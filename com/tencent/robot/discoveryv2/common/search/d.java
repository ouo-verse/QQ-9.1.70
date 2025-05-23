package com.tencent.robot.discoveryv2.common.search;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/search/d;", "", "<init>", "()V", "a", "Lcom/tencent/robot/discoveryv2/common/search/d$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/search/d$a;", "Lcom/tencent/robot/discoveryv2/common/search/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "visibility", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.common.search.d$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateSearchBarVisibility extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibility;

        public UpdateSearchBarVisibility(int i3) {
            super(null);
            this.visibility = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateSearchBarVisibility) && this.visibility == ((UpdateSearchBarVisibility) other).visibility) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.visibility;
        }

        @NotNull
        public String toString() {
            return "UpdateSearchBarVisibility(visibility=" + this.visibility + ")";
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    d() {
    }
}
