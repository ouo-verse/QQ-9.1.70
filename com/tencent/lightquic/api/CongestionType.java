package com.tencent.lightquic.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/lightquic/api/CongestionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CUBIC_BYTES", "RENO_BYTES", "BBR", "PCC", "GOOG_CC", "BBR_V2", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class CongestionType {
    private static final /* synthetic */ CongestionType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final CongestionType BBR;
    public static final CongestionType BBR_V2;
    public static final CongestionType CUBIC_BYTES;
    public static final CongestionType GOOG_CC;
    public static final CongestionType PCC;
    public static final CongestionType RENO_BYTES;
    private final int type;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        CongestionType congestionType = new CongestionType("CUBIC_BYTES", 0, 0);
        CUBIC_BYTES = congestionType;
        CongestionType congestionType2 = new CongestionType("RENO_BYTES", 1, 1);
        RENO_BYTES = congestionType2;
        CongestionType congestionType3 = new CongestionType("BBR", 2, 2);
        BBR = congestionType3;
        CongestionType congestionType4 = new CongestionType("PCC", 3, 3);
        PCC = congestionType4;
        CongestionType congestionType5 = new CongestionType("GOOG_CC", 4, 4);
        GOOG_CC = congestionType5;
        CongestionType congestionType6 = new CongestionType("BBR_V2", 5, 5);
        BBR_V2 = congestionType6;
        $VALUES = new CongestionType[]{congestionType, congestionType2, congestionType3, congestionType4, congestionType5, congestionType6};
    }

    CongestionType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.type = i16;
        }
    }

    public static CongestionType valueOf(String str) {
        return (CongestionType) Enum.valueOf(CongestionType.class, str);
    }

    public static CongestionType[] values() {
        return (CongestionType[]) $VALUES.clone();
    }

    public final int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.type;
    }
}
