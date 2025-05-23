package com.tencent.qqnt.emotion.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/emotion/utils/c;", "", "", "emojiId", "", "emojiType", "b", "a", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f356686a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f356686a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(@Nullable String emojiId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) emojiId, emojiType)).intValue();
        }
        if (TextUtils.isEmpty(emojiId)) {
            return -1;
        }
        try {
            Integer valueOf = Integer.valueOf(emojiId);
            Intrinsics.checkNotNullExpressionValue(valueOf, "{\n            Integer.valueOf(emojiId)\n        }");
            int intValue = valueOf.intValue();
            if (emojiType != 1) {
                if (emojiType != 2) {
                    return -1;
                }
                return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getServerId(intValue);
            }
            return QQSysFaceUtil.convertToServer(intValue);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final int b(@Nullable String emojiId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) emojiId, emojiType)).intValue();
        }
        int i3 = -1;
        if (TextUtils.isEmpty(emojiId)) {
            QLog.i("EmojiSpanUtils", 1, "[serverToLocal]: emojiId is " + emojiId);
            return -1;
        }
        try {
            Integer valueOf = Integer.valueOf(emojiId);
            Intrinsics.checkNotNullExpressionValue(valueOf, "{\n            Integer.valueOf(emojiId)\n        }");
            int intValue = valueOf.intValue();
            if (emojiType != 1) {
                if (emojiType != 2) {
                    QLog.e("EmojiSpanUtils", 1, "[serverToLocal] error, emojiId is " + emojiId + ", emojiType is " + emojiType);
                } else {
                    i3 = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getLocalId(intValue);
                }
            } else {
                i3 = QQSysFaceUtil.convertToLocal(intValue);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("EmojiSpanUtils", 4, "[serverToLocal]: emojiId is " + emojiId + ", emojiType is " + emojiType + " localId is " + i3);
            }
            return i3;
        } catch (NumberFormatException e16) {
            QLog.i("EmojiSpanUtils", 1, "[serverToLocal]: emojiId is " + emojiId + ", exception is " + e16);
            return -1;
        }
    }
}
