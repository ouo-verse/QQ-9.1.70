package com.tencent.av.core;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.av.mediacodec.api.IAndroidCodecHelperApi;
import com.tencent.av.so.ResMgr;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.af;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.util.AVSoProxy;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements AVSoProxy {

    /* renamed from: b, reason: collision with root package name */
    private static tw.b f73565b;

    /* renamed from: a, reason: collision with root package name */
    private final Context f73566a;

    public b(Context context) {
        this.f73566a = context;
    }

    private int a() {
        if (f73565b == null) {
            f73565b = new tw.b(af.c("machineMiddleLine"), af.c("machineHighLine"));
        }
        return f73565b.a();
    }

    @VisibleForTesting
    public ArrayList<HWCodecAbility> b(String str, Context context) {
        return ((IAndroidCodecHelperApi) QRoute.api(IAndroidCodecHelperApi.class)).checkSupportHWCodecAbility("AVSoProxyImpl", this.f73566a);
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getAVAILibDir() {
        if (TextUtils.isEmpty(ResMgr.l()) || TextUtils.isEmpty(ResMgr.k())) {
            return "";
        }
        return ("QQ_AUDIO_AI_SO_DIR=" + ResMgr.l() + ";") + "QQ_AUDIO_AI_NS_MODEL_DIR=" + ResMgr.k() + ";";
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getAVMediaEngineSoDir() {
        return ResMgr.r();
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getAVTraeSoDir() {
        return ResMgr.m();
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getAndroidCodecInfo() {
        ArrayList<HWCodecAbility> b16 = b("AVSoProxyImpl", this.f73566a);
        String str = "";
        if (b16 != null && b16.size() > 0) {
            Iterator<HWCodecAbility> it = b16.iterator();
            while (it.hasNext()) {
                HWCodecAbility next = it.next();
                int i3 = next.codecType;
                if (i3 == 1 && next.isHWCodec) {
                    str = ((str + "HWAVCDEC=1;") + "HWAVCDEC_MAXW=" + next.maxW + ";") + "HWAVCDEC_MAXH=" + next.maxH + ";";
                } else if (i3 == 2 && next.isHWCodec) {
                    str = ((str + "HWAVCENC=1;") + "HWAVCENC_MAXW=" + next.maxW + ";") + "HWAVCENC_MAXH=" + next.maxH + ";";
                } else if (i3 == 4 && next.isHWCodec) {
                    str = ((str + "HWHEVCDEC=1;") + "HWHEVCDEC_MAXW=" + next.maxW + ";") + "HWHEVCDEC_MAXH=" + next.maxH + ";";
                } else if (i3 == 8 && next.isHWCodec) {
                    str = ((str + "HWHEVCENC=1;") + "HWHEVCENC_MAXW=" + next.maxW + ";") + "HWHEVCENC_MAXH=" + next.maxH + ";";
                }
            }
            return str;
        }
        return ((("HWAVCENC=0;") + "HWAVCDEC=0;") + "HWHEVCENC=0;") + "HWHEVCDEC=0;";
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public Context getContext() {
        return this.f73566a;
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getHardwareDetectSoDir() {
        return AVSoUtils.o();
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getHevcDecSoDir() {
        return AVSoUtils.p();
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getHevcEncSoDir() {
        return AVSoUtils.r();
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public int getScreenShareDecLevel() {
        return vu.a.c().b().decodeInt("KEY_MAX_RENDER_LEVEL", 2);
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public int getScreenShareEncLevel() {
        boolean z16;
        int a16 = a();
        if (Build.VERSION.SDK_INT < 29) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (a16 == 3 || z16) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public String getVideoSRSoDir() {
        return AVSoUtils.v();
    }

    @Override // com.tencent.avcore.util.AVSoProxy
    public void updateHevcCodecSoDir() {
        AVSoUtils.M();
    }
}
