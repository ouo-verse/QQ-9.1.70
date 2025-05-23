package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.forward.dialog.ForwardDialog;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class ForwardPluginShareStructMsgOption extends ForwardBaseOption implements al {
    static IPatchRedirector $redirector_;
    private static final int[] D;
    private URLDrawableDownListener.Adapter C;

    /* renamed from: d, reason: collision with root package name */
    AbsShareMsg f210730d;

    /* renamed from: e, reason: collision with root package name */
    boolean f210731e;

    /* renamed from: f, reason: collision with root package name */
    int f210732f;

    /* renamed from: h, reason: collision with root package name */
    String f210733h;

    /* renamed from: i, reason: collision with root package name */
    String f210734i;

    /* renamed from: m, reason: collision with root package name */
    int f210735m;

    /* loaded from: classes12.dex */
    class a extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPluginShareStructMsgOption.this);
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
                QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadCancelled");
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
                QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadFailed ,cause = " + th5);
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
                QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadInterrupted");
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
                QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadSuccessed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPluginShareStructMsgOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardPluginShareStructMsgOption.this.r();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72125);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            D = new int[]{1020, 1008, 1005, 1009, 1021, 1001, 10002, 10004, 1022, 7000, 6004, 9501};
        }
    }

    public ForwardPluginShareStructMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210731e = false;
        this.f210734i = "";
        this.C = new a();
    }

    private void m(QQCustomDialog qQCustomDialog) {
        qQCustomDialog.setBodyLayoutNoMargin();
        URLImageView uRLImageView = new URLImageView(this.mActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(152.0f, this.mActivity.getResources()));
        int i3 = this.f210730d.mMsgServiceID;
        if (i3 == 114 || i3 == 116) {
            layoutParams.leftMargin = BaseAIOUtils.f(24.0f, this.mActivity.getResources());
            layoutParams.rightMargin = BaseAIOUtils.f(24.0f, this.mActivity.getResources());
        }
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setBackgroundColor(Color.parseColor("#dcdfe4"));
        String a16 = com.tencent.mobileqq.adapter.g.a(this.f210730d, "cover");
        Drawable drawable = this.mActivity.getResources().getDrawable(R.drawable.h2r);
        int i16 = 1;
        if (!TextUtils.isEmpty(a16)) {
            URLDrawable drawable2 = URLDrawable.getDrawable(a16, (int) this.mActivity.getResources().getDimension(R.dimen.f158688md), BaseAIOUtils.f(165.0f, this.mActivity.getResources()), drawable, drawable, true);
            uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if (drawable2 != null && drawable2.getStatus() == 2) {
                drawable2.restartDownload();
            }
            if (drawable2 != null && drawable2.getStatus() == 1) {
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                uRLImageView.setBackgroundDrawable(null);
            } else {
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                uRLImageView.setURLDrawableDownListener(this.C);
            }
            uRLImageView.setImageDrawable(drawable2);
        } else {
            uRLImageView.setImageDrawable(drawable);
            uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        qQCustomDialog.addView(uRLImageView, layoutParams);
        String a17 = com.tencent.mobileqq.adapter.g.a(this.f210730d, "title");
        TextView textView = new TextView(this.mActivity);
        textView.setText(a17);
        textView.setTextSize(16.0f);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-16777216);
        Bundle bundle = this.mExtraData;
        if (bundle != null && bundle.getInt("title_max_line", -1) > 0) {
            i16 = this.mExtraData.getInt("title_max_line", 1);
        }
        textView.setMaxLines(i16);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(BaseAIOUtils.f(24.0f, this.mActivity.getResources()), BaseAIOUtils.f(8.0f, this.mActivity.getResources()), BaseAIOUtils.f(24.0f, this.mActivity.getResources()), BaseAIOUtils.f(20.0f, this.mActivity.getResources()));
        qQCustomDialog.addView(textView);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View n() {
        boolean z16;
        Intent intent;
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        linearLayout.addView(this.f210730d.getPreDialogView(this.mActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0f));
        AbsShareMsg absShareMsg = this.f210730d;
        if (absShareMsg.mMsgServiceID != 32 && !TextUtils.isEmpty(absShareMsg.mMsgUrl)) {
            z16 = true;
            if (((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).isWeatherArkPageUrl(this.f210730d.mMsgUrl.trim())) {
                Intent intent2 = this.mIntent;
                if (intent2 != null) {
                    intent2.putExtra("k_back", true);
                }
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
                view.setContentDescription(HardCodeUtil.qqStr(R.string.mp8));
            }
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            intent = this.mIntent;
            if (intent != null) {
                String stringExtra = intent.getStringExtra(AppConstants.Key.KEY_SEND_TIPS);
                if (stringExtra == null) {
                    return frameLayout;
                }
                QQCustomDialog qQCustomDialog = this.mConfirmDialog;
                if (qQCustomDialog instanceof ForwardNewVersionDialog) {
                    ((ForwardNewVersionDialog) qQCustomDialog).I0(stringExtra);
                } else if (qQCustomDialog instanceof ForwardDialog) {
                    ((ForwardDialog) qQCustomDialog).F0(stringExtra);
                }
            }
            return frameLayout;
        }
        z16 = false;
        FrameLayout frameLayout2 = new FrameLayout(this.mActivity);
        frameLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (z16) {
        }
        frameLayout2.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        intent = this.mIntent;
        if (intent != null) {
        }
        return frameLayout2;
    }

    private void o(String str) {
        ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f210736d;

            {
                this.f210736d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPluginShareStructMsgOption.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String replace = MarketFaceConstants.emoticonJsonFilePath.replace("[epId]", this.f210736d);
                boolean fileExists = FileUtils.fileExists(replace);
                String replace2 = EmotionPanelConstans.smallEmoticonJsonUrl.replace("[epId]", this.f210736d);
                File file = new File(replace);
                if (!fileExists) {
                    com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(replace2, file);
                    gVar.K = true;
                    if (DownloaderFactory.o(gVar, ForwardPluginShareStructMsgOption.this.app) != 0) {
                        return;
                    }
                }
                EmoticonPackage emoticonPackage = new EmoticonPackage();
                emoticonPackage.epId = this.f210736d;
                emoticonPackage.jobType = 4;
                EmotionJsonUtils.parseSmallJson(ForwardPluginShareStructMsgOption.this.app, emoticonPackage, EmojiManagerServiceConstant.JSON_EMOSM_MALL, FileUtils.fileToBytes(file), new ArrayList());
            }
        }, 5, null, true);
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

    private void q() {
        String str;
        QQCustomDialog qQCustomDialog;
        if (getEditTextType() == 0 || (qQCustomDialog = this.mConfirmDialog) == null) {
            str = "";
        } else {
            str = qQCustomDialog.getInputValue();
        }
        this.mIntent.getAction();
        Boolean valueOf = Boolean.valueOf(this.mIntent.getBooleanExtra("key_flag_from_plugin", false));
        Boolean valueOf2 = Boolean.valueOf(this.mIntent.getBooleanExtra("k_back", false));
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=" + valueOf + "iskeyBack=" + valueOf2 + "isNOneedJumpToAIO=" + this.isNOneedJumpToAIO);
        }
        List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
        if (this.mFromSharePanelPreviewAndSend && multiTargetWithoutDataLine != null) {
            int i3 = this.f210732f;
            if (i3 != 146 && i3 != 95 && !v(i3)) {
                return;
            }
            for (ResultRecord resultRecord : multiTargetWithoutDataLine) {
                Intent intent = new Intent();
                intent.putExtras(this.mExtraData);
                intent.putExtra("uin", resultRecord.uin);
                intent.putExtra("uintype", resultRecord.uinType);
                intent.putExtra("troop_uin", resultRecord.groupUin);
                intent.putExtra(AppConstants.Key.UID, resultRecord.uid);
                ForwardPluginShareWebViewHelper.e(this.app, this.mActivity, ForwardUtils.n0(intent), intent, false);
            }
            return;
        }
        if (valueOf.booleanValue()) {
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), new int[]{2});
            this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
            m3.putExtras(this.mExtraData);
            handleForwardFromFavorite(m3);
            if (valueOf2.booleanValue()) {
                AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(m3.getExtras());
                if (this.f210732f == 13 && (e16 instanceof StructMsgForGeneralShare)) {
                    ((StructMsgForGeneralShare) e16).mMsgActionData = m3.getStringExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA) + "&msg=" + m3.getStringExtra("title") + "&toUin=" + this.mExtraData.getString("uin");
                }
                int i16 = e16.mMsgServiceID;
                if (i16 == 83) {
                    e16.mMsgActionData = "";
                }
                if (i16 == 108 || i16 == 114 || i16 == 116) {
                    e16.mMsgActionData = "";
                }
                for (ResultRecord resultRecord2 : multiTargetWithoutDataLine) {
                    SessionInfo o06 = ForwardUtils.o0(m3, resultRecord2.uin, resultRecord2.getUinType(), resultRecord2.groupUin);
                    int c16 = com.tencent.mobileqq.activity.aio.forward.b.d().c();
                    e16.forwardID = c16;
                    com.tencent.mobileqq.activity.aio.forward.b.d().h(o06, str, c16);
                    ShareMsgHelper.h(this.app, resultRecord2.uin, o06.f179559f, resultRecord2.getUinType(), e16, null);
                    if (!TextUtils.isEmpty(str)) {
                        com.tencent.biz.anonymous.a.h().f78364c = true;
                    }
                }
            } else {
                for (ResultRecord resultRecord3 : multiTargetWithoutDataLine) {
                    if (this.isNOneedJumpToAIO) {
                        ForwardUtils.p(this.app, this.mAppContext, ForwardUtils.o0(m3, resultRecord3.uin, resultRecord3.getUinType(), resultRecord3.groupUin), m3);
                    } else if (l.d(m3)) {
                        ForwardUtils.p(this.app, this.mAppContext, ForwardUtils.o0(m3, resultRecord3.uin, resultRecord3.getUinType(), resultRecord3.groupUin), m3);
                    }
                }
            }
            Intent intent2 = new Intent();
            intent2.putExtras(this.mExtraData);
            this.mActivity.setResult(-1, intent2);
            s(m3);
            this.mActivity.finish();
            return;
        }
        forwardToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!TextUtils.isEmpty(this.f210730d.mMsgUrl)) {
            String trim = this.f210730d.mMsgUrl.trim();
            if (QLog.isColorLevel()) {
                QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "gotoWeb " + trim);
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
            QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "empty url");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void s(Intent intent) {
        int i3;
        int i16;
        if (SearchConfig.ENGINE_PUBLIC_ACCOUNT.equals(this.f210733h)) {
            String string = this.mExtraData.getString(IPublicAccountJavascriptInterface.KEY_PUB_UIN);
            if (string == null) {
                string = "";
            }
            String str = string;
            int i17 = this.mExtraData.getInt("uintype");
            if (i17 != 0) {
                if (i17 != 1) {
                    if (i17 != 3000) {
                        i16 = 0;
                        if (this.mIntent.getBooleanExtra("k_struct_forward", false)) {
                            this.mIntent.getStringExtra("struct_uin");
                            this.mIntent.getStringExtra("strurt_msgid");
                            this.mIntent.getStringExtra("detail_url");
                        }
                        ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.app, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_11", "pbshare_success", i16);
                        return;
                    }
                    i3 = 1003;
                } else {
                    i3 = 1002;
                }
            } else {
                i3 = 1001;
            }
            i16 = i3;
            if (this.mIntent.getBooleanExtra("k_struct_forward", false)) {
            }
            ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.app, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_11", "pbshare_success", i16);
            return;
        }
        if ("struct_msg_from_h5".equals(this.f210733h)) {
            String string2 = this.mExtraData.getString(IPublicAccountJavascriptInterface.KEY_PUB_UIN);
            if (!TextUtils.isEmpty(string2)) {
                ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.app, string2, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_31", "share_succ");
                return;
            }
            return;
        }
        if (l.d(intent)) {
            ReportController.n(this.app, "CliOper", "", this.mExtraData.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
        }
    }

    private void t(String str) {
        if (this.f210730d.mMsgUrl.startsWith("http://article.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("https://article.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("http://post.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("https://post.mp.qq.com")) {
            String string = this.mExtraData.getString("uin");
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007236", "0X8007236", 0, 0, this.f210734i, "" + this.f210735m, string, "");
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007236", "", this.f210734i, "" + this.f210735m, string, "");
            if (!TextUtils.isEmpty(str) || !"".equals(str)) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007237", "0X8007237", 0, 0, this.f210734i, "" + this.f210735m, string, "");
            }
        }
    }

    private void u(int i3, Bundle bundle) {
        if (this.mIntent.getBooleanExtra("isWebCompShare", false)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle2.putString("act_type", "" + i3);
            bundle2.putString("intext_1", "" + com.tencent.open.agent.report.e.b(this.f210732f));
            bundle2.putString("intext_2", "" + com.tencent.open.agent.report.e.c(bundle.getInt("uintype"), bundle.getString("uin")));
            bundle2.putString("intext_3", "1");
            ReportCenter.f().l(bundle2, "", this.app.getCurrentAccountUin(), false);
        }
    }

    private boolean v(int i3) {
        if (i3 != 2) {
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("plugin_audio_share_use_default_ark_switch", false);
        QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "isAudioShareByDefaultArk switchOn: " + isSwitchOn);
        return isSwitchOn;
    }

    private static boolean w(int i3) {
        for (int i16 : D) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        byte[] byteArrayExtra = this.mIntent.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES);
        if (byteArrayExtra != null) {
            AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(byteArrayExtra);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            x(d16);
            boolean p16 = p(d16);
            if (d16 instanceof StructMsgForAudioShare) {
                layoutParams.setMargins(0, BaseAIOUtils.f(5.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(10.0f, this.mActivity.getResources()));
            } else if (p16) {
                layoutParams.setMargins(0, 0, 0, 0);
                qQCustomDialog.adjustMessageTopBottomMargin(0.0f, 0.0f);
            } else {
                layoutParams.setMargins(BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), BaseAIOUtils.f(5.0f, this.mActivity.getResources()));
            }
            if (this.f210731e) {
                m(qQCustomDialog);
                return false;
            }
            qQCustomDialog.addView(d16.getPreDialogView(this.mActivity, null), layoutParams);
            if (!p16) {
                addSourceNameView(d16.getSourceName(), qQCustomDialog);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int intExtra = this.mIntent.getIntExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, 13);
        if ((intExtra & 8) != 0 && allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if ((intExtra & 4) != 0 && allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if ((intExtra & 1) != 0 && allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if (super.allowSmartDeviceAbility()) {
            this.mForwardAbilities.add(e.W3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
        } else {
            u(81, bundle);
            super.buildForwardDialog(i3, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        AbsShareMsg absShareMsg = this.f210730d;
        if (absShareMsg == null) {
            return null;
        }
        int i3 = absShareMsg.mMsgServiceID;
        if (i3 == 33) {
            this.mForwardReportType = 8;
            return n();
        }
        if (i3 == 95) {
            this.mForwardReportType = 9;
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
        String string = this.mExtraData.getString("detail_url", "");
        String string2 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, "");
        if (TextUtils.isEmpty(string2)) {
            string2 = this.mExtraData.getString("image_url", "");
        }
        String string3 = this.mExtraData.getString("title", "");
        String string4 = this.mExtraData.getString("desc", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new SharePublishGuildFeedParam.LinkTypeParam(string, string2, string3, string4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.forwardOnCancel();
        ReportController.o(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
        if (this.mIntent.getBooleanExtra("k_struct_forward", false)) {
            ReportController.o(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005457", "0X8005457", 0, 0, "", "", "android", "");
        }
        if (this.f210730d.mMsgUrl.startsWith("http://article.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("https://article.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("http://post.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("https://post.mp.qq.com")) {
            String string = this.mExtraData.getString("uin");
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007235", "0X8007235", 0, 0, this.f210734i, "" + this.f210735m, string, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        boolean z17 = true;
        QLog.d("forward", 1, "ForwardPluginShareStructMsgOption forwardOnConfirm");
        ReportController.o(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
        reportSendAction();
        if (isMultiTarget2Send()) {
            q();
            return;
        }
        if (this.mExtraData.getInt("uintype") == 1 && ((com.tencent.mobileqq.troop.utils.aj) this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).e(this.mExtraData.getString("uin"))) {
            QQToast.makeText(this.app.getApp(), R.string.emm, 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        u(82, this.mExtraData);
        if (this.fromCreateDiscussion) {
            ReportController.o(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
            this.fromCreateDiscussion = false;
        }
        if (getEditTextType() == 0) {
            str = "";
        } else {
            str = this.mConfirmDialog.getInputValue();
        }
        t(str);
        this.mIntent.getAction();
        Boolean valueOf = Boolean.valueOf(this.mIntent.getBooleanExtra("key_flag_from_plugin", false));
        Boolean valueOf2 = Boolean.valueOf(this.mIntent.getBooleanExtra("k_back", false));
        boolean booleanExtra = this.mIntent.getBooleanExtra("k_action_web_default_share", false);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ForwardPluginShareStructMsgOption isFromPlugin=");
        sb5.append(valueOf);
        sb5.append(" needJumpAIO=");
        sb5.append(!this.isNOneedJumpToAIO);
        sb5.append(" mForwardSubType=");
        sb5.append(this.f210732f);
        sb5.append(" isDefaultWebShare=");
        sb5.append(booleanExtra);
        QLog.d("forward", 1, sb5.toString());
        if (valueOf.booleanValue()) {
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), new int[]{2});
            this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
            m3.putExtras(this.mExtraData);
            handleForwardFromFavorite(m3);
            if (this.mExtraData.getInt("uintype") == 10014) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                SessionInfo n06 = ForwardUtils.n0(m3);
                n06.f179559f = m3.getStringExtra("guild_id");
                this.mIntent.putExtra("is_need_show_toast", false);
                this.mNeedInterrupFinishActivity = true;
                ForwardPluginShareWebViewHelper.d(this.app, this.mActivity, n06, m3, null);
            } else {
                int i3 = this.f210732f;
                if (i3 != 146 && i3 != 95 && !v(i3)) {
                    if (valueOf2.booleanValue()) {
                        AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(m3.getExtras());
                        if (this.f210732f == 13 && (e16 instanceof StructMsgForGeneralShare)) {
                            ((StructMsgForGeneralShare) e16).mMsgActionData = m3.getStringExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA) + "&msg=" + m3.getStringExtra("title") + "&toUin=" + this.mExtraData.getString("uin");
                        }
                        int i16 = e16.mMsgServiceID;
                        if (i16 == 83) {
                            e16.mMsgActionData = "";
                        }
                        if (i16 == 108 || i16 == 114 || i16 == 116) {
                            if (e16.getSourceName().equals("QQ\u52a8\u6f2b")) {
                                e16.mMsg_A_ActionData = e16.mMsgActionData;
                            }
                            e16.mMsgActionData = "";
                        }
                        SessionInfo n07 = ForwardUtils.n0(m3);
                        int c16 = com.tencent.mobileqq.activity.aio.forward.b.d().c();
                        e16.forwardID = c16;
                        com.tencent.mobileqq.activity.aio.forward.b.d().h(n07, str, c16);
                        ShareMsgHelper.h(this.app, this.mExtraData.getString("uin"), n07.f179559f, this.mExtraData.getInt("uintype"), e16, null);
                        if (!TextUtils.isEmpty(str)) {
                            com.tencent.biz.anonymous.a.h().f78364c = true;
                        }
                    } else if (this.isNOneedJumpToAIO) {
                        ForwardUtils.p(this.app, this.mAppContext, ForwardUtils.n0(m3), m3);
                    } else {
                        if (l.d(m3)) {
                            ForwardUtils.p(this.app, this.mAppContext, ForwardUtils.n0(m3), m3);
                        }
                        this.mActivity.startActivity(m3);
                    }
                    z17 = false;
                } else {
                    SessionInfo n08 = ForwardUtils.n0(m3);
                    this.mIntent.putExtra("is_need_show_toast", false);
                    this.mNeedInterrupFinishActivity = true;
                    ForwardPluginShareWebViewHelper.e(this.app, this.mActivity, n08, m3, !this.isNOneedJumpToAIO);
                }
            }
            Intent intent = new Intent();
            intent.putExtras(this.mExtraData);
            this.mActivity.setResult(-1, intent);
            s(m3);
            u(83, this.mExtraData);
            if (!z17) {
                this.mActivity.finish();
                return;
            }
            return;
        }
        forwardToTarget();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardToMyComputer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.mExtraData.putBoolean("forward_jump_to_data_line_aio", false);
        this.mExtraData.putInt("dataline_forward_type", 102);
        this.mExtraData.putString("dataline_forward_text", this.f210730d.mMsgUrl);
        super.forwardToMyComputer(i3);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (this.f210732f == 13 || SearchConfig.ENGINE_PUBLIC_ACCOUNT.equals(this.f210733h) || "web_share".equals(this.f210733h) || "struct_msg_from_h5".equals(this.f210733h) || "struct_favorite".equals(this.f210733h)) {
            for (RecentUser recentUser : list) {
                if (b()) {
                    arrayList.add(recentUser);
                } else if (recentUser != null && !Utils.J(recentUser.uin) && !w(recentUser.getType()) && (recentUser.getType() != 1006 || isSupportAbility(e.U3))) {
                    if (recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) {
                        if ((recentUser.getType() == 0 && isSupportAbility(e.O3)) || ((recentUser.getType() == 1 && !isHotChat(recentUser.uin) && isSupportAbility(e.P3)) || (recentUser.getType() == 3000 && isSupportAbility(e.Q3)))) {
                            if ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || this.mSurpportTroopDiscussionTmpConv) {
                                arrayList.add(recentUser);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardPluginShareStructMsgOption preloadData");
        }
        super.preloadData();
        this.f210732f = this.mIntent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, Integer.MAX_VALUE);
        this.f210733h = this.mExtraData.getString("pluginName");
        this.isNOneedJumpToAIO = this.mIntent.getBooleanExtra("forward _key_nojump", false);
        AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(this.mExtraData.getByteArray(AppConstants.Key.STRUCT_MSG_BYTES));
        if (d16 != null && (d16 instanceof AbsShareMsg)) {
            this.f210730d = (AbsShareMsg) d16;
        }
        AbsShareMsg absShareMsg = this.f210730d;
        if (absShareMsg == null) {
            return true;
        }
        int i3 = absShareMsg.mMsgServiceID;
        if (i3 != 83 && i3 != 108 && i3 != 114 && i3 != 116 && i3 != 151 && i3 != 156) {
            if (absShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("https://article.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("http://post.mp.qq.com") || this.f210730d.mMsgUrl.startsWith("https://post.mp.qq.com")) {
                this.f210735m = 1;
                this.mExtraData.putInt("emoInputType", 2);
            }
        } else {
            this.f210731e = true;
            this.mExtraData.putInt("emoInputType", 3);
            this.f210735m = 2;
        }
        try {
            this.f210734i = Uri.parse(this.f210730d.mMsgUrl).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f210734i == null) {
            this.f210734i = "";
        }
        if (this.mIntent.getBooleanExtra("isWebCompShare", false)) {
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "80");
            bundle.putString("intext_1", "" + com.tencent.open.agent.report.e.b(this.f210732f));
            bundle.putString("intext_3", "1");
            ReportCenter.f().l(bundle, "", this.app.getCurrentAccountUin(), false);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected int realShareToQfav() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        String stringExtra = this.mIntent.getStringExtra("detail_url");
        int i3 = -1;
        if (!TextUtils.isEmpty(stringExtra) && QfavBuilder.a0(stringExtra).e(this.mActivity, this.app.getAccount(), -1, null)) {
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
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.f210730d == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "msgId = " + this.f210730d.mMsgServiceID);
        }
        AbsShareMsg absShareMsg = this.f210730d;
        int i3 = absShareMsg.mMsgServiceID;
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

    public void x(AbsStructMsg absStructMsg) {
        List<AbsStructMsgElement> structMsgItemLists;
        com.tencent.mobileqq.structmsg.view.u uVar;
        ArrayList<AbsStructMsgElement> arrayList;
        int i3;
        Emoticon emoticon;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) absStructMsg);
            return;
        }
        if (absStructMsg != null && (absStructMsg instanceof StructMsgForGeneralShare) && (structMsgItemLists = ((StructMsgForGeneralShare) absStructMsg).getStructMsgItemLists()) != null && structMsgItemLists.size() != 0) {
            Iterator<AbsStructMsgElement> it = structMsgItemLists.iterator();
            while (true) {
                if (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    if (next instanceof com.tencent.mobileqq.structmsg.view.u) {
                        uVar = (com.tencent.mobileqq.structmsg.view.u) next;
                        break;
                    }
                } else {
                    uVar = null;
                    break;
                }
            }
            if (uVar != null && (arrayList = uVar.U0) != null && arrayList.size() != 0) {
                Iterator<AbsStructMsgElement> it5 = arrayList.iterator();
                ap apVar = null;
                while (it5.hasNext()) {
                    AbsStructMsgElement next2 = it5.next();
                    if (next2 instanceof ap) {
                        apVar = (ap) next2;
                    }
                }
                if (apVar == null) {
                    return;
                }
                String t16 = apVar.t();
                if (TextUtils.isEmpty(t16)) {
                    return;
                }
                IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.app.getRuntimeService(IEmoticonManagerService.class);
                StringBuilder sb5 = new StringBuilder(t16);
                int i16 = 0;
                while (i16 < sb5.length()) {
                    if ('\u00ff' == sb5.charAt(i16) && (i3 = i16 + 3) < sb5.length()) {
                        char[] cArr = new char[4];
                        cArr[0] = sb5.charAt(i3);
                        cArr[1] = sb5.charAt(i16 + 2);
                        cArr[2] = sb5.charAt(i16 + 1);
                        cArr[3] = sb5.charAt(i16);
                        for (int i17 = 0; i17 < 4; i17++) {
                            char c16 = cArr[i17];
                            if (c16 == '\u00fa') {
                                cArr[i17] = '\n';
                            } else if (c16 == '\u00fe') {
                                cArr[i17] = '\r';
                            } else if (c16 == '\u00fd') {
                                cArr[i17] = 20;
                            }
                        }
                        int[] r16 = com.tencent.mobileqq.emosm.e.r(cArr);
                        String str = AbsQQText.SMALL_EMOJI_SYMBOL;
                        if (iEmoticonManagerService != null) {
                            emoticon = iEmoticonManagerService.syncFindEmoticonById(Integer.toString(r16[0]), Integer.toString(r16[1]));
                        } else {
                            emoticon = null;
                        }
                        if (emoticon != null) {
                            str = emoticon.character;
                        } else {
                            o(Integer.toString(r16[0]));
                        }
                        sb5.replace(i16, i3, str);
                        i16 += str.length();
                    }
                    i16++;
                }
                if (!TextUtils.isEmpty(sb5)) {
                    apVar.E(sb5.toString());
                }
            }
        }
    }
}
