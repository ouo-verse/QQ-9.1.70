package com.tencent.aelight.camera.aioeditor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import fs.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends AsyncTask<Void, Void, Integer> {

    /* renamed from: m, reason: collision with root package name */
    private static AtomicLong f66584m = new AtomicLong(0);

    /* renamed from: a, reason: collision with root package name */
    private int f66585a;

    /* renamed from: b, reason: collision with root package name */
    private String f66586b;

    /* renamed from: c, reason: collision with root package name */
    private String f66587c;

    /* renamed from: d, reason: collision with root package name */
    private String f66588d;

    /* renamed from: e, reason: collision with root package name */
    private int f66589e;

    /* renamed from: f, reason: collision with root package name */
    private String f66590f;

    /* renamed from: g, reason: collision with root package name */
    private VideoSendPublicParam f66591g;

    /* renamed from: h, reason: collision with root package name */
    private d.a f66592h = new d.a();

    /* renamed from: i, reason: collision with root package name */
    private long f66593i;

    /* renamed from: j, reason: collision with root package name */
    private String f66594j;

    /* renamed from: k, reason: collision with root package name */
    private ProgressDialog f66595k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f66596l;

    public c(VideoSendPublicParam videoSendPublicParam) {
        this.f66593i = 0L;
        this.f66594j = "";
        this.f66591g = videoSendPublicParam;
        this.f66593i = f66584m.getAndIncrement();
        this.f66594j = "MediaCodecSendTask_[mSessionId=" + this.f66593i + "]";
    }

    private void a(String str, Throwable th5) {
        if (th5 != null) {
            QLog.i(this.f66594j, 1, "[@] " + str, th5);
            return;
        }
        QLog.i(this.f66594j, 1, "[@] " + str);
    }

    private void b() {
        a("cancelProgressDialog", null);
        try {
            ProgressDialog progressDialog = this.f66595k;
            if (progressDialog != null) {
                progressDialog.cancel();
                this.f66595k = null;
            }
        } catch (Exception unused) {
        }
    }

    private int d() {
        FileInputStream fileInputStream;
        VideoSendPublicParam videoSendPublicParam = this.f66591g;
        BaseImageUtil.updateLBSExif(videoSendPublicParam.mThumbFilePath, videoSendPublicParam.mLatitude, videoSendPublicParam.mLongitude);
        File file = new File(this.f66591g.mThumbFilePath);
        try {
            fileInputStream = new FileInputStream(this.f66591g.mThumbFilePath);
            try {
                this.f66587c = HexUtil.bytes2HexStr(MD5.toMD5Byte(fileInputStream, file.length()));
            } catch (FileNotFoundException unused) {
            }
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.f66587c)) {
            a("doInBackground(), mTempMd5 is empty", null);
            return -302;
        }
        String l3 = j.l(this.f66587c, "jpg");
        if (FileUtils.moveFile(this.f66591g.mThumbFilePath, l3)) {
            this.f66591g.mThumbFilePath = l3;
            return 0;
        }
        if (FileUtils.fileExistsAndNotEmpty(l3)) {
            return 0;
        }
        a("doInBackground(), rename failure, mThumbFilePath = " + this.f66591g.mThumbFilePath + ",thumbPath=" + l3, null);
        return -301;
    }

    private int f() {
        int a16;
        this.f66586b = this.f66591g.mVideoCacheDir;
        a("cacheDir=" + this.f66586b, null);
        if (!FileUtils.fileExistsAndNotEmpty(this.f66591g.mVideoFilePath)) {
            a("video file empty! path=" + this.f66591g.mVideoFilePath, null);
            return -300;
        }
        if (!FileUtils.fileExistsAndNotEmpty(this.f66591g.mThumbFilePath)) {
            a("thumb file empty! path=" + this.f66591g.mThumbFilePath, null);
            return -301;
        }
        Intent intent = this.f66591g.mContext.getIntent();
        this.f66589e = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 0);
        this.f66588d = intent.getStringExtra(ShortVideoConstants.BLESS_PTV_MP4_Path);
        this.f66590f = intent.getStringExtra(ISelectMemberActivityConstants.FAKE_ID);
        int a17 = com.tencent.mobileqq.shortvideo.util.d.a(this.f66591g.mVideoFilePath, this.f66592h);
        if (a17 != 0) {
            a("MediaMetadataUtils: errCode=" + a17, null);
            return a17;
        }
        if (intent.getBooleanExtra("from_qzone_slideshow", false)) {
            a16 = this.f66591g.recordTime;
        } else {
            a16 = (int) t.a(this.f66591g.mEncodeMode, this.f66592h.f288248a[3]);
        }
        this.f66585a = (a16 + 500) / 1000;
        VideoSendPublicParam videoSendPublicParam = this.f66591g;
        if (videoSendPublicParam.mThumbWidth <= 0 || videoSendPublicParam.mThumbHeight <= 0) {
            int[] iArr = this.f66592h.f288248a;
            int i3 = iArr[2];
            int i16 = iArr[0];
            videoSendPublicParam.mThumbWidth = i16;
            int i17 = iArr[1];
            videoSendPublicParam.mThumbHeight = i17;
            if (i3 == 90 || i3 == 270) {
                videoSendPublicParam.mThumbWidth = i17;
                videoSendPublicParam.mThumbHeight = i16;
            }
        }
        return d();
    }

    private void g(Intent intent) {
        intent.putExtra(ShortVideoConstants.SV_MEDIACODEC_ENCODE_ENABLE, true);
        intent.putExtra(PeakConstants.IS_VIDEO_RECORDED, true);
        intent.putExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR, this.f66586b);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, this.f66591g.mThumbFilePath);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, this.f66591g.mThumbWidth);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, this.f66591g.mThumbHeight);
        intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, this.f66587c);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, this.f66585a * 1000);
        intent.putExtra(PeakConstants.VIDEO_NEED_PROCESS, true);
        intent.putExtra(PeakConstants.VIDEO_TYPE, 0);
        intent.putExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID, this.f66591g.fakeVid);
        intent.putExtra(ShortVideoConstants.VIDEO_IS_GENERATE_GIF, this.f66591g.generateGif);
        intent.putExtra(ShortVideoConstants.VIDEO_MOOD_TIMER_DELETE, this.f66591g.timerDelete);
        intent.putExtra(PeakConstants.EXTRA_DIRECTLY_BACK, true);
        Bundle bundle = new Bundle();
        bundle.putInt(ShortVideoConstants.SV_ENCODE_MAX_BITRATE, CodecParam.mMaxrate);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_MIN_BITRATE, CodecParam.mMinrate);
        bundle.putInt(ShortVideoConstants.SV_TOTAL_RECORD_TIME, this.f66585a);
        intent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        long currentTimeMillis = System.currentTimeMillis();
        int f16 = f();
        if (f16 != 0) {
            return Integer.valueOf(f16);
        }
        a("doInBackground total:time=" + ((System.currentTimeMillis() - currentTimeMillis) / 1000.0d), null);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        b();
        boolean z16 = true;
        boolean z17 = false;
        if (num.intValue() == 0) {
            int i3 = this.f66591g.entrySource;
            if (i3 == 3) {
                Intent intent = new Intent(this.f66591g.mContext.getIntent());
                g(intent);
                intent.setFlags(536870912);
                if (intent.getStringExtra("qzone_plugin_activity_name") == null) {
                    QzonePluginProxyActivity.setActivityNameToIntent(intent, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
                }
                QZoneHelper.launchQZone(this.f66591g.mContext, "", intent, -1);
                this.f66591g.mContext.finish();
                this.f66591g.mContext = null;
                return;
            }
            if (i3 == 5) {
                Intent intent2 = new Intent(this.f66591g.mContext.getIntent());
                g(intent2);
                intent2.setClass(this.f66591g.mContext, NewPhotoListActivity.class);
                intent2.addFlags(603979776);
                this.f66591g.mContext.startActivity(intent2);
                return;
            }
            Intent intent3 = new Intent();
            h(intent3);
            VideoSendPublicParam videoSendPublicParam = this.f66591g;
            qs.c cVar = videoSendPublicParam.mUserCallBack;
            if (cVar != null) {
                cVar.sendClick(videoSendPublicParam.mContext, intent3);
                this.f66591g.mContext.finish();
                this.f66591g.mContext = null;
                return;
            }
            intent3.putExtra("uin", videoSendPublicParam.mUin);
            intent3.putExtra("uintype", this.f66591g.mUinType);
            intent3.putExtra("troop_uin", this.f66591g.mTroopUin);
            intent3.putExtra(ShortVideoConstants.FILE_SEND_BUSINESS_TYPE, 2);
            a("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = " + this.f66586b, null);
            intent3.putExtra("ab_test_send_btn_click_time", this.f66591g.mContext.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
            String str = this.f66591g.mUin;
            if (str != null && str.equals(MessageForBlessPTV.BLESS_REQ_UIN)) {
                intent3.putExtra(ShortVideoConstants.BLESS_PTV_MP4_Path, this.f66588d);
                intent3.putExtra("param_type", 9003);
                intent3.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                intent3.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
                intent3.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, this.f66591g.mContext.getString(R.string.f170612vu));
                intent3.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, this.f66591g.mContext.getString(R.string.a8j));
                intent3.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 1);
                intent3.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, this.f66589e);
                intent3.putExtra(ISelectMemberActivityConstants.PARAM_BLESSTYPE, 2);
                intent3.putExtra("encode_type", 1);
                intent3.putExtra(ISelectMemberActivityConstants.FAKE_ID, this.f66590f);
                ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startBlessSelectMemberActivityForResult(this.f66591g.mContext, intent3, 10007);
            } else {
                VideoSendPublicParam videoSendPublicParam2 = this.f66591g;
                if (videoSendPublicParam2.mUinType == 10014) {
                    Intent intent4 = (Intent) videoSendPublicParam2.mContext.getIntent().getParcelableExtra(PeakConstants.GUILD_OPEN_AIO_INTENT);
                    if (intent4 != null) {
                        intent4.putExtra(PeakConstants.GUILD_VIDEO_SEND_FLAG, true);
                        intent4.putExtras(intent3);
                        intent4.putExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_PATH, this.f66591g.mVideoFilePath);
                        this.f66591g.mContext.startActivity(intent4);
                    }
                } else {
                    intent3.setClass(videoSendPublicParam2.mContext, SendVideoActivity.class);
                    this.f66591g.mContext.startActivity(intent3);
                }
                z16 = false;
            }
            z17 = z16;
        } else {
            QQToast.makeText(this.f66591g.mContext, HardCodeUtil.qqStr(R.string.nyz), 0).show(this.f66591g.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            QLog.e(this.f66594j, 1, "" + num);
            a("onPostExecute(), MediaCodecSendTask error = " + num, null);
        }
        if (!z17) {
            this.f66591g.mContext.finish();
        }
        this.f66591g.mContext = null;
    }

    void h(Intent intent) {
        intent.putExtra(ShortVideoConstants.SV_MEDIACODEC_ENCODE_ENABLE, true);
        intent.putExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR, this.f66586b);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, this.f66591g.mThumbFilePath);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, this.f66591g.mThumbWidth);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, this.f66591g.mThumbHeight);
        intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, this.f66587c);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, this.f66585a);
        intent.putExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, this.f66585a);
        intent.putExtra(ShortVideoConstants.VIDEO_MOOD_CONTENT, this.f66591g.mContent);
        intent.putExtra(ShortVideoConstants.VIDEO_MOOD_PRIV, this.f66591g.mPriv);
        intent.putExtra(ShortVideoConstants.VIDEO_MOOD_PRIVUINLIST, this.f66591g.mPrivUinList);
        intent.putExtra(ShortVideoConstants.ENABLE_EDIT_VIDEO, this.f66591g.mEnableEditVideo);
        intent.putExtra(ShortVideoConstants.VIDEO_TOPIC_ID, this.f66591g.topicId);
        intent.putExtra(ShortVideoConstants.VIDEO_TOPIC_SYNC_QZONE, this.f66591g.topicSyncQzone);
        intent.putExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID, this.f66591g.fakeVid);
        intent.putExtra(ShortVideoConstants.VIDEO_IS_GENERATE_GIF, this.f66591g.generateGif);
        intent.putExtra(ShortVideoConstants.VIDEO_MOOD_TIMER_DELETE, this.f66591g.timerDelete);
        intent.putExtra(ShortVideoConstants.QZONE_VIDEO_TOPIC, this.f66591g.qzoneVerticalVideoTopicInfo);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, this.f66591g.isUploadOrigin);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, this.f66591g.fontId);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, this.f66591g.fontFormatType);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, this.f66591g.fontUrl);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, this.f66591g.superFontId);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO, this.f66591g.superFontInfo);
        intent.putExtra(ShortVideoConstants.SV_ENCODE_MAX_BITRATE, CodecParam.mMaxrate);
        intent.putExtra(ShortVideoConstants.SV_ENCODE_MIN_BITRATE, CodecParam.mMinrate);
        String stringExtra = this.f66591g.mContext.getIntent().getStringExtra(ShortVideoConstants.FORWARD_SOURCE_TO_QZONE);
        if (!TextUtils.isEmpty(stringExtra)) {
            intent.putExtra(ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, stringExtra);
        }
        if (TextUtils.isEmpty(this.f66591g.templateId)) {
            return;
        }
        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, this.f66591g.templateId);
        if (TextUtils.isEmpty(this.f66591g.templateName)) {
            return;
        }
        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, this.f66591g.templateName);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        i(this.f66591g.mContext, R.string.cuv);
    }

    private void i(Context context, int i3) {
        a("showProgressDialog", null);
        try {
            if (this.f66595k != null) {
                b();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context, R.style.qZoneInputDialog);
                this.f66595k = reportProgressDialog;
                reportProgressDialog.setCancelable(true);
                this.f66595k.show();
                this.f66595k.setContentView(R.layout.f168383uh);
                this.f66596l = (TextView) this.f66595k.findViewById(R.id.photo_prievew_progress_dialog_text);
            }
            this.f66596l.setText(i3);
            if (this.f66595k.isShowing()) {
                return;
            }
            this.f66595k.show();
        } catch (Throwable th5) {
            a("showProgressDialog", th5);
        }
    }
}
