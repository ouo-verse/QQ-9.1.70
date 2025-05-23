package com.tencent.robot.adelie.homepage.category.part.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotTabInfo;
import com.tencent.robot.adelie.homepage.category.part.tab.AdelieHomeCategoryTabBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u001eB\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0014\u0010\r\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u000e\u001a\u00020\bH\u0014J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/part/tab/AdelieHomeCategoryTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "categories", "", "d", "e", "", "position", "width", "height", "c", "setData", "getTabMargin", "", "title", "addTab", "Ljava/util/List;", "getCategoryList", "()Ljava/util/List;", "setCategoryList", "(Ljava/util/List;)V", "categoryList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeCategoryTabBar extends QUIPageTabBar {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f365993e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final List<Pair<Float, Float>> f365994f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<RobotTabInfo> categoryList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/part/tab/AdelieHomeCategoryTabBar$a;", "", "", "DT_ELEMENT_BAS_TAB", "Ljava/lang/String;", "DT_PARAM_TAB_ID", "DT_PARAM_TAB_NAME", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    static {
        List<Pair<Float, Float>> listOf;
        Float valueOf = Float.valueOf(32.0f);
        Float valueOf2 = Float.valueOf(22.0f);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(valueOf, valueOf2), new Pair(valueOf, valueOf2), new Pair(valueOf, valueOf2)});
        f365994f = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieHomeCategoryTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
        setTabChangeListener(new QUIPageTabBar.i() { // from class: w14.a
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                AdelieHomeCategoryTabBar.b(AdelieHomeCategoryTabBar.this, i3, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieHomeCategoryTabBar this$0, int i3, boolean z16) {
        List<RobotTabInfo> list;
        RobotTabInfo robotTabInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.mTabContainer;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i3);
        if (z16 && childAt != null && (list = this$0.categoryList) != null && (robotTabInfo = list.get(i3)) != null) {
            HashMap hashMap = new HashMap();
            String str = robotTabInfo.name;
            Intrinsics.checkNotNullExpressionValue(str, "data.name");
            hashMap.put("tab_name", str);
            String str2 = robotTabInfo.tabId;
            Intrinsics.checkNotNullExpressionValue(str2, "data.tabId");
            hashMap.put("tabid", str2);
            VideoReport.setElementId(childAt, "em_bas_tab");
            VideoReport.setElementClickPolicy(childAt, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("clck", childAt, hashMap);
        }
    }

    private final void c(int position, int width, int height) {
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(R.drawable.f160063j44);
        int dpToPx = ViewUtils.dpToPx(15.5f);
        textView.setPadding(0, dpToPx, 0, dpToPx);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        if (position == 0) {
            layoutParams.leftMargin = getTabMargin();
        }
        layoutParams.rightMargin = getTabMargin();
        layoutParams.gravity = 17;
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    private final void d(List<RobotTabInfo> categories) {
        if (this.mTabContainer != null && !categories.isEmpty() && this.mTabContainer.getChildCount() == categories.size()) {
            int childCount = this.mTabContainer.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.mTabContainer.getChildAt(i3);
                if (childAt == null) {
                    return;
                }
                VideoReport.setElementId(childAt, "em_bas_tab");
                VideoReport.setElementClickPolicy(childAt, ClickPolicy.REPORT_NONE);
                RobotTabInfo robotTabInfo = categories.get(i3);
                HashMap hashMap = new HashMap();
                String str = robotTabInfo.name;
                Intrinsics.checkNotNullExpressionValue(str, "data.name");
                hashMap.put("tab_name", str);
                String str2 = robotTabInfo.tabId;
                Intrinsics.checkNotNullExpressionValue(str2, "data.tabId");
                hashMap.put("tabid", str2);
                VideoReport.setElementParams(childAt, hashMap);
                VideoReport.reportEvent("imp", childAt, hashMap);
            }
        }
    }

    private final void e() {
        int i3 = 0;
        for (Object obj : f365994f) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            c(i3, ViewUtils.dpToPx(((Number) pair.getFirst()).floatValue()), ViewUtils.dpToPx(((Number) pair.getSecond()).floatValue()));
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        ColorStateList colorStateList;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTextSize(17.0f);
        if (position == getCurrentPosition()) {
            colorStateList = this.mCheckedTextColor;
        } else {
            colorStateList = this.mUncheckedTextColor;
        }
        textView.setTextColor(colorStateList);
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (position == 0) {
            layoutParams.leftMargin = getTabMargin();
        }
        layoutParams.rightMargin = getTabMargin();
        FontSettingManager.resetViewSize2Normal(getContext(), textView);
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        return ViewUtils.dpToPx(16.0f);
    }

    public final void setCategoryList(@Nullable List<RobotTabInfo> list) {
        this.categoryList = list;
    }

    public final void setData(@NotNull List<RobotTabInfo> categories) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(categories, "categories");
        List<RobotTabInfo> list = categories;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RobotTabInfo) it.next()).name);
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        setTabData((String[]) array);
        this.categoryList = categories;
        d(categories);
    }
}
