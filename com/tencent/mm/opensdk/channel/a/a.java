package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C7048a {

        /* renamed from: a, reason: collision with root package name */
        public String f151765a;

        /* renamed from: b, reason: collision with root package name */
        public String f151766b;

        /* renamed from: c, reason: collision with root package name */
        public String f151767c;

        /* renamed from: d, reason: collision with root package name */
        public long f151768d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f151769e;
    }

    public static int a(Bundle bundle, String str, int i3) {
        if (bundle == null) {
            return i3;
        }
        try {
            return bundle.getInt(str, i3);
        } catch (Exception e16) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e16.getMessage());
            return i3;
        }
    }

    public static Object a(int i3, String str) {
        try {
            switch (i3) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (Exception e16) {
            Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e16.getMessage());
            return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e16) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e16.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C7048a c7048a) {
        String str;
        String str2;
        if (context == null || c7048a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!b.b(c7048a.f151766b)) {
                if (b.b(c7048a.f151765a)) {
                    str2 = null;
                } else {
                    str2 = c7048a.f151765a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c7048a.f151766b);
                Bundle bundle = c7048a.f151769e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c7048a.f151767c);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c7048a.f151768d);
                intent.putExtra(ConstantsAPI.CHECK_SUM, a(c7048a.f151767c, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0155: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:171:0x0155 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? r85;
        ByteArrayOutputStream byteArrayOutputStream3;
        String str2;
        ?? r36;
        Object obj;
        InputStream inputStream;
        Exception e16;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        IOException e17;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream3;
        MalformedURLException e18;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream4;
        ByteArrayOutputStream byteArrayOutputStream4;
        ByteArrayOutputStream byteArrayOutputStream5;
        ByteArrayOutputStream byteArrayOutputStream6;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        ?? r86;
        InputStream inputStream5 = null;
        if (str != null) {
            int length = str.length();
            try {
                if (length != 0) {
                    try {
                        r86 = (HttpURLConnection) new URL(str).openConnection();
                    } catch (MalformedURLException e19) {
                        e18 = e19;
                        httpURLConnection3 = null;
                        inputStream4 = null;
                    } catch (IOException e26) {
                        e17 = e26;
                        httpURLConnection2 = null;
                        inputStream3 = null;
                    } catch (Exception e27) {
                        e16 = e27;
                        httpURLConnection = null;
                        inputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        obj = null;
                        inputStream = null;
                    }
                    try {
                        if (r86 == 0) {
                            Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                            if (r86 != 0) {
                                try {
                                    r86.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            return null;
                        }
                        try {
                            r86.setRequestMethod("GET");
                            r86.setConnectTimeout(i3);
                            r86.setReadTimeout(i3);
                            if (r86.getResponseCode() >= 300) {
                                Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                                try {
                                    r86.disconnect();
                                } catch (Throwable unused2) {
                                }
                                return null;
                            }
                            InputStream inputStream6 = r86.getInputStream();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream7 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream6.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream7.write(bArr, 0, read);
                                    }
                                    byte[] byteArray = byteArrayOutputStream7.toByteArray();
                                    Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                                    try {
                                        r86.disconnect();
                                    } catch (Throwable unused3) {
                                    }
                                    try {
                                        inputStream6.close();
                                    } catch (Throwable unused4) {
                                    }
                                    try {
                                        byteArrayOutputStream7.close();
                                    } catch (Throwable unused5) {
                                    }
                                    return byteArray;
                                } catch (MalformedURLException e28) {
                                    inputStream4 = inputStream6;
                                    e18 = e28;
                                    byteArrayOutputStream6 = byteArrayOutputStream7;
                                    httpURLConnection6 = r86;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e18.getMessage());
                                    if (httpURLConnection6 != null) {
                                    }
                                    if (inputStream4 != null) {
                                    }
                                    if (byteArrayOutputStream6 != null) {
                                    }
                                    return null;
                                } catch (IOException e29) {
                                    inputStream3 = inputStream6;
                                    e17 = e29;
                                    byteArrayOutputStream5 = byteArrayOutputStream7;
                                    httpURLConnection5 = r86;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e17.getMessage());
                                    if (httpURLConnection5 != null) {
                                    }
                                    if (inputStream3 != null) {
                                    }
                                    if (byteArrayOutputStream5 != null) {
                                    }
                                    return null;
                                } catch (Exception e36) {
                                    inputStream2 = inputStream6;
                                    e16 = e36;
                                    byteArrayOutputStream4 = byteArrayOutputStream7;
                                    httpURLConnection4 = r86;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e16.getMessage());
                                    if (httpURLConnection4 != null) {
                                    }
                                    if (inputStream2 != null) {
                                    }
                                    if (byteArrayOutputStream4 != null) {
                                    }
                                    return null;
                                } catch (Throwable th6) {
                                    byteArrayOutputStream2 = byteArrayOutputStream7;
                                    r36 = inputStream6;
                                    th = th6;
                                    str2 = r86;
                                    byteArrayOutputStream3 = byteArrayOutputStream2;
                                    inputStream5 = r36;
                                    r85 = str2;
                                    if (r85 != 0) {
                                    }
                                    if (inputStream5 != null) {
                                    }
                                    if (byteArrayOutputStream3 == null) {
                                    }
                                }
                            } catch (MalformedURLException e37) {
                                inputStream4 = inputStream6;
                                e18 = e37;
                                httpURLConnection3 = r86;
                                byteArrayOutputStream6 = null;
                                httpURLConnection6 = httpURLConnection3;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e18.getMessage());
                                if (httpURLConnection6 != null) {
                                    try {
                                        httpURLConnection6.disconnect();
                                    } catch (Throwable unused6) {
                                    }
                                }
                                if (inputStream4 != null) {
                                    try {
                                        inputStream4.close();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                if (byteArrayOutputStream6 != null) {
                                    try {
                                        byteArrayOutputStream6.close();
                                    } catch (Throwable unused8) {
                                    }
                                }
                                return null;
                            } catch (IOException e38) {
                                inputStream3 = inputStream6;
                                e17 = e38;
                                httpURLConnection2 = r86;
                                byteArrayOutputStream5 = null;
                                httpURLConnection5 = httpURLConnection2;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e17.getMessage());
                                if (httpURLConnection5 != null) {
                                    try {
                                        httpURLConnection5.disconnect();
                                    } catch (Throwable unused9) {
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable unused10) {
                                    }
                                }
                                if (byteArrayOutputStream5 != null) {
                                    try {
                                        byteArrayOutputStream5.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                return null;
                            } catch (Exception e39) {
                                inputStream2 = inputStream6;
                                e16 = e39;
                                httpURLConnection = r86;
                                byteArrayOutputStream4 = null;
                                httpURLConnection4 = httpURLConnection;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e16.getMessage());
                                if (httpURLConnection4 != null) {
                                    try {
                                        httpURLConnection4.disconnect();
                                    } catch (Throwable unused12) {
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused13) {
                                    }
                                }
                                if (byteArrayOutputStream4 != null) {
                                    try {
                                        byteArrayOutputStream4.close();
                                    } catch (Throwable unused14) {
                                    }
                                }
                                return null;
                            } catch (Throwable th7) {
                                inputStream = inputStream6;
                                th = th7;
                                obj = r86;
                                inputStream5 = inputStream;
                                byteArrayOutputStream3 = null;
                                r85 = obj;
                                if (r85 != 0) {
                                    try {
                                        r85.disconnect();
                                    } catch (Throwable unused15) {
                                    }
                                }
                                if (inputStream5 != null) {
                                    try {
                                        inputStream5.close();
                                    } catch (Throwable unused16) {
                                    }
                                }
                                if (byteArrayOutputStream3 == null) {
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream3.close();
                                    throw th;
                                } catch (Throwable unused17) {
                                    throw th;
                                }
                            }
                        } catch (MalformedURLException e46) {
                            e18 = e46;
                            inputStream4 = null;
                            httpURLConnection3 = r86;
                        } catch (IOException e47) {
                            e17 = e47;
                            inputStream3 = null;
                            httpURLConnection2 = r86;
                        } catch (Exception e48) {
                            e16 = e48;
                            inputStream2 = null;
                            httpURLConnection = r86;
                        } catch (Throwable th8) {
                            th = th8;
                            inputStream = null;
                            obj = r86;
                        }
                    } catch (MalformedURLException e49) {
                        e18 = e49;
                        inputStream4 = null;
                        byteArrayOutputStream6 = null;
                        httpURLConnection6 = r86;
                    } catch (IOException e56) {
                        e17 = e56;
                        inputStream3 = null;
                        byteArrayOutputStream5 = null;
                        httpURLConnection5 = r86;
                    } catch (Exception e57) {
                        e16 = e57;
                        inputStream2 = null;
                        byteArrayOutputStream4 = null;
                        httpURLConnection4 = r86;
                    } catch (Throwable th9) {
                        th = th9;
                        byteArrayOutputStream3 = null;
                        r85 = r86;
                        if (r85 != 0) {
                        }
                        if (inputStream5 != null) {
                        }
                        if (byteArrayOutputStream3 == null) {
                        }
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                byteArrayOutputStream2 = byteArrayOutputStream;
                r36 = length;
                str2 = str;
            }
        }
        Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        return null;
    }

    public static byte[] a(String str, int i3, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i3);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i16 = 0;
            for (byte b16 : digest) {
                int i17 = i16 + 1;
                cArr2[i16] = cArr[(b16 >>> 4) & 15];
                i16 = i17 + 1;
                cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
