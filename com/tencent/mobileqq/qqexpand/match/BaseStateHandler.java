package com.tencent.mobileqq.qqexpand.match;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BaseStateHandler {

    /* renamed from: d, reason: collision with root package name */
    b f263914d;

    /* renamed from: e, reason: collision with root package name */
    vg2.d f263915e;

    /* renamed from: f, reason: collision with root package name */
    private int f263916f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseStateHandler(b bVar, int i3) {
        vg2.d dVar = new vg2.d();
        this.f263915e = dVar;
        this.f263916f = -1;
        this.f263914d = bVar;
        dVar.a();
        this.f263916f = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.f263916f + " cancelMatch in wrong state!!");
    }

    public void b() {
        this.f263915e.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z16) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z16, vg2.d dVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z16, int i3, vg2.d dVar, String str) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i3) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId UIN IS EMPTY");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId algorithmId IS EMPTY");
            str2 = "0";
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.match.BaseStateHandler.1
            @Override // java.lang.Runnable
            public void run() {
                ExpandChatUtil.I((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str, String str2, byte[] bArr) {
        this.f263914d.f263925f.getMsgCache().v(String.valueOf(str), String.valueOf(str2), bArr);
    }

    public void i(vg2.d dVar) {
        vg2.d dVar2 = this.f263915e;
        dVar2.f441605a = dVar.f441605a;
        dVar2.f441606b = dVar.f441606b;
        dVar2.f441607c = dVar.f441607c;
        dVar2.f441608d = dVar.f441608d;
        dVar2.f441609e = dVar.f441609e;
        dVar2.f441610f = dVar.f441610f;
        dVar2.f441612h = dVar.f441612h;
        dVar2.f441613i = dVar.f441613i;
        dVar2.f441614j = dVar.f441614j;
        dVar2.f441615k = dVar.f441615k;
    }

    public void j(vg2.d dVar) {
        this.f263915e.a();
        if (dVar != null) {
            i(dVar);
        }
    }
}
