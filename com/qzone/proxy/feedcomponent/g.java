package com.qzone.proxy.feedcomponent;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.app.ResourcePreloader;
import com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFeedFragmentFeedImp;
import com.qzone.common.business.QzoneLocalDownloadListener;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.business.publishqueue.QZoneReportTaskQueue;
import com.qzone.publish.business.task.QZoneReportTask;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.x;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Prototype;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.theme.SkinnableBitmapDrawable;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
@Prototype
/* loaded from: classes39.dex */
public class g extends FeedGlobalEnv {

    /* renamed from: d, reason: collision with root package name */
    private static String f50152d = "NULL";

    /* renamed from: a, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, String> f50153a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f50154b;

    /* renamed from: c, reason: collision with root package name */
    Handler f50155c = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f50156a;

        static {
            int[] iArr = new int[ViewSectionType.values().length];
            f50156a = iArr;
            try {
                iArr[ViewSectionType.GDT_CAROUSEL_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50156a[ViewSectionType.GDT_DESCRIPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Inject
    public g() {
    }

    private String a(String str) {
        if ("[em]e179[/em]".equals(str)) {
            return "https://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/poly_praise/100000/100001/praise.png";
        }
        if ("[em]e113[/em]".equals(str)) {
            return "https://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/poly_praise/100000/100002/praise.png";
        }
        if ("[em]e109[/em]".equals(str)) {
            return "https://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/poly_praise/100000/100003/praise.png";
        }
        if ("[em]e144[/em]".equals(str)) {
            return "https://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/poly_praise/100000/100004/praise.png";
        }
        if ("[em]e111[/em]".equals(str)) {
            return "https://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/poly_praise/100000/100005/praise.png";
        }
        if ("[em]e153[/em]".equals(str)) {
            return "https://qzonestyle.gtimg.cn/qzone/photo/v7/js/common/images/poly_praise/100000/100006/praise.png";
        }
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean canDownloadFont() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean checkHasInstallPackage(Context context, String str) {
        return com.tencent.mobileqq.cooperation.a.d(str, context);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public Object createViewSection(ViewSectionType viewSectionType, Context context, Object obj) {
        int i3 = a.f50156a[viewSectionType.ordinal()];
        if (i3 == 1) {
            return new h6.b(context, (NormalAbsFeedView) obj);
        }
        if (i3 != 2) {
            return null;
        }
        return new h6.d(context, (NormalAbsFeedView) obj);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getBitmapRef().getBitmap();
        }
        if (drawable instanceof SpecifiedBitmapDrawable) {
            return ((SpecifiedBitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public byte[] encodeJceStrcut(JceStruct jceStruct) {
        return t5.b.c(jceStruct);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public Class getAddGroupQQProxy() {
        return QQBrowserActivity.class;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public Handler getAsyncRenderHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public Handler getBackgroundHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public String getCacheDir(String str) {
        return ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).getCacheDir(str);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public SharedPreferences getCachePreference(Context context, long j3) {
        return u5.b.N(j3);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getColor(int i3) {
        return com.qzone.adapter.feedcomponent.j.c(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getColorId(int i3) {
        return com.qzone.adapter.feedcomponent.j.d(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getCurrentPhotoMode() {
        return BaseFeedFragmentFeedImp.q();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public float getDensity() {
        return ViewUtils.getDensity();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getDensityDpi() {
        return (int) ViewUtils.getDensityDpi();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public Drawable getDrawable(int i3) {
        return com.qzone.adapter.feedcomponent.j.g(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getDrawableId(int i3) {
        return com.qzone.adapter.feedcomponent.j.h(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public String getGuideCommentRedpocketIconUrl() {
        if ("NULL".equals(f50152d)) {
            f50152d = LocalMultiProcConfig.getString4Uin("qzone_redpocket_guide_comment_icon_url", null, LoginData.getInstance().getUin());
        }
        return f50152d;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public String getImgUrlByStrEmotion(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f50153a != null && this.f50153a.containsKey(str)) {
            return this.f50153a.get(str);
        }
        return a(str);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public ExecutorService getLightThreadPool() {
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getNetworkType() {
        return com.tencent.biz.common.util.g.a(BaseApplication.getContext());
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getNumCores() {
        return x.b();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getPixelPerCM() {
        return ViewUtils.getPixelPerCM();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public Context getPluginContext() {
        return ResourcePreloader.b().c();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public String getPraiseResrourceUrl(String str) {
        return u5.b.h0(str, "");
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public float getScaledDensity() {
        return ViewUtils.getScaleDensity();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getScreenHeight() {
        pl.a aVar = pl.a.f426446a;
        if (aVar.B(BaseApplication.getContext())) {
            return aVar.t(BaseApplication.getContext());
        }
        return ViewUtils.getScreenHeight();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public double getScreenSizeCM() {
        return ViewUtils.getScreenSizeCM();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public int getScreenWidth() {
        pl.a aVar = pl.a.f426446a;
        if (aVar.B(BaseApplication.getContext())) {
            return aVar.u(BaseApplication.getContext());
        }
        return ViewUtils.getScreenWidth();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public float getSpValue(float f16) {
        return ViewUtils.getSpValue(f16);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public String getStrEmotionByPos(int i3) {
        ArrayList<String> arrayList = this.f50154b;
        if (arrayList != null && arrayList.size() > i3) {
            return this.f50154b.get(i3);
        }
        return b(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public long getUin() {
        return LoginData.getInstance().getUin();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean isAccessibilityEnable() {
        return u5.a.e();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean isAudioPlayerParameter() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean isBestPerformanceDevice() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean isDebug() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean isNetworkAvailable(Context context) {
        return NetworkState.isNetSupport();
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean isViewDebugMode() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public m obtainDbManager(Class cls, long j3, String str) {
        return s8.a.q(cls, j3, str);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void postRunnableToTTTThread(Runnable runnable) {
        Looper looper = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getLooper();
        if (looper != null && Thread.currentThread() == looper.getThread()) {
            runnable.run();
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler().post(runnable);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void postRunnableToUIThread(Runnable runnable) {
        this.f50155c.post(runnable);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void putEmotionUrlMap(String str, String str2) {
        if (this.f50153a == null) {
            this.f50153a = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.f50153a.containsKey(str)) {
            return;
        }
        if (this.f50154b == null) {
            this.f50154b = new ArrayList<>();
        }
        this.f50154b.add(str);
        this.f50153a.put(str, str2);
        if (ImageLoader.getInstance().loadImageSync(str2) == null) {
            ImageLoader.getInstance().downloadImageOnly(str2, null);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void savePraiseResrourceUrl(String str, String str2) {
        u5.b.v0(str, str2);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void showToast(int i3, Context context, CharSequence charSequence) {
        ToastUtil.r(charSequence);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public boolean checkLiveVideoGuest() {
        return ag.a(false);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void sendFeedActionReportDataToOutbox(String str, long j3) {
        if (UploadEnv.getIpStack(0) == 2) {
            if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_ENABLE_V6_TTT_REPORT, 0) == 1) {
                QZoneReportTaskQueue.h().d(new QZoneReportTask(str));
                return;
            }
            return;
        }
        QZoneReportTaskQueue.h().d(new QZoneReportTask(str));
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void showToast(int i3, Context context, CharSequence charSequence, int i16) {
        ToastUtil.s(charSequence, i16);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void removeButton(Object obj) {
        if (obj == null || !(obj instanceof DownloadImmediatelyContract.Presenter)) {
            return;
        }
        QzoneLocalDownloadListener.d().g((DownloadImmediatelyContract.Presenter) obj);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void postRunnableToBackgroundThread(Runnable runnable) {
        ThreadManagerV2.post(runnable, 2, null, false);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void postRunnableToNormalThread(Runnable runnable) {
        ThreadManagerV2.post(runnable, 5, null, false);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void postTaskToHeavyThreadPool(Runnable runnable) {
        ThreadManagerV2.post(runnable, 5, null, false);
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void submitRealTimeJob(Runnable runnable) {
        ThreadManagerV2.post(runnable, 8, null, false);
    }

    private String b(int i3) {
        if (i3 == 0) {
            return "[em]e179[/em]";
        }
        if (i3 == 1) {
            return "[em]e113[/em]";
        }
        if (i3 == 2) {
            return "[em]e109[/em]";
        }
        if (i3 == 3) {
            return "[em]e144[/em]";
        }
        if (i3 == 4) {
            return "[em]e111[/em]";
        }
        if (i3 != 5) {
            return null;
        }
        return "[em]e153[/em]";
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void assertUiThread() {
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void setPossibleCrashText(String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void tryPreLoadAdData(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.FeedGlobalEnv
    public void updateButtonStatus(String str, Object obj) {
    }
}
