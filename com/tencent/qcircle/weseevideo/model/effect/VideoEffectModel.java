package com.tencent.qcircle.weseevideo.model.effect;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qcircle.tavcut.bean.TextItem;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 u2\u00020\u0001:\u0002uvB\u00f7\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u00a2\u0006\u0002\u0010\u001fJ\u0006\u0010W\u001a\u00020\u0000J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010_\u001a\u00020\u0003H\u00c6\u0003J\t\u0010`\u001a\u00020\u0003H\u00c6\u0003J\t\u0010a\u001a\u00020\u0011H\u00c6\u0003J\t\u0010b\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010d\u001a\u00020\u000bH\u00c6\u0003J\t\u0010e\u001a\u00020\u000bH\u00c6\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010h\u001a\u00020\bH\u00c6\u0003J\t\u0010i\u001a\u00020\bH\u00c6\u0003J\t\u0010j\u001a\u00020\u000bH\u00c6\u0003J\t\u0010k\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00fb\u0001\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u00c6\u0001J\u0013\u0010o\u001a\u00020\u000b2\b\u0010p\u001a\u0004\u0018\u00010qH\u00d6\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u0010r\u001a\u00020\u000bJ\t\u0010s\u001a\u00020\u0003H\u00d6\u0001J\t\u0010t\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u0010'R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010!\"\u0004\b9\u0010#R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\u0011\u0010<\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b=\u0010-R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010@\"\u0004\bA\u0010BR\u001a\u0010\u001a\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010@\"\u0004\bC\u0010BR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010@\"\u0004\bD\u0010BR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\u001a\u0010\u0018\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010)\"\u0004\bN\u0010+R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010-\"\u0004\bP\u0010/R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010%\"\u0004\bR\u0010'R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010!\"\u0004\bT\u0010#R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010%\"\u0004\bV\u0010'\u00a8\u0006w"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/VideoEffectModel;", "Ljava/io/Serializable;", AIAbilityModel.AI_KEY, "", "filePath", "", "stickerId", "startTime", "", "duration", "isUserEdit", "", "source", "effectId", "effectName", "effectBgColor", WadlProxyConsts.CREATE_TIME, "", "landscapePath", "animationMode", "verticalPath", "categoryId", "timeLineIndex", "effectSubType", "startOffset", "endOffset", "isRelative", "isLoadName", "pagTextItems", "", "Lcom/tencent/qcircle/tavcut/bean/TextItem;", "(ILjava/lang/String;Ljava/lang/String;FFZILjava/lang/String;Ljava/lang/String;IJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;IIJJZZLjava/util/List;)V", "getAnimationMode", "()I", "setAnimationMode", "(I)V", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getDuration", "()F", "setDuration", "(F)V", "getEffectBgColor", "setEffectBgColor", "getEffectId", "setEffectId", "getEffectName", "setEffectName", "getEffectSubType", "setEffectSubType", "getEffectType", "setEffectType", "getEndOffset", "setEndOffset", "endTime", "getEndTime", "getFilePath", "setFilePath", "()Z", "setLoadName", "(Z)V", "setRelative", "setUserEdit", "getLandscapePath", "setLandscapePath", "getPagTextItems", "()Ljava/util/List;", "setPagTextItems", "(Ljava/util/List;)V", "getSource", "setSource", "getStartOffset", "setStartOffset", "getStartTime", "setStartTime", "getStickerId", "setStickerId", "getTimeLineIndex", "setTimeLineIndex", "getVerticalPath", "setVerticalPath", "clone", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "isVertical", "hashCode", "toString", "Companion", "EffectType", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class VideoEffectModel implements Serializable {
    private static final String LANDSCAPE_SUFFIX = "_landscape";
    private static final String PAG_SUFFIX = ".pag";
    public static final int STATUS_UN_POSITION = -1;
    public static final int TYPE_BEGIN = 1;
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_END = 2;
    private int animationMode;

    @Nullable
    private String categoryId;
    private long createTime;
    private float duration;
    private int effectBgColor;

    @Nullable
    private String effectId;

    @Nullable
    private String effectName;
    private int effectSubType;
    private int effectType;
    private long endOffset;

    @Nullable
    private String filePath;
    private boolean isLoadName;
    private boolean isRelative;
    private boolean isUserEdit;

    @Nullable
    private String landscapePath;

    @Nullable
    private List<TextItem> pagTextItems;
    private int source;
    private long startOffset;
    private float startTime;

    @Nullable
    private String stickerId;
    private int timeLineIndex;

    @Nullable
    private String verticalPath;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/VideoEffectModel$EffectType;", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes22.dex */
    public @interface EffectType {
    }

    public VideoEffectModel() {
        this(0, null, null, 0.0f, 0.0f, false, 0, null, null, 0, 0L, null, 0, null, null, 0, 0, 0L, 0L, false, false, null, 4194303, null);
    }

    public static /* synthetic */ VideoEffectModel copy$default(VideoEffectModel videoEffectModel, int i3, String str, String str2, float f16, float f17, boolean z16, int i16, String str3, String str4, int i17, long j3, String str5, int i18, String str6, String str7, int i19, int i26, long j16, long j17, boolean z17, boolean z18, List list, int i27, Object obj) {
        return videoEffectModel.copy((i27 & 1) != 0 ? videoEffectModel.effectType : i3, (i27 & 2) != 0 ? videoEffectModel.filePath : str, (i27 & 4) != 0 ? videoEffectModel.stickerId : str2, (i27 & 8) != 0 ? videoEffectModel.startTime : f16, (i27 & 16) != 0 ? videoEffectModel.duration : f17, (i27 & 32) != 0 ? videoEffectModel.isUserEdit : z16, (i27 & 64) != 0 ? videoEffectModel.source : i16, (i27 & 128) != 0 ? videoEffectModel.effectId : str3, (i27 & 256) != 0 ? videoEffectModel.effectName : str4, (i27 & 512) != 0 ? videoEffectModel.effectBgColor : i17, (i27 & 1024) != 0 ? videoEffectModel.createTime : j3, (i27 & 2048) != 0 ? videoEffectModel.landscapePath : str5, (i27 & 4096) != 0 ? videoEffectModel.animationMode : i18, (i27 & 8192) != 0 ? videoEffectModel.verticalPath : str6, (i27 & 16384) != 0 ? videoEffectModel.categoryId : str7, (i27 & 32768) != 0 ? videoEffectModel.timeLineIndex : i19, (i27 & 65536) != 0 ? videoEffectModel.effectSubType : i26, (i27 & 131072) != 0 ? videoEffectModel.startOffset : j16, (i27 & 262144) != 0 ? videoEffectModel.endOffset : j17, (i27 & 524288) != 0 ? videoEffectModel.isRelative : z17, (1048576 & i27) != 0 ? videoEffectModel.isLoadName : z18, (i27 & 2097152) != 0 ? videoEffectModel.pagTextItems : list);
    }

    @NotNull
    public final VideoEffectModel clone() {
        return copy$default(this, 0, null, null, 0.0f, 0.0f, false, 0, null, null, 0, 0L, null, 0, null, null, 0, 0, 0L, 0L, false, false, null, 4194303, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getEffectType() {
        return this.effectType;
    }

    /* renamed from: component10, reason: from getter */
    public final int getEffectBgColor() {
        return this.effectBgColor;
    }

    /* renamed from: component11, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getLandscapePath() {
        return this.landscapePath;
    }

    /* renamed from: component13, reason: from getter */
    public final int getAnimationMode() {
        return this.animationMode;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getVerticalPath() {
        return this.verticalPath;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: component16, reason: from getter */
    public final int getTimeLineIndex() {
        return this.timeLineIndex;
    }

    /* renamed from: component17, reason: from getter */
    public final int getEffectSubType() {
        return this.effectSubType;
    }

    /* renamed from: component18, reason: from getter */
    public final long getStartOffset() {
        return this.startOffset;
    }

    /* renamed from: component19, reason: from getter */
    public final long getEndOffset() {
        return this.endOffset;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getIsRelative() {
        return this.isRelative;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getIsLoadName() {
        return this.isLoadName;
    }

    @Nullable
    public final List<TextItem> component22() {
        return this.pagTextItems;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getStickerId() {
        return this.stickerId;
    }

    /* renamed from: component4, reason: from getter */
    public final float getStartTime() {
        return this.startTime;
    }

    /* renamed from: component5, reason: from getter */
    public final float getDuration() {
        return this.duration;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsUserEdit() {
        return this.isUserEdit;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getEffectId() {
        return this.effectId;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getEffectName() {
        return this.effectName;
    }

    @NotNull
    public final VideoEffectModel copy(int r28, @Nullable String filePath, @Nullable String stickerId, float startTime, float duration, boolean isUserEdit, int source, @Nullable String effectId, @Nullable String effectName, int effectBgColor, long r38, @Nullable String landscapePath, int animationMode, @Nullable String verticalPath, @Nullable String categoryId, int timeLineIndex, int effectSubType, long startOffset, long endOffset, boolean isRelative, boolean isLoadName, @Nullable List<TextItem> pagTextItems) {
        return new VideoEffectModel(r28, filePath, stickerId, startTime, duration, isUserEdit, source, effectId, effectName, effectBgColor, r38, landscapePath, animationMode, verticalPath, categoryId, timeLineIndex, effectSubType, startOffset, endOffset, isRelative, isLoadName, pagTextItems);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VideoEffectModel) {
                VideoEffectModel videoEffectModel = (VideoEffectModel) other;
                if (this.effectType != videoEffectModel.effectType || !Intrinsics.areEqual(this.filePath, videoEffectModel.filePath) || !Intrinsics.areEqual(this.stickerId, videoEffectModel.stickerId) || Float.compare(this.startTime, videoEffectModel.startTime) != 0 || Float.compare(this.duration, videoEffectModel.duration) != 0 || this.isUserEdit != videoEffectModel.isUserEdit || this.source != videoEffectModel.source || !Intrinsics.areEqual(this.effectId, videoEffectModel.effectId) || !Intrinsics.areEqual(this.effectName, videoEffectModel.effectName) || this.effectBgColor != videoEffectModel.effectBgColor || this.createTime != videoEffectModel.createTime || !Intrinsics.areEqual(this.landscapePath, videoEffectModel.landscapePath) || this.animationMode != videoEffectModel.animationMode || !Intrinsics.areEqual(this.verticalPath, videoEffectModel.verticalPath) || !Intrinsics.areEqual(this.categoryId, videoEffectModel.categoryId) || this.timeLineIndex != videoEffectModel.timeLineIndex || this.effectSubType != videoEffectModel.effectSubType || this.startOffset != videoEffectModel.startOffset || this.endOffset != videoEffectModel.endOffset || this.isRelative != videoEffectModel.isRelative || this.isLoadName != videoEffectModel.isLoadName || !Intrinsics.areEqual(this.pagTextItems, videoEffectModel.pagTextItems)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getAnimationMode() {
        return this.animationMode;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final float getDuration() {
        return this.duration;
    }

    public final int getEffectBgColor() {
        return this.effectBgColor;
    }

    @Nullable
    public final String getEffectId() {
        return this.effectId;
    }

    @Nullable
    public final String getEffectName() {
        return this.effectName;
    }

    public final int getEffectSubType() {
        return this.effectSubType;
    }

    public final int getEffectType() {
        return this.effectType;
    }

    public final long getEndOffset() {
        return this.endOffset;
    }

    public final float getEndTime() {
        return this.startTime + this.duration;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final String getLandscapePath() {
        return this.landscapePath;
    }

    @Nullable
    public final List<TextItem> getPagTextItems() {
        return this.pagTextItems;
    }

    public final int getSource() {
        return this.source;
    }

    public final long getStartOffset() {
        return this.startOffset;
    }

    public final float getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final String getStickerId() {
        return this.stickerId;
    }

    public final int getTimeLineIndex() {
        return this.timeLineIndex;
    }

    @Nullable
    public final String getVerticalPath() {
        return this.verticalPath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28 = this.effectType * 31;
        String str = this.filePath;
        int i29 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i36 = (i28 + i3) * 31;
        String str2 = this.stickerId;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int floatToIntBits = (((((i36 + i16) * 31) + Float.floatToIntBits(this.startTime)) * 31) + Float.floatToIntBits(this.duration)) * 31;
        boolean z16 = this.isUserEdit;
        int i37 = 1;
        int i38 = z16;
        if (z16 != 0) {
            i38 = 1;
        }
        int i39 = (((floatToIntBits + i38) * 31) + this.source) * 31;
        String str3 = this.effectId;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i46 = (i39 + i17) * 31;
        String str4 = this.effectName;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i47 = (((i46 + i18) * 31) + this.effectBgColor) * 31;
        long j3 = this.createTime;
        int i48 = (i47 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str5 = this.landscapePath;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i49 = (((i48 + i19) * 31) + this.animationMode) * 31;
        String str6 = this.verticalPath;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i56 = (i49 + i26) * 31;
        String str7 = this.categoryId;
        if (str7 != null) {
            i27 = str7.hashCode();
        } else {
            i27 = 0;
        }
        int i57 = (((((i56 + i27) * 31) + this.timeLineIndex) * 31) + this.effectSubType) * 31;
        long j16 = this.startOffset;
        int i58 = (i57 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.endOffset;
        int i59 = (i58 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        boolean z17 = this.isRelative;
        int i65 = z17;
        if (z17 != 0) {
            i65 = 1;
        }
        int i66 = (i59 + i65) * 31;
        boolean z18 = this.isLoadName;
        if (!z18) {
            i37 = z18 ? 1 : 0;
        }
        int i67 = (i66 + i37) * 31;
        List<TextItem> list = this.pagTextItems;
        if (list != null) {
            i29 = list.hashCode();
        }
        return i67 + i29;
    }

    public final boolean isLoadName() {
        return this.isLoadName;
    }

    public final boolean isRelative() {
        return this.isRelative;
    }

    public final boolean isUserEdit() {
        return this.isUserEdit;
    }

    public final void setAnimationMode(int i3) {
        this.animationMode = i3;
    }

    public final void setCategoryId(@Nullable String str) {
        this.categoryId = str;
    }

    public final void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public final void setDuration(float f16) {
        this.duration = f16;
    }

    public final void setEffectBgColor(int i3) {
        this.effectBgColor = i3;
    }

    public final void setEffectId(@Nullable String str) {
        this.effectId = str;
    }

    public final void setEffectName(@Nullable String str) {
        this.effectName = str;
    }

    public final void setEffectSubType(int i3) {
        this.effectSubType = i3;
    }

    public final void setEffectType(int i3) {
        this.effectType = i3;
    }

    public final void setEndOffset(long j3) {
        this.endOffset = j3;
    }

    public final void setFilePath(@Nullable String str) {
        this.filePath = str;
    }

    public final void setLandscapePath(@Nullable String str) {
        this.landscapePath = str;
    }

    public final void setLoadName(boolean z16) {
        this.isLoadName = z16;
    }

    public final void setPagTextItems(@Nullable List<TextItem> list) {
        this.pagTextItems = list;
    }

    public final void setRelative(boolean z16) {
        this.isRelative = z16;
    }

    public final void setSource(int i3) {
        this.source = i3;
    }

    public final void setStartOffset(long j3) {
        this.startOffset = j3;
    }

    public final void setStartTime(float f16) {
        this.startTime = f16;
    }

    public final void setStickerId(@Nullable String str) {
        this.stickerId = str;
    }

    public final void setTimeLineIndex(int i3) {
        this.timeLineIndex = i3;
    }

    public final void setUserEdit(boolean z16) {
        this.isUserEdit = z16;
    }

    public final void setVerticalPath(@Nullable String str) {
        this.verticalPath = str;
    }

    @NotNull
    public String toString() {
        return "VideoEffectModel(effectType=" + this.effectType + ", filePath=" + this.filePath + ", stickerId=" + this.stickerId + ", startTime=" + this.startTime + ", duration=" + this.duration + ", isUserEdit=" + this.isUserEdit + ", source=" + this.source + ", effectId=" + this.effectId + ", effectName=" + this.effectName + ", effectBgColor=" + this.effectBgColor + ", createTime=" + this.createTime + ", landscapePath=" + this.landscapePath + ", animationMode=" + this.animationMode + ", verticalPath=" + this.verticalPath + ", categoryId=" + this.categoryId + ", timeLineIndex=" + this.timeLineIndex + ", effectSubType=" + this.effectSubType + ", startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", isRelative=" + this.isRelative + ", isLoadName=" + this.isLoadName + ", pagTextItems=" + this.pagTextItems + ")";
    }

    public VideoEffectModel(int i3, @Nullable String str, @Nullable String str2, float f16, float f17, boolean z16, int i16, @Nullable String str3, @Nullable String str4, int i17, long j3, @Nullable String str5, int i18, @Nullable String str6, @Nullable String str7, int i19, int i26, long j16, long j17, boolean z17, boolean z18, @Nullable List<TextItem> list) {
        this.effectType = i3;
        this.filePath = str;
        this.stickerId = str2;
        this.startTime = f16;
        this.duration = f17;
        this.isUserEdit = z16;
        this.source = i16;
        this.effectId = str3;
        this.effectName = str4;
        this.effectBgColor = i17;
        this.createTime = j3;
        this.landscapePath = str5;
        this.animationMode = i18;
        this.verticalPath = str6;
        this.categoryId = str7;
        this.timeLineIndex = i19;
        this.effectSubType = i26;
        this.startOffset = j16;
        this.endOffset = j17;
        this.isRelative = z17;
        this.isLoadName = z18;
        this.pagTextItems = list;
    }

    @Nullable
    public final String getFilePath(boolean isVertical) {
        boolean endsWith$default;
        if (TextUtils.isEmpty(this.verticalPath) && TextUtils.isEmpty(this.landscapePath)) {
            String str = this.filePath;
            this.verticalPath = str;
            this.landscapePath = str;
            if (!TextUtils.isEmpty(str)) {
                String str2 = this.verticalPath;
                if (str2 == null) {
                    Intrinsics.throwNpe();
                }
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, PAG_SUFFIX, false, 2, null);
                if (endsWith$default) {
                    StringBuilder sb5 = new StringBuilder();
                    String str3 = this.verticalPath;
                    if (str3 == null) {
                        Intrinsics.throwNpe();
                    }
                    String str4 = this.verticalPath;
                    if (str4 == null) {
                        Intrinsics.throwNpe();
                    }
                    int length = str4.length() - 4;
                    if (str3 != null) {
                        String substring = str3.substring(0, length);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        sb5.append(substring);
                        sb5.append(LANDSCAPE_SUFFIX);
                        sb5.append(PAG_SUFFIX);
                        String sb6 = sb5.toString();
                        this.landscapePath = sb6;
                        if (!FileUtils.exists(sb6)) {
                            this.landscapePath = this.verticalPath;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
        }
        if (isVertical) {
            return this.verticalPath;
        }
        return this.landscapePath;
    }

    public /* synthetic */ VideoEffectModel(int i3, String str, String str2, float f16, float f17, boolean z16, int i16, String str3, String str4, int i17, long j3, String str5, int i18, String str6, String str7, int i19, int i26, long j16, long j17, boolean z17, boolean z18, List list, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? VideoEffectType.TYPE_SPECIAL_EFFECT.value : i3, (i27 & 2) != 0 ? null : str, (i27 & 4) != 0 ? "" : str2, (i27 & 8) != 0 ? 0.0f : f16, (i27 & 16) == 0 ? f17 : 0.0f, (i27 & 32) != 0 ? false : z16, (i27 & 64) != 0 ? 0 : i16, (i27 & 128) != 0 ? null : str3, (i27 & 256) != 0 ? null : str4, (i27 & 512) != 0 ? 0 : i17, (i27 & 1024) != 0 ? 0L : j3, (i27 & 2048) != 0 ? null : str5, (i27 & 4096) != 0 ? 0 : i18, (i27 & 8192) != 0 ? null : str6, (i27 & 16384) != 0 ? null : str7, (32768 & i27) != 0 ? -1 : i19, (i27 & 65536) != 0 ? 0 : i26, (i27 & 131072) != 0 ? 0L : j16, (i27 & 262144) != 0 ? 0L : j17, (i27 & 524288) != 0 ? false : z17, (i27 & 1048576) != 0 ? false : z18, (i27 & 2097152) != 0 ? null : list);
    }
}
