package com.tenpay.sdk.fakeurl;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.fakeurl.dispatcher.BindCardVerifyDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.BindNewCardDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.ConfirmRequestDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.FaceIdentifyDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.FakeUrlDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.IdCardVerifyDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.QueryAccountListDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.RegenerateASKeyDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.RegenerateAuthKeyDispatcher;
import com.tenpay.sdk.fakeurl.dispatcher.TransferInputDispatcher;
import com.tenpay.sdk.net.gateway.GatewayFakeUrlController;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016JF\u0010\u001c\u001a\u00020\u000f2>\b\u0002\u0010\u001d\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bRD\u0010\u0007\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tenpay/sdk/fakeurl/QWalletFakeUrlHandler;", "Lcom/tenpay/sdk/fakeurl/FakeUrlHandler;", "context", "Landroid/content/Context;", "uin", "", "(Landroid/content/Context;Ljava/lang/String;)V", "dispatcherCallback", "Lkotlin/Function2;", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "Lkotlin/ParameterName;", "name", "fakeInfo", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "getUin", "()Ljava/lang/String;", "dispatch", "", "targetUri", QZoneDTLoginReporter.SCHEMA, "dispatchQWallet", "onHandlerFinish", "btnUri", "retCode", "", "retMsg", "setDispatcherCallback", "listener", "Companion", "EnumFakeHost", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class QWalletFakeUrlHandler extends FakeUrlHandler {

    @NotNull
    private static final String SCHEME_TENPAYSDK = "tenpaysdk";

    @Nullable
    private Function2<? super FakeInfo, ? super Uri, Unit> dispatcherCallback;

    @Nullable
    private final String uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/fakeurl/QWalletFakeUrlHandler$EnumFakeHost;", "", "interceptorCallback", "", "(Ljava/lang/String;IZ)V", "getInterceptorCallback", "()Z", QWalletFakeUrl.FAKEURL_TRANSFERINPUT, QWalletFakeUrl.FAKEURL_REGENERATEASKEY, QWalletFakeUrl.FAKEURL_REGENERATEAUTHKEY, QWalletFakeUrl.FAKEURL_BINDCARDVERIFY, QWalletFakeUrl.FAKEURL_BINDNEWCARD, "idCardVerify", QWalletFakeUrl.FAKEURL_COMFIRM_REQUEST, "queryAccountList", "faceIdentify", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EnumFakeHost {
        transferInput(false),
        regenerateASKey(false),
        regenerateAuthKey(false),
        bindCardVerify(false),
        bindNewCard(false),
        idCardVerify(false),
        confirmRequest(true),
        queryAccountList(false),
        faceIdentify(false);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final boolean interceptorCallback;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/fakeurl/QWalletFakeUrlHandler$EnumFakeHost$Companion;", "", "()V", "fromHost", "Lcom/tenpay/sdk/fakeurl/QWalletFakeUrlHandler$EnumFakeHost;", "host", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final EnumFakeHost fromHost(@Nullable String host) {
                for (EnumFakeHost enumFakeHost : EnumFakeHost.values()) {
                    if (Intrinsics.areEqual(enumFakeHost.name(), host)) {
                        return enumFakeHost;
                    }
                }
                return null;
            }

            Companion() {
            }
        }

        EnumFakeHost(boolean z16) {
            this.interceptorCallback = z16;
        }

        public final boolean getInterceptorCallback() {
            return this.interceptorCallback;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumFakeHost.values().length];
            try {
                iArr[EnumFakeHost.transferInput.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumFakeHost.regenerateASKey.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumFakeHost.regenerateAuthKey.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumFakeHost.bindCardVerify.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumFakeHost.bindNewCard.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumFakeHost.idCardVerify.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumFakeHost.confirmRequest.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumFakeHost.queryAccountList.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumFakeHost.faceIdentify.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ QWalletFakeUrlHandler(Context context, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? com.tencent.mobileqq.base.a.c() : str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0024. Please report as an issue. */
    private final boolean dispatchQWallet(Uri uri, FakeInfo fakeInfo) {
        EnumFakeHost fromHost;
        FakeUrlDispatcher transferInputDispatcher;
        FakeUrlDispatcher regenerateASKeyDispatcher;
        if (!Intrinsics.areEqual(uri.getScheme(), SCHEME_TENPAYSDK) || (fromHost = EnumFakeHost.INSTANCE.fromHost(uri.getHost())) == null) {
            return false;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[fromHost.ordinal()]) {
            case 1:
                transferInputDispatcher = new TransferInputDispatcher(this.dispatcherCallback, fakeInfo);
                regenerateASKeyDispatcher = transferInputDispatcher;
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 2:
                regenerateASKeyDispatcher = new RegenerateASKeyDispatcher(this.uin);
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 3:
                regenerateASKeyDispatcher = new RegenerateAuthKeyDispatcher(this.uin);
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 4:
                regenerateASKeyDispatcher = new BindCardVerifyDispatcher(this.uin);
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 5:
                regenerateASKeyDispatcher = new BindNewCardDispatcher(this.uin);
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 6:
                regenerateASKeyDispatcher = new IdCardVerifyDispatcher();
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 7:
                transferInputDispatcher = new ConfirmRequestDispatcher(this.dispatcherCallback, fakeInfo);
                regenerateASKeyDispatcher = transferInputDispatcher;
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 8:
                regenerateASKeyDispatcher = new QueryAccountListDispatcher(this.uin);
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            case 9:
                regenerateASKeyDispatcher = new FaceIdentifyDispatcher();
                QLog.i("QWallet.FakeUrlDispatcher", 2, "performAction: " + regenerateASKeyDispatcher);
                regenerateASKeyDispatcher.performAction(getContextRef$qwallet_impl_release().get(), uri);
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setDispatcherCallback$default(QWalletFakeUrlHandler qWalletFakeUrlHandler, Function2 function2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                function2 = null;
            }
            qWalletFakeUrlHandler.setDispatcherCallback(function2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDispatcherCallback");
    }

    public final boolean dispatch(@Nullable String schema) {
        boolean z16 = true;
        QLog.i(FakeUrlHandler.TAG, 1, "dispatch " + schema);
        if (schema != null && schema.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        return dispatch(Uri.parse(schema), null);
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    public void onHandlerFinish(@Nullable Uri btnUri, int retCode, @NotNull String retMsg) {
        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
    }

    public final void setDispatcherCallback(@Nullable Function2<? super FakeInfo, ? super Uri, Unit> listener) {
        this.dispatcherCallback = listener;
    }

    public QWalletFakeUrlHandler(@Nullable Context context, @Nullable String str) {
        super(context);
        this.uin = str;
    }

    @Override // com.tenpay.sdk.fakeurl.FakeUrlHandler
    public boolean dispatch(@Nullable Uri targetUri, @Nullable FakeInfo fakeInfo) {
        String default_error_tips;
        int retCode = fakeInfo != null ? fakeInfo.getRetCode() : -1001;
        if (fakeInfo == null || (default_error_tips = fakeInfo.getRetMsg()) == null) {
            default_error_tips = GatewayFakeUrlController.INSTANCE.getDEFAULT_ERROR_TIPS();
        }
        if (targetUri == null) {
            QLog.w("QWallet.FakeUrlDispatcher", 2, "dispatch null uri");
            onHandlerFinish(null, retCode, default_error_tips);
            return false;
        }
        if (dispatchQWallet(targetUri, fakeInfo)) {
            onHandlerFinish(targetUri, retCode, default_error_tips);
            return true;
        }
        if (!super.dispatch(targetUri, fakeInfo)) {
            return false;
        }
        onHandlerFinish(targetUri, retCode, default_error_tips);
        return true;
    }
}
