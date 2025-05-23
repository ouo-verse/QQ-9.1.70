package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.ark.ark;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001)B;\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003JP\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0010\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareRecordData;", "", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "getPlayData", "", "toJson", "", "component1", "component2", "component3", "component4", "component5", "()Ljava/lang/Integer;", "component6", "width", "height", "theme", "bodyType", "frameCount", QQBrowserActivity.APP_PARAM, "copy", "(IIIILjava/lang/Integer;Ljava/lang/String;)Lcom/tencent/filament/zplan/scene/square/SquareRecordData;", "toString", "hashCode", "other", "", "equals", "I", "getWidth", "()I", "getHeight", "getTheme", "getBodyType", "Ljava/lang/Integer;", "getFrameCount", "Ljava/lang/String;", "getExtraParams", "()Ljava/lang/String;", "<init>", "(IIIILjava/lang/Integer;Ljava/lang/String;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class SquareRecordData {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int bodyType;

    @Nullable
    private final String extraParams;

    @Nullable
    private final Integer frameCount;
    private final int height;
    private final int theme;
    private final int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareRecordData$a;", "", "", ark.ARKMETADATA_JSON, "Lcom/tencent/filament/zplan/scene/square/SquareRecordData;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.square.SquareRecordData$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final SquareRecordData a(@NotNull String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                return (SquareRecordData) new Gson().fromJson(json, SquareRecordData.class);
            } catch (Exception e16) {
                FLog.INSTANCE.e("SquareRecordData", "fromJson error: " + e16);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SquareRecordData(int i3, int i16, int i17, int i18, @Nullable Integer num, @Nullable String str) {
        this.width = i3;
        this.height = i16;
        this.theme = i17;
        this.bodyType = i18;
        this.frameCount = num;
        this.extraParams = str;
    }

    public static /* synthetic */ SquareRecordData copy$default(SquareRecordData squareRecordData, int i3, int i16, int i17, int i18, Integer num, String str, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = squareRecordData.width;
        }
        if ((i19 & 2) != 0) {
            i16 = squareRecordData.height;
        }
        int i26 = i16;
        if ((i19 & 4) != 0) {
            i17 = squareRecordData.theme;
        }
        int i27 = i17;
        if ((i19 & 8) != 0) {
            i18 = squareRecordData.bodyType;
        }
        int i28 = i18;
        if ((i19 & 16) != 0) {
            num = squareRecordData.frameCount;
        }
        Integer num2 = num;
        if ((i19 & 32) != 0) {
            str = squareRecordData.extraParams;
        }
        return squareRecordData.copy(i3, i26, i27, i28, num2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTheme() {
        return this.theme;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBodyType() {
        return this.bodyType;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getFrameCount() {
        return this.frameCount;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final SquareRecordData copy(int width, int height, int theme, int bodyType, @Nullable Integer frameCount, @Nullable String extraParams) {
        return new SquareRecordData(width, height, theme, bodyType, frameCount, extraParams);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareRecordData) {
                SquareRecordData squareRecordData = (SquareRecordData) other;
                if (this.width != squareRecordData.width || this.height != squareRecordData.height || this.theme != squareRecordData.theme || this.bodyType != squareRecordData.bodyType || !Intrinsics.areEqual(this.frameCount, squareRecordData.frameCount) || !Intrinsics.areEqual(this.extraParams, squareRecordData.extraParams)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getBodyType() {
        return this.bodyType;
    }

    @Nullable
    public final String getExtraParams() {
        return this.extraParams;
    }

    @Nullable
    public final Integer getFrameCount() {
        return this.frameCount;
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final SquareAvatarData getPlayData() {
        SquareAvatarData.Companion companion = SquareAvatarData.INSTANCE;
        String str = this.extraParams;
        if (str == null) {
            str = "";
        }
        return companion.a(str);
    }

    public final int getTheme() {
        return this.theme;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3;
        int i16 = ((((((this.width * 31) + this.height) * 31) + this.theme) * 31) + this.bodyType) * 31;
        Integer num = this.frameCount;
        int i17 = 0;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str = this.extraParams;
        if (str != null) {
            i17 = str.hashCode();
        }
        return i18 + i17;
    }

    @NotNull
    public final String toJson() {
        try {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        } catch (Exception e16) {
            FLog.INSTANCE.e("SquareRecordData", "toJson error: " + e16);
            return "";
        }
    }

    @NotNull
    public String toString() {
        return "SquareRecordData(width=" + this.width + ", height=" + this.height + ", theme=" + this.theme + ", bodyType=" + this.bodyType + ", frameCount=" + this.frameCount + ", extraParams=" + this.extraParams + ")";
    }
}
