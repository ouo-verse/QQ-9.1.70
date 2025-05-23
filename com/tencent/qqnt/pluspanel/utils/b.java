package com.tencent.qqnt.pluspanel.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import com.tencent.qqnt.pluspanel.utils.a;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/utils/b;", "", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static final Resources f360675b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J@\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J4\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J$\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0002J<\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010(j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`)2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0004H\u0002J8\u0010-\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002R\u0014\u0010/\u001a\u00020.8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00106\u001a\n 5*\u0004\u0018\u000104048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/pluspanel/utils/b$a;", "", "", "isRobotAIO", "", "iconUrl", "simpleDayUrl", "vipUrl", "", "defaultDrawableID", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "c", "e", "url", "drawableId", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "option", h.F, "d", "drawable", "f", "dayUrl", "options", "i", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "appInfo", "Lcom/tencent/qqnt/pluspanel/data/a;", "appData", "", "l", "Lcom/tencent/qqnt/pluspanel/config/b;", "cacheInfo", "j", "k", "g", "parentAppInfo", "uinType", "chatId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "index", "needChild", "a", "", "DAY_FILTER", "J", "NIGHT_FILTER", "TAG", "Ljava/lang/String;", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "res", "Landroid/content/res/Resources;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.utils.b$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final ArrayList<com.tencent.qqnt.pluspanel.data.a> b(PlusPanelAppInfo parentAppInfo, Context context, int uinType, String chatId) {
            boolean z16;
            ArrayList<PlusPanelAppInfo> childList = parentAppInfo.getChildList();
            if (childList != null && !childList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            ArrayList<com.tencent.qqnt.pluspanel.data.a> arrayList = new ArrayList<>();
            int i3 = 0;
            for (Object obj : childList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.qqnt.pluspanel.data.a a16 = b.INSTANCE.a((PlusPanelAppInfo) obj, i3, context, uinType, chatId, false);
                if (a16 != null) {
                    arrayList.add(a16);
                }
                i3 = i16;
            }
            return arrayList;
        }

        private final Drawable c(boolean isRobotAIO, String iconUrl, String simpleDayUrl, String vipUrl, int defaultDrawableID, Context context) {
            Resources resources;
            if (!isRobotAIO) {
                resources = b.f360675b;
            } else {
                resources = context.getResources();
            }
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                int e16 = e(defaultDrawableID);
                if (e16 > 0) {
                    obtain.mFailedDrawable = resources.getDrawable(e16);
                    obtain.mLoadingDrawable = resources.getDrawable(e16);
                }
                if (!QQTheme.isNowSimpleUI() && !isRobotAIO) {
                    if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
                        return h(vipUrl, defaultDrawableID, obtain);
                    }
                    return h(iconUrl, defaultDrawableID, obtain);
                }
                return i(isRobotAIO, simpleDayUrl, defaultDrawableID, obtain, context);
            } catch (Exception e17) {
                QLog.e("AppLoaderUtil", 1, "[getAppDrawable] exception: " + e17, e17);
                return null;
            }
        }

        private final Drawable d() {
            if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(b.f360675b.getColorStateList(R.color.qui_common_bg_top_light));
                gradientDrawable.setCornerRadius(ViewUtils.dpToPx(8.0f));
                return gradientDrawable;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(b.f360675b.getColorStateList(R.color.qui_common_fill_light_secondary));
            gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(12.0f));
            return gradientDrawable2;
        }

        private final int e(int defaultDrawableID) {
            if (defaultDrawableID <= 0) {
                return 0;
            }
            return defaultDrawableID;
        }

        private final Drawable f(Drawable drawable) {
            if (QQTheme.isNowThemeDefaultNight()) {
                drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor("#a6ffffff"), PorterDuff.Mode.SRC_IN));
            } else {
                drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor("#a6ffffff"), PorterDuff.Mode.SRC_IN));
                drawable.setColorFilter(null);
            }
            return drawable;
        }

        private final com.tencent.qqnt.pluspanel.data.a g(PlusPanelAppInfo appInfo, Context context) {
            com.tencent.qqnt.pluspanel.data.a aVar = new com.tencent.qqnt.pluspanel.data.a(0, 1, null);
            aVar.p(appInfo.getAppID());
            aVar.s(c(appInfo.isRobotAIO(), appInfo.getIconUrl(), appInfo.getSimpleDayUrl(), appInfo.getIconVip(), appInfo.defaultDrawableID(), context));
            aVar.n(appInfo.getAppID());
            aVar.w(appInfo.getAppName());
            aVar.o(appInfo.getActionType());
            aVar.m(appInfo.getAction());
            aVar.z(appInfo.getUrl());
            aVar.r(appInfo.getAppName() + "\u6309\u94ae");
            return aVar;
        }

        private final Drawable h(String url, int drawableId, URLDrawable.URLDrawableOptions option) {
            boolean z16;
            LayerDrawable layerDrawable;
            ArrayList arrayList = new ArrayList();
            if (url != null && url.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (drawableId > 0) {
                    Drawable drawable = b.f360675b.getDrawable(drawableId);
                    arrayList.add(d());
                    arrayList.add(f(drawable));
                    Object[] array = arrayList.toArray(new Drawable[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    layerDrawable = new LayerDrawable((Drawable[]) array);
                } else {
                    layerDrawable = null;
                }
            } else {
                URLDrawable drawable2 = URLDrawable.getDrawable(url, option);
                arrayList.add(d());
                arrayList.add(f(drawable2));
                Object[] array2 = arrayList.toArray(new Drawable[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                layerDrawable = new LayerDrawable((Drawable[]) array2);
            }
            if ((QQTheme.isDefaultTheme() || QQTheme.isNowThemeDefaultNight()) && layerDrawable != null) {
                layerDrawable.setLayerInset(1, ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(10.0f));
            }
            return layerDrawable;
        }

        private final Drawable i(boolean isRobotAIO, String dayUrl, int defaultDrawableID, URLDrawable.URLDrawableOptions options, Context context) {
            Drawable drawable;
            if (isRobotAIO) {
                Drawable drawable2 = context.getResources().getDrawable(defaultDrawableID);
                Intrinsics.checkNotNullExpressionValue(drawable2, "context.resources.getDrawable(defaultDrawableID)");
                return drawable2;
            }
            if (QQTheme.isNowThemeSimpleNight()) {
                if (!TextUtils.isEmpty(dayUrl)) {
                    drawable = URLDrawable.getDrawable(dayUrl, options);
                    Intrinsics.checkNotNullExpressionValue(drawable, "{\n                    UR\u2026ptions)\n                }");
                } else {
                    drawable = b.f360675b.getDrawable(defaultDrawableID);
                    Intrinsics.checkNotNullExpressionValue(drawable, "{\n                    re\u2026ableID)\n                }");
                }
                drawable.setColorFilter(DownloadCardView.COLOR_APP_VERSION, PorterDuff.Mode.SRC_ATOP);
            } else {
                if (!TextUtils.isEmpty(dayUrl)) {
                    drawable = URLDrawable.getDrawable(dayUrl, options);
                    Intrinsics.checkNotNullExpressionValue(drawable, "{\n                    UR\u2026ptions)\n                }");
                } else {
                    drawable = b.f360675b.getDrawable(defaultDrawableID);
                    Intrinsics.checkNotNullExpressionValue(drawable, "{\n                    re\u2026ableID)\n                }");
                }
                if (QQTheme.isNowSimpleUI()) {
                    drawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
                } else {
                    drawable.setColorFilter(b.f360675b.getColor(R.color.qui_common_icon_aio_toolbar_normal), PorterDuff.Mode.SRC_ATOP);
                }
            }
            return drawable;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Drawable j(PlusPanelAppInfo appInfo, com.tencent.qqnt.pluspanel.config.b cacheInfo, Context context) {
            boolean z16;
            String str;
            String str2;
            String o16;
            boolean z17;
            int i3 = 0;
            if (cacheInfo != null && (o16 = cacheInfo.o()) != null) {
                if (o16.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16) {
                        QLog.i("AppLoaderUtil", 1, "[getTroopAppDrawable]: appid=" + appInfo.getAppID() + ", appinfo=" + appInfo);
                    }
                    String str3 = null;
                    if (cacheInfo == null) {
                        str = cacheInfo.o();
                    } else {
                        str = null;
                    }
                    int defaultDrawableID = appInfo.defaultDrawableID();
                    if (cacheInfo != null) {
                        i3 = cacheInfo.s();
                    }
                    if (i3 < 1 && defaultDrawableID > 0) {
                        str = "";
                    }
                    String str4 = str;
                    boolean isRobotAIO = appInfo.isRobotAIO();
                    if (cacheInfo == null) {
                        str2 = cacheInfo.n();
                    } else {
                        str2 = null;
                    }
                    if (cacheInfo != null) {
                        str3 = cacheInfo.p();
                    }
                    return c(isRobotAIO, str4, str2, str3, defaultDrawableID, context);
                }
            }
            z16 = false;
            if (z16) {
            }
            String str32 = null;
            if (cacheInfo == null) {
            }
            int defaultDrawableID2 = appInfo.defaultDrawableID();
            if (cacheInfo != null) {
            }
            if (i3 < 1) {
                str = "";
            }
            String str42 = str;
            boolean isRobotAIO2 = appInfo.isRobotAIO();
            if (cacheInfo == null) {
            }
            if (cacheInfo != null) {
            }
            return c(isRobotAIO2, str42, str2, str32, defaultDrawableID2, context);
        }

        private final com.tencent.qqnt.pluspanel.data.a k(PlusPanelAppInfo appInfo, Context context) {
            boolean z16;
            String title;
            String str;
            String str2;
            String str3;
            Map<String, com.tencent.qqnt.pluspanel.config.b> appConfigDatas = ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getAppConfigDatas();
            com.tencent.qqnt.pluspanel.config.b appConfigDataById = ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getAppConfigDataById(String.valueOf(appInfo.getAppID()));
            if (appConfigDatas != null && !appConfigDatas.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            String str4 = null;
            if (!z16 && (appConfigDataById == null || appConfigDataById.m() != 1)) {
                QLog.d("AppLoaderUtil", 2, "getTroopAppInfo return, cacheInfo is null or disable");
                return null;
            }
            com.tencent.qqnt.pluspanel.data.a aVar = new com.tencent.qqnt.pluspanel.data.a(0, 1, null);
            aVar.p(appInfo.getAppID());
            aVar.s(j(appInfo, appConfigDataById, context));
            aVar.n(appInfo.getAppID());
            if (appConfigDataById == null || (title = appConfigDataById.r()) == null) {
                title = appInfo.getTitle();
            }
            aVar.w(title);
            if (appConfigDataById != null) {
                str = appConfigDataById.i();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str2 = appInfo.getActionType();
            } else if (appConfigDataById != null) {
                str2 = appConfigDataById.i();
            } else {
                str2 = null;
            }
            aVar.o(str2);
            if (appConfigDataById != null) {
                str3 = appConfigDataById.h();
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                str4 = appInfo.getAction();
            } else if (appConfigDataById != null) {
                str4 = appConfigDataById.h();
            }
            aVar.z(str4);
            aVar.m(appInfo.getAction());
            aVar.r(aVar.h() + "\u6309\u94ae");
            return aVar;
        }

        private final void l(PlusPanelAppInfo appInfo, com.tencent.qqnt.pluspanel.data.a appData) {
            if (appData == null) {
                return;
            }
            int appid = appInfo.getAppid();
            boolean isC2C = appInfo.isC2C();
            if (isC2C) {
                if (appid == a.INSTANCE.C()) {
                    appData.v(appInfo.getRedPoint());
                }
            } else if (!isC2C) {
                a.Companion companion = a.INSTANCE;
                if (appid == companion.V() || appid == companion.X() || appid == companion.w0() || appid == companion.l0()) {
                    appData.v(appInfo.getRedPoint());
                }
            }
        }

        @Nullable
        public final com.tencent.qqnt.pluspanel.data.a a(@NotNull PlusPanelAppInfo appInfo, int index, @NotNull Context context, int uinType, @NotNull String chatId, boolean needChild) {
            com.tencent.qqnt.pluspanel.data.a g16;
            Drawable drawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.pluspanel.data.a) iPatchRedirector.redirect((short) 2, this, appInfo, Integer.valueOf(index), context, Integer.valueOf(uinType), chatId, Boolean.valueOf(needChild));
            }
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(chatId, "chatId");
            if (uinType == 2) {
                g16 = k(appInfo, context);
                if (g16 != null) {
                    g16.u(String.valueOf(Integer.valueOf(g16.c())));
                }
            } else {
                g16 = g(appInfo, context);
                if (uinType == 1 && g16 != null) {
                    g16.u(String.valueOf(appInfo.getRedDotID()));
                }
            }
            if (g16 != null) {
                drawable = g16.e();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                return null;
            }
            if (g16 != null) {
                g16.x(chatId);
            }
            if (g16 != null) {
                g16.y(uinType);
            }
            if (g16 != null) {
                g16.t(index);
            }
            if (needChild) {
                g16.q(b(appInfo, context, uinType, chatId));
            }
            l(appInfo, g16);
            return g16;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
            f360675b = MobileQQ.sMobileQQ.getResources();
        }
    }
}
