package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.an;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.Date;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgForAudioShare extends AbsShareMsg implements com.tencent.mobileqq.music.g {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static View.OnClickListener f290351d;
    private WeakReference<URLImageView> mCoverImage;
    private boolean mIsShowCommentLayout;
    private View.OnClickListener musicShareCoverClikListener;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f290354d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgForAudioShare.this);
            } else {
                this.f290354d = 0L;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QQAppInterface qQAppInterface;
            boolean z16;
            com.tencent.mobileqq.onlinestatus.manager.e eVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Resources resources = view.getContext().getResources();
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - this.f290354d >= 500) {
                    this.f290354d = uptimeMillis;
                    if (view.getTag() instanceof AbsShareMsg) {
                        AbsShareMsg absShareMsg = (AbsShareMsg) view.getTag();
                        Context context = view.getContext();
                        try {
                            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(absShareMsg.currentAccountUin);
                        } catch (AccountNotMatchException e16) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("StructMsg", 4, e16.getStackTrace().toString());
                            }
                            qQAppInterface = null;
                        }
                        if (qQAppInterface != null) {
                            MediaPlayerManager.q(qQAppInterface).D(true);
                        }
                        if (absShareMsg != null && absShareMsg.mMsgServiceID == 2) {
                            StructMsgForAudioShare structMsgForAudioShare = (StructMsgForAudioShare) absShareMsg;
                            if (QQPlayerService.t0(StructMsgForAudioShare.this)) {
                                QQPlayerService.m1(context);
                                view.setContentDescription(resources.getString(R.string.f170492ss));
                            } else if (qQAppInterface != null && qQAppInterface.isVideoChatting()) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
                                }
                            } else {
                                if (qQAppInterface != null && (eVar = (com.tencent.mobileqq.onlinestatus.manager.e) ((IOnlineStatusManagerService) qQAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class)) != null) {
                                    eVar.h(1);
                                }
                                SongInfo songInfo = new SongInfo();
                                songInfo.f251870h = structMsgForAudioShare.mContentSrc;
                                songInfo.f251871i = structMsgForAudioShare.mContentTitle;
                                songInfo.f251872m = structMsgForAudioShare.mContentSummary;
                                songInfo.C = structMsgForAudioShare.mContentCover;
                                songInfo.D = structMsgForAudioShare.mMsgUrl;
                                boolean z17 = false;
                                if (!"com.tencent.radio".equals(absShareMsg.mSource_A_ActionData) && !"1103394134".equals(Long.valueOf(absShareMsg.mSourceAppid)) && !"\u4f01\u9e45FM".equals(absShareMsg.mSourceName)) {
                                    if (!QZoneHelper.PACKAGENAME_QQMUSIC.equals(absShareMsg.mSource_A_ActionData) && !"100497308".equals(Long.valueOf(absShareMsg.mSourceAppid)) && !"QQ\u97f3\u4e50".equals(absShareMsg.mSourceName)) {
                                        z16 = false;
                                    } else {
                                        songInfo.I = 4;
                                        z16 = true;
                                    }
                                } else {
                                    songInfo.I = 6;
                                    z16 = false;
                                    z17 = true;
                                }
                                Intent intent = new Intent(context, (Class<?>) MusicPlayerActivity.class);
                                if ((z17 || z16) && "web".equals(absShareMsg.mMsgAction)) {
                                    intent.putExtra("key_isReadModeEnabled", true);
                                    String str = absShareMsg.mMsgUrl;
                                    if (z17) {
                                        str = str + "&player=mqq";
                                    }
                                    intent.putExtra("url", str);
                                    intent.putExtra("param_force_internal_browser", true);
                                    intent.putExtra("isAppShare", true);
                                    intent.putExtra(AppConstants.Key.SHARE_REQ_APP_ID, com.tencent.mobileqq.utils.h.e(absShareMsg.mSourceAppid));
                                    intent.putExtra("fromAio", true);
                                    ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(intent, absShareMsg.mMsgUrl);
                                }
                                QQPlayerService.b1(intent);
                                Bundle f06 = QQPlayerService.f0();
                                if (f06 == null) {
                                    f06 = new Bundle();
                                    QQPlayerService.a1(f06);
                                }
                                f06.putString("KEY_SOURCE_NAME", StructMsgForAudioShare.this.getSourceName());
                                QQPlayerService.Z0(StructMsgForAudioShare.this);
                                QQPlayerService.l1(context, StructMsgForAudioShare.this.getToken(), songInfo);
                                view.setContentDescription(resources.getString(R.string.f170490sq));
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("QQPlayerService", 2, "msg is null or serviceId not audio_share");
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f290351d = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructMsgForAudioShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.musicShareCoverClikListener = new b();
            this.mMsgServiceID = 2;
        }
    }

    public static StructMsgForAudioShare getTestObj() {
        StructMsgForAudioShare structMsgForAudioShare = new StructMsgForAudioShare();
        structMsgForAudioShare.mMsgServiceID = 2;
        structMsgForAudioShare.fwFlag = 0;
        structMsgForAudioShare.mContentCover = "https://url.cn/R3i1JD";
        structMsgForAudioShare.mContentLayout = 2;
        structMsgForAudioShare.mContentSrc = "https://url.cn/JpkdzT";
        structMsgForAudioShare.mContentSummary = HardCodeUtil.qqStr(R.string.f172742tw3);
        structMsgForAudioShare.mContentTitle = HardCodeUtil.qqStr(R.string.tw6) + new Date();
        structMsgForAudioShare.mMsgUrl = "https://y.qq.com/i/song.html?songid=625023&source=qq";
        structMsgForAudioShare.mSourceName = "QQ\u97f3\u4e50";
        structMsgForAudioShare.mMsgBrief = HardCodeUtil.qqStr(R.string.twe);
        structMsgForAudioShare.mMsgAction = "web";
        structMsgForAudioShare.mMsgActionData = "y.qq.com";
        structMsgForAudioShare.mMsg_A_ActionData = QZoneHelper.PACKAGENAME_QQMUSIC;
        structMsgForAudioShare.mSource_I_ActionData = "tencent100497308://";
        structMsgForAudioShare.mSourceAction = "app";
        structMsgForAudioShare.mMsgTemplateID = 1;
        structMsgForAudioShare.mSourceAppid = 100497308L;
        structMsgForAudioShare.mSourceUrl = "https://web.p.qq.com/qqmpmobile/aio/app.html?id=100497308";
        structMsgForAudioShare.mSourceIcon = "https://p.qpic.cn/qqconnect_app_logo/1LlgQzJVOyA9xucianwgfHru8JA97ERytRa0lHcRRGGw/0";
        return structMsgForAudioShare;
    }

    public static void onClickEvent(Context context, StructMsgForAudioShare structMsgForAudioShare) {
        int i3;
        if ("web".equals(structMsgForAudioShare.mMsgAction)) {
            i3 = 1;
            ((com.tencent.mobileqq.onlinestatus.manager.e) ((IOnlineStatusManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class)).h(1);
            Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("big_brother_source_key", "biz_src_jc_aio");
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra("url", structMsgForAudioShare.mMsgUrl);
            intent.putExtra("param_force_internal_browser", true);
            intent.putExtra("isAppShare", true);
            intent.putExtra(AppConstants.Key.SHARE_REQ_APP_ID, com.tencent.mobileqq.utils.h.e(structMsgForAudioShare.mSourceAppid));
            context.sendBroadcast(new Intent("qqplayer_exit_action"));
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(structMsgForAudioShare.message, intent, structMsgForAudioShare.mMsgUrl);
            context.startActivity(intent);
            ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, structMsgForAudioShare.mMsgUrl, "", "", "");
        } else {
            i3 = 0;
        }
        int i16 = i3;
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForAudioShare.uin, "0X80055C7", "0X80055C7", 0, i16, "" + structMsgForAudioShare.msgId, structMsgForAudioShare.templateIDForPortal, "", structMsgForAudioShare.mMsgUrl);
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForAudioShare.uin, "0X8005D49", "0X8005D49", 0, i16, "MSGID=" + Long.toString(structMsgForAudioShare.msgId) + ";TEPLATEID=" + structMsgForAudioShare.templateIDForPortal + ";ARTICALID=;REFERRER=" + AbsStructMsgElement.e(structMsgForAudioShare.mMsgUrl), "", "", "");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public View.OnClickListener getOnClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return f290351d;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg, com.tencent.mobileqq.structmsg.AbsStructMsg
    public View getPreDialogView(Context context, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) view);
        }
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.bzg, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.dgb);
        TextView textView = (TextView) view.findViewById(R.id.kbs);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_summary);
        String str = this.mContentCover;
        String str2 = this.mContentTitle;
        String str3 = this.mContentSummary;
        textView.setText(str2);
        textView2.setText(str3);
        int i3 = 2;
        if (!TextUtils.isEmpty(str2)) {
            textView2.setMaxLines(2);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            textView2.setMaxLines(4);
        }
        if (TextUtils.isEmpty(str3)) {
            i3 = 3;
        }
        textView.setMaxLines(i3);
        Drawable drawable = context.getResources().getDrawable(R.drawable.f162489h31);
        imageView.setBackgroundDrawable(null);
        if (TextUtils.isEmpty(str)) {
            imageView.setImageDrawable(drawable);
        } else {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                str = Uri.fromFile(new File(str)).toString();
            }
            imageView.setImageDrawable(URLDrawable.getDrawable(str, drawable, drawable));
        }
        return view;
    }

    @Override // com.tencent.mobileqq.music.g
    public String getToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return QQPlayerService.Y(1, String.valueOf(this.uniseq));
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public View getView(Context context, View view, an anVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, this, context, view, anVar, bundle);
        }
        if (this.mMsgException) {
            View versionExceptionView = AbsStructMsg.getVersionExceptionView(context, view, anVar, bundle);
            versionExceptionView.setId(R.id.j59);
            versionExceptionView.setTag(R.id.j59, this);
            return versionExceptionView;
        }
        Resources resources = context.getResources();
        View inflate = LayoutInflater.from(context).inflate(R.layout.bzd, (ViewGroup) null);
        URLImageView uRLImageView = (URLImageView) inflate.findViewById(R.id.dgb);
        this.mCoverImage = new WeakReference<>(uRLImageView);
        TextView textView = (TextView) inflate.findViewById(R.id.kbs);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_summary);
        textView.setText(this.mContentTitle);
        textView2.setText(this.mContentSummary);
        if (!TextUtils.isEmpty(this.mContentTitle)) {
            textView2.setMaxLines(2);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            textView2.setMaxLines(4);
        }
        if (!TextUtils.isEmpty(this.mContentSummary)) {
            i3 = 2;
        }
        textView.setMaxLines(i3);
        uRLImageView.setVisibility(0);
        if (QQPlayerService.t0(this)) {
            uRLImageView.setImageResource(R.drawable.exw);
            uRLImageView.setContentDescription(resources.getString(R.string.f170493st));
        } else {
            uRLImageView.setImageResource(R.drawable.exv);
            uRLImageView.setContentDescription(resources.getString(R.string.f170491sr));
        }
        if (!TextUtils.isEmpty(this.mContentCover)) {
            String str = this.mContentCover;
            Drawable drawable = resources.getDrawable(R.drawable.f162489h31);
            try {
                int f16 = BaseAIOUtils.f(70.0f, resources);
                URLDrawable drawable2 = URLDrawable.getDrawable(str, f16, f16, drawable, drawable);
                if (!AbsDownloader.hasFile(str) && URLDrawableHelper.isMobileNetAndAutodownDisabled(context)) {
                    z16 = false;
                }
                drawable2.setAutoDownload(z16);
                uRLImageView.setBackgroundDrawable(drawable2);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AudioShareMsg", 2, "getView " + e16.getMessage());
                }
            }
        } else {
            uRLImageView.setBackgroundResource(R.drawable.f162489h31);
        }
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(BaseChatItemLayout.f178058p0, -2);
        } else {
            layoutParams.width = BaseChatItemLayout.f178058p0;
            layoutParams.height = -2;
        }
        inflate.setLayoutParams(layoutParams);
        uRLImageView.setTag(this);
        uRLImageView.setOnClickListener(this.musicShareCoverClikListener);
        inflate.setId(R.id.j59);
        inflate.setTag(R.id.j59, this);
        return inflate;
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlaySongChanged(SongInfo songInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) songInfo);
        }
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlayStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        WeakReference<URLImageView> weakReference = this.mCoverImage;
        if (weakReference != null && weakReference.get() != null) {
            URLImageView uRLImageView = this.mCoverImage.get();
            Resources resources = uRLImageView.getContext().getResources();
            if (i3 != 2 && i3 != 1) {
                uRLImageView.post(new Runnable(uRLImageView) { // from class: com.tencent.mobileqq.structmsg.StructMsgForAudioShare.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ URLImageView f290353d;

                    {
                        this.f290353d = uRLImageView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StructMsgForAudioShare.this, (Object) uRLImageView);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f290353d.setImageResource(R.drawable.exv);
                        }
                    }
                });
                uRLImageView.setContentDescription(resources.getString(R.string.f170491sr));
            } else {
                uRLImageView.post(new Runnable(uRLImageView) { // from class: com.tencent.mobileqq.structmsg.StructMsgForAudioShare.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ URLImageView f290352d;

                    {
                        this.f290352d = uRLImageView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StructMsgForAudioShare.this, (Object) uRLImageView);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f290352d.setImageResource(R.drawable.exw);
                        }
                    }
                });
                uRLImageView.setContentDescription(resources.getString(R.string.f170493st));
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    protected boolean parseContentNode(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.mContentLayout = k.d(jVar.a(TtmlNode.TAG_LAYOUT));
        if (jVar.b() >= 3) {
            j c16 = jVar.c(0);
            if (c16 != null) {
                this.mContentCover = c16.a("cover");
                this.mContentSrc = c16.a("src");
            }
            j c17 = jVar.c(1);
            if (c17 != null) {
                this.mContentTitle = s.c(i.h(c17), false);
            }
            j c18 = jVar.c(2);
            if (c18 != null) {
                this.mContentSummary = s.c(i.h(c18), false);
            }
        }
        return true;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectInput);
            return;
        }
        try {
            int readInt = objectInput.readInt();
            this.mVersion = readInt;
            if (readInt == 1) {
                this.mMsgTemplateID = objectInput.readInt();
                this.mMsgAction = objectInput.readUTF();
                this.mMsgActionData = objectInput.readUTF();
                this.mMsg_A_ActionData = objectInput.readUTF();
                this.mMsg_I_ActionData = objectInput.readUTF();
                this.mMsgUrl = objectInput.readUTF();
                this.mMsgBrief = objectInput.readUTF();
                this.mContentLayout = objectInput.readInt();
                this.mContentCover = objectInput.readUTF();
                this.mContentSrc = objectInput.readUTF();
                this.mContentTitle = objectInput.readUTF();
                this.mContentSummary = objectInput.readUTF();
                this.mSourceAppid = objectInput.readLong();
                this.mSourceIcon = objectInput.readUTF();
                this.mSourceName = objectInput.readUTF();
                this.mSourceUrl = objectInput.readUTF();
                this.mSourceAction = objectInput.readUTF();
                this.mSourceActionData = objectInput.readUTF();
                this.mSource_A_ActionData = objectInput.readUTF();
                this.mSource_I_ActionData = objectInput.readUTF();
                this.fwFlag = objectInput.readInt();
                if (!TextUtils.isEmpty(this.mSourceName) || !TextUtils.isEmpty(this.mSourceIcon)) {
                    this.mHasSource = true;
                }
            } else if (readInt >= 2) {
                this.mMsgTemplateID = objectInput.readInt();
                this.mMsgAction = objectInput.readUTF();
                this.mMsgActionData = objectInput.readUTF();
                this.mMsg_A_ActionData = objectInput.readUTF();
                this.mMsg_I_ActionData = objectInput.readUTF();
                this.mMsgUrl = objectInput.readUTF();
                this.mMsgBrief = objectInput.readUTF();
                this.mContentLayout = objectInput.readInt();
                this.mContentCover = objectInput.readUTF();
                this.mContentSrc = objectInput.readUTF();
                this.mContentTitle = objectInput.readUTF();
                this.mContentSummary = objectInput.readUTF();
                this.mSourceAppid = objectInput.readLong();
                this.mSourceIcon = objectInput.readUTF();
                this.mSourceName = objectInput.readUTF();
                this.mSourceUrl = objectInput.readUTF();
                this.mSourceAction = objectInput.readUTF();
                this.mSourceActionData = objectInput.readUTF();
                this.mSource_A_ActionData = objectInput.readUTF();
                this.mSource_I_ActionData = objectInput.readUTF();
                this.fwFlag = objectInput.readInt();
                this.mFlag = objectInput.readInt();
                this.mHasSource = objectInput.readBoolean();
                this.mCommentText = objectInput.readUTF();
                if (readInt >= 3) {
                    this.mCompatibleText = objectInput.readUTF();
                    this.msgId = objectInput.readLong();
                    this.mPromotionType = objectInput.readInt();
                    this.mPromotionMsg = objectInput.readUTF();
                    this.mPromotionMenus = objectInput.readUTF();
                    this.mPromotionMenuDestructiveIndex = objectInput.readInt();
                    if (readInt >= 5) {
                        this.source_puin = objectInput.readUTF();
                        if (readInt >= 7) {
                            this.adverSign = objectInput.readInt();
                            this.adverKey = objectInput.readUTF();
                            this.index = objectInput.readUTF();
                            this.index_name = objectInput.readUTF();
                            this.index_type = objectInput.readUTF();
                            if (readInt >= 15) {
                                this.forwardType = objectInput.readInt();
                                this.shareData.readExternal(objectInput);
                            }
                        }
                    }
                }
            } else {
                this.mMsgException = true;
            }
        } catch (IOException e16) {
            if (e16.getMessage() != null && e16.getMessage().equals("structmsg_version_error")) {
                this.mMsgException = true;
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public void report(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, obj);
        } else {
            jq3.a.n("2", this.uinType, this.mContentTitle, this.mSourceAppid);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    protected void toContentXml(AbsStructMsg.a aVar) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        aVar.startTag(null, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
        aVar.attribute(null, TtmlNode.TAG_LAYOUT, String.valueOf(this.mContentLayout));
        aVar.startTag(null, "audio");
        String str = this.mContentCover;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        aVar.attribute(null, "cover", str);
        String str3 = this.mContentSrc;
        if (str3 == null) {
            str3 = "";
        }
        aVar.attribute(null, "src", str3);
        aVar.endTag(null, "audio");
        aVar.startTag(null, "title");
        String str4 = this.mContentTitle;
        if (str4 == null) {
            str4 = "";
        }
        aVar.text(str4);
        aVar.endTag(null, "title");
        aVar.startTag(null, "summary");
        String str5 = this.mContentSummary;
        if (str5 != null) {
            str2 = str5;
        }
        aVar.text(str2);
        aVar.endTag(null, "summary");
        aVar.endTag(null, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        String c16;
        String c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) objectOutput);
            return;
        }
        objectOutput.writeInt(this.mMsgServiceID);
        objectOutput.writeInt(this.mVersion);
        objectOutput.writeInt(this.mMsgTemplateID);
        String str = this.mMsgAction;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.mMsgActionData;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        String str4 = this.mMsg_A_ActionData;
        if (str4 == null) {
            str4 = "";
        }
        objectOutput.writeUTF(str4);
        String str5 = this.mMsg_I_ActionData;
        if (str5 == null) {
            str5 = "";
        }
        objectOutput.writeUTF(str5);
        String str6 = this.mMsgUrl;
        if (str6 == null) {
            str6 = "";
        }
        objectOutput.writeUTF(str6);
        String str7 = this.mMsgBrief;
        if (str7 == null) {
            str7 = "";
        }
        objectOutput.writeUTF(str7);
        objectOutput.writeInt(this.mContentLayout);
        String str8 = this.mContentCover;
        if (str8 == null) {
            str8 = "";
        }
        objectOutput.writeUTF(str8);
        String str9 = this.mContentSrc;
        if (str9 == null) {
            str9 = "";
        }
        objectOutput.writeUTF(str9);
        String str10 = this.mContentTitle;
        if (str10 == null) {
            c16 = "";
        } else {
            c16 = s.c(str10, false);
        }
        objectOutput.writeUTF(c16);
        String str11 = this.mContentSummary;
        if (str11 == null) {
            c17 = "";
        } else {
            c17 = s.c(str11, false);
        }
        objectOutput.writeUTF(c17);
        objectOutput.writeLong(this.mSourceAppid);
        String str12 = this.mSourceIcon;
        if (str12 == null) {
            str12 = "";
        }
        objectOutput.writeUTF(str12);
        String str13 = this.mSourceName;
        if (str13 == null) {
            str13 = "";
        }
        objectOutput.writeUTF(str13);
        String str14 = this.mSourceUrl;
        if (str14 == null) {
            str14 = "";
        }
        objectOutput.writeUTF(str14);
        String str15 = this.mSourceAction;
        if (str15 == null) {
            str15 = "";
        }
        objectOutput.writeUTF(str15);
        String str16 = this.mSourceActionData;
        if (str16 == null) {
            str16 = "";
        }
        objectOutput.writeUTF(str16);
        String str17 = this.mSource_A_ActionData;
        if (str17 == null) {
            str17 = "";
        }
        objectOutput.writeUTF(str17);
        String str18 = this.mSource_I_ActionData;
        if (str18 == null) {
            str18 = "";
        }
        objectOutput.writeUTF(str18);
        objectOutput.writeInt(this.fwFlag);
        objectOutput.writeInt(this.mFlag);
        objectOutput.writeBoolean(this.mHasSource);
        String str19 = this.mCommentText;
        if (str19 == null) {
            str19 = "";
        }
        objectOutput.writeUTF(str19);
        String str20 = this.mCompatibleText;
        if (str20 == null) {
            str20 = "";
        }
        objectOutput.writeUTF(str20);
        objectOutput.writeLong(this.msgId);
        objectOutput.writeInt(this.mPromotionType);
        String str21 = this.mPromotionMsg;
        if (str21 == null) {
            str21 = "";
        }
        objectOutput.writeUTF(str21);
        String str22 = this.mPromotionMenus;
        if (str22 == null) {
            str22 = "";
        }
        objectOutput.writeUTF(str22);
        objectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
        String str23 = this.source_puin;
        if (str23 == null) {
            str23 = "";
        }
        objectOutput.writeUTF(str23);
        objectOutput.writeInt(this.adverSign);
        String str24 = this.adverKey;
        if (str24 == null) {
            str24 = "";
        }
        objectOutput.writeUTF(str24);
        String str25 = this.index;
        if (str25 == null) {
            str25 = "";
        }
        objectOutput.writeUTF(str25);
        String str26 = this.index_name;
        if (str26 == null) {
            str26 = "";
        }
        objectOutput.writeUTF(str26);
        String str27 = this.index_type;
        if (str27 == null) {
            str27 = "";
        }
        objectOutput.writeUTF(str27);
        objectOutput.writeInt(this.forwardType);
        this.shareData.writeExternal(objectOutput);
        String str28 = this.mCommonData;
        if (str28 != null) {
            str2 = str28;
        }
        objectOutput.writeUTF(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructMsgForAudioShare(Bundle bundle) {
        super(bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        this.musicShareCoverClikListener = new b();
        this.mContentSrc = bundle.getString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        this.mContentLayout = 2;
        this.mMsgServiceID = 2;
        this.mMsgAction = "web";
    }

    StructMsgForAudioShare(j jVar) {
        super(jVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
        } else {
            this.musicShareCoverClikListener = new b();
            this.mMsgServiceID = 2;
        }
    }
}
