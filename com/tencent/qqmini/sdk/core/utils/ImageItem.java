package com.tencent.qqmini.sdk.core.utils;

import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ImageItem {

    /* renamed from: a, reason: collision with root package name */
    public String f348072a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f348073b;

    /* renamed from: c, reason: collision with root package name */
    private PipedInputStream f348074c;

    /* renamed from: d, reason: collision with root package name */
    private PipedOutputStream f348075d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f348076e;

    public ImageItem(String str, byte[] bArr) {
        this.f348072a = str;
        this.f348073b = bArr;
        this.f348076e = -1;
    }

    public byte[] d() {
        if (this.f348076e != -1 && this.f348076e != 2) {
            return null;
        }
        return this.f348073b;
    }

    public InputStream e() {
        if (this.f348076e != -1 && this.f348076e != 2) {
            if (this.f348076e != 0 && this.f348076e != 1) {
                return null;
            }
            return this.f348074c;
        }
        try {
            this.f348074c.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new ByteArrayInputStream(this.f348073b);
    }

    public ImageItem(String str, final InputStream inputStream) {
        this.f348072a = str;
        this.f348076e = 0;
        if (inputStream == null) {
            this.f348076e = 3;
            return;
        }
        try {
            this.f348074c = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            this.f348075d = pipedOutputStream;
            pipedOutputStream.connect(this.f348074c);
            ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.core.utils.ImageItem.1
                @Override // java.lang.Runnable
                public void run() {
                    InputStream inputStream2;
                    try {
                        try {
                            try {
                                ImageItem.this.f348076e = 1;
                                byte[] bArr = new byte[1024];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    ImageItem.this.f348075d.write(bArr, 0, read);
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                ImageItem.this.f348075d.close();
                                ImageItem.this.f348073b = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                ImageItem.this.f348076e = 2;
                                inputStream2 = inputStream;
                            } catch (Exception e16) {
                                ImageItem.this.f348076e = 3;
                                QMLog.i("ImgItem", "transfer error", e16);
                                InputStream inputStream3 = inputStream;
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                } else {
                                    return;
                                }
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                        } catch (Throwable th5) {
                            InputStream inputStream4 = inputStream;
                            if (inputStream4 != null) {
                                try {
                                    inputStream4.close();
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th5;
                        }
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                }
            });
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f348076e = 3;
            QMLog.i("ImgItem", "init error", e16);
        }
    }
}
