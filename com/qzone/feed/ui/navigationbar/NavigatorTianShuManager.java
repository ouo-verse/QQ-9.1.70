package com.qzone.feed.ui.navigationbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.qq.e.comm.constants.TangramAppConstants;
import com.qzone.common.account.LoginData;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NavigatorTianShuManager {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<Activity> f47380a;

    /* renamed from: b, reason: collision with root package name */
    List<NavigatorItem> f47381b;

    /* renamed from: c, reason: collision with root package name */
    ImageView f47382c;

    /* renamed from: d, reason: collision with root package name */
    AsyncImageView f47383d;

    /* renamed from: e, reason: collision with root package name */
    String f47384e;

    /* renamed from: f, reason: collision with root package name */
    String f47385f;

    /* renamed from: g, reason: collision with root package name */
    public int f47386g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f47387h = 0;

    /* renamed from: i, reason: collision with root package name */
    TianShuGetAdvCallback f47388i = new TianShuGetAdvCallback() { // from class: com.qzone.feed.ui.navigationbar.NavigatorTianShuManager.1
        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            TianShuAccess.AdPlacementInfo adPlacementInfo;
            if (QZLog.isColorLevel()) {
                QZLog.i("NavigatorTianShuManager", "onGetAdvs isSucc:" + z16);
            }
            if (!z16 || getAdsRsp == null) {
                return;
            }
            List<TianShuAccess.RspEntry> list = getAdsRsp.mapAds.has() ? getAdsRsp.mapAds.get() : null;
            if (list == null) {
                QZLog.e("NavigatorTianShuManager", "rspEntries == null");
                return;
            }
            HashMap hashMap = new HashMap();
            for (TianShuAccess.RspEntry rspEntry : list) {
                if (rspEntry != null && rspEntry.key.has()) {
                    hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
                }
            }
            TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(FilterEnum.MIC_PTU_ZIRAN));
            if (rspEntry2 != null && (adPlacementInfo = rspEntry2.value) != null && adPlacementInfo.lst.size() != 0 && rspEntry2.value.lst.get(0) != null && rspEntry2.value.lst.get(0).argList != null && rspEntry2.value.lst.get(0).argList.get() != null) {
                List<TianShuAccess.MapEntry> list2 = rspEntry2.value.lst.get(0).argList.get();
                HashMap hashMap2 = new HashMap();
                for (TianShuAccess.MapEntry mapEntry : list2) {
                    String str = mapEntry.key.get();
                    String str2 = mapEntry.value.get();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        hashMap2.put(str, str2);
                    }
                }
                NavigatorTianShuManager.this.f47385f = String.valueOf(rspEntry2.value.lst.get(0).iAdId.get());
                try {
                    NavigatorTianShuManager.this.f47386g = Integer.parseInt((String) hashMap2.get("id"));
                } catch (Exception unused) {
                    NavigatorTianShuManager.this.f47386g = 20;
                }
                final String str3 = (String) hashMap2.get("icon url");
                if (TextUtils.isEmpty(str3)) {
                    str3 = (String) hashMap2.get(TangramAppConstants.ICON_URL);
                }
                NavigatorTianShuManager.this.f47384e = (String) hashMap2.get("text");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                for (NavigatorItem navigatorItem : NavigatorTianShuManager.this.f47381b) {
                    if (navigatorItem != null) {
                        int i3 = navigatorItem.G;
                        NavigatorTianShuManager navigatorTianShuManager = NavigatorTianShuManager.this;
                        if (i3 == navigatorTianShuManager.f47386g) {
                            navigatorTianShuManager.f47382c = navigatorItem.f47363f;
                            AsyncImageView asyncImageView = navigatorItem.I;
                            navigatorTianShuManager.f47383d = asyncImageView;
                            asyncImageView.setAsyncImageListener(navigatorTianShuManager.f47389j);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.feed.ui.navigationbar.NavigatorTianShuManager.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NavigatorTianShuManager.this.f47383d.setAsyncImage(str3);
                                }
                            });
                            return;
                        }
                    }
                }
                return;
            }
            QZLog.e("NavigatorTianShuManager", "data is error");
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private AsyncImageable.AsyncImageListener f47389j = new a();

    /* renamed from: k, reason: collision with root package name */
    private Runnable f47390k = new AnimationRunnable(this);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class AnimationRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<NavigatorTianShuManager> f47400d;

        AnimationRunnable(NavigatorTianShuManager navigatorTianShuManager) {
            this.f47400d = new WeakReference<>(navigatorTianShuManager);
        }

        @Override // java.lang.Runnable
        public void run() {
            NavigatorTianShuManager navigatorTianShuManager;
            WeakReference<NavigatorTianShuManager> weakReference = this.f47400d;
            if (weakReference == null || (navigatorTianShuManager = weakReference.get()) == null) {
                return;
            }
            navigatorTianShuManager.g();
        }
    }

    public NavigatorTianShuManager(Activity activity, List<NavigatorItem> list) {
        this.f47380a = new WeakReference<>(activity);
        this.f47381b = list;
    }

    public static void j(String str, boolean z16) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        String uinString = LoginData.getInstance().getUinString();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = uinString + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.180";
        tianShuReportData.mPageId = "tianshu.180";
        tianShuReportData.mItemId = str;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mActionId = z16 ? 101 : 102;
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    public void h() {
        if (QZLog.isColorLevel()) {
            QZLog.i("NavigatorTianShuManager", "getTianShuAd");
        }
        if (this.f47381b == null) {
            QZLog.e("NavigatorTianShuManager", "mItemList == null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = FilterEnum.MIC_PTU_ZIRAN;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(arrayList, this.f47388i);
    }

    public void i() {
        TianShuManager.getInstance().removeAdvCallback(this.f47388i);
        this.f47381b.clear();
    }

    private ObjectAnimator f(View view, String str, float f16, float f17, long j3, long j16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, f16, f17);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(j3);
        ofFloat.setStartDelay(j16);
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final View view, final View view2) {
        if (QZLog.isColorLevel()) {
            QZLog.i("NavigatorTianShuManager", "animationBegin");
        }
        if (view == null || view2 == null || !view.isShown() || view2.isShown()) {
            return;
        }
        ObjectAnimator f16 = f(view, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.15f, 120L, 0L);
        ObjectAnimator f17 = f(view, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.15f, 120L, 0L);
        ObjectAnimator f18 = f(view, BasicAnimation.KeyPath.ROTATION, 0.0f, 90.0f, 280L, 120L);
        ObjectAnimator f19 = f(view, BasicAnimation.KeyPath.SCALE_X, 1.15f, 0.0f, 280L, 120L);
        ObjectAnimator f26 = f(view, BasicAnimation.KeyPath.SCALE_Y, 1.15f, 0.0f, 280L, 120L);
        final ObjectAnimator f27 = f(view2, BasicAnimation.KeyPath.ROTATION, -90.0f, 0.0f, 280L, 0L);
        final ObjectAnimator f28 = f(view2, "ScaleX", 0.0f, 1.15f, 280L, 0L);
        final ObjectAnimator f29 = f(view2, "ScaleY", 0.0f, 1.15f, 280L, 0L);
        final ObjectAnimator f36 = f(view2, "ScaleX", 1.15f, 0.96f, 160L, 280L);
        final ObjectAnimator f37 = f(view2, "ScaleY", 1.15f, 0.96f, 160L, 280L);
        final ObjectAnimator f38 = f(view2, "ScaleX", 0.96f, 1.05f, 120L, 440L);
        final ObjectAnimator f39 = f(view2, "ScaleY", 0.96f, 1.05f, 120L, 440L);
        final ObjectAnimator f46 = f(view2, "ScaleX", 1.05f, 1.0f, 120L, 560L);
        final ObjectAnimator f47 = f(view2, "ScaleY", 1.05f, 1.0f, 120L, 560L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(f16).with(f17).with(f18).with(f19).with(f26);
        animatorSet.start();
        view2.postDelayed(new Runnable() { // from class: com.qzone.feed.ui.navigationbar.NavigatorTianShuManager.4
            @Override // java.lang.Runnable
            public void run() {
                view.setVisibility(8);
                view2.setVisibility(0);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(f27).with(f28).with(f29).with(f36).with(f37).with(f38).with(f39).with(f46).with(f47);
                animatorSet2.start();
            }
        }, 320L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f47380a;
        if (weakReference != null && weakReference.get() != null) {
            activity = this.f47380a.get();
        } else {
            ImageView imageView = this.f47382c;
            activity = (imageView == null || imageView.getContext() == null || !(this.f47382c.getContext() instanceof Activity)) ? null : (Activity) this.f47382c.getContext();
        }
        if (!TextUtils.isEmpty(this.f47384e)) {
            QzoneGuideBubbleHelper.g().i(activity, this.f47382c, this.f47384e, 0, 14.0f, 0.0d, 10.0d, 2300L, -1, -16777216, false, false, ViewUtils.dpToPx(6.0f), null, 0, true, 1.0f, null);
        }
        QzoneGuideBubbleHelper.g().i(activity, this.f47382c, this.f47384e, 0, 14.0f, 0.0d, 10.0d, 2300L, -1, -16777216, false, false, ViewUtils.dpToPx(6.0f), null, 0, true, 1.0f, null);
        e(this.f47382c, this.f47383d);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.qzone.feed.ui.navigationbar.NavigatorTianShuManager.3
            @Override // java.lang.Runnable
            public void run() {
                QzoneGuideBubbleHelper.g().f();
                NavigatorTianShuManager navigatorTianShuManager = NavigatorTianShuManager.this;
                navigatorTianShuManager.e(navigatorTianShuManager.f47383d, navigatorTianShuManager.f47382c);
            }
        }, 2000L);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AsyncImageable.AsyncImageListener {
        a() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            if (QZLog.isColorLevel()) {
                QZLog.i("NavigatorTianShuManager", "onImageFailed");
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            AsyncImageView asyncImageView;
            if (QZLog.isColorLevel()) {
                QZLog.i("NavigatorTianShuManager", "onImageLoaded");
            }
            if (asyncImageable == null || (asyncImageView = NavigatorTianShuManager.this.f47383d) == null) {
                return;
            }
            asyncImageView.setImageDrawable(asyncImageable.getDrawable());
            NavigatorTianShuManager navigatorTianShuManager = NavigatorTianShuManager.this;
            navigatorTianShuManager.f47383d.removeCallbacks(navigatorTianShuManager.f47390k);
            NavigatorTianShuManager navigatorTianShuManager2 = NavigatorTianShuManager.this;
            navigatorTianShuManager2.f47383d.postDelayed(navigatorTianShuManager2.f47390k, 100L);
            NavigatorTianShuManager.j(NavigatorTianShuManager.this.f47385f, true);
            NavigatorTianShuManager navigatorTianShuManager3 = NavigatorTianShuManager.this;
            navigatorTianShuManager3.f47387h = navigatorTianShuManager3.f47386g;
            LpReportInfo_pf00064.allReport(302, 32, 61, "1");
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
            if (QZLog.isColorLevel()) {
                QZLog.i("NavigatorTianShuManager", "onImageStarted");
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }
}
