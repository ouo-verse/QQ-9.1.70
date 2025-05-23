package com.qzone.reborn.feedx.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.QZoneBaseFeedxFragment;
import com.qzone.reborn.feedx.block.ab;
import com.qzone.reborn.feedx.part.m;
import com.qzone.reborn.feedx.viewmodel.w;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.state.report.SquareReportConst;
import gf.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ve.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0012\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020!0 H\u0014R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/feedx/fragment/QZoneFeedxFamousUserHomeFragment;", "Lcom/qzone/reborn/base/QZoneBaseFeedxFragment;", "Lgf/k;", "Landroid/view/View;", "contentView", "", "sh", "initViewModel", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onViewCreatedBeforePartInit", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "getPageType", "", "enableRootViewSetFitsSystemWindows", "Ltc/b;", "getFeedxViewModel", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedx/block/b;", "getHeaderBlock", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Lcom/qzone/reborn/feedx/viewmodel/w;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedx/viewmodel/d;", "D", "Lcom/qzone/reborn/feedx/viewmodel/d;", "mFamousUserViewModel", "Lcom/qzone/reborn/feedx/part/m;", "E", "Lcom/qzone/reborn/feedx/part/m;", "rh", "()Lcom/qzone/reborn/feedx/part/m;", "uh", "(Lcom/qzone/reborn/feedx/part/m;)V", "mListBlockPart", "Lcom/qzone/reborn/feedx/block/d;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/block/d;", "qh", "()Lcom/qzone/reborn/feedx/block/d;", "th", "(Lcom/qzone/reborn/feedx/block/d;)V", "mHeaderBlock", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFeedxFamousUserHomeFragment extends QZoneBaseFeedxFragment implements k {

    /* renamed from: C, reason: from kotlin metadata */
    private w mUserHomeViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.d mFamousUserViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    protected m mListBlockPart;

    /* renamed from: F, reason: from kotlin metadata */
    protected com.qzone.reborn.feedx.block.d mHeaderBlock;

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneUserHomeViewModel::class.java)");
        this.mUserHomeViewModel = (w) viewModel;
        ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedx.viewmodel.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneFamousUserViewModel::class.java)");
        this.mFamousUserViewModel = (com.qzone.reborn.feedx.viewmodel.d) viewModel2;
    }

    private final void sh(View contentView) {
        registerIoc(this, k.class);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> c16;
        ArrayList arrayList = new ArrayList();
        uh(new m(R.id.nch, buildBlockList()));
        arrayList.add(rh());
        i e16 = new i().g("2").e(getMFromDtPageId());
        w wVar = this.mUserHomeViewModel;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        i h16 = e16.h(wVar.getMUin());
        w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar3;
        }
        if (wVar2.M2()) {
            c16 = new ve.e().c(h16);
            Intrinsics.checkNotNullExpressionValue(c16, "{\n            QZoneFamou\u2026eParts(builder)\n        }");
        } else {
            c16 = new ve.d().c(h16);
            Intrinsics.checkNotNullExpressionValue(c16, "{\n            QZoneFamou\u2026eParts(builder)\n        }");
        }
        arrayList.addAll(c16);
        return arrayList;
    }

    public List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        th(new com.qzone.reborn.feedx.block.d(null));
        arrayList.add(qh());
        com.qzone.reborn.feedx.block.k kVar = new com.qzone.reborn.feedx.block.k(null);
        kVar.setBlockVisible(false);
        arrayList.add(kVar);
        ab abVar = new ab(null);
        abVar.setBlockVisible(false);
        arrayList.add(abVar);
        arrayList.add(new com.qzone.reborn.feedx.block.f(null));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.base.c getBlockPart() {
        return rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167290ci4;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_personal_homepage";
    }

    @Override // com.qzone.reborn.feedx.viewmodel.a
    public tc.b getFeedxViewModel() {
        w wVar = this.mUserHomeViewModel;
        if (wVar != null) {
            return wVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        return null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.feedx.block.b getHeaderBlock() {
        return qh();
    }

    @Override // gf.k
    public int getPageType() {
        return 12;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewModel();
        if (getActivity() != null) {
            w wVar = this.mUserHomeViewModel;
            if (wVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                wVar = null;
            }
            FragmentActivity activity = getActivity();
            wVar.b3(activity != null ? activity.getIntent() : null);
            com.qzone.reborn.feedx.viewmodel.d dVar = this.mFamousUserViewModel;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFamousUserViewModel");
                dVar = null;
            }
            FragmentActivity activity2 = getActivity();
            dVar.P1(activity2 != null ? activity2.getIntent() : null);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        sh(contentView);
    }

    protected final com.qzone.reborn.feedx.block.d qh() {
        com.qzone.reborn.feedx.block.d dVar = this.mHeaderBlock;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHeaderBlock");
        return null;
    }

    protected final m rh() {
        m mVar = this.mListBlockPart;
        if (mVar != null) {
            return mVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListBlockPart");
        return null;
    }

    protected final void th(com.qzone.reborn.feedx.block.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mHeaderBlock = dVar;
    }

    protected final void uh(m mVar) {
        Intrinsics.checkNotNullParameter(mVar, "<set-?>");
        this.mListBlockPart = mVar;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[5];
        w wVar = this.mUserHomeViewModel;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        pairArr[0] = TuplesKt.to("touin", Long.valueOf(wVar.getMUin()));
        w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar3 = null;
        }
        if (wVar3.M2()) {
            str = LoginData.getInstance().getUid();
        } else {
            str = "";
        }
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str);
        w wVar4 = this.mUserHomeViewModel;
        if (wVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar4 = null;
        }
        pairArr[2] = TuplesKt.to("open_visit_state", Integer.valueOf(!wVar4.M2() ? 1 : 0));
        pairArr[3] = TuplesKt.to("is_authentication_space", 1);
        w wVar5 = this.mUserHomeViewModel;
        if (wVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar5;
        }
        pairArr[4] = TuplesKt.to("authentication_account", String.valueOf(wVar2.getMUin()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }
}
