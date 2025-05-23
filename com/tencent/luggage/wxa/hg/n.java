package com.tencent.luggage.wxa.hg;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.hg.m;
import com.tencent.mobileqq.data.MessageForRichState;
import cooperation.qzone.QZoneHelper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum n implements com.tencent.luggage.wxa.hg.a {
    Sm2GenKeyPair { // from class: com.tencent.luggage.wxa.hg.n.u
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2GenKeyPair.operate");
            byte[][] c16 = com.tencent.luggage.wxa.cr.c.a().c();
            if (c16 != null && 2 <= c16.length && c16[0] != null && c16[1] != null) {
                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                com.tencent.luggage.wxa.r4.d a16 = params.a();
                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("privateKey", com.tencent.luggage.wxa.uk.c0.a(c16[0])), TuplesKt.to("publicKey", com.tencent.luggage.wxa.uk.c0.a(c16[1])));
                return aVar.a(a16, OK, mutableMapOf);
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2GenKeyPair.operate, keyPair is illegal");
            com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
            Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
            return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
        }
    },
    Sm2GenPublicKey { // from class: com.tencent.luggage.wxa.hg.n.v
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2GenPublicKey.operate");
            d.a b16 = n.f127144c.b(params, "privateKey");
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] a16 = com.tencent.luggage.wxa.cr.c.a().a((byte[]) bVar.a());
                    if (a16 == null) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2GenPublicKey.operate, publicKey is null");
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                    com.tencent.luggage.wxa.r4.d a17 = params.a();
                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("publicKey", com.tencent.luggage.wxa.uk.c0.a(a16)));
                    return aVar.a(a17, OK, mutableMapOf);
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm2EncryptWithMode { // from class: com.tencent.luggage.wxa.hg.n.t
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2EncryptWithMode.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "publicKey");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a a16 = dVar.a(params, "cipherMode");
                            if (a16 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) a16;
                                if (bVar3.a() instanceof com.tencent.luggage.wxa.hg.g) {
                                    byte[] b18 = com.tencent.luggage.wxa.cr.c.a().b(bArr, bArr2, ((com.tencent.luggage.wxa.hg.g) bVar3.a()).d());
                                    if (b18 == null) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2EncryptWithMode.operate, ciphertext is null");
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                    com.tencent.luggage.wxa.r4.d a17 = params.a();
                                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(b18)));
                                    return aVar.a(a17, OK, mutableMapOf);
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) a16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm2DecryptWithMode { // from class: com.tencent.luggage.wxa.hg.n.r
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2DecryptWithMode.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "privateKey");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a a16 = dVar.a(params, "cipherMode");
                            if (a16 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) a16;
                                if (bVar3.a() instanceof com.tencent.luggage.wxa.hg.g) {
                                    byte[] a17 = com.tencent.luggage.wxa.cr.c.a().a(bArr, bArr2, ((com.tencent.luggage.wxa.hg.g) bVar3.a()).d());
                                    if (a17 == null) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2DecryptWithMode.operate, plaintext is null");
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                    com.tencent.luggage.wxa.r4.d a18 = params.a();
                                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(a17)));
                                    return aVar.a(a18, OK, mutableMapOf);
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) a16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm2SignWithMode { // from class: com.tencent.luggage.wxa.hg.n.x
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2SignWithMode.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, "message");
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "uid");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "privateKey");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    byte[] bArr3 = (byte[]) bVar3.a();
                                    d.a b19 = dVar.b(params, "publicKey");
                                    if (b19 instanceof d.a.b) {
                                        d.a.b bVar4 = (d.a.b) b19;
                                        if (bVar4.a() instanceof byte[]) {
                                            byte[] bArr4 = (byte[]) bVar4.a();
                                            d.a c16 = dVar.c(params, "signMode");
                                            if (c16 instanceof d.a.b) {
                                                d.a.b bVar5 = (d.a.b) c16;
                                                if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.i) {
                                                    byte[] a16 = com.tencent.luggage.wxa.cr.c.a().a(bArr, bArr2, bArr3, bArr4, ((com.tencent.luggage.wxa.hg.i) bVar5.a()).d());
                                                    if (a16 == null) {
                                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2SignWithMode.operate, signed is null");
                                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                                    }
                                                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                    com.tencent.luggage.wxa.r4.d a17 = params.a();
                                                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("signed", com.tencent.luggage.wxa.uk.c0.a(a16)));
                                                    return aVar.a(a17, OK, mutableMapOf);
                                                }
                                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                            }
                                            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                            return ((d.a.C6264a) c16).a();
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b19, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b19).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR6 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR6, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR6, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm2VerifyWithMode { // from class: com.tencent.luggage.wxa.hg.n.z
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2VerifyWithMode.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, "message");
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "uid");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "signed");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    byte[] bArr3 = (byte[]) bVar3.a();
                                    d.a b19 = dVar.b(params, "publicKey");
                                    if (b19 instanceof d.a.b) {
                                        d.a.b bVar4 = (d.a.b) b19;
                                        if (bVar4.a() instanceof byte[]) {
                                            byte[] bArr4 = (byte[]) bVar4.a();
                                            d.a c16 = dVar.c(params, "signMode");
                                            if (c16 instanceof d.a.b) {
                                                d.a.b bVar5 = (d.a.b) c16;
                                                if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.i) {
                                                    boolean b26 = com.tencent.luggage.wxa.cr.c.a().b(bArr, bArr2, bArr3, bArr4, ((com.tencent.luggage.wxa.hg.i) bVar5.a()).d());
                                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2VerifyWithMode.operate, success: " + b26);
                                                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("success", Boolean.valueOf(b26)));
                                                    return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                                                }
                                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                            }
                                            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                            return ((d.a.C6264a) c16).a();
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b19, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b19).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm3 { // from class: com.tencent.luggage.wxa.hg.n.a0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm3.operate");
            d.a b16 = n.f127144c.b(params, "message");
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] b17 = com.tencent.luggage.wxa.cr.c.a().b((byte[]) bVar.a());
                    if (b17 == null) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm3.operate, digest is null");
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                    com.tencent.luggage.wxa.r4.d a16 = params.a();
                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, com.tencent.luggage.wxa.uk.c0.a(b17)));
                    return aVar.a(a16, OK, mutableMapOf);
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm3Hmac { // from class: com.tencent.luggage.wxa.hg.n.b0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm3Hmac.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, "message");
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "key");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] a16 = com.tencent.luggage.wxa.cr.c.a().a(bArr, (byte[]) bVar2.a());
                            if (a16 == null) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm3Hmac.operate, mac is null");
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                            }
                            m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                            com.tencent.luggage.wxa.r4.d a17 = params.a();
                            com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                            Intrinsics.checkNotNullExpressionValue(OK, "OK");
                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("mac", com.tencent.luggage.wxa.uk.c0.a(a16)));
                            return aVar.a(a17, OK, mutableMapOf);
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    GenRandomBytes { // from class: com.tencent.luggage.wxa.hg.n.k
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "GenRandomBytes.operate");
            try {
                int i3 = params.b().getInt("length");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.SmCryptoInvoker", "GenRandomBytes.operate, len: " + i3);
                byte[] a16 = com.tencent.luggage.wxa.cr.c.a().a(i3);
                if (a16 == null) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "GenRandomBytes.operate, randomBytes is null");
                    com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                    Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                    return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                }
                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                com.tencent.luggage.wxa.r4.d a17 = params.a();
                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("randomBytes", com.tencent.luggage.wxa.uk.c0.a(a16)));
                return aVar.a(a17, OK, mutableMapOf);
            } catch (JSONException unused) {
                com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                return new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null);
            }
        }
    },
    Sm4CbcEncrypt { // from class: com.tencent.luggage.wxa.hg.n.d0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CbcEncrypt.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "key");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "iv");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    try {
                                        byte[] b19 = com.tencent.luggage.wxa.cr.c.a().b(bArr, bArr2, (byte[]) bVar3.a(), params.b().getBoolean("noPadding"));
                                        if (b19 == null) {
                                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CbcEncrypt.operate, ciphertext is null");
                                            com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                            Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                            return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                        }
                                        m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                        com.tencent.luggage.wxa.r4.d a16 = params.a();
                                        com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                        Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(b19)));
                                        return aVar.a(a16, OK, mutableMapOf);
                                    } catch (JSONException unused) {
                                        com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                                        Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                                        return new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null);
                                    }
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm4CbcDecrypt { // from class: com.tencent.luggage.wxa.hg.n.c0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CbcDecrypt.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "key");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "iv");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    try {
                                        byte[] a16 = com.tencent.luggage.wxa.cr.c.a().a(bArr, bArr2, (byte[]) bVar3.a(), params.b().getBoolean("noPadding"));
                                        if (a16 == null) {
                                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CbcDecrypt.operate, plaintext is null");
                                            com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                            Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                            return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                        }
                                        m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                        com.tencent.luggage.wxa.r4.d a17 = params.a();
                                        com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                        Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(a16)));
                                        return aVar.a(a17, OK, mutableMapOf);
                                    } catch (JSONException unused) {
                                        com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                                        Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                                        return new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null);
                                    }
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm4GcmEncrypt { // from class: com.tencent.luggage.wxa.hg.n.j0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4GcmEncrypt.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "key");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "iv");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    byte[] bArr3 = (byte[]) bVar3.a();
                                    d.a b19 = dVar.b(params, "aad");
                                    if (b19 instanceof d.a.b) {
                                        d.a.b bVar4 = (d.a.b) b19;
                                        if (bVar4.a() instanceof byte[]) {
                                            byte[][] a16 = com.tencent.luggage.wxa.cr.c.a().a(bArr, bArr2, bArr3, (byte[]) bVar4.a());
                                            if (a16 != null && 2 <= a16.length && a16[0] != null && a16[1] != null) {
                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                com.tencent.luggage.wxa.r4.d a17 = params.a();
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(a16[0])), TuplesKt.to("tag", com.tencent.luggage.wxa.uk.c0.a(a16[1])));
                                                return aVar.a(a17, OK, mutableMapOf);
                                            }
                                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4GcmEncrypt.operate, encryptResult is illegal");
                                            com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                            Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                            return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b19, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b19).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm4GcmDecrypt { // from class: com.tencent.luggage.wxa.hg.n.i0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4GcmDecrypt.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "tag");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "key");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    byte[] bArr3 = (byte[]) bVar3.a();
                                    d.a b19 = dVar.b(params, "iv");
                                    if (b19 instanceof d.a.b) {
                                        d.a.b bVar4 = (d.a.b) b19;
                                        if (bVar4.a() instanceof byte[]) {
                                            byte[] bArr4 = (byte[]) bVar4.a();
                                            d.a b26 = dVar.b(params, "aad");
                                            if (b26 instanceof d.a.b) {
                                                d.a.b bVar5 = (d.a.b) b26;
                                                if (bVar5.a() instanceof byte[]) {
                                                    byte[] a16 = com.tencent.luggage.wxa.cr.c.a().a(bArr, bArr2, bArr3, bArr4, (byte[]) bVar5.a());
                                                    if (a16 == null) {
                                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4GcmDecrypt.operate, plaintext is null");
                                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                                    }
                                                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                    com.tencent.luggage.wxa.r4.d a17 = params.a();
                                                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(a16)));
                                                    return aVar.a(a17, OK, mutableMapOf);
                                                }
                                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                            }
                                            Intrinsics.checkNotNull(b26, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                            return ((d.a.C6264a) b26).a();
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b19, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b19).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR6 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR6, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR6, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm4CtrEncrypt { // from class: com.tencent.luggage.wxa.hg.n.f0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CtrEncrypt.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "key");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "iv");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    byte[] b19 = com.tencent.luggage.wxa.cr.c.a().b(bArr, bArr2, (byte[]) bVar3.a());
                                    if (b19 == null) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CtrEncrypt.operate, ciphertext is null");
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                    com.tencent.luggage.wxa.r4.d a16 = params.a();
                                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(b19)));
                                    return aVar.a(a16, OK, mutableMapOf);
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    Sm4CtrDecrypt { // from class: com.tencent.luggage.wxa.hg.n.e0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CtrDecrypt.operate");
            d dVar = n.f127144c;
            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
            if (b16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) b16;
                if (bVar.a() instanceof byte[]) {
                    byte[] bArr = (byte[]) bVar.a();
                    d.a b17 = dVar.b(params, "key");
                    if (b17 instanceof d.a.b) {
                        d.a.b bVar2 = (d.a.b) b17;
                        if (bVar2.a() instanceof byte[]) {
                            byte[] bArr2 = (byte[]) bVar2.a();
                            d.a b18 = dVar.b(params, "iv");
                            if (b18 instanceof d.a.b) {
                                d.a.b bVar3 = (d.a.b) b18;
                                if (bVar3.a() instanceof byte[]) {
                                    byte[] a16 = com.tencent.luggage.wxa.cr.c.a().a(bArr, bArr2, (byte[]) bVar3.a());
                                    if (a16 == null) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4CtrDecrypt.operate, plaintext is null");
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                    com.tencent.luggage.wxa.r4.d a17 = params.a();
                                    com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                    Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(a16)));
                                    return aVar.a(a17, OK, mutableMapOf);
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b18).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) b17).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) b16).a();
        }
    },
    GenerateSm4Key { // from class: com.tencent.luggage.wxa.hg.n.m
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "GenerateSm4Key.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                bVar2.a((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "GenerateSm4Key.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    ImportSm4Key { // from class: com.tencent.luggage.wxa.hg.n.p
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            boolean z16;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "ImportSm4Key.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a e17 = dVar.e(params, "key");
                            if (e17 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) e17;
                                if (bVar4.a() instanceof String) {
                                    byte[] a17 = dVar.a((String) bVar4.a());
                                    if (a17 != null) {
                                        z16 = com.tencent.luggage.wxa.hg.k.f127136a;
                                        if (z16) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("ImportSm4Key.operate, key: ");
                                            String arrays = Arrays.toString(a17);
                                            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                                            sb5.append(arrays);
                                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", sb5.toString());
                                        }
                                        try {
                                            bVar2.b(str, a17);
                                            com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                            Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                            return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                                        } catch (com.tencent.luggage.wxa.dr.c e18) {
                                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "ImportSm4Key.operate, fail since " + e18);
                                            return n.f127144c.a(e18);
                                        }
                                    }
                                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "ImportSm4Key.operate, decode hexKey fail");
                                    com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                                    Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                                    return new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null);
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                            }
                            Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) e17).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    ExportSm4Key { // from class: com.tencent.luggage.wxa.hg.n.j
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            boolean z16;
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "ExportSm4Key.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                byte[] l3 = bVar2.l((String) bVar3.a());
                                z16 = com.tencent.luggage.wxa.hg.k.f127136a;
                                if (z16) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("ExportSm4Key.operate, key: ");
                                    String arrays = Arrays.toString(l3);
                                    Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                                    sb5.append(arrays);
                                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", sb5.toString());
                                }
                                String a17 = dVar.a(l3);
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("key", a17));
                                return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "ExportSm4Key.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    UpdateSm4Key { // from class: com.tencent.luggage.wxa.hg.n.s0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            boolean z16;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "UpdateSm4Key.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a e17 = dVar.e(params, "key");
                            if (e17 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) e17;
                                if (bVar4.a() instanceof String) {
                                    byte[] a17 = dVar.a((String) bVar4.a());
                                    if (a17 != null) {
                                        z16 = com.tencent.luggage.wxa.hg.k.f127136a;
                                        if (z16) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("UpdateSm4Key.operate, key: ");
                                            String arrays = Arrays.toString(a17);
                                            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                                            sb5.append(arrays);
                                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", sb5.toString());
                                        }
                                        try {
                                            bVar2.a(str, a17);
                                            com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                            Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                            return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                                        } catch (com.tencent.luggage.wxa.dr.c e18) {
                                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "UpdateSm4Key.operate, fail since " + e18);
                                            return n.f127144c.a(e18);
                                        }
                                    }
                                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "UpdateSm4Key.operate, decode hexKey fail");
                                    com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                                    Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                                    return new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null);
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                            }
                            Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) e17).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    DeleteSm4Key { // from class: com.tencent.luggage.wxa.hg.n.g
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "DeleteSm4Key.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                bVar2.f((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "DeleteSm4Key.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    CheckSm4Key { // from class: com.tencent.luggage.wxa.hg.n.c
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "CheckSm4Key.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                boolean e17 = bVar2.e((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("exist", Boolean.valueOf(e17)));
                                return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                            } catch (com.tencent.luggage.wxa.dr.c e18) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "CheckSm4Key.operate, fail since " + e18);
                                return n.f127144c.a(e18);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    GenerateSm2KeyPair { // from class: com.tencent.luggage.wxa.hg.n.l
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "GenerateSm2KeyPair.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                bVar2.k((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "GenerateSm2KeyPair.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    ImportSm2PublicKey { // from class: com.tencent.luggage.wxa.hg.n.o
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "ImportSm2PublicKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a e17 = dVar.e(params, "publicKey");
                            if (e17 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) e17;
                                if (bVar4.a() instanceof String) {
                                    String str2 = (String) bVar4.a();
                                    d.a d16 = dVar.d(params, "sm2KeyFormat");
                                    if (d16 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) d16;
                                        if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.h) {
                                            try {
                                                bVar2.d(str, str2, ((com.tencent.luggage.wxa.hg.h) bVar5.a()).c());
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                                            } catch (com.tencent.luggage.wxa.dr.c e18) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "ImportSm2PublicKey.operate, fail since " + e18);
                                                return n.f127144c.a(e18);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) d16).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) e17).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    ExportSm2PublicKey { // from class: com.tencent.luggage.wxa.hg.n.i
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "ExportSm2PublicKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a d16 = dVar.d(params, "sm2KeyFormat");
                            if (d16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) d16;
                                if (bVar4.a() instanceof com.tencent.luggage.wxa.hg.h) {
                                    try {
                                        String b16 = bVar2.b(str, ((com.tencent.luggage.wxa.hg.h) bVar4.a()).c());
                                        com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                        Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("publicKey", b16));
                                        return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                                    } catch (com.tencent.luggage.wxa.dr.c e17) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "ExportSm2PublicKey.operate, fail since " + e17);
                                        return n.f127144c.a(e17);
                                    }
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                            }
                            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) d16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    UpdateSm2PublicKey { // from class: com.tencent.luggage.wxa.hg.n.r0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "UpdateSm2PublicKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a e17 = dVar.e(params, "publicKey");
                            if (e17 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) e17;
                                if (bVar4.a() instanceof String) {
                                    String str2 = (String) bVar4.a();
                                    d.a d16 = dVar.d(params, "sm2KeyFormat");
                                    if (d16 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) d16;
                                        if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.h) {
                                            try {
                                                bVar2.b(str, str2, ((com.tencent.luggage.wxa.hg.h) bVar5.a()).c());
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                                            } catch (com.tencent.luggage.wxa.dr.c e18) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "UpdateSm2PublicKey.operate, fail since " + e18);
                                                return n.f127144c.a(e18);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) d16).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) e17).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    DeleteSm2PublicKey { // from class: com.tencent.luggage.wxa.hg.n.f
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "DeleteSm2PublicKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                bVar2.j((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "DeleteSm2PublicKey.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    CheckSm2PublicKey { // from class: com.tencent.luggage.wxa.hg.n.b
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "CheckSm2PublicKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                boolean c16 = bVar2.c((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("exist", Boolean.valueOf(c16)));
                                return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "CheckSm2PublicKey.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    ImportSm2PrivateKey { // from class: com.tencent.luggage.wxa.hg.n.n
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "ImportSm2PrivateKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a e17 = dVar.e(params, "privateKey");
                            if (e17 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) e17;
                                if (bVar4.a() instanceof String) {
                                    String str2 = (String) bVar4.a();
                                    d.a d16 = dVar.d(params, "sm2KeyFormat");
                                    if (d16 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) d16;
                                        if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.h) {
                                            try {
                                                bVar2.a(str, str2, ((com.tencent.luggage.wxa.hg.h) bVar5.a()).c());
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                                            } catch (com.tencent.luggage.wxa.dr.c e18) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "ImportSm2PrivateKey.operate, fail since " + e18);
                                                return n.f127144c.a(e18);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) d16).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) e17).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    ExportSm2PrivateKey { // from class: com.tencent.luggage.wxa.hg.n.h
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            String str;
            Map mutableMapOf;
            boolean z16;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "ExportSm2PrivateKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str2 = (String) bVar3.a();
                            d.a d16 = dVar.d(params, "sm2KeyFormat");
                            if (d16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) d16;
                                if (bVar4.a() instanceof com.tencent.luggage.wxa.hg.h) {
                                    try {
                                        String[] a17 = bVar2.a(str2, ((com.tencent.luggage.wxa.hg.h) bVar4.a()).c());
                                        if (a17 != null) {
                                            if (a17.length == 0) {
                                                z16 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            if (!z16) {
                                                str = a17[0];
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("privateKey", str));
                                                return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                                            }
                                        }
                                        str = "";
                                        com.tencent.luggage.wxa.af.c OK2 = com.tencent.luggage.wxa.af.e.f121305a;
                                        Intrinsics.checkNotNullExpressionValue(OK2, "OK");
                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("privateKey", str));
                                        return new com.tencent.luggage.wxa.hg.m(OK2, mutableMapOf);
                                    } catch (com.tencent.luggage.wxa.dr.c e17) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "ExportSm2PrivateKey.operate, fail since " + e17);
                                        return n.f127144c.a(e17);
                                    }
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                            }
                            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) d16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    UpdateSm2PrivateKey { // from class: com.tencent.luggage.wxa.hg.n.q0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "UpdateSm2PrivateKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a e17 = dVar.e(params, "privateKey");
                            if (e17 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) e17;
                                if (bVar4.a() instanceof String) {
                                    String str2 = (String) bVar4.a();
                                    d.a d16 = dVar.d(params, "sm2KeyFormat");
                                    if (d16 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) d16;
                                        if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.h) {
                                            try {
                                                bVar2.c(str, str2, ((com.tencent.luggage.wxa.hg.h) bVar5.a()).c());
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                                            } catch (com.tencent.luggage.wxa.dr.c e18) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "UpdateSm2PrivateKey.operate, fail since " + e18);
                                                return n.f127144c.a(e18);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) d16).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) e17).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    DeleteSm2PrivateKey { // from class: com.tencent.luggage.wxa.hg.n.e
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "DeleteSm2PrivateKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                bVar2.g((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                return new com.tencent.luggage.wxa.hg.m(OK, null, 2, null);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "DeleteSm2PrivateKey.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    CheckSm2PrivateKey { // from class: com.tencent.luggage.wxa.hg.n.a
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "CheckSm2PrivateKey.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            try {
                                boolean d16 = bVar2.d((String) bVar3.a());
                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("exist", Boolean.valueOf(d16)));
                                return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "CheckSm2PrivateKey.operate, fail since " + e17);
                                return n.f127144c.a(e17);
                            }
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    Sm4EcbEncrypt { // from class: com.tencent.luggage.wxa.hg.n.h0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4EcbEncrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    try {
                                        byte[] a17 = bVar2.e().a(str, (byte[]) bVar4.a());
                                        m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                        com.tencent.luggage.wxa.r4.d a18 = params.a();
                                        com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                        Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(a17)));
                                        return aVar.a(a18, OK, mutableMapOf);
                                    } catch (com.tencent.luggage.wxa.dr.c e17) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4EcbEncrypt.operate, fail since " + e17);
                                        return n.f127144c.a(e17);
                                    }
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    Sm4EcbDecrypt { // from class: com.tencent.luggage.wxa.hg.n.g0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4EcbDecrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    try {
                                        byte[] b17 = bVar2.e().b(str, (byte[]) bVar4.a());
                                        m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                        com.tencent.luggage.wxa.r4.d a17 = params.a();
                                        com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                        Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(b17)));
                                        return aVar.a(a17, OK, mutableMapOf);
                                    } catch (com.tencent.luggage.wxa.dr.c e17) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm4EcbDecrypt.operate, fail since " + e17);
                                        return n.f127144c.a(e17);
                                    }
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    SmStorageSm4CbcEncrypt { // from class: com.tencent.luggage.wxa.hg.n.l0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CbcEncrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a b17 = dVar.b(params, "iv");
                                    if (b17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) b17;
                                        if (bVar5.a() instanceof byte[]) {
                                            try {
                                                byte[] d16 = bVar2.e().d(str, bArr, (byte[]) bVar5.a());
                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                com.tencent.luggage.wxa.r4.d a17 = params.a();
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(d16)));
                                                return aVar.a(a17, OK, mutableMapOf);
                                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CbcEncrypt.operate, fail since " + e17);
                                                return n.f127144c.a(e17);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    SmStorageSm4CbcDecrypt { // from class: com.tencent.luggage.wxa.hg.n.k0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CbcDecrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a b17 = dVar.b(params, "iv");
                                    if (b17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) b17;
                                        if (bVar5.a() instanceof byte[]) {
                                            try {
                                                byte[] c16 = bVar2.e().c(str, bArr, (byte[]) bVar5.a());
                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                com.tencent.luggage.wxa.r4.d a17 = params.a();
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(c16)));
                                                return aVar.a(a17, OK, mutableMapOf);
                                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CbcDecrypt.operate, fail since " + e17);
                                                return n.f127144c.a(e17);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    SmStorageSm4CtrEncrypt { // from class: com.tencent.luggage.wxa.hg.n.n0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CtrEncrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a b17 = dVar.b(params, "iv");
                                    if (b17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) b17;
                                        if (bVar5.a() instanceof byte[]) {
                                            try {
                                                byte[] b18 = bVar2.e().b(str, bArr, (byte[]) bVar5.a());
                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                com.tencent.luggage.wxa.r4.d a17 = params.a();
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(b18)));
                                                return aVar.a(a17, OK, mutableMapOf);
                                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CtrEncrypt.operate, fail since " + e17);
                                                return n.f127144c.a(e17);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    SmStorageSm4CtrDecrypt { // from class: com.tencent.luggage.wxa.hg.n.m0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CtrDecrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a b17 = dVar.b(params, "iv");
                                    if (b17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) b17;
                                        if (bVar5.a() instanceof byte[]) {
                                            try {
                                                byte[] a17 = bVar2.e().a(str, bArr, (byte[]) bVar5.a());
                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                com.tencent.luggage.wxa.r4.d a18 = params.a();
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(a17)));
                                                return aVar.a(a18, OK, mutableMapOf);
                                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4CtrDecrypt.operate, fail since " + e17);
                                                return n.f127144c.a(e17);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    SmStorageSm4GcmEncrypt { // from class: com.tencent.luggage.wxa.hg.n.p0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4GcmEncrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a b17 = dVar.b(params, "iv");
                                    if (b17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) b17;
                                        if (bVar5.a() instanceof byte[]) {
                                            byte[] bArr2 = (byte[]) bVar5.a();
                                            d.a b18 = dVar.b(params, "aad");
                                            if (b18 instanceof d.a.b) {
                                                d.a.b bVar6 = (d.a.b) b18;
                                                if (bVar6.a() instanceof byte[]) {
                                                    try {
                                                        byte[][] a17 = bVar2.e().a(str, bArr, bArr2, (byte[]) bVar6.a());
                                                        m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                        com.tencent.luggage.wxa.r4.d a18 = params.a();
                                                        com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                        Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(a17[0])), TuplesKt.to("tag", com.tencent.luggage.wxa.uk.c0.a(a17[1])));
                                                        return aVar.a(a18, OK, mutableMapOf);
                                                    } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4GcmEncrypt.operate, fail since " + e17);
                                                        return n.f127144c.a(e17);
                                                    }
                                                }
                                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                            }
                                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                            return ((d.a.C6264a) b18).a();
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    SmStorageSm4GcmDecrypt { // from class: com.tencent.luggage.wxa.hg.n.o0
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4GcmDecrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a b17 = dVar.b(params, "tag");
                                    if (b17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) b17;
                                        if (bVar5.a() instanceof byte[]) {
                                            byte[] bArr2 = (byte[]) bVar5.a();
                                            d.a b18 = dVar.b(params, "iv");
                                            if (b18 instanceof d.a.b) {
                                                d.a.b bVar6 = (d.a.b) b18;
                                                if (bVar6.a() instanceof byte[]) {
                                                    byte[] bArr3 = (byte[]) bVar6.a();
                                                    d.a b19 = dVar.b(params, "aad");
                                                    if (b19 instanceof d.a.b) {
                                                        d.a.b bVar7 = (d.a.b) b19;
                                                        if (bVar7.a() instanceof byte[]) {
                                                            try {
                                                                byte[] a17 = bVar2.e().a(str, bArr, bArr2, bArr3, (byte[]) bVar7.a());
                                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                                com.tencent.luggage.wxa.r4.d a18 = params.a();
                                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(a17)));
                                                                return aVar.a(a18, OK, mutableMapOf);
                                                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "SmStorageSm4GcmDecrypt.operate, fail since " + e17);
                                                                return n.f127144c.a(e17);
                                                            }
                                                        }
                                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                                    }
                                                    Intrinsics.checkNotNull(b19, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                                    return ((d.a.C6264a) b19).a();
                                                }
                                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                            }
                                            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                            return ((d.a.C6264a) b18).a();
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) b17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR6 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR6, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR6, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    Sm2Encrypt { // from class: com.tencent.luggage.wxa.hg.n.s
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Encrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a a17 = dVar.a(params, "cipherMode");
                                    if (a17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) a17;
                                        if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.g) {
                                            try {
                                                byte[] b17 = bVar2.g().b(str, bArr, ((com.tencent.luggage.wxa.hg.g) bVar5.a()).c());
                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                com.tencent.luggage.wxa.r4.d a18 = params.a();
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QZoneHelper.CIPHERTEXT, com.tencent.luggage.wxa.uk.c0.a(b17)));
                                                return aVar.a(a18, OK, mutableMapOf);
                                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Encrypt.operate, fail since " + e17);
                                                return n.f127144c.a(e17);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(a17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) a17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    Sm2Decrypt { // from class: com.tencent.luggage.wxa.hg.n.q
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Decrypt.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, QZoneHelper.CIPHERTEXT);
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a a17 = dVar.a(params, "cipherMode");
                                    if (a17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) a17;
                                        if (bVar5.a() instanceof com.tencent.luggage.wxa.hg.g) {
                                            try {
                                                byte[] a18 = bVar2.g().a(str, bArr, ((com.tencent.luggage.wxa.hg.g) bVar5.a()).c());
                                                m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                com.tencent.luggage.wxa.r4.d a19 = params.a();
                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, com.tencent.luggage.wxa.uk.c0.a(a18)));
                                                return aVar.a(a19, OK, mutableMapOf);
                                            } catch (com.tencent.luggage.wxa.dr.c e17) {
                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Decrypt.operate, fail since " + e17);
                                                return n.f127144c.a(e17);
                                            }
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(a17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) a17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    Sm2Sign { // from class: com.tencent.luggage.wxa.hg.n.w
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Sign.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, "message");
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a e17 = dVar.e(params, "id");
                                    if (e17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) e17;
                                        if (bVar5.a() instanceof String) {
                                            String str2 = (String) bVar5.a();
                                            d.a c16 = dVar.c(params, "signMode");
                                            if (c16 instanceof d.a.b) {
                                                d.a.b bVar6 = (d.a.b) c16;
                                                if (bVar6.a() instanceof com.tencent.luggage.wxa.hg.i) {
                                                    try {
                                                        byte[] a17 = bVar2.g().a(str, bArr, str2, ((com.tencent.luggage.wxa.hg.i) bVar6.a()).c());
                                                        m.a aVar = com.tencent.luggage.wxa.hg.m.f127139c;
                                                        com.tencent.luggage.wxa.r4.d a18 = params.a();
                                                        com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                        Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("signed", com.tencent.luggage.wxa.uk.c0.a(a17)));
                                                        return aVar.a(a18, OK, mutableMapOf);
                                                    } catch (com.tencent.luggage.wxa.dr.c e18) {
                                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Sign.operate, fail since " + e18);
                                                        return n.f127144c.a(e18);
                                                    }
                                                }
                                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                            }
                                            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                            return ((d.a.C6264a) c16).a();
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) e17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    },
    Sm2Verify { // from class: com.tencent.luggage.wxa.hg.n.y
        @Override // com.tencent.luggage.wxa.hg.a
        public com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.hg.l params) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(params, "params");
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Verify.operate");
            d dVar = n.f127144c;
            d.a a16 = dVar.a(params);
            if (a16 instanceof d.a.b) {
                d.a.b bVar = (d.a.b) a16;
                if (bVar.a() instanceof com.tencent.luggage.wxa.hg.b) {
                    com.tencent.luggage.wxa.hg.b bVar2 = (com.tencent.luggage.wxa.hg.b) bVar.a();
                    d.a e16 = dVar.e(params, "desc");
                    if (e16 instanceof d.a.b) {
                        d.a.b bVar3 = (d.a.b) e16;
                        if (bVar3.a() instanceof String) {
                            String str = (String) bVar3.a();
                            d.a b16 = dVar.b(params, "message");
                            if (b16 instanceof d.a.b) {
                                d.a.b bVar4 = (d.a.b) b16;
                                if (bVar4.a() instanceof byte[]) {
                                    byte[] bArr = (byte[]) bVar4.a();
                                    d.a e17 = dVar.e(params, "id");
                                    if (e17 instanceof d.a.b) {
                                        d.a.b bVar5 = (d.a.b) e17;
                                        if (bVar5.a() instanceof String) {
                                            String str2 = (String) bVar5.a();
                                            d.a b17 = dVar.b(params, "signed");
                                            if (b17 instanceof d.a.b) {
                                                d.a.b bVar6 = (d.a.b) b17;
                                                if (bVar6.a() instanceof byte[]) {
                                                    byte[] bArr2 = (byte[]) bVar6.a();
                                                    d.a c16 = dVar.c(params, "signMode");
                                                    if (c16 instanceof d.a.b) {
                                                        d.a.b bVar7 = (d.a.b) c16;
                                                        if (bVar7.a() instanceof com.tencent.luggage.wxa.hg.i) {
                                                            try {
                                                                boolean a17 = bVar2.g().a(str, bArr, str2, bArr2, ((com.tencent.luggage.wxa.hg.i) bVar7.a()).c());
                                                                com.tencent.luggage.wxa.af.c OK = com.tencent.luggage.wxa.af.e.f121305a;
                                                                Intrinsics.checkNotNullExpressionValue(OK, "OK");
                                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("success", Boolean.valueOf(a17)));
                                                                return new com.tencent.luggage.wxa.hg.m(OK, mutableMapOf);
                                                            } catch (com.tencent.luggage.wxa.dr.c e18) {
                                                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "Sm2Verify.operate, fail since " + e18);
                                                                return n.f127144c.a(e18);
                                                            }
                                                        }
                                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null);
                                                    }
                                                    Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                                    return ((d.a.C6264a) c16).a();
                                                }
                                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null);
                                            }
                                            Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                            return ((d.a.C6264a) b17).a();
                                        }
                                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null);
                                    }
                                    Intrinsics.checkNotNull(e17, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                                    return ((d.a.C6264a) e17).a();
                                }
                                com.tencent.luggage.wxa.af.c INTERNAL_ERROR4 = com.tencent.luggage.wxa.af.e.f121309e;
                                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR4, "INTERNAL_ERROR");
                                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR4, null, 2, null);
                            }
                            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                            return ((d.a.C6264a) b16).a();
                        }
                        com.tencent.luggage.wxa.af.c INTERNAL_ERROR5 = com.tencent.luggage.wxa.af.e.f121309e;
                        Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR5, "INTERNAL_ERROR");
                        return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR5, null, 2, null);
                    }
                    Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
                    return ((d.a.C6264a) e16).a();
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR6 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR6, "INTERNAL_ERROR");
                return new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR6, null, 2, null);
            }
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.sm.SmCryptoOperator.Companion.ParamsParseResult.Failure");
            return ((d.a.C6264a) a16).a();
        }
    };


    /* renamed from: c, reason: collision with root package name */
    public static final d f127144c = new d(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.hg.o f127164a;

    /* renamed from: b, reason: collision with root package name */
    public final String f127165b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static abstract class a {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.hg.n$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6264a extends a {

                /* renamed from: a, reason: collision with root package name */
                public final com.tencent.luggage.wxa.hg.m f127166a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6264a(com.tencent.luggage.wxa.hg.m operateResult) {
                    super(null);
                    Intrinsics.checkNotNullParameter(operateResult, "operateResult");
                    this.f127166a = operateResult;
                }

                public final com.tencent.luggage.wxa.hg.m a() {
                    return this.f127166a;
                }
            }

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class b extends a {

                /* renamed from: a, reason: collision with root package name */
                public final Object f127167a;

                public b(Object obj) {
                    super(null);
                    this.f127167a = obj;
                }

                public final Object a() {
                    return this.f127167a;
                }
            }

            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public static final b f127168a = new b();

            public b() {
                super(1);
            }

            public final CharSequence a(byte b16) {
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                return format;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).byteValue());
            }
        }

        public d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a b(com.tencent.luggage.wxa.hg.l lVar, String str) {
            try {
                Object obj = lVar.b().get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.nio.ByteBuffer");
                return new a.b(com.tencent.luggage.wxa.tk.c.a((ByteBuffer) obj));
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e16, "parseNativeBuffer failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null));
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e17, "parseNativeBuffer failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null));
            }
        }

        public final a c(com.tencent.luggage.wxa.hg.l lVar, String str) {
            a c6264a;
            try {
                com.tencent.luggage.wxa.hg.i a16 = com.tencent.luggage.wxa.hg.i.f127126d.a(lVar.b().getInt(str));
                if (a16 != null) {
                    c6264a = new a.b(a16);
                } else {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "parseSignMode, null");
                    com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                    Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                    c6264a = new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null));
                }
                return c6264a;
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e16, "parseSignMode failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA2 = com.tencent.luggage.wxa.af.e.f121315k;
                Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA2, "INVALID_REQUEST_DATA");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA2, null, 2, null));
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e17, "parseSignMode failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null));
            }
        }

        public final a d(com.tencent.luggage.wxa.hg.l lVar, String str) {
            a c6264a;
            try {
                com.tencent.luggage.wxa.hg.h a16 = com.tencent.luggage.wxa.hg.h.f127120c.a(lVar.b().getInt(str));
                if (a16 != null) {
                    c6264a = new a.b(a16);
                } else {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "parseSm2KeyFormat, null");
                    com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                    Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                    c6264a = new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null));
                }
                return c6264a;
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e16, "parseSm2KeyFormat failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA2 = com.tencent.luggage.wxa.af.e.f121315k;
                Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA2, "INVALID_REQUEST_DATA");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA2, null, 2, null));
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e17, "parseSm2KeyFormat failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null));
            }
        }

        public final a e(com.tencent.luggage.wxa.hg.l lVar, String str) {
            try {
                return new a.b(lVar.b().getString(str));
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e16, "parseString failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null));
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e17, "parseString failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null));
            }
        }

        public final a a(com.tencent.luggage.wxa.hg.l lVar, String str) {
            a c6264a;
            try {
                com.tencent.luggage.wxa.hg.g a16 = com.tencent.luggage.wxa.hg.g.f127109d.a(lVar.b().getInt(str));
                if (a16 != null) {
                    c6264a = new a.b(a16);
                } else {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "parseCipherMode, null");
                    com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                    Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                    c6264a = new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA, null, 2, null));
                }
                return c6264a;
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e16, "parseCipherMode failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA2 = com.tencent.luggage.wxa.af.e.f121315k;
                Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA2, "INVALID_REQUEST_DATA");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INVALID_REQUEST_DATA2, null, 2, null));
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e17, "parseCipherMode failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null));
            }
        }

        public final a a(com.tencent.luggage.wxa.hg.l lVar) {
            try {
                com.tencent.luggage.wxa.c5.e runtime = lVar.a().getRuntime();
                if (runtime == null) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.SmCryptoInvoker", "getSmStorage, runtime is null");
                    com.tencent.luggage.wxa.af.c INTERNAL_ERROR = com.tencent.luggage.wxa.af.e.f121309e;
                    Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR, "INTERNAL_ERROR");
                    return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR, null, 2, null));
                }
                com.tencent.luggage.wxa.hg.b a16 = com.tencent.luggage.wxa.hg.p.f127173a.a(runtime);
                if (a16 != null) {
                    return new a.b(a16);
                }
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR2 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR2, "INTERNAL_ERROR");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR2, null, 2, null));
            } catch (com.tencent.luggage.wxa.dr.c e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e16, "getSmStorage failure", new Object[0]);
                return new a.C6264a(a(e16));
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.SmCryptoInvoker", e17, "getSmStorage failure", new Object[0]);
                com.tencent.luggage.wxa.af.c INTERNAL_ERROR3 = com.tencent.luggage.wxa.af.e.f121309e;
                Intrinsics.checkNotNullExpressionValue(INTERNAL_ERROR3, "INTERNAL_ERROR");
                return new a.C6264a(new com.tencent.luggage.wxa.hg.m(INTERNAL_ERROR3, null, 2, null));
            }
        }

        public final com.tencent.luggage.wxa.hg.m a(com.tencent.luggage.wxa.dr.c cVar) {
            com.tencent.luggage.wxa.af.c GENERAL_FAIL_USE_OTHER_SERVICE = com.tencent.luggage.wxa.af.e.f121313i;
            Intrinsics.checkNotNullExpressionValue(GENERAL_FAIL_USE_OTHER_SERVICE, "GENERAL_FAIL_USE_OTHER_SERVICE");
            return new com.tencent.luggage.wxa.hg.m(com.tencent.luggage.wxa.af.l.a(GENERAL_FAIL_USE_OTHER_SERVICE, "fail:" + cVar.f124435a), null, 2, null);
        }

        public final byte[] a(String str) {
            List<String> chunked;
            int collectionSizeOrDefault;
            byte[] byteArray;
            int checkRadix;
            if (str.length() % 2 != 0) {
                return null;
            }
            chunked = StringsKt___StringsKt.chunked(str, 2);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(chunked, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str2 : chunked) {
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                arrayList.add(Byte.valueOf((byte) Integer.parseInt(str2, checkRadix)));
            }
            byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
            return byteArray;
        }

        public final String a(byte[] bArr) {
            String joinToString$default;
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) b.f127168a, 30, (Object) null);
            return joinToString$default;
        }
    }

    /* synthetic */ n(com.tencent.luggage.wxa.hg.o oVar, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(oVar, str);
    }

    public final com.tencent.luggage.wxa.hg.o b() {
        return this.f127164a;
    }

    public final String c() {
        return this.f127165b;
    }

    n(com.tencent.luggage.wxa.hg.o oVar, String str) {
        this.f127164a = oVar;
        this.f127165b = str;
    }
}
