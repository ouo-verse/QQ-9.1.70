package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/base/j;", "", "", "toString", "Lcom/tencent/kuikly/core/base/h;", "a", "Lcom/tencent/kuikly/core/base/h;", "color", "", "b", UserInfo.SEX_FEMALE, "stopIn01", "<init>", "(Lcom/tencent/kuikly/core/base/h;F)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final h color;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float stopIn01;

    public j(h color, float f16) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.stopIn01 = f16;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.color);
        sb5.append(TokenParser.SP);
        sb5.append(this.stopIn01);
        return sb5.toString();
    }
}
