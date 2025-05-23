package com.qq.e.tg.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.ArrayUtilStub;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.TGSplashAD;
import com.qq.e.tg.splash.TGSplashPreCacheUtil;
import com.qq.e.tg.splash.report.SplashStubEvent;
import com.qq.e.tg.splash.report.TADSplashReportUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TGSplashHotLaunchHelper {

    /* renamed from: a, reason: collision with root package name */
    private ImageLoadListener f40793a;

    /* renamed from: b, reason: collision with root package name */
    private ImageLoadListener f40794b;

    /* renamed from: c, reason: collision with root package name */
    private volatile PreCacheSplashAd f40795c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Bitmap f40796d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ImageLoadListener implements TGSplashPreCacheUtil.AdImageLoadListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<TGSplashHotLaunchHelper> f40800a;

        /* renamed from: b, reason: collision with root package name */
        private PreCacheSplashAd f40801b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f40802c;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<PrepareSplashImageListener> f40803d;

        ImageLoadListener(WeakReference<TGSplashHotLaunchHelper> weakReference, PreCacheSplashAd preCacheSplashAd, boolean z16, WeakReference<PrepareSplashImageListener> weakReference2) {
            this.f40800a = weakReference;
            this.f40801b = preCacheSplashAd;
            this.f40802c = z16;
            this.f40803d = weakReference2;
        }

        @Override // com.qq.e.tg.splash.TGSplashPreCacheUtil.AdImageLoadListener
        public final void onLoadFailed(int i3) {
            TGSplashHotLaunchHelper tGSplashHotLaunchHelper;
            int i16;
            WeakReference<TGSplashHotLaunchHelper> weakReference = this.f40800a;
            if (weakReference != null) {
                tGSplashHotLaunchHelper = weakReference.get();
            } else {
                tGSplashHotLaunchHelper = null;
            }
            if (tGSplashHotLaunchHelper != null) {
                if (this.f40802c) {
                    i16 = SplashStubEvent.BACKUP_IMG_PRE_DECODE_FAIL;
                } else {
                    i16 = SplashStubEvent.N21_IMG_PRE_DECODE_FAIL;
                }
                tGSplashHotLaunchHelper.a(i16);
            }
            WeakReference<PrepareSplashImageListener> weakReference2 = this.f40803d;
            if (weakReference2 != null && weakReference2.get() != null) {
                this.f40803d.get().onPrepareFailed(i3);
            }
        }

        @Override // com.qq.e.tg.splash.TGSplashPreCacheUtil.AdImageLoadListener
        public final void onLoaded(Bitmap bitmap) {
            TGSplashHotLaunchHelper tGSplashHotLaunchHelper;
            GDTLogger.i("TGSplashHotLaunchHelper hot launch bitmap ready isBackup ?" + this.f40802c);
            WeakReference<TGSplashHotLaunchHelper> weakReference = this.f40800a;
            if (weakReference != null) {
                tGSplashHotLaunchHelper = weakReference.get();
            } else {
                tGSplashHotLaunchHelper = null;
            }
            if (tGSplashHotLaunchHelper == null) {
                GDTLogger.e("onLoaded helper == null");
                return;
            }
            if (!this.f40802c) {
                tGSplashHotLaunchHelper.a(SplashStubEvent.N21_IMG_PRE_DECODE_SUCCESS);
                tGSplashHotLaunchHelper.f40795c = this.f40801b;
                tGSplashHotLaunchHelper.f40796d = bitmap;
                WeakReference<PrepareSplashImageListener> weakReference2 = this.f40803d;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f40803d.get().onPrepareSuccess();
                }
            } else {
                tGSplashHotLaunchHelper.a(SplashStubEvent.BACKUP_IMG_PRE_DECODE_SUCCESS);
                if (tGSplashHotLaunchHelper.f40795c == null) {
                    tGSplashHotLaunchHelper.f40795c = this.f40801b;
                    tGSplashHotLaunchHelper.f40796d = bitmap;
                }
            }
            GDTLogger.i("TGSplashHotLaunchHelper helper.mCanShowAd ?" + tGSplashHotLaunchHelper.f40795c);
            GDTLogger.i("TGSplashHotLaunchHelper helper.mCanShowImage ?" + tGSplashHotLaunchHelper.f40796d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface PrepareSplashImageListener {
        void onPrepareFailed(int i3);

        void onPrepareSuccess();
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public boolean canShow() {
        ?? r06;
        if (TGSplashBackupOrderHolder.getInstance().getBackupSplashPreCacheResult() != null) {
            r06 = 1;
        } else {
            r06 = 0;
        }
        TADSplashReportUtil.report(SplashStubEvent.HOT_LAUNCH_CAN_SHOW, r06, null, null);
        return r06;
    }

    public void clearCache() {
        TGSplashBackupOrderHolder.getInstance().b();
    }

    public TGSplashPreCacheResult getPreCacheBackupOrder() {
        return TGSplashBackupOrderHolder.getInstance().getBackupSplashPreCacheResult();
    }

    public void prepare(final Context context, final WeakReference<PrepareSplashImageListener> weakReference) {
        GDTLogger.i("TGSplashHotLaunchHelper start prepare");
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashHotLaunchHelper.1
            @Override // java.lang.Runnable
            public void run() {
                TGSplashHotLaunchHelper.this.a(SplashStubEvent.PREPARE_START);
                TGSplashHotLaunchHelper.a(TGSplashHotLaunchHelper.this, context, weakReference);
                TGSplashHotLaunchHelper.b(TGSplashHotLaunchHelper.this, context, weakReference);
            }
        });
    }

    public void reportEmptyOrderHotLaunch(TGSplashAD tGSplashAD) {
        GDTLogger.i("TGSplashHotLaunchHelper reportEmptyOrderHotLaunch");
        if (tGSplashAD == null) {
            return;
        }
        PreCacheSplashAd cachedEmptyOrder = TGSplashBackupOrderHolder.getInstance().getCachedEmptyOrder();
        if (cachedEmptyOrder != null) {
            GDTLogger.i("TGSplashHotLaunchHelper reportEmptyOrderHotLaunch url:" + cachedEmptyOrder.getApUrl());
            TADSplashReportUtil.report(SplashStubEvent.HOT_LAUNCH_REPORT_EMPTY_ORDER, 0, null, null);
            TGSplashAD.FetchAdParams fetchAdParams = new TGSplashAD.FetchAdParams();
            fetchAdParams.emptyOrderApUrl = cachedEmptyOrder.getApUrl();
            tGSplashAD.reportEmptyOrderIfNecessaryAndPreFetchAd(fetchAdParams);
            return;
        }
        GDTLogger.e("TGSplashHotLaunchHelper reportEmptyOrderHotLaunch NO emptyOrder");
        TADSplashReportUtil.report(SplashStubEvent.HOT_LAUNCH_REPORT_EMPTY_ORDER_FAIL_NULL_DATA, 0, null, null);
    }

    public void show(TGSplashAD tGSplashAD, ViewGroup viewGroup, long j3) {
        GDTLogger.i("TGSplashHotLaunchHelper start show");
        if (tGSplashAD != null) {
            TGSplashAD.SplashDisplayParams splashDisplayParams = new TGSplashAD.SplashDisplayParams();
            splashDisplayParams.bitmap = this.f40796d;
            splashDisplayParams.splashAd = this.f40795c;
            splashDisplayParams.container = viewGroup;
            splashDisplayParams.firstFrameTimeout = j3;
            GDTLogger.i("TGSplashHotLaunchHelper params.bitmap " + splashDisplayParams.bitmap);
            GDTLogger.i("TGSplashHotLaunchHelper params.splashAd " + splashDisplayParams.splashAd);
            GDTLogger.i("TGSplashHotLaunchHelper params.container " + splashDisplayParams.container);
            TADSplashReportUtil.report(SplashStubEvent.HOT_LAUNCH_SHOW, 0, null, null);
            tGSplashAD.showAd(splashDisplayParams);
        }
    }

    static /* synthetic */ void b(TGSplashHotLaunchHelper tGSplashHotLaunchHelper, Context context, WeakReference weakReference) {
        tGSplashHotLaunchHelper.a(SplashStubEvent.N21_SELECT_START);
        List<PreCacheSplashAd> cachedOrdersByDate = TGSplashBackupOrderHolder.getInstance().getCachedOrdersByDate(TGSplashPreCacheUtil.getTodayDate());
        if (ArrayUtilStub.isNotNullAndEmpty(cachedOrdersByDate)) {
            for (PreCacheSplashAd preCacheSplashAd : cachedOrdersByDate) {
                if (preCacheSplashAd != null && preCacheSplashAd.isValid(context)) {
                    tGSplashHotLaunchHelper.a(SplashStubEvent.N21_SELECT_SUCCESS);
                    GDTLogger.i("TGSplashHotLaunchHelper [selectOrderByCurrentDateAndPrepareImage] order uoid:" + preCacheSplashAd.getUoid() + " aid :" + preCacheSplashAd.getAid());
                    if (tGSplashHotLaunchHelper.f40794b == null) {
                        tGSplashHotLaunchHelper.f40794b = new ImageLoadListener(new WeakReference(tGSplashHotLaunchHelper), preCacheSplashAd, false, weakReference);
                    }
                    tGSplashHotLaunchHelper.a(SplashStubEvent.N21_IMG_PRE_DECODE_START);
                    TGSplashPreCacheUtil.preloadAdImages(context, preCacheSplashAd, new WeakReference(tGSplashHotLaunchHelper.f40794b));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        TADSplashReportUtil.report(i3, 0, null, null);
    }

    static /* synthetic */ void a(TGSplashHotLaunchHelper tGSplashHotLaunchHelper, Context context, WeakReference weakReference) {
        PreCacheSplashAd a16 = TGSplashBackupOrderHolder.getInstance().a();
        if (context == null || a16 == null) {
            return;
        }
        if (tGSplashHotLaunchHelper.f40793a == null) {
            tGSplashHotLaunchHelper.f40793a = new ImageLoadListener(new WeakReference(tGSplashHotLaunchHelper), a16, true, weakReference);
        }
        tGSplashHotLaunchHelper.a(SplashStubEvent.BACKUP_IMG_PRE_DECODE_START);
        TGSplashPreCacheUtil.preloadAdImages(context, a16, new WeakReference(tGSplashHotLaunchHelper.f40793a));
    }
}
