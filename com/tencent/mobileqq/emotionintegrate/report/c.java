package com.tencent.mobileqq.emotionintegrate.report;

import com.tencent.mobileqq.emotionintegrate.p;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/report/c;", "", "", "aioType", "c", "", h.F, "Lcom/tencent/mobileqq/emotionintegrate/p;", "emoticonPreviewData", "i", "a", "b", "g", "", "r5", "f", "e", "d", "I", "sChatType", "sEmotionSource", "Ljava/lang/String;", "sEmotionMD5", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f205285a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int sChatType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int sEmotionSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String sEmotionMD5;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55058);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f205285a = new c();
        sEmotionSource = -1;
        sEmotionMD5 = "";
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int c(int aioType) {
        if (aioType == 1) {
            return 1;
        }
        if (aioType == 2 || aioType == 3) {
            return 2;
        }
        if (aioType != 4) {
            switch (aioType) {
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                    return 3;
                default:
                    return 5;
            }
        }
        return 4;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            h(0);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            sEmotionSource = -1;
            sEmotionMD5 = "";
        }
    }

    public final int d(@NotNull p emoticonPreviewData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) emoticonPreviewData)).intValue();
        }
        Intrinsics.checkNotNullParameter(emoticonPreviewData, "emoticonPreviewData");
        int i3 = emoticonPreviewData.i();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return 9;
                }
                switch (i3) {
                    case 7:
                    case 9:
                        return 7;
                    case 8:
                        return 5;
                    case 10:
                        return 10;
                    case 11:
                        return 4;
                    case 12:
                    case 13:
                        return 6;
                    case 14:
                        return 12;
                    default:
                        switch (i3) {
                            case 1000:
                                return 3;
                            case 1001:
                                return 2;
                            case 1002:
                                break;
                            default:
                                return 0;
                        }
                }
            } else {
                return 8;
            }
        }
        return 1;
    }

    public final void e(@NotNull String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) r56);
        } else {
            Intrinsics.checkNotNullParameter(r56, "r5");
            ReportController.o(null, "dc00898", "", "", "0X800C590", "0X800C590", 0, 0, String.valueOf(sEmotionSource), String.valueOf(sChatType), sEmotionMD5, r56);
        }
    }

    public final void f(@NotNull String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) r56);
        } else {
            Intrinsics.checkNotNullParameter(r56, "r5");
            ReportController.o(null, "dc00898", "", "", "0X800C58F", "0X800C58F", 0, 0, String.valueOf(sEmotionSource), String.valueOf(sChatType), sEmotionMD5, r56);
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800C58E", "0X800C58E", 0, 0, String.valueOf(sEmotionSource), String.valueOf(sChatType), sEmotionMD5, "");
        }
    }

    public final void h(int aioType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, aioType);
        } else {
            sChatType = c(aioType);
        }
    }

    public final void i(@NotNull p emoticonPreviewData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonPreviewData);
            return;
        }
        Intrinsics.checkNotNullParameter(emoticonPreviewData, "emoticonPreviewData");
        sEmotionSource = d(emoticonPreviewData);
        String g16 = emoticonPreviewData.g();
        if (g16 == null) {
            g16 = "";
        }
        sEmotionMD5 = g16;
    }
}
