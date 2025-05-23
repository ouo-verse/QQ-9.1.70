package com.tencent.lyric.util;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
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
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f147099d;

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f147100e;

    /* renamed from: f, reason: collision with root package name */
    private static final b f147101f;

    /* renamed from: a, reason: collision with root package name */
    private final String f147102a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<com.tencent.lyric.data.e> f147103b;

    /* renamed from: c, reason: collision with root package name */
    private int f147104c;

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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13931);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f147099d = Pattern.compile("(?<=\\[).*?(?=\\])");
        f147100e = Pattern.compile("(?<=\\()-?[0-9]*,-?[0-9]*(?=\\))");
        f147101f = new b(null);
    }

    public f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f147103b = new ArrayList<>();
            this.f147102a = str;
        }
    }

    private int a(String str) {
        String[] split = str.split("\\:");
        try {
            if (split.length == 2 && "offset".equalsIgnoreCase(split[0])) {
                return Integer.parseInt(split[1].trim());
            }
        } catch (Exception e16) {
            Log.e("ParsingQrc", e16.toString());
        }
        return 0;
    }

    private void c(String str) {
        if (str != null && !str.equals("")) {
            Matcher matcher = f147099d.matcher(str);
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
                        String str2 = (String) it.next();
                        com.tencent.lyric.data.e eVar = new com.tencent.lyric.data.e();
                        if (e(str2, eVar) != -1) {
                            d(substring, eVar);
                            this.f147103b.add(eVar);
                        }
                    }
                    arrayList.clear();
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
                if (i17 > str.length()) {
                    i17 = str.length();
                }
                String trim = str.substring(i17).trim();
                if (trim.length() == 0 && this.f147104c == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        int a16 = a((String) it5.next());
                        if (a16 != Integer.MAX_VALUE) {
                            this.f147104c = a16;
                            return;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    String str3 = (String) it6.next();
                    com.tencent.lyric.data.e eVar2 = new com.tencent.lyric.data.e();
                    if (e(str3, eVar2) != -1) {
                        d(trim, eVar2);
                        this.f147103b.add(eVar2);
                    }
                }
            } catch (Exception e16) {
                Log.e("ParsingQrc", e16.toString());
            }
        }
    }

    private long e(String str, com.tencent.lyric.data.e eVar) {
        String[] split = str.split("\\,");
        if (split.length < 2) {
            String[] split2 = str.split("\\:");
            if (this.f147104c == 0 && split2[0].equalsIgnoreCase("offset")) {
                this.f147104c = Integer.parseInt(split2[1]);
            }
            return -1L;
        }
        if (split.length == 2) {
            try {
                long parseLong = Long.parseLong(split[1]);
                long parseLong2 = Long.parseLong(split[0]);
                eVar.f147072c = parseLong;
                eVar.f147071b = parseLong2;
                return parseLong2;
            } catch (Exception unused) {
            }
        }
        return -1L;
    }

    private com.tencent.lyric.data.b f(String str, int i3, int i16, com.tencent.lyric.data.b bVar) {
        long j3;
        long j16;
        String[] split = str.split("\\,");
        if (split.length < 2 || split.length != 2) {
            return null;
        }
        long parseLong = Long.parseLong(split[1]);
        long parseLong2 = Long.parseLong(split[0]);
        if (parseLong < 0) {
            j3 = 0;
        } else {
            j3 = parseLong;
        }
        if (parseLong2 < 0) {
            j16 = 0;
        } else {
            j16 = parseLong2;
        }
        return new com.tencent.lyric.data.b(j16, j3, i3, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [int] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.lyric.data.a b() {
        int i3;
        int i16;
        ?? r46;
        BufferedReader bufferedReader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.lyric.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = this.f147102a;
        BufferedReader bufferedReader2 = null;
        if (str != null) {
            if (str.contains("LyricContent")) {
                i3 = str.indexOf("LyricContent");
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                int i17 = i3 + 12;
                if (str.length() > i17 + 1) {
                    String substring = str.substring(i17);
                    if (!substring.trim().startsWith(ContainerUtils.KEY_VALUE_DELIMITER)) {
                        return null;
                    }
                    String substring2 = substring.substring(substring.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
                    if (!substring2.trim().startsWith("\"")) {
                        return null;
                    }
                    String substring3 = substring2.substring(substring2.indexOf("\"") + 1);
                    if (substring3.contains("/>")) {
                        i16 = substring3.lastIndexOf("/>");
                    } else {
                        i16 = -1;
                    }
                    if (i16 == -1) {
                        return null;
                    }
                    String substring4 = substring3.substring(0, i16);
                    if (substring4.contains("\"")) {
                        r46 = substring4.lastIndexOf("\"");
                    } else {
                        r46 = -1;
                    }
                    if (r46 == -1) {
                        return null;
                    }
                    try {
                        try {
                            bufferedReader = new BufferedReader(new StringReader(substring4.substring(0, r46)));
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    c(readLine.trim());
                                } catch (Exception e16) {
                                    e = e16;
                                    Log.e("ParsingQrc", e.toString());
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e17) {
                                            Log.e("ParsingQrc", e17.toString());
                                        }
                                    }
                                    return null;
                                }
                            }
                            Collections.sort(this.f147103b, f147101f);
                            com.tencent.lyric.data.a aVar = new com.tencent.lyric.data.a(2, this.f147104c, this.f147103b);
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                Log.e("ParsingQrc", e18.toString());
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
                        bufferedReader2 = r46;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e26) {
                                Log.e("ParsingQrc", e26.toString());
                            }
                        }
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str, com.tencent.lyric.data.e eVar) {
        com.tencent.lyric.data.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) eVar);
            return;
        }
        try {
            eVar.f147070a = "";
            if (str != null && !str.equals("")) {
                Matcher matcher = f147100e.matcher(str);
                ArrayList<com.tencent.lyric.data.b> arrayList = new ArrayList<>();
                String str2 = "";
                while (matcher.find()) {
                    String group = matcher.group();
                    if (group == null) {
                        group = "";
                    }
                    int indexOf = str.indexOf("(" + group + ")");
                    int length = str2.length();
                    str2 = str2 + str.substring(0, indexOf);
                    str = str.substring(indexOf + group.length() + 2, str.length());
                    if (arrayList.size() > 0) {
                        bVar = arrayList.get(arrayList.size() - 1);
                    } else {
                        bVar = null;
                    }
                    com.tencent.lyric.data.b f16 = f(group, length, str2.length(), bVar);
                    if (f16 != null) {
                        arrayList.add(f16);
                    }
                }
                eVar.f147070a = str2;
                eVar.f147074e = arrayList;
            }
        } catch (Exception e16) {
            Log.e("ParsingQrc", "", e16);
        }
    }
}
