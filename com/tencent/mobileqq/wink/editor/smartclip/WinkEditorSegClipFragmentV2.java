package com.tencent.mobileqq.wink.editor.smartclip;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2;
import com.tencent.mobileqq.wink.editor.smartclip.n;
import com.tencent.mobileqq.wink.editor.view.WinkSegClipView;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0002Y]\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0001dB\u0007\u00a2\u0006\u0004\ba\u0010bJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0010H\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020$H\u0002J\n\u0010'\u001a\u0004\u0018\u00010&H\u0002J \u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\f2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u0013H\u0002J\b\u0010+\u001a\u00020\fH\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0003H\u0002R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020&0/j\b\u0012\u0004\u0012\u00020&`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010C\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010<R\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010F\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010F\u001a\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "", "handleBackEvent", "hidden", "onHiddenChanged", "", "getStatusBarColor", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "kotlin.jvm.PlatformType", "getLogTag", "initData", "Th", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Hh", "initView", "Uh", "Sh", "position", "Rh", "Yh", "", "Lh", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "Mh", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "resultTime", "Ph", "Ih", "Zh", "contentView", "registerDaTongReportPageId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "segClipDataList", "D", "I", "currentModifiedIndex", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "E", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "bussinessName", "G", "Z", "needShowThumb", "H", "needShowSelectStart", "reportSessionId", "Lcom/tencent/videocut/model/BackgroundModel;", "J", "Lkotlin/Lazy;", "Jh", "()Lcom/tencent/videocut/model/BackgroundModel;", "backgroundModel", "Lcom/tencent/mobileqq/wink/editor/smartclip/n;", "K", "Kh", "()Lcom/tencent/mobileqq/wink/editor/smartclip/n;", "clipAdapter", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "L", "Oh", "()Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/b;", "M", "Nh", "()Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/b;", "editSegClipViewModel", "com/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$d", "N", "Lcom/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$d;", "playerListener", "com/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$e", "P", "Lcom/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$e;", "renderListener", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorSegClipFragmentV2 extends ImmersivePartFragment implements IWinkCrashReportCallback {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy backgroundModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy clipAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy timelineViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy editSegClipViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final d playerListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final e renderListener;

    @NotNull
    public Map<Integer, View> Q = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<WinkSegClipView.SegClipModel> segClipDataList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private int currentModifiedIndex = -1;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider = com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String bussinessName = "";

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needShowThumb = true;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needShowSelectStart = true;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String reportSessionId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007JB\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0007R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$a;", "", "Lcom/tencent/videocut/model/BackgroundModel;", "backgroundModel", "Lcom/tencent/videocut/model/MediaClip;", "selectedMediaClip", "", "mediaClips", "Lcom/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2;", "b", "", "mediaClipPath", "", "selectStart", "selectDuration", "bussinessName", "", "needShowSelectStart", "needShowThumb", "reportSessionId", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "a", "KEY_MEDIA_CLIPS", "Ljava/lang/String;", "KEY_SELECTED_MEDIA_CLIP", "TAG", "", "TIME_DIFF", "I", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final BasePartFragment a(@NotNull String mediaClipPath, long selectStart, long selectDuration, @NotNull String bussinessName, boolean needShowSelectStart, boolean needShowThumb, @NotNull String reportSessionId) {
            Intrinsics.checkNotNullParameter(mediaClipPath, "mediaClipPath");
            Intrinsics.checkNotNullParameter(bussinessName, "bussinessName");
            Intrinsics.checkNotNullParameter(reportSessionId, "reportSessionId");
            LocalMediaInfo d16 = WinkExportUtils.d(mediaClipPath);
            ResourceModel resourceModel = null;
            if (d16 == null) {
                ms.a.c("WinkEditorSegClipFragmentV2", "buildLocalMediaInfoForVideo failed, create fragment failed");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(d16);
            WinkEditDataWrapper d17 = com.tencent.mobileqq.wink.editor.draft.c.d(arrayList, 0, 6);
            if (!d17.getEditDatas().isEmpty()) {
                BackgroundModel backgroundModel = d17.getEditDatas().get(0).getMediaModel().backgroundModel;
                List<MediaClip> list = d17.getEditDatas().get(0).getMediaModel().videos;
                if (!list.isEmpty()) {
                    MediaClip mediaClip = list.get(0);
                    ResourceModel resourceModel2 = mediaClip.resource;
                    if (resourceModel2 != null) {
                        resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : Long.valueOf(Math.min(selectDuration, mediaClip.resource.sourceDuration)), (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : Long.valueOf(selectStart), (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : Long.valueOf(Math.min(selectDuration, resourceModel2.sourceDuration)), (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
                    }
                    MediaClip copy$default = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(copy$default);
                    WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2 = new WinkEditorSegClipFragmentV2();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(QQWinkConstants.BACKGROUND_MODEL, backgroundModel);
                    bundle.putParcelable("key_selected_media_clip", (Parcelable) arrayList2.get(0));
                    bundle.putParcelableArrayList("key_media_clips", new ArrayList<>(arrayList2));
                    bundle.putBoolean(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_NEED_SHOW_SELECT_START_TIME, needShowSelectStart);
                    bundle.putBoolean(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_NEED_SHOW_THUMB, needShowThumb);
                    bundle.putString(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_REPORT_SESSION_ID, reportSessionId);
                    bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, bussinessName);
                    winkEditorSegClipFragmentV2.setArguments(bundle);
                    return winkEditorSegClipFragmentV2;
                }
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final WinkEditorSegClipFragmentV2 b(@NotNull BackgroundModel backgroundModel, @NotNull MediaClip selectedMediaClip, @NotNull List<? extends MediaClip> mediaClips) {
            Intrinsics.checkNotNullParameter(backgroundModel, "backgroundModel");
            Intrinsics.checkNotNullParameter(selectedMediaClip, "selectedMediaClip");
            Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
            WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2 = new WinkEditorSegClipFragmentV2();
            Bundle bundle = new Bundle();
            bundle.putParcelable(QQWinkConstants.BACKGROUND_MODEL, backgroundModel);
            bundle.putParcelable("key_selected_media_clip", selectedMediaClip);
            bundle.putParcelableArrayList("key_media_clips", new ArrayList<>(mediaClips));
            winkEditorSegClipFragmentV2.setArguments(bundle);
            return winkEditorSegClipFragmentV2;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$b", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$c;", "", "b", "", "startTimeUs", "a", "c", "timeUs", "e", "d", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkSegClipView.c {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void a(long startTimeUs) {
            float f16;
            WinkSegClipView.SegClipModel Mh = WinkEditorSegClipFragmentV2.this.Mh();
            if (Mh != null) {
                f16 = Mh.getSpeedRate();
            } else {
                f16 = 1.0f;
            }
            long j3 = ((float) startTimeUs) / f16;
            long Lh = WinkEditorSegClipFragmentV2.this.Lh();
            WinkEditorSegClipFragmentV2.this.Oh().o3(j3, Lh);
            TimelineViewModelV2 timelineViewModel = WinkEditorSegClipFragmentV2.this.Oh();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, j3, false, false, 6, null);
            ms.a.a("WinkEditorSegClipFragmentV2", "onScroll---start=" + j3 + ", duration=" + Lh);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void b() {
            WinkEditorSegClipFragmentV2.this.Oh().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void c() {
            WinkEditorSegClipFragmentV2.this.Oh().c3();
            WinkEditorSegClipFragmentV2.this.Yh();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void d() {
            WinkEditorSegClipFragmentV2.this.Oh().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void e(long timeUs) {
            TimelineViewModelV2 timelineViewModel = WinkEditorSegClipFragmentV2.this.Oh();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, timeUs, false, false, 6, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void f() {
            WinkEditorSegClipFragmentV2.this.Oh().c3();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f321474d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkEditorSegClipFragmentV2 f321475e;

        c(View view, WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2) {
            this.f321474d = view;
            this.f321475e = winkEditorSegClipFragmentV2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(16)
        public void onGlobalLayout() {
            boolean booleanValue;
            int intValue;
            this.f321474d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
            List Hh = this.f321475e.Hh();
            Boolean bool = Boolean.FALSE;
            int width = ((FrameLayout) this.f321475e.uh(R.id.v7c)).getWidth();
            int height = ((FrameLayout) this.f321475e.uh(R.id.v7c)).getHeight();
            Boolean bool2 = u53.i.f438428a;
            if (bool2 == null) {
                booleanValue = false;
            } else {
                booleanValue = bool2.booleanValue();
            }
            boolean z16 = booleanValue;
            Integer num = u53.i.f438429b;
            if (num == null) {
                intValue = 4;
            } else {
                intValue = num.intValue();
            }
            dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(false, editMode, Hh, null, bool, width, height, null, null, z16, intValue, Long.MAX_VALUE, false, false, null, WinkTavCutScene.Seg, true, false, 0, 0, false, null, 4092160, null);
            TimelineViewModelV2 timelineViewModel = this.f321475e.Oh();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2 = this.f321475e;
            TimelineViewModelV2.S2(timelineViewModel, winkEditorSegClipFragmentV2, (FrameLayout) winkEditorSegClipFragmentV2.uh(R.id.v7c), winkTavCutParams, this.f321475e.playerListener, this.f321475e.renderListener, true, false, true, 0L, null, 832, null);
            WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV22 = this.f321475e;
            winkEditorSegClipFragmentV22.Rh(winkEditorSegClipFragmentV22.currentModifiedIndex);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$d", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements IPlayer.PlayerListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WinkEditorSegClipFragmentV2 this$0) {
            float f16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (((WinkSegClipView) this$0.uh(R.id.f81914fg)) != null) {
                WinkSegClipView.SegClipModel Mh = this$0.Mh();
                if (Mh != null) {
                    f16 = Mh.getSpeedRate();
                } else {
                    f16 = 1.0f;
                }
                long k3 = ((float) ((WinkSegClipView) this$0.uh(R.id.f81914fg)).k()) / f16;
                long Lh = this$0.Lh();
                ms.a.a("WinkEditorSegClipFragmentV2", "onPlayerSourceReady---start=" + k3 + ", duration=" + Lh);
                this$0.Oh().o3(k3, Lh);
                TimelineViewModelV2 timelineViewModel = this$0.Oh();
                Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
                TimelineViewModelV2.g3(timelineViewModel, k3, false, false, 6, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WinkEditorSegClipFragmentV2 this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WinkSegClipView winkSegClipView = (WinkSegClipView) this$0.uh(R.id.f81914fg);
            if (winkSegClipView != null) {
                winkSegClipView.z(j3);
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2 = WinkEditorSegClipFragmentV2.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.smartclip.j
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorSegClipFragmentV2.d.c(WinkEditorSegClipFragmentV2.this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(final long currentDurationUs, long playerDurationUs) {
            WinkEditorSegClipFragmentV2.this.Oh().m2().postValue(Long.valueOf(currentDurationUs));
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2 = WinkEditorSegClipFragmentV2.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.smartclip.i
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorSegClipFragmentV2.d.d(WinkEditorSegClipFragmentV2.this, currentDurationUs);
                }
            });
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (status == IPlayer.PlayerStatus.PLAYING) {
                ((ImageView) WinkEditorSegClipFragmentV2.this.uh(R.id.xyv)).setImageResource(R.drawable.oqq);
            } else if (status == IPlayer.PlayerStatus.PAUSED) {
                ((ImageView) WinkEditorSegClipFragmentV2.this.uh(R.id.xyv)).setImageResource(R.drawable.oqs);
            }
            WinkEditorSegClipFragmentV2.this.Oh().l2().postValue(status);
        }
    }

    public WinkEditorSegClipFragmentV2() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BackgroundModel>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2$backgroundModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BackgroundModel invoke() {
                Bundle arguments = WinkEditorSegClipFragmentV2.this.getArguments();
                BackgroundModel backgroundModel = arguments != null ? (BackgroundModel) arguments.getParcelable(QQWinkConstants.BACKGROUND_MODEL) : null;
                return backgroundModel == null ? new BackgroundModel(null, null, null, null, null, null, null, null, 0.0f, 0, null, 2047, null) : backgroundModel;
            }
        });
        this.backgroundModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<n>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2$clipAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final n invoke() {
                com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d dVar;
                ArrayList arrayList;
                dVar = WinkEditorSegClipFragmentV2.this.thumbnailProvider;
                arrayList = WinkEditorSegClipFragmentV2.this.segClipDataList;
                return new n(dVar, arrayList);
            }
        });
        this.clipAdapter = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TimelineViewModelV2>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2$timelineViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TimelineViewModelV2 invoke() {
                return (TimelineViewModelV2) new ViewModelProvider(WinkEditorSegClipFragmentV2.this).get(TimelineViewModelV2.class);
            }
        });
        this.timelineViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.WinkEditorSegClipFragmentV2$editSegClipViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b invoke() {
                return (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b) new ViewModelProvider(WinkEditorSegClipFragmentV2.this.requireActivity()).get(com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b.class);
            }
        });
        this.editSegClipViewModel = lazy4;
        this.playerListener = new d();
        this.renderListener = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WinkEditData> Hh() {
        List<WinkEditData> mutableListOf;
        ArrayList arrayList = new ArrayList();
        WinkSegClipView.SegClipModel Mh = Mh();
        if (Mh != null) {
            arrayList.add(Mh.getMediaClip());
        }
        MediaModel c16 = com.tencent.mobileqq.wink.editor.model.a.c(arrayList, Jh(), null, 4, null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkEditData(c16, com.tencent.mobileqq.wink.editor.model.a.r(c16), null, null, null, null, false, null, null, null, null, null, true, null, null, null, false, null, 257920, null));
        return mutableListOf;
    }

    private final boolean Ih() {
        for (WinkSegClipView.SegClipModel segClipModel : this.segClipDataList) {
            if (Math.abs(segClipModel.getOriginStartTime() - segClipModel.getModifiedStartTime()) >= 50000) {
                return true;
            }
        }
        return false;
    }

    private final BackgroundModel Jh() {
        return (BackgroundModel) this.backgroundModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n Kh() {
        return (n) this.clipAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long Lh() {
        if (Mh() != null) {
            return ((float) r0.getSelectDuration()) / r0.getSpeedRate();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkSegClipView.SegClipModel Mh() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.segClipDataList, this.currentModifiedIndex);
        return (WinkSegClipView.SegClipModel) orNull;
    }

    private final com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b Nh() {
        return (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.b) this.editSegClipViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelineViewModelV2 Oh() {
        return (TimelineViewModelV2) this.timelineViewModel.getValue();
    }

    private final void Ph(boolean confirm, List<Long> resultTime) {
        boolean z16;
        Nh().N1(confirm);
        Bundle bundle = new Bundle();
        List<Long> list = resultTime;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            bundle.putSerializable(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_SELECT_START_TIME_RESULT, new ArrayList(list));
        } else {
            bundle.putSerializable(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_SELECT_START_TIME_RESULT, null);
        }
        getParentFragmentManager().setFragmentResult(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_RESULT, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Qh(WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        winkEditorSegClipFragmentV2.Ph(z16, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        r1 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r1.getMediaClip());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Rh(int position) {
        Object orNull;
        List<? extends MediaClip> emptyList;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.segClipDataList, position);
        if (((WinkSegClipView.SegClipModel) orNull) != null) {
            this.currentModifiedIndex = position;
            WinkSegClipView.SegClipModel Mh = Mh();
            if (Mh != null) {
                ((WinkSegClipView) uh(R.id.f81914fg)).setSegClipModel(Mh);
            }
            TimelineViewModelV2 Oh = Oh();
            WinkSegClipView.SegClipModel Mh2 = Mh();
            if (Mh2 == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            Oh.y3(emptyList);
            ms.a.f("WinkEditorSegClipFragmentV2", "handleMediaClipClick---" + position + " timeLineViewModel update media clips");
        }
    }

    private final void Sh() {
        ((WinkSegClipView) uh(R.id.f81914fg)).setSegClipCallback(new b());
    }

    private final void Th(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new c(view, this));
    }

    private final void Uh() {
        ((ImageView) uh(R.id.xyi)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.smartclip.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorSegClipFragmentV2.Vh(WinkEditorSegClipFragmentV2.this, view);
            }
        });
        VideoReport.setElementId((ImageView) uh(R.id.xyk), WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_ADJUST_APPLY_BUTTON);
        VideoReport.setElementClickPolicy((ImageView) uh(R.id.xyk), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy((ImageView) uh(R.id.xyk), ExposurePolicy.REPORT_NONE);
        ((ImageView) uh(R.id.xyk)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.smartclip.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorSegClipFragmentV2.Wh(WinkEditorSegClipFragmentV2.this, view);
            }
        });
        ((ImageView) uh(R.id.xyv)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.smartclip.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorSegClipFragmentV2.Xh(WinkEditorSegClipFragmentV2.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(WinkEditorSegClipFragmentV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Yh();
        if (this$0.Ih()) {
            this$0.Zh();
        } else {
            Qh(this$0, false, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(WinkEditorSegClipFragmentV2 this$0, View view) {
        int collectionSizeOrDefault;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Yh();
        ArrayList<WinkSegClipView.SegClipModel> arrayList = this$0.segClipDataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((WinkSegClipView.SegClipModel) it.next()).getModifiedStartTime()));
        }
        ms.a.f(this$0.getTAG(), "resultStartTimeList = " + arrayList2);
        this$0.Nh().O1(arrayList2);
        this$0.Ph(true, arrayList2);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        if (this$0.Oh().getHasChanged()) {
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_IS_VIDEO_LENGTH_ADJUST, "1");
        } else {
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_IS_VIDEO_LENGTH_ADJUST, "0");
        }
        VideoReport.reportEvent("ev_xsj_camera_action", view, map);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(WinkEditorSegClipFragmentV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Oh().W2()) {
            this$0.Oh().b3();
        } else {
            this$0.Oh().c3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh() {
        long k3 = ((WinkSegClipView) uh(R.id.f81914fg)).k();
        WinkSegClipView.SegClipModel Mh = Mh();
        if (Mh != null) {
            Mh.i(k3);
        }
    }

    private final void Zh() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setMessage(getResources().getString(R.string.f215395vh));
        createCustomDialog.setPositiveButton(getResources().getString(R.string.f215405vi), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.smartclip.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorSegClipFragmentV2.ai(WinkEditorSegClipFragmentV2.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(getResources().getString(R.string.ym5), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.smartclip.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorSegClipFragmentV2.bi(dialogInterface, i3);
            }
        });
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(WinkEditorSegClipFragmentV2 this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Qh(this$0, false, null, 2, null);
    }

    private final void initData() {
        ArrayList<MediaClip> arrayList;
        int collectionSizeOrDefault;
        Unit unit;
        String str;
        boolean z16;
        String str2;
        MediaClip mediaClip;
        long j3;
        MediaType mediaType;
        ResourceModel resourceModel;
        WinkSegClipView.SegClipModel segClipModel;
        long j16;
        long j17;
        long j18;
        ArrayList<WinkSegClipView.SegClipModel> arrayList2;
        long j19;
        ResourceModel copy;
        Bundle arguments = getArguments();
        if (arguments != null) {
            arrayList = arguments.getParcelableArrayList("key_media_clips");
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        this.segClipDataList.clear();
        ArrayList<WinkSegClipView.SegClipModel> arrayList3 = this.segClipDataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (MediaClip it : arrayList) {
            ResourceModel resourceModel2 = it.resource;
            float f16 = 1.0f;
            if (resourceModel2 != null) {
                f16 = (((float) resourceModel2.selectDuration) * 1.0f) / ((float) resourceModel2.scaleDuration);
            }
            float f17 = f16;
            if (resourceModel2 != null) {
                j3 = resourceModel2.sourceDuration;
            } else {
                j3 = 0;
            }
            long j26 = ((float) j3) / f17;
            if (resourceModel2 != null) {
                mediaType = resourceModel2.type;
            } else {
                mediaType = null;
            }
            if (mediaType == MediaType.IMAGE) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                MediaClip copy$default = MediaClip.copy$default(it, null, null, null, null, null, null, null, 127, null);
                long j27 = it.resource.selectDuration;
                segClipModel = new WinkSegClipView.SegClipModel(copy$default, f17, j27, j27, 0L, 0L);
                arrayList2 = arrayList3;
            } else {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                MediaClip l3 = com.tencent.videocut.render.extension.e.l(it);
                ResourceModel resourceModel3 = l3.resource;
                if (resourceModel3 != null) {
                    copy = resourceModel3.copy((r35 & 1) != 0 ? resourceModel3.id : null, (r35 & 2) != 0 ? resourceModel3.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel3.scaleDuration) : Long.valueOf(j26), (r35 & 8) != 0 ? Long.valueOf(resourceModel3.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel3.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel3.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel3.selectDuration) : null, (r35 & 128) != 0 ? resourceModel3.type : null, (r35 & 256) != 0 ? resourceModel3.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel3.volume) : null, (r35 & 1024) != 0 ? resourceModel3.extras : null, (r35 & 2048) != 0 ? resourceModel3.picClipRect : null, (r35 & 4096) != 0 ? resourceModel3.reversePath : null, (r35 & 8192) != 0 ? resourceModel3.normalPath : null, (r35 & 16384) != 0 ? resourceModel3.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel3.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel3.unknownFields() : null);
                    resourceModel = copy;
                } else {
                    resourceModel = null;
                }
                MediaClip copy$default2 = MediaClip.copy$default(l3, resourceModel, null, null, null, null, null, null, 126, null);
                ResourceModel resourceModel4 = it.resource;
                if (resourceModel4 != null) {
                    j16 = resourceModel4.sourceDuration;
                } else {
                    j16 = 0;
                }
                if (resourceModel4 != null) {
                    j17 = resourceModel4.selectDuration;
                } else {
                    j17 = 0;
                }
                if (resourceModel4 != null) {
                    j18 = resourceModel4.selectStart;
                } else {
                    j18 = 0;
                }
                arrayList2 = arrayList3;
                if (resourceModel4 != null) {
                    j19 = resourceModel4.selectStart;
                } else {
                    j19 = 0;
                }
                segClipModel = new WinkSegClipView.SegClipModel(copy$default2, f17, j16, j17, j18, j19);
            }
            arrayList4.add(segClipModel);
            arrayList3 = arrayList2;
        }
        arrayList3.addAll(arrayList4);
        Bundle arguments2 = getArguments();
        int i3 = -1;
        if (arguments2 != null && (mediaClip = (MediaClip) arguments2.getParcelable("key_selected_media_clip")) != null) {
            Iterator<WinkSegClipView.SegClipModel> it5 = this.segClipDataList.iterator();
            int i16 = 0;
            while (true) {
                if (it5.hasNext()) {
                    if (Intrinsics.areEqual(com.tencent.videocut.render.extension.e.n(it5.next().getMediaClip()), com.tencent.videocut.render.extension.e.n(mediaClip))) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            this.currentModifiedIndex = i16;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        boolean z17 = true;
        if (unit == null) {
            if (!this.segClipDataList.isEmpty()) {
                i3 = 0;
            }
            this.currentModifiedIndex = i3;
        }
        Bundle arguments3 = getArguments();
        String str3 = "";
        if (arguments3 != null) {
            str = arguments3.getString(QQWinkConstants.ENTRY_BUSINESS_NAME, "");
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
        this.bussinessName = str;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            z16 = arguments4.getBoolean(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_NEED_SHOW_SELECT_START_TIME, true);
        } else {
            z16 = true;
        }
        this.needShowSelectStart = z16;
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            z17 = arguments5.getBoolean(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_NEED_SHOW_THUMB, true);
        }
        this.needShowThumb = z17;
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            str2 = arguments6.getString(QQWinkConstants.KEY_SEG_CLIP_FRAGMENT_REPORT_SESSION_ID, "");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        this.reportSessionId = str3;
    }

    private final void initView() {
        ((RecyclerView) uh(R.id.f7878480)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((FrameLayout) uh(R.id.v7c)).setPadding(0, com.tencent.mobileqq.wink.editor.util.m.m(getContext()), 0, 0);
        Uh();
        Sh();
        if (!this.needShowThumb) {
            View uh5 = uh(R.id.f116026xm);
            if (uh5 != null) {
                uh5.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) uh(R.id.ymr);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) uh(R.id.v7h)).getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = com.tencent.videocut.utils.e.f384236a.a(192.0f);
            }
            ((ConstraintLayout) uh(R.id.v7h)).setLayoutParams(layoutParams);
        }
        if (!this.needShowSelectStart) {
            ((WinkSegClipView) uh(R.id.f81914fg)).setNeedShowStartTimeText(false);
        }
    }

    private final void registerDaTongReportPageId(View contentView) {
        boolean z16;
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        HashMap hashMap = new HashMap();
        String str2 = this.reportSessionId;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            try {
                str = WinkContext.INSTANCE.d().getDtParams().c();
            } catch (Exception unused) {
                ms.a.c("WinkEditorSegClipFragmentV2", "registerDaTongReportPageId get winkcontext failed");
                str = "";
            }
        } else {
            str = this.reportSessionId;
        }
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(hashMap, str));
        VideoReport.ignorePageInOutEvent(contentView, true);
        ms.a.f("WinkEditorSegClipFragmentV2", "reportDaTongRegister subPage: " + getTAG() + ", pageId: pg_xsj_edit_page");
    }

    public void _$_clearFindViewByIdCache() {
        this.Q.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hcx;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return WinkEditorSegClipFragmentV2.class.getSimpleName();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    public final boolean handleBackEvent() {
        ImageView imageView = (ImageView) uh(R.id.xyi);
        if (imageView != null) {
            imageView.performClick();
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        za3.a.b(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        za3.a.c(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        za3.a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        za3.a.e(this, i3);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        za3.a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        WinkSegClipView winkSegClipView = (WinkSegClipView) uh(R.id.f81914fg);
        if (winkSegClipView != null) {
            winkSegClipView.i();
        }
        super.onDestroyView();
        Kh().x();
        Oh().d3();
        ThumbnailProviderManager.f319211a.o();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            Oh().b3();
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onPauseReport();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onResumeReport();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ThumbnailProviderManager.f319211a.p();
        registerDaTongReportPageId(view);
        initData();
        Th(view);
        initView();
        view.setClickable(true);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }

    @Nullable
    public View uh(int i3) {
        View findViewById;
        Map<Integer, View> map = this.Q;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View view2 = getView();
            if (view2 != null && (findViewById = view2.findViewById(i3)) != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/smartclip/WinkEditorSegClipFragmentV2$e", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements ISessionListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final WinkEditorSegClipFragmentV2 this$0, LAKRenderModel newData) {
            float f16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            if (((WinkSegClipView) this$0.uh(R.id.f81914fg)) != null) {
                this$0.Oh().D3(newData.getTimeLines());
                this$0.Kh().y(new n.c() { // from class: com.tencent.mobileqq.wink.editor.smartclip.l
                    @Override // com.tencent.mobileqq.wink.editor.smartclip.n.c
                    public final void onClick(int i3) {
                        WinkEditorSegClipFragmentV2.e.d(WinkEditorSegClipFragmentV2.this, i3);
                    }
                });
                this$0.Kh().z(this$0.currentModifiedIndex);
                if (((RecyclerView) this$0.uh(R.id.f7878480)).getAdapter() == null) {
                    ((RecyclerView) this$0.uh(R.id.f7878480)).setAdapter(this$0.Kh());
                }
                WinkSegClipView.SegClipModel Mh = this$0.Mh();
                if (Mh != null) {
                    f16 = Mh.getSpeedRate();
                } else {
                    f16 = 1.0f;
                }
                long k3 = ((float) ((WinkSegClipView) this$0.uh(R.id.f81914fg)).k()) / f16;
                long Lh = this$0.Lh();
                ms.a.a("WinkEditorSegClipFragmentV2", "onRenderDataChanged---start=" + k3 + ", duration=" + Lh);
                this$0.Oh().o3(k3, Lh);
                TimelineViewModelV2 timelineViewModel = this$0.Oh();
                Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
                TimelineViewModelV2.g3(timelineViewModel, k3, false, false, 6, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WinkEditorSegClipFragmentV2 this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Yh();
            this$0.Rh(i3);
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorSegClipFragmentV2 winkEditorSegClipFragmentV2 = WinkEditorSegClipFragmentV2.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.smartclip.k
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorSegClipFragmentV2.e.c(WinkEditorSegClipFragmentV2.this, newData);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(DialogInterface dialogInterface, int i3) {
    }
}
