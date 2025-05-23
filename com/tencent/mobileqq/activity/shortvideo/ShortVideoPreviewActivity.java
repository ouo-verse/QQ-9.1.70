package com.tencent.mobileqq.activity.shortvideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cs;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.video.b;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.util.VersionUtils;
import com.vivo.push.PushClientConstants;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

@RoutePage(desc = "\u77ed\u89c6\u9891\u9884\u89c8\u9875\u9762", path = IPhotoLogicFactory.SHORT_VIDEO_PREVIEW_ACTIVITY_URI)
/* loaded from: classes10.dex */
public class ShortVideoPreviewActivity extends BaseActivity implements View.OnClickListener, Runnable {
    static final String C_TAG = "VideoCompressTask";
    public static final int DEST_TYPE_AIO = 0;
    public static final int DEST_TYPE_DATALINE = 4;
    public static final int DEST_TYPE_HEALTH = 7;
    public static final int DEST_TYPE_MP = 8;
    public static final int DEST_TYPE_QZONE = 1;
    public static final int DEST_TYPE_QZONE_VIDEO = 3;
    public static final int DEST_TYPE_TROOP_BAR = 2;
    public static final int DEST_TYPE_TROOP_REWARD = 5;
    public static final int DEST_TYPE_UP_MASTER = 10;
    public static final int DEST_TYPE_WEB = 6;
    public static final String INTENT_VALUE_CANCEL_IN_PREVIEW_ACTIVITY = "INTENT_VALUE_CANCEL_IN_PREVIEW_ACTIVITY";
    private static final String KEY_SIZE_AFTER_COMPRESS = "size_after_compress";
    private static final String KEY_THUMB_DIR = "thumb_dir";
    private static final String KEY_VIDEO_DIR = "video_dir";
    public static final String PREVIEW_ONLY = "preview_only";
    public static final int REQUEST_READINJOY_UGC_VIDEO_DELIVER = 101;
    static final String STATE_PLAY_POSITION = "state_play_position";
    static final String STATE_PLAY_STATE = "state_play_state";
    static final String TAG = "ShortVideoPreviewActivity";
    public static int mNoCompress;
    String localImagePath;
    Bitmap mBitmap;
    TextView mCancelBtn;
    ImageView mCover;
    int mDestType;
    long mDuration;
    String mFileSource;
    int mHeightInfo;
    boolean mIsFromSystemMedia;
    boolean mIsSupportVideoCheckbox;
    ImageView mOperatorBtn;
    int mSavedCurPosition;
    int mSavedPlayState;
    ArrayList<String> mSelectedVideoAndPhotoList;
    TextView mSendBtn;
    SurfaceView mSurfaceView;
    int mSurfaceViewHeight;
    int mSurfaceViewWidth;
    String mUin;
    int mUinType;
    String mVideoPath;
    long mVideoSize;
    int mWidthInfo;
    ImageView operatorBtnSeekBar;
    TextView progressTimeMp;
    LinearLayout seekBarLayout;
    SeekBar seekBarMp;
    TextView totalTimeMp;
    int duration = -1;
    com.tencent.mobileqq.video.b mMediaPlayer = new com.tencent.mobileqq.video.c();
    boolean mPreviewOnly = false;
    BroadcastReceiver mScreenReceiver = new i();
    SurfaceHolder.Callback mCallback = new m();
    private b.c mPreparedListener = new o();
    private b.a mCompleteListener = new p();
    private b.InterfaceC8953b mPlayStateListener = new q();
    final MqqHandler updateBarHandler = new h();
    Runnable updateSeekBarThread = new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.20
        @Override // java.lang.Runnable
        public void run() {
            if (ShortVideoPreviewActivity.this.mMediaPlayer.isPlaying() && ShortVideoPreviewActivity.this.mSurfaceView != null) {
                Message obtain = Message.obtain();
                obtain.arg1 = ShortVideoPreviewActivity.this.mMediaPlayer.getCurrentPosition();
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoPreviewActivity.TAG, 2, "\u6b64\u65f6\u65f6\u95f4\u4e3a+" + obtain.arg1);
                }
                ShortVideoPreviewActivity.this.seekBarMp.setProgress(obtain.arg1);
                MqqHandler mqqHandler = ShortVideoPreviewActivity.this.updateBarHandler;
                if (mqqHandler == null) {
                    return;
                }
                mqqHandler.sendMessage(obtain);
                ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
                shortVideoPreviewActivity.updateBarHandler.post(shortVideoPreviewActivity.updateSeekBarThread);
            }
        }
    };
    SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new j();

    /* loaded from: classes10.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Intent intent = ShortVideoPreviewActivity.super.getIntent();
            String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            Intent intent2 = new Intent();
            intent2.setClassName(stringExtra2, stringExtra);
            intent2.addFlags(603979776);
            intent2.putExtra("file_send_path", ShortVideoPreviewActivity.this.mVideoPath);
            intent2.putExtra(ShortVideoConstants.FILE_SEND_SIZE, ShortVideoPreviewActivity.this.mVideoSize);
            intent2.putExtra(ShortVideoConstants.FILE_SEND_DURATION, ShortVideoPreviewActivity.this.mDuration);
            intent2.putExtra(ShortVideoConstants.FILE_SOURCE, ShortVideoPreviewActivity.this.mFileSource);
            ShortVideoPreviewActivity.this.startActivity(intent2);
            ShortVideoPreviewActivity.super.finish();
            Intent intent3 = new Intent("key_video_select_confirm_ok_click");
            intent3.putExtra(PushClientConstants.TAG_CLASS_NAME, stringExtra);
            ShortVideoPreviewActivity.this.sendBroadcast(intent3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f186283d;

        d(Runnable runnable) {
            this.f186283d = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f186283d.run();
        }
    }

    /* loaded from: classes10.dex */
    class h extends MqqHandler {
        h() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            ShortVideoPreviewActivity.this.progressTimeMp.setText(ShortVideoUtils.stringForTime(message.arg1));
        }
    }

    /* loaded from: classes10.dex */
    class i extends BroadcastReceiver {
        i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoPreviewActivity.TAG, 2, "ACTION_SCREEN_OFF == >>");
                }
                ShortVideoPreviewActivity.this.pause();
            } else if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action)) {
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoPreviewActivity.TAG, 2, "ACTION_START_VIDEO_CHAT == >>");
                }
                ShortVideoPreviewActivity.this.pause();
            }
        }
    }

    /* loaded from: classes10.dex */
    class k implements ViewTreeObserver.OnGlobalLayoutListener {
        k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
            shortVideoPreviewActivity.mSurfaceViewWidth = shortVideoPreviewActivity.mSurfaceView.getWidth();
            ShortVideoPreviewActivity shortVideoPreviewActivity2 = ShortVideoPreviewActivity.this;
            shortVideoPreviewActivity2.mSurfaceViewHeight = shortVideoPreviewActivity2.mSurfaceView.getHeight();
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreviewActivity.TAG, 2, "onGlobalLayout,mSurfaceViewWidth:" + ShortVideoPreviewActivity.this.mSurfaceViewWidth + ",mSurfaceViewHeight:" + ShortVideoPreviewActivity.this.mSurfaceViewHeight);
            }
            ShortVideoPreviewActivity.this.mSurfaceView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* loaded from: classes10.dex */
    class l implements ViewTreeObserver.OnGlobalLayoutListener {
        l() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ThreadManagerV2.post(ShortVideoPreviewActivity.this, 8, null, false);
            ShortVideoPreviewActivity.this.mCover.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* loaded from: classes10.dex */
    class o implements b.c {
        o() {
        }

        @Override // com.tencent.mobileqq.video.b.c
        public void a(com.tencent.mobileqq.video.b bVar) {
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreviewActivity.TAG, 2, "mMediaPlayer onPrepared: mDuration=" + ShortVideoPreviewActivity.this.mDuration);
            }
            SurfaceHolder holder = ShortVideoPreviewActivity.this.mSurfaceView.getHolder();
            if (holder != null && holder.getSurface().isValid()) {
                ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
                cs.a(shortVideoPreviewActivity.mSurfaceView, shortVideoPreviewActivity.mSurfaceViewWidth, shortVideoPreviewActivity.mSurfaceViewHeight, shortVideoPreviewActivity.mMediaPlayer.getVideoWidth(), ShortVideoPreviewActivity.this.mMediaPlayer.getVideoHeight());
                if (ShortVideoPreviewActivity.this.mDestType == 10) {
                    bVar.setDisplay(holder);
                    ShortVideoPreviewActivity.this.duration = bVar.getDuration();
                    if (ShortVideoPreviewActivity.this.duration > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(ShortVideoPreviewActivity.TAG, 2, "\u6b64\u65f6\u7684\u65f6\u957f\u4e3a" + ShortVideoUtils.stringForTime(ShortVideoPreviewActivity.this.duration));
                        }
                        ShortVideoPreviewActivity.this.totalTimeMp.setText(ShortVideoUtils.stringForTime(r9.duration));
                        ShortVideoPreviewActivity shortVideoPreviewActivity2 = ShortVideoPreviewActivity.this;
                        shortVideoPreviewActivity2.seekBarMp.setMax(shortVideoPreviewActivity2.duration);
                        return;
                    }
                    return;
                }
                return;
            }
            com.tencent.mobileqq.filemanager.util.d.e(R.string.f170804af2);
        }
    }

    /* loaded from: classes10.dex */
    class p implements b.a {
        p() {
        }

        @Override // com.tencent.mobileqq.video.b.a
        public void a(com.tencent.mobileqq.video.b bVar) {
            QLog.i(ShortVideoPreviewActivity.TAG, 1, "[onCompletion] ");
            if (VersionUtils.isrFroyo()) {
                ((AudioManager) ShortVideoPreviewActivity.this.getSystemService("audio")).abandonAudioFocus(null);
            }
        }
    }

    /* loaded from: classes10.dex */
    class q implements b.InterfaceC8953b {
        q() {
        }

        @Override // com.tencent.mobileqq.video.b.InterfaceC8953b
        public void onPlayStateChanged(int i3) {
            if (i3 == 1) {
                ShortVideoPreviewActivity.this.mCover.setVisibility(8);
                ShortVideoPreviewActivity.this.mOperatorBtn.setImageResource(R.drawable.f9o);
            } else {
                ShortVideoPreviewActivity.this.mOperatorBtn.setImageResource(R.drawable.f9n);
            }
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreviewActivity.TAG, 2, "changePlayState, playState => " + ShortVideoPreviewActivity.this.getPlayStateStr(i3));
            }
        }
    }

    /* loaded from: classes10.dex */
    class r implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f186297d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f186298e;

        r(Intent intent, ArrayList arrayList) {
            this.f186297d = intent;
            this.f186298e = arrayList;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            PhotoUtils.sendPhoto(ShortVideoPreviewActivity.this, this.f186297d, this.f186298e, 2, false);
        }
    }

    /* loaded from: classes10.dex */
    class t extends AsyncTask<String, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        QQProgressDialog f186305a;

        /* renamed from: b, reason: collision with root package name */
        Activity f186306b;

        /* renamed from: c, reason: collision with root package name */
        String f186307c;

        /* renamed from: d, reason: collision with root package name */
        String f186308d;

        /* renamed from: e, reason: collision with root package name */
        String f186309e;

        public t(Activity activity) {
            this.f186306b = activity;
            this.f186305a = new QQProgressDialog(activity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x018c, code lost:
        
            if (r3 == null) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x016f, code lost:
        
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x016d, code lost:
        
            if (r3 != null) goto L64;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(String... strArr) {
            long j3;
            long j16;
            int i3 = 0;
            String str = strArr[0];
            int i16 = -1;
            if (TextUtils.isEmpty(str) || this.f186306b == null) {
                return -1;
            }
            this.f186307c = str;
            File file = new File(AppConstants.SDCARD_PATH + "shortvideo");
            if (!file.exists()) {
                file.mkdirs();
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean initVideoTrim = ShortVideoTrimmer.initVideoTrim(this.f186306b);
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return -1;
            }
            this.f186308d = ShortVideoUtils.getShortVideoCompressPath(str, str.substring(lastIndexOf + 1));
            if (initVideoTrim) {
                if (ShortVideoPreviewActivity.mNoCompress == -1) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPreviewActivity.TAG, 2, "ldNoCompress");
                    }
                    this.f186308d = this.f186307c;
                } else {
                    HashMap<String, String> CompressPosition = ShortVideoPreviewActivity.CompressPosition(str, this.f186306b);
                    int parseInt = Integer.parseInt(CompressPosition.get("ret"));
                    this.f186308d = CompressPosition.get("outputPath");
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPreviewActivity.TAG, 2, "Before Compress:" + str + "After Compress:" + this.f186308d);
                    }
                    i3 = parseInt;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long length = new File(str).length();
                if (!TextUtils.isEmpty(this.f186308d)) {
                    j16 = new File(this.f186308d).length();
                } else {
                    j16 = 0;
                }
                j3 = currentTimeMillis;
                long j17 = j16;
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoPreviewActivity.C_TAG, 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress ret = " + i3 + ", cost:" + currentTimeMillis2 + "ms, fileSourceSize=" + length + ", fileTargetSize=" + j17 + ", uniseq=");
                }
                i16 = i3;
            } else {
                j3 = currentTimeMillis;
            }
            Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(this.f186306b, str);
            if (videoThumbnail != null) {
                File file2 = new File(file, String.valueOf(j3) + "_thumb.jpg");
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        if (file2.createNewFile()) {
                            this.f186309e = file2.getPath();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getPath());
                            try {
                                videoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e16) {
                                e = e16;
                                fileOutputStream = fileOutputStream2;
                                QLog.i(ShortVideoPreviewActivity.C_TAG, 1, "create thumb exception:" + e);
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            return Integer.valueOf(i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            String str;
            super.onPostExecute(num);
            QQProgressDialog qQProgressDialog = this.f186305a;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f186305a.dismiss();
            }
            if (TextUtils.isEmpty(this.f186308d)) {
                str = this.f186307c;
            } else {
                str = this.f186308d;
            }
            long length = new File(str).length();
            if (this.f186306b != null) {
                if (length > r3.getIntent().getIntExtra(ShortVideoPreviewActivity.KEY_SIZE_AFTER_COMPRESS, 10485760)) {
                    QQToast.makeText(this.f186306b, HardCodeUtil.qqStr(R.string.ti5), 0).show(ShortVideoPreviewActivity.this.getTitleBarHeight());
                    this.f186306b.setResult(0);
                    this.f186306b.finish();
                    this.f186306b = null;
                    return;
                }
                if (this.f186306b != null && num.intValue() == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("video_dir", str);
                    intent.putExtra(ShortVideoPreviewActivity.KEY_THUMB_DIR, this.f186309e);
                    this.f186306b.setResult(-1, intent);
                    this.f186306b.finish();
                    this.f186306b = null;
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f186305a.setMessage(HardCodeUtil.qqStr(R.string.thc));
            this.f186305a.setCancelable(false);
            this.f186305a.show();
        }
    }

    public static HashMap<String, String> CompressPosition(String str, Context context) {
        int i3;
        HashMap<String, String> hashMap = new HashMap<>();
        String shortVideoCompressPath = ShortVideoUtils.getShortVideoCompressPath(str, str.substring(str.lastIndexOf(".") + 1));
        VideoConverterConfig compressConfig = ShortVideoTrimmer.getCompressConfig(str);
        if (compressConfig != null && compressConfig.isNeedCompress) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            s sVar = new s(shortVideoCompressPath, (int) (compressConfig.srcBitrate * 1024), (int) compressConfig.srcFrameRate, 0L, Long.parseLong(extractMetadata));
            VideoConverter videoConverter = new VideoConverter(new br2.a());
            videoConverter.setCompressMode(1);
            int startCompress = videoConverter.startCompress(context, str, sVar, true);
            if (startCompress == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(C_TAG, 2, "CompressTask, step: compress completed using MediaCodec");
                }
                i3 = 0;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(C_TAG, 2, "CompressTask, step: compress failed using MediaCodec, compressRet:" + startCompress);
                }
                i3 = -1;
            }
            if (i3 != 0 && !TextUtils.isEmpty(shortVideoCompressPath)) {
                if (QLog.isColorLevel()) {
                    QLog.d(C_TAG, 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
                }
                i3 = ShortVideoTrimmer.compressVideo(context, str, shortVideoCompressPath, compressConfig);
            }
        } else if (compressConfig != null && !compressConfig.isNeedCompress) {
            shortVideoCompressPath = str;
            i3 = 0;
        } else {
            i3 = -1;
        }
        hashMap.put("outputPath", shortVideoCompressPath);
        hashMap.put("ret", String.valueOf(i3));
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
    
        if (r3 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        if (r3 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String coverToLocalImage(Bitmap bitmap) {
        String str;
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "cutvideoMp"));
        if (!file.exists()) {
            file.mkdirs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileOutputStream fileOutputStream = null;
        if (bitmap == null) {
            return null;
        }
        File file2 = new File(file, String.valueOf(currentTimeMillis) + "_thumb.jpg");
        try {
            try {
                if (file2.createNewFile()) {
                    str = file2.getPath();
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getPath());
                        try {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            QLog.i(C_TAG, 1, "create thumb exception:" + e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            return str;
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e18) {
                        e = e18;
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                    }
                } else {
                    str = null;
                }
            } catch (Exception e26) {
                e = e26;
                str = null;
            } catch (OutOfMemoryError e27) {
                e = e27;
                str = null;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void handleSendVideo2Dataline() {
        this.mVideoSize = new File(this.mVideoPath).length();
        if (NetworkUtil.isNetworkAvailable(this) && !NetworkUtil.isWifiConnected(this) && this.mVideoSize > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FMDialogUtil.a(this, R.string.b_v, R.string.f170958ba0, new f());
        } else {
            sendVideo();
            setResult(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVideo() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(PeakConstants.DEST_VIDEO_ACTIVITY_CLASS_NAME);
        String stringExtra2 = intent.getStringExtra(PeakConstants.DEST_VIDEO_ACTIVITY_PACKAGE_NAME);
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            if (stringExtra == null) {
                return;
            }
        }
        intent.setClassName(stringExtra2, stringExtra);
        intent.putExtra("file_send_path", this.mVideoPath);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, this.mDuration);
        intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, this.mVideoSize);
        intent.putExtra("uin", this.mUin);
        intent.putExtra("uintype", this.mUinType);
        intent.putExtra(ShortVideoConstants.FILE_SOURCE, this.mFileSource);
        intent.putExtra(ShortVideoConstants.START_INIT_ACTIVITY_AFTER_SENDED, true);
        if (!this.mIsFromSystemMedia) {
            ReportController.o(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
        }
        Intent intent2 = getIntent();
        if (intent2 != null && intent2.hasExtra(PeakConstants.CUSTOM_SHORTVIDEOPREVIEW_SENDBTN_REPORT_ACTION_NAME)) {
            String stringExtra3 = intent2.getStringExtra(PeakConstants.CUSTOM_SHORTVIDEOPREVIEW_SENDBTN_REPORT_ACTION_NAME);
            String stringExtra4 = intent2.getStringExtra(PeakConstants.CUSTOM_SHORTVIDEOPREVIEW_SENDBTN_REPORT_REVERSE2);
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            String str = stringExtra4;
            if (stringExtra3 != null) {
                ReportController.o(null, "CliOper", "", "", stringExtra3, stringExtra3, 0, 0, str, "", "", "");
            }
        }
        startActivity(intent);
    }

    public static void showAlertDialog(Context context, int i3) {
        DialogUtil.createCustomDialog(context, 232, null, context.getString(i3), new g(), null).show();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        initData(super.getIntent());
        if (bundle != null) {
            this.mSavedPlayState = bundle.getInt(STATE_PLAY_STATE);
            this.mSavedCurPosition = bundle.getInt(STATE_PLAY_POSITION);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onCreate(), mSavedCurPosition : " + this.mSavedCurPosition + ",mSavedPlayState : " + getPlayStateStr(this.mSavedPlayState));
            }
        }
        super.setContentView(R.layout.b2x);
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.j8h);
        this.mSurfaceView = surfaceView;
        surfaceView.getHolder().setType(3);
        this.mSurfaceView.getHolder().addCallback(this.mCallback);
        this.mSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new k());
        this.mCover = (ImageView) findViewById(R.id.bat);
        TextView textView = (TextView) findViewById(R.id.aoo);
        this.mCancelBtn = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.f166845in0);
        this.mSendBtn = textView2;
        textView2.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.fff);
        this.mOperatorBtn = imageView;
        imageView.setOnClickListener(this);
        this.seekBarLayout = (LinearLayout) findViewById(R.id.fad);
        this.progressTimeMp = (TextView) findViewById(R.id.g1n);
        this.totalTimeMp = (TextView) findViewById(R.id.juu);
        ImageView imageView2 = (ImageView) findViewById(R.id.ffg);
        this.operatorBtnSeekBar = imageView2;
        imageView2.setImageResource(R.drawable.f9o);
        this.operatorBtnSeekBar.setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.ili);
        this.seekBarMp = seekBar;
        seekBar.setVisibility(0);
        this.seekBarMp.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        this.mCover.getViewTreeObserver().addOnGlobalLayoutListener(new l());
        updateUIByDestType();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        registerReceiver(this.mScreenReceiver, intentFilter);
        if (this.mDestType == 10) {
            if (bundle == null) {
                play(0);
            } else if (this.mSavedPlayState == 1) {
                play(this.mSavedCurPosition);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        MqqHandler mqqHandler = this.updateBarHandler;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacks(this.updateSeekBarThread);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnDestroy");
        }
        releaseMediaPlayer();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.mBitmap.recycle();
            }
            this.mBitmap = null;
        }
        unregisterReceiver(this.mScreenReceiver);
    }

    int getPlayState() {
        return this.mMediaPlayer.getPlayState();
    }

    String getPlayStateStr(int i3) {
        return com.tencent.mobileqq.video.c.f(i3);
    }

    void handleSendVideo() {
        boolean z16;
        boolean z17;
        boolean z18;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Environment.getExternalStorageState().equals("mounted") && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mVideoSize = new File(this.mVideoPath).length();
        if (z17) {
            if (Utils.z() > 512000) {
                if (com.tencent.mobileqq.shortvideo.h.f287891c != 0 && System.currentTimeMillis() - com.tencent.mobileqq.shortvideo.h.f287891c < MiniBoxNoticeInfo.MIN_5) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "upload video isConfirmed=" + z18 + " allowUploadInXGTime=" + com.tencent.mobileqq.shortvideo.h.f287891c);
                }
                if (NetworkUtil.isMobileNetWork(this) && !z18) {
                    long j3 = this.mVideoSize;
                    if (j3 >= 1048576) {
                        DialogUtil.createCustomDialog(this, 232, null, String.format(getResources().getString(R.string.f173147hl1), ShortVideoUtils.stringForFileSize(this, j3)), new d(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.13
                            @Override // java.lang.Runnable
                            public void run() {
                                ShortVideoPreviewActivity.this.sendVideo();
                                com.tencent.mobileqq.shortvideo.h.f287891c = System.currentTimeMillis();
                                ShortVideoPreviewActivity.this.setResult(-1);
                            }
                        }), new e()).show();
                        return;
                    }
                }
                sendVideo();
                return;
            }
            showAlertDialog(this, R.string.hlp);
            return;
        }
        QQToast.makeText(this, 1, R.string.h9v, 0).show(getTitleBarHeight());
    }

    void initData(Intent intent) {
        int i3;
        this.mVideoPath = intent.getExtras().getString("file_send_path");
        this.mDuration = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_DURATION);
        this.mVideoSize = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_SIZE);
        this.mWidthInfo = intent.getIntExtra(ShortVideoConstants.FILE_WIDTH, 0);
        this.mHeightInfo = intent.getIntExtra(ShortVideoConstants.FILE_HEIGHT, 0);
        intent.removeExtra(ShortVideoConstants.FILE_WIDTH);
        intent.removeExtra(ShortVideoConstants.FILE_HEIGHT);
        this.mUin = intent.getExtras().getString("uin");
        this.mUinType = intent.getIntExtra("uintype", -1);
        this.mFileSource = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
        this.mPreviewOnly = intent.getBooleanExtra(PREVIEW_ONLY, false);
        this.mIsFromSystemMedia = intent.getBooleanExtra(ShortVideoConstants.IS_FROM_SYSTEM_MEDIA, true);
        boolean booleanExtra = intent.getBooleanExtra(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, false);
        this.mIsSupportVideoCheckbox = booleanExtra;
        if (booleanExtra) {
            this.mSelectedVideoAndPhotoList = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        }
        boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.IS_FROM_TROOP_BAR, false);
        boolean booleanExtra3 = intent.getBooleanExtra(PeakConstants.IS_FROM_TROOP_REWARD, false);
        String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if (stringExtra == null) {
            this.mDestType = -1;
        } else if (!stringExtra.contains("SplashActivity") && !stringExtra.contains("ChatActivity")) {
            if (!stringExtra.contains(PeakConstants.VIDEO_REFER_FROM_MOOD) && !stringExtra.contains("QZonePublishMoodRealActivity")) {
                if (stringExtra.contains(PeakConstants.VIDEO_REFER_FROM_ALBUM)) {
                    this.mDestType = 1;
                } else if (booleanExtra2) {
                    this.mDestType = 2;
                } else if (booleanExtra3) {
                    this.mDestType = 5;
                } else if (stringExtra.contains("TrimVideoActivity")) {
                    this.mDestType = 3;
                } else if (stringExtra.contains("LiteActivity")) {
                    this.mDestType = 4;
                } else if (!stringExtra.contains("QQBrowserActivity") && !stringExtra.contains("PublicAccountBrowser")) {
                    if (stringExtra.contains("ReadInJoyDeliverVideoActivity")) {
                        this.mDestType = 10;
                    } else {
                        this.mDestType = 0;
                    }
                } else {
                    this.mDestType = 6;
                }
            } else {
                this.mDestType = 1;
            }
        } else {
            this.mDestType = 0;
        }
        if (TextUtils.isEmpty(this.mVideoPath) || (((i3 = this.mDestType) != 2 && i3 != 6 && i3 != 10 && TextUtils.isEmpty(this.mUin)) || !FileUtils.fileExistsAndNotEmpty(this.mVideoPath))) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
            }
            QQToast.makeText(this, R.string.hl8, 0).show();
            super.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    @TargetApi(11)
    public void onClick(View view) {
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.aoo) {
            super.finish();
        } else if (id5 == R.id.fff) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleClick: mPlayState = " + getPlayStateStr(getPlayState()));
            }
            if (this.mSavedPlayState == 2 && (i16 = this.mSavedCurPosition) > 0) {
                play(i16);
                this.mSavedPlayState = 0;
                this.mSavedCurPosition = 0;
            } else {
                int playState = getPlayState();
                if (playState != 0) {
                    if (playState != 1) {
                        if (playState != 2) {
                            if (playState == 3) {
                                play(0);
                            }
                        } else {
                            resume();
                        }
                    } else {
                        pause();
                    }
                } else if (this.app.isVideoChatting()) {
                    QQToast.makeText(this, 0, R.string.hld, 0).show();
                } else {
                    play(0);
                }
            }
        } else if (id5 == R.id.ffg) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleClick: mPlayState = " + getPlayStateStr(getPlayState()));
            }
            if (this.mSavedPlayState == 2 && (i3 = this.mSavedCurPosition) > 0) {
                play(i3);
                this.mSavedPlayState = 0;
                this.mSavedCurPosition = 0;
            } else {
                int playState2 = getPlayState();
                if (playState2 != 0) {
                    if (playState2 != 1) {
                        if (playState2 != 2) {
                            if (playState2 == 3) {
                                play(0);
                            }
                        } else {
                            this.operatorBtnSeekBar.setImageResource(R.drawable.f9o);
                            resume();
                        }
                    } else {
                        this.operatorBtnSeekBar.setImageResource(R.drawable.f9n);
                        pause();
                    }
                } else if (this.app.isVideoChatting()) {
                    QQToast.makeText(this, 0, R.string.hld, 0).show();
                } else {
                    play(0);
                }
            }
        } else if (id5 == R.id.f166845in0) {
            int i17 = this.mDestType;
            if (i17 != 0) {
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 != 4) {
                                if (i17 != 5) {
                                    if (i17 == 7) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d(TAG, 2, "ldStart Compress");
                                        }
                                        mNoCompress = -1;
                                        new t(this).execute(this.mVideoPath);
                                    }
                                } else {
                                    Intent intent = super.getIntent();
                                    intent.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
                                    intent.putExtra(PeakConstants.VIDEO_SIZE, this.mVideoSize);
                                    intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, this.mDuration);
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(this.mVideoPath);
                                    DialogUtil.createCustomDialog(this, 232, null, getString(R.string.f171417ev0, String.format("%.2fMB", Double.valueOf((this.mVideoSize / 1024.0d) / 1024.0d))), new r(intent, arrayList), new a()).show();
                                }
                            } else {
                                handleSendVideo2Dataline();
                            }
                        }
                    } else {
                        DialogUtil.createCustomDialog(this, 232, null, getString(R.string.f171417ev0, String.format("%.2fMB", Double.valueOf((this.mVideoSize / 1024.0d) / 1024.0d))), new b(), new c()).show();
                        Intent intent2 = new Intent("key_video_select_apply_click");
                        intent2.putExtra(PushClientConstants.TAG_CLASS_NAME, super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                        sendBroadcast(intent2);
                    }
                }
                Intent intent3 = super.getIntent();
                intent3.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
                intent3.putExtra(PeakConstants.VIDEO_SIZE, this.mVideoSize);
                intent3.putExtra(ShortVideoConstants.FILE_SEND_DURATION, this.mDuration);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.mVideoPath);
                PhotoUtils.sendPhoto(this, intent3, arrayList2, 2, false);
            } else {
                handleSendVideo();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (getPlayState() == 1 || getPlayState() == 2) {
            this.mSavedCurPosition = this.mMediaPlayer.getCurrentPosition();
        }
        this.mSavedPlayState = getPlayState();
        bundle.putInt(STATE_PLAY_STATE, getPlayState());
        bundle.putInt(STATE_PLAY_POSITION, this.mSavedCurPosition);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSaveInstanceState: mSavedCurPosition: " + this.mSavedCurPosition + " ,playState = " + getPlayStateStr(getPlayState()));
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).abandonAudioFocus(null);
        }
        super.onStop();
    }

    void pause() {
        if (VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).abandonAudioFocus(null);
        }
        this.mMediaPlayer.pause();
    }

    void play(int i3) {
        if (!FileUtils.fileExistsAndNotEmpty(this.mVideoPath)) {
            QQToast.makeText(this, R.string.hl8, 0).show();
            return;
        }
        this.mMediaPlayer.a(this.mCompleteListener);
        this.mMediaPlayer.c(this.mPreparedListener);
        this.mMediaPlayer.b(this.mPlayStateListener);
        if (this.mMediaPlayer.d(this.mVideoPath, i3)) {
            if (VersionUtils.isrFroyo()) {
                ((AudioManager) getSystemService("audio")).requestAudioFocus(null, 3, 2);
            }
            if (this.mDestType != 10) {
                try {
                    this.mMediaPlayer.setDisplay(this.mSurfaceView.getHolder());
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "play exception:", e16);
                    return;
                }
            }
            return;
        }
        DialogUtil.createCustomDialog(this, 232, null, getString(R.string.hly), new n(), null).show();
    }

    void releaseMediaPlayer() {
        com.tencent.mobileqq.video.b bVar = this.mMediaPlayer;
        if (bVar != null) {
            bVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    void resume() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "#resume#");
        }
        this.mMediaPlayer.resume();
        if (VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).requestAudioFocus(null, 3, 2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mBitmap = ShortVideoUtils.getVideoThumbnail(this, this.mVideoPath);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.18
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
                shortVideoPreviewActivity.mCover.setImageBitmap(shortVideoPreviewActivity.mBitmap);
            }
        });
    }

    void updateUIByDestType() {
        ArrayList<String> arrayList;
        TextView textView = this.mSendBtn;
        if (textView != null) {
            int i3 = this.mDestType;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        textView.setText(R.string.f171151ok);
                    } else {
                        textView.setText(R.string.ejf);
                    }
                } else {
                    textView.setText(R.string.f171151ok);
                }
            } else {
                StringBuilder sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.f172712ti4));
                if (this.mIsSupportVideoCheckbox && (arrayList = this.mSelectedVideoAndPhotoList) != null && arrayList.size() > 0) {
                    sb5.append("(");
                    sb5.append(this.mSelectedVideoAndPhotoList.size());
                    sb5.append(")");
                }
                this.mSendBtn.setText(sb5);
            }
            if (this.mPreviewOnly) {
                this.mSendBtn.setVisibility(8);
                TextView textView2 = this.mCancelBtn;
                if (textView2 != null) {
                    textView2.setText(R.string.hih);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements FMDialogUtil.c {
        f() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ShortVideoPreviewActivity.this.sendVideo();
            ShortVideoPreviewActivity.this.setResult(-1);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* loaded from: classes10.dex */
    public static class s implements VideoConverter.Processor {

        /* renamed from: a, reason: collision with root package name */
        final String f186300a;

        /* renamed from: b, reason: collision with root package name */
        final int f186301b;

        /* renamed from: c, reason: collision with root package name */
        final int f186302c;

        /* renamed from: d, reason: collision with root package name */
        final long f186303d;

        /* renamed from: e, reason: collision with root package name */
        final long f186304e;

        s(String str, int i3, int i16, long j3, long j16) {
            this.f186300a = str;
            this.f186301b = i3;
            this.f186303d = j3;
            this.f186304e = j16;
            if (i16 > 0) {
                this.f186302c = i16;
            } else {
                this.f186302c = 30;
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public VideoConverterConfig getEncodeConfig(int i3, int i16) {
            String str;
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            if (i3 <= i16) {
                i3 = i16;
            }
            videoConverterConfig.output = this.f186300a;
            int i17 = 1280;
            if (i3 >= 1280) {
                str = "720p";
            } else {
                i17 = 960;
                if (i3 >= 960) {
                    str = "540p";
                } else {
                    i17 = 640;
                    str = "480p";
                }
            }
            if (i3 < i17) {
                videoConverterConfig.videoBitRate = (int) (((819200 * 1.0d) / i17) * i3);
            } else {
                videoConverterConfig.videoBitRate = 819200;
            }
            videoConverterConfig.scaleRate = i17 / i3;
            int i18 = this.f186302c;
            if (i18 > 30) {
                i18 = 30;
            }
            videoConverterConfig.videoFrameRate = i18;
            videoConverterConfig.beginTime = this.f186303d;
            videoConverterConfig.endTime = this.f186304e;
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreviewActivity.C_TAG, 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + videoConverterConfig.setRotation + ", scaleRate=" + videoConverterConfig.scaleRate + ", videoBitRate=" + videoConverterConfig.videoBitRate + ", videoFrameRate=" + videoConverterConfig.videoFrameRate + ", beginTime=" + videoConverterConfig.beginTime + ", endTime=" + videoConverterConfig.endTime + ",quality:" + str + ",videoLongestEdge=" + i17);
            }
            return videoConverterConfig;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(Throwable th5) {
            QLog.e(ShortVideoPreviewActivity.C_TAG, 1, "CompressTask, step: HWCompressProcessor onFailed:" + th5.getMessage());
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
        }
    }

    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* loaded from: classes10.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class n implements DialogInterface.OnClickListener {
        n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* loaded from: classes10.dex */
    class j implements SeekBar.OnSeekBarChangeListener {
        j() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            int progress = ShortVideoPreviewActivity.this.seekBarMp.getProgress();
            ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
            MqqHandler mqqHandler = shortVideoPreviewActivity.updateBarHandler;
            if (mqqHandler != null) {
                mqqHandler.removeCallbacks(shortVideoPreviewActivity.updateSeekBarThread);
            }
            ShortVideoPreviewActivity.this.pause();
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreviewActivity.TAG, 2, "onStartTrackingTouch: progress = " + progress);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            int progress = ShortVideoPreviewActivity.this.seekBarMp.getProgress();
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreviewActivity.TAG, 2, "onStopTrackingTouch: \u5f53\u524d\u4f4d\u7f6e\u4e3a = " + progress);
            }
            ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
            if (shortVideoPreviewActivity.mMediaPlayer != null) {
                if (shortVideoPreviewActivity.getPlayState() == 2) {
                    ShortVideoPreviewActivity.this.resume();
                }
                ShortVideoPreviewActivity.this.operatorBtnSeekBar.setImageResource(R.drawable.f9o);
                ShortVideoPreviewActivity.this.mMediaPlayer.start();
                ShortVideoPreviewActivity.this.mMediaPlayer.seekTo(progress);
                ShortVideoPreviewActivity shortVideoPreviewActivity2 = ShortVideoPreviewActivity.this;
                shortVideoPreviewActivity2.updateBarHandler.post(shortVideoPreviewActivity2.updateSeekBarThread);
                ShortVideoPreviewActivity.this.mSendBtn.setEnabled(false);
                ShortVideoPreviewActivity.this.mSendBtn.setTextColor(-2130706433);
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }

    /* loaded from: classes10.dex */
    class m implements SurfaceHolder.Callback {
        m() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            int i3;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("surfaceCreated: mSavedCurPosition:");
                sb5.append(ShortVideoPreviewActivity.this.mSavedCurPosition);
                sb5.append(",mSavedPlayState : ");
                ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
                sb5.append(shortVideoPreviewActivity.getPlayStateStr(shortVideoPreviewActivity.mSavedPlayState));
                QLog.d(ShortVideoPreviewActivity.TAG, 2, sb5.toString());
            }
            ShortVideoPreviewActivity shortVideoPreviewActivity2 = ShortVideoPreviewActivity.this;
            if (shortVideoPreviewActivity2.mSavedPlayState == 1 && (i3 = shortVideoPreviewActivity2.mSavedCurPosition) > 0) {
                shortVideoPreviewActivity2.play(i3);
                ShortVideoPreviewActivity shortVideoPreviewActivity3 = ShortVideoPreviewActivity.this;
                shortVideoPreviewActivity3.mSavedCurPosition = 0;
                shortVideoPreviewActivity3.mSavedPlayState = 0;
                return;
            }
            shortVideoPreviewActivity2.mCover.setVisibility(0);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreviewActivity.TAG, 2, "surfaceDestroyed ");
            }
            com.tencent.mobileqq.video.b bVar = ShortVideoPreviewActivity.this.mMediaPlayer;
            if (bVar != null) {
                bVar.release();
            }
            ShortVideoPreviewActivity shortVideoPreviewActivity = ShortVideoPreviewActivity.this;
            MqqHandler mqqHandler = shortVideoPreviewActivity.updateBarHandler;
            if (mqqHandler != null) {
                mqqHandler.removeCallbacks(shortVideoPreviewActivity.updateSeekBarThread);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        }
    }
}
