package com.tencent.state.square.like;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import qt4.a;
import qt4.b;
import qt4.c;
import qt4.d;
import qt4.e;
import qt4.f;
import qt4.g;
import qt4.h;
import qt4.i;
import qt4.j;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bJD\u0010\u000f\u001a\u00020\u00042<\b\u0002\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bJ4\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016J-\u0010\u0018\u001a\u00020\u00042%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/like/LikeService;", "", "()V", "checkLike", "", "uin", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/state/square/like/CheckLikedResult;", "Lkotlin/ParameterName;", "name", "likedResult", "", "errorCode", "getLikeList", "Lcom/tencent/state/square/like/LikeListInfo;", "result", "likeStatus", "type", "isCancel", "", "Lkotlin/Function1;", "Lcom/tencent/state/square/like/LikeResult;", "readLikeList", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LikeService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_like_svr.StatusLike";
    private static final String METHOD_CHECK_LIKE = "CheckLike";
    private static final String METHOD_GET_LIKE_LIST = "GetLikeList";
    private static final String METHOD_LIKE = "LikeStatus";
    private static final String METHOD_READ_LIKE_LIST = "ReadLikeList";
    private static final String TAG = "LikeService";

    public final void checkLike(long uin, final Function2<? super CheckLikedResult, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        a aVar = new a();
        aVar.f429523a = 1;
        aVar.f429524b = new long[]{uin};
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_CHECK_LIKE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.like.LikeService$checkLike$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "LikeService", "checkLike failed errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function2 function2 = Function2.this;
                    if (function2 != null) {
                        CheckLikedResult checkLikedResult = new CheckLikedResult();
                        Integer errCode = data.getErrCode();
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onReceive(byte[] rspData) {
                    int i3;
                    j[] jVarArr;
                    int i16;
                    Object orNull;
                    Object orNull2;
                    e[] eVarArr;
                    Object orNull3;
                    try {
                        b c16 = b.c(rspData);
                        Function2 function2 = Function2.this;
                        if (function2 != null) {
                            CheckLikedResult checkLikedResult = new CheckLikedResult();
                            j[] jVarArr2 = c16.f429526b;
                            if (jVarArr2 != null) {
                                orNull2 = ArraysKt___ArraysKt.getOrNull(jVarArr2, 0);
                                j jVar = (j) orNull2;
                                if (jVar != null && (eVarArr = jVar.f429561b) != null) {
                                    orNull3 = ArraysKt___ArraysKt.getOrNull(eVarArr, 0);
                                    e eVar = (e) orNull3;
                                    if (eVar != null) {
                                        i3 = eVar.f429539a;
                                        checkLikedResult.setLikeType(i3);
                                        jVarArr = c16.f429526b;
                                        if (jVarArr != null) {
                                            orNull = ArraysKt___ArraysKt.getOrNull(jVarArr, 0);
                                            j jVar2 = (j) orNull;
                                            if (jVar2 != null) {
                                                i16 = jVar2.f429562c;
                                                checkLikedResult.setTotalLikedCount(i16);
                                                if (checkLikedResult.getTotalLikedCount() == 0) {
                                                    checkLikedResult.setTotalLikedCount(checkLikedResult.getLikeType() == -1 ? 0 : 1);
                                                }
                                                checkLikedResult.setLocalLikedCount(checkLikedResult.getTotalLikedCount());
                                                Unit unit = Unit.INSTANCE;
                                            }
                                        }
                                        i16 = 0;
                                        checkLikedResult.setTotalLikedCount(i16);
                                        if (checkLikedResult.getTotalLikedCount() == 0) {
                                        }
                                        checkLikedResult.setLocalLikedCount(checkLikedResult.getTotalLikedCount());
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                }
                            }
                            i3 = -1;
                            checkLikedResult.setLikeType(i3);
                            jVarArr = c16.f429526b;
                            if (jVarArr != null) {
                            }
                            i16 = 0;
                            checkLikedResult.setTotalLikedCount(i16);
                            if (checkLikedResult.getTotalLikedCount() == 0) {
                            }
                            checkLikedResult.setLocalLikedCount(checkLikedResult.getTotalLikedCount());
                            Unit unit22 = Unit.INSTANCE;
                        }
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("LikeService", "checkLike failed", th5);
                        Function2 function22 = Function2.this;
                        if (function22 != null) {
                        }
                    }
                }
            });
        }
    }

    public final void getLikeList(final Function2<? super LikeListInfo, ? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        c cVar = new c();
        cVar.f429530b = 1;
        cVar.f429531c = 1;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_LIKE_LIST, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.like.LikeService$getLikeList$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "LikeService", "getLikeList failed errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function2 function2 = Function2.this;
                    if (function2 != null) {
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        d c16 = d.c(rspData);
                        h[] hVarArr = c16.f429533b;
                        if (hVarArr != null) {
                            for (h it : hVarArr) {
                                LikeData likeData = new LikeData();
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                likeData.parse(it);
                                Unit unit = Unit.INSTANCE;
                                arrayList.add(likeData);
                            }
                        }
                        SquareBaseKt.getSquareLog().i("LikeService", "getLikeList success unReadNum " + c16.f429532a);
                        Function2 function2 = Function2.this;
                        if (function2 != null) {
                        }
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("LikeService", "getLikeList parse error", th5);
                        Function2 function22 = Function2.this;
                        if (function22 != null) {
                        }
                    }
                }
            });
        }
    }

    public final void likeStatus(final long uin, int type, boolean isCancel, final Function1<? super LikeResult, Unit> callback) {
        Map<String, String> emptyMap;
        SquareBaseKt.getSquareLog().i(TAG, "likeStatus: uin=" + uin + ", type=" + type + ", isCancel=" + isCancel);
        f fVar = new f();
        fVar.f429546f = SquareFragment.INSTANCE.getChatLandAppId();
        fVar.f429541a = 1;
        fVar.f429545e = 1;
        fVar.f429542b = uin;
        fVar.f429544d = isCancel ? 1L : 0L;
        e eVar = new e();
        eVar.f429539a = type;
        fVar.f429543c = new e[]{eVar};
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(fVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_LIKE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.like.LikeService$likeStatus$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "LikeService", "likeStatus failed errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        g c16 = g.c(rspData);
                        SquareBaseKt.getSquareLog().i("LikeService", "likeStatus success: uin=" + uin + ", gotFlower=" + c16.f429549c);
                        Function1 function1 = Function1.this;
                        if (function1 != null) {
                        }
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("LikeService", "likeStatus failed", th5);
                        Function1 function12 = Function1.this;
                        if (function12 != null) {
                        }
                    }
                }
            });
        }
    }

    public final void readLikeList(final Function1<? super Integer, Unit> callback) {
        Map<String, String> emptyMap;
        i iVar = new i();
        iVar.f429558a = System.currentTimeMillis() / 1000;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(iVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_READ_LIKE_LIST, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.square.like.LikeService$readLikeList$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "LikeService", "readLikeList failed errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                        Integer errCode = data.getErrCode();
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getLikeList$default(LikeService likeService, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function2 = null;
        }
        likeService.getLikeList(function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void readLikeList$default(LikeService likeService, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        likeService.readLikeList(function1);
    }
}
