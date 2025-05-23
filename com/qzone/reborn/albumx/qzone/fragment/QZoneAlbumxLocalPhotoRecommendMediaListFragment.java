package com.qzone.reborn.albumx.qzone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBodyPart;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBottomOperatePart;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListTitlePart;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u000fH\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/fragment/QZoneAlbumxLocalPhotoRecommendMediaListFragment;", "Lcom/qzone/common/activities/base/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "needSupportFullScreen", "needAdjustImmersive", "isUseDarkTextStatusBar", "", "getLogTag", "getDaTongPageId", "enableDaTongPageRegister", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoRecommendMediaListFragment extends BaseFragment {
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneAlbumxMediaListTitlePart());
        arrayList.add(new QZoneAlbumxMediaListBodyPart());
        arrayList.add(new QZoneAlbumxMediaListBottomOperatePart());
        return arrayList;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected boolean enableDaTongPageRegister() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f129014x;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected String getDaTongPageId() {
        return "pg_qz_cluster_details_page";
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public String getLogTag() {
        return "QZoneAlbumxLocalPhotoRecommendMediaListFragment";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return !QQTheme.isNowThemeIsNight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (onCreateView != null) {
            ViewExtKt.f(onCreateView, ImmersiveUtils.getStatusBarHeight(onCreateView.getContext()));
        }
        return onCreateView;
    }
}
