package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f292381a;

    /* renamed from: b, reason: collision with root package name */
    protected String f292382b;

    /* renamed from: c, reason: collision with root package name */
    protected int f292383c;

    /* renamed from: d, reason: collision with root package name */
    protected DataLineMsgRecord f292384d;

    /* renamed from: e, reason: collision with root package name */
    protected ConfigSettingForDataLine f292385e;

    public b(QQAppInterface qQAppInterface, DataLineMsgRecord dataLineMsgRecord, ConfigSettingForDataLine configSettingForDataLine) {
        this.f292381a = qQAppInterface;
        this.f292384d = dataLineMsgRecord;
        this.f292382b = dataLineMsgRecord.frienduin;
        this.f292383c = dataLineMsgRecord.istroop;
        this.f292385e = configSettingForDataLine;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        String d16 = TencentDocDataLineTipsConfigProcessor.a().d();
        if (TextUtils.isEmpty(d16)) {
            if (QLog.isColorLevel()) {
                QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null, or maybe has not recv");
            }
            return false;
        }
        String j3 = q.j(a());
        StringTokenizer stringTokenizer = new StringTokenizer(d16, "|");
        if (!stringTokenizer.hasMoreTokens()) {
            if (QLog.isColorLevel()) {
                QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null");
            }
            return false;
        }
        while (stringTokenizer.hasMoreTokens()) {
            if (j3.equalsIgnoreCase(stringTokenizer.nextToken())) {
                return true;
            }
        }
        return false;
    }
}
