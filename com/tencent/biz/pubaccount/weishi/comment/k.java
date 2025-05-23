package com.tencent.biz.pubaccount.weishi.comment;

import NS_KING_SOCIALIZE_META.stMetaPerson;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {
    public static boolean a(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static stSimpleComment d(stSimpleMetaComment stsimplemetacomment, stSimpleMetaPerson stsimplemetaperson) {
        stSimpleMetaPerson stsimplemetaperson2 = stsimplemetacomment.poster;
        if (!TextUtils.isEmpty(stsimplemetaperson2.nick)) {
            stsimplemetaperson = stsimplemetaperson2;
        }
        return new stSimpleComment(stsimplemetacomment.f25128id, stsimplemetacomment.wording, stsimplemetacomment.poster_id, c(stsimplemetaperson), stsimplemetacomment.dingNum, stsimplemetacomment.isDing, stsimplemetacomment.feedId, null);
    }

    public static boolean g(String str, boolean z16, List<WSCommentFriendBaseInfo> list, int i3, int i16, String str2) {
        String name;
        if ((f(i3, i16, str2) || !z16) && list != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                WSCommentFriendBaseInfo wSCommentFriendBaseInfo = list.get(i17);
                if (wSCommentFriendBaseInfo != null && (name = wSCommentFriendBaseInfo.getName()) != null && str != null) {
                    if (!str.equalsIgnoreCase("@" + name)) {
                        if (str.equalsIgnoreCase("@" + name + " ")) {
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

    public static void h(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = view.getHeight();
        layoutParams.weight = 0.0f;
        view.setLayoutParams(layoutParams);
    }

    public static String i(QQTextBuilder qQTextBuilder) {
        int length;
        int length2 = qQTextBuilder.length();
        char[] cArr = new char[length2];
        qQTextBuilder.getChars(0, length2, cArr, 0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArr);
        int i3 = 0;
        for (EmoticonSpan emoticonSpan : (EmoticonSpan[]) qQTextBuilder.getSpans(0, length2, EmoticonSpan.class)) {
            int spanStart = qQTextBuilder.getSpanStart(emoticonSpan);
            int spanEnd = qQTextBuilder.getSpanEnd(emoticonSpan);
            int i16 = emoticonSpan.emojiType;
            if (i16 == 0) {
                try {
                    String emojiString = com.tencent.mobileqq.text.TextUtils.getEmojiString(emoticonSpan.index);
                    stringBuffer.replace(spanStart + i3, spanEnd + i3, emojiString);
                    length = emojiString.length();
                } catch (Exception e16) {
                    x.f("WSCommentUtil", e16.getMessage());
                }
            } else if (i16 == 1) {
                String faceDescription = QQSysFaceUtil.getFaceDescription(emoticonSpan.index & Integer.MAX_VALUE);
                stringBuffer.replace(spanStart + i3, spanEnd + i3, faceDescription);
                length = faceDescription.length();
            } else if (i16 == 2) {
                String description = emoticonSpan.getDescription();
                stringBuffer.replace(spanStart + i3, spanEnd + i3, description);
                length = description.length();
            }
            i3 += length - (spanEnd - spanStart);
        }
        return stringBuffer.toString();
    }

    public static void k(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.weight = 1.0f;
        view.setLayoutParams(layoutParams);
    }

    public static stMetaPerson c(stSimpleMetaPerson stsimplemetaperson) {
        return new stMetaPerson(stsimplemetaperson.f25130id, stsimplemetaperson.type, stsimplemetaperson.uid, stsimplemetaperson.createtime, stsimplemetaperson.nick, stsimplemetaperson.avatar, stsimplemetaperson.sex, "", "", "", "", "", "", -1, 0, "");
    }

    public static void j(Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        if (decorView instanceof ViewGroup) {
            View childAt = ((ViewGroup) decorView).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2 == null || childAt2.getId() == 16908290) {
                        return;
                    }
                    if (!(childAt2 instanceof ViewStub)) {
                        childAt2.setAlpha(0.0f);
                    }
                }
            }
        }
    }

    public static int e(CharSequence charSequence, int i3, int i16, List<WSCommentFriendBaseInfo> list, int i17, int i18, String str) {
        if (charSequence != null) {
            if (charSequence.length() > 1) {
                int min = Math.min(charSequence.length(), i3);
                int i19 = min - 1;
                for (int i26 = 1; i19 >= 0 && i26 <= i16; i26++) {
                    if (charSequence.charAt(i19) == '@' && g(charSequence.toString().substring(i19, min), false, list, i17, i18, str)) {
                        return i19;
                    }
                    i19--;
                }
            }
        }
        return -1;
    }

    public static boolean b(Context context, View view) {
        if (view == null) {
            return false;
        }
        if (context == null) {
            try {
                context = view.getContext();
            } catch (Exception e16) {
                x.d(e16.getLocalizedMessage());
            }
        }
        if (context != null) {
            if (context instanceof Activity) {
                if (a(context)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean f(int i3, int i16, String str) {
        return (i3 == -1 || i16 == -1 || str == null || str.length() <= 0) ? false : true;
    }
}
