package com.tencent.mobileqq.activity.qcircle.utils;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.qcircle.bubble.IconType;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleContentElement;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleCounterStyle$BubbleContent;
import qqcircle.QQCircleCounterStyle$StyleBubble;
import qqcircle.QQCircleCounterStyle$StyleIcon;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0000\u00a8\u0006\f"}, d2 = {"Lqqcircle/QQCircleCounterStyle$StyleBubble;", "", "a", "", "Landroid/graphics/drawable/Drawable;", "iconDrawableList", "Lcom/tencent/mobileqq/activity/qcircle/bubble/k$b;", "c", "Lcom/tencent/mobileqq/activity/qcircle/bubble/g;", "b", "Lcom/tencent/mobileqq/activity/qcircle/bubble/IconType;", "d", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {
    @NotNull
    public static final String a(@NotNull QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble) {
        Intrinsics.checkNotNullParameter(qQCircleCounterStyle$StyleBubble, "<this>");
        List<QQCircleCounterStyle$BubbleContent> list = qQCircleCounterStyle$StyleBubble.contents.get();
        Intrinsics.checkNotNullExpressionValue(list, "contents.get()");
        Iterator<T> it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + ((QQCircleCounterStyle$BubbleContent) it.next()).text.get();
        }
        return str;
    }

    @NotNull
    public static final List<QCircleTabRedPointBubbleContentElement> b(@NotNull QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(qQCircleCounterStyle$StyleBubble, "<this>");
        List<QQCircleCounterStyle$BubbleContent> list = qQCircleCounterStyle$StyleBubble.contents.get();
        Intrinsics.checkNotNullExpressionValue(list, "contents.get()");
        List<QQCircleCounterStyle$BubbleContent> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (QQCircleCounterStyle$BubbleContent qQCircleCounterStyle$BubbleContent : list2) {
            String str = qQCircleCounterStyle$BubbleContent.text.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.text.get()");
            String str2 = qQCircleCounterStyle$BubbleContent.color.get();
            Intrinsics.checkNotNullExpressionValue(str2, "it.color.get()");
            arrayList.add(new QCircleTabRedPointBubbleContentElement(str, str2, qQCircleCounterStyle$BubbleContent.bold.get()));
        }
        return arrayList;
    }

    @NotNull
    public static final List<QCircleTabRedPointBubbleInfo.IconInfo> c(@NotNull QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble, @NotNull List<? extends Drawable> iconDrawableList) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(qQCircleCounterStyle$StyleBubble, "<this>");
        Intrinsics.checkNotNullParameter(iconDrawableList, "iconDrawableList");
        List<QQCircleCounterStyle$StyleIcon> iconList = qQCircleCounterStyle$StyleBubble.icons.get();
        Intrinsics.checkNotNullExpressionValue(iconList, "iconList");
        if (!iconList.isEmpty()) {
            List<Integer> list = iconList.get(0).alphas.get();
            QLog.i("StyleBubbleExt", 1, "toIconInfoList, alphaList=" + list);
            if (!list.isEmpty() && list.size() == iconDrawableList.size()) {
                List<? extends Drawable> list2 = iconDrawableList;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                arrayList = new ArrayList(collectionSizeOrDefault2);
                for (Drawable drawable : list2) {
                    Integer percentAlpha = list.get(iconDrawableList.indexOf(drawable));
                    Intrinsics.checkNotNullExpressionValue(percentAlpha, "percentAlpha");
                    arrayList.add(new QCircleTabRedPointBubbleInfo.IconInfo(drawable, Integer.valueOf(Math.max(Math.min(percentAlpha.intValue(), 100), 0)).intValue() / 100.0f));
                }
            } else {
                QLog.i("StyleBubbleExt", 1, "toIconInfoList, use default max alpha");
                List<? extends Drawable> list3 = iconDrawableList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(new QCircleTabRedPointBubbleInfo.IconInfo((Drawable) it.next(), 1.0f));
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @NotNull
    public static final IconType d(@NotNull QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble) {
        Intrinsics.checkNotNullParameter(qQCircleCounterStyle$StyleBubble, "<this>");
        int i3 = qQCircleCounterStyle$StyleBubble.styleType.get();
        if (i3 != 1) {
            if (i3 != 2) {
                return IconType.NONE;
            }
            return IconType.PICTURE;
        }
        return IconType.AVATAR;
    }
}
