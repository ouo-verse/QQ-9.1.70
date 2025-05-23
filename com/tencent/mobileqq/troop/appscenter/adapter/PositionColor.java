package com.tencent.mobileqq.troop.appscenter.adapter;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/PositionColor;", "", "colorResId", "", "(Ljava/lang/String;II)V", "getColorResId", "()I", "POSITION_0", "POSITION_1", "POSITION_2", "DEFAULT", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class PositionColor {
    private static final /* synthetic */ PositionColor[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PositionColor DEFAULT;
    public static final PositionColor POSITION_0;
    public static final PositionColor POSITION_1;
    public static final PositionColor POSITION_2;
    private final int colorResId;

    private static final /* synthetic */ PositionColor[] $values() {
        return new PositionColor[]{POSITION_0, POSITION_1, POSITION_2, DEFAULT};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        POSITION_0 = new PositionColor("POSITION_0", 0, R.color.qui_common_feedback_warning);
        POSITION_1 = new PositionColor("POSITION_1", 1, R.color.qui_common_feedback_success);
        POSITION_2 = new PositionColor("POSITION_2", 2, R.color.qui_common_brand_standard);
        DEFAULT = new PositionColor("DEFAULT", 3, R.color.qui_common_text_secondary);
        $VALUES = $values();
    }

    PositionColor(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.colorResId = i16;
        }
    }

    public static PositionColor valueOf(String str) {
        return (PositionColor) Enum.valueOf(PositionColor.class, str);
    }

    public static PositionColor[] values() {
        return (PositionColor[]) $VALUES.clone();
    }

    public final int getColorResId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.colorResId;
    }
}
