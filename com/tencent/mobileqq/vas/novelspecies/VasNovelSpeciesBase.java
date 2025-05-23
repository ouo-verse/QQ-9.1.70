package com.tencent.mobileqq.vas.novelspecies;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.novelspecies.data.a;
import com.tencent.mobileqq.vas.novelspecies.impl.NovelSpaciesWidgetApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u0000 \r2\u00020\u0001:\u0002\u0013\u0005B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0010H&J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001e\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/novelspecies/VasNovelSpeciesBase;", "Landroid/appwidget/AppWidgetProvider;", "Landroid/content/Context;", "context", "Landroid/app/PendingIntent;", "b", "Landroid/widget/RemoteViews;", "views", "Lcom/tencent/mobileqq/vas/novelspecies/data/a$b;", "cacheData", "", "isBig", "", "d", "Lcom/tencent/mobileqq/vas/novelspecies/VasNovelSpeciesBase$b;", "currentImage", "", "imgPath", "Landroid/graphics/Bitmap;", "a", "c", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "onUpdate", "from", "e", "Landroid/content/Intent;", "intent", "onReceive", "f", "Lcom/tencent/mobileqq/vas/novelspecies/VasNovelSpeciesBase$b;", "currentBgImg", "currentElementImg", "", "J", "lastPullConfigTimeOnUpdate", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class VasNovelSpeciesBase extends AppWidgetProvider {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b currentBgImg = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b currentElementImg = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastPullConfigTimeOnUpdate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R*\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/novelspecies/VasNovelSpeciesBase$b;", "", "Lmqq/util/WeakReference;", "Landroid/graphics/Bitmap;", "a", "Lmqq/util/WeakReference;", "()Lmqq/util/WeakReference;", "c", "(Lmqq/util/WeakReference;)V", "bitMapRef", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "imgPath", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<Bitmap> bitMapRef = new WeakReference<>(null);

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String imgPath;

        @NotNull
        public final WeakReference<Bitmap> a() {
            return this.bitMapRef;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getImgPath() {
            return this.imgPath;
        }

        public final void c(@NotNull WeakReference<Bitmap> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.bitMapRef = weakReference;
        }

        public final void d(@Nullable String str) {
            this.imgPath = str;
        }
    }

    private final Bitmap a(b currentImage, String imgPath) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(imgPath)) {
            return null;
        }
        if (Intrinsics.areEqual(imgPath, currentImage.getImgPath()) && (bitmap = currentImage.a().get()) != null) {
            return bitmap;
        }
        try {
            if (new File(imgPath).exists()) {
                Bitmap decodeFile = BitmapFactory.decodeFile(imgPath);
                if (decodeFile != null) {
                    currentImage.c(new WeakReference<>(decodeFile));
                    currentImage.d(imgPath);
                }
                return decodeFile;
            }
        } catch (OutOfMemoryError unused) {
            QLog.i("VasNovelSpeciesBase", 2, "createWidgetBitmap oom");
        }
        return null;
    }

    private final PendingIntent b(Context context) {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse("mqqapi://kuikly/open?version=1&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_new_el_homeland&bundle_name=vas_new_el_homeland&enteranceId=widget&single=1"));
        intent.addFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(context, 0, \u2026ingIntent.FLAG_IMMUTABLE)");
        return activity;
    }

    private final void c(RemoteViews views, boolean isBig) {
        if (isBig) {
            views.setImageViewResource(R.id.zv6, R.drawable.f162000np0);
        } else {
            views.setImageViewResource(R.id.zv6, R.drawable.noz);
        }
        views.setImageViewBitmap(R.id.f643235x, null);
        views.setViewVisibility(R.id.f643035v, 4);
    }

    private final void d(RemoteViews views, a.b cacheData, boolean isBig) {
        views.setImageViewBitmap(R.id.zv6, a(this.currentBgImg, cacheData.a(isBig)));
        views.setImageViewBitmap(R.id.f643235x, a(this.currentElementImg, cacheData.getElementPath()));
        views.setViewVisibility(R.id.f643035v, 0);
        if (TextUtils.isEmpty(cacheData.getMsg())) {
            views.setViewVisibility(R.id.f643035v, 4);
        } else {
            views.setViewVisibility(R.id.f643035v, 0);
            views.setTextViewText(R.id.f643135w, cacheData.getMsg());
        }
    }

    public abstract void e(@NotNull Context context, @NotNull String from);

    public final void f(@NotNull RemoteViews views, @NotNull Context context, boolean isBig) {
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(context, "context");
        a widgetCachedData = ((INovelSpaciesWidgetApi) QRoute.api(INovelSpaciesWidgetApi.class)).getWidgetCachedData();
        if (widgetCachedData != null) {
            views.setTextViewText(R.id.f642935u, String.valueOf(widgetCachedData.getCom.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo.SCORE java.lang.String()));
            views.setTextViewText(R.id.f642835t, String.valueOf(widgetCachedData.getCoin()));
            if (!TextUtils.isEmpty(widgetCachedData.getLastWidgetData().b(isBig)) && widgetCachedData.getLastWidgetData().getExpiredTimestamp() > System.currentTimeMillis()) {
                if (!TextUtils.isEmpty(widgetCachedData.getLastWidgetData().a(isBig)) && !TextUtils.isEmpty(widgetCachedData.getLastWidgetData().getElementPath())) {
                    d(views, widgetCachedData.getLastWidgetData(), isBig);
                }
            } else if (!TextUtils.isEmpty(widgetCachedData.getDefaultWidgetData().a(isBig)) && !TextUtils.isEmpty(widgetCachedData.getDefaultWidgetData().getElementPath())) {
                d(views, widgetCachedData.getDefaultWidgetData(), isBig);
            } else {
                c(views, isBig);
            }
        } else {
            c(views, isBig);
        }
        views.setOnClickPendingIntent(R.id.zv6, b(context));
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        String str = intent.getPackage();
        if (str != null && !Intrinsics.areEqual(str, context.getPackageName())) {
            return;
        }
        if (Intrinsics.areEqual(NovelSpaciesWidgetApiImpl.ACTION_UPDATE_VAS_NOVEL_SPECIES, action)) {
            QLog.d("VasNovelSpeciesBase", 1, "[onReceive] action action:" + action + ",intentPkg:" + str + ",contextPkg:" + context.getPackageName());
            e(context, "brocast");
            return;
        }
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        e(context, "onUpdate");
        if (Math.abs(System.currentTimeMillis() - this.lastPullConfigTimeOnUpdate) < 600000) {
            QLog.i("VasNovelSpeciesBase", 1, "[onUpdate] has not reach pull time or in fast pull\uff0clastPullConfigTime:" + this.lastPullConfigTimeOnUpdate);
            return;
        }
        this.lastPullConfigTimeOnUpdate = System.currentTimeMillis();
        ((INovelSpaciesWidgetApi) QRoute.api(INovelSpaciesWidgetApi.class)).fetchAndCacheWidgetData();
    }
}
