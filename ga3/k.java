package ga3;

import ga3.p;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
class k implements p.b<Set<String>> {

    /* renamed from: a, reason: collision with root package name */
    static final k f401631a = new k();

    k() {
    }

    @Override // ga3.p.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<String> a(byte[] bArr, int i3, int i16) {
        int i17;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i16 > 0) {
            m mVar = new m(bArr, i3);
            int i18 = i3 + i16;
            while (true) {
                i17 = mVar.f401636c;
                if (i17 >= i18) {
                    break;
                }
                linkedHashSet.add(mVar.m(mVar.p()));
            }
            if (i17 != i18) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // ga3.p.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public byte[] encode(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i3 = 0;
        int i16 = 0;
        for (String str : set) {
            if (str == null) {
                i3 += 5;
                iArr[i16] = -1;
            } else {
                int n3 = m.n(str);
                strArr[i16] = str;
                iArr[i16] = n3;
                i3 += m.o(n3) + n3;
            }
            i16++;
        }
        m mVar = new m(i3);
        for (int i17 = 0; i17 < size; i17++) {
            int i18 = iArr[i17];
            mVar.z(i18);
            if (i18 >= 0) {
                mVar.x(strArr[i17]);
            }
        }
        return mVar.f401635b;
    }

    @Override // ga3.p.b
    public String tag() {
        return "StringSetEncoder";
    }
}
