package com.tencent.mobileqq.signature.topic;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.Spannable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f288457a;

    public static boolean a(String str) {
        if (str == null || str.trim().length() < 3) {
            return false;
        }
        return true;
    }

    public static int b(Editable editable, int i3) {
        if (editable.length() < 0 || i3 < 2 || i3 > editable.length()) {
            return -1;
        }
        for (int i16 = i3 - 1; i16 >= 0 && g(editable, i16) == null && editable.charAt(i16) != ' '; i16--) {
            if (editable.charAt(i16) == '#') {
                return i16;
            }
        }
        return -1;
    }

    public static ColorStateList c(int i3, int i16) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{0}}, new int[]{i16, i3});
    }

    public static String d(Editable editable) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < editable.length(); i3++) {
            if (g(editable, i3) == null) {
                sb5.append(editable.subSequence(i3, i3 + 1));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TopicUtil", 2, String.format("getPlainText [edit=%s len=%d %s]", editable, Integer.valueOf(editable.length()), sb5.toString()));
        }
        return sb5.toString();
    }

    public static List<Pair<Integer, String>> e(Editable editable) {
        ITopic iTopic;
        ArrayList arrayList = new ArrayList();
        ITopic iTopic2 = null;
        for (int i3 = 0; i3 < editable.length(); i3++) {
            ITopic[] iTopicArr = (ITopic[]) editable.getSpans(i3, i3, ITopic.class);
            if (iTopicArr != null && iTopicArr.length > 0 && (iTopic = iTopicArr[0]) != iTopic2) {
                Object data = iTopic.getData();
                if (data instanceof Pair) {
                    arrayList.add((Pair) data);
                }
                iTopic2 = iTopic;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("TopicUtil", 2, String.format("getTopics %s", j(arrayList)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<Pair<Integer, Integer>> f(Editable editable) {
        ITopic iTopic;
        ArrayList arrayList = new ArrayList();
        ITopic iTopic2 = null;
        for (int i3 = 0; i3 < editable.length(); i3++) {
            ITopic[] iTopicArr = (ITopic[]) editable.getSpans(i3, i3, ITopic.class);
            if (iTopicArr != null && iTopicArr.length > 0) {
                if (iTopicArr.length > 1) {
                    iTopic = null;
                    for (ITopic iTopic3 : iTopicArr) {
                        if (iTopic3 != iTopic2) {
                            iTopic = iTopic3;
                        }
                    }
                    if (iTopic == null) {
                        iTopic = iTopicArr[iTopicArr.length - 1];
                    }
                } else {
                    iTopic = iTopicArr[0];
                }
                if (iTopic != iTopic2) {
                    Object data = iTopic.getData();
                    if (data instanceof Pair) {
                        arrayList.add(new Pair((Integer) ((Pair) data).first, Integer.valueOf(i3)));
                    }
                    iTopic2 = iTopic;
                }
            }
        }
        return arrayList;
    }

    public static ITopic g(Spannable spannable, int i3) {
        if (i3 >= 0 && i3 < spannable.length()) {
            ITopic[] iTopicArr = (ITopic[]) spannable.getSpans(i3, i3, ITopic.class);
            for (int i16 = 0; i16 < iTopicArr.length; i16++) {
                int spanStart = spannable.getSpanStart(iTopicArr[i16]);
                int spanEnd = spannable.getSpanEnd(iTopicArr[i16]);
                if (i3 >= spanStart && i3 < spanEnd) {
                    return iTopicArr[i16];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if ((r3 - 1) < (r2.length() - 1)) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(Editable editable, int i3, int i16, int i17) {
        int i18;
        int i19;
        boolean z16;
        if (i3 < 0 && i16 >= 0 && i17 > 0 && i17 >= (i18 = -i3) && (i19 = i16 + i17) <= editable.length()) {
            int i26 = i19 - i18;
            if (Character.isLowSurrogate(editable.toString().charAt(i26)) && i26 > 0) {
                z16 = true;
            }
            z16 = false;
            editable.delete(i26, i19);
            if (z16) {
                editable.delete(i26 - 1, i26);
            }
        }
    }

    public static void i(Context context, String str, int i3) {
        if (System.currentTimeMillis() - f288457a < 500) {
            return;
        }
        f288457a = System.currentTimeMillis();
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        ((Activity) context).startActivityForResult(intent, i3);
    }

    public static String j(List<Pair<Integer, String>> list) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb5.append("index = ");
            sb5.append(i3);
            sb5.append(",");
            sb5.append("id = ");
            sb5.append(list.get(i3).first);
            sb5.append(",");
            sb5.append("topic = ");
            sb5.append(list.get(i3).second);
            sb5.append(",");
        }
        return sb5.toString();
    }
}
