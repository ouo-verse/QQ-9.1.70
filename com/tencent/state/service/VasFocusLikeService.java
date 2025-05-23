package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.rapier.b;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.library.data.LibraryDataParserKt;
import com.tencent.state.library.data.LibraryLikeResult;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.CommonFootLabel;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import ks4.a;
import ks4.e;
import org.apache.httpcore.message.TokenParser;
import os4.c;
import os4.d;
import os4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005JH\u0010\u0010\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b2(\u0010\u0007\u001a$\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\nj\b\u0012\u0004\u0012\u00020\u000f`\u000b\u0012\u0004\u0012\u00020\b0\rJ*\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\b0\rJ\u001a\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u0012R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/service/VasFocusLikeService;", "", "", "uin", "roomId", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/library/data/LibraryLikeResult;", "callback", "", "doFriendLike", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uins", "Lkotlin/Function2;", "", "Lcom/tencent/state/template/data/CommonFootLabel;", "batchGetFootLabel", "getTargetFootLabel", "Lkotlin/Function1;", "Los4/b;", "getUnreadLikeNumber", "lastRedDotTs", "doLikeRedDotClick", "", "TAG", "Ljava/lang/String;", "SERVICE", "METHOD_LIKE", "Lcom/tencent/state/service/IVasLibraryLikeService;", "likeService", "Lcom/tencent/state/service/IVasLibraryLikeService;", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasFocusLikeService {
    private static final String METHOD_LIKE = "Like";
    private static final String SERVICE = "trpc.qmeta.library_like_svr.LibraryLikeSvr";
    private static final String TAG = "VasFocusLikeService";
    public static final VasFocusLikeService INSTANCE = new VasFocusLikeService();
    private static final IVasLibraryLikeService likeService = (IVasLibraryLikeService) Square.INSTANCE.getConfig().getRapier().b(IVasLibraryLikeService.class);

    VasFocusLikeService() {
    }

    public final void batchGetFootLabel(ArrayList<Long> uins, final Function2<? super Boolean, ? super ArrayList<CommonFootLabel>, Unit> callback) {
        long[] longArray;
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "batchGetFootLabel.");
        a aVar = new a();
        longArray = CollectionsKt___CollectionsKt.toLongArray(uins);
        aVar.f412952a = longArray;
        likeService.batchGetUniFootLabel(aVar).a(new b<ks4.b>() { // from class: com.tencent.state.service.VasFocusLikeService$batchGetFootLabel$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFocusLikeService", "batchGetFootLabel error " + errorCode + TokenParser.SP + errorMessage, null, 4, null);
                Function2.this.invoke(Boolean.FALSE, new ArrayList());
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ks4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("batchGetFootLabel success: size=");
                e[] eVarArr = response.f412953a;
                sb5.append(eVarArr != null ? Integer.valueOf(eVarArr.length) : null);
                squareLog.i("VasFocusLikeService", sb5.toString());
                ArrayList arrayList = new ArrayList();
                for (e label : response.f412953a) {
                    Intrinsics.checkNotNullExpressionValue(label, "label");
                    arrayList.add(new CommonFootLabel(label));
                }
                Function2.this.invoke(Boolean.TRUE, arrayList);
            }
        });
    }

    public final void doFriendLike(long uin, long roomId, final ResultCallback<LibraryLikeResult> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "doFriendLike");
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "doFriendLike network delegate is null");
            return;
        }
        os4.e eVar = new os4.e();
        eVar.f423983a = uin;
        eVar.f423984b = roomId;
        byte[] byteArray = MessageNano.toByteArray(eVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_LIKE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasFocusLikeService$doFriendLike$1
            /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
            @Override // com.tencent.state.api.INetworkDelegateCallBack
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onError(SquareErrorData data) {
                boolean z16;
                String prompt;
                boolean isBlank;
                Intrinsics.checkNotNullParameter(data, "data");
                Integer errCode = data.getErrCode();
                int intValue = errCode != null ? errCode.intValue() : -1;
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFocusLikeService", "doFriendLike error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
                String prompt2 = data.getPrompt();
                if (prompt2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(prompt2);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16) {
                            prompt = VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT;
                        } else {
                            prompt = data.getPrompt();
                        }
                        ResultCallback.this.onResultFailure(intValue, data.getErrMsg(), prompt);
                    }
                }
                z16 = true;
                if (!z16) {
                }
                ResultCallback.this.onResultFailure(intValue, data.getErrMsg(), prompt);
            }

            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onReceive(byte[] rspData) {
                SquareBaseKt.getSquareLog().i("VasFocusLikeService", "doFriendLike, success");
                try {
                    f response = f.c(rspData);
                    ResultCallback resultCallback = ResultCallback.this;
                    Intrinsics.checkNotNullExpressionValue(response, "response");
                    resultCallback.onResultSuccess(LibraryDataParserKt.parse(response));
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e("VasFocusLikeService", "doFriendLike parse err.", th5);
                    ResultCallback.this.onResultFailure(-2, "doFriendLike parse error", null);
                }
            }
        });
    }

    public final void doLikeRedDotClick(long lastRedDotTs, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "doLikeRedDotClick: ts=" + lastRedDotTs);
        IVasLibraryLikeService iVasLibraryLikeService = likeService;
        c cVar = new c();
        cVar.f423982a = lastRedDotTs;
        Unit unit = Unit.INSTANCE;
        iVasLibraryLikeService.doLikeRedDotClick(cVar).a(new b<d>() { // from class: com.tencent.state.service.VasFocusLikeService$doLikeRedDotClick$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFocusLikeService", "doLikeRedDotClick failed: errorCode=" + errorCode + ", errMsg=" + errorMessage, null, 4, null);
                Function1.this.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(d response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasFocusLikeService", "doLikeRedDotClick success.");
                Function1.this.invoke(Boolean.TRUE);
            }
        });
    }

    public final void getTargetFootLabel(long uin, final Function2<? super Boolean, ? super CommonFootLabel, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        aVar.f412952a = new long[]{uin};
        likeService.batchGetUniFootLabel(aVar).a(new b<ks4.b>() { // from class: com.tencent.state.service.VasFocusLikeService$getTargetFootLabel$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFocusLikeService", "batchGetFootLabel error " + errorCode + TokenParser.SP + errorMessage, null, 4, null);
                Function2.this.invoke(Boolean.FALSE, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ks4.b response) {
                Object firstOrNull;
                Intrinsics.checkNotNullParameter(response, "response");
                e[] footLabels = response.f412953a;
                Intrinsics.checkNotNullExpressionValue(footLabels, "footLabels");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(footLabels);
                e eVar = (e) firstOrNull;
                Function2.this.invoke(Boolean.TRUE, eVar != null ? new CommonFootLabel(eVar) : null);
            }
        });
    }

    public final void getUnreadLikeNumber(final Function1<? super os4.b, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getUnreadLikeNumber.");
        likeService.getUnreadLikeNumber(new os4.a()).a(new b<os4.b>() { // from class: com.tencent.state.service.VasFocusLikeService$getUnreadLikeNumber$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasFocusLikeService", "getUnreadLikeNumber failed: errorCode=" + errorCode + ", errMsg=" + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(os4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasFocusLikeService", "getUnreadLikeNumber success: nums=" + response.f423980a + ", ts=" + response.f423981b);
                Function1.this.invoke(response);
            }
        });
    }
}
