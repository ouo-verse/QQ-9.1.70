package com.tencent.mobileqq.webview.api.impl;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.webview.api.IJumpApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/webview/api/impl/JumpApiImpl;", "Lcom/tencent/mobileqq/webview/api/IJumpApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getTxcJumpParserClazz", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class JumpApiImpl implements IJumpApi {
    @Override // com.tencent.mobileqq.webview.api.IJumpApi
    public Class<? extends av> getTxcJumpParserClazz() {
        return i52.a.class;
    }
}
