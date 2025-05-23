package com.tencent.mobileqq.matchfriend.utils;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {
    public static void b(Context context, String str, String str2) {
        c(context, str, str2);
    }

    public static List<Pair<String, String>> d(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("<qa .*?>(.*?)</qa>").matcher(str);
        while (matcher.find() && matcher.groupCount() > 0) {
            arrayList.add(new Pair(matcher.group(0), matcher.group(1)));
        }
        return arrayList;
    }

    public static String e(String str) {
        Matcher matcher = Pattern.compile("(?<=qhref=\\\").+?(?=\\\")|(?<=qhref=\\').+?(?=\\')").matcher(str);
        if (matcher.find()) {
            return str.substring(matcher.start(), matcher.end());
        }
        return null;
    }

    public static String a(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "0";
        }
        return messageRecord.getExtInfoFromExtStr("match_friend_official_message_type");
    }

    private static void c(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        d dVar = new d(context);
        dVar.c("pg_kl_new_official_account_chat_page", null);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_kl_new_official_account_msg");
        dVar.b(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_official_account_msg_type_id", str2);
        dVar.m("em_kl_new_official_account_msg", str, hashMap);
    }
}
