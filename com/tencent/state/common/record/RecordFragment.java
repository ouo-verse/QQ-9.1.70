package com.tencent.state.common.record;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.state.FragmentComponent;
import com.tencent.state.PageType;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.databinding.VasSquareErrorViewBinding;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryRecordBinding;
import com.tencent.state.view.SquareImageView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/common/record/RecordFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "pageType", "Lcom/tencent/state/PageType;", "(Lcom/tencent/state/PageType;)V", "adapter", "Lcom/tencent/state/common/record/RecordAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentLibraryRecordBinding;", "getPageType", "()Lcom/tencent/state/PageType;", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getPageId", "", "initView", "", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class RecordFragment extends VasBaseSubFragment {
    private static final String TAG = "SquareLibraryRecordFragment";
    private RecordAdapter adapter;
    private VasSquareFragmentLibraryRecordBinding binding;
    private final PageType pageType;

    public RecordFragment(PageType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        this.pageType = pageType;
    }

    private final void initView() {
        SquareImageView squareImageView;
        RecyclerView it;
        this.adapter = new RecordAdapter(this);
        VasSquareFragmentLibraryRecordBinding vasSquareFragmentLibraryRecordBinding = this.binding;
        if (vasSquareFragmentLibraryRecordBinding != null && (it = vasSquareFragmentLibraryRecordBinding.recordList) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.setAdapter(this.adapter);
            it.setLayoutManager(new LinearLayoutManager(requireContext()));
        }
        VasSquareFragmentLibraryRecordBinding vasSquareFragmentLibraryRecordBinding2 = this.binding;
        if (vasSquareFragmentLibraryRecordBinding2 == null || (squareImageView = vasSquareFragmentLibraryRecordBinding2.back) == null) {
            return;
        }
        squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.common.record.RecordFragment$initView$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordFragment.this.onBackPressed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List listOf;
        List<FragmentComponent> plus;
        List<FragmentComponent> components = super.getComponents();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new RecordReportComponent(), new RecordRouterComponent()});
        plus = CollectionsKt___CollectionsKt.plus((Collection) components, (Iterable) listOf);
        return plus;
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return SquareReportConst.PageId.PAGE_ID_LIBRARY_RECORD;
    }

    public final PageType getPageType() {
        return this.pageType;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        hideFragment(this);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareFragmentLibraryRecordBinding inflate = VasSquareFragmentLibraryRecordBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentLibrary\u2026 binding = this\n        }");
        LinearLayout mRv = inflate.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "VasSquareFragmentLibrary\u2026ing = this\n        }.root");
        return mRv;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        IRecordDataProvider iRecordDataProvider = RecordProviderFactory.INSTANCE.get(this.pageType);
        if (iRecordDataProvider != 0) {
            iRecordDataProvider.getInteractionRecord(new ResultCallback<List<? extends RecordData>>() { // from class: com.tencent.state.common.record.RecordFragment$onViewCreated$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public /* bridge */ /* synthetic */ void onResultSuccess(List<? extends RecordData> list) {
                    onResultSuccess2((List<RecordData>) list);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    VasSquareFragmentLibraryRecordBinding vasSquareFragmentLibraryRecordBinding;
                    VasSquareErrorViewBinding vasSquareErrorViewBinding;
                    RelativeLayout mRv;
                    ResultCallback.DefaultImpls.onResultFailure(this, error, message);
                    vasSquareFragmentLibraryRecordBinding = RecordFragment.this.binding;
                    if (vasSquareFragmentLibraryRecordBinding != null && (vasSquareErrorViewBinding = vasSquareFragmentLibraryRecordBinding.requestErrorBackground) != null && (mRv = vasSquareErrorViewBinding.getMRv()) != null) {
                        mRv.setVisibility(0);
                    }
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareLibraryRecordFragment", "error:" + error + ", message:" + message, null, 4, null);
                }

                /* renamed from: onResultSuccess, reason: avoid collision after fix types in other method */
                public void onResultSuccess2(List<RecordData> result) {
                    VasSquareFragmentLibraryRecordBinding vasSquareFragmentLibraryRecordBinding;
                    VasSquareFragmentLibraryRecordBinding vasSquareFragmentLibraryRecordBinding2;
                    RecordAdapter recordAdapter;
                    RelativeLayout relativeLayout;
                    VasSquareErrorViewBinding vasSquareErrorViewBinding;
                    RelativeLayout mRv;
                    Intrinsics.checkNotNullParameter(result, "result");
                    vasSquareFragmentLibraryRecordBinding = RecordFragment.this.binding;
                    if (vasSquareFragmentLibraryRecordBinding != null && (vasSquareErrorViewBinding = vasSquareFragmentLibraryRecordBinding.requestErrorBackground) != null && (mRv = vasSquareErrorViewBinding.getMRv()) != null) {
                        mRv.setVisibility(8);
                    }
                    if (!result.isEmpty()) {
                        vasSquareFragmentLibraryRecordBinding2 = RecordFragment.this.binding;
                        if (vasSquareFragmentLibraryRecordBinding2 != null && (relativeLayout = vasSquareFragmentLibraryRecordBinding2.vasSquareRecordEmptyContainer) != null) {
                            relativeLayout.setVisibility(8);
                        }
                        recordAdapter = RecordFragment.this.adapter;
                        if (recordAdapter != null) {
                            recordAdapter.setData(result);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }
}
