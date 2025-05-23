package com.tencent.mobileqq.forward.preview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/forward/preview/ForwardPreviewConst$PreviewType", "", "Lcom/tencent/mobileqq/forward/preview/ForwardPreviewConst$PreviewType;", "<init>", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "SHARE_ACTION_SHEET", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ForwardPreviewConst$PreviewType {
    private static final /* synthetic */ ForwardPreviewConst$PreviewType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ForwardPreviewConst$PreviewType NORMAL;
    public static final ForwardPreviewConst$PreviewType SHARE_ACTION_SHEET;

    private static final /* synthetic */ ForwardPreviewConst$PreviewType[] $values() {
        return new ForwardPreviewConst$PreviewType[]{NORMAL, SHARE_ACTION_SHEET};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58145);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NORMAL = new ForwardPreviewConst$PreviewType(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0);
        SHARE_ACTION_SHEET = new ForwardPreviewConst$PreviewType("SHARE_ACTION_SHEET", 1);
        $VALUES = $values();
    }

    ForwardPreviewConst$PreviewType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ForwardPreviewConst$PreviewType valueOf(String str) {
        return (ForwardPreviewConst$PreviewType) Enum.valueOf(ForwardPreviewConst$PreviewType.class, str);
    }

    public static ForwardPreviewConst$PreviewType[] values() {
        return (ForwardPreviewConst$PreviewType[]) $VALUES.clone();
    }
}
