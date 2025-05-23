package com.qzone.reborn.feedx.viewmodel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneBlogDetailViewModel extends h {

    /* renamed from: m0, reason: collision with root package name */
    private BusinessFeedData f55871m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f55872n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f55873o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f55874p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f55875q0;

    private void F2(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("u");
            String queryParameter2 = Uri.parse(str).getQueryParameter("a");
            this.L = Uri.parse(str).getQueryParameter("i");
            this.J = Long.parseLong(queryParameter);
            this.K = Integer.parseInt(queryParameter2);
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneBlogDetailViewModel", 1, th5);
        }
    }

    private void Q2(BusinessFeedData businessFeedData) {
        if (TextUtils.isEmpty(businessFeedData.getFeedCommInfo().actionurl)) {
            return;
        }
        if (businessFeedData.isForwardFeed()) {
            this.f55873o0 = businessFeedData.getFeedCommInfo().actionurl + "&_proxyByURL=1";
            return;
        }
        this.f55873o0 = businessFeedData.getFeedCommInfo().actionurl;
    }

    private void R2() {
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        try {
            String[] split = this.L.split("_");
            if (split.length >= 3) {
                this.L = split[2];
            }
            this.f55873o0 = V2();
            this.f55873o0 += "&from=fav";
        } catch (Exception e16) {
            QZLog.e("get favor blog action url error", e16.toString());
        }
    }

    private String V2() {
        return QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_BLOG_DETAIL, "https://h5.qzone.qq.com/ugc/share?_wv=1&appid=2&res_uin={uin}&cellid={cellid}").replace("{uin}", this.J + "").replace("{cellid}", this.L + "");
    }

    private void Y2(Intent intent) {
        String stringExtra = intent.getStringExtra("cell_operation.qq_url");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        final String queryParameter = Uri.parse(stringExtra).getQueryParameter("u");
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread, false).post(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.QZoneBlogDetailViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneBlogDetailViewModel.this.f55875q0 = s8.f.f().g(queryParameter);
                if (TextUtils.isEmpty(QZoneBlogDetailViewModel.this.f55875q0) || QZoneBlogDetailViewModel.this.f55875q0.length() <= 6) {
                    return;
                }
                QZoneBlogDetailViewModel.this.f55875q0 = QZoneBlogDetailViewModel.this.f55875q0.substring(0, 5) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
        });
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h
    public void G2(Intent intent) {
        super.G2(intent);
        Bundle extras = intent.getExtras();
        this.K = extras.getInt("appid");
        this.f55872n0 = extras.getInt("mqqflag") == 1;
        this.f55873o0 = intent.getStringExtra("blog_url");
        boolean z16 = extras.getBoolean("qzone.sourceFrom", false);
        if (this.f55872n0) {
            a2(extras);
        } else if (z16) {
            U2(extras);
        } else {
            this.f55871m0 = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(extras, BusinessFeedData.STORE_KEY);
        }
        Y2(intent);
    }

    public String S2() {
        return this.f55875q0;
    }

    public String T2() {
        return this.f55873o0;
    }

    public BusinessFeedData W2() {
        return this.f55871m0;
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h
    protected void t2() {
        MutableLiveData<UIStateData<BusinessFeedData>> mutableLiveData = this.f55901m;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.f55901m.getValue().getData() == null) {
            return;
        }
        BusinessFeedData data = this.f55901m.getValue().getData();
        if (data != null && data.getFeedCommInfo() != null && (data.getFeedCommInfo().actiontype == 51 || data.getFeedCommInfo().actiontype == 50)) {
            Q2(data);
        } else if (this.f55874p0) {
            R2();
        } else {
            this.f55873o0 = V2();
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h
    public boolean u2() {
        return this.f55874p0;
    }

    private void U2(Bundle bundle) {
        this.K = 7035;
        this.L = bundle.getString("qzone.cellid");
        this.J = bundle.getLong("qzone.favorOwner");
        this.f55874p0 = bundle.getBoolean("qzone.isFavorBlog", false);
    }

    private void a2(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("cell_operation.qq_url");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        F2(string);
    }
}
