package com.tencent.mobileqq.matchfriend.request;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {
    public static void a(AppInterface appInterface, byte[] bArr, String str, int i3) {
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        aVar.Z0(str, bArr, new a(str, aVar, i3));
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f245580d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.relation.common.servlet.a f245581e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f245582f;

        a(String str, com.tencent.relation.common.servlet.a aVar, int i3) {
            this.f245580d = str;
            this.f245581e = aVar;
            this.f245582f = i3;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16 || obj == null) {
                QLog.e("MatchFriendSendRequestHelper", 1, this.f245580d + " isSuccess:" + z16 + ", data:" + obj);
            }
            this.f245581e.notifyUI(this.f245582f, z16, obj);
        }
    }
}
