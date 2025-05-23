package com.tencent.mobileqq.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dv {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f307686a = Uri.parse("content://telephony/carriers/preferapn");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f307687a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f307688b = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7 A[Catch: IOException -> 0x00c3, TRY_LEAVE, TryCatch #5 {IOException -> 0x00c3, blocks: (B:50:0x00bf, B:43:0x00c7), top: B:49:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0112 A[Catch: IOException -> 0x010e, TRY_LEAVE, TryCatch #9 {IOException -> 0x010e, blocks: (B:63:0x010a, B:56:0x0112), top: B:62:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, double d16, double d17, int i3, HttpClient httpClient) {
        InputStreamReader inputStreamReader;
        Throwable th5;
        BufferedReader bufferedReader;
        String str;
        String str2;
        JSONObject optJSONObject;
        int indexOf;
        String str3 = "https://maps.google.com/maps/api/geocode/json?latlng=" + d16 + "," + d17 + "&sensor=false&language=zh-CN";
        String str4 = "";
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, 20000L);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, "android-qzone");
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        d(context, defaultHttpClient);
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(defaultHttpClient.execute(new HttpGet(str3)).getEntity().getContent());
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                str2 = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str2 = str2 + readLine;
                        } else {
                            try {
                                break;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                    } catch (IOException e17) {
                        e = e17;
                        str = str2;
                        inputStreamReader2 = inputStreamReader;
                        try {
                            e.printStackTrace();
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                    str2 = str;
                                    optJSONObject = new JSONObject(str2).getJSONArray(ForwardMiniChooseFriendOption.RESULT_LIST).optJSONObject(0);
                                    if (optJSONObject != null) {
                                    }
                                    indexOf = str4.indexOf(HardCodeUtil.qqStr(R.string.t1p));
                                    if (indexOf < 0) {
                                    }
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            str2 = str;
                            optJSONObject = new JSONObject(str2).getJSONArray(ForwardMiniChooseFriendOption.RESULT_LIST).optJSONObject(0);
                            if (optJSONObject != null) {
                            }
                            indexOf = str4.indexOf(HardCodeUtil.qqStr(R.string.t1p));
                            if (indexOf < 0) {
                            }
                        } catch (Throwable th6) {
                            inputStreamReader = inputStreamReader2;
                            th5 = th6;
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                    throw th5;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th5;
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th5;
                    }
                }
                inputStreamReader.close();
                bufferedReader.close();
            } catch (IOException e26) {
                e = e26;
                bufferedReader = null;
                inputStreamReader2 = inputStreamReader;
                str = "";
                e.printStackTrace();
                if (inputStreamReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                str2 = str;
                optJSONObject = new JSONObject(str2).getJSONArray(ForwardMiniChooseFriendOption.RESULT_LIST).optJSONObject(0);
                if (optJSONObject != null) {
                }
                indexOf = str4.indexOf(HardCodeUtil.qqStr(R.string.t1p));
                if (indexOf < 0) {
                }
            } catch (Throwable th8) {
                bufferedReader = null;
                th5 = th8;
            }
        } catch (IOException e27) {
            e = e27;
            bufferedReader = null;
        } catch (Throwable th9) {
            inputStreamReader = null;
            th5 = th9;
            bufferedReader = null;
        }
        try {
            optJSONObject = new JSONObject(str2).getJSONArray(ForwardMiniChooseFriendOption.RESULT_LIST).optJSONObject(0);
            if (optJSONObject != null) {
                try {
                    str4 = optJSONObject.getString("formatted_address");
                } catch (JSONException e28) {
                    e28.printStackTrace();
                }
            }
            indexOf = str4.indexOf(HardCodeUtil.qqStr(R.string.t1p));
            if (indexOf < 0) {
                return str4.substring(0, indexOf).trim();
            }
            return str4;
        } catch (JSONException unused) {
            return "";
        }
    }

    private static a b(Context context) {
        a aVar = new a();
        Cursor cursor = null;
        try {
            try {
                Cursor query = ContactsMonitor.query(context.getContentResolver(), f307686a, null, null, null, null);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("proxy"));
                if (string != null) {
                    string = string.toLowerCase();
                }
                String string2 = query.getString(query.getColumnIndex("port"));
                String string3 = query.getString(query.getColumnIndex("apn"));
                if (string3 != null) {
                    string3 = string3.toLowerCase();
                }
                query.close();
                if (string != null && string.length() > 0 && Integer.valueOf(string2).intValue() > 0) {
                    aVar.f307687a = string;
                    aVar.f307688b = Integer.valueOf(string2).intValue();
                } else if (string3 != null && string3.startsWith("ctwap")) {
                    aVar.f307687a = "10.0.0.200";
                    aVar.f307688b = 80;
                } else if (string3 != null && string3.startsWith("cmwap")) {
                    aVar.f307687a = "10.0.0.172";
                    aVar.f307688b = 80;
                } else if (string3 != null && string3.startsWith("uniwap")) {
                    aVar.f307687a = "10.0.0.172";
                    aVar.f307688b = 80;
                }
                query.close();
                return aVar;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (0 != 0) {
                    cursor.close();
                }
                return aVar;
            }
        } catch (Throwable unused) {
            if (0 != 0) {
                cursor.close();
            }
            return aVar;
        }
    }

    private static String c(Context context) {
        int i3;
        String str;
        if (context == null) {
            str = Proxy.getDefaultHost();
            i3 = Proxy.getDefaultPort();
        } else if (AppNetConnInfo.isMobileConn()) {
            String host = Proxy.getHost(context);
            int port = Proxy.getPort(context);
            if (host == null || host.trim().length() == 0 || port <= 0) {
                host = Proxy.getDefaultHost();
                port = Proxy.getDefaultPort();
                if (host == null || host.trim().length() == 0 || port <= 0) {
                    a b16 = b(context);
                    String str2 = b16.f307687a;
                    i3 = b16.f307688b;
                    str = str2;
                }
            }
            str = host;
            i3 = port;
        } else {
            return null;
        }
        if (str != null && str.trim().length() > 0) {
            return str + ":" + i3;
        }
        return "";
    }

    public static void d(Context context, HttpClient httpClient) {
        String[] split;
        httpClient.getParams().removeParameter(ConnRoutePNames.DEFAULT_PROXY);
        String c16 = c(context);
        if (c16 != null && c16.length() > 0 && (split = c16.split(":")) != null && split.length == 2) {
            httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(split[0], Integer.valueOf(split[1]).intValue()));
        }
    }
}
