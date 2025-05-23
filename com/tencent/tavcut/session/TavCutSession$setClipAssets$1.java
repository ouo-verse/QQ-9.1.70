package com.tencent.tavcut.session;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.tavcut.render.builder.light.LightRenderChainManager;
import com.tencent.tavcut.rendermodel.RenderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.light.ClipAsset;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
final class TavCutSession$setClipAssets$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f374464d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f374465e;
    final /* synthetic */ TavCutSession this$0;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.this$0.playerRenderChainManager instanceof LightRenderChainManager) {
            RenderModel L = this.this$0.L();
            List<ClipAsset> a16 = com.tencent.tavcut.render.builder.light.a.a(this.f374464d);
            zd4.b bVar = this.this$0.playerRenderChainManager;
            if (bVar != null) {
                ((LightRenderChainManager) bVar).D(a16, L.getPainting().pagPath, this.f374465e);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.render.builder.light.LightRenderChainManager");
        }
    }
}
