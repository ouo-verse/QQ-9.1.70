package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.config.business.BroadcastConfProcessor;

/* loaded from: classes10.dex */
public class BroadcastConfParser extends BaseConfigParser<BroadcastConfProcessor.a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BroadcastConfProcessor.a defaultConfig() {
        return new BroadcastConfProcessor.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BroadcastConfProcessor.a parse(@NonNull byte[] bArr) {
        return BroadcastConfProcessor.a.a(new String(bArr));
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        return false;
    }
}
