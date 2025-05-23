package com.tencent.luggage.wxa.ae;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.luggage.wxa.ae.h;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.d5.a;
import com.tencent.luggage.wxa.hn.c5;
import com.tencent.luggage.wxa.hn.gf;
import com.tencent.luggage.wxa.hn.m9;
import com.tencent.luggage.wxa.hn.o5;
import com.tencent.luggage.wxa.hn.o9;
import com.tencent.luggage.wxa.hn.p5;
import com.tencent.luggage.wxa.hn.pb;
import com.tencent.luggage.wxa.hn.q5;
import com.tencent.luggage.wxa.hn.r5;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.ml.j;
import com.tencent.luggage.wxa.ml.u;
import com.tencent.luggage.wxa.rj.p;
import com.tencent.luggage.wxa.tj.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.luggage.wxa.xd.f1;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends k implements h {

    @Deprecated
    public static final int CTRL_INDEX = 54;

    @Deprecated
    @NotNull
    public static final String NAME = "authorize";

    /* renamed from: a, reason: collision with root package name */
    public static final c f121093a = new c(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends SuspendLambda implements Function2 {
        public final /* synthetic */ JSONObject C;
        public final /* synthetic */ JSONObject D;
        public final /* synthetic */ int E;
        public final /* synthetic */ JSONObject F;
        public final /* synthetic */ g G;
        public final /* synthetic */ List H;

        /* renamed from: a, reason: collision with root package name */
        public Object f121094a;

        /* renamed from: b, reason: collision with root package name */
        public Object f121095b;

        /* renamed from: c, reason: collision with root package name */
        public Object f121096c;

        /* renamed from: d, reason: collision with root package name */
        public Object f121097d;

        /* renamed from: e, reason: collision with root package name */
        public Object f121098e;

        /* renamed from: f, reason: collision with root package name */
        public Object f121099f;

        /* renamed from: g, reason: collision with root package name */
        public Object f121100g;

        /* renamed from: h, reason: collision with root package name */
        public Object f121101h;

        /* renamed from: i, reason: collision with root package name */
        public int f121102i;

        /* renamed from: j, reason: collision with root package name */
        public int f121103j;

        /* renamed from: k, reason: collision with root package name */
        public int f121104k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121105l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ l f121106m;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ae.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C5995a implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CancellableContinuation f121107a;

            public C5995a(CancellableContinuation cancellableContinuation) {
                this.f121107a = cancellableContinuation;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(t8 t8Var) {
                if (this.f121107a.isActive()) {
                    CancellableContinuation cancellableContinuation = this.f121107a;
                    Result.Companion companion = Result.INSTANCE;
                    if (t8Var == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JSAuthorizeResponse");
                    }
                    cancellableContinuation.resumeWith(Result.m476constructorimpl((r5) t8Var));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CancellableContinuation f121108a;

            public b(CancellableContinuation cancellableContinuation) {
                this.f121108a = cancellableContinuation;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(t8 t8Var) {
                if (this.f121108a.isActive()) {
                    CancellableContinuation cancellableContinuation = this.f121108a;
                    Result.Companion companion = Result.INSTANCE;
                    if (t8Var == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JSAuthorizeConfirmResponse");
                    }
                    cancellableContinuation.resumeWith(Result.m476constructorimpl((p5) t8Var));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.tencent.luggage.wxa.ic.d dVar, l lVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, JSONObject jSONObject3, g gVar, List list, Continuation continuation) {
            super(2, continuation);
            this.f121105l = dVar;
            this.f121106m = lVar;
            this.C = jSONObject;
            this.D = jSONObject2;
            this.E = i3;
            this.F = jSONObject3;
            this.G = gVar;
            this.H = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.f121105l, this.f121106m, this.C, this.D, this.E, this.F, this.G, this.H, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:253:0x052a, code lost:
        
            r1 = "fail:login error " + r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0468, code lost:
        
            r2 = "fail:login error " + r2;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:114:0x0305 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x025d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:155:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0368  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x01e4  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x01ea A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:174:0x022a A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:183:0x05b1 A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:188:0x05bb A[Catch: all -> 0x0090, TRY_ENTER, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:203:0x0628 A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:207:0x064e A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:212:0x06a1  */
        /* JADX WARN: Removed duplicated region for block: B:214:0x063a A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:231:0x0150 A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:240:0x0500  */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0510 A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:246:0x051a A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0435 A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:262:0x057a  */
        /* JADX WARN: Removed duplicated region for block: B:265:0x055d A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:269:0x0516 A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:279:0x0175 A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:284:0x0197 A[Catch: all -> 0x0090, TRY_ENTER, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:288:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0458 A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x04c9  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x049f A[Catch: all -> 0x0090, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0314  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0384 A[Catch: all -> 0x0090, a -> 0x03df, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0396 A[Catch: all -> 0x0090, a -> 0x03df, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x03bb A[Catch: all -> 0x0090, a -> 0x03df, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x04d1  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x03a7 A[Catch: all -> 0x0090, a -> 0x03df, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x03cf A[Catch: all -> 0x0090, a -> 0x03df, TRY_LEAVE, TryCatch #2 {all -> 0x0090, blocks: (B:8:0x0031, B:11:0x0355, B:12:0x0362, B:22:0x0408, B:24:0x0435, B:26:0x043b, B:28:0x0447, B:31:0x0458, B:33:0x045e, B:38:0x0468, B:40:0x048a, B:42:0x048e, B:43:0x0492, B:44:0x04c3, B:49:0x047a, B:50:0x049f, B:52:0x04a3, B:53:0x04ae, B:54:0x044b, B:56:0x044f, B:58:0x04b9, B:60:0x005b, B:63:0x02ff, B:115:0x0305, B:69:0x0380, B:71:0x0384, B:73:0x038a, B:78:0x0396, B:80:0x03b7, B:82:0x03bb, B:83:0x03bf, B:89:0x03a7, B:91:0x03cf, B:92:0x031e, B:94:0x0324, B:96:0x0328, B:98:0x0330, B:100:0x0334, B:108:0x036c, B:110:0x037b, B:119:0x0084, B:123:0x025d, B:144:0x0275, B:127:0x0287, B:130:0x02cb, B:132:0x02f4, B:151:0x0089, B:153:0x01b7, B:160:0x01d2, B:162:0x01d8, B:169:0x01ef, B:170:0x01ea, B:172:0x020c, B:174:0x022a, B:179:0x0098, B:181:0x05a9, B:183:0x05b1, B:188:0x05bb, B:190:0x05ea, B:192:0x05f0, B:194:0x0604, B:196:0x0615, B:198:0x061b, B:203:0x0628, B:205:0x064a, B:207:0x064e, B:208:0x0652, B:209:0x069b, B:214:0x063a, B:216:0x0665, B:218:0x0669, B:219:0x067a, B:220:0x060a, B:222:0x060e, B:224:0x068b, B:226:0x00b4, B:228:0x014a, B:229:0x014c, B:231:0x0150, B:235:0x04dc, B:237:0x04e2, B:242:0x0504, B:244:0x0510, B:246:0x051a, B:248:0x0520, B:253:0x052a, B:255:0x054b, B:257:0x054f, B:258:0x0553, B:259:0x0574, B:264:0x053b, B:265:0x055d, B:267:0x0561, B:268:0x056b, B:269:0x0516, B:270:0x015d, B:272:0x0165, B:274:0x0169, B:279:0x0175, B:284:0x0197, B:293:0x0584, B:298:0x00c3, B:301:0x0113, B:302:0x011e, B:304:0x0144), top: B:2:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0328 A[Catch: all -> 0x0090, a -> 0x030c, TRY_ENTER, TryCatch #0 {a -> 0x030c, blocks: (B:115:0x0305, B:96:0x0328, B:98:0x0330, B:100:0x0334), top: B:114:0x0305 }] */
        /* JADX WARN: Type inference failed for: r19v3, types: [com.tencent.luggage.wxa.ae.k] */
        /* JADX WARN: Type inference failed for: r19v4 */
        /* JADX WARN: Type inference failed for: r19v6 */
        /* JADX WARN: Type inference failed for: r1v12, types: [com.tencent.luggage.wxa.hn.r5] */
        /* JADX WARN: Type inference failed for: r1v33, types: [com.tencent.luggage.wxa.hn.r5] */
        /* JADX WARN: Type inference failed for: r24v0, types: [org.json.JSONObject] */
        /* JADX WARN: Type inference failed for: r24v1 */
        /* JADX WARN: Type inference failed for: r24v3 */
        /* JADX WARN: Type inference failed for: r2v17, types: [com.tencent.luggage.wxa.hn.p5] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            com.tencent.luggage.wxa.bj.a aVar;
            boolean z16;
            com.tencent.luggage.wxa.bj.a aVar2;
            String str;
            boolean z17;
            c5 c5Var;
            boolean z18;
            com.tencent.luggage.wxa.bj.a aVar3;
            Object a16;
            g gVar;
            c5 c5Var2;
            boolean z19;
            String str2;
            int i3;
            ?? r242;
            com.tencent.luggage.wxa.ic.d dVar;
            ?? r19;
            g gVar2;
            c5 c5Var3;
            c5 c5Var4;
            l lVar;
            com.tencent.luggage.wxa.ic.d dVar2;
            Object obj2;
            Continuation intercepted;
            h.b bVar;
            Object result;
            Object coroutine_suspended2;
            ?? r16;
            Integer boxInt;
            LinkedList linkedList;
            boolean z26;
            Object a17;
            c5 c5Var5;
            g gVar3;
            g gVar4;
            l lVar2;
            int b16;
            JSONObject jSONObject;
            int i16;
            com.tencent.luggage.wxa.ic.d dVar3;
            d dVar4;
            int i17;
            boolean z27;
            l lVar3;
            com.tencent.luggage.wxa.bj.a aVar4;
            Continuation intercepted2;
            h.b bVar2;
            Object result2;
            Object coroutine_suspended3;
            int i18;
            com.tencent.luggage.wxa.ic.d dVar5;
            JSONObject jSONObject2;
            l lVar4;
            g gVar5;
            com.tencent.luggage.wxa.ic.d dVar6;
            p5 p5Var;
            c5 c5Var6;
            Integer boxInt2;
            l lVar5;
            JSONObject jSONObject3;
            LinkedList linkedList2;
            Object firstOrNull;
            l lVar6;
            JSONObject jSONObject4;
            c5 c5Var7;
            boolean z28;
            String str3;
            int i19;
            g gVar6;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i26 = this.f121104k;
            try {
                try {
                    try {
                    } catch (com.tencent.luggage.wxa.bj.a e16) {
                        aVar = e16;
                        z16 = true;
                    }
                    switch (i26) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            try {
                                h.b bVar3 = h.f121074n;
                                com.tencent.luggage.wxa.ic.d dVar7 = this.f121105l;
                                q5 q5Var = new q5();
                                com.tencent.luggage.wxa.ic.d dVar8 = this.f121105l;
                                List list = this.H;
                                l lVar7 = this.f121106m;
                                JSONObject jSONObject5 = this.C;
                                q5Var.f128498e = dVar8.getAppId();
                                q5Var.f128499f.addAll(list);
                                q5Var.f128500g = dVar8.getRuntime().l0();
                                q5Var.f128501h = lVar7.a(new gf(), dVar8);
                                q5Var.f128504k = lVar7.a(jSONObject5.optJSONArray("scope"), dVar8.getRuntime());
                                this.f121094a = dVar7;
                                this.f121095b = "/cgi-bin/mmbiz-bin/js-authorize";
                                this.f121096c = q5Var;
                                this.f121097d = r5.class;
                                try {
                                    this.f121104k = 1;
                                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                                    cancellableContinuationImpl.initCancellability();
                                    bVar = h.b.f121075a;
                                    bVar.a(dVar7, "/cgi-bin/mmbiz-bin/js-authorize", q5Var, r5.class).a(new C5995a(cancellableContinuationImpl)).a(new i(cancellableContinuationImpl));
                                    result = cancellableContinuationImpl.getResult();
                                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (result == coroutine_suspended2) {
                                        DebugProbes.probeCoroutineSuspended(this);
                                    }
                                    if (result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    r16 = (r5) result;
                                    c5 c5Var8 = r16.f128575e;
                                    boxInt = c5Var8 == null ? Boxing.boxInt(c5Var8.f127384d) : null;
                                    if (boxInt != null && boxInt.intValue() == -12000) {
                                        linkedList = r16.f128576f;
                                        if (linkedList != null && !linkedList.isEmpty()) {
                                            z26 = false;
                                            if (!z26) {
                                                this.f121106m.a(this.f121105l, this.E, "fail:internal error scope empty", com.tencent.luggage.wxa.af.e.f121324t, this.F);
                                                Unit unit = Unit.INSTANCE;
                                                g gVar7 = this.G;
                                                if (gVar7 != null) {
                                                    gVar7.b();
                                                }
                                                return unit;
                                            }
                                            this.F.put("showedModal", 1);
                                            l lVar8 = this.f121106m;
                                            com.tencent.luggage.wxa.ic.d dVar9 = this.f121105l;
                                            this.f121094a = null;
                                            this.f121095b = null;
                                            this.f121096c = null;
                                            this.f121097d = null;
                                            this.f121104k = 3;
                                            a17 = lVar8.a(dVar9, (r5) r16, this);
                                            if (a17 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            lVar2 = this.f121106m;
                                            com.tencent.luggage.wxa.ic.d dVar10 = this.f121105l;
                                            int i27 = this.E;
                                            JSONObject jSONObject6 = this.F;
                                            d dVar11 = (d) a17;
                                            b16 = dVar11.b();
                                            if (b16 != 1) {
                                                List c16 = dVar11.c();
                                                Intrinsics.checkNotNull(c16);
                                                this.f121094a = lVar2;
                                                this.f121095b = dVar10;
                                                jSONObject = jSONObject6;
                                                this.f121096c = jSONObject;
                                                this.f121097d = dVar11;
                                                this.f121102i = i27;
                                                this.f121103j = 1;
                                                this.f121104k = 4;
                                                if (lVar2.a(dVar10, c16, this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                i16 = i27;
                                                dVar3 = dVar10;
                                                dVar4 = dVar11;
                                            } else {
                                                if (b16 != 2) {
                                                    if (b16 == 3) {
                                                        String a18 = dVar11.a();
                                                        if (a18 != null && a18.length() != 0) {
                                                            z27 = false;
                                                            lVar2.a(dVar10, i27, !z27 ? "fail auth cancel" : dVar11.a(), com.tencent.luggage.wxa.af.e.f121318n, jSONObject6);
                                                            jSONObject = jSONObject6;
                                                            dVar4 = dVar11;
                                                            i16 = i27;
                                                            dVar3 = dVar10;
                                                            i17 = 0;
                                                            i27 = i16;
                                                            dVar10 = dVar3;
                                                            jSONObject6 = jSONObject;
                                                            if (i17 != 0) {
                                                            }
                                                            gVar5 = this.G;
                                                            if (gVar5 != null) {
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                        z27 = true;
                                                        lVar2.a(dVar10, i27, !z27 ? "fail auth cancel" : dVar11.a(), com.tencent.luggage.wxa.af.e.f121318n, jSONObject6);
                                                        jSONObject = jSONObject6;
                                                        dVar4 = dVar11;
                                                        i16 = i27;
                                                        dVar3 = dVar10;
                                                        i17 = 0;
                                                        i27 = i16;
                                                        dVar10 = dVar3;
                                                        jSONObject6 = jSONObject;
                                                        if (i17 != 0) {
                                                        }
                                                        gVar5 = this.G;
                                                        if (gVar5 != null) {
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                    dVar4 = dVar11;
                                                    i17 = 0;
                                                    if (i17 != 0) {
                                                        try {
                                                            h.b bVar4 = h.f121074n;
                                                            o5 o5Var = new o5();
                                                            o5Var.f128322e = dVar10.getAppId();
                                                            LinkedList linkedList3 = o5Var.f128323f;
                                                            List c17 = dVar4.c();
                                                            if (c17 == null) {
                                                                try {
                                                                    c17 = CollectionsKt__CollectionsKt.emptyList();
                                                                } catch (com.tencent.luggage.wxa.bj.a e17) {
                                                                    aVar4 = e17;
                                                                    str = "Luggage.WXA.JsApiAuthorize2";
                                                                    lVar3 = lVar2;
                                                                    z17 = true;
                                                                    r242 = jSONObject6;
                                                                    dVar = dVar10;
                                                                    r19 = lVar3;
                                                                    aVar2 = aVar4;
                                                                    i26 = i27;
                                                                    w.b(str, "send confirm for appId:" + dVar.getAppId() + " callbackId:" + i26 + " failed, exception:" + aVar2);
                                                                    if (aVar2.f122898a == a.EnumC6074a.SERVER) {
                                                                    }
                                                                    r19.a(dVar, i26, "", com.tencent.luggage.wxa.af.e.f121322r, r242);
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    gVar2 = this.G;
                                                                    if (gVar2 != null) {
                                                                    }
                                                                    return unit2;
                                                                }
                                                            }
                                                            str = "Luggage.WXA.JsApiAuthorize2";
                                                            try {
                                                                linkedList3.addAll(c17);
                                                                o5Var.f128324g = dVar4.b();
                                                                o5Var.f128325h = dVar10.getRuntime().l0();
                                                                o5Var.f128326i = lVar2.a(new gf(), dVar10);
                                                                o5Var.f128327j = dVar4.d();
                                                                this.f121094a = lVar2;
                                                                this.f121095b = dVar10;
                                                                this.f121096c = jSONObject6;
                                                                this.f121097d = dVar10;
                                                                this.f121098e = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                                                                this.f121099f = o5Var;
                                                                this.f121100g = p5.class;
                                                                this.f121101h = this;
                                                                this.f121102i = i27;
                                                                this.f121104k = 5;
                                                                intercepted2 = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                                                                lVar3 = lVar2;
                                                                z17 = true;
                                                                try {
                                                                    CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(intercepted2, 1);
                                                                    cancellableContinuationImpl2.initCancellability();
                                                                    bVar2 = h.b.f121075a;
                                                                    bVar2.a(dVar10, "/cgi-bin/mmbiz-bin/js-authorize-confirm", o5Var, p5.class).a(new b(cancellableContinuationImpl2)).a(new i(cancellableContinuationImpl2));
                                                                    result2 = cancellableContinuationImpl2.getResult();
                                                                    coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    if (result2 == coroutine_suspended3) {
                                                                        DebugProbes.probeCoroutineSuspended(this);
                                                                    }
                                                                    if (result2 == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    i18 = i27;
                                                                    dVar5 = dVar10;
                                                                    jSONObject2 = jSONObject6;
                                                                    lVar4 = lVar3;
                                                                    try {
                                                                        p5Var = (p5) result2;
                                                                        c5Var6 = p5Var.f128399e;
                                                                        if (c5Var6 == null) {
                                                                            try {
                                                                                boxInt2 = Boxing.boxInt(c5Var6.f127384d);
                                                                            } catch (com.tencent.luggage.wxa.bj.a e18) {
                                                                                e = e18;
                                                                                lVar5 = lVar4;
                                                                                dVar2 = dVar5;
                                                                                jSONObject3 = jSONObject2;
                                                                                i26 = i18;
                                                                                aVar2 = e;
                                                                                obj2 = jSONObject3;
                                                                                lVar = lVar5;
                                                                                r242 = obj2;
                                                                                dVar = dVar2;
                                                                                r19 = lVar;
                                                                                w.b(str, "send confirm for appId:" + dVar.getAppId() + " callbackId:" + i26 + " failed, exception:" + aVar2);
                                                                                if (aVar2.f122898a == a.EnumC6074a.SERVER) {
                                                                                    com.tencent.luggage.wxa.fn.b bVar5 = aVar2.f122901d;
                                                                                    if (bVar5 instanceof p5) {
                                                                                        Intrinsics.checkNotNull(bVar5, "null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JSAuthorizeConfirmResponse");
                                                                                        ?? r26 = (p5) bVar5;
                                                                                        if (r26 instanceof p5) {
                                                                                            c5Var4 = r26.f128399e;
                                                                                        } else {
                                                                                            if (!(r26 instanceof r5)) {
                                                                                                c5Var3 = null;
                                                                                                if (c5Var3 == null) {
                                                                                                    int i28 = c5Var3.f127384d;
                                                                                                    String str4 = c5Var3.f127385e;
                                                                                                    if (str4 != null && str4.length() != 0) {
                                                                                                        z17 = false;
                                                                                                        break;
                                                                                                    }
                                                                                                    String str5 = "fail:" + str4;
                                                                                                    String str6 = str5;
                                                                                                    int i29 = c5Var3.f127386f;
                                                                                                    if (i29 == 0) {
                                                                                                        i29 = com.tencent.luggage.wxa.af.e.f121327w.f121277a;
                                                                                                    }
                                                                                                    r19.a(dVar, i26, str6, new com.tencent.luggage.wxa.af.c(i29), r242);
                                                                                                } else if (r26 instanceof p5) {
                                                                                                    r19.a(dVar, i26, "fail:confirm cgi fail", com.tencent.luggage.wxa.af.e.f121323s, r242);
                                                                                                } else {
                                                                                                    r19.a(dVar, i26, "fail:cgi fail", com.tencent.luggage.wxa.af.e.f121323s, r242);
                                                                                                }
                                                                                                Unit unit22 = Unit.INSTANCE;
                                                                                                gVar2 = this.G;
                                                                                                if (gVar2 != null) {
                                                                                                    gVar2.b();
                                                                                                }
                                                                                                return unit22;
                                                                                            }
                                                                                            c5Var4 = ((r5) r26).f128575e;
                                                                                        }
                                                                                        c5Var3 = c5Var4;
                                                                                        if (c5Var3 == null) {
                                                                                        }
                                                                                        Unit unit222 = Unit.INSTANCE;
                                                                                        gVar2 = this.G;
                                                                                        if (gVar2 != null) {
                                                                                        }
                                                                                        return unit222;
                                                                                    }
                                                                                }
                                                                                r19.a(dVar, i26, "", com.tencent.luggage.wxa.af.e.f121322r, r242);
                                                                                Unit unit2222 = Unit.INSTANCE;
                                                                                gVar2 = this.G;
                                                                                if (gVar2 != null) {
                                                                                }
                                                                                return unit2222;
                                                                            }
                                                                        } else {
                                                                            boxInt2 = null;
                                                                        }
                                                                        try {
                                                                            if (boxInt2 != null && boxInt2.intValue() == 0) {
                                                                                linkedList2 = p5Var.f128400f;
                                                                                if (linkedList2 != null) {
                                                                                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) linkedList2);
                                                                                    o9 o9Var = (o9) firstOrNull;
                                                                                    if (o9Var != null) {
                                                                                        if (o9Var.f128346e != null) {
                                                                                            this.f121094a = lVar4;
                                                                                            this.f121095b = dVar5;
                                                                                            this.f121096c = jSONObject2;
                                                                                            this.f121097d = null;
                                                                                            this.f121098e = null;
                                                                                            this.f121099f = null;
                                                                                            this.f121100g = null;
                                                                                            this.f121101h = null;
                                                                                            this.f121102i = i18;
                                                                                            this.f121104k = 6;
                                                                                            if (lVar4.a(dVar5, o9Var, this) == coroutine_suspended) {
                                                                                                return coroutine_suspended;
                                                                                            }
                                                                                            lVar6 = lVar4;
                                                                                            dVar2 = dVar5;
                                                                                            jSONObject4 = jSONObject2;
                                                                                            i26 = i18;
                                                                                            try {
                                                                                                lVar6.a(dVar2, i26, "fail:risk intercepted", jSONObject4);
                                                                                                jSONObject4 = jSONObject4;
                                                                                                lVar6 = lVar6;
                                                                                                Unit unit3 = Unit.INSTANCE;
                                                                                                gVar6 = this.G;
                                                                                                if (gVar6 != null) {
                                                                                                    gVar6.b();
                                                                                                }
                                                                                                return unit3;
                                                                                            } catch (com.tencent.luggage.wxa.bj.a e19) {
                                                                                                e = e19;
                                                                                                jSONObject3 = jSONObject4;
                                                                                                lVar5 = lVar6;
                                                                                                aVar2 = e;
                                                                                                obj2 = jSONObject3;
                                                                                                lVar = lVar5;
                                                                                                r242 = obj2;
                                                                                                dVar = dVar2;
                                                                                                r19 = lVar;
                                                                                                w.b(str, "send confirm for appId:" + dVar.getAppId() + " callbackId:" + i26 + " failed, exception:" + aVar2);
                                                                                                if (aVar2.f122898a == a.EnumC6074a.SERVER) {
                                                                                                }
                                                                                                r19.a(dVar, i26, "", com.tencent.luggage.wxa.af.e.f121322r, r242);
                                                                                                Unit unit22222 = Unit.INSTANCE;
                                                                                                gVar2 = this.G;
                                                                                                if (gVar2 != null) {
                                                                                                }
                                                                                                return unit22222;
                                                                                            }
                                                                                        }
                                                                                        lVar6 = lVar4;
                                                                                        dVar2 = dVar5;
                                                                                        jSONObject4 = jSONObject2;
                                                                                        Unit unit32 = Unit.INSTANCE;
                                                                                        gVar6 = this.G;
                                                                                        if (gVar6 != null) {
                                                                                        }
                                                                                        return unit32;
                                                                                    }
                                                                                }
                                                                                lVar4.a(dVar5, i18, "", com.tencent.luggage.wxa.af.e.f121305a, jSONObject2);
                                                                            } else {
                                                                                l lVar9 = lVar4;
                                                                                com.tencent.luggage.wxa.ic.d dVar12 = dVar5;
                                                                                JSONObject jSONObject7 = jSONObject2;
                                                                                c5Var7 = p5Var.f128399e;
                                                                                if (c5Var7 == null) {
                                                                                    int i36 = c5Var7.f127384d;
                                                                                    String str7 = c5Var7.f127385e;
                                                                                    if (str7 != null && str7.length() != 0) {
                                                                                        z28 = false;
                                                                                        if (z28) {
                                                                                            str3 = "fail:" + str7;
                                                                                        } else {
                                                                                            str3 = "fail:login error " + i36;
                                                                                        }
                                                                                        String str8 = str3;
                                                                                        i19 = c5Var7.f127386f;
                                                                                        if (i19 == 0) {
                                                                                            i19 = com.tencent.luggage.wxa.af.e.f121327w.f121277a;
                                                                                        }
                                                                                        lVar9.a(dVar12, i18, str8, new com.tencent.luggage.wxa.af.c(i19), jSONObject7);
                                                                                    }
                                                                                    z28 = z17;
                                                                                    if (z28) {
                                                                                    }
                                                                                    String str82 = str3;
                                                                                    i19 = c5Var7.f127386f;
                                                                                    if (i19 == 0) {
                                                                                    }
                                                                                    lVar9.a(dVar12, i18, str82, new com.tencent.luggage.wxa.af.c(i19), jSONObject7);
                                                                                } else {
                                                                                    lVar9.a(dVar12, i18, "fail:confirm cgi fail", com.tencent.luggage.wxa.af.e.f121323s, jSONObject7);
                                                                                }
                                                                            }
                                                                        } catch (com.tencent.luggage.wxa.bj.a e26) {
                                                                            e = e26;
                                                                            aVar2 = e;
                                                                            obj2 = coroutine_suspended;
                                                                            i26 = i18;
                                                                            lVar = lVar3;
                                                                            dVar2 = dVar6;
                                                                            r242 = obj2;
                                                                            dVar = dVar2;
                                                                            r19 = lVar;
                                                                            w.b(str, "send confirm for appId:" + dVar.getAppId() + " callbackId:" + i26 + " failed, exception:" + aVar2);
                                                                            if (aVar2.f122898a == a.EnumC6074a.SERVER) {
                                                                            }
                                                                            r19.a(dVar, i26, "", com.tencent.luggage.wxa.af.e.f121322r, r242);
                                                                            Unit unit222222 = Unit.INSTANCE;
                                                                            gVar2 = this.G;
                                                                            if (gVar2 != null) {
                                                                            }
                                                                            return unit222222;
                                                                        }
                                                                    } catch (com.tencent.luggage.wxa.bj.a e27) {
                                                                        e = e27;
                                                                        lVar3 = lVar4;
                                                                        dVar6 = dVar5;
                                                                        coroutine_suspended = jSONObject2;
                                                                    }
                                                                } catch (com.tencent.luggage.wxa.bj.a e28) {
                                                                    e = e28;
                                                                    aVar4 = e;
                                                                    r242 = jSONObject6;
                                                                    dVar = dVar10;
                                                                    r19 = lVar3;
                                                                    aVar2 = aVar4;
                                                                    i26 = i27;
                                                                    w.b(str, "send confirm for appId:" + dVar.getAppId() + " callbackId:" + i26 + " failed, exception:" + aVar2);
                                                                    if (aVar2.f122898a == a.EnumC6074a.SERVER) {
                                                                    }
                                                                    r19.a(dVar, i26, "", com.tencent.luggage.wxa.af.e.f121322r, r242);
                                                                    Unit unit2222222 = Unit.INSTANCE;
                                                                    gVar2 = this.G;
                                                                    if (gVar2 != null) {
                                                                    }
                                                                    return unit2222222;
                                                                }
                                                            } catch (com.tencent.luggage.wxa.bj.a e29) {
                                                                e = e29;
                                                                lVar3 = lVar2;
                                                                z17 = true;
                                                                aVar4 = e;
                                                                r242 = jSONObject6;
                                                                dVar = dVar10;
                                                                r19 = lVar3;
                                                                aVar2 = aVar4;
                                                                i26 = i27;
                                                                w.b(str, "send confirm for appId:" + dVar.getAppId() + " callbackId:" + i26 + " failed, exception:" + aVar2);
                                                                if (aVar2.f122898a == a.EnumC6074a.SERVER) {
                                                                }
                                                                r19.a(dVar, i26, "", com.tencent.luggage.wxa.af.e.f121322r, r242);
                                                                Unit unit22222222 = Unit.INSTANCE;
                                                                gVar2 = this.G;
                                                                if (gVar2 != null) {
                                                                }
                                                                return unit22222222;
                                                            }
                                                        } catch (com.tencent.luggage.wxa.bj.a e36) {
                                                            e = e36;
                                                            str = "Luggage.WXA.JsApiAuthorize2";
                                                        }
                                                    }
                                                    gVar5 = this.G;
                                                    if (gVar5 != null) {
                                                        gVar5.b();
                                                        Unit unit4 = Unit.INSTANCE;
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                                lVar2.a(dVar10, i27, "fail auth deny", com.tencent.luggage.wxa.af.e.f121317m, jSONObject6);
                                                jSONObject = jSONObject6;
                                                dVar4 = dVar11;
                                                i16 = i27;
                                                dVar3 = dVar10;
                                            }
                                            i17 = 1;
                                            i27 = i16;
                                            dVar10 = dVar3;
                                            jSONObject6 = jSONObject;
                                            if (i17 != 0) {
                                            }
                                            gVar5 = this.G;
                                            if (gVar5 != null) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        z26 = true;
                                        if (!z26) {
                                        }
                                    } else {
                                        boolean z29 = true;
                                        if (boxInt != null && boxInt.intValue() == 0) {
                                            this.f121106m.a(this.f121105l, this.E, "", com.tencent.luggage.wxa.af.e.f121305a, this.F);
                                            Unit unit5 = Unit.INSTANCE;
                                            gVar4 = this.G;
                                            if (gVar4 != null) {
                                                gVar4.b();
                                            }
                                            return unit5;
                                        }
                                        l lVar10 = this.f121106m;
                                        com.tencent.luggage.wxa.ic.d dVar13 = this.f121105l;
                                        int i37 = this.E;
                                        JSONObject jSONObject8 = this.F;
                                        c5Var5 = !(r16 instanceof p5) ? ((p5) r16).f128399e : r16.f128575e;
                                        if (c5Var5 == null) {
                                            int i38 = c5Var5.f127384d;
                                            String str9 = c5Var5.f127385e;
                                            if (str9 != null && str9.length() != 0) {
                                                z29 = false;
                                                break;
                                            }
                                            String str10 = "fail:" + str9;
                                            String str11 = str10;
                                            int i39 = c5Var5.f127386f;
                                            if (i39 == 0) {
                                                i39 = com.tencent.luggage.wxa.af.e.f121327w.f121277a;
                                            }
                                            lVar10.a(dVar13, i37, str11, new com.tencent.luggage.wxa.af.c(i39), jSONObject8);
                                        } else if (r16 instanceof p5) {
                                            lVar10.a(dVar13, i37, "fail:confirm cgi fail", com.tencent.luggage.wxa.af.e.f121323s, jSONObject8);
                                        } else {
                                            lVar10.a(dVar13, i37, "fail:cgi fail", com.tencent.luggage.wxa.af.e.f121323s, jSONObject8);
                                        }
                                        Unit unit6 = Unit.INSTANCE;
                                        gVar3 = this.G;
                                        if (gVar3 != null) {
                                            gVar3.b();
                                        }
                                        return unit6;
                                    }
                                } catch (com.tencent.luggage.wxa.bj.a e37) {
                                    e = e37;
                                    z16 = true;
                                    aVar = e;
                                    l lVar11 = this.f121106m;
                                    com.tencent.luggage.wxa.ic.d dVar14 = this.f121105l;
                                    JSONObject jSONObject9 = this.C;
                                    JSONObject jSONObject10 = this.D;
                                    int i46 = this.E;
                                    this.f121094a = aVar;
                                    this.f121095b = null;
                                    this.f121096c = null;
                                    this.f121097d = null;
                                    this.f121104k = 2;
                                    c5Var = null;
                                    z18 = z16;
                                    aVar3 = aVar;
                                    a16 = lVar11.a(dVar14, jSONObject9, jSONObject10, i46, aVar, this);
                                    if (a16 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    if (!((Boolean) a16).booleanValue()) {
                                    }
                                }
                            } catch (com.tencent.luggage.wxa.bj.a e38) {
                                e = e38;
                                z16 = true;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure(obj);
                            result = obj;
                            r16 = (r5) result;
                            c5 c5Var82 = r16.f128575e;
                            if (c5Var82 == null) {
                            }
                            if (boxInt != null) {
                                linkedList = r16.f128576f;
                                if (linkedList != null) {
                                    z26 = false;
                                    if (!z26) {
                                    }
                                    break;
                                }
                                z26 = true;
                                if (!z26) {
                                }
                                break;
                            }
                            boolean z292 = true;
                            if (boxInt != null) {
                                this.f121106m.a(this.f121105l, this.E, "", com.tencent.luggage.wxa.af.e.f121305a, this.F);
                                Unit unit52 = Unit.INSTANCE;
                                gVar4 = this.G;
                                if (gVar4 != null) {
                                }
                                return unit52;
                            }
                            l lVar102 = this.f121106m;
                            com.tencent.luggage.wxa.ic.d dVar132 = this.f121105l;
                            int i372 = this.E;
                            JSONObject jSONObject82 = this.F;
                            if (!(r16 instanceof p5)) {
                            }
                            if (c5Var5 == null) {
                            }
                            Unit unit62 = Unit.INSTANCE;
                            gVar3 = this.G;
                            if (gVar3 != null) {
                            }
                            return unit62;
                        case 2:
                            com.tencent.luggage.wxa.bj.a aVar5 = (com.tencent.luggage.wxa.bj.a) this.f121094a;
                            ResultKt.throwOnFailure(obj);
                            aVar3 = aVar5;
                            c5Var = null;
                            z18 = true;
                            a16 = obj;
                            if (!((Boolean) a16).booleanValue()) {
                                Unit unit7 = Unit.INSTANCE;
                                g gVar8 = this.G;
                                if (gVar8 != null) {
                                    gVar8.b();
                                }
                                return unit7;
                            }
                            w.b("Luggage.WXA.JsApiAuthorize2", "send query for appId:" + this.f121105l.getAppId() + " callbackId:" + this.E + " failed, exception:" + aVar3);
                            if (aVar3.f122898a == a.EnumC6074a.SERVER) {
                                com.tencent.luggage.wxa.fn.b bVar6 = aVar3.f122901d;
                                if (bVar6 instanceof r5) {
                                    l lVar12 = this.f121106m;
                                    com.tencent.luggage.wxa.ic.d dVar15 = this.f121105l;
                                    int i47 = this.E;
                                    Intrinsics.checkNotNull(bVar6, "null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JSAuthorizeResponse");
                                    ?? r17 = (r5) bVar6;
                                    JSONObject jSONObject11 = this.F;
                                    if (r17 instanceof p5) {
                                        c5Var2 = ((p5) r17).f128399e;
                                    } else {
                                        c5Var2 = r17 instanceof r5 ? r17.f128575e : c5Var;
                                    }
                                    if (c5Var2 != null) {
                                        int i48 = c5Var2.f127384d;
                                        String str12 = c5Var2.f127385e;
                                        if (str12 != null && str12.length() != 0) {
                                            z19 = false;
                                            if (z19) {
                                                str2 = "fail:" + str12;
                                            } else {
                                                str2 = "fail:login error " + i48;
                                            }
                                            String str13 = str2;
                                            i3 = c5Var2.f127386f;
                                            if (i3 == 0) {
                                                i3 = com.tencent.luggage.wxa.af.e.f121327w.f121277a;
                                            }
                                            lVar12.a(dVar15, i47, str13, new com.tencent.luggage.wxa.af.c(i3), jSONObject11);
                                        }
                                        z19 = z18;
                                        if (z19) {
                                        }
                                        String str132 = str2;
                                        i3 = c5Var2.f127386f;
                                        if (i3 == 0) {
                                        }
                                        lVar12.a(dVar15, i47, str132, new com.tencent.luggage.wxa.af.c(i3), jSONObject11);
                                    } else if (r17 instanceof p5) {
                                        lVar12.a(dVar15, i47, "fail:confirm cgi fail", com.tencent.luggage.wxa.af.e.f121323s, jSONObject11);
                                    } else {
                                        lVar12.a(dVar15, i47, "fail:cgi fail", com.tencent.luggage.wxa.af.e.f121323s, jSONObject11);
                                    }
                                    Unit unit8 = Unit.INSTANCE;
                                    gVar = this.G;
                                    if (gVar != null) {
                                        gVar.b();
                                    }
                                    return unit8;
                                }
                            }
                            this.f121106m.a(this.f121105l, this.E, "", com.tencent.luggage.wxa.af.e.f121322r, this.F);
                            Unit unit82 = Unit.INSTANCE;
                            gVar = this.G;
                            if (gVar != null) {
                            }
                            return unit82;
                        case 3:
                            ResultKt.throwOnFailure(obj);
                            a17 = obj;
                            lVar2 = this.f121106m;
                            com.tencent.luggage.wxa.ic.d dVar102 = this.f121105l;
                            int i272 = this.E;
                            JSONObject jSONObject62 = this.F;
                            d dVar112 = (d) a17;
                            b16 = dVar112.b();
                            if (b16 != 1) {
                            }
                            i17 = 1;
                            i272 = i16;
                            dVar102 = dVar3;
                            jSONObject62 = jSONObject;
                            if (i17 != 0) {
                            }
                            gVar5 = this.G;
                            if (gVar5 != null) {
                            }
                            return Unit.INSTANCE;
                        case 4:
                            i17 = this.f121103j;
                            i16 = this.f121102i;
                            dVar4 = (d) this.f121097d;
                            jSONObject = (JSONObject) this.f121096c;
                            dVar3 = (com.tencent.luggage.wxa.ic.d) this.f121095b;
                            lVar2 = (l) this.f121094a;
                            ResultKt.throwOnFailure(obj);
                            i272 = i16;
                            dVar102 = dVar3;
                            jSONObject62 = jSONObject;
                            if (i17 != 0) {
                            }
                            gVar5 = this.G;
                            if (gVar5 != null) {
                            }
                            return Unit.INSTANCE;
                        case 5:
                            int i49 = this.f121102i;
                            JSONObject jSONObject12 = (JSONObject) this.f121096c;
                            com.tencent.luggage.wxa.ic.d dVar16 = (com.tencent.luggage.wxa.ic.d) this.f121095b;
                            l lVar13 = (l) this.f121094a;
                            ResultKt.throwOnFailure(obj);
                            jSONObject2 = jSONObject12;
                            dVar5 = dVar16;
                            lVar4 = lVar13;
                            str = "Luggage.WXA.JsApiAuthorize2";
                            z17 = true;
                            i18 = i49;
                            result2 = obj;
                            p5Var = (p5) result2;
                            c5Var6 = p5Var.f128399e;
                            if (c5Var6 == null) {
                            }
                            if (boxInt2 != null) {
                                linkedList2 = p5Var.f128400f;
                                if (linkedList2 != null) {
                                }
                                lVar4.a(dVar5, i18, "", com.tencent.luggage.wxa.af.e.f121305a, jSONObject2);
                                gVar5 = this.G;
                                if (gVar5 != null) {
                                }
                                return Unit.INSTANCE;
                            }
                            l lVar92 = lVar4;
                            com.tencent.luggage.wxa.ic.d dVar122 = dVar5;
                            JSONObject jSONObject72 = jSONObject2;
                            c5Var7 = p5Var.f128399e;
                            if (c5Var7 == null) {
                            }
                            gVar5 = this.G;
                            if (gVar5 != null) {
                            }
                            return Unit.INSTANCE;
                        case 6:
                            i26 = this.f121102i;
                            JSONObject jSONObject13 = (JSONObject) this.f121096c;
                            dVar2 = (com.tencent.luggage.wxa.ic.d) this.f121095b;
                            l lVar14 = (l) this.f121094a;
                            ResultKt.throwOnFailure(obj);
                            str = "Luggage.WXA.JsApiAuthorize2";
                            z17 = true;
                            jSONObject4 = jSONObject13;
                            lVar6 = lVar14;
                            lVar6.a(dVar2, i26, "fail:risk intercepted", jSONObject4);
                            jSONObject4 = jSONObject4;
                            lVar6 = lVar6;
                            Unit unit322 = Unit.INSTANCE;
                            gVar6 = this.G;
                            if (gVar6 != null) {
                            }
                            return unit322;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } finally {
                }
            } catch (com.tencent.luggage.wxa.bj.a e39) {
                aVar2 = e39;
                str = "Luggage.WXA.JsApiAuthorize2";
                z17 = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f121109a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f121110a;

        /* renamed from: b, reason: collision with root package name */
        public final String f121111b;

        /* renamed from: c, reason: collision with root package name */
        public final List f121112c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f121113d;

        public d(int i3, String str, List list, boolean z16) {
            this.f121110a = i3;
            this.f121111b = str;
            this.f121112c = list;
            this.f121113d = z16;
        }

        public final String a() {
            return this.f121111b;
        }

        public final int b() {
            return this.f121110a;
        }

        public final List c() {
            return this.f121112c;
        }

        public final boolean d() {
            return this.f121113d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f121110a == dVar.f121110a && Intrinsics.areEqual(this.f121111b, dVar.f121111b) && Intrinsics.areEqual(this.f121112c, dVar.f121112c) && this.f121113d == dVar.f121113d) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int i3 = this.f121110a * 31;
            String str = this.f121111b;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            List list = this.f121112c;
            if (list != null) {
                i16 = list.hashCode();
            }
            int i18 = (i17 + i16) * 31;
            boolean z16 = this.f121113d;
            int i19 = z16;
            if (z16 != 0) {
                i19 = 1;
            }
            return i18 + i19;
        }

        public String toString() {
            return "UserPromptResult(resultCode=" + this.f121110a + ", errMsg=" + this.f121111b + ", selectedScopes=" + this.f121112c + ", userAgreementChecked=" + this.f121113d + ')';
        }

        public /* synthetic */ d(int i3, String str, List list, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : list, (i16 & 8) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r5 f121114a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121115b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f121116c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f121117d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121118a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.tj.d f121119b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ r5 f121120c;

            public a(com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.tj.d dVar2, r5 r5Var) {
                this.f121118a = dVar;
                this.f121119b = dVar2;
                this.f121120c = r5Var;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tencent.luggage.wxa.ic.d dVar = this.f121118a;
                this.f121119b.a(dVar, this.f121120c.f128582l.f127823e, (d0) dVar.b(d0.class)).b(dVar);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements a.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f121121a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121122b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.d5.a f121123c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.tj.d f121124d;

            public b(l lVar, com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.d5.a aVar, com.tencent.luggage.wxa.tj.d dVar2) {
                this.f121121a = lVar;
                this.f121122b = dVar;
                this.f121123c = aVar;
                this.f121124d = dVar2;
            }

            @Override // com.tencent.luggage.wxa.d5.a.b
            public final void a(Bitmap bitmap) {
                if (bitmap != null) {
                    l lVar = this.f121121a;
                    com.tencent.luggage.wxa.ic.d dVar = this.f121122b;
                    com.tencent.luggage.wxa.d5.a aVar = this.f121123c;
                    lVar.a(lVar.a(dVar), bitmap, aVar.T(), AuthorizeCenter.SCOPE_USER_INFO, this.f121124d);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class c implements u, FunctionAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f121125a;

            public c(j jVar) {
                this.f121125a = jVar;
            }

            @Override // com.tencent.luggage.wxa.ml.u
            public final void a() {
                this.f121125a.b();
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof u) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function getFunctionDelegate() {
                return new FunctionReferenceImpl(0, this.f121125a, j.class, "markHadTriggerUserUserAgreementAlert", "markHadTriggerUserUserAgreementAlert()V", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements d.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f121126a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CancellableContinuation f121127b;

            public d(j jVar, CancellableContinuation cancellableContinuation) {
                this.f121126a = jVar;
                this.f121127b = cancellableContinuation;
            }

            @Override // com.tencent.luggage.wxa.tj.d.c
            public void a(int i3, ArrayList resultData, int i16, boolean z16) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            this.f121126a.a(z16, 2);
                        }
                    } else {
                        this.f121126a.a(z16, 1);
                    }
                } else {
                    this.f121126a.a(z16, 0);
                }
                if (this.f121127b.isActive()) {
                    CancellableContinuation cancellableContinuation = this.f121127b;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new d(i3, null, resultData, z16, 2, null)));
                }
            }
        }

        public e(r5 r5Var, com.tencent.luggage.wxa.ic.d dVar, CancellableContinuation cancellableContinuation, l lVar) {
            this.f121114a = r5Var;
            this.f121115b = dVar;
            this.f121116c = cancellableContinuation;
            this.f121117d = lVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x01b4  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00e5  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            Object firstOrNull;
            String str;
            boolean z16;
            boolean z17;
            int collectionSizeOrDefault;
            boolean z18;
            String str2;
            boolean z19;
            boolean z26;
            pb pbVar;
            boolean z27;
            String str3;
            boolean z28;
            boolean z29;
            String str4;
            boolean z36;
            m9 m9Var = (m9) this.f121114a.f128576f.getFirst();
            String str5 = m9Var.f128168d;
            Intrinsics.checkNotNullExpressionValue(str5, "firstScopeInfo.Scope");
            j jVar = new j(str5);
            com.tencent.luggage.wxa.tj.d a16 = d.a.a(this.f121115b, new d(jVar, this.f121116c), this.f121114a.f128576f);
            com.tencent.luggage.wxa.ic.d dVar = this.f121115b;
            r5 r5Var = this.f121114a;
            l lVar = this.f121117d;
            CancellableContinuation cancellableContinuation = this.f121116c;
            a16.b(dVar.getRuntime().S().f125809b);
            a16.k(r5Var.f128581k);
            LinkedList linkedList = r5Var.f128576f;
            Intrinsics.checkNotNullExpressionValue(linkedList, "response.ScopeList");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) linkedList);
            m9 m9Var2 = (m9) firstOrNull;
            if (m9Var2 != null) {
                str = m9Var2.f128169e;
            } else {
                str = null;
            }
            a16.h(str);
            a16.l(r5Var.f128579i);
            a16.j(r5Var.f128580j);
            a16.a(r5Var.f128578h);
            a16.a((d0) dVar.b(d0.class));
            if (!dVar.getRuntime().y0()) {
                com.tencent.luggage.wxa.hn.i iVar = r5Var.f128582l;
                if (iVar != null && iVar.f127822d) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if (z29) {
                    if (iVar != null) {
                        str4 = iVar.f127823e;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z36 = false;
                    } else {
                        z36 = true;
                    }
                    if (!z36) {
                        a16.a(true);
                        a16.a(new a(dVar, a16, r5Var));
                        if (!Intrinsics.areEqual(AuthorizeCenter.SCOPE_USER_INFO, m9Var.f128168d)) {
                            com.tencent.luggage.wxa.d5.a a17 = a.C6131a.a();
                            Intrinsics.checkNotNullExpressionValue(a17, "notNullProvider()");
                            z16 = true;
                            z17 = false;
                            lVar.a(lVar.a(dVar), (Bitmap) null, a17.T(), AuthorizeCenter.SCOPE_USER_INFO, a16);
                            a17.a(new b(lVar, dVar, a17, a16));
                        } else {
                            z16 = true;
                            z17 = false;
                            if (r5Var.f128576f.size() > 1) {
                                a16.a(8);
                                a16.i("");
                                LinkedList linkedList2 = r5Var.f128576f;
                                Intrinsics.checkNotNullExpressionValue(linkedList2, "response.ScopeList");
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedList2, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                int i3 = 0;
                                for (Object obj : linkedList2) {
                                    int i16 = i3 + 1;
                                    if (i3 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    m9 m9Var3 = (m9) obj;
                                    String str6 = m9Var3.f128174j;
                                    String str7 = m9Var3.f128168d;
                                    if (i3 == 0) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    arrayList.add(new j.a(1, str6, str7, z18));
                                    i3 = i16;
                                }
                                a16.a(arrayList);
                            } else {
                                String str8 = m9Var.f128168d;
                                Intrinsics.checkNotNullExpressionValue(str8, "firstScopeInfo.Scope");
                                a16.i(str8);
                            }
                        }
                        str2 = m9Var.f128173i;
                        if (str2 == null && str2.length() != 0) {
                            z19 = z17;
                        } else {
                            z19 = z16;
                        }
                        if (z19) {
                            a16.g(m9Var.f128173i);
                        } else if (p.a(m9Var.f128168d, dVar.getRuntime().j0())) {
                            String a18 = p.a(m9Var.f128168d, dVar.getRuntime());
                            if (a18 != null && a18.length() != 0) {
                                z26 = z17;
                            } else {
                                z26 = z16;
                            }
                            if (z26) {
                                if (cancellableContinuation.isActive()) {
                                    Result.Companion companion = Result.INSTANCE;
                                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new d(3, "fail:require permission desc", null, false, 12, null)));
                                    return;
                                }
                                return;
                            }
                            a16.g(a18);
                        }
                        pbVar = r5Var.f128585o;
                        if (pbVar == null && pbVar.f128430d == z16) {
                            z27 = z16;
                        } else {
                            z27 = z17;
                        }
                        if (z27) {
                            if (pbVar != null) {
                                str3 = pbVar.f128431e;
                            } else {
                                str3 = null;
                            }
                            if (str3 != null && str3.length() != 0) {
                                z28 = z17;
                            } else {
                                z28 = z16;
                            }
                            if (!z28) {
                                String str9 = r5Var.f128585o.f128431e;
                                Intrinsics.checkNotNullExpressionValue(str9, "response.privacy_protect_info.wording");
                                a16.c(str9);
                                jVar.c();
                                a16.a(new c(jVar));
                            }
                        }
                        a16.b(dVar);
                    }
                }
            }
            a16.a(false);
            if (!Intrinsics.areEqual(AuthorizeCenter.SCOPE_USER_INFO, m9Var.f128168d)) {
            }
            str2 = m9Var.f128173i;
            if (str2 == null) {
            }
            z19 = z16;
            if (z19) {
            }
            pbVar = r5Var.f128585o;
            if (pbVar == null) {
            }
            z27 = z17;
            if (z27) {
            }
            a16.b(dVar);
        }
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ Context a(com.tencent.luggage.wxa.xd.d dVar) {
        return h.CC.a(this, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ com.tencent.luggage.wxa.fn.c a(String str) {
        return h.CC.b(this, str);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ gf a(gf gfVar, com.tencent.luggage.wxa.xd.d dVar) {
        return h.CC.c(this, gfVar, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(Context context, Bitmap bitmap, String str, String str2, com.tencent.luggage.wxa.tj.d dVar) {
        h.CC.d(this, context, bitmap, str, str2, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(com.tencent.luggage.wxa.xd.i iVar, com.tencent.luggage.wxa.ml.m mVar) {
        h.CC.e(this, iVar, mVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.xo.d dVar) {
        h.CC.f(this, bVar, dVar);
    }

    public Object a(com.tencent.luggage.wxa.ic.d dVar, List list, Continuation continuation) {
        return a(this, dVar, list, continuation);
    }

    public Object a(com.tencent.luggage.wxa.ic.d dVar, o9 o9Var, Continuation continuation) {
        return a(this, dVar, o9Var, continuation);
    }

    public Object a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj, Continuation continuation) {
        return a(this, dVar, jSONObject, jSONObject2, i3, obj, continuation);
    }

    @Override // com.tencent.luggage.wxa.ae.k
    public final void a(f1 invokeContext, g gVar) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        com.tencent.luggage.wxa.ic.d dVar = (com.tencent.luggage.wxa.ic.d) invokeContext.f();
        JSONObject e16 = invokeContext.e();
        int d16 = invokeContext.d();
        JSONObject g16 = invokeContext.g();
        JSONArray optJSONArray = e16.optJSONArray("scope");
        List b16 = optJSONArray != null ? com.tencent.luggage.wxa.e5.f.f124541a.b(optJSONArray, b.f121109a) : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("showedModal", 0);
        if (!(b16 == null || b16.isEmpty())) {
            BuildersKt__Builders_commonKt.launch$default(com.tencent.luggage.wxa.uk.f.a(dVar), Dispatchers.getMain().getImmediate(), null, new a(dVar, this, e16, g16, d16, jSONObject, gVar, b16, null), 2, null);
        } else {
            a(dVar, d16, "", com.tencent.luggage.wxa.af.e.f121315k, jSONObject);
        }
    }

    public static /* synthetic */ Object a(l lVar, com.tencent.luggage.wxa.ic.d dVar, List list, Continuation continuation) {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object a(l lVar, com.tencent.luggage.wxa.ic.d dVar, o9 o9Var, Continuation continuation) {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object a(l lVar, com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj, Continuation continuation) {
        return Boxing.boxBoolean(false);
    }

    public final Object a(com.tencent.luggage.wxa.ic.d dVar, r5 r5Var, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        dVar.a(new e(r5Var, dVar, cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
