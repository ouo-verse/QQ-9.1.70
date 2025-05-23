package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J(\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIONickIconServiceApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "mockIconDataForStockBlock", "", "troopUin", "memberUin", "Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi$b;", "callback", "", "getTmInfoIconDataAsync", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "getIdentityDataFromCacheOrFetchAsync", "", "isGlobalSwitchOpen", "getStaticIconDataList", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "openTroopIdentityWearPage", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIONickIconServiceApiNtImpl implements IAIONickIconServiceApi {
    static IPatchRedirector $redirector_;

    public AIONickIconServiceApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> mockIconDataForStockBlock() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(1, 1, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(2, 1, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(3, 1, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(4, 1, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(5, 1, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(6, 1, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(7, 1, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(8, 1, Long.MAX_VALUE, null, 8, null));
        return arrayListOf;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    @Nullable
    public com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c getIdentityDataFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    @NotNull
    public List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> getStaticIconDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new ArrayList();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public void getTmInfoIconDataAsync(@NotNull String troopUin, @NotNull String memberUin, @NotNull IAIONickIconServiceApi.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, memberUin, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.a(true, mockIconDataForStockBlock());
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public boolean isGlobalSwitchOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public void openTroopIdentityWearPage(@NotNull Context context, @NotNull String troopUin, @NotNull String memberUin, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, troopUin, memberUin, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }
}
