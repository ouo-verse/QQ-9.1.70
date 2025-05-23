package com.tencent.state.library.components.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.library.calendar.CalendarEntryConfig;
import com.tencent.state.library.calendar.CalendarEntryManager;
import com.tencent.state.library.calendar.CalendarGuideManager;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.library.view.ToastPopupPosition;
import com.tencent.state.library.view.ToastPopupWindow;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareHippyMethodObserver;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import com.tencent.state.template.data.CommonConfig;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.TemplateMapViewKt;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J,\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010%\u001a\u00020\u000eJ\u0006\u0010\f\u001a\u00020\u000eJ\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryCalendarComponent;", "Lcom/tencent/state/library/components/fragments/LibraryBaseComponent;", "Lcom/tencent/state/square/api/ISquareHippyMethodObserver;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentLibraryBinding;", "entryManager", "Lcom/tencent/state/library/calendar/CalendarEntryManager;", "hasShowFirstGuide", "", "needCheckGuideWhenResume", "needCheckGuideWhenSeatUpdate", LauncherConst.KEY_OPEN_FOCUS_CALENDAR, "onCalendarEntryClick", "", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentPaused", "onFragmentResumed", "onFragmentViewCreated", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onMethodCall", "method", "", "readableMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "onUpdateSeatButtonState", "showCalendarDialog", "showCalendarGuideAfterAppear", "showTaskGuideIfNeed", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryCalendarComponent extends LibraryBaseComponent implements ISquareHippyMethodObserver {
    public static final String METHOD_HIPPY_AWARD_LIBRARY_MOTION = "awardLibraryMotion";
    private static final String TAG = "LibraryCalendarComponent";
    private VasSquareFragmentLibraryBinding binding;
    private final CalendarEntryManager entryManager = new CalendarEntryManager();
    private boolean hasShowFirstGuide;
    private boolean needCheckGuideWhenResume;
    private boolean needCheckGuideWhenSeatUpdate;
    private boolean openFocusCalendar;

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCalendarEntryClick() {
        LibraryCalendarComponent$onCalendarEntryClick$1 libraryCalendarComponent$onCalendarEntryClick$1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$onCalendarEntryClick$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onCalendarButtonClicked();
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(ITemplateMapEvent.class, null, null, libraryCalendarComponent$onCalendarEntryClick$1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCalendarDialog() {
        Map<String, Object> mutableMapOf;
        final FrameLayout frameLayout;
        CalendarGuideManager calendarGuideManager = CalendarGuideManager.INSTANCE;
        if (calendarGuideManager.enableShowCalendarGuide()) {
            this.hasShowFirstGuide = calendarGuideManager.needShowCalendarGuideAtFirst();
            VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
            if (vasSquareFragmentLibraryBinding == null || (frameLayout = vasSquareFragmentLibraryBinding.calendar) == null) {
                return;
            }
            SquareBaseKt.getSquareThread().postOnUiDelayed(200L, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$showCalendarDialog$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final QBaseActivity activity;
                    VasBaseFragment fragment;
                    VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding2;
                    FrameLayout it;
                    activity = this.getActivity();
                    if (activity != null) {
                        fragment = this.getFragment();
                        if ((fragment == null || fragment.isTopFragment()) && !activity.isFinishing() && activity.hasWindowFocus()) {
                            final Rect rect = new Rect();
                            frameLayout.getGlobalVisibleRect(rect);
                            vasSquareFragmentLibraryBinding2 = this.binding;
                            if (vasSquareFragmentLibraryBinding2 == null || (it = vasSquareFragmentLibraryBinding2.getMRv()) == null) {
                                return;
                            }
                            CalendarGuideManager calendarGuideManager2 = CalendarGuideManager.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            calendarGuideManager2.showCalendarGuideAtFirst(it, rect, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$showCalendarDialog$$inlined$let$lambda$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    CalendarEntryManager calendarEntryManager;
                                    calendarEntryManager = this.entryManager;
                                    calendarEntryManager.openFocusCalendarPage(activity);
                                }
                            }, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$showCalendarDialog$$inlined$let$lambda$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    this.hasShowFirstGuide = CalendarGuideManager.INSTANCE.needShowCalendarGuideAtFirst();
                                    this.onUpdateSeatButtonState();
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        if (FocusDialogTips.INSTANCE.showCalendarDialog(getActivity(), new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$showCalendarDialog$onConfirm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CalendarEntryManager calendarEntryManager;
                QBaseActivity activity;
                Map<String, Object> mutableMapOf2;
                calendarEntryManager = LibraryCalendarComponent.this.entryManager;
                activity = LibraryCalendarComponent.this.getActivity();
                calendarEntryManager.openFocusCalendarPage(activity);
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 0));
                squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_LIBRARY_CALENDAR_DIALOG, mutableMapOf2);
            }
        }, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$showCalendarDialog$onCancel$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map<String, Object> mutableMapOf2;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 1));
                squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_LIBRARY_CALENDAR_DIALOG, mutableMapOf2);
            }
        })) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
            squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_LIBRARY_CALENDAR_DIALOG, mutableMapOf);
        }
    }

    private final void showCalendarGuideAfterAppear() {
        CalendarGuideManager.INSTANCE.showNewMotionIfNeed(new ResultCallback<String>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$showCalendarGuideAfterAppear$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
            
                r0 = r13.this$0.getActivity();
             */
            @Override // com.tencent.state.service.ResultCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResultSuccess(String result) {
                boolean z16;
                boolean z17;
                TemplateMapView mapView;
                VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding;
                LinearLayout btn;
                QBaseActivity activity;
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                WeakReference<VasBaseFragmentComponentGroup> parent2;
                FragmentComponent fragmentComponent2;
                FragmentComponent component$default2;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
                if (result != null) {
                    mapView = LibraryCalendarComponent.this.getMapView();
                    FragmentComponent fragmentComponent3 = null;
                    if (!TemplateMapViewKt.isMeSeated(mapView)) {
                        vasSquareFragmentLibraryBinding = LibraryCalendarComponent.this.binding;
                        if (vasSquareFragmentLibraryBinding == null || (btn = vasSquareFragmentLibraryBinding.seatButton) == null || activity == null || activity.isFinishing()) {
                            return;
                        }
                        LibraryCalendarComponent libraryCalendarComponent = LibraryCalendarComponent.this;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(libraryCalendarComponent instanceof VasBaseFragmentComponentGroup) ? null : libraryCalendarComponent);
                        if ((vasBaseFragmentComponentGroup3 == null || (fragmentComponent = vasBaseFragmentComponentGroup3.getComponent(LibraryReportComponent.class, null)) == null) && ((parent = libraryCalendarComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(LibraryReportComponent.class, null)) == null)) {
                            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) libraryCalendarComponent).fragment;
                            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, LibraryReportComponent.class, null, null, 2, null)) == null) {
                                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) libraryCalendarComponent).parentFragment;
                                if (vasBaseFragment2 != null) {
                                    fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, LibraryReportComponent.class, null, null, 6, null);
                                }
                            } else {
                                fragmentComponent3 = component$default;
                            }
                            fragmentComponent = fragmentComponent3;
                        }
                        LibraryReportComponent libraryReportComponent = (LibraryReportComponent) fragmentComponent;
                        if (libraryReportComponent != null) {
                            libraryReportComponent.markSeatBubbleShow(true);
                        }
                        Intrinsics.checkNotNullExpressionValue(btn, "btn");
                        Context context = btn.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "btn.context");
                        new ToastPopupWindow(context, ToastPopupPosition.Above, result, Color.parseColor("#FF774B2E"), Color.parseColor("#FFFFF6E7"), ViewExtensionsKt.dip(btn.getContext(), 12), 0L, SquareReportConst.ElementId.ELEMENT_ID_SEAT_BUTTON_IMP, SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE).showAsDropDown(btn);
                        return;
                    }
                    LibraryCalendarComponent libraryCalendarComponent2 = LibraryCalendarComponent.this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(libraryCalendarComponent2 instanceof VasBaseFragmentComponentGroup) ? null : libraryCalendarComponent2);
                    if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent2 = vasBaseFragmentComponentGroup4.getComponent(LibraryUiComponent.class, null)) == null) && ((parent2 = libraryCalendarComponent2.getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent2 = vasBaseFragmentComponentGroup2.getComponent(LibraryUiComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) libraryCalendarComponent2).fragment;
                        if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, LibraryUiComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) libraryCalendarComponent2).parentFragment;
                            if (vasBaseFragment4 != null) {
                                fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, LibraryUiComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent3 = component$default2;
                        }
                        fragmentComponent2 = fragmentComponent3;
                    }
                    LibraryUiComponent libraryUiComponent = (LibraryUiComponent) fragmentComponent2;
                    if (libraryUiComponent != null) {
                        libraryUiComponent.backToMySeat();
                        return;
                    }
                    return;
                }
                z16 = LibraryCalendarComponent.this.needCheckGuideWhenResume;
                if (z16) {
                    z17 = LibraryCalendarComponent.this.hasShowFirstGuide;
                    if (z17) {
                        return;
                    }
                    LibraryCalendarComponent.this.needCheckGuideWhenResume = false;
                    LibraryCalendarComponent.this.showTaskGuideIfNeed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTaskGuideIfNeed() {
        VasBaseFragment fragment = getFragment();
        if (fragment == null || fragment.isTopFragment()) {
            CalendarGuideManager.INSTANCE.getCalendarGuideForLibrary(new LibraryCalendarComponent$showTaskGuideIfNeed$1(this));
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        RoomConfig config;
        CommonConfig config2;
        Intrinsics.checkNotNullParameter(info, "info");
        CommonRoomInfo room = info.getRoom();
        CalendarEntryConfig calendarConfig = (room == null || (config = room.getConfig()) == null || (config2 = config.getConfig()) == null) ? null : config2.getCalendarConfig();
        SquareBaseKt.getSquareLog().i(TAG, "onEnterRoom: config=" + calendarConfig);
        if (calendarConfig == null) {
            return;
        }
        this.entryManager.setEntryConfig(calendarConfig);
        if (!calendarConfig.isShowEntry() || info.getIsReenter()) {
            return;
        }
        CalendarGuideManager calendarGuideManager = CalendarGuideManager.INSTANCE;
        calendarGuideManager.setCalendarGuideConfig(calendarConfig.getGuideConfig());
        if (this.openFocusCalendar) {
            this.openFocusCalendar = false;
            this.entryManager.openFocusCalendarPage(getActivity());
        } else {
            calendarGuideManager.tryShowCalendarGuideDialogAfterQBookGuideDialog(new Runnable() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$onEnterRoom$1
                @Override // java.lang.Runnable
                public final void run() {
                    LibraryCalendarComponent.this.showCalendarDialog();
                }
            });
            this.needCheckGuideWhenSeatUpdate = true;
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentDestroyed(fm5, f16);
        Square.INSTANCE.getConfig().getHippyEngine().removeMethodObserver(this);
        CalendarGuideManager.INSTANCE.resetDisableShowCalendarDialogOnce();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPaused(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentPaused(fm5, f16);
        this.needCheckGuideWhenSeatUpdate = false;
        this.needCheckGuideWhenResume = true;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentResumed(fm5, f16);
        showCalendarGuideAfterAppear();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareFragmentLibraryBinding bind = VasSquareFragmentLibraryBinding.bind(v3);
        this.binding = bind;
        this.entryManager.initEntryView(bind != null ? bind.calendar : null, bind != null ? bind.calendarRedDot : null, new LibraryCalendarComponent$onFragmentViewCreated$1(this));
        Square.INSTANCE.getConfig().getHippyEngine().addMethodObserver(this);
    }

    @Override // com.tencent.state.square.api.ISquareHippyMethodObserver
    public void onMethodCall(String method, HippyMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        SquareBaseKt.getSquareLog().i(TAG, "onMethodCall method:" + method);
        if (method.hashCode() == 1788562676 && method.equals(METHOD_HIPPY_AWARD_LIBRARY_MOTION)) {
            CalendarGuideManager.INSTANCE.markNewMotion(true);
        }
    }

    public final void onUpdateSeatButtonState() {
        LinearLayout linearLayout;
        VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
        if (vasSquareFragmentLibraryBinding == null || (linearLayout = vasSquareFragmentLibraryBinding.seatButton) == null || linearLayout.getVisibility() != 0 || !this.needCheckGuideWhenSeatUpdate || this.hasShowFirstGuide) {
            return;
        }
        this.needCheckGuideWhenSeatUpdate = false;
        showTaskGuideIfNeed();
    }

    public final void openFocusCalendar() {
        this.openFocusCalendar = true;
    }
}
