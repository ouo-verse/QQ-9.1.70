package com.tencent.mobileqq.wink.editor;

import android.widget.FrameLayout;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.TrackStickerInfo;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModelUtilsKt;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.TransitionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u001a&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "", "enableTransition", "", "e", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "Lcom/tencent/videocut/model/MediaClip;", "b", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/draft/TrackStickerInfo;", "stickerTrackerResult", "Lcom/gyailib/library/GYTrackStickerInfo;", "a", "Lcom/tencent/mobileqq/wink/editor/dr$c;", "params", "Landroid/widget/FrameLayout;", "containerWrapper", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "stickerMaterial", "Lcom/tencent/videocut/model/Size;", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ds {
    @Nullable
    public static final ArrayList<GYTrackStickerInfo> a(@Nullable ArrayList<TrackStickerInfo> arrayList) {
        if (arrayList != null) {
            ArrayList<GYTrackStickerInfo> arrayList2 = new ArrayList<>();
            Iterator<TrackStickerInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TrackStickerInfo next = it.next();
                float x16 = next.getX();
                float y16 = next.getY();
                float w3 = next.getW();
                float h16 = next.getH();
                float radian = next.getRadian();
                float imageW = next.getImageW();
                float imageH = next.getImageH();
                float confidence = next.getConfidence();
                long timestamp = next.getTimestamp();
                GYTrackStickerInfo gYTrackStickerInfo = new GYTrackStickerInfo();
                gYTrackStickerInfo.f35992x = x16;
                gYTrackStickerInfo.f35993y = y16;
                gYTrackStickerInfo.f35991w = w3;
                gYTrackStickerInfo.f35990h = h16;
                gYTrackStickerInfo.radian = radian;
                gYTrackStickerInfo.imageW = imageW;
                gYTrackStickerInfo.imageH = imageH;
                gYTrackStickerInfo.confidence = confidence;
                gYTrackStickerInfo.timestamp = timestamp;
                arrayList2.add(gYTrackStickerInfo);
            }
            return arrayList2;
        }
        return null;
    }

    @Nullable
    public static final MediaClip b(@NotNull WinkVideoTavCut winkVideoTavCut, long j3) {
        Intrinsics.checkNotNullParameter(winkVideoTavCut, "<this>");
        List<MediaClip> g06 = winkVideoTavCut.g0();
        if (g06 != null) {
            long j16 = 0;
            for (MediaClip mediaClip : g06) {
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    long j17 = resourceModel.scaleDuration;
                    if ((j3 - j16) * ((j17 + j16) - j3) >= 0) {
                        return mediaClip;
                    }
                    j16 += j17;
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public static final Size c(@NotNull dr.WinkTavCutParams params, @Nullable FrameLayout frameLayout, @Nullable MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (frameLayout != null && metaMaterial != null && frameLayout.getHeight() > 0 && (com.tencent.mobileqq.wink.editor.sticker.m.S(metaMaterial) || com.tencent.mobileqq.wink.editor.sticker.m.U(metaMaterial))) {
            return new Size(Integer.valueOf(frameLayout.getWidth()), Integer.valueOf(frameLayout.getHeight()), null, 4, null);
        }
        return new Size(Integer.valueOf(params.getWidth()), Integer.valueOf(params.getHeight()), null, 4, null);
    }

    public static /* synthetic */ Size d(dr.WinkTavCutParams winkTavCutParams, FrameLayout frameLayout, MetaMaterial metaMaterial, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            frameLayout = null;
        }
        if ((i3 & 4) != 0) {
            metaMaterial = null;
        }
        return c(winkTavCutParams, frameLayout, metaMaterial);
    }

    public static final void e(@NotNull WinkVideoTavCut winkVideoTavCut, boolean z16) {
        Map<String, TransitionModel> emptyMap;
        Intrinsics.checkNotNullParameter(winkVideoTavCut, "<this>");
        List<MediaClip> clipsMinusTransformTime = MediaModelUtilsKt.getClipsMinusTransformTime(winkVideoTavCut.V(), z16);
        emptyMap = MapsKt__MapsKt.emptyMap();
        winkVideoTavCut.f3(clipsMinusTransformTime, emptyMap);
    }
}
