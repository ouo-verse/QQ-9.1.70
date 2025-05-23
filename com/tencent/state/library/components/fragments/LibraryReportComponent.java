package com.tencent.state.library.components.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.library.LibraryMapViewModel;
import com.tencent.state.library.data.LibraryAvatarItem;
import com.tencent.state.library.data.LibraryDecoratorItem;
import com.tencent.state.library.data.LibraryTableItem;
import com.tencent.state.library.holder.LibraryAvatarViewHolder;
import com.tencent.state.library.holder.LibraryImageViewHolder;
import com.tencent.state.library.holder.LibraryTableViewHolder;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.EntryDecorator;
import com.tencent.state.template.data.SeatButtonState;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.TemplateMapViewKt;
import com.tencent.state.view.SquareImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u000bH\u0016J,\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J*\u0010%\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0002\b\u00030&j\u0002`'2\u0006\u0010(\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010)H\u0016J<\u0010*\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0002\b\u00030&j\u0002`'2\u0006\u0010(\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00102\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u00103\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0013H\u0002J\u0018\u00104\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u001bH\u0002J\f\u00105\u001a\u00020\b*\u000200H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryReportComponent;", "Lcom/tencent/state/library/components/fragments/LibraryBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentLibraryBinding;", "calendarBubbleShow", "", "lastButtonType", "", "seatBubbleShow", "initAvatarReport", "", "vh", "Lcom/tencent/state/library/holder/LibraryAvatarViewHolder;", "data", "Lcom/tencent/state/library/data/LibraryAvatarItem;", "initElementReport", "initImageReport", "Lcom/tencent/state/library/holder/LibraryImageViewHolder;", "Lcom/tencent/state/library/data/LibraryDecoratorItem;", "initPageReport", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", "initTableReport", "Lcom/tencent/state/library/holder/LibraryTableViewHolder;", "Lcom/tencent/state/library/data/LibraryTableItem;", "markCalendarBubbleShow", ViewStickEventHelper.IS_SHOW, "markSeatBubbleShow", "onCalendarButtonClicked", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onItemBind", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "Lcom/tencent/state/map/MapItem;", "onItemClicked", "viewId", "extra", "", "onSeatButtonChanged", "state", "Lcom/tencent/state/template/data/SeatButtonState;", "onSeatButtonClicked", "reportAvatarClick", "reportImageClick", "reportTableClick", "getSeatButtonType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryReportComponent extends LibraryBaseComponent {
    private VasSquareFragmentLibraryBinding binding;
    private boolean calendarBubbleShow;
    private int lastButtonType = -1;
    private boolean seatBubbleShow;

    private final int getSeatButtonType(SeatButtonState seatButtonState) {
        if (seatButtonState.isMeSeated()) {
            return 2;
        }
        return seatButtonState.isRoomFull() ? 1 : 0;
    }

    private final void initAvatarReport(final LibraryAvatarViewHolder vh5, final LibraryAvatarItem data) {
        Resource resource;
        Table table;
        SitDownInfo sitDown = data.getUser().getSitDown();
        final int i3 = (sitDown == null || (table = sitDown.getTable()) == null || !table.getHasNeighbor()) ? 1 : 2;
        SitDownInfo sitDown2 = data.getUser().getSitDown();
        final int i16 = (sitDown2 == null || (resource = sitDown2.getResource()) == null || resource.getIsDefault()) ? 0 : 1;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View view = vh5.getBinding().hitArea;
        Intrinsics.checkNotNullExpressionValue(view, "vh.binding.hitArea");
        squareReporter.setElementInfo(view, "em_zplan_library_avatar_icon", new LinkedHashMap(), false, false);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = vh5.getBinding().bubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "vh.binding.bubble");
        squareReporter2.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_USER_ICON, new LinkedHashMap(), false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryReportComponent$initAvatarReport$1
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
                Map<String, Object> mutableMapOf;
                Map<String, Object> mutableMapOf2;
                IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
                View view2 = LibraryAvatarViewHolder.this.getBinding().hitArea;
                Intrinsics.checkNotNullExpressionValue(view2, "vh.binding.hitArea");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_desk_num", Integer.valueOf(i3)), TuplesKt.to(SquareReportConst.Key.KEY_AVATAR_TYPE, Integer.valueOf(i16)));
                squareReporter3.reportEvent("imp", view2, mutableMapOf);
                IReporter squareReporter4 = SquareBaseKt.getSquareReporter();
                RelativeLayout relativeLayout2 = LibraryAvatarViewHolder.this.getBinding().bubble;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "vh.binding.bubble");
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", data.getUser().getUin()));
                squareReporter4.reportEvent("imp", relativeLayout2, mutableMapOf2);
            }
        });
    }

    private final void initImageReport(final LibraryImageViewHolder vh5, LibraryDecoratorItem data) {
        Decorator decorator = data.getDecorator();
        if (!(decorator instanceof EntryDecorator)) {
            decorator = null;
        }
        EntryDecorator entryDecorator = (EntryDecorator) decorator;
        if (entryDecorator != null) {
            final String reportKey = entryDecorator.getReportKey();
            if (reportKey == null) {
                reportKey = "empty_key";
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = vh5.getBinding().image;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "vh.binding.image");
            squareReporter.setElementInfo(squareImageView, "em_zplan_bookshelf", new LinkedHashMap(), false, false);
            SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryReportComponent$initImageReport$1
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
                    Map<String, Object> mutableMapOf;
                    IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                    SquareImageView squareImageView2 = LibraryImageViewHolder.this.getBinding().image;
                    Intrinsics.checkNotNullExpressionValue(squareImageView2, "vh.binding.image");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_LIBRARY_BOOKSHELF_NUM, reportKey));
                    squareReporter2.reportEvent("imp", squareImageView2, mutableMapOf);
                }
            });
        }
    }

    private final void initPageReport(Fragment f16, View v3) {
        String str;
        String str2;
        Map<String, Object> mutableMapOf;
        Intent intent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (str = fragment.getPageId()) == null) {
            str = SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE;
        }
        QBaseActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str2 = intent.getStringExtra("subReferer")) == null) {
            str2 = "";
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_library_entrance_channel", str2));
        squareReporter.setPageInfo(f16, v3, str, mutableMapOf);
    }

    private final void initTableReport(final LibraryTableViewHolder vh5, LibraryTableItem data) {
        final int i3 = data.getTable().getHasNeighbor() ? 2 : 1;
        SquareBaseKt.getSquareReporter().setElementInfo(vh5.getBinding().tableView.getClickView(), "em_zplan_library_homepage_empty_desk", new LinkedHashMap(), false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryReportComponent$initTableReport$1
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
                TemplateMapView mapView;
                Map<String, Object> mutableMapOf;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                View clickView = vh5.getBinding().tableView.getClickView();
                mapView = LibraryReportComponent.this.getMapView();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_desk_num", Integer.valueOf(i3)), TuplesKt.to(SquareReportConst.Key.KEY_LIBRARY_ME_FOCUS, Integer.valueOf(TemplateMapViewKt.isMeSeated(mapView) ? 1 : 0)));
                squareReporter.reportEvent("imp", clickView, mutableMapOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSeatButtonChanged(SeatButtonState state) {
        int seatButtonType;
        Map<String, Object> mutableMapOf;
        VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
        if (vasSquareFragmentLibraryBinding == null || (seatButtonType = getSeatButtonType(state)) == this.lastButtonType) {
            return;
        }
        this.lastButtonType = seatButtonType;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = vasSquareFragmentLibraryBinding.seatButton;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.seatButton");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_btn_type", Integer.valueOf(seatButtonType)));
        squareReporter.reportEvent("imp", linearLayout, mutableMapOf);
    }

    private final void reportAvatarClick(LibraryAvatarViewHolder vh5, LibraryAvatarItem data) {
        Map<String, Object> mutableMapOf;
        Resource resource;
        Table table;
        SitDownInfo sitDown = data.getUser().getSitDown();
        int i3 = (sitDown == null || (table = sitDown.getTable()) == null || !table.getHasNeighbor()) ? 1 : 2;
        SitDownInfo sitDown2 = data.getUser().getSitDown();
        int i16 = (sitDown2 == null || (resource = sitDown2.getResource()) == null || resource.getIsDefault()) ? 0 : 1;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View view = vh5.getBinding().hitArea;
        Intrinsics.checkNotNullExpressionValue(view, "vh.binding.hitArea");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_desk_num", Integer.valueOf(i3)), TuplesKt.to(SquareReportConst.Key.KEY_AVATAR_TYPE, Integer.valueOf(i16)));
        squareReporter.reportEvent("clck", view, mutableMapOf);
    }

    private final void reportImageClick(LibraryImageViewHolder vh5, LibraryDecoratorItem data) {
        Map<String, Object> mutableMapOf;
        Decorator decorator = data.getDecorator();
        if (!(decorator instanceof EntryDecorator)) {
            decorator = null;
        }
        EntryDecorator entryDecorator = (EntryDecorator) decorator;
        if (entryDecorator != null) {
            String reportKey = entryDecorator.getReportKey();
            if (reportKey == null) {
                reportKey = "empty_key";
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = vh5.getBinding().image;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "vh.binding.image");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_LIBRARY_BOOKSHELF_NUM, reportKey));
            squareReporter.reportEvent("clck", squareImageView, mutableMapOf);
        }
    }

    private final void reportTableClick(LibraryTableViewHolder vh5, LibraryTableItem data) {
        Map<String, Object> mutableMapOf;
        int i3 = data.getTable().getHasNeighbor() ? 2 : 1;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View clickView = vh5.getBinding().tableView.getClickView();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_desk_num", Integer.valueOf(i3)), TuplesKt.to(SquareReportConst.Key.KEY_LIBRARY_ME_FOCUS, Integer.valueOf(TemplateMapViewKt.isMeSeated(getMapView()) ? 1 : 0)));
        squareReporter.reportEvent("clck", clickView, mutableMapOf);
    }

    public final void markCalendarBubbleShow(boolean isShow) {
        this.calendarBubbleShow = isShow;
    }

    public final void markSeatBubbleShow(boolean isShow) {
        this.seatBubbleShow = isShow;
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onCalendarButtonClicked() {
        Map<String, Object> mutableMapOf;
        VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
        if (vasSquareFragmentLibraryBinding != null) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            FrameLayout frameLayout = vasSquareFragmentLibraryBinding.calendar;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.calendar");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, Integer.valueOf(this.calendarBubbleShow ? 1 : 0)));
            squareReporter.reportEvent("clck", frameLayout, mutableMapOf);
            this.calendarBubbleShow = false;
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareFragmentLibraryBinding bind = VasSquareFragmentLibraryBinding.bind(v3);
        this.binding = bind;
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquareFragmentLibrary\u2026lso { this.binding = it }");
        initPageReport(f16, v3);
        initElementReport(bind);
        ViewModel viewModel = new ViewModelProvider(f16).get(LibraryMapViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(f)[Lib\u2026MapViewModel::class.java]");
        ((LibraryMapViewModel) viewModel).getSeatButtonState().observe(f16.getViewLifecycleOwner(), new Observer<SeatButtonState>() { // from class: com.tencent.state.library.components.fragments.LibraryReportComponent$onFragmentViewCreated$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(SeatButtonState it) {
                LibraryReportComponent libraryReportComponent = LibraryReportComponent.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                libraryReportComponent.onSeatButtonChanged(it);
            }
        });
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (vh5 instanceof LibraryAvatarViewHolder) {
            LibraryAvatarViewHolder libraryAvatarViewHolder = (LibraryAvatarViewHolder) vh5;
            if (!(data instanceof LibraryAvatarItem)) {
                data = null;
            }
            LibraryAvatarItem libraryAvatarItem = (LibraryAvatarItem) data;
            if (libraryAvatarItem != null) {
                initAvatarReport(libraryAvatarViewHolder, libraryAvatarItem);
                return;
            }
            return;
        }
        if (vh5 instanceof LibraryTableViewHolder) {
            LibraryTableViewHolder libraryTableViewHolder = (LibraryTableViewHolder) vh5;
            if (!(data instanceof LibraryTableItem)) {
                data = null;
            }
            LibraryTableItem libraryTableItem = (LibraryTableItem) data;
            if (libraryTableItem != null) {
                initTableReport(libraryTableViewHolder, libraryTableItem);
                return;
            }
            return;
        }
        if (vh5 instanceof LibraryImageViewHolder) {
            LibraryImageViewHolder libraryImageViewHolder = (LibraryImageViewHolder) vh5;
            if (!(data instanceof LibraryDecoratorItem)) {
                data = null;
            }
            LibraryDecoratorItem libraryDecoratorItem = (LibraryDecoratorItem) data;
            if (libraryDecoratorItem != null) {
                initImageReport(libraryImageViewHolder, libraryDecoratorItem);
            }
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        String str;
        Map<String, Object> mutableMapOf;
        User user;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (viewId == 3) {
            if (((LibraryAvatarViewHolder) (!(vh5 instanceof LibraryAvatarViewHolder) ? null : vh5)) != null) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                RelativeLayout relativeLayout = ((LibraryAvatarViewHolder) vh5).getBinding().bubble;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "vh.binding.bubble");
                Pair[] pairArr = new Pair[1];
                if (!(data instanceof LibraryAvatarItem)) {
                    data = null;
                }
                LibraryAvatarItem libraryAvatarItem = (LibraryAvatarItem) data;
                if (libraryAvatarItem == null || (user = libraryAvatarItem.getUser()) == null || (str = user.getUin()) == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("zplan_other_user_qq", str);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                squareReporter.reportEvent("clck", relativeLayout, mutableMapOf);
                return;
            }
            return;
        }
        if (extra != null) {
            return;
        }
        if (vh5 instanceof LibraryAvatarViewHolder) {
            LibraryAvatarViewHolder libraryAvatarViewHolder = (LibraryAvatarViewHolder) vh5;
            if (!(data instanceof LibraryAvatarItem)) {
                data = null;
            }
            LibraryAvatarItem libraryAvatarItem2 = (LibraryAvatarItem) data;
            if (libraryAvatarItem2 != null) {
                reportAvatarClick(libraryAvatarViewHolder, libraryAvatarItem2);
                return;
            }
            return;
        }
        if (vh5 instanceof LibraryTableViewHolder) {
            LibraryTableViewHolder libraryTableViewHolder = (LibraryTableViewHolder) vh5;
            if (!(data instanceof LibraryTableItem)) {
                data = null;
            }
            LibraryTableItem libraryTableItem = (LibraryTableItem) data;
            if (libraryTableItem != null) {
                reportTableClick(libraryTableViewHolder, libraryTableItem);
                return;
            }
            return;
        }
        if (vh5 instanceof LibraryImageViewHolder) {
            LibraryImageViewHolder libraryImageViewHolder = (LibraryImageViewHolder) vh5;
            if (!(data instanceof LibraryDecoratorItem)) {
                data = null;
            }
            LibraryDecoratorItem libraryDecoratorItem = (LibraryDecoratorItem) data;
            if (libraryDecoratorItem != null) {
                reportImageClick(libraryImageViewHolder, libraryDecoratorItem);
            }
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onSeatButtonClicked(SeatButtonState state) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(state, "state");
        VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding = this.binding;
        if (vasSquareFragmentLibraryBinding != null) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            LinearLayout linearLayout = vasSquareFragmentLibraryBinding.seatButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.seatButton");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_btn_type", Integer.valueOf(getSeatButtonType(state))), TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, Integer.valueOf(this.seatBubbleShow ? 1 : 0)));
            squareReporter.reportEvent("clck", linearLayout, mutableMapOf);
            this.seatBubbleShow = false;
        }
    }

    private final void initElementReport(VasSquareFragmentLibraryBinding binding) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        FrameLayout frameLayout = binding.calendar;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.calendar");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, 0));
        IReporter.DefaultImpls.setElementInfo$default(squareReporter, frameLayout, "em_zplan_focus_calendar_button", mutableMapOf, false, false, 16, null);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = binding.seatButton;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.seatButton");
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_FLY_BUBBLE_GUIDE, 0));
        squareReporter2.setElementInfo(linearLayout, "em_zplan_bottom_btn", mutableMapOf2, false, false);
    }
}
