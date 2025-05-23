package com.tencent.mobileqq.profilecard.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

/* loaded from: classes16.dex */
public abstract class AbsProfileBusinessProcessor implements IRequestProfileCardCallback, IGetProfileDetailCallback {
    static IPatchRedirector $redirector_;
    protected AppRuntime appRuntime;

    public AbsProfileBusinessProcessor(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.appRuntime = appRuntime;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailRequestForLogin(List<Short> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailResponseBegin(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailResponseEnd(Bundle bundle, boolean z16, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, bundle, Boolean.valueOf(z16), card);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLV(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVBegin(Bundle bundle, long j3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bundle, Long.valueOf(j3), card);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVEnd(Bundle bundle, long j3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, bundle, Long.valueOf(j3), card);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfile0x5eb(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bundle, card, respHead, respSummaryCard, oidb_0x5eb_udcuindata);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileCard(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, card, respHead, respSummaryCard);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileService(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bundle, card, respHead, respSummaryCard, sparseArray);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(Bundle bundle, ArrayList<BusinessReqBuffer> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bundle, arrayList, arrayList2);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onResponseProfileCard(boolean z16, Bundle bundle, RespHead respHead, RespSummaryCard respSummaryCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle, respHead, respSummaryCard);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void requestParseProfileLocation(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) card);
        }
    }
}
