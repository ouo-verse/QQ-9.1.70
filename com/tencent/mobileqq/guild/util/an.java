package com.tencent.mobileqq.guild.util;

import android.util.Log;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.util.an;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/util/an;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class an {

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b */
    private static final int f235436b = QQGuildUIUtil.f(16.0f);

    /* renamed from: c */
    private static final int f235437c = QQGuildUIUtil.f(16.0f);

    /* renamed from: d */
    private static final int f235438d = QQGuildUIUtil.f(4.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002JX\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000426\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00072\b\b\u0002\u0010\u0010\u001a\u00020\fR\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/util/an$a;", "", "", "d", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "Lkotlin/Function2;", "Lcom/tencent/image/URLDrawable;", "Lkotlin/ParameterName;", "name", "urlDrawable", "", "iconWidth", "", "onLoadFinish", "iconHeight", "e", "OFFICIAL_MEDAL_WIDTH", "I", "c", "()I", "OFFICIAL_MEDAL_HEIGHT", "a", "OFFICIAL_MEDAL_PADDING", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.util.an$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/util/an$a$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.util.an$a$a */
        /* loaded from: classes14.dex */
        public static final class C7910a implements URLDrawable.URLDrawableListener {

            /* renamed from: d */
            final /* synthetic */ WeakReference<? extends View> f235439d;

            /* renamed from: e */
            final /* synthetic */ int f235440e;

            /* renamed from: f */
            final /* synthetic */ Function2<URLDrawable, Integer, Unit> f235441f;

            /* JADX WARN: Multi-variable type inference failed */
            C7910a(WeakReference<? extends View> weakReference, int i3, Function2<? super URLDrawable, ? super Integer, Unit> function2) {
                this.f235439d = weakReference;
                this.f235440e = i3;
                this.f235441f = function2;
            }

            public static final void b(URLDrawable urlDrawable, int i3, Function2 onLoadFinish) {
                Intrinsics.checkNotNullParameter(urlDrawable, "$urlDrawable");
                Intrinsics.checkNotNullParameter(onLoadFinish, "$onLoadFinish");
                int intrinsicWidth = (int) ((urlDrawable.getIntrinsicWidth() / urlDrawable.getIntrinsicHeight()) * i3);
                if (QLog.isColorLevel()) {
                    QLog.i("GuildOfficialIconUtils", 1, "onLoadSuccess, iconWidth: " + intrinsicWidth + ", iconHeight: " + i3);
                }
                urlDrawable.setBounds(0, 0, intrinsicWidth, i3);
                onLoadFinish.invoke(urlDrawable, Integer.valueOf(intrinsicWidth));
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                QLog.d("GuildOfficialIconUtils", 1, "onLoadCanceled...");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                QLog.d("GuildOfficialIconUtils", 1, "onLoadFailed...");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(@NotNull final URLDrawable urlDrawable) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                View view = this.f235439d.get();
                if (view != null) {
                    final int i3 = this.f235440e;
                    final Function2<URLDrawable, Integer, Unit> function2 = this.f235441f;
                    view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.am
                        @Override // java.lang.Runnable
                        public final void run() {
                            an.Companion.C7910a.b(URLDrawable.this, i3, function2);
                        }
                    });
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void f(Companion companion, WeakReference weakReference, Function2 function2, int i3, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                i3 = companion.a();
            }
            companion.e(weakReference, function2, i3);
        }

        public final int a() {
            return an.f235437c;
        }

        public final int b() {
            return an.f235438d;
        }

        public final int c() {
            return an.f235436b;
        }

        @NotNull
        public final String d() {
            String str;
            Unit unit;
            com.tencent.mobileqq.guild.config.n nVar = (com.tencent.mobileqq.guild.config.n) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105844");
            if (nVar != null) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildOfficialIconUtils", "[getOfficialIconUrl] get config success: " + nVar.getIconUrl());
                }
                str = nVar.getIconUrl();
                unit = Unit.INSTANCE;
            } else {
                str = "https://downv6.qq.com/innovate/guild/common/guild_official_medal_v2.png";
                unit = null;
            }
            if (unit == null) {
                Logger logger2 = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildOfficialIconUtils", "[getOfficialIconUrl] confBean is null");
                }
            }
            Logger logger3 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildOfficialIconUtils", "[getOfficialIconUrl] result is: " + ((Object) str));
            }
            return str;
        }

        public final void e(@NotNull WeakReference<? extends View> viewRef, @NotNull Function2<? super URLDrawable, ? super Integer, Unit> onLoadFinish, int iconHeight) {
            Intrinsics.checkNotNullParameter(viewRef, "viewRef");
            Intrinsics.checkNotNullParameter(onLoadFinish, "onLoadFinish");
            String d16 = d();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = iconHeight;
            obtain.mRequestWidth = an.INSTANCE.c();
            URLDrawable urlDrawable = URLDrawable.getDrawable(d16, obtain);
            urlDrawable.setBounds(0, 0, c(), iconHeight);
            if (urlDrawable.getStatus() == 1) {
                int intrinsicWidth = (int) ((urlDrawable.getIntrinsicWidth() / urlDrawable.getIntrinsicHeight()) * iconHeight);
                urlDrawable.setBounds(0, 0, intrinsicWidth, iconHeight);
                Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
                onLoadFinish.invoke(urlDrawable, Integer.valueOf(intrinsicWidth));
                return;
            }
            urlDrawable.setURLDrawableListener(new C7910a(viewRef, iconHeight, onLoadFinish));
            urlDrawable.startDownload();
        }

        Companion() {
        }
    }
}
