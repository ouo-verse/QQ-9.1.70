package com.tencent.mobileqq.kandian.biz.config.api.impl;

import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfProcessor;
import kotlin.Metadata;
import y52.a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/config/api/impl/ReadInJoySearchJumpUrlConfProcessorImpl;", "Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoySearchJumpUrlConfProcessor;", "Ly52/a;", "getConfig", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/config/l;", "getProcessClazz", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInJoySearchJumpUrlConfProcessorImpl implements IReadInJoySearchJumpUrlConfProcessor {
    @Override // com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor
    public a getConfig() {
        return ReadInjoySearchJumpurlConfProcessor.a();
    }

    @Override // com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor
    public Class<? extends l<?>> getProcessClazz() {
        return ReadInjoySearchJumpurlConfProcessor.class;
    }
}
