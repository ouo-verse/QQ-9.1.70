package com.tencent.state.square.chatland.component;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.event.Event;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.chatland.data.ChatLandAvatarExtra;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.square.chatland.view.ChatLandAvatarPanelController;
import com.tencent.state.square.chatland.view.ChatLandDialogTips;
import com.tencent.state.square.chatland.view.ChatLandRepeatListController;
import com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder;
import com.tencent.state.square.components.SquareBlockDialogUtils;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.components.fragment.SquareBaseComponent;
import com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.detail.BaseDetailFragmentConfig;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.detail.DetailGuestFragmentConfig;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.StatusUpdateData;
import com.tencent.state.square.detail.SubScene;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.push.BubbleMessage;
import com.tencent.state.utils.FlagsHelper;
import com.tencent.state.utils.VMUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0002{|B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\"\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020(0-J\b\u0010.\u001a\u00020(H\u0002J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020(J\u000e\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u000206J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u0002080;2\u0006\u0010<\u001a\u00020+H\u0002J\u0018\u0010=\u001a\u00020\u00062\u0006\u00109\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u0006J\u0010\u0010@\u001a\u0004\u0018\u00010+2\u0006\u0010A\u001a\u00020\u0006J\b\u0010B\u001a\u0004\u0018\u00010CJ\b\u0010D\u001a\u0004\u0018\u000108J\u0006\u0010E\u001a\u00020\u0006J\u001c\u0010F\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010Gj\u0004\u0018\u0001`H2\u0006\u00109\u001a\u00020>H\u0002J\u0006\u0010I\u001a\u00020(J\u000e\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020+J\u000e\u0010L\u001a\u00020(2\u0006\u00109\u001a\u00020>J\u0006\u0010M\u001a\u00020(J\u0010\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020PH\u0016J*\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u0002002\u0006\u0010S\u001a\u00020T2\u0006\u0010A\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010+H\u0016J\b\u0010U\u001a\u00020(H\u0016J\u0010\u0010V\u001a\u00020(2\u0006\u0010W\u001a\u00020\u0016H\u0002J,\u0010X\u001a\u00020(2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020T2\b\u0010^\u001a\u0004\u0018\u00010PH\u0016J\"\u0010_\u001a\u00020(2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010`\u001a\u000200H\u0016J\b\u0010a\u001a\u00020(H\u0016J<\u0010b\u001a\u00020(2\u000e\u0010c\u001a\n\u0012\u0002\b\u00030Gj\u0002`H2\u0006\u0010A\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010+2\u0006\u0010d\u001a\u00020\u00062\b\u0010e\u001a\u0004\u0018\u00010\u001dH\u0016J2\u0010f\u001a\u00020(2\u000e\u0010c\u001a\n\u0012\u0002\b\u00030Gj\u0002`H2\u0006\u0010A\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010+2\u0006\u0010d\u001a\u00020\u0006H\u0016J\u0010\u0010g\u001a\u00020(2\u0006\u0010K\u001a\u00020hH\u0016J\u0012\u0010i\u001a\u00020(2\b\u0010K\u001a\u0004\u0018\u00010hH\u0016J\u000e\u0010j\u001a\u00020(2\u0006\u0010K\u001a\u000208J\u0006\u0010k\u001a\u00020(J\u0010\u0010l\u001a\u00020(2\u0006\u0010K\u001a\u00020+H\u0002J\u0006\u0010m\u001a\u00020(J\u0016\u0010n\u001a\u00020(2\u0006\u0010K\u001a\u00020+2\u0006\u0010o\u001a\u000200J\u001c\u0010p\u001a\u00020(2\u0006\u00109\u001a\u00020>2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020(0-J\u0010\u0010r\u001a\u00020(2\u0006\u0010K\u001a\u00020hH\u0002J\u0010\u0010s\u001a\u0002002\u0006\u0010A\u001a\u00020\u0006H\u0002J\u0016\u0010t\u001a\u00020(2\u0006\u0010A\u001a\u00020\u00062\u0006\u0010K\u001a\u00020+J\u000e\u0010u\u001a\u00020(2\u0006\u0010v\u001a\u00020wJ\u0016\u0010x\u001a\u00020(2\u0006\u00109\u001a\u00020>2\u0006\u0010y\u001a\u00020zR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006}"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandSquareComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "owner", "Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;", "appId", "", "(Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;I)V", "getAppId", "()I", "avatarViewPanelController", "Lcom/tencent/state/square/chatland/view/ChatLandAvatarPanelController;", "getAvatarViewPanelController", "()Lcom/tencent/state/square/chatland/view/ChatLandAvatarPanelController;", "avatarViewPanelController$delegate", "Lkotlin/Lazy;", "chatLandRepeatListController", "Lcom/tencent/state/square/chatland/view/ChatLandRepeatListController;", "getChatLandRepeatListController", "()Lcom/tencent/state/square/chatland/view/ChatLandRepeatListController;", "chatLandRepeatListController$delegate", "flagsHelper", "Lcom/tencent/state/utils/FlagsHelper;", "squareGroupVM", "Lcom/tencent/state/square/SquareViewModel;", "getSquareGroupVM", "()Lcom/tencent/state/square/SquareViewModel;", "squareGroupVM$delegate", "value", "", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "vm", "Lcom/tencent/state/square/SquareMapViewModel;", "waitMapReadyAddList", "Lcom/tencent/state/square/chatland/component/ChatLandSquareComponent$WaitMapReadyAddList;", "appendOrUpdateChatLandUserItem", "", "list", "", "Lcom/tencent/state/map/MapItem;", "onDone", "Lkotlin/Function0;", "checkMsgHeaderPanelVisible", "checkViewVisible", "", "location", "Landroid/graphics/Rect;", "doWaitMapReadyAddListRender", "findTableIndex", "tableId", "", "getAvatarItemDataByUin", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "uin", "getClickAvatars", "", "current", "getIndexByUinType", "", "itemType", "getItemDataByIndex", "index", "getMapSize", "Landroid/util/Size;", "getMeAvatarItemData", "getSeatedUserCount", "getViewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "hideMsgHeaderPanel", "insertItem", "data", "locateToUin", "locateToWelcome", "onBackFromDetail", "bundle", "Landroid/os/Bundle;", "onCenterScaled", "isScaleToCenter", "view", "Landroid/view/View;", "onChatLandSeatAdded", "onFlagsChange", "helper", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", Constants.FILE_INSTANCE_STATE, "onFragmentVisibilityChanged", "isVisible", "onFriendStatusPanelClosed", "onItemClicked", "vh", "viewId", "extra", "onItemLongClick", "onMapDataReceived", "Lcom/tencent/state/map/MapData;", "onMapWelcomeScaleAnimEnd", "panelShow", "playFadeInAnim", "playFilament", "removeAllFlexAvatarItem", "removeItem", "skipAnim", "scaleToDetailAmin", "callback", "showWelcome", "tryScale", "updateByIndex", "updateSpeakMessageBubble", "message", "Lcom/tencent/state/template/push/BubbleMessage;", "updateTargetResource", "resource", "Lcom/tencent/state/square/data/Resource;", "Companion", "WaitMapReadyAddList", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSquareComponent extends SquareBaseComponent implements IChatLandEventListener {
    private static final String FLAG_IS_CHAT_LANED_SEAT_INITED = "FLAG_IS_CHAT_LANED_SEAT_INITED";
    private static final String FLAG_IS_NEED_SHOW_WELCOME = "FLAG_IS_NEED_SHOW_WELCOME";
    private static final long LOCATE_TABLE_ID = 10001;
    private static final String TAG = "ChatLandSquareComponent";
    private final int appId;

    /* renamed from: avatarViewPanelController$delegate, reason: from kotlin metadata */
    private final Lazy avatarViewPanelController;

    /* renamed from: chatLandRepeatListController$delegate, reason: from kotlin metadata */
    private final Lazy chatLandRepeatListController;
    private final FlagsHelper flagsHelper;
    private final IChatLandUIOwner owner;

    /* renamed from: squareGroupVM$delegate, reason: from kotlin metadata */
    private final Lazy squareGroupVM;
    private SquareMapViewModel vm;
    private WaitMapReadyAddList waitMapReadyAddList;

    public ChatLandSquareComponent(IChatLandUIOwner owner, int i3) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        List listOf;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.appId = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChatLandAvatarPanelController>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$avatarViewPanelController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ChatLandAvatarPanelController invoke() {
                return new ChatLandAvatarPanelController(new Function0<SquareView>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$avatarViewPanelController$2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SquareView invoke() {
                        SquareView mapView;
                        mapView = ChatLandSquareComponent.this.getMapView();
                        return mapView;
                    }
                }, new Function1<Long, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$avatarViewPanelController$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                        invoke(l3.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j3) {
                        WeakReference<VasBaseFragmentComponentGroup> parent;
                        FragmentComponent fragmentComponent;
                        FragmentComponent component$default;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                        ChatLandSquareComponent chatLandSquareComponent = ChatLandSquareComponent.this;
                        FragmentComponent fragmentComponent2 = null;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSquareComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSquareComponent);
                        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = chatLandSquareComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandSquareComponent).fragment;
                            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSquareComponent).parentFragment;
                                if (vasBaseFragment2 != null) {
                                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null);
                                }
                            } else {
                                fragmentComponent2 = component$default;
                            }
                            fragmentComponent = fragmentComponent2;
                        }
                        ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) fragmentComponent;
                        if (chatLandInteractionMotionComponent != null) {
                            chatLandInteractionMotionComponent.openInviteDialog(j3);
                        }
                    }
                }, new Function2<String, String, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$avatarViewPanelController$2.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                        invoke2(str, str2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String uin, String nick) {
                        IChatLandUIOwner iChatLandUIOwner;
                        Intrinsics.checkNotNullParameter(uin, "uin");
                        Intrinsics.checkNotNullParameter(nick, "nick");
                        iChatLandUIOwner = ChatLandSquareComponent.this.owner;
                        iChatLandUIOwner.onOpenAIO(uin, nick);
                    }
                }, new Function1<String, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$avatarViewPanelController$2.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String uin) {
                        VasBaseFragment fragment;
                        MapViewHolder viewHolder;
                        VasBaseFragment fragment2;
                        QBaseActivity activity;
                        String str;
                        BaseDetailFragmentConfig detailGuestFragmentConfig;
                        VasBaseFragment fragment3;
                        Context context;
                        Intrinsics.checkNotNullParameter(uin, "uin");
                        fragment = ChatLandSquareComponent.this.getFragment();
                        if (fragment != null) {
                            if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                                fragment3 = ChatLandSquareComponent.this.getFragment();
                                if (fragment3 == null || (context = fragment3.getContext()) == null) {
                                    return;
                                }
                                IRouter router = Square.INSTANCE.getConfig().getRouter();
                                Intrinsics.checkNotNullExpressionValue(context, "context");
                                router.routeToNearbyDetailPage(context, uin);
                                return;
                            }
                            viewHolder = ChatLandSquareComponent.this.getViewHolder(uin);
                            if (viewHolder == null || !viewHolder.onScaleToDetail()) {
                                return;
                            }
                            DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
                            fragment2 = ChatLandSquareComponent.this.getFragment();
                            MainScene parse = MainScene.INSTANCE.parse(Integer.valueOf(ChatLandSquareComponent.this.getAppId()));
                            SubScene subScene = SubScene.UNKNOWN;
                            activity = ChatLandSquareComponent.this.getActivity();
                            if (activity == null || (str = SquareGroupReportComponentKt.getSourceFrom(activity)) == null) {
                                str = "";
                            }
                            EntranceSource entranceSource = new EntranceSource(parse, subScene, str);
                            if (CommonDataKt.isMe(Long.parseLong(uin))) {
                                detailGuestFragmentConfig = new DetailMeFragmentConfig();
                            } else {
                                detailGuestFragmentConfig = new DetailGuestFragmentConfig();
                            }
                            BaseDetailFragmentConfig baseDetailFragmentConfig = detailGuestFragmentConfig;
                            baseDetailFragmentConfig.setEnterWithScaleAnim(true);
                            Unit unit = Unit.INSTANCE;
                            DetailFragmentLauncher.launch$default(detailFragmentLauncher, fragment2, entranceSource, uin, baseDetailFragmentConfig, null, 16, null);
                        }
                    }
                });
            }
        });
        this.avatarViewPanelController = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new ChatLandSquareComponent$chatLandRepeatListController$2(this));
        this.chatLandRepeatListController = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SquareViewModel>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$squareGroupVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareViewModel invoke() {
                SquareFragment squareFragment;
                VasBaseGroupFragment groupFragment;
                squareFragment = ChatLandSquareComponent.this.getSquareFragment();
                if (squareFragment == null || (groupFragment = squareFragment.getGroupFragment()) == null) {
                    return null;
                }
                return (SquareViewModel) VMUtils.INSTANCE.safelyGet(groupFragment, SquareViewModel.class, String.valueOf(ChatLandSquareComponent.this.getAppId()));
            }
        });
        this.squareGroupVM = lazy3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{FLAG_IS_CHAT_LANED_SEAT_INITED, FLAG_IS_NEED_SHOW_WELCOME});
        this.flagsHelper = new FlagsHelper(listOf, new ChatLandSquareComponent$flagsHelper$1(this));
    }

    private final void checkMsgHeaderPanelVisible() {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$checkMsgHeaderPanelVisible$1
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
                ChatLandAvatarPanelController avatarViewPanelController;
                WeakReference<VasBaseFragmentComponentGroup> parent;
                VasBaseFragment vasBaseFragment;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                WeakReference<VasBaseFragmentComponentGroup> parent2;
                VasBaseFragment vasBaseFragment2;
                FragmentComponent component$default2;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
                ChatLandAvatarPanelController avatarViewPanelController2;
                avatarViewPanelController = ChatLandSquareComponent.this.getAvatarViewPanelController();
                String currentUin = avatarViewPanelController.getCurrentUin();
                if (currentUin != null) {
                    ChatLandSquareComponent chatLandSquareComponent = ChatLandSquareComponent.this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(chatLandSquareComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSquareComponent);
                    if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = chatLandSquareComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) chatLandSquareComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) chatLandSquareComponent).parentFragment;
                        component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSquareComponent.class, null, null, 6, null) : null;
                    }
                    ChatLandSquareComponent chatLandSquareComponent2 = (ChatLandSquareComponent) component$default;
                    Integer valueOf = chatLandSquareComponent2 != null ? Integer.valueOf(ChatLandSquareComponent.getIndexByUinType$default(chatLandSquareComponent2, currentUin, 0, 2, null)) : null;
                    if (valueOf != null && valueOf.intValue() != -1) {
                        ChatLandSquareComponent chatLandSquareComponent3 = ChatLandSquareComponent.this;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(chatLandSquareComponent3 instanceof VasBaseFragmentComponentGroup) ? null : chatLandSquareComponent3);
                        if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent2 = chatLandSquareComponent3.getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSquareComponent3).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
                            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) chatLandSquareComponent3).parentFragment;
                            component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSquareComponent.class, null, null, 6, null) : null;
                        }
                        ChatLandSquareComponent chatLandSquareComponent4 = (ChatLandSquareComponent) component$default2;
                        MapItem itemDataByIndex = chatLandSquareComponent4 != null ? chatLandSquareComponent4.getItemDataByIndex(valueOf.intValue()) : null;
                        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) (itemDataByIndex instanceof ChatLandAvatarItem ? itemDataByIndex : null);
                        if (chatLandAvatarItem != null) {
                            avatarViewPanelController2 = ChatLandSquareComponent.this.getAvatarViewPanelController();
                            avatarViewPanelController2.updateLocation(chatLandAvatarItem, ChatLandSquareComponent.this.getMeAvatarItemData());
                            return;
                        }
                        return;
                    }
                    ChatLandSquareComponent.this.hideMsgHeaderPanel();
                }
            }
        });
    }

    public final ChatLandAvatarPanelController getAvatarViewPanelController() {
        return (ChatLandAvatarPanelController) this.avatarViewPanelController.getValue();
    }

    private final ChatLandRepeatListController getChatLandRepeatListController() {
        return (ChatLandRepeatListController) this.chatLandRepeatListController.getValue();
    }

    private final List<ChatLandAvatarItem> getClickAvatars(final MapItem current) {
        MapAdapter adapter;
        final ArrayList arrayList = new ArrayList();
        if (current instanceof ChatLandTableItem) {
            return arrayList;
        }
        final int centerX = current.getLocation().getCenterX();
        final int centerY = current.getLocation().getCenterY();
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$getClickAvatars$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if ((mapItem instanceof ChatLandAvatarItem) && !((ChatLandAvatarItem) mapItem).getUser().isReceiver() && mapItem.getItemViewLocation().contains(centerX, centerY) && (!Intrinsics.areEqual(mapItem, MapItem.this))) {
                        arrayList.add(mapItem);
                    }
                }
            });
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator<T>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$getClickAvatars$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((ChatLandAvatarItem) t17).getLocation().getCenterY()), Integer.valueOf(((ChatLandAvatarItem) t16).getLocation().getCenterY()));
                    return compareValues;
                }
            });
        }
        if (!(current instanceof ChatLandAvatarItem)) {
            current = null;
        }
        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) current;
        if (chatLandAvatarItem != null && !chatLandAvatarItem.getUser().isReceiver()) {
            arrayList.add(0, chatLandAvatarItem);
        }
        return arrayList;
    }

    private final SquareViewModel getSquareGroupVM() {
        return (SquareViewModel) this.squareGroupVM.getValue();
    }

    public final MapViewHolder<?> getViewHolder(final String uin) {
        MapAdapter adapter;
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null) {
            return null;
        }
        int indexOf = adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$getViewHolder$index$1
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
                return Intrinsics.areEqual(it.getUin(), uin) && it.getType() == 10;
            }
        });
        SquareView mapView2 = getMapView();
        if (mapView2 != null) {
            return mapView2.getViewHolder(indexOf);
        }
        return null;
    }

    public final void onFlagsChange(FlagsHelper helper) {
        List<String> listOf;
        SquareMapViewModel squareMapViewModel;
        LiveData<MapData> data;
        MapData value;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{FLAG_IS_CHAT_LANED_SEAT_INITED, FLAG_IS_NEED_SHOW_WELCOME});
        if (!helper.isFlagsTrue(listOf) || (squareMapViewModel = this.vm) == null || (data = squareMapViewModel.getData()) == null || (value = data.getValue()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(value, "vm?.data?.value ?: return");
        showWelcome(value);
    }

    public final void playFilament(MapItem data) {
        SquareView mapView;
        IMapPlayManager iMapPlayManager;
        MapPlayableItem mapPlayableItem = (MapPlayableItem) (!(data instanceof MapPlayableItem) ? null : data);
        if (mapPlayableItem == null || (mapView = getMapView()) == null || (iMapPlayManager = (IMapPlayManager) mapView.getComponent(IMapPlayManager.class)) == null) {
            return;
        }
        iMapPlayManager.onPlayFilament(mapPlayableItem, ((MapPlayableItem) data).isMe());
    }

    private final void showWelcome(MapData data) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        LiveData<Integer> tipType;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(SquareFriendStatusPanelComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(SquareFriendStatusPanelComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareFriendStatusPanelComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareFriendStatusPanelComponent.class, null, null, 6, null) : null;
        }
        SquareFriendStatusPanelComponent squareFriendStatusPanelComponent = (SquareFriendStatusPanelComponent) component$default;
        if (squareFriendStatusPanelComponent != null && squareFriendStatusPanelComponent.isPanelShowing()) {
            SquareBaseKt.getSquareLog().d(TAG, "showWelcome cancel by friend panel");
            return;
        }
        if (!GuideContext.INSTANCE.hasCheckedCreateRoleGuide()) {
            SquareBaseKt.getSquareLog().d(TAG, "showWelcome cancel by guide");
            return;
        }
        if (SquareBlockDialogUtils.INSTANCE.isBlockDialog(getActivity())) {
            SquareBaseKt.getSquareLog().d(TAG, "showWelcome cancel by block dialog");
            return;
        }
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.ChatLand.HAS_SHOW_CHAT_LAND_WELCOME_TIPS, false, null, false, 12, null)) {
            SquareBaseKt.getSquareLog().d(TAG, "showWelcome cancel by have shown");
            return;
        }
        SquareMapViewModel squareMapViewModel = this.vm;
        Integer value = (squareMapViewModel == null || (tipType = squareMapViewModel.getTipType()) == null) ? null : tipType.getValue();
        if (value == null || value.intValue() != 3) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showWelcome cancel by tipType ");
            SquareMapViewModel squareMapViewModel2 = this.vm;
            sb5.append(squareMapViewModel2 != null ? squareMapViewModel2.getTipType() : null);
            squareLog.d(TAG, sb5.toString());
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$showWelcome$1
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
                VasBaseFragment fragment;
                IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.ChatLand.HAS_SHOW_CHAT_LAND_WELCOME_TIPS, true, null, false, 12, null);
                ChatLandDialogTips chatLandDialogTips = ChatLandDialogTips.INSTANCE;
                fragment = ChatLandSquareComponent.this.getFragment();
                chatLandDialogTips.showWelcomeTip(fragment != null ? fragment.getContext() : null, ChatLandSquareComponent.this.getAppId(), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$showWelcome$1.1
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
                            ChatLandSquareComponent.this.locateToWelcome();
                        }
                    }
                });
            }
        });
    }

    private final boolean tryScale(int index) {
        MapViewHolder<?> viewHolder;
        SquareView mapView = getMapView();
        if (mapView == null || (viewHolder = mapView.getViewHolder(index)) == null) {
            return false;
        }
        MapViewHolder.doScaleToDetail$default(viewHolder, 18, null, 2, null);
        return true;
    }

    public final void appendOrUpdateChatLandUserItem(final List<? extends MapItem> list, final Function0<Unit> onDone) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.post(new Runnable() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$appendOrUpdateChatLandUserItem$1
                @Override // java.lang.Runnable
                public final void run() {
                    SquareView mapView2;
                    ISquareViewUpdater updater;
                    mapView2 = ChatLandSquareComponent.this.getMapView();
                    if (mapView2 == null || (updater = mapView2.getUpdater()) == null) {
                        return;
                    }
                    updater.appendOrUpdateChatLandUserItem(list, onDone);
                }
            });
        }
    }

    public final boolean checkViewVisible(Rect location) {
        MapItemController controller;
        IMapItemViewManager viewManager;
        Intrinsics.checkNotNullParameter(location, "location");
        SquareView mapView = getMapView();
        if (mapView == null) {
            return false;
        }
        Rect rect = new Rect((int) (location.left * mapView.getCurrentZoomRatio()), (int) (location.top * mapView.getCurrentZoomRatio()), (int) (location.right * mapView.getCurrentZoomRatio()), (int) (location.bottom * mapView.getCurrentZoomRatio()));
        MapAdapter adapter = mapView.getAdapter();
        if (adapter == null || (controller = adapter.getController()) == null || (viewManager = controller.getViewManager()) == null) {
            return false;
        }
        return viewManager.checkLocationInScreen(rect);
    }

    public final void doWaitMapReadyAddListRender() {
        ISquareViewUpdater updater;
        WaitMapReadyAddList waitMapReadyAddList = this.waitMapReadyAddList;
        if (waitMapReadyAddList != null) {
            SquareView mapView = getMapView();
            if (mapView != null && (updater = mapView.getUpdater()) != null) {
                updater.appendOrUpdateChatLandUserItem(waitMapReadyAddList.getList(), waitMapReadyAddList.getOnDone());
            }
            this.waitMapReadyAddList = null;
        }
    }

    public final int findTableIndex(final long tableId) {
        MapAdapter adapter;
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null) {
            return -1;
        }
        return adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$findTableIndex$1
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
                SitDownInfo sitDown;
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getAppId() == ChatLandSquareComponent.this.getAppId() && (((it instanceof ChatLandAvatarItem) && (sitDown = ((ChatLandAvatarItem) it).getUser().getSitDown()) != null && sitDown.getTableId() == tableId) || ((it instanceof ChatLandTableItem) && ((ChatLandTableItem) it).getTable().getId() == tableId));
            }
        });
    }

    public final int getAppId() {
        return this.appId;
    }

    public final ChatLandAvatarItem getAvatarItemDataByUin(long uin) {
        MapItem itemDataByIndex = getItemDataByIndex(getIndexByUinType(String.valueOf(uin), 10));
        if (!(itemDataByIndex instanceof ChatLandAvatarItem)) {
            itemDataByIndex = null;
        }
        return (ChatLandAvatarItem) itemDataByIndex;
    }

    public final int getIndexByUinType(String uin, int itemType) {
        MapAdapter adapter;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null) {
            return -1;
        }
        return adapter.indexOf(uin, itemType, this.appId);
    }

    public final MapItem getItemDataByIndex(int index) {
        MapAdapter adapter;
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null) {
            return null;
        }
        return adapter.getItemData(index);
    }

    public final Size getMapSize() {
        MapAdapter adapter;
        MapItemController controller;
        IMapLocator locator;
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null || (controller = adapter.getController()) == null || (locator = controller.getLocator()) == null) {
            return null;
        }
        return new Size(locator.getMapWidth(), locator.getMapHeight());
    }

    public final ChatLandAvatarItem getMeAvatarItemData() {
        MapItem itemDataByIndex = getItemDataByIndex(getIndexByUinType(SquareBaseKt.getSquareCommon().getCurrentAccountUin(), 10));
        if (!(itemDataByIndex instanceof ChatLandAvatarItem)) {
            itemDataByIndex = null;
        }
        return (ChatLandAvatarItem) itemDataByIndex;
    }

    public final int getSeatedUserCount() {
        MapAdapter adapter;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$getSeatedUserCount$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if (mapItem != null && mapItem.getType() == 10 && mapItem.getAppId() == ChatLandSquareComponent.this.getAppId()) {
                        intRef.element++;
                    }
                }
            });
        }
        return intRef.element;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent
    public Object getTag() {
        return Integer.valueOf(this.appId);
    }

    public final void hideMsgHeaderPanel() {
        getAvatarViewPanelController().hide();
    }

    public final void insertItem(final MapItem data) {
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(data, "data");
        SquareView mapView = getMapView();
        if (mapView != null && (updater = mapView.getUpdater()) != null) {
            updater.appendItem(data);
        }
        checkMsgHeaderPanelVisible();
        ChatLandRepeatListController.updateList$default(getChatLandRepeatListController(), data, false, 2, null);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$insertItem$1
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
                ChatLandSquareComponent.this.playFilament(data);
            }
        });
    }

    public final void locateToUin(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.getManipulator().locateTo(getIndexByUinType$default(this, uin, 0, 2, null), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$locateToUin$1
                public final void invoke(boolean z16) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void locateToWelcome() {
        IMapViewManipulator manipulator;
        MapAdapter adapter;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$locateToWelcome$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Integer] */
                /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.Integer] */
                public final void invoke(int i3, MapItem mapItem) {
                    SitDownInfo sitDown;
                    if ((mapItem instanceof ChatLandTableItem) && ((ChatLandTableItem) mapItem).getTable().getId() == 10001) {
                        Ref.ObjectRef.this.element = Integer.valueOf(i3);
                    } else if ((mapItem instanceof ChatLandAvatarItem) && (sitDown = ((ChatLandAvatarItem) mapItem).getUser().getSitDown()) != null && sitDown.getTableId() == 10001) {
                        Ref.ObjectRef.this.element = Integer.valueOf(i3);
                    }
                }
            });
        }
        Integer num = (Integer) objectRef.element;
        if (num != null) {
            num.intValue();
            SquareView mapView2 = getMapView();
            if (mapView2 == null || (manipulator = mapView2.getManipulator()) == null) {
                return;
            }
            Integer num2 = (Integer) objectRef.element;
            manipulator.locateTo(num2 != null ? num2.intValue() : 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$locateToWelcome$2
                public final void invoke(boolean z16) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onBackFromDetail(Bundle bundle) {
        SquareFragment squareFragment;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        boolean z16 = bundle.getBoolean(SquareConstants.ENTER_WITH_SCALE_ANIM);
        boolean z17 = bundle.getBoolean(SquareConstants.DETAIL_OPEN_IS_ME);
        if (z16 || z17 || (squareFragment = getSquareFragment()) == null) {
            return;
        }
        squareFragment.onVisibilityChanged(true, "chatLandBack");
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.setActionPanelVisibility(!isScaleToCenter);
        }
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandLeaveRoom() {
        IChatLandEventListener.DefaultImpls.onChatLandLeaveRoom(this);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandSeatAdded() {
        this.flagsHelper.update(FLAG_IS_CHAT_LANED_SEAT_INITED, true);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle r46) {
        LiveData<Event<Resource>> resourceOfMe;
        VasBaseFragment fragment;
        LifecycleOwner viewLifecycleOwner;
        LiveData<Event<StatusUpdateData>> statusUpdateData;
        LifecycleOwner viewLifecycleOwner2;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.vm = (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(f16, SquareMapViewModel.class, String.valueOf(this.appId));
        SquareViewModel squareGroupVM = getSquareGroupVM();
        if (squareGroupVM != null && (statusUpdateData = squareGroupVM.getStatusUpdateData()) != null) {
            VasBaseFragment fragment2 = getFragment();
            if (fragment2 == null || (viewLifecycleOwner2 = fragment2.getViewLifecycleOwner()) == null) {
                return;
            } else {
                statusUpdateData.observe(viewLifecycleOwner2, new Observer<Event<StatusUpdateData>>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$onFragmentViewCreated$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Event<StatusUpdateData> event) {
                        StatusUpdateData peekContent;
                        AvatarAction action;
                        Resource lookFront;
                        WeakReference<VasBaseFragmentComponentGroup> parent;
                        FragmentComponent fragmentComponent;
                        FragmentComponent component$default;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                        if (event == null || (peekContent = event.peekContent()) == null || (action = peekContent.getAction()) == null || (lookFront = action.getLookFront()) == null) {
                            return;
                        }
                        int actionId = lookFront.getActionId();
                        ChatLandSquareComponent chatLandSquareComponent = ChatLandSquareComponent.this;
                        FragmentComponent fragmentComponent2 = null;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSquareComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSquareComponent);
                        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandRoomComponent.class, null)) == null) && ((parent = chatLandSquareComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandRoomComponent.class, null)) == null)) {
                            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandSquareComponent).fragment;
                            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandRoomComponent.class, null, null, 2, null)) == null) {
                                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSquareComponent).parentFragment;
                                if (vasBaseFragment2 != null) {
                                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandRoomComponent.class, null, null, 6, null);
                                }
                            } else {
                                fragmentComponent2 = component$default;
                            }
                            fragmentComponent = fragmentComponent2;
                        }
                        ChatLandRoomComponent chatLandRoomComponent = (ChatLandRoomComponent) fragmentComponent;
                        if (chatLandRoomComponent != null) {
                            chatLandRoomComponent.notifyRoomUserRefresh(actionId);
                        }
                    }
                });
            }
        }
        SquareViewModel squareGroupVM2 = getSquareGroupVM();
        if (squareGroupVM2 == null || (resourceOfMe = squareGroupVM2.getResourceOfMe()) == null || (fragment = getFragment()) == null || (viewLifecycleOwner = fragment.getViewLifecycleOwner()) == null) {
            return;
        }
        resourceOfMe.observe(viewLifecycleOwner, new Observer<Event<Resource>>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$onFragmentViewCreated$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Event<Resource> event) {
                Resource peekContent;
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                if (event == null || (peekContent = event.peekContent()) == null) {
                    return;
                }
                int actionId = peekContent.getActionId();
                ChatLandSquareComponent chatLandSquareComponent = ChatLandSquareComponent.this;
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSquareComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSquareComponent);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandRoomComponent.class, null)) == null) && ((parent = chatLandSquareComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandRoomComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandSquareComponent).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandRoomComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSquareComponent).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandRoomComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                ChatLandRoomComponent chatLandRoomComponent = (ChatLandRoomComponent) fragmentComponent;
                if (chatLandRoomComponent != null) {
                    chatLandRoomComponent.notifyRoomUserRefresh(actionId);
                }
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        ChatLandAvatarItem meAvatarItemData;
        SquareView mapView;
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(f16, "f");
        if (isVisible || (meAvatarItemData = getMeAvatarItemData()) == null) {
            return;
        }
        Object extra = meAvatarItemData.getExtra();
        if (!(extra instanceof ChatLandAvatarExtra)) {
            extra = null;
        }
        ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) extra;
        if (chatLandAvatarExtra != null) {
            chatLandAvatarExtra.setNeedRingPagAnim(false);
            int indexByUinType = getIndexByUinType(SquareBaseKt.getSquareCommon().getCurrentAccountUin(), 10);
            if (indexByUinType == -1 || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
                return;
            }
            updater.updateItem(indexByUinType, meAvatarItemData);
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onFriendStatusPanelClosed() {
        LiveData<MapData> data;
        SquareMapViewModel squareMapViewModel = this.vm;
        if (squareMapViewModel == null || (data = squareMapViewModel.getData()) == null || data.getValue() == null) {
            return;
        }
        this.flagsHelper.update(FLAG_IS_NEED_SHOW_WELCOME, true);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Context context;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (data != null) {
            FragmentComponent fragmentComponent2 = null;
            if ((data.getAppId() == this.appId ? data : null) != null) {
                super.onItemClicked(vh5, index, data, viewId, extra);
                List<ChatLandAvatarItem> clickAvatars = getClickAvatars(data);
                if (clickAvatars.size() > 1) {
                    VasBaseFragment fragment = getFragment();
                    if (fragment == null || (context = fragment.getContext()) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
                    getChatLandRepeatListController().show(context, clickAvatars);
                    return;
                }
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSeatComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSeatComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSeatComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSeatComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                ChatLandSeatComponent chatLandSeatComponent = (ChatLandSeatComponent) fragmentComponent;
                if (chatLandSeatComponent != null) {
                    chatLandSeatComponent.onItemClicked(vh5, index, data, viewId, extra);
                }
            }
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemLongClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (data != null) {
            FragmentComponent fragmentComponent2 = null;
            if ((data.getAppId() == this.appId ? data : null) != null) {
                super.onItemLongClick(vh5, index, data, viewId);
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSeatComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSeatComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSeatComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSeatComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                ChatLandSeatComponent chatLandSeatComponent = (ChatLandSeatComponent) fragmentComponent;
                if (chatLandSeatComponent != null) {
                    IMapViewListener.DefaultImpls.onItemClicked$default(chatLandSeatComponent, vh5, index, data, viewId, null, 16, null);
                }
            }
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getFromCache()) {
            Integer valueOf = Integer.valueOf(this.appId);
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, valueOf)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, valueOf)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, valueOf, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
            if (chatLandUiComponent != null) {
                chatLandUiComponent.initCacheBackground();
            }
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapWelcomeScaleAnimEnd(MapData data) {
        this.flagsHelper.update(FLAG_IS_NEED_SHOW_WELCOME, true);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onPublicChatConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        IChatLandEventListener.DefaultImpls.onPublicChatConfigLoaded(this, conf);
    }

    public final void panelShow(ChatLandAvatarItem data) {
        Context context;
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(data, "data");
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        MapViewHolder<?> viewHolder = getViewHolder(data.getUin());
        if (viewHolder != null) {
            getAvatarViewPanelController().show(context, viewHolder, data, getMeAvatarItemData());
            SquareView mapView = getMapView();
            if (mapView == null || (updater = mapView.getUpdater()) == null) {
                return;
            }
            updater.hideSpeakBubble(data.getUin());
        }
    }

    public final void playFadeInAnim() {
        MapAdapter adapter;
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null) {
            return;
        }
        adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$playFadeInAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                invoke(num.intValue(), mapItem);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, MapItem mapItem) {
                SquareView mapView2;
                if (mapItem instanceof ChatLandAvatarItem) {
                    mapView2 = ChatLandSquareComponent.this.getMapView();
                    MapViewHolder<?> viewHolder = mapView2 != null ? mapView2.getViewHolder(i3) : null;
                    if (!(viewHolder instanceof ChatLandAvatarViewHolder)) {
                        viewHolder = null;
                    }
                    ChatLandAvatarViewHolder chatLandAvatarViewHolder = (ChatLandAvatarViewHolder) viewHolder;
                    if (chatLandAvatarViewHolder != null) {
                        ChatLandAvatarViewHolder.fadeIn$default(chatLandAvatarViewHolder, null, 1, null);
                    }
                }
            }
        });
    }

    public final void removeAllFlexAvatarItem() {
        ISquareViewUpdater updater;
        MapAdapter adapter;
        final ArrayList<MapItem> arrayList = new ArrayList();
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$removeAllFlexAvatarItem$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    SitDownInfo sitDown;
                    if ((mapItem instanceof ChatLandAvatarItem) && mapItem.getAppId() == ChatLandSquareComponent.this.getAppId() && (sitDown = ((ChatLandAvatarItem) mapItem).getUser().getSitDown()) != null && sitDown.getIsFlexTable()) {
                        arrayList.add(mapItem);
                    }
                }
            });
        }
        for (MapItem mapItem : arrayList) {
            SquareView mapView2 = getMapView();
            if (mapView2 != null && (updater = mapView2.getUpdater()) != null) {
                updater.hide(mapItem.getUin(), 10, false);
            }
        }
    }

    public final void removeItem(MapItem data, boolean skipAnim) {
        ISquareViewUpdater updater;
        ISquareViewUpdater updater2;
        Intrinsics.checkNotNullParameter(data, "data");
        SquareView mapView = getMapView();
        if (mapView != null && (updater2 = mapView.getUpdater()) != null) {
            updater2.hideRingAnim(data.getUin());
        }
        SquareView mapView2 = getMapView();
        if (mapView2 != null && (updater = mapView2.getUpdater()) != null) {
            updater.hide(data.getUin(), 10, skipAnim);
        }
        checkMsgHeaderPanelVisible();
        getChatLandRepeatListController().updateList(data, true);
    }

    public final void scaleToDetailAmin(String uin, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.scaleToDetailAmin(uin, 10, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$scaleToDetailAmin$1
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
                    Function0.this.invoke();
                }
            });
        }
    }

    public final void updateByIndex(int index, final MapItem data) {
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(data, "data");
        SquareView mapView = getMapView();
        if (mapView != null && (updater = mapView.getUpdater()) != null) {
            updater.updateItem(index, data);
        }
        checkMsgHeaderPanelVisible();
        ChatLandRepeatListController.updateList$default(getChatLandRepeatListController(), data, false, 2, null);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$updateByIndex$1
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
                ChatLandSquareComponent.this.playFilament(data);
            }
        });
    }

    public final void updateSpeakMessageBubble(BubbleMessage message) {
        SquareView mapView;
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(message, "message");
        if ((Intrinsics.areEqual(String.valueOf(message.getUin()), getAvatarViewPanelController().getCurrentUin()) && getAvatarViewPanelController().isShowing()) || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.updateSpeakBubble(message);
    }

    public final void updateTargetResource(String uin, Resource resource) {
        IMapViewUpdater iMapViewUpdater;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(resource, "resource");
        SquareView mapView = getMapView();
        if (mapView == null || (iMapViewUpdater = (IMapViewUpdater) mapView.getComponent(IMapViewUpdater.class)) == null) {
            return;
        }
        iMapViewUpdater.updateTargetResource(uin, resource, true);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J)\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandSquareComponent$WaitMapReadyAddList;", "", "list", "", "Lcom/tencent/state/map/MapItem;", "onDone", "Lkotlin/Function0;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "getOnDone", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class WaitMapReadyAddList {
        private final List<MapItem> list;
        private final Function0<Unit> onDone;

        /* JADX WARN: Multi-variable type inference failed */
        public WaitMapReadyAddList(List<? extends MapItem> list, Function0<Unit> onDone) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(onDone, "onDone");
            this.list = list;
            this.onDone = onDone;
        }

        public final List<MapItem> component1() {
            return this.list;
        }

        public final Function0<Unit> component2() {
            return this.onDone;
        }

        public final WaitMapReadyAddList copy(List<? extends MapItem> list, Function0<Unit> onDone) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(onDone, "onDone");
            return new WaitMapReadyAddList(list, onDone);
        }

        public final List<MapItem> getList() {
            return this.list;
        }

        public final Function0<Unit> getOnDone() {
            return this.onDone;
        }

        public int hashCode() {
            List<MapItem> list = this.list;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.onDone;
            return hashCode + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            return "WaitMapReadyAddList(list=" + this.list + ", onDone=" + this.onDone + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WaitMapReadyAddList)) {
                return false;
            }
            WaitMapReadyAddList waitMapReadyAddList = (WaitMapReadyAddList) other;
            return Intrinsics.areEqual(this.list, waitMapReadyAddList.list) && Intrinsics.areEqual(this.onDone, waitMapReadyAddList.onDone);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WaitMapReadyAddList copy$default(WaitMapReadyAddList waitMapReadyAddList, List list, Function0 function0, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = waitMapReadyAddList.list;
            }
            if ((i3 & 2) != 0) {
                function0 = waitMapReadyAddList.onDone;
            }
            return waitMapReadyAddList.copy(list, function0);
        }
    }

    public static /* synthetic */ int getIndexByUinType$default(ChatLandSquareComponent chatLandSquareComponent, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 10;
        }
        return chatLandSquareComponent.getIndexByUinType(str, i3);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent
    public void setTag(Object obj) {
    }
}
