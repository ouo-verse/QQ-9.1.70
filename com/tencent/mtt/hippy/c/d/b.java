package com.tencent.mtt.hippy.c.d;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.mtt.hippy.c.d;
import com.tencent.mtt.hippy.c.d.c;
import com.tencent.mtt.hippy.runtime.builtins.JSSharedArrayBuffer;
import com.tencent.mtt.hippy.runtime.builtins.b;
import com.tencent.mtt.hippy.runtime.builtins.c;
import com.tencent.mtt.hippy.runtime.builtins.e;
import com.tencent.mtt.hippy.runtime.builtins.f;
import com.tencent.mtt.hippy.runtime.builtins.g;
import com.tencent.mtt.hippy.runtime.builtins.h;
import com.tencent.mtt.hippy.runtime.builtins.i;
import java.nio.ByteBuffer;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends d {

    /* renamed from: f, reason: collision with root package name */
    private final a f337152f;

    /* renamed from: g, reason: collision with root package name */
    private Map<com.tencent.mtt.hippy.runtime.builtins.a, Integer> f337153g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f337154h;

    /* renamed from: i, reason: collision with root package name */
    private c f337155i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.c.d.b$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f337156a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f337157b;

        static {
            int[] iArr = new int[c.a.values().length];
            f337157b = iArr;
            try {
                iArr[c.a.EvalError.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f337157b[c.a.RangeError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f337157b[c.a.ReferenceError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f337157b[c.a.SyntaxError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f337157b[c.a.TypeError.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f337157b[c.a.URIError.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[b.a.values().length];
            f337156a = iArr2;
            try {
                iArr2[b.a.DATA_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f337156a[b.a.BIGINT64_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f337156a[b.a.BIGUINT64_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f337156a[b.a.FLOAT32_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f337156a[b.a.FLOAT64_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f337156a[b.a.INT8_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f337156a[b.a.INT16_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f337156a[b.a.INT32_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f337156a[b.a.UINT8_ARRAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f337156a[b.a.UINT8_CLAMPED_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f337156a[b.a.UINT16_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f337156a[b.a.UINT32_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        int a(b bVar, JSSharedArrayBuffer jSSharedArrayBuffer);

        boolean a(b bVar, c cVar);

        boolean a(b bVar, Object obj);
    }

    public b() {
        this(null, null, 13);
    }

    private void a(com.tencent.mtt.hippy.c.a aVar) {
        this.f337140a.a(aVar.a());
    }

    private void b(@NonNull com.tencent.mtt.hippy.runtime.builtins.c cVar) {
        com.tencent.mtt.hippy.c.b bVar;
        c.a a16 = cVar.a();
        switch (AnonymousClass1.f337157b[a16.ordinal()]) {
            case 1:
                bVar = com.tencent.mtt.hippy.c.b.EVAL_ERROR;
                break;
            case 2:
                bVar = com.tencent.mtt.hippy.c.b.RANGE_ERROR;
                break;
            case 3:
                bVar = com.tencent.mtt.hippy.c.b.REFERENCE_ERROR;
                break;
            case 4:
                bVar = com.tencent.mtt.hippy.c.b.SYNTAX_ERROR;
                break;
            case 5:
                bVar = com.tencent.mtt.hippy.c.b.TYPE_ERROR;
                break;
            case 6:
                bVar = com.tencent.mtt.hippy.c.b.URI_ERROR;
                break;
            default:
                if (a16 != c.a.Error && a16 != c.a.AggregateError) {
                    throw new com.tencent.mtt.hippy.b.b();
                }
                bVar = null;
                break;
        }
        if (bVar != null) {
            a(bVar);
        }
    }

    private boolean c(Object obj) {
        a((byte) 92);
        a aVar = this.f337152f;
        if (aVar != null) {
            return aVar.a(this, obj);
        }
        throw new com.tencent.mtt.hippy.c.b.b(obj);
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object m() {
        return f.f337627b;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object n() {
        return f.f337628c;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object o() {
        return f.f337626a;
    }

    public b(com.tencent.mtt.hippy.c.c.b.b bVar, a aVar, int i3) {
        super(bVar, i3);
        this.f337152f = aVar;
    }

    private void a(com.tencent.mtt.hippy.c.b bVar) {
        this.f337140a.a(bVar.a());
    }

    private void a(c.a aVar) {
        if (this.f337152f == null) {
            throw new com.tencent.mtt.hippy.c.b.b(aVar);
        }
        if (this.f337155i == null) {
            c cVar = new c();
            this.f337155i = cVar;
            if (!this.f337152f.a(this, cVar)) {
                this.f337155i = null;
                return;
            }
        }
        a(PublicAccountH5AbilityPluginImpl.OPENCAMERA);
        this.f337140a.a(this.f337155i.a(aVar));
    }

    private void a(@NonNull JSSharedArrayBuffer jSSharedArrayBuffer) {
        a aVar = this.f337152f;
        if (aVar == null) {
            throw new com.tencent.mtt.hippy.c.b.b(jSSharedArrayBuffer);
        }
        int a16 = aVar.a(this, jSSharedArrayBuffer);
        a(IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR);
        this.f337140a.a(a16);
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.a.a aVar) {
        byte b16;
        int h16 = aVar.h();
        if (aVar.k()) {
            a((byte) 65);
            this.f337140a.a(h16);
            for (int i3 = 0; i3 < h16; i3++) {
                a(aVar.a(i3));
            }
            a(e.b((e) aVar));
            b16 = 36;
        } else {
            if (!aVar.l()) {
                throw new com.tencent.mtt.hippy.b.b();
            }
            a((byte) 97);
            this.f337140a.a(h16);
            for (Pair<Integer, Object> pair : ((com.tencent.mtt.hippy.runtime.builtins.a.c) aVar).a()) {
                this.f337140a.a(((Integer) pair.first).intValue());
                a(pair.second);
            }
            a(e.b((e) aVar));
            b16 = MaskType.MASK_TYPE_EXTERNAL;
        }
        a(b16);
        this.f337140a.a(e.a((e) aVar));
        this.f337140a.a(h16);
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.a aVar) {
        if (this.f337153g == null) {
            this.f337153g = new IdentityHashMap();
        }
        Integer num = this.f337153g.get(aVar);
        if (num != null) {
            a(IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE);
            this.f337140a.a(com.tencent.mtt.hippy.c.f.a.a(num.intValue()));
            return;
        }
        ByteBuffer a16 = aVar.a();
        int limit = a16.limit();
        a((byte) 66);
        this.f337140a.a(limit);
        for (int i3 = 0; i3 < limit; i3++) {
            this.f337140a.a(a16.get(i3));
        }
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.b.a aVar) {
        a(aVar.c());
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.b.b bVar) {
        a(bVar.a() ? IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic : (byte) 120);
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.b.c cVar) {
        a(Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM);
        a(cVar.c().doubleValue());
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.b.e eVar) {
        a(IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM);
        a(eVar.c().toString());
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.b<?> bVar) {
        com.tencent.mtt.hippy.c.a aVar;
        if (this.f337154h) {
            if (!c(bVar)) {
                throw new com.tencent.mtt.hippy.c.b.b(bVar);
            }
            return;
        }
        a((byte) 86);
        switch (AnonymousClass1.f337156a[bVar.a().ordinal()]) {
            case 1:
                aVar = com.tencent.mtt.hippy.c.a.DATA_VIEW;
                break;
            case 2:
                aVar = com.tencent.mtt.hippy.c.a.BIGINT64_ARRAY;
                break;
            case 3:
                aVar = com.tencent.mtt.hippy.c.a.BIGUINT64_ARRAY;
                break;
            case 4:
                aVar = com.tencent.mtt.hippy.c.a.FLOAT32_ARRAY;
                break;
            case 5:
                aVar = com.tencent.mtt.hippy.c.a.FLOAT64_ARRAY;
                break;
            case 6:
                aVar = com.tencent.mtt.hippy.c.a.INT8_ARRAY;
                break;
            case 7:
                aVar = com.tencent.mtt.hippy.c.a.INT16_ARRAY;
                break;
            case 8:
                aVar = com.tencent.mtt.hippy.c.a.INT32_ARRAY;
                break;
            case 9:
                aVar = com.tencent.mtt.hippy.c.a.UINT8_ARRAY;
                break;
            case 10:
                aVar = com.tencent.mtt.hippy.c.a.UINT8_CLAMPED_ARRAY;
                break;
            case 11:
                aVar = com.tencent.mtt.hippy.c.a.UINT16_ARRAY;
                break;
            case 12:
                aVar = com.tencent.mtt.hippy.c.a.UINT32_ARRAY;
                break;
            default:
                throw new com.tencent.mtt.hippy.b.b();
        }
        a(aVar);
        this.f337140a.a(bVar.d());
        this.f337140a.a(bVar.e());
        if (c() >= 14) {
            this.f337140a.a(bVar.b());
        }
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.c cVar) {
        a(IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC);
        b(cVar);
        String b16 = cVar.b();
        if (!b16.isEmpty()) {
            a(com.tencent.mtt.hippy.c.b.MESSAGE);
            a(b16);
        }
        String c16 = cVar.c();
        if (!c16.isEmpty()) {
            a(com.tencent.mtt.hippy.c.b.STACK);
            a(c16);
        }
        a(com.tencent.mtt.hippy.c.b.END);
    }

    private void a(@NonNull com.tencent.mtt.hippy.runtime.builtins.d dVar) {
        a((byte) 59);
        int i3 = 0;
        for (Map.Entry<Object, Object> entry : dVar.a().entrySet()) {
            i3++;
            a(entry.getKey());
            a(entry.getValue());
        }
        a((byte) 58);
        this.f337140a.a(i3 * 2);
    }

    private void a(e eVar) {
        a(PublicAccountH5AbilityPluginImpl.OPENIMG);
        a(eVar.i());
        a((byte) 123);
        this.f337140a.a(eVar.h());
    }

    private void a(@NonNull g gVar) {
        a((byte) 82);
        a(gVar.a());
        this.f337140a.a(gVar.b());
    }

    private void a(@NonNull h hVar) {
        a((byte) 39);
        Iterator<Object> it = hVar.a().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3++;
            a(it.next());
        }
        a((byte) 44);
        this.f337140a.a(i3);
    }

    private void a(@NonNull Set<Pair<String, Object>> set) {
        for (Pair<String, Object> pair : set) {
            a((String) pair.first);
            a(pair.second);
        }
    }

    @Override // com.tencent.mtt.hippy.c.d
    public boolean a(Object obj) {
        if (super.a(obj)) {
            return true;
        }
        if (c() >= 15 && (obj instanceof c.a)) {
            b(obj);
            a((c.a) obj);
            return true;
        }
        if (!this.f337154h && i.a(obj) && ((i) obj).r()) {
            com.tencent.mtt.hippy.runtime.builtins.b bVar = (com.tencent.mtt.hippy.runtime.builtins.b) obj;
            b(bVar);
            boolean z16 = bVar.c() instanceof com.tencent.mtt.hippy.runtime.builtins.a;
            com.tencent.mtt.hippy.runtime.builtins.a c16 = bVar.c();
            if (z16) {
                a((JSSharedArrayBuffer) c16);
            } else {
                a(c16);
            }
        }
        if (i.a(obj)) {
            b(obj);
            i iVar = (i) obj;
            if (iVar.j()) {
                a((com.tencent.mtt.hippy.runtime.builtins.a.a) iVar);
            } else if (iVar.r()) {
                a((com.tencent.mtt.hippy.runtime.builtins.b<?>) iVar);
            } else if (iVar.n()) {
                a((com.tencent.mtt.hippy.runtime.builtins.c) iVar);
            } else if (iVar.o()) {
                a((g) iVar);
            } else if (iVar.m()) {
                a((e) iVar);
            } else if (iVar.p()) {
                a((com.tencent.mtt.hippy.runtime.builtins.d) iVar);
            } else if (iVar.q()) {
                a((h) iVar);
            } else if (iVar.s()) {
                a((JSSharedArrayBuffer) iVar);
            } else if (iVar.t()) {
                a((com.tencent.mtt.hippy.runtime.builtins.a) iVar);
            } else if (iVar.u()) {
                a((com.tencent.mtt.hippy.runtime.builtins.b.b) iVar);
            } else if (iVar.w()) {
                a(IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION);
                a((com.tencent.mtt.hippy.runtime.builtins.b.a) iVar);
            } else if (iVar.x()) {
                a((com.tencent.mtt.hippy.runtime.builtins.b.c) iVar);
            } else {
                if (!iVar.v()) {
                    throw new com.tencent.mtt.hippy.b.b();
                }
                a((com.tencent.mtt.hippy.runtime.builtins.b.e) iVar);
            }
        } else {
            if (!c(obj)) {
                return false;
            }
            b(obj);
        }
        return true;
    }
}
