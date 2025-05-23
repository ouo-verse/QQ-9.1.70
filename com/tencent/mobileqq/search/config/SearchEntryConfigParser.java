package com.tencent.mobileqq.search.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ap2.d;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.NetworkResult;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes18.dex */
public class SearchEntryConfigParser extends BaseConfigParser<d> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d defaultConfig() {
        return new d();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable d dVar) {
        super.doOnConfigUpdate(dVar);
        QLog.i("SearchEntryConfigParser", 1, "SearchEntryConfig, searchEntryConfig=" + dVar);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d parse(@NonNull byte[] bArr) {
        d dVar = new d();
        try {
            if (bArr.length > 0) {
                String str = new String(bArr, StandardCharsets.UTF_8);
                dVar = d.d(str);
                QLog.i("SearchEntryConfigParser", 1, "parse, configString=" + str + ", config=" + dVar + ", config.hash=" + dVar.hashCode());
            } else {
                QLog.i("SearchEntryConfigParser", 1, "parse, configString is empty");
            }
        } catch (Exception e16) {
            QLog.e("SearchEntryConfigParser", 1, "parse, Exception=" + e16);
        }
        QLog.i("SearchEntryConfigParser", 1, "parse, defaultConfig=" + dVar + ", config.hash=" + dVar.hashCode());
        return dVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean z16) {
        super.onCdnDownload(z16);
        QLog.i("SearchEntryConfigParser", 1, "SearchEntryConfig, onCdnDownload");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean z16) {
        super.onReceive(z16);
        QLog.i("SearchEntryConfigParser", 1, "onReceive, boolean=" + z16);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(@NonNull NetworkResult networkResult) {
        super.onReceiveNotUpdate(networkResult);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        super.onRemoved();
        QLog.i("SearchEntryConfigParser", 1, "SearchEntryConfig, onRemoved");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NonNull String str) {
        super.onSend(str);
        QLog.i("SearchEntryConfigParser", 1, "onSend, string=" + str);
    }
}
