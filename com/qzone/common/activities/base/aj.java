package com.qzone.common.activities.base;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.qzone.common.friend.business.model.Friend;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    static SpannableStringBuilder f45444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            int spanStart;
            int spanStart2;
            SpannableStringBuilder spannableStringBuilder = aj.f45444a;
            if (spannableStringBuilder == null || (spanStart = spannableStringBuilder.getSpanStart(obj)) == (spanStart2 = aj.f45444a.getSpanStart(obj2))) {
                return 0;
            }
            return spanStart > spanStart2 ? 1 : -1;
        }
    }

    public static String b(String str, List<Friend> list, boolean z16) {
        return a(str, list, z16);
    }

    public static int c(EditText editText, ArrayList<ResultRecord> arrayList, List<Friend> list, int i3) {
        if (arrayList == null) {
            return i3;
        }
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            Friend friend = new Friend();
            if (!TextUtils.isEmpty(next.name)) {
                friend.mName = next.name;
            } else {
                friend.mName = next.uin;
            }
            try {
                long parseLong = Long.parseLong(next.uin);
                friend.mUin = parseLong;
                if (friend.mName == null || parseLong == 0) {
                    RFWLog.e("InputViewPanelControl", RFWLog.USR, "parse at user list fail, friend name is " + friend.mName + " uin is " + friend.mUin);
                } else {
                    if (list == null) {
                        RFWLog.e("InputViewPanelControl", RFWLog.USR, "parse at user list is null");
                        return i3;
                    }
                    list.add(friend);
                    String str = "@" + friend.mName + " ";
                    if (i3 < str.length()) {
                        i3 = str.length();
                    }
                    com.qzone.util.am.g(str, editText.getSelectionStart(), editText);
                }
            } catch (NumberFormatException e16) {
                RFWLog.e("InputViewPanelControl", RFWLog.USR, "parse at user list uin exception is " + e16);
            }
        }
        return i3;
    }

    public static String d(List<Friend> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && list.size() != 0) {
            for (Friend friend : list) {
                String str = friend.mName;
                if (str == null) {
                    str = friend.mUin + "";
                }
                stringBuffer.append("@{uin:" + friend.mUin + ",nick:" + str.replace("%", "%25").replace(",", "%2C").replace("}", "%7D") + "}");
            }
            return stringBuffer.toString();
        }
        return stringBuffer.toString();
    }

    public static boolean j(String str, boolean z16, List<Friend> list, int i3, int i16, String str2) {
        if ((i(i3, i16, str2) || !z16) && list != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                Friend friend = list.get(i17);
                if (friend != null && friend.mName != null && str != null) {
                    if (!str.equalsIgnoreCase("@" + friend.mName)) {
                        if (str.equalsIgnoreCase("@" + friend.mName + " ")) {
                        }
                    }
                    if (!z16) {
                        return true;
                    }
                    list.remove(i17);
                    return true;
                }
            }
        }
        return false;
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("InputViewPanelControl", 1, "nick name is null");
            return null;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb5 = new StringBuilder(charArray.length);
        com.tencent.mobileqq.text.o oVar = new com.tencent.mobileqq.text.o(str, 3);
        f45444a = oVar;
        int i3 = 0;
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) oVar.getSpans(0, charArray.length, EmoticonSpan.class);
        Arrays.sort(emoticonSpanArr, new a());
        int length = emoticonSpanArr.length;
        int i16 = 0;
        while (i3 < length) {
            EmoticonSpan emoticonSpan = emoticonSpanArr[i3];
            int spanStart = f45444a.getSpanStart(emoticonSpan);
            int spanEnd = f45444a.getSpanEnd(emoticonSpan);
            if (emoticonSpan != null && spanStart < spanEnd && spanEnd > 0) {
                if (spanStart > i16) {
                    sb5.append(charArray, i16, spanStart - i16);
                }
                int i17 = emoticonSpan.emojiType;
                if (i17 == 0) {
                    String emojiUnicodeString = QQEmojiUtil.getEmojiUnicodeString(emoticonSpan.index);
                    if (!TextUtils.isEmpty(emojiUnicodeString)) {
                        sb5.append(emojiUnicodeString);
                    } else {
                        QLog.e(QQTextBuilder.TAG, 1, "\u4e0d\u652f\u6301\u7684\u8868\u60c5");
                    }
                } else if (i17 == 1) {
                    String faceDescription = QQSysFaceUtil.getFaceDescription(Integer.MAX_VALUE & emoticonSpan.index);
                    if (!TextUtils.isEmpty(faceDescription)) {
                        sb5.append(faceDescription);
                    } else {
                        QLog.e(QQTextBuilder.TAG, 1, "\u4e0d\u652f\u6301\u7684\u8868\u60c5");
                    }
                } else if (i17 == 2) {
                    sb5.append(emoticonSpan.getDescription());
                }
                i3++;
                i16 = spanEnd;
            } else {
                QLog.e("InputViewPanelControl", 1, "span error");
                break;
            }
        }
        if (i16 < charArray.length) {
            sb5.append(charArray, i16, charArray.length - i16);
        }
        return sb5.toString();
    }

    public static String g(EditText editText) {
        QQTextBuilder qQTextBuilder;
        if (editText != null) {
            if ((editText.getText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) editText.getText()) != null) {
                RFWLog.d("InputViewPanelControl", RFWLog.CLR, " get plain text is " + qQTextBuilder.toPlainText());
                return qQTextBuilder.toPlainText();
            }
            if (editText.getEditableText() != null) {
                RFWLog.d("InputViewPanelControl", RFWLog.CLR, " get plain text is " + editText.getEditableText().toString());
                return editText.getEditableText().toString();
            }
        }
        QLog.e("InputViewPanelControl", 1, "get plain text is null");
        return null;
    }

    public static String f(EditText editText, List<Friend> list, boolean z16) {
        if (editText != null) {
            String g16 = g(editText);
            if (!TextUtils.isEmpty(g16)) {
                String b16 = b(g16, list, z16);
                RFWLog.i("InputViewPanelControl", RFWLog.CLR, "string after replace is " + b16);
                return QzoneEmotionUtils.splash2Emo(b16.replaceAll(com.qzone.util.l.a(R.string.f172111ng0), com.qzone.util.l.a(R.string.f172113ng2)).replaceAll(com.qzone.util.l.a(R.string.nfz), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2192465w), "/chigua"));
            }
            return "";
        }
        return "";
    }

    public static String a(String str, List<Friend> list, boolean z16) {
        if (str == null) {
            QLog.e("InputViewPanelControl", 1, "con is empty");
            return null;
        }
        if (list == null || list.size() == 0) {
            return str;
        }
        for (Friend friend : list) {
            String str2 = friend.mName;
            if (str2 == null) {
                str2 = friend.mUin + "";
            }
            String replace = str2.replace("%", "%25").replace(",", "%2C").replace("}", "%7D");
            if (z16) {
                replace = replace.replace("{", "%7B").replace(":", "%3A").replace(">", "%3E");
            }
            String str3 = "@{uin:" + friend.mUin + ",nick:" + replace + "}";
            String str4 = "@" + m(friend.mName);
            if (!TextUtils.isEmpty(friend.mName) && str.contains(str4)) {
                str = com.qzone.util.am.j(str4, str, str3);
            }
        }
        return str;
    }

    public static boolean l(MotionEvent motionEvent, EditText editText, int i3, int i16, View view) {
        if (editText != null) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) (motionEvent.getY() + i3 + i16);
            Rect h16 = h(editText);
            if (h16 != null && h16.contains(x16, y16)) {
                return true;
            }
        }
        if (view == null) {
            return false;
        }
        int x17 = (int) motionEvent.getX();
        int y17 = (int) (motionEvent.getY() + i3 + i16);
        Rect h17 = h(view);
        return h17 != null && h17.contains(x17, y17);
    }

    public static int e(CharSequence charSequence, int i3, int i16, List<Friend> list, int i17, int i18, String str) {
        if (charSequence != null) {
            if (charSequence.length() > 1) {
                int length = charSequence.length() > i3 ? i3 : charSequence.length();
                int i19 = length - 1;
                for (int i26 = 1; i19 >= 0 && i26 <= i16; i26++) {
                    if (charSequence.charAt(i19) == '@' && j(charSequence.toString().substring(i19, length), false, list, i17, i18, str)) {
                        return i19;
                    }
                    i19--;
                }
            }
        }
        return -1;
    }

    public static Rect h(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
    }

    public static boolean k(MotionEvent motionEvent, View view, int i3, int i16) {
        if (motionEvent != null && view != null) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) (motionEvent.getY() + i3 + i16);
            Rect h16 = h(view);
            if (h16 != null && h16.contains(x16, y16)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(int i3, int i16, String str) {
        return (i3 == -1 || i16 == -1 || str == null || str.length() <= 0) ? false : true;
    }
}
