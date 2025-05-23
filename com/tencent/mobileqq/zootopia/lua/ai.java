package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import com.epicgames.ue4.GameActivity;
import com.tencent.av.service.i;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.lua.ai;
import com.tencent.mobileqq.zootopia.qav.MultiVoiceChatController;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.mobileqq.zplan.ipc.business.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ai;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "startQQAudioCall", "notifyZPlanGameStatusChange", "operateQQChatRoomMicState", "startQQChatRoom", "exitQQChatRoom", "operateQQChatRoomSpeakerState", "getQQChatRoomOpenIdList", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ai extends LuaBasePlugin {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final HashSet<Companion.InterfaceC9112a> f328485f = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f328486h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static boolean f328487i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013J\"\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\tJ\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u0007R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010)R$\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00130*j\b\u0012\u0004\u0012\u00020\u0013`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ai$a;", "", "", "isC2C", "", "", "callList", "", "d", "", "retCode", "callee", "k", "status", "caller", "f", "roomOwner", "causer", "g", "Lcom/tencent/mobileqq/zootopia/lua/ai$a$a;", "listener", "a", "isSuccess", "errorCode", "reason", tl.h.F, "j", "action", "openId", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "sIsAudioPluginRegister", "Z", "b", "()Z", "l", "(Z)V", "GAME_ID_NONE", "I", "TAG", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "sGetRoomInfoListener", "Ljava/util/HashSet;", "Ljava/lang/Object;", "sGetRoomInfoListenerLock", "Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ai$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ai$a$a;", "", "", "isInGame", "", VirtualAppProxy.KEY_GAME_ID, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zootopia.lua.ai$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public interface InterfaceC9112a {
            void a(boolean isInGame, int gameId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(InterfaceC9112a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (ai.f328486h) {
                if (!ai.f328485f.contains(listener)) {
                    ai.f328485f.add(listener);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (!b()) {
                synchronized (ai.f328486h) {
                    Iterator it = ai.f328485f.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC9112a) it.next()).a(false, 0);
                    }
                    ai.f328485f.clear();
                    Unit unit2 = Unit.INSTANCE;
                }
            } else {
                ZPlanLuaBridge.INSTANCE.callLua("N2L_GetCurrentGameInfo", (a.b) new b(), true);
            }
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "N2L_GetCurrentGameInfo");
        }

        public final boolean b() {
            return ai.f328487i;
        }

        public final void c() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
                ((ZPlanAppInterface) appInterface).s(new Object[]{2});
            }
        }

        public final void d(boolean isC2C, List<String> callList) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("IsC2C", isC2C);
            if (!isC2C && callList != null) {
                List<String> list = callList;
                if (!list.isEmpty()) {
                    jSONObject.put("CallList", new JSONArray((Collection) list));
                }
            }
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnAudioEnterRoom", jSONObject, null, false, 12, null);
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "N2L_OnAudioEnterRoom param: " + jSONObject);
        }

        public final void e(int action, String openId) {
            Intrinsics.checkNotNullParameter(openId, "openId");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Action.TAG, action);
            jSONObject.put("MemID", openId);
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnChatRoomMemberChanged", jSONObject, null, false, 12, null);
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "N2L_OnChatRoomMemberChanged, param: " + jSONObject);
        }

        public final void f(int status, String caller, String callee) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("IsC2C", true);
            jSONObject.put("Status", status);
            jSONObject.put("Caller", caller);
            jSONObject.put("Callee", callee);
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnQQAudioCallEvent", jSONObject, null, false, 12, null);
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "N2L_OnQQAudioCallEvent, param: " + jSONObject);
        }

        public final void g(int status, String roomOwner, String causer) {
            Intrinsics.checkNotNullParameter(roomOwner, "roomOwner");
            Intrinsics.checkNotNullParameter(causer, "causer");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("IsC2C", false);
            jSONObject.put("GroupStatus", status);
            jSONObject.put("RoomOwner", roomOwner);
            jSONObject.put("Causer", causer);
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnQQAudioCallEvent", jSONObject, null, false, 12, null);
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "N2L_OnQQAudioCallEvent, param: " + jSONObject);
        }

        public final void h(boolean isSuccess, int errorCode, String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GameActivity.DOWNLOAD_RETURN_NAME, isSuccess ? 1 : 2);
            jSONObject.put("ErrorCode", errorCode);
            jSONObject.put("Reason", reason);
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnEnterQQChatRoom", jSONObject, null, false, 12, null);
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "notifyLuSelfEnterQQChatRoom, param:" + jSONObject);
        }

        public final void j(int reason) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Reason", reason);
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnExitQQChatRoom", jSONObject, null, false, 12, null);
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "notifyLuaSelfExitQQChatRoom, param:" + jSONObject);
        }

        public final void k(int retCode, String callee) {
            Intrinsics.checkNotNullParameter(callee, "callee");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("RetCode", retCode);
            jSONObject.put("Callee", callee);
            a.C10063a.d(ZPlanLuaBridge.INSTANCE, "N2L_OnStartQQAudioCallback", jSONObject, null, false, 12, null);
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "N2L_OnStartQQAudioCallback, param: " + jSONObject);
        }

        public final void l(boolean z16) {
            ai.f328487i = z16;
        }

        public final void m(int status) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
                ((ZPlanAppInterface) appInterface).s(new Object[]{1, Integer.valueOf(status)});
            }
        }

        Companion() {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ai$a$b", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zootopia.lua.ai$a$b */
        /* loaded from: classes35.dex */
        public static final class b implements a.b {
            b() {
            }

            @Override // com.tencent.zplan.luabridge.a.b
            public void onExecuteLua() {
                a.b.C10064a.a(this);
            }

            @Override // com.tencent.zplan.luabridge.a.b
            public void onLuaResult(final boolean success, final String result) {
                QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "N2L_GetCurrentGameInfo onLuaResult, success=" + success + ", result=" + result);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.aj
                    @Override // java.lang.Runnable
                    public final void run() {
                        ai.Companion.b.b(success, result);
                    }
                }, 16, null, false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0037 A[LOOP:0: B:5:0x0031->B:7:0x0037, LOOP_END] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static final void b(boolean z16, String str) {
                boolean z17;
                int i3;
                JSONObject jSONObject;
                Iterator it;
                boolean z18 = false;
                int i16 = 0;
                if (z16) {
                    try {
                        jSONObject = new JSONObject(str);
                        z17 = jSONObject.optBoolean("IsInGame", false);
                    } catch (JSONException e16) {
                        e = e16;
                        z17 = false;
                    }
                    try {
                        i16 = jSONObject.optInt("GameId", 0);
                    } catch (JSONException e17) {
                        e = e17;
                        QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_OnCurrentGameInfo error", e);
                        i3 = i16;
                        z18 = z17;
                        it = ai.f328485f.iterator();
                        while (it.hasNext()) {
                        }
                        synchronized (ai.f328486h) {
                        }
                    }
                    i3 = i16;
                    z18 = z17;
                } else {
                    i3 = 0;
                }
                it = ai.f328485f.iterator();
                while (it.hasNext()) {
                    ((InterfaceC9112a) it.next()).a(z18, i3);
                }
                synchronized (ai.f328486h) {
                    ai.f328485f.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public static /* synthetic */ void i(Companion companion, boolean z16, int i3, String str, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            if ((i16 & 4) != 0) {
                str = "";
            }
            companion.h(z16, i3, str);
        }
    }

    public ai(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String openId, long j3, boolean z16) {
        if (z16) {
            QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_StartQQChatRoom in av chatting");
            INSTANCE.h(false, -1, "\u5f53\u524d\u6b63\u5728QQ\u901a\u8bdd\u4e2d");
            return;
        }
        MultiVoiceChatController.Companion companion = MultiVoiceChatController.INSTANCE;
        if (!companion.a().getIsEntering().get()) {
            companion.a().C();
            companion.a().getIsEntering().set(true);
            MultiVoiceChatController a16 = companion.a();
            Intrinsics.checkNotNullExpressionValue(openId, "openId");
            if (a16.w(openId, j3) != 0) {
                QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_StartQQChatRoom, getSign failed");
                return;
            }
            return;
        }
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_StartQQChatRoom, has already start entering");
    }

    @LuaEvent("L2N_ExitQQChatRoom")
    public final String exitQQChatRoom(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_ExitQQChatRoom, param: " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            jSONObject.optString("UserID");
            jSONObject.optString("RoomID");
            MultiVoiceChatController.p(MultiVoiceChatController.INSTANCE.a(), 0, 1, null);
            return "";
        } catch (JSONException e16) {
            QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_ExitQQChatRoom error", e16);
            return "";
        }
    }

    @LuaEvent("L2N_GetQQChatRoomOpenIdList")
    public final String getQQChatRoomOpenIdList(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_GetQQChatRoomOpenIdList, param: " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            jSONObject.optString("OpenID");
            long optLong = jSONObject.optLong("RoomID");
            MultiVoiceChatController.Companion companion = MultiVoiceChatController.INSTANCE;
            int v3 = companion.a().v(optLong);
            if (v3 != 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameActivity.DOWNLOAD_RETURN_NAME, 2);
                jSONObject2.put("ErrorCode", v3);
                argument.callback(argument.fail(jSONObject2));
                return "";
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(GameActivity.DOWNLOAD_RETURN_NAME, 1);
            jSONObject3.put("ErrorCode", 0);
            ArrayList<String> u16 = companion.a().u();
            if (u16 != null && (!u16.isEmpty())) {
                jSONObject3.put("OpenIdList", new JSONArray((Collection) u16));
            } else {
                QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_GetQQChatRoomOpenIdList, result is null or empty");
            }
            argument.callback(argument.ok(jSONObject3));
            return "";
        } catch (JSONException e16) {
            QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_OperateQQChatRoomMic error", e16);
            return "";
        }
    }

    @LuaEvent("L2N_NotifyZPlanGameStatusChange")
    public final String notifyZPlanGameStatusChange(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_NotifyZPlanGameStatusChange, param: " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            int optInt = jSONObject.optInt("GameId");
            int optInt2 = jSONObject.optInt("Status", 2);
            boolean optBoolean = jSONObject.optBoolean("IsInQQAudio");
            if (optInt2 == 1) {
                QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "bindWWiseAudioToQAV ret=" + ZplanAVControllerForQAV.INSTANCE.f());
            } else {
                QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "unbindWWiseAudioToQAV ret=" + ZplanAVControllerForQAV.INSTANCE.K());
            }
            if (optBoolean) {
                ZplanAVControllerForQAV.Companion companion = ZplanAVControllerForQAV.INSTANCE;
                if (companion.t(optInt)) {
                    if (optInt2 == 1) {
                        companion.v(optInt2, optInt == 200001);
                        INSTANCE.m(1);
                    } else {
                        companion.B(true);
                        companion.C(optInt == 200001);
                    }
                }
                if (optInt2 == 1) {
                    com.tencent.av.zplan.c.m("tencent.video.v2z.is_c2c", null, new b());
                    return "";
                }
                return "";
            }
            return "";
        } catch (JSONException e16) {
            QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_NotifyZPlanGameStatusChange error", e16);
            return "";
        }
    }

    @LuaEvent("L2N_OperateQQChatRoomMic")
    public final String operateQQChatRoomMicState(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_OperateQQChatRoomMic, param: " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            jSONObject.optString("OpenID");
            MultiVoiceChatController.INSTANCE.a().O(jSONObject.optInt("MicState", 0) == 1);
            return "";
        } catch (JSONException e16) {
            QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_OperateQQChatRoomMic error", e16);
            return "";
        }
    }

    @LuaEvent("L2N_OperateQQChatRoomSpeaker")
    public final String operateQQChatRoomSpeakerState(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_OperateQQChatRoomSpeaker, param: " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            jSONObject.optString("OpenID");
            MultiVoiceChatController.INSTANCE.a().P(jSONObject.optInt("SpeakerState", 0) == 1);
            return "";
        } catch (JSONException e16) {
            QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_OperateQQChatRoomMic error", e16);
            return "";
        }
    }

    @LuaEvent("L2N_StartQQAudioCall")
    public final String startQQAudioCall(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_StartQQAudioCall, param: " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            jSONObject.optInt("ViewType");
            String callee = jSONObject.optString("Callee");
            Companion companion = INSTANCE;
            companion.m(0);
            ZplanAVControllerForQAV.Companion companion2 = ZplanAVControllerForQAV.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(callee, "callee");
            if (!companion2.H(callee, this.activity)) {
                companion.c();
                return "";
            }
            return "";
        } catch (JSONException e16) {
            QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_StartQQAudioCall error", e16);
            return "";
        }
    }

    @LuaEvent("L2N_StartQQChatRoom")
    public final String startQQChatRoom(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_StartQQChatRoom, param: " + argument.getF440574c());
        try {
            JSONObject jSONObject = new JSONObject(argument.getF440574c());
            final String optString = jSONObject.optString("UserID");
            final long optLong = jSONObject.optLong("RoomID");
            ((com.tencent.mobileqq.zplan.ipc.business.d) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.d.class)).isAvChatting(new d.a() { // from class: com.tencent.mobileqq.zootopia.lua.ah
                @Override // com.tencent.mobileqq.zplan.ipc.business.d.a
                public final void a(boolean z16) {
                    ai.f(optString, optLong, z16);
                }
            });
            return "";
        } catch (JSONException e16) {
            QLog.e("[RTAudio][zplan]ZootopiaAudioPlugin", 1, "L2N_StartQQChatRoom error", e16);
            return "";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ai$b", "Lcom/tencent/av/service/i$a;", "", StateEvent.ProcessResult.SUCCEED, "", "resultJson", "", ICustomDataEditor.STRING_ARRAY_PARAM_5, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends i.a {
        b() {
        }

        @Override // com.tencent.av.service.i
        public void a5(boolean succeed, String resultJson) {
            if (succeed) {
                ai.INSTANCE.d(true, null);
            } else {
                com.tencent.av.zplan.c.m("tencent.video.v2z.get_call_list", null, null);
            }
        }
    }
}
