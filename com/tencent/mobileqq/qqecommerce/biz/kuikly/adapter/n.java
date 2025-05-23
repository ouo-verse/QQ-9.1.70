package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.QQKuiklyCommUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/n;", "Ld01/l;", "Lcom/tencent/kuikly/core/render/android/a;", "renderContext", "Landroid/content/Context;", "g", "", tl.h.F, "i", "", "processName", "e", "", "b", "context", "pageName", "Lorg/json/JSONObject;", ISchemeApi.KEY_PAGE_DATA, "hotReloadIp", "a", "c", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n implements d01.l {

    /* renamed from: a, reason: collision with root package name */
    public static final n f262801a = new n();

    n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context) {
        com.tencent.mobileqq.pad.k kVar;
        SplashActivity splashActivity = context instanceof SplashActivity ? (SplashActivity) context : null;
        if (splashActivity == null || (kVar = splashActivity.getqFragmentStackManager()) == null) {
            return;
        }
        kVar.o();
    }

    private final boolean h(com.tencent.kuikly.core.render.android.a renderContext) {
        Bundle arguments;
        QQKuiklyFragment b16 = QQKuiklyCommUtil.INSTANCE.b(renderContext);
        return (b16 == null || (arguments = b16.getArguments()) == null || true != arguments.getBoolean("is_page_closed")) ? false : true;
    }

    private final boolean i(com.tencent.kuikly.core.render.android.a renderContext) {
        Bundle arguments;
        Bundle bundle;
        QQKuiklyFragment b16 = QQKuiklyCommUtil.INSTANCE.b(renderContext);
        return (b16 == null || (arguments = b16.getArguments()) == null || (bundle = arguments.getBundle("launchKuiklyParams")) == null || true != bundle.getBoolean("is_load_on_split_mode", false)) ? false : true;
    }

    @Override // d01.l
    public void a(Context context, String pageName, JSONObject pageData, String hotReloadIp) {
        boolean startsWith$default;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(hotReloadIp, "hotReloadIp");
        Bundle bundle = new Bundle();
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pageName, "mqqapi://kuikly", false, 2, null);
        if (startsWith$default) {
            bundle.putAll(nf2.a.b(tf2.a.c(pageName)));
        } else {
            bundle.putString("page_name", pageName);
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) pageName, (CharSequence) "bundle_name=new_qecommerce", false, 2, (Object) null);
        if (contains$default) {
            bundle.putSerializable("ext_userdata", nf2.a.e(pageData));
        } else {
            bundle.putAll(nf2.a.b(nf2.a.a(pageData)));
        }
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, bundle);
    }

    @Override // d01.l
    public void b(com.tencent.kuikly.core.render.android.a renderContext) {
        Bundle arguments;
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        final Context g16 = g(renderContext);
        if ((g16 instanceof SplashActivity) && i(renderContext)) {
            if (h(renderContext)) {
                return;
            }
            QQKuiklyFragment b16 = QQKuiklyCommUtil.INSTANCE.b(renderContext);
            if (b16 != null && (arguments = b16.getArguments()) != null) {
                arguments.putBoolean("is_page_closed", true);
            }
            ((SplashActivity) g16).runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.f(g16);
                }
            });
            return;
        }
        Activity activity = g16 instanceof Activity ? (Activity) g16 : null;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // d01.l
    public void c(com.tencent.kuikly.core.render.android.a renderContext, String pageName, JSONObject pageData, String hotReloadIp) {
        boolean startsWith$default;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(hotReloadIp, "hotReloadIp");
        Bundle bundle = new Bundle();
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pageName, "mqqapi://kuikly", false, 2, null);
        if (startsWith$default) {
            bundle.putAll(nf2.a.b(tf2.a.c(pageName)));
        } else {
            bundle.putString("page_name", pageName);
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) pageName, (CharSequence) "bundle_name=new_qecommerce", false, 2, (Object) null);
        if (contains$default) {
            bundle.putSerializable("ext_userdata", nf2.a.e(pageData));
        } else {
            bundle.putAll(nf2.a.b(nf2.a.a(pageData)));
        }
        if (i(renderContext) && e(bundle.getString("process_name"))) {
            if (!bundle.containsKey("is_support_split_mode")) {
                bundle.putBoolean("is_support_split_mode", true);
            }
            if (!bundle.containsKey("is_cover_split_page")) {
                bundle.putBoolean("is_cover_split_page", true);
            }
            if (!bundle.containsKey("is_need_clear_other_fragment")) {
                bundle.putBoolean("is_need_clear_other_fragment", false);
            }
        }
        Context g16 = g(renderContext);
        if (g16 == null) {
            return;
        }
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(g16, bundle);
    }

    private final Context g(com.tencent.kuikly.core.render.android.a renderContext) {
        if ((renderContext != null ? renderContext.getContext() : null) instanceof ContextWrapper) {
            Context context = renderContext != null ? renderContext.getContext() : null;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.content.ContextWrapper");
            return ((ContextWrapper) context).getBaseContext();
        }
        if (renderContext != null) {
            return renderContext.getContext();
        }
        return null;
    }

    private final boolean e(String processName) {
        return (processName == null || processName.length() == 0) || Intrinsics.areEqual(processName, "main") || Intrinsics.areEqual(processName, "local");
    }
}
