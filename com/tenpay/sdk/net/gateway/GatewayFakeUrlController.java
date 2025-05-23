package com.tenpay.sdk.net.gateway;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ErrDetail;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.util.QQToastUtil;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlHandler;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.b;
import pl2.e;
import pl2.g;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J4\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayFakeUrlController;", "", "", "outerMsg", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ErrDetail;", "errorDetail", "", "fixErrorDetailMsg", "", "retCode", "Lpl2/g;", "bizAbility", "Lcom/tenpay/sdk/net/gateway/GatewayCallbackInterceptor;", "callbackInterceptor", "Lcom/tenpay/sdk/net/gateway/GatewayFakeUrlController$EnumHandleResult;", "processError", "TAG", "Ljava/lang/String;", "DEFAULT_ERROR_TIPS", "getDEFAULT_ERROR_TIPS", "()Ljava/lang/String;", "CODE_PARAM_ERROR", "I", "CODE_DECRYPT_ERROR", "CODE_MERGE_RSP_ERROR", "<init>", "()V", "EnumHandleResult", "GatewayFakeUrlHandler", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class GatewayFakeUrlController {
    public static final int CODE_DECRYPT_ERROR = -1002;
    public static final int CODE_MERGE_RSP_ERROR = -1003;
    public static final int CODE_PARAM_ERROR = -1001;

    @NotNull
    public static final String TAG = "GatewayErrorController";

    @NotNull
    public static final GatewayFakeUrlController INSTANCE = new GatewayFakeUrlController();

    @NotNull
    private static final String DEFAULT_ERROR_TIPS = p.INSTANCE.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayFakeUrlController$EnumHandleResult;", "", "(Ljava/lang/String;I)V", "NO_HANDLE", "HANDLE", "HANDLE_NEED_INTERCEPTED", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EnumHandleResult {
        NO_HANDLE,
        HANDLE,
        HANDLE_NEED_INTERCEPTED
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\"\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayFakeUrlController$GatewayFakeUrlHandler;", "Lcom/tenpay/sdk/fakeurl/QWalletFakeUrlHandler;", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "fakeInfo", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "onDispatcherCallback", "", "retCode", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ErrDetail;", "errorDetail", "Lcom/tenpay/sdk/net/gateway/GatewayFakeUrlController$EnumHandleResult;", "handle", "btnUri", "", "retMsg", "onHandlerFinish", "targetUri", "", "dispatch", "Lpl2/g;", "bizAbility", "Lpl2/g;", "Lcom/tenpay/sdk/net/gateway/GatewayCallbackInterceptor;", "callbackInterceptor", "Lcom/tenpay/sdk/net/gateway/GatewayCallbackInterceptor;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lpl2/g;Lcom/tenpay/sdk/net/gateway/GatewayCallbackInterceptor;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class GatewayFakeUrlHandler extends QWalletFakeUrlHandler {

        @Nullable
        private final g bizAbility;

        @NotNull
        private final GatewayCallbackInterceptor callbackInterceptor;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tenpay.sdk.net.gateway.GatewayFakeUrlController$GatewayFakeUrlHandler$1, reason: invalid class name */
        /* loaded from: classes27.dex */
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<FakeInfo, Uri, Unit> {
            AnonymousClass1(Object obj) {
                super(2, obj, GatewayFakeUrlHandler.class, "onDispatcherCallback", "onDispatcherCallback(Lcom/tenpay/sdk/fakeurl/FakeInfo;Landroid/net/Uri;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(FakeInfo fakeInfo, Uri uri) {
                invoke2(fakeInfo, uri);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable FakeInfo fakeInfo, @Nullable Uri uri) {
                ((GatewayFakeUrlHandler) this.receiver).onDispatcherCallback(fakeInfo, uri);
            }
        }

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FakeInfo.EnumErrorShowFlag.values().length];
                try {
                    iArr[FakeInfo.EnumErrorShowFlag.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FakeInfo.EnumErrorShowFlag.TOAST.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FakeInfo.EnumErrorShowFlag.ALTER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GatewayFakeUrlHandler(@NotNull Context context, @Nullable g gVar, @NotNull GatewayCallbackInterceptor callbackInterceptor) {
            super(context, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callbackInterceptor, "callbackInterceptor");
            this.bizAbility = gVar;
            this.callbackInterceptor = callbackInterceptor;
            setDispatcherCallback(new AnonymousClass1(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void onDispatcherCallback(FakeInfo fakeInfo, Uri uri) {
            String str;
            Map emptyMap;
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, FakeUrlHandler.TAG, "onClickHost: " + uri, null, 4, null);
            if (uri != null) {
                str = uri.getHost();
            } else {
                str = null;
            }
            if (str != null && str.hashCode() == 2097777583 && str.equals(QWalletFakeUrl.FAKEURL_COMFIRM_REQUEST)) {
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null) {
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(queryParameterNames, 10);
                    mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                    emptyMap = new LinkedHashMap(coerceAtLeast);
                    for (Object obj : queryParameterNames) {
                        String queryParameter = uri.getQueryParameter((String) obj);
                        if (queryParameter == null) {
                            queryParameter = "";
                        }
                        emptyMap.put(obj, queryParameter);
                    }
                } else {
                    emptyMap = MapsKt__MapsKt.emptyMap();
                }
                this.callbackInterceptor.retry(emptyMap);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
        
            if (r5.shouldIntercept() == true) goto L10;
         */
        @Override // com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler, com.tenpay.sdk.fakeurl.FakeUrlHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean dispatch(@Nullable Uri targetUri, @Nullable FakeInfo fakeInfo) {
            boolean z16;
            boolean dispatch = super.dispatch(targetUri, fakeInfo);
            if (!dispatch) {
                if (fakeInfo != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16) {
                    GatewayCallbackInterceptor gatewayCallbackInterceptor = this.callbackInterceptor;
                    int retCode = fakeInfo.getRetCode();
                    String retMsg = fakeInfo.getRetMsg();
                    if (retMsg == null) {
                        retMsg = GatewayFakeUrlController.INSTANCE.getDEFAULT_ERROR_TIPS();
                    }
                    gatewayCallbackInterceptor.onCallbackFail(retCode, retMsg, false);
                }
            }
            return dispatch;
        }

        @NotNull
        public final EnumHandleResult handle(int retCode, @NotNull PayGatewayProto$ErrDetail errorDetail) {
            int i3;
            Unit unit;
            Intrinsics.checkNotNullParameter(errorDetail, "errorDetail");
            FakeInfo parseFrom = FakeInfo.INSTANCE.parseFrom(retCode, errorDetail);
            ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, FakeUrlHandler.TAG, "handle fakeInfo: " + parseFrom, null, 4, null);
            FakeInfo.EnumErrorShowFlag errorShowFlag = parseFrom.getErrorShowFlag();
            if (errorShowFlag == null) {
                i3 = -1;
            } else {
                i3 = WhenMappings.$EnumSwitchMapping$0[errorShowFlag.ordinal()];
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return EnumHandleResult.NO_HANDLE;
                    }
                    if (!parseFrom.isValid()) {
                        parseFrom.setLeftData(FakeInfo.FakeButton.INSTANCE.getDEFAULT_BUTTON());
                    }
                    QQCustomDialog buildDialog = buildDialog(parseFrom);
                    if (buildDialog != null) {
                        buildDialog.show();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        return EnumHandleResult.NO_HANDLE;
                    }
                    if (parseFrom.shouldIntercept()) {
                        return EnumHandleResult.HANDLE_NEED_INTERCEPTED;
                    }
                    return EnumHandleResult.HANDLE;
                }
                QQToastUtil.showQQToast(1, errorDetail.retmsg.get());
                return EnumHandleResult.HANDLE;
            }
            return EnumHandleResult.HANDLE;
        }

        @Override // com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler
        public void onHandlerFinish(@Nullable Uri btnUri, int retCode, @NotNull String retMsg) {
            e eVar;
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            super.onHandlerFinish(btnUri, retCode, retMsg);
            g gVar = this.bizAbility;
            if (gVar instanceof e) {
                eVar = (e) gVar;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                eVar.b(btnUri, retCode, retMsg);
            }
        }
    }

    GatewayFakeUrlController() {
    }

    private final void fixErrorDetailMsg(String outerMsg, PayGatewayProto$ErrDetail errorDetail) {
        boolean z16;
        String str = errorDetail.retmsg.get();
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (outerMsg == null || outerMsg.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                errorDetail.retmsg.set(outerMsg);
            } else {
                errorDetail.retmsg.set(DEFAULT_ERROR_TIPS);
            }
        }
    }

    @NotNull
    public final String getDEFAULT_ERROR_TIPS() {
        return DEFAULT_ERROR_TIPS;
    }

    @NotNull
    public final EnumHandleResult processError(int retCode, @Nullable String outerMsg, @Nullable PayGatewayProto$ErrDetail errorDetail, @Nullable g bizAbility, @NotNull GatewayCallbackInterceptor callbackInterceptor) {
        String str;
        Integer num;
        b bVar;
        PBEnumField pBEnumField;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(callbackInterceptor, "callbackInterceptor");
        DLog dLog = DLog.INSTANCE;
        Context context = null;
        if (errorDetail != null && (pBStringField = errorDetail.retmsg) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (errorDetail != null && (pBEnumField = errorDetail.err_style) != null) {
            num = Integer.valueOf(pBEnumField.get());
        } else {
            num = null;
        }
        ILogAgent.DefaultImpls.i$default(dLog, TAG, "process fakeError: retCode=" + retCode + ", retMsg=" + str + ", dialogStyle=" + num, null, 4, null);
        if (errorDetail == null) {
            ILogAgent.DefaultImpls.w$default(dLog, TAG, "ignored null errorDetail", null, 4, null);
            return EnumHandleResult.NO_HANDLE;
        }
        fixErrorDetailMsg(outerMsg, errorDetail);
        if ((bizAbility instanceof e) && ((e) bizAbility).a(retCode, errorDetail)) {
            ILogAgent.DefaultImpls.i$default(dLog, TAG, "error handle by biz. " + bizAbility, null, 4, null);
            return EnumHandleResult.HANDLE;
        }
        if (bizAbility instanceof b) {
            bVar = (b) bizAbility;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            context = bVar.getContext();
        }
        if (context != null && ((b) bizAbility).isAlive()) {
            return new GatewayFakeUrlHandler(context, bizAbility, callbackInterceptor).handle(retCode, errorDetail);
        }
        return EnumHandleResult.HANDLE;
    }
}
