package com.tencent.mobileqq.popanim.util;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<String> f259158a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52354);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f259158a = new SparseArray<>();
        }
    }

    public static String a(int i3, boolean z16) {
        String str;
        String str2;
        String str3 = f259158a.get(i3);
        if (str3 != null) {
            return str3;
        }
        int convertToServer = QQSysFaceUtil.convertToServer(i3);
        if (QQSysFaceUtil.isStaticFace(i3)) {
            str2 = QQSysAndEmojiResMgr.getInstance().getFullResPath(2, convertToServer);
        } else {
            if (z16) {
                str = QQSysAndEmojiResMgr.getInstance().getFullResPath(4, convertToServer);
            } else {
                str = "";
            }
            if (!new File(str).exists()) {
                str2 = QQSysAndEmojiResMgr.getInstance().getFullResPath(2, convertToServer);
            } else {
                str2 = str;
            }
        }
        if (!new File(str2).exists()) {
            int[] iArr = EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE;
            if (iArr.length > i3) {
                str2 = "id_" + iArr[i3];
            } else if (QLog.isColorLevel()) {
                QLog.e("PopOutEmoticonUtil", 1, "getEmoGifPath can not find any emoticonPath |localId=" + i3);
            }
        }
        if (z16) {
            f259158a.put(i3, str2);
        }
        return str2;
    }

    public static int b(View view, int i3) {
        view.getLocationOnScreen(new int[2]);
        return (r0[1] - i3) - 10;
    }

    public static int c(int i3, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return ((i3 - iArr[1]) - view.getHeight()) / 2;
    }

    public static boolean d(EmoticonInfo emoticonInfo) {
        if (emoticonInfo == null || !(emoticonInfo instanceof SystemAndEmojiEmoticonInfo) || ((SystemAndEmojiEmoticonInfo) emoticonInfo).emotionType != 2) {
            return false;
        }
        return true;
    }

    public static boolean e(int i3, int[] iArr) {
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(int i3, EmoticonInfo emoticonInfo, int i16) {
        boolean z16;
        boolean z17;
        if (emoticonInfo == null) {
            return false;
        }
        if (i16 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PopOutEmoticonUtil", 4, "supportPopOutEmoticon isC2C=" + z16 + " emoPanelType=" + i3);
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }
}
