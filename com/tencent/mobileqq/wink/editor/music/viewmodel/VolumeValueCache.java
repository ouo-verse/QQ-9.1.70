package com.tencent.mobileqq.wink.editor.music.viewmodel;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.render.extension.MediaClipUseType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \u00182\u00020\u0001:\u0002 6B\u0007\u00a2\u0006\u0004\b4\u00105J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u001a\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rJ\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rJ\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000fJ\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001cJ\u001a\u0010\u001f\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001cR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010'R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010'R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010'R\u0018\u0010/\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010.R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010!R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/VolumeValueCache;", "", "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "", "i", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/VolumeValueCache$MusicStatus;", "c", "", "enableBgm", "isUseTemplate", DomainData.DOMAIN_NAME, "", "", "", "mediaClipVolumes", "p", "g", "openOri", "d", tl.h.F, "enable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "f", "newValue", "o", "Lkotlin/Pair;", "b", "pair", "l", "a", "Z", "j", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "isChangedManually", "Ljava/util/Map;", "originDefaultVolumesHasBgm", "originDefaultVolumesNoBgm", "originDefaultVolumesInTemplate", "e", "OriginDefaultOpenVolumeWithTemplate", "lastMediaClipVolumes", "Ljava/lang/Float;", "lastBgmVolume", "lastHasBgmOriginCheckBoxEnable", "lastNoBGMOriginCheckBoxEnable", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/VolumeValueCache$MusicStatus;", "currentMusicStatus", "<init>", "()V", "MusicStatus", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class VolumeValueCache {

    /* renamed from: k, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l */
    private static boolean f321195l;

    /* renamed from: a, reason: from kotlin metadata */
    private boolean isChangedManually;

    /* renamed from: g, reason: from kotlin metadata */
    @Nullable
    private Float lastBgmVolume;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Float> originDefaultVolumesHasBgm = new LinkedHashMap();

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Float> originDefaultVolumesNoBgm = new LinkedHashMap();

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Float> originDefaultVolumesInTemplate = new LinkedHashMap();

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Float> OriginDefaultOpenVolumeWithTemplate = new LinkedHashMap();

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private Map<Integer, Float> lastMediaClipVolumes = new LinkedHashMap();

    /* renamed from: h */
    private boolean lastHasBgmOriginCheckBoxEnable = true;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean lastNoBGMOriginCheckBoxEnable = true;

    /* renamed from: j, reason: from kotlin metadata */
    @NotNull
    private MusicStatus currentMusicStatus = MusicStatus.NONE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/VolumeValueCache$MusicStatus;", "", "(Ljava/lang/String;I)V", "NONE", "HasBGM", "HasTemplateBGM", "NoBGM", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum MusicStatus {
        NONE,
        HasBGM,
        HasTemplateBGM,
        NoBGM
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/VolumeValueCache$a;", "", "", "a", "b", "e", "d", "c", "", "ALL_CLIP_INDEX", "I", "MUSIC_DEFAULT_VOLUME_HAS_BGM", UserInfo.SEX_FEMALE, "MUSIC_DEFAULT_VOLUME_IN_TEMPLATE", "ORIGIN_DEFAULT_VOLUME_HAS_BGM", "ORIGIN_DEFAULT_VOLUME_IN_TEMPLATE", "ORIGIN_DEFAULT_VOLUME_IN_TEMPLATE_HIT_EXP", "ORIGIN_DEFAULT_VOLUME_IN_TEMPLATE_HIT_EXP_OPEN_ORI", "ORIGIN_DEFAULT_VOLUME_NO_BGM", "", "isHitVolumeExp", "Z", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.viewmodel.VolumeValueCache$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            if (VolumeValueCache.f321195l) {
                return 0.3f;
            }
            return 1.0f;
        }

        public final float b() {
            return 1.0f;
        }

        public final float c() {
            if (VolumeValueCache.f321195l) {
                return 1.0f;
            }
            return 0.15f;
        }

        public final float d() {
            if (VolumeValueCache.f321195l) {
                return 0.0f;
            }
            return 0.15f;
        }

        public final float e() {
            if (VolumeValueCache.f321195l) {
                return 1.0f;
            }
            return 0.15f;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f321206a;

        static {
            int[] iArr = new int[MusicStatus.values().length];
            try {
                iArr[MusicStatus.HasBGM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicStatus.HasTemplateBGM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f321206a = iArr;
        }
    }

    public VolumeValueCache() {
        WinkContext e16 = WinkContext.INSTANCE.e();
        f321195l = e16 != null && e16.u("QCIRCLE");
    }

    public static /* synthetic */ Map e(VolumeValueCache volumeValueCache, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return volumeValueCache.d(z16);
    }

    @NotNull
    public final Pair<Boolean, Boolean> b() {
        return new Pair<>(Boolean.valueOf(this.lastHasBgmOriginCheckBoxEnable), Boolean.valueOf(this.lastNoBGMOriginCheckBoxEnable));
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MusicStatus getCurrentMusicStatus() {
        return this.currentMusicStatus;
    }

    @NotNull
    public final Map<Integer, Float> d(boolean openOri) {
        Map<Integer, Float> mutableMap;
        Map<Integer, Float> mutableMap2;
        Map<Integer, Float> mutableMap3;
        Map<Integer, Float> mutableMap4;
        int i3 = b.f321206a[this.currentMusicStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                Map<Integer, Float> map = this.originDefaultVolumesNoBgm;
                if (map.isEmpty()) {
                    map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(-1, Float.valueOf(1.0f)));
                }
                mutableMap4 = MapsKt__MapsKt.toMutableMap(map);
                return mutableMap4;
            }
            if (openOri) {
                Map<Integer, Float> map2 = this.OriginDefaultOpenVolumeWithTemplate;
                if (map2.isEmpty()) {
                    map2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(-1, Float.valueOf(INSTANCE.c())));
                }
                mutableMap3 = MapsKt__MapsKt.toMutableMap(map2);
                return mutableMap3;
            }
            Map<Integer, Float> map3 = this.originDefaultVolumesInTemplate;
            if (map3.isEmpty()) {
                map3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(-1, Float.valueOf(INSTANCE.d())));
            }
            mutableMap2 = MapsKt__MapsKt.toMutableMap(map3);
            return mutableMap2;
        }
        Map<Integer, Float> map4 = this.originDefaultVolumesHasBgm;
        if (map4.isEmpty()) {
            map4 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(-1, Float.valueOf(INSTANCE.e())));
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(map4);
        return mutableMap;
    }

    public final float f() {
        Float f16 = this.lastBgmVolume;
        if (f16 != null) {
            return f16.floatValue();
        }
        return INSTANCE.a();
    }

    @NotNull
    public final Map<Integer, Float> g() {
        Map<Integer, Float> mutableMap;
        if (this.isChangedManually) {
            mutableMap = MapsKt__MapsKt.toMutableMap(this.lastMediaClipVolumes);
            return mutableMap;
        }
        return e(this, false, 1, null);
    }

    public final boolean h() {
        if (k()) {
            return this.lastHasBgmOriginCheckBoxEnable;
        }
        return this.lastNoBGMOriginCheckBoxEnable;
    }

    public final void i(@NotNull List<? extends MediaClip> mediaClips) {
        float e16;
        float d16;
        float c16;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        this.originDefaultVolumesHasBgm.clear();
        this.originDefaultVolumesNoBgm.clear();
        this.originDefaultVolumesInTemplate.clear();
        this.OriginDefaultOpenVolumeWithTemplate.clear();
        int i3 = 0;
        for (Object obj : mediaClips) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaClip mediaClip = (MediaClip) obj;
            float f16 = 1.0f;
            if (com.tencent.videocut.render.extension.e.r(mediaClip) == MediaClipUseType.NORMAL) {
                Integer valueOf = Integer.valueOf(i3);
                Map<Integer, Float> map = this.originDefaultVolumesHasBgm;
                Companion companion = INSTANCE;
                map.put(valueOf, Float.valueOf(companion.e()));
                this.originDefaultVolumesNoBgm.put(Integer.valueOf(i3), Float.valueOf(1.0f));
                this.originDefaultVolumesInTemplate.put(Integer.valueOf(i3), Float.valueOf(companion.d()));
                this.OriginDefaultOpenVolumeWithTemplate.put(Integer.valueOf(i3), Float.valueOf(companion.c()));
            } else {
                Map<Integer, Float> map2 = this.originDefaultVolumesHasBgm;
                Integer valueOf2 = Integer.valueOf(i3);
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    e16 = resourceModel.volume;
                } else {
                    e16 = INSTANCE.e();
                }
                map2.put(valueOf2, Float.valueOf(e16));
                Map<Integer, Float> map3 = this.originDefaultVolumesNoBgm;
                Integer valueOf3 = Integer.valueOf(i3);
                ResourceModel resourceModel2 = mediaClip.resource;
                if (resourceModel2 != null) {
                    f16 = resourceModel2.volume;
                }
                map3.put(valueOf3, Float.valueOf(f16));
                Map<Integer, Float> map4 = this.originDefaultVolumesInTemplate;
                Integer valueOf4 = Integer.valueOf(i3);
                ResourceModel resourceModel3 = mediaClip.resource;
                if (resourceModel3 != null) {
                    d16 = resourceModel3.volume;
                } else {
                    d16 = INSTANCE.d();
                }
                map4.put(valueOf4, Float.valueOf(d16));
                Map<Integer, Float> map5 = this.OriginDefaultOpenVolumeWithTemplate;
                Integer valueOf5 = Integer.valueOf(i3);
                ResourceModel resourceModel4 = mediaClip.resource;
                if (resourceModel4 != null) {
                    c16 = resourceModel4.volume;
                } else {
                    c16 = INSTANCE.c();
                }
                map5.put(valueOf5, Float.valueOf(c16));
            }
            i3 = i16;
        }
        this.lastMediaClipVolumes = com.tencent.videocut.render.extension.e.g(mediaClips);
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsChangedManually() {
        return this.isChangedManually;
    }

    public final boolean k() {
        MusicStatus musicStatus = this.currentMusicStatus;
        if (musicStatus != MusicStatus.HasBGM && musicStatus != MusicStatus.HasTemplateBGM) {
            return false;
        }
        return true;
    }

    public final void l(@NotNull Pair<Boolean, Boolean> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        this.lastHasBgmOriginCheckBoxEnable = pair.getFirst().booleanValue();
        this.lastNoBGMOriginCheckBoxEnable = pair.getSecond().booleanValue();
    }

    public final void m(boolean z16) {
        this.isChangedManually = z16;
    }

    public final void n(boolean z16, boolean z17) {
        MusicStatus musicStatus;
        if (z16) {
            if (z17) {
                musicStatus = MusicStatus.HasTemplateBGM;
            } else {
                musicStatus = MusicStatus.HasBGM;
            }
        } else {
            musicStatus = MusicStatus.NoBGM;
        }
        this.currentMusicStatus = musicStatus;
    }

    public final void o(float newValue) {
        this.lastBgmVolume = Float.valueOf(newValue);
    }

    public final void p(@NotNull Map<Integer, Float> mediaClipVolumes) {
        Map<Integer, Float> mutableMap;
        Intrinsics.checkNotNullParameter(mediaClipVolumes, "mediaClipVolumes");
        mutableMap = MapsKt__MapsKt.toMutableMap(mediaClipVolumes);
        this.lastMediaClipVolumes = mutableMap;
    }

    public final void q(boolean z16) {
        if (k()) {
            this.lastHasBgmOriginCheckBoxEnable = z16;
        } else {
            this.lastNoBGMOriginCheckBoxEnable = z16;
        }
    }
}
