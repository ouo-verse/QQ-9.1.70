package e45;

import c45.b;
import c45.l;
import cooperation.qzone.ShareElfFile;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01df, code lost:
    
        if ((r0 & cooperation.qzone.ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x026a, code lost:
    
        if ((r0 & cooperation.qzone.ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x02b3, code lost:
    
        if ((r0 & cooperation.qzone.ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x02eb, code lost:
    
        r3 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02e9, code lost:
    
        r3 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02e7, code lost:
    
        if ((r10 & cooperation.qzone.ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if ((r0 & (-16384)) != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a1, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
    
        if ((r0 & (-16384)) != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
    
        if ((r0 & cooperation.qzone.ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return 5;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int a(c45.b bVar, Object obj) {
        int i3;
        int i16;
        int i17;
        int i18;
        c45.c cVar;
        Integer num;
        int protoSize;
        Integer valueOf;
        if (bVar instanceof b.e.c) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
            ((Double) obj).doubleValue();
            return 8;
        }
        if (!(bVar instanceof b.e.d)) {
            int i19 = 2;
            if (bVar instanceof b.e.f) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                long longValue = ((Long) obj).longValue();
                if (((-128) & longValue) != 0) {
                    if (longValue >= 0) {
                        if (((-34359738368L) & longValue) != 0) {
                            longValue >>>= 28;
                            i19 = 6;
                        }
                        if (((-2097152) & longValue) != 0) {
                            i19 += 2;
                            longValue >>>= 14;
                        }
                    }
                    return 10;
                }
                return 1;
            }
            if (bVar instanceof b.e.i) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                long longValue2 = ((Long) obj).longValue();
                if (((-128) & longValue2) != 0) {
                    if (longValue2 >= 0) {
                        if (((-34359738368L) & longValue2) != 0) {
                            longValue2 >>>= 28;
                            i19 = 6;
                        }
                        if (((-2097152) & longValue2) != 0) {
                            i19 += 2;
                            longValue2 >>>= 14;
                        }
                    }
                    return 10;
                }
                return 1;
            }
            if (bVar instanceof b.e.C0168e) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj).intValue();
                if (intValue >= 0) {
                    if ((intValue & (-128)) != 0) {
                        if ((intValue & (-16384)) != 0) {
                            if ((intValue & (-2097152)) != 0) {
                            }
                            return 3;
                        }
                    }
                    return 1;
                }
                return 10;
            }
            if (bVar instanceof b.e.a) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                ((Boolean) obj).booleanValue();
            } else {
                int i26 = 0;
                if (bVar instanceof b.e.g) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) obj;
                    int i27 = 0;
                    int i28 = 0;
                    while (true) {
                        if (!(i27 < str.length())) {
                            if ((i28 & (-128)) == 0) {
                                i19 = 1;
                            } else if ((i28 & (-16384)) != 0) {
                                i19 = (i28 & (-2097152)) == 0 ? 3 : (i28 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
                            }
                            return i19 + i28;
                        }
                        if (i27 < str.length()) {
                            int i29 = i27 + 1;
                            char charAt = str.charAt(i27);
                            if (Character.isHighSurrogate(charAt) && i29 < str.length()) {
                                char charAt2 = str.charAt(i29);
                                if (Character.isLowSurrogate(charAt2)) {
                                    i29++;
                                    valueOf = Integer.valueOf((((char) (charAt - '\ud800')) * '\u0400') + 65536 + ((char) (charAt2 - Utf8.LOG_SURROGATE_HEADER)));
                                    int intValue2 = valueOf.intValue();
                                    i28 += intValue2 < 0 && intValue2 < 128 ? 128 <= intValue2 && intValue2 < 2048 ? 2 : 2048 <= intValue2 && intValue2 < 65536 ? 3 : 4 : 1;
                                    i27 = i29;
                                }
                            }
                            valueOf = Integer.valueOf(charAt & CharCompanionObject.MAX_VALUE);
                            int intValue22 = valueOf.intValue();
                            if (intValue22 < 0 && intValue22 < 128) {
                            }
                            i28 += intValue22 < 0 && intValue22 < 128 ? 128 <= intValue22 && intValue22 < 2048 ? 2 : 2048 <= intValue22 && intValue22 < 65536 ? 3 : 4 : 1;
                            i27 = i29;
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                } else {
                    if (bVar instanceof b.e.C0167b) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        byte[] bArr = ((c45.a) obj).f30291a;
                        int length = bArr.length;
                        if ((length & (-128)) == 0) {
                            i19 = 1;
                        } else if ((length & (-16384)) != 0) {
                            i19 = (length & (-2097152)) == 0 ? 3 : (length & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
                        }
                        return bArr.length + i19;
                    }
                    if (!(bVar instanceof b.e.h)) {
                        if (bVar instanceof b.c) {
                            ((b.c) bVar).getClass();
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.Message");
                            c45.d dVar = (c45.d) obj;
                            int protoSize2 = dVar.getProtoSize();
                            if ((protoSize2 & (-128)) == 0) {
                                i19 = 1;
                            } else if ((protoSize2 & (-16384)) != 0) {
                                i19 = (protoSize2 & (-2097152)) == 0 ? 3 : (protoSize2 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
                            }
                            protoSize = dVar.getProtoSize();
                        } else if (bVar instanceof b.d) {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.MessageNew");
                            l lVar = (l) obj;
                            int protoSize3 = lVar.getProtoSize();
                            if ((protoSize3 & (-128)) == 0) {
                                i19 = 1;
                            } else if ((protoSize3 & (-16384)) != 0) {
                                i19 = (protoSize3 & (-2097152)) == 0 ? 3 : (protoSize3 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
                            }
                            protoSize = lVar.getProtoSize();
                        } else {
                            if (bVar instanceof b.a) {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                int intValue3 = ((Integer) obj).intValue();
                                if (intValue3 >= 0) {
                                    if ((intValue3 & (-128)) != 0) {
                                        if ((intValue3 & (-16384)) != 0) {
                                            if ((intValue3 & (-2097152)) != 0) {
                                            }
                                            return 3;
                                        }
                                    }
                                }
                                return 10;
                            }
                            if (bVar instanceof b.f) {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                List list = (List) obj;
                                b.f fVar = (b.f) bVar;
                                final c45.b bVar2 = fVar.f30309a;
                                boolean z16 = fVar.f30310b;
                                Function1<Object, Integer> function1 = new Function1<Object, Integer>() { // from class: pbandk.internal.binary.AbstractSizer$repeatedSize$sizeFn$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Integer invoke(Object obj2) {
                                        return Integer.valueOf(obj2 != null ? e45.b.a(b.this, obj2) : 0);
                                    }
                                };
                                if (z16) {
                                    if ((list instanceof c45.c) && (num = (cVar = (c45.c) list).f30315e) != null) {
                                        i18 = num.intValue();
                                        int intValue4 = cVar.f30315e.intValue();
                                        if ((intValue4 & (-128)) != 0) {
                                            if ((intValue4 & (-16384)) != 0) {
                                                if ((intValue4 & (-2097152)) != 0) {
                                                }
                                                i19 = 3;
                                            }
                                        }
                                        i19 = 1;
                                    } else {
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            i26 += ((Number) function1.invoke(it.next())).intValue();
                                        }
                                        if ((i26 & (-128)) == 0) {
                                            i18 = i26;
                                            i19 = 1;
                                        } else if ((i26 & (-16384)) == 0) {
                                            i18 = i26;
                                        } else if ((i26 & (-2097152)) == 0) {
                                            i18 = i26;
                                            i19 = 3;
                                        } else {
                                            i18 = i26;
                                        }
                                    }
                                    return i19 + i18;
                                }
                                Iterator it5 = list.iterator();
                                while (it5.hasNext()) {
                                    i26 += ((Number) function1.invoke(it5.next())).intValue();
                                }
                                return i26;
                            }
                            if (bVar instanceof b.C0166b) {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                                a.c.C11000a<K, V> c11000a = ((b.C0166b) bVar).f30295a;
                                int i36 = 0;
                                for (Map.Entry entry : ((Map) obj).entrySet()) {
                                    if (entry instanceof a.c) {
                                        i17 = ((a.c) entry).getProtoSize();
                                    } else {
                                        Object key = entry.getKey();
                                        if (!f.a(c11000a.f425876a, key)) {
                                            key = null;
                                        }
                                        if (key != null) {
                                            int a16 = j.a(1, 0);
                                            i3 = a(c11000a.f425876a, key) + ((a16 & (-128)) == 0 ? 1 : (a16 & (-16384)) == 0 ? 2 : (a16 & (-2097152)) == 0 ? 3 : (a16 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5);
                                        } else {
                                            i3 = 0;
                                        }
                                        Object value = entry.getValue();
                                        if (!f.a(c11000a.f425877b, value)) {
                                            value = null;
                                        }
                                        if (value != null) {
                                            int a17 = j.a(2, 0);
                                            i16 = a(c11000a.f425877b, value) + ((a17 & (-128)) == 0 ? 1 : (a17 & (-16384)) == 0 ? 2 : (a17 & (-2097152)) == 0 ? 3 : (a17 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5);
                                        } else {
                                            i16 = 0;
                                        }
                                        i17 = i16 + i3;
                                    }
                                    i36 += ((i17 & (-128)) == 0 ? 1 : (i17 & (-16384)) == 0 ? 2 : (i17 & (-2097152)) == 0 ? 3 : (i17 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5) + i17;
                                }
                                return i36;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        return protoSize + i19;
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int intValue5 = ((Integer) obj).intValue();
                    if ((intValue5 & (-128)) != 0) {
                        if ((intValue5 & (-16384)) != 0) {
                            if ((intValue5 & (-2097152)) != 0) {
                            }
                            return 3;
                        }
                    }
                }
            }
            return 1;
            return i19;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        ((Float) obj).floatValue();
        return 4;
    }
}
