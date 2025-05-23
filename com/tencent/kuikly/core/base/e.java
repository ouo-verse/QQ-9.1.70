package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/base/e;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "()F", "lineWidth", "Lcom/tencent/kuikly/core/base/BorderStyle;", "b", "Lcom/tencent/kuikly/core/base/BorderStyle;", "getLineStyle", "()Lcom/tencent/kuikly/core/base/BorderStyle;", "lineStyle", "Lcom/tencent/kuikly/core/base/h;", "c", "Lcom/tencent/kuikly/core/base/h;", "getColor", "()Lcom/tencent/kuikly/core/base/h;", "color", "<init>", "(FLcom/tencent/kuikly/core/base/BorderStyle;Lcom/tencent/kuikly/core/base/h;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float lineWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final BorderStyle lineStyle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final h color;

    public e(float f16, BorderStyle lineStyle, h color) {
        Intrinsics.checkNotNullParameter(lineStyle, "lineStyle");
        Intrinsics.checkNotNullParameter(color, "color");
        this.lineWidth = f16;
        this.lineStyle = lineStyle;
        this.color = color;
    }

    /* renamed from: a, reason: from getter */
    public final float getLineWidth() {
        return this.lineWidth;
    }

    public String toString() {
        return this.lineWidth + TokenParser.SP + this.lineStyle.getValue() + TokenParser.SP + this.color;
    }
}
