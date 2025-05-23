package com.qzone.business.plusunion.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import com.qzone.business.plusunion.business.model.AppInfo;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.QZoneEmptyView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAppIntroActivity extends BaseFragment {
    public static String H = "appinfokey";
    private AppInfo C;
    private int D;
    private QZoneEmptyView E;
    private ViewGroup F;
    private QQCustomDialog G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.qzone.business.plusunion.business.a.h().b(QZoneAppIntroActivity.this.C)) {
                QZoneAppIntroActivity.this.vh();
            } else {
                com.qzone.business.plusunion.business.a.h().u(QZoneAppIntroActivity.this.getActivity(), QZoneAppIntroActivity.this.C);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                com.qzone.business.plusunion.business.a.h().w(QZoneAppIntroActivity.this.getActivity(), QZoneAppIntroActivity.this.C.downloadUrl);
                ClickReport.s(String.valueOf(QZoneAppIntroActivity.this.C.appid), QZoneAppIntroActivity.this.C.appname, "qzone3rdapp", 302, 9, 0);
            } catch (Exception unused) {
                QZoneAppIntroActivity.this.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastUrlDownloadFail", "\u94fe\u63a5\u4e0b\u8f7d\u5931\u8d25"), 4);
            }
        }
    }

    private void init() {
        com.qzone.business.plusunion.business.a.h().y();
        this.F = (ViewGroup) findViewById(R.id.b9n);
        this.E = (QZoneEmptyView) findViewById(R.id.f165089bw3);
        try {
            this.D = Integer.valueOf(getIntent().getStringExtra(H)).intValue();
        } catch (Exception unused) {
        }
        setTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleApplicationIntro", "\u5e94\u7528\u4ecb\u7ecd"));
    }

    private void loadData() {
        AppInfo e16 = com.qzone.business.plusunion.business.a.h().e(this.D);
        this.C = e16;
        if (e16 != null) {
            uh();
        } else if (!checkNetworkConnect()) {
            toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"));
            wh(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "EmptyViewContentLoadFail", "\u5185\u5bb9\u52a0\u8f7d\u5931\u8d25"));
        } else {
            wh(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "EmptyViewContentLoading", "\u5185\u5bb9\u52a0\u8f7d\u4e2d"));
            com.qzone.business.plusunion.business.a.h().g(getHandler());
        }
    }

    private void uh() {
        this.F.setVisibility(0);
        this.E.setVisibility(8);
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.f163999gj);
        asyncImageView.setForeground(R.drawable.ays);
        TextView textView = (TextView) findViewById(R.id.f164000gk);
        TextView textView2 = (TextView) findViewById(R.id.f163998gi);
        Button button = (Button) findViewById(R.id.f163997gh);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "StartApplication", "\u542f\u52a8\u5e94\u7528");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DownloadApplication", "\u76f4\u63a5\u4e0b\u8f7d\u5b89\u88c5");
        if (!com.qzone.business.plusunion.business.a.h().b(this.C)) {
            config = config2;
        }
        button.setText(config);
        button.setOnClickListener(new a());
        AppInfo appInfo = this.C;
        if (appInfo != null) {
            if (URLUtil.isNetworkUrl(appInfo.iconUrl)) {
                asyncImageView.setAsyncImage(this.C.iconUrl);
            }
            textView.setText(this.C.appname);
            textView2.setText(this.C.summary);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogApplicationDownload", "\u662f\u5426\u4e0b\u8f7d\u8be5\u5e94\u7528\uff1f");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogDownload", "\u4e0b\u8f7d");
        if (this.G == null) {
            this.G = DialogUtil.createCustomDialog(getActivity(), 230).setTitle((String) null).setPositiveButton(config2, new c()).setNegativeButton("\u53d6\u6d88", new b());
        }
        this.G.setMessage(config);
        this.G.show();
    }

    private void wh(String str) {
        this.F.setVisibility(8);
        this.E.setVisibility(0);
        this.E.setMessage(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        onServiceResult(QZoneResult.unpack(message));
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected void onServiceResult(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            wh(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "EmptyViewContentLoadFail", "\u5185\u5bb9\u52a0\u8f7d\u5931\u8d25"));
            return;
        }
        if (qZoneResult.what != 3841) {
            return;
        }
        if (qZoneResult.getSucceed()) {
            AppInfo e16 = com.qzone.business.plusunion.business.a.h().e(this.D);
            this.C = e16;
            if (e16 != null) {
                uh();
                return;
            } else {
                wh(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "EmptyViewApplicationRisk", "\u8be5\u5e94\u7528\u6709\u98ce\u9669\uff0c\u8fd4\u56de\u6d4f\u89c8\u5176\u4ed6\u5185\u5bb9\u5427"));
                return;
            }
        }
        wh(qZoneResult.getMessage());
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        init();
        loadData();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.bgs, viewGroup, false);
    }
}
