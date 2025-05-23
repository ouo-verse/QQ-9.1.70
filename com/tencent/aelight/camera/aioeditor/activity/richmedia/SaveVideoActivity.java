package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SaveVideoActivity extends FlowActivity {
    private static FFmpeg V;
    private a S;
    private boolean T;
    private int U;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<PeakActivity> f66359a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<AppInterface> f66360b;

        /* renamed from: d, reason: collision with root package name */
        private String f66362d;

        /* renamed from: e, reason: collision with root package name */
        double f66363e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f66364f;

        /* renamed from: h, reason: collision with root package name */
        private String f66366h;

        /* renamed from: c, reason: collision with root package name */
        private AtomicBoolean f66361c = new AtomicBoolean(false);

        /* renamed from: g, reason: collision with root package name */
        private int f66365g = -1;

        a(PeakActivity peakActivity, AppInterface appInterface) {
            this.f66359a = new WeakReference<>(peakActivity);
            this.f66360b = new WeakReference<>(appInterface);
        }

        private boolean k() {
            if (!this.f66361c.get()) {
                return false;
            }
            if (this.f66359a.get() == null || this.f66360b.get() == null) {
                return true;
            }
            m(0, SaveVideoActivity.D0(this.f66360b.get(), this.f66362d));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(int i3, PublishVideoEntry publishVideoEntry) {
            if (this.f66360b.get() == null || this.f66359a.get() == null || this.f66359a.get().isFinishing()) {
                return;
            }
            PeakActivity peakActivity = this.f66359a.get();
            SaveVideoActivity.G0(this.f66360b.get(), publishVideoEntry);
            peakActivity.setResult(p(i3), peakActivity.getIntent());
            peakActivity.finish();
            if (p(i3) == -1) {
                q(this.f66365g);
            }
        }

        private String n() {
            StringBuilder sb5 = new StringBuilder(AppConstants.SDCARD_VIDEO);
            File file = new File(sb5.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            int i3 = 0;
            do {
                sb5.append(VidUtil.generateVid());
                sb5.append(".mp4");
                if (!new File(sb5.toString()).exists()) {
                    QLog.d("SaveVideoActivity", 1, "generateVideoFinalPath:" + ((Object) sb5));
                    return sb5.toString();
                }
                sb5 = new StringBuilder(AppConstants.SDCARD_VIDEO);
                i3++;
            } while (i3 <= 10);
            sb5.append(VidUtil.generateVid());
            sb5.append(".mp4");
            QLog.d("SaveVideoActivity", 1, "retryTime OverTimes, generateVideoFinalPath:" + ((Object) sb5));
            return sb5.toString();
        }

        private String o(Context context) {
            if (context == null) {
                return "";
            }
            return context.getSharedPreferences(MiniConst.LaunchCameraPluginConst.MINI_LAUNCH_TAG, 0).getString(MiniConst.LaunchCameraPluginConst.MINI_LAUNCH_AE_APP_ID, "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int p(int i3) {
            if (this.f66361c.get()) {
                return 0;
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(int i3) {
            if (this.f66359a.get() == null || TextUtils.isEmpty(this.f66366h)) {
                return;
            }
            new File(this.f66366h).exists();
        }

        private void r() {
            String parent;
            if (this.f66359a.get() == null || this.f66360b.get() == null || k()) {
                return;
            }
            PeakActivity peakActivity = this.f66359a.get();
            AppInterface appInterface = this.f66360b.get();
            Intent intent = peakActivity.getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("fakeId");
            this.f66362d = stringExtra;
            PublishVideoEntry D0 = SaveVideoActivity.D0(appInterface, stringExtra);
            if (D0 == null) {
                peakActivity.setResult(1, peakActivity.getIntent());
                peakActivity.finish();
                return;
            }
            if (k()) {
                return;
            }
            String str = D0.mLocalRawVideoDir;
            File file = new File(D0.mLocalRawVideoDir);
            if (file.isFile()) {
                str = file.getParent();
            }
            String b16 = ShortVideoUtils.b(new File(str));
            if (b16 != null && (parent = new File(b16).getParent()) != null) {
                com.tencent.biz.qqstory.utils.d.c(parent);
            }
            new VideoCompositeHelper().b(D0, b16, false, true, new C0574a(b16, null, D0));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            r();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0574a implements VideoCompositeHelper.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f66367a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f66368b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ PublishVideoEntry f66369c;

            C0574a(String str, String str2, PublishVideoEntry publishVideoEntry) {
                this.f66367a = str;
                this.f66368b = str2;
                this.f66369c = publishVideoEntry;
            }

            @Override // com.tencent.mobileqq.editor.composite.VideoCompositeHelper.f
            public void a(int i3, String str, String str2) {
                if (i3 != 0) {
                    a.this.m(1, this.f66369c);
                } else {
                    a aVar = a.this;
                    aVar.s((PeakActivity) aVar.f66359a.get(), this.f66367a, this.f66368b, this.f66369c);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class b implements FFmpegExecuteResponseCallback {

            /* renamed from: a, reason: collision with root package name */
            PublishVideoEntry f66371a;

            /* renamed from: b, reason: collision with root package name */
            String f66372b;

            /* renamed from: c, reason: collision with root package name */
            String f66373c;

            /* renamed from: d, reason: collision with root package name */
            long f66374d = System.currentTimeMillis();

            b(PublishVideoEntry publishVideoEntry, String str, String str2) {
                this.f66371a = publishVideoEntry;
                this.f66372b = str;
                this.f66373c = str2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(File file, CountDownLatch countDownLatch, boolean z16, String str) {
                QLog.d("SaveVideoActivity", 1, "VideoSaveAlumCallBack|onSavePhotoResult= " + z16 + " savePath=" + str);
                if (z16) {
                    this.f66373c = str;
                    FileUtils.deleteFile(file);
                }
                FileUtils.deleteFile(new File(this.f66372b).getParent());
                countDownLatch.countDown();
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str) {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveVideoActivity", 2, "generate files|third step fail:" + str + ",videoFinalPath= " + this.f66373c);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onStart() {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack\uff1aonStart videoFinalPath= " + this.f66373c);
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str) {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack|onSuccess videoFinalPath= " + this.f66373c);
                }
                if (a.this.f66359a.get() != null) {
                    Activity activity = (Activity) a.this.f66359a.get();
                    final File file = new File(this.f66373c);
                    String absolutePath = new File(AppConstants.SDCARD_IMG_CAMERA, file.getName()).getAbsolutePath();
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    ss.h.f434426a.j(activity, new File(this.f66373c), absolutePath, new ss.e() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.l
                        @Override // ss.e
                        public final void onResult(boolean z16, String str2) {
                            SaveVideoActivity.a.b.this.b(file, countDownLatch, z16, str2);
                        }
                    });
                    try {
                        if (!countDownLatch.await(3L, TimeUnit.SECONDS)) {
                            QLog.e("SaveVideoActivity", 1, "VideoSaveAlumCallBack|onSavePhotoResult operation timed out.");
                        } else {
                            QLog.d("SaveVideoActivity", 1, "VideoSaveAlumCallBack|onSavePhotoResult DONE videoFinalPath=" + this.f66373c);
                        }
                    } catch (InterruptedException e16) {
                        QLog.e("SaveVideoActivity", 1, "VideoSaveAlumCallBack|error=" + e16);
                    }
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFinish(boolean z16) {
                double currentTimeMillis = (System.currentTimeMillis() - this.f66374d) / 1000.0d;
                if (QLog.isColorLevel()) {
                    QLog.d("SaveVideoActivity", 2, "generate files|third step cost:" + currentTimeMillis + ",videoFinalPath= " + this.f66373c);
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("generate_video_cost", a.this.f66363e + "");
                hashMap.put("watermark_cost", currentTimeMillis + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qq_ptv_save_time", true, 0L, 0L, hashMap, null);
                FileUtils.deleteFile(this.f66372b);
                if (a.this.f66359a.get() != null) {
                    Activity activity = (Activity) a.this.f66359a.get();
                    if (a.this.f66360b.get() != null) {
                        SaveVideoActivity.G0((AppInterface) a.this.f66360b.get(), this.f66371a);
                    }
                    a aVar = a.this;
                    int p16 = z16 ? aVar.p(-1) : aVar.p(1);
                    if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(activity.getIntent())) {
                        Intent intent = new Intent();
                        if (z16) {
                            intent.setAction(MiniConst.LaunchCameraPluginConst.BROADCAST_ACTION_CAMERA_BACK_RESULT);
                            intent.putExtra("file_path", this.f66373c);
                            intent.putExtra(MiniConst.LaunchCameraPluginConst.THUMB_PATH, this.f66371a.miniThumbPath);
                            intent.putExtra("video_duration", this.f66371a.videoDuration);
                            intent.putExtra("is_video", true);
                        }
                        activity.sendBroadcast(intent);
                        activity.setResult(p16, activity.getIntent());
                        activity.finish();
                        return;
                    }
                    Intent intent2 = activity.getIntent();
                    if (z16) {
                        intent2.putExtra("key_video_save_path", this.f66373c);
                    }
                    activity.setResult(p16, activity.getIntent());
                    activity.finish();
                    if (p16 == -1) {
                        a aVar2 = a.this;
                        aVar2.q(aVar2.f66365g);
                    }
                }
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onProgress(String str) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(PeakActivity peakActivity, String str, String str2, PublishVideoEntry publishVideoEntry) {
            if (peakActivity == null) {
                return;
            }
            this.f66366h = n();
            if (SaveVideoActivity.V == null) {
                SaveVideoActivity.V = FFmpeg.getInstance(peakActivity.getApplicationContext());
            }
            if (SaveVideoActivity.V.isFFmpegCommandRunning()) {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveVideoActivity", 2, "generate files mFFmpeg is running!");
                    return;
                }
                return;
            }
            try {
                if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(peakActivity.getIntent()) || ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(peakActivity.getIntent())) {
                    IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                    this.f66366h = iMiniAppService.getTmpPathFromOut(str, o(this.f66359a.get()));
                    String tmpPathFromOut = iMiniAppService.getTmpPathFromOut(publishVideoEntry.thumbPath, o(this.f66359a.get()));
                    publishVideoEntry.miniThumbPath = tmpPathFromOut;
                    if (tmpPathFromOut != null) {
                        FileUtils.copyFile(publishVideoEntry.thumbPath, tmpPathFromOut);
                    }
                }
                b bVar = new b(publishVideoEntry, str, this.f66366h);
                SaveVideoActivity.V.setCurrentTaskUni(this.f66366h);
                SaveVideoActivity.V.watermark(str2, str, this.f66366h, false, publishVideoEntry.videoWidth, publishVideoEntry.videoHeight, bVar);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveVideoActivity", 2, "generate files save alum:" + e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PublishVideoEntry D0(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (currentAccountUin != null) {
            ad0.a aVar = new ad0.a(currentAccountUin);
            aVar.verifyAuthentication();
            List<? extends Entity> F0 = F0(aVar.createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[]{str});
            if (F0 == null || F0.size() <= 0) {
                return null;
            }
            return (PublishVideoEntry) F0.get(0);
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    public static Intent E0(Context context, String str, int i3, int i16, int i17) {
        Intent intent = new Intent(context, (Class<?>) SaveVideoActivity.class);
        intent.putExtra("fakeId", str);
        intent.putExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, i16);
        intent.putExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, i3);
        intent.putExtra("save_video_businessid", i17);
        return intent;
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.FlowActivity, com.tencent.mobileqq.app.BaseActivity2, android.app.Activity
    public void onBackPressed() {
        if (this.T) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT < 29 || !((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("aio_capture_dialog_hide_navigation")) {
            return;
        }
        com.tencent.biz.subscribe.utils.g.c(getWindow());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.F = false;
        this.G = false;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        CodecParam.mRecordFrames = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
        CodecParam.mRecordTime = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
        this.U = intent.getIntExtra("requestCode", -1);
        a aVar = new a(this, fr.b.a());
        this.S = aVar;
        aVar.f66364f = intent.getBooleanExtra(ShortVideoConstants.VIDEO_EDIT_FLAG, false);
        this.S.f66365g = intent.getIntExtra("save_video_businessid", -1);
        Utils.executeAsyncTaskOnSerialExcuter(this.S, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G0(AppInterface appInterface, PublishVideoEntry publishVideoEntry) {
        if (publishVideoEntry == null) {
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (currentAccountUin != null) {
            ad0.a aVar = new ad0.a(currentAccountUin);
            aVar.verifyAuthentication();
            aVar.createEntityManager().remove(publishVideoEntry);
            return;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.T = true;
            if (this.S != null && !isFinishing()) {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveVideoActivity", 2, "cancel save video");
                }
                if (SlideShowPhotoListManager.n().m() == 22) {
                    int i16 = this.U;
                    if (i16 == 111) {
                        LpReportInfo_pf00064.allReport(680, 12, 2);
                    } else if (i16 == 222) {
                        LpReportInfo_pf00064.allReport(680, 13, 2);
                    }
                }
                this.S.f66361c.set(true);
                setResult(0, getIntent());
                if (getIntent() != null) {
                    final String stringExtra = getIntent().getStringExtra("fakeId");
                    ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AppInterface a16 = fr.b.a();
                            SaveVideoActivity.G0(a16, SaveVideoActivity.D0(a16, stringExtra));
                        }
                    }, null, true);
                }
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    private static List<? extends Entity> F0(EntityManager entityManager, Class<? extends Entity> cls, String str, String str2, String[] strArr) {
        return entityManager.query(cls, str, false, str2, strArr, null, null, null, null, null);
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.FlowActivity
    protected void y0(ViewGroup viewGroup) {
    }
}
