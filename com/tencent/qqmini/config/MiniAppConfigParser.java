package com.tencent.qqmini.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.mini.config.united.MiniConfigParser;
import com.tencent.qphone.base.util.QLog;
import cu3.a;

/* loaded from: classes34.dex */
public class MiniAppConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(byte[] bArr) {
        String str = new String(bArr);
        if (QLog.isColorLevel()) {
            QLog.d(MiniConfigParser.TAG, 1, "[onParsed] , content = " + str);
        }
        return a.a(str);
    }
}
