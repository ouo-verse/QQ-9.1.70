package com.tencent.aelight.camera.aioeditor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.peak.PeakConstants;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes32.dex */
public class PhotoListCustomizationAECamera extends PhotoListCustomizationDefault {
    public static final String F = "com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera";

    /* loaded from: classes32.dex */
    class a implements MediaScanner.OnMediaInfoScannerListener {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
        public void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16) {
            if (QQStoryFlowCallback.e(((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).D, localMediaInfo)) {
                PhotoListCustomizationAECamera.this.W0(localMediaInfo);
                VSReporter.m("mystatus_localupload", "pic_select", 0, 0, new String[0]);
            } else {
                ((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).C.P.a();
            }
        }
    }

    /* loaded from: classes32.dex */
    class b implements MediaScanner.OnMediaInfoScannerListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f66291d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f66292e;

        /* loaded from: classes32.dex */
        class a implements FrameVideoHelper.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ LocalMediaInfo f66294a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FrameVideoHelper f66295b;

            a(LocalMediaInfo localMediaInfo, FrameVideoHelper frameVideoHelper) {
                this.f66294a = localMediaInfo;
                this.f66295b = frameVideoHelper;
            }

            @Override // com.tencent.biz.videostory.video.FrameVideoHelper.a
            public void a(boolean z16, ArrayList<FrameVideoHelper.FrameBuffer> arrayList, long j3) {
                ((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).C.P.a();
                Bundle bundle = new Bundle();
                bundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", j3);
                bundle.putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
                bundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", arrayList);
                ((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).D.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
                PhotoListCustomizationAECamera.this.V0(this.f66294a, bundle);
                this.f66295b.z();
            }
        }

        b(Intent intent, ArrayList arrayList) {
            this.f66291d = intent;
            this.f66292e = arrayList;
        }

        @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
        public void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16) {
            if (QQStoryFlowCallback.e(((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).D, localMediaInfo)) {
                if (((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).C != null) {
                    long j3 = localMediaInfo.mDuration;
                    PhotoListCustomizationAECamera photoListCustomizationAECamera = PhotoListCustomizationAECamera.this;
                    if (j3 > photoListCustomizationAECamera.f184310e.filter.videoMaxDuration) {
                        ((PhotoListCustomizationDefault) photoListCustomizationAECamera).C.P.a();
                        this.f66291d.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
                        PhotoUtils.sendPhoto(((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).D, this.f66291d, this.f66292e, 2, true);
                        return;
                    }
                }
                FrameVideoHelper frameVideoHelper = new FrameVideoHelper(localMediaInfo.path, localMediaInfo.mediaWidth, localMediaInfo.mediaHeight, localMediaInfo.mDuration);
                frameVideoHelper.y(new a(localMediaInfo, frameVideoHelper));
                VSReporter.m("mystatus_localupload", "video_select", 0, 0, new String[0]);
                return;
            }
            ((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).C.P.a();
        }
    }

    PhotoListCustomizationAECamera(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
    }

    private void X0() {
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity == null || basePhotoListActivity.getIntent() == null) {
            return;
        }
        this.D.getIntent().putExtra(AECameraConstants.KEY_FROM_PIC_CHOOSE, true);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void l(View view, int i3) {
        if (this.D == null) {
            ms.a.c("PhotoListCustomizationAECamera", "mActivity is null");
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        this.C.P.b();
        MediaScanner.getInstance(BaseApplication.getContext()).queryMediaInfoAsync(new a(), m06);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        if (this.D == null) {
            ms.a.c("PhotoListCustomizationAECamera", "mActivity is null.");
            return;
        }
        if (!Utils.B()) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.h9v), 0).show();
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null) {
            ms.a.c("PhotoListCustomizationAECamera", "photoInfo is null.");
            return;
        }
        Intent intent = this.D.getIntent();
        intent.putExtra("file_send_path", m06.path);
        intent.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
        intent.putExtra(PeakConstants.VIDEO_SIZE, m06.fileSize);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, m06.mDuration);
        intent.putExtra(ShortVideoConstants.FILE_WIDTH, m06.mediaWidth);
        intent.putExtra(ShortVideoConstants.FILE_HEIGHT, m06.mediaHeight);
        intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) m06);
        intent.putExtra(AECameraConstants.KEY_FROM_PIC_CHOOSE, true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m06.path);
        this.C.P.b();
        X0();
        MediaScanner.getInstance(BaseApplication.getContext()).queryMediaInfoAsync(new b(intent, arrayList), m06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(final LocalMediaInfo localMediaInfo) {
        String str;
        BasePhotoListActivity basePhotoListActivity;
        int i3;
        int i16;
        if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.path) && (basePhotoListActivity = this.D) != null && basePhotoListActivity.getIntent() != null) {
            X0();
            if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare(this.D.getIntent())) {
                this.C.P.a();
                Bundle bundle = new Bundle();
                bundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", localMediaInfo.path);
                bundle.putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
                this.D.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
                V0(localMediaInfo, bundle);
                return;
            }
            final String c16 = VideoStoryPicToVideo.d().c(localMediaInfo.path, "2");
            if (TextUtils.isEmpty(c16)) {
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            j.d(localMediaInfo.path, options);
            int alainSize = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).alainSize(ScreenUtil.SCREEN_WIDTH);
            int alainSize2 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).alainSize((int) (alainSize / (options.outWidth / options.outHeight)));
            if (alainSize2 > com.tencent.mobileqq.editor.composite.step.b.f204002c) {
                i3 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).alainSize((int) ((alainSize * com.tencent.mobileqq.editor.composite.step.b.f204002c) / alainSize2));
                i16 = com.tencent.mobileqq.editor.composite.step.b.f204002c;
            } else {
                i3 = alainSize;
                i16 = alainSize2;
            }
            VideoStoryPicToVideo.d().e(localMediaInfo.path, c16, "2", i3, i16, false, 0, new VideoStoryPicToVideo.a() { // from class: com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.3
                @Override // com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.a
                public void a(VideoStoryPicToVideo.b bVar) {
                    final long j3;
                    Log.d("Q.videostory.capture", "success");
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(c16);
                        final LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                        localMediaInfo2.path = c16;
                        localMediaInfo2.mDuration = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                        localMediaInfo2.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        localMediaInfo2.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        localMediaInfo2.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                        localMediaInfo2.mMediaType = 1;
                        localMediaInfo2.mMimeType = "video/mp4";
                        LocalMediaInfo localMediaInfo3 = localMediaInfo;
                        localMediaInfo2.latitude = localMediaInfo3.latitude;
                        localMediaInfo2.longitude = localMediaInfo3.longitude;
                        localMediaInfo2.addedDate = localMediaInfo3.addedDate;
                        mediaMetadataRetriever.release();
                        Bitmap c17 = j.c(localMediaInfo.path);
                        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        if (c17 == null || c17.isRecycled()) {
                            j3 = 0;
                        } else {
                            Bitmap b16 = com.tencent.biz.videostory.support.a.b(c17);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            b16.compress(Bitmap.CompressFormat.JPEG, (int) ((Long) VSConfigManager.c().e(IVSConfigManager.SMART_CUT_PIC_QUALITY_AND, 80L)).longValue(), byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            j3 = byteArray.length;
                            copyOnWriteArrayList.add(new FrameVideoHelper.FrameBuffer(byteArray));
                            byteArrayOutputStream.close();
                            c17.recycle();
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).D.isFinishing()) {
                                    return;
                                }
                                ((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).C.P.a();
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", localMediaInfo.path);
                                bundle2.putBoolean("KEY_FROM_PIC_TO_VIDEO", true);
                                bundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable) copyOnWriteArrayList);
                                bundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", j3);
                                PhotoListCustomizationAECamera.this.V0(localMediaInfo2, bundle2);
                            }
                        });
                    } catch (Exception unused) {
                        mediaMetadataRetriever.release();
                    }
                }

                @Override // com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.a
                public void b(VideoStoryPicToVideo.b bVar) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).D.isFinishing()) {
                                return;
                            }
                            ((PhotoListCustomizationDefault) PhotoListCustomizationAECamera.this).C.P.a();
                            Log.d("Q.videostory.capture", "failed");
                        }
                    });
                }
            });
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("data error: ");
        if (localMediaInfo == null) {
            str = "";
        } else {
            str = localMediaInfo.path;
        }
        sb5.append(str);
        ms.a.c("PhotoListCustomizationAECamera", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(LocalMediaInfo localMediaInfo, Bundle bundle) {
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity == null || basePhotoListActivity.getIntent() == null || localMediaInfo == null) {
            return;
        }
        QQStoryFlowCallback.f(this.D, localMediaInfo.path, localMediaInfo, 0, (int) localMediaInfo.mDuration, this.D.getIntent().getIntExtra("entrance_type", 120), 10023, 0, null, null, false, 11, 14, bundle);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        if ((i3 == 10023 || i3 == 2) && i16 == -1) {
            this.D.setResult(i16, intent);
            this.D.finish();
            return;
        }
        if (i3 == 10023) {
            boolean z16 = false;
            if (intent != null && intent.getBooleanExtra(PeakConstants.KEY_EDIT_TO_PHOTO_LIST, false)) {
                z16 = true;
            }
            if (z16) {
                this.D.finish();
            }
        }
        super.G(i3, i16, intent);
    }
}
