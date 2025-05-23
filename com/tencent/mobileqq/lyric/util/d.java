package com.tencent.mobileqq.lyric.util;

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
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f243174d;

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f243175e;

    /* renamed from: f, reason: collision with root package name */
    private static final a f243176f;

    /* renamed from: a, reason: collision with root package name */
    private final String f243177a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.lyric.data.d> f243178b;

    /* renamed from: c, reason: collision with root package name */
    private int f243179c;

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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37155);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f243174d = Pattern.compile("(?<=\\[).*?(?=\\])");
        f243175e = Pattern.compile("(?<=\\()-?[0-9]*,-?[0-9]*(?=\\))");
        f243176f = new a();
    }

    public d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f243178b = new ArrayList<>();
            this.f243177a = str;
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
            Matcher matcher = f243174d.matcher(str);
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
                        com.tencent.mobileqq.lyric.data.d dVar = new com.tencent.mobileqq.lyric.data.d();
                        if (e(str2, dVar) != -1) {
                            d(substring, dVar);
                            this.f243178b.add(dVar);
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
                if (trim.length() == 0 && this.f243179c == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        int a16 = a((String) it5.next());
                        if (a16 != Integer.MAX_VALUE) {
                            this.f243179c = a16;
                            return;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    String str3 = (String) it6.next();
                    com.tencent.mobileqq.lyric.data.d dVar2 = new com.tencent.mobileqq.lyric.data.d();
                    if (e(str3, dVar2) != -1) {
                        d(trim, dVar2);
                        this.f243178b.add(dVar2);
                    }
                }
            } catch (Exception e16) {
                Log.e("ParsingQrc", e16.toString());
            }
        }
    }

    private void d(String str, com.tencent.mobileqq.lyric.data.d dVar) {
        com.tencent.mobileqq.lyric.data.a aVar;
        try {
            dVar.f243148a = "";
            if (str != null && !str.equals("")) {
                Matcher matcher = f243175e.matcher(str);
                ArrayList<com.tencent.mobileqq.lyric.data.a> arrayList = new ArrayList<>();
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
                        aVar = arrayList.get(arrayList.size() - 1);
                    } else {
                        aVar = null;
                    }
                    com.tencent.mobileqq.lyric.data.a f16 = f(group, length, str2.length(), aVar);
                    if (f16 != null) {
                        arrayList.add(f16);
                    }
                }
                dVar.f243148a = str2;
                dVar.f243154g = arrayList;
            }
        } catch (Exception e16) {
            Log.e("ParsingQrc", "", e16);
        }
    }

    private long e(String str, com.tencent.mobileqq.lyric.data.d dVar) {
        String[] split = str.split("\\,");
        if (split.length < 2) {
            String[] split2 = str.split("\\:");
            if (this.f243179c == 0 && split2[0].equalsIgnoreCase("offset")) {
                this.f243179c = Integer.parseInt(split2[1]);
            }
            return -1L;
        }
        if (split.length == 2) {
            try {
                long parseLong = Long.parseLong(split[1]);
                long parseLong2 = Long.parseLong(split[0]);
                dVar.f243150c = parseLong;
                dVar.f243149b = parseLong2;
                return parseLong2;
            } catch (Exception unused) {
            }
        }
        return -1L;
    }

    private com.tencent.mobileqq.lyric.data.a f(String str, int i3, int i16, com.tencent.mobileqq.lyric.data.a aVar) {
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
        return new com.tencent.mobileqq.lyric.data.a(j16, j3, i3, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [int] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.lyric.data.b b() {
        int i3;
        int i16;
        ?? r46;
        BufferedReader bufferedReader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.lyric.data.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = this.f243177a;
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
                            Collections.sort(this.f243178b, f243176f);
                            com.tencent.mobileqq.lyric.data.b bVar = new com.tencent.mobileqq.lyric.data.b(2, this.f243179c, this.f243178b);
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                Log.e("ParsingQrc", e18.toString());
                            }
                            return bVar;
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
}
