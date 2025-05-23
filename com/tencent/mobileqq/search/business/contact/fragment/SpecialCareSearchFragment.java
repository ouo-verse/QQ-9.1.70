package com.tencent.mobileqq.search.business.contact.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.search.base.activity.SearchMoreActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.h;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.ListView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qn2.d;
import sn2.c;
import xn2.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014J\u0010\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fH\u0014J&\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\"\u0010\u001f\u001a\u00020\u00052\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0003H\u0014\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/fragment/SpecialCareSearchFragment;", "Lcom/tencent/mobileqq/search/base/fragment/BaseSearchFragment;", "Lcom/tencent/mobileqq/search/model/y;", "", "haveResult", "", "sh", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "qh", "rh", "Lon2/b;", "newSearchEngine", "Lmn2/a;", "newAdapter", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", DKHippyEvent.EVENT_STOP, "", "resultList", "Lpn2/b;", "respData", "onFinish", "needShowHeader", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpecialCareSearchFragment extends BaseSearchFragment<y> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/fragment/SpecialCareSearchFragment$a;", "", "Landroid/content/Context;", "context", "", "dtReferPage", "", "traceId", "", "a", "KEY_DT_REFER_PAGE", "Ljava/lang/String;", "KEY_DT_TRACE_ID", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.contact.fragment.SpecialCareSearchFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, int dtReferPage, @Nullable String traceId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Bundle bundle = new Bundle();
            bundle.putString("keyword", "\u7279\u522b\u5173\u5fc3");
            bundle.putInt("dtReferPage", dtReferPage);
            bundle.putString("trace_id", traceId);
            SearchMoreActivity.INSTANCE.a(context, SpecialCareSearchFragment.class, context.getResources().getString(R.string.f214035rt), bundle);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/search/business/contact/fragment/SpecialCareSearchFragment$b", "Lmn2/b;", "Lcom/tencent/mobileqq/search/model/y;", "Lsn2/c;", "", "position", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lsn2/d;", "f", "Lqn2/d;", "e", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends mn2.b<y, c> {
        b(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        @Override // mn2.a
        @NotNull
        protected d<y, c> e(int position) {
            IFaceDecoder faceDecoder = ((BaseSearchFragment) SpecialCareSearchFragment.this).faceDecoder;
            Intrinsics.checkNotNullExpressionValue(faceDecoder, "faceDecoder");
            return new e(faceDecoder);
        }

        @Override // mn2.a
        @NotNull
        protected sn2.d f(int position, @Nullable ViewGroup parent) {
            return new yn2.d(parent, R.layout.bxt);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final PageParams qh(boolean haveResult) {
        int i3;
        String str;
        byte b16;
        Map mapOf;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("dtReferPage");
        } else {
            i3 = 0;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("trace_id");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            b16 = false;
        } else {
            b16 = true;
        }
        if (b16 != false) {
            str = "";
        }
        VSNetworkHelper.getInstance().getNetworkImpl().getAccountId();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.nanoTime());
        simpleDateFormat.format(new Date());
        long currentTimeMillis = System.currentTimeMillis() % 1000;
        random.nextInt(90000);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("referpage", Integer.valueOf(i3)), TuplesKt.to("search_query_text", "\u7279\u522b\u5173\u5fc3"), TuplesKt.to("have_result", Integer.valueOf(haveResult ? 1 : 0)), TuplesKt.to("search_trace_id", str));
        return new PageParams((Map<String, ?>) mapOf);
    }

    private final void rh() {
        int childCount = this.noResultLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.noResultLayout.getChildAt(i3).setVisibility(8);
        }
        this.noResultLayout.setGravity(17);
        ViewGroup.LayoutParams layoutParams = this.noResultLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = -1;
        marginLayoutParams.width = -1;
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        marginLayoutParams.topMargin = 0;
        this.noResultLayout.addView(new QUIEmptyState.Builder(getContext()).setImageType(7).setTitle("\u6682\u65e0\u7279\u522b\u5173\u5fc3\u7684\u8054\u7cfb\u4eba").build(), -1, -1);
    }

    private final void sh(boolean haveResult) {
        if (this.activityContentView != null) {
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(this.activityContentView, "pg_bas_special_concern");
            VideoReport.setPageReportPolicy(this.activityContentView, PageReportPolicy.REPORT_ALL);
            VideoReport.setPageParams(this.activityContentView, qh(haveResult));
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean needShowHeader() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    @NotNull
    protected mn2.a<?, ?> newAdapter() {
        return new b(this.listView, this.faceDecoder);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    @NotNull
    protected on2.b<?> newSearchEngine() {
        AppInterface appInterface = this.appInterface;
        Intrinsics.checkNotNullExpressionValue(appInterface, "appInterface");
        return new h(appInterface);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        rh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(@Nullable List<y> resultList, @Nullable pn2.b respData) {
        boolean z16;
        super.onFinish(resultList, respData);
        if (resultList != null) {
            z16 = !resultList.isEmpty();
        } else {
            z16 = false;
        }
        sh(z16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.searchEngine.pause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        startSearch("\u7279\u522b\u5173\u5fc3", 1);
        this.searchEngine.resume();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }
}
