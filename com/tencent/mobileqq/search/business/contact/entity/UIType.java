package com.tencent.mobileqq.search.business.contact.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "", "<init>", "()V", "a", "b", "CheckStatus", "c", "d", "e", "f", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$b;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$c;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$d;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$e;", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class UIType {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;", "", "(Ljava/lang/String;I)V", "isChecked", "", "UNCHECKED", "CHECKED", "DISABLED", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public enum CheckStatus {
        UNCHECKED,
        CHECKED,
        DISABLED;

        public final boolean isChecked() {
            if (this == CHECKED) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType$a;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$b;", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "d", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "e", "()Lcom/tencent/mobileqq/search/business/contact/entity/c;", "itemData", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;", "isCheck", "", "canEditCheckStatus", "clickable", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/entity/c;Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;ZZ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ContactsSearchItemData itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull ContactsSearchItemData itemData, @NotNull CheckStatus isCheck, boolean z16, boolean z17) {
            super(isCheck, z16, z17);
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            Intrinsics.checkNotNullParameter(isCheck, "isCheck");
            this.itemData = itemData;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final ContactsSearchItemData getItemData() {
            return this.itemData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType$b;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "another", "", "d", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;", "a", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;", "b", "()Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;", "setCheckStatus", "(Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;)V", "checkStatus", "Z", "()Z", "setCanEditCheckStatus", "(Z)V", "canEditCheckStatus", "c", "setClickable", "clickable", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;ZZ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static class b extends UIType {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private CheckStatus checkStatus;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean canEditCheckStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean clickable;

        public b() {
            this(null, false, false, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanEditCheckStatus() {
            return this.canEditCheckStatus;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CheckStatus getCheckStatus() {
            return this.checkStatus;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getClickable() {
            return this.clickable;
        }

        public final boolean d(@NotNull b another) {
            Intrinsics.checkNotNullParameter(another, "another");
            if (this.checkStatus == another.checkStatus && this.canEditCheckStatus == another.canEditCheckStatus) {
                return true;
            }
            return false;
        }

        public /* synthetic */ b(CheckStatus checkStatus, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? CheckStatus.UNCHECKED : checkStatus, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? true : z17);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull CheckStatus checkStatus, boolean z16, boolean z17) {
            super(null);
            Intrinsics.checkNotNullParameter(checkStatus, "checkStatus");
            this.checkStatus = checkStatus;
            this.canEditCheckStatus = z16;
            this.clickable = z17;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType$c;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "collapse", "<init>", "(Z)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.contact.entity.UIType$c, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class LoadMoreUI extends UIType {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean collapse;

        public LoadMoreUI(boolean z16) {
            super(null);
            this.collapse = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCollapse() {
            return this.collapse;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof LoadMoreUI) && this.collapse == ((LoadMoreUI) other).collapse) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.collapse;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "LoadMoreUI(collapse=" + this.collapse + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType$d;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d extends UIType {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f282919a = new d();

        d() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType$e;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "title", "b", "Z", "()Z", "isGapTop", "<init>", "(Ljava/lang/String;Z)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.contact.entity.UIType$e, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class TitleUI extends UIType {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isGapTop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleUI(@NotNull String title, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
            this.isGapTop = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsGapTop() {
            return this.isGapTop;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TitleUI)) {
                return false;
            }
            TitleUI titleUI = (TitleUI) other;
            if (Intrinsics.areEqual(this.title, titleUI.title) && this.isGapTop == titleUI.isGapTop) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.title.hashCode() * 31;
            boolean z16 = this.isGapTop;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "TitleUI(title=" + this.title + ", isGapTop=" + this.isGapTop + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/entity/UIType$f;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$b;", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "d", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", "e", "()Lcom/tencent/mobileqq/search/business/contact/entity/c;", "itemData", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;", "isCheck", "", "canEditCheckStatus", "clickable", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/entity/c;Lcom/tencent/mobileqq/search/business/contact/entity/UIType$CheckStatus;ZZ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ContactsSearchItemData itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull ContactsSearchItemData itemData, @NotNull CheckStatus isCheck, boolean z16, boolean z17) {
            super(isCheck, z16, z17);
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            Intrinsics.checkNotNullParameter(isCheck, "isCheck");
            this.itemData = itemData;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final ContactsSearchItemData getItemData() {
            return this.itemData;
        }
    }

    public /* synthetic */ UIType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    UIType() {
    }
}
