package com.tencent.state.library.focus.component;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.ClickType;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.LibraryFocusTimeBubble;
import com.tencent.state.library.focus.view.LibraryTitleContainer;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareLibraryBubbleBinding;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import com.tencent.state.square.databinding.VasSquareLibrarySingleViewBinding;
import com.tencent.state.square.databinding.VasSquareLibraryTitleContainerBinding;
import com.tencent.state.template.data.User;
import com.tencent.state.view.SquareImageView;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusSingleReportComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibrarySingleViewBinding;", "calendarBubbleShow", "", "initElementReport", "", "initPageReport", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", "markCalendarBubbleShow", ViewStickEventHelper.IS_SHOW, "onComeOnButtonClicked", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFuncButtonClicked", "type", "Lcom/tencent/state/library/focus/view/ClickType;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusSingleReportComponent extends FocusBaseComponent {
    private VasSquareLibrarySingleViewBinding binding;
    private boolean calendarBubbleShow;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClickType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ClickType.CALENDAR.ordinal()] = 1;
            iArr[ClickType.END_FOCUS.ordinal()] = 2;
        }
    }

    private final void initPageReport(Fragment f16, View v3) {
        FocusItem singleItem;
        User user;
        String str;
        Map<String, Object> mutableMapOf;
        FocusBaseItem data = getData();
        if (data == null || (singleItem = data.getSingleItem()) == null || (user = singleItem.getUser()) == null) {
            return;
        }
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (str = fragment.getPageId()) == null) {
            str = "pg_zplan_library_single_focus";
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_zhutai_ketai", Integer.valueOf(!user.isMe() ? 1 : 0)), TuplesKt.to("zplan_other_user_qq", Long.valueOf(user.getInfo().getUin())));
        squareReporter.setPageInfo(f16, v3, str, mutableMapOf);
    }

    public final void markCalendarBubbleShow(boolean isShow) {
        this.calendarBubbleShow = isShow;
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onComeOnButtonClicked(User user) {
        FocusCommonView focusCommonView;
        VasSquareLibraryCommonViewBinding binding;
        LibraryFocusTimeBubble libraryFocusTimeBubble;
        VasSquareLibraryBubbleBinding binding2;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(user, "user");
        VasSquareLibrarySingleViewBinding vasSquareLibrarySingleViewBinding = this.binding;
        if (vasSquareLibrarySingleViewBinding == null || (focusCommonView = vasSquareLibrarySingleViewBinding.commonView) == null || (binding = focusCommonView.getBinding()) == null || (libraryFocusTimeBubble = binding.focusTimeBubble) == null || (binding2 = libraryFocusTimeBubble.getBinding()) == null) {
            return;
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout = binding2.singleLikeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.singleLikeView");
        Pair[] pairArr = new Pair[1];
        TextView textView = binding2.likeReddot;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.likeReddot");
        pairArr[0] = TuplesKt.to("zplan_is_there_a_red_dot_when_clicked", Integer.valueOf(ViewExtensionsKt.isVisible(textView) ? 1 : 2));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.reportEvent("clck", frameLayout, mutableMapOf);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareLibrarySingleViewBinding bind = VasSquareLibrarySingleViewBinding.bind(v3);
        this.binding = bind;
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquareLibrarySingleVi\u2026lso { this.binding = it }");
        initPageReport(f16, v3);
        initElementReport(bind);
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onFuncButtonClicked(ClickType type) {
        FocusCommonView focusCommonView;
        VasSquareLibraryCommonViewBinding binding;
        LibraryTitleContainer libraryTitleContainer;
        VasSquareLibraryTitleContainerBinding binding2;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(type, "type");
        VasSquareLibrarySingleViewBinding vasSquareLibrarySingleViewBinding = this.binding;
        if (vasSquareLibrarySingleViewBinding == null || (focusCommonView = vasSquareLibrarySingleViewBinding.commonView) == null || (binding = focusCommonView.getBinding()) == null || (libraryTitleContainer = binding.titleContainer) == null || (binding2 = libraryTitleContainer.getBinding()) == null) {
            return;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = binding2.endFocus;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.endFocus");
            squareReporter.reportEvent("clck", squareImageView, new LinkedHashMap());
            return;
        }
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = binding2.calendar;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.calendar");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, Integer.valueOf(this.calendarBubbleShow ? 1 : 0)));
        squareReporter2.reportEvent("clck", relativeLayout, mutableMapOf);
        this.calendarBubbleShow = false;
    }

    private final void initElementReport(VasSquareLibrarySingleViewBinding binding) {
        Map mutableMapOf;
        VasSquareLibraryTitleContainerBinding binding2 = binding.commonView.getBinding().titleContainer.getBinding();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = binding2.calendar;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "titleBinding.calendar");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, 0));
        IReporter.DefaultImpls.setElementInfo$default(squareReporter, relativeLayout, "em_zplan_focus_calendar_button", mutableMapOf, false, false, 16, null);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView = binding2.endFocus;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "titleBinding.endFocus");
        IReporter.DefaultImpls.setElementInfo$default(squareReporter2, squareImageView, "em_zplan_library_end_focus_btn", new LinkedHashMap(), false, false, 16, null);
        VasSquareLibraryBubbleBinding binding3 = binding.commonView.getBinding().focusTimeBubble.getBinding();
        IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout = binding3.singleLikeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bubbleBinding.singleLikeView");
        IReporter.DefaultImpls.setElementInfo$default(squareReporter3, frameLayout, "em_zplan_library_come_on_btn", new LinkedHashMap(), false, false, 16, null);
    }
}
