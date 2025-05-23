package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import android.graphics.drawable.ColorDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.model.ShareBackground;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/a;", "", "", "a", "b", "", "url", "Lcom/tencent/image/URLDrawable;", "f", "", "g", "Lcom/tencent/sqshow/utils/featureswitch/model/ai;", DownloadInfo.spKey_Config, tl.h.F, "c", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/o;", "callback", "d", "Lcom/tencent/sqshow/utils/featureswitch/model/ai;", "zPlanShareConfig", "", "I", "bkgIndex", "portraitIndex", "e", "currentPortraitId", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f371751a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ZPlanShareConfig zPlanShareConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int bkgIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int portraitIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int currentPortraitId;

    a() {
    }

    private final void a() {
        List<Integer> d16;
        List<ShareBackground> c16;
        ShareBackground activityBackground;
        if (g()) {
            ArrayList arrayList = new ArrayList();
            ZPlanShareConfig zPlanShareConfig2 = zPlanShareConfig;
            if (zPlanShareConfig2 != null && (activityBackground = zPlanShareConfig2.getActivityBackground()) != null) {
                arrayList.add(activityBackground);
            }
            ZPlanShareConfig zPlanShareConfig3 = zPlanShareConfig;
            if (zPlanShareConfig3 != null && (c16 = zPlanShareConfig3.c()) != null) {
                arrayList.addAll(c16);
            }
            ZPlanShareConfig zPlanShareConfig4 = zPlanShareConfig;
            if (zPlanShareConfig4 != null) {
                zPlanShareConfig4.f(arrayList);
            }
            ZPlanShareConfig zPlanShareConfig5 = zPlanShareConfig;
            Integer valueOf = zPlanShareConfig5 != null ? Integer.valueOf(zPlanShareConfig5.getActivityPortraitId()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            if (valueOf != null) {
                arrayList2.add(Integer.valueOf(valueOf.intValue()));
            }
            ZPlanShareConfig zPlanShareConfig6 = zPlanShareConfig;
            if (zPlanShareConfig6 != null && (d16 = zPlanShareConfig6.d()) != null) {
                arrayList2.addAll(d16);
            }
            ZPlanShareConfig zPlanShareConfig7 = zPlanShareConfig;
            if (zPlanShareConfig7 == null) {
                return;
            }
            zPlanShareConfig7.g(arrayList2);
        }
    }

    private final void b() {
        ZPlanShareConfig zPlanShareConfig2 = zPlanShareConfig;
        if (zPlanShareConfig2 != null) {
            Iterator<ShareBackground> it = zPlanShareConfig2.c().iterator();
            while (it.hasNext()) {
                e(f371751a, it.next().getUrl(), null, 2, null);
            }
            e(f371751a, zPlanShareConfig2.getShareBaseMapUrl(), null, 2, null);
        }
    }

    private final URLDrawable f(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, option)");
        return drawable;
    }

    private final boolean g() {
        ShareBackground activityBackground;
        ZPlanShareConfig zPlanShareConfig2 = zPlanShareConfig;
        if (zPlanShareConfig2 == null || (activityBackground = zPlanShareConfig2.getActivityBackground()) == null) {
            return false;
        }
        if (activityBackground.getUrl().length() == 0) {
            return false;
        }
        if (activityBackground.getThemeColor().length() == 0) {
            return false;
        }
        return !(activityBackground.getTextColor().length() == 0);
    }

    public final void c() {
        ZPlanShareConfig zPlanShareConfig2 = zPlanShareConfig;
        if (zPlanShareConfig2 != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Iterator<ShareBackground> it = zPlanShareConfig2.c().iterator();
            while (it.hasNext()) {
                URLDrawable.removeMemoryCacheByUrl(it.next().getUrl(), obtain);
            }
            URLDrawable.removeMemoryCacheByUrl(zPlanShareConfig2.getShareBaseMapUrl(), obtain);
        }
    }

    public final void d(String url, o callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            QLog.e("AvatarShareConfig", 1, "downloadImage url is empty");
            if (callback != null) {
                callback.a();
                return;
            }
            return;
        }
        URLDrawable f16 = f(url);
        if (f16.getStatus() == 1) {
            QLog.i("AvatarShareConfig", 1, "get url cache by " + url);
            if (callback != null) {
                callback.onLoadSuccessed(f16);
                return;
            }
            return;
        }
        f16.setURLDrawableListener(new C9819a(url, callback));
        f16.startDownload();
    }

    public final void h(ZPlanShareConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        bkgIndex = 0;
        portraitIndex = 0;
        currentPortraitId = 0;
        zPlanShareConfig = config;
        a();
        b();
    }

    public static /* synthetic */ void e(a aVar, String str, o oVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            oVar = null;
        }
        aVar.d(str, oVar);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/a$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9819a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f371756d;

        C9819a(String str, o oVar) {
            this.f371756d = str;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
            QLog.i("AvatarShareConfig", 1, "download image cancel by " + this.f371756d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            QLog.i("AvatarShareConfig", 1, "download image failed by " + this.f371756d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            QLog.i("AvatarShareConfig", 1, "download image success by " + this.f371756d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }
}
