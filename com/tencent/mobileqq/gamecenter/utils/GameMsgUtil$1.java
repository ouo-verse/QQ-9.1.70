package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
class GameMsgUtil$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppInterface f213411d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f213412e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Message f213413f;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        if (r12.f213412e == 0) goto L18;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        try {
            i3 = f.f213435b;
            if (-1 == i3) {
                f.f213435b = f.q(this.f213411d);
            }
            i16 = f.f213435b;
            if (-1 != i16) {
                i17 = f.f213435b;
                if (i17 != 0 || this.f213412e <= 0) {
                    i18 = f.f213435b;
                    if (i18 > 0) {
                    }
                    f.f213435b = this.f213412e;
                    return;
                }
                String str = f.f213434a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[reportGameMsgBoxExplosure883], lastUnread:");
                i19 = f.f213435b;
                sb5.append(i19);
                sb5.append(",curCount:");
                sb5.append(this.f213412e);
                QLog.i(str, 1, sb5.toString());
                String str2 = "0";
                if (this.f213412e == 0) {
                    str2 = "1";
                }
                String str3 = str2;
                TinyInfo tinyInfo = new TinyInfo();
                tinyInfo.parseFromMessageRecord(this.f213413f);
                f.c0(tinyInfo.gameAppId + "", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92003", "209055", "", "", "8", str3);
                f.l0(this.f213411d, this.f213412e);
                f.f213435b = this.f213412e;
                return;
            }
            f.l0(this.f213411d, this.f213412e);
        } catch (Throwable th5) {
            QLog.i(f.f213434a, 1, th5.getMessage());
        }
    }
}
