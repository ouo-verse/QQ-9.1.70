package com.tencent.mobileqq.icgame.room.config;

import a42.d;
import android.os.Build;
import com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus.AudioFocusComponent;
import com.tencent.icgame.game.liveroom.impl.room.audience.preload.PreloadRoomComponent;
import com.tencent.icgame.game.liveroom.impl.room.roomconfig.RoomConfigComponent;
import com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateComponent;
import com.tencent.mobileqq.icgame.base.baseroom.roomstate.RoomStateConnector;
import com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode;
import com.tencent.mobileqq.icgame.framework.pagefacotry.b;
import com.tencent.mobileqq.icgame.room.connector.ICGameAudienceConnector;
import com.tencent.mobileqq.icgame.room.displayview.component.ICGameDisplayViewConnector;
import com.tencent.mobileqq.icgame.room.displayview.definition.DefinitionConnector;
import com.tencent.mobileqq.icgame.room.displayview.horizontal.HorizontalCtrlConnector;
import com.tencent.mobileqq.icgame.room.end.LiveEndConnector;
import com.tencent.mobileqq.icgame.room.end.g;
import com.tencent.mobileqq.icgame.room.followguide.FollowGuideConnector;
import com.tencent.mobileqq.icgame.room.gift.GiftComponent;
import com.tencent.mobileqq.icgame.room.gift.GiftConnector;
import com.tencent.mobileqq.icgame.room.gift.GiftEntranceConnector;
import com.tencent.mobileqq.icgame.room.input.component.InputBoxConnector;
import com.tencent.mobileqq.icgame.room.likeowner.LikeOwnerConnector;
import com.tencent.mobileqq.icgame.room.likeowner.LiveLikeViewConnector;
import com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutComponent;
import com.tencent.mobileqq.icgame.room.message.component.LiveMessageLayoutConnector;
import com.tencent.mobileqq.icgame.room.operatedialog.connector.OperateDialogConnector;
import com.tencent.mobileqq.icgame.room.operationbar.QQLiveAudienceOperationBarConnector;
import com.tencent.mobileqq.icgame.room.p006float.component.FloatControlComponent;
import com.tencent.mobileqq.icgame.room.p006float.component.FloatControlConnector;
import com.tencent.mobileqq.icgame.room.pendant.component.QQIvLivePendantConnector;
import com.tencent.mobileqq.icgame.room.pendant.component.QQLivePendantComponent;
import com.tencent.mobileqq.icgame.room.preload.PreloadRoomConnector;
import com.tencent.mobileqq.icgame.room.report.ReportConnector;
import com.tencent.mobileqq.icgame.room.top.QQLiveTopAreaConnector;
import com.tencent.mobileqq.icgame.room.top.TopAreaComponent;
import com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateComponent;
import com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateConnector;
import com.tencent.mobileqq.icgame.room.unitedialog.QQLiveUniteDialogConnector;
import f22.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import z32.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/config/ICGameConfig;", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/b;", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "root", "", "c", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/connector/b;", "a", "Lo32/b;", "b", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGameConfig implements b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ICGameConfig f237442a = new ICGameConfig();

    ICGameConfig() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.pagefacotry.b
    @NotNull
    public List<Class<? extends com.tencent.mobileqq.icgame.framework.connector.b>> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RoomStateConnector.class);
        arrayList.add(PreloadRoomConnector.class);
        arrayList.add(a.class);
        arrayList.add(QQLiveTopAreaConnector.class);
        arrayList.add(ICGameAudienceConnector.class);
        arrayList.add(ICGameDisplayViewConnector.class);
        arrayList.add(OperateDialogConnector.class);
        arrayList.add(QQLiveAudienceOperationBarConnector.class);
        arrayList.add(qv0.a.class);
        arrayList.add(FollowGuideConnector.class);
        arrayList.add(QQLiveUniteDialogConnector.class);
        arrayList.add(HorizontalCtrlConnector.class);
        arrayList.add(DefinitionConnector.class);
        arrayList.add(FloatControlConnector.class);
        arrayList.add(LikeOwnerConnector.class);
        arrayList.add(LiveEndConnector.class);
        arrayList.add(d.class);
        arrayList.add(LiveLikeViewConnector.class);
        arrayList.add(LiveMessageLayoutConnector.class);
        arrayList.add(InputBoxConnector.class);
        arrayList.add(TouchDelegateConnector.class);
        arrayList.add(GiftEntranceConnector.class);
        arrayList.add(GiftConnector.class);
        arrayList.add(ReportConnector.class);
        arrayList.add(QQIvLivePendantConnector.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.framework.pagefacotry.b
    @NotNull
    public o32.b b() {
        return new c();
    }

    @Override // com.tencent.mobileqq.icgame.framework.pagefacotry.b
    public void c(@NotNull ComponentNode root) {
        ComponentNode m3;
        Intrinsics.checkNotNullParameter(root, "root");
        ComponentNode m16 = ComponentNode.m(root, n42.a.class, null, 2, null);
        if (m16 != null) {
            ComponentNode.m(m16, com.tencent.mobileqq.icgame.room.displayview.component.d.class, null, 2, null);
            ComponentNode m17 = ComponentNode.m(m16, a42.c.class, null, 2, null);
            if (m17 != null && (m3 = ComponentNode.m(m17, com.tencent.mobileqq.icgame.room.component.a.class, null, 2, null)) != null) {
                ComponentNode.m(m3, TopAreaComponent.class, null, 2, null);
                ComponentNode.m(m3, j42.a.class, null, 2, null);
                ComponentNode.m(m3, tv0.a.class, null, 2, null);
                ComponentNode.m(m3, FloatControlComponent.class, null, 2, null);
                ComponentNode.m(m3, com.tencent.mobileqq.icgame.room.likeowner.b.class, null, 2, null);
                ComponentNode.m(m3, com.tencent.mobileqq.icgame.room.likeowner.c.class, null, 2, null);
                ComponentNode.m(m3, LiveMessageLayoutComponent.class, null, 2, null);
                ComponentNode.m(m3, com.tencent.mobileqq.icgame.room.input.component.b.class, null, 2, null);
                ComponentNode.m(m3, TouchDelegateComponent.class, null, 2, null);
            }
            ComponentNode.m(m16, g.class, null, 2, null);
        }
        ComponentNode.m(root, jx0.a.class, null, 2, null);
        ComponentNode.m(root, nv0.b.class, null, 2, null);
        ComponentNode.m(root, com.tencent.icgame.game.liveroom.impl.room.followguide.b.class, null, 2, null);
        ComponentNode.m(root, com.tencent.mobileqq.icgame.room.unitedialog.a.class, null, 2, null);
        ComponentNode.m(root, lv0.a.class, null, 2, null);
        ComponentNode.m(root, PreloadRoomComponent.class, null, 2, null);
        root.k(AudioFocusComponent.class, new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.icgame.room.config.ICGameConfig$getComponentNode$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Build.VERSION.SDK_INT >= 26);
            }
        });
        ComponentNode.m(root, com.tencent.mobileqq.icgame.room.displayview.definition.b.class, null, 2, null);
        ComponentNode.m(root, d22.d.class, null, 2, null);
        ComponentNode.m(root, RoomStateComponent.class, null, 2, null);
        ComponentNode.m(root, RoomConfigComponent.class, null, 2, null);
        ComponentNode.m(root, com.tencent.mobileqq.icgame.room.gift.b.class, null, 2, null);
        ComponentNode.m(root, GiftComponent.class, null, 2, null);
        ComponentNode.m(root, com.tencent.mobileqq.icgame.room.report.a.class, null, 2, null);
        ComponentNode.m(root, QQLivePendantComponent.class, null, 2, null);
    }
}
