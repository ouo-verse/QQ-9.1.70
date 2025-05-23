package l94;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\t\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Ll94/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "menuType", "b", "d", "menuId", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "menuContent", "Ll94/e;", "Ll94/e;", "()Ll94/e;", "itemClickListener", "Ll94/d;", "Ll94/d;", "()Ll94/d;", "itemAddListener", "<init>", "(IILjava/lang/String;Ll94/e;Ll94/d;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: l94.c, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class AvatarActionSheetDialogMenuItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int menuType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int menuId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String menuContent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final e itemClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final d itemAddListener;

    public AvatarActionSheetDialogMenuItem(int i3, int i16, String menuContent, e itemClickListener, d dVar) {
        Intrinsics.checkNotNullParameter(menuContent, "menuContent");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.menuType = i3;
        this.menuId = i16;
        this.menuContent = menuContent;
        this.itemClickListener = itemClickListener;
        this.itemAddListener = dVar;
    }

    /* renamed from: a, reason: from getter */
    public final d getItemAddListener() {
        return this.itemAddListener;
    }

    /* renamed from: b, reason: from getter */
    public final e getItemClickListener() {
        return this.itemClickListener;
    }

    /* renamed from: c, reason: from getter */
    public final String getMenuContent() {
        return this.menuContent;
    }

    /* renamed from: d, reason: from getter */
    public final int getMenuId() {
        return this.menuId;
    }

    /* renamed from: e, reason: from getter */
    public final int getMenuType() {
        return this.menuType;
    }

    public int hashCode() {
        int hashCode = ((((((this.menuType * 31) + this.menuId) * 31) + this.menuContent.hashCode()) * 31) + this.itemClickListener.hashCode()) * 31;
        d dVar = this.itemAddListener;
        return hashCode + (dVar == null ? 0 : dVar.hashCode());
    }

    public String toString() {
        return "AvatarActionSheetDialogMenuItem(menuType=" + this.menuType + ", menuId=" + this.menuId + ", menuContent=" + this.menuContent + ", itemClickListener=" + this.itemClickListener + ", itemAddListener=" + this.itemAddListener + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarActionSheetDialogMenuItem)) {
            return false;
        }
        AvatarActionSheetDialogMenuItem avatarActionSheetDialogMenuItem = (AvatarActionSheetDialogMenuItem) other;
        return this.menuType == avatarActionSheetDialogMenuItem.menuType && this.menuId == avatarActionSheetDialogMenuItem.menuId && Intrinsics.areEqual(this.menuContent, avatarActionSheetDialogMenuItem.menuContent) && Intrinsics.areEqual(this.itemClickListener, avatarActionSheetDialogMenuItem.itemClickListener) && Intrinsics.areEqual(this.itemAddListener, avatarActionSheetDialogMenuItem.itemAddListener);
    }

    public /* synthetic */ AvatarActionSheetDialogMenuItem(int i3, int i16, String str, e eVar, d dVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, str, eVar, (i17 & 16) != 0 ? null : dVar);
    }
}
