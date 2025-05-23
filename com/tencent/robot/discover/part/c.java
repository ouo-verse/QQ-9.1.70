package com.tencent.robot.discover.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000 :*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H&R\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/robot/discover/part/c;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "V", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", Constants.BASE_IN_APP_NAME, "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "x9", "", "enable", "z9", "show", "I9", "J9", ReportConstant.COSTREPORT_PREFIX, "Ljava/lang/Class;", "F9", "d", "Landroidx/recyclerview/widget/RecyclerView;", "D9", "()Landroidx/recyclerview/widget/RecyclerView;", "H9", "(Landroidx/recyclerview/widget/RecyclerView;)V", "refreshRecyclerView", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "A9", "()Landroid/widget/RelativeLayout;", "G9", "(Landroid/widget/RelativeLayout;)V", "loadingRl", "Li34/b;", "f", "Li34/b;", "B9", "()Li34/b;", "setMAdapter", "(Li34/b;)V", "mAdapter", tl.h.F, "Lcom/tencent/biz/richframework/part/BaseViewModel;", "C9", "()Lcom/tencent/biz/richframework/part/BaseViewModel;", "setMViewMode", "(Lcom/tencent/biz/richframework/part/BaseViewModel;)V", "mViewMode", "i", "Z", "loadMoreDataEnable", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class c<V extends BaseViewModel> extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public RecyclerView refreshRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout loadingRl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i34.b mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private V mViewMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean loadMoreDataEnable = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/discover/part/c$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<V> f367568d;

        b(c<V> cVar) {
            this.f367568d = cVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                this.f367568d.x9(recyclerView);
            }
        }
    }

    private final void D3() {
        View findViewById = getPartRootView().findViewById(R.id.f769242z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.robot_loading_rl)");
        G9((RelativeLayout) findViewById);
        A9().setVisibility(8);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167841e51, (ViewGroup) null);
        ViewUtils viewUtils = ViewUtils.f352270a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(viewUtils.b(100), viewUtils.b(100));
        layoutParams.addRule(13);
        inflate.setLayoutParams(layoutParams);
        A9().addView(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ysu);
        TextView textView = (TextView) inflate.findViewById(R.id.yt9);
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 1));
        textView.setText(HardCodeUtil.qqStr(R.string.f222296d5));
    }

    private final void E9() {
        i34.b bVar = new i34.b();
        bVar.setHasStableIds(true);
        this.mAdapter = bVar;
        D9().setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.mAdapter}));
    }

    private final void initViewModel() {
        this.mViewMode = (V) getViewModel(F9());
    }

    @NotNull
    public final RelativeLayout A9() {
        RelativeLayout relativeLayout = this.loadingRl;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingRl");
        return null;
    }

    @Nullable
    /* renamed from: B9, reason: from getter */
    public final i34.b getMAdapter() {
        return this.mAdapter;
    }

    @Nullable
    public final V C9() {
        return this.mViewMode;
    }

    @NotNull
    public final RecyclerView D9() {
        RecyclerView recyclerView = this.refreshRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refreshRecyclerView");
        return null;
    }

    @NotNull
    public abstract Class<V> F9();

    public final void G9(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.loadingRl = relativeLayout;
    }

    public final void H9(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.refreshRecyclerView = recyclerView;
    }

    public void I9(boolean show) {
        if (show) {
            A9().setVisibility(0);
            D9().setVisibility(8);
        } else {
            A9().setVisibility(8);
            D9().setVisibility(0);
        }
    }

    public final void J9() {
        QQToast.makeText(getContext(), 1, R.string.f222306d6, 0).show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f767142e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.robot_feed_content_rv)");
        H9((RecyclerView) findViewById);
        D9().setItemAnimator(null);
        D9().setLayoutManager(new SafeLinearLayoutManager(getContext()));
        D3();
        E9();
        initViewModel();
        D9().addOnScrollListener(new b(this));
    }

    public abstract void s();

    public final void x9(@NotNull RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        QLog.i("BaseRobotFeedContentPart", 4, "checkCanLoadMore loadMoreDataEnable=" + this.loadMoreDataEnable);
        if (this.loadMoreDataEnable) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null) {
                i3 = linearLayoutManager.findLastVisibleItemPosition();
            } else {
                i3 = 0;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                i16 = adapter.getItemCount();
            } else {
                i16 = 0;
            }
            QLog.i("BaseRobotFeedContentPart", 4, "onScrollStateChangedlastVisibleItemPosition=" + i3 + " itemCount=" + i16);
            if (i3 >= i16 - 2) {
                this.loadMoreDataEnable = false;
                s();
            }
        }
    }

    public final void z9(boolean enable) {
        QLog.i("BaseRobotFeedContentPart", 4, "enableLoadMore enable=" + enable);
        this.loadMoreDataEnable = enable;
    }
}
