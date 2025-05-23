package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.part.albummember.QZAlbumxAlbumMemberInvitePart;
import com.qzone.reborn.albumx.qzonex.part.albummember.QZAlbumxAlbumMemberPart;
import com.qzone.reborn.albumx.qzonex.part.albummember.QZAlbumxAlbumMemberTitlePart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import jc.r;
import jc.s;
import jc.t;
import jc.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.ao;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxAlbumMemberFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getDaTongPageId", "Lnc/ao;", BdhLogUtil.LogTag.Tag_Conn, "Lnc/ao;", "albumMemberViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumxAlbumMemberFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ao albumMemberViewModel;

    private final void initViewModel() {
        this.albumMemberViewModel = (ao) getViewModel(ao.class);
    }

    private final void parseIntent(Intent intent) {
        ao aoVar = this.albumMemberViewModel;
        if (aoVar != null) {
            aoVar.S1(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128613u;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_album_members";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ao aoVar = this.albumMemberViewModel;
        if (aoVar != null) {
            aoVar.L1();
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

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QQShareActionManager qQShareActionManager = new QQShareActionManager();
        qQShareActionManager.a(new t());
        qQShareActionManager.a(new r());
        qQShareActionManager.a(new s());
        qQShareActionManager.a(new u());
        Unit unit = Unit.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZAlbumxAlbumMemberTitlePart(), new QZAlbumxAlbumMemberPart(), new QZAlbumxAlbumMemberInvitePart(qQShareActionManager));
        return mutableListOf;
    }
}
