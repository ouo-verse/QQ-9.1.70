package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/base/g;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "offsetX", "b", "offsetY", "c", NodeProps.SHADOW_RADIUS, "Lcom/tencent/kuikly/core/base/h;", "d", "Lcom/tencent/kuikly/core/base/h;", NodeProps.SHADOW_COLOR, "<init>", "(FFFLcom/tencent/kuikly/core/base/h;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float offsetX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float offsetY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float shadowRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final h shadowColor;

    public g(float f16, float f17, float f18, h shadowColor) {
        Intrinsics.checkNotNullParameter(shadowColor, "shadowColor");
        this.offsetX = f16;
        this.offsetY = f17;
        this.shadowRadius = f18;
        this.shadowColor = shadowColor;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.offsetX);
        sb5.append(TokenParser.SP);
        sb5.append(this.offsetY);
        sb5.append(TokenParser.SP);
        sb5.append(this.shadowRadius);
        sb5.append(TokenParser.SP);
        sb5.append(this.shadowColor);
        return sb5.toString();
    }
}
