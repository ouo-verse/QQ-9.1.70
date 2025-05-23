package com.tencent.luggage.wxa.wj;

import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.tn.w;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(b bVar, boolean z16);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v2 com.tencent.luggage.wxa.wj.e$b, still in use, count: 1, list:
  (r0v2 com.tencent.luggage.wxa.wj.e$b) from 0x004c: FILLED_NEW_ARRAY 
  (r4v3 com.tencent.luggage.wxa.wj.e$b)
  (r7v1 com.tencent.luggage.wxa.wj.e$b)
  (r1v3 com.tencent.luggage.wxa.wj.e$b)
  (r0v2 com.tencent.luggage.wxa.wj.e$b)
 A[WRAPPED] (LINE:77) elemType: com.tencent.luggage.wxa.wj.e$b
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:238)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        PORTRAIT(1),
        UNSPECIFIED(-1),
        LANDSCAPE_SENSOR(6),
        LANDSCAPE_LOCKED(0),
        LANDSCAPE_LEFT(8),
        LANDSCAPE_RIGHT(0);


        /* renamed from: h, reason: collision with root package name */
        public static final b[] f144275h;

        /* renamed from: a, reason: collision with root package name */
        public final int f144277a;

        static {
            f144275h = new b[]{r4, r7, r1, new b(6)};
        }

        public b(int i3) {
            this.f144277a = i3;
        }

        public static boolean b(b bVar) {
            return ArrayUtils.contains(f144275h, bVar);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f144276i.clone();
        }

        public boolean a(b bVar) {
            b bVar2;
            return this == bVar || (this == (bVar2 = LANDSCAPE_SENSOR) && bVar == LANDSCAPE_LOCKED) || (this == LANDSCAPE_LOCKED && bVar == bVar2);
        }

        public boolean b() {
            return b(this);
        }

        public static b a(int i3) {
            for (b bVar : values()) {
                if (bVar.f144277a == i3) {
                    return bVar;
                }
            }
            return UNSPECIFIED;
        }

        public static b b(String str) {
            if ("landscape".equals(str)) {
                return LANDSCAPE_SENSOR;
            }
            if ("portrait".equals(str)) {
                return PORTRAIT;
            }
            if ("landscapeLeft".equals(str)) {
                return LANDSCAPE_LEFT;
            }
            if ("landscapeRight".equals(str)) {
                return LANDSCAPE_RIGHT;
            }
            if (!"auto".equals(str) && !UNSPECIFIED.name().equalsIgnoreCase(str)) {
                for (b bVar : values()) {
                    if (bVar.name().equalsIgnoreCase(str)) {
                        return bVar;
                    }
                }
                return null;
            }
            return UNSPECIFIED;
        }

        public static b a(String str) {
            b b16 = b(str);
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = b16 == null ? null : b16.name();
            objArr[2] = Integer.valueOf(b16 == null ? -1 : b16.f144277a);
            w.d("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", objArr);
            return b16;
        }

        public static b a(i iVar) {
            b a16 = iVar != null ? a(iVar.f125812e) : null;
            return a16 == null ? PORTRAIT : a16;
        }
    }

    b a();

    void a(b bVar, a aVar);
}
