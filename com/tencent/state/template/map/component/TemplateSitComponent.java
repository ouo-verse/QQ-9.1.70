package com.tencent.state.template.map.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseFragmentKt;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.common.tag.BaseTagPanel;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.common.tag.ITagPanelListener;
import com.tencent.state.event.Event;
import com.tencent.state.library.LibraryFragment;
import com.tencent.state.library.calendar.CalendarEntryConfig;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.view.LibraryCalendarGuideView;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import com.tencent.state.template.activity.TemplateActivityViewModel;
import com.tencent.state.template.data.CommonConfig;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.Stall;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.event.FocusType;
import com.tencent.state.template.event.GlobalMeFocusStartSquareEvent;
import com.tencent.state.template.fragment.TemplateCommonOperateComponent;
import com.tencent.state.template.fragment.TemplateShareComponent;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.item.TemplateTableItem;
import com.tencent.state.template.map.TemplateMapFragment;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.TemplateMapViewKt;
import com.tencent.state.template.service.ITemplateRoomService;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u0000 W2\u00020\u0001:\u0001WB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H&J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J.\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H&J\u001a\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0019\u001a\u00020'H\u0002J\u001c\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020$0,J\u0012\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\u0016H&J\b\u0010/\u001a\u000200H&J\b\u00101\u001a\u000202H&J\b\u00103\u001a\u000204H&J\b\u00105\u001a\u000204H&J\u0010\u00106\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u00107\u001a\u00020$2\u0006\u00108\u001a\u0002022\u0006\u0010%\u001a\u00020&2\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020=H\u0016J\u0018\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010>\u001a\u00020\u0014J,\u0010?\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\"\u0010F\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0014H\u0016J<\u0010H\u001a\u00020$2\u000e\u0010I\u001a\n\u0012\u0002\b\u00030Jj\u0002`K2\u0006\u0010L\u001a\u0002042\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u0002042\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J \u0010R\u001a\u00020$2\u0006\u0010L\u001a\u0002042\u0006\u0010S\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010T\u001a\u00020$2\u0006\u0010G\u001a\u00020\u0014J\u001a\u0010U\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010>\u001a\u00020\u0014J\u0010\u0010V\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020'H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006X"}, d2 = {"Lcom/tencent/state/template/map/component/TemplateSitComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "service", "Lcom/tencent/state/template/service/ITemplateRoomService;", "(Lcom/tencent/state/template/service/ITemplateRoomService;)V", "activityVm", "Lcom/tencent/state/template/activity/TemplateActivityViewModel;", "getActivityVm", "()Lcom/tencent/state/template/activity/TemplateActivityViewModel;", "setActivityVm", "(Lcom/tencent/state/template/activity/TemplateActivityViewModel;)V", "room", "Lcom/tencent/state/template/data/CommonRoomInfo;", "getRoom", "()Lcom/tencent/state/template/data/CommonRoomInfo;", "setRoom", "(Lcom/tencent/state/template/data/CommonRoomInfo;)V", "getService", "()Lcom/tencent/state/template/service/ITemplateRoomService;", "canEditTag", "", "createDetailFragment", "Landroidx/fragment/app/Fragment;", DownloadInfo.spKey_Config, "Lcom/tencent/state/library/calendar/CalendarEntryConfig;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "createShowSitDownPanel", "Lcom/tencent/state/common/tag/BaseTagPanel;", "context", "Landroid/content/Context;", "target", "Lcom/tencent/state/template/data/Table;", "tagFocusListener", "Lcom/tencent/state/common/tag/ITagPanelListener;", "doEditDeskMateTag", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "Lcom/tencent/state/template/item/TemplateTableItem;", "doFocus", "params", "Lcom/tencent/state/template/data/SitDownTagParams;", "onFocusSuccess", "Lkotlin/Function0;", "getActivityViewModel", "f", "getDetailResultKey", "", "getFocusType", "Lcom/tencent/state/template/event/FocusType;", "getSceneType", "", "getShareSource", "gotoDetail", "handleGlobalMeFocusStart", "focusType", "tableId", "", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "needLocateTo", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentVisibilityChanged", "isVisible", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "data", "Lcom/tencent/state/map/MapItem;", "viewId", "extra", "", "scaleToDetail", "table", "setCalendarViewVisible", "showSitDownPanel", "trySwitchTable", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateSitComponent extends TemplateMapBaseComponent {
    private static final String TAG = "TemplateSitComponent";
    private TemplateActivityViewModel activityVm;
    private CommonRoomInfo room;
    private final ITemplateRoomService service;

    public TemplateSitComponent(ITemplateRoomService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
    }

    private final void gotoDetail(FocusItem item) {
        RoomConfig config;
        CommonConfig config2;
        CommonRoomInfo commonRoomInfo = this.room;
        Fragment createDetailFragment = createDetailFragment((commonRoomInfo == null || (config = commonRoomInfo.getConfig()) == null || (config2 = config.getConfig()) == null) ? null : config2.getCalendarConfig(), item);
        if (createDetailFragment != null) {
            VasBaseFragment fragment = getFragment();
            if (fragment != null) {
                fragment.pushFragment(createDetailFragment);
            }
            setCalendarViewVisible(false);
            final String detailResultKey = getDetailResultKey();
            VasBaseFragment fragment2 = getFragment();
            if (fragment2 != null) {
                VasBaseFragmentKt.setFragmentResultListener(fragment2, detailResultKey, new Function2<String, Bundle, Unit>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$gotoDetail$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                        invoke2(str, bundle);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r2v4, types: [com.tencent.state.map.BaseMapView] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String key, Bundle bundle) {
                        TemplateMapFragment<?, ?> templateFragment;
                        ?? mapView;
                        Intrinsics.checkNotNullParameter(key, "key");
                        Intrinsics.checkNotNullParameter(bundle, "<anonymous parameter 1>");
                        if (!Intrinsics.areEqual(key, detailResultKey) || (templateFragment = TemplateSitComponent.this.getTemplateFragment()) == null || (mapView = templateFragment.getMapView()) == 0) {
                            return;
                        }
                        mapView.onBackFromDetail();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scaleToDetail(int index, Table table, User user) {
        MapViewHolder<?> viewHolder;
        VasBaseFragment fragment = getFragment();
        if (fragment != null && fragment.isTopFragment()) {
            TemplateMapView<?> mapView = getMapView();
            if (mapView == null || (viewHolder = mapView.getViewHolder(index)) == null || !viewHolder.onScaleToDetail()) {
                return;
            }
            CommonRoomInfo commonRoomInfo = this.room;
            gotoDetail(new FocusItem(table, user, commonRoomInfo != null ? commonRoomInfo.getId() : 0L));
            return;
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("scaleToDetail, but current top fragment is ");
        VasBaseFragment fragment2 = getFragment();
        sb5.append(fragment2 != null ? fragment2.getTopFragment() : null);
        squareLog.w(TAG, sb5.toString());
    }

    private final void trySwitchTable(TemplateTableItem item) {
        Context context;
        VasBaseFragment fragment;
        TemplateCommonOperateComponent templateCommonOperateComponent;
        VasBaseFragment fragment2 = getFragment();
        if (fragment2 == null || (context = fragment2.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        CommonRoomInfo commonRoomInfo = this.room;
        if (commonRoomInfo == null || (fragment = getFragment()) == null || (templateCommonOperateComponent = (TemplateCommonOperateComponent) VasBaseLifecycleFragment.getComponent$default(fragment, TemplateCommonOperateComponent.class, null, null, 6, null)) == null) {
            return;
        }
        String uin = item.getUin();
        long id5 = commonRoomInfo.getId();
        long id6 = item.getTable().getId();
        Stall stall = item.getTable().getStall();
        TemplateCommonOperateComponent.switchTable$default(templateCommonOperateComponent, context, uin, id5, id6, stall != null ? stall.getCategoryId() : null, false, null, 64, null);
    }

    public abstract boolean canEditTag();

    public abstract Fragment createDetailFragment(CalendarEntryConfig config, FocusItem item);

    public abstract BaseTagPanel createShowSitDownPanel(Context context, CommonRoomInfo room, Table target, ITagPanelListener tagFocusListener);

    public final void doFocus(SitDownTagParams params, final Function0<Unit> onFocusSuccess) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(onFocusSuccess, "onFocusSuccess");
        this.service.sitDown(params, new ResultCallback<User>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$doFocus$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
            @Override // com.tencent.state.service.ResultCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResultFailure(int error, String message, String prompt) {
                boolean z16;
                VasBaseFragment fragment;
                boolean isBlank;
                if (prompt != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(prompt);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                            fragment = TemplateSitComponent.this.getFragment();
                            squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, prompt, 1);
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(User result) {
                if (result != null) {
                    TemplateSitComponent.this.onFocusSuccess(result, true);
                    onFocusSuccess.invoke();
                } else {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "TemplateSitComponent", "doFocus success but result user is null.", null, 4, null);
                }
            }
        });
    }

    public abstract TemplateActivityViewModel getActivityViewModel(Fragment f16);

    protected final TemplateActivityViewModel getActivityVm() {
        return this.activityVm;
    }

    public abstract String getDetailResultKey();

    public abstract FocusType getFocusType();

    protected final CommonRoomInfo getRoom() {
        return this.room;
    }

    public abstract int getSceneType();

    public final ITemplateRoomService getService() {
        return this.service;
    }

    public abstract int getShareSource();

    public final void handleGlobalMeFocusStart(FocusType focusType, final User user, long tableId) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(focusType, "focusType");
        Intrinsics.checkNotNullParameter(user, "user");
        SquareBaseKt.getSquareLog().i(TAG, "handleMeFocusStart: " + focusType + ", " + user.getUin() + ", " + tableId + ", " + TemplateMapViewKt.isMeSeated(getMapView()));
        if (focusType == getFocusType() && !TemplateMapViewKt.isMeSeated(getMapView())) {
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null) : null;
            }
            TemplateUiComponent templateUiComponent = (TemplateUiComponent) component$default;
            if (templateUiComponent != null) {
                templateUiComponent.sitDown(tableId, user);
            }
            Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$handleGlobalMeFocusStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    it.onMeFocusStart(User.this);
                }
            };
            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment3 != null) {
                vasBaseFragment3.forEachComponent(ITemplateMapEvent.class, null, null, function1);
            }
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.room = info.getRoom();
    }

    public final void onFocusSuccess(final User user, boolean needLocateTo) {
        MapAdapter adapter;
        SitDownInfo sitDown;
        final Table table;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        IMapViewManipulator manipulator;
        Intrinsics.checkNotNullParameter(user, "user");
        SquareUtil squareUtil = SquareUtil.INSTANCE;
        QBaseActivity activity = getActivity();
        if (!(activity instanceof Activity)) {
            activity = null;
        }
        squareUtil.setKeepScreen(activity, true);
        TemplateMapView<?> mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null || (sitDown = user.getSitDown()) == null) {
            return;
        }
        final long tableId = sitDown.getTableId();
        final int indexOf = adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$onFocusSuccess$index$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                return Boolean.valueOf(invoke2(mapItem));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(MapItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (it instanceof TemplateTableItem) && ((TemplateTableItem) it).getTable().getId() == tableId;
            }
        });
        MapItem itemData = adapter.getItemData(indexOf);
        if (!(itemData instanceof TemplateTableItem)) {
            itemData = null;
        }
        TemplateTableItem templateTableItem = (TemplateTableItem) itemData;
        if (templateTableItem == null || (table = templateTableItem.getTable()) == null) {
            return;
        }
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null) : null;
        }
        TemplateUiComponent templateUiComponent = (TemplateUiComponent) component$default;
        if (templateUiComponent != null) {
            templateUiComponent.sitDown(tableId, user);
        }
        if (needLocateTo) {
            TemplateMapView<?> mapView2 = getMapView();
            if (mapView2 != null && (manipulator = mapView2.getManipulator()) != null) {
                manipulator.locateTo(indexOf, new Function1<Boolean, Unit>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$onFocusSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        TemplateSitComponent.this.scaleToDetail(indexOf, table, user);
                    }
                });
            }
        } else {
            scaleToDetail(indexOf, table, user);
        }
        if (user.isMe()) {
            Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$onFocusSuccess$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    it.onMeFocusStart(User.this);
                }
            };
            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment3 != null) {
                vasBaseFragment3.forEachComponent(ITemplateMapEvent.class, null, null, function1);
            }
            SimpleEventBus.getInstance().dispatchEvent(new GlobalMeFocusStartSquareEvent(getFocusType(), user, tableId));
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        LiveData<Event<Pair<Long, Long>>> endFocusUser;
        LiveData<Event<User>> startFocusUser;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        TemplateActivityViewModel activityViewModel = getActivityViewModel(f16);
        this.activityVm = activityViewModel;
        if (activityViewModel != null && (startFocusUser = activityViewModel.getStartFocusUser()) != null) {
            startFocusUser.observe(f16.getViewLifecycleOwner(), new Observer<Event<User>>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$onFragmentViewCreated$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Event<User> event) {
                    final User content;
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    VasBaseFragment vasBaseFragment;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    if (event == null || (content = event.getContent()) == null) {
                        return;
                    }
                    TemplateSitComponent templateSitComponent = TemplateSitComponent.this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templateSitComponent instanceof VasBaseFragmentComponentGroup) ? null : templateSitComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && (((parent = templateSitComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) templateSitComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null))) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templateSitComponent).parentFragment;
                        component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null) : null;
                    }
                    TemplateUiComponent templateUiComponent = (TemplateUiComponent) component$default;
                    if (templateUiComponent != null) {
                        SitDownInfo sitDown = content.getSitDown();
                        templateUiComponent.sitDown(sitDown != null ? sitDown.getTableId() : 0L, content);
                    }
                    if (content.isMe()) {
                        TemplateSitComponent templateSitComponent2 = TemplateSitComponent.this;
                        Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$onFragmentViewCreated$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
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
                                it.onMeFocusStart(User.this);
                            }
                        };
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) templateSitComponent2).fragment;
                        if (vasBaseFragment3 != null) {
                            vasBaseFragment3.forEachComponent(ITemplateMapEvent.class, null, null, function1);
                        }
                    }
                }
            });
        }
        TemplateActivityViewModel templateActivityViewModel = this.activityVm;
        if (templateActivityViewModel == null || (endFocusUser = templateActivityViewModel.getEndFocusUser()) == null) {
            return;
        }
        endFocusUser.observe(f16.getViewLifecycleOwner(), new Observer<Event<Pair<? extends Long, ? extends Long>>>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$onFragmentViewCreated$2
            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Event<Pair<? extends Long, ? extends Long>> event) {
                onChanged2((Event<Pair<Long, Long>>) event);
            }

            /* renamed from: onChanged, reason: avoid collision after fix types in other method */
            public final void onChanged2(Event<Pair<Long, Long>> event) {
                Pair<Long, Long> content;
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                if (event == null || (content = event.getContent()) == null) {
                    return;
                }
                FragmentComponent fragmentComponent2 = null;
                if (Intrinsics.areEqual(String.valueOf(content.getSecond().longValue()), Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin())) {
                    TemplateSitComponent templateSitComponent = TemplateSitComponent.this;
                    TemplateSitComponent$onFragmentViewCreated$2$1$1 templateSitComponent$onFragmentViewCreated$2$1$1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$onFragmentViewCreated$2$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                            invoke2(iTemplateMapEvent);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ITemplateMapEvent component) {
                            Intrinsics.checkNotNullParameter(component, "component");
                            component.onMeFocusEnd();
                        }
                    };
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) templateSitComponent).fragment;
                    if (vasBaseFragment != null) {
                        vasBaseFragment.forEachComponent(ITemplateMapEvent.class, null, null, templateSitComponent$onFragmentViewCreated$2$1$1);
                    }
                }
                TemplateSitComponent templateSitComponent2 = TemplateSitComponent.this;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templateSitComponent2 instanceof VasBaseFragmentComponentGroup) ? null : templateSitComponent2);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && ((parent = templateSitComponent2.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templateSitComponent2).fragment;
                    if (vasBaseFragment2 == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) templateSitComponent2).parentFragment;
                        if (vasBaseFragment3 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, TemplateUiComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent;
                if (templateUiComponent != null) {
                    templateUiComponent.standUp(content.getFirst().longValue(), content.getSecond().longValue());
                }
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        Intrinsics.checkNotNullParameter(f16, "f");
        setCalendarViewVisible(isVisible);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        if ((r10) != false) goto L35;
     */
    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.map.IMapViewListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        SitDownInfo sitDown;
        Table table;
        User user;
        TemplateShareComponent templateShareComponent;
        User user2;
        SitDownInfo sitDown2;
        CommonTagInfo subTag;
        String id5;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (viewId == 1) {
            if (!(data instanceof TemplateAvatarItem)) {
                data = null;
            }
            TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) data;
            if (templateAvatarItem == null || (sitDown = templateAvatarItem.getUser().getSitDown()) == null || (table = sitDown.getTable()) == null) {
                return;
            }
            User user3 = templateAvatarItem.getUser();
            CommonRoomInfo commonRoomInfo = this.room;
            gotoDetail(new FocusItem(table, user3, commonRoomInfo != null ? commonRoomInfo.getId() : 0L));
            return;
        }
        if (viewId != 2) {
            return;
        }
        if (!(data instanceof TemplateTableItem)) {
            data = null;
        }
        TemplateTableItem templateTableItem = (TemplateTableItem) data;
        if (templateTableItem != null) {
            Table neighbor = templateTableItem.getTable().getNeighbor();
            if (neighbor != null && (user = neighbor.getUser()) != null && user.isMe()) {
                if (canEditTag()) {
                    Table neighbor2 = templateTableItem.getTable().getNeighbor();
                    if (neighbor2 != null && (user2 = neighbor2.getUser()) != null && (sitDown2 = user2.getSitDown()) != null && (subTag = sitDown2.getSubTag()) != null && (id5 = subTag.getId()) != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(id5);
                    }
                    Table neighbor3 = templateTableItem.getTable().getNeighbor();
                    doEditDeskMateTag(neighbor3 != null ? neighbor3.getUser() : null, templateTableItem);
                    return;
                }
                VasBaseFragment fragment = getFragment();
                if (fragment == null || (templateShareComponent = (TemplateShareComponent) VasBaseLifecycleFragment.getComponent$default(fragment, TemplateShareComponent.class, null, null, 6, null)) == null) {
                    return;
                }
                templateShareComponent.doShare(getShareSource(), getSceneType());
                return;
            }
            if (TemplateMapViewKt.isMeSeated(getMapView())) {
                trySwitchTable(templateTableItem);
            } else {
                showSitDownPanel(templateTableItem.getTable(), true);
            }
        }
    }

    protected final void setActivityVm(TemplateActivityViewModel templateActivityViewModel) {
        this.activityVm = templateActivityViewModel;
    }

    public final void setCalendarViewVisible(boolean isVisible) {
        VasSquareFragmentLibraryBinding binding;
        FrameLayout mContainer;
        VasBaseFragment fragment = getFragment();
        LibraryCalendarGuideView libraryCalendarGuideView = null;
        if (!(fragment instanceof LibraryFragment)) {
            fragment = null;
        }
        LibraryFragment libraryFragment = (LibraryFragment) fragment;
        if (libraryFragment != null && (binding = libraryFragment.getBinding()) != null && (mContainer = binding.getMContainer()) != null) {
            libraryCalendarGuideView = (LibraryCalendarGuideView) mContainer.findViewWithTag(LibraryCalendarGuideView.TAG);
        }
        if (libraryCalendarGuideView != null) {
            ViewExtensionsKt.setVisibility(libraryCalendarGuideView, isVisible);
        }
    }

    protected final void setRoom(CommonRoomInfo commonRoomInfo) {
        this.room = commonRoomInfo;
    }

    public final void showSitDownPanel(Table target, final boolean needLocateTo) {
        Context context;
        BaseTagPanel createShowSitDownPanel;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        CommonRoomInfo commonRoomInfo = this.room;
        if (commonRoomInfo == null || (createShowSitDownPanel = createShowSitDownPanel(context, commonRoomInfo, target, new ITagPanelListener() { // from class: com.tencent.state.template.map.component.TemplateSitComponent$showSitDownPanel$1
            @Override // com.tencent.state.common.tag.ITagPanelListener
            public void onFocusFailed(boolean isDueToRoomFull, SitDownTagParams params) {
                WeakReference<VasBaseFragmentComponentGroup> parent;
                VasBaseFragment vasBaseFragment;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                SquareBaseKt.getSquareLog().i("TemplateSitComponent", "onFocusFailed, " + isDueToRoomFull);
                if (isDueToRoomFull) {
                    TemplateSitComponent templateSitComponent = TemplateSitComponent.this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templateSitComponent instanceof VasBaseFragmentComponentGroup) ? null : templateSitComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && (((parent = templateSitComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) templateSitComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateRoomComponent.class, null, null, 2, null)) == null))) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templateSitComponent).parentFragment;
                        component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 6, null) : null;
                    }
                    TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) component$default;
                    if (templateRoomComponent != null) {
                        TemplateRoomComponent.switchRoom$default(templateRoomComponent, params, null, 2, null);
                    }
                }
            }

            @Override // com.tencent.state.common.tag.ITagPanelListener
            public void onFocusSuccess(User user) {
                Intrinsics.checkNotNullParameter(user, "user");
                SquareBaseKt.getSquareLog().i("TemplateSitComponent", "onFocusSuccess");
                TemplateSitComponent.this.onFocusSuccess(user, needLocateTo);
            }
        })) == null) {
            return;
        }
        createShowSitDownPanel.show();
    }

    private final void doEditDeskMateTag(User user, TemplateTableItem item) {
        CommonRoomInfo commonRoomInfo;
        VasBaseFragment fragment;
        Context context;
        TemplateCommonOperateComponent templateCommonOperateComponent;
        if (user == null || (commonRoomInfo = this.room) == null || (fragment = getFragment()) == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        VasBaseFragment fragment2 = getFragment();
        if (fragment2 == null || (templateCommonOperateComponent = (TemplateCommonOperateComponent) VasBaseLifecycleFragment.getComponent$default(fragment2, TemplateCommonOperateComponent.class, null, null, 6, null)) == null) {
            return;
        }
        TemplateCommonOperateComponent.showEditDeskMateTagPanel$default(templateCommonOperateComponent, context, user, commonRoomInfo.getId(), item.getTable().getId(), null, 16, null);
    }

    public static /* synthetic */ void onFocusSuccess$default(TemplateSitComponent templateSitComponent, User user, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            templateSitComponent.onFocusSuccess(user, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFocusSuccess");
    }

    public static /* synthetic */ void showSitDownPanel$default(TemplateSitComponent templateSitComponent, Table table, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            templateSitComponent.showSitDownPanel(table, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSitDownPanel");
    }
}
