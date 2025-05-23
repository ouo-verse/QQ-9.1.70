package com.tencent.mobileqq.zplan.web;

import com.tencent.tavcut.core.render.exporter.MovieExporter;
import com.tencent.zplan.meme.action.MODE;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/c;", "", "", "modeStr", "Lcom/tencent/zplan/meme/action/MODE;", "b", "mode", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f336037a = new c();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f336038a;

        static {
            int[] iArr = new int[MODE.values().length];
            try {
                iArr[MODE.FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MODE.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MODE.MP4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f336038a = iArr;
        }
    }

    c() {
    }

    public final String a(MODE mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i3 = a.f336038a[mode.ordinal()];
        if (i3 == 1) {
            return "image/png";
        }
        if (i3 == 2) {
            return "image/gif";
        }
        if (i3 != 3) {
            return "image/png";
        }
        return "video/mp4";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0014. Please report as an issue. */
    public final MODE b(String modeStr) {
        Intrinsics.checkNotNullParameter(modeStr, "modeStr");
        String upperCase = modeStr.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        switch (upperCase.hashCode()) {
            case -1850236474:
                if (upperCase.equals("SHARPP")) {
                    return MODE.SHARPP;
                }
                return MODE.FRAME;
            case 70564:
                if (upperCase.equals("GIF")) {
                    return MODE.GIF;
                }
                return MODE.FRAME;
            case 76529:
                if (upperCase.equals(MovieExporter.FILE_TYPE)) {
                    return MODE.MP4;
                }
                return MODE.FRAME;
            case 79369:
                if (upperCase.equals("PNG")) {
                    return MODE.FRAME;
                }
                return MODE.FRAME;
            default:
                return MODE.FRAME;
        }
    }
}
