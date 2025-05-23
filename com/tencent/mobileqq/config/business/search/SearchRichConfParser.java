package com.tencent.mobileqq.config.business.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.search.rich.n;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import sa1.b;

/* loaded from: classes10.dex */
public class SearchRichConfParser extends BaseConfigParser<b> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable b bVar) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("#doOnConfigUpdate ");
            if (bVar != null) {
                str = bVar.toString();
            } else {
                str = " empty";
            }
            sb5.append(str);
            QLog.d("SearchRichConfParser", 2, sb5.toString());
        }
        n.g().i();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        if (bArr.length > 0) {
            return b.g(new String(bArr, StandardCharsets.UTF_8));
        }
        return new b();
    }
}
