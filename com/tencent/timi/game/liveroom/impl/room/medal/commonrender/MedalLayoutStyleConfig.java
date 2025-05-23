package com.tencent.timi.game.liveroom.impl.room.medal.commonrender;

import android.graphics.Color;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b1\b\u0086\b\u0018\u0000 92\u00020\u0001:\u0001\nBg\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\u0006\u0010-\u001a\u00020\t\u0012\u0006\u00100\u001a\u00020\t\u0012\u0006\u00102\u001a\u00020\u0007\u0012\u0006\u00104\u001a\u00020\u0004\u0012\u0006\u00106\u001a\u00020\t\u00a2\u0006\u0004\b7\u00108J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0015\u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u0011\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b,\u0010\u000fR\"\u00100\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\"\u00102\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b+\u0010!\"\u0004\b1\u0010#R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010&\u001a\u0004\b%\u0010'\"\u0004\b3\u0010)R\"\u00106\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b5\u0010\u000f\u00a8\u0006:"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "l", "()F", "setWidth", "(F)V", "width", "b", "e", "setHeight", "height", "c", "j", "setTextFontOffsetX", "textFontOffsetX", "d", "k", "setTextFontOffsetY", "textFontOffsetY", "setFirTextFontSize", "firTextFontSize", "f", "Z", "()Z", "setFirTextFontBold", "(Z)V", "firTextFontBold", "g", "I", "()I", "setFirTextColor", "(I)V", "firTextColor", h.F, "setFirTextCenterXOffset", "firTextCenterXOffset", "i", "setSecTextFontSize", "secTextFontSize", "setSecTextFontBold", "secTextFontBold", "setSecTextColor", "secTextColor", "setSecTextCenterXOffset", "secTextCenterXOffset", "<init>", "(FFFFFZIFFZIF)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.medal.commonrender.b, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class MedalLayoutStyleConfig {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float textFontOffsetX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float textFontOffsetY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private float firTextFontSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean firTextFontBold;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int firTextColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private float firTextCenterXOffset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private float secTextFontSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean secTextFontBold;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int secTextColor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private float secTextCenterXOffset;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/b$a;", "", "", "jsonStr", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/b;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.medal.commonrender.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MedalLayoutStyleConfig a(@NotNull String jsonStr) {
            boolean z16;
            float f16;
            float f17;
            boolean z17;
            int i3;
            int i16;
            float f18;
            boolean z18;
            int i17;
            float f19;
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(jsonStr);
                float b16 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("width"));
                float b17 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("height"));
                boolean z19 = true;
                if (0.0f == b16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (0.0f != b17) {
                        z19 = false;
                    }
                    if (!z19) {
                        if (jSONObject.has("text_font_offset_x")) {
                            f16 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("text_font_offset_x"));
                        } else {
                            f16 = 0.0f;
                        }
                        if (jSONObject.has("text_font_offset_y")) {
                            f17 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("text_font_offset_y"));
                        } else {
                            f17 = 0.0f;
                        }
                        float c16 = com.tencent.timi.game.utils.b.c(14);
                        if (jSONObject.has("firtext_font_size")) {
                            c16 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("firtext_font_size"));
                        }
                        float f26 = c16;
                        if (jSONObject.has("firtext_font_bold")) {
                            z17 = jSONObject.getBoolean("firtext_font_bold");
                        } else {
                            z17 = false;
                        }
                        try {
                            i3 = Color.parseColor(jSONObject.getString("firtext_color"));
                        } catch (Exception e16) {
                            AegisLogger.INSTANCE.i("unknown|MedalLayoutStyleConfig", "buildFromJson", "exception=" + e16);
                            i3 = 0;
                        }
                        if (jSONObject.has("firtext_centerX_offset")) {
                            f18 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("firtext_centerX_offset"));
                            i16 = 14;
                        } else {
                            i16 = 14;
                            f18 = 0.0f;
                        }
                        float c17 = com.tencent.timi.game.utils.b.c(i16);
                        if (jSONObject.has("sectext_font_size")) {
                            c17 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("sectext_font_size"));
                        }
                        float f27 = c17;
                        if (jSONObject.has("sectext_font_bold")) {
                            z18 = jSONObject.getBoolean("sectext_font_bold");
                        } else {
                            z18 = false;
                        }
                        try {
                            i17 = Color.parseColor(jSONObject.getString("sectext_color"));
                        } catch (Exception e17) {
                            AegisLogger.INSTANCE.i("unknown|MedalLayoutStyleConfig", "buildFromJson", "exception=" + e17);
                            i17 = 0;
                        }
                        if (jSONObject.has("sectext_centerX_offset")) {
                            f19 = com.tencent.timi.game.utils.b.b((float) jSONObject.getDouble("sectext_centerX_offset"));
                        } else {
                            f19 = 0.0f;
                        }
                        return new MedalLayoutStyleConfig(b16, b17, f16, f17, f26, z17, i3, f18, f27, z18, i17, f19);
                    }
                }
                return null;
            } catch (Exception e18) {
                AegisLogger.INSTANCE.i("unknown|MedalLayoutStyleConfig", "buildFromJson", "exception=" + e18);
                return null;
            }
        }

        Companion() {
        }
    }

    public MedalLayoutStyleConfig(float f16, float f17, float f18, float f19, float f26, boolean z16, int i3, float f27, float f28, boolean z17, int i16, float f29) {
        this.width = f16;
        this.height = f17;
        this.textFontOffsetX = f18;
        this.textFontOffsetY = f19;
        this.firTextFontSize = f26;
        this.firTextFontBold = z16;
        this.firTextColor = i3;
        this.firTextCenterXOffset = f27;
        this.secTextFontSize = f28;
        this.secTextFontBold = z17;
        this.secTextColor = i16;
        this.secTextCenterXOffset = f29;
    }

    /* renamed from: a, reason: from getter */
    public final float getFirTextCenterXOffset() {
        return this.firTextCenterXOffset;
    }

    /* renamed from: b, reason: from getter */
    public final int getFirTextColor() {
        return this.firTextColor;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getFirTextFontBold() {
        return this.firTextFontBold;
    }

    /* renamed from: d, reason: from getter */
    public final float getFirTextFontSize() {
        return this.firTextFontSize;
    }

    /* renamed from: e, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalLayoutStyleConfig)) {
            return false;
        }
        MedalLayoutStyleConfig medalLayoutStyleConfig = (MedalLayoutStyleConfig) other;
        if (Float.compare(this.width, medalLayoutStyleConfig.width) == 0 && Float.compare(this.height, medalLayoutStyleConfig.height) == 0 && Float.compare(this.textFontOffsetX, medalLayoutStyleConfig.textFontOffsetX) == 0 && Float.compare(this.textFontOffsetY, medalLayoutStyleConfig.textFontOffsetY) == 0 && Float.compare(this.firTextFontSize, medalLayoutStyleConfig.firTextFontSize) == 0 && this.firTextFontBold == medalLayoutStyleConfig.firTextFontBold && this.firTextColor == medalLayoutStyleConfig.firTextColor && Float.compare(this.firTextCenterXOffset, medalLayoutStyleConfig.firTextCenterXOffset) == 0 && Float.compare(this.secTextFontSize, medalLayoutStyleConfig.secTextFontSize) == 0 && this.secTextFontBold == medalLayoutStyleConfig.secTextFontBold && this.secTextColor == medalLayoutStyleConfig.secTextColor && Float.compare(this.secTextCenterXOffset, medalLayoutStyleConfig.secTextCenterXOffset) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final float getSecTextCenterXOffset() {
        return this.secTextCenterXOffset;
    }

    /* renamed from: g, reason: from getter */
    public final int getSecTextColor() {
        return this.secTextColor;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getSecTextFontBold() {
        return this.secTextFontBold;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.textFontOffsetX)) * 31) + Float.floatToIntBits(this.textFontOffsetY)) * 31) + Float.floatToIntBits(this.firTextFontSize)) * 31;
        boolean z16 = this.firTextFontBold;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int floatToIntBits2 = (((((((floatToIntBits + i16) * 31) + this.firTextColor) * 31) + Float.floatToIntBits(this.firTextCenterXOffset)) * 31) + Float.floatToIntBits(this.secTextFontSize)) * 31;
        boolean z17 = this.secTextFontBold;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((floatToIntBits2 + i3) * 31) + this.secTextColor) * 31) + Float.floatToIntBits(this.secTextCenterXOffset);
    }

    /* renamed from: i, reason: from getter */
    public final float getSecTextFontSize() {
        return this.secTextFontSize;
    }

    /* renamed from: j, reason: from getter */
    public final float getTextFontOffsetX() {
        return this.textFontOffsetX;
    }

    /* renamed from: k, reason: from getter */
    public final float getTextFontOffsetY() {
        return this.textFontOffsetY;
    }

    /* renamed from: l, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    @NotNull
    public String toString() {
        return "MedalLayoutStyleConfig(width=" + this.width + ", height=" + this.height + ", textFontOffsetX=" + this.textFontOffsetX + ", textFontOffsetY=" + this.textFontOffsetY + ", firTextFontSize=" + this.firTextFontSize + ", firTextFontBold=" + this.firTextFontBold + ", firTextColor=" + this.firTextColor + ", firTextCenterXOffset=" + this.firTextCenterXOffset + ", secTextFontSize=" + this.secTextFontSize + ", secTextFontBold=" + this.secTextFontBold + ", secTextColor=" + this.secTextColor + ", secTextCenterXOffset=" + this.secTextCenterXOffset + ")";
    }
}
