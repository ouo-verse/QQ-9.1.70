package com.tencent.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends f {
    static IPatchRedirector $redirector_;

    public g(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    private com.tencent.lyric.data.d g(List<com.tencent.lyric.data.b> list, int i3) {
        if (list != null && !list.isEmpty()) {
            long j3 = list.get(0).f147062a;
            int i16 = list.get(0).f147064c + i3;
            int i17 = list.get(list.size() - 1).f147065d + i3;
            Iterator<com.tencent.lyric.data.b> it = list.iterator();
            long j16 = 0;
            while (it.hasNext()) {
                j16 += it.next().f147063b;
            }
            return new com.tencent.lyric.data.d(j3, j16, i16, i17);
        }
        return null;
    }

    private void h(String str, com.tencent.lyric.data.e eVar) {
        String[] split;
        if (str != null) {
            try {
                if (!str.equals("") && (split = str.split("<seg>")) != null && split.length != 0) {
                    ArrayList<com.tencent.lyric.data.d> arrayList = new ArrayList<>(split.length);
                    if (split.length == 1) {
                        arrayList.add(g(eVar.f147074e, 0));
                    } else {
                        com.tencent.lyric.data.e eVar2 = new com.tencent.lyric.data.e();
                        int i3 = 0;
                        for (String str2 : split) {
                            eVar2.f147070a = null;
                            eVar2.f147074e = null;
                            super.d(str2, eVar2);
                            com.tencent.lyric.data.d g16 = g(eVar2.f147074e, i3);
                            if (g16 != null) {
                                arrayList.add(g16);
                                i3 = g16.f147069d;
                            }
                        }
                    }
                    eVar.f147075f = arrayList;
                }
            } catch (Exception e16) {
                Log.e("ParsingQrc", "parseQrcSeg", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.lyric.util.f
    public void d(String str, com.tencent.lyric.data.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) eVar);
        } else if (str != null && !str.equals("")) {
            super.d(str.replaceAll("<seg>", ""), eVar);
            h(str, eVar);
        }
    }
}
