package k61;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.MutualMarkCardUpdateEvent;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateElegantCardView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00140\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lk61/h;", "Lk61/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "containerView", "", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", "p", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "onBackEvent", "Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateElegantCardView;", "e", "Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateElegantCardView;", "intimateElegantCardView", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h extends d implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IntimateElegantCardView intimateElegantCardView;

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(MutualMarkCardUpdateEvent.class);
        return arrayListOf;
    }

    @Override // k61.d, h61.a
    public void k() {
        IntimateElegantCardView intimateElegantCardView = this.intimateElegantCardView;
        if (intimateElegantCardView != null) {
            intimateElegantCardView.o();
        }
    }

    @Override // k61.d, h61.a
    public void m() {
        IntimateElegantCardView intimateElegantCardView = this.intimateElegantCardView;
        if (intimateElegantCardView != null) {
            intimateElegantCardView.n();
        }
    }

    @Override // k61.d, h61.b
    public boolean onBackEvent() {
        IntimateElegantCardView intimateElegantCardView = this.intimateElegantCardView;
        if (intimateElegantCardView != null) {
            return intimateElegantCardView.Q();
        }
        return false;
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IntimateElegantCardView intimateElegantCardView = this.intimateElegantCardView;
        if (intimateElegantCardView != null) {
            intimateElegantCardView.m();
        }
        this.intimateElegantCardView = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView instanceof IntimateElegantCardView) {
            IntimateElegantCardView intimateElegantCardView = (IntimateElegantCardView) containerView;
            this.intimateElegantCardView = intimateElegantCardView;
            if (intimateElegantCardView != null) {
                intimateElegantCardView.o();
            }
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IntimateElegantCardView intimateElegantCardView;
        if ((event instanceof MutualMarkCardUpdateEvent) && (intimateElegantCardView = this.intimateElegantCardView) != null) {
            MutualMarkCardUpdateEvent mutualMarkCardUpdateEvent = (MutualMarkCardUpdateEvent) event;
            intimateElegantCardView.R(mutualMarkCardUpdateEvent.getChangedCardIndex(), mutualMarkCardUpdateEvent.getIsWear());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            IntimateElegantCardView intimateElegantCardView = this.intimateElegantCardView;
            if (intimateElegantCardView != null) {
                intimateElegantCardView.setFriendUin(data.getFriendUin());
            }
            IntimateElegantCardView intimateElegantCardView2 = this.intimateElegantCardView;
            if (intimateElegantCardView2 != null) {
                intimateElegantCardView2.r(data.getIntimateInfo(), data.getFriendIntimateType());
            }
        }
    }
}
