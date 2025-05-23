package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmedia.CommonPreviewLayerFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.util.AutoSaveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.video.VideoComponentCallback;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardShortVideoOption extends ForwardBaseOption implements al {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected b f210888d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class PressDarkImageView extends ImageView {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        public static ColorFilter f210897e;

        /* renamed from: d, reason: collision with root package name */
        ImageView f210898d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72234);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                f210897e = new PorterDuffColorFilter(167970842, PorterDuff.Mode.SRC_ATOP);
            }
        }

        public PressDarkImageView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }

        @Override // android.widget.ImageView, android.view.View
        protected void drawableStateChanged() {
            Drawable drawable;
            Drawable drawable2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            super.drawableStateChanged();
            if (isPressed()) {
                super.setAlpha(0.5f);
                ImageView imageView = this.f210898d;
                if (imageView != null && (drawable2 = imageView.getDrawable()) != null) {
                    drawable2.setColorFilter(com.tencent.mobileqq.activity.aio.o.f179547b);
                    return;
                }
                return;
            }
            super.setAlpha(1.0f);
            ImageView imageView2 = this.f210898d;
            if (imageView2 != null && (drawable = imageView2.getDrawable()) != null) {
                drawable.setColorFilter(null);
            }
        }

        public PressDarkImageView(Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }

        public PressDarkImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardShortVideoOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardShortVideoOption forwardShortVideoOption = ForwardShortVideoOption.this;
                if (forwardShortVideoOption.mActivity != null) {
                    forwardShortVideoOption.m();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f210900a;

        /* renamed from: b, reason: collision with root package name */
        public PressDarkImageView f210901b;

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            this.f210901b.setVisibility(0);
            this.f210900a.setVisibility(0);
            if (drawable == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardShortVideoOption", 2, "setPreviewImage null");
                }
                this.f210900a.setImageResource(R.drawable.aio_image_fail_round);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f210900a.setLayoutParams(layoutParams);
            this.f210900a.setAdjustViewBounds(true);
            this.f210900a.setMaxHeight(ViewUtils.dip2px(140.0f));
            this.f210900a.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f210900a.setImageDrawable(drawable);
        }
    }

    public ForwardShortVideoOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.mSurpportTroopDiscussionTmpConv = true;
            this.mForwardReportType = 7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Intent intent = new Intent(this.mActivity, (Class<?>) ShortVideoPlayActivity.class);
        if (this.mExtraData.getParcelable(ShortVideoConstants.KEY_MESSAGE_FOR_SHORTVIDEO) != null) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) this.mExtraData.getParcelable(ShortVideoConstants.KEY_MESSAGE_FOR_SHORTVIDEO);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview msg " + messageForShortVideo.videoFileName);
            }
            intent.putExtras(this.mExtraData);
            intent.putExtra(ShortVideoConstants.VIDEO_PLAY_CALLER, 5);
            intent.putExtra(ShortVideoConstants.MESSAGE_CLICK_START, System.currentTimeMillis());
        } else {
            String string = this.mExtraData.getString("file_send_path");
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview file " + string);
            }
            if (FileUtils.fileExists(string)) {
                if (mb1.a.f416517a.l()) {
                    ImageView imageView = this.f210888d.f210900a;
                    if (imageView == null) {
                        imageView = new ImageView(this.mActivity);
                    }
                    ImageView imageView2 = imageView;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(sm2.a.f433978a.b(string, this.mForwardThumb));
                    com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
                    eVar.j(arrayList);
                    eVar.i(0);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("hide_save_button", true);
                    RFWLayerLaunchUtil.jumpToGallery(imageView2, arrayList, 0, QQGalleryActivity.class, CommonPreviewLayerFragment.class, bundle);
                    return;
                }
                intent.putExtra("file_send_path", string);
                intent.putExtra(ShortVideoConstants.VIDEO_PLAY_CALLER, 6);
                intent.putExtra(ShortVideoConstants.MESSAGE_CLICK_START, System.currentTimeMillis());
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview file not exit ");
                    return;
                }
                return;
            }
        }
        this.mActivity.startActivity(intent);
        reportClickContentAction();
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        if (this.mExtraData.getBoolean(ShortVideoConstants.FORWARD_IS_PTV, false)) {
            if (!TextUtils.isEmpty(this.mForwardThumb)) {
                try {
                    qQCustomDialog.setPreviewImage(l.g(cn.d(new BitmapDrawable(this.mActivity.getResources(), this.mForwardThumb))), true, 1);
                } catch (OutOfMemoryError e16) {
                    QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get ptv drawable omm!", e16);
                }
            }
            return false;
        }
        if (this.mExtraData.getBoolean("isFromFavorite", false)) {
            String str2 = AppConstants.S_DCARD_COLLECTION + "pic/" + this.mIntent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5) + "_0";
            String str3 = this.mForwardThumb;
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !new File(str3).exists() && new File(str2).exists()) {
                FileUtils.copyFile(str2, str3);
            }
        }
        if (!TextUtils.isEmpty(this.mForwardThumb)) {
            try {
                URL generateURLForNew = RegionalThumbDownloader.generateURLForNew(this.mForwardThumb, ScreenUtil.dip2px(100.0f), ScreenUtil.dip2px(300.0f));
                if (generateURLForNew != null) {
                    str = generateURLForNew.toString();
                } else {
                    str = null;
                }
                ThreadManagerV2.post(new Runnable(URLDrawable.getDrawable(str), qQCustomDialog, this.mIntent.getBooleanExtra(AppConstants.Key.FORWARD_IS_LONG, false), this.mIntent.getIntExtra(ShortVideoConstants.FILE_SEND_SIZE, 0), this.mIntent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, 0)) { // from class: com.tencent.mobileqq.forward.ForwardShortVideoOption.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ URLDrawable f210889d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ QQCustomDialog f210890e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f210891f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f210892h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ int f210893i;

                    {
                        this.f210889d = r6;
                        this.f210890e = qQCustomDialog;
                        this.f210891f = r8;
                        this.f210892h = r9;
                        this.f210893i = r10;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ForwardShortVideoOption.this, r6, qQCustomDialog, Boolean.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            URLDrawableHelper.decodeLocalImage(this.f210889d, null, false);
                            ForwardShortVideoOption.this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardShortVideoOption.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    URLDrawable uRLDrawable = AnonymousClass1.this.f210889d;
                                    uRLDrawable.setBounds(0, 0, uRLDrawable.getIntrinsicWidth(), AnonymousClass1.this.f210889d.getIntrinsicHeight());
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    anonymousClass1.f210890e.setPreviewImage(anonymousClass1.f210889d, true, 0, true);
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    if (anonymousClass12.f210891f) {
                                        int i3 = anonymousClass12.f210892h;
                                        if (i3 != 0 && anonymousClass12.f210893i != 0) {
                                            anonymousClass12.f210890e.setVideoFormat(true, false, ShortVideoUtils.stringForFileSize(ForwardShortVideoOption.this.mAppContext, i3), ShortVideoUtils.stringForTime(AnonymousClass1.this.f210893i * 1000));
                                            return;
                                        } else {
                                            anonymousClass12.f210890e.setVideoFormat(true, false, null, null);
                                            return;
                                        }
                                    }
                                    anonymousClass12.f210890e.setVideoFormat(true, false, null, null);
                                }
                            });
                        }
                    }
                }, 8, null, false);
                return false;
            } catch (OutOfMemoryError e17) {
                QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get shortvideo drawable omm!", e17);
            }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
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
        if (this.mIntent.getBooleanExtra("k_qzone", false)) {
            this.mForwardAbilities.add(e.R3);
        }
        if (this.mIntent.getBooleanExtra("k_qqstory", false)) {
            this.mForwardAbilities.add(e.Z3);
        }
        if (this.mIntent.getBooleanExtra("k_dataline", false)) {
            this.mForwardAbilities.add(e.S3);
            this.mForwardAbilities.add(e.X3);
            this.mForwardAbilities.add(e.f211017e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.f167851jj, (ViewGroup) null);
        b bVar = new b();
        this.f210888d = bVar;
        bVar.f210900a = (ImageView) inflate.findViewById(R.id.cla);
        b bVar2 = this.f210888d;
        ((ChatThumbView) bVar2.f210900a).f179329f = false;
        bVar2.f210901b = new PressDarkImageView(this.mActivity);
        this.f210888d.f210901b.setImageDrawable(this.mActivity.getResources().getDrawable(R.drawable.cmr));
        b bVar3 = this.f210888d;
        bVar3.f210901b.f210898d = bVar3.f210900a;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.cl_);
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            int dip2px = ViewUtils.dip2px(15.0f);
            inflate.setPadding(0, dip2px, 0, dip2px);
        } else {
            this.f210888d.f210900a.setVisibility(8);
            this.f210888d.f210901b.setVisibility(8);
        }
        int dip2px2 = ViewUtils.dip2px(40.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        layoutParams.addRule(13);
        relativeLayout.addView(this.f210888d.f210901b, layoutParams);
        inflate.findViewById(R.id.cl_).setVisibility(0);
        n();
        this.f210888d.f210901b.setContentDescription(HardCodeUtil.qqStr(R.string.mqw));
        this.f210888d.f210901b.setOnClickListener(new a());
        return inflate;
    }

    @Override // com.tencent.mobileqq.forward.al
    @androidx.annotation.Nullable
    public SharePublishGuildFeedParam c() {
        ForwardFileInfo forwardFileInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        String string = this.mExtraData.getString(AppConstants.Key.FORWARD_THUMB, "");
        if (TextUtils.isEmpty(string) && (forwardFileInfo = (ForwardFileInfo) this.mIntent.getParcelableExtra("fileinfo")) != null) {
            string = forwardFileInfo.p();
        }
        String string2 = this.mExtraData.getString(AppConstants.Key.FORWARD_EXTRA, "");
        if (TextUtils.isEmpty(string2)) {
            string2 = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH, "");
        }
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
            return null;
        }
        return new SharePublishGuildFeedParam.VideoTypeParam(string, string2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.forwardOnCancel();
        int i3 = getExtras().getInt("key_forward_ability_type");
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardShortVideoOption", 2, "-->getCancelListener--onClick--type = " + i3);
        }
        if (i3 == e.Z3.intValue()) {
            id0.a.n("plus_shoot", "nosend_tip", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.forwardOnConfirm();
        if (this.mExtraData.getBoolean("NeedReportForwardShortVideo", false)) {
            int calcUinType = ((IPicPreDownload) this.app.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.app, this.mExtraData.getInt("uintype"), this.mExtraData.getString("uin"));
            if (calcUinType == 3) {
                str = "1";
            } else if (calcUinType == 2) {
                str = "2";
            } else if (calcUinType == 0) {
                str = "3";
            } else {
                str = "4";
            }
            ReportController.o(this.app, "CliOper", "", "", "0X8005622", "0X8005622", 0, 0, str, "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void forwardToQQStory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(getExtras());
        intent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
        ReportController.o(this.app, "CliOper", "", "", "0X8007810", "0X8007810", 0, 0, "", "", "", "");
        id0.a.n("plus_shoot", "send_tip", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void forwardToQZone(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        aliasIntent.putExtras(this.mExtraData);
        aliasIntent.putExtra("set_user_callback", VideoComponentCallback.TAG);
        aliasIntent.putExtra("forward_to_qzone_to_enable_edit", true);
        aliasIntent.putExtra(ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, ShortVideoConstants.SOURCE_FROM_QUICK_SHOOT);
        aliasIntent.putExtra("key_content", str);
        aliasIntent.setFlags(67108864);
        aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 4);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra(SplashActivity.SWITCH_ANIM, true);
        aliasIntent.putExtra("forward_to_someplace_from_shoot_quick", 1002);
        ReportController.o(this.app, "CliOper", "", "", "0X800780F", "0X800780F", 0, 0, "", "", "", "");
        this.mActivity.setResult(-1, aliasIntent);
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getEditTextType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = this.mExtraData.getInt("key_forward_ability_type");
        boolean booleanExtra = this.mIntent.getBooleanExtra(ForwardRecentActivity.FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE, false);
        if (i3 == e.R3.intValue() && booleanExtra) {
            return 2;
        }
        return super.getEditTextType();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null) {
                if (!Utils.J(recentUser.uin) && recentUser.getType() != 10004 && ((recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) && (recentUser.getType() == 0 || recentUser.getType() == 1 || recentUser.getType() == 10027))) {
                    arrayList.add(recentUser);
                } else if (recentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN) && isSupportAbility(e.S3) && isFromSharePullRecentList()) {
                    arrayList.add(recentUser);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return true;
    }

    protected void n() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.mExtraData.getBoolean("isFromFavorite", false)) {
            String str2 = AppConstants.S_DCARD_COLLECTION + "pic/" + this.mIntent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5) + "_0";
            String str3 = this.mForwardThumb;
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !new File(str3).exists() && new File(str2).exists()) {
                FileUtils.copyFile(str2, str3);
            }
        }
        if (!TextUtils.isEmpty(this.mForwardThumb)) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage " + this.mForwardThumb);
            }
            try {
                URL generateURLForNew = RegionalThumbDownloader.generateURLForNew(this.mForwardThumb, ScreenUtil.dip2px(100.0f), ScreenUtil.dip2px(300.0f));
                if (generateURLForNew != null) {
                    str = generateURLForNew.toString();
                } else {
                    str = null;
                }
                URLDrawable drawable = URLDrawable.getDrawable(str);
                drawable.setBounds(0, 0, ScreenUtil.dip2px(248.0f), ScreenUtil.dip2px(248.0f));
                this.mIntent.getBooleanExtra(AppConstants.Key.FORWARD_IS_LONG, false);
                this.mIntent.getIntExtra(ShortVideoConstants.FILE_SEND_SIZE, 0);
                this.mIntent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, 0);
                ThreadManagerV2.excute(new Runnable(drawable) { // from class: com.tencent.mobileqq.forward.ForwardShortVideoOption.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ URLDrawable f210895d;

                    {
                        this.f210895d = drawable;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardShortVideoOption.this, (Object) drawable);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            URLDrawableHelper.decodeLocalImage(this.f210895d, null, false);
                            ForwardShortVideoOption.this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardShortVideoOption.3.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    URLDrawable uRLDrawable = AnonymousClass3.this.f210895d;
                                    uRLDrawable.setBounds(0, 0, uRLDrawable.getIntrinsicWidth(), AnonymousClass3.this.f210895d.getIntrinsicHeight());
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    ForwardShortVideoOption.this.f210888d.a(anonymousClass3.f210895d);
                                }
                            });
                        }
                    }
                }, 16, null, false);
                return;
            } catch (OutOfMemoryError e16) {
                QLog.e("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage omm!", e16);
                this.f210888d.a(null);
                return;
            }
        }
        this.f210888d.a(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        boolean z16 = this.mExtraData.getBoolean("isFromFavorite", false);
        boolean z17 = this.mExtraData.getBoolean(AppConstants.Key.FORWARD_NEED_SENDMSG, false);
        boolean booleanExtra = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "forwardShortvideo realForwardTo isNeedSendMsg=" + z17 + "isFromFavorite=" + z16);
        }
        if (isMultiTarget2Send()) {
            getMultiTargetWithoutDataLine();
            Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
            aliasIntent.putExtras(this.mExtraData);
            Intent m3 = BaseAIOUtils.m(aliasIntent, null);
            m3.putExtra("isBack2Root", true);
            if (this.mFromSharePanelPreviewAndSend) {
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
                return true;
            }
            if (z17) {
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
            } else if (booleanExtra || booleanExtra2) {
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179557e = this.mExtraData.getString("uin");
                sessionInfo.f179555d = this.mExtraData.getInt("uintype");
                sessionInfo.f179559f = this.mExtraData.getString("troop_uin");
                m3.putExtra(PeakConstants.SEND_SESSION_INFO, sessionInfo);
                int i3 = sessionInfo.f179555d;
                if (i3 == 0) {
                    str2 = "0X800780C";
                } else if (i3 == 1) {
                    str2 = "0X800780D";
                } else if (i3 == 3000) {
                    str2 = "0X800780E";
                } else {
                    str2 = "";
                }
                ReportController.o(this.app, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
            }
            this.mActivity.setResult(-1, m3);
            return true;
        }
        Intent aliasIntent2 = SplashActivity.getAliasIntent(this.mActivity);
        aliasIntent2.putExtras(this.mExtraData);
        Intent m16 = BaseAIOUtils.m(aliasIntent2, null);
        m16.putExtra("isBack2Root", true);
        if (z17) {
            ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m16, null);
        } else if (booleanExtra || booleanExtra2) {
            SessionInfo sessionInfo2 = new SessionInfo();
            sessionInfo2.f179557e = this.mExtraData.getString("uin");
            sessionInfo2.f179555d = this.mExtraData.getInt("uintype");
            sessionInfo2.f179559f = this.mExtraData.getString("troop_uin");
            m16.putExtra(PeakConstants.SEND_SESSION_INFO, sessionInfo2);
            int i16 = sessionInfo2.f179555d;
            if (i16 == 0) {
                str = "0X800780C";
            } else if (i16 == 1) {
                str = "0X800780D";
            } else if (i16 == 3000) {
                str = "0X800780E";
            } else {
                str = "";
            }
            ReportController.o(this.app, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
        this.mActivity.setResult(-1, m16);
        this.mActivity.finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineSingle(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        intent.putExtra("dataline_forward_type", 100);
        String string = this.mExtraData.getString(AppConstants.Key.FORWARD_EXTRA);
        if (string == null) {
            string = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_EXTRA);
        }
        if (string == null) {
            string = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (string == null) {
            string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (string == null) {
            string = this.mExtraData.getString("GALLERY.FORWORD_LOCAL_PATH");
        }
        QLog.d("ForwardOption.ForwardShortVideoOption", 1, "sendDatalineSingle filePath: " + string);
        intent.putExtra("dataline_forward_path", string);
        AutoSaveUtils.d(true, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.mExtraData.getBoolean(ShortVideoConstants.FORWARD_IS_PTV, false)) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShortVideoOption", 2, "isFromPtv use old");
            }
            return false;
        }
        return true;
    }
}
