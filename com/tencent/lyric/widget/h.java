package com.tencent.lyric.widget;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static int a(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2, int i3, int i16, int i17) {
        int size;
        if (aVar != null) {
            if (i3 == 0) {
                return i16;
            }
            if (i3 >= 0) {
                if (i16 >= 0 && i16 <= i17 && i17 < aVar.f147056b.size()) {
                    if (aVar.f147057c != null) {
                        int i18 = 0;
                        if (aVar2 == null) {
                            while (i16 <= i17) {
                                i18 += aVar.f147056b.get(i16).e();
                                if (i3 <= i18) {
                                    return i16;
                                }
                                i16++;
                            }
                            return i17;
                        }
                        if (aVar2.f147057c != null) {
                            if (aVar.f147056b.size() != aVar2.f147056b.size()) {
                                Log.w("LyricViewHelper", "\u539f\u6b4c\u8bcd\u548c\u7f57\u9a6c\u97f3\u6b4c\u8bcd\u4e0d\u4e00\u81f4");
                                if (aVar.f147056b.size() < aVar2.f147056b.size()) {
                                    size = aVar.f147056b.size();
                                } else {
                                    size = aVar2.f147056b.size();
                                }
                            } else {
                                size = aVar.f147056b.size();
                            }
                            if (i17 >= size) {
                                i17 = size;
                            }
                            int i19 = 0;
                            while (i18 < i17) {
                                i19 = i19 + aVar.f147056b.get(i18).e() + aVar2.f147056b.get(i18).e();
                                if (i3 <= i19) {
                                    return i18;
                                }
                                i18++;
                            }
                            return i17 - 1;
                        }
                        Log.w("LyricViewHelper", "\u53c2\u6570\u662f\u5426\u672a\u751f\u6210ui");
                        throw new RuntimeException("\u53c2\u6570\u4e0d\u5408\u6cd5");
                    }
                    Log.w("LyricViewHelper", "\u53c2\u6570\u662f\u5426\u672a\u751f\u6210ui");
                    throw new RuntimeException("\u53c2\u6570\u4e0d\u5408\u6cd5");
                }
                Log.i("LyricViewHelper", "\u884c\u53f7\u4e0d\u5408\u6cd5");
                throw new RuntimeException("\u53c2\u6570\u4e0d\u5408\u6cd5");
            }
            Log.i("LyricViewHelper", "\u884c\u53f7\u4e0d\u5408\u6cd5");
            throw new RuntimeException("\u53c2\u6570\u4e0d\u5408\u6cd5");
        }
        Log.i("LyricViewHelper", "\u6b4c\u8bcd\u4e3a\u7a7a");
        throw new RuntimeException("\u53c2\u6570\u4e0d\u5408\u6cd5");
    }

    public static final com.tencent.lyric.data.a b(com.tencent.lyric.data.a aVar) {
        if (aVar == null) {
            return new com.tencent.lyric.data.a(2, 0, null);
        }
        com.tencent.lyric.data.a aVar2 = new com.tencent.lyric.data.a(2, aVar.f147061g, new ArrayList());
        aVar2.f147055a = aVar.f147055a;
        Iterator<com.tencent.lyric.data.e> it = aVar.f147056b.iterator();
        while (it.hasNext()) {
            com.tencent.lyric.data.e next = it.next();
            if (next != null) {
                Iterator<com.tencent.lyric.data.f> it5 = next.f147073d.iterator();
                while (it5.hasNext()) {
                    aVar2.f147056b.add(new com.tencent.lyric.data.e(it5.next()));
                }
            }
        }
        return aVar2;
    }

    public static final com.tencent.lyric.data.a c(com.tencent.lyric.data.a aVar) {
        if (aVar == null) {
            return new com.tencent.lyric.data.a(2, 0, null);
        }
        com.tencent.lyric.data.a aVar2 = new com.tencent.lyric.data.a(2, aVar.f147061g, new ArrayList());
        aVar2.f147055a = aVar.f147055a;
        Iterator<com.tencent.lyric.data.e> it = aVar.f147056b.iterator();
        while (it.hasNext()) {
            com.tencent.lyric.data.e next = it.next();
            if (next != null) {
                Iterator<com.tencent.lyric.data.f> it5 = next.f147073d.iterator();
                while (it5.hasNext()) {
                    com.tencent.lyric.data.f next2 = it5.next();
                    com.tencent.lyric.data.e eVar = new com.tencent.lyric.data.e(next2);
                    if (eVar.f147073d == null) {
                        eVar.f147073d = new ArrayList<>();
                    }
                    eVar.f147073d.clear();
                    eVar.f147073d.add(next2);
                    aVar2.f147056b.add(eVar);
                }
            }
        }
        aVar2.u(aVar.f147057c);
        return aVar2;
    }
}
