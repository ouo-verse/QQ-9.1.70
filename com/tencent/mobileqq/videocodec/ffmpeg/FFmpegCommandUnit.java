package com.tencent.mobileqq.videocodec.ffmpeg;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FFmpegCommandUnit {
    static IPatchRedirector $redirector_ = null;
    public static final int CMDTYPE_CHANGE_ORIENTATION = 12;
    public static final int CMDTYPE_CLIP_AUDIO = 3;
    public static final int CMDTYPE_COMBINE_DOODLE = 15;
    public static final int CMDTYPE_COMBINE_VIDEO_AUDIO = 4;
    public static final int CMDTYPE_COMPRESS_VIDEO = 11;
    public static final int CMDTYPE_CONCAT_DIFF_VIDEO = 8;
    public static final int CMDTYPE_CONCAT_TS = 6;
    public static final int CMDTYPE_CONCAT_VIDEO = 2;
    public static final int CMDTYPE_CONCAT_VIDEO_BY_TS = 7;
    public static final int CMDTYPE_CONVERT_PIC_TO_VIDEO = 9;
    public static final int CMDTYPE_CONVERT_PIC_TO_VIDEO_WITH_DURATION = 20;
    public static final int CMDTYPE_DETECT_INFO_VOLUME = 22;
    public static final int CMDTYPE_EMPTY = 14;
    public static final int CMDTYPE_HFLIP_VIDEO = 10;
    public static final int CMDTYPE_MP4_TO_TS = 5;
    public static final int CMDTYPE_SET_TIMESTAMP = 13;
    public static final int CMDTYPE_TRANSCODE_AUDIO = 21;
    public static final int CMDTYPE_WARTERMARK = 1;
    public static final int CMPTYPE_GET_AUDIO_FROM_MP4 = 18;
    public static final int CMPTYPE_GET_VIDEO_FROM_MP4 = 19;
    public static final int CMPTYPE_MIX_AUDIO = 17;
    public static final int CMPTYPE_MP4_TO_MP3 = 16;
    public ArrayList<Object> arguments;
    public FFmpegExecuteResponseCallback callback;
    public String[] cmd;
    public int cmdType;
    public String output;

    public FFmpegCommandUnit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String toString() {
        String join;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String[] strArr = this.cmd;
        String str = "null";
        if (strArr == null) {
            join = "null";
        } else {
            join = TextUtils.join(" ", strArr);
        }
        ArrayList<Object> arrayList = this.arguments;
        if (arrayList != null) {
            str = TextUtils.join(",", arrayList.toArray());
        }
        return "FFmpegCommandUnit{ cmdType :" + this.cmdType + "\n cmd: " + join + "\n output: " + this.output + "\n arguments: " + str;
    }

    public FFmpegCommandUnit(String[] strArr, String str, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, strArr, str, fFmpegExecuteResponseCallback);
            return;
        }
        this.output = str;
        this.cmd = strArr;
        this.callback = fFmpegExecuteResponseCallback;
    }
}
