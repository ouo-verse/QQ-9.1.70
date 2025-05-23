package com.tencent.mobileqq.unitedconfig_android.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.unitedconfig_android.api.IManageMigrate;
import com.tencent.mobileqq.unitedconfig_android.i;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ManageMigrateImpl implements IManageMigrate {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_VERSION = "0";
    private static final String KEY_CONFIG_VERSION = "key_config_version";
    private static final String KEY_CONTENT = "key_content";
    private static final String SEPARATOR = "_";

    public ManageMigrateImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String genKey(String str, String str2) {
        return str + "_" + str2;
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IManageMigrate
    public void migrate(@NonNull String str, int i3, @NonNull String str2, @Nullable String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, str3);
        } else {
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            i iVar = new i(str);
            iVar.encodeBytes(genKey(str2, "key_content"), str3.getBytes(StandardCharsets.UTF_8));
            iVar.encodeString(genKey(str2, KEY_CONFIG_VERSION), "0");
        }
    }
}
