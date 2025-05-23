package com.qzone.reborn.albumx.qzonex.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabPicTitlePart;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bp;
import nc.bq;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxTabPicFragment;", "Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxTabBaseMediaFragment;", "Lhb/f;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Lnc/bp;", "ph", "Lnc/bq;", "ag", "", "onDestroyView", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "", "isVisibleToUser", "setUserVisibleHint", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxTabPicFragment extends QZAlbumxTabBaseMediaFragment implements hb.f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QZAlbumxTabPicFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.registerDaTongReportPageId();
    }

    @Override // hb.f
    public bq ag() {
        return (bq) getViewModel(bq.class);
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabBaseMediaFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new com.qzone.reborn.albumx.qzonex.part.pictab.h(ph()));
        assembleParts.add(new QZAlbumTabPicTitlePart());
        assembleParts.add(new qb.a("qzone_albumx_photo_list"));
        return assembleParts;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        bq ag5;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!isAdded() || (ag5 = ag()) == null) {
            return linkedHashMap;
        }
        linkedHashMap.put(ProfileCardBlacklistReportConst.PAGE_PARAM_USERPROFILE_SETTING_HOST_GUEST_TYPE, Integer.valueOf(Intrinsics.areEqual(LoginData.getInstance().getUinString(), ag5.getUin()) ? 1 : 2));
        return linkedHashMap;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_pic_list";
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabBaseMediaFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        registerIoc(onCreateView, this, hb.f.class);
        return onCreateView;
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabBaseMediaFragment, com.qzone.reborn.base.QZoneBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterIoc(hb.f.class);
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabBaseMediaFragment
    public bp ph() {
        ViewModel viewModel = getViewModel(bq.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxTabPicViewModel::class.java)");
        return (bp) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        QLog.d(getTAG(), 1, "[setUserVisibleHint]: " + isVisibleToUser);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxTabPicFragment.sh(QZAlbumxTabPicFragment.this);
            }
        }, 200L);
    }
}
