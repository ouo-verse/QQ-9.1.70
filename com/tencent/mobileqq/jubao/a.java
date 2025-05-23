package com.tencent.mobileqq.jubao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.inputmethod.InputMethodManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.dt.api.JubaoMsgData;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.i;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msgselect.api.IMsgSelectFragmentApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f238922d;

    /* renamed from: e, reason: collision with root package name */
    private String f238923e;

    /* renamed from: f, reason: collision with root package name */
    private String f238924f;

    /* renamed from: h, reason: collision with root package name */
    private String f238925h;

    /* renamed from: i, reason: collision with root package name */
    private final String f238926i;

    /* renamed from: m, reason: collision with root package name */
    private String f238927m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.jubao.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C7953a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        C7953a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
            } else if (eIPCResult.code == 0) {
                a.this.D(0, eIPCResult.data.getBoolean("receive_success"), eIPCResult.data);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238926i = "0x800A851";
            this.f238927m = HardCodeUtil.qqStr(R.string.nim);
        }
    }

    public static String A(List<ChatMessage> list) {
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ChatMessage> it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.mo162put(c.b(it.next()).toJson());
                } catch (JsonORM.JsonParseException e16) {
                    QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
                }
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static String B(List<AIOMsgItem> list) {
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<AIOMsgItem> it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.mo162put(c.a(it.next()).toJson());
                } catch (JsonORM.JsonParseException e16) {
                    QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
                }
            }
            return jSONArray.toString();
        }
        return "";
    }

    private String C(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f238925h)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String e16 = NewReportPlugin.e(jSONObject.optString("chatuin", ""), NewReportPlugin.p(1));
                QLog.i("jubaoApiPlugin", 1, "replaceChatuin(), origin ChatUin == " + e16 + ", mCurrentChannelId == " + this.f238925h);
                if (!TextUtils.isEmpty(this.f238925h) && !TextUtils.equals(e16, this.f238925h)) {
                    jSONObject.put("chatuin", NewReportPlugin.j(this.f238925h, NewReportPlugin.p(1)));
                    return jSONObject.toString();
                }
                return str;
            } catch (JSONException e17) {
                QLog.e("jubaoApiPlugin", 1, e17, new Object[0]);
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    private void E(String... strArr) {
        int i3;
        int i16;
        int i17;
        ?? r26;
        int i18;
        ?? r27;
        String str = "jubao_matchfriend_sig";
        if (!NetworkUtil.isNetworkAvailable(this.mRuntime.a())) {
            callJs(this.f238923e, r(5, ""));
            return;
        }
        String str2 = strArr[0];
        if (x(str2)) {
            str2 = C(strArr[0]);
        }
        QLog.i("jubaoApiPlugin", 1, "uploadChatMsg(), json == " + str2);
        if (TextUtils.isEmpty(str2)) {
            callJs(this.f238923e, r(0, ""));
            QLog.d("jubaoApiPlugin", 1, "doUploadChatMsg js args is empty ");
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("eviluin", "");
                String optString2 = jSONObject.optString("chatuin", "");
                String optString3 = jSONObject.optString("groupcode", "");
                int optInt = jSONObject.optInt("chattype", 0);
                if (!TextUtils.isEmpty(optString2)) {
                    optString2 = NewReportPlugin.e(optString2, NewReportPlugin.p(1));
                }
                try {
                    JubaoMsgData[] jubaoMsgDataArr = (JubaoMsgData[]) JsonORM.parseFrom(new JSONArray(jSONObject.optString("msgs")), JubaoMsgData.class);
                    ArrayList arrayList = new ArrayList();
                    try {
                        int i19 = 0;
                        for (int length = jubaoMsgDataArr.length; i19 < length; length = length) {
                            arrayList.add(jubaoMsgDataArr[i19]);
                            i19++;
                        }
                        this.f238923e = jSONObject.optString("callback", "");
                        try {
                            if (arrayList.size() == 0) {
                                QLog.e("jubaoApiPlugin", 2, "ipc upload  to msgServer msg size = 0 ");
                                try {
                                    String r16 = r(1, "");
                                    String str3 = this.f238923e;
                                    String[] strArr2 = new String[1];
                                    try {
                                        strArr2[0] = r16;
                                        callJs(str3, strArr2);
                                        return;
                                    } catch (JSONException e16) {
                                        e = e16;
                                        i16 = 0;
                                        i17 = 2;
                                        i3 = 1;
                                        String r17 = r(i17, "");
                                        String str4 = this.f238923e;
                                        String[] strArr3 = new String[i3];
                                        strArr3[i16] = r17;
                                        callJs(str4, strArr3);
                                        QLog.e("jubaoApiPlugin", i3, e, new Object[i16]);
                                        return;
                                    }
                                } catch (JSONException e17) {
                                    e = e17;
                                    i3 = 1;
                                    i18 = 2;
                                    i16 = 0;
                                    i17 = i18;
                                    String r172 = r(i17, "");
                                    String str42 = this.f238923e;
                                    String[] strArr32 = new String[i3];
                                    strArr32[i16] = r172;
                                    callJs(str42, strArr32);
                                    QLog.e("jubaoApiPlugin", i3, e, new Object[i16]);
                                    return;
                                }
                            }
                            if (QLog.isColorLevel()) {
                                try {
                                    QLog.d("jubaoApiPlugin", 2, "ipc upload  msg size = " + arrayList.size() + ", chatUin = " + optString2 + ", " + arrayList.toString());
                                } catch (JsonORM.JsonParseException e18) {
                                    e = e18;
                                    r26 = 2;
                                    callJs(this.f238923e, r(r26, ""));
                                    QLog.e("jubaoApiPlugin", 1, e, new Object[0]);
                                    return;
                                } catch (JSONException e19) {
                                    e = e19;
                                    r27 = 2;
                                    i3 = 1;
                                    i18 = r27;
                                    i16 = 0;
                                    i17 = i18;
                                    String r1722 = r(i17, "");
                                    String str422 = this.f238923e;
                                    String[] strArr322 = new String[i3];
                                    strArr322[i16] = r1722;
                                    callJs(str422, strArr322);
                                    QLog.e("jubaoApiPlugin", i3, e, new Object[i16]);
                                    return;
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("jubao_evil_uin", optString);
                            bundle.putString("jubao_chat_uin", optString2);
                            bundle.putString("jubao_group_code", optString3);
                            bundle.putInt("jubao_chat_type", optInt);
                            bundle.putSerializable("jubao_msg_list", arrayList);
                            if (optInt == 10007) {
                                String s16 = s("jubao_game_sig");
                                bundle.putString("jubao_game_sig", s16);
                                if (QLog.isColorLevel()) {
                                    QLog.i("jubaoApiPlugin", 2, "gameSig = " + s16);
                                }
                            } else if (optInt == 1001) {
                                bundle.putString("jubao_nearby_sig", s("jubao_nearby_sig"));
                            } else if (optInt == 1046) {
                                bundle.putString("jubao_matchfriend_sig", s("jubao_matchfriend_sig"));
                            } else if (optInt == 119) {
                                bundle.putString("jubao_nearbypro_sig", s("jubao_nearbypro_sig"));
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("jubaoApiPlugin", 2, "ipc upload concent, evilUin = " + optString + ", chatUin =" + optString2 + "\uff0c groupCode = " + optString3 + "\uff0c chatType =" + optInt + "\uff0cjubaoMsgDataArrayList = " + arrayList);
                            }
                            QIPCClientHelper.getInstance().callServer("JubaoIPCServer", "", bundle, new C7953a());
                            ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, "", "", "", "");
                        } catch (JsonORM.JsonParseException e26) {
                            e = e26;
                            r26 = str;
                        } catch (JSONException e27) {
                            e = e27;
                            r27 = str;
                        }
                    } catch (JSONException e28) {
                        e = e28;
                        r27 = 2;
                    }
                } catch (JSONException e29) {
                    e = e29;
                    i3 = 1;
                }
            } catch (JSONException e36) {
                e = e36;
                i3 = 1;
                i16 = 0;
                i17 = 2;
            }
        } catch (JsonORM.JsonParseException e37) {
            e = e37;
            r26 = 2;
        }
    }

    private void p(int i3, String str, String str2, Bundle bundle) {
        Intent intent = new Intent();
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        if (i3 == 119) {
            l3 = 119;
        }
        if (i3 == 1003) {
            l3 = 1;
        }
        if (com.tencent.nt.adapter.session.c.e(i3) || i3 == 1003) {
            str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (TextUtils.isEmpty(str)) {
                QQToast makeText = QQToast.makeText(BaseApplication.context, R.string.f1359202r, 1);
                makeText.show(makeText.getTitleBarHeight());
                return;
            }
        }
        intent.putExtra("key_peerId", str);
        QLog.d("jubaoApiPlugin", 1, String.format("doJumpChatMsg chatType:%d uid:%s nick:%s", Integer.valueOf(l3), str, str2));
        intent.putExtra("key_chat_type", l3);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("key_chat_name", str2);
        }
        intent.putExtra("key_from", 1001);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setClass(this.mRuntime.a(), QPublicFragmentActivity.class);
        intent.putExtra("public_fragment_class", ((IMsgSelectFragmentApi) QRoute.api(IMsgSelectFragmentApi.class)).getFragmentClass().getName());
        intent.putExtras(bundle);
        startActivityForResult(intent, (byte) 0);
    }

    public static String q(List<AIOMsgItem> list) {
        int size = list.size();
        String B = B(list);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgcount", size);
            jSONObject.put("msgs", B);
        } catch (JSONException e16) {
            QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
        }
        return jSONObject.toString();
    }

    public static String r(int i3, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i3);
            jSONObject.put("uuid", str);
        } catch (JSONException e16) {
            QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
        }
        return jSONObject.toString();
    }

    private String s(String str) {
        String str2 = this.f238924f;
        if (str2 == null) {
            return "";
        }
        for (String str3 : str2.split(ContainerUtils.FIELD_DELIMITER)) {
            if (str3.startsWith(str)) {
                return str3.split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
            }
        }
        return "";
    }

    private String t(String... strArr) {
        if (!TextUtils.isEmpty(strArr[0])) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("eviluin", "");
                this.f238924f = new String(this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData"));
                if (TextUtils.equals(s("is_need_open_channel_select_fragment"), "1")) {
                    return jSONObject.optString("groupcode", "");
                }
                return optString;
            } catch (JSONException e16) {
                QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
            }
        }
        return "";
    }

    private void u(Intent intent, int i3) {
        if (i3 == -1) {
            String stringExtra = intent.getStringExtra("extra_key_return_selected_channel_id");
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra("extra_key_return_selected_channel_old_param"));
                jSONObject.put("chatuin", NewReportPlugin.j(stringExtra, NewReportPlugin.p(1)));
                y(jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
            }
        }
    }

    private boolean v(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("chattype", 0);
        String optString = jSONObject.optString("groupcode", "");
        if (optInt == 10014 && TextUtils.isEmpty(optString)) {
            return false;
        }
        this.f238924f = new String(this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData"));
        return TextUtils.equals(s("isdirectmsg"), "1");
    }

    private boolean w(String... strArr) {
        if (!TextUtils.isEmpty(strArr[0])) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                int optInt = jSONObject.optInt("chattype", 0);
                String optString = jSONObject.optString("groupcode", "");
                if (optInt == 10014 && TextUtils.isEmpty(optString)) {
                    return true;
                }
                this.f238924f = new String(this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData"));
                if (TextUtils.equals(s("is_need_open_channel_select_fragment"), "1")) {
                    return true;
                }
            } catch (JSONException e16) {
                QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
            }
        }
        return false;
    }

    private boolean x(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                int optInt = new JSONObject(str).optInt("chattype", 0);
                QLog.i("jubaoApiPlugin", 1, "judgeChatTypeIsGuild(), chatType == " + optInt);
                if (optInt != 10014) {
                    return false;
                }
                return true;
            } catch (JSONException e16) {
                QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011d A[Catch: JSONException -> 0x01f2, JsonParseException -> 0x01f6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JsonParseException -> 0x01f6, blocks: (B:112:0x004c, B:9:0x0054, B:11:0x005a, B:16:0x0061, B:29:0x006e, B:31:0x0074, B:34:0x0085, B:35:0x0087, B:36:0x00b5, B:38:0x00d3, B:40:0x00e9, B:42:0x00f6, B:48:0x010b, B:53:0x0115, B:59:0x011d, B:62:0x012f, B:64:0x0137, B:65:0x0143, B:67:0x014f, B:68:0x0152, B:72:0x0177, B:90:0x019f, B:91:0x01b9, B:98:0x01d4, B:99:0x01da, B:100:0x01e0, B:102:0x01e8, B:103:0x01eb), top: B:111:0x004c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y(String... strArr) {
        int i3;
        int i16;
        String str;
        String str2;
        ArrayList arrayList;
        String str3;
        String str4 = strArr[0];
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        int i17 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str4);
            String optString = jSONObject.optString("chatuin", "");
            String optString2 = jSONObject.optString("groupcode", "");
            int optInt = jSONObject.optInt("chattype", 0);
            int optInt2 = jSONObject.optInt("topicid", 0);
            String optString3 = jSONObject.optString("uinname", "");
            String optString4 = jSONObject.optString("msgs");
            boolean v3 = v(jSONObject);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    try {
                        optString = NewReportPlugin.e(optString, NewReportPlugin.p(1));
                    } catch (JSONException e16) {
                        e = e16;
                        i16 = i17;
                        i3 = 0;
                        QLog.e("jubaoApiPlugin", i16, e, new Object[i3]);
                        return;
                    }
                } catch (JsonORM.JsonParseException e17) {
                    e = e17;
                    i3 = 0;
                    QLog.e("jubaoApiPlugin", 1, e, new Object[i3]);
                    return;
                }
            }
            if (!TextUtils.isEmpty(optString3)) {
                try {
                } catch (JsonORM.JsonParseException e18) {
                    e = e18;
                    i3 = 0;
                    QLog.e("jubaoApiPlugin", 1, e, new Object[i3]);
                    return;
                } catch (JSONException e19) {
                    e = e19;
                    i3 = 0;
                }
                try {
                    optString3 = new String(Base64.decode(optString3, 0));
                } catch (JSONException e26) {
                    e = e26;
                    i3 = 0;
                    i16 = 1;
                    QLog.e("jubaoApiPlugin", i16, e, new Object[i3]);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                str = "uinname";
                Object[] objArr = new Object[7];
                objArr[0] = "jubaoApiPlugin";
                try {
                    objArr[1] = optString;
                    str2 = optString;
                    objArr[2] = Integer.valueOf(optInt);
                    objArr[3] = optString2;
                    objArr[4] = Integer.valueOf(optInt2);
                    objArr[5] = optString3;
                    objArr[6] = str4;
                    QLog.i("NewReportPlugin", 2, String.format("%s jumpChatMsg [%s, %s, %s, %s, %s] json=%s", objArr));
                } catch (JSONException e27) {
                    e = e27;
                    i16 = 1;
                    i3 = 0;
                    QLog.e("jubaoApiPlugin", i16, e, new Object[i3]);
                    return;
                }
            } else {
                str = "uinname";
                str2 = optString;
            }
            this.f238924f = new String(this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData"));
            if (!TextUtils.isEmpty(optString4)) {
                JubaoMsgData[] jubaoMsgDataArr = (JubaoMsgData[]) JsonORM.parseFrom(new JSONArray(optString4), JubaoMsgData.class);
                arrayList = new ArrayList();
                int i18 = 0;
                for (int length = jubaoMsgDataArr.length; i18 < length; length = length) {
                    arrayList.add(jubaoMsgDataArr[i18]);
                    i18++;
                }
            } else {
                arrayList = null;
            }
            this.f238922d = jSONObject.optString("callback", "");
            if (optInt != 1 && optInt != 3000) {
                str3 = str2;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        QLog.d("jubaoApiPlugin", 1, "jumpChatMsg openChatUin is null");
                        return;
                    } catch (JSONException e28) {
                        e = e28;
                        i16 = 1;
                        i3 = 0;
                        QLog.e("jubaoApiPlugin", i16, e, new Object[i3]);
                        return;
                    }
                }
                Activity a16 = this.mRuntime.a();
                Bundle bundle = new Bundle();
                if (optInt == 10014) {
                    String name = com.tencent.guild.aio.factory.a.class.getName();
                    if (v3) {
                        name = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getDirectFactoryName();
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("msgs", optString4);
                    i17 = 1;
                    bundle2.putBoolean("entrance_from_jubao", true);
                    bundle2.putString("penetrate_to_chat_activity", str4);
                    bundle2.putInt("AIOParam_FromScene", FromScene.JUBAO.ordinal());
                    try {
                        i3 = 0;
                        try {
                            startActivityForResult(((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(a16, new i().f(optString2).b(str3).d(name).c(false).e(bundle2).a()), (byte) 0);
                            return;
                        } catch (JsonORM.JsonParseException e29) {
                            e = e29;
                            QLog.e("jubaoApiPlugin", 1, e, new Object[i3]);
                            return;
                        } catch (JSONException e36) {
                            e = e36;
                            i16 = 1;
                            QLog.e("jubaoApiPlugin", i16, e, new Object[i3]);
                            return;
                        }
                    } catch (JsonORM.JsonParseException e37) {
                        e = e37;
                        i3 = 0;
                    } catch (JSONException e38) {
                        e = e38;
                        i3 = 0;
                    }
                } else {
                    if (optInt == 10007) {
                        String s16 = s("friendroleid");
                        String s17 = s("myroleid");
                        bundle.putString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, s16);
                        bundle.putString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, s17);
                    }
                    bundle.putString("uin", str3);
                    bundle.putInt("uintype", optInt);
                    if (!TextUtils.isEmpty(optString3)) {
                        if (optInt != 1033 && optInt != 1034) {
                            bundle.putString(str, optString3);
                        }
                        bundle.putString(ConfessInfo.KEY_CONFESSOR_NICK, optString3);
                    }
                    bundle.putInt(ConfessInfo.KEY_CONFESS_TOPICID, optInt2);
                    if (arrayList != null) {
                        bundle.putSerializable("msgs", arrayList);
                    }
                    bundle.putString("penetrate_to_chat_activity", str4);
                    p(optInt, str3, optString3, bundle);
                    return;
                }
            }
            str3 = optString2;
            if (!TextUtils.isEmpty(str3)) {
            }
        } catch (JsonORM.JsonParseException e39) {
            e = e39;
            i3 = 0;
        } catch (JSONException e46) {
            e = e46;
            i3 = 0;
            i16 = 1;
        }
    }

    private void z(String... strArr) {
        String t16 = t(strArr);
        if (!TextUtils.isEmpty(t16)) {
            Intent intent = new Intent();
            intent.setClass(this.mRuntime.a(), QPublicFragmentActivity.class);
            intent.putExtra("public_fragment_class", ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getQQGuildSelectChannelFragmentClass().getName());
            intent.putExtra("extra_guild_id", t16);
            intent.putExtra("extra_select_channel_origin_param", strArr[0]);
            startActivityForResult(intent, (byte) 1);
        }
    }

    public void D(int i3, boolean z16, Bundle bundle) {
        String str;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        QLog.e("jubaoApiPlugin", 2, "receiver msgServer resp  isSucesss =  " + z16);
        ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 3, 0, "", "", "", "");
        if (i3 == 0) {
            if (z16 && bundle != null) {
                str = bundle.getString("jubao_uuid");
                i16 = bundle.getInt("jubao_result_code", 0);
                i17 = 0;
            } else {
                if (bundle == null) {
                    str = "";
                    i16 = 0;
                } else {
                    i16 = bundle.getInt("jubao_result_code", 1);
                    str = "";
                }
                i17 = 1;
            }
            callJs(this.f238923e, r(i16, str));
            QLog.d("jubaoApiPlugin", 1, "upload resp uuid = " + str + ",result = " + i16);
            i18 = i16;
            i19 = i17;
        }
        ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, "" + i19, "" + i18, "", "");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str, String... strArr) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) strArr);
            return;
        }
        if (str != null && (str2 = this.f238923e) != null && str.equals(str2)) {
            ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 4, 0, "", "", "", "");
        }
        super.callJs(str, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "jubao";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        QLog.d("jubaoApiPlugin", 1, "handleJsRequest methodName= " + str3);
        if ("jubao".equals(str2)) {
            if ("selectMsgs".equalsIgnoreCase(str3)) {
                if (strArr != null && strArr.length > 0) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.mRuntime.a().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.mRuntime.a().getWindow().getDecorView().getWindowToken(), 0);
                    }
                    if (w(strArr)) {
                        z(strArr);
                    } else {
                        y(strArr);
                    }
                    ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 0, 0, "0", "", "", "");
                }
                return true;
            }
            if ("uploadMsgs".equalsIgnoreCase(str3)) {
                if (strArr != null && strArr.length > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("jubaoApiPlugin", 2, "method = " + str3 + "\uff0cargs[0] = " + strArr[0]);
                    }
                    E(strArr[0]);
                } else {
                    i3 = 1;
                }
                ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 1, 0, "" + i3, "", "", "");
                return true;
            }
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        QLog.d("jubaoApiPlugin", 1, "onActivityResult resultCode=" + i3);
        super.onActivityResult(intent, b16, i3);
        if (b16 == 0) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("msgs");
                this.f238925h = intent.getStringExtra("chatuin");
                if (QLog.isDevelopLevel()) {
                    QLog.d("jubaoApiPlugin", 4, "onActivityResult msgs= " + stringExtra + ", mCurrentChannelId == " + this.f238925h);
                }
                callJs(this.f238922d, stringExtra);
                return;
            }
            if (intent != null) {
                str = intent.getStringExtra("penetrate_to_chat_activity");
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d("jubaoApiPlugin", 2, "onActivityResult user cancel select msg = " + str);
            }
            if (w(str)) {
                z(str);
                return;
            }
            return;
        }
        if (b16 == 1) {
            u(intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void startActivityForResult(Intent intent, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, Byte.valueOf(b16));
        } else {
            QLog.e("jubaoApiPlugin", 1, "startActivityForResult ");
            super.startActivityForResult(intent, b16);
        }
    }
}
