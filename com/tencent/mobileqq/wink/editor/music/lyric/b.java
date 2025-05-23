package com.tencent.mobileqq.wink.editor.music.lyric;

import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
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
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f320853d = Pattern.compile("(?<=\\[).*?(?=\\])");

    /* renamed from: e, reason: collision with root package name */
    private static final a f320854e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f320855a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<d73.e> f320856b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private int f320857c;

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

    public b(String str) {
        this.f320855a = str;
    }

    private void b(String str) {
        String trim;
        if (str != null && !str.equals("")) {
            Matcher matcher = f320853d.matcher(str);
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
                            d73.e eVar = new d73.e();
                            eVar.f393180a = substring;
                            eVar.f393181b = d16;
                            this.f320856b.add(eVar);
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
                if (trim.length() == 0 && this.f320857c == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        int c16 = c((String) it5.next());
                        if (c16 != Integer.MAX_VALUE) {
                            this.f320857c = c16;
                            break;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    long d17 = d((String) it6.next());
                    if (d17 != -1 && trim.length() > 0) {
                        d73.e eVar2 = new d73.e();
                        eVar2.f393180a = trim;
                        eVar2.f393181b = d17;
                        this.f320856b.add(eVar2);
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
                if (this.f320857c == 0 && split[0].equalsIgnoreCase("offset")) {
                    this.f320857c = Integer.parseInt(split[1]);
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

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00a2: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:163), block:B:54:0x00a2 */
    public d73.b a() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str = this.f320855a;
        BufferedReader bufferedReader3 = null;
        if (str == null) {
            return null;
        }
        try {
            if (str != null) {
                try {
                    bufferedReader2 = new BufferedReader(new StringReader(str));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            b(readLine.trim());
                        } catch (Exception e16) {
                            e = e16;
                            Log.e("ParsingLrc", e.toString());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e17) {
                                    Log.e("ParsingLrc", e17.toString());
                                }
                            }
                            return null;
                        }
                    }
                    Collections.sort(this.f320856b, f320854e);
                    for (int i3 = 0; i3 < this.f320856b.size(); i3++) {
                        if (i3 < this.f320856b.size() - 1) {
                            this.f320856b.get(i3).f393182c = this.f320856b.get(i3 + 1).f393181b - this.f320856b.get(i3).f393181b;
                        } else {
                            this.f320856b.get(i3).f393182c = 999999L;
                        }
                    }
                    d73.b bVar = new d73.b(1, this.f320857c, this.f320856b);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e18) {
                        Log.e("ParsingLrc", e18.toString());
                    }
                    return bVar;
                } catch (Exception e19) {
                    e = e19;
                    bufferedReader2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
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
            bufferedReader3 = bufferedReader;
        }
    }
}
