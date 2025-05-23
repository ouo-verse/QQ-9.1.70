package com.qzone.reborn.albumx.common.share;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.share.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\"\u0010\f\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0010J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001aJ\u0006\u0010\u001c\u001a\u00020\u0006J \u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001fR?\u0010'\u001a*\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\"j\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004`#8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R3\u0010-\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040(j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004`)8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,R$\u00104\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R6\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u000105j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`68\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R6\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u000105j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`68\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R6\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u000105j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`68\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00107\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "Lcom/qzone/reborn/albumx/common/share/b;", "T", "", "Lcom/qzone/reborn/albumx/common/share/a;", "shareAction", "", "a", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "firstLine", "secondLine", h.F, "Landroidx/lifecycle/ViewModel;", "viewModel", "j", "", "action", "k", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "type", "c", "shareContext", "l", "(Lcom/qzone/reborn/albumx/common/share/b;)V", "b", "g", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "e", "()Ljava/util/HashMap;", "shareActions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "getAllActions", "()Ljava/util/HashSet;", "allActions", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "d", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "i", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "shareActionSheet", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAllItems", "()Ljava/util/ArrayList;", "setAllItems", "(Ljava/util/ArrayList;)V", "allItems", "getFirstLineItems", "setFirstLineItems", "firstLineItems", "getSecondLineItems", "setSecondLineItems", "secondLineItems", "Landroidx/lifecycle/ViewModel;", "getViewModel", "()Landroidx/lifecycle/ViewModel;", "setViewModel", "(Landroidx/lifecycle/ViewModel;)V", "<init>", "()V", "ShareLine", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QQShareActionManager<T extends b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, a<T>> shareActions = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashSet<a<T>> allActions = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ShareActionSheet shareActionSheet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> allItems;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> firstLineItems;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> secondLineItems;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "", "(Ljava/lang/String;I)V", "NONE", "FIRST", "SECOND", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum ShareLine {
        NONE,
        FIRST,
        SECOND
    }

    public final void a(a<T> shareAction) {
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.c().iterator();
        while (it.hasNext()) {
            this.shareActions.put(Integer.valueOf(((Number) it.next()).intValue()), shareAction);
        }
        this.allActions.add(shareAction);
    }

    public final void b(T shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if ((shareActionSheet == null || shareActionSheet.isShowing()) ? false : true) {
            return;
        }
        ShareActionSheet shareActionSheet2 = this.shareActionSheet;
        if (shareActionSheet2 != null) {
            shareActionSheet2.dismiss();
        }
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).g(shareContext, false);
        }
    }

    public final a<T> c(int type) {
        return this.shareActions.get(Integer.valueOf(type));
    }

    /* renamed from: d, reason: from getter */
    public final ShareActionSheet getShareActionSheet() {
        return this.shareActionSheet;
    }

    public final HashMap<Integer, a<T>> e() {
        return this.shareActions;
    }

    public final void f(int requestCode, int resultCode, Intent data) {
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).h(requestCode, resultCode, data);
        }
    }

    public final void g() {
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).i();
        }
    }

    public final void h(List<? extends ShareActionSheetBuilder.ActionSheetItem> firstLine, List<? extends ShareActionSheetBuilder.ActionSheetItem> secondLine) {
        Intrinsics.checkNotNullParameter(firstLine, "firstLine");
        Intrinsics.checkNotNullParameter(secondLine, "secondLine");
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.setActionSheetItems(firstLine, secondLine);
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        List<? extends ShareActionSheetBuilder.ActionSheetItem> list = firstLine;
        arrayList.addAll(list);
        this.firstLineItems = arrayList;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        List<? extends ShareActionSheetBuilder.ActionSheetItem> list2 = secondLine;
        arrayList2.addAll(list2);
        this.secondLineItems = arrayList2;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList3 = new ArrayList<>();
        arrayList3.addAll(list);
        arrayList3.addAll(list2);
        this.allItems = arrayList3;
    }

    public final void i(ShareActionSheet shareActionSheet) {
        this.shareActionSheet = shareActionSheet;
    }

    public final void j(ViewModel viewModel) {
        this.viewModel = viewModel;
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).j(viewModel);
        }
    }

    public final void k(int action, ViewModel viewModel) {
        a<T> aVar;
        if (this.shareActions.containsKey(Integer.valueOf(action)) && (aVar = this.shareActions.get(Integer.valueOf(action))) != null) {
            aVar.j(viewModel);
        }
    }

    public final void l(T shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        boolean z16 = false;
        if (shareActionSheet != null && shareActionSheet.isShowing()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ShareActionSheet shareActionSheet2 = this.shareActionSheet;
        if (shareActionSheet2 != null) {
            shareActionSheet2.show();
        }
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).g(shareContext, true);
        }
    }

    public final void m(int action, boolean visible) {
        ShareActionSheetBuilder.ActionSheetItem actionSheetItem;
        Object obj;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = this.allItems;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((ShareActionSheetBuilder.ActionSheetItem) obj).action == action) {
                        break;
                    }
                }
            }
            actionSheetItem = (ShareActionSheetBuilder.ActionSheetItem) obj;
        } else {
            actionSheetItem = null;
        }
        if (actionSheetItem == null && visible) {
            if (this.shareActions.get(Integer.valueOf(action)) != null) {
                ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
                ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = this.allItems;
                if (arrayList2 != null) {
                    arrayList2.add(build);
                }
                a<T> aVar = this.shareActions.get(Integer.valueOf(action));
                if ((aVar != null ? aVar.b() : null) == ShareLine.FIRST) {
                    ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList3 = this.firstLineItems;
                    if (arrayList3 != null) {
                        arrayList3.add(build);
                    }
                } else {
                    ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList4 = this.secondLineItems;
                    if (arrayList4 != null) {
                        arrayList4.add(build);
                    }
                }
                ShareActionSheet shareActionSheet = this.shareActionSheet;
                if (shareActionSheet != null) {
                    shareActionSheet.setActionSheetItems(this.firstLineItems, this.secondLineItems);
                }
            }
        } else if (actionSheetItem != null) {
            actionSheetItem.visibility = visible ? 0 : 8;
        }
        ShareActionSheet shareActionSheet2 = this.shareActionSheet;
        if (shareActionSheet2 != null) {
            shareActionSheet2.refresh();
        }
    }
}
