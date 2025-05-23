package com.tencent.qcircle.weishi.module.edit.cut;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.model.effect.VideoTransitionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u001a*\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b\u001a*\u0010\t\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\n\u001a\u00020\b\u001a2\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e\u001a*\u0010\u000f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0010\u001a\u00020\b\u001a\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\r\u001a\u00020\u000e\u001a,\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a8\u0006\u0014"}, d2 = {"calculateClipSeek", "", "clips", "", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/CutModelKt;", JsonUtils.KEY_TRANSITIONS, "Lcom/tencent/qcircle/weseevideo/model/effect/VideoTransitionModel;", "clipUuid", "", "calculateDeleteSeek", "deleteUuid", "calculateReorderSeek", "uuid", "targetIndex", "", "calculateSpeedSeek", "speedUuid", "getIndexdTransition", "getLocateClip", "indicatorTimeMs", "libtavcut_debug"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class CutExtKt {
    public static final long calculateClipSeek(@NotNull List<CutModelKt> clips, @NotNull List<? extends VideoTransitionModel> transitions, @NotNull String clipUuid) {
        Object obj;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        Intrinsics.checkParameterIsNotNull(transitions, "transitions");
        Intrinsics.checkParameterIsNotNull(clipUuid, "clipUuid");
        long j3 = 0;
        int i3 = 0;
        for (Object obj2 : clips) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CutModelKt cutModelKt = (CutModelKt) obj2;
            if (Intrinsics.areEqual(cutModelKt.getUuid(), clipUuid)) {
                return j3;
            }
            j3 += cutModelKt.getResource().getScaleDuration();
            Iterator<T> it = transitions.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((VideoTransitionModel) obj).getTransitionPosition() == i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((VideoTransitionModel) obj) != null) {
                j3 -= (int) (r6.getOverlapTime() / r6.getSpeed());
            }
            i3 = i16;
        }
        return -1L;
    }

    public static final long calculateDeleteSeek(@NotNull List<CutModelKt> clips, @NotNull List<? extends VideoTransitionModel> transitions, @NotNull String deleteUuid) {
        Object lastOrNull;
        String str;
        Object obj;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        Intrinsics.checkParameterIsNotNull(transitions, "transitions");
        Intrinsics.checkParameterIsNotNull(deleteUuid, "deleteUuid");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) clips);
        CutModelKt cutModelKt = (CutModelKt) lastOrNull;
        if (cutModelKt != null) {
            str = cutModelKt.getUuid();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, deleteUuid)) {
            return -1L;
        }
        long j3 = 0;
        int i3 = 0;
        for (Object obj2 : clips) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CutModelKt cutModelKt2 = (CutModelKt) obj2;
            if (Intrinsics.areEqual(cutModelKt2.getUuid(), deleteUuid)) {
                return j3;
            }
            j3 += cutModelKt2.getResource().getScaleDuration();
            Iterator<T> it = transitions.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((VideoTransitionModel) obj).getTransitionPosition() == i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((VideoTransitionModel) obj) != null) {
                j3 -= (int) (r9.getOverlapTime() / r9.getSpeed());
            }
            i3 = i16;
        }
        return -1L;
    }

    public static final long calculateReorderSeek(@NotNull List<CutModelKt> clips, @NotNull List<? extends VideoTransitionModel> transitions, @NotNull String uuid, int i3) {
        int i16;
        int collectionSizeOrDefault;
        long j3;
        Object obj;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        Intrinsics.checkParameterIsNotNull(transitions, "transitions");
        Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        Iterator<CutModelKt> it = clips.iterator();
        int i17 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getUuid(), uuid)) {
                    break;
                }
                i17++;
            } else {
                i17 = -1;
                break;
            }
        }
        if (i17 < i3) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        List<CutModelKt> subList = clips.subList(0, i3 + i16);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i18 = 0;
        for (Object obj2 : subList) {
            int i19 = i18 + 1;
            if (i18 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CutModelKt cutModelKt = (CutModelKt) obj2;
            Iterator<T> it5 = transitions.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (((VideoTransitionModel) obj).getTransitionPosition() == i18) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            arrayList.add(new Pair(cutModelKt, obj));
            i18 = i19;
        }
        ArrayList<Pair> arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (!Intrinsics.areEqual(((CutModelKt) ((Pair) obj3).getFirst()).getUuid(), uuid)) {
                arrayList2.add(obj3);
            }
        }
        long j16 = 0;
        for (Pair pair : arrayList2) {
            VideoTransitionModel videoTransitionModel = (VideoTransitionModel) pair.getSecond();
            if (videoTransitionModel != null) {
                j3 = videoTransitionModel.getOverlapTime() / videoTransitionModel.getSpeed();
            } else {
                j3 = 0;
            }
            j16 = (j16 + ((CutModelKt) pair.getFirst()).getResource().getScaleDuration()) - j3;
        }
        return j16;
    }

    public static final long calculateSpeedSeek(@NotNull List<CutModelKt> clips, @NotNull List<? extends VideoTransitionModel> transitions, @NotNull String speedUuid) {
        Object obj;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        Intrinsics.checkParameterIsNotNull(transitions, "transitions");
        Intrinsics.checkParameterIsNotNull(speedUuid, "speedUuid");
        long j3 = 0;
        int i3 = 0;
        for (Object obj2 : clips) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CutModelKt cutModelKt = (CutModelKt) obj2;
            if (Intrinsics.areEqual(cutModelKt.getUuid(), speedUuid)) {
                return j3;
            }
            j3 += cutModelKt.getResource().getScaleDuration();
            Iterator<T> it = transitions.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((VideoTransitionModel) obj).getTransitionPosition() == i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((VideoTransitionModel) obj) != null) {
                j3 -= (int) (r6.getOverlapTime() / r6.getSpeed());
            }
            i3 = i16;
        }
        return -1L;
    }

    @Nullable
    public static final VideoTransitionModel getIndexdTransition(@NotNull List<? extends VideoTransitionModel> transitions, int i3) {
        Object obj;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(transitions, "transitions");
        Iterator<T> it = transitions.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((VideoTransitionModel) obj).getTransitionPosition() == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (VideoTransitionModel) obj;
    }

    @Nullable
    public static final CutModelKt getLocateClip(long j3, @NotNull List<CutModelKt> clips, @NotNull List<? extends VideoTransitionModel> transitions) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        Intrinsics.checkParameterIsNotNull(transitions, "transitions");
        Iterator<T> it = clips.iterator();
        int i3 = 0;
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                return null;
            }
            Object next = it.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CutModelKt cutModelKt = (CutModelKt) next;
            Iterator<T> it5 = transitions.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                if (((VideoTransitionModel) next2).getTransitionPosition() == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next2;
                    break;
                }
            }
            if (((VideoTransitionModel) obj) != null) {
                j3 += (int) (r3.getOverlapTime() / r3.getSpeed());
            }
            if (cutModelKt.getResource().getScaleDuration() >= j3) {
                return cutModelKt;
            }
            j3 -= cutModelKt.getResource().getScaleDuration();
            i3 = i16;
        }
    }
}
