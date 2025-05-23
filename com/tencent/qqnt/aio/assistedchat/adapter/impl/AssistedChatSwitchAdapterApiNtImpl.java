package com.tencent.qqnt.aio.assistedchat.adapter.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.d;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wu3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J4\u0010\u000e\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J:\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u001a\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/impl/AssistedChatSwitchAdapterApiNtImpl;", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatSwitchAdapterApi;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "isSwitchOn", "", "getSwitchValue", "", "switchList", "switchValue", "Lkotlin/Function1;", "", "callback", "reqSetSwitch", "", "uin", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "reqGetSwitch", "Lwu3/a;", "listener", "addSwitchChangedListener", "removeSwitchChangedListener", "preRequestSwitch", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatSwitchAdapterApiNtImpl implements IAssistedChatSwitchAdapterApi {
    static IPatchRedirector $redirector_;

    public AssistedChatSwitchAdapterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void addSwitchChangedListener(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public int getSwitchValue(@NotNull AssistedChatSwitch r46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) r46)).intValue();
        }
        Intrinsics.checkNotNullParameter(r46, "switch");
        return 1;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public boolean isSwitchOn(@NotNull AssistedChatSwitch r46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(r46, "switch");
        return true;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void preRequestSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void removeSwitchChangedListener(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void reqGetSwitch(@NotNull String uin, @NotNull List<AssistedChatSwitch> switchList, @Nullable Function1<? super List<d>, Unit> callback) {
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uin, switchList, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        if (callback != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.invoke(emptyList);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void reqSetSwitch(@NotNull List<AssistedChatSwitch> switchList, int switchValue, @Nullable Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, switchList, Integer.valueOf(switchValue), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        if (callback != null) {
            callback.invoke(Boolean.TRUE);
        }
    }
}
