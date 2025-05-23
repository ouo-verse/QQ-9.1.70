package com.tencent.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f147094d;

    /* renamed from: e, reason: collision with root package name */
    private static final b f147095e;

    /* renamed from: a, reason: collision with root package name */
    private final String f147096a;

    /* renamed from: b, reason: collision with root package name */
    private int f147097b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<com.tencent.lyric.data.e> f147098c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class b implements Comparator<com.tencent.lyric.data.e> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.lyric.data.e eVar, com.tencent.lyric.data.e eVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) eVar2)).intValue();
            }
            if (eVar.f147071b >= eVar2.f147071b) {
                return 1;
            }
            return -1;
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f147094d = Pattern.compile("(?<=\\[).*?(?=\\])");
            f147095e = new b(null);
        }
    }

    public e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f147098c = new ArrayList<>();
            this.f147096a = str;
        }
    }

    private void b(String str) {
        String trim;
        if (str != null && !str.equals("")) {
            Matcher matcher = f147094d.matcher(str);
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            int i16 = -1;
            while (matcher.find()) {
                String group = matcher.group();
                if (group == null) {
                    group = "";
                }
                int indexOf = str.indexOf("[" + group + "]");
                if (i16 != -1 && indexOf - i16 > i3 + 2) {
                    String substring = str.substring(i16 + i3 + 2, indexOf);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        long d16 = d((String) it.next());
                        if (d16 != -1) {
                            com.tencent.lyric.data.e eVar = new com.tencent.lyric.data.e();
                            eVar.f147070a = substring;
                            eVar.f147071b = d16;
                            this.f147098c.add(eVar);
                        }
                    }
                }
                arrayList.add(group);
                i3 = group.length();
                i16 = indexOf;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            int i17 = i3 + 2 + i16;
            try {
                try {
                    if (i17 > str.length()) {
                        i17 = str.length();
                    }
                    trim = str.substring(i17).trim();
                } catch (Exception e16) {
                    Log.e("ParsingLrc", e16.toString());
                }
                if (trim.length() == 0 && this.f147097b == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        int c16 = c((String) it5.next());
                        if (c16 != Integer.MAX_VALUE) {
                            this.f147097b = c16;
                            break;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    long d17 = d((String) it6.next());
                    if (d17 != -1 && trim.length() > 0) {
                        com.tencent.lyric.data.e eVar2 = new com.tencent.lyric.data.e();
                        eVar2.f147070a = trim;
                        eVar2.f147071b = d17;
                        this.f147098c.add(eVar2);
                    }
                }
            } finally {
                arrayList.clear();
            }
        }
    }

    private int c(String str) {
        String[] split = str.split("\\:");
        try {
            if (split.length == 2 && "offset".equalsIgnoreCase(split[0])) {
                return Integer.parseInt(split[1].trim());
            }
        } catch (Exception e16) {
            Log.e("ParsingLrc", e16.toString());
        }
        return 0;
    }

    private long d(String str) {
        String[] split = str.split("\\:|\\.");
        if (split.length < 2) {
            return -1L;
        }
        if (split.length == 2) {
            try {
                if (this.f147097b == 0 && split[0].equalsIgnoreCase("offset")) {
                    this.f147097b = Integer.parseInt(split[1]);
                    return -1L;
                }
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt >= 0 && parseInt2 >= 0 && parseInt2 < 60) {
                    return ((parseInt * 60) + parseInt2) * 1000;
                }
                throw new RuntimeException("\u6570\u5b57\u4e0d\u5408\u6cd5!");
            } catch (Exception unused) {
                return -1L;
            }
        }
        if (split.length == 3) {
            try {
                int parseInt3 = Integer.parseInt(split[0]);
                int parseInt4 = Integer.parseInt(split[1]);
                int parseInt5 = Integer.parseInt(split[2]);
                if (parseInt3 >= 0 && parseInt4 >= 0 && parseInt4 < 60 && parseInt5 >= 0 && parseInt5 <= 99) {
                    return (((parseInt3 * 60) + parseInt4) * 1000) + (parseInt5 * 10);
                }
                throw new RuntimeException("\u6570\u5b57\u4e0d\u5408\u6cd5!");
            } catch (Exception unused2) {
            }
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.lyric.data.a a() {
        BufferedReader bufferedReader;
        ?? hasPatch;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && (hasPatch = iPatchRedirector.hasPatch((short) 2)) != 0) {
            return (com.tencent.lyric.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new StringReader(this.f147096a));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        b(readLine.trim());
                    } catch (Exception e16) {
                        e = e16;
                        Log.e("ParsingLrc", e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e17) {
                                Log.e("ParsingLrc", e17.toString());
                            }
                        }
                        return null;
                    }
                }
                Collections.sort(this.f147098c, f147095e);
                for (int i3 = 0; i3 < this.f147098c.size(); i3++) {
                    if (i3 < this.f147098c.size() - 1) {
                        this.f147098c.get(i3).f147072c = this.f147098c.get(i3 + 1).f147071b - this.f147098c.get(i3).f147071b;
                    } else {
                        this.f147098c.get(i3).f147072c = 999999L;
                    }
                }
                com.tencent.lyric.data.a aVar = new com.tencent.lyric.data.a(1, this.f147097b, this.f147098c);
                try {
                    bufferedReader.close();
                } catch (IOException e18) {
                    Log.e("ParsingLrc", e18.toString());
                }
                return aVar;
            } catch (Exception e19) {
                e = e19;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader2 = hasPatch;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e26) {
                    Log.e("ParsingLrc", e26.toString());
                }
            }
            throw th;
        }
    }
}
