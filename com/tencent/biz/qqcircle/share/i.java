package com.tencent.biz.qqcircle.share;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSFastShareUserInfo;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import uq3.k;
import uq3.o;
import uq3.q;
import yb0.l;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    private HostForwardUtils f92376u;

    /* renamed from: v, reason: collision with root package name */
    private final List<ResultRecord> f92377v;

    public i(QCircleBaseShareOperation.a aVar) {
        super(aVar);
        this.f92377v = new ArrayList();
    }

    private void L(Intent intent, String str) {
        String str2;
        if (this.f92376u == null) {
            this.f92376u = new HostForwardUtils();
        }
        if (t() != null && t().feed != null) {
            if (!TextUtils.isEmpty(t().mDirectShowMsg) && t().mMultiShareUsers.isEmpty()) {
                intent.putExtra("is_need_show_toast", false);
                this.f92376u.registerForwardResultReceiver(intent, QFSShareResultKt.d(t().feed.f398449id.get()));
                return;
            }
            if (!TextUtils.isEmpty(t().customShareSuccessToast)) {
                intent.putExtra("is_need_show_toast", false);
                intent.putExtra("qqcircle_custom_share_success_toast", t().customShareSuccessToast);
            }
            if (!t().isNeedShowShareSuccessToast) {
                intent.putExtra("is_need_show_toast", false);
            }
            QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo d16 = ua0.d.d(t());
            if (d16 != null) {
                if (q() != null) {
                    str2 = q().getDtPageId();
                } else {
                    str2 = "";
                }
                d16.mDtCustomPgId = str2;
            }
            this.f92376u.registerForwardResultReceiver(intent, QFSShareResultKt.f(m(), n(), d16));
            this.f92376u.addForwardType(intent, str);
            return;
        }
        QLog.d("QFSSharePart", 1, "[createHostForwardApi] share info should not be null.");
    }

    private void M(String str) {
        QCircleShareInfo t16 = t();
        if (t16 != null && !t16.mMultiShareUsers.isEmpty()) {
            ArrayList<ResultRecord> arrayList = new ArrayList(t16.mMultiShareUsers);
            if (!this.f92377v.isEmpty()) {
                arrayList.addAll(this.f92377v);
            }
            for (ResultRecord resultRecord : arrayList) {
                this.f92311i = resultRecord.uin;
                d("share", N(resultRecord.uinType));
            }
            return;
        }
        d("share", str);
    }

    private String N(int i3) {
        if (i3 == 1) {
            return QCircleDaTongConstant.ElementParamValue.QQ_AIO_GROUP;
        }
        if (i3 == 10014) {
            return QCircleDaTongConstant.ElementParamValue.QQ_AIO_SGRP;
        }
        if (i3 == QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE()) {
            return QCircleDaTongConstant.ElementParamValue.MUTUAL_FOLLOW_FRIEND;
        }
        return "qq_aio-qq";
    }

    private boolean O() {
        QCircleShareInfo t16 = t();
        if ((t16 != null && !t16.isEnableShareToMutual) || !S() || t16 == null || !t16.mMultiShareUsers.isEmpty()) {
            return true;
        }
        return false;
    }

    private Bundle P() {
        int i3;
        int i16;
        String str;
        if (t() == null) {
            return new Bundle();
        }
        if (!t().mMultiShareUsers.isEmpty()) {
            return Q();
        }
        boolean z16 = t().mNeedShowShareDialog;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        if (z16) {
            i16 = x();
        } else {
            i16 = t().mShareUinType;
        }
        if (z16) {
            str = v();
        } else {
            str = t().mShareUin;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_REQ(), i3);
        bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN_TYPE(), i16);
        bundle.putString(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN(), str);
        bundle.putString(QCircleHostConstants._ForwardRecentActivity.keyDirectShowMsg(), t().mDirectShowMsg);
        if (!z16) {
            bundle.putString(QCircleHostConstants.AppConstants.Key.UIN(), str);
            bundle.putInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), i16);
        }
        return bundle;
    }

    private Bundle Q() {
        if (t() == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_REQ(), 3);
        bundle.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, t().mMultiShareUsers);
        bundle.putString("direct_show_msg", t().mDirectShowMsg);
        if (t().isFromMultiSharePanel) {
            bundle.putBoolean("qqcircle_is_from_multi_share_panel", true);
        }
        return bundle;
    }

    private void R() {
        String str;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = t().extraTypeInfo;
        HostForwardUtils.ForwardInfoEntity forwardInfoEntity = new HostForwardUtils.ForwardInfoEntity();
        forwardInfoEntity.setForwardUin(v());
        forwardInfoEntity.setForwardUinType(x());
        ua0.d.a(m(), n()).n(qCircleExtraTypeInfo, forwardInfoEntity);
        QLog.d("QFSSharePart", 1, "[shareToSpecifiedFriend] handler success.");
        int i3 = this.f92312j;
        if (i3 == 1) {
            str = QCircleDaTongConstant.ElementParamValue.QQ_AIO_GROUP;
        } else if (i3 == 10014) {
            str = QCircleDaTongConstant.ElementParamValue.QQ_AIO_SGRP;
        } else {
            str = "qq_aio-qq";
        }
        if (o.Y1("qqcircle_enable_multi_share_report_loop", true)) {
            M(str);
        } else {
            d("share", str);
        }
    }

    private boolean S() {
        if (t() == null || t().mMultiShareUsers.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<ResultRecord> it = t().mMultiShareUsers.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            if (next.getUinType() == QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE()) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        this.f92377v.clear();
        this.f92377v.addAll(arrayList);
        t().mMultiShareUsers.clear();
        t().mMultiShareUsers.addAll(arrayList2);
        l.f449997a.e(t().feed.f398449id.get(), arrayList, t().mDirectShowMsg, t().mMultiShareUsers.isEmpty());
        QLog.d("QFSSharePart", 1, "shareToMutualUsers");
        return true;
    }

    private void T(Intent intent) {
        if (!O()) {
            QLog.d("QFSSharePart", 1, "[startShare] no need share after check mutual.");
            return;
        }
        intent.putExtras(P());
        U(intent);
        QLog.d("QFSSharePart", 1, "[startShare]");
    }

    private void U(@NonNull Intent intent) {
        L(intent, HostForwardUtils.HOST_FORWARD_DIALOG_RECENTLY_FLAG());
        HostForwardUtils hostForwardUtils = this.f92376u;
        if (hostForwardUtils == null) {
            QLog.w("QFSSharePart", 1, "[openHostEnvironment] host forward api should be not null.");
        } else {
            hostForwardUtils.startForwardActivityForResult(ASEngineUtils.getHostContext(f()), intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSSharePart", 1, "[realOperate] forbid because of sencebeat");
            return;
        }
        if (yb0.c.d(t())) {
            yb0.c.i(f());
            return;
        }
        if (t() != null && t().feed != null && t().feed.share != null && f() != null) {
            Intent s16 = QCircleBaseShareOperation.s(f(), t().feed);
            if (s16 == null) {
                QLog.d("QFSSharePart", 1, "[shareToSpecifiedFriend] intent == null, not handler.");
                return;
            }
            q.c(f(), "share_lately_type_key", "share_type_specified_friend");
            q.c(f(), "share_type_specified_friend", v());
            q.c(f(), "share_type_group", String.valueOf(x()));
            k.a().p("share_type_specified_friend_name", w());
            QFSFastShareUserInfo qFSFastShareUserInfo = new QFSFastShareUserInfo(w(), v(), x());
            String transferShareInfoToString = QFSFastShareUserInfo.transferShareInfoToString(qFSFastShareUserInfo);
            if (!TextUtils.isEmpty(transferShareInfoToString) && qFSFastShareUserInfo.getType() != QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE()) {
                k.a().p(QFSFastShareUserInfo.SP_KEY_FAST_SHARE_USER_INFO, transferShareInfoToString);
            }
            QLog.d("QFSSharePart", 1, "[shareToSpecifiedFriend] update sp uin = " + v() + ", type =" + x());
            T(s16);
            R();
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected Map<String, Object> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_target_qq", v());
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}
