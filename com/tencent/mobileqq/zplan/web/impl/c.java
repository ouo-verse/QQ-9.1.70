package com.tencent.mobileqq.zplan.web.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.mobileqq.zootopia.ue.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/c;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleOpenTransparentWebView", "handleH5MediaSource", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "d", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "viewManager", "<init>", "(Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager viewManager;

    public c(UEActivityViewManager viewManager) {
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        this.viewManager = viewManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c this$0, JSONObject params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        this$0.viewManager.getH5MediaStatusManager().d(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UEActivityViewManager uEActivityViewManager = this$0.viewManager;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        b.a.a(uEActivityViewManager, url, false, false, 6, null);
    }

    @LuaEvent("L2N_HandleH5MediaSource")
    public final String handleH5MediaSource(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("TransparentWebViewPlugin", 1, "L2N_HandleH5MediaSource #handleH5MediaSource  == " + argument.getF440574c());
        final JSONObject jSONObject = new JSONObject(argument.getF440574c());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                c.c(c.this, jSONObject);
            }
        });
        return argument.ok();
    }

    @LuaEvent("L2N_OpenTransparentWebView")
    public final String handleOpenTransparentWebView(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("TransparentWebViewPlugin", 1, "OpenTransparentWebView  == " + argument.getF440574c());
        final String optString = new JSONObject(argument.getF440574c()).optString("url");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(c.this, optString);
            }
        });
        return argument.ok();
    }
}
