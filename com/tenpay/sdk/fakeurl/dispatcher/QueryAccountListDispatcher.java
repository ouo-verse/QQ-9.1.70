package com.tenpay.sdk.fakeurl.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tenpay.form.queryaccount.IdQueryEntryFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/fakeurl/dispatcher/QueryAccountListDispatcher;", "Lcom/tenpay/sdk/fakeurl/dispatcher/FakeUrlDispatcher;", "uin", "", "(Ljava/lang/String;)V", "getUin", "()Ljava/lang/String;", "performAction", "", "context", "Landroid/content/Context;", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QueryAccountListDispatcher implements FakeUrlDispatcher {

    @Nullable
    private final String uin;

    public QueryAccountListDispatcher(@Nullable String str) {
        this.uin = str;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    @Override // com.tenpay.sdk.fakeurl.dispatcher.FakeUrlDispatcher
    public void performAction(@Nullable Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        IdQueryEntryFragment.INSTANCE.startIdQuery(uri.getQueryParameter("channelInfo"), uri.getQueryParameter("tokenId"), uri.getQueryParameter(WadlProxyConsts.CHANNEL), uri.getQueryParameter("regbindParam"), context);
    }
}
