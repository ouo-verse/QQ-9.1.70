package com.tencent.mobileqq.dalvik;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.util.AbiUtil;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DalvikInternals {
    static IPatchRedirector $redirector_;

    public DalvikInternals() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native long find(long[] jArr, int i3, int i16, int i17, int i18, int i19, int i26, long j3, long j16, int i27, int i28, int i29, long j17);

    public static boolean loadLib(Context context) {
        if (!Build.CPU_ABI.toLowerCase(Locale.US).contains(ResourceAttributes.HostArchValues.X86) && !SoLoadUtil.l()) {
            Log.d("qq_la", AbiUtil.ARM);
            return SoLoadUtilNew.loadSoByName(context, "qq_la");
        }
        Log.d("qq_la", ResourceAttributes.HostArchValues.X86);
        return SoLoadUtil.loadNativeLibrary(context, "qq_la", 0, false, false);
    }

    public static native int modArtHeap(long[] jArr, int i3, int i16, int i17);

    public static native int modheap(long[] jArr, int i3, int i16, int i17, int i18);

    public static native int preverify(long[] jArr);

    public static native int replace(long j3, int i3, int i16);
}
