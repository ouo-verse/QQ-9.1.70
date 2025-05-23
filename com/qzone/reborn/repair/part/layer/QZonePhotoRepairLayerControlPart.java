package com.qzone.reborn.repair.part.layer;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.get_photo_list_ex_rsp;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.ViewModel;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.widget.matrix.RFWMatrixImageView;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J<\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t2\u001a\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0014J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\"\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0014J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0014J\b\u0010#\u001a\u00020\"H\u0014J$\u0010'\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u00192\u0006\u0010&\u001a\u00020\u0017H\u0014J\u001c\u0010(\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0017H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001d\u00108\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerControlPart;", "Lcom/qzone/reborn/layer/part/QZoneFeedxLayerControlPart;", "Lxn/c;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Ka", "Ljava/util/ArrayList;", "LNS_MOBILE_PHOTO/Photo;", "Lkotlin/collections/ArrayList;", "photoList", "Ja", "La", "Landroid/os/Bundle;", "data", "initIntentData", "onInitView", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "Ha", "Aa", "Lcom/qzone/album/data/model/RecomAlbumList;", "recomAlbumList", "R9", "", "ua", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerInfo", "fetchLeft", "fetchRight", "Lcom/qzone/preview/service/QZoneAlbumRequestBuilder;", "X9", "Lcom/qzone/common/business/result/QZoneResult;", "result", "ia", "", "ea", "preLayerState", "newLayerState", "canFindPrePic", "T9", "U9", "isShowSrPic", "d9", "LNS_MOBILE_PHOTO/get_photo_list_ex_rsp;", "Z", "LNS_MOBILE_PHOTO/get_photo_list_ex_rsp;", "mResponse", "", "a0", "Ljava/lang/String;", "mFetchLLoc", "Lcom/tencent/libra/IPicLoader;", "b0", "Lkotlin/Lazy;", "Ia", "()Lcom/tencent/libra/IPicLoader;", "mPicLoader", "<init>", "()V", "c0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerControlPart extends QZoneFeedxLayerControlPart implements xn.c {

    /* renamed from: Z, reason: from kotlin metadata */
    private get_photo_list_ex_rsp mResponse;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String mFetchLLoc;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Lazy mPicLoader;

    public QZonePhotoRepairLayerControlPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPicLoader>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerControlPart$mPicLoader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IPicLoader invoke() {
                View rootView = QZonePhotoRepairLayerControlPart.this.getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return RFWLayerIOCUtil.getPicLoaderFromView(rootView);
            }
        });
        this.mPicLoader = lazy;
    }

    private final IPicLoader Ia() {
        return (IPicLoader) this.mPicLoader.getValue();
    }

    private final ArrayList<Photo> Ja(ArrayList<Photo> photoList) {
        Object obj;
        ArrayList<Photo> arrayList = new ArrayList<>();
        if (!bl.b(photoList)) {
            Iterator<T> it = photoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Photo photo = (Photo) obj;
                if (TextUtils.equals(photo != null ? photo.lloc : null, this.mFetchLLoc)) {
                    break;
                }
            }
            Photo photo2 = (Photo) obj;
            if (photo2 == null) {
                QLog.e(getTAG(), 1, " handleQZoneResult currentPhoto is null");
                return null;
            }
            if (TextUtils.isEmpty(aa().k2().getSrOriginUrl())) {
                QZoneRepairTaskStateBean k26 = aa().k2();
                String str = photo2.currenturl;
                Intrinsics.checkNotNullExpressionValue(str, "currentPhoto.currenturl");
                k26.setSrOriginUrl(str);
            }
            if (!TextUtils.isEmpty(aa().k2().getSrUrl())) {
                photo2.url = aa().k2().getSrUrl();
            }
            arrayList.add(photo2);
        }
        return arrayList;
    }

    private final void Ka(View rootView) {
        RFWIocAbilityProvider.g().registerIoc(rootView, this, xn.c.class);
    }

    private final void La() {
        ImageView currentImageView = this.Q.getCurrentImageView(this.C);
        final RFWMatrixImageView rFWMatrixImageView = currentImageView instanceof RFWMatrixImageView ? (RFWMatrixImageView) currentImageView : null;
        if (rFWMatrixImageView != null && this.mCurrentSelectedItem != null) {
            final Matrix matrix = new Matrix();
            rFWMatrixImageView.getSuppMatrix(matrix);
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            Option reqOption = RFWLayerImageLoader.getReqOption(rFWLayerItemMediaInfo, rFWMatrixImageView, DecodeFormat.PREFER_ARGB_8888);
            IPicLoader Ia = Ia();
            if (Ia != null) {
                Ia.loadImage(reqOption, new IPicLoadStateListener() { // from class: com.qzone.reborn.repair.part.layer.k
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        QZonePhotoRepairLayerControlPart.Ma(RFWMatrixImageView.this, matrix, loadState, option);
                    }
                });
                return;
            }
            return;
        }
        QLog.e("QZonePhotoRepairLayerControlPart", 1, "[updateMatrixImageView] currentImageView:" + rFWMatrixImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(RFWMatrixImageView rFWMatrixImageView, Matrix matrix, LoadState state, Option option) {
        Intrinsics.checkNotNullParameter(matrix, "$matrix");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.isFinishSuccess() && option != null) {
            rFWMatrixImageView.tryMagnifyLongPic(false);
            rFWMatrixImageView.setSuppMatrix(matrix);
            return;
        }
        QLog.e("QZonePhotoRepairLayerControlPart", 1, "[loadImage] fail:" + state + " url:" + (option != null ? option.getUrl() : null));
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void Aa() {
        if (getMLayerViewModel().mRichMediaInfo.getValue() == null) {
            return;
        }
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Intrinsics.checkNotNull(value);
        V9(value.getData(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    /* renamed from: Ha, reason: merged with bridge method [inline-methods] */
    public QZonePhotoRepairLayerViewModel aa() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        return (QZonePhotoRepairLayerViewModel) viewModel;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void T9(RFWLayerState preLayerState, RFWLayerState newLayerState, boolean canFindPrePic) {
        PhotoParam photoParam;
        get_photo_list_ex_rsp get_photo_list_ex_rspVar = this.mResponse;
        if (get_photo_list_ex_rspVar == null || preLayerState == null || newLayerState == null) {
            return;
        }
        if (canFindPrePic) {
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar);
            if (get_photo_list_ex_rspVar.index <= newLayerState.getSelectedPosition() || (photoParam = this.f57988i) == null || photoParam.appid != 4) {
                return;
            }
            get_photo_list_ex_rsp get_photo_list_ex_rspVar2 = this.mResponse;
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar2);
            newLayerState.setPositionOffset(get_photo_list_ex_rspVar2.index - newLayerState.getSelectedPosition());
            preLayerState.getSelectedPosition();
            String tag = getTAG();
            int i3 = RFWLog.USR;
            get_photo_list_ex_rsp get_photo_list_ex_rspVar3 = this.mResponse;
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar3);
            RFWLog.i(tag, i3, "response index is " + get_photo_list_ex_rspVar3.index + " mSelectedPosition is " + newLayerState.getSelectedPosition());
            return;
        }
        Intrinsics.checkNotNull(get_photo_list_ex_rspVar);
        if (get_photo_list_ex_rspVar.index > preLayerState.getSelectedPosition()) {
            get_photo_list_ex_rsp get_photo_list_ex_rspVar4 = this.mResponse;
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar4);
            int i16 = get_photo_list_ex_rspVar4.index;
            get_photo_list_ex_rsp get_photo_list_ex_rspVar5 = this.mResponse;
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar5);
            newLayerState.setPositionOffset(i16 - get_photo_list_ex_rspVar5.indexInVec);
            preLayerState.getSelectedPosition();
            String tag2 = getTAG();
            int i17 = RFWLog.USR;
            get_photo_list_ex_rsp get_photo_list_ex_rspVar6 = this.mResponse;
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar6);
            RFWLog.i(tag2, i17, "response index is " + get_photo_list_ex_rspVar6.index + " indexInVec is " + newLayerState.getSelectedPosition());
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected QZoneAlbumRequestBuilder X9(RFWLayerState layerInfo, boolean fetchLeft, boolean fetchRight) {
        String picId;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder = new QZoneAlbumRequestBuilder();
        if (this.f57988i != null && layerInfo != null && !bl.b(layerInfo.getRichMediaDataList())) {
            List<RFWLayerItemMediaInfo> richMediaDataList = layerInfo.getRichMediaDataList();
            Intrinsics.checkNotNull(richMediaDataList);
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = richMediaDataList.get(layerInfo.getSelectedPosition());
            PhotoParam photoParam = this.f57988i;
            photoParam.cell_id = photoParam.albumid;
            String str = "";
            if (rFWLayerItemMediaInfo.getLayerPicInfo() == null) {
                picId = "";
            } else {
                RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
                Intrinsics.checkNotNull(layerPicInfo);
                picId = layerPicInfo.getPicId();
            }
            this.mFetchLLoc = picId;
            QLog.i("QZonePhotoRepairLayerControlPart", 1, "fetch lloc is " + picId);
            QZoneAlbumRequestBuilder fetchRight2 = qZoneAlbumRequestBuilder.setPhotoId(this.mFetchLLoc).setFetchLeft(fetchLeft ? 1 : 0).setFetchRight(fetchRight ? 1 : 0);
            RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo();
            if (layerPicInfo2 != null && (currentPicInfo = layerPicInfo2.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
                str = url;
            }
            fetchRight2.setUrl(str).setPhotoParam(this.f57988i).setAlbumType(this.f57988i.albumType).setPhotoExType(0);
        }
        return qZoneAlbumRequestBuilder;
    }

    @Override // xn.c
    public void d9(boolean isShowSrPic) {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo = (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null) ? null : layerPicInfo.getCurrentPicInfo();
        if (currentPicInfo == null) {
            RFWLog.e("QZonePhotoRepairLayerControlPart", RFWLog.USR, "[switchShowSrPic] isShowSrPic: " + isShowSrPic);
            return;
        }
        if (isShowSrPic) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setUrl(aa().k2().getSrUrl());
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo2);
            RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo2.getLayerPicInfo();
            if (layerPicInfo2 != null) {
                layerPicInfo2.setCurrentPicInfo(rFWPicInfo);
            }
        } else {
            if (!TextUtils.isEmpty(aa().k2().getSrOriginUrl())) {
                currentPicInfo.setUrl(aa().k2().getSrOriginUrl());
                String d16 = com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(aa().k2().getSrOriginUrl()));
                if (!TextUtils.isEmpty(d16)) {
                    currentPicInfo.setLocalPath(d16);
                }
            }
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo3);
            RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo3.getLayerPicInfo();
            if (layerPicInfo3 != null) {
                layerPicInfo3.setCurrentPicInfo(currentPicInfo);
            }
        }
        RFWLog.i("QZonePhotoRepairLayerControlPart", RFWLog.USR, "[switchShowSrPic] isShowSrPic:" + isShowSrPic + " srUrl = " + aa().k2().getSrUrl() + " \n currentPic = " + currentPicInfo.getUrl() + " \n localPath = " + currentPicInfo.getLocalPath() + " \n initSrcUrl = " + aa().k2().getSrOriginUrl());
        La();
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 0;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void ia(QZoneResult result) {
        int i3;
        PhotoParam photoParam;
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i(getTAG(), 1, " handleQZoneResult " + result.getSucceed());
        if (result.getSucceed()) {
            Bundle bundle = result.getBundle();
            if (bundle == null) {
                QLog.e(getTAG(), 1, " handleQZoneResult data is null");
                return;
            }
            bundle.getInt("type", 0);
            get_photo_list_ex_rsp get_photo_list_ex_rspVar = (get_photo_list_ex_rsp) bundle.get("response");
            if ((get_photo_list_ex_rspVar != null ? get_photo_list_ex_rspVar.photolist : null) == null || get_photo_list_ex_rspVar.photolist.size() == 0) {
                return;
            }
            this.mResponse = get_photo_list_ex_rspVar;
            Album album = get_photo_list_ex_rspVar.albuminfo;
            if (album != null && (photoParam = this.f57988i) != null) {
                photoParam.albumPriv = album.priv;
            }
            int i16 = get_photo_list_ex_rspVar.index;
            if (i16 < 0) {
                this.H = 0;
                this.J = true;
                this.K = get_photo_list_ex_rspVar.right_finish > 0;
            } else {
                this.H = i16;
                this.J = get_photo_list_ex_rspVar.left_finish > 0;
                this.K = get_photo_list_ex_rspVar.right_finish > 0;
            }
            ArrayList<Photo> arrayList = get_photo_list_ex_rspVar.photolist;
            Intrinsics.checkNotNullExpressionValue(arrayList, "response.photolist");
            ArrayList<Photo> Ja = Ja(arrayList);
            if (Ja == null) {
                return;
            }
            this.L = Ja;
            RFWLayerState rFWLayerState = new RFWLayerState();
            Album album2 = get_photo_list_ex_rspVar.albuminfo;
            if (album2 != null && (i3 = album2.total) > 0) {
                rFWLayerState.setMediaSum(i3);
            } else {
                rFWLayerState.setMediaSum(get_photo_list_ex_rspVar.photolist.size());
            }
            rFWLayerState.setRichMediaDataList(this.T.R1(this.L, get_photo_list_ex_rspVar.albuminfo));
            S9(false, false);
            String tag = getTAG();
            List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerState.getRichMediaDataList();
            Intrinsics.checkNotNull(richMediaDataList);
            QLog.i(tag, 1, " handleQZoneResult mRichMediaDataList size:" + richMediaDataList.size());
            xa(rFWLayerState, UIStateData.obtainSuccess(false));
        }
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        aa().y2(data);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Ka(rootView);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected boolean ua() {
        return ra();
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void U9(RFWLayerState preLayerState, RFWLayerState newLayerState) {
        if (preLayerState == null || newLayerState == null) {
            return;
        }
        if (this.mResponse == null) {
            newLayerState.setSelectedPosition(preLayerState.getSelectedPosition());
            return;
        }
        String tag = getTAG();
        int i3 = RFWLog.USR;
        get_photo_list_ex_rsp get_photo_list_ex_rspVar = this.mResponse;
        Intrinsics.checkNotNull(get_photo_list_ex_rspVar);
        int i16 = get_photo_list_ex_rspVar.indexInVec;
        get_photo_list_ex_rsp get_photo_list_ex_rspVar2 = this.mResponse;
        Intrinsics.checkNotNull(get_photo_list_ex_rspVar2);
        RFWLog.i(tag, i3, "response indexInVec is " + i16 + " response index is " + get_photo_list_ex_rspVar2.index + " pre index is " + preLayerState.getSelectedPosition());
        get_photo_list_ex_rsp get_photo_list_ex_rspVar3 = this.mResponse;
        Intrinsics.checkNotNull(get_photo_list_ex_rspVar3);
        if (get_photo_list_ex_rspVar3.indexInVec >= preLayerState.getSelectedPosition()) {
            get_photo_list_ex_rsp get_photo_list_ex_rspVar4 = this.mResponse;
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar4);
            newLayerState.setSelectedPosition(get_photo_list_ex_rspVar4.indexInVec);
            return;
        }
        get_photo_list_ex_rsp get_photo_list_ex_rspVar5 = this.mResponse;
        Intrinsics.checkNotNull(get_photo_list_ex_rspVar5);
        if (get_photo_list_ex_rspVar5.index >= preLayerState.getSelectedPosition()) {
            get_photo_list_ex_rsp get_photo_list_ex_rspVar6 = this.mResponse;
            Intrinsics.checkNotNull(get_photo_list_ex_rspVar6);
            newLayerState.setSelectedPosition(get_photo_list_ex_rspVar6.index);
            return;
        }
        newLayerState.setSelectedPosition(preLayerState.getSelectedPosition());
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void R9(RecomAlbumList recomAlbumList) {
    }
}
