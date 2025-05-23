package com.tencent.sqshow.zootopia.c2c.photograph;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.activity.ZplanHostActivity;
import com.tencent.sqshow.zootopia.c2c.ZootopiaC2CAvatarFragment;
import com.tencent.sqshow.zootopia.c2c.item.ZootopiaBaseC2CFloatFragment;
import com.tencent.sqshow.zootopia.c2c.item.ZootopiaC2CAvatarRecyclerView;
import com.tencent.sqshow.zootopia.c2c.photograph.c;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.state.report.SquareReportConst;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lo2.ah;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/photograph/ZootopiaPhotographFragment;", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaBaseC2CFloatFragment;", "Lcom/tencent/sqshow/zootopia/c2c/photograph/c$b;", "Landroid/view/View;", "view", "", "Sh", "Th", "initView", "", "isFolded", "Hh", "", "getSubSource", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "data", "", "position", ah.f415119g0, "doLoadMore", "onLoadMoreComplete", "Lcom/tencent/sqshow/zootopia/c2c/photograph/c;", "W", "Lcom/tencent/sqshow/zootopia/c2c/photograph/c;", "foldedAdapter", "X", "unfoldedAdapter", "Lcom/tencent/sqshow/zootopia/c2c/photograph/h;", "Y", "Lkotlin/Lazy;", "Rh", "()Lcom/tencent/sqshow/zootopia/c2c/photograph/h;", "vm", "Z", "closeWhenJumpToPreView", "<init>", "()V", "a0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaPhotographFragment extends ZootopiaBaseC2CFloatFragment implements c.b {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: W, reason: from kotlin metadata */
    private c foldedAdapter;

    /* renamed from: X, reason: from kotlin metadata */
    private c unfoldedAdapter;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean closeWhenJumpToPreView;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/photograph/ZootopiaPhotographFragment$a;", "", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "source", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/sqshow/zootopia/c2c/photograph/ZootopiaPhotographFragment;", "a", "", "DOWNLOAD_URL_HOST", "Ljava/lang/String;", "EXTRA_CLOSE_WHEN_JUMP_TO_PREVIEW_BOOLEAN", "EXTRA_FIXED_ROLE_SERIAL", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.c2c.photograph.ZootopiaPhotographFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaPhotographFragment a(FragmentSource source, Bundle bundle) {
            Intrinsics.checkNotNullParameter(source, "source");
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(ZootopiaSource.KEY_FRAGMENT_SOURCE, source);
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            ZootopiaPhotographFragment zootopiaPhotographFragment = new ZootopiaPhotographFragment();
            zootopiaPhotographFragment.setArguments(bundle2);
            return zootopiaPhotographFragment;
        }

        Companion() {
        }
    }

    public ZootopiaPhotographFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.sqshow.zootopia.c2c.photograph.ZootopiaPhotographFragment$vm$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/c2c/photograph/ZootopiaPhotographFragment$vm$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ZootopiaPhotographFragment f370151a;

                a(ZootopiaPhotographFragment zootopiaPhotographFragment) {
                    this.f370151a = zootopiaPhotographFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(Class<T> modelClass) {
                    ZootopiaSource Dh;
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    Dh = this.f370151a.Dh();
                    return new h(new g(Dh));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                ZootopiaPhotographFragment zootopiaPhotographFragment = ZootopiaPhotographFragment.this;
                ViewModel invoke = com.tencent.mobileqq.mvvm.h.b(zootopiaPhotographFragment, new a(zootopiaPhotographFragment)).get(h.class);
                Intrinsics.checkNotNullExpressionValue(invoke, "invoke");
                return (h) invoke;
            }
        });
        this.vm = lazy;
    }

    private final h Rh() {
        return (h) this.vm.getValue();
    }

    private final void Sh(View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        c cVar = new c(context, 0);
        cVar.C(this);
        cVar.fillList(Rh().N1());
        cVar.p(getFooterView());
        this.foldedAdapter = cVar;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        c cVar2 = new c(context2, 1);
        cVar2.C(this);
        cVar2.fillList(Rh().N1());
        cVar2.p(getFooterView());
        this.unfoldedAdapter = cVar2;
    }

    private final void Th() {
        Rh().O1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.c2c.photograph.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaPhotographFragment.Uh(ZootopiaPhotographFragment.this, (List) obj);
            }
        });
        Rh().M1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.c2c.photograph.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaPhotographFragment.Vh(ZootopiaPhotographFragment.this, (Boolean) obj);
            }
        });
        Rh().L1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.c2c.photograph.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaPhotographFragment.Wh(ZootopiaPhotographFragment.this, (ErrorMessage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(ZootopiaPhotographFragment this$0, List it) {
        ZootopiaLoadFailView zootopiaLoadFailView;
        ShimmerLinearLayout shimmerLinearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n74.d viewBinding = this$0.getViewBinding();
        if (viewBinding != null && (shimmerLinearLayout = viewBinding.f419193c) != null) {
            shimmerLinearLayout.d();
        }
        if (it.isEmpty()) {
            n74.d viewBinding2 = this$0.getViewBinding();
            if (viewBinding2 == null || (zootopiaLoadFailView = viewBinding2.f419192b) == null) {
                return;
            }
            zootopiaLoadFailView.b();
            zootopiaLoadFailView.setVisibility(0);
            return;
        }
        c cVar = this$0.foldedAdapter;
        if (cVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cVar.fillList(it);
        }
        c cVar2 = this$0.unfoldedAdapter;
        if (cVar2 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cVar2.fillList(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(ZootopiaPhotographFragment this$0, Boolean it) {
        ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n74.d viewBinding = this$0.getViewBinding();
        if (viewBinding == null || (zootopiaC2CAvatarRecyclerView = viewBinding.f419194d) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zootopiaC2CAvatarRecyclerView.d(true, it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r0 != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Wh(ZootopiaPhotographFragment this$0, ErrorMessage errorMessage) {
        ZootopiaLoadFailView zootopiaLoadFailView;
        ZootopiaLoadFailView zootopiaLoadFailView2;
        ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView;
        boolean z16;
        Object first;
        ShimmerLinearLayout shimmerLinearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n74.d viewBinding = this$0.getViewBinding();
        if (viewBinding != null && (shimmerLinearLayout = viewBinding.f419193c) != null) {
            shimmerLinearLayout.d();
        }
        List<ZPlanTemplate> value = this$0.Rh().O1().getValue();
        TextView textView = null;
        if (!(value != null && value.isEmpty())) {
            List<ZPlanTemplate> value2 = this$0.Rh().O1().getValue();
            if (value2 != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value2);
                ZPlanTemplate zPlanTemplate = (ZPlanTemplate) first;
                if (zPlanTemplate != null && zPlanTemplate.getId() == -1) {
                    z16 = true;
                }
            }
            z16 = false;
        }
        n74.d viewBinding2 = this$0.getViewBinding();
        if (viewBinding2 != null && (zootopiaLoadFailView = viewBinding2.f419192b) != null) {
            zootopiaLoadFailView.c();
        }
        n74.d viewBinding3 = this$0.getViewBinding();
        ZootopiaLoadFailView zootopiaLoadFailView3 = viewBinding3 != null ? viewBinding3.f419192b : null;
        if (zootopiaLoadFailView3 != null) {
            zootopiaLoadFailView3.setVisibility(0);
        }
        n74.d viewBinding4 = this$0.getViewBinding();
        if (viewBinding4 != null && (zootopiaC2CAvatarRecyclerView = viewBinding4.f419194d) != null) {
            zootopiaC2CAvatarRecyclerView.d(false, true);
        }
        if (errorMessage.getErrorCode() == -88) {
            n74.d viewBinding5 = this$0.getViewBinding();
            if (viewBinding5 != null && (zootopiaLoadFailView2 = viewBinding5.f419192b) != null) {
                textView = (TextView) zootopiaLoadFailView2.findViewById(R.id.qtx);
            }
            if (textView == null) {
                return;
            }
            textView.setText("\u6682\u65f6\u6ca1\u6709\u6570\u636e\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }
    }

    @Override // com.tencent.sqshow.zootopia.c2c.photograph.c.b
    public void ah(View view, ZPlanTemplate data, int position) {
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        ZplanHostActivity.Companion companion = ZplanHostActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Bundle bundle = new Bundle();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        bundle.putSerializable("template", data);
        Bundle arguments = getArguments();
        bundle.putSerializable("extra_fixed_role", arguments != null ? arguments.getSerializable("extra_fixed_role") : null);
        bundle.putInt("biz", 1);
        bundle.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.ProfileEntry, ZootopiaSource.SUB_SOURCE_PROFILE_VISITOR, null, 4, null));
        Unit unit = Unit.INSTANCE;
        ZplanHostActivity.Companion.c(companion, requireContext, com.tencent.sqshow.zootopia.samestyle.a.class, bundle, 0, 8, null);
        if (this.closeWhenJumpToPreView) {
            Fragment parentFragment = getParentFragment();
            ZootopiaC2CAvatarFragment zootopiaC2CAvatarFragment = parentFragment instanceof ZootopiaC2CAvatarFragment ? (ZootopiaC2CAvatarFragment) parentFragment : null;
            if (zootopiaC2CAvatarFragment != null) {
                zootopiaC2CAvatarFragment.dismiss();
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.c2c.item.ZootopiaC2CAvatarRecyclerView.d
    public void doLoadMore() {
        h.Q1(Rh(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_PHOTOGRAPH;
    }

    @Override // com.tencent.sqshow.zootopia.c2c.item.ZootopiaBaseC2CFloatFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Sh(view);
        n74.d viewBinding = getViewBinding();
        ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView = viewBinding != null ? viewBinding.f419194d : null;
        if (zootopiaC2CAvatarRecyclerView != null) {
            zootopiaC2CAvatarRecyclerView.setAdapter(this.foldedAdapter);
        }
        Rh().P1(true);
        Th();
        Bundle arguments = getArguments();
        this.closeWhenJumpToPreView = arguments != null ? arguments.getBoolean("extra_close_when_jump_to_preview", false) : false;
    }

    @Override // com.tencent.sqshow.zootopia.c2c.item.ZootopiaBaseC2CFloatFragment
    public void Hh(boolean isFolded) {
        ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView;
        if (isFolded) {
            n74.d viewBinding = getViewBinding();
            zootopiaC2CAvatarRecyclerView = viewBinding != null ? viewBinding.f419194d : null;
            if (zootopiaC2CAvatarRecyclerView == null) {
                return;
            }
            zootopiaC2CAvatarRecyclerView.setAdapter(this.foldedAdapter);
            return;
        }
        n74.d viewBinding2 = getViewBinding();
        zootopiaC2CAvatarRecyclerView = viewBinding2 != null ? viewBinding2.f419194d : null;
        if (zootopiaC2CAvatarRecyclerView == null) {
            return;
        }
        zootopiaC2CAvatarRecyclerView.setAdapter(this.unfoldedAdapter);
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public void onLoadMoreComplete() {
    }
}
