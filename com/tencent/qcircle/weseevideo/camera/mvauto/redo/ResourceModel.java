package com.tencent.qcircle.weseevideo.camera.mvauto.redo;

import com.tencent.qcircle.weseevideo.model.effect.VideoTransitionModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u00c6\u0003J\t\u0010#\u001a\u00020\u000fH\u00c6\u0003J\t\u0010$\u001a\u00020\u000fH\u00c6\u0003Jo\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0007J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0007J\b\u0010-\u001a\u0004\u0018\u00010\bJ\t\u0010.\u001a\u00020\u000fH\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001a\u00a8\u00060"}, d2 = {"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/ResourceModel;", "", "selectUuid", "", "flashing", "", "data", "", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/CutModelKt;", "backupData", "transitionData", "Ljava/util/ArrayList;", "Lcom/tencent/qcircle/weseevideo/model/effect/VideoTransitionModel;", "Lkotlin/collections/ArrayList;", "transitionPosition", "", "smartCutType", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/ArrayList;II)V", "getBackupData", "()Ljava/util/List;", "getData", "getFlashing", "()Z", "getSelectUuid", "()Ljava/lang/String;", "getSmartCutType", "()I", "getTransitionData", "()Ljava/util/ArrayList;", "getTransitionPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "getAllVideoDuration", "", "getClipBackupData", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "getMediaClipModel", "getSelectedClip", "hashCode", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class ResourceModel {

    @Nullable
    private final List<CutModelKt> backupData;

    @NotNull
    private final List<CutModelKt> data;
    private final boolean flashing;

    @Nullable
    private final String selectUuid;
    private final int smartCutType;

    @NotNull
    private final ArrayList<VideoTransitionModel> transitionData;
    private final int transitionPosition;

    public ResourceModel() {
        this(null, false, null, null, null, 0, 0, 127, null);
    }

    public static /* synthetic */ ResourceModel copy$default(ResourceModel resourceModel, String str, boolean z16, List list, List list2, ArrayList arrayList, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = resourceModel.selectUuid;
        }
        if ((i17 & 2) != 0) {
            z16 = resourceModel.flashing;
        }
        boolean z17 = z16;
        if ((i17 & 4) != 0) {
            list = resourceModel.data;
        }
        List list3 = list;
        if ((i17 & 8) != 0) {
            list2 = resourceModel.backupData;
        }
        List list4 = list2;
        if ((i17 & 16) != 0) {
            arrayList = resourceModel.transitionData;
        }
        ArrayList arrayList2 = arrayList;
        if ((i17 & 32) != 0) {
            i3 = resourceModel.transitionPosition;
        }
        int i18 = i3;
        if ((i17 & 64) != 0) {
            i16 = resourceModel.smartCutType;
        }
        return resourceModel.copy(str, z17, list3, list4, arrayList2, i18, i16);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSelectUuid() {
        return this.selectUuid;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getFlashing() {
        return this.flashing;
    }

    @NotNull
    public final List<CutModelKt> component3() {
        return this.data;
    }

    @Nullable
    public final List<CutModelKt> component4() {
        return this.backupData;
    }

    @NotNull
    public final ArrayList<VideoTransitionModel> component5() {
        return this.transitionData;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTransitionPosition() {
        return this.transitionPosition;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSmartCutType() {
        return this.smartCutType;
    }

    @NotNull
    public final ResourceModel copy(@Nullable String selectUuid, boolean flashing, @NotNull List<CutModelKt> data, @Nullable List<CutModelKt> backupData, @NotNull ArrayList<VideoTransitionModel> transitionData, int transitionPosition, int smartCutType) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(transitionData, "transitionData");
        return new ResourceModel(selectUuid, flashing, data, backupData, transitionData, transitionPosition, smartCutType);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ResourceModel) {
                ResourceModel resourceModel = (ResourceModel) other;
                if (!Intrinsics.areEqual(this.selectUuid, resourceModel.selectUuid) || this.flashing != resourceModel.flashing || !Intrinsics.areEqual(this.data, resourceModel.data) || !Intrinsics.areEqual(this.backupData, resourceModel.backupData) || !Intrinsics.areEqual(this.transitionData, resourceModel.transitionData) || this.transitionPosition != resourceModel.transitionPosition || this.smartCutType != resourceModel.smartCutType) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getAllVideoDuration() {
        Iterator<T> it = this.data.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((CutModelKt) it.next()).getResource().getScaleDuration();
        }
        return j3;
    }

    @Nullable
    public final List<CutModelKt> getBackupData() {
        return this.backupData;
    }

    @Nullable
    public final List<MediaClipModel> getClipBackupData() {
        int collectionSizeOrDefault;
        List<CutModelKt> list = this.backupData;
        if (list != null) {
            List<CutModelKt> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((CutModelKt) it.next()).convert());
            }
            return arrayList;
        }
        return null;
    }

    @NotNull
    public final List<CutModelKt> getData() {
        return this.data;
    }

    public final boolean getFlashing() {
        return this.flashing;
    }

    @NotNull
    public final List<MediaClipModel> getMediaClipModel() {
        int collectionSizeOrDefault;
        List<CutModelKt> list = this.data;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((CutModelKt) it.next()).convert());
        }
        return arrayList;
    }

    @Nullable
    public final String getSelectUuid() {
        return this.selectUuid;
    }

    @Nullable
    public final CutModelKt getSelectedClip() {
        Object obj;
        Iterator<T> it = this.data.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((CutModelKt) obj).getUuid(), this.selectUuid)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (CutModelKt) obj;
    }

    public final int getSmartCutType() {
        return this.smartCutType;
    }

    @NotNull
    public final ArrayList<VideoTransitionModel> getTransitionData() {
        return this.transitionData;
    }

    public final int getTransitionPosition() {
        return this.transitionPosition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.selectUuid;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        boolean z16 = this.flashing;
        int i26 = z16;
        if (z16 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        List<CutModelKt> list = this.data;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        List<CutModelKt> list2 = this.backupData;
        if (list2 != null) {
            i17 = list2.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        ArrayList<VideoTransitionModel> arrayList = this.transitionData;
        if (arrayList != null) {
            i18 = arrayList.hashCode();
        }
        return ((((i29 + i18) * 31) + this.transitionPosition) * 31) + this.smartCutType;
    }

    @NotNull
    public String toString() {
        return "ResourceModel(selectUuid=" + this.selectUuid + ", flashing=" + this.flashing + ", data=" + this.data + ", backupData=" + this.backupData + ", transitionData=" + this.transitionData + ", transitionPosition=" + this.transitionPosition + ", smartCutType=" + this.smartCutType + ")";
    }

    public ResourceModel(@Nullable String str, boolean z16, @NotNull List<CutModelKt> data, @Nullable List<CutModelKt> list, @NotNull ArrayList<VideoTransitionModel> transitionData, int i3, int i16) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(transitionData, "transitionData");
        this.selectUuid = str;
        this.flashing = z16;
        this.data = data;
        this.backupData = list;
        this.transitionData = transitionData;
        this.transitionPosition = i3;
        this.smartCutType = i16;
    }

    public /* synthetic */ ResourceModel(String str, boolean z16, List list, List list2, ArrayList arrayList, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : str, (i17 & 2) != 0 ? false : z16, (i17 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i17 & 16) != 0 ? new ArrayList() : arrayList, (i17 & 32) != 0 ? -1 : i3, (i17 & 64) == 0 ? i16 : 0);
    }
}
