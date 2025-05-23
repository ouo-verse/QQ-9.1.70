package com.tencent.mobileqq.wink.event;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/event/TemplateSelectEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", WadlProxyConsts.KEY_MATERIAL, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "needRender", "", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getNeedRender", "()Z", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class TemplateSelectEvent extends SimpleBaseEvent {

    @Nullable
    private final MetaMaterial material;
    private final boolean needRender;

    public TemplateSelectEvent(@Nullable MetaMaterial metaMaterial, boolean z16) {
        this.material = metaMaterial;
        this.needRender = z16;
    }

    @Nullable
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    public final boolean getNeedRender() {
        return this.needRender;
    }
}
