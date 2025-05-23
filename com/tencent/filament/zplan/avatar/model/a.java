package com.tencent.filament.zplan.avatar.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ.\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0004R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0017R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/a;", "", "Lorg/json/JSONObject;", "e", "", "slot", "Lcom/tencent/filament/zplan/avatar/model/Float4;", "color", "Lcom/tencent/filament/zplan/avatar/model/ColorType;", "type", "", "b", "fromColor", "toColor", "", "progress", "c", "d", "target", "a", "f", "", "Lcom/tencent/filament/zplan/avatar/model/Color;", "Ljava/util/Map;", "colorMap", "Lcom/tencent/filament/zplan/avatar/model/GradientColor;", "gradientColorMap", "D", "irisHueShift", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Color> colorMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, GradientColor> gradientColorMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private double irisHueShift;

    private final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Color> entry : this.colorMap.entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue().a());
        }
        jSONObject.put("slotColorMap", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        for (Map.Entry<String, GradientColor> entry2 : this.gradientColorMap.entrySet()) {
            jSONObject3.put(entry2.getKey(), entry2.getValue().a());
        }
        jSONObject.put("slotGradientColorMap", jSONObject3);
        jSONObject.put("irisHueShift", this.irisHueShift);
        return jSONObject;
    }

    public final void a(@NotNull JSONObject target) {
        Intrinsics.checkNotNullParameter(target, "target");
        target.put("colorInfo", e());
    }

    public final void b(@NotNull String slot, @NotNull Float4 color, @NotNull ColorType type) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(type, "type");
        this.colorMap.put(slot, new Color(color, type));
    }

    public final void c(@NotNull String slot, @NotNull Float4 fromColor, @NotNull Float4 toColor, double progress, @NotNull ColorType type) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(fromColor, "fromColor");
        Intrinsics.checkNotNullParameter(toColor, "toColor");
        Intrinsics.checkNotNullParameter(type, "type");
        this.gradientColorMap.put(slot, new GradientColor(progress, fromColor, toColor, type));
    }

    public final void d(double progress) {
        this.irisHueShift = progress;
    }

    @NotNull
    public final String f() {
        String jSONObject = e().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJson().toString()");
        return jSONObject;
    }
}
