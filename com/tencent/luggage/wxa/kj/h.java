package com.tencent.luggage.wxa.kj;

import com.tencent.luggage.wxa.ic.e;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.xd.p {
    private static final int CTRL_INDEX = 49;
    public static final String NAME = "onAppEnterBackground";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f132208a;

        static {
            int[] iArr = new int[e.d.values().length];
            f132208a = iArr;
            try {
                iArr[e.d.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f132208a[e.d.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f132208a[e.d.LAUNCH_NATIVE_PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f132208a[e.d.HOME_PRESSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f132208a[e.d.HIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f132208a[e.d.HANG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f132208a[e.d.LAUNCH_MINI_PROGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        HashMap hashMap = new HashMap(1);
        String str = "hide";
        switch (a.f132208a[com.tencent.luggage.wxa.ic.e.d(gVar.getAppId()).ordinal()]) {
            case 1:
                str = "close";
                break;
            case 2:
                str = "back";
                break;
            case 6:
                str = "hang";
                break;
            case 7:
                str = "launchMiniProgram";
                break;
        }
        hashMap.put("mode", str);
        setData(hashMap).setContext(gVar.h0()).dispatch();
    }
}
