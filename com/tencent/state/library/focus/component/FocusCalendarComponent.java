package com.tencent.state.library.focus.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.library.calendar.CalendarEntryConfig;
import com.tencent.state.library.calendar.CalendarEntryManager;
import com.tencent.state.library.calendar.CalendarGuideManager;
import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.IFocusParentView;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.view.ClickType;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.LibraryTitleContainer;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import com.tencent.state.square.databinding.VasSquareLibraryTitleContainerBinding;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusCalendarComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryTitleContainerBinding;", "entryManager", "Lcom/tencent/state/library/calendar/CalendarEntryManager;", "onCalendarEntryClick", "", "onFragmentResumed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "showTaskGuideIfNeed", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusCalendarComponent extends FocusBaseComponent {
    private static final String TAG = "LibraryCalendarComponent";
    private VasSquareLibraryTitleContainerBinding binding;
    private final CalendarEntryManager entryManager = new CalendarEntryManager();

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCalendarEntryClick() {
        FocusCalendarComponent$onCalendarEntryClick$1 focusCalendarComponent$onCalendarEntryClick$1 = new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.component.FocusCalendarComponent$onCalendarEntryClick$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IFocusEventListener iFocusEventListener) {
                invoke2(iFocusEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IFocusEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onFuncButtonClicked(ClickType.CALENDAR);
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(IFocusEventListener.class, null, null, focusCalendarComponent$onCalendarEntryClick$1);
        }
    }

    private final void showTaskGuideIfNeed() {
        CalendarGuideManager.INSTANCE.getCalendarGuideForFocus(new FocusCalendarComponent$showTaskGuideIfNeed$1(this));
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fm5, Fragment f16) {
        FocusBaseFragment focusFragment;
        IFocusParentView fragmentView;
        FocusCommonView commonView;
        VasSquareLibraryCommonViewBinding binding;
        LibraryTitleContainer libraryTitleContainer;
        VasSquareLibraryTitleContainerBinding binding2;
        Bundle arguments;
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentResumed(fm5, f16);
        FocusBaseItem data = getData();
        if (data == null || !FocusDataKt.hasMe(data) || (focusFragment = getFocusFragment()) == null || (fragmentView = focusFragment.getFragmentView()) == null || (commonView = fragmentView.getCommonView()) == null || (binding = commonView.getBinding()) == null || (libraryTitleContainer = binding.titleContainer) == null || (binding2 = libraryTitleContainer.getBinding()) == null) {
            return;
        }
        this.binding = binding2;
        this.entryManager.initEntryView(binding2.calendar, binding2.calendarRedDot, new FocusCalendarComponent$onFragmentResumed$1(this));
        VasBaseFragment fragment = getFragment();
        Serializable serializable = (fragment == null || (arguments = fragment.getArguments()) == null) ? null : arguments.getSerializable(FocusBaseFragment.KEY_CALENDAR_CONFIG);
        CalendarEntryConfig calendarEntryConfig = (CalendarEntryConfig) (serializable instanceof CalendarEntryConfig ? serializable : null);
        SquareBaseKt.getSquareLog().i(TAG, "onFragmentViewCreated: config=" + calendarEntryConfig);
        if (calendarEntryConfig != null) {
            this.entryManager.setEntryConfig(calendarEntryConfig);
            if (calendarEntryConfig.isShowEntry()) {
                showTaskGuideIfNeed();
            }
        }
    }
}
