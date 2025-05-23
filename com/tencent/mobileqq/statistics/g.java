package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String f289997d;

    /* renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f289998a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, String> f289999b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<File>> f290000c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a implements Comparator<File> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file != null && file2 != null) {
                if (file.length() > file2.length()) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75421);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f289997d = QLog.getLogExternalPath(BaseApplication.getContext()) + "/tencent/msflogs/com/tencent/mobileqq/";
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f289998a = new SimpleDateFormat("yyyy-MM-dd HH");
        this.f289999b = new HashMap<>();
        this.f290000c = new HashMap<>();
    }

    private int b(File file) {
        File[] listFiles;
        if (file.isFile()) {
            return (int) file.length();
        }
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return 0;
        }
        int i3 = 0;
        for (File file2 : listFiles) {
            i3 += b(file2);
        }
        return i3;
    }

    private void c(File[] fileArr) {
        if (fileArr == null) {
            QLog.e("LogSizeReporter", 1, "file array is null");
            return;
        }
        for (File file : fileArr) {
            if (file.isFile() && file.exists()) {
                String[] split = file.getName().split("\\.");
                if (split.length != 8) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LogSizeReporter", 1, "is not logfile");
                    }
                } else {
                    String str = split[2];
                    if (!split[7].equals("qlog")) {
                        if (QLog.isColorLevel()) {
                            QLog.d("LogSizeReporter", 1, "is not qlog");
                        }
                    } else {
                        if (!this.f290000c.containsKey(str)) {
                            this.f290000c.put(str, new ArrayList<>());
                        }
                        ArrayList<File> arrayList = this.f290000c.get(str);
                        if (arrayList != null) {
                            String str2 = "20" + split[3] + "-" + split[4] + "-" + split[5] + " " + split[6];
                            Date parse = this.f289998a.parse(this.f289998a.format(new Date()), new ParsePosition(0));
                            Date parse2 = this.f289998a.parse(str2, new ParsePosition(0));
                            if (parse != null && parse2 != null) {
                                if (((int) (parse.getTime() - parse2.getTime())) / 3600000 < 24) {
                                    arrayList.add(file);
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("LogSizeReporter", 1, "date is null");
                            }
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("LogSizeReporter", 1, "not file or not exists");
            }
        }
    }

    private void d() {
        a aVar = new a();
        for (Map.Entry<String, ArrayList<File>> entry : this.f290000c.entrySet()) {
            String key = entry.getKey();
            ArrayList<File> value = entry.getValue();
            try {
                if (value.isEmpty()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LogSizeReporter", 1, "logList is empty");
                    }
                } else if (!this.f289999b.containsKey(key)) {
                    value.sort(aVar);
                    int i3 = 0;
                    if (value.size() >= 3) {
                        i3 = ((int) ((value.get(0).length() + value.get(1).length()) + value.get(2).length())) / 3;
                    } else if (value.size() != 0) {
                        Iterator<File> it = value.iterator();
                        long j3 = 0;
                        while (it.hasNext()) {
                            j3 += it.next().length();
                        }
                        i3 = ((int) j3) / value.size();
                    }
                    this.f289999b.put(key, String.valueOf(i3));
                } else if (QLog.isColorLevel()) {
                    QLog.d("LogSizeReporter", 1, "this process has been analysed");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public HashMap<String, String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        File file = new File(f289997d);
        c(file.listFiles());
        d();
        this.f289999b.put("sumOfSize", String.valueOf(b(file) / 1048576));
        return this.f289999b;
    }
}
