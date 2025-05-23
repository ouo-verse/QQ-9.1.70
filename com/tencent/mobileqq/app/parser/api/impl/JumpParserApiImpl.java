package com.tencent.mobileqq.app.parser.api.impl;

import com.tencent.mobileqq.app.parser.api.IJumpParserApi;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.app.parser.cq;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/parser/api/impl/JumpParserApiImpl;", "Lcom/tencent/mobileqq/app/parser/api/IJumpParserApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getQZonePushParser", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class JumpParserApiImpl implements IJumpParserApi {
    @Override // com.tencent.mobileqq.app.parser.api.IJumpParserApi
    public Class<? extends av> getQZonePushParser() {
        return cq.class;
    }
}
