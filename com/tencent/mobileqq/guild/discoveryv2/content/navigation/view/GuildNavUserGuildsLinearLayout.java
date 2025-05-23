package com.tencent.mobileqq.guild.discoveryv2.content.navigation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.discoveryv2.categoryfeatured.view.CategoryFeaturedGroupItem;
import com.tencent.mobileqq.guild.discoveryv2.categoryfeatured.view.CategoryFeaturedItem;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh1.NavCategoryFeaturedGroupItemData;
import vh1.NavCategoryFeaturedItemData;
import vh1.NavFeaturedGroupItemData;
import vh1.NavFeaturedItemData;
import vh1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001[B'\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u00020\u0005\u00a2\u0006\u0004\bX\u0010YJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u0012\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001e\u0010\u0015\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u0019\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u001e\u0010\u001b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J(\u0010\"\u001a\u00020!2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0018\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0014J0\u0010-\u001a\u00020\b2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0014J\u0014\u0010/\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dR\u0014\u00101\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00100R\u0014\u00102\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00100R\u0014\u00103\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u00100R\u0014\u00104\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00100R\u0014\u00105\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00100R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00100R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\"\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00100\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00100\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R(\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00107\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u00100\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\"\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u00100\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R(\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00107\u001a\u0004\bP\u0010D\"\u0004\bQ\u0010F\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/navigation/view/GuildNavUserGuildsLinearLayout;", "Landroid/widget/LinearLayout;", "", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "finalCanShowDataCount", "gap", "", "l", "width", "maxItemCountWithoutLine", h.F, "finalCanShowViewCount", "cacheViews", "g", "Lvh1/d;", "data", "c", "Lvh1/c;", "categoryGuildGroupItemData", "b", "f", "Lvh1/f;", "navFeaturedGroupItemData", "d", "Lvh1/g;", "e", "k", "", "Lvh1/a;", "list1", "list2", "", "j", "list", "i", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "dataList", "setDataList", "I", "itemWidth", "itemHeight", "minGap", "middleGap", "maxGap", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "D", "getCacheWidth", "()I", "setCacheWidth", "(I)V", "cacheWidth", "E", "getCacheHeight", "setCacheHeight", "cacheHeight", UserInfo.SEX_FEMALE, "getCacheDataList", "()Ljava/util/List;", "setCacheDataList", "(Ljava/util/List;)V", "cacheDataList", "G", "getCacheWidthForLayout", "setCacheWidthForLayout", "cacheWidthForLayout", "H", "getCacheHeightForLayout", "setCacheHeightForLayout", "cacheHeightForLayout", "getCacheDataListForLayout", "setCacheDataListForLayout", "cacheDataListForLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNavUserGuildsLinearLayout extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<? extends vh1.a> dataList;

    /* renamed from: D, reason: from kotlin metadata */
    private int cacheWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int cacheHeight;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<? extends vh1.a> cacheDataList;

    /* renamed from: G, reason: from kotlin metadata */
    private int cacheWidthForLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private int cacheHeightForLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<? extends vh1.a> cacheDataListForLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int itemWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int minGap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int middleGap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int maxGap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int maxItemCountWithoutLine;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNavUserGuildsLinearLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(List<View> cacheViews, NavCategoryFeaturedGroupItemData categoryGuildGroupItemData) {
        Object obj;
        Iterator<T> it = cacheViews.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((View) obj) instanceof CategoryFeaturedGroupItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        View view = (View) obj;
        if (view != null) {
            cacheViews.remove(view);
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            obj = new CategoryFeaturedGroupItem(context, null, 0, 6, null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.categoryfeatured.view.CategoryFeaturedGroupItem");
        CategoryFeaturedGroupItem categoryFeaturedGroupItem = (CategoryFeaturedGroupItem) obj;
        categoryFeaturedGroupItem.setLayoutParams(new ViewGroup.MarginLayoutParams(this.itemWidth, this.itemHeight));
        categoryFeaturedGroupItem.setData(categoryGuildGroupItemData);
        addView((View) obj);
    }

    private final void c(List<View> cacheViews, NavCategoryFeaturedItemData data) {
        Object obj;
        Iterator<T> it = cacheViews.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((View) obj) instanceof CategoryFeaturedItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        View view = (View) obj;
        if (view != null) {
            cacheViews.remove(view);
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            obj = new CategoryFeaturedItem(context, null, 0, 6, null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.categoryfeatured.view.CategoryFeaturedItem");
        CategoryFeaturedItem categoryFeaturedItem = (CategoryFeaturedItem) obj;
        categoryFeaturedItem.setLayoutParams(new ViewGroup.MarginLayoutParams(this.itemWidth, this.itemHeight));
        categoryFeaturedItem.setData(data);
        addView((View) obj);
    }

    private final void d(List<View> cacheViews, NavFeaturedGroupItemData navFeaturedGroupItemData) {
        Object obj;
        Iterator<T> it = cacheViews.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((View) obj) instanceof NavFeaturedGroupItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        View view = (View) obj;
        if (view != null) {
            cacheViews.remove(view);
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            obj = new NavFeaturedGroupItem(context, null, 0, 6, null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.NavFeaturedGroupItem");
        NavFeaturedGroupItem navFeaturedGroupItem = (NavFeaturedGroupItem) obj;
        navFeaturedGroupItem.setLayoutParams(new ViewGroup.MarginLayoutParams(this.itemWidth, this.itemHeight));
        navFeaturedGroupItem.setData(navFeaturedGroupItemData);
        addView((View) obj);
    }

    private final void e(List<View> cacheViews, NavFeaturedItemData data) {
        Object obj;
        Iterator<T> it = cacheViews.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((View) obj) instanceof NavFeaturedItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        View view = (View) obj;
        if (view != null) {
            cacheViews.remove(view);
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            obj = new NavFeaturedItem(context, null, 0, 6, null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.NavFeaturedItem");
        NavFeaturedItem navFeaturedItem = (NavFeaturedItem) obj;
        navFeaturedItem.setLayoutParams(new ViewGroup.MarginLayoutParams(this.itemWidth, this.itemHeight));
        navFeaturedItem.setData(data);
        addView((View) obj);
    }

    private final void f(List<View> cacheViews) {
        Object obj;
        Iterator<T> it = cacheViews.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((View) obj) instanceof NavLineView) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        View view = (View) obj;
        if (view != null) {
            cacheViews.remove(view);
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            obj = new NavLineView(context, null, 0, 6, null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.NavLineView");
        NavLineView navLineView = (NavLineView) obj;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(navLineView.getLineItemWidth(), navLineView.getLineItemHeight());
        marginLayoutParams.topMargin = navLineView.getLineTopMargin();
        navLineView.setLayoutParams(marginLayoutParams);
        addView((View) obj);
    }

    private final void g(int finalCanShowViewCount, List<View> cacheViews) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        for (int i3 = 0; i3 < finalCanShowViewCount; i3++) {
            vh1.a aVar = this.dataList.get(i3);
            if (aVar instanceof NavFeaturedItemData) {
                if (i3 == finalCanShowViewCount - 1) {
                    List<? extends vh1.a> list = this.dataList;
                    List<? extends vh1.a> subList = list.subList(i3, list.size());
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : subList) {
                        if (obj instanceof NavFeaturedItemData) {
                            arrayList.add(obj);
                        }
                    }
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((NavFeaturedItemData) it.next()).getGuildAvatarUrl());
                    }
                    if (arrayList2.size() > 1) {
                        vh1.a aVar2 = this.dataList.get(i3);
                        Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.content.navigation.NavFeaturedItemData");
                        NavFeaturedItemData navFeaturedItemData = (NavFeaturedItemData) aVar2;
                        d(cacheViews, new NavFeaturedGroupItemData(arrayList2, "\u66f4\u591a", navFeaturedItemData.getConfId(), navFeaturedItemData.getIsLittleWorldCreate(), navFeaturedItemData.b()));
                    } else {
                        e(cacheViews, (NavFeaturedItemData) aVar);
                    }
                } else {
                    e(cacheViews, (NavFeaturedItemData) aVar);
                }
            } else if (aVar instanceof i) {
                f(cacheViews);
            } else if (aVar instanceof NavCategoryFeaturedItemData) {
                if (i3 == finalCanShowViewCount - 1) {
                    List<? extends vh1.a> list2 = this.dataList;
                    List<? extends vh1.a> subList2 = list2.subList(i3, list2.size());
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : subList2) {
                        if (obj2 instanceof NavCategoryFeaturedItemData) {
                            arrayList3.add(obj2);
                        }
                    }
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                    ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        arrayList4.add(((NavCategoryFeaturedItemData) it5.next()).getGuildAvatarUrl());
                    }
                    if (arrayList4.size() > 1) {
                        vh1.a aVar3 = this.dataList.get(i3);
                        Intrinsics.checkNotNull(aVar3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.content.navigation.NavCategoryFeaturedItemData");
                        b(cacheViews, new NavCategoryFeaturedGroupItemData(arrayList4, "\u66f4\u591a", ((NavCategoryFeaturedItemData) aVar3).getConfId()));
                    } else {
                        c(cacheViews, (NavCategoryFeaturedItemData) aVar);
                    }
                } else {
                    c(cacheViews, (NavCategoryFeaturedItemData) aVar);
                }
            }
        }
    }

    private final int h(int width, int maxItemCountWithoutLine) {
        int i3 = this.itemWidth * maxItemCountWithoutLine;
        int i16 = this.minGap;
        int i17 = maxItemCountWithoutLine - 1;
        int max = i16 + ((width - (i3 + (i16 * i17))) / Math.max(1, i17));
        if (max > this.maxGap) {
            return this.middleGap;
        }
        return max;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<vh1.a> i(List<? extends vh1.a> list) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(list.get(0));
        int size = list.size();
        for (int i3 = 1; i3 < size; i3++) {
            if (!Intrinsics.areEqual(list.get(i3).getClass(), list.get(i3 - 1).getClass())) {
                arrayList.add(new i());
            }
            arrayList.add(list.get(i3));
        }
        return arrayList;
    }

    private final boolean j(List<? extends vh1.a> list1, List<? extends vh1.a> list2) {
        if (list1 == list2) {
            return true;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        int size = list1.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Objects.equals(list1.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private final void k(int gap) {
        int childCount = getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt instanceof NavLineView) {
                int i17 = i3 - (gap / 2);
                NavLineView navLineView = (NavLineView) childAt;
                childAt.layout(i17, navLineView.getLineTopMargin(), navLineView.getLineItemWidth() + i17, navLineView.getLineItemHeight() + navLineView.getLineTopMargin());
            } else {
                int i18 = this.itemWidth + i3;
                childAt.layout(i3, 0, i18, this.itemHeight);
                i3 = i18 + gap;
            }
        }
    }

    private final void l(int finalCanShowDataCount, int gap) {
        for (int i3 = 0; i3 < finalCanShowDataCount; i3++) {
            View childAt = getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i16 = gap / 2;
            marginLayoutParams.leftMargin = i16;
            marginLayoutParams.rightMargin = i16;
            childAt.setLayoutParams(marginLayoutParams);
            if (childAt instanceof NavLineView) {
                NavLineView navLineView = (NavLineView) childAt;
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(navLineView.getLineItemWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(navLineView.getLineItemHeight(), 1073741824));
            } else {
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(this.itemWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824));
            }
        }
    }

    private final List<View> m() {
        ArrayList arrayList = new ArrayList();
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        removeAllViews();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildNavUserGuildsLinearLayout this$0, List dataList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        this$0.dataList = this$0.i(dataList);
        this$0.requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i3 = right - left;
        int i16 = bottom - top;
        if (i3 == this.cacheWidthForLayout && i16 == this.cacheHeightForLayout && j(this.cacheDataListForLayout, this.dataList)) {
            QLog.i("GuildNavUserGuildsLinearLayout", 4, "onLayout, newWidth == cacheWidthForLayout(" + this.cacheWidthForLayout + ") && newHeight == cacheHeightForLayout(" + this.cacheHeightForLayout + ") && isListEqual, do not need to layout again, return");
            return;
        }
        this.cacheWidthForLayout = i3;
        this.cacheHeightForLayout = i16;
        this.cacheDataListForLayout = this.dataList;
        k(h(i3, this.maxItemCountWithoutLine));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        List take;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (size == this.cacheWidth && size2 == this.cacheHeight && j(this.cacheDataList, this.dataList)) {
            QLog.i("GuildNavUserGuildsLinearLayout", 4, "onMeasure, width == cacheWidth(" + this.cacheWidth + ") && height == cacheHeight(" + this.cacheHeight + ") && isListEqual, do not need to measure again, return");
            setMeasuredDimension(size, size2);
            return;
        }
        this.cacheWidth = size;
        this.cacheHeight = size2;
        List<? extends vh1.a> list = this.dataList;
        this.cacheDataList = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!(((vh1.a) obj) instanceof i)) {
                arrayList.add(obj);
            }
        }
        int size3 = (this.itemWidth * arrayList.size()) + (this.minGap * (arrayList.size() - 1));
        this.maxItemCountWithoutLine = arrayList.size();
        int i3 = this.itemWidth;
        int i16 = this.minGap;
        if (size3 > (size - i3) - i16) {
            this.maxItemCountWithoutLine = (size + i16) / (i3 + i16);
        }
        int h16 = h(size, this.maxItemCountWithoutLine);
        List<View> m3 = m();
        int min = Math.min(arrayList.size(), this.maxItemCountWithoutLine);
        take = CollectionsKt___CollectionsKt.take(this.dataList, min);
        List list2 = take;
        int i17 = 0;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if ((((vh1.a) it.next()) instanceof i) && (i17 = i17 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        int i18 = min + i17;
        g(i18, m3);
        VideoReport.traversePage(this);
        l(i18, h16);
        setMeasuredDimension(size, size2);
    }

    public final void setCacheDataList(@NotNull List<? extends vh1.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cacheDataList = list;
    }

    public final void setCacheDataListForLayout(@NotNull List<? extends vh1.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cacheDataListForLayout = list;
    }

    public final void setCacheHeight(int i3) {
        this.cacheHeight = i3;
    }

    public final void setCacheHeightForLayout(int i3) {
        this.cacheHeightForLayout = i3;
    }

    public final void setCacheWidth(int i3) {
        this.cacheWidth = i3;
    }

    public final void setCacheWidthForLayout(int i3) {
        this.cacheWidthForLayout = i3;
    }

    public final void setDataList(@NotNull final List<? extends vh1.a> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildNavUserGuildsLinearLayout.n(GuildNavUserGuildsLinearLayout.this, dataList);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNavUserGuildsLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildNavUserGuildsLinearLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNavUserGuildsLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<? extends vh1.a> emptyList;
        List<? extends vh1.a> emptyList2;
        List<? extends vh1.a> emptyList3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemWidth = bi.b(60);
        this.itemHeight = bi.b(72);
        this.minGap = bi.b(10);
        this.middleGap = bi.b(24);
        this.maxGap = bi.b(36);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.dataList = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.cacheDataList = emptyList2;
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.cacheDataListForLayout = emptyList3;
    }
}
