package com.tencent.mobileqq.zplan.proxy;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J.\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/l;", "Llx4/d;", "", "tag", "message", "", "a", "", "clr", "", "t", "", "d", "i", "w", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l implements lx4.d {
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean a(String tag, String message) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean contains;
        boolean contains2;
        boolean contains3;
        boolean contains4;
        if (tag != null) {
            contains4 = StringsKt__StringsKt.contains((CharSequence) tag, (CharSequence) "lua error", true);
            if (contains4) {
                z16 = true;
                if (!z16) {
                    if (message != null) {
                        contains3 = StringsKt__StringsKt.contains((CharSequence) message, (CharSequence) "lua error", true);
                        if (contains3) {
                            z17 = true;
                            if (!z17) {
                                if (tag != null) {
                                    contains2 = StringsKt__StringsKt.contains((CharSequence) tag, (CharSequence) "luaerror", true);
                                    if (contains2) {
                                        z18 = true;
                                        if (!z18) {
                                            if (message != null) {
                                                contains = StringsKt__StringsKt.contains((CharSequence) message, (CharSequence) "luaerror", true);
                                                if (contains) {
                                                    z19 = true;
                                                    if (!z19) {
                                                        return false;
                                                    }
                                                }
                                            }
                                            z19 = false;
                                            if (!z19) {
                                            }
                                        }
                                    }
                                }
                                z18 = false;
                                if (!z18) {
                                }
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
                return true;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return true;
    }

    @Override // lx4.d
    public void d(String tag, int clr, String message, Throwable t16) {
        QLog.d(tag, clr, message, t16);
    }

    @Override // lx4.d
    public void e(String tag, int clr, String message, Throwable t16) {
        QLog.e(tag, clr, message, t16);
        if (a(tag, message)) {
            id3.c.f407549a.a(tag, message, t16);
        }
    }

    @Override // lx4.d
    public void i(String tag, int clr, String message, Throwable t16) {
        QLog.i(tag, clr, message, t16);
    }

    @Override // lx4.d
    public void w(String tag, int clr, String message, Throwable t16) {
        QLog.w(tag, clr, message, t16);
    }
}
