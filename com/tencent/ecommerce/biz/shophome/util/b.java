package com.tencent.ecommerce.biz.shophome.util;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0004J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0004J(\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/util/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", ZPlanPublishSource.FROM_SCHEME, "Landroid/os/Bundle;", "arguments", "", h.F, "", "target", "c", "context", "Lorg/json/JSONObject;", "data", "b", "d", WadlProxyConsts.KEY_JUMP_URL, "g", "query", "e", "Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomePageType;", "pageType", "f", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f104380a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/shophome/util/b$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f104381a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference f104382b;

        a(Bundle bundle, WeakReference weakReference) {
            this.f104381a = bundle;
            this.f104382b = weakReference;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            String str;
            int optInt = data.optInt("code", 0);
            if (optInt == 1) {
                cg0.a.b("ECShopHomeSchemeProcessor", "[onItemClickListener] onCallbackFinished code = " + optInt);
                return;
            }
            Bundle bundle = this.f104381a;
            if (bundle == null || (str = bundle.getString("scheme_callback_id")) == null) {
                str = "";
            }
            IECSchemeCallback b16 = ug0.a.b(str);
            if (b16 != null) {
                b16.onCallbackFinished(data);
            }
            Activity activity = (Activity) this.f104382b.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/shophome/util/b$b", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1094b implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f104383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f104384b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f104385c;

        C1094b(WeakReference weakReference, Activity activity, Bundle bundle) {
            this.f104383a = weakReference;
            this.f104384b = activity;
            this.f104385c = bundle;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            String str;
            int optInt = data.optInt("code", 0);
            int optInt2 = data.optInt("target", 0);
            Activity activity = (Activity) this.f104383a.get();
            if (optInt == 1) {
                cg0.a.b("ECShopHomeSchemeProcessor", "shopHomeSchemeJump onCallbackFinished code = " + optInt);
                if (activity != null) {
                    b.f104380a.c(this.f104384b, optInt2);
                    return;
                }
                return;
            }
            Bundle bundle = this.f104385c;
            if (bundle == null || (str = bundle.getString("scheme_callback_id")) == null) {
                str = "";
            }
            IECSchemeCallback b16 = ug0.a.b(str);
            if (b16 != null) {
                b16.onCallbackFinished(data);
            }
            if (activity != null) {
                activity.finish();
            }
        }
    }

    b() {
    }

    private final void h(Activity activity, String scheme, Bundle arguments) {
        ECScheme.f(scheme, new C1094b(new WeakReference(activity), activity, arguments), null, 4, null);
    }

    public final void d(Activity activity, Bundle arguments) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String string;
        String str6 = "";
        if (arguments == null || (str = arguments.getString(WadlProxyConsts.CHANNEL)) == null) {
            str = "";
        }
        if (arguments == null || (str2 = arguments.getString("shop_id")) == null) {
            str2 = "";
        }
        if (arguments == null || (str3 = arguments.getString("is_select", "")) == null) {
            str3 = "";
        }
        if (arguments == null || (str4 = arguments.getString("is_distributor", "")) == null) {
            str4 = "";
        }
        if (arguments == null || (str5 = arguments.getString("coupon_id", "")) == null) {
            str5 = "";
        }
        if (arguments != null && (string = arguments.getString("qz_gdt")) != null) {
            str6 = string;
        }
        ECShopReportParams c16 = com.tencent.ecommerce.biz.shophome.util.a.f104379a.c(arguments);
        String str7 = "mqqapi://ecommerce/open?target=30&channel=" + str + "&shop_id=" + str2 + "&is_select=" + str3 + "&role=" + c16.role + "&source=" + c16.source + "&is_distributor=" + str4 + "&coupon_id=" + str5;
        if (str6.length() > 0) {
            str7 = str7 + "&qz_gdt=" + str6;
        }
        h(activity, str7, arguments);
    }

    public final void e(Activity activity, Bundle arguments, String query) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String string;
        String str6 = "";
        if (arguments == null || (str = arguments.getString(WadlProxyConsts.CHANNEL)) == null) {
            str = "";
        }
        if (arguments == null || (str2 = arguments.getString("shop_id")) == null) {
            str2 = "";
        }
        if (arguments == null || (str3 = arguments.getString("is_select", "")) == null) {
            str3 = "";
        }
        if (arguments == null || (str4 = arguments.getString("is_distributor", "")) == null) {
            str4 = "";
        }
        if (arguments == null || (str5 = arguments.getString("coupon_id", "")) == null) {
            str5 = "";
        }
        if (arguments != null && (string = arguments.getString("qz_gdt")) != null) {
            str6 = string;
        }
        ECShopReportParams c16 = com.tencent.ecommerce.biz.shophome.util.a.f104379a.c(arguments);
        String str7 = "mqqapi://ecommerce/open?target=31&channel=" + str + "&shop_id=" + str2 + "&query=" + query + "&role=" + c16.role + "&source=" + c16.source + "&is_select=" + str3 + "&is_distributor=" + str4 + "&coupon_id=" + str5 + "&src_type=internal&version=1";
        if (str6.length() > 0) {
            str7 = str7 + "&qz_gdt=" + str6;
        }
        cg0.a.b("ECShopHomeSchemeProcessor", "[launchSearchResultPage] jumpScheme = " + str7);
        h(activity, str7, arguments);
    }

    public final void f(Activity activity, Bundle arguments, ECShopHomePageType pageType, String scheme) {
        boolean contains$default;
        String str;
        ECShopReportParams c16 = com.tencent.ecommerce.biz.shophome.util.a.f104379a.c(arguments);
        String str2 = c16.role;
        String str3 = c16.source;
        String str4 = scheme + "&page_type=" + pageType.ordinal() + "&role=" + str2;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) "source=", false, 2, (Object) null);
        if (!contains$default) {
            str4 = str4 + "&source=" + str3;
        }
        if (arguments == null || (str = arguments.getString("qz_gdt")) == null) {
            str = "";
        }
        if (str.length() > 0) {
            str4 = str4 + "&qz_gdt=" + str;
        }
        ECScheme.f(str4, new a(arguments, new WeakReference(activity)), null, 4, null);
    }

    public final void g(Activity activity, Bundle arguments, String jumpUrl) {
        h(activity, jumpUrl, arguments);
    }

    public final void b(Activity context, Bundle arguments, JSONObject data) {
        String str;
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        IECSchemeCallback b16 = ug0.a.b(str);
        if (b16 != null) {
            b16.onCallbackFinished(data);
        }
        context.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Activity activity, int target) {
        if (target == 30) {
            activity.finish();
        }
    }
}
