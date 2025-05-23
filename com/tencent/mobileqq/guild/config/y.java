package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.guild.live.config.GuildLiveReadyTipsConfBean;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public boolean f216237a;

    /* renamed from: a0, reason: collision with root package name */
    public int f216238a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f216240b0;

    /* renamed from: j, reason: collision with root package name */
    public long f216255j;

    /* renamed from: j0, reason: collision with root package name */
    public int f216256j0;

    /* renamed from: k, reason: collision with root package name */
    public int f216257k;

    /* renamed from: k0, reason: collision with root package name */
    public int f216258k0;

    /* renamed from: l, reason: collision with root package name */
    public int f216259l;

    /* renamed from: p, reason: collision with root package name */
    public boolean f216267p;

    /* renamed from: b, reason: collision with root package name */
    public boolean f216239b = false;

    /* renamed from: c, reason: collision with root package name */
    public String f216241c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f216243d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f216245e = "https://qun.qq.com/h5/group-create?_wv=16777216&_cwv=1";

    /* renamed from: f, reason: collision with root package name */
    public String f216247f = "https://qun.qq.com/qqweb/qunpro/create?_wv=3&_wwv=132";

    /* renamed from: g, reason: collision with root package name */
    public boolean f216249g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f216251h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f216253i = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f216261m = 1;

    /* renamed from: n, reason: collision with root package name */
    public int f216263n = 300000;

    /* renamed from: o, reason: collision with root package name */
    public int f216265o = 20;

    /* renamed from: q, reason: collision with root package name */
    public boolean f216269q = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f216271r = true;

    /* renamed from: s, reason: collision with root package name */
    public String f216273s = "https://qun.qq.com/qunpro/passcheck/index?_wv=16777219&_wwv=129&_cwv=9";

    /* renamed from: t, reason: collision with root package name */
    public boolean f216275t = true;

    /* renamed from: u, reason: collision with root package name */
    public String f216277u = "https://qun.qq.com/guild/h5/guild-school/index.html?_wv=54181&_wwv=128";

    /* renamed from: v, reason: collision with root package name */
    public boolean f216279v = false;

    /* renamed from: w, reason: collision with root package name */
    public String f216281w = "";

    /* renamed from: x, reason: collision with root package name */
    public boolean f216283x = true;

    /* renamed from: y, reason: collision with root package name */
    public boolean f216285y = false;

    /* renamed from: z, reason: collision with root package name */
    public v f216287z = new v();
    public boolean A = false;
    public String B = "https://qun.qq.com/qqweb/qunpro/share?_wv=3&_wwv=128&inviteCode=1iV8UU&from=181074&biz=ka";
    public boolean C = false;
    public String D = "https://ifeedback.qq.com/platform/feedback?app_id=950";
    public boolean E = true;
    public List<String> F = new ArrayList();
    public TroopJoinGuildBean G = new TroopJoinGuildBean();
    public Map<Integer, p> H = new HashMap();
    public boolean I = false;
    public boolean J = true;
    public boolean K = true;
    public HashSet<String> L = new HashSet<>();
    public List<String> M = new ArrayList(2);
    public boolean N = true;
    public GuildDiscoverBannerConfBean O = new GuildDiscoverBannerConfBean();
    public boolean P = false;
    public String Q = "";
    public boolean R = false;
    public String S = "https://downv6.qq.com/innovate/guild/identity/";
    public Set<String> T = new HashSet();
    public boolean U = true;
    public boolean V = true;
    public boolean W = false;
    public boolean X = false;
    public List<String> Y = new ArrayList();
    public List<String> Z = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    public int f216242c0 = 3;

    /* renamed from: d0, reason: collision with root package name */
    public int f216244d0 = 3;

    /* renamed from: e0, reason: collision with root package name */
    public int f216246e0 = 3;

    /* renamed from: f0, reason: collision with root package name */
    public int f216248f0 = 3;

    /* renamed from: g0, reason: collision with root package name */
    public GuildLiveReadyTipsConfBean f216250g0 = new GuildLiveReadyTipsConfBean();

    /* renamed from: h0, reason: collision with root package name */
    public s f216252h0 = new s();

    /* renamed from: i0, reason: collision with root package name */
    public boolean f216254i0 = false;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f216260l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f216262m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    public String f216264n0 = "";

    /* renamed from: o0, reason: collision with root package name */
    public int f216266o0 = -1;

    /* renamed from: p0, reason: collision with root package name */
    public int f216268p0 = 150;

    /* renamed from: q0, reason: collision with root package name */
    public String f216270q0 = "";

    /* renamed from: r0, reason: collision with root package name */
    public String f216272r0 = "";

    /* renamed from: s0, reason: collision with root package name */
    public int f216274s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    public List<Integer> f216276t0 = new ArrayList();

    /* renamed from: u0, reason: collision with root package name */
    public List<Integer> f216278u0 = new ArrayList();

    /* renamed from: v0, reason: collision with root package name */
    public String f216280v0 = "https://qun.qq.com/guild/h5/robot-push-settings/index.html";

    /* renamed from: w0, reason: collision with root package name */
    public String f216282w0 = "https://support.qq.com/product/396585/faqs-more?_wv=0";

    /* renamed from: x0, reason: collision with root package name */
    public String f216284x0 = "https://qun.qq.com/qqweb/qunpro/share?_wv=3&_wwv=128&appChannel=share&inviteCode=24d0lv&from=181074&biz=ka";

    /* renamed from: y0, reason: collision with root package name */
    public String f216286y0 = "https://qun.qq.com/qunpro/robot/add?_wwv=1&_wv=16777219&type=share";

    /* renamed from: z0, reason: collision with root package name */
    public String f216288z0 = "https://qun.qq.com/qunpro/robot/share";
    public String A0 = "\u8bed\u97f3\u804a\u5929\u4e2d\u4e25\u7981\u51fa\u73b0\u8fdd\u6cd5\u8fdd\u89c4\u3001\u8272\u60c5\u4f4e\u4fd7\u3001\u6076\u610f\u5f15\u6d41\u7b49\u4fe1\u606f\u3002\u82e5\u53d1\u73b0\u8fdd\u89c4\u884c\u4e3a\u8bf7\u53ca\u65f6\u4e3e\u62a5\uff0c\u5e73\u53f0\u5c06\u91c7\u53d6\u7981\u6b62\u4f7f\u7528\u529f\u80fd\u6216\u5c01\u505c\u8d26\u53f7\u7b49\u5904\u7f5a\u63aa\u65bd\u3002\u53e6\u8bf7\u6ce8\u610f\u8d22\u4ea7\u5b89\u5168\uff0c\u8c28\u9632\u7f51\u7edc\u6b3a\u8bc8\u3002";
    public boolean B0 = false;
    public String C0 = "mqqapi://ecommerce/open?target=2&channel=3&src_type=internal&version=1";
    public JSONObject D0 = new JSONObject();
    public Boolean E0 = Boolean.TRUE;
    public double F0 = 0.0d;
    public boolean G0 = false;
    public Set<String> H0 = new HashSet();
    public Set<String> I0 = new HashSet();
    public int J0 = 29;
    private Map<Integer, tg1.a> K0 = new HashMap();
    private List<com.tencent.mobileqq.guild.config.subconfig.parser.a> L0 = new ArrayList();
    public boolean M0 = true;
    public int N0 = 300;
    public boolean O0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y() {
        b();
    }

    private void b() {
        this.L0.add(new com.tencent.mobileqq.guild.config.subconfig.parser.f());
        this.L0.add(new com.tencent.mobileqq.guild.config.subconfig.parser.h());
        this.L0.add(new com.tencent.mobileqq.guild.config.subconfig.parser.e());
        this.L0.add(new com.tencent.mobileqq.guild.config.subconfig.parser.b());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:(12:(3:456|457|(68:461|462|(4:464|465|466|467)|471|227|228|229|(1:231)|232|(1:234)|235|(1:237)|238|(1:240)|241|(1:243)|244|(1:246)|247|248|249|(3:444|445|(1:447))|251|252|253|(3:434|435|(1:437))|255|(1:257)|258|259|260|(7:415|416|417|(1:419)(1:427)|420|421|(1:423))(1:262)|263|264|265|(3:396|397|(35:399|400|401|402|268|269|270|(3:380|381|(30:383|384|385|386|273|274|(3:276|(1:278)|279)|280|(4:282|283|284|285)(1:376)|287|288|(1:290)|291|(3:347|348|(3:352|(6:355|356|357|358|359|353)|364))|293|294|295|(3:301|(3:304|305|302)|306)|307|308|309|(2:311|(1:313))|314|(2:316|(1:318))|319|(2:321|(1:323))|324|(2:326|(1:328))|329|(6:331|332|333|334|335|(1:337))))|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(5:297|299|301|(1:302)|306)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0)))|267|268|269|270|(0)|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(0)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0)))|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0))|269|270|(0)|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(0)|307) */
    /* JADX WARN: Can't wrap try/catch for region: R(33:(57:12|13|(5:16|17|(3:19|20|21)(1:23)|22|14)|31|32|(3:34|(1:36)(1:548)|37)(2:549|(1:551)(2:552|(1:554)(2:555|(5:557|(1:559)(1:565)|560|(1:562)(1:564)|563)(2:566|(3:568|(1:570)(1:572)|571)(2:573|(1:575)(2:576|(1:578)(2:579|(1:581)(2:582|(1:584)))))))))|38|(3:40|(1:42)(1:44)|43)|45|(4:47|(1:49)(1:53)|50|(1:52))|54|(4:56|(1:58)(1:62)|59|(1:61))|63|(4:65|(1:67)(1:71)|68|(1:70))|72|(4:74|(1:76)(1:80)|77|(1:79))|81|(4:83|(1:85)(1:89)|86|(1:88))|90|(4:92|(1:94)(1:98)|95|(1:97))|99|(3:101|(1:103)|104)|105|(3:107|(1:109)|110)|111|(3:113|(1:115)|116)|117|(3:119|(1:121)|122)|123|(3:125|(1:127)|128)|129|(4:131|(1:133)(1:137)|134|(1:136))|138|(4:140|(1:142)(1:146)|143|(1:145))|147|(4:149|(1:151)(1:155)|152|(1:154))|156|(4:158|(1:160)(1:164)|161|(1:163))|165|(1:167)|168|(1:170)|171|(2:173|(1:175))|176|(1:178)|179|(1:181)|182|(1:184)|185|(1:187)|188|(1:190)|191|(3:193|(1:195)|196)|197)|(5:198|199|(4:537|538|(1:540)|541)|201|(18:202|203|(4:519|520|(4:522|523|524|525)(1:530)|526)(1:205)|206|207|(1:209)|210|(1:212)|213|214|215|(4:496|497|(4:499|500|501|502)(1:507)|503)(1:217)|218|219|220|(4:478|479|(4:481|482|483|484)(1:489)|485)(1:222)|223|224))|(36:(3:456|457|(68:461|462|(4:464|465|466|467)|471|227|228|229|(1:231)|232|(1:234)|235|(1:237)|238|(1:240)|241|(1:243)|244|(1:246)|247|248|249|(3:444|445|(1:447))|251|252|253|(3:434|435|(1:437))|255|(1:257)|258|259|260|(7:415|416|417|(1:419)(1:427)|420|421|(1:423))(1:262)|263|264|265|(3:396|397|(35:399|400|401|402|268|269|270|(3:380|381|(30:383|384|385|386|273|274|(3:276|(1:278)|279)|280|(4:282|283|284|285)(1:376)|287|288|(1:290)|291|(3:347|348|(3:352|(6:355|356|357|358|359|353)|364))|293|294|295|(3:301|(3:304|305|302)|306)|307|308|309|(2:311|(1:313))|314|(2:316|(1:318))|319|(2:321|(1:323))|324|(2:326|(1:328))|329|(6:331|332|333|334|335|(1:337))))|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(5:297|299|301|(1:302)|306)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0)))|267|268|269|270|(0)|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(0)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0)))|264|265|(0)|267|268|269|270|(0)|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(0)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0))|226|227|228|229|(0)|232|(0)|235|(0)|238|(0)|241|(0)|244|(0)|247|248|249|(0)|251|252|253|(0)|255|(0)|258|259|260|(0)(0)|263) */
    /* JADX WARN: Can't wrap try/catch for region: R(89:12|13|(5:16|17|(3:19|20|21)(1:23)|22|14)|31|32|(3:34|(1:36)(1:548)|37)(2:549|(1:551)(2:552|(1:554)(2:555|(5:557|(1:559)(1:565)|560|(1:562)(1:564)|563)(2:566|(3:568|(1:570)(1:572)|571)(2:573|(1:575)(2:576|(1:578)(2:579|(1:581)(2:582|(1:584)))))))))|38|(3:40|(1:42)(1:44)|43)|45|(4:47|(1:49)(1:53)|50|(1:52))|54|(4:56|(1:58)(1:62)|59|(1:61))|63|(4:65|(1:67)(1:71)|68|(1:70))|72|(4:74|(1:76)(1:80)|77|(1:79))|81|(4:83|(1:85)(1:89)|86|(1:88))|90|(4:92|(1:94)(1:98)|95|(1:97))|99|(3:101|(1:103)|104)|105|(3:107|(1:109)|110)|111|(3:113|(1:115)|116)|117|(3:119|(1:121)|122)|123|(3:125|(1:127)|128)|129|(4:131|(1:133)(1:137)|134|(1:136))|138|(4:140|(1:142)(1:146)|143|(1:145))|147|(4:149|(1:151)(1:155)|152|(1:154))|156|(4:158|(1:160)(1:164)|161|(1:163))|165|(1:167)|168|(1:170)|171|(2:173|(1:175))|176|(1:178)|179|(1:181)|182|(1:184)|185|(1:187)|188|(1:190)|191|(3:193|(1:195)|196)|197|(5:198|199|(4:537|538|(1:540)|541)|201|(18:202|203|(4:519|520|(4:522|523|524|525)(1:530)|526)(1:205)|206|207|(1:209)|210|(1:212)|213|214|215|(4:496|497|(4:499|500|501|502)(1:507)|503)(1:217)|218|219|220|(4:478|479|(4:481|482|483|484)(1:489)|485)(1:222)|223|224))|(36:(3:456|457|(68:461|462|(4:464|465|466|467)|471|227|228|229|(1:231)|232|(1:234)|235|(1:237)|238|(1:240)|241|(1:243)|244|(1:246)|247|248|249|(3:444|445|(1:447))|251|252|253|(3:434|435|(1:437))|255|(1:257)|258|259|260|(7:415|416|417|(1:419)(1:427)|420|421|(1:423))(1:262)|263|264|265|(3:396|397|(35:399|400|401|402|268|269|270|(3:380|381|(30:383|384|385|386|273|274|(3:276|(1:278)|279)|280|(4:282|283|284|285)(1:376)|287|288|(1:290)|291|(3:347|348|(3:352|(6:355|356|357|358|359|353)|364))|293|294|295|(3:301|(3:304|305|302)|306)|307|308|309|(2:311|(1:313))|314|(2:316|(1:318))|319|(2:321|(1:323))|324|(2:326|(1:328))|329|(6:331|332|333|334|335|(1:337))))|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(5:297|299|301|(1:302)|306)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0)))|267|268|269|270|(0)|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(0)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0)))|264|265|(0)|267|268|269|270|(0)|272|273|274|(0)|280|(0)(0)|287|288|(0)|291|(0)|293|294|295|(0)|307|308|309|(0)|314|(0)|319|(0)|324|(0)|329|(0))|226|227|228|229|(0)|232|(0)|235|(0)|238|(0)|241|(0)|244|(0)|247|248|249|(0)|251|252|253|(0)|255|(0)|258|259|260|(0)(0)|263) */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0b21, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0b23, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0b26, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0b2c, code lost:
    
        r17 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x0b35, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0b36, code lost:
    
        r21 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x0b3e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x0b3f, code lost:
    
        r21 = r2;
        r20 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x0b45, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x0b46, code lost:
    
        r21 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0b4a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:231:0x07a6 A[Catch: Exception -> 0x07b0, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x07b0, blocks: (B:466:0x0780, B:231:0x07a6, B:234:0x07bb, B:237:0x07cd, B:240:0x07f1, B:243:0x0803, B:246:0x0815), top: B:465:0x0780 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x07bb A[Catch: Exception -> 0x07b0, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x07b0, blocks: (B:466:0x0780, B:231:0x07a6, B:234:0x07bb, B:237:0x07cd, B:240:0x07f1, B:243:0x0803, B:246:0x0815), top: B:465:0x0780 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x07cd A[Catch: Exception -> 0x07b0, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x07b0, blocks: (B:466:0x0780, B:231:0x07a6, B:234:0x07bb, B:237:0x07cd, B:240:0x07f1, B:243:0x0803, B:246:0x0815), top: B:465:0x0780 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x07f1 A[Catch: Exception -> 0x07b0, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x07b0, blocks: (B:466:0x0780, B:231:0x07a6, B:234:0x07bb, B:237:0x07cd, B:240:0x07f1, B:243:0x0803, B:246:0x0815), top: B:465:0x0780 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0803 A[Catch: Exception -> 0x07b0, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x07b0, blocks: (B:466:0x0780, B:231:0x07a6, B:234:0x07bb, B:237:0x07cd, B:240:0x07f1, B:243:0x0803, B:246:0x0815), top: B:465:0x0780 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0815 A[Catch: Exception -> 0x07b0, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x07b0, blocks: (B:466:0x0780, B:231:0x07a6, B:234:0x07bb, B:237:0x07cd, B:240:0x07f1, B:243:0x0803, B:246:0x0815), top: B:465:0x0780 }] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0893 A[Catch: Exception -> 0x0884, TRY_ENTER, TRY_LEAVE, TryCatch #37 {Exception -> 0x0884, blocks: (B:435:0x085d, B:437:0x0869, B:257:0x0893), top: B:434:0x085d }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x08db  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0965 A[Catch: Exception -> 0x0985, TRY_ENTER, TryCatch #34 {Exception -> 0x0985, blocks: (B:386:0x093b, B:276:0x0965, B:278:0x096b, B:279:0x0981), top: B:385:0x093b }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0990  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x09b3 A[Catch: Exception -> 0x099f, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x099f, blocks: (B:285:0x0997, B:290:0x09b3), top: B:284:0x0997 }] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0a06 A[Catch: Exception -> 0x0a28, TRY_ENTER, TryCatch #13 {Exception -> 0x0a28, blocks: (B:358:0x09e2, B:297:0x0a06, B:299:0x0a0f, B:302:0x0a16, B:304:0x0a1c), top: B:357:0x09e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0a1c A[Catch: Exception -> 0x0a28, TRY_LEAVE, TryCatch #13 {Exception -> 0x0a28, blocks: (B:358:0x09e2, B:297:0x0a06, B:299:0x0a0f, B:302:0x0a16, B:304:0x0a1c), top: B:357:0x09e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0a32 A[Catch: Exception -> 0x0b1e, TryCatch #10 {Exception -> 0x0b1e, blocks: (B:309:0x0a2c, B:311:0x0a32, B:313:0x0a3e, B:314:0x0a58, B:316:0x0a61, B:318:0x0a70, B:319:0x0a88, B:321:0x0a91, B:323:0x0aa0, B:324:0x0ab8, B:326:0x0ac1, B:328:0x0ad0, B:329:0x0ae8, B:335:0x0af9, B:337:0x0b01), top: B:308:0x0a2c }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0a61 A[Catch: Exception -> 0x0b1e, TryCatch #10 {Exception -> 0x0b1e, blocks: (B:309:0x0a2c, B:311:0x0a32, B:313:0x0a3e, B:314:0x0a58, B:316:0x0a61, B:318:0x0a70, B:319:0x0a88, B:321:0x0a91, B:323:0x0aa0, B:324:0x0ab8, B:326:0x0ac1, B:328:0x0ad0, B:329:0x0ae8, B:335:0x0af9, B:337:0x0b01), top: B:308:0x0a2c }] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0a91 A[Catch: Exception -> 0x0b1e, TryCatch #10 {Exception -> 0x0b1e, blocks: (B:309:0x0a2c, B:311:0x0a32, B:313:0x0a3e, B:314:0x0a58, B:316:0x0a61, B:318:0x0a70, B:319:0x0a88, B:321:0x0a91, B:323:0x0aa0, B:324:0x0ab8, B:326:0x0ac1, B:328:0x0ad0, B:329:0x0ae8, B:335:0x0af9, B:337:0x0b01), top: B:308:0x0a2c }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0ac1 A[Catch: Exception -> 0x0b1e, TryCatch #10 {Exception -> 0x0b1e, blocks: (B:309:0x0a2c, B:311:0x0a32, B:313:0x0a3e, B:314:0x0a58, B:316:0x0a61, B:318:0x0a70, B:319:0x0a88, B:321:0x0a91, B:323:0x0aa0, B:324:0x0ab8, B:326:0x0ac1, B:328:0x0ad0, B:329:0x0ae8, B:335:0x0af9, B:337:0x0b01), top: B:308:0x0a2c }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0af1  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x09c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x09a8  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0924 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x08e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x089e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x085d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0826 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static y c(ai[] aiVarArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Exception exc;
        int i3;
        JSONObject jSONObject;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        JSONArray optJSONArray;
        int i16;
        ai[] aiVarArr2 = aiVarArr;
        String str18 = "isRobotGuildOpen";
        String str19 = "whiteUserConfig";
        String str20 = "isChannelNumberSearchableOpen";
        String str21 = "guildRoleGroupConfigKey";
        String str22 = "guildRoleIdentityIcon";
        String str23 = "addFriendManage";
        String str24 = "robotAuthCacheMaxDuration";
        String str25 = "speakThresholdFaceAuth";
        String str26 = "pushMsgSettingLink";
        String str27 = "guildMyOrderUrl";
        String str28 = "isShowGuildMyOrder";
        String str29 = "robotShareJumpUrlNotInQQ";
        y yVar = new y();
        String str30 = "robotShareJumpUrlInQQ";
        int length = aiVarArr2.length;
        String str31 = "clientIconPrefix";
        int i17 = 0;
        while (i17 < length) {
            int i18 = length;
            ai aiVar = aiVarArr2[i17];
            String str32 = aiVar.f202268b;
            int i19 = i17;
            if (QLog.isDevelopLevel()) {
                str = str20;
                str2 = str21;
                StringBuilder sb5 = new StringBuilder();
                str3 = str22;
                sb5.append("parse,id = ");
                sb5.append(aiVar.f202267a);
                sb5.append(" content=");
                QLog.d("Guild.config.QQMeetConfigBean", 4, sb5.toString(), str32);
            } else {
                str = str20;
                str2 = str21;
                str3 = str22;
            }
            if (TextUtils.isEmpty(str32)) {
                str4 = str24;
                str5 = str26;
                str6 = str23;
                str21 = str2;
                str7 = str3;
                str8 = str18;
                str9 = str31;
                str10 = str;
                str11 = str19;
            } else {
                try {
                    Iterator<com.tencent.mobileqq.guild.config.subconfig.parser.a> it = yVar.L0.iterator();
                    while (it.hasNext()) {
                        try {
                            tg1.a parse = it.next().parse(str32);
                            if (parse != null) {
                                yVar.K0.put(Integer.valueOf(parse.getSubConfigType()), parse);
                            }
                        } catch (Exception e16) {
                            str4 = str24;
                            str5 = str26;
                            str6 = str23;
                            str21 = str2;
                            str7 = str3;
                            str8 = str18;
                            str9 = str31;
                            str10 = str;
                            exc = e16;
                            str11 = str19;
                            i3 = 0;
                            QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                            i17 = i19 + 1;
                            str23 = str6;
                            str26 = str5;
                            length = i18;
                            str19 = str11;
                            str18 = str8;
                            str24 = str4;
                            aiVarArr2 = aiVarArr;
                            str22 = str7;
                            str20 = str10;
                            str31 = str9;
                        }
                    }
                    jSONObject = new JSONObject(str32);
                    if (jSONObject.has(str19)) {
                        yVar.f216237a = jSONObject.optInt(str19) == 1;
                    } else if (jSONObject.has(str18)) {
                        yVar.f216239b = jSONObject.optBoolean(str18);
                        yVar.f216241c = jSONObject.optString("robotListUrl", "");
                        yVar.f216243d = jSONObject.optString("robotDetailInfoUrl", "");
                    } else if (jSONObject.has("globalGuildConfig")) {
                        i(yVar, jSONObject.optJSONObject("globalGuildConfig"));
                    } else if (jSONObject.has("enableVoiceChannel")) {
                        yVar.f216249g = jSONObject.optInt("enableVoiceChannel") == 1;
                        yVar.f216251h = jSONObject.optInt("enableVoiceChannelRobot") == 1;
                    } else if (jSONObject.has("forbiddenShowThirdAppAuthDialog")) {
                        yVar.f216267p = jSONObject.optInt("forbiddenShowThirdAppAuthDialog") == 1;
                    } else if (jSONObject.has("isShowPass")) {
                        yVar.f216271r = jSONObject.optBoolean("isShowPass");
                        yVar.f216273s = jSONObject.optString("guildPassUrl");
                    } else if (jSONObject.has("isShowInvite")) {
                        yVar.f216269q = jSONObject.optBoolean("isShowInvite");
                    } else if (jSONObject.has("isGuildOwnerOperationShow")) {
                        yVar.f216275t = jSONObject.optBoolean("isGuildOwnerOperationShow");
                        yVar.f216277u = jSONObject.optString("guildOwnerOperationUrl");
                    } else if (jSONObject.has("isShowSetGlobalTopMsg")) {
                        yVar.K = jSONObject.optBoolean("isShowSetGlobalTopMsg", true);
                    }
                    if (jSONObject.has("enableRetrieveById")) {
                        yVar.N = jSONObject.optInt("enableRetrieveById") == 1;
                    }
                    if (jSONObject.has("directMsgSwitch")) {
                        int optInt = jSONObject.optInt("directMsgSwitch");
                        yVar.f216283x = optInt == 1;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "directMsgSwitch: " + optInt);
                        }
                    }
                    if (jSONObject.has("directDiscoverSwitch")) {
                        int optInt2 = jSONObject.optInt("directDiscoverSwitch");
                        yVar.f216285y = optInt2 == 1;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "directDiscoverSwitch: " + optInt2);
                        }
                    }
                    if (jSONObject.has("enableSearchTabGuild")) {
                        yVar.U = jSONObject.optInt("enableSearchTabGuild") != 0;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "enableSearchTabGuild:" + yVar.U);
                        }
                    }
                    h(jSONObject);
                    if (jSONObject.has("enableSearchTabFeed")) {
                        yVar.V = jSONObject.optInt("enableSearchTabFeed") != 0;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "enableSearchTabFeed:" + yVar.V);
                        }
                    }
                    if (jSONObject.has("enableSearchTabLive")) {
                        yVar.W = jSONObject.optInt("enableSearchTabLive") != 0;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "enableSearchTabLive:" + yVar.W);
                        }
                    }
                    if (jSONObject.has("enableSearchTabSchedule")) {
                        yVar.X = jSONObject.optInt("enableSearchTabSchedule") != 0;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "enableSearchTabSchedule:" + yVar.X);
                        }
                    }
                    if (jSONObject.has("canGameLiveGuild")) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "canGameLiveGuild manage config:" + jSONObject.optJSONArray("canGameLiveGuild"));
                        }
                        g(yVar.Y, jSONObject.getJSONArray("canGameLiveGuild"));
                    }
                    if (jSONObject.has("canProgramLiveGuild")) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "canProgramLiveGuild manage config:" + jSONObject.optJSONArray("canProgramLiveGuild"));
                        }
                        g(yVar.Z, jSONObject.getJSONArray("canProgramLiveGuild"));
                    }
                    if (jSONObject.has(str26)) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "pushMsgSettingLink manage config:" + jSONObject.optString(str26));
                        }
                        yVar.f216280v0 = jSONObject.optString(str26);
                    }
                    if (jSONObject.has(str24)) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "robotAuthCacheMaxDuration manage config:" + jSONObject.optInt(str24));
                        }
                        yVar.f216238a0 = jSONObject.optInt(str24);
                    }
                    if (jSONObject.has("robotDirectMessageMaxActiveMessageCount")) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "robotDirectMessageMaxActiveMessageCount manage config:" + jSONObject.optJSONArray("robotDirectMessageMaxActiveMessageCount"));
                        }
                        yVar.f216240b0 = jSONObject.optInt("robotDirectMessageMaxActiveMessageCount");
                    }
                    if (jSONObject.has("searchAllGuildCount")) {
                        int optInt3 = jSONObject.optInt("searchAllGuildCount");
                        if (optInt3 <= 0) {
                            optInt3 = 1;
                        }
                        yVar.f216242c0 = optInt3;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "searchAllGuildCount:" + yVar.f216242c0);
                        }
                    }
                    if (jSONObject.has("searchAllFeedCount")) {
                        int optInt4 = jSONObject.optInt("searchAllFeedCount");
                        if (optInt4 <= 0) {
                            optInt4 = 1;
                        }
                        yVar.f216244d0 = optInt4;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "searchAllFeedCount:" + yVar.f216244d0);
                        }
                    }
                    if (jSONObject.has("searchAllLiveCount")) {
                        int optInt5 = jSONObject.optInt("searchAllLiveCount");
                        if (optInt5 <= 0) {
                            optInt5 = 1;
                        }
                        yVar.f216246e0 = optInt5;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "searchAllLiveCount:" + yVar.f216246e0);
                        }
                    }
                    if (jSONObject.has("searchAllScheduleCount")) {
                        int optInt6 = jSONObject.optInt("searchAllScheduleCount");
                        if (optInt6 <= 0) {
                            optInt6 = 1;
                        }
                        yVar.f216248f0 = optInt6;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "searchAllScheduleCount:" + yVar.f216248f0);
                        }
                    }
                    if (v.g(jSONObject)) {
                        v.h(yVar.f216287z, jSONObject);
                    }
                    if (s.h(jSONObject)) {
                        s.i(yVar.f216252h0, jSONObject);
                    }
                    if (jSONObject.has("isShowGuildManageLog")) {
                        yVar.f216279v = jSONObject.optBoolean("isShowGuildManageLog");
                        yVar.f216281w = jSONObject.optString("guildManageLogUrl");
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "mIsShowGuildManageLog: " + yVar.f216279v + ", mGuildManageLogUrl: " + yVar.f216281w);
                        }
                    }
                    if (jSONObject.has("isShowGuildJoinOfficialGuild")) {
                        yVar.A = jSONObject.optBoolean("isShowGuildJoinOfficialGuild");
                        yVar.B = jSONObject.optString("guildJoinOfficialGuildUrl");
                    }
                    if (jSONObject.has("isShowGuildHelpAndFeedback")) {
                        yVar.C = jSONObject.optBoolean("isShowGuildHelpAndFeedback");
                        yVar.D = jSONObject.optString("guildHelpAndFeedbackUrl");
                    }
                    if (jSONObject.has("isShowGuildDiscoverEntrance")) {
                        yVar.E = jSONObject.optBoolean("isShowGuildDiscoverEntrance", true);
                    }
                    if (jSONObject.has("guildRobotInline")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("guildRobotInline");
                        yVar.f216253i = optJSONObject.optInt("isInlineBotOpen");
                        yVar.f216255j = optJSONObject.optLong("cacheDuration");
                        yVar.f216257k = optJSONObject.optInt("requestTimeout");
                        yVar.f216259l = optJSONObject.optInt("typeTimeout");
                    }
                    if (jSONObject.has("robotSlashCmd")) {
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("robotSlashCmd");
                        yVar.f216261m = optJSONObject2.optInt("isSupportSlash");
                        yVar.f216263n = optJSONObject2.optInt("robotSlashCmdCacheDuration");
                        yVar.f216265o = optJSONObject2.optInt("robotSlashCmdCacheCapacity");
                        yVar.f216258k0 = optJSONObject2.optInt("robotCmdSortGuildLimit");
                        yVar.f216256j0 = optJSONObject2.optInt("robotCmdSortRobotLimit");
                    }
                    if (jSONObject.has("GuildDiscoverTexts")) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Guild.config.QQMeetConfigBean", 4, "GuildDiscoverTexts:" + jSONObject.optJSONArray("GuildDiscoverTexts"));
                        }
                        e(yVar, jSONObject.optJSONArray("GuildDiscoverTexts"));
                    }
                    str7 = str3;
                } catch (Exception e17) {
                    e = e17;
                    str4 = str24;
                    str5 = str26;
                    str6 = str23;
                    str21 = str2;
                    str7 = str3;
                    str8 = str18;
                }
                try {
                    if (jSONObject.has(str7)) {
                        try {
                            if (QLog.isDevelopLevel()) {
                                QLog.i("Guild.config.QQMeetConfigBean", 4, "guildRoleIdentityIcon manage config:" + jSONObject.optJSONArray(str7));
                            }
                            f(yVar, jSONObject.optJSONArray(str7));
                        } catch (Exception e18) {
                            e = e18;
                            str4 = str24;
                            str5 = str26;
                            str6 = str23;
                            str9 = str31;
                            str10 = str;
                            str21 = str2;
                            str8 = str18;
                            str11 = str19;
                            i3 = 0;
                            exc = e;
                            QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                            i17 = i19 + 1;
                            str23 = str6;
                            str26 = str5;
                            length = i18;
                            str19 = str11;
                            str18 = str8;
                            str24 = str4;
                            aiVarArr2 = aiVarArr;
                            str22 = str7;
                            str20 = str10;
                            str31 = str9;
                        }
                    }
                    str21 = str2;
                    try {
                        if (jSONObject.has(str21)) {
                            try {
                                if (QLog.isDevelopLevel()) {
                                    StringBuilder sb6 = new StringBuilder();
                                    str8 = str18;
                                    try {
                                        sb6.append("guildRoleGroupConfigKey config: ");
                                        sb6.append(jSONObject.optJSONObject(str21));
                                        QLog.i("Guild.config.QQMeetConfigBean", 4, sb6.toString());
                                    } catch (Exception e19) {
                                        e = e19;
                                        exc = e;
                                        str4 = str24;
                                        str5 = str26;
                                        str6 = str23;
                                        str9 = str31;
                                        str10 = str;
                                        str11 = str19;
                                        i3 = 0;
                                        QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                        i17 = i19 + 1;
                                        str23 = str6;
                                        str26 = str5;
                                        length = i18;
                                        str19 = str11;
                                        str18 = str8;
                                        str24 = str4;
                                        aiVarArr2 = aiVarArr;
                                        str22 = str7;
                                        str20 = str10;
                                        str31 = str9;
                                    }
                                } else {
                                    str8 = str18;
                                }
                                yVar.I = jSONObject.optJSONObject(str21).optBoolean("isShowNormalRoleGroup");
                            } catch (Exception e26) {
                                e = e26;
                                str8 = str18;
                            }
                        } else {
                            str8 = str18;
                        }
                        try {
                            if (jSONObject.has("hasGuildSelectedAnim")) {
                                yVar.J = jSONObject.optBoolean("hasGuildSelectedAnim");
                            }
                            if (jSONObject.has("isShowGuildNameRuleDialog")) {
                                yVar.P = jSONObject.optBoolean("isShowGuildNameRuleDialog");
                                yVar.Q = jSONObject.optString("officialDeclareLinkUrl");
                            }
                            String str33 = str;
                            try {
                                if (jSONObject.has(str33)) {
                                    try {
                                        if (QLog.isDevelopLevel()) {
                                            StringBuilder sb7 = new StringBuilder();
                                            str11 = str19;
                                            try {
                                                sb7.append("isChannelNumberSearchableOpen:");
                                                sb7.append(jSONObject.optJSONArray(str33));
                                                QLog.i("Guild.config.QQMeetConfigBean", 4, sb7.toString());
                                            } catch (Exception e27) {
                                                e = e27;
                                                str4 = str24;
                                                str5 = str26;
                                                str6 = str23;
                                                str9 = str31;
                                                i3 = 0;
                                                str10 = str33;
                                                exc = e;
                                                QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                i17 = i19 + 1;
                                                str23 = str6;
                                                str26 = str5;
                                                length = i18;
                                                str19 = str11;
                                                str18 = str8;
                                                str24 = str4;
                                                aiVarArr2 = aiVarArr;
                                                str22 = str7;
                                                str20 = str10;
                                                str31 = str9;
                                            }
                                        } else {
                                            str11 = str19;
                                        }
                                        yVar.R = jSONObject.optBoolean(str33);
                                    } catch (Exception e28) {
                                        e = e28;
                                        str11 = str19;
                                    }
                                } else {
                                    str11 = str19;
                                }
                                str12 = str31;
                                try {
                                    if (jSONObject.has(str12)) {
                                        try {
                                            if (QLog.isDevelopLevel()) {
                                                StringBuilder sb8 = new StringBuilder();
                                                str10 = str33;
                                                try {
                                                    sb8.append("clientIconPrefix:");
                                                    sb8.append(jSONObject.optJSONArray(str12));
                                                    QLog.i("Guild.config.QQMeetConfigBean", 4, sb8.toString());
                                                } catch (Exception e29) {
                                                    e = e29;
                                                    exc = e;
                                                    str9 = str12;
                                                    str4 = str24;
                                                    str5 = str26;
                                                    str6 = str23;
                                                    i3 = 0;
                                                    QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                    i17 = i19 + 1;
                                                    str23 = str6;
                                                    str26 = str5;
                                                    length = i18;
                                                    str19 = str11;
                                                    str18 = str8;
                                                    str24 = str4;
                                                    aiVarArr2 = aiVarArr;
                                                    str22 = str7;
                                                    str20 = str10;
                                                    str31 = str9;
                                                }
                                            } else {
                                                str10 = str33;
                                            }
                                            yVar.S = jSONObject.optString(str12);
                                        } catch (Exception e36) {
                                            e = e36;
                                            str10 = str33;
                                        }
                                    } else {
                                        str10 = str33;
                                    }
                                    try {
                                    } catch (Exception e37) {
                                        e = e37;
                                        str9 = str12;
                                        str4 = str24;
                                        str5 = str26;
                                        str6 = str23;
                                        exc = e;
                                        i3 = 0;
                                        QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                        i17 = i19 + 1;
                                        str23 = str6;
                                        str26 = str5;
                                        length = i18;
                                        str19 = str11;
                                        str18 = str8;
                                        str24 = str4;
                                        aiVarArr2 = aiVarArr;
                                        str22 = str7;
                                        str20 = str10;
                                        str31 = str9;
                                    }
                                } catch (Exception e38) {
                                    e = e38;
                                    str10 = str33;
                                }
                            } catch (Exception e39) {
                                e = e39;
                                str11 = str19;
                                str4 = str24;
                                str5 = str26;
                                str6 = str23;
                                str9 = str31;
                                str10 = str33;
                            }
                        } catch (Exception e46) {
                            e = e46;
                            str4 = str24;
                            str5 = str26;
                            str6 = str23;
                            str9 = str31;
                            str10 = str;
                            str11 = str19;
                            exc = e;
                            i3 = 0;
                            QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                            i17 = i19 + 1;
                            str23 = str6;
                            str26 = str5;
                            length = i18;
                            str19 = str11;
                            str18 = str8;
                            str24 = str4;
                            aiVarArr2 = aiVarArr;
                            str22 = str7;
                            str20 = str10;
                            str31 = str9;
                        }
                    } catch (Exception e47) {
                        e = e47;
                        str8 = str18;
                    }
                } catch (Exception e48) {
                    e = e48;
                    str4 = str24;
                    str5 = str26;
                    str6 = str23;
                    str9 = str31;
                    str10 = str;
                    str21 = str2;
                    str8 = str18;
                    str11 = str19;
                    exc = e;
                    i3 = 0;
                    QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                    i17 = i19 + 1;
                    str23 = str6;
                    str26 = str5;
                    length = i18;
                    str19 = str11;
                    str18 = str8;
                    str24 = str4;
                    aiVarArr2 = aiVarArr;
                    str22 = str7;
                    str20 = str10;
                    str31 = str9;
                }
                try {
                    try {
                        try {
                            if (jSONObject.has("disableMarkdownVersion")) {
                                try {
                                    JSONArray optJSONArray2 = jSONObject.optJSONArray("disableMarkdownVersion");
                                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                        int length2 = optJSONArray2.length();
                                        str9 = str12;
                                        int i26 = 0;
                                        while (i26 < length2) {
                                            str4 = str24;
                                            try {
                                                JSONArray jSONArray = optJSONArray2;
                                                yVar.T.add(optJSONArray2.getString(i26));
                                                i26++;
                                                str24 = str4;
                                                optJSONArray2 = jSONArray;
                                            } catch (Exception e49) {
                                                e = e49;
                                                exc = e;
                                                str5 = str26;
                                                str6 = str23;
                                                i3 = 0;
                                                QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                i17 = i19 + 1;
                                                str23 = str6;
                                                str26 = str5;
                                                length = i18;
                                                str19 = str11;
                                                str18 = str8;
                                                str24 = str4;
                                                aiVarArr2 = aiVarArr;
                                                str22 = str7;
                                                str20 = str10;
                                                str31 = str9;
                                            }
                                        }
                                        str4 = str24;
                                        if (jSONObject.has("enableGuildSearchHotSort")) {
                                            yVar.f216254i0 = jSONObject.getBoolean("enableGuildSearchHotSort");
                                        }
                                        if (jSONObject.has("enableLiveSupportQuicFlv")) {
                                            yVar.f216260l0 = jSONObject.getBoolean("enableLiveSupportQuicFlv");
                                        }
                                        if (jSONObject.has("enableLiveSupportLocalDns")) {
                                            yVar.f216262m0 = jSONObject.getBoolean("enableLiveSupportLocalDns");
                                            yVar.f216264n0 = jSONObject.getString("LiveDomain");
                                            yVar.f216266o0 = jSONObject.getInt("RequestInterval");
                                        }
                                        if (jSONObject.has("QQGProRealNameAuthMemberLimitNums")) {
                                            yVar.f216268p0 = jSONObject.optInt("QQGProRealNameAuthMemberLimitNums");
                                        }
                                        if (jSONObject.has("FaqUrl")) {
                                            yVar.f216282w0 = jSONObject.optString("FaqUrl");
                                        }
                                        if (jSONObject.has("DeveloperExploreUrl")) {
                                            yVar.f216284x0 = jSONObject.optString("DeveloperExploreUrl");
                                        }
                                        str13 = str30;
                                        if (jSONObject.has(str13)) {
                                            try {
                                                yVar.f216286y0 = jSONObject.getString(str13);
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.i("Guild.config.QQMeetConfigBean", 4, "robotShareJumpUrlInQQ config: " + jSONObject.optString(str13));
                                                }
                                            } catch (Exception e56) {
                                                e = e56;
                                                str30 = str13;
                                                str5 = str26;
                                                str6 = str23;
                                                i3 = 0;
                                                exc = e;
                                                QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                i17 = i19 + 1;
                                                str23 = str6;
                                                str26 = str5;
                                                length = i18;
                                                str19 = str11;
                                                str18 = str8;
                                                str24 = str4;
                                                aiVarArr2 = aiVarArr;
                                                str22 = str7;
                                                str20 = str10;
                                                str31 = str9;
                                            }
                                        }
                                        str14 = str29;
                                        if (jSONObject.has(str14)) {
                                            try {
                                                yVar.f216288z0 = jSONObject.getString(str14);
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.i("Guild.config.QQMeetConfigBean", 4, "robotShareJumpUrlNotInQQ config: " + jSONObject.optString(str14));
                                                }
                                            } catch (Exception e57) {
                                                e = e57;
                                                str30 = str13;
                                                str29 = str14;
                                                str5 = str26;
                                                str6 = str23;
                                                i3 = 0;
                                                exc = e;
                                                QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                i17 = i19 + 1;
                                                str23 = str6;
                                                str26 = str5;
                                                length = i18;
                                                str19 = str11;
                                                str18 = str8;
                                                str24 = str4;
                                                aiVarArr2 = aiVarArr;
                                                str22 = str7;
                                                str20 = str10;
                                                str31 = str9;
                                            }
                                        }
                                        if (jSONObject.has("tailGuildIdStart")) {
                                            d(yVar, jSONObject);
                                        }
                                        str15 = str28;
                                        if (jSONObject.has(str15)) {
                                            str30 = str13;
                                        } else {
                                            try {
                                                str30 = str13;
                                            } catch (Exception e58) {
                                                e = e58;
                                                str30 = str13;
                                            }
                                            try {
                                                yVar.B0 = jSONObject.optInt(str15) == 1;
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.i("Guild.config.QQMeetConfigBean", 4, "isShowGuildMyOrder config: " + jSONObject.optInt(str15));
                                                }
                                            } catch (Exception e59) {
                                                e = e59;
                                                exc = e;
                                                str29 = str14;
                                                str28 = str15;
                                                str5 = str26;
                                                str6 = str23;
                                                i3 = 0;
                                                QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                i17 = i19 + 1;
                                                str23 = str6;
                                                str26 = str5;
                                                length = i18;
                                                str19 = str11;
                                                str18 = str8;
                                                str24 = str4;
                                                aiVarArr2 = aiVarArr;
                                                str22 = str7;
                                                str20 = str10;
                                                str31 = str9;
                                            }
                                        }
                                        str16 = str27;
                                        if (jSONObject.has(str16)) {
                                            try {
                                                yVar.C0 = jSONObject.optString(str16);
                                                if (QLog.isDevelopLevel()) {
                                                    StringBuilder sb9 = new StringBuilder();
                                                    str29 = str14;
                                                    try {
                                                        sb9.append("guildMyOrderUrl config: ");
                                                        sb9.append(jSONObject.optString(str16));
                                                        QLog.i("Guild.config.QQMeetConfigBean", 4, sb9.toString());
                                                        str17 = str25;
                                                        if (jSONObject.has(str17)) {
                                                            try {
                                                                yVar.E0 = Boolean.valueOf(jSONObject.optBoolean(str17));
                                                                if (QLog.isDevelopLevel()) {
                                                                    StringBuilder sb10 = new StringBuilder();
                                                                    str27 = str16;
                                                                    try {
                                                                        sb10.append("speakThresholdFaceAuth config: ");
                                                                        sb10.append(jSONObject.optString(str17));
                                                                        QLog.i("Guild.config.QQMeetConfigBean", 4, sb10.toString());
                                                                        if (jSONObject.has("useFadeInOut")) {
                                                                            if (QLog.isDevelopLevel()) {
                                                                                QLog.i("Guild.config.QQMeetConfigBean", 4, "KaraokeGuild config:" + str32);
                                                                            }
                                                                            yVar.D0 = jSONObject;
                                                                        }
                                                                        if (jSONObject.has("robotInputHintProbability")) {
                                                                            str25 = str17;
                                                                        } else {
                                                                            str25 = str17;
                                                                            try {
                                                                                yVar.F0 = jSONObject.optDouble("robotInputHintProbability", 0.0d);
                                                                            } catch (Exception e65) {
                                                                                exc = e65;
                                                                                str28 = str15;
                                                                                str5 = str26;
                                                                                str6 = str23;
                                                                                i3 = 0;
                                                                                QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                                                i17 = i19 + 1;
                                                                                str23 = str6;
                                                                                str26 = str5;
                                                                                length = i18;
                                                                                str19 = str11;
                                                                                str18 = str8;
                                                                                str24 = str4;
                                                                                aiVarArr2 = aiVarArr;
                                                                                str22 = str7;
                                                                                str20 = str10;
                                                                                str31 = str9;
                                                                            }
                                                                        }
                                                                        if (jSONObject.has("showRobotButtonInAddPanel")) {
                                                                            yVar.G0 = jSONObject.optBoolean("showRobotButtonInAddPanel");
                                                                        }
                                                                        if (jSONObject.has("QQGProShowCommandGuildList")) {
                                                                            try {
                                                                                JSONArray optJSONArray3 = jSONObject.optJSONArray("QQGProShowCommandGuildList");
                                                                                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                                                                    int i27 = 0;
                                                                                    while (i27 < optJSONArray3.length()) {
                                                                                        str28 = str15;
                                                                                        str5 = str26;
                                                                                        try {
                                                                                            yVar.H0.add(String.valueOf(optJSONArray3.optLong(i27, 0L)));
                                                                                            i27++;
                                                                                            str26 = str5;
                                                                                            str15 = str28;
                                                                                        } catch (Exception e66) {
                                                                                            e = e66;
                                                                                            exc = e;
                                                                                            str6 = str23;
                                                                                            i3 = 0;
                                                                                            QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                                                            i17 = i19 + 1;
                                                                                            str23 = str6;
                                                                                            str26 = str5;
                                                                                            length = i18;
                                                                                            str19 = str11;
                                                                                            str18 = str8;
                                                                                            str24 = str4;
                                                                                            aiVarArr2 = aiVarArr;
                                                                                            str22 = str7;
                                                                                            str20 = str10;
                                                                                            str31 = str9;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } catch (Exception e67) {
                                                                                e = e67;
                                                                                str28 = str15;
                                                                                str5 = str26;
                                                                            }
                                                                        }
                                                                        str28 = str15;
                                                                        str5 = str26;
                                                                        if (jSONObject.has("enableRobotRedDotVersion") && (optJSONArray = jSONObject.optJSONArray("enableRobotRedDotVersion")) != null && optJSONArray.length() > 0) {
                                                                            for (i16 = 0; i16 < optJSONArray.length(); i16++) {
                                                                                yVar.I0.add(optJSONArray.getString(i16));
                                                                            }
                                                                        }
                                                                        str6 = str23;
                                                                        if (jSONObject.has(str6)) {
                                                                            yVar.M0 = jSONObject.optBoolean(str6);
                                                                            if (QLog.isDevelopLevel()) {
                                                                                QLog.i("Guild.config.QQMeetConfigBean", 4, "addFriendManage config: " + jSONObject.optString(str6));
                                                                            }
                                                                        }
                                                                        if (jSONObject.has("mediaChannelSecurityMsgText")) {
                                                                            yVar.A0 = jSONObject.optString("mediaChannelSecurityMsgText");
                                                                            if (QLog.isDevelopLevel()) {
                                                                                QLog.i("Guild.config.QQMeetConfigBean", 4, "mediaChannelSecurityMsgText config: " + yVar.A0);
                                                                            }
                                                                        }
                                                                        if (jSONObject.has("speakModeQueueTime")) {
                                                                            yVar.N0 = jSONObject.optInt("speakModeQueueTime");
                                                                            if (QLog.isDevelopLevel()) {
                                                                                QLog.i("Guild.config.QQMeetConfigBean", 4, "speakModeQueueTime config: " + yVar.N0);
                                                                            }
                                                                        }
                                                                        if (jSONObject.has("minEnableListenPreloadApiLevel")) {
                                                                            yVar.J0 = jSONObject.getInt("minEnableListenPreloadApiLevel");
                                                                            if (QLog.isDevelopLevel()) {
                                                                                QLog.i("Guild.config.QQMeetConfigBean", 4, "minEnableListenPreloadApiLevel config: " + yVar.J0);
                                                                            }
                                                                        }
                                                                        if (jSONObject.has("GroupGuildUpgradeFetchSwitch")) {
                                                                            i3 = 0;
                                                                            try {
                                                                                yVar.O0 = jSONObject.optBoolean("GroupGuildUpgradeFetchSwitch", false);
                                                                                if (QLog.isDevelopLevel()) {
                                                                                    QLog.i("Guild.config.QQMeetConfigBean", 4, "GuildGuildUpgradeFetchSwitch =" + yVar.O0);
                                                                                }
                                                                            } catch (Exception e68) {
                                                                                e = e68;
                                                                                exc = e;
                                                                                QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                                                i17 = i19 + 1;
                                                                                str23 = str6;
                                                                                str26 = str5;
                                                                                length = i18;
                                                                                str19 = str11;
                                                                                str18 = str8;
                                                                                str24 = str4;
                                                                                aiVarArr2 = aiVarArr;
                                                                                str22 = str7;
                                                                                str20 = str10;
                                                                                str31 = str9;
                                                                            }
                                                                        }
                                                                    } catch (Exception e69) {
                                                                        e = e69;
                                                                        exc = e;
                                                                        str25 = str17;
                                                                        str28 = str15;
                                                                        str5 = str26;
                                                                        str6 = str23;
                                                                        i3 = 0;
                                                                        QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                                        i17 = i19 + 1;
                                                                        str23 = str6;
                                                                        str26 = str5;
                                                                        length = i18;
                                                                        str19 = str11;
                                                                        str18 = str8;
                                                                        str24 = str4;
                                                                        aiVarArr2 = aiVarArr;
                                                                        str22 = str7;
                                                                        str20 = str10;
                                                                        str31 = str9;
                                                                    }
                                                                }
                                                            } catch (Exception e75) {
                                                                e = e75;
                                                                str27 = str16;
                                                            }
                                                        }
                                                        str27 = str16;
                                                        if (jSONObject.has("useFadeInOut")) {
                                                        }
                                                        if (jSONObject.has("robotInputHintProbability")) {
                                                        }
                                                        if (jSONObject.has("showRobotButtonInAddPanel")) {
                                                        }
                                                        if (jSONObject.has("QQGProShowCommandGuildList")) {
                                                        }
                                                        str28 = str15;
                                                        str5 = str26;
                                                        if (jSONObject.has("enableRobotRedDotVersion")) {
                                                            while (i16 < optJSONArray.length()) {
                                                            }
                                                        }
                                                        str6 = str23;
                                                        if (jSONObject.has(str6)) {
                                                        }
                                                        if (jSONObject.has("mediaChannelSecurityMsgText")) {
                                                        }
                                                        if (jSONObject.has("speakModeQueueTime")) {
                                                        }
                                                        if (jSONObject.has("minEnableListenPreloadApiLevel")) {
                                                        }
                                                        if (jSONObject.has("GroupGuildUpgradeFetchSwitch")) {
                                                        }
                                                    } catch (Exception e76) {
                                                        e = e76;
                                                        str27 = str16;
                                                        str28 = str15;
                                                        str5 = str26;
                                                        str6 = str23;
                                                        i3 = 0;
                                                        exc = e;
                                                        QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                                                        i17 = i19 + 1;
                                                        str23 = str6;
                                                        str26 = str5;
                                                        length = i18;
                                                        str19 = str11;
                                                        str18 = str8;
                                                        str24 = str4;
                                                        aiVarArr2 = aiVarArr;
                                                        str22 = str7;
                                                        str20 = str10;
                                                        str31 = str9;
                                                    }
                                                }
                                            } catch (Exception e77) {
                                                e = e77;
                                                str29 = str14;
                                            }
                                        }
                                        str29 = str14;
                                        str17 = str25;
                                        if (jSONObject.has(str17)) {
                                        }
                                        str27 = str16;
                                        if (jSONObject.has("useFadeInOut")) {
                                        }
                                        if (jSONObject.has("robotInputHintProbability")) {
                                        }
                                        if (jSONObject.has("showRobotButtonInAddPanel")) {
                                        }
                                        if (jSONObject.has("QQGProShowCommandGuildList")) {
                                        }
                                        str28 = str15;
                                        str5 = str26;
                                        if (jSONObject.has("enableRobotRedDotVersion")) {
                                        }
                                        str6 = str23;
                                        if (jSONObject.has(str6)) {
                                        }
                                        if (jSONObject.has("mediaChannelSecurityMsgText")) {
                                        }
                                        if (jSONObject.has("speakModeQueueTime")) {
                                        }
                                        if (jSONObject.has("minEnableListenPreloadApiLevel")) {
                                        }
                                        if (jSONObject.has("GroupGuildUpgradeFetchSwitch")) {
                                        }
                                    }
                                } catch (Exception e78) {
                                    e = e78;
                                    str9 = str12;
                                    str4 = str24;
                                }
                            }
                            if (jSONObject.has(str6)) {
                            }
                            if (jSONObject.has("mediaChannelSecurityMsgText")) {
                            }
                            if (jSONObject.has("speakModeQueueTime")) {
                            }
                            if (jSONObject.has("minEnableListenPreloadApiLevel")) {
                            }
                            if (jSONObject.has("GroupGuildUpgradeFetchSwitch")) {
                            }
                        } catch (Exception e79) {
                            e = e79;
                            exc = e;
                            i3 = 0;
                            QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                            i17 = i19 + 1;
                            str23 = str6;
                            str26 = str5;
                            length = i18;
                            str19 = str11;
                            str18 = str8;
                            str24 = str4;
                            aiVarArr2 = aiVarArr;
                            str22 = str7;
                            str20 = str10;
                            str31 = str9;
                        }
                        if (jSONObject.has(str17)) {
                        }
                        str27 = str16;
                        if (jSONObject.has("useFadeInOut")) {
                        }
                        if (jSONObject.has("robotInputHintProbability")) {
                        }
                        if (jSONObject.has("showRobotButtonInAddPanel")) {
                        }
                        if (jSONObject.has("QQGProShowCommandGuildList")) {
                        }
                        str28 = str15;
                        str5 = str26;
                        if (jSONObject.has("enableRobotRedDotVersion")) {
                        }
                        str6 = str23;
                    } catch (Exception e85) {
                        e = e85;
                        str27 = str16;
                    }
                    if (jSONObject.has(str16)) {
                    }
                    str29 = str14;
                    str17 = str25;
                } catch (Exception e86) {
                    e = e86;
                    str27 = str16;
                    str29 = str14;
                    str28 = str15;
                    str5 = str26;
                    str6 = str23;
                    exc = e;
                    i3 = 0;
                    QLog.e("Guild.config.QQMeetConfigBean", 1, exc, new Object[i3]);
                    i17 = i19 + 1;
                    str23 = str6;
                    str26 = str5;
                    length = i18;
                    str19 = str11;
                    str18 = str8;
                    str24 = str4;
                    aiVarArr2 = aiVarArr;
                    str22 = str7;
                    str20 = str10;
                    str31 = str9;
                }
                str9 = str12;
                str4 = str24;
                if (jSONObject.has("enableGuildSearchHotSort")) {
                }
                if (jSONObject.has("enableLiveSupportQuicFlv")) {
                }
                if (jSONObject.has("enableLiveSupportLocalDns")) {
                }
                if (jSONObject.has("QQGProRealNameAuthMemberLimitNums")) {
                }
                if (jSONObject.has("FaqUrl")) {
                }
                if (jSONObject.has("DeveloperExploreUrl")) {
                }
                str13 = str30;
                if (jSONObject.has(str13)) {
                }
                str14 = str29;
                if (jSONObject.has(str14)) {
                }
                if (jSONObject.has("tailGuildIdStart")) {
                }
                str15 = str28;
                if (jSONObject.has(str15)) {
                }
                str16 = str27;
            }
            i17 = i19 + 1;
            str23 = str6;
            str26 = str5;
            length = i18;
            str19 = str11;
            str18 = str8;
            str24 = str4;
            aiVarArr2 = aiVarArr;
            str22 = str7;
            str20 = str10;
            str31 = str9;
        }
        return yVar;
    }

    private static void d(y yVar, JSONObject jSONObject) {
        if (yVar != null && jSONObject != null) {
            yVar.f216270q0 = jSONObject.optString("tailGuildIdStart");
            yVar.f216272r0 = jSONObject.optString("tailGuildIdEnd");
            yVar.f216274s0 = jSONObject.optInt("members");
            JSONArray optJSONArray = jSONObject.optJSONArray("lessThanChannelTypes");
            if (optJSONArray != null) {
                yVar.f216276t0 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    yVar.f216276t0.add((Integer) optJSONArray.opt(i3));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("moreThanChannelTypes");
            if (optJSONArray2 != null) {
                yVar.f216278u0 = new ArrayList();
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    yVar.f216278u0.add((Integer) optJSONArray2.opt(i16));
                }
            }
        }
    }

    private static void e(y yVar, JSONArray jSONArray) {
        yVar.F.clear();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String trim = jSONArray.optString(i3).trim();
            if (!TextUtils.isEmpty(trim)) {
                yVar.F.add(trim);
            }
        }
    }

    private static void f(y yVar, JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() > 0) {
            yVar.H.clear();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.has("id") && jSONObject.has("name") && jSONObject.has("iconUrl")) {
                    Integer valueOf = Integer.valueOf(jSONObject.optInt("id"));
                    yVar.H.put(valueOf, new p(valueOf.intValue(), jSONObject.optString("name"), jSONObject.optString("iconUrl")));
                }
            }
        }
    }

    private static void g(List<String> list, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            list.clear();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                list.add(jSONArray.optString(i3));
            }
        }
    }

    private static void h(JSONObject jSONObject) {
        if (jSONObject.has("enableDiscoverAsyncInflate")) {
            boolean z16 = true;
            if (jSONObject.optInt("enableDiscoverAsyncInflate") != 1) {
                z16 = false;
            }
            com.tencent.mobileqq.guild.discover.d.b(z16);
        }
    }

    private static void i(y yVar, JSONObject jSONObject) {
        yVar.f216245e = jSONObject.optString("guild_open_create_url");
    }

    @Nullable
    public tg1.a a(int i3) {
        return this.K0.get(Integer.valueOf(i3));
    }

    @NonNull
    public String toString() {
        return "mIsWhiteUser:" + this.f216237a + ", mGuildOpenCreateUrl:" + this.f216245e + ", mEnableVoiceChannel:" + this.f216249g + ", mEnableVoiceChannelRobot:" + this.f216251h + ", mForbiddenShowThirdAppAuthDialog:" + this.f216267p + ", mIsShowGuildDiscoverEntrance:" + this.E + ", mIsShowSetGlobalTopMsg" + this.K + ", hasGuildSelectedAnim:" + this.J + ", mIsShowGuildMyOrder:" + this.B0 + ", mGuildMyOrderUrl:" + this.C0 + ", mSubConfig:" + this.K0;
    }
}
