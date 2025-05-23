package com.tencent.mobileqq.studymode;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class StudyModePushConfigProcessor extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    /* loaded from: classes18.dex */
    public static final class a implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public String f290975d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<Integer> f290976e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f290975d = "";
                this.f290976e = new ArrayList<>();
            }
        }

        public static a a(String str) {
            a aVar = new a();
            try {
                String optString = new JSONObject(str).optString("black_ids");
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(optString)) {
                    for (String str2 : optString.split(",")) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str2.trim())));
                    }
                    aVar.f290975d = optString;
                    aVar.f290976e.addAll(arrayList);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("StudyModePushConfigProcessor", 2, "[study mode push config], :" + optString);
                }
            } catch (Throwable th5) {
                QLog.e("StudyModePushConfigProcessor", 1, th5, new Object[0]);
            }
            return aVar;
        }
    }

    public StudyModePushConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a d() {
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101555");
        if (aVar == null) {
            return new a();
        }
        return aVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        super.doOnConfigUpdate(aVar);
        QLog.i("StudyModePushConfigProcessor", 1, "configUpdate " + aVar);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        String str = new String(bArr, StandardCharsets.UTF_8);
        QLog.i("StudyModePushConfigProcessor", 1, "parse " + str);
        if (TextUtils.isEmpty(str)) {
            return new a();
        }
        return a.a(str);
    }
}
