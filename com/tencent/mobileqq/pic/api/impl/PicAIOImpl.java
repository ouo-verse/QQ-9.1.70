package com.tencent.mobileqq.pic.api.impl;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError;

/* loaded from: classes16.dex */
public class PicAIOImpl implements IPicAIO {
    static IPatchRedirector $redirector_;

    public PicAIOImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public float getAioImageRoundCorner(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams)).floatValue();
        }
        Object obj = downloadParams.tag;
        if (obj instanceof MessageForPic) {
            if (((MessageForPic) obj).istroop == 10014) {
                return 0.0f;
            }
            return 8.0f;
        }
        if ((obj instanceof MessageForFile) && ((MessageForFile) obj).istroop == 10014) {
            return 0.0f;
        }
        return 8.0f;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public String getReceivePicFailedTip(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable);
        }
        return PicDownloadExplicitError.getFailedTip(uRLDrawable);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public String getSendPicFailedTip(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPic);
        }
        return PicUploadExplicitError.getFailedTip(messageForPic);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public int getThumbMaxPx(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3))).intValue();
        }
        return AIOImgThumbHelper.getAioThumbMaxPx(z16, z17, i3);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public int getThumbMinPx(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3))).intValue();
        }
        return AIOImgThumbHelper.getAioThumbMinPx(z16, z17, i3);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public int getThumbMinPxForFileWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        return AIOImgThumbHelper.getAioThumbMinPxForFileWidth(i3);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public ThumbWidthHeightDP getThumbWidthHeightDP(MessageForPic messageForPic, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic, z16) : (ThumbWidthHeightDP) iPatchRedirector.redirect((short) 5, this, messageForPic, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public ThumbWidthHeightDP getThumbWidthHeightDPForFile(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ThumbWidthHeightDP) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return AIOImgThumbHelper.getThumbWidthHeightDPForFileMsg(i3);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public void initAioThumbSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            AIOImgThumbHelper.initAioThumbSize();
            CommonImgThumbHelper.initAioThumbSizeByDpc();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public void reportNormalPicMsgClickEvent(MessageForPic messageForPic) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) messageForPic);
            return;
        }
        AIOPicThumbSizeProcessor.a b16 = AIOPicThumbSizeProcessor.b();
        if (b16 != null) {
            double d16 = b16.f202416b;
            if (d16 > 0.0d) {
                i3 = (int) (d16 * 100.0d);
            } else if (!b16.equals(new AIOPicThumbSizeProcessor().g()) && b16.f202415a) {
                i3 = 0;
            } else {
                i3 = 101;
            }
            int i16 = i3;
            int i17 = messageForPic.istroop;
            if (i17 == 0) {
                str = "1";
            } else if (ao.u(i17)) {
                str = "2";
            } else if (ao.r(messageForPic.istroop)) {
                str = "3";
            } else {
                str = "4";
            }
            ReportController.o(null, "dc00898", "", "", "0X800B2A2", "0X800B2A2", i16, 0, str, "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIO
    public ThumbWidthHeightDP getThumbWidthHeightDP(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? AIOImgThumbHelper.getThumbWidthHeightDPForPicMsg(z16, z17, i3) : (ThumbWidthHeightDP) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
    }
}
