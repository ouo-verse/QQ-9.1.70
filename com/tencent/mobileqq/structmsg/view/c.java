package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.HttpDownloaderParams;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;
import org.slf4j.Marker;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public static int Y0;
    public static int Z0;

    /* renamed from: a1, reason: collision with root package name */
    public static int f290634a1;
    public boolean R0;
    public String S0;
    public String T0;
    public int U0;
    public int V0;
    public int W0;
    private URLDrawableDownListener.Adapter X0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            super.onLoadCancelled(view, uRLDrawable);
            if (QLog.isColorLevel()) {
                QLog.d("StructMsgItemCover", 2, "onLoadCancelled");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
                return;
            }
            super.onLoadFailed(view, uRLDrawable, th5);
            if (QLog.isColorLevel()) {
                QLog.d("StructMsgItemCover", 2, "onLoadFailed ,cause = " + th5);
            }
            if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                String url = uRLDrawable.getURL().toString();
                if (url.startsWith("http://url.cn")) {
                    try {
                        URLDrawable drawable = URLDrawable.getDrawable(new URL(url.replace("http://", "https://")), (URLDrawable.URLDrawableOptions) uRLDrawable.getTag());
                        drawable.setAutoDownload(true);
                        ((PAHighLightImageView) view).setImageDrawable(drawable);
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                if (uRLDrawable != null) {
                    hashMap.put("param_Url", uRLDrawable.getURL().toString());
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StructMsgPicShow", false, 0L, 0L, hashMap, null);
            } catch (Exception unused) {
            }
            c.this.m(view, 0, 1001);
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, interruptedException);
                return;
            }
            super.onLoadInterrupted(view, uRLDrawable, interruptedException);
            if (QLog.isColorLevel()) {
                QLog.d("StructMsgItemCover", 2, "onLoadInterrupted");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            if (view == null) {
                return;
            }
            view.setBackgroundDrawable(null);
            if (view instanceof ImageView) {
                ((ImageView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_Url", uRLDrawable.getURL().toString());
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StructMsgPicShow", true, 0L, 0L, hashMap, null);
            } catch (Exception unused) {
            }
            if (QLog.isColorLevel()) {
                QLog.d("StructMsgItemCover", 2, "onLoadSuccessed");
            }
            c.this.m(view, 1, 1001);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75515);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        Y0 = 1;
        Z0 = 2;
        f290634a1 = 3;
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.R0 = false;
        this.W0 = f290634a1;
        this.X0 = new a();
        this.f290322e = "picture";
        this.f290320d = 19;
    }

    public static Bitmap o(Drawable drawable) {
        Bitmap.Config config;
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicWidth, config);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicWidth);
            drawable.draw(canvas);
            Bitmap roundedCornerBitmap = BaseImageUtil.getRoundedCornerBitmap(createBitmap, intrinsicWidth, intrinsicWidth, intrinsicWidth);
            createBitmap.recycle();
            return roundedCornerBitmap;
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            QLog.e("StructMsgItemCover", 2, "getRoundedCornerBitmap  OutOfMemoryError");
            return null;
        }
    }

    private URLDrawable q(String str, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16, boolean z17, Object obj) {
        try {
            URL url = new URL(str);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable2;
            obtain.mPlayGifImage = z16;
            obtain.mGifRoundCorner = 0.0f;
            obtain.mNeedCheckNetType = z17;
            obtain.mRetryCount = 3;
            obtain.mExtraInfo = obj;
            HttpDownloaderParams httpDownloaderParams = new HttpDownloaderParams();
            httpDownloaderParams.businessType = 1001;
            AbsStructMsg absStructMsg = this.P0;
            if (absStructMsg != null) {
                httpDownloaderParams.param1 = absStructMsg.mMsgServiceID;
                httpDownloaderParams.param2 = absStructMsg.mMsgTemplateID;
                MessageRecord messageRecord = absStructMsg.message;
                if (messageRecord != null) {
                    httpDownloaderParams.param3 = String.valueOf(messageRecord.istroop);
                }
            }
            obtain.mHttpDownloaderParams = httpDownloaderParams;
            URLDrawable drawable3 = URLDrawable.getDrawable(url, obtain);
            if ("url.cn".equals(url.getHost())) {
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mRequestWidth = i3;
                obtain2.mRequestHeight = i16;
                obtain2.mLoadingDrawable = drawable;
                obtain2.mFailedDrawable = drawable2;
                obtain2.mPlayGifImage = z16;
                obtain2.mGifRoundCorner = 0.0f;
                obtain2.mNeedCheckNetType = z17;
                obtain2.mRetryCount = 3;
                obtain2.mExtraInfo = obj;
                obtain2.mHttpDownloaderParams = httpDownloaderParams;
                drawable3.setTag(obtain2);
            }
            return drawable3;
        } catch (MalformedURLException unused) {
            throw new IllegalArgumentException("illegal url format: " + str);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        return n(context, view, false, bundle);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        int parseInt;
        int parseInt2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        String a16 = jVar.a("cover");
        if (a16 == null) {
            a16 = "";
        }
        this.S0 = a16;
        if (this.f290320d > 3) {
            this.f290329i = jVar.a("action");
            this.f290327h = jVar.a("url");
            if (this.f290320d > 5) {
                this.H = jVar.a("index");
                this.I = jVar.a("index_name");
                this.J = jVar.a("index_type");
                try {
                    String a17 = jVar.a("w");
                    if (a17 == null) {
                        parseInt = 0;
                    } else {
                        parseInt = Integer.parseInt(a17);
                    }
                    this.U0 = parseInt;
                    String a18 = jVar.a(tl.h.F);
                    if (a18 == null) {
                        parseInt2 = 0;
                    } else {
                        parseInt2 = Integer.parseInt(a18);
                    }
                    this.V0 = parseInt2;
                } catch (NumberFormatException unused) {
                    this.U0 = 0;
                    this.V0 = 0;
                }
                if (this.f290320d > 8) {
                    this.T0 = jVar.a("needRoundView");
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "Cover";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.S0 = objectInput.readUTF();
        if (this.f290320d > 3) {
            this.f290329i = objectInput.readUTF();
            this.f290327h = objectInput.readUTF();
            if (this.f290320d > 5) {
                this.H = objectInput.readUTF();
                this.I = objectInput.readUTF();
                this.J = objectInput.readUTF();
                this.U0 = objectInput.readInt();
                this.V0 = objectInput.readInt();
                if (this.f290320d > 8) {
                    this.T0 = objectInput.readUTF();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void j(AbsShareMsg absShareMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) absShareMsg);
        } else {
            absShareMsg.mContentCover = this.S0;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "picture");
        String str = this.S0;
        if (str == null) {
            str = "";
        }
        xmlSerializer.attribute(null, "cover", str);
        if (this.f290320d > 3) {
            if (!TextUtils.isEmpty(this.f290329i)) {
                xmlSerializer.attribute(null, "action", this.f290329i);
            }
            if (!TextUtils.isEmpty(this.f290327h)) {
                xmlSerializer.attribute(null, "url", this.f290327h);
            }
            if (this.f290320d > 5) {
                if (!TextUtils.isEmpty(this.H)) {
                    xmlSerializer.attribute(null, "index", this.H);
                }
                if (!TextUtils.isEmpty(this.I)) {
                    xmlSerializer.attribute(null, "index_name", this.I);
                }
                if (!TextUtils.isEmpty(this.J)) {
                    xmlSerializer.attribute(null, "index_type", this.J);
                }
                xmlSerializer.attribute(null, "w", String.valueOf(this.U0));
                xmlSerializer.attribute(null, tl.h.F, String.valueOf(this.V0));
                if (this.f290320d > 8 && !TextUtils.isEmpty(this.T0)) {
                    xmlSerializer.attribute(null, "needRoundView", this.T0);
                }
            }
        }
        xmlSerializer.endTag(null, "picture");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.S0;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        if (this.f290320d > 3) {
            String str3 = this.f290329i;
            if (str3 == null) {
                str3 = "";
            }
            objectOutput.writeUTF(str3);
            String str4 = this.f290327h;
            if (str4 == null) {
                str4 = "";
            }
            objectOutput.writeUTF(str4);
            if (this.f290320d > 5) {
                String str5 = this.H;
                if (str5 == null) {
                    str5 = "";
                }
                objectOutput.writeUTF(str5);
                String str6 = this.I;
                if (str6 == null) {
                    str6 = "";
                }
                objectOutput.writeUTF(str6);
                String str7 = this.J;
                if (str7 == null) {
                    str7 = "";
                }
                objectOutput.writeUTF(str7);
                objectOutput.writeInt(this.U0);
                objectOutput.writeInt(this.V0);
                if (this.f290320d > 8) {
                    String str8 = this.T0;
                    if (str8 != null) {
                        str2 = str8;
                    }
                    objectOutput.writeUTF(str2);
                }
            }
        }
    }

    public void m(View view, int i3, int i16) {
        ChatMessage chatMessage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QQAppInterface qQAppInterface = null;
        try {
            chatMessage = com.tencent.mobileqq.activity.aio.l.C(view);
        } catch (ClassCastException unused) {
            chatMessage = null;
        }
        if (chatMessage == null) {
            return;
        }
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("gdt_msgClick");
        if (!TextUtils.isEmpty(extInfoFromExtStr) && this.S0.endsWith("gif")) {
            String str = "0";
            ChatFragment chatFragment = ((BaseActivity) view.getContext()).getChatFragment();
            if (chatFragment != null) {
                qQAppInterface = chatFragment.ph();
            }
            QQAppInterface qQAppInterface2 = qQAppInterface;
            try {
                JSONObject jSONObject = new JSONObject(extInfoFromExtStr);
                if (jSONObject.has("ad_id")) {
                    str = jSONObject.getString("ad_id");
                }
            } catch (Exception unused2) {
                if (QLog.isColorLevel()) {
                    QLog.e("StructMsgItemCover", 2, "parse ad_id error");
                }
            }
            String str2 = str;
            StructMsgForGeneralShare p16 = p(view);
            if (p16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsgItemCover", 2, "StructMsgForGeneralShare == NULL");
                    return;
                }
                return;
            }
            ReportController.n(qQAppInterface2, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D93", "0X8005D93", i16, 1, i3, str2, String.valueOf(p16.msgId), "1", "");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:249|(1:251)|252|253|254|(1:256)(2:268|(1:270)(9:271|258|259|260|261|(3:113|(1:115)|116)(3:98|(1:100)|101)|(1:103)|(1:112)(3:(1:107)|108|(1:110))|111))|257|258|259|260|261|(1:96)|113|(0)|116|(0)|(0)|112|111) */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0458, code lost:
    
        if (r0.istroop == 1008) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x042f, code lost:
    
        if (r0 != null) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x02f1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x02fd, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x02ff, code lost:
    
        com.tencent.qphone.base.util.QLog.e("StructMsgItemCover", 2, "createView, error: " + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0319, code lost:
    
        r1.setImageDrawable(com.tencent.mobileqq.utils.BaseImageUtil.getDefaultFaceDrawable140_140());
        r0 = r35;
        r15 = r1;
        r30 = "";
        r17 = r13;
        r7 = null;
        r12 = null;
        r13 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0509 A[Catch: Exception -> 0x0538, TryCatch #6 {Exception -> 0x0538, blocks: (B:96:0x04db, B:98:0x04e2, B:100:0x04e8, B:101:0x04ef, B:103:0x0509, B:107:0x0512, B:108:0x0516, B:110:0x052e, B:112:0x0532, B:113:0x04f5, B:115:0x04fb, B:116:0x0502, B:89:0x04b9, B:91:0x04c3, B:92:0x04cb, B:94:0x04d6), top: B:88:0x04b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x050e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04fb A[Catch: Exception -> 0x0538, TryCatch #6 {Exception -> 0x0538, blocks: (B:96:0x04db, B:98:0x04e2, B:100:0x04e8, B:101:0x04ef, B:103:0x0509, B:107:0x0512, B:108:0x0516, B:110:0x052e, B:112:0x0532, B:113:0x04f5, B:115:0x04fb, B:116:0x0502, B:89:0x04b9, B:91:0x04c3, B:92:0x04cb, B:94:0x04d6), top: B:88:0x04b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x049d A[Catch: Exception -> 0x053b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x053b, blocks: (B:81:0x046a, B:127:0x049d, B:131:0x047e, B:134:0x048e, B:140:0x0394, B:143:0x039e, B:147:0x03b8, B:192:0x0465), top: B:139:0x0394 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x047e A[Catch: Exception -> 0x053b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x053b, blocks: (B:81:0x046a, B:127:0x049d, B:131:0x047e, B:134:0x048e, B:140:0x0394, B:143:0x039e, B:147:0x03b8, B:192:0x0465), top: B:139:0x0394 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0470 A[Catch: Exception -> 0x057b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x057b, blocks: (B:63:0x0164, B:66:0x0175, B:68:0x017e, B:202:0x018f, B:204:0x0198, B:206:0x019f, B:208:0x01a5, B:209:0x01ac, B:211:0x01b4, B:213:0x01c0, B:214:0x01c5, B:216:0x01cd, B:218:0x01e1, B:220:0x01ea, B:222:0x01f2, B:223:0x0201, B:226:0x0211, B:228:0x0217, B:229:0x024c, B:230:0x0282, B:232:0x0223, B:233:0x022f, B:235:0x0235, B:236:0x0241, B:237:0x025d, B:239:0x0266, B:240:0x026c, B:241:0x01f9, B:243:0x0274, B:244:0x0286, B:245:0x028e, B:247:0x0297, B:249:0x029e, B:251:0x02a4, B:252:0x02ab, B:254:0x02b8, B:256:0x02be, B:260:0x02dd, B:264:0x02f9, B:266:0x02ff, B:267:0x0319, B:268:0x02c6, B:270:0x02ca, B:70:0x0334, B:72:0x033d, B:74:0x035a, B:76:0x0362, B:78:0x037c, B:83:0x0470, B:86:0x0495, B:133:0x0482, B:135:0x0384, B:137:0x038c, B:145:0x03ab, B:149:0x03c1, B:152:0x03cb, B:154:0x03cf, B:156:0x03d8, B:158:0x03dd, B:169:0x03e6, B:171:0x03f1, B:174:0x041a, B:176:0x042d, B:180:0x03fe, B:183:0x0406, B:186:0x0413, B:160:0x044c, B:162:0x0450, B:164:0x0454, B:189:0x0434, B:190:0x044b), top: B:62:0x0164, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0495 A[Catch: Exception -> 0x057b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x057b, blocks: (B:63:0x0164, B:66:0x0175, B:68:0x017e, B:202:0x018f, B:204:0x0198, B:206:0x019f, B:208:0x01a5, B:209:0x01ac, B:211:0x01b4, B:213:0x01c0, B:214:0x01c5, B:216:0x01cd, B:218:0x01e1, B:220:0x01ea, B:222:0x01f2, B:223:0x0201, B:226:0x0211, B:228:0x0217, B:229:0x024c, B:230:0x0282, B:232:0x0223, B:233:0x022f, B:235:0x0235, B:236:0x0241, B:237:0x025d, B:239:0x0266, B:240:0x026c, B:241:0x01f9, B:243:0x0274, B:244:0x0286, B:245:0x028e, B:247:0x0297, B:249:0x029e, B:251:0x02a4, B:252:0x02ab, B:254:0x02b8, B:256:0x02be, B:260:0x02dd, B:264:0x02f9, B:266:0x02ff, B:267:0x0319, B:268:0x02c6, B:270:0x02ca, B:70:0x0334, B:72:0x033d, B:74:0x035a, B:76:0x0362, B:78:0x037c, B:83:0x0470, B:86:0x0495, B:133:0x0482, B:135:0x0384, B:137:0x038c, B:145:0x03ab, B:149:0x03c1, B:152:0x03cb, B:154:0x03cf, B:156:0x03d8, B:158:0x03dd, B:169:0x03e6, B:171:0x03f1, B:174:0x041a, B:176:0x042d, B:180:0x03fe, B:183:0x0406, B:186:0x0413, B:160:0x044c, B:162:0x0450, B:164:0x0454, B:189:0x0434, B:190:0x044b), top: B:62:0x0164, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04c3 A[Catch: Exception -> 0x0538, TryCatch #6 {Exception -> 0x0538, blocks: (B:96:0x04db, B:98:0x04e2, B:100:0x04e8, B:101:0x04ef, B:103:0x0509, B:107:0x0512, B:108:0x0516, B:110:0x052e, B:112:0x0532, B:113:0x04f5, B:115:0x04fb, B:116:0x0502, B:89:0x04b9, B:91:0x04c3, B:92:0x04cb, B:94:0x04d6), top: B:88:0x04b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x04d6 A[Catch: Exception -> 0x0538, TryCatch #6 {Exception -> 0x0538, blocks: (B:96:0x04db, B:98:0x04e2, B:100:0x04e8, B:101:0x04ef, B:103:0x0509, B:107:0x0512, B:108:0x0516, B:110:0x052e, B:112:0x0532, B:113:0x04f5, B:115:0x04fb, B:116:0x0502, B:89:0x04b9, B:91:0x04c3, B:92:0x04cb, B:94:0x04d6), top: B:88:0x04b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04db A[Catch: Exception -> 0x0538, TryCatch #6 {Exception -> 0x0538, blocks: (B:96:0x04db, B:98:0x04e2, B:100:0x04e8, B:101:0x04ef, B:103:0x0509, B:107:0x0512, B:108:0x0516, B:110:0x052e, B:112:0x0532, B:113:0x04f5, B:115:0x04fb, B:116:0x0502, B:89:0x04b9, B:91:0x04c3, B:92:0x04cb, B:94:0x04d6), top: B:88:0x04b9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View n(Context context, View view, boolean z16, Bundle bundle) {
        Drawable drawable;
        AnyScaleTypeImageView fixRatioPAHighLightImageView;
        View view2;
        AnyScaleTypeImageView anyScaleTypeImageView;
        View view3;
        Object obj;
        String str;
        Drawable drawable2;
        String str2;
        boolean z17;
        View view4;
        Drawable drawable3;
        URLDrawable uRLDrawable;
        boolean z18;
        String str3;
        String str4;
        MessageRecord messageRecord;
        MessageRecord messageRecord2;
        int i3;
        int f16;
        int i16;
        int i17;
        int f17;
        Drawable faceDrawable;
        String str5;
        int dimensionPixelSize;
        String str6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, view, Boolean.valueOf(z16), bundle);
        }
        this.R0 = z16;
        if (QLog.isColorLevel()) {
            QLog.d("[@]", 2, "StructMsgItemCover createView start! mUrlString = " + this.S0);
        }
        boolean z19 = bundle != null ? bundle.getBoolean("pre_dialog") : false;
        boolean z26 = bundle != null ? bundle.getBoolean("pa_should_change") : false;
        Resources resources = context.getResources();
        int i18 = resources.getDisplayMetrics().widthPixels;
        try {
            drawable = ax.a().b(resources, R.drawable.h2r);
        } catch (OutOfMemoryError unused) {
            drawable = null;
        }
        if (view != null && (view instanceof PAImageView)) {
            view2 = view;
            fixRatioPAHighLightImageView = (PAHighLightImageView) view;
        } else {
            fixRatioPAHighLightImageView = new FixRatioPAHighLightImageView(context);
            fixRatioPAHighLightImageView.setId(R.id.dgb);
            fixRatioPAHighLightImageView.setContentDescription(resources.getString(R.string.f170795ad1));
            view2 = fixRatioPAHighLightImageView;
        }
        fixRatioPAHighLightImageView.setTag(this);
        String str7 = this.S0;
        if (TextUtils.isEmpty(str7) && bundle != null && bundle.containsKey("extend-data-json") && bundle.getInt("serviceID", 0) == 128) {
            String string = bundle.getString("extend-data-json");
            if (!TextUtils.isEmpty(string)) {
                try {
                    if (context instanceof BaseActivity) {
                        fixRatioPAHighLightImageView.setImageDrawable(FaceDrawable.getFaceDrawable(((BaseActivity) context).app, 4, new JSONObject(string).optString("groupcode")));
                        try {
                            fixRatioPAHighLightImageView.setBackgroundDrawable(null);
                            return view2;
                        } catch (Throwable th5) {
                            th = th5;
                            QLog.d("StructMsgItemCover", 1, "createView error:" + th.getMessage());
                            if (!TextUtils.isEmpty(str7)) {
                            }
                            str6 = this.f290329i;
                            if (str6 != null) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            return view3;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
        if (!TextUtils.isEmpty(str7)) {
            if (QLog.isColorLevel()) {
                QLog.d("[@]", 2, "StructMsgItemCover createView ,url = " + str7);
            }
            fixRatioPAHighLightImageView.setImageDrawable(drawable);
            fixRatioPAHighLightImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (z26) {
                fixRatioPAHighLightImageView.setBackgroundColor(Color.parseColor("#dddfe2"));
            } else {
                fixRatioPAHighLightImageView.setBackgroundColor(Color.parseColor("#dddfe4"));
            }
            view3 = view2;
            obj = "";
        } else {
            try {
                try {
                    if (str7.startsWith("http://") || str7.startsWith("https://")) {
                        str2 = "#dddfe2";
                        z17 = z26;
                    } else {
                        str2 = "#dddfe2";
                        z17 = z26;
                        if (!str7.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, 73))) {
                            try {
                            } catch (MalformedURLException e16) {
                                e = e16;
                                i16 = 0;
                            }
                            if (str7.startsWith("mqqapi://card")) {
                                int lastIndexOf = str7.lastIndexOf("&uin=");
                                if (lastIndexOf == -1) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("StructMsgItemCover", 2, "createView, error: index is -1");
                                    }
                                    fixRatioPAHighLightImageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable140_140());
                                    return view2;
                                }
                                String substring = str7.substring(lastIndexOf + 5);
                                int lastIndexOf2 = substring.lastIndexOf(ContainerUtils.FIELD_DELIMITER);
                                if (lastIndexOf2 != -1) {
                                    substring = substring.substring(0, lastIndexOf2);
                                }
                                Context context2 = view2.getContext();
                                if (context2 instanceof BaseActivity) {
                                    fixRatioPAHighLightImageView.f316488d = "";
                                    QQAppInterface qQAppInterface = ((BaseActivity) context2).app;
                                    Drawable defaultFaceDrawable140_140 = BaseImageUtil.getDefaultFaceDrawable140_140();
                                    if (str7.indexOf("internal_phone") > -1) {
                                        int indexOf = str7.indexOf("&headtext=");
                                        if (indexOf != -1) {
                                            int indexOf2 = str7.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf + 1);
                                            if (indexOf2 == -1) {
                                                str5 = str7.substring(indexOf + 10);
                                            } else {
                                                str5 = str7.substring(indexOf + 10, indexOf2);
                                            }
                                        } else {
                                            str5 = "";
                                        }
                                        String decode = URLDecoder.decode(str5);
                                        if (!TextUtils.isEmpty(decode.trim())) {
                                            if (z19) {
                                                if (com.tencent.mobileqq.utils.ac.o0(decode)) {
                                                    dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.ayx);
                                                } else {
                                                    dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.ayz);
                                                }
                                            } else if (com.tencent.mobileqq.utils.ac.o0(decode)) {
                                                dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.ayt);
                                            } else {
                                                dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.ayv);
                                            }
                                            fixRatioPAHighLightImageView.setTextSize(dimensionPixelSize);
                                            fixRatioPAHighLightImageView.f316488d = decode;
                                            faceDrawable = context2.getResources().getDrawable(R.drawable.day);
                                        } else if (substring.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                            faceDrawable = FaceDrawable.getMobileFaceDrawable(qQAppInterface, substring, (byte) 3);
                                        } else {
                                            faceDrawable = FaceDrawable.getDefaultDrawable(11, 3);
                                        }
                                    } else {
                                        faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 1, substring, 3, defaultFaceDrawable140_140, defaultFaceDrawable140_140);
                                    }
                                    fixRatioPAHighLightImageView.setImageDrawable(faceDrawable);
                                } else {
                                    fixRatioPAHighLightImageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable140_140());
                                }
                                return view2;
                            }
                            if (str7.startsWith("troop_notice")) {
                                fixRatioPAHighLightImageView.setImageResource(R.drawable.e5u);
                                return view2;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("[@]", 2, "StructMsgItemCover createView ,begin decode");
                            }
                            String url = new File(str7).toURL().toString();
                            try {
                                i17 = this.W0;
                            } catch (MalformedURLException e17) {
                                e = e17;
                                i16 = i18;
                            }
                            if (i17 == Y0) {
                                f17 = BaseAIOUtils.f(70.0f, resources);
                            } else if (i17 == Z0) {
                                f17 = BaseAIOUtils.f(140.0f, resources);
                            } else {
                                i16 = i18;
                                URLDrawable drawable4 = URLDrawable.getDrawable(url, i16, i16, drawable, drawable, true);
                                anyScaleTypeImageView = fixRatioPAHighLightImageView;
                                obj = "";
                                i18 = i16;
                                drawable3 = null;
                                uRLDrawable = drawable4;
                                view4 = view2;
                                z18 = z16;
                                if (uRLDrawable == null && uRLDrawable.getStatus() == 1) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("[@]", 2, "StructMsgItemCover createView ,set null");
                                    }
                                    anyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                } else {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("[@]", 2, "StructMsgItemCover createView ,set listener");
                                    }
                                    anyScaleTypeImageView.setURLDrawableDownListener(this.X0);
                                }
                                if (z18) {
                                    anyScaleTypeImageView.setBackgroundDrawable(drawable3);
                                }
                                if (uRLDrawable == null && z18) {
                                    if (i18 == 0) {
                                        i18 = uRLDrawable.getIntrinsicWidth();
                                    }
                                    int i19 = i18;
                                    uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(i19, i19, i19));
                                    uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                                    anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                                    if (uRLDrawable.getStatus() != 1) {
                                        uRLDrawable.restartDownload();
                                    }
                                } else {
                                    anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                                }
                                view3 = view4;
                            }
                            i16 = f17;
                            URLDrawable drawable42 = URLDrawable.getDrawable(url, i16, i16, drawable, drawable, true);
                            anyScaleTypeImageView = fixRatioPAHighLightImageView;
                            obj = "";
                            i18 = i16;
                            drawable3 = null;
                            uRLDrawable = drawable42;
                            view4 = view2;
                            z18 = z16;
                            if (uRLDrawable == null) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            anyScaleTypeImageView.setURLDrawableDownListener(this.X0);
                            if (z18) {
                            }
                            if (uRLDrawable == null) {
                            }
                            anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                            view3 = view4;
                        }
                    }
                    if (str7.startsWith(ITroopAvatarUtilApi.REGEXP_URL_STRING)) {
                        String str8 = str7.substring(str7.lastIndexOf("gh/") + 3).split("/")[0];
                        if (!TextUtils.isEmpty(str8)) {
                            Context context3 = view2.getContext();
                            if (context3 instanceof BaseActivity) {
                                QQAppInterface qQAppInterface2 = ((BaseActivity) context3).app;
                                Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(4, 3);
                                fixRatioPAHighLightImageView.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface2, 4, str8, 3, defaultDrawable, defaultDrawable));
                            } else {
                                fixRatioPAHighLightImageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable140_140());
                            }
                            return view2;
                        }
                    } else {
                        if (!str7.startsWith(ff0.a.E) && !str7.startsWith(ff0.a.F)) {
                            try {
                                if (!str7.startsWith(ff0.a.G)) {
                                    if (str7.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, 73))) {
                                        ColorDrawable colorDrawable = new ColorDrawable(0);
                                        fixRatioPAHighLightImageView.setImageDrawable(URLDrawable.getDrawable(str7, colorDrawable, colorDrawable));
                                        return view2;
                                    }
                                    if (!str7.startsWith("http://imgplat.store.qq.com/bqq_qfpic/520520") && !str7.contains(SubscribeShareHelper.f96434j)) {
                                        String str9 = this.T0;
                                        if (str9 != null && str9.equals("1")) {
                                            this.R0 = true;
                                            str3 = str7;
                                            z18 = true;
                                            messageRecord2 = null;
                                            i3 = this.W0;
                                            if (i3 != Y0) {
                                            }
                                            i18 = f16;
                                            if (z17) {
                                            }
                                            anyScaleTypeImageView = fixRatioPAHighLightImageView;
                                            view4 = view2;
                                            Drawable drawable5 = drawable;
                                            obj = "";
                                            Drawable drawable6 = drawable;
                                            str = "StructMsgItemCover";
                                            drawable2 = drawable;
                                            drawable3 = null;
                                            uRLDrawable = q(str3, i18, i18, drawable5, drawable6, true, true, messageRecord2);
                                            if (uRLDrawable.getTag() == null) {
                                            }
                                            uRLDrawable.setAutoDownload(true);
                                            if (uRLDrawable.getStatus() == 2) {
                                            }
                                            if (uRLDrawable == null) {
                                            }
                                            if (QLog.isColorLevel()) {
                                            }
                                            anyScaleTypeImageView.setURLDrawableDownListener(this.X0);
                                            if (z18) {
                                            }
                                            if (uRLDrawable == null) {
                                            }
                                            anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                                            view3 = view4;
                                        } else {
                                            if (str7.startsWith("http://qqpublic.qpic.cn")) {
                                                try {
                                                    if (new URL(str7).getQuery() != null) {
                                                        str4 = "&spec=screen";
                                                        int i26 = this.W0;
                                                        if (i26 == Y0) {
                                                            str4 = "&spec=small";
                                                        } else if (i26 == Z0) {
                                                            str4 = "&spec=middle";
                                                        }
                                                    } else {
                                                        str4 = "?spec=screen";
                                                        int i27 = this.W0;
                                                        if (i27 == Y0) {
                                                            str4 = "?spec=small";
                                                        } else if (i27 == Z0) {
                                                            str4 = "?spec=middle";
                                                        }
                                                    }
                                                    str7 = str7 + str4;
                                                    AbsStructMsg absStructMsg = this.P0;
                                                    if (absStructMsg != null) {
                                                        messageRecord = absStructMsg.message;
                                                    }
                                                    messageRecord = null;
                                                } catch (MalformedURLException unused2) {
                                                    throw new IllegalArgumentException("illegal url format: " + str7);
                                                }
                                            } else {
                                                AbsStructMsg absStructMsg2 = this.P0;
                                                if (absStructMsg2 != null) {
                                                    messageRecord = absStructMsg2.message;
                                                    if (messageRecord != null) {
                                                    }
                                                }
                                            }
                                            messageRecord2 = messageRecord;
                                            str3 = str7;
                                            z18 = z16;
                                            i3 = this.W0;
                                            if (i3 != Y0) {
                                                fixRatioPAHighLightImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                f16 = BaseAIOUtils.f(70.0f, resources);
                                            } else if (i3 == Z0) {
                                                fixRatioPAHighLightImageView.setScaleType(ImageView.ScaleType.CENTER);
                                                f16 = BaseAIOUtils.f(140.0f, resources);
                                            } else {
                                                fixRatioPAHighLightImageView.setScaleType(ImageView.ScaleType.CENTER);
                                                if (z17) {
                                                    fixRatioPAHighLightImageView.setBackgroundColor(Color.parseColor(str2));
                                                } else {
                                                    fixRatioPAHighLightImageView.setBackgroundColor(Color.parseColor("#dddfe4"));
                                                }
                                                anyScaleTypeImageView = fixRatioPAHighLightImageView;
                                                view4 = view2;
                                                Drawable drawable52 = drawable;
                                                obj = "";
                                                Drawable drawable62 = drawable;
                                                str = "StructMsgItemCover";
                                                drawable2 = drawable;
                                                drawable3 = null;
                                                uRLDrawable = q(str3, i18, i18, drawable52, drawable62, true, true, messageRecord2);
                                                if (uRLDrawable.getTag() == null) {
                                                    uRLDrawable.setTag(0);
                                                }
                                                uRLDrawable.setAutoDownload(true);
                                                if (uRLDrawable.getStatus() == 2) {
                                                    uRLDrawable.restartDownload();
                                                }
                                                if (uRLDrawable == null) {
                                                }
                                                if (QLog.isColorLevel()) {
                                                }
                                                anyScaleTypeImageView.setURLDrawableDownListener(this.X0);
                                                if (z18) {
                                                }
                                                if (uRLDrawable == null) {
                                                }
                                                anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                                                view3 = view4;
                                            }
                                            i18 = f16;
                                            if (z17) {
                                            }
                                            anyScaleTypeImageView = fixRatioPAHighLightImageView;
                                            view4 = view2;
                                            Drawable drawable522 = drawable;
                                            obj = "";
                                            Drawable drawable622 = drawable;
                                            str = "StructMsgItemCover";
                                            drawable2 = drawable;
                                            drawable3 = null;
                                            uRLDrawable = q(str3, i18, i18, drawable522, drawable622, true, true, messageRecord2);
                                            if (uRLDrawable.getTag() == null) {
                                            }
                                            uRLDrawable.setAutoDownload(true);
                                            if (uRLDrawable.getStatus() == 2) {
                                            }
                                            if (uRLDrawable == null) {
                                            }
                                            if (QLog.isColorLevel()) {
                                            }
                                            anyScaleTypeImageView.setURLDrawableDownListener(this.X0);
                                            if (z18) {
                                            }
                                            if (uRLDrawable == null) {
                                            }
                                            anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                                            view3 = view4;
                                        }
                                    }
                                    this.R0 = true;
                                    str3 = str7;
                                    z18 = true;
                                    messageRecord2 = null;
                                    i3 = this.W0;
                                    if (i3 != Y0) {
                                    }
                                    i18 = f16;
                                    if (z17) {
                                    }
                                    anyScaleTypeImageView = fixRatioPAHighLightImageView;
                                    view4 = view2;
                                    Drawable drawable5222 = drawable;
                                    obj = "";
                                    Drawable drawable6222 = drawable;
                                    str = "StructMsgItemCover";
                                    drawable2 = drawable;
                                    drawable3 = null;
                                    uRLDrawable = q(str3, i18, i18, drawable5222, drawable6222, true, true, messageRecord2);
                                    if (uRLDrawable.getTag() == null) {
                                    }
                                    uRLDrawable.setAutoDownload(true);
                                    if (uRLDrawable.getStatus() == 2) {
                                    }
                                    if (uRLDrawable == null) {
                                    }
                                    if (QLog.isColorLevel()) {
                                    }
                                    anyScaleTypeImageView.setURLDrawableDownListener(this.X0);
                                    if (z18) {
                                    }
                                    if (uRLDrawable == null) {
                                    }
                                    anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                                    view3 = view4;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                anyScaleTypeImageView = fixRatioPAHighLightImageView;
                                obj = "";
                                str = "StructMsgItemCover";
                                drawable2 = drawable;
                                view3 = view2;
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("StructMsgItemCover createView ,exception  = ");
                                    sb5.append(e);
                                    QLog.d(str, 2, sb5.toString() != null ? e.getMessage() : " happens error ");
                                }
                                anyScaleTypeImageView.setImageDrawable(drawable2);
                                str6 = this.f290329i;
                                if (str6 != null) {
                                    view3.setClickable(true);
                                    view3.setOnClickListener(this);
                                }
                                if (QLog.isColorLevel()) {
                                }
                                return view3;
                            }
                        }
                        anyScaleTypeImageView = fixRatioPAHighLightImageView;
                        view3 = view2;
                        obj = "";
                        str = "StructMsgItemCover";
                        drawable2 = drawable;
                        try {
                            anyScaleTypeImageView.setBackgroundDrawable(null);
                            String substring2 = str7.substring(str7.lastIndexOf("&uin=") + 5);
                            Context context4 = view3.getContext();
                            if (context4 instanceof BaseActivity) {
                                anyScaleTypeImageView.setImageDrawable(((BaseActivity) context4).app.getFaceDrawable(substring2, false, (byte) 4));
                            } else {
                                anyScaleTypeImageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable140_140());
                            }
                            return view3;
                        } catch (Exception e19) {
                            e = e19;
                            if (QLog.isColorLevel()) {
                            }
                            anyScaleTypeImageView.setImageDrawable(drawable2);
                            str6 = this.f290329i;
                            if (str6 != null) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            return view3;
                        }
                    }
                    uRLDrawable = q(str3, i18, i18, drawable5222, drawable6222, true, true, messageRecord2);
                    if (uRLDrawable.getTag() == null) {
                    }
                    uRLDrawable.setAutoDownload(true);
                    if (uRLDrawable.getStatus() == 2) {
                    }
                    if (uRLDrawable == null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    anyScaleTypeImageView.setURLDrawableDownListener(this.X0);
                    if (z18) {
                    }
                    if (uRLDrawable == null) {
                    }
                    anyScaleTypeImageView.setImageDrawable(uRLDrawable);
                    view3 = view4;
                } catch (Exception e26) {
                    e = e26;
                    view3 = view4;
                    if (QLog.isColorLevel()) {
                    }
                    anyScaleTypeImageView.setImageDrawable(drawable2);
                    str6 = this.f290329i;
                    if (str6 != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return view3;
                }
                z18 = z16;
                str3 = str7;
                messageRecord2 = null;
                i3 = this.W0;
                if (i3 != Y0) {
                }
                i18 = f16;
                if (z17) {
                }
                anyScaleTypeImageView = fixRatioPAHighLightImageView;
                view4 = view2;
                Drawable drawable52222 = drawable;
                obj = "";
                Drawable drawable62222 = drawable;
                str = "StructMsgItemCover";
                drawable2 = drawable;
                drawable3 = null;
            } catch (Exception e27) {
                e = e27;
                anyScaleTypeImageView = fixRatioPAHighLightImageView;
                view3 = view2;
                obj = "";
                str = "StructMsgItemCover";
                drawable2 = drawable;
                if (QLog.isColorLevel()) {
                }
                anyScaleTypeImageView.setImageDrawable(drawable2);
                str6 = this.f290329i;
                if (str6 != null) {
                }
                if (QLog.isColorLevel()) {
                }
                return view3;
            }
        }
        str6 = this.f290329i;
        if (str6 != null && !str6.equals(obj)) {
            view3.setClickable(true);
            view3.setOnClickListener(this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("[@]", 2, "StructMsgItemCover createView end!");
        }
        return view3;
    }

    StructMsgForGeneralShare p(View view) {
        ViewParent parent = view.getParent();
        while (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.getId() == R.id.j59) {
                return (StructMsgForGeneralShare) viewGroup.getTag(R.id.j59);
            }
            parent = viewGroup.getParent();
        }
        return null;
    }

    public c(String str) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.S0 = str;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
    }

    public c(String str, String str2) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else {
            this.S0 = str;
            this.T0 = str2;
        }
    }
}
