package com.tencent.mobileqq.msf.core.net.utils.f;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends com.tencent.mobileqq.msf.core.net.utils.f.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f249528g = "file_del_time";

    /* renamed from: h, reason: collision with root package name */
    private static final String f249529h = "key_delete_version_new";

    /* renamed from: i, reason: collision with root package name */
    private static final String f249530i = "plain";

    /* renamed from: j, reason: collision with root package name */
    private static final String f249531j = "regex";

    /* renamed from: k, reason: collision with root package name */
    private static final int f249532k = 2;

    /* renamed from: l, reason: collision with root package name */
    private static final String f249533l = "files";

    /* renamed from: m, reason: collision with root package name */
    private static final String f249534m = "shared_prefs";

    /* renamed from: n, reason: collision with root package name */
    private static final String f249535n = "${FILE_DIR}";

    /* renamed from: o, reason: collision with root package name */
    private static final String f249536o = "${SP_DIR}";

    /* renamed from: p, reason: collision with root package name */
    private static final String f249537p = "${DATA_DIR}";

    /* renamed from: q, reason: collision with root package name */
    private static final String f249538q = "${SDCARD_DIR}";

    /* renamed from: r, reason: collision with root package name */
    private static final String f249539r = "${EXFILE_DIR}";

    /* renamed from: e, reason: collision with root package name */
    private boolean f249540e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<String> f249541f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends HashSet<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            } else {
                add(c.f249530i);
                add(c.f249531j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f249543a;

        b(String str) {
            this.f249543a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) str);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            return Pattern.compile(this.f249543a).matcher(str).matches();
        }
    }

    public c(String str, List<Pair<String, String>> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f249541f = new a();
        this.f249516a = str;
        this.f249517b = list;
        this.f249518c = z16;
        this.f249540e = z17;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(Pair<String, String> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pair)).booleanValue();
        }
        if (pair == null || !this.f249541f.contains(pair.first) || TextUtils.isEmpty((CharSequence) pair.second)) {
            return false;
        }
        int i3 = 0;
        for (String str : ((String) pair.second).split(File.separator)) {
            if (!TextUtils.isEmpty(str)) {
                i3++;
            }
        }
        return i3 >= 2;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean b() {
        List<Pair<String, String>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? MsfCmdConfig.CMD_DELETE_FILE.equals(this.f249516a) && (list = this.f249517b) != null && list.size() > 0 : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
    }

    private String b(String str) {
        StringBuilder sb5 = new StringBuilder();
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        String sb6 = sb5.toString();
        String absolutePath = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        if (f249535n.equals(str)) {
            return absolutePath + str2;
        }
        if (f249536o.equals(str)) {
            return absolutePath.replace(f249533l, f249534m) + str2;
        }
        if (f249537p.equals(str)) {
            return absolutePath.replace(f249533l, "");
        }
        if (f249538q.equals(str)) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + str2;
        }
        if (!f249539r.equals(str)) {
            return sb6;
        }
        return BaseApplication.getContext().getExternalFilesDir(null).getAbsolutePath() + str2;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(@NonNull String str, List<Pair<String, String>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) list)).booleanValue();
        }
        if (list == null) {
            return true;
        }
        try {
            if (this.f249540e) {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(f249528g, 0);
                String string = sharedPreferences.getString(f249529h, "");
                if (str.equals(string)) {
                    QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,don't delete file one more times,localversion =" + string + ",version = " + str);
                    return false;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putString(f249529h, str);
                    edit.commit();
                }
                QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,just delete file one times,localversion =" + string + ",version = " + str);
            }
        } catch (Throwable th5) {
            QLog.e(MsfCmdConfig.TAG, 1, "execute faild", th5);
        }
        QLog.d(MsfCmdConfig.TAG, 1, "safe mode delete file");
        boolean z16 = false;
        for (Pair<String, String> pair : list) {
            String[] split = ((String) pair.second).split(File.separator);
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                    z16 = true;
                }
            }
            a(arrayList, "", 0, (String) pair.first);
        }
        return z16;
    }

    private void a(ArrayList<String> arrayList, String str, int i3, String str2) {
        if (i3 >= arrayList.size()) {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
                MsfPullConfigUtil.showToastForSafeModeTest("\u6267\u884c\u5220\u9664\u6587\u4ef6\u6307\u4ee4\uff0c\u4fee\u590d\u95ea\u9000");
                return;
            }
            return;
        }
        if (i3 == 0) {
            String b16 = b(arrayList.get(i3));
            if (TextUtils.isEmpty(b16) || !new File(b16).exists()) {
                return;
            }
            a(arrayList, b16, i3 + 1, str2);
            return;
        }
        String str3 = arrayList.get(i3);
        if (f249530i.equals(str2)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(str3);
            sb5.append(i3 != arrayList.size() + (-1) ? File.separator : "");
            a(arrayList, sb5.toString(), i3 + 1, str2);
            return;
        }
        File[] listFiles = new File(str).listFiles(new b(str3));
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(file2.getAbsolutePath());
            sb6.append(i3 == arrayList.size() + (-1) ? "" : File.separator);
            a(arrayList, sb6.toString(), i3 + 1, str2);
        }
    }
}
