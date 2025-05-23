package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/o;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "c", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleUIOverlapCheck", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/b;", "e", "Lcom/tencent/mobileqq/zootopia/ue/b;", "viewManager", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/zootopia/ue/b;)V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class o extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.ue.b viewManager;

    public o(Activity activity, com.tencent.mobileqq.zootopia.ue.b viewManager) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        this.activity = activity;
        this.viewManager = viewManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(o this$0, ViewGroup viewGroup, JSONObject result, LuaArgument argument) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(argument, "$argument");
        if (this$0.c()) {
            int i3 = LiuHaiUtils.getRealDisplay(this$0.activity)[1];
            int height = viewGroup.getHeight();
            QLog.i("ZPlanOverlapCheckPlugin_", 1, "Portrait screenHeight:" + i3 + ", viewHeight:" + height);
            if (i3 == height) {
                result.put("isOverlap", 1);
            }
        } else {
            int i16 = LiuHaiUtils.getRealDisplay(this$0.activity)[0];
            int width = viewGroup.getWidth();
            QLog.i("ZPlanOverlapCheckPlugin_", 1, "LANDSCAPE screenWidth:" + i16 + ", viewWidth:" + width);
            if (i16 == width) {
                result.put("isOverlap", 1);
            }
        }
        QLog.i("ZPlanOverlapCheckPlugin_", 1, "handleUIOverlapCheck result:" + result);
        argument.callback(result.toString());
    }

    private final boolean c() {
        int i3 = this.activity.getResources().getConfiguration().orientation;
        QLog.i("ZPlanOverlapCheckPlugin_", 1, "orientation:" + i3);
        return i3 == 1;
    }

    @LuaEvent("L2N_UIOverlapCheck")
    public final String handleUIOverlapCheck(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        boolean z16 = LiuHaiUtils.mHasNotch;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.activity);
        QLog.i("ZPlanOverlapCheckPlugin_", 1, "handleUIOverlapCheck hasNotch:" + z16 + ", statusBarHeight:" + statusBarHeight);
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("isOverlap", 0);
        jSONObject.put("statusBarHeight", statusBarHeight);
        final ViewGroup rootView = this.viewManager.getRootView();
        if (rootView == null) {
            QLog.w("ZPlanOverlapCheckPlugin_", 1, "handleUIOverlapCheck rootView is null. result:" + jSONObject);
            argument.callback(jSONObject.toString());
            return "";
        }
        rootView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.n
            @Override // java.lang.Runnable
            public final void run() {
                o.b(o.this, rootView, jSONObject, argument);
            }
        });
        return "";
    }
}
