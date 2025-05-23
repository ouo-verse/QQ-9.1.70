package com.tencent.qimei.report.beat;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.tmdownloader.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class BeatType {
    static IPatchRedirector $redirector_;
    public static final BeatType AUDIT;
    public static final BeatType BACKGROUND;
    public static final BeatType FORGROUND;
    public static final BeatType INIT;
    public static final BeatType NET_CHANGE;
    public static final BeatType NORMAL;
    public static final BeatType REGISTER;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BeatType[] f343360a;
    private final int controlBit;
    private final int type;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16528);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        BeatType beatType = new BeatType(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0, 0, 0);
        NORMAL = beatType;
        BeatType beatType2 = new BeatType(a.CONNTECTSTATE_INIT, 1, 1, 1);
        INIT = beatType2;
        BeatType beatType3 = new BeatType("REGISTER", 2, 2, 2);
        REGISTER = beatType3;
        BeatType beatType4 = new BeatType("AUDIT", 3, 3, 4);
        AUDIT = beatType4;
        BeatType beatType5 = new BeatType("NET_CHANGE", 4, 4, 8);
        NET_CHANGE = beatType5;
        BeatType beatType6 = new BeatType("FORGROUND", 5, 5, 0);
        FORGROUND = beatType6;
        BeatType beatType7 = new BeatType("BACKGROUND", 6, 6, 0);
        BACKGROUND = beatType7;
        f343360a = new BeatType[]{beatType, beatType2, beatType3, beatType4, beatType5, beatType6, beatType7};
    }

    public BeatType(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.type = i16;
            this.controlBit = i17;
        }
    }

    public static BeatType valueOf(String str) {
        return (BeatType) Enum.valueOf(BeatType.class, str);
    }

    public static BeatType[] values() {
        return (BeatType[]) f343360a.clone();
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.controlBit;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.type;
    }
}
