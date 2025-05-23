package com.tencent.mobileqq.icgame.room.top;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.view.AnchorTopAreaView;
import com.tencent.icgame.trpc.yes.common.LiveBusConfigCenterClass$DynamicConfigRsp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import fu0.c;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k22.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@ComponentEvent(eventList = {com.tencent.mobileqq.icgame.room.top.b.class})
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B\u000f\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b%\u0010&R#\u0010-\u001a\n (*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R!\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/top/TopAreaComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView;", "Lk22/b;", "", BdhLogUtil.LogTag.Tag_Conn, "", UserInfo.SEX_FEMALE, "k", "i", "w", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "K", "H", "I", HippyTKDListViewAdapter.X, "y", "J", "isLand", "G", "L", "", "roomId", "B", "Lcom/tencent/icgame/trpc/yes/common/LiveBusConfigCenterClass$DynamicConfigRsp;", DownloadInfo.spKey_Config, "E", "Lep4/b;", "D", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/room/top/a;", "topAreaSupport", "Lcom/tencent/mobileqq/icgame/room/top/a;", "Lcom/tencent/mobileqq/icgame/room/float/component/a;", "floatControlService", "Lcom/tencent/mobileqq/icgame/room/float/component/a;", "Lfu0/c;", "kotlin.jvm.PlatformType", h.F, "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lfu0/c;", "liveRoomService", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/concurrent/CopyOnWriteArrayList;", "configChangeList", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class TopAreaComponent extends SingleUIComponent<AnchorTopAreaView> implements k22.b {

    @InjectService(key = com.tencent.mobileqq.icgame.room.p006float.component.a.class)
    private com.tencent.mobileqq.icgame.room.p006float.component.a floatControlService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy configChangeList;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    @InjectService(key = a.class)
    @Nullable
    private a topAreaSupport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/icgame/room/top/TopAreaComponent$b", "Lpv0/a;", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements pv0.a {
        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/room/top/TopAreaComponent$c", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$d;", "", "roomId", "", "c", "d", "a", "b", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements AnchorTopAreaView.d {
        c() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void a(long roomId) {
            QLog.i("ICGameTopAreaComponent", 1, "endLive: roomId:" + roomId);
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void b(long roomId) {
            if (TopAreaComponent.this.topAreaSupport != null) {
                a aVar = TopAreaComponent.this.topAreaSupport;
                Intrinsics.checkNotNull(aVar);
                if (aVar.a()) {
                    return;
                }
            }
            h22.a aVar2 = TopAreaComponent.this.qqLiveRoomService;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar2 = null;
            }
            aVar2.b(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if (r2.a() == true) goto L10;
         */
        @Override // com.tencent.icgame.game.liveroom.impl.room.view.AnchorTopAreaView.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(long roomId) {
            boolean z16;
            if (!TopAreaComponent.this.F()) {
                a aVar = TopAreaComponent.this.topAreaSupport;
                if (aVar != null) {
                    z16 = true;
                }
                z16 = false;
                if (!z16) {
                    h22.a aVar2 = TopAreaComponent.this.qqLiveRoomService;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                        aVar2 = null;
                    }
                    aVar2.b(false);
                }
            }
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void d(long roomId) {
            com.tencent.mobileqq.icgame.room.p006float.component.a aVar = TopAreaComponent.this.floatControlService;
            h22.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatControlService");
                aVar = null;
            }
            aVar.b();
            h22.a aVar3 = TopAreaComponent.this.qqLiveRoomService;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            } else {
                aVar2 = aVar3;
            }
            aVar2.b(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/top/TopAreaComponent$d", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$c;", "", NodeProps.VISIBLE, "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements AnchorTopAreaView.c {
        d() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.view.AnchorTopAreaView.c
        public void a(boolean visible) {
            h22.a aVar = TopAreaComponent.this.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            aVar.e(visible);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopAreaComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) qx0.a.b(c.class);
            }
        });
        this.liveRoomService = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CopyOnWriteArrayList<com.tencent.icgame.game.liveroom.impl.room.roomconfig.a>>() { // from class: com.tencent.mobileqq.icgame.room.top.TopAreaComponent$configChangeList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CopyOnWriteArrayList<com.tencent.icgame.game.liveroom.impl.room.roomconfig.a> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });
        this.configChangeList = lazy2;
    }

    private final fu0.c A() {
        return (fu0.c) this.liveRoomService.getValue();
    }

    private final void C() {
        AnchorTopAreaView p16 = p();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        p16.setActivityContext(aVar.d());
        p().setAudienceViewModel(new b());
        p().setListener(new c());
        p().setUIVisibleChangedListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F() {
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        y32.d.j(aVar.getRoomId());
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar3;
        }
        return aVar2.h();
    }

    private final CopyOnWriteArrayList<com.tencent.icgame.game.liveroom.impl.room.roomconfig.a> z() {
        return (CopyOnWriteArrayList) this.configChangeList.getValue();
    }

    public final void B(long roomId) {
        p().v();
    }

    public final void D(@NotNull ep4.b config) {
        Intrinsics.checkNotNullParameter(config, "config");
        p().X(config.f396942a);
    }

    public final void E(@NotNull LiveBusConfigCenterClass$DynamicConfigRsp config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Iterator<T> it = z().iterator();
        while (it.hasNext()) {
            ((com.tencent.icgame.game.liveroom.impl.room.roomconfig.a) it.next()).a(config);
        }
    }

    public final void G(boolean isLand) {
        int i3;
        p().C(isLand);
        AnchorTopAreaView p16 = p();
        if (isLand) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        p16.setVisibility(i3);
    }

    public final void H() {
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        p().D(aVar.getRoomId());
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar3;
        }
        LiveRoomExtraInfo extraInfo = aVar2.getExtraInfo();
        if (extraInfo != null) {
            p().setLiveExtraInfo(extraInfo);
        }
    }

    public final void I() {
        AnchorTopAreaView p16 = p();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        p16.E(aVar.getRoomId());
        rx0.a.h("is_click_anchor_info_card_avatar", false);
        y();
    }

    public final void J() {
        p().z();
        if (rx0.a.b("is_click_anchor_info_card_avatar", false)) {
            p().W();
        }
    }

    public final void K() {
        p().setActivityContext(getComponentContext().getContext());
        p().setQQLive(true);
        p().setLifecycleOwner(getComponentContext().getLifecycleOwner());
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        Intent intent = aVar.getIntent();
        if (intent != null) {
            p().setFromFloatWindow(intent.getBooleanExtra("open_from_float_window", false));
        }
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar3 = null;
        }
        LiveRoomExtraInfo extraInfo = aVar3.getExtraInfo();
        if (extraInfo != null) {
            p().setLiveExtraInfo(extraInfo);
        }
        if (mu0.a.k().o()) {
            h22.a aVar4 = this.qqLiveRoomService;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar4 = null;
            }
            long roomId = aVar4.getRoomId();
            h22.a aVar5 = this.qqLiveRoomService;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            } else {
                aVar2 = aVar5;
            }
            String preLoadVideoUrl = aVar2.getPreLoadVideoUrl();
            if (preLoadVideoUrl == null) {
                preLoadVideoUrl = "";
            }
            p().F(roomId, false, preLoadVideoUrl);
        }
    }

    public final void L() {
        p().Y();
    }

    @Override // k22.b
    public boolean handleBackPressed() {
        return b.a.a(this);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        p().V();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        aVar.i(this);
    }

    @Override // k22.b
    public void j() {
        b.a.b(this);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        C();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        aVar.g(this);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.f99715qj;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public AnchorTopAreaView n() {
        return new AnchorTopAreaView(getComponentContext().getContext(), null, 0, 6, null);
    }

    public final void x() {
        long j3;
        BaseAnchorInfo anchorInfo;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        IAudienceRoom N = A().N(roomId);
        if (N == null) {
            QLog.i("ICGameTopAreaComponent", 1, "enterRoom: audienceRoom is Null,check data! roomId:" + roomId);
        }
        AnchorTopAreaView p16 = p();
        if (N != null && (anchorInfo = N.getAnchorInfo()) != null) {
            j3 = anchorInfo.getAnchorUid();
        } else {
            j3 = 0;
        }
        p16.setLiveRoomInfo(j3);
        p().A(roomId, false);
    }

    public final void y() {
        AnchorTopAreaView p16 = p();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        p16.B(aVar.getRoomId());
    }
}
