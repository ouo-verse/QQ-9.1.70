package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseHbFragment extends QBaseFragment {
    protected Bundle C;
    protected SendHbActivity D;
    protected BaseQQAppInterface E;
    protected bl2.g F;
    protected int G;
    protected boolean H;
    protected boolean I;
    protected boolean J = false;

    private void rh() {
        if (this.H && this.I) {
            this.H = false;
            try {
                sh();
            } catch (Throwable th5) {
                QLog.e("Q.qwallet.BaseHbFragment", 1, th5, new Object[0]);
            }
        }
    }

    private void uh() {
        Bundle arguments = getArguments();
        this.C = arguments;
        String string = arguments.getString(WadlProxyConsts.CHANNEL, String.valueOf(1));
        try {
            this.G = Integer.valueOf(string).intValue();
        } catch (NumberFormatException unused) {
        }
        QLog.i("Q.qwallet.BaseHbFragment", 2, "base params channel = " + string + ProgressTracer.SEPARATOR + this.G);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.i("Q.qwallet.BaseHbFragment", 1, "onCreateView: " + getClass().getSimpleName());
        SendHbActivity sendHbActivity = (SendHbActivity) getQBaseActivity();
        this.D = sendHbActivity;
        this.F = new bl2.g(sendHbActivity);
        this.E = (BaseQQAppInterface) this.D.getAppRuntime();
        this.D.getWindow().setSoftInputMode(19);
        uh();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("Q.qwallet.BaseHbFragment", 1, "onDestroy: " + getClass().getSimpleName());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(requireActivity(), true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.H = true;
        this.J = true;
        rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ph(String str, String str2) {
        SendHbActivity sendHbActivity;
        if (!TextUtils.isEmpty(str) && (sendHbActivity = this.D) != null && !sendHbActivity.isFinishing()) {
            this.D.addHbUploadData(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qh(HbInfo.a aVar, int i3, int i16, String str, String str2) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("number#");
            stringBuffer.append(i16);
            stringBuffer.append(",type#");
            if (!com.tencent.mobileqq.qwallet.hb.aio.impl.d.e(aVar.recv_type) && !"7".equals(aVar.recv_type) && !"4".equals(aVar.recv_type) && !"5".equals(aVar.recv_type)) {
                if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.f(aVar.recv_type)) {
                    stringBuffer.append("crowd");
                } else {
                    stringBuffer.append(VipFunCallConstants.KEY_GROUP);
                }
                stringBuffer.append(",channel#");
                stringBuffer.append(i3);
                stringBuffer.append(",money#");
                stringBuffer.append(str);
                ph(str2, stringBuffer.toString());
            }
            stringBuffer.append("person");
            stringBuffer.append(",channel#");
            stringBuffer.append(i3);
            stringBuffer.append(",money#");
            stringBuffer.append(str);
            ph(str2, stringBuffer.toString());
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        String string;
        super.setUserVisibleHint(z16);
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.BaseHbFragment", 2, "setUserVisibleHint: " + z16 + " " + getClass().getSimpleName());
        }
        this.I = z16;
        rh();
        if (z16) {
            Bundle arguments = getArguments();
            String string2 = arguments.getString("panel_name");
            String string3 = arguments.getString("recv_type");
            if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(string3)) {
                string = arguments.getString("guild_id");
            } else {
                string = arguments.getString("recv_uin");
            }
            ReportUtils.g("redpack.send.show", string3, string2, "", string);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sh() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.BaseHbFragment", 2, "onLazyLoad: " + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void th(String str) {
        QLog.i("Q.qwallet.BaseHbFragment", 2, "openUrl = " + str);
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        RouteUtils.startActivityForResult(getQBaseActivity(), intent, RouterConstants.UI_ROUTE_BROWSER, 16);
    }
}
