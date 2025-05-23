package com.tencent.turingcam;

import android.hardware.Camera;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.DO0IX;
import com.tencent.turingcam.s5pTT;
import com.tencent.turingcam.spXPg;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public class fa2Ik extends spXPg {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static final String f382241g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f382242h;

    /* renamed from: b, reason: collision with root package name */
    private String f382243b;

    /* renamed from: c, reason: collision with root package name */
    private int f382244c;

    /* renamed from: d, reason: collision with root package name */
    private int f382245d;

    /* renamed from: e, reason: collision with root package name */
    private int f382246e;

    /* renamed from: f, reason: collision with root package name */
    private long f382247f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21564);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382241g = FxCVY.b("XrAtCLyRZD+iVG+xiPkUocfEh7sxA2as2/upDg==");
            f382242h = FxCVY.b("QkyoZDoA2EfeXs1uxHxbayaYRl76hMTg");
        }
    }

    public fa2Ik() {
        super("4");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382245d = -1;
            this.f382247f = 0L;
        }
    }

    @Override // com.tencent.turingcam.spXPg
    public long a(DO0IX.spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) spxpg)).longValue();
        }
        this.f382245d = -1;
        this.f382243b = spxpg.d();
        this.f382244c = spxpg.a(5);
        Camera a16 = spxpg.a();
        s5pTT.spXPg spxpg2 = new s5pTT.spXPg();
        if (!s5pTT.a(a16, f382241g, spxpg2)) {
            G2SZT.b().a("checker_start_codes", a(), String.valueOf(TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS));
            return TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS;
        }
        this.f382246e = ((Integer) spxpg2.a()).intValue();
        if (a16 != null && !TextUtils.isEmpty(this.f382243b)) {
            G2SZT.b().a("checker_start_codes", a(), String.valueOf(0L));
            return 0L;
        }
        G2SZT.b().a("checker_start_codes", a(), String.valueOf(TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS));
        return TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS;
    }

    @Override // com.tencent.turingcam.spXPg
    public boolean a(spXPg.C10028spXPg c10028spXPg, Camera camera2, EQsUZ eQsUZ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, c10028spXPg, camera2, eQsUZ)).booleanValue();
        }
        if (this.f382245d < 0) {
            byte[] bArr = c10028spXPg.f382373b;
            byte[] bytes = this.f382243b.getBytes();
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            WeakReference weakReference = new WeakReference(camera2);
            Class cls = Integer.TYPE;
            if (!s5pTT.a(camera2, f382242h, new Class[]{Object.class, cls, cls, cls, Object.class}, new Object[]{weakReference, Integer.valueOf(this.f382246e), 0, 0, bArr2})) {
                return true;
            }
            this.f382247f = System.currentTimeMillis();
            this.f382245d++;
            return false;
        }
        if (this.f382247f > c10028spXPg.f382372a) {
            return false;
        }
        int length = this.f382243b.getBytes().length;
        byte[] bArr3 = new byte[length];
        System.arraycopy(c10028spXPg.f382373b, 0, bArr3, 0, length);
        uAnWx uanwx = new uAnWx();
        uanwx.f382396a = a();
        uanwx.f382397b = this.f382245d;
        uanwx.f382398c = bArr3;
        eQsUZ.f381792a.add(uanwx);
        Arrays.equals(bArr3, this.f382243b.getBytes());
        int i3 = this.f382245d + 1;
        this.f382245d = i3;
        return i3 > this.f382244c;
    }
}
