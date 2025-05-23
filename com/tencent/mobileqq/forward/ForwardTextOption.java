package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.cw;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardTextOption extends ForwardBaseOption implements al {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardTextOption.this);
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
                QQCustomDialog qQCustomDialog = ForwardTextOption.this.mConfirmDialog;
                if (qQCustomDialog != null) {
                    qQCustomDialog.hideSoftInputFromWindow();
                    List<AIOMsgItem> h16 = com.tencent.qqnt.aio.forward.l.e().h();
                    if (com.tencent.qqnt.aio.forward.l.e().d() == null && (h16 == null || h16.isEmpty())) {
                        o oVar = new o(ForwardTextOption.this.mConfirmDialog);
                        oVar.m(ForwardTextOption.this.mActivity.getString(R.string.bc8), ForwardTextOption.this.mForwardText);
                        ForwardTextOption.this.mConfirmDialog.addPreviewView(oVar.c());
                    } else {
                        QQCustomDialog qQCustomDialog2 = ForwardTextOption.this.mConfirmDialog;
                        if (qQCustomDialog2 instanceof cw) {
                            z16 = ((cw) qQCustomDialog2).X();
                        } else {
                            z16 = false;
                        }
                        ForwardTextOption.this.mIntent.putExtra(AppConstants.Key.FORWARD_ACTIVITY_BG, z16);
                        ForwardTextOption forwardTextOption = ForwardTextOption.this;
                        NtMsgForwardUtils.q(forwardTextOption.mActivity, forwardTextOption.mIntent);
                        NTChatHistoryMsgForwardSingleton nTChatHistoryMsgForwardSingleton = NTChatHistoryMsgForwardSingleton.INSTANCE;
                        ForwardTextOption forwardTextOption2 = ForwardTextOption.this;
                        nTChatHistoryMsgForwardSingleton.previewForwardMsg(forwardTextOption2.mActivity, forwardTextOption2.mIntent);
                    }
                    ForwardTextOption.this.reportClickContentAction();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ForwardTextOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.mSurpportTroopDiscussionTmpConv = true;
            this.mForwardReportType = 3;
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.adjustDialogProperty();
        this.mConfirmDialog.adjustMessageBottomMargin(17.0f);
        this.mConfirmDialog.setMessageTextColor(R.color.f157116k8);
        this.mConfirmDialog.setMessageTextSize(14.0f);
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
        super.buildForwardAbility();
        if (this.mIntent.getBooleanExtra("k_dataline", true)) {
            this.mForwardAbilities.add(e.S3);
            this.mForwardAbilities.add(e.X3);
            this.mForwardAbilities.add(e.f211017e4);
        }
        if (this.mIntent.getBooleanExtra("k_smartdevice", true) && allowSmartDeviceAbility()) {
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
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        AnimationTextView animationTextView = new AnimationTextView(this.mActivity);
        String dialogContent = getDialogContent();
        if (dialogContent == null) {
            dialogContent = "";
        }
        QQText qQText = new QQText(dialogContent, 5, 16);
        animationTextView.setText(qQText);
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
        if (AppSetting.f99565y) {
            view.setContentDescription(qQText.toPlainText(4));
        }
        view.setOnClickListener(new a());
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        int dip2px = ViewUtils.dip2px(20.0f);
        frameLayout.setPadding(0, dip2px, 0, dip2px);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 16));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        SharePublishGuildFeedParam.LinkTypeParam fromBundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (TextUtils.isEmpty(this.mForwardText)) {
            return null;
        }
        Bundle extras = this.mIntent.getExtras();
        if (extras != null && extras.getBoolean(AppConstants.Key.GUILD_SHARE_TEXT_WITH_COMPATIBLE_H5_CARD, false) && (fromBundle = SharePublishGuildFeedParam.LinkTypeParam.fromBundle(extras)) != null) {
            return fromBundle;
        }
        return new SharePublishGuildFeedParam.TextTypeParam(this.mForwardText);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() != 1008 && recentUser.getType() != 1021 && recentUser.getType() != 10004 && recentUser.getType() != 7000 && recentUser.getType() != 6004 && recentUser.getType() != 6002 && (recentUser.getType() != 1 || !isHotChat(recentUser.uin))) {
                if (recentUser.getType() != 1006 || isSupportAbility(e.U3)) {
                    if (recentUser.getType() != 9501 && (recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType()))) {
                        if ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || this.mSurpportTroopDiscussionTmpConv) {
                            arrayList.add(recentUser);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onPause();
            AbstractGifImage.pauseAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onResume();
            AbstractGifImage.resumeAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        SpannableString spannableString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        if (this.mForwardText == null && (spannableString = (SpannableString) this.mExtraData.get(AppConstants.Key.FORWARD_TEXT)) != null) {
            this.mForwardText = spannableString.toString();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        Intent m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.mFromSharePanelPreviewAndSend) {
            Intent intent = new Intent();
            this.mExtraData.putString(AppConstants.Key.FORWARD_TEXT, this.mForwardText);
            intent.putExtras(this.mExtraData);
            ForwardUtils.w(this.app, this.mActivity, this.mAppContext, intent, null);
            return false;
        }
        if (isMultiTarget2Send()) {
            Intent m16 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
            if (this.mIntent.getBooleanExtra("isFromShare", false)) {
                this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mrh));
                m16.addFlags(268435456);
                m16.addFlags(67108864);
                this.mExtraData.putString(AppConstants.Key.FORWARD_TEXT, this.mForwardText);
                m16.putExtras(this.mExtraData);
                boolean handleForwardFromFavorite = handleForwardFromFavorite(m16);
                if (this.isFormJump) {
                    ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m16, null);
                } else if (!handleForwardFromFavorite) {
                    ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m16, null);
                }
            }
            this.mExtraData.putBoolean("isBack2Root", false);
            m16.putExtras(this.mExtraData);
            this.mActivity.setResult(-1, m16);
            return false;
        }
        int i3 = this.mExtraData.getInt("uintype");
        String string = this.mExtraData.getString("uin");
        if (i3 == 1008) {
            m3 = new Intent(this.mActivity, (Class<?>) ChatActivity.class);
            m3.putExtra("chat_subType", ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(string, this.app));
        } else {
            m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
        }
        if (this.mIntent.getBooleanExtra("isFromShare", false)) {
            this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mrc));
            m3.addFlags(268435456);
            m3.addFlags(67108864);
            this.mExtraData.putString(AppConstants.Key.FORWARD_TEXT, this.mForwardText);
            m3.putExtras(this.mExtraData);
            boolean handleForwardFromFavorite2 = handleForwardFromFavorite(m3);
            if (this.isFormJump) {
                this.mActivity.startActivity(m3);
            } else if (!handleForwardFromFavorite2) {
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
            }
        }
        this.mExtraData.putBoolean("isBack2Root", false);
        m3.putExtras(this.mExtraData);
        this.mActivity.setResult(-1, m3);
        this.mActivity.finish();
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected int realShareToQfav() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = -1;
        if (QfavBuilder.k0(null, this.mForwardText).C(this.app).e(this.mActivity, this.app.getAccount(), -1, null)) {
            i3 = 0;
        }
        int i16 = i3;
        if (i16 == 0) {
            cooperation.qqfav.d.d(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineSingle(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            intent.putExtra("dataline_forward_type", 102);
            intent.putExtra("dataline_forward_text", this.mForwardText);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }
}
