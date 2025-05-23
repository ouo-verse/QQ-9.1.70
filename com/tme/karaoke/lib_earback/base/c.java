package com.tme.karaoke.lib_earback.base;

import android.content.SharedPreferences;
import android.media.AudioDeviceInfo;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import com.tencent.component.utils.LogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import com.tme.karaoke.lib_earback.EarBackModule;
import com.tme.karaoke.lib_earback.EarBackScene;
import com.tme.karaoke.lib_earback.EarBackType;
import com.tme.karaoke.lib_earback.EarBackUserWill;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u0006\u0010\u0007\u001a\u00020\u0004\u001a\u0006\u0010\b\u001a\u00020\u0004\u001a\u0006\u0010\t\u001a\u00020\u0004\u001a\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b\u001a\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u0006\u0010\u000f\u001a\u00020\u0004\u001a\n\u0010\u0011\u001a\u00020\u0000*\u00020\u0010\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0012\u001a\n\u0010\u0015\u001a\u00020\u0002*\u00020\u0014\u001a\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a\u001a\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a\u00a8\u0006\u001e"}, d2 = {"", "info", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "i", "b", "c", "d", "on", "Lcom/tme/karaoke/lib_earback/EarBackScene;", "scene", "p", "g", h.F, "", "a", "Landroid/media/AudioRecordingConfiguration;", "l", "Landroid/media/AudioDeviceInfo;", "k", "Lcom/tme/karaoke/lib_earback/EarBackUserWill;", "userWill", DomainData.DOMAIN_NAME, "e", "Lcom/tme/karaoke/lib_earback/EarBackType;", "type", "f", "o", "lib_earback_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class c {
    @NotNull
    public static final String a(int i3) {
        switch (i3) {
            case 1:
                return MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC;
            case 2:
                return "voice_uplink";
            case 3:
                return "voice_downlink";
            case 4:
                return "voice_call";
            case 5:
                return MiniGameLameMp3EncodeThread.AUDIO_SOURCE_CAMCORDER;
            case 6:
                return MiniGameLameMp3EncodeThread.AUDIO_SOURCE_VOICE_RECOGNITION;
            case 7:
                return "voice_commenication";
            case 8:
            default:
                return "unkonwcode = " + i3;
            case 9:
                return "unprocessed";
        }
    }

    public static final boolean b() {
        if (EarBackModule.R.j().getEarBackType() != EarBackType.None) {
            return true;
        }
        return false;
    }

    public static final boolean c() {
        return EarBackModule.R.j().getAudioDeviceInfo().getIsBlueToothSupport();
    }

    public static final boolean d() {
        return EarBackModule.R.j().getAudioDeviceInfo().getIsFullBand();
    }

    public static final void e(@NotNull EarBackUserWill userWill) {
        Intrinsics.checkParameterIsNotNull(userWill, "userWill");
        n(userWill);
        EarBackModule.R.j().k(userWill);
    }

    public static final boolean f(@NotNull EarBackType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (type != EarBackType.HuaweiAudioKitEarBackType) {
            return true;
        }
        SharedPreferences l3 = EarBackModule.R.l();
        if (l3 != null && l3.getBoolean("earback_userwill_huaweiaudiokit_key", false)) {
            return true;
        }
        return false;
    }

    public static final boolean g() {
        if (b() && EarBackModule.R.j().getEarBackIsCanControlInApp()) {
            return true;
        }
        return false;
    }

    public static final boolean h() {
        if (EarBackModule.R.j().getEarBackUserWill() == EarBackUserWill.On) {
            return true;
        }
        return false;
    }

    public static final boolean i() {
        if (EarBackModule.R.j().getEarBackType() == EarBackType.HuaweiAPIAbove26VersionSystemEarBackType) {
            return true;
        }
        return false;
    }

    public static final boolean j() {
        if (EarBackModule.R.j().getEarBackType() == EarBackType.HuaweiAudioKitEarBackType) {
            return true;
        }
        return false;
    }

    public static final void k(@NotNull AudioDeviceInfo printHumanDeviceInfo) {
        Intrinsics.checkParameterIsNotNull(printHumanDeviceInfo, "$this$printHumanDeviceInfo");
        m("type=" + printHumanDeviceInfo.getType() + ",id=" + printHumanDeviceInfo.getId() + ",productName=" + printHumanDeviceInfo.getProductName());
    }

    public static final void l(@NotNull AudioRecordingConfiguration printLogFriendlyInfo) {
        int clientAudioSource;
        int clientAudioSessionId;
        Intrinsics.checkParameterIsNotNull(printLogFriendlyInfo, "$this$printLogFriendlyInfo");
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getClientAudioSource = ");
            clientAudioSource = printLogFriendlyInfo.getClientAudioSource();
            sb5.append(a(clientAudioSource));
            sb5.append(",getClientAudioSessionId = ");
            clientAudioSessionId = printLogFriendlyInfo.getClientAudioSessionId();
            sb5.append(clientAudioSessionId);
            m(sb5.toString());
        }
    }

    public static final void m(@NotNull String info) {
        Intrinsics.checkParameterIsNotNull(info, "info");
        LogUtil.i("EarBackModule", info);
    }

    public static final void n(@NotNull EarBackUserWill userWill) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(userWill, "userWill");
        SharedPreferences l3 = EarBackModule.R.l();
        if (l3 != null) {
            SharedPreferences.Editor edit = l3.edit();
            if (userWill == EarBackUserWill.On) {
                z16 = true;
            } else {
                z16 = false;
            }
            edit.putBoolean("earback_userwill_key", z16).apply();
            return;
        }
        m("mSharePerference == null");
    }

    public static final void o(@NotNull EarBackType type) {
        SharedPreferences l3;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (type == EarBackType.HuaweiAudioKitEarBackType && (l3 = EarBackModule.R.l()) != null && (edit = l3.edit()) != null && (putBoolean = edit.putBoolean("earback_userwill_huaweiaudiokit_key", true)) != null) {
            putBoolean.apply();
        }
    }

    public static final boolean p(boolean z16, @NotNull EarBackScene scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        return EarBackModule.R.a(z16, scene);
    }
}
