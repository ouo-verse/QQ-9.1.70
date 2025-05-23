package com.tencent.mobileqq.vas.adv.base.service;

import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.mobileqq.vas.adv.base.service.VasGdtService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/gdtad/aditem/GdtAdLoader$Listener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasGdtService$listener$2 extends Lambda implements Function0<GdtAdLoader.Listener> {
    final /* synthetic */ VasGdtService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasGdtService$listener$2(VasGdtService vasGdtService) {
        super(0);
        this.this$0 = vasGdtService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VasGdtService this$0, GdtAdLoader gdtAdLoader) {
        qq_ad_get.QQAdGetRsp qQAdGetRsp;
        GdtAdLoader.Session session;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VasGdtService.a gdtCallback = this$0.getGdtCallback();
        if (gdtCallback != null) {
            if (gdtAdLoader != null && (session = gdtAdLoader.getSession()) != null) {
                qQAdGetRsp = session.response;
            } else {
                qQAdGetRsp = null;
            }
            gdtCallback.a(qQAdGetRsp);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GdtAdLoader.Listener invoke() {
        final VasGdtService vasGdtService = this.this$0;
        return new GdtAdLoader.Listener() { // from class: com.tencent.mobileqq.vas.adv.base.service.f
            @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
            public final void onResponse(GdtAdLoader gdtAdLoader) {
                VasGdtService$listener$2.b(VasGdtService.this, gdtAdLoader);
            }
        };
    }
}
