package com.tencent.state.library.focus;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.state.FragmentComponent;
import com.tencent.state.PageType;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.record.RecordFragment;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.common.tag.ITagPanelListener;
import com.tencent.state.library.components.fragments.LibraryChatComponent;
import com.tencent.state.library.components.fragments.LibraryMsgBoxComponent;
import com.tencent.state.library.components.fragments.LibraryPublicChatComponent;
import com.tencent.state.library.focus.component.FocusCalendarComponent;
import com.tencent.state.library.focus.component.FocusGroupReportComponent;
import com.tencent.state.library.focus.component.FocusRecordComponent;
import com.tencent.state.library.focus.component.IFocusEventListener;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.ClickType;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.FocusGroupView;
import com.tencent.state.library.focus.view.LibraryFocusTimeBubble;
import com.tencent.state.library.tag.LibraryFocusPanel;
import com.tencent.state.publicchat.IPublicChatOwner;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.component.IPublicChatOwnerEventListener;
import com.tencent.state.publicchat.component.PublicChatCommonComponent;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.UnreadMessageObserver;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import com.tencent.state.square.databinding.VasSquareLibraryGroupBinding;
import com.tencent.state.square.databinding.VasSquareLibraryGroupViewBinding;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.event.FocusType;
import com.tencent.state.template.event.GlobalMeFocusStartSquareEvent;
import com.tencent.state.template.fragment.TemplateCommonOperateComponent;
import com.tencent.state.template.fragment.TemplateShareComponent;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001CB\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0014J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u000fH\u0016J\"\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\rH\u0016J&\u00102\u001a\u0004\u0018\u00010.2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020\u000fH\u0016J\u0018\u0010:\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010;\u001a\u00020\u000fH\u0016J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020\u000fH\u0016J\b\u0010?\u001a\u00020\u000fH\u0016J\u001a\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tencent/state/library/focus/FocusGroupFragment;", "Lcom/tencent/state/library/focus/FocusBaseFragment;", "Lcom/tencent/state/library/focus/FocusGroupListener;", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "Lcom/tencent/state/publicchat/IPublicChatOwner;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryGroupBinding;", "fromPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "miniAioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "publicChatConf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "clearUnReadCache", "", "uin", "", "doEditDeskMateTag", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "doFuncBtnClick", "type", "Lcom/tencent/state/library/focus/view/ClickType;", "doOnDestroy", "doOnViewCreated", "doShare", "doStartFocus", "getAppId", "", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getFragmentView", "Lcom/tencent/state/library/focus/IFocusParentView;", "getPageId", "isPublicChatEnabled", "", "notifyUnreadMessage", "message", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "onCallMateClick", "onChatBoxClicked", "v", "Landroid/view/View;", "nick", "onConfigLoaded", "conf", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onEmptyTableClicked", "onFocusBackPress", "onFocusChange", "isVisible", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "trySwitchTable", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusGroupFragment extends FocusBaseFragment implements FocusGroupListener, UnreadMessageObserver, IPublicChatOwner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "FocusGroupFragment";
    private VasSquareLibraryGroupBinding binding;
    private AtomicBoolean fromPause = new AtomicBoolean(false);
    private ISquareBaseMessageService miniAioService;
    private PublicChatConfInfo publicChatConf;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/library/focus/FocusGroupFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/tencent/state/library/focus/FocusGroupFragment;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusGroupItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        public final FocusGroupFragment newInstance(FocusGroupItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            FocusGroupFragment focusGroupFragment = new FocusGroupFragment();
            focusGroupFragment.setData(item);
            return focusGroupFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void doOnDestroy() {
        FocusGroupView focusGroupView;
        ISquareBaseMessageService iSquareBaseMessageService = this.miniAioService;
        if (iSquareBaseMessageService != null) {
            iSquareBaseMessageService.deleteUnreadMessageObserver(this);
        }
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        if (vasSquareLibraryGroupBinding == null || (focusGroupView = vasSquareLibraryGroupBinding.groupView) == null) {
            return;
        }
        focusGroupView.onDestroy();
    }

    private final void doOnViewCreated() {
        MessageRecordType messageRecordType;
        FocusGroupView focusGroupView;
        FocusCommonView commonView;
        VasSquareLibraryCommonViewBinding binding;
        LibraryFocusTimeBubble libraryFocusTimeBubble;
        FocusGroupView focusGroupView2;
        BasicServiceComponent basicServiceComponent = (BasicServiceComponent) VasBaseLifecycleFragment.getComponent$default(this, BasicServiceComponent.class, null, null, 6, null);
        ISquareBaseMessageService messageService = basicServiceComponent != null ? basicServiceComponent.getMessageService() : null;
        this.miniAioService = messageService;
        if (messageService != null) {
            messageService.addUnreadMessageObserver(this);
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnViewCreated: data=");
        sb5.append(getData());
        sb5.append(", groupView=");
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        sb5.append(vasSquareLibraryGroupBinding != null ? vasSquareLibraryGroupBinding.groupView : null);
        squareLog.i(TAG, sb5.toString());
        FocusBaseItem data = getData();
        if (!(data instanceof FocusGroupItem)) {
            data = null;
        }
        FocusGroupItem focusGroupItem = (FocusGroupItem) data;
        if (focusGroupItem != null) {
            VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding2 = this.binding;
            if (vasSquareLibraryGroupBinding2 != null && (focusGroupView2 = vasSquareLibraryGroupBinding2.groupView) != null) {
                focusGroupView2.initView(focusGroupItem, this);
            }
            VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding3 = this.binding;
            if (vasSquareLibraryGroupBinding3 != null && (focusGroupView = vasSquareLibraryGroupBinding3.groupView) != null && (commonView = focusGroupView.getCommonView()) != null && (binding = commonView.getBinding()) != null && (libraryFocusTimeBubble = binding.focusTimeBubble) != null) {
                libraryFocusTimeBubble.setBubbleClickListener(new Function2<Integer, User, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$doOnViewCreated$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, User user) {
                        invoke(num.intValue(), user);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final int i3, final User user) {
                        Intrinsics.checkNotNullParameter(user, "user");
                        if (i3 == 5) {
                            if (user.isMe()) {
                                FocusGroupFragment.this.showFragment(new RecordFragment(PageType.Library));
                            }
                            FocusGroupFragment.this.forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$doOnViewCreated$$inlined$let$lambda$1.1
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
                                    it.onComeOnButtonClicked(User.this);
                                }
                            });
                            return;
                        }
                        FocusGroupFragment.this.forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$doOnViewCreated$$inlined$let$lambda$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                it.onViewClick(i3, user);
                            }
                        });
                    }
                });
            }
            String meDeskUin = FocusDataKt.meDeskUin(focusGroupItem);
            if (meDeskUin != null) {
                ISquareBaseMessageService iSquareBaseMessageService = this.miniAioService;
                Boolean valueOf = iSquareBaseMessageService != null ? Boolean.valueOf(iSquareBaseMessageService.isFriend(meDeskUin)) : null;
                ISquareBaseMessageService iSquareBaseMessageService2 = this.miniAioService;
                if (iSquareBaseMessageService2 != null) {
                    if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
                        messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
                    } else {
                        messageRecordType = MessageRecordType.RECORD_TYPE_SQUARE_TEMP;
                    }
                    ISquareBaseMessageService.DefaultImpls.getSingleUnreadMsg$default(iSquareBaseMessageService2, meDeskUin, false, messageRecordType, new Function1<SquareBaseMessageRecord, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$doOnViewCreated$$inlined$let$lambda$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SquareBaseMessageRecord squareBaseMessageRecord) {
                            invoke2(squareBaseMessageRecord);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SquareBaseMessageRecord squareBaseMessageRecord) {
                            VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding4;
                            FocusGroupView focusGroupView3;
                            vasSquareLibraryGroupBinding4 = FocusGroupFragment.this.binding;
                            if (vasSquareLibraryGroupBinding4 == null || (focusGroupView3 = vasSquareLibraryGroupBinding4.groupView) == null) {
                                return;
                            }
                            focusGroupView3.setUnReadView(squareBaseMessageRecord);
                        }
                    }, 2, null);
                }
            }
            if (FocusDataKt.hasMe(focusGroupItem)) {
                getFocusDialog().showFirstGroupFocusDialog(getContext());
            }
            FocusRecordComponent focusRecordComponent = (FocusRecordComponent) getComponent(FocusRecordComponent.class, null, null);
            if (focusRecordComponent != null) {
                focusRecordComponent.doGroupMeRecordAvatar(focusGroupItem);
            }
        }
    }

    private final void doShare() {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context ?: return");
            getFocusDialog().showShareFindDeskDialog(context, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$doShare$1
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
                    TemplateShareComponent templateShareComponent;
                    if (!z16 || (templateShareComponent = (TemplateShareComponent) VasBaseLifecycleFragment.getComponent$default(FocusGroupFragment.this, TemplateShareComponent.class, null, null, 6, null)) == null) {
                        return;
                    }
                    templateShareComponent.doShare(1, 1);
                }
            });
        }
    }

    private final void doStartFocus(final FocusItem item) {
        final Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context ?: return");
            if (isMeSeat()) {
                trySwitchTable(item);
                return;
            }
            boolean z16 = !item.getTable().getHasNeighbor();
            Table neighbor = item.getTable().getNeighbor();
            new LibraryFocusPanel(context, z16, true, (neighbor != null ? neighbor.getUser() : null) != null, item.getRoomId(), item.getTable().getId(), new ITagPanelListener() { // from class: com.tencent.state.library.focus.FocusGroupFragment$doStartFocus$1
                @Override // com.tencent.state.common.tag.ITagPanelListener
                public void onFocusFailed(boolean z17, SitDownTagParams sitDownTagParams) {
                    ITagPanelListener.DefaultImpls.onFocusFailed(this, z17, sitDownTagParams);
                }

                @Override // com.tencent.state.common.tag.ITagPanelListener
                public void onFocusSuccess(User user) {
                    VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding;
                    FocusGroupView focusGroupView;
                    Intrinsics.checkNotNullParameter(user, "user");
                    SquareUtil squareUtil = SquareUtil.INSTANCE;
                    Context context2 = context;
                    if (!(context2 instanceof Activity)) {
                        context2 = null;
                    }
                    squareUtil.setKeepScreen((Activity) context2, true);
                    FocusGroupFragment.this.notifyLibraryMeSitDown(user);
                    vasSquareLibraryGroupBinding = FocusGroupFragment.this.binding;
                    if (vasSquareLibraryGroupBinding != null && (focusGroupView = vasSquareLibraryGroupBinding.groupView) != null) {
                        focusGroupView.updateBubbleData(item.getTable().getId(), user);
                    }
                    SitDownInfo sitDown = user.getSitDown();
                    Long valueOf = sitDown != null ? Long.valueOf(sitDown.getTableId()) : null;
                    if (!user.isMe() || valueOf == null) {
                        return;
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new GlobalMeFocusStartSquareEvent(FocusType.Library, user, valueOf.longValue()));
                }
            }).show();
        }
    }

    private final void trySwitchTable(FocusItem item) {
        TemplateCommonOperateComponent templateCommonOperateComponent;
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context ?: return");
            String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
            if (currentAccountUin == null || (templateCommonOperateComponent = (TemplateCommonOperateComponent) VasBaseLifecycleFragment.getComponent$default(this, TemplateCommonOperateComponent.class, null, null, 6, null)) == null) {
                return;
            }
            templateCommonOperateComponent.switchTable(context, currentAccountUin, item.getRoomId(), item.getTable().getId(), null, true, null);
        }
    }

    @Override // com.tencent.state.library.focus.FocusGroupListener
    public void clearUnReadCache(String uin) {
        FocusGroupView focusGroupView;
        Intrinsics.checkNotNullParameter(uin, "uin");
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        if (vasSquareLibraryGroupBinding == null || (focusGroupView = vasSquareLibraryGroupBinding.groupView) == null) {
            return;
        }
        focusGroupView.setUnReadView(null);
    }

    @Override // com.tencent.state.library.focus.FocusGroupListener
    public void doFuncBtnClick(final ClickType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$doFuncBtnClick$1
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
                it.onFuncButtonClicked(ClickType.this);
            }
        });
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public int getAppId() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List listOf;
        List plus;
        List<FragmentComponent> mutableList;
        List listOf2;
        List<FragmentComponent> components = super.getComponents();
        int i3 = 0;
        int i16 = 2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new FocusRecordComponent(), new FocusGroupReportComponent(), new LibraryMsgBoxComponent(), new FocusCalendarComponent()});
        plus = CollectionsKt___CollectionsKt.plus((Collection) components, (Iterable) listOf);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) plus);
        FocusBaseItem data = getData();
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (!(data instanceof FocusGroupItem)) {
            data = null;
        }
        FocusGroupItem focusGroupItem = (FocusGroupItem) data;
        if (focusGroupItem != null && focusGroupItem.getFocusItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin()) != null) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new PublicChatCommonComponent(this, i3, i16, defaultConstructorMarker), new LibraryPublicChatComponent()});
            mutableList.addAll(listOf2);
        }
        return mutableList;
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment
    public IFocusParentView getFragmentView() {
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        if (vasSquareLibraryGroupBinding != null) {
            return vasSquareLibraryGroupBinding.groupView;
        }
        return null;
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return "pg_zplan_library_double_focus";
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public long getRoomId() {
        return IPublicChatOwner.DefaultImpls.getRoomId(this);
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public RoomThemeData getRoomThemeData() {
        return IPublicChatOwner.DefaultImpls.getRoomThemeData(this);
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public Scene getScene() {
        return IPublicChatOwner.DefaultImpls.getScene(this);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.library.focus.FocusGroupListener
    public boolean isPublicChatEnabled() {
        PublicChatConfInfo publicChatConfInfo = this.publicChatConf;
        return publicChatConfInfo != null && publicChatConfInfo.getShow();
    }

    @Override // com.tencent.state.square.api.UnreadMessageObserver
    public void notifyUnreadMessage(final SquareBaseMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String uin = message.getUin();
        FocusBaseItem data = getData();
        if (Intrinsics.areEqual(uin, data != null ? FocusDataKt.meDeskUin(data) : null)) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$notifyUnreadMessage$1
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
                    VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding;
                    FocusGroupView focusGroupView;
                    vasSquareLibraryGroupBinding = FocusGroupFragment.this.binding;
                    if (vasSquareLibraryGroupBinding == null || (focusGroupView = vasSquareLibraryGroupBinding.groupView) == null) {
                        return;
                    }
                    focusGroupView.setUnReadView(message);
                }
            });
        }
    }

    @Override // com.tencent.state.library.focus.FocusGroupListener
    public void onCallMateClick() {
        LibraryPublicChatComponent libraryPublicChatComponent = (LibraryPublicChatComponent) getComponent(LibraryPublicChatComponent.class, null, null);
        if (libraryPublicChatComponent != null) {
            FocusBaseItem data = getData();
            libraryPublicChatComponent.callGather((FocusGroupItem) (data instanceof FocusGroupItem ? data : null));
        }
    }

    @Override // com.tencent.state.library.focus.FocusGroupListener
    public void onChatBoxClicked(final View v3, String uin, String nick) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(uin, "uin");
        LibraryChatComponent libraryChatComponent = (LibraryChatComponent) getComponent(LibraryChatComponent.class, null, null);
        if (libraryChatComponent != null) {
            libraryChatComponent.openAioChat(uin, nick);
        }
        forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$onChatBoxClicked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                it.onChatBoxClicked(v3);
            }
        });
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public void onConfigLoaded(PublicChatConfInfo conf) {
        FocusGroupView focusGroupView;
        Intrinsics.checkNotNullParameter(conf, "conf");
        this.publicChatConf = conf;
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
        if (vasSquareLibraryGroupBinding == null || (focusGroupView = vasSquareLibraryGroupBinding.groupView) == null) {
            return;
        }
        focusGroupView.updateCallMateBtn();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareLibraryGroupBinding inflate = VasSquareLibraryGroupBinding.inflate(inflater);
        this.binding = inflate;
        if (inflate != null) {
            return inflate.getMContainer();
        }
        return null;
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        doOnDestroy();
    }

    @Override // com.tencent.state.library.focus.FocusGroupListener
    public void onEmptyTableClicked(final int type, final FocusItem item) {
        User user;
        User user2;
        SitDownInfo sitDown;
        CommonTagInfo subTag;
        String id5;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(item, "item");
        Table neighbor = item.getTable().getNeighbor();
        if (neighbor != null && (user = neighbor.getUser()) != null) {
            if (user.isMe()) {
                Table neighbor2 = item.getTable().getNeighbor();
                if (neighbor2 != null && (user2 = neighbor2.getUser()) != null && (sitDown = user2.getSitDown()) != null && (subTag = sitDown.getSubTag()) != null && (id5 = subTag.getId()) != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(id5);
                    if (!(isBlank)) {
                        doShare();
                        forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$onEmptyTableClicked$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                it.onEmptyTableClicked(type, item);
                            }
                        });
                    }
                }
                Table neighbor3 = item.getTable().getNeighbor();
                doEditDeskMateTag(neighbor3 != null ? neighbor3.getUser() : null, item);
                forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$onEmptyTableClicked$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        it.onEmptyTableClicked(type, item);
                    }
                });
            }
        }
        doStartFocus(item);
        forEachComponent(IFocusEventListener.class, null, null, new Function1<IFocusEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$onEmptyTableClicked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                it.onEmptyTableClicked(type, item);
            }
        });
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment
    public void onFocusBackPress() {
        FocusItem rightItem;
        FocusItem item;
        FocusBaseItem data = getData();
        if (data != null && (item = data.getItem()) != null) {
            updateLibraryItemVisible(FocusDataKt.getId(item), FocusDataKt.getType(item), true);
        }
        FocusBaseItem data2 = getData();
        if (data2 == null || (rightItem = data2.getRightItem()) == null) {
            return;
        }
        updateLibraryItemVisible(FocusDataKt.getId(rightItem), FocusDataKt.getType(rightItem), true);
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public void onMsgAction(MsgAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        IPublicChatOwner.DefaultImpls.onMsgAction(this, action);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.fromPause.set(true);
        onFocusChange(false);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onFocusChange(true);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        doOnViewCreated();
        forEachComponent(IPublicChatOwnerEventListener.class, null, null, new Function1<IPublicChatOwnerEventListener, Unit>() { // from class: com.tencent.state.library.focus.FocusGroupFragment$onViewCreated$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IPublicChatOwnerEventListener iPublicChatOwnerEventListener) {
                invoke2(iPublicChatOwnerEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IPublicChatOwnerEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                IPublicChatOwnerEventListener.DefaultImpls.onSceneReady$default(it, false, 1, null);
            }
        });
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.library.focus.FocusBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    private final void doEditDeskMateTag(User user, FocusItem item) {
        Context context;
        if (user == null || (context = getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "context ?: return");
        TemplateCommonOperateComponent templateCommonOperateComponent = (TemplateCommonOperateComponent) VasBaseLifecycleFragment.getComponent$default(this, TemplateCommonOperateComponent.class, null, null, 6, null);
        if (templateCommonOperateComponent != null) {
            TemplateCommonOperateComponent.showEditDeskMateTagPanel$default(templateCommonOperateComponent, context, user, item.getRoomId(), item.getTable().getId(), null, 16, null);
        }
    }

    private final void onFocusChange(boolean isVisible) {
        FocusGroupView focusGroupView;
        VasSquareLibraryGroupViewBinding binding;
        SquareAvatarView squareAvatarView;
        FocusGroupView focusGroupView2;
        VasSquareLibraryGroupViewBinding binding2;
        SquareAvatarView squareAvatarView2;
        FocusGroupView focusGroupView3;
        FocusGroupView focusGroupView4;
        if (isVisible && this.fromPause.compareAndSet(true, false)) {
            VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding = this.binding;
            if (vasSquareLibraryGroupBinding != null && (focusGroupView4 = vasSquareLibraryGroupBinding.groupView) != null) {
                focusGroupView4.playTargetAvatar(true);
            }
            VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding2 = this.binding;
            if (vasSquareLibraryGroupBinding2 == null || (focusGroupView3 = vasSquareLibraryGroupBinding2.groupView) == null) {
                return;
            }
            focusGroupView3.playTargetAvatar(false);
            return;
        }
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding3 = this.binding;
        if (vasSquareLibraryGroupBinding3 != null && (focusGroupView2 = vasSquareLibraryGroupBinding3.groupView) != null && (binding2 = focusGroupView2.getBinding()) != null && (squareAvatarView2 = binding2.leftAvatarImage) != null) {
            squareAvatarView2.stop();
        }
        VasSquareLibraryGroupBinding vasSquareLibraryGroupBinding4 = this.binding;
        if (vasSquareLibraryGroupBinding4 == null || (focusGroupView = vasSquareLibraryGroupBinding4.groupView) == null || (binding = focusGroupView.getBinding()) == null || (squareAvatarView = binding.rightAvatarImage) == null) {
            return;
        }
        squareAvatarView.stop();
    }
}
