package com.tencent.mobileqq.vas.vipav.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.g;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipFunCallUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements MediaPlayer.OnPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f311249d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VipFunCallMediaListener f311250e;

        b(boolean z16, VipFunCallMediaListener vipFunCallMediaListener) {
            this.f311249d = z16;
            this.f311250e = vipFunCallMediaListener;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            QLog.e(VipFunCallConstants.TAG, 1, "onPrepared isAllowNotify: " + this.f311249d);
            if (this.f311249d) {
                mediaPlayer.setVolume(1.0f, 1.0f);
            } else {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
            VipFunCallMediaListener vipFunCallMediaListener = this.f311250e;
            if (vipFunCallMediaListener != null) {
                vipFunCallMediaListener.onMediaPrepare();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements MediaPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoView f311251d;

        c(VideoView videoView) {
            this.f311251d = videoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f311251d.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements MediaPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f311252d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VipFunCallMediaListener f311253e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ VideoView f311254f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f311255h;

        d(int i3, VipFunCallMediaListener vipFunCallMediaListener, VideoView videoView, boolean z16) {
            this.f311252d = i3;
            this.f311253e = vipFunCallMediaListener;
            this.f311254f = videoView;
            this.f311255h = z16;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            VideoView videoView;
            VasNtCommonReporter.getFunCall().setValue1("videoPlayingOnError").setNum1(this.f311252d).setNum2(i3).setNum3(i16).report(false);
            if (QLog.isColorLevel()) {
                QLog.d(VipFunCallConstants.TAG, 2, "playing onError what=" + i3 + ", extra=" + i16 + ", funcallid=" + this.f311252d);
            }
            VipFunCallMediaListener vipFunCallMediaListener = this.f311253e;
            if (vipFunCallMediaListener != null) {
                vipFunCallMediaListener.onError(i3, i16, this.f311252d);
            }
            BitmapDrawable bitmapDrawable = null;
            String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(null, this.f311252d, 7, null);
            if (!TextUtils.isEmpty(resourcePathByUrl) && new File(resourcePathByUrl).exists()) {
                Bitmap c16 = j.c(resourcePathByUrl);
                if (c16 != null) {
                    bitmapDrawable = new BitmapDrawable(c16);
                }
                if (bitmapDrawable != null && (videoView = this.f311254f) != null) {
                    if (this.f311255h) {
                        videoView.setBackgroundDrawable(bitmapDrawable);
                    } else {
                        videoView.setVisibility(8);
                        RelativeLayout relativeLayout = (RelativeLayout) this.f311254f.getParent();
                        if (relativeLayout != null) {
                            relativeLayout.setBackgroundDrawable(bitmapDrawable);
                        }
                    }
                }
            }
            return true;
        }
    }

    public static String getFunCallName(AppRuntime appRuntime, int i3) {
        if (i3 > 0) {
            return getFunCallSP(appRuntime, 0, String.valueOf(i3)).getString("name", "");
        }
        return "\u9ed8\u8ba4\u6765\u7535";
    }

    public static String getFunCallPath() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "funcall" + File.separator);
    }

    public static SharedPreferences getFunCallSP(AppRuntime appRuntime, int i3, String str) {
        String str2;
        if (appRuntime == null) {
            appRuntime = VasUtil.getApp();
        }
        if (appRuntime == null) {
            QLog.e(VipFunCallConstants.TAG, 1, "getFunCallUinSP app == null");
            return null;
        }
        if (1 == i3) {
            str2 = "fun_call_uinSp_" + appRuntime.getAccount();
        } else {
            str2 = "fun_call_appSp";
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + "_" + str;
        }
        return VasMMKV.getFunCall(appRuntime.getApplication(), str2);
    }

    private static int getIdToInteger(int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e16) {
                QLog.e(VipFunCallConstants.TAG, 1, "getResIdByUin err:" + e16.getMessage());
                return i3;
            }
        }
        return i3;
    }

    private static int getIdWithCall(AppRuntime appRuntime, int i3, boolean z16, String str, int i16, SharedPreferences sharedPreferences) {
        if (!z16 && !TextUtils.isEmpty(str)) {
            String str2 = null;
            String string = sharedPreferences.getString(VipFunCallConstants.KEY_GROUP, null);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                int i17 = 0;
                while (true) {
                    if (i17 >= split.length) {
                        break;
                    }
                    String string2 = sharedPreferences.getString(VipFunCallConstants.KEY_GROUP_ONE + split[i17], null);
                    if (!TextUtils.isEmpty(string2)) {
                        if (string2.indexOf("-" + str + "-") > 0) {
                            String[] split2 = string2.split(",");
                            if (split2.length >= 3) {
                                str2 = 3 == i3 ? split2[1] : split2[0];
                            }
                        }
                    }
                    i17++;
                }
            }
            int idToInteger = getIdToInteger(i16, str2);
            if (idToInteger == 0) {
                return sharedPreferences.getInt(appRuntime.getAccount() + "callId" + i3, 0);
            }
            return idToInteger;
        }
        return i16;
    }

    public static String getKuiklySchema() {
        return ar.b("ketchwang", "2024-08-13", "vas_kuikly_funcall_config").getStringData("");
    }

    public static int getLastFunCallID(AppRuntime appRuntime) {
        SharedPreferences funCallSP = getFunCallSP(appRuntime, 1, null);
        int i3 = funCallSP.getInt(VipFunCallConstants.LAST_FUN_CALL_PLAY_ID, 0);
        funCallSP.edit().remove(VipFunCallConstants.LAST_FUN_CALL_PLAY_ID).commit();
        return i3;
    }

    public static int getResIdByUin(AppRuntime appRuntime, String str, int i3, boolean z16, String str2) {
        if (appRuntime == null) {
            appRuntime = VasUtil.getApp();
        }
        AppRuntime appRuntime2 = appRuntime;
        if (appRuntime2 == null) {
            QLog.e(VipFunCallConstants.TAG, 1, "getResIdByUin null == app");
            return 0;
        }
        SharedPreferences funCallSP = getFunCallSP(appRuntime2, 1, null);
        if (funCallSP == null) {
            QLog.e(VipFunCallConstants.TAG, 1, "getResIdByUin null == sp");
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            if (z16) {
                str = appRuntime2.getAccount();
            } else {
                QLog.e(VipFunCallConstants.TAG, 1, "getResIdByUin null == uin, isICall = false");
            }
        }
        return getIdWithCall(appRuntime2, i3, z16, str2, funCallSP.getInt(str + "callId" + i3, 0), funCallSP);
    }

    public static String getResourcePathByUrl(AppRuntime appRuntime, int i3, int i16, String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResourceUrlOrValue(appRuntime, i3, i16, null);
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isDebugVersion()) {
                QLog.e(VipFunCallConstants.TAG, 1, "getResourcePathByUrl, url=null , id=" + i3 + ", type=" + i16);
            }
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        return (getFunCallPath() + i3 + File.separator) + substring;
    }

    public static int getResourceType() {
        if (QLog.isColorLevel() && QLog.isDebugVersion()) {
            QLog.d(VipFunCallConstants.TAG, 2, "Build.MODEL=[" + DeviceInfoMonitor.getModel() + "],android.os.Build.VERSION.SDK_INT=[" + Build.VERSION.SDK_INT + "]");
        }
        if (VipFunCallConstants.mResType < 0) {
            try {
                String[] split = "R8007,SCH-I869,K-Touch E780,HUAWEI C8812E,AMOI N828,7,8,9,10,11,12,13,HUAWEI Y320-T00,gt-s7568i".split(",");
                for (int i3 = 0; i3 < split.length; i3++) {
                    String str = split[i3];
                    if (str != null) {
                        if (str.equalsIgnoreCase(Build.VERSION.SDK_INT + "") || split[i3].equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                            VipFunCallConstants.mResType = 7;
                        }
                    }
                }
            } catch (Exception unused) {
                QLog.e(VipFunCallConstants.TAG, 1, "Build.MODEL=[" + DeviceInfoMonitor.getModel() + "],android.os.Build.VERSION.SDK_INT=[" + Build.VERSION.SDK_INT + "]");
            }
        }
        if (VipFunCallConstants.mResType < 0) {
            VipFunCallConstants.mResType = 6;
        }
        return VipFunCallConstants.mResType;
    }

    public static String getResourceUrlOrValue(AppRuntime appRuntime, int i3, int i16, String str) {
        SharedPreferences funCallSP = getFunCallSP(appRuntime, 0, String.valueOf(i3));
        String str2 = null;
        if (funCallSP != null) {
            if (i16 > -1) {
                str2 = funCallSP.getString("_" + i16, null);
            } else if (!TextUtils.isEmpty(str)) {
                str2 = funCallSP.getString(str, null);
            }
        }
        if (TextUtils.isEmpty(str2) && QLog.isDebugVersion()) {
            QLog.e(VipFunCallConstants.TAG, 1, "getResourceUrl, url=null , id=" + i3 + ", type=" + i16);
        }
        return str2;
    }

    public static boolean ifUseKuikly() {
        UnitedProxy b16 = ar.b("ketchwang", "2024-08-13", "vas_kuikly_funcall_config");
        String stringData = b16.getStringData("");
        if (!b16.isEnable(false)) {
            QLog.i(VipFunCallConstants.TAG, 1, "kuikly FunCall not enable");
            return false;
        }
        if (stringData.isEmpty()) {
            QLog.i(VipFunCallConstants.TAG, 1, "kuikly FunCall not enable, scheme is empty");
            return false;
        }
        QLog.i(VipFunCallConstants.TAG, 1, "kuikly FunCall enabled");
        return true;
    }

    @SuppressLint({"WrongConstant"})
    public static boolean isExternalStorageReady(Context context, String str, boolean z16) {
        Context context2;
        boolean z17;
        int i3;
        boolean z18;
        long currentTimeMillis = System.currentTimeMillis();
        boolean B = Utils.B();
        if (B && context == null) {
            try {
                context2 = VasUtil.getApp().getApplicationContext();
            } catch (Exception e16) {
                e = e16;
                QLog.e(VipFunCallConstants.TAG, 1, "isExternalStorageReady have sdCARD:" + B + ", from:" + str + ", lonth=" + (System.currentTimeMillis() - currentTimeMillis) + ", msg=" + e.getMessage());
                return B;
            }
        } else {
            context2 = context;
        }
        if (B && context2 != null) {
            int checkPermission = context2.checkPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, Process.myPid(), Process.myUid());
            if (checkPermission == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            i3 = checkPermission;
            z17 = z18;
        } else {
            z17 = B;
            i3 = -10;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isColorLevel() || !z17 || z16) {
                QLog.d(VipFunCallConstants.TAG, 1, "isExternalStorageReady have sdCARD:" + z17 + ", from:" + str + ", showLog:" + z16 + ", type=" + i3 + ", lonth=" + currentTimeMillis2);
            }
            ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).vipFuncallReport(str, z17, i3, currentTimeMillis2);
            return z17;
        } catch (Exception e17) {
            e = e17;
            B = z17;
            QLog.e(VipFunCallConstants.TAG, 1, "isExternalStorageReady have sdCARD:" + B + ", from:" + str + ", lonth=" + (System.currentTimeMillis() - currentTimeMillis) + ", msg=" + e.getMessage());
            return B;
        }
    }

    public static boolean isNetworkAllowDowanload() {
        int systemNetwork = NetworkUtil.getSystemNetwork(null);
        if (1 == systemNetwork || 4 == systemNetwork) {
            return true;
        }
        return false;
    }

    public static int needToShowTip(AppRuntime appRuntime, String str, String str2) {
        int i3 = getFunCallSP(appRuntime, 1, null).getInt("uin_fun_call_id_change_" + str + "_" + str2, 2);
        if (i3 != 0) {
            setNeedToShowTip(appRuntime, str, 0, str2, 0);
        }
        return i3;
    }

    public static boolean play(Context context, VideoView videoView, String str, int i3, VipFunCallMediaListener vipFunCallMediaListener, int i16, boolean z16, boolean z17) {
        if (context != null && videoView != null && str != null) {
            File file = new File(str);
            if (file.exists() && !videoView.isPlaying()) {
                if (QLog.isColorLevel()) {
                    QLog.d(VipFunCallConstants.TAG, 2, "playing[" + i16 + "]");
                }
                if (i3 == 6) {
                    VasNtCommonReporter.getFunCall().setValue1("tryPlayVideo").setNum1(i16).report();
                    return playVideo(videoView, vipFunCallMediaListener, i16, z16, file, z17);
                }
                if (i3 == 7 && playPicture(videoView, str, vipFunCallMediaListener)) {
                    VasNtCommonReporter.getFunCall().setValue1("playPic").setNum1(i16).report();
                    return true;
                }
            }
            VasNtCommonReporter.getFunCall().setValue1("videoPlayingOrNotExist").setValue2(str).setNum1(i16).report(false);
            return false;
        }
        VasNtCommonReporter.getFunCall().setValue1("playResourceNull").setValue2(str).setNum1(i16).report(false);
        return false;
    }

    private static boolean playPicture(VideoView videoView, String str, VipFunCallMediaListener vipFunCallMediaListener) {
        BitmapDrawable bitmapDrawable;
        RelativeLayout relativeLayout;
        Bitmap c16 = j.c(str);
        if (c16 != null) {
            bitmapDrawable = new BitmapDrawable(c16);
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null && (relativeLayout = (RelativeLayout) videoView.getParent()) != null) {
            if (vipFunCallMediaListener != null) {
                vipFunCallMediaListener.onMediaPrepare();
            }
            relativeLayout.setBackgroundDrawable(bitmapDrawable);
            return true;
        }
        return false;
    }

    private static boolean playVideo(VideoView videoView, VipFunCallMediaListener vipFunCallMediaListener, int i3, boolean z16, File file, boolean z17) {
        videoView.setOnTouchListener(new a());
        videoView.setVideoPath(file.getAbsolutePath());
        videoView.requestFocus();
        videoView.setVisibility(0);
        videoView.setOnPreparedListener(new b(z17, vipFunCallMediaListener));
        videoView.setOnCompletionListener(new c(videoView));
        videoView.setOnErrorListener(new d(i3, vipFunCallMediaListener, videoView, z16));
        return true;
    }

    public static void setLastFunCallID(AppRuntime appRuntime, int i3) {
        getFunCallSP(appRuntime, 1, null).edit().putInt(VipFunCallConstants.LAST_FUN_CALL_PLAY_ID, i3).commit();
    }

    public static void setNeedToShowTip(AppRuntime appRuntime, String str, int i3, String str2, int i16) {
        getFunCallSP(appRuntime, 1, null).edit().putInt("uin_fun_call_id_change_" + str + "_" + str2, i3).commit();
        if (i16 == 0) {
            return;
        }
        String resourcePathByUrl = getResourcePathByUrl(appRuntime, i16, 8, null);
        File file = new File(resourcePathByUrl);
        if (!FileUtils.fileExists(resourcePathByUrl)) {
            ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).startDownload(appRuntime, new Bundle(), new g(getResourceUrlOrValue(appRuntime, i16, 8, null), file), null);
        }
    }
}
