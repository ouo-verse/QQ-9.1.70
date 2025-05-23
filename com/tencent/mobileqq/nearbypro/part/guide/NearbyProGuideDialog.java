package com.tencent.mobileqq.nearbypro.part.guide;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u00020\u0001:\u0001UB\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J&\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0018J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0006\u0010\u001f\u001a\u00020\u0002R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00107R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/guide/NearbyProGuideDialog;", "Lcom/google/android/material/bottomsheet/a;", "", "i0", "l0", "e0", "d0", "f0", "n0", "a0", "", "guideTitle", "r0", "guideDesc", "q0", "", "position", "p0", "imageWidth", "imageHeight", "", "Lcom/tencent/mobileqq/nearbypro/part/guide/a;", "guideItemList", "o0", "", "m0", "Landroid/view/View;", "b0", "showDialog", "c0", "dismiss", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/nearbypro/part/guide/f;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/nearbypro/part/guide/f;", "mGuideContext", "Lcom/tencent/mobileqq/nearbypro/part/guide/c;", "D", "Lcom/tencent/mobileqq/nearbypro/part/guide/c;", "mGuideCallback", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mGuideTitleTv", UserInfo.SEX_FEMALE, "mGuideDescTv", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "G", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "mBannerLayout", "Lcom/tencent/mobileqq/nearbypro/part/guide/d;", "H", "Lcom/tencent/mobileqq/nearbypro/part/guide/d;", "mBannerAdapter", "Lcom/tencent/mobileqq/nearbypro/part/guide/NearbyProGuideBannerIndicator;", "I", "Lcom/tencent/mobileqq/nearbypro/part/guide/NearbyProGuideBannerIndicator;", "mBannerIndicator", "Landroid/widget/Button;", "J", "Landroid/widget/Button;", "mEnterBtn", "K", "Landroid/view/View;", "mRootView", "L", "Z", "mHasClickEnter", "M", "mGuideConfigItemSize", "Landroid/animation/ObjectAnimator;", "N", "Landroid/animation/ObjectAnimator;", "mShowAnimator", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "P", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "mLoadConfigJob", "Ljava/util/concurrent/atomic/AtomicBoolean;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsAsyncLoadingConfig", "<init>", "(Lcom/tencent/mobileqq/nearbypro/part/guide/f;Lcom/tencent/mobileqq/nearbypro/part/guide/c;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProGuideDialog extends com.google.android.material.bottomsheet.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final NearbyProGuideContext mGuideContext;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c mGuideCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mGuideTitleTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mGuideDescTv;

    /* renamed from: G, reason: from kotlin metadata */
    private BannerLayout mBannerLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private d mBannerAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private NearbyProGuideBannerIndicator mBannerIndicator;

    /* renamed from: J, reason: from kotlin metadata */
    private Button mEnterBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mHasClickEnter;

    /* renamed from: M, reason: from kotlin metadata */
    private int mGuideConfigItemSize;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ObjectAnimator mShowAnimator;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b mLoadConfigJob;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean mIsAsyncLoadingConfig;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/part/guide/NearbyProGuideDialog$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<GuideConfigItem> f253683c;

        b(List<GuideConfigItem> list) {
            this.f253683c = list;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            NearbyProGuideDialog.this.p0(position);
            if (this.f253683c.size() > position) {
                NearbyProGuideDialog.this.r0(this.f253683c.get(position).getMGuideTitle());
                NearbyProGuideDialog.this.q0(this.f253683c.get(position).getMGuideDesc());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyProGuideDialog(@NotNull NearbyProGuideContext mGuideContext, @NotNull c mGuideCallback) {
        super(mGuideContext.getMContext());
        Intrinsics.checkNotNullParameter(mGuideContext, "mGuideContext");
        Intrinsics.checkNotNullParameter(mGuideCallback, "mGuideCallback");
        this.mGuideContext = mGuideContext;
        this.mGuideCallback = mGuideCallback;
        this.mGuideConfigItemSize = 1;
        this.mIsAsyncLoadingConfig = new AtomicBoolean(false);
        i0();
        l0();
        e0();
        d0();
        f0();
    }

    private final void a0() {
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        float[] fArr = new float[2];
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        fArr[0] = view2.getMeasuredHeight();
        fArr[1] = 0.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", fArr);
        ofFloat.setDuration(300L).start();
        this.mShowAnimator = ofFloat;
    }

    private final void d0() {
        View view = this.mRootView;
        NearbyProGuideBannerIndicator nearbyProGuideBannerIndicator = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f164574t41);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.banner_layout)");
        this.mBannerLayout = (BannerLayout) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.t3z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.banner_indicator)");
        this.mBannerIndicator = (NearbyProGuideBannerIndicator) findViewById2;
        this.mBannerAdapter = new d();
        BannerLayout bannerLayout = this.mBannerLayout;
        if (bannerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            bannerLayout = null;
        }
        d dVar = this.mBannerAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerAdapter");
            dVar = null;
        }
        bannerLayout.setAdapter(dVar);
        BannerLayout bannerLayout2 = this.mBannerLayout;
        if (bannerLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            bannerLayout2 = null;
        }
        bannerLayout2.getViewPager2().setOrientation(0);
        com.tencent.mobileqq.guild.component.banner.a aVar = com.tencent.mobileqq.guild.component.banner.a.f215813a;
        BannerLayout bannerLayout3 = this.mBannerLayout;
        if (bannerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            bannerLayout3 = null;
        }
        ViewPager2 viewPager2 = bannerLayout3.getViewPager2();
        NearbyProGuideBannerIndicator nearbyProGuideBannerIndicator2 = this.mBannerIndicator;
        if (nearbyProGuideBannerIndicator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerIndicator");
        } else {
            nearbyProGuideBannerIndicator = nearbyProGuideBannerIndicator2;
        }
        aVar.a(viewPager2, nearbyProGuideBannerIndicator);
    }

    private final void e0() {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.uge);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.desc_iv)");
        this.mGuideDescTv = (TextView) findViewById;
    }

    private final void f0() {
        View view = this.mRootView;
        Button button = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.bxj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<Button>(R.id.enter_btn)");
        Button button2 = (Button) findViewById;
        this.mEnterBtn = button2;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEnterBtn");
        } else {
            button = button2;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.guide.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NearbyProGuideDialog.g0(NearbyProGuideDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(NearbyProGuideDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.nearbypro.part.guide.b bVar = com.tencent.mobileqq.nearbypro.part.guide.b.f253690a;
        Button button = this$0.mEnterBtn;
        BannerLayout bannerLayout = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEnterBtn");
            button = null;
        }
        bVar.b(button);
        if (this$0.mGuideConfigItemSize <= 0) {
            this$0.dismiss();
        } else {
            BannerLayout bannerLayout2 = this$0.mBannerLayout;
            if (bannerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
                bannerLayout2 = null;
            }
            int currentItem = bannerLayout2.getViewPager2().getCurrentItem();
            int i3 = this$0.mGuideConfigItemSize;
            int i16 = currentItem % i3;
            if (i16 == i3 - 1) {
                this$0.mHasClickEnter = true;
                this$0.dismiss();
            } else {
                BannerLayout bannerLayout3 = this$0.mBannerLayout;
                if (bannerLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
                } else {
                    bannerLayout = bannerLayout3;
                }
                bannerLayout.getViewPager2().setCurrentItem(i16 + 1);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i0() {
        View view = null;
        View inflate = LayoutInflater.from(this.mGuideContext.getMContext()).inflate(R.layout.fnb, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mGuideContext.mCont\u2026          false\n        )");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = inflate;
        }
        setContentView(view);
        setCanceledOnTouchOutside(false);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.nearbypro.part.guide.h
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                NearbyProGuideDialog.j0(NearbyProGuideDialog.this, dialogInterface);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.nearbypro.part.guide.i
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                NearbyProGuideDialog.k0(NearbyProGuideDialog.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(NearbyProGuideDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = this$0.findViewById(R.id.ugk);
        if (findViewById != null) {
            this$0.getBehavior().setPeekHeight(findViewById.getHeight());
            findViewById.getParent().getParent().requestLayout();
        }
        this$0.a0();
        com.tencent.mobileqq.nearbypro.part.guide.b bVar = com.tencent.mobileqq.nearbypro.part.guide.b.f253690a;
        View view = this$0.mRootView;
        Button button = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        bVar.d(view);
        Button button2 = this$0.mEnterBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEnterBtn");
        } else {
            button = button2;
        }
        bVar.c(button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(NearbyProGuideDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mGuideCallback.a();
        com.tencent.mobileqq.nearbypro.part.guide.b bVar = com.tencent.mobileqq.nearbypro.part.guide.b.f253690a;
        View view = this$0.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        bVar.e(view);
    }

    private final void l0() {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.jp6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.title_iv)");
        this.mGuideTitleTv = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(ViewUtils.getScreenWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(int imageWidth, int imageHeight, List<GuideConfigItem> guideItemList) {
        int collectionSizeOrDefault;
        BannerLayout bannerLayout = this.mBannerLayout;
        d dVar = null;
        if (bannerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            bannerLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = bannerLayout.getLayoutParams();
        BannerLayout bannerLayout2 = this.mBannerLayout;
        if (bannerLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            bannerLayout2 = null;
        }
        layoutParams.width = imageWidth;
        layoutParams.height = imageHeight;
        bannerLayout2.setLayoutParams(layoutParams);
        BannerLayout bannerLayout3 = this.mBannerLayout;
        if (bannerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            bannerLayout3 = null;
        }
        bannerLayout3.getViewPager2().registerOnPageChangeCallback(new b(guideItemList));
        d dVar2 = this.mBannerAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerAdapter");
        } else {
            dVar = dVar2;
        }
        List<GuideConfigItem> list = guideItemList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((GuideConfigItem) it.next()).getMGuideImageUrl());
        }
        dVar.k0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(int position) {
        String string;
        int i3 = this.mGuideConfigItemSize;
        if (i3 <= 0) {
            return;
        }
        if (position % i3 == i3 - 1) {
            string = getContext().getString(R.string.f170302ko);
        } else {
            string = getContext().getString(R.string.f170322kq);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if ((position % mGuideCo\u2026uide_next_page)\n        }");
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ((Button) view.findViewById(R.id.bxj)).setText(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(String guideDesc) {
        TextView textView = this.mGuideDescTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideDescTv");
            textView = null;
        }
        textView.setText(guideDesc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(String guideTitle) {
        TextView textView = this.mGuideTitleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideTitleTv");
            textView = null;
        }
        textView.setText(guideTitle);
    }

    @NotNull
    public final View b0() {
        TextView textView = this.mGuideTitleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuideTitleTv");
            return null;
        }
        return textView;
    }

    public final boolean c0() {
        if (!isShowing() && !this.mIsAsyncLoadingConfig.get()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Job f16;
        com.tencent.mobileqq.nearbypro.base.j.c().e("NearbyProGuideWindow", "dismiss");
        super.dismiss();
        ObjectAnimator objectAnimator = this.mShowAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadConfigJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
    }

    /* renamed from: m0, reason: from getter */
    public final boolean getMHasClickEnter() {
        return this.mHasClickEnter;
    }

    public final void onDestroy() {
        Job f16;
        com.tencent.mobileqq.nearbypro.base.j.c().e("NearbyProGuideWindow", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ObjectAnimator objectAnimator = this.mShowAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mIsAsyncLoadingConfig.set(false);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadConfigJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void showDialog() {
        if (c0()) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("NearbyProGuideWindow", "showDialog isShowing return.");
            return;
        }
        this.mHasClickEnter = false;
        this.mIsAsyncLoadingConfig.set(true);
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundResource(R.drawable.k3l);
        this.mLoadConfigJob = CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.mGuideContext.getMLifecycleOwner()), "NearbyProGuideWindowshowDialog", Boolean.FALSE, null, Boolean.TRUE, new NearbyProGuideDialog$showDialog$1(this, null), 4, null);
    }
}
