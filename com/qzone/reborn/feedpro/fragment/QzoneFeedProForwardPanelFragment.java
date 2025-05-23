package com.qzone.reborn.feedpro.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.part.al;
import com.qzone.reborn.comment.part.ap;
import com.qzone.reborn.comment.part.at;
import com.qzone.reborn.comment.part.av;
import com.qzone.reborn.comment.part.ax;
import com.qzone.reborn.comment.part.c;
import com.qzone.reborn.comment.part.p;
import com.qzone.reborn.feedpro.viewmodel.l;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import dd.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/feedpro/fragment/QzoneFeedProForwardPanelFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Ldd/b;", BdhLogUtil.LogTag.Tag_Conn, "Ldd/b;", "mInputViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/l;", "D", "Lcom/qzone/reborn/feedpro/viewmodel/l;", "mDataViewModel", "E", "Ljava/lang/String;", "mFromDtPageId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProForwardPanelFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private b mInputViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private l mDataViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private String mFromDtPageId = "";

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        b bVar = this.mInputViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        QZoneCommentPanelParams T1 = bVar.T1();
        arrayList.add(new p(T1));
        arrayList.add(new al(T1));
        arrayList.add(new ax(T1));
        arrayList.add(new av(T1));
        arrayList.add(new at(T1));
        if (T1.getEnableEmo()) {
            arrayList.add(new ap(T1));
        }
        if (T1.getEnableAt()) {
            arrayList.add(new c(T1));
        }
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.chz;
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
        ViewModel viewModel2 = getViewModel(l.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QzoneFeedPr\u2026ataViewModel::class.java)");
        l lVar = (l) viewModel2;
        this.mDataViewModel = lVar;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataViewModel");
            lVar = null;
        }
        lVar.N1();
        b bVar4 = this.mInputViewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
        } else {
            bVar2 = bVar4;
        }
        this.mFromDtPageId = bVar2.T1().getFromDtPageId();
    }
}
