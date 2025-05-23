package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xc3.submsgtype0xc3$MsgBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e implements f, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f180109d;

    /* renamed from: e, reason: collision with root package name */
    private Context f180110e;

    /* renamed from: f, reason: collision with root package name */
    private p f180111f;

    /* renamed from: h, reason: collision with root package name */
    private MqqHandler f180112h;

    /* renamed from: i, reason: collision with root package name */
    private a f180113i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        JSONObject f180114a;

        /* renamed from: b, reason: collision with root package name */
        int f180115b;

        /* renamed from: c, reason: collision with root package name */
        int f180116c;

        /* renamed from: d, reason: collision with root package name */
        long f180117d;

        /* renamed from: e, reason: collision with root package name */
        String f180118e;

        /* renamed from: f, reason: collision with root package name */
        String f180119f;

        /* renamed from: g, reason: collision with root package name */
        String f180120g;

        /* renamed from: h, reason: collision with root package name */
        long f180121h;

        /* renamed from: i, reason: collision with root package name */
        long f180122i;

        /* renamed from: j, reason: collision with root package name */
        protected int f180123j;

        /* renamed from: k, reason: collision with root package name */
        int f180124k;

        /* renamed from: l, reason: collision with root package name */
        int f180125l;

        /* renamed from: m, reason: collision with root package name */
        String f180126m;

        /* renamed from: n, reason: collision with root package name */
        public long f180127n;

        public a(JSONObject jSONObject) {
            this.f180116c = 0;
            this.f180124k = 0;
            this.f180125l = 0;
            this.f180114a = jSONObject;
            if (jSONObject != null) {
                this.f180117d = jSONObject.optLong(IPublicAccountBrowser.KEY_PUB_UIN);
                this.f180115b = jSONObject.optInt("type");
                this.f180116c = jSONObject.optInt("show_tab");
                this.f180118e = jSONObject.optString("content");
                this.f180119f = jSONObject.optString("icon");
                this.f180120g = jSONObject.optString("url");
                this.f180121h = jSONObject.optLong("begin");
                this.f180122i = jSONObject.optLong("end");
                this.f180126m = jSONObject.optString("shool_id");
                this.f180123j = jSONObject.optInt(Element.ELEMENT_NAME_TIMES);
                this.f180127n = jSONObject.optLong("msg_seqno");
                this.f180127n = jSONObject.optLong("msg_seqno");
                this.f180124k = jSONObject.optInt("tid");
                this.f180125l = jSONObject.optInt("clicked");
            }
        }

        public boolean a() {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
            if (serverTimeMillis >= this.f180121h && serverTimeMillis <= this.f180122i) {
                return false;
            }
            return true;
        }

        boolean b() {
            if (this.f180117d > 0 && this.f180123j >= 0) {
                return true;
            }
            return false;
        }
    }

    public static a b(QQAppInterface qQAppInterface, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = qQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PubAccountTips", 2, "getLastPATipsMsg getSharedPreferences error: ", e16);
            }
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString("selfuin_" + qQAppInterface.getCurrentAccountUin() + "_puin_" + str + "_msgdata", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new a(new JSONObject(string));
        } catch (JSONException e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("PubAccountTips", 2, "getLastPATipsMsg JSONException:", e17);
            return null;
        }
    }

    public static void c(QQAppInterface qQAppInterface, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            submsgtype0xc3$MsgBody mergeFrom = new submsgtype0xc3$MsgBody().mergeFrom(bArr);
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountTips", 2, "Parsing Msg0x210Sub0xc3 data. type:" + mergeFrom.uint32_type.get() + ", push_data:" + mergeFrom.bytes_push_data.get() + ", timestamp:" + mergeFrom.uint64_timestamp.get());
            }
            if (mergeFrom.uint32_type.has() && mergeFrom.bytes_push_data.has() && mergeFrom.uint32_type.get() == 1) {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(mergeFrom.bytes_push_data.get().toByteArray(), "UTF-8"));
                        a aVar = new a(jSONObject);
                        if (aVar.b()) {
                            if (aVar.f180116c == 1) {
                                MessageForStructing messageForStructing = (MessageForStructing) q.d(MessageRecord.MSG_TYPE_STRUCT_MSG);
                                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                                String str = "" + aVar.f180117d;
                                String str2 = aVar.f180118e;
                                messageForStructing.init(currentAccountUin, str, str, str2, 0L, MessageRecord.MSG_TYPE_STRUCT_MSG, 1008, 0L);
                                StructMsgForGeneralShare b16 = i.b();
                                b16.mMsgBrief = str2;
                                b16.mMsgUrl = aVar.f180120g;
                                b16.mMsgServiceID = 85;
                                messageForStructing.structingMsg = b16;
                                messageForStructing.saveExtInfoToExtStr("public_account_msg_extra_info_type", "1");
                                qQAppInterface.getMessageFacade().d(messageForStructing, currentAccountUin, true, true, true, false);
                                jSONObject.put("msg_seqno", messageForStructing.uniseq);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("PubAccountTips", 2, "Msg0x210Sub0xc3 .type:" + aVar.f180115b + ", push_data:" + jSONObject.toString());
                            }
                            if (qQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0) != null) {
                                d(qQAppInterface, "" + aVar.f180117d, b(qQAppInterface, "" + aVar.f180117d), jSONObject.toString());
                                MqqHandler handler = qQAppInterface.getHandler(ChatActivity.class);
                                if (handler != null) {
                                    handler.sendEmptyMessage(38);
                                }
                            }
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                } catch (UnsupportedEncodingException e17) {
                    e17.printStackTrace();
                }
            }
        } catch (InvalidProtocolBufferMicroException e18) {
            e18.printStackTrace();
        }
    }

    public static void d(QQAppInterface qQAppInterface, String str, a aVar, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("PubAccountTips", 2, "refreshLocalTips. puin:" + str + " ,pushData:" + str2);
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
        if (aVar != null) {
            qQAppInterface.getMessageFacade().V1(str, 1008, aVar.f180127n, true);
            if (QLog.isColorLevel()) {
                QLog.i("PubAccountTips", 2, "removeMsgByUniseq. uniqSeqno:" + aVar.f180127n);
            }
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str3 = "selfuin_" + qQAppInterface.getCurrentAccountUin() + "_puin_" + str + "_msgdata";
        if (str2 != null) {
            edit.putString(str3, str2);
        } else {
            edit.remove(str3);
        }
        edit.commit();
    }

    @Override // com.tencent.mobileqq.activity.aio.tips.f
    public View a(Object... objArr) {
        View inflate = LayoutInflater.from(this.f180110e).inflate(R.layout.a48, (ViewGroup) null);
        a aVar = this.f180113i;
        if (aVar != null) {
            int i3 = aVar.f180115b;
            if (i3 == 1) {
                inflate.setBackgroundResource(R.color.f157399of);
            } else if (i3 == 2) {
                inflate.setBackgroundResource(R.color.f157400og);
            }
            ((TextView) inflate.findViewById(R.id.f164236o4)).setText(this.f180113i.f180118e);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f164232o0);
            String str = this.f180113i.f180119f;
            if (!TextUtils.isEmpty(str)) {
                imageView.setImageDrawable(URLDrawableHelper.getDrawable(str, (Drawable) null, (Drawable) null));
            } else {
                imageView.setVisibility(8);
            }
        }
        inflate.setOnClickListener(this);
        return inflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f180111f.f179555d == 1008 && (aVar = this.f180113i) != null && !TextUtils.isEmpty(aVar.f180120g)) {
            SharedPreferences sharedPreferences = this.f180109d.getApp().getSharedPreferences("push_campus_tips", 0);
            if (sharedPreferences != null) {
                String str = "selfuin_" + this.f180109d.getCurrentAccountUin() + "_puin_" + this.f180111f.f179557e + "_msgdata";
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountTips", 2, "clickedTimes:" + (this.f180113i.f180125l + 1));
                }
                a aVar2 = this.f180113i;
                int i3 = aVar2.f180125l + 1;
                aVar2.f180125l = i3;
                if (i3 >= aVar2.f180123j) {
                    d(this.f180109d, "" + this.f180113i.f180117d, this.f180113i, null);
                    this.f180112h.sendEmptyMessageDelayed(28, 2000L);
                } else {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    try {
                        a aVar3 = this.f180113i;
                        aVar3.f180114a.put("clicked", aVar3.f180125l);
                        edit.putString(str, this.f180113i.f180114a.toString()).commit();
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            Intent intent = new Intent(this.f180110e, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.f180113i.f180120g);
            this.f180110e.startActivity(intent);
            ReportController.o(this.f180109d, "P_CliOper", "Vip_pay_mywallet", "", "school", "school.aio.tips.click", 0, 0, "" + this.f180113i.f180124k, "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
