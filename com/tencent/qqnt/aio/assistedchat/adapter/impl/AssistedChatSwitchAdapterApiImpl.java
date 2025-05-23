package com.tencent.qqnt.aio.assistedchat.adapter.impl;

import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.d;
import com.tencent.qqnt.aio.assistedchat.setting.e;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wu3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J4\u0010\u000e\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J:\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u001a\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/impl/AssistedChatSwitchAdapterApiImpl;", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatSwitchAdapterApi;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "isSwitchOn", "", "getSwitchValue", "", "switchList", "switchValue", "Lkotlin/Function1;", "", "callback", "reqSetSwitch", "", "uin", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "reqGetSwitch", "Lwu3/a;", "listener", "addSwitchChangedListener", "removeSwitchChangedListener", "preRequestSwitch", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AssistedChatSwitchAdapterApiImpl implements IAssistedChatSwitchAdapterApi {
    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void addSwitchChangedListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e.f349447a.d(listener);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public int getSwitchValue(AssistedChatSwitch r26) {
        Intrinsics.checkNotNullParameter(r26, "switch");
        return e.f349447a.f(r26);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public boolean isSwitchOn(AssistedChatSwitch r26) {
        Intrinsics.checkNotNullParameter(r26, "switch");
        return e.f349447a.g(r26);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void preRequestSwitch() {
        e.f349447a.k();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void removeSwitchChangedListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e.f349447a.m(listener);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void reqGetSwitch(String uin, List<AssistedChatSwitch> switchList, Function1<? super List<d>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        e.f349447a.n(uin, switchList, callback);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi
    public void reqSetSwitch(List<AssistedChatSwitch> switchList, int switchValue, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        e.f349447a.q(switchList, switchValue, callback);
    }
}
