package com.tencent.ecommerce.biz.orders.address.picker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.recycleview.ECTextTagItemDecoration;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictAddressInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictType;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerInitIntent;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerSelectedIntent;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerState;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECCityInfo;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u000245B\u000f\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View;", "view", "", "initView", "xh", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "cityList", "wh", "yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "vh", "()Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerViewModel;", "viewModel", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "cityListTitle", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "cityListLayout", UserInfo.SEX_FEMALE, "hint", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter;", "G", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter;", "cityListAdapter", "H", "districtList", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter;", "I", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter;", "adapter", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;", "J", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;)V", "AddressAdapter", "CityListAdapter", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressItemFragment extends Fragment {

    /* renamed from: D, reason: from kotlin metadata */
    private TextView cityListTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView cityListLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView hint;

    /* renamed from: G, reason: from kotlin metadata */
    private CityListAdapter cityListAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView districtList;

    /* renamed from: J, reason: from kotlin metadata */
    private final DistrictType type;

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECAddressPickerViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressItemFragment$$special$$inlined$activityViewModels$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressItemFragment$$special$$inlined$activityViewModels$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
            ViewModelProvider.Factory defaultViewModelProviderFactory = requireActivity.getDefaultViewModelProviderFactory();
            Intrinsics.checkExpressionValueIsNotNull(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: I, reason: from kotlin metadata */
    private final AddressAdapter adapter = new AddressAdapter();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002%&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0016\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter$a;", "Lcom/tencent/ecommerce/base/ui/recycleview/ECTextTagItemDecoration$TextTagRecycleViewAdapter;", "", "position", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "k0", "getItemCount", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter$ItemClickListener;", "listener", "m0", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "addressInfoList", "initSelectedIndex", "q3", "", "getTextTag", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", BdhLogUtil.LogTag.Tag_Conn, "I", "selectedPosition", "D", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter$ItemClickListener;", "itemClickListener", "<init>", "()V", "a", "ItemClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class AddressAdapter extends RecyclerView.Adapter<a> implements ECTextTagItemDecoration.TextTagRecycleViewAdapter {

        /* renamed from: D, reason: from kotlin metadata */
        private ItemClickListener itemClickListener;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final List<DistrictAddressInfo> data = new ArrayList();

        /* renamed from: C, reason: from kotlin metadata */
        private int selectedPosition = -1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter$ItemClickListener;", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "itemData", "", "onItemClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public interface ItemClickListener {
            void onItemClickListener(DistrictAddressInfo itemData);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001c\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$AddressAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "name", "", "isSelected", "", "l", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "image", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            private final TextView textView;

            /* renamed from: F, reason: from kotlin metadata */
            private final ImageView image;

            public a(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.o4z);
                this.image = (ImageView) view.findViewById(R.id.o0z);
            }

            public final void l(String name, boolean isSelected) {
                this.textView.setText(name);
                if (isSelected) {
                    this.image.setVisibility(0);
                    this.textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6952y));
                } else {
                    this.image.setVisibility(8);
                    this.textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f103079e;

            b(int i3) {
                this.f103079e = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ItemClickListener itemClickListener = AddressAdapter.this.itemClickListener;
                if (itemClickListener != null) {
                    itemClickListener.onItemClickListener((DistrictAddressInfo) AddressAdapter.this.data.get(this.f103079e));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        private final void n0(int position) {
            int i3 = this.selectedPosition;
            this.selectedPosition = position;
            if (i3 > -1) {
                notifyItemChanged(i3);
            }
            notifyItemChanged(this.selectedPosition);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.data.size();
        }

        @Override // com.tencent.ecommerce.base.ui.recycleview.ECTextTagItemDecoration.TextTagRecycleViewAdapter
        public String getTextTag(int position) {
            boolean isBlank;
            isBlank = StringsKt__StringsJVMKt.isBlank(this.data.get(position).getPingYin());
            if (isBlank) {
                return "";
            }
            String pingYin = this.data.get(position).getPingYin();
            if (pingYin != null) {
                String substring = pingYin.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            holder.l(this.data.get(position).name, this.selectedPosition == position);
            holder.itemView.setOnClickListener(new b(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            return new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.cop, parent, false));
        }

        public final void m0(ItemClickListener listener) {
            this.itemClickListener = listener;
        }

        public final void q3(List<DistrictAddressInfo> addressInfoList, int initSelectedIndex) {
            if (Intrinsics.areEqual(this.data, addressInfoList)) {
                if (this.selectedPosition != initSelectedIndex) {
                    n0(initSelectedIndex);
                }
            } else {
                this.data.clear();
                this.data.addAll(addressInfoList);
                this.selectedPosition = initSelectedIndex;
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "cityInfo", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "selectedPosition", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "data", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$ItemClickListener;", "D", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$ItemClickListener;", "itemClickListener", "<init>", "(Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$ItemClickListener;)V", "a", "ItemClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class CityListAdapter extends RecyclerView.Adapter<a> {

        /* renamed from: C, reason: from kotlin metadata */
        private final List<ECCityInfo> data;

        /* renamed from: D, reason: from kotlin metadata */
        private final ItemClickListener itemClickListener;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private int selectedPosition = -1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$ItemClickListener;", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "data", "", "onItemClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public interface ItemClickListener {
            void onItemClick(ECCityInfo data);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001c\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "cityInfo", "", "isSelected", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "cityName", "", "G", "I", "selectedTextColor", "H", "unselectedTextColor", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$ItemClickListener;", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$ItemClickListener;", "listener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$CityListAdapter$ItemClickListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            private final ImageView icon;

            /* renamed from: F, reason: from kotlin metadata */
            private final TextView cityName;

            /* renamed from: G, reason: from kotlin metadata */
            private final int selectedTextColor;

            /* renamed from: H, reason: from kotlin metadata */
            private final int unselectedTextColor;

            /* renamed from: I, reason: from kotlin metadata */
            private final ItemClickListener listener;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.ecommerce.biz.orders.address.picker.ECAddressItemFragment$CityListAdapter$a$a, reason: collision with other inner class name */
            /* loaded from: classes31.dex */
            public static final class ViewOnClickListenerC1065a implements View.OnClickListener {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ECCityInfo f103082e;

                ViewOnClickListenerC1065a(ECCityInfo eCCityInfo) {
                    this.f103082e = eCCityInfo;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    a.this.listener.onItemClick(this.f103082e);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            public a(View view, ItemClickListener itemClickListener) {
                super(view);
                this.listener = itemClickListener;
                this.icon = (ImageView) view.findViewById(R.id.o3r);
                this.cityName = (TextView) view.findViewById(R.id.ntb);
                this.selectedTextColor = ResourcesCompat.getColor(view.getResources(), R.color.f6952y, null);
                this.unselectedTextColor = ResourcesCompat.getColor(view.getResources(), R.color.f6942x, null);
            }

            public final void m(ECCityInfo cityInfo, boolean isSelected) {
                this.cityName.setText(cityInfo.getCity());
                this.icon.setVisibility(cityInfo.getIsCurrentLocation() ? 0 : 8);
                this.itemView.setOnClickListener(new ViewOnClickListenerC1065a(cityInfo));
                if (isSelected) {
                    this.cityName.setTextColor(this.selectedTextColor);
                    this.icon.setImageResource(R.drawable.dqp);
                } else {
                    this.cityName.setTextColor(this.unselectedTextColor);
                    this.icon.setImageResource(R.drawable.f159707ef4);
                }
                this.itemView.setSelected(isSelected);
            }
        }

        public CityListAdapter(List<ECCityInfo> list, ItemClickListener itemClickListener) {
            this.data = list;
            this.itemClickListener = itemClickListener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.data.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            holder.m(this.data.get(position), position == this.selectedPosition);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            return new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.cok, parent, false), this.itemClickListener);
        }

        public final void k0(ECCityInfo cityInfo) {
            int i3 = this.selectedPosition;
            int indexOf = this.data.indexOf(cityInfo);
            notifyItemChanged(i3);
            this.selectedPosition = indexOf;
            notifyItemChanged(indexOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "it", "", "onItemClick", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements CityListAdapter.ItemClickListener {
        a() {
        }

        @Override // com.tencent.ecommerce.biz.orders.address.picker.ECAddressItemFragment.CityListAdapter.ItemClickListener
        public final void onItemClick(ECCityInfo eCCityInfo) {
            List mutableListOf;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(eCCityInfo.province, eCCityInfo.getCity());
            ECAddressItemFragment.this.vh().O1(new ECAddressPickerInitIntent(mutableListOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/f;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/f;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<ECAddressPickerState> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECAddressPickerState eCAddressPickerState) {
            if (eCAddressPickerState.c().size() > 1) {
                ECCityInfo eCCityInfo = new ECCityInfo(eCAddressPickerState.c().get(0).name, eCAddressPickerState.c().get(1).name);
                CityListAdapter cityListAdapter = ECAddressItemFragment.this.cityListAdapter;
                if (cityListAdapter != null) {
                    cityListAdapter.k0(eCCityInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/f;", "kotlin.jvm.PlatformType", "addressPickerState", "", "a", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/f;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<ECAddressPickerState> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECAddressPickerState eCAddressPickerState) {
            int indexOf;
            if (eCAddressPickerState.getIsFinishSelected() || eCAddressPickerState.a().size() <= ECAddressItemFragment.this.type.ordinal()) {
                return;
            }
            List<DistrictAddressInfo> list = eCAddressPickerState.a().get(ECAddressItemFragment.this.type.ordinal());
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends DistrictAddressInfo>) ((List<? extends Object>) list), eCAddressPickerState.c().size() > ECAddressItemFragment.this.type.ordinal() ? eCAddressPickerState.c().get(ECAddressItemFragment.this.type.ordinal()) : null);
            ECAddressItemFragment.this.adapter.q3(list, indexOf);
            ECAddressItemFragment.rh(ECAddressItemFragment.this).scrollToPosition(indexOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "itemData", "", "onItemClickListener", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements AddressAdapter.ItemClickListener {
        d() {
        }

        @Override // com.tencent.ecommerce.biz.orders.address.picker.ECAddressItemFragment.AddressAdapter.ItemClickListener
        public final void onItemClickListener(DistrictAddressInfo districtAddressInfo) {
            ECAddressItemFragment.this.vh().O1(new ECAddressPickerSelectedIntent(districtAddressInfo));
        }
    }

    public ECAddressItemFragment(DistrictType districtType) {
        this.type = districtType;
    }

    public static final /* synthetic */ RecyclerView rh(ECAddressItemFragment eCAddressItemFragment) {
        RecyclerView recyclerView = eCAddressItemFragment.districtList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtList");
        }
        return recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECAddressPickerViewModel vh() {
        return (ECAddressPickerViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(List<ECCityInfo> cityList) {
        RecyclerView recyclerView = this.cityListLayout;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cityListLayout");
        }
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        this.cityListAdapter = new CityListAdapter(cityList, new a());
        RecyclerView recyclerView2 = this.cityListLayout;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cityListLayout");
        }
        recyclerView2.setAdapter(this.cityListAdapter);
        CityListAdapter cityListAdapter = this.cityListAdapter;
        if (cityListAdapter != null) {
            cityListAdapter.notifyDataSetChanged();
        }
        yh();
        vh().P1().observe(getViewLifecycleOwner(), new b());
    }

    private final void xh() {
        vh().P1().observe(getViewLifecycleOwner(), new c());
        if (this.type == DistrictType.Nation) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        }
    }

    private final void yh() {
        TextView textView = this.hint;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hint");
        }
        textView.setVisibility(0);
        TextView textView2 = this.cityListTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cityListTitle");
        }
        textView2.setVisibility(0);
        RecyclerView recyclerView = this.cityListLayout;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cityListLayout");
        }
        recyclerView.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        xh();
    }

    private final void initView(View view) {
        this.cityListTitle = (TextView) view.findViewById(R.id.nta);
        this.cityListLayout = (RecyclerView) view.findViewById(R.id.nt_);
        this.hint = (TextView) view.findViewById(R.id.o_7);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o8n);
        this.districtList = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtList");
        }
        recyclerView.setAdapter(this.adapter);
        this.adapter.m0(new d());
        RecyclerView recyclerView2 = this.districtList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtList");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView3 = this.districtList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtList");
        }
        recyclerView3.addItemDecoration(new ECTextTagItemDecoration(this.adapter, e.c(15.0f), getResources().getColor(R.color.f6962z)));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.col, container, false);
    }
}
