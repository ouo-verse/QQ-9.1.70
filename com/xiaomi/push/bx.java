package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bx {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388339a;

        static {
            int[] iArr = new int[gf.values().length];
            f388339a = iArr;
            try {
                iArr[gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388339a[gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388339a[gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388339a[gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f388339a[gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f388339a[gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f388339a[gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f388339a[gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f388339a[gf.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f388339a[gf.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f388339a[gf.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f388339a[gf.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static int a(Context context, int i3) {
        int i16;
        int a16 = fo.a(context);
        if (-1 == a16) {
            return -1;
        }
        if (a16 == 0) {
            i16 = 13;
        } else {
            i16 = 11;
        }
        return (i3 * i16) / 10;
    }

    public static int b(gf gfVar) {
        return de.a(gfVar.a());
    }

    public static int c(hq hqVar, gf gfVar) {
        int a16;
        switch (a.f388339a[gfVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return de.a(gfVar.a());
            case 11:
                a16 = de.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof gw) {
                            String str = ((gw) hqVar).f389213d;
                            if (!TextUtils.isEmpty(str) && de.b(de.d(str)) != -1) {
                                a16 = de.b(de.d(str));
                                break;
                            }
                        } else if (hqVar instanceof he) {
                            String str2 = ((he) hqVar).f389261d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (de.b(de.d(str2)) != -1) {
                                    a16 = de.b(de.d(str2));
                                }
                                if (gp.UploadTinyData.equals(de.d(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        jz4.c.B("PERF_ERROR : parse Notification type error");
                        return a16;
                    }
                }
                break;
            case 12:
                a16 = de.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof ha) {
                            String b16 = ((ha) hqVar).b();
                            if (!TextUtils.isEmpty(b16) && ed.a(b16) != -1) {
                                a16 = ed.a(b16);
                                break;
                            }
                        } else if (hqVar instanceof gz) {
                            String a17 = ((gz) hqVar).a();
                            if (!TextUtils.isEmpty(a17) && ed.a(a17) != -1) {
                                return ed.a(a17);
                            }
                        }
                    } catch (Exception unused2) {
                        jz4.c.B("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a16;
    }

    public static void d(String str, Context context, int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            int a16 = a(context, i16);
            if (i3 != de.b(gp.UploadTinyData)) {
                df.a(context.getApplicationContext()).b(str, i3, 1L, a16);
            }
        }
    }

    public static void e(String str, Context context, hb hbVar, int i3) {
        gf a16;
        int i16;
        if (context != null && hbVar != null && (a16 = hbVar.a()) != null) {
            int b16 = b(a16);
            if (i3 <= 0) {
                byte[] e16 = fv.e(hbVar);
                if (e16 != null) {
                    i16 = e16.length;
                } else {
                    i16 = 0;
                }
                i3 = i16;
            }
            d(str, context, b16, i3);
        }
    }

    public static void f(String str, Context context, hq hqVar, gf gfVar, int i3) {
        d(str, context, c(hqVar, gfVar), i3);
    }

    public static void g(String str, Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            hb hbVar = new hb();
            try {
                fv.d(hbVar, bArr);
                e(str, context, hbVar, bArr.length);
            } catch (hu unused) {
                jz4.c.m("fail to convert bytes to container");
            }
        }
    }
}
