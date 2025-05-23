package com.qzone.reborn.aio;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.QZoneBaseFeedxFragment;
import com.qzone.reborn.base.c;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import g9.b;
import g9.d;
import g9.e;
import gf.k;
import h9.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ve.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\rH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/qzone/reborn/aio/QZoneAIOUserFeedxFragment;", "Lcom/qzone/reborn/base/QZoneBaseFeedxFragment;", "Lgf/k;", "", "initIoc", "initViewModel", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedBeforePartInit", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "getPageType", "", "enableRootViewSetFitsSystemWindows", "Ltc/b;", "getFeedxViewModel", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedx/block/b;", "getHeaderBlock", "getReportPageId", "Lg9/e;", BdhLogUtil.LogTag.Tag_Conn, "Lg9/e;", "mAIOTitleBlock", "Lh9/a;", "D", "Lh9/a;", "mViewModel", "Lg9/d;", "E", "Lg9/d;", "mListBlockPart", "Lg9/b;", UserInfo.SEX_FEMALE, "Lg9/b;", "mFeedListBlockPart", "Lcom/qzone/reborn/feedx/block/k;", "G", "Lcom/qzone/reborn/feedx/block/k;", "mEmptyPageBlock", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class QZoneAIOUserFeedxFragment extends QZoneBaseFeedxFragment implements k {

    /* renamed from: C, reason: from kotlin metadata */
    private e mAIOTitleBlock;

    /* renamed from: D, reason: from kotlin metadata */
    private a mViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private d mListBlockPart;

    /* renamed from: F, reason: from kotlin metadata */
    private b mFeedListBlockPart;

    /* renamed from: G, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.block.k mEmptyPageBlock;

    private final void initIoc() {
        registerIoc(this, k.class);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAIOUse\u2026omeViewModel::class.java)");
        this.mViewModel = (a) viewModel;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        d dVar = new d(R.id.mn6, buildBlockList());
        this.mListBlockPart = dVar;
        arrayList.add(dVar);
        i iVar = new i();
        a aVar = this.mViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        List<Part> assemblerParts = new ve.a().c(iVar.h(aVar.getMUin()).e(getMFromDtPageId()));
        Intrinsics.checkNotNullExpressionValue(assemblerParts, "assemblerParts");
        arrayList.addAll(assemblerParts);
        return arrayList;
    }

    public List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        com.qzone.reborn.feedx.block.k kVar = new com.qzone.reborn.feedx.block.k(null);
        this.mEmptyPageBlock = kVar;
        kVar.setBlockVisible(false);
        com.qzone.reborn.feedx.block.k kVar2 = this.mEmptyPageBlock;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyPageBlock");
            kVar2 = null;
        }
        arrayList.add(kVar2);
        e eVar = new e(null);
        this.mAIOTitleBlock = eVar;
        eVar.setBlockVisible(false);
        e eVar2 = this.mAIOTitleBlock;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOTitleBlock");
            eVar2 = null;
        }
        arrayList.add(eVar2);
        b bVar = new b(null);
        this.mFeedListBlockPart = bVar;
        arrayList.add(bVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public c getBlockPart() {
        d dVar = this.mListBlockPart;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListBlockPart");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127661_;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_personal_dynamic_feed";
    }

    @Override // com.qzone.reborn.feedx.viewmodel.a
    public tc.b getFeedxViewModel() {
        a aVar = this.mViewModel;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        return null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.feedx.block.b getHeaderBlock() {
        return null;
    }

    @Override // gf.k
    public int getPageType() {
        return 4;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 16;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewModel();
        if (getArguments() != null) {
            a aVar = this.mViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar = null;
            }
            aVar.q2(getArguments());
        }
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initIoc();
    }
}
