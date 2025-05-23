package com.tencent.state.square.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSettingMeItem;", "", "icon", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionSettingMeItem {
    private final String icon;
    private final String text;

    public InteractionSettingMeItem(String icon, String text) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        this.icon = icon;
        this.text = text;
    }

    /* renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final InteractionSettingMeItem copy(String icon, String text) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        return new InteractionSettingMeItem(icon, text);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.icon;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InteractionSettingMeItem(icon=" + this.icon + ", text=" + this.text + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionSettingMeItem)) {
            return false;
        }
        InteractionSettingMeItem interactionSettingMeItem = (InteractionSettingMeItem) other;
        return Intrinsics.areEqual(this.icon, interactionSettingMeItem.icon) && Intrinsics.areEqual(this.text, interactionSettingMeItem.text);
    }

    public static /* synthetic */ InteractionSettingMeItem copy$default(InteractionSettingMeItem interactionSettingMeItem, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = interactionSettingMeItem.icon;
        }
        if ((i3 & 2) != 0) {
            str2 = interactionSettingMeItem.text;
        }
        return interactionSettingMeItem.copy(str, str2);
    }
}
