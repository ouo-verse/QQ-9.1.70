package com.qzone.reborn.groupalbum.layer.part;

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
import com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.qzone.reborn.groupalbum.viewmodel.af;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
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

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000 Z2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0014J\b\u0010#\u001a\u00020\"H$J\b\u0010$\u001a\u00020\u0018H\u0014J\u0016\u0010(\u001a\u00020'2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0014J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0003H\u0014J\b\u0010,\u001a\u00020+H\u0004J\b\u0010-\u001a\u00020\u0004H\u0014J\u0012\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00101\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00102\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u00104\u001a\u00020\u000eH\u0014J\b\u00105\u001a\u00020\u0004H\u0014R*\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010T\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumBaseLayerControlPart;", "Lcom/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart;", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "Lci/e;", "", "pa", "Landroid/os/Bundle;", "data", "ua", "wa", "", "id", "na", "extraInfoBean", "", "qa", "sa", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "bean", "xa", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "za", "ta", "", "getRefer", "initIntentData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "fetchLeft", "fetchRight", "X9", "U9", "Lci/h;", "la", "N9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Lo9/e;", "R9", "layerListBean", "va", "Lii/a;", LocaleUtils.L_JAPANESE, "oa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartPause", "onPartResume", "onLayerStateUpdate", "ra", "ha", "", "J", "Ljava/util/List;", "getInitExtraInfoList", "()Ljava/util/List;", "setInitExtraInfoList", "(Ljava/util/List;)V", "initExtraInfoList", "Lok/a;", "K", "Lok/a;", "ma", "()Lok/a;", "setMAlbumAdapter", "(Lok/a;)V", "mAlbumAdapter", "Lcom/qzone/reborn/groupalbum/viewmodel/af;", "L", "Lcom/qzone/reborn/groupalbum/viewmodel/af;", "getMLayerRecommendViewModel", "()Lcom/qzone/reborn/groupalbum/viewmodel/af;", "setMLayerRecommendViewModel", "(Lcom/qzone/reborn/groupalbum/viewmodel/af;)V", "mLayerRecommendViewModel", "M", "Ljava/lang/String;", "getMLayerRecommendViewBg", "()Ljava/lang/String;", "setMLayerRecommendViewBg", "(Ljava/lang/String;)V", "mLayerRecommendViewBg", "N", "Z", "mIsInRecomAlbumPage", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class GroupAlbumBaseLayerControlPart extends CommonLayerControlPart<GroupAlbumLayerExtraInfoBean, ci.e> {

    /* renamed from: J, reason: from kotlin metadata */
    private List<GroupAlbumLayerExtraInfoBean> initExtraInfoList;

    /* renamed from: K, reason: from kotlin metadata */
    private ok.a mAlbumAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private af mLayerRecommendViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private String mLayerRecommendViewBg;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsInRecomAlbumPage;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/groupalbum/layer/part/GroupAlbumBaseLayerControlPart$b", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "uiStateData", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Observer<UIStateData<AlumBasicData>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<AlumBasicData> uiStateData) {
            ok.a mAlbumAdapter;
            if (GroupAlbumBaseLayerControlPart.this.getMAlbumAdapter() != null) {
                if ((uiStateData != null ? uiStateData.getData() : null) == null) {
                    return;
                }
                AlumBasicData data = uiStateData.getData();
                ok.a mAlbumAdapter2 = GroupAlbumBaseLayerControlPart.this.getMAlbumAdapter();
                if (mAlbumAdapter2 != null) {
                    mAlbumAdapter2.x0(uiStateData.getMsg(), data);
                }
                if (!GroupAlbumBaseLayerControlPart.this.mIsInRecomAlbumPage || (mAlbumAdapter = GroupAlbumBaseLayerControlPart.this.getMAlbumAdapter()) == null) {
                    return;
                }
                mAlbumAdapter.i0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void pa() {
        String str;
        oa();
        List<GroupAlbumLayerExtraInfoBean> list = this.initExtraInfoList;
        String str2 = "";
        if ((list != null ? list.size() : 0) > 0) {
            List<GroupAlbumLayerExtraInfoBean> list2 = this.initExtraInfoList;
            Intrinsics.checkNotNull(list2);
            str = list2.get(0).getAlbumId();
        }
        str = "";
        List<GroupAlbumLayerExtraInfoBean> list3 = this.initExtraInfoList;
        if ((list3 != null ? list3.size() : 0) > 0) {
            List<GroupAlbumLayerExtraInfoBean> list4 = this.initExtraInfoList;
            Intrinsics.checkNotNull(list4);
            String albumName = list4.get(0).getAlbumName();
            if (albumName != null) {
                str2 = albumName;
            }
        }
        af afVar = this.mLayerRecommendViewModel;
        if (afVar != null) {
            afVar.W1(ja().getGroupId(), str, str2);
        }
        ha();
    }

    private final boolean qa(GroupAlbumLayerExtraInfoBean extraInfoBean, String id5) {
        return Intrinsics.areEqual(id5, extraInfoBean.getLLoc());
    }

    private final void ta(RFWLayerState layerState) {
        if (layerState.getMediaSum() != 0 && layerState.getMediaSum() - this.mSelectedPosition <= 1) {
            RFWLog.d("GroupAlbumBaseLayerControlPart", RFWLog.CLR, "onLayerStateUpdate, layerState.mediaSum:" + layerState.getMediaSum() + " mSelectedPosition:" + this.mSelectedPosition + " requestRecommendAlbumInfo");
            af afVar = this.mLayerRecommendViewModel;
            if (afVar != null) {
                afVar.b2();
            }
        }
    }

    private final void wa() {
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
            GroupAlbumLayerExtraInfoBean na5 = na(mediaId);
            if (na5 != null) {
                Activity activity = getActivity();
                na5.y((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra(MiniAppTranRoomIdServlet.KEY_GROUP_ID));
            }
            rFWLayerItemMediaInfo.setExtraData(na5);
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(QZoneFeedxLayerRecommendPhotoBean bean) {
        String str;
        String mAlbumName;
        bean.refer = getRefer();
        bean.isShowBackView = false;
        bean.isDataIllegal = false;
        bean.isShowUserHomeEntrance = false;
        bean.isShowHasMoreBtn = true;
        bean.isShowUserIcon = false;
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
        bean.albumOwnerTitle = "\u672c\u7fa4\u7684\u66f4\u591a\u76f8\u518c";
        bean.isDefaultStyle = bean.albumCacheDataList.size() > 2;
        String str2 = this.mLayerRecommendViewBg;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        bean.backgroundUrl = str2;
        af afVar = this.mLayerRecommendViewModel;
        if (afVar == null || (str = afVar.getMAlbumId()) == null) {
            str = "";
        }
        bean.layerAlbumId = str;
        af afVar2 = this.mLayerRecommendViewModel;
        if (afVar2 != null && (mAlbumName = afVar2.getMAlbumName()) != null) {
            str3 = mAlbumName;
        }
        bean.layerAlbumName = str3;
        bean.moreBtnText = getContext().getString(R.string.f133125_);
    }

    private final void za(RFWLayerState layerState) {
        RFWLayerPicInfo layerPicInfo;
        if (layerState.getMediaSum() - 1 == this.mSelectedPosition) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            this.mLayerRecommendViewBg = (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null) ? null : layerPicInfo.getMaxsizeFile();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected int N9() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public o9.e R9(UIStateData<ci.e> uiStateData) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        RFWLayerState data2;
        List<RFWLayerItemMediaInfo> richMediaDataList2;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        o9.e eVar = new o9.e();
        ci.e data3 = uiStateData.getData();
        if (data3 == null) {
            return eVar;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setMediaSum(data3.getMediumSum());
        if (data3.getIsRefresh()) {
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
        Y9(data3.getIsLeftFinish());
        aa(data3.getIsRightFinish());
        if (data3.getIsRefresh()) {
            Z9(true);
        }
        va(data3);
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
        ii.a ja5 = ja();
        ci.h la5 = la();
        la5.n(ja().getGroupId());
        la5.k(ja().getBatchId());
        la5.l(fetchLeft);
        la5.m(fetchRight);
        la5.q(fetchLeft && fetchRight);
        ja5.X1(la5);
    }

    public abstract int getRefer();

    protected void ha() {
        MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> U1;
        af afVar = this.mLayerRecommendViewModel;
        if (afVar == null || (U1 = afVar.U1()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<QZoneFeedxLayerRecommendPhotoBean>, Unit> function1 = new Function1<UIStateData<QZoneFeedxLayerRecommendPhotoBean>, Unit>() { // from class: com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart$addRecommendAdapter$1
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
                    ViewPager2 viewPager = GroupAlbumBaseLayerControlPart.this.getViewPager();
                    if (!((viewPager != null ? viewPager.getAdapter() : null) instanceof RFWConcatAdapter) || (list = (bean = uIStateData.getData()).albumCacheDataList) == null || list.size() < 2) {
                        return;
                    }
                    GroupAlbumBaseLayerControlPart groupAlbumBaseLayerControlPart = GroupAlbumBaseLayerControlPart.this;
                    Intrinsics.checkNotNullExpressionValue(bean, "bean");
                    groupAlbumBaseLayerControlPart.xa(bean);
                    ok.a mAlbumAdapter = GroupAlbumBaseLayerControlPart.this.getMAlbumAdapter();
                    Intrinsics.checkNotNull(mAlbumAdapter);
                    mAlbumAdapter.y0(bean);
                    ViewPager2 viewPager2 = GroupAlbumBaseLayerControlPart.this.getViewPager();
                    RecyclerView.Adapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter");
                    ok.a mAlbumAdapter2 = GroupAlbumBaseLayerControlPart.this.getMAlbumAdapter();
                    Intrinsics.checkNotNull(mAlbumAdapter2);
                    ((RFWConcatAdapter) adapter).addAdapter(mAlbumAdapter2);
                    GroupAlbumBaseLayerControlPart.this.sa();
                }
            }
        };
        U1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.groupalbum.layer.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumBaseLayerControlPart.ia(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        Serializable serializable = data != null ? data.getSerializable("key_init_data_list") : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean> }");
        this.initExtraInfoList = (ArrayList) serializable;
        ua(data);
        wa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ii.a ja() {
        q9.a<ci.e> L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.layer.viewmodel.GroupAlbumBaseLayerDataViewModel");
        return (ii.a) L9;
    }

    protected abstract ci.h la();

    /* renamed from: ma, reason: from getter */
    public final ok.a getMAlbumAdapter() {
        return this.mAlbumAdapter;
    }

    protected void oa() {
        if (this.mAlbumAdapter != null) {
            return;
        }
        ViewPager2 viewPager = getViewPager();
        if ((viewPager != null ? viewPager.getAdapter() : null) instanceof RFWConcatAdapter) {
            this.mLayerRecommendViewModel = (af) getViewModel(af.class);
            this.mAlbumAdapter = new ok.a();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        pa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        ok.a aVar;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        ta(layerState);
        za(layerState);
        RFWLog.d("GroupAlbumBaseLayerControlPart", RFWLog.USR, "onLayerStateUpdate, layerState.mediaSum:" + layerState.getMediaSum() + " mSelectedPosition:" + this.mSelectedPosition);
        if (ra()) {
            RFWLog.d("GroupAlbumBaseLayerControlPart", RFWLog.USR, "onLayerStateUpdate, recommend album page selected");
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

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean ra() {
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

    protected void va(ci.e layerListBean) {
        Intrinsics.checkNotNullParameter(layerListBean, "layerListBean");
    }

    private final GroupAlbumLayerExtraInfoBean na(String id5) {
        if (ArrayUtils.isOutOfArrayIndex(0, this.initExtraInfoList)) {
            return null;
        }
        List<GroupAlbumLayerExtraInfoBean> list = this.initExtraInfoList;
        Intrinsics.checkNotNull(list);
        for (GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean : list) {
            if (qa(groupAlbumLayerExtraInfoBean, id5)) {
                return groupAlbumLayerExtraInfoBean;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
        MutableLiveData<UIStateData<AlumBasicData>> R1;
        QLog.d("GroupAlbumBaseLayerControlPart", 1, "requestRecommendAd");
        af afVar = this.mLayerRecommendViewModel;
        if (afVar != null && (R1 = afVar.R1()) != null) {
            R1.observe(getHostFragment(), new b());
        }
        af afVar2 = this.mLayerRecommendViewModel;
        if (afVar2 != null) {
            afVar2.Z1();
        }
    }

    private final void ua(Bundle data) {
        if (data != null) {
            String str = "";
            if (data.containsKey("key_attach_info")) {
                ii.a ja5 = ja();
                String string = data.getString("key_attach_info");
                if (string == null) {
                    string = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string, "it.getString(GroupAlbumG\u2026er.KEY_ATTACH_INFO) ?: \"\"");
                }
                ja5.b2(string);
            }
            if (data.containsKey(MiniAppTranRoomIdServlet.KEY_GROUP_ID)) {
                ii.a ja6 = ja();
                String string2 = data.getString(MiniAppTranRoomIdServlet.KEY_GROUP_ID);
                if (string2 == null) {
                    string2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string2, "it.getString(GroupAlbumG\u2026ncher.KEY_GROUP_ID) ?: \"\"");
                }
                ja6.a2(string2);
            }
            if (data.containsKey("key_batch_id")) {
                ii.a ja7 = ja();
                String string3 = data.getString("key_batch_id");
                if (string3 != null) {
                    Intrinsics.checkNotNullExpressionValue(string3, "it.getString(GroupAlbumG\u2026ncher.KEY_BATCH_ID) ?: \"\"");
                    str = string3;
                }
                ja7.Z1(str);
            }
        }
    }
}
