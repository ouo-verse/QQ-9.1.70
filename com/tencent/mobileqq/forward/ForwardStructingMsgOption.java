package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.cw;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardStructingMsgOption extends ForwardBaseOption implements al {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    AbsShareMsg f210903d;

    /* renamed from: e, reason: collision with root package name */
    boolean f210904e;

    /* renamed from: f, reason: collision with root package name */
    String f210905f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f210906h;

    /* renamed from: i, reason: collision with root package name */
    private URLDrawableDownListener.Adapter f210907i;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardStructingMsgOption.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            super.onLoadCancelled(view, uRLDrawable);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "onLoadCancelled");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
                return;
            }
            super.onLoadFailed(view, uRLDrawable, th5);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "onLoadFailed ,cause = " + th5);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, interruptedException);
                return;
            }
            super.onLoadInterrupted(view, uRLDrawable, interruptedException);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "onLoadInterrupted");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            if (view == null) {
                return;
            }
            view.setBackgroundDrawable(null);
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(uRLDrawable);
                view.requestLayout();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "onLoadSuccessed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardStructingMsgOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardStructingMsgOption.this.r();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardStructingMsgOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQCustomDialog qQCustomDialog = ForwardStructingMsgOption.this.mConfirmDialog;
                if (qQCustomDialog != null) {
                    qQCustomDialog.hideSoftInputFromWindow();
                    QQCustomDialog qQCustomDialog2 = ForwardStructingMsgOption.this.mConfirmDialog;
                    if (qQCustomDialog2 instanceof cw) {
                        z16 = ((cw) qQCustomDialog2).X();
                    } else {
                        z16 = false;
                    }
                    ForwardStructingMsgOption.this.mIntent.putExtra(AppConstants.Key.FORWARD_ACTIVITY_BG, z16);
                    ForwardStructingMsgOption forwardStructingMsgOption = ForwardStructingMsgOption.this;
                    NtMsgForwardUtils.q(forwardStructingMsgOption.mActivity, forwardStructingMsgOption.mIntent);
                    NTChatHistoryMsgForwardSingleton nTChatHistoryMsgForwardSingleton = NTChatHistoryMsgForwardSingleton.INSTANCE;
                    ForwardStructingMsgOption forwardStructingMsgOption2 = ForwardStructingMsgOption.this;
                    nTChatHistoryMsgForwardSingleton.previewForwardMsg(forwardStructingMsgOption2.mActivity, forwardStructingMsgOption2.mIntent);
                    ForwardStructingMsgOption.this.reportClickContentAction();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ForwardStructingMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210904e = false;
        this.f210905f = "";
        this.f210907i = new a();
    }

    private void m(QQCustomDialog qQCustomDialog) {
        qQCustomDialog.setBodyLayoutNoMargin();
        URLImageView uRLImageView = new URLImageView(this.mActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(152.0f, this.mActivity.getResources()));
        int i3 = this.f210903d.mMsgServiceID;
        if (i3 == 114 || i3 == 116) {
            layoutParams.leftMargin = BaseAIOUtils.f(24.0f, this.mActivity.getResources());
            layoutParams.rightMargin = BaseAIOUtils.f(24.0f, this.mActivity.getResources());
        }
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setBackgroundColor(Color.parseColor("#dcdfe4"));
        String a16 = com.tencent.mobileqq.adapter.g.a(this.f210903d, "cover");
        Drawable drawable = this.mActivity.getResources().getDrawable(R.drawable.h2r);
        if (!TextUtils.isEmpty(a16)) {
            URLDrawable drawable2 = URLDrawable.getDrawable(a16, -1, BaseAIOUtils.f(165.0f, this.mActivity.getResources()), drawable, drawable, true);
            uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if (drawable2 != null && drawable2.getStatus() == 2) {
                drawable2.restartDownload();
            }
            if (drawable2 != null && drawable2.getStatus() == 1) {
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                uRLImageView.setBackgroundDrawable(null);
            } else {
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                uRLImageView.setURLDrawableDownListener(this.f210907i);
            }
            uRLImageView.setImageDrawable(drawable2);
        } else {
            uRLImageView.setImageDrawable(drawable);
            uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        qQCustomDialog.addView(uRLImageView, layoutParams);
        String a17 = com.tencent.mobileqq.adapter.g.a(this.f210903d, "title");
        TextView textView = new TextView(this.mActivity);
        textView.setText(a17);
        textView.setTextSize(16.0f);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-16777216);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(BaseAIOUtils.f(24.0f, this.mActivity.getResources()), BaseAIOUtils.f(8.0f, this.mActivity.getResources()), BaseAIOUtils.f(24.0f, this.mActivity.getResources()), BaseAIOUtils.f(20.0f, this.mActivity.getResources()));
        qQCustomDialog.addView(textView);
    }

    private View n() {
        boolean z16;
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        linearLayout.addView(this.f210903d.getPreDialogView(this.mActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0f));
        AbsShareMsg absShareMsg = this.f210903d;
        if (absShareMsg.mMsgServiceID == 32 || TextUtils.isEmpty(absShareMsg.mMsgUrl)) {
            z16 = false;
        } else {
            z16 = true;
        }
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (z16) {
            ImageView imageView = new ImageView(this.mActivity);
            imageView.setImageResource(R.drawable.forward_dialog_file_arrow_normal);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0f), ViewUtils.dip2px(14.0f));
            layoutParams.setMargins(ViewUtils.dip2px(7.0f), 0, 0, 0);
            layoutParams.gravity = 16;
            SimpleModeHelper.s(null, imageView, layoutParams);
            linearLayout.addView(imageView, layoutParams);
            View view = new View(this.mActivity);
            SimpleModeHelper.q(view);
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(33.0f), 16));
            view.setOnClickListener(new b());
            view.setContentDescription(HardCodeUtil.qqStr(R.string.mq_));
        }
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private View o() {
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        AnimationTextView animationTextView = new AnimationTextView(this.mActivity);
        String dialogContent = getDialogContent();
        if (dialogContent == null) {
            dialogContent = "";
        }
        animationTextView.setText(new QQText(dialogContent, 5, 16));
        animationTextView.setMaxLines(2);
        animationTextView.setEllipsize(TextUtils.TruncateAt.END);
        animationTextView.setTextColor(this.mActivity.getResources().getColorStateList(R.color.f157084jf));
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
        view.setId(R.id.lim);
        SimpleModeHelper.q(view);
        view.setContentDescription(this.mActivity.getString(R.string.bc8));
        view.setOnClickListener(new c());
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        int dip2px = ViewUtils.dip2px(20.0f);
        frameLayout.setPadding(0, dip2px, 0, dip2px);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 16));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    private boolean p(AbsStructMsg absStructMsg) {
        List<AbsStructMsgElement> structMsgItemLists;
        if ((absStructMsg instanceof StructMsgForGeneralShare) && (structMsgItemLists = ((StructMsgForGeneralShare) absStructMsg).getStructMsgItemLists()) != null) {
            for (int i3 = 0; i3 < structMsgItemLists.size(); i3++) {
                AbsStructMsgElement absStructMsgElement = structMsgItemLists.get(i3);
                if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.u) {
                    int i16 = ((com.tencent.mobileqq.structmsg.view.u) absStructMsgElement).R0;
                    if (i16 == 1 || i16 == 3) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean q(AbsShareMsg absShareMsg) {
        List<AbsStructMsgElement> structMsgItemLists;
        if ((absShareMsg instanceof StructMsgForGeneralShare) && (structMsgItemLists = ((StructMsgForGeneralShare) absShareMsg).getStructMsgItemLists()) != null) {
            for (int i3 = 0; i3 < structMsgItemLists.size(); i3++) {
                AbsStructMsgElement absStructMsgElement = structMsgItemLists.get(i3);
                if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.y) {
                    ArrayList<AbsStructMsgElement> arrayList = ((com.tencent.mobileqq.structmsg.view.y) absStructMsgElement).U0;
                    if (arrayList != null) {
                        for (int i16 = 0; i16 < arrayList.size(); i16++) {
                            AbsStructMsgElement absStructMsgElement2 = arrayList.get(i16);
                            if ((absStructMsgElement2 instanceof StructMsgItemVideo) && !((StructMsgItemVideo) absStructMsgElement2).v()) {
                                return true;
                            }
                        }
                    } else {
                        continue;
                    }
                } else if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.u) {
                    int i17 = ((com.tencent.mobileqq.structmsg.view.u) absStructMsgElement).R0;
                    if (i17 == 1 || i17 == 3) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!TextUtils.isEmpty(this.f210903d.mMsgUrl)) {
            String trim = this.f210903d.mMsgUrl.trim();
            if (QLog.isColorLevel()) {
                QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "gotoWeb " + trim);
            }
            if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(trim)) {
                Bundle bundle = new Bundle();
                bundle.putString("url", trim);
                bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_FROM_FORWARD_DIALOG, true);
                TeamWorkDocEditBrowserActivity.openTeamWorkDocEditBrowserActivity(this.mActivity, bundle, false);
            } else {
                Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserDelegationActivity.class);
                intent.putExtra("param_force_internal_browser", true);
                intent.putExtra("reqType", 7);
                intent.putExtra(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
                intent.putExtra("hide_more_button", true);
                intent.putExtra("url", trim);
                WebAccelerator.s(this.mActivity, intent, trim);
            }
            reportClickContentAction();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "empty url");
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        AbsShareMsg absShareMsg = this.f210903d;
        if (absShareMsg != null) {
            boolean q16 = q(absShareMsg);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            AbsShareMsg absShareMsg2 = this.f210903d;
            boolean z17 = false;
            if (absShareMsg2 instanceof StructMsgForGeneralShare) {
                if (!q16 && absShareMsg2.mMsgServiceID != 97) {
                    layoutParams.setMargins(BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), BaseAIOUtils.f(5.0f, this.mActivity.getResources()));
                }
            } else if (absShareMsg2 instanceof StructMsgForAudioShare) {
                layoutParams.setMargins(0, BaseAIOUtils.f(5.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(10.0f, this.mActivity.getResources()));
            } else if (absShareMsg2 instanceof StructMsgForImageShare) {
                layoutParams.setMargins(BaseAIOUtils.f(-10.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-7.5f, this.mActivity.getResources()), 0);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "updateImageView addStructView");
            }
            if (this.f210904e) {
                m(qQCustomDialog);
                return false;
            }
            qQCustomDialog.addView(this.f210903d.getPreDialogView(this.mActivity, null), layoutParams);
            if (!(this.f210903d instanceof StructMsgForImageShare) && !q16 && this.mIntent.getBooleanExtra("is_need_show_sources", true)) {
                z16 = true;
            } else {
                z16 = false;
            }
            AbsShareMsg absShareMsg3 = this.f210903d;
            if (absShareMsg3.mMsgServiceID != 35) {
                z17 = z16;
            }
            if (z17) {
                addSourceNameView(absShareMsg3.mSourceName, qQCustomDialog);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.adjustDialogProperty();
        this.mConfirmDialog.adjustMessageBottomMargin(17.0f);
        this.mConfirmDialog.setMessageTextColor(R.color.f157116k8);
        this.mConfirmDialog.setMessageTextSize(14.0f);
        AbsShareMsg absShareMsg = this.f210903d;
        if (absShareMsg != null && absShareMsg.mMsgServiceID == 97) {
            ViewGroup.LayoutParams layoutParams = ((LinearLayout) this.mConfirmDialog.findViewById(R.id.abb)).getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            }
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
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
        if (this.mIntent.getBooleanExtra("k_smartdevice", true) && super.allowSmartDeviceAbility()) {
            this.mForwardAbilities.add(e.W3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.f210906h) {
            return o();
        }
        AbsShareMsg absShareMsg = this.f210903d;
        if (absShareMsg == null) {
            return null;
        }
        int i3 = absShareMsg.mMsgServiceID;
        if (i3 == 33) {
            return n();
        }
        if (i3 == 95) {
            return n();
        }
        return n();
    }

    @Override // com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return GuildForwardUtilKt.g(this.mExtraData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.forwardOnCancel();
            ReportController.o(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mExtraData.getInt("uintype") == 10014) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = "";
        if (z16) {
            if (getEditTextType() != 0) {
                str = this.mConfirmDialog.getInputValue();
            }
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), new int[]{2});
            this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
            m3.putExtras(this.mExtraData);
            SessionInfo n06 = ForwardUtils.n0(m3);
            this.mIntent.putExtra("is_need_show_toast", false);
            this.mNeedInterrupFinishActivity = true;
            ForwardPluginShareWebViewHelper.d(this.app, this.mActivity, n06, m3, this.f210903d);
            super.forwardOnConfirm();
            return;
        }
        int intExtra = this.mIntent.getIntExtra(AppConstants.Key.STRUCT_MSG_SERVICE_ID, -1);
        ReportController.o(this.app, "CliOper", "", "", "0X800567B", "0X800567B", 0, 0, intExtra + "", "", "", "");
        ReportController.o(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
        jq3.a.f(this.app, this.appid, this.mIntent, this.f210903d);
        if (getEditTextType() != 0) {
            str = this.mConfirmDialog.getInputValue();
        }
        this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
        super.forwardOnConfirm();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean needSendMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        this.f210906h = this.mExtraData.getBoolean(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG);
        AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(this.mExtraData.getByteArray(AppConstants.Key.STRUCT_MSG_BYTES));
        if (d16 != null && (d16 instanceof AbsShareMsg)) {
            this.f210903d = (AbsShareMsg) d16;
        }
        AbsShareMsg absShareMsg = this.f210903d;
        if (absShareMsg != null) {
            int i3 = absShareMsg.mMsgServiceID;
            if (i3 != 83 && i3 != 108 && i3 != 114 && i3 != 116 && i3 != 151 && i3 != 156) {
                if (absShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com") || this.f210903d.mMsgUrl.startsWith("https://article.mp.qq.com") || this.f210903d.mMsgUrl.startsWith("http://post.mp.qq.com") || this.f210903d.mMsgUrl.startsWith("https://post.mp.qq.com")) {
                    this.mExtraData.putInt("emoInputType", 2);
                }
            } else {
                this.f210904e = true;
                this.mExtraData.putInt("emoInputType", 3);
            }
            try {
                this.f210905f = Uri.parse(this.f210903d.mMsgUrl).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (this.f210905f == null) {
                this.f210905f = "";
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Intent intent = new Intent();
        intent.putExtras(this.mExtraData);
        this.mExtraData.putBoolean("isBack2Root", false);
        if (QLog.isColorLevel() && this.f210903d != null) {
            QLog.d("forward", 2, "ForwardStructingMsgOption realForwardTo  mShareMsg.mMsgServiceID=" + this.f210903d.mMsgServiceID);
        }
        if (isMultiTarget2Send()) {
            List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
            if (this.f210903d instanceof StructMsgForImageShare) {
                for (ResultRecord resultRecord : multiTargetWithoutDataLine) {
                    StructMsgForImageShare.sendAndUploadImageShare(this.app, (StructMsgForImageShare) this.f210903d, resultRecord.uin, resultRecord.getUinType(), null, 0);
                }
                if (!this.mExtraData.getBoolean("k_back", true)) {
                    Intent m3 = BaseAIOUtils.m(new Intent(this.mActivity, (Class<?>) ChatActivity.class), null);
                    m3.putExtras(this.mExtraData);
                    this.mActivity.startActivity(m3);
                }
            }
            AbsShareMsg absShareMsg = this.f210903d;
            if (absShareMsg != null && ((i16 = absShareMsg.mMsgServiceID) == 32 || i16 == 97)) {
                for (ResultRecord resultRecord2 : multiTargetWithoutDataLine) {
                    ForwardUtils.p(this.app, this.mAppContext, ForwardUtils.o0(intent, resultRecord2.uin, resultRecord2.getUinType(), resultRecord2.groupUin), intent);
                }
                if (this.f210903d.mMsgServiceID == 97) {
                    return false;
                }
            }
            if (this.mExtraData.getBoolean("forwardDirect", false)) {
                Activity activity = this.mActivity;
                if (activity instanceof AppActivity) {
                    QQAppInterface qQAppInterface = (QQAppInterface) ((AppActivity) activity).getAppRuntime();
                    Activity activity2 = this.mActivity;
                    ForwardUtils.w(qQAppInterface, activity2, activity2.getApplicationContext(), intent, null);
                }
            }
        } else {
            AbsShareMsg absShareMsg2 = this.f210903d;
            if (absShareMsg2 instanceof StructMsgForImageShare) {
                StructMsgForImageShare.sendAndUploadImageShare(this.app, (StructMsgForImageShare) absShareMsg2, this.mExtraData.getString("uin"), this.mExtraData.getInt("uintype"), null, 0);
                if (!this.mExtraData.getBoolean("k_back", true)) {
                    Intent m16 = BaseAIOUtils.m(new Intent(this.mActivity, (Class<?>) ChatActivity.class), null);
                    m16.putExtras(this.mExtraData);
                    this.mActivity.startActivity(m16);
                }
            }
            AbsShareMsg absShareMsg3 = this.f210903d;
            if (absShareMsg3 != null && ((i3 = absShareMsg3.mMsgServiceID) == 32 || i3 == 97 || i3 == 145 || i3 == 155)) {
                ForwardUtils.p(this.app, this.mAppContext, ForwardUtils.n0(intent), intent);
                if (this.f210903d.mMsgServiceID == 97) {
                    return false;
                }
            }
            if (this.mExtraData.getBoolean("forwardDirect", false)) {
                Activity activity3 = this.mActivity;
                if (activity3 instanceof AppActivity) {
                    QQAppInterface qQAppInterface2 = (QQAppInterface) ((AppActivity) activity3).getAppRuntime();
                    Activity activity4 = this.mActivity;
                    ForwardUtils.w(qQAppInterface2, activity4, activity4.getApplicationContext(), intent, null);
                }
            }
        }
        intent.putExtra("uin", this.mExtraData.getString("uin", ""));
        intent.putExtra("uintype", this.mExtraData.getInt("uintype", 0));
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (cooperation.qqfav.QfavBuilder.e0(r1.R0).C(r27.app).e(r27.mActivity, r27.app.getAccount(), -1, null) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fa, code lost:
    
        if (cooperation.qqfav.QfavBuilder.b0(java.lang.Float.valueOf(r9).floatValue(), java.lang.Float.valueOf(r10).floatValue(), r12, r11, null).C(r27.app).e(r27.mActivity, r27.app.getAccount(), -1, null) != false) goto L14;
     */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int realShareToQfav() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        AbsShareMsg absShareMsg = this.f210903d;
        int i17 = -1;
        if (absShareMsg instanceof StructMsgForImageShare) {
            com.tencent.mobileqq.structmsg.view.e s16 = QfavUtil.s((StructMsgForImageShare) absShareMsg);
            if (s16 != null) {
            }
            i16 = i17;
        } else {
            if (!TextUtils.isEmpty(absShareMsg.mMsgActionData)) {
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                for (String str5 : this.f210903d.mMsgActionData.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split = str5.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length > 1) {
                        if (split[0].trim().equals(QCircleSchemeAttr.Polymerize.LAT)) {
                            str = split[1];
                        } else if (split[0].trim().equals("lon")) {
                            str2 = split[1];
                        } else if (split[0].trim().equals("loc")) {
                            str3 = split[1];
                        } else if (split[0].trim().equals("title")) {
                            str4 = split[1];
                        }
                    }
                }
                if (this.f210903d.mMsgServiceID == 32) {
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (!TextUtils.isEmpty(str3)) {
                            }
                        }
                    }
                }
            } else {
                byte[] g16 = QfavUtil.g(this.f210903d.getXmlBytes());
                AbsShareMsg absShareMsg2 = this.f210903d;
                if (absShareMsg2 instanceof StructMsgForAudioShare) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                if (QfavBuilder.Z(i3, absShareMsg2.mContentTitle, absShareMsg2.mMsgUrl, absShareMsg2.mSourceName, absShareMsg2.mContentSummary, absShareMsg2.mContentCover, absShareMsg2.mContentSrc, g16, false, 0L).C(this.app).e(this.mActivity, this.app.getAccount(), -1, null)) {
                    i16 = 0;
                }
            }
            i16 = i17;
        }
        if (i16 == 0) {
            cooperation.qqfav.d.d(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.f210906h) {
            return true;
        }
        if (this.f210903d == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "msgId = " + this.f210903d.mMsgServiceID);
        }
        AbsShareMsg absShareMsg = this.f210903d;
        int i3 = absShareMsg.mMsgServiceID;
        if (i3 == 35) {
            return true;
        }
        if (i3 == 33) {
            this.mForwardReportType = 8;
            return true;
        }
        if (i3 == 95) {
            this.mForwardReportType = 9;
            return true;
        }
        if (absShareMsg.mMsgUrl == null || !p(absShareMsg)) {
            return false;
        }
        this.mForwardReportType = 8;
        return true;
    }
}
