package com.tencent.state.library.components.fragments;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.library.calendar.CalendarGuideMessage;
import com.tencent.state.library.view.ToastPopupPosition;
import com.tencent.state.library.view.ToastPopupWindow;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/library/components/fragments/LibraryCalendarComponent$showTaskGuideIfNeed$1", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/library/calendar/CalendarGuideMessage;", "onResultSuccess", "", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryCalendarComponent$showTaskGuideIfNeed$1 implements ResultCallback<CalendarGuideMessage> {
    final /* synthetic */ LibraryCalendarComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LibraryCalendarComponent$showTaskGuideIfNeed$1(LibraryCalendarComponent libraryCalendarComponent) {
        this.this$0 = libraryCalendarComponent;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str, String str2) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(final CalendarGuideMessage result) {
        Intrinsics.checkNotNullParameter(result, "result");
        SquareBaseKt.getSquareThread().postOnUiDelayed(200L, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryCalendarComponent$showTaskGuideIfNeed$1$onResultSuccess$1
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

            /* JADX WARN: Code restructure failed: missing block: B:24:0x00de, code lost:
            
                r1 = r28.this$0.this$0.binding;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x00ec, code lost:
            
                r2 = r28.this$0.this$0.getActivity();
             */
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
            
                r2 = r28.this$0.this$0.binding;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
            
                r2 = r28.this$0.this$0.getActivity();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                String str;
                Object obj;
                VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding;
                LinearLayout btn;
                QBaseActivity activity;
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent component$default;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default2;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding2;
                FrameLayout btn2;
                QBaseActivity activity2;
                WeakReference<VasBaseFragmentComponentGroup> parent2;
                VasBaseFragment vasBaseFragment;
                FragmentComponent component$default3;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
                String focusTips = result.getFocusTips();
                if (focusTips == null || vasSquareFragmentLibraryBinding2 == null || (btn2 = vasSquareFragmentLibraryBinding2.calendar) == null || activity2 == null || activity2.isFinishing()) {
                    str = "btn.context";
                    obj = LibraryReportComponent.class;
                } else {
                    LibraryCalendarComponent libraryCalendarComponent = LibraryCalendarComponent$showTaskGuideIfNeed$1.this.this$0;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(libraryCalendarComponent instanceof VasBaseFragmentComponentGroup) ? null : libraryCalendarComponent);
                    if ((vasBaseFragmentComponentGroup3 == null || (component$default3 = vasBaseFragmentComponentGroup3.getComponent(LibraryReportComponent.class, null)) == null) && (((parent2 = libraryCalendarComponent.getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default3 = vasBaseFragmentComponentGroup2.getComponent(LibraryReportComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) libraryCalendarComponent).fragment) == null || (component$default3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, LibraryReportComponent.class, null, null, 2, null)) == null))) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) libraryCalendarComponent).parentFragment;
                        component$default3 = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, LibraryReportComponent.class, null, null, 6, null) : null;
                    }
                    LibraryReportComponent libraryReportComponent = (LibraryReportComponent) component$default3;
                    if (libraryReportComponent != null) {
                        libraryReportComponent.markCalendarBubbleShow(true);
                    }
                    Intrinsics.checkNotNullExpressionValue(btn2, "btn");
                    Context context = btn2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "btn.context");
                    str = "btn.context";
                    obj = LibraryReportComponent.class;
                    new ToastPopupWindow(context, ToastPopupPosition.Below, focusTips, Color.parseColor("#FFFFFFFF"), Color.parseColor("#E5262626"), ViewExtensionsKt.dip(btn2.getContext(), 12), 5000L, SquareReportConst.ElementId.ELEMENT_ID_CALENDAR_BUTTON_IMP, SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE).showAsDropDown(btn2);
                }
                String seatTips = result.getSeatTips();
                if (seatTips == null || vasSquareFragmentLibraryBinding == null || (btn = vasSquareFragmentLibraryBinding.seatButton) == null || activity == null || activity.isFinishing()) {
                    return;
                }
                LibraryCalendarComponent libraryCalendarComponent2 = LibraryCalendarComponent$showTaskGuideIfNeed$1.this.this$0;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(libraryCalendarComponent2 instanceof VasBaseFragmentComponentGroup) ? null : libraryCalendarComponent2);
                if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent = vasBaseFragmentComponentGroup4.getComponent(obj, null)) == null) && ((parent = libraryCalendarComponent2.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(obj, null)) == null)) {
                    VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) libraryCalendarComponent2).fragment;
                    if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, LibraryReportComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) libraryCalendarComponent2).parentFragment;
                        component$default = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, LibraryReportComponent.class, null, null, 6, null) : null;
                    } else {
                        component$default = component$default2;
                    }
                    fragmentComponent = component$default;
                }
                LibraryReportComponent libraryReportComponent2 = (LibraryReportComponent) fragmentComponent;
                if (libraryReportComponent2 != null) {
                    libraryReportComponent2.markSeatBubbleShow(true);
                }
                Intrinsics.checkNotNullExpressionValue(btn, "btn");
                Context context2 = btn.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, str);
                new ToastPopupWindow(context2, ToastPopupPosition.Above, seatTips, Color.parseColor("#FF774B2E"), Color.parseColor("#FFFFF6E7"), ViewExtensionsKt.dip(btn.getContext(), 12), 0L, SquareReportConst.ElementId.ELEMENT_ID_SEAT_BUTTON_IMP, SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE).showAsDropDown(btn);
            }
        });
    }
}
