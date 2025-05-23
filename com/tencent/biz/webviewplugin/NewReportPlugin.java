package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.type.IPermissionType;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class NewReportPlugin {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f97302a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f97303b = "https://jubao.qq.com/uniform_impeach/impeach_entry";

    /* renamed from: c, reason: collision with root package name */
    private static String f97304c = "https://jubaobest.qq.com/uniform_impeach/impeach_entry";

    /* renamed from: com.tencent.biz.webviewplugin.NewReportPlugin$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String C;
        final /* synthetic */ String D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f97305d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f97306e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f97307f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f97308h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bundle f97309i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f97310m;

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle P = NewReportPlugin.P(this.f97305d, this.f97306e, this.f97307f, this.f97308h, this.f97309i);
                String str = this.f97310m;
                if (TextUtils.isEmpty(str) && this.f97306e.getAppRuntime() == null) {
                    str = ProcessConstant.AVGAME;
                }
                QBaseActivity qBaseActivity = this.f97306e;
                String str2 = this.f97307f;
                String str3 = this.f97308h;
                String str4 = this.C;
                String str5 = this.D;
                int i3 = this.f97305d;
                final String J = NewReportPlugin.J(qBaseActivity, str2, null, null, str3, str4, str5, i3, NewReportPlugin.v(i3), str, "", "", "", "", "", "", "", P);
                if (QLog.isColorLevel()) {
                    QLog.d("NewReportPlugin", 2, "safetyNewReport postData=" + J);
                }
                this.f97306e.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NewReportPlugin.g(AnonymousClass1.this.f97306e, J);
                    }
                });
            } catch (Exception e16) {
                this.f97306e.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d("NewReportPlugin", 2, "safetyNewReport exception1" + e16.getMessage());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.webviewplugin.NewReportPlugin$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ Context E;
        final /* synthetic */ QQProgressDialog F;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f97321d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f97322e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f97323f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f97324h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f97325i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f97326m;

        AnonymousClass3(Bundle bundle, String str, String str2, int i3, QQAppInterface qQAppInterface, String str3, String str4, String str5, Context context, QQProgressDialog qQProgressDialog) {
            this.f97321d = bundle;
            this.f97322e = str;
            this.f97323f = str2;
            this.f97324h = i3;
            this.f97325i = qQAppInterface;
            this.f97326m = str3;
            this.C = str4;
            this.D = str5;
            this.E = context;
            this.F = qQProgressDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Context context, String str, QQProgressDialog qQProgressDialog) {
            NewReportPlugin.g(context, str);
            qQProgressDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit f(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Bundle bundle, final Context context, final QQProgressDialog qQProgressDialog, String str14) {
            try {
                final String K = NewReportPlugin.K(qQAppInterface, str, str2, str3, str4, str5, str6, i3, NewReportPlugin.v(i3), str14, str7, str8, str9, str10, str11, str12, str13, bundle);
                if (QLog.isColorLevel()) {
                    QLog.i("NewReportPlugin", 2, String.format("matchFriendSafetyRealReport post: %s", K));
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewReportPlugin.AnonymousClass3.e(context, K, qQProgressDialog);
                    }
                });
                return null;
            } catch (Exception e16) {
                g(e16);
                return null;
            }
        }

        private void g(Exception exc) {
            QLog.d("NewReportPlugin", 1, "matchFriendSafetyRealReport error", exc);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQProgressDialog qQProgressDialog = this.F;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.m
                @Override // java.lang.Runnable
                public final void run() {
                    QQProgressDialog.this.dismiss();
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            AnonymousClass3 anonymousClass3;
            try {
                Bundle bundle = this.f97321d;
                if (bundle == null) {
                    try {
                        bundle = new Bundle();
                    } catch (Exception e16) {
                        e = e16;
                        anonymousClass3 = this;
                        anonymousClass3.g(e);
                        return;
                    }
                }
                final Bundle bundle2 = bundle;
                final String string = bundle2.getString("text_evidence", "");
                final String string2 = bundle2.getString("img_evidence", "");
                final String string3 = bundle2.getString("url_evidence", "");
                final String string4 = bundle2.getString("video_evidence", "");
                final String string5 = bundle2.getString("file_evidence", "");
                final String string6 = bundle2.getString("audio_evidence", "");
                final String string7 = bundle2.getString("user_input_param", "");
                final String string8 = bundle2.getString(TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, "");
                final String str = this.f97322e;
                final String str2 = this.f97323f;
                final int i3 = this.f97324h;
                final QQAppInterface qQAppInterface = this.f97325i;
                final String str3 = this.f97326m;
                final String str4 = this.C;
                final String str5 = this.D;
                final Context context = this.E;
                final QQProgressDialog qQProgressDialog = this.F;
                NTJuBaoUtil.a(str, str2, i3, bundle2, new Function1() { // from class: com.tencent.biz.webviewplugin.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit f16;
                        f16 = NewReportPlugin.AnonymousClass3.this.f(qQAppInterface, str, str3, str4, str2, string8, str5, i3, string, string2, string3, string4, string5, string6, string7, bundle2, context, qQProgressDialog, (String) obj);
                        return f16;
                    }
                });
            } catch (Exception e17) {
                e = e17;
                anonymousClass3 = this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.webviewplugin.NewReportPlugin$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ String E;
        final /* synthetic */ QQProgressDialog F;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f97327d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f97328e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f97329f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f97330h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bundle f97331i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f97332m;

        AnonymousClass4(int i3, QBaseActivity qBaseActivity, String str, String str2, Bundle bundle, String str3, String str4, String str5, String str6, QQProgressDialog qQProgressDialog) {
            this.f97327d = i3;
            this.f97328e = qBaseActivity;
            this.f97329f = str;
            this.f97330h = str2;
            this.f97331i = bundle;
            this.f97332m = str3;
            this.C = str4;
            this.D = str5;
            this.E = str6;
            this.F = qQProgressDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(QQProgressDialog qQProgressDialog, Exception exc) {
            qQProgressDialog.dismiss();
            if (QLog.isColorLevel()) {
                QLog.w("NewReportPlugin", 2, "safetyNewReport exception: " + exc.getMessage(), exc);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(QBaseActivity qBaseActivity, String str, QQProgressDialog qQProgressDialog) {
            NewReportPlugin.g(qBaseActivity, str);
            qQProgressDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit f(final QBaseActivity qBaseActivity, String str, String str2, String str3, String str4, String str5, int i3, Bundle bundle, final QQProgressDialog qQProgressDialog, String str6) {
            try {
                final String J = NewReportPlugin.J(qBaseActivity, str, str2, str3, str4, "", str5, i3, NewReportPlugin.v(i3), str6, "", "", "", "", "", "", "", bundle);
                if (QLog.isColorLevel()) {
                    QLog.d("NewReportPlugin", 2, "safetyNewReport postData=" + J);
                }
                qBaseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewReportPlugin.AnonymousClass4.e(QBaseActivity.this, J, qQProgressDialog);
                    }
                });
                return null;
            } catch (UnsupportedEncodingException e16) {
                g(e16);
                return null;
            }
        }

        private void g(final Exception exc) {
            QBaseActivity qBaseActivity = this.f97328e;
            final QQProgressDialog qQProgressDialog = this.F;
            qBaseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.q
                @Override // java.lang.Runnable
                public final void run() {
                    NewReportPlugin.AnonymousClass4.d(QQProgressDialog.this, exc);
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final Bundle P = NewReportPlugin.P(this.f97327d, this.f97328e, this.f97329f, this.f97330h, this.f97331i);
                String str = this.f97332m;
                final String str2 = this.f97329f;
                final String str3 = this.f97330h;
                final int i3 = this.f97327d;
                final QBaseActivity qBaseActivity = this.f97328e;
                final String str4 = this.C;
                final String str5 = this.D;
                final String str6 = this.E;
                final QQProgressDialog qQProgressDialog = this.F;
                NTJuBaoUtil.b(str, str2, str3, i3, P, new Function1() { // from class: com.tencent.biz.webviewplugin.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit f16;
                        f16 = NewReportPlugin.AnonymousClass4.this.f(qBaseActivity, str2, str4, str5, str3, str6, i3, P, qQProgressDialog, (String) obj);
                        return f16;
                    }
                });
            } catch (Exception e16) {
                g(e16);
            }
        }
    }

    public static boolean A(MsgRecord msgRecord) {
        MsgElement msgElement = msgRecord.getElements().get(0);
        if (msgElement == null || msgElement.getPicElement() == null) {
            return false;
        }
        return true;
    }

    public static boolean B(MsgRecord msgRecord) {
        MsgElement msgElement = msgRecord.getElements().get(0);
        if (msgElement == null) {
            return false;
        }
        if (msgElement.getStructMsgElement() == null && msgElement.getStructLongMsgElement() == null) {
            return false;
        }
        return true;
    }

    public static boolean C(MsgRecord msgRecord) {
        MsgElement msgElement = msgRecord.getElements().get(0);
        if (msgElement == null || msgElement.getTextElement() == null) {
            return false;
        }
        return true;
    }

    public static String E(Activity activity, String str, String str2, String str3, String str4, int i3, String str5, String str6, int i16, String str7, Bundle bundle) throws UnsupportedEncodingException {
        return J(activity, str, "", str2, str3, m(activity, i3, str, bundle), str4, i3, str5, str6, "", "", "", "", "", "", "", bundle) + "&msgs=" + str7 + "&msg_count=" + i16;
    }

    @NonNull
    public static GetMsgReq F(String str, String str2, int i3, Bundle bundle) {
        String str3;
        int i16;
        if (bundle != null && bundle.containsKey("chatuin") && bundle.containsKey("chattype")) {
            str3 = bundle.getString("chatuin");
            i16 = bundle.getInt("chattype");
        } else {
            str3 = null;
            i16 = -1;
        }
        int i17 = 50;
        if (i16 != -1 && !TextUtils.isEmpty(str3)) {
            str = str3;
        } else {
            if (i3 != 22003 && i3 != 22000 && i3 != 20009 && i3 != 20008 && i3 != 20014 && i3 != 25029) {
                if (i3 != 22001 && i3 != 20013) {
                    if (i3 == 20012) {
                        str = str2;
                    } else if (i3 == 21002) {
                        i16 = 1034;
                    } else if (i3 == 21003) {
                        i16 = 1033;
                    } else if (i3 != 20015 && i3 != 20005) {
                        if (i3 == 25020) {
                            i16 = 1045;
                        } else if (i3 != 2220331 && i3 != 2220330 && i3 != 2220329) {
                            if (i3 == 20017) {
                                i16 = 1022;
                            } else if (i3 == 20016) {
                                i16 = 1000;
                            } else if (i3 == 20018) {
                                i16 = 10002;
                            } else if (i3 == 20019) {
                                i16 = 1004;
                            } else if (i3 == 25028) {
                                i16 = 10010;
                            } else if (i3 == 25095) {
                                i16 = 10007;
                                str = str2;
                            } else {
                                i16 = 0;
                            }
                        } else {
                            i16 = 1046;
                        }
                    } else {
                        i16 = 1044;
                    }
                } else {
                    i16 = 3000;
                    str = str2;
                    i17 = 200;
                }
            } else {
                str = str2;
                i17 = 200;
            }
            i16 = 1;
        }
        return new GetMsgReq(str, i16, i17);
    }

    public static Bundle G(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("chatuin", str);
        bundle.putInt("chattype", i3);
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("makeReportExtraParams [%s]", bundle));
        }
        return bundle;
    }

    public static Bundle H(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return new Bundle();
        }
        Bundle G = G(sessionInfo.f179557e, sessionInfo.f179555d);
        int i3 = sessionInfo.f179555d;
        if (i3 == 1033 || i3 == 1034) {
            G.putInt("topicid", sessionInfo.S);
            G.putString("uinname", sessionInfo.T);
        }
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("makeReportExtraParamsForProfile [%s]", G));
        }
        return G;
    }

    public static Bundle I(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return new Bundle();
        }
        Bundle G = G(str, i3);
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("makeReportExtraParamsForProfile [%s]", G));
        }
        return G;
    }

    public static String J(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Bundle bundle) throws UnsupportedEncodingException {
        return K(activity instanceof BaseActivity ? ((BaseActivity) activity).app : null, str, str2, str3, str4, str5, str6, i3, str7, str8, str9, str10, str11, str12, str13, str14, str15, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x07ac  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04ac  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String K(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Bundle bundle) throws UnsupportedEncodingException {
        String str16;
        String str17;
        String str18;
        int i16;
        String str19;
        StringBuilder sb5;
        String upperCase;
        String str20;
        String str21;
        ?? r95;
        String h16;
        String h17;
        String h18;
        String h19;
        String h26;
        String h27;
        String h28;
        String str22;
        int i17;
        char c16;
        String format;
        int i18;
        int i19;
        int i26;
        String str23 = TextUtils.isEmpty(str2) ? str : str2;
        String str24 = AppSetting.f99551k;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("system=");
        sb6.append("android");
        sb6.append("&version=");
        sb6.append(str24);
        sb6.append("&uintype=1");
        sb6.append("&eviluin=");
        sb6.append(str23);
        sb6.append("&appname=KQQ");
        sb6.append("&appid=2400002");
        if (!TextUtils.isEmpty(str7)) {
            sb6.append("&subapp=");
            sb6.append(str7);
        } else {
            sb6.append("&subapp=");
            sb6.append(v(i3));
        }
        sb6.append("&scene=");
        sb6.append(i3);
        if (i3 == 2220331) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("reporttime=");
            str16 = "";
            sb7.append(System.currentTimeMillis() / 1000);
            str17 = sb7.toString();
            if (!TextUtils.isEmpty(str5)) {
                str17 = "roomid=" + str5 + "|" + str17;
            }
        } else {
            str16 = "";
            if ((i3 < 2220369 || i3 > 2220371) && !w(i3)) {
                if (bundle != null) {
                    String valueOf = String.valueOf(bundle.getLong("anonymousseq"));
                    if (!TextUtils.isEmpty(valueOf)) {
                        str17 = "anonymousseq=" + valueOf;
                    }
                }
                str17 = str16;
            } else {
                str17 = str5;
            }
        }
        sb6.append("&contentid=");
        sb6.append(str17);
        if (!TextUtils.isEmpty(str3)) {
            sb6.append("&buddyflag=");
            sb6.append(str3);
        } else {
            sb6.append("&buddyflag=0");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb6.append("&groupid=");
            sb6.append(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb6.append("&contentid=");
            sb6.append(str5);
        }
        String r16 = (!TextUtils.isEmpty(str8) || qQAppInterface == null) ? str8 : r(qQAppInterface, str, str4, i3, bundle);
        if (i3 == 25098 || i3 == 2220331 || w(i3)) {
            r16 = "chatmsg:";
        }
        String h29 = h(r16, true);
        String h36 = h(str9, true);
        String h37 = h(str10, true);
        String h38 = h(str11, true);
        String h39 = h(str12, true);
        String h46 = h(str13, true);
        String h47 = h(str14, true);
        sb6.append("&srv_para=");
        sb6.append(h29);
        sb6.append("&text_evidence=");
        sb6.append(h36);
        sb6.append("&img_evidence=");
        sb6.append(h37);
        sb6.append("&url_evidence=");
        sb6.append(h38);
        sb6.append("&video_evidence=");
        sb6.append(h39);
        sb6.append("&file_evidence=");
        sb6.append(h46);
        sb6.append("&audio_evidence=");
        sb6.append(h47);
        if (TextUtils.isEmpty(str15)) {
            sb6.append("&user_input_param=");
            sb6.append(h("REPORT_IP=0&EVIL_IP=0", true));
        } else {
            sb6.append("&user_input_param=");
            sb6.append(h(str15, true));
        }
        String str25 = "abcdabcdabcdabcd";
        try {
            String str26 = HttpBaseUtil.m("https://jubao.qq.com/uniform_impeach/impeach_cryptokey", "GET", new Bundle()).f340999a;
            if (QLog.isColorLevel()) {
                str18 = str17;
                try {
                    QLog.d("NewReportPlugin", 2, String.format("makePostData step1: %s", str26));
                } catch (Exception e16) {
                    e = e16;
                    i16 = 1;
                    QLog.d("NewReportPlugin", 1, "get cryptograph exception" + e.getMessage());
                    str19 = str25;
                    String f16 = f("d41d8cd98f00b204e9800998ecf8427e", str19);
                    if (QLog.isColorLevel()) {
                    }
                    sb5 = new StringBuilder(200);
                    sb5.append("android");
                    sb5.append("_");
                    sb5.append(str24);
                    sb5.append("_");
                    sb5.append(i3);
                    sb5.append("_");
                    sb5.append(f16);
                    String sb8 = sb5.toString();
                    upperCase = MD5Utils.toMD5(sb8).toUpperCase();
                    if (QLog.isColorLevel()) {
                    }
                    sb5.setLength(r95);
                    if (x(i3)) {
                    }
                    h16 = h(h47, r95);
                    h17 = h(h46, r95);
                    h18 = h(h37, r95);
                    h19 = h(h29, r95);
                    h26 = h(h36, r95);
                    h27 = h(h38, r95);
                    h28 = h(h39, r95);
                    sb5.append("2400002");
                    sb5.append("_");
                    sb5.append("KQQ");
                    sb5.append("_");
                    if (!TextUtils.isEmpty(h16)) {
                    }
                    sb5.append("_");
                    sb5.append(!TextUtils.isEmpty(str3) ? 0 : str3);
                    sb5.append("_");
                    if (!TextUtils.isEmpty(str18)) {
                    }
                    if (i3 != 2220369) {
                    }
                    sb5.append("_");
                    sb5.append(4);
                    sb5.append("_");
                    sb5.append(str23);
                    sb5.append("_");
                    sb5.append(r0);
                    sb5.append("_");
                    if (!TextUtils.isEmpty(h17)) {
                    }
                    sb5.append("_");
                    str22 = str4;
                    if (str22 != null) {
                    }
                    sb5.append("_");
                    if (!TextUtils.isEmpty(h18)) {
                    }
                    sb5.append("_");
                    sb5.append(0);
                    sb5.append("_");
                    sb5.append(i3);
                    sb5.append("_");
                    if (!TextUtils.isEmpty(h19)) {
                    }
                    sb5.append("_");
                    sb5.append(str7);
                    sb5.append("_");
                    sb5.append(str21);
                    sb5.append("_");
                    if (!TextUtils.isEmpty(h26)) {
                    }
                    sb5.append("_");
                    sb5.append(1);
                    sb5.append("_");
                    if (!TextUtils.isEmpty(h27)) {
                    }
                    sb5.append("_");
                    sb5.append(str20);
                    sb5.append("_");
                    if (!TextUtils.isEmpty(h28)) {
                    }
                    sb5.append("_");
                    sb5.append(upperCase);
                    String sb9 = sb5.toString();
                    String md5 = MD5.toMD5(sb9.getBytes("UTF-8"));
                    if (QLog.isColorLevel()) {
                    }
                    sb6.append("&cryptograph=");
                    sb6.append(md5);
                    if (bundle != null) {
                        String string = bundle.getString("chatuin");
                        i17 = bundle.getInt("chattype");
                        if (i17 != 1) {
                        }
                        if (!TextUtils.isEmpty(format)) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                    String sb10 = sb6.toString();
                    if (QLog.isColorLevel()) {
                    }
                    return sb10;
                }
            } else {
                str18 = str17;
            }
            str25 = o(str26);
            if (QLog.isColorLevel()) {
                QLog.d("NewReportPlugin", 2, String.format("makePostData step2: %s", str25));
            }
            str19 = str25;
            i16 = 1;
        } catch (Exception e17) {
            e = e17;
            str18 = str17;
        }
        String f162 = f("d41d8cd98f00b204e9800998ecf8427e", str19);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[i16];
            objArr[0] = f162;
            QLog.d("NewReportPlugin", 2, String.format("makePostData step3: %s", objArr));
        }
        sb5 = new StringBuilder(200);
        sb5.append("android");
        sb5.append("_");
        sb5.append(str24);
        sb5.append("_");
        sb5.append(i3);
        sb5.append("_");
        sb5.append(f162);
        String sb82 = sb5.toString();
        upperCase = MD5Utils.toMD5(sb82).toUpperCase();
        if (QLog.isColorLevel()) {
            str20 = str24;
            str21 = "android";
            r95 = 0;
        } else {
            str20 = str24;
            str21 = "android";
            r95 = 0;
            QLog.d("NewReportPlugin", 2, String.format("makePostData step4: [%s, %s]", sb82, upperCase));
        }
        sb5.setLength(r95);
        if (x(i3) && !w(i3)) {
            sb5.append(str23);
            sb5.append("_");
            sb5.append(h(h29, r95));
            sb5.append("_");
            sb5.append(h(h36, r95));
            sb5.append("_");
            sb5.append(h(h37, r95));
            sb5.append("_");
            sb5.append(h(h38, r95));
            sb5.append("_");
            sb5.append(h(h39, r95));
            sb5.append("_");
            sb5.append(h(h46, r95));
            sb5.append("_");
            sb5.append(h(h47, r95));
            sb5.append("_");
            sb5.append(upperCase);
            str22 = str4;
        } else {
            h16 = h(h47, r95);
            h17 = h(h46, r95);
            h18 = h(h37, r95);
            h19 = h(h29, r95);
            h26 = h(h36, r95);
            h27 = h(h38, r95);
            h28 = h(h39, r95);
            sb5.append("2400002");
            sb5.append("_");
            sb5.append("KQQ");
            sb5.append("_");
            if (!TextUtils.isEmpty(h16)) {
                sb5.append(h16);
            }
            sb5.append("_");
            sb5.append(!TextUtils.isEmpty(str3) ? 0 : str3);
            sb5.append("_");
            if (!TextUtils.isEmpty(str18)) {
                sb5.append(str18);
            }
            int i27 = i3 != 2220369 ? 7 : 2;
            sb5.append("_");
            sb5.append(4);
            sb5.append("_");
            sb5.append(str23);
            sb5.append("_");
            sb5.append(i27);
            sb5.append("_");
            if (!TextUtils.isEmpty(h17)) {
                sb5.append(h17);
            }
            sb5.append("_");
            str22 = str4;
            if (str22 != null) {
                sb5.append(str22);
            }
            sb5.append("_");
            if (!TextUtils.isEmpty(h18)) {
                sb5.append(h18);
            }
            sb5.append("_");
            sb5.append(0);
            sb5.append("_");
            sb5.append(i3);
            sb5.append("_");
            if (!TextUtils.isEmpty(h19)) {
                sb5.append(h19);
            }
            sb5.append("_");
            sb5.append(str7);
            sb5.append("_");
            sb5.append(str21);
            sb5.append("_");
            if (!TextUtils.isEmpty(h26)) {
                sb5.append(h26);
            }
            sb5.append("_");
            sb5.append(1);
            sb5.append("_");
            if (!TextUtils.isEmpty(h27)) {
                sb5.append(h27);
            }
            sb5.append("_");
            sb5.append(str20);
            sb5.append("_");
            if (!TextUtils.isEmpty(h28)) {
                sb5.append(h28);
            }
            sb5.append("_");
            sb5.append(upperCase);
        }
        String sb92 = sb5.toString();
        String md52 = MD5.toMD5(sb92.getBytes("UTF-8"));
        if (QLog.isColorLevel()) {
            QLog.d("NewReportPlugin", 2, String.format("makePostData step5: [%s, %s]", sb92, md52));
        }
        sb6.append("&cryptograph=");
        sb6.append(md52);
        if (bundle != null && bundle.containsKey("chatuin") && bundle.containsKey("chattype")) {
            String string2 = bundle.getString("chatuin");
            i17 = bundle.getInt("chattype");
            if (i17 != 1) {
                format = String.format("&%s=%s&%s=%s&%s=%s", "chatuin", !TextUtils.equals(str, string2) ? j(str, p(1)) : str16, "groupcode", string2, "chattype", Integer.valueOf(i17));
            } else if (i17 == 3000) {
                format = String.format("&%s=%s&%s=%s&%s=%s", "chatuin", !TextUtils.equals(str, string2) ? j(str, p(1)) : str16, "groupcode", string2, "chattype", Integer.valueOf(i17));
            } else if (i17 == 10014) {
                String j3 = j(string2, p(1));
                if (bundle.containsKey("is_need_open_channel_select_fragment")) {
                    i19 = 0;
                    i26 = bundle.getInt("is_need_open_channel_select_fragment", 0);
                } else {
                    i19 = 0;
                    i26 = 0;
                }
                int i28 = bundle.containsKey("isdirectmsg") ? bundle.getInt("isdirectmsg", i19) : i19;
                if (i3 == 25086) {
                    Object[] objArr2 = new Object[8];
                    objArr2[i19] = "chatuin";
                    objArr2[1] = j3;
                    objArr2[2] = "groupcode";
                    objArr2[3] = str16;
                    objArr2[4] = "chattype";
                    objArr2[5] = Integer.valueOf(i17);
                    objArr2[6] = "is_need_open_channel_select_fragment";
                    objArr2[7] = Integer.valueOf(i26);
                    format = String.format("&%s=%s&%s=%s&%s=%s&%s=%s", objArr2);
                } else {
                    format = String.format("&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", "chatuin", j3, "groupcode", str22, "chattype", Integer.valueOf(i17), "is_need_open_channel_select_fragment", Integer.valueOf(i26), "isdirectmsg", Integer.valueOf(i28));
                }
                if (w(i3)) {
                    sb6.append("&eviluin_type=2");
                    sb6.append("&is_anonymous=0");
                    sb6.append("&crypto_version=4");
                }
            } else if (i17 == 1033 || i17 == 1034) {
                int i29 = bundle.getInt("topicid");
                String string3 = bundle.getString("uinname");
                if (TextUtils.isEmpty(string3)) {
                    c16 = 0;
                } else {
                    c16 = 0;
                    string3 = URLEncoder.encode(Base64.encodeToString(string3.getBytes(), 0), "UTF-8");
                }
                String j16 = j(string2, p(1));
                Object[] objArr3 = new Object[8];
                objArr3[c16] = "chatuin";
                objArr3[1] = j16;
                objArr3[2] = "chattype";
                objArr3[3] = Integer.valueOf(i17);
                objArr3[4] = "topicid";
                objArr3[5] = Integer.valueOf(i29);
                objArr3[6] = "uinname";
                objArr3[7] = string3;
                format = String.format("&%s=%s&%s=%s&%s=%s&%s=%s", objArr3);
            } else if (i17 == 10007) {
                byte[] byteArray = bundle.getByteArray("jubao_game_sig");
                if (byteArray == null) {
                    byteArray = new byte[0];
                    i18 = 1;
                    QLog.e("NewReportPlugin", 1, "gameSig is empty");
                } else {
                    i18 = 1;
                }
                String j17 = j(string2, p(i18));
                String str27 = bundle.getString("roleId").split(ContainerUtils.FIELD_DELIMITER)[0];
                String str28 = bundle.getString("roleId").split(ContainerUtils.FIELD_DELIMITER)[i18];
                String concat = "evilroleId=".concat(str27).concat("|").concat("roleId=").concat(str28);
                Object[] objArr4 = new Object[16];
                objArr4[0] = "chatuin";
                objArr4[i18] = j17;
                objArr4[2] = "chattype";
                objArr4[3] = Integer.valueOf(i17);
                objArr4[4] = "friendroleid";
                objArr4[5] = str27;
                objArr4[6] = "myroleid";
                objArr4[7] = str28;
                objArr4[8] = TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID;
                objArr4[9] = concat;
                objArr4[10] = "jubao_game_sig";
                objArr4[11] = Base64.encodeToString(byteArray, 0);
                objArr4[12] = "c2c_type";
                objArr4[13] = "1";
                objArr4[14] = "service_type";
                objArr4[15] = "164";
                format = String.format("&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", objArr4);
                if (QLog.isColorLevel()) {
                    QLog.i("NewReportPlugin", 2, "\u8054\u8c03 sig = " + Arrays.toString(byteArray));
                }
            } else if (i17 == 1001) {
                format = String.format("&%s=%s&%s=%s&%s=%s", "chatuin", j(string2, p(1)), "chattype", Integer.valueOf(i17), "jubao_nearby_sig", Base64.encodeToString(bundle.getByteArray("jubao_nearby_sig"), 0));
            } else if (i17 == 1046) {
                sb6.append(i3 == 2220369 ? "&eviluin_type=7" : "&eviluin_type=2");
                sb6.append("&is_anonymous=0");
                sb6.append("&crypto_version=4");
                format = String.format("&%s=%s&%s=%s&%s=%s", "chatuin", j(string2, p(1)), "chattype", Integer.valueOf(i17), "jubao_matchfriend_sig", Base64.encodeToString(bundle.getByteArray("jubao_matchfriend_sig"), 0));
            } else {
                format = String.format("&%s=%s&%s=%s", "chatuin", j(string2, p(1)), "chattype", Integer.valueOf(i17));
            }
            if (!TextUtils.isEmpty(format)) {
                sb6.append(format);
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewReportPlugin", 2, String.format("extra_chat [%s] -- [%s] ", bundle, format));
            }
        }
        String sb102 = sb6.toString();
        if (QLog.isColorLevel()) {
            QLog.d("NewReportPlugin", 2, String.format("makePostData post: %s", sb102));
        }
        return sb102;
    }

    private static void L(QQAppInterface qQAppInterface, Context context, String str, String str2, String str3, String str4, String str5, int i3, Bundle bundle, QQProgressDialog qQProgressDialog) {
        ThreadManagerV2.excute(new AnonymousClass3(bundle, str, str4, i3, qQAppInterface, str2, str3, str5, context, qQProgressDialog), 16, null, false);
    }

    public static void M(QQAppInterface qQAppInterface, Context context, String str, String str2, String str3, String str4, String str5, int i3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5)) {
            if (QLog.isColorLevel()) {
                QLog.i("NewReportPlugin", 2, String.format("safetyNewReport [org: %s, encrypt: %s,  g: %s,  s: %s, extra: %s]", str, str2, str4, Integer.valueOf(i3), bundle));
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(context);
            try {
                qQProgressDialog.show();
            } catch (Exception e16) {
                QLog.e("NewReportPlugin", 1, "err show progress dialog", e16);
            }
            L(qQAppInterface, context, str, str2, str3, str4, str5, i3, bundle, qQProgressDialog);
            return;
        }
        QLog.e("NewReportPlugin", 1, "safetyReport param null");
    }

    private static void N(final QBaseActivity qBaseActivity, final String str, final String str2, final String str3, final int i3, final String str4, final QQProgressDialog qQProgressDialog, final Bundle bundle) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                String v3;
                String str5;
                try {
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        bundle2 = new Bundle();
                    }
                    String string = bundle2.getString("text_evidence", "");
                    String string2 = bundle2.getString("img_evidence", "");
                    String string3 = bundle2.getString("url_evidence", "");
                    String string4 = bundle2.getString("video_evidence", "");
                    String string5 = bundle2.getString("file_evidence", "");
                    String string6 = bundle2.getString("audio_evidence", "");
                    String string7 = bundle2.getString("user_input_param", "");
                    if (!TextUtils.isEmpty(str4)) {
                        v3 = str4;
                    } else {
                        v3 = NewReportPlugin.v(i3);
                    }
                    String str6 = v3;
                    if (qBaseActivity.getAppRuntime() instanceof QQAppInterface) {
                        str5 = NewReportPlugin.r((QQAppInterface) qBaseActivity.getAppRuntime(), str2, str3, i3, bundle2);
                    } else {
                        str5 = "chatmsg%3A";
                    }
                    final String J = NewReportPlugin.J(qBaseActivity, str, "", "", str3, "", "", i3, str6, str5, string, string2, string3, string4, string5, string6, string7, bundle2);
                    if (QLog.isColorLevel()) {
                        QLog.i("NewReportPlugin", 2, String.format("nearbySafetyRealReport post: %s", J));
                    }
                    qBaseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NewReportPlugin.g(qBaseActivity, J);
                            qQProgressDialog.dismiss();
                        }
                    });
                } catch (Exception e16) {
                    qBaseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            qQProgressDialog.dismiss();
                            if (QLog.isColorLevel()) {
                                QLog.d("NewReportPlugin", 2, "nearbySafetyRealReport exception1" + e16.getMessage());
                            }
                        }
                    });
                }
            }
        }, 16, null, false);
    }

    public static void O(QBaseActivity qBaseActivity, long j3, String str, String str2, int i3, String str3, Bundle bundle) {
        String valueOf;
        if (qBaseActivity != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("NewReportPlugin", 2, String.format("nearbySafetyReport [%s, %s, %s]", Long.valueOf(j3), str, Integer.valueOf(i3)));
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
            try {
                qQProgressDialog.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (j3 <= 0) {
                valueOf = str;
            } else {
                valueOf = String.valueOf(j3);
            }
            N(qBaseActivity, valueOf, str, str2, c(i3), d(i3, str3), qQProgressDialog, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewReportPlugin", 2, "nearbySafetyReport param null");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        r13 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        r0 = r13;
        r12 = true;
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ad, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c9, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle P(int i3, QBaseActivity qBaseActivity, String str, String str2, Bundle bundle) {
        String str3;
        int i16;
        boolean z16;
        if (bundle != null) {
            str3 = bundle.getString("chatuin");
        } else {
            str3 = null;
        }
        if (bundle != null) {
            i16 = bundle.getInt("chattype");
        } else {
            i16 = -1;
        }
        if (i3 != 20008) {
            if (i3 == 20013) {
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
                i16 = 3000;
            } else {
                if (i3 == 20015) {
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                    }
                    i16 = 1044;
                } else if (i3 == 25020) {
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                    }
                    i16 = 1045;
                } else if (i3 == 20016) {
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                    }
                    i16 = 1000;
                } else if (i3 == 20019) {
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                    }
                    i16 = 1004;
                } else if (i3 == 20017) {
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                    }
                    i16 = 1022;
                } else if (i3 == 20018) {
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                    }
                    i16 = 10002;
                } else {
                    if (i3 == 21001) {
                        if (!TextUtils.isEmpty(str3)) {
                            str = str3;
                        }
                        str3 = str;
                        i16 = 0;
                    } else if (i3 != 22003) {
                        if (i3 == 25028) {
                            if (!TextUtils.isEmpty(str3)) {
                                str2 = str3;
                            }
                            i16 = 10010;
                        } else if (i3 != 25029) {
                            if (i3 != 25080 && i3 != 25086 && i3 != 25082 && i3 != 25098 && i3 != 25099 && i3 != 25090) {
                                z16 = false;
                            } else {
                                if (i3 != 25080 && i3 != 25082 && i3 != 25098 && i3 != 25099 && i3 != 25090) {
                                    if (bundle != null) {
                                        bundle.putString("groupcode", "");
                                    }
                                } else if (bundle != null) {
                                    bundle.putString("groupcode", str2);
                                }
                                i16 = 10014;
                            }
                        }
                    }
                    z16 = true;
                }
                str3 = str;
                z16 = true;
            }
            str3 = str2;
            z16 = true;
        }
        if (z16) {
            if (bundle == null) {
                bundle = G(str3, i16);
            } else if (!bundle.containsKey("chatuin") || !bundle.containsKey("chattype")) {
                bundle.putString("chatuin", str3);
                bundle.putInt("chattype", i16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("preDealReportForScene [%s, %s, %s]", Integer.valueOf(i3), str3, Integer.valueOf(i16)));
        }
        return bundle;
    }

    private static void Q(QBaseActivity qBaseActivity, int i3, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        int u16 = u(i3);
        Bundle G = G(str, i3);
        if (i3 == 0) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        String str8 = str4;
        byte[] bArr = null;
        if (i3 != 3000 && i3 != 1) {
            if (i3 != 1000 && i3 != 10007) {
                str5 = null;
            } else {
                str5 = str3;
            }
        } else {
            str5 = str;
        }
        if (i3 == 1001) {
            ad adVar = ad.f97536a;
            if (adVar.a()) {
                adVar.b(qBaseActivity, "10022", str, str8, str5, str2, str5, "0", "");
                return;
            }
            AppRuntime appRuntime = qBaseActivity.getAppRuntime();
            if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
                bArr = ((QQAppInterface) appRuntime).getMsgCache().b0(str);
            }
            G.putByteArray("jubao_nearby_sig", bArr);
            O(qBaseActivity, 0L, str, str5, u16, null, G);
            return;
        }
        if (i3 == 10002) {
            O(qBaseActivity, 0L, str, str5, u16, null, G);
            return;
        }
        if (i3 != 1034 && i3 != 1033 && i3 != 1044 && i3 != 1045) {
            if (i3 == 10007) {
                if (str5 != null) {
                    str6 = str5.split("_")[0];
                } else {
                    str6 = null;
                }
                if (str5 != null) {
                    str7 = str5.split("_")[1];
                } else {
                    str7 = null;
                }
                G.putString("roleId", str7);
                G.putString("chatuin", str6);
                G.putInt("chattype", 10007);
                AppRuntime appRuntime2 = qBaseActivity.getAppRuntime();
                if (appRuntime2 != null) {
                    bArr = ((com.tencent.mobileqq.service.message.e) qBaseActivity.getAppRuntime().getMsgCache()).b1(str6, appRuntime2.getCurrentUin());
                }
                G.putByteArray("jubao_game_sig", bArr);
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("jubao_game", 0);
                if (appRuntime2 != null) {
                    sharedPreferences.edit().putString("jubao_game_evil_uin_".concat(appRuntime2.getCurrentUin()), str).apply();
                }
                S(qBaseActivity, str, null, str8, str6, str2, u16, null, G);
                return;
            }
            S(qBaseActivity, str, null, str8, str5, str2, u16, null, G);
            return;
        }
        S(qBaseActivity, str, j(str, p(2)), str8, str5, str2, u16, null, G);
    }

    public static void R(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4) {
        byte[] bytes;
        if (qQAppInterface == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            String str5 = "SourceID=401&appname=KQQ&jubaotype=uin&system=android&subapp=BusinessCard&" + (("groupuin=" + str + "&eviluin=0&anonyid=" + URLEncoder.encode(str2) + "&impeachuin=" + str3 + "&msglist=" + str4) + "&uin_source=unfriend");
            if (str5 == null) {
                bytes = null;
            } else {
                try {
                    bytes = str5.getBytes("utf-8");
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("NewReportPlugin", 2, "safetyReport exception" + e16.getMessage());
                        return;
                    }
                    return;
                }
            }
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("BSafeReportPost", true);
            intent.putExtra("SafeReportData", bytes);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("ishiderefresh", true);
            intent.putExtra("ishidebackforward", true);
            intent.putExtra("url", "https://jubao.qq.com/cn/jubao");
            intent.addFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, "safetyReport param null");
        }
    }

    public static void S(QBaseActivity qBaseActivity, String str, String str2, String str3, String str4, String str5, int i3, String str6, Bundle bundle) {
        if (qBaseActivity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5)) {
            if (QLog.isColorLevel()) {
                QLog.i("NewReportPlugin", 2, String.format("safetyNewReport [org: %s, encrypt: %s,  g: %s,  s: %s, extra: %s]", str, str2, str4, Integer.valueOf(i3), bundle));
            }
            final QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
            try {
                qQProgressDialog.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            ad adVar = ad.f97536a;
            if (adVar.a()) {
                String l3 = l(i3);
                QLog.i("NewReportPlugin", 1, "appId:" + l3);
                if (!TextUtils.isEmpty(l3)) {
                    adVar.b(qBaseActivity, l3, str, str3, str4, str, str4, "0", "");
                    qBaseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQProgressDialog.this.dismiss();
                        }
                    });
                    return;
                }
            }
            ThreadManagerV2.excute(new AnonymousClass4(i3, qBaseActivity, str, str4, bundle, str6, str2, str3, str5, qQProgressDialog), 16, null, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewReportPlugin", 2, "safetyReport param null");
        }
    }

    public static void T(QBaseActivity qBaseActivity, String str, String str2, String str3, int i3, String str4) {
        if (qBaseActivity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.i("NewReportPlugin", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", str, str2, str3, Integer.valueOf(i3), str4));
            }
            S(qBaseActivity, str, null, null, str2, str3, i3, str4, null);
        } else if (QLog.isColorLevel()) {
            QLog.d("NewReportPlugin", 2, "safetyReport param null");
        }
    }

    public static void U(QBaseActivity qBaseActivity, int i3, String str, String str2) {
        Q(qBaseActivity, i3, str, str2, null);
    }

    public static void V(QBaseActivity qBaseActivity, int i3, String str, String str2, String str3) {
        Q(qBaseActivity, i3, str, str2, str3);
    }

    public static void b(final QBaseActivity qBaseActivity, final String str, final String str2, final String str3, final String str4, final int i3, final String str5, final int i16, final String str6, final Bundle bundle) {
        if (qBaseActivity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4)) {
            if (QLog.isColorLevel()) {
                QLog.i("NewReportPlugin", 2, String.format("actionSheetReport [org: %s, g: %s,  s: %s, extra: %s]", str, str3, Integer.valueOf(i3), bundle));
            }
            final QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
            try {
                qQProgressDialog.show();
            } catch (Exception e16) {
                QLog.e("NewReportPlugin", 1, e16, new Object[0]);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle P = NewReportPlugin.P(i3, qBaseActivity, str, str3, bundle);
                        QBaseActivity qBaseActivity2 = qBaseActivity;
                        String str7 = str;
                        String str8 = str2;
                        String str9 = str3;
                        String str10 = str4;
                        int i17 = i3;
                        final String E = NewReportPlugin.E(qBaseActivity2, str7, str8, str9, str10, i17, NewReportPlugin.v(i17), str5, i16, str6, P);
                        if (QLog.isColorLevel()) {
                            QLog.d("NewReportPlugin", 2, "actionSheetReport postData=" + E);
                        }
                        qBaseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NewReportPlugin.g(qBaseActivity, E);
                                if (qQProgressDialog.isShowing()) {
                                    qQProgressDialog.dismiss();
                                }
                            }
                        });
                    } catch (Exception e17) {
                        qBaseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.NewReportPlugin.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (qQProgressDialog.isShowing()) {
                                    qQProgressDialog.dismiss();
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("NewReportPlugin", 2, "safetyNewReport exception1" + e17.getMessage());
                                }
                            }
                        });
                    }
                }
            }, 16, null, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewReportPlugin", 2, "actionSheetReport param null");
        }
    }

    private static int c(int i3) {
        if (i3 == 3010) {
            return 20006;
        }
        return i3;
    }

    private static String d(int i3, String str) {
        int c16 = c(i3);
        if (c16 != i3) {
            return v(c16);
        }
        return str;
    }

    public static String e(String str, String str2) {
        byte[] bArr;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] E = Utils.E(str);
            if (E != null && E.length > 0) {
                bArr = i(E, str2, 2);
            } else {
                bArr = null;
            }
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            String str4 = new String(bArr, "UTF-8");
            try {
                int indexOf = str4.indexOf(0);
                if (indexOf >= 0) {
                    return str4.substring(0, indexOf);
                }
                return str4;
            } catch (UnsupportedEncodingException e16) {
                e = e16;
                str3 = str4;
                e.printStackTrace();
                return str3;
            } catch (Throwable th5) {
                th = th5;
                str3 = str4;
                th.printStackTrace();
                return str3;
            }
        } catch (UnsupportedEncodingException e17) {
            e = e17;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String f(String str, String str2) {
        byte[] decode;
        try {
            if (str2.equals("abcdabcdabcdabcd")) {
                decode = str2.getBytes("UTF-8");
            } else {
                decode = Base64.decode(str2.getBytes("UTF-8"), 0);
            }
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, new SecretKeySpec(str.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES));
            return new String(cipher.doFinal(decode));
        } catch (Exception e16) {
            QLog.e("NewReportPlugin", 1, "decrypt Key has something wrong : " + e16.toString());
            e16.printStackTrace();
            return null;
        }
    }

    public static void g(Context context, String str) {
        byte[] bytes;
        try {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("BSafeReportPost", true);
            if (str == null) {
                bytes = null;
            } else {
                bytes = str.getBytes("utf-8");
            }
            intent.putExtra("SafeReportData", bytes);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("ishiderefresh", true);
            intent.putExtra("ishidebackforward", true);
            context.startActivity(intent.putExtra("url", n()));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("NewReportPlugin", 2, "doJumpReport exception: " + e16.getMessage());
            }
        }
    }

    public static String h(String str, boolean z16) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        try {
            if (z16) {
                str = URLEncoder.encode(str, "UTF-8");
            } else {
                str = URLDecoder.decode(str, "UTF-8");
            }
            return str;
        } catch (UnsupportedEncodingException e16) {
            if (!z16) {
                str2 = str;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NewReportPlugin", 2, String.format("encodeOrDecodeStr [%s, %s]", Boolean.valueOf(z16), str), e16);
            }
            return str2;
        } catch (Throwable th5) {
            QLog.i("NewReportPlugin", 1, String.format("encodeOrDecodeStr [%s, %s]", Boolean.valueOf(z16), str), th5);
            return str;
        }
    }

    private static byte[] i(byte[] bArr, String str, int i3) {
        if (bArr != null && bArr.length != 0) {
            try {
                int length = bArr.length;
                if (length % 16 != 0) {
                    length += 16 - (length % 16);
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
                cipher.init(i3, new SecretKeySpec(str.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES));
                return cipher.doFinal(bArr2);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("NewReportPlugin", 1, "encryOrDecryStr error: " + e16.getMessage());
            }
        }
        return null;
    }

    public static String j(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Utils.e(i(str.getBytes("utf-8"), str2, 1));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    public static String k(List<ChatMessage> list) {
        String plainText;
        String str;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (ChatMessage chatMessage : list) {
            if (chatMessage instanceof MessageForMixedMsg) {
                MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) chatMessage;
                List<MessageRecord> list2 = messageForMixedMsg.msgElemList;
                if (list2 != null) {
                    for (MessageRecord messageRecord : list2) {
                        if (y(messageRecord)) {
                            messageRecord.istroop = messageForMixedMsg.istroop;
                            messageRecord.senderuin = messageForMixedMsg.senderuin;
                            messageRecord.selfuin = messageForMixedMsg.selfuin;
                            messageRecord.frienduin = messageForMixedMsg.frienduin;
                            arrayList.add(messageRecord);
                        }
                    }
                }
            } else {
                arrayList.add(chatMessage);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MessageRecord messageRecord2 = (MessageRecord) it.next();
            if (messageRecord2 != null) {
                String str2 = messageRecord2.senderuin;
                if (!(messageRecord2 instanceof MessageForText) && !(messageRecord2 instanceof MessageForLongMsg)) {
                    if (messageRecord2 instanceof MessageForPic) {
                        MessageForPic messageForPic = (MessageForPic) messageRecord2;
                        if (TextUtils.isEmpty(messageForPic.uuid)) {
                            messageForPic.parse();
                        }
                        plainText = messageForPic.uuid;
                        str = "2";
                    } else if (messageRecord2 instanceof MessageForStructing) {
                        AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord2).structingMsg;
                        if (absStructMsg != null) {
                            plainText = h(absStructMsg.getXml(), false);
                            str = "3";
                            z16 = true;
                            if (!z16 && !TextUtils.isEmpty(plainText)) {
                                try {
                                    plainText = plainText.replace("\"", "\\\"").replace("'", "\\'").replace("|", "\\|").replace(":", "\\:").replace(";", "\\;").replace("[", "\\[").replace("]", "\\]").replace(ContainerUtils.KEY_VALUE_DELIMITER, "\\=").replace("\n", "");
                                } catch (Throwable th5) {
                                    QLog.e("NewReportPlugin", 1, th5, new Object[0]);
                                }
                            }
                            sb5.setLength(0);
                            sb5.append("[");
                            sb5.append("uin=");
                            sb5.append(str2);
                            sb5.append(";");
                            sb5.append("content=");
                            sb5.append(plainText);
                            sb5.append(";");
                            sb5.append("type=");
                            sb5.append(str);
                            sb5.append("]");
                            arrayList2.add(sb5.toString());
                        }
                    } else if (messageRecord2 instanceof MessageForShortVideo) {
                        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord2;
                        if (TextUtils.isEmpty(messageForShortVideo.uuid)) {
                            messageForShortVideo.parse();
                        }
                        plainText = messageForShortVideo.uuid;
                        str = "5";
                    } else {
                        if (messageRecord2 instanceof MessageForFile) {
                            MessageForFile messageForFile = (MessageForFile) messageRecord2;
                            if (TextUtils.isEmpty(messageForFile.urlAtServer)) {
                                messageForFile.parse();
                            }
                            plainText = messageForFile.urlAtServer;
                        } else if (messageRecord2 instanceof MessageForTroopFile) {
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) messageRecord2;
                            if (TextUtils.isEmpty(messageForTroopFile.url)) {
                                messageForTroopFile.parse();
                            }
                            plainText = messageForTroopFile.url;
                        } else if (messageRecord2 instanceof MessageForPtt) {
                            MessageForPtt messageForPtt = (MessageForPtt) messageRecord2;
                            if (TextUtils.isEmpty(messageForPtt.urlAtServer)) {
                                messageForPtt.parse();
                            }
                            plainText = messageForPtt.urlAtServer;
                            str = "7";
                        }
                        str = "6";
                    }
                } else {
                    plainText = new QQText(messageRecord2.f203106msg, 3).toPlainText();
                    str = "1";
                }
                z16 = false;
                if (!z16) {
                    plainText = plainText.replace("\"", "\\\"").replace("'", "\\'").replace("|", "\\|").replace(":", "\\:").replace(";", "\\;").replace("[", "\\[").replace("]", "\\]").replace(ContainerUtils.KEY_VALUE_DELIMITER, "\\=").replace("\n", "");
                }
                sb5.setLength(0);
                sb5.append("[");
                sb5.append("uin=");
                sb5.append(str2);
                sb5.append(";");
                sb5.append("content=");
                sb5.append(plainText);
                sb5.append(";");
                sb5.append("type=");
                sb5.append(str);
                sb5.append("]");
                arrayList2.add(sb5.toString());
            }
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("chatmsg:");
        int size = arrayList2.size() > 50 ? arrayList2.size() - 50 : 0;
        while (size < arrayList2.size()) {
            sb6.append((String) arrayList2.get(size));
            size++;
        }
        return sb6.toString();
    }

    public static String l(int i3) {
        if (i3 != 20001) {
            if (i3 != 20008) {
                if (i3 != 20010) {
                    if (i3 != 20020) {
                        if (i3 != 21001) {
                            return "";
                        }
                        ad adVar = ad.f97536a;
                        return "10010";
                    }
                    ad adVar2 = ad.f97536a;
                    return "10034";
                }
                ad adVar3 = ad.f97536a;
                return "10033";
            }
            ad adVar4 = ad.f97536a;
            return "10097";
        }
        ad adVar5 = ad.f97536a;
        return "10045";
    }

    public static String m(Activity activity, int i3, String str, Bundle bundle) {
        String str2 = "";
        if (i3 != 25099) {
            return "";
        }
        Object obj = bundle.get("chatuin");
        if (obj instanceof String) {
            str2 = (String) obj;
        }
        String str3 = "channel_id=" + str2 + "|tinyid=" + str;
        long q16 = q(activity, str2);
        if (q16 != 0) {
            return str3 + "|roomid=" + q16;
        }
        return str3;
    }

    private static String n() {
        if (f97302a) {
            return f97304c;
        }
        return f97303b;
    }

    public static String o(String str) {
        try {
            return new JSONObject(str).getString("key");
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "abcdabcdabcdabcd";
        }
    }

    public static String p(int i3) {
        return "6bW#X@~L.+X)4%$>";
    }

    private static long q(Activity activity, String str) {
        IGProChannelInfo channelInfo;
        if (!(activity instanceof QBaseActivity) || (channelInfo = ((IGPSService) ((QBaseActivity) activity).getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(str)) == null) {
            return 0L;
        }
        return channelInfo.getLiveRoomId();
    }

    public static String r(QQAppInterface qQAppInterface, String str, String str2, int i3, Bundle bundle) {
        GetMsgReq F = F(str, str2, i3, bundle);
        List<MessageRecord> N = qQAppInterface.getMessageFacade().N(F.getUin(), F.getUinType(), F.getMaxCount());
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("getMsgForReport [%s, %s, %s, %s]", F.getUin(), Integer.valueOf(F.getUinType()), Integer.valueOf(i3), Integer.valueOf(N.size())));
        }
        return s(str, str2, i3, F.getMaxCount(), N);
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String s(String str, String str2, int i3, int i16, List<MessageRecord> list) {
        int i17;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z16;
        AbsStructMsg absStructMsg;
        ArrayList arrayList = new ArrayList();
        for (MessageRecord messageRecord : list) {
            if (messageRecord instanceof MessageForMixedMsg) {
                MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) messageRecord;
                List<MessageRecord> list2 = messageForMixedMsg.msgElemList;
                if (list2 != null) {
                    for (MessageRecord messageRecord2 : list2) {
                        if (y(messageRecord2)) {
                            messageRecord2.istroop = messageForMixedMsg.istroop;
                            messageRecord2.senderuin = messageForMixedMsg.senderuin;
                            messageRecord2.selfuin = messageForMixedMsg.selfuin;
                            messageRecord2.frienduin = messageForMixedMsg.frienduin;
                            arrayList.add(messageRecord2);
                        }
                    }
                }
            } else if (y(messageRecord)) {
                if (!(messageRecord instanceof MessageForText) && !(messageRecord instanceof MessageForLongMsg)) {
                    arrayList.add(messageRecord);
                } else if (messageRecord.msgtype == -1000) {
                    arrayList.add(messageRecord);
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            i17 = 0;
            if (!it.hasNext()) {
                break;
            }
            MessageRecord messageRecord3 = (MessageRecord) it.next();
            if (messageRecord3 != null) {
                int i18 = messageRecord3.istroop;
                if (i18 != 1000 && i18 != 1004) {
                    str3 = messageRecord3.senderuin;
                } else if (messageRecord3.isSend()) {
                    str3 = messageRecord3.selfuin;
                } else {
                    str3 = messageRecord3.frienduin;
                }
                if ((i3 != 20008 && i3 != 20013) || TextUtils.isEmpty(str2) || TextUtils.equals(str3, str)) {
                    if (i3 != 20012 || TextUtils.equals(str3, str)) {
                        if (messageRecord3 instanceof MessageForPic) {
                            MessageForPic messageForPic = (MessageForPic) messageRecord3;
                            messageForPic.parse();
                            str4 = messageForPic.uuid;
                            str5 = "2";
                        } else if (!(messageRecord3 instanceof MessageForText) && !(messageRecord3 instanceof MessageForLongMsg)) {
                            if ((messageRecord3 instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord3).structingMsg) != null) {
                                str4 = h(absStructMsg.getXml(), false);
                                z16 = true;
                                str6 = "3";
                                if (!z16) {
                                    try {
                                        str4 = str4.replace("\"", "\\\"").replace("'", "\\'").replace("|", "\\|").replace(":", "\\:").replace(";", "\\;").replace("[", "\\[").replace("]", "\\]").replace(ContainerUtils.KEY_VALUE_DELIMITER, "\\=").replace("\n", "");
                                    } catch (Throwable th5) {
                                        th5.printStackTrace();
                                    }
                                }
                                sb5.setLength(0);
                                sb5.append("[");
                                sb5.append("uin=");
                                sb5.append(str3);
                                sb5.append(";");
                                sb5.append("content=");
                                sb5.append(str4);
                                sb5.append(";");
                                sb5.append("type=");
                                sb5.append(str6);
                                sb5.append("]");
                                arrayList2.add(sb5.toString());
                            }
                        } else {
                            str4 = new QQText(messageRecord3.f203106msg, 3).toPlainText();
                            str5 = "1";
                        }
                        str6 = str5;
                        z16 = false;
                        if (!z16) {
                        }
                        sb5.setLength(0);
                        sb5.append("[");
                        sb5.append("uin=");
                        sb5.append(str3);
                        sb5.append(";");
                        sb5.append("content=");
                        sb5.append(str4);
                        sb5.append(";");
                        sb5.append("type=");
                        sb5.append(str6);
                        sb5.append("]");
                        arrayList2.add(sb5.toString());
                    }
                }
            }
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("chatmsg:");
        if (arrayList2.size() > i16) {
            i17 = arrayList2.size() - i16;
        }
        while (i17 < arrayList2.size()) {
            sb6.append((String) arrayList2.get(i17));
            i17++;
        }
        return sb6.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String t(String str, String str2, int i3, int i16, List<MsgRecord> list) {
        int i17;
        String fileUuid;
        String str3;
        String str4;
        boolean z16;
        String xmlContent;
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : list) {
            if (z(msgRecord)) {
                arrayList.add(msgRecord);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            i17 = 0;
            if (!it.hasNext()) {
                break;
            }
            MsgRecord msgRecord2 = (MsgRecord) it.next();
            if (msgRecord2 != null) {
                String valueOf = String.valueOf(msgRecord2.getSenderUin());
                if ((i3 != 20008 && i3 != 20013) || TextUtils.isEmpty(str2) || TextUtils.equals(valueOf, str)) {
                    if (i3 != 20012 || TextUtils.equals(valueOf, str)) {
                        if (A(msgRecord2)) {
                            fileUuid = msgRecord2.getElements().get(0).getPicElement().getFileUuid();
                            str3 = "2";
                        } else if (C(msgRecord2)) {
                            fileUuid = new QQText(msgRecord2.getElements().get(0).getTextElement().getContent(), 3).toPlainText();
                            str3 = "1";
                        } else if (B(msgRecord2) && msgRecord2.getElements() != null && msgRecord2.getElements().get(0) != null && msgRecord2.getElements().get(0).getStructMsgElement() != null && (xmlContent = msgRecord2.getElements().get(0).getStructMsgElement().getXmlContent()) != null) {
                            fileUuid = h(xmlContent, false);
                            z16 = true;
                            str4 = "3";
                            if (!z16) {
                                try {
                                    fileUuid = fileUuid.replace("\"", "\\\"").replace("'", "\\'").replace("|", "\\|").replace(":", "\\:").replace(";", "\\;").replace("[", "\\[").replace("]", "\\]").replace(ContainerUtils.KEY_VALUE_DELIMITER, "\\=").replace("\n", "");
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                            sb5.setLength(0);
                            sb5.append("[");
                            sb5.append("uin=");
                            sb5.append(valueOf);
                            sb5.append(";");
                            sb5.append("content=");
                            sb5.append(fileUuid);
                            sb5.append(";");
                            sb5.append("type=");
                            sb5.append(str4);
                            sb5.append("]");
                            arrayList2.add(sb5.toString());
                        }
                        str4 = str3;
                        z16 = false;
                        if (!z16) {
                        }
                        sb5.setLength(0);
                        sb5.append("[");
                        sb5.append("uin=");
                        sb5.append(valueOf);
                        sb5.append(";");
                        sb5.append("content=");
                        sb5.append(fileUuid);
                        sb5.append(";");
                        sb5.append("type=");
                        sb5.append(str4);
                        sb5.append("]");
                        arrayList2.add(sb5.toString());
                    }
                }
            }
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("chatmsg:");
        if (arrayList2.size() > i16) {
            i17 = arrayList2.size() - i16;
        }
        while (i17 < arrayList2.size()) {
            sb6.append((String) arrayList2.get(i17));
            i17++;
        }
        return sb6.toString();
    }

    public static int u(int i3) {
        int i16;
        if (i3 == 1) {
            i16 = 20008;
        } else if (i3 == 3000) {
            i16 = 20013;
        } else if (i3 == 1004) {
            i16 = IPermissionType.MODIFY_WORLD_CHANNEL;
        } else if (i3 == 0) {
            i16 = 21000;
        } else if (i3 == 1044) {
            i16 = 20015;
        } else if (i3 == 1045) {
            i16 = 25020;
        } else if (i3 == 1000) {
            i16 = 20016;
        } else if (i3 == 1022) {
            i16 = 20017;
        } else if (i3 == 10002) {
            i16 = BaseConstants.ERR_SVR_MSG_DEL_RAMBLE_INTERNAL_ERROR;
        } else if (i3 == 1001) {
            i16 = 20004;
        } else if (i3 == 1034) {
            i16 = 21002;
        } else if (i3 == 1033) {
            i16 = 21003;
        } else if (i3 == 1006) {
            i16 = 20020;
        } else if (i3 == 10008) {
            i16 = 25022;
        } else if (i3 == 10010) {
            i16 = 25028;
        } else if (i3 == 10007) {
            i16 = 25095;
        } else if (i3 == 1043) {
            i16 = 1110;
        } else {
            i16 = 20002;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("chattype2scene: [%s, %s]", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        return i16;
    }

    public static String v(int i3) {
        if (i3 != 22000) {
            if (i3 != 22001) {
                if (i3 != 25098) {
                    if (i3 != 25099) {
                        switch (i3) {
                            case 1110:
                                return "group_robot";
                            case 22003:
                                return "group_info";
                            case 25004:
                                return "c2c_chat_pop";
                            case 25020:
                                return "kuolie_feed_c2c";
                            case 25022:
                                return "stg_wezone_c2c";
                            case 25044:
                                return "c2c_stg_peiwan";
                            case 25054:
                                return "c2c_video";
                            case 25080:
                                return "qq_station_ugc";
                            case 25082:
                                return "qq_station_uin";
                            case 25086:
                                return "qq_station";
                            case 25090:
                                return "qq_station_audio_channel";
                            case 25095:
                                return "gamebox_c2c";
                            case 2220478:
                                return "QQpindaohuatizipindao_socialinteraction_2220478";
                            case 2220482:
                                return "QQpindao_socialinteraction_2220482";
                            case 2720075:
                                return "QQpindao_socialinteraction_2720075";
                            default:
                                switch (i3) {
                                    case 20001:
                                        return "stg_profile";
                                    case 20002:
                                        return "stg_single_chat";
                                    case 20003:
                                        return "nearby_info";
                                    case 20004:
                                        return "nearby_chat";
                                    case 20005:
                                        return "nearby_kuoli";
                                    case 20006:
                                        return "nearby_fjdt";
                                    case 20007:
                                        return "nearby_yan_zhi_pei_dui";
                                    case 20008:
                                        return "person_in_group";
                                    case 20009:
                                        return "stg_invite_togroup";
                                    case 20010:
                                        return "stg_add_friend";
                                    case 20011:
                                        return "stg_apply_for_group";
                                    case 20012:
                                        return "nearby_hotchat";
                                    case 20013:
                                        return "person_in_discuss";
                                    case 20014:
                                        return "stg_kuolie_group";
                                    case 20015:
                                        return "stg_kuolie_c2c";
                                    case 20016:
                                        return "stg_group_c2c";
                                    case 20017:
                                        return "stg_checkmsg_c2c";
                                    case BaseConstants.ERR_SVR_MSG_DEL_RAMBLE_INTERNAL_ERROR /* 20018 */:
                                        return "stg_buluo_c2c";
                                    case IPermissionType.MODIFY_WORLD_CHANNEL /* 20019 */:
                                        return "stg_discuss_c2c";
                                    case 20020:
                                        return "stg_addressbook_c2c";
                                    default:
                                        switch (i3) {
                                            case 21000:
                                                return "c2c_chat";
                                            case 21001:
                                                return "c2c_info";
                                            case 21002:
                                                return "c2c_honest_say";
                                            case 21003:
                                                return "c2c_honest_friend";
                                            default:
                                                switch (i3) {
                                                    case 25028:
                                                        return "stg_sound_chat";
                                                    case 25029:
                                                        return "stg_anonymous_c2c";
                                                    case 25030:
                                                        return "c2c_friendsuccess";
                                                    case 25031:
                                                        return "vide_game";
                                                    default:
                                                        switch (i3) {
                                                            case 25060:
                                                                return "person_in_group_action";
                                                            case 25061:
                                                                return "stg_c2c_action";
                                                            case 25062:
                                                                return "c2c_chat_action";
                                                            default:
                                                                switch (i3) {
                                                                    case 2220329:
                                                                    case 2220330:
                                                                    case 2220331:
                                                                        return "kuolie_new_singlechat_" + i3;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 2220369:
                                                                                return "kuolie_new_groupconversation_2220369";
                                                                            case 2220370:
                                                                                return "kuolie_new_singlechat_2220370";
                                                                            case 2220371:
                                                                                return "kuolie_new_singlechat_2220371";
                                                                            default:
                                                                                return "";
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    }
                    return "non_live_broadcast";
                }
                return "channel_live_telecast";
            }
            return "discuss_mobile";
        }
        return "group_chat";
    }

    private static boolean w(int i3) {
        if (i3 != 2220478 && i3 != 2220482 && i3 != 2720075) {
            return false;
        }
        return true;
    }

    private static boolean x(int i3) {
        if ((i3 >= 2220329 && i3 <= 2220331) || (i3 >= 2220369 && i3 <= 2220371)) {
            return true;
        }
        return false;
    }

    public static boolean y(MessageRecord messageRecord) {
        if (!(messageRecord instanceof MessageForText) && !(messageRecord instanceof MessageForLongMsg) && !(messageRecord instanceof MessageForStructing) && !(messageRecord instanceof MessageForPic) && !(messageRecord instanceof MessageForMixedMsg)) {
            return false;
        }
        return true;
    }

    public static boolean z(MsgRecord msgRecord) {
        Iterator<MsgElement> it = msgRecord.getElements().iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.getTextElement() != null || next.getStructLongMsgElement() != null || next.getPicElement() != null || next.getStructMsgElement() != null) {
                return true;
            }
        }
        return false;
    }
}
