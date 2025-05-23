package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.event.QZoneLayerDeletePhotoEvent;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.component.media.image.ImageKey;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ok.a;

/* loaded from: classes37.dex */
public abstract class QZoneFeedxLayerControlPart extends ap implements SimpleEventReceiver {
    protected int G;
    public int H;
    protected boolean I;
    public boolean J;
    public boolean K;
    public ArrayList<Photo> L;
    protected RecomAlbumList M;
    private ViewPager2 N;
    protected ok.a P;
    protected RFWLayerGalleryAdapter Q;
    protected Runnable R;
    protected QZoneFeedxLayerRecommendViewModel S;
    protected uk.a T;
    protected int U;
    protected boolean V;
    protected boolean W;
    protected int X;
    private boolean Y;

    /* loaded from: classes37.dex */
    public static class ParseAlbumTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QZoneFeedxLayerControlPart> f57844d;

        /* renamed from: e, reason: collision with root package name */
        private final Map<Integer, byte[]> f57845e;

        public ParseAlbumTask(QZoneFeedxLayerControlPart qZoneFeedxLayerControlPart, Map<Integer, byte[]> map) {
            this.f57844d = new WeakReference<>(qZoneFeedxLayerControlPart);
            this.f57845e = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            QZoneFeedxLayerControlPart qZoneFeedxLayerControlPart = this.f57844d.get();
            if (qZoneFeedxLayerControlPart != null) {
                qZoneFeedxLayerControlPart.va(this.f57845e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements Observer<UIStateData<AlumBasicData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<AlumBasicData> uIStateData) {
            if (QZoneFeedxLayerControlPart.this.P == null || uIStateData == null || uIStateData.getData() == null) {
                return;
            }
            AlumBasicData data = uIStateData.getData();
            QZoneFeedxLayerControlPart.this.P.x0(uIStateData.getMsg(), data);
            QLog.i("QZoneFeedxLayerControlPart", 1, "on advdata change , aid : " + data.aid);
            if (QZoneFeedxLayerControlPart.this.Y) {
                QZoneFeedxLayerControlPart.this.P.i0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements Observer<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes37.dex */
        public class a implements a.b {
            a() {
            }

            @Override // ok.a.b
            public void a() {
                QZoneFeedxLayerControlPart.this.za();
            }
        }

        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QZoneFeedxLayerRecommendPhotoBean> uIStateData) {
            if (QZoneFeedxLayerControlPart.this.P == null) {
                return;
            }
            if (uIStateData != null && uIStateData.getData() != null && !uIStateData.getData().isDataIllegal) {
                QZoneFeedxLayerRecommendPhotoBean data = uIStateData.getData();
                data.backgroundUrl = QZoneFeedxLayerControlPart.this.Y9();
                QZoneFeedxLayerControlPart qZoneFeedxLayerControlPart = QZoneFeedxLayerControlPart.this;
                data.refer = qZoneFeedxLayerControlPart.U;
                qZoneFeedxLayerControlPart.P.w0(new a());
                QZoneFeedxLayerControlPart.this.wa(data);
                return;
            }
            RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "data is illegal");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements Observer<UIStateData<QZoneResult>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QZoneResult> uIStateData) {
            QZoneFeedxLayerControlPart.this.ga(uIStateData.getData());
        }
    }

    public QZoneFeedxLayerControlPart() {
        this.L = new ArrayList<>();
        this.U = 0;
        this.Y = false;
    }

    private void Ca() {
        Map<Integer, String> map;
        PhotoParam photoParam;
        if (this.D == 1 && (photoParam = this.f57988i) != null && !TextUtils.isEmpty(photoParam.albumid) && this.f57988i.appid == 4) {
            this.G = 2;
        }
        PhotoParam photoParam2 = this.f57988i;
        if (photoParam2 == null || (map = photoParam2.busi_param) == null) {
            return;
        }
        String str = map.get(16);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.G = Integer.valueOf(str).intValue();
    }

    private void Ea() {
        if (this.mLayerViewModel.mRichMediaInfo.getValue() == null) {
            return;
        }
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()) {
            rFWLayerItemMediaInfo.setExtraData(ca(rFWLayerItemMediaInfo.getMediaId()));
        }
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = this.mLayerViewModel.mRichMediaInfo;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    private void Q9(final RecomAlbumList recomAlbumList) {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedxLayerControlPart.this.R9(recomAlbumList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Y9() {
        ArrayList<Photo> arrayList = this.L;
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        if (this.L.get(r0.size() - 1) == null) {
            return "";
        }
        return this.L.get(r0.size() - 1).bigurl;
    }

    private PhotoInfo ca(String str) {
        List<PhotoInfo> list = this.f57989m;
        if (list == null) {
            return null;
        }
        for (PhotoInfo photoInfo : list) {
            if (sa(photoInfo, str)) {
                return photoInfo;
            }
        }
        return null;
    }

    private PhotoParam da(Album album) {
        PhotoParam photoParam = new PhotoParam();
        long j3 = album.uin;
        photoParam.ownerUin = j3;
        photoParam.feedUin = j3;
        photoParam.albumid = album.albumid;
        photoParam.albumType = album.type;
        int i3 = album.total;
        photoParam.albumnum = i3;
        photoParam.uploadnum = i3;
        photoParam.albumPriv = album.priv;
        String str = album.answer;
        photoParam.albumanswer = str;
        if (str == null) {
            photoParam.albumanswer = "";
        }
        photoParam.loginUin = LoginData.getInstance().getUin();
        photoParam.cell_id = photoParam.albumid;
        Map<Integer, String> map = album.busi_param;
        photoParam.busi_param = map;
        if (map != null) {
            photoParam.orgKey = map.get(5);
            photoParam.curKey = photoParam.busi_param.get(6);
        }
        photoParam.mFromRecent = true;
        return photoParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(final QZoneResult qZoneResult) {
        Runnable runnable = new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart.5
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedxLayerControlPart.this.ia(qZoneResult);
            }
        };
        if (pa()) {
            RFWThreadManager.getInstance().execOnNetThread(runnable);
        } else {
            RFWThreadManager.getInstance().runOnUiThread(runnable);
        }
    }

    private void ha(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder) {
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
        if (qZoneInteractPhotoRequestBuilder == null) {
            RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "builder is null");
            return;
        }
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel != null && (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) != null && mutableLiveData.getValue() != null) {
            RFWLayerState data = this.mLayerViewModel.mRichMediaInfo.getValue().getData();
            if (data == null) {
                RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "layer state data is null");
                return;
            }
            List<RFWLayerItemMediaInfo> richMediaDataList = data.getRichMediaDataList();
            if (ArrayUtils.isOutOfArrayIndex(this.C, richMediaDataList)) {
                RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "mSelectedPosition is out of bounds");
                return;
            }
            if (richMediaDataList.remove(this.C) == null) {
                RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "delete fail");
                return;
            }
            if (richMediaDataList.isEmpty() && getActivity() != null) {
                getActivity().finish();
            }
            data.setRichMediaDataList(richMediaDataList);
            data.setMediaSum(data.getMediaSum() - 1);
            if (data.getSelectedPosition() > 0) {
                data.setSelectedPosition(data.getSelectedPosition() - 1);
            } else {
                data.setSelectedPosition(0);
            }
            UIStateData<RFWLayerState> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setDataList(data);
            xa(data, obtainSuccess);
            return;
        }
        RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "rich media info is null");
    }

    private void ja() {
        uk.a aa5 = aa();
        this.T = aa5;
        if (aa5 == null) {
            RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "layer data view model is null");
            return;
        }
        aa5.b2(this.f57988i);
        this.T.a2(this.f57989m);
        this.T.f439100i.observe(getPartHost().getLifecycleOwner(), new c());
    }

    private void la() {
        if (aa() == null) {
            return;
        }
        aa().b2(this.f57988i);
    }

    private boolean ma() {
        ViewPager2 viewPager2 = this.N;
        if (viewPager2 == null || viewPager2.getAdapter() == null || !(this.N.getAdapter() instanceof RFWConcatAdapter)) {
            return false;
        }
        return ((RFWConcatAdapter) this.N.getAdapter()).getAdapters().contains(this.P);
    }

    private boolean na() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_KEY_ALLOW_ALBUM_RECOMMEND_SHOW_GALLERY, 1) == 1;
    }

    private boolean oa() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_KEY_ALLOW_SCROLL_TO_RECOMMEND, 1) == 1;
    }

    private boolean pa() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_KEY_FEEDX_LAYER_RESPONSE_IN_SUB_THREAD, 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za() {
        QZoneFeedxLayerRecommendViewModel qZoneFeedxLayerRecommendViewModel = this.S;
        if (qZoneFeedxLayerRecommendViewModel == null) {
            RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "layer view model is null");
            return;
        }
        qZoneFeedxLayerRecommendViewModel.U1().observe(getHostFragment(), new a());
        if (na()) {
            this.S.f2();
        }
        this.S.e2();
    }

    protected abstract void Aa();

    /* JADX INFO: Access modifiers changed from: protected */
    public void Da(RFWLayerState rFWLayerState, UIStateData<RFWLayerState> uIStateData) {
        boolean z16;
        RFWLayerState data = this.mLayerViewModel.mRichMediaInfo.getValue().getData();
        int currentIndex = RFWLayerItemMediaInfo.INSTANCE.getCurrentIndex(data.getSelectedItemMedia(), rFWLayerState.getRichMediaDataList());
        if (currentIndex >= 0) {
            rFWLayerState.setSelectedPosition(currentIndex);
            RFWLog.i(getTAG(), RFWLog.USR, "preSelectedPosition:" + data.getSelectedPosition() + " find new mSelectedPosition:" + currentIndex);
            z16 = true;
        } else {
            U9(data, rFWLayerState);
            z16 = false;
        }
        T9(data, rFWLayerState, z16);
        uIStateData.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
        this.mLayerViewModel.mRichMediaInfo.setValue(uIStateData.setDataList(rFWLayerState));
        if (this.R != null) {
            RFWThreadManager.getInstance().execOnSubThread(this.R);
            this.R = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fa() {
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()) {
            if (rFWLayerItemMediaInfo.getLayerPicInfo() != null && rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo() != null && rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo() != rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo()) {
                rFWLayerItemMediaInfo.getLayerPicInfo().setCurrentPicInfo(rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo());
            }
        }
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = this.mLayerViewModel.mRichMediaInfo;
        mutableLiveData.setValue(mutableLiveData.getValue());
        if (B9() != null) {
            B9().g8();
        }
    }

    protected void R9(RecomAlbumList recomAlbumList) {
        if (this.P == null && (this.N.getAdapter() instanceof RFWConcatAdapter)) {
            this.P = new ok.a();
            W9(recomAlbumList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V9(RFWLayerState rFWLayerState, boolean z16, boolean z17) {
        if (ua()) {
            return;
        }
        if (rFWLayerState != null && rFWLayerState.getRichMediaDataList() != null && rFWLayerState.getRichMediaDataList().size() > rFWLayerState.getSelectedPosition()) {
            if (this.T == null) {
                RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "layer data view model is null");
                return;
            }
            if (z16 && this.V) {
                return;
            }
            if (z17 && this.W) {
                return;
            }
            if (z16) {
                this.V = true;
            }
            if (z17) {
                this.W = true;
            }
            QZoneAlbumRequestBuilder X9 = X9(rFWLayerState, z16, z17);
            this.X = rFWLayerState.getSelectedPosition();
            QLog.d("QZoneFeedxLayerControlPart", 1, "fetch left is " + z16 + ", fetch right is " + z17 + ", initial index is " + this.X);
            this.T.Z1(X9);
            return;
        }
        RFWLog.e("QZoneFeedxLayerControlPart", RFWLog.USR, "no need to fetch layer data");
    }

    protected void W9(RecomAlbumList recomAlbumList) {
        QZoneFeedxLayerRecommendViewModel qZoneFeedxLayerRecommendViewModel = this.S;
        if (qZoneFeedxLayerRecommendViewModel == null) {
            return;
        }
        qZoneFeedxLayerRecommendViewModel.X1().observe(getHostFragment(), new b());
        this.S.S1(recomAlbumList);
    }

    protected abstract QZoneAlbumRequestBuilder X9(RFWLayerState rFWLayerState, boolean z16, boolean z17);

    protected abstract uk.a aa();

    protected abstract int ea();

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneLayerDeletePhotoEvent.class);
        return arrayList;
    }

    protected abstract void ia(QZoneResult qZoneResult);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle bundle) {
        la();
        ja();
        Ca();
        Ea();
        Aa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.N != null && ta()) {
            this.N.setCurrentItem(this.L.size() - 1, false);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QZoneFeedxLayerRecommendViewModel qZoneFeedxLayerRecommendViewModel = (QZoneFeedxLayerRecommendViewModel) getViewModel(QZoneFeedxLayerRecommendViewModel.class);
        this.S = qZoneFeedxLayerRecommendViewModel;
        qZoneFeedxLayerRecommendViewModel.g2(this.U);
        Z9(view);
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        broadcastMessage("hide_feedx_layer_head_mask", Boolean.valueOf(ta()));
        if (this.I) {
            if (!this.J && this.C <= ea()) {
                V9(rFWLayerState, true, false);
            }
            if (!this.K && (rFWLayerState.getRichMediaDataList().size() - this.C) - 1 <= ea()) {
                V9(rFWLayerState, false, true);
            }
            if (ta()) {
                RFWLog.d("QZoneFeedxLayerControlPart", RFWLog.USR, "onLayerStateUpdate, recommend album page selected");
                this.Y = true;
                ok.a aVar = this.P;
                if (aVar != null) {
                    aVar.i0();
                    this.P.r0();
                }
                broadcastMessage("HIDE_ORIGINAL_PIC_BUTTON", null);
                broadcastMessage("FEEDX_LAYER_DANMU_HIDE", null);
                return;
            }
            this.Y = false;
            ok.a aVar2 = this.P;
            if (aVar2 != null) {
                aVar2.n0();
            }
        }
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        ok.a aVar = this.P;
        if (aVar != null) {
            aVar.onPartDestroy(activity);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        ok.a aVar = this.P;
        if (aVar != null) {
            aVar.onPartPause(activity);
        }
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        ok.a aVar = this.P;
        if (aVar != null) {
            aVar.onPartResume(activity);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneLayerDeletePhotoEvent) {
            ha(((QZoneLayerDeletePhotoEvent) simpleBaseEvent).mBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean qa(RFWLayerState rFWLayerState) {
        int size = rFWLayerState.getRichMediaDataList().size();
        int i3 = this.C;
        return (size - i3) - 1 <= i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ra() {
        PhotoParam photoParam = this.f57988i;
        return photoParam != null && photoParam.noNeedToFetchPhotoList;
    }

    public boolean sa(PhotoInfo photoInfo, String str) {
        VideoInfo videoInfo;
        boolean equals = (!photoInfo.isVideo() || (videoInfo = photoInfo.videodata) == null) ? false : str.equals(videoInfo.videoId);
        if (!equals && !TextUtils.isEmpty(photoInfo.getPicId())) {
            equals = str.equals(photoInfo.getPicId());
        }
        return (equals || TextUtils.isEmpty(photoInfo.bigUrl)) ? equals : str.equals(ImageKey.getUrlKey(photoInfo.bigUrl, true));
    }

    protected boolean ta() {
        ok.a aVar = this.P;
        if (aVar != null && this.f57984d == null) {
            return aVar.m0() || ma();
        }
        return false;
    }

    protected boolean ua() {
        return false;
    }

    protected void va(Map<Integer, byte[]> map) {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_SWITCH, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < config) {
            QZLog.i(getTAG(), 2, "[parseRecomAlbumListForPhotoList] current sdk ", Integer.valueOf(i3), " less than lessSdkVersion ", Integer.valueOf(config));
        } else if (oa()) {
            this.M = new RecomAlbumList();
            this.M.parsedFromFeature(map, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND, -1), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND, 2));
            Q9(this.M);
        }
    }

    protected void wa(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (this.N.getAdapter() instanceof RFWConcatAdapter) {
            this.P.y0(qZoneFeedxLayerRecommendPhotoBean);
            ((RFWConcatAdapter) this.N.getAdapter()).addAdapter(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xa(final RFWLayerState rFWLayerState, final UIStateData<RFWLayerState> uIStateData) {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart.6

            /* renamed from: com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart$6$a */
            /* loaded from: classes37.dex */
            class a extends RecyclerView.OnScrollListener {
                a() {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                    super.onScrollStateChanged(recyclerView, i3);
                    if (i3 == 0) {
                        QZoneFeedxLayerControlPart.this.Q.getRecyclerView().removeOnScrollListener(this);
                        RFWLog.i(QZoneFeedxLayerControlPart.this.getTAG(), RFWLog.USR, "scroll is idle start setData");
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        QZoneFeedxLayerControlPart.this.Da(rFWLayerState, uIStateData);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (QZoneFeedxLayerControlPart.this.B9() != null) {
                    QZoneFeedxLayerControlPart.this.B9().g8();
                }
                if (QZoneFeedxLayerControlPart.this.Q.getRecyclerView().getScrollState() == 0) {
                    QZoneFeedxLayerControlPart.this.Da(rFWLayerState, uIStateData);
                } else {
                    RFWLog.i(QZoneFeedxLayerControlPart.this.getTAG(), RFWLog.USR, "isScrolling add listener");
                    QZoneFeedxLayerControlPart.this.Q.getRecyclerView().addOnScrollListener(new a());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<PhotoParam> ba(ArrayList<PhotoFeedsData> arrayList) {
        Album album;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<PhotoParam> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoFeedsData photoFeedsData = arrayList.get(i3);
            if (photoFeedsData != null && (album = photoFeedsData.album) != null && Ba(album)) {
                arrayList2.add(da(album));
            }
        }
        return arrayList2;
    }

    private boolean Ba(Album album) {
        ArrayList<PhotoParam> arrayList;
        String str;
        if (album == null || album.albumid == null || (arrayList = this.f57986f) == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<PhotoParam> it = this.f57986f.iterator();
        while (it.hasNext()) {
            PhotoParam next = it.next();
            if (next != null && (str = next.albumid) != null && str.equals(album.albumid)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S9(boolean z16, boolean z17) {
        if (z16) {
            this.V = false;
        }
        if (z17) {
            this.W = false;
        }
    }

    protected void Z9(View view) {
        ViewPager2 viewPager2 = ((RFWGalleryViewPager) view.findViewById(R.id.f73943ux)).getViewPager2();
        this.N = viewPager2;
        this.Q = (RFWLayerGalleryAdapter) ((RFWConcatAdapter) viewPager2.getAdapter()).getAdapters().get(0);
    }

    public QZoneFeedxLayerControlPart(ve.l lVar) {
        this.L = new ArrayList<>();
        this.U = 0;
        this.Y = false;
        if (lVar == null) {
            return;
        }
        this.U = lVar.a();
    }

    protected void U9(RFWLayerState rFWLayerState, RFWLayerState rFWLayerState2) {
    }

    protected void T9(RFWLayerState rFWLayerState, RFWLayerState rFWLayerState2, boolean z16) {
    }
}
