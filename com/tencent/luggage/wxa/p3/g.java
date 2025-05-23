package com.tencent.luggage.wxa.p3;

import android.os.Build;
import android.util.SparseIntArray;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.luggage.wxa.tn.r0;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f137156a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final b f137157b;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f137158c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f137159a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            com.tencent.luggage.wxa.lo.i.a(com.tencent.luggage.wxa.t9.l.g());
            if (!com.tencent.luggage.wxa.lo.i.h() && !com.tencent.luggage.wxa.lo.i.f()) {
                return "android-" + Build.VERSION.SDK_INT;
            }
            return "pad-android-" + Build.VERSION.SDK_INT;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends SparseIntArray {
        public final void a(String url, int i3) {
            Intrinsics.checkNotNullParameter(url, "url");
            super.put(url.hashCode(), i3);
        }

        public final int a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            int i3 = super.get(url.hashCode(), -1);
            if (!com.tencent.luggage.wxa.tn.e.f141559a || i3 != -1) {
                return i3;
            }
            throw new IllegalStateException(("Found invalid cmdid, please register " + url + " in this map.").toString());
        }
    }

    static {
        Lazy lazy;
        b bVar = new b();
        f137157b = bVar;
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
        bVar.a("/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync", QzoneCoverConst.MSG_COVER_INVALIDATE);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", QzoneCoverConst.MSG_UNSET_SUPER_COVER);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", com.tencent.luggage.wxa.kf.d.CTRL_INDEX);
        bVar.a("/cgi-bin/mmbiz-bin/js-authorize", gdt_analysis_event.EVENT_GET_JAVA_VM_VERSION);
        bVar.a("/cgi-bin/mmbiz-bin/js-authorize-confirm", gdt_analysis_event.EVENT_GET_QIMEI36);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
        bVar.a("/cgi-bin/mmbiz-bin/js-operatewxdata", LaunchScene.LAUNCH_SCENE_VM_NOTIFICATION);
        bVar.a("/cgi-bin/mmbiz-bin/js-authorize", gdt_analysis_event.EVENT_GET_JAVA_VM_VERSION);
        bVar.a("/cgi-bin/mmbiz-bin/js-authorize-confirm", gdt_analysis_event.EVENT_GET_QIMEI36);
        bVar.a("/cgi-bin/mmbiz-bin/js-login", 1029);
        bVar.a("/cgi-bin/mmbiz-bin/js-login-confirm", 1117);
        bVar.a("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
        bVar.a("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp", 1122);
        bVar.a("/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync", gdt_analysis_event.EVENT_GET_WEBVIEW_USER_AGENT);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl", 1139);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord", 1149);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp_modauth", 1188);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl", 1139);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo", 1718);
        bVar.a("/cgi-bin/micromsg-bin/rcptinfoquery", 417);
        bVar.a("/cgi-bin/mmbiz-bin/jsapi-preverify", 1093);
        bVar.a("/cgi-bin/mmbiz-bin/jsapi-auth", 1095);
        bVar.a("/cgi-bin/mmbiz-bin/jsapi-setauth", 1096);
        bVar.a("/cgi-bin/mmbiz-bin/jsapi-realtimeverify", 1094);
        bVar.a("/cgi-bin/mmbiz-bin/js-refreshsession", 1196);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/getruntimesession", 3540);
        bVar.a("/cgi-bin/mmbiz-bin/oauth_authorize", 1254);
        bVar.a("/cgi-bin/mmbiz-bin/oauth_authorize_confirm", 1373);
        bVar.a("/cgi-bin/mmbiz-bin/wxartrappsvr/route", 2946);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/getdeeplinkticket", 1172);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/getdeeplinkinfo", 1081);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo", 2921);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/batchreport", 4336);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo", 1124);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/getwxadebuginfo", 1113);
        bVar.a("/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent", 1129);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/getpubliclibinfo", 1168);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/checkwebviewurl", 4759);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord", 1839);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord", 1148);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/hostattrsync", 5183);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl", 1713);
        bVar.a("/cgi-bin/mmoc-bin/ad/addatareport", 1295);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", 4428);
        bVar.a("/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport", 1009);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/checkuserstarrecord", 4831);
        bVar.a("/cgi-bin/mmgame-bin/getwxagameconfig", 2955);
        bVar.a("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode", 1479);
        bVar.a("/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo", 3827);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/fetchdata", 1733);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession", 2985);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/joincloudimroom", 1991);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/reportusercheckphoneprivacy", 7056);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/devicelogin", PlayerResources.RawId.RAW_DOME_OBJ);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/wxasearch", 4706);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/getapprelation", 5094);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/getuserinfo", 4466);
        bVar.a("/cgi-bin/mmbiz-bin/wxaruntime/workflow", 29183);
        bVar.a("/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo", 2921);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp_getwxauseuserinforecordlist", 2690);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
        bVar.a("/cgi-bin/mmbiz-bin/wxaapp_moduseuserinfo", 4891);
        bVar.a("/cgi-bin/mmbiz-bin/wxaweos/getgpsbyip", 4507);
        lazy = LazyKt__LazyJVMKt.lazy(a.f137159a);
        f137158c = lazy;
    }

    public static final int a() {
        return r0.f141701b;
    }

    public final String b() {
        return (String) f137158c.getValue();
    }

    public final int c() {
        return r0.f141700a;
    }

    public final int a(String str) {
        b bVar = f137157b;
        if (str == null) {
            str = "";
        }
        return bVar.a(str);
    }
}
