package com.tencent.state.square.friendsetting;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.mayknow.MayKnowService;
import ht4.d;
import is4.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ls4.b;
import ls4.c;
import ls4.e;
import ls4.f;
import ls4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&JN\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006JR\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006JR\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006JT\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\n2:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006JJ\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006JK\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00042%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u001bJ\u001c\u0010\u001e\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u001bJ6\u0010$\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/friendsetting/SettingService;", "", "", "troopUin", "", "isBaned", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "", "errorCode", "", "callback", "setPrivacyMode", "Lis4/b;", "data", "isTroop", "setFixed", "uin", "cancelFixed", "type", "hide", "cancelHide", "pageSize", "lastId", "onlyUin", "Lkotlin/Function1;", "Lls4/c;", "getHideList", "hideMayKnowEntrance", "", "event", "actionType", "reason", "source", "report", "<init>", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SettingService {
    private static final String CMD_SERVICE = "trpc.qmeta.fixed_menu_svr.FixedMenuSvr";
    private static final String CMD_SERVICE_HIDE = "trpc.qmeta.hide_menu_svr.HideMenu";
    private static final String CMD_SERVICE_PRIVACY = "trpc.qmeta.square_group_svr.SquareGroupSvr";
    private static final String METHOD_CANCEL_FIXED = "CancelFixed";
    private static final String METHOD_CANCEL_HIDE = "UnHide";
    private static final String METHOD_FIXED = "SetFixed";
    private static final String METHOD_GET_HIDE_LIST = "GetHideUsers";
    private static final String METHOD_HIDE = "Hide";
    private static final String METHOD_PRIVACY = "SetPrivacyMode";
    private static final String TAG = "FixedService";

    public final void cancelFixed(final long uin, boolean isTroop, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        a aVar = new a();
        aVar.f408675a = uin;
        aVar.f408676b = isTroop ? 1 : 0;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_CANCEL_FIXED, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.friendsetting.SettingService$cancelFixed$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FixedService", "cancelFixed failed " + uin + " errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function2 function2 = callback;
                    if (function2 != null) {
                        Boolean bool = Boolean.FALSE;
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().i("FixedService", "cancelFixed success " + uin);
                    Function2 function2 = callback;
                    if (function2 != null) {
                    }
                }
            });
        }
    }

    public final void cancelHide(final long uin, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        g gVar = new g();
        gVar.f415528a = uin;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(gVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE_HIDE, METHOD_CANCEL_HIDE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.friendsetting.SettingService$cancelHide$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FixedService", "cancelHide failed " + uin + " errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function2 function2 = callback;
                    if (function2 != null) {
                        Boolean bool = Boolean.FALSE;
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().i("FixedService", "cancelHide success " + uin);
                    Function2 function2 = callback;
                    if (function2 != null) {
                    }
                }
            });
        }
    }

    public final void getHideList(int pageSize, long lastId, boolean onlyUin, final Function1<? super c, Unit> callback) {
        Map<String, String> emptyMap;
        b bVar = new b();
        bVar.f415515a = pageSize;
        bVar.f415516b = lastId;
        bVar.f415517c = onlyUin;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(bVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE_HIDE, METHOD_GET_HIDE_LIST, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.friendsetting.SettingService$getHideList$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FixedService", "getHideList failed errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    c cVar;
                    f[] fVarArr;
                    Integer num = null;
                    try {
                        cVar = c.c(rspData);
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("FixedService", "getHideList rspData parse error", th5);
                        cVar = null;
                    }
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getHideList success size ");
                    if (cVar != null && (fVarArr = cVar.f415518a) != null) {
                        num = Integer.valueOf(fVarArr.length);
                    }
                    sb5.append(num);
                    squareLog.i("FixedService", sb5.toString());
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                    }
                }
            });
        }
    }

    public final void hide(final long uin, int type, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        e eVar = new e();
        eVar.f415521a = uin;
        eVar.f415522b = type;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(eVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE_HIDE, METHOD_HIDE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.friendsetting.SettingService$hide$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FixedService", "hide failed " + uin + " errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function2 function2 = callback;
                    if (function2 != null) {
                        Boolean bool = Boolean.FALSE;
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().i("FixedService", "hide success " + uin);
                    Function2 function2 = callback;
                    if (function2 != null) {
                    }
                }
            });
        }
    }

    public final void hideMayKnowEntrance(final Function1<? super Boolean, Unit> callback) {
        MayKnowService.INSTANCE.hideMayKnowEntrance(new ResultCallback<Object>() { // from class: com.tencent.state.square.friendsetting.SettingService$hideMayKnowEntrance$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(Object result) {
                Function1 function1 = Function1.this;
                if (function1 != null) {
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                Function1 function1 = Function1.this;
                if (function1 != null) {
                }
            }
        });
    }

    public final void report(String event, String uin, int actionType, int result, int reason, String source) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(source, "source");
        IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_other_user_qq", uin);
        linkedHashMap.put(SquareReportConst.Key.KEY_SET_TOP_TYPE, Integer.valueOf(actionType));
        linkedHashMap.put("zplan_action_result", Integer.valueOf(result));
        linkedHashMap.put("zplan_action_fail_reason", Integer.valueOf(reason));
        linkedHashMap.put("zplan_set_top_entrance", source);
        Unit unit = Unit.INSTANCE;
        reporter.reportEvent(event, linkedHashMap);
    }

    public final void setFixed(final is4.b data, boolean isTroop, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(data, "data");
        is4.c cVar = new is4.c();
        cVar.f408680a = data;
        cVar.f408681b = isTroop ? 1 : 0;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_FIXED, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.friendsetting.SettingService$setFixed$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FixedService", "setFixed failed " + is4.b.this.f408677a + " errCode: " + error.getErrCode() + ", errMsg: " + error.getErrMsg(), null, 4, null);
                    Function2 function2 = callback;
                    if (function2 != null) {
                        Boolean bool = Boolean.FALSE;
                        Integer errCode = error.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().i("FixedService", "setFixed success " + is4.b.this.f408677a);
                    Function2 function2 = callback;
                    if (function2 != null) {
                    }
                }
            });
        }
    }

    public final void setPrivacyMode(long troopUin, boolean isBaned, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        d dVar = new d();
        dVar.f406270a = troopUin;
        dVar.f406271b = isBaned ? 1 : 0;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(dVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE_PRIVACY, METHOD_PRIVACY, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.friendsetting.SettingService$setPrivacyMode$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FixedService", "SetPrivacyModeReq failed  errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function2 function2 = Function2.this;
                    Boolean bool = Boolean.FALSE;
                    Integer errCode = data.getErrCode();
                    function2.invoke(bool, Integer.valueOf(errCode != null ? errCode.intValue() : -1));
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    Function2.this.invoke(Boolean.TRUE, 0);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void cancelFixed$default(SettingService settingService, long j3, boolean z16, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function2 = null;
        }
        settingService.cancelFixed(j3, z16, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void cancelHide$default(SettingService settingService, long j3, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        settingService.cancelHide(j3, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setFixed$default(SettingService settingService, is4.b bVar, boolean z16, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function2 = null;
        }
        settingService.setFixed(bVar, z16, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hide$default(SettingService settingService, long j3, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            function2 = null;
        }
        settingService.hide(j3, i3, function2);
    }

    public static /* synthetic */ void getHideList$default(SettingService settingService, int i3, long j3, boolean z16, Function1 function1, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 10;
        }
        int i17 = i3;
        if ((i16 & 2) != 0) {
            j3 = 0;
        }
        long j16 = j3;
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        settingService.getHideList(i17, j16, z16, function1);
    }
}
