package com.tencent.qqnt.aio.menu.processor;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, a> f351462a;

    public d(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        HashMap<String, a> hashMap = new HashMap<>();
        this.f351462a = hashMap;
        hashMap.put("RevokeMenuItem", new k(bVar));
        this.f351462a.put("DelMenuItem", new f());
        this.f351462a.put("AddEssenceMenuItem", new c());
        this.f351462a.put("TroopTodoMenuItem", new p());
        this.f351462a.put("ReplyMenuItem", new MenuReplyProcessor());
        this.f351462a.put("RelatedEmotionMenuItem", new j());
        this.f351462a.put("MultiSelectMenuItem", new MenuMultiSelectProcessor());
        this.f351462a.put("SaveWeiYunMenuItem", new m());
        this.f351462a.put("UpcomingMenuItem", new e());
        this.f351462a.put("ScreenShotMenuItem", new n());
        this.f351462a.put("SendToPcMenuItem", new e());
        this.f351462a.put("AddOneMenuItem", new e());
        this.f351462a.put("ForwardGroupAlbumMenuItem", new h());
        this.f351462a.put("RobotReportMenuItem", new l());
        this.f351462a.put("JumpDressUpMenuItem", new g());
        this.f351462a.put("TranslateMenuItem", new o());
        this.f351462a.put("MakeSameMenuItem", new i());
    }

    @Override // com.tencent.qqnt.aio.menu.processor.a
    public void a(com.tencent.qqnt.aio.menu.ui.c cVar, com.tencent.qqnt.aio.menu.ui.d dVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cVar, dVar, bundle);
            return;
        }
        a aVar = this.f351462a.get(dVar.e());
        if (aVar != null) {
            aVar.a(cVar, dVar, bundle);
        } else {
            cVar.a(dVar);
        }
    }
}
