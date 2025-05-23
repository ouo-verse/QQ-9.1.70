package com.tencent.mobileqq.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
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
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f243169d;

    /* renamed from: e, reason: collision with root package name */
    private static final a f243170e;

    /* renamed from: a, reason: collision with root package name */
    private final String f243171a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.lyric.data.d> f243172b;

    /* renamed from: c, reason: collision with root package name */
    private int f243173c;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a implements Comparator<com.tencent.mobileqq.lyric.data.d> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.lyric.data.d dVar, com.tencent.mobileqq.lyric.data.d dVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) dVar2)).intValue();
            }
            if (dVar.f243149b >= dVar2.f243149b) {
                return 1;
            }
            return -1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37133);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f243169d = Pattern.compile("(?<=\\[).*?(?=\\])");
            f243170e = new a();
        }
    }

    public c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f243172b = new ArrayList<>();
            this.f243171a = str;
        }
    }

    private void b(String str) {
        String trim;
        if (str != null && !str.equals("")) {
            Matcher matcher = f243169d.matcher(str);
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
                            com.tencent.mobileqq.lyric.data.d dVar = new com.tencent.mobileqq.lyric.data.d();
                            dVar.f243148a = substring;
                            dVar.f243149b = d16;
                            this.f243172b.add(dVar);
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
                if (trim.length() == 0 && this.f243173c == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        int c16 = c((String) it5.next());
                        if (c16 != Integer.MAX_VALUE) {
                            this.f243173c = c16;
                            break;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    long d17 = d((String) it6.next());
                    if (d17 != -1 && trim.length() > 0) {
                        com.tencent.mobileqq.lyric.data.d dVar2 = new com.tencent.mobileqq.lyric.data.d();
                        dVar2.f243148a = trim;
                        dVar2.f243149b = d17;
                        this.f243172b.add(dVar2);
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
                if (this.f243173c == 0 && split[0].equalsIgnoreCase("offset")) {
                    this.f243173c = Integer.parseInt(split[1]);
                    return -1L;
                }
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt >= 0 && parseInt2 >= 0 && parseInt2 < 60) {
                    return ((parseInt * 60) + parseInt2) * 1000;
                }
                throw new RuntimeException(HardCodeUtil.qqStr(R.string.ozj));
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
                throw new RuntimeException(HardCodeUtil.qqStr(R.string.ozk));
            } catch (Exception unused2) {
            }
        }
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [boolean] */
    public com.tencent.mobileqq.lyric.data.b a() {
        BufferedReader bufferedReader;
        ?? hasPatch;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && (hasPatch = iPatchRedirector.hasPatch((short) 2)) != 0) {
            return (com.tencent.mobileqq.lyric.data.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = this.f243171a;
        BufferedReader bufferedReader2 = null;
        if (str == null) {
            return null;
        }
        try {
            if (str != null) {
                try {
                    bufferedReader = new BufferedReader(new StringReader(str));
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
                    Collections.sort(this.f243172b, f243170e);
                    for (int i3 = 0; i3 < this.f243172b.size(); i3++) {
                        if (i3 < this.f243172b.size() - 1) {
                            this.f243172b.get(i3).f243150c = this.f243172b.get(i3 + 1).f243149b - this.f243172b.get(i3).f243149b;
                        } else {
                            this.f243172b.get(i3).f243150c = 999999L;
                        }
                    }
                    com.tencent.mobileqq.lyric.data.b bVar = new com.tencent.mobileqq.lyric.data.b(1, this.f243173c, this.f243172b);
                    try {
                        bufferedReader.close();
                    } catch (IOException e18) {
                        Log.e("ParsingLrc", e18.toString());
                    }
                    return bVar;
                } catch (Exception e19) {
                    e = e19;
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
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
            return null;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader2 = hasPatch;
        }
    }
}
