package com.tencent.mobileqq.msf.core.net.utils.f;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f249548f = "sp_del_time";

    /* renamed from: g, reason: collision with root package name */
    private static final String f249549g = "key_sp_delete_version_new";

    /* renamed from: e, reason: collision with root package name */
    private boolean f249550e;

    public e(String str, List<Pair<String, String>> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f249516a = str;
        this.f249517b = list;
        this.f249518c = z16;
        this.f249550e = z17;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(Pair<String, String> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (pair == null || TextUtils.isEmpty((CharSequence) pair.first) || TextUtils.isEmpty((CharSequence) pair.second)) ? false : true : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pair)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean b() {
        List<Pair<String, String>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (MsfCmdConfig.CMD_DELETE_SP_KEY.equals(this.f249516a) && (list = this.f249517b) != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5 */
    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(@NonNull String str, List<Pair<String, String>> list) {
        String str2;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) list)).booleanValue();
        }
        int i17 = 1;
        if (list == null) {
            return true;
        }
        int i18 = 0;
        try {
            if (this.f249550e) {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(f249548f, 0);
                String string = sharedPreferences.getString(f249549g, "");
                if (str.equals(string)) {
                    QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,don't delete sp one more times,localversion =" + string + ",version = " + str);
                    return false;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putString(f249549g, str);
                    edit.commit();
                }
                QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,just delete sp one times,localversion =" + string + ",version = " + str);
            }
        } catch (Throwable th5) {
            QLog.e(MsfCmdConfig.TAG, 1, "execute delete sp faild", th5);
        }
        String replace = BaseApplication.getContext().getFilesDir().getAbsolutePath().replace("files", "shared_prefs");
        int i19 = this.f249518c ? 4 : 0;
        int i26 = 2;
        QLog.d(MsfCmdConfig.TAG, 1, " The SharedPreferenceMode is ", Integer.valueOf(i19));
        boolean z16 = 0;
        for (Pair<String, String> pair : list) {
            File file = new File(replace + File.separator + ((String) pair.first) + ".xml");
            if (file.isFile() && file.exists()) {
                SharedPreferences sharedPreferences2 = BaseApplication.getContext().getSharedPreferences((String) pair.first, i19);
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                if (edit2 != null) {
                    Map<String, ?> all = sharedPreferences2.getAll();
                    Pattern compile = Pattern.compile((String) pair.second);
                    Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                    while (it.hasNext()) {
                        String key = it.next().getKey();
                        if (compile.matcher(key).matches()) {
                            edit2.remove(key).commit();
                            Object[] objArr = new Object[i26];
                            objArr[i18] = key;
                            objArr[i17] = " has been removed";
                            QLog.d(MsfCmdConfig.TAG, i17, objArr);
                            z16 = i17;
                        }
                    }
                }
                MsfPullConfigUtil.showToastForSafeModeTest("\u6267\u884c\u5220\u9664sp\u6307\u4ee4\uff0c\u4fee\u590d\u95ea\u9000");
            } else {
                File[] filesByConfigFilePath = MsfCmdConfig.getFilesByConfigFilePath(replace, (String) pair.first, "xml");
                if (filesByConfigFilePath == null || filesByConfigFilePath.length <= 0) {
                    i26 = i26;
                    i17 = i17;
                    replace = replace;
                    i18 = i18;
                } else {
                    int length = filesByConfigFilePath.length;
                    int i27 = i18;
                    z16 = z16;
                    while (i27 < length) {
                        File file2 = filesByConfigFilePath[i27];
                        if (file2.isFile() && file2.exists()) {
                            String name = file2.getName();
                            if (name.endsWith(".xml")) {
                                str2 = replace;
                                SharedPreferences sharedPreferences3 = BaseApplication.getContext().getSharedPreferences(name.substring(i18, name.length() - 4), i19);
                                SharedPreferences.Editor edit3 = sharedPreferences3.edit();
                                if (edit3 != null) {
                                    Map<String, ?> all2 = sharedPreferences3.getAll();
                                    Pattern compile2 = Pattern.compile((String) pair.second);
                                    Iterator<Map.Entry<String, ?>> it5 = all2.entrySet().iterator();
                                    while (it5.hasNext()) {
                                        String key2 = it5.next().getKey();
                                        if (compile2.matcher(key2).matches()) {
                                            edit3.remove(key2).commit();
                                            QLog.d(MsfCmdConfig.TAG, 1, key2, " has been removed");
                                            it5 = it5;
                                            z16 = 1;
                                            i18 = 0;
                                        } else {
                                            it5 = it5;
                                            i18 = 0;
                                        }
                                    }
                                }
                                i3 = i18;
                                i16 = 2;
                                MsfPullConfigUtil.showToastForSafeModeTest("\u6267\u884c\u5220\u9664sp\u6307\u4ee4\uff0c\u4fee\u590d\u95ea\u9000");
                                i27++;
                                i26 = i16;
                                replace = str2;
                                i18 = i3;
                                z16 = z16;
                            } else {
                                str2 = replace;
                                i3 = i18;
                                i16 = 2;
                            }
                        } else {
                            str2 = replace;
                            i3 = i18;
                            i16 = i26;
                        }
                        i27++;
                        i26 = i16;
                        replace = str2;
                        i18 = i3;
                        z16 = z16;
                    }
                    i17 = 1;
                }
            }
        }
        return z16;
    }
}
