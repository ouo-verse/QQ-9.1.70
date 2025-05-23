package com.tencent.mobileqq.zootopia.lua;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaDressLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "code", "", "msg", "Lorg/json/JSONObject;", "c", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "handleMoveDressMethod", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDressLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZootopiaDressLuaPlugin> f328422e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaDressLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaDressLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaDressLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZootopiaDressLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaDressLuaPlugin a() {
            return (ZootopiaDressLuaPlugin) ZootopiaDressLuaPlugin.f328422e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZootopiaDressLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaDressLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaDressLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaDressLuaPlugin invoke() {
                return new ZootopiaDressLuaPlugin();
            }
        });
        f328422e = lazy;
    }

    private final JSONObject c(int code, String msg2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("msg", msg2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(LuaArgument argument, ZootopiaDressLuaPlugin this$0, JSONObject params, FileDownloadData fileDownloadData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(argument, "$argument");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        QLog.i("ZootopiaDressLuaPlugin", 1, "dress download status is " + (fileDownloadData != null ? Integer.valueOf(fileDownloadData.getStatus()) : null) + " path " + (fileDownloadData != null ? fileDownloadData.getFilePath() : null));
        if (!(fileDownloadData != null && fileDownloadData.getStatus() == 5)) {
            argument.callback(argument.fail(this$0.c(-2, "res not download")));
            return;
        }
        String optString = params.optString("dstPath");
        if (Intrinsics.areEqual(fileDownloadData.getFilePath(), optString)) {
            argument.callback(argument.ok(this$0.c(0, "")));
            return;
        }
        File file = new File(fileDownloadData.getFilePath());
        try {
        } catch (IOException e16) {
            QLog.e("ZootopiaDressLuaPlugin", 1, "decompression failed", e16);
        }
        if (file.isFile()) {
            QLog.i("ZootopiaDressLuaPlugin", 1, "real unZipFile");
            ZipUtils.unZipFile(file, optString);
            file.delete();
            z16 = true;
            QLog.i("ZootopiaDressLuaPlugin", 1, "move result is " + z16);
            if (z16) {
                argument.callback(argument.fail(this$0.c(-1, "move file failed")));
                return;
            } else {
                ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).updateDownloadDataFilePath(fileDownloadData.getCategory(), fileDownloadData.getUrl(), optString);
                argument.callback(argument.ok(this$0.c(0, "")));
                return;
            }
        }
        QLog.i("ZootopiaDressLuaPlugin", 1, "targetPath not file");
        z16 = false;
        QLog.i("ZootopiaDressLuaPlugin", 1, "move result is " + z16);
        if (z16) {
        }
    }

    @LuaEvent("L2N_MoveDressResource")
    public final String handleMoveDressMethod(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaDressLuaPlugin", 1, "L2N_MoveDressResource params: " + argument.getF440574c());
        try {
            final JSONObject jSONObject = new JSONObject(argument.getF440574c());
            ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).getDressDownloadInfo(new com.tencent.mobileqq.zootopia.ipc.b() { // from class: com.tencent.mobileqq.zootopia.lua.am
                @Override // com.tencent.mobileqq.zootopia.ipc.b
                public final void a(FileDownloadData fileDownloadData) {
                    ZootopiaDressLuaPlugin.d(LuaArgument.this, this, jSONObject, fileDownloadData);
                }
            });
            return null;
        } catch (Exception e16) {
            QLog.e("ZootopiaDressLuaPlugin", 1, "L2N_MoveDressResource parse error", e16);
            return argument.fail(c(-1, "params parse error"));
        }
    }
}
