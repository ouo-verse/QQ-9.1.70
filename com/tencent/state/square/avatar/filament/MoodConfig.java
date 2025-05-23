package com.tencent.state.square.avatar.filament;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.FovProjection;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.zplan.common.utils.d;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 N2\u00020\u0001:\u0001NBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\t\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0013H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\r\u0010(\u001a\u00060\u0006j\u0002`\u0007H\u00c6\u0003J\r\u0010)\u001a\u00060\u0006j\u0002`\tH\u00c6\u0003J\t\u0010*\u001a\u00020\u000bH\u00c6\u0003J\t\u0010+\u001a\u00020\rH\u00c6\u0003J\t\u0010,\u001a\u00020\u000fH\u00c6\u0003J\u0011\u0010-\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\tH\u00c6\u0003J\t\u0010.\u001a\u00020\u000bH\u00c6\u0003J}\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\f\b\u0002\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010\b\u001a\u00060\u0006j\u0002`\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\t2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001J\u0013\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\b\u00102\u001a\u00020\u0000H\u0002J \u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020@H\u0002J\u0018\u0010B\u001a\u0004\u0018\u00010C2\u0006\u00109\u001a\u00020:2\u0006\u00105\u001a\u000206J\u0006\u0010D\u001a\u00020EJ\u001a\u0010F\u001a\u0004\u0018\u00010\u000b2\u000e\u0010G\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\tH\u0002J\u0006\u0010H\u001a\u00020\u0013J\t\u0010I\u001a\u00020JH\u00d6\u0001J\u0010\u0010K\u001a\u00020\u00132\b\u0010L\u001a\u0004\u0018\u00010\u000bJ\t\u0010M\u001a\u00020\u000bH\u00d6\u0001R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00060\u0006j\u0002`\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00060\u0006j\u0002`\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0010\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001d\u00a8\u0006O"}, d2 = {"Lcom/tencent/state/square/avatar/filament/MoodConfig;", "", "fCameraFOV", "", "mCameraFOV", "cameraLocation", "Lcom/tencent/state/square/avatar/filament/Vector3;", "Lcom/tencent/state/square/avatar/filament/Location;", "cameraRotation", "Lcom/tencent/state/square/avatar/filament/Rotation;", "zShowNickName", "", "animations", "Lcom/tencent/state/square/avatar/filament/Animations;", "actors", "Lcom/tencent/state/square/avatar/filament/Actors;", "extraActorRotation", QzoneZipCacheHelper.DIR, "fromCache", "", "(FFLcom/tencent/state/square/avatar/filament/Vector3;Lcom/tencent/state/square/avatar/filament/Vector3;Ljava/lang/String;Lcom/tencent/state/square/avatar/filament/Animations;Lcom/tencent/state/square/avatar/filament/Actors;Lcom/tencent/state/square/avatar/filament/Vector3;Ljava/lang/String;Z)V", "getActors", "()Lcom/tencent/state/square/avatar/filament/Actors;", "getAnimations", "()Lcom/tencent/state/square/avatar/filament/Animations;", "getCameraLocation", "()Lcom/tencent/state/square/avatar/filament/Vector3;", "getCameraRotation", "getDir", "()Ljava/lang/String;", "getExtraActorRotation", "getFCameraFOV", "()F", "getFromCache", "()Z", "getMCameraFOV", "getZShowNickName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "fullPath", "getAvatarAnim", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "gender", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "avatarType", "Lcom/tencent/state/square/avatar/filament/AvatarType;", "animType", "Lcom/tencent/state/square/avatar/filament/AnimType;", "getCameraInfo", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getCameraLookAt", "Lcom/tencent/filament/zplan/avatar/LookAt;", "transform", "Lcom/tencent/state/square/avatar/filament/Mat44F;", "getCameraTransform", "getExtraActorData", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", "getLightInfo", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getTransformInfo", BasicAnimation.KeyPath.ROTATION, "hasGuest", "hashCode", "", "isCurrentSelect", "url", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MoodConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("actors")
    private final Actors actors;

    @SerializedName("Animations")
    private final Animations animations;

    @SerializedName("CameraLocation")
    private final Vector3 cameraLocation;

    @SerializedName("CameraRotation")
    private final Vector3 cameraRotation;
    private final String dir;

    @SerializedName("ExtraActorRotation")
    private final Vector3 extraActorRotation;

    @SerializedName("FCameraFOV")
    private final float fCameraFOV;
    private final boolean fromCache;

    @SerializedName("MCameraFOV")
    private final float mCameraFOV;

    @SerializedName("ZShowNickName")
    private final String zShowNickName;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/avatar/filament/MoodConfig$Companion;", "", "()V", "fromJson", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "moodJson", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final MoodConfig fromJson(String moodJson) {
            Intrinsics.checkNotNullParameter(moodJson, "moodJson");
            return ((MoodConfig) new Gson().fromJson(moodJson, MoodConfig.class)).fullPath();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[AnimType.values().length];
            $EnumSwitchMapping$0 = iArr;
            AnimType animType = AnimType.IDLE;
            iArr[animType.ordinal()] = 1;
            AnimType animType2 = AnimType.CLICK;
            iArr[animType2.ordinal()] = 2;
            int[] iArr2 = new int[AvatarType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AvatarType.HOST.ordinal()] = 1;
            iArr2[AvatarType.GUEST.ordinal()] = 2;
            int[] iArr3 = new int[AnimType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[animType.ordinal()] = 1;
            iArr3[animType2.ordinal()] = 2;
        }
    }

    public MoodConfig(float f16, float f17, Vector3 cameraLocation, Vector3 cameraRotation, String zShowNickName, Animations animations, Actors actors, Vector3 vector3, String dir, boolean z16) {
        Intrinsics.checkNotNullParameter(cameraLocation, "cameraLocation");
        Intrinsics.checkNotNullParameter(cameraRotation, "cameraRotation");
        Intrinsics.checkNotNullParameter(zShowNickName, "zShowNickName");
        Intrinsics.checkNotNullParameter(animations, "animations");
        Intrinsics.checkNotNullParameter(actors, "actors");
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.fCameraFOV = f16;
        this.mCameraFOV = f17;
        this.cameraLocation = cameraLocation;
        this.cameraRotation = cameraRotation;
        this.zShowNickName = zShowNickName;
        this.animations = animations;
        this.actors = actors;
        this.extraActorRotation = vector3;
        this.dir = dir;
        this.fromCache = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MoodConfig fullPath() {
        this.animations.setFullPath(this.dir);
        this.actors.setFullPath(this.dir);
        return this;
    }

    private final LookAt getCameraLookAt(Mat44F transform) {
        new Vec3F(transform.getM00(), transform.getM01(), transform.getM02());
        Vec3F vec3F = new Vec3F(transform.getM10(), transform.getM11(), transform.getM12());
        Vec3F vec3F2 = new Vec3F(-transform.getM20(), -transform.getM21(), -transform.getM22());
        Vec3F vec3F3 = new Vec3F(transform.getM30(), transform.getM31(), transform.getM32());
        return new LookAt(vec3F3.toFloatArray(), vec3F3.plus(vec3F2).toFloatArray(), vec3F.toFloatArray());
    }

    private final Mat44F getCameraTransform() {
        float x16 = this.cameraLocation.getX();
        float y16 = this.cameraLocation.getY();
        float z16 = this.cameraLocation.getZ();
        return MathKt.convertUE4MatToLightSDK(MathKt.composeMatrix(new Vec3F(0.0f, 0.0f, 0.0f), MathKt.eulerZYXToQuaternion(MathKt.toRadius(-90.0f), MathKt.toRadius(0.0f), MathKt.toRadius(0.0f)), new Vec3F(1.0f, 1.0f, 1.0f))).inverse().times(MathKt.convertUE4MatToLightSDK(MathKt.composeMatrix(new Vec3F(x16, y16, z16), MathKt.eulerZYXToQuaternion(MathKt.toRadius(this.cameraRotation.getZ()), -MathKt.toRadius(this.cameraRotation.getY()), MathKt.toRadius(this.cameraRotation.getX())), new Vec3F(1.0f, 1.0f, 1.0f))));
    }

    /* renamed from: component1, reason: from getter */
    public final float getFCameraFOV() {
        return this.fCameraFOV;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getFromCache() {
        return this.fromCache;
    }

    /* renamed from: component2, reason: from getter */
    public final float getMCameraFOV() {
        return this.mCameraFOV;
    }

    /* renamed from: component3, reason: from getter */
    public final Vector3 getCameraLocation() {
        return this.cameraLocation;
    }

    /* renamed from: component4, reason: from getter */
    public final Vector3 getCameraRotation() {
        return this.cameraRotation;
    }

    /* renamed from: component5, reason: from getter */
    public final String getZShowNickName() {
        return this.zShowNickName;
    }

    /* renamed from: component6, reason: from getter */
    public final Animations getAnimations() {
        return this.animations;
    }

    /* renamed from: component7, reason: from getter */
    public final Actors getActors() {
        return this.actors;
    }

    /* renamed from: component8, reason: from getter */
    public final Vector3 getExtraActorRotation() {
        return this.extraActorRotation;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDir() {
        return this.dir;
    }

    public final MoodConfig copy(float fCameraFOV, float mCameraFOV, Vector3 cameraLocation, Vector3 cameraRotation, String zShowNickName, Animations animations, Actors actors, Vector3 extraActorRotation, String dir, boolean fromCache) {
        Intrinsics.checkNotNullParameter(cameraLocation, "cameraLocation");
        Intrinsics.checkNotNullParameter(cameraRotation, "cameraRotation");
        Intrinsics.checkNotNullParameter(zShowNickName, "zShowNickName");
        Intrinsics.checkNotNullParameter(animations, "animations");
        Intrinsics.checkNotNullParameter(actors, "actors");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return new MoodConfig(fCameraFOV, mCameraFOV, cameraLocation, cameraRotation, zShowNickName, animations, actors, extraActorRotation, dir, fromCache);
    }

    public final Actors getActors() {
        return this.actors;
    }

    public final Animations getAnimations() {
        return this.animations;
    }

    public final SquareAvatarData.AvatarAnim getAvatarAnim(EnumUserGender gender, AvatarType avatarType, AnimType animType) {
        List<Animation> idle;
        Object lastOrNull;
        Animation animation;
        String fBodyAnimtionPath;
        String fHeadAnimtionPath;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(avatarType, "avatarType");
        Intrinsics.checkNotNullParameter(animType, "animType");
        boolean z16 = gender == EnumUserGender.GENDER_MALE;
        int i3 = WhenMappings.$EnumSwitchMapping$0[animType.ordinal()];
        if (i3 == 1) {
            idle = this.animations.getIdle();
        } else if (i3 == 2) {
            idle = this.animations.getClick();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (idle != null) {
            int i16 = WhenMappings.$EnumSwitchMapping$1[avatarType.ordinal()];
            if (i16 == 1) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) idle);
                animation = (Animation) lastOrNull;
            } else if (i16 == 2) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) idle);
                animation = (Animation) firstOrNull;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (animation != null) {
                if (z16) {
                    fBodyAnimtionPath = animation.getMBodyAnimtionPath();
                } else {
                    fBodyAnimtionPath = animation.getFBodyAnimtionPath();
                }
                if (z16) {
                    fHeadAnimtionPath = animation.getMHeadAnimtionPath();
                } else {
                    fHeadAnimtionPath = animation.getFHeadAnimtionPath();
                }
                return new SquareAvatarData.AvatarAnim(fBodyAnimtionPath, fHeadAnimtionPath);
            }
        }
        return null;
    }

    public final CameraParams getCameraInfo() {
        float convertFovFromVerticalToHorizontal = MathKt.convertFovFromVerticalToHorizontal(this.mCameraFOV, 1.0f, 1.0f);
        return new CameraParams(new Exposure(16, 100.0d, 0.008d), getCameraLookAt(getCameraTransform()), null, new FovProjection(convertFovFromVerticalToHorizontal, 1.0f, 1000.0f, 0.05f, "horizontal"), null, 20, null);
    }

    public final Vector3 getCameraLocation() {
        return this.cameraLocation;
    }

    public final Vector3 getCameraRotation() {
        return this.cameraRotation;
    }

    public final String getDir() {
        return this.dir;
    }

    public final SquareAvatarData.ExtraActorData getExtraActorData(AnimType animType, EnumUserGender gender) {
        List<Actor> idle;
        Object orNull;
        Intrinsics.checkNotNullParameter(animType, "animType");
        Intrinsics.checkNotNullParameter(gender, "gender");
        int i3 = WhenMappings.$EnumSwitchMapping$2[animType.ordinal()];
        if (i3 == 1) {
            idle = this.actors.getIdle();
        } else if (i3 == 2) {
            idle = this.actors.getClick();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        boolean z16 = gender == EnumUserGender.GENDER_MALE;
        if (idle != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(idle, 0);
            Actor actor = (Actor) orNull;
            if (actor != null) {
                return new SquareAvatarData.ExtraActorData(actor.getMeshPath(z16), actor.getAnimationPath(z16), getTransformInfo(this.extraActorRotation));
            }
        }
        return null;
    }

    public final Vector3 getExtraActorRotation() {
        return this.extraActorRotation;
    }

    public final float getFCameraFOV() {
        return this.fCameraFOV;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final LightsParams getLightInfo() {
        List mutableListOf;
        Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
        directional.setColor(new float[]{1.0f, 0.94f, 0.99f});
        directional.setIntensity(67000.0f);
        directional.setDirection(new float[]{0.5f, -0.246f, -0.856f});
        directional.setCastShadows(true);
        Unit unit = Unit.INSTANCE;
        IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
        indirectLight.setIntensity(5000.0f);
        SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight.setKey("spotLight1");
        spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
        spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
        spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
        spotLight.setIntensity(123380.0f);
        spotLight.setFalloff(10.0d);
        spotLight.setInnerCone(10);
        spotLight.setOuterCone(50);
        spotLight.setCastShadows(false);
        SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight2.setKey("spotLight2");
        spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
        spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
        spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
        spotLight2.setIntensity(48330.0f);
        spotLight2.setFalloff(30.0d);
        spotLight2.setInnerCone(10);
        spotLight2.setOuterCone(40);
        spotLight2.setCastShadows(false);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
        return new LightsParams(directional, indirectLight, mutableListOf);
    }

    public final float getMCameraFOV() {
        return this.mCameraFOV;
    }

    public final String getZShowNickName() {
        return this.zShowNickName;
    }

    public final boolean hasGuest() {
        return this.animations.getIdle().size() > 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.fCameraFOV) * 31) + Float.floatToIntBits(this.mCameraFOV)) * 31;
        Vector3 vector3 = this.cameraLocation;
        int hashCode = (floatToIntBits + (vector3 != null ? vector3.hashCode() : 0)) * 31;
        Vector3 vector32 = this.cameraRotation;
        int hashCode2 = (hashCode + (vector32 != null ? vector32.hashCode() : 0)) * 31;
        String str = this.zShowNickName;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Animations animations = this.animations;
        int hashCode4 = (hashCode3 + (animations != null ? animations.hashCode() : 0)) * 31;
        Actors actors = this.actors;
        int hashCode5 = (hashCode4 + (actors != null ? actors.hashCode() : 0)) * 31;
        Vector3 vector33 = this.extraActorRotation;
        int hashCode6 = (hashCode5 + (vector33 != null ? vector33.hashCode() : 0)) * 31;
        String str2 = this.dir;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.fromCache;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode7 + i3;
    }

    public String toString() {
        return "MoodConfig(fCameraFOV=" + this.fCameraFOV + ", mCameraFOV=" + this.mCameraFOV + ", cameraLocation=" + this.cameraLocation + ", cameraRotation=" + this.cameraRotation + ", zShowNickName=" + this.zShowNickName + ", animations=" + this.animations + ", actors=" + this.actors + ", extraActorRotation=" + this.extraActorRotation + ", dir=" + this.dir + ", fromCache=" + this.fromCache + ")";
    }

    public /* synthetic */ MoodConfig(float f16, float f17, Vector3 vector3, Vector3 vector32, String str, Animations animations, Actors actors, Vector3 vector33, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, vector3, vector32, str, animations, actors, vector33, str2, (i3 & 512) != 0 ? false : z16);
    }

    private final String getTransformInfo(Vector3 rotation) {
        if (rotation == null) {
            return null;
        }
        return new TransformData(new Vec3F(0.0f, 0.0f, 0.0f), MathKt.eulerZYXToQuaternion(MathKt.toRadius(rotation.getZ()), MathKt.toRadius(-rotation.getY()), MathKt.toRadius(rotation.getX())), new Vec3F(1.0f, 1.0f, 1.0f)).toJson();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoodConfig)) {
            return false;
        }
        MoodConfig moodConfig = (MoodConfig) other;
        return Float.compare(this.fCameraFOV, moodConfig.fCameraFOV) == 0 && Float.compare(this.mCameraFOV, moodConfig.mCameraFOV) == 0 && Intrinsics.areEqual(this.cameraLocation, moodConfig.cameraLocation) && Intrinsics.areEqual(this.cameraRotation, moodConfig.cameraRotation) && Intrinsics.areEqual(this.zShowNickName, moodConfig.zShowNickName) && Intrinsics.areEqual(this.animations, moodConfig.animations) && Intrinsics.areEqual(this.actors, moodConfig.actors) && Intrinsics.areEqual(this.extraActorRotation, moodConfig.extraActorRotation) && Intrinsics.areEqual(this.dir, moodConfig.dir) && this.fromCache == moodConfig.fromCache;
    }

    public final boolean isCurrentSelect(String url) {
        boolean contains$default;
        if (url == null) {
            return false;
        }
        String urlMd5 = d.c(url);
        String str = this.dir;
        Intrinsics.checkNotNullExpressionValue(urlMd5, "urlMd5");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) urlMd5, false, 2, (Object) null);
        return contains$default;
    }
}
