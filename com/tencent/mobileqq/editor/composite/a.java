package com.tencent.mobileqq.editor.composite;

import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import hd0.c;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ".temp.mp4";
        c.a("VideoCompositeUtil", "reEncodeVideoWithFFmpeg start!");
        int i3 = 0;
        int ffmpegReCodec = HwVideoMerge.ffmpegReCodec(str, str2, 0);
        if (ffmpegReCodec != 0) {
            QLog.e("VideoCompositeUtil", 2, "[NewVersion]HwVideoMerge->merge: errcode=" + ffmpegReCodec);
            i3 = ffmpegReCodec;
        } else {
            FileUtils.deleteFile(str);
            FileUtils.rename(str2, str);
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoCompositeUtil", 2, "reEncodeVideoWithFFmpeg cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return i3;
    }
}
