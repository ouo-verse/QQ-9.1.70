package com.tencent.mobileqq.guild.base.view.colorpick;

import android.graphics.Color;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\tR&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R \u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u0004\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/base/view/colorpick/a;", "", "", "", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "getColors$annotations", "()V", NodeProps.COLORS, "c", "I", "()I", "getDefaultColor$annotations", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f214809a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> colors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int defaultColor;

    static {
        List listOf;
        int collectionSizeOrDefault;
        Object first;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"#6998DD", "#2C599A", "#3934D7", "#0048FF", "#0099FF", "#12C1DA", "#4D3376", "#722DDC", "#C136E2", "#E55BA0", "#A16BF0", "#90C600", "#965D12", "#D42D3B", "#FF4A00", "#FF8A00", "#E7AF00", "#03723E"});
        List list = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Color.parseColor((String) it.next())));
        }
        colors = arrayList;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        defaultColor = ((Number) first).intValue();
    }

    a() {
    }

    @NotNull
    public static final List<Integer> a() {
        return colors;
    }

    public static final int b() {
        return defaultColor;
    }
}
