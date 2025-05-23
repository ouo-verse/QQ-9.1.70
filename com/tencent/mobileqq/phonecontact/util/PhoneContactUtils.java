package com.tencent.mobileqq.phonecontact.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class PhoneContactUtils {
    static IPatchRedirector $redirector_;

    public static String a(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0) {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            byte[] c16 = c(bArr);
            byte[] c17 = c(bytes);
            for (int i3 = 0; i3 < length; i3++) {
                c16[i3] = (byte) (c17[i3] ^ c16[i3]);
            }
            int length2 = c16.length - 1;
            int i16 = length2;
            while (true) {
                if (i16 >= 0) {
                    if (c16[i16] != 0) {
                        break;
                    }
                    i16--;
                } else {
                    i16 = 0;
                    break;
                }
            }
            if (i16 != length2) {
                int i17 = i16 + 1;
                byte[] bArr2 = new byte[i17];
                System.arraycopy(c16, 0, bArr2, 0, i17);
                c16 = bArr2;
            }
            return new String(c(c16));
        }
        return str;
    }

    public static void b(AppInterface appInterface, Resources resources, ImageView imageView) {
        if (appInterface != null && resources != null && imageView != null) {
            ThreadManagerV2.excute(new Runnable(resources, appInterface, imageView) { // from class: com.tencent.mobileqq.phonecontact.util.PhoneContactUtils.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Resources f258497d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AppInterface f258498e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ ImageView f258499f;

                {
                    this.f258497d = resources;
                    this.f258498e = appInterface;
                    this.f258499f = imageView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, resources, appInterface, imageView);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Bitmap bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        bitmap = BitmapFactory.decodeResource(this.f258497d, R.drawable.f161728eq3);
                    } catch (OutOfMemoryError e16) {
                        e16.printStackTrace();
                        QLog.i("IMCore.PhoneContact.PhoneContactUtils", 1, "OutOfMemoryError", e16);
                        bitmap = null;
                        if (QLog.isColorLevel()) {
                        }
                        this.f258498e.runOnUiThread(new Runnable(bitmap) { // from class: com.tencent.mobileqq.phonecontact.util.PhoneContactUtils.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Bitmap f258500d;

                            {
                                this.f258500d = bitmap;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bitmap);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Bitmap bitmap2 = this.f258500d;
                                if (bitmap2 != null) {
                                    AnonymousClass1.this.f258499f.setImageBitmap(bitmap2);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, "loadIconAsync end");
                                }
                            }
                        });
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        QLog.i("IMCore.PhoneContact.PhoneContactUtils", 1, "Throwable", th5);
                        bitmap = null;
                        if (QLog.isColorLevel()) {
                        }
                        this.f258498e.runOnUiThread(new Runnable(bitmap) { // from class: com.tencent.mobileqq.phonecontact.util.PhoneContactUtils.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Bitmap f258500d;

                            {
                                this.f258500d = bitmap;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bitmap);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Bitmap bitmap2 = this.f258500d;
                                if (bitmap2 != null) {
                                    AnonymousClass1.this.f258499f.setImageBitmap(bitmap2);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, "loadIconAsync end");
                                }
                            }
                        });
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, "loadIconAsync bmp: " + bitmap);
                    }
                    this.f258498e.runOnUiThread(new Runnable(bitmap) { // from class: com.tencent.mobileqq.phonecontact.util.PhoneContactUtils.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Bitmap f258500d;

                        {
                            this.f258500d = bitmap;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bitmap);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            Bitmap bitmap2 = this.f258500d;
                            if (bitmap2 != null) {
                                AnonymousClass1.this.f258499f.setImageBitmap(bitmap2);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, "loadIconAsync end");
                            }
                        }
                    });
                }
            }, 16, null, true);
        } else if (QLog.isColorLevel()) {
            QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, String.format("loadIconAsync [%s, %s, %s]", appInterface, resources, imageView));
        }
    }

    private static byte[] c(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i3 = 0; length > i3 * 2; i3++) {
            byte b16 = bArr[i3];
            int i16 = length - i3;
            bArr[i3] = bArr[i16];
            bArr[i16] = b16;
        }
        return bArr;
    }
}
