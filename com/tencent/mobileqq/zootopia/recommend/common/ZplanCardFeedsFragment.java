package com.tencent.mobileqq.zootopia.recommend.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u0005H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/zootopia/recommend/common/ZplanCardFeedsFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Ldb4/a;", "Lk84/a;", "Landroid/view/View$OnClickListener;", "", "Lh", "initViewModel", "Lcom/tencent/mobileqq/zootopia/recommend/common/ZplanCardFeedsListView;", "cardFeedsListView", "Ih", "Mh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "status", "I4", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getSubSource", "", "onBackPressedEvent", "ne", "Lcom/tencent/common/app/AppInterface;", "N", "Lcom/tencent/common/app/AppInterface;", "app", "Lgd3/c;", "P", "Lgd3/c;", "mViewModel", "Lfi3/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfi3/f;", "getBinding", "()Lfi3/f;", "setBinding", "(Lfi3/f;)V", "binding", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "pageParam", ExifInterface.LATITUDE_SOUTH, VasWebviewConstants.KEY_PAGE_TITLE, "Lid3/d;", "T", "Lid3/d;", "dtReporter", "U", "dtReportHelper", "Lcom/tencent/mobileqq/zootopia/utils/e;", "V", "Lcom/tencent/mobileqq/zootopia/utils/e;", "fastClickUtils", "Loa4/a;", "W", "Lkotlin/Lazy;", "Jh", "()Loa4/a;", "mapResViewModel", "<init>", "()V", "X", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ZplanCardFeedsFragment extends ZootopiaBaseFragment implements db4.a, k84.a, View.OnClickListener {

    /* renamed from: X, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: N, reason: from kotlin metadata */
    private AppInterface app;

    /* renamed from: P, reason: from kotlin metadata */
    private gd3.c mViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private fi3.f binding;

    /* renamed from: R, reason: from kotlin metadata */
    private String pageParam = "";

    /* renamed from: S, reason: from kotlin metadata */
    private String pageTitle = "";

    /* renamed from: T, reason: from kotlin metadata */
    private final id3.d dtReporter = new id3.d(null, 1, null);

    /* renamed from: U, reason: from kotlin metadata */
    private final id3.d dtReportHelper = new id3.d(null, 1, null);

    /* renamed from: V, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.utils.e fastClickUtils = new com.tencent.mobileqq.zootopia.utils.e();

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy mapResViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/recommend/common/ZplanCardFeedsFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "fromSource", "Landroid/os/Bundle;", "bundle", "", "a", "", "EXTRA_KEY_PAGE_PARAM", "Ljava/lang/String;", "EXTRA_KEY_TITLE", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.recommend.common.ZplanCardFeedsFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, ZootopiaSource fromSource, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fromSource, "fromSource");
            ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, context, ZplanCardFeedsFragment.class, fromSource, bundle, false, 16, null);
        }

        Companion() {
        }
    }

    public ZplanCardFeedsFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.mobileqq.zootopia.recommend.common.ZplanCardFeedsFragment$mapResViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = h.a(ZplanCardFeedsFragment.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResViewModel = lazy;
    }

    private final void Ih(ZplanCardFeedsListView cardFeedsListView) {
        g gVar = new g(Jh(), Ch());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        gVar.j(viewLifecycleOwner, getContext(), this.mViewModel, cardFeedsListView, this, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.recommend.common.ZplanCardFeedsFragment$bindObservers$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final oa4.a Jh() {
        return (oa4.a) this.mapResViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(ZplanCardFeedsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mh();
    }

    private final void Lh() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("pageParam") : null;
        if (string == null) {
            string = "";
        }
        this.pageParam = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("title") : null;
        String str = string2 != null ? string2 : "";
        this.pageTitle = str;
        QLog.i("ZplanCardFeedsFragment", 1, "readArguments pageParam=" + this.pageParam + " pageTitle = " + str + " - " + getArguments());
    }

    private final void Mh() {
        gd3.c cVar = this.mViewModel;
        if (cVar != null) {
            gd3.c.U1(cVar, 0, 1, null);
        }
    }

    private final void initViewModel() {
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            return;
        }
        gd3.c cVar = (gd3.c) new ViewModelProvider(this, new gd3.a(appInterface, Ch())).get(gd3.c.class);
        this.mViewModel = cVar;
        if (cVar != null) {
            cVar.S1(this.pageParam);
        }
    }

    @Override // db4.a
    public void I4(int status) {
        QLog.i("ZplanCardFeedsFragment", 1, "updateCardListStatus status = " + status);
        fi3.f fVar = this.binding;
        if (fVar != null) {
            if (status == 1) {
                fVar.f399261h.setVisibility(0);
                fVar.f399260g.setVisibility(8);
                fVar.f399259f.setVisibility(8);
                return;
            }
            if (status == 2) {
                fVar.f399260g.setVisibility(0);
                fVar.f399261h.setVisibility(8);
                fVar.f399259f.setVisibility(8);
            } else if (status == 3) {
                fVar.f399260g.setVisibility(0);
                fVar.f399261h.setVisibility(8);
                fVar.f399259f.setVisibility(8);
            } else {
                if (status != 4) {
                    return;
                }
                fVar.f399259f.setVisibility(0);
                fVar.f399261h.setVisibility(8);
                fVar.f399260g.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_FEEDS_CARD_LIST;
    }

    @Override // k84.a
    public void ne() {
        Mh();
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.plc) {
            onBackPressedEvent();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.app = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        b.INSTANCE.a();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity activity;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        Lh();
        fi3.f g16 = fi3.f.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null && (frameLayout = g16.f399258e) != null) {
            frameLayout.setPadding(0, Bh(), 0, 0);
        }
        fi3.f fVar = this.binding;
        if (fVar != null && (activity = getActivity()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Ch()));
            id3.d dVar = this.dtReporter;
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            FrameLayout root = fVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            dVar.j(activity, root, "pg_zplan_card_" + this.pageParam, hashMap);
        }
        fi3.f fVar2 = this.binding;
        if (fVar2 != null) {
            return fVar2.getRoot();
        }
        return null;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache(activity, ZplanCacheComponentType.PARENT_PAGE_HANDLER, this);
        }
        fi3.f fVar = this.binding;
        if (fVar != null) {
            FragmentActivity ctx = getActivity();
            if (ctx != null) {
                IZplanCacheApi iZplanCacheApi = (IZplanCacheApi) QRoute.api(IZplanCacheApi.class);
                Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
                ZplanCacheComponentType zplanCacheComponentType = ZplanCacheComponentType.CARD_LIST_VIEW;
                ZplanCardFeedsListView zplanCardFeedsListView = fVar.f399259f;
                Intrinsics.checkNotNullExpressionValue(zplanCardFeedsListView, "it.zootopiaFeedsListView");
                iZplanCacheApi.saveCache(ctx, zplanCacheComponentType, zplanCardFeedsListView);
            }
            fVar.f399256c.setOnClickListener(this);
            fVar.f399257d.setText(this.pageTitle);
            I4(1);
            fVar.f399260g.getBtnNetworkError().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.recommend.common.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZplanCardFeedsFragment.Kh(ZplanCardFeedsFragment.this, view2);
                }
            });
            initViewModel();
            ZplanCardFeedsListView zplanCardFeedsListView2 = fVar.f399259f;
            Intrinsics.checkNotNullExpressionValue(zplanCardFeedsListView2, "it.zootopiaFeedsListView");
            Ih(zplanCardFeedsListView2);
        }
        Mh();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }
}
