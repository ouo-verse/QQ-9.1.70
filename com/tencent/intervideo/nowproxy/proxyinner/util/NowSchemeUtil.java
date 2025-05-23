package com.tencent.intervideo.nowproxy.proxyinner.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.intervideo.nowproxy.Global;
import com.tencent.intervideo.nowproxy.ListNameData;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.baseability.log.DefaultLog;
import com.tencent.intervideo.nowproxy.common.ThreadManager;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NowSchemeUtil {
    static IPatchRedirector $redirector_;
    private static String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(BaseConstants.ERR_SDK_NET_WAIT_SEND_REMAINING_TIMEOUT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = "NowSchemeUtil";
        }
    }

    public NowSchemeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String addBusiParam(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str + "&busiparam=" + str2;
            }
            return str + "?busiparam=" + str2;
        }
        return str;
    }

    public static boolean doAction(Context context, String str, Intent intent) {
        String str2;
        intent.putExtra("doAction", str);
        if (TextUtils.isEmpty(str) && !Global.sAppid.equals("2")) {
            Toast.makeText(context, "\u7f3a\u5c11\u5173\u952e\u53c2\u6570action", 0).show();
            return false;
        }
        try {
            String stringExtra = intent.getStringExtra("decoded_scheme");
            str2 = stringExtra.substring(stringExtra.indexOf("viewid"), stringExtra.length());
        } catch (Exception unused) {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            ThreadManager.getFileThreadHandler().post(new Runnable("https://c.gdt.qq.com/gdt_mclick.fcg?" + str2) { // from class: com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$gdt_url;

                {
                    this.val$gdt_url = r4;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.val$gdt_url).openConnection();
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() == 200) {
                            httpURLConnection.getInputStream();
                        }
                        XLog.i(NowSchemeUtil.TAG, "ping gdt time = " + (System.currentTimeMillis() - currentTimeMillis));
                    } catch (IOException e16) {
                        DefaultLog.e(NowSchemeUtil.TAG, "ping gdt e = " + e16.getMessage());
                        e16.printStackTrace();
                    }
                }
            });
        }
        if (str.equalsIgnoreCase("openroom")) {
            return doOpenRoomAction(intent);
        }
        if (str.equalsIgnoreCase("preload")) {
            NowLive.preload(null);
            return true;
        }
        NowLive.getNowRoomEntry().enterPluginManager(6, intent.getExtras());
        return true;
    }

    public static boolean doActionByScheme(Context context, String str, Bundle bundle, long j3) {
        XLog.i(TAG, "doActionByScheme scheme = " + str);
        Intent parseSchemeUrl = parseSchemeUrl(str);
        if (parseSchemeUrl == null) {
            return false;
        }
        String stringExtra = parseSchemeUrl.getStringExtra("action");
        if (bundle != null) {
            parseSchemeUrl.putExtras(bundle);
        }
        parseSchemeUrl.putExtra("actionSeq", j3);
        parseSchemeUrl.removeExtra("action");
        return doAction(context, stringExtra, parseSchemeUrl);
    }

    private static boolean doOpenRoomAction(Intent intent) {
        long j3;
        String str;
        int i3;
        String str2;
        String str3;
        int i16;
        ListNameData listNameData;
        long j16;
        String str4 = "";
        long j17 = 0;
        ListNameData listNameData2 = null;
        int i17 = 2;
        try {
            j17 = Long.parseLong(intent.getStringExtra("roomid"));
            String stringExtra = intent.getStringExtra("vid");
            try {
                String stringExtra2 = intent.getStringExtra("listname");
                str4 = intent.getStringExtra("fromid");
                String stringExtra3 = intent.getStringExtra(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
                if (stringExtra3 != null) {
                    try {
                        if (stringExtra3.length() > 0) {
                            i17 = Integer.valueOf(stringExtra3).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(stringExtra2)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(stringExtra2);
                    listNameData2 = new ListNameData(arrayList, 0);
                }
                str3 = str4;
                j16 = j17;
                listNameData = listNameData2;
                i16 = i17;
                str2 = stringExtra;
            } catch (Exception unused2) {
                j3 = j17;
                str = str4;
                i3 = i17;
                str4 = stringExtra;
                str2 = str4;
                str3 = str;
                i16 = i3;
                listNameData = null;
                j16 = j3;
                return NowLive.openRoom(listNameData, j16, str2, str3, i16, intent.getExtras());
            }
        } catch (Exception unused3) {
            j3 = j17;
            str = "";
            i3 = 2;
        }
        return NowLive.openRoom(listNameData, j16, str2, str3, i16, intent.getExtras());
    }

    public static Intent parseSchemeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            Intent intent = new Intent();
            intent.putExtra("original_scheme", str);
            intent.putExtra("decoded_scheme", decode);
            String[] split = decode.split(ContainerUtils.FIELD_DELIMITER);
            if (split == null || split.length == 0) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length == 2) {
                    intent.putExtra(split2[0], split2[1]);
                }
            }
            return intent;
        } catch (Exception e16) {
            DefaultLog.e(TAG, "parseScheme decode exception");
            e16.printStackTrace();
            return null;
        }
    }
}
