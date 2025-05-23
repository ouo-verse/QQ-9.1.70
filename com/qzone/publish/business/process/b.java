package com.qzone.publish.business.process;

import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.process.base.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f51047a;

        static {
            int[] iArr = new int[QZoneProcessType.values().length];
            f51047a = iArr;
            try {
                iArr[QZoneProcessType.PROCESS_TYPE_QCIRCLE_COMPRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51047a[QZoneProcessType.PROCESS_TYPE_QCIRCLE_EXPORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> com.qzone.publish.business.process.base.a a(T t16, QZoneProcessType qZoneProcessType, a.InterfaceC0438a<T> interfaceC0438a) {
        int i3 = a.f51047a[qZoneProcessType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
        } else if (t16 instanceof ShuoshuoVideoInfo) {
            return new c((ShuoshuoVideoInfo) t16, interfaceC0438a);
        }
        if (t16 instanceof ShuoshuoVideoInfo) {
            return new d((ShuoshuoVideoInfo) t16, interfaceC0438a);
        }
        return null;
    }
}
