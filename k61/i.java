package k61;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderView;
import com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.BackgroundChangeEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.PartnerUpdateEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.UpdateQZoneIntimateSpaceEntranceInfoEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.UpdateTitlePartCurrentTypeLevelEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J*\u0010\u0011\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004H\u0014J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lk61/i;", "Lk61/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "r", "Landroid/view/View;", "containerView", "", "onInitView", "Lj61/a;", "data", "", "position", "", "payload", ReportConstant.COSTREPORT_PREFIX, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView;", "e", "Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView;", "intimateFriendInfoView", "<init>", "()V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i extends d implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IntimateHeaderView intimateFriendInfoView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"k61/i$b", "Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderView$b;", "", "isPartnerIntimate", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements IntimateHeaderView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderView.b
        public void a(boolean isPartnerIntimate) {
            SimpleEventBus.getInstance().dispatchEvent(new PartnerUpdateEvent(isPartnerIntimate));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"k61/i$c", "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$c;", "", "position", "", "onChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements QUICardStackView.c {
        c() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView.c
        public void onChanged(int position) {
            List r16 = i.this.r();
            if (position >= 0 && position < r16.size()) {
                int type = ((com.tencent.mobileqq.activity.aio.intimate.header.g) r16.get(position)).getType();
                j61.d dVar = j61.d.f409515a;
                if (dVar.b() != type) {
                    SimpleEventBus.getInstance().dispatchEvent(new BackgroundChangeEvent(type, ((com.tencent.mobileqq.activity.aio.intimate.header.g) r16.get(position)).getLevel()));
                }
                dVar.f(type);
                com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a.j(dVar.c(), type);
                IntimateHeaderView intimateHeaderView = i.this.intimateFriendInfoView;
                if (intimateHeaderView != null) {
                    intimateHeaderView.setCurrentType(type);
                }
                QLog.i("IntimateFriendInfoSection", 1, "currentType_change: " + type);
                SimpleEventBus.getInstance().dispatchEvent(new UpdateTitlePartCurrentTypeLevelEvent(type, ((com.tencent.mobileqq.activity.aio.intimate.header.g) r16.get(position)).getLevel(), ((com.tencent.mobileqq.activity.aio.intimate.header.g) r16.get(position)).getFlag()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.activity.aio.intimate.header.g> r() {
        ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g> E;
        IntimateHeaderView intimateHeaderView = this.intimateFriendInfoView;
        if (intimateHeaderView == null || (E = intimateHeaderView.E()) == null) {
            return new ArrayList();
        }
        return E;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateQZoneIntimateSpaceEntranceInfoEvent.class);
        return arrayListOf;
    }

    @Override // k61.d, h61.a
    public void k() {
        IntimateHeaderView intimateHeaderView = this.intimateFriendInfoView;
        if (intimateHeaderView != null) {
            intimateHeaderView.o();
        }
    }

    @Override // k61.d, h61.a
    public void m() {
        IntimateHeaderView intimateHeaderView = this.intimateFriendInfoView;
        if (intimateHeaderView != null) {
            intimateHeaderView.setCurrentType(0);
        }
        IntimateHeaderView intimateHeaderView2 = this.intimateFriendInfoView;
        if (intimateHeaderView2 != null) {
            intimateHeaderView2.n();
        }
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        IntimateHeaderView intimateHeaderView = this.intimateFriendInfoView;
        if (intimateHeaderView != null) {
            intimateHeaderView.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView instanceof IntimateHeaderView) {
            IntimateHeaderView intimateHeaderView = (IntimateHeaderView) containerView;
            this.intimateFriendInfoView = intimateHeaderView;
            if (intimateHeaderView != null) {
                intimateHeaderView.o();
            }
            IntimateHeaderView intimateHeaderView2 = this.intimateFriendInfoView;
            if (intimateHeaderView2 != null) {
                intimateHeaderView2.setClipChildren(false);
            }
            IntimateHeaderView intimateHeaderView3 = this.intimateFriendInfoView;
            if (intimateHeaderView3 != null) {
                intimateHeaderView3.setPartnerListener(new b());
            }
            IntimateHeaderView intimateHeaderView4 = this.intimateFriendInfoView;
            if (intimateHeaderView4 != null) {
                intimateHeaderView4.setTabChangeListener(new c());
            }
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IntimateHeaderView intimateHeaderView;
        if ((event instanceof UpdateQZoneIntimateSpaceEntranceInfoEvent) && (intimateHeaderView = this.intimateFriendInfoView) != null) {
            intimateHeaderView.C(((UpdateQZoneIntimateSpaceEntranceInfoEvent) event).getInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            IntimateHeaderView intimateHeaderView = this.intimateFriendInfoView;
            if (intimateHeaderView != null) {
                intimateHeaderView.setFriendUin(data.getFriendUin());
            }
            IntimateHeaderView intimateHeaderView2 = this.intimateFriendInfoView;
            if (intimateHeaderView2 != null) {
                intimateHeaderView2.r(data.getIntimateInfo(), data.getFriendIntimateType());
            }
        }
    }
}
