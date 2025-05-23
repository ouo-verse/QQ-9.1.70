package com.tencent.mobileqq.troop.jointype.event;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/event/TroopAutoApprovalSettingUpdate;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "updateFromWeb", "", "groupCode", "", "autoApprovalSetting", "(ZJZ)V", "getAutoApprovalSetting", "()Z", "getGroupCode", "()J", "getUpdateFromWeb", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class TroopAutoApprovalSettingUpdate extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private final boolean autoApprovalSetting;
    private final long groupCode;
    private final boolean updateFromWeb;

    public TroopAutoApprovalSettingUpdate(boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17));
            return;
        }
        this.updateFromWeb = z16;
        this.groupCode = j3;
        this.autoApprovalSetting = z17;
    }

    public static /* synthetic */ TroopAutoApprovalSettingUpdate copy$default(TroopAutoApprovalSettingUpdate troopAutoApprovalSettingUpdate, boolean z16, long j3, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = troopAutoApprovalSettingUpdate.updateFromWeb;
        }
        if ((i3 & 2) != 0) {
            j3 = troopAutoApprovalSettingUpdate.groupCode;
        }
        if ((i3 & 4) != 0) {
            z17 = troopAutoApprovalSettingUpdate.autoApprovalSetting;
        }
        return troopAutoApprovalSettingUpdate.copy(z16, j3, z17);
    }

    public final boolean component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.updateFromWeb;
    }

    public final long component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.groupCode;
    }

    public final boolean component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.autoApprovalSetting;
    }

    @NotNull
    public final TroopAutoApprovalSettingUpdate copy(boolean updateFromWeb, long groupCode, boolean autoApprovalSetting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TroopAutoApprovalSettingUpdate) iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(updateFromWeb), Long.valueOf(groupCode), Boolean.valueOf(autoApprovalSetting));
        }
        return new TroopAutoApprovalSettingUpdate(updateFromWeb, groupCode, autoApprovalSetting);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopAutoApprovalSettingUpdate)) {
            return false;
        }
        TroopAutoApprovalSettingUpdate troopAutoApprovalSettingUpdate = (TroopAutoApprovalSettingUpdate) other;
        if (this.updateFromWeb == troopAutoApprovalSettingUpdate.updateFromWeb && this.groupCode == troopAutoApprovalSettingUpdate.groupCode && this.autoApprovalSetting == troopAutoApprovalSettingUpdate.autoApprovalSetting) {
            return true;
        }
        return false;
    }

    public final boolean getAutoApprovalSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.autoApprovalSetting;
    }

    public final long getGroupCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.groupCode;
    }

    public final boolean getUpdateFromWeb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.updateFromWeb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        boolean z16 = this.updateFromWeb;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + a.a(this.groupCode)) * 31;
        boolean z17 = this.autoApprovalSetting;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopAutoApprovalSettingUpdate(updateFromWeb=" + this.updateFromWeb + ", groupCode=" + this.groupCode + ", autoApprovalSetting=" + this.autoApprovalSetting + ")";
    }
}
