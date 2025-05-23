package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f288244a;

    /* renamed from: b, reason: collision with root package name */
    private String f288245b;

    /* renamed from: c, reason: collision with root package name */
    private FileOutputStream f288246c;

    public a(String str) throws RuntimeException {
        this.f288244a = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f288244a);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("audio_data_cache");
        sb5.append(str2);
        this.f288244a = sb5.toString();
        File file = new File(this.f288244a);
        boolean mkdirs = file.mkdirs();
        boolean isDirectory = file.isDirectory();
        if (!mkdirs && !isDirectory) {
            throw new RuntimeException("AudioDataCache: mkd=" + mkdirs + " isdir=" + isDirectory);
        }
    }

    private static void a(String str, Throwable th5) {
        if (QLog.isColorLevel()) {
            if (th5 != null) {
                QLog.d("AudioDataCache", 2, "[@] " + str, th5);
                return;
            }
            QLog.d("AudioDataCache", 2, "[@] " + str);
        }
    }

    public String b(RMVideoStateMgr rMVideoStateMgr) {
        a("closeCache: path=" + this.f288245b, null);
        String str = this.f288244a + this.f288245b;
        if (this.f288246c != null) {
            if (rMVideoStateMgr != null) {
                try {
                    rMVideoStateMgr.r();
                } catch (IOException unused) {
                }
            }
            this.f288246c.close();
        }
        this.f288246c = null;
        this.f288245b = null;
        return str;
    }

    public void c(RMVideoStateMgr rMVideoStateMgr) {
        a("initCache: oldpath=" + this.f288245b + " mOutStream=" + this.f288246c, null);
        b(rMVideoStateMgr);
        this.f288245b = VidUtil.generateVid();
        String str = this.f288244a + this.f288245b;
        File file = new File(str);
        if (!file.exists()) {
            try {
                this.f288246c = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                this.f288246c = null;
            }
            a("initCache: newPath=" + this.f288245b, null);
            return;
        }
        throw new RuntimeException("AudioDataCache: file exists| " + str);
    }

    public boolean d(byte[] bArr, int i3, int i16) {
        FileOutputStream fileOutputStream = this.f288246c;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(bArr, i3, i16);
                return true;
            } catch (IOException e16) {
                e16.printStackTrace();
                a("writeData: exp=", e16);
            }
        }
        return false;
    }
}
