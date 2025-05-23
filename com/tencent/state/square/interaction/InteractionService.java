package com.tencent.state.square.interaction;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.interaction.InteractionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import pt4.a;
import pt4.b;
import pt4.c;
import pt4.d;
import pt4.e;
import pt4.f;
import pt4.g;
import pt4.h;
import pt4.i;
import pt4.j;
import pt4.k;
import pt4.l;
import pt4.m;
import pt4.n;
import pt4.q;
import pt4.s;
import pt4.t;
import pt4.u;
import pt4.v;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bJg\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062O\u0010\u0007\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJq\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062Q\b\u0002\u0010\u0007\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ_\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00122O\u0010\u0007\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJi\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062Q\b\u0002\u0010\u0007\u001aK\u0012\u0015\u0012\u0013\u0018\u00010#\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJJ\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062:\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010&\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010%J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)JV\u0010*\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010+\u001a\u00020#26\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00040%JH\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u001228\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010%\u00a8\u00060"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionService;", "", "()V", "clearUnread", "", "unreadScene", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "errorCode", "getAllInteractiveOptions", "limit", "offset", "Lkotlin/Function3;", "Lcom/tencent/state/square/interaction/InteractionSettingOptionList;", "data", "", "errorMsg", "getInteractionOptions", "interactedUin", "", "targetStatus", "targetRichStatus", "Lcom/tencent/state/square/interaction/InteractionOptionsInfo;", "info", "msg", "getInteractionRecord", "cursorId", "Lcom/tencent/state/square/interaction/InteractionRecordList;", "result", "getInteractionSettings", "status", "richStatus", "Lcom/tencent/state/square/interaction/InteractionSettings;", "getInteractionUnread", "Lkotlin/Function2;", "Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", "interact", "reqData", "Lcom/tencent/state/square/interaction/InteractionManager$InteractData;", "saveInteractionSettings", QCircleDaTongConstant.ElementParamValue.SETTINGS, "textCheck", "text", "code", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionService {
    public static final int CODE_REVIEW_FAILED = -10032;
    public static final int CODE_SUCCESS = 0;
    private static final String ERROR_MSG_TIMEOUT = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
    private static final String GET_INTERACTION_GET_ALL_INTERACTIVE_OPTIONS = "GetAllInteractiveOptions";
    private static final String GET_INTERACTION_OPTIONS_METHOD = "GetInteractiveOptions";
    private static final String GET_INTERACTION_RECORD_CLEAR_UNREAD_METHOD = "ClearUnread";
    private static final String GET_INTERACTION_RECORD_METHOD = "GetInteractions";
    private static final String GET_INTERACTION_RECORD_UNREAD_METHOD = "GetUnread";
    private static final String GET_INTERACTION_SETTING_ME_TEXT_CHECK = "TextCheck";
    private static final String GET_INTERACTIVE_SETTINGS_METHOD = "GetInteractiveSetting";
    private static final String INTERACT_METHOD = "InteractWithStatus";
    private static final String SERVICE = "trpc.qmeta.status_interact_svr.StatusInteractSvr";
    private static final String SET_INTERACTIVE_SETTINGS_METHOD = "SetInteractiveOptions";
    private static final String TAG = "InteractionService";

    public final void clearUnread(int unreadScene, final Function1<? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        a aVar = new a();
        aVar.f427162a = unreadScene;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, GET_INTERACTION_RECORD_CLEAR_UNREAD_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$clearUnread$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "clearUnread " + data, null, 4, null);
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        b.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "clearUnread failed " + th5.getMessage(), null, 4, null);
                    }
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                    }
                }
            });
        }
    }

    public final void getAllInteractiveOptions(int limit, int offset, final Function3<? super InteractionSettingOptionList, ? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        c cVar = new c();
        cVar.f427163a = limit;
        cVar.f427164b = offset;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, GET_INTERACTION_GET_ALL_INTERACTIVE_OPTIONS, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$getAllInteractiveOptions$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareBaseKt.getSquareLog().i("InteractionService", "getAllInteractiveOptions " + data);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                        Integer errCode = data.getErrCode();
                        Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : 0);
                        String prompt = data.getPrompt();
                        if (prompt == null) {
                            prompt = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    d dVar;
                    try {
                        dVar = d.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getAllInteractiveOptions failed " + th5.getMessage(), null, 4, null);
                        dVar = null;
                    }
                    SquareBaseKt.getSquareLog().i("InteractionService", "getAllInteractiveOptions success " + dVar);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                    }
                }
            });
        }
    }

    public final void getInteractionOptions(long interactedUin, int targetStatus, int targetRichStatus, final Function3<? super InteractionOptionsInfo, ? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        g gVar = new g();
        gVar.f427169a = interactedUin;
        gVar.f427170b = targetStatus;
        gVar.f427171c = targetRichStatus;
        SquareBaseKt.getSquareLog().i(TAG, "getInteractionOptions req " + gVar);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(gVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, GET_INTERACTION_OPTIONS_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$getInteractionOptions$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionOptions " + data, null, 4, null);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                        Integer errCode = data.getErrCode();
                        Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : 0);
                        String prompt = data.getPrompt();
                        if (prompt == null) {
                            prompt = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    h hVar;
                    List emptyList;
                    q[] qVarArr;
                    try {
                        hVar = h.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionOptions failed " + th5.getMessage(), null, 4, null);
                        hVar = null;
                    }
                    SquareBaseKt.getSquareLog().i("InteractionService", "getInteractionOptions success " + hVar);
                    InteractionSelectOrder parsePB = InteractionSelectOrder.INSTANCE.parsePB(hVar != null ? hVar.f427173b : 0);
                    if (hVar == null || (qVarArr = hVar.f427172a) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList(qVarArr.length);
                        for (q it : qVarArr) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            arrayList.add(new InteractionOption(it));
                        }
                        emptyList = new ArrayList();
                        for (Object obj : arrayList) {
                            if (((InteractionOption) obj).getOptionId() != 0) {
                                emptyList.add(obj);
                            }
                        }
                    }
                    InteractionOptionsInfo interactionOptionsInfo = new InteractionOptionsInfo(parsePB, emptyList);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                    }
                }
            });
        }
    }

    public final void getInteractionRecord(String cursorId, final Function3<? super InteractionRecordList, ? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(cursorId, "cursorId");
        e eVar = new e();
        eVar.f427166a = cursorId;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(eVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, GET_INTERACTION_RECORD_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$getInteractionRecord$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionRecord " + data, null, 4, null);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                        Integer errCode = data.getErrCode();
                        Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : 0);
                        String prompt = data.getPrompt();
                        if (prompt == null) {
                            prompt = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    f fVar;
                    try {
                        fVar = f.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionRecord failed " + th5.getMessage(), null, 4, null);
                        fVar = null;
                    }
                    SquareBaseKt.getSquareLog().i("InteractionService", "getInteractionRecord success " + fVar);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                    }
                }
            });
        }
    }

    public final void getInteractionSettings(int status, int richStatus, final Function3<? super InteractionSettings, ? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        i iVar = new i();
        iVar.f427174a = status;
        iVar.f427175b = richStatus;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(iVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, GET_INTERACTIVE_SETTINGS_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$getInteractionSettings$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionSettings " + data, null, 4, null);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                        Integer errCode = data.getErrCode();
                        Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : 0);
                        String prompt = data.getPrompt();
                        if (prompt == null) {
                            prompt = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    j jVar;
                    try {
                        jVar = j.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionSettings failed " + th5.getMessage(), null, 4, null);
                        jVar = null;
                    }
                    SquareBaseKt.getSquareLog().i("InteractionService", "getInteractionSettings success " + jVar);
                    Function3 function3 = Function3.this;
                    if (function3 != null) {
                    }
                }
            });
        }
    }

    public final void getInteractionUnread(int unreadScene, final Function2<? super InteractionUnreadInfo, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        k kVar = new k();
        kVar.f427178a = unreadScene;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(kVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, GET_INTERACTION_RECORD_UNREAD_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$getInteractionUnread$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionUnread " + data, null, 4, null);
                    Function2 function2 = Function2.this;
                    if (function2 != null) {
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    l lVar;
                    try {
                        lVar = l.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "getInteractionUnread failed " + th5.getMessage(), null, 4, null);
                        lVar = null;
                    }
                    SquareBaseKt.getSquareLog().i("InteractionService", "getInteractionUnread success " + lVar);
                    Function2 function2 = Function2.this;
                    if (function2 != null) {
                    }
                }
            });
        }
    }

    public final void interact(final InteractionManager.InteractData reqData) {
        int appId;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        m mVar = new m();
        mVar.f427182a = reqData.getInteractedUin();
        mVar.f427183b = reqData.getTargetStatus();
        mVar.f427184c = reqData.getTargetRichStatus();
        Long optionId = reqData.getOptionId();
        mVar.f427185d = optionId != null ? optionId.longValue() : 0L;
        InteractionOption optionTmp = reqData.getOptionTmp();
        mVar.f427186e = optionTmp != null ? optionTmp.toPB() : null;
        mVar.f427187f = reqData.getInteractedUinList();
        mVar.f427188g = reqData.getInteractionType();
        if (reqData.getAppId() == 0) {
            appId = SquareFragment.INSTANCE.getChatLandAppId();
        } else {
            appId = reqData.getAppId();
        }
        mVar.f427189h = appId;
        SquareBaseKt.getSquareLog().i(TAG, "interact: uin=" + reqData.getInteractedUin());
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(mVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, INTERACT_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$interact$2
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "interact " + data, null, 4, null);
                    Function3<InteractionResult, Integer, String, Unit> callback = InteractionManager.InteractData.this.getCallback();
                    if (callback != null) {
                        Integer errCode = data.getErrCode();
                        Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : 0);
                        String prompt = data.getPrompt();
                        if (prompt == null) {
                            prompt = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                        callback.invoke(null, valueOf, prompt);
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    n nVar;
                    try {
                        nVar = n.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "interact failed " + th5.getMessage(), null, 4, null);
                        nVar = null;
                    }
                    InteractionResult interactionResult = nVar != null ? new InteractionResult(nVar) : null;
                    SquareBaseKt.getSquareLog().i("InteractionService", "interact success: " + interactionResult);
                    Function3<InteractionResult, Integer, String, Unit> callback = InteractionManager.InteractData.this.getCallback();
                    if (callback != null) {
                        callback.invoke(interactionResult, 0, "");
                    }
                }
            });
        }
    }

    public final void saveInteractionSettings(int status, int richStatus, InteractionSettings settings, final Function2<? super Integer, ? super String, Unit> callback) {
        int collectionSizeOrDefault;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(callback, "callback");
        s sVar = new s();
        sVar.f427240c = status;
        sVar.f427241d = richStatus;
        sVar.f427239b = settings.getSelectOrder().toPB();
        List<InteractionSettingOption> interactionOptions = settings.getInteractionOptions();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(interactionOptions, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = interactionOptions.iterator();
        while (it.hasNext()) {
            arrayList.add(((InteractionSettingOption) it.next()).toPBUserCustomOption());
        }
        Object[] array = arrayList.toArray(new v[0]);
        if (array != null) {
            sVar.f427238a = (v[]) array;
            INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
            if (networkDelegate != null) {
                byte[] byteArray = MessageNano.toByteArray(sVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                networkDelegate.sendVasProxyRequest(SERVICE, SET_INTERACTIVE_SETTINGS_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$saveInteractionSettings$2
                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onError(SquareErrorData data) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "saveInteractionSettings " + data, null, 4, null);
                        Function2 function2 = Function2.this;
                        Integer errCode = data.getErrCode();
                        Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : 0);
                        String prompt = data.getPrompt();
                        if (prompt == null) {
                            prompt = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                        function2.invoke(valueOf, prompt);
                    }

                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onReceive(byte[] rspData) {
                        j jVar;
                        try {
                            jVar = j.c(rspData);
                        } catch (Throwable th5) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "saveInteractionSettings failed " + th5.getMessage(), null, 4, null);
                            jVar = null;
                        }
                        SquareBaseKt.getSquareLog().i("InteractionService", "saveInteractionSettings success " + jVar);
                        Function2.this.invoke(0, "");
                    }
                });
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void textCheck(String text, final Function2<? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(text, "text");
        t tVar = new t();
        tVar.f427242a = text;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(tVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, GET_INTERACTION_SETTING_ME_TEXT_CHECK, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.interaction.InteractionService$textCheck$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "textCheck error " + data, null, 4, null);
                    String prompt = data.getPrompt();
                    String str = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                    if (prompt != null) {
                        if (TextUtils.isEmpty(prompt)) {
                            prompt = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                        str = prompt;
                    }
                    Function2 function2 = Function2.this;
                    if (function2 != null) {
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    u uVar;
                    try {
                        uVar = u.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "InteractionService", "textCheck failed " + th5.getMessage(), null, 4, null);
                        uVar = null;
                    }
                    SquareBaseKt.getSquareLog().i("InteractionService", "textCheck success " + uVar);
                    Function2 function2 = Function2.this;
                    if (function2 != null) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getInteractionSettings$default(InteractionService interactionService, int i3, int i16, Function3 function3, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            function3 = null;
        }
        interactionService.getInteractionSettings(i3, i16, function3);
    }

    public static /* synthetic */ void getInteractionOptions$default(InteractionService interactionService, long j3, int i3, int i16, Function3 function3, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            function3 = null;
        }
        interactionService.getInteractionOptions(j3, i3, i16, function3);
    }
}
