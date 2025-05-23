package com.tencent.qqnt.aio.gallery.share;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014R3\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002`\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR'\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001dj\b\u0012\u0004\u0012\u00020\u0002`\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R$\u0010)\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R3\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u0017j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0002`\u00188\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b*\u0010\u001bR6\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;", "", "Lcom/tencent/qqnt/aio/gallery/share/a;", "shareAction", "", "a", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "firstLine", "secondLine", "g", "", "action", "", NodeProps.VISIBLE, "j", "", "type", "c", "e", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "shareActions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "allActions", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "getShareActionSheet", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", tl.h.F, "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "shareActionSheet", "d", "newShareActions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAllItems", "()Ljava/util/ArrayList;", "setAllItems", "(Ljava/util/ArrayList;)V", "allItems", "<init>", "()V", "ShareLine", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTShareActionManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ShareActionSheet shareActionSheet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> allItems;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, a> shareActions = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashSet<a> allActions = new HashSet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, a> newShareActions = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "", "(Ljava/lang/String;I)V", "NONE", "FIRST", "SECOND", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum ShareLine {
        NONE,
        FIRST,
        SECOND
    }

    public final void a(a shareAction) {
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.c().iterator();
        while (it.hasNext()) {
            this.newShareActions.put((String) it.next(), shareAction);
        }
        Iterator<T> it5 = shareAction.e().iterator();
        while (it5.hasNext()) {
            this.shareActions.put(Integer.valueOf(((Number) it5.next()).intValue()), shareAction);
        }
        this.allActions.add(shareAction);
    }

    public final HashSet<a> b() {
        return this.allActions;
    }

    public final a c(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.newShareActions.get(type);
    }

    public final HashMap<String, a> d() {
        return this.newShareActions;
    }

    public final a e(int type) {
        return this.shareActions.get(Integer.valueOf(type));
    }

    public final HashMap<Integer, a> f() {
        return this.shareActions;
    }

    public final void g(List<? extends ShareActionSheetBuilder.ActionSheetItem> firstLine, List<? extends ShareActionSheetBuilder.ActionSheetItem> secondLine) {
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

    public final void h(ShareActionSheet shareActionSheet) {
        this.shareActionSheet = shareActionSheet;
    }

    public final void i(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.show();
        }
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).h(shareContext, true);
        }
    }

    public final void j(int action, boolean visible) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = this.allItems;
        if (arrayList != null) {
            for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : arrayList) {
                if (actionSheetItem.action == action) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        actionSheetItem = null;
        if (actionSheetItem != null) {
            actionSheetItem.visibility = visible ? 0 : 8;
        }
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.refresh();
        }
    }
}
