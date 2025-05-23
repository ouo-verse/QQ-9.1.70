package com.tencent.mobileqq.wink.editor.templatecoll;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.templatecoll.f;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.AudioOutputConfig;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.VideoOutputConfig;

@Metadata(d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u00a3\u00012\u00020\u0001:\u0002\u00a4\u0001B\t\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\"\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014\u0012\u0004\u0012\u00020\r0\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0016\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002JP\u0010,\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010*H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\u0012\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0012\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010.H\u0002J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0006\u00103\u001a\u00020\rH\u0002J\u0018\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\rH\u0002J\u001a\u00108\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00107\u001a\u00020\rH\u0002J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\rH\u0002J\b\u0010<\u001a\u00020;H\u0016J\b\u0010=\u001a\u00020\rH\u0016J\b\u0010>\u001a\u00020\u0004H\u0016J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010B\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010E\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010CH\u0014J\b\u0010F\u001a\u00020\u0004H\u0014J\b\u0010G\u001a\u00020\u0004H\u0014J\b\u0010H\u001a\u00020\u0002H\u0016J\"\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\r2\u0006\u00107\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u0010K\u001a\u00020\u0004H\u0016J\b\u0010L\u001a\u00020\u0004H\u0016R\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR$\u0010^\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001b\u0010j\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010rR\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010`R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010z\u001a\u0004\u0018\u00010*8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010`R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R#\u0010\u0090\u0001\u001a\f\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0095\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0094\u0001\u0010wR\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001f\u0010\u009d\u0001\u001a\u00020\r8TX\u0094\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009a\u0001\u0010g\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001f\u0010\u00a0\u0001\u001a\u00020\r8TX\u0094\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009e\u0001\u0010g\u001a\u0006\b\u009f\u0001\u0010\u009c\u0001\u00a8\u0006\u00a5\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClippingMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "isPlaying", "", "Ja", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "Xa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "cb", "Qa", "Na", "", "position", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Lcom/tencent/videocut/model/MediaClip;", "Wa", "Lkotlin/Pair;", "", "Va", "firstIndex", "bb", "Ta", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "slots", "kb", "", "curPlayerTimeUs", "rb", "(Ljava/lang/Long;)V", "Ka", "", "Ra", "Sa", "mediaClip", "preprocessMediasIndex", "holderInfo", "", "mediaPaths", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "templateLibraryMaterial", UinConfigManager.KEY_HB, "La", "Landroid/content/Intent;", "data", "lb", "intent", "jb", "videoIndex", "Ya", "it", "nb", QzoneIPCModule.RESULT_CODE, "Ia", "clipIndex", "ob", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "B9", "M9", "initAfterInflation", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "uiData", "N9", "Landroid/os/Bundle;", "args", "L9", "pa", "onDismiss", "onBackEvent", "requestCode", "onActivityResult", "oa", "K9", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "playerStatusBtn", "N", "cancelBtn", "Landroid/support/v7/widget/RecyclerView;", "P", "Landroid/support/v7/widget/RecyclerView;", "rvPicMove", "Lcom/tencent/mobileqq/wink/editor/templatecoll/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/templatecoll/f;", "picMoveAdapter", "Ljava/util/HashMap;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/HashMap;", "mediaInfoMap", ExifInterface.LATITUDE_SOUTH, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/template/x;", "T", "Lcom/tencent/mobileqq/wink/editor/template/x;", "templateViewModel", "Lcom/tencent/mobileqq/wink/editor/templatecoll/ah;", "U", "Lkotlin/Lazy;", "Ua", "()Lcom/tencent/mobileqq/wink/editor/templatecoll/ah;", "cropViewModel", "V", "Ljava/util/List;", "mediaModelBackup", "W", "Ljava/lang/String;", "jsAssetBackup", "X", "Ljava/lang/Integer;", "currPlayLocation", "Y", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "lastCurrentReplaceMediaInfo", "Z", "lastCurrentReplaceIndex", "a0", "value", "b0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "qb", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;", "c0", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;", "templatePreprocessConfigObj", "d0", "originMediaInfo", "Lcom/tencent/mobileqq/wink/picker/TabType;", "e0", "Lcom/tencent/mobileqq/wink/picker/TabType;", "pickerTabType", "f0", "Ljava/lang/Boolean;", "needFaceDetect", "", "Lorg/light/ClipPlaceHolder;", "g0", "[Lorg/light/ClipPlaceHolder;", "clipPlaceHolders", "h0", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeControlViewModel", "i0", "needPause", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "j0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "k0", "Za", "()I", "slideUpPlayerBottomOffset", "l0", "ab", "slideUpPlayerTopOffset", "<init>", "()V", "m0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkEditorTemplateCollClippingMenuPart extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ImageView playerStatusBtn;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ImageView cancelBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private RecyclerView rvPicMove;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private f picMoveAdapter;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private HashMap<String, LocalMediaInfo> mediaInfoMap;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private ArrayList<String> mediaPaths = new ArrayList<>();

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.template.x templateViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy cropViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private List<? extends MediaClip> mediaModelBackup;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private String jsAssetBackup;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Integer currPlayLocation;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo lastCurrentReplaceMediaInfo;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private Integer lastCurrentReplaceIndex;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<TemplateLibraryHolderInfo> holderInfo;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaMaterial templateLibraryMaterial;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TemplatePreProcessConfig templatePreprocessConfigObj;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> originMediaInfo;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TabType pickerTabType;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean needFaceDetect;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ClipPlaceHolder[] clipPlaceHolders;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicVolumeControlViewModel musicVolumeControlViewModel;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean needPause;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy slideUpPlayerBottomOffset;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy slideUpPlayerTopOffset;

    public WinkEditorTemplateCollClippingMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ah>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClippingMenuPart$cropViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ah invoke() {
                return (ah) new ViewModelProvider(WinkEditorTemplateCollClippingMenuPart.this.getHostFragment().requireActivity()).get(ah.class);
            }
        });
        this.cropViewModel = lazy;
        this.jsAssetBackup = "INVALID_JS_ASSET_BACKUP";
        this.currPlayLocation = 0;
        this.lastCurrentReplaceIndex = -1;
        this.playerListener = new b();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClippingMenuPart$slideUpPlayerBottomOffset$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ImmersiveUtils.dpToPx(236.0f));
            }
        });
        this.slideUpPlayerBottomOffset = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClippingMenuPart$slideUpPlayerTopOffset$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ImmersiveUtils.dpToPx(0.0f));
            }
        });
        this.slideUpPlayerTopOffset = lazy3;
    }

    private final void Ia(Intent data, int resultCode) {
        List<MediaClip> g06;
        int collectionSizeOrDefault;
        WinkVideoTavCut winkVideoTavCut;
        RectF rectF;
        ResourceModel resourceModel;
        if (data != null) {
            int i3 = 0;
            int intExtra = data.getIntExtra("ARG_MEDIA_INDEX", 0);
            if (resultCode == 202) {
                long longExtra = data.getLongExtra("ARG_VIDEO_START", 0L);
                android.graphics.RectF rectF2 = (android.graphics.RectF) data.getParcelableExtra("ARG_CROP_RECT");
                dr H9 = H9();
                if (H9 != null && (g06 = H9.g0()) != null) {
                    List<MediaClip> list = g06;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (true) {
                        winkVideoTavCut = null;
                        ResourceModel resourceModel2 = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        MediaClip mediaClip = (MediaClip) next;
                        if (i3 == intExtra) {
                            if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
                                rectF = resourceModel.picClipRect;
                            } else {
                                rectF = null;
                            }
                            if (rectF2 != null) {
                                rectF = new RectF(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, null, 16, null);
                            }
                            RectF rectF3 = rectF;
                            ResourceModel resourceModel3 = mediaClip.resource;
                            if (resourceModel3 != null) {
                                resourceModel2 = resourceModel3.copy((r35 & 1) != 0 ? resourceModel3.id : null, (r35 & 2) != 0 ? resourceModel3.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel3.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel3.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel3.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel3.selectStart) : Long.valueOf(longExtra), (r35 & 64) != 0 ? Long.valueOf(resourceModel3.selectDuration) : null, (r35 & 128) != 0 ? resourceModel3.type : null, (r35 & 256) != 0 ? resourceModel3.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel3.volume) : null, (r35 & 1024) != 0 ? resourceModel3.extras : null, (r35 & 2048) != 0 ? resourceModel3.picClipRect : rectF3, (r35 & 4096) != 0 ? resourceModel3.reversePath : null, (r35 & 8192) != 0 ? resourceModel3.normalPath : null, (r35 & 16384) != 0 ? resourceModel3.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel3.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel3.unknownFields() : null);
                            }
                            mediaClip = MediaClip.copy$default(mediaClip, resourceModel2, null, null, null, null, null, null, 126, null);
                        }
                        arrayList.add(mediaClip);
                        i3 = i16;
                    }
                    dr H92 = H9();
                    if (H92 instanceof WinkVideoTavCut) {
                        winkVideoTavCut = (WinkVideoTavCut) H92;
                    }
                    if (winkVideoTavCut != null) {
                        winkVideoTavCut.e0(arrayList);
                    }
                }
            }
            ob(intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(boolean isPlaying) {
        if (isPlaying) {
            ImageView imageView = this.playerStatusBtn;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.oqq);
                return;
            }
            return;
        }
        ImageView imageView2 = this.playerStatusBtn;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.oqs);
        }
    }

    private final boolean Ka(int position) {
        List<TemplatePreProcessConfig.Media> medias;
        Object orNull;
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreprocessConfigObj;
        if (templatePreProcessConfig != null && (medias = templatePreProcessConfig.getMedias()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(medias, position);
            TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) orNull;
            if (media == null) {
                return true;
            }
            if (media.getIndex() < 0) {
                return false;
            }
            List<TemplatePreProcessConfig.Media.Preprocess> preprocess = media.getPreprocess();
            if (preprocess == null || preprocess.isEmpty()) {
                return true;
            }
            return false;
        }
        return true;
    }

    private final void La() {
        List<MediaClip> list;
        List<? extends MediaClip> list2 = this.mediaModelBackup;
        dr H9 = H9();
        if (H9 != null) {
            list = H9.g0();
        } else {
            list = null;
        }
        if (!Intrinsics.areEqual(list2, list)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ViewUtilsKt.n(context, 0, 0, Integer.valueOf(R.string.f239097lj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.y
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkEditorTemplateCollClippingMenuPart.Ma(WinkEditorTemplateCollClippingMenuPart.this, dialogInterface, i3);
                }
            }, null, null, 102, null);
            return;
        }
        x9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(WinkEditorTemplateCollClippingMenuPart this$0, DialogInterface dialogInterface, int i3) {
        WinkVideoTavCut winkVideoTavCut;
        HashMap<String, String> hashMapOf;
        WinkVideoTavCut winkVideoTavCut2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<? extends MediaClip> list = this$0.mediaModelBackup;
        if (list != null) {
            dr H9 = this$0.H9();
            if (H9 instanceof WinkVideoTavCut) {
                winkVideoTavCut2 = (WinkVideoTavCut) H9;
            } else {
                winkVideoTavCut2 = null;
            }
            if (winkVideoTavCut2 != null) {
                WinkVideoTavCut.t3(winkVideoTavCut2, list, false, false, 6, null);
            }
            if (this$0.lastCurrentReplaceMediaInfo != null) {
                Integer num = this$0.lastCurrentReplaceIndex;
                Intrinsics.checkNotNull(num);
                if (num.intValue() >= 0) {
                    LocalMediaInfo localMediaInfo = this$0.lastCurrentReplaceMediaInfo;
                    Intrinsics.checkNotNull(localMediaInfo);
                    Integer num2 = this$0.lastCurrentReplaceIndex;
                    Intrinsics.checkNotNull(num2);
                    this$0.nb(localMediaInfo, num2.intValue());
                }
            }
            this$0.lastCurrentReplaceIndex = -1;
            this$0.lastCurrentReplaceMediaInfo = null;
        }
        if (!Intrinsics.areEqual(this$0.jsAssetBackup, this$0.G9().T2())) {
            this$0.G9().M4(this$0.jsAssetBackup);
            dr H92 = this$0.H9();
            if (H92 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) H92;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                String str = this$0.jsAssetBackup;
                Intrinsics.checkNotNull(str);
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str));
                winkVideoTavCut.G2(hashMapOf);
            }
        }
        ImageView imageView = this$0.cancelBtn;
        if (imageView != null) {
            c.c(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_CUT_RETURN_BUTTON, null, 4, null);
        }
        MusicVolumeControlViewModel Xa = this$0.Xa();
        if (Xa != null) {
            Xa.H2(!com.tencent.videocut.render.extension.e.u(this$0.mediaModelBackup));
        }
        this$0.Ua().S1();
        this$0.x9();
    }

    private final void Na(View rootView) {
        ArrayList<LocalMediaInfo> arrayList = this.originMediaInfo;
        this.mediaInfoMap = new HashMap<>();
        this.mediaPaths.clear();
        if (arrayList != null) {
            for (LocalMediaInfo localMediaInfo : arrayList) {
                HashMap<String, LocalMediaInfo> hashMap = this.mediaInfoMap;
                Intrinsics.checkNotNull(hashMap);
                String str = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str, "it.path");
                hashMap.put(str, localMediaInfo);
                this.mediaPaths.add(localMediaInfo.path);
            }
        }
        final ArrayList<TemplateLibraryHolderInfo> arrayList2 = this.holderInfo;
        if (arrayList2 != null) {
            boolean z16 = false;
            if (arrayList != null && (!arrayList.isEmpty())) {
                z16 = true;
            }
            if (z16) {
                kb(arrayList2);
                f fVar = new f(rootView.getContext(), this.mediaInfoMap, 102, arrayList2, this.originMediaInfo, G9().getIsOpeningEndingEditMode());
                this.picMoveAdapter = fVar;
                ArrayList<String> arrayList3 = this.mediaPaths;
                fVar.J(arrayList3, arrayList3.size());
                fVar.F(this.mediaPaths);
                fVar.I(new f.a() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.w
                    @Override // com.tencent.mobileqq.wink.editor.templatecoll.f.a
                    public final void a(int i3, LocalMediaInfo localMediaInfo2) {
                        WinkEditorTemplateCollClippingMenuPart.Pa(WinkEditorTemplateCollClippingMenuPart.this, arrayList2, i3, localMediaInfo2);
                    }
                });
                fVar.K(true);
                RecyclerView recyclerView = this.rvPicMove;
                if (recyclerView != null) {
                    recyclerView.setAdapter(fVar);
                }
                G9().B2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.x
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkEditorTemplateCollClippingMenuPart.Oa(WinkEditorTemplateCollClippingMenuPart.this, (Long) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(WinkEditorTemplateCollClippingMenuPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rb(l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(WinkEditorTemplateCollClippingMenuPart this$0, ArrayList arrayList, int i3, LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int intValue = this$0.Va(i3).component2().intValue();
        Intrinsics.checkNotNullExpressionValue(localMediaInfo, "localMediaInfo");
        this$0.hb(i3, this$0.Wa(i3, localMediaInfo), intValue, arrayList, this$0.mediaPaths, localMediaInfo, this$0.templateLibraryMaterial);
    }

    private final void Qa(View rootView) {
        this.rvPicMove = (RecyclerView) rootView.findViewById(R.id.uqn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        linearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = this.rvPicMove;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.rvPicMove;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new a(6));
        }
        Na(rootView);
    }

    private final float Ra(int position) {
        int i3;
        ClipPlaceHolder[] clipPlaceHolderArr;
        List<TemplatePreProcessConfig.Media> medias;
        Object orNull;
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreprocessConfigObj;
        if (templatePreProcessConfig != null && (medias = templatePreProcessConfig.getMedias()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(medias, position);
            TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) orNull;
            if (media != null) {
                i3 = media.getIndex();
                clipPlaceHolderArr = this.clipPlaceHolders;
                if (clipPlaceHolderArr == null && i3 >= 0 && i3 < clipPlaceHolderArr.length) {
                    ClipPlaceHolder clipPlaceHolder = clipPlaceHolderArr[i3];
                    float f16 = clipPlaceHolder.width / clipPlaceHolder.height;
                    w53.b.a(this.TAG, "getClipHolderAspectRatio, position: " + position + ", ratio: " + f16);
                    return f16;
                }
                return 0.5625f;
            }
        }
        i3 = position;
        clipPlaceHolderArr = this.clipPlaceHolders;
        return clipPlaceHolderArr == null ? 0.5625f : 0.5625f;
    }

    private final int Sa(int position) {
        int i3;
        ClipPlaceHolder[] clipPlaceHolderArr;
        List<TemplatePreProcessConfig.Media> medias;
        Object orNull;
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreprocessConfigObj;
        if (templatePreProcessConfig != null && (medias = templatePreProcessConfig.getMedias()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(medias, position);
            TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) orNull;
            if (media != null) {
                i3 = media.getIndex();
                clipPlaceHolderArr = this.clipPlaceHolders;
                if (clipPlaceHolderArr == null && i3 >= 0 && i3 < clipPlaceHolderArr.length) {
                    int i16 = clipPlaceHolderArr[i3].fillMode;
                    w53.b.a(this.TAG, "getClipHolderScaleMode, : " + position + ", fillMode: " + i16);
                    return i16;
                }
                return 3;
            }
        }
        i3 = position;
        clipPlaceHolderArr = this.clipPlaceHolders;
        return clipPlaceHolderArr == null ? 3 : 3;
    }

    private final void Ta() {
        Integer num;
        MovieController assetForMovie;
        if (this.templateLibraryMaterial == null) {
            return;
        }
        LightAsset Load = LightAsset.Load(WinkEditorResourceManager.a1().m(this.templateLibraryMaterial), 0);
        String str = this.TAG;
        ClipPlaceHolder[] clipPlaceHolderArr = null;
        if (Load != null) {
            num = Integer.valueOf(Load.getErrorCode());
        } else {
            num = null;
        }
        w53.b.a(str, "getClipPlaceHolders: lightAsset errorCode: " + num);
        LightEngine make = LightEngine.make(new VideoOutputConfig(30.0f, 0), new AudioOutputConfig(), new RendererConfig());
        if (make != null && (assetForMovie = make.setAssetForMovie(Load)) != null) {
            clipPlaceHolderArr = assetForMovie.getClipPlaceHolders();
        }
        this.clipPlaceHolders = clipPlaceHolderArr;
    }

    private final ah Ua() {
        return (ah) this.cropViewModel.getValue();
    }

    private final Pair<List<Integer>, Integer> Va(int position) {
        Object orNull;
        List listOf;
        Collection emptyList;
        List plus;
        boolean z16;
        int collectionSizeOrDefault;
        List listOf2;
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreprocessConfigObj;
        if (templatePreProcessConfig == null) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(position));
            return TuplesKt.to(listOf2, Integer.valueOf(position));
        }
        List<TemplatePreProcessConfig.Media> medias = templatePreProcessConfig.getMedias();
        Intrinsics.checkNotNullExpressionValue(medias, "processConfig.medias");
        orNull = CollectionsKt___CollectionsKt.getOrNull(medias, position);
        TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) orNull;
        if (media == null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(position));
            return TuplesKt.to(listOf, Integer.valueOf(position));
        }
        List<TemplatePreProcessConfig.Media.Preprocess> preprocess = media.getPreprocess();
        if (preprocess == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<TemplatePreProcessConfig.Media.Preprocess> list = preprocess;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                emptyList.add(Integer.valueOf(((TemplatePreProcessConfig.Media.Preprocess) it.next()).getIndex()));
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Integer>) ((Collection<? extends Object>) emptyList), Integer.valueOf(media.getIndex()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : plus) {
            if (((Number) obj).intValue() >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return TuplesKt.to(arrayList, Integer.valueOf(media.getIndex()));
    }

    private final MediaClip Wa(int position, LocalMediaInfo localMediaInfo) {
        Object orNull;
        List mutableListOf;
        Object firstOrNull;
        List mutableListOf2;
        Object firstOrNull2;
        List<MediaClip> g06;
        Object orNull2;
        List<MediaClip> g07;
        Object orNull3;
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreprocessConfigObj;
        if (templatePreProcessConfig == null) {
            dr H9 = H9();
            if (H9 != null && (g07 = H9.g0()) != null) {
                orNull3 = CollectionsKt___CollectionsKt.getOrNull(g07, position);
                return (MediaClip) orNull3;
            }
            return null;
        }
        Intrinsics.checkNotNull(templatePreProcessConfig);
        List<TemplatePreProcessConfig.Media> medias = templatePreProcessConfig.getMedias();
        if (medias != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(medias, position);
            TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) orNull;
            if (media == null) {
                return null;
            }
            if (media.getIndex() >= 0) {
                dr H92 = H9();
                if (H92 != null && (g06 = H92.g0()) != null) {
                    orNull2 = CollectionsKt___CollectionsKt.getOrNull(g06, media.getIndex());
                    return (MediaClip) orNull2;
                }
                return null;
            }
            if (e93.i.I(localMediaInfo)) {
                mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(e93.i.f(localMediaInfo, false));
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) com.tencent.videocut.render.repository.a.e(com.tencent.videocut.render.repository.a.f384196a, mutableListOf2, 0.0f, 2, null));
                return (MediaClip) firstOrNull2;
            }
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(e93.i.d(localMediaInfo, 2500000L));
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) com.tencent.videocut.render.repository.a.e(com.tencent.videocut.render.repository.a.f384196a, mutableListOf, 0.0f, 2, null));
            return (MediaClip) firstOrNull;
        }
        return null;
    }

    private final MusicVolumeControlViewModel Xa() {
        FragmentActivity fragmentActivity;
        if (this.musicVolumeControlViewModel == null) {
            Fragment hostFragment = getHostFragment();
            if (hostFragment != null) {
                fragmentActivity = hostFragment.requireActivity();
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                this.musicVolumeControlViewModel = (MusicVolumeControlViewModel) new ViewModelProvider(getHostFragment().requireActivity()).get(MusicVolumeControlViewModel.class);
            }
        }
        return this.musicVolumeControlViewModel;
    }

    private final ArrayList<Integer> Ya(int videoIndex) {
        List<TemplatePreProcessConfig.Media.Preprocess> list;
        Object obj;
        boolean z16;
        boolean z17;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(videoIndex));
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreprocessConfigObj;
        if (templatePreProcessConfig == null) {
            return arrayList;
        }
        List<TemplatePreProcessConfig.Media> medias = templatePreProcessConfig.getMedias();
        Intrinsics.checkNotNullExpressionValue(medias, "config.medias");
        Iterator<T> it = medias.iterator();
        while (true) {
            list = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((TemplatePreProcessConfig.Media) obj).getIndex() == videoIndex) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) obj;
        if (media != null) {
            list = media.getPreprocess();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        for (TemplatePreProcessConfig.Media.Preprocess preprocess : list) {
            List<Integer> multipleIndexes = preprocess.getMultipleIndexes();
            if (multipleIndexes != null && !multipleIndexes.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                arrayList.add(Integer.valueOf(preprocess.getIndex()));
            } else {
                List<Integer> multipleIndexes2 = preprocess.getMultipleIndexes();
                Intrinsics.checkNotNullExpressionValue(multipleIndexes2, "processResult.multipleIndexes");
                Iterator<T> it5 = multipleIndexes2.iterator();
                while (it5.hasNext()) {
                    arrayList.add((Integer) it5.next());
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int bb(int firstIndex) {
        boolean z16;
        boolean z17;
        boolean z18;
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreprocessConfigObj;
        if (templatePreProcessConfig == null) {
            return firstIndex;
        }
        List<TemplatePreProcessConfig.Media> medias = templatePreProcessConfig.getMedias();
        Intrinsics.checkNotNullExpressionValue(medias, "processConfig.medias");
        Iterator<TemplatePreProcessConfig.Media> it = medias.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                TemplatePreProcessConfig.Media next = it.next();
                boolean z19 = true;
                if (next.getIndex() != firstIndex) {
                    List<TemplatePreProcessConfig.Media.Preprocess> preprocess = next.getPreprocess();
                    if (preprocess != null) {
                        Intrinsics.checkNotNullExpressionValue(preprocess, "preprocess");
                        List<TemplatePreProcessConfig.Media.Preprocess> list = preprocess;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it5 = list.iterator();
                            while (it5.hasNext()) {
                                if (((TemplatePreProcessConfig.Media.Preprocess) it5.next()).getIndex() == firstIndex) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    z18 = true;
                                    break;
                                }
                            }
                        }
                        z18 = false;
                        if (z18) {
                            z16 = true;
                            if (!z16) {
                                z19 = false;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                }
                if (z19) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            return i3;
        }
        return firstIndex;
    }

    private final void cb(View rootView) {
        Qa(rootView);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.aoo);
        this.cancelBtn = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTemplateCollClippingMenuPart.eb(WinkEditorTemplateCollClippingMenuPart.this, view);
                }
            });
        }
        ((ImageView) rootView.findViewById(R.id.f164879u42)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorTemplateCollClippingMenuPart.fb(WinkEditorTemplateCollClippingMenuPart.this, view);
            }
        });
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.f25790bs);
        this.playerStatusBtn = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTemplateCollClippingMenuPart.gb(WinkEditorTemplateCollClippingMenuPart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(WinkEditorTemplateCollClippingMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.La();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fb(WinkEditorTemplateCollClippingMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gb(WinkEditorTemplateCollClippingMenuPart this$0, View view) {
        boolean z16;
        dr H9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H92 = this$0.H9();
        boolean z17 = true;
        if (H92 != null && H92.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            dr H93 = this$0.H9();
            if (H93 != null) {
                H93.pause();
            }
        } else {
            dr H94 = this$0.H9();
            if (H94 == null || H94.isPlaying()) {
                z17 = false;
            }
            if (z17 && (H9 = this$0.H9()) != null) {
                H9.play();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void hb(int position, MediaClip mediaClip, int preprocessMediasIndex, ArrayList<TemplateLibraryHolderInfo> holderInfo, ArrayList<String> mediaPaths, LocalMediaInfo localMediaInfo, MetaMaterial templateLibraryMaterial) {
        long j3;
        BackgroundModel backgroundModel;
        BasePartFragment winkEditorTemplateCollClipSegFragment;
        MediaModel V;
        ResourceModel resourceModel;
        Serializable serializable;
        MediaPickerScene mediaPickerScene;
        long j16;
        long j17;
        Intent intent;
        ResourceModel copy;
        ResourceModel resourceModel2;
        Intent intent2;
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_MEDIA_INDEX", preprocessMediasIndex);
        bundle.putString("ARG_ORIGINAL_SCRIPT_PARAMS", this.jsAssetBackup);
        bundle.putSerializable("ARG_HOLDER_INFO", holderInfo.get(position));
        bundle.putSerializable(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, templateLibraryMaterial);
        bundle.putStringArrayList("ARG_SELECT_MEDIA_PATHS", mediaPaths);
        TabType tabType = this.pickerTabType;
        if (tabType != null) {
            bundle.putSerializable(QQWinkConstants.MEDIA_PICKER_TAB_TYPE, tabType);
        }
        Boolean bool = this.needFaceDetect;
        if (bool != null) {
            bundle.putSerializable(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT, Boolean.valueOf(bool.booleanValue()));
        }
        Activity activity = getActivity();
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            intent2.putExtra(QQWinkConstants.PICK_IS_FIRST_TEMPLATE, G9().getIsFromFirstTemplate());
            if (G9().getIsFromFirstTemplate() && (H9() instanceof WinkVideoTavCut)) {
                dr H9 = H9();
                Intrinsics.checkNotNull(H9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                intent2.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, ((WinkVideoTavCut) H9).getTemplateMaterial());
            }
        }
        bundle.putFloat("ARG_CROP_FRAME_ASPECT_RATIO", Ra(position));
        bundle.putInt("ARG_CROP_FRAME_SCALE_MODE", Sa(position));
        if (mediaClip != null && (resourceModel2 = mediaClip.resource) != null) {
            j3 = resourceModel2.selectStart;
        } else {
            j3 = 0;
        }
        bundle.putLong("ARG_VIDEO_SELECTION_DURATION", holderInfo.get(position).getHolderTimeSlot() * ((float) 1000000));
        bundle.putLong("ARG_VIDEO_START", j3);
        if (mediaClip != null) {
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null) {
                long j18 = resourceModel3.sourceDuration;
                copy = resourceModel3.copy((r35 & 1) != 0 ? resourceModel3.id : null, (r35 & 2) != 0 ? resourceModel3.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel3.scaleDuration) : Long.valueOf(j18), (r35 & 8) != 0 ? Long.valueOf(resourceModel3.sourceStart) : 0L, (r35 & 16) != 0 ? Long.valueOf(resourceModel3.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel3.selectStart) : 0L, (r35 & 64) != 0 ? Long.valueOf(resourceModel3.selectDuration) : Long.valueOf(j18), (r35 & 128) != 0 ? resourceModel3.type : null, (r35 & 256) != 0 ? resourceModel3.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel3.volume) : null, (r35 & 1024) != 0 ? resourceModel3.extras : null, (r35 & 2048) != 0 ? resourceModel3.picClipRect : null, (r35 & 4096) != 0 ? resourceModel3.reversePath : null, (r35 & 8192) != 0 ? resourceModel3.normalPath : null, (r35 & 16384) != 0 ? resourceModel3.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel3.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel3.unknownFields() : null);
                resourceModel = copy;
            } else {
                resourceModel = null;
            }
            bundle.putParcelable("ARG_VIDEO_CLIP", MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
            Activity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                serializable = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
            } else {
                serializable = null;
            }
            if (serializable instanceof MediaPickerScene) {
                mediaPickerScene = (MediaPickerScene) serializable;
            } else {
                mediaPickerScene = null;
            }
            if (mediaPickerScene == MediaPickerScene.TEMPLATE_ZSHOW) {
                ResourceModel resourceModel4 = mediaClip.resource;
                if (resourceModel4 != null) {
                    j16 = resourceModel4.sourceDuration;
                } else {
                    j16 = 0;
                }
                if (j16 < bundle.getLong("ARG_VIDEO_SELECTION_DURATION")) {
                    ResourceModel resourceModel5 = mediaClip.resource;
                    if (resourceModel5 != null) {
                        j17 = resourceModel5.sourceDuration;
                    } else {
                        j17 = 0;
                    }
                    bundle.putLong("ARG_VIDEO_SELECTION_DURATION", j17);
                }
            }
        }
        bundle.putString("ARG_IMAGE_PATH", localMediaInfo.path);
        dr H92 = H9();
        if (H92 != null && (V = H92.V()) != null) {
            backgroundModel = V.backgroundModel;
        } else {
            backgroundModel = null;
        }
        bundle.putParcelable("ARG_BACKGROUND_MODEL", backgroundModel);
        bundle.putBoolean("ARG_IS_IMAGE_CLIP", e93.i.G(localMediaInfo));
        bundle.putParcelable("ARG_ORIGIN_MEDIA_INFO", localMediaInfo);
        if (Ka(position)) {
            winkEditorTemplateCollClipSegFragment = new WinkEditorTemplateCollCropFragment();
        } else if (e93.i.G(localMediaInfo)) {
            winkEditorTemplateCollClipSegFragment = new WinkEditorTemplateCollImageFragment();
        } else {
            winkEditorTemplateCollClipSegFragment = new WinkEditorTemplateCollClipSegFragment();
        }
        winkEditorTemplateCollClipSegFragment.setArguments(bundle);
        winkEditorTemplateCollClipSegFragment.setTargetFragment(getHostFragment(), 100);
        dr H93 = H9();
        if (H93 != null) {
            H93.pause();
        }
        this.needPause = true;
        getHostFragment().requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.f123867ht, winkEditorTemplateCollClipSegFragment, winkEditorTemplateCollClipSegFragment.getTAG()).addToBackStack(winkEditorTemplateCollClipSegFragment.getTAG()).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(WinkEditorTemplateCollClippingMenuPart this$0, ArrayList localMediaInfo) {
        MetaMaterial curTemplateMaterial;
        int lastIndex;
        Integer num;
        int lastIndex2;
        TemplateLibraryHolderInfo templateLibraryHolderInfo;
        int lastIndex3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditUIData C9 = this$0.C9();
        this$0.originMediaInfo = localMediaInfo;
        ArrayList<TemplateLibraryHolderInfo> arrayList = new ArrayList<>();
        if (this$0.holderInfo != null) {
            Intrinsics.checkNotNullExpressionValue(localMediaInfo, "localMediaInfo");
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(localMediaInfo);
            if (lastIndex >= 0) {
                int i3 = 0;
                while (true) {
                    Object obj = localMediaInfo.get(i3);
                    Intrinsics.checkNotNullExpressionValue(obj, "localMediaInfo[i]");
                    LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) obj;
                    ArrayList<TemplateLibraryHolderInfo> arrayList2 = this$0.holderInfo;
                    if (arrayList2 != null) {
                        num = Integer.valueOf(arrayList2.size());
                    } else {
                        num = null;
                    }
                    Intrinsics.checkNotNull(num);
                    if (i3 < num.intValue()) {
                        ArrayList<TemplateLibraryHolderInfo> arrayList3 = this$0.holderInfo;
                        Intrinsics.checkNotNull(arrayList3);
                        templateLibraryHolderInfo = arrayList3.get(i3);
                    } else {
                        ArrayList<TemplateLibraryHolderInfo> arrayList4 = this$0.holderInfo;
                        Intrinsics.checkNotNull(arrayList4);
                        lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList4);
                        if (lastIndex2 >= 0) {
                            ArrayList<TemplateLibraryHolderInfo> arrayList5 = this$0.holderInfo;
                            Intrinsics.checkNotNull(arrayList5);
                            ArrayList<TemplateLibraryHolderInfo> arrayList6 = this$0.holderInfo;
                            Intrinsics.checkNotNull(arrayList6);
                            lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(arrayList6);
                            templateLibraryHolderInfo = arrayList5.get(lastIndex3);
                        } else {
                            templateLibraryHolderInfo = new TemplateLibraryHolderInfo(localMediaInfo2, -1.0f, "");
                        }
                    }
                    arrayList.add(TemplateLibraryHolderInfo.copy$default(templateLibraryHolderInfo, null, ((float) localMediaInfo2.mDuration) / 1000100, null, 5, null));
                    if (i3 == lastIndex) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this$0.holderInfo = arrayList;
        if (C9 instanceof TemplateCollClippingUIData) {
            TemplateCollClippingUIData templateCollClippingUIData = (TemplateCollClippingUIData) C9;
            templateCollClippingUIData.setOriginMediaInfo(this$0.originMediaInfo);
            templateCollClippingUIData.setHolderInfo(arrayList);
        }
        this$0.G9().i5(this$0.holderInfo);
        if (this$0.getPartRootView() != null) {
            View partRootView = this$0.getPartRootView();
            Intrinsics.checkNotNull(partRootView);
            this$0.Na(partRootView);
        }
        com.tencent.mobileqq.wink.editor.template.x xVar = this$0.templateViewModel;
        if (xVar != null && (curTemplateMaterial = xVar.getCurTemplateMaterial()) != null) {
            this$0.qb(curTemplateMaterial);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0047 A[Catch: Exception -> 0x0081, TryCatch #0 {Exception -> 0x0081, blocks: (B:3:0x0006, B:5:0x0010, B:7:0x001b, B:13:0x0029, B:15:0x0031, B:17:0x0037, B:33:0x0047, B:36:0x0056, B:37:0x0068, B:39:0x006e, B:41:0x007c), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void jb(Intent intent) {
        String str;
        HashMap<String, String> hashMapOf;
        String T2;
        String str2;
        boolean z16;
        WinkVideoTavCut winkVideoTavCut;
        HashMap<String, String> hashMapOf2;
        boolean isBlank;
        WinkVideoTavCut winkVideoTavCut2 = null;
        try {
            T2 = G9().T2();
            if (intent != null) {
                str2 = intent.getStringExtra("key_template_asset");
            } else {
                str2 = null;
            }
        } catch (Exception e16) {
            w53.b.d(this.TAG, "parseAndApplyJsAssetParams: fail", e16);
        }
        if (str2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    if (T2 != null) {
                        dr H9 = H9();
                        if (H9 instanceof WinkVideoTavCut) {
                            winkVideoTavCut = (WinkVideoTavCut) H9;
                        } else {
                            winkVideoTavCut = null;
                        }
                        if (winkVideoTavCut != null) {
                            hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, T2));
                            winkVideoTavCut.G2(hashMapOf2);
                        }
                    }
                    str = null;
                    if (str == null && !Intrinsics.areEqual(str, this.jsAssetBackup)) {
                        G9().M4(str);
                        dr H92 = H9();
                        if (H92 instanceof WinkVideoTavCut) {
                            winkVideoTavCut2 = (WinkVideoTavCut) H92;
                        }
                        if (winkVideoTavCut2 != null) {
                            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str));
                            winkVideoTavCut2.G2(hashMapOf);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String T22 = G9().T2();
                if (T22 == null) {
                    T22 = "{}";
                }
                JSONObject jSONObject = new JSONObject(T22);
                JSONObject jSONObject2 = new JSONObject(str2);
                Iterator keys = jSONObject2.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "newScriptJsonObj.keys()");
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    jSONObject.put(str3, jSONObject2.get(str3));
                }
                str = jSONObject.toString();
                if (str == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final void kb(ArrayList<TemplateLibraryHolderInfo> slots) {
        boolean z16;
        Long l3;
        ListIterator<TemplateLibraryHolderInfo> listIterator = slots.listIterator();
        Intrinsics.checkNotNullExpressionValue(listIterator, "slots.listIterator()");
        while (listIterator.hasNext()) {
            TemplateLibraryHolderInfo next = listIterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "slotsIterator.next()");
            TemplateLibraryHolderInfo templateLibraryHolderInfo = next;
            if (templateLibraryHolderInfo.getHolderTimeSlot() == -1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && H9() != null) {
                dr H9 = H9();
                Long l16 = null;
                if (H9 != null) {
                    l3 = Long.valueOf(H9.getDurationUs());
                } else {
                    l3 = null;
                }
                if (l3 != null) {
                    LocalMediaInfo mediaInfo = templateLibraryHolderInfo.getMediaInfo();
                    dr H92 = H9();
                    if (H92 != null) {
                        l16 = Long.valueOf(H92.getDurationUs());
                    }
                    Intrinsics.checkNotNull(l16);
                    TemplateLibraryHolderInfo templateLibraryHolderInfo2 = new TemplateLibraryHolderInfo(mediaInfo, ((float) l16.longValue()) / 1000000.0f, templateLibraryHolderInfo.getHolderHintText());
                    listIterator.remove();
                    listIterator.add(templateLibraryHolderInfo2);
                }
            }
        }
    }

    private final void lb(Intent data) {
        boolean z16;
        List sorted;
        boolean z17;
        boolean z18;
        LocalMediaInfo localMediaInfo;
        int collectionSizeOrDefault;
        Map map;
        WinkVideoTavCut winkVideoTavCut;
        List<MediaClip> g06;
        WinkVideoTavCut winkVideoTavCut2;
        Float f16;
        ResourceModel copy;
        LiveData<Float> h26;
        Serializable serializable;
        MediaPickerScene mediaPickerScene;
        Iterator it;
        ArrayList arrayList;
        List<MediaData> listOf;
        MediaModel b16;
        ResourceModel copy2;
        List<MediaData> listOf2;
        Intent intent;
        List<MediaClip> g07;
        MediaClip mediaClip;
        ResourceModel resourceModel;
        boolean z19;
        Intent intent2 = data;
        if (intent2 != null) {
            int intExtra = intent2.getIntExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_INDEX, 0);
            ArrayList parcelableArrayListExtra = intent2.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            ArrayList parcelableArrayListExtra2 = intent2.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL);
            if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                parcelableArrayListExtra = intent2.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL);
            }
            ArrayList<Integer> Ya = Ya(intExtra);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : Ya) {
                if (((Number) obj).intValue() >= 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    arrayList2.add(obj);
                }
            }
            sorted = CollectionsKt___CollectionsKt.sorted(arrayList2);
            if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parcelableArrayListExtra, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = parcelableArrayListExtra.iterator();
                int i3 = 0;
                while (true) {
                    long j3 = 0;
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) next;
                    int intValue = ((Number) sorted.get(i3)).intValue();
                    dr H9 = H9();
                    if (H9 != null && (g07 = H9.g0()) != null && (mediaClip = g07.get(intValue)) != null && (resourceModel = mediaClip.resource) != null) {
                        j3 = resourceModel.selectDuration;
                    } else {
                        dr H92 = H9();
                        if (H92 != null) {
                            j3 = H92.getDurationUs();
                        }
                    }
                    float floatExtra = intent2.getFloatExtra(QQWinkConstants.MEDIA_PICKER_TEMPLATE_LIBRARY_HOLDER_TIME_SLOT, 0.0f);
                    Activity activity = getActivity();
                    if (activity != null && (intent = activity.getIntent()) != null) {
                        serializable = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
                    } else {
                        serializable = null;
                    }
                    if (serializable instanceof MediaPickerScene) {
                        mediaPickerScene = (MediaPickerScene) serializable;
                    } else {
                        mediaPickerScene = null;
                    }
                    if (mediaPickerScene == MediaPickerScene.TEMPLATE_ZSHOW) {
                        j3 = ((float) 1000000) * floatExtra;
                        it = it5;
                        arrayList = arrayList3;
                        if (((float) localMediaInfo2.mDuration) < floatExtra * ((float) 1000) && !e93.i.G(localMediaInfo2)) {
                            j3 = localMediaInfo2.mDuration * 1000;
                        }
                    } else {
                        it = it5;
                        arrayList = arrayList3;
                    }
                    if (e93.i.G(localMediaInfo2)) {
                        com.tencent.videocut.render.repository.a aVar = com.tencent.videocut.render.repository.a.f384196a;
                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(e93.i.d(localMediaInfo2, j3));
                        b16 = aVar.b(listOf2);
                    } else {
                        com.tencent.videocut.render.repository.a aVar2 = com.tencent.videocut.render.repository.a.f384196a;
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(e93.i.f(localMediaInfo2, false));
                        b16 = aVar2.b(listOf);
                    }
                    if (G9().a2() && G9().R2() != null) {
                        ArrayList<LocalMediaInfo> R2 = G9().R2();
                        Intrinsics.checkNotNull(R2);
                        if (R2.size() > intValue) {
                            ArrayList<LocalMediaInfo> R22 = G9().R2();
                            Intrinsics.checkNotNull(R22);
                            R22.set(intValue, localMediaInfo2);
                        }
                    }
                    MediaClip mediaClip2 = b16.videos.get(0);
                    ResourceModel resourceModel2 = mediaClip2.resource;
                    ResourceModel resourceModel3 = null;
                    if (resourceModel2 != null) {
                        copy2 = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : Long.valueOf(j3), (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : Long.valueOf(j3), (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
                        resourceModel3 = copy2;
                    }
                    arrayList.add(TuplesKt.to(Integer.valueOf(intValue), MediaClip.copy$default(mediaClip2, resourceModel3, null, null, null, null, null, null, 126, null)));
                    intent2 = data;
                    arrayList3 = arrayList;
                    i3 = i16;
                    it5 = it;
                }
                map = MapsKt__MapsKt.toMap(arrayList3);
                dr H93 = H9();
                if (H93 != null && (g06 = H93.g0()) != null) {
                    ArrayList arrayList4 = new ArrayList(g06);
                    for (Map.Entry entry : map.entrySet()) {
                        arrayList4.set(((Number) entry.getKey()).intValue(), (MediaClip) entry.getValue());
                    }
                    MusicVolumeControlViewModel Xa = Xa();
                    if (Xa != null) {
                        z18 = true;
                        Xa.H2(!com.tencent.videocut.render.extension.e.u(arrayList4));
                    } else {
                        z18 = true;
                    }
                    if (!com.tencent.videocut.render.extension.e.u(arrayList4)) {
                        MusicVolumeControlViewModel Xa2 = Xa();
                        if (Xa2 != null && (h26 = Xa2.h2()) != null) {
                            f16 = h26.getValue();
                        } else {
                            f16 = null;
                        }
                        if (f16 == null) {
                            f16 = Float.valueOf(0.15f);
                            MusicVolumeControlViewModel Xa3 = Xa();
                            if (Xa3 != null) {
                                Xa3.S1(f16.floatValue(), MusicVolumeControlViewModel.VolumeType.ORIGIN);
                            }
                        }
                        w53.b.a(this.TAG, "currentOriginVolume: " + f16);
                        int i17 = 0;
                        for (Object obj2 : arrayList4) {
                            int i18 = i17 + 1;
                            if (i17 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            MediaClip media = (MediaClip) obj2;
                            Intrinsics.checkNotNullExpressionValue(media, "media");
                            ResourceModel resourceModel4 = media.resource;
                            ResourceModel resourceModel5 = null;
                            if (resourceModel4 != null) {
                                copy = resourceModel4.copy((r35 & 1) != 0 ? resourceModel4.id : null, (r35 & 2) != 0 ? resourceModel4.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel4.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel4.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel4.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel4.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel4.selectDuration) : null, (r35 & 128) != 0 ? resourceModel4.type : null, (r35 & 256) != 0 ? resourceModel4.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel4.volume) : f16, (r35 & 1024) != 0 ? resourceModel4.extras : null, (r35 & 2048) != 0 ? resourceModel4.picClipRect : null, (r35 & 4096) != 0 ? resourceModel4.reversePath : null, (r35 & 8192) != 0 ? resourceModel4.normalPath : null, (r35 & 16384) != 0 ? resourceModel4.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel4.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel4.unknownFields() : null);
                                resourceModel5 = copy;
                            }
                            arrayList4.set(i17, MediaClip.copy$default(media, resourceModel5, null, null, null, null, null, null, 126, null));
                            i17 = i18;
                        }
                    }
                    dr H94 = H9();
                    if (H94 instanceof WinkVideoTavCut) {
                        winkVideoTavCut2 = (WinkVideoTavCut) H94;
                    } else {
                        winkVideoTavCut2 = null;
                    }
                    if (winkVideoTavCut2 != null) {
                        WinkVideoTavCut.t3(winkVideoTavCut2, arrayList4, false, false, 6, null);
                    }
                } else {
                    z18 = true;
                }
                dr H95 = H9();
                if (H95 instanceof WinkVideoTavCut) {
                    winkVideoTavCut = (WinkVideoTavCut) H95;
                } else {
                    winkVideoTavCut = null;
                }
                if (winkVideoTavCut != null) {
                    winkVideoTavCut.seek(0L);
                }
            } else {
                z18 = true;
            }
            if (parcelableArrayListExtra2 != null && !parcelableArrayListExtra2.isEmpty()) {
                z18 = false;
            }
            if (!z18) {
                LocalMediaInfo it6 = (LocalMediaInfo) parcelableArrayListExtra2.get(0);
                int bb5 = bb(intExtra);
                if (this.mediaPaths.size() > bb5 && bb5 >= 0) {
                    this.lastCurrentReplaceIndex = Integer.valueOf(bb5);
                    HashMap<String, LocalMediaInfo> hashMap = this.mediaInfoMap;
                    if (hashMap != null) {
                        localMediaInfo = hashMap.get(this.mediaPaths.get(bb5));
                    } else {
                        localMediaInfo = null;
                    }
                    this.lastCurrentReplaceMediaInfo = localMediaInfo;
                }
                Intrinsics.checkNotNullExpressionValue(it6, "it");
                nb(it6, bb5);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorTemplateCollClippingMenuPart.mb(WinkEditorTemplateCollClippingMenuPart.this);
                    }
                }, 300L);
            }
            jb(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mb(WinkEditorTemplateCollClippingMenuPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            H9.play();
        }
    }

    private final void nb(LocalMediaInfo it, int videoIndex) {
        HashMap<String, LocalMediaInfo> hashMap = this.mediaInfoMap;
        if (hashMap != null) {
            String str = it.path;
            Intrinsics.checkNotNullExpressionValue(str, "it.path");
            hashMap.put(str, it);
        }
        if (this.mediaPaths.size() > videoIndex) {
            this.mediaPaths.set(videoIndex, it.path);
        }
        ArrayList<LocalMediaInfo> arrayList = this.originMediaInfo;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (arrayList.size() > videoIndex) {
                WinkEditUIData C9 = C9();
                ArrayList<LocalMediaInfo> arrayList2 = this.originMediaInfo;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.set(videoIndex, it);
                if (C9 instanceof TemplateCollClippingUIData) {
                    ((TemplateCollClippingUIData) C9).setOriginMediaInfo(this.originMediaInfo);
                }
            }
        }
        f fVar = this.picMoveAdapter;
        if (fVar != null) {
            fVar.G(this.mediaPaths);
            fVar.notifyDataSetChanged();
        }
    }

    private final void ob(int clipIndex) {
        List<MediaClip> g06;
        long j3;
        final Ref.LongRef longRef = new Ref.LongRef();
        dr H9 = H9();
        if (H9 != null && (g06 = H9.g0()) != null) {
            int i3 = 0;
            for (Object obj : g06) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MediaClip mediaClip = (MediaClip) obj;
                if (i3 < clipIndex) {
                    long j16 = longRef.element;
                    ResourceModel resourceModel = mediaClip.resource;
                    if (resourceModel != null) {
                        j3 = resourceModel.sourceDuration;
                    } else {
                        j3 = 0;
                    }
                    longRef.element = j16 + j3;
                }
                i3 = i16;
            }
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.r
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorTemplateCollClippingMenuPart.pb(WinkEditorTemplateCollClippingMenuPart.this, longRef);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pb(WinkEditorTemplateCollClippingMenuPart this$0, Ref.LongRef startTime) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        dr H9 = this$0.H9();
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.seek(startTime.element);
            this$0.rb(Long.valueOf(startTime.element));
            if (!winkVideoTavCut.isPlaying()) {
                winkVideoTavCut.play();
                this$0.needPause = false;
            }
        }
    }

    private final void qb(MetaMaterial metaMaterial) {
        TemplatePreProcessConfig templatePreProcessConfig;
        this.templateLibraryMaterial = metaMaterial;
        if (metaMaterial != null) {
            templatePreProcessConfig = com.tencent.mobileqq.wink.editor.c.H0(metaMaterial);
        } else {
            templatePreProcessConfig = null;
        }
        this.templatePreprocessConfigObj = templatePreProcessConfig;
    }

    private final void rb(Long curPlayerTimeUs) {
        int i3;
        Intrinsics.checkNotNull(curPlayerTimeUs);
        if (curPlayerTimeUs.longValue() > 0) {
            f fVar = this.picMoveAdapter;
            if (fVar != null) {
                i3 = fVar.L(((float) curPlayerTimeUs.longValue()) / 1000000.0f);
            } else {
                i3 = 0;
            }
            if (i3 >= 0) {
                Integer num = this.currPlayLocation;
                if (num == null || i3 != num.intValue()) {
                    this.currPlayLocation = Integer.valueOf(i3);
                    com.tencent.mobileqq.wink.utils.b.e(this.rvPicMove, 0, i3);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f93885as;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        List<MediaClip> list;
        MetaMaterial metaMaterial;
        boolean z16;
        dr H9;
        super.L9(args);
        ra(Za(), ab());
        boolean z17 = true;
        if (H9() instanceof WinkVideoTavCut) {
            dr H92 = H9();
            if (H92 != null && !H92.isPlaying()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (H9 = H9()) != null) {
                H9.play();
            }
        }
        dr H93 = H9();
        if (H93 == null || !H93.isPlaying()) {
            z17 = false;
        }
        Ja(z17);
        dr H94 = H9();
        if (H94 != null) {
            H94.addPlayerListener(this.playerListener);
        }
        dr H95 = H9();
        String str = null;
        if (H95 != null) {
            list = H95.g0();
        } else {
            list = null;
        }
        this.mediaModelBackup = list;
        this.jsAssetBackup = G9().T2();
        com.tencent.mobileqq.wink.editor.template.x xVar = this.templateViewModel;
        if (xVar != null && xVar.getCurTemplateMaterial() != null && this.templateLibraryMaterial == null) {
            com.tencent.mobileqq.wink.editor.template.x xVar2 = this.templateViewModel;
            if (xVar2 != null) {
                metaMaterial = xVar2.getCurTemplateMaterial();
            } else {
                metaMaterial = null;
            }
            qb(metaMaterial);
        }
        ah Ua = Ua();
        MetaMaterial metaMaterial2 = this.templateLibraryMaterial;
        if (metaMaterial2 != null) {
            str = metaMaterial2.f30533id;
        }
        Ua.L1(str);
        Ta();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        ArrayList<TemplateLibraryHolderInfo> arrayList;
        MetaMaterial metaMaterial;
        Intent intent;
        TabType tabType;
        Boolean bool;
        TemplateCollClippingUIData templateCollClippingUIData;
        TemplateCollClippingUIData templateCollClippingUIData2;
        TemplateCollClippingUIData templateCollClippingUIData3;
        TemplateCollClippingUIData templateCollClippingUIData4;
        super.M9();
        if (getUiData() == null) {
            O9(new TemplateCollClippingUIData(this));
        }
        ArrayList<LocalMediaInfo> parcelableArrayListExtra = getActivity().getIntent().getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL);
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = getActivity().getIntent().getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
        }
        TemplateCollClippingUIData templateCollClippingUIData5 = null;
        if (parcelableArrayListExtra != null) {
            WinkEditUIData C9 = C9();
            if (C9 instanceof TemplateCollClippingUIData) {
                templateCollClippingUIData4 = (TemplateCollClippingUIData) C9;
            } else {
                templateCollClippingUIData4 = null;
            }
            if (templateCollClippingUIData4 != null) {
                templateCollClippingUIData4.setOriginMediaInfo(parcelableArrayListExtra);
            }
            this.originMediaInfo = parcelableArrayListExtra;
        }
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("template_holder_slot");
        if (serializableExtra instanceof ArrayList) {
            arrayList = (ArrayList) serializableExtra;
        } else {
            arrayList = null;
        }
        if (G9().a2() && arrayList == null && G9().r3() != null) {
            List<TemplateLibraryHolderInfo> r36 = G9().r3();
            Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo>");
            arrayList = (ArrayList) r36;
        }
        if (arrayList != null) {
            WinkEditUIData C92 = C9();
            if (C92 instanceof TemplateCollClippingUIData) {
                templateCollClippingUIData3 = (TemplateCollClippingUIData) C92;
            } else {
                templateCollClippingUIData3 = null;
            }
            if (templateCollClippingUIData3 != null) {
                templateCollClippingUIData3.setHolderInfo(arrayList);
            }
            this.holderInfo = arrayList;
        }
        Serializable serializableExtra2 = getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (serializableExtra2 instanceof MetaMaterial) {
            metaMaterial = (MetaMaterial) serializableExtra2;
        } else {
            metaMaterial = null;
        }
        if (metaMaterial != null) {
            WinkEditUIData C93 = C9();
            if (C93 instanceof TemplateCollClippingUIData) {
                templateCollClippingUIData2 = (TemplateCollClippingUIData) C93;
            } else {
                templateCollClippingUIData2 = null;
            }
            if (templateCollClippingUIData2 != null) {
                templateCollClippingUIData2.setTemplateLibraryMaterial(metaMaterial);
            }
            qb(metaMaterial);
        }
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            Serializable serializableExtra3 = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_TAB_TYPE);
            if (serializableExtra3 instanceof TabType) {
                tabType = (TabType) serializableExtra3;
            } else {
                tabType = null;
            }
            if (tabType != null) {
                WinkEditUIData C94 = C9();
                if (C94 instanceof TemplateCollClippingUIData) {
                    templateCollClippingUIData = (TemplateCollClippingUIData) C94;
                } else {
                    templateCollClippingUIData = null;
                }
                if (templateCollClippingUIData != null) {
                    templateCollClippingUIData.setPickerTabType(tabType);
                }
                this.pickerTabType = tabType;
            }
            Serializable serializableExtra4 = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT);
            if (serializableExtra4 instanceof Boolean) {
                bool = (Boolean) serializableExtra4;
            } else {
                bool = null;
            }
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                WinkEditUIData C95 = C9();
                if (C95 instanceof TemplateCollClippingUIData) {
                    templateCollClippingUIData5 = (TemplateCollClippingUIData) C95;
                }
                if (templateCollClippingUIData5 != null) {
                    templateCollClippingUIData5.setNeedFaceDetect(Boolean.valueOf(booleanValue));
                }
                this.needFaceDetect = Boolean.valueOf(booleanValue);
            }
        }
        G9().P2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTemplateCollClippingMenuPart.ib(WinkEditorTemplateCollClippingMenuPart.this, (ArrayList) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData uiData) {
        super.N9(uiData);
        if (uiData instanceof TemplateCollClippingUIData) {
            TemplateCollClippingUIData templateCollClippingUIData = (TemplateCollClippingUIData) uiData;
            this.holderInfo = templateCollClippingUIData.getHolderInfo();
            this.originMediaInfo = templateCollClippingUIData.getOriginMediaInfo();
            qb(templateCollClippingUIData.getTemplateLibraryMaterial());
            this.pickerTabType = templateCollClippingUIData.getPickerTabType();
            this.needFaceDetect = templateCollClippingUIData.getNeedFaceDetect();
            ah Ua = Ua();
            if (Ua != null) {
                Ua.R1(templateCollClippingUIData);
            }
        }
        if (getUiData() == null) {
            O9(new TemplateCollClippingUIData(this));
        }
        WinkEditUIData C9 = C9();
        if (C9 instanceof TemplateCollClippingUIData) {
            TemplateCollClippingUIData templateCollClippingUIData2 = (TemplateCollClippingUIData) C9;
            templateCollClippingUIData2.setOriginMediaInfo(this.originMediaInfo);
            templateCollClippingUIData2.setHolderInfo(this.holderInfo);
            templateCollClippingUIData2.setTemplateLibraryMaterial(this.templateLibraryMaterial);
            templateCollClippingUIData2.setPickerTabType(this.pickerTabType);
            templateCollClippingUIData2.setNeedFaceDetect(this.needFaceDetect);
        }
    }

    protected int Za() {
        return ((Number) this.slideUpPlayerBottomOffset.getValue()).intValue();
    }

    protected int ab() {
        return ((Number) this.slideUpPlayerTopOffset.getValue()).intValue();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.TEMPLATE_COLL_CLIP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        this.templateViewModel = (com.tencent.mobileqq.wink.editor.template.x) getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
        ah Ua = Ua();
        WinkEditUIData uiData = getUiData();
        Intrinsics.checkNotNull(uiData, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.templatecoll.TemplateCollClippingUIData");
        Ua.Q1((TemplateCollClippingUIData) uiData);
        cb(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Boolean bool;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 100) {
            if (requestCode == 101 && resultCode == -1) {
                G9().k5(true);
                getHostFragment().requireActivity().getSupportFragmentManager().popBackStack();
                lb(data);
                return;
            }
            return;
        }
        if (data != null) {
            bool = Boolean.valueOf(data.getBooleanExtra("ARG_NEED_REPLACE_MEDIA", false));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            lb(data);
        }
        Ia(data, resultCode);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        super.onDismiss();
        qa();
        dr H9 = H9();
        if (H9 != null) {
            H9.removePlayerListener(this.playerListener);
        }
        dr H92 = H9();
        if (H92 != null) {
            H92.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void pa() {
        dr H9;
        super.pa();
        List<? extends MediaClip> list = this.mediaModelBackup;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if (list.size() > 1 && (H9 = H9()) != null) {
            H9.flush(true);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClippingMenuPart$b", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements IPlayer.PlayerListener {
        b() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            dr H9;
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (WinkEditorTemplateCollClippingMenuPart.this.getHostFragment().isResumed() && !WinkEditorTemplateCollClippingMenuPart.this.needPause && (H9 = WinkEditorTemplateCollClippingMenuPart.this.H9()) != null) {
                H9.play();
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (status == IPlayer.PlayerStatus.PLAYING) {
                WinkEditorTemplateCollClippingMenuPart.this.Ja(true);
            } else if (status == IPlayer.PlayerStatus.PAUSED) {
                WinkEditorTemplateCollClippingMenuPart.this.Ja(false);
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
        }
    }
}
