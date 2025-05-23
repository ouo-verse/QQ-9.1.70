package com.tencent.mobileqq.qwallet.hb.detail;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001KB1\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010F\u001a\u00020E\u0012\b\b\u0002\u0010G\u001a\u00020E\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0014J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010\u0014R\u0016\u00101\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00103\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00105\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010\u0014R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0007068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R,\u0010=\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;0:068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020>068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u00108\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinCoverView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "Q0", "L0", "S0", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "hbSkinData", "R0", "T0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onFinishInflate", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinViewModel;", "d", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinViewModel;", "viewModel", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "defaultCoverView", "Landroid/view/View;", "f", "Landroid/view/View;", "noSkinCoverView", "Landroidx/viewpager2/widget/ViewPager2;", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "storyViewPager", "Lcom/google/android/material/tabs/TabLayout;", "i", "Lcom/google/android/material/tabs/TabLayout;", "storyTabLayout", "Lcom/tencent/mobileqq/qwallet/hb/detail/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/hb/detail/d;", "pagerAdapter", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "storyInfoLayout", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "merchantTitle", "E", "merchantLogo", UserInfo.SEX_FEMALE, "merchantName", "G", "landingPageView", "H", "expandCoverView", "Landroidx/lifecycle/Observer;", "I", "Landroidx/lifecycle/Observer;", "hbSkinDataObserver", "Lkotlin/Triple;", "", "J", "scrollInfoObserver", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", "K", "stateObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "L", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinCoverView extends ConstraintLayout implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup storyInfoLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView merchantTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView merchantLogo;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView merchantName;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView landingPageView;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView expandCoverView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Observer<HbSkinData> hbSkinDataObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Observer<Triple<Float, Float, Float>> scrollInfoObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Observer<HbSkinState> stateObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HbSkinViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView defaultCoverView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View noSkinCoverView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 storyViewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TabLayout storyTabLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private d pagerAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/detail/HbSkinCoverView$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            d dVar = HbSkinCoverView.this.pagerAdapter;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                dVar = null;
            }
            dVar.i0().setValue(Integer.valueOf(position));
            if (HbSkinCoverView.this.viewModel.Z1().getValue() == HbSkinState.EXPANDED) {
                HbDetailModule.l("redpacket.story.show", String.valueOf(HbSkinCoverView.this.viewModel.getSkinId()), String.valueOf(position), HbSkinCoverView.this.viewModel.getUniqueSkinId());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/detail/HbSkinCoverView$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (view != null && outline != null) {
                outline.setRoundRect((int) (view.getLeft() - (view.getWidth() * 1.0f)), (int) (view.getBottom() - (view.getWidth() * 3.0f)), (int) (view.getRight() + (view.getWidth() * 1.0f)), view.getBottom(), view.getWidth() * 1.5f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinCoverView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(HbSkinCoverView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("HbSkinCoverView", 1, ":click cover view ");
        HbSkinState value = this$0.viewModel.Z1().getValue();
        if (value == HbSkinState.INITIAL || value == HbSkinState.INTERMEDIATE) {
            this$0.viewModel.Q1(HbSkinState.EXPANDED);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(HbSkinCoverView this$0, HbSkinData hbSkinData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hbSkinData != null && ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isSupportSkinStory(hbSkinData.getSkinType())) {
            this$0.R0(hbSkinData);
            this$0.T0(hbSkinData);
        } else {
            this$0.S0();
        }
    }

    private final void L0() {
        this.viewModel.Q1(HbSkinState.EXPANDED);
        HbDetailModule.l("redpacket.firstpic.click", String.valueOf(this.viewModel.getSkinId()), "", this.viewModel.getUniqueSkinId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(HbSkinCoverView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(TabLayout.g tab, int i3) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.f34288i.setEnabled(false);
        QLog.d("HbSkinCoverView", 2, "onConfigureTab: tab " + tab + ", position, " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(HbSkinCoverView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(HbSkinCoverView this$0, Triple triple) {
        float coerceAtLeast;
        float coerceAtMost;
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.viewModel.T1()) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((((Number) triple.getFirst()).floatValue() - ((Number) triple.getSecond()).floatValue()) / (((Number) triple.getThird()).floatValue() - ((Number) triple.getSecond()).floatValue()), 0.0f);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
            ViewGroup viewGroup = this$0.storyInfoLayout;
            ImageView imageView = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storyInfoLayout");
                viewGroup = null;
            }
            viewGroup.setAlpha(coerceAtMost);
            ViewGroup viewGroup2 = this$0.storyInfoLayout;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storyInfoLayout");
                viewGroup2 = null;
            }
            int i16 = 0;
            if (coerceAtMost == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            viewGroup2.setVisibility(i3);
            ImageView imageView2 = this$0.expandCoverView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandCoverView");
                imageView2 = null;
            }
            imageView2.setAlpha(1.0f - coerceAtMost);
            ImageView imageView3 = this$0.expandCoverView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandCoverView");
            } else {
                imageView = imageView3;
            }
            if (((Number) triple.getFirst()).floatValue() <= 20.0f || ((Number) triple.getFirst()).floatValue() >= ((Number) triple.getSecond()).floatValue() + 20) {
                i16 = 8;
            }
            imageView.setVisibility(i16);
        }
    }

    private final void Q0() {
        setOutlineProvider(new c());
        setClipToOutline(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.material.tabs.TabLayout] */
    private final void R0(HbSkinData hbSkinData) {
        int i3 = 8;
        ImageView imageView = null;
        if (hbSkinData.t().isEmpty()) {
            ViewPager2 viewPager2 = this.storyViewPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
                viewPager2 = null;
            }
            viewPager2.setVisibility(8);
            ViewGroup viewGroup = this.storyInfoLayout;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storyInfoLayout");
                viewGroup = null;
            }
            viewGroup.setVisibility(8);
            ImageView imageView2 = this.expandCoverView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandCoverView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        d dVar = this.pagerAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            dVar = null;
        }
        dVar.n0(hbSkinData);
        ViewPager2 viewPager22 = this.storyViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
            viewPager22 = null;
        }
        viewPager22.setVisibility(0);
        ?? r06 = this.storyTabLayout;
        if (r06 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("storyTabLayout");
        } else {
            imageView = r06;
        }
        if (hbSkinData.t().size() > 1) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    private final void S0() {
        ImageView imageView = this.defaultCoverView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultCoverView");
            imageView = null;
        }
        imageView.setVisibility(8);
        View view = this.noSkinCoverView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noSkinCoverView");
            view = null;
        }
        view.setVisibility(0);
        ViewGroup viewGroup = this.storyInfoLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyInfoLayout");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        ViewPager2 viewPager2 = this.storyViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
            viewPager2 = null;
        }
        viewPager2.setVisibility(8);
        ImageView imageView3 = this.expandCoverView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCoverView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void T0(final HbSkinData hbSkinData) {
        boolean z16;
        TextView textView;
        ImageView imageView;
        String activityEntryName;
        boolean z17;
        TextView textView2;
        TextView textView3;
        boolean isBlank;
        boolean isBlank2;
        boolean z18;
        boolean isBlank3;
        boolean isBlank4;
        TextView textView4 = this.merchantTitle;
        TextView textView5 = null;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("merchantTitle");
            textView4 = null;
        }
        textView4.setText(hbSkinData.getTitle());
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nvg);
        if (!this.viewModel.T1()) {
            QLog.i("HbSkinCoverView", 2, "showSkinUrl: " + hbSkinData.getDefaultSkinUrl());
            ImageView imageView2 = this.defaultCoverView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultCoverView");
                imageView2 = null;
            }
            imageView2.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(hbSkinData.getDefaultSkinUrl(), drawable, drawable));
        } else {
            QLog.i("HbSkinCoverView", 2, "show defaultCover");
            ImageView imageView3 = this.defaultCoverView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultCoverView");
                imageView3 = null;
            }
            imageView3.setImageDrawable(drawable);
        }
        String merchantName = hbSkinData.getMerchantName();
        boolean z19 = true;
        if (merchantName != null) {
            isBlank4 = StringsKt__StringsJVMKt.isBlank(merchantName);
            if (!isBlank4) {
                z16 = false;
                if (!z16) {
                    String merchantLogoUrl = hbSkinData.getMerchantLogoUrl();
                    if (merchantLogoUrl != null) {
                        isBlank3 = StringsKt__StringsJVMKt.isBlank(merchantLogoUrl);
                        if (!isBlank3) {
                            z18 = false;
                            if (!z18) {
                                TextView textView6 = this.merchantName;
                                if (textView6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("merchantName");
                                    textView6 = null;
                                }
                                textView6.setText(hbSkinData.getMerchantName());
                                ColorDrawable colorDrawable = new ColorDrawable(0);
                                ImageView imageView4 = this.merchantLogo;
                                if (imageView4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("merchantLogo");
                                    imageView4 = null;
                                }
                                imageView4.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(hbSkinData.getMerchantLogoUrl(), colorDrawable, colorDrawable));
                                activityEntryName = hbSkinData.getActivityEntryName();
                                if (activityEntryName != null) {
                                    isBlank2 = StringsKt__StringsJVMKt.isBlank(activityEntryName);
                                    if (!isBlank2) {
                                        z17 = false;
                                        if (!z17) {
                                            String activityUrl = hbSkinData.getActivityUrl();
                                            if (activityUrl != null) {
                                                isBlank = StringsKt__StringsJVMKt.isBlank(activityUrl);
                                                if (!isBlank) {
                                                    z19 = false;
                                                }
                                            }
                                            if (!z19) {
                                                TextView textView7 = this.landingPageView;
                                                if (textView7 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("landingPageView");
                                                    textView7 = null;
                                                }
                                                textView7.setText(hbSkinData.getActivityEntryName());
                                                textView3 = this.landingPageView;
                                                if (textView3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("landingPageView");
                                                } else {
                                                    textView5 = textView3;
                                                }
                                                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.al
                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        HbSkinCoverView.U0(HbSkinCoverView.this, hbSkinData, view);
                                                    }
                                                });
                                            }
                                        }
                                        textView2 = this.landingPageView;
                                        if (textView2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("landingPageView");
                                            textView2 = null;
                                        }
                                        textView2.setVisibility(8);
                                        textView3 = this.landingPageView;
                                        if (textView3 == null) {
                                        }
                                        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.al
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                HbSkinCoverView.U0(HbSkinCoverView.this, hbSkinData, view);
                                            }
                                        });
                                    }
                                }
                                z17 = true;
                                if (!z17) {
                                }
                                textView2 = this.landingPageView;
                                if (textView2 == null) {
                                }
                                textView2.setVisibility(8);
                                textView3 = this.landingPageView;
                                if (textView3 == null) {
                                }
                                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.al
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        HbSkinCoverView.U0(HbSkinCoverView.this, hbSkinData, view);
                                    }
                                });
                            }
                        }
                    }
                    z18 = true;
                    if (!z18) {
                    }
                }
                textView = this.merchantName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("merchantName");
                    textView = null;
                }
                textView.setVisibility(8);
                imageView = this.merchantLogo;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("merchantLogo");
                    imageView = null;
                }
                imageView.setVisibility(8);
                activityEntryName = hbSkinData.getActivityEntryName();
                if (activityEntryName != null) {
                }
                z17 = true;
                if (!z17) {
                }
                textView2 = this.landingPageView;
                if (textView2 == null) {
                }
                textView2.setVisibility(8);
                textView3 = this.landingPageView;
                if (textView3 == null) {
                }
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.al
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HbSkinCoverView.U0(HbSkinCoverView.this, hbSkinData, view);
                    }
                });
            }
        }
        z16 = true;
        if (!z16) {
        }
        textView = this.merchantName;
        if (textView == null) {
        }
        textView.setVisibility(8);
        imageView = this.merchantLogo;
        if (imageView == null) {
        }
        imageView.setVisibility(8);
        activityEntryName = hbSkinData.getActivityEntryName();
        if (activityEntryName != null) {
        }
        z17 = true;
        if (!z17) {
        }
        textView2 = this.landingPageView;
        if (textView2 == null) {
        }
        textView2.setVisibility(8);
        textView3 = this.landingPageView;
        if (textView3 == null) {
        }
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HbSkinCoverView.U0(HbSkinCoverView.this, hbSkinData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(HbSkinCoverView this$0, HbSkinData hbSkinData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hbSkinData, "$hbSkinData");
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        com.tencent.mobileqq.qwallet.utils.k.h((Activity) context, hbSkinData.getActivityUrl());
        HbDetailModule.m("redpacket.story.source.click", String.valueOf(this$0.viewModel.getSkinId()), this$0.viewModel.getUniqueSkinId(), null, 8, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(HbSkinCoverView this$0, HbSkinState hbSkinState) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.storyViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
            viewPager2 = null;
        }
        if (hbSkinState == HbSkinState.EXPANDED) {
            z16 = true;
        } else {
            z16 = false;
        }
        viewPager2.setUserInputEnabled(z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        hbSkinViewModel.W1().observeForever(this.scrollInfoObserver);
        hbSkinViewModel.U1().observeForever(this.hbSkinDataObserver);
        hbSkinViewModel.Z1().observeForever(this.stateObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        hbSkinViewModel.W1().removeObserver(this.scrollInfoObserver);
        hbSkinViewModel.U1().removeObserver(this.hbSkinDataObserver);
        hbSkinViewModel.Z1().removeObserver(this.stateObserver);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HbSkinCoverView.M0(HbSkinCoverView.this, view);
            }
        });
        QLog.d("HbSkinCoverView", 2, "onFinishInflate: ");
        View findViewById = findViewById(R.id.x65);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hb_detail_default_cover)");
        this.defaultCoverView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.x67);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.hb_detail_no_skin_cover)");
        this.noSkinCoverView = findViewById2;
        View findViewById3 = findViewById(R.id.x6g);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hb_detail_story_view_pager)");
        ViewPager2 viewPager2 = (ViewPager2) findViewById3;
        this.storyViewPager = viewPager2;
        ImageView imageView = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
            viewPager2 = null;
        }
        viewPager2.setOffscreenPageLimit(1);
        View findViewById4 = findViewById(R.id.f88554xd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.story_tab_layout)");
        this.storyTabLayout = (TabLayout) findViewById4;
        this.pagerAdapter = new d(this.viewModel.Z1(), this.viewModel.W1(), this.viewModel.getSkinId(), this.viewModel.getUniqueSkinId());
        ViewPager2 viewPager22 = this.storyViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
            viewPager22 = null;
        }
        d dVar = this.pagerAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            dVar = null;
        }
        viewPager22.setAdapter(dVar);
        ViewPager2 viewPager23 = this.storyViewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
            viewPager23 = null;
        }
        viewPager23.registerOnPageChangeCallback(new b());
        TabLayout tabLayout = this.storyTabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyTabLayout");
            tabLayout = null;
        }
        ViewPager2 viewPager24 = this.storyViewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyViewPager");
            viewPager24 = null;
        }
        new com.google.android.material.tabs.d(tabLayout, viewPager24, new d.b() { // from class: com.tencent.mobileqq.qwallet.hb.detail.aj
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i3) {
                HbSkinCoverView.N0(gVar, i3);
            }
        }).a();
        View findViewById5 = findViewById(R.id.x76);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.hb_skin_info_layout)");
        this.storyInfoLayout = (ViewGroup) findViewById5;
        View findViewById6 = findViewById(R.id.f166247z53);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.merchant_title)");
        this.merchantTitle = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.z4x);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.merchant_logo)");
        this.merchantLogo = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.z4z);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.merchant_name)");
        this.merchantName = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.ycp);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.landing_page_btn)");
        this.landingPageView = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.uy9);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.expand_cover_view)");
        ImageView imageView2 = (ImageView) findViewById10;
        this.expandCoverView = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCoverView");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HbSkinCoverView.O0(HbSkinCoverView.this, view);
            }
        });
        if (!this.viewModel.c2()) {
            S0();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinCoverView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinCoverView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HbSkinCoverView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public HbSkinCoverView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof ComponentActivity) {
            ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(HbSkinViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(contex\u2026kinViewModel::class.java)");
            HbSkinViewModel hbSkinViewModel = (HbSkinViewModel) viewModel;
            this.viewModel = hbSkinViewModel;
            ((ComponentActivity) context).getLifecycle().addObserver(hbSkinViewModel);
            View.inflate(context, R.layout.hkc, this);
            Q0();
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HbSkinCoverView.H0(HbSkinCoverView.this, view);
                }
            });
            ViewCompat.setImportantForAccessibility(this, 2);
            this.hbSkinDataObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.af
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HbSkinCoverView.K0(HbSkinCoverView.this, (HbSkinData) obj);
                }
            };
            this.scrollInfoObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ag
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HbSkinCoverView.P0(HbSkinCoverView.this, (Triple) obj);
                }
            };
            this.stateObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ah
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HbSkinCoverView.V0(HbSkinCoverView.this, (HbSkinState) obj);
                }
            };
            return;
        }
        throw new IllegalArgumentException("current context should inherited from androidx.activity.ComponentActivity.");
    }
}
