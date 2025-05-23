package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.aa;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.l;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SendTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    BaseActivity f186242d;

    /* renamed from: e, reason: collision with root package name */
    Intent f186243e;

    /* renamed from: f, reason: collision with root package name */
    boolean f186244f;

    public SendTask(BaseActivity baseActivity, Intent intent) {
        this.f186242d = baseActivity;
        if (intent != null) {
            this.f186243e = intent;
        } else {
            this.f186243e = baseActivity.getIntent();
        }
        this.f186244f = this.f186243e.getExtras().getBoolean(PeakConstants.SEND_IN_BACKGROUND);
    }

    public static void a(Intent intent) {
        int intExtra = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_MAX_BITRATE, -1);
        if (intExtra > 0) {
            CodecParam.mMaxrate = intExtra;
        }
        int intExtra2 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_MIN_BITRATE, -1);
        if (intExtra2 > 0) {
            CodecParam.mMinrate = intExtra2;
        }
        int intExtra3 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_QMAX, -1);
        if (intExtra3 > 0) {
            CodecParam.mQmax = intExtra3;
        }
        int intExtra4 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_QMIN, -1);
        if (intExtra4 > 0) {
            CodecParam.mQmin = intExtra4;
        }
        int intExtra5 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_QMAXDIFF, -1);
        if (intExtra5 > 0) {
            CodecParam.mMaxQdiff = intExtra5;
        }
        int intExtra6 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_REF_FRAME, -1);
        if (intExtra6 > 0) {
            CodecParam.mRefframe = intExtra6;
        }
        int intExtra7 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_SMOOTH, -1);
        if (intExtra7 > 0) {
            CodecParam.mIsSmooth = intExtra7;
        }
        CodecParam.mEnableTotalTimeAdjust = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_TOTALTIME_ADJ, 0);
        CodecParam.mEnableTimestampFix = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_TIMESTAMP_FIX, 0);
        CodecParam.mAudioTimestampLow = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_LOW, 0);
        CodecParam.mAudioTimestampHigh = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_HIGH, 0);
        CodecParam.mAudioTimeRatio = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_RATIO, 65537);
        CodecParam.setEnableBaseLineMp4Flag(intent.getBooleanExtra(ShortVideoConstants.SV_ENCODE_BASELINE_MP4, false));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "#SendTask# run(): start");
        }
        a(this.f186243e);
        CodecParam.mRecordFrames = this.f186243e.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
        CodecParam.mRecordTime = this.f186243e.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
        String stringExtra = this.f186243e.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
        if (FileUtils.fileExistsAndNotEmpty(stringExtra)) {
            URLDrawable drawable = URLDrawable.getDrawable(new File(stringExtra), URLDrawable.URLDrawableOptions.obtain());
            drawable.downloadImediatly();
            if (drawable.getStatus() == 1) {
                this.f186242d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.SendTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = SendTask.this.f186243e;
                        if (intent != null) {
                            int intExtra = intent.getIntExtra(ShortVideoConstants.FILE_SEND_BUSINESS_TYPE, 2);
                            if (QLog.isColorLevel()) {
                                QLog.d("SendVideoActivity", 2, "#SendTask# run(), busiType = " + intExtra + ",VideoFileDir = " + SendTask.this.f186243e.getStringExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR));
                            }
                            if (SendTask.this.f186243e.getIntExtra("uintype", -1) == 9501) {
                                intExtra = 4;
                            }
                            v b16 = com.tencent.mobileqq.shortvideo.h.b(0, intExtra);
                            aa c16 = l.c(SendTask.this.f186243e, b16);
                            b16.e(c16);
                            xq2.b aioShortVideoSendOperator = ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(SendTask.this.f186242d.app);
                            MessageRecord l3 = aioShortVideoSendOperator.l(c16);
                            if (l3 != null) {
                                QQAppInterface qQAppInterface = SendTask.this.f186242d.app;
                                if (qQAppInterface != null) {
                                    ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(l3.frienduin, l3.uniseq);
                                }
                                aioShortVideoSendOperator.e(l3);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SendVideoActivity", 2, "#SendTask# run(): success");
                            }
                        }
                        SendTask sendTask = SendTask.this;
                        if (!sendTask.f186244f) {
                            sendTask.f186242d.setResult(-1, sendTask.f186243e);
                            SendTask.this.f186242d.finish();
                        }
                    }
                });
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SendVideoActivity", 2, "#SendTask# run(): UrlDrawable status not success, path=" + stringExtra);
            }
            if (!this.f186244f) {
                this.f186242d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.SendTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendTask.this.f186242d.setResult(0);
                        SendTask.this.f186242d.finish();
                    }
                });
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SendVideoActivity", 2, "#SendTask# run(): thumb not exist, path=" + stringExtra);
        }
        if (!this.f186244f) {
            this.f186242d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.SendTask.3
                @Override // java.lang.Runnable
                public void run() {
                    SendTask.this.f186242d.setResult(0);
                    SendTask.this.f186242d.finish();
                }
            });
        }
    }
}
