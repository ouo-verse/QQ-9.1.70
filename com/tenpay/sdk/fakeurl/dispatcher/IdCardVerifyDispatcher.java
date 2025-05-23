package com.tenpay.sdk.fakeurl.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tenpay.idverify.IdVerifyModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/fakeurl/dispatcher/IdCardVerifyDispatcher;", "Lcom/tenpay/sdk/fakeurl/dispatcher/FakeUrlDispatcher;", "()V", "performAction", "", "context", "Landroid/content/Context;", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdCardVerifyDispatcher implements FakeUrlDispatcher {
    @Override // com.tenpay.sdk.fakeurl.dispatcher.FakeUrlDispatcher
    public void performAction(@Nullable Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        IdVerifyModule.startFromFakeUrl(context);
    }
}
