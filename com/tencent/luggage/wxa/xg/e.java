package com.tencent.luggage.wxa.xg;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum e {
    NETWORK,
    EXTRACT,
    EXTRACT_NOT_SUPPORT,
    DECODE,
    DECODE_NOT_SUPPORT,
    RENDER,
    ILLEGAL,
    OTHER;


    /* renamed from: a, reason: collision with root package name */
    public static final a f144918a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(int i3, int i16) {
            e eVar;
            if (-4000 >= i3) {
                eVar = b(i3, i16);
            } else {
                eVar = null;
            }
            w.d("MicroMsg.AppBrand.GeneralErrorType", "fromErrorInfo, errorWhat: " + i3 + ", errorExtra: " + i16 + ", errorType: " + eVar);
            return eVar;
        }

        public final e b(int i3, int i16) {
            e eVar;
            if (i3 != -4999) {
                switch (i3) {
                    case TXLiteAVCode.ERR_BGM_INVALID_URL /* -4006 */:
                    case -4000:
                        eVar = e.NETWORK;
                        break;
                    case -4005:
                        eVar = e.RENDER;
                        break;
                    case -4004:
                        eVar = e.EXTRACT;
                        break;
                    case -4003:
                        eVar = e.DECODE;
                        break;
                    case -4002:
                        eVar = e.ILLEGAL;
                        break;
                    case -4001:
                        eVar = e.EXTRACT_NOT_SUPPORT;
                        break;
                    default:
                        eVar = null;
                        break;
                }
            } else {
                eVar = e.OTHER;
            }
            if (eVar == null) {
                w.b("MicroMsg.AppBrand.GeneralErrorType", "fromExoErrorInfo, errorType is null, errorWhat: " + i3 + ", errorExtra: " + i16);
            }
            return eVar;
        }
    }

    public static final e a(int i3, int i16) {
        return f144918a.a(i3, i16);
    }
}
