package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001c\u0010 B#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH\u0002J\u0014\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProNavigatorBar;", "Landroid/widget/FrameLayout;", "", tl.h.F, "", "g", "j", "Lcom/qzone/reborn/feedpro/widget/header/NavigatorItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "itemWidth", "Landroid/view/View;", "c", "itemView", "e", "", "items", "setNavigatorItems", "i", "d", "Ljava/util/List;", "navigatorItems", "Landroid/widget/LinearLayout;", "Lkotlin/Lazy;", "f", "()Landroid/widget/LinearLayout;", "containerLayout", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProNavigatorBar extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<NavigatorItem> navigatorItems;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy containerLayout;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedpro/widget/header/QzoneFeedProNavigatorBar$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QzoneFeedProNavigatorBar.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            QzoneFeedProNavigatorBar.this.j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProNavigatorBar(Context context) {
        super(context);
        List<NavigatorItem> emptyList;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.navigatorItems = emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProNavigatorBar$containerLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(QzoneFeedProNavigatorBar.this.getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                return linearLayout;
            }
        });
        this.containerLayout = lazy;
        h();
    }

    private final View c(final NavigatorItem item, int itemWidth) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(itemWidth, -1));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(linearLayout.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ef.d.b(20), ef.d.b(20));
        layoutParams.setMarginEnd(ef.d.b(2));
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(item.getIconResId());
        com.qzone.reborn.feedpro.utils.aa aaVar = com.qzone.reborn.feedpro.utils.aa.f54263a;
        com.qzone.reborn.feedpro.utils.aa.c(aaVar, imageView, 0.0f, 1, null);
        linearLayout.addView(imageView);
        TextView textView = new TextView(linearLayout.getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(item.getText());
        textView.setTextColor(ResourcesCompat.getColor(textView.getResources(), R.color.qui_common_text_primary, null));
        textView.setTextSize(16.0f);
        textView.setIncludeFontPadding(false);
        com.qzone.reborn.feedpro.utils.aa.e(aaVar, textView, 0.0f, 1, null);
        linearLayout.addView(textView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.header.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProNavigatorBar.d(NavigatorItem.this, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(NavigatorItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        item.c().invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e(NavigatorItem item, View itemView) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("channellist_alert", 0);
        linkedHashMap.put("column_type", Integer.valueOf(item.getIEntranceId()));
        linkedHashMap.put("is_friend_profile_picture", 0);
        fo.b bVar = new fo.b();
        bVar.l(linkedHashMap);
        bVar.i("entrance_id=" + item.getIEntranceId());
        fo.c.o(itemView, "em_qz_space_entry_column", bVar);
    }

    private final LinearLayout f() {
        return (LinearLayout) this.containerLayout.getValue();
    }

    private final int g() {
        return getWidth() / this.navigatorItems.size();
    }

    private final void h() {
        addView(f());
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        f().removeAllViews();
        if (this.navigatorItems.isEmpty()) {
            return;
        }
        int g16 = g();
        for (NavigatorItem navigatorItem : this.navigatorItems) {
            View c16 = c(navigatorItem, g16);
            f().addView(c16);
            e(navigatorItem, c16);
        }
    }

    public final void i() {
        if (this.navigatorItems.isEmpty()) {
            return;
        }
        int childCount = f().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            f().getChildAt(i3).setLayoutParams(new LinearLayout.LayoutParams(g(), -1));
        }
    }

    public final void setNavigatorItems(List<NavigatorItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.navigatorItems = items;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProNavigatorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        List<NavigatorItem> emptyList;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.navigatorItems = emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProNavigatorBar$containerLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(QzoneFeedProNavigatorBar.this.getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                return linearLayout;
            }
        });
        this.containerLayout = lazy;
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProNavigatorBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<NavigatorItem> emptyList;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.navigatorItems = emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProNavigatorBar$containerLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(QzoneFeedProNavigatorBar.this.getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                return linearLayout;
            }
        });
        this.containerLayout = lazy;
        h();
    }
}
