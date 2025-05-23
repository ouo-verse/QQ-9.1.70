package com.tencent.state.library.components.fragments;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.library.calendar.CalendarGuideManager;
import com.tencent.state.library.data.LibraryDecoratorItem;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.EntryDecorator;
import com.tencent.state.template.map.TemplateMapView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryQBookComponent$showQBookDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LibraryQBookComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.library.components.fragments.LibraryQBookComponent$showQBookDialog$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TemplateMapView mapView;
            mapView = LibraryQBookComponent$showQBookDialog$1.this.this$0.getMapView();
            if (mapView != null) {
                mapView.post(new Runnable() { // from class: com.tencent.state.library.components.fragments.LibraryQBookComponent.showQBookDialog.1.1.1
                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
                    
                        r1 = r4.this$0.this$0.this$0.getMapView();
                     */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.ArrayList] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        TemplateMapView mapView2;
                        TemplateMapView mapView3;
                        IMapViewManipulator manipulator;
                        MapAdapter adapter;
                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = new ArrayList();
                        mapView2 = LibraryQBookComponent$showQBookDialog$1.this.this$0.getMapView();
                        if (mapView2 != null && (adapter = mapView2.getAdapter()) != null) {
                            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryQBookComponent.showQBookDialog.1.1.1.1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                                    invoke(num.intValue(), mapItem);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i3, MapItem mapItem) {
                                    if (mapItem instanceof LibraryDecoratorItem) {
                                        Decorator decorator = ((LibraryDecoratorItem) mapItem).getDecorator();
                                        if (!(decorator instanceof EntryDecorator)) {
                                            decorator = null;
                                        }
                                        EntryDecorator entryDecorator = (EntryDecorator) decorator;
                                        if (entryDecorator != null) {
                                            String bookshelfAnimate = entryDecorator.getBookshelfAnimate();
                                            if (bookshelfAnimate == null || bookshelfAnimate.length() == 0) {
                                                return;
                                            }
                                            ((List) Ref.ObjectRef.this.element).add(Integer.valueOf(i3));
                                        }
                                    }
                                }
                            });
                        }
                        if (((List) objectRef.element).size() <= 0 || mapView3 == null || (manipulator = mapView3.getManipulator()) == null) {
                            return;
                        }
                        manipulator.locateTo(((Number) ((List) objectRef.element).get(0)).intValue(), new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryQBookComponent.showQBookDialog.1.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                TemplateMapView mapView4;
                                if (z16) {
                                    Iterator it = ((List) objectRef.element).iterator();
                                    while (it.hasNext()) {
                                        int intValue = ((Number) it.next()).intValue();
                                        mapView4 = LibraryQBookComponent$showQBookDialog$1.this.this$0.getMapView();
                                        if (mapView4 != null) {
                                            mapView4.notifyItemChangeWithPayload(intValue, 2);
                                        }
                                    }
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryQBookComponent$showQBookDialog$1(LibraryQBookComponent libraryQBookComponent) {
        super(0);
        this.this$0 = libraryQBookComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        QBaseActivity activity;
        boolean needShowQBookAvailableDialog;
        QBaseActivity activity2;
        activity = this.this$0.getActivity();
        if (activity == null || !activity.isFinishing()) {
            needShowQBookAvailableDialog = this.this$0.needShowQBookAvailableDialog();
            if (needShowQBookAvailableDialog) {
                CalendarGuideManager.INSTANCE.disableShowCalendarDialogOnce();
                this.this$0.setNeedShowQBookAvailableDialog(false);
                LibraryQBookComponent libraryQBookComponent = this.this$0;
                activity2 = libraryQBookComponent.getActivity();
                libraryQBookComponent.showQBookAvailableTip(activity2, new AnonymousClass1());
                return;
            }
            CalendarGuideManager.INSTANCE.continueShowCalendarDialog();
            return;
        }
        CalendarGuideManager.INSTANCE.resetDisableShowCalendarDialogOnce();
    }
}
