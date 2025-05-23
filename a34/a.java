package a34;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"La34/a;", "Lat/a;", "<init>", "()V", "a", "b", "La34/a$a;", "La34/a$b;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a implements at.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"La34/a$a;", "La34/a;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: a34.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C0009a extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final C0009a f25436d = new C0009a();

        C0009a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"La34/a$b;", "La34/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "a", "()Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: a34.a$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class OnShareItemClick extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShareActionSheetBuilder.ActionSheetItem item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnShareItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ShareActionSheetBuilder.ActionSheetItem getItem() {
            return this.item;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnShareItemClick) && Intrinsics.areEqual(this.item, ((OnShareItemClick) other).item)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnShareItemClick(item=" + this.item + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
