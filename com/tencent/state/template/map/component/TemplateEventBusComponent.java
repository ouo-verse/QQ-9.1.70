package com.tencent.state.template.map.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.detail.event.DetailCommonBackEvent;
import com.tencent.state.template.event.GlobalMeFocusStartSquareEvent;
import com.tencent.state.template.event.RefreshDeskMateTagEvent;
import com.tencent.state.template.event.SwitchTableEvent;
import com.tencent.state.utils.EventBusUtilsKt;
import com.tencent.state.utils.IEventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007`\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001fH\u0002J<\u0010 \u001a\u00020\u000e22\u0010!\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b`\tH&R:\u0010\u0005\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/template/map/component/TemplateEventBusComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "eventMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "getEventClass", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onDetailCommonBackEvent", "", "event", "Lcom/tencent/state/square/detail/event/DetailCommonBackEvent;", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onGlobalMeFocusStart", "Lcom/tencent/state/template/event/GlobalMeFocusStartSquareEvent;", "onReceiveEvent", "onRefreshDeskMateTag", "Lcom/tencent/state/template/event/RefreshDeskMateTagEvent;", "onSwitchTable", "Lcom/tencent/state/template/event/SwitchTableEvent;", "registerEvent", "map", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateEventBusComponent extends TemplateMapBaseComponent implements SimpleEventReceiver<SimpleBaseEvent> {
    private final HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> eventMap;

    public TemplateEventBusComponent() {
        HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> hashMap = new HashMap<>();
        EventBusUtilsKt.register(hashMap, RefreshDeskMateTagEvent.class, new Function1<RefreshDeskMateTagEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateEventBusComponent$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RefreshDeskMateTagEvent refreshDeskMateTagEvent) {
                invoke2(refreshDeskMateTagEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RefreshDeskMateTagEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TemplateEventBusComponent.this.onRefreshDeskMateTag(it);
            }
        });
        EventBusUtilsKt.register(hashMap, SwitchTableEvent.class, new Function1<SwitchTableEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateEventBusComponent$$special$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SwitchTableEvent switchTableEvent) {
                invoke2(switchTableEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SwitchTableEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TemplateEventBusComponent.this.onSwitchTable(it);
            }
        });
        EventBusUtilsKt.register(hashMap, GlobalMeFocusStartSquareEvent.class, new Function1<GlobalMeFocusStartSquareEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateEventBusComponent$$special$$inlined$apply$lambda$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GlobalMeFocusStartSquareEvent globalMeFocusStartSquareEvent) {
                invoke2(globalMeFocusStartSquareEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GlobalMeFocusStartSquareEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TemplateEventBusComponent.this.onGlobalMeFocusStart(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailCommonBackEvent.class, new Function1<DetailCommonBackEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateEventBusComponent$$special$$inlined$apply$lambda$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailCommonBackEvent detailCommonBackEvent) {
                invoke2(detailCommonBackEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailCommonBackEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TemplateEventBusComponent.this.onDetailCommonBackEvent(it);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.eventMap = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDetailCommonBackEvent(DetailCommonBackEvent event) {
        TemplateUiComponent templateUiComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (templateUiComponent = (TemplateUiComponent) fragment.getComponent(TemplateUiComponent.class, null, null)) == null) {
            return;
        }
        templateUiComponent.toggleSeatButtonVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGlobalMeFocusStart(GlobalMeFocusStartSquareEvent event) {
        TemplateSitComponent templateSitComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (templateSitComponent = (TemplateSitComponent) VasBaseLifecycleFragment.getComponent$default(fragment, TemplateSitComponent.class, null, null, 6, null)) == null) {
            return;
        }
        templateSitComponent.handleGlobalMeFocusStart(event.getType(), event.getUser(), event.getTableId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRefreshDeskMateTag(RefreshDeskMateTagEvent event) {
        TemplateUiComponent templateUiComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (templateUiComponent = (TemplateUiComponent) VasBaseLifecycleFragment.getComponent$default(fragment, TemplateUiComponent.class, null, null, 6, null)) == null) {
            return;
        }
        templateUiComponent.updateDeskMateTag(event.getUin(), event.getDeskMateTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSwitchTable(SwitchTableEvent event) {
        TemplateUiComponent templateUiComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (templateUiComponent = (TemplateUiComponent) fragment.getComponent(TemplateUiComponent.class, null, null)) == null) {
            return;
        }
        templateUiComponent.switchSelfTable(event.getTableId(), event.getUser(), event.getFromFocusFragment());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.addAll(this.eventMap.keySet());
        return arrayList;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentDestroyed(fm5, f16);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public abstract void registerEvent(HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> map);

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        IEventHandler iEventHandler;
        if (event == null || (iEventHandler = this.eventMap.get(event.getClass())) == null) {
            return;
        }
        iEventHandler.handleEvent(event);
    }
}
