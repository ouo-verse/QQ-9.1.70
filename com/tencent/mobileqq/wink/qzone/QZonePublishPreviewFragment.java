package com.tencent.mobileqq.wink.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.gyailib.library.GYTrackStickerInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra;
import com.tencent.mobileqq.wink.editor.draft.a;
import com.tencent.mobileqq.wink.editor.ds;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.export.j;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.mobileqq.wink.qzone.QZonePublishPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.utils.o;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Size;
import u53.i;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 n2\u00020\u0001:\u0002opB\u0007\u00a2\u0006\u0004\bl\u0010mJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J(\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001aH\u0002J\u001a\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\b\u0010\"\u001a\u00020\u0005H\u0014J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020%H\u0014J\b\u0010'\u001a\u00020%H\u0014J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0016J\"\u0010/\u001a\u00020\u00022\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00109R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010IR\u0018\u0010R\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010IR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010IR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010IR\u0018\u0010`\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010MR\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010j\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Ph", "Kh", "", QQWinkConstants.COVER_PATH, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Hh", "initVideoPlayer", "Fh", "Lcom/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment$b;", "callBack", "Ih", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Uh", "Gh", "missionId", "initMediaData", "Qh", "Vh", "initSeekBar", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "getPlayerListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getAssetDataFromEditData", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Th", "getLogTag", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", "", "getContentLayoutId", "getStatusBarColor", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "mWinkEditDataWrapper", "D", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "mPlayerListener", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "mPlayerLayoutFront", UserInfo.SEX_FEMALE, "mPlayerLayoutBack", "Landroid/widget/SeekBar;", "G", "Landroid/widget/SeekBar;", "mSeekBar", "H", "mSeekFrameLayout", "Landroid/widget/RelativeLayout;", "I", "Landroid/widget/RelativeLayout;", "mVideoProgressLayout", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mVideoCurrentProgress", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "mVideoPauseButton", "L", "mVideoDurationProgress", "M", "editBtn", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "N", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "mVideoTavCut", "P", "publishBtn", "Landroid/widget/CheckBox;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/CheckBox;", "checkBox", BdhLogUtil.LogTag.Tag_Req, "checkBoxDesc", ExifInterface.LATITUDE_SOUTH, "backBtn", "", "T", "Z", "useMissionId", "U", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "V", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "initialTemplateMaterial", "<init>", "()V", "W", "a", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZonePublishPreviewFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkEditDataWrapper mWinkEditDataWrapper;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IPlayer.PlayerListener mPlayerListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mPlayerLayoutFront;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mPlayerLayoutBack;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private SeekBar mSeekBar;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mSeekFrameLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout mVideoProgressLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mVideoCurrentProgress;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView mVideoPauseButton;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView mVideoDurationProgress;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView editBtn;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private WinkVideoTavCut mVideoTavCut;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView publishBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private CheckBox checkBox;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TextView checkBoxDesc;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ImageView backBtn;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean useMissionId;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial initialTemplateMaterial;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment$b;", "", "", QQWinkConstants.COVER_PATH, "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@NotNull String coverPath);
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment$c", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "", "currentDurationUs", "playerDurationUs", "", "onPositionChanged", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "onStatusChanged", "onPlayerSourceReady", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IPlayer.PlayerListener {
        c() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            SeekBar seekBar;
            if (playerDurationUs != 0 && (seekBar = QZonePublishPreviewFragment.this.mSeekBar) != null) {
                seekBar.setProgress((int) ((currentDurationUs / playerDurationUs) * 1000));
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment$d", "Lcom/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment$b;", "", QQWinkConstants.COVER_PATH, "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements b {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.qzone.QZonePublishPreviewFragment.b
        public void a(@NotNull String coverPath) {
            String str;
            String str2;
            String str3;
            Boolean bool;
            List<? extends LocalMediaInfo> list;
            Intrinsics.checkNotNullParameter(coverPath, "coverPath");
            HashMap hashMap = new HashMap();
            Intent intent = new Intent();
            LocalMediaInfo Hh = QZonePublishPreviewFragment.this.Hh(coverPath);
            if (Hh != null && !TextUtils.isEmpty(Hh.path)) {
                String str4 = Hh.path;
                Intrinsics.checkNotNullExpressionValue(str4, "it.path");
                hashMap.put(str4, Hh);
                intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap);
                w53.b.a("QZonePreviewFragment", "medialistSize " + hashMap);
            }
            WinkEditDataWrapper winkEditDataWrapper = QZonePublishPreviewFragment.this.mWinkEditDataWrapper;
            WinkEditDataWrapper winkEditDataWrapper2 = QZonePublishPreviewFragment.this.mWinkEditDataWrapper;
            Boolean bool2 = null;
            if (winkEditDataWrapper2 != null) {
                str = winkEditDataWrapper2.getMissionId();
            } else {
                str = null;
            }
            a.i(winkEditDataWrapper, str);
            WinkEditDataWrapper winkEditDataWrapper3 = QZonePublishPreviewFragment.this.mWinkEditDataWrapper;
            WinkEditDataWrapper winkEditDataWrapper4 = QZonePublishPreviewFragment.this.mWinkEditDataWrapper;
            if (winkEditDataWrapper4 != null) {
                str2 = winkEditDataWrapper4.getMissionId();
            } else {
                str2 = null;
            }
            a.h(winkEditDataWrapper3, str2);
            intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 10);
            intent.putExtra(QQWinkConstants.WINK_PUBLISH_TASK_ID, "qzone-syncalbum-0002");
            WinkEditDataWrapper winkEditDataWrapper5 = QZonePublishPreviewFragment.this.mWinkEditDataWrapper;
            if (winkEditDataWrapper5 != null) {
                str3 = winkEditDataWrapper5.getMissionId();
            } else {
                str3 = null;
            }
            intent.putExtra(QQWinkConstants.MISSION_ID, str3);
            intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
            CheckBox checkBox = QZonePublishPreviewFragment.this.checkBox;
            if (checkBox != null) {
                bool = Boolean.valueOf(checkBox.isChecked());
            } else {
                bool = null;
            }
            intent.putExtra(PeakConstants.KEY_QZONE_SYNC_CIRCLE, bool);
            intent.putExtra(PeakConstants.KEY_IS_FROM_QZONE_AUTO_TEMPLATE, true);
            OutputData.Companion companion = OutputData.INSTANCE;
            Collection values = hashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "mediaList.values");
            list = CollectionsKt___CollectionsKt.toList(values);
            WinkContext.INSTANCE.d().m().k(QZonePublishPreviewFragment.this.getContext(), companion.a(4L, list, intent));
            SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 15, null));
            CheckBox checkBox2 = QZonePublishPreviewFragment.this.checkBox;
            if (checkBox2 != null) {
                bool2 = Boolean.valueOf(checkBox2.isChecked());
            }
            w53.b.a("QZonePreviewFragment", "publish button clicked " + bool2);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment$e", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements SeekBar.OnSeekBarChangeListener {
        e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
            Long l3;
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                double d16 = progress / 1000.0d;
                String str = null;
                if (QZonePublishPreviewFragment.this.mVideoTavCut != null) {
                    l3 = Long.valueOf((long) (r5.getDurationUs() * d16));
                } else {
                    l3 = null;
                }
                if (l3 != null) {
                    QZonePublishPreviewFragment qZonePublishPreviewFragment = QZonePublishPreviewFragment.this;
                    long longValue = l3.longValue();
                    WinkVideoTavCut winkVideoTavCut = qZonePublishPreviewFragment.mVideoTavCut;
                    if (winkVideoTavCut != null) {
                        winkVideoTavCut.seek(longValue);
                    }
                }
                SeekBar seekBar2 = QZonePublishPreviewFragment.this.mSeekBar;
                if (seekBar2 != null) {
                    seekBar2.setProgress(progress);
                }
                TextView textView = QZonePublishPreviewFragment.this.mVideoCurrentProgress;
                if (textView != null) {
                    if (l3 != null) {
                        str = com.tencent.mobileqq.wink.editor.music.a.d(l3.longValue());
                    }
                    textView.setText(str);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            String str;
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            seekBar.getLayoutParams().height = ViewUtils.dpToPx(4.0f);
            seekBar.requestLayout();
            WinkVideoTavCut winkVideoTavCut = QZonePublishPreviewFragment.this.mVideoTavCut;
            if (winkVideoTavCut != null) {
                winkVideoTavCut.pause();
            }
            RelativeLayout relativeLayout = QZonePublishPreviewFragment.this.mVideoProgressLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            ImageView imageView = QZonePublishPreviewFragment.this.mVideoPauseButton;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = QZonePublishPreviewFragment.this.mVideoDurationProgress;
            if (textView != null) {
                WinkVideoTavCut winkVideoTavCut2 = QZonePublishPreviewFragment.this.mVideoTavCut;
                if (winkVideoTavCut2 != null) {
                    str = com.tencent.mobileqq.wink.editor.music.a.d(winkVideoTavCut2.getDurationUs());
                } else {
                    str = null;
                }
                textView.setText(str);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            seekBar.getLayoutParams().height = ViewUtils.dpToPx(2.0f);
            seekBar.requestLayout();
            WinkVideoTavCut winkVideoTavCut = QZonePublishPreviewFragment.this.mVideoTavCut;
            if (winkVideoTavCut != null) {
                winkVideoTavCut.play();
            }
            ImageView imageView = QZonePublishPreviewFragment.this.mVideoPauseButton;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            RelativeLayout relativeLayout = QZonePublishPreviewFragment.this.mVideoProgressLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isPlaying() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Fh() {
        boolean z16;
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            WinkVideoTavCut winkVideoTavCut2 = this.mVideoTavCut;
            if (winkVideoTavCut2 != null) {
                winkVideoTavCut2.pause();
            }
            ImageView imageView = this.mVideoPauseButton;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        WinkVideoTavCut winkVideoTavCut3 = this.mVideoTavCut;
        if (winkVideoTavCut3 != null) {
            winkVideoTavCut3.play();
        }
        ImageView imageView2 = this.mVideoPauseButton;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private final Bitmap Gh() {
        String str;
        WinkEditData winkEditData;
        ArrayList<WinkEditData> editDatas;
        Object firstOrNull;
        w53.b.f("QZonePreviewFragment", "saveVideoProgressCover: extractCoverBitmap start");
        try {
            AssetImageGenerator.UN_CATCH_EGL_ERROR = true;
            Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(this.mWinkEditDataWrapper);
            WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
            if (winkVideoTavCut == null) {
                return null;
            }
            Object obj = r26.first;
            Intrinsics.checkNotNullExpressionValue(obj, "size.first");
            int intValue = ((Number) obj).intValue();
            Object obj2 = r26.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "size.second");
            Size size = new Size(intValue, ((Number) obj2).intValue());
            WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
            if (winkEditDataWrapper != null) {
                str = com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper);
            } else {
                str = null;
            }
            String v3 = j.v(str);
            Intrinsics.checkNotNullExpressionValue(v3, "getTemplateDir(mWinkEdit\u2026er?.getTemplateFileDir())");
            WinkEditDataWrapper winkEditDataWrapper2 = this.mWinkEditDataWrapper;
            if (winkEditDataWrapper2 != null && (editDatas = winkEditDataWrapper2.getEditDatas()) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) editDatas);
                winkEditData = (WinkEditData) firstOrNull;
            } else {
                winkEditData = null;
            }
            return winkVideoTavCut.g1(0L, size, v3, u.T1(winkEditData));
        } catch (Exception e16) {
            w53.b.e("QZonePreviewFragment", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LocalMediaInfo Hh(String coverPath) {
        List<MediaClip> list;
        WinkEditDataWrapper winkEditDataWrapper;
        String str;
        WinkEditDataWrapper winkEditDataWrapper2;
        ArrayList<WinkEditData> editDatas;
        Object firstOrNull;
        Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(this.mWinkEditDataWrapper);
        WinkEditDataWrapper winkEditDataWrapper3 = this.mWinkEditDataWrapper;
        String str2 = null;
        if (winkEditDataWrapper3 == null) {
            return null;
        }
        long duration = winkEditDataWrapper3.getDuration() / 1000;
        WinkEditDataWrapper winkEditDataWrapper4 = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper4 != null && (editDatas = winkEditDataWrapper4.getEditDatas()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) editDatas);
            WinkEditData winkEditData = (WinkEditData) firstOrNull;
            if (winkEditData != null) {
                list = com.tencent.mobileqq.wink.editor.draft.c.t(winkEditData);
                winkEditDataWrapper = this.mWinkEditDataWrapper;
                if (winkEditDataWrapper == null) {
                    str = winkEditDataWrapper.getMissionId();
                } else {
                    str = null;
                }
                String e26 = u.e2(str);
                winkEditDataWrapper2 = this.mWinkEditDataWrapper;
                if (winkEditDataWrapper2 != null) {
                    str2 = winkEditDataWrapper2.getMissionId();
                }
                Object obj = r26.first;
                Intrinsics.checkNotNullExpressionValue(obj, "size.first");
                int intValue = ((Number) obj).intValue();
                Object obj2 = r26.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "size.second");
                return u.U1(list, e26, coverPath, str2, intValue, ((Number) obj2).intValue(), new ArrayList(), duration);
            }
        }
        list = null;
        winkEditDataWrapper = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper == null) {
        }
        String e262 = u.e2(str);
        winkEditDataWrapper2 = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper2 != null) {
        }
        Object obj3 = r26.first;
        Intrinsics.checkNotNullExpressionValue(obj3, "size.first");
        int intValue2 = ((Number) obj3).intValue();
        Object obj22 = r26.second;
        Intrinsics.checkNotNullExpressionValue(obj22, "size.second");
        return u.U1(list, e262, coverPath, str2, intValue2, ((Number) obj22).intValue(), new ArrayList(), duration);
    }

    private final void Ih(final b callBack) {
        IPlayer currentPlayer;
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null && (currentPlayer = winkVideoTavCut.getCurrentPlayer()) != null) {
            currentPlayer.pause();
            currentPlayer.readSnapShootBitmap(new OnReadSnapShootListener() { // from class: r93.g
                @Override // com.tencent.tav.player.OnReadSnapShootListener
                public final void onSuccess(Bitmap bitmap, CMTime cMTime) {
                    QZonePublishPreviewFragment.Jh(QZonePublishPreviewFragment.this, callBack, bitmap, cMTime);
                }
            });
            currentPlayer.seek(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(QZonePublishPreviewFragment this$0, b callBack, Bitmap bitmap, CMTime cMTime) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = this$0.Gh();
        }
        callBack.a(this$0.Uh(bitmap));
    }

    private final void Kh() {
        TextView textView = this.publishBtn;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: r93.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZonePublishPreviewFragment.Lh(QZonePublishPreviewFragment.this, view);
                }
            });
        }
        TextView textView2 = this.editBtn;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: r93.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZonePublishPreviewFragment.Mh(QZonePublishPreviewFragment.this, view);
                }
            });
        }
        ImageView imageView = this.backBtn;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: r93.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZonePublishPreviewFragment.Nh(QZonePublishPreviewFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(QZonePublishPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ih(new d());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(QZonePublishPreviewFragment this$0, View view) {
        Object obj;
        List<MediaInfo> list;
        ArrayList<LocalMediaInfo> originMediaInfos;
        int collectionSizeOrDefault;
        MediaInfo copy;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        Bundle arguments = this$0.getArguments();
        if (arguments != null) {
            intent.putExtras(arguments);
        }
        ArrayList arrayList = null;
        if (this$0.useMissionId) {
            WinkEditDataWrapper winkEditDataWrapper = this$0.mWinkEditDataWrapper;
            if (winkEditDataWrapper != null && (originMediaInfos = winkEditDataWrapper.getOriginMediaInfos()) != null) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(originMediaInfos, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                for (LocalMediaInfo localMediaInfo : originMediaInfos) {
                    copy = r10.copy((r29 & 1) != 0 ? r10.mediaType : null, (r29 & 2) != 0 ? r10.albumId : null, (r29 & 4) != 0 ? r10.width : 0, (r29 & 8) != 0 ? r10.height : 0, (r29 & 16) != 0 ? r10.localMediaPath : null, (r29 & 32) != 0 ? r10.qZoneMediaId : null, (r29 & 64) != 0 ? r10.qZoneMediaThumbUrl : null, (r29 & 128) != 0 ? r10.qZoneMediaThumbWidth : 0, (r29 & 256) != 0 ? r10.qZoneMediaThumbHeight : 0, (r29 & 512) != 0 ? r10.qZoneMediaDownloadUrl : null, (r29 & 1024) != 0 ? r10.qZoneMediaSloc : null, (r29 & 2048) != 0 ? com.tencent.mobileqq.wink.picker.qzone.a.f325177a.b(localMediaInfo).duration : localMediaInfo.mDuration);
                    arrayList.add(copy);
                }
            }
            ArrayList arrayList2 = arrayList;
            Context context = this$0.getContext();
            if (context != null && arrayList2 != null) {
                com.tencent.mobileqq.wink.picker.f.f324854a.j(context, intent, 0, arrayList2, 10);
                w53.b.a("QZonePreviewFragment", "editBtn with missionID: " + arrayList2.size());
            }
        } else {
            Context context2 = this$0.getContext();
            if (context2 != null) {
                com.tencent.mobileqq.wink.picker.f fVar = com.tencent.mobileqq.wink.picker.f.f324854a;
                Bundle arguments2 = this$0.getArguments();
                if (arguments2 != null) {
                    obj = arguments2.get(QQWinkConstants.KEY_QZONE_MEDIA_INFOS);
                } else {
                    obj = null;
                }
                if (obj instanceof List) {
                    list = (List) obj;
                } else {
                    list = null;
                }
                fVar.j(context2, intent, 0, list, 10);
                w53.b.a("QZonePreviewFragment", "editBtn without missionID");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(QZonePublishPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Oh(QZonePublishPreviewFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SeekBar seekBar = this$0.mSeekBar;
        if (seekBar != null) {
            seekBar.onTouchEvent(motionEvent);
            return true;
        }
        return true;
    }

    private final void Ph() {
        boolean z16;
        Intent intent;
        Activity hostActivity = getHostActivity();
        int i3 = 0;
        if (hostActivity != null && (intent = hostActivity.getIntent()) != null) {
            z16 = intent.getBooleanExtra(QQWinkConstants.KEY_QZONE_AUTO_TEMPLATE_DISABLE_SYNC_QCIRCLE, false);
        } else {
            z16 = false;
        }
        CheckBox checkBox = this.checkBox;
        if (checkBox != null) {
            checkBox.setChecked(!z16);
        }
        if (z16) {
            i3 = 8;
        }
        CheckBox checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            checkBox2.setVisibility(i3);
        }
        TextView textView = this.checkBoxDesc;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    private final void Qh() {
        IPlayer currentPlayer;
        IPlayer.PlayerListener playerListener;
        WinkVideoTavCut winkVideoTavCut;
        WinkVideoTavCut winkVideoTavCut2 = this.mVideoTavCut;
        if (winkVideoTavCut2 != null) {
            winkVideoTavCut2.release();
        }
        dr.WinkTavCutParams winkTavCutParams = null;
        WinkVideoTavCut winkVideoTavCut3 = new WinkVideoTavCut(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.mVideoTavCut = winkVideoTavCut3;
        w53.b.a("QZonePreviewFragment", "tavCut inited: " + Boolean.valueOf(winkVideoTavCut3.getIsInit()));
        WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper != null) {
            Context it = getContext();
            if (it != null) {
                o oVar = o.f384257a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                int f16 = oVar.f(it);
                WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
                ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
                String templateFilePath = winkEditDataWrapper.getTemplateFilePath();
                Boolean bool = Boolean.FALSE;
                int g16 = o.g();
                HashMap<String, String> assetDataFromEditData = getAssetDataFromEditData();
                Boolean bool2 = i.f438428a;
                if (bool2 == null) {
                    bool2 = bool;
                }
                Intrinsics.checkNotNullExpressionValue(bool2, "if (WinkEditPerformanceW\u2026Config.isOpenFFmpegDecode");
                boolean booleanValue = bool2.booleanValue();
                Integer softDecodeThreadCnt = i.f438429b;
                Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
                winkTavCutParams = new dr.WinkTavCutParams(false, editMode, editDatas, templateFilePath, bool, g16, f16, null, assetDataFromEditData, booleanValue, softDecodeThreadCnt.intValue(), 0L, false, false, null, WinkTavCutScene.QZone, true, false, 0, 0, false, null, 4089856, null);
            }
            dr.WinkTavCutParams winkTavCutParams2 = winkTavCutParams;
            WinkVideoTavCut winkVideoTavCut4 = this.mVideoTavCut;
            if (winkVideoTavCut4 != null) {
                winkVideoTavCut4.V1(this.mPlayerLayoutFront, this.mPlayerLayoutBack);
            }
            if (winkTavCutParams2 != null && (winkVideoTavCut = this.mVideoTavCut) != null) {
                WinkVideoTavCut.P1(winkVideoTavCut, this, winkTavCutParams2, true, 0L, null, null, 56, null);
            }
            WinkVideoTavCut winkVideoTavCut5 = this.mVideoTavCut;
            if (winkVideoTavCut5 != null && (currentPlayer = winkVideoTavCut5.getCurrentPlayer()) != null && (playerListener = getPlayerListener()) != null) {
                currentPlayer.removePlayerListener(playerListener);
                currentPlayer.addPlayerListener(playerListener);
                currentPlayer.setLoopPlay(true);
            }
            Vh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(QZonePublishPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(QZonePublishPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String Uh(Bitmap bitmap) {
        String str;
        boolean z16;
        try {
            if (bitmap == null) {
                w53.b.c("QZonePreviewFragment", "\u7528\u6237\u672a\u6539\u53d8\u5c01\u9762\u56fe\uff0c\u6216\u8005\u83b7\u53d6\u5c01\u9762\u56fe\u5931\u8d25");
                return "";
            }
            w53.b.f("QZonePreviewFragment", "saveDataAndQuit: w=" + bitmap.getWidth() + " h=" + bitmap.getHeight());
            String str2 = u53.b.f438379j;
            String str3 = File.separator;
            WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
            if (winkEditDataWrapper != null) {
                str = winkEditDataWrapper.getMissionId();
            } else {
                str = null;
            }
            String str4 = str2 + str3 + str + "_" + System.currentTimeMillis() + ".JPG";
            File file = new File(str4);
            File parentFile = file.getParentFile();
            boolean z17 = true;
            if (parentFile != null && !parentFile.exists()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                File parentFile2 = file.getParentFile();
                if (parentFile2 == null || parentFile2.mkdirs()) {
                    z17 = false;
                }
                if (z17) {
                    w53.b.c("QZonePreviewFragment", "\u4fdd\u5b58\u5c01\u9762\uff0c\u521b\u5efa\u7236\u8def\u5f84\u5931\u8d25");
                }
            }
            if (!file.createNewFile()) {
                w53.b.c("QZonePreviewFragment", "\u4fdd\u5b58\u5c01\u9762\uff0c\u521b\u5efa\u5c01\u9762\u6587\u4ef6\u5931\u8d25");
            }
            if (FileUtils.saveBitmapToFile(bitmap, str4)) {
                w53.b.f("QZonePreviewFragment", "\u5c01\u9762\u4fdd\u5b58\u6210\u529f,path=" + str4);
            } else {
                w53.b.c("QZonePreviewFragment", "\u5c01\u9762\u4fdd\u5b58\u51fa\u9519");
            }
            bitmap.recycle();
            return str4;
        } catch (Exception e16) {
            w53.b.c("QZonePreviewFragment", "\u5c01\u9762\u4fdd\u5b58\u51fa\u9519:" + e16);
            return "";
        }
    }

    private final void Vh() {
        ArrayList<WinkEditData> editDatas;
        ArrayList<GYTrackStickerInfo> a16;
        WinkVideoTavCut winkVideoTavCut;
        WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper != null && (editDatas = winkEditDataWrapper.getEditDatas()) != null) {
            Iterator<T> it = editDatas.iterator();
            while (it.hasNext()) {
                Map<String, WinkStickerModelExtra> stickerExtraMap = ((WinkEditData) it.next()).getStickerExtraMap();
                if (stickerExtraMap != null) {
                    for (Map.Entry<String, WinkStickerModelExtra> entry : stickerExtraMap.entrySet()) {
                        String entityName = entry.getValue().getEntityName();
                        if (entityName != null && (a16 = ds.a(entry.getValue().getStickerTrackerResult())) != null && (winkVideoTavCut = this.mVideoTavCut) != null) {
                            WinkVideoTavCut.L3(winkVideoTavCut, a16, entityName, null, 4, null);
                        }
                    }
                }
            }
        }
        WinkVideoTavCut winkVideoTavCut2 = this.mVideoTavCut;
        if (winkVideoTavCut2 != null) {
            winkVideoTavCut2.m0(new f());
        }
    }

    private final HashMap<String, String> getAssetDataFromEditData() {
        Object firstOrNull;
        WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) winkEditDataWrapper.getEditDatas());
            WinkEditData winkEditData = (WinkEditData) firstOrNull;
            if (winkEditData == null) {
                return null;
            }
            return winkEditData.getAssetData();
        }
        return null;
    }

    private final IPlayer.PlayerListener getPlayerListener() {
        if (this.mPlayerListener == null) {
            this.mPlayerListener = new c();
        }
        return this.mPlayerListener;
    }

    private final void initMediaData(String missionId) {
        Object obj;
        List list;
        ArrayList<String> arrayList;
        LocalMediaInfo c16;
        int collectionSizeOrDefault;
        String str;
        WinkEditDataWrapper winkEditDataWrapper;
        w53.b.a("QZonePreviewFragment", "missionId: " + missionId);
        String str2 = null;
        if (!TextUtils.isEmpty(missionId)) {
            this.mWinkEditDataWrapper = a.f(missionId);
            this.initialTemplateMaterial = null;
            this.useMissionId = true;
        } else {
            this.useMissionId = false;
            Bundle arguments = getArguments();
            if (arguments != null) {
                obj = arguments.get(QQWinkConstants.KEY_QZONE_MEDIA_INFOS);
            } else {
                obj = null;
            }
            if (obj instanceof List) {
                list = (List) obj;
            } else {
                list = null;
            }
            if (list != null) {
                List list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MediaInfo) it.next()).getLocalMediaPath());
                }
            } else {
                arrayList = null;
            }
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                for (String str3 : arrayList) {
                    int mediaType = QAlbumUtil.getMediaType(str3);
                    if (mediaType != 0) {
                        if (mediaType != 1) {
                            c16 = null;
                        } else {
                            c16 = WinkExportUtils.d(str3);
                        }
                    } else {
                        c16 = WinkExportUtils.c(str3);
                    }
                    if (c16 != null) {
                        arrayList2.add(c16);
                    }
                }
            }
            try {
                w53.b.f("QZonePreviewFragment", "list size: " + arrayList2.size());
                this.mWinkEditDataWrapper = com.tencent.mobileqq.wink.editor.draft.c.d(arrayList2, 0, 0);
            } catch (Exception e16) {
                w53.b.e(WinkPreviewFragment.TAG, e16);
            }
        }
        MetaMaterial metaMaterial = this.initialTemplateMaterial;
        if (metaMaterial != null && (winkEditDataWrapper = this.mWinkEditDataWrapper) != null) {
            winkEditDataWrapper.setTemplateFilePath(WinkEditorResourceManager.a1().i2(metaMaterial));
        }
        MetaMaterial metaMaterial2 = this.initialTemplateMaterial;
        if (metaMaterial2 != null) {
            str = metaMaterial2.f30533id;
        } else {
            str = null;
        }
        WinkEditDataWrapper winkEditDataWrapper2 = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper2 != null) {
            str2 = winkEditDataWrapper2.getTemplateFilePath();
        }
        w53.b.a("QZonePreviewFragment", "material: " + str + " path: " + str2);
    }

    private final void initSeekBar() {
        FrameLayout frameLayout = this.mSeekFrameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: r93.f
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean Oh;
                    Oh = QZonePublishPreviewFragment.Oh(QZonePublishPreviewFragment.this, view, motionEvent);
                    return Oh;
                }
            });
        }
        RelativeLayout relativeLayout = this.mVideoProgressLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setMax(1000);
        }
        SeekBar seekBar2 = this.mSeekBar;
        if (seekBar2 != null) {
            seekBar2.setOnSeekBarChangeListener(new e());
        }
    }

    private final void initVideoPlayer() {
        FrameLayout frameLayout = this.mPlayerLayoutBack;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: r93.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZonePublishPreviewFragment.Sh(QZonePublishPreviewFragment.this, view);
                }
            });
        }
        FrameLayout frameLayout2 = this.mPlayerLayoutFront;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: r93.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZonePublishPreviewFragment.Rh(QZonePublishPreviewFragment.this, view);
                }
            });
        }
    }

    public final void Th(@Nullable String missionId) {
        WinkExportUtils.G();
        initMediaData(missionId);
        Qh();
        initSeekBar();
        initVideoPlayer();
        Kh();
        Ph();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hlr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePreviewFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Object obj;
        Bundle extras;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == -1) {
            String str = null;
            if (data != null && (extras = data.getExtras()) != null) {
                obj = extras.get(QQWinkConstants.MISSION_ID);
            } else {
                obj = null;
            }
            if (obj instanceof String) {
                str = (String) obj;
            }
            Th(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        WinkVideoTavCut winkVideoTavCut;
        super.onDestroyView();
        if (this.mWinkEditDataWrapper != null && (winkVideoTavCut = this.mVideoTavCut) != null) {
            winkVideoTavCut.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        WinkVideoTavCut winkVideoTavCut;
        IPlayer currentPlayer;
        super.onPause();
        if (this.mWinkEditDataWrapper != null && (winkVideoTavCut = this.mVideoTavCut) != null && (currentPlayer = winkVideoTavCut.getCurrentPlayer()) != null) {
            currentPlayer.pause();
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        TextView textView;
        TextView textView2;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        SeekBar seekBar;
        FrameLayout frameLayout3;
        RelativeLayout relativeLayout;
        TextView textView3;
        ImageView imageView;
        TextView textView4;
        CheckBox checkBox;
        TextView textView5;
        ImageView imageView2;
        Serializable serializable;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.rootView = view;
        MetaMaterial metaMaterial = null;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.f29010kh);
        } else {
            textView = null;
        }
        this.publishBtn = textView;
        View view2 = this.rootView;
        if (view2 != null) {
            textView2 = (TextView) view2.findViewById(R.id.yzd);
        } else {
            textView2 = null;
        }
        this.editBtn = textView2;
        View view3 = this.rootView;
        if (view3 != null) {
            frameLayout = (FrameLayout) view3.findViewById(R.id.f926458f);
        } else {
            frameLayout = null;
        }
        this.mPlayerLayoutFront = frameLayout;
        View view4 = this.rootView;
        if (view4 != null) {
            frameLayout2 = (FrameLayout) view4.findViewById(R.id.f926158c);
        } else {
            frameLayout2 = null;
        }
        this.mPlayerLayoutBack = frameLayout2;
        View view5 = this.rootView;
        if (view5 != null) {
            seekBar = (SeekBar) view5.findViewById(R.id.vad);
        } else {
            seekBar = null;
        }
        this.mSeekBar = seekBar;
        View view6 = this.rootView;
        if (view6 != null) {
            frameLayout3 = (FrameLayout) view6.findViewById(R.id.v9e);
        } else {
            frameLayout3 = null;
        }
        this.mSeekFrameLayout = frameLayout3;
        View view7 = this.rootView;
        if (view7 != null) {
            relativeLayout = (RelativeLayout) view7.findViewById(R.id.f123937i0);
        } else {
            relativeLayout = null;
        }
        this.mVideoProgressLayout = relativeLayout;
        View view8 = this.rootView;
        if (view8 != null) {
            textView3 = (TextView) view8.findViewById(R.id.v9f);
        } else {
            textView3 = null;
        }
        this.mVideoCurrentProgress = textView3;
        View view9 = this.rootView;
        if (view9 != null) {
            imageView = (ImageView) view9.findViewById(R.id.f644836c);
        } else {
            imageView = null;
        }
        this.mVideoPauseButton = imageView;
        View view10 = this.rootView;
        if (view10 != null) {
            textView4 = (TextView) view10.findViewById(R.id.v9h);
        } else {
            textView4 = null;
        }
        this.mVideoDurationProgress = textView4;
        View view11 = this.rootView;
        if (view11 != null) {
            checkBox = (CheckBox) view11.findViewById(R.id.f913554y);
        } else {
            checkBox = null;
        }
        this.checkBox = checkBox;
        View view12 = this.rootView;
        if (view12 != null) {
            textView5 = (TextView) view12.findViewById(R.id.f913654z);
        } else {
            textView5 = null;
        }
        this.checkBoxDesc = textView5;
        View view13 = this.rootView;
        if (view13 != null) {
            imageView2 = (ImageView) view13.findViewById(R.id.f69173i1);
        } else {
            imageView2 = null;
        }
        this.backBtn = imageView2;
        Activity hostActivity = getHostActivity();
        if (hostActivity != null && (intent = hostActivity.getIntent()) != null) {
            serializable = intent.getSerializableExtra(QQWinkConstants.KEY_QZONE_AUTO_TEMPLATE_MATERIAL);
        } else {
            serializable = null;
        }
        if (serializable instanceof MetaMaterial) {
            metaMaterial = (MetaMaterial) serializable;
        }
        this.initialTemplateMaterial = metaMaterial;
        if (!WinkExportUtils.R()) {
            w53.b.g("QZonePreviewFragment", "load so failed!");
        } else {
            Th("");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/qzone/QZonePublishPreviewFragment$f", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements ICutStatusCallback {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f326138a;

            static {
                int[] iArr = new int[MusicVolumeControlViewModel.VolumeType.values().length];
                try {
                    iArr[MusicVolumeControlViewModel.VolumeType.ORIGIN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MusicVolumeControlViewModel.VolumeType.BGM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MusicVolumeControlViewModel.VolumeType.TEMPLATE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MusicVolumeControlViewModel.VolumeType.NONE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f326138a = iArr;
            }
        }

        f() {
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
            MusicVolumeControlViewModel.VolumeType volumeType;
            int i3;
            WinkEditDataWrapper winkEditDataWrapper;
            WinkEditDataWrapper winkEditDataWrapper2 = QZonePublishPreviewFragment.this.mWinkEditDataWrapper;
            if (winkEditDataWrapper2 != null) {
                volumeType = winkEditDataWrapper2.getBgmVolumeType();
            } else {
                volumeType = null;
            }
            if (volumeType == null) {
                i3 = -1;
            } else {
                i3 = a.f326138a[volumeType.ordinal()];
            }
            if (i3 == 2) {
                WinkVideoTavCut winkVideoTavCut = QZonePublishPreviewFragment.this.mVideoTavCut;
                if (winkVideoTavCut != null) {
                    winkVideoTavCut.W2(false);
                }
            } else if (i3 == 3 && (winkEditDataWrapper = QZonePublishPreviewFragment.this.mWinkEditDataWrapper) != null) {
                float bgmVolume = winkEditDataWrapper.getBgmVolume();
                WinkVideoTavCut winkVideoTavCut2 = QZonePublishPreviewFragment.this.mVideoTavCut;
                if (winkVideoTavCut2 != null) {
                    WinkVideoTavCut.H3(winkVideoTavCut2, bgmVolume, null, 2, null);
                }
            }
            WinkEditDataWrapper winkEditDataWrapper3 = QZonePublishPreviewFragment.this.mWinkEditDataWrapper;
            if (winkEditDataWrapper3 != null) {
                float originVolume = winkEditDataWrapper3.getOriginVolume();
                WinkVideoTavCut winkVideoTavCut3 = QZonePublishPreviewFragment.this.mVideoTavCut;
                if (winkVideoTavCut3 != null) {
                    winkVideoTavCut3.o(originVolume);
                }
            }
            WinkVideoTavCut winkVideoTavCut4 = QZonePublishPreviewFragment.this.mVideoTavCut;
            if (winkVideoTavCut4 != null) {
                winkVideoTavCut4.d(this);
            }
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity rootEntity) {
        }
    }
}
