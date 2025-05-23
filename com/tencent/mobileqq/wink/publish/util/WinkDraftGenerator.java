package com.tencent.mobileqq.wink.publish.util;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.JsonObject;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.dailysign.DailySignConfig;
import com.tencent.mobileqq.wink.dailysign.af;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.recommend.WinkMusicRecommender;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicInfo;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.TemplateFixedClipConfig;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.TemplateMusicInfoParseResult;
import com.tencent.mobileqq.wink.editor.util.m;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.utils.o;
import com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.utils.LiveDataExtKt;
import e93.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k93.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import mqq.app.MobileQQ;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.LightConstants;
import org.light.lightAssetKit.components.Size;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001RB\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ3\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\r\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J0\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J$\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0002J\u0018\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\bH\u0002J\u001d\u0010/\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0018J\u001d\u00101\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102JL\u0010<\u001a\u00020;2\u0006\u00103\u001a\u00020\u00162\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112!\u0010:\u001a\u001d\u0012\u0013\u0012\u001106\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020-05H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010?J\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00160B2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0011J}\u0010G\u001a\u00020;2\u0006\u00103\u001a\u00020\u00162\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00162!\u0010:\u001a\u001d\u0012\u0013\u0012\u001106\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020-052!\u0010F\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020-05H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010HJ8\u0010N\u001a\u00020M2\u0006\u0010I\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\b\b\u0002\u0010K\u001a\u00020J2\b\b\u0002\u0010L\u001a\u00020JJ\u000e\u0010O\u001a\u00020*2\u0006\u0010)\u001a\u00020(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/WinkDraftGenerator;", "", "Lcom/tencent/mobileqq/wink/dailysign/af;", "dailySignInfo", "Lkotlin/Triple;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", h.F, "(Lcom/tencent/mobileqq/wink/dailysign/af;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/wink/editor/recommend/WinkMusicRecommender$a;", "recommendData", "winkEditDataWrapper", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "f", "(Lcom/tencent/mobileqq/wink/editor/recommend/WinkMusicRecommender$a;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfo;", "musicInfo", "g", "(Ljava/util/List;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "winkEditData", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "musicInfoWrapper", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "musicStuckInfo", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/h;", "templateMusicInfoParseResult", "Lcom/tencent/videocut/model/MediaClip;", DomainData.DOMAIN_NAME, "", "durationMs", "", "Lcom/tencent/videocut/model/AudioModel;", "k", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "Lcom/tencent/videocut/model/BackgroundModel;", ReportConstant.COSTREPORT_PREFIX, "_missionId", "", "p", "e", "songMid", "o", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", QAdVrReportParams.ParamKey.MEDIA, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/winkpublish/report/OneClickPublishingFeedErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "onError", "Lcom/tencent/mobileqq/wink/publish/util/WinkDraftGenerator$a;", "j", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "Ljava/util/ArrayList;", "u", "templateFilePath", "editData", "processEditData", "i", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "missionId", "", "savePublishDraft", "draftIsSaveUploading", "Lk93/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkDraftGenerator {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkDraftGenerator f325956a = new WinkDraftGenerator();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/WinkDraftGenerator$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "missionId", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editDataWrapper", "Lk93/c;", "c", "Lk93/c;", "()Lk93/c;", "publishDraft", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lk93/c;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class DraftData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String missionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WinkEditDataWrapper editDataWrapper;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final k93.c publishDraft;

        public DraftData(@NotNull String missionId, @NotNull WinkEditDataWrapper editDataWrapper, @NotNull k93.c publishDraft) {
            Intrinsics.checkNotNullParameter(missionId, "missionId");
            Intrinsics.checkNotNullParameter(editDataWrapper, "editDataWrapper");
            Intrinsics.checkNotNullParameter(publishDraft, "publishDraft");
            this.missionId = missionId;
            this.editDataWrapper = editDataWrapper;
            this.publishDraft = publishDraft;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final WinkEditDataWrapper getEditDataWrapper() {
            return this.editDataWrapper;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getMissionId() {
            return this.missionId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final k93.c getPublishDraft() {
            return this.publishDraft;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DraftData)) {
                return false;
            }
            DraftData draftData = (DraftData) other;
            if (Intrinsics.areEqual(this.missionId, draftData.missionId) && Intrinsics.areEqual(this.editDataWrapper, draftData.editDataWrapper) && Intrinsics.areEqual(this.publishDraft, draftData.publishDraft)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.missionId.hashCode() * 31) + this.editDataWrapper.hashCode()) * 31) + this.publishDraft.hashCode();
        }

        @NotNull
        public String toString() {
            return "DraftData(missionId=" + this.missionId + ", editDataWrapper=" + this.editDataWrapper + ", publishDraft=" + this.publishDraft + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/publish/util/WinkDraftGenerator$b", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicHelper$b;", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "editorMusicInfo", "", "succeeded", "", "localPath", "", "a", "", "progress", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkEditorMusicHelper.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f325960a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super String> continuation) {
            this.f325960a = continuation;
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.b
        public void a(@NotNull WinkEditorMusicInfo editorMusicInfo, boolean succeeded, @NotNull String localPath) {
            Intrinsics.checkNotNullParameter(editorMusicInfo, "editorMusicInfo");
            Intrinsics.checkNotNullParameter(localPath, "localPath");
            if (succeeded) {
                this.f325960a.resumeWith(Result.m476constructorimpl(localPath));
            } else {
                this.f325960a.resumeWith(Result.m476constructorimpl(null));
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.b
        public void b(@NotNull WinkEditorMusicInfo editorMusicInfo, int progress) {
            Intrinsics.checkNotNullParameter(editorMusicInfo, "editorMusicInfo");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/publish/util/WinkDraftGenerator$c", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements Observer<List<? extends MetaCategory>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<List<QQCircleSmartMatchMusic$MusicInfo>> f325961d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "baseRequest", "", "isSuccess", "", "retCode", "", "errMsg", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfoRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lqqcircle/QQCircleSmartMatchMusic$MusicInfoRsp;)V"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a<T> implements VSDispatchObserver.OnVSRspCallBack {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Continuation<List<QQCircleSmartMatchMusic$MusicInfo>> f325963b;

            /* JADX WARN: Multi-variable type inference failed */
            a(Continuation<? super List<QQCircleSmartMatchMusic$MusicInfo>> continuation) {
                this.f325963b = continuation;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
                PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
                if (z16 && qQCircleSmartMatchMusic$MusicInfoRsp != null && (pBRepeatMessageField = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo) != null) {
                    c cVar = c.this;
                    Continuation<List<QQCircleSmartMatchMusic$MusicInfo>> continuation = this.f325963b;
                    List<QQCircleSmartMatchMusic$MusicInfo> editorMusicList = pBRepeatMessageField.get();
                    WinkEditorResourceManager.a1().K0().removeObserver(cVar);
                    w53.b.a("WinkDraftGenerator", "genDailySignWrapper editorMusicList: " + editorMusicList);
                    Intrinsics.checkNotNullExpressionValue(editorMusicList, "editorMusicList");
                    if (!editorMusicList.isEmpty()) {
                        editorMusicList.add(0, editorMusicList.remove(RandomKt.Random(System.currentTimeMillis()).nextInt(editorMusicList.size())));
                    }
                    continuation.resumeWith(Result.m476constructorimpl(editorMusicList));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super List<QQCircleSmartMatchMusic$MusicInfo>> continuation) {
            this.f325961d = continuation;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable List<MetaCategory> metaCategories) {
            WinkEditorMusicHelper.C(WinkDraftGenerator.f325956a.u(metaCategories), new a(this.f325961d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfoRsp;", "musicInfoRsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lqqcircle/QQCircleSmartMatchMusic$MusicInfoRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<WinkEditorMusicInfo> f325964a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super WinkEditorMusicInfo> continuation) {
            this.f325964a = continuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
            Object firstOrNull;
            List<QQCircleSmartMatchMusic$MusicInfo> list = null;
            if (qQCircleSmartMatchMusic$MusicInfoRsp == null) {
                this.f325964a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo;
            if (pBRepeatMessageField != null) {
                list = pBRepeatMessageField.get();
            }
            List<WinkEditorMusicInfo> musics = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(list), "", "");
            Continuation<WinkEditorMusicInfo> continuation = this.f325964a;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(musics, "musics");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) musics);
            continuation.resumeWith(Result.m476constructorimpl(firstOrNull));
        }
    }

    WinkDraftGenerator() {
    }

    private final Object e(WinkEditorMusicInfo winkEditorMusicInfo, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        String o16 = WinkEditorMusicHelper.o(winkEditorMusicInfo);
        Intrinsics.checkNotNullExpressionValue(o16, "getMusicLocalPath(musicInfo)");
        if (WinkEditorMusicHelper.p(o16)) {
            safeContinuation.resumeWith(Result.m476constructorimpl(o16));
        } else {
            WinkEditorMusicHelper.n(MobileQQ.sMobileQQ.peekAppRuntime(), winkEditorMusicInfo, winkEditorMusicInfo.t(), o16, new b(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(WinkMusicRecommender.a aVar, WinkEditDataWrapper winkEditDataWrapper, Continuation<? super WinkEditorMusicInfo> continuation) {
        WinkDraftGenerator$fillMusicInfoToEditData$1 winkDraftGenerator$fillMusicInfoToEditData$1;
        Object coroutine_suspended;
        int i3;
        Object firstOrNull;
        WinkEditorMusicInfo winkEditorMusicInfo;
        Object obj;
        QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo;
        WinkEditDataWrapper winkEditDataWrapper2;
        String str;
        Object firstOrNull2;
        int collectionSizeOrDefault;
        long sumOfLong;
        MediaModel copy;
        long j3;
        if (continuation instanceof WinkDraftGenerator$fillMusicInfoToEditData$1) {
            winkDraftGenerator$fillMusicInfoToEditData$1 = (WinkDraftGenerator$fillMusicInfoToEditData$1) continuation;
            int i16 = winkDraftGenerator$fillMusicInfoToEditData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkDraftGenerator$fillMusicInfoToEditData$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = winkDraftGenerator$fillMusicInfoToEditData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkDraftGenerator$fillMusicInfoToEditData$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        qQCircleSmartMatchMusic$MusicStuckPointInfo = (QQCircleSmartMatchMusic$MusicStuckPointInfo) winkDraftGenerator$fillMusicInfoToEditData$1.L$2;
                        winkEditorMusicInfo = (WinkEditorMusicInfo) winkDraftGenerator$fillMusicInfoToEditData$1.L$1;
                        winkEditDataWrapper2 = (WinkEditDataWrapper) winkDraftGenerator$fillMusicInfoToEditData$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    List<VsMusicItemInfo> l3 = WinkEditorMusicHelper.l(aVar.b());
                    Intrinsics.checkNotNullExpressionValue(l3, "convertToMusicItemList(recommendData.musicInfo)");
                    if (l3.isEmpty()) {
                        w53.b.f("WinkDraftGenerator", "[fillMusicInfoToEditData] musicItems is null");
                        return null;
                    }
                    List<WinkEditorMusicInfo> j16 = WinkEditorMusicHelper.j(l3, "", "");
                    Intrinsics.checkNotNullExpressionValue(j16, "assembleEditorMusicInfoList(musicItems, \"\", \"\")");
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) j16);
                    winkEditorMusicInfo = (WinkEditorMusicInfo) firstOrNull;
                    if (winkEditorMusicInfo == null) {
                        w53.b.f("WinkDraftGenerator", "[fillMusicInfoToEditData] firstRecommendMusic is null");
                        return null;
                    }
                    if (aVar.c() == null) {
                        w53.b.f("WinkDraftGenerator", "[fillMusicInfoToEditData] recommendData.musicStuckInfo is null");
                        return null;
                    }
                    String p16 = winkEditorMusicInfo.p();
                    Intrinsics.checkNotNullExpressionValue(p16, "firstRecommendMusic.songMid");
                    Iterator<T> it = aVar.c().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(((QQCircleSmartMatchMusic$MusicStuckPointInfo) obj).mid.get(), p16)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo2 = (QQCircleSmartMatchMusic$MusicStuckPointInfo) obj;
                    if (qQCircleSmartMatchMusic$MusicStuckPointInfo2 == null) {
                        return null;
                    }
                    winkDraftGenerator$fillMusicInfoToEditData$1.L$0 = winkEditDataWrapper;
                    winkDraftGenerator$fillMusicInfoToEditData$1.L$1 = winkEditorMusicInfo;
                    winkDraftGenerator$fillMusicInfoToEditData$1.L$2 = qQCircleSmartMatchMusic$MusicStuckPointInfo2;
                    winkDraftGenerator$fillMusicInfoToEditData$1.label = 1;
                    Object m3 = m(winkEditorMusicInfo, winkDraftGenerator$fillMusicInfoToEditData$1);
                    if (m3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQCircleSmartMatchMusic$MusicStuckPointInfo = qQCircleSmartMatchMusic$MusicStuckPointInfo2;
                    obj2 = m3;
                    winkEditDataWrapper2 = winkEditDataWrapper;
                }
                str = (String) obj2;
                if (str != null) {
                    return null;
                }
                MusicInfoWrapper musicInfoWrapper = new MusicInfoWrapper(winkEditorMusicInfo, str, winkEditorMusicInfo.s(), ((int) winkEditDataWrapper2.getDuration()) / 1000, false, 16, null);
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) winkEditDataWrapper2.getEditDatas());
                WinkEditData winkEditData = (WinkEditData) firstOrNull2;
                if (winkEditData != null) {
                    List<MediaClip> n3 = f325956a.n(winkEditData, musicInfoWrapper, qQCircleSmartMatchMusic$MusicStuckPointInfo, com.tencent.mobileqq.wink.editor.smartclip.c.n(winkEditDataWrapper2.getTemplateFilePath()));
                    List<MediaClip> list = n3;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it5 = list.iterator();
                    while (it5.hasNext()) {
                        ResourceModel resourceModel = ((MediaClip) it5.next()).resource;
                        if (resourceModel != null) {
                            j3 = resourceModel.selectDuration;
                        } else {
                            j3 = 0;
                        }
                        arrayList.add(Boxing.boxLong(j3));
                    }
                    sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList);
                    copy = r9.copy((r39 & 1) != 0 ? r9.id : null, (r39 & 2) != 0 ? r9.name : null, (r39 & 4) != 0 ? r9.version : null, (r39 & 8) != 0 ? r9.createTime : null, (r39 & 16) != 0 ? r9.updateTime : null, (r39 & 32) != 0 ? r9.duration : null, (r39 & 64) != 0 ? r9.videos : n3, (r39 & 128) != 0 ? r9.audios : f325956a.k(musicInfoWrapper, sumOfLong), (r39 & 256) != 0 ? r9.stickers : null, (r39 & 512) != 0 ? r9.backgroundModel : null, (r39 & 1024) != 0 ? r9.filterModels : null, (r39 & 2048) != 0 ? r9.specialEffects : null, (r39 & 4096) != 0 ? r9.transitions : null, (r39 & 8192) != 0 ? r9.templateModel : null, (r39 & 16384) != 0 ? r9.coverInfo : null, (r39 & 32768) != 0 ? r9.exportSetting : null, (r39 & 65536) != 0 ? r9.openHDR : null, (r39 & 131072) != 0 ? r9.hdrModels : null, (r39 & 262144) != 0 ? r9.smoothModels : null, (r39 & 524288) != 0 ? r9.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
                    winkEditData.setMediaModel(copy);
                    winkEditData.setDurationUs(sumOfLong);
                    winkEditDataWrapper2.setDuration(sumOfLong);
                }
                winkEditDataWrapper2.setMusicId(Boxing.boxLong(winkEditorMusicInfo.o()));
                winkEditDataWrapper2.setMusicName(winkEditorMusicInfo.q());
                winkEditDataWrapper2.setMusicPath(winkEditorMusicInfo.r());
                winkEditDataWrapper2.setMusicDuration(Boxing.boxInt(winkEditorMusicInfo.n()));
                winkEditDataWrapper2.setSelectMusicStart(Boxing.boxInt(winkEditorMusicInfo.s()));
                winkEditDataWrapper2.setSelectMusicMid(winkEditorMusicInfo.p());
                winkEditDataWrapper2.setBgmVolume(1.0f);
                winkEditDataWrapper2.setBgmVolumeType(MusicVolumeControlViewModel.VolumeType.BGM);
                winkEditDataWrapper2.setOriginVolume(0.15f);
                winkEditDataWrapper2.setSmartClipActive(true);
                return winkEditorMusicInfo;
            }
        }
        winkDraftGenerator$fillMusicInfoToEditData$1 = new WinkDraftGenerator$fillMusicInfoToEditData$1(this, continuation);
        Object obj22 = winkDraftGenerator$fillMusicInfoToEditData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkDraftGenerator$fillMusicInfoToEditData$1.label;
        if (i3 == 0) {
        }
        str = (String) obj22;
        if (str != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(List<QQCircleSmartMatchMusic$MusicInfo> list, WinkEditDataWrapper winkEditDataWrapper, Continuation<? super WinkEditorMusicInfo> continuation) {
        WinkDraftGenerator$fillMusicInfoToEditData$3 winkDraftGenerator$fillMusicInfoToEditData$3;
        Object coroutine_suspended;
        int i3;
        Object firstOrNull;
        WinkEditorMusicInfo winkEditorMusicInfo;
        WinkEditDataWrapper winkEditDataWrapper2;
        String str;
        Object firstOrNull2;
        MediaModel copy;
        if (continuation instanceof WinkDraftGenerator$fillMusicInfoToEditData$3) {
            winkDraftGenerator$fillMusicInfoToEditData$3 = (WinkDraftGenerator$fillMusicInfoToEditData$3) continuation;
            int i16 = winkDraftGenerator$fillMusicInfoToEditData$3.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkDraftGenerator$fillMusicInfoToEditData$3.label = i16 - Integer.MIN_VALUE;
                Object obj = winkDraftGenerator$fillMusicInfoToEditData$3.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkDraftGenerator$fillMusicInfoToEditData$3.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        winkEditorMusicInfo = (WinkEditorMusicInfo) winkDraftGenerator$fillMusicInfoToEditData$3.L$1;
                        winkEditDataWrapper2 = (WinkEditDataWrapper) winkDraftGenerator$fillMusicInfoToEditData$3.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<WinkEditorMusicInfo> j3 = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(list), "", "");
                    Intrinsics.checkNotNullExpressionValue(j3, "assembleEditorMusicInfoL\u2026mList(musicInfo), \"\", \"\")");
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) j3);
                    WinkEditorMusicInfo winkEditorMusicInfo2 = (WinkEditorMusicInfo) firstOrNull;
                    if (winkEditorMusicInfo2 == null) {
                        return null;
                    }
                    winkDraftGenerator$fillMusicInfoToEditData$3.L$0 = winkEditDataWrapper;
                    winkDraftGenerator$fillMusicInfoToEditData$3.L$1 = winkEditorMusicInfo2;
                    winkDraftGenerator$fillMusicInfoToEditData$3.label = 1;
                    Object m3 = m(winkEditorMusicInfo2, winkDraftGenerator$fillMusicInfoToEditData$3);
                    if (m3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkEditorMusicInfo = winkEditorMusicInfo2;
                    obj = m3;
                    winkEditDataWrapper2 = winkEditDataWrapper;
                }
                str = (String) obj;
                if (str != null) {
                    return null;
                }
                long j16 = 1000;
                long duration = winkEditDataWrapper2.getDuration() / j16;
                MusicInfoWrapper musicInfoWrapper = new MusicInfoWrapper(winkEditorMusicInfo, str, winkEditorMusicInfo.s(), (int) duration, false, 16, null);
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) winkEditDataWrapper2.getEditDatas());
                WinkEditData winkEditData = (WinkEditData) firstOrNull2;
                if (winkEditData != null) {
                    copy = r16.copy((r39 & 1) != 0 ? r16.id : null, (r39 & 2) != 0 ? r16.name : null, (r39 & 4) != 0 ? r16.version : null, (r39 & 8) != 0 ? r16.createTime : null, (r39 & 16) != 0 ? r16.updateTime : null, (r39 & 32) != 0 ? r16.duration : null, (r39 & 64) != 0 ? r16.videos : null, (r39 & 128) != 0 ? r16.audios : f325956a.k(musicInfoWrapper, duration * j16), (r39 & 256) != 0 ? r16.stickers : null, (r39 & 512) != 0 ? r16.backgroundModel : null, (r39 & 1024) != 0 ? r16.filterModels : null, (r39 & 2048) != 0 ? r16.specialEffects : null, (r39 & 4096) != 0 ? r16.transitions : null, (r39 & 8192) != 0 ? r16.templateModel : null, (r39 & 16384) != 0 ? r16.coverInfo : null, (r39 & 32768) != 0 ? r16.exportSetting : null, (r39 & 65536) != 0 ? r16.openHDR : null, (r39 & 131072) != 0 ? r16.hdrModels : null, (r39 & 262144) != 0 ? r16.smoothModels : null, (r39 & 524288) != 0 ? r16.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
                    winkEditData.setMediaModel(copy);
                }
                winkEditDataWrapper2.setMusicId(Boxing.boxLong(winkEditorMusicInfo.o()));
                winkEditDataWrapper2.setMusicName(winkEditorMusicInfo.q());
                winkEditDataWrapper2.setSelectMusicStart(Boxing.boxInt(winkEditorMusicInfo.s()));
                winkEditDataWrapper2.setSelectMusicMid(winkEditorMusicInfo.p());
                winkEditDataWrapper2.setBgmVolume(1.0f);
                winkEditDataWrapper2.setBgmVolumeType(MusicVolumeControlViewModel.VolumeType.BGM);
                winkEditDataWrapper2.setOriginVolume(0.15f);
                return winkEditorMusicInfo;
            }
        }
        winkDraftGenerator$fillMusicInfoToEditData$3 = new WinkDraftGenerator$fillMusicInfoToEditData$3(this, continuation);
        Object obj2 = winkDraftGenerator$fillMusicInfoToEditData$3.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkDraftGenerator$fillMusicInfoToEditData$3.label;
        if (i3 == 0) {
        }
        str = (String) obj2;
        if (str != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x032d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0316 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(af afVar, Continuation<? super Triple<? extends List<LocalMediaInfo>, DailySignConfig, WinkEditDataWrapper>> continuation) {
        WinkDraftGenerator$genDailySignWrapper$1 winkDraftGenerator$genDailySignWrapper$1;
        Object coroutine_suspended;
        int i3;
        DailySignConfig dailySignConfig;
        WinkDraftGenerator winkDraftGenerator;
        List<String> mediaPath;
        Map<String, String> assetDataMap;
        String textContent;
        HashMap hashMapOf;
        List mutableList;
        int collectionSizeOrDefault;
        WinkEditDataWrapper copy$default;
        Object l3;
        List list;
        BackgroundModel backgroundModel;
        MediaModel copy;
        Map mutableMapOf;
        WinkEditData copy2;
        BackgroundModel copy3;
        DailySignConfig dailySignConfig2;
        WinkEditDataWrapper winkEditDataWrapper;
        List list2;
        if (continuation instanceof WinkDraftGenerator$genDailySignWrapper$1) {
            winkDraftGenerator$genDailySignWrapper$1 = (WinkDraftGenerator$genDailySignWrapper$1) continuation;
            int i16 = winkDraftGenerator$genDailySignWrapper$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkDraftGenerator$genDailySignWrapper$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkDraftGenerator$genDailySignWrapper$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkDraftGenerator$genDailySignWrapper$1.label;
                int i17 = 1;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                winkEditDataWrapper = (WinkEditDataWrapper) winkDraftGenerator$genDailySignWrapper$1.L$2;
                                list2 = (List) winkDraftGenerator$genDailySignWrapper$1.L$1;
                                dailySignConfig2 = (DailySignConfig) winkDraftGenerator$genDailySignWrapper$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                return new Triple(list2, dailySignConfig2, winkEditDataWrapper);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        WinkEditDataWrapper winkEditDataWrapper2 = (WinkEditDataWrapper) winkDraftGenerator$genDailySignWrapper$1.L$3;
                        list = (List) winkDraftGenerator$genDailySignWrapper$1.L$2;
                        DailySignConfig dailySignConfig3 = (DailySignConfig) winkDraftGenerator$genDailySignWrapper$1.L$1;
                        winkDraftGenerator = (WinkDraftGenerator) winkDraftGenerator$genDailySignWrapper$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        copy$default = winkEditDataWrapper2;
                        dailySignConfig = dailySignConfig3;
                        winkDraftGenerator$genDailySignWrapper$1.L$0 = dailySignConfig;
                        winkDraftGenerator$genDailySignWrapper$1.L$1 = list;
                        winkDraftGenerator$genDailySignWrapper$1.L$2 = copy$default;
                        winkDraftGenerator$genDailySignWrapper$1.L$3 = null;
                        winkDraftGenerator$genDailySignWrapper$1.label = 3;
                        if (winkDraftGenerator.g((List) obj, copy$default, winkDraftGenerator$genDailySignWrapper$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dailySignConfig2 = dailySignConfig;
                        winkEditDataWrapper = copy$default;
                        list2 = list;
                        return new Triple(list2, dailySignConfig2, winkEditDataWrapper);
                    }
                    dailySignConfig = (DailySignConfig) winkDraftGenerator$genDailySignWrapper$1.L$1;
                    winkDraftGenerator = (WinkDraftGenerator) winkDraftGenerator$genDailySignWrapper$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    dailySignConfig = new DailySignConfig(afVar);
                    dailySignConfig.setFrom("QZONE");
                    WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
                    winkDraftGenerator$genDailySignWrapper$1.L$0 = this;
                    winkDraftGenerator$genDailySignWrapper$1.L$1 = dailySignConfig;
                    winkDraftGenerator$genDailySignWrapper$1.label = 1;
                    if (winkMaterialResourceLoader.h(dailySignConfig, winkDraftGenerator$genDailySignWrapper$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkDraftGenerator = this;
                }
                mediaPath = dailySignConfig.getMediaPath();
                Intrinsics.checkNotNull(mediaPath);
                MetaMaterial metaMaterial = dailySignConfig.getMetaMaterial();
                Intrinsics.checkNotNull(metaMaterial);
                String str = com.tencent.mobileqq.wink.editor.c.g0(metaMaterial) + File.separator + TemplateBean.TEMPLATE_JSON;
                assetDataMap = dailySignConfig.getAssetDataMap();
                HashMap hashMap = new HashMap();
                String v16 = WinkEditorResourceManager.a1().v1();
                Intrinsics.checkNotNullExpressionValue(v16, "getInstance().qqNickName");
                hashMap.put("nickNameForQQ", v16);
                hashMap.put("yearNumber", String.valueOf(Calendar.getInstance().get(1)));
                DailySignConfig.Companion companion = DailySignConfig.INSTANCE;
                hashMap.put("monthNumber", companion.a(Calendar.getInstance().get(2) + 1));
                hashMap.put("dayNumber", companion.a(Calendar.getInstance().get(5)));
                hashMap.put("weekString", com.tencent.mobileqq.wink.editor.sticker.selector.adapter.a.INSTANCE.a(Calendar.getInstance().get(7) - 1));
                if (assetDataMap != null) {
                    hashMap.putAll(assetDataMap);
                }
                textContent = dailySignConfig.getTextContent();
                if (textContent != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("text", textContent);
                    jsonObject.addProperty("height", Boxing.boxInt(90));
                }
                if (dailySignConfig.getMediaPath() != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("path", mediaPath.get(0));
                }
                hashMap.put("startExport", "true");
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, new JSONObject(hashMap).toString()));
                if (mediaPath.isEmpty()) {
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) o.f326724a.i(mediaPath));
                } else {
                    mutableList = new ArrayList();
                }
                WinkEditDataWrapper f16 = com.tencent.mobileqq.wink.editor.draft.c.f(new ArrayList(mutableList), 0, 0, 6, null);
                String missionId = dailySignConfig.getMissionId();
                ArrayList<WinkEditData> editDatas = f16.getEditDatas();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (WinkEditData winkEditData : editDatas) {
                    BackgroundModel backgroundModel2 = winkEditData.getMediaModel().backgroundModel;
                    if (backgroundModel2 != null) {
                        copy3 = backgroundModel2.copy((r24 & 1) != 0 ? backgroundModel2.id : null, (r24 & 2) != 0 ? backgroundModel2.renderSize : new SizeF(1080.0f, 1920.0f, null, 4, null), (r24 & 4) != 0 ? backgroundModel2.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel2.bgColor : null, (r24 & 16) != 0 ? backgroundModel2.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel2.ratioType : null, (r24 & 64) != 0 ? backgroundModel2.resPack : null, (r24 & 128) != 0 ? backgroundModel2.categoryId : null, (r24 & 256) != 0 ? backgroundModel2.fillScale : 1.0f, (r24 & 512) != 0 ? backgroundModel2.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel2.unknownFields() : null);
                        backgroundModel = copy3;
                    } else {
                        backgroundModel = null;
                    }
                    copy = r21.copy((r39 & 1) != 0 ? r21.id : null, (r39 & 2) != 0 ? r21.name : null, (r39 & 4) != 0 ? r21.version : null, (r39 & 8) != 0 ? r21.createTime : null, (r39 & 16) != 0 ? r21.updateTime : null, (r39 & 32) != 0 ? r21.duration : null, (r39 & 64) != 0 ? r21.videos : null, (r39 & 128) != 0 ? r21.audios : null, (r39 & 256) != 0 ? r21.stickers : null, (r39 & 512) != 0 ? r21.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? r21.filterModels : null, (r39 & 2048) != 0 ? r21.specialEffects : null, (r39 & 4096) != 0 ? r21.transitions : null, (r39 & 8192) != 0 ? r21.templateModel : null, (r39 & 16384) != 0 ? r21.coverInfo : null, (r39 & 32768) != 0 ? r21.exportSetting : null, (r39 & 65536) != 0 ? r21.openHDR : null, (r39 & 131072) != 0 ? r21.hdrModels : null, (r39 & 262144) != 0 ? r21.smoothModels : null, (r39 & 524288) != 0 ? r21.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
                    Pair[] pairArr = new Pair[i17];
                    MetaMaterial metaMaterial2 = dailySignConfig.getMetaMaterial();
                    Intrinsics.checkNotNull(metaMaterial2);
                    String str2 = metaMaterial2.f30533id;
                    MetaMaterial metaMaterial3 = dailySignConfig.getMetaMaterial();
                    Intrinsics.checkNotNull(metaMaterial3);
                    pairArr[0] = new Pair(str2, metaMaterial3);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    copy2 = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : copy, (r37 & 2) != 0 ? winkEditData.durationUs : 0L, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : mutableMapOf, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : hashMapOf, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
                    arrayList.add(copy2);
                    i17 = 1;
                }
                copy$default = WinkEditDataWrapper.copy$default(f16, missionId, null, new ArrayList(arrayList), null, str, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -22, 4095, null);
                w53.b.a("WinkDraftGenerator", "genDailySignWrapper: " + com.tencent.mobileqq.wink.editor.c.g0(metaMaterial));
                winkDraftGenerator$genDailySignWrapper$1.L$0 = winkDraftGenerator;
                winkDraftGenerator$genDailySignWrapper$1.L$1 = dailySignConfig;
                winkDraftGenerator$genDailySignWrapper$1.L$2 = mutableList;
                winkDraftGenerator$genDailySignWrapper$1.L$3 = copy$default;
                winkDraftGenerator$genDailySignWrapper$1.label = 2;
                l3 = winkDraftGenerator.l(winkDraftGenerator$genDailySignWrapper$1);
                if (l3 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = mutableList;
                obj = l3;
                winkDraftGenerator$genDailySignWrapper$1.L$0 = dailySignConfig;
                winkDraftGenerator$genDailySignWrapper$1.L$1 = list;
                winkDraftGenerator$genDailySignWrapper$1.L$2 = copy$default;
                winkDraftGenerator$genDailySignWrapper$1.L$3 = null;
                winkDraftGenerator$genDailySignWrapper$1.label = 3;
                if (winkDraftGenerator.g((List) obj, copy$default, winkDraftGenerator$genDailySignWrapper$1) != coroutine_suspended) {
                }
            }
        }
        winkDraftGenerator$genDailySignWrapper$1 = new WinkDraftGenerator$genDailySignWrapper$1(this, continuation);
        Object obj2 = winkDraftGenerator$genDailySignWrapper$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkDraftGenerator$genDailySignWrapper$1.label;
        int i172 = 1;
        if (i3 == 0) {
        }
        mediaPath = dailySignConfig.getMediaPath();
        Intrinsics.checkNotNull(mediaPath);
        MetaMaterial metaMaterial4 = dailySignConfig.getMetaMaterial();
        Intrinsics.checkNotNull(metaMaterial4);
        String str3 = com.tencent.mobileqq.wink.editor.c.g0(metaMaterial4) + File.separator + TemplateBean.TEMPLATE_JSON;
        assetDataMap = dailySignConfig.getAssetDataMap();
        HashMap hashMap2 = new HashMap();
        String v162 = WinkEditorResourceManager.a1().v1();
        Intrinsics.checkNotNullExpressionValue(v162, "getInstance().qqNickName");
        hashMap2.put("nickNameForQQ", v162);
        hashMap2.put("yearNumber", String.valueOf(Calendar.getInstance().get(1)));
        DailySignConfig.Companion companion2 = DailySignConfig.INSTANCE;
        hashMap2.put("monthNumber", companion2.a(Calendar.getInstance().get(2) + 1));
        hashMap2.put("dayNumber", companion2.a(Calendar.getInstance().get(5)));
        hashMap2.put("weekString", com.tencent.mobileqq.wink.editor.sticker.selector.adapter.a.INSTANCE.a(Calendar.getInstance().get(7) - 1));
        if (assetDataMap != null) {
        }
        textContent = dailySignConfig.getTextContent();
        if (textContent != null) {
        }
        if (dailySignConfig.getMediaPath() != null) {
        }
        hashMap2.put("startExport", "true");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, new JSONObject(hashMap2).toString()));
        if (mediaPath.isEmpty()) {
        }
        WinkEditDataWrapper f162 = com.tencent.mobileqq.wink.editor.draft.c.f(new ArrayList(mutableList), 0, 0, 6, null);
        String missionId2 = dailySignConfig.getMissionId();
        ArrayList<WinkEditData> editDatas2 = f162.getEditDatas();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        while (r6.hasNext()) {
        }
        copy$default = WinkEditDataWrapper.copy$default(f162, missionId2, null, new ArrayList(arrayList2), null, str3, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -22, 4095, null);
        w53.b.a("WinkDraftGenerator", "genDailySignWrapper: " + com.tencent.mobileqq.wink.editor.c.g0(metaMaterial4));
        winkDraftGenerator$genDailySignWrapper$1.L$0 = winkDraftGenerator;
        winkDraftGenerator$genDailySignWrapper$1.L$1 = dailySignConfig;
        winkDraftGenerator$genDailySignWrapper$1.L$2 = mutableList;
        winkDraftGenerator$genDailySignWrapper$1.L$3 = copy$default;
        winkDraftGenerator$genDailySignWrapper$1.label = 2;
        l3 = winkDraftGenerator.l(winkDraftGenerator$genDailySignWrapper$1);
        if (l3 != coroutine_suspended) {
        }
    }

    private final Map<String, AudioModel> k(MusicInfoWrapper musicInfoWrapper, long durationMs) {
        AudioModel copy;
        Map<String, AudioModel> mapOf;
        copy = r0.copy((r37 & 1) != 0 ? r0.id : null, (r37 & 2) != 0 ? r0.path : null, (r37 & 4) != 0 ? Long.valueOf(r0.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(r0.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(r0.startTimeInTimeline) : null, (r37 & 32) != 0 ? Float.valueOf(r0.volume) : Float.valueOf(1.0f), (r37 & 64) != 0 ? Float.valueOf(r0.speed) : null, (r37 & 128) != 0 ? r0.volumeEffects : null, (r37 & 256) != 0 ? r0.name : null, (r37 & 512) != 0 ? r0.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(r0.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(r0.selectDuration) : Long.valueOf(durationMs), (r37 & 4096) != 0 ? Long.valueOf(r0.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(r0.fadeOutDuration) : null, (r37 & 16384) != 0 ? r0.lyricInfo : null, (r37 & 32768) != 0 ? r0.type : null, (r37 & 65536) != 0 ? r0.waveSampleData : null, (r37 & 131072) != 0 ? r0.event : null, (r37 & 262144) != 0 ? musicInfoWrapper.e().unknownFields() : null);
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair(copy.id, copy));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(WinkEditorMusicInfo winkEditorMusicInfo, Continuation<? super String> continuation) {
        WinkDraftGenerator$getMusicLocalPath$1 winkDraftGenerator$getMusicLocalPath$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        WinkDraftGenerator winkDraftGenerator;
        WinkEditorMusicInfo winkEditorMusicInfo2;
        if (continuation instanceof WinkDraftGenerator$getMusicLocalPath$1) {
            winkDraftGenerator$getMusicLocalPath$1 = (WinkDraftGenerator$getMusicLocalPath$1) continuation;
            int i16 = winkDraftGenerator$getMusicLocalPath$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkDraftGenerator$getMusicLocalPath$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkDraftGenerator$getMusicLocalPath$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkDraftGenerator$getMusicLocalPath$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        winkDraftGenerator = (WinkDraftGenerator) winkDraftGenerator$getMusicLocalPath$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        winkEditorMusicInfo2 = (WinkEditorMusicInfo) obj;
                        if (winkEditorMusicInfo2 != null) {
                            return null;
                        }
                        winkDraftGenerator$getMusicLocalPath$1.L$0 = null;
                        winkDraftGenerator$getMusicLocalPath$1.label = 2;
                        obj = winkDraftGenerator.e(winkEditorMusicInfo2, winkDraftGenerator$getMusicLocalPath$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String t16 = winkEditorMusicInfo.t();
                    Intrinsics.checkNotNullExpressionValue(t16, "musicInfo.songUrl");
                    if (t16.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        String p16 = winkEditorMusicInfo.p();
                        Intrinsics.checkNotNullExpressionValue(p16, "musicInfo.songMid");
                        winkDraftGenerator$getMusicLocalPath$1.L$0 = this;
                        winkDraftGenerator$getMusicLocalPath$1.label = 1;
                        obj = o(p16, winkDraftGenerator$getMusicLocalPath$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        winkDraftGenerator = this;
                        winkEditorMusicInfo2 = (WinkEditorMusicInfo) obj;
                        if (winkEditorMusicInfo2 != null) {
                        }
                    } else {
                        winkDraftGenerator$getMusicLocalPath$1.label = 3;
                        obj = e(winkEditorMusicInfo, winkDraftGenerator$getMusicLocalPath$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj;
                    }
                }
                return obj;
            }
        }
        winkDraftGenerator$getMusicLocalPath$1 = new WinkDraftGenerator$getMusicLocalPath$1(this, continuation);
        Object obj2 = winkDraftGenerator$getMusicLocalPath$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkDraftGenerator$getMusicLocalPath$1.label;
        if (i3 == 0) {
        }
        return obj2;
    }

    private final List<MediaClip> n(WinkEditData winkEditData, MusicInfoWrapper musicInfoWrapper, QQCircleSmartMatchMusic$MusicStuckPointInfo musicStuckInfo, TemplateMusicInfoParseResult templateMusicInfoParseResult) {
        TemplateFixedClipConfig templateFixedClipConfig;
        List<MediaClip> m3 = com.tencent.videocut.render.extension.e.m(com.tencent.mobileqq.wink.editor.draft.c.t(winkEditData));
        MusicInfo f16 = musicInfoWrapper.f(musicStuckInfo);
        if (templateMusicInfoParseResult != null) {
            templateFixedClipConfig = templateMusicInfoParseResult.getFixedClipConfig();
        } else {
            templateFixedClipConfig = null;
        }
        return com.tencent.mobileqq.wink.editor.smartclip.c.c(m3, f16, templateFixedClipConfig).c();
    }

    private final Object o(String str, Continuation<? super WinkEditorMusicInfo> continuation) {
        Continuation intercepted;
        ArrayList arrayListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
        WinkEditorMusicHelper.D(arrayListOf, new d(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void p(String _missionId, WinkEditDataWrapper winkEditDataWrapper) {
        Object firstOrNull;
        Object firstOrNull2;
        MediaModel copy;
        MediaModel copy2;
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = u.e2(_missionId);
        localMediaInfo.missionID = _missionId;
        winkEditDataWrapper.setOutMediaInfo(localMediaInfo);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) winkEditDataWrapper.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) firstOrNull;
        if (winkEditData != null) {
            copy2 = r3.copy((r39 & 1) != 0 ? r3.id : null, (r39 & 2) != 0 ? r3.name : null, (r39 & 4) != 0 ? r3.version : null, (r39 & 8) != 0 ? r3.createTime : null, (r39 & 16) != 0 ? r3.updateTime : null, (r39 & 32) != 0 ? r3.duration : null, (r39 & 64) != 0 ? r3.videos : null, (r39 & 128) != 0 ? r3.audios : null, (r39 & 256) != 0 ? r3.stickers : null, (r39 & 512) != 0 ? r3.backgroundModel : f325956a.t(winkEditData.getMediaModel()), (r39 & 1024) != 0 ? r3.filterModels : null, (r39 & 2048) != 0 ? r3.specialEffects : null, (r39 & 4096) != 0 ? r3.transitions : null, (r39 & 8192) != 0 ? r3.templateModel : null, (r39 & 16384) != 0 ? r3.coverInfo : null, (r39 & 32768) != 0 ? r3.exportSetting : null, (r39 & 65536) != 0 ? r3.openHDR : null, (r39 & 131072) != 0 ? r3.hdrModels : null, (r39 & 262144) != 0 ? r3.smoothModels : null, (r39 & 524288) != 0 ? r3.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData.getMediaModel().unknownFields() : null);
            winkEditData.setMediaModel(copy2);
        }
        com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, _missionId);
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) winkEditDataWrapper.getEditDatas());
        WinkEditData winkEditData2 = (WinkEditData) firstOrNull2;
        if (winkEditData2 != null) {
            copy = r3.copy((r39 & 1) != 0 ? r3.id : null, (r39 & 2) != 0 ? r3.name : null, (r39 & 4) != 0 ? r3.version : null, (r39 & 8) != 0 ? r3.createTime : null, (r39 & 16) != 0 ? r3.updateTime : null, (r39 & 32) != 0 ? r3.duration : null, (r39 & 64) != 0 ? r3.videos : null, (r39 & 128) != 0 ? r3.audios : null, (r39 & 256) != 0 ? r3.stickers : null, (r39 & 512) != 0 ? r3.backgroundModel : f325956a.s(winkEditData2.getMediaModel()), (r39 & 1024) != 0 ? r3.filterModels : null, (r39 & 2048) != 0 ? r3.specialEffects : null, (r39 & 4096) != 0 ? r3.transitions : null, (r39 & 8192) != 0 ? r3.templateModel : null, (r39 & 16384) != 0 ? r3.coverInfo : null, (r39 & 32768) != 0 ? r3.exportSetting : null, (r39 & 65536) != 0 ? r3.openHDR : null, (r39 & 131072) != 0 ? r3.hdrModels : null, (r39 & 262144) != 0 ? r3.smoothModels : null, (r39 & 524288) != 0 ? r3.openSuperHDR : null, (r39 & 1048576) != 0 ? winkEditData2.getMediaModel().unknownFields() : null);
            winkEditData2.setMediaModel(copy);
        }
        com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, _missionId);
    }

    public static /* synthetic */ k93.c r(WinkDraftGenerator winkDraftGenerator, String str, String str2, List list, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 16) != 0) {
            z17 = false;
        }
        return winkDraftGenerator.q(str, str2, list, z18, z17);
    }

    private final BackgroundModel s(MediaModel mediaModel) {
        float f16;
        float f17;
        SizeF sizeF;
        BackgroundModel copy;
        m mVar = m.f322645a;
        Size j3 = mVar.j(mediaModel);
        if (j3.width > j3.height) {
            f16 = 99999.0f;
        } else {
            f16 = 0.0f;
        }
        float f18 = f16;
        int i3 = mVar.b().height;
        int i16 = j3.height;
        int i17 = j3.width;
        if (i16 * i17 <= 0) {
            w53.b.c("WinkDraftGenerator", "render size is error: width = " + i17 + ",height=" + i16);
            f17 = 1.0f;
        } else {
            f17 = (i16 * 1.0f) / i17;
        }
        if (f17 < 1.0f) {
            float f19 = i3;
            sizeF = new SizeF(f19, f17 * f19, ByteString.EMPTY);
        } else {
            float f26 = i3;
            sizeF = new SizeF(f26 / f17, f26, ByteString.EMPTY);
        }
        SizeF d16 = com.tencent.mobileqq.wink.editor.model.a.d(mediaModel.videos, sizeF.width, sizeF.height);
        BackgroundModel backgroundModel = mediaModel.backgroundModel;
        Intrinsics.checkNotNull(backgroundModel);
        copy = backgroundModel.copy((r24 & 1) != 0 ? backgroundModel.id : null, (r24 & 2) != 0 ? backgroundModel.renderSize : d16, (r24 & 4) != 0 ? backgroundModel.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel.bgColor : null, (r24 & 16) != 0 ? backgroundModel.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel.ratioType : null, (r24 & 64) != 0 ? backgroundModel.resPack : null, (r24 & 128) != 0 ? backgroundModel.categoryId : null, (r24 & 256) != 0 ? backgroundModel.fillScale : f18, (r24 & 512) != 0 ? backgroundModel.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel.unknownFields() : null);
        return copy;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(@NotNull String str, @Nullable List<String> list, @Nullable String str2, @NotNull Function1<? super OneClickPublishingFeedErrorCode, Unit> function1, @NotNull Function1<? super WinkEditDataWrapper, Unit> function12, @NotNull Continuation<? super DraftData> continuation) {
        WinkDraftGenerator$genDraftForDailySign$1 winkDraftGenerator$genDraftForDailySign$1;
        Object coroutine_suspended;
        int i3;
        WinkDraftGenerator winkDraftGenerator;
        String str3;
        String missionId;
        if (continuation instanceof WinkDraftGenerator$genDraftForDailySign$1) {
            winkDraftGenerator$genDraftForDailySign$1 = (WinkDraftGenerator$genDraftForDailySign$1) continuation;
            int i16 = winkDraftGenerator$genDraftForDailySign$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkDraftGenerator$genDraftForDailySign$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkDraftGenerator$genDraftForDailySign$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkDraftGenerator$genDraftForDailySign$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        missionId = (String) winkDraftGenerator$genDraftForDailySign$1.L$2;
                        String str4 = (String) winkDraftGenerator$genDraftForDailySign$1.L$1;
                        WinkDraftGenerator winkDraftGenerator2 = (WinkDraftGenerator) winkDraftGenerator$genDraftForDailySign$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str3 = str4;
                        winkDraftGenerator = winkDraftGenerator2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String d26 = u.d2();
                    af afVar = new af(list, str, null, 4, null);
                    afVar.d(d26);
                    winkDraftGenerator$genDraftForDailySign$1.L$0 = this;
                    winkDraftGenerator$genDraftForDailySign$1.L$1 = str;
                    winkDraftGenerator$genDraftForDailySign$1.L$2 = d26;
                    winkDraftGenerator$genDraftForDailySign$1.label = 1;
                    Object h16 = h(afVar, winkDraftGenerator$genDraftForDailySign$1);
                    if (h16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkDraftGenerator = this;
                    str3 = str;
                    missionId = d26;
                    obj = h16;
                }
                Triple triple = (Triple) obj;
                WinkEditDataWrapper winkEditDataWrapper = (WinkEditDataWrapper) triple.getThird();
                List list2 = (List) triple.getFirst();
                com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, missionId);
                com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, missionId);
                Intrinsics.checkNotNullExpressionValue(missionId, "missionId");
                return new DraftData(missionId, winkEditDataWrapper, r(winkDraftGenerator, missionId, str3, list2, false, false, 16, null));
            }
        }
        winkDraftGenerator$genDraftForDailySign$1 = new WinkDraftGenerator$genDraftForDailySign$1(this, continuation);
        Object obj2 = winkDraftGenerator$genDraftForDailySign$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkDraftGenerator$genDraftForDailySign$1.label;
        if (i3 == 0) {
        }
        Triple triple2 = (Triple) obj2;
        WinkEditDataWrapper winkEditDataWrapper2 = (WinkEditDataWrapper) triple2.getThird();
        List list22 = (List) triple2.getFirst();
        com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper2, missionId);
        com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper2, missionId);
        Intrinsics.checkNotNullExpressionValue(missionId, "missionId");
        return new DraftData(missionId, winkEditDataWrapper2, r(winkDraftGenerator, missionId, str3, list22, false, false, 16, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01af A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0232 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(@NotNull String str, @NotNull List<? extends LocalMediaInfo> list, @NotNull Function1<? super OneClickPublishingFeedErrorCode, Unit> function1, @NotNull Continuation<? super DraftData> continuation) {
        WinkDraftGenerator$genDraftWithRecommendStuckMusic$1 winkDraftGenerator$genDraftWithRecommendStuckMusic$1;
        Object coroutine_suspended;
        int i3;
        String missionId;
        WinkEditDataWrapper copy$default;
        boolean z16;
        WinkDraftGenerator winkDraftGenerator;
        String str2;
        List<? extends LocalMediaInfo> list2;
        boolean z17;
        boolean z18;
        Object d16;
        WinkDraftGenerator winkDraftGenerator2;
        Object e16;
        WinkDraftGenerator winkDraftGenerator3;
        boolean z19;
        Object first;
        Object first2;
        List<QQCircleSmartMatchMusic$MusicInfo> list3;
        WinkDraftGenerator winkDraftGenerator4;
        WinkMusicRecommender.a aVar;
        Object f16;
        String str3 = str;
        List<? extends LocalMediaInfo> list4 = list;
        Function1<? super OneClickPublishingFeedErrorCode, Unit> function12 = function1;
        if (continuation instanceof WinkDraftGenerator$genDraftWithRecommendStuckMusic$1) {
            winkDraftGenerator$genDraftWithRecommendStuckMusic$1 = (WinkDraftGenerator$genDraftWithRecommendStuckMusic$1) continuation;
            int i16 = winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkDraftGenerator$genDraftWithRecommendStuckMusic$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    WinkEditDataWrapper winkEditDataWrapper = (WinkEditDataWrapper) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5;
                                    String str4 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4;
                                    function12 = (Function1) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3;
                                    List<? extends LocalMediaInfo> list5 = (List) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2;
                                    String str5 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1;
                                    WinkDraftGenerator winkDraftGenerator5 = (WinkDraftGenerator) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    winkDraftGenerator3 = winkDraftGenerator5;
                                    f16 = obj;
                                    missionId = str4;
                                    list4 = list5;
                                    copy$default = winkEditDataWrapper;
                                    str3 = str5;
                                    if (((WinkEditorMusicInfo) f16) == null) {
                                        w53.b.c("WinkDraftGenerator", "[genDraftWithRecommendStuckMusic] editMusicInfo is null");
                                        function12.invoke(new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_FILL_RECOMMEND_STUCK_MUSIC_FAILED, null, 2, null));
                                    }
                                    list2 = list4;
                                    winkDraftGenerator = winkDraftGenerator3;
                                    str2 = str3;
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                WinkEditDataWrapper winkEditDataWrapper2 = (WinkEditDataWrapper) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5;
                                String str6 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4;
                                function12 = (Function1) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3;
                                List<? extends LocalMediaInfo> list6 = (List) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2;
                                String str7 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1;
                                winkDraftGenerator3 = (WinkDraftGenerator) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                copy$default = winkEditDataWrapper2;
                                str3 = str7;
                                e16 = obj;
                                missionId = str6;
                                list4 = list6;
                                aVar = (WinkMusicRecommender.a) e16;
                                if (aVar != null) {
                                    w53.b.c("WinkDraftGenerator", "[genDraftWithRecommendStuckMusic] recommendData is null");
                                    function12.invoke(new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_RECOMMEND_STUCK_MUSIC_FAILED, null, 2, null));
                                    list2 = list4;
                                    winkDraftGenerator = winkDraftGenerator3;
                                    str2 = str3;
                                } else {
                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0 = winkDraftGenerator3;
                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1 = str3;
                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2 = list4;
                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3 = function12;
                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4 = missionId;
                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5 = copy$default;
                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label = 4;
                                    f16 = winkDraftGenerator3.f(aVar, copy$default, winkDraftGenerator$genDraftWithRecommendStuckMusic$1);
                                    if (f16 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    if (((WinkEditorMusicInfo) f16) == null) {
                                    }
                                    list2 = list4;
                                    winkDraftGenerator = winkDraftGenerator3;
                                    str2 = str3;
                                }
                            }
                        } else {
                            WinkEditDataWrapper winkEditDataWrapper3 = (WinkEditDataWrapper) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4;
                            String str8 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3;
                            List<? extends LocalMediaInfo> list7 = (List) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2;
                            String str9 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1;
                            winkDraftGenerator4 = (WinkDraftGenerator) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            copy$default = winkEditDataWrapper3;
                            missionId = str8;
                            list4 = list7;
                            str3 = str9;
                            str2 = str3;
                            list2 = list4;
                            winkDraftGenerator = winkDraftGenerator4;
                        }
                    } else {
                        WinkEditDataWrapper winkEditDataWrapper4 = (WinkEditDataWrapper) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5;
                        String str10 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4;
                        function12 = (Function1) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3;
                        List<? extends LocalMediaInfo> list8 = (List) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2;
                        String str11 = (String) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1;
                        winkDraftGenerator2 = (WinkDraftGenerator) winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        copy$default = winkEditDataWrapper4;
                        str3 = str11;
                        d16 = obj;
                        missionId = str10;
                        list4 = list8;
                        list3 = (List) d16;
                        if (list3 != null) {
                            w53.b.c("WinkDraftGenerator", "[genDraftWithRecommendStuckMusic] musicInfo is null");
                            function12.invoke(new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_RECOMMEND_MUSIC_FAILED, null, 2, null));
                            str2 = str3;
                            list2 = list4;
                            winkDraftGenerator = winkDraftGenerator2;
                        } else {
                            winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0 = winkDraftGenerator2;
                            winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1 = str3;
                            winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2 = list4;
                            winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3 = missionId;
                            winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4 = copy$default;
                            winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5 = null;
                            winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label = 2;
                            if (winkDraftGenerator2.g(list3, copy$default, winkDraftGenerator$genDraftWithRecommendStuckMusic$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            winkDraftGenerator4 = winkDraftGenerator2;
                            str2 = str3;
                            list2 = list4;
                            winkDraftGenerator = winkDraftGenerator4;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    missionId = u.d2();
                    copy$default = WinkEditDataWrapper.copy$default(com.tencent.mobileqq.wink.editor.draft.c.f(new ArrayList(list4), 0, 0, 6, null), missionId, null, null, null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -2, 4095, null);
                    copy$default.setOriginVolume(1.0f);
                    if (list.size() == 1) {
                        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                        if (i.I((LocalMediaInfo) first2)) {
                            z16 = true;
                            if (z16) {
                                if (list.size() == 1) {
                                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                                    if (i.G((LocalMediaInfo) first)) {
                                        z17 = true;
                                        if (list.size() <= 3) {
                                            List<? extends LocalMediaInfo> list9 = list4;
                                            if (!(list9 instanceof Collection) || !list9.isEmpty()) {
                                                Iterator<T> it = list9.iterator();
                                                while (it.hasNext()) {
                                                    if (i.G((LocalMediaInfo) it.next())) {
                                                        z19 = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            z19 = false;
                                            if (!z19) {
                                                z18 = true;
                                                if (z17 && !z18) {
                                                    WinkMusicRecommender winkMusicRecommender = WinkMusicRecommender.f321453a;
                                                    WinkDraftGenerator$genDraftWithRecommendStuckMusic$recommendData$1 winkDraftGenerator$genDraftWithRecommendStuckMusic$recommendData$1 = new Function1<WinkMusicRecommender.ProgressState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator$genDraftWithRecommendStuckMusic$recommendData$1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(WinkMusicRecommender.ProgressState progressState) {
                                                            invoke2(progressState);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(@NotNull WinkMusicRecommender.ProgressState it5) {
                                                            Intrinsics.checkNotNullParameter(it5, "it");
                                                            w53.b.f("WinkDraftGenerator", "[genDraftWithRecommendStuckMusic] recommendStuckMusic: " + it5);
                                                        }
                                                    };
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0 = this;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1 = str3;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2 = list4;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3 = function12;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4 = missionId;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5 = copy$default;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label = 3;
                                                    e16 = winkMusicRecommender.e(list4, winkDraftGenerator$genDraftWithRecommendStuckMusic$recommendData$1, winkDraftGenerator$genDraftWithRecommendStuckMusic$1);
                                                    if (e16 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    winkDraftGenerator3 = this;
                                                    aVar = (WinkMusicRecommender.a) e16;
                                                    if (aVar != null) {
                                                    }
                                                } else {
                                                    WinkMusicRecommender winkMusicRecommender2 = WinkMusicRecommender.f321453a;
                                                    WinkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1 winkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1 = new Function1<WinkMusicRecommender.ProgressState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(WinkMusicRecommender.ProgressState progressState) {
                                                            invoke2(progressState);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(@NotNull WinkMusicRecommender.ProgressState it5) {
                                                            Intrinsics.checkNotNullParameter(it5, "it");
                                                            w53.b.f("WinkDraftGenerator", "[genDraftWithRecommendStuckMusic] recommendMusic: " + it5);
                                                        }
                                                    };
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0 = this;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1 = str3;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2 = list4;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3 = function12;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4 = missionId;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5 = copy$default;
                                                    winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label = 1;
                                                    d16 = winkMusicRecommender2.d(list4, winkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1, winkDraftGenerator$genDraftWithRecommendStuckMusic$1);
                                                    if (d16 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    winkDraftGenerator2 = this;
                                                    list3 = (List) d16;
                                                    if (list3 != null) {
                                                    }
                                                }
                                            }
                                        }
                                        z18 = false;
                                        if (z17) {
                                        }
                                        WinkMusicRecommender winkMusicRecommender22 = WinkMusicRecommender.f321453a;
                                        WinkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1 winkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$12 = new Function1<WinkMusicRecommender.ProgressState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(WinkMusicRecommender.ProgressState progressState) {
                                                invoke2(progressState);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull WinkMusicRecommender.ProgressState it5) {
                                                Intrinsics.checkNotNullParameter(it5, "it");
                                                w53.b.f("WinkDraftGenerator", "[genDraftWithRecommendStuckMusic] recommendMusic: " + it5);
                                            }
                                        };
                                        winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0 = this;
                                        winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1 = str3;
                                        winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2 = list4;
                                        winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3 = function12;
                                        winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4 = missionId;
                                        winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5 = copy$default;
                                        winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label = 1;
                                        d16 = winkMusicRecommender22.d(list4, winkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$12, winkDraftGenerator$genDraftWithRecommendStuckMusic$1);
                                        if (d16 == coroutine_suspended) {
                                        }
                                    }
                                }
                                z17 = false;
                                if (list.size() <= 3) {
                                }
                                z18 = false;
                                if (z17) {
                                }
                                WinkMusicRecommender winkMusicRecommender222 = WinkMusicRecommender.f321453a;
                                WinkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1 winkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$122 = new Function1<WinkMusicRecommender.ProgressState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(WinkMusicRecommender.ProgressState progressState) {
                                        invoke2(progressState);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull WinkMusicRecommender.ProgressState it5) {
                                        Intrinsics.checkNotNullParameter(it5, "it");
                                        w53.b.f("WinkDraftGenerator", "[genDraftWithRecommendStuckMusic] recommendMusic: " + it5);
                                    }
                                };
                                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$0 = this;
                                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$1 = str3;
                                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$2 = list4;
                                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$3 = function12;
                                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$4 = missionId;
                                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.L$5 = copy$default;
                                winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label = 1;
                                d16 = winkMusicRecommender222.d(list4, winkDraftGenerator$genDraftWithRecommendStuckMusic$musicInfo$122, winkDraftGenerator$genDraftWithRecommendStuckMusic$1);
                                if (d16 == coroutine_suspended) {
                                }
                            } else {
                                winkDraftGenerator = this;
                                str2 = str3;
                                list2 = list4;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                }
                Intrinsics.checkNotNullExpressionValue(missionId, "missionId");
                winkDraftGenerator.p(missionId, copy$default);
                return new DraftData(missionId, copy$default, r(winkDraftGenerator, missionId, str2, list2, false, false, 24, null));
            }
        }
        winkDraftGenerator$genDraftWithRecommendStuckMusic$1 = new WinkDraftGenerator$genDraftWithRecommendStuckMusic$1(this, continuation);
        Object obj2 = winkDraftGenerator$genDraftWithRecommendStuckMusic$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkDraftGenerator$genDraftWithRecommendStuckMusic$1.label;
        if (i3 == 0) {
        }
        Intrinsics.checkNotNullExpressionValue(missionId, "missionId");
        winkDraftGenerator.p(missionId, copy$default);
        return new DraftData(missionId, copy$default, r(winkDraftGenerator, missionId, str2, list2, false, false, 24, null));
    }

    @Nullable
    public final Object l(@NotNull Continuation<? super List<QQCircleSmartMatchMusic$MusicInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        c cVar = new c(safeContinuation);
        MutableLiveData<List<MetaCategory>> K0 = WinkEditorResourceManager.a1().K0();
        Intrinsics.checkNotNullExpressionValue(K0, "getInstance().dailySignMusicListLiveData");
        LiveDataExtKt.b(K0, cVar);
        WinkEditorResourceManager.a1().Q2("music");
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @NotNull
    public final k93.c q(@NotNull String missionId, @NotNull String content, @NotNull List<? extends LocalMediaInfo> media, boolean savePublishDraft, boolean draftIsSaveUploading) {
        Object first;
        String str;
        int collectionSizeOrDefault;
        HashMap hashMapOf;
        String str2;
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(media, "media");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) media);
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) first;
        if (i.I(localMediaInfo)) {
            str = PublishVideoUtils.getVideoCover(localMediaInfo.path);
        } else {
            str = localMediaInfo.path;
        }
        List<? extends LocalMediaInfo> list = media;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((LocalMediaInfo) it.next()).path);
        }
        String str3 = localMediaInfo.path;
        LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
        localMediaInfo2.mMimeType = "video/mp4";
        localMediaInfo2.thumbnailPath = str;
        localMediaInfo2.mOriginPath = new ArrayList<>(arrayList);
        Unit unit = Unit.INSTANCE;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(str3, localMediaInfo2));
        c.a F = new c.a(missionId, 1, arrayList, hashMapOf).F(content);
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 == null || (str2 = f16.getTraceId()) == null) {
            str2 = "";
        }
        k93.c draftParameter = F.E(str2).G(str).A();
        if (savePublishDraft) {
            if (draftIsSaveUploading) {
                ha3.b h16 = draftParameter.h();
                h16.f404626k = 1;
                WinkDraftUtil.INSTANCE.r(h16);
                w53.b.f("WinkDraftGenerator", "[savePublishDraft] draftContent\uff1a" + h16);
            } else {
                WinkDraftUtil.INSTANCE.s(draftParameter);
            }
        }
        Intrinsics.checkNotNullExpressionValue(draftParameter, "draftParameter");
        return draftParameter;
    }

    @NotNull
    public final BackgroundModel t(@NotNull MediaModel mediaModel) {
        float f16;
        float f17;
        SizeF sizeF;
        BackgroundModel copy;
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        m mVar = m.f322645a;
        Size k3 = mVar.k(mediaModel);
        if (k3.width > k3.height) {
            f16 = 99999.0f;
        } else {
            f16 = 0.0f;
        }
        float f18 = f16;
        int i3 = mVar.b().height;
        int i16 = k3.height;
        int i17 = k3.width;
        if (i16 * i17 <= 0) {
            w53.b.c("WinkDraftGenerator", "render size is error: width = " + i17 + ",height=" + i16);
            f17 = 1.0f;
        } else {
            f17 = (i16 * 1.0f) / i17;
        }
        if (f17 < 1.0f) {
            float f19 = i3;
            sizeF = new SizeF(f19, f17 * f19, ByteString.EMPTY);
        } else {
            float f26 = i3;
            sizeF = new SizeF(f26 / f17, f26, ByteString.EMPTY);
        }
        SizeF d16 = com.tencent.mobileqq.wink.editor.model.a.d(mediaModel.videos, sizeF.width, sizeF.height);
        BackgroundModel backgroundModel = mediaModel.backgroundModel;
        Intrinsics.checkNotNull(backgroundModel);
        copy = backgroundModel.copy((r24 & 1) != 0 ? backgroundModel.id : null, (r24 & 2) != 0 ? backgroundModel.renderSize : d16, (r24 & 4) != 0 ? backgroundModel.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel.bgColor : null, (r24 & 16) != 0 ? backgroundModel.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel.ratioType : null, (r24 & 64) != 0 ? backgroundModel.resPack : null, (r24 & 128) != 0 ? backgroundModel.categoryId : null, (r24 & 256) != 0 ? backgroundModel.fillScale : f18, (r24 & 512) != 0 ? backgroundModel.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel.unknownFields() : null);
        return copy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<String> u(@Nullable List<MetaCategory> metaCategories) {
        List emptyList;
        Object obj;
        ArrayList<MetaMaterial> arrayList;
        Object obj2;
        Map<String, String> map;
        String str = null;
        if (metaCategories != null) {
            Iterator<T> it = metaCategories.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "music")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MetaCategory metaCategory = (MetaCategory) obj;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        if (Intrinsics.areEqual(((MetaMaterial) obj2).f30533id, "daily_sign_in_recommend_music_list")) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                MetaMaterial metaMaterial = (MetaMaterial) obj2;
                if (metaMaterial != null && (map = metaMaterial.additionalFields) != null) {
                    str = map.get("musicList");
                }
            }
        }
        String str2 = str;
        if (str2 == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArrayList<>(emptyList);
    }
}
