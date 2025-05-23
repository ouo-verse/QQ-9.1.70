package com.tencent.mobileqq.icgame.room.likeowner;

import a42.e;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.like.LiveOwnerLikeView;
import com.tencent.icgame.game.liveroom.impl.room.like.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@ComponentEvent(eventList = {EnterRoomSuccessEvent.class, com.tencent.icgame.game.liveroom.impl.room.roomconfig.b.class})
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0010R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/likeowner/b;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView;", ReportConstant.COSTREPORT_PREFIX, "", "k", "i", "Landroid/view/ViewGroup$LayoutParams;", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "v", "Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/b;", "event", "t", "Landroid/view/MotionEvent;", "w", HippyTKDListViewAdapter.X, "Lh22/a;", "roomService", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/room/message/component/a;", "messageLayoutService", "Lcom/tencent/mobileqq/icgame/room/message/component/a;", "La42/e;", "clearScreenService", "La42/e;", "Lb42/b;", "audienceComponent", "Lb42/b;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends SingleUIComponent<LiveOwnerLikeView> {

    @InjectService(key = b42.b.class)
    private b42.b audienceComponent;

    @InjectService(key = e.class)
    private e clearScreenService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.message.component.a.class)
    private com.tencent.mobileqq.icgame.room.message.component.a messageLayoutService;

    @InjectService(key = h22.a.class)
    private h22.a roomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent, com.tencent.mobileqq.icgame.framework.component.i
    @NotNull
    public ViewGroup.LayoutParams f() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.xcz;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public LiveOwnerLikeView n() {
        return new LiveOwnerLikeView(getComponentContext().getContext(), null, 0, 6, null);
    }

    public final void t(@NotNull com.tencent.icgame.game.liveroom.impl.room.roomconfig.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE.b(event.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String().f396943b);
        p().q(event);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void u() {
        com.tencent.mobileqq.icgame.room.message.component.a aVar = this.messageLayoutService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageLayoutService");
            aVar = null;
        }
        z42.b a16 = aVar.a();
        ArrayList arrayList = new ArrayList();
        if (a16 instanceof ViewGroup) {
            arrayList.add(a16);
        }
        f fVar = f.f115408a;
        h22.a aVar3 = this.roomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomService");
            aVar3 = null;
        }
        fVar.d(aVar3.getRoomId(), arrayList);
        fVar.h(p());
        h22.a aVar4 = this.roomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomService");
            aVar4 = null;
        }
        LiveRoomExtraInfo extraInfo = aVar4.getExtraInfo();
        if (extraInfo != null) {
            LiveOwnerLikeView p16 = p();
            h22.a aVar5 = this.roomService;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomService");
            } else {
                aVar2 = aVar5;
            }
            p16.s(aVar2.getRoomId(), extraInfo);
        }
    }

    public final void v() {
        f.f115408a.e();
    }

    public final void w(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        h22.a aVar = this.roomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomService");
            aVar = null;
        }
        if (aVar.p()) {
            e eVar = this.clearScreenService;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clearScreenService");
                eVar = null;
            }
            if (!eVar.a()) {
                e eVar2 = this.clearScreenService;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearScreenService");
                    eVar2 = null;
                }
                if (eVar2.b()) {
                    f fVar = f.f115408a;
                    h22.a aVar3 = this.roomService;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roomService");
                    } else {
                        aVar2 = aVar3;
                    }
                    fVar.c(aVar2.getRoomId(), event);
                }
            }
        }
    }

    public final void x(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        h22.a aVar = this.roomService;
        e eVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomService");
            aVar = null;
        }
        if (aVar.p()) {
            e eVar2 = this.clearScreenService;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clearScreenService");
                eVar2 = null;
            }
            if (!eVar2.a()) {
                e eVar3 = this.clearScreenService;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearScreenService");
                } else {
                    eVar = eVar3;
                }
                if (eVar.b()) {
                    f.f115408a.i();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
