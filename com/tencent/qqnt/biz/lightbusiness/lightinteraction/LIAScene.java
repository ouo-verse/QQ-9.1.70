package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAScene;", "", "key", "", "(Ljava/lang/String;II)V", "getKey", "()I", "MsgList", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "light_business_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class LIAScene {
    private static final /* synthetic */ LIAScene[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LIAScene AIO;
    public static final LIAScene MsgList;
    private final int key;

    private static final /* synthetic */ LIAScene[] $values() {
        return new LIAScene[]{MsgList, AIO};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        MsgList = new LIAScene("MsgList", 0, 1);
        AIO = new LIAScene(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, 1, 2);
        $VALUES = $values();
    }

    LIAScene(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.key = i16;
        }
    }

    public static LIAScene valueOf(String str) {
        return (LIAScene) Enum.valueOf(LIAScene.class, str);
    }

    public static LIAScene[] values() {
        return (LIAScene[]) $VALUES.clone();
    }

    public final int getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.key;
    }
}
