package com.tencent.state.square.components.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.FriendStatusPanelData;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.square.databinding.VasSquareFriendStatusPanelBinding;
import com.tencent.state.square.databinding.VasSquareFriendStatusPanelItemBinding;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import com.tencent.state.utils.CacheFileUtils;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0003567B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\u0018\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001c\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\u001c\u001a\u00020\u0005J*\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010 H\u0016J,\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010#\u001a\u00020/H\u0016J\u0016\u00100\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0016\u00103\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a01H\u0016J\b\u00104\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFriendStatusPanelComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Landroid/view/View$OnClickListener;", "()V", "hasInit", "", "panelBinding", "Lcom/tencent/state/square/databinding/VasSquareFriendStatusPanelBinding;", "panelData", "Lcom/tencent/state/square/FriendStatusPanelData;", "receivedData", "squareBinding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "squareViewManager", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "attachToParent", "", "context", "Landroid/content/Context;", "binding", "initList", "initListener", "initReport", "initTitle", "initView", "desc", "", "initViewAfterMapDataReady", "isPanelShowing", "onCenterScaled", "isScaleToCenter", "view", "Landroid/view/View;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", NodeProps.ON_CLICK, "v", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onMapDataReceived", "Lcom/tencent/state/map/MapData;", "onRoleAdded", "", "Lcom/tencent/state/square/MoveItem;", "onRoleRemoved", "refreshAllItemOperator", "Companion", "PanelAdapter", "PanelViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFriendStatusPanelComponent extends SquareBaseComponent implements View.OnClickListener {
    private static final String TAG = "SquareFriendStatusPanelComponent";
    private boolean hasInit;
    private VasSquareFriendStatusPanelBinding panelBinding;
    private FriendStatusPanelData panelData;
    private boolean receivedData;
    private VasSquareFragmentSquareBinding squareBinding;
    private ISquareViewManagerProxy squareViewManager;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017H\u0016J\u0006\u0010!\u001a\u00020\u001bJ\u0014\u0010\"\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFriendStatusPanelComponent$PanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/square/components/fragment/SquareFriendStatusPanelComponent$PanelViewHolder;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "mapView", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "squareViewManager", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "(Lcom/tencent/state/VasBaseFragment;Lcom/tencent/state/map/BaseMapView;Lcom/tencent/state/square/resource/ISquareViewManagerProxy;)V", "data", "", "", "fastClickHelper", "Lcom/tencent/state/utils/FastClickUtils;", "getFragment", "()Lcom/tencent/state/VasBaseFragment;", "getMapView", "()Lcom/tencent/state/map/BaseMapView;", "getSquareViewManager", "()Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "refreshAllItemOperator", "setData", "list", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class PanelAdapter extends RecyclerView.Adapter<PanelViewHolder> {
        private List<String> data;
        private final FastClickUtils fastClickHelper;
        private final VasBaseFragment fragment;
        private final BaseMapView<?> mapView;
        private final ISquareViewManagerProxy squareViewManager;

        public PanelAdapter(VasBaseFragment vasBaseFragment, BaseMapView<?> baseMapView, ISquareViewManagerProxy iSquareViewManagerProxy) {
            List<String> emptyList;
            this.fragment = vasBaseFragment;
            this.mapView = baseMapView;
            this.squareViewManager = iSquareViewManagerProxy;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.data = emptyList;
            this.fastClickHelper = new FastClickUtils(800L);
        }

        public final VasBaseFragment getFragment() {
            return this.fragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        public final BaseMapView<?> getMapView() {
            return this.mapView;
        }

        public final ISquareViewManagerProxy getSquareViewManager() {
            return this.squareViewManager;
        }

        public final void refreshAllItemOperator() {
            if (!this.data.isEmpty()) {
                notifyItemRangeChanged(0, this.data.size());
            }
        }

        public final void setData(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            SquareBaseKt.getSquareLog().i(SquareFriendStatusPanelComponent.TAG, "setData, size=" + list.size());
            this.data = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(PanelViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.bindData(this.data.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public PanelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            VasBaseFragment vasBaseFragment = this.fragment;
            BaseMapView<?> baseMapView = this.mapView;
            VasSquareFriendStatusPanelItemBinding inflate = VasSquareFriendStatusPanelItemBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFriendStatusPan\u2026      )\n                )");
            return new PanelViewHolder(vasBaseFragment, baseMapView, inflate, this.squareViewManager, this.fastClickHelper);
        }
    }

    private final void attachToParent(Context context, VasSquareFriendStatusPanelBinding binding) {
        LinearLayout linearLayout;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.squareBinding;
        if (vasSquareFragmentSquareBinding == null || (linearLayout = vasSquareFragmentSquareBinding.bottomContainer) == null) {
            return;
        }
        RelativeLayout mContainer = binding.getMContainer();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewExtensionsKt.dip(context, 130.0f));
        layoutParams.leftMargin = ViewExtensionsKt.dip(context, 18.0f);
        layoutParams.rightMargin = ViewExtensionsKt.dip(context, 18.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(mContainer, layoutParams);
    }

    private final void initList(Context context, VasSquareFriendStatusPanelBinding binding, FriendStatusPanelData panelData) {
        RecyclerView recyclerView = binding.friendStatusPanelRv;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.friendStatusPanelRv");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        Unit unit = Unit.INSTANCE;
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = binding.friendStatusPanelRv;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.friendStatusPanelRv");
        PanelAdapter panelAdapter = new PanelAdapter(getFragment(), getMapView(), this.squareViewManager);
        panelAdapter.setData(panelData.getList());
        recyclerView2.setAdapter(panelAdapter);
    }

    private final void initListener(VasSquareFriendStatusPanelBinding binding) {
        binding.friendStatusPanel.setOnClickListener(this);
        binding.friendStatusPanelClose.setOnClickListener(this);
    }

    private final void initReport(final VasSquareFriendStatusPanelBinding binding) {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView = binding.friendStatusPanelClose;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.friendStatusPanelClose");
        squareReporter.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, new LinkedHashMap(), false, false);
        binding.friendStatusPanelClose.post(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent$initReport$1
            @Override // java.lang.Runnable
            public final void run() {
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                SquareImageView squareImageView2 = VasSquareFriendStatusPanelBinding.this.friendStatusPanelClose;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.friendStatusPanelClose");
                squareReporter2.reportEvent("imp", squareImageView2, new LinkedHashMap());
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initTitle(VasSquareFriendStatusPanelBinding binding, FriendStatusPanelData panelData) {
        boolean z16;
        String title;
        boolean isBlank;
        TextView textView = binding.friendStatusPanelTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.friendStatusPanelTitle");
        String title2 = panelData.getTitle();
        if (title2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(title2);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    title = panelData.getList().size() + "\u4e2a\u597d\u53cb\u66f4\u65b0\u72b6\u6001";
                } else {
                    title = panelData.getTitle();
                }
                textView.setText(title);
            }
        }
        z16 = true;
        if (!z16) {
        }
        textView.setText(title);
    }

    private final void initView(FriendStatusPanelData panelData, String desc) {
        List<String> list;
        SquareBaseKt.getSquareLog().i(TAG, "initView, from:" + desc);
        if (this.squareBinding == null) {
            SquareBaseKt.getSquareLog().i(TAG, "initView, squareBinding not init");
            return;
        }
        if (panelData != null && (list = panelData.getList()) != null && !list.isEmpty()) {
            if (this.hasInit) {
                SquareBaseKt.getSquareLog().i(TAG, "initView, hasInit");
                return;
            }
            if (!this.receivedData) {
                SquareBaseKt.getSquareLog().i(TAG, "initView, mapData not ready");
                return;
            }
            VasBaseFragment fragment = getFragment();
            Context context = fragment != null ? fragment.getContext() : null;
            if (context == null) {
                SquareBaseKt.getSquareLog().i(TAG, "initView, context is null");
                return;
            } else {
                this.hasInit = true;
                initViewAfterMapDataReady(context, panelData);
                return;
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "initView, list empty");
    }

    private final void refreshAllItemOperator() {
        RecyclerView recyclerView;
        VasSquareFriendStatusPanelBinding vasSquareFriendStatusPanelBinding = this.panelBinding;
        RecyclerView.Adapter adapter = (vasSquareFriendStatusPanelBinding == null || (recyclerView = vasSquareFriendStatusPanelBinding.friendStatusPanelRv) == null) ? null : recyclerView.getAdapter();
        PanelAdapter panelAdapter = (PanelAdapter) (adapter instanceof PanelAdapter ? adapter : null);
        if (panelAdapter != null) {
            panelAdapter.refreshAllItemOperator();
        }
    }

    public final boolean isPanelShowing() {
        return this.panelBinding != null;
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        RelativeLayout mContainer;
        Intrinsics.checkNotNullParameter(view, "view");
        VasSquareFriendStatusPanelBinding vasSquareFriendStatusPanelBinding = this.panelBinding;
        if (vasSquareFriendStatusPanelBinding == null || (mContainer = vasSquareFriendStatusPanelBinding.getMContainer()) == null) {
            return;
        }
        mContainer.setVisibility(isScaleToCenter ? 8 : 0);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        super.onFragmentViewCreated(fm5, f16, v3, savedInstanceState);
        this.squareBinding = VasSquareFragmentSquareBinding.bind(v3);
        this.panelData = SquareBaseComponentKt.getSquareGroupConfig(this).getFriendStatusPanelData();
        ActivityResultCaller fragment = getFragment();
        if (!(fragment instanceof ISquareViewManagerProxy)) {
            fragment = null;
        }
        this.squareViewManager = (ISquareViewManagerProxy) fragment;
        initView(this.panelData, "viewCreated");
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getFromCache()) {
            return;
        }
        List<MapItem> dataList = data.getDataList();
        this.receivedData = !(dataList == null || dataList.isEmpty());
        initView(this.panelData, "receiveData");
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onRoleAdded(List<MoveItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareBaseKt.getSquareLog().i(TAG, "onRoleAdded, size=" + data.size());
        CacheFileUtils.INSTANCE.doUpdateWhenExit();
        refreshAllItemOperator();
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onRoleRemoved(List<String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareBaseKt.getSquareLog().i(TAG, "onRoleRemoved, size=" + data.size());
        CacheFileUtils.INSTANCE.doUpdateWhenExit();
        refreshAllItemOperator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0012\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001cH\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFriendStatusPanelComponent$PanelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "mapView", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "binding", "Lcom/tencent/state/square/databinding/VasSquareFriendStatusPanelItemBinding;", "squareViewManager", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "fastClickHelper", "Lcom/tencent/state/utils/FastClickUtils;", "(Lcom/tencent/state/VasBaseFragment;Lcom/tencent/state/map/BaseMapView;Lcom/tencent/state/square/databinding/VasSquareFriendStatusPanelItemBinding;Lcom/tencent/state/square/resource/ISquareViewManagerProxy;Lcom/tencent/state/utils/FastClickUtils;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareFriendStatusPanelItemBinding;", "getFastClickHelper", "()Lcom/tencent/state/utils/FastClickUtils;", "getFragment", "()Lcom/tencent/state/VasBaseFragment;", "getMapView", "()Lcom/tencent/state/map/BaseMapView;", "getSquareViewManager", "()Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "uin", "", "bindData", "", "bindListener", "bindOperator", "bindUserAvatar", "bindUserNick", "handleOperatorClick", "initReport", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "reportClick", "reportExposure", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class PanelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final VasSquareFriendStatusPanelItemBinding binding;
        private final FastClickUtils fastClickHelper;
        private final VasBaseFragment fragment;
        private final BaseMapView<?> mapView;
        private final ISquareViewManagerProxy squareViewManager;
        private String uin;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PanelViewHolder(VasBaseFragment vasBaseFragment, BaseMapView<?> baseMapView, VasSquareFriendStatusPanelItemBinding binding, ISquareViewManagerProxy iSquareViewManagerProxy, FastClickUtils fastClickHelper) {
            super(binding.getMContainer());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(fastClickHelper, "fastClickHelper");
            this.fragment = vasBaseFragment;
            this.mapView = baseMapView;
            this.binding = binding;
            this.squareViewManager = iSquareViewManagerProxy;
            this.fastClickHelper = fastClickHelper;
            this.uin = "";
            binding.getMContainer().post(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent.PanelViewHolder.1
                @Override // java.lang.Runnable
                public final void run() {
                    PanelViewHolder.this.initReport();
                }
            });
        }

        private final void bindListener() {
            this.binding.itemOperatorIcon.setOnClickListener(this);
            this.binding.itemUserAvatar.setOnClickListener(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void bindOperator(String uin) {
            ISquareViewUpdater squareViewUpdater;
            ISquareViewManagerProxy iSquareViewManagerProxy = this.squareViewManager;
            Boolean valueOf = (iSquareViewManagerProxy == null || (squareViewUpdater = iSquareViewManagerProxy.getSquareViewUpdater()) == null) ? null : Boolean.valueOf(squareViewUpdater.isNotInSquareUinItemType(uin, 1));
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareBaseKt.getSquareLog().d(SquareFriendStatusPanelComponent.TAG, "bindOperator, " + uin + ", " + valueOf);
            }
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(valueOf, bool)) {
                SquareImageView squareImageView = this.binding.itemOperatorIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.itemOperatorIcon");
                squareImageView.setVisibility(0);
            } else {
                SquareImageView squareImageView2 = this.binding.itemOperatorIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.itemOperatorIcon");
                squareImageView2.setVisibility(8);
            }
            SquareImageView squareImageView3 = this.binding.itemOperatorIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.itemOperatorIcon");
            squareImageView3.setTag(Integer.valueOf(Intrinsics.areEqual(valueOf, bool) ? 1 : 0));
        }

        private final void bindUserAvatar(final String uin) {
            FaceUtils.INSTANCE.loadHeadIcon(Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.itemUserAvatar, uin, false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent$PanelViewHolder$bindUserAvatar$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                    return Boolean.valueOf(invoke2(str));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(String str) {
                    return TextUtils.equals(str, uin);
                }
            });
        }

        private final void bindUserNick(String uin) {
            TextView textView = this.binding.itemUserNick;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.itemUserNick");
            textView.setText(SquareBaseKt.getSquareCommon().getFriendRemarkName(uin, uin));
        }

        private final void handleOperatorClick() {
            IMapViewManipulator squareViewAbility;
            ISquareRoleManager squareRoleManager;
            List listOf;
            ISquareViewUpdater squareViewUpdater;
            if (this.fastClickHelper.isFastDoubleClick()) {
                SquareImageView squareImageView = this.binding.itemOperatorIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.itemOperatorIcon");
                Context context = squareImageView.getContext();
                if (context != null) {
                    ICommonUtils.DefaultImpls.showToast$default(SquareBaseKt.getSquareCommon(), context, R.string.xf7, 0, 4, (Object) null);
                    return;
                }
                return;
            }
            ISquareViewManagerProxy iSquareViewManagerProxy = this.squareViewManager;
            Boolean valueOf = (iSquareViewManagerProxy == null || (squareViewUpdater = iSquareViewManagerProxy.getSquareViewUpdater()) == null) ? null : Boolean.valueOf(squareViewUpdater.isNotInSquare(this.uin, 0));
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("bindOperator, ");
                sb5.append(this.uin);
                sb5.append(", ");
                sb5.append(valueOf);
                sb5.append(", ");
                SquareImageView squareImageView2 = this.binding.itemOperatorIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.itemOperatorIcon");
                sb5.append(com.tencent.state.ViewExtensionsKt.isVisible(squareImageView2));
                squareLog.d(SquareFriendStatusPanelComponent.TAG, sb5.toString());
            }
            if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
                ISquareViewManagerProxy iSquareViewManagerProxy2 = this.squareViewManager;
                if (iSquareViewManagerProxy2 == null || (squareRoleManager = iSquareViewManagerProxy2.getSquareRoleManager()) == null) {
                    return;
                }
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new MoveItem(this.uin, 0, false, null, 12, null));
                ISquareRoleManager.DefaultImpls.addMultiRoles$default(squareRoleManager, listOf, 6, MainScene.SQUARE, null, false, false, new Function1<Map<MoveItem, ? extends MoveResult>, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent$PanelViewHolder$handleOperatorClick$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<MoveItem, ? extends MoveResult> map) {
                        invoke2((Map<MoveItem, MoveResult>) map);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<MoveItem, MoveResult> it) {
                        String str;
                        Intrinsics.checkNotNullParameter(it, "it");
                        SquareFriendStatusPanelComponent.PanelViewHolder panelViewHolder = SquareFriendStatusPanelComponent.PanelViewHolder.this;
                        str = panelViewHolder.uin;
                        panelViewHolder.bindOperator(str);
                    }
                }, 56, null);
                return;
            }
            ISquareViewManagerProxy iSquareViewManagerProxy3 = this.squareViewManager;
            if (iSquareViewManagerProxy3 == null || (squareViewAbility = iSquareViewManagerProxy3.getSquareViewAbility()) == null) {
                return;
            }
            IMapViewManipulator.DefaultImpls.locateTo$default(squareViewAbility, this.uin, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initReport() {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            CircleBoarderImageView circleBoarderImageView = this.binding.itemUserAvatar;
            Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.itemUserAvatar");
            squareReporter.setElementInfo(circleBoarderImageView, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_AVATAR, new LinkedHashMap(), false, false);
            IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = this.binding.itemOperatorIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.itemOperatorIcon");
            squareReporter2.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_OPERATOR, new LinkedHashMap(), false, false);
        }

        private final void reportClick() {
            Map<String, Object> mutableMapOf;
            Map<String, Object> mutableMapOf2;
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = this.binding.itemOperatorIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.itemOperatorIcon");
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("zplan_other_user_qq", this.uin);
            SquareImageView squareImageView2 = this.binding.itemOperatorIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.itemOperatorIcon");
            Object tag = squareImageView2.getTag();
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ACTION_BUTTON_TYPE, Integer.valueOf(num != null ? num.intValue() : 0));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            squareReporter.reportEvent("clck", squareImageView, mutableMapOf);
            IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
            CircleBoarderImageView circleBoarderImageView = this.binding.itemUserAvatar;
            Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.itemUserAvatar");
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", this.uin));
            squareReporter2.reportEvent("clck", circleBoarderImageView, mutableMapOf2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void reportExposure(String uin) {
            Map<String, Object> mutableMapOf;
            Map<String, Object> mutableMapOf2;
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            CircleBoarderImageView circleBoarderImageView = this.binding.itemUserAvatar;
            Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.itemUserAvatar");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", uin));
            squareReporter.reportEvent("imp", circleBoarderImageView, mutableMapOf);
            IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = this.binding.itemOperatorIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.itemOperatorIcon");
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("zplan_other_user_qq", uin);
            SquareImageView squareImageView2 = this.binding.itemOperatorIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.itemOperatorIcon");
            Object tag = squareImageView2.getTag();
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ACTION_BUTTON_TYPE, Integer.valueOf(num != null ? num.intValue() : 0));
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr);
            squareReporter2.reportEvent("imp", squareImageView, mutableMapOf2);
        }

        public final void bindData(final String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.uin = uin;
            bindUserAvatar(uin);
            bindUserNick(uin);
            bindOperator(uin);
            bindListener();
            this.binding.getMContainer().post(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent$PanelViewHolder$bindData$1
                @Override // java.lang.Runnable
                public final void run() {
                    SquareFriendStatusPanelComponent.PanelViewHolder.this.reportExposure(uin);
                }
            });
        }

        public final VasSquareFriendStatusPanelItemBinding getBinding() {
            return this.binding;
        }

        public final FastClickUtils getFastClickHelper() {
            return this.fastClickHelper;
        }

        public final VasBaseFragment getFragment() {
            return this.fragment;
        }

        public final BaseMapView<?> getMapView() {
            return this.mapView;
        }

        public final ISquareViewManagerProxy getSquareViewManager() {
            return this.squareViewManager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
            CircleBoarderImageView circleBoarderImageView = this.binding.itemUserAvatar;
            Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.itemUserAvatar");
            int id5 = circleBoarderImageView.getId();
            if (valueOf == null || valueOf.intValue() != id5) {
                SquareImageView squareImageView = this.binding.itemOperatorIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.itemOperatorIcon");
                int id6 = squareImageView.getId();
                if (valueOf == null || valueOf.intValue() != id6) {
                    return;
                }
            }
            handleOperatorClick();
            reportClick();
        }
    }

    private final void initViewAfterMapDataReady(Context context, FriendStatusPanelData panelData) {
        if (panelData != null) {
            List<String> list = panelData.getList();
            VasSquareFriendStatusPanelBinding vasSquareFriendStatusPanelBinding = null;
            if (!(list != null ? Boolean.valueOf(list.isEmpty()) : null).booleanValue()) {
                VasSquareFriendStatusPanelBinding it = VasSquareFriendStatusPanelBinding.inflate(LayoutInflater.from(context));
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    attachToParent(context, it);
                    initTitle(it, panelData);
                    initList(context, it, panelData);
                    initListener(it);
                    initReport(it);
                    Unit unit = Unit.INSTANCE;
                    vasSquareFriendStatusPanelBinding = it;
                }
                this.panelBinding = vasSquareFriendStatusPanelBinding;
                return;
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "initViewAfterMapDataReady, null or empty");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        VasSquareFriendStatusPanelBinding vasSquareFriendStatusPanelBinding;
        LinearLayout linearLayout;
        SquareImageView squareImageView;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        VasSquareFriendStatusPanelBinding vasSquareFriendStatusPanelBinding2 = this.panelBinding;
        if (!Intrinsics.areEqual(valueOf, (vasSquareFriendStatusPanelBinding2 == null || (squareImageView = vasSquareFriendStatusPanelBinding2.friendStatusPanelClose) == null) ? null : Integer.valueOf(squareImageView.getId())) || (vasSquareFriendStatusPanelBinding = this.panelBinding) == null) {
            return;
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView2 = vasSquareFriendStatusPanelBinding.friendStatusPanelClose;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "this.friendStatusPanelClose");
        squareReporter.reportEvent("clck", squareImageView2, new LinkedHashMap());
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.squareBinding;
        if (vasSquareFragmentSquareBinding != null && (linearLayout = vasSquareFragmentSquareBinding.bottomContainer) != null) {
            linearLayout.removeView(vasSquareFriendStatusPanelBinding.getMContainer());
        }
        this.panelBinding = null;
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment != null) {
            squareFragment.forEachComponent(ISquareEventListener.class, null, null, new Function1<ISquareEventListener, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent$onClick$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ISquareEventListener iSquareEventListener) {
                    invoke2(iSquareEventListener);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ISquareEventListener it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onFriendStatusPanelClosed();
                }
            });
        }
    }

    static /* synthetic */ void initView$default(SquareFriendStatusPanelComponent squareFriendStatusPanelComponent, FriendStatusPanelData friendStatusPanelData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            friendStatusPanelData = null;
        }
        squareFriendStatusPanelComponent.initView(friendStatusPanelData, str);
    }

    static /* synthetic */ void initViewAfterMapDataReady$default(SquareFriendStatusPanelComponent squareFriendStatusPanelComponent, Context context, FriendStatusPanelData friendStatusPanelData, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            friendStatusPanelData = null;
        }
        squareFriendStatusPanelComponent.initViewAfterMapDataReady(context, friendStatusPanelData);
    }
}
