package com.tencent.mobileqq.guild.jump.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IJumpParserApi extends QRouteApi {

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public d f226402b = new C7808a();

        /* renamed from: a, reason: collision with root package name */
        public c f226401a = new b();

        /* renamed from: c, reason: collision with root package name */
        public e f226403c = new c();

        /* renamed from: com.tencent.mobileqq.guild.jump.api.IJumpParserApi$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        class C7808a implements d {
            C7808a() {
            }

            @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.d
            public String a() {
                return "";
            }
        }

        /* loaded from: classes13.dex */
        class b implements c {
            b() {
            }

            @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.c
            public String getPackageName() {
                return "";
            }
        }

        /* loaded from: classes13.dex */
        class c implements e {
            c() {
            }

            @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.e
            public String getSource() {
                return "";
            }
        }

        public String a() {
            c cVar = this.f226401a;
            if (cVar != null) {
                return cVar.getPackageName();
            }
            return "";
        }

        public String b() {
            d dVar = this.f226402b;
            if (dVar != null) {
                return dVar.a();
            }
            return "";
        }

        public String c() {
            e eVar = this.f226403c;
            if (eVar != null) {
                return eVar.getSource();
            }
            return "";
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes13.dex */
    public interface c {
        String getPackageName();
    }

    /* loaded from: classes13.dex */
    public interface d {
        String a();
    }

    /* loaded from: classes13.dex */
    public interface e {
        String getSource();
    }

    b createActionable(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult, a aVar);

    b createActionableForRobot(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult, a aVar);
}
