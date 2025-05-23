package com.tencent.mobileqq.vas.lovechat;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends QQVasUpdateBusiness {
    public String e(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getSavePath(i3));
        String str = File.separator;
        sb5.append(str);
        sb5.append("bg01.png");
        String sb6 = sb5.toString();
        if (new File(sb6).exists()) {
            return sb6;
        }
        QLog.e("love-chat", 1, "love-chat longBgPath file not exists item " + i3);
        return getSavePath(i3) + str + "bg.png";
    }

    public String f(int i3) {
        return getSavePath(i3) + File.separator + "pendant.png";
    }

    public String g(int i3, long j3) {
        if (j3 < 10) {
            return getSavePath(i3) + File.separator + "unread1.png";
        }
        if (j3 < 100) {
            return getSavePath(i3) + File.separator + "unread2.png";
        }
        return getSavePath(i3) + File.separator + "unread3.png";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 327L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "love_chat";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "LoveChatBusiness";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String[] getNecessaryFiles() {
        return new String[]{"bg.png", "pendant.png", "unread1.png", "unread2.png", "unread3.png"};
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "chatFrame." + i3 + ".android.zip";
    }

    public boolean h(String str) {
        return str.endsWith("bg01.png");
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
