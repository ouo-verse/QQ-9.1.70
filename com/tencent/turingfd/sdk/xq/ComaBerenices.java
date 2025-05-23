package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.turingfd.sdk.xq.Hydra;
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
public class ComaBerenices {

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.ComaBerenices$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo implements Hydra {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String[] f382654a;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f382655b;

        public Cdo(String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) strArr);
            } else {
                this.f382655b = 0;
                this.f382654a = strArr;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:139:0x007a, code lost:
        
            if (r4 != false) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x022f  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0237  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Hydra.Cdo a(byte[] bArr) {
            Context context;
            boolean z16;
            char c16;
            HttpURLConnection httpURLConnection;
            int i3;
            HttpURLConnection httpURLConnection2;
            int responseCode;
            NetworkInfo activeNetworkInfo;
            String a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Hydra.Cdo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            }
            String str = this.f382654a[this.f382655b];
            synchronized (Celse.class) {
                context = Celse.f383328a;
            }
            boolean z17 = true;
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable th5) {
                String message = th5.getMessage();
                if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
                if (NetworkMonitor.getType(activeNetworkInfo) != 1) {
                    if (NetworkMonitor.getType(activeNetworkInfo) == 0 && (a16 = ComaBerenices.a(context)) != null && a16.length() > 0 && ComaBerenices.b(context) > 0) {
                        c16 = 2;
                    } else {
                        c16 = 3;
                    }
                    byte[] bArr2 = null;
                    if (c16 == 4) {
                        i3 = MessageRecord.MSG_TYPE_AI_SPECIAL_GUIDE;
                        httpURLConnection = null;
                    } else {
                        try {
                            URL url = new URL(str);
                            if (c16 == 2) {
                                httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(ComaBerenices.a(Celse.a()), ComaBerenices.b(Celse.a()))));
                            } else {
                                httpURLConnection2 = (HttpURLConnection) url.openConnection();
                            }
                        } catch (IllegalArgumentException e16) {
                            e = e16;
                            httpURLConnection = null;
                        } catch (SecurityException e17) {
                            e = e17;
                            httpURLConnection = null;
                        } catch (MalformedURLException e18) {
                            e = e18;
                            httpURLConnection = null;
                        } catch (IOException e19) {
                            e = e19;
                            httpURLConnection = null;
                        } catch (UnsupportedOperationException e26) {
                            e = e26;
                            httpURLConnection = null;
                        } catch (Throwable th6) {
                            th = th6;
                            httpURLConnection = null;
                        }
                        try {
                            httpURLConnection2.setReadTimeout(15000);
                            httpURLConnection2.setConnectTimeout(15000);
                            httpURLConnection = httpURLConnection2;
                            i3 = 0;
                        } catch (IllegalArgumentException e27) {
                            httpURLConnection = httpURLConnection2;
                            e = e27;
                            e.printStackTrace();
                            i3 = -1057;
                            if (i3 == 0) {
                            }
                            z17 = false;
                            if (i3 == 0) {
                            }
                        } catch (SecurityException e28) {
                            httpURLConnection = httpURLConnection2;
                            e = e28;
                            e.printStackTrace();
                            i3 = -1058;
                            if (i3 == 0) {
                            }
                            z17 = false;
                            if (i3 == 0) {
                            }
                        } catch (UnsupportedOperationException e29) {
                            httpURLConnection = httpURLConnection2;
                            e = e29;
                            e.printStackTrace();
                            i3 = -1059;
                            if (i3 == 0) {
                            }
                            z17 = false;
                            if (i3 == 0) {
                            }
                        } catch (MalformedURLException e36) {
                            httpURLConnection = httpURLConnection2;
                            e = e36;
                            e.printStackTrace();
                            i3 = -1053;
                            if (i3 == 0) {
                            }
                            z17 = false;
                            if (i3 == 0) {
                            }
                        } catch (IOException e37) {
                            httpURLConnection = httpURLConnection2;
                            e = e37;
                            e.printStackTrace();
                            i3 = -1056;
                            if (i3 == 0) {
                            }
                            z17 = false;
                            if (i3 == 0) {
                            }
                        } catch (Throwable th7) {
                            httpURLConnection = httpURLConnection2;
                            th = th7;
                            th.printStackTrace();
                            i3 = -1000;
                            if (i3 == 0) {
                            }
                            z17 = false;
                            if (i3 == 0) {
                            }
                        }
                    }
                    if (i3 == 0) {
                        i3 = -2000;
                        try {
                            try {
                                int length = bArr.length;
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setDoInput(true);
                                httpURLConnection.setUseCaches(false);
                                httpURLConnection.setRequestMethod("POST");
                                httpURLConnection.setRequestProperty("Pragma", "no-cache");
                                httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                                httpURLConnection.setInstanceFollowRedirects(false);
                                httpURLConnection.setRequestProperty("User-Agent", "Turing");
                                httpURLConnection.setRequestProperty("Accept", "*/*");
                                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                                httpURLConnection.setRequestProperty(FileUploadBase.CONTENT_LENGTH, "" + length);
                                try {
                                    if (Build.VERSION.SDK != null) {
                                        httpURLConnection.setRequestProperty("Connection", "close");
                                    }
                                } catch (Exception unused) {
                                }
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(bArr);
                                outputStream.flush();
                                outputStream.close();
                                responseCode = httpURLConnection.getResponseCode();
                            } catch (ProtocolException e38) {
                                StringBuilder a17 = Flat.a("protocol error:");
                                a17.append(e38.getMessage());
                                Log.e("TuringHttpUtil", a17.toString());
                                e38.printStackTrace();
                                i3 = MessageRecord.MSG_TYPE_QQSTORY;
                            } catch (IOException e39) {
                                StringBuilder a18 = Flat.a("post io error:");
                                a18.append(e39.getMessage());
                                Log.e("TuringHttpUtil", a18.toString());
                                e39.printStackTrace();
                                i3 = MessageRecord.MSG_TYPE_TROOP_WANT_GIFT_MSG;
                            } catch (IllegalStateException e46) {
                                StringBuilder a19 = Flat.a("illegal state error:");
                                a19.append(e46.getMessage());
                                Log.e("TuringHttpUtil", a19.toString());
                                e46.printStackTrace();
                                i3 = MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED;
                            }
                        } catch (IllegalAccessError e47) {
                            StringBuilder a26 = Flat.a("illegal access error:");
                            a26.append(e47.getMessage());
                            Log.e("TuringHttpUtil", a26.toString());
                            e47.printStackTrace();
                            i3 = MessageRecord.MSG_TYPE_PL_NEWS;
                        } catch (Throwable th8) {
                            Log.w("TuringHttpUtil", th8);
                            th8.printStackTrace();
                        }
                        if (responseCode == 200) {
                            i3 = 0;
                            if (i3 == 0) {
                                return new Hydra.Cdo(i3, new byte[0]);
                            }
                            AtomicReference atomicReference = new AtomicReference();
                            int i16 = -4000;
                            if (httpURLConnection != null && z17) {
                                try {
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    while (true) {
                                        int read = inputStream.read();
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(read);
                                    }
                                    bArr2 = byteArrayOutputStream.toByteArray();
                                    i16 = 0;
                                } catch (IOException e48) {
                                    e48.printStackTrace();
                                    i16 = -4056;
                                } catch (Exception e49) {
                                    e49.printStackTrace();
                                }
                                atomicReference.set(bArr2);
                                httpURLConnection.disconnect();
                            }
                            if (i16 != 0) {
                                return new Hydra.Cdo(i16, new byte[0]);
                            }
                            return new Hydra.Cdo(i16, (byte[]) atomicReference.get());
                        }
                        if (responseCode != -1) {
                            i3 = (-2000) - responseCode;
                        }
                    }
                    z17 = false;
                    if (i3 == 0) {
                    }
                }
                c16 = 1;
                byte[] bArr22 = null;
                if (c16 == 4) {
                }
                if (i3 == 0) {
                }
                z17 = false;
                if (i3 == 0) {
                }
            }
            c16 = 4;
            byte[] bArr222 = null;
            if (c16 == 4) {
            }
            if (i3 == 0) {
            }
            z17 = false;
            if (i3 == 0) {
            }
        }
    }

    public static String a(Context context) {
        return System.getProperty("http.proxyHost");
    }

    public static int b(Context context) {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
