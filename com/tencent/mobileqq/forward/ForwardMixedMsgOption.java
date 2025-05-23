package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardMixedMsgOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected MessageForMixedMsg f210684d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardMixedMsgOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQCustomDialog qQCustomDialog = ForwardMixedMsgOption.this.mConfirmDialog;
                if (qQCustomDialog != null) {
                    qQCustomDialog.hideSoftInputFromWindow();
                    ForwardMixedMsgOption forwardMixedMsgOption = ForwardMixedMsgOption.this;
                    n nVar = new n(forwardMixedMsgOption.mConfirmDialog, forwardMixedMsgOption.app);
                    if (com.tencent.qqnt.aio.forward.l.e().d() != null) {
                        nVar.l(ForwardMixedMsgOption.this.mActivity.getString(R.string.bc8), com.tencent.qqnt.aio.forward.l.e().d());
                    }
                    ForwardMixedMsgOption.this.mConfirmDialog.addPreviewView(nVar.c());
                    ForwardMixedMsgOption.this.reportClickContentAction();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ForwardMixedMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        AnimationTextView animationTextView = new AnimationTextView(this.mActivity);
        animationTextView.setText(new QQText(getDialogContent(), 5, 16));
        animationTextView.setMaxLines(2);
        animationTextView.setEllipsize(TextUtils.TruncateAt.END);
        animationTextView.setTextColor(this.mActivity.getResources().getColorStateList(R.color.f157116k8));
        animationTextView.setTextSize(14.0f);
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setImageResource(R.drawable.forward_dialog_file_arrow_normal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 17;
        linearLayout.addView(animationTextView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0f), ViewUtils.dip2px(14.0f));
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(ViewUtils.dip2px(3.0f), 0, 0, 0);
        SimpleModeHelper.s(animationTextView, imageView, layoutParams2);
        linearLayout.addView(imageView, layoutParams2);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        View view = new View(this.mActivity);
        SimpleModeHelper.q(view);
        view.setOnClickListener(new a());
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        int dip2px = ViewUtils.dip2px(20.0f);
        frameLayout.setPadding(0, dip2px, 0, dip2px);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 16));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        MessageForMixedMsg messageForMixedMsg = this.f210684d;
        if (messageForMixedMsg != null) {
            return MessageForMixedMsg.getTextFromMixedMsgForForwardPreview(messageForMixedMsg);
        }
        return super.getDialogContent();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            AbstractGifImage.pauseAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            AbstractGifImage.resumeAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        long j3 = this.mExtraData.getLong(AppConstants.Key.FORWARD_UNISEQ, -1L);
        if (j3 != -1) {
            ChatMessage chatMessage = ((MixedMsgManager) this.app.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).f247173e.get(Long.valueOf(j3));
            if (chatMessage != null) {
                if (chatMessage instanceof MessageForMixedMsg) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForMixedMsg");
                    }
                    this.f210684d = (MessageForMixedMsg) chatMessage;
                    return true;
                }
                if (chatMessage instanceof MessageForLongMsg) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "MessageForLongMsg");
                    }
                    try {
                        MessageRecord rebuildLongMsg = ((MessageForLongMsg) chatMessage).rebuildLongMsg();
                        if (rebuildLongMsg instanceof MessageForMixedMsg) {
                            this.f210684d = (MessageForMixedMsg) rebuildLongMsg;
                            return true;
                        }
                        return true;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "rebuildLongMsg error :" + e16.toString());
                            return true;
                        }
                        return true;
                    }
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg: " + j3);
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }
}
