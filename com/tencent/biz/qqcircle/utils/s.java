package com.tencent.biz.qqcircle.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.R;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;

/* compiled from: P */
/* loaded from: classes5.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static final long[] f92781a = new long[8];

    public static void a(Context context, String str) {
        if (b()) {
            QCircleToast.o(h.a(R.string.f189283yz), 0);
            return;
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getApplicationContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                QLog.e("QCircleCopyUtils", 1, "copyTextToClipboard  clipboardManager == null");
                return;
            } else {
                ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("", RichTextAtParser.changeAT2PlainText(str)));
                return;
            }
        }
        QLog.e("QCircleCopyUtils", 1, "copyTextToClipboard  context == null || TextUtils.isEmpty(text)");
    }

    private static boolean b() {
        long[] jArr = f92781a;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long uptimeMillis = SystemClock.uptimeMillis();
        jArr[jArr.length - 1] = uptimeMillis;
        if (uptimeMillis - jArr[0] <= 10000) {
            return true;
        }
        return false;
    }
}
