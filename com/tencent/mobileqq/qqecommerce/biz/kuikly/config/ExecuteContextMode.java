package com.tencent.mobileqq.qqecommerce.biz.kuikly.config;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/ExecuteContextMode;", "", "", "value", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "JVM", "JS", "SO", "DEX", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public enum ExecuteContextMode {
    JVM(0),
    JS(1),
    SO(2),
    DEX(3);

    public final int value;

    ExecuteContextMode(int i3) {
        this.value = i3;
    }
}
