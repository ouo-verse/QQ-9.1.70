package com.tencent.mobileqq.zootopia.lua;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u000bB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaCleanSceneDataPlugin;", "Lcom/tencent/mobileqq/z1/lua/b;", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaCleanSceneDataPlugin$b;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleCleanSceneData", "<init>", "()V", "e", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaCleanSceneDataPlugin extends com.tencent.mobileqq.z1.lua.b<b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<ZootopiaCleanSceneDataPlugin> f328420f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaCleanSceneDataPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaCleanSceneDataPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaCleanSceneDataPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZootopiaCleanSceneDataPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaCleanSceneDataPlugin a() {
            return (ZootopiaCleanSceneDataPlugin) ZootopiaCleanSceneDataPlugin.f328420f.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaCleanSceneDataPlugin$b;", "", "", "", "keyList", "", "u8", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void u8(List<String> keyList);
    }

    static {
        Lazy<ZootopiaCleanSceneDataPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaCleanSceneDataPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaCleanSceneDataPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaCleanSceneDataPlugin invoke() {
                return new ZootopiaCleanSceneDataPlugin();
            }
        });
        f328420f = lazy;
    }

    @LuaEvent("L2N_CleanSceneData")
    public final String handleCleanSceneData(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaCleanSceneDataPlugin", 2, "handleCleanSceneData, params:" + argument.getParams());
        }
        JSONArray optJSONArray = new JSONObject(argument.getParams()).optJSONArray("keys");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                Intrinsics.checkNotNullExpressionValue(optString, "keyJsonArray.optString(i)");
                arrayList.add(optString);
            }
            if (!arrayList.isEmpty()) {
                Iterator<T> it = a().iterator();
                while (it.hasNext()) {
                    ((b) it.next()).u8(arrayList);
                }
            }
        }
        return argument.ok();
    }
}
