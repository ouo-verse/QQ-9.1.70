package com.tencent.biz.TroopRedpoint;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.nearby.redtouch.d;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qphone.base.util.QLog;
import hd0.c;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791$GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TroopRedTouchManager implements Manager {
    public static final String F = String.valueOf(System.currentTimeMillis());
    Map<Long, oidb_0x791$RedDotInfo> C;
    private BroadcastReceiver D;
    protected int E;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f78336d;

    /* renamed from: e, reason: collision with root package name */
    final String f78337e;

    /* renamed from: f, reason: collision with root package name */
    final String f78338f;

    /* renamed from: h, reason: collision with root package name */
    final String f78339h;

    /* renamed from: i, reason: collision with root package name */
    oidb_0x791$GetRedDotRes f78340i;

    /* renamed from: m, reason: collision with root package name */
    boolean f78341m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(CloudStorageServlet.REQUEST_TYPE, 0);
            QLog.i(TroopRedTouchManager.this.f78339h, 2, "receive request" + intent.getExtras());
            if (intExtra == 1) {
                Intent intent2 = new Intent();
                intent2.setAction("com.tencent.mobileqq.NearbyJsInterface");
                intent2.putExtra("command_type", 1);
                intent2.putExtra("data", TroopRedTouchManager.this.t());
                TroopRedTouchManager.this.f78336d.getApp().sendBroadcast(intent2);
            }
        }
    }

    public TroopRedTouchManager(QQAppInterface qQAppInterface) {
        this(qQAppInterface, null);
    }

    private synchronized void A(Map<Long, oidb_0x791$RedDotInfo> map) {
        if (map == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f78339h, 2, "saveLocalFileList, size =" + map.size());
        }
        final String d16 = d(map);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.TroopRedpoint.TroopRedTouchManager.3
            @Override // java.lang.Runnable
            public void run() {
                String absolutePath = new File(TroopRedTouchManager.this.f78336d.getApplication().getFilesDir(), "TroopRedTouchManager2_All" + TroopRedTouchManager.this.f78336d.getCurrentAccountUin()).getAbsolutePath();
                synchronized (TroopRedTouchManager.this) {
                    try {
                        FileUtils.pushData2File(absolutePath, PluginBaseInfoHelper.Base64Helper.encode(d16.getBytes(), 0), false);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TroopRedTouchManager.this.f78339h + LogTag.TAG_TAB_RED_POINT, 2, "saveLocalFileList Exception,e =" + e16.getMessage());
                        }
                    }
                }
            }
        }, 5, null, false);
    }

    private void C(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (oidb_0x791_reddotinfo.msg_nearby_entrance_extend_config.has() && oidb_0x791_reddotinfo.msg_nearby_entrance_extend_config.bool_has_hintWord.has() && oidb_0x791_reddotinfo.msg_nearby_entrance_extend_config.bool_has_hintWord.get() && oidb_0x791_reddotinfo.msg_nearby_entrance_extend_config.str_hintWord.has()) {
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f78336d.getCurrentAccountUin(), INearbySPUtil.KEY_NEARBY_RED_DOT_ASSIST_TEXT, oidb_0x791_reddotinfo.msg_nearby_entrance_extend_config.str_hintWord.get().toStringUtf8());
        }
        if (oidb_0x791_reddotinfo.msg_word_corner_red_dot.has() && oidb_0x791_reddotinfo.msg_word_corner_red_dot.bool_enable.has() && oidb_0x791_reddotinfo.msg_word_corner_red_dot.bool_enable.get() && oidb_0x791_reddotinfo.msg_word_corner_red_dot.bool_switch_to_word_corner.has() && oidb_0x791_reddotinfo.msg_word_corner_red_dot.bool_switch_to_word_corner.get() && oidb_0x791_reddotinfo.msg_word_corner_red_dot.str_hintText.has()) {
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f78336d.getCurrentAccountUin(), INearbySPUtil.KEY_NEARBY_RED_DOT_CORNER_TEXT, oidb_0x791_reddotinfo.msg_word_corner_red_dot.str_hintText.get().toStringUtf8());
        }
    }

    private void D(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (oidb_0x791_reddotinfo.uint32_appid.get() == 60 && oidb_0x791_reddotinfo.str_custom_buffer.has()) {
            try {
                JSONObject jSONObject = new JSONObject(oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8());
                if (jSONObject.optInt("is_comment") == 1) {
                    ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f78336d.getCurrentAccountUin(), INearbySPUtil.KEY_MSG_BOX_COMMENT_ZAN_RED_DOT_TYPE, Integer.valueOf(jSONObject.optInt("comment_red_dot_type")));
                }
            } catch (Exception e16) {
                QLog.e(LogTag.TAG_NEARBY_RED_POINT, 1, "get msgBoxCommentZan error: " + e16.getMessage());
            }
        }
    }

    private void E(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (oidb_0x791_reddotinfo.uint32_appid.get() == 60 && oidb_0x791_reddotinfo.str_custom_buffer.has()) {
            try {
                JSONObject jSONObject = new JSONObject(oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8());
                if (jSONObject.optInt("is_c2c") == 1) {
                    ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f78336d.getCurrentAccountUin(), INearbySPUtil.KEY_MSG_BOX_SAY_HELLO_RED_DOT_TYPE, Integer.valueOf(jSONObject.optInt("say_hello_red_dot_type")));
                }
            } catch (Exception e16) {
                QLog.e(LogTag.TAG_NEARBY_RED_POINT, 1, "get msgBoxSayHelloType error: " + e16.getMessage());
            }
        }
    }

    private void F() {
        try {
            this.f78336d.getApp().unregisterReceiver(this.D);
        } catch (IllegalArgumentException unused) {
            QLog.e(this.f78339h, 1, "[stopTalk2NearbyJsInterface] not register");
        }
    }

    private String d(Map<Long, oidb_0x791$RedDotInfo> map) {
        if (map == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Long l3 : map.keySet()) {
                if (l3 != null && map.get(l3) != null) {
                    jSONObject.put(String.valueOf(l3), PluginBaseInfoHelper.Base64Helper.encodeToString(map.get(l3).toByteArray(), 0));
                }
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            PlayerUtils.log(6, this.f78339h, "convertHashMapToJSONString: JSONException when convert HashMap data - " + e16.getMessage());
            return "";
        }
    }

    private synchronized oidb_0x791$GetRedDotRes g() {
        oidb_0x791$GetRedDotRes oidb_0x791_getreddotres;
        NullPointerException e16;
        InvalidProtocolBufferMicroException e17;
        try {
            byte[] fileToBytes = FileUtils.fileToBytes(new File(this.f78336d.getApplication().getFilesDir(), "TroopRedTouchManager2_" + this.f78336d.getCurrentAccountUin()));
            oidb_0x791_getreddotres = new oidb_0x791$GetRedDotRes();
            if (fileToBytes != null) {
                try {
                    oidb_0x791_getreddotres.mergeFrom(fileToBytes);
                } catch (InvalidProtocolBufferMicroException e18) {
                    e17 = e18;
                    e17.printStackTrace();
                    return oidb_0x791_getreddotres;
                } catch (NullPointerException e19) {
                    e16 = e19;
                    e16.printStackTrace();
                    return oidb_0x791_getreddotres;
                }
            }
        } catch (InvalidProtocolBufferMicroException e26) {
            oidb_0x791_getreddotres = null;
            e17 = e26;
        } catch (NullPointerException e27) {
            oidb_0x791_getreddotres = null;
            e16 = e27;
        }
        return oidb_0x791_getreddotres;
    }

    private synchronized Map<Long, oidb_0x791$RedDotInfo> h() {
        HashMap hashMap;
        hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(new String(PluginBaseInfoHelper.Base64Helper.decode(FileUtils.fileToBytes(new File(this.f78336d.getApplication().getFilesDir(), "TroopRedTouchManager2_All" + this.f78336d.getCurrentAccountUin())), 0)));
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = new oidb_0x791$RedDotInfo();
                oidb_0x791_reddotinfo.mergeFrom(PluginBaseInfoHelper.Base64Helper.decode((String) jSONObject.get(str), 0));
                hashMap.put(Long.valueOf(Long.parseLong(str)), oidb_0x791_reddotinfo);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f78339h, 2, "getLocalRedInfoMsgList, size =" + hashMap.size());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t() {
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.f78340i.rpt_msg_reddot_info.size(); i3++) {
            oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = this.f78340i.rpt_msg_reddot_info.get(i3);
            if (oidb_0x791_reddotinfo.str_custom_buffer.has()) {
                try {
                    JSONObject jSONObject = new JSONObject(oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8());
                    if (jSONObject.optInt("is_web_care") == 1) {
                        jSONArray.mo162put(jSONObject.optString("web_red_dot_data"));
                    }
                } catch (Exception e16) {
                    QLog.e(LogTag.TAG_NEARBY_RED_POINT, 1, "get webCareRedDotInfo error: " + e16.getMessage());
                    return "";
                }
            }
        }
        return jSONArray.toString();
    }

    private void v(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (oidb_0x791_reddotinfo.str_custom_buffer.has()) {
            try {
                JSONObject jSONObject = new JSONObject(oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8());
                if (jSONObject.optInt("is_web_care") == 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mobileqq.NearbyJsInterface");
                    intent.putExtra("command_type", 2);
                    intent.putExtra("data", jSONObject.optString("web_red_dot_data"));
                    this.f78336d.getApp().sendBroadcast(intent);
                }
            } catch (Exception e16) {
                QLog.e(LogTag.TAG_NEARBY_RED_POINT, 1, "get push for web: " + e16.getMessage());
            }
        }
    }

    private void w() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
        this.f78336d.getApp().registerReceiver(this.D, intentFilter);
    }

    public static String y(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (oidb_0x791_reddotinfo == null) {
            return "";
        }
        return "redDotInfo2String, oidb_0x791.RedDotInfo:uint32_appid:" + oidb_0x791_reddotinfo.uint32_appid.get() + "|redDotInfo.bool_display_reddot:" + oidb_0x791_reddotinfo.bool_display_reddot.get() + "|uint32_number:" + oidb_0x791_reddotinfo.uint32_number.get() + "|uint32_reason:" + oidb_0x791_reddotinfo.uint32_reason.get() + "|uint32_last_time:" + oidb_0x791_reddotinfo.uint32_last_time.get() + "|uint64_cmd_uin:" + oidb_0x791_reddotinfo.uint64_cmd_uin.get() + "|uint32_cmd_uin_type:" + oidb_0x791_reddotinfo.uint32_cmd_uin_type.get() + "|str_face_url:" + oidb_0x791_reddotinfo.str_face_url.get().toStringUtf8() + "|str_custom_buffer:" + oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8() + "|uint32_expire_time:" + oidb_0x791_reddotinfo.uint32_expire_time.get();
    }

    private synchronized void z(final oidb_0x791$GetRedDotRes oidb_0x791_getreddotres) {
        if (oidb_0x791_getreddotres == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.TroopRedpoint.TroopRedTouchManager.2
            @Override // java.lang.Runnable
            public void run() {
                String absolutePath = new File(TroopRedTouchManager.this.f78336d.getApplication().getFilesDir(), "TroopRedTouchManager2_" + TroopRedTouchManager.this.f78336d.getCurrentAccountUin()).getAbsolutePath();
                synchronized (TroopRedTouchManager.this) {
                    try {
                        FileUtils.pushData2File(absolutePath, oidb_0x791_getreddotres.toByteArray(), false);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    StringBuilder sb5 = new StringBuilder("saveLocalFile==>");
                    for (int i3 = 0; i3 < oidb_0x791_getreddotres.rpt_msg_reddot_info.size(); i3++) {
                        sb5.append(TroopRedTouchManager.y(oidb_0x791_getreddotres.rpt_msg_reddot_info.get(i3)));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TroopRedTouchManager.this.f78339h + LogTag.TAG_TAB_RED_POINT, 2, sb5.toString());
                    }
                }
            }
        }, 5, null, false);
    }

    public synchronized void B(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (this.f78340i == null) {
            this.f78340i = g();
        }
        if (this.f78340i != null && oidb_0x791_reddotinfo != null) {
            int i3 = oidb_0x791_reddotinfo.uint32_appid.get();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_RED_POINT, 2, "set\uff1aappId=" + i3 + ", uin=" + oidb_0x791_reddotinfo.uint64_cmd_uin.get() + ", hasRed=" + oidb_0x791_reddotinfo.bool_display_reddot.get());
            }
            C(oidb_0x791_reddotinfo);
            E(oidb_0x791_reddotinfo);
            D(oidb_0x791_reddotinfo);
            v(oidb_0x791_reddotinfo);
            boolean z16 = false;
            for (int i16 = 0; i16 < this.f78340i.rpt_msg_reddot_info.size(); i16++) {
                oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2 = this.f78340i.rpt_msg_reddot_info.get(i16);
                if (oidb_0x791_reddotinfo2.uint32_appid.get() == i3) {
                    if (i3 != 56 && i3 != 61) {
                        this.f78340i.rpt_msg_reddot_info.set(i16, oidb_0x791_reddotinfo);
                        z16 = true;
                        break;
                    }
                    if (oidb_0x791_reddotinfo2.uint64_cmd_uin.get() == oidb_0x791_reddotinfo.uint64_cmd_uin.get()) {
                        this.f78340i.rpt_msg_reddot_info.set(i16, oidb_0x791_reddotinfo);
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_NEARBY_RED_POINT, 2, "APPID_NEARBY_CONCERN_UPDATE, onPush\uff1ahas same uin reddot, uin=" + oidb_0x791_reddotinfo.uint64_cmd_uin.get());
                        }
                        z16 = true;
                        break;
                    }
                }
            }
            if (!z16) {
                this.f78340i.rpt_msg_reddot_info.add(oidb_0x791_reddotinfo);
            }
            z(this.f78340i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[Catch: Exception -> 0x0057, TRY_ENTER, TryCatch #0 {Exception -> 0x0057, blocks: (B:42:0x0044, B:44:0x004c, B:14:0x005a, B:17:0x0069, B:19:0x0074, B:20:0x0083, B:22:0x0089, B:23:0x0079, B:25:0x007f, B:26:0x008d, B:28:0x0095, B:29:0x009f, B:31:0x00a5, B:32:0x00b0, B:40:0x00ab), top: B:41:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:42:0x0044, B:44:0x004c, B:14:0x005a, B:17:0x0069, B:19:0x0074, B:20:0x0083, B:22:0x0089, B:23:0x0079, B:25:0x007f, B:26:0x008d, B:28:0x0095, B:29:0x009f, B:31:0x00a5, B:32:0x00b0, B:40:0x00ab), top: B:41:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:42:0x0044, B:44:0x004c, B:14:0x005a, B:17:0x0069, B:19:0x0074, B:20:0x0083, B:22:0x0089, B:23:0x0079, B:25:0x007f, B:26:0x008d, B:28:0x0095, B:29:0x009f, B:31:0x00a5, B:32:0x00b0, B:40:0x00ab), top: B:41:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:42:0x0044, B:44:0x004c, B:14:0x005a, B:17:0x0069, B:19:0x0074, B:20:0x0083, B:22:0x0089, B:23:0x0079, B:25:0x007f, B:26:0x008d, B:28:0x0095, B:29:0x009f, B:31:0x00a5, B:32:0x00b0, B:40:0x00ab), top: B:41:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo, oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2) {
        int i3;
        String stringUtf8;
        JSONObject jSONObject;
        if (oidb_0x791_reddotinfo != null && oidb_0x791_reddotinfo.uint32_last_time.has()) {
            i3 = oidb_0x791_reddotinfo.uint32_last_time.get();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.f78339h, 2, "TENCENT_DOCS_ASSISTANT  show redDot" + oidb_0x791_reddotinfo2.bool_display_reddot.get());
        }
        if (!oidb_0x791_reddotinfo2.bool_display_reddot.get()) {
            String str = null;
            if (oidb_0x791_reddotinfo != null) {
                try {
                    if (oidb_0x791_reddotinfo.str_custom_buffer.has()) {
                        stringUtf8 = oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8();
                        String str2 = "";
                        if (!TextUtils.isEmpty(stringUtf8)) {
                            JSONObject jSONObject2 = new JSONObject(stringUtf8);
                            if (jSONObject2.has("lastMsg")) {
                                str2 = jSONObject2.getString("lastMsg");
                            } else if (jSONObject2.has("msg")) {
                                str2 = jSONObject2.getString("msg");
                            }
                            if (jSONObject2.has("lastTime")) {
                                i3 = jSONObject2.getInt("lastTime");
                            }
                        }
                        if (oidb_0x791_reddotinfo2.str_custom_buffer.has()) {
                            str = oidb_0x791_reddotinfo2.str_custom_buffer.get().toStringUtf8();
                        }
                        if (TextUtils.isEmpty(str)) {
                            jSONObject = new JSONObject(str);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("lastMsg", str2);
                        jSONObject.put("lastTime", i3);
                        oidb_0x791_reddotinfo2.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(jSONObject.toString()));
                    }
                } catch (Exception e16) {
                    QLog.e(this.f78339h, 1, "parse tencentDocs redDot info error" + e16.getMessage());
                    return;
                }
            }
            stringUtf8 = null;
            String str22 = "";
            if (!TextUtils.isEmpty(stringUtf8)) {
            }
            if (oidb_0x791_reddotinfo2.str_custom_buffer.has()) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            jSONObject.put("lastMsg", str22);
            jSONObject.put("lastTime", i3);
            oidb_0x791_reddotinfo2.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(jSONObject.toString()));
        }
    }

    public synchronized void b(int i3) {
        Map<Long, oidb_0x791$RedDotInfo> map = this.C;
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<Long, oidb_0x791$RedDotInfo>> it = this.C.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().uint32_appid.get() == i3) {
                    it.remove();
                }
            }
            A(this.C);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6 A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:6:0x0020, B:8:0x0024, B:9:0x002a, B:14:0x0030, B:16:0x003c, B:22:0x0048, B:24:0x0054, B:28:0x006f, B:29:0x0067, B:32:0x0072, B:33:0x00cb, B:35:0x00d6, B:41:0x008c, B:43:0x0099, B:47:0x00c1, B:48:0x00ac, B:52:0x00c6), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void c(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_NEARBY_RED_POINT, 2, "clearStoryRedPointByAppId\uff1aappId=" + i3);
        }
        if (this.f78340i == null) {
            this.f78340i = g();
        }
        if (this.f78340i == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("clearStoryRedPointByAppId==>[");
        if (i3 == 38) {
            b(i3);
        }
        if (i3 != 56 && i3 != 61) {
            int size = this.f78340i.rpt_msg_reddot_info.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = this.f78340i.rpt_msg_reddot_info.get(size);
                if (oidb_0x791_reddotinfo.bool_display_reddot.get() && oidb_0x791_reddotinfo.uint32_appid.get() == i3) {
                    this.f78340i.rpt_msg_reddot_info.remove(size);
                    TroopRedTouchHandler.F2(this.f78336d, oidb_0x791_reddotinfo);
                    sb5.append(y(oidb_0x791_reddotinfo));
                    sb5.append("]");
                    break;
                }
                size--;
            }
            z(this.f78340i);
            if (QLog.isColorLevel()) {
                QLog.d(this.f78339h + LogTag.TAG_TAB_RED_POINT, 2, sb5.toString());
            }
        }
        oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2 = null;
        for (int size2 = this.f78340i.rpt_msg_reddot_info.size() - 1; size2 >= 0; size2--) {
            oidb_0x791$RedDotInfo oidb_0x791_reddotinfo3 = this.f78340i.rpt_msg_reddot_info.get(size2);
            if (oidb_0x791_reddotinfo3.uint32_appid.get() == i3) {
                this.f78340i.rpt_msg_reddot_info.remove(size2);
                sb5.append(y(oidb_0x791_reddotinfo3));
                sb5.append("] [");
                oidb_0x791_reddotinfo2 = oidb_0x791_reddotinfo3;
            }
        }
        if (oidb_0x791_reddotinfo2 != null) {
            TroopRedTouchHandler.F2(this.f78336d, oidb_0x791_reddotinfo2);
        }
        z(this.f78340i);
        if (QLog.isColorLevel()) {
        }
    }

    public synchronized oidb_0x791$RedDotInfo e(int i3) {
        if (this.f78340i == null) {
            this.f78340i = g();
        }
        oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = null;
        if (this.f78340i == null) {
            return null;
        }
        int i16 = 0;
        while (true) {
            if (i16 >= this.f78340i.rpt_msg_reddot_info.size()) {
                break;
            }
            oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2 = this.f78340i.rpt_msg_reddot_info.get(i16);
            if (i3 == oidb_0x791_reddotinfo2.uint32_appid.get() && oidb_0x791_reddotinfo2.bool_display_reddot.get()) {
                oidb_0x791_reddotinfo = oidb_0x791_reddotinfo2;
                break;
            }
            i16++;
        }
        return oidb_0x791_reddotinfo;
    }

    public oidb_0x791$RedDotInfo f(int i3, boolean z16) {
        if (this.f78340i == null) {
            this.f78340i = g();
        }
        if (this.f78340i == null) {
            return null;
        }
        for (int i16 = 0; i16 < this.f78340i.rpt_msg_reddot_info.size(); i16++) {
            oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = this.f78340i.rpt_msg_reddot_info.get(i16);
            if (i3 == oidb_0x791_reddotinfo.uint32_appid.get() && (!z16 || oidb_0x791_reddotinfo.bool_display_reddot.get())) {
                return oidb_0x791_reddotinfo;
            }
        }
        return null;
    }

    public BusinessInfoCheckUpdate.RedTypeInfo i() {
        if (e(65) != null) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_content.set("");
            redTypeInfo.red_desc.set("");
            return redTypeInfo;
        }
        return null;
    }

    public BusinessInfoCheckUpdate.RedTypeInfo j() {
        if (e(42) != null) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_content.set("");
            redTypeInfo.red_desc.set("");
            return redTypeInfo;
        }
        return null;
    }

    public synchronized d k() {
        boolean z16;
        d dVar = new d();
        if (this.C == null) {
            this.C = h();
        }
        if (this.C.size() <= 0) {
            return dVar;
        }
        Iterator<Map.Entry<Long, oidb_0x791$RedDotInfo>> it = this.C.entrySet().iterator();
        while (it.hasNext()) {
            oidb_0x791$RedDotInfo value = it.next().getValue();
            if (value.uint32_appid.get() == 38) {
                String stringUtf8 = value.str_custom_buffer.get().toStringUtf8();
                try {
                    dVar.f253077a = value.uint32_number.get();
                    JSONObject jSONObject = new JSONObject(stringUtf8);
                    if (jSONObject.optInt("official_topic") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        dVar.f253078b++;
                    }
                    int optInt = jSONObject.optInt("red_content_type");
                    if (optInt == 1) {
                        dVar.f253079c++;
                    } else if (optInt == 2) {
                        dVar.f253080d++;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        return dVar;
    }

    public synchronized INearbyRedInfo l(boolean z16, boolean z17) {
        INearbyRedInfo iNearbyRedInfo;
        ((TroopRedTouchManager) this.f78336d.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).u();
        iNearbyRedInfo = (INearbyRedInfo) QRoute.api(INearbyRedInfo.class);
        QLog.d(LogTag.TAG_NEARBY_RED_POINT, 1, "getNearbyRedPoint, don't needShow");
        iNearbyRedInfo.setRedAppIdType(0);
        return iNearbyRedInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7 A[Catch: all -> 0x013b, TryCatch #4 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x000b, B:13:0x001b, B:15:0x0025, B:20:0x0059, B:22:0x0061, B:24:0x006b, B:62:0x007a, B:65:0x0080, B:30:0x00a7, B:37:0x00be, B:41:0x00d4, B:43:0x00da, B:39:0x00e4, B:46:0x00e1, B:48:0x00f0, B:50:0x0103, B:52:0x0111, B:55:0x0117, B:57:0x011e, B:58:0x0122, B:70:0x0094, B:80:0x009b), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0139 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BusinessInfoCheckUpdate.RedTypeInfo m() {
        String str;
        oidb_0x791$RedDotInfo oidb_0x791_reddotinfo;
        oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2;
        int i3;
        boolean z16;
        if (this.f78340i == null) {
            this.f78340i = g();
        }
        if (this.f78340i == null) {
            return null;
        }
        String str2 = "";
        long j3 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z17 = false;
        while (i16 < this.f78340i.rpt_msg_reddot_info.size()) {
            oidb_0x791_reddotinfo = this.f78340i.rpt_msg_reddot_info.get(i16);
            i17 = oidb_0x791_reddotinfo.uint32_number.get();
            z17 = oidb_0x791_reddotinfo.bool_display_reddot.get();
            j3 = oidb_0x791_reddotinfo.uint64_cmd_uin.get();
            str = oidb_0x791_reddotinfo.str_face_url.get().toStringUtf8();
            if (38 == oidb_0x791_reddotinfo.uint32_appid.get() && (z17 || i17 > 0)) {
                if (oidb_0x791_reddotinfo.str_custom_buffer.has()) {
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        oidb_0x791_reddotinfo2 = null;
                    }
                    if (new JSONObject(oidb_0x791_reddotinfo.str_custom_buffer.get().toStringUtf8()).optInt("official_topic") == 1) {
                        try {
                            i3 = oidb_0x791_reddotinfo.uint32_number.get();
                            try {
                                z16 = oidb_0x791_reddotinfo.bool_display_reddot.get();
                                oidb_0x791_reddotinfo2 = oidb_0x791_reddotinfo;
                            } catch (Exception e17) {
                                e = e17;
                                oidb_0x791_reddotinfo2 = oidb_0x791_reddotinfo;
                                e.printStackTrace();
                                z16 = false;
                                if (oidb_0x791_reddotinfo != null) {
                                }
                            }
                        } catch (Exception e18) {
                            e = e18;
                            oidb_0x791_reddotinfo2 = oidb_0x791_reddotinfo;
                            i3 = 0;
                            e.printStackTrace();
                            z16 = false;
                            if (oidb_0x791_reddotinfo != null) {
                            }
                        }
                        if (oidb_0x791_reddotinfo != null) {
                            return null;
                        }
                        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                        INearbyRedDotCustomInfo iNearbyRedDotCustomInfo = (INearbyRedDotCustomInfo) QRoute.api(INearbyRedDotCustomInfo.class);
                        iNearbyRedDotCustomInfo.parse(oidb_0x791_reddotinfo);
                        if (z17 || z16) {
                            if (i17 > 0) {
                                String valueOf = String.valueOf(i17);
                                redTypeInfo.red_type.set(5);
                                redTypeInfo.red_content.set(valueOf);
                                if (oidb_0x791_reddotinfo.str_custom_buffer.has()) {
                                    try {
                                        if (!iNearbyRedDotCustomInfo.getIsOfficialNum()) {
                                            redTypeInfo.red_type.set(0);
                                        }
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
                                    }
                                }
                                redTypeInfo.red_desc.set(n(str, j3, iNearbyRedDotCustomInfo));
                            } else if (oidb_0x791_reddotinfo2 != null) {
                                String stringUtf8 = oidb_0x791_reddotinfo2.str_custom_buffer.get().toStringUtf8();
                                redTypeInfo.red_content.set(String.valueOf(i3));
                                try {
                                    if (new JSONObject(stringUtf8).optInt("red_type") != 0) {
                                        redTypeInfo.red_type.set(0);
                                    } else {
                                        redTypeInfo.red_type.set(5);
                                    }
                                } catch (Exception e26) {
                                    e26.printStackTrace();
                                }
                            } else {
                                redTypeInfo.red_type.set(0);
                                redTypeInfo.red_content.set("");
                                redTypeInfo.red_desc.set("");
                            }
                        }
                        return redTypeInfo;
                    }
                    oidb_0x791_reddotinfo2 = null;
                    i3 = 0;
                    z16 = false;
                    if (oidb_0x791_reddotinfo != null) {
                    }
                } else {
                    oidb_0x791_reddotinfo2 = null;
                    i3 = 0;
                    z16 = false;
                    if (oidb_0x791_reddotinfo != null) {
                    }
                }
            } else {
                i16++;
                str2 = str;
            }
        }
        str = str2;
        oidb_0x791_reddotinfo = null;
        oidb_0x791_reddotinfo2 = null;
        i3 = 0;
        z16 = false;
        if (oidb_0x791_reddotinfo != null) {
        }
    }

    public String n(String str, long j3, INearbyRedDotCustomInfo iNearbyRedDotCustomInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("faceUrl", str);
            jSONObject.put("uin", j3);
            jSONObject.put("isOfficialNotify", iNearbyRedDotCustomInfo.getIsOfficialNotify());
            jSONObject.put("redContentType", iNearbyRedDotCustomInfo.getContentType());
            jSONObject.put("redContentMsg", iNearbyRedDotCustomInfo.getContentMsg());
            jSONObject.put("topicId", iNearbyRedDotCustomInfo.getTopicId());
            jSONObject.put("msgId", iNearbyRedDotCustomInfo.getRecommendPeopleMsgId());
            jSONObject.put(MessageRoamJsPlugin.USERTYPE, iNearbyRedDotCustomInfo.getUserType());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public BusinessInfoCheckUpdate.RedTypeInfo o() {
        oidb_0x791$RedDotInfo e16 = e(24);
        oidb_0x791$RedDotInfo e17 = e(27);
        if ((e16 != null && e16.bool_display_reddot.get()) || (e17 != null && e17.bool_display_reddot.get())) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_content.set("");
            redTypeInfo.red_desc.set("");
            return redTypeInfo;
        }
        return null;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        z(this.f78340i);
        F();
    }

    public synchronized oidb_0x791$RedDotInfo p() {
        if (this.f78340i == null) {
            this.f78340i = g();
        }
        oidb_0x791$GetRedDotRes oidb_0x791_getreddotres = this.f78340i;
        if (oidb_0x791_getreddotres == null) {
            return null;
        }
        oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = null;
        for (oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2 : oidb_0x791_getreddotres.rpt_msg_reddot_info.get()) {
            if (oidb_0x791_reddotinfo2.bool_display_reddot.get()) {
                int i3 = oidb_0x791_reddotinfo2.uint32_appid.get();
                if (com.tencent.biz.TroopRedpoint.a.f(i3)) {
                    if (i3 == 37 && oidb_0x791_reddotinfo2.uint32_expire_time.get() < NetConnInfoCenter.getServerTime()) {
                        c.v(this.f78339h, "%d red dot time out", Integer.valueOf(i3));
                    } else if (i3 != 48 && com.tencent.biz.TroopRedpoint.a.a(oidb_0x791_reddotinfo2, oidb_0x791_reddotinfo) > 0) {
                        oidb_0x791_reddotinfo = oidb_0x791_reddotinfo2;
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TAB_RED_POINT, 2, "return:" + y(oidb_0x791_reddotinfo));
        }
        return null;
    }

    public int q() {
        oidb_0x791$RedDotInfo p16 = p();
        if (p16 == null) {
            return 0;
        }
        int i3 = p16.uint32_appid.get();
        if (i3 != 8) {
            if (i3 != 11) {
                if (i3 != 35) {
                    if (i3 == 37) {
                        return 8;
                    }
                    if (i3 != 52) {
                        return 0;
                    }
                    return 3;
                }
                return 2;
            }
            return 4;
        }
        return 1;
    }

    public int r() {
        oidb_0x791$RedDotInfo p16 = p();
        if (p16 == null) {
            return 0;
        }
        return p16.uint32_report_type.get();
    }

    public BusinessInfoCheckUpdate.RedTypeInfo s() {
        oidb_0x791$RedDotInfo e16 = e(23);
        oidb_0x791$RedDotInfo e17 = e(26);
        if ((e16 != null && e16.bool_display_reddot.get()) || (e17 != null && e17.bool_display_reddot.get())) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_content.set("");
            redTypeInfo.red_desc.set("");
            return redTypeInfo;
        }
        return null;
    }

    public BusinessInfoCheckUpdate.RedTypeInfo u() {
        if (e(25) != null) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_content.set("");
            redTypeInfo.red_desc.set("");
            return redTypeInfo;
        }
        return null;
    }

    public boolean x() {
        String currentAccountUin = this.f78336d.getCurrentAccountUin();
        return PreferenceManager.getDefaultSharedPreferences(this.f78336d.getApp()).getBoolean("troop_nearby_red_point_state_" + currentAccountUin, true);
    }

    public TroopRedTouchManager(QQAppInterface qQAppInterface, oidb_0x791$GetRedDotRes oidb_0x791_getreddotres) {
        this.f78337e = "TroopRedTouchManager2_";
        this.f78338f = "TroopRedTouchManager2_All";
        this.f78339h = TroopRedTouchManager.class.getSimpleName();
        this.f78341m = false;
        this.C = null;
        this.D = new a();
        this.E = 0;
        this.f78336d = qQAppInterface;
        if (oidb_0x791_getreddotres != null) {
            this.f78340i = oidb_0x791_getreddotres;
        }
        w();
    }
}
