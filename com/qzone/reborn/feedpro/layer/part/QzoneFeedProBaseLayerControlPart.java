package com.qzone.reborn.feedpro.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerListBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerRouteBean;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
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
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 T2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020 H\u0004J\b\u0010\"\u001a\u00020\u0010H\u0014J\b\u0010$\u001a\u00020#H$J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0016\u0010+\u001a\u00020*2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0014J\u0012\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010/\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u00100\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u00102\u001a\u00020\u0010H\u0014J\b\u00103\u001a\u00020\u0004H\u0014J\b\u00105\u001a\u000204H\u0014J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0003H\u0014J\u001c\u0010:\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u00010\u00122\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010;\u001a\u00020\u0010H\u0016R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/QzoneFeedProBaseLayerControlPart;", "Lcom/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerListBean;", "", "ra", "pa", "qa", "Landroid/os/Bundle;", "data", "wa", "za", "", "id", "oa", "extraInfoBean", "", "sa", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "va", "Ba", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "bean", "Aa", "albumOwnerUin", LocaleUtils.L_JAPANESE, "ua", "initIntentData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lke/b;", "ma", "U9", "Lge/g;", "na", "fetchLeft", "fetchRight", "X9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Lo9/e;", "R9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartResume", "onPartPause", "onLayerStateUpdate", "ta", "ha", "", "N9", "layerListBean", "xa", "preLayerState", "newLayerState", "H9", "onBackEvent", "Lok/a;", "J", "Lok/a;", "la", "()Lok/a;", "setAlbumAdapter", "(Lok/a;)V", "albumAdapter", "Lke/f;", "K", "Lke/f;", "layerRecommendViewModel", "Lke/d;", "L", "Lke/d;", "layerOperateViewModel", "M", "Ljava/lang/String;", "layerRecommendViewBg", "N", "Z", "isInRecommendPage", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneFeedProBaseLayerControlPart extends CommonLayerControlPart<QzoneFeedProLayerExtraInfoBean, QzoneFeedProLayerListBean> {

    /* renamed from: J, reason: from kotlin metadata */
    private ok.a albumAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private ke.f layerRecommendViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private ke.d layerOperateViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private String layerRecommendViewBg;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isInRecommendPage;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedpro/layer/part/QzoneFeedProBaseLayerControlPart$b", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "uiStateData", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Observer<UIStateData<AlumBasicData>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<AlumBasicData> uiStateData) {
            ok.a albumAdapter;
            if (QzoneFeedProBaseLayerControlPart.this.getAlbumAdapter() != null) {
                if ((uiStateData != null ? uiStateData.getData() : null) == null) {
                    return;
                }
                AlumBasicData data = uiStateData.getData();
                ok.a albumAdapter2 = QzoneFeedProBaseLayerControlPart.this.getAlbumAdapter();
                if (albumAdapter2 != null) {
                    albumAdapter2.x0(uiStateData.getMsg(), data);
                }
                if (!QzoneFeedProBaseLayerControlPart.this.isInRecommendPage || (albumAdapter = QzoneFeedProBaseLayerControlPart.this.getAlbumAdapter()) == null) {
                    return;
                }
                albumAdapter.i0();
            }
        }
    }

    private final void Ba(RFWLayerState layerState) {
        RFWLayerPicInfo layerPicInfo;
        if (layerState.getMediaSum() - 1 == this.mSelectedPosition) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            this.layerRecommendViewBg = (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null) ? null : layerPicInfo.getMaxsizeFile();
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

    private final QzoneFeedProLayerExtraInfoBean oa(String id5) {
        if (ArrayUtils.isOutOfArrayIndex(0, ma().S1())) {
            return null;
        }
        List<QzoneFeedProLayerExtraInfoBean> S1 = ma().S1();
        Intrinsics.checkNotNull(S1);
        for (QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean : S1) {
            if (sa(qzoneFeedProLayerExtraInfoBean, id5)) {
                return qzoneFeedProLayerExtraInfoBean;
            }
        }
        return null;
    }

    private final void pa() {
        ke.d dVar = (ke.d) getViewModel(ke.d.class);
        this.layerOperateViewModel = dVar;
        if (dVar != null) {
            dVar.U1(ma().getCommonFeed(), ma().getForwardFeed(), ma().getOwner(), ma().getLikeKey());
        }
    }

    private final void qa() {
        if (this.albumAdapter != null) {
            return;
        }
        ViewPager2 viewPager = getViewPager();
        if ((viewPager != null ? viewPager.getAdapter() : null) instanceof RFWConcatAdapter) {
            this.layerRecommendViewModel = (ke.f) getViewModel(ke.f.class);
            this.albumAdapter = new ok.a();
        }
    }

    private final void ra() {
        ke.f fVar = this.layerRecommendViewModel;
        if (fVar != null) {
            QzoneFeedProLayerExtraInfoBean x95 = x9();
            fVar.T1(x95 != null ? x95.getAlbumId() : null, ma().getOwner(), 1);
        }
    }

    private final boolean sa(QzoneFeedProLayerExtraInfoBean extraInfoBean, String id5) {
        return Intrinsics.areEqual(id5, extraInfoBean.getLLoc());
    }

    private final void va(RFWLayerState layerState) {
        ke.f fVar;
        if (layerState.getMediaSum() != 0 && je.a.K(layerState) - this.mSelectedPosition <= 2) {
            QLog.d("QzoneFeedProBaseLayerControlPart", 2, "onLayerStateUpdate, layerState.mediaSum:" + layerState.getMediaSum() + " mSelectedPosition:" + this.mSelectedPosition + " requestRecommendAlbumInfo");
            if (ma().getForwardFeed() != null || (fVar = this.layerRecommendViewModel) == null) {
                return;
            }
            fVar.X1();
        }
    }

    private final void za() {
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
            rFWLayerItemMediaInfo.setExtraData(oa(mediaId));
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected int N9() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public o9.e R9(UIStateData<QzoneFeedProLayerListBean> uiStateData) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        RFWLayerState data2;
        List<RFWLayerItemMediaInfo> richMediaDataList2;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        o9.e eVar = new o9.e();
        QzoneFeedProLayerListBean data3 = uiStateData.getData();
        if (data3 == null) {
            return eVar;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setMediaSum(data3.getMediumSum());
        if (data3.getIsDeleteChange()) {
            if (data3.g().isEmpty()) {
                Activity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else {
                rFWLayerState.setRichMediaDataList(data3.g());
            }
        } else if (data3.getIsRefresh()) {
            rFWLayerState.setRichMediaDataList(data3.g());
        } else if (data3.getIsFetchLeft()) {
            ArrayList arrayList = new ArrayList(data3.g());
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value != null && (data2 = value.getData()) != null && (richMediaDataList2 = data2.getRichMediaDataList()) != null) {
                arrayList.addAll(richMediaDataList2);
            }
            rFWLayerState.setRichMediaDataList(arrayList);
        } else if (data3.getIsFetchRight()) {
            ArrayList arrayList2 = new ArrayList();
            UIStateData<RFWLayerState> value2 = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value2 != null && (data = value2.getData()) != null && (richMediaDataList = data.getRichMediaDataList()) != null) {
                arrayList2.addAll(richMediaDataList);
            }
            arrayList2.addAll(data3.g());
            rFWLayerState.setRichMediaDataList(arrayList2);
        }
        if (data3.getIsFetchLeft()) {
            Y9(data3.getIsLeftFinish());
        }
        if (data3.getIsFetchRight()) {
            aa(data3.getIsRightFinish());
        }
        if (data3.getIsRefresh()) {
            Z9(true);
        }
        xa(data3);
        UIStateData<RFWLayerState> rfwLayerInfoUIStateData = UIStateData.obtainSuccess(false);
        eVar.c(rFWLayerState);
        Intrinsics.checkNotNullExpressionValue(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        eVar.d(rfwLayerInfoUIStateData);
        String tag = getTAG();
        int i3 = RFWLog.USR;
        List<RFWLayerItemMediaInfo> richMediaDataList3 = rFWLayerState.getRichMediaDataList();
        Integer valueOf = richMediaDataList3 != null ? Integer.valueOf(richMediaDataList3.size()) : null;
        RFWLog.i(tag, i3, "media list size is " + valueOf + " is refresh " + data3.getIsRefresh());
        return eVar;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected boolean U9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public void X9(boolean fetchLeft, boolean fetchRight) {
        ke.b ma5 = ma();
        ge.g na5 = na();
        na5.h(fetchLeft);
        na5.i(fetchRight);
        na5.l(fetchLeft && fetchRight);
        ma5.d2(na5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        wa(data);
        za();
    }

    /* renamed from: la, reason: from getter */
    public final ok.a getAlbumAdapter() {
        return this.albumAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ke.b ma() {
        q9.a<QzoneFeedProLayerListBean> L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.viewmodel.QzoneFeedProBaseLayerViewModel");
        return (ke.b) L9;
    }

    protected abstract ge.g na();

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        int size = (value == null || (data = value.getData()) == null || (richMediaDataList = data.getRichMediaDataList()) == null) ? 0 : richMediaDataList.size();
        if (getViewPager() != null && this.isInRecommendPage && size >= 1) {
            ViewPager2 viewPager = getViewPager();
            Intrinsics.checkNotNull(viewPager);
            viewPager.setCurrentItem(size - 1, false);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        qa();
        ra();
        ha();
        pa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        ok.a aVar;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        va(layerState);
        Ba(layerState);
        QLog.d("QzoneFeedProBaseLayerControlPart", 1, "onLayerStateUpdate, layerState.mediaSum:" + layerState.getMediaSum() + " mSelectedPosition:" + this.mSelectedPosition);
        if (ta()) {
            this.isInRecommendPage = true;
            ok.a aVar2 = this.albumAdapter;
            if (aVar2 != null) {
                aVar2.v0(true);
            }
            ok.a aVar3 = this.albumAdapter;
            if (aVar3 != null) {
                aVar3.i0();
            }
            ok.a aVar4 = this.albumAdapter;
            if (aVar4 != null) {
                aVar4.r0();
            }
            broadcastMessage("HIDE_ORIGINAL_PIC_BUTTON", null);
            broadcastMessage("LAYER_TITLE_CONTAINER_HIDE", null);
            broadcastMessage("FEEDX_LAYER_DANMU_HIDE", null);
            return;
        }
        if (this.isInRecommendPage && (aVar = this.albumAdapter) != null) {
            aVar.s0();
        }
        ok.a aVar5 = this.albumAdapter;
        if (aVar5 != null) {
            aVar5.v0(false);
        }
        this.isInRecommendPage = false;
        ok.a aVar6 = this.albumAdapter;
        if (aVar6 != null) {
            aVar6.n0();
        }
        broadcastMessage("LAYER_TITLE_CONTAINER_SHOW", null);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        ok.a aVar = this.albumAdapter;
        if (aVar != null) {
            aVar.onPartDestroy(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        ok.a aVar = this.albumAdapter;
        if (aVar != null) {
            aVar.onPartPause(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        ok.a aVar = this.albumAdapter;
        if (aVar != null) {
            aVar.onPartResume(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean ta() {
        boolean z16;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        boolean contains;
        if (this.albumAdapter == null || x9() != null) {
            return false;
        }
        ok.a aVar = this.albumAdapter;
        Intrinsics.checkNotNull(aVar);
        if (!aVar.m0()) {
            ViewPager2 viewPager = getViewPager();
            RecyclerView.Adapter adapter = viewPager != null ? viewPager.getAdapter() : null;
            RFWConcatAdapter rFWConcatAdapter = adapter instanceof RFWConcatAdapter ? (RFWConcatAdapter) adapter : null;
            if (rFWConcatAdapter != null && (adapters = rFWConcatAdapter.getAdapters()) != null) {
                ok.a aVar2 = this.albumAdapter;
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

    protected void xa(QzoneFeedProLayerListBean layerListBean) {
        Intrinsics.checkNotNullParameter(layerListBean, "layerListBean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa(QZoneFeedxLayerRecommendPhotoBean bean) {
        String str;
        String albumName;
        bean.refer = 1;
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
        String str2 = this.layerRecommendViewBg;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        bean.backgroundUrl = str2;
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getAlbumId()) == null) {
            str = "";
        }
        bean.layerAlbumId = str;
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        if (x96 != null && (albumName = x96.getAlbumName()) != null) {
            str3 = albumName;
        }
        bean.layerAlbumName = str3;
        bean.moreBtnText = getContext().getString(R.string.f133125_);
        HashMap<String, Object> hashMap = bean.extraParams;
        if (hashMap != null) {
            hashMap.put("albumid", bean.layerAlbumId);
            hashMap.put("album_name", bean.layerAlbumName);
            hashMap.put(QZoneDTLoginReporter.PAGE_STYLE, 1);
            hashMap.put("come_from", Integer.valueOf(!TextUtils.isEmpty(bean.layerAlbumName) ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua() {
        MutableLiveData<UIStateData<AlumBasicData>> R1;
        QLog.d("QzoneFeedProBaseLayerControlPart", 1, "requestRecommendAd");
        ke.f fVar = this.layerRecommendViewModel;
        if (fVar != null && (R1 = fVar.R1()) != null) {
            R1.observe(getHostFragment(), new b());
        }
        ke.f fVar2 = this.layerRecommendViewModel;
        if (fVar2 != null) {
            fVar2.U1();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void H9(RFWLayerState preLayerState, RFWLayerState newLayerState) {
        QLog.i("QzoneFeedProBaseLayerControlPart", 1, "adjustSelectPositionWhenNotFindPreItem");
        if (!this.isInRecommendPage || newLayerState == null) {
            return;
        }
        List<RFWLayerItemMediaInfo> richMediaDataList = newLayerState.getRichMediaDataList();
        newLayerState.setSelectedPosition(richMediaDataList != null ? richMediaDataList.size() : 0);
    }

    protected void ha() {
        MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> S1;
        QLog.d("QzoneFeedProBaseLayerControlPart", 1, "addRecommendAdapter");
        ke.f fVar = this.layerRecommendViewModel;
        if (fVar == null || (S1 = fVar.S1()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<QZoneFeedxLayerRecommendPhotoBean>, Unit> function1 = new Function1<UIStateData<QZoneFeedxLayerRecommendPhotoBean>, Unit>() { // from class: com.qzone.reborn.feedpro.layer.part.QzoneFeedProBaseLayerControlPart$addRecommendAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
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
                    ViewPager2 viewPager = QzoneFeedProBaseLayerControlPart.this.getViewPager();
                    if (!((viewPager != null ? viewPager.getAdapter() : null) instanceof RFWConcatAdapter) || (list = (bean = uIStateData.getData()).albumCacheDataList) == null || list.size() < 2 || QzoneFeedProBaseLayerControlPart.this.getAlbumAdapter() == null) {
                        return;
                    }
                    QzoneFeedProBaseLayerControlPart qzoneFeedProBaseLayerControlPart = QzoneFeedProBaseLayerControlPart.this;
                    Intrinsics.checkNotNullExpressionValue(bean, "bean");
                    qzoneFeedProBaseLayerControlPart.Aa(bean);
                    ok.a albumAdapter = QzoneFeedProBaseLayerControlPart.this.getAlbumAdapter();
                    Intrinsics.checkNotNull(albumAdapter);
                    albumAdapter.y0(bean);
                    ViewPager2 viewPager2 = QzoneFeedProBaseLayerControlPart.this.getViewPager();
                    RecyclerView.Adapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter");
                    ok.a albumAdapter2 = QzoneFeedProBaseLayerControlPart.this.getAlbumAdapter();
                    Intrinsics.checkNotNull(albumAdapter2);
                    ((RFWConcatAdapter) adapter).addAdapter(albumAdapter2);
                    QzoneFeedProBaseLayerControlPart.this.ua();
                }
            }
        };
        S1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.feedpro.layer.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProBaseLayerControlPart.ia(Function1.this, obj);
            }
        });
    }

    private final void wa(Bundle data) {
        QzoneFeedProLayerRouteBean qzoneFeedProLayerRouteBean;
        if (data != null && data.containsKey("key_route_bean") && (qzoneFeedProLayerRouteBean = (QzoneFeedProLayerRouteBean) data.getParcelable("key_route_bean")) != null) {
            ma().h2(qzoneFeedProLayerRouteBean.q());
            ma().f2(qzoneFeedProLayerRouteBean.getFeedId());
            ma().l2(qzoneFeedProLayerRouteBean.getUfKey());
            ma().m2(qzoneFeedProLayerRouteBean.getUgcId());
            ma().i2(qzoneFeedProLayerRouteBean.getLikeKey());
            ma().k2(qzoneFeedProLayerRouteBean.getContextHashCode());
        }
        ke.b ma5 = ma();
        com.qzone.reborn.feedpro.utils.b bVar = com.qzone.reborn.feedpro.utils.b.f54315a;
        ma5.e2((CommonFeed) bVar.a("key_common_feed", ma().getRouteContextHashCode(), CommonFeed.class));
        ma().g2((CommonFeed) bVar.a("key_common_forward_feed", ma().getRouteContextHashCode(), CommonFeed.class));
        ma().n2((CommonUnionID) bVar.a("key_common_union_id", ma().getRouteContextHashCode(), CommonUnionID.class));
        ma().j2((CommonUser) bVar.a("key_common_user", ma().getRouteContextHashCode(), CommonUser.class));
    }
}
