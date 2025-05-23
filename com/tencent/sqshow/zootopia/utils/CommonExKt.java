package com.tencent.sqshow.zootopia.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.nano.MessageNano;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a,\u0010\u000b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a(\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a*\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t\u001a\u001c\u0010\u0016\u001a\u00020\u0012*\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\t\u001a\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018*\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\u001a\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001c\u001a\u0012\u0010!\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0001\u001a!\u0010%\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\"*\u00020\u000f2\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&\u001a\n\u0010'\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010)\u001a\u00020\f*\u00020(\u001a$\u0010+\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010*\u001a\n\u0010-\u001a\u00020,*\u00020\u0001\u001a\u0014\u00100\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120.\u001a\n\u00101\u001a\u00020\u001c*\u00020\u0001\u001a'\u00105\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\"*\u000202*\u0004\u0018\u0001032\u0006\u00104\u001a\u00028\u0000\u00a2\u0006\u0004\b5\u00106\u001a\f\u00108\u001a\u0004\u0018\u000107*\u00020\f\u001a\u001c\u0010:\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120.2\u0006\u00109\u001a\u00020\u0017\u001a\f\u0010;\u001a\u00020\u001c*\u0004\u0018\u000103\u001a\n\u0010<\u001a\u00020\u0001*\u00020\u0001\u001a\u000e\u0010>\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0001\u001a\u000e\u0010?\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0001\u00a8\u0006@"}, d2 = {"Lcom/tencent/image/URLImageView;", "", "url", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "options", "Lcom/tencent/image/URLDrawableDownListener;", "listener", "Lcom/tencent/image/URLDrawable;", "u", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "t", "", "defaultDrawableResId", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "colorResId", "", "y", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "r", "", "", "d", "(J)[Ljava/lang/String;", "key", "Lorg/json/JSONObject;", "value", "c", "Landroid/net/Uri;", "needRemovedKey", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "T", "Lcom/tencent/mobileqq/zplan/api/ZplanCacheComponentType;", "type", "p", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/api/ZplanCacheComponentType;)Ljava/lang/Object;", "g", "Landroid/app/Activity;", "e", "Lcom/tencent/image/URLDrawable$DownloadListener;", DomainData.DOMAIN_NAME, "", "f", "Lkotlin/Function0;", "task", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/google/protobuf/nano/MessageNano;", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, BdhLogUtil.LogTag.Tag_Conn, "([BLcom/google/protobuf/nano/MessageNano;)Lcom/google/protobuf/nano/MessageNano;", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "D", "delayMillis", tl.h.F, "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "toast", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CommonExKt {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/utils/CommonExKt$a", "Lcom/tencent/image/URLDrawable$DownloadListener;", "", "onFileDownloadStarted", "", "p0", "onFileDownloadSucceed", "", "onFileDownloadFailed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements URLDrawable.DownloadListener {

        /* renamed from: d */
        final /* synthetic */ String f373222d;

        /* renamed from: e */
        final /* synthetic */ URLDrawable.DownloadListener f373223e;

        a(String str, URLDrawable.DownloadListener downloadListener) {
            this.f373222d = str;
            this.f373223e = downloadListener;
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int p06) {
            QLog.e("String.preloadUrl", 1, "onFileDownloadFailed (" + p06 + ") " + this.f373222d);
            URLDrawable.DownloadListener downloadListener = this.f373223e;
            if (downloadListener != null) {
                downloadListener.onFileDownloadFailed(p06);
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            QLog.d("String.preloadUrl", 4, "onFileDownloadStarted " + this.f373222d);
            URLDrawable.DownloadListener downloadListener = this.f373223e;
            if (downloadListener != null) {
                downloadListener.onFileDownloadStarted();
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long p06) {
            QLog.i("String.preloadUrl", 1, "onFileDownloadSucceed (" + p06 + ") " + this.f373222d);
            URLDrawable.DownloadListener downloadListener = this.f373223e;
            if (downloadListener != null) {
                downloadListener.onFileDownloadSucceed(p06);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/sqshow/zootopia/utils/CommonExKt$b", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "progress", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements URLDrawableDownListener {

        /* renamed from: d */
        final /* synthetic */ Context f373224d;

        /* renamed from: e */
        final /* synthetic */ int f373225e;

        b(Context context, int i3) {
            this.f373224d = context;
            this.f373225e = i3;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable drawable) {
            Drawable f16 = cn.f(drawable);
            if (f16 == null) {
                return;
            }
            f16.setColorFilter(this.f373224d.getResources().getColor(this.f373225e), PorterDuff.Mode.SRC_IN);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable drawable, Throwable r46) {
            QLog.e("URLImageView", 1, "setUrlSafetyWithColorFilter, onLoadFailed", r46);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable drawable, InterruptedException e16) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable drawable, int progress) {
        }
    }

    public static final JSONObject A(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static final <T extends MessageNano> T C(byte[] bArr, T instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        try {
            return (T) MessageNano.mergeFrom(instance, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final UEAvatarGender D(int i3) {
        UEAvatarGender uEAvatarGender = UEAvatarGender.MALE;
        if (i3 == uEAvatarGender.getIndex()) {
            return uEAvatarGender;
        }
        UEAvatarGender uEAvatarGender2 = UEAvatarGender.FEMALE;
        if (i3 == uEAvatarGender2.getIndex()) {
            return uEAvatarGender2;
        }
        return null;
    }

    public static final String c(String str, String key, JSONObject value) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Uri uri = Uri.parse(str);
        String queryParameter = uri.getQueryParameter(ISchemeApi.KEY_SCENE_DATA);
        if (queryParameter == null) {
            return str;
        }
        try {
            jSONObject = new JSONObject(queryParameter);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return str;
        }
        jSONObject.put(key, value);
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        Uri.Builder buildUpon = q(uri, ISchemeApi.KEY_SCENE_DATA).buildUpon();
        buildUpon.appendQueryParameter(ISchemeApi.KEY_SCENE_DATA, jSONObject.toString());
        String uri2 = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "builder.build().toString()");
        return uri2;
    }

    public static final int e(Activity activity) {
        int statusBarHeight;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        LiuHaiUtils.initLiuHaiProperty(activity);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            statusBarHeight = LiuHaiUtils.getNotchInScreenHeight(activity);
        } else {
            statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
        }
        QLog.i("Activity", 1, "getRealStatusBarHeight init = " + statusBarHeight);
        return statusBarHeight;
    }

    public static final boolean f(String str) {
        boolean equals;
        Intrinsics.checkNotNullParameter(str, "<this>");
        equals = StringsKt__StringsJVMKt.equals(str, "true", true);
        return equals;
    }

    public static final String g(String str) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(str, "<this>");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(str.length(), 100);
        String substring = str.substring(0, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        if (str.length() <= 100) {
            return substring;
        }
        return substring + "...(" + str.length() + ")";
    }

    public static final void h(final Function0<Unit> task, long j3) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                CommonExKt.i(Function0.this);
            }
        }, j3);
    }

    public static final void i(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.invoke();
    }

    public static final void j(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            task.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.utils.d
                @Override // java.lang.Runnable
                public final void run() {
                    CommonExKt.k(Function0.this);
                }
            });
        }
    }

    public static final void k(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.invoke();
    }

    public static final void l(final String toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.utils.CommonExKt$postToastDefault$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(BaseApplication.getContext(), 0, toast, 0).show();
            }
        });
    }

    public static final void m(final String toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.utils.CommonExKt$postToastError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(BaseApplication.getContext(), 1, toast, 0).show();
            }
        });
    }

    public static final URLDrawable n(String str, Drawable drawable, URLDrawable.DownloadListener downloadListener) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
            drawable2.setDownloadListener(new a(str, downloadListener));
            drawable2.startDownload();
            QLog.d("String.preloadUrl", 4, "preload url:" + str);
            return drawable2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final <T> T p(Context context, ZplanCacheComponentType type) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        T t16 = (T) ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(context, type);
        if (t16 == null) {
            return null;
        }
        return t16;
    }

    public static final Uri q(Uri uri, String needRemovedKey) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(needRemovedKey, "needRemovedKey");
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(uri.getScheme());
        builder.authority(uri.getAuthority());
        builder.path(uri.getPath());
        HashSet<String> hashSet = new HashSet(queryParameterNames);
        hashSet.remove(needRemovedKey);
        for (String str : hashSet) {
            builder.appendQueryParameter(str, uri.getQueryParameter(str));
        }
        Uri build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final void r(URLImageView uRLImageView, pu4.g gVar, Drawable defaultDrawable) {
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(defaultDrawable, "defaultDrawable");
        if (gVar == null) {
            QLog.e("URLImageView", 1, "setMaterial failed, material is null!");
            return;
        }
        String url = gVar.f427434a;
        String str = gVar.f427435b;
        URLDrawable.URLDrawableOptions option = URLDrawable.URLDrawableOptions.obtain();
        option.mLoadingDrawable = defaultDrawable;
        option.mFailedDrawable = defaultDrawable;
        if (Intrinsics.areEqual(str, "gif")) {
            option.mPlayGifImage = true;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        Intrinsics.checkNotNullExpressionValue(option, "option");
        x(uRLImageView, url, option, null, 4, null);
    }

    public static final URLDrawable s(URLImageView uRLImageView, String url, int i3, URLDrawableDownListener uRLDrawableDownListener) {
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        return t(uRLImageView, url, q.b(i3), uRLDrawableDownListener);
    }

    public static final URLDrawable t(URLImageView uRLImageView, String url, Drawable drawable, URLDrawableDownListener uRLDrawableDownListener) {
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        URLDrawable.URLDrawableOptions option = URLDrawable.URLDrawableOptions.obtain();
        option.mLoadingDrawable = drawable;
        option.mFailedDrawable = drawable;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        return u(uRLImageView, url, option, uRLDrawableDownListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final URLDrawable u(URLImageView uRLImageView, String url, URLDrawable.URLDrawableOptions options, URLDrawableDownListener uRLDrawableDownListener) {
        URLDrawable uRLDrawable;
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(options, "options");
        if (url.length() > 0) {
            if (uRLDrawableDownListener != null) {
                try {
                    uRLImageView.setURLDrawableDownListener(uRLDrawableDownListener);
                } catch (Exception e16) {
                    e = e16;
                    uRLDrawable = null;
                    QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                    if (uRLDrawableDownListener != null) {
                    }
                    return uRLDrawable;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    uRLDrawable = null;
                    QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                    if (uRLDrawableDownListener != null) {
                    }
                    return uRLDrawable;
                }
            }
            URLDrawable drawable = URLDrawable.getDrawable(url, options);
            try {
                uRLImageView.setImageDrawable(drawable);
                if (drawable.getStatus() == 1) {
                    if (uRLDrawableDownListener != null) {
                        uRLDrawableDownListener.onLoadSuccessed(uRLImageView, drawable);
                    }
                } else if (drawable.getStatus() == 2) {
                    drawable.restartDownload();
                }
                return drawable;
            } catch (Exception e18) {
                uRLDrawable = drawable;
                e = e18;
                QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                if (uRLDrawableDownListener != null) {
                    uRLDrawableDownListener.onLoadFailed(uRLImageView, null, e);
                }
                return uRLDrawable;
            } catch (OutOfMemoryError e19) {
                uRLDrawable = drawable;
                e = e19;
                QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                if (uRLDrawableDownListener != null) {
                    uRLDrawableDownListener.onLoadFailed(uRLImageView, null, e);
                }
                return uRLDrawable;
            }
        }
        uRLImageView.setImageDrawable(options.mFailedDrawable);
        if (uRLDrawableDownListener == null) {
            return null;
        }
        uRLDrawableDownListener.onLoadFailed(uRLImageView, null, null);
        return null;
    }

    public static final void y(URLImageView uRLImageView, Context context, String url, int i3, Drawable defaultDrawable) {
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(defaultDrawable, "defaultDrawable");
        t(uRLImageView, url, defaultDrawable, new b(context, i3));
    }

    public static final String z(String str) {
        boolean startsWith$default;
        String result = "";
        Intrinsics.checkNotNullParameter(str, "<this>");
        Matcher matcher = Pattern.compile("AnimMontage'(.*)\\.(.*)'").matcher(str);
        try {
            if (matcher.find()) {
                result = matcher.group(1);
            }
        } catch (Exception unused) {
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(result, "/Game/", false, 2, null);
        if (startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            result = result.substring(6);
            Intrinsics.checkNotNullExpressionValue(result, "this as java.lang.String).substring(startIndex)");
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public static final String[] d(long j3) {
        String[] strArr = new String[2];
        for (int i3 = 0; i3 < 2; i3++) {
            strArr[i3] = "";
        }
        if (j3 < 10000) {
            strArr[0] = String.valueOf(j3);
            strArr[1] = "";
            return strArr;
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            String format = new DecimalFormat("#.0").format(Float.valueOf((((float) j3) * 1.0f) / 10000));
            Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat(\"#.0\").format(showNum)");
            strArr[0] = format;
            strArr[1] = "\u4e07";
            return strArr;
        }
        String format2 = new DecimalFormat("#.0").format(Float.valueOf((((float) j3) * 1.0f) / 100000000));
        Intrinsics.checkNotNullExpressionValue(format2, "DecimalFormat(\"#.0\").format(showNum)");
        strArr[0] = format2;
        strArr[1] = "\u4ebf";
        return strArr;
    }

    public static final JSONObject B(byte[] bArr) {
        String str;
        if (bArr == null) {
            return new JSONObject();
        }
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            str = new String(bArr, UTF_8);
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            return new JSONObject();
        }
        return A(str);
    }

    public static /* synthetic */ URLDrawable v(URLImageView uRLImageView, String str, int i3, URLDrawableDownListener uRLDrawableDownListener, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            uRLDrawableDownListener = null;
        }
        return s(uRLImageView, str, i3, uRLDrawableDownListener);
    }

    public static /* synthetic */ URLDrawable x(URLImageView uRLImageView, String str, URLDrawable.URLDrawableOptions uRLDrawableOptions, URLDrawableDownListener uRLDrawableDownListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            uRLDrawableDownListener = null;
        }
        return u(uRLImageView, str, uRLDrawableOptions, uRLDrawableDownListener);
    }

    public static /* synthetic */ URLDrawable o(String str, Drawable drawable, URLDrawable.DownloadListener downloadListener, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drawable = q.b(R.drawable.gym);
        }
        if ((i3 & 2) != 0) {
            downloadListener = null;
        }
        return n(str, drawable, downloadListener);
    }

    public static /* synthetic */ URLDrawable w(URLImageView uRLImageView, String str, Drawable drawable, URLDrawableDownListener uRLDrawableDownListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            drawable = q.b(R.drawable.gym);
        }
        if ((i3 & 4) != 0) {
            uRLDrawableDownListener = null;
        }
        return t(uRLImageView, str, drawable, uRLDrawableDownListener);
    }
}
