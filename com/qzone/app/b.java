package com.qzone.app;

import com.qzone.common.account.LoginData;
import cooperation.qzone.QUA;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b implements com.qzone.common.config.service.a {
    @Override // com.qzone.common.config.service.a
    public long a() {
        return LoginData.getInstance().getUin();
    }

    @Override // com.qzone.common.config.service.a
    public AppRuntime b() {
        return LoginData.getInstance().getQZoneRuntime();
    }

    @Override // com.qzone.common.config.service.a
    public String c() {
        return "Android-QZoneInQQ";
    }

    @Override // com.qzone.common.config.service.a
    public String getQUA() {
        return QUA.getQUA3();
    }

    @Override // com.qzone.common.config.service.a
    public String getRefer() {
        return "mqq";
    }

    @Override // com.qzone.common.config.service.a
    public String getSource() {
        return "Qzone";
    }

    @Override // com.qzone.common.config.service.a
    public String getVersion() {
        return QUA.getVersionForPic();
    }
}
