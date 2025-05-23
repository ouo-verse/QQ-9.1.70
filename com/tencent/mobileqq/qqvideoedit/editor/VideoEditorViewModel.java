package com.tencent.mobileqq.qqvideoedit.editor;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditData;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditDataWrapper;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuItem;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.picker.MediaData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.render.player.IPlayer;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b8\u0018\u0000 \u00ab\u00012\u00020\u0001:\u0004\u00ac\u0001\u00ad\u0001B\t\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002J(\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002J(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00192\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010#\u001a\u00020\u001bJ\u001a\u0010(\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020\u000fJ\u0006\u0010/\u001a\u00020\u0019J\u0006\u00100\u001a\u00020\u0019J\u0006\u00101\u001a\u00020\u000fJ\u0010\u00104\u001a\u00020\u001b2\b\u00103\u001a\u0004\u0018\u000102J\u0010\u00105\u001a\u00020\u001b2\b\u00103\u001a\u0004\u0018\u000102J\u0006\u00106\u001a\u00020\u0019J\b\u00108\u001a\u000207H\u0016J\u000e\u0010:\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0019R \u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\n0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020@0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010>R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020!0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010>R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020)0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010>R\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020)0G8\u0006\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00190;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010>R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00190G8\u0006\u00a2\u0006\f\n\u0004\bO\u0010I\u001a\u0004\bP\u0010KR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00190;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010>R\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00190G8\u0006\u00a2\u0006\f\n\u0004\bT\u0010I\u001a\u0004\bU\u0010KR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010TR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010TR$\u0010_\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R6\u0010f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eRL\u0010j\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\b2\u001a\u0010g\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bh\u0010a\u001a\u0004\bi\u0010cR(\u0010m\u001a\u0004\u0018\u0001072\b\u0010g\u001a\u0004\u0018\u0001078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bk\u0010Z\u001a\u0004\bl\u0010\\R&\u0010q\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00120;8\u0006\u00a2\u0006\f\n\u0004\br\u0010>\u001a\u0004\bs\u0010tR\u001d\u0010y\u001a\b\u0012\u0004\u0012\u00020v0;8\u0006\u00a2\u0006\f\n\u0004\bw\u0010>\u001a\u0004\bx\u0010tR#\u0010\u0080\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR(\u0010\u0086\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0081\u0001\u0010T\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R&\u0010\u008a\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0087\u0001\u0010{\u001a\u0005\b\u0088\u0001\u0010}\"\u0005\b\u0089\u0001\u0010\u007fR\u0018\u0010\u008c\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010{R'\u0010\u008f\u0001\u001a\u00020\u00192\u0006\u0010g\u001a\u00020\u00198\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\b\u008d\u0001\u0010{\u001a\u0005\b\u008e\u0001\u0010}R(\u0010\u0003\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R,\u0010\u0097\u0001\u001a\u0004\u0018\u00010$2\b\u0010g\u001a\u0004\u0018\u00010$8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b{\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R'\u0010\u009a\u0001\u001a\u00020\u00192\u0006\u0010g\u001a\u00020\u00198\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\b\u0098\u0001\u0010{\u001a\u0005\b\u0099\u0001\u0010}R(\u0010\u009e\u0001\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009b\u0001\u0010Z\u001a\u0005\b\u009c\u0001\u0010\\\"\u0005\b\u009d\u0001\u0010^R(\u0010\u00a2\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u009f\u0001\u0010T\u001a\u0006\b\u00a0\u0001\u0010\u0083\u0001\"\u0006\b\u00a1\u0001\u0010\u0085\u0001R\u001f\u0010\u00a4\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\n0G8F\u00a2\u0006\u0007\u001a\u0005\b\u00a3\u0001\u0010KR\u0019\u0010\u00a6\u0001\u001a\b\u0012\u0004\u0012\u00020@0G8F\u00a2\u0006\u0007\u001a\u0005\b\u00a5\u0001\u0010KR\u0019\u0010\u00a8\u0001\u001a\b\u0012\u0004\u0012\u00020!0G8F\u00a2\u0006\u0007\u001a\u0005\b\u00a7\u0001\u0010K\u00a8\u0006\u00ae\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "editMode", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditData;", "W1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "N1", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfoList", "P1", "mediaInfo", "", "width", "height", "", "duration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/picker/MediaData;", "M1", "O1", "Landroid/content/Intent;", "intent", "", "r2", "", NowProxyConstants.AccountInfoKey.A2, "p2", SemanticAttributes.DbSystemValues.H2, "playerWidth", "playerHeight", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw$a;", "t2", "x2", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/MenuType;", "newMenuType", "Landroid/os/Bundle;", "args", "y2", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "w2", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "v2", "Z1", ICustomDataEditor.NUMBER_PARAM_2, "l2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/content/Context;", "context", ICustomDataEditor.STRING_PARAM_2, "q2", "k2", "", "getLogTag", "isChildFragmentShow", "L1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/MenuItem;", "i", "Landroidx/lifecycle/MutableLiveData;", "_bottomDashboardMenuLiveData", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_menuSwitchActionLiveData", BdhLogUtil.LogTag.Tag_Conn, "_tavCutParamsLiveData", "D", "_renderSizeLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "e2", "()Landroidx/lifecycle/LiveData;", "renderSizeLiveData", UserInfo.SEX_FEMALE, "_isHDROpen", "G", "o2", "isHDROpen", "H", "_childFragmentHidden", "I", "R1", "childFragmentHidden", "J", "K", "L", "Ljava/lang/String;", "getTemplatePath", "()Ljava/lang/String;", "setTemplatePath", "(Ljava/lang/String;)V", "templatePath", "M", "Ljava/util/ArrayList;", "getMediaInfosOutput", "()Ljava/util/ArrayList;", "setMediaInfosOutput", "(Ljava/util/ArrayList;)V", "mediaInfosOutput", "<set-?>", "N", "b2", "mediaInfos", "P", "d2", "missionId", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/Map;", "editDataMap", BdhLogUtil.LogTag.Tag_Req, "U1", "()Landroidx/lifecycle/MutableLiveData;", "currentPlayerTimeLiveData", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", ExifInterface.LATITUDE_SOUTH, "T1", "currentPlayerStateLiveData", "T", "Z", "j2", "()Z", "u2", "(Z)V", "isAutoTemplate", "U", "getMFrom", "()I", "setMFrom", "(I)V", "mFrom", "V", "m2", "setFromCapture", "isFromCapture", "W", "mIsDisableOther", "X", "i2", "isAllImages", "Y", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "X1", "()Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/MenuType;", "S1", "()Lcom/tencent/mobileqq/qqvideoedit/editor/menu/MenuType;", "curMenuType", "a0", "getEnableImageTransition", "enableImageTransition", "b0", "getDraftMusicMid", "setDraftMusicMid", "draftMusicMid", "c0", "g2", "setUseHD", "useHD", "Q1", "bottomDashboardMenuLiveData", "c2", "menuSwitchActionLiveData", "f2", "tavCutParamsLiveData", "<init>", "()V", "d0", "a", "EditMode", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorViewModel extends BaseViewModel {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<SizeF> _renderSizeLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<SizeF> renderSizeLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isHDROpen;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isHDROpen;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _childFragmentHidden;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> childFragmentHidden;

    /* renamed from: J, reason: from kotlin metadata */
    private int playerWidth;

    /* renamed from: K, reason: from kotlin metadata */
    private int playerHeight;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String templatePath;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> mediaInfosOutput;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> mediaInfos;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private String missionId;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Map<EditMode, List<VideoEditData>> editDataMap;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> currentPlayerTimeLiveData;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<IPlayer.PlayerStatus> currentPlayerStateLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isAutoTemplate;

    /* renamed from: U, reason: from kotlin metadata */
    private int mFrom;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isFromCapture;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mIsDisableOther;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isAllImages;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private EditMode editMode;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private MenuType curMenuType;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean enableImageTransition;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String draftMusicMid;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int useHD;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MenuItem>> _bottomDashboardMenuLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MenuSwitchAction> _menuSwitchActionLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<aw.VideoTavCutParams> _tavCutParamsLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "", "(Ljava/lang/String;I)V", "Image", ComponentFactory.ComponentType.VIDEO, "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public enum EditMode {
        Image,
        Video
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275137a;

        static {
            int[] iArr = new int[MenuType.values().length];
            try {
                iArr[MenuType.TO_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f275137a = iArr;
        }
    }

    public VideoEditorViewModel() {
        MutableLiveData<SizeF> mutableLiveData = new MutableLiveData<>();
        this._renderSizeLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF>");
        this.renderSizeLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._isHDROpen = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.isHDROpen = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._childFragmentHidden = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.childFragmentHidden = mutableLiveData3;
        this.editDataMap = new LinkedHashMap();
        this.currentPlayerTimeLiveData = new MutableLiveData<>();
        this.currentPlayerStateLiveData = new MutableLiveData<>();
        this.mFrom = -1;
        this.editMode = EditMode.Video;
        this.draftMusicMid = "";
    }

    private final void A2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MenuItem.TEXT);
        arrayList.add(MenuItem.VOLUME);
        IRuntimeService runtimeService = com.tencent.mobileqq.qqvideoedit.a.b().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppRuntime().getRunti\u2026ava, ProcessConstant.ALL)");
        if (((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("rich_media_video_edit_crop", true)) {
            arrayList.add(MenuItem.CROP);
        }
        this._bottomDashboardMenuLiveData.postValue(arrayList);
        x2();
    }

    private final MediaData M1(LocalMediaInfo mediaInfo, int width, int height, long duration) {
        if (mediaInfo.mediaWidth == 0 || mediaInfo.mediaHeight == 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(mediaInfo.path, options);
            mediaInfo.mediaWidth = options.outWidth;
            mediaInfo.mediaHeight = options.outHeight;
        }
        if (mediaInfo.mediaWidth == 0 || mediaInfo.mediaHeight == 0) {
            mediaInfo.mediaWidth = 720;
            mediaInfo.mediaHeight = 1280;
        }
        String str = mediaInfo.mMimeType;
        if (str == null) {
            str = "";
        }
        int i3 = mediaInfo.mediaWidth;
        int i16 = mediaInfo.mediaHeight;
        String str2 = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str2, "mediaInfo.path");
        return new MediaData(1, str, i3, i16, 0L, 0L, duration, str2, mediaInfo.path, mediaInfo.mAlbumName);
    }

    private final ArrayList<VideoEditData> N1() {
        boolean z16;
        ArrayList<LocalMediaInfo> arrayList = this.mediaInfosOutput;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new ArrayList<>();
        }
        ArrayList<LocalMediaInfo> arrayList2 = this.mediaInfosOutput;
        Intrinsics.checkNotNull(arrayList2);
        return P1(arrayList2);
    }

    private final MediaData O1(LocalMediaInfo mediaInfo, long duration) {
        int i3;
        int i16;
        com.tencent.mobileqq.qqvideoedit.editor.export.a.d(mediaInfo);
        int i17 = mediaInfo.rotation;
        if (i17 != 90 && i17 != 270) {
            i3 = mediaInfo.mediaHeight;
            i16 = mediaInfo.mediaWidth;
        } else {
            i3 = mediaInfo.mediaWidth;
            i16 = mediaInfo.mediaHeight;
        }
        int i18 = i16;
        String str = mediaInfo.mMimeType;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.mMimeType");
        String str2 = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str2, "mediaInfo.path");
        return new MediaData(0, str, i18, i3, 0L, 0L, duration, str2, mediaInfo.path, mediaInfo.mAlbumName);
    }

    private final ArrayList<VideoEditData> P1(List<? extends LocalMediaInfo> mediaInfoList) {
        boolean z16;
        long j3;
        List filterNotNull;
        int collectionSizeOrDefault;
        long j16;
        ArrayList arrayList;
        long j17;
        MediaData M1;
        ArrayList<VideoEditData> arrayListOf;
        ResourceModel resourceModel;
        if (p2(mediaInfoList)) {
            LocalMediaInfo localMediaInfo = mediaInfoList.get(0);
            Intrinsics.checkNotNull(localMediaInfo);
            LocalMediaInfo localMediaInfo2 = localMediaInfo;
            LocalMediaInfo localMediaInfo3 = mediaInfoList.get(0);
            Intrinsics.checkNotNull(localMediaInfo3);
            int i3 = localMediaInfo3.mediaWidth;
            LocalMediaInfo localMediaInfo4 = mediaInfoList.get(0);
            Intrinsics.checkNotNull(localMediaInfo4);
            arrayList = CollectionsKt__CollectionsKt.arrayListOf(M1(localMediaInfo2, i3, localMediaInfo4.mediaHeight, 10000000L));
            j16 = 10000000;
        } else {
            if (this.isAllImages && QzoneConfig.getWinkTransitionSwitch()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.enableImageTransition = z16;
            if (z16) {
                j3 = 3500000;
            } else {
                j3 = 2500000;
            }
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mediaInfoList);
            List list = filterNotNull;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            long j18 = 0;
            int i16 = 0;
            for (Object obj : list) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                LocalMediaInfo localMediaInfo5 = (LocalMediaInfo) obj;
                if (QAlbumUtil.getMediaType(localMediaInfo5) == 1) {
                    long j19 = localMediaInfo5.mDuration * 1000;
                    j18 += j19;
                    M1 = O1(localMediaInfo5, j19);
                } else {
                    if (this.enableImageTransition && (i16 == 0 || i16 == mediaInfoList.size() - 1)) {
                        j17 = j3 - 500000;
                    } else {
                        j17 = j3;
                    }
                    M1 = M1(localMediaInfo5, localMediaInfo5.mediaWidth, localMediaInfo5.mediaHeight, j17);
                    j18 += j17;
                }
                arrayList2.add(M1);
                i16 = i17;
            }
            if (this.enableImageTransition) {
                j16 = arrayList2.size() * 2500000;
            } else {
                j16 = j18;
            }
            arrayList = arrayList2;
        }
        MediaModel a16 = hk2.a.f405214a.a(arrayList);
        ArrayList arrayList3 = new ArrayList();
        for (MediaClip mediaClip : a16.videos) {
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = ResourceModel.copy$default(resourceModel2, null, null, null, null, null, null, null, null, null, Float.valueOf(1.0f), null, null, null, null, null, null, 65023, null);
            } else {
                resourceModel = null;
            }
            arrayList3.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new VideoEditData(MediaModel.copy$default(a16, null, null, null, null, null, null, arrayList3, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null), j16, null, null, null, null, false, 124, null));
        return arrayListOf;
    }

    private final List<VideoEditData> W1(EditMode editMode) {
        if (this.editDataMap.containsKey(editMode)) {
            List<VideoEditData> list = this.editDataMap.get(editMode);
            Intrinsics.checkNotNull(list);
            return list;
        }
        ArrayList<VideoEditData> N1 = N1();
        this.editDataMap.put(editMode, N1);
        return N1;
    }

    private final boolean p2(List<? extends LocalMediaInfo> mediaInfoList) {
        LocalMediaInfo localMediaInfo;
        if (mediaInfoList.size() != 1 || (localMediaInfo = mediaInfoList.get(0)) == null || QAlbumUtil.getMediaType(localMediaInfo) == 1) {
            return false;
        }
        return true;
    }

    private final boolean r2(Intent intent) {
        VideoEditDataWrapper a16;
        EditMode editMode;
        int intExtra = intent.getIntExtra(QQWinkConstants.EDITOR_ENTRANCE, 0);
        this.mFrom = intExtra;
        if ((intExtra != 2 && intExtra != 3) || (a16 = wj2.a.a(intent.getStringExtra("key_video_video_mission_id"))) == null) {
            return false;
        }
        this.templatePath = a16.getTemplateFilePath();
        ArrayList<LocalMediaInfo> originMediaInfos = a16.getOriginMediaInfos();
        this.mediaInfos = originMediaInfos;
        this.mediaInfosOutput = originMediaInfos;
        this.missionId = a16.getMissionId();
        this.isFromCapture = a16.isFromCapture();
        this.draftMusicMid = a16.getSelectMusicMid();
        this.useHD = a16.getUseHD();
        if (this.mediaInfos == null) {
            return false;
        }
        Integer editMode2 = a16.getEditMode();
        if (editMode2 != null && editMode2.intValue() == 0) {
            editMode = EditMode.Video;
        } else {
            editMode = EditMode.Image;
        }
        this.editMode = editMode;
        this.editDataMap.put(editMode, a16.getEditData());
        return true;
    }

    public static /* synthetic */ void z2(VideoEditorViewModel videoEditorViewModel, MenuType menuType, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        videoEditorViewModel.y2(menuType, bundle);
    }

    public final void L1(boolean isChildFragmentShow) {
        this._childFragmentHidden.postValue(Boolean.valueOf(isChildFragmentShow));
    }

    @NotNull
    public final LiveData<List<MenuItem>> Q1() {
        return this._bottomDashboardMenuLiveData;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this.childFragmentHidden;
    }

    @Nullable
    /* renamed from: S1, reason: from getter */
    public final MenuType getCurMenuType() {
        return this.curMenuType;
    }

    @NotNull
    public final MutableLiveData<IPlayer.PlayerStatus> T1() {
        return this.currentPlayerStateLiveData;
    }

    @NotNull
    public final MutableLiveData<Long> U1() {
        return this.currentPlayerTimeLiveData;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final EditMode getEditMode() {
        return this.editMode;
    }

    public final int Z1() {
        if (this.editMode == EditMode.Video) {
            return 0;
        }
        return 1;
    }

    /* renamed from: a2, reason: from getter */
    public final int getMFrom() {
        return this.mFrom;
    }

    @Nullable
    public final ArrayList<LocalMediaInfo> b2() {
        return this.mediaInfos;
    }

    @NotNull
    public final LiveData<MenuSwitchAction> c2() {
        return this._menuSwitchActionLiveData;
    }

    @Nullable
    /* renamed from: d2, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @NotNull
    public final LiveData<SizeF> e2() {
        return this.renderSizeLiveData;
    }

    @NotNull
    public final LiveData<aw.VideoTavCutParams> f2() {
        return this._tavCutParamsLiveData;
    }

    /* renamed from: g2, reason: from getter */
    public final int getUseHD() {
        return this.useHD;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "VideoEditorViewModel";
    }

    public final void h2(@Nullable Intent intent) {
        boolean z16;
        boolean z17;
        boolean z18;
        EditMode editMode;
        if (intent == null) {
            return;
        }
        boolean z19 = true;
        if (!r2(intent)) {
            this.isFromCapture = intent.getBooleanExtra(QQWinkConstants.IS_FROM_CAPTURE, false);
            this.mediaInfos = intent.getParcelableArrayListExtra(AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS);
            ArrayList<LocalMediaInfo> parcelableArrayListExtra = intent.getParcelableArrayListExtra("localMediaInfos_output");
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = this.mediaInfos;
            }
            this.mediaInfosOutput = parcelableArrayListExtra;
            if (parcelableArrayListExtra == null) {
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra(QQWinkConstants.IS_AUTO_TEMPLATE, false);
            this.isAutoTemplate = booleanExtra;
            if (booleanExtra) {
                com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().k(false);
            }
            this.missionId = VideoExportViewModel.R1();
            ArrayList<LocalMediaInfo> arrayList = this.mediaInfosOutput;
            Intrinsics.checkNotNull(arrayList);
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (QAlbumUtil.getMediaType((LocalMediaInfo) it.next()) == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        z18 = false;
                        break;
                    }
                }
            }
            z18 = true;
            this.isAllImages = z18;
            if (uq3.c.d6() && this.isAllImages) {
                editMode = EditMode.Image;
            } else {
                editMode = EditMode.Video;
            }
            this.editMode = editMode;
        }
        ArrayList<LocalMediaInfo> arrayList2 = this.mediaInfosOutput;
        Intrinsics.checkNotNull(arrayList2);
        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
            Iterator<T> it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (QAlbumUtil.getMediaType((LocalMediaInfo) it5.next()) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z19 = false;
                    break;
                }
            }
        }
        this.isAllImages = z19;
        A2();
    }

    /* renamed from: i2, reason: from getter */
    public final boolean getIsAllImages() {
        return this.isAllImages;
    }

    /* renamed from: j2, reason: from getter */
    public final boolean getIsAutoTemplate() {
        return this.isAutoTemplate;
    }

    /* renamed from: k2, reason: from getter */
    public final boolean getMIsDisableOther() {
        return this.mIsDisableOther;
    }

    public final boolean l2() {
        if (this.mFrom == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: m2, reason: from getter */
    public final boolean getIsFromCapture() {
        return this.isFromCapture;
    }

    public final boolean n2() {
        if (this.mFrom == 3) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LiveData<Boolean> o2() {
        return this.isHDROpen;
    }

    public final void q2(@Nullable Context context) {
        if (this.mediaInfos == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQWinkConstants.IS_BACK_EDIT, true);
        if (!this.isFromCapture) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            ArrayList<LocalMediaInfo> arrayList2 = this.mediaInfos;
            Intrinsics.checkNotNull(arrayList2);
            Iterator<LocalMediaInfo> it = arrayList2.iterator();
            while (it.hasNext()) {
                LocalMediaInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.path)) {
                    String str = next.path;
                    Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
                    hashMap.put(str, next);
                    arrayList.add(next.path);
                }
            }
            bundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", hashMap);
            bundle.putSerializable("PhotoConst.PHOTO_PATHS", arrayList);
        }
        bundle.putBoolean(QQWinkConstants.IS_FROM_CAPTURE, this.isFromCapture);
        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchAEMultiCamera(context, bundle);
    }

    public final void s2(@Nullable Context context) {
        if (l2()) {
            q2(context);
        } else {
            n2();
        }
    }

    @Nullable
    public final aw.VideoTavCutParams t2(int playerWidth, int playerHeight) {
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        EditMode editMode = this.editMode;
        return new aw.VideoTavCutParams(true, editMode, W1(editMode), this.templatePath, playerWidth, playerHeight);
    }

    public final void u2(boolean z16) {
        this.isAutoTemplate = z16;
    }

    public final void v2(boolean isOpen) {
        if (!Intrinsics.areEqual(Boolean.valueOf(isOpen), this._isHDROpen.getValue())) {
            this._isHDROpen.postValue(Boolean.valueOf(isOpen));
        }
    }

    public final void w2(@NotNull SizeF renderSize) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        if (Intrinsics.areEqual(renderSize, this._renderSizeLiveData.getValue())) {
            return;
        }
        this._renderSizeLiveData.postValue(renderSize);
    }

    public final void x2() {
        z2(this, MenuType.BOTTOM_DASHBOARD, null, 2, null);
    }

    public final void y2(@NotNull MenuType newMenuType, @Nullable Bundle args) {
        MenuType menuType;
        Intrinsics.checkNotNullParameter(newMenuType, "newMenuType");
        if (QLog.isColorLevel()) {
            QLog.i(getTAG(), 2, "switchMenu: " + newMenuType);
        }
        MenuSwitchAction value = this._menuSwitchActionLiveData.getValue();
        if (value != null) {
            menuType = value.getMenuType();
        } else {
            menuType = null;
        }
        if (menuType == newMenuType) {
            return;
        }
        this.curMenuType = newMenuType;
        if (b.f275137a[newMenuType.ordinal()] == 1) {
            this.editMode = EditMode.Video;
            A2();
            MutableLiveData<aw.VideoTavCutParams> mutableLiveData = this._tavCutParamsLiveData;
            EditMode editMode = this.editMode;
            mutableLiveData.postValue(new aw.VideoTavCutParams(false, editMode, W1(editMode), null, this.playerWidth, this.playerHeight));
            return;
        }
        this._menuSwitchActionLiveData.postValue(new MenuSwitchAction(newMenuType, args));
    }
}
