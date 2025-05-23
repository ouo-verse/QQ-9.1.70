package com.tencent.mobileqq.zootopia.lua;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanFileLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "scanFolder", "", "Lkotlin/Pair;", "", "e", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "deleteFolder", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanFileLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZPlanFileLuaPlugin> f328385e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanFileLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZPlanFileLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZPlanFileLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZPlanFileLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanFileLuaPlugin a() {
            return (ZPlanFileLuaPlugin) ZPlanFileLuaPlugin.f328385e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZPlanFileLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanFileLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanFileLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanFileLuaPlugin invoke() {
                return new ZPlanFileLuaPlugin();
            }
        });
        f328385e = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i3 = 0; i3 < length; i3++) {
            String optString = jSONArray != null ? jSONArray.optString(i3) : null;
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString == null ? "" : optString);
                QLog.i("ZPlanFileLuaPlugin", 1, "L2N_DeleteFolder#deleteFile - " + optString);
                if (FileUtils.isDir(optString)) {
                    FileUtils.deleteDirectory(optString);
                } else {
                    FileUtils.deleteFile(optString);
                }
            }
        }
        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).deleteOldTaskDataWhenClearCache(arrayList);
        QLog.i("ZPlanFileLuaPlugin", 1, "deleteFolder finish");
    }

    private final List<Pair<Boolean, String>> e(String scanFolder) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(scanFolder)) {
            File file = new File(scanFolder);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    arrayList.add(new Pair(Boolean.valueOf(file2.isDirectory()), file2.getCanonicalPath()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZPlanFileLuaPlugin this$0, final String scanFolder, final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(argument, "$argument");
        Intrinsics.checkNotNullExpressionValue(scanFolder, "scanFolder");
        final List<Pair<Boolean, String>> e16 = this$0.e(scanFolder);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanFileLuaPlugin$scanFolder$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                JSONArray jSONArray = new JSONArray();
                Iterator<T> it = e16.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", 1 ^ (((Boolean) pair.getFirst()).booleanValue() ? 1 : 0));
                    jSONObject.put("fullPath", pair.getSecond());
                    jSONArray.mo162put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Node.CHILDREN_ATTR, jSONArray);
                QLog.i("ZPlanFileLuaPlugin", 1, "L2N_ScanFolder " + scanFolder + ", result= " + jSONObject2);
                argument.callback(jSONObject2.toString());
            }
        });
    }

    @LuaEvent("L2N_DeleteFolder")
    public final String deleteFolder(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanFileLuaPlugin", 1, "L2N_DeleteFolder, " + argument.getF440574c() + ", " + argument);
        try {
            final JSONArray optJSONArray = new JSONObject(argument.getF440574c()).optJSONArray("folderPath");
            if ((optJSONArray != null ? optJSONArray.length() : 0) > 0) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanFileLuaPlugin.d(JSONArray.this);
                    }
                }, 64, null, false);
            } else {
                QLog.i("ZPlanFileLuaPlugin", 1, "folderPath empty");
            }
        } catch (Exception e16) {
            QLog.e("ZPlanFileLuaPlugin", 1, "L2N_DeleteFolder exception", e16);
        }
        return argument.ok();
    }

    @LuaEvent("L2N_ScanFolder")
    public final String scanFolder(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanFileLuaPlugin", 1, "L2N_ScanFolder, " + argument.getF440574c() + ", " + argument);
        try {
            final String optString = new JSONObject(argument.getF440574c()).optString("folderPath");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.m
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanFileLuaPlugin.f(ZPlanFileLuaPlugin.this, optString, argument);
                }
            }, 64, null, false);
            return "";
        } catch (Exception e16) {
            QLog.e("ZPlanFileLuaPlugin", 1, "L2N_ScanFolder exception", e16);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", -1);
            jSONObject.put("err_msg", "exception " + e16.getMessage());
            argument.callback(jSONObject.toString());
            return "";
        }
    }
}
