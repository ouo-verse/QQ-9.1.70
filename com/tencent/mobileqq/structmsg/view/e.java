package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public String R0;
    public String S0;
    public String T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public long Y0;
    public long Z0;

    /* renamed from: a1, reason: collision with root package name */
    public long f290636a1;

    /* renamed from: b1, reason: collision with root package name */
    public StructMsgForImageShare f290637b1;

    /* renamed from: c1, reason: collision with root package name */
    public MessageForPic f290638c1;

    /* renamed from: d1, reason: collision with root package name */
    public URL f290639d1;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.R0 = null;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f290637b1 = null;
        this.f290638c1 = null;
        this.f290639d1 = null;
        this.f290320d = 14;
        this.f290322e = "image";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011e  */
    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View c(Context context, View view, Bundle bundle) {
        URLDrawable uRLDrawable;
        BubbleImageView bubbleImageView;
        int i3;
        int imgThumbMaxPx;
        int i16;
        int imgThumbMaxPx2;
        int i17;
        int i18;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        MessageForPic messageForPic = this.f290638c1;
        if (messageForPic != null) {
            URL url = URLDrawableHelper.getURL(messageForPic, 65537);
            URL url2 = this.f290639d1;
            if (url2 == null || !url2.equals(url)) {
                uRLDrawable = com.tencent.mobileqq.activity.aio.item.i.d(context, this.f290638c1);
                if (uRLDrawable == null) {
                    if (this.f290637b1 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
                        }
                        return new View(context);
                    }
                    MessageForPic messageForPic2 = new MessageForPic();
                    messageForPic2.path = this.R0;
                    messageForPic2.uuid = this.S0;
                    messageForPic2.md5 = this.T0;
                    StructMsgForImageShare structMsgForImageShare = this.f290637b1;
                    messageForPic2.istroop = structMsgForImageShare.uinType;
                    messageForPic2.msgtype = structMsgForImageShare.mMsgType;
                    messageForPic2.versionCode = structMsgForImageShare.messageVersion;
                    messageForPic2.uniseq = structMsgForImageShare.mUniseq;
                    int i19 = structMsgForImageShare.mIsSend;
                    messageForPic2.issend = i19;
                    String str = structMsgForImageShare.currentAccountUin;
                    messageForPic2.selfuin = str;
                    String str2 = structMsgForImageShare.uin;
                    messageForPic2.frienduin = str2;
                    messageForPic2.groupFileID = this.Y0;
                    messageForPic2.busiType = 1030;
                    if (i19 != 1) {
                        str = str2;
                    }
                    messageForPic2.senderuin = str;
                    messageForPic2.size = this.Z0;
                    messageForPic2.time = this.f290636a1;
                    messageForPic2.subVersion = 5;
                    messageForPic2.fileSizeFlag = 0;
                    messageForPic2.thumbHeight = structMsgForImageShare.thumbHeight;
                    messageForPic2.thumbWidth = structMsgForImageShare.thumbWidth;
                    messageForPic2.rawMsgUrl = structMsgForImageShare.rawUrl;
                    messageForPic2.bigMsgUrl = structMsgForImageShare.bigUrl;
                    messageForPic2.thumbMsgUrl = structMsgForImageShare.thumbUrl;
                    if (n()) {
                        messageForPic2.thumbWidthHeightDP = new ThumbWidthHeightDP(this.U0, this.V0, this.W0, this.X0, true);
                        ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).tryAdjustThumbSize(this.f290637b1, messageForPic2, this);
                    }
                    File file = AbsDownloader.getFile(URLDrawableHelper.getURL(messageForPic2, 1, null).toString());
                    if (file != null && GifDrawable.isGifFile(file)) {
                        messageForPic2.imageType = 2000;
                    }
                    this.f290638c1 = messageForPic2;
                    uRLDrawable = com.tencent.mobileqq.activity.aio.item.i.d(context, messageForPic2);
                    this.f290639d1 = uRLDrawable.getURL();
                }
                if (view == null && (view instanceof BubbleImageView)) {
                    bubbleImageView = (BubbleImageView) view;
                } else {
                    bubbleImageView = new BubbleImageView(context);
                    bubbleImageView.setId(R.id.dgx);
                    bubbleImageView.setAdjustViewBounds(true);
                    i3 = this.W0;
                    if (i3 == 0) {
                        imgThumbMaxPx = BaseAIOUtils.f(i3, context.getResources());
                    } else {
                        imgThumbMaxPx = CommonImgThumbHelper.getImgThumbMaxPx(false);
                    }
                    bubbleImageView.setMaxWidth(imgThumbMaxPx);
                    i16 = this.X0;
                    if (i16 == 0) {
                        imgThumbMaxPx2 = BaseAIOUtils.f(i16, context.getResources());
                    } else {
                        imgThumbMaxPx2 = CommonImgThumbHelper.getImgThumbMaxPx(false);
                    }
                    bubbleImageView.setMaxHeight(imgThumbMaxPx2);
                    i17 = this.U0;
                    if (i17 != 0) {
                        bubbleImageView.setMinimumWidth(BaseAIOUtils.f(i17, context.getResources()));
                    }
                    i18 = this.V0;
                    if (i18 != 0) {
                        bubbleImageView.setMinimumHeight(BaseAIOUtils.f(i18, context.getResources()));
                    }
                    bubbleImageView.setAdjustViewBounds(true);
                    bubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    if (!QQTheme.isNowSimpleUI()) {
                        f16 = 8.0f;
                    } else {
                        f16 = 12.0f;
                    }
                    bubbleImageView.setRadius(f16);
                }
                bubbleImageView.m(false);
                bubbleImageView.setShowEdge(true);
                bubbleImageView.setImageDrawable(uRLDrawable);
                ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).tryCompactMaxWidth(this.f290637b1, bubbleImageView, this);
                return bubbleImageView;
            }
        }
        uRLDrawable = null;
        if (uRLDrawable == null) {
        }
        if (view == null) {
        }
        bubbleImageView = new BubbleImageView(context);
        bubbleImageView.setId(R.id.dgx);
        bubbleImageView.setAdjustViewBounds(true);
        i3 = this.W0;
        if (i3 == 0) {
        }
        bubbleImageView.setMaxWidth(imgThumbMaxPx);
        i16 = this.X0;
        if (i16 == 0) {
        }
        bubbleImageView.setMaxHeight(imgThumbMaxPx2);
        i17 = this.U0;
        if (i17 != 0) {
        }
        i18 = this.V0;
        if (i18 != 0) {
        }
        bubbleImageView.setAdjustViewBounds(true);
        bubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!QQTheme.isNowSimpleUI()) {
        }
        bubbleImageView.setRadius(f16);
        bubbleImageView.m(false);
        bubbleImageView.setShowEdge(true);
        bubbleImageView.setImageDrawable(uRLDrawable);
        ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).tryCompactMaxWidth(this.f290637b1, bubbleImageView, this);
        return bubbleImageView;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        String a16 = jVar.a("uuid");
        String a17 = jVar.a("md5");
        String a18 = jVar.a("md5");
        String a19 = jVar.a(MediaDBValues.FILESIZE);
        String a26 = jVar.a("local_path");
        if (a16 == null) {
            a16 = "";
        }
        this.S0 = a16;
        if (a17 == null) {
            a17 = "";
        }
        this.T0 = a17;
        if (a26 == null) {
            a26 = "";
        }
        this.R0 = a26;
        this.U0 = com.tencent.mobileqq.activity.aio.l.S(jVar, NodeProps.MIN_WIDTH);
        this.V0 = com.tencent.mobileqq.activity.aio.l.S(jVar, NodeProps.MIN_HEIGHT);
        this.W0 = com.tencent.mobileqq.activity.aio.l.S(jVar, NodeProps.MAX_WIDTH);
        this.X0 = com.tencent.mobileqq.activity.aio.l.S(jVar, NodeProps.MAX_HEIGHT);
        if (a18 != null) {
            try {
                this.Y0 = Long.parseLong(a18);
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, e16.getMessage());
                }
            }
        }
        if (a19 != null) {
            try {
                this.Z0 = Long.parseLong(a19);
            } catch (NumberFormatException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, e17.getMessage());
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "Image";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.R0 = objectInput.readUTF();
        this.S0 = objectInput.readUTF();
        this.T0 = objectInput.readUTF();
        this.Y0 = objectInput.readLong();
        this.Z0 = objectInput.readLong();
        this.f290636a1 = objectInput.readLong();
        if (this.f290320d > 13) {
            this.U0 = objectInput.readInt();
            this.V0 = objectInput.readInt();
            this.W0 = objectInput.readInt();
            this.X0 = objectInput.readInt();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "image");
        String str = this.S0;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        xmlSerializer.attribute(null, "uuid", str);
        String str3 = this.T0;
        if (str3 == null) {
            str3 = "";
        }
        xmlSerializer.attribute(null, "md5", str3);
        xmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.Y0));
        xmlSerializer.attribute(null, MediaDBValues.FILESIZE, String.valueOf(this.Z0));
        String str4 = this.R0;
        if (str4 != null) {
            str2 = str4;
        }
        xmlSerializer.attribute(null, "local_path", str2);
        xmlSerializer.attribute(null, NodeProps.MIN_WIDTH, Integer.toString(this.U0));
        xmlSerializer.attribute(null, NodeProps.MIN_HEIGHT, Integer.toString(this.V0));
        xmlSerializer.attribute(null, NodeProps.MAX_WIDTH, Integer.toString(this.W0));
        xmlSerializer.attribute(null, NodeProps.MAX_HEIGHT, Integer.toString(this.X0));
        xmlSerializer.endTag(null, "image");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.R0;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.S0;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        String str4 = this.T0;
        if (str4 != null) {
            str2 = str4;
        }
        objectOutput.writeUTF(str2);
        objectOutput.writeLong(this.Y0);
        objectOutput.writeLong(this.Z0);
        objectOutput.writeLong(this.f290636a1);
        if (this.f290320d > 13) {
            objectOutput.writeInt(this.U0);
            objectOutput.writeInt(this.V0);
            objectOutput.writeInt(this.W0);
            objectOutput.writeInt(this.X0);
        }
    }

    public MessageForPic m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MessageForPic) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        MessageForPic messageForPic = new MessageForPic();
        StructMsgForImageShare structMsgForImageShare = this.f290637b1;
        if (structMsgForImageShare == null) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "StructMsgItemImage.generateMessageForPic.mImageShareMsg == null nudnik trick");
            }
            return messageForPic;
        }
        messageForPic.path = this.R0;
        messageForPic.uuid = this.S0;
        messageForPic.md5 = this.T0;
        messageForPic.istroop = structMsgForImageShare.uinType;
        messageForPic.msgtype = structMsgForImageShare.mMsgType;
        messageForPic.versionCode = structMsgForImageShare.messageVersion;
        messageForPic.uniseq = structMsgForImageShare.mUniseq;
        int i3 = structMsgForImageShare.mIsSend;
        messageForPic.issend = i3;
        String str = structMsgForImageShare.currentAccountUin;
        messageForPic.selfuin = str;
        String str2 = structMsgForImageShare.uin;
        messageForPic.frienduin = str2;
        messageForPic.groupFileID = this.Y0;
        messageForPic.busiType = 1030;
        if (i3 != 1) {
            str = str2;
        }
        messageForPic.senderuin = str;
        messageForPic.size = this.Z0;
        messageForPic.time = this.f290636a1;
        messageForPic.subVersion = 5;
        messageForPic.fileSizeFlag = 0;
        messageForPic.thumbHeight = structMsgForImageShare.thumbHeight;
        messageForPic.thumbWidth = structMsgForImageShare.thumbWidth;
        return messageForPic;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.U0 != 0 && this.V0 != 0 && this.W0 != 0 && this.X0 != 0) {
            return true;
        }
        return false;
    }

    public e(String str) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.R0 = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }
}
