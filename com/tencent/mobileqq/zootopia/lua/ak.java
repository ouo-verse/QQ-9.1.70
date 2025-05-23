package com.tencent.mobileqq.zootopia.lua;

import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ak;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "uin", "", "width", "height", "c", "", "b", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "handleAvatarTexture", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "texturePathMap", "e", "Ljava/lang/String;", "lastRequestFlag", "<init>", "()V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ak extends LuaBasePlugin {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final ak f328492h = new ak();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, String> texturePathMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String lastRequestFlag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ak$a", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "success", "", "engineInitFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ZPlanEngineStatusUpdateListener {
        a() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            QLog.i("ZootopiaAvatarTextureLuaPlugin", 1, "registerAvatarTextureLuaPlugin");
            ar.f328509a.b(ak.this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(this, z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ak$b;", "", "Lcom/tencent/mobileqq/zootopia/lua/ak;", "INSTANCE", "Lcom/tencent/mobileqq/zootopia/lua/ak;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ak;", "", "AVATAR_IMG_DEFAULT_H", "I", "AVATAR_IMG_DEFAULT_W", "GENDER_SEX_MAN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ak$b, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ak a() {
            return ak.f328492h;
        }

        Companion() {
        }
    }

    public ak() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).registerZPlanEngineStatusUpdateListener(new a());
        this.texturePathMap = new ConcurrentHashMap<>();
    }

    public final String c(String uin, int width, int height) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaAvatarTextureLuaPlugin", 1, "getAvatarTexture, " + MobileQQ.sProcessId + ", " + uin + ", " + width + ", " + height);
        }
        if (TextUtils.isEmpty(uin)) {
            return "";
        }
        if (width <= 0) {
            width = 800;
        }
        if (height <= 0) {
            height = 800;
        }
        int i3 = new com.tencent.mobileqq.zplan.proxy.c().getGender() == 1 ? 1 : 2;
        String str = uin + "_" + i3 + "_" + width + "_" + height;
        String str2 = this.texturePathMap.get(str);
        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("ZootopiaAvatarTextureLuaPlugin", 1, "getAvatarTexture, " + str + ", hit mem, " + str2);
            }
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        this.lastRequestFlag = str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uin", uin);
        jSONObject.put("sex", i3);
        jSONObject.put("width", width);
        jSONObject.put("height", height);
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaAvatarTextureLuaPlugin", 1, "getAvatarTexture, call lua, params: " + jSONObject);
        }
        ar.f328509a.a("N2L_RecordLoading", jSONObject.toString());
        return "";
    }

    @LuaEvent("L2N_RecordLoading")
    public final String handleAvatarTexture(LuaArgument argument) {
        String str;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaAvatarTextureLuaPlugin", 1, hashCode() + ", handleAvatarTexture, params:" + argument.getParams() + ", lastRequest: " + this.lastRequestFlag);
        JSONObject jSONObject = new JSONObject(argument.getParams());
        int optInt = jSONObject.optInt("errorCode", -1);
        String optString = jSONObject.optString("texturePath", null);
        String optString2 = jSONObject.optString("uin", null);
        int optInt2 = jSONObject.optInt("sex", -1);
        int optInt3 = jSONObject.optInt("width", -1);
        int optInt4 = jSONObject.optInt("height", -1);
        String optString3 = jSONObject.optString("avatarKey", null);
        if (!TextUtils.isEmpty(optString2) && optInt2 != -1 && optInt3 != -1 && optInt4 != -1) {
            str = optString2 + "_" + optInt2 + "_" + optInt3 + "_" + optInt4;
        } else {
            str = this.lastRequestFlag;
        }
        if (TextUtils.isEmpty(str)) {
            return argument.ok();
        }
        if (optInt == 0) {
            if (!TextUtils.isEmpty(optString) && new File(optString).exists()) {
                ConcurrentHashMap<String, String> concurrentHashMap = this.texturePathMap;
                Intrinsics.checkNotNull(str);
                Intrinsics.checkNotNull(optString);
                concurrentHashMap.put(str, optString);
            } else {
                ConcurrentHashMap<String, String> concurrentHashMap2 = this.texturePathMap;
                Intrinsics.checkNotNull(str);
                concurrentHashMap2.put(str, "");
            }
            QLog.i("ZootopiaAvatarTextureLuaPlugin", 1, "handleAvatarTexture, path:" + optString + ", " + str + ", " + optString3);
        }
        return argument.ok();
    }

    public final void b() {
        QLog.i("ZootopiaAvatarTextureLuaPlugin", 1, HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        this.texturePathMap.clear();
    }
}
