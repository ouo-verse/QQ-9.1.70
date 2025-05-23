package com.tencent.biz.qqcircle.share;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    private HostForwardUtils f92364u;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Consumer<String> {
        a() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) {
            AIOPictureData aIOPictureData = new AIOPictureData();
            aIOPictureData.filePath = str;
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToChannel(new File(str), true, aIOPictureData, new Bundle(), e.this.f(), e.this.f92314l, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "QFSSharePart");
        }
    }

    public e(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(Intent intent, String str) {
        if (this.f92364u == null) {
            this.f92364u = new HostForwardUtils();
        }
        if (t() == null) {
            QLog.d("QFSSharePart", 1, "[createHostForwardApi] share info should not be null.");
            return;
        }
        this.f92364u.registerForwardResultReceiver(intent, QFSShareResultKt.f(m(), n(), ua0.d.d(t())));
        this.f92364u.addForwardType(intent, str);
    }

    private void M() {
        N();
    }

    private void N() {
        H(127, 2, t().extraTypeInfo, "");
        d("share", QCircleDaTongConstant.ElementParamValue.SGRP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (yb0.c.d(t())) {
            yb0.c.i(f());
            return;
        }
        if (t() != null && t().feed != null && t().feed.share != null && f() != null) {
            if (t().isShowPersonalQrcodeDown && h() != null) {
                h().g(new a());
            } else {
                Intent s16 = QCircleBaseShareOperation.s(f(), t().feed);
                if (s16 == null) {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.tx7), 0);
                    return;
                }
                I(true);
                L(s16, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
                s16.putExtra("is_multi_selection", false);
                s16.putExtra("only_single_selection", true);
                s16.putExtra("call_by_forward", true);
                if (!TextUtils.isEmpty(t().mDirectShowMsg)) {
                    s16.putExtra(AppConstants.Key.FORWARD_ARK_APP_ADDTIONAL_MESSAGE, t().mDirectShowMsg);
                }
                if (!t().isNeedShowShareSuccessToast) {
                    s16.putExtra("is_need_show_toast", false);
                }
                QCircleHostLauncher.launchForwardGuildListFragment(f(), s16);
            }
            QLog.d("QFSSharePart", 1, "shareToQQ  success");
            M();
            yb0.g.f449962a.g(true, j());
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}
