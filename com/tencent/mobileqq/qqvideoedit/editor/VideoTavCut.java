package com.tencent.mobileqq.qqvideoedit.editor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditContainerView;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.EditUIManager;
import com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.EditUIScene;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditData;
import com.tencent.mobileqq.qqvideoedit.editor.model.PointF;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.editor.transition.TransitionModelExKt;
import com.tencent.mobileqq.qqvideoedit.editor.transition.TransitionResourceManager;
import com.tencent.mobileqq.qqvideoedit.editor.view.BorderView;
import com.tencent.mobileqq.qqvideoedit.event.FilterSelectedEvent;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TransitionModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
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
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001IB\t\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\tH\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0,H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020/H\u0016J\u001c\u00106\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001603H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\u0004H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010<\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0016\u0018\u00010;H\u0016J\u0012\u0010?\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H\u0016J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H\u0016J\u0014\u0010F\u001a\u00020\u00042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0,J\u0006\u0010G\u001a\u00020\u0004J\u0006\u0010H\u001a\u00020\u0004J\b\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u00020\rH\u0016J\b\u0010K\u001a\u00020\rH\u0016J\u000e\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00190,H\u0016J\b\u0010M\u001a\u00020\u001bH\u0016J\b\u0010N\u001a\u00020\u0004H\u0016J\b\u0010O\u001a\u00020\u001bH\u0016J\b\u0010P\u001a\u00020\u001bH\u0016J\u0018\u0010U\u001a\u00020\u00042\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020SH\u0016J\u0006\u0010V\u001a\u00020\u001bJ\u0006\u0010W\u001a\u00020\u001bJ\u000e\u0010Z\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020XJ\b\u0010[\u001a\u00020\u001bH\u0016R\u0018\u0010]\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\\R$\u0010d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010\\\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010\\R\u0018\u0010h\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010\\R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010\\R\u0016\u0010l\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010rR\"\u0010z\u001a\u00020t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bu\u0010w\"\u0004\bx\u0010yR\"\u0010{\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010N\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b%\u0010\u0080\u0001R\u0017\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b<\u0010\u0082\u0001R\u0018\u0010\u0084\u0001\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\bL\u0010\u0083\u0001R\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bC\u0010\u0085\u0001R\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bP\u0010\u0085\u0001R\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001a\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0006\u0010\u0089\u0001R,\u0010\u008e\u0001\u001a\u0004\u0018\u0001042\t\u0010\u008b\u0001\u001a\u0004\u0018\u0001048\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\b\u0005\u0010\u008c\u0001\u001a\u0005\bn\u0010\u008d\u0001R\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0011\u0010\u008f\u0001R\u001b\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001c\u0010\u0092\u0001R(\u0010\u0099\u0001\u001a\u00030\u0094\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bW\u0010\u001d\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R(\u0010\u009c\u0001\u001a\u00030\u0094\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bV\u0010\u001d\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001\"\u0006\b\u009b\u0001\u0010\u0098\u0001R'\u0010\u00a0\u0001\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020@038\u0006\u00a2\u0006\u000f\n\u0005\b\b\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0007\u0010\u00a1\u0001R\u0017\u0010\u00a2\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010GR\u001a\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bx\u0010\u00a3\u0001R\u0017\u0010\u00a5\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010NR\u001b\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b?\u0010\u00a7\u0001\u00a8\u0006\u00ab\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/VideoTavCut;", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw;", "Landroid/widget/FrameLayout;", "playerViewContainer", "", ReportConstant.COSTREPORT_PREFIX, "r", "y", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "mediaModel", "M", "O", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "g", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "hostFragment", "t", "Lorg/libpag/PAGView;", "fakeStickerPagView", "Landroid/view/View;", "playerContainerWrapper", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "stickerModel", "D", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditData;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "I", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw$a;", "params", "g0", "B", "Lcom/tencent/tavcut/render/player/IPlayer;", "getPlayer", "Lcom/tencent/tavcut/session/a;", "l", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", "c0", "hidden", "b", "release", "V", "", "e0", "E", "", "durationUs", "W", "getDurationUs", "", "", "stickerModelMap", "H", "T", "i", "f0", "a0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "audioModel", BdhLogUtil.LogTag.Tag_Conn, "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "Y", "o", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "videos", "G", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "getRenderSize", "k", DomainData.DOMAIN_NAME, "U", "Z", "d0", "p", "Landroid/graphics/Matrix;", "matrix", "Landroid/graphics/RectF;", "rectF", "X", "w", "v", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "size", UserInfo.SEX_FEMALE, "b0", "Landroid/widget/FrameLayout;", "frontPlayerViewContainer", "backPlayerViewContainer", "c", "getCurrentPlayerViewContainer", "()Landroid/widget/FrameLayout;", "setCurrentPlayerViewContainer", "(Landroid/widget/FrameLayout;)V", "currentPlayerViewContainer", "d", "verticalPlayerViewContainer", "e", "horizontalPlayerViewContainer", "f", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView;", "videoEditContainerView", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView;", tl.h.F, "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView;", "stickerBorderView", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "videoEditContext", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIManager;", "j", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIManager;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIManager;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIManager;)V", "uiManager", "isChangedBackground", "()Z", "setChangedBackground", "(Z)V", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "playerListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw$a;", "Lcom/tencent/tavcut/session/a;", "cutSession", "Lcom/tencent/tavcut/render/player/IPlayer;", "verticalPlayer", "horizontalPlayer", "currentPlayer", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", "renderLayerHelper", "<set-?>", "Ljava/lang/String;", "()Ljava/lang/String;", "templatePath", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "oriMediaModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/hdr/a;", "Lcom/tencent/mobileqq/qqvideoedit/editor/hdr/a;", "hdrEffectNode", "", "getRenderWidth", "()I", "setRenderWidth", "(I)V", "renderWidth", "getRenderHeight", "setRenderHeight", "renderHeight", "Ljava/util/Map;", "getStickerScaleMap", "()Ljava/util/Map;", "stickerScaleMap", "Lorg/libpag/PAGView;", "stickerDuration", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "curStickerModel", "isMovingSticker", "Lorg/libpag/PAGFile;", "Lorg/libpag/PAGFile;", "lastStickerPAGFile", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoTavCut implements aw {

    /* renamed from: A, reason: from kotlin metadata */
    @Nullable
    private VideoStickerModel curStickerModel;

    /* renamed from: B, reason: from kotlin metadata */
    private boolean isMovingSticker;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private PAGFile lastStickerPAGFile;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout frontPlayerViewContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout backPlayerViewContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout currentPlayerViewContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout verticalPlayerViewContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout horizontalPlayerViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout playerContainerWrapper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private EditContainerView videoEditContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BorderView stickerBorderView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EditViewContext videoEditContext;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public EditUIManager uiManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isChangedBackground;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPlayer.a playerListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private aw.VideoTavCutParams params;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.session.a cutSession;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPlayer verticalPlayer;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPlayer horizontalPlayer;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPlayer currentPlayer;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ComposeRenderLayer renderLayerHelper;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String templatePath;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MediaModel oriMediaModel;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqvideoedit.editor.hdr.a hdrEffectNode;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGView fakeStickerPagView;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int renderWidth = 720;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int renderHeight = 1280;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Float> stickerScaleMap = new LinkedHashMap();

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private long stickerDuration = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/VideoTavCut$b", "Lcom/tencent/tavcut/operator/b;", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends com.tencent.tavcut.operator.b {
        b() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(PAGView fakeStickerPagView, View playerContainerWrapper, VideoStickerModel stickerModel) {
        PAGFile c16;
        fakeStickerPagView.getLayoutParams().width = (int) stickerModel.getSizeInView().f275793x;
        fakeStickerPagView.getLayoutParams().height = (int) stickerModel.getSizeInView().f275794y;
        fakeStickerPagView.setX(playerContainerWrapper.getX() + stickerModel.getLeftTopInView().f275793x);
        fakeStickerPagView.setY(playerContainerWrapper.getY() + stickerModel.getLeftTopInView().f275794y);
        fakeStickerPagView.setRotation(-stickerModel.rotate);
        String str = stickerModel.filePath;
        PAGFile pAGFile = this.lastStickerPAGFile;
        if (pAGFile != null) {
            Intrinsics.checkNotNull(pAGFile);
            if (TextUtils.equals(str, pAGFile.path())) {
                c16 = this.lastStickerPAGFile;
                this.lastStickerPAGFile = c16;
                if (c16 != null) {
                    QLog.e("VideoTavCut", 1, "updateFakeStickerPagView error, pagFile is null!");
                    return;
                }
                PAGText textData = c16.getTextData(0);
                if (textData == null) {
                    return;
                }
                for (TextItem textItem : stickerModel.textItems) {
                    textData.text = textItem.text;
                    if (Intrinsics.areEqual(str, ak2.o.U)) {
                        if (!TextUtils.isEmpty(textItem.backgroundColor)) {
                            textData.backgroundColor = Color.parseColor(textItem.backgroundColor);
                        }
                        if (!TextUtils.isEmpty(textItem.textColor)) {
                            textData.fillColor = Color.parseColor(textItem.textColor);
                        }
                    } else if (!TextUtils.isEmpty(textItem.textColor)) {
                        textData.fillColor = Color.parseColor(textItem.textColor);
                    }
                    textData.fontStyle = textItem.fontStyle;
                    textData.fontFamily = textItem.fontFamily;
                    c16.replaceText(0, textData);
                }
                fakeStickerPagView.setComposition(c16);
                return;
            }
        }
        c16 = com.tencent.mobileqq.qqvideoedit.utils.k.b().c(str);
        this.lastStickerPAGFile = c16;
        if (c16 != null) {
        }
    }

    private final void I() {
        SizeF sizeF;
        FrameLayout frameLayout;
        boolean z16;
        Map<String, VideoStickerModel> map;
        int mapCapacity;
        BackgroundModel backgroundModel = V().backgroundModel;
        if (backgroundModel != null && (sizeF = backgroundModel.renderSize) != null && (frameLayout = this.playerContainerWrapper) != null) {
            if (sizeF.height == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && frameLayout.getHeight() != 0) {
                Map<String, VideoStickerModel> m3 = m();
                if (m3 != null) {
                    mapCapacity = MapsKt__MapsJVMKt.mapCapacity(m3.size());
                    LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                    Iterator<T> it = m3.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        Object key = entry.getKey();
                        PointF f16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.g.f(getRenderSize(), new Size(Integer.valueOf(frameLayout.getWidth()), Integer.valueOf(frameLayout.getHeight()), null, 4, null));
                        VideoStickerModel a16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.d.INSTANCE.a((VideoStickerModel) entry.getValue(), this);
                        ((VideoStickerModel) entry.getValue()).getOriginPointInView().f275793x = f16.f275793x;
                        ((VideoStickerModel) entry.getValue()).getOriginPointInView().f275794y = f16.f275794y;
                        ((VideoStickerModel) entry.getValue()).updatePositionInView(this.renderWidth, this.renderHeight, a16.scale, a16.centerX, a16.centerY);
                        linkedHashMap.put(key, VideoStickerModel.copyAndUpdate$default((VideoStickerModel) entry.getValue(), null, null, 0L, 0L, 0, a16.scale, 0.0f, a16.centerX, a16.centerY, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -417, 31, null));
                    }
                    map = MapsKt__MapsKt.toMutableMap(linkedHashMap);
                } else {
                    map = null;
                }
                if (map != null) {
                    H(map);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final VideoTavCut this$0, final VideoEditData this_with) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.au
            @Override // java.lang.Runnable
            public final void run() {
                VideoTavCut.L(VideoTavCut.this, this_with);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(VideoTavCut this$0, VideoEditData this_with) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        ComposeRenderLayer composeRenderLayer = this$0.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(this_with.getMediaModel());
    }

    private final void M(MediaModel mediaModel) {
        ComposeRenderLayer composeRenderLayer;
        ms.a.c("VideoTavCut", "updateWithHorizontalPlayer");
        ComposeRenderLayer composeRenderLayer2 = this.renderLayerHelper;
        if (composeRenderLayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer2 = null;
        }
        composeRenderLayer2.c(new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null));
        IPlayer iPlayer = this.currentPlayer;
        long j3 = 0;
        if (iPlayer != null && Intrinsics.areEqual(iPlayer, this.horizontalPlayer)) {
            ComposeRenderLayer composeRenderLayer3 = this.renderLayerHelper;
            if (composeRenderLayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                composeRenderLayer3 = null;
            }
            composeRenderLayer3.d(mediaModel);
            IPlayer iPlayer2 = this.currentPlayer;
            Intrinsics.checkNotNull(iPlayer2);
            iPlayer2.seek(0L);
            y();
        } else if (this.horizontalPlayer == null) {
            FrameLayout frameLayout = this.horizontalPlayerViewContainer;
            if (frameLayout == null) {
                if (this.verticalPlayerViewContainer == null) {
                    FrameLayout frameLayout2 = this.frontPlayerViewContainer;
                    Intrinsics.checkNotNull(frameLayout2);
                    r(frameLayout2);
                } else {
                    FrameLayout frameLayout3 = this.backPlayerViewContainer;
                    Intrinsics.checkNotNull(frameLayout3);
                    r(frameLayout3);
                }
            } else {
                Intrinsics.checkNotNull(frameLayout);
                r(frameLayout);
            }
            com.tencent.tavcut.session.a aVar = this.cutSession;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                aVar = null;
            }
            IPlayer iPlayer3 = this.horizontalPlayer;
            Intrinsics.checkNotNull(iPlayer3);
            aVar.p(iPlayer3);
            this.currentPlayer = this.horizontalPlayer;
            ComposeRenderLayer composeRenderLayer4 = this.renderLayerHelper;
            if (composeRenderLayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                composeRenderLayer4 = null;
            }
            composeRenderLayer4.d(mediaModel);
            if (this.verticalPlayerViewContainer != null) {
                j3 = 1000;
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.at
                @Override // java.lang.Runnable
                public final void run() {
                    VideoTavCut.N(VideoTavCut.this);
                }
            }, j3);
            FrameLayout frameLayout4 = this.horizontalPlayerViewContainer;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(0);
            }
        } else {
            com.tencent.tavcut.session.a aVar2 = this.cutSession;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                aVar2 = null;
            }
            IPlayer iPlayer4 = this.horizontalPlayer;
            Intrinsics.checkNotNull(iPlayer4);
            aVar2.p(iPlayer4);
            this.currentPlayer = this.horizontalPlayer;
            ComposeRenderLayer composeRenderLayer5 = this.renderLayerHelper;
            if (composeRenderLayer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                composeRenderLayer = null;
            } else {
                composeRenderLayer = composeRenderLayer5;
            }
            composeRenderLayer.d(mediaModel);
            FrameLayout frameLayout5 = this.horizontalPlayerViewContainer;
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(0);
            }
            FrameLayout frameLayout6 = this.verticalPlayerViewContainer;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(4);
            }
            y();
        }
        this.currentPlayerViewContainer = this.horizontalPlayerViewContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(VideoTavCut this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(this$0.currentPlayer, this$0.verticalPlayer)) {
            FrameLayout frameLayout = this$0.verticalPlayerViewContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            this$0.y();
            IPlayer iPlayer = this$0.currentPlayer;
            Intrinsics.checkNotNull(iPlayer);
            iPlayer.seek(0L);
            IPlayer iPlayer2 = this$0.currentPlayer;
            Intrinsics.checkNotNull(iPlayer2);
            iPlayer2.play();
        }
    }

    private final void O(MediaModel mediaModel) {
        ComposeRenderLayer composeRenderLayer;
        ms.a.c("VideoTavCut", "updateWithVerticalPlayer");
        ComposeRenderLayer composeRenderLayer2 = this.renderLayerHelper;
        if (composeRenderLayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer2 = null;
        }
        composeRenderLayer2.c(new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null));
        IPlayer iPlayer = this.currentPlayer;
        long j3 = 0;
        if (iPlayer != null && Intrinsics.areEqual(iPlayer, this.verticalPlayer)) {
            ComposeRenderLayer composeRenderLayer3 = this.renderLayerHelper;
            if (composeRenderLayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                composeRenderLayer3 = null;
            }
            composeRenderLayer3.d(mediaModel);
            IPlayer iPlayer2 = this.currentPlayer;
            Intrinsics.checkNotNull(iPlayer2);
            iPlayer2.seek(0L);
            x();
        } else if (this.verticalPlayer == null) {
            FrameLayout frameLayout = this.verticalPlayerViewContainer;
            if (frameLayout == null) {
                if (this.horizontalPlayerViewContainer == null) {
                    FrameLayout frameLayout2 = this.frontPlayerViewContainer;
                    Intrinsics.checkNotNull(frameLayout2);
                    s(frameLayout2);
                } else {
                    FrameLayout frameLayout3 = this.backPlayerViewContainer;
                    Intrinsics.checkNotNull(frameLayout3);
                    s(frameLayout3);
                }
            } else {
                Intrinsics.checkNotNull(frameLayout);
                s(frameLayout);
            }
            com.tencent.tavcut.session.a aVar = this.cutSession;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                aVar = null;
            }
            IPlayer iPlayer3 = this.verticalPlayer;
            Intrinsics.checkNotNull(iPlayer3);
            aVar.p(iPlayer3);
            this.currentPlayer = this.verticalPlayer;
            ComposeRenderLayer composeRenderLayer4 = this.renderLayerHelper;
            if (composeRenderLayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                composeRenderLayer4 = null;
            }
            composeRenderLayer4.d(mediaModel);
            if (this.horizontalPlayerViewContainer != null) {
                j3 = 1000;
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.av
                @Override // java.lang.Runnable
                public final void run() {
                    VideoTavCut.P(VideoTavCut.this);
                }
            }, j3);
            FrameLayout frameLayout4 = this.verticalPlayerViewContainer;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(0);
            }
        } else {
            com.tencent.tavcut.session.a aVar2 = this.cutSession;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                aVar2 = null;
            }
            IPlayer iPlayer4 = this.verticalPlayer;
            Intrinsics.checkNotNull(iPlayer4);
            aVar2.p(iPlayer4);
            this.currentPlayer = this.verticalPlayer;
            ComposeRenderLayer composeRenderLayer5 = this.renderLayerHelper;
            if (composeRenderLayer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                composeRenderLayer = null;
            } else {
                composeRenderLayer = composeRenderLayer5;
            }
            composeRenderLayer.d(mediaModel);
            FrameLayout frameLayout5 = this.verticalPlayerViewContainer;
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(0);
            }
            FrameLayout frameLayout6 = this.horizontalPlayerViewContainer;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(4);
            }
            x();
        }
        this.currentPlayerViewContainer = this.verticalPlayerViewContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(VideoTavCut this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(this$0.currentPlayer, this$0.horizontalPlayer)) {
            FrameLayout frameLayout = this$0.horizontalPlayerViewContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            this$0.x();
            IPlayer iPlayer = this$0.currentPlayer;
            Intrinsics.checkNotNull(iPlayer);
            iPlayer.seek(0L);
            IPlayer iPlayer2 = this$0.currentPlayer;
            Intrinsics.checkNotNull(iPlayer2);
            iPlayer2.play();
        }
    }

    private final Size g(MediaModel mediaModel) {
        boolean z16;
        try {
            float f16 = gk2.d.b(mediaModel.videos.get(0)).width;
            float f17 = gk2.d.b(mediaModel.videos.get(0)).height;
            for (MediaClip mediaClip : mediaModel.videos) {
                boolean z17 = true;
                if (gk2.d.b(mediaClip).width == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (gk2.d.b(mediaClip).height != 0.0f) {
                        z17 = false;
                    }
                    if (!z17 && (gk2.d.b(mediaClip).width * 1.0f) / gk2.d.b(mediaClip).height < (1.0f * f16) / f17) {
                        f16 = gk2.d.b(mediaClip).width;
                        f17 = gk2.d.b(mediaClip).height;
                    }
                }
            }
            aw.VideoTavCutParams videoTavCutParams = null;
            if (3 * f16 <= 2 * f17) {
                aw.VideoTavCutParams videoTavCutParams2 = this.params;
                if (videoTavCutParams2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    videoTavCutParams2 = null;
                }
                int width = videoTavCutParams2.getWidth();
                this.renderWidth = width;
                int i3 = (int) ((width * f17) / f16);
                this.renderHeight = i3;
                aw.VideoTavCutParams videoTavCutParams3 = this.params;
                if (videoTavCutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    videoTavCutParams3 = null;
                }
                if (i3 < videoTavCutParams3.getHeight()) {
                    aw.VideoTavCutParams videoTavCutParams4 = this.params;
                    if (videoTavCutParams4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("params");
                    } else {
                        videoTavCutParams = videoTavCutParams4;
                    }
                    int height = videoTavCutParams.getHeight();
                    this.renderHeight = height;
                    this.renderWidth = (int) ((f16 * height) / f17);
                }
            } else {
                aw.VideoTavCutParams videoTavCutParams5 = this.params;
                if (videoTavCutParams5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    videoTavCutParams5 = null;
                }
                this.renderWidth = videoTavCutParams5.getWidth();
                aw.VideoTavCutParams videoTavCutParams6 = this.params;
                if (videoTavCutParams6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                } else {
                    videoTavCutParams = videoTavCutParams6;
                }
                this.renderHeight = (int) ((videoTavCutParams.getWidth() * f17) / f16);
            }
            ms.a.c("VideoTavCut", "computerRenderSize, result width:" + this.renderWidth + " renderHeight:" + this.renderHeight);
            return new Size(Integer.valueOf(this.renderWidth), Integer.valueOf(this.renderHeight), null, 4, null);
        } catch (Exception e16) {
            ms.a.e("VideoTavCut", e16);
            return new Size(720, 1280, null, 4, null);
        }
    }

    private final VideoEditData q() {
        aw.VideoTavCutParams videoTavCutParams = this.params;
        if (videoTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            videoTavCutParams = null;
        }
        return videoTavCutParams.d().get(0);
    }

    private final void r(FrameLayout playerViewContainer) {
        ms.a.c("VideoTavCut", "initHorizontalPlayer");
        if (this.horizontalPlayer == null) {
            ViewGroup.LayoutParams layoutParams = playerViewContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).setMargins(ViewUtils.dpToPx(-300.0f), 0, ViewUtils.dpToPx(-300.0f), 0);
            IPlayer g16 = od4.b.f422509e.g(playerViewContainer);
            this.horizontalPlayer = g16;
            Intrinsics.checkNotNull(g16);
            g16.setLoopPlay(true);
            this.horizontalPlayerViewContainer = playerViewContainer;
            this.currentPlayer = this.horizontalPlayer;
        }
    }

    private final void s(FrameLayout playerViewContainer) {
        ms.a.c("VideoTavCut", "initVerticalPlayer");
        if (this.verticalPlayer == null) {
            IPlayer g16 = od4.b.f422509e.g(playerViewContainer);
            this.verticalPlayer = g16;
            Intrinsics.checkNotNull(g16);
            g16.setLoopPlay(true);
            this.verticalPlayerViewContainer = playerViewContainer;
            this.currentPlayer = this.verticalPlayer;
        }
    }

    private final void t(BasePartFragment hostFragment) {
        View findViewById = hostFragment.requireView().findViewById(R.id.f1170370c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "hostFragment.requireView\u2026Id(R.id.videoControlView)");
        this.videoEditContainerView = (EditContainerView) findViewById;
        View findViewById2 = hostFragment.requireView().findViewById(R.id.f88404wz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "hostFragment.requireView\u2026(R.id.stickerControlView)");
        this.stickerBorderView = (BorderView) findViewById2;
        Context requireContext = hostFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "hostFragment.requireContext()");
        this.videoEditContext = new EditViewContext(requireContext);
        EditViewContext editViewContext = this.videoEditContext;
        EditContainerView editContainerView = null;
        if (editViewContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditContext");
            editViewContext = null;
        }
        A(new EditUIManager(editViewContext));
        EditUIManager j3 = j();
        EditContainerView editContainerView2 = this.videoEditContainerView;
        if (editContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditContainerView");
        } else {
            editContainerView = editContainerView2;
        }
        j3.f(editContainerView);
        j().d(new Function2<Float, Float, List<? extends Object>>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut$initVideoEditContainerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ List<? extends Object> invoke(Float f16, Float f17) {
                return invoke(f16.floatValue(), f17.floatValue());
            }

            @NotNull
            public final List<Object> invoke(float f16, float f17) {
                return VideoTavCut.this.c0().b(f16, f17);
            }
        });
        j().j(EditUIScene.MULTIMEDIA);
    }

    private final boolean u() {
        if (q().getMediaModel().videos.size() > 1) {
            return true;
        }
        return false;
    }

    private final void x() {
        IPlayer iPlayer = this.horizontalPlayer;
        if (iPlayer != null) {
            iPlayer.release();
        }
        this.horizontalPlayer = null;
    }

    private final void y() {
        IPlayer iPlayer = this.verticalPlayer;
        if (iPlayer != null) {
            iPlayer.release();
        }
        this.verticalPlayer = null;
    }

    public final void A(@NotNull EditUIManager editUIManager) {
        Intrinsics.checkNotNullParameter(editUIManager, "<set-?>");
        this.uiManager = editUIManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0176 A[Catch: Exception -> 0x018c, TryCatch #1 {Exception -> 0x018c, blocks: (B:31:0x0154, B:33:0x0158, B:34:0x015e, B:37:0x016f, B:38:0x0172, B:40:0x0176, B:42:0x017a, B:43:0x017d, B:45:0x0181, B:46:0x0184, B:50:0x0165, B:52:0x016b), top: B:30:0x0154 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(@NotNull MediaModel mediaModel) {
        String str;
        Size g16;
        float f16;
        SizeF sizeF;
        BackgroundModel backgroundModel;
        IPlayer.a aVar;
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        try {
            aw.VideoTavCutParams videoTavCutParams = null;
            if (!TextUtils.isEmpty(this.templatePath)) {
                aw.VideoTavCutParams videoTavCutParams2 = this.params;
                if (videoTavCutParams2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    videoTavCutParams2 = null;
                }
                this.renderWidth = (videoTavCutParams2.getHeight() * 720) / 1280;
                aw.VideoTavCutParams videoTavCutParams3 = this.params;
                if (videoTavCutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    videoTavCutParams3 = null;
                }
                this.renderHeight = videoTavCutParams3.getHeight();
                aw.VideoTavCutParams videoTavCutParams4 = this.params;
                if (videoTavCutParams4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    videoTavCutParams4 = null;
                }
                Integer valueOf = Integer.valueOf((videoTavCutParams4.getHeight() * 720) / 1280);
                aw.VideoTavCutParams videoTavCutParams5 = this.params;
                if (videoTavCutParams5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("params");
                    videoTavCutParams5 = null;
                }
                g16 = new Size(valueOf, Integer.valueOf(videoTavCutParams5.getHeight()), null, 4, null);
                f16 = 1.0f;
            } else {
                g16 = g(mediaModel);
                Integer num = g16.width;
                Intrinsics.checkNotNull(num);
                int intValue = num.intValue();
                Integer num2 = g16.height;
                Intrinsics.checkNotNull(num2);
                if (intValue > num2.intValue()) {
                    f16 = 99999.0f;
                } else {
                    f16 = 0.0f;
                }
            }
            float f17 = f16;
            Intrinsics.checkNotNull(g16);
            Integer num3 = g16.width;
            Intrinsics.checkNotNull(num3);
            int intValue2 = num3.intValue();
            Integer num4 = g16.height;
            Intrinsics.checkNotNull(num4);
            if (intValue2 > num4.intValue()) {
                Intrinsics.checkNotNull(g16.width);
                sizeF = new SizeF(1280.0f, (g16.height.intValue() * 1280.0f) / r6.intValue(), ByteString.EMPTY);
            } else {
                Intrinsics.checkNotNull(g16.width);
                Intrinsics.checkNotNull(g16.height);
                sizeF = new SizeF((r4.intValue() * 1280.0f) / r6.intValue(), 1280.0f, ByteString.EMPTY);
            }
            SizeF sizeF2 = sizeF;
            BackgroundModel backgroundModel2 = mediaModel.backgroundModel;
            if (backgroundModel2 != null) {
                backgroundModel = BackgroundModel.copy$default(backgroundModel2, null, sizeF2, null, null, null, null, null, null, f17, null, 765, null);
            } else {
                backgroundModel = null;
            }
            Size size = g16;
            try {
                MediaModel copy$default = MediaModel.copy$default(mediaModel, null, null, null, null, null, null, null, null, null, backgroundModel, null, null, null, null, null, null, null, null, null, 523775, null);
                ms.a.c("VideoTavCut", "renderSize: width = " + size.width + "height = " + size.height);
                Integer num5 = size.width;
                str = "VideoTavCut";
                try {
                    aw.VideoTavCutParams videoTavCutParams6 = this.params;
                    if (videoTavCutParams6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("params");
                    } else {
                        videoTavCutParams = videoTavCutParams6;
                    }
                    int width = videoTavCutParams.getWidth();
                    if (num5 != null && num5.intValue() == width) {
                        O(copy$default);
                        aVar = this.playerListener;
                        if (aVar != null) {
                            IPlayer iPlayer = this.currentPlayer;
                            if (iPlayer != null) {
                                iPlayer.c(aVar);
                            }
                            IPlayer iPlayer2 = this.currentPlayer;
                            if (iPlayer2 != null) {
                                iPlayer2.a(aVar);
                            }
                        }
                        q().setMediaModel(copy$default);
                    }
                    M(copy$default);
                    aVar = this.playerListener;
                    if (aVar != null) {
                    }
                    q().setMediaModel(copy$default);
                } catch (Exception e16) {
                    e = e16;
                    ms.a.e(str, e);
                }
            } catch (Exception e17) {
                e = e17;
                str = "VideoTavCut";
            }
        } catch (Exception e18) {
            e = e18;
            str = "VideoTavCut";
        }
    }

    public void C(@Nullable AudioModel audioModel) {
        VideoEditData q16 = q();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (audioModel != null) {
            linkedHashMap.put(audioModel.id, audioModel);
        }
        q16.setMediaModel(MediaModel.copy$default(q16.getMediaModel(), null, null, null, null, null, null, null, linkedHashMap, null, null, null, null, null, null, null, null, null, null, null, 524159, null));
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
    }

    public void E(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        q().setMediaModel(mediaModel);
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(mediaModel);
    }

    public final void F(@NotNull SizeF size) {
        Intrinsics.checkNotNullParameter(size, "size");
        FrameLayout frameLayout = this.playerContainerWrapper;
        if (frameLayout == null) {
            return;
        }
        j().g(size, frameLayout);
        ms.a.f("VideoTavCut", "updateRenderSize: [" + ((int) size.width) + ", " + ((int) size.height) + "]");
        com.tencent.tavcut.session.a aVar = this.cutSession;
        com.tencent.tavcut.session.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
            aVar = null;
        }
        aVar.q(new com.tencent.tavcut.composition.model.component.Size(Integer.valueOf((int) size.width), Integer.valueOf((int) size.height), null, 4, null));
        com.tencent.tavcut.session.a aVar3 = this.cutSession;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
        } else {
            aVar2 = aVar3;
        }
        aVar2.flushWithoutDelay();
    }

    public final void G(@NotNull List<MediaClip> videos) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        VideoEditData q16 = q();
        q16.setMediaModel(MediaModel.copy$default(q16.getMediaModel(), null, null, null, null, null, null, videos, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null));
        B(q16.getMediaModel());
        I();
    }

    public void H(@NotNull Map<String, VideoStickerModel> stickerModelMap) {
        Intrinsics.checkNotNullParameter(stickerModelMap, "stickerModelMap");
        VideoEditData q16 = q();
        q16.setStickerModelMap(stickerModelMap);
        MediaModel mediaModel = q16.getMediaModel();
        Map<String, VideoStickerModel> stickerModelMap2 = q16.getStickerModelMap();
        Intrinsics.checkNotNull(stickerModelMap2);
        q16.setMediaModel(MediaModel.copy$default(mediaModel, null, null, null, null, null, null, null, null, stickerModelMap2, null, null, null, null, null, null, null, null, null, null, 524031, null));
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        com.tencent.tavcut.session.a aVar = null;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
        com.tencent.tavcut.session.a aVar2 = this.cutSession;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
        } else {
            aVar = aVar2;
        }
        aVar.flush();
    }

    public final void J() {
        Context context;
        ComposeRenderLayer composeRenderLayer = null;
        if (RFWApplication.getApplication() != null) {
            context = RFWApplication.getApplication().getApplicationContext();
        } else {
            context = null;
        }
        if (context != null && v() && u() && QzoneConfig.getWinkTransitionSwitch()) {
            TransitionModel d16 = TransitionModelExKt.d(context);
            final VideoEditData q16 = q();
            Map<String, TransitionModel> a16 = TransitionModelExKt.a(q16.getMediaModel().videos, true, d16);
            TransitionResourceManager.c().h(context, a16.values(), new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.as
                @Override // java.lang.Runnable
                public final void run() {
                    VideoTavCut.K(VideoTavCut.this, q16);
                }
            });
            q16.setMediaModel(MediaModel.copy$default(q16.getMediaModel(), null, null, null, null, null, null, null, null, null, null, null, null, a16, null, null, null, null, null, null, 520191, null));
            ComposeRenderLayer composeRenderLayer2 = this.renderLayerHelper;
            if (composeRenderLayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            } else {
                composeRenderLayer = composeRenderLayer2;
            }
            composeRenderLayer.d(q16.getMediaModel());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void T() {
        this.isMovingSticker = true;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public boolean U() {
        boolean z16;
        List<MediaClip> list;
        Object first;
        ResourceModel resourceModel;
        List<MediaClip> list2;
        if (!Intrinsics.areEqual(this.oriMediaModel, V())) {
            return true;
        }
        MediaModel mediaModel = this.oriMediaModel;
        boolean z17 = false;
        if (mediaModel != null && (list2 = mediaModel.videos) != null && (!list2.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        MediaModel mediaModel2 = this.oriMediaModel;
        if (mediaModel2 != null && (list = mediaModel2.videos) != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            MediaClip mediaClip = (MediaClip) first;
            if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
                long j3 = resourceModel.sourceDuration;
                com.tencent.tavcut.session.a aVar = this.cutSession;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                    aVar = null;
                }
                if (j3 == aVar.getTotalDurationUs()) {
                    z17 = true;
                }
            }
        }
        return !z17;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public MediaModel V() {
        return q().getMediaModel();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void W(long durationUs) {
        Map<String, VideoStickerModel> linkedHashMap;
        Map<String, FilterModel> linkedHashMap2;
        int mapCapacity;
        int mapCapacity2;
        VideoStickerModel videoStickerModel;
        boolean z16;
        q().setDurationUs(durationUs);
        VideoEditData q16 = q();
        if (q16.getStickerModelMap() != null) {
            Map<String, VideoStickerModel> stickerModelMap = q16.getStickerModelMap();
            Intrinsics.checkNotNull(stickerModelMap);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<String, VideoStickerModel> entry : stickerModelMap.entrySet()) {
                if (entry.getValue().startTime < durationUs) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap3.size());
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(mapCapacity2);
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                Object key = entry2.getKey();
                if (((VideoStickerModel) entry2.getValue()).startTime + ((VideoStickerModel) entry2.getValue()).duration >= durationUs) {
                    videoStickerModel = VideoStickerModel.copyAndUpdate$default((VideoStickerModel) entry2.getValue(), null, null, 0L, durationUs - ((VideoStickerModel) entry2.getValue()).startTime, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -9, 31, null);
                } else {
                    videoStickerModel = (VideoStickerModel) entry2.getValue();
                }
                linkedHashMap4.put(key, videoStickerModel);
            }
            linkedHashMap = MapsKt__MapsKt.toMutableMap(linkedHashMap4);
        } else {
            linkedHashMap = new LinkedHashMap<>();
        }
        q16.setStickerModelMap(linkedHashMap);
        if (q16.getFilterModelMap() != null) {
            Map<String, FilterModel> filterModelMap = q16.getFilterModelMap();
            Intrinsics.checkNotNull(filterModelMap);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(filterModelMap.size());
            LinkedHashMap linkedHashMap5 = new LinkedHashMap(mapCapacity);
            Iterator<T> it = filterModelMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry3 = (Map.Entry) it.next();
                linkedHashMap5.put(entry3.getKey(), FilterModel.copy$default((FilterModel) entry3.getValue(), null, null, null, null, Long.valueOf(durationUs), null, null, 111, null));
            }
            linkedHashMap2 = MapsKt__MapsKt.toMutableMap(linkedHashMap5);
        } else {
            linkedHashMap2 = new LinkedHashMap<>();
        }
        q16.setFilterModelMap(linkedHashMap2);
        MediaModel mediaModel = q16.getMediaModel();
        Map<String, VideoStickerModel> stickerModelMap2 = q16.getStickerModelMap();
        Intrinsics.checkNotNull(stickerModelMap2);
        Map<String, FilterModel> filterModelMap2 = q16.getFilterModelMap();
        Intrinsics.checkNotNull(filterModelMap2);
        q16.setMediaModel(MediaModel.copy$default(mediaModel, null, null, null, null, null, null, null, null, stickerModelMap2, null, filterModelMap2, null, null, null, null, null, null, null, null, 523007, null));
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void X(@NotNull Matrix matrix, @NotNull RectF rectF) {
        int collectionSizeOrDefault;
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        MediaModel V = V();
        List<MediaClip> list = V.videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            List<Float> a16 = com.tencent.mobileqq.qqvideoedit.editor.crop.a.a(matrix);
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = ResourceModel.copy$default(resourceModel2, null, null, null, null, null, null, null, null, null, null, null, new com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RectF(rectF.left, rectF.top, rectF.right, rectF.bottom, null, 16, null), null, null, null, null, 63487, null);
            } else {
                resourceModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, a16, null, 94, null));
        }
        E(MediaModel.copy$default(V, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void Y(float volume) {
        VideoEditData q16 = q();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, AudioModel> entry : q16.getMediaModel().audios.entrySet()) {
            hashMap.put(entry.getKey(), AudioModel.copy$default(entry.getValue(), null, null, null, null, null, Float.valueOf(volume), null, null, null, null, null, null, null, null, null, null, null, null, 262111, null));
        }
        C(null);
        q16.setMediaModel(MediaModel.copy$default(q16.getMediaModel(), null, null, null, null, null, null, null, hashMap, null, null, null, null, null, null, null, null, null, null, null, 524159, null));
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void Z() {
        this.oriMediaModel = V();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public Size a() {
        aw.VideoTavCutParams videoTavCutParams = this.params;
        aw.VideoTavCutParams videoTavCutParams2 = null;
        if (videoTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            videoTavCutParams = null;
        }
        Integer valueOf = Integer.valueOf(videoTavCutParams.getWidth());
        aw.VideoTavCutParams videoTavCutParams3 = this.params;
        if (videoTavCutParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            videoTavCutParams2 = videoTavCutParams3;
        }
        return new Size(valueOf, Integer.valueOf(videoTavCutParams2.getHeight()), null, 4, null);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void a0(@NotNull VideoStickerModel stickerModel) {
        boolean z16;
        Object obj;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        VideoEditData q16 = q();
        Map<String, VideoStickerModel> stickerModelMap = q16.getStickerModelMap();
        boolean z17 = false;
        if (stickerModelMap != null && !stickerModelMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Map<String, VideoStickerModel> stickerModelMap2 = q16.getStickerModelMap();
        Intrinsics.checkNotNull(stickerModelMap2);
        stickerModelMap2.remove(stickerModel.id);
        MediaModel mediaModel = q16.getMediaModel();
        Map<String, VideoStickerModel> stickerModelMap3 = q16.getStickerModelMap();
        Intrinsics.checkNotNull(stickerModelMap3);
        q16.setMediaModel(MediaModel.copy$default(mediaModel, null, null, null, null, null, null, null, null, stickerModelMap3, null, null, null, null, null, null, null, null, null, null, 524031, null));
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        ComposeRenderLayer composeRenderLayer2 = null;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
        MetaMaterial material = stickerModel.getMaterial();
        Intrinsics.checkNotNull(material);
        if (com.tencent.mobileqq.qqvideoedit.editor.sticker.h.D(material)) {
            VideoEditData q17 = q();
            Map<String, VideoStickerModel> stickerModelMap4 = q17.getStickerModelMap();
            if (stickerModelMap4 == null || stickerModelMap4.isEmpty()) {
                z17 = true;
            }
            if (z17) {
                return;
            }
            Map<String, VideoStickerModel> stickerModelMap5 = q17.getStickerModelMap();
            Intrinsics.checkNotNull(stickerModelMap5);
            Iterator<T> it = stickerModelMap5.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    MetaMaterial material2 = ((VideoStickerModel) obj).getMaterial();
                    Intrinsics.checkNotNull(material2);
                    if (Intrinsics.areEqual(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.o(material2), com.tencent.mobileqq.qqvideoedit.editor.sticker.h.o(stickerModel.getMaterial()))) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            VideoStickerModel videoStickerModel = (VideoStickerModel) obj;
            if (videoStickerModel != null) {
                Map<String, VideoStickerModel> stickerModelMap6 = q17.getStickerModelMap();
                Intrinsics.checkNotNull(stickerModelMap6);
                stickerModelMap6.remove(videoStickerModel.id);
                MediaModel mediaModel2 = q17.getMediaModel();
                Map<String, VideoStickerModel> stickerModelMap7 = q17.getStickerModelMap();
                Intrinsics.checkNotNull(stickerModelMap7);
                q17.setMediaModel(MediaModel.copy$default(mediaModel2, null, null, null, null, null, null, null, null, stickerModelMap7, null, null, null, null, null, null, null, null, null, null, 524031, null));
                ComposeRenderLayer composeRenderLayer3 = this.renderLayerHelper;
                if (composeRenderLayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                } else {
                    composeRenderLayer2 = composeRenderLayer3;
                }
                composeRenderLayer2.d(q17.getMediaModel());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r4 != null) goto L25;
     */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean hidden) {
        MetaMaterial metaMaterial;
        Collection<MetaMaterial> values;
        Object elementAtOrNull;
        if (hidden) {
            FrameLayout frameLayout = this.currentPlayerViewContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            IPlayer iPlayer = this.currentPlayer;
            if (iPlayer != null) {
                iPlayer.pause();
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.currentPlayerViewContainer;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        IPlayer iPlayer2 = this.currentPlayer;
        if (iPlayer2 != null) {
            iPlayer2.seek(0L);
        }
        Map<String, MetaMaterial> filterMaterialMap = q().getFilterMaterialMap();
        if (filterMaterialMap != null && (values = filterMaterialMap.values()) != null) {
            elementAtOrNull = CollectionsKt___CollectionsKt.elementAtOrNull(values, 0);
            metaMaterial = (MetaMaterial) elementAtOrNull;
        }
        metaMaterial = null;
        SimpleEventBus.getInstance().dispatchEvent(new FilterSelectedEvent(metaMaterial));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    /* renamed from: b0, reason: from getter */
    public boolean getIsChangedBackground() {
        return this.isChangedBackground;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public ComposeRenderLayer c0() {
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            return null;
        }
        return composeRenderLayer;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public boolean d0() {
        VideoEditData q16 = q();
        q16.setOpenHDR(!q16.getOpenHDR());
        com.tencent.mobileqq.qqvideoedit.editor.hdr.a aVar = this.hdrEffectNode;
        if (aVar != null) {
            aVar.m(q16.getOpenHDR());
        }
        q16.setMediaModel(MediaModel.copy$default(q16.getMediaModel(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null));
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
        return q().getOpenHDR();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public List<MediaModel> e0() {
        List<MediaModel> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(q().getMediaModel());
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void f0(@NotNull VideoStickerModel stickerModel) {
        boolean z16;
        VideoEditData videoEditData;
        PAGView pAGView;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        this.curStickerModel = stickerModel;
        VideoEditData q16 = q();
        if (q16.getStickerModelMap() == null) {
            q16.setStickerModelMap(new LinkedHashMap());
        }
        boolean z17 = true;
        if (this.isMovingSticker) {
            PAGView pAGView2 = this.fakeStickerPagView;
            if (pAGView2 != null && this.playerContainerWrapper != null) {
                Intrinsics.checkNotNull(pAGView2);
                FrameLayout frameLayout = this.playerContainerWrapper;
                Intrinsics.checkNotNull(frameLayout);
                D(pAGView2, frameLayout, stickerModel);
            }
            PAGView pAGView3 = this.fakeStickerPagView;
            if (pAGView3 == null || pAGView3.getVisibility() != 0) {
                z17 = false;
            }
            if (!z17) {
                this.stickerDuration = stickerModel.duration;
                Map<String, VideoStickerModel> stickerModelMap = q16.getStickerModelMap();
                Intrinsics.checkNotNull(stickerModelMap);
                stickerModelMap.put(stickerModel.id, VideoStickerModel.copyAndUpdate$default(stickerModel, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -9, 31, null));
                MediaModel mediaModel = q16.getMediaModel();
                Map<String, VideoStickerModel> stickerModelMap2 = q16.getStickerModelMap();
                Intrinsics.checkNotNull(stickerModelMap2);
                q16.setMediaModel(MediaModel.copy$default(mediaModel, null, null, null, null, null, null, null, null, stickerModelMap2, null, null, null, null, null, null, null, null, null, null, 524031, null));
                ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
                if (composeRenderLayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
                    composeRenderLayer = null;
                }
                composeRenderLayer.e(q16.getMediaModel());
                PAGView pAGView4 = this.fakeStickerPagView;
                if (pAGView4 != null) {
                    pAGView4.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (this.stickerDuration >= 0) {
            Map<String, VideoStickerModel> stickerModelMap3 = q16.getStickerModelMap();
            Intrinsics.checkNotNull(stickerModelMap3);
            z16 = false;
            videoEditData = q16;
            stickerModelMap3.put(stickerModel.id, VideoStickerModel.copyAndUpdate$default(stickerModel, null, null, 0L, this.stickerDuration, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -9, 31, null));
            this.stickerDuration = -1L;
        } else {
            z16 = false;
            videoEditData = q16;
            Map<String, VideoStickerModel> stickerModelMap4 = videoEditData.getStickerModelMap();
            Intrinsics.checkNotNull(stickerModelMap4);
            stickerModelMap4.put(stickerModel.id, stickerModel);
        }
        MediaModel mediaModel2 = videoEditData.getMediaModel();
        Map<String, VideoStickerModel> stickerModelMap5 = videoEditData.getStickerModelMap();
        Intrinsics.checkNotNull(stickerModelMap5);
        VideoEditData videoEditData2 = videoEditData;
        videoEditData2.setMediaModel(MediaModel.copy$default(mediaModel2, null, null, null, null, null, null, null, null, stickerModelMap5, null, null, null, null, null, null, null, null, null, null, 524031, null));
        ComposeRenderLayer composeRenderLayer2 = this.renderLayerHelper;
        if (composeRenderLayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer2 = null;
        }
        composeRenderLayer2.e(videoEditData2.getMediaModel());
        PAGView pAGView5 = this.fakeStickerPagView;
        if (pAGView5 == null || pAGView5.getVisibility() != 0) {
            z17 = z16;
        }
        if (z17 && (pAGView = this.fakeStickerPagView) != null) {
            pAGView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void g0(@NotNull BasePartFragment hostFragment, @NotNull aw.VideoTavCutParams params) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        VideoEditorFragment videoEditorFragment;
        IPlayer.a aVar;
        PAGView pAGView;
        com.tencent.tavcut.session.a aVar2;
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        od4.b bVar = od4.b.f422509e;
        this.cutSession = bVar.h();
        String templatePath = params.getTemplatePath();
        this.templatePath = templatePath;
        RenderModel x16 = bVar.x(templatePath);
        if (x16 != null) {
            com.tencent.tavcut.session.a aVar3 = this.cutSession;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                aVar3 = null;
            }
            aVar3.g(x16);
        }
        com.tencent.mobileqq.qqvideoedit.editor.hdr.a aVar4 = new com.tencent.mobileqq.qqvideoedit.editor.hdr.a();
        this.hdrEffectNode = aVar4;
        aVar4.n(false);
        aVar4.m(p());
        com.tencent.tavcut.session.a aVar5 = this.cutSession;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
            aVar5 = null;
        }
        aVar5.d(aVar4);
        View view = hostFragment.getView();
        if (view != null) {
            frameLayout = (FrameLayout) view.findViewById(R.id.f1171070j);
        } else {
            frameLayout = null;
        }
        this.frontPlayerViewContainer = frameLayout;
        View view2 = hostFragment.getView();
        if (view2 != null) {
            frameLayout2 = (FrameLayout) view2.findViewById(R.id.f1170970i);
        } else {
            frameLayout2 = null;
        }
        this.backPlayerViewContainer = frameLayout2;
        FrameLayout frameLayout4 = this.frontPlayerViewContainer;
        this.currentPlayerViewContainer = frameLayout4;
        if (frameLayout4 != null) {
            frameLayout4.setVisibility(0);
        }
        View view3 = hostFragment.getView();
        if (view3 != null) {
            frameLayout3 = (FrameLayout) view3.findViewById(R.id.f25780br);
        } else {
            frameLayout3 = null;
        }
        this.playerContainerWrapper = frameLayout3;
        if (hostFragment instanceof VideoEditorFragment) {
            videoEditorFragment = (VideoEditorFragment) hostFragment;
        } else {
            videoEditorFragment = null;
        }
        if (videoEditorFragment != null) {
            aVar = videoEditorFragment.getPlayerListener();
        } else {
            aVar = null;
        }
        this.playerListener = aVar;
        View view4 = hostFragment.getView();
        if (view4 != null) {
            pAGView = (PAGView) view4.findViewById(R.id.uze);
        } else {
            pAGView = null;
        }
        this.fakeStickerPagView = pAGView;
        Intrinsics.checkNotNull(pAGView);
        pAGView.play();
        PAGView pAGView2 = this.fakeStickerPagView;
        Intrinsics.checkNotNull(pAGView2);
        pAGView2.setRepeatCount(0);
        if (w()) {
            com.tencent.tavcut.session.a aVar6 = this.cutSession;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                aVar6 = null;
            }
            aVar6.getIClipSourceOperator().h(new b());
        }
        com.tencent.tavcut.session.a aVar7 = this.cutSession;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
            aVar2 = null;
        } else {
            aVar2 = aVar7;
        }
        this.renderLayerHelper = new ComposeRenderLayer(aVar2, null, null, 6, null);
        B(V());
        this.oriMediaModel = V();
        t(hostFragment);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getDurationUs() {
        boolean z16;
        boolean isBlank;
        String str = this.templatePath;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return q().getDurationUs();
                }
                IPlayer currentPlayer = getCurrentPlayer();
                if (currentPlayer != null) {
                    return currentPlayer.getDurationUs();
                }
                return 0L;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @Nullable
    /* renamed from: getPlayer, reason: from getter */
    public IPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public Size getRenderSize() {
        return new Size(Integer.valueOf(this.renderWidth), Integer.valueOf(this.renderHeight), null, 4, null);
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getTemplatePath() {
        return this.templatePath;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void i() {
        if (this.isMovingSticker) {
            this.isMovingSticker = false;
            VideoStickerModel videoStickerModel = this.curStickerModel;
            if (videoStickerModel != null) {
                f0(videoStickerModel);
            }
        }
    }

    @NotNull
    public final EditUIManager j() {
        EditUIManager editUIManager = this.uiManager;
        if (editUIManager != null) {
            return editUIManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiManager");
        return null;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public Size k() {
        PAGFile pAGFile = this.lastStickerPAGFile;
        if (pAGFile != null) {
            try {
                PAGLayer[] layersByEditableIndex = pAGFile.getLayersByEditableIndex(0, 3);
                Object b16 = com.tencent.robolectric.a.b(this.fakeStickerPagView, "pagPlayer");
                Intrinsics.checkNotNullExpressionValue(b16, "getField(fakeStickerPagView, \"pagPlayer\")");
                RectF bounds = ((PAGPlayer) b16).getBounds(layersByEditableIndex[0]);
                return new Size(Integer.valueOf((int) bounds.width()), Integer.valueOf((int) bounds.height()), null, 4, null);
            } catch (Throwable th5) {
                QLog.e("VideoTavCut", 2, "getTopLevelStickerSize failed! " + th5);
            }
        }
        return new Size(0, 0, null, 4, null);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public com.tencent.tavcut.session.a l() {
        com.tencent.tavcut.session.a aVar = this.cutSession;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
            return null;
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @Nullable
    public Map<String, VideoStickerModel> m() {
        return q().getStickerModelMap();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    @NotNull
    public List<VideoEditData> n() {
        aw.VideoTavCutParams videoTavCutParams = this.params;
        if (videoTavCutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            videoTavCutParams = null;
        }
        return videoTavCutParams.d();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void o(float volume) {
        int collectionSizeOrDefault;
        VideoEditData q16 = q();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = q16.getMediaModel().videos.iterator();
        while (true) {
            ResourceModel resourceModel = null;
            if (!it.hasNext()) {
                break;
            }
            MediaClip mediaClip = (MediaClip) it.next();
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = ResourceModel.copy$default(resourceModel2, null, null, null, null, null, null, null, null, null, Float.valueOf(volume), null, null, null, null, null, null, 65023, null);
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
        }
        q16.setMediaModel(MediaModel.copy$default(q16.getMediaModel(), null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null));
        if (this.templatePath != null) {
            com.tencent.tavcut.session.a aVar = this.cutSession;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                aVar = null;
            }
            RenderModel renderModel = aVar.getRenderModel();
            if (renderModel != null) {
                List<ClipSource> clipsAssets = renderModel.getClipsAssets();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(clipsAssets, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = clipsAssets.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(ClipSource.copy$default((ClipSource) it5.next(), null, null, null, 0L, null, Float.valueOf(volume), null, null, null, null, null, null, 4063, null));
                }
                com.tencent.tavcut.session.a aVar2 = this.cutSession;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cutSession");
                    aVar2 = null;
                }
                aVar2.getIClipSourceOperator().e(0, arrayList2);
            }
        }
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public boolean p() {
        return q().getOpenHDR();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.aw
    public void release() {
        com.tencent.tavcut.session.a aVar = this.cutSession;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
            aVar = null;
        }
        aVar.release();
    }

    public final boolean v() {
        Iterator<MediaClip> it = q().getMediaModel().videos.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = it.next().resource;
            if (resourceModel != null && resourceModel.type != MediaType.IMAGE) {
                return false;
            }
        }
        return true;
    }

    public final boolean w() {
        MediaClip mediaClip;
        if (V().videos.size() == 1 && (mediaClip = V().videos.get(0)) != null) {
            ResourceModel resourceModel = mediaClip.resource;
            Intrinsics.checkNotNull(resourceModel);
            if (resourceModel.type == MediaType.IMAGE) {
                return true;
            }
        }
        return false;
    }

    public final void z() {
        Map emptyMap;
        VideoEditData q16 = q();
        MediaModel mediaModel = q16.getMediaModel();
        emptyMap = MapsKt__MapsKt.emptyMap();
        q16.setMediaModel(MediaModel.copy$default(mediaModel, null, null, null, null, null, null, null, null, null, null, null, null, emptyMap, null, null, null, null, null, null, 520191, null));
        ComposeRenderLayer composeRenderLayer = this.renderLayerHelper;
        if (composeRenderLayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            composeRenderLayer = null;
        }
        composeRenderLayer.d(q16.getMediaModel());
    }
}
