package com.tencent.mobileqq.troop.teamup.publish.data;

import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/data/TroopTeamUpJoinType;", "", "descriptionRes", "", "protoValue", "(Ljava/lang/String;III)V", "getDescriptionRes", "()I", "getProtoValue", "APPLY", "UPLOAD_PIC", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopTeamUpJoinType {
    private static final /* synthetic */ TroopTeamUpJoinType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopTeamUpJoinType APPLY;
    public static final TroopTeamUpJoinType UPLOAD_PIC;
    private final int descriptionRes;
    private final int protoValue;

    private static final /* synthetic */ TroopTeamUpJoinType[] $values() {
        return new TroopTeamUpJoinType[]{APPLY, UPLOAD_PIC};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        APPLY = new TroopTeamUpJoinType("APPLY", 0, R.string.f236327e2, 1);
        UPLOAD_PIC = new TroopTeamUpJoinType("UPLOAD_PIC", 1, R.string.f236447ed, 2);
        $VALUES = $values();
    }

    TroopTeamUpJoinType(@StringRes String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.descriptionRes = i16;
            this.protoValue = i17;
        }
    }

    public static TroopTeamUpJoinType valueOf(String str) {
        return (TroopTeamUpJoinType) Enum.valueOf(TroopTeamUpJoinType.class, str);
    }

    public static TroopTeamUpJoinType[] values() {
        return (TroopTeamUpJoinType[]) $VALUES.clone();
    }

    public final int getDescriptionRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.descriptionRes;
    }

    public final int getProtoValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.protoValue;
    }
}
