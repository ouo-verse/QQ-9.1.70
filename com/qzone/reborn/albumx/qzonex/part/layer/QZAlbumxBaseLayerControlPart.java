package com.qzone.reborn.albumx.qzonex.part.layer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumExData;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000 W*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002:\u0001XB\u0007\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\u000eH\u0014J\b\u0010&\u001a\u00020%H$J\b\u0010'\u001a\u00020\u001aH\u0014J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0004J\b\u0010*\u001a\u00020\u0004H\u0014J\u0012\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010.\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010/\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u00101\u001a\u00020\u000eH\u0014J\b\u00102\u001a\u00020\u0004H\u0014R*\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010B\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010Q\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxBaseLayerControlPart;", "T", "Lcom/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "", "qa", "Landroid/os/Bundle;", "data", "wa", "xa", "", "id", "na", "extraInfoBean", "", "sa", "ua", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "bean", "za", "albumOwnerUin", LocaleUtils.L_JAPANESE, "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "Aa", "va", "", "getRefer", "ra", "initIntentData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "fetchLeft", "fetchRight", "X9", "U9", "Lbb/g;", "la", "N9", "Loc/a;", "oa", "pa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartPause", "onPartResume", "onLayerStateUpdate", "ta", "ha", "", "J", "Ljava/util/List;", "getInitExtraInfoList", "()Ljava/util/List;", "setInitExtraInfoList", "(Ljava/util/List;)V", "initExtraInfoList", "Lok/a;", "K", "Lok/a;", "ma", "()Lok/a;", "setMAlbumAdapter", "(Lok/a;)V", "mAlbumAdapter", "Loc/w;", "L", "Loc/w;", "getMLayerRecommendViewModel", "()Loc/w;", "setMLayerRecommendViewModel", "(Loc/w;)V", "mLayerRecommendViewModel", "M", "Ljava/lang/String;", "getMLayerRecommendViewBg", "()Ljava/lang/String;", "setMLayerRecommendViewBg", "(Ljava/lang/String;)V", "mLayerRecommendViewBg", "N", "Z", "mIsInRecomAlbumPage", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZAlbumxBaseLayerControlPart<T> extends CommonLayerControlPart<QZAlbumxLayerExtraInfoBean, T> {

    /* renamed from: J, reason: from kotlin metadata */
    private List<QZAlbumxLayerExtraInfoBean> initExtraInfoList;

    /* renamed from: K, reason: from kotlin metadata */
    private ok.a mAlbumAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private oc.w mLayerRecommendViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private String mLayerRecommendViewBg;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsInRecomAlbumPage;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxBaseLayerControlPart$b", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "uiStateData", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Observer<UIStateData<AlumBasicData>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZAlbumxBaseLayerControlPart<T> f53124d;

        b(QZAlbumxBaseLayerControlPart<T> qZAlbumxBaseLayerControlPart) {
            this.f53124d = qZAlbumxBaseLayerControlPart;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<AlumBasicData> uiStateData) {
            ok.a mAlbumAdapter;
            if (this.f53124d.getMAlbumAdapter() != null) {
                if ((uiStateData != null ? uiStateData.getData() : null) == null) {
                    return;
                }
                AlumBasicData data = uiStateData.getData();
                ok.a mAlbumAdapter2 = this.f53124d.getMAlbumAdapter();
                if (mAlbumAdapter2 != null) {
                    mAlbumAdapter2.x0(uiStateData.getMsg(), data);
                }
                if (!((QZAlbumxBaseLayerControlPart) this.f53124d).mIsInRecomAlbumPage || (mAlbumAdapter = this.f53124d.getMAlbumAdapter()) == null) {
                    return;
                }
                mAlbumAdapter.i0();
            }
        }
    }

    private final void Aa(RFWLayerState layerState) {
        RFWLayerPicInfo layerPicInfo;
        if (layerState.getMediaSum() - 1 == this.mSelectedPosition) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            this.mLayerRecommendViewBg = (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null) ? null : layerPicInfo.getMaxsizeFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String ja(String albumOwnerUin) {
        String a16;
        if (Intrinsics.areEqual(albumOwnerUin, LoginData.getInstance().getUinString())) {
            a16 = "\u6211";
        } else {
            a16 = com.qzone.reborn.albumx.qzonex.utils.j.f53413a.a(albumOwnerUin, "");
        }
        return a16 + "\u7684\u66f4\u591a\u76f8\u518c";
    }

    private final QZAlbumxLayerExtraInfoBean na(String id5) {
        List<QZAlbumxLayerExtraInfoBean> list = this.initExtraInfoList;
        if (list != null && !ArrayUtils.isOutOfArrayIndex(0, list)) {
            List<QZAlbumxLayerExtraInfoBean> list2 = this.initExtraInfoList;
            Intrinsics.checkNotNull(list2);
            for (QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean : list2) {
                if (sa(qZAlbumxLayerExtraInfoBean, id5)) {
                    return qZAlbumxLayerExtraInfoBean;
                }
            }
        }
        return null;
    }

    private final boolean sa(QZAlbumxLayerExtraInfoBean extraInfoBean, String id5) {
        return Intrinsics.areEqual(id5, extraInfoBean.getLLoc());
    }

    private final void va(RFWLayerState layerState) {
        if (layerState.getMediaSum() != 0 && layerState.getMediaSum() - this.mSelectedPosition <= 2) {
            RFWLog.d("QZAlbumxBaseLayerControlPart", RFWLog.CLR, "onLayerStateUpdate, layerState.mediaSum:" + layerState.getMediaSum() + " mSelectedPosition:" + this.mSelectedPosition + " requestRecommendAlbumInfo");
            oc.w wVar = this.mLayerRecommendViewModel;
            if (wVar != null) {
                wVar.b2();
            }
        }
    }

    private final void xa() {
        Intent intent;
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data = value.getData()) == null) ? null : data.getRichMediaDataList();
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        Intrinsics.checkNotNull(richMediaDataList);
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            String mediaId = rFWLayerItemMediaInfo.getMediaId();
            if (mediaId == null) {
                mediaId = "";
            }
            QZAlbumxLayerExtraInfoBean na5 = na(mediaId);
            if (na5 != null) {
                Activity activity = getActivity();
                na5.d0((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("key_qzone_id"));
            }
            rFWLayerItemMediaInfo.setExtraData(na5);
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void za(QZoneFeedxLayerRecommendPhotoBean bean) {
        String str;
        String mAlbumName;
        bean.refer = getRefer();
        bean.isShowBackView = false;
        bean.isDataIllegal = false;
        bean.isShowHasMoreBtn = true;
        RecomAlbumList recomAlbumList = new RecomAlbumList();
        recomAlbumList.mCanBeShown = true;
        List<AlbumCacheData> list = bean.albumCacheDataList;
        Intrinsics.checkNotNullExpressionValue(list, "bean.albumCacheDataList");
        for (AlbumCacheData albumCacheData : list) {
            recomAlbumList.recomAlbumList.add(albumCacheData);
            RecomAlbumExData recomAlbumExData = new RecomAlbumExData();
            recomAlbumExData.albumInfo = albumCacheData;
            recomAlbumList.recomAlbumVecExList.add(recomAlbumExData);
        }
        recomAlbumList.hasMore = bean.isShowHasMoreBtn;
        bean.recomAlbumList = recomAlbumList;
        bean.albumOwnerTitle = ja(String.valueOf(bean.albumOwnerUin));
        bean.isDefaultStyle = bean.albumCacheDataList.size() > 2;
        String str2 = this.mLayerRecommendViewBg;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        bean.backgroundUrl = str2;
        oc.w wVar = this.mLayerRecommendViewModel;
        if (wVar == null || (str = wVar.getMAlbumId()) == null) {
            str = "";
        }
        bean.layerAlbumId = str;
        oc.w wVar2 = this.mLayerRecommendViewModel;
        if (wVar2 != null && (mAlbumName = wVar2.getMAlbumName()) != null) {
            str3 = mAlbumName;
        }
        bean.layerAlbumName = str3;
        bean.moreBtnText = getContext().getString(R.string.f133125_);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected int N9() {
        return 3;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected boolean U9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public void X9(boolean fetchLeft, boolean fetchRight) {
        oc.a<T> oa5 = oa();
        bb.g la5 = la();
        la5.n(oa().getQzoneId());
        la5.k(oa().getLinkId());
        la5.g(fetchLeft);
        la5.h(fetchRight);
        la5.l(fetchLeft && fetchRight);
        oa5.U1(la5);
    }

    public abstract int getRefer();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        Serializable serializable = data != null ? data.getSerializable("key_init_data_list") : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean> }");
        this.initExtraInfoList = (ArrayList) serializable;
        wa(data);
        xa();
    }

    protected abstract bb.g la();

    /* renamed from: ma, reason: from getter */
    public final ok.a getMAlbumAdapter() {
        return this.mAlbumAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final oc.a<T> oa() {
        q9.a<T> L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.layer.QZAlbumxBaseLayerDataViewModel<T of com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxBaseLayerControlPart>");
        return (oc.a) L9;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        qa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        ok.a aVar;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        va(layerState);
        Aa(layerState);
        RFWLog.d("QZAlbumxBaseLayerControlPart", RFWLog.USR, "onLayerStateUpdate, layerState.mediaSum:" + layerState.getMediaSum() + " mSelectedPosition:" + this.mSelectedPosition);
        if (ta()) {
            RFWLog.d("QZAlbumxBaseLayerControlPart", RFWLog.USR, "onLayerStateUpdate, recommend album page selected");
            this.mIsInRecomAlbumPage = true;
            ok.a aVar2 = this.mAlbumAdapter;
            if (aVar2 != null) {
                aVar2.v0(true);
            }
            ok.a aVar3 = this.mAlbumAdapter;
            if (aVar3 != null) {
                aVar3.i0();
            }
            ok.a aVar4 = this.mAlbumAdapter;
            if (aVar4 != null) {
                aVar4.r0();
            }
            broadcastMessage("HIDE_ORIGINAL_PIC_BUTTON", null);
            broadcastMessage("LAYER_TITLE_CONTAINER_HIDE", null);
            broadcastMessage("FEEDX_LAYER_DANMU_HIDE", null);
            return;
        }
        if (this.mIsInRecomAlbumPage && (aVar = this.mAlbumAdapter) != null) {
            aVar.s0();
        }
        ok.a aVar5 = this.mAlbumAdapter;
        if (aVar5 != null) {
            aVar5.v0(false);
        }
        this.mIsInRecomAlbumPage = false;
        ok.a aVar6 = this.mAlbumAdapter;
        if (aVar6 != null) {
            aVar6.n0();
        }
        broadcastMessage("LAYER_TITLE_CONTAINER_SHOW", null);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        ok.a aVar = this.mAlbumAdapter;
        if (aVar != null) {
            aVar.onPartDestroy(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        ok.a aVar = this.mAlbumAdapter;
        if (aVar != null) {
            aVar.onPartPause(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        ok.a aVar = this.mAlbumAdapter;
        if (aVar != null) {
            aVar.onPartResume(activity);
        }
    }

    protected void pa() {
        if (this.mAlbumAdapter != null) {
            return;
        }
        ViewPager2 viewPager = getViewPager();
        if ((viewPager != null ? viewPager.getAdapter() : null) instanceof RFWConcatAdapter) {
            this.mLayerRecommendViewModel = (oc.w) getViewModel(oc.w.class);
            this.mAlbumAdapter = new ok.a();
        }
    }

    public boolean ra() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean ta() {
        boolean z16;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        boolean contains;
        if (this.mAlbumAdapter == null || x9() != null) {
            return false;
        }
        ok.a aVar = this.mAlbumAdapter;
        Intrinsics.checkNotNull(aVar);
        if (!aVar.m0()) {
            ViewPager2 viewPager = getViewPager();
            RecyclerView.Adapter adapter = viewPager != null ? viewPager.getAdapter() : null;
            RFWConcatAdapter rFWConcatAdapter = adapter instanceof RFWConcatAdapter ? (RFWConcatAdapter) adapter : null;
            if (rFWConcatAdapter != null && (adapters = rFWConcatAdapter.getAdapters()) != null) {
                ok.a aVar2 = this.mAlbumAdapter;
                Intrinsics.checkNotNull(aVar2);
                contains = CollectionsKt___CollectionsKt.contains(adapters, aVar2);
                if (contains) {
                    z16 = true;
                    if (!z16) {
                        return false;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void qa() {
        String str;
        QLog.d("QZAlbumxBaseLayerControlPart", 1, "initRecommendViewModel");
        pa();
        List<QZAlbumxLayerExtraInfoBean> list = this.initExtraInfoList;
        String str2 = "";
        if ((list != null ? list.size() : 0) > 0 && ra()) {
            List<QZAlbumxLayerExtraInfoBean> list2 = this.initExtraInfoList;
            Intrinsics.checkNotNull(list2);
            str = list2.get(0).getAlbumId();
        }
        str = "";
        List<QZAlbumxLayerExtraInfoBean> list3 = this.initExtraInfoList;
        if ((list3 != null ? list3.size() : 0) > 0 && ra()) {
            List<QZAlbumxLayerExtraInfoBean> list4 = this.initExtraInfoList;
            Intrinsics.checkNotNull(list4);
            String albumName = list4.get(0).getAlbumName();
            if (albumName != null) {
                str2 = albumName;
            }
        }
        oc.w wVar = this.mLayerRecommendViewModel;
        if (wVar != null) {
            wVar.W1(oa().getQzoneId(), str, str2, getRefer());
        }
        ha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua() {
        MutableLiveData<UIStateData<AlumBasicData>> R1;
        QLog.d("QZAlbumxBaseLayerControlPart", 1, "requestRecommendAd");
        oc.w wVar = this.mLayerRecommendViewModel;
        if (wVar != null && (R1 = wVar.R1()) != null) {
            R1.observe(getHostFragment(), new b(this));
        }
        oc.w wVar2 = this.mLayerRecommendViewModel;
        if (wVar2 != null) {
            wVar2.Z1();
        }
    }

    protected void ha() {
        MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> U1;
        QLog.d("QZAlbumxBaseLayerControlPart", 1, "addRecommendAdapter");
        oc.w wVar = this.mLayerRecommendViewModel;
        if (wVar == null || (U1 = wVar.U1()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<QZoneFeedxLayerRecommendPhotoBean>, Unit> function1 = new Function1<UIStateData<QZoneFeedxLayerRecommendPhotoBean>, Unit>(this) { // from class: com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxBaseLayerControlPart$addRecommendAdapter$1
            final /* synthetic */ QZAlbumxBaseLayerControlPart<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneFeedxLayerRecommendPhotoBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneFeedxLayerRecommendPhotoBean> uIStateData) {
                QZoneFeedxLayerRecommendPhotoBean bean;
                List<AlbumCacheData> list;
                if (uIStateData != null) {
                    ViewPager2 viewPager = this.this$0.getViewPager();
                    if (!((viewPager != null ? viewPager.getAdapter() : null) instanceof RFWConcatAdapter) || (list = (bean = uIStateData.getData()).albumCacheDataList) == null || list.size() < 2) {
                        return;
                    }
                    QZAlbumxBaseLayerControlPart<T> qZAlbumxBaseLayerControlPart = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(bean, "bean");
                    qZAlbumxBaseLayerControlPart.za(bean);
                    ok.a mAlbumAdapter = this.this$0.getMAlbumAdapter();
                    Intrinsics.checkNotNull(mAlbumAdapter);
                    mAlbumAdapter.y0(bean);
                    ViewPager2 viewPager2 = this.this$0.getViewPager();
                    RecyclerView.Adapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter");
                    ok.a mAlbumAdapter2 = this.this$0.getMAlbumAdapter();
                    Intrinsics.checkNotNull(mAlbumAdapter2);
                    ((RFWConcatAdapter) adapter).addAdapter(mAlbumAdapter2);
                    this.this$0.ua();
                }
            }
        };
        U1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxBaseLayerControlPart.ia(Function1.this, obj);
            }
        });
    }

    private final void wa(Bundle data) {
        if (data != null) {
            String str = "";
            if (data.containsKey("key_attach_info")) {
                oc.a<T> oa5 = oa();
                String string = data.getString("key_attach_info");
                if (string == null) {
                    string = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string, "it.getString(QZAlbumxGal\u2026er.KEY_ATTACH_INFO) ?: \"\"");
                }
                oa5.Z1(string);
            }
            if (data.containsKey("key_qzone_id")) {
                oc.a<T> oa6 = oa();
                String string2 = data.getString("key_qzone_id");
                if (string2 == null) {
                    string2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string2, "it.getString(QZAlbumxGal\u2026ncher.KEY_QZONE_ID) ?: \"\"");
                }
                oa6.X1(string2);
            }
            if (data.containsKey("key_link_id")) {
                oc.a<T> oa7 = oa();
                String string3 = data.getString("key_link_id");
                if (string3 != null) {
                    Intrinsics.checkNotNullExpressionValue(string3, "it.getString(QZAlbumxGal\u2026uncher.KEY_LINK_ID) ?: \"\"");
                    str = string3;
                }
                oa7.W1(str);
            }
        }
    }
}
