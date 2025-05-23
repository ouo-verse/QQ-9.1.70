package com.tencent.camerasdk.avreport;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class AEKitReportEvent {
    private static final /* synthetic */ AEKitReportEvent[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AEKitReportEvent PREVIEW_FIRST_FRAME;
    public static final AEKitReportEvent PREVIEW_PERFORMANCE;
    public static final AEKitReportEvent PREVIEW_TNN_MATERIAL;
    public static final AEKitReportEvent SELECT_STICKER;
    public String value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AEKitReportEvent aEKitReportEvent = new AEKitReportEvent("SELECT_STICKER", 0, "aekit_select_motion");
        SELECT_STICKER = aEKitReportEvent;
        AEKitReportEvent aEKitReportEvent2 = new AEKitReportEvent("PREVIEW_PERFORMANCE", 1, "aekit_preview_performance");
        PREVIEW_PERFORMANCE = aEKitReportEvent2;
        AEKitReportEvent aEKitReportEvent3 = new AEKitReportEvent("PREVIEW_FIRST_FRAME", 2, "aekit_first_frame");
        PREVIEW_FIRST_FRAME = aEKitReportEvent3;
        AEKitReportEvent aEKitReportEvent4 = new AEKitReportEvent("PREVIEW_TNN_MATERIAL", 3, "aekit_tnn_material");
        PREVIEW_TNN_MATERIAL = aEKitReportEvent4;
        $VALUES = new AEKitReportEvent[]{aEKitReportEvent, aEKitReportEvent2, aEKitReportEvent3, aEKitReportEvent4};
    }

    AEKitReportEvent(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.value = str2;
        }
    }

    public static AEKitReportEvent valueOf(String str) {
        return (AEKitReportEvent) Enum.valueOf(AEKitReportEvent.class, str);
    }

    public static AEKitReportEvent[] values() {
        return (AEKitReportEvent[]) $VALUES.clone();
    }
}
