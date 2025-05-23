package com.tencent.state.template.map;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.state.data.Image;
import com.tencent.state.library.components.fragments.LibraryCalendarComponent;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.MapFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.map.MapViewConfigKt;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.map.MapViewModel;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH$J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\tH$J\b\u0010\u000f\u001a\u00020\u0010H\u0014J*\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J*\u0010\u001a\u001a\u00020\t2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J<\u0010\u001e\u001a\u00020\t2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J2\u0010\"\u001a\u00020\t2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u001c\u0010#\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0010H\u0016J*\u0010&\u001a\u00020\t2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0010H\u0014\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/template/map/TemplateMapFragment;", "V", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "VM", "Lcom/tencent/state/map/MapViewModel;", "Lcom/tencent/state/map/MapFragment;", "()V", "destroyTagManager", "", "getMapViewConfig", "Lcom/tencent/state/map/MapViewConfig;", "mapBackground", "Lcom/tencent/state/data/Image;", "initTagManager", "isZoomEnabled", "", "onCenterScaled", "isScaleToCenter", "view", "Landroid/view/View;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onItemBind", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "onItemClicked", "viewId", "extra", "", "onItemLongClick", "onItemRecordCover", "onMapZoom", "isZoomIn", "onZoomOverOut", "sendMapDataRequest", "isRefresh", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMapFragment<V extends BaseMapView<?>, VM extends MapViewModel> extends MapFragment<V, VM> {
    protected abstract void destroyTagManager();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public MapViewConfig getMapViewConfig(Image mapBackground) {
        Intrinsics.checkNotNullParameter(mapBackground, "mapBackground");
        MapViewConfig mapViewConfig = super.getMapViewConfig(mapBackground);
        mapViewConfig.setAvatarConfig(MapViewConfigKt.defaultFocusAnimaConfig());
        return mapViewConfig;
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    protected abstract void initTagManager();

    @Override // com.tencent.state.map.MapFragment
    protected boolean isZoomEnabled() {
        return false;
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(final boolean isScaleToCenter, final View view, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCenterScaled(isScaleToCenter, view, index, data);
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.TemplateMapFragment$onCenterScaled$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onCenterScaled(isScaleToCenter, view, index, data);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        destroyTagManager();
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onItemBind(final MapViewHolder<?> vh5, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.TemplateMapFragment$onItemBind$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemBind(MapViewHolder.this, index, data);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemClicked(final MapViewHolder<?> vh5, final int index, final MapItem data, final int viewId, final Object extra) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.TemplateMapFragment$onItemClicked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemClicked(MapViewHolder.this, index, data, viewId, extra);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemLongClick(final MapViewHolder<?> vh5, final int index, final MapItem data, final int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.TemplateMapFragment$onItemLongClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemLongClick(MapViewHolder.this, index, data, viewId);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecordCover(final MapItem data, final Object extra) {
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.TemplateMapFragment$onItemRecordCover$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemRecordCover(MapItem.this, extra);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoom(final boolean isZoomIn) {
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.TemplateMapFragment$onMapZoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMapZoom(isZoomIn);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onZoomOverOut(final MapViewHolder<?> vh5, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.TemplateMapFragment$onZoomOverOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onZoomOverOut(MapViewHolder.this, index, data);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        r12 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r12 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r12);
     */
    @Override // com.tencent.state.map.MapFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void sendMapDataRequest(boolean isRefresh) {
        Intent intent;
        String stringExtra;
        Intent intent2;
        Long longOrNull;
        Intent intent3;
        Long longOrNull2;
        if (isRefresh) {
            TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) getComponent(TemplateRoomComponent.class, null, null);
            if (templateRoomComponent != null) {
                TemplateRoomComponent.switchRoom$default(templateRoomComponent, null, null, 3, null);
            }
        } else {
            FragmentActivity activity = getActivity();
            long longValue = (activity == null || (intent3 = activity.getIntent()) == null || (r12 = intent3.getStringExtra("roomId")) == null || longOrNull2 == null) ? 0L : longOrNull2.longValue();
            FragmentActivity activity2 = getActivity();
            long longValue2 = (activity2 == null || (intent2 = activity2.getIntent()) == null || (r12 = intent2.getStringExtra("uin")) == null || longOrNull == null) ? 0L : longOrNull.longValue();
            FragmentActivity activity3 = getActivity();
            boolean parseBoolean = (activity3 == null || (intent = activity3.getIntent()) == null || (stringExtra = intent.getStringExtra(LauncherConst.KEY_OPEN_FOCUS_CALENDAR)) == null) ? false : Boolean.parseBoolean(stringExtra);
            if (longValue != 0) {
                TemplateRoomComponent templateRoomComponent2 = (TemplateRoomComponent) getComponent(TemplateRoomComponent.class, null, null);
                if (templateRoomComponent2 != null) {
                    TemplateRoomComponent.enterRoom$default(templateRoomComponent2, Long.valueOf(longValue), false, 2, null);
                }
            } else if (longValue2 != 0) {
                TemplateRoomComponent templateRoomComponent3 = (TemplateRoomComponent) getComponent(TemplateRoomComponent.class, null, null);
                if (templateRoomComponent3 != null) {
                    templateRoomComponent3.enterRoomByUin(Long.valueOf(longValue2));
                }
            } else if (parseBoolean) {
                LibraryCalendarComponent libraryCalendarComponent = (LibraryCalendarComponent) getComponent(LibraryCalendarComponent.class, null, null);
                if (libraryCalendarComponent != null) {
                    libraryCalendarComponent.openFocusCalendar();
                }
                TemplateRoomComponent templateRoomComponent4 = (TemplateRoomComponent) getComponent(TemplateRoomComponent.class, null, null);
                if (templateRoomComponent4 != null) {
                    TemplateRoomComponent.enterRoom$default(templateRoomComponent4, null, false, 3, null);
                }
            } else {
                TemplateRoomComponent templateRoomComponent5 = (TemplateRoomComponent) getComponent(TemplateRoomComponent.class, null, null);
                if (templateRoomComponent5 != null) {
                    TemplateRoomComponent.enterRoom$default(templateRoomComponent5, null, false, 3, null);
                }
            }
        }
        initTagManager();
    }
}
