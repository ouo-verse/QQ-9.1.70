package j72;

import i72.QQStrangerQuickEmojiModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lj72/a;", "Lol3/b;", "<init>", "()V", "a", "Lj72/a$a;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a implements b {
    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lj72/a$a;", "Lj72/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Li72/i;", "d", "Li72/i;", "a", "()Li72/i;", "quickEmojiModel", "<init>", "(Li72/i;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: j72.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class OnClickItemIntent extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerQuickEmojiModel quickEmojiModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnClickItemIntent(QQStrangerQuickEmojiModel quickEmojiModel) {
            super(null);
            Intrinsics.checkNotNullParameter(quickEmojiModel, "quickEmojiModel");
            this.quickEmojiModel = quickEmojiModel;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerQuickEmojiModel getQuickEmojiModel() {
            return this.quickEmojiModel;
        }

        public int hashCode() {
            return this.quickEmojiModel.hashCode();
        }

        public String toString() {
            return "OnClickItemIntent(quickEmojiModel=" + this.quickEmojiModel + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnClickItemIntent) && Intrinsics.areEqual(this.quickEmojiModel, ((OnClickItemIntent) other).quickEmojiModel);
        }
    }
}
