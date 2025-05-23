package com.tencent.mqp.app.sec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.bankcode_info$BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info$BankcodeElem;
import com.tencent.ims.bankcode_info$ElemPos;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.SafeMsg$SafeMoreInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* loaded from: classes21.dex */
public class MQPSensitiveMsgUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f336105a;

    /* renamed from: b, reason: collision with root package name */
    private static Bundle f336106b;

    /* renamed from: c, reason: collision with root package name */
    private static String f336107c;

    /* renamed from: d, reason: collision with root package name */
    private static MQPSensitiveMsgUtil f336108d;

    /* renamed from: e, reason: collision with root package name */
    private static BroadcastReceiver f336109e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f336118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f336119e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f336120f;

        a(String str, int i3, int i16) {
            this.f336118d = str;
            this.f336119e = i3;
            this.f336120f = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ReportController.o(null, "P_CliOper", "Safe_SensMsg", this.f336118d, "Alert_Dialog", "Cancel", this.f336119e, this.f336120f, "", "", "", "");
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes21.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (action != null && action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && intent.getIntExtra("type", 0) != 0) {
                MQPSensitiveMsgUtil.f336107c = intent.getStringExtra("account");
                MQPSensitiveMsgUtil.n(MQPSensitiveMsgUtil.f336107c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f336121d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f336122e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f336123f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ bankcode_info$BankcodeCtrlInfo f336124h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f336125i;

        c(String str, int i3, long j3, bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo, boolean z16) {
            this.f336121d = str;
            this.f336122e = i3;
            this.f336123f = j3;
            this.f336124h = bankcode_info_bankcodectrlinfo;
            this.f336125i = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Long.valueOf(j3), bankcode_info_bankcodectrlinfo, Boolean.valueOf(z16));
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            boolean z16;
            Bundle bundle;
            QQMessageFacade qQMessageFacade;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            int i16 = 0;
            if (waitAppRuntime != null && (qQMessageFacade = (QQMessageFacade) waitAppRuntime.getManager(QQManagerFactory.MGR_MSG_FACADE)) != null) {
                MessageRecord P = qQMessageFacade.P(this.f336121d, this.f336122e, this.f336123f);
                if (P == null) {
                    return;
                }
                String extInfoFromExtStr = P.getExtInfoFromExtStr("sens_msg_attr");
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    try {
                        i16 = Integer.parseInt(extInfoFromExtStr);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } else if (this.f336124h.bankcode_elems.has()) {
                    int i17 = 0;
                    for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem : this.f336124h.bankcode_elems.get()) {
                        if (bankcode_info_bankcodeelem.bankcode_attr.has()) {
                            i3 = bankcode_info_bankcodeelem.bankcode_attr.get();
                        } else {
                            i3 = 0;
                        }
                        if (i3 > i17) {
                            i17 = i3;
                        }
                    }
                    i16 = i17;
                }
                String extInfoFromExtStr2 = P.getExtInfoFromExtStr("sens_msg_need_mask");
                if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                    z16 = Boolean.parseBoolean(extInfoFromExtStr2);
                    if (!this.f336125i || !z16 || (bundle = (Bundle) AntiFraudConfigFileUtil.n().p("SensMsgTipsCfg", Action.TAG, 1, i16)) == null) {
                        return;
                    }
                    Iterator<String> it = bundle.keySet().iterator();
                    while (it.hasNext()) {
                        Bundle bundle2 = bundle.getBundle(it.next());
                        if (bundle2 != null && bundle2.getString("Type").compareToIgnoreCase("showAlert") == 0) {
                            MQPSensitiveMsgUtil.p(this.f336121d, this.f336122e, this.f336123f, bundle2.getString("AlertTitle"), bundle2.getString("AlertText"), bundle2.getString("AlertOtherBtnText"), bundle2.getString("AlertCancelBtnText"));
                        }
                    }
                    return;
                }
            }
            z16 = true;
            if (!this.f336125i) {
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                textPaint.setUnderlineText(true);
                textPaint.setColor(-12541697);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77434);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f336105a = 0;
        f336106b = new Bundle();
        f336107c = "0";
        f336108d = null;
        f336109e = new b();
    }

    public MQPSensitiveMsgUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int f(String str, int i3) {
        int i16;
        if (i3 > 0) {
            i16 = i3;
        } else {
            i16 = 0;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            try {
                int codePointAt = str.codePointAt(i17);
                if (codePointAt == 20 || (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) >= 0 && codePointAt > 65535)) {
                    i16++;
                }
            } catch (Exception unused) {
            }
        }
        return i16;
    }

    public static MQPSensitiveMsgUtil g() {
        if (f336108d == null) {
            f336108d = new MQPSensitiveMsgUtil();
            i();
        }
        return f336108d;
    }

    private static Object h(String str, int i3, long j3, boolean z16, bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo) {
        return new c(str, i3, j3, bankcode_info_bankcodectrlinfo, z16);
    }

    private static void i() {
        BaseApplication.getContext().registerReceiver(f336109e, new IntentFilter(NewIntent.ACTION_ACCOUNT_CHANGED));
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && waitAppRuntime.isLogin()) {
            n(waitAppRuntime.getAccount());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(MessageRecord messageRecord, List<MessageRecord> list, boolean z16, byte[] bArr) {
        bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo;
        int i3;
        bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo2;
        int i16;
        List<bankcode_info$BankcodeElem> list2;
        int i17;
        boolean z17;
        boolean z18;
        boolean z19;
        List<bankcode_info$BankcodeElem> list3;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int f16;
        int i36;
        List<bankcode_info$BankcodeElem> list4;
        String str;
        int i37;
        String str2;
        int i38;
        String str3;
        int i39;
        List<bankcode_info$BankcodeElem> list5;
        try {
            bankcode_info_bankcodectrlinfo = new bankcode_info$BankcodeCtrlInfo();
            try {
                bankcode_info_bankcodectrlinfo.mergeFrom(bArr);
                if (bankcode_info_bankcodectrlinfo.msgtail_id.has()) {
                    i3 = bankcode_info_bankcodectrlinfo.msgtail_id.get();
                } else {
                    i3 = 0;
                }
                try {
                    if (bankcode_info_bankcodectrlinfo.bankcode_elems.has()) {
                        list5 = bankcode_info_bankcodectrlinfo.bankcode_elems.get();
                    } else {
                        list5 = null;
                    }
                    bankcode_info_bankcodectrlinfo2 = bankcode_info_bankcodectrlinfo;
                    i16 = i3;
                    list2 = list5;
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    bankcode_info_bankcodectrlinfo2 = bankcode_info_bankcodectrlinfo;
                    i16 = i3;
                    list2 = null;
                    if (list2 == null) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                i3 = 0;
                e.printStackTrace();
                bankcode_info_bankcodectrlinfo2 = bankcode_info_bankcodectrlinfo;
                i16 = i3;
                list2 = null;
                if (list2 == null) {
                }
            }
        } catch (Exception e18) {
            e = e18;
            bankcode_info_bankcodectrlinfo = null;
        }
        if (list2 == null) {
            return;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("sens_msg_attr");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                i17 = Integer.parseInt(extInfoFromExtStr);
            } catch (Exception e19) {
                e19.printStackTrace();
                i17 = 0;
            }
        } else {
            i17 = 0;
            for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem : list2) {
                if (bankcode_info_bankcodeelem.bankcode_attr.has()) {
                    i39 = bankcode_info_bankcodeelem.bankcode_attr.get();
                } else {
                    i39 = 0;
                }
                if (i39 > i17) {
                    i17 = i39;
                }
            }
        }
        int i46 = 1;
        if (i17 == 20) {
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("sens_msg_has_not_confirmed_msg");
            if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                try {
                    z17 = Boolean.parseBoolean(extInfoFromExtStr2);
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            } else {
                boolean z26 = false;
                for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem2 : list2) {
                    if (bankcode_info_bankcodeelem2.bankcode_attr.has()) {
                        i38 = bankcode_info_bankcodeelem2.bankcode_attr.get();
                    } else {
                        i38 = 0;
                    }
                    if (i38 == 20) {
                        if (bankcode_info_bankcodeelem2.clean_bankcode.has()) {
                            str3 = bankcode_info_bankcodeelem2.clean_bankcode.get();
                        } else {
                            str3 = null;
                        }
                        if (!TextUtils.isEmpty(str3) && !g().j(str3)) {
                            z26 = true;
                        }
                    }
                }
                z17 = z26;
            }
            if (z16 && i16 == 1 && (i17 == 30 || (i17 == 20 && z17))) {
                z18 = true;
            } else {
                z18 = false;
            }
            messageRecord.saveExtInfoToExtStr("sens_msg_need_mask", Boolean.toString(z18));
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            for (MessageRecord messageRecord2 : list) {
                if (messageRecord2 instanceof MessageForText) {
                    int i56 = i47;
                    int i57 = i56;
                    while (i56 < list2.size()) {
                        i57 = i56 + 1;
                        bankcode_info$BankcodeElem bankcode_info_bankcodeelem3 = list2.get(i56);
                        if (bankcode_info_bankcodeelem3 != null) {
                            if (bankcode_info_bankcodeelem3.bankcode_pos.has()) {
                                bankcode_info$ElemPos bankcode_info_elempos = bankcode_info_bankcodeelem3.bankcode_pos.get();
                                if (bankcode_info_elempos.start_offset.has()) {
                                    i27 = bankcode_info_elempos.start_offset.get();
                                } else {
                                    i27 = 0;
                                }
                                if (bankcode_info_elempos.end_offset.has()) {
                                    i26 = bankcode_info_elempos.end_offset.get();
                                } else {
                                    i26 = 0;
                                }
                            } else {
                                i26 = 0;
                                i27 = 0;
                            }
                            if (i26 >= i48 && i27 <= messageRecord2.f203106msg.length() + i48) {
                                if (bankcode_info_bankcodeelem3.bankcode_hidden_pos.has()) {
                                    bankcode_info$ElemPos bankcode_info_elempos2 = bankcode_info_bankcodeelem3.bankcode_hidden_pos.get();
                                    if (bankcode_info_elempos2.start_offset.has()) {
                                        i28 = bankcode_info_elempos2.start_offset.get();
                                    } else {
                                        i28 = 0;
                                    }
                                    if (bankcode_info_elempos2.end_offset.has()) {
                                        i29 = bankcode_info_elempos2.end_offset.get();
                                        f16 = f(messageRecord2.f203106msg, (i27 + i49) - i48);
                                        int f17 = f(messageRecord2.f203106msg, (i26 + i49) - i48);
                                        int i58 = i28 + f16;
                                        int i59 = i29 + f16;
                                        if (f16 >= messageRecord2.f203106msg.length() && (i36 = f17 + i46) <= messageRecord2.f203106msg.length()) {
                                            String substring = messageRecord2.f203106msg.substring(f16, i36);
                                            String str4 = "";
                                            String str5 = "";
                                            int i65 = 0;
                                            while (i65 < substring.length()) {
                                                char charAt = substring.charAt(i65);
                                                List<bankcode_info$BankcodeElem> list6 = list2;
                                                if (i16 != 1 || !Character.isDigit(charAt)) {
                                                    str2 = substring;
                                                    str5 = str5;
                                                } else {
                                                    StringBuilder sb5 = new StringBuilder();
                                                    str2 = substring;
                                                    sb5.append(str5);
                                                    sb5.append(charAt);
                                                    str5 = sb5.toString();
                                                }
                                                i65++;
                                                substring = str2;
                                                list2 = list6;
                                            }
                                            list4 = list2;
                                            String str6 = str5;
                                            if (!TextUtils.isEmpty(str6) || !z18) {
                                                if (bankcode_info_bankcodeelem3.clean_bankcode.has()) {
                                                    str = bankcode_info_bankcodeelem3.clean_bankcode.get();
                                                } else {
                                                    str = null;
                                                }
                                                if (z18 && TextUtils.equals(str6, str)) {
                                                    int i66 = 0;
                                                    i46 = 1;
                                                    while (true) {
                                                        i37 = i59 + 1;
                                                        if (i66 >= i37 - i58) {
                                                            break;
                                                        }
                                                        str4 = str4 + "*";
                                                        i66++;
                                                    }
                                                    MessageForText messageForText = (MessageForText) messageRecord2;
                                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(messageForText.charStr);
                                                    spannableStringBuilder.replace(i58, i37, (CharSequence) str4);
                                                    messageForText.charStr = spannableStringBuilder;
                                                    i56 = i57;
                                                    list2 = list4;
                                                }
                                            }
                                            i46 = 1;
                                            i56 = i57;
                                            list2 = list4;
                                        } else {
                                            list3 = list2;
                                            i57--;
                                            break;
                                        }
                                    }
                                } else {
                                    i28 = 0;
                                }
                                i29 = 0;
                                f16 = f(messageRecord2.f203106msg, (i27 + i49) - i48);
                                int f172 = f(messageRecord2.f203106msg, (i26 + i49) - i48);
                                int i582 = i28 + f16;
                                int i592 = i29 + f16;
                                if (f16 >= messageRecord2.f203106msg.length()) {
                                }
                                list3 = list2;
                                i57--;
                                break;
                            }
                        }
                        list4 = list2;
                        i56 = i57;
                        list2 = list4;
                    }
                    list3 = list2;
                    int i67 = i57;
                    z19 = z18;
                    i18 = i46;
                    i19 = i16;
                    m(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, z16, bankcode_info_bankcodectrlinfo2, i47, i67, (MessageForText) messageRecord2, i48 - i49);
                    String str7 = messageRecord2.f203106msg;
                    i49 += f(str7, str7.length()) - messageRecord2.f203106msg.length();
                    i48 += messageRecord2.f203106msg.length();
                    i47 = i67;
                } else {
                    z19 = z18;
                    list3 = list2;
                    i18 = i46;
                    i19 = i16;
                    i48++;
                }
                z18 = z19;
                i16 = i19;
                list2 = list3;
                i46 = i18;
            }
        }
        z17 = false;
        if (z16) {
        }
        z18 = false;
        messageRecord.saveExtInfoToExtStr("sens_msg_need_mask", Boolean.toString(z18));
        int i472 = 0;
        int i482 = 0;
        int i492 = 0;
        while (r16.hasNext()) {
        }
    }

    private static void l(SpannableStringBuilder spannableStringBuilder, int i3, int i16) {
        if (spannableStringBuilder == null) {
            return;
        }
        for (Object obj : spannableStringBuilder.getSpans(i3, i16, Object.class)) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            int spanFlags = spannableStringBuilder.getSpanFlags(obj);
            if (spanStart < i3 && spanEnd <= i16) {
                spannableStringBuilder.setSpan(obj, spanStart, i3, spanFlags);
            } else if (spanStart >= i3 && spanEnd <= i16 && !(obj instanceof EmoticonSpan)) {
                spannableStringBuilder.removeSpan(obj);
            } else if (spanStart > i3 && spanStart < i16 && spanEnd > i16) {
                spannableStringBuilder.setSpan(obj, i16, spanEnd, spanFlags);
            } else if (spanStart < i3 && spanEnd > i16) {
                spannableStringBuilder.setSpan(obj, spanStart, i3, spanFlags);
                spannableStringBuilder.setSpan(obj, i16, spanEnd, spanFlags);
            }
        }
    }

    private static void m(String str, int i3, long j3, boolean z16, bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo, int i16, int i17, MessageForText messageForText, int i18) {
        int i19;
        int i26;
        int i27;
        int i28;
        bankcode_info$ElemPos bankcode_info_elempos;
        if (bankcode_info_bankcodectrlinfo != null && bankcode_info_bankcodectrlinfo.bankcode_elems.has()) {
            if (bankcode_info_bankcodectrlinfo.msgtail_id.has()) {
                i19 = bankcode_info_bankcodectrlinfo.msgtail_id.get();
            } else {
                i19 = 0;
            }
            for (int i29 = i16; i29 < bankcode_info_bankcodectrlinfo.bankcode_elems.size() && i29 < i17; i29++) {
                bankcode_info$BankcodeElem bankcode_info_bankcodeelem = bankcode_info_bankcodectrlinfo.bankcode_elems.get(i29);
                if (bankcode_info_bankcodeelem != null) {
                    if (bankcode_info_bankcodeelem.bankcode_pos.has() && (bankcode_info_elempos = bankcode_info_bankcodeelem.bankcode_pos.get()) != null) {
                        if (bankcode_info_elempos.start_offset.has()) {
                            i27 = bankcode_info_elempos.start_offset.get();
                        } else {
                            i27 = 0;
                        }
                        if (bankcode_info_elempos.end_offset.has()) {
                            i26 = bankcode_info_elempos.end_offset.get();
                        } else {
                            i26 = 0;
                        }
                    } else {
                        i26 = 0;
                        i27 = 0;
                    }
                    if (i26 >= i18 && i27 <= messageForText.charStr.length() + i18) {
                        String extInfoFromExtStr = messageForText.getExtInfoFromExtStr("sens_msg_original_text");
                        if (TextUtils.isEmpty(extInfoFromExtStr)) {
                            extInfoFromExtStr = messageForText.charStr.toString();
                        }
                        int f16 = f(extInfoFromExtStr, i27 - i18);
                        int f17 = f(extInfoFromExtStr, i26 - i18);
                        int i36 = f16;
                        do {
                            if (i19 == 1 && !Character.isDigit(messageForText.charStr.charAt(i36))) {
                                break;
                            } else {
                                i36--;
                            }
                        } while (i36 >= 0);
                        if (i36 < 0) {
                            i28 = 0;
                        } else {
                            i28 = i36;
                        }
                        int i37 = f17;
                        do {
                            if (i19 == 1 && !Character.isDigit(messageForText.charStr.charAt(i37))) {
                                break;
                            } else {
                                i37++;
                            }
                        } while (i37 < messageForText.charStr.length());
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(messageForText.charStr);
                        l(spannableStringBuilder, i28, i37);
                        spannableStringBuilder.setSpan(h(str, i3, j3, z16, bankcode_info_bankcodectrlinfo), f16, f17 + 1, 33);
                        messageForText.charStr = spannableStringBuilder;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(String str) {
        f336105a = 0;
        f336107c = str;
        if (!TextUtils.isEmpty(str)) {
            f336106b.putBundle(f336107c, null);
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_confirmed_sensmsg_" + MQPSensitiveMsgUtil.f336107c, 0);
                    Bundle bundle = new Bundle();
                    for (int i3 = 0; i3 < 10; i3++) {
                        String num = Integer.toString(i3);
                        if (sharedPreferences.contains(num)) {
                            String string = sharedPreferences.getString(num, null);
                            if (!TextUtils.isEmpty(string)) {
                                bundle.putString(string, num);
                            }
                        }
                    }
                    if (bundle.size() > 0) {
                        MQPSensitiveMsgUtil.f336105a = bundle.size() - 1;
                    }
                    MQPSensitiveMsgUtil.f336106b.putBundle(MQPSensitiveMsgUtil.f336107c, bundle);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(String str, int i3, long j3, String str2, String str3, String str4, String str5) {
        AppRuntime waitAppRuntime;
        QQMessageFacade qQMessageFacade;
        MessageRecord P;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if ((BaseActivity.sTopActivity instanceof MultiForwardActivity) || (waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null)) == null || (qQMessageFacade = (QQMessageFacade) waitAppRuntime.getManager(QQManagerFactory.MGR_MSG_FACADE)) == null || (P = qQMessageFacade.P(str, i3, j3)) == null) {
            return;
        }
        String extInfoFromExtStr = P.getExtInfoFromExtStr("sens_msg_ctrl_info");
        int i27 = 0;
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo = new bankcode_info$BankcodeCtrlInfo();
                bankcode_info_bankcodectrlinfo.mergeFrom(HexUtil.hexStr2Bytes(extInfoFromExtStr));
                if (bankcode_info_bankcodectrlinfo.msgtail_id.has()) {
                    i19 = bankcode_info_bankcodectrlinfo.msgtail_id.get();
                } else {
                    i19 = 0;
                }
                try {
                    if (bankcode_info_bankcodectrlinfo.bankcode_elems.has()) {
                        i16 = 0;
                        for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem : bankcode_info_bankcodectrlinfo.bankcode_elems.get()) {
                            try {
                                if (bankcode_info_bankcodeelem.bankcode_attr.has()) {
                                    i26 = bankcode_info_bankcodeelem.bankcode_attr.get();
                                } else {
                                    i26 = 0;
                                }
                                if (i26 > i16) {
                                    i16 = i26;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                i27 = i19;
                                e.printStackTrace();
                                i17 = i16;
                                i18 = i27;
                                String str6 = P.senderuin;
                                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(BaseActivity.sTopActivity, 230);
                                createCustomDialog.setTitle(str2);
                                createCustomDialog.setMessage(str3);
                                if (!TextUtils.isEmpty(str4)) {
                                }
                                if (!TextUtils.isEmpty(str5)) {
                                }
                                createCustomDialog.show();
                            }
                        }
                        i27 = i16;
                    }
                    i17 = i27;
                    i18 = i19;
                } catch (Exception e17) {
                    e = e17;
                    i16 = 0;
                }
            } catch (Exception e18) {
                e = e18;
                i16 = 0;
            }
        } else if (P instanceof MessageForSafeGrayTips) {
            MessageForSafeGrayTips messageForSafeGrayTips = (MessageForSafeGrayTips) P;
            SafeMsg$SafeMoreInfo safeMsg$SafeMoreInfo = messageForSafeGrayTips.safeInfo;
            i19 = 2;
            if (safeMsg$SafeMoreInfo != null && safeMsg$SafeMoreInfo.strMsgTxt.has()) {
                try {
                    i27 = Integer.parseInt(messageForSafeGrayTips.safeInfo.strMsgTxt.get());
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            }
            i17 = i27;
            i18 = i19;
        } else {
            i18 = 0;
            i17 = 0;
        }
        String str62 = P.senderuin;
        QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(BaseActivity.sTopActivity, 230);
        createCustomDialog2.setTitle(str2);
        createCustomDialog2.setMessage(str3);
        if (!TextUtils.isEmpty(str4)) {
            createCustomDialog2.setPositiveButton(str4, new DialogInterface.OnClickListener(str62, i18, i17, qQMessageFacade, str, i3, j3) { // from class: com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f336110d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f336111e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f336112f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ QQMessageFacade f336113h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f336114i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f336115m;

                {
                    this.f336110d = str62;
                    this.f336111e = i18;
                    this.f336112f = i17;
                    this.f336113h = qQMessageFacade;
                    this.f336114i = str;
                    this.f336115m = i3;
                    this.C = j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str62, Integer.valueOf(i18), Integer.valueOf(i17), qQMessageFacade, str, Integer.valueOf(i3), Long.valueOf(j3));
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i28) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i28);
                    } else {
                        ReportController.o(null, "P_CliOper", "Safe_SensMsg", this.f336110d, "Alert_Dialog", "Other", this.f336111e, this.f336112f, "", "", "", "");
                        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                MessageRecord P2 = anonymousClass1.f336113h.P(anonymousClass1.f336114i, anonymousClass1.f336115m, anonymousClass1.C);
                                if (P2 == null) {
                                    return;
                                }
                                MQPSensitiveMsgUtil.q(P2);
                                try {
                                    P2.saveExtInfoToExtStr("sens_msg_confirmed", "1");
                                    P2.removeExtInfoToExtStr("sens_msg_original_text");
                                    P2.removeExtInfoToExtStr("sens_msg_need_parse");
                                    P2.removeExtInfoToExtStr("sens_msg_need_mask");
                                    P2.removeExtInfoToExtStr("sens_msg_attr");
                                    P2.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    anonymousClass12.f336113h.a1(anonymousClass12.f336114i, anonymousClass12.f336115m, anonymousClass12.C, AppConstants.Key.COLUMN_EXT_STR, P2.extStr);
                                    AnonymousClass1.this.f336113h.K0(P2);
                                } catch (Exception e26) {
                                    e26.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(str5)) {
            createCustomDialog2.setNegativeButton(str5, new a(str62, i18, i17));
        }
        createCustomDialog2.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void q(MessageRecord messageRecord) {
        List<bankcode_info$BankcodeElem> list;
        int i3;
        String str;
        int i16;
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return;
        }
        bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo = new bankcode_info$BankcodeCtrlInfo();
        try {
            bankcode_info_bankcodectrlinfo.mergeFrom(HexUtil.hexStr2Bytes(extInfoFromExtStr));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (bankcode_info_bankcodectrlinfo.bankcode_elems.has()) {
            list = bankcode_info_bankcodectrlinfo.bankcode_elems.get();
            if (list != null) {
                return;
            }
            int i17 = 0;
            for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem : list) {
                if (bankcode_info_bankcodeelem.bankcode_attr.has()) {
                    i16 = bankcode_info_bankcodeelem.bankcode_attr.get();
                } else {
                    i16 = 0;
                }
                if (i16 > i17) {
                    i17 = i16;
                }
            }
            if (i17 != 20) {
                return;
            }
            for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem2 : list) {
                if (bankcode_info_bankcodeelem2.bankcode_attr.has()) {
                    i3 = bankcode_info_bankcodeelem2.bankcode_attr.get();
                } else {
                    i3 = 0;
                }
                if (i3 == 20) {
                    if (bankcode_info_bankcodeelem2.clean_bankcode.has()) {
                        str = bankcode_info_bankcodeelem2.clean_bankcode.get();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        g().o(str);
                    }
                }
            }
            messageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
            return;
        }
        list = null;
        if (list != null) {
        }
    }

    public boolean j(String str) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && (bundle = f336106b.getBundle(f336107c)) != null && bundle.containsKey(MD5Utils.encodeHexStr(str))) {
            return true;
        }
        return false;
    }

    public void o(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && !j(str)) {
            f336105a = (f336105a + 1) % 10;
            String encodeHexStr = MD5Utils.encodeHexStr(str);
            String num = Integer.toString(f336105a);
            Bundle bundle = f336106b.getBundle(f336107c);
            if (bundle != null) {
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        str2 = it.next();
                        String string = bundle.getString(str2);
                        if (!TextUtils.isEmpty(string) && string.equals(num)) {
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.remove(str2);
                }
                bundle.putString(encodeHexStr, num);
            }
            ThreadManagerV2.executeOnFileThread(new Runnable(num, encodeHexStr) { // from class: com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f336116d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f336117e;

                {
                    this.f336116d = num;
                    this.f336117e = encodeHexStr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MQPSensitiveMsgUtil.this, num, encodeHexStr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("sp_confirmed_sensmsg_" + MQPSensitiveMsgUtil.f336107c, 0).edit();
                    edit.putString(this.f336116d, this.f336117e);
                    edit.commit();
                }
            });
        }
    }
}
