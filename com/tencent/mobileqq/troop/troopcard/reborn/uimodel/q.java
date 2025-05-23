package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\n\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/j;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/j;", "c", "()Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/j;", "troopLevelUIModel", "Z", "()Z", "showPrettyTroopIcon", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/j;Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> tags;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j troopLevelUIModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean showPrettyTroopIcon;

    public q(@NotNull List<String> tags, @NotNull j troopLevelUIModel, boolean z16) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(troopLevelUIModel, "troopLevelUIModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tags, troopLevelUIModel, Boolean.valueOf(z16));
            return;
        }
        this.tags = tags;
        this.troopLevelUIModel = troopLevelUIModel;
        this.showPrettyTroopIcon = z16;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.showPrettyTroopIcon;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tags;
    }

    @NotNull
    public final j c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (j) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopLevelUIModel;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof q)) {
            return false;
        }
        q qVar = (q) other;
        if (Intrinsics.areEqual(this.tags, qVar.tags) && Intrinsics.areEqual(this.troopLevelUIModel, qVar.troopLevelUIModel) && this.showPrettyTroopIcon == qVar.showPrettyTroopIcon) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int hashCode = ((this.tags.hashCode() * 31) + this.troopLevelUIModel.hashCode()) * 31;
        boolean z16 = this.showPrettyTroopIcon;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopTagUIModel(tags=" + this.tags + ", troopLevelUIModel=" + this.troopLevelUIModel + ", showPrettyTroopIcon=" + this.showPrettyTroopIcon + ")";
    }
}
