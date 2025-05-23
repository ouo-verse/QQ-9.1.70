package com.tencent.biz.qqcircle.immersive.utils;

import android.content.Intent;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabNameInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StSubTabInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/bq;", "", "", "tabType", "", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleTabNameInfo;", "tabNameInfo", "", "e", "c", "Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;", "tabInfo", "Landroid/content/Intent;", "intent", "", "isRememberSubTabInfo", "isTransmitSubTabInfo", "a", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bq {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bq f90197a = new bq();

    bq() {
    }

    private final String d(int tabType) {
        return "sp_key_selected_tab_info_" + tabType;
    }

    @NotNull
    public final QCircleTabNameInfo a(@NotNull QCircleTabInfo tabInfo, @Nullable Intent intent, boolean isRememberSubTabInfo, boolean isTransmitSubTabInfo) {
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        int type = tabInfo.getType();
        if (type != 8) {
            QCircleTabNameInfo.Companion companion = QCircleTabNameInfo.INSTANCE;
            String name = tabInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name, "tabInfo.name");
            return companion.create(type, name);
        }
        int b16 = b(intent);
        if (b16 != -1) {
            QLog.d("RememberTabInfoUtil", 1, "createTabNameInfo, assignShowSubTabType:" + b16);
            QCircleTabNameInfo.Companion companion2 = QCircleTabNameInfo.INSTANCE;
            String name2 = tabInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "tabInfo.name");
            return companion2.create(type, name2);
        }
        QLog.d("RememberTabInfoUtil", 1, "createTabNameInfo, rememberSubTabInfo:" + isRememberSubTabInfo + ", transmitSubTabInfo:" + isTransmitSubTabInfo);
        if (!isRememberSubTabInfo) {
            try {
                QCircleTabNameInfo.Companion companion3 = QCircleTabNameInfo.INSTANCE;
                String name3 = tabInfo.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "tabInfo.name");
                return companion3.create(type, name3);
            } catch (Error e16) {
                QLog.e("RememberTabInfoUtil", 1, "createTabNameInfo, error ", e16);
                String name4 = tabInfo.getName();
                Intrinsics.checkNotNullExpressionValue(name4, "tabInfo.name");
                return new QCircleTabNameInfo(type, name4, 0, null, false, 28, null);
            }
        }
        QCircleTabNameInfo c16 = c(type);
        QLog.d("RememberTabInfoUtil", 1, "createTabNameInfo, tabType: " + type + ", selectedTabInfo: " + c16);
        if (c16 == null) {
            QCircleTabNameInfo.Companion companion4 = QCircleTabNameInfo.INSTANCE;
            String name5 = tabInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name5, "tabInfo.name");
            return companion4.create(type, name5);
        }
        List<QQCircleFeedBase$StSubTabInfo> subTabInfoList = tabInfo.mTab.subTabInfo.get();
        Intrinsics.checkNotNullExpressionValue(subTabInfoList, "subTabInfoList");
        Iterator<QQCircleFeedBase$StSubTabInfo> it = subTabInfoList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (it.next().sourceType.get() == c16.getSelectedSubTabType()) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            QLog.d("RememberTabInfoUtil", 1, "createTabNameInfo, index is -1 ");
            QCircleTabNameInfo.Companion companion5 = QCircleTabNameInfo.INSTANCE;
            String name6 = tabInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name6, "tabInfo.name");
            return companion5.create(type, name6);
        }
        QQCircleFeedBase$StSubTabInfo qQCircleFeedBase$StSubTabInfo = subTabInfoList.get(i3);
        if (qQCircleFeedBase$StSubTabInfo == null) {
            QLog.d("RememberTabInfoUtil", 1, "createTabNameInfo, subTabInfo is null ");
            QCircleTabNameInfo.Companion companion6 = QCircleTabNameInfo.INSTANCE;
            String name7 = tabInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name7, "tabInfo.name");
            return companion6.create(type, name7);
        }
        tabInfo.mTab.defaultSubTabindex.set(i3);
        QCircleTabNameInfo.Companion companion7 = QCircleTabNameInfo.INSTANCE;
        String name8 = tabInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name8, "tabInfo.name");
        int i16 = qQCircleFeedBase$StSubTabInfo.sourceType.get();
        String str = qQCircleFeedBase$StSubTabInfo.tabName.get();
        Intrinsics.checkNotNullExpressionValue(str, "subTabInfo.tabName.get()");
        return companion7.create(type, name8, i16, str, isTransmitSubTabInfo);
    }

    public final int b(@Nullable Intent intent) {
        QCircleFolderBean qCircleFolderBean;
        if (intent == null || !intent.hasExtra("key_bundle_common_init_bean")) {
            return -1;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QCircleFolderBean) {
            qCircleFolderBean = (QCircleFolderBean) serializableExtra;
        } else {
            qCircleFolderBean = null;
        }
        if (qCircleFolderBean == null) {
            return -1;
        }
        return qCircleFolderBean.getAssignShowSubTabType();
    }

    @Nullable
    public final QCircleTabNameInfo c(int tabType) {
        String h16 = uq3.k.a().h(d(tabType), "");
        QLog.d("RememberTabInfoUtil", 1, "getSelectedTabInfo, tabType:" + tabType + ", json:" + h16);
        return QCircleTabNameInfo.INSTANCE.fromJson(h16);
    }

    public final void e(@NotNull QCircleTabNameInfo tabNameInfo) {
        Intrinsics.checkNotNullParameter(tabNameInfo, "tabNameInfo");
        QLog.d("RememberTabInfoUtil", 1, "saveSelectedTabInfo, info:" + tabNameInfo);
        uq3.k.a().p(d(tabNameInfo.getTabType()), tabNameInfo.toJson());
    }
}
