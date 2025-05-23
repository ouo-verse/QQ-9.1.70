package com.tenpay.sdk.fakeurl.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tenpay.sdk.fakeurl.FakeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BM\u0012<\b\u0002\u0010\u0002\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\bH\u0016RB\u0010\u0002\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/fakeurl/dispatcher/ConfirmRequestDispatcher;", "Lcom/tenpay/sdk/fakeurl/dispatcher/FakeUrlDispatcher;", "dispatcherCallback", "Lkotlin/Function2;", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "Lkotlin/ParameterName;", "name", "fakeInfo", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "(Lkotlin/jvm/functions/Function2;Lcom/tenpay/sdk/fakeurl/FakeInfo;)V", "getFakeInfo", "()Lcom/tenpay/sdk/fakeurl/FakeInfo;", "performAction", "context", "Landroid/content/Context;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ConfirmRequestDispatcher implements FakeUrlDispatcher {

    @Nullable
    private final Function2<FakeInfo, Uri, Unit> dispatcherCallback;

    @Nullable
    private final FakeInfo fakeInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public ConfirmRequestDispatcher(@Nullable Function2<? super FakeInfo, ? super Uri, Unit> function2, @Nullable FakeInfo fakeInfo) {
        this.dispatcherCallback = function2;
        this.fakeInfo = fakeInfo;
    }

    @Nullable
    public final FakeInfo getFakeInfo() {
        return this.fakeInfo;
    }

    @Override // com.tenpay.sdk.fakeurl.dispatcher.FakeUrlDispatcher
    public void performAction(@Nullable Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Function2<FakeInfo, Uri, Unit> function2 = this.dispatcherCallback;
        if (function2 != null) {
            function2.invoke(this.fakeInfo, uri);
        }
    }

    public /* synthetic */ ConfirmRequestDispatcher(Function2 function2, FakeInfo fakeInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function2, fakeInfo);
    }
}
