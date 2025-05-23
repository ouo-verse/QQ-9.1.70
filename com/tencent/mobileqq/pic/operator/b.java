package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.ZPlanPicExtraData;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.u;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import cooperation.peak.PeakConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends UploadPicOperator {
    static IPatchRedirector $redirector_;
    private static final Set<Integer> F;
    boolean E;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f258756a;

        /* renamed from: b, reason: collision with root package name */
        public long f258757b;

        /* renamed from: c, reason: collision with root package name */
        public String f258758c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f258759d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f258759d = false;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "QuickSendObject{mOriginMD5='" + this.f258756a + "', mOriginSize=" + this.f258757b + ", mThumbMD5='" + this.f258758c + "', mQuickSendFailed=" + this.f258759d + '}';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        HashSet hashSet = new HashSet();
        F = hashSet;
        hashSet.add(1042);
        hashSet.add(5);
        hashSet.add(1047);
        hashSet.add(1054);
        hashSet.add(1044);
        hashSet.add(1049);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.E = false;
        }
    }

    public static a L(MessageRecord messageRecord, TransferRequest transferRequest) {
        if (F.contains(Integer.valueOf(transferRequest.mBusiType))) {
            try {
                long longValue = Long.valueOf(messageRecord.getExtInfoFromExtStr(IPicBus.ORIGINAL_SIZE)).longValue();
                String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(IPicBus.ORIGINAL_MD5);
                if (longValue > 0 && !extInfoFromExtStr.equals("")) {
                    a aVar = new a();
                    aVar.f258756a = extInfoFromExtStr;
                    aVar.f258757b = longValue;
                    aVar.f258758c = messageRecord.getExtInfoFromExtStr(IPicBus.THUMB_MD5);
                    return aVar;
                }
                return null;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public v B(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (v) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        v B = super.B(intent);
        if (intent != null && B != null) {
            a aVar = new a();
            aVar.f258756a = intent.getStringExtra(IPicBus.ORIGINAL_MD5);
            aVar.f258757b = intent.getLongExtra(IPicBus.ORIGINAL_SIZE, 0L);
            aVar.f258758c = intent.getStringExtra(IPicBus.THUMB_MD5);
            B.f258821g0 = aVar;
            B.f258834t0 = intent.getIntExtra(PeakConstants.KEY_EMOTION_SOURCE_FROM, 0);
            B.f258835u0 = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_INFO);
            B.f258836v0 = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_WEBURL);
            B.f258837w0 = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_ICONURL);
            B.f258838x0 = intent.getStringExtra(PeakConstants.KEY_EMOTION_SOURCE_PACKAGE);
            B.f258839y0 = intent.getIntExtra(PeakConstants.KEY_EMOTION_SOURCE_EPID, 0);
            if (B.f258840z0 == null) {
                B.f258840z0 = new u();
            }
            B.f258840z0.f258806c = intent.getBooleanExtra(IPicBus.IS_AD_EMO, false);
            B.f258840z0.f258807d = intent.getStringExtra(IPicBus.AD_EMO_JUMP_URL);
            B.f258840z0.f258808e = intent.getStringExtra(IPicBus.AD_EMO_DESC_STR);
            B.f258840z0.f258809f = intent.getBooleanExtra(IPicBus.IS_EMO_SEARCH, false);
            if (intent.hasExtra(IPicBus.ZPLAN_PIC_EXTRA_MAP)) {
                B.f258840z0.f258813j = (HashMap) intent.getSerializableExtra(IPicBus.ZPLAN_PIC_EXTRA_MAP);
            }
        }
        return B;
    }

    public void M(MessageRecord messageRecord, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord, (Object) aVar);
            return;
        }
        if (aVar != null && messageRecord != null) {
            messageRecord.saveExtInfoToExtStr(IPicBus.ORIGINAL_MD5, aVar.f258756a);
            messageRecord.saveExtInfoToExtStr(IPicBus.ORIGINAL_SIZE, String.valueOf(aVar.f258757b));
            messageRecord.saveExtInfoToExtStr(IPicBus.THUMB_MD5, aVar.f258758c);
            this.E = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.BasePicOperator
    public void o(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic);
        } else if (!this.E || messageForPic.imageType != 2000) {
            super.o(messageForPic);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public void w(MessageForPic messageForPic, v vVar) {
        HashMap<String, String> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPic, (Object) vVar);
            return;
        }
        if (vVar == null) {
            return;
        }
        super.w(messageForPic, vVar);
        int i3 = this.f258751f.f258784e;
        Object obj = vVar.f258821g0;
        if (obj instanceof a) {
            M(messageForPic, (a) obj);
        }
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData == null) {
            picMessageExtraData = new PicMessageExtraData();
        }
        if (i3 == 1042) {
            if (vVar.i()) {
                picMessageExtraData.imageBizType = 13;
            } else {
                picMessageExtraData.imageBizType = 2;
            }
            picMessageExtraData.textSummary = this.f258754m.getApp().getString(R.string.iml);
            messageForPic.picExtraData = picMessageExtraData;
            return;
        }
        if (i3 == 1047) {
            if (vVar.h()) {
                picMessageExtraData.imageBizType = 9;
                picMessageExtraData.setAdEmoJumpUrl(vVar.f258840z0.f258807d);
                picMessageExtraData.setAdEmoDescStr(vVar.f258840z0.f258808e);
            } else {
                picMessageExtraData.imageBizType = 7;
            }
            String currentText = ((IStickerRecManager) this.f258754m.getRuntimeService(IStickerRecManager.class, "")).getCurrentText();
            if (!TextUtils.isEmpty(currentText)) {
                picMessageExtraData.textSummary = "[" + currentText + "]";
            }
            messageForPic.picExtraData = picMessageExtraData;
            return;
        }
        if (i3 == 1044) {
            picMessageExtraData.imageBizType = 3;
            picMessageExtraData.textSummary = this.f258754m.getApp().getString(R.string.iml);
            messageForPic.picExtraData = picMessageExtraData;
            return;
        }
        if (i3 == 1049) {
            picMessageExtraData.imageBizType = 4;
            if (this.f258754m instanceof AppInterface) {
                String zhituText = ((IDep) QRoute.api(IDep.class)).getZhituText();
                if (TextUtils.isEmpty(zhituText)) {
                    return;
                }
                picMessageExtraData.textSummary = "[" + zhituText + "]";
            }
            messageForPic.picExtraData = picMessageExtraData;
            return;
        }
        if (i3 == 1054) {
            picMessageExtraData.imageBizType = 10;
            picMessageExtraData.textSummary = this.f258754m.getApp().getString(R.string.iml);
            messageForPic.picExtraData = picMessageExtraData;
        } else if (i3 == 1060) {
            picMessageExtraData.imageBizType = 1;
            u uVar = vVar.f258840z0;
            if (uVar != null && (hashMap = uVar.f258813j) != null) {
                picMessageExtraData.mZPlanPicInfo = ZPlanPicExtraData.parseMapToZPlanPicExtraData(hashMap);
                picMessageExtraData.textSummary = "[" + picMessageExtraData.mZPlanPicInfo.getName() + "]";
            }
            messageForPic.picExtraData = picMessageExtraData;
        }
    }
}
