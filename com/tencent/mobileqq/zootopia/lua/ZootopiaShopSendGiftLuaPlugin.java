package com.tencent.mobileqq.zootopia.lua;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaPortalGiftData;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u000bB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin;", "Lcom/tencent/mobileqq/z1/lua/b;", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin$b;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleReceiveSendGiftEvent", "<init>", "()V", "e", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaShopSendGiftLuaPlugin extends com.tencent.mobileqq.z1.lua.b<b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<ZootopiaShopSendGiftLuaPlugin> f328450f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "PARAM_COIN_COUNT", "Ljava/lang/String;", "PARAM_COIN_ICON", "PARAM_COIN_TYPE", "PARAM_ITEM_ICON", "PARAM_ITEM_ID", "PARAM_LOGO_ICON", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZootopiaShopSendGiftLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaShopSendGiftLuaPlugin a() {
            return (ZootopiaShopSendGiftLuaPlugin) ZootopiaShopSendGiftLuaPlugin.f328450f.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShopSendGiftLuaPlugin$b;", "", "Lcom/tencent/sqshow/zootopia/data/p;", "sendGiftData", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void b(ZootopiaPortalGiftData sendGiftData);
    }

    static {
        Lazy<ZootopiaShopSendGiftLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaShopSendGiftLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaShopSendGiftLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaShopSendGiftLuaPlugin invoke() {
                return new ZootopiaShopSendGiftLuaPlugin();
            }
        });
        f328450f = lazy;
    }

    @LuaEvent("L2N_SendGiftArk")
    public final String handleReceiveSendGiftEvent(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaShopSendGiftLuaPlugin", 2, "handleReceiveSendGiftEvent, event: " + argument.getF440573b() + ", params:" + argument.getF440574c());
        }
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            long optLong = jSONObject.optLong("ItemId", 0L);
            String coinIcon = jSONObject.optString("CoinIcon", "");
            int optInt = jSONObject.optInt("CoinCount", 0);
            String itemIcon = jSONObject.optString("ItemIcon", "");
            String logoIcon = jSONObject.optString("LogoIcon", "");
            Intrinsics.checkNotNullExpressionValue(coinIcon, "coinIcon");
            Intrinsics.checkNotNullExpressionValue(itemIcon, "itemIcon");
            Intrinsics.checkNotNullExpressionValue(logoIcon, "logoIcon");
            ZootopiaPortalGiftData zootopiaPortalGiftData = new ZootopiaPortalGiftData(optLong, coinIcon, optInt, itemIcon, logoIcon);
            Iterator<T> it = a().iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(zootopiaPortalGiftData);
            }
            return argument.ok();
        } catch (Throwable th5) {
            QLog.e("ZootopiaShopSendGiftLuaPlugin", 1, "handleReceiveSendGiftEvent throw t:" + th5);
            return argument.fail();
        }
    }
}
