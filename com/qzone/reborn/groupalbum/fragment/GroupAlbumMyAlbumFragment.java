package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.part.myalbum.GroupAlbumMyAlbumPart;
import com.qzone.reborn.groupalbum.part.myalbum.g;
import com.qzone.reborn.groupalbum.viewmodel.al;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumMyAlbumFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "", "getContentLayoutId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getDaTongPageId", "Lcom/qzone/reborn/groupalbum/viewmodel/al;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/viewmodel/al;", "mMyAlbumViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumMyAlbumFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private al mMyAlbumViewModel;

    private final void initViewModel() {
        this.mMyAlbumViewModel = (al) getViewModel(al.class);
    }

    private final void parseIntent(Intent intent) {
        al alVar = this.mMyAlbumViewModel;
        if (alVar != null) {
            alVar.N1(intent);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GroupAlbumMyAlbumPart());
        arrayList.add(new g());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127801n;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_qz_all_group_albums";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        al alVar = this.mMyAlbumViewModel;
        if (alVar != null) {
            alVar.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initViewModel();
        if (getActivity() == null || (intent = requireActivity().getIntent()) == null) {
            return;
        }
        parseIntent(intent);
    }
}
