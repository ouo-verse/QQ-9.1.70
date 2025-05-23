package com.tencent.mobileqq.app.qim;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends ReportDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    List<QIMNotifyAddFriend> C;
    QIMNewFriendManager D;
    FlashChatManager E;
    int F;
    public View G;

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Button button = (Button) getWindow().findViewById(R.id.b7m);
        button.setOnClickListener(this);
        button.setText("OK\uff08" + this.C.size() + "\uff09");
        button.setEnabled(this.C.isEmpty() ^ true);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, compoundButton, Boolean.valueOf(z16));
        } else {
            Object tag = compoundButton.getTag();
            if (tag instanceof QIMNotifyAddFriend) {
                QIMNotifyAddFriend qIMNotifyAddFriend = (QIMNotifyAddFriend) tag;
                if (z16) {
                    if (!this.C.contains(qIMNotifyAddFriend)) {
                        this.C.add(qIMNotifyAddFriend);
                    }
                } else if (this.C.contains(qIMNotifyAddFriend)) {
                    this.C.remove(qIMNotifyAddFriend);
                }
            }
            N();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.b7m) {
                dismiss();
                ((FriendListHandler) ((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addBatchQIMFriends(this.C);
                this.E.d(getContext(), null);
                this.D.g(this.C);
                int i3 = this.F;
                if (i3 == 1) {
                    ReportController.o(null, "dc00898", "", "", "0X8008A9F", "0X8008A9F", 0, 0, "", "", "", "");
                } else if (i3 == 2) {
                    ReportController.o(null, "dc00898", "", "", "0X8008AA2", "0X8008AA2", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.close) {
                int i16 = this.F;
                if (i16 == 1) {
                    ReportController.o(null, "dc00898", "", "", "0X8008AA0", "0X8008AA0", 0, 0, "", "", "", "");
                } else if (i16 == 2) {
                    ReportController.o(null, "dc00898", "", "", "0X8008AA3", "0X8008AA3", 0, 0, "", "", "", "");
                }
                dismiss();
            } else if (id5 == R.id.e3f) {
                dismiss();
            } else if (this.G == view || view == getWindow().getDecorView()) {
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
