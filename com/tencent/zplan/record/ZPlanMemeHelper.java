package com.tencent.zplan.record;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.epicgames.ue4.GameActivityThunk;
import com.epicgames.ue4.NativeCalls;
import com.epicgames.ue4.RecordFrameBuffer;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.zplan.IZPlanRecordCallback;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ERROR_ENGINE_RECORD_FAIL;
import com.tencent.zplan.meme.encoder.IRecordOperator;
import com.tencent.zplan.meme.encoder.MemeEncodeController;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.model.Properties;
import com.tencent.zplan.model.ZPlanRecordFrameData;
import com.tencent.zplan.record.ZPlanMemeHelper$ueRecordFrameListener$2;
import com.tencent.zplan.utils.ZLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lx4.f;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import yx4.c;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0002TUB\t\b\u0002\u00a2\u0006\u0004\bR\u0010SJ=\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\u0004\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ!\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u0019\u0010*\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010-\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u0019\u00100\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)R\u0019\u00103\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010)R\u0019\u00105\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b4\u0010)R\u0019\u00108\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b6\u0010'\u001a\u0004\b7\u0010)R\u0019\u0010:\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b9\u0010)R\u0016\u0010<\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010>R\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010@R\u001b\u0010E\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010C\u001a\u0004\b6\u0010DR\u0017\u0010J\u001a\u00020F8\u0006\u00a2\u0006\f\n\u0004\b/\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010N\u001a\u00020K8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/zplan/record/ZPlanMemeHelper;", "", "", "methodName", "", "Ljava/lang/Class;", "paramsTypes", "Ljava/lang/reflect/Method;", "r", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "i", "", "t", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "params", "Lcom/tencent/zplan/IZPlanRecordCallback;", "callback", "u", "(Lcom/tencent/zplan/meme/model/MemeRecordParams;Lcom/tencent/zplan/IZPlanRecordCallback;)V", "a", "Ljava/lang/Class;", "getSTRING", "()Ljava/lang/Class;", "STRING", "b", "getINT", "INT", "Lcom/tencent/zplan/model/ZPlanRecordFrameData;", "c", "getFRAME_DATA", "FRAME_DATA", "Landroid/os/Bundle;", "d", "getBUNDLE", "BUNDLE", "e", "Ljava/lang/reflect/Method;", "l", "()Ljava/lang/reflect/Method;", "METHOD_ON_ENCODE_START", "f", "k", "METHOD_ON_ENCODE_END", "g", "p", "METHOD_ON_RECORD_FRAME_START", h.F, "getMETHOD_ON_RECORD_SINGLE_FRAME", "METHOD_ON_RECORD_SINGLE_FRAME", "o", "METHOD_ON_RECORD_FRAME_END", "j", DomainData.DOMAIN_NAME, "METHOD_ON_RECORD_DONE", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "METHOD_ON_RECORD_COVER_DONE", "Z", "isThreadStart", "", "J", "curRenderOffscreenHandleLong", "I", "lastRecordFrameTaskId", "Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", "Lkotlin/Lazy;", "()Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", "encodeController", "Lcom/tencent/zplan/record/ZPlanMemeHelper$RecordPlugin;", "Lcom/tencent/zplan/record/ZPlanMemeHelper$RecordPlugin;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/zplan/record/ZPlanMemeHelper$RecordPlugin;", "recordPlugin", "Lcom/epicgames/ue4/GameActivityThunk$RecordFrameListener;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/epicgames/ue4/GameActivityThunk$RecordFrameListener;", "ueRecordFrameListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "encodeRecordFrameRunnable", "<init>", "()V", "RecordPlugin", "ZPlanRecordOperator", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanMemeHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Class<String> STRING;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Class<Integer> INT;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Class<ZPlanRecordFrameData> FRAME_DATA;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Class<Bundle> BUNDLE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Method METHOD_ON_ENCODE_START;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Method METHOD_ON_ENCODE_END;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Method METHOD_ON_RECORD_FRAME_START;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Method METHOD_ON_RECORD_SINGLE_FRAME;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Method METHOD_ON_RECORD_FRAME_END;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Method METHOD_ON_RECORD_DONE;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Method METHOD_ON_RECORD_COVER_DONE;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isThreadStart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static long curRenderOffscreenHandleLong;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static volatile int lastRecordFrameTaskId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static final Lazy encodeController;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final RecordPlugin recordPlugin;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy ueRecordFrameListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static final Runnable encodeRecordFrameRunnable;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final ZPlanMemeHelper f385999s;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/zplan/record/ZPlanMemeHelper$RecordPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "b", "Lorg/json/JSONObject;", "propertiesJson", "", "fps", "totalFrameCount", "recordKey", "", "c", "a", "handleRecordActionStart", "handleRecordActionEnd", "handleQZoneAvatarRecordStart", "handleCommonRecordStart", "handleQZoneAvatarRecordEnd", "handleCommonRecordEnd", "handleAppearanceKeyChangeFromEngine", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class RecordPlugin extends LuaBasePlugin {
        private final String a(LuaArgument argument) {
            String str;
            boolean z16;
            MemeRecordParams params;
            String f440574c = argument.getF440574c();
            JSONObject jSONObject = new JSONObject(f440574c);
            int optInt = jSONObject.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            ZPlanMemeHelper zPlanMemeHelper = ZPlanMemeHelper.f385999s;
            if (!zPlanMemeHelper.i(optInt)) {
                ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleBatchRecordEnd, taskId:" + optInt + " not equal to currentTaskId!!, params:" + f440574c);
                return argument.fail();
            }
            IRecordOperator recordOperator = zPlanMemeHelper.j().getRecordOperator();
            String str2 = null;
            if (!(recordOperator instanceof ZPlanRecordOperator)) {
                recordOperator = null;
            }
            ZPlanRecordOperator zPlanRecordOperator = (ZPlanRecordOperator) recordOperator;
            if (zPlanRecordOperator != null && (params = zPlanRecordOperator.getParams()) != null) {
                str = params.getUniKey();
            } else {
                str = null;
            }
            if (str == null) {
                ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleBatchRecordEnd, taskId:" + optInt + ", recordKey null");
                return argument.fail();
            }
            int optInt2 = jSONObject.optInt("portraitId");
            int optInt3 = jSONObject.optInt("errorCode");
            ZLog zLog = ZLog.f386189b;
            zLog.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleBatchRecordEnd, portraitId:" + optInt2 + ", errorCode:" + optInt3 + ", params:" + f440574c);
            if (optInt3 != 0 && Meme.f385754h.k().getDetectErrorOnL2NEnd()) {
                Bundle bundle = new Bundle();
                bundle.putInt("MemeRecordActionStatus", ERROR_ENGINE_RECORD_FAIL.INSTANCE.toInt());
                bundle.putInt("MemeRecordScriptErrorCode", optInt3);
                zPlanRecordOperator.onRecordDone(str, optInt2, bundle);
                return argument.fail();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("statistic");
            if (optJSONObject != null) {
                str2 = optJSONObject.toString();
            }
            MemeEncodeController j3 = zPlanMemeHelper.j();
            if (optInt3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            j3.h(optInt2, z16, str2);
            if (!ZPlanMemeHelper.e(zPlanMemeHelper)) {
                zLog.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleBatchRecordEnd postToEncodeThread.");
                zPlanMemeHelper.t();
            }
            return argument.ok();
        }

        private final String b(LuaArgument argument) {
            MemeRecordParams params;
            String f440574c = argument.getF440574c();
            JSONObject jSONObject = new JSONObject(f440574c);
            int optInt = jSONObject.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            ZPlanMemeHelper zPlanMemeHelper = ZPlanMemeHelper.f385999s;
            if (!zPlanMemeHelper.i(optInt)) {
                ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleBatchRecordStart, taskId:" + optInt + " not equal to currentTaskId!! params:" + f440574c);
                return argument.fail();
            }
            IRecordOperator recordOperator = zPlanMemeHelper.j().getRecordOperator();
            String str = null;
            if (!(recordOperator instanceof ZPlanRecordOperator)) {
                recordOperator = null;
            }
            ZPlanRecordOperator zPlanRecordOperator = (ZPlanRecordOperator) recordOperator;
            if (zPlanRecordOperator != null && (params = zPlanRecordOperator.getParams()) != null) {
                str = params.getUniKey();
            }
            if (str == null) {
                ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleBatchRecordStart, taskId:" + optInt + ", recordKey null");
                return argument.fail();
            }
            int optInt2 = jSONObject.optInt("portraitId");
            int optInt3 = jSONObject.optInt("errorCode");
            ZLog.f386189b.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleBatchRecordStart, portraitId:" + optInt2 + ", errorCode:" + optInt3 + ", params:" + f440574c);
            if (optInt3 != 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("MemeRecordActionStatus", ERROR_ENGINE_RECORD_FAIL.INSTANCE.toInt());
                bundle.putInt("MemeRecordScriptErrorCode", optInt3);
                zPlanRecordOperator.onRecordDone(str, optInt2, bundle);
                return argument.fail();
            }
            int optInt4 = jSONObject.optInt("fps", 30);
            int optInt5 = jSONObject.optInt("totalFrameCount", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject(Constants.Service.PROPERTIES);
            String str2 = str + util.base64_pad_url + optInt2;
            Meme meme = Meme.f385754h;
            MemeEncodeController.j(zPlanMemeHelper.j(), optInt2, 1.0f / optInt4, optInt5, meme.q(str2), meme.v(str2, zPlanRecordOperator.getParams().getRecordMode()), null, meme.l(str2), 32, null);
            c(optJSONObject, optInt4, optInt5, str2);
            return argument.ok();
        }

        private final void c(final JSONObject propertiesJson, int fps, int totalFrameCount, String recordKey) {
            if (propertiesJson != null) {
                propertiesJson.put("fps", fps);
                propertiesJson.put("totalFrameCount", totalFrameCount);
                final String c16 = Properties.INSTANCE.c(recordKey);
                f fVar = (f) mx4.a.f417748a.a(f.class);
                if (fVar != null) {
                    f.a.b(fVar, new Runnable() { // from class: com.tencent.zplan.record.ZPlanMemeHelper$RecordPlugin$saveProperties$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Properties.Companion companion = Properties.INSTANCE;
                            String str = c16;
                            String jSONObject = propertiesJson.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "propertiesJson.toString()");
                            companion.d(str, jSONObject);
                        }
                    }, 0L, 2, null);
                }
            }
        }

        @LuaEvent("L2N_AppearanceKeyDidChanged")
        @Nullable
        public final String handleAppearanceKeyChangeFromEngine(@NotNull LuaArgument argument) {
            Intrinsics.checkNotNullParameter(argument, "argument");
            String f440574c = argument.getF440574c();
            ZLog.f386189b.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleAppearanceKeyChangeFromEngine, params:" + f440574c);
            c cVar = (c) mx4.a.f417748a.a(c.class);
            if (cVar != null) {
                cVar.appearanceKeyChangeFromEngine(f440574c);
            }
            return argument.ok();
        }

        @LuaEvent(defaultAsync = false, value = "L2N_CommonRecordEnd")
        @Nullable
        public final String handleCommonRecordEnd(@NotNull LuaArgument argument) {
            Intrinsics.checkNotNullParameter(argument, "argument");
            return a(argument);
        }

        @LuaEvent(defaultAsync = false, value = "L2N_CommonRecordStart")
        @Nullable
        public final String handleCommonRecordStart(@NotNull LuaArgument argument) {
            Intrinsics.checkNotNullParameter(argument, "argument");
            return b(argument);
        }

        @LuaEvent(defaultAsync = false, value = "L2N_RecordQZoneAvatarEnd")
        @Nullable
        public final String handleQZoneAvatarRecordEnd(@NotNull LuaArgument argument) {
            Intrinsics.checkNotNullParameter(argument, "argument");
            return a(argument);
        }

        @LuaEvent(defaultAsync = false, value = "L2N_RecordQZoneAvatarStart")
        @Nullable
        public final String handleQZoneAvatarRecordStart(@NotNull LuaArgument argument) {
            Intrinsics.checkNotNullParameter(argument, "argument");
            return b(argument);
        }

        @LuaEvent(defaultAsync = false, value = "L2N_RecordActionEnd")
        @Nullable
        public final String handleRecordActionEnd(@NotNull LuaArgument argument) {
            MemeRecordParams params;
            Intrinsics.checkNotNullParameter(argument, "argument");
            String f440574c = argument.getF440574c();
            JSONObject jSONObject = new JSONObject(f440574c);
            int optInt = jSONObject.optInt("id");
            ZPlanMemeHelper zPlanMemeHelper = ZPlanMemeHelper.f385999s;
            if (!zPlanMemeHelper.i(optInt)) {
                ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleRecordActionEnd, taskId:" + optInt + " not equal to currentTaskId!!, params:" + f440574c);
                return argument.fail();
            }
            IRecordOperator recordOperator = zPlanMemeHelper.j().getRecordOperator();
            if (recordOperator != null && (params = recordOperator.getParams()) != null) {
                int id5 = params.getId();
                int optInt2 = jSONObject.optInt("errorCode");
                ZLog zLog = ZLog.f386189b;
                zLog.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleRecordActionEnd, portraitId:" + id5 + ", errorCode:" + optInt2 + ", params:" + f440574c);
                boolean z16 = false;
                int optInt3 = jSONObject.optInt("useRecordV2", 0);
                if (optInt2 != 0 && Meme.f385754h.k().getDetectErrorOnL2NEnd()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("MemeRecordActionStatus", ERROR_ENGINE_RECORD_FAIL.INSTANCE.toInt());
                    bundle.putInt("MemeRecordScriptErrorCode", optInt2);
                    bundle.putInt("MemeUseRecordV2", optInt3);
                    recordOperator.onRecordDone(recordOperator.getParams().getUniKey(), id5, bundle);
                    return argument.fail();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("statistic");
                if (optJSONObject != null) {
                    optJSONObject.put("useRecordV2", optInt3);
                } else {
                    optJSONObject = null;
                }
                String valueOf = String.valueOf(optJSONObject);
                MemeEncodeController j3 = zPlanMemeHelper.j();
                if (optInt2 == 0) {
                    z16 = true;
                }
                j3.h(id5, z16, valueOf);
                if (!ZPlanMemeHelper.e(zPlanMemeHelper)) {
                    zLog.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleRecordActionEnd postToEncodeThread.");
                    zPlanMemeHelper.t();
                }
                return argument.ok();
            }
            return argument.fail();
        }

        @LuaEvent(defaultAsync = false, value = "L2N_RecordActionStart")
        @Nullable
        public final String handleRecordActionStart(@NotNull LuaArgument argument) {
            String str;
            Intrinsics.checkNotNullParameter(argument, "argument");
            String f440574c = argument.getF440574c();
            JSONObject jSONObject = new JSONObject(f440574c);
            int optInt = jSONObject.optInt("id");
            ZPlanMemeHelper zPlanMemeHelper = ZPlanMemeHelper.f385999s;
            if (!zPlanMemeHelper.i(optInt)) {
                ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleRecordActionStart, taskId:" + optInt + " not equal to currentTaskId!! params:" + f440574c);
                return argument.fail();
            }
            IRecordOperator recordOperator = zPlanMemeHelper.j().getRecordOperator();
            if (recordOperator != null) {
                MemeRecordParams params = recordOperator.getParams();
                String uniKey = params.getUniKey();
                int id5 = params.getId();
                int optInt2 = jSONObject.optInt("errorCode");
                ZLog.f386189b.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "handleRecordActionStart, portraitId:" + id5 + ", errorCode:" + optInt2 + ", params:" + f440574c);
                int optInt3 = jSONObject.optInt("useRecordV2", 0);
                if (optInt2 != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("MemeRecordActionStatus", ERROR_ENGINE_RECORD_FAIL.INSTANCE.toInt());
                    bundle.putInt("MemeRecordScriptErrorCode", optInt2);
                    bundle.putInt("MemeUseRecordV2", optInt3);
                    recordOperator.onRecordDone(uniKey, id5, bundle);
                    return argument.fail();
                }
                int optInt4 = jSONObject.optInt("fps", 30);
                int optInt5 = jSONObject.optInt("realCount", 0);
                float f16 = 1.0f / optInt4;
                Meme meme = Meme.f385754h;
                String q16 = meme.q(uniKey);
                String v3 = meme.v(uniKey, params.getRecordMode());
                JSONObject optJSONObject = jSONObject.optJSONObject("statistic");
                if (optJSONObject != null) {
                    str = optJSONObject.toString();
                } else {
                    str = null;
                }
                zPlanMemeHelper.j().i(id5, f16, optInt5, q16, v3, str, meme.l(uniKey));
                c(jSONObject.optJSONObject(Constants.Service.PROPERTIES), optInt4, optInt5, uniKey);
                return argument.ok();
            }
            return argument.fail();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000fH\u0002J$\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J$\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010 \u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010!\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/zplan/record/ZPlanMemeHelper$ZPlanRecordOperator;", "Lcom/tencent/zplan/meme/encoder/IRecordOperator;", "params", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "callback", "Lcom/tencent/zplan/IZPlanRecordCallback;", "(Lcom/tencent/zplan/meme/model/MemeRecordParams;Lcom/tencent/zplan/IZPlanRecordCallback;)V", "batchCount", "", "getParams", "()Lcom/tencent/zplan/meme/model/MemeRecordParams;", "recordDoneCount", "remoteCallback", "Landroid/os/RemoteCallbackList;", "doRemoteCallback", "", "method", "Ljava/lang/reflect/Method;", "args", "", "", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "finish", "onEncodeEnd", "recordKey", "", "portraitId", "data", "Landroid/os/Bundle;", "onEncodeStart", "onRecordCoverDone", "onRecordDone", "onRecordFrameEnd", "onRecordFrameStart", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class ZPlanRecordOperator implements IRecordOperator {
        private final int batchCount;

        @NotNull
        private final MemeRecordParams params;
        private volatile int recordDoneCount;
        private final RemoteCallbackList<IZPlanRecordCallback> remoteCallback;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/record/ZPlanMemeHelper$ZPlanRecordOperator$a", "Landroid/os/RemoteCallbackList;", "Lcom/tencent/zplan/IZPlanRecordCallback;", "callback", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class a extends RemoteCallbackList<IZPlanRecordCallback> {
            a() {
            }

            @Override // android.os.RemoteCallbackList
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallbackDied(@Nullable IZPlanRecordCallback callback) {
                super.onCallbackDied(callback);
                ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "onCallbackDied:" + callback);
            }
        }

        public ZPlanRecordOperator(@NotNull MemeRecordParams params, @Nullable IZPlanRecordCallback iZPlanRecordCallback) {
            int i3;
            Intrinsics.checkNotNullParameter(params, "params");
            this.params = params;
            a aVar = new a();
            this.remoteCallback = aVar;
            aVar.register(iZPlanRecordCallback);
            int[] portraitIds = getParams().getPortraitIds();
            if (getParams().isBatch() && portraitIds != null) {
                i3 = portraitIds.length;
            } else {
                i3 = 1;
            }
            this.batchCount = i3;
            ZLog.f386189b.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "create new ZPlanRecordListener, batchCount:" + i3 + ", params:" + getParams() + ", remoteCallback:" + aVar);
        }

        private final void doRemoteCallback(Method method, Object... args) {
            synchronized (this.remoteCallback) {
                int beginBroadcast = this.remoteCallback.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        IZPlanRecordCallback broadcastItem = this.remoteCallback.getBroadcastItem(i3);
                        Intrinsics.checkNotNullExpressionValue(broadcastItem, "remoteCallback.getBroadcastItem(i)");
                        IZPlanRecordCallback iZPlanRecordCallback = broadcastItem;
                        if (iZPlanRecordCallback != null) {
                            method.invoke(iZPlanRecordCallback, Arrays.copyOf(args, args.length));
                        }
                    } catch (Exception e16) {
                        ZLog.f386189b.g("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "doRemoteCallback:" + method + " exception", e16);
                    }
                }
                this.remoteCallback.finishBroadcast();
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void finish() {
            this.remoteCallback.kill();
        }

        @Override // android.os.IInterface
        public /* bridge */ /* synthetic */ IBinder asBinder() {
            return (IBinder) asBinder();
        }

        @Override // com.tencent.zplan.meme.encoder.IRecordOperator
        @NotNull
        public MemeRecordParams getParams() {
            return this.params;
        }

        @Override // com.tencent.zplan.meme.IZPlanRecordCallback
        public void onEncodeEnd(@Nullable String recordKey, int portraitId, @Nullable Bundle data) {
            Method k3 = ZPlanMemeHelper.f385999s.k();
            if (k3 != null) {
                doRemoteCallback(k3, getParams().getUniKey(), Integer.valueOf(portraitId), data);
            }
        }

        @Override // com.tencent.zplan.meme.IZPlanRecordCallback
        public void onEncodeStart(@Nullable String recordKey, int portraitId) {
            Method l3 = ZPlanMemeHelper.f385999s.l();
            if (l3 != null) {
                doRemoteCallback(l3, recordKey, Integer.valueOf(portraitId));
            }
        }

        @Override // com.tencent.zplan.meme.IZPlanRecordCallback
        public void onRecordCoverDone(@Nullable String recordKey, int portraitId, @Nullable Bundle data) {
            Method m3 = ZPlanMemeHelper.f385999s.m();
            if (m3 != null) {
                doRemoteCallback(m3, recordKey, Integer.valueOf(portraitId), data);
            }
        }

        @Override // com.tencent.zplan.meme.IZPlanRecordCallback
        public void onRecordDone(@Nullable String recordKey, int portraitId, @Nullable Bundle data) {
            Method n3 = ZPlanMemeHelper.f385999s.n();
            if (n3 != null) {
                doRemoteCallback(n3, recordKey, Integer.valueOf(portraitId), data);
            }
            this.recordDoneCount++;
            if (this.recordDoneCount == this.batchCount) {
                ZLog.f386189b.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "all done, kill remoteCallback:" + this.remoteCallback);
                finish();
            }
        }

        @Override // com.tencent.zplan.meme.IZPlanRecordCallback
        public void onRecordFrameEnd(@Nullable String recordKey, int portraitId, @Nullable Bundle data) {
            Method o16 = ZPlanMemeHelper.f385999s.o();
            if (o16 != null) {
                doRemoteCallback(o16, recordKey, Integer.valueOf(portraitId), data);
            }
        }

        @Override // com.tencent.zplan.meme.IZPlanRecordCallback
        public void onRecordFrameStart(@Nullable String recordKey, int portraitId, @Nullable Bundle data) {
            Method p16 = ZPlanMemeHelper.f385999s.p();
            if (p16 != null) {
                doRemoteCallback(p16, recordKey, Integer.valueOf(portraitId), data);
            }
        }

        @Override // com.tencent.zplan.meme.encoder.IRecordOperator, android.os.IInterface
        @Nullable
        public Void asBinder() {
            return IRecordOperator.a.a(this);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        ZPlanMemeHelper zPlanMemeHelper = new ZPlanMemeHelper();
        f385999s = zPlanMemeHelper;
        STRING = String.class;
        Class<Integer> cls = Integer.TYPE;
        INT = cls;
        FRAME_DATA = ZPlanRecordFrameData.class;
        BUNDLE = Bundle.class;
        METHOD_ON_ENCODE_START = zPlanMemeHelper.r("onEncodeStart", String.class, cls);
        METHOD_ON_ENCODE_END = zPlanMemeHelper.r("onEncodeEnd", String.class, cls, Bundle.class);
        METHOD_ON_RECORD_FRAME_START = zPlanMemeHelper.r("onRecordFrameStart", String.class, cls, Bundle.class);
        METHOD_ON_RECORD_SINGLE_FRAME = zPlanMemeHelper.r("onRecordSingleFrame", String.class, cls, ZPlanRecordFrameData.class);
        METHOD_ON_RECORD_FRAME_END = zPlanMemeHelper.r("onRecordFrameEnd", String.class, cls, Bundle.class);
        METHOD_ON_RECORD_DONE = zPlanMemeHelper.r("onRecordDone", String.class, cls, Bundle.class);
        METHOD_ON_RECORD_COVER_DONE = zPlanMemeHelper.r("onRecordCoverDone", String.class, cls, Bundle.class);
        lastRecordFrameTaskId = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MemeEncodeController>() { // from class: com.tencent.zplan.record.ZPlanMemeHelper$encodeController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemeEncodeController invoke() {
                return new MemeEncodeController();
            }
        });
        encodeController = lazy;
        recordPlugin = new RecordPlugin();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMemeHelper$ueRecordFrameListener$2.a>() { // from class: com.tencent.zplan.record.ZPlanMemeHelper$ueRecordFrameListener$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }

            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/zplan/record/ZPlanMemeHelper$ueRecordFrameListener$2$a", "Lcom/epicgames/ue4/GameActivityThunk$RecordFrameListener;", "", "id", "errCode", "", "onRecordStart", "onRecordEnd", "", "renderOffscreenHandleLong", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "onFrameTick", "zplan_debug"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes27.dex */
            public static final class a implements GameActivityThunk.RecordFrameListener {
                a() {
                }

                @Override // com.epicgames.ue4.GameActivityThunk.RecordFrameListener
                public void onFrameTick(long renderOffscreenHandleLong, int taskId) {
                    ZPlanMemeHelper zPlanMemeHelper = ZPlanMemeHelper.f385999s;
                    IRecordOperator recordOperator = zPlanMemeHelper.j().getRecordOperator();
                    if (recordOperator == null) {
                        ZLog.f386189b.f("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "onFrameTick recordOperator null!");
                        return;
                    }
                    MemeRecordParams params = recordOperator.getParams();
                    if (params.isBatch()) {
                        taskId /= 100000;
                    }
                    if (zPlanMemeHelper.i(taskId)) {
                        ZPlanMemeHelper.curRenderOffscreenHandleLong = renderOffscreenHandleLong;
                        zPlanMemeHelper.t();
                        return;
                    }
                    NativeCalls.PopRecordFrameBuffer(renderOffscreenHandleLong);
                    ZLog.f386189b.o("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "onFrameTick, taskId:" + taskId + " not equal to currentTaskId:" + params.getTaskId());
                }

                @Override // com.epicgames.ue4.GameActivityThunk.RecordFrameListener
                public void onRecordEnd(int id5, int errCode) {
                }

                @Override // com.epicgames.ue4.GameActivityThunk.RecordFrameListener
                public void onRecordStart(int id5, int errCode) {
                }
            }
        });
        ueRecordFrameListener = lazy2;
        encodeRecordFrameRunnable = new Runnable() { // from class: com.tencent.zplan.record.ZPlanMemeHelper$encodeRecordFrameRunnable$1
            /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
            
                r0 = false;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                ZPlanMemeHelper zPlanMemeHelper2;
                long j3;
                boolean z16;
                int i3;
                int i16;
                int i17;
                int i18;
                IRecordOperator recordOperator = ZPlanMemeHelper.f385999s.j().getRecordOperator();
                if (recordOperator != null) {
                    while (true) {
                        zPlanMemeHelper2 = ZPlanMemeHelper.f385999s;
                        j3 = ZPlanMemeHelper.curRenderOffscreenHandleLong;
                        RecordFrameBuffer PeekRecordFrameBuffer = NativeCalls.PeekRecordFrameBuffer(j3);
                        if (PeekRecordFrameBuffer == null) {
                            ZLog.f386189b.c("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "record thread end. buffer is null");
                            break;
                        }
                        if (PeekRecordFrameBuffer.getPixels() == null) {
                            ZLog.f386189b.c("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "record thread end. Pixels is null");
                            break;
                        }
                        MemeRecordParams params = recordOperator.getParams();
                        int id5 = params.getId();
                        if (params.isBatch()) {
                            id5 = PeekRecordFrameBuffer.getPortraitId() - ((PeekRecordFrameBuffer.getPortraitId() / 100000) * 100000);
                        }
                        MemeEncodeController j16 = zPlanMemeHelper2.j();
                        byte[] pixels = PeekRecordFrameBuffer.getPixels();
                        Intrinsics.checkNotNullExpressionValue(pixels, "buffer.pixels");
                        j16.m(id5, pixels, PeekRecordFrameBuffer.getWidth(), PeekRecordFrameBuffer.getHeight());
                        i16 = ZPlanMemeHelper.lastRecordFrameTaskId;
                        if (i16 >= 0) {
                            i17 = ZPlanMemeHelper.lastRecordFrameTaskId;
                            if (i17 != id5) {
                                ZLog zLog = ZLog.f386189b;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("frameEnd lastId=");
                                i18 = ZPlanMemeHelper.lastRecordFrameTaskId;
                                sb5.append(i18);
                                sb5.append(" currentId=");
                                sb5.append(id5);
                                zLog.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", sb5.toString());
                                z16 = true;
                                break;
                            }
                        }
                        ZPlanMemeHelper.lastRecordFrameTaskId = id5;
                    }
                    MemeEncodeController j17 = zPlanMemeHelper2.j();
                    i3 = ZPlanMemeHelper.lastRecordFrameTaskId;
                    if (j17.l(i3)) {
                        ZPlanMemeHelper.lastRecordFrameTaskId = -1;
                    }
                    ZPlanMemeHelper.isThreadStart = false;
                    if (z16) {
                        zPlanMemeHelper2.t();
                        return;
                    }
                    return;
                }
                ZLog.f386189b.f("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "onFrameTick recordOperator null!");
            }
        };
    }

    ZPlanMemeHelper() {
    }

    public static final /* synthetic */ boolean e(ZPlanMemeHelper zPlanMemeHelper) {
        return isThreadStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(int taskId) {
        IRecordOperator recordOperator = j().getRecordOperator();
        if (recordOperator == null || recordOperator.getParams().getTaskId() != taskId) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MemeEncodeController j() {
        return (MemeEncodeController) encodeController.getValue();
    }

    private final Method r(String methodName, Class<? extends Object>... paramsTypes) {
        try {
            return IZPlanRecordCallback.class.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(paramsTypes, paramsTypes.length));
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "getRemoteMethod:" + methodName + ", paramsTypes:" + paramsTypes + " exception", e16);
            return null;
        }
    }

    @Nullable
    public final Method k() {
        return METHOD_ON_ENCODE_END;
    }

    @Nullable
    public final Method l() {
        return METHOD_ON_ENCODE_START;
    }

    @Nullable
    public final Method m() {
        return METHOD_ON_RECORD_COVER_DONE;
    }

    @Nullable
    public final Method n() {
        return METHOD_ON_RECORD_DONE;
    }

    @Nullable
    public final Method o() {
        return METHOD_ON_RECORD_FRAME_END;
    }

    @Nullable
    public final Method p() {
        return METHOD_ON_RECORD_FRAME_START;
    }

    @NotNull
    public final RecordPlugin q() {
        return recordPlugin;
    }

    @NotNull
    public final GameActivityThunk.RecordFrameListener s() {
        return (GameActivityThunk.RecordFrameListener) ueRecordFrameListener.getValue();
    }

    public final void t() {
        if (isThreadStart) {
            return;
        }
        isThreadStart = true;
        j().k(encodeRecordFrameRunnable);
    }

    public final void u(@NotNull MemeRecordParams params, @Nullable IZPlanRecordCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        j().o(new ZPlanRecordOperator(params, callback));
        String eventName = params.getEventName();
        JSONObject json = params.toJSON();
        ZLog.f386189b.k("[zplan][MemePlayer-SDK][ZPlanMemeHelper]", "start record, params:" + json + ", callback:" + callback);
        a.C10063a.d(ZPlanLuaBridge.INSTANCE, eventName, json, null, false, 12, null);
    }
}
