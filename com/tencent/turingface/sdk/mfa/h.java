package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.turingcam.eh5ma;
import com.tencent.turingcam.tmnyR;
import com.tencent.turingface.sdk.mfa.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes27.dex */
public class h implements m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String[] f382513a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f382514b;

    public h(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) strArr);
        } else {
            this.f382514b = 0;
            this.f382513a = strArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x007a, code lost:
    
        if (r4 != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m.a a(byte[] bArr) {
        Context context;
        boolean z16;
        char c16;
        Throwable th5;
        HttpURLConnection httpURLConnection;
        SecurityException e16;
        IllegalArgumentException e17;
        IOException e18;
        MalformedURLException e19;
        UnsupportedOperationException e26;
        int i3;
        HttpURLConnection httpURLConnection2;
        int i16;
        int responseCode;
        NetworkInfo activeNetworkInfo;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        String str = this.f382513a[this.f382514b];
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        boolean z17 = true;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th6) {
            String message = th6.getMessage();
            if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
            if (NetworkMonitor.getType(activeNetworkInfo) != 1) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 0 && (a16 = com.tencent.could.huiyansdk.utils.e.a(context)) != null && a16.length() > 0 && com.tencent.could.huiyansdk.utils.e.b(context) > 0) {
                    c16 = 2;
                } else {
                    c16 = 3;
                }
                byte[] bArr2 = null;
                if (c16 == 4) {
                    i16 = MessageRecord.MSG_TYPE_AI_SPECIAL_GUIDE;
                    httpURLConnection2 = null;
                } else {
                    try {
                        URL url = new URL(str);
                        if (c16 == 2) {
                            httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(com.tencent.could.huiyansdk.utils.e.a(eh5ma.a()), com.tencent.could.huiyansdk.utils.e.b(eh5ma.a()))));
                        } else {
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                        }
                        try {
                            httpURLConnection.setReadTimeout(15000);
                            httpURLConnection.setConnectTimeout(15000);
                            httpURLConnection2 = httpURLConnection;
                            i16 = 0;
                        } catch (IOException e27) {
                            e18 = e27;
                            e18.printStackTrace();
                            i3 = -1056;
                            int i17 = i3;
                            httpURLConnection2 = httpURLConnection;
                            i16 = i17;
                            if (i16 == 0) {
                            }
                            z17 = false;
                            if (i16 == 0) {
                            }
                        } catch (IllegalArgumentException e28) {
                            e17 = e28;
                            e17.printStackTrace();
                            i3 = -1057;
                            int i172 = i3;
                            httpURLConnection2 = httpURLConnection;
                            i16 = i172;
                            if (i16 == 0) {
                            }
                            z17 = false;
                            if (i16 == 0) {
                            }
                        } catch (SecurityException e29) {
                            e16 = e29;
                            e16.printStackTrace();
                            i3 = -1058;
                            int i1722 = i3;
                            httpURLConnection2 = httpURLConnection;
                            i16 = i1722;
                            if (i16 == 0) {
                            }
                            z17 = false;
                            if (i16 == 0) {
                            }
                        } catch (UnsupportedOperationException e36) {
                            e26 = e36;
                            e26.printStackTrace();
                            i3 = -1059;
                            int i17222 = i3;
                            httpURLConnection2 = httpURLConnection;
                            i16 = i17222;
                            if (i16 == 0) {
                            }
                            z17 = false;
                            if (i16 == 0) {
                            }
                        } catch (MalformedURLException e37) {
                            e19 = e37;
                            e19.printStackTrace();
                            i3 = -1053;
                            int i172222 = i3;
                            httpURLConnection2 = httpURLConnection;
                            i16 = i172222;
                            if (i16 == 0) {
                            }
                            z17 = false;
                            if (i16 == 0) {
                            }
                        } catch (Throwable th7) {
                            th5 = th7;
                            th5.printStackTrace();
                            i3 = -1000;
                            int i1722222 = i3;
                            httpURLConnection2 = httpURLConnection;
                            i16 = i1722222;
                            if (i16 == 0) {
                            }
                            z17 = false;
                            if (i16 == 0) {
                            }
                        }
                    } catch (UnsupportedOperationException e38) {
                        e26 = e38;
                        httpURLConnection = null;
                    } catch (MalformedURLException e39) {
                        e19 = e39;
                        httpURLConnection = null;
                    } catch (IOException e46) {
                        e18 = e46;
                        httpURLConnection = null;
                    } catch (IllegalArgumentException e47) {
                        e17 = e47;
                        httpURLConnection = null;
                    } catch (SecurityException e48) {
                        e16 = e48;
                        httpURLConnection = null;
                    } catch (Throwable th8) {
                        th5 = th8;
                        httpURLConnection = null;
                    }
                }
                if (i16 == 0) {
                    i16 = -2000;
                    try {
                        try {
                            int length = bArr.length;
                            httpURLConnection2.setDoOutput(true);
                            httpURLConnection2.setDoInput(true);
                            httpURLConnection2.setUseCaches(false);
                            httpURLConnection2.setRequestMethod("POST");
                            httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                            httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                            httpURLConnection2.setInstanceFollowRedirects(false);
                            httpURLConnection2.setRequestProperty("User-Agent", "Turing");
                            httpURLConnection2.setRequestProperty("Accept", "*/*");
                            httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                            httpURLConnection2.setRequestProperty("Content-Type", "application/octet-stream");
                            httpURLConnection2.setRequestProperty(FileUploadBase.CONTENT_LENGTH, "" + length);
                            try {
                                if (Build.VERSION.SDK != null) {
                                    httpURLConnection2.setRequestProperty("Connection", "close");
                                }
                            } catch (Exception unused) {
                            }
                            OutputStream outputStream = httpURLConnection2.getOutputStream();
                            outputStream.write(bArr);
                            outputStream.flush();
                            outputStream.close();
                            responseCode = httpURLConnection2.getResponseCode();
                        } catch (ProtocolException e49) {
                            StringBuilder a17 = tmnyR.a("protocol error:");
                            a17.append(e49.getMessage());
                            Log.e("TuringHttpUtil", a17.toString());
                            e49.printStackTrace();
                            i16 = MessageRecord.MSG_TYPE_QQSTORY;
                        } catch (IOException e56) {
                            StringBuilder a18 = tmnyR.a("post io error:");
                            a18.append(e56.getMessage());
                            Log.e("TuringHttpUtil", a18.toString());
                            e56.printStackTrace();
                            i16 = MessageRecord.MSG_TYPE_TROOP_WANT_GIFT_MSG;
                        } catch (IllegalStateException e57) {
                            StringBuilder a19 = tmnyR.a("illegal state error:");
                            a19.append(e57.getMessage());
                            Log.e("TuringHttpUtil", a19.toString());
                            e57.printStackTrace();
                            i16 = MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED;
                        }
                    } catch (IllegalAccessError e58) {
                        StringBuilder a26 = tmnyR.a("illegal access error:");
                        a26.append(e58.getMessage());
                        Log.e("TuringHttpUtil", a26.toString());
                        e58.printStackTrace();
                        i16 = MessageRecord.MSG_TYPE_PL_NEWS;
                    } catch (Throwable th9) {
                        Log.w("TuringHttpUtil", th9);
                        th9.printStackTrace();
                    }
                    if (responseCode == 200) {
                        i16 = 0;
                        if (i16 == 0) {
                            return new m.a(i16, new byte[0]);
                        }
                        AtomicReference atomicReference = new AtomicReference();
                        int i18 = -4000;
                        if (httpURLConnection2 != null && z17) {
                            try {
                                InputStream inputStream = httpURLConnection2.getInputStream();
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    int read = inputStream.read();
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(read);
                                }
                                bArr2 = byteArrayOutputStream.toByteArray();
                                i18 = 0;
                            } catch (IOException e59) {
                                e59.printStackTrace();
                                i18 = -4056;
                            } catch (Exception e65) {
                                e65.printStackTrace();
                            }
                            atomicReference.set(bArr2);
                            httpURLConnection2.disconnect();
                        }
                        if (i18 != 0) {
                            return new m.a(i18, new byte[0]);
                        }
                        return new m.a(i18, (byte[]) atomicReference.get());
                    }
                    if (responseCode != -1) {
                        i16 = (-2000) - responseCode;
                    }
                }
                z17 = false;
                if (i16 == 0) {
                }
            }
            c16 = 1;
            byte[] bArr22 = null;
            if (c16 == 4) {
            }
            if (i16 == 0) {
            }
            z17 = false;
            if (i16 == 0) {
            }
        }
        c16 = 4;
        byte[] bArr222 = null;
        if (c16 == 4) {
        }
        if (i16 == 0) {
        }
        z17 = false;
        if (i16 == 0) {
        }
    }
}
