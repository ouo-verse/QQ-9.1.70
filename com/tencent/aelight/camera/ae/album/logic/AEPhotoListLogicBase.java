package com.tencent.aelight.camera.ae.album.logic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.logic.c;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.MovieExporter;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.util.VersionUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class AEPhotoListLogicBase<K extends AEAbstractPhotoListFragment> extends com.tencent.aelight.camera.ae.album.logic.c<K> implements c.InterfaceC0533c, c.a, c.b {
    private String F;
    private boolean G;
    private ArrayList<LocalMediaInfo> H;
    private float I;
    private float J;
    private String K;
    private Map<String, vp.b> L;
    private final Map<String, String> M;
    private String N;
    protected final boolean P;
    private com.tencent.aelight.camera.ae.view.c Q;
    private volatile boolean R;
    private volatile boolean S;
    private volatile CountDownLatch T;
    private int U;
    private int V;
    private float W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ms.a.f("AEPhotoListLogicBase", "batchCompressDialog cancel clicked");
            AEPhotoListLogicBase.this.R = true;
            AEPhotoListLogicBase.this.i0();
            if (AEPhotoListLogicBase.this.T != null) {
                AEPhotoListLogicBase.this.T.countDown();
            }
            AEPhotoListLogicBase.this.Q.cancel();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements ThreadExcutor.IThreadListener {
        c() {
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
            ms.a.a("AEPhotoListLogicBase", "onAdded--serialCompressVideos");
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            ms.a.a("AEPhotoListLogicBase", "onPostRun--serialCompressVideos");
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
            ms.a.a("AEPhotoListLogicBase", "onPreRun--serialCompressVideos");
        }
    }

    /* loaded from: classes32.dex */
    class d implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEAbstractPhotoListFragment.g f62097d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f62098e;

        d(AEAbstractPhotoListFragment.g gVar, int i3) {
            this.f62097d = gVar;
            this.f62098e = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!this.f62097d.f62058i.isChecked()) {
                return false;
            }
            AEPhotoListLogicBase.this.l0(this.f62098e, (LocalMediaInfo) AEPhotoListLogicBase.this.H.get(this.f62098e), this.f62097d);
            AEPhotoListLogicBase.this.j0(this.f62097d);
            AEPhotoListLogicBase.this.z0();
            if (!AEPhotoListLogicBase.this.G0().isEmpty()) {
                return true;
            }
            AEPhotoListLogicBase.this.f62122e.get().f62034h.notifyDataSetChanged();
            return true;
        }
    }

    /* loaded from: classes32.dex */
    class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f62100d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AEAbstractPhotoListFragment.g f62101e;

        e(int i3, AEAbstractPhotoListFragment.g gVar) {
            this.f62100d = i3;
            this.f62101e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!AEPhotoListLogicBase.this.h0()) {
                AEPhotoListLogicBase.this.J0(this.f62100d, this.f62101e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    class f implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEAbstractPhotoListFragment.g f62103d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f62104e;

        f(AEAbstractPhotoListFragment.g gVar, int i3) {
            this.f62103d = gVar;
            this.f62104e = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!this.f62103d.f62058i.isChecked()) {
                return false;
            }
            AEPhotoListLogicBase.this.l0(this.f62104e, (LocalMediaInfo) AEPhotoListLogicBase.this.H.get(this.f62104e), this.f62103d);
            AEPhotoListLogicBase.this.j0(this.f62103d);
            AEPhotoListLogicBase.this.z0();
            if (!AEPhotoListLogicBase.this.G0().isEmpty()) {
                return true;
            }
            AEPhotoListLogicBase.this.f62122e.get().f62034h.notifyDataSetChanged();
            return true;
        }
    }

    /* loaded from: classes32.dex */
    class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEAbstractPhotoListFragment.g f62106d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f62107e;

        g(AEAbstractPhotoListFragment.g gVar, int i3) {
            this.f62106d = gVar;
            this.f62107e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEPhotoListLogicBase.this.m0(this.f62106d.itemView, this.f62107e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AEPhotoListLogicBase(K k3) {
        super(k3);
        this.F = null;
        this.G = true;
        this.H = new ArrayList<>();
        this.L = new HashMap();
        this.M = new HashMap();
        this.N = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
        this.P = i.a();
        this.R = false;
        this.S = false;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.f62126m = this;
        this.C = this;
        this.D = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i3 = 0; i3 < this.H.size(); i3++) {
            if (str.equals(this.H.get(i3).path)) {
                return i3;
            }
        }
        return -1;
    }

    private LocalMediaInfo D0(String str) {
        HashMap<String, LocalMediaInfo> hashMap;
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
        LocalMediaInfo localMediaInfo = (photoCommonBaseData == null || (hashMap = photoCommonBaseData.selectedMediaInfoHashMap) == null) ? null : hashMap.get(str);
        if (localMediaInfo != null) {
            return localMediaInfo;
        }
        LinkedList<LocalMediaInfo> linkedList = new LinkedList(this.H);
        if (CollectionUtils.isEmpty(linkedList)) {
            return localMediaInfo;
        }
        for (LocalMediaInfo localMediaInfo2 : linkedList) {
            if (localMediaInfo2 != null && !TextUtils.isEmpty(localMediaInfo2.path) && localMediaInfo2.path.equals(str)) {
                return localMediaInfo2;
            }
        }
        return localMediaInfo;
    }

    private URLDrawable F0() {
        try {
            return URLDrawableHelper.getDrawable("https://downv6.qq.com/shadow_qqcamera/iOS/image/aeeditor_album_blank@2x.png");
        } catch (Exception e16) {
            ms.a.d("AEPhotoListLogicBase", "getNoPhotoTipDrawable---error: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> G0() {
        return this.f62123f.selectedPhotoList;
    }

    private void H0() {
        EditorPicInfo editorPicInfo;
        final ArrayList<AEAlbumMediaBaseModel> arrayList = new ArrayList<>();
        final ArrayList arrayList2 = new ArrayList();
        LinkedList linkedList = new LinkedList(this.f62123f.selectedPhotoList);
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            String str = (String) linkedList.get(i3);
            if (TextUtils.isEmpty(str)) {
                ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--empty path, drop it: " + str);
            } else if (!new File(str).exists()) {
                ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--file not exists, drop it: " + str);
            } else {
                LocalMediaInfo D0 = D0(str);
                if (D0 != null && QAlbumUtil.getMediaType(D0) == 1) {
                    int o16 = o(D0);
                    if (o16 != 2 && o16 != 0) {
                        ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--not supported video, drop it: " + str);
                    } else {
                        AEAlbumVideoModel aEAlbumVideoModel = new AEAlbumVideoModel(str);
                        aEAlbumVideoModel.setOriginPath(str);
                        arrayList.add(aEAlbumVideoModel);
                        if (o16 == 2) {
                            String str2 = this.M.get(str);
                            if (TextUtils.isEmpty(str2)) {
                                arrayList2.add(aEAlbumVideoModel);
                            } else {
                                ms.a.a("AEPhotoListLogicBase", "hit cache, no need compress for: " + str);
                                aEAlbumVideoModel.setPath(str2);
                            }
                        }
                    }
                } else {
                    vp.b T0 = T0(str);
                    if (T0 != null && (editorPicInfo = T0.f442129a) != null) {
                        AEAlbumImageModel aEAlbumImageModel = new AEAlbumImageModel(str, editorPicInfo);
                        aEAlbumImageModel.setOriginPath(str);
                        arrayList.add(aEAlbumImageModel);
                    } else {
                        ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--no crop info, drop it: " + str);
                    }
                }
            }
        }
        if (CollectionUtils.isEmpty(arrayList)) {
            ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForMixPhotoAndVideo--no media selected, should NOT happen");
            QQToast.makeText(this.f62122e.get().getActivity(), R.string.y5g, 0).show();
            return;
        }
        if (arrayList2.isEmpty()) {
            v0(arrayList);
            return;
        }
        if (this.Q == null) {
            com.tencent.aelight.camera.ae.view.c cVar = new com.tencent.aelight.camera.ae.view.c(this.f62122e.get().getActivity());
            this.Q = cVar;
            cVar.P(this.f62122e.get().getString(R.string.y_0));
            this.Q.O(new b());
        }
        this.Q.show();
        ms.a.a("AEPhotoListLogicBase", "after show, submit compress task");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.15
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f("AEPhotoListLogicBase", "serialCompressVideos---begin, need compress count=" + arrayList2.size());
                AEPhotoListLogicBase.this.S = false;
                AEPhotoListLogicBase.this.X0(arrayList2);
                ms.a.f("AEPhotoListLogicBase", "serialCompressVideos---end, canceled=" + AEPhotoListLogicBase.this.R);
                if (!AEPhotoListLogicBase.this.R && !AEPhotoListLogicBase.this.S) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                            AEPhotoListLogicBase.this.v0(arrayList);
                            AEPhotoListLogicBase.this.Q.dismiss();
                        }
                    });
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.15.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AEPhotoListLogicBase.this.Q.isShowing()) {
                                AEPhotoListLogicBase.this.Q.dismiss();
                            }
                        }
                    });
                }
                AEPhotoListLogicBase.this.R = false;
                AEPhotoListLogicBase.this.S = false;
            }
        }, 16, new c(), true);
    }

    private void I0() {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList(this.f62123f.selectedPhotoList);
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            String str = (String) linkedList.get(i3);
            if (TextUtils.isEmpty(str)) {
                ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForOnlyPhoto--empty path, drop it: " + str);
            } else {
                vp.b T0 = T0(str);
                if (T0 != null && T0.f442129a != null) {
                    if (!new File(str).exists()) {
                        ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForOnlyPhoto--file not exists, drop it: " + str);
                    } else {
                        arrayList.add(T0.f442129a);
                    }
                } else {
                    ms.a.c("AEPhotoListLogicBase", "handleClickNextBtnForOnlyPhoto--no crop info, drop it: " + str);
                }
            }
        }
        if (CollectionUtils.isEmpty(arrayList)) {
            QQToast.makeText(this.f62122e.get().getActivity(), R.string.y5f, 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(AEEditorConstants.CLIPPED_PIC_INFOS, arrayList);
        int b16 = js.a.B.b();
        if (gq.a.x(this.f62122e.get().getActivity().getIntent())) {
            b16 = js.a.D.b();
        }
        ar.a.e(this.f62122e.get().getActivity(), 0, bundle, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(int i3, AEAbstractPhotoListFragment.g gVar) {
        ms.a.a("AEPhotoListLogicBase", "handlePhotoItemClick, position = " + i3);
        LocalMediaInfo localMediaInfo = this.H.get(i3);
        if (!gVar.f62058i.isChecked() && gVar.f62056f.getVisibility() == 8) {
            ms.a.a("AEPhotoListLogicBase", "\u6ca1\u6709\u9009\u4e2d\uff0c\u6ca1\u6709focus\uff0c\u70b9\u51fb\u540e\u53d8\u9009\u4e2d\u4e14focus, position = " + i3);
            if (G0() != null && G0().size() + this.f62125i.initialHasPickedNum >= this.f62123f.maxSelectNum) {
                ms.a.a("AEPhotoListLogicBase", "handlePhotoItemClick, exceededPhotoLimit");
                Z0(i3, localMediaInfo, gVar);
                return;
            }
            Y0(gVar);
            Z0(i3, localMediaInfo, gVar);
            k0(i3);
            boolean R0 = R0();
            if (!R0) {
                this.U = this.f62122e.get().Q.getChildAt(i3 - this.f62122e.get().H.findFirstVisibleItemPosition()).getTop() + DisplayUtil.dip2px(this.f62122e.get().getActivity(), 2.0f);
            }
            if (!this.f62125i.canMixPhotoAndVideo) {
                u0(R0 ? 0 : 600);
            }
            o0(localMediaInfo.path, !R0, false);
            return;
        }
        if (gVar.f62058i.isChecked() && gVar.f62056f.getVisibility() == 8) {
            ms.a.a("AEPhotoListLogicBase", "\u9009\u4e2d\uff0c\u6ca1\u6709focus\uff0c\u70b9\u51fb\u540e\u53d8\u9009\u4e2d\u4e14focus, position = " + i3);
            Y0(gVar);
            boolean R02 = R0();
            k0(i3);
            if (!R02) {
                this.U = this.f62122e.get().Q.getChildAt(i3 - this.f62122e.get().H.findFirstVisibleItemPosition()).getTop() + DisplayUtil.dip2px(this.f62122e.get().getActivity(), 2.0f);
            }
            o0(localMediaInfo.path, !R02, false);
            return;
        }
        if (gVar.f62058i.isChecked() && gVar.f62056f.getVisibility() == 0) {
            if (G0().size() > 1) {
                ms.a.a("AEPhotoListLogicBase", "\u9009\u4e2d\uff0c\u6709focus\uff0c\u9009\u4e2d\u7684\u56fe\u5927\u4e8e\u4e00\u5f20\uff0c\u70b9\u51fb\u540e\u53d8\u672a\u9009\u4e2d\u4e14\u65e0focus, position = " + i3);
                j0(gVar);
                l0(i3, localMediaInfo, gVar);
                z0();
                return;
            }
            ms.a.a("AEPhotoListLogicBase", "\u9009\u4e2d\uff0c\u6709focus\uff0c\u9009\u4e2d\u7684\u56fe\u53ea\u6709\u8fd9\u4e00\u5f20\uff0c\u70b9\u51fb\u540e\u53d8\u672a\u9009\u4f46\u6709focus, position = " + i3);
            l0(i3, localMediaInfo, gVar);
            this.f62122e.get().f62034h.notifyDataSetChanged();
            return;
        }
        if (gVar.f62058i.isChecked() || gVar.f62056f.getVisibility() != 0) {
            return;
        }
        ms.a.a("AEPhotoListLogicBase", "\u6ca1\u6709\u9009\u4e2d\uff0c\u6709focus\uff0c\u70b9\u51fb\u540e\u53d8\u9009\u4e2d\u4e14focus, position = " + i3);
        Z0(i3, localMediaInfo, gVar);
        if (this.f62125i.canMixPhotoAndVideo) {
            return;
        }
        u0(0);
    }

    private boolean M0(ArrayList<String> arrayList, String str) {
        return arrayList.contains(str);
    }

    private boolean N0() {
        return (this.f62125i.canMixPhotoAndVideo || (G0().isEmpty() && this.f62125i.canPickVideo)) ? false : true;
    }

    private boolean O0() {
        ArrayList<String> arrayList;
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
        if (photoCommonBaseData == null || (arrayList = photoCommonBaseData.selectedPhotoList) == null || arrayList.size() <= 1) {
            return false;
        }
        return AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_RATIO_TOASTED, true, 0);
    }

    private EditorPicInfo Q0(String str) {
        EditorPicInfo editorPicInfo;
        ms.a.a("AEPhotoListLogicBase", "[prepareEditorPicInfo]");
        vp.b T0 = T0(str);
        if (T0 != null && (editorPicInfo = T0.f442129a) != null) {
            return editorPicInfo;
        }
        EditorPicInfo editorPicInfo2 = new EditorPicInfo();
        Size imageSize = BitmapUtil.getImageSize(str);
        editorPicInfo2.picPath = str;
        editorPicInfo2.originPicWidth = imageSize.getWidth();
        editorPicInfo2.originPicHeight = imageSize.getHeight();
        return editorPicInfo2;
    }

    private vp.b T0(String str) {
        ms.a.a("AEPhotoListLogicBase", "[queryPhotoCropInfo]");
        Map<String, vp.b> map = this.L;
        if (map == null || map.size() == 0) {
            return null;
        }
        return this.L.get(str);
    }

    private void U0(String str) {
        ms.a.a("AEPhotoListLogicBase", "[removePhotoCropInfo]");
        Map<String, vp.b> map = this.L;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.L.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        Activity activity;
        if (!VersionUtils.isrFroyo() || (activity = this.f62122e.get().getActivity()) == null) {
            return;
        }
        ((AudioManager) activity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }

    private void W0() {
        if (TextUtils.isEmpty(this.K)) {
            return;
        }
        LocalMediaInfo D0 = D0(this.K);
        if (D0 == null || QAlbumUtil.getMediaType(D0) == 0) {
            if (M0(this.f62123f.selectedPhotoList, this.K)) {
                EditorPicInfo f16 = this.f62122e.get().J.f(Q0(this.K));
                Matrix h16 = this.f62122e.get().J.h();
                if (f16 == null || h16 == null) {
                    return;
                }
                f0(this.K, f16, h16);
                return;
            }
            U0(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(ArrayList<AEAlbumVideoModel> arrayList) {
        final int size = arrayList.size();
        final int i3 = 0;
        while (i3 < size) {
            final AEAlbumVideoModel aEAlbumVideoModel = arrayList.get(i3);
            LocalMediaInfo D0 = D0(aEAlbumVideoModel.getPath());
            aEAlbumVideoModel.setOriginPath(aEAlbumVideoModel.getPath());
            i3++;
            this.T = new CountDownLatch(1);
            ms.a.f("AEPhotoListLogicBase", "batchCompress---begin, index=" + i3);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.17
                @Override // java.lang.Runnable
                public void run() {
                    AEPhotoListLogicBase.this.Q.P(AEPhotoListLogicBase.this.f62122e.get().getString(R.string.y7e, Integer.valueOf(i3), Integer.valueOf(size)));
                }
            });
            s0(D0, new MovieExporter.VideoCompressListener() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.18
                @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
                public void onCompressCanceled() {
                    ms.a.f("AEPhotoListLogicBase", "batchCompress---cancel, index=" + i3);
                    if (AEPhotoListLogicBase.this.T != null) {
                        AEPhotoListLogicBase.this.T.countDown();
                    }
                }

                @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
                public void onCompressError(AssetExportSession assetExportSession) {
                    ms.a.f("AEPhotoListLogicBase", "batchCompress---error, index=" + i3 + ", path=" + aEAlbumVideoModel.getPath());
                    AEPhotoListLogicBase.this.S = true;
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.18.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), R.string.y9y, 1).show();
                        }
                    });
                    if (AEPhotoListLogicBase.this.T != null) {
                        AEPhotoListLogicBase.this.T.countDown();
                    }
                }

                @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
                public void onCompressFinish(String str) {
                    ms.a.f("AEPhotoListLogicBase", "batchCompress---finish, index=" + i3 + ", compressed path=" + str);
                    AEPhotoListLogicBase.this.M.put(aEAlbumVideoModel.getPath(), str);
                    aEAlbumVideoModel.setPath(str);
                    if (AEPhotoListLogicBase.this.T != null) {
                        AEPhotoListLogicBase.this.T.countDown();
                    }
                }

                @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
                public void onCompressing(final float f16) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AEPhotoListLogicBase.this.Q.Q((int) (f16 * 100.0f));
                        }
                    });
                }

                @Override // com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener
                public void onCompressStart() {
                }
            });
            if (this.T != null) {
                try {
                    this.T.await();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                this.T = null;
            }
            if (this.R || this.S) {
                return;
            }
        }
    }

    private void Y0(AEAbstractPhotoListFragment.g gVar) {
        gVar.f62056f.setVisibility(0);
    }

    private void Z0(int i3, LocalMediaInfo localMediaInfo, AEAbstractPhotoListFragment.g gVar) {
        ms.a.a("AEPhotoListLogicBase", "[setSelected], photoPath=" + localMediaInfo.path);
        gVar.F.onClick(gVar.D);
        com.tencent.aelight.camera.aebase.c.f(this.f62125i.initialHasPickedNum > 0, true, this.f62122e.get().f62034h.getItemViewType(i3), i3, "1");
    }

    private boolean a1() {
        if (this.f62125i.canMixPhotoAndVideo || G0() == null) {
            return true;
        }
        String str = this.K;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        LocalMediaInfo D0 = D0(str);
        return D0 != null && (QAlbumUtil.getMediaType(D0) != 0 || D0.mediaWidth == D0.mediaHeight);
    }

    private void c1() {
        this.f62122e.get().K.releasePlayer(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        Activity activity;
        if (!VersionUtils.isrFroyo() || (activity = this.f62122e.get().getActivity()) == null) {
            return;
        }
        ((AudioManager) activity.getSystemService("audio")).abandonAudioFocus(null);
    }

    private void e1() {
        Intent intent = this.f62122e.get().getActivity().getIntent();
        AEAlbumLogicData aEAlbumLogicData = this.f62125i;
        if (aEAlbumLogicData.canMixPhotoAndVideo) {
            PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
            photoCommonBaseData.maxSelectNum = aEAlbumLogicData.maxSelectNumForMix;
            this.f62124h.f184293d = true;
            photoCommonBaseData.isSingleMode = false;
            return;
        }
        this.f62123f.maxSelectNum = aEAlbumLogicData.maxSelectNumForNormal;
        this.f62124h.f184293d = intent.getBooleanExtra(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, false);
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData2 = this.f62123f;
        if (photoCommonBaseData2.maxSelectNum > 1) {
            photoCommonBaseData2.isSingleMode = false;
        }
        if (intent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
            this.f62123f.isSingleMode = false;
        }
    }

    private void f0(String str, EditorPicInfo editorPicInfo, Matrix matrix) {
        ms.a.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo]");
        if (this.L == null) {
            ms.a.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], cropInfoMap=null");
            return;
        }
        vp.b T0 = T0(str);
        if (T0 == null) {
            T0 = new vp.b();
        }
        T0.f442129a = editorPicInfo;
        T0.f442130b = matrix;
        g0(str, T0);
    }

    private void g0(String str, vp.b bVar) {
        ms.a.a("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], inner");
        this.L.put(str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(AEAbstractPhotoListFragment.g gVar) {
        gVar.f62056f.setVisibility(8);
    }

    private void k0(int i3) {
        if (this.F.equals(this.H.get(i3).path)) {
            return;
        }
        ms.a.a("AEPhotoListLogicBase", "!currentFocusedImagePath.equals(mAllImages.get(position).path), position = " + i3);
        int B0 = B0(this.H, this.F);
        this.F = this.H.get(i3).path;
        if (B0 >= 0) {
            this.f62122e.get().f62034h.notifyItemChanged(B0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(int i3, LocalMediaInfo localMediaInfo, AEAbstractPhotoListFragment.g gVar) {
        gVar.F.onClick(gVar.D);
        ms.a.a("AEPhotoListLogicBase", "cancelSelected image.path = " + localMediaInfo.path);
        U0(localMediaInfo.path);
        com.tencent.aelight.camera.aebase.c.f(this.f62125i.initialHasPickedNum > 0, false, this.f62122e.get().f62034h.getItemViewType(i3), i3, "1");
    }

    private void n0(boolean z16) {
        String str;
        LocalMediaInfo localMediaInfo;
        int o16;
        WeakReference<K> weakReference = this.f62122e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (G0().isEmpty()) {
            ArrayList arrayList = new ArrayList(this.H);
            final int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    i3 = -1;
                    str = null;
                    break;
                }
                localMediaInfo = (LocalMediaInfo) arrayList.get(i3);
                if (localMediaInfo != null) {
                    if (this.f62125i.canMixPhotoAndVideo) {
                        if (QAlbumUtil.getMediaType(localMediaInfo) != 1 || (o16 = o(localMediaInfo)) == 0 || o16 == 2) {
                            break;
                        }
                    } else if (QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                        str = localMediaInfo.path;
                        break;
                    }
                }
                i3++;
            }
            str = localMediaInfo.path;
            this.F = str;
            q0(str, z16, true, false);
            if (i3 > 0) {
                this.f62122e.get().Q.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEPhotoListLogicBase.this.f62122e.get().H.scrollToPositionWithOffset(i3, 0);
                    }
                });
                return;
            }
            return;
        }
        ms.a.f("AEPhotoListLogicBase", "changeFocusAndPreviewWhenDataChanged---already picked some items, preview won't change");
    }

    private void q0(String str, boolean z16, boolean z17, boolean z18) {
        if (!StringUtil.isEmpty(str)) {
            if (this.f62125i.canMixPhotoAndVideo) {
                int mediaType = QAlbumUtil.getMediaType(E0(str));
                if (mediaType == 0) {
                    o0(str, z16, z17);
                    return;
                } else {
                    if (mediaType == 1) {
                        p0(str, z16, z17, z18);
                        return;
                    }
                    return;
                }
            }
            o0(str, z16, z17);
            return;
        }
        f1(true, false);
    }

    private void r0() {
        if (CollectionUtils.isEmpty(this.f62123f.selectedPhotoList)) {
            return;
        }
        Iterator it = new ArrayList(this.f62123f.selectedPhotoList).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            LocalMediaInfo D0 = D0(str);
            if (D0 == null) {
                ms.a.f("AEPhotoListLogicBase", "clearSelectedData---failed get media info at first, try another way");
                D0 = E0(str);
            }
            if (D0 != null) {
                D0.selectStatus = 2;
            } else {
                ms.a.c("AEPhotoListLogicBase", "clearSelectedData---still failed to get media info");
            }
        }
        Iterator<LocalMediaInfo> it5 = this.H.iterator();
        while (it5.hasNext()) {
            it5.next().selectStatus = 2;
        }
        this.f62123f.selectedPhotoList.clear();
        this.f62123f.selectedIndex.clear();
        this.f62123f.selectedMediaInfoHashMap.clear();
    }

    private void u0(int i3) {
        if (this.f62125i.canMixPhotoAndVideo || G0().size() != 1) {
            return;
        }
        if (i3 > 0) {
            this.f62122e.get().Q.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.9
                @Override // java.lang.Runnable
                public void run() {
                    AEPhotoListLogicBase.this.f62122e.get().f62034h.notifyDataSetChanged();
                }
            }, i3);
        } else {
            this.f62122e.get().f62034h.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(ArrayList<AEAlbumMediaBaseModel> arrayList) {
        Activity activity = this.f62122e.get().getActivity();
        Intent intent = activity.getIntent();
        if (gq.a.B(intent)) {
            ms.a.f("AEPhotoListLogicBase", "doRealJumpForMix---is additional pick case, setResult and finish");
            Intent intent2 = new Intent();
            intent2.putExtra(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, arrayList);
            activity.setResult(-1, intent2);
            activity.finish();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, arrayList);
        int b16 = js.a.B.b();
        if (gq.a.x(intent)) {
            b16 = js.a.D.b();
        }
        ar.a.e(activity, 2, bundle, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(String str, boolean z16) {
        W0();
        f1(false, true);
        this.K = str;
        this.f62122e.get().J.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(str, 1440, 1440));
        if (this.f62125i.canMixPhotoAndVideo && this.f62122e.get().J.k() == 1) {
            this.f62122e.get().J.m();
        }
        this.I = this.f62122e.get().J.j();
        this.J = this.f62122e.get().J.e();
        t0(this.f62122e.get().J.k());
        vp.b T0 = T0(str);
        if (T0 != null && T0.f442130b != null && M0(this.f62123f.selectedPhotoList, str)) {
            this.f62122e.get().J.setImageMatrix(T0.f442130b);
        } else {
            U0(str);
        }
        if (z16) {
            this.f62122e.get().G.i();
        }
        if (a1()) {
            this.f62122e.get().w();
        } else {
            this.f62122e.get().C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str, boolean z16, boolean z17) {
        ms.a.f("AEPhotoListLogicBase", "doShowPreviewVideo: " + str + ", autoPlay=" + z17);
        if (z16) {
            this.f62122e.get().G.i();
        }
        BaseVideoView baseVideoView = this.f62122e.get().K;
        if (str != null && str.equals(this.K)) {
            if (z17 && !baseVideoView.isPlaying()) {
                ms.a.f("AEPhotoListLogicBase", "doShowPreviewVideo---same as the last previewed path, just resume play");
                baseVideoView.play();
            }
            ms.a.f("AEPhotoListLogicBase", "doShowPreviewVideo---same as the last previewed path, quick return");
            return;
        }
        f1(false, false);
        W0();
        this.K = str;
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mIsLoop = true;
        videoPlayParam.mIsLocal = true;
        videoPlayParam.mIsMute = false;
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mSceneId = 126;
        videoPlayParam.mSceneName = SceneID.getSceneStr(126);
        videoPlayParam.mVideoPath = str;
        videoPlayParam.mCallback = new a(videoPlayParam, str);
        baseVideoView.setVideoParam(videoPlayParam);
        baseVideoView.play();
        if (z17) {
            return;
        }
        baseVideoView.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        if (G0().isEmpty()) {
            return;
        }
        ms.a.a("AEPhotoListLogicBase", "mPhotoCommonData.selectedPhotoList.size() = " + G0().size());
        String str = G0().get(G0().size() - 1);
        int i3 = 0;
        while (true) {
            if (i3 >= this.H.size()) {
                i3 = -1;
                break;
            } else if (this.H.get(i3).path.equals(str)) {
                break;
            } else {
                i3++;
            }
        }
        ms.a.a("AEPhotoListLogicBase", "!mPhotoCommonData.selectedPhotoList.isEmpty(), lastImagePosition = " + i3);
        if (i3 >= 0) {
            this.F = str;
            this.f62122e.get().f62034h.notifyDataSetChanged();
        }
        q0(str, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String A0(LocalMediaInfo localMediaInfo) {
        return this.f62122e.get().getResources().getString(R.string.cu_, Integer.valueOf(this.f62123f.maxSelectNum));
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void B(int i3) {
        this.V = i3;
        this.W = 0.0f;
        if (i3 == 1) {
            this.f62122e.get().P.setVisibility(0);
            this.f62122e.get().w();
            if (this.f62125i.canSwitchSelectionMode) {
                this.f62122e.get().S.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void C(float f16) {
        this.f62122e.get().P.setAlpha(f16);
        float f17 = 1.0f - f16;
        if (this.U != 0 && this.V == 2) {
            this.f62122e.get().Q.scrollBy(0, (int) (this.U * (f17 - this.W)));
        }
        this.W = f17;
    }

    public LocalMediaInfo E0(String str) {
        LocalMediaInfo localMediaInfo;
        HashMap<String, LocalMediaInfo> hashMap;
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
        HashMap<String, LocalMediaInfo> hashMap2 = photoCommonBaseData.selectedMediaInfoHashMap;
        LocalMediaInfo localMediaInfo2 = hashMap2 != null ? hashMap2.get(str) : null;
        if (localMediaInfo2 == null && (hashMap = photoCommonBaseData.allMediaInfoHashMap) != null) {
            localMediaInfo2 = hashMap.get(str);
        }
        if (localMediaInfo2 != null && (localMediaInfo2.mediaWidth == 0 || localMediaInfo2.mediaHeight == 0)) {
            d.a aVar = new d.a();
            com.tencent.mobileqq.shortvideo.util.d.a(str, aVar);
            int[] iArr = aVar.f288248a;
            localMediaInfo2.mediaWidth = iArr[0];
            localMediaInfo2.mediaHeight = iArr[1];
            localMediaInfo2.rotation = iArr[2];
            HashMap<String, LocalMediaInfo> hashMap3 = photoCommonBaseData.allMediaInfoHashMap;
            if (hashMap3 != null && (localMediaInfo = hashMap3.get(str)) != null && (localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0)) {
                localMediaInfo.mediaWidth = localMediaInfo2.mediaWidth;
                localMediaInfo.mediaHeight = localMediaInfo2.mediaHeight;
                localMediaInfo.rotation = localMediaInfo2.rotation;
            }
        }
        return localMediaInfo2;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void F() {
        this.f62122e.get().S.setVisibility(this.f62125i.canSwitchSelectionMode ? 0 : 8);
        P0(this.f62125i.canMixPhotoAndVideo);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void H(ArrayList<LocalMediaInfo> arrayList, boolean z16) {
        this.H = arrayList;
        n0(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void I() {
        ArrayList<String> arrayList = this.f62123f.selectedPhotoList;
        this.f62122e.get().getString(R.string.ctx);
        if (arrayList.size() > 0) {
            arrayList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L0(int i3, AEAbstractPhotoListFragment.g gVar) {
        ms.a.a("AEPhotoListLogicBase", "handleVideoItemClickForMix, position = " + i3);
        LocalMediaInfo localMediaInfo = this.H.get(i3);
        if (!gVar.f62058i.isChecked() && gVar.f62056f.getVisibility() == 8) {
            ms.a.a("AEPhotoListLogicBase", "\u6ca1\u6709\u9009\u4e2d\uff0c\u6ca1\u6709focus\uff0c\u70b9\u51fb\u540e\u53d8\u9009\u4e2d\u4e14focus, position = " + i3);
            if (G0() != null && G0().size() + this.f62125i.initialHasPickedNum >= this.f62123f.maxSelectNum) {
                ms.a.a("AEPhotoListLogicBase", "handleVideoItemClickForMix, exceededPhotoLimit");
                Z0(i3, localMediaInfo, gVar);
                return;
            }
            Y0(gVar);
            Z0(i3, localMediaInfo, gVar);
            k0(i3);
            boolean R0 = R0();
            if (!R0) {
                this.U = this.f62122e.get().Q.getChildAt(i3 - this.f62122e.get().H.findFirstVisibleItemPosition()).getTop() + DisplayUtil.dip2px(this.f62122e.get().getActivity(), 2.0f);
            }
            p0(localMediaInfo.path, !R0, false, true);
            return;
        }
        if (gVar.f62058i.isChecked() && gVar.f62056f.getVisibility() == 8) {
            ms.a.a("AEPhotoListLogicBase", "\u9009\u4e2d\uff0c\u6ca1\u6709focus\uff0c\u70b9\u51fb\u540e\u53d8\u9009\u4e2d\u4e14focus, position = " + i3);
            Y0(gVar);
            k0(i3);
            boolean R02 = R0();
            if (!R02) {
                this.U = this.f62122e.get().Q.getChildAt(i3 - this.f62122e.get().H.findFirstVisibleItemPosition()).getTop() + DisplayUtil.dip2px(this.f62122e.get().getActivity(), 2.0f);
            }
            p0(localMediaInfo.path, !R02, false, true);
            return;
        }
        if (gVar.f62058i.isChecked() && gVar.f62056f.getVisibility() == 0) {
            if (G0().size() > 1) {
                ms.a.a("AEPhotoListLogicBase", "\u9009\u4e2d\uff0c\u6709focus\uff0c\u9009\u4e2d\u7684\u56fe\u5927\u4e8e\u4e00\u5f20\uff0c\u70b9\u51fb\u540e\u53d8\u672a\u9009\u4e2d\u4e14\u65e0focus, position = " + i3);
                j0(gVar);
                l0(i3, localMediaInfo, gVar);
                z0();
                return;
            }
            ms.a.a("AEPhotoListLogicBase", "\u9009\u4e2d\uff0c\u6709focus\uff0c\u9009\u4e2d\u7684\u56fe\u53ea\u6709\u8fd9\u4e00\u5f20\uff0c\u70b9\u51fb\u540e\u53d8\u672a\u9009\u4f46\u6709focus, position = " + i3);
            l0(i3, localMediaInfo, gVar);
            this.f62122e.get().f62034h.notifyDataSetChanged();
            return;
        }
        if (gVar.f62058i.isChecked() || gVar.f62056f.getVisibility() != 0) {
            return;
        }
        ms.a.a("AEPhotoListLogicBase", "\u6ca1\u6709\u9009\u4e2d\uff0c\u6709focus\uff0c\u70b9\u51fb\u540e\u53d8\u9009\u4e2d\u4e14focus, position = " + i3);
        Z0(i3, localMediaInfo, gVar);
        boolean R03 = R0();
        if (!R03) {
            this.U = this.f62122e.get().Q.getChildAt(i3 - this.f62122e.get().H.findFirstVisibleItemPosition()).getTop() + DisplayUtil.dip2px(this.f62122e.get().getActivity(), 2.0f);
        }
        p0(localMediaInfo.path, !R03, false, true);
    }

    protected void P0(boolean z16) {
        e1();
        this.f62122e.get().K(z16);
        if (z16) {
            this.f62122e.get().w();
            int k3 = this.f62122e.get().J.k();
            if (k3 == 1) {
                K0(k3);
                this.f62122e.get().J.m();
            }
        } else {
            int k16 = this.f62122e.get().J.k();
            if (k16 == 2) {
                K0(k16);
                this.f62122e.get().J.m();
            }
            if (!a1()) {
                this.f62122e.get().C();
            }
            r0();
        }
        n0(true);
        this.f62122e.get().f62034h.notifyDataSetChanged();
        I();
    }

    protected boolean R0() {
        return this.f62122e.get().G.m();
    }

    protected void S0(AEAbstractPhotoListFragment.g gVar, LocalMediaInfo localMediaInfo) {
        throw null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c.a
    public void b(int i3, AEAbstractPhotoListFragment.g gVar, AEAbstractPhotoListFragment.f fVar) {
        URL generateAlbumThumbURL;
        View view;
        if (this.f62123f.maxSelectNum > 100) {
            gVar.f62058i.setTextSize(10.0f);
        }
        if (this.f62125i.canMixPhotoAndVideo) {
            if (this.G) {
                this.G = false;
                this.F = this.H.get(i3).path;
                gVar.f62056f.setVisibility(0);
            } else {
                gVar.f62056f.setVisibility(this.F.equals(this.H.get(i3).path) ? 0 : 8);
            }
        } else {
            gVar.f62056f.setVisibility(8);
        }
        gVar.F = fVar;
        if (!this.f62123f.isSingleMode && this.f62124h.f184293d && (view = gVar.D) != null) {
            view.setVisibility(0);
        } else {
            gVar.D.setVisibility(8);
        }
        f fVar2 = new f(gVar, i3);
        gVar.f62058i.setOnTouchListener(fVar2);
        gVar.D.setOnTouchListener(fVar2);
        gVar.itemView.setOnClickListener(new g(gVar, i3));
        gVar.F.b(i3);
        gVar.F.a(gVar.f62058i);
        ImageView imageView = gVar.f62055e;
        imageView.setAdjustViewBounds(false);
        LocalMediaInfo p16 = this.f62122e.get().f62034h.p(i3);
        gVar.itemView.setContentDescription(QAlbumUtil.createContentDescription(1, p16, i3));
        if (p16.isSystemMeidaStore) {
            generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(p16, "VIDEO");
        } else {
            generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(p16, "APP_VIDEO");
        }
        int i16 = AlbumThumbDownloader.THUMB_WIDHT;
        p16.thumbHeight = i16;
        p16.thumbWidth = i16;
        URLDrawable uRLDrawable = gVar.f62059m;
        if (uRLDrawable == null || !uRLDrawable.getURL().equals(generateAlbumThumbURL)) {
            if (QLog.isColorLevel()) {
                QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + generateAlbumThumbURL.toString());
            }
            URLDrawable drawable = URLDrawableHelper.getDrawable(generateAlbumThumbURL, this.f62122e.get().f62034h.f62048f, this.f62122e.get().f62034h.f62047e);
            drawable.setTag(p16);
            imageView.setImageDrawable(drawable);
            ((URLImageView) imageView).setURLDrawableDownListener(this.f62122e.get().f62034h);
            gVar.f62059m = drawable;
            if (uRLDrawable != null) {
                uRLDrawable.cancelDownload();
            }
        }
        TextView textView = gVar.C;
        if (!p16.isSystemMeidaStore && p16.mDuration <= 0) {
            textView.setVisibility(8);
            MediaScanner mediaScanner = MediaScanner.getInstance(BaseApplication.getContext());
            if (mediaScanner != null) {
                mediaScanner.queryMediaInfoDuration(this, p16, i3);
            }
        } else {
            textView.setVisibility(0);
            textView.setText(QAlbumUtil.formatTimeToString(p16.mDuration));
        }
        int i17 = p16.selectStatus;
        if (i17 == 1) {
            gVar.f62058i.setCheckedNumber(this.f62123f.selectedPhotoList.indexOf(p16.path) + 1 + this.f62125i.initialHasPickedNum);
            if (gVar.itemView.getBackground() != null) {
                gVar.itemView.setBackgroundDrawable(null);
            }
        } else if (i17 == 3) {
            gVar.f62058i.setChecked(false);
        } else {
            gVar.f62058i.setChecked(false);
            if (gVar.itemView.getBackground() != null) {
                gVar.itemView.setBackgroundDrawable(null);
            }
        }
        p16.visableTime = SystemClock.uptimeMillis();
        p16.listViewPosition = i3;
        if (!N0()) {
            int size = this.f62123f.selectedPhotoList.size() + this.f62125i.initialHasPickedNum;
            PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
            if (size < photoCommonBaseData.maxSelectNum || i17 == 1 || photoCommonBaseData.isSingleMode) {
                gVar.f62055e.setAlpha(1.0f);
                return;
            }
        }
        gVar.f62055e.setAlpha(0.3f);
    }

    public void b1(Intent intent) {
        this.f62122e.get().startActivity(intent);
        this.f62122e.get().getActivity().finish();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c.a
    public View c() {
        View inflate = this.f62122e.get().f62034h.f62049h.inflate(R.layout.dlc, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(this.f62122e.get().f62040m, this.f62122e.get().C));
        return inflate;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c.a
    public View d() {
        View inflate = this.f62122e.get().f62034h.f62049h.inflate(R.layout.dlb, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(this.f62122e.get().f62040m, this.f62122e.get().C));
        return inflate;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c.a
    public View f() {
        ImageView imageView = new ImageView(this.f62122e.get().getActivity());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(this.f62122e.get().f62040m, this.f62122e.get().C));
        imageView.setBackgroundColor(-16777216);
        imageView.setImageResource(R.drawable.d3v);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c.a
    public void g(int i3, AEAbstractPhotoListFragment.g gVar, AEAbstractPhotoListFragment.f fVar) {
        View view;
        if (this.f62123f.maxSelectNum > 100) {
            gVar.f62058i.setTextSize(10.0f);
        }
        gVar.F = fVar;
        if (this.G) {
            this.G = false;
            this.F = this.H.get(i3).path;
            gVar.f62056f.setVisibility(0);
        } else {
            gVar.f62056f.setVisibility(this.F.equals(this.H.get(i3).path) ? 0 : 8);
        }
        if (!this.f62123f.isSingleMode && (view = gVar.D) != null) {
            view.setVisibility(0);
        }
        d dVar = new d(gVar, i3);
        gVar.f62058i.setOnTouchListener(dVar);
        gVar.D.setOnTouchListener(dVar);
        gVar.F.b(i3);
        gVar.F.a(gVar.f62058i);
        gVar.itemView.setOnClickListener(new e(i3, gVar));
        ImageView imageView = gVar.f62055e;
        imageView.setAdjustViewBounds(false);
        LocalMediaInfo p16 = this.f62122e.get().f62034h.p(i3);
        gVar.itemView.setContentDescription(QAlbumUtil.createContentDescription(0, p16, i3));
        if (p16 != null) {
            gVar.f62054d.setVisibility(4);
            if (this.f62124h.f184308s && this.f62122e.get().y(p16)) {
                if (gVar.E == null) {
                    TextView q16 = this.f62122e.get().f62034h.q();
                    gVar.E = q16;
                    q16.setText("GIF");
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(12);
                    ((RelativeLayout) gVar.itemView).addView(gVar.E, layoutParams);
                }
                gVar.E.setVisibility(0);
            } else {
                TextView textView = gVar.E;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
            int i16 = AlbumThumbDownloader.THUMB_WIDHT;
            p16.thumbHeight = i16;
            p16.thumbWidth = i16;
            URLDrawable uRLDrawable = gVar.f62059m;
            if (uRLDrawable == null || !uRLDrawable.getURL().toString().equals(QAlbumUtil.PROTOCOL_ALBUM_THUMB + QzoneWebViewOfflinePlugin.STR_DEVIDER + p16.path)) {
                URL generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(p16);
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoListActivity", 2, "photoGridAdapter,getView(),image url :" + generateAlbumThumbURL.toString());
                }
                URLDrawable drawable = URLDrawableHelper.getDrawable(generateAlbumThumbURL, this.f62122e.get().f62034h.f62048f, this.f62122e.get().f62034h.f62047e);
                drawable.setTag(p16);
                imageView.setImageDrawable(drawable);
                ((URLImageView) imageView).setURLDrawableDownListener(this.f62122e.get().f62034h);
                gVar.f62059m = drawable;
            }
            int i17 = p16.selectStatus;
            if (i17 == 1) {
                gVar.f62058i.setCheckedNumber(this.f62123f.selectedPhotoList.indexOf(p16.path) + 1 + this.f62125i.initialHasPickedNum);
                if (gVar.itemView.getBackground() != null) {
                    gVar.itemView.setBackgroundDrawable(null);
                }
            } else if (i17 == 3) {
                gVar.f62058i.setChecked(false);
            } else {
                gVar.f62058i.setChecked(false);
                if (gVar.itemView.getBackground() != null) {
                    gVar.itemView.setBackgroundDrawable(null);
                }
            }
            if (AppSetting.f99565y) {
                gVar.f62058i.setContentDescription(QAlbumUtil.createContentDescriptionWithCheckBox(0, p16, i3, gVar.f62058i.isChecked()));
            }
            p16.visableTime = SystemClock.uptimeMillis();
            p16.listViewPosition = i3;
            S0(gVar, p16);
            int size = this.f62123f.selectedPhotoList.size() + this.f62125i.initialHasPickedNum;
            PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
            if (size >= photoCommonBaseData.maxSelectNum && i17 != 1 && !photoCommonBaseData.isSingleMode) {
                gVar.f62055e.setAlpha(0.3f);
            } else {
                gVar.f62055e.setAlpha(1.0f);
            }
        }
    }

    protected boolean h0() {
        throw null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void i() {
        if (!this.f62124h.f184291b) {
            AlbumThumbManager.getInstance(this.f62122e.get().getActivity()).clear();
        }
        if (this.f62122e.get().f62034h != null) {
            QAlbumUtil.sLastAlbumPhotoCountMap.put(this.f62123f.albumId, Integer.valueOf(this.f62122e.get().f62034h.getItemCount()));
        }
        if (this.f62122e.get().f62039k0 != null) {
            this.f62122e.get().f62039k0.cancel(true);
        }
        Map<String, vp.b> map = this.L;
        if (map != null) {
            map.clear();
        }
        this.K = null;
        h();
    }

    protected void i0() {
        throw null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void j() {
        com.tencent.mobileqq.activity.photo.album.photolist.e eVar = this.f62124h;
        if (eVar.f184298i) {
            this.f62122e.get().getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.13
                @Override // java.lang.Runnable
                public void run() {
                    if (AEPhotoListLogicBase.this.f62122e.get().f62039k0 == null) {
                        AEPhotoListLogicBase.this.f62122e.get().r(true, true);
                    }
                }
            });
        } else {
            eVar.f184298i = true;
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void k(Intent intent) {
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        HashMap hashMap2 = new HashMap(hashMap);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            HashMap<String, LocalMediaInfo> hashMap3 = this.f62123f.allMediaInfoHashMap;
            LocalMediaInfo localMediaInfo = hashMap3 != null ? hashMap3.get(next) : null;
            if (localMediaInfo != null) {
                hashMap2.put(next, localMediaInfo);
            } else {
                LocalMediaInfo localMediaInfo2 = hashMap.get(next);
                if (localMediaInfo2 != null) {
                    hashMap2.put(next, localMediaInfo2);
                }
            }
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f62123f.albumId);
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f62123f.albumName);
    }

    public void m0(View view, int i3) {
        throw null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void n(Intent intent) {
        String str;
        this.f62124h.f184305p = intent.getBooleanExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        if (intent.getBooleanExtra(QAlbumConstants.ALBUM_ENTER_DIRECTLY, false)) {
            long currentTimeMillis = System.currentTimeMillis() - QAlbumUtil.sLastAlbumRecordTime;
            if (this.f62124h.f184305p && currentTimeMillis < 60000) {
                PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
                photoCommonBaseData.albumName = QAlbumUtil.sLastAlbumName;
                photoCommonBaseData.albumId = QAlbumUtil.sLastAlbumId;
            }
        } else {
            this.f62123f.albumName = intent.getStringExtra(QAlbumConstants.ALBUM_NAME);
            this.f62123f.albumId = intent.getStringExtra(QAlbumConstants.ALBUM_ID);
        }
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData2 = this.f62123f;
        if (photoCommonBaseData2.albumId == null) {
            photoCommonBaseData2.albumId = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
            photoCommonBaseData2.albumName = null;
        }
        this.f62124h.f184308s = intent.getBooleanExtra(QAlbumConstants.SHOW_GIF_TYPE_ICON, false);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            this.f62123f.selectedPhotoList = stringArrayListExtra;
        }
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData3 = this.f62123f;
        if (photoCommonBaseData3.selectedPhotoList == null) {
            photoCommonBaseData3.selectedPhotoList = new ArrayList<>();
        }
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData4 = this.f62123f;
        if (photoCommonBaseData4.selectedMediaInfoHashMap == null) {
            photoCommonBaseData4.selectedMediaInfoHashMap = new HashMap<>();
        }
        HashMap hashMap = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        if (hashMap != null && !hashMap.isEmpty() && this.f62123f.selectedPhotoList.size() == hashMap.size()) {
            this.f62123f.selectedMediaInfoHashMap.clear();
            this.f62123f.selectedMediaInfoHashMap.putAll(hashMap);
        }
        this.f62123f.selectedIndex = new ArrayList<>();
        this.f62123f.isSingleMode = intent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
        this.f62123f.showMediaType = intent.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData5 = this.f62123f;
        photoCommonBaseData5.filter = MediaFileFilter.getFilter(photoCommonBaseData5.showMediaType);
        this.f62124h.f184306q = intent.getBooleanExtra(QAlbumConstants.IS_SHOW_CAMERA, false);
        com.tencent.mobileqq.activity.photo.album.photolist.e eVar = this.f62124h;
        if (eVar.f184306q) {
            eVar.f184307r = intent.getBooleanExtra(QAlbumConstants.SHOW_CAMERA_IN_VIDEO, false);
        }
        this.f62123f.filter.videoMaxDuration = intent.getLongExtra(QAlbumConstants.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT, Long.MAX_VALUE);
        if (this.f62123f.showMediaType == 2) {
            str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
        } else {
            str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
        }
        this.N = str;
        this.f62125i.maxSelectNumForNormal = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        AEAlbumLogicData aEAlbumLogicData = this.f62125i;
        aEAlbumLogicData.minSelectNumForMix = 2;
        aEAlbumLogicData.maxSelectNumForMix = 30;
        aEAlbumLogicData.minSelectNumForNormal = Integer.MIN_VALUE;
        aEAlbumLogicData.canMixPhotoAndVideo = intent.getBooleanExtra(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO, false);
        this.f62125i.canSwitchSelectionMode = intent.getBooleanExtra(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE, true);
        this.f62125i.initialHasPickedNum = this.f62122e.get().getActivity().getIntent().getIntExtra(PeakConstants.BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM, 0);
        this.f62125i.canPickVideo = this.f62122e.get().getActivity().getIntent().getBooleanExtra(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO, true);
        e1();
        ms.a.f("AEPhotoListLogicBase", "initData---aeAlbumData=" + this.f62125i);
    }

    protected void o0(final String str, final boolean z16, boolean z17) {
        ms.a.f("AEPhotoListLogicBase", "checkShowImagePreview--");
        if (!z17) {
            w0(str, z16);
        } else {
            this.f62122e.get().J.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.10
                @Override // java.lang.Runnable
                public void run() {
                    AEPhotoListLogicBase.this.w0(str, z16);
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public boolean p() {
        return true;
    }

    protected void p0(final String str, final boolean z16, boolean z17, final boolean z18) {
        ms.a.f("AEPhotoListLogicBase", "checkShowVideoPreview--");
        if (!z17) {
            x0(str, z16, z18);
        } else {
            this.f62122e.get().J.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.11
                @Override // java.lang.Runnable
                public void run() {
                    AEPhotoListLogicBase.this.x0(str, z16, z18);
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void q(boolean z16) {
        super.q(z16);
        if (z16 || TextUtils.isEmpty(this.f62123f.albumName) || this.N.equals(this.f62123f.albumName)) {
            return;
        }
        this.N = this.f62123f.albumName;
        if (!CollectionUtils.isEmpty(this.H)) {
            this.U = this.f62122e.get().Q.getChildAt(0 - this.f62122e.get().H.findFirstVisibleItemPosition()).getTop() + DisplayUtil.dip2px(this.f62122e.get().getActivity(), 2.0f);
        }
        this.f62122e.get().G.i();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void r() {
        AEAlbumLogicData aEAlbumLogicData = this.f62125i;
        boolean z16 = !aEAlbumLogicData.canMixPhotoAndVideo;
        aEAlbumLogicData.canMixPhotoAndVideo = z16;
        P0(z16);
        com.tencent.aelight.camera.ae.report.b.b().B(this.f62125i.canMixPhotoAndVideo);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void s(View view) {
        ArrayList<String> arrayList = this.f62123f.selectedPhotoList;
        if (arrayList.size() == 0 && !TextUtils.isEmpty(this.K)) {
            arrayList.add(this.K);
        }
        W0();
        if (this.f62125i.canMixPhotoAndVideo) {
            H0();
        } else {
            I0();
        }
    }

    protected void s0(LocalMediaInfo localMediaInfo, MovieExporter.VideoCompressListener videoCompressListener) {
        throw null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void u(float f16) {
        this.f62122e.get().P.setAlpha(f16);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void v(View view) {
        int k3 = this.f62122e.get().J.k();
        if (k3 == 1) {
            com.tencent.aelight.camera.ae.report.b.b().A(0);
        } else if (k3 == 2) {
            com.tencent.aelight.camera.ae.report.b.b().A(1);
        }
        if (O0()) {
            AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_AE_RATIO_TOASTED, false, 0);
            d1(k3);
        }
        K0(k3);
        this.f62122e.get().J.m();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void w(View view) {
        y0(false, this.f62122e.get().getActivity().getIntent());
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void x() {
        if (this.f62122e.get().G.l()) {
            this.f62122e.get().G.i();
        }
    }

    void y0(boolean z16, Intent intent) {
        throw null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public boolean z(List<LocalMediaInfo> list, boolean z16) {
        if (this.f62122e.get() == null || this.f62122e.get().getActivity() == null) {
            return false;
        }
        this.f62122e.get().getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.6
            @Override // java.lang.Runnable
            public void run() {
                AEPhotoListLogicBase.this.f62122e.get().n();
            }
        });
        if (list == null) {
            if ((this.f62124h.f184306q && this.f62123f.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) || (this.f62124h.f184307r && this.f62123f.albumId.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID))) {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.mMimeType = MimeHelper.MIME_TYPE_MOBILEQQ_CAMERA;
                ArrayList arrayList = new ArrayList();
                arrayList.add(0, localMediaInfo);
                list = arrayList;
            }
            this.f62122e.get().f62034h.t(list, true);
            this.f62122e.get().getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.7
                @Override // java.lang.Runnable
                public void run() {
                    AEPhotoListLogicBase.this.f62122e.get().f62034h.notifyDataSetChanged();
                    AEPhotoListLogicBase.this.I();
                    QQToast.makeText(AEPhotoListLogicBase.this.f62122e.get().getActivity(), "\u6682\u65e0\u5a92\u4f53\u6587\u4ef6", 1000).show();
                }
            });
            return false;
        }
        if ((this.f62124h.f184306q && this.f62123f.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) || (this.f62124h.f184307r && this.f62123f.albumId.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID))) {
            LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
            localMediaInfo2.mMimeType = MimeHelper.MIME_TYPE_MOBILEQQ_CAMERA;
            list.add(0, localMediaInfo2);
        }
        this.f62122e.get().f62034h.t(list, z16);
        final boolean isEmpty = list.isEmpty();
        this.f62122e.get().getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.8
            @Override // java.lang.Runnable
            public void run() {
                if (isEmpty) {
                    QQToast.makeText(AEPhotoListLogicBase.this.f62122e.get().getActivity(), "\u6682\u65e0\u5a92\u4f53\u6587\u4ef6", 1000).show();
                }
                AEPhotoListLogicBase.this.f62122e.get().f62034h.notifyDataSetChanged();
                AEPhotoListLogicBase.this.f62122e.get().f62027d.I();
            }
        });
        return true;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void A(int i3, boolean z16) {
        this.W = 0.0f;
        this.U = 0;
        if (i3 == 2 && z16) {
            this.f62122e.get().P.setVisibility(8);
            if (a1()) {
                this.f62122e.get().w();
            } else {
                this.f62122e.get().C();
            }
            if (this.f62125i.canSwitchSelectionMode) {
                this.f62122e.get().S.setVisibility(0);
            }
        }
    }

    private void d1(int i3) {
        if (i3 == 1) {
            QQToast.makeText(BaseApplication.getContext(), BaseApplication.getContext().getResources().getString(R.string.f169866y13), 1).show();
        } else if (i3 == 2) {
            QQToast.makeText(BaseApplication.getContext(), BaseApplication.getContext().getResources().getString(R.string.f169867y14), 1).show();
        }
    }

    private void t0(int i3) {
        if (i3 == 1) {
            this.f62122e.get().J.setGestureEnabled(true);
            this.f62122e.get().J.setMinZoom(this.J);
        } else if (i3 == 2) {
            this.f62122e.get().J.setGestureEnabled(true);
            this.f62122e.get().J.setMinZoom(this.I);
        }
    }

    private void K0(int i3) {
        ArrayList<String> arrayList;
        Iterator<String> it;
        ms.a.f("AEPhotoListLogicBase", "handlePhotoRatioChanged---lastRatio=" + i3);
        int i16 = 1;
        if (i3 == 1) {
            t0(2);
        } else if (i3 == 2) {
            t0(1);
        }
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62123f;
        if (photoCommonBaseData == null || (arrayList = photoCommonBaseData.selectedPhotoList) == null) {
            return;
        }
        Iterator<String> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            String next = it5.next();
            Size imageSize = BitmapUtil.getImageSize(next);
            EditorPicInfo editorPicInfo = new EditorPicInfo();
            editorPicInfo.picPath = next;
            editorPicInfo.originPicWidth = imageSize.getWidth();
            double height = imageSize.getHeight();
            editorPicInfo.originPicHeight = height;
            double d16 = editorPicInfo.originPicWidth;
            double d17 = (d16 * 1.0d) / height;
            if (i3 != i16) {
                it = it5;
                if (i3 == 2) {
                    if (d17 < 1.0d) {
                        editorPicInfo.f66186x = 0.0d;
                        editorPicInfo.f66187y = (((height - d16) * 1.0d) / 2.0d) / height;
                        editorPicInfo.f66185w = 1.0d;
                        editorPicInfo.f66184h = d17;
                    } else {
                        editorPicInfo.f66186x = (((d16 - height) * 1.0d) / 2.0d) / d16;
                        editorPicInfo.f66187y = 0.0d;
                        editorPicInfo.f66185w = d17;
                        editorPicInfo.f66184h = 1.0d;
                    }
                }
            } else if (d17 <= 0.3333333432674408d) {
                it = it5;
                editorPicInfo.f66186x = 0.0d;
                editorPicInfo.f66187y = (((height - (d16 / 0.3333333432674408d)) * 1.0d) / 2.0d) / height;
                editorPicInfo.f66185w = 1.0d;
                editorPicInfo.f66184h = ((d16 / 0.3333333432674408d) * 1.0d) / height;
            } else {
                it = it5;
                if (d17 >= 1.7777777910232544d) {
                    editorPicInfo.f66186x = (((d16 - (height * 1.7777777910232544d)) * 1.0d) / 2.0d) / d16;
                    editorPicInfo.f66187y = 0.0d;
                    editorPicInfo.f66185w = ((height * 1.7777777910232544d) * 1.0d) / d16;
                    editorPicInfo.f66184h = 1.0d;
                } else {
                    editorPicInfo.f66186x = 0.0d;
                    editorPicInfo.f66187y = 0.0d;
                    editorPicInfo.f66185w = 1.0d;
                    editorPicInfo.f66184h = 1.0d;
                }
            }
            f0(next, editorPicInfo, null);
            it5 = it;
            i16 = 1;
        }
    }

    private void f1(boolean z16, boolean z17) {
        if (z16) {
            this.f62122e.get().M.setImageDrawable(F0());
            this.f62122e.get().L.setVisibility(0);
            this.f62122e.get().N.setVisibility(this.f62125i.canMixPhotoAndVideo ? 0 : 8);
            this.f62122e.get().J.setVisibility(4);
            this.f62122e.get().K.setVisibility(4);
            this.f62122e.get().E(false);
            this.f62122e.get().w();
            c1();
            this.K = null;
            return;
        }
        this.f62122e.get().L.setVisibility(8);
        if (z17) {
            this.f62122e.get().J.setVisibility(0);
            this.f62122e.get().K.setVisibility(4);
            this.f62122e.get().E(false);
            c1();
            return;
        }
        this.f62122e.get().J.setVisibility(4);
        this.f62122e.get().K.setVisibility(0);
        this.f62122e.get().w();
    }

    private int B0(ArrayList<LocalMediaInfo> arrayList, String str) {
        if (arrayList != null && str != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).path.equals(str)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements VideoPlayerCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoPlayParam f62092d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f62093e;

        a(VideoPlayParam videoPlayParam, String str) {
            this.f62092d = videoPlayParam;
            this.f62093e = str;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
            int C0;
            ms.a.c("AEPhotoListLogicBase", "onPlayError---errorType=" + i16 + ", errorCode=" + i17 + ", exInfo=" + str + "\nvideoPath=" + this.f62093e);
            String str2 = this.f62093e;
            if (str2 == null || !str2.equals(AEPhotoListLogicBase.this.K) || !AEPhotoListLogicBase.this.f62123f.selectedPhotoList.contains(this.f62093e) || (C0 = AEPhotoListLogicBase.this.C0(this.f62093e)) == -1) {
                return;
            }
            AEPhotoListLogicBase.this.l0(C0, AEPhotoListLogicBase.this.f62122e.get().f62034h.p(C0), (AEAbstractPhotoListFragment.g) AEPhotoListLogicBase.this.f62122e.get().Q.findViewHolderForAdapterPosition(C0));
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            ms.a.f("AEPhotoListLogicBase", "onStateChange---state=" + i3);
            if (i3 == 4) {
                if (!this.f62092d.mIsMute) {
                    AEPhotoListLogicBase.this.V0();
                }
                AEPhotoListLogicBase.this.f62122e.get().E(false);
            } else if (i3 == 6) {
                AEPhotoListLogicBase.this.e0();
                AEPhotoListLogicBase.this.f62122e.get().E(true);
            } else {
                if (i3 != 9) {
                    return;
                }
                AEPhotoListLogicBase.this.e0();
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void m(Message message) {
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c
    public void y(CompoundButton compoundButton, boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.c.a
    public void a(int i3, AEAbstractPhotoListFragment.g gVar, AEAbstractPhotoListFragment.f fVar) {
    }
}
