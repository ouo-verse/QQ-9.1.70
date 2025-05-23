package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class y extends p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public MessageRecord f205303a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f205304b;

    public y(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageRecord);
        } else {
            this.f205303a = messageRecord;
        }
    }

    public p A(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (p) iPatchRedirector.redirect((short) 23, (Object) this, (Object) bundle);
        }
        if (bundle.containsKey("cur_msg_uniseq")) {
            QLog.d("MsgEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
            String string = bundle.getString("cur_msg_uin");
            int i3 = bundle.getInt("cur_msg_uin_type");
            long j3 = bundle.getLong("cur_msg_uniseq");
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                return new y(((QQAppInterface) runtime).getMessageFacade().w0(string, i3, j3));
            }
            return null;
        }
        return null;
    }

    public PicElement B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PicElement) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord != null && (messageRecord instanceof MessageForPic)) {
            return ((MessageForPic) messageRecord).getPicElement();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public CustomEmotionData a() {
        List<CustomEmotionData> emoticonDataList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CustomEmotionData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        MessageRecord messageRecord = this.f205303a;
        if ((messageRecord instanceof MessageForPic) && ((MessageForPic) messageRecord).md5 != null) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime instanceof QQAppInterface) && (emoticonDataList = ((IFavroamingDBManagerService) ((QQAppInterface) runtime).getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList()) != null) {
                for (CustomEmotionData customEmotionData : emoticonDataList) {
                    if (((MessageForPic) this.f205303a).md5.equalsIgnoreCase(customEmotionData.md5)) {
                        return customEmotionData;
                    }
                    Object obj = this.f205303a.extObj;
                    if (obj instanceof MsgElement) {
                        MsgElement msgElement = (MsgElement) obj;
                        if (msgElement.getPicElement() != null && (str = msgElement.getPicElement().originImageMd5) != null && str.equalsIgnoreCase(customEmotionData.md5)) {
                            return customEmotionData;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public int b(List<p> list) {
        MessageRecord messageRecord;
        MessageRecord messageRecord2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list)).intValue();
        }
        for (p pVar : list) {
            if ((pVar instanceof y) && (messageRecord = ((y) pVar).f205303a) != null && (messageRecord2 = this.f205303a) != null && messageRecord.uniseq == messageRecord2.uniseq) {
                if ((messageRecord instanceof MessageForPic) && (messageRecord2 instanceof MessageForPic) && (str = ((MessageForPic) messageRecord).md5) != null) {
                    if (str.equals(((MessageForPic) messageRecord2).md5)) {
                        return list.indexOf(pVar);
                    }
                } else {
                    return list.indexOf(pVar);
                }
            }
        }
        return list.size() - 1;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public Drawable c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord instanceof MessageForPic) {
            String str = ((MessageForPic) messageRecord).path;
            if (FileUtils.fileExists(str)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mPlayGifImage = true;
                obtain.mGifRefreshDelay = com.tencent.mobileqq.emosm.e.v();
                return URLDrawable.getFileDrawable(str, obtain);
            }
        }
        s sVar = new s(this.f205303a);
        Drawable a16 = r.a(context, sVar);
        this.f205304b = sVar.f205292d;
        return a16;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord instanceof MessageForMarketFace) {
            return ((MessageForMarketFace) messageRecord).getMarketFaceId();
        }
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
            if (picMessageExtraData != null && !TextUtils.isEmpty(picMessageExtraData.emojiId) && !TextUtils.equals(picMessageExtraData.emojiId, "0")) {
                return picMessageExtraData.emojiId;
            }
            return messageForPic.md5;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String e() {
        PicMessageExtraData picMessageExtraData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord instanceof MessageForMarketFace) {
            return String.valueOf(((MessageForMarketFace) messageRecord).getMarketFacePackageId());
        }
        if ((messageRecord instanceof MessageForPic) && (picMessageExtraData = ((MessageForPic) messageRecord).picExtraData) != null && !TextUtils.isEmpty(picMessageExtraData.emojiPkgId) && !TextUtils.equals(picMessageExtraData.emojiPkgId, "0")) {
            return picMessageExtraData.emojiPkgId;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public EmoticonInfo f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (EmoticonInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord instanceof MessageForMarketFace) {
            return (EmoticonInfo) r.f((MessageForMarketFace) messageRecord);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String g() {
        PicElement picElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        MessageRecord messageRecord = this.f205303a;
        if ((messageRecord instanceof MessageForPic) && (picElement = ((MessageForPic) messageRecord).getPicElement()) != null) {
            return picElement.getOriginImageMd5();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String h() {
        PicElement picElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        MessageRecord messageRecord = this.f205303a;
        if ((messageRecord instanceof MessageForPic) && (picElement = ((MessageForPic) messageRecord).getPicElement()) != null && picElement.getEmojiMall() != null) {
            return String.valueOf(picElement.getEmojiMall().getPackageId());
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        if (x()) {
            return 1000;
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord instanceof MessageForMarketFace) {
            return 1001;
        }
        if ((messageRecord instanceof MessageForPic) && ((MessageForPic) messageRecord).picExtraData != null) {
            return ((MessageForPic) messageRecord).picExtraData.imageBizType;
        }
        return super.i();
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord == null) {
            return -1L;
        }
        return messageRecord.shmsgseq;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord == null) {
            return 0L;
        }
        return messageRecord.uniseq;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        MessageRecord messageRecord = this.f205303a;
        if ((messageRecord instanceof MessageForPic) && ((MessageForPic) messageRecord).picExtraData != null) {
            int i3 = ((MessageForPic) messageRecord).picExtraData.from;
            if (i3 == 1 || i3 == 2) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return p.n(this.f205303a);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return p.p(this.f205303a);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f205303a instanceof MessageForMarketFace;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord instanceof MessageForPic) {
            return FileUtils.fileExists(((MessageForPic) messageRecord).path);
        }
        return this.f205304b;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean t(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pVar)).booleanValue();
        }
        if (pVar == null || k() != pVar.k()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        MessageRecord messageRecord = this.f205303a;
        if ((messageRecord instanceof MessageForPic) && ((MessageForPic) messageRecord).picExtraData != null) {
            return ((MessageForPic) messageRecord).picExtraData.isSelfieFace();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f205303a instanceof MessageForVideoEmoticon;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return p.w(this.f205303a);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public void y(Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle, i3);
            return;
        }
        super.y(bundle, i3);
        MessageRecord messageRecord = this.f205303a;
        if (messageRecord != null) {
            bundle.putString("cur_msg_uin", messageRecord.frienduin);
            bundle.putInt("cur_msg_uin_type", this.f205303a.istroop);
            bundle.putLong("cur_msg_uniseq", this.f205303a.uniseq);
        }
    }
}
