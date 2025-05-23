package com.tencent.timi.game.liveroom.impl.room.anchor;

import com.tencent.mobileqq.qqlive.anchor.live.pkentrance.PKEntranceComponent;
import com.tencent.mobileqq.qqlive.framework.pagefacotry.ComponentNode;
import com.tencent.mobileqq.qqlive.room.pkgame.AnchorPKGameComponent;
import com.tencent.timi.game.liveroom.impl.room.anchor.pk.TimiAnchorPKGameConnector;
import com.tencent.timi.game.liveroom.impl.room.anchor.pk.TimiCrossRoomLinkScreenStateConnector;
import com.tencent.timi.game.liveroom.impl.room.anchor.pk.TimiLinkPKAnchorPlayerConnector;
import com.tencent.timi.game.liveroom.impl.room.anchor.pk.TimiPKEntranceConnector;
import com.tencent.timi.game.liveroom.impl.room.anchor.pk.TimiPKVideoViewConnector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/b;", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/b;", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;", "root", "", "c", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "a", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/config/b;", "b", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements com.tencent.mobileqq.qqlive.framework.pagefacotry.b {
    @Override // com.tencent.mobileqq.qqlive.framework.pagefacotry.b
    @NotNull
    public List<Class<? extends com.tencent.mobileqq.qqlive.framework.connector.b>> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(q.class);
        if (ht3.a.e("qqlive_enable_anchor_obs_pk_feature", true) && com.tencent.mobileqq.qqlive.sail.c.f272176a.d().r() == 2) {
            arrayList.add(TimiLinkPKAnchorPlayerConnector.class);
            arrayList.add(TimiCrossRoomLinkScreenStateConnector.class);
            arrayList.add(TimiPKVideoViewConnector.class);
            arrayList.add(TimiAnchorPKGameConnector.class);
            arrayList.add(TimiPKEntranceConnector.class);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.pagefacotry.b
    @NotNull
    public com.tencent.mobileqq.qqlive.framework.pagefacotry.config.b b() {
        return new com.tencent.mobileqq.qqlive.base.room.pageconfig.c();
    }

    @Override // com.tencent.mobileqq.qqlive.framework.pagefacotry.b
    public void c(@NotNull ComponentNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        ComponentNode l3 = ComponentNode.l(root, p.class, null, 2, null);
        if (l3 != null && ht3.a.e("qqlive_enable_anchor_obs_pk_feature", true) && com.tencent.mobileqq.qqlive.sail.c.f272176a.d().r() == 2) {
            com.tencent.mobileqq.qqlive.anchor.live.anchorswitch.a aVar = new com.tencent.mobileqq.qqlive.anchor.live.anchorswitch.a();
            l3.k(com.tencent.mobileqq.qqlive.anchor.live.pkbtn.c.class, aVar);
            l3.k(com.tencent.mobileqq.qqlive.room.linkscreengame.a.class, aVar);
            l3.k(com.tencent.mobileqq.qqlive.anchor.live.pkstate.i.class, aVar);
            l3.k(com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.d.class, aVar);
            l3.k(AnchorPKGameComponent.class, aVar);
            l3.k(PKEntranceComponent.class, aVar);
        }
    }
}
