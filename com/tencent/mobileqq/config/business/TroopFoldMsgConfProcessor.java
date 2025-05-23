package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class TroopFoldMsgConfProcessor extends BaseConfigParser<bj> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bj defaultConfig() {
        return new bj();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable bj bjVar) {
        super.doOnConfigUpdate(bjVar);
        QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public bj parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            QLog.d("TroopFoldMsgConfProcessor", 1, "TroopFoldMsgBean parse null");
            return new bj();
        }
        QLog.d("TroopFoldMsgConfProcessor", 1, "parse " + str);
        return bj.a(str);
    }
}
