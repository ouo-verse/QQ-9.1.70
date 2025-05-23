package com.tencent.mobileqq.qqvideoedit.editor.draft;

import androidx.fragment.app.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.MusicVolumeControlViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b9\b\u0086\b\u0018\u0000 f2\u00020\u0001:\u0001gB\u00c7\u0001\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010#\u001a\u00020\u0010\u0012\u0006\u0010$\u001a\u00020\u0012\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0012\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0017\u0012\b\b\u0002\u0010)\u001a\u00020\u0017\u0012\b\b\u0002\u0010*\u001a\u00020\u001a\u00a2\u0006\u0004\bd\u0010eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u00c6\u0003J\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tH\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0012H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0017H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0017H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u001aH\u00c6\u0003J\u00d6\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00172\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001aH\u00c6\u0001\u00a2\u0006\u0004\b+\u0010,J\t\u0010-\u001a\u00020\u0002H\u00d6\u0001J\t\u0010.\u001a\u00020\u0004H\u00d6\u0001J\u0013\u00101\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010/H\u00d6\u0003R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u00104R$\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u00108R'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;R+\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b<\u0010;R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u00102\u001a\u0004\b=\u00104\"\u0004\b>\u0010?R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00105\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u00108R$\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010$\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010L\u001a\u0004\b$\u0010M\"\u0004\bN\u0010OR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u00102\u001a\u0004\bP\u00104\"\u0004\bQ\u0010?R\"\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010L\u001a\u0004\b&\u0010M\"\u0004\bR\u0010OR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010(\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010)\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010X\u001a\u0004\b]\u0010Z\"\u0004\b^\u0010\\R\"\u0010*\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditDataWrapper;", "Ljava/io/Serializable;", "", "component1", "", "component2", "()Ljava/lang/Integer;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditData;", "Lkotlin/collections/ArrayList;", "component3", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "component4", "component5", "component6", "component7", "", "component8", "", "component9", "component10", "component11", "component12", "", "component13", "component14", "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "component15", "missionId", "editMode", "editData", "originMediaInfos", "templateFilePath", "from", "outMediaInfo", "duration", "isFromCapture", "selectMusicMid", "isBackGroundChanged", "useHD", "originVolume", "bgmVolume", "bgmVolumeType", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;JZLjava/lang/String;ZIFFLcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;)Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditDataWrapper;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getMissionId", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getEditMode", "setEditMode", "(Ljava/lang/Integer;)V", "Ljava/util/ArrayList;", "getEditData", "()Ljava/util/ArrayList;", "getOriginMediaInfos", "getTemplateFilePath", "setTemplateFilePath", "(Ljava/lang/String;)V", "getFrom", "setFrom", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getOutMediaInfo", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "setOutMediaInfo", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "J", "getDuration", "()J", "setDuration", "(J)V", "Z", "()Z", "setFromCapture", "(Z)V", "getSelectMusicMid", "setSelectMusicMid", "setBackGroundChanged", "I", "getUseHD", "()I", "setUseHD", "(I)V", UserInfo.SEX_FEMALE, "getOriginVolume", "()F", "setOriginVolume", "(F)V", "getBgmVolume", "setBgmVolume", "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "getBgmVolumeType", "()Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "setBgmVolumeType", "(Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;)V", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;JZLjava/lang/String;ZIFFLcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;)V", "Companion", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class VideoEditDataWrapper implements Serializable {
    private static final long serialVersionUID = 599093938747237759L;
    private float bgmVolume;

    @NotNull
    private MusicVolumeControlViewModel.VolumeType bgmVolumeType;
    private long duration;

    @NotNull
    private final ArrayList<VideoEditData> editData;

    @Nullable
    private Integer editMode;

    @Nullable
    private Integer from;
    private boolean isBackGroundChanged;
    private boolean isFromCapture;

    @Nullable
    private final String missionId;

    @Nullable
    private final ArrayList<LocalMediaInfo> originMediaInfos;
    private float originVolume;

    @Nullable
    private LocalMediaInfo outMediaInfo;

    @Nullable
    private String selectMusicMid;

    @Nullable
    private String templateFilePath;
    private int useHD;

    public VideoEditDataWrapper(@Nullable String str, @Nullable Integer num, @NotNull ArrayList<VideoEditData> editData, @Nullable ArrayList<LocalMediaInfo> arrayList, @Nullable String str2, @Nullable Integer num2, @Nullable LocalMediaInfo localMediaInfo, long j3, boolean z16, @Nullable String str3, boolean z17, int i3, float f16, float f17, @NotNull MusicVolumeControlViewModel.VolumeType bgmVolumeType) {
        Intrinsics.checkNotNullParameter(editData, "editData");
        Intrinsics.checkNotNullParameter(bgmVolumeType, "bgmVolumeType");
        this.missionId = str;
        this.editMode = num;
        this.editData = editData;
        this.originMediaInfos = arrayList;
        this.templateFilePath = str2;
        this.from = num2;
        this.outMediaInfo = localMediaInfo;
        this.duration = j3;
        this.isFromCapture = z16;
        this.selectMusicMid = str3;
        this.isBackGroundChanged = z17;
        this.useHD = i3;
        this.originVolume = f16;
        this.bgmVolume = f17;
        this.bgmVolumeType = bgmVolumeType;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getSelectMusicMid() {
        return this.selectMusicMid;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsBackGroundChanged() {
        return this.isBackGroundChanged;
    }

    /* renamed from: component12, reason: from getter */
    public final int getUseHD() {
        return this.useHD;
    }

    /* renamed from: component13, reason: from getter */
    public final float getOriginVolume() {
        return this.originVolume;
    }

    /* renamed from: component14, reason: from getter */
    public final float getBgmVolume() {
        return this.bgmVolume;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final MusicVolumeControlViewModel.VolumeType getBgmVolumeType() {
        return this.bgmVolumeType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getEditMode() {
        return this.editMode;
    }

    @NotNull
    public final ArrayList<VideoEditData> component3() {
        return this.editData;
    }

    @Nullable
    public final ArrayList<LocalMediaInfo> component4() {
        return this.originMediaInfos;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTemplateFilePath() {
        return this.templateFilePath;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getFrom() {
        return this.from;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final LocalMediaInfo getOutMediaInfo() {
        return this.outMediaInfo;
    }

    /* renamed from: component8, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsFromCapture() {
        return this.isFromCapture;
    }

    @NotNull
    public final VideoEditDataWrapper copy(@Nullable String missionId, @Nullable Integer editMode, @NotNull ArrayList<VideoEditData> editData, @Nullable ArrayList<LocalMediaInfo> originMediaInfos, @Nullable String templateFilePath, @Nullable Integer from, @Nullable LocalMediaInfo outMediaInfo, long duration, boolean isFromCapture, @Nullable String selectMusicMid, boolean isBackGroundChanged, int useHD, float originVolume, float bgmVolume, @NotNull MusicVolumeControlViewModel.VolumeType bgmVolumeType) {
        Intrinsics.checkNotNullParameter(editData, "editData");
        Intrinsics.checkNotNullParameter(bgmVolumeType, "bgmVolumeType");
        return new VideoEditDataWrapper(missionId, editMode, editData, originMediaInfos, templateFilePath, from, outMediaInfo, duration, isFromCapture, selectMusicMid, isBackGroundChanged, useHD, originVolume, bgmVolume, bgmVolumeType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoEditDataWrapper)) {
            return false;
        }
        VideoEditDataWrapper videoEditDataWrapper = (VideoEditDataWrapper) other;
        if (Intrinsics.areEqual(this.missionId, videoEditDataWrapper.missionId) && Intrinsics.areEqual(this.editMode, videoEditDataWrapper.editMode) && Intrinsics.areEqual(this.editData, videoEditDataWrapper.editData) && Intrinsics.areEqual(this.originMediaInfos, videoEditDataWrapper.originMediaInfos) && Intrinsics.areEqual(this.templateFilePath, videoEditDataWrapper.templateFilePath) && Intrinsics.areEqual(this.from, videoEditDataWrapper.from) && Intrinsics.areEqual(this.outMediaInfo, videoEditDataWrapper.outMediaInfo) && this.duration == videoEditDataWrapper.duration && this.isFromCapture == videoEditDataWrapper.isFromCapture && Intrinsics.areEqual(this.selectMusicMid, videoEditDataWrapper.selectMusicMid) && this.isBackGroundChanged == videoEditDataWrapper.isBackGroundChanged && this.useHD == videoEditDataWrapper.useHD && Float.compare(this.originVolume, videoEditDataWrapper.originVolume) == 0 && Float.compare(this.bgmVolume, videoEditDataWrapper.bgmVolume) == 0 && this.bgmVolumeType == videoEditDataWrapper.bgmVolumeType) {
            return true;
        }
        return false;
    }

    public final float getBgmVolume() {
        return this.bgmVolume;
    }

    @NotNull
    public final MusicVolumeControlViewModel.VolumeType getBgmVolumeType() {
        return this.bgmVolumeType;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final ArrayList<VideoEditData> getEditData() {
        return this.editData;
    }

    @Nullable
    public final Integer getEditMode() {
        return this.editMode;
    }

    @Nullable
    public final Integer getFrom() {
        return this.from;
    }

    @Nullable
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    public final ArrayList<LocalMediaInfo> getOriginMediaInfos() {
        return this.originMediaInfos;
    }

    public final float getOriginVolume() {
        return this.originVolume;
    }

    @Nullable
    public final LocalMediaInfo getOutMediaInfo() {
        return this.outMediaInfo;
    }

    @Nullable
    public final String getSelectMusicMid() {
        return this.selectMusicMid;
    }

    @Nullable
    public final String getTemplateFilePath() {
        return this.templateFilePath;
    }

    public final int getUseHD() {
        return this.useHD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        String str = this.missionId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num = this.editMode;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int hashCode7 = (((i16 + hashCode2) * 31) + this.editData.hashCode()) * 31;
        ArrayList<LocalMediaInfo> arrayList = this.originMediaInfos;
        if (arrayList == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = arrayList.hashCode();
        }
        int i17 = (hashCode7 + hashCode3) * 31;
        String str2 = this.templateFilePath;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i18 = (i17 + hashCode4) * 31;
        Integer num2 = this.from;
        if (num2 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num2.hashCode();
        }
        int i19 = (i18 + hashCode5) * 31;
        LocalMediaInfo localMediaInfo = this.outMediaInfo;
        if (localMediaInfo == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = localMediaInfo.hashCode();
        }
        int a16 = (((i19 + hashCode6) * 31) + a.a(this.duration)) * 31;
        boolean z16 = this.isFromCapture;
        int i26 = 1;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int i28 = (a16 + i27) * 31;
        String str3 = this.selectMusicMid;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        int i29 = (i28 + i3) * 31;
        boolean z17 = this.isBackGroundChanged;
        if (!z17) {
            i26 = z17 ? 1 : 0;
        }
        return ((((((((i29 + i26) * 31) + this.useHD) * 31) + Float.floatToIntBits(this.originVolume)) * 31) + Float.floatToIntBits(this.bgmVolume)) * 31) + this.bgmVolumeType.hashCode();
    }

    public final boolean isBackGroundChanged() {
        return this.isBackGroundChanged;
    }

    public final boolean isFromCapture() {
        return this.isFromCapture;
    }

    public final void setBackGroundChanged(boolean z16) {
        this.isBackGroundChanged = z16;
    }

    public final void setBgmVolume(float f16) {
        this.bgmVolume = f16;
    }

    public final void setBgmVolumeType(@NotNull MusicVolumeControlViewModel.VolumeType volumeType) {
        Intrinsics.checkNotNullParameter(volumeType, "<set-?>");
        this.bgmVolumeType = volumeType;
    }

    public final void setDuration(long j3) {
        this.duration = j3;
    }

    public final void setEditMode(@Nullable Integer num) {
        this.editMode = num;
    }

    public final void setFrom(@Nullable Integer num) {
        this.from = num;
    }

    public final void setFromCapture(boolean z16) {
        this.isFromCapture = z16;
    }

    public final void setOriginVolume(float f16) {
        this.originVolume = f16;
    }

    public final void setOutMediaInfo(@Nullable LocalMediaInfo localMediaInfo) {
        this.outMediaInfo = localMediaInfo;
    }

    public final void setSelectMusicMid(@Nullable String str) {
        this.selectMusicMid = str;
    }

    public final void setTemplateFilePath(@Nullable String str) {
        this.templateFilePath = str;
    }

    public final void setUseHD(int i3) {
        this.useHD = i3;
    }

    @NotNull
    public String toString() {
        return "VideoEditDataWrapper(missionId=" + this.missionId + ", editMode=" + this.editMode + ", editData=" + this.editData + ", originMediaInfos=" + this.originMediaInfos + ", templateFilePath=" + this.templateFilePath + ", from=" + this.from + ", outMediaInfo=" + this.outMediaInfo + ", duration=" + this.duration + ", isFromCapture=" + this.isFromCapture + ", selectMusicMid=" + this.selectMusicMid + ", isBackGroundChanged=" + this.isBackGroundChanged + ", useHD=" + this.useHD + ", originVolume=" + this.originVolume + ", bgmVolume=" + this.bgmVolume + ", bgmVolumeType=" + this.bgmVolumeType + ")";
    }

    public /* synthetic */ VideoEditDataWrapper(String str, Integer num, ArrayList arrayList, ArrayList arrayList2, String str2, Integer num2, LocalMediaInfo localMediaInfo, long j3, boolean z16, String str3, boolean z17, int i3, float f16, float f17, MusicVolumeControlViewModel.VolumeType volumeType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? 0 : num, (i16 & 4) != 0 ? new ArrayList() : arrayList, (i16 & 8) != 0 ? null : arrayList2, (i16 & 16) != 0 ? null : str2, (i16 & 32) != 0 ? 0 : num2, (i16 & 64) != 0 ? null : localMediaInfo, j3, z16, str3, (i16 & 1024) != 0 ? false : z17, (i16 & 2048) != 0 ? 0 : i3, (i16 & 4096) != 0 ? 0.0f : f16, (i16 & 8192) != 0 ? 0.0f : f17, (i16 & 16384) != 0 ? MusicVolumeControlViewModel.VolumeType.NONE : volumeType);
    }
}
