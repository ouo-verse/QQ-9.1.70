package com.tencent.mobileqq.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parse.JumpParseConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.HashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bi {

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.mobileqq.app.parser.jumpcontroller.c f307491a;

    static {
        try {
            if (com.tencent.mobileqq.app.parser.jumpcontroller.d.f196486c.size() > 0) {
                f307491a = com.tencent.mobileqq.app.parser.jumpcontroller.d.f196486c.get(0).newInstance();
                QLog.d("JumpAction", 1, "JumpParserInject newInstance");
            }
        } catch (Exception e16) {
            QLog.e("JumpAction", 1, "JumpParserInject static statement: ", e16);
        }
    }

    public static String a(String str, boolean z16) {
        String str2;
        try {
            str2 = URLDecoder.decode(str);
            if (z16) {
                try {
                    return str2.replaceAll(" ", Marker.ANY_NON_NULL_MARKER);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("JumpAction", 2, "JumpParser parser Exception =" + str);
                        return str2;
                    }
                    return str2;
                }
            }
            return str2;
        } catch (Exception unused2) {
            str2 = null;
        }
    }

    public static String b(String str) {
        int indexOf;
        try {
            if (!TextUtils.isEmpty(str) && str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) != -1) {
                return str.substring(0, indexOf);
            }
            return str;
        } catch (Exception e16) {
            QLog.d("JumpAction", 2, "handleSensitiveSchemeLog out error", e16);
            return str;
        }
    }

    public static ax c(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "Jump input=" + b(str));
            }
            if (str == null) {
                return null;
            }
            return f307491a.a(baseQQAppInterface, context, str);
        } catch (Exception e16) {
            HashMap<String, String> hashMap = new HashMap<>(1);
            hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_UTIL_URL_ERROR_KEY, str);
            hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_UTIL_SCENE_ERROR_KEY, "2");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", JumpParseConstants.KEY_JUMP_PARSER_UTIL, true, 0L, 0L, hashMap, "", false);
            QLog.e("JumpAction", 1, "JumpParser parser Exception =" + e16.getMessage());
            ax axVar = new ax(baseQQAppInterface, context);
            axVar.f307439d = "";
            axVar.f307440e = "";
            axVar.f307438c = str;
            return axVar;
        }
    }

    public static String[] d(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length(), str.length())};
    }
}
