package com.tencent.robot.aio.bottombar.picture;

import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/d;", "", "<init>", "()V", "a", "Lcom/tencent/robot/aio/bottombar/picture/d$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class d implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/d$a;", "Lcom/tencent/robot/aio/bottombar/picture/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.bottombar.picture.d$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class ClearSinglePictureInfo extends d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final LocalMediaInfo info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearSinglePictureInfo(@NotNull LocalMediaInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final LocalMediaInfo getInfo() {
            return this.info;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ClearSinglePictureInfo) && Intrinsics.areEqual(this.info, ((ClearSinglePictureInfo) other).info)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.info.hashCode();
        }

        @NotNull
        public String toString() {
            return "ClearSinglePictureInfo(info=" + this.info + ")";
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    d() {
    }
}
