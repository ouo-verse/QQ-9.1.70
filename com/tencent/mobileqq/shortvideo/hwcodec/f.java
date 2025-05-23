package com.tencent.mobileqq.shortvideo.hwcodec;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f288026a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f288027b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f288028c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f288029d = 0;

    public int a(String str, int i3, int i16, double d16, double d17, String str2) {
        String b16 = RecordThumbnailUtils.b(str, i3, i16, str2, 0, Bitmap.Config.RGB_565);
        if (TextUtils.isEmpty(b16)) {
            if (QLog.isColorLevel()) {
                QLog.e("SVHwThumbGen", 2, "genThumbFile(), mThumbFilePath is empty");
            }
            return -2;
        }
        File file = new File(b16);
        if (!file.exists()) {
            return -2;
        }
        BaseImageUtil.updateLBSExif(b16, d16, d17);
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(b16);
                try {
                    this.f288026a = HexUtil.bytes2HexStr(MD5.toMD5Byte(fileInputStream2, file.length()));
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    if (TextUtils.isEmpty(this.f288026a)) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SVHwThumbGen", 2, "doInBackground(), mThumbMd5 is empty");
                        }
                        return -1;
                    }
                    return 0;
                } catch (FileNotFoundException e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(this.f288026a)) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SVHwThumbGen", 2, "doInBackground(), mThumbMd5 is empty");
                        }
                        return -1;
                    }
                    return 0;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(this.f288026a)) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SVHwThumbGen", 2, "doInBackground(), mThumbMd5 is empty");
                        }
                        return -1;
                    }
                    throw th;
                }
            } catch (FileNotFoundException e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
