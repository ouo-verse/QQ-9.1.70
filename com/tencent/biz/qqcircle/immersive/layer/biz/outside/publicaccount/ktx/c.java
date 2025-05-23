package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.Scene;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n\u001a\f\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u0000\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\u0006*\u00020\u0000\"\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012\"\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "", "g", h.F, "k", "needRequest", "", "j", "needAutoRefresh", "i", "Lqqcircle/QQCircleFeedBase$StFeedListBusiReqData;", "bizReqData", "l", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/Scene;", "c", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)Z", "isImmersiveFromPublicAccount", "d", "shouldReuseExistedPage", "a", "enableRefresh", "b", "needAutoReFreshImmersive", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c {
    public static final boolean a(@NotNull QCircleInitBean qCircleInitBean) {
        String str;
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs != null) {
            str = schemeAttrs.get(QCircleScheme.AttrDetail.ENABLE_REFRESH);
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "1");
    }

    public static final boolean b(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            return false;
        }
        return Intrinsics.areEqual(schemeAttrs.get(QCircleScheme.AttrDetail.QCIRCLE_IMMERSIVE_AUTO_REFRESH), "1");
    }

    @NotNull
    public static final Scene c(@Nullable QCircleInitBean qCircleInitBean) {
        if (an.d(qCircleInitBean)) {
            return Scene.Q_CIRCLE_PROBE_TAB;
        }
        return Scene.Q_CIRCLE_PUBLIC_ACCOUNT_MSG_TAG;
    }

    public static final boolean d(@NotNull QCircleInitBean qCircleInitBean) {
        String str;
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs != null) {
            str = schemeAttrs.get(QCircleScheme.AttrDetail.SHOULD_REUSE_EXISTED_PAGE);
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "1");
    }

    public static final boolean e(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            return false;
        }
        return Intrinsics.areEqual(schemeAttrs.get("xsj_custom_pgid"), "pg_xsj_chat_history_short_video_page");
    }

    public static final boolean f(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        if (!g(qCircleInitBean) && !h(qCircleInitBean)) {
            return false;
        }
        return true;
    }

    public static final boolean g(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            return false;
        }
        return Intrinsics.areEqual(schemeAttrs.get("xsj_custom_pgid"), "pg_xsj_gzh_page");
    }

    public static final boolean h(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        return Intrinsics.areEqual(qCircleInitBean.getLaunchFrom(), "biz_public_account_from_staggered");
    }

    public static final void i(@NotNull QCircleInitBean qCircleInitBean, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            schemeAttrs = new HashMap<>();
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        schemeAttrs.put(QCircleScheme.AttrDetail.QCIRCLE_IMMERSIVE_AUTO_REFRESH, str);
        qCircleInitBean.setSchemeAttrs(schemeAttrs);
    }

    public static final void j(@NotNull QCircleInitBean qCircleInitBean, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            schemeAttrs = new HashMap<>();
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        schemeAttrs.put(QCircleScheme.AttrDetail.QCIRCLE_IMMERSIVE_REQUEST_SPECIFIC_FEED, str);
        qCircleInitBean.setSchemeAttrs(schemeAttrs);
    }

    public static final boolean k(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            schemeAttrs = new HashMap<>();
        }
        return Intrinsics.areEqual(schemeAttrs.get(QCircleScheme.AttrDetail.QCIRCLE_IMMERSIVE_REQUEST_SPECIFIC_FEED), "1");
    }

    public static final void l(@NotNull QCircleInitBean qCircleInitBean, @NotNull QQCircleFeedBase$StFeedListBusiReqData bizReqData) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        Intrinsics.checkNotNullParameter(bizReqData, "bizReqData");
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            return;
        }
        String str = schemeAttrs.get("key_scheme");
        String str2 = null;
        if (str != null) {
            bizReqData.entrySchema.set(str);
        } else {
            str = null;
        }
        String str3 = schemeAttrs.get("transdata");
        if (str3 != null) {
            bizReqData.schemaTrans.set(str3);
            str2 = str3;
        }
        QLog.i("QCircleInitBean", 1, "keySchema=" + str + " transData=" + str2);
    }

    public static final void m(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "<this>");
        qCircleInitBean.setLayerBizAssemblerType("biz_aio_chat_history_layer");
    }
}
