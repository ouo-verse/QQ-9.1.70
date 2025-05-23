package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class DonDisturbProcessor extends BaseConfigParser<j> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j defaultConfig() {
        return new j();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable j jVar) {
        super.doOnConfigUpdate(jVar);
        if (jVar == null) {
            return;
        }
        ea.l5(BaseApplication.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), jVar.b());
        if (QLog.isColorLevel()) {
            QLog.d("DonDisturbProcessor", 2, "onUpdate don disturb" + jVar);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public j parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (!TextUtils.isEmpty(str)) {
            j a16 = j.a(str);
            if (QLog.isColorLevel()) {
                QLog.d("DonDisturbProcessor", 2, "onParsed don disturb" + str);
            }
            return a16;
        }
        return new j();
    }
}
