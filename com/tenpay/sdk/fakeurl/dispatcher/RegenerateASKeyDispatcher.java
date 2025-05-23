package com.tenpay.sdk.fakeurl.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tenpay.api.FingerPayApi;
import com.tenpay.sdk.Cgi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/fakeurl/dispatcher/RegenerateASKeyDispatcher;", "Lcom/tenpay/sdk/fakeurl/dispatcher/FakeUrlDispatcher;", "uin", "", "(Ljava/lang/String;)V", "getUin", "()Ljava/lang/String;", "performAction", "", "context", "Landroid/content/Context;", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class RegenerateASKeyDispatcher implements FakeUrlDispatcher {

    @Nullable
    private final String uin;

    public RegenerateASKeyDispatcher(@Nullable String str) {
        this.uin = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performAction$lambda$0(Context context, RegenerateASKeyDispatcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            FingerPayApi.closeFingerPay(context, this$0.uin);
            SoterCore.removeAppGlobalSecureKey();
            SoterWrapperApi.removeAuthKeyByScene(Cgi.scene_FingerPay);
        } catch (Exception e16) {
            QLog.e("QWallet.FakeUrlDispatcher", 1, "", e16);
        }
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    @Override // com.tenpay.sdk.fakeurl.dispatcher.FakeUrlDispatcher
    public void performAction(@Nullable final Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.fakeurl.dispatcher.a
            @Override // java.lang.Runnable
            public final void run() {
                RegenerateASKeyDispatcher.performAction$lambda$0(context, this);
            }
        }, 128, null, false);
    }
}
