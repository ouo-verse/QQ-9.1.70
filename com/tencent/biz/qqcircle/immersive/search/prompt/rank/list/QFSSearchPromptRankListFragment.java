package com.tencent.biz.qqcircle.immersive.search.prompt.rank.list;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$TextIconStyleData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankDataModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/QFSSearchPromptRankListFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "wh", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onViewCreatedAfterPartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "registerDaTongReportPageId", "", "getDaTongPageId", "", "getContentLayoutId", "getLogTag", "getPageId", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/e;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/e;", "listAdapter", "G", "Landroid/view/View;", "maskView", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/QFSSearchPromptRankListViewModel;", "H", "Lkotlin/Lazy;", "vh", "()Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/QFSSearchPromptRankListViewModel;", "viewModel", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankListFragment extends QFSBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private e listAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View maskView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public QFSSearchPromptRankListFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSSearchPromptRankListViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.list.QFSSearchPromptRankListFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSSearchPromptRankListViewModel invoke() {
                return (QFSSearchPromptRankListViewModel) QFSSearchPromptRankListFragment.this.getViewModel(QFSSearchPromptRankListViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final QFSSearchPromptRankListViewModel vh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QFSSearchPromptRankListViewModel) value;
    }

    private final void wh() {
        LiveData<QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData>> N1 = vh().N1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData>, Unit> function1 = new Function1<QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.list.QFSSearchPromptRankListFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData> qFSSearchPromptRankDataModel) {
                invoke2(qFSSearchPromptRankDataModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData> qFSSearchPromptRankDataModel) {
                RecyclerView recyclerView;
                e eVar;
                e eVar2;
                e eVar3;
                if (qFSSearchPromptRankDataModel.getIsSuccess()) {
                    QFSSearchPromptRankListFragment.this.listAdapter = new e(QFSSearchPromptRankListFragment.this.getReportBean());
                    recyclerView = QFSSearchPromptRankListFragment.this.recyclerView;
                    if (recyclerView != null) {
                        eVar3 = QFSSearchPromptRankListFragment.this.listAdapter;
                        recyclerView.setAdapter(eVar3);
                    }
                    eVar = QFSSearchPromptRankListFragment.this.listAdapter;
                    if (eVar != null) {
                        eVar.i0(qFSSearchPromptRankDataModel.getViewMoreUrl());
                    }
                    eVar2 = QFSSearchPromptRankListFragment.this.listAdapter;
                    if (eVar2 != null) {
                        eVar2.setData(qFSSearchPromptRankDataModel.b());
                        return;
                    }
                    return;
                }
                QLog.w(QFSSearchPromptRankListFragment.this.getTAG(), 1, "[onChanged] fail");
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.list.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchPromptRankListFragment.xh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gro;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchPromptRankListFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        vh().O1(getArguments());
        wh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        View view;
        View findViewById;
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        RecyclerView recyclerView = null;
        if (contentView != null) {
            view = contentView.findViewById(R.id.f53972dy);
        } else {
            view = null;
        }
        this.maskView = view;
        if (view != null) {
            view.setVisibility(8);
        }
        if (contentView != null && (findViewById = contentView.findViewById(R.id.f53992e0)) != null) {
            findViewById.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
        if (contentView != null) {
            recyclerView = (RecyclerView) contentView.findViewById(R.id.f53982dz);
        }
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        ca0.a.a(this.recyclerView, 1);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        int b16 = cVar.b(16);
        if (contentView != null) {
            contentView.setPadding(b16, 0, b16, 0);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setPadding(cVar.b(8), b16, 0, b16);
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
