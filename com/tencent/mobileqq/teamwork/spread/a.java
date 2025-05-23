package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f292376a;

    /* renamed from: b, reason: collision with root package name */
    protected String f292377b;

    /* renamed from: c, reason: collision with root package name */
    protected int f292378c;

    /* renamed from: d, reason: collision with root package name */
    protected ChatMessage f292379d;

    /* renamed from: e, reason: collision with root package name */
    protected ConfigSetting f292380e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.spread.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8642a {
        void a(List<String> list);
    }

    public a(QQAppInterface qQAppInterface, ChatMessage chatMessage, ConfigSetting configSetting) {
        this.f292376a = qQAppInterface;
        this.f292379d = chatMessage;
        this.f292377b = chatMessage.frienduin;
        this.f292378c = chatMessage.istroop;
        this.f292380e = configSetting;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(InterfaceC8642a interfaceC8642a);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() {
        String h16 = TencentDocTipsConfigProcessor.a().h();
        if (TextUtils.isEmpty(h16)) {
            if (QLog.isColorLevel()) {
                QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null, or maybe has not recv");
            }
            return false;
        }
        String j3 = q.j(a());
        StringTokenizer stringTokenizer = new StringTokenizer(h16, "|");
        if (!stringTokenizer.hasMoreTokens()) {
            if (QLog.isColorLevel()) {
                QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null");
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
