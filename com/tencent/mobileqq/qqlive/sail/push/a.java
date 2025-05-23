package com.tencent.mobileqq.qqlive.sail.push;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.nano.MessageNano;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import fp4.c;
import g55.ag;
import g55.au;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nr4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qq4.b;
import rr4.e;
import sq4.d;
import sr4.i;
import tl.h;
import ur4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\f\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0000\u001a\f\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0000\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u0000\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u0000\u001a\f\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0000\u001a\f\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u00020\u0000\u001a\f\u0010\u0017\u001a\u0004\u0018\u00010\r*\u00020\u0000\u001a\f\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0000\u001a\f\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u0000\u001a\f\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0000\u001a\f\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\u0000\u001a\f\u0010!\u001a\u0004\u0018\u00010 *\u00020\u0000\u001a\f\u0010#\u001a\u0004\u0018\u00010\"*\u00020\u0000\u001a\f\u0010%\u001a\u0004\u0018\u00010$*\u00020\u0000\u001a\f\u0010'\u001a\u0004\u0018\u00010&*\u00020\u0000\u001a\f\u0010)\u001a\u0004\u0018\u00010(*\u00020\u0000\u001a\f\u0010+\u001a\u0004\u0018\u00010**\u00020\u0000\u001a\f\u0010-\u001a\u0004\u0018\u00010,*\u00020\u0000\u001a\f\u0010/\u001a\u0004\u0018\u00010.*\u00020\u0000\u001a\f\u00101\u001a\u0004\u0018\u000100*\u00020\u0000\u001a\f\u00103\u001a\u0004\u0018\u000102*\u00020\u0000\u001a\f\u00105\u001a\u0004\u0018\u000104*\u00020\u0000\u001a\f\u00107\u001a\u0004\u0018\u000106*\u00020\u0000\u001a\f\u00109\u001a\u0004\u0018\u000108*\u00020\u0000\u001a\f\u0010;\u001a\u0004\u0018\u00010:*\u00020\u0000\u00a8\u0006<"}, d2 = {"Lfp4/c;", "Lcom/google/protobuf/nano/MessageNano;", "l", "Lqt3/a;", "v", "Lqq3/a;", "k", "Lrq3/a;", "d", "Li11/a;", HippyTKDListViewAdapter.X, "Lsq3/a;", BdhLogUtil.LogTag.Tag_Conn, "Lgp4/a;", "g", "Lmt3/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lyq4/a;", "p", "Lhr4/f;", "j", "Lxq4/a;", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lyo4/b;", "f", "Lqq4/a;", "r", "Lmr4/a;", "u", "Lsr4/i;", "D", "Lnr4/f;", h.F, "Lrr4/e;", "i", "Lh55/b;", "b", "Lh55/a;", "a", "Lg55/ag;", "o", "Lg55/au;", ReportConstant.COSTREPORT_PREFIX, "Lnr4/h;", "e", "Lur4/n;", "w", "Lqq4/b;", "B", "Lar4/a;", DomainData.DOMAIN_NAME, "Lsq4/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsq4/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lsq4/b;", "y", "Lwq4/a;", "t", "qq-live-sdk-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final d A(@NotNull c cVar) {
        boolean z16;
        d c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 112) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = d.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=112");
            }
            if (c16 instanceof d) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof d) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final b B(@NotNull c cVar) {
        boolean z16;
        b c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 110) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = b.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=110");
            }
            if (c16 instanceof b) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof b) {
        }
    }

    @Nullable
    public static final sq3.a C(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        MessageNano l3 = l(cVar);
        if (l3 instanceof sq3.a) {
            return (sq3.a) l3;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final i D(@NotNull c cVar) {
        boolean z16;
        i c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 55) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = i.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=55");
            }
            if (c16 instanceof i) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof i) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final h55.a a(@NotNull c cVar) {
        boolean z16;
        h55.a c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 105) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = h55.a.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=105");
            }
            if (c16 instanceof h55.a) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof h55.a) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final h55.b b(@NotNull c cVar) {
        boolean z16;
        h55.b c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 104) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = h55.b.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=104");
            }
            if (c16 instanceof h55.b) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof h55.b) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final xq4.a c(@NotNull c cVar) {
        boolean z16;
        xq4.a c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 18) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = xq4.a.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=18");
            }
            if (c16 instanceof xq4.a) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof xq4.a) {
        }
    }

    @Nullable
    public static final rq3.a d(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        MessageNano l3 = l(cVar);
        if (l3 instanceof rq3.a) {
            return (rq3.a) l3;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final nr4.h e(@NotNull c cVar) {
        boolean z16;
        nr4.h c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 109) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = nr4.h.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=109");
            }
            if (c16 instanceof nr4.h) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof nr4.h) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final yo4.b f(@NotNull c cVar) {
        boolean z16;
        yo4.b c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 52) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = yo4.b.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=52");
            }
            if (c16 instanceof yo4.b) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof yo4.b) {
        }
    }

    @Nullable
    public static final gp4.a g(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        MessageNano l3 = l(cVar);
        if (l3 instanceof gp4.a) {
            return (gp4.a) l3;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final f h(@NotNull c cVar) {
        boolean z16;
        f c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 21) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = f.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=21");
            }
            if (c16 instanceof f) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof f) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final e i(@NotNull c cVar) {
        boolean z16;
        e c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 103) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = e.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=103");
            }
            if (c16 instanceof e) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof e) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final hr4.f j(@NotNull c cVar) {
        boolean z16;
        hr4.f c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 19) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = hr4.f.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=19");
            }
            if (c16 instanceof hr4.f) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof hr4.f) {
        }
    }

    @Nullable
    public static final qq3.a k(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        MessageNano l3 = l(cVar);
        if (l3 instanceof qq3.a) {
            return (qq3.a) l3;
        }
        return null;
    }

    @Nullable
    public static final MessageNano l(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Function1<c, MessageNano> b16 = PushCmdHandler.f272371a.b(cVar.f400284b);
        if (b16 != null) {
            return b16.invoke(cVar);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final mt3.e m(@NotNull c cVar) {
        boolean z16;
        mt3.e c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = mt3.e.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=16");
            }
            if (c16 instanceof mt3.e) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof mt3.e) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ar4.a n(@NotNull c cVar) {
        boolean z16;
        ar4.a c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 111) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = ar4.a.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=111");
            }
            if (c16 instanceof ar4.a) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof ar4.a) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ag o(@NotNull c cVar) {
        boolean z16;
        ag c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 106) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = ag.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=106");
            }
            if (c16 instanceof ag) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof ag) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final yq4.a p(@NotNull c cVar) {
        boolean z16;
        yq4.a c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 15) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = yq4.a.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=15");
            }
            if (c16 instanceof yq4.a) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof yq4.a) {
        }
    }

    @Nullable
    public static final gp4.a q(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 != null && g16.f403047a == 100) {
            return g16;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final qq4.a r(@NotNull c cVar) {
        boolean z16;
        qq4.a c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 101) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = qq4.a.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=101");
            }
            if (c16 instanceof qq4.a) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof qq4.a) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final au s(@NotNull c cVar) {
        boolean z16;
        au c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 107) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = au.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=107");
            }
            if (c16 instanceof au) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof au) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final wq4.a t(@NotNull c cVar) {
        boolean z16;
        wq4.a c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 115) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = wq4.a.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=115");
            }
            if (c16 instanceof wq4.a) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof wq4.a) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final mr4.a u(@NotNull c cVar) {
        boolean z16;
        mr4.a c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 102) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = mr4.a.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=102");
            }
            if (c16 instanceof mr4.a) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof mr4.a) {
        }
    }

    @Nullable
    public static final qt3.a v(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        MessageNano l3 = l(cVar);
        if (l3 instanceof qt3.a) {
            return (qt3.a) l3;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final n w(@NotNull c cVar) {
        boolean z16;
        n c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 108) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = n.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=108");
            }
            if (c16 instanceof n) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof n) {
        }
    }

    @Nullable
    public static final i11.a x(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        MessageNano l3 = l(cVar);
        if (l3 instanceof i11.a) {
            return (i11.a) l3;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final sq4.b y(@NotNull c cVar) {
        boolean z16;
        sq4.b c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 114) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = sq4.b.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=114");
            }
            if (c16 instanceof sq4.b) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof sq4.b) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final sq4.c z(@NotNull c cVar) {
        boolean z16;
        sq4.c c16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        gp4.a g16 = g(cVar);
        if (g16 == null) {
            return null;
        }
        if (g16.f403047a == 113) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                c16 = sq4.c.c(g16.f403049c);
            } catch (Exception unused) {
                AegisLogger.INSTANCE.w("Push|PushCmdHandler", "subCmdParse", "parse error, subCmd=113");
            }
            if (c16 instanceof sq4.c) {
                return null;
            }
            return c16;
        }
        c16 = null;
        if (c16 instanceof sq4.c) {
        }
    }
}
