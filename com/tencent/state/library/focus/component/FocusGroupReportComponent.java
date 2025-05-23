package com.tencent.state.library.focus.component;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.ClickType;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.FocusGroupView;
import com.tencent.state.library.focus.view.LibraryFocusTimeBubble;
import com.tencent.state.library.focus.view.LibraryTitleContainer;
import com.tencent.state.library.view.LibraryTableView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareLibraryBubbleBinding;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import com.tencent.state.square.databinding.VasSquareLibraryGroupBinding;
import com.tencent.state.square.databinding.VasSquareLibraryGroupViewBinding;
import com.tencent.state.square.databinding.VasSquareLibrarySingleBubbleBinding;
import com.tencent.state.square.databinding.VasSquareLibraryTitleContainerBinding;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J,\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020!H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/library/focus/component/FocusGroupReportComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryGroupBinding;", "calendarBubbleShow", "", "clickView", "Landroid/view/View;", "decorator", "initElementReport", "", "initPageReport", "f", "Landroidx/fragment/app/Fragment;", "v", "markCalendarBubbleShow", ViewStickEventHelper.IS_SHOW, "onChatBoxClicked", "onComeOnButtonClicked", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onEmptyTableClicked", "type", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFuncButtonClicked", "Lcom/tencent/state/library/focus/view/ClickType;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class FocusGroupReportComponent extends FocusBaseComponent {
    private VasSquareLibraryGroupBinding binding;
    private boolean calendarBubbleShow;
    private View clickView;
    private View decorator;

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
        String str;
        Map<String, Object> mutableMapOf;
        UserCommon info;
        UserCommon info2;
        FocusBaseItem data = getData();
        if (data != null) {
            VasBaseFragment fragment = getFragment();
            if (fragment == null || (str = fragment.getPageId()) == null) {
                str = "pg_zplan_library_double_focus";
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("zplan_zhutai_ketai", Integer.valueOf(!FocusDataKt.hasMe(data) ? 1 : 0));
            User user = data.getItem().getUser();
            long j3 = 0;
            pairArr[1] = TuplesKt.to("zplan_desk1_user_qq", Long.valueOf((user == null || (info2 = user.getInfo()) == null) ? 0L : info2.getUin()));
            User user2 = data.getRightItem().getUser();
            if (user2 != null && (info = user2.getInfo()) != null) {
                j3 = info.getUin();
            }
            pairArr[2] = TuplesKt.to("zplan_desk2_user_qq", Long.valueOf(j3));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            squareReporter.setPageInfo(f16, v3, str, mutableMapOf);
        }
    }

    public final void markCalendarBubbleShow(boolean isShow) {
        this.calendarBubbleShow = isShow;
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onChatBoxClicked(View v3) {
        FocusGroupView focusGroupView;
        VasSquareLibraryGroupViewBinding binding;
        LinearLayout linearLayout;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        if (vasSquareLibraryGroupBinding == null || (focusGroupView = vasSquareLibraryGroupBinding.groupView) == null || (binding = focusGroupView.getBinding()) == null || (linearLayout = binding.customChatBox) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(linearLayout, "this.binding?.groupView?\u2026?.customChatBox ?: return");
        if (Intrinsics.areEqual(v3, linearLayout)) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_allow_click", 1));
            squareReporter.reportEvent("clck", linearLayout, mutableMapOf);
        }
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onComeOnButtonClicked(User user) {
        FocusGroupView focusGroupView;
        VasSquareLibraryGroupViewBinding binding;
        FocusCommonView focusCommonView;
        VasSquareLibraryCommonViewBinding binding2;
        LibraryFocusTimeBubble libraryFocusTimeBubble;
        VasSquareLibraryBubbleBinding binding3;
        VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding;
        VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding2;
        Map<String, Object> mutableMapOf;
        Table table;
        Table table2;
        Intrinsics.checkNotNullParameter(user, "user");
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        if (vasSquareLibraryGroupBinding == null || (focusGroupView = vasSquareLibraryGroupBinding.groupView) == null || (binding = focusGroupView.getBinding()) == null || (focusCommonView = binding.commonView) == null || (binding2 = focusCommonView.getBinding()) == null || (libraryFocusTimeBubble = binding2.focusTimeBubble) == null || (binding3 = libraryFocusTimeBubble.getBinding()) == null) {
            return;
        }
        SitDownInfo sitDown = user.getSitDown();
        if (sitDown != null && (table2 = sitDown.getTable()) != null && table2.isLeft()) {
            vasSquareLibrarySingleBubbleBinding = binding3.leftBubble;
        } else {
            vasSquareLibrarySingleBubbleBinding = binding3.rightBubble;
        }
        FrameLayout frameLayout = vasSquareLibrarySingleBubbleBinding.likeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "if (user.sitDown?.table?\u2026ding.rightBubble.likeView");
        SitDownInfo sitDown2 = user.getSitDown();
        if (sitDown2 != null && (table = sitDown2.getTable()) != null && table.isLeft()) {
            vasSquareLibrarySingleBubbleBinding2 = binding3.leftBubble;
        } else {
            vasSquareLibrarySingleBubbleBinding2 = binding3.rightBubble;
        }
        TextView textView = vasSquareLibrarySingleBubbleBinding2.likeReddot;
        Intrinsics.checkNotNullExpressionValue(textView, "if (user.sitDown?.table?\u2026ng.rightBubble.likeReddot");
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("zplan_other_user_qq", Long.valueOf(user.getInfo().getUin()));
        pairArr[1] = TuplesKt.to("zplan_is_red_dot_when_clicked", Integer.valueOf(ViewExtensionsKt.isVisible(textView) ? 1 : 2));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.reportEvent("clck", frameLayout, mutableMapOf);
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onEmptyTableClicked(int type, FocusItem item) {
        View view;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(item, "item");
        if (type == 1) {
            view = this.decorator;
        } else {
            view = this.clickView;
        }
        if (view != null) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            Pair[] pairArr = new Pair[1];
            FocusBaseItem data = getData();
            pairArr[0] = TuplesKt.to("zplan_is_seated_or_share", Integer.valueOf((data == null || !FocusDataKt.hasMe(data)) ? 0 : 1));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            squareReporter.reportEvent("clck", view, mutableMapOf);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareLibraryGroupBinding bind = VasSquareLibraryGroupBinding.bind(v3);
        this.binding = bind;
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquareLibraryGroupBin\u2026lso { this.binding = it }");
        initPageReport(f16, v3);
        initElementReport(bind);
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onFuncButtonClicked(ClickType type) {
        FocusGroupView focusGroupView;
        VasSquareLibraryGroupViewBinding binding;
        FocusCommonView focusCommonView;
        VasSquareLibraryCommonViewBinding binding2;
        LibraryTitleContainer libraryTitleContainer;
        VasSquareLibraryTitleContainerBinding binding3;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(type, "type");
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        if (vasSquareLibraryGroupBinding == null || (focusGroupView = vasSquareLibraryGroupBinding.groupView) == null || (binding = focusGroupView.getBinding()) == null || (focusCommonView = binding.commonView) == null || (binding2 = focusCommonView.getBinding()) == null || (libraryTitleContainer = binding2.titleContainer) == null || (binding3 = libraryTitleContainer.getBinding()) == null) {
            return;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = binding3.endFocus;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.endFocus");
            squareReporter.reportEvent("clck", squareImageView, new LinkedHashMap());
            return;
        }
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = binding3.calendar;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.calendar");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, Integer.valueOf(this.calendarBubbleShow ? 1 : 0)));
        squareReporter2.reportEvent("clck", relativeLayout, mutableMapOf);
        this.calendarBubbleShow = false;
    }

    private final void initElementReport(VasSquareLibraryGroupBinding binding) {
        Map mutableMapOf;
        Map mutableMapOf2;
        Map mutableMapOf3;
        Map mutableMapOf4;
        Map mutableMapOf5;
        FocusBaseItem data;
        LibraryTableView libraryTableView;
        LibraryTableView libraryTableView2;
        Map mutableMapOf6;
        FocusItem singleItem;
        FocusItem rightItem;
        User user;
        UserCommon info;
        FocusItem item;
        User user2;
        UserCommon info2;
        FocusItem singleItem2;
        User user3;
        UserCommon info3;
        VasSquareLibraryTitleContainerBinding binding2 = binding.groupView.getBinding().commonView.getBinding().titleContainer.getBinding();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = binding2.calendar;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "titleBinding.calendar");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, 0));
        IReporter.DefaultImpls.setElementInfo$default(squareReporter, relativeLayout, "em_zplan_focus_calendar_button", mutableMapOf, false, false, 16, null);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView = binding2.endFocus;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "titleBinding.endFocus");
        IReporter.DefaultImpls.setElementInfo$default(squareReporter2, squareImageView, "em_zplan_library_end_focus_btn", new LinkedHashMap(), false, false, 16, null);
        VasSquareLibraryBubbleBinding binding3 = binding.groupView.getBinding().commonView.getBinding().focusTimeBubble.getBinding();
        IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout = binding3.singleLikeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bubbleBinding.singleLikeView");
        Pair[] pairArr = new Pair[1];
        FocusBaseItem data2 = getData();
        long j3 = 0;
        pairArr[0] = TuplesKt.to("zplan_other_user_qq", Long.valueOf((data2 == null || (singleItem2 = data2.getSingleItem()) == null || (user3 = singleItem2.getUser()) == null || (info3 = user3.getInfo()) == null) ? 0L : info3.getUin()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr);
        IReporter.DefaultImpls.setElementInfo$default(squareReporter3, frameLayout, "em_zplan_library_come_on_btn", mutableMapOf2, false, false, 16, null);
        IReporter squareReporter4 = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout2 = binding3.leftBubble.likeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "bubbleBinding.leftBubble.likeView");
        Pair[] pairArr2 = new Pair[1];
        FocusBaseItem data3 = getData();
        pairArr2[0] = TuplesKt.to("zplan_other_user_qq", Long.valueOf((data3 == null || (item = data3.getItem()) == null || (user2 = item.getUser()) == null || (info2 = user2.getInfo()) == null) ? 0L : info2.getUin()));
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(pairArr2);
        IReporter.DefaultImpls.setElementInfo$default(squareReporter4, frameLayout2, "em_zplan_library_come_on_btn", mutableMapOf3, false, false, 16, null);
        IReporter squareReporter5 = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout3 = binding3.rightBubble.likeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "bubbleBinding.rightBubble.likeView");
        Pair[] pairArr3 = new Pair[1];
        FocusBaseItem data4 = getData();
        if (data4 != null && (rightItem = data4.getRightItem()) != null && (user = rightItem.getUser()) != null && (info = user.getInfo()) != null) {
            j3 = info.getUin();
        }
        pairArr3[0] = TuplesKt.to("zplan_other_user_qq", Long.valueOf(j3));
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(pairArr3);
        IReporter.DefaultImpls.setElementInfo$default(squareReporter5, frameLayout3, "em_zplan_library_come_on_btn", mutableMapOf4, false, false, 16, null);
        VasSquareLibraryGroupViewBinding binding4 = binding.groupView.getBinding();
        FocusBaseItem data5 = getData();
        if (data5 != null && data5.isSingleUser()) {
            FocusBaseItem data6 = getData();
            Table table = (data6 == null || (singleItem = data6.getSingleItem()) == null) ? null : singleItem.getTable();
            if (table != null && table.isLeft()) {
                libraryTableView = binding4.rightTab;
            } else {
                libraryTableView = binding4.leftTab;
            }
            ImageView decorator = libraryTableView.getDecorator();
            if (table != null && table.isLeft()) {
                libraryTableView2 = binding4.rightTab;
            } else {
                libraryTableView2 = binding4.leftTab;
            }
            View clickView = libraryTableView2.getClickView();
            IReporter squareReporter6 = SquareBaseKt.getSquareReporter();
            Pair[] pairArr4 = new Pair[1];
            FocusBaseItem data7 = getData();
            pairArr4[0] = TuplesKt.to("zplan_is_seated_or_share", Integer.valueOf((data7 == null || !FocusDataKt.hasMe(data7)) ? 0 : 1));
            mutableMapOf6 = MapsKt__MapsKt.mutableMapOf(pairArr4);
            IReporter.DefaultImpls.setElementInfo$default(squareReporter6, decorator, "em_zplan_empty_desk_seated_or_share", mutableMapOf6, false, false, 16, null);
            IReporter.DefaultImpls.setElementInfo$default(SquareBaseKt.getSquareReporter(), clickView, "em_zplan_empty_desk", new LinkedHashMap(), false, false, 16, null);
            this.decorator = decorator;
            this.clickView = clickView;
        }
        FocusBaseItem data8 = getData();
        boolean z16 = (data8 == null || !FocusDataKt.hasMe(data8) || (data = getData()) == null || data.isSingleUser()) ? false : true;
        IReporter squareReporter7 = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = binding.groupView.getBinding().customChatBox;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.groupView.binding.customChatBox");
        Pair[] pairArr5 = new Pair[1];
        pairArr5[0] = TuplesKt.to("zplan_is_allow_click", Integer.valueOf(z16 ? 1 : 2));
        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(pairArr5);
        IReporter.DefaultImpls.setElementInfo$default(squareReporter7, linearLayout, "em_zplan_bottom_chat_box", mutableMapOf5, false, false, 16, null);
    }
}
