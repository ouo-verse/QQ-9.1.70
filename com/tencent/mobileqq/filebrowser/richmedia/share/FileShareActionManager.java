package com.tencent.mobileqq.filebrowser.richmedia.share;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\r\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR3\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0017j\b\u0012\u0004\u0012\u00020\u0002`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R6\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager;", "", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "shareAction", "", "a", "", "type", "b", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "firstLine", "secondLine", "d", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "shareActions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "allActions", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "getShareActionSheet", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "e", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "shareActionSheet", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAllItems", "()Ljava/util/ArrayList;", "setAllItems", "(Ljava/util/ArrayList;)V", "allItems", "<init>", "()V", "ShareLine", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileShareActionManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, FileAbsShareAction> shareActions = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<FileAbsShareAction> allActions = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheet shareActionSheet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> allItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "", "(Ljava/lang/String;I)V", "NONE", "FIRST", "SECOND", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public enum ShareLine {
        NONE,
        FIRST,
        SECOND
    }

    public final void a(@NotNull FileAbsShareAction shareAction) {
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.c().iterator();
        while (it.hasNext()) {
            this.shareActions.put(Integer.valueOf(((Number) it.next()).intValue()), shareAction);
        }
        this.allActions.add(shareAction);
    }

    @Nullable
    public final FileAbsShareAction b(int type) {
        return this.shareActions.get(Integer.valueOf(type));
    }

    @NotNull
    public final HashMap<Integer, FileAbsShareAction> c() {
        return this.shareActions;
    }

    public final void d(@NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> firstLine, @NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> secondLine) {
        Intrinsics.checkNotNullParameter(firstLine, "firstLine");
        Intrinsics.checkNotNullParameter(secondLine, "secondLine");
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.setActionSheetItems(firstLine, secondLine);
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        arrayList.addAll(firstLine);
        arrayList.addAll(secondLine);
        this.allItems = arrayList;
    }

    public final void e(@Nullable ShareActionSheet shareActionSheet) {
        this.shareActionSheet = shareActionSheet;
    }

    public final void f(@NotNull FileShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.show();
        }
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((FileAbsShareAction) it.next()).f(shareContext, true);
        }
    }
}
