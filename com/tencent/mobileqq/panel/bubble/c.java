package com.tencent.mobileqq.panel.bubble;

import QC.AioBubbleRecom$GetAioRecommendReq;
import QC.AioBubbleRecom$GetAioRecommendRsp;
import QC.AioBubbleRecom$ItemInfo;
import QC.AioBubbleRecom$LoginInfo;
import QC.AioBubbleRecom$SetRecommendItemReq;
import QC.AioBubbleRecom$SetRecommendItemRsp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.panel.FontBubble;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vip.n;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static c f257161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.panel.bubble.b f257162d;

        a(com.tencent.mobileqq.panel.bubble.b bVar) {
            this.f257162d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c.this.h(z16, obj, this.f257162d);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.panel.bubble.a f257164d;

        b(com.tencent.mobileqq.panel.bubble.a aVar) {
            this.f257164d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c.this.g(z16, obj, this.f257164d);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257161a = null;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    private AioBubbleRecom$ItemInfo c(FontBubble fontBubble, int i3) {
        int i16;
        int i17;
        AioBubbleRecom$ItemInfo aioBubbleRecom$ItemInfo = new AioBubbleRecom$ItemInfo();
        PBUInt32Field pBUInt32Field = aioBubbleRecom$ItemInfo.appID;
        if (i3 == 3) {
            i16 = 5;
        } else {
            i16 = 2;
        }
        pBUInt32Field.set(i16);
        PBUInt32Field pBUInt32Field2 = aioBubbleRecom$ItemInfo.itemID;
        if (i3 == 3) {
            i17 = fontBubble.fontId;
        } else {
            i17 = fontBubble.bubbleId;
        }
        pBUInt32Field2.set(i17);
        return aioBubbleRecom$ItemInfo;
    }

    public static c e() {
        if (f257161a == null) {
            synchronized (c.class) {
                if (f257161a == null) {
                    f257161a = new c();
                }
            }
        }
        return f257161a;
    }

    @NotNull
    private AioBubbleRecom$LoginInfo f() {
        AioBubbleRecom$LoginInfo aioBubbleRecom$LoginInfo = new AioBubbleRecom$LoginInfo();
        aioBubbleRecom$LoginInfo.clientVer.set(AppSetting.f99554n);
        aioBubbleRecom$LoginInfo.opplat.set(2);
        aioBubbleRecom$LoginInfo.keyType.set(8);
        return aioBubbleRecom$LoginInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, Object obj, com.tencent.mobileqq.panel.bubble.a aVar) {
        if (aVar == null) {
            return;
        }
        if (z16 && obj != null && (obj instanceof AioBubbleRecom$GetAioRecommendRsp)) {
            aVar.a((AioBubbleRecom$GetAioRecommendRsp) obj);
        } else {
            aVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z16, Object obj, com.tencent.mobileqq.panel.bubble.b bVar) {
        if (bVar == null) {
            QLog.e("AIOFontBubble_AIOBubbleManager", 1, "handleSetRecommend callback null");
        } else if (z16 && (obj instanceof AioBubbleRecom$SetRecommendItemRsp)) {
            bVar.a((AioBubbleRecom$SetRecommendItemRsp) obj);
        } else {
            bVar.a(null);
        }
    }

    public void d(int i3, com.tencent.mobileqq.panel.bubble.a aVar) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        QLog.i("AIOFontBubble_AIOBubbleManager", 1, "request getBubbleList panelType = " + i3);
        AioBubbleRecom$GetAioRecommendReq aioBubbleRecom$GetAioRecommendReq = new AioBubbleRecom$GetAioRecommendReq();
        PBUInt32Field pBUInt32Field = aioBubbleRecom$GetAioRecommendReq.appid;
        if (i3 == 3) {
            i16 = 5;
        } else {
            i16 = 2;
        }
        pBUInt32Field.set(i16);
        aioBubbleRecom$GetAioRecommendReq.loginInfo.set(f());
        n.request("trpc.qqva.aio_recommend.aio_recommend.getAioRecommend", aioBubbleRecom$GetAioRecommendReq, AioBubbleRecom$GetAioRecommendRsp.class, new b(aVar));
    }

    public void i(FontBubble fontBubble, boolean z16, com.tencent.mobileqq.panel.bubble.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fontBubble, Boolean.valueOf(z16), bVar);
            return;
        }
        if (fontBubble != null && bVar != null) {
            QLog.i("AIOFontBubble_AIOBubbleManager", 1, "request setNewBubble fontBubble = " + fontBubble.toString() + " isRestore = " + z16);
            AioBubbleRecom$SetRecommendItemReq aioBubbleRecom$SetRecommendItemReq = new AioBubbleRecom$SetRecommendItemReq();
            AioBubbleRecom$ItemInfo c16 = c(fontBubble, 3);
            AioBubbleRecom$ItemInfo c17 = c(fontBubble, 4);
            aioBubbleRecom$SetRecommendItemReq.loginInfo.set(f());
            ArrayList arrayList = new ArrayList();
            if (z16) {
                arrayList.add(c16);
                arrayList.add(c17);
            } else if (fontBubble.panelType == 3) {
                arrayList.add(c16);
            } else {
                arrayList.add(c17);
            }
            aioBubbleRecom$SetRecommendItemReq.item.set(arrayList);
            n.request("trpc.qqva.aio_recommend.aio_recommend.setRecommendItem", aioBubbleRecom$SetRecommendItemReq, AioBubbleRecom$SetRecommendItemRsp.class, new a(bVar));
        }
    }
}
