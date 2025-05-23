package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qqcircle.beans.QFSRecordShareUserBean;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cc {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends TypeToken<List<QFSRecordShareUserBean>> {
        a() {
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(",");
        ArrayList arrayList = new ArrayList();
        int length = split.length - 1;
        while (true) {
            if (length < 0) {
                break;
            }
            String str2 = split[length];
            if (arrayList.size() >= 10) {
                QLog.d("QFSRecentlyShareUserHelper", 1, "[deduplicateUsers] userList len: " + split.length);
                break;
            }
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
            length--;
        }
        Collections.reverse(arrayList);
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sb5.append((String) arrayList.get(i3));
            if (i3 < arrayList.size() - 1) {
                sb5.append(",");
            }
        }
        return sb5.toString();
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        String h16 = uq3.k.a().h("key_recently_share_user_list", "");
        if (TextUtils.isEmpty(h16)) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(h16.split(",")));
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static List<QFSRecordShareUserBean> c() {
        if (!com.tencent.biz.qqcircle.immersive.utils.a.c()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        String h16 = uq3.k.a().h("key_recent_share_mutual_follow_user_list", null);
        if (h16 == null) {
            return arrayList;
        }
        try {
            return (List) new Gson().fromJson(h16, new a().getType());
        } catch (Exception e16) {
            QLog.e("QFSRecentlyShareUserHelper", 1, "[parseRecordShareMutualFollowUserBeanList] error: " + e16);
            return arrayList;
        }
    }

    public static void d(List<String> list) {
        int i3;
        if (list == null || list.isEmpty() || !com.tencent.biz.qqcircle.immersive.utils.a.c()) {
            return;
        }
        List<QFSRecordShareUserBean> c16 = c();
        ArrayList arrayList = new ArrayList();
        Iterator<QFSRecordShareUserBean> it = c16.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            QFSRecordShareUserBean next = it.next();
            while (i3 < list.size()) {
                if (list.get(i3).equals(next.getShareUin())) {
                    next.setShareTimestamp(System.currentTimeMillis());
                    arrayList.add(Integer.valueOf(i3));
                }
                i3++;
            }
        }
        while (i3 < list.size()) {
            if (!arrayList.contains(Integer.valueOf(i3))) {
                QFSRecordShareUserBean qFSRecordShareUserBean = new QFSRecordShareUserBean();
                qFSRecordShareUserBean.setShareUin(list.get(i3));
                qFSRecordShareUserBean.setShareTimestamp(System.currentTimeMillis());
                c16.add(qFSRecordShareUserBean);
            }
            i3++;
        }
        uq3.k.a().p("key_recent_share_mutual_follow_user_list", new Gson().toJson(c16));
        QLog.d("QFSRecentlyShareUserHelper", 1, "saveRecentShareMutualFollowUsers");
    }

    public static void e(String str) {
        String a16 = a(uq3.k.a().h("key_recently_share_user_list", ""));
        if (!TextUtils.isEmpty(a16)) {
            String[] split = a16.split(",");
            StringBuilder sb5 = new StringBuilder();
            if (Arrays.asList(split).contains(str)) {
                int indexOf = Arrays.asList(split).indexOf(str);
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (i3 != indexOf) {
                        sb5.append(split[i3]);
                        sb5.append(",");
                    }
                }
                sb5.append(str);
                str = sb5.toString();
            } else if (split.length == 10) {
                for (int i16 = 1; i16 < 10; i16++) {
                    sb5.append(split[i16]);
                    sb5.append(",");
                }
                sb5.append(str);
                str = sb5.toString();
            } else {
                str = a16 + "," + str;
            }
        }
        QLog.d("QFSRecentlyShareUserHelper", 1, "saveUser: " + str);
        uq3.k.a().p("key_recently_share_user_list", str);
    }
}
