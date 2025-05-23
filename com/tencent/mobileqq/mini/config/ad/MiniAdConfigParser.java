package com.tencent.mobileqq.mini.config.ad;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes33.dex */
public class MiniAdConfigParser extends BaseConfigParser<MiniAdConfigBean> {
    public static final String GROUP_ID = "100226";
    private static final String TAG = "MiniAdConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniAdConfigBean defaultConfig() {
        return new MiniAdConfigBean();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniAdConfigBean parse(byte[] bArr) {
        MiniAdConfigBean miniAdConfigBean = new MiniAdConfigBean();
        if (bArr == null) {
            return miniAdConfigBean;
        }
        MiniAdConfigBean parse = MiniAdConfigBean.parse(new String(bArr, StandardCharsets.UTF_8));
        QLog.d(TAG, 1, "configs parse\uff1a" + parse);
        return parse;
    }
}
