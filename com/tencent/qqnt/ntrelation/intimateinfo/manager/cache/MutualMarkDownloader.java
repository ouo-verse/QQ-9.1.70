package com.tencent.qqnt.ntrelation.intimateinfo.manager.cache;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103JV\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\n\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\t`\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJN\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\t2&\u0010\r\u001a\"\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\t\u0012\u0004\u0012\u00020\f0\u000fJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\u001c\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'R\u0014\u0010)\u001a\u00020&8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010'R\u0017\u0010,\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b\u001e\u0010+R\u0017\u00101\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/manager/cache/MutualMarkDownloader;", "", "Landroid/content/Context;", "context", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "mutualMarkInfos", "Lkotlin/Function0;", "", "callback", "b", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "a", "iconUrl", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "listener", "Lcom/tencent/image/URLDrawable;", "e", "info", "f", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "TAG", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "J", "getFLAG_MASK_INTIMACY", "()J", "FLAG_MASK_INTIMACY", "", "I", "MARK_VERSION_NEW", "MARK_VERSION_OLD", "g", "()I", "limitHeight", h.F, "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "getDrawableListener", "()Lcom/tencent/image/URLDrawable$URLDrawableListener;", "drawableListener", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MutualMarkDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MutualMarkDownloader f360096a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineScope scope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final long FLAG_MASK_INTIMACY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int MARK_VERSION_NEW;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int MARK_VERSION_OLD = 0;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int limitHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final URLDrawable.URLDrawableListener drawableListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/ntrelation/intimateinfo/manager/cache/MutualMarkDownloader$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "drawable", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) cause);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, progress);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlDrawable);
                return;
            }
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            int intrinsicWidth = urlDrawable.getIntrinsicWidth();
            int intrinsicHeight = urlDrawable.getIntrinsicHeight();
            if (intrinsicHeight > 0 && intrinsicWidth > 0) {
                MutualMarkDownloader mutualMarkDownloader = MutualMarkDownloader.f360096a;
                intrinsicWidth = (intrinsicWidth * mutualMarkDownloader.c()) / intrinsicHeight;
                intrinsicHeight = mutualMarkDownloader.c();
            }
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                urlDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                urlDrawable.invalidateSelf();
                if (urlDrawable.getCallback() != null && (urlDrawable.getCallback() instanceof View)) {
                    Drawable.Callback callback = urlDrawable.getCallback();
                    Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type android.view.View");
                    ((View) callback).invalidate();
                    Drawable.Callback callback2 = urlDrawable.getCallback();
                    Intrinsics.checkNotNull(callback2, "null cannot be cast to non-null type android.view.View");
                    ((View) callback2).requestLayout();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f360096a = new MutualMarkDownloader();
        TAG = "MutualMarkDownloader";
        scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        FLAG_MASK_INTIMACY = 8L;
        MARK_VERSION_NEW = 1;
        limitHeight = ViewUtils.dip2px(21.0f);
        drawableListener = new a();
    }

    MutualMarkDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Context context, @NotNull ArrayList<NTMutualMarkEntity> mutualMarkInfos, @NotNull Function1<? super ArrayList<Drawable>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, mutualMarkInfos, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mutualMarkInfos, "mutualMarkInfos");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new MutualMarkDownloader$downloadImages$1(mutualMarkInfos, context, callback, null), 3, null);
    }

    public final void b(@NotNull Context context, @NotNull HashMap<String, ArrayList<NTMutualMarkEntity>> mutualMarkInfos, @NotNull Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, mutualMarkInfos, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mutualMarkInfos, "mutualMarkInfos");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new MutualMarkDownloader$downloadImagesBatch$1(mutualMarkInfos, context, callback, null), 3, null);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return limitHeight;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TAG;
    }

    @NotNull
    public final URLDrawable e(@NotNull Context context, @NotNull String iconUrl, @Nullable URLDrawable.URLDrawableListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 9, this, context, iconUrl, listener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        int dip2px = ViewUtils.dip2px(21.0f);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, 0, dip2px);
        obtain.mUseApngImage = true;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        URLDrawable urlDrawable = URLDrawable.getDrawable(iconUrl, obtain);
        urlDrawable.setTargetDensity(context.getResources().getDisplayMetrics().densityDpi / 2);
        urlDrawable.setURLDrawableListener(drawableListener);
        if (1 != urlDrawable.getStatus()) {
            urlDrawable.setURLDrawableListener(listener);
            urlDrawable.setAutoDownload(true);
            urlDrawable.startDownload(true);
        } else if (listener != null) {
            listener.onLoadSuccessed(urlDrawable);
        }
        Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
        return urlDrawable;
    }

    @NotNull
    public final String f(@Nullable NTMutualMarkEntity info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) info);
        }
        if (info == null) {
            return "";
        }
        if (!TextUtils.isEmpty(info.iconUrl) && info.markVersion == MARK_VERSION_NEW) {
            return info.iconUrl;
        }
        if (!TextUtils.isEmpty(info.icon_dynamic_url) && info.markVersion == MARK_VERSION_OLD) {
            return info.icon_dynamic_url;
        }
        if (TextUtils.isEmpty(info.icon_static_url) || info.markVersion != MARK_VERSION_OLD) {
            return "";
        }
        return info.icon_static_url;
    }
}
