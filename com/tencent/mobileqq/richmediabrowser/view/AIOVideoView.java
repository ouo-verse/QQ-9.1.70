package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController;
import com.tencent.mobileqq.richmediabrowser.subtitle.api.IDisplayVideoSubtitle;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.video.VideoView;
import com.tencent.util.Pair;
import com.tencent.util.PermissionUtil;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import vm2.SubtitleDisplayData;
import vm2.i;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOVideoView extends com.tencent.mobileqq.richmediabrowser.view.a implements View.OnClickListener, VideoPlayerCallback, e04.g {
    public com.tencent.mobileqq.richmediabrowser.presenter.e Q;
    public VideoView R;
    public RelativeLayout S;
    public TextView T;
    public ImageView U;
    public SeekBar V;
    public ImageButton W;
    private TVKVideoController X;
    public LinearLayout Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public long f282040a0;

    /* renamed from: b0, reason: collision with root package name */
    public ImageButton f282041b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f282042c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.richmediabrowser.f f282043d0;

    /* renamed from: e0, reason: collision with root package name */
    private VideoPlayParam f282044e0;

    /* renamed from: f0, reason: collision with root package name */
    private MessageRecord f282045f0;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> f282046g0;

    /* renamed from: h0, reason: collision with root package name */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> f282047h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f282048i0;

    /* renamed from: j0, reason: collision with root package name */
    private long f282049j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f282050k0;

    /* renamed from: l0, reason: collision with root package name */
    private final Runnable f282051l0;

    /* renamed from: m0, reason: collision with root package name */
    private final Runnable f282052m0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AIOVideoView.this.R.mVideoView.play();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AIOVideoView.this.R.mVideoView.pauseDownload();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f282057d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f282058e;

        c(int i3, Object obj) {
            this.f282057d = i3;
            this.f282058e = obj;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f282057d != 101) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showSaveFileTips type = " + this.f282057d);
                return;
            }
            Object obj = this.f282058e;
            if (obj instanceof AIOVideoData) {
                AIOVideoData aIOVideoData = (AIOVideoData) obj;
                AIOVideoView.this.Q.S(aIOVideoData);
                AIOVideoView.this.Q.R(aIOVideoData.msgId, aIOVideoData.subId, 7);
                AIOVideoView.this.updateUI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showSaveFileTips cancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends AccessibilityDelegateCompat {
        e() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(Button.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (32768 == accessibilityEvent.getEventType()) {
                AIOVideoData u06 = AIOVideoView.this.u0();
                String str = "\u6682\u505c";
                if (u06 != null && u06.status != 3) {
                    str = "\u64ad\u653e";
                }
                view.setContentDescription(str);
            }
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements i.a.InterfaceC11427a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIOVideoData f282062a;

        f(AIOVideoData aIOVideoData) {
            this.f282062a = aIOVideoData;
        }

        @Override // vm2.i.a.InterfaceC11427a
        public void a(boolean z16) {
            AIOVideoView.this.I0(z16, this.f282062a);
            AIOVideoView.this.a1(this.f282062a);
            AIOVideoView.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g extends VideoPlayParam {
        g() {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayParam
        public boolean isSameVideo(Object obj) {
            if (!(obj instanceof VideoPlayParam) || ((VideoPlayParam) obj).mStartPlayPosMs != this.mStartPlayPosMs) {
                return false;
            }
            return super.isSameVideo(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOVideoData f282065d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f282066e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f282067f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ RichMediaBrowserInfo f282068h;

        h(AIOVideoData aIOVideoData, File file, int i3, RichMediaBrowserInfo richMediaBrowserInfo) {
            this.f282065d = aIOVideoData;
            this.f282066e = file;
            this.f282067f = i3;
            this.f282068h = richMediaBrowserInfo;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0282  */
        /* JADX WARN: Removed duplicated region for block: B:54:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            RichMediaBrowserInfo selectedItem;
            RichMediaBaseData richMediaBaseData;
            if (actionSheetItem != null) {
                AIOVideoView aIOVideoView = AIOVideoView.this;
                if (aIOVideoView.f282077h instanceof Activity) {
                    aIOVideoView.f282075e.dismiss();
                    int i16 = actionSheetItem.action;
                    if (i16 != 2) {
                        int i17 = 4;
                        if (i16 != 3) {
                            if (i16 == 6) {
                                AIOVideoView.this.l0(this.f282065d);
                                AIOBrowserPresenter aIOBrowserPresenter = AIOVideoView.this.Q.f281859e;
                                if (aIOBrowserPresenter != null) {
                                    aIOBrowserPresenter.R(5);
                                }
                                i3 = 3;
                            } else {
                                if (i16 != 27) {
                                    if (i16 == 39) {
                                        AIOVideoView.this.k0(this.f282065d, this.f282066e, this.f282067f, this.f282068h, true);
                                    } else if (i16 != 54) {
                                        if (i16 == 64) {
                                            AIOVideoView.this.m0(this.f282065d);
                                            i17 = 7;
                                        } else if (i16 == 94) {
                                            AIOVideoView.this.t0();
                                            AIOBrowserPresenter aIOBrowserPresenter2 = AIOVideoView.this.Q.f281859e;
                                            if (aIOBrowserPresenter2 != null) {
                                                aIOBrowserPresenter2.R(4);
                                            }
                                        } else if (i16 != 166) {
                                            if (i16 == 179) {
                                                AIOVideoView.this.s0();
                                                AIOVideoView.this.N0();
                                                i17 = 8;
                                            } else if (i16 == 184) {
                                                AIOVideoView.this.q0(this.f282066e, this.f282065d);
                                            } else if (i16 != 72 && i16 != 73) {
                                                if (i16 != 126) {
                                                    if (i16 != 127) {
                                                        i17 = AIOVideoView.this.w0(this.f282065d, i16, actionSheetItem);
                                                    } else {
                                                        IVideoDepend iVideoDepend = (IVideoDepend) QRoute.api(IVideoDepend.class);
                                                        AIOVideoView aIOVideoView2 = AIOVideoView.this;
                                                        Context context = aIOVideoView2.f282077h;
                                                        String str = aIOVideoView2.f282048i0;
                                                        AIOVideoData aIOVideoData = this.f282065d;
                                                        iVideoDepend.onQRDecodeSucceed(context, str, aIOVideoData.istroop, false, aIOVideoData.F, "", "", "", 2, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g());
                                                        AIOVideoView.this.P0("0X800ACB8", this.f282065d.istroop);
                                                    }
                                                } else {
                                                    IVideoDepend iVideoDepend2 = (IVideoDepend) QRoute.api(IVideoDepend.class);
                                                    AIOVideoView aIOVideoView3 = AIOVideoView.this;
                                                    Context context2 = aIOVideoView3.f282077h;
                                                    String str2 = aIOVideoView3.f282048i0;
                                                    AIOVideoData aIOVideoData2 = this.f282065d;
                                                    iVideoDepend2.onQRDecodeSucceed(context2, str2, aIOVideoData2.istroop, false, aIOVideoData2.F, "", "", "", 1, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g());
                                                    AIOVideoView.this.P0("0X800ACB7", this.f282065d.istroop);
                                                }
                                            }
                                        } else {
                                            ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity) AIOVideoView.this.f282077h, this.f282066e.getAbsolutePath());
                                        }
                                    } else {
                                        ReportController.o(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", com.tencent.mobileqq.richmediabrowser.h.a().c(), 0, "", "", "", "");
                                        String i18 = com.tencent.mobileqq.richmediabrowser.h.a().i();
                                        if (TextUtils.isEmpty(i18)) {
                                            i18 = com.tencent.mobileqq.richmediabrowser.h.a().g();
                                        }
                                        String str3 = i18;
                                        IMsgLocationApi iMsgLocationApi = (IMsgLocationApi) QRoute.api(IMsgLocationApi.class);
                                        Activity activity = (Activity) AIOVideoView.this.f282077h;
                                        int f16 = com.tencent.mobileqq.richmediabrowser.h.a().f();
                                        String g16 = com.tencent.mobileqq.richmediabrowser.h.a().g();
                                        AIOVideoData aIOVideoData3 = this.f282065d;
                                        iMsgLocationApi.jumpToTargetNTAIOPosition(activity, f16, g16, str3, aIOVideoData3.shmsgseq, aIOVideoData3.msgId);
                                        AIOBrowserPresenter aIOBrowserPresenter3 = AIOVideoView.this.Q.f281859e;
                                        if (aIOBrowserPresenter3 != null) {
                                            aIOBrowserPresenter3.R(6);
                                        }
                                    }
                                    i3 = 0;
                                } else if (AIOVideoView.this.f282043d0 != null && AIOVideoView.this.f282043d0.n()) {
                                    AIOVideoView.this.f282043d0.f(this.f282065d.msgId);
                                    Context context3 = AIOVideoView.this.f282077h;
                                    QQToast.makeText(context3, context3.getString(R.string.f221626bb), 0).show();
                                }
                                i3 = 6;
                            }
                            String W0 = AIOPictureView.W0(this.f282065d);
                            String V0 = AIOPictureView.V0();
                            QLog.i("AIOVideoView", 2, "reportClickEvent 0X8009EF9/0X8009EF8 sessionType=" + W0 + "enterType=" + V0);
                            selectedItem = AIOVideoView.this.Q.f281861h.getSelectedItem();
                            if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null && AIOVideoData.class.isInstance(richMediaBaseData)) {
                                int i19 = ((AIOVideoData) selectedItem.baseData).f281846h;
                                if (i19 == 0) {
                                    ReportController.o(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i3, 0, W0, V0, "", "");
                                    return;
                                } else {
                                    if (i19 == 1) {
                                        ReportController.o(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i3, 0, W0, V0, "", "");
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        ((IVideoDepend) QRoute.api(IVideoDepend.class)).sendToQZone((Activity) AIOVideoView.this.f282077h, com.tencent.mobileqq.richmediabrowser.h.a().m(), this.f282066e.getAbsolutePath());
                        ReportController.o(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
                        i3 = i17;
                        String W02 = AIOPictureView.W0(this.f282065d);
                        String V02 = AIOPictureView.V0();
                        QLog.i("AIOVideoView", 2, "reportClickEvent 0X8009EF9/0X8009EF8 sessionType=" + W02 + "enterType=" + V02);
                        selectedItem = AIOVideoView.this.Q.f281861h.getSelectedItem();
                        if (selectedItem != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    AIOVideoView.this.n0(this.f282065d, i16, actionSheetItem);
                    i3 = 1;
                    String W022 = AIOPictureView.W0(this.f282065d);
                    String V022 = AIOPictureView.V0();
                    QLog.i("AIOVideoView", 2, "reportClickEvent 0X8009EF9/0X8009EF8 sessionType=" + W022 + "enterType=" + V022);
                    selectedItem = AIOVideoView.this.Q.f281861h.getSelectedItem();
                    if (selectedItem != null) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j extends QQPermission.BasePermissionsListener {
        j() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class k {

        /* renamed from: a, reason: collision with root package name */
        public BaseVideoView f282072a;

        public k() {
        }
    }

    public AIOVideoView(Context context, com.tencent.mobileqq.richmediabrowser.presenter.e eVar) {
        super(context, eVar);
        this.f282040a0 = 0L;
        this.f282046g0 = new ArrayList<>();
        this.f282047h0 = new ArrayList<>();
        this.f282048i0 = "";
        this.f282049j0 = -1L;
        this.f282050k0 = false;
        this.f282051l0 = new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                AIOVideoView.this.Q.p().f281782d = true;
                AIOVideoView.this.m(false);
                AIOVideoView.this.c1(0);
                AIOVideoView.this.updateUI();
            }
        };
        this.f282052m0 = new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                xm2.c.f448170a.b(AIOVideoView.this.f282077h);
                AIOVideoView.this.Q.g();
                QLog.i("AIOVideoView", 1, "aioVideoViewSubtitle, showSubtitleTimeoutRunnable, invoke getVideoSubtitle method timeout. ");
            }
        };
        this.Q = eVar;
    }

    private boolean A0(AIOVideoData aIOVideoData, File file) {
        if (file != null && file.exists()) {
            long length = file.length();
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + file.getPath() + ", mTransferredSize = " + length + ", data.size = " + aIOVideoData.size);
            if (!((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isShortVideoType(aIOVideoData.f281846h) && length < aIOVideoData.size) {
                return true;
            }
            return false;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        return true;
    }

    private void C0() {
        AIOVideoData u06 = u0();
        if (u06 != null && !TextUtils.isEmpty(u06.M) && (this.f282077h instanceof Activity)) {
            ((IJumpUtil) QRoute.api(IJumpUtil.class)).jumpToCameraActivityForAio((Activity) this.f282077h, u06.M);
            ReportController.o(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", u06.M, "");
        }
    }

    private void D0() {
        if (this.f282077h instanceof BaseActivity) {
            C0();
            return;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onClick, activity:" + this.f282077h);
    }

    private void E0() {
        long j3;
        AIOVideoData W = this.Q.W();
        if (W != null && (this.f282077h instanceof Activity)) {
            BaseVideoView baseVideoView = this.R.mVideoView;
            if (baseVideoView != null) {
                j3 = baseVideoView.getCurPlayingPos();
            } else {
                j3 = 0;
            }
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity) this.f282077h, com.tencent.mobileqq.richmediabrowser.h.a().f(), com.tencent.mobileqq.richmediabrowser.h.a().i(), false, W.shmsgseq, j3);
        }
        if (W != null && W.status == 3) {
            this.Q.T(W.msgId, true);
            J0();
        }
        this.Q.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(Bitmap bitmap) {
        if (bitmap == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, videoFrame null");
                return;
            }
            return;
        }
        try {
            File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "tmpaiovideoframe.jpg");
            if (!file.exists()) {
                file.createNewFile();
            }
            this.f282048i0 = file.getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, write tmp file:" + this.f282048i0);
            }
            RichMediaBrowserUtils.i(bitmap, this.f282048i0);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        final ArrayList arrayList = new ArrayList();
        Pair<Boolean, Boolean> hasCode = ((IVideoDepend) QRoute.api(IVideoDepend.class)).hasCode(bitmap);
        if (hasCode.first.booleanValue()) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, detected QRCode, build item");
            }
            RichMediaBrowserUtils.b(126, arrayList, this.f282048i0, 0);
        }
        if (hasCode.second.booleanValue()) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, detected MiniCode, build item");
            }
            RichMediaBrowserUtils.b(127, arrayList, this.f282048i0, 0);
        }
        if (arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, detected nothing");
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AIOVideoView.this.f282047h0.add(AIOVideoView.this.f282047h0.size() - 1, (ShareActionSheetBuilder.ActionSheetItem) it.next());
                }
                AIOVideoView aIOVideoView = AIOVideoView.this;
                aIOVideoView.f282075e.setActionSheetItems(aIOVideoView.f282046g0, AIOVideoView.this.f282047h0);
                if (AIOVideoView.this.f282075e.isShowing()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, refresh share menu");
                    }
                    AIOVideoView.this.f282075e.refresh();
                    return;
                }
                AIOVideoView.this.f282075e.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(boolean z16, AIOVideoData aIOVideoData) {
        int i3;
        vm2.k kVar = vm2.k.f441884a;
        kVar.h(z16);
        this.Q.h(z16);
        xm2.b bVar = xm2.b.f448169a;
        Context context = this.f282077h;
        if (z16) {
            i3 = R.string.f221956c8;
        } else {
            i3 = R.string.f221946c7;
        }
        bVar.c(context, i3);
        vm2.c.f441865a.a(!z16);
        if (!z16) {
            kVar.j(this.R, this.Q, this.f282052m0);
        }
    }

    private void J0() {
        VideoView videoView = this.R;
        if (videoView != null) {
            videoView.pauseVideo();
        }
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar.z(eVar.f281859e.getCurrentPosition())) {
            this.Q.I(true);
        }
    }

    private void K0() {
        AIOVideoData W = this.Q.W();
        if (W != null && W.status != 7) {
            b1(this.Q.f281861h.getCurrentPosition(), false);
        }
        v();
    }

    private void L0(tm2.f fVar, long j3) {
        int i3;
        if (fVar == null) {
            return;
        }
        AIOVideoData u06 = u0();
        if (u06 != null) {
            i3 = u06.status;
        } else {
            i3 = -1;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo id = " + fVar.f436617k);
        this.Q.R(fVar.f436617k, fVar.f436618l, 3);
        updateUI();
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.U(0L, 0L, com.tencent.mobileqq.richmediabrowser.h.a().g());
        }
        this.R.setVideoPlayCallback(this);
        if (this.R.mVideoView != null) {
            if (i3 != 4) {
                if (j3 > -1) {
                    fVar.f436623q = j3;
                }
                R0(fVar);
            }
            this.R.mVideoView.play();
            a1(u06);
        }
    }

    private void M0() {
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.R(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.L();
        }
    }

    private void O0(long j3, VideoPlayParam videoPlayParam) {
        String str;
        if (!this.Q.Z(j3)) {
            long V = this.Q.V(j3);
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoView", 2, "reportForVideoStartPlayCost, id:" + j3 + ", clickBubbleTime = " + V);
            }
            if (V > 0) {
                long currentTimeMillis = System.currentTimeMillis() - V;
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("timeCost", String.valueOf(currentTimeMillis));
                hashMap.put(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, videoPlayParam.mSceneName);
                if (videoPlayParam.mIsLocal) {
                    str = "actVideoFSPlayCost";
                } else {
                    str = "acVideoFSPlayCost_Online";
                }
                String str2 = str;
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "report video start play cost , reportName = " + str2 + " , timeCost = " + currentTimeMillis + " , busiType = " + videoPlayParam.mSceneName);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str2, true, currentTimeMillis, 0L, hashMap, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(String str, int i3) {
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 1) {
                i16 = 2;
            } else if (i3 == 3000) {
                i16 = 3;
            } else if (i3 == 6000) {
                i16 = 4;
            } else {
                i16 = -1;
            }
        }
        ReportController.o(null, "dc00898", "", "", str, str, i16, 0, "", "0", "0", "");
    }

    private void R0(tm2.f fVar) {
        VideoPlayParam f06 = f0(fVar);
        this.f282044e0 = f06;
        VideoView videoView = this.R;
        if (videoView != null) {
            videoView.setVideoPlayCallback(f06);
            this.R.mVideoView.setVideoParam(this.f282044e0);
        }
    }

    private void S0(AIOVideoData aIOVideoData, int i3) {
        boolean z16;
        Intent intent;
        int i16;
        File c16 = new tm2.e().c(aIOVideoData, 1);
        RichMediaBrowserInfo selectedItem = this.Q.f281861h.getSelectedItem();
        this.f282046g0.clear();
        this.f282047h0.clear();
        boolean A0 = A0(aIOVideoData, c16);
        boolean z17 = false;
        if (aIOVideoData.f281846h == 1 && A0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            RichMediaBrowserUtils.a(2, this.f282046g0);
        }
        if (aIOVideoData.f281846h == 4601) {
            RichMediaBrowserUtils.a(171, this.f282046g0);
        }
        vm2.k kVar = vm2.k.f441884a;
        if (kVar.l(aIOVideoData.f281846h)) {
            if (kVar.i(aIOVideoData.f281846h)) {
                i16 = 202;
            } else {
                i16 = 201;
            }
            RichMediaBrowserUtils.a(i16, this.f282047h0);
        }
        RichMediaBrowserUtils.a(179, this.f282047h0);
        Context context = this.f282077h;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null && intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_ENABLED, false)) {
            z17 = true;
        }
        if (aIOVideoData.f281846h != 1 || !A0) {
            RichMediaBrowserUtils.a(39, this.f282047h0);
        }
        if (com.tencent.mobileqq.richmediabrowser.utils.h.c() && z17) {
            RichMediaBrowserUtils.a(94, this.f282047h0);
        }
        if (!A0) {
            RichMediaBrowserUtils.a(6, this.f282047h0);
            RichMediaBrowserUtils.a(3, this.f282046g0);
            RichMediaBrowserUtils.a(27, this.f282046g0);
        }
        if (com.tencent.mobileqq.richmediabrowser.h.a().r() && !TextUtils.isEmpty(com.tencent.mobileqq.richmediabrowser.h.a().g()) && com.tencent.mobileqq.richmediabrowser.h.a().f() != -1) {
            RichMediaBrowserUtils.a(54, this.f282047h0);
        }
        if (!A0 && c16 != null && ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).isFileSupported(c16.getAbsolutePath())) {
            RichMediaBrowserUtils.a(166, this.f282046g0);
        }
        if (!A0 && ((IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class)).isSupportVideoFormat(aIOVideoData.C, aIOVideoData.D, (int) (aIOVideoData.f281845f * 1000))) {
            RichMediaBrowserUtils.a(184, this.f282046g0);
        }
        if (!A0) {
            RichMediaBrowserUtils.a(64, this.f282046g0);
        }
        Q0(aIOVideoData, c16, i3, selectedItem);
        Context context2 = this.f282077h;
        if (context2 instanceof Activity) {
            ((Activity) context2).getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
        }
        this.f282075e.setActionSheetItems(this.f282046g0, this.f282047h0);
        if (z16) {
            p0(aIOVideoData);
        }
        this.f282075e.show();
    }

    private void V0(boolean z16) {
        RichMediaBrowserInfo selectedItem;
        if (z16 && (selectedItem = this.Q.f281861h.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData = selectedItem.baseData;
            if ((richMediaBaseData instanceof AIOVideoData) && this.Q.X((AIOVideoData) richMediaBaseData) == null) {
                z16 = false;
            }
        }
        this.f282050k0 = z16;
    }

    private void Z0(boolean z16) {
        int i3;
        View view = this.f282042c0;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(AIOVideoData aIOVideoData) {
        if (aIOVideoData != null) {
            vm2.k kVar = vm2.k.f441884a;
            if (kVar.l(aIOVideoData.f281846h)) {
                tm2.f X = this.Q.X(aIOVideoData);
                if (X != null && this.R != null) {
                    ((IDisplayVideoSubtitle) QRoute.api(IDisplayVideoSubtitle.class)).start(new SubtitleDisplayData(X.f436608b, aIOVideoData, this.Q, this.R, this.f282077h, this.f282052m0, kVar.f(aIOVideoData.size)));
                    return;
                }
                return;
            }
        }
        QLog.i("AIOVideoView", 1, "aioVideoViewSubtitle, startIdentifyVideoSubtitle, do return.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(int i3, boolean z16) {
        RichMediaBaseData richMediaBaseData;
        long j3;
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoView", 2, "tryPlayVideo, position = ", Integer.valueOf(i3), ", isAutoPlay = ", Boolean.valueOf(z16));
        }
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 101) {
            AIOVideoData aIOVideoData = (AIOVideoData) item.baseData;
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoView", 2, "tryPlayVideo, position = " + i3 + " , msgId = " + aIOVideoData.msgId);
            }
            aIOVideoData.Q = i3;
            aIOVideoData.I = z16;
            this.Q.d0(aIOVideoData.msgId, !z16);
            tm2.f X = this.Q.X(aIOVideoData);
            if (X == null) {
                this.Q.Y(aIOVideoData);
                this.Q.R(aIOVideoData.msgId, aIOVideoData.subId, 1);
                updateUI();
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = " + aIOVideoData.msgId + ", shortVideoData.subId = " + aIOVideoData.subId);
                return;
            }
            if (z16) {
                j3 = com.tencent.mobileqq.richmediabrowser.h.a().f281827w;
            } else {
                j3 = -1;
            }
            L0(X, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(int i3) {
        AIOVideoData u06 = u0();
        if (u06 != null) {
            this.Q.R(u06.msgId, u06.subId, i3);
        }
    }

    private void d1() {
        BaseVideoView baseVideoView;
        VideoView videoView = this.R;
        if (videoView != null && (baseVideoView = videoView.mVideoView) != null && !baseVideoView.isPlaying()) {
            J0();
        } else {
            c1(3);
        }
    }

    private void e1() {
        W0(false);
        V0(true);
        K(this.R, 5);
        J(this.Q, 5);
        this.P.postDelayed(this.f282051l0, 3000L);
    }

    private VideoPlayParam f0(tm2.f fVar) {
        VideoView videoView;
        VideoPlayParam gVar = new g();
        MessageRecord messageRecord = fVar.f436612f;
        this.f282045f0 = messageRecord;
        gVar.mSceneId = 101;
        gVar.mSceneName = SceneID.getSceneStr(101) + "_FulScr";
        AIOVideoData u06 = u0();
        if (u06 != null && ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isShortVideoType(u06.f281846h)) {
            gVar.mSceneId = 100;
            gVar.mSceneName = SceneID.getSceneStr(100) + "_FulScr";
        }
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar != null) {
            gVar.mIsMute = eVar.b0(fVar.f436617k);
        }
        if (!gVar.mIsMute && (videoView = this.R) != null) {
            videoView.requestAudioFocus();
        }
        boolean z16 = fVar.f436607a;
        if (z16) {
            gVar.mUrls = fVar.f436609c;
            gVar.mSavePath = fVar.f436608b;
        } else {
            gVar.mVideoPath = fVar.f436608b;
        }
        gVar.mIsLocal = !z16;
        if (messageRecord != null && this.R != null) {
            gVar = ((IVideoDepend) QRoute.api(IVideoDepend.class)).buildVideoPlayParam(messageRecord, gVar);
            if (gVar != null) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo, videoDuration = " + gVar.mVideoFileTimeMs);
                this.R.totalTime.setText(com.tencent.richmediabrowser.utils.a.b(gVar.mVideoFileTimeMs));
            }
            this.R.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(0L));
        }
        if (gVar != null) {
            gVar.mIsLoop = false;
            gVar.mNeedPlayProgress = true;
            long j3 = fVar.f436623q;
            if (j3 > 0) {
                gVar.mStartPlayPosMs = j3;
            }
        }
        return gVar;
    }

    private void g0(boolean z16, View view) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable") && AppSetting.f99565y) {
            CharSequence contentDescription = view.getContentDescription();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u5df2\u5207\u6362\u5230");
            if (z16) {
                str = "\u64ad\u653e";
            } else {
                str = "\u6682\u505c";
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(contentDescription) && contentDescription.toString().equals(sb6)) {
                return;
            }
            view.setContentDescription(sb6);
            view.sendAccessibilityEvent(4);
        }
    }

    private void j0(AIOVideoData aIOVideoData) {
        if (vm2.k.f441884a.l(aIOVideoData.f281846h) && (this.f282077h instanceof Activity)) {
            i.a.f441881a.j(this.Q, this.f282078i, new WeakReference((Activity) this.f282077h), new f(aIOVideoData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(AIOVideoData aIOVideoData, File file, int i3, RichMediaBrowserInfo richMediaBrowserInfo, boolean z16) {
        if (aIOVideoData.G == 5002) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
            QQToast.makeText(this.f282077h, 1, R.string.f221826bv, 0).show();
            return;
        }
        if (!PermissionUtil.isHasStoragePermission(this.f282077h) && (this.f282077h instanceof Activity)) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission((Activity) this.f282077h, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC));
            if (qQPermission != null) {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new j());
                return;
            }
            return;
        }
        if (((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isShortVideoType(aIOVideoData.f281846h)) {
            this.Q.e0(i3, file);
        } else if (file != null && file.exists() && file.length() == aIOVideoData.size) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append((file.getParentFile().getName() + NetConnInfoCenter.getServerTime()).toLowerCase(Locale.US));
            sb5.append(".mp4");
            ThreadManager.getFileThreadHandler().post(((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getVideoFileSaveRunnable(file.getAbsolutePath(), this.Q.E, sb5.toString(), false));
        } else if (!AppNetConnInfo.isNetSupport()) {
            this.Q.E.sendEmptyMessage(((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getVideoSaveFailCode());
        } else if (!AppNetConnInfo.isWifiConn() && aIOVideoData.size > 29360128) {
            Y0(101, aIOVideoData, richMediaBrowserInfo);
        } else {
            this.Q.S(aIOVideoData);
            this.Q.R(aIOVideoData.msgId, aIOVideoData.subId, 7);
            updateUI();
            BaseVideoView baseVideoView = this.R.mVideoView;
            if (baseVideoView != null) {
                baseVideoView.pause();
            }
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            if (z16) {
                aIOBrowserPresenter.R(3);
            } else {
                aIOBrowserPresenter.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(AIOVideoData aIOVideoData) {
        Intent u16;
        com.tencent.mobileqq.richmediabrowser.f fVar = this.f282043d0;
        if (fVar != null && fVar.n() && (u16 = this.f282043d0.u(aIOVideoData.msgId, aIOVideoData.subId, com.tencent.mobileqq.richmediabrowser.h.a().f())) != null && (this.f282077h instanceof Activity)) {
            ((IVideoDepend) QRoute.api(IVideoDepend.class)).dealAddFavorite(u16, (Activity) this.f282077h, null, 3, 0, aIOVideoData.istroop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(AIOVideoData aIOVideoData) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setDataAndType(Uri.parse("file://" + aIOVideoData.f281844e), "video/*");
        intent.putExtra("big_brother_source_key", " biz_src_jc_video");
        this.f282077h.startActivity(intent);
        int i3 = aIOVideoData.istroop;
        if (i3 == 0) {
            ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
            return;
        }
        if (i3 == 3000) {
            ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
        } else if (i3 == 1) {
            ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(AIOVideoData aIOVideoData, int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        Intent u16;
        if (aIOVideoData != null && (fVar = this.f282043d0) != null && fVar.n() && (u16 = this.f282043d0.u(aIOVideoData.msgId, aIOVideoData.subId, com.tencent.mobileqq.richmediabrowser.h.a().f())) != null && (this.f282077h instanceof Activity)) {
            u16.putExtra("NeedReportForwardShortVideo", true);
            ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).dealSendToFriend((Activity) this.f282077h, u16, aIOVideoData.M, aIOVideoData.N, i3, actionSheetItem);
        }
        if (com.tencent.mobileqq.richmediabrowser.h.a().q() && this.Q.f281859e != null) {
            AIOBrowserPresenter.D("0X8009ABC");
        }
    }

    private void o0(AIOVideoData aIOVideoData, int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        Intent u16;
        if (aIOVideoData != null && (fVar = this.f282043d0) != null && fVar.n() && (u16 = this.f282043d0.u(aIOVideoData.msgId, aIOVideoData.subId, com.tencent.mobileqq.richmediabrowser.h.a().f())) != null && (this.f282077h instanceof Activity)) {
            u16.putExtra("NeedReportForwardShortVideo", true);
            ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).dealSendToGuild((Activity) this.f282077h, u16, aIOVideoData.M, aIOVideoData.N, i3, actionSheetItem);
        }
        if (com.tencent.mobileqq.richmediabrowser.h.a().q() && this.Q.f281859e != null) {
            AIOBrowserPresenter.D("0X8009ABC");
        }
    }

    private void p0(AIOVideoData aIOVideoData) {
        Intent u16;
        com.tencent.mobileqq.richmediabrowser.f fVar = this.f282043d0;
        if (fVar != null && fVar.n() && (u16 = this.f282043d0.u(aIOVideoData.msgId, aIOVideoData.subId, com.tencent.mobileqq.richmediabrowser.h.a().f())) != null) {
            u16.putExtra("NeedReportForwardShortVideo", true);
            if (this.Q.f281861h.getSelectedItem() != null) {
                RichMediaBaseData richMediaBaseData = this.Q.f281861h.getSelectedItem().baseData;
                if (richMediaBaseData instanceof AIOVideoData) {
                    AIOVideoData aIOVideoData2 = (AIOVideoData) richMediaBaseData;
                    if (!TextUtils.isEmpty(aIOVideoData2.M)) {
                        u16.putExtra(((IVideoDepend) QRoute.api(IVideoDepend.class)).getCameraVideoParam(), aIOVideoData2.M);
                        u16.putExtra(((IVideoDepend) QRoute.api(IVideoDepend.class)).getCameraMaterialName(), aIOVideoData2.N);
                    }
                }
            }
            this.f282075e.setIntentForStartForwardRecentActivity(u16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(File file, AIOVideoData aIOVideoData) {
        String i3;
        if (file != null && aIOVideoData != null) {
            Intent intent = new Intent();
            Context context = this.f282077h;
            if (context instanceof Activity) {
                intent = ((Activity) context).getIntent();
            }
            int i16 = aIOVideoData.istroop;
            if (i16 != 1) {
                if (i16 != 10014) {
                    i3 = "";
                } else {
                    i3 = com.tencent.mobileqq.richmediabrowser.h.a().j();
                }
            } else {
                i3 = com.tencent.mobileqq.richmediabrowser.h.a().i();
                if (TextUtils.isEmpty(i3)) {
                    i3 = com.tencent.mobileqq.richmediabrowser.h.a().g();
                }
            }
            String str = i3;
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).innerBizShareToQCircle(this.f282077h, file.getAbsolutePath(), i16, str, intent.getStringExtra(PeakConstants.KEY_TROOP_GROUP_NAME), Long.valueOf(aIOVideoData.shmsgseq));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap r0(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoView", 2, "drawable2Bitmap, drawable is null");
                return null;
            }
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        long j3;
        AIOVideoData u06 = u0();
        if (u06 != null) {
            TVKVideoController tVKVideoController = this.X;
            if (tVKVideoController != null) {
                tVKVideoController.r();
            }
            BaseVideoView baseVideoView = this.R.mVideoView;
            if (baseVideoView != null) {
                j3 = baseVideoView.getCurPlayingPos();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            this.X = new TVKVideoController(this.f282077h);
            tm2.f X = this.Q.X(u06);
            if (X != null) {
                this.X.x(X, u06.E, j16);
                this.X.u(u06.f281843d, u06.C, u06.D);
                if (this.X.s(u06.istroop, u06.C, u06.D)) {
                    this.Q.back();
                    return;
                }
                return;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        AIOVideoData W = this.Q.W();
        if (W == null) {
            QLog.e("AIOVideoView", 1, "enterVideoEditPage error, aioVideoData is null!");
            return;
        }
        Context context = this.f282077h;
        if (!(context instanceof Activity)) {
            QLog.e("AIOVideoView", 1, "enterVideoEditPage error, mContext is not instance of Activity!");
            return;
        }
        Activity activity = (Activity) context;
        if (!q.p(W.f281844e)) {
            QQToast.makeText(activity, activity.getResources().getString(R.string.f237747hw), 0).show();
        } else {
            if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
                QQToast.makeText(activity, activity.getResources().getString(R.string.f237737hv), 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtras(activity.getIntent());
            ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(activity, intent, RichMediaBrowserUtils.c(1, W.f281844e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w0(AIOVideoData aIOVideoData, int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (i3 != 171) {
            if (i3 != 201) {
                if (i3 != 202) {
                    return 0;
                }
                I0(false, aIOVideoData);
                M0();
                return 0;
            }
            I0(true, aIOVideoData);
            M0();
            return 0;
        }
        o0(aIOVideoData, i3, actionSheetItem);
        return 9;
    }

    private void x0(int i3, int i16, VideoPlayParam videoPlayParam) {
        String str;
        tm2.f X;
        if (i3 == 2 && (X = this.Q.X(u0())) != null && X.f436609c != null && !StringUtil.isEmpty(X.f436611e)) {
            for (String str2 : X.f436609c) {
                if (!StringUtil.isEmpty(str2)) {
                    InnerDns.getInstance().reportBadIp(X.f436611e, InnerDns.getHostFromUrl(str2), ((IVideoDepend) QRoute.api(IVideoDepend.class)).getVideoIpType());
                }
            }
            com.tencent.mobileqq.richmediabrowser.utils.g.e().c();
        }
        if (i3 == 1) {
            str = this.f282077h.getString(R.string.f222006cc);
        } else {
            str = null;
        }
        if (i16 == 14011001) {
            str = this.f282077h.getString(R.string.f221996cb);
            this.Q.f0(5002, 0L);
        }
        final AIOVideoData u06 = u0();
        if (u06 != null) {
            if (str == null) {
                str = this.f282077h.getString(R.string.f221936c6);
            }
            u06.H = str;
            u06.P++;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, videoData.mPlayErrTimes = " + u06.P);
        }
        if (com.tencent.mobileqq.qqvideoplatform.a.a(i16, videoPlayParam) && this.R.mVideoView != null && u06 != null && u06.P < 2) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, auto replay video.");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.4
                @Override // java.lang.Runnable
                public void run() {
                    AIOVideoView aIOVideoView = AIOVideoView.this;
                    AIOVideoData aIOVideoData = u06;
                    aIOVideoView.b1(aIOVideoData.Q, aIOVideoData.I);
                }
            });
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.5
                @Override // java.lang.Runnable
                public void run() {
                    AIOVideoView.this.c1(6);
                    AIOVideoView.this.updateUI();
                }
            });
        }
    }

    private void y0() {
        boolean z16;
        Intent intent;
        RelativeLayout relativeLayout = this.H;
        if (relativeLayout != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.ffe);
            ImageButton imageButton = (ImageButton) this.H.findViewById(R.id.m2d);
            this.W = imageButton;
            imageButton.setContentDescription(this.f282077h.getString(R.string.f221606b_));
            this.W.setOnClickListener(this);
            this.W.setVisibility(8);
            VideoView videoView = this.R;
            if (videoView != null) {
                videoView.initContentView(this.H);
            }
            z0(this.H);
            RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout2.findViewById(R.id.kjb);
            this.S = relativeLayout3;
            SeekBar seekBar = (SeekBar) relativeLayout3.findViewById(R.id.kjd);
            this.V = seekBar;
            seekBar.setMax(10000);
            this.T = (TextView) this.S.findViewById(R.id.kjc);
            ImageView imageView = (ImageView) this.S.findViewById(R.id.f164822az1);
            this.U = imageView;
            imageView.setOnClickListener(this);
            ImageButton imageButton2 = (ImageButton) this.H.findViewById(R.id.cp5);
            this.E = imageButton2;
            imageButton2.setOnClickListener(this);
            ImageButton imageButton3 = (ImageButton) this.H.findViewById(R.id.f59252s8);
            this.f282079m = imageButton3;
            imageButton3.setOnClickListener(this);
            ImageButton imageButton4 = (ImageButton) this.H.findViewById(R.id.gqp);
            this.C = imageButton4;
            imageButton4.setOnClickListener(this);
            boolean z17 = false;
            if ((this.f282077h instanceof Activity) && !com.tencent.mobileqq.richmediabrowser.utils.h.c() && (intent = ((Activity) this.f282077h).getIntent()) != null && intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_ENABLED, false)) {
                z16 = true;
            } else {
                z16 = false;
            }
            F(z16);
            ImageButton imageButton5 = (ImageButton) this.H.findViewById(R.id.f59282sa);
            this.D = imageButton5;
            imageButton5.setOnClickListener(this);
            AIOVideoData u06 = u0();
            if (com.tencent.mobileqq.richmediabrowser.utils.h.c() && (u06 == null || u06.f281846h != 1 || !A0(u06, new tm2.e().c(u06, 1)))) {
                z17 = true;
            }
            H(z17);
            ImageButton imageButton6 = (ImageButton) this.H.findViewById(R.id.cq7);
            this.f282041b0 = imageButton6;
            imageButton6.setOnClickListener(this);
            AccessibilityUtil.s(this.f282041b0, this.f282077h.getString(R.string.f221566b6));
            this.Y = (LinearLayout) this.H.findViewById(R.id.f164720x7);
            this.Z = (TextView) this.H.findViewById(R.id.f164721xu);
            this.Y.setOnClickListener(this);
            this.Y.setVisibility(8);
            this.f282042c0 = this.H.findViewById(R.id.jmw);
            ImageButton imageButton7 = (ImageButton) this.H.findViewById(R.id.gqo);
            this.f282078i = imageButton7;
            imageButton7.setOnClickListener(this);
        }
        VideoView videoView2 = this.R;
        if (videoView2 != null && !videoView2.isInExitAnim) {
            C(true);
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.O();
        }
    }

    private void z0(View view) {
        View findViewById;
        View findViewById2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable") || !AppSetting.f99565y || (findViewById = view.findViewById(R.id.fac)) == null || (findViewById2 = findViewById.findViewById(R.id.fff)) == null || (ViewCompat.getAccessibilityDelegate(findViewById2) instanceof AccessibilityDelegateCompat)) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(findViewById2, new e());
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void A(int i3) {
        super.A(i3);
        AIOVideoData u06 = u0();
        if (u06 != null) {
            if (this.R.mVideoView.isPlaying()) {
                if (RichMediaBrowserUtils.d()) {
                    long curPlayingPos = this.R.mVideoView.getCurPlayingPos();
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOVideoView", 2, "showActionSheet, captureCurFrame, from:" + i3 + ", pos:" + curPlayingPos);
                    }
                    this.R.mVideoView.captureCurFrame(curPlayingPos, 0, 0);
                }
            } else if (this.R.playBar.getProgress() > 0) {
                if (RichMediaBrowserUtils.d()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOVideoView", 2, "showActionSheet, captureCurFrame, from:" + i3 + ", pos:" + this.f282049j0);
                    }
                    this.R.mVideoView.captureCurFrame(this.f282049j0, 0, 0);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("AIOVideoView", 2, "showActionSheet, video is not playing, recognize thumbnail");
                }
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.12
                    @Override // java.lang.Runnable
                    public void run() {
                        AIOVideoView aIOVideoView = AIOVideoView.this;
                        aIOVideoView.H0(aIOVideoView.r0(aIOVideoView.R.mVideoView.getCoverDrawable()));
                    }
                });
            }
            S0(u06, i3);
        }
    }

    public void B0(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "notifyVideoUrl ");
        this.Q.u(j3, i3, i16, str);
        AIOVideoData u06 = u0();
        if (u06 == null) {
            return;
        }
        com.tencent.mobileqq.richmediabrowser.utils.g.e().b(u06.msgId, strArr, System.currentTimeMillis(), messageRecord, i17, str2);
        tm2.f fVar = new tm2.f();
        fVar.f436607a = true;
        fVar.f436609c = strArr;
        fVar.f436608b = str;
        fVar.f436612f = messageRecord;
        fVar.f436613g = i17;
        fVar.f436617k = u06.msgId;
        fVar.f436618l = u06.subId;
        File file = new File(u06.f281844e);
        if (file.exists()) {
            fVar.f436622p = file.length();
        } else {
            fVar.f436622p = 0L;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + fVar.f436619m);
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar.a0(eVar.f281861h.getCurrentPosition())) {
            L0(fVar, -1L);
        } else {
            c1(0);
            updateUI();
        }
        if (new tm2.e().c(u06, 0) == null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
            com.tencent.mobileqq.richmediabrowser.f fVar2 = this.f282043d0;
            if (fVar2 != null) {
                fVar2.y(u06.msgId, u06.subId, 0);
            }
        }
    }

    public void F0() {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar.a0(eVar.f281861h.getCurrentPosition()) && this.R != null) {
            AIOVideoData u06 = u0();
            BaseVideoView baseVideoView = this.R.mVideoView;
            if (baseVideoView != null && u06 != null && u06.status == 4) {
                baseVideoView.resume();
            }
        }
    }

    public void G0() {
        VideoView videoView = this.R;
        if (videoView != null && videoView.mVideoView != null) {
            com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
            if (!eVar.a0(eVar.f281861h.getCurrentPosition())) {
                this.R.mVideoView.setCoverVisible();
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void I() {
        Z0(true);
    }

    public void Q0(AIOVideoData aIOVideoData, File file, int i3, RichMediaBrowserInfo richMediaBrowserInfo) {
        this.f282075e.setItemClickListenerV2(new h(aIOVideoData, file, i3, richMediaBrowserInfo));
        this.f282075e.setCancelListener(new i());
    }

    public void T0(boolean z16) {
        if (this.Y != null) {
            RichMediaBrowserInfo selectedItem = this.Q.f281861h.getSelectedItem();
            boolean z17 = false;
            if (z16 && selectedItem != null && selectedItem.baseData != null && !com.tencent.mobileqq.richmediabrowser.h.a().v() && !com.tencent.mobileqq.richmediabrowser.h.a().q() && ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture() && ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).isAEPituTakeSameOpen()) {
                RichMediaBaseData richMediaBaseData = selectedItem.baseData;
                if (richMediaBaseData instanceof AIOVideoData) {
                    AIOVideoData aIOVideoData = (AIOVideoData) richMediaBaseData;
                    if (!TextUtils.isEmpty(aIOVideoData.M)) {
                        this.Y.setVisibility(0);
                        String string = this.f282077h.getString(R.string.f221536b3);
                        if (!TextUtils.isEmpty(aIOVideoData.N)) {
                            string = aIOVideoData.N;
                        }
                        this.Z.setText(string);
                        if (this.f282040a0 != aIOVideoData.msgId) {
                            ReportController.o(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", aIOVideoData.M, "");
                            this.f282040a0 = aIOVideoData.msgId;
                        }
                        z17 = true;
                    }
                }
            }
            if (!z17) {
                this.Y.setVisibility(8);
            }
        }
    }

    public void U0(Dialog dialog) {
        if (dialog != null) {
            Context context = this.f282077h;
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                try {
                    dialog.show();
                } catch (Throwable th5) {
                    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showDialogSafe exception: " + th5.getMessage());
                }
            }
        }
    }

    public void W0(boolean z16) {
        int i3;
        RelativeLayout relativeLayout = this.S;
        if (relativeLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        }
    }

    public void X0() {
        BaseVideoView baseVideoView = this.R.mVideoView;
        if (baseVideoView != null && !baseVideoView.isLocalPlay() && this.R.mVideoView.isPlaying()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f282077h, 230, (String) null, this.f282077h.getString(R.string.f221916c4), R.string.f221736bm, R.string.f222036cf, new a(), new b());
            this.R.mVideoView.pause();
            U0(createCustomDialog);
        }
    }

    public void Y0(int i3, Object obj, RichMediaBrowserInfo richMediaBrowserInfo) {
        Context context = this.f282077h;
        U0(DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f221866bz), this.f282077h.getString(R.string.f221856by), new c(i3, obj), new d()));
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public View a(View view, ViewGroup viewGroup) {
        this.H = (RelativeLayout) LayoutInflater.from(this.f282077h).inflate(R.layout.hnm, (ViewGroup) null);
        y0();
        RelativeLayout relativeLayout = this.R.videoControlContainer;
        if (relativeLayout != null) {
            relativeLayout.addView(this.H);
        }
        return this.R.mBrowserItemView;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void b(int i3) {
        RichMediaBaseData richMediaBaseData;
        String str;
        RichMediaBaseData richMediaBaseData2;
        BaseVideoView baseVideoView;
        super.b(i3);
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 101) {
            AIOVideoData aIOVideoData = (AIOVideoData) item.baseData;
            tm2.e eVar = new tm2.e();
            URLDrawable uRLDrawable = this.Q.D.get(Integer.valueOf(i3));
            if (uRLDrawable != null && (baseVideoView = this.R.mVideoView) != null) {
                baseVideoView.showCover(uRLDrawable);
            } else if (eVar.c(aIOVideoData, 0) != null) {
                this.Q.c0(aIOVideoData.f281843d, aIOVideoData.C, aIOVideoData.D, this.R.mVideoView.getCoverImage(), i3);
            }
            if (aIOVideoData.f281846h == 1) {
                str = "0X8009EF1";
            } else {
                str = "0X8009EF2";
            }
            String str2 = str;
            RichMediaBrowserInfo o16 = this.Q.o();
            if (o16 != null && (richMediaBaseData2 = o16.baseData) != null && richMediaBaseData2.getType() == 101 && ((AIOVideoData) o16.baseData).msgId == aIOVideoData.msgId && !o16.isReport) {
                ReportController.o(null, "dc00898", "", "", str2, str2, 1, 0, "", "", "", "");
                o16.isReport = true;
            } else {
                ReportController.o(null, "dc00898", "", "", str2, str2, 2, 0, "", "", "", "");
            }
            k kVar = new k();
            VideoView videoView = this.R;
            kVar.f282072a = videoView.mVideoView;
            videoView.mBrowserItemView.setTag(kVar);
        }
    }

    @Override // e04.g
    public void d() {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
        if (this.Q.x()) {
            if (this.Q.p().f281782d) {
                this.Q.p().f281782d = false;
                this.Q.p().j();
                o();
            } else {
                this.Q.p().f();
                this.Q.p().f281782d = true;
                m(true);
            }
            this.Q.p().i();
            return;
        }
        this.Q.back();
    }

    @Override // e04.g
    public void e() {
        BaseVideoView baseVideoView;
        VideoView videoView = this.R;
        if (videoView != null && (baseVideoView = videoView.mVideoView) != null && baseVideoView.isPlaying()) {
            J0();
        } else {
            BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
            if (browserBasePresenter != null) {
                b1(browserBasePresenter.getCurrentPosition(), false);
            }
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.S();
        }
        w();
    }

    @Override // e04.g
    public void f() {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
        K0();
    }

    public void f1(int i3, View view, boolean z16) {
        tm2.f X;
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && item.baseData != null && view != null && (view.getTag() instanceof k)) {
            BaseVideoView baseVideoView = ((k) view.getTag()).f282072a;
            if (item.baseData.getType() == 101) {
                AIOVideoData aIOVideoData = (AIOVideoData) item.baseData;
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateView loadShortVideoCover");
                this.Q.c0(aIOVideoData.f281843d, aIOVideoData.C, aIOVideoData.D, baseVideoView.getCoverImage(), i3);
                if (this.Q.a0(i3) && (X = this.Q.X(aIOVideoData)) != null) {
                    L0(X, -1L);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, c04.c
    public void g(f04.c cVar) {
        super.g(cVar);
        if (cVar instanceof VideoView) {
            VideoView videoView = (VideoView) cVar;
            this.R = videoView;
            videoView.setPlayPanelDecorator(true);
            this.R.setVideoViewClickEvent(this);
            try {
                this.R.setVideoGestureScaleEnable(((IFeatureRuntimeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_video_preview_enable_scale"));
            } catch (Throwable th5) {
                QLog.e("AIOVideoView", 1, "[setDecoratorView] try setVideoGestureScaleEnable error! ", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void h(Intent intent) {
        super.h(intent);
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserPresenter.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            this.f282043d0 = (com.tencent.mobileqq.richmediabrowser.f) this.Q.f281859e.getParamsBuilder().c();
        }
    }

    public void i0() {
        this.Q.D.clear();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void m(boolean z16) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "doEnterImmersion, isClick:" + z16 + ", hasDanmaku:" + this.Q.t());
        super.m(z16);
        if (z16) {
            D(false);
            this.Q.Q(false);
        } else {
            if (this.Q.t()) {
                this.Q.p().f281782d = false;
                this.Q.j();
                this.Q.k();
                Z0(false);
                return;
            }
            D(false);
            this.Q.p().h();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        if (QLog.isColorLevel()) {
            QLog.i("AIOVideoView", 2, "onCapFrame, id:" + j3 + ", isSuccess:" + z16 + ", w:" + i3 + ", h:" + i16);
        }
        H0(bitmap);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar;
        RichMediaBaseData richMediaBaseData;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f164822az1) {
            RichMediaBrowserInfo selectedItem = this.Q.f281861h.getSelectedItem();
            if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null && (richMediaBaseData instanceof AIOVideoData)) {
                AIOVideoData aIOVideoData = (AIOVideoData) richMediaBaseData;
                com.tencent.mobileqq.richmediabrowser.f fVar = this.f282043d0;
                if (fVar != null) {
                    fVar.A(aIOVideoData.msgId, aIOVideoData.subId, 256);
                }
                this.Q.R(aIOVideoData.msgId, aIOVideoData.subId, 0);
                updateUI();
            }
        } else if (id5 == R.id.m2d) {
            s0();
            AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
            if (aIOBrowserPresenter != null) {
                aIOBrowserPresenter.L();
            }
        } else if (id5 == R.id.gqo) {
            l();
        } else if (id5 == R.id.f59252s8) {
            n();
        } else if (id5 == R.id.cp5) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoView", 2, "onClick qq_gallery_danmaku_view ");
            }
            E0();
        } else if (id5 == R.id.cq7) {
            com.tencent.mobileqq.richmediabrowser.presenter.e eVar2 = this.Q;
            if (eVar2 != null) {
                eVar2.f281859e.T();
                long curPlayingPos = this.R.mVideoView.getCurPlayingPos();
                Intent intent = new Intent();
                intent.putExtra(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getExtraSeekPos(), curPlayingPos);
                AIOVideoData W = this.Q.W();
                if (W != null) {
                    intent.putExtra(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getMsgId(), W.msgId);
                }
                ((Activity) this.f282077h).setResult(-1, intent);
                this.Q.back();
            }
        } else if (id5 == R.id.f164720x7) {
            D0();
        } else if (id5 == R.id.gqp) {
            t0();
            AIOBrowserPresenter aIOBrowserPresenter2 = this.Q.f281859e;
            if (aIOBrowserPresenter2 != null) {
                aIOBrowserPresenter2.K();
            }
        } else if (id5 == R.id.f59282sa && (eVar = this.Q) != null && eVar.f281861h != null) {
            k0(u0(), new tm2.e().c(this.Q.W(), 1), 0, this.Q.f281861h.getSelectedItem(), false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadComplete(long j3) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar != null) {
            tm2.f X = eVar.X(u0());
            if (X != null) {
                X.f436607a = false;
            }
            this.Q.f0(2003, 0L);
            if (X != null && !TextUtils.isEmpty(X.f436608b)) {
                ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onFileDownload(this.f282044e0.mSavePath, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationEnd() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoView", 2, "onEnterAnimationEnd");
        }
        super.onEnterAnimationEnd();
        C(true);
        updateUI();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationStart() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoView", 2, "onEnterAnimationStart");
        }
        C(false);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onFirstFrameRendered(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoView", 2, "onFirstFrameRendered, id:" + j3);
        }
        O0(j3, this.f282044e0);
        MessageRecord messageRecord = this.f282045f0;
        if (messageRecord instanceof MessageForShortVideo) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_busiType", String.valueOf(((MessageForShortVideo) messageRecord).busiType));
            hashMap.put(ReportConstant.KEY_VIDEO_CODEC_FORMAT, this.f282045f0.getExtInfoFromExtStr("video_download_response_codec_format"));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SHORTVIDEO_PLAY, true, 0L, 0L, hashMap, "");
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void onItemSelected(int i3) {
        super.onItemSelected(i3);
        b(i3);
        this.Q.c("");
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof AIOVideoData) {
                AIOVideoData aIOVideoData = (AIOVideoData) richMediaBaseData;
                j0(aIOVideoData);
                this.Q.R(aIOVideoData.msgId, aIOVideoData.subId, 0);
                if (this.Q.a0(i3)) {
                    b1(i3, true);
                } else {
                    updateUI();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayError(long j3, int i3, int i16, int i17, String str) {
        BrowserLogHelper.getInstance().getGalleryLog().e("AIOVideoView", 1, "onPlayError, id = " + j3 + " ,module = " + i3 + " , errorType = " + i16 + ", errCode = " + i17 + " , exInfo = " + str);
        x0(i3, i17, this.f282044e0);
        MessageRecord messageRecord = this.f282045f0;
        if (messageRecord instanceof MessageForShortVideo) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_busiType", String.valueOf(((MessageForShortVideo) messageRecord).busiType));
            hashMap.put(ReportConstant.KEY_VIDEO_CODEC_FORMAT, this.f282045f0.getExtInfoFromExtStr("video_download_response_codec_format"));
            hashMap.put("param_FailCode", String.valueOf(i17));
            hashMap.put(ReportConstant.KEY_ERR_DESC, str);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SHORTVIDEO_PLAY, false, 0L, 0L, hashMap, "");
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayProgress(long j3, long j16) {
        this.f282049j0 = j16;
    }

    @Override // e04.g
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (z16) {
            AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
            if (aIOBrowserPresenter != null) {
                aIOBrowserPresenter.V();
            }
            this.Q.p().f();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.d
    public void onScrollEnd() {
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar.z(eVar.f281861h.getCurrentPosition())) {
            BaseVideoView baseVideoView = this.R.mVideoView;
            if (baseVideoView != null && baseVideoView.isPlaying()) {
                this.Q.N();
            } else {
                this.Q.I(false);
            }
        }
        RichMediaBrowserUtils.e(this.Q).R = 0L;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.d
    public void onScrollStart() {
        super.onScrollStart();
        vm2.k.f441884a.j(this.R, this.Q, this.f282052m0);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onStateChange(long j3, int i3) {
        VideoView videoView;
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoView", 2, "onStateChange , state = " + i3 + ", msgUniseq=" + j3);
        }
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        if (i3 == 9 && (videoView = this.R) != null) {
                            videoView.abandonAudioFocus();
                            return;
                        }
                        return;
                    }
                    c1(5);
                    updateUI();
                    return;
                }
                c1(4);
                updateUI();
                return;
            }
            c1(2);
            updateUI();
            return;
        }
        d1();
        updateUI();
        if (!this.f282044e0.mIsMute) {
            this.R.requestAudioFocus();
        }
        AIOVideoData u06 = u0();
        if (u06 != null) {
            this.Q.U(u06.msgId);
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoView", 2, "onStateChange, STATE_PLAYING, try set autoplay = false");
            }
            this.Q.T(u06.msgId, false);
        }
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar.z(eVar.f281861h.getCurrentPosition())) {
            this.Q.N();
            RichMediaBrowserInfo selectedItem = this.Q.f281861h.getSelectedItem();
            if (selectedItem != null && (selectedItem.baseData instanceof AIOBrowserBaseData) && this.Q.n() != null && this.R.mVideoView != null) {
                this.Q.n().g(com.tencent.mobileqq.richmediabrowser.d.g(((AIOBrowserBaseData) selectedItem.baseData).shmsgseq, this.R.mVideoView.getCurPlayingPos(), this.Q.n(), this.Q.f281862i));
            }
        }
    }

    @Override // e04.g
    public void onStopTrackingTouch(SeekBar seekBar) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
        if (this.Q.n() != null) {
            com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
            if (eVar.z(eVar.f281861h.getCurrentPosition()) && seekBar != null) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
                this.Q.n().q(seekBar.getProgress());
                AIOVideoData W = this.Q.W();
                if (W != null) {
                    this.Q.n().g(com.tencent.mobileqq.richmediabrowser.d.g(W.shmsgseq, seekBar.getProgress(), this.Q.n(), this.Q.f281862i));
                }
            }
        }
        this.Q.p().j();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void t() {
        super.t();
        i0();
        this.f282043d0 = null;
        VideoView videoView = this.R;
        if (videoView != null) {
            videoView.onDestroy();
        }
        this.P.removeCallbacks(this.f282051l0);
        vm2.k.f441884a.j(this.R, this.Q, this.f282052m0);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void u(long j3) {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        boolean z16;
        super.u(j3);
        AIOVideoData u06 = u0();
        if (u06 != null && (fVar = this.f282043d0) != null) {
            int k3 = fVar.k(u06.msgId, u06.subId);
            if (k3 >= 0 && k3 < 100) {
                z16 = true;
            } else {
                z16 = false;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg isSaving:" + z16);
            if (z16) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg cancelDownloadMedia");
                this.f282043d0.A(u06.msgId, u06.subId, 256);
            }
            BaseVideoView baseVideoView = this.R.mVideoView;
            if (baseVideoView != null) {
                baseVideoView.pause();
            }
        }
    }

    public AIOVideoData u0() {
        BrowserBasePresenter browserBasePresenter;
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        com.tencent.mobileqq.richmediabrowser.presenter.e eVar = this.Q;
        if (eVar != null && (browserBasePresenter = eVar.f281861h) != null && (selectedItem = browserBasePresenter.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 101) {
            return (AIOVideoData) selectedItem.baseData;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void updateUI() {
        int i3;
        String string;
        super.updateUI();
        AIOVideoData u06 = u0();
        G(z());
        E(y(this.Q.f281861h.getSelectedItem()));
        T0(true);
        if (u06 != null && this.R != null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "updateUI id = " + u06.f365136id + ", status = " + u06.status);
            int i16 = 8;
            switch (u06.status) {
                case 0:
                    W0(false);
                    V0(true);
                    BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
                    browserBasePresenter.onLoadFinish(browserBasePresenter.getSelectedIndex(), true);
                    this.R.showPlayPanel(false);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    ImageView imageView = this.R.mCenterPlayBtn;
                    if (u06.I) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    imageView.setVisibility(i3);
                    this.R.playButton.setImageResource(R.drawable.f9n);
                    g0(false, this.R.playButton);
                    BaseVideoView baseVideoView = this.R.mVideoView;
                    if (baseVideoView != null) {
                        long videoDurationMs = baseVideoView.getVideoDurationMs();
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "videoDuration = " + videoDurationMs);
                        this.R.totalTime.setText(com.tencent.richmediabrowser.utils.a.b(videoDurationMs));
                        this.R.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(0L));
                    }
                    this.R.playBar.setProgress(0);
                    if (u06.istroop == 10014) {
                        VideoView videoView = this.R;
                        ImageView imageView2 = videoView.mCenterPlayBtn;
                        if (!u06.I && !videoView.mVideoView.isPlaying()) {
                            i16 = 0;
                        }
                        imageView2.setVisibility(i16);
                        if (this.R.mVideoView.isPlaying()) {
                            this.R.showPlayPanel(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    BrowserBasePresenter browserBasePresenter2 = this.Q.f281861h;
                    browserBasePresenter2.onLoadStart(browserBasePresenter2.getSelectedIndex(), u06.progress);
                    this.R.showPlayPanel(false);
                    W0(false);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    V0(false);
                    return;
                case 2:
                    BaseVideoView baseVideoView2 = this.R.mVideoView;
                    if (baseVideoView2 != null) {
                        if (baseVideoView2.isPlaying()) {
                            this.R.bufferPanel.setVisibility(0);
                        } else {
                            this.R.bufferPanel.setVisibility(8);
                        }
                    }
                    BrowserBasePresenter browserBasePresenter3 = this.Q.f281861h;
                    browserBasePresenter3.onLoadFinish(browserBasePresenter3.getSelectedIndex(), true);
                    this.R.showPlayPanel(true);
                    W0(false);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    V0(true);
                    return;
                case 3:
                    BrowserBasePresenter browserBasePresenter4 = this.Q.f281861h;
                    browserBasePresenter4.onLoadFinish(browserBasePresenter4.getSelectedIndex(), true);
                    this.R.showPlayPanel(true);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    this.R.playButton.setImageResource(R.drawable.f9o);
                    g0(true, this.R.playButton);
                    BaseVideoView baseVideoView3 = this.R.mVideoView;
                    if (baseVideoView3 != null) {
                        this.N = baseVideoView3.getVideoDurationMs();
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "videoDuration = " + this.N);
                        this.R.totalTime.setText(com.tencent.richmediabrowser.utils.a.b(this.N));
                    }
                    W0(false);
                    V0(true);
                    this.P.removeCallbacks(this.f282051l0);
                    return;
                case 4:
                    BrowserBasePresenter browserBasePresenter5 = this.Q.f281861h;
                    browserBasePresenter5.onLoadFinish(browserBasePresenter5.getSelectedIndex(), true);
                    this.R.showPlayPanel(true);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(0);
                    this.R.playButton.setImageResource(R.drawable.f9n);
                    g0(false, this.R.playButton);
                    W0(false);
                    V0(true);
                    return;
                case 5:
                    e1();
                    return;
                case 6:
                    BrowserBasePresenter browserBasePresenter6 = this.Q.f281861h;
                    browserBasePresenter6.onLoadFinish(browserBasePresenter6.getSelectedIndex(), true);
                    this.R.showPlayPanel(false);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(0);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    this.R.playButton.setImageResource(R.drawable.f9n);
                    g0(false, this.R.playButton);
                    TextView textView = (TextView) this.R.mErrLayout.findViewById(R.id.byl);
                    if (textView != null) {
                        if (!TextUtils.isEmpty(u06.H)) {
                            string = u06.H;
                        } else {
                            string = this.f282077h.getString(R.string.f238267ja);
                        }
                        textView.setText(string);
                    }
                    W0(false);
                    V0(false);
                    return;
                case 7:
                    BrowserBasePresenter browserBasePresenter7 = this.Q.f281861h;
                    browserBasePresenter7.onLoadFinish(browserBasePresenter7.getSelectedIndex(), true);
                    this.T.setText(this.f282077h.getString(R.string.f221886c1) + u06.progress + "%");
                    this.V.setProgress(u06.progress * 100);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.showPlayPanel(false);
                    W0(true);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    V0(true);
                    return;
                default:
                    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI status is error, status = " + u06.status);
                    return;
            }
        }
    }

    public long v0() {
        BaseVideoView baseVideoView;
        VideoView videoView = this.R;
        if (videoView != null && (baseVideoView = videoView.mVideoView) != null) {
            return baseVideoView.getCurPlayingPos();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements DialogInterface.OnCancelListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadProgress(long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onLoopBack(long j3, long j16) {
    }
}
