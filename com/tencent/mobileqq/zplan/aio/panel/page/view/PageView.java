package com.tencent.mobileqq.zplan.aio.panel.page.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.aio.panel.item.view.ItemView;
import com.tencent.upload.report.UploadQualityReportBuilder;
import cooperation.qzone.QZoneClickReport;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "dx", "dy", "", "onScrolled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PageView extends RecyclerView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int dx5, int dy5) {
        Sequence flatMap;
        Sequence mapNotNull;
        flatMap = SequencesKt___SequencesKt.flatMap(ViewGroupKt.getChildren(this), new Function1<View, Sequence<? extends View>>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.view.PageView$onScrolled$1
            @Override // kotlin.jvm.functions.Function1
            public final Sequence<View> invoke(View it) {
                Sequence<View> emptySequence;
                Sequence<View> children;
                Intrinsics.checkNotNullParameter(it, "it");
                ViewGroup viewGroup = it instanceof ViewGroup ? (ViewGroup) it : null;
                if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null) {
                    return children;
                }
                emptySequence = SequencesKt__SequencesKt.emptySequence();
                return emptySequence;
            }
        });
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(flatMap, new Function1<View, ItemView>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.view.PageView$onScrolled$2
            @Override // kotlin.jvm.functions.Function1
            public final ItemView invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof ItemView) {
                    return (ItemView) it;
                }
                return null;
            }
        });
        Iterator it = mapNotNull.iterator();
        while (it.hasNext()) {
            ((ItemView) it.next()).i(dx5, dy5);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\nB/\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "getItemHeightDp", "()F", "itemHeightDp", "b", "d", "bottomMarginDp", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "c", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "e", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "itemTheme", "I", "g", "()I", "spanCount", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "reportSceneType", "<init>", "(FFLcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;ILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.page.view.PageView$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class Theme {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: g, reason: collision with root package name */
        private static final Theme f331278g;

        /* renamed from: h, reason: collision with root package name */
        private static final Theme f331279h;

        /* renamed from: i, reason: collision with root package name */
        private static final Theme f331280i;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final float itemHeightDp;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float bottomMarginDp;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final ItemView.Theme itemTheme;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int spanCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String reportSceneType;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a$a;", "", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "a", "()Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "SPACE", "c", "CONNECT", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.aio.panel.page.view.PageView$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes35.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Theme a() {
                return Theme.f331278g;
            }

            public final Theme b() {
                return Theme.f331280i;
            }

            public final Theme c() {
                return Theme.f331279h;
            }

            Companion() {
            }
        }

        static {
            ItemView.Theme.Companion companion = ItemView.Theme.INSTANCE;
            f331278g = new Theme(83.0f, 8.0f, companion.a(), 5, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
            f331279h = new Theme(101.0f, 13.0f, companion.b(), 4, "friend_time");
            f331280i = new Theme(101.0f, 13.0f, companion.b(), 4, UploadQualityReportBuilder.STATE_CONNECT);
        }

        public Theme(float f16, float f17, ItemView.Theme itemTheme, int i3, String reportSceneType) {
            Intrinsics.checkNotNullParameter(itemTheme, "itemTheme");
            Intrinsics.checkNotNullParameter(reportSceneType, "reportSceneType");
            this.itemHeightDp = f16;
            this.bottomMarginDp = f17;
            this.itemTheme = itemTheme;
            this.spanCount = i3;
            this.reportSceneType = reportSceneType;
        }

        /* renamed from: d, reason: from getter */
        public final float getBottomMarginDp() {
            return this.bottomMarginDp;
        }

        /* renamed from: e, reason: from getter */
        public final ItemView.Theme getItemTheme() {
            return this.itemTheme;
        }

        /* renamed from: f, reason: from getter */
        public final String getReportSceneType() {
            return this.reportSceneType;
        }

        /* renamed from: g, reason: from getter */
        public final int getSpanCount() {
            return this.spanCount;
        }

        public int hashCode() {
            return (((((((Float.floatToIntBits(this.itemHeightDp) * 31) + Float.floatToIntBits(this.bottomMarginDp)) * 31) + this.itemTheme.hashCode()) * 31) + this.spanCount) * 31) + this.reportSceneType.hashCode();
        }

        public String toString() {
            return "Theme(itemHeightDp=" + this.itemHeightDp + ", bottomMarginDp=" + this.bottomMarginDp + ", itemTheme=" + this.itemTheme + ", spanCount=" + this.spanCount + ", reportSceneType=" + this.reportSceneType + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Theme)) {
                return false;
            }
            Theme theme = (Theme) other;
            return Float.compare(this.itemHeightDp, theme.itemHeightDp) == 0 && Float.compare(this.bottomMarginDp, theme.bottomMarginDp) == 0 && Intrinsics.areEqual(this.itemTheme, theme.itemTheme) && this.spanCount == theme.spanCount && Intrinsics.areEqual(this.reportSceneType, theme.reportSceneType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setId(R.id.r6z);
    }
}
