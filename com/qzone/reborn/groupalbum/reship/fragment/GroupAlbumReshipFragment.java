package com.qzone.reborn.groupalbum.reship.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipInitBean;
import com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipPart;
import com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipSelectBarPart;
import com.qzone.reborn.groupalbum.reship.part.b;
import com.qzone.reborn.part.publish.common.inputarea.QZoneScrollViewPart;
import com.qzone.reborn.part.publish.common.inputarea.c;
import com.qzone.reborn.part.publish.common.inputkeyboardmenu.QZoneInputKeyboardMenuPart;
import com.qzone.util.l;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import dj.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ni.e;
import ni.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H\u0014J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/fragment/GroupAlbumReshipFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "qh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "ph", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "initBean", "Lcom/qzone/reborn/groupalbum/reship/part/b;", "D", "Lcom/qzone/reborn/groupalbum/reship/part/b;", "mediaPickPart", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumReshipFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private GroupAlbumReshipInitBean initBean;

    /* renamed from: D, reason: from kotlin metadata */
    private final b mediaPickPart = new b(new li.b());

    private final void qh() {
        Parcelable parcelableExtra = getHostActivity().getIntent().getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(parcelableExtra);
        this.initBean = (GroupAlbumReshipInitBean) parcelableExtra;
        e eVar = (e) getViewModel(e.class);
        GroupAlbumReshipInitBean groupAlbumReshipInitBean = this.initBean;
        GroupAlbumReshipInitBean groupAlbumReshipInitBean2 = null;
        if (groupAlbumReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumReshipInitBean = null;
        }
        eVar.a2(groupAlbumReshipInitBean.getGroupId());
        h hVar = (h) getViewModel(h.class);
        GroupAlbumReshipInitBean groupAlbumReshipInitBean3 = this.initBean;
        if (groupAlbumReshipInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            groupAlbumReshipInitBean2 = groupAlbumReshipInitBean3;
        }
        hVar.R1(groupAlbumReshipInitBean2);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        return ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ed8;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_reprint_to_space_album";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        qh();
        super.onViewCreated(view, savedInstanceState);
    }

    public final Map<String, Object> ph() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        GroupAlbumReshipInitBean groupAlbumReshipInitBean = this.initBean;
        if (groupAlbumReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumReshipInitBean = null;
        }
        linkedHashMap.put("group_uin", groupAlbumReshipInitBean.getGroupId());
        return linkedHashMap;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[7];
        partArr[0] = this.mediaPickPart;
        vl.e eVar = new vl.e();
        eVar.O9(l.a(R.string.s3c));
        eVar.M9(l.a(R.string.rlu));
        eVar.I9("em_qz_confirm_upload");
        Unit unit = Unit.INSTANCE;
        partArr[1] = eVar;
        c cVar = new c(new a());
        cVar.O9("em_qz_add_description");
        partArr[2] = cVar;
        QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = new QZoneInputKeyboardMenuPart();
        GroupAlbumReshipInitBean groupAlbumReshipInitBean = this.initBean;
        if (groupAlbumReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumReshipInitBean = null;
        }
        qZoneInputKeyboardMenuPart.Ga(groupAlbumReshipInitBean.getGroupId());
        partArr[3] = qZoneInputKeyboardMenuPart;
        partArr[4] = new QZoneScrollViewPart();
        partArr[5] = new GroupAlbumReshipSelectBarPart();
        partArr[6] = new GroupAlbumReshipPart();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }
}
