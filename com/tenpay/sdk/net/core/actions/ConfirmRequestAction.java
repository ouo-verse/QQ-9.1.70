package com.tenpay.sdk.net.core.actions;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import com.tenpay.sdk.fakeurl.FakeUrlHandler;
import com.tenpay.sdk.fakeurl.FillNameRequestHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import com.tenpay.sdk.net.core.request.ContextAbility;
import com.tenpay.sdk.net.core.request.RetryAbility;
import com.tenpay.sdk.net.core.result.NetResult;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002J6\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/ConfirmRequestAction;", "Lcom/tenpay/sdk/net/core/actions/IKeyLinkAction;", "()V", "commonConfirmRequestAction", "", "context", "Landroid/content/Context;", "rspJSON", "Lorg/json/JSONObject;", "retryAbility", "Lcom/tenpay/sdk/net/core/request/RetryAbility;", "callback", "Lkotlin/Function0;", "fillNameRequestAction", QWalletFakeUrl.FAKEURL_PARAM_FILL_NAME, "", "onInterceptCallback", "", "url", "result", "Lcom/tenpay/sdk/net/core/result/NetResult;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ConfirmRequestAction implements IKeyLinkAction {

    @NotNull
    public static final String TAG = "QWalletHttp-ConfirmRequestAction";

    private final void commonConfirmRequestAction(Context context, JSONObject rspJSON, final RetryAbility retryAbility, final Function0<Unit> callback) {
        QLog.i(TAG, 1, "do commonConfirmRequestAction");
        new FakeUrlHandler(context).handle(retryAbility.getOriginUrl(), rspJSON, new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.net.core.actions.ConfirmRequestAction$commonConfirmRequestAction$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
            public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex index, @Nullable Uri uri) {
                Map emptyMap;
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
                Intrinsics.checkNotNullParameter(index, "index");
                if (uri == null) {
                    return false;
                }
                if (FakeUrlUtils.isConfirmRequest(uri)) {
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
                    QLog.i(ConfirmRequestAction.TAG, 1, "fake url retry request append: " + emptyMap);
                    RetryAbility.this.retry(emptyMap);
                    return true;
                }
                callback.invoke();
                return false;
            }
        });
    }

    private final void fillNameRequestAction(Context context, String fillName, JSONObject rspJSON, final RetryAbility retryAbility, final Function0<Unit> callback) {
        QLog.i(TAG, 1, "do fillNameRequestAction");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        new FillNameRequestHandler(context, fillName, linkedHashMap).handle(retryAbility.getOriginUrl(), rspJSON, new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.net.core.actions.ConfirmRequestAction$fillNameRequestAction$1
            @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
            public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex index, @Nullable Uri uri) {
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                Map<String, String> mutableMap;
                Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
                Intrinsics.checkNotNullParameter(index, "index");
                if (uri == null) {
                    return false;
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(queryParameterNames, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast);
                for (Object obj : queryParameterNames) {
                    String queryParameter = uri.getQueryParameter((String) obj);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    linkedHashMap2.put(obj, queryParameter);
                }
                mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap2);
                mutableMap.putAll(linkedHashMap);
                if (FakeUrlUtils.isConfirmRequest(uri)) {
                    QLog.i(ConfirmRequestAction.TAG, 1, "fake url retry request append: " + mutableMap);
                    RetryAbility.this.retry(mutableMap);
                    return true;
                }
                callback.invoke();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInterceptCallback$lambda$0(String str, ConfirmRequestAction this$0, Context context, JSONObject jSONObject, RetryAbility retryAbility, Function0 callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(retryAbility, "$retryAbility");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z17 = false;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            this$0.fillNameRequestAction(context, str, jSONObject, retryAbility, callback);
        } else {
            this$0.commonConfirmRequestAction(context, jSONObject, retryAbility, callback);
        }
    }

    @Override // com.tenpay.sdk.net.core.actions.IKeyLinkAction
    public boolean onInterceptCallback(@NotNull String url, @NotNull NetResult result, @NotNull final Function0<Unit> callback) {
        final JSONObject jSONObject;
        final RetryAbility retryAbility;
        ContextAbility contextAbility;
        final Context context;
        Uri uri;
        Uri uri2;
        FakeInfo.FakeButton leftData;
        FakeInfo.FakeButton leftData2;
        FakeInfo.FakeButton rightData;
        FakeInfo.FakeButton rightData2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object bizResponse = result.getBizResponse();
        Uri uri3 = null;
        if (bizResponse instanceof JSONObject) {
            jSONObject = (JSONObject) bizResponse;
        } else {
            jSONObject = null;
        }
        if (jSONObject == null || !QWalletFakeUrl.hasQWalletFakeProtocal(jSONObject)) {
            return false;
        }
        Object request = result.getRequest();
        if (request instanceof RetryAbility) {
            retryAbility = (RetryAbility) request;
        } else {
            retryAbility = null;
        }
        if (retryAbility == null) {
            return false;
        }
        Object request2 = result.getRequest();
        if (request2 instanceof ContextAbility) {
            contextAbility = (ContextAbility) request2;
        } else {
            contextAbility = null;
        }
        if (contextAbility == null || (context = contextAbility.getContext()) == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            QLog.w(TAG, 1, "context !is Activity." + context);
            return false;
        }
        FakeInfo parseFrom = FakeInfo.INSTANCE.parseFrom(url, jSONObject);
        if (parseFrom != null && (rightData2 = parseFrom.getRightData()) != null) {
            uri = rightData2.getUri();
        } else {
            uri = null;
        }
        if (FakeUrlUtils.isConfirmRequest(uri)) {
            if (parseFrom != null && (rightData = parseFrom.getRightData()) != null) {
                uri3 = rightData.getUri();
            }
        } else {
            if (parseFrom != null && (leftData2 = parseFrom.getLeftData()) != null) {
                uri2 = leftData2.getUri();
            } else {
                uri2 = null;
            }
            if (FakeUrlUtils.isConfirmRequest(uri2) && parseFrom != null && (leftData = parseFrom.getLeftData()) != null) {
                uri3 = leftData.getUri();
            }
        }
        if (uri3 == null) {
            return false;
        }
        final String queryParameter = uri3.getQueryParameter(QWalletFakeUrl.FAKEURL_PARAM_FILL_NAME);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tenpay.sdk.net.core.actions.a
            @Override // java.lang.Runnable
            public final void run() {
                ConfirmRequestAction.onInterceptCallback$lambda$0(queryParameter, this, context, jSONObject, retryAbility, callback);
            }
        });
        return true;
    }
}
