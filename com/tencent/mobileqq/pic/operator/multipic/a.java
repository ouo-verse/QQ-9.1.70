package com.tencent.mobileqq.pic.operator.multipic;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.operator.multipic.c;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends b implements ad {
    static IPatchRedirector $redirector_;
    final int E;
    final q F;
    final l G;
    final Rect H;

    public a(c.a aVar, WeakReference<AppInterface> weakReference, int i3, String str) {
        super(aVar, weakReference);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, weakReference, Integer.valueOf(i3), str);
            return;
        }
        this.E = i3;
        this.F = this.f258765h.get(i3);
        this.G = this.f258766i.get(i3);
        this.H = l(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r2 = (int) ((r5 * 198.0f) / r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r3 >= 198) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r3 >= 198) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        if (r6 > 3.0f) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Rect l(String str) {
        Rect rect = new Rect(0, 0, 0, 0);
        if (str != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            int i16 = options.outHeight;
            int min = Math.min(i3, i16);
            int max = Math.max(i3, i16);
            float f16 = max;
            float f17 = min;
            float f18 = f16 / f17;
            if (min <= 198) {
                if (min > 66 && min <= 198) {
                    if (f18 <= 3.0f) {
                    }
                    min = 66;
                } else if (min <= 66) {
                    if (f18 > 3.0f) {
                    }
                }
                if (i3 >= i16) {
                    rect.right = min;
                    rect.bottom = max;
                } else {
                    rect.right = max;
                    rect.bottom = min;
                }
            }
            max = 198;
            if (i3 >= i16) {
            }
        }
        return rect;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0349 A[Catch: all -> 0x0374, TryCatch #2 {, blocks: (B:33:0x02c8, B:37:0x0301, B:38:0x0316, B:40:0x0349, B:41:0x0372, B:44:0x030c), top: B:32:0x02c8 }] */
    @Override // com.tencent.mobileqq.pic.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
        }
        boolean z16 = false;
        if (im_msg_body_richtext != null && im_msg_body_richtext.elems.has()) {
            im_msg_body$Elem im_msg_body_elem = im_msg_body_richtext.elems.get(0);
            if (im_msg_body_elem != null) {
                if (im_msg_body_elem.not_online_image.has()) {
                    im_msg_body$NotOnlineImage im_msg_body_notonlineimage = im_msg_body_elem.not_online_image.get();
                    im_msg_body_notonlineimage.uint32_thumb_width.set(this.H.right);
                    im_msg_body_notonlineimage.uint32_thumb_height.set(this.H.bottom);
                    int i3 = this.G.f258732h.f258713h;
                    if (i3 != 1 && i3 != 3000) {
                        synchronized (this.f258765h) {
                            q qVar = this.F;
                            qVar.f258790a = 0;
                            qVar.f258793d = im_msg_body_notonlineimage;
                        }
                        f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] OK, " + c(im_msg_body_notonlineimage));
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + this.E + "] OK");
                        }
                    } else {
                        f.f(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2CustomFace for [" + this.E + "] ");
                        im_msg_body$CustomFace d16 = d(im_msg_body_notonlineimage);
                        synchronized (this.f258765h) {
                            q qVar2 = this.F;
                            qVar2.f258790a = 0;
                            qVar2.f258793d = d16;
                        }
                        f.f(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] OK, " + a(d16));
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + this.E + "] OK");
                        }
                    }
                } else if (im_msg_body_elem.custom_face.has()) {
                    im_msg_body$CustomFace im_msg_body_customface = im_msg_body_elem.custom_face.get();
                    im_msg_body_customface.uint32_thumb_width.set(this.H.right);
                    im_msg_body_customface.uint32_thumb_height.set(this.H.bottom);
                    int i16 = this.G.f258732h.f258713h;
                    if (i16 != 1 && i16 != 3000) {
                        f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2NotOnlineImage for [" + this.E + "] ");
                        im_msg_body$NotOnlineImage e16 = e(im_msg_body_customface);
                        synchronized (this.f258765h) {
                            q qVar3 = this.F;
                            qVar3.f258790a = 0;
                            qVar3.f258793d = e16;
                        }
                        f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] OK, " + c(e16));
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + this.E + "] OK");
                        }
                    } else {
                        synchronized (this.f258765h) {
                            q qVar4 = this.F;
                            qVar4.f258790a = 0;
                            qVar4.f258793d = im_msg_body_customface;
                        }
                        f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] OK, " + a(im_msg_body_customface));
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + this.E + "] OK");
                        }
                    }
                } else {
                    f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] failed, elem.not_online_image and elem.custom_face are null");
                }
                z16 = true;
            } else {
                f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] failed, richText.elems is null");
            }
        } else {
            f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] failed, richText is null or richText.elems is null");
        }
        if (!z16) {
            synchronized (this.f258765h) {
                q qVar5 = this.F;
                qVar5.f258790a = -1;
                qVar5.f258791b = new m.a();
                m.a aVar = this.F.f258791b;
                aVar.f258738c = -1;
                aVar.f258737b = "Get target pic filepath of [" + this.E + "] failed";
                int i17 = this.G.f258732h.f258713h;
                if (i17 != 1 && i17 != 3000) {
                    this.F.f258793d = h(null, null, this.E);
                    f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] failed, errDec \uff1d " + this.F.f258791b.f258737b);
                    if (QLog.isColorLevel()) {
                        QLog.e("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + this.E + "] failed, errDec \uff1d " + this.F.f258791b.f258737b);
                    }
                }
                this.F.f258793d = f(null, null, this.E);
                f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.E + "] failed, errDec \uff1d " + this.F.f258791b.f258737b);
                if (QLog.isColorLevel()) {
                }
            }
        }
        k();
        if (i() == 0) {
            j();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0081 A[Catch: all -> 0x00b9, TryCatch #0 {, blocks: (B:11:0x0012, B:13:0x0016, B:18:0x003d, B:19:0x004e, B:21:0x0081, B:22:0x00ab, B:24:0x00b4, B:25:0x0046, B:26:0x00b7), top: B:10:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4 A[Catch: all -> 0x00b9, TryCatch #0 {, blocks: (B:11:0x0012, B:13:0x0016, B:18:0x003d, B:19:0x004e, B:21:0x0081, B:22:0x00ab, B:24:0x00b4, B:25:0x0046, B:26:0x00b7), top: B:10:0x0012 }] */
    @Override // com.tencent.mobileqq.pic.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ad.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.f258765h) {
            if (aVar.f258597a != 0) {
                q qVar = this.F;
                qVar.f258790a = -1;
                qVar.f258791b = new m.a();
                q qVar2 = this.F;
                m.a aVar2 = qVar2.f258791b;
                aVar2.f258737b = aVar.f258599c;
                aVar2.f258738c = aVar.f258598b;
                int i3 = this.G.f258732h.f258713h;
                if (i3 != 1 && i3 != 3000) {
                    qVar2.f258793d = h(null, null, this.E);
                    f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onSend", "[" + this.E + "] failed, errDec = " + this.F.f258791b.f258737b);
                    if (QLog.isColorLevel()) {
                        QLog.e("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + this.E + "] failed, errDec \uff1d " + this.F.f258791b.f258737b);
                    }
                    k();
                    if (i() == 0) {
                        j();
                    }
                }
                qVar2.f258793d = f(null, null, this.E);
                f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onSend", "[" + this.E + "] failed, errDec = " + this.F.f258791b.f258737b);
                if (QLog.isColorLevel()) {
                }
                k();
                if (i() == 0) {
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }
}
