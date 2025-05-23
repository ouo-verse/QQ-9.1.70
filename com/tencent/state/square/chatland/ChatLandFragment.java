package com.tencent.state.square.chatland;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.ISquareViewDetectorCallback;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.chatland.component.ChatLandComponent;
import com.tencent.state.square.chatland.component.ChatLandNearbyReportComponent;
import com.tencent.state.square.chatland.component.ChatLandPKComponent;
import com.tencent.state.square.chatland.component.ChatLandRoomComponent;
import com.tencent.state.square.chatland.component.ChatLandSquareComponent;
import com.tencent.state.square.chatland.component.ChatLandUiComponent;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder;
import com.tencent.state.square.chatland.viewmodel.ChatLandMapViewModel;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.components.fragment.SquareBaseComponent;
import com.tencent.state.square.components.fragment.SquareFilamentCoverComponent;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.databinding.VasSquareItemChatLandAvatarBinding;
import com.tencent.state.square.databinding.ZtpSquareChatLandFragmentBinding;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.utils.VMUtils;
import com.tencent.state.view.SquareImageView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 P2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001PB'\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0014J\b\u0010\u001f\u001a\u00020\nH\u0016J\u001e\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\"0!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u001e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001dH\u0014J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010:\u001a\u00020&H\u0016J\b\u0010;\u001a\u00020&H\u0016J\b\u0010<\u001a\u00020&H\u0016J*\u0010=\u001a\u00020&2\u000e\u0010>\u001a\n\u0012\u0002\b\u00030?j\u0002`@2\u0006\u0010A\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010-H\u0016J<\u0010B\u001a\u00020&2\u000e\u0010>\u001a\n\u0012\u0002\b\u00030?j\u0002`@2\u0006\u0010A\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010-2\u0006\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\"H\u0016J2\u0010E\u001a\u00020&2\u000e\u0010>\u001a\n\u0012\u0002\b\u00030?j\u0002`@2\u0006\u0010A\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010-2\u0006\u0010C\u001a\u00020\u0006H\u0016J\u001c\u0010F\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010-2\b\u0010D\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020IH\u0016J\u001a\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103H\u0016J*\u0010L\u001a\u00020&2\u000e\u0010>\u001a\n\u0012\u0002\b\u00030?j\u0002`@2\u0006\u0010A\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020IH\u0014J\u001e\u0010O\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001dH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R(\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003@VX\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006Q"}, d2 = {"Lcom/tencent/state/square/chatland/ChatLandFragment;", "Lcom/tencent/state/map/MapFragment;", "Lcom/tencent/state/square/SquareView;", "Lcom/tencent/state/square/chatland/viewmodel/ChatLandMapViewModel;", "Lcom/tencent/state/map/ISquareViewDetectorCallback;", "appId", "", "roomId", "", WadlProxyConsts.KEY_JUMP_URL, "", "(ILjava/lang/Long;Ljava/lang/String;)V", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareChatLandFragmentBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/ZtpSquareChatLandFragmentBinding;", "setBinding", "(Lcom/tencent/state/square/databinding/ZtpSquareChatLandFragmentBinding;)V", "mapView", "getMapView", "()Lcom/tencent/state/square/SquareView;", "Ljava/lang/Long;", "<set-?>", "vm", "getVm", "()Lcom/tencent/state/square/chatland/viewmodel/ChatLandMapViewModel;", "setVm", "(Lcom/tencent/state/square/chatland/viewmodel/ChatLandMapViewModel;)V", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getPageId", "getReportParams", "", "", "data", "Lcom/tencent/state/square/data/SquareEntranceItem;", "handleSelfPKTagEvent", "", "event", "Landroid/view/MotionEvent;", "initMapView", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "dataList", "Lcom/tencent/state/map/MapItem;", "onAttach", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDetectorScale", "onDetectorScroll", "onItemBind", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "onItemClicked", "viewId", "extra", "onItemLongClick", "onItemRecordCover", "onMapZoom", "isZoomIn", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "onZoomOverOut", "sendMapDataRequest", "isRefresh", "updateMapView", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandFragment extends MapFragment<SquareView, ChatLandMapViewModel> implements ISquareViewDetectorCallback {
    private static final String TAG = "ChatLandFragment";
    private final int appId;
    private ZtpSquareChatLandFragmentBinding binding;
    private final String jumpUrl;
    private final Long roomId;
    private ChatLandMapViewModel vm;

    public ChatLandFragment() {
        this(0, null, null, 7, null);
    }

    private final Map<String, Object> getReportParams(SquareEntranceItem data) {
        String str;
        Map<String, Object> mutableMapOf;
        EntranceLink link;
        String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(this.appId));
        pairArr[1] = TuplesKt.to("dt_pgid", checkNearby);
        pairArr[2] = TuplesKt.to("pgid", checkNearby);
        if (data == null || (link = data.getLink()) == null || (str = link.getLink()) == null) {
            str = "";
        }
        pairArr[3] = TuplesKt.to(SquareReportConst.Param.EM_CHAT_LAND_NEARBY_OPERATE, str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSelfPKTagEvent(MotionEvent event) {
        ChatLandAvatarItem meAvatarItemInLands;
        VasSquareItemChatLandAvatarBinding binding;
        LinearLayout linearLayout;
        VasSquareItemChatLandAvatarBinding binding2;
        LinearLayout linearLayout2;
        SquareView squareView;
        IMapItemViewManager itemViewManager;
        ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) getComponent(ChatLandPKComponent.class, null, null);
        if (chatLandPKComponent == null || (meAvatarItemInLands = chatLandPKComponent.getMeAvatarItemInLands()) == null) {
            return;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) getComponent(ChatLandSquareComponent.class, null, Integer.valueOf(meAvatarItemInLands.getAppId()));
        Integer valueOf = chatLandSquareComponent != null ? Integer.valueOf(ChatLandSquareComponent.getIndexByUinType$default(chatLandSquareComponent, SquareBaseKt.getSquareCommon().getCurrentAccountUin(), 0, 2, null)) : null;
        if (valueOf != null) {
            valueOf.intValue();
            ZtpSquareChatLandFragmentBinding binding3 = getBinding();
            MapViewHolder<?> viewHolder = (binding3 == null || (squareView = binding3.squareView) == null || (itemViewManager = squareView.getItemViewManager()) == null) ? null : itemViewManager.getViewHolder(valueOf.intValue());
            ChatLandAvatarViewHolder chatLandAvatarViewHolder = (ChatLandAvatarViewHolder) (viewHolder instanceof ChatLandAvatarViewHolder ? viewHolder : null);
            int rawX = (int) event.getRawX();
            int rawY = (int) event.getRawY();
            Rect rect = new Rect();
            if (chatLandAvatarViewHolder != null && (binding2 = chatLandAvatarViewHolder.getBinding()) != null && (linearLayout2 = binding2.pkResultArea) != null) {
                linearLayout2.getGlobalVisibleRect(rect);
            }
            if (!rect.contains(rawX, rawY) || chatLandAvatarViewHolder == null || (binding = chatLandAvatarViewHolder.getBinding()) == null || (linearLayout = binding.pkResultArea) == null) {
                return;
            }
            linearLayout.performClick();
        }
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return SquareReportConst.PageId.PAGE_ID_NEARBY;
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public void initMapView(MapViewConfig config, List<? extends MapItem> dataList) {
        MapAdapter adapter;
        MapItemController controller;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        super.initMapView(config, dataList);
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null || (controller = adapter.getController()) == null) {
            return;
        }
        controller.setWelcomeScaleAnimDone(true);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        setVm((ChatLandMapViewModel) VMUtils.INSTANCE.safelyGet(this, ChatLandMapViewModel.class, String.valueOf(this.appId)));
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        SquareRuntime.INSTANCE.markNearby();
        super.onCreate(savedInstanceState);
        Context it = getContext();
        if (it != null) {
            ImageService.Companion companion = ImageService.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            companion.initImageLoader(it);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SquareView squareView;
        SquareImageView squareImageView;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(ZtpSquareChatLandFragmentBinding.inflate(getLayoutInflater()));
        ZtpSquareChatLandFragmentBinding binding = getBinding();
        if (binding != null && (squareImageView = binding.back) != null) {
            squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onCreateView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatLandFragment.this.onBackPressed();
                }
            });
        }
        ZtpSquareChatLandFragmentBinding binding2 = getBinding();
        if (binding2 != null && (squareView = binding2.squareView) != null) {
            squareView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onCreateView$2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View p06, MotionEvent event) {
                    if (event != null && event.getAction() == 1) {
                        ChatLandFragment.this.handleSelfPKTagEvent(event);
                    }
                    return false;
                }
            });
        }
        ZtpSquareChatLandFragmentBinding binding3 = getBinding();
        if (binding3 != null) {
            return binding3.getMRv();
        }
        return null;
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SquareRuntime.INSTANCE.removeNearbyMark();
        ImageService.INSTANCE.destroy();
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.setDetectorCallback(null);
        }
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int index, MapItem data) {
        EntranceLink link;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (!(data instanceof SquareEntranceItem)) {
            data = null;
        }
        SquareEntranceItem squareEntranceItem = (SquareEntranceItem) data;
        if (squareEntranceItem == null || (link = squareEntranceItem.getLink()) == null || link.getLinkType() != 1) {
            return;
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View view = vh5.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
        squareReporter.setElementInfo(view, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_NEARBY_OPERATE, getReportParams(squareEntranceItem), false, false);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        View view2 = vh5.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "vh.itemView");
        squareReporter2.reportEvent("imp", view2, new LinkedHashMap());
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemClicked(final MapViewHolder<?> vh5, final int index, final MapItem data, final int viewId, final Object extra) {
        EntranceLink link;
        ChatLandAvatarItem meAvatarItemInLands;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        SquareBaseKt.getSquareLog().i(TAG, "onItemClicked: index=" + index + ", data=" + data + ", clickViewType=" + viewId);
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onItemClicked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemClicked(MapViewHolder.this, index, data, viewId, extra);
            }
        });
        if (data != null) {
            if (viewId == 21) {
                ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) getComponent(ChatLandPKComponent.class, null, null);
                if (chatLandPKComponent == null || (meAvatarItemInLands = chatLandPKComponent.getMeAvatarItemInLands()) == null) {
                    return;
                }
                ChatLandPKComponent chatLandPKComponent2 = (ChatLandPKComponent) getComponent(ChatLandPKComponent.class, null, Integer.valueOf(meAvatarItemInLands.getAppId()));
                if (chatLandPKComponent2 != null) {
                    chatLandPKComponent2.showPKPanelIfNeeded(true);
                }
            }
            if (!(data instanceof SquareEntranceItem)) {
                data = null;
            }
            SquareEntranceItem squareEntranceItem = (SquareEntranceItem) data;
            if (squareEntranceItem == null || (link = squareEntranceItem.getLink()) == null || link.getLinkType() != 1) {
                return;
            }
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            View view = vh5.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
            squareReporter.reportEvent("clck", view, getReportParams(squareEntranceItem));
        }
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemLongClick(final MapViewHolder<?> vh5, final int index, final MapItem data, final int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onItemLongClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemLongClick(MapViewHolder.this, index, data, viewId);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecordCover(final MapItem data, final Object extra) {
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onItemRecordCover$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemRecordCover(MapItem.this, extra);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoom(final boolean isZoomIn) {
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onMapZoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMapZoom(isZoomIn);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.setDetectorCallback(this);
        }
        forEachComponent(ChatLandComponent.class, null, null, new Function1<ChatLandComponent<SquareView, ChatLandMapViewModel>, Unit>() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onViewCreated$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandComponent<SquareView, ChatLandMapViewModel> chatLandComponent) {
                invoke2(chatLandComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandComponent<SquareView, ChatLandMapViewModel> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.initialize();
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onZoomOverOut(final MapViewHolder<?> vh5, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.ChatLandFragment$onZoomOverOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onZoomOverOut(MapViewHolder.this, index, data);
            }
        });
    }

    public void setBinding(ZtpSquareChatLandFragmentBinding ztpSquareChatLandFragmentBinding) {
        this.binding = ztpSquareChatLandFragmentBinding;
    }

    public void setVm(ChatLandMapViewModel chatLandMapViewModel) {
        this.vm = chatLandMapViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public void updateMapView(MapViewConfig config, List<? extends MapItem> dataList) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    public ChatLandFragment(int i3) {
        this(i3, null, null, 6, null);
    }

    @Override // com.tencent.state.map.MapFragment
    public ZtpSquareChatLandFragmentBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new BasicServiceComponent(), new ChatLandComponent(this, this.appId, this.roomId, this.jumpUrl), new ChatLandNearbyReportComponent(this.appId), new SquareFilamentCoverComponent()});
        return listOf;
    }

    @Override // com.tencent.state.map.MapFragment
    public SquareView getMapView() {
        ZtpSquareChatLandFragmentBinding binding = getBinding();
        if (binding != null) {
            return binding.squareView;
        }
        return null;
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public ChatLandMapViewModel getVm() {
        return this.vm;
    }

    @Override // com.tencent.state.map.ISquareViewDetectorCallback
    public void onDetectorScroll() {
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) getComponent(ChatLandUiComponent.class, null, null);
        if (chatLandUiComponent != null) {
            chatLandUiComponent.onDetectorScroll();
        }
    }

    public ChatLandFragment(int i3, Long l3) {
        this(i3, l3, null, 4, null);
    }

    @Override // com.tencent.state.map.MapFragment
    protected void sendMapDataRequest(boolean isRefresh) {
        ChatLandRoomComponent chatLandRoomComponent;
        if (!isRefresh || (chatLandRoomComponent = (ChatLandRoomComponent) getComponent(ChatLandRoomComponent.class, null, null)) == null) {
            return;
        }
        TemplateRoomComponent.switchRoom$default(chatLandRoomComponent, null, null, 3, null);
    }

    public /* synthetic */ ChatLandFragment(int i3, Long l3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : l3, (i16 & 4) != 0 ? "" : str);
    }

    public ChatLandFragment(int i3, Long l3, String jumpUrl) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.appId = i3;
        this.roomId = l3;
        this.jumpUrl = jumpUrl;
    }

    @Override // com.tencent.state.map.ISquareViewDetectorCallback
    public void onDetectorScale() {
    }
}
