package l72;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Ll72/b;", "Lat/a;", "<init>", "()V", "a", "b", "c", "Ll72/b$a;", "Ll72/b$b;", "Ll72/b$c;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class b implements at.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Ll72/b$a;", "Ll72/b;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name */
        public static final a f413909d = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ll72/b$b;", "Ll72/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isSelected", "<init>", "(Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l72.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class OnAssistedChatClick extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelected;

        /* renamed from: a, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public int hashCode() {
            boolean z16 = this.isSelected;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "OnAssistedChatClick(isSelected=" + this.isSelected + ")";
        }

        public OnAssistedChatClick(boolean z16) {
            super(null);
            this.isSelected = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnAssistedChatClick) && this.isSelected == ((OnAssistedChatClick) other).isSelected;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ll72/b$c;", "Ll72/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isSelected", "<init>", "(Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l72.b$c, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class OnEmoticonClick extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelected;

        /* renamed from: a, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public int hashCode() {
            boolean z16 = this.isSelected;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "OnEmoticonClick(isSelected=" + this.isSelected + ")";
        }

        public OnEmoticonClick(boolean z16) {
            super(null);
            this.isSelected = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnEmoticonClick) && this.isSelected == ((OnEmoticonClick) other).isSelected;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
