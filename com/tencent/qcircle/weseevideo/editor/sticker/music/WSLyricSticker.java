package com.tencent.qcircle.weseevideo.editor.sticker.music;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qcircle.oscar.app.GlobalContext;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricPlayStrategy;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.FrameModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerConfigModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.qcircle.weseevideo.model.effect.TAVStickerExKt;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0001H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010J\u0010\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/WSLyricSticker;", "Lcom/tencent/tavsticker/model/TAVSticker;", "()V", "mLyricAnimation", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/LyricPlayStrategy$LyricAnimation;", "mLyricWrapper", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/WSLyricSticker$LyricWrapper;", "computeLyricSentence", "", "presentationTimeMs", "", "computeProgress", "init", "loadLyricConfig", "Lcom/tencent/qcircle/weseevideo/model/effect/StickerConfigModel;", "path", "", "reloadFromSubtitleModel", "", "model", "Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;", "updateLyricConfig", "effectId", "effectPath", "configPath", "updateMusicData", "musicData", "Lcom/tencent/qcircle/weseevideo/model/data/MusicMaterialMetaDataBean;", "updateMusicStartTime", "startTime", "", "updateStickerText", "text", "Companion", "LyricWrapper", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class WSLyricSticker extends TAVSticker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_LOOP_END = "extra_loop_end";
    private static final String EXTRA_LOOP_START = "extra_loop_start";
    private static final String EXTRA_LOOP_TYPE = "extra_loop_type";
    private static final String EXTRA_LYRIC = "extra_lyric";
    private static final String EXTRA_LYRIC_EFFECT_ID = "extra_lyric_effect_id";
    private static final String EXTRA_LYRIC_EFFECT_PATH = "extra_lyric_effect_path";
    private static final String EXTRA_LYRIC_FORMAT = "extra_lyric_format_is_qrc";
    private static final String EXTRA_MUSIC_START = "extra_music_start";

    @NotNull
    public static final String LAYER_NAME = "lyrics";
    private static final String TAG = "WSLyricSticker";
    private LyricPlayStrategy.LyricAnimation mLyricAnimation;
    private LyricWrapper mLyricWrapper;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/WSLyricSticker$Companion;", "", "()V", "EXTRA_LOOP_END", "", "EXTRA_LOOP_START", "EXTRA_LOOP_TYPE", "EXTRA_LYRIC", "EXTRA_LYRIC_EFFECT_ID", "EXTRA_LYRIC_EFFECT_PATH", "EXTRA_LYRIC_FORMAT", "EXTRA_MUSIC_START", "LAYER_NAME", "TAG", "dumpToSubtitleModel", "Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;", "sticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "parseLyric", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Lyric;", "data", "Lcom/tencent/qcircle/weseevideo/model/data/MusicMaterialMetaDataBean;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final SubtitleModel dumpToSubtitleModel(@NotNull TAVSticker sticker) {
            Object firstOrNull;
            Intrinsics.checkParameterIsNotNull(sticker, "sticker");
            SubtitleModel subtitleModel = new SubtitleModel();
            subtitleModel.setAssetFilePath(sticker.getAssetFilePath());
            subtitleModel.setFilePath(sticker.getFilePath());
            subtitleModel.setCenterX(sticker.getCenterX());
            subtitleModel.setCenterY(sticker.getCenterY());
            subtitleModel.setScale(sticker.getScale());
            subtitleModel.setLayerIndex(sticker.getLayerIndex());
            subtitleModel.setRotate(sticker.getRotate());
            subtitleModel.setWidth(sticker.getWidth());
            subtitleModel.setHeight(sticker.getHeight());
            subtitleModel.editable = sticker.isEditable();
            subtitleModel.setMinScale(sticker.getMinScale());
            subtitleModel.setMaxScale(sticker.getMaxScale());
            String string = sticker.getExtraBundle().getString(WSLyricSticker.EXTRA_LYRIC_EFFECT_ID);
            String str = "";
            if (string == null) {
                string = "";
            }
            subtitleModel.setEffectId(string);
            String string2 = sticker.getExtraBundle().getString(WSLyricSticker.EXTRA_LYRIC_EFFECT_PATH);
            if (string2 == null) {
                string2 = "";
            }
            subtitleModel.setEffectPath(string2);
            String string3 = sticker.getExtraBundle().getString(WSLyricSticker.EXTRA_LYRIC);
            if (string3 != null) {
                str = string3;
            }
            subtitleModel.setLyric(str);
            subtitleModel.setLyricFormatIsQRC(sticker.getExtraBundle().getBoolean(WSLyricSticker.EXTRA_LYRIC_FORMAT));
            subtitleModel.setMusicStartTime(sticker.getExtraBundle().getInt(WSLyricSticker.EXTRA_MUSIC_START));
            subtitleModel.setLoopStart(sticker.getExtraBundle().getLong(WSLyricSticker.EXTRA_LOOP_START));
            subtitleModel.setLoopEnd(sticker.getExtraBundle().getLong(WSLyricSticker.EXTRA_LOOP_END));
            subtitleModel.setLoopType(sticker.getExtraBundle().getInt(WSLyricSticker.EXTRA_LOOP_TYPE));
            ArrayList<TAVStickerTextItem> stickerTextItems = sticker.getStickerTextItems();
            Intrinsics.checkExpressionValueIsNotNull(stickerTextItems, "sticker.stickerTextItems");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stickerTextItems);
            TAVStickerTextItem tAVStickerTextItem = (TAVStickerTextItem) firstOrNull;
            if (tAVStickerTextItem != null) {
                String fontPath = tAVStickerTextItem.getFontPath();
                Intrinsics.checkExpressionValueIsNotNull(fontPath, "it.fontPath");
                subtitleModel.setFontPath(fontPath);
            }
            return subtitleModel;
        }

        @Nullable
        public final Lyric parseLyric(@NotNull MusicMaterialMetaDataBean data) {
            boolean equals;
            Intrinsics.checkParameterIsNotNull(data, "data");
            String str = data.lyricFormat;
            if (str == null) {
                str = "";
            }
            equals = StringsKt__StringsJVMKt.equals(str, LyricParseHelper.LYRIC_FROMAT_QRC, true);
            return LyricParseHelper.parseTextToLyric(data.lyric, equals);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\bR\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qcircle/weseevideo/editor/sticker/music/WSLyricSticker$LyricWrapper;", "", "lyric", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Lyric;", "startTime", "", "(Lcom/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Lyric;I)V", "endTime", "", "getEndTime", "()J", "getLyric", "()Lcom/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Lyric;", "mCurrentSentence", "Lcom/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence;", "getStartTime", "()I", "setStartTime", "(I)V", "getCurrentSentence", "position", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class LyricWrapper {

        @Nullable
        private final Lyric lyric;
        private Sentence mCurrentSentence;
        private int startTime;

        public LyricWrapper(@Nullable Lyric lyric, int i3) {
            this.lyric = lyric;
            this.startTime = i3;
        }

        @Nullable
        public final Sentence getCurrentSentence(long position) {
            long j3;
            int i3;
            Lyric lyric;
            List<Sentence> sentenceList;
            Sentence sentence;
            int i16 = (int) (position + this.startTime);
            Sentence sentence2 = this.mCurrentSentence;
            long j16 = 0;
            if (sentence2 != null) {
                j3 = sentence2.mStartTime + sentence2.mDuration;
            } else {
                j3 = 0;
            }
            if (sentence2 != null) {
                j16 = sentence2.mStartTime;
            }
            long j17 = i16;
            if (j16 < j17 && j17 < j3) {
                return sentence2;
            }
            Lyric lyric2 = this.lyric;
            if (lyric2 != null) {
                i3 = lyric2.findLineNo(i16);
            } else {
                i3 = -1;
            }
            if (i3 == -1 || (lyric = this.lyric) == null || (sentenceList = lyric.getSentenceList()) == null || (sentence = sentenceList.get(i3)) == null) {
                return null;
            }
            this.mCurrentSentence = sentence;
            return sentence;
        }

        public final long getEndTime() {
            Sentence sentence;
            List<Sentence> sentenceList;
            Object lastOrNull;
            Lyric lyric = this.lyric;
            if (lyric != null && (sentenceList = lyric.getSentenceList()) != null) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) sentenceList);
                sentence = (Sentence) lastOrNull;
            } else {
                sentence = null;
            }
            if (sentence != null) {
                return sentence.mStartTime + sentence.mDuration;
            }
            return 0L;
        }

        @Nullable
        public final Lyric getLyric() {
            return this.lyric;
        }

        public final int getStartTime() {
            return this.startTime;
        }

        public final void setStartTime(int i3) {
            this.startTime = i3;
        }
    }

    public WSLyricSticker() {
        setAutoPlay(false);
    }

    private final double computeLyricSentence(long presentationTimeMs) {
        Sentence sentence;
        int i3;
        LyricWrapper lyricWrapper = this.mLyricWrapper;
        if (lyricWrapper != null) {
            sentence = lyricWrapper.getCurrentSentence(presentationTimeMs);
        } else {
            sentence = null;
        }
        LyricWrapper lyricWrapper2 = this.mLyricWrapper;
        if (lyricWrapper2 != null) {
            i3 = lyricWrapper2.getStartTime();
        } else {
            i3 = 0;
        }
        long j3 = presentationTimeMs + i3;
        if (sentence == null) {
            return 0.0d;
        }
        long j16 = sentence.mStartTime;
        if (j16 <= j3 && j16 + sentence.mDuration >= j3) {
            String str = sentence.mText;
            Intrinsics.checkExpressionValueIsNotNull(str, "sentence.mText");
            updateStickerText(str);
            if (this.mLyricAnimation == null) {
                return 0.0d;
            }
            return LyricPlayStrategy.INSTANCE.calculateProgress(j3 - sentence.mStartTime, sentence.mDuration, r12);
        }
        String str2 = sentence.mText;
        Intrinsics.checkExpressionValueIsNotNull(str2, "sentence.mText");
        updateStickerText(str2);
        return 0.0d;
    }

    @JvmStatic
    @NotNull
    public static final SubtitleModel dumpToSubtitleModel(@NotNull TAVSticker tAVSticker) {
        return INSTANCE.dumpToSubtitleModel(tAVSticker);
    }

    private final StickerConfigModel loadLyricConfig(String path) {
        try {
            return (StickerConfigModel) GsonUtils.json2Obj(FileUtils.load(GlobalContext.getContext(), path), StickerConfigModel.class);
        } catch (Exception e16) {
            Logger.e(e16);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        if (r1 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateStickerText(String text) {
        Object firstOrNull;
        TAVStickerTextItem tAVStickerTextItem;
        Object obj;
        ArrayList<TAVStickerTextItem> stickerTextItems = getStickerTextItems();
        if (stickerTextItems != null) {
            Iterator<T> it = stickerTextItems.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    TAVStickerTextItem it5 = (TAVStickerTextItem) obj;
                    Intrinsics.checkExpressionValueIsNotNull(it5, "it");
                    if (Intrinsics.areEqual(it5.getLayerName(), "lyrics")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            tAVStickerTextItem = (TAVStickerTextItem) obj;
        }
        ArrayList<TAVStickerTextItem> stickerTextItems2 = getStickerTextItems();
        Intrinsics.checkExpressionValueIsNotNull(stickerTextItems2, "stickerTextItems");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stickerTextItems2);
        tAVStickerTextItem = (TAVStickerTextItem) firstOrNull;
        if (tAVStickerTextItem != null && (!Intrinsics.areEqual(tAVStickerTextItem.getText(), text))) {
            tAVStickerTextItem.setText(text);
            updateTextData();
        }
    }

    @Override // com.tencent.tavsticker.model.TAVSticker
    public double computeProgress(long presentationTimeMs) {
        return computeLyricSentence(presentationTimeMs);
    }

    @Override // com.tencent.tavsticker.model.TAVSticker
    @NotNull
    public TAVSticker init() {
        TAVSticker superResult = super.init();
        Intrinsics.checkExpressionValueIsNotNull(superResult, "superResult");
        return superResult;
    }

    public final void reloadFromSubtitleModel(@NotNull SubtitleModel model) {
        Object firstOrNull;
        Object firstOrNull2;
        String str;
        Intrinsics.checkParameterIsNotNull(model, "model");
        setFilePath(model.getFilePath());
        setAssetFilePath(model.getAssetFilePath());
        setCenterX(model.getCenterX());
        setCenterY(model.getCenterY());
        setScale(model.getScale());
        setLayerIndex(model.getLayerIndex());
        setRotate(model.getRotate());
        setMinScale(model.getMinScale());
        setMaxScale(model.getMaxScale());
        TAVStickerExKt.setExtraStickerType(this, WsStickerConstant.StickerType.STICKER_LYRIC);
        try {
            init();
        } catch (Exception e16) {
            Logger.e(TAG, "reloadFromSubtitleModel: ", e16);
        }
        getExtraBundle().putLong(EXTRA_LOOP_START, model.getLoopStart());
        getExtraBundle().putLong(EXTRA_LOOP_END, model.getLoopEnd());
        getExtraBundle().putInt(EXTRA_LOOP_TYPE, model.getLoopType());
        getExtraBundle().putString(EXTRA_LYRIC, model.getLyric());
        getExtraBundle().putInt(EXTRA_MUSIC_START, model.getMusicStartTime());
        getExtraBundle().putBoolean(EXTRA_LYRIC_FORMAT, model.getLyricFormatIsQRC());
        getExtraBundle().putString(EXTRA_LYRIC_EFFECT_ID, model.getEffectId());
        getExtraBundle().putString(EXTRA_LYRIC_EFFECT_PATH, model.getEffectPath());
        this.mLyricAnimation = new LyricPlayStrategy.LyricAnimation(model.getLoopStart(), model.getLoopEnd(), durationTime() / 1000, model.getLoopType()).format();
        LyricWrapper lyricWrapper = new LyricWrapper(LyricParseHelper.parseTextToLyric(model.getLyric(), model.getLyricFormatIsQRC()), model.getMusicStartTime());
        this.mLyricWrapper = lyricWrapper;
        Sentence currentSentence = lyricWrapper.getCurrentSentence(0L);
        ArrayList<TAVStickerTextItem> stickerTextItems = getStickerTextItems();
        Intrinsics.checkExpressionValueIsNotNull(stickerTextItems, "stickerTextItems");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stickerTextItems);
        TAVStickerTextItem tAVStickerTextItem = (TAVStickerTextItem) firstOrNull;
        if (tAVStickerTextItem != null) {
            if (currentSentence != null) {
                str = currentSentence.mText;
            } else {
                str = null;
            }
            tAVStickerTextItem.setText(str);
        }
        ArrayList<TAVStickerTextItem> stickerTextItems2 = getStickerTextItems();
        Intrinsics.checkExpressionValueIsNotNull(stickerTextItems2, "stickerTextItems");
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stickerTextItems2);
        TAVStickerTextItem tAVStickerTextItem2 = (TAVStickerTextItem) firstOrNull2;
        if (tAVStickerTextItem2 != null) {
            tAVStickerTextItem2.setFontPath(model.getFontPath());
        }
    }

    public final void updateLyricConfig(@NotNull String effectId, @NotNull String effectPath, @NotNull String configPath) {
        float f16;
        float f17;
        long j3;
        long j16;
        int i3;
        long j17;
        long j18;
        FrameModel frame;
        FrameModel frame2;
        FrameModel frame3;
        Intrinsics.checkParameterIsNotNull(effectId, "effectId");
        Intrinsics.checkParameterIsNotNull(effectPath, "effectPath");
        Intrinsics.checkParameterIsNotNull(configPath, "configPath");
        Logger.i(TAG, "updateLyricConfig() called with: effectId = [" + effectId + "], effectPath = [" + effectPath + "], configPath = [" + configPath + ']');
        StickerConfigModel loadLyricConfig = loadLyricConfig(configPath);
        float f18 = 0.5f;
        if (loadLyricConfig != null && (frame3 = loadLyricConfig.getFrame()) != null) {
            f16 = frame3.getCenterX();
        } else {
            f16 = 0.5f;
        }
        setCenterX(f16);
        if (loadLyricConfig != null && (frame2 = loadLyricConfig.getFrame()) != null) {
            f17 = frame2.getCenterY();
        } else {
            f17 = 0.5f;
        }
        setCenterY(f17);
        if (loadLyricConfig != null && (frame = loadLyricConfig.getFrame()) != null) {
            f18 = frame.getScale();
        }
        setScale(f18);
        try {
            init();
        } catch (Exception e16) {
            Logger.e(TAG, "sticker initial failed, please check path && pagFile", e16);
        }
        TAVStickerExKt.setExtraStickerType(this, WsStickerConstant.StickerType.STICKER_LYRIC);
        if (loadLyricConfig != null) {
            j3 = loadLyricConfig.getLoopStart();
        } else {
            j3 = 0;
        }
        if (loadLyricConfig != null) {
            j16 = loadLyricConfig.getLoopEnd();
        } else {
            j16 = 0;
        }
        int i16 = 0;
        if (loadLyricConfig != null) {
            i3 = loadLyricConfig.getLoopType();
        } else {
            i3 = 0;
        }
        this.mLyricAnimation = new LyricPlayStrategy.LyricAnimation(j3, j16, durationTime() / 1000, i3).format();
        Bundle extraBundle = getExtraBundle();
        if (loadLyricConfig != null) {
            j17 = loadLyricConfig.getLoopStart();
        } else {
            j17 = 0;
        }
        extraBundle.putLong(EXTRA_LOOP_START, j17);
        Bundle extraBundle2 = getExtraBundle();
        if (loadLyricConfig != null) {
            j18 = loadLyricConfig.getLoopEnd();
        } else {
            j18 = 0;
        }
        extraBundle2.putLong(EXTRA_LOOP_END, j18);
        Bundle extraBundle3 = getExtraBundle();
        if (loadLyricConfig != null) {
            i16 = loadLyricConfig.getLoopType();
        }
        extraBundle3.putInt(EXTRA_LOOP_TYPE, i16);
        getExtraBundle().putString(EXTRA_LYRIC_EFFECT_ID, effectId);
        getExtraBundle().putString(EXTRA_LYRIC_EFFECT_PATH, effectPath);
    }

    public final void updateMusicData(@Nullable MusicMaterialMetaDataBean musicData) {
        String str;
        boolean equals;
        int i3;
        String str2 = null;
        if (musicData != null && !TextUtils.isEmpty(musicData.lyric)) {
            this.mLyricWrapper = new LyricWrapper(INSTANCE.parseLyric(musicData), musicData.startTime);
        } else {
            this.mLyricWrapper = null;
        }
        if (musicData == null || (str = musicData.lyricFormat) == null) {
            str = "";
        }
        equals = StringsKt__StringsJVMKt.equals(str, LyricParseHelper.LYRIC_FROMAT_QRC, true);
        Bundle extraBundle = getExtraBundle();
        if (musicData != null) {
            i3 = musicData.startTime;
        } else {
            i3 = 0;
        }
        extraBundle.putInt(EXTRA_MUSIC_START, i3);
        getExtraBundle().putBoolean(EXTRA_LYRIC_FORMAT, equals);
        Bundle extraBundle2 = getExtraBundle();
        if (musicData != null) {
            str2 = musicData.lyric;
        }
        extraBundle2.putString(EXTRA_LYRIC, str2);
    }

    public final void updateMusicStartTime(int startTime) {
        LyricWrapper lyricWrapper = this.mLyricWrapper;
        if (lyricWrapper != null) {
            lyricWrapper.setStartTime(startTime);
        }
    }
}
