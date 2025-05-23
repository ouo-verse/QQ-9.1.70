package com.tencent.mobileqq.panel;

import QC.AioBubbleRecom$GetAioRecommendRsp;
import QC.AioBubbleRecom$ItemInfo;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.panel.FontBubblePanelView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements com.tencent.mobileqq.panel.bubble.a, FontBubblePanelView.c<AioBubbleRecom$GetAioRecommendRsp> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ISVIPHandler f257166a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.panel.bubble.a
    public void a(AioBubbleRecom$GetAioRecommendRsp aioBubbleRecom$GetAioRecommendRsp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aioBubbleRecom$GetAioRecommendRsp);
            return;
        }
        ISVIPHandler iSVIPHandler = this.f257166a;
        if (iSVIPHandler != null) {
            if (aioBubbleRecom$GetAioRecommendRsp != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            iSVIPHandler.notifyUI(107, z16, aioBubbleRecom$GetAioRecommendRsp);
        }
    }

    @Override // com.tencent.mobileqq.panel.FontBubblePanelView.c
    public String b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        return IndividuationUrlHelper.getMarketUrl(context, "font", IndividuationUrlHelper.AdTag.DETAIL_FONT_ADTAG);
    }

    @Override // com.tencent.mobileqq.panel.FontBubblePanelView.c
    public void d(ISVIPHandler iSVIPHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iSVIPHandler);
        } else {
            this.f257166a = iSVIPHandler;
            com.tencent.mobileqq.panel.bubble.c.e().d(3, this);
        }
    }

    @Override // com.tencent.mobileqq.panel.FontBubblePanelView.c
    public String e(FontBubble fontBubble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) fontBubble);
        }
        return IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.FONT_PREVIEW).replace("[id]", Integer.toString(fontBubble.fontId));
    }

    @Override // com.tencent.mobileqq.panel.FontBubblePanelView.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<FontBubble> c(QQAppInterface qQAppInterface, AioBubbleRecom$GetAioRecommendRsp aioBubbleRecom$GetAioRecommendRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface, (Object) aioBubbleRecom$GetAioRecommendRsp);
        }
        ArrayList arrayList = new ArrayList();
        if (aioBubbleRecom$GetAioRecommendRsp.items.get() != null) {
            for (AioBubbleRecom$ItemInfo aioBubbleRecom$ItemInfo : aioBubbleRecom$GetAioRecommendRsp.items.get()) {
                FontBubble fontBubble = new FontBubble();
                fontBubble.viewType = 1;
                fontBubble.fontId = aioBubbleRecom$ItemInfo.itemID.get();
                fontBubble.itemBgColor = aioBubbleRecom$ItemInfo.itemBgColor.get();
                fontBubble.name = aioBubbleRecom$ItemInfo.name.get();
                fontBubble.engine = aioBubbleRecom$ItemInfo.fontEngine.get();
                fontBubble.feeType = aioBubbleRecom$ItemInfo.feeType.get();
                fontBubble.isQualified = aioBubbleRecom$ItemInfo.isQualified.get();
                fontBubble.price = aioBubbleRecom$ItemInfo.price.get();
                fontBubble.picUrl = aioBubbleRecom$ItemInfo.image.get();
                fontBubble.panelType = 3;
                arrayList.add(fontBubble);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.panel.FontBubblePanelView.c
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 3;
    }
}
