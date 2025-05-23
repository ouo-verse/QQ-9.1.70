package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import android.graphics.Color;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/MemberDistributionType;", "", "textColor", "", "processColor", "iconRes", "(Ljava/lang/String;IIII)V", "getIconRes", "()I", "getProcessColor", "getTextColor", "ACTIVE", "GENDER_MALE", "GENDER_FEMALE", "LOCATION", "AGE_70", "AGE_8090", "AGE_00", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class MemberDistributionType {
    private static final /* synthetic */ MemberDistributionType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MemberDistributionType ACTIVE;
    public static final MemberDistributionType AGE_00;
    public static final MemberDistributionType AGE_70;
    public static final MemberDistributionType AGE_8090;
    public static final MemberDistributionType GENDER_FEMALE;
    public static final MemberDistributionType GENDER_MALE;
    public static final MemberDistributionType LOCATION;
    private final int iconRes;
    private final int processColor;
    private final int textColor;

    private static final /* synthetic */ MemberDistributionType[] $values() {
        return new MemberDistributionType[]{ACTIVE, GENDER_MALE, GENDER_FEMALE, LOCATION, AGE_70, AGE_8090, AGE_00};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57298);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        ACTIVE = new MemberDistributionType("ACTIVE", 0, Color.parseColor("#FF5539"), Color.parseColor("#FFB4A6"), R.drawable.qui_medals);
        GENDER_MALE = new MemberDistributionType("GENDER_MALE", 1, Color.parseColor("#0095F7"), Color.parseColor("#9FCAFF"), R.drawable.qui_male);
        GENDER_FEMALE = new MemberDistributionType("GENDER_FEMALE", 2, Color.parseColor("#EF59A5"), Color.parseColor("#FFB0D0"), R.drawable.qui_female);
        LOCATION = new MemberDistributionType("LOCATION", 3, Color.parseColor("#957CFF"), Color.parseColor("#CBBEFF"), R.drawable.qui_position);
        AGE_70 = new MemberDistributionType("AGE_70", 4, Color.parseColor("#3AC6EC"), Color.parseColor("#99DBEC"), R.drawable.qui_user);
        AGE_8090 = new MemberDistributionType("AGE_8090", 5, Color.parseColor("#30D3C3"), Color.parseColor("#95E7DE"), R.drawable.qui_user);
        AGE_00 = new MemberDistributionType("AGE_00", 6, Color.parseColor("#0FDC76"), Color.parseColor("#9DE2C0"), R.drawable.qui_user);
        $VALUES = $values();
    }

    MemberDistributionType(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.textColor = i16;
        this.processColor = i17;
        this.iconRes = i18;
    }

    public static MemberDistributionType valueOf(String str) {
        return (MemberDistributionType) Enum.valueOf(MemberDistributionType.class, str);
    }

    public static MemberDistributionType[] values() {
        return (MemberDistributionType[]) $VALUES.clone();
    }

    public final int getIconRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.iconRes;
    }

    public final int getProcessColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.processColor;
    }

    public final int getTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.textColor;
    }
}
