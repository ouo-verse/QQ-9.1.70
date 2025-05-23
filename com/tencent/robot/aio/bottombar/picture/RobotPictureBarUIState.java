package com.tencent.robot.aio.bottombar.picture;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState;", "", "<init>", "()V", "AddPicItem", "HidePictures", "NotifyOverMaxSelectedSize", "ShowPictures", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$AddPicItem;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$HidePictures;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$NotifyOverMaxSelectedSize;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$ShowPictures;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class RobotPictureBarUIState implements MviUIState {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$AddPicItem;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "list", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class AddPicItem extends RobotPictureBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<LocalMediaInfo> list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddPicItem(@NotNull List<LocalMediaInfo> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        @NotNull
        public final List<LocalMediaInfo> a() {
            return this.list;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AddPicItem) && Intrinsics.areEqual(this.list, ((AddPicItem) other).list)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        @NotNull
        public String toString() {
            return "AddPicItem(list=" + this.list + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$HidePictures;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class HidePictures extends RobotPictureBarUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HidePictures f366927d = new HidePictures();

        HidePictures() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$NotifyOverMaxSelectedSize;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "maxSize", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class NotifyOverMaxSelectedSize extends RobotPictureBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int maxSize;

        public NotifyOverMaxSelectedSize(int i3) {
            super(null);
            this.maxSize = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getMaxSize() {
            return this.maxSize;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NotifyOverMaxSelectedSize) && this.maxSize == ((NotifyOverMaxSelectedSize) other).maxSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.maxSize;
        }

        @NotNull
        public String toString() {
            return "NotifyOverMaxSelectedSize(maxSize=" + this.maxSize + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState$ShowPictures;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowPictures extends RobotPictureBarUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowPictures f366929d = new ShowPictures();

        ShowPictures() {
            super(null);
        }
    }

    public /* synthetic */ RobotPictureBarUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotPictureBarUIState() {
    }
}
