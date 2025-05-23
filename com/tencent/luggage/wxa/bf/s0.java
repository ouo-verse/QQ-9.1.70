package com.tencent.luggage.wxa.bf;

import android.net.Uri;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.luggage.wxa.rc.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s0 extends com.tencent.luggage.wxa.rc.y {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f122562a;

        public a(com.tencent.luggage.wxa.c5.e eVar) {
            this.f122562a = eVar;
        }

        @Override // com.tencent.luggage.wxa.rc.g.a
        public com.tencent.luggage.wxa.xd.d a() {
            return this.f122562a.h0();
        }
    }

    static {
        com.tencent.luggage.wxa.aa.h.b("appbrandcommon", s0.class.getClassLoader());
    }

    public s0(com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.bf.a aVar) {
        super(new LinkedList());
        com.tencent.luggage.wxa.mc.b0 b0Var = new com.tencent.luggage.wxa.mc.b0(eVar);
        b().clear();
        com.tencent.luggage.wxa.rc.g gVar = new com.tencent.luggage.wxa.rc.g(e() + eVar.getAppId() + "/blobTmp/", eVar.getAppId(), "wxblob://", new a(eVar));
        gVar.setMaxTotalSize(aVar.f122514a * 1048576);
        b().add(gVar);
        com.tencent.luggage.wxa.rc.o d16 = d(eVar.getAppId());
        d16.setMaxTotalSize(aVar.f122514a * 1048576);
        com.tencent.luggage.wxa.rc.c0 b16 = b(com.tencent.luggage.wxa.y8.h.a(eVar.S().f130798j0), eVar.getAppId());
        b16.setMaxTotalSize(aVar.f122514a * 1048576);
        com.tencent.luggage.wxa.rc.c0 c16 = c(com.tencent.luggage.wxa.y8.h.a(eVar.S().f130798j0), eVar.getAppId());
        c16.setMaxTotalSize(aVar.f122518e * 1048576);
        b().add(c16);
        com.tencent.luggage.wxa.rc.c0 d17 = d(com.tencent.luggage.wxa.y8.h.a(eVar.S().f130798j0), eVar.getAppId());
        d17.setMaxTotalSize(aVar.f122519f * 1048576);
        b().add(d17);
        com.tencent.luggage.wxa.rc.c0 a16 = a(com.tencent.luggage.wxa.y8.h.a(eVar.S().f130798j0), eVar.getAppId());
        a16.setMaxTotalSize(Long.MAX_VALUE);
        b().add(a16);
        com.tencent.luggage.wxa.rc.c0 e16 = e(com.tencent.luggage.wxa.y8.h.a(eVar.S().f130798j0), eVar.getAppId());
        e16.setMaxTotalSize(aVar.f122514a * 1048576);
        b().add(e16);
        com.tencent.luggage.wxa.rc.c0 f16 = f();
        f16.setMaxTotalSize(GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT);
        b().add(f16);
        b().add(b16);
        b().add(d16);
        b().add(b0Var);
        initialize();
    }

    public static com.tencent.luggage.wxa.rc.c0 a(String str, String str2) {
        return new com.tencent.luggage.wxa.rc.c0(b(str, str2, "clientdata"), "wxfile://clientdata");
    }

    public static com.tencent.luggage.wxa.rc.c0 b(String str, String str2) {
        return new com.tencent.luggage.wxa.rc.c0(b(str, str2), MiniAppFileManager.WXFILE_PREFIX_USR);
    }

    public static com.tencent.luggage.wxa.rc.c0 c(String str, String str2) {
        return new com.tencent.luggage.wxa.rc.c0(b(str, str2, "opendata"), "wxfile://opendata");
    }

    public static com.tencent.luggage.wxa.rc.o d(String str) {
        return new com.tencent.luggage.wxa.rc.o(e() + str + "/", str, "wxfile://");
    }

    public static String e() {
        return AppBrandLocalMediaObjectManager.c();
    }

    public static com.tencent.luggage.wxa.rc.c0 f() {
        return new com.tencent.luggage.wxa.rc.c0(b("wxsdk"), "wxfile://sdk");
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v allocTempFile(String str) {
        return ((com.tencent.luggage.wxa.rc.o) a(com.tencent.luggage.wxa.rc.o.class)).allocTempFile(str);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l createTempFileFrom(com.tencent.luggage.wxa.cp.v vVar, String str, boolean z16, com.tencent.luggage.wxa.tk.i iVar) {
        return ((com.tencent.luggage.wxa.rc.o) a(com.tencent.luggage.wxa.rc.o.class)).createTempFileFrom(vVar, str, z16, iVar);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public List getSavedFileList() {
        return ((com.tencent.luggage.wxa.rc.o) a(com.tencent.luggage.wxa.rc.o.class)).getSavedFileList();
    }

    @Override // com.tencent.luggage.wxa.rc.y, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l readDir(String str, com.tencent.luggage.wxa.tk.i iVar) {
        Uri parse = Uri.parse(str);
        if ("wxfile".equals(parse.getScheme()) && com.tencent.luggage.wxa.tn.w0.c(parse.getAuthority())) {
            LinkedList linkedList = new LinkedList();
            ((com.tencent.luggage.wxa.rc.o) a(com.tencent.luggage.wxa.rc.o.class)).readDir("", iVar);
            if (!com.tencent.luggage.wxa.tn.w0.a((List) iVar.f141499a)) {
                for (com.tencent.luggage.wxa.rc.j jVar : (List) iVar.f141499a) {
                    jVar.f139536a = jVar.f139536a.replaceFirst(Pattern.quote("wxfile://"), "");
                }
            }
            com.tencent.luggage.wxa.h6.c.a(linkedList, (List) iVar.f141499a);
            ((com.tencent.luggage.wxa.rc.c0) a(MiniAppFileManager.WXFILE_PREFIX_USR)).readDir(MiniAppFileManager.WXFILE_PREFIX_USR, iVar);
            com.tencent.luggage.wxa.h6.c.a(linkedList, (List) iVar.f141499a);
            iVar.f141499a = linkedList;
            return com.tencent.luggage.wxa.rc.l.OK;
        }
        return super.readDir(str, iVar);
    }

    public static String a(String... strArr) {
        StringBuilder sb5 = new StringBuilder(";");
        for (String str : strArr) {
            sb5.append(com.tencent.luggage.wxa.tn.w0.d(str));
            sb5.append(';');
        }
        return com.tencent.luggage.wxa.y8.c.a(sb5.toString().getBytes());
    }

    public static String b(String... strArr) {
        com.tencent.luggage.wxa.cp.v c16 = c();
        if (c16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
            return null;
        }
        return new com.tencent.luggage.wxa.cp.v(c16.m() + "/" + a(strArr)).m();
    }

    public static com.tencent.luggage.wxa.cp.v c() {
        if (!com.tencent.luggage.wxa.aa.b.a()) {
            return null;
        }
        String a16 = com.tencent.luggage.wxa.tk.c.a();
        if (!a16.endsWith("/")) {
            a16 = a16 + "/";
        }
        return new com.tencent.luggage.wxa.cp.v(a16 + "wxanewfiles/");
    }

    public static com.tencent.luggage.wxa.rc.c0 e(String str, String str2) {
        return new com.tencent.luggage.wxa.rc.c0(b(str, str2, "singlePage"), "wxfile://singlepage");
    }

    public static com.tencent.luggage.wxa.rc.c0 d(String str, String str2) {
        return new com.tencent.luggage.wxa.rc.c0(b(str, str2, "wxprivate"), "wxfile://__wxprivate__");
    }
}
