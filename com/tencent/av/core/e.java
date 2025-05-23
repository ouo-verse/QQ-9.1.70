package com.tencent.av.core;

import android.text.TextUtils;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.i;
import com.tencent.avcore.jni.dav.NtrtcRoom;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final VcControllerImpl f73572a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Long, HashMap<String, Object>> f73573b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(VcControllerImpl vcControllerImpl) {
        this.f73572a = vcControllerImpl;
    }

    private boolean a(boolean z16, boolean z17, boolean z18) {
        if (!z17 && (z16 || z18)) {
            return false;
        }
        return true;
    }

    private boolean b(boolean z16, boolean z17, boolean z18) {
        if (!z16 && (z17 || z18)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int d(long j3, String str, boolean z16, boolean z17, int i3) {
        int i16;
        boolean z18;
        String str2;
        boolean z19 = false;
        if (b(z16, z17, false)) {
            Object h16 = h(j3, str);
            if (h16 instanceof Integer) {
                i16 = ((Integer) h16).intValue();
                if (i16 != i3) {
                    z18 = true;
                    if (a(z16, z17, z18)) {
                        try {
                            str2 = NtrtcRoom.getInstance().getAVSDKInfo(j3, str);
                        } catch (UnsatisfiedLinkError e16) {
                            k("getAVSDKInfo", e16);
                            str2 = null;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                i16 = Integer.parseInt(str2);
                                j(j3, str, Integer.valueOf(i16));
                                if (i16 != i3) {
                                    z19 = true;
                                }
                                z18 = z19;
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("JniSimpleInfoMng", 2, "getIntegerValue, [peerUin: " + j3 + ", onlyFromCache: " + z16 + ", onlyFromAVSDK: " + z17 + ", ret: " + z18 + ", key: " + str + ", value: " + i16 + ", default: " + i3 + "]");
                    }
                    return i16;
                }
                z18 = false;
                if (a(z16, z17, z18)) {
                }
                if (QLog.isColorLevel()) {
                }
                return i16;
            }
        }
        i16 = i3;
        z18 = false;
        if (a(z16, z17, z18)) {
        }
        if (QLog.isColorLevel()) {
        }
        return i16;
    }

    private HashMap<String, Object> e(long j3) {
        HashMap<String, Object> hashMap = this.f73573b.get(Long.valueOf(j3));
        if (hashMap == null) {
            synchronized (this.f73573b) {
                hashMap = this.f73573b.get(Long.valueOf(j3));
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    this.f73573b.put(Long.valueOf(j3), hashMap);
                }
            }
        }
        return hashMap;
    }

    public static long i(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return i.g(str);
        } catch (NumberFormatException e16) {
            QLog.i("JniSimpleInfoMng", 1, "parseUin", e16);
            return -1L;
        } catch (Throwable th5) {
            QLog.i("JniSimpleInfoMng", 1, "parseUin", th5);
            return -1L;
        }
    }

    private void k(String str, UnsatisfiedLinkError unsatisfiedLinkError) {
        QLog.i("JniSimpleInfoMng", 1, "updateSoFail, from[" + str + "]", unsatisfiedLinkError);
        AVSoUtils.L(BaseApplication.getContext(), "qav_rtc_sdk");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j3) {
        HashMap<String, Object> e16 = e(j3);
        if (e16 != null) {
            e16.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.i("JniSimpleInfoMng", 2, "clearInfoForClose, peerUin[" + j3 + "]");
        }
    }

    public int f(String str, boolean z16, boolean z17) {
        return d(i(str), "PeerSdkVersion", z16, z17, 0);
    }

    public int g(String str, boolean z16, boolean z17) {
        return d(i(str), "PeerTerminalType", z16, z17, 0);
    }

    public Object h(long j3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return e(j3).get(str);
    }

    public void j(long j3, String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e(j3).put(str, obj);
    }
}
