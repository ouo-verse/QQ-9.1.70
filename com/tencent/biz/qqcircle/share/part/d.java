package com.tencent.biz.qqcircle.share.part;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSFriendDialogInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSQQFriendsSelectChangedEvent;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends Part implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private Dialog f92428d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f92429e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f92430f;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<com.tencent.mobileqq.multishare.action.c> f92431h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<com.tencent.mobileqq.multishare.action.c> f92432i;

    /* renamed from: m, reason: collision with root package name */
    private QFSFriendDialogInitBean f92433m;

    public d(QFSFriendDialogInitBean qFSFriendDialogInitBean) {
        ArrayList<com.tencent.mobileqq.multishare.action.c> arrayList = new ArrayList<>();
        this.f92432i = arrayList;
        this.f92433m = qFSFriendDialogInitBean;
        arrayList.clear();
        arrayList.addAll(z9());
        QLog.d("QFSQQFriendsTitlePart", 1, "[QFSQQFriendsTitlePart] mOriginSelectedUserList size =" + RFSafeListUtils.getSize(arrayList));
    }

    private void A9(View view) {
        this.f92430f = (TextView) view.findViewById(R.id.f5142282);
        this.f92429e = (ImageView) view.findViewById(R.id.f5141281);
        this.f92430f.setOnClickListener(this);
        this.f92429e.setOnClickListener(this);
    }

    private void B9() {
        QFSFriendDialogInitBean qFSFriendDialogInitBean = this.f92433m;
        if (qFSFriendDialogInitBean != null && qFSFriendDialogInitBean.getShareInfo() != null) {
            QCircleShareInfo shareInfo = this.f92433m.getShareInfo();
            shareInfo.mSelectedUserList.clear();
            shareInfo.mSelectedUserList.addAll(this.f92432i);
            QLog.d("QFSQQFriendsTitlePart", 1, "[openSelectedFragment] mOriginSelectedUserList size =" + RFSafeListUtils.getSize(this.f92432i));
            broadcastMessage("share_action_show_share_sheet", shareInfo);
            return;
        }
        QLog.e("QFSQQFriendsTitlePart", 1, "[openMultiShareFragment] mInitBean is null");
    }

    private void C9() {
        QFSFriendDialogInitBean qFSFriendDialogInitBean = this.f92433m;
        if (qFSFriendDialogInitBean != null && qFSFriendDialogInitBean.getShareInfo() != null) {
            QCircleShareInfo shareInfo = this.f92433m.getShareInfo();
            shareInfo.mSelectedUserList.clear();
            shareInfo.mSelectedUserList.addAll(this.f92431h);
            QLog.d("QFSQQFriendsTitlePart", 1, "[openSelectedFragment] mSelectedUserList size =" + this.f92431h.size());
            broadcastMessage("share_action_show_share_sheet", shareInfo);
            return;
        }
        QLog.e("QFSQQFriendsTitlePart", 1, "[openSelectedFragment] mInitBean is null");
    }

    private void D9(QFSQQFriendsSelectChangedEvent qFSQQFriendsSelectChangedEvent) {
        String a16;
        boolean z16 = true;
        if (this.f92430f == null) {
            QLog.e("QFSQQFriendsTitlePart", 1, "[updateTvComplete] mTvComplete is null");
            return;
        }
        int finalSelectedSize = qFSQQFriendsSelectChangedEvent.getFinalSelectedSize();
        TextView textView = this.f92430f;
        if (finalSelectedSize > 0) {
            a16 = RFWApplication.getApplication().getString(R.string.f188323wd, Integer.valueOf(finalSelectedSize));
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1933249w);
        }
        textView.setText(a16);
        TextView textView2 = this.f92430f;
        if (finalSelectedSize <= 0) {
            z16 = false;
        }
        textView2.setEnabled(z16);
        this.f92431h.clear();
        this.f92431h.addAll(qFSQQFriendsSelectChangedEvent.getFinalSelectedUserList());
    }

    private void x9() {
        Dialog dialog = this.f92428d;
        if (dialog == null) {
            QLog.e("QFSQQFriendsTitlePart", 1, "[dismissDialogFragment] mDialogFragment is null");
        } else {
            dialog.dismiss();
        }
    }

    private ArrayList<com.tencent.mobileqq.multishare.action.c> z9() {
        ArrayList<com.tencent.mobileqq.multishare.action.c> arrayList = new ArrayList<>();
        QFSFriendDialogInitBean qFSFriendDialogInitBean = this.f92433m;
        if (qFSFriendDialogInitBean != null && qFSFriendDialogInitBean.getShareInfo() != null && !RFSafeListUtils.isEmpty(this.f92433m.getShareInfo().mSelectedUserList)) {
            return this.f92433m.getShareInfo().mSelectedUserList;
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSQQFriendsSelectChangedEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f5141281) {
            x9();
            B9();
        } else if (id5 == R.id.f5142282 && !FastClickUtils.isFastDoubleClick("QFSQQFriendsTitlePart")) {
            x9();
            C9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (getPartHost() instanceof DialogFragment) {
            this.f92428d = ((DialogFragment) getPartHost()).getDialog();
        }
        A9(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSQQFriendsSelectChangedEvent) {
            D9((QFSQQFriendsSelectChangedEvent) simpleBaseEvent);
        }
    }
}
