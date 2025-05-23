package com.tencent.lightquic.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/lightquic/api/QUICVersion;", "", "version", "", "(Ljava/lang/String;II)V", "getVersion", "()I", "GQUIC_43", "GQUIC_46", "IQUIC_RFC9000", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class QUICVersion {
    private static final /* synthetic */ QUICVersion[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QUICVersion GQUIC_43;
    public static final QUICVersion GQUIC_46;
    public static final QUICVersion IQUIC_RFC9000;
    private final int version;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8334);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        QUICVersion qUICVersion = new QUICVersion("GQUIC_43", 0, 43);
        GQUIC_43 = qUICVersion;
        QUICVersion qUICVersion2 = new QUICVersion("GQUIC_46", 1, 46);
        GQUIC_46 = qUICVersion2;
        QUICVersion qUICVersion3 = new QUICVersion("IQUIC_RFC9000", 2, 80);
        IQUIC_RFC9000 = qUICVersion3;
        $VALUES = new QUICVersion[]{qUICVersion, qUICVersion2, qUICVersion3};
    }

    QUICVersion(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.version = i16;
        }
    }

    public static QUICVersion valueOf(String str) {
        return (QUICVersion) Enum.valueOf(QUICVersion.class, str);
    }

    public static QUICVersion[] values() {
        return (QUICVersion[]) $VALUES.clone();
    }

    public final int getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.version;
    }
}
