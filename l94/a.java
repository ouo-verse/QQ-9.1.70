package l94;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0016j\b\u0012\u0004\u0012\u00020\r`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Ll94/a;", "", "", "title", "e", "", "menuId", "menuContent", "", "isHighlight", "Ll94/e;", "itemClickListener", "a", "Ll94/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "cancelClickListener", "d", "Ll94/b;", "c", "Ljava/lang/String;", "menuTitle", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "menuList", "Ll94/e;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String menuTitle = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<AvatarActionSheetDialogMenuItem> menuList = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private e cancelClickListener;

    public final a a(int menuId, String menuContent, boolean isHighlight, e itemClickListener) {
        Intrinsics.checkNotNullParameter(menuContent, "menuContent");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.menuList.add(new AvatarActionSheetDialogMenuItem(isHighlight ? 3 : 2, menuId, menuContent, itemClickListener, null, 16, null));
        return this;
    }

    public final a b(AvatarActionSheetDialogMenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.menuList.add(item);
        return this;
    }

    public final AvatarActionSheetDialogCustomData c() {
        return new AvatarActionSheetDialogCustomData(this.menuTitle, this.menuList, this.cancelClickListener, null, 8, null);
    }

    public final a d(e cancelClickListener) {
        Intrinsics.checkNotNullParameter(cancelClickListener, "cancelClickListener");
        this.cancelClickListener = cancelClickListener;
        return this;
    }

    public final a e(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.menuTitle = title;
        return this;
    }
}
