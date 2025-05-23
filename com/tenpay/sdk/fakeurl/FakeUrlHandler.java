package com.tenpay.sdk.fakeurl;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\"\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\"\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeUrlHandler;", "Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$OnClickButtonListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contextRef", "Lmqq/util/WeakReference;", "getContextRef$qwallet_impl_release", "()Lmqq/util/WeakReference;", "customListener", "buildDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "fakeInfo", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "dispatch", "", "targetUri", "Landroid/net/Uri;", "handle", BrowserPlugin.KEY_REQUEST_URL, "", "data", "listener", "Lorg/json/JSONObject;", "onClickButton", "index", "Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$BtnIndex;", LayoutAttrDefine.CLICK_URI, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class FakeUrlHandler implements FakeUrlDialogBuilder.OnClickButtonListener {

    @NotNull
    public static final String TAG = "QWalletHttp.FakeUrlHandler";

    @NotNull
    private final WeakReference<Context> contextRef;

    @Nullable
    private FakeUrlDialogBuilder.OnClickButtonListener customListener;

    public FakeUrlHandler(@Nullable Context context) {
        this.contextRef = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public QQCustomDialog buildDialog(@Nullable FakeInfo fakeInfo) {
        Context context;
        if (fakeInfo == null || (context = this.contextRef.get()) == null) {
            return null;
        }
        FakeUrlDialogBuilder fakeUrlDialogBuilder = new FakeUrlDialogBuilder(context);
        fakeUrlDialogBuilder.setData(fakeInfo);
        fakeUrlDialogBuilder.setOnButtonClickListener(this);
        fakeUrlDialogBuilder.setMsgSchemaAction(new Function1<String, Unit>() { // from class: com.tenpay.sdk.fakeurl.FakeUrlHandler$buildDialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String schema) {
                Intrinsics.checkNotNullParameter(schema, "schema");
                k.h(FakeUrlHandler.this.getContextRef$qwallet_impl_release().get(), Uri.parse(schema).toString());
            }
        });
        return fakeUrlDialogBuilder.build();
    }

    public boolean dispatch(@Nullable Uri targetUri, @Nullable FakeInfo fakeInfo) {
        QLog.i(TAG, 1, "dispatch uri: " + targetUri + ", fakeInfo: " + fakeInfo);
        if (targetUri == null) {
            return false;
        }
        k.h(this.contextRef.get(), targetUri.toString());
        return true;
    }

    @NotNull
    public final WeakReference<Context> getContextRef$qwallet_impl_release() {
        return this.contextRef;
    }

    public final boolean handle(@Nullable String requestUrl, @NotNull String data, @Nullable FakeUrlDialogBuilder.OnClickButtonListener listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            return handle(requestUrl, new JSONObject(data), listener);
        } catch (JSONException e16) {
            QLog.w(TAG, 1, "handle occur: ", e16);
            return false;
        }
    }

    @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
    public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex index, @Nullable Uri uri) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
        Intrinsics.checkNotNullParameter(index, "index");
        FakeUrlDialogBuilder.OnClickButtonListener onClickButtonListener = this.customListener;
        if (onClickButtonListener != null) {
            z16 = onClickButtonListener.onClickButton(fakeInfo, index, uri);
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        QLog.i(TAG, 2, "dispatchClick " + uri);
        return dispatch(uri, fakeInfo);
    }

    public final boolean handle(@Nullable String requestUrl, @NotNull JSONObject data, @Nullable FakeUrlDialogBuilder.OnClickButtonListener listener) {
        Unit unit;
        Intrinsics.checkNotNullParameter(data, "data");
        FakeInfo parseFrom = FakeInfo.INSTANCE.parseFrom(requestUrl, data);
        if (parseFrom == null || parseFrom.getErrorShowFlag() != FakeInfo.EnumErrorShowFlag.ALTER) {
            return false;
        }
        if (!parseFrom.isValid()) {
            parseFrom.setLeftData(FakeInfo.FakeButton.INSTANCE.getDEFAULT_BUTTON());
        }
        QLog.i(TAG, 1, "handle: " + data + ", requestUrl: " + requestUrl + ", listener: " + listener);
        this.customListener = listener;
        QQCustomDialog buildDialog = buildDialog(parseFrom);
        if (buildDialog != null) {
            buildDialog.show();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit != null;
    }
}
