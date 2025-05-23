package com.qzone.reborn.comment.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import dd.a;
import dd.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import wc.c;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/comment/fragment/QZoneCommentPanelFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Ldd/b;", BdhLogUtil.LogTag.Tag_Conn, "Ldd/b;", "mInputViewModel", "Ldd/a;", "D", "Ldd/a;", "mDataViewModel", "E", "Ljava/lang/String;", "mFromDtPageId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentPanelFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private b mInputViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private a mDataViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private String mFromDtPageId = "";

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> c16;
        ArrayList arrayList = new ArrayList();
        b bVar = this.mInputViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        QZoneCommentPanelParams T1 = bVar.T1();
        if (T1.getIsShare()) {
            c16 = new c().c(T1);
        } else {
            c16 = new wc.b().c(T1);
        }
        arrayList.addAll(c16);
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        a aVar = this.mDataViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            aVar = null;
        }
        BusinessFeedData value = aVar.j().getValue();
        String mFromDtPageId = getMFromDtPageId();
        if (Intrinsics.areEqual(mFromDtPageId, "pg_qz_dynamic_detail_page")) {
            return fh.b.INSTANCE.c(value);
        }
        if (Intrinsics.areEqual(mFromDtPageId, "pg_qz_personal_homepage")) {
            return fh.b.INSTANCE.e(value);
        }
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cht;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId, reason: from getter */
    protected String getMFromDtPageId() {
        return this.mFromDtPageId;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = getViewModel(b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        b bVar = (b) viewModel;
        this.mInputViewModel = bVar;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        bVar.Z1(getActivity());
        b bVar3 = this.mInputViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar3 = null;
        }
        bVar3.initData();
        ViewModel viewModel2 = getViewModel(a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneInputDataViewModel::class.java)");
        a aVar = (a) viewModel2;
        this.mDataViewModel = aVar;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            aVar = null;
        }
        aVar.N1();
        b bVar4 = this.mInputViewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar4 = null;
        }
        if (bVar4.T1().getIsShare()) {
            b bVar5 = this.mInputViewModel;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            } else {
                bVar2 = bVar5;
            }
            this.mFromDtPageId = bVar2.T1().getFromDtPageId();
            return;
        }
        this.mFromDtPageId = "pg_qz_spatial_keyboard";
    }
}
