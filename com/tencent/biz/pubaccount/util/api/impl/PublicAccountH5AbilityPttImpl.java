package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountH5Manager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.c;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PublicAccountH5AbilityPttImpl implements d.a, IPublicAccountH5AbilityPtt {
    private static String fileNameForPtt = "";
    private static int fileSizeForPtt = 0;
    private static double mDuration = 0.0d;
    private static String mLocalPathForPttDownload = "";
    private static String mLocalPathForPttUpload = "";
    private static String md5ForPtt = "";
    private static String serverIdForPtt = "";
    private Handler mHandler;
    VoicePlayer mPlayer;
    private d mQQRecorder;
    WebViewPlugin.b mRuntime;
    private String uin;
    private String TAG = "PublicAccountH5AbilityForPtt";
    private File mFile = null;
    private FileOutputStream outputStream = null;
    private int MAX_TIME = 60000;
    private VoicePlayer.a mListener = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ClickableColorSpanTextView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.ClickableColorSpanTextView.a
        public void a(ClickableColorSpanTextView clickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan) {
            Intent intent = new Intent(PublicAccountH5AbilityPttImpl.this.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", IQQRecorderUtils.ABNORMAL_RECORD_URL);
            PublicAccountH5AbilityPttImpl.this.getContext().startActivity(intent);
        }
    }

    public PublicAccountH5AbilityPttImpl(String str, WebViewPlugin.b bVar) {
        this.mRuntime = bVar;
        this.uin = str;
    }

    private Activity getActivity() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Activity activity = getActivity();
        return activity == null ? MobileQQ.sMobileQQ.getApplicationContext() : activity;
    }

    public static String getFileNameForPtt() {
        return fileNameForPtt;
    }

    public static int getFileSizeForPtt() {
        return fileSizeForPtt;
    }

    public static String getLocalPathForPttDownload() {
        return mLocalPathForPttDownload;
    }

    public static String getLocalPathForPttUpload() {
        return mLocalPathForPttUpload;
    }

    public static String getMd5ForPtt() {
        return md5ForPtt;
    }

    public static String getServerIdForPtt() {
        return serverIdForPtt;
    }

    public static int getTimeForPtt() {
        if (mDuration != 0.0d) {
            return ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).msToSec(mDuration);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAbnormalRecordDlg() {
        DialogUtil.createContentClickableDialog(getContext(), HardCodeUtil.qqStr(R.string.pn_), new SpannableString(getContext().getString(R.string.f8v)), 0, R.string.i5e, null, null, new b()).show();
    }

    public void cancelPttRecorderAndPlayTask() {
        if (isPlaying()) {
            stopVoice();
        }
        stopRecord();
    }

    public void checkFileInfo() {
        try {
            File file = new File(mLocalPathForPttUpload);
            if (file.exists()) {
                md5ForPtt = com.tencent.qqprotect.singleupdate.a.d(file);
                fileSizeForPtt = (int) file.length();
                fileNameForPtt = md5ForPtt;
            }
        } catch (IOException unused) {
        }
    }

    public void closeOutputStream() {
        try {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException unused) {
        }
        this.outputStream = null;
    }

    public String getLocalIdForPTT() {
        String str = mLocalPathForPttUpload.split("/")[r0.length - 1];
        if (str.length() >= 21) {
            return str.substring(0, str.length() - 4);
        }
        return "";
    }

    public String getLocalPathFromIdForPtt(String str) {
        return AppConstants.SDCARD_PATH + IPublicAccountH5Manager.C2B_FIRE_PTT_DIR + str + ".amr";
    }

    public void handleRecorderError(String str, RecordParams.RecorderParam recorderParam) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl.3
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountH5AbilityPttImpl.this.showAbnormalRecordDlg();
            }
        });
    }

    public void handleRecorderStart() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl.2
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(PublicAccountH5AbilityPttImpl.this.getContext(), HardCodeUtil.qqStr(R.string.pnj), 0).show();
            }
        });
    }

    boolean isFolderExists(String str) {
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }

    public boolean isPlaying() {
        VoicePlayer voicePlayer = this.mPlayer;
        return voicePlayer != null && voicePlayer.p() == 2;
    }

    public boolean isRecorderRecording() {
        d dVar = this.mQQRecorder;
        return (dVar == null || dVar.a()) ? false : true;
    }

    public /* bridge */ /* synthetic */ boolean isSupportVoiceTextEdit() {
        return c.a(this);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
        return this.MAX_TIME;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String str, byte[] bArr, int i3, int i16, double d16, RecordParams.RecorderParam recorderParam) {
        try {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.write(bArr, 0, i3);
            }
        } catch (IOException unused) {
        }
    }

    public void pauseVoice() {
        VoicePlayer voicePlayer = this.mPlayer;
        if (voicePlayer == null || voicePlayer.p() != 2) {
            return;
        }
        this.mPlayer.s();
    }

    public void playVoice(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        VoicePlayer voicePlayer = this.mPlayer;
        if (voicePlayer == null || this.mHandler == null || (voicePlayer != null && voicePlayer.p() != 3)) {
            Handler handler = new Handler();
            this.mHandler = handler;
            this.mPlayer = new VoicePlayer(str, handler);
        }
        this.mPlayer.y(getContext());
        this.mPlayer.z();
        this.mPlayer.l(this.mListener);
        if (this.mPlayer.p() == 1) {
            this.mPlayer.A();
        } else if (this.mPlayer.p() == 3) {
            this.mPlayer.u();
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt
    public void setLocalPathForPtt(String str) {
        mLocalPathForPttDownload = str;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt
    public void setServerIdForPtt(String str) {
        serverIdForPtt = str;
    }

    public void startRecord() {
        if (this.mQQRecorder == null) {
            this.mQQRecorder = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(getContext());
        }
        mLocalPathForPttUpload = AppConstants.SDCARD_PATH + IPublicAccountH5Manager.C2B_FIRE_PTT_DIR + FileMsg.getTransFileDateTime() + ".amr";
        QQAudioUtils.i(getContext(), true);
        this.mQQRecorder.b(this);
        this.mQQRecorder.start(mLocalPathForPttUpload);
    }

    public void stopRecord() {
        d dVar = this.mQQRecorder;
        if (dVar != null) {
            dVar.stop();
            this.mQQRecorder = null;
        }
        closeOutputStream();
        QQAudioUtils.i(getContext(), false);
    }

    public void stopVoice() {
        VoicePlayer voicePlayer = this.mPlayer;
        if (voicePlayer != null) {
            voicePlayer.v();
            this.mPlayer = null;
            this.mHandler = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", 0);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.plw) + getLocalIdForPTT() + HardCodeUtil.qqStr(R.string.pnq));
                jSONObject.put("localId", getLocalIdForPTT());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            if (this.mRuntime.e() != null) {
                this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.playEndCallback, jSONObject.toString());
            }
        }
    }

    public void onRecorderNotReady(String str) {
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
    }

    public String getLocalIdForPTTDownLoad(String str) {
        if (str == null) {
            str = mLocalPathForPttDownload;
        }
        String str2 = str.split("/")[r3.length - 1];
        if (str2.length() >= 21) {
            return str2.substring(0, str2.length() - 4);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
        handleRecorderError(str, recorderParam);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", -1);
            jSONObject.put("msg", "onInitFailed");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (this.mRuntime.e() != null) {
            this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, jSONObject.toString());
        }
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
        handleRecorderError(str, recorderParam);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", -1);
            jSONObject.put("msg", "onRecorderAbnormal");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (this.mRuntime.e() != null) {
            this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, jSONObject.toString());
        }
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(String str, RecordParams.RecorderParam recorderParam, double d16) {
        mDuration = d16;
        JSONObject jSONObject = new JSONObject();
        try {
            if (mDuration == this.MAX_TIME) {
                jSONObject.put("retCode", 0);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.pmq));
                jSONObject.put("localId", getLocalIdForPTT());
                if (this.mRuntime.e() != null) {
                    this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.voiceRecorderEndCallback, jSONObject.toString());
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2B", "0X8005D2B", 0, 0, "1", "", "", "");
                return;
            }
            if (this.mFile.exists()) {
                jSONObject.put("retCode", 0);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.plt) + getLocalIdForPTT());
                jSONObject.put("localId", getLocalIdForPTT());
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2A", "0X8005D2A", 0, 0, "1", "", "", "");
            } else {
                jSONObject.put("retCode", -1);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.pnf));
                jSONObject.put("localId", getLocalIdForPTT());
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2A", "0X8005D2A", 0, -1, "1", "", "", "");
            }
            if (this.mRuntime.e() != null) {
                this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.recordStopCallback, jSONObject.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", -1);
            jSONObject.put("msg", "onRecorderError");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (this.mRuntime.e() != null) {
            this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, jSONObject.toString());
        }
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam) {
        if (isFolderExists(AppConstants.SDCARD_PATH + IPublicAccountH5Manager.C2B_FIRE_PTT_DIR)) {
            File file = new File(str);
            this.mFile = file;
            if (file.exists()) {
                this.mFile.delete();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mFile);
                this.outputStream = fileOutputStream;
                fileOutputStream.write("#!AMR\n".getBytes());
                return;
            } catch (FileNotFoundException e16) {
                this.outputStream = null;
                e16.printStackTrace();
                return;
            } catch (IOException unused) {
                this.outputStream = null;
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", -1);
            jSONObject.put("msg", "no sdCard");
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        if (this.mRuntime.e() != null) {
            this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, jSONObject.toString());
        }
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", 0);
            jSONObject.put("msg", "startRecord");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (this.mRuntime.e() != null) {
            this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, jSONObject.toString());
        }
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D29", "0X8005D29", 0, 0, "1", "", "", "");
        handleRecorderStart();
        return 0;
    }

    /* loaded from: classes32.dex */
    class a implements VoicePlayer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void u4(int i3, String str, int i16) {
            JSONObject jSONObject = new JSONObject();
            if (i3 == 8) {
                try {
                    jSONObject.put("retCode", -1);
                    jSONObject.put("msg", "fail");
                    jSONObject.put("localId", PublicAccountH5AbilityPttImpl.this.getLocalIdForPTT());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            } else if (i3 == 4) {
                try {
                    jSONObject.put("retCode", 0);
                    jSONObject.put("msg", HardCodeUtil.qqStr(R.string.pmn) + PublicAccountH5AbilityPttImpl.this.getLocalIdForPTT() + HardCodeUtil.qqStr(R.string.pmh));
                    jSONObject.put("localId", PublicAccountH5AbilityPttImpl.this.getLocalIdForPTT());
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
            if (PublicAccountH5AbilityPttImpl.this.mRuntime.e() != null) {
                PublicAccountH5AbilityPttImpl.this.mRuntime.e().callJs(PublicAccountH5AbilityPluginImpl.voicePlayEndCallback, jSONObject.toString());
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2F", "0X8005D2F", 0, 0, "1", "", "", "");
            VoicePlayer voicePlayer = PublicAccountH5AbilityPttImpl.this.mPlayer;
            if (voicePlayer != null) {
                voicePlayer.v();
            }
            PublicAccountH5AbilityPttImpl.this.mPlayer = null;
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void c5(String str, int i3, int i16) {
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void ic(String str, int i3, int i16) {
        }
    }

    public PublicAccountH5AbilityPttImpl() {
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int i3) {
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
    }
}
