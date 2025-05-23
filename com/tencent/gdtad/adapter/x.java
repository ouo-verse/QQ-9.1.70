package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.ad.tangram.wechat.AdWXMINIProgramAdapter;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class x implements AdWXMINIProgramAdapter {
    @Override // com.tencent.ad.tangram.wechat.AdWXMINIProgramAdapter
    public AdError show(AdWXMINIProgram.Params params) {
        String str;
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Ad ad5;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[show] posID:");
        String str7 = null;
        if (params != null && (ad5 = params.f61351ad) != null) {
            str = ad5.getPosId();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(" openType:");
        if (params != null) {
            i3 = params.openType;
        } else {
            i3 = Integer.MIN_VALUE;
        }
        sb5.append(i3);
        sb5.append(" channelAppID:");
        if (params != null) {
            str2 = params.channelAppID;
        } else {
            str2 = null;
        }
        sb5.append(str2);
        sb5.append(" token:");
        if (params != null) {
            str3 = params.token;
        } else {
            str3 = null;
        }
        sb5.append(str3);
        sb5.append(" appID:");
        if (params != null) {
            str4 = params.appID;
        } else {
            str4 = null;
        }
        sb5.append(str4);
        sb5.append(" userName:");
        if (params != null) {
            str5 = params.userName;
        } else {
            str5 = null;
        }
        sb5.append(str5);
        sb5.append(" path:");
        if (params != null) {
            str6 = params.path;
        } else {
            str6 = null;
        }
        sb5.append(str6);
        sb5.append(" traceData:");
        if (params != null) {
            str7 = params.traceData;
        }
        sb5.append(str7);
        QLog.i("GdtWXMINIProgramAdapter", 1, sb5.toString());
        return ((IGdtAPI) QRoute.api(IGdtAPI.class)).handleWXMiniJump(params);
    }
}
