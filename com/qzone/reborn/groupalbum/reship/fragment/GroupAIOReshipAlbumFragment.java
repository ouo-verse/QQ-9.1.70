package com.qzone.reborn.groupalbum.reship.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.reship.bean.GroupAIOReshipInitBean;
import com.qzone.reborn.groupalbum.reship.part.GroupAIOReshipPart;
import com.qzone.reborn.groupalbum.upload.selectalbum.GroupUploadSelectAlbumBarPart;
import com.qzone.reborn.groupalbum.upload.selectalbum.f;
import com.qzone.reborn.part.publish.common.inputarea.QZoneScrollViewPart;
import com.qzone.reborn.part.publish.common.inputkeyboardmenu.QZoneInputKeyboardMenuPart;
import com.qzone.util.l;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import li.a;
import mqq.app.Constants;
import ni.c;
import tl.g;
import vl.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012H\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/fragment/GroupAIOReshipAlbumFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "ph", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedAfterPartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "initBean", "Ltl/g;", "D", "Ltl/g;", "mediaPickPart", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAIOReshipAlbumFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private GroupAIOReshipInitBean initBean;

    /* renamed from: D, reason: from kotlin metadata */
    private final g mediaPickPart = new g(new a());

    private final void ph() {
        Parcelable parcelableExtra = getHostActivity().getIntent().getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(parcelableExtra);
        this.initBean = (GroupAIOReshipInitBean) parcelableExtra;
        f fVar = (f) getViewModel(f.class);
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.initBean;
        GroupAIOReshipInitBean groupAIOReshipInitBean2 = null;
        if (groupAIOReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        }
        String groupId = groupAIOReshipInitBean.getGroupId();
        GroupAIOReshipInitBean groupAIOReshipInitBean3 = this.initBean;
        if (groupAIOReshipInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean3 = null;
        }
        fVar.S1(groupId, groupAIOReshipInitBean3.getAlbumInfo());
        c cVar = (c) getViewModel(c.class);
        GroupAIOReshipInitBean groupAIOReshipInitBean4 = this.initBean;
        if (groupAIOReshipInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            groupAIOReshipInitBean2 = groupAIOReshipInitBean4;
        }
        cVar.i2(groupAIOReshipInitBean2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hki;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_group_reprint_album_upload";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        ph();
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[2];
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.initBean;
        GroupAIOReshipInitBean groupAIOReshipInitBean2 = null;
        if (groupAIOReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        }
        pairArr[0] = TuplesKt.to("group_uin", groupAIOReshipInitBean.getGroupId());
        GroupAIOReshipInitBean groupAIOReshipInitBean3 = this.initBean;
        if (groupAIOReshipInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            groupAIOReshipInitBean2 = groupAIOReshipInitBean3;
        }
        pairArr[1] = TuplesKt.to(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(groupAIOReshipInitBean2.getFromType()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[8];
        partArr[0] = this.mediaPickPart;
        sl.a aVar = new sl.a();
        aVar.C9("em_qz_add_location");
        Unit unit = Unit.INSTANCE;
        partArr[1] = aVar;
        e eVar = new e();
        eVar.O9(l.a(R.string.s3c));
        eVar.M9(l.a(R.string.f2195766s));
        eVar.I9("em_qz_confirm_upload");
        partArr[2] = eVar;
        com.qzone.reborn.part.publish.common.inputarea.c cVar = new com.qzone.reborn.part.publish.common.inputarea.c(new dj.a());
        cVar.O9("em_qz_add_description");
        partArr[3] = cVar;
        QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = new QZoneInputKeyboardMenuPart();
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.initBean;
        if (groupAIOReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        }
        qZoneInputKeyboardMenuPart.Ga(groupAIOReshipInitBean.getGroupId());
        partArr[4] = qZoneInputKeyboardMenuPart;
        partArr[5] = new QZoneScrollViewPart();
        GroupUploadSelectAlbumBarPart groupUploadSelectAlbumBarPart = new GroupUploadSelectAlbumBarPart();
        groupUploadSelectAlbumBarPart.J9(WinkDaTongReportConstant.ElementId.EM_XSJ_QZONE_UPLOAD_ALBUM);
        partArr[6] = groupUploadSelectAlbumBarPart;
        partArr[7] = new GroupAIOReshipPart();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }
}
