package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSWorkSuggestionsPart;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.FragmentPartProvider;
import com.tencent.biz.richframework.part.IPartFragmentHost;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e40.QFSWorkSuggestionsData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001]B\u0007\u00a2\u0006\u0004\bZ\u0010[J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\f\u0010\b\u001a\u00020\u0005*\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u001eR.\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'RV\u00105\u001a6\u0012\u0013\u0012\u00110*\u00a2\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0005\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010<\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010D\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010X\u00a8\u0006^"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/QFSWorkSuggestionsFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/biz/richframework/part/IPartFragmentHost;", "Le40/r;", "data", "", "Jh", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Ch", "Gh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Ah", "", "Bh", "", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "getReportBean", "()Ljava/util/Map;", "Lh", "(Ljava/util/Map;)V", "reportBean", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "which", WadlProxyConsts.EXTRA_DATA, "D", "Lkotlin/jvm/functions/Function2;", "getOnSelect", "()Lkotlin/jvm/functions/Function2;", "setOnSelect", "(Lkotlin/jvm/functions/Function2;)V", "onSelect", "E", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "Ih", "(Ljava/lang/String;)V", "feedId", "", UserInfo.SEX_FEMALE, "J", "getCreatTime", "()J", "Hh", "(J)V", "creatTime", "G", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "lookMoreView", "I", "Landroid/view/View;", "closeButton", "Landroidx/core/widget/NestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "scrollView", "Lr70/c;", "K", "Lr70/c;", "vm", "Landroidx/fragment/app/Fragment;", "getHostFragment", "()Landroidx/fragment/app/Fragment;", "hostFragment", "<init>", "()V", "L", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSWorkSuggestionsFragment extends ReportAndroidXDialogFragment implements IPartFragmentHost {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function2<? super Integer, ? super Bundle, Unit> onSelect;

    /* renamed from: F, reason: from kotlin metadata */
    private long creatTime;

    /* renamed from: G, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView lookMoreView;

    /* renamed from: I, reason: from kotlin metadata */
    private View closeButton;

    /* renamed from: J, reason: from kotlin metadata */
    private NestedScrollView scrollView;

    /* renamed from: K, reason: from kotlin metadata */
    private r70.c vm;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Map<String, Object> reportBean = new LinkedHashMap();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String feedId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/QFSWorkSuggestionsFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "fm", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/immersive/QFSWorkSuggestionsFragment;", "", "Lkotlin/ExtensionFunctionType;", "init", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.QFSWorkSuggestionsFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull FragmentManager fm5, @NotNull Function1<? super QFSWorkSuggestionsFragment, Unit> init) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(init, "init");
            try {
                QFSWorkSuggestionsFragment qFSWorkSuggestionsFragment = new QFSWorkSuggestionsFragment();
                init.invoke(qFSWorkSuggestionsFragment);
                qFSWorkSuggestionsFragment.show(fm5, "QFSWorkSuggestionsFragment");
                return true;
            } catch (Exception e16) {
                QLog.e("QFSWorkSuggestionsFragment", 1, "show fragment error ", e16);
                return false;
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/QFSWorkSuggestionsFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f84711d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSWorkSuggestionsFragment f84712e;

        b(QUSHalfScreenFloatingView qUSHalfScreenFloatingView, QFSWorkSuggestionsFragment qFSWorkSuggestionsFragment) {
            this.f84711d = qUSHalfScreenFloatingView;
            this.f84712e = qFSWorkSuggestionsFragment;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            NestedScrollView nestedScrollView = this.f84712e.scrollView;
            if (nestedScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                nestedScrollView = null;
            }
            return nestedScrollView.canScrollVertically(-1);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            NestedScrollView nestedScrollView = this.f84712e.scrollView;
            if (nestedScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                nestedScrollView = null;
            }
            return nestedScrollView.canScrollVertically(1);
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57179d() {
            TextView textView = null;
            View inflate = LayoutInflater.from(this.f84711d.getContext()).inflate(R.layout.f168765gu0, (ViewGroup) null);
            QFSWorkSuggestionsFragment qFSWorkSuggestionsFragment = this.f84712e;
            View findViewById = inflate.findViewById(R.id.iig);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.scroll_view)");
            qFSWorkSuggestionsFragment.scrollView = (NestedScrollView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.zf7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.more_suggestions)");
            qFSWorkSuggestionsFragment.lookMoreView = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.f350210q);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.qfs_close_suggetions)");
            qFSWorkSuggestionsFragment.closeButton = findViewById3;
            TextView textView2 = qFSWorkSuggestionsFragment.lookMoreView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
                textView2 = null;
            }
            VideoReport.setPageId(textView2, qFSWorkSuggestionsFragment.Bh());
            TextView textView3 = qFSWorkSuggestionsFragment.lookMoreView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
                textView3 = null;
            }
            VideoReport.setElementParams(textView3, new QCircleDTParamBuilder().buildElementParams());
            TextView textView4 = qFSWorkSuggestionsFragment.lookMoreView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
                textView4 = null;
            }
            VideoReport.setElementId(textView4, QCircleDaTongConstant.ElementParamValue.XSJ_WORK_ADVISE_POP_MORE);
            TextView textView5 = qFSWorkSuggestionsFragment.lookMoreView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
            } else {
                textView = textView5;
            }
            VideoReport.setElementExposePolicy(textView, ExposurePolicy.REPORT_NONE);
            return inflate;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/QFSWorkSuggestionsFragment$c", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements QUSBaseHalfScreenFloatingView.o {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            r70.c cVar = QFSWorkSuggestionsFragment.this.vm;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                cVar = null;
            }
            Function2<Integer, Bundle, Unit> N1 = cVar.N1();
            if (N1 != null) {
                N1.invoke(-1, null);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(@Nullable View v3) {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/QFSWorkSuggestionsFragment$d", "Lcom/tencent/mobileqq/widget/qus/a;", "", "onShowTotal", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends com.tencent.mobileqq.widget.qus.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f84714d;

        d(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
            this.f84714d = qUSHalfScreenFloatingView;
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            this.f84714d.K(this);
        }
    }

    private final void Ch(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
        this.floatingView = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setIgnoreHorizontalMove(true);
        qUSHalfScreenFloatingView.J();
        qUSHalfScreenFloatingView.setIsContentDraggable(false);
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenFloatingView.setContentViewBackgroundResource(R.color.qui_common_bg_bottom_light);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new b(qUSHalfScreenFloatingView, this));
        qUSHalfScreenFloatingView.setOnOutsideClickListener(new c());
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.immersive.j
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                QFSWorkSuggestionsFragment.Dh(QFSWorkSuggestionsFragment.this);
            }
        });
        qUSHalfScreenFloatingView.j(new d(qUSHalfScreenFloatingView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(QFSWorkSuggestionsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.Gh();
            this$0.dismissAllowingStateLoss();
        } catch (Exception e16) {
            QLog.e("QFSWorkSuggestionsFragment", 1, "dismiss fragment error ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(QFSWorkSuggestionsFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Gh() {
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(32, this.feedId, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(QFSWorkSuggestionsData data) {
        TextView textView = null;
        if (data == null) {
            TextView textView2 = this.lookMoreView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.lookMoreView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSWorkSuggestionsFragment.Kh(QFSWorkSuggestionsFragment.this, view);
            }
        });
        TextView textView4 = this.lookMoreView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
            textView4 = null;
        }
        textView4.setTag(data.getMoreDataUrl());
        TextView textView5 = this.lookMoreView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
        } else {
            textView = textView5;
        }
        textView.setText(data.getMoreDataWord());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(QFSWorkSuggestionsFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        TextView textView = this$0.lookMoreView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lookMoreView");
            textView = null;
        }
        com.tencent.biz.qqcircle.launcher.c.g(activity, textView.getTag().toString());
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void Ah() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.floatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
        Gh();
    }

    @NotNull
    public final String Bh() {
        String str;
        Object obj = this.reportBean.get("xsj_custom_pgid");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void Hh(long j3) {
        this.creatTime = j3;
    }

    public final void Ih(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void Lh(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.reportBean = map;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QFSWorkSuggestionsPart());
        return mutableListOf;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public /* synthetic */ Activity getHostActivity() {
        return com.tencent.biz.richframework.part.a.a(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Context getHostContext() {
        return com.tencent.biz.richframework.part.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    /* renamed from: getHostLifecycleOwner */
    public /* synthetic */ LifecycleOwner getLifecycleOwner() {
        return com.tencent.biz.richframework.part.a.c(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Object getViewTagData() {
        return ne0.a.d(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        new FragmentPartProvider(this).initProvider();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.f173448dl);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.f173293c);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        r70.c it = (r70.c) getViewModel(this, null, r70.c.class);
        it.P1(this.reportBean, this.onSelect);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
        it.S1(account, this.feedId, this.creatTime);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this.vm = it;
        View inflate = inflater.inflate(R.layout.e3i, container, false);
        View findViewById = inflate.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById<QUSHalfS\u2026qus_floating_half_screen)");
        Ch((QUSHalfScreenFloatingView) findViewById);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026ingHalfScreen()\n        }");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.closeButton;
        r70.c cVar = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QFSWorkSuggestionsFragment.Eh(QFSWorkSuggestionsFragment.this, view3);
            }
        });
        r70.c cVar2 = this.vm;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            cVar = cVar2;
        }
        LiveData<QFSWorkSuggestionsData> O1 = cVar.O1();
        final QFSWorkSuggestionsFragment$onViewCreated$2 qFSWorkSuggestionsFragment$onViewCreated$2 = new QFSWorkSuggestionsFragment$onViewCreated$2(this);
        O1.observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSWorkSuggestionsFragment.Fh(Function1.this, obj);
            }
        });
        VideoReport.setElementParams(view, new QCircleDTParamBuilder().buildElementParams());
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementParamValue.XSJ_WORK_ADVISE_POP);
        VideoReport.setPageId(view, Bh());
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(32, this.feedId, true));
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.IPartFragmentHost
    @NotNull
    public Fragment getHostFragment() {
        return this;
    }
}
