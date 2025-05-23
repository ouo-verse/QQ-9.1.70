package com.tencent.filament.zplan.animation;

import androidx.annotation.Keep;
import com.tencent.ark.ark;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.light.LightConstants;

@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/animation/GYZPlanAnimation;", "", "()V", "blackSlotState", "", "getBlackSlotState", "()I", "setBlackSlotState", "(I)V", "moodDuration", "", "getMoodDuration", "()J", "setMoodDuration", "(J)V", "moodPath", "", "getMoodPath", "()Ljava/lang/String;", "setMoodPath", "(Ljava/lang/String;)V", "moodType", "getMoodType", "setMoodType", "setMoodTypeReady", "getSetMoodTypeReady", "setSetMoodTypeReady", "fromJSON", "", ark.ARKMETADATA_JSON, "Lorg/json/JSONObject;", "toJSON", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GYZPlanAnimation {
    private int blackSlotState;
    private long moodDuration;

    @NotNull
    private String moodPath = "";
    private int moodType;
    private int setMoodTypeReady;

    public final void fromJSON(@NotNull JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        String optString = json.optString(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODPATH);
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"lightAss\u2026tMoodTypeReady.moodPath\")");
        this.moodPath = optString;
        this.moodType = json.optInt(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODTYPE);
        this.moodDuration = json.optLong(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODDURATION);
        this.blackSlotState = json.optInt(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_BLACKSLOTSTATE);
        this.setMoodTypeReady = json.optInt(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY);
    }

    public final int getBlackSlotState() {
        return this.blackSlotState;
    }

    public final long getMoodDuration() {
        return this.moodDuration;
    }

    @NotNull
    public final String getMoodPath() {
        return this.moodPath;
    }

    public final int getMoodType() {
        return this.moodType;
    }

    public final int getSetMoodTypeReady() {
        return this.setMoodTypeReady;
    }

    public final void setBlackSlotState(int i3) {
        this.blackSlotState = i3;
    }

    public final void setMoodDuration(long j3) {
        this.moodDuration = j3;
    }

    public final void setMoodPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.moodPath = str;
    }

    public final void setMoodType(int i3) {
        this.moodType = i3;
    }

    public final void setSetMoodTypeReady(int i3) {
        this.setMoodTypeReady = i3;
    }

    @NativeMethodProxy(enabled = false)
    @NotNull
    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("moodPath", this.moodPath);
        jSONObject.put("moodType", this.moodType);
        jSONObject.put("moodDuration", this.moodDuration);
        return jSONObject;
    }
}
