package com.tencent.biz.qqcircle.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.events.QFSInteractActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSSendMsgResultEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSShareSuccessEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cc;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean;
import cooperation.qzone.QzoneIPCModule;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;
import uq3.o;
import uq3.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u001a&\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u001a\u001e\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u001a\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u001a\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a \u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0013H\u0002\u001a\u0012\u0010 \u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0012\u0010!\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0012\u0010\"\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u001a\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a8\u0006("}, d2 = {"", "pageId", "parentParentId", "Lcooperation/qqcircle/beans/QCircleForwardInfoReportBean$QCircleForwardExtraTypeInfo;", "extra", "Landroid/os/ResultReceiver;", "f", "", "feedId", "d", "parentPageId", "e", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "Lcooperation/qqcircle/beans/QCircleForwardInfoReportBean;", "bean", "", tl.h.F, "", "k", "", "", "p", "i", "j", "Lcom/tencent/biz/qcircleshadow/lib/variation/HostForwardUtils$ForwardInfoEntity;", "o", "flag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNeedFilter", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "reportBean", "c", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "g", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSShareResultKt {
    private static final void c(QCircleForwardInfoReportBean qCircleForwardInfoReportBean, Bundle bundle) {
        boolean z16 = true;
        if (!o.Y1("qqcircle_enable_multi_share_report_loop", true)) {
            return;
        }
        List<ResultRecord> g16 = g(bundle);
        if (g16.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ResultRecord resultRecord : g16) {
            HostForwardUtils.ForwardInfoEntity forwardInfoEntity = new HostForwardUtils.ForwardInfoEntity();
            forwardInfoEntity.setForwardUin(resultRecord.uin);
            forwardInfoEntity.setForwardUinType(resultRecord.uinType);
            forwardInfoEntity.setForwardName(resultRecord.name);
            arrayList.add(forwardInfoEntity);
        }
        qCircleForwardInfoReportBean.setMultiShareEntityList(arrayList);
        QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo reportExtra = qCircleForwardInfoReportBean.getReportExtra();
        if (reportExtra != null) {
            if (arrayList.size() <= 1) {
                z16 = false;
            }
            reportExtra.isMultiSelect = z16;
        }
    }

    @NotNull
    public static final ResultReceiver d(@NotNull final String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        final Handler handler = new Handler(Looper.getMainLooper());
        return new ResultReceiver(handler) { // from class: com.tencent.biz.qqcircle.share.QFSShareResultKt$createSendMsgResult$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                String str;
                boolean z16 = true;
                QLog.d("RHF-QFSShareResult", 1, "[sendMsgResult] retCode: " + resultCode);
                int i3 = QCircleToast.f91646f;
                if (resultCode == -1) {
                    str = "\u6d88\u606f\u53d1\u9001\u6210\u529f";
                } else {
                    str = "\u6d88\u606f\u53d1\u9001\u5931\u8d25";
                }
                QCircleToast.j(i3, str, 0);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                if (resultCode != -1) {
                    z16 = false;
                }
                simpleEventBus.dispatchEvent(new QFSSendMsgResultEvent(z16, feedId));
            }
        };
    }

    @NotNull
    public static final ResultReceiver e(final int i3, final int i16, @Nullable final QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo qCircleForwardExtraTypeInfo) {
        final Handler handler = new Handler(Looper.getMainLooper());
        return new ResultReceiver(handler) { // from class: com.tencent.biz.qqcircle.share.QFSShareResultKt$createShareQZoneResult$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                HostForwardUtils.ForwardInfoEntity o16;
                if (resultCode == -1) {
                    o16 = QFSShareResultKt.o(resultData);
                    ua0.d.a(i3, i16).A(qCircleForwardExtraTypeInfo, o16);
                }
            }
        };
    }

    @NotNull
    public static final ResultReceiver f(final int i3, final int i16, @Nullable final QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo qCircleForwardExtraTypeInfo) {
        final Handler handler = new Handler(Looper.getMainLooper());
        return new ResultReceiver(handler) { // from class: com.tencent.biz.qqcircle.share.QFSShareResultKt$createShareResult$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                HostForwardUtils.ForwardInfoEntity o16;
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                o16 = QFSShareResultKt.o(resultData);
                QCircleForwardInfoReportBean qCircleForwardInfoReportBean = new QCircleForwardInfoReportBean();
                qCircleForwardInfoReportBean.setForwardEntity(o16);
                qCircleForwardInfoReportBean.setPageId(i3);
                qCircleForwardInfoReportBean.setParentPageId(i16);
                qCircleForwardInfoReportBean.setReportExtra(qCircleForwardExtraTypeInfo);
                QFSShareResultKt.h(resultCode, resultData, qCircleForwardInfoReportBean);
            }
        };
    }

    private static final List<ResultRecord> g(Bundle bundle) {
        ArrayList arrayList;
        boolean z16;
        List<ResultRecord> emptyList;
        ArrayList arrayList2 = null;
        if (bundle != null) {
            arrayList = bundle.getParcelableArrayList("selected_target_list");
        } else {
            arrayList = null;
        }
        if (bundle != null) {
            arrayList2 = bundle.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        }
        boolean z17 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return arrayList;
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            z17 = true;
        }
        if (z17) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, Bundle bundle, QCircleForwardInfoReportBean qCircleForwardInfoReportBean) {
        int i16;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        String str2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        PBStringField pBStringField2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3;
        PBStringField pBStringField3;
        String q16 = q(bundle);
        boolean l3 = l(bundle);
        boolean i17 = i(bundle);
        if (bundle != null) {
            i16 = bundle.size();
        } else {
            i16 = 0;
        }
        QLog.d("RHF-QFSShareResult", 1, "[handleReceiveResult] ", "size: " + i16 + " | recentlyFlag: " + q16 + " | resultCode: " + i3 + " | isRecentlyClickFlag: " + l3 + " | pageId: " + qCircleForwardInfoReportBean.getPageId() + " | parentPageId: " + qCircleForwardInfoReportBean.getParentPageId() + " | isMultiSelect: " + i17);
        QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo reportExtra = qCircleForwardInfoReportBean.getReportExtra();
        if (reportExtra != null) {
            reportExtra.isMultiSelect = i17;
        }
        if (i3 == 0 && l3) {
            m(q16, qCircleForwardInfoReportBean);
            return;
        }
        if (i3 == -1) {
            c(qCircleForwardInfoReportBean, bundle);
            n(q16, qCircleForwardInfoReportBean, j(bundle));
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo reportExtra2 = qCircleForwardInfoReportBean.getReportExtra();
            String str3 = null;
            if (reportExtra2 != null && (feedCloudMeta$StFeed3 = reportExtra2.feed) != null && (pBStringField3 = feedCloudMeta$StFeed3.f398449id) != null) {
                str = pBStringField3.get();
            } else {
                str = null;
            }
            simpleEventBus.dispatchEvent(new QFSInteractActionEvent(str, 3));
            if (k(bundle)) {
                SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
                QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo reportExtra3 = qCircleForwardInfoReportBean.getReportExtra();
                if (reportExtra3 != null && (feedCloudMeta$StFeed2 = reportExtra3.feed) != null && (pBStringField2 = feedCloudMeta$StFeed2.f398449id) != null) {
                    str2 = pBStringField2.get();
                } else {
                    str2 = null;
                }
                simpleEventBus2.dispatchEvent(new QFSShareSuccessEvent(str2, qCircleForwardInfoReportBean.getPageId(), p(bundle)));
            } else {
                QLog.e("RHF-QFSShareResult", 1, "[handleReceiveResult] not qcircle forward");
            }
            r(bundle);
            yb0.g gVar = yb0.g.f449962a;
            QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo reportExtra4 = qCircleForwardInfoReportBean.getReportExtra();
            if (reportExtra4 != null && (feedCloudMeta$StFeed = reportExtra4.feed) != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str3 = pBStringField.get();
            }
            if (str3 == null) {
                str3 = "";
            }
            gVar.g(true, str3);
        }
    }

    public static final boolean i(@Nullable Bundle bundle) {
        if (bundle != null) {
            return bundle.getBoolean("is_multi_selection");
        }
        return false;
    }

    private static final boolean j(Bundle bundle) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_filter_share_success_report_910", true) || bundle == null) {
            return false;
        }
        return bundle.getBoolean("qqcircle_is_from_multi_share_panel", false);
    }

    public static final boolean k(@Nullable Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(HostForwardUtils.KEY_QCIRCLE_FORWARD(), false);
    }

    private static final boolean l(Bundle bundle) {
        if (bundle != null && bundle.getBoolean("key_qcircle_click")) {
            return true;
        }
        return false;
    }

    private static final void m(String str, QCircleForwardInfoReportBean qCircleForwardInfoReportBean) {
        ua0.d.z(str, qCircleForwardInfoReportBean);
    }

    private static final void n(String str, QCircleForwardInfoReportBean qCircleForwardInfoReportBean, boolean z16) {
        List split$default;
        if (z16) {
            QLog.d("RHF-QFSShareResult", 1, "[notifyResultCallback] need filter, return.");
            return;
        }
        ua0.d.w(str, qCircleForwardInfoReportBean);
        if (!TextUtils.isEmpty(qCircleForwardInfoReportBean.getForwardEntity().getForwardUin())) {
            String forwardUin = qCircleForwardInfoReportBean.getForwardEntity().getForwardUin();
            Intrinsics.checkNotNullExpressionValue(forwardUin, "bean.forwardEntity.forwardUin");
            split$default = StringsKt__StringsKt.split$default((CharSequence) forwardUin, new String[]{","}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                cc.e((String) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HostForwardUtils.ForwardInfoEntity o(Bundle bundle) {
        Object first;
        HostForwardUtils.ForwardInfoEntity forwardInfoEntity = new HostForwardUtils.ForwardInfoEntity();
        if (bundle == null) {
            return forwardInfoEntity;
        }
        try {
            String string = bundle.getString("uin");
            int i3 = bundle.getInt("uintype");
            String string2 = bundle.getString("uinname");
            List<ResultRecord> g16 = g(bundle);
            if (!g16.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) g16);
                ResultRecord resultRecord = (ResultRecord) first;
                string = resultRecord.uin;
                i3 = resultRecord.uinType;
                if (!TextUtils.isEmpty(resultRecord.name)) {
                    string2 = resultRecord.name;
                }
            }
            forwardInfoEntity.setForwardUin(string);
            forwardInfoEntity.setForwardUinType(i3);
            forwardInfoEntity.setForwardName(string2);
            q.c(RFWApplication.getApplication(), "share_type_specified_friend", string);
            q.c(RFWApplication.getApplication(), "share_type_group", String.valueOf(i3));
            k.a().p("share_type_specified_friend_name", string2);
            QLog.d("RHF-QFSShareResult", 1, "[parseForwardInfoEntity] result data: ", forwardInfoEntity.toString());
        } catch (Throwable th5) {
            QLog.e("RHF-QFSShareResult", 1, "[parseForwardInfoEntity] error: ", th5);
        }
        return forwardInfoEntity;
    }

    @Nullable
    public static final Map<String, Long> p(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            Serializable serializable = bundle.getSerializable(AppConstants.Key.FORWARD_ARK_MSG_ID_MAP);
            if (!(serializable instanceof Map)) {
                return null;
            }
            return (Map) serializable;
        } catch (Exception unused) {
            return null;
        }
    }

    private static final String q(Bundle bundle) {
        if (bundle == null) {
            String HOST_FORWARD_RECENTLY_CHAT_FLAG = HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG();
            Intrinsics.checkNotNullExpressionValue(HOST_FORWARD_RECENTLY_CHAT_FLAG, "{\n        HostForwardUti\u2026ECENTLY_CHAT_FLAG()\n    }");
            return HOST_FORWARD_RECENTLY_CHAT_FLAG;
        }
        String string = bundle.getString(HostForwardUtils.HOST_FORWARD_TYPE_KEY(), HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
        Intrinsics.checkNotNullExpressionValue(string, "resultData.getString(\n  \u2026ECENTLY_CHAT_FLAG()\n    )");
        return string;
    }

    private static final void r(Bundle bundle) {
        String str;
        if (bundle == null || (str = bundle.getString("qqcircle_custom_share_success_toast")) == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(str, "")) {
            QCircleToast.l(QCircleToast.f91646f, str, 1, true, false);
        }
    }
}
