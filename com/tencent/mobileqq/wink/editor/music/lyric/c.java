package com.tencent.mobileqq.wink.editor.music.lyric;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
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
/* loaded from: classes21.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f320858d = Pattern.compile("(?<=\\[).*?(?=\\])");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f320859e = Pattern.compile("(?<=\\()-?[0-9]*,-?[0-9]*(?=\\))");

    /* renamed from: f, reason: collision with root package name */
    private static final a f320860f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f320861a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<d73.e> f320862b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private int f320863c;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class a implements Comparator<d73.e> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d73.e eVar, d73.e eVar2) {
            if (eVar.f393181b >= eVar2.f393181b) {
                return 1;
            }
            return -1;
        }
    }

    public c(String str) {
        this.f320861a = str;
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
            Matcher matcher = f320858d.matcher(str);
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
                        d73.e eVar = new d73.e();
                        if (e(str2, eVar) != -1) {
                            d(substring, eVar);
                            this.f320862b.add(eVar);
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
                if (trim.length() == 0 && this.f320863c == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        int a16 = a((String) it5.next());
                        if (a16 != Integer.MAX_VALUE) {
                            this.f320863c = a16;
                            return;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    String str3 = (String) it6.next();
                    d73.e eVar2 = new d73.e();
                    if (e(str3, eVar2) != -1) {
                        d(trim, eVar2);
                        this.f320862b.add(eVar2);
                    }
                }
            } catch (Exception e16) {
                Log.e("ParsingQrc", e16.toString());
            }
        }
    }

    private void d(String str, d73.e eVar) {
        d73.a aVar;
        try {
            eVar.f393180a = "";
            if (str != null && !str.equals("")) {
                Matcher matcher = f320859e.matcher(str);
                ArrayList<d73.a> arrayList = new ArrayList<>();
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
                    d73.a f16 = f(group, length, str2.length(), aVar);
                    if (f16 != null) {
                        arrayList.add(f16);
                    }
                }
                eVar.f393180a = str2;
                eVar.f393186g = arrayList;
            }
        } catch (Exception e16) {
            Log.e("ParsingQrc", "", e16);
        }
    }

    private long e(String str, d73.e eVar) {
        String[] split = str.split("\\,");
        if (split.length < 2) {
            String[] split2 = str.split("\\:");
            if (this.f320863c == 0 && split2[0].equalsIgnoreCase("offset")) {
                this.f320863c = Integer.parseInt(split2[1]);
            }
            return -1L;
        }
        if (split.length == 2) {
            try {
                long parseLong = Long.parseLong(split[1]);
                long parseLong2 = Long.parseLong(split[0]);
                eVar.f393182c = parseLong;
                eVar.f393181b = parseLong2;
                return parseLong2;
            } catch (Exception unused) {
            }
        }
        return -1L;
    }

    private d73.a f(String str, int i3, int i16, d73.a aVar) {
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
        return new d73.a(j16, j3, i3, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [int] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d73.b b() {
        int i3;
        int i16;
        ?? r36;
        BufferedReader bufferedReader;
        String str = this.f320861a;
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
                        r36 = substring4.lastIndexOf("\"");
                    } else {
                        r36 = -1;
                    }
                    if (r36 == -1) {
                        return null;
                    }
                    try {
                        try {
                            bufferedReader = new BufferedReader(new StringReader(substring4.substring(0, r36)));
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
                            Collections.sort(this.f320862b, f320860f);
                            d73.b bVar = new d73.b(2, this.f320863c, this.f320862b);
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
                        bufferedReader2 = r36;
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
