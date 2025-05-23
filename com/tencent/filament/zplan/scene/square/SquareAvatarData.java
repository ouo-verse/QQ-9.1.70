package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.ark.ark;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0004+,-.B5\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "", "", "toJson", "", "hasGuest", "hasExtra", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;", "component1", "component2", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", "component3", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "component4", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "component5", "host", QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE, "extra", MiniAppConst.MENU_STYLE_LIGHT, "camera", "copy", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;", "getHost", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;", "getGuest", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", "getExtra", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLight", "()Lcom/tencent/filament/zplan/avatar/LightsParams;", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getCamera", "()Lcom/tencent/filament/zplan/avatar/CameraParams;", "<init>", "(Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;Lcom/tencent/filament/zplan/avatar/LightsParams;Lcom/tencent/filament/zplan/avatar/CameraParams;)V", "Companion", "AvatarAnim", "AvatarData", "a", "ExtraActorData", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class SquareAvatarData {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final CameraParams camera;

    @Nullable
    private final ExtraActorData extra;

    @Nullable
    private final AvatarData guest;

    @NotNull
    private final AvatarData host;

    @NotNull
    private final LightsParams light;

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "", "bodyAnimGltf", "", "headAnimGltf", "(Ljava/lang/String;Ljava/lang/String;)V", "getBodyAnimGltf", "()Ljava/lang/String;", "getHeadAnimGltf", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final /* data */ class AvatarAnim {

        @NotNull
        private final String bodyAnimGltf;

        @NotNull
        private final String headAnimGltf;

        public AvatarAnim(@NotNull String bodyAnimGltf, @NotNull String headAnimGltf) {
            Intrinsics.checkNotNullParameter(bodyAnimGltf, "bodyAnimGltf");
            Intrinsics.checkNotNullParameter(headAnimGltf, "headAnimGltf");
            this.bodyAnimGltf = bodyAnimGltf;
            this.headAnimGltf = headAnimGltf;
        }

        public static /* synthetic */ AvatarAnim copy$default(AvatarAnim avatarAnim, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = avatarAnim.bodyAnimGltf;
            }
            if ((i3 & 2) != 0) {
                str2 = avatarAnim.headAnimGltf;
            }
            return avatarAnim.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getBodyAnimGltf() {
            return this.bodyAnimGltf;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getHeadAnimGltf() {
            return this.headAnimGltf;
        }

        @NotNull
        public final AvatarAnim copy(@NotNull String bodyAnimGltf, @NotNull String headAnimGltf) {
            Intrinsics.checkNotNullParameter(bodyAnimGltf, "bodyAnimGltf");
            Intrinsics.checkNotNullParameter(headAnimGltf, "headAnimGltf");
            return new AvatarAnim(bodyAnimGltf, headAnimGltf);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof AvatarAnim) {
                    AvatarAnim avatarAnim = (AvatarAnim) other;
                    if (!Intrinsics.areEqual(this.bodyAnimGltf, avatarAnim.bodyAnimGltf) || !Intrinsics.areEqual(this.headAnimGltf, avatarAnim.headAnimGltf)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final String getBodyAnimGltf() {
            return this.bodyAnimGltf;
        }

        @NotNull
        public final String getHeadAnimGltf() {
            return this.headAnimGltf;
        }

        public int hashCode() {
            int i3;
            String str = this.bodyAnimGltf;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.headAnimGltf;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "AvatarAnim(bodyAnimGltf=" + this.bodyAnimGltf + ", headAnimGltf=" + this.headAnimGltf + ")";
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\tH\u00c6\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\tH\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarData;", "", "uin", "", "gender", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "anim", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "avatarInfoStr", "", "(JLcom/tencent/filament/zplan/avatar/model/EnumUserGender;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;Ljava/lang/String;)V", "getAnim", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "getAvatarInfoStr", "()Ljava/lang/String;", "setAvatarInfoStr", "(Ljava/lang/String;)V", "getGender", "()Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "getUin", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final /* data */ class AvatarData {

        @Nullable
        private final AvatarAnim anim;

        @NotNull
        private String avatarInfoStr;

        @NotNull
        private final EnumUserGender gender;
        private final long uin;

        public AvatarData(long j3, @NotNull EnumUserGender gender, @Nullable AvatarAnim avatarAnim, @NotNull String avatarInfoStr) {
            Intrinsics.checkNotNullParameter(gender, "gender");
            Intrinsics.checkNotNullParameter(avatarInfoStr, "avatarInfoStr");
            this.uin = j3;
            this.gender = gender;
            this.anim = avatarAnim;
            this.avatarInfoStr = avatarInfoStr;
        }

        public static /* synthetic */ AvatarData copy$default(AvatarData avatarData, long j3, EnumUserGender enumUserGender, AvatarAnim avatarAnim, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = avatarData.uin;
            }
            long j16 = j3;
            if ((i3 & 2) != 0) {
                enumUserGender = avatarData.gender;
            }
            EnumUserGender enumUserGender2 = enumUserGender;
            if ((i3 & 4) != 0) {
                avatarAnim = avatarData.anim;
            }
            AvatarAnim avatarAnim2 = avatarAnim;
            if ((i3 & 8) != 0) {
                str = avatarData.avatarInfoStr;
            }
            return avatarData.copy(j16, enumUserGender2, avatarAnim2, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUin() {
            return this.uin;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final EnumUserGender getGender() {
            return this.gender;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final AvatarAnim getAnim() {
            return this.anim;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getAvatarInfoStr() {
            return this.avatarInfoStr;
        }

        @NotNull
        public final AvatarData copy(long uin, @NotNull EnumUserGender gender, @Nullable AvatarAnim anim, @NotNull String avatarInfoStr) {
            Intrinsics.checkNotNullParameter(gender, "gender");
            Intrinsics.checkNotNullParameter(avatarInfoStr, "avatarInfoStr");
            return new AvatarData(uin, gender, anim, avatarInfoStr);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof AvatarData) {
                    AvatarData avatarData = (AvatarData) other;
                    if (this.uin != avatarData.uin || !Intrinsics.areEqual(this.gender, avatarData.gender) || !Intrinsics.areEqual(this.anim, avatarData.anim) || !Intrinsics.areEqual(this.avatarInfoStr, avatarData.avatarInfoStr)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @Nullable
        public final AvatarAnim getAnim() {
            return this.anim;
        }

        @NotNull
        public final String getAvatarInfoStr() {
            return this.avatarInfoStr;
        }

        @NotNull
        public final EnumUserGender getGender() {
            return this.gender;
        }

        public final long getUin() {
            return this.uin;
        }

        public int hashCode() {
            int i3;
            int i16;
            long j3 = this.uin;
            int i17 = ((int) (j3 ^ (j3 >>> 32))) * 31;
            EnumUserGender enumUserGender = this.gender;
            int i18 = 0;
            if (enumUserGender != null) {
                i3 = enumUserGender.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (i17 + i3) * 31;
            AvatarAnim avatarAnim = this.anim;
            if (avatarAnim != null) {
                i16 = avatarAnim.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 31;
            String str = this.avatarInfoStr;
            if (str != null) {
                i18 = str.hashCode();
            }
            return i26 + i18;
        }

        public final void setAvatarInfoStr(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatarInfoStr = str;
        }

        @NotNull
        public String toString() {
            return "AvatarData(uin=" + this.uin + ", gender=" + this.gender + ", anim=" + this.anim + ", avatarInfoStr=" + this.avatarInfoStr + ")";
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", "", "meshGltf", "", "animGltf", "transform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnimGltf", "()Ljava/lang/String;", "getMeshGltf", "getTransform", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final /* data */ class ExtraActorData {

        @NotNull
        private final String animGltf;

        @NotNull
        private final String meshGltf;

        @Nullable
        private final String transform;

        public ExtraActorData(@NotNull String meshGltf, @NotNull String animGltf, @Nullable String str) {
            Intrinsics.checkNotNullParameter(meshGltf, "meshGltf");
            Intrinsics.checkNotNullParameter(animGltf, "animGltf");
            this.meshGltf = meshGltf;
            this.animGltf = animGltf;
            this.transform = str;
        }

        public static /* synthetic */ ExtraActorData copy$default(ExtraActorData extraActorData, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = extraActorData.meshGltf;
            }
            if ((i3 & 2) != 0) {
                str2 = extraActorData.animGltf;
            }
            if ((i3 & 4) != 0) {
                str3 = extraActorData.transform;
            }
            return extraActorData.copy(str, str2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getMeshGltf() {
            return this.meshGltf;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getAnimGltf() {
            return this.animGltf;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getTransform() {
            return this.transform;
        }

        @NotNull
        public final ExtraActorData copy(@NotNull String meshGltf, @NotNull String animGltf, @Nullable String transform) {
            Intrinsics.checkNotNullParameter(meshGltf, "meshGltf");
            Intrinsics.checkNotNullParameter(animGltf, "animGltf");
            return new ExtraActorData(meshGltf, animGltf, transform);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof ExtraActorData) {
                    ExtraActorData extraActorData = (ExtraActorData) other;
                    if (!Intrinsics.areEqual(this.meshGltf, extraActorData.meshGltf) || !Intrinsics.areEqual(this.animGltf, extraActorData.animGltf) || !Intrinsics.areEqual(this.transform, extraActorData.transform)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final String getAnimGltf() {
            return this.animGltf;
        }

        @NotNull
        public final String getMeshGltf() {
            return this.meshGltf;
        }

        @Nullable
        public final String getTransform() {
            return this.transform;
        }

        public int hashCode() {
            int i3;
            int i16;
            String str = this.meshGltf;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = i3 * 31;
            String str2 = this.animGltf;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            String str3 = this.transform;
            if (str3 != null) {
                i17 = str3.hashCode();
            }
            return i19 + i17;
        }

        @NotNull
        public String toString() {
            return "ExtraActorData(meshGltf=" + this.meshGltf + ", animGltf=" + this.animGltf + ", transform=" + this.transform + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$a;", "", "", ark.ARKMETADATA_JSON, "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.square.SquareAvatarData$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final SquareAvatarData a(@NotNull String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                return (SquareAvatarData) new Gson().fromJson(json, SquareAvatarData.class);
            } catch (Exception e16) {
                FLog.INSTANCE.e("SquareAvatarData", "fromJson error: " + e16);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SquareAvatarData(@NotNull AvatarData host, @Nullable AvatarData avatarData, @Nullable ExtraActorData extraActorData, @NotNull LightsParams light, @Nullable CameraParams cameraParams) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(light, "light");
        this.host = host;
        this.guest = avatarData;
        this.extra = extraActorData;
        this.light = light;
        this.camera = cameraParams;
    }

    public static /* synthetic */ SquareAvatarData copy$default(SquareAvatarData squareAvatarData, AvatarData avatarData, AvatarData avatarData2, ExtraActorData extraActorData, LightsParams lightsParams, CameraParams cameraParams, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            avatarData = squareAvatarData.host;
        }
        if ((i3 & 2) != 0) {
            avatarData2 = squareAvatarData.guest;
        }
        AvatarData avatarData3 = avatarData2;
        if ((i3 & 4) != 0) {
            extraActorData = squareAvatarData.extra;
        }
        ExtraActorData extraActorData2 = extraActorData;
        if ((i3 & 8) != 0) {
            lightsParams = squareAvatarData.light;
        }
        LightsParams lightsParams2 = lightsParams;
        if ((i3 & 16) != 0) {
            cameraParams = squareAvatarData.camera;
        }
        return squareAvatarData.copy(avatarData, avatarData3, extraActorData2, lightsParams2, cameraParams);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final AvatarData getHost() {
        return this.host;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final AvatarData getGuest() {
        return this.guest;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final ExtraActorData getExtra() {
        return this.extra;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final LightsParams getLight() {
        return this.light;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final CameraParams getCamera() {
        return this.camera;
    }

    @NotNull
    public final SquareAvatarData copy(@NotNull AvatarData host, @Nullable AvatarData guest, @Nullable ExtraActorData extra, @NotNull LightsParams light, @Nullable CameraParams camera2) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(light, "light");
        return new SquareAvatarData(host, guest, extra, light, camera2);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareAvatarData) {
                SquareAvatarData squareAvatarData = (SquareAvatarData) other;
                if (!Intrinsics.areEqual(this.host, squareAvatarData.host) || !Intrinsics.areEqual(this.guest, squareAvatarData.guest) || !Intrinsics.areEqual(this.extra, squareAvatarData.extra) || !Intrinsics.areEqual(this.light, squareAvatarData.light) || !Intrinsics.areEqual(this.camera, squareAvatarData.camera)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final CameraParams getCamera() {
        return this.camera;
    }

    @Nullable
    public final ExtraActorData getExtra() {
        return this.extra;
    }

    @Nullable
    public final AvatarData getGuest() {
        return this.guest;
    }

    @NotNull
    public final AvatarData getHost() {
        return this.host;
    }

    @NotNull
    public final LightsParams getLight() {
        return this.light;
    }

    public final boolean hasExtra() {
        if (this.extra != null) {
            return true;
        }
        return false;
    }

    public final boolean hasGuest() {
        if (this.guest != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        AvatarData avatarData = this.host;
        int i19 = 0;
        if (avatarData != null) {
            i3 = avatarData.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        AvatarData avatarData2 = this.guest;
        if (avatarData2 != null) {
            i16 = avatarData2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        ExtraActorData extraActorData = this.extra;
        if (extraActorData != null) {
            i17 = extraActorData.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        LightsParams lightsParams = this.light;
        if (lightsParams != null) {
            i18 = lightsParams.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        CameraParams cameraParams = this.camera;
        if (cameraParams != null) {
            i19 = cameraParams.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    public final String toJson() {
        try {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        } catch (Exception e16) {
            FLog.INSTANCE.e("SquareAvatarData", "toJson error: " + e16);
            return "";
        }
    }

    @NotNull
    public String toString() {
        return "SquareAvatarData(host=" + this.host + ", guest=" + this.guest + ", extra=" + this.extra + ", light=" + this.light + ", camera=" + this.camera + ")";
    }
}
