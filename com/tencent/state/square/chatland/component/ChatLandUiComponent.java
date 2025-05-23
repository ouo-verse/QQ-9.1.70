package com.tencent.state.square.chatland.component;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.publicchat.PublicChatViewSlots;
import com.tencent.state.publicchat.component.PublicChatUIComponent;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.view.MsgNewBtnConfig;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.chatland.component.ChatLandUiComponent;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.chatland.view.AreaType;
import com.tencent.state.square.chatland.view.ChatLandBackgroundView;
import com.tencent.state.square.chatland.view.ChatLandDialogTips;
import com.tencent.state.square.chatland.view.ChatLandInteractionMotionIndicator;
import com.tencent.state.square.chatland.view.ChatLandInteractionMotionInvitePanel;
import com.tencent.state.square.chatland.view.ChatLandRefreshPanelView;
import com.tencent.state.square.chatland.view.IViewContainer;
import com.tencent.state.square.chatland.view.ImageTipsManager;
import com.tencent.state.square.chatland.view.InterMotionIndicatorInfo;
import com.tencent.state.square.chatland.view.OperationAdManger;
import com.tencent.state.square.chatland.view.PagTipsManager;
import com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder;
import com.tencent.state.square.databinding.VasSquareFragmentChatLandActionPanelBinding;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.square.databinding.VasSquareItemChatLandAvatarBinding;
import com.tencent.state.square.tasks.SquareTaskSheet;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.InteractionMotionState;
import com.tencent.state.template.data.InviteInfo;
import com.tencent.state.template.data.OperationAd;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.User;
import com.tencent.state.template.service.VasSquareRoomServiceKt;
import com.tencent.state.utils.CacheFileUtils;
import com.tencent.state.utils.CachePath;
import com.tencent.state.view.SquareImageView;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import fs4.r;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import wt4.f;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001`B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010$\u001a\u00020\u00192\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0002J\u0012\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-H\u0002J\b\u00100\u001a\u0004\u0018\u000101J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-H\u0002J \u00103\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u00104\u001a\u000205H\u0002J\u0006\u00106\u001a\u00020\u0019J\u0012\u00107\u001a\u00020\u00192\n\b\u0002\u00108\u001a\u0004\u0018\u00010.J\u0006\u00109\u001a\u00020\u0019J*\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0006\u0010?\u001a\u00020\u0019J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020BH\u0016J\u001a\u0010C\u001a\u00020\u00192\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020GH\u0016J\"\u0010H\u001a\u00020\u00192\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\u0006\u0010I\u001a\u00020\u001eH\u0016J \u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001eH\u0016J\b\u0010O\u001a\u00020\u0019H\u0016J\u0010\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020RH\u0016J\u000e\u0010S\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u001eJ\u000e\u0010W\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u001eJ\u000e\u0010X\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u001eJ\u000e\u0010Y\u001a\u00020\u00192\u0006\u0010=\u001a\u00020ZJ\u000e\u0010[\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\\J \u0010]\u001a\u00020\u00192\u0006\u0010^\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010_\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006a"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandUiComponent;", "Lcom/tencent/state/square/chatland/component/ChatLandMapBaseComponent;", "Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "Lcom/tencent/state/square/chatland/view/IViewContainer;", "owner", "Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;", "appId", "", "(Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;I)V", "actionPanel", "Lcom/tencent/state/square/databinding/VasSquareFragmentChatLandActionPanelBinding;", "backgroundView", "Lcom/tencent/state/square/chatland/view/ChatLandBackgroundView;", "imageTipsManager", "Lcom/tencent/state/square/chatland/view/ImageTipsManager;", "mapZoomLevel", "operationAdManger", "Lcom/tencent/state/square/chatland/view/OperationAdManger;", "pagTipsManager", "Lcom/tencent/state/square/chatland/view/PagTipsManager;", "refreshPanelView", "Lcom/tencent/state/square/chatland/view/ChatLandRefreshPanelView;", "roomInfo", "Lcom/tencent/state/template/data/CommonRoomInfo;", "addToMap", "", "view", "Landroid/view/View;", "addView", "backgroundClickInterceptor", "", "screenPoint", "Landroid/graphics/Point;", "mapPoint", "bindActionPanel", "bindBackground", "bindOperationAd", "ads", "", "Lcom/tencent/state/template/data/OperationAd;", "bindRefreshPanel", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "fetchRedDotFlag", "getBgReportParams", "", "", "", "getPublicChatViewSlots", "Lcom/tencent/state/publicchat/PublicChatViewSlots;", "getReportParams", "handleBackgroundClick", "areaType", "Lcom/tencent/state/square/chatland/view/AreaType;", "hideIndicator", "hideInvitePanel", "billNo", "initCacheBackground", "onCenterScaled", "isScaleToCenter", "index", "data", "Lcom/tencent/state/map/MapItem;", "onDetectorScroll", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentVisibilityChanged", "isVisible", "onMapZoomEnd", "zoomLevel", "scale", "", "isZoomIn", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "refreshTheme", "removeView", "setActionPanelButtonsVisibility", NodeProps.VISIBLE, "setActionPanelVisibility", "setTaskRedDotVisible", "showIndicator", "Lcom/tencent/state/square/chatland/view/InterMotionIndicatorInfo;", "showInvitePanel", "Lcom/tencent/state/template/data/InviteInfo;", "showWillSitLocationTips", "pagUrl", "showWrongSitLocationTips", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandUiComponent extends ChatLandMapBaseComponent implements IChatLandEventListener, IViewContainer {
    private static final String TAG = "ChatLandUiComponent";
    private static final int WILL_SIT_LOCATION_PAG_HEIGHT_DP = 100;
    private static final int WILL_SIT_LOCATION_PAG_OFFSET_X_DP = 50;
    private static final float WILL_SIT_LOCATION_PAG_OFFSET_Y_DP = 75.75f;
    private static final String WILL_SIT_LOCATION_PAG_URL = "https://cdn.meta.qq.com/chat_land/v2/flex_indicator_v3.pag";
    private static final int WILL_SIT_LOCATION_PAG_WIDTH_DP = 100;
    private static final int WRONG_SIT_LOCATION_IMG_HEIGHT_DP = 52;
    private static final String WRONG_SIT_LOCATION_IMG_URL = "https://cdn.meta.qq.com/chat_land/v2/vas_square_chatland_wrong_location.webp";
    private static final int WRONG_SIT_LOCATION_IMG_WIDTH_DP = 186;
    private VasSquareFragmentChatLandActionPanelBinding actionPanel;
    private ChatLandBackgroundView backgroundView;
    private final ImageTipsManager imageTipsManager;
    private int mapZoomLevel;
    private final OperationAdManger operationAdManger;
    private final IChatLandUIOwner owner;
    private final PagTipsManager pagTipsManager;
    private ChatLandRefreshPanelView refreshPanelView;
    private CommonRoomInfo roomInfo;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InteractionMotionState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[InteractionMotionState.INVITING.ordinal()] = 1;
            iArr[InteractionMotionState.PAIRING.ordinal()] = 2;
            int[] iArr2 = new int[AreaType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AreaType.CLICKABLE.ordinal()] = 1;
            iArr2[AreaType.UNCLICKABLE.ordinal()] = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandUiComponent(IChatLandUIOwner owner, int i3) {
        super(i3);
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.imageTipsManager = new ImageTipsManager(new WeakReference(this));
        this.pagTipsManager = new PagTipsManager(new WeakReference(this));
        this.operationAdManger = new OperationAdManger(new WeakReference(this));
    }

    public final boolean backgroundClickInterceptor(Point screenPoint, Point mapPoint) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        VasSquareItemChatLandAvatarBinding binding;
        LinearLayout linearLayout;
        VasSquareItemChatLandAvatarBinding binding2;
        LinearLayout linearLayout2;
        IMapItemViewManager itemViewManager;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        if (chatLandSquareComponent != null) {
            int indexByUinType$default = ChatLandSquareComponent.getIndexByUinType$default(chatLandSquareComponent, SquareBaseKt.getSquareCommon().getCurrentAccountUin(), 0, 2, null);
            SquareView mapView = getMapView();
            MapViewHolder<?> viewHolder = (mapView == null || (itemViewManager = mapView.getItemViewManager()) == null) ? null : itemViewManager.getViewHolder(indexByUinType$default);
            ChatLandAvatarViewHolder chatLandAvatarViewHolder = (ChatLandAvatarViewHolder) (viewHolder instanceof ChatLandAvatarViewHolder ? viewHolder : null);
            Rect rect = new Rect();
            if (chatLandAvatarViewHolder != null && (binding2 = chatLandAvatarViewHolder.getBinding()) != null && (linearLayout2 = binding2.pkResultArea) != null) {
                linearLayout2.getGlobalVisibleRect(rect);
            }
            if (rect.contains(screenPoint.x, screenPoint.y)) {
                if (chatLandAvatarViewHolder == null || (binding = chatLandAvatarViewHolder.getBinding()) == null || (linearLayout = binding.pkResultArea) == null) {
                    return true;
                }
                linearLayout.performClick();
                return true;
            }
        }
        return false;
    }

    private final void bindActionPanel() {
        final Context context;
        FrameLayout mRv;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        final WeakReference weakReference = new WeakReference(this);
        if (this.actionPanel == null) {
            final VasSquareFragmentChatLandActionPanelBinding view = VasSquareFragmentChatLandActionPanelBinding.inflate(LayoutInflater.from(context));
            this.actionPanel = view;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this.owner.onAddViewToScreen(view.getMRv());
            view.exitButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    VasBaseFragment vasBaseFragment;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    WeakReference<VasBaseFragmentComponentGroup> parent2;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default2;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
                    Map<String, Object> reportParams;
                    ChatLandUiComponent chatLandUiComponent = this;
                    Integer valueOf = Integer.valueOf(chatLandUiComponent.getAppId());
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent);
                    if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(ChatLandPKComponent.class, valueOf)) == null) && (((parent = chatLandUiComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, valueOf)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) chatLandUiComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, valueOf, 2, null)) == null))) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandUiComponent).parentFragment;
                        component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandPKComponent.class, null, null, 6, null) : null;
                    }
                    ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) component$default;
                    if (chatLandPKComponent != null) {
                        chatLandPKComponent.hidePKPanel();
                    }
                    ChatLandUiComponent chatLandUiComponent2 = this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent2 instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent2);
                    if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent = vasBaseFragmentComponentGroup4.getComponent(PublicChatUIComponent.class, null)) == null) && ((parent2 = chatLandUiComponent2.getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PublicChatUIComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) chatLandUiComponent2).fragment;
                        if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, PublicChatUIComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) chatLandUiComponent2).parentFragment;
                            if (vasBaseFragment4 != null) {
                                fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, PublicChatUIComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent2 = component$default2;
                        }
                        fragmentComponent = fragmentComponent2;
                    }
                    PublicChatUIComponent publicChatUIComponent = (PublicChatUIComponent) fragmentComponent;
                    if (publicChatUIComponent != null) {
                        publicChatUIComponent.hideMsgListPanel();
                    }
                    ChatLandDialogTips.INSTANCE.showLeaveConfirmTip(context, this.getAppId(), false, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            WeakReference<VasBaseFragmentComponentGroup> parent3;
                            VasBaseFragment vasBaseFragment5;
                            FragmentComponent component$default3;
                            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup5;
                            if (z16) {
                                ChatLandUiComponent chatLandUiComponent3 = this;
                                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup6 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent3 instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent3);
                                if ((vasBaseFragmentComponentGroup6 == null || (component$default3 = vasBaseFragmentComponentGroup6.getComponent(ChatLandSeatComponent.class, null)) == null) && (((parent3 = chatLandUiComponent3.getParent()) == null || (vasBaseFragmentComponentGroup5 = parent3.get()) == null || (component$default3 = vasBaseFragmentComponentGroup5.getComponent(ChatLandSeatComponent.class, null)) == null) && ((vasBaseFragment5 = ((VasBaseFragmentComponent) chatLandUiComponent3).fragment) == null || (component$default3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment5, ChatLandSeatComponent.class, null, null, 2, null)) == null))) {
                                    VasBaseFragment vasBaseFragment6 = ((VasBaseFragmentComponent) chatLandUiComponent3).parentFragment;
                                    component$default3 = vasBaseFragment6 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment6, ChatLandSeatComponent.class, null, null, 6, null) : null;
                                }
                                ChatLandSeatComponent chatLandSeatComponent = (ChatLandSeatComponent) component$default3;
                                if (chatLandSeatComponent != null) {
                                    ChatLandSeatComponent.doLeave$default(chatLandSeatComponent, null, 1, null);
                                }
                            }
                        }
                    });
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    FrameLayout frameLayout = VasSquareFragmentChatLandActionPanelBinding.this.exitButton;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "view.exitButton");
                    reportParams = this.getReportParams();
                    squareReporter.reportEvent("clck", frameLayout, reportParams);
                }
            });
            if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                RelativeLayout relativeLayout = view.taskContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "view.taskContainer");
                ViewExtensionsKt.setVisibility(relativeLayout, false);
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = view.taskButton;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "view.taskButton");
            squareReporter.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_TASK_ENTRY, new LinkedHashMap(), false, false);
            view.taskButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding;
                    Map<String, Object> mutableMapOf;
                    View view2;
                    SquareTaskSheet squareTaskSheet = new SquareTaskSheet(context, 1);
                    squareTaskSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$2.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) weakReference.get();
                            if (chatLandUiComponent != null) {
                                chatLandUiComponent.fetchRedDotFlag();
                            }
                        }
                    });
                    squareTaskSheet.show();
                    vasSquareFragmentChatLandActionPanelBinding = ChatLandUiComponent.this.actionPanel;
                    int i3 = (vasSquareFragmentChatLandActionPanelBinding == null || (view2 = vasSquareFragmentChatLandActionPanelBinding.taskRedDot) == null || !ViewExtensionsKt.isVisible(view2)) ? 0 : 1;
                    IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HAVE_RED_DOT, Integer.valueOf(i3)));
                    squareReporter2.reportEvent("clck", it, mutableMapOf);
                }
            });
            view.interactionMotionInvitePanel.setOnSelectCallback(new Function3<Boolean, Boolean, InviteInfo, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, InviteInfo inviteInfo) {
                    invoke(bool.booleanValue(), bool2.booleanValue(), inviteInfo);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, boolean z17, final InviteInfo info) {
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    Intrinsics.checkNotNullParameter(info, "info");
                    SquareBaseKt.getSquareLog().d("ChatLandUiComponent", "\u4e92\u52a8\u9080\u8bf7\u9762\u677f\u70b9\u51fb agree=" + z16 + " ignore7Days=" + z17 + " info=" + info);
                    ChatLandUiComponent chatLandUiComponent = ChatLandUiComponent.this;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = chatLandUiComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandUiComponent).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandUiComponent).parentFragment;
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
                        chatLandInteractionMotionComponent.replyInvite(info, z16, z17, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$3.1
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
                                VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding;
                                ChatLandInteractionMotionInvitePanel chatLandInteractionMotionInvitePanel;
                                vasSquareFragmentChatLandActionPanelBinding = ChatLandUiComponent.this.actionPanel;
                                if (vasSquareFragmentChatLandActionPanelBinding == null || (chatLandInteractionMotionInvitePanel = vasSquareFragmentChatLandActionPanelBinding.interactionMotionInvitePanel) == null) {
                                    return;
                                }
                                chatLandInteractionMotionInvitePanel.hide(info.getBillNo());
                            }
                        });
                    }
                }
            });
            view.interactionMotionInvitePanel.setOnTimeoutCallback(new Function1<InviteInfo, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$1$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InviteInfo inviteInfo) {
                    invoke2(inviteInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InviteInfo info) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    SquareBaseKt.getSquareLog().d("ChatLandUiComponent", "\u4e92\u52a8\u9080\u8bf7\u9762\u677f\u8d85\u65f6 info=" + info);
                }
            });
            view.interactionMotionInvitePanel.setOnClickHeadCallback(new Function1<InviteInfo, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InviteInfo inviteInfo) {
                    invoke2(inviteInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InviteInfo info) {
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    Intrinsics.checkNotNullParameter(info, "info");
                    SquareBaseKt.getSquareLog().d("ChatLandUiComponent", "\u4e92\u52a8\u9080\u8bf7\u9762\u677f\u70b9\u51fb\u5934\u50cf info=" + info);
                    ChatLandUiComponent chatLandUiComponent = ChatLandUiComponent.this;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandPublicChatComponent.class, null)) == null) && ((parent = chatLandUiComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandPublicChatComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandUiComponent).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPublicChatComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandUiComponent).parentFragment;
                            if (vasBaseFragment2 != null) {
                                fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandPublicChatComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent2 = component$default;
                        }
                        fragmentComponent = fragmentComponent2;
                    }
                    ChatLandPublicChatComponent chatLandPublicChatComponent = (ChatLandPublicChatComponent) fragmentComponent;
                    if (chatLandPublicChatComponent != null) {
                        chatLandPublicChatComponent.viewTaFocus(info.getUser().getUin());
                    }
                }
            });
            view.interactionMotionIndicator.setOnClickCallback(new Function1<InterMotionIndicatorInfo, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InterMotionIndicatorInfo interMotionIndicatorInfo) {
                    invoke2(interMotionIndicatorInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InterMotionIndicatorInfo info) {
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    Intrinsics.checkNotNullParameter(info, "info");
                    SquareBaseKt.getSquareLog().d("ChatLandUiComponent", "\u4e92\u52a8\u6307\u793a\u5668\u70b9\u51fb currentInfo=" + info);
                    int i3 = ChatLandUiComponent.WhenMappings.$EnumSwitchMapping$0[info.getStatus().ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return;
                        }
                        ChatLandDialogTips.INSTANCE.showEndInteractionConfirm(context, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                WeakReference<VasBaseFragmentComponentGroup> parent2;
                                FragmentComponent fragmentComponent2;
                                FragmentComponent component$default2;
                                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
                                if (z16) {
                                    ChatLandUiComponent chatLandUiComponent = ChatLandUiComponent.this;
                                    FragmentComponent fragmentComponent3 = null;
                                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent);
                                    if ((vasBaseFragmentComponentGroup3 == null || (fragmentComponent2 = vasBaseFragmentComponentGroup3.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent2 = chatLandUiComponent.getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandUiComponent).fragment;
                                        if (vasBaseFragment == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandUiComponent).parentFragment;
                                            if (vasBaseFragment2 != null) {
                                                fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null);
                                            }
                                        } else {
                                            fragmentComponent3 = component$default2;
                                        }
                                        fragmentComponent2 = fragmentComponent3;
                                    }
                                    ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) fragmentComponent2;
                                    if (chatLandInteractionMotionComponent != null) {
                                        chatLandInteractionMotionComponent.endInteraction();
                                    }
                                }
                            }
                        });
                        return;
                    }
                    ChatLandUiComponent chatLandUiComponent = ChatLandUiComponent.this;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = chatLandUiComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandUiComponent).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandUiComponent).parentFragment;
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
                        chatLandInteractionMotionComponent.cancelInvite();
                    }
                }
            });
            view.interactionMotionIndicator.setOnInviteTimeoutCallback(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindActionPanel$$inlined$let$lambda$6
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
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    SquareBaseKt.getSquareLog().d("ChatLandUiComponent", "\u4e92\u52a8\u6307\u793a\u5668\u9080\u8bf7\u8d85\u65f6");
                    SquareBaseKt.getSquareCommon().showToastSafely(context, "\u9080\u8bf7\u8d85\u65f6\uff0c\u5bf9\u65b9\u6682\u65e0\u56de\u5e94", 0);
                    ChatLandUiComponent chatLandUiComponent = ChatLandUiComponent.this;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandUiComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandUiComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = chatLandUiComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandUiComponent).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandUiComponent).parentFragment;
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
                        chatLandInteractionMotionComponent.onInteractionInviteTimeout();
                    }
                }
            });
            IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
            FrameLayout frameLayout = view.exitButton;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "view.exitButton");
            squareReporter2.setElementInfo(frameLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_EXIT_BTN, getReportParams(), false, false);
        }
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding == null || (mRv = vasSquareFragmentChatLandActionPanelBinding.getMRv()) == null) {
            return;
        }
        ViewExtensionsKt.setVisibility(mRv, false);
    }

    private final void bindOperationAd(List<OperationAd> ads) {
        Context context;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        this.operationAdManger.init(new WeakReference<>(context), ads);
    }

    public final void fetchRedDotFlag() {
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return;
        }
        Square.INSTANCE.getConfig().getObtainInstanceHelper().getSquareTaskService().getTaskRedPointFlag(21L, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$fetchRedDotFlag$1
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
                ChatLandUiComponent.this.setTaskRedDotVisible(z16);
            }
        });
    }

    public final Map<String, Object> getReportParams() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Map<String, Object> mutableMapOf;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) fragmentComponent;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_REMAINING_USER_COUNT, Integer.valueOf(chatLandSquareComponent != null ? chatLandSquareComponent.getSeatedUserCount() : 0)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(getAppId())));
        return mutableMapOf;
    }

    public final void handleBackgroundClick(Point screenPoint, Point mapPoint, AreaType areaType) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        SquareBaseKt.getSquareLog().d(TAG, getAppId() + " onClick " + mapPoint + TokenParser.SP + areaType);
        if (SquareBaseKt.getSquareCommon().getStudyMode()) {
            return;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[areaType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            showWrongSitLocationTips(screenPoint, mapPoint);
            return;
        }
        CommonRoomInfo commonRoomInfo = this.roomInfo;
        if (commonRoomInfo == null || !commonRoomInfo.isSupportFlexTable()) {
            return;
        }
        SquareBaseKt.getSquareLog().d(TAG, "take flex table " + getAppId() + TokenParser.SP + mapPoint);
        FragmentComponent fragmentComponent2 = null;
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
            ChatLandSeatComponent.takeSeat$default(chatLandSeatComponent, -1L, mapPoint, true, null, null, 24, null);
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$handleBackgroundClick$1
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
                ChatLandBackgroundView chatLandBackgroundView;
                Map<String, Object> bgReportParams;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                chatLandBackgroundView = ChatLandUiComponent.this.backgroundView;
                if (chatLandBackgroundView != null) {
                    bgReportParams = ChatLandUiComponent.this.getBgReportParams();
                    squareReporter.reportEvent("clck", chatLandBackgroundView, bgReportParams);
                }
            }
        });
    }

    private final void showWillSitLocationTips(String pagUrl, Point screenPoint, Point mapPoint) {
        VasBaseFragment fragment;
        Context context;
        if ((pagUrl.length() == 0) || (fragment = getFragment()) == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        PagTipsManager.show$default(this.pagTipsManager, context, pagUrl, new Point(screenPoint.x - com.tencent.state.square.common.ViewExtensionsKt.dip(context, 50), screenPoint.y - com.tencent.state.square.common.ViewExtensionsKt.dip(context, WILL_SIT_LOCATION_PAG_OFFSET_Y_DP)), new Size(com.tencent.state.square.common.ViewExtensionsKt.dip(context, 100), com.tencent.state.square.common.ViewExtensionsKt.dip(context, 100)), 0, 16, null);
    }

    private final void showWrongSitLocationTips(Point screenPoint, Point mapPoint) {
        Context context;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        int dip = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 186);
        int dip2 = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 52);
        ImageTipsManager.show$default(this.imageTipsManager, context, WRONG_SIT_LOCATION_IMG_URL, new Point(screenPoint.x - (dip / 2), screenPoint.y - dip2), new Size(dip, dip2), 0L, 16, null);
    }

    @Override // com.tencent.state.square.chatland.view.IViewContainer
    public void addToMap(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.owner.onAddViewToMap(view);
    }

    @Override // com.tencent.state.square.chatland.view.IViewContainer
    public void addView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.owner.onAddViewToScreen(view);
    }

    public final PublicChatViewSlots getPublicChatViewSlots() {
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding == null) {
            return null;
        }
        FrameLayout frameLayout = vasSquareFragmentChatLandActionPanelBinding.publicChatListContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "it.publicChatListContainer");
        FrameLayout frameLayout2 = vasSquareFragmentChatLandActionPanelBinding.publicChatBtnContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "it.publicChatBtnContainer");
        return new PublicChatViewSlots(frameLayout, frameLayout2, new MsgNewBtnConfig("\u548c\u5927\u5bb6\u804a\u4e00\u804a\u5427~", Color.parseColor("#80FFFFFF"), 14.0f, false, 8388627, 18));
    }

    public final void hideIndicator() {
        ChatLandInteractionMotionIndicator chatLandInteractionMotionIndicator;
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding == null || (chatLandInteractionMotionIndicator = vasSquareFragmentChatLandActionPanelBinding.interactionMotionIndicator) == null) {
            return;
        }
        chatLandInteractionMotionIndicator.hide();
    }

    public final void hideInvitePanel(String billNo) {
        ChatLandInteractionMotionInvitePanel chatLandInteractionMotionInvitePanel;
        SquareBaseKt.getSquareLog().d(TAG, "hideInvitePanel " + billNo);
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding == null || (chatLandInteractionMotionInvitePanel = vasSquareFragmentChatLandActionPanelBinding.interactionMotionInvitePanel) == null) {
            return;
        }
        chatLandInteractionMotionInvitePanel.hide(billNo);
    }

    public final void initCacheBackground() {
        CacheFileUtils cacheFileUtils = CacheFileUtils.INSTANCE;
        CachePath chatLandCacheType = cacheFileUtils.getChatLandCacheType(getAppId());
        if (chatLandCacheType != null) {
            cacheFileUtils.getCache(chatLandCacheType, new Function1<byte[], Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$initCacheBackground$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                    invoke2(bArr);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(byte[] it) {
                    ChatLandBackgroundView chatLandBackgroundView;
                    IChatLandUIOwner iChatLandUIOwner;
                    RoomThemeData roomThemeData;
                    Intrinsics.checkNotNullParameter(it, "it");
                    chatLandBackgroundView = ChatLandUiComponent.this.backgroundView;
                    if (chatLandBackgroundView != null) {
                        return;
                    }
                    try {
                        MessageNano mergeFrom = MessageNano.mergeFrom(new f(), it);
                        Intrinsics.checkNotNullExpressionValue(mergeFrom, "MessageNano.mergeFrom(EnterRoomRsp(), it)");
                        Function1<r[], RoomConfig> chatLandRoomConfParser = ChatLandRoomComponentKt.getChatLandRoomConfParser();
                        iChatLandUIOwner = ChatLandUiComponent.this.owner;
                        EnterRoomInfo parse = VasSquareRoomServiceKt.parse((f) mergeFrom, (Function1<? super r[], RoomConfig>) chatLandRoomConfParser, iChatLandUIOwner.onGetMapSize());
                        ChatLandUiComponent.this.bindBackground(parse.getRoom());
                        ChatLandUiComponent chatLandUiComponent = ChatLandUiComponent.this;
                        CommonRoomInfo room = parse.getRoom();
                        if (room == null || (roomThemeData = room.getTheme()) == null) {
                            roomThemeData = null;
                        } else {
                            roomThemeData.setText("");
                            Unit unit = Unit.INSTANCE;
                        }
                        chatLandUiComponent.bindRefreshPanel(roomThemeData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ChatLandUiComponent", "initCacheBackground cache: " + th5, null, 4, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        OperationAdManger.onVisibilityChanged$default(this.operationAdManger, !isScaleToCenter, false, 2, null);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandLeaveRoom() {
        IChatLandEventListener.DefaultImpls.onChatLandLeaveRoom(this);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandSeatAdded() {
        IChatLandEventListener.DefaultImpls.onChatLandSeatAdded(this);
    }

    public final void onDetectorScroll() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Rect videoLocation = this.operationAdManger.getVideoLocation();
        if (videoLocation != null) {
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
            }
            ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
            OperationAdManger.onVisibilityChanged$default(this.operationAdManger, chatLandSquareComponent != null ? chatLandSquareComponent.checkViewVisible(videoLocation) : false, false, 2, null);
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.roomInfo = info.getRoom();
        bindBackground(info.getRoom());
        CommonRoomInfo room = info.getRoom();
        bindRefreshPanel(room != null ? room.getTheme() : null);
        bindActionPanel();
        CommonRoomInfo room2 = info.getRoom();
        bindOperationAd(room2 != null ? room2.getOperationAdSlots() : null);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        this.imageTipsManager.destroy();
        this.pagTipsManager.destroy();
        this.operationAdManger.destroy();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        Intrinsics.checkNotNullParameter(f16, "f");
        this.operationAdManger.onVisibilityChanged(isVisible, true);
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onMapZoomEnd(int zoomLevel, float scale, boolean isZoomIn) {
        this.mapZoomLevel = zoomLevel;
        ChatLandBackgroundView chatLandBackgroundView = this.backgroundView;
        if (chatLandBackgroundView != null) {
            chatLandBackgroundView.updateZoomLevel(zoomLevel);
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusEnd() {
        VasSquareFragmentSquareBinding binding;
        LinearLayout linearLayout;
        FrameLayout mRv;
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding != null && (mRv = vasSquareFragmentChatLandActionPanelBinding.getMRv()) != null) {
            ViewExtensionsKt.setVisibility(mRv, false);
        }
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof SquareFragment)) {
            fragment = null;
        }
        SquareFragment squareFragment = (SquareFragment) fragment;
        if (squareFragment != null && (binding = squareFragment.getBinding()) != null && (linearLayout = binding.bottomContainer) != null) {
            ViewExtensionsKt.setVisibility(linearLayout, true);
        }
        SquareUtil.INSTANCE.setKeepScreen(getActivity(), false);
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusStart(User r75) {
        VasSquareFragmentSquareBinding binding;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(r75, "user");
        final VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding != null) {
            FrameLayout mRv = vasSquareFragmentChatLandActionPanelBinding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "panel.root");
            VasBaseFragment fragment = getFragment();
            ViewExtensionsKt.setVisibility(mRv, fragment != null && fragment.isTopFragment());
            SquareBaseKt.getSquareThread().postOnUiDelayed(50L, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$onMeFocusStart$$inlined$let$lambda$1
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
                    Map<String, Object> reportParams;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    FrameLayout frameLayout = VasSquareFragmentChatLandActionPanelBinding.this.exitButton;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "panel.exitButton");
                    reportParams = this.getReportParams();
                    squareReporter.reportEvent("imp", frameLayout, reportParams);
                }
            });
        }
        VasBaseFragment fragment2 = getFragment();
        if (!(fragment2 instanceof SquareFragment)) {
            fragment2 = null;
        }
        SquareFragment squareFragment = (SquareFragment) fragment2;
        if (squareFragment != null && (binding = squareFragment.getBinding()) != null && (linearLayout = binding.bottomContainer) != null) {
            ViewExtensionsKt.setVisibility(linearLayout, false);
        }
        SquareUtil.INSTANCE.setKeepScreen(getActivity(), true);
        fetchRedDotFlag();
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onPublicChatConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        IChatLandEventListener.DefaultImpls.onPublicChatConfigLoaded(this, conf);
    }

    @Override // com.tencent.state.square.chatland.view.IViewContainer
    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.owner.onRemoveViewFromScreen(view);
    }

    public final void setActionPanelButtonsVisibility(boolean r26) {
        LinearLayout linearLayout;
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding == null || (linearLayout = vasSquareFragmentChatLandActionPanelBinding.seatButtonWrapper) == null) {
            return;
        }
        linearLayout.setVisibility(r26 ? 0 : 4);
    }

    public final void setActionPanelVisibility(boolean r152) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        FrameLayout mRv;
        if (isMeSeated()) {
            Integer valueOf = Integer.valueOf(getAppId());
            boolean z16 = this instanceof VasBaseFragmentComponentGroup;
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(ChatLandPKComponent.class, valueOf)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, valueOf)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, valueOf, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandPKComponent.class, null, null, 6, null) : null;
            }
            ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) component$default;
            if (!r152 && chatLandPKComponent != null) {
                chatLandPKComponent.hidePKPanel();
            }
            VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
            if (vasSquareFragmentChatLandActionPanelBinding != null && (mRv = vasSquareFragmentChatLandActionPanelBinding.getMRv()) != null) {
                ViewExtensionsKt.setVisibility(mRv, r152);
            }
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent = vasBaseFragmentComponentGroup4.getComponent(PublicChatUIComponent.class, null)) == null) && ((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PublicChatUIComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, PublicChatUIComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment4 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, PublicChatUIComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default2;
                }
                fragmentComponent = fragmentComponent2;
            }
            PublicChatUIComponent publicChatUIComponent = (PublicChatUIComponent) fragmentComponent;
            if (publicChatUIComponent != null) {
                publicChatUIComponent.setVisibility(r152);
            }
        }
    }

    public final void setTaskRedDotVisible(boolean r56) {
        Map<String, Object> mutableMapOf;
        View view;
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding != null && (view = vasSquareFragmentChatLandActionPanelBinding.taskRedDot) != null) {
            ViewExtensionsKt.setVisibility(view, r56);
        }
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding2 = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding2 != null) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = vasSquareFragmentChatLandActionPanelBinding2.taskButton;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "it.taskButton");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HAVE_RED_DOT, Integer.valueOf(r56 ? 1 : 0)));
            squareReporter.reportEvent("imp", squareImageView, mutableMapOf);
        }
    }

    public final void showIndicator(InterMotionIndicatorInfo data) {
        ChatLandInteractionMotionIndicator chatLandInteractionMotionIndicator;
        Intrinsics.checkNotNullParameter(data, "data");
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding == null || (chatLandInteractionMotionIndicator = vasSquareFragmentChatLandActionPanelBinding.interactionMotionIndicator) == null) {
            return;
        }
        chatLandInteractionMotionIndicator.bind(data);
    }

    public final void showInvitePanel(InviteInfo info) {
        ChatLandInteractionMotionInvitePanel chatLandInteractionMotionInvitePanel;
        Intrinsics.checkNotNullParameter(info, "info");
        SquareBaseKt.getSquareLog().d(TAG, "bindInvitePanel " + info);
        VasSquareFragmentChatLandActionPanelBinding vasSquareFragmentChatLandActionPanelBinding = this.actionPanel;
        if (vasSquareFragmentChatLandActionPanelBinding == null || (chatLandInteractionMotionInvitePanel = vasSquareFragmentChatLandActionPanelBinding.interactionMotionInvitePanel) == null) {
            return;
        }
        chatLandInteractionMotionInvitePanel.bind(info);
    }

    public final Map<String, Object> getBgReportParams() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(getAppId())), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HAVE_JOIN, Integer.valueOf(isMeSeated() ? 1 : 0)));
        return mutableMapOf;
    }

    public final void bindRefreshPanel(RoomThemeData themeData) {
        VasBaseFragment fragment;
        Context context;
        if (themeData == null || (fragment = getFragment()) == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        if (SquareBaseKt.getSquareCommon().getStudyMode()) {
            ChatLandRefreshPanelView chatLandRefreshPanelView = this.refreshPanelView;
            if (chatLandRefreshPanelView != null) {
                chatLandRefreshPanelView.hide();
                return;
            }
            return;
        }
        if (this.refreshPanelView == null) {
            ChatLandRefreshPanelView chatLandRefreshPanelView2 = new ChatLandRefreshPanelView(context, null, 0, new Function0<Map<String, Object>>() { // from class: com.tencent.state.square.chatland.component.ChatLandUiComponent$bindRefreshPanel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, Object> invoke() {
                    Map<String, Object> reportParams;
                    reportParams = ChatLandUiComponent.this.getReportParams();
                    return reportParams;
                }
            }, 6, null);
            this.owner.onAddViewToMap(chatLandRefreshPanelView2);
            this.refreshPanelView = chatLandRefreshPanelView2;
        }
        ChatLandRefreshPanelView chatLandRefreshPanelView3 = this.refreshPanelView;
        if (chatLandRefreshPanelView3 != null) {
            chatLandRefreshPanelView3.update(themeData);
        }
    }

    public final void bindBackground(CommonRoomInfo roomInfo) {
        VasBaseFragment fragment;
        Context context;
        if (roomInfo == null || (fragment = getFragment()) == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        if (this.backgroundView == null) {
            ChatLandBackgroundView chatLandBackgroundView = new ChatLandBackgroundView(context, new ChatLandUiComponent$bindBackground$1(this), new ChatLandUiComponent$bindBackground$2(this));
            this.owner.onAddBackgroundViewToMap(chatLandBackgroundView);
            Unit unit = Unit.INSTANCE;
            this.backgroundView = chatLandBackgroundView;
            SquareBaseKt.getSquareReporter().setElementInfo(chatLandBackgroundView, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_CLICKABLE_AREA, new LinkedHashMap(), false, false);
        }
        ChatLandBackgroundView chatLandBackgroundView2 = this.backgroundView;
        if (chatLandBackgroundView2 != null) {
            chatLandBackgroundView2.update(roomInfo, this.mapZoomLevel);
        }
    }

    public final void refreshTheme(RoomThemeData themeData) {
        CommonRoomInfo commonRoomInfo;
        ChatLandBackgroundView chatLandBackgroundView;
        Intrinsics.checkNotNullParameter(themeData, "themeData");
        CommonRoomInfo commonRoomInfo2 = this.roomInfo;
        if (commonRoomInfo2 != null) {
            commonRoomInfo = commonRoomInfo2.copy((r24 & 1) != 0 ? commonRoomInfo2.id : 0L, (r24 & 2) != 0 ? commonRoomInfo2.stalls : null, (r24 & 4) != 0 ? commonRoomInfo2.tables : null, (r24 & 8) != 0 ? commonRoomInfo2.users : null, (r24 & 16) != 0 ? commonRoomInfo2.background : null, (r24 & 32) != 0 ? commonRoomInfo2.config : null, (r24 & 64) != 0 ? commonRoomInfo2.theme : themeData, (r24 & 128) != 0 ? commonRoomInfo2.appId : 0, (r24 & 256) != 0 ? commonRoomInfo2.maxPeople : 0, (r24 & 512) != 0 ? commonRoomInfo2.operationAdSlots : null);
        } else {
            commonRoomInfo = null;
        }
        this.roomInfo = commonRoomInfo;
        if (commonRoomInfo != null && (chatLandBackgroundView = this.backgroundView) != null) {
            chatLandBackgroundView.update(commonRoomInfo, this.mapZoomLevel);
        }
        ChatLandRefreshPanelView chatLandRefreshPanelView = this.refreshPanelView;
        if (chatLandRefreshPanelView != null) {
            chatLandRefreshPanelView.update(themeData);
        }
    }

    public static /* synthetic */ void hideInvitePanel$default(ChatLandUiComponent chatLandUiComponent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        chatLandUiComponent.hideInvitePanel(str);
    }
}
