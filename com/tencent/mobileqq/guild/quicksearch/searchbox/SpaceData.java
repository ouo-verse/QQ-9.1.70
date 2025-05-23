package com.tencent.mobileqq.guild.quicksearch.searchbox;

import com.heytap.databaseengine.apiv3.data.Element;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/i;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", Element.ELEMENT_NAME_DISTANCE, "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.quicksearch.searchbox.i, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SpaceData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int distance;

    public SpaceData(int i3) {
        this.distance = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getDistance() {
        return this.distance;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SpaceData) && this.distance == ((SpaceData) other).distance) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.distance;
    }

    @NotNull
    public String toString() {
        return "SpaceData(distance=" + this.distance + ")";
    }
}
