package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00015B1\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0014\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u0011\u001a\u00020\u0004H\u0014J0\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0014J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "", "c", "", "position", "", "title", "addTab", "currentPos", "updateTextColor", "", "getUnderLineRect", "", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$b;", "tabDataList", "setTabData", "getTabMargin", "", "changed", "l", "t", "r", "b", "onLayout", "invalidate", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$RetryInvalidateRunnable;", "d", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$RetryInvalidateRunnable;", "retryInvalidateRunnable", "e", "Z", "underLineOptimizationSwitch", "f", "I", "extraPadding", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar$a$a;", h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar$a$a;", "getTabBarsUpdatedCallback", "()Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar$a$a;", "setTabBarsUpdatedCallback", "(Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar$a$a;)V", "tabBarsUpdatedCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildDiscoveryTabBar extends QUIPageTabBar {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildQUIPageTabBar.RetryInvalidateRunnable<GuildDiscoveryTabBar> retryInvalidateRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean underLineOptimizationSwitch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int extraPadding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Companion.InterfaceC7730a tabBarsUpdatedCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDiscoveryTabBar(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        if (this.mTabCount <= 1) {
            return;
        }
        String[] mTabTexts = this.mTabTexts;
        Intrinsics.checkNotNullExpressionValue(mTabTexts, "mTabTexts");
        int i3 = 0;
        for (String str : mTabTexts) {
            i3 += (int) this.mPaint.measureText(str);
        }
        int measuredWidth = getMeasuredWidth();
        int i16 = this.extraPadding;
        float f16 = (((measuredWidth - i16) - i16) - i3) / (this.mTabCount - 1);
        int dip2px = ViewUtils.dip2px(24.0f);
        int dip2px2 = ViewUtils.dip2px(60.0f);
        if (f16 < dip2px || f16 > dip2px2) {
            f16 = ViewUtils.dip2px(24.0f);
        }
        int i17 = this.mTabCount - 1;
        for (int i18 = 0; i18 < i17; i18++) {
            View childAt = this.mTabContainer.getChildAt(i18);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = (int) f16;
            marginLayoutParams.leftMargin = 0;
            childAt.setLayoutParams(marginLayoutParams);
        }
        View childAt2 = this.mTabContainer.getChildAt(0);
        View childAt3 = this.mTabContainer.getChildAt(this.mTabCount - 1);
        ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.leftMargin = this.extraPadding;
        childAt2.setLayoutParams(marginLayoutParams2);
        ViewGroup.LayoutParams layoutParams3 = childAt3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
        marginLayoutParams3.rightMargin = this.extraPadding;
        childAt3.setLayoutParams(marginLayoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        TextView textView;
        boolean z16;
        super.addTab(position, title);
        View childAt = this.mTabContainer.getChildAt(position);
        if (childAt instanceof TextView) {
            textView = (TextView) childAt;
        } else {
            textView = null;
        }
        if (textView != null) {
            if (position == getCurrentPosition()) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setSelected(z16);
            if (position == getCurrentPosition()) {
                s.a(textView, 500, 1);
            } else {
                s.a(textView, 300, 0);
            }
        }
        if (this.mTabCount - 1 == position) {
            c();
            Companion.InterfaceC7730a interfaceC7730a = this.tabBarsUpdatedCallback;
            if (interfaceC7730a != null) {
                LinearLayout mTabContainer = this.mTabContainer;
                Intrinsics.checkNotNullExpressionValue(mTabContainer, "mTabContainer");
                interfaceC7730a.a(ViewGroupKt.getChildren(mTabContainer));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        if (this.mTabCount <= 1) {
            return this.extraPadding;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    @NotNull
    public int[] getUnderLineRect(int position) {
        View childAt = this.mTabContainer.getChildAt(position);
        if (childAt == null) {
            QLog.e("GuildDiscoveryTabBar", 1, "getUnderLineRect, currentTab is null!");
            return new int[]{0, 0, 0, 0};
        }
        int height = getHeight() - ViewUtils.dip2px(3.0f);
        int height2 = getHeight();
        int measureText = (int) this.mPaint.measureText(this.mTabTexts[position]);
        int left = childAt.getLeft() + ViewUtils.dip2px(6.0f);
        int left2 = (childAt.getLeft() + measureText) - ViewUtils.dip2px(6.0f);
        int[] iArr = {left, height, left2, height2};
        if (this.underLineOptimizationSwitch && childAt.getRight() - childAt.getLeft() == 0) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.retryInvalidateRunnable);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.retryInvalidateRunnable, 200L);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                int i3 = this.mAnimationStartX;
                String arrays = Arrays.toString(iArr);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                Log.d("GuildDiscoveryTabBar", "getUnderLineRect position:" + position + ", startX=" + i3 + ", (reset), ret:" + arrays);
            }
            return new int[]{0, height, left2, height2};
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            int i16 = this.mAnimationStartX;
            String arrays2 = Arrays.toString(iArr);
            Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
            Log.d("GuildDiscoveryTabBar", "getUnderLineRect position:" + position + ", startX=" + i16 + ", ret:" + arrays2);
        }
        return iArr;
    }

    @Override // android.view.View
    public void invalidate() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildDiscoveryTabBar", "invalidate");
        }
        super.invalidate();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        if (changed) {
            c();
        }
    }

    public final void setTabBarsUpdatedCallback(@Nullable Companion.InterfaceC7730a interfaceC7730a) {
        this.tabBarsUpdatedCallback = interfaceC7730a;
    }

    public final void setTabData(@NotNull List<GuildQUIPageTabBar.GuildQUIPagerTabData> tabDataList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(tabDataList, "tabDataList");
        Logger.f235387a.d().i("GuildDiscoveryTabBar", 1, "setTabData tabDataList:" + tabDataList);
        List<GuildQUIPageTabBar.GuildQUIPagerTabData> list = tabDataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((GuildQUIPageTabBar.GuildQUIPagerTabData) it.next()).getDrawable());
        }
        CollectionsKt___CollectionsKt.toList(arrayList);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((GuildQUIPageTabBar.GuildQUIPagerTabData) it5.next()).getTitle());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        super.setTabData((String[]) array);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        TextView textView;
        boolean z16;
        super.updateTextColor(currentPos);
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                textView = null;
            }
            if (textView != null) {
                if (i3 == currentPos) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                textView.setSelected(z16);
                if (textView.isSelected()) {
                    s.a(textView, 500, 1);
                } else {
                    s.a(textView, 300, 0);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDiscoveryTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDiscoveryTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildDiscoveryTabBar(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDiscoveryTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.retryInvalidateRunnable = new GuildQUIPageTabBar.RetryInvalidateRunnable<>(this, new Function1<GuildDiscoveryTabBar, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.widget.GuildDiscoveryTabBar$retryInvalidateRunnable$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildDiscoveryTabBar guildDiscoveryTabBar) {
                invoke2(guildDiscoveryTabBar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildDiscoveryTabBar $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                ((QUIPageTabBar) $receiver).mAnimationStartX = 0;
            }
        });
        this.underLineOptimizationSwitch = true;
        this.extraPadding = ViewUtils.dip2px(16.0f);
        this.mTabContainer.getLayoutParams().width = -2;
        this.mCheckedTextColor = ie0.a.f().h(getContext(), R.color.qui_common_text_primary, 1000);
    }
}
