package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.ae.play.AEQuDongConstants;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneReq;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class PhotoListCustomizationDefault extends PhotoListCustomizationBase<h> {
    static IPatchRedirector $redirector_;
    protected g C;
    protected BasePhotoListActivity D;
    com.tencent.mobileqq.activity.photo.album.c E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDefault.this);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDefault.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
            } else if (i3 == 0) {
                oy3.a.a().c("list_photo", false);
            } else {
                oy3.a.a().b("list_photo");
            }
        }
    }

    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDefault.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PhotoListCustomizationDefault.this.w0(view, new Bundle(), 2, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public PhotoListCustomizationDefault(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
            return;
        }
        this.D = (BasePhotoListActivity) abstractPhotoListActivity;
        g gVar = new g();
        this.f184312h = gVar;
        this.C = gVar;
    }

    private void A0(com.tencent.mobileqq.activity.photo.album.photolist.a aVar) {
        NumberCheckBox numberCheckBox;
        if (aVar == null || aVar.itemView == null || (numberCheckBox = aVar.J) == null) {
            return;
        }
        numberCheckBox.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.J.getLayoutParams();
        int dpToPx = ViewUtils.dpToPx(24.0f);
        layoutParams.width = dpToPx;
        layoutParams.height = dpToPx;
        ImageView imageView = aVar.G;
        if (imageView == null) {
            return;
        }
        imageView.setBackgroundColor(Color.parseColor("#66000000"));
        if (aVar.J.isChecked()) {
            aVar.G.setVisibility(0);
        } else {
            aVar.G.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a A(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (com.tencent.mobileqq.activity.photo.album.photolist.a) iPatchRedirector.redirect((short) 50, (Object) this, (Object) aVar, i3);
        }
        com.tencent.mobileqq.activity.photo.album.photolist.a A = super.A(aVar, i3);
        A0(A);
        return A;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void B(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) intent);
            return;
        }
        super.B(intent);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0 && !TextUtils.isEmpty(stringArrayListExtra.get(0))) {
            ThreadManagerV2.postImmediately(new Runnable(stringArrayListExtra.get(0)) { // from class: com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f184187d;

                {
                    this.f184187d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDefault.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 3;
                    String j3 = j.j(this.f184187d);
                    obtain.obj = j3;
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    j.d(localMediaInfo, j3);
                    com.tencent.mobileqq.activity.photo.album.photolist.e.f184289u.put(j3, localMediaInfo);
                    PhotoListCustomizationDefault.this.C.P.sendMessage(obtain);
                }
            }, null, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void B0(Intent intent, boolean z16, ArrayList<String> arrayList) {
        LocalMediaInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            if (!ImageManager.isNetworkUrl(str)) {
                if (((h) this.f184311f).b(this.f184310e, str) == 1 && (a16 = ((h) this.f184311f).a(this.f184310e, str)) != null) {
                    SendVideoInfo sendVideoInfo = new SendVideoInfo();
                    sendVideoInfo.fileSize = a16.fileSize;
                    sendVideoInfo.duration = a16.mDuration;
                    hashMap.put(Integer.valueOf(i3), sendVideoInfo);
                }
                i3++;
            }
        }
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
        }
        if (z16) {
            ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(this.D, intent, arrayList, this.C.f184242w, ((h) this.f184311f).f184248f, false);
        } else {
            ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.D, intent, arrayList, ((h) this.f184311f).f184248f, this.C.f184241v);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void C(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) intent);
            return;
        }
        super.C(intent);
        this.C.P.b();
        long currentTimeMillis = System.currentTimeMillis();
        String stringExtra = intent.getStringExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID);
        String stringExtra2 = intent.getStringExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR);
        VideoCompositeHelper videoCompositeHelper = new VideoCompositeHelper();
        videoCompositeHelper.s(true);
        PublishVideoEntry k3 = VideoCompositeHelper.k(stringExtra);
        String g16 = j.g(k3.mLocalRawVideoDir);
        if (TextUtils.isEmpty(g16)) {
            QZLog.i("QQAlbum", 1, "get target path fail");
        } else {
            videoCompositeHelper.b(k3, g16, false, true, new VideoCompositeHelper.f(currentTimeMillis, g16, k3, stringExtra2) { // from class: com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.3
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f184188a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f184189b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ PublishVideoEntry f184190c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f184191d;

                {
                    this.f184188a = currentTimeMillis;
                    this.f184189b = g16;
                    this.f184190c = k3;
                    this.f184191d = stringExtra2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PhotoListCustomizationDefault.this, Long.valueOf(currentTimeMillis), g16, k3, stringExtra2);
                    }
                }

                @Override // com.tencent.mobileqq.editor.composite.VideoCompositeHelper.f
                public void a(int i3, String str, String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                        return;
                    }
                    if (i3 == 0) {
                        QZLog.d("QQAlbum", 2, "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.f184188a));
                        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.3.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Message obtain = Message.obtain();
                                obtain.what = 1;
                                obtain.obj = AnonymousClass3.this.f184189b;
                                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                                try {
                                    localMediaInfo.path = AnonymousClass3.this.f184189b;
                                    localMediaInfo.mMimeType = "video/mp4";
                                    localMediaInfo.addedDate = System.currentTimeMillis();
                                    localMediaInfo.modifiedDate = System.currentTimeMillis();
                                    PublishVideoEntry publishVideoEntry = AnonymousClass3.this.f184190c;
                                    localMediaInfo.thumbnailPath = publishVideoEntry.thumbPath;
                                    localMediaInfo.mDuration = publishVideoEntry.videoDuration;
                                    localMediaInfo.fileSize = new File(AnonymousClass3.this.f184189b).length();
                                    localMediaInfo.isSystemMeidaStore = false;
                                } catch (Exception e16) {
                                    QZLog.e("QQAlbum", 2, "get new video info exception", e16);
                                }
                                com.tencent.mobileqq.activity.photo.album.photolist.e.f184289u.put(AnonymousClass3.this.f184189b, localMediaInfo);
                                PhotoListCustomizationDefault.this.C.P.sendMessage(obtain);
                                FileUtils.deleteDirectory(AnonymousClass3.this.f184191d);
                            }
                        }, null, true);
                    } else {
                        Message obtain = Message.obtain();
                        obtain.what = 2;
                        obtain.obj = Integer.valueOf(i3);
                        PhotoListCustomizationDefault.this.C.P.sendMessage(obtain);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
            StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
        } else if (!this.f184310e.albumName.equalsIgnoreCase("Camera") && !this.f184310e.albumName.equalsIgnoreCase("camera") && !this.f184310e.albumName.contains("Camera") && !this.f184310e.albumName.contains("camera")) {
            StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
        } else {
            StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        }
        g gVar = this.C;
        if (gVar.A && (!TextUtils.isEmpty(gVar.C) || !TextUtils.isEmpty(this.C.D))) {
            TextView textView = this.D.magicStickBtn;
            if (textView != null) {
                textView.performClick();
                return;
            }
            return;
        }
        Intent intent = this.D.getIntent();
        intent.getStringExtra("PhotoConst.PLUGIN_APK");
        intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184310e.selectedMediaInfoHashMap);
        n0(intent);
        B0(intent, false, this.f184310e.selectedPhotoList);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void D(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) message);
            return;
        }
        super.D(message);
        this.C.P.a();
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        Object obj = message.obj;
        if (obj instanceof String) {
            String str = (String) obj;
            QZLog.d("QQAlbum", 2, "onEncodeSuccess = ", str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (arrayList.size() >= PhotoCommonBaseData.getInstance().maxSelectNum) {
                BasePhotoListActivity basePhotoListActivity = this.D;
                QQToast.makeText(basePhotoListActivity, String.format(basePhotoListActivity.getResources().getString(R.string.cu_), Integer.valueOf(PhotoCommonBaseData.getInstance().maxSelectNum)), 0).show();
            } else {
                PhotoCommonBaseData.getInstance().selectedPhotoList.add(str);
                j.m(this);
            }
            j.k(this.D, str);
        }
    }

    public boolean D0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        BasePhotoListActivity basePhotoListActivity;
        MediaFileFilter mediaFileFilter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SelectPhotoTrace", 2, "QQAlbum initData(),intent extras is:" + intent.getExtras());
        }
        super.E(intent);
        if (this.C != null && this.f184310e != null && this.D != null) {
            if (intent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false) && (mediaFileFilter = this.f184310e.filter) != null) {
                mediaFileFilter.needVideo = false;
                mediaFileFilter.needGif = false;
            }
            this.C.L = intent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
            com.tencent.mobileqq.activity.photo.j.h(this.D, intent, false, this.C.N);
            this.C.f184242w = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM);
            g gVar = this.C;
            if (gVar.f184242w == null) {
                gVar.f184242w = new HashMap<>(1);
            }
            this.f184310e.isShowQzoneAlbum = intent.getBooleanExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
            ((h) this.f184311f).f184251m = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_INFOS);
            this.C.f184244y = intent.getBooleanExtra(PeakConstants.ALBUM_SHOW_ORI_BUTTON, false);
            this.C.f184245z = intent.getBooleanExtra(PeakConstants.IS_SHOW_QUALITY_COUNT_TV, true);
            ((h) this.f184311f).f184249h = intent.getStringExtra(PeakConstants.MY_UIN);
            this.C.f184241v = intent.getBooleanExtra(PeakConstants.IS_WAIT_DEST_RESULT, false);
            this.C.E = intent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
            this.C.F = intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
            this.C.H = intent.getIntExtra("uintype", -1);
            ((h) this.f184311f).f184248f = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
            if (intent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
                this.f184310e.isSingleMode = false;
            }
            this.C.G = intent.getBooleanExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, false);
            this.C.I = intent.getStringExtra("uinname");
            this.C.J = intent.getStringExtra("uin");
            this.C.f184243x = intent.getBooleanExtra(PeakConstants.IS_PREVIEW_VIDEO, true);
            MediaFileFilter mediaFileFilter2 = this.f184310e.filter;
            if (mediaFileFilter2 != null) {
                mediaFileFilter2.videoSizeLimit = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, -1L);
                this.f184310e.filter.videoMaxDuration = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, -1L);
                boolean booleanExtra = intent.getBooleanExtra("NEED_HEIF", false);
                if (booleanExtra) {
                    this.f184310e.filter.needHeif = booleanExtra;
                }
            }
            g gVar2 = this.C;
            if (!gVar2.A) {
                gVar2.A = intent.getBooleanExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, false);
            }
            g gVar3 = this.C;
            if (gVar3.A) {
                gVar3.B = (HashMap) intent.getSerializableExtra("PasterConstants.pasters_data");
                this.C.C = intent.getStringExtra("PasterConstants.paster_id");
                this.C.D = intent.getStringExtra("PasterConstants.paster_cate_id");
            }
            this.C.M = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_MAX_MEDIA_SIZE, -1L);
            if (this.f184310e.isShowQzoneAlbum) {
                String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
                if (account != null) {
                    g gVar4 = this.C;
                    if (gVar4.Q == null) {
                        gVar4.Q = new k((h) this.f184311f);
                    }
                    ((IQzoneReq) QRoute.api(IQzoneReq.class)).sentGetAlbumListNumServlet(this.C.Q, Long.valueOf(account).longValue());
                } else {
                    this.f184310e.isShowQzoneAlbum = false;
                }
            }
            this.C.O = intent.getBooleanExtra(PeakConstants.IS_SINGLE_NEED_EDIT, false);
            this.C.f184304o = 4;
            this.E = this.D.newPhotoViewHelper(this.f184313i);
            g gVar5 = this.C;
            if (gVar5 != null && (basePhotoListActivity = this.D) != null) {
                gVar5.P = basePhotoListActivity.newPhotoListHandler(this);
            }
        }
    }

    public boolean E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        CheckBox checkBox;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.F();
        View view = this.f184313i.D;
        if (view != null) {
            this.D.magicStickBtn = (TextView) view.findViewById(R.id.ekt);
            this.D.qualityCheckBox = (CheckBox) this.f184313i.D.findViewById(R.id.h1y);
            this.D.qualityTv = (TextView) this.f184313i.D.findViewById(R.id.f166661h24);
            this.D.qualityCountTv = (TextView) this.f184313i.D.findViewById(R.id.h1z);
            this.D.imgCountTipsTv = (TextView) this.f184313i.D.findViewById(R.id.dg7);
            this.D.previewTv = (TextView) this.f184313i.D.findViewById(R.id.fyh);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f184313i.f184280m.setFitsSystemWindows(true);
            this.f184313i.f184280m.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.D), 0, 0);
        }
        this.f184313i.H.addOnScrollListener(new b());
        View view2 = this.f184313i.D;
        if (view2 != null) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            if (!photoCommonBaseData.isSingleMode && photoCommonBaseData.showMediaType != 2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        PhotoListSceneBase photoListSceneBase = this.f184313i;
        TextView textView = photoListSceneBase.J;
        if (textView != null) {
            textView.setOnClickListener(photoListSceneBase);
        }
        PhotoListSceneBase photoListSceneBase2 = this.f184313i;
        Button button = photoListSceneBase2.K;
        if (button != null) {
            button.setOnClickListener(photoListSceneBase2);
        }
        TextView textView2 = this.D.magicStickBtn;
        if (textView2 != null) {
            if (this.C.A) {
                textView2.setVisibility(0);
                this.D.magicStickBtn.setOnClickListener(new c());
            } else {
                textView2.setVisibility(8);
            }
        }
        if (this.C.f184244y && (checkBox = this.D.qualityCheckBox) != null) {
            checkBox.setOnCheckedChangeListener(this.f184313i);
        }
        T();
        this.C.P = this.D.newPhotoListHandler(this);
        this.E.a();
        QLog.i("SelectPhotoTrace", 1, "initUI coat\uff1a" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        BasePhotoListActivity basePhotoListActivity = this.D;
        CheckBox checkBox = basePhotoListActivity.qualityCheckBox;
        if (checkBox != null) {
            int i3 = ((h) this.f184311f).f184248f;
            if (i3 != 0) {
                if (i3 == 2) {
                    TextView textView = basePhotoListActivity.qualityCountTv;
                    if (textView != null) {
                        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
                        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.allMediaInfoHashMap;
                        g gVar = this.C;
                        j.l(textView, arrayList, hashMap, gVar.K, basePhotoListActivity, gVar.f184242w, photoCommonBaseData.selectedMediaInfoHashMap);
                    }
                    this.D.qualityCheckBox.setChecked(true);
                    return;
                }
                return;
            }
            checkBox.setChecked(false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (QLog.isDevelopLevel() && arrayList != null && arrayList.size() != 0) {
            QLog.d("QQAlbum", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + arrayList.size());
        }
        this.C.f184301l = i3;
        if (i16 == -1) {
            if (i3 != 16) {
                if (i3 != 10007) {
                    if (i3 != 10010) {
                        if (i3 == 10014) {
                            this.D.setResult(-1, intent);
                            this.D.finish();
                        }
                    } else if (intent == null) {
                        return;
                    } else {
                        this.f184310e.selectedPhotoList = intent.getStringArrayListExtra("img_list");
                    }
                } else {
                    Intent intent2 = new Intent();
                    intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList);
                    intent2.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
                    this.D.setResult(-1, intent2);
                    this.D.finish();
                    return;
                }
            } else {
                X(true, this.D.getIntent());
                return;
            }
        } else if (i3 == 17) {
            QAlbumUtil.sLastAlbumRecordTime = 0L;
            return;
        }
        j.h(this.D, i3, i16, intent, this.C.F, ((h) this.f184311f).f184249h);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            super.I();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, view, Integer.valueOf(i3), checkBox);
            return;
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        if (photoCommonBaseData.isSingleMode) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "current select count:" + arrayList.size());
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        int i16 = m06.selectStatus;
        if (!o0(m06, checkBox)) {
            return;
        }
        if (i16 != 1) {
            z16 = true;
        }
        if (z16) {
            s0(m06);
        } else {
            t0(m06);
        }
        h0(z16, m06);
        this.f184313i.u(i3, z16);
        this.f184313i.t(!z16);
        T();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void K(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            boolean z17 = this.f184310e.isSingleMode;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void L(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view);
        } else {
            super.L(view);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean N(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) list)).booleanValue();
        }
        if (!super.N(list)) {
            return false;
        }
        g gVar = this.C;
        if (gVar.f184290a) {
            gVar.f184290a = false;
            this.f184313i.H.post(new Runnable(q0(list)) { // from class: com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f184194d;

                {
                    this.f184194d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationDefault.this, r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PhotoListCustomizationDefault photoListCustomizationDefault = PhotoListCustomizationDefault.this;
                    if (photoListCustomizationDefault.D != null) {
                        photoListCustomizationDefault.f184313i.I.scrollToPositionWithOffset(this.f184194d, 1);
                    }
                }
            });
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) view);
            return;
        }
        Button button = this.f184313i.K;
        if (button != null) {
            button.setClickable(false);
        }
        if (!this.f184310e.selectedPhotoList.isEmpty()) {
            this.f184313i.s(this.f184310e.selectedPhotoList.get(r0.size() - 1));
        }
        if (this.f184310e.selectedPhotoList.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(AEQuDongConstants.INTENT_KEY_PHOTOLIST, 2, "size == 0");
            }
        } else {
            this.D.getIntent();
            C0();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) view);
            return;
        }
        QAlbumUtil.clearSelectItemInfo();
        if (!this.C.G) {
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
            return;
        }
        Intent intent = this.D.getIntent();
        String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
        if (stringExtra == null) {
            return;
        }
        intent.setClassName(stringExtra2, stringExtra);
        intent.removeExtra("PhotoConst.PHOTO_PATHS");
        intent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
        intent.addFlags(603979776);
        this.D.startActivity(intent);
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
        } else {
            super.R(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void S(List<LocalMediaInfo> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) list, i3);
        } else if (list != null) {
            com.tencent.mobileqq.activity.photo.j.g(list, i3, null, this.C.N);
            super.S(list, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.T();
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        boolean z17 = true;
        if (arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(PeakConstants.TAG, 2, "updateButton selectedPhotoList.size()=" + arrayList.size());
        }
        CheckBox checkBox = this.D.qualityCheckBox;
        if (checkBox != null) {
            if (!z16) {
                checkBox.setChecked(false);
            }
            this.D.qualityCheckBox.setVisibility(8);
            if (this.C.f184244y) {
                this.D.qualityCheckBox.setVisibility(0);
            }
        }
        TextView textView = this.D.qualityTv;
        if (textView != null) {
            textView.setVisibility(8);
            if (this.C.f184244y) {
                this.D.qualityTv.setVisibility(0);
            }
        }
        TextView textView2 = this.D.qualityCountTv;
        if (textView2 != null) {
            if (!z16) {
                textView2.setEnabled(false);
            }
            this.D.qualityCountTv.setVisibility(8);
            if (this.C.f184244y && z16) {
                this.D.qualityCountTv.setEnabled(true);
            }
            if (!this.C.f184245z) {
                this.D.qualityCountTv.setVisibility(8);
            }
        }
        F0();
        TextView textView3 = this.D.magicStickBtn;
        if (textView3 != null) {
            if (this.C.A) {
                if (arrayList.size() == 1) {
                    O o16 = this.f184311f;
                    if (((h) o16).f184251m == null || ((h) o16).f184251m.size() <= 0) {
                        int b16 = ((h) this.f184311f).b(this.f184310e, arrayList.get(0));
                        if ((b16 != 0 || !D0()) && (b16 != 1 || !E0())) {
                            z17 = false;
                        }
                        this.D.magicStickBtn.setEnabled(z17);
                        return;
                    }
                }
                this.D.magicStickBtn.setEnabled(false);
                return;
            }
            textView3.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public void X(boolean z16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), intent);
            return;
        }
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, false);
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (!z16) {
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            if (arrayList != null && arrayList.size() > 0) {
                ReportController.n(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X8004072", "0X8004072", 0, arrayList.size(), 0, "", "", "", "");
            }
        } else {
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.C.f184292c);
        }
        O o16 = this.f184311f;
        if (((h) o16).f184251m != null && ((h) o16).f184251m.size() > 0) {
            intent.putExtra(PeakConstants.PHOTO_INFOS, ((h) this.f184311f).f184251m);
            intent.putExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM, intent.getSerializableExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM));
            intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, 0);
            intent.putExtra(PeakConstants.USE_URL_PATH, true);
            intent.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, intent.getBooleanExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, false));
        } else {
            intent.putExtra(PeakConstants.USE_URL_PATH, false);
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184310e.selectedMediaInfoHashMap);
        intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, 0);
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
        intent.putExtra("PasterConstants.pasters_data", this.C.B);
        com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
        BasePhotoListActivity basePhotoListActivity = this.D;
        intent.setClass(basePhotoListActivity, basePhotoListActivity.getPreviewActivityClass());
        intent.addFlags(603979776);
        R(intent);
        QAlbumUtil.anim(this.D, true, true);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public String Y(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) localMediaInfo);
        }
        int i3 = this.f184310e.maxSelectNum;
        String Y = super.Y(localMediaInfo);
        if (localMediaInfo != null) {
            String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
            if (this.C.f184293d && mimeType != null && "video".equals(mimeType[0])) {
                return this.D.getResources().getString(R.string.cu_, Integer.valueOf(i3));
            }
            return Y;
        }
        return Y;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public Class Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (Class) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.D.getPreviewActivityClass();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, localMediaInfo, Boolean.valueOf(z16))).booleanValue();
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (!this.C.f184293d && mimeType != null && !"image".equals(mimeType[0])) {
            return false;
        }
        int i3 = localMediaInfo.selectStatus;
        if ((i3 == 1 && z16) || (i3 == 2 && !z16)) {
            return false;
        }
        if (i3 == 2 && z16 && photoCommonBaseData.selectedPhotoList.size() >= photoCommonBaseData.maxSelectNum) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C.f184299j >= 700) {
                QQToast.makeText(this.D, Y(localMediaInfo), 1000).show();
                g gVar = this.C;
                gVar.f184299j = currentTimeMillis;
                gVar.f184300k = true;
            }
            return false;
        }
        this.C.f184300k = false;
        if (z16) {
            u0(localMediaInfo);
        } else {
            v0(localMediaInfo);
        }
        this.f184313i.t(!z16);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void c(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view, i3);
        } else if (!Utils.B()) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.h9v), 0).show();
        } else {
            this.D.dispatchTakePictureIntent();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.b
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (View) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.D.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.inflate(R.layout.gzn, (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public void g0(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) list);
            return;
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null && arrayList.size() != 0) {
            int i3 = 0;
            while (i3 < this.f184310e.selectedPhotoList.size()) {
                String str = this.f184310e.selectedPhotoList.get(i3);
                if (TextUtils.isEmpty(str)) {
                    QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
                } else if (!new File(str).exists()) {
                    if (str.startsWith("http")) {
                        O o16 = this.f184311f;
                        if (((h) o16).f184251m != null && ((h) o16).f184251m.containsKey(str)) {
                        }
                    }
                    this.f184310e.selectedPhotoList.remove(i3);
                    i3--;
                    HashMap<String, LocalMediaInfo> hashMap = this.f184310e.selectedMediaInfoHashMap;
                    if (hashMap != null && hashMap.containsKey(str)) {
                        this.f184310e.selectedMediaInfoHashMap.remove(str);
                    }
                }
                i3++;
            }
        }
        super.g0(list);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    protected void i0(com.tencent.mobileqq.activity.photo.album.photolist.a aVar, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) aVar, (Object) localMediaInfo);
        } else if (com.tencent.mobileqq.activity.photo.j.f(localMediaInfo.path, this.C.N)) {
            aVar.I.setImageDrawable(this.D.getDrawable(R.drawable.f160524cg1));
            aVar.I.setVisibility(0);
        } else {
            aVar.I.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Intent) iPatchRedirector.redirect((short) 17, (Object) this, (Object) view, i3);
        }
        Intent k3 = super.k(view, i3);
        k3.putExtra(PeakConstants.MY_UIN, ((h) this.f184311f).f184249h);
        k3.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
        k3.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, this.C.A);
        k3.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, com.tencent.mobileqq.activity.photo.j.a(this.C.N));
        k3.putExtra(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 6);
        k3.putExtra("PasterConstants.paster_id", this.C.C);
        k3.putExtra("PasterConstants.paster_cate_id", this.C.D);
        k3.putExtra("PasterConstants.pasters_data", this.C.B);
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null && arrayList.size() > 0) {
            ReportController.n(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X8005674", "0X8005674", 0, this.f184310e.selectedPhotoList.size(), 0, "", "", "", "");
        }
        return k3;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void l(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, i3);
        } else {
            z0(this.f184313i.Q.m0(i3), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) intent);
        }
    }

    boolean o0(LocalMediaInfo localMediaInfo, CheckBox checkBox) {
        if (localMediaInfo.selectStatus != 1 && this.f184310e.selectedPhotoList.size() >= this.f184310e.maxSelectNum) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C.f184299j >= 1000) {
                QQToast.makeText(this.D, Y(localMediaInfo), 0).show();
                checkBox.setChecked(false);
                this.C.f184299j = currentTimeMillis;
            }
            return false;
        }
        if (this.C.H == 9501 && this.D.getIntent().getBooleanExtra(PeakConstants.IS_SEND_FILESIZE_LIMIT, false) && localMediaInfo.selectStatus != 1) {
            Iterator<String> it = this.f184310e.selectedPhotoList.iterator();
            long j3 = 0;
            while (it.hasNext()) {
                j3 += FileUtils.getFileSizes(it.next());
            }
            if (j3 + FileUtils.getFileSizes(localMediaInfo.path) > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                QQToast.makeText(this.D, "\u9009\u62e9\u56fe\u7247\u603b\u5927\u5c0f\u4e0d\u80fd\u8d85\u8fc750M", 0).show();
                checkBox.setChecked(false);
                return false;
            }
        }
        if (!this.D.getIntent().getBooleanExtra(PeakConstants.IS_SEND_GIF_SIZE_LIMIT, false) || !QAlbumUtil.isGif(localMediaInfo) || FileUtils.getFileSizes(localMediaInfo.path) <= 3145728) {
            return true;
        }
        QQToast.makeText(this.D, "\u56fe\u7247\u6587\u4ef6\u8fc7\u5927", 0).show();
        checkBox.setChecked(false);
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener
    public void onPhotoListDatasetDurationChanged(int i3, LocalMediaInfo localMediaInfo) {
        com.tencent.mobileqq.activity.photo.album.photolist.d dVar;
        ArrayList<LocalMediaInfo> arrayList;
        LocalMediaInfo localMediaInfo2;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3, (Object) localMediaInfo);
            return;
        }
        com.tencent.mobileqq.activity.photo.album.b bVar = this.C.P;
        if (bVar == null || (dVar = this.f184313i.Q) == null || (arrayList = dVar.E) == null || (localMediaInfo2 = arrayList.get(i3)) == null || localMediaInfo == null || (str = localMediaInfo2.path) == null || (str2 = localMediaInfo.path) == null || !str.equals(str2)) {
            return;
        }
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = 0;
        Bundle bundle = new Bundle();
        bundle.putInt("ALBUMLIST_POSITION", i3);
        bundle.putLong("ALBUMLIST_ITEM_DURATION", localMediaInfo.mDuration);
        obtainMessage.setData(bundle);
        bVar.sendMessage(obtainMessage);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view, i3);
            return;
        }
        if (!Utils.B()) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.h9v), 0).show();
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null) {
            return;
        }
        Intent intent = this.D.getIntent();
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(m06.path)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(m06.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
        this.f184313i.s(m06.path);
        if (!this.C.f184243x) {
            intent.putExtra("file_send_path", m06.path);
            intent.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
            intent.putExtra(PeakConstants.VIDEO_SIZE, m06.fileSize);
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, m06.mDuration);
            intent.putExtra(ShortVideoConstants.FILE_WIDTH, m06.mediaWidth);
            intent.putExtra(ShortVideoConstants.FILE_HEIGHT, m06.mediaHeight);
            intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) m06);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(m06.path);
            ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.D, intent, arrayList, 2, false);
            return;
        }
        if (!this.f184310e.isSingleMode) {
            Intent intent2 = this.D.getIntent();
            intent2.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
            intent2.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
            LocalMediaInfo m07 = this.f184313i.Q.m0(i3);
            intent2.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, m07.position);
            intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
            intent2.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
            intent2.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
            intent2.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
            intent2.putExtra(QAlbumConstants.SHOW_ALBUM, true);
            intent2.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, this.C.A);
            intent2.putExtra("PasterConstants.paster_id", this.C.C);
            intent2.putExtra("PasterConstants.paster_cate_id", this.C.D);
            com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
            HashMap<String, LocalMediaInfo> hashMap2 = this.f184310e.selectedMediaInfoHashMap;
            if (!hashMap2.containsKey(m07.path)) {
                hashMap2.put(m07.path, m07);
            }
            intent2.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
            intent2.putExtra("PasterConstants.pasters_data", this.C.B);
            BasePhotoListActivity basePhotoListActivity2 = this.D;
            intent2.setClass(basePhotoListActivity2, basePhotoListActivity2.getPreviewActivityClass());
            intent2.addFlags(603979776);
            ArrayList<String> arrayList2 = this.f184310e.selectedPhotoList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ReportController.n(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X8005674", "0X8005674", 0, this.f184310e.selectedPhotoList.size(), 0, "", "", "", "");
            }
            this.D.startActivity(intent2);
            this.D.finish();
            QAlbumUtil.anim(this.D, true, true);
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.D, IPhotoLogicFactory.SHORT_VIDEO_PREVIEW_ACTIVITY_URI);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.extra().putString("file_send_path", m06.path);
        activityURIRequest.extra().putLong(ShortVideoConstants.FILE_SEND_SIZE, m06.fileSize);
        activityURIRequest.extra().putLong(ShortVideoConstants.FILE_SEND_DURATION, m06.mDuration);
        activityURIRequest.extra().putInt(ShortVideoConstants.FILE_WIDTH, m06.mediaWidth);
        activityURIRequest.extra().putInt(ShortVideoConstants.FILE_HEIGHT, m06.mediaHeight);
        activityURIRequest.extra().putString("uin", this.C.J);
        activityURIRequest.extra().putInt("uintype", this.C.H);
        activityURIRequest.extra().putString(ShortVideoConstants.FILE_SOURCE, "album");
        activityURIRequest.extra().putBoolean(ShortVideoConstants.IS_FROM_SYSTEM_MEDIA, m06.isSystemMeidaStore);
        if (this.C.f184293d) {
            activityURIRequest.extra().putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
            activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        }
        activityURIRequest.setRequestCode(17);
        QRoute.startUri(activityURIRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) intent);
        } else {
            this.D.startActivity(intent);
        }
    }

    int q0(List<LocalMediaInfo> list) {
        int size;
        int i3 = this.C.f184297h;
        if (i3 == -1) {
            i3 = com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t;
        }
        if (i3 == -1) {
            LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
            if (linkedHashMap != null && (size = linkedHashMap.size()) > 0) {
                i3 = linkedHashMap.get(linkedHashMap.keySet().toArray()[size - 1]).intValue();
            }
            if (i3 == -1 && this.C.f184305p) {
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
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
            if (i3 == -1 && photoCommonBaseData.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID) && !arrayList.isEmpty()) {
                int size2 = list.size();
                String str = arrayList.get(arrayList.size() - 1);
                int i17 = 0;
                while (true) {
                    if (i17 >= size2) {
                        break;
                    }
                    if (str.equals(list.get(i17).path)) {
                        i3 = i17;
                        break;
                    }
                    i17++;
                }
            }
        } else {
            com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = -1;
        }
        int num_backgournd_icon = this.f184313i.Q.getNUM_BACKGOURND_ICON();
        if (num_backgournd_icon <= 0 || i3 == -1 || i3 > num_backgournd_icon - 1) {
            return 0;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        if (this.f184310e.isShowQzoneAlbum) {
            MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this.C.Q);
        }
        super.r();
        if (QLog.isColorLevel()) {
            QLog.e(AEQuDongConstants.INTENT_KEY_PHOTOLIST, 2, "doOnDestroy");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public h x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) localMediaInfo);
        } else {
            x0(localMediaInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        super.t();
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        if (this.C.f184301l == 10016) {
            if (!this.D.getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
                this.D.finish();
                return;
            } else {
                this.D.getIntent().removeExtra("FROM_QZONR_NO_FINISH");
                this.C.f184301l = 0;
            }
        }
        TextView textView = this.D.magicStickBtn;
        if (textView != null) {
            textView.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) localMediaInfo);
        } else {
            y0(localMediaInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void u(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
            return;
        }
        super.u(intent);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
        intent.putExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, this.f184310e.isShowQzoneAlbum);
        intent.putExtra(PeakConstants.PHOTO_INFOS, ((h) this.f184311f).f184251m);
        intent.putExtra("peak.myUin", ((h) this.f184311f).f184249h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) localMediaInfo);
        } else {
            x0(localMediaInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) localMediaInfo);
        } else {
            y0(localMediaInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public AbstractAlbumListFragment w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (AbstractAlbumListFragment) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return new AlbumListFragment();
    }

    public void w0(View view, Bundle bundle, int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, view, bundle, Integer.valueOf(i3), intent);
            return;
        }
        if (this.f184310e.selectedPhotoList.size() > 0) {
            p0(((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(this.D, intent, this.f184310e.selectedPhotoList.get(0), i3, bundle));
            TextView textView = this.D.magicStickBtn;
            if (textView != null) {
                textView.setClickable(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) localMediaInfo);
            return;
        }
        localMediaInfo.selectStatus = 1;
        String str = localMediaInfo.path;
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (this.C.f184293d && mimeType != null && "video".equals(mimeType[0])) {
            g gVar = this.C;
            int i3 = gVar.f184294e + 1;
            gVar.f184294e = i3;
            if (i3 == 1) {
                gVar.f184296g = localMediaInfo;
            }
        }
        if (!TextUtils.isEmpty(localMediaInfo.mMimeType) && "image/gif".equals(localMediaInfo.mMimeType)) {
            this.C.f184295f++;
        }
        this.f184310e.selectedPhotoList.add(str);
        this.f184310e.selectedIndex.add(localMediaInfo.position);
        this.f184310e.selectedMediaInfoHashMap.put(str, localMediaInfo);
        LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            QAlbumUtil.sSelectItemPosMap.put(this.f184310e.albumId, linkedHashMap);
        }
        linkedHashMap.put(str, Integer.valueOf(this.f184313i.I.findFirstVisibleItemPosition()));
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(str)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(str, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a y(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.mobileqq.activity.photo.album.photolist.a) iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar, i3);
        }
        com.tencent.mobileqq.activity.photo.album.photolist.a y16 = super.y(aVar, i3);
        A0(y16);
        return y16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) localMediaInfo);
            return;
        }
        localMediaInfo.selectStatus = 2;
        String str = localMediaInfo.path;
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (this.C.f184293d && mimeType != null && "video".equals(mimeType[0])) {
            g gVar = this.C;
            int i3 = gVar.f184294e - 1;
            gVar.f184294e = i3;
            if (i3 == 1) {
                gVar.f184296g = localMediaInfo;
            }
        }
        if (!TextUtils.isEmpty(localMediaInfo.mMimeType) && "image/gif".equals(localMediaInfo.mMimeType)) {
            this.C.f184295f--;
        }
        this.f184310e.selectedPhotoList.remove(str);
        this.f184310e.selectedIndex.remove(localMediaInfo.position);
        this.f184310e.selectedMediaInfoHashMap.remove(str);
        LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
        if (linkedHashMap != null) {
            linkedHashMap.remove(str);
        }
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (hashMap.containsKey(str)) {
            hashMap.remove(str);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a z(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (com.tencent.mobileqq.activity.photo.album.photolist.a) iPatchRedirector.redirect((short) 49, (Object) this, (Object) aVar, i3);
        }
        com.tencent.mobileqq.activity.photo.album.photolist.a z16 = super.z(aVar, i3);
        A0(z16);
        return z16;
    }

    public void z0(LocalMediaInfo localMediaInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) localMediaInfo, i3);
            return;
        }
        String str = localMediaInfo.path;
        Intent intent = this.D.getIntent();
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
        if (intent.getBooleanExtra(PeakConstants.MULTI_PREVIEW_IN_SINGLE_MODE, false)) {
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.mediaPathsList);
            intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, localMediaInfo.position);
        }
        g gVar = this.C;
        if (gVar.E) {
            HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
            if (!hashMap.containsKey(str)) {
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                hashMap.put(str, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
            }
            this.f184313i.s(str);
            ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).sendPhoto(this.D, intent, this.f184310e.selectedPhotoList, 0, this.C.f184241v);
            return;
        }
        if (!gVar.O) {
            intent.putExtra(PeakConstants.ALLOW_LOCK, false);
            BasePhotoListActivity basePhotoListActivity = this.D;
            intent.setClass(basePhotoListActivity, basePhotoListActivity.getPreviewActivityClass());
            intent.putExtra("PasterConstants.pasters_data", this.C.B);
        } else {
            intent = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toCropActivity(this.D, intent);
            j.i(intent, this.f184310e.albumId, str, this.C.f184305p);
            intent.putExtra("PHOTOLIST_START_POSITION", this.f184313i.I.findFirstVisibleItemPosition());
        }
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
        intent.addFlags(603979776);
        this.D.startActivity(intent);
        this.D.finish();
        QAlbumUtil.anim(this.D, true, true);
    }
}
