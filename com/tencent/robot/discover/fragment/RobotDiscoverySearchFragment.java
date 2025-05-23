package com.tencent.robot.discover.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.SearchTransAnimUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.discover.part.RobotSearchContentPart;
import com.tencent.robot.discover.part.RobotTroopObserverPart;
import com.tencent.robot.discover.part.m;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\f*\u0001 \u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/discover/fragment/RobotDiscoverySearchFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Bh", "Ljava/lang/Runnable;", "afterAnimationRunnable", OcrConfig.CHINESE, "vh", "wh", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "Landroid/view/View;", "fakeNavBar", "resultContainer", "Ah", "Dh", "", "needImmersive", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "overrideFinish", "onFinish", "com/tencent/robot/discover/fragment/RobotDiscoverySearchFragment$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/discover/fragment/RobotDiscoverySearchFragment$b;", "mBinding", "D", "Z", "mHasPerformedEnterAnimation", "<init>", "()V", "E", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotDiscoverySearchFragment extends QPublicBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static SoftReference<Bitmap> F;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mBinding = new b();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mHasPerformedEnterAnimation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/discover/fragment/RobotDiscoverySearchFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "args", "Landroid/graphics/Bitmap;", "fakeNavBarImage", "", "a", "", "RESULT_CONTAINER_ANIM_END_ALPHA", UserInfo.SEX_FEMALE, "RESULT_CONTAINER_ANIM_START_ALPHA", "", "SOFT_INPUT_DELAY_SHOW_TIME_MILLS", "J", "", "TAG", "Ljava/lang/String;", "Ljava/lang/ref/SoftReference;", "cachedNavBarImage", "Ljava/lang/ref/SoftReference;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discover.fragment.RobotDiscoverySearchFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Bundle args, @Nullable Bitmap fakeNavBarImage) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(args, "args");
            if (fakeNavBarImage != null) {
                Companion companion = RobotDiscoverySearchFragment.INSTANCE;
                RobotDiscoverySearchFragment.F = new SoftReference(fakeNavBarImage);
            }
            Intent intent = new Intent();
            intent.putExtras(args);
            QPublicFragmentActivity.start(context, intent, RobotDiscoverySearchFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0016"}, d2 = {"com/tencent/robot/discover/fragment/RobotDiscoverySearchFragment$b", "", "Landroid/view/View;", "a", "Landroid/view/View;", "c", "()Landroid/view/View;", "g", "(Landroid/view/View;)V", "root", "b", "e", "fakeNavBar", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "d", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar;", h.F, "(Lcom/tencent/mobileqq/widget/search/QUISearchBar;)V", "searchBar", "f", "resultContainer", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public View root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public View fakeNavBar;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public QUISearchBar searchBar;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public View resultContainer;

        b() {
        }

        @NotNull
        public final View a() {
            View view = this.fakeNavBar;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("fakeNavBar");
            return null;
        }

        @NotNull
        public final View b() {
            View view = this.resultContainer;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("resultContainer");
            return null;
        }

        @NotNull
        public final View c() {
            View view = this.root;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        @NotNull
        public final QUISearchBar d() {
            QUISearchBar qUISearchBar = this.searchBar;
            if (qUISearchBar != null) {
                return qUISearchBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            return null;
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.fakeNavBar = view;
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.resultContainer = view;
        }

        public final void g(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.root = view;
        }

        public final void h(@NotNull QUISearchBar qUISearchBar) {
            Intrinsics.checkNotNullParameter(qUISearchBar, "<set-?>");
            this.searchBar = qUISearchBar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/discover/fragment/RobotDiscoverySearchFragment$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f367536e;

        c(Runnable runnable) {
            this.f367536e = runnable;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            RobotDiscoverySearchFragment.this.mBinding.c().getViewTreeObserver().removeOnPreDrawListener(this);
            RobotDiscoverySearchFragment.this.wh(this.f367536e);
            return false;
        }
    }

    private final void Ah(QUISearchBar searchBar, View fakeNavBar, View resultContainer, Runnable afterAnimationRunnable) {
        float height = fakeNavBar.getHeight();
        resultContainer.animate().alpha(0.0f).setDuration(250L).start();
        fakeNavBar.animate().translationY(0.0f).setDuration(250L).start();
        searchBar.animate().translationY(height).setDuration(250L).start();
        SearchTransAnimUtil.doAnimFromCurUITrans(searchBar, 1, afterAnimationRunnable);
    }

    private final void Bh() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.robot.discover.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                RobotDiscoverySearchFragment.Ch(RobotDiscoverySearchFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(RobotDiscoverySearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QuickPinyinEditText inputWidget = this$0.mBinding.d().getInputWidget();
        inputWidget.requestFocus();
        InputMethodUtil.show(inputWidget);
        inputWidget.setCursorVisible(true);
    }

    private final void Dh() {
        FragmentActivity activity = getActivity();
        if (activity instanceof QPublicFragmentActivity) {
            ((QPublicFragmentActivity) activity).superFinish();
        } else {
            QLog.e("RobotDiscoverySearchFragment", 1, "superFinish| activity isn't QPublicFragmentActivity");
        }
    }

    private final void vh() {
        int statusBarHeight = ViewUtils.getStatusBarHeight(getContext());
        b bVar = this.mBinding;
        bVar.d().setTranslationY(statusBarHeight);
        bVar.a().setVisibility(8);
        View b16 = bVar.b();
        ViewGroup.LayoutParams layoutParams = b16.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = statusBarHeight + getResources().getDimensionPixelSize(R.dimen.c_i);
            b16.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(Runnable afterAnimationRunnable) {
        float height = this.mBinding.a().getHeight();
        int statusBarHeight = ViewUtils.getStatusBarHeight(getContext());
        this.mBinding.d().animate().translationYBy(statusBarHeight - height).setDuration(250L).start();
        this.mBinding.a().animate().translationY(-height).setDuration(250L).start();
        this.mBinding.b().animate().alpha(1.0f).setDuration(250L).start();
        View b16 = this.mBinding.b();
        ViewGroup.LayoutParams layoutParams = b16.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = this.mBinding.d().getHeight() + statusBarHeight;
            b16.setLayoutParams(layoutParams2);
            SearchTransAnimUtil.doAnimToCurUITrans(this.mBinding.d(), 1, afterAnimationRunnable);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(RobotDiscoverySearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("RobotDiscoverySearchFragment", 4, "afterAnim");
        this$0.Bh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(RobotDiscoverySearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh();
    }

    private final void zh(Runnable afterAnimationRunnable) {
        Bitmap bitmap;
        SoftReference<Bitmap> softReference = F;
        if (softReference != null) {
            bitmap = softReference.get();
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            vh();
            if (afterAnimationRunnable != null) {
                afterAnimationRunnable.run();
                return;
            }
            return;
        }
        this.mHasPerformedEnterAnimation = true;
        View a16 = this.mBinding.a();
        a16.setBackground(new BitmapDrawable(bitmap));
        ViewGroup.LayoutParams layoutParams = a16.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = bitmap.getWidth();
            layoutParams2.height = bitmap.getHeight();
            a16.setLayoutParams(layoutParams2);
            a16.setY(0.0f);
            this.mBinding.b().setAlpha(0.0f);
            this.mBinding.d().setTranslationY(bitmap.getHeight());
            this.mBinding.c().getViewTreeObserver().addOnPreDrawListener(new c(afterAnimationRunnable));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new m(), new RobotSearchContentPart(R.id.f7659423, 0, 2, null), new RobotTroopObserverPart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169071ho3;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        F = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        b bVar = this.mBinding;
        bVar.g(contentView);
        View findViewById = contentView.findViewById(R.id.uzg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.fake_nav_bar)");
        bVar.e(findViewById);
        View findViewById2 = contentView.findViewById(R.id.f765541z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026d.robot_discovery_search)");
        bVar.h((QUISearchBar) findViewById2);
        View findViewById3 = contentView.findViewById(R.id.f7659423);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById\u2026very_search_result_frame)");
        bVar.f(findViewById3);
        Bh();
        zh(new Runnable() { // from class: com.tencent.robot.discover.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotDiscoverySearchFragment.xh(RobotDiscoverySearchFragment.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        InputMethodUtil.hide(this.mBinding.d().getInputWidget());
        Part part = this.mPartManager.getPart(m.class.getName());
        if (part != null) {
            part.handleBroadcastMessage("msg_remove_text_watcher", null);
        }
        if (this.mHasPerformedEnterAnimation) {
            Ah(this.mBinding.d(), this.mBinding.a(), this.mBinding.b(), new Runnable() { // from class: com.tencent.robot.discover.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    RobotDiscoverySearchFragment.yh(RobotDiscoverySearchFragment.this);
                }
            });
            this.mHasPerformedEnterAnimation = false;
            return true;
        }
        Dh();
        return true;
    }
}
