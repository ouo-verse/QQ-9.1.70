package com.qzone.reborn.albumx.qzonex.fragment.layer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import bb.d;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.qzone.reborn.albumx.qzonex.part.layer.aa;
import com.qzone.reborn.albumx.qzonex.part.layer.ag;
import com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerBottomOperatePart;
import com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerHeaderPart;
import com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxBatchLayerSelectorPart;
import com.qzone.reborn.albumx.qzonex.part.layer.batch.QZAlbumxLayerSectionOperatePart;
import com.qzone.reborn.albumx.qzonex.part.layer.batch.f;
import com.qzone.reborn.albumx.qzonex.part.layer.u;
import com.qzone.reborn.albumx.qzonex.part.layer.z;
import com.qzone.reborn.feedx.util.m;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import hb.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oc.a;
import oc.e;
import p9.b;
import ub.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u001b\u001a\u00020\u000fH\u0014J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/layer/QZAlbumxBatchLayerFragment;", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "Lhb/c;", "Lbb/d;", "Lp9/b;", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Loc/a;", "E", "", "isOpenNavigationBarImmersive", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onBackEvent", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "th", "getPlayScene", "", "getDaTongPageId", "sh", "rh", "", "", "getChildDaTongDynamicParams", "Loc/e;", UserInfo.SEX_FEMALE, "Loc/e;", "albumDetailLayerViewModel", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxBatchLayerFragment extends CommonLayerFragment implements c<d> {

    /* renamed from: F, reason: from kotlin metadata */
    private e albumDetailLayerViewModel;

    private final b uh() {
        return new b();
    }

    @Override // hb.c
    public a<d> E() {
        return this.albumDetailLayerViewModel;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new com.qzone.reborn.albumx.qzonex.part.layer.batch.d());
        arrayList.add(new QZAlbumxLayerSectionOperatePart());
        arrayList.add(new QZAlbumxBatchLayerSelectorPart());
        arrayList.add(new QZAlbumxBatchLayerHeaderPart());
        arrayList.add(new QZAlbumxBatchLayerBottomOperatePart());
        arrayList.add(new z());
        arrayList.add(new aa());
        arrayList.add(new u());
        arrayList.add(new qb.a("qzone_albumx_batch_layer"));
        arrayList.add(new com.qzone.reborn.albumx.qzonex.part.layer.batch.e());
        return arrayList;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public Map<String, Object> getChildDaTongDynamicParams() {
        return super.getChildDaTongDynamicParams();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public String getDaTongPageId() {
        return "pg_qz_pic_large";
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 146;
    }

    @Override // com.tencent.richframework.gallery.RFWLayerFragment
    public boolean isOpenNavigationBarImmersive() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
        UIStateData<RFWLayerState> value;
        RFWLayerState data;
        String str;
        RFWLayerVideoInfo layerVideoInfo;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        RFWLayerPicInfo layerPicInfo2;
        Intent intent = new Intent();
        oc.b bVar = (oc.b) getViewModel(oc.b.class);
        RFWLayerViewModel rFWLayerViewModel = (RFWLayerViewModel) getViewModel(RFWLayerViewModel.class);
        m.b("extra_key_parcelable_selected_list_for_result_batch_layer", bVar.R1());
        QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean = new QZAlbumxBatchLayerSelectedMediaInfoBean();
        if (rFWLayerViewModel != null && (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) != null && (value = mutableLiveData.getValue()) != null && (data = value.getData()) != null) {
            RFWLayerItemMediaInfo selectedItemMedia = data.getSelectedItemMedia();
            String str2 = "";
            if (selectedItemMedia == null || (layerPicInfo2 = selectedItemMedia.getLayerPicInfo()) == null || (str = layerPicInfo2.getPicId()) == null) {
                str = "";
            }
            qZAlbumxBatchLayerSelectedMediaInfoBean.g(str);
            if (selectedItemMedia != null && (layerPicInfo = selectedItemMedia.getLayerPicInfo()) != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
                str2 = url;
            }
            qZAlbumxBatchLayerSelectedMediaInfoBean.k(str2);
            qZAlbumxBatchLayerSelectedMediaInfoBean.m((selectedItemMedia == null || (layerVideoInfo = selectedItemMedia.getLayerVideoInfo()) == null) ? 0 : layerVideoInfo.getVideoDurationSec());
            qZAlbumxBatchLayerSelectedMediaInfoBean.l(selectedItemMedia != null ? selectedItemMedia.isVideo() : false);
        }
        Unit unit = Unit.INSTANCE;
        intent.putExtra("batch_selector_result_cur_media", qZAlbumxBatchLayerSelectedMediaInfoBean);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        e eVar;
        QZAlbumxAlbumDetailInitBean e26;
        e eVar2;
        Intent intent;
        super.onCreate(savedInstanceState);
        this.albumDetailLayerViewModel = (e) getViewModel(e.class);
        FragmentActivity activity = getActivity();
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        boolean z16 = false;
        if (extras != null && extras.containsKey("key_album_detail_init_bean")) {
            z16 = true;
        }
        if (z16 && (eVar2 = this.albumDetailLayerViewModel) != null) {
            Object obj = extras.get("key_album_detail_init_bean");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean");
            eVar2.l2((QZAlbumxAlbumDetailInitBean) obj);
        }
        fj.a aVar = fj.a.f399444a;
        e eVar3 = this.albumDetailLayerViewModel;
        if (eVar3 == null || (e26 = eVar3.e2()) == null || (str = e26.getDataRepoKey()) == null) {
            str = "";
        }
        Object a16 = aVar.a(str);
        if (!(a16 instanceof k) || (eVar = this.albumDetailLayerViewModel) == null) {
            return;
        }
        eVar.k2((k) a16);
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(view, this, c.class);
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part rh() {
        return new f();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part sh() {
        b uh5 = uh();
        uh5.c(true);
        return new ag(uh5);
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 8;
    }
}
