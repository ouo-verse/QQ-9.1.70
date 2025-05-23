package com.tencent.mobileqq.troop.avatar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
class TroopAvatarManger$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f294484d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AppInterface f294485e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ i f294486f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Class f294487h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ArrayList f294488i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ HashMap f294489m;
    final /* synthetic */ e this$0;

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            bVar = this.this$0.f294548b;
            bVar.d(this.f294484d);
            bVar2 = this.this$0.f294548b;
            bVar2.e(this.f294485e);
            bVar3 = this.this$0.f294548b;
            List<String> c16 = bVar3.c(this.f294485e);
            i iVar = this.f294486f;
            Class<? extends Thread> cls = this.f294487h;
            ArrayList<TroopClipPic> arrayList = this.f294488i;
            HashMap<String, String> hashMap = this.f294489m;
            bVar4 = this.this$0.f294548b;
            iVar.d(cls, arrayList, hashMap, c16, bVar4);
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
