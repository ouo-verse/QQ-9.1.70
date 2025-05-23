package com.tencent.luggage.wxa.e5;

import android.webkit.ConsoleMessage;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f124547a = new i();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f124548a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 2;
            iArr[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            iArr[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 4;
            iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 5;
            f124548a = iArr;
        }
    }

    public static final void a(ConsoleMessage consoleMessage, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        a(consoleMessage, tag, false, 2, null);
    }

    public static /* synthetic */ void a(ConsoleMessage consoleMessage, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        a(consoleMessage, str, z16);
    }

    public static final void a(ConsoleMessage consoleMessage, String tag, boolean z16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ConsoleMessage.MessageLevel messageLevel = consoleMessage != null ? consoleMessage.messageLevel() : null;
        int i3 = messageLevel == null ? -1 : a.f124548a[messageLevel.ordinal()];
        if (i3 != -1) {
            int i16 = 3;
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    i16 = 5;
                    if (i3 != 4) {
                        if (i3 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        i16 = 6;
                    }
                } else if (z16) {
                    i16 = 4;
                }
            }
            try {
                com.tencent.luggage.wxa.yp.b.a(i16, tag, "ConsoleMessage: message:" + consoleMessage.message() + ", sourceId:" + consoleMessage.sourceId() + ", lineNumber:" + consoleMessage.lineNumber());
            } catch (OutOfMemoryError unused) {
            }
        }
    }
}
