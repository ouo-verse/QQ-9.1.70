package com.tencent.biz.pubaccount.weishi.combo.msg.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import az.a;
import az.e;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.combo.msg.detail.WSMsgDetailFragment;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.view.WSXRecyclerView;
import com.tencent.biz.pubaccount.weishi.view.topnav.WSTopNavigationBar;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import xy.i;
import zy.c;
import zy.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 [2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0002:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J \u0010'\u001a\u00020\u00042\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%H\u0016J \u0010(\u001a\u00020\u00042\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001fH\u0016J\b\u0010.\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0016R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u00108R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010U\u00a8\u0006]"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/combo/msg/detail/WSMsgDetailFragment;", "Lcom/tencent/biz/pubaccount/weishi/WSBaseFragment;", "Lzy/c;", "Laz/a;", "", "initData", "initIntent", "Lxy/i;", "topBarController", "Mh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "Hh", "Kh", "Ih", "Jh", "Gh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Yc", "", "isRefresh", "isFinished", "wb", "Ljava/util/ArrayList;", "Lyy/c;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "U5", "A6", "show", "jc", "lg", "f6", "Lxy/a;", "getAdapter", "", "position", "P0", "Lcom/tencent/biz/pubaccount/weishi/view/WSXRecyclerView;", "M", "Lcom/tencent/biz/pubaccount/weishi/view/WSXRecyclerView;", "xRecyclerView", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "emptyView", "Landroid/widget/RelativeLayout;", "P", "Landroid/widget/RelativeLayout;", "failedView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "retryView", "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "topNavigationBar", ExifInterface.LATITUDE_SOUTH, "Lxy/i;", "Landroid/support/v7/widget/LinearLayoutManager;", "T", "Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager", "U", "Landroid/view/View;", "footerView", "V", "Lxy/a;", "adapter", "W", "Ljava/lang/Integer;", "subjectId", "", "X", "Ljava/lang/String;", "fromScene", "Y", "title", "<init>", "()V", "Z", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSMsgDetailFragment extends WSBaseFragment<c, a> implements c {

    /* renamed from: Z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: M, reason: from kotlin metadata */
    private WSXRecyclerView xRecyclerView;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView emptyView;

    /* renamed from: P, reason: from kotlin metadata */
    private RelativeLayout failedView;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView retryView;

    /* renamed from: R, reason: from kotlin metadata */
    private WSTopNavigationBar topNavigationBar;

    /* renamed from: S, reason: from kotlin metadata */
    private i topBarController;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayoutManager layoutManager = new LinearLayoutManager(this.C, 1, false);

    /* renamed from: U, reason: from kotlin metadata */
    private View footerView;

    /* renamed from: V, reason: from kotlin metadata */
    private xy.a adapter;

    /* renamed from: W, reason: from kotlin metadata */
    private Integer subjectId;

    /* renamed from: X, reason: from kotlin metadata */
    private String fromScene;

    /* renamed from: Y, reason: from kotlin metadata */
    private String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/combo/msg/detail/WSMsgDetailFragment$a;", "", "Lzy/g;", "params", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.combo.msg.detail.WSMsgDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(g params) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intent d16 = params.d();
            Context context = params.getContext();
            if (context instanceof Activity) {
                PublicFragmentActivity.b.a(context, d16, PublicFragmentActivity.class, WSMsgDetailFragment.class);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/pubaccount/weishi/combo/msg/detail/WSMsgDetailFragment$b", "Lcom/tencent/widget/pull2refresh/XRecyclerView$RefreshCallback;", "Lcom/tencent/widget/pull2refresh/XRecyclerView;", "recyclerView", "", "isMachineRefresh", "", "startTopRefresh", "", "reqType", "startLoadMore", "endOfRefresh", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements XRecyclerView.RefreshCallback {
        b() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
            WSXRecyclerView wSXRecyclerView = WSMsgDetailFragment.this.xRecyclerView;
            if (wSXRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
                wSXRecyclerView = null;
            }
            wSXRecyclerView.backToTopAtOnce();
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(XRecyclerView recyclerView, int reqType) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            WSMsgDetailFragment.this.getPresenter().z0(false, false);
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(XRecyclerView recyclerView, boolean isMachineRefresh) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            WSMsgDetailFragment.this.getPresenter().z0(false, true);
        }
    }

    private final void Hh() {
        Context mContext = this.C;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        xy.a aVar = new xy.a(mContext);
        this.adapter = aVar;
        aVar.setHasStableIds(true);
    }

    private final void Ih() {
        View view = null;
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.fx5, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(c\u2026shi_follow_no_more, null)");
        this.footerView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            inflate = null;
        }
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View view2 = this.footerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
        } else {
            view = view2;
        }
        ((TextView) view.findViewById(R.id.xux)).setText(R.string.x97);
    }

    private final void Jh() {
        WSXRecyclerView wSXRecyclerView = this.xRecyclerView;
        WSXRecyclerView wSXRecyclerView2 = null;
        if (wSXRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            wSXRecyclerView = null;
        }
        wSXRecyclerView.getLoadMoreLayoutHelper().setPreLoaderCount(0);
        WSXRecyclerView wSXRecyclerView3 = this.xRecyclerView;
        if (wSXRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            wSXRecyclerView3 = null;
        }
        wSXRecyclerView3.setRefreshEnable(true);
        WSXRecyclerView wSXRecyclerView4 = this.xRecyclerView;
        if (wSXRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            wSXRecyclerView4 = null;
        }
        wSXRecyclerView4.setIsAutoScrolling(true);
        WSXRecyclerView wSXRecyclerView5 = this.xRecyclerView;
        if (wSXRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            wSXRecyclerView5 = null;
        }
        RecyclerViewWithHeaderFooter recyclerView = wSXRecyclerView5.getRecyclerView();
        xy.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(this.layoutManager);
        recyclerView.setItemAnimator(null);
        WSXRecyclerView wSXRecyclerView6 = this.xRecyclerView;
        if (wSXRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
        } else {
            wSXRecyclerView2 = wSXRecyclerView6;
        }
        wSXRecyclerView2.setRefreshCallback(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(WSMsgDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.failedView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("failedView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        this$0.getPresenter().z0(true, false);
    }

    private final void Mh(i topBarController) {
        topBarController.b(new View.OnClickListener() { // from class: zy.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSMsgDetailFragment.Nh(WSMsgDetailFragment.this, view);
            }
        });
        String str = this.title;
        if (str != null) {
            topBarController.d(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(WSMsgDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBaseActivity().doOnBackPressed();
    }

    private final void initData() {
        getPresenter().z0(true, false);
    }

    private final void initIntent() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        this.subjectId = Integer.valueOf(intent.getIntExtra("key_subject_id", 0));
        this.fromScene = intent.getStringExtra("key_from_scene");
        this.title = intent.getStringExtra("key_title");
    }

    @Override // zy.c
    public void A6(ArrayList<yy.c> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        xy.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.appendList(msgList);
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Gh, reason: merged with bridge method [inline-methods] */
    public a V() {
        initIntent();
        return e.f27359a.a(this.fromScene);
    }

    @Override // zy.c
    public void P0(int position) {
        xy.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.notifyItemChanged(position);
    }

    @Override // zy.c
    public void U5(ArrayList<yy.c> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        xy.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.fillList(msgList);
    }

    @Override // zy.c
    public xy.a getAdapter() {
        xy.a aVar = this.adapter;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @Override // zy.c
    public void lg(boolean show) {
        xy.a aVar = null;
        View view = null;
        if (show) {
            xy.a aVar2 = this.adapter;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar2 = null;
            }
            View view2 = this.footerView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerView");
            } else {
                view = view2;
            }
            aVar2.addFooterView(view);
            return;
        }
        xy.a aVar3 = this.adapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            aVar = aVar3;
        }
        aVar.removeFooterView();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer num = this.subjectId;
        if (num != null) {
            getPresenter().C0(num.intValue());
        }
        getPresenter().g();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.d0t, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026detail, container, false)");
        initView(inflate);
        return inflate;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getPresenter().doOnDestroy();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        wh();
        ph(!this.L);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override // zy.c
    public void Yc() {
        f6(true);
        WSXRecyclerView wSXRecyclerView = this.xRecyclerView;
        WSXRecyclerView wSXRecyclerView2 = null;
        if (wSXRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            wSXRecyclerView = null;
        }
        wSXRecyclerView.loadMoreComplete(false, false);
        WSXRecyclerView wSXRecyclerView3 = this.xRecyclerView;
        if (wSXRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
        } else {
            wSXRecyclerView2 = wSXRecyclerView3;
        }
        wSXRecyclerView2.pullRefreshCompleted(false);
    }

    @Override // zy.c
    public void f6(boolean show) {
        RelativeLayout relativeLayout = null;
        if (show) {
            RelativeLayout relativeLayout2 = this.failedView;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("failedView");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(0);
            lg(false);
            return;
        }
        RelativeLayout relativeLayout3 = this.failedView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("failedView");
        } else {
            relativeLayout = relativeLayout3;
        }
        relativeLayout.setVisibility(8);
    }

    @Override // zy.c
    public void jc(boolean show) {
        TextView textView = null;
        if (show) {
            TextView textView2 = this.emptyView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            lg(false);
            return;
        }
        TextView textView3 = this.emptyView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    @Override // zy.c
    public void wb(boolean isRefresh, boolean isFinished) {
        WSXRecyclerView wSXRecyclerView = null;
        if (isRefresh) {
            WSXRecyclerView wSXRecyclerView2 = this.xRecyclerView;
            if (wSXRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
                wSXRecyclerView2 = null;
            }
            wSXRecyclerView2.pullRefreshCompleted(true);
        }
        WSXRecyclerView wSXRecyclerView3 = this.xRecyclerView;
        if (wSXRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
        } else {
            wSXRecyclerView = wSXRecyclerView3;
        }
        wSXRecyclerView.loadMoreComplete(true, !isFinished);
    }

    private final void Kh(View rootView) {
        View findViewById = rootView.findViewById(R.id.p6r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.top_navigation_bar)");
        WSTopNavigationBar wSTopNavigationBar = (WSTopNavigationBar) findViewById;
        this.topNavigationBar = wSTopNavigationBar;
        WSTopNavigationBar wSTopNavigationBar2 = null;
        if (this.L) {
            if (wSTopNavigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topNavigationBar");
                wSTopNavigationBar = null;
            }
            wSTopNavigationBar.setTopBarStyle(2, true, false);
        } else {
            if (wSTopNavigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topNavigationBar");
                wSTopNavigationBar = null;
            }
            wSTopNavigationBar.setTopBarStyle(1, true, false);
        }
        WSTopNavigationBar wSTopNavigationBar3 = this.topNavigationBar;
        if (wSTopNavigationBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topNavigationBar");
        } else {
            wSTopNavigationBar2 = wSTopNavigationBar3;
        }
        i iVar = new i(wSTopNavigationBar2);
        this.topBarController = iVar;
        Mh(iVar);
    }

    private final void initView(View rootView) {
        View findViewById = rootView.findViewById(R.id.f163266p64);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_msg_detail)");
        this.xRecyclerView = (WSXRecyclerView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.p7k);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_msg_detail_empty)");
        this.emptyView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.p5y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rl_msg_detail_failed)");
        this.failedView = (RelativeLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f163271p74);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tv_click_retry)");
        this.retryView = (TextView) findViewById4;
        GradientDrawable a16 = ba.a(this.C.getResources().getColor(R.color.f78059), ba.f81739n);
        Intrinsics.checkNotNullExpressionValue(a16, "createRoundRectangleDraw\u2026IUtil.PIX_20DP.toFloat())");
        TextView textView = this.retryView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryView");
            textView = null;
        }
        com.tencent.mobileqq.mvvm.g.a(textView, a16);
        TextView textView3 = this.retryView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryView");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: zy.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSMsgDetailFragment.Lh(WSMsgDetailFragment.this, view);
            }
        });
        Ih();
        Kh(rootView);
        Hh();
        Jh();
    }
}
