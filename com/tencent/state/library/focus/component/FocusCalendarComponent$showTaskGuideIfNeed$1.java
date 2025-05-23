package com.tencent.state.library.focus.component;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.library.view.ToastPopupPosition;
import com.tencent.state.library.view.ToastPopupWindow;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareLibraryTitleContainerBinding;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/library/focus/component/FocusCalendarComponent$showTaskGuideIfNeed$1", "Lcom/tencent/state/service/ResultCallback;", "", "onResultSuccess", "", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusCalendarComponent$showTaskGuideIfNeed$1 implements ResultCallback<String> {
    final /* synthetic */ FocusCalendarComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusCalendarComponent$showTaskGuideIfNeed$1(FocusCalendarComponent focusCalendarComponent) {
        this.this$0 = focusCalendarComponent;
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
    public void onResultSuccess(final String result) {
        SquareBaseKt.getSquareThread().postOnUiDelayed(200L, new Function0<Unit>() { // from class: com.tencent.state.library.focus.component.FocusCalendarComponent$showTaskGuideIfNeed$1$onResultSuccess$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
            
                r0 = r14.this$0.this$0.binding;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
            
                r0 = r14.this$0.this$0.getActivity();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                VasSquareLibraryTitleContainerBinding vasSquareLibraryTitleContainerBinding;
                RelativeLayout btn;
                QBaseActivity activity;
                WeakReference<VasBaseFragmentComponentGroup> parent;
                VasBaseFragment vasBaseFragment;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                WeakReference<VasBaseFragmentComponentGroup> parent2;
                VasBaseFragment vasBaseFragment2;
                FragmentComponent component$default2;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
                VasBaseFragment fragment;
                String str = result;
                if (str == null || vasSquareLibraryTitleContainerBinding == null || (btn = vasSquareLibraryTitleContainerBinding.calendar) == null || activity == null || activity.isFinishing()) {
                    return;
                }
                FocusCalendarComponent focusCalendarComponent = FocusCalendarComponent$showTaskGuideIfNeed$1.this.this$0;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(focusCalendarComponent instanceof VasBaseFragmentComponentGroup) ? null : focusCalendarComponent);
                if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(FocusSingleReportComponent.class, null)) == null) && (((parent = focusCalendarComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(FocusSingleReportComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) focusCalendarComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, FocusSingleReportComponent.class, null, null, 2, null)) == null))) {
                    VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) focusCalendarComponent).parentFragment;
                    component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, FocusSingleReportComponent.class, null, null, 6, null) : null;
                }
                FocusSingleReportComponent focusSingleReportComponent = (FocusSingleReportComponent) component$default;
                if (focusSingleReportComponent != null) {
                    focusSingleReportComponent.markCalendarBubbleShow(true);
                }
                FocusCalendarComponent focusCalendarComponent2 = FocusCalendarComponent$showTaskGuideIfNeed$1.this.this$0;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(focusCalendarComponent2 instanceof VasBaseFragmentComponentGroup) ? null : focusCalendarComponent2);
                if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(FocusGroupReportComponent.class, null)) == null) && (((parent2 = focusCalendarComponent2.getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(FocusGroupReportComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) focusCalendarComponent2).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, FocusGroupReportComponent.class, null, null, 2, null)) == null))) {
                    VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) focusCalendarComponent2).parentFragment;
                    component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, FocusGroupReportComponent.class, null, null, 6, null) : null;
                }
                FocusGroupReportComponent focusGroupReportComponent = (FocusGroupReportComponent) component$default2;
                if (focusGroupReportComponent != null) {
                    focusGroupReportComponent.markCalendarBubbleShow(true);
                }
                Intrinsics.checkNotNullExpressionValue(btn, "btn");
                Context context = btn.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "btn.context");
                ToastPopupPosition toastPopupPosition = ToastPopupPosition.Below;
                int parseColor = Color.parseColor("#FFFFFFFF");
                int parseColor2 = Color.parseColor("#E5262626");
                int dip = ViewExtensionsKt.dip(btn.getContext(), 12);
                fragment = FocusCalendarComponent$showTaskGuideIfNeed$1.this.this$0.getFragment();
                new ToastPopupWindow(context, toastPopupPosition, str, parseColor, parseColor2, dip, 5000L, SquareReportConst.ElementId.ELEMENT_ID_CALENDAR_BUTTON_IMP, fragment != null ? fragment.getPageId() : null).showAsDropDown(btn);
            }
        });
    }
}
