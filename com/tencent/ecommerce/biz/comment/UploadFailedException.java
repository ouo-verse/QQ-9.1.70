package com.tencent.ecommerce.biz.comment;

import kotlin.Metadata;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/UploadFailedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "filePath", "", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class UploadFailedException extends RuntimeException {
    public final String filePath;

    public UploadFailedException(String str, String str2) {
        super("\u4efb\u52a1\u5931\u8d25: " + str + TokenParser.SP + str2);
        this.filePath = str;
    }
}
