package com.tencent.aelight.camera.ae.album.logic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.g;
import com.tencent.mobileqq.activity.photo.j;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.h;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bm;
import com.tencent.mobileqq.utils.e;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes32.dex */
public class AEPhotoListLogicDefault extends AEPhotoListLogicBase<com.tencent.aelight.camera.ae.album.fragment.b> {
    protected g X;
    private List<b> Y;

    /* renamed from: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault$2, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f62109d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f62110e;
        final /* synthetic */ AEPhotoListLogicDefault this$0;

        @Override // java.lang.Runnable
        public void run() {
            PhotoUtils.sendPhoto(((com.tencent.aelight.camera.ae.album.fragment.b) this.this$0.f62122e.get()).getActivity(), this.f62109d, this.f62110e, 2, this.this$0.X.f184241v);
            h.f287891c = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements TAVCut.Callback {
        a() {
        }

        @Override // com.tencent.qcircle.tavcut.TAVCut.Callback
        public void onDone(int i3) {
            ms.a.f("AEPhotoListLogicDefault", "TAVCut init ret code = " + i3);
            if (i3 != 0) {
                AEPhotoListLogicDefault.this.Y.add(new b(-9));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f62112a;

        public b(int i3) {
            this.f62112a = i3;
        }

        public String toString() {
            switch (this.f62112a) {
                case -9:
                    return "\u521d\u59cb\u5316TAVCut\u5931\u8d25";
                case -8:
                default:
                    return WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
                case -7:
                    return "\u52a0\u8f7dImageAlgo\u5931\u8d25";
                case -6:
                    return "\u52a0\u8f7dPAG\u5931\u8d25";
                case -5:
                    return "\u52a0\u8f7d\u4eba\u8138\u68c0\u6d4b\u5931\u8d25";
                case -4:
                    return "\u52a0\u8f7dPtuAlgo\u5931\u8d25";
                case -3:
                    return "\u52a0\u8f7dPtuTools\u5931\u8d25";
                case -2:
                    return "\u52a0\u8f7dYTCommon\u5931\u8d25";
                case -1:
                    return "\u521d\u59cb\u5316AEKit\u5931\u8d25";
                case 0:
                    return "\u521d\u59cb\u5316\u6210\u529f";
            }
        }
    }

    public AEPhotoListLogicDefault(com.tencent.aelight.camera.ae.album.fragment.b bVar) {
        super(bVar);
        this.Y = new ArrayList();
        this.f62126m = this;
        this.C = this;
        this.D = this;
        g gVar = new g();
        this.f62124h = gVar;
        this.X = gVar;
    }

    private void h1() {
        this.Y.size();
    }

    private void i1() {
        if (!com.tencent.aelight.camera.ae.d.j()) {
            this.Y.add(new b(-1));
        } else {
            j1(FeatureManager.Features.YT_COMMON.init(), -2);
            j1(FeatureManager.Features.PTU_TOOLS.init(), -3);
            j1(FeatureManager.Features.PTU_ALGO.init(), -4);
            j1(com.tencent.aelight.camera.ae.d.s(), -8);
            j1(FeatureManager.Features.IMAGE_ALGO.init(), -7);
        }
        TAVCut.initTAVCut(BaseApplication.context, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.y(), new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    public String A0(LocalMediaInfo localMediaInfo) {
        int i3 = this.f62123f.maxSelectNum;
        String A0 = super.A0(localMediaInfo);
        if (localMediaInfo == null) {
            return A0;
        }
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        return (this.X.f184293d && mimeType != null && "video".equals(mimeType[0])) ? ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getResources().getString(R.string.cu_, Integer.valueOf(i3)) : A0;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void F() {
        I();
        super.F();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void G(List<LocalMediaInfo> list) {
        j.g(list, 0, null, this.X.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void I() {
        super.I();
        ArrayList<String> arrayList = this.f62123f.selectedPhotoList;
        arrayList.size();
        if (QLog.isColorLevel()) {
            QLog.d(PeakConstants.TAG, 2, "updateButton selectedPhotoList.size()=" + arrayList.size());
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    protected void S0(AEAbstractPhotoListFragment.g gVar, LocalMediaInfo localMediaInfo) {
        if (j.f(localMediaInfo.path, this.X.N)) {
            gVar.f62057h.setImageDrawable(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getDrawable(R.drawable.f160524cg1));
            gVar.f62057h.setVisibility(0);
        } else {
            gVar.f62057h.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    public void b1(Intent intent) {
        super.b1(intent);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c.b
    public void e(View view, int i3, CheckBox checkBox) {
        String str;
        if (this.f62123f.isSingleMode) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "current select count:" + this.f62123f.selectedPhotoList.size());
        }
        LocalMediaInfo p16 = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).f62034h.p(i3);
        int i16 = p16.selectStatus;
        if (i16 != 1 && this.f62123f.selectedPhotoList.size() + this.f62125i.initialHasPickedNum >= this.f62123f.maxSelectNum) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.X.f184299j >= 1000) {
                QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), A0(p16), 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
                checkBox.setChecked(false);
                this.X.f184299j = currentTimeMillis;
                return;
            }
            return;
        }
        if (this.X.H == 9501 && ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent().getBooleanExtra(PeakConstants.IS_SEND_FILESIZE_LIMIT, false) && i16 != 1) {
            Iterator<String> it = this.f62123f.selectedPhotoList.iterator();
            long j3 = 0;
            while (it.hasNext()) {
                j3 += FileUtils.getFileSizes(it.next());
            }
            if (j3 + FileUtils.getFileSizes(p16.path) > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), "\u9009\u62e9\u56fe\u7247\u603b\u5927\u5c0f\u4e0d\u80fd\u8d85\u8fc750M", 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
                checkBox.setChecked(false);
                return;
            }
        }
        if (((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent().getBooleanExtra(PeakConstants.IS_SEND_GIF_SIZE_LIMIT, false) && ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).y(p16) && FileUtils.getFileSizes(p16.path) > 3145728) {
            QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), "\u56fe\u7247\u6587\u4ef6\u8fc7\u5927", 0).show(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).E);
            checkBox.setChecked(false);
            return;
        }
        int i17 = i16 != 1 ? 1 : 2;
        p16.selectStatus = i17;
        boolean z16 = i17 == 1;
        String str2 = p16.path;
        PresendPicMgr f16 = PresendPicMgr.f();
        if (z16) {
            String[] mimeType = MimeHelper.getMimeType(p16.mMimeType);
            if (this.X.f184293d && mimeType != null && "video".equals(mimeType[0])) {
                g gVar = this.X;
                int i18 = gVar.f184294e + 1;
                gVar.f184294e = i18;
                if (i18 == 1) {
                    gVar.f184296g = p16;
                }
            }
            if (!TextUtils.isEmpty(p16.mMimeType) && "image/gif".equals(p16.mMimeType)) {
                this.X.f184295f++;
            }
            this.f62123f.selectedPhotoList.add(str2);
            this.f62123f.selectedIndex.add(p16.position);
            this.f62123f.selectedMediaInfoHashMap.put(str2, p16);
            if (f16 != null && mimeType != null && (str = mimeType[0]) != null && !"video".equals(str)) {
                f16.k(str2, 1052, ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent().getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0));
            }
            m.c(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent(), "param_totalSelNum");
            Intent intent = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent();
            if (!intent.hasExtra(QAlbumConstants.PARAM_INITTIME)) {
                intent.putExtra(QAlbumConstants.PARAM_INITTIME, System.currentTimeMillis());
            }
            LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f62123f.albumId);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
                QAlbumUtil.sSelectItemPosMap.put(this.f62123f.albumId, linkedHashMap);
            }
            linkedHashMap.put(str2, Integer.valueOf(((GridLayoutManager) ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).Q.getLayoutManager()).findFirstVisibleItemPosition()));
            HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
            if (!hashMap.containsKey(str2)) {
                PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
                hashMap.put(str2, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
            }
        } else {
            String[] mimeType2 = MimeHelper.getMimeType(p16.mMimeType);
            if (this.X.f184293d && mimeType2 != null && "video".equals(mimeType2[0])) {
                g gVar2 = this.X;
                int i19 = gVar2.f184294e - 1;
                gVar2.f184294e = i19;
                if (i19 == 1) {
                    gVar2.f184296g = p16;
                }
            }
            if (!TextUtils.isEmpty(p16.mMimeType) && "image/gif".equals(p16.mMimeType)) {
                this.X.f184295f--;
            }
            this.f62123f.selectedPhotoList.remove(str2);
            this.f62123f.selectedIndex.remove(p16.position);
            this.f62123f.selectedMediaInfoHashMap.remove(str2);
            if (f16 != null) {
                f16.b(str2, 1013);
            }
            m.c(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent(), "param_cancelSelNum");
            LinkedHashMap<String, Integer> linkedHashMap2 = QAlbumUtil.sSelectItemPosMap.get(this.f62123f.albumId);
            if (linkedHashMap2 != null) {
                linkedHashMap2.remove(str2);
            }
            HashMap<String, Pair<String, String>> hashMap2 = QAlbumUtil.sSelectItemAlbum;
            if (hashMap2.containsKey(str2)) {
                hashMap2.remove(str2);
            }
        }
        ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).H(i3, z16);
        ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).A(!z16);
        I();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c.a
    public View f() {
        return super.f();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void i() {
        super.i();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void j() {
        super.j();
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        if (this.X.f184301l == 10016) {
            if (!((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
                ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().finish();
            } else {
                ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity().getIntent().removeExtra("FROM_QZONR_NO_FINISH");
                this.X.f184301l = 0;
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void k(Intent intent) {
        super.k(intent);
        intent.putExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, this.f62123f.isShowQzoneAlbum);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public List<LocalMediaInfo> l(boolean z16) {
        int i3 = (this.f62123f.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID) && z16) ? 100 : -1;
        Activity activity = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity();
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
        String str = photoCommonBaseData.albumId;
        String str2 = photoCommonBaseData.albumName;
        MediaFileFilter mediaFileFilter = photoCommonBaseData.filter;
        List<LocalMediaInfo> albumMedias = QAlbumBaseUtil.getAlbumMedias(activity, str, str2, i3, mediaFileFilter, mediaFileFilter.videoMaxDuration);
        bm.b("PEAK", "getAlbumMedias");
        if (albumMedias == null) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("SelectPhotoTrace", 2, "photoList is null");
            return null;
        }
        ArrayList<String> arrayList = this.f62123f.selectedPhotoList;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i16 = 0; i16 < this.f62123f.selectedPhotoList.size(); i16++) {
                if (TextUtils.isEmpty(this.f62123f.selectedPhotoList.get(i16))) {
                    QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
                }
            }
        }
        return albumMedias;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void m(Message message) {
        super.m(message);
        ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).n();
        ArrayList<String> arrayList = this.f62123f.selectedPhotoList;
        Object obj = message.obj;
        if (obj instanceof String) {
            String str = (String) obj;
            QZLog.d("QQAlbum", 2, "onEncodeSuccess = ", str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            int size = arrayList.size();
            PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
            if (size >= photoCommonBaseData.maxSelectNum) {
                QQToast.makeText(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), String.format(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getResources().getString(R.string.cu_), Integer.valueOf(this.f62123f.maxSelectNum)), 0).show();
            } else {
                photoCommonBaseData.selectedPhotoList.add(str);
                ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).M();
            }
            ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).L(str);
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void n(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("SelectPhotoTrace", 2, "QQAlbum initData(),intent extras is:" + intent.getExtras());
        }
        super.n(intent);
        i1();
        h1();
        this.X.L = intent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
        j.h(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), intent, false, this.X.N);
        this.X.f184242w = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM);
        g gVar = this.X;
        if (gVar.f184242w == null) {
            gVar.f184242w = new HashMap<>(1);
        }
        this.f62123f.isShowQzoneAlbum = intent.getBooleanExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
        this.X.f184244y = intent.getBooleanExtra(PeakConstants.ALBUM_SHOW_ORI_BUTTON, false);
        this.X.f184245z = intent.getBooleanExtra(PeakConstants.IS_SHOW_QUALITY_COUNT_TV, true);
        this.X.f184241v = intent.getBooleanExtra(PeakConstants.IS_WAIT_DEST_RESULT, false);
        this.X.E = intent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
        this.X.F = intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
        this.X.H = intent.getIntExtra("uintype", -1);
        this.X.G = intent.getBooleanExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, false);
        this.X.I = intent.getStringExtra("uinname");
        this.X.J = intent.getStringExtra("uin");
        this.f62123f.filter.videoSizeLimit = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, -1L);
        this.X.f184243x = intent.getBooleanExtra(PeakConstants.IS_PREVIEW_VIDEO, true);
        this.f62123f.filter.videoMaxDuration = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, -1L);
        g gVar2 = this.X;
        if (!gVar2.A) {
            gVar2.A = intent.getBooleanExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, false);
        }
        g gVar3 = this.X;
        if (gVar3.A) {
            gVar3.B = (HashMap) intent.getSerializableExtra("PasterConstants.pasters_data");
            this.X.C = intent.getStringExtra("PasterConstants.paster_id");
            this.X.D = intent.getStringExtra("PasterConstants.paster_cate_id");
        }
        this.X.M = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_MAX_MEDIA_SIZE, -1L);
    }

    @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener
    public void onPhotoListDatasetDurationChanged(int i3, LocalMediaInfo localMediaInfo) {
        AEAbstractPhotoListFragment.e eVar;
        ArrayList<LocalMediaInfo> arrayList;
        LocalMediaInfo localMediaInfo2;
        String str;
        String str2;
        Handler handler = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).f62066l0;
        if (handler == null || (eVar = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).f62034h) == null || (arrayList = eVar.f62046d) == null || (localMediaInfo2 = arrayList.get(i3)) == null || localMediaInfo == null || (str = localMediaInfo2.path) == null || (str2 = localMediaInfo.path) == null || !str.equals(str2)) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 0;
        Bundle bundle = new Bundle();
        bundle.putInt("ALBUMLIST_POSITION", i3);
        bundle.putLong("ALBUMLIST_ITEM_DURATION", localMediaInfo.mDuration);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public boolean p() {
        return super.p();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public void w(View view) {
        super.w(view);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase
    protected void y0(boolean z16, Intent intent) {
        e.e();
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, false);
        ArrayList<String> arrayList = this.f62123f.selectedPhotoList;
        if (!z16) {
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        } else {
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.X.f184292c);
        }
        intent.putExtra(PeakConstants.USE_URL_PATH, false);
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f62123f.selectedMediaInfoHashMap);
        intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, 0);
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f62123f.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f62123f.albumId);
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra("PasterConstants.pasters_data", this.X.B);
        com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = ((GridLayoutManager) ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).Q.getLayoutManager()).findFirstVisibleItemPosition();
        intent.setClass(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), NewPhotoPreviewActivity.class);
        intent.addFlags(603979776);
        b1(intent);
        QAlbumUtil.anim(((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).getActivity(), true, true);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase, com.tencent.aelight.camera.ae.album.logic.c
    public boolean z(List<LocalMediaInfo> list, boolean z16) {
        int size;
        if (this.f62122e.get() == null || !super.z(list, z16)) {
            return false;
        }
        g gVar = this.X;
        if (gVar.f184290a) {
            gVar.f184290a = false;
            int i3 = gVar.f184297h;
            if (i3 == -1) {
                i3 = com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t;
            }
            if (i3 == -1) {
                LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f62123f.albumId);
                if (linkedHashMap != null && (size = linkedHashMap.size()) > 0) {
                    i3 = linkedHashMap.get(linkedHashMap.keySet().toArray()[size - 1]).intValue();
                }
                if (i3 == -1 && this.X.f184305p) {
                    Iterator<LocalMediaInfo> it = list.iterator();
                    int i16 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().selectStatus == 3) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                }
                PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
                ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
                if (i3 == -1 && photoCommonBaseData.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID) && !arrayList.isEmpty()) {
                    int size2 = list.size();
                    String str = arrayList.get(arrayList.size() - 1);
                    for (int i17 = 0; i17 < size2 && !str.equals(list.get(i17).path); i17++) {
                    }
                }
            } else {
                com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = -1;
            }
            int itemCount = ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).f62034h.getItemCount();
            if (itemCount != 0) {
                int i18 = itemCount - 1;
            }
            ((com.tencent.aelight.camera.ae.album.fragment.b) this.f62122e.get()).Q.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault.7
                @Override // java.lang.Runnable
                public void run() {
                    AEPhotoListLogicDefault.this.f62122e.get();
                }
            });
        }
        return true;
    }

    private void j1(boolean z16, int i3) {
        if (z16) {
            return;
        }
        this.Y.add(new b(i3));
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void t(View view, Bundle bundle, int i3, Intent intent) {
    }
}
