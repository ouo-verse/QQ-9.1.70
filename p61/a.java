package p61;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f425431a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: p61.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C10983a extends TypeToken<List<String>> {
        C10983a() {
        }
    }

    public static List<String> a() {
        List<String> list = f425431a;
        if (list.size() > 0) {
            return list;
        }
        g();
        return list;
    }

    public static String b(int i3) {
        if (i3 > 99) {
            return "99+";
        }
        return String.valueOf(i3);
    }

    private static SharedPreferences c() {
        return BaseApplicationImpl.getApplication().getSharedPreferences(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), 0);
    }

    public static boolean d(int i3) {
        if (10007 == i3) {
            return true;
        }
        return false;
    }

    public static boolean e(MessageRecord messageRecord) {
        if (messageRecord != null && f(messageRecord.istroop)) {
            return true;
        }
        return false;
    }

    public static boolean f(int i3) {
        if (10008 == i3) {
            return true;
        }
        return false;
    }

    private static void g() {
        SharedPreferences c16 = c();
        if (c16 != null && c16.contains("sp_chat_no_limit_white_list_key")) {
            List list = (List) new Gson().fromJson(c16.getString("sp_chat_no_limit_white_list_key", null), new C10983a().getType());
            if (list != null && !list.isEmpty()) {
                List<String> list2 = f425431a;
                list2.clear();
                list2.addAll(list);
            }
        }
    }

    public static void h(List<String> list) {
        SharedPreferences c16;
        if (list != null && !list.isEmpty() && (c16 = c()) != null && c16.edit() != null) {
            try {
                c16.edit().putString("sp_chat_no_limit_white_list_key", new Gson().toJson(list)).apply();
            } catch (Exception e16) {
                QLog.e("QCircleChatUtil", 1, "saveChatNoLimitWhiteList error:" + e16);
            }
        }
    }
}
