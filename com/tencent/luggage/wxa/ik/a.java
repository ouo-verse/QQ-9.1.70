package com.tencent.luggage.wxa.ik;

import com.tencent.luggage.wxa.hi.b;
import com.tencent.luggage.wxa.hi.e;
import com.tencent.luggage.wxa.hi.f;
import com.tencent.luggage.wxa.hi.g;
import com.tencent.luggage.wxa.hi.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements com.tencent.luggage.wxa.hi.a {
    public static b A;
    public static b B;
    public static b C;
    public static b D;
    public static b E;
    public static b F;
    public static b G;
    public static b H;
    public static b I;
    public static b J;
    public static b K;
    public static b L;
    public static b M;
    public static b N;
    public static b O;
    public static b P;
    public static b Q;
    public static b R;
    public static b S;
    public static b T;
    public static b U;
    public static b V;
    public static b W;
    public static b X;
    public static b Y;
    public static b Z;

    /* renamed from: a, reason: collision with root package name */
    public static b f130619a;

    /* renamed from: a0, reason: collision with root package name */
    public static b f130620a0;

    /* renamed from: b, reason: collision with root package name */
    public static b f130621b;

    /* renamed from: c, reason: collision with root package name */
    public static b f130622c;

    /* renamed from: d, reason: collision with root package name */
    public static b f130623d;

    /* renamed from: e, reason: collision with root package name */
    public static b f130624e;

    /* renamed from: f, reason: collision with root package name */
    public static b f130625f;

    /* renamed from: g, reason: collision with root package name */
    public static b f130626g;

    /* renamed from: h, reason: collision with root package name */
    public static b f130627h;

    /* renamed from: i, reason: collision with root package name */
    public static b f130628i;

    /* renamed from: j, reason: collision with root package name */
    public static b f130629j;

    /* renamed from: k, reason: collision with root package name */
    public static b f130630k;

    /* renamed from: l, reason: collision with root package name */
    public static b f130631l;

    /* renamed from: m, reason: collision with root package name */
    public static b f130632m;

    /* renamed from: n, reason: collision with root package name */
    public static b f130633n;

    /* renamed from: o, reason: collision with root package name */
    public static b f130634o;

    /* renamed from: p, reason: collision with root package name */
    public static b f130635p;

    /* renamed from: q, reason: collision with root package name */
    public static b f130636q;

    /* renamed from: r, reason: collision with root package name */
    public static b f130637r;

    /* renamed from: s, reason: collision with root package name */
    public static b f130638s;
    public static final List<e> sStepNodes;

    /* renamed from: t, reason: collision with root package name */
    public static b f130639t;

    /* renamed from: u, reason: collision with root package name */
    public static b f130640u;

    /* renamed from: v, reason: collision with root package name */
    public static b f130641v;

    /* renamed from: w, reason: collision with root package name */
    public static b f130642w;

    /* renamed from: x, reason: collision with root package name */
    public static b f130643x;

    /* renamed from: y, reason: collision with root package name */
    public static b f130644y;

    /* renamed from: z, reason: collision with root package name */
    public static b f130645z;

    static {
        ArrayList arrayList = new ArrayList();
        sStepNodes = arrayList;
        arrayList.add(new j("WeAppLaunch"));
        f fVar = new f("WeAppLaunch", "Launch", true, false, "", 2, 0, 0, "");
        f130619a = fVar;
        arrayList.add(fVar);
        f fVar2 = new f("WeAppLaunch", "GetContact", true, false, "", 3, 0, 1, "");
        f130621b = fVar2;
        arrayList.add(fVar2);
        f fVar3 = new f("WeAppLaunch", "GetContact_DB", true, true, "\u8bfb\u53d6contact\u4fe1\u606f", 1, 1, Integer.MIN_VALUE, "");
        f130622c = fVar3;
        arrayList.add(fVar3);
        f fVar4 = new f("WeAppLaunch", "GetContact_CGI", false, true, "\u62c9contact cgi", 1, 1, Integer.MIN_VALUE, "");
        f130623d = fVar4;
        arrayList.add(fVar4);
        f fVar5 = new f("WeAppLaunch", "CheckBan", true, false, "\u5c01\u7981\u903b\u8f91", 1, 0, Integer.MIN_VALUE, "");
        f130624e = fVar5;
        arrayList.add(fVar5);
        f fVar6 = new f("WeAppLaunch", "ContainerUILaunch", true, true, "\u62c9\u8d77\u5bb9\u5668UI\u754c\u9762", 1, 0, Integer.MIN_VALUE, "");
        f130625f = fVar6;
        arrayList.add(fVar6);
        f fVar7 = new f("WeAppLaunch", "PrepareRuntime", true, false, "", 3, 0, 2, "");
        f130626g = fVar7;
        arrayList.add(fVar7);
        f fVar8 = new f("WeAppLaunch", "PrepareMainProcess", true, true, "\u51c6\u5907\u4e3b\u8fdb\u7a0b\u901a\u8baf", 1, 2, Integer.MIN_VALUE, "");
        f130627h = fVar8;
        arrayList.add(fVar8);
        f fVar9 = new f("WeAppLaunch", "InstallLibraries", true, true, "\u52a8\u6001\u5b89\u88c5\u5c0f\u7a0b\u5e8f\u73af\u5883\u6240\u9700\u4e8c\u8fdb\u5236\u5e93", 1, 2, Integer.MIN_VALUE, "");
        f130628i = fVar9;
        arrayList.add(fVar9);
        f fVar10 = new f("WeAppLaunch", "PrepareWebView", true, true, "\u51c6\u5907WebView (View)", 1, 2, Integer.MIN_VALUE, "");
        f130629j = fVar10;
        arrayList.add(fVar10);
        f fVar11 = new f("WeAppLaunch", "PrepareResourceGroup", true, false, "Launch CGI\u53ca\u51c6\u5907\u5c0f\u7a0b\u5e8f\u5305", 3, 2, 3, "");
        f130630k = fVar11;
        arrayList.add(fVar11);
        f fVar12 = new f("WeAppLaunch", "PrepareResourceProcess", true, false, "\u8d44\u6e90\u51c6\u5907\u903b\u8f91\u8fc7\u7a0b", 1, 3, Integer.MIN_VALUE, "");
        f130631l = fVar12;
        arrayList.add(fVar12);
        f fVar13 = new f("WeAppLaunch", "PrepareResourceWaitForResult", true, false, "runtime\u76d1\u542c\u8fc7\u7a0b\u7ed3\u679c", 1, 3, Integer.MIN_VALUE, "");
        f130632m = fVar13;
        arrayList.add(fVar13);
        f fVar14 = new f("WeAppLaunch", "PrepareResourceTimeout", true, true, "\u8d44\u6e90\u51c6\u590710s\u8d85\u65f6\u4e8b\u4ef6", 1, 3, Integer.MIN_VALUE, "");
        f130633n = fVar14;
        arrayList.add(fVar14);
        f fVar15 = new f("WeAppLaunch", "PrepareResourceSubProcessLaunchWxaApp_DB", true, true, "\u4f7f\u7528\u672c\u5730\u7f13\u5b58\u7684launch\u6570\u636e\u6253\u5f00", 1, 3, Integer.MIN_VALUE, "");
        f130634o = fVar15;
        arrayList.add(fVar15);
        f fVar16 = new f("WeAppLaunch", "PrepareResourceSubProcessLaunchWxaApp_CGI", true, true, "\u540c\u6b65\u8bf7\u6c42launch\u6570\u636e\u6253\u5f00", 1, 3, Integer.MIN_VALUE, "");
        f130635p = fVar16;
        arrayList.add(fVar16);
        f fVar17 = new f("WeAppLaunch", "PrepareResourceSubProcessCodePkg_DB", true, true, "\u4f7f\u7528\u672c\u5730\u7f13\u5b58\u597d\u7684\u4ee3\u7801\u5305\u6253\u5f00", 1, 3, Integer.MIN_VALUE, "");
        f130636q = fVar17;
        arrayList.add(fVar17);
        f fVar18 = new f("WeAppLaunch", "PrepareResourceSubProcessCodePkg_Download", true, true, "\u540c\u6b65\u4e0b\u8f7d\u4ee3\u7801\u5305\u6253\u5f00", 1, 3, Integer.MIN_VALUE, "");
        f130637r = fVar18;
        arrayList.add(fVar18);
        f fVar19 = new f("WeAppLaunch", "SetupConfigsPostResourcePrepared", true, false, "\u8d44\u6e90\u51c6\u5907\u5b8c\u7684\u914d\u7f6e\u89e3\u6790", 1, 2, Integer.MIN_VALUE, "");
        f130638s = fVar19;
        arrayList.add(fVar19);
        f fVar20 = new f("WeAppLaunch", "WaitForCommLibConfirm", true, true, "\u786e\u5b9a\u57fa\u7840\u5e93\u7248\u672c", 1, 2, Integer.MIN_VALUE, "");
        f130639t = fVar20;
        arrayList.add(fVar20);
        f fVar21 = new f("WeAppLaunch", "WaitForWebViewPreloadDone", true, true, "\u7b49\u5f85\u542f\u52a8\u524d\u9884\u52a0\u8f7dwebview\u5b8c\u6210 (View)", 1, 2, Integer.MIN_VALUE, "");
        f130640u = fVar21;
        arrayList.add(fVar21);
        f fVar22 = new f("WeAppLaunch", "WaitForWebViewAheadPreloadDone", true, true, "\u7b49\u5f85\u8fd0\u884c\u65f6\u9884\u52a0\u8f7dwebview\u5b8c\u6210 (View)", 1, 2, Integer.MIN_VALUE, "");
        f130641v = fVar22;
        arrayList.add(fVar22);
        f fVar23 = new f("WeAppLaunch", "WaitForAppServicePreloadDone", true, true, "\u7b49\u5f85\u542f\u52a8\u524d\u9884\u52a0\u8f7dappservice\u5b8c\u6210 (Service)", 1, 2, Integer.MIN_VALUE, "");
        f130642w = fVar23;
        arrayList.add(fVar23);
        f fVar24 = new f("WeAppLaunch", "WaitForAppServiceAheadPreloadDone", true, true, "\u7b49\u5f85\u8fd0\u884c\u65f6\u9884\u52a0\u8f7dappservice\u5b8c\u6210 (Service)", 1, 2, Integer.MIN_VALUE, "");
        f130643x = fVar24;
        arrayList.add(fVar24);
        f fVar25 = new f("WeAppLaunch", "InitRuntimeGroup", true, false, "", 3, 0, 4, "mp");
        f130644y = fVar25;
        arrayList.add(fVar25);
        f fVar26 = new f("WeAppLaunch", "ServiceInit", true, false, "", 2, 4, 5, "");
        f130645z = fVar26;
        arrayList.add(fVar26);
        f fVar27 = new f("WeAppLaunch", "InjectJSWAMainContext", true, true, "\u6ce8\u5165WAMainContext.js (Service)", 1, 5, Integer.MIN_VALUE, "");
        A = fVar27;
        arrayList.add(fVar27);
        f fVar28 = new f("WeAppLaunch", "InjectJSWASubContext", true, true, "\u6ce8\u5165WASubContext.js (Service)", 1, 5, Integer.MIN_VALUE, "");
        B = fVar28;
        arrayList.add(fVar28);
        f fVar29 = new f("WeAppLaunch", "InjectJSAppService", true, true, "\u6ce8\u5165appservice.js (Service)", 1, 5, Integer.MIN_VALUE, "");
        C = fVar29;
        arrayList.add(fVar29);
        f fVar30 = new f("WeAppLaunch", "InjectWxConfig", true, true, "\u6ce8\u5165wxConfig (Service)", 1, 5, Integer.MIN_VALUE, "");
        D = fVar30;
        arrayList.add(fVar30);
        f fVar31 = new f("WeAppLaunch", "PageInit", true, false, "", 2, 4, 6, "");
        E = fVar31;
        arrayList.add(fVar31);
        f fVar32 = new f("WeAppLaunch", "PageInitUIGroup", true, false, "", 3, 6, 7, "");
        F = fVar32;
        arrayList.add(fVar32);
        f fVar33 = new f("WeAppLaunch", "CreatePageUI", true, false, "\u9996\u9875\u754c\u9762\u521b\u5efa", 1, 7, Integer.MIN_VALUE, "");
        G = fVar33;
        arrayList.add(fVar33);
        f fVar34 = new f("WeAppLaunch", "CreateWebViewInstance", true, true, "", 1, 7, Integer.MIN_VALUE, "");
        H = fVar34;
        arrayList.add(fVar34);
        f fVar35 = new f("WeAppLaunch", "InjectWAPageFrameHtml", true, true, "\u6ce8\u5165WAPageframe.html (View)", 1, 6, Integer.MIN_VALUE, "");
        I = fVar35;
        arrayList.add(fVar35);
        f fVar36 = new f("WeAppLaunch", "InjectJSWAWebview", true, true, "\u6ce8\u5165WAWebview.js (View)", 1, 6, Integer.MIN_VALUE, "");
        J = fVar36;
        arrayList.add(fVar36);
        f fVar37 = new f("WeAppLaunch", "InjectJSPageScript", true, false, "\u9875\u9762js\u6ce8\u5165 (View)", 1, 6, Integer.MIN_VALUE, "");
        K = fVar37;
        arrayList.add(fVar37);
        f fVar38 = new f("WeAppLaunch", "GenerateFuncReadyRespond", false, false, "webview\u53d1\u51fa\u7684GenerateFuncReady\u88abappservice\u54cd\u5e94 (View)", 1, 6, Integer.MIN_VALUE, "");
        L = fVar38;
        arrayList.add(fVar38);
        f fVar39 = new f("WeAppLaunch", "VdSync", true, false, "\u7b2c\u4e00\u6b21VdSync (View) ", 1, 6, Integer.MIN_VALUE, "");
        M = fVar39;
        arrayList.add(fVar39);
        f fVar40 = new f("WeAppLaunch", "PageReady", true, false, "page ready (View)", 1, 6, Integer.MIN_VALUE, "");
        N = fVar40;
        arrayList.add(fVar40);
        f fVar41 = new f("WeAppLaunch", "InitRuntimeGroup_Game", true, false, "", 3, 0, 8, "game");
        O = fVar41;
        arrayList.add(fVar41);
        f fVar42 = new f("WeAppLaunch", "ServiceInit_Game", true, false, "", 2, 8, 9, "");
        P = fVar42;
        arrayList.add(fVar42);
        f fVar43 = new f("WeAppLaunch", "InjectWAGameContext", true, true, "\u6ce8\u5165 WAGame.js (Service)", 1, 9, Integer.MIN_VALUE, "");
        Q = fVar43;
        arrayList.add(fVar43);
        f fVar44 = new f("WeAppLaunch", "InjectWAGameSubContext", true, true, "\u6ce8\u5165 WAGameSubContext.js (Service) ", 1, 9, Integer.MIN_VALUE, "");
        R = fVar44;
        arrayList.add(fVar44);
        f fVar45 = new f("WeAppLaunch", "InjectJSGame", true, true, "\u6ce8\u5165game.js (Service)", 1, 9, Integer.MIN_VALUE, "");
        S = fVar45;
        arrayList.add(fVar45);
        f fVar46 = new f("WeAppLaunch", "InjectWxConfig_Game", true, true, "\u6ce8\u5165wxConfig (Service)", 1, 9, Integer.MIN_VALUE, "");
        T = fVar46;
        arrayList.add(fVar46);
        f fVar47 = new f("WeAppLaunch", "PageInit_Game", true, false, "", 2, 8, 10, "");
        U = fVar47;
        arrayList.add(fVar47);
        f fVar48 = new f("WeAppLaunch", "PageInitUIGroup_Game", true, false, "", 3, 10, 11, "");
        V = fVar48;
        arrayList.add(fVar48);
        f fVar49 = new f("WeAppLaunch", "CreatePageUI_Game", true, false, "\u9996\u9875\u754c\u9762\u521b\u5efa", 1, 11, Integer.MIN_VALUE, "");
        W = fVar49;
        arrayList.add(fVar49);
        f fVar50 = new f("WeAppLaunch", "CreateMagicBrushView", true, true, "", 1, 11, Integer.MIN_VALUE, "");
        X = fVar50;
        arrayList.add(fVar50);
        f fVar51 = new f("WeAppLaunch", "SurfaceAvailable", true, false, "SurfaceAvailable (View)", 1, 10, Integer.MIN_VALUE, "");
        Y = fVar51;
        arrayList.add(fVar51);
        f fVar52 = new f("WeAppLaunch", "PageReady_Game", true, false, "page ready (View)", 1, 10, Integer.MIN_VALUE, "");
        Z = fVar52;
        arrayList.add(fVar52);
        f fVar53 = new f("WeAppLaunch", "ColdLaunchFailed", true, true, "", 1, 0, Integer.MIN_VALUE, "");
        f130620a0 = fVar53;
        arrayList.add(fVar53);
        arrayList.add(new g("WeAppLaunch"));
    }
}
