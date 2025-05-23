package p05;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqlive.api.impl.QQLiveUtilImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IlivePluginService;
import cooperation.ilive.util.QQLiveGuardManager;
import cooperation.qzone.remote.ServiceConst;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static a f424878d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f424879e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private String f424880a;

    /* renamed from: b, reason: collision with root package name */
    private String f424881b;

    /* renamed from: c, reason: collision with root package name */
    private String f424882c;

    a() {
    }

    private void a() {
        QQLiveGuardManager.f390141d.d();
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) IlivePluginService.class);
        intent.setAction("action_enter_room");
        intent.putExtra("extra_key_mqq_schema", this.f424882c);
        intent.putExtra("extra_key_timestamp", System.currentTimeMillis());
        long j3 = QQLiveUtilImpl.preloadProcessTimestamp;
        if (j3 > 0) {
            intent.putExtra("EXTRA_KEY_PRELOAD_TIMESTAMP", j3);
        }
        BaseApplication.getContext().startService(intent);
    }

    public static a c() {
        if (f424878d == null) {
            synchronized (f424879e) {
                if (f424878d == null) {
                    f424878d = new a();
                }
            }
        }
        return f424878d;
    }

    private String d() {
        if (TextUtils.isEmpty(this.f424881b)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(this.f424881b);
        return Uri.encode(jSONArray.toString());
    }

    private void e(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.H;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{activity_id}", str2);
    }

    private void f(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.D;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{anchor_id}", str2);
    }

    private void g(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.C;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{extdata}", str2);
    }

    private void h(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.f417965u;
        if (str2 == null) {
            str2 = "0";
        }
        this.f424882c = str.replace("{jump_start_time}", str2);
    }

    private void i(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.f417961q;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{qq_live_product_type}", str2);
    }

    private void j(n05.a aVar) {
        this.f424882c = this.f424882c.replace("{pip}", "false");
    }

    private void k(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.f417963s;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{rcmd_context}", str2);
    }

    private void l(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.f417964t;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{translucent_page}", str2);
    }

    private void m(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.I;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{auto_open_pendant_id}", str2);
    }

    private void n(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.F;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{scene_id}", str2);
    }

    private void o(n05.a aVar) {
        String str = this.f424882c;
        String str2 = aVar.f417966v;
        if (str2 == null) {
            str2 = "";
        }
        this.f424882c = str.replace("{showmore}", str2);
    }

    public void b(n05.a aVar) {
        String account;
        CharSequence charSequence;
        if (aVar != null && !TextUtils.isEmpty(aVar.f417947c)) {
            QLog.e("IliveLiteHelper", 1, "enterRoom");
            this.f424880a = aVar.f417947c;
            this.f424881b = aVar.f417948d;
            String str = "";
            if (TextUtils.isEmpty(aVar.f417952h)) {
                aVar.f417952h = "";
            }
            if (TextUtils.isEmpty(this.f424881b)) {
                this.f424881b = "";
            }
            String str2 = "0";
            if (TextUtils.isEmpty(aVar.B)) {
                aVar.B = "0";
            }
            if (TextUtils.isEmpty(aVar.f417954j)) {
                aVar.f417954j = "";
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                account = "";
            } else {
                account = peekAppRuntime.getAccount();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(account);
            String str3 = "_";
            sb5.append("_");
            sb5.append(System.currentTimeMillis());
            String sb6 = sb5.toString();
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(aVar.f417954j)) {
                    jSONObject = new JSONObject(Uri.decode(aVar.f417954j));
                }
                jSONObject.put(ServiceConst.PARA_SESSION_ID, sb6);
                aVar.f417954j = jSONObject.toString();
            } catch (Exception unused) {
                QLog.e("IliveLiteHelper", 1, "");
            }
            this.f424882c = "mqqapi://now/openroom?roomtype=0&fromid=1037&roomid={roomId}&coverurl={coverurl}&videoUrl={videoUrl}&pageType=1&starttime={startTime}&nocleartop={nocleartop}&tool_state={tool_state}&closeJump={closeJump}&fromid={fromid}&trace_info={trace_info}&session_id={session_id}&first_click_time={first_click_time}&traceId={traceId}&room_type={room_type}&game_id={game_id}&game_tag_id={game_tag_id}&video_source={video_source}&qq_live_product_type={qq_live_product_type}&pip={pip}&rcmd_context={rcmd_context}&translucent_page={translucent_page}&jump_start_time={jump_start_time}&auto_open_url={auto_open_url}&auto_open_page_style={auto_open_page_style}&showmore={showmore}&level={level}&default_tab_id={default_tab_id}&gamelive_custom_params={gamelive_custom_params}&jumpcmd={jumpcmd}&extdata={extdata}&anchor_id={anchor_id}&scene_id={scene_id}&qz_gdt={qz_gdt}&activity_id={activity_id}&auto_open_pendant_id={auto_open_pendant_id}&auto_open_luckybag={auto_open_luckybag}&auto_download={auto_download}";
            String replace = "mqqapi://now/openroom?roomtype=0&fromid=1037&roomid={roomId}&coverurl={coverurl}&videoUrl={videoUrl}&pageType=1&starttime={startTime}&nocleartop={nocleartop}&tool_state={tool_state}&closeJump={closeJump}&fromid={fromid}&trace_info={trace_info}&session_id={session_id}&first_click_time={first_click_time}&traceId={traceId}&room_type={room_type}&game_id={game_id}&game_tag_id={game_tag_id}&video_source={video_source}&qq_live_product_type={qq_live_product_type}&pip={pip}&rcmd_context={rcmd_context}&translucent_page={translucent_page}&jump_start_time={jump_start_time}&auto_open_url={auto_open_url}&auto_open_page_style={auto_open_page_style}&showmore={showmore}&level={level}&default_tab_id={default_tab_id}&gamelive_custom_params={gamelive_custom_params}&jumpcmd={jumpcmd}&extdata={extdata}&anchor_id={anchor_id}&scene_id={scene_id}&qz_gdt={qz_gdt}&activity_id={activity_id}&auto_open_pendant_id={auto_open_pendant_id}&auto_open_luckybag={auto_open_luckybag}&auto_download={auto_download}".replace("{roomId}", this.f424880a);
            this.f424882c = replace;
            String replace2 = replace.replace("{videoUrl}", d());
            this.f424882c = replace2;
            String replace3 = replace2.replace("{fromid}", String.valueOf(aVar.f417953i));
            this.f424882c = replace3;
            String replace4 = replace3.replace("{startTime}", String.valueOf(System.currentTimeMillis()));
            this.f424882c = replace4;
            String str4 = "1";
            if (!aVar.f417955k) {
                charSequence = "0";
            } else {
                charSequence = "1";
            }
            String replace5 = replace4.replace("{nocleartop}", charSequence);
            this.f424882c = replace5;
            String replace6 = replace5.replace("{closeJump}", Uri.encode(aVar.f417952h));
            this.f424882c = replace6;
            String replace7 = replace6.replace("{trace_info}", Uri.encode(aVar.f417954j));
            this.f424882c = replace7;
            String replace8 = replace7.replace("{session_id}", sb6);
            this.f424882c = replace8;
            String replace9 = replace8.replace("{traceId}", aVar.E);
            this.f424882c = replace9;
            if (!QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")) {
                str4 = "0";
            }
            String replace10 = replace9.replace("{tool_state}", str4);
            this.f424882c = replace10;
            String str5 = aVar.f417957m;
            if (str5 == null) {
                str5 = "0";
            }
            String replace11 = replace10.replace("{room_type}", str5);
            this.f424882c = replace11;
            String str6 = aVar.f417958n;
            if (str6 == null) {
                str6 = "0";
            }
            String replace12 = replace11.replace("{game_id}", str6);
            this.f424882c = replace12;
            String str7 = aVar.f417959o;
            if (str7 == null) {
                str7 = "0";
            }
            String replace13 = replace12.replace("{game_tag_id}", str7);
            this.f424882c = replace13;
            String str8 = aVar.f417960p;
            if (str8 == null) {
                str8 = String.valueOf(65536L);
            }
            String replace14 = replace13.replace("{video_source}", str8);
            this.f424882c = replace14;
            String str9 = aVar.f417949e;
            if (str9 == null) {
                str9 = "";
            }
            String replace15 = replace14.replace("{coverurl}", str9);
            this.f424882c = replace15;
            if (!TextUtils.isEmpty(aVar.f417967w)) {
                str3 = aVar.f417967w;
            }
            String replace16 = replace15.replace("{auto_open_url}", str3);
            this.f424882c = replace16;
            if (!TextUtils.isEmpty(aVar.f417968x)) {
                str2 = aVar.f417968x;
            }
            String replace17 = replace16.replace("{auto_open_page_style}", str2);
            this.f424882c = replace17;
            String replace18 = replace17.replace("{level}", aVar.B);
            this.f424882c = replace18;
            String str10 = aVar.f417969y;
            if (str10 == null) {
                str10 = "";
            }
            String replace19 = replace18.replace("{default_tab_id}", str10);
            this.f424882c = replace19;
            String str11 = aVar.f417970z;
            if (str11 == null) {
                str11 = "";
            }
            String replace20 = replace19.replace("{gamelive_custom_params}", str11);
            this.f424882c = replace20;
            String str12 = aVar.A;
            if (str12 == null) {
                str12 = "";
            }
            String replace21 = replace20.replace("{jumpcmd}", str12);
            this.f424882c = replace21;
            String str13 = aVar.G;
            if (str13 == null) {
                str13 = "";
            }
            String replace22 = replace21.replace("{qz_gdt}", str13);
            this.f424882c = replace22;
            String str14 = aVar.J;
            if (str14 == null) {
                str14 = "";
            }
            String replace23 = replace22.replace("{auto_open_luckybag}", str14);
            this.f424882c = replace23;
            String str15 = aVar.K;
            if (str15 != null) {
                str = str15;
            }
            this.f424882c = replace23.replace("{auto_download}", str);
            i(aVar);
            j(aVar);
            k(aVar);
            l(aVar);
            h(aVar);
            o(aVar);
            g(aVar);
            f(aVar);
            n(aVar);
            e(aVar);
            m(aVar);
            if (QLog.isDevelopLevel()) {
                QLog.e("IliveLiteHelper", 1, "enterRoom qq scheme=" + this.f424882c);
            }
            a();
            return;
        }
        QLog.e("IliveLiteHelper", 1, "error enter room id null");
    }
}
