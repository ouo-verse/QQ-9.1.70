package com.tencent.mobileqq.wink.explore;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra;
import com.tencent.mobileqq.wink.editor.draft.c;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.sticker.StickerLayerIndexManager;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.editor.util.f;
import com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator;
import com.tencent.mobileqq.wink.utils.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.ImageType;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.render.extension.e;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGText;
import org.light.lightAssetKit.components.Size;
import tl.h;
import u73.Audio;
import u73.Background;
import u73.MemeData;
import u73.Sticker;
import u73.Text;
import u73.d;
import w53.b;
import w73.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b=\u0010>J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J4\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J \u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\"H\u0002J\u001b\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J(\u00101\u001a\u0002002\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u00104\u001a\u0002032\u0006\u0010\u0007\u001a\u0002022\u0006\u0010\b\u001a\u0002022\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J;\u00106\u001a\u00020'2\u0006\u00105\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u00107R\u001c\u0010<\u001a\n 9*\u0004\u0018\u000108088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/wink/explore/WinkMediaModelGenerator;", "", "Landroid/content/Context;", "context", "Lu73/f;", "memeData", "", "width", "height", "", "topic", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "j", "e", "wrapper", "renderWidth", "renderHeight", "Lkotlin/Pair;", DomainData.DOMAIN_NAME, "", "f", "url", "Lcom/tencent/videocut/model/ImageType;", "o", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "winkStickModel", "r", "stickerModel", "Lu73/a;", "audio", "d", "g", "Lu73/j;", "text", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "defaultTextMaterial", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "metaMaterial", "p", "", "l", "(Lu73/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "paramsWidth", "paramsHeight", "Lorg/light/lightAssetKit/components/Size;", "i", "", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut$b;", h.F, "data", "k", "(Ljava/lang/String;IILandroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/biz/richframework/download/RFWDownloader;", QDLog.TAG_DOWNLOAD, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaModelGenerator {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkMediaModelGenerator f322764a = new WinkMediaModelGenerator();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final RFWDownloader downloader = RFWDownloaderFactory.getDownloader(new a());

    WinkMediaModelGenerator() {
    }

    private final void d(WinkStickerModel stickerModel, Audio audio, WinkEditDataWrapper wrapper) {
        boolean z16;
        AudioModel copy;
        Object first;
        MediaModel copy2;
        AudioModel copy3;
        b.f("WinkMediaModelGenerator", "[MemeData] audio:" + audio);
        if (audio.getUrl().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            b.g("WinkMediaModelGenerator", "no audio url...");
            return;
        }
        stickerModel.setTimeRangeChangedByUser(true);
        AudioModel audioModel = new AudioModel(null, null, 0L, 0L, 0L, 0.0f, 0.0f, null, null, null, 0L, 0L, 0L, 0L, null, null, null, null, null, 524287, null);
        String g16 = com.tencent.videocut.render.extension.a.g(stickerModel.id);
        if (g16 == null) {
            return;
        }
        copy = audioModel.copy((r37 & 1) != 0 ? audioModel.id : g16, (r37 & 2) != 0 ? audioModel.path : audio.b(), (r37 & 4) != 0 ? Long.valueOf(audioModel.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(audioModel.sourceDuration) : Long.valueOf(audio.a()), (r37 & 16) != 0 ? Long.valueOf(audioModel.startTimeInTimeline) : Long.valueOf(stickerModel.startTime), (r37 & 32) != 0 ? Float.valueOf(audioModel.volume) : Float.valueOf(2.0f), (r37 & 64) != 0 ? Float.valueOf(audioModel.speed) : Float.valueOf(1.0f), (r37 & 128) != 0 ? audioModel.volumeEffects : null, (r37 & 256) != 0 ? audioModel.name : null, (r37 & 512) != 0 ? audioModel.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(audioModel.selectStartTime) : 0L, (r37 & 2048) != 0 ? Long.valueOf(audioModel.selectDuration) : Long.valueOf(audio.a()), (r37 & 4096) != 0 ? Long.valueOf(audioModel.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(audioModel.fadeOutDuration) : null, (r37 & 16384) != 0 ? audioModel.lyricInfo : null, (r37 & 32768) != 0 ? audioModel.type : AudioModel.Type.TTS, (r37 & 65536) != 0 ? audioModel.waveSampleData : null, (r37 & 131072) != 0 ? audioModel.event : null, (r37 & 262144) != 0 ? audioModel.unknownFields() : null);
        com.tencent.videocut.render.extension.a.i(copy, 0);
        QLog.i("WinkMediaModelGenerator", 1, "[appendVideo] audioModel: " + copy);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) wrapper.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) first;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, AudioModel> entry : winkEditData.getMediaModel().audios.entrySet()) {
            String key = entry.getKey();
            copy3 = r16.copy((r37 & 1) != 0 ? r16.id : null, (r37 & 2) != 0 ? r16.path : null, (r37 & 4) != 0 ? Long.valueOf(r16.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(r16.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(r16.startTimeInTimeline) : null, (r37 & 32) != 0 ? Float.valueOf(r16.volume) : null, (r37 & 64) != 0 ? Float.valueOf(r16.speed) : null, (r37 & 128) != 0 ? r16.volumeEffects : null, (r37 & 256) != 0 ? r16.name : null, (r37 & 512) != 0 ? r16.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(r16.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(r16.selectDuration) : null, (r37 & 4096) != 0 ? Long.valueOf(r16.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(r16.fadeOutDuration) : null, (r37 & 16384) != 0 ? r16.lyricInfo : null, (r37 & 32768) != 0 ? r16.type : null, (r37 & 65536) != 0 ? r16.waveSampleData : null, (r37 & 131072) != 0 ? r16.event : null, (r37 & 262144) != 0 ? entry.getValue().unknownFields() : null);
            linkedHashMap.put(key, copy3);
        }
        linkedHashMap.remove(g16);
        linkedHashMap.put(g16, copy);
        copy2 = r7.copy((r39 & 1) != 0 ? r7.id : null, (r39 & 2) != 0 ? r7.name : null, (r39 & 4) != 0 ? r7.version : null, (r39 & 8) != 0 ? r7.createTime : null, (r39 & 16) != 0 ? r7.updateTime : null, (r39 & 32) != 0 ? r7.duration : null, (r39 & 64) != 0 ? r7.videos : null, (r39 & 128) != 0 ? r7.audios : linkedHashMap, (r39 & 256) != 0 ? r7.stickers : null, (r39 & 512) != 0 ? r7.backgroundModel : null, (r39 & 1024) != 0 ? r7.filterModels : null, (r39 & 2048) != 0 ? r7.specialEffects : null, (r39 & 4096) != 0 ? r7.transitions : null, (r39 & 8192) != 0 ? r7.templateModel : null, (r39 & 16384) != 0 ? r7.coverInfo : null, (r39 & 32768) != 0 ? r7.exportSetting : null, (r39 & 65536) != 0 ? r7.openHDR : null, (r39 & 131072) != 0 ? r7.hdrModels : null, (r39 & 262144) != 0 ? r7.smoothModels : null, (r39 & 524288) != 0 ? r7.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
        winkEditData.setMediaModel(copy2);
        if (stickerModel.getTtsAudioInfo() == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = stickerModel.textItems.iterator();
            while (it.hasNext()) {
                arrayList.add(((TextItem) it.next()).text);
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            stickerModel.setTtsAudioInfo(new TTSAudioInfo((String[]) array, 1, 2.0f, stickerModel.id));
        }
        stickerModel.setHasChooseTTS(true);
    }

    private final WinkEditDataWrapper e(MemeData memeData) {
        ArrayList arrayList;
        Object first;
        int collectionSizeOrDefault;
        MediaModel copy;
        WinkEditData copy2;
        Background background;
        ResourceModel resourceModel;
        ResourceModel copy3;
        Object orNull;
        Object next;
        int collectionSizeOrDefault2;
        b.f("WinkMediaModelGenerator", "[MemeData]backgrounds:" + memeData.a());
        List<Background> a16 = memeData.a();
        if (a16 != null) {
            List<Background> list = a16;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(WinkExportUtils.b(((Background) it.next()).c()));
            }
        } else {
            arrayList = null;
        }
        List<Background> a17 = memeData.a();
        float f16 = 10.0f;
        if (a17 != null) {
            Iterator<T> it5 = a17.iterator();
            if (!it5.hasNext()) {
                next = null;
            } else {
                next = it5.next();
                if (it5.hasNext()) {
                    float endTime = ((Background) next).getEndTime();
                    do {
                        Object next2 = it5.next();
                        float endTime2 = ((Background) next2).getEndTime();
                        if (Float.compare(endTime, endTime2) < 0) {
                            next = next2;
                            endTime = endTime2;
                        }
                    } while (it5.hasNext());
                }
            }
            Background background2 = (Background) next;
            if (background2 != null) {
                f16 = background2.getEndTime();
            }
        }
        b.f("WinkMediaModelGenerator", "[buildDefaultEditDataWrapper] videoTime:(0 - " + f16 + ")");
        long j3 = (long) (f16 * ((float) 1000000));
        WinkEditDataWrapper copy$default = WinkEditDataWrapper.copy$default(c.g(new ArrayList(arrayList), 0, 0, false, 6, null), WinkContext.INSTANCE.d().getMissionId(), null, null, null, null, null, null, j3, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -130, 4095, null);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) copy$default.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) first;
        List<MediaClip> list2 = winkEditData.getMediaModel().videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaClip mediaClip = (MediaClip) obj;
            List<Background> a18 = memeData.a();
            if (a18 != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(a18, i3);
                background = (Background) orNull;
            } else {
                background = null;
            }
            if (background != null) {
                ResourceModel resourceModel2 = mediaClip.resource;
                if (resourceModel2 != null) {
                    copy3 = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : Long.valueOf(background.a()), (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : Long.valueOf(background.a()), (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : Long.valueOf(background.a()), (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
                    resourceModel = copy3;
                } else {
                    resourceModel = null;
                }
                mediaClip = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
            }
            arrayList2.add(mediaClip);
            i3 = i16;
        }
        copy = r21.copy((r39 & 1) != 0 ? r21.id : null, (r39 & 2) != 0 ? r21.name : null, (r39 & 4) != 0 ? r21.version : null, (r39 & 8) != 0 ? r21.createTime : null, (r39 & 16) != 0 ? r21.updateTime : null, (r39 & 32) != 0 ? r21.duration : null, (r39 & 64) != 0 ? r21.videos : arrayList2, (r39 & 128) != 0 ? r21.audios : null, (r39 & 256) != 0 ? r21.stickers : null, (r39 & 512) != 0 ? r21.backgroundModel : null, (r39 & 1024) != 0 ? r21.filterModels : null, (r39 & 2048) != 0 ? r21.specialEffects : null, (r39 & 4096) != 0 ? r21.transitions : null, (r39 & 8192) != 0 ? r21.templateModel : null, (r39 & 16384) != 0 ? r21.coverInfo : null, (r39 & 32768) != 0 ? r21.exportSetting : null, (r39 & 65536) != 0 ? r21.openHDR : null, (r39 & 131072) != 0 ? r21.hdrModels : null, (r39 & 262144) != 0 ? r21.smoothModels : null, (r39 & 524288) != 0 ? r21.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
        copy2 = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : copy, (r37 & 2) != 0 ? winkEditData.durationUs : j3, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : null, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
        copy$default.getEditDatas().clear();
        copy$default.getEditDatas().add(copy2);
        return copy$default;
    }

    private final void f(MemeData memeData, WinkEditDataWrapper wrapper, int renderWidth, int renderHeight, String topic) {
        boolean z16;
        Map<String, String> mapOf;
        boolean z17;
        List<Sticker> b16 = memeData.b();
        if (b16 != null) {
            for (Sticker sticker : b16) {
                b.f("WinkMediaModelGenerator", "[MemeData] sticker:" + sticker);
                PointF pointF = new PointF(0.0f, 0.0f);
                float c16 = sticker.getFrame().c();
                QLog.i("WinkMediaModelGenerator", 1, "[buildStickers] scale:" + c16);
                if (sticker.getUrl().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    b.g("WinkMediaModelGenerator", "no sticker url...");
                } else {
                    int b17 = StickerLayerIndexManager.f321548a.b();
                    MetaMaterial metaMaterial = new MetaMaterial();
                    metaMaterial.f30533id = UUID.randomUUID().toString();
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("imageUrl", sticker.getUrl()), TuplesKt.to("imagePath", sticker.d()), TuplesKt.to("topic", topic), TuplesKt.to("sendToFeed", "0"));
                    metaMaterial.additionalFields = mapOf;
                    metaMaterial.thumbUrl = sticker.getUrl();
                    Unit unit = Unit.INSTANCE;
                    long e16 = sticker.e();
                    long b18 = sticker.b();
                    StickerModel.Type type = StickerModel.Type.DEFAULT;
                    String d16 = sticker.d();
                    WinkMediaModelGenerator winkMediaModelGenerator = f322764a;
                    WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(l.E(b17, pointF, metaMaterial, e16, b18, type, 1.0f, 0.0f, d16, winkMediaModelGenerator.o(sticker.getUrl()), 800, 800, 0.0f, 0.0f, 12288, null), null, null, 0L, 0L, 0, c16, c16, 0.0f, sticker.getFrame().a(), sticker.getFrame().b(), false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -865, 1048575, null);
                    copyAndUpdate$default.updatePositionInView(renderWidth, renderHeight, c16, c16, sticker.getFrame().a(), sticker.getFrame().b());
                    Audio audio = sticker.getAudio();
                    if (audio != null) {
                        if (audio.getUrl().length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            audio = null;
                        }
                        if (audio != null) {
                            winkMediaModelGenerator.d(copyAndUpdate$default, audio, wrapper);
                        }
                    }
                    winkMediaModelGenerator.r(copyAndUpdate$default, wrapper);
                }
            }
        }
    }

    private final void g(MemeData memeData, WinkEditDataWrapper wrapper, int renderWidth, int renderHeight) {
        String str;
        String str2;
        ArrayList arrayListOf;
        List<Text> c16 = memeData.c();
        if (c16 != null) {
            for (Text text : c16) {
                b.f("WinkMediaModelGenerator", "[MemeData]Text:" + text);
                MetaMaterial a06 = m.a0();
                com.tencent.mobileqq.wink.editor.c.F1(a06, false);
                WinkStickerModel u16 = l.u(a06, new SizeF(0.0f, 0.0f, null, 4, null), new SizeF(0.0f, 0.0f, null, 4, null), renderWidth, renderHeight, text.e(), text.c(), false, false, 192, null);
                if (u16 != null) {
                    float a16 = text.getFrame().a();
                    float b16 = text.getFrame().b();
                    float c17 = text.getFrame().c();
                    float c18 = text.getFrame().c();
                    boolean z16 = true;
                    TextItem[] textItemArr = new TextItem[1];
                    String text2 = text.getText();
                    String textColor = text.getTextColor();
                    String textBgColor = text.getTextBgColor();
                    if (textBgColor == null) {
                        str = "";
                    } else {
                        str = textBgColor;
                    }
                    int b17 = text.b();
                    String strokeColor = text.getStrokeColor();
                    if (strokeColor == null) {
                        str2 = "";
                    } else {
                        str2 = strokeColor;
                    }
                    float strokeWidth = text.getStrokeWidth();
                    String strokeColor2 = text.getStrokeColor();
                    if (strokeColor2 == null || strokeColor2.length() <= 0) {
                        z16 = false;
                    }
                    textItemArr[0] = new TextItem(text2, textColor, null, str2, strokeWidth, null, null, null, 0, null, null, null, Boolean.valueOf(z16), null, null, str, b17, null, null, null, null, 1994724, null);
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(textItemArr);
                    WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(u16, null, null, 0L, 0L, 0, c17, c18, 0.0f, a16, b16, false, 0, 0, 0.0f, 0.0f, arrayListOf, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -33633, 1048575, null);
                    if (copyAndUpdate$default != null) {
                        WinkMediaModelGenerator winkMediaModelGenerator = f322764a;
                        winkMediaModelGenerator.q(text, a06);
                        m.n0(a06, text.getText());
                        winkMediaModelGenerator.p(a06);
                        WinkStickerModel copyAndUpdate$default2 = WinkStickerModel.copyAndUpdate$default(copyAndUpdate$default, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, a06, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -1, 1048447, null);
                        copyAndUpdate$default2.updatePositionInView(renderWidth, renderHeight, text.getFrame().c(), text.getFrame().c(), text.getFrame().a(), text.getFrame().b());
                        winkMediaModelGenerator.r(copyAndUpdate$default2, wrapper);
                    }
                }
            }
        }
    }

    private final WinkVideoTavCut.RenderSizeAndOriginSize h(float width, float height, int paramsWidth, int paramsHeight, Context context) {
        f fVar = f.f322633a;
        return fVar.a(fVar.b(width, height, context), paramsWidth, paramsHeight, width, height).getFirst();
    }

    private final Size i(MediaModel mediaModel, int paramsWidth, int paramsHeight, Context context) {
        try {
            BackgroundModel backgroundModel = mediaModel.backgroundModel;
            if (backgroundModel == null || backgroundModel.renderSize == null) {
                float f16 = e.o(mediaModel.videos.get(0)).width;
            }
            BackgroundModel backgroundModel2 = mediaModel.backgroundModel;
            if (backgroundModel2 == null || backgroundModel2.renderSize == null) {
                float f17 = e.o(mediaModel.videos.get(0)).height;
            }
            SizeF c16 = com.tencent.mobileqq.wink.editor.util.m.f322645a.c(mediaModel.videos);
            WinkVideoTavCut.RenderSizeAndOriginSize h16 = h(c16.width, c16.height, paramsWidth, paramsHeight, context);
            int renderWidth = h16.getRenderWidth();
            int renderHeight = h16.getRenderHeight();
            ms.a.c("WinkMediaModelGenerator", "[ratioFeature] -> [computerRenderSize], result width:" + renderWidth + " renderHeight:" + renderHeight);
            return new Size(renderWidth, renderHeight);
        } catch (Exception e16) {
            ms.a.e("WinkMediaModelGenerator", e16);
            return com.tencent.mobileqq.wink.editor.util.m.f322645a.b();
        }
    }

    private final WinkEditDataWrapper j(Context context, MemeData memeData, int width, int height, String topic) {
        WinkEditDataWrapper e16 = e(memeData);
        Pair<Integer, Integer> n3 = n(context, e16, width, height);
        int intValue = n3.component1().intValue();
        int intValue2 = n3.component2().intValue();
        b.f("WinkMediaModelGenerator", "renderWidth:" + intValue + " renderHeight:" + intValue2);
        f(memeData, e16, intValue, intValue2, topic);
        g(memeData, e16, intValue, intValue2);
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(MemeData memeData, Continuation<? super Boolean> continuation) {
        WinkMediaModelGenerator$downloadFile$1 winkMediaModelGenerator$downloadFile$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Deferred async$default;
        String url;
        boolean z16;
        boolean z17;
        String url2;
        boolean z18;
        boolean z19;
        List list;
        Iterator it;
        if (continuation instanceof WinkMediaModelGenerator$downloadFile$1) {
            winkMediaModelGenerator$downloadFile$1 = (WinkMediaModelGenerator$downloadFile$1) continuation;
            int i16 = winkMediaModelGenerator$downloadFile$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkMediaModelGenerator$downloadFile$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkMediaModelGenerator$downloadFile$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkMediaModelGenerator$downloadFile$1.label;
                boolean z26 = false;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.i("WinkMediaModelGenerator", 1, "[downloadFile] Start...");
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    List<Background> a16 = memeData.a();
                    if (a16 != null) {
                        for (Background background : a16) {
                            QLog.i("WinkMediaModelGenerator", 1, "[downloadUrl] background:" + background.getUrl());
                            if (background.getUrl().length() > 0) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (z19) {
                                linkedHashSet.add(background.getUrl());
                            }
                        }
                    }
                    List<Sticker> b16 = memeData.b();
                    if (b16 != null) {
                        for (Sticker sticker : b16) {
                            QLog.i("WinkMediaModelGenerator", 1, "[downloadUrl] sticker:" + sticker.getUrl());
                            if (sticker.getUrl().length() > 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                linkedHashSet.add(sticker.getUrl());
                            }
                            Audio audio = sticker.getAudio();
                            if (audio != null && (url2 = audio.getUrl()) != null) {
                                if (url2.length() > 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (!z18) {
                                    url2 = null;
                                }
                                if (url2 != null) {
                                    QLog.i("WinkMediaModelGenerator", 1, "[downloadUrl] sticker-audio:" + url2);
                                    linkedHashSet.add(url2);
                                }
                            }
                        }
                    }
                    List<Text> c16 = memeData.c();
                    if (c16 != null) {
                        Iterator<T> it5 = c16.iterator();
                        while (it5.hasNext()) {
                            Audio audio2 = ((Text) it5.next()).getAudio();
                            if (audio2 != null && (url = audio2.getUrl()) != null) {
                                if (url.length() > 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (!z16) {
                                    url = null;
                                }
                                if (url != null) {
                                    QLog.i("WinkMediaModelGenerator", 1, "[downloadUrl] text-audio:" + url);
                                    linkedHashSet.add(url);
                                }
                            }
                        }
                    }
                    QLog.i("WinkMediaModelGenerator", 1, "[downloadUrl] download size:" + linkedHashSet.size());
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedHashSet, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it6 = linkedHashSet.iterator();
                    while (it6.hasNext()) {
                        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkMediaModelGenerator$downloadFile$downloadJobs$1$1((String) it6.next(), null), 3, null);
                        arrayList.add(async$default);
                    }
                    winkMediaModelGenerator$downloadFile$1.label = 1;
                    obj = AwaitKt.awaitAll(arrayList, winkMediaModelGenerator$downloadFile$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                QLog.i("WinkMediaModelGenerator", 1, "[downloadFile] Finish...");
                list = (List) obj;
                if ((list instanceof Collection) || !list.isEmpty()) {
                    it = list.iterator();
                    while (it.hasNext()) {
                        if (!((Boolean) it.next()).booleanValue()) {
                            break;
                        }
                    }
                }
                z26 = true;
                return Boxing.boxBoolean(z26);
            }
        }
        winkMediaModelGenerator$downloadFile$1 = new WinkMediaModelGenerator$downloadFile$1(this, continuation);
        Object obj2 = winkMediaModelGenerator$downloadFile$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkMediaModelGenerator$downloadFile$1.label;
        boolean z262 = false;
        if (i3 == 0) {
        }
        QLog.i("WinkMediaModelGenerator", 1, "[downloadFile] Finish...");
        list = (List) obj2;
        if (list instanceof Collection) {
        }
        it = list.iterator();
        while (it.hasNext()) {
        }
        z262 = true;
        return Boxing.boxBoolean(z262);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WinkMediaModelGenerator$downloadFileFromUrl$2(str, null), continuation);
    }

    private final Pair<Integer, Integer> n(Context context, WinkEditDataWrapper wrapper, int renderWidth, int renderHeight) {
        Object firstOrNull;
        Size size;
        Object first;
        Float f16;
        Object first2;
        Float f17;
        Integer num;
        Object first3;
        int i3;
        SizeF sizeF;
        Object first4;
        SizeF sizeF2;
        SizeF sizeF3;
        SizeF sizeF4;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) wrapper.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) firstOrNull;
        Integer num2 = null;
        if (winkEditData != null) {
            WinkDraftGenerator.f325956a.t(winkEditData.getMediaModel());
            size = f322764a.i(winkEditData.getMediaModel(), renderWidth, renderHeight, context);
        } else {
            size = null;
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) wrapper.getEditDatas());
        BackgroundModel backgroundModel = ((WinkEditData) first).getMediaModel().backgroundModel;
        if (backgroundModel != null && (sizeF4 = backgroundModel.renderSize) != null) {
            f16 = Float.valueOf(sizeF4.width);
        } else {
            f16 = null;
        }
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) wrapper.getEditDatas());
        BackgroundModel backgroundModel2 = ((WinkEditData) first2).getMediaModel().backgroundModel;
        if (backgroundModel2 != null && (sizeF3 = backgroundModel2.renderSize) != null) {
            f17 = Float.valueOf(sizeF3.height);
        } else {
            f17 = null;
        }
        if (size != null) {
            num = Integer.valueOf(size.width);
        } else {
            num = null;
        }
        if (size != null) {
            num2 = Integer.valueOf(size.height);
        }
        QLog.i("WinkMediaModelGenerator", 1, "(" + renderWidth + "," + renderHeight + ") (" + f16 + "," + f17 + ") (" + num + "," + num2 + ")");
        if (size == null) {
            first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) wrapper.getEditDatas());
            BackgroundModel backgroundModel3 = ((WinkEditData) first3).getMediaModel().backgroundModel;
            if (backgroundModel3 != null && (sizeF = backgroundModel3.renderSize) != null) {
                i3 = (int) sizeF.width;
            } else {
                i3 = renderWidth;
            }
        } else {
            i3 = size.width;
        }
        if (size == null) {
            first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) wrapper.getEditDatas());
            BackgroundModel backgroundModel4 = ((WinkEditData) first4).getMediaModel().backgroundModel;
            if (backgroundModel4 != null && (sizeF2 = backgroundModel4.renderSize) != null) {
                renderWidth = (int) sizeF2.height;
            }
        } else {
            renderWidth = size.height;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(renderWidth));
    }

    private final ImageType o(String url) {
        boolean endsWith;
        boolean endsWith2;
        endsWith = StringsKt__StringsJVMKt.endsWith(url, ".png", true);
        if (!endsWith) {
            endsWith2 = StringsKt__StringsJVMKt.endsWith(url, QzoneEmotionUtils.SIGN_ICON_URL_END, true);
            if (endsWith2) {
                return ImageType.GIF;
            }
            return ImageType.UNKNOWN;
        }
        return ImageType.COMMON;
    }

    private final void p(MetaMaterial metaMaterial) {
        PAGText textData;
        PAGLayer layerAt;
        RectF bounds;
        PAGFile c16 = x.b().c(m.y(metaMaterial));
        if (c16 != null && (textData = c16.getTextData(0)) != null) {
            textData.text = m.l(metaMaterial);
            textData.fillColor = m.F(metaMaterial);
            textData.justification = m.G(metaMaterial);
            textData.fontStyle = m.s(metaMaterial);
            textData.fontFamily = m.o(metaMaterial);
            textData.backgroundColor = m.g(metaMaterial);
            textData.backgroundAlpha = m.f(metaMaterial);
            textData.applyStroke = m.e(metaMaterial);
            textData.strokeColor = m.B(metaMaterial);
            textData.strokeWidth = m.C(metaMaterial);
            c16.replaceText(0, textData);
            if (c16.numChildren() == 1 && (layerAt = c16.getLayerAt(0)) != null && (bounds = layerAt.getBounds()) != null) {
                Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
                ms.a.a("WinkMediaModelGenerator", "page layer bounds before concat =  " + bounds + " \uff0c content = " + m.l(metaMaterial) + ", height = " + c16.height());
                Matrix matrix = new Matrix();
                matrix.reset();
                while (layerAt != null) {
                    matrix.postConcat(layerAt.getTotalMatrix());
                    layerAt = layerAt.parent();
                }
                matrix.mapRect(bounds);
                ms.a.a("WinkMediaModelGenerator", "page layer bounds = " + bounds + " \uff0c content = " + m.l(metaMaterial) + ", height = " + c16.height());
                Map<String, String> map = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map, "metaMaterial.additionalFields");
                map.put("textBoundsTop", String.valueOf(bounds.top));
                Map<String, String> map2 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map2, "metaMaterial.additionalFields");
                map2.put("textBoundsBottom", String.valueOf(bounds.bottom));
                Map<String, String> map3 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map3, "metaMaterial.additionalFields");
                map3.put("textBoundsLeft", String.valueOf(bounds.left));
                Map<String, String> map4 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map4, "metaMaterial.additionalFields");
                map4.put("textBoundsRight", String.valueOf(bounds.right));
                Map<String, String> map5 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map5, "metaMaterial.additionalFields");
                map5.put("pagViewCenterX", String.valueOf(c16.width() / 2.0f));
                Map<String, String> map6 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map6, "metaMaterial.additionalFields");
                map6.put("pagViewCenterY", String.valueOf(c16.height() / 2.0f));
                Map<String, String> map7 = metaMaterial.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map7, "metaMaterial.additionalFields");
                map7.put("pagViewWidth", String.valueOf(c16.width()));
            }
        }
    }

    private final void q(Text text, MetaMaterial defaultTextMaterial) {
        boolean z16;
        boolean z17;
        String textColor = text.getTextColor();
        boolean z18 = false;
        if (textColor.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = null;
        if (!z16) {
            textColor = null;
        }
        if (textColor != null) {
            m.N0(defaultTextMaterial, Color.parseColor(textColor));
        }
        String textBgColor = text.getTextBgColor();
        if (textBgColor != null) {
            if (textBgColor.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                textBgColor = null;
            }
            if (textBgColor != null) {
                m.g0(defaultTextMaterial, Color.parseColor(textBgColor));
                m.f0(defaultTextMaterial, text.b());
            }
        }
        String strokeColor = text.getStrokeColor();
        if (strokeColor != null) {
            if (strokeColor.length() > 0) {
                z18 = true;
            }
            if (z18) {
                str = strokeColor;
            }
            if (str != null) {
                m.H0(defaultTextMaterial, Color.parseColor(str));
                m.I0(defaultTextMaterial, text.getStrokeWidth());
                m.e0(defaultTextMaterial, true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00cc, code lost:
    
        r3 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void r(WinkStickerModel winkStickModel, WinkEditDataWrapper wrapper) {
        Map<String, WinkStickerModelExtra> linkedHashMap;
        Map mutableMap;
        MediaModel copy;
        WinkStickerModelExtra winkStickerModelExtra = new WinkStickerModelExtra(winkStickModel.getInitStickerScale(), winkStickModel.getDownScaleRecord(), winkStickModel.getOriginPointInView(), winkStickModel.getSizeInView(), winkStickModel.getCenterInView(), winkStickModel.getLeftTopInView(), winkStickModel.getRightBottomInView(), winkStickModel.getMaterial(), winkStickModel.getLastDownScaleX(), winkStickModel.getLastDownScaleY(), winkStickModel.getLastDownRotate(), winkStickModel.getNormalizedLeftTopInView(), winkStickModel.getNormalizedRightBottomInView(), winkStickModel.isTextSticker(), winkStickModel.getClickBoundsLeftTopInView(), winkStickModel.getClickBoundsRightBottomInView(), winkStickModel.getIsTraceSticker(), winkStickModel.getStickerTrackerResult(), winkStickModel.getEntityName(), 0, winkStickModel.getIsTimeRangeChangedByUser(), winkStickModel.getHasChooseTTS(), winkStickModel.getTtsAudioInfo());
        QLog.i("WinkMediaModelGenerator", 1, "[updateWrapperByStickModel] stickModel: " + winkStickModel);
        QLog.i("WinkMediaModelGenerator", 1, "[updateWrapperByStickModel] WinkStickerModelExtra: " + winkStickerModelExtra);
        for (WinkEditData winkEditData : wrapper.getEditDatas()) {
            Map<String, WinkStickerModel> stickerModelMap = winkEditData.getStickerModelMap();
            if (stickerModelMap == null) {
                stickerModelMap = new LinkedHashMap<>();
            }
            winkEditData.setStickerModelMap(stickerModelMap);
            Map<String, WinkStickerModel> stickerModelMap2 = winkEditData.getStickerModelMap();
            if (stickerModelMap2 != null) {
                stickerModelMap2.put(winkStickModel.id, winkStickModel);
            }
            Map<String, WinkStickerModelExtra> stickerExtraMap = winkEditData.getStickerExtraMap();
            if (stickerExtraMap == null || linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            linkedHashMap.put(winkStickModel.id, winkStickerModelExtra);
            winkEditData.setStickerExtraMap(linkedHashMap);
            mutableMap = MapsKt__MapsKt.toMutableMap(winkEditData.getMediaModel().stickers);
            mutableMap.put(winkStickModel.id, winkStickModel);
            copy = r5.copy((r39 & 1) != 0 ? r5.id : null, (r39 & 2) != 0 ? r5.name : null, (r39 & 4) != 0 ? r5.version : null, (r39 & 8) != 0 ? r5.createTime : null, (r39 & 16) != 0 ? r5.updateTime : null, (r39 & 32) != 0 ? r5.duration : null, (r39 & 64) != 0 ? r5.videos : null, (r39 & 128) != 0 ? r5.audios : null, (r39 & 256) != 0 ? r5.stickers : mutableMap, (r39 & 512) != 0 ? r5.backgroundModel : null, (r39 & 1024) != 0 ? r5.filterModels : null, (r39 & 2048) != 0 ? r5.specialEffects : null, (r39 & 4096) != 0 ? r5.transitions : null, (r39 & 8192) != 0 ? r5.templateModel : null, (r39 & 16384) != 0 ? r5.coverInfo : null, (r39 & 32768) != 0 ? r5.exportSetting : null, (r39 & 65536) != 0 ? r5.openHDR : null, (r39 & 131072) != 0 ? r5.hdrModels : null, (r39 & 262144) != 0 ? r5.smoothModels : null, (r39 & 524288) != 0 ? r5.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
            winkEditData.setMediaModel(copy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(@NotNull String str, int i3, int i16, @NotNull Context context, @NotNull String str2, @NotNull Continuation<? super Boolean> continuation) {
        WinkMediaModelGenerator$downloadAndSaveDataToWrapper$1 winkMediaModelGenerator$downloadAndSaveDataToWrapper$1;
        Object coroutine_suspended;
        int i17;
        MemeData memeData;
        Context context2;
        int i18;
        Object obj;
        WinkMediaModelGenerator winkMediaModelGenerator;
        String str3;
        int i19;
        if (continuation instanceof WinkMediaModelGenerator$downloadAndSaveDataToWrapper$1) {
            winkMediaModelGenerator$downloadAndSaveDataToWrapper$1 = (WinkMediaModelGenerator$downloadAndSaveDataToWrapper$1) continuation;
            int i26 = winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.label = i26 - Integer.MIN_VALUE;
                Object obj2 = winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.label;
                if (i17 == 0) {
                    if (i17 == 1) {
                        i18 = winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.I$1;
                        i19 = winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.I$0;
                        memeData = (MemeData) winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$3;
                        str3 = (String) winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$2;
                        Context context3 = (Context) winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$1;
                        winkMediaModelGenerator = (WinkMediaModelGenerator) winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        obj = obj2;
                        context2 = context3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    memeData = d.b(str).getMemeData();
                    winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$0 = this;
                    context2 = context;
                    winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$1 = context2;
                    winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$2 = str2;
                    winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.L$3 = memeData;
                    winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.I$0 = i3;
                    winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.I$1 = i16;
                    winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.label = 1;
                    Object l3 = l(memeData, winkMediaModelGenerator$downloadAndSaveDataToWrapper$1);
                    if (l3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i18 = i16;
                    obj = l3;
                    winkMediaModelGenerator = this;
                    str3 = str2;
                    i19 = i3;
                }
                if (!((Boolean) obj).booleanValue()) {
                    com.tencent.mobileqq.wink.editor.draft.a.h(winkMediaModelGenerator.j(context2, memeData, i19, i18, str3), WinkContext.INSTANCE.d().getMissionId());
                    return Boxing.boxBoolean(true);
                }
                QLog.e("WinkMediaModelGenerator", 1, "Download failed");
                return Boxing.boxBoolean(false);
            }
        }
        winkMediaModelGenerator$downloadAndSaveDataToWrapper$1 = new WinkMediaModelGenerator$downloadAndSaveDataToWrapper$1(this, continuation);
        Object obj22 = winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = winkMediaModelGenerator$downloadAndSaveDataToWrapper$1.label;
        if (i17 == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
