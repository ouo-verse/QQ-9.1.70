package com.qzone.reborn.intimate.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.bean.init.QZIntimateSettingPageBean;
import com.qzone.reborn.intimate.part.bb;
import com.qzone.reborn.intimate.part.q;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nk.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013H\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZIntimateSpaceSettingFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "enableRootViewSetFitsSystemWindows", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onFinish", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "Lnk/o;", BdhLogUtil.LogTag.Tag_Conn, "Lnk/o;", "settingViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceSettingFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private o settingViewModel;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        o oVar = this.settingViewModel;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
            oVar = null;
        }
        QZIntimateSettingPageBean settingPageBean = oVar.getSettingPageBean();
        if (settingPageBean != null) {
            linkedHashMap.put("close_friend_space_id", settingPageBean.getSpaceId());
            linkedHashMap.put("close_friend_space_type", Integer.valueOf(settingPageBean.getSpaceType()));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cij;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_qz_settings_page_buddy";
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = getViewModel(o.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateS\u2026ageViewModel::class.java)");
        o oVar = (o) viewModel;
        this.settingViewModel = oVar;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
            oVar = null;
        }
        FragmentActivity activity = getActivity();
        oVar.O1(activity != null ? activity.getIntent() : null);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new bb(), new q());
        return mutableListOf;
    }
}
