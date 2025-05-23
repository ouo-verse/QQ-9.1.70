package com.tencent.ecommerce.biz.util;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000f\u001a\u00020\bR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/util/m;", "", "", "a", "", "fSize", "e", "(Ljava/lang/Integer;)Lcom/tencent/ecommerce/biz/util/m;", "", "fColor", "c", "lineCount", "f", "styleStr", "d", "b", "Ljava/lang/StringBuilder;", "Ljava/lang/StringBuilder;", "styleStringBuilder", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final StringBuilder styleStringBuilder = new StringBuilder();

    private final void a() {
        this.styleStringBuilder.append(";");
    }

    public final String b() {
        return this.styleStringBuilder.toString();
    }

    public final m c(String fColor) {
        if (fColor != null) {
            StringBuilder sb5 = this.styleStringBuilder;
            sb5.append("color:");
            sb5.append(fColor);
            a();
        }
        return this;
    }

    public final m d(String styleStr) {
        if (styleStr != null) {
            this.styleStringBuilder.append(styleStr);
            a();
        }
        return this;
    }

    public final m e(Integer fSize) {
        if (fSize != null) {
            fSize.intValue();
            StringBuilder sb5 = this.styleStringBuilder;
            sb5.append("font-size:");
            sb5.append(fSize.intValue());
            sb5.append("px");
            a();
        }
        return this;
    }

    public final m f(Integer lineCount) {
        if (lineCount != null) {
            lineCount.intValue();
            StringBuilder sb5 = this.styleStringBuilder;
            sb5.append("-webkit-box-orient:vertical;-webkit-line-clamp:");
            sb5.append(lineCount.intValue());
            a();
        }
        return this;
    }
}
