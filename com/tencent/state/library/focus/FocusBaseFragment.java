package com.tencent.state.library.focus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentKt;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.VasExtensionsKt;
import com.tencent.state.library.LibraryActivityViewModel;
import com.tencent.state.library.calendar.CalendarEntryConfig;
import com.tencent.state.library.components.LibraryGroupOperateComponent;
import com.tencent.state.library.components.LibraryGroupShareComponent;
import com.tencent.state.library.components.fragments.LibraryChatComponent;
import com.tencent.state.library.focus.component.FocusEventBusComponent;
import com.tencent.state.library.focus.component.FocusLikeReddotComponent;
import com.tencent.state.library.focus.component.FocusPushComponent;
import com.tencent.state.library.focus.component.FocusRouterComponent;
import com.tencent.state.library.focus.component.FocusTimerComponent;
import com.tencent.state.library.focus.component.FocusUIComponent;
import com.tencent.state.library.focus.component.IFocusEventListener;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.data.FocusSingleItem;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.service.VasLibraryRoomService;
import com.tencent.state.service.VasLibraryStatisticsService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.MeResourceRecorder;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.template.data.SitDownUpdateData;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0014J\n\u0010&\u001a\u0004\u0018\u00010'H&J\b\u0010(\u001a\u00020!H\u0002J\u0006\u0010)\u001a\u00020\u0019J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020!H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\u0012\u00103\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020!H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u0011H\u0016J\b\u00109\u001a\u00020!H&J\u001a\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0018\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0011H\u0014J\u001a\u0010@\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020DH\u0016J \u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0019H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006K"}, d2 = {"Lcom/tencent/state/library/focus/FocusBaseFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/state/library/focus/FocusBaseListener;", "()V", "activityVM", "Lcom/tencent/state/library/LibraryActivityViewModel;", "getActivityVM", "()Lcom/tencent/state/library/LibraryActivityViewModel;", "setActivityVM", "(Lcom/tencent/state/library/LibraryActivityViewModel;)V", "data", "Lcom/tencent/state/library/focus/data/FocusBaseItem;", "getData", "()Lcom/tencent/state/library/focus/data/FocusBaseItem;", "setData", "(Lcom/tencent/state/library/focus/data/FocusBaseItem;)V", "endFocusStatText", "", "focusDialog", "Lcom/tencent/state/library/focus/FocusDialogTips;", "getFocusDialog", "()Lcom/tencent/state/library/focus/FocusDialogTips;", "setFocusDialog", "(Lcom/tencent/state/library/focus/FocusDialogTips;)V", "isDestroy", "", "recorder", "Lcom/tencent/state/square/resource/MeResourceRecorder;", "getRecorder", "()Lcom/tencent/state/square/resource/MeResourceRecorder;", "setRecorder", "(Lcom/tencent/state/square/resource/MeResourceRecorder;)V", "doCommonDestroy", "", "doCommonInitEvent", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getFragmentView", "Lcom/tencent/state/library/focus/IFocusParentView;", "initEndFocusStatText", "isMeSeat", "notifyLibraryMeSitDown", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "notifyLibraryMeStandUp", "tableId", "", "uin", "onBackClick", "onBackPressed", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onEndFocusClick", "focusTimeText", "onFocusBackPress", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", "onVisibilityChanged", "isVisible", "from", "recordAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "updateLibraryItemVisible", "id", "type", "", NodeProps.VISIBLE, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class FocusBaseFragment extends VasBaseSubFragment implements FocusBaseListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_CALENDAR_CONFIG = "key_calendar_config";
    public static final String KEY_OPEN_DETAIL = "key_open_library_detail";
    private LibraryActivityViewModel activityVM;
    private FocusBaseItem data;
    private boolean isDestroy;
    private MeResourceRecorder recorder = new MeResourceRecorder();
    private FocusDialogTips focusDialog = FocusDialogTips.INSTANCE;
    private String endFocusStatText = "";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/library/focus/FocusBaseFragment$Companion;", "", "()V", "KEY_CALENDAR_CONFIG", "", "KEY_OPEN_DETAIL", "newInstance", "Lcom/tencent/state/library/focus/FocusBaseFragment;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", DownloadInfo.spKey_Config, "Lcom/tencent/state/library/calendar/CalendarEntryConfig;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final FocusBaseFragment newInstance(FocusItem item, CalendarEntryConfig config) {
            Table neighbor;
            User user;
            FocusGroupItem focusGroupItem;
            FocusBaseFragment newInstance;
            Intrinsics.checkNotNullParameter(item, "item");
            User user2 = item.getUser();
            boolean z16 = (user2 != null && user2.isMe()) || !((neighbor = item.getTable().getNeighbor()) == null || (user = neighbor.getUser()) == null || !user.isMe());
            if (item.getTable().getNeighbor() == null) {
                if (z16) {
                    newInstance = FocusSingleMeFragment.INSTANCE.newInstance(new FocusSingleItem(item));
                } else {
                    newInstance = FocusSingleGuestFragment.INSTANCE.newInstance(new FocusSingleItem(item));
                }
            } else if (item.getTable().isLeft()) {
                Table neighbor2 = item.getTable().getNeighbor();
                if (neighbor2 != null) {
                    focusGroupItem = new FocusGroupItem(item, new FocusItem(neighbor2, neighbor2.getUser(), item.getRoomId()));
                    newInstance = focusGroupItem == null ? FocusGroupFragment.INSTANCE.newInstance(focusGroupItem) : null;
                }
                focusGroupItem = null;
                if (focusGroupItem == null) {
                }
            } else {
                Table neighbor3 = item.getTable().getNeighbor();
                if (neighbor3 != null) {
                    focusGroupItem = new FocusGroupItem(new FocusItem(neighbor3, neighbor3.getUser(), item.getRoomId()), item);
                    if (focusGroupItem == null) {
                    }
                }
                focusGroupItem = null;
                if (focusGroupItem == null) {
                }
            }
            if (config != null && newInstance != null) {
                newInstance.setArguments(VasExtensionsKt.bundleOf(TuplesKt.to(FocusBaseFragment.KEY_CALENDAR_CONFIG, config)));
            }
            return newInstance;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void doCommonDestroy() {
        FocusCommonView commonView;
        View view;
        Context it = getContext();
        if (it != null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            commonUtils.unSetStandardFont(it);
        }
        IFocusParentView fragmentView = getFragmentView();
        if (fragmentView != null && (view = fragmentView.getView()) != null) {
            view.setVisibility(8);
        }
        IFocusParentView fragmentView2 = getFragmentView();
        if (fragmentView2 != null && (commonView = fragmentView2.getCommonView()) != null) {
            commonView.onDestroy();
        }
        FocusTimerComponent focusTimerComponent = (FocusTimerComponent) getComponent(FocusTimerComponent.class, null, null);
        if (focusTimerComponent != null) {
            focusTimerComponent.pauseTimer();
        }
    }

    private final void doCommonInitEvent() {
        View view;
        Context it = getContext();
        if (it != null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            commonUtils.setStandardFont(it);
        }
        FragmentActivity activity = getActivity();
        this.activityVM = activity != null ? (LibraryActivityViewModel) new ViewModelProvider(activity).get(LibraryActivityViewModel.class) : null;
        IFocusParentView fragmentView = getFragmentView();
        if (fragmentView == null || (view = fragmentView.getView()) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.FocusBaseFragment$doCommonInitEvent$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FocusBaseFragment.this.onBackPressed();
            }
        });
    }

    private final void initEndFocusStatText() {
        new VasLibraryStatisticsService().getUserFocusStatistics(new Function1<String, Unit>() { // from class: com.tencent.state.library.focus.FocusBaseFragment$initEndFocusStatText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FocusBaseFragment.this.endFocusStatText = it;
            }
        });
    }

    protected final LibraryActivityViewModel getActivityVM() {
        return this.activityVM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FocusBaseItem getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FocusDialogTips getFocusDialog() {
        return this.focusDialog;
    }

    public abstract IFocusParentView getFragmentView();

    protected final MeResourceRecorder getRecorder() {
        return this.recorder;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    public final boolean isMeSeat() {
        LiveData<Boolean> isMeSeat;
        Boolean value;
        LibraryActivityViewModel libraryActivityViewModel = this.activityVM;
        if (libraryActivityViewModel == null || (isMeSeat = libraryActivityViewModel.isMeSeat()) == null || (value = isMeSeat.getValue()) == null) {
            return false;
        }
        return value.booleanValue();
    }

    @Override // com.tencent.state.library.focus.FocusBaseListener
    public void notifyLibraryMeSitDown(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        LibraryActivityViewModel libraryActivityViewModel = this.activityVM;
        if (libraryActivityViewModel != null) {
            libraryActivityViewModel.updateStartFocusUser(user);
        }
    }

    @Override // com.tencent.state.library.focus.FocusBaseListener
    public void notifyLibraryMeStandUp(long tableId, long uin) {
        SquareUtil.INSTANCE.setKeepScreen(getActivity(), false);
        LibraryActivityViewModel libraryActivityViewModel = this.activityVM;
        if (libraryActivityViewModel != null) {
            libraryActivityViewModel.updateEndFocusUser(tableId, uin);
        }
    }

    @Override // com.tencent.state.library.focus.FocusBaseListener
    public void onBackClick() {
        onBackPressed();
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        if (!this.isDestroy) {
            this.isDestroy = true;
            onFocusBackPress();
            this.activityVM = null;
            this.recorder.onDestroy();
            VasBaseFragmentKt.setFragmentResult(this, KEY_OPEN_DETAIL, new Bundle());
            popFragment(this);
        }
        return true;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEndFocusStatText();
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        doCommonDestroy();
    }

    @Override // com.tencent.state.library.focus.FocusBaseListener
    public void onEndFocusClick(String focusTimeText) {
        Intrinsics.checkNotNullParameter(focusTimeText, "focusTimeText");
        SquareBaseKt.getSquareLog().d(QBaseFragment.TAG, "onEndFocusClick " + focusTimeText);
        FocusTimerComponent focusTimerComponent = (FocusTimerComponent) getComponent(FocusTimerComponent.class, null, null);
        if (focusTimerComponent != null) {
            focusTimerComponent.pauseTimer();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            SquareBaseKt.getSquareLog().d(QBaseFragment.TAG, "showEndFocusDialog");
            this.focusDialog.showEndFocusDialog(activity, focusTimeText, this.endFocusStatText, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.FocusBaseFragment$onEndFocusClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        VasLibraryRoomService.INSTANCE.standUp("FocusPage", new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.FocusBaseFragment$onEndFocusClick$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
                            
                                r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke(boolean z17) {
                                Long longOrNull;
                                Long meTableId;
                                if (z17) {
                                    FocusBaseFragment focusBaseFragment = FocusBaseFragment.this;
                                    FocusBaseItem data = focusBaseFragment.getData();
                                    long j3 = 0;
                                    long longValue = (data == null || (meTableId = FocusDataKt.getMeTableId(data)) == null) ? 0L : meTableId.longValue();
                                    FocusBaseItem data2 = FocusBaseFragment.this.getData();
                                    if (data2 != null && (r0 = FocusDataKt.meUin(data2)) != null && longOrNull != null) {
                                        j3 = longOrNull.longValue();
                                    }
                                    focusBaseFragment.notifyLibraryMeStandUp(longValue, j3);
                                    FocusBaseFragment.this.onBackPressed();
                                    return;
                                }
                                FocusTimerComponent focusTimerComponent2 = (FocusTimerComponent) FocusBaseFragment.this.getComponent(FocusTimerComponent.class, null, null);
                                if (focusTimerComponent2 != null) {
                                    focusTimerComponent2.restartTimer();
                                }
                            }
                        });
                        return;
                    }
                    FocusTimerComponent focusTimerComponent2 = (FocusTimerComponent) FocusBaseFragment.this.getComponent(FocusTimerComponent.class, null, null);
                    if (focusTimerComponent2 != null) {
                        focusTimerComponent2.restartTimer();
                    }
                }
            });
        }
    }

    public abstract void onFocusBackPress();

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusBaseFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IFocusEventListener iFocusEventListener) {
                invoke2(iFocusEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IFocusEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FocusBaseItem data = FocusBaseFragment.this.getData();
                if (data != null) {
                    it.onEnterFocus(data);
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
        doCommonInitEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public void onVisibilityChanged(boolean isVisible, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        super.onVisibilityChanged(isVisible, from);
        if (isVisible) {
            FocusTimerComponent focusTimerComponent = (FocusTimerComponent) getComponent(FocusTimerComponent.class, null, null);
            if (focusTimerComponent != null) {
                focusTimerComponent.restartTimer();
                return;
            }
            return;
        }
        FocusTimerComponent focusTimerComponent2 = (FocusTimerComponent) getComponent(FocusTimerComponent.class, null, null);
        if (focusTimerComponent2 != null) {
            focusTimerComponent2.pauseTimer();
        }
    }

    @Override // com.tencent.state.library.focus.FocusBaseListener
    public void recordAvatar(Resource resource, IResourceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MeResourceRecorder.startRecord$default(this.recorder, new RecordRequest(resource, null, 0, 4, null), (String) null, (List) null, callback, 6, (Object) null);
    }

    protected final void setActivityVM(LibraryActivityViewModel libraryActivityViewModel) {
        this.activityVM = libraryActivityViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setData(FocusBaseItem focusBaseItem) {
        this.data = focusBaseItem;
    }

    protected final void setFocusDialog(FocusDialogTips focusDialogTips) {
        Intrinsics.checkNotNullParameter(focusDialogTips, "<set-?>");
        this.focusDialog = focusDialogTips;
    }

    protected final void setRecorder(MeResourceRecorder meResourceRecorder) {
        Intrinsics.checkNotNullParameter(meResourceRecorder, "<set-?>");
        this.recorder = meResourceRecorder;
    }

    @Override // com.tencent.state.library.focus.FocusBaseListener
    public void updateLibraryItemVisible(String id5, int type, boolean visible) {
        Intrinsics.checkNotNullParameter(id5, "id");
        LibraryActivityViewModel libraryActivityViewModel = this.activityVM;
        if (libraryActivityViewModel != null) {
            libraryActivityViewModel.updateScaledAvatarVisibility(new SitDownUpdateData(id5, type, visible));
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new FocusPushComponent(), new FocusUIComponent(), new LibraryChatComponent(), new FocusTimerComponent(), new FocusRouterComponent(), new FocusEventBusComponent(), new LibraryGroupShareComponent(), new LibraryGroupOperateComponent(), new FocusLikeReddotComponent()});
        return listOf;
    }
}
