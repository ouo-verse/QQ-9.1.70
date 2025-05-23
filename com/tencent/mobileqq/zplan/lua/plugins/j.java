package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/j;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "isSuccess", "", "filePath", "remoteUrl", "", "b", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "uploadFile", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final j f333850d = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/lua/plugins/j$a", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements a.b {
        a() {
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            QLog.i("ZootopiaUploaderLuaPlugin", 1, "sendN2LOnFinished, success: " + success + ", result => " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/lua/plugins/j$b", "Lcom/tencent/mobileqq/zootopia/ipc/upload/a;", "", "isSuccess", "", "remoteUrl", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.ipc.upload.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f333851a;

        b(String str) {
            this.f333851a = str;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.upload.a
        public void a(boolean isSuccess, String remoteUrl) {
            Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
            QLog.i("ZootopiaUploaderLuaPlugin", 1, "upload  filePath: " + this.f333851a + ",  res: " + isSuccess + ", remoteUrl: " + remoteUrl + " ");
            j jVar = j.f333850d;
            String filePath = this.f333851a;
            Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
            jVar.b(isSuccess, filePath, remoteUrl);
        }
    }

    j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean isSuccess, String filePath, String remoteUrl) {
        com.tencent.zplan.luabridge.a aVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", !isSuccess ? 1 : 0);
        jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        jSONObject.put("filePath", filePath);
        jSONObject.put("downloadUrl", remoteUrl);
        QLog.i("ZootopiaUploaderLuaPlugin", 1, "upload file => " + jSONObject);
        if (t74.h.b()) {
            aVar = ZPlanServiceHelper.I.S();
        } else {
            aVar = ZPlanLuaBridge.INSTANCE;
        }
        if (aVar != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
            aVar.callLua("N2L_UploadFileFinished", jSONObject2, new a());
        }
    }

    @LuaEvent("L2N_UploadFile")
    public final String uploadFile(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        JSONObject jSONObject = new JSONObject(arg.getF440574c());
        QLog.d("ZootopiaUploaderLuaPlugin", 1, "show uploadFile " + jSONObject);
        String filePath = jSONObject.optString("filePath");
        Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
        if (filePath.length() == 0) {
            QLog.e("ZootopiaUploaderLuaPlugin", 1, "filePath is empty!");
            return arg.fail();
        }
        String uuid = jSONObject.optString("remotePath");
        if (uuid.length() == 0) {
            String b16 = w.f373306a.b();
            String str = com.tencent.open.base.g.b(new File(filePath)) + com.tencent.mobileqq.zplan.cc.util.h.f332563a.c(filePath);
            uuid = "home_ark_share_all/" + t.f373300a.g() + "/" + com.tencent.open.base.g.d(b16) + "/" + str;
        }
        com.tencent.mobileqq.zootopia.ipc.upload.b bVar = (com.tencent.mobileqq.zootopia.ipc.upload.b) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.upload.b.class);
        Intrinsics.checkNotNullExpressionValue(uuid, "uuid");
        bVar.uploadFile(filePath, uuid, new b(filePath));
        return arg.ok();
    }
}
