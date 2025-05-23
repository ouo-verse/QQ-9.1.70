package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumAlbumDetailAnswerCheckPart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumAlbumDetailTimeLinePart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailBodyPart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailCeilingPart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailInvitePart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailOperatePanelPart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailPlusMenuPart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailSharePart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailTitlePart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxSyncDataPart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.ak;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.s;
import com.qzone.reborn.albumx.qzonex.share.action.QZAlbumxDetailShareMoreAction;
import com.qzone.reborn.albumx.qzonex.share.action.QZAlbumxDetailShareQQAction;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedx.util.m;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.richframework.argus.node.ArgusTag;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc.j;
import jc.k;
import jc.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.ap;
import nc.y;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_QZAlbumx", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a0\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxAlbumDetailFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Ll9/c;", "", "ph", "qh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "enableRootViewSetFitsSystemWindows", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "Ne", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "qf", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailFragment extends QZoneBaseFragment implements l9.c {

    /* renamed from: C, reason: from kotlin metadata */
    private QZAlbumxAlbumDetailInitBean initBean;

    private final void ph() {
        MutableLiveData<CommonAlbumInfo> M1;
        Object a16 = m.a("extra_key_parcelable_album_info_for_detail");
        CommonAlbumInfo commonAlbumInfo = a16 instanceof CommonAlbumInfo ? (CommonAlbumInfo) a16 : null;
        if (commonAlbumInfo == null) {
            return;
        }
        com.qzone.reborn.albumx.common.viewmodel.b Ne = Ne();
        Intrinsics.checkNotNull(Ne, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        y yVar = (y) Ne;
        MutableLiveData<CommonAlbumInfo> M12 = yVar.M1();
        if ((M12 != null ? M12.getValue() : null) != null || (M1 = yVar.M1()) == null) {
            return;
        }
        M1.setValue(commonAlbumInfo);
    }

    private final void qh() {
        Intent intent;
        if (this.initBean == null) {
            FragmentActivity activity = getActivity();
            Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
            this.initBean = serializableExtra instanceof QZAlbumxAlbumDetailInitBean ? (QZAlbumxAlbumDetailInitBean) serializableExtra : null;
        }
    }

    @Override // l9.c
    public com.qzone.reborn.albumx.common.viewmodel.b Ne() {
        ViewModel viewModel = getViewModel(y.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026ailViewModel::class.java)");
        return (com.qzone.reborn.albumx.common.viewmodel.b) viewModel;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        qh();
        ph();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new qb.a("qzone_albumx_album_detail"));
        arrayList.add(new QZAlbumxAlbumDetailTitlePart());
        arrayList.add(new s());
        arrayList.add(new QZAlbumxAlbumDetailBodyPart());
        arrayList.add(new ak());
        arrayList.add(new QZAlbumxAlbumDetailPlusMenuPart(this.initBean));
        arrayList.add(new QZAlbumxAlbumDetailOperatePanelPart());
        arrayList.add(new QZAlbumAlbumDetailTimeLinePart());
        arrayList.add(new QZAlbumAlbumDetailAnswerCheckPart());
        arrayList.add(new QZAlbumxSyncDataPart());
        QQShareActionManager qQShareActionManager = new QQShareActionManager();
        qQShareActionManager.a(new jc.g());
        qQShareActionManager.a(new jc.e());
        qQShareActionManager.a(new jc.f());
        qQShareActionManager.a(new jc.h());
        arrayList.add(new QZAlbumxAlbumDetailInvitePart(qQShareActionManager));
        QQShareActionManager qQShareActionManager2 = new QQShareActionManager();
        qQShareActionManager2.a(new j());
        qQShareActionManager2.a(new QZAlbumxDetailShareMoreAction());
        qQShareActionManager2.a(new jc.i());
        qQShareActionManager2.a(new QZAlbumxDetailShareQQAction());
        qQShareActionManager2.a(new k());
        qQShareActionManager2.a(new l());
        arrayList.add(new QZAlbumxAlbumDetailSharePart(qQShareActionManager2));
        arrayList.add(new QZAlbumxAlbumDetailCeilingPart());
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        String uin = qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getUin() : null;
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.initBean;
        arrayList.add(new QZAlbumxTransmitPart(uin, qZAlbumxAlbumDetailInitBean2 != null ? qZAlbumxAlbumDetailInitBean2.getAlbumId() : null, 20, null, 8, null));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        com.qzone.reborn.albumx.common.viewmodel.b Ne;
        String str;
        CommonAlbumInfo value;
        CommonAlbumAccessPermission commonAlbumAccessPermission;
        String name;
        CommonAlbumInfo value2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!isAdded() || (Ne = Ne()) == null) {
            return linkedHashMap;
        }
        mc.d dVar = mc.d.f416543a;
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        MutableLiveData<CommonAlbumInfo> M1 = Ne.M1();
        Integer num = null;
        linkedHashMap.put("topic_type", Integer.valueOf(dVar.a(cVar.c((M1 == null || (value2 = M1.getValue()) == null) ? null : Integer.valueOf(value2.getQzAlbumType())))));
        CommonAlbumInfo value3 = Ne.M1().getValue();
        String str2 = "";
        if (value3 == null || (str = value3.getAlbumId()) == null) {
            str = "";
        }
        linkedHashMap.put("albumid", str);
        CommonAlbumInfo value4 = Ne.M1().getValue();
        if (value4 != null && (name = value4.getName()) != null) {
            str2 = name;
        }
        linkedHashMap.put("album_name", str2);
        MutableLiveData<CommonAlbumInfo> M12 = Ne.M1();
        linkedHashMap.put("user_identity", Integer.valueOf(dVar.b(M12 != null ? M12.getValue() : null)));
        MutableLiveData<CommonAlbumInfo> M13 = Ne.M1();
        if (M13 != null && (value = M13.getValue()) != null && (commonAlbumAccessPermission = value.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String()) != null) {
            num = Integer.valueOf(commonAlbumAccessPermission.getPermissionType());
        }
        linkedHashMap.put(MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, Integer.valueOf(dVar.c(num)));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128583r;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_photo_list_new";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            fj.a aVar = fj.a.f399444a;
            QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
            String albumId = qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getAlbumId() : null;
            aVar.b(albumId + hashCode());
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        qh();
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        if (qZAlbumxAlbumDetailInitBean != null) {
            com.qzone.reborn.albumx.common.viewmodel.b Ne = Ne();
            Intrinsics.checkNotNull(Ne, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
            y yVar = (y) Ne;
            yVar.b3(qZAlbumxAlbumDetailInitBean);
            yVar.a3(qZAlbumxAlbumDetailInitBean.getAlbumId() + hashCode());
            fj.a.f399444a.c(qZAlbumxAlbumDetailInitBean.getAlbumId() + hashCode(), yVar.getDataRepo());
        }
        RFWIocAbilityProvider.g().registerIoc(view, this, l9.c.class);
    }

    @Override // l9.c
    public com.qzone.reborn.albumx.common.viewmodel.e qf() {
        ViewModel viewModel = getViewModel(ap.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026ateViewModel::class.java)");
        return (com.qzone.reborn.albumx.common.viewmodel.e) viewModel;
    }
}
