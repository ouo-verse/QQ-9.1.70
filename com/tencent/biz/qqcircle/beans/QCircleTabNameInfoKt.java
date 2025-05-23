package com.tencent.biz.qqcircle.beans;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a4\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0001\u00a8\u0006\f"}, d2 = {"contains", "", "", "Lcom/tencent/biz/qqcircle/beans/QCircleTabNameInfo;", "tabName", "", "updateSelectedSubTabName", "tabType", "", "subTabType", "subTabName", "showSelectedSubTabName", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QCircleTabNameInfoKt {
    public static final boolean contains(@NotNull List<QCircleTabNameInfo> list, @NotNull String tabName) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((QCircleTabNameInfo) obj).getTabName(), tabName)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public static final QCircleTabNameInfo updateSelectedSubTabName(@NotNull List<QCircleTabNameInfo> list, int i3, int i16, @NotNull String subTabName, boolean z16) {
        boolean z17;
        Object obj;
        boolean z18;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(subTabName, "subTabName");
        if (i3 == -1 || i16 == -1) {
            return null;
        }
        if (subTabName.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((QCircleTabNameInfo) obj).getTabType() == i3) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QCircleTabNameInfo qCircleTabNameInfo = (QCircleTabNameInfo) obj;
        if (qCircleTabNameInfo == null) {
            return null;
        }
        qCircleTabNameInfo.setSelectedSubTabType(i16);
        qCircleTabNameInfo.setSelectedSubTabName(subTabName);
        qCircleTabNameInfo.setNeedShowSelectedSubTabName(z16);
        return qCircleTabNameInfo;
    }

    public static /* synthetic */ QCircleTabNameInfo updateSelectedSubTabName$default(List list, int i3, int i16, String str, boolean z16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = true;
        }
        return updateSelectedSubTabName(list, i3, i16, str, z16);
    }
}
