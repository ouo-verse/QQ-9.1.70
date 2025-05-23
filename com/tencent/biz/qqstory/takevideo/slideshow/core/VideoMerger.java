package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.biz.qqstory.takevideo.slideshow.f;
import com.tencent.biz.qqstory.takevideo.slideshow.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VideoMerger extends com.tencent.biz.qqstory.takevideo.slideshow.core.b {

    /* renamed from: e, reason: collision with root package name */
    private MediaFormat f94356e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f94357f = false;

    /* renamed from: g, reason: collision with root package name */
    long f94358g;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a extends SlideShowProcessor.e {

        /* renamed from: d, reason: collision with root package name */
        public List<SlideItemInfo> f94365d;

        /* renamed from: e, reason: collision with root package name */
        public b f94366e;

        /* renamed from: f, reason: collision with root package name */
        public Activity f94367f;

        /* renamed from: g, reason: collision with root package name */
        public Handler f94368g;

        /* renamed from: h, reason: collision with root package name */
        public int f94369h;

        /* renamed from: i, reason: collision with root package name */
        public int f94370i;

        /* renamed from: j, reason: collision with root package name */
        public String f94371j;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b(boolean z16);
    }

    public void c(final a aVar) {
        boolean z16;
        String str;
        String str2;
        boolean z17;
        boolean z18;
        Bundle bundle;
        int i3;
        MusicItemInfo musicItemById;
        if (QLog.isColorLevel()) {
            QLog.i("VideoMerger", 2, "start combine");
        }
        if (aVar.f94365d == null) {
            return;
        }
        ld0.a aVar2 = new ld0.a();
        ArrayList arrayList = new ArrayList(aVar.f94365d.size());
        ArrayList<SlideItemInfo> arrayList2 = new ArrayList(aVar.f94365d.size());
        TransitionHandler transitionHandler = (TransitionHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.H);
        ArrayList arrayList3 = new ArrayList();
        boolean z19 = false;
        for (SlideItemInfo slideItemInfo : aVar.f94365d) {
            LocalMediaInfo D2 = transitionHandler.D2(slideItemInfo.f94291i);
            if (D2 != null) {
                arrayList.add(D2.path);
                arrayList3.add(D2.mAudioPath);
                slideItemInfo.F = D2.path;
                slideItemInfo.G = D2.mAudioPath;
                slideItemInfo.H = D2.mHasAudioTrack;
                slideItemInfo.I = D2.mSampleRate;
                arrayList2.add(slideItemInfo);
                if (slideItemInfo.f94290h == 1) {
                    if (slideItemInfo.H) {
                        z19 = true;
                    }
                    QLog.i("VideoMerger", 1, "mergeRunnable hasAudioTrack=" + slideItemInfo.H + " mSampleRate:" + slideItemInfo.I);
                }
            }
        }
        if (a(aVar)) {
            b(9, "", null, null, null, aVar);
            return;
        }
        if (this.f94356e == null) {
            if (transitionHandler.E2() != null) {
                this.f94356e = transitionHandler.E2();
                if (QLog.isColorLevel()) {
                    QLog.d("VideoMerger", 2, "transHandler.getMediaFormat");
                }
            } else {
                if (arrayList.size() > 0) {
                    this.f94356e = com.tencent.biz.qqstory.takevideo.slideshow.core.a.o(arrayList.get(0));
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatFromVideo, videoPath : " + arrayList.get(0));
                    }
                }
                if (this.f94356e == null) {
                    this.f94356e = com.tencent.biz.qqstory.takevideo.slideshow.core.a.n();
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatDefault");
                    }
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "mVideoFormat not null");
        }
        b bVar = aVar.f94366e;
        if (bVar != null) {
            bVar.b(z19);
        }
        String d16 = h.d();
        String str3 = d16 + ".dat";
        if (z19) {
            z16 = ld0.b.a(arrayList2);
            QLog.i("VideoMerger", 1, "clip audio success=" + z16);
            if (z16) {
                arrayList3.clear();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((SlideItemInfo) it.next()).G);
                }
                z16 = aVar2.c(arrayList3, str3);
            }
        } else {
            z16 = true;
        }
        QLog.i("VideoMerger", 1, "merge audio success " + z16);
        if (z16) {
            z16 = ld0.b.c(arrayList2);
            QLog.i("VideoMerger", 1, "clip video success=" + z16);
            arrayList.clear();
            for (SlideItemInfo slideItemInfo2 : arrayList2) {
                if (slideItemInfo2.f94290h == 0) {
                    arrayList.add(slideItemInfo2.F);
                }
                arrayList.add(slideItemInfo2.F);
            }
        }
        Iterator<String> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            QLog.i("VideoMerger", 1, "merge print video begin:  path: " + it5.next());
        }
        if (!z16) {
            str = "merge video result ";
            str2 = str3;
            z17 = false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            str = "merge video result ";
            str2 = str3;
            boolean d17 = aVar2.d(arrayList, d16, 720, 1280, this.f94356e);
            QLog.i("VideoMerger", 1, str + d17 + " cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            z17 = d17;
        }
        QLog.i("VideoMerger", 1, str + z17);
        final LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = d16;
        localMediaInfo.mMimeType = "video";
        if (QQAudioHelper.i()) {
            localMediaInfo.mTransferPosList = aVar2.a(arrayList, d16);
        } else {
            localMediaInfo.mTransferPosList = aVar2.b(arrayList);
        }
        try {
            MediaScanner.getInstance(BaseApplication.getContext()).buildAndUpdateVideo(localMediaInfo);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("VideoMerger", 1, "pic2video err", th5);
        }
        if (z17) {
            id0.a.i("actAlbumTime", (System.currentTimeMillis() - this.f94358g) + "", aVar.f94365d.size() + "");
            final CameraCaptureView.VideoCaptureResult videoCaptureResult = new CameraCaptureView.VideoCaptureResult();
            videoCaptureResult.videoFrameCount = arrayList.size();
            if (z19) {
                videoCaptureResult.audioDataFilePath = str2;
            } else {
                videoCaptureResult.audioDataFilePath = Image2Video.c();
            }
            videoCaptureResult.videoMp4FilePath = d16;
            Intent intent = aVar.f94367f.getIntent();
            if (intent != null) {
                bundle = intent.getBundleExtra("state");
            } else {
                bundle = null;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            final Bundle bundle2 = bundle;
            Bundle extras = aVar.f94367f.getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            final Bundle bundle3 = extras;
            Intent intent2 = aVar.f94367f.getIntent();
            int intExtra = intent2.getIntExtra("entrance_type", 99);
            boolean booleanExtra = intent2.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
            boolean z26 = z17;
            ((ILaunchVideoEditorForAlbum) QRoute.api(ILaunchVideoEditorForAlbum.class)).setVideoParams(bundle3.getInt("edit_video_type", 10002), intExtra, bundle3.getInt("qq_sub_business_id", 2), SlideShowPhotoListManager.n().l());
            bundle3.putBoolean(PeakConstants.FROM_QQSTORY_SLIDESHOW, true);
            bundle3.putString(PeakConstants.FROM_QQSTORY_SLIDESHOW_FILE_DATA, d16);
            bundle3.putInt("extra_transiton_src_from", 1);
            bundle3.putInt("extra_slide_entrance", aVar.f94369h);
            bundle3.putInt("extra_slide_sticker_id", aVar.f94370i);
            bundle3.putString("extra_slide_sticker_str", aVar.f94371j);
            if (aVar.f94365d.size() > 0) {
                bundle3.putString("extra_transiton_default", aVar.f94365d.get(0).M);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("doMerge mTransId=");
                    i3 = 0;
                    sb5.append(aVar.f94365d.get(0).M);
                    QLog.d("VideoMerger", 2, sb5.toString());
                } else {
                    i3 = 0;
                }
                aVar.f94365d.get(i3).getClass();
                List<f.a> b16 = f.a(aVar.f94367f).b(aVar.f94365d.get(i3).M);
                if (b16 != null && b16.size() > 0 && (musicItemById = ((IAELaunchMusicConfigManager) QRoute.api(IAELaunchMusicConfigManager.class)).getMusicItemById(b16.get(i3).f94400a, b16.get(i3).f94401b)) != null) {
                    Bundle bundle4 = new Bundle();
                    Bundle bundle5 = new Bundle();
                    bundle5.putParcelable(AEEditorConstants.SELECT_MUSIC, musicItemById);
                    bundle5.putString(AEEditorConstants.SELECT_MUSIC_LOCAL_PATH, musicItemById.getLocalPath());
                    bundle5.putInt(AEEditorConstants.CAPTURE_MODE, 2);
                    bundle4.putBundle(((IAEClassManager) QRoute.api(IAEClassManager.class)).getMusicProviderViewClass().getSimpleName(), bundle5);
                    bundle2.putBundle(ParseCommon.CONTAINER, bundle4);
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoMerger", 2, "doMerge musicItemInfo=" + musicItemById.mTagName + " " + musicItemById.mItemId);
                    }
                }
            }
            bundle3.putBoolean("PhotoConst.IS_FROM_EDIT", booleanExtra);
            if (SlideShowPhotoListManager.n().l() == 13) {
                ((IQimMusicPlayer) QRoute.api(IQimMusicPlayer.class)).clearMusic();
            }
            z18 = z26;
            aVar.f94368g.post(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.1
                @Override // java.lang.Runnable
                public void run() {
                    ((ILaunchVideoEditorForAlbum) QRoute.api(ILaunchVideoEditorForAlbum.class)).jumpToEditVideoActivity(aVar.f94367f, videoCaptureResult, localMediaInfo, bundle2, 7, bundle3);
                    if (SlideShowPhotoListManager.n().l() == 14 && (aVar.f94367f instanceof NewPhotoListActivity)) {
                        QLog.d("VideoMerger", 2, "shuoshuo merge complete, jump to editVideoActivity and finish PhotoListActivity");
                        aVar.f94367f.finish();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoMerger", 2, "merge complete, jump to editVideoActivity , context : " + aVar.f94367f.getClass().getSimpleName());
                    }
                }
            });
            Iterator<SlideItemInfo> it6 = aVar.f94365d.iterator();
            int i16 = 0;
            while (it6.hasNext()) {
                if (it6.next().f94290h == 1) {
                    i16++;
                }
            }
            int size = aVar.f94365d.size() - i16;
            id0.a.n("video_edit_slides", "suc_compose", !this.f94357f ? 1 : 0, 0, "", aVar.f94365d.size() + "", size + "", i16 + "");
            id0.a.i("actAlbumResult", "0");
        } else {
            z18 = z17;
            aVar.f94368g.post(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoMerger", 2, "merge video failed");
                    }
                    id0.a.i("actAlbumResult", ThemeBackground.DIY_UPLOAD_BG_ID);
                    QQToast.makeText(aVar.f94367f, HardCodeUtil.qqStr(R.string.v5_), 0).show();
                }
            });
        }
        b bVar2 = aVar.f94366e;
        if (bVar2 != null) {
            bVar2.a();
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoMerger", 2, "combine video result =" + z18);
        }
    }
}
