package com.qzone.module.covercomponent.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.module.covercomponent.manage.CoverCacheManager;
import com.qzone.module.covercomponent.manage.QZoneCoverContainerManager;
import com.qzone.module.covercomponent.ui.CoverQzoneShowWebView;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.ui.ICoverBaseView;
import com.qzone.proxy.covercomponent.ui.IOnCoverChangedListener;
import com.qzone.proxy.covercomponent.ui.IOnCoverClickListener;
import com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer;
import com.qzone.report.QZonePerfReporter;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qui.immersive.color.f;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.model.CoverCacheData;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCoverContainer extends FrameLayout implements IQZoneCoverContainer, View.OnLongClickListener {
    public static final String TAG = "QZoneCoverContainer";
    private volatile Drawable C;
    private ViewGroup D;
    private CoverFullScreenImageView E;
    private long F;
    private ViewGroup G;
    private int H;
    private IOnCoverChangedListener I;
    private IOnCoverClickListener J;
    private CoverQzoneShowBreezeView K;
    private int L;
    private volatile boolean M;
    private volatile boolean N;
    private volatile boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private View.OnClickListener U;
    private boolean V;
    private long W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f48720a0;

    /* renamed from: d, reason: collision with root package name */
    private int f48721d;

    /* renamed from: e, reason: collision with root package name */
    private ICoverBaseView f48722e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f48723f;

    /* renamed from: h, reason: collision with root package name */
    private CoverCacheData f48724h;

    /* renamed from: i, reason: collision with root package name */
    private Activity f48725i;

    /* renamed from: m, reason: collision with root package name */
    private volatile Rect f48726m;

    static {
        f.a(new QZoneCoverContainerColorFetcher());
    }

    public QZoneCoverContainer(Context context, ViewGroup viewGroup, long j3) {
        super(context);
        this.f48721d = 255;
        this.M = true;
        this.N = false;
        this.P = false;
        this.R = ar.b("kenaiyu", "2024-10-24", "vas_bug_qzone_webview_cover").isEnable(false);
        this.S = -1;
        this.T = -1;
        this.V = false;
        this.F = j3;
        this.D = viewGroup;
        this.H = 17;
        r();
    }

    private void A() {
        CoverCacheData coverCacheData = this.f48724h;
        if (coverCacheData == null) {
            return;
        }
        String replaceWithUin = QZoneCoverContainerManager.replaceWithUin(QZoneCoverContainerManager.replaceWithQua(coverCacheData.mapExtInfo.get(QzoneCoverConst.COVER_EXTINOF_DYNAMIC_ALBUM_H5_URL)), p());
        String str = this.f48724h.mapExtInfo.get(QzoneCoverConst.COVER_EXTINFO_DYNAMIC_ALBUM_STATIC_PIC_URL);
        VasLogReporter.getQzoneCover().report("resetSuperCover from: setDynamicAlbumCoverData");
        H(10, p(), replaceWithUin, str, str, "\u7cdf\u7cd5\uff0c\u52a0\u8f7d\u51fa\u9519\u4e86", 1.0d, QZoneCoverContainerManager.getDynamicAlbumCoverListener(), false);
    }

    private void B() {
        CoverCacheData coverCacheData = this.f48724h;
        if (coverCacheData == null) {
            CoverLog.w(TAG, "setDynamicCover mCurrentCoverData is null", null);
            return;
        }
        CoverCacheData.PackageInfo packageInfo = coverCacheData.packageInfo;
        if (packageInfo != null) {
            this.H = m(packageInfo.coverStyle);
        }
        ICoverBaseView iCoverBaseView = this.f48722e;
        if ((iCoverBaseView == null || iCoverBaseView.getCoverType() == getCoverType()) ? false : true) {
            this.f48722e.onDestroy();
            this.f48722e = null;
        }
        x("setDynamicCover");
        ICoverBaseView iCoverBaseView2 = this.f48722e;
        if (iCoverBaseView2 == null) {
            this.f48722e = CoverEnv.newDynamicCoverWrapperInstance(getContext(), getCoverType(), this);
            onHierarchyChange(this.G);
        } else {
            CoverEnv.setDynamicCoverParentView(iCoverBaseView2, this);
        }
        if (this.U == null) {
            this.U = new View.OnClickListener() { // from class: com.qzone.module.covercomponent.ui.QZoneCoverContainer.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    if (TextUtils.isEmpty(CoverEnv.getCoverJumpUrlFromJce(QZoneCoverContainer.this.f48724h.uin))) {
                        CoverJumpAction.jumpToCoverCenter(QZoneCoverContainer.this.getContext(), 0, "", QZoneCoverContainer.this.f48724h.uin);
                    } else {
                        CoverJumpAction.jumpToUrlPageFromJceData(QZoneCoverContainer.this.getContext(), QZoneCoverContainer.this.f48724h.uin);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
        }
        CoverEnv.setDynamicCoverWebviewListener(this.f48722e, this.U);
        CoverEnv.setDynamicCoverWithData(this.f48722e, this.f48724h);
    }

    private void C(int i3, int i16) {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverStillImageView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        x("setImageCover");
        if (this.f48722e == null) {
            CoverStillImageView coverStillImageView = new CoverStillImageView();
            this.f48722e = coverStillImageView;
            coverStillImageView.setCoverBaseParent(this);
        }
        ((CoverStillImageView) this.f48722e).setCoverData(p(), this.f48724h, i3, i16);
    }

    private void D() {
        if (this.f48724h == null) {
            return;
        }
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverJigsawView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        x("setJigsawCover");
        if (this.f48722e == null) {
            CoverJigsawView coverJigsawView = new CoverJigsawView();
            this.f48722e = coverJigsawView;
            coverJigsawView.setCoverBaseParent(this);
        }
        ((CoverJigsawView) this.f48722e).init(this.f48724h.photoWall);
    }

    private void E() {
        if (this.f48724h == null) {
            return;
        }
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverMovingView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        x("setMovingCover");
        if (this.f48722e == null) {
            CoverMovingView coverMovingView = new CoverMovingView(getContext());
            this.f48722e = coverMovingView;
            coverMovingView.setCoverBaseParent(this);
        }
        ((CoverMovingView) this.f48722e).init(this.f48724h.photoWall);
    }

    private void F(int i3, int i16) {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverMusicView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        x("setMusicCover");
        if (this.f48722e == null) {
            CoverMusicView coverMusicView = new CoverMusicView();
            this.f48722e = coverMusicView;
            coverMusicView.setCoverBaseParent(this);
        }
        ((CoverMusicView) this.f48722e).setCoverData(getContext(), getActivity(), this, p(), this.f48724h, i3, this.L);
    }

    private void G() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        if (this.f48722e != null || this.f48724h == null) {
            return;
        }
        this.f48722e = new CoverPanoramaView(p(), getContext(), this, this.f48724h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    private void I() {
        String str;
        String str2;
        if (this.f48724h == null) {
            return;
        }
        String replaceWithQua = QZoneCoverContainerManager.replaceWithQua(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithUin(CoverEnv.getConfig("H5Url", QzoneCoverConst.SECONDARY_COVER_QZONE_SHOW_URL, QzoneCoverConst.QZONE_SHOW_URL), p()), "{screenWidth}", String.valueOf(CoverEnv.getScreenWidth())));
        ?? r36 = 1;
        boolean z16 = CoverEnv.isSupportSuperCover() && !TextUtils.isEmpty(this.f48724h.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FULL_SCREEN_URL)) && CoverEnv.isQzoneShowShowAsSuperCover();
        String str3 = "";
        if (z16) {
            str = "";
        } else {
            str = this.f48724h.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_DOWNGRADE_BG);
        }
        if (!z16) {
            str3 = this.f48724h.mapExtInfo.get(QzoneCoverConst.KEY_QZONE_SHOW_BG_URL);
        }
        if (z16 || str == null || str.length() <= 0) {
            str2 = str3;
            r36 = z16;
        } else {
            str2 = str;
        }
        String replaceUrlParam = QZoneCoverContainerManager.replaceUrlParam(replaceWithQua, "{hideperson}", String.valueOf((int) r36));
        double cutRateConfig = CoverEnv.QzoneShowEnv.getCutRateConfig();
        if ("1".equals(this.f48724h.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FORCE_DOWNGRADE_FLAG))) {
            replaceUrlParam = null;
        }
        VasLogReporter.getQzoneCover().report("resetSuperCover from: setQzoneShowWebviewDataWithCoverData");
        H(6, p(), replaceUrlParam, str2, str, QzoneCoverConst.WEBVIEW_DEFAULT_ERROR_MSG, cutRateConfig, QZoneCoverContainerManager.getQzoneShowListener(), z16);
        if (z16) {
            ICoverBaseView iCoverBaseView = this.f48722e;
            if (iCoverBaseView != null && (iCoverBaseView instanceof CoverQzoneShowWebView)) {
                ((CoverQzoneShowWebView) iCoverBaseView).setBackgroundTransparent();
            }
            K(6);
        }
    }

    private void J(ViewGroup viewGroup) {
        String str = this.f48724h.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FG_ZIP);
        if (TextUtils.isEmpty(str) || !CoverEnv.isSupportQzoneBreeze()) {
            return;
        }
        int parseInt = Integer.parseInt(this.f48724h.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FG_IMG_COUNT));
        String str2 = this.f48724h.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FG_ID);
        if (this.K == null) {
            this.K = new CoverQzoneShowBreezeView(getContext(), viewGroup);
        }
        this.K.addToParent();
        this.K.setData(str, str2, parseInt);
    }

    private void L() {
        boolean isChanged;
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverVideoCoverView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        x("setVideoCover");
        long p16 = p();
        if (p16 == 0) {
            p16 = CoverEnv.getLoginUin();
        }
        long j3 = p16;
        ICoverBaseView iCoverBaseView2 = this.f48722e;
        if (iCoverBaseView2 == null) {
            CoverLog.d(TAG, CoverLog.CLR, "setVideoCover mCoverView is null, set ischanged true");
            isChanged = true;
        } else {
            CoverVideoCoverView coverVideoCoverView = (CoverVideoCoverView) iCoverBaseView2;
            CoverCacheData coverCacheData = this.f48724h;
            isChanged = coverVideoCoverView.isChanged(j3, coverCacheData != null ? coverCacheData.mapExtInfo : null);
            CoverLog.d(TAG, CoverLog.CLR, "setVideoCover mCoverView is not null, ischanged =" + isChanged);
        }
        if (isChanged) {
            ICoverBaseView iCoverBaseView3 = this.f48722e;
            if (iCoverBaseView3 != null) {
                iCoverBaseView3.onDestroy();
                this.f48722e = null;
            }
            CoverCacheData coverCacheData2 = this.f48724h;
            int i3 = (coverCacheData2 == null || !QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER.equals(coverCacheData2.type)) ? 9 : 15;
            try {
                Context context = getContext();
                Activity activity = getActivity();
                CoverCacheData coverCacheData3 = this.f48724h;
                this.f48722e = new CoverVideoCoverView(context, activity, this, j3, coverCacheData3 != null ? coverCacheData3.mapExtInfo : null, i3, this.L);
            } catch (Throwable th5) {
                th5.printStackTrace();
                CoverLog.e(TAG, "video cover exception", th5);
            }
        }
    }

    private void M() {
        HashMap<String, String> hashMap;
        CoverCacheData coverCacheData = this.f48724h;
        if (coverCacheData == null || (hashMap = coverCacheData.mapExtInfo) == null) {
            return;
        }
        String replaceWithUin = QZoneCoverContainerManager.replaceWithUin(QZoneCoverContainerManager.replaceWithQua(hashMap.get(QzoneCoverConst.COVER_EXTINFO_WEBVIEW_H5_URL)), p());
        if (!QZoneCoverContainerManager.getArguments(replaceWithUin).containsKey("refer")) {
            replaceWithUin = QZoneCoverContainerManager.addParameter(replaceWithUin, "refer", o());
        }
        if (!QZoneCoverContainerManager.getArguments(replaceWithUin).containsKey("_proxyByURL")) {
            replaceWithUin = QZoneCoverContainerManager.addParameter(replaceWithUin, "_proxyByURL", "1");
        }
        String webviewDefaultUrl = CoverCacheManager.getWebviewDefaultUrl(this.f48724h);
        VasLogReporter.getQzoneCover().report("resetSuperCover from: setWebviewCover");
        H(17, p(), replaceWithUin, webviewDefaultUrl, webviewDefaultUrl, "\u7cdf\u7cd5\uff0c\u52a0\u8f7d\u51fa\u9519\u4e86", 1.0d, QZoneCoverContainerManager.getWebviewCoverListener(), false);
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView == null || !(iCoverBaseView instanceof CoverQzoneShowWebView)) {
            return;
        }
        ((CoverQzoneShowWebView) iCoverBaseView).setWebviewClickListener(QZoneCoverContainerManager.getWebviewCoverClickListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String str;
        CoverCacheData coverCacheData = this.f48724h;
        if (coverCacheData != null) {
            if (CoverHelper.isFullScreenCover(coverCacheData)) {
                str = QzoneCoverConst.KEY_TRANSPARENCY;
            } else {
                str = QzoneCoverConst.COVER_QZONE_SHOW_TRANS;
            }
            HashMap<String, String> hashMap = this.f48724h.mapExtInfo;
            String str2 = hashMap == null ? null : hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                this.f48721d = CoverCacheManager.transparencyValueRealValue(str2);
                return;
            } else {
                this.f48721d = 255;
                return;
            }
        }
        this.f48721d = 255;
    }

    private void O() {
        int i3;
        int i16 = this.H;
        if (i16 == 16 || i16 == 17) {
            i3 = (int) (((this.S - this.T) / 2.0f) + 0.5f);
        } else if (i16 != 48) {
            i3 = i16 != 80 ? 0 : -this.T;
        } else {
            i3 = this.S;
        }
        scrollTo(0, i3);
    }

    private static int m(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return 80;
            }
            return 48;
        }
        return 17;
    }

    private static void n(CoverCacheData coverCacheData, String str) {
        HashMap<String, String> hashMap = coverCacheData.mapExtInfo;
        if (hashMap == null) {
            return;
        }
        String str2 = hashMap.get(str);
        if (!CoverHelper.isLocalVideo(str2) || CoverHelper.isFileExist(str2)) {
            return;
        }
        coverCacheData.mapExtInfo.remove(str);
    }

    private String o() {
        int i3 = this.L;
        if (i3 == 1) {
            return QZoneClickReport.ClickReportConfig.SOURCE_TO_FRIENDFEED;
        }
        if (i3 == 2) {
            return "profilefeed";
        }
        if (i3 == 3) {
            return "coverpreview";
        }
        if (i3 != 4) {
            return "unknown";
        }
        return "avatarpreview";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long p() {
        return this.F;
    }

    private void q() {
        CoverQzoneShowBreezeView coverQzoneShowBreezeView = this.K;
        if (coverQzoneShowBreezeView != null) {
            coverQzoneShowBreezeView.hide();
            this.K.removeFromParent();
            this.K = null;
        }
    }

    private void r() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setId(CoverHelper.getResId(5));
        this.D.addView(this, 0);
        setWillNotDraw(false);
        s();
        setOnLongClickListener(this);
    }

    private void s() {
        if (CoverCacheManager.gLoginUserCoverUrl == null || CoverCacheManager.gLoginUserCoverUrl.length() == 0) {
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "initDefaultDrawable: " + CoverCacheManager.gLoginUserCoverUrl);
        if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(CoverCacheManager.gLoginUserCoverUrl).setRegionScaleType(ImageView.ScaleType.CENTER_CROP), new IPicLoadStateListener() { // from class: com.qzone.module.covercomponent.ui.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    QZoneCoverContainer.this.u(loadState, option);
                }
            });
        } else {
            this.C = ImageLoader.getInstance().loadImage(CoverCacheManager.gLoginUserCoverUrl, ImageLoader.Options.obtain());
        }
        if (this.C != null) {
            int screenWidth = CoverEnv.getScreenWidth();
            this.f48726m = new Rect(0, 0, screenWidth, screenWidth);
            this.C.setBounds(this.f48726m);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        return CoverHelper.isWebviewLikeCover(CoverHelper.checkCoverType(this.f48724h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(LoadState loadState, Option option) {
        this.C = new BitmapDrawable(BaseApplication.getContext().getResources(), option.getResultBitMap());
    }

    private String w(String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("{refer}", o());
    }

    private void x(String str) {
        VasLogReporter.getQzoneCover().report("resetSuperCover from: " + str);
        this.f48723f.sendEmptyMessage(QzoneCoverConst.MSG_UNSET_SUPER_COVER);
        this.f48721d = 255;
    }

    private void y() {
        boolean isChanged;
        HashMap<String, String> hashMap;
        ICoverBaseView iCoverBaseView = this.f48722e;
        String str = null;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverGifView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        x("setCustomGifCover");
        long p16 = p();
        if (p16 == 0) {
            p16 = CoverEnv.getLoginUin();
        }
        long j3 = p16;
        ICoverBaseView iCoverBaseView2 = this.f48722e;
        if (iCoverBaseView2 == null) {
            CoverLog.d(TAG, CoverLog.CLR, "setCustomGifCover mCoverView is null, set ischanged true");
            isChanged = true;
        } else {
            CoverGifView coverGifView = (CoverGifView) iCoverBaseView2;
            CoverCacheData coverCacheData = this.f48724h;
            isChanged = coverGifView.isChanged(j3, coverCacheData != null ? coverCacheData.mapExtInfo : null);
            CoverLog.d(TAG, CoverLog.CLR, "setCustomGifCover mCoverView is not null, ischanged =" + isChanged);
        }
        if (isChanged) {
            ICoverBaseView iCoverBaseView3 = this.f48722e;
            if (iCoverBaseView3 != null) {
                iCoverBaseView3.onDestroy();
                this.f48722e = null;
            }
            try {
                String rightCoverUrl = CoverCacheManager.getRightCoverUrl(this.f48724h);
                CoverCacheData coverCacheData2 = this.f48724h;
                if (coverCacheData2 != null && (hashMap = coverCacheData2.mapExtInfo) != null) {
                    str = hashMap.get(CoverHelper.GIF_URL_KEY);
                }
                CoverGifView coverGifView2 = new CoverGifView(j3, this, this.L, rightCoverUrl, str);
                this.f48722e = coverGifView2;
                coverGifView2.setCoverBaseParent(this);
            } catch (Throwable th5) {
                CoverLog.e(TAG, "gif cover exception", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Handler handler = this.f48723f;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.QZoneCoverContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    CoverCacheData coverCacheData = new CoverCacheData();
                    coverCacheData.uin = QZoneCoverContainer.this.p();
                    coverCacheData.type = QzoneCoverConst.CoverStringType.COVER_TYPE_STATIC;
                    coverCacheData.local_url = CoverHelper.getLocalDefaultCover(QZoneCoverContainer.this.Q);
                    CoverLog.i(QZoneCoverContainer.TAG, CoverLog.CLR, "set local default cover " + coverCacheData.local_url);
                    QZoneCoverContainer qZoneCoverContainer = QZoneCoverContainer.this;
                    qZoneCoverContainer.setCoverInMainThread(qZoneCoverContainer.p(), coverCacheData);
                }
            });
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void breezePause() {
        CoverQzoneShowBreezeView coverQzoneShowBreezeView = this.K;
        if (coverQzoneShowBreezeView != null) {
            coverQzoneShowBreezeView.hide();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void breezeResume() {
        CoverQzoneShowBreezeView coverQzoneShowBreezeView = this.K;
        if (coverQzoneShowBreezeView != null) {
            coverQzoneShowBreezeView.show();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void calljs(String str) {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView == null || !CoverHelper.isWebviewLikeCover(iCoverBaseView.getCoverType())) {
            return;
        }
        ((CoverQzoneShowWebView) iCoverBaseView).v(str);
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseParent
    public void coverInvalidate() {
        super.invalidate();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void delayShow() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.delayShow();
        }
        this.V = true;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void dispatchPullEvent(int i3, int i16) {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.dispatchPullEvent(i3, i16);
        }
        try {
            int i17 = this.P ? -i3 : 0;
            CoverFullScreenImageView coverFullScreenImageView = this.E;
            if (coverFullScreenImageView != null && coverFullScreenImageView.getScrollY() != i17) {
                this.E.scrollTo(0, i17);
            }
            CoverQzoneShowBreezeView coverQzoneShowBreezeView = this.K;
            if (coverQzoneShowBreezeView == null || coverQzoneShowBreezeView.getScrollY() == i17) {
                return;
            }
            this.K.scrollTo(0, i17);
        } catch (Exception e16) {
            CoverLog.w(TAG, "mSuperCover.scrollTo fail, t=" + i3, e16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ICoverBaseView iCoverBaseView;
        if (getCoverType() == 14 && this.G != null) {
            motionEvent.setLocation(motionEvent.getX(), motionEvent.getY() + CoverEnv.getCoverPaddingTop());
            boolean dispatchTouchEvent = this.G.dispatchTouchEvent(motionEvent);
            CoverLog.d(TAG, CoverLog.CLR, "event=" + motionEvent.getAction() + ",outerlayout ret=" + dispatchTouchEvent);
            if (motionEvent.getAction() == 0 && !dispatchTouchEvent && (iCoverBaseView = this.f48722e) != null) {
                iCoverBaseView.onTouchEvent(this.f48725i, this, motionEvent, this.f48724h);
            }
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void doWhenLoadingFailed() {
        CoverLog.w(TAG, "doWhenLoadingFailed set empty cover.", null);
        z();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public Activity getActivity() {
        return this.f48725i;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public int getCoverType() {
        return CoverHelper.checkCoverType(this.f48724h);
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public <T> T getExtra(Class<T> cls) {
        return null;
    }

    public int getParentHeight() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup viewGroup = this.D;
        if (viewGroup == null || (layoutParams = viewGroup.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public int getTransparency() {
        return this.f48721d;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void hideFullscreenCover() {
        CoverFullScreenImageView coverFullScreenImageView = this.E;
        if (coverFullScreenImageView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) coverFullScreenImageView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.E);
                    this.E = null;
                    CoverHelper.changeTransparency((View) getParent(), this.f48721d);
                    CoverEnv.notifyAdapter(this.f48725i);
                    View footerRootView = CoverEnv.getFooterRootView(this.f48725i);
                    if (footerRootView != null) {
                        footerRootView.getBackground().setAlpha(this.f48721d);
                    }
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (CoverEnv.isListView(childAt)) {
                            childAt.setBackgroundColor(getResources().getColor(CoverHelper.getResId(6)));
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        q();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public boolean isCoverVisible() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView == null) {
            return false;
        }
        return iCoverBaseView.isCoverVisible();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public boolean isPaused() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView == null) {
            return false;
        }
        return iCoverBaseView.isPaused();
    }

    @Override // android.view.View, com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onConfigurationChanged(Configuration configuration) {
        CoverLog.d(TAG, CoverLog.DEV, "onConfigurationChanged width =" + CoverEnv.getScreenWidth());
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onConfigurationChanged(configuration);
        }
    }

    public void onCoverInvisible() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView == null || !iCoverBaseView.isCoverVisible()) {
            return;
        }
        this.f48722e.onInvisible();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onCoverVisible() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView == null || iCoverBaseView.isCoverVisible()) {
            return;
        }
        this.f48722e.onVisible();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onDestory() {
        if (this.N) {
            return;
        }
        this.N = true;
        onPause();
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        CoverFullScreenImageView coverFullScreenImageView = this.E;
        if (coverFullScreenImageView != null) {
            coverFullScreenImageView.onDestory();
        }
        CoverQzoneShowBreezeView coverQzoneShowBreezeView = this.K;
        if (coverQzoneShowBreezeView != null) {
            coverQzoneShowBreezeView.onDestroy();
            this.K = null;
        }
        this.f48725i = null;
        this.D = null;
        this.E = null;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IOnCoverClickListener iOnCoverClickListener = this.J;
        if (iOnCoverClickListener != null) {
            iOnCoverClickListener.onLongClick(null);
            this.f48720a0 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int screenWidth = CoverEnv.getScreenWidth();
        int parentHeight = getParentHeight();
        if (parentHeight == 0 || parentHeight == -2 || parentHeight == -1) {
            parentHeight = screenWidth;
        }
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && (iCoverBaseView instanceof CoverQzoneShowWebView)) {
            parentHeight = ((CoverQzoneShowWebView) iCoverBaseView).getScreenHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(screenWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(parentHeight, 1073741824));
        setMeasuredDimension(screenWidth, parentHeight);
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onPause() {
        if (this.M) {
            return;
        }
        this.M = true;
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onPause();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onPullChanged(float f16) {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onPullChanged(f16);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onPullEnd() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onPullEnd();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onPullStart() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onPullStart();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onResume() {
        if (this.M) {
            this.M = false;
            ICoverBaseView iCoverBaseView = this.f48722e;
            if (iCoverBaseView != null) {
                iCoverBaseView.onResume();
            }
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onStart() {
        CoverLog.i(TAG + hashCode(), CoverLog.CLR, "container onStart");
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onStart();
        }
        CoverFullScreenImageView coverFullScreenImageView = this.E;
        if (coverFullScreenImageView != null) {
            coverFullScreenImageView.onStart();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onStop() {
        CoverLog.i(TAG + hashCode(), CoverLog.CLR, "container onStop");
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.onStop();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (!(iCoverBaseView instanceof CoverQzoneShowWebView) && !(iCoverBaseView instanceof CoverVideoCoverView) && !(iCoverBaseView instanceof CoverGifView)) {
            TouchDelegate touchDelegate = getTouchDelegate();
            if (touchDelegate != null) {
                touchDelegate.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.W = System.currentTimeMillis();
                this.f48720a0 = false;
            } else if (action == 1) {
                CoverLog.i(TAG, CoverLog.DEV, "long click time = " + ViewConfiguration.getLongPressTimeout() + " currentTiem = " + (System.currentTimeMillis() - this.W));
                if (System.currentTimeMillis() - this.W < ViewConfiguration.getLongPressTimeout()) {
                    ICoverBaseView iCoverBaseView2 = this.f48722e;
                    if (iCoverBaseView2 != null) {
                        return iCoverBaseView2.onTouchEvent(this.f48725i, this, motionEvent, this.f48724h);
                    }
                    CoverLog.d(TAG, CoverLog.DEV, "mCoverView is null,ignore touch action up");
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        CoverEnv.handleWindowVisibilityChanged(getContext(), i3, this.f48722e);
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseParent
    public void postCoverInvalidate() {
        super.postInvalidate();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setActivity(Activity activity) {
        this.f48725i = activity;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setCacheCover(long j3) {
        if (j3 != p()) {
            VasLogReporter.getQzoneCover().report("uin \u4e0d\u4e00\u81f4" + p());
            return;
        }
        setCacheCover(j3, null);
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setCoverInMainThread(long j3, CoverCacheData coverCacheData) {
        if (j3 != p()) {
            return;
        }
        if (j3 != CoverEnv.getLoginUin()) {
            this.C = null;
        }
        try {
            this.f48724h = coverCacheData;
            if (coverCacheData == null) {
                if (j3 == CoverEnv.getLoginUin() || !CoverEnv.isNetworkAvailable()) {
                    CoverLog.d(TAG, CoverLog.DEV, "1.cover cache is null,set empty cover,uin=" + j3);
                    z();
                    return;
                }
                return;
            }
            int checkCoverType = CoverHelper.checkCoverType(coverCacheData);
            int i3 = (checkCoverType == 3 && CoverEnv.getShowCoverGuide(getContext())) ? 1 : 0;
            CoverLog.d(TAG, CoverLog.CLR, "setCoverInMainThread, cover type:" + checkCoverType + ", cover guide:" + i3);
            Message obtain = Message.obtain(this.f48723f, QzoneCoverConst.MSG_COVER_UPDATE_UI, checkCoverType, i3);
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", this.f48724h);
            obtain.setData(bundle);
            onHandleMessage(obtain);
        } catch (Exception e16) {
            CoverLog.e(TAG, "setCacheCover error", e16);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setCustomWebviewCover(long j3, String str, String str2, String str3) {
        CoverLog.e(TAG, "setCustomWebviewCover uin=" + j3 + ",coverUrl=" + str + ",bgUrl=" + str2, null);
        H(8, j3, str, str2, str3, null, 1.0d, null, false);
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setEmptyCover() {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverStillImageView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        if (this.f48722e == null) {
            CoverStillImageView coverStillImageView = new CoverStillImageView();
            this.f48722e = coverStillImageView;
            coverStillImageView.setCoverBaseParent(this);
        }
        ((CoverStillImageView) this.f48722e).init(CoverHelper.getLocalDefaultCover(this.Q));
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setGravity(int i3) {
        CoverLog.d(TAG, CoverLog.CLR, "setGravity gravity=" + i3);
        if (this.H != i3) {
            this.H = i3;
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setHandler(Handler handler) {
        this.f48723f = handler;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setIsInLimitPage(boolean z16) {
        this.Q = z16;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setIsTiantaiStyle(boolean z16) {
        this.P = z16;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setOnCoverChangedListener(IOnCoverChangedListener iOnCoverChangedListener) {
        this.I = iOnCoverChangedListener;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setOnCoverClickListener(IOnCoverClickListener iOnCoverClickListener) {
        this.J = iOnCoverClickListener;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setOuterLayout(ViewGroup viewGroup) {
        this.G = viewGroup;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setRefer(int i3) {
        this.L = i3;
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.setRefer(i3);
        }
        CoverLog.i(TAG, CoverLog.USR, "set cover refer: " + i3);
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setVisiblePadding(int i3, int i16) {
        if (this.S == i3 && this.T == i16) {
            return;
        }
        this.S = i3;
        this.T = i16;
        O();
    }

    private void H(int i3, long j3, String str, String str2, String str3, String str4, double d16, CoverQzoneShowWebView.WebviewCoverListener webviewCoverListener, boolean z16) {
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null && !(iCoverBaseView instanceof CoverQzoneShowWebView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        if (!z16) {
            this.f48723f.sendEmptyMessage(QzoneCoverConst.MSG_UNSET_SUPER_COVER);
        }
        this.f48721d = 255;
        ICoverBaseView iCoverBaseView2 = this.f48722e;
        if (iCoverBaseView2 != null && ((CoverQzoneShowWebView) iCoverBaseView2).mQzoneShowWebView != null) {
            ((CoverQzoneShowWebView) iCoverBaseView2).reloadWeb(j3, str, str2, str3);
            return;
        }
        if (iCoverBaseView2 != null) {
            iCoverBaseView2.onDestroy();
            this.V = true;
        }
        CoverQzoneShowWebView coverQzoneShowWebView = new CoverQzoneShowWebView(i3, getContext(), this.f48725i, j3, str, str2, str3, str4, d16, webviewCoverListener);
        this.f48722e = coverQzoneShowWebView;
        coverQzoneShowWebView.initAndShow(this, this.V);
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onHierarchyChange(ViewGroup viewGroup) {
        if (14 == getCoverType()) {
            CoverEnv.setDynamicCoverHierarchyChange(this.f48722e, viewGroup);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void showFullscreenCover(ViewGroup viewGroup) {
        if (viewGroup == null) {
            VasLogReporter.getQzoneCover().report("showFullscreenCover parent null");
            return;
        }
        if (this.E == null) {
            this.E = new CoverFullScreenImageView(getContext());
            viewGroup.addView(this.E, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        this.E.setCurrentCacheData(this.f48724h);
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER.equals(this.f48724h.type)) {
            J(viewGroup);
        }
        CoverHelper.changeTransparency((View) getParent(), this.f48721d);
        View footerRootView = CoverEnv.getFooterRootView(this.f48725i);
        if (footerRootView != null) {
            footerRootView.getBackground().setAlpha(this.f48721d);
        }
        CoverEnv.notifyAdapter(this.f48725i);
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null && CoverEnv.isListView(childAt)) {
                childAt.setBackgroundColor(0);
            }
        }
        VasLogReporter.getQzoneCover().report("showFullscreenCover");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(CoverCacheData coverCacheData) {
        if (coverCacheData == null || !QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(coverCacheData.type) || coverCacheData.mapExtInfo == null) {
            return;
        }
        n(coverCacheData, QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH);
        n(coverCacheData, QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC);
        if (!coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC)) {
            coverCacheData.mapExtInfo.remove(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH);
        }
        n(coverCacheData, QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL);
        n(coverCacheData, QzoneCoverConst.KEY_VIDEO_COVER_PIC);
        if (!coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_PIC)) {
            coverCacheData.mapExtInfo.remove(QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL);
        }
        if (TextUtils.isEmpty(coverCacheData.mapExtInfo.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH)) || !TextUtils.isEmpty(coverCacheData.mapExtInfo.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC))) {
            return;
        }
        coverCacheData.mapExtInfo.remove(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH);
        coverCacheData.mapExtInfo.remove(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC);
        coverCacheData.mapExtInfo.remove(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_WIDTH);
        coverCacheData.mapExtInfo.remove(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_HEIGHT);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (!(iCoverBaseView instanceof CoverSuperImageView) && !(iCoverBaseView instanceof CoverQzoneShowWebView) && this.C != null) {
            this.C.draw(canvas);
        }
        ICoverBaseView iCoverBaseView2 = this.f48722e;
        if ((iCoverBaseView2 instanceof CoverQzoneShowWebView) || (iCoverBaseView2 instanceof CoverVideoCoverView) || (iCoverBaseView2 instanceof CoverGifView) || (iCoverBaseView2 instanceof CoverPanoramaView)) {
            super.onDraw(canvas);
        } else if (iCoverBaseView2 != null) {
            iCoverBaseView2.draw(canvas);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onHandleMessage(Message message) {
        if (message == null) {
            return;
        }
        int i3 = message.what;
        if (1000024 != i3) {
            if (i3 == 1192) {
                invalidate();
                return;
            }
            return;
        }
        int i16 = message.arg1;
        Bundle data = message.getData();
        CoverCacheData coverCacheData = this.f48724h;
        if (data != null) {
            coverCacheData = (CoverCacheData) data.getParcelable("data");
        }
        if (coverCacheData == null) {
            CoverLog.d(TAG + hashCode(), CoverLog.CLR, "\u6267\u884c\u5237\u65b0,but cover data is null.");
        } else {
            if (coverCacheData.uin != p()) {
                CoverLog.d(TAG + hashCode(), CoverLog.CLR, "uin\u4e0d\u540c\uff0c\u4e0d\u6267\u884c\u5237\u65b0 curr cover uin=" + p() + ",need refresh uin=" + coverCacheData.uin);
                return;
            }
            CoverLog.d(TAG + hashCode(), CoverLog.CLR, "uin\u4e00\u6837\uff0c\u6267\u884c\u5237\u65b0 need refresh uin=" + coverCacheData.uin);
        }
        this.H = 17;
        switch (i16) {
            case 0:
            case 3:
            case 4:
            case 5:
                C(i16, coverCacheData != null ? coverCacheData.alian : 3);
                break;
            case 1:
                E();
                break;
            case 2:
                D();
                break;
            case 6:
                if (this.R) {
                    VasNtCommonReporter.getHistoryFeature("qzone_webview_cover").setValue2(QzoneCoverConst.KEY_IS_QZONE_SHOW).reportEveryDay();
                    C(3, coverCacheData != null ? coverCacheData.alian : 3);
                    break;
                } else {
                    I();
                    break;
                }
            case 7:
                if (CoverEnv.isSupportSuperCover()) {
                    K(i16);
                    break;
                } else {
                    C(i16, coverCacheData != null ? coverCacheData.alian : 3);
                    break;
                }
            case 8:
                CoverCacheData coverCacheData2 = this.f48724h;
                if (coverCacheData2 != null) {
                    String contentTypeFamousSpaceBgUrl = CoverEnv.getContentTypeFamousSpaceBgUrl(coverCacheData2.uin);
                    setCustomWebviewCover(this.f48724h.uin, w(CoverEnv.getContentTypeFamousSpaceWebviewUrl(this.f48724h.uin)), contentTypeFamousSpaceBgUrl, contentTypeFamousSpaceBgUrl);
                    break;
                }
                break;
            case 9:
            case 15:
                L();
                break;
            case 10:
                A();
                break;
            case 12:
            case 13:
            case 14:
                B();
                break;
            case 16:
                y();
                break;
            case 17:
                if (this.R) {
                    VasNtCommonReporter.getHistoryFeature("qzone_webview_cover").setValue2("webview_cover").reportEveryDay();
                    C(3, coverCacheData != null ? coverCacheData.alian : 3);
                    break;
                } else {
                    M();
                    break;
                }
            case 18:
                G();
                break;
            case 19:
                F(i16, coverCacheData != null ? coverCacheData.alian : 3);
                break;
        }
        ICoverBaseView iCoverBaseView = this.f48722e;
        if (iCoverBaseView != null) {
            iCoverBaseView.setRefer(this.L);
            IOnCoverClickListener iOnCoverClickListener = this.J;
            if (iOnCoverClickListener != null) {
                this.f48722e.setOnCoverClickListener(iOnCoverClickListener);
            }
        }
        O();
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setCacheCover(final long j3, final CoverCacheData coverCacheData) {
        if (p() != j3) {
            VasLogReporter.getQzoneCover().report("uin \u4e0d\u4e00\u81f4" + p());
            return;
        }
        if (j3 != CoverEnv.getLoginUin()) {
            this.C = null;
        }
        CoverEnv.getRealTimeThreadHandler().post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.QZoneCoverContainer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CoverCacheData coverCacheData2 = QZoneCoverContainer.this.f48724h;
                    CoverCacheData coverCacheData3 = coverCacheData;
                    if (coverCacheData3 == null) {
                        coverCacheData3 = CoverCacheManager.getInstance().getCoverFromCache(j3);
                    }
                    QZoneCoverContainer.this.f48724h = CoverHelper.copyObject(coverCacheData3);
                    QZoneCoverContainer.this.N();
                    QZoneCoverContainer.v(QZoneCoverContainer.this.f48724h);
                    boolean isCoverDataTheSame = CoverHelper.isCoverDataTheSame(coverCacheData2, coverCacheData3);
                    if (!isCoverDataTheSame) {
                        try {
                            if (QZoneCoverContainer.this.I != null) {
                                QZoneCoverContainer.this.I.onCoverChanged(coverCacheData2, QZoneCoverContainer.this.f48724h);
                            }
                        } catch (Exception e16) {
                            CoverLog.e(QZoneCoverContainer.TAG, "onCoverChanged exception", e16);
                        }
                    }
                    if (!isCoverDataTheSame || QZoneCoverContainer.this.t() || coverCacheData == null || QZoneCoverContainer.this.f48724h == null) {
                        if (QZoneCoverContainer.this.f48724h == null) {
                            if (j3 == CoverEnv.getLoginUin() || !CoverEnv.isNetworkAvailable()) {
                                CoverLog.e(QZoneCoverContainer.TAG, "2.cover cache is null,set empty cover,uin=" + j3, null);
                                QZoneCoverContainer.this.z();
                                return;
                            }
                            return;
                        }
                        if (CoverLog.isColorLevel()) {
                            CoverLog.i(QZoneCoverContainer.TAG, CoverLog.CLR, "type=" + QZoneCoverContainer.this.f48724h.type + "," + CoverHelper.toPrintString(QZoneCoverContainer.this.f48724h.mapExtInfo) + ",coverId=" + QZoneCoverContainer.this.f48724h.coverId + ",local_url=" + QZoneCoverContainer.this.f48724h.local_url + " ,urls=" + CoverHelper.toPrintString(QZoneCoverContainer.this.f48724h.urls));
                        }
                        int checkCoverType = CoverHelper.checkCoverType(QZoneCoverContainer.this.f48724h);
                        int i3 = (checkCoverType == 3 && CoverEnv.getShowCoverGuide(QZoneCoverContainer.this.getContext())) ? 1 : 0;
                        if (checkCoverType != 0) {
                            QZonePerfReporter.f59697a.j("custom", "[Cover]qzone_cover_" + checkCoverType);
                        }
                        if (CoverLog.isDevelopLevel()) {
                            CoverLog.d(QZoneCoverContainer.TAG, CoverLog.DEV, "setCacheCover, cover type:" + checkCoverType + ", cover guide:" + i3);
                        }
                        if (QZoneCoverContainer.this.f48723f == null) {
                            CoverLog.e(QZoneCoverContainer.TAG, "setCacheCover error, mHandler is null", null);
                            return;
                        }
                        CoverLog.i(QZoneCoverContainer.TAG, CoverLog.CLR, "3.cover not the same send msg MSG_COVER_UPDATE_UI");
                        Message obtain = Message.obtain(QZoneCoverContainer.this.f48723f, QzoneCoverConst.MSG_COVER_UPDATE_UI, checkCoverType, i3);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("data", QZoneCoverContainer.this.f48724h);
                        obtain.setData(bundle);
                        QZoneCoverContainer.this.f48723f.sendMessage(obtain);
                        return;
                    }
                    CoverLog.i(QZoneCoverContainer.TAG, CoverLog.CLR, "cover is the same not update cover,refer=" + QZoneCoverContainer.this.L);
                } catch (Exception e17) {
                    CoverLog.e(QZoneCoverContainer.TAG, "setCacheCover error", e17);
                }
            }
        });
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void setVisiblePadding(int i3) {
        int coverPaddingTop = CoverEnv.getCoverPaddingTop();
        CoverCacheData coverCacheData = this.f48724h;
        scrollTo(0, (coverCacheData == null || !coverCacheData.type.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_GAME)) ? (int) (((coverPaddingTop - i3) / 2.0f) + 0.5f) : -i3);
    }

    private void K(int i3) {
        String str;
        ICoverBaseView iCoverBaseView;
        boolean z16 = 7 == i3;
        if (z16 && (iCoverBaseView = this.f48722e) != null && !(iCoverBaseView instanceof CoverSuperImageView)) {
            iCoverBaseView.onDestroy();
            this.f48722e = null;
        }
        if (z16) {
            q();
        }
        if (z16 && this.f48722e == null) {
            CoverSuperImageView coverSuperImageView = new CoverSuperImageView();
            coverSuperImageView.setCoverBaseParent(this);
            coverSuperImageView.init();
            this.f48722e = coverSuperImageView;
        }
        if (z16) {
            str = QzoneCoverConst.KEY_TRANSPARENCY;
        } else {
            str = QzoneCoverConst.COVER_QZONE_SHOW_TRANS;
        }
        String str2 = this.f48724h.mapExtInfo.get(str);
        if (str2 != null) {
            this.f48721d = CoverCacheManager.transparencyValueRealValue(str2);
        }
        this.f48723f.sendMessage(this.f48723f.obtainMessage(QzoneCoverConst.MSG_SET_SUPER_COVER, this.f48724h));
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public FrameLayout getAttachView() {
        return this;
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void onCoverInvislble() {
    }

    @Override // com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer
    public void stopCover() {
    }
}
