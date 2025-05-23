package com.tencent.mobileqq.zootopia.lua;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/be;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleOpenCartShopping", "handleCloseCartShopping", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "d", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "viewManager", "<init>", "(Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class be extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager viewManager;

    public be(UEActivityViewManager viewManager) {
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        this.viewManager = viewManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(be this$0, int i3, List itemList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemList, "$itemList");
        this$0.viewManager.x(i3, itemList);
    }

    @LuaEvent("L2N_CloseShoppingCart")
    public final String handleCloseCartShopping(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZplanCartShoppingLua", 1, "handleCloseCartShopping --> " + argument);
        this.viewManager.m();
        return argument.ok();
    }

    @LuaEvent("L2N_OpenShoppingCart")
    public final String handleOpenCartShopping(LuaArgument argument) {
        final int optInt;
        JSONArray optJSONArray;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZplanCartShoppingLua", 1, "handleOpenCartShopping --> " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            optInt = jSONObject.optInt("gender");
            optJSONArray = jSONObject.optJSONArray("storeItem");
        } catch (Exception e16) {
            QLog.e("ZplanCartShoppingLua", 1, "parse json error " + e16);
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            final ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                uv4.bd bdVar = new uv4.bd();
                bdVar.f440321b = optJSONObject.optInt("itemId");
                bdVar.f440320a = optJSONObject.optLong("storeItemId");
                bdVar.f440322c = optJSONObject.optLong("ugcId");
                arrayList.add(bdVar);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.bd
                @Override // java.lang.Runnable
                public final void run() {
                    be.b(be.this, optInt, arrayList);
                }
            });
            return argument.ok();
        }
        return argument.fail("storeItem can`t be not");
    }
}
