package com.tencent.mobileqq.wink.editor.aielimination.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qshadow.ShadowAIGCStatus$ButtonInfo;
import qshadow.ShadowAIGCStatus$PayInfo;
import qshadow.ShadowAIGCStatus$UsageInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\u0005\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;", "", "", "", "Lqshadow/ShadowAIGCStatus$UsageInfo;", "a", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "usageInfoMap", "Lqshadow/ShadowAIGCStatus$PayInfo;", "Lqshadow/ShadowAIGCStatus$PayInfo;", "()Lqshadow/ShadowAIGCStatus$PayInfo;", "payInfo", "Lqshadow/ShadowAIGCStatus$ButtonInfo;", "c", "Lqshadow/ShadowAIGCStatus$ButtonInfo;", "getButtonInfo", "()Lqshadow/ShadowAIGCStatus$ButtonInfo;", "buttonInfo", "<init>", "(Ljava/util/Map;Lqshadow/ShadowAIGCStatus$PayInfo;Lqshadow/ShadowAIGCStatus$ButtonInfo;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, ShadowAIGCStatus$UsageInfo> usageInfoMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShadowAIGCStatus$PayInfo payInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShadowAIGCStatus$ButtonInfo buttonInfo;

    public c(@NotNull Map<Integer, ShadowAIGCStatus$UsageInfo> usageInfoMap, @NotNull ShadowAIGCStatus$PayInfo payInfo, @NotNull ShadowAIGCStatus$ButtonInfo buttonInfo) {
        Intrinsics.checkNotNullParameter(usageInfoMap, "usageInfoMap");
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        this.usageInfoMap = usageInfoMap;
        this.payInfo = payInfo;
        this.buttonInfo = buttonInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ShadowAIGCStatus$PayInfo getPayInfo() {
        return this.payInfo;
    }

    @NotNull
    public final Map<Integer, ShadowAIGCStatus$UsageInfo> b() {
        return this.usageInfoMap;
    }
}
