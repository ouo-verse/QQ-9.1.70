package com.tencent.mobileqq.qqecommerce.biz.res;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.LruCache;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.ttpic.openapi.filter.LightConstants;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import ie0.a;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b0\u00101J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J#\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016JK\u0010#\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2'\u0010\"\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u001ej\u0002`!H\u0016Ju\u0010#\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2Q\u0010\"\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\f0$j\u0002`'H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R&\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/res/ECResourceApi;", "Lcom/tencent/ecommerce/biz/res/api/IECResourceApi;", "", "tokenStr", "", "c", "(Ljava/lang/String;)Ljava/lang/Integer;", h.F, "tokenRes", "skinMode", "i", "message", "", "b", "path", "Landroid/graphics/drawable/Drawable;", "d", "drawable", "j", "resourceType", "f", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "e", "getColor", "", "isVasTheme", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "fetchDrawable", "Lkotlin/Function3;", "errorCode", "errorMsg", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "handler", "Landroidx/collection/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroidx/collection/LruCache;", "imageCache", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECResourceApi implements IECResourceApi {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f263407d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, Integer> f263408e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Integer> f263409f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LruCache<String, WeakReference<Drawable>> imageCache = new LruCache<>(20);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000eR \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/res/ECResourceApi$a;", "", "", "token", "", "resId", "", "a", "b", "", "COLOR_TOKEN_MAP", "Ljava/util/Map;", "IMAGE_TOKEN_MAP", "PARAM_COLOR", "Ljava/lang/String;", "QUI_COLOR_BASE_SCHAMA", "QUI_COLOR_PARAM_UNIQUE_ID", "QUI_TOKEN_COMMON_PREFIX", "QUI_TOKEN_PREFIX", "RESOURCE_TYPE_COLOR", "RESOURCE_TYPE_DRAWABLE", "TAG", "TINT_COLOR_PREFIX", "TOKEN_DEFAULT_THEME", "TOKEN_NIGHT_THEME", "", "resIdCache", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.res.ECResourceApi$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String token, int resId) {
            Intrinsics.checkNotNullParameter(token, "token");
            ECResourceApi.f263407d.put(token, Integer.valueOf(resId));
        }

        public final int b(String token) {
            Intrinsics.checkNotNullParameter(token, "token");
            Integer num = (Integer) ECResourceApi.f263407d.get(token);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        Companion() {
        }
    }

    static {
        Map<String, Integer> mapOf;
        Map<String, Integer> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("text_primary", Integer.valueOf(R.color.qui_common_text_primary)), TuplesKt.to("text_secondary", Integer.valueOf(R.color.qui_common_text_secondary)), TuplesKt.to("text_secondary_light", Integer.valueOf(R.color.qui_common_text_secondary_light)), TuplesKt.to("text_link", Integer.valueOf(R.color.qui_common_text_link)), TuplesKt.to("brand_standard", Integer.valueOf(R.color.qui_common_brand_standard)), TuplesKt.to("text_nav_primary", Integer.valueOf(R.color.qui_common_text_nav_primary)), TuplesKt.to("text_nav_secondary", Integer.valueOf(R.color.qui_common_text_nav_secondary)), TuplesKt.to("text_white", Integer.valueOf(R.color.qui_common_text_allwhite_primary)), TuplesKt.to("button_bg_primary_default", Integer.valueOf(R.color.qui_button_bg_primary_default)), TuplesKt.to("button_text_primary_default", Integer.valueOf(R.color.qui_button_text_primary_default)), TuplesKt.to("button_text_secondary_default", Integer.valueOf(R.color.qui_button_text_secondary_default)), TuplesKt.to("button_text_secondary_disable", Integer.valueOf(R.color.qui_button_text_secondary_disable)), TuplesKt.to("button_border_secondary_default", Integer.valueOf(R.color.qui_button_border_secondary_default)), TuplesKt.to("button_border_secondary_disable", Integer.valueOf(R.color.qui_button_border_secondary_disable)), TuplesKt.to("button_bg_secondary_default", Integer.valueOf(R.color.qui_button_bg_secondary_default)), TuplesKt.to("button_bg_secondary_disable", Integer.valueOf(R.color.qui_button_bg_secondary_disable)), TuplesKt.to("fill_standard_primary", Integer.valueOf(R.color.qui_common_fill_standard_primary)), TuplesKt.to("fill_light_primary", Integer.valueOf(R.color.qui_common_fill_light_primary)), TuplesKt.to("fill_light_secondary", Integer.valueOf(R.color.qui_common_fill_light_secondary)), TuplesKt.to("bg_bottom_light", Integer.valueOf(R.color.qui_common_bg_bottom_light)), TuplesKt.to("bg_bottom_standard", Integer.valueOf(R.color.qui_common_bg_bottom_standard)), TuplesKt.to("overlay_dark", Integer.valueOf(R.color.qui_common_overlay_dark)), TuplesKt.to("icon_primary", Integer.valueOf(R.color.qui_common_icon_primary)), TuplesKt.to("icon_secondary", Integer.valueOf(R.color.qui_common_icon_secondary)), TuplesKt.to("icon_aio_toolbar_active", Integer.valueOf(R.color.qui_common_icon_aio_toolbar_active)), TuplesKt.to("border_light", Integer.valueOf(R.color.qui_common_border_light)), TuplesKt.to("border_standard", Integer.valueOf(R.color.qui_common_border_standard)), TuplesKt.to("bg_nav_primary", Integer.valueOf(R.color.qui_common_bg_nav_primary)), TuplesKt.to("bg_nav_secondary", Integer.valueOf(R.color.qui_common_bg_nav_secondary)), TuplesKt.to("bg_nav_aio", Integer.valueOf(R.color.qui_common_bg_nav_aio)));
        f263408e = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("voice_mute", Integer.valueOf(R.drawable.qui_voice_mute)), TuplesKt.to("voice_high", Integer.valueOf(R.drawable.qui_voice_high)), TuplesKt.to("play", Integer.valueOf(R.drawable.qui_play)), TuplesKt.to("chevron_left", Integer.valueOf(R.drawable.qui_chevron_left)), TuplesKt.to("chevron_down", Integer.valueOf(R.drawable.qui_chevron_down)), TuplesKt.to("chevron_right", Integer.valueOf(R.drawable.qui_chevron_right)), TuplesKt.to("chevron_up", Integer.valueOf(R.drawable.qui_chevron_up)), TuplesKt.to("like", Integer.valueOf(R.drawable.qui_like)), TuplesKt.to("like_filled", Integer.valueOf(R.drawable.qui_like_filled)), TuplesKt.to(QCircleAlphaUserReporter.KEY_USER, Integer.valueOf(R.drawable.qui_user)), TuplesKt.to(LightConstants.MALE, Integer.valueOf(R.drawable.qui_male)), TuplesKt.to(LightConstants.FEMALE, Integer.valueOf(R.drawable.qui_female)), TuplesKt.to("search", Integer.valueOf(R.drawable.qui_search)), TuplesKt.to("time", Integer.valueOf(R.drawable.qui_time)), TuplesKt.to("close", Integer.valueOf(R.drawable.qui_close)), TuplesKt.to("delete", Integer.valueOf(R.drawable.qui_delete)), TuplesKt.to("common_bg_bottom_standard_bg", Integer.valueOf(R.drawable.qui_common_bg_bottom_standard_bg)));
        f263409f = mapOf2;
    }

    private final void b(String message) {
        QLog.e("ECResourceApi", 1, "alertTokenNotFound message:" + message);
    }

    private final Integer c(String tokenStr) {
        String removePrefix;
        String substringBefore$default;
        removePrefix = StringsKt__StringsKt.removePrefix(tokenStr, (CharSequence) "qui_color://");
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(removePrefix, "?color_unique_id=", (String) null, 2, (Object) null);
        Integer num = f263408e.get(substringBefore$default);
        if (num == null) {
            num = g(this, substringBefore$default, null, 2, null);
        }
        if (num == null) {
            b("color token:" + substringBefore$default + " \u4e0d\u5b58\u5728\uff0c\u8bf7\u5347\u7ea7\u5f53\u524d\u7aefqui token\u7248\u672c\u6216\u8005\u68c0\u67e5token\u540d\u79f0\u662f\u5426\u6b63\u786e");
        }
        return num;
    }

    private final Drawable d(String path) {
        WeakReference<Drawable> weakReference = this.imageCache.get(path);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final int e(String tokenStr, String resourceType) {
        if (tokenStr.length() == 0) {
            return 0;
        }
        BaseApplication context = BaseApplication.getContext();
        String packageName = context.getPackageName();
        int identifier = context.getResources().getIdentifier("qui_" + tokenStr, resourceType, packageName);
        if (identifier == 0) {
            identifier = context.getResources().getIdentifier("qui_common_" + tokenStr, resourceType, packageName);
        }
        return identifier == 0 ? context.getResources().getIdentifier(tokenStr, resourceType, packageName) : identifier;
    }

    private final Integer f(String tokenStr, String resourceType) {
        String str = resourceType + "_" + tokenStr;
        Companion companion = INSTANCE;
        int b16 = companion.b(str);
        if (b16 != 0) {
            return Integer.valueOf(b16);
        }
        int e16 = e(tokenStr, resourceType);
        if (e16 != 0) {
            companion.a(str, e16);
        } else {
            QLog.e("ECResourceApi", 1, "getResId is null with token:" + tokenStr + " type:" + resourceType);
        }
        if (e16 != 0) {
            return Integer.valueOf(e16);
        }
        return null;
    }

    private final int h(String tokenStr) {
        boolean contains$default;
        boolean contains$default2;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) tokenStr, (CharSequence) "default_theme=1", false, 2, (Object) null);
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) tokenStr, (CharSequence) "night_theme=1", false, 2, (Object) null);
        int i3 = contains$default ? 1001 : 1000;
        if (contains$default2) {
            return 1002;
        }
        return i3;
    }

    private final int i(int tokenRes, int skinMode) {
        return a.f().g(BaseApplication.getContext(), tokenRes, skinMode);
    }

    private final void j(String path, Drawable drawable) {
        this.imageCache.put(path, new WeakReference<>(drawable));
    }

    @Override // com.tencent.ecommerce.biz.res.api.IECResourceApi
    public void fetchDrawable(Context context, String path, IECImageLoader.ImageLoaderOption option, Function1<? super Drawable, Unit> callback) {
        boolean contains$default;
        String str;
        Drawable drawable;
        Long longOrNull;
        boolean startsWith$default;
        List split$default;
        Object first;
        Object lastOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) path, (CharSequence) "c_prefix:", false, 2, (Object) null);
        if (contains$default) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) path, new String[]{"c_prefix:"}, false, 0, 6, (Object) null);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
            String str2 = (String) first;
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default);
            str = (String) lastOrNull;
            path = str2;
        } else {
            str = null;
        }
        Drawable d16 = d(path);
        if (d16 != null) {
            callback.invoke(d16);
            return;
        }
        Uri parse = Uri.parse(path);
        String authority = parse.getAuthority();
        Integer num = f263409f.get(authority);
        if (num == null) {
            num = f(authority == null ? "" : authority, "drawable");
            if (num == null) {
                callback.invoke(null);
                b("image token:" + authority + " \u4e0d\u5b58\u5728\uff0c\u8bf7\u5347\u7ea7\u5f53\u524d\u7aefqui token\u7248\u672c\u6216\u8005\u68c0\u67e5token\u540d\u79f0\u662f\u5426\u6b63\u786e");
                return;
            }
        }
        if (str == null) {
            str = parse.getQueryParameter("color");
        }
        if (!(str == null || str.length() == 0)) {
            drawable = context.getResources().getDrawable(num.intValue());
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            Integer valueOf = longOrNull != null ? Integer.valueOf((int) longOrNull.longValue()) : null;
            if (valueOf != null) {
                if (drawable instanceof SkinnableBitmapDrawable) {
                    drawable = ((SkinnableBitmapDrawable) drawable).mutate2();
                    drawable.setColorFilter(new PorterDuffColorFilter(valueOf.intValue(), PorterDuff.Mode.SRC_IN));
                } else {
                    drawable.mutate();
                    drawable.setTint(valueOf.intValue());
                }
            } else {
                int h16 = h(str);
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "qui_color://", false, 2, null);
                Integer c16 = startsWith$default ? c(str) : g(this, str, null, 2, null);
                if (c16 != null) {
                    drawable = a.f().o(context, num.intValue(), c16.intValue(), h16);
                } else {
                    b("color token:" + str + " \u4e0d\u5b58\u5728\uff0c\u8bf7\u5347\u7ea7\u5f53\u524d\u7aefqui token\u7248\u672c\u6216\u8005\u68c0\u67e5token\u540d\u79f0\u662f\u5426\u6b63\u786e");
                }
            }
        } else {
            drawable = context.getResources().getDrawable(num.intValue());
        }
        j(path, drawable);
        callback.invoke(drawable);
    }

    @Override // com.tencent.ecommerce.biz.res.api.IECResourceApi
    public int getColor(String tokenStr) {
        Intrinsics.checkNotNullParameter(tokenStr, "tokenStr");
        Integer c16 = c(tokenStr);
        int h16 = h(tokenStr);
        if (c16 != null) {
            return i(c16.intValue(), h16);
        }
        return 0;
    }

    @Override // com.tencent.ecommerce.biz.res.api.IECResourceApi
    public boolean isVasTheme() {
        return QQTheme.isVasTheme();
    }

    static /* synthetic */ Integer g(ECResourceApi eCResourceApi, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "color";
        }
        return eCResourceApi.f(str, str2);
    }

    @Override // com.tencent.ecommerce.biz.res.api.IECResourceApi
    public void fetchDrawable(Context context, String path, IECImageLoader.ImageLoaderOption option, final Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchDrawable(context, path, option, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.res.ECResourceApi$fetchDrawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable drawable) {
                boolean z16 = drawable != null;
                callback.invoke(drawable, Integer.valueOf(z16 ? 0 : AppConstants.RichMediaErrorCode.ERROR_NET_UNEXPECT_END), z16 ? "" : "fetch token drawable error");
            }
        });
    }
}
