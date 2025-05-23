package com.tencent.mobileqq.widget.listitem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0004\u000b\b\u0003$Bq\b\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\n\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fB%\b\u0016\u0012\u001a\u0010\r\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\n\"\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\u001e\u0010 B-\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u001a\u0010\r\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\n\"\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\u001e\u0010!B5\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u001a\u0010\r\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\n\"\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\u001e\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000\u00a2\u0006\u0004\b\b\u0010\tR \u0010\r\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR/\u0010\u0014\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0010j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/Group;", "", "", "c", "()V", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "", "b", "(Lcom/tencent/mobileqq/widget/listitem/a;)Z", "", "a", "[Lcom/tencent/mobileqq/widget/listitem/a;", "configList", "Z", "showOtherConfigIfConfigListEmpty", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "allConfigList", "", "d", "I", "visibleConfigListSize", "", "topDescription", "bottomDescription", "topConfigList", "bottomConfigList", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Lcom/tencent/mobileqq/widget/listitem/a;[Lcom/tencent/mobileqq/widget/listitem/a;[Lcom/tencent/mobileqq/widget/listitem/a;Z)V", "([Lcom/tencent/mobileqq/widget/listitem/a;)V", "(Ljava/lang/CharSequence;[Lcom/tencent/mobileqq/widget/listitem/a;)V", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Lcom/tencent/mobileqq/widget/listitem/a;)V", "e", "PositionType", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class Group {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a<?>[] configList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean showOtherConfigIfConfigListEmpty;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a<?>> allConfigList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int visibleConfigListSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/Group$PositionType;", "", "(Ljava/lang/String;I)V", "Top", "Bottom", "Middle", "Other", "Only", "qqui_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public enum PositionType {
        Top,
        Bottom,
        Middle,
        Other,
        Only
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\"\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J1\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\"\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ=\u0010\u000e\u001a\u00020\u00052\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\r\u001a\u00020\b2\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\"\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\"\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0007J5\u0010\u0011\u001a\u00020\u00052\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00032\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\"\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/Group$a;", "", "", "Lcom/tencent/mobileqq/widget/listitem/a;", "configList", "Lcom/tencent/mobileqq/widget/listitem/Group;", "d", "([Lcom/tencent/mobileqq/widget/listitem/a;)Lcom/tencent/mobileqq/widget/listitem/Group;", "", "description", "c", "(Ljava/lang/CharSequence;[Lcom/tencent/mobileqq/widget/listitem/a;)Lcom/tencent/mobileqq/widget/listitem/Group;", "topConfig", "bottomDescription", "a", "(Lcom/tencent/mobileqq/widget/listitem/a;Ljava/lang/CharSequence;[Lcom/tencent/mobileqq/widget/listitem/a;)Lcom/tencent/mobileqq/widget/listitem/Group;", "b", "e", "(Lcom/tencent/mobileqq/widget/listitem/a;[Lcom/tencent/mobileqq/widget/listitem/a;)Lcom/tencent/mobileqq/widget/listitem/Group;", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.widget.listitem.Group$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Group a(@NotNull a<?> topConfig, @NotNull CharSequence bottomDescription, @NotNull a<?>... configList) {
            Intrinsics.checkNotNullParameter(topConfig, "topConfig");
            Intrinsics.checkNotNullParameter(bottomDescription, "bottomDescription");
            Intrinsics.checkNotNullParameter(configList, "configList");
            return new Group(null, bottomDescription, new a[]{topConfig}, null, configList, false, 41, null);
        }

        @NotNull
        public final Group b(@NotNull a<?>... configList) {
            Intrinsics.checkNotNullParameter(configList, "configList");
            return new Group(null, null, null, null, configList, false, 47, null);
        }

        @NotNull
        public final Group c(@NotNull CharSequence description, @NotNull a<?>... configList) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(configList, "configList");
            return new Group(description, null, configList, null, null, true, 26, null);
        }

        @NotNull
        public final Group d(@NotNull a<?>... configList) {
            Intrinsics.checkNotNullParameter(configList, "configList");
            return new Group(null, null, configList, null, null, true, 27, null);
        }

        @NotNull
        public final Group e(@NotNull a<?> topConfig, @NotNull a<?>... configList) {
            Intrinsics.checkNotNullParameter(topConfig, "topConfig");
            Intrinsics.checkNotNullParameter(configList, "configList");
            return new Group(null, null, new a[]{topConfig}, null, configList, false, 43, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/Group$b;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/ac;", "Landroid/widget/TextView;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "E", "viewHolder", "", "position", "", "", "payloads", "", "D", "", "k", "Ljava/lang/CharSequence;", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/lang/CharSequence;", UserInfo.SEX_FEMALE, "(Ljava/lang/CharSequence;)V", "description", "", "l", "Z", "isTop", "<init>", "(Ljava/lang/CharSequence;Z)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static class b extends a<ac<TextView>> {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private CharSequence description;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private final boolean isTop;

        public b(@NotNull CharSequence description, boolean z16) {
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
            this.isTop = z16;
        }

        @NotNull
        /* renamed from: C, reason: from getter */
        public CharSequence getDescription() {
            return this.description;
        }

        @Override // com.tencent.mobileqq.widget.listitem.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public void m(@NotNull ac<TextView> viewHolder, int position, @NotNull List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            View view = viewHolder.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) view;
            if (this.isTop) {
                textView.setPadding(textView.getPaddingLeft(), Utils.n(11.5f, textView.getResources()), textView.getPaddingRight(), Utils.n(6.5f, textView.getResources()));
            } else {
                int n3 = Utils.n(11.5f, textView.getResources());
                textView.setPadding(textView.getPaddingLeft(), Utils.n(6.5f, textView.getResources()), textView.getPaddingRight(), n3);
            }
            textView.setText(getDescription());
        }

        @Override // com.tencent.mobileqq.widget.listitem.a
        @NotNull
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public ac<TextView> n(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            TextView textView = new TextView(parent.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int dimensionPixelSize = textView.getResources().getDimensionPixelSize(R.dimen.da8);
            textView.setTextColor(ie0.a.f().h(textView.getContext(), R.color.qui_common_text_secondary, getThemeId()));
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.aw5));
            textView.setPadding(dimensionPixelSize, textView.getPaddingTop(), dimensionPixelSize, textView.getPaddingBottom());
            return new ac<>(textView);
        }

        public void F(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.description = charSequence;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/Group$c;", "", "", "a", "I", "()I", "c", "(I)V", "left", "b", "d", "right", "<init>", "(II)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int left;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int right;

        public c(int i3, int i16) {
            this.left = i3;
            this.right = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: b, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        public final void c(int i3) {
            this.left = i3;
        }

        public final void d(int i3) {
            this.right = i3;
        }
    }

    Group(CharSequence charSequence, CharSequence charSequence2, a<?>[] aVarArr, a<?>[] aVarArr2, a<?>[] aVarArr3, boolean z16) {
        this.configList = aVarArr3;
        this.showOtherConfigIfConfigListEmpty = z16;
        ArrayList<a<?>> arrayList = new ArrayList<>();
        this.allConfigList = arrayList;
        boolean z17 = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            arrayList.add(new b(charSequence, true));
        }
        if (aVarArr != null) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, aVarArr);
        }
        c();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, aVarArr3);
        if (aVarArr2 != null) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, aVarArr2);
        }
        if (charSequence2 != null && charSequence2.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            arrayList.add(new b(charSequence2, false));
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).u(this);
        }
    }

    @NotNull
    public final ArrayList<a<?>> a() {
        return this.allConfigList;
    }

    public final boolean b(@NotNull a<?> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.j() && (this.visibleConfigListSize > 0 || this.showOtherConfigIfConfigListEmpty)) {
            return true;
        }
        return false;
    }

    public final void c() {
        Object first;
        Object last;
        Object first2;
        a<?>[] aVarArr = this.configList;
        ArrayList arrayList = new ArrayList();
        for (a<?> aVar : aVarArr) {
            if (aVar.j()) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() == 1) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            ((a) first2).y(PositionType.Only);
        } else if (arrayList.size() > 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            ((a) first).y(PositionType.Top);
            int size = arrayList.size() - 1;
            for (int i3 = 1; i3 < size; i3++) {
                ((a) arrayList.get(i3)).y(PositionType.Middle);
            }
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            ((a) last).y(PositionType.Bottom);
        }
        this.visibleConfigListSize = arrayList.size();
    }

    /* synthetic */ Group(CharSequence charSequence, CharSequence charSequence2, a[] aVarArr, a[] aVarArr2, a[] aVarArr3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : charSequence, (i3 & 2) != 0 ? null : charSequence2, (i3 & 4) != 0 ? null : aVarArr, (i3 & 8) == 0 ? aVarArr2 : null, (i3 & 16) != 0 ? new a[0] : aVarArr3, (i3 & 32) != 0 ? false : z16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Group(@NotNull a<?>... configList) {
        this(null, null, null, null, configList, false, 47, null);
        Intrinsics.checkNotNullParameter(configList, "configList");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Group(@NotNull CharSequence topDescription, @NotNull a<?>... configList) {
        this(topDescription, null, null, null, configList, false, 42, null);
        Intrinsics.checkNotNullParameter(topDescription, "topDescription");
        Intrinsics.checkNotNullParameter(configList, "configList");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Group(@NotNull CharSequence topDescription, @NotNull CharSequence bottomDescription, @NotNull a<?>... configList) {
        this(topDescription, bottomDescription, null, null, configList, false, 40, null);
        Intrinsics.checkNotNullParameter(topDescription, "topDescription");
        Intrinsics.checkNotNullParameter(bottomDescription, "bottomDescription");
        Intrinsics.checkNotNullParameter(configList, "configList");
    }
}
