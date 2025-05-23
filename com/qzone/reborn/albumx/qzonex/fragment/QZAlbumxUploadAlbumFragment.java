package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadAlbumAuthorityBarPart;
import com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadAlbumPart;
import com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadQualitySelectBarPart;
import com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadSelectAlbumBarPart;
import com.qzone.reborn.albumx.qzonex.part.upload.QZAlbumxUploadSelectLayoutMarginPart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.part.publish.common.inputarea.QZoneScrollViewPart;
import com.qzone.reborn.part.publish.common.inputkeyboardmenu.QZoneInputKeyboardMenuPart;
import com.qzone.util.l;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016H\u0014R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxUploadAlbumFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "qh", "", "ph", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedAfterPartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/content/Intent;", "newIntent", "onNewIntent", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "initBean", "Lcom/qzone/reborn/albumx/qzonex/part/upload/a;", "D", "Lcom/qzone/reborn/albumx/qzonex/part/upload/a;", "mediaPickPart", "Lym/a;", "E", "Lym/a;", "publisherGamePlayPart", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxUploadAlbumFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private QZAlbumxUploadAlbumInitBean initBean;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.albumx.qzonex.part.upload.a mediaPickPart;

    /* renamed from: E, reason: from kotlin metadata */
    private final ym.a publisherGamePlayPart = new ym.a();

    private final int ph() {
        int d16 = v5.a.a().d("photo");
        if (d16 != 2) {
            return d16 != 3 ? 3 : 1;
        }
        return 2;
    }

    private final void qh() {
        Parcelable parcelableExtra = getHostActivity().getIntent().getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(parcelableExtra);
        this.initBean = (QZAlbumxUploadAlbumInitBean) parcelableExtra;
        qc.e eVar = (qc.e) getViewModel(qc.e.class);
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean2 = null;
        if (qZAlbumxUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZAlbumxUploadAlbumInitBean = null;
        }
        eVar.T1(qZAlbumxUploadAlbumInitBean);
        qc.b bVar = (qc.b) getViewModel(qc.b.class);
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean3 = this.initBean;
        if (qZAlbumxUploadAlbumInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZAlbumxUploadAlbumInitBean3 = null;
        }
        bVar.g2(qZAlbumxUploadAlbumInitBean3, getHostActivity().getIntent().getExtras());
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean4 = this.initBean;
        if (qZAlbumxUploadAlbumInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZAlbumxUploadAlbumInitBean4 = null;
        }
        db.d dVar = new db.d(qZAlbumxUploadAlbumInitBean4);
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean5 = this.initBean;
        if (qZAlbumxUploadAlbumInitBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            qZAlbumxUploadAlbumInitBean2 = qZAlbumxUploadAlbumInitBean5;
        }
        this.mediaPickPart = new com.qzone.reborn.albumx.qzonex.part.upload.a(dVar, qZAlbumxUploadAlbumInitBean2);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean2 = null;
        if (qZAlbumxUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZAlbumxUploadAlbumInitBean = null;
        }
        int fromType = qZAlbumxUploadAlbumInitBean.getFromType();
        linkedHashMap.put("come_from", Integer.valueOf(fromType != 7 ? fromType != 8 ? fromType != 9 ? 0 : 3 : 1 : 4));
        linkedHashMap.put("user_identity", Integer.valueOf(LoginData.getInstance().isQzoneVip() ? 1 : 0));
        linkedHashMap.put("default_pic_quality", Integer.valueOf(ph()));
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean3 = this.initBean;
        if (qZAlbumxUploadAlbumInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            qZAlbumxUploadAlbumInitBean2 = qZAlbumxUploadAlbumInitBean3;
        }
        String tianShuAdId = qZAlbumxUploadAlbumInitBean2.getTianShuAdId();
        if (tianShuAdId == null) {
            tianShuAdId = "";
        }
        linkedHashMap.put("qz_adid", tianShuAdId);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hkn;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_album_upload_new";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        this.publisherGamePlayPart.F9(newIntent);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        qh();
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        com.qzone.reborn.albumx.qzonex.part.upload.a aVar = null;
        if (qZAlbumxUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZAlbumxUploadAlbumInitBean = null;
        }
        if (qZAlbumxUploadAlbumInitBean.getIsLaunchSelectPhotoPage()) {
            QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean2 = this.initBean;
            if (qZAlbumxUploadAlbumInitBean2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initBean");
                qZAlbumxUploadAlbumInitBean2 = null;
            }
            qZAlbumxUploadAlbumInitBean2.setLaunchSelectPhotoPage(false);
            com.qzone.reborn.albumx.qzonex.part.upload.a aVar2 = this.mediaPickPart;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaPickPart");
            } else {
                aVar = aVar2;
            }
            aVar.ra();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[8];
        com.qzone.reborn.albumx.qzonex.part.upload.a aVar = this.mediaPickPart;
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPickPart");
            aVar = null;
        }
        partArr[0] = aVar;
        vl.e eVar = new vl.e();
        eVar.O9(l.a(R.string.f2195666r));
        eVar.M9(l.a(R.string.f2195766s));
        eVar.G9("em_qz_cancel_button");
        eVar.I9("em_qz_confirm_upload");
        Unit unit = Unit.INSTANCE;
        partArr[1] = eVar;
        ViewModel viewModel = getViewModel(qc.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxUpl\u2026BarViewModel::class.java)");
        com.qzone.reborn.part.publish.common.inputarea.c cVar = new com.qzone.reborn.part.publish.common.inputarea.c(new db.c((qc.e) viewModel));
        cVar.O9("em_qz_add_description");
        partArr[2] = cVar;
        partArr[3] = new QZoneInputKeyboardMenuPart(new db.a());
        partArr[4] = new QZoneScrollViewPart();
        QZAlbumxUploadSelectAlbumBarPart qZAlbumxUploadSelectAlbumBarPart = new QZAlbumxUploadSelectAlbumBarPart();
        qZAlbumxUploadSelectAlbumBarPart.J9(WinkDaTongReportConstant.ElementId.EM_QZ_SELECT_ALBUM);
        partArr[5] = qZAlbumxUploadSelectAlbumBarPart;
        partArr[6] = new t9.c();
        partArr[7] = new QZAlbumxUploadAlbumPart();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean2 = this.initBean;
        if (qZAlbumxUploadAlbumInitBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZAlbumxUploadAlbumInitBean2 = null;
        }
        if (qZAlbumxUploadAlbumInitBean2.getFromType() != 6) {
            sl.a aVar2 = new sl.a();
            aVar2.C9("em_qz_add_location");
            mutableListOf.add(aVar2);
            QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean3 = this.initBean;
            if (qZAlbumxUploadAlbumInitBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initBean");
                qZAlbumxUploadAlbumInitBean3 = null;
            }
            mutableListOf.add(new QZAlbumxUploadAlbumAuthorityBarPart(qZAlbumxUploadAlbumInitBean3));
            QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean4 = this.initBean;
            if (qZAlbumxUploadAlbumInitBean4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initBean");
            } else {
                qZAlbumxUploadAlbumInitBean = qZAlbumxUploadAlbumInitBean4;
            }
            if (qZAlbumxUploadAlbumInitBean.getFromType() != 7) {
                mutableListOf.add(new QZAlbumxUploadQualitySelectBarPart(getMFromDtPageId()));
            }
        }
        mutableListOf.add(new QZAlbumxUploadSelectLayoutMarginPart());
        mutableListOf.add(this.publisherGamePlayPart);
        mutableListOf.add(new qb.a("qzone_albumx_upload_album"));
        return mutableListOf;
    }
}
