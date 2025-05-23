package k61;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.GetLoverValueEvent;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantLoveEntranceView;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J*\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017`\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lk61/q;", "Lk61/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "p", "Landroid/view/View;", "containerView", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "e", "Z", "hasOpened", "Lcom/tencent/mobileqq/activity/aio/intimate/view/ElegantLoveEntranceView;", "f", "Lcom/tencent/mobileqq/activity/aio/intimate/view/ElegantLoveEntranceView;", "loverEntranceView", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class q extends d implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasOpened;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ElegantLoveEntranceView loverEntranceView;

    private final void p() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_couplearea", j61.d.f409515a.d(), null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GetLoverValueEvent.class);
        return arrayListOf;
    }

    @Override // k61.d, h61.a
    public void k() {
        this.hasOpened = true;
        ElegantLoveEntranceView elegantLoveEntranceView = this.loverEntranceView;
        if (elegantLoveEntranceView != null) {
            elegantLoveEntranceView.u();
        }
        ElegantLoveEntranceView elegantLoveEntranceView2 = this.loverEntranceView;
        if (elegantLoveEntranceView2 != null) {
            elegantLoveEntranceView2.o();
        }
    }

    @Override // k61.d, h61.a
    public void m() {
        ElegantLoveEntranceView elegantLoveEntranceView = this.loverEntranceView;
        if (elegantLoveEntranceView != null) {
            elegantLoveEntranceView.n();
        }
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ElegantLoveEntranceView elegantLoveEntranceView = this.loverEntranceView;
        if (elegantLoveEntranceView != null) {
            elegantLoveEntranceView.m();
        }
        this.loverEntranceView = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView instanceof ElegantLoveEntranceView) {
            ElegantLoveEntranceView elegantLoveEntranceView = (ElegantLoveEntranceView) containerView;
            this.loverEntranceView = elegantLoveEntranceView;
            if (elegantLoveEntranceView != null) {
                elegantLoveEntranceView.o();
            }
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (!(event instanceof GetLoverValueEvent)) {
            return;
        }
        GetLoverValueEvent getLoverValueEvent = (GetLoverValueEvent) event;
        if (getLoverValueEvent.getIsSuccess()) {
            ElegantLoveEntranceView elegantLoveEntranceView = this.loverEntranceView;
            if (elegantLoveEntranceView != null) {
                elegantLoveEntranceView.w(getLoverValueEvent.getWording(), getLoverValueEvent.getValue(), getLoverValueEvent.getUrl());
                return;
            }
            return;
        }
        ElegantLoveEntranceView elegantLoveEntranceView2 = this.loverEntranceView;
        if (elegantLoveEntranceView2 != null) {
            elegantLoveEntranceView2.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        ElegantLoveEntranceView elegantLoveEntranceView;
        if (data != null) {
            ElegantLoveEntranceView elegantLoveEntranceView2 = this.loverEntranceView;
            if (elegantLoveEntranceView2 != null) {
                elegantLoveEntranceView2.r(data.getIntimateInfo(), data.getFriendIntimateType());
            }
            if (this.hasOpened && (elegantLoveEntranceView = this.loverEntranceView) != null) {
                elegantLoveEntranceView.t();
            }
            p();
        }
    }
}
