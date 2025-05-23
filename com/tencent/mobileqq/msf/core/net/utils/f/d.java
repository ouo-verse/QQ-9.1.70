package com.tencent.mobileqq.msf.core.net.utils.f;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f249545f = "mmkv_del_time";

    /* renamed from: g, reason: collision with root package name */
    private static final String f249546g = "key_mmkv_delete_version_new";

    /* renamed from: e, reason: collision with root package name */
    private boolean f249547e;

    public d(String str, List<Pair<String, String>> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f249516a = str;
        this.f249517b = list;
        this.f249518c = z16;
        this.f249547e = z17;
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
        if (MsfCmdConfig.CMD_DELETE_MMKV_KEY.equals(this.f249516a) && (list = this.f249517b) != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(@NonNull String str, List<Pair<String, String>> list) {
        String str2;
        Iterator<Pair<String, String>> it;
        int i3;
        int i16;
        Iterator<Pair<String, String>> it5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) list)).booleanValue();
        }
        if (list == null) {
            return true;
        }
        int i17 = 0;
        try {
            if (this.f249547e) {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(f249545f, 0);
                String string = sharedPreferences.getString(f249546g, "");
                if (str.equals(string)) {
                    QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,don't delete mmkv one more times,localversion =" + string + ",version = " + str);
                    return false;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putString(f249546g, str);
                    edit.commit();
                }
                QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,just delete mmkv one times,localversion =" + string + ",version = " + str);
            }
        } catch (Throwable th5) {
            QLog.e(MsfCmdConfig.TAG, 1, "execute delete mmkv faild", th5);
        }
        String str3 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/mmkv";
        int i18 = 2;
        int i19 = this.f249518c ? 2 : 1;
        Iterator<Pair<String, String>> it6 = list.iterator();
        boolean z16 = false;
        while (it6.hasNext()) {
            Pair<String, String> next = it6.next();
            File file = new File(str3 + File.separator + ((String) next.first));
            if (file.isFile() && file.exists()) {
                MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), (String) next.first, i19);
                Pattern compile = Pattern.compile((String) next.second);
                String[] allKeyArr = from.allKeyArr();
                int length = allKeyArr.length;
                for (int i26 = i17; i26 < length; i26++) {
                    String str4 = allKeyArr[i26];
                    if (compile.matcher(str4).matches()) {
                        from.removeKey(str4);
                        Object[] objArr = new Object[i18];
                        objArr[i17] = str4;
                        objArr[1] = " has been removed";
                        QLog.d(MsfCmdConfig.TAG, 1, objArr);
                        z16 = true;
                    }
                }
                from.commitAsync();
            } else {
                File[] filesByConfigFilePath = MsfCmdConfig.getFilesByConfigFilePath(str3, (String) next.first, "");
                Pattern compile2 = Pattern.compile((String) next.second);
                int length2 = filesByConfigFilePath.length;
                int i27 = i17;
                while (i27 < length2) {
                    File file2 = filesByConfigFilePath[i27];
                    if (file2 != null && file2.isFile() && file2.exists()) {
                        MMKVOptionEntity from2 = QMMKV.from(BaseApplication.getContext(), file2.getName(), i19);
                        String[] allKeyArr2 = from2.allKeyArr();
                        int length3 = allKeyArr2.length;
                        int i28 = 0;
                        while (i28 < length3) {
                            String str5 = str3;
                            String str6 = allKeyArr2[i28];
                            if (compile2.matcher(str6).matches()) {
                                from2.removeKey(str6);
                                it5 = it6;
                                QLog.d(MsfCmdConfig.TAG, 1, str6, " has been removed");
                                z16 = true;
                            } else {
                                it5 = it6;
                            }
                            i28++;
                            it6 = it5;
                            str3 = str5;
                        }
                        str2 = str3;
                        it = it6;
                        i16 = 2;
                        i3 = 0;
                        from2.commitAsync();
                    } else {
                        str2 = str3;
                        it = it6;
                        i3 = i17;
                        i16 = i18;
                    }
                    i27++;
                    it6 = it;
                    i18 = i16;
                    i17 = i3;
                    str3 = str2;
                }
            }
        }
        return z16;
    }
}
