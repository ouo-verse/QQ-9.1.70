package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import bl2.HbSkinInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.HbListRecommendSkinViewModel;
import com.tencent.mobileqq.qwallet.hb.send.model.HbSkinViewModel;
import com.tencent.mobileqq.qwallet.hb.send.model.MakeSkinEntryConfig;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.a;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0017H\u0016J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0013R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/impl/HbSkinListFragment;", "Lcom/tencent/mobileqq/qwallet/hb/send/impl/BaseHbFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qwallet/hb/panel/b;", "", "Xh", "Landroid/view/View;", "view", "initView", "Mh", "initTitleBar", "Nh", "initData", "Lbl2/c;", "hbSkinInfo", "Qh", "Uh", "Sh", "Zh", "", "skinId", "Vh", "Wh", "", "Ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onResume", "hidden", "onHiddenChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Q5", "v", NodeProps.ON_CLICK, "isVisibleToUser", "setUserVisibleHint", "keyCode", "Rh", "Lcom/tencent/mobileqq/qwallet/hb/send/model/HbSkinViewModel;", "K", "Lcom/tencent/mobileqq/qwallet/hb/send/model/HbSkinViewModel;", "viewModel", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/HbListRecommendSkinViewModel;", "L", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/HbListRecommendSkinViewModel;", "recommendSkinViewModel", "Lal2/f;", "M", "Lal2/f;", "hbSkinListAdapter", "Landroidx/viewpager2/widget/ViewPager2;", "N", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "confirmBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "recommendSkinListLayout", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "recommendSkinListView", "Landroidx/fragment/app/DialogFragment;", ExifInterface.LATITUDE_SOUTH, "Landroidx/fragment/app/DialogFragment;", "previewDialog", "T", "Z", "needRefreshOnResume", "<init>", "()V", "U", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinListFragment extends BaseHbFragment implements View.OnClickListener, com.tencent.mobileqq.qwallet.hb.panel.b {

    /* renamed from: K, reason: from kotlin metadata */
    private HbSkinViewModel viewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private HbListRecommendSkinViewModel recommendSkinViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private al2.f hbSkinListAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView confirmBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    private View recommendSkinListLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private RecyclerView recommendSkinListView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private DialogFragment previewDialog;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean needRefreshOnResume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qwallet/hb/send/impl/HbSkinListFragment$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f277659d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f277660e;

        b(int i3, int i16) {
            this.f277659d = i3;
            this.f277660e = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childLayoutPosition = parent.getChildLayoutPosition(view);
            if (childLayoutPosition == 0) {
                i3 = this.f277659d;
            } else {
                i3 = this.f277660e;
            }
            outRect.left = i3;
            if (childLayoutPosition == state.getItemCount() - 1) {
                i16 = this.f277659d;
            } else {
                i16 = 0;
            }
            outRect.right = i16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/send/impl/HbSkinListFragment$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            al2.f fVar = HbSkinListFragment.this.hbSkinListAdapter;
            al2.f fVar2 = null;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hbSkinListAdapter");
                fVar = null;
            }
            if (fVar.getItemCount() > 0) {
                HbSkinListFragment hbSkinListFragment = HbSkinListFragment.this;
                al2.f fVar3 = hbSkinListFragment.hbSkinListAdapter;
                if (fVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hbSkinListAdapter");
                } else {
                    fVar2 = fVar3;
                }
                hbSkinListFragment.Wh(fVar2.getItem(position));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Mh(View view) {
        boolean z16;
        try {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                View findViewById = view.findViewById(R.id.j1z);
                findViewById.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext());
                findViewById.requestLayout();
                SendHbActivity sendHbActivity = this.D;
                if (!QQTheme.isNowThemeIsNight()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                com.tencent.mobileqq.qwallet.utils.d.b(sendHbActivity, z16);
            }
        } catch (Throwable th5) {
            QLog.e("SkinPageForUsualHbFragment", 1, th5, new Object[0]);
        }
    }

    private final void Nh(View view) {
        boolean z16;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f67423da);
        final MakeSkinEntryConfig makeSkinEntryConfig = (MakeSkinEntryConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_MAKE_SKIN_ENTRY_SWITCH, MakeSkinEntryConfig.INSTANCE.a());
        String entryTitle = makeSkinEntryConfig.getEntryTitle();
        boolean z17 = true;
        if (entryTitle != null && entryTitle.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String url = makeSkinEntryConfig.getUrl();
            if (url != null && url.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                relativeLayout.setVisibility(0);
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        HbSkinListFragment.Oh(HbSkinListFragment.this, makeSkinEntryConfig, view2);
                    }
                });
                ((TextView) view.findViewById(R.id.f67433db)).setText(makeSkinEntryConfig.getEntryTitle());
                ((ImageView) view.findViewById(R.id.f67413d_)).setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(makeSkinEntryConfig.getEntryIcon()));
                HbSkinViewModel hbSkinViewModel = this.viewModel;
                if (hbSkinViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    hbSkinViewModel = null;
                }
                ReportUtils.g("skinArea.selectpifu.show", hbSkinViewModel.getRecvType(), "", "", "");
                return;
            }
        }
        relativeLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(HbSkinListFragment this$0, MakeSkinEntryConfig entryConfig, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(entryConfig, "$entryConfig");
        com.tencent.mobileqq.qwallet.utils.k.h(this$0.getContext(), entryConfig.getUrl());
        HbSkinViewModel hbSkinViewModel = this$0.viewModel;
        if (hbSkinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            hbSkinViewModel = null;
        }
        ReportUtils.g("skinArea.selectpifu.click", hbSkinViewModel.getRecvType(), "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean Ph() {
        String str;
        Bundle bundle = this.C;
        if (bundle == null || (str = bundle.getString("recv_type")) == null) {
            str = "";
        }
        return com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(HbSkinInfo hbSkinInfo) {
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        if (hbSkinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            hbSkinViewModel = null;
        }
        hbSkinViewModel.O1(hbSkinInfo);
    }

    private final void Sh() {
        RecyclerView recyclerView = this.recommendSkinListView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.recommendSkinListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.q
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinListFragment.Th(HbSkinListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(HbSkinListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recommendSkinListView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListView");
            recyclerView = null;
        }
        int width = recyclerView.getWidth();
        if (width == 0) {
            width = RangesKt___RangesKt.coerceAtMost(MobileQQ.sMobileQQ.getResources().getDisplayMetrics().widthPixels, ViewUtils.dip2px(450.0f));
        }
        RecyclerView recyclerView3 = this$0.recommendSkinListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListView");
            recyclerView3 = null;
        }
        QLog.d("SkinPageForUsualHbFragment", 1, "width = " + width + " recommendSkinListView.width = " + recyclerView3.getWidth());
        double d16 = (double) width;
        int i3 = (int) (0.05d * d16);
        int i16 = (int) (d16 * 0.035d);
        RecyclerView recyclerView4 = this$0.recommendSkinListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.addItemDecoration(new b(i3, i16));
    }

    private final void Uh() {
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setPageTransformer(new al2.g());
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        viewPager23.setOffscreenPageLimit(1);
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager22.registerOnPageChangeCallback(new c());
        Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(int skinId) {
        FragmentActivity fragmentActivity;
        boolean z16;
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return;
        }
        if (fragmentActivity.isFinishing()) {
            QLog.d("SkinPageForUsualHbFragment", 2, "showSkinPreview: activity is finishing " + fragmentActivity);
            return;
        }
        HbListRecommendSkinViewModel hbListRecommendSkinViewModel = this.recommendSkinViewModel;
        if (hbListRecommendSkinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinViewModel");
            hbListRecommendSkinViewModel = null;
        }
        List<com.tencent.mobileqq.qwallet.pb.a> value = hbListRecommendSkinViewModel.Z1().getValue();
        if (value != null) {
            List<com.tencent.mobileqq.qwallet.pb.a> list = value;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                boolean z17 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                com.tencent.mobileqq.qwallet.pb.a aVar = (com.tencent.mobileqq.qwallet.pb.a) next;
                if ((aVar instanceof a.Skin) && !((a.Skin) aVar).getValue().has_got.get()) {
                    z17 = true;
                }
                if (z17) {
                    arrayList.add(next);
                }
            }
            HbListRecommendSkinViewModel hbListRecommendSkinViewModel2 = this.recommendSkinViewModel;
            if (hbListRecommendSkinViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendSkinViewModel");
                hbListRecommendSkinViewModel2 = null;
            }
            if (!Intrinsics.areEqual(arrayList, hbListRecommendSkinViewModel2.Z1().getValue())) {
                HbListRecommendSkinViewModel hbListRecommendSkinViewModel3 = this.recommendSkinViewModel;
                if (hbListRecommendSkinViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendSkinViewModel");
                    hbListRecommendSkinViewModel3 = null;
                }
                MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> Z1 = hbListRecommendSkinViewModel3.Z1();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    com.tencent.mobileqq.qwallet.pb.a aVar2 = (com.tencent.mobileqq.qwallet.pb.a) obj;
                    if ((aVar2 instanceof a.Skin) && !((a.Skin) aVar2).getValue().has_got.get()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList2.add(obj);
                    }
                }
                Z1.setValue(arrayList2);
            }
        }
        HbListRecommendSkinViewModel hbListRecommendSkinViewModel4 = this.recommendSkinViewModel;
        if (hbListRecommendSkinViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinViewModel");
            hbListRecommendSkinViewModel4 = null;
        }
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        if (hbSkinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            hbSkinViewModel = null;
        }
        hbListRecommendSkinViewModel4.q2(new WeakReference<>(hbSkinViewModel.Q1()));
        SkinPreviewDialogFragment a16 = SkinPreviewDialogFragment.INSTANCE.a(1, skinId, com.tencent.mobileqq.qwallet.hb.panel.e.INSTANCE.a(Ph(), null).a());
        a16.Jh(this);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        a16.show(supportFragmentManager, "skin_preview_dialog_fragment");
        this.previewDialog = a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(HbSkinInfo hbSkinInfo) {
        TextView textView = null;
        if (hbSkinInfo.getIsDisable()) {
            TextView textView2 = this.confirmBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
                textView2 = null;
            }
            textView2.setEnabled(false);
            TextView textView3 = this.confirmBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            } else {
                textView = textView3;
            }
            textView.setText(hbSkinInfo.getDisableText());
            return;
        }
        TextView textView4 = this.confirmBtn;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            textView4 = null;
        }
        textView4.setEnabled(true);
        TextView textView5 = this.confirmBtn;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        } else {
            textView = textView5;
        }
        textView.setText("\u4f7f\u7528\u5c01\u9762");
    }

    private final void Xh() {
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        ViewPager2 viewPager2 = null;
        if (hbSkinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            hbSkinViewModel = null;
        }
        HbSkinInfo value = hbSkinViewModel.S1().getValue();
        al2.f fVar = this.hbSkinListAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbSkinListAdapter");
            fVar = null;
        }
        List<HbSkinInfo> currentList = fVar.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "hbSkinListAdapter.currentList");
        final int indexOf = currentList.indexOf(value);
        if (indexOf != -1) {
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.l
                @Override // java.lang.Runnable
                public final void run() {
                    HbSkinListFragment.Yh(HbSkinListFragment.this, indexOf);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(HbSkinListFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(i3, false);
    }

    private final void Zh() {
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinListFragment.ai(HbSkinListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(HbSkinListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        int height = viewPager2.getHeight();
        ViewPager2 viewPager23 = this$0.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        int width = (viewPager23.getWidth() - ((int) ((height * 630.0f) / 1062.0f))) / 2;
        ViewPager2 viewPager24 = this$0.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager22.setPadding(width, 0, width, 0);
    }

    private final void initData() {
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        HbListRecommendSkinViewModel hbListRecommendSkinViewModel = null;
        if (hbSkinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            hbSkinViewModel = null;
        }
        LiveData<Pair<List<HbSkinInfo>, Boolean>> P1 = hbSkinViewModel.P1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final HbSkinListFragment$initData$1 hbSkinListFragment$initData$1 = new HbSkinListFragment$initData$1(this);
        P1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbSkinListFragment.Kh(Function1.this, obj);
            }
        });
        if (!Ph()) {
            HbListRecommendSkinViewModel hbListRecommendSkinViewModel2 = this.recommendSkinViewModel;
            if (hbListRecommendSkinViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendSkinViewModel");
            } else {
                hbListRecommendSkinViewModel = hbListRecommendSkinViewModel2;
            }
            MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> Z1 = hbListRecommendSkinViewModel.Z1();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            final Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.HbSkinListFragment$initData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.qwallet.pb.a> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends com.tencent.mobileqq.qwallet.pb.a> recommendItemList) {
                    int collectionSizeOrDefault;
                    View view;
                    RecyclerView recyclerView;
                    HbListRecommendSkinViewModel hbListRecommendSkinViewModel3;
                    View view2;
                    Intrinsics.checkNotNullExpressionValue(recommendItemList, "recommendItemList");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : recommendItemList) {
                        if (obj instanceof a.Skin) {
                            arrayList.add(obj);
                        }
                    }
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((a.Skin) it.next()).getValue());
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : arrayList2) {
                        if (!((RedPackSkin$RecommendSkin) obj2).has_got.get()) {
                            arrayList3.add(obj2);
                        }
                    }
                    HbListRecommendSkinViewModel hbListRecommendSkinViewModel4 = null;
                    View view3 = null;
                    if (arrayList3.isEmpty()) {
                        view2 = HbSkinListFragment.this.recommendSkinListLayout;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListLayout");
                        } else {
                            view3 = view2;
                        }
                        view3.setVisibility(8);
                        return;
                    }
                    view = HbSkinListFragment.this.recommendSkinListLayout;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListLayout");
                        view = null;
                    }
                    view.setVisibility(0);
                    al2.h hVar = new al2.h(arrayList3);
                    final HbSkinListFragment hbSkinListFragment = HbSkinListFragment.this;
                    hVar.l0(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.HbSkinListFragment$initData$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i3) {
                            HbSkinListFragment.this.Vh(i3);
                        }
                    });
                    recyclerView = HbSkinListFragment.this.recommendSkinListView;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recommendSkinListView");
                        recyclerView = null;
                    }
                    recyclerView.setAdapter(hVar);
                    hbListRecommendSkinViewModel3 = HbSkinListFragment.this.recommendSkinViewModel;
                    if (hbListRecommendSkinViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recommendSkinViewModel");
                    } else {
                        hbListRecommendSkinViewModel4 = hbListRecommendSkinViewModel3;
                    }
                    hbListRecommendSkinViewModel4.A2();
                }
            };
            Z1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HbSkinListFragment.Lh(Function1.this, obj);
                }
            });
        }
    }

    private final void initTitleBar(View view) {
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.f213025p4);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
        Nh(view);
    }

    private final void initView(View view) {
        Mh(view);
        initTitleBar(view);
        View findViewById = view.findViewById(R.id.f66783bk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026p_hb_skin_confirm_button)");
        this.confirmBtn = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f86084qp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.skin_view_pager)");
        this.viewPager = (ViewPager2) findViewById2;
        this.hbSkinListAdapter = new al2.f(new HbSkinListFragment$initView$1(this));
        ViewPager2 viewPager2 = this.viewPager;
        TextView textView = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        al2.f fVar = this.hbSkinListAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbSkinListAdapter");
            fVar = null;
        }
        viewPager2.setAdapter(fVar);
        View findViewById3 = view.findViewById(R.id.f71453o7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.recommend_skin_list_layout)");
        this.recommendSkinListLayout = findViewById3;
        View findViewById4 = view.findViewById(R.id.f71463o8);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.recommend_skin_list_view)");
        this.recommendSkinListView = (RecyclerView) findViewById4;
        TextView textView2 = this.confirmBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            textView2 = null;
        }
        textView2.setEnabled(true);
        TextView textView3 = this.confirmBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(this);
        Uh();
        Sh();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.b
    public void Q5(int skinId) {
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        if (hbSkinViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            hbSkinViewModel = null;
        }
        hbSkinViewModel.W1(skinId, "", 0);
        DialogFragment dialogFragment = this.previewDialog;
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
        this.previewDialog = null;
        this.D.switchToUsualHbFragment(null);
    }

    public final boolean Rh(int keyCode) {
        if (keyCode == 4) {
            this.D.switchToUsualHbFragment(null);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f66783bk) {
            HbSkinViewModel hbSkinViewModel = this.viewModel;
            if (hbSkinViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                hbSkinViewModel = null;
            }
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            hbSkinViewModel.X1(viewPager2.getCurrentItem());
            this.D.switchToUsualHbFragment(null);
        } else if (v3.getId() == R.id.ivTitleBtnLeft) {
            this.D.switchToUsualHbFragment(null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Zh();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i("SkinPageForUsualHbFragment", 2, "onCreateView: " + HbSkinListFragment.class.getSimpleName());
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.hj8, (ViewGroup) null);
        HbSkinViewModel viewModel = this.D.getViewModel();
        Intrinsics.checkNotNullExpressionValue(viewModel, "mActivity.viewModel");
        this.viewModel = viewModel;
        HbListRecommendSkinViewModel hbListRecommendskinViewModel = this.D.getHbListRecommendskinViewModel();
        Intrinsics.checkNotNullExpressionValue(hbListRecommendskinViewModel, "mActivity.hbListRecommendskinViewModel");
        this.recommendSkinViewModel = hbListRecommendskinViewModel;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        initView(view);
        initData();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            Xh();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needRefreshOnResume) {
            this.needRefreshOnResume = false;
            HbSkinViewModel hbSkinViewModel = this.viewModel;
            if (hbSkinViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                hbSkinViewModel = null;
            }
            hbSkinViewModel.U1();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        String str;
        String str2;
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Bundle bundle = this.C;
            if (bundle == null || (str = bundle.getString("panel_name")) == null) {
                str = "";
            }
            Bundle bundle2 = this.C;
            if (bundle2 == null || (str2 = bundle2.getString("recv_type")) == null) {
                str2 = "";
            }
            ReportUtils.g("redpack.selectpifu.show", str2, str, "", "");
        }
    }
}
