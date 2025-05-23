package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
class ce {

    /* renamed from: h, reason: collision with root package name */
    private static String f388377h = "/MiPushLog";

    /* renamed from: b, reason: collision with root package name */
    private String f388379b;

    /* renamed from: c, reason: collision with root package name */
    private String f388380c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f388381d;

    /* renamed from: e, reason: collision with root package name */
    private int f388382e;

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat f388378a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f, reason: collision with root package name */
    private int f388383f = 2097152;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<File> f388384g = new ArrayList<>();

    private void e(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z16 = false;
        while (read != -1 && !z16) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i3 >= read || !matcher.find(i3)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f388379b.length() + start);
                if (!this.f388381d) {
                    if (substring.compareTo(this.f388379b) >= 0) {
                        this.f388381d = true;
                        i16 = start;
                    }
                } else if (substring.compareTo(this.f388380c) > 0) {
                    z16 = true;
                    read = start;
                    break;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f388379b.length();
                }
                i3 = start + indexOf;
            }
            if (this.f388381d) {
                int i17 = read - i16;
                this.f388382e += i17;
                if (z16) {
                    bufferedWriter.write(cArr, i16, i17);
                    return;
                } else {
                    bufferedWriter.write(cArr, i16, i17);
                    if (this.f388382e > this.f388383f) {
                        return;
                    }
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    private void f(File file) {
        BufferedReader bufferedReader;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + ia.a() + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.ae.g() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f388382e = 0;
                    Iterator<File> it = this.f388384g.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            e(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            bufferedReader2 = bufferedWriter;
                            jz4.c.z("LOG: filter error = " + e.getMessage());
                            in.b(bufferedReader2);
                            in.b(bufferedReader);
                            return;
                        } catch (IOException e17) {
                            e = e17;
                            bufferedReader2 = bufferedWriter;
                            jz4.c.z("LOG: filter error = " + e.getMessage());
                            in.b(bufferedReader2);
                            in.b(bufferedReader);
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = bufferedWriter;
                            in.b(bufferedReader2);
                            in.b(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(bb.c().v());
                    in.b(bufferedWriter);
                    in.b(bufferedReader2);
                } catch (FileNotFoundException e18) {
                    e = e18;
                    bufferedReader = bufferedReader2;
                } catch (IOException e19) {
                    e = e19;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = bufferedReader2;
                }
            } catch (FileNotFoundException e26) {
                e = e26;
                bufferedReader = null;
            } catch (IOException e27) {
                e = e27;
                bufferedReader = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    ce a(File file) {
        if (file.exists()) {
            this.f388384g.add(file);
        }
        return this;
    }

    ce b(Date date, Date date2) {
        if (date.after(date2)) {
            this.f388379b = this.f388378a.format(date2);
            this.f388380c = this.f388378a.format(date);
        } else {
            this.f388379b = this.f388378a.format(date);
            this.f388380c = this.f388378a.format(date2);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = cd.a(context);
            if (file2 == null) {
                return null;
            }
            a(new File(file2, "xmsf.log.1"));
            a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(context.getFilesDir() + f388377h);
            if (!im.b(file3)) {
                return null;
            }
            a(new File(file3, "log0.txt"));
            a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        b(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        f(file5);
        jz4.c.z("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            in.c(file4, file5);
            jz4.c.z("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i3) {
        if (i3 != 0) {
            this.f388383f = i3;
        }
    }
}
