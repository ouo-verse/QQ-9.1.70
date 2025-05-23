package l94;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\t\u0010\u001aR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001c\u0010\f\u00a8\u0006 "}, d2 = {"Ll94/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMenuTitle", "(Ljava/lang/String;)V", "menuTitle", "", "Ll94/c;", "b", "Ljava/util/List;", "()Ljava/util/List;", "setMenuList", "(Ljava/util/List;)V", "menuList", "Ll94/e;", "Ll94/e;", "()Ll94/e;", "cancelClickListener", "d", "pageId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ll94/e;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: l94.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class AvatarActionSheetDialogCustomData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String menuTitle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private List<AvatarActionSheetDialogMenuItem> menuList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final e cancelClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pageId;

    public AvatarActionSheetDialogCustomData(String menuTitle, List<AvatarActionSheetDialogMenuItem> menuList, e eVar, String str) {
        Intrinsics.checkNotNullParameter(menuTitle, "menuTitle");
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        this.menuTitle = menuTitle;
        this.menuList = menuList;
        this.cancelClickListener = eVar;
        this.pageId = str;
    }

    /* renamed from: a, reason: from getter */
    public final e getCancelClickListener() {
        return this.cancelClickListener;
    }

    public final List<AvatarActionSheetDialogMenuItem> b() {
        return this.menuList;
    }

    /* renamed from: c, reason: from getter */
    public final String getMenuTitle() {
        return this.menuTitle;
    }

    /* renamed from: d, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    public int hashCode() {
        int hashCode = ((this.menuTitle.hashCode() * 31) + this.menuList.hashCode()) * 31;
        e eVar = this.cancelClickListener;
        int hashCode2 = (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        String str = this.pageId;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AvatarActionSheetDialogCustomData(menuTitle=" + this.menuTitle + ", menuList=" + this.menuList + ", cancelClickListener=" + this.cancelClickListener + ", pageId=" + this.pageId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarActionSheetDialogCustomData)) {
            return false;
        }
        AvatarActionSheetDialogCustomData avatarActionSheetDialogCustomData = (AvatarActionSheetDialogCustomData) other;
        return Intrinsics.areEqual(this.menuTitle, avatarActionSheetDialogCustomData.menuTitle) && Intrinsics.areEqual(this.menuList, avatarActionSheetDialogCustomData.menuList) && Intrinsics.areEqual(this.cancelClickListener, avatarActionSheetDialogCustomData.cancelClickListener) && Intrinsics.areEqual(this.pageId, avatarActionSheetDialogCustomData.pageId);
    }

    public /* synthetic */ AvatarActionSheetDialogCustomData(String str, List list, e eVar, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i3 & 4) != 0 ? null : eVar, (i3 & 8) != 0 ? null : str2);
    }
}
