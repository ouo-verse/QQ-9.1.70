package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class al extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public String R0;
    private String S0;
    private String T0;
    public View.OnClickListener U0;
    private URLDrawableDownListener.Adapter V0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatMessage chatMessage;
            String str;
            String str2;
            QQAppInterface ph5;
            MessageRecord messageRecord;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Context context = view.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("file_send_path", al.this.S0);
                bundle.putInt(ShortVideoConstants.VIDEO_PLAY_CALLER, 2);
                bundle.putLong(ShortVideoConstants.MESSAGE_CLICK_START, System.currentTimeMillis());
                try {
                    chatMessage = com.tencent.mobileqq.activity.aio.l.C(view);
                } catch (ClassCastException unused) {
                    chatMessage = null;
                }
                if (chatMessage == null) {
                    str = "";
                } else {
                    str = chatMessage.getExtInfoFromExtStr("gdt_msgClick");
                }
                bundle.putString("ad_gdt", str);
                StructMsgForGeneralShare o16 = al.this.o(view);
                if (o16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("structmsg.StructMsgItemVideoForPA", 2, "StructMsgForGeneralShare == NULL");
                    }
                } else {
                    bundle.putString("msg_id", String.valueOf(o16.msgId));
                    if (al.this.T0 != null && !al.this.T0.equals("")) {
                        bundle.putString(ShortVideoConstants.STRUCT_MSG_VIDEO_INFO, al.this.T0);
                        bundle.putString(ShortVideoConstants.FROM_UIN, o16.currentAccountUin);
                        bundle.putInt(ShortVideoConstants.FROM_UIN_TYPE, 1008);
                        bundle.putString(ShortVideoConstants.FROM_SESSION_UIN, o16.uin);
                        try {
                            str2 = new JSONObject(al.this.T0).getString(ShortVideoConstants.FILE_UUID);
                        } catch (Exception unused2) {
                        }
                        Intent intent = new Intent(context, (Class<?>) ShortVideoPlayActivity.class);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                        ph5 = ((BaseActivity) context).getChatFragment().ph();
                        ReportController.n(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005C9A", "0X8005C9A", 0, 1, 0, o16.uin, o16.currentAccountUin, al.this.S0, str2);
                        messageRecord = o16.message;
                        if (messageRecord != null && "1".equals(messageRecord.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, o16.message.frienduin);
                                jSONObject.put("type", al.this.J);
                                jSONObject.put("index", al.this.H);
                                jSONObject.put("name", al.this.I);
                                jSONObject.put("net", String.valueOf(HttpUtil.getNetWorkType()));
                                jSONObject.put("mobile_imei", com.tencent.mobileqq.utils.ah.z());
                                jSONObject.put("obj", "");
                                jSONObject.put("gdt_cli_data", o16.message.getExtInfoFromExtStr("gdt_msgClick"));
                                jSONObject.put("view_id", o16.message.getExtInfoFromExtStr("gdt_view_id"));
                                ((IPAReportUtil) QRoute.api(IPAReportUtil.class)).reportClickEventForAdver(ph5, o16.message.selfuin, jSONObject.toString(), "" + o16.msgId);
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    str2 = "";
                    Intent intent2 = new Intent(context, (Class<?>) ShortVideoPlayActivity.class);
                    intent2.putExtras(bundle);
                    context.startActivity(intent2);
                    ph5 = ((BaseActivity) context).getChatFragment().ph();
                    ReportController.n(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005C9A", "0X8005C9A", 0, 1, 0, o16.uin, o16.currentAccountUin, al.this.S0, str2);
                    messageRecord = o16.message;
                    if (messageRecord != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(IPublicAccountBrowser.KEY_PUB_UIN, o16.message.frienduin);
                        jSONObject2.put("type", al.this.J);
                        jSONObject2.put("index", al.this.H);
                        jSONObject2.put("name", al.this.I);
                        jSONObject2.put("net", String.valueOf(HttpUtil.getNetWorkType()));
                        jSONObject2.put("mobile_imei", com.tencent.mobileqq.utils.ah.z());
                        jSONObject2.put("obj", "");
                        jSONObject2.put("gdt_cli_data", o16.message.getExtInfoFromExtStr("gdt_msgClick"));
                        jSONObject2.put("view_id", o16.message.getExtInfoFromExtStr("gdt_view_id"));
                        ((IPAReportUtil) QRoute.api(IPAReportUtil.class)).reportClickEventForAdver(ph5, o16.message.selfuin, jSONObject2.toString(), "" + o16.msgId);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
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
                QLog.d("structmsg.StructMsgItemVideoForPA", 2, "onLoadCancelled");
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
                QLog.d("structmsg.StructMsgItemVideoForPA", 2, "onLoadFailed ,cause = " + th5);
            }
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
                QLog.d("structmsg.StructMsgItemVideoForPA", 2, "onLoadInterrupted");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            view.setBackgroundDrawable(uRLDrawable);
            if (QLog.isColorLevel()) {
                QLog.d("structmsg.StructMsgItemVideoForPA", 2, "onLoadSuccessed");
            }
        }
    }

    public al() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.R0 = null;
        this.S0 = null;
        this.T0 = null;
        this.U0 = new a();
        this.V0 = new b();
        this.f290322e = "pavideo";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        PAHighLightImageView pAHighLightImageView;
        Drawable drawable;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        int i3 = resources.getDisplayMetrics().widthPixels;
        if (view != null && (view instanceof AnyScaleTypeImageView)) {
            pAHighLightImageView = (PAHighLightImageView) view;
        } else {
            pAHighLightImageView = new PAHighLightImageView(context);
            pAHighLightImageView.setId(R.id.dgb);
            pAHighLightImageView.setContentDescription(resources.getString(R.string.cli));
            pAHighLightImageView.setDisplayRuleDef(com.tencent.mobileqq.widget.e.f316872a);
            pAHighLightImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            pAHighLightImageView.setContentDescription(resources.getText(R.string.hqr));
        }
        pAHighLightImageView.setTag(this);
        try {
            drawable = resources.getDrawable(R.drawable.d86);
        } catch (OutOfMemoryError unused) {
            drawable = null;
        }
        if (TextUtils.isEmpty(this.R0)) {
            pAHighLightImageView.setBackgroundDrawable(drawable);
        } else {
            URLDrawable drawable2 = URLDrawable.getDrawable(this.R0, i3, i3, drawable, drawable);
            if (!AbsDownloader.hasFile(this.R0) && URLDrawableHelper.isMobileNetAndAutodownDisabled(context)) {
                z16 = false;
            } else {
                z16 = true;
            }
            drawable2.setAutoDownload(z16);
            if (drawable2.getStatus() == 1) {
                pAHighLightImageView.setBackgroundDrawable(null);
            } else {
                pAHighLightImageView.setURLDrawableDownListener(this.V0);
                pAHighLightImageView.setBackgroundColor(15790320);
            }
            pAHighLightImageView.setBackgroundDrawable(drawable2);
        }
        WeakReference<com.tencent.mobileqq.activity.aio.an> weakReference = this.O0;
        if (weakReference != null) {
            pAHighLightImageView.setOnLongClickListener(weakReference.get());
            pAHighLightImageView.setOnTouchListener(this.O0.get());
        }
        pAHighLightImageView.setOnClickListener(this.U0);
        return pAHighLightImageView;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.R0 = jVar.a("cover");
        this.S0 = jVar.a("src");
        if (this.f290320d > 5) {
            this.T0 = jVar.a("video_info");
            this.H = jVar.a("index");
            this.I = jVar.a("index_name");
            this.J = jVar.a("index_type");
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "pavideo";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.R0 = objectInput.readUTF();
        this.S0 = objectInput.readUTF();
        if (this.f290320d > 5) {
            this.T0 = objectInput.readUTF();
            this.H = objectInput.readUTF();
            this.I = objectInput.readUTF();
            this.J = objectInput.readUTF();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "pavideo");
        xmlSerializer.attribute(null, "cover", this.R0);
        xmlSerializer.attribute(null, "src", this.S0);
        if (this.f290320d > 5) {
            xmlSerializer.attribute(null, "video_info", this.T0);
            if (!TextUtils.isEmpty(this.H)) {
                xmlSerializer.attribute(null, "index", this.H);
            }
            if (!TextUtils.isEmpty(this.I)) {
                xmlSerializer.attribute(null, "index_name", this.I);
            }
            if (!TextUtils.isEmpty(this.J)) {
                xmlSerializer.attribute(null, "index_type", this.J);
            }
        }
        xmlSerializer.endTag(null, "pavideo");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectOutput);
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
        if (this.f290320d > 5) {
            String str4 = this.T0;
            if (str4 == null) {
                str4 = "";
            }
            objectOutput.writeUTF(str4);
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
            if (str7 != null) {
                str2 = str7;
            }
            objectOutput.writeUTF(str2);
        }
    }

    StructMsgForGeneralShare o(View view) {
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
}
