package com.tencent.robot.share.layer;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R3\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u0016j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002`\u00178\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001cj\b\u0012\u0004\u0012\u00020\u0002`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001eR*\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010 j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/share/layer/RobotLayerShareActionManager;", "", "Li54/a;", "shareAction", "", "a", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "firstLine", "secondLine", "d", "", "type", "b", "f", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "getShareActionSheet", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "e", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;)V", "shareActionSheet", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "shareActions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "allActions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "allItems", "<init>", "()V", "ShareLine", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotLayerShareActionManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheetV2 shareActionSheet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, i54.a> shareActions = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<i54.a> allActions = new HashSet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> allItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/share/layer/RobotLayerShareActionManager$ShareLine;", "", "(Ljava/lang/String;I)V", "NONE", "FIRST", "SECOND", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public enum ShareLine {
        NONE,
        FIRST,
        SECOND
    }

    public final void a(@NotNull i54.a shareAction) {
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.c().iterator();
        while (it.hasNext()) {
            this.shareActions.put(Integer.valueOf(((Number) it.next()).intValue()), shareAction);
        }
        this.allActions.add(shareAction);
    }

    @Nullable
    public final i54.a b(int type) {
        return this.shareActions.get(Integer.valueOf(type));
    }

    @NotNull
    public final HashMap<Integer, i54.a> c() {
        return this.shareActions;
    }

    public final void d(@NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> firstLine, @NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> secondLine) {
        Intrinsics.checkNotNullParameter(firstLine, "firstLine");
        Intrinsics.checkNotNullParameter(secondLine, "secondLine");
        ShareActionSheetV2 shareActionSheetV2 = this.shareActionSheet;
        if (shareActionSheetV2 != null) {
            shareActionSheetV2.setActionSheetItems(firstLine, secondLine);
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        arrayList.addAll(firstLine);
        arrayList.addAll(secondLine);
        this.allItems = arrayList;
    }

    public final void e(@Nullable ShareActionSheetV2 shareActionSheetV2) {
        this.shareActionSheet = shareActionSheetV2;
    }

    public final void f() {
        ShareActionSheetV2 shareActionSheetV2 = this.shareActionSheet;
        if (shareActionSheetV2 != null) {
            shareActionSheetV2.show();
        }
    }
}
