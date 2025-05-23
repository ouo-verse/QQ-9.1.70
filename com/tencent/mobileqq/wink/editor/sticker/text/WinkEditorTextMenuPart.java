package com.tencent.mobileqq.wink.editor.sticker.text;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.util.Property;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContent;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContentWrapper;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.text.c;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import com.tencent.videocut.model.TextItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.sdk.util.UinConfigManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u00c8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 \u00ad\u00022\u00020\u00012\u00020\u0002:\u0002\u00ae\u0002B\t\u00a2\u0006\u0006\b\u00ab\u0002\u0010\u00ac\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\fH\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0003J\b\u0010#\u001a\u00020\u0003H\u0003J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0006H\u0002J\u001a\u0010-\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0018\u00102\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\t2\u0006\u00101\u001a\u000200H\u0002J\b\u00103\u001a\u00020\u0006H\u0002J\u0010\u00104\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\tH\u0002J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u00020\fH\u0016J\u0010\u00108\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\u0003H\u0016J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0014J$\u0010>\u001a\u00020\u00032\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030;H\u0014J\b\u0010?\u001a\u00020\u0003H\u0016J\b\u0010@\u001a\u00020\u0003H\u0016J\u0012\u0010C\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u0006H\u0016J\n\u0010G\u001a\u0004\u0018\u00010FH\u0016J$\u0010H\u001a\u00020\u00032\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030;H\u0014J\b\u0010I\u001a\u00020\u0003H\u0016J\b\u0010J\u001a\u00020\u0003H\u0016J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010L\u001a\u00020KH\u0016J\u0012\u0010P\u001a\u00020\u00032\b\u0010O\u001a\u0004\u0018\u00010NH\u0016J\b\u0010R\u001a\u00020QH\u0016J\u001c\u0010U\u001a\u00020\u00032\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00060SH\u0016J\b\u0010V\u001a\u00020\u0003H\u0016J\u0018\u0010X\u001a\n W*\u0004\u0018\u00010\u00150\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010Y\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J$\u0010\\\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010[\u001a\u0004\u0018\u00010Z2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010^\u001a\u00020\u0003J\u0006\u0010_\u001a\u00020\u0003J\u0010\u0010`\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010a\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010d\u001a\u00020\u00032\b\u0010c\u001a\u0004\u0018\u000100H\u0016J\u001a\u0010g\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\fH\u0016J\u0006\u0010h\u001a\u00020\u0003J\u0010\u0010k\u001a\u00020\u00032\u0006\u0010j\u001a\u00020iH\u0016J\b\u0010l\u001a\u00020\u0003H\u0016J\b\u0010m\u001a\u00020\u0003H\u0016J\b\u0010n\u001a\u000200H\u0004R\"\u0010u\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010w\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010p\u001a\u0004\bw\u0010r\"\u0004\bx\u0010tR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR*\u0010\u0081\u0001\u001a\u0004\u0018\u00010{2\b\u0010|\u001a\u0004\u0018\u00010{8\u0004@BX\u0084\u000e\u00a2\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R,\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0092\u0001\u001a\u0006\b\u0099\u0001\u0010\u0094\u0001\"\u0006\b\u009a\u0001\u0010\u0096\u0001R+\u0010\u00a2\u0001\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b\u00a0\u0001\u0010\u00a1\u0001R+\u0010\u00a6\u0001\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a3\u0001\u0010\u009d\u0001\u001a\u0006\b\u00a4\u0001\u0010\u009f\u0001\"\u0006\b\u00a5\u0001\u0010\u00a1\u0001R+\u0010\u00aa\u0001\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a7\u0001\u0010\u009d\u0001\u001a\u0006\b\u00a8\u0001\u0010\u009f\u0001\"\u0006\b\u00a9\u0001\u0010\u00a1\u0001R*\u0010\u00ad\u0001\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bp\u0010\u009d\u0001\u001a\u0006\b\u00ab\u0001\u0010\u009f\u0001\"\u0006\b\u00ac\u0001\u0010\u00a1\u0001R\u001c\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001c\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00b0\u0001R,\u0010\u00bb\u0001\u001a\u0005\u0018\u00010\u00b4\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u001c\u0010\u00bf\u0001\u001a\u0005\u0018\u00010\u00bc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u001c\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u00c0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u001c\u0010\u00c7\u0001\u001a\u0005\u0018\u00010\u00c4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u00c6\u0001R\u001b\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c8\u0001\u0010\u00c9\u0001R\u001c\u0010\u00cc\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cb\u0001\u0010\u0092\u0001R\u001c\u0010\u00d0\u0001\u001a\u0005\u0018\u00010\u00cd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u001c\u0010\u00d4\u0001\u001a\u0005\u0018\u00010\u00d1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001R\u001c\u0010\u00d8\u0001\u001a\u0005\u0018\u00010\u00d5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u00d7\u0001R\u0018\u0010\u00da\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d9\u0001\u0010zR\u0018\u0010\u00dc\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00db\u0001\u0010zR\u001c\u0010\u00e0\u0001\u001a\u0005\u0018\u00010\u00dd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00de\u0001\u0010\u00df\u0001R\u001c\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00e1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e2\u0001\u0010\u00e3\u0001R)\u0010\u00eb\u0001\u001a\u00020Q8\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u00e5\u0001\u0010\u00e6\u0001\u001a\u0006\b\u00e7\u0001\u0010\u00e8\u0001\"\u0006\b\u00e9\u0001\u0010\u00ea\u0001R*\u0010\u00f3\u0001\u001a\u00030\u00ec\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u00ed\u0001\u0010\u00ee\u0001\u001a\u0006\b\u00ef\u0001\u0010\u00f0\u0001\"\u0006\b\u00f1\u0001\u0010\u00f2\u0001R,\u0010\u00fb\u0001\u001a\u0005\u0018\u00010\u00f4\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00f5\u0001\u0010\u00f6\u0001\u001a\u0006\b\u00f7\u0001\u0010\u00f8\u0001\"\u0006\b\u00f9\u0001\u0010\u00fa\u0001R\u001c\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u00fc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fd\u0001\u0010\u00fe\u0001R\u0018\u0010\u0083\u0002\u001a\u00030\u0080\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0018\u0010\u0085\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0002\u0010zR\u0018\u0010\u0087\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0002\u0010zR\u0018\u0010\u0089\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0002\u0010pR\u001c\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0002\u0010\u0092\u0001R\u001c\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0002\u0010\u008a\u0001R\u001b\u0010\u008f\u0002\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0002\u0010\u009d\u0001R(\u0010\u0095\u0002\u001a\u00020\f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u0090\u0002\u0010z\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0018\u0010\u0097\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0096\u0002\u0010zR\u001b\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0002\u0010\u0099\u0002R\u001b\u0010\u009d\u0002\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u001c\u0010\u00a1\u0002\u001a\u0005\u0018\u00010\u009e\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0002\u0010\u00a0\u0002R\u001b\u0010\u00a4\u0002\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0002\u0010\u00a3\u0002R\u0018\u0010\u00a6\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0002\u0010pR\u0016\u0010\u00a8\u0002\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00a7\u0002\u0010rR\u0018\u0010\u00aa\u0002\u001a\u00030\u00f4\u00018TX\u0094\u0004\u00a2\u0006\b\u001a\u0006\b\u00a9\u0002\u0010\u00f8\u0001\u00a8\u0006\u00af\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lo73/a;", "", "Db", "Wb", "", "isTextEmpty", "vb", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ob", "", "displayType", "Ec", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Sc", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "pagEffectData", "dc", "Lorg/libpag/PAGFile;", "materialPagFile", "Kc", "Lorg/libpag/PAGText;", "pagText", "Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContent;", "content", "Ic", "Hc", "Tc", "bilingual", "Uc", "Za", "Lb", "Pb", "view", "jc", "index", "Oc", NodeProps.VISIBLE, "mc", "Landroid/widget/TextView;", "categoryText", "checked", "Nc", "nc", "Dc", "", "type", "eb", "ec", "ic", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "B9", "onInitView", "wb", "initAfterInflation", "Lkotlin/Function0;", "onStartAction", "onEndAction", "ua", Constants.BASE_IN_APP_NAME, "w3", "Landroid/os/Bundle;", "args", "L9", "isTemplateText", "Ya", "Landroid/graphics/Bitmap;", "gb", "ta", "onDismiss", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "cc", "Landroid/util/Pair;", "pair", "ub", "hc", "kotlin.jvm.PlatformType", "rb", "Rc", "Lorg/libpag/PAGView;", "mTextPagView", "Pc", "Fb", "ab", "kc", "Cb", "Ab", "Jb", "categoryId", "Gc", "isUpdated", "completeType", "bb", "Cc", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "oa", "K9", "sb", "M", "Z", "gc", "()Z", "Bc", "(Z)V", "isSubtitleMode", "N", "isSubtitleEditMode", "Ac", "P", "I", "Lcom/tencent/mobileqq/wink/editor/sticker/text/TextMenuBgView;", "<set-?>", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/sticker/text/TextMenuBgView;", "tb", "()Lcom/tencent/mobileqq/wink/editor/sticker/text/TextMenuBgView;", "textMenuBgView", BdhLogUtil.LogTag.Tag_Req, "Lorg/libpag/PAGView;", "Landroid/widget/FrameLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/FrameLayout;", "mContentLayout", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "lb", "()Landroid/widget/ImageView;", PlayerConfig.TC_CACHE_DIR_NAME, "(Landroid/widget/ImageView;)V", "mTextConfirm", "Landroid/widget/LinearLayout;", "U", "Landroid/widget/LinearLayout;", "getMMenuLayout", "()Landroid/widget/LinearLayout;", "sc", "(Landroid/widget/LinearLayout;)V", "mMenuLayout", "V", "ib", "setMBottomSwitchLayout", "mBottomSwitchLayout", "W", "Landroid/widget/TextView;", "kb", "()Landroid/widget/TextView;", "rc", "(Landroid/widget/TextView;)V", "mKeyboardTv", "X", "pb", "xc", "mTextStyleTv", "Y", "ob", "wc", "mTextPatternTv", "mb", "uc", "mTextDecorTv", "Landroid/graphics/drawable/Drawable;", "a0", "Landroid/graphics/drawable/Drawable;", "mCheckedCategoryIndicator", "b0", "mUncheckedCategoryIndicator", "Landroid/widget/EditText;", "c0", "Landroid/widget/EditText;", "nb", "()Landroid/widget/EditText;", "vc", "(Landroid/widget/EditText;)V", "mTextInput", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;", "d0", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;", "mKeyboardStateHelper", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper$a;", "e0", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper$a;", "mKeyboardStateListener", "Landroidx/constraintlayout/widget/ConstraintLayout;", "f0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mTextStyleTabLayout", "g0", "Landroid/view/View;", "mColorSelectorIndicator", "h0", "mColorSelectorLayout", "Lcom/tencent/mobileqq/wink/editor/sticker/text/g;", "i0", "Lcom/tencent/mobileqq/wink/editor/sticker/text/g;", "mTextFontContentAdapter", "Lcom/tencent/mobileqq/wink/editor/sticker/text/c;", "j0", "Lcom/tencent/mobileqq/wink/editor/sticker/text/c;", "mTextBackgroundAdapter", "Landroidx/constraintlayout/widget/Group;", "k0", "Landroidx/constraintlayout/widget/Group;", "textBgGroup", "l0", "mColorSelectorItemWidth", "m0", "mColorSelectorIndicatorOffset", "Landroid/support/v7/widget/RecyclerView;", "n0", "Landroid/support/v7/widget/RecyclerView;", "mContentRecyclerView", "Lcom/tencent/mobileqq/wink/editor/sticker/text/f;", "o0", "Lcom/tencent/mobileqq/wink/editor/sticker/text/f;", "mTextFancyContentAdapter", "p0", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "qb", "()Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "yc", "(Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;)V", "mTextViewModel", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "q0", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "jb", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "qc", "(Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;)V", "mEditorViewModel", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "r0", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", UinConfigManager.KEY_HB, "()Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "oc", "(Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;)V", "mApplyMaterialTask", "Landroid/graphics/RectF;", "s0", "Landroid/graphics/RectF;", "finalTextBounds", "Landroid/graphics/PointF;", "t0", "Landroid/graphics/PointF;", "pagViewCenter", "u0", "pagViewWidth", "v0", "contentheight", "w0", IMiniCardBeancurd.SIGN_PLAIN_TEXT, "x0", "ttsLayout", "y0", "ttsIcon", "z0", "ttsTextView", "A0", "getSaveTextUnderlayType", "()I", "zc", "(I)V", "saveTextUnderlayType", "B0", "saveTextColor", "C0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "currentMetaMaterial", "D0", "Ljava/lang/String;", "inputWords", "Lcom/tencent/mobileqq/wink/editor/view/e;", "E0", "Lcom/tencent/mobileqq/wink/editor/view/e;", "winkEditorChangeInputLoadingDialog", "F0", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "backToMenuType", "G0", "isPlayingWhenShow", "X9", "autoAnimate", "fb", "applyMaterialTask", "<init>", "()V", "H0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkEditorTextMenuPart extends WinkEditorMenuPart implements o73.a {

    /* renamed from: A0, reason: from kotlin metadata */
    private int saveTextUnderlayType;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial currentMetaMaterial;

    /* renamed from: D0, reason: from kotlin metadata */
    @Nullable
    private String inputWords;

    /* renamed from: E0, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.view.e winkEditorChangeInputLoadingDialog;

    /* renamed from: F0, reason: from kotlin metadata */
    @Nullable
    private MenuType backToMenuType;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean isPlayingWhenShow;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isSubtitleMode;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isSubtitleEditMode;

    /* renamed from: P, reason: from kotlin metadata */
    private int displayType;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TextMenuBgView textMenuBgView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private PAGView mTextPagView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mContentLayout;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ImageView mTextConfirm;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mMenuLayout;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mBottomSwitchLayout;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView mKeyboardTv;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TextView mTextStyleTv;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private TextView mTextPatternTv;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private TextView mTextDecorTv;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mCheckedCategoryIndicator;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mUncheckedCategoryIndicator;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mTextInput;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSoftKeyboardStateHelper mKeyboardStateHelper;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSoftKeyboardStateHelper.a mKeyboardStateListener;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout mTextStyleTabLayout;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mColorSelectorIndicator;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mColorSelectorLayout;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mTextFontContentAdapter;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.sticker.text.c mTextBackgroundAdapter;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Group textBgGroup;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private int mColorSelectorItemWidth;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private int mColorSelectorIndicatorOffset;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mContentRecyclerView;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.sticker.text.f mTextFancyContentAdapter;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    protected bb mTextViewModel;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    protected WinkEditorViewModel mEditorViewModel;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ApplyMaterialTask mApplyMaterialTask;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RectF finalTextBounds;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private int pagViewWidth;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private int contentheight;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout ttsLayout;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ttsIcon;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView ttsTextView;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF pagViewCenter = new PointF();

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private boolean plainText = true;

    /* renamed from: B0, reason: from kotlin metadata */
    private int saveTextColor = Color.parseColor("#EFEFEF");

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart$b", "Lcom/tencent/mobileqq/wink/flow/a;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "", "F1", "g", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.wink.flow.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void F1(@NotNull ApplyMaterialTask.Status downloadStatus, int position, @NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
            Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (com.tencent.mobileqq.wink.editor.sticker.m.W(material)) {
                super.F1(downloadStatus, position, material, callback);
            } else {
                com.tencent.mobileqq.wink.editor.sticker.l.K(material, callback);
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void g(int position, @NotNull MetaMaterial material) {
            String str;
            Intrinsics.checkNotNullParameter(material, "material");
            WinkEditorTextMenuPart.this.qb().M1(material);
            WinkEditorViewModel G9 = WinkEditorTextMenuPart.this.G9();
            if (G9 != null && (str = G9.getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String()) != null) {
                String id5 = material.f30533id;
                Intrinsics.checkNotNullExpressionValue(id5, "id");
                y53.e.d().a(str, material.f30533id, new WinkPublishQualityReportData("P_MATERIAL_COST_END", null, "0", id5, "video", null, null, null, null, null, null, null, null, null, 0L, 32738, null));
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public boolean z(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            if (!Intrinsics.areEqual("TEXT_DEFAULT_DEFAULT_ID", material.f30533id) && !Intrinsics.areEqual("TEXT_PATTERN_NON_ID", material.f30533id) && !Intrinsics.areEqual("TEXT_DECOR_NON_ID", material.f30533id)) {
                return super.z(position, material);
            }
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart$d", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper$a;", "", "onSoftKeyboardClosed", "", "keyboardHeightInPx", "onSoftKeyboardOpened", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements WinkSoftKeyboardStateHelper.a {
        d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0040, code lost:
        
            if (r0.k() == true) goto L12;
         */
        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int keyboardHeightInPx) {
            Boolean bool;
            boolean z16;
            WinkEditorTextMenuPart winkEditorTextMenuPart = WinkEditorTextMenuPart.this;
            String str = winkEditorTextMenuPart.TAG;
            WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = winkEditorTextMenuPart.mKeyboardStateHelper;
            if (winkSoftKeyboardStateHelper != null) {
                bool = Boolean.valueOf(winkSoftKeyboardStateHelper.k());
            } else {
                bool = null;
            }
            w53.b.a(str, "onSoftKeyboardHeightChanged keyboardHeightInPx:" + keyboardHeightInPx + " keyboardOpened:" + bool);
            WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper2 = WinkEditorTextMenuPart.this.mKeyboardStateHelper;
            if (winkSoftKeyboardStateHelper2 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                if (WinkEditorTextMenuPart.this.displayType == 4) {
                    LinearLayout mBottomSwitchLayout = WinkEditorTextMenuPart.this.getMBottomSwitchLayout();
                    if (mBottomSwitchLayout != null) {
                        mBottomSwitchLayout.setVisibility(8);
                    }
                    FrameLayout frameLayout = WinkEditorTextMenuPart.this.mContentLayout;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                }
                WinkEditorTextMenuPart.this.qb().N1("CATEGORY_KEYBOARD");
                FrameLayout frameLayout2 = WinkEditorTextMenuPart.this.mContentLayout;
                Intrinsics.checkNotNull(frameLayout2);
                if (frameLayout2.getLayoutParams().height != keyboardHeightInPx) {
                    FrameLayout frameLayout3 = WinkEditorTextMenuPart.this.mContentLayout;
                    Intrinsics.checkNotNull(frameLayout3);
                    frameLayout3.getLayoutParams().height = keyboardHeightInPx;
                    FrameLayout frameLayout4 = WinkEditorTextMenuPart.this.mContentLayout;
                    Intrinsics.checkNotNull(frameLayout4);
                    frameLayout4.requestLayout();
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardClosed() {
            w53.b.a(WinkEditorTextMenuPart.this.TAG, "onSoftKeyboardClosed");
            if (WinkEditorTextMenuPart.this.displayType == 4) {
                FrameLayout frameLayout = WinkEditorTextMenuPart.this.mContentLayout;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                LinearLayout mBottomSwitchLayout = WinkEditorTextMenuPart.this.getMBottomSwitchLayout();
                if (mBottomSwitchLayout != null) {
                    mBottomSwitchLayout.setVisibility(8);
                    return;
                }
                return;
            }
            String value = WinkEditorTextMenuPart.this.qb().U1().getValue();
            if (Intrinsics.areEqual("CATEGORY_KEYBOARD", value)) {
                WinkEditorTextMenuPart.cb(WinkEditorTextMenuPart.this, false, 0, 2, null);
            } else {
                WinkEditorTextMenuPart.this.Gc(value);
            }
            FrameLayout frameLayout2 = WinkEditorTextMenuPart.this.mContentLayout;
            Intrinsics.checkNotNull(frameLayout2);
            if (frameLayout2.getLayoutParams().height != WinkEditorTextMenuPart.this.contentheight && WinkEditorTextMenuPart.this.currentMetaMaterial != null) {
                FrameLayout frameLayout3 = WinkEditorTextMenuPart.this.mContentLayout;
                Intrinsics.checkNotNull(frameLayout3);
                frameLayout3.getLayoutParams().height = WinkEditorTextMenuPart.this.contentheight;
                FrameLayout frameLayout4 = WinkEditorTextMenuPart.this.mContentLayout;
                Intrinsics.checkNotNull(frameLayout4);
                frameLayout4.requestLayout();
            }
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            w53.b.a(WinkEditorTextMenuPart.this.TAG, "onSoftKeyboardOpened keyboardHeightInPx:" + keyboardHeightInPx);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321955d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321956e;

        e(Function0<Unit> function0, Function0<Unit> function02) {
            this.f321955d = function0;
            this.f321956e = function02;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f321956e.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            this.f321955d.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321957d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321958e;

        f(Function0<Unit> function0, Function0<Unit> function02) {
            this.f321957d = function0;
            this.f321958e = function02;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f321958e.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            this.f321957d.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bb(WinkEditorTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qb().N1("CATEGORY_KEYBOARD");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Db() {
        aa().getTextMaterialVOLiveData().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Eb(WinkEditorTextMenuPart.this, (com.tencent.mobileqq.wink.editor.model.b) obj);
            }
        });
    }

    private final void Dc(boolean visible) {
        int i3;
        Nc(this.mTextStyleTv, visible);
        ConstraintLayout constraintLayout = this.mTextStyleTabLayout;
        if (constraintLayout != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            constraintLayout.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eb(WinkEditorTextMenuPart this$0, com.tencent.mobileqq.wink.editor.model.b winkMaterialVO) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(winkMaterialVO, "winkMaterialVO");
        this$0.qb().H2(winkMaterialVO.a());
    }

    private final void Ec(int displayType) {
        if (!this.visible) {
            Bundle bundle = new Bundle();
            bundle.putInt(EmotionConstants.DISPLAY_TYPE, displayType);
            Q9(bundle);
        }
        qb().w2();
        qb().N1("CATEGORY_KEYBOARD");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gb(WinkEditorTextMenuPart this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.qb().P1(v3, v3.getId(), this$0.sb());
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hb(WinkEditorTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ab();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Hc(PAGText pagText, MetaMaterial material) {
        if (com.tencent.mobileqq.wink.editor.c.W0(material, "backgroundColor")) {
            pagText.backgroundColor = com.tencent.mobileqq.wink.editor.sticker.m.g(material);
        } else {
            com.tencent.mobileqq.wink.editor.sticker.m.g0(material, pagText.backgroundColor);
        }
        if (com.tencent.mobileqq.wink.editor.c.W0(material, "backgroundAlpha")) {
            pagText.backgroundAlpha = com.tencent.mobileqq.wink.editor.sticker.m.f(material);
        } else {
            com.tencent.mobileqq.wink.editor.sticker.m.f0(material, pagText.backgroundAlpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ib(WinkEditorTextMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cb(this$0, false, 0, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ic(PAGText pagText, MetaMaterialContent content, MetaMaterial material) {
        pagText.text = "";
        if (content != null) {
            pagText.text = content.getContent();
            pagText.fillColor = com.tencent.mobileqq.wink.editor.sticker.m.F(material);
            pagText.fontStyle = com.tencent.mobileqq.wink.editor.sticker.m.s(material);
            pagText.fontFamily = com.tencent.mobileqq.wink.editor.sticker.m.o(material);
            Hc(pagText, material);
            Tc(pagText, material);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kb(WinkEditorTextMenuPart this$0, View view) {
        String str;
        Editable text;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mTextInput;
        if (editText != null && (text = editText.getText()) != null) {
            str = text.toString();
        } else {
            str = null;
        }
        this$0.inputWords = str;
        this$0.kc();
        this$0.bb(true, 1);
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(7, 100));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Kc(PAGFile materialPagFile, final MetaMaterial material) {
        MetaMaterialContentWrapper metaMaterialContentWrapper;
        MetaMaterialContentWrapper metaMaterialContentWrapper2;
        ArrayList<MetaMaterialContent> arrayList;
        Integer num;
        Integer num2;
        ArrayList<MetaMaterialContent> metaMaterialContent;
        ArrayList<MetaMaterialContent> metaMaterialContent2;
        ArrayList<MetaMaterialContent> metaMaterialContent3;
        MetaMaterialContentWrapper m3;
        ArrayList<MetaMaterialContent> arrayList2;
        MetaMaterialContent metaMaterialContent4;
        ArrayList<MetaMaterialContent> metaMaterialContent5;
        MetaMaterialContentWrapper m16;
        PAGView pAGView = this.mTextPagView;
        if (materialPagFile != null && pAGView != null) {
            PAGText textData = materialPagFile.getTextData(0);
            if (textData == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(textData, "pagFile.getTextData(0) ?: return");
            MetaMaterialContent metaMaterialContent6 = null;
            if (material != null) {
                metaMaterialContentWrapper = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
            } else {
                metaMaterialContentWrapper = null;
            }
            if (metaMaterialContentWrapper != null) {
                if (material != null && (m16 = com.tencent.mobileqq.wink.editor.sticker.m.m(material)) != null) {
                    arrayList2 = m16.getMetaMaterialContent();
                } else {
                    arrayList2 = null;
                }
                if (arrayList2 != null) {
                    MetaMaterialContentWrapper m17 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                    if (m17 != null && (metaMaterialContent5 = m17.getMetaMaterialContent()) != null) {
                        metaMaterialContent4 = metaMaterialContent5.get(0);
                    } else {
                        metaMaterialContent4 = null;
                    }
                    Ic(textData, metaMaterialContent4, material);
                }
            }
            materialPagFile.replaceText(0, textData);
            boolean z16 = true;
            PAGText textData2 = materialPagFile.getTextData(1);
            if (textData2 == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(textData2, "pagFile.getTextData(1) ?: return");
            if (material != null) {
                metaMaterialContentWrapper2 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
            } else {
                metaMaterialContentWrapper2 = null;
            }
            if (metaMaterialContentWrapper2 != null) {
                if (material != null && (m3 = com.tencent.mobileqq.wink.editor.sticker.m.m(material)) != null) {
                    arrayList = m3.getMetaMaterialContent();
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    if (this.isSubtitleEditMode) {
                        Ic(textData2, null, material);
                    } else {
                        MetaMaterialContentWrapper m18 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                        if (m18 != null && (metaMaterialContent3 = m18.getMetaMaterialContent()) != null) {
                            num = Integer.valueOf(metaMaterialContent3.size());
                        } else {
                            num = null;
                        }
                        if (num != null) {
                            MetaMaterialContentWrapper m19 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                            if (m19 != null && (metaMaterialContent2 = m19.getMetaMaterialContent()) != null) {
                                num2 = Integer.valueOf(metaMaterialContent2.size());
                            } else {
                                num2 = null;
                            }
                            Intrinsics.checkNotNull(num2);
                            if (num2.intValue() >= 2) {
                                MetaMaterialContentWrapper m26 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                                if (m26 != null && (metaMaterialContent = m26.getMetaMaterialContent()) != null) {
                                    metaMaterialContent6 = metaMaterialContent.get(1);
                                }
                                Ic(textData2, metaMaterialContent6, material);
                            }
                        }
                    }
                }
            }
            materialPagFile.replaceText(1, textData2);
            pAGView.setComposition(materialPagFile);
            Handler mainHandler = getMainHandler();
            if (mainHandler != null) {
                mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ac
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorTextMenuPart.Mc(WinkEditorTextMenuPart.this, material);
                    }
                });
            }
            this.pagViewWidth = pAGView.getWidth();
            this.pagViewCenter.x = pAGView.getWidth() / 2.0f;
            this.pagViewCenter.y = pAGView.getHeight() / 2.0f;
            int numChildren = materialPagFile.numChildren();
            if (numChildren != 1) {
                z16 = false;
            }
            this.plainText = z16;
            if (z16) {
                for (int i3 = 0; i3 < numChildren; i3++) {
                    PAGLayer layerAt = materialPagFile.getLayerAt(i3);
                    String str = this.TAG;
                    Intrinsics.checkNotNull(layerAt);
                    ms.a.c(str, "layer name [" + i3 + "] = " + layerAt.layerName());
                    RectF bounds = layerAt.getBounds();
                    this.finalTextBounds = bounds;
                    ms.a.a(this.TAG, "bounds before concat = " + bounds + "  height = " + materialPagFile.height());
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    while (layerAt != null) {
                        matrix.postConcat(layerAt.getTotalMatrix());
                        layerAt = layerAt.parent();
                    }
                    matrix.mapRect(this.finalTextBounds);
                    ms.a.c(this.TAG, "bounds = " + this.finalTextBounds + " ,height = " + materialPagFile.height());
                }
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void Lb(View rootView) {
        this.mContentRecyclerView = (RecyclerView) rootView.findViewById(R.id.u7w);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), Za());
        RecyclerView recyclerView = this.mContentRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        com.tencent.mobileqq.wink.editor.sticker.text.f fVar = new com.tencent.mobileqq.wink.editor.sticker.text.f(getContext(), G9().getEditMode());
        fVar.U(true);
        fVar.S(fb());
        this.mTextFancyContentAdapter = fVar;
        RecyclerView recyclerView2 = this.mContentRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(fVar);
        }
        qb().i2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Mb(WinkEditorTextMenuPart.this, (List) obj);
            }
        });
        qb().h2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Nb(WinkEditorTextMenuPart.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mb(WinkEditorTextMenuPart this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.sticker.text.f fVar = this$0.mTextFancyContentAdapter;
        if (fVar != null) {
            fVar.Y(list);
        }
        com.tencent.mobileqq.wink.editor.sticker.text.f fVar2 = this$0.mTextFancyContentAdapter;
        if (fVar2 != null) {
            fVar2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mc(WinkEditorTextMenuPart this$0, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        this$0.Uc(material, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nb(WinkEditorTextMenuPart this$0, Integer num) {
        com.tencent.mobileqq.wink.editor.sticker.text.f fVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && (fVar = this$0.mTextFancyContentAdapter) != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.a0(num.intValue());
        }
    }

    private final void Nc(TextView categoryText, boolean checked) {
        if (checked) {
            if (categoryText != null) {
                categoryText.setTypeface(Typeface.defaultFromStyle(1));
            }
            if (categoryText != null) {
                categoryText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, this.mCheckedCategoryIndicator);
                return;
            }
            return;
        }
        if (categoryText != null) {
            categoryText.setTypeface(Typeface.defaultFromStyle(0));
        }
        if (categoryText != null) {
            categoryText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, this.mUncheckedCategoryIndicator);
        }
    }

    private final void Ob(View rootView) {
        TextMenuBgView textMenuBgView = (TextMenuBgView) rootView.findViewById(R.id.f94835dc);
        this.textMenuBgView = textMenuBgView;
        if (textMenuBgView != null) {
            textMenuBgView.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart$initTextPagView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WinkEditorTextMenuPart.this.hc();
                }
            });
        }
        PAGView pAGView = (PAGView) rootView.findViewById(R.id.f94865df);
        if (pAGView != null) {
            pAGView.play();
            pAGView.setRepeatCount(0);
            this.pagViewWidth = pAGView.getWidth();
        } else {
            pAGView = null;
        }
        this.mTextPagView = pAGView;
    }

    private final void Oc(int index) {
        LinearLayout linearLayout = this.mColorSelectorLayout;
        if (linearLayout == null) {
            return;
        }
        if (index == -1) {
            View view = this.mColorSelectorIndicator;
            Intrinsics.checkNotNull(view);
            view.setVisibility(4);
            return;
        }
        if (index >= 0) {
            Intrinsics.checkNotNull(linearLayout);
            if (index <= linearLayout.getChildCount()) {
                View view2 = this.mColorSelectorIndicator;
                Intrinsics.checkNotNull(view2);
                view2.setVisibility(0);
                View view3 = this.mColorSelectorIndicator;
                Intrinsics.checkNotNull(view3);
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                LinearLayout linearLayout2 = this.mColorSelectorLayout;
                Intrinsics.checkNotNull(linearLayout2);
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = linearLayout2.getChildAt(index).getLeft();
                LinearLayout linearLayout3 = this.mColorSelectorLayout;
                Intrinsics.checkNotNull(linearLayout3);
                int width = linearLayout3.getChildAt(0).getWidth();
                int i3 = this.mColorSelectorItemWidth;
                if (i3 == 0 || i3 != width) {
                    this.mColorSelectorItemWidth = width;
                    View view4 = this.mColorSelectorIndicator;
                    Intrinsics.checkNotNull(view4);
                    view4.getLayoutParams().width = this.mColorSelectorItemWidth + (this.mColorSelectorIndicatorOffset * 2);
                }
                View view5 = this.mColorSelectorIndicator;
                Intrinsics.checkNotNull(view5);
                view5.requestLayout();
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void Pb() {
        ViewStub viewStub;
        ms.a.a(this.TAG, "initTextStyleTab");
        View partRootView = getPartRootView();
        View view = null;
        if (partRootView != null) {
            viewStub = (ViewStub) partRootView.findViewById(R.id.f897950q);
        } else {
            viewStub = null;
        }
        if (viewStub != null) {
            view = viewStub.inflate();
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        this.mTextStyleTabLayout = constraintLayout;
        Intrinsics.checkNotNull(constraintLayout);
        View findViewById = constraintLayout.findViewById(R.id.f94965dp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mTextStyleTabLayout!!.fi\u2026(R.id.textStyleContentRv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        g gVar = new g(getContext(), G9().getEditMode());
        gVar.S(fb());
        this.mTextFontContentAdapter = gVar;
        recyclerView.setAdapter(gVar);
        ConstraintLayout constraintLayout2 = this.mTextStyleTabLayout;
        Intrinsics.checkNotNull(constraintLayout2);
        View findViewById2 = constraintLayout2.findViewById(R.id.f94655cv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mTextStyleTabLayout!!.fi\u2026yId(R.id.textBgContentRv)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        com.tencent.mobileqq.wink.editor.sticker.text.c cVar = new com.tencent.mobileqq.wink.editor.sticker.text.c();
        this.mTextBackgroundAdapter = cVar;
        Intrinsics.checkNotNull(cVar);
        cVar.w(new c.InterfaceC9038c() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ah
            @Override // com.tencent.mobileqq.wink.editor.sticker.text.c.InterfaceC9038c
            public final void a(int i3) {
                WinkEditorTextMenuPart.Qb(WinkEditorTextMenuPart.this, i3);
            }
        });
        recyclerView2.setAdapter(this.mTextBackgroundAdapter);
        ConstraintLayout constraintLayout3 = this.mTextStyleTabLayout;
        Intrinsics.checkNotNull(constraintLayout3);
        Group group = (Group) constraintLayout3.findViewById(R.id.f94675cx);
        this.textBgGroup = group;
        if (group != null) {
            group.setReferencedIds(new int[]{R.id.f94665cw, R.id.f94655cv});
        }
        qb().k2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Rb(WinkEditorTextMenuPart.this, (List) obj);
            }
        });
        qb().j2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Sb(WinkEditorTextMenuPart.this, (Integer) obj);
            }
        });
        qb().l2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Tb(WinkEditorTextMenuPart.this, (Integer) obj);
            }
        });
        ConstraintLayout constraintLayout4 = this.mTextStyleTabLayout;
        Intrinsics.checkNotNull(constraintLayout4);
        this.mColorSelectorIndicator = constraintLayout4.findViewById(R.id.u0q);
        ConstraintLayout constraintLayout5 = this.mTextStyleTabLayout;
        Intrinsics.checkNotNull(constraintLayout5);
        LinearLayout linearLayout = (LinearLayout) constraintLayout5.findViewById(R.id.u0r);
        this.mColorSelectorLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.setWeightSum(bb.f322034r0.size());
        }
        int size = bb.f322034r0.size();
        for (final int i3 = 0; i3 < size; i3++) {
            View view2 = new View(getContext());
            List<Integer> list = bb.f322034r0;
            Integer num = list.get(i3);
            if (num != null && num.intValue() == -1) {
                view2.setBackgroundColor(bb.f322033q0);
            } else {
                Integer num2 = list.get(i3);
                Intrinsics.checkNotNullExpressionValue(num2, "WinkEditorTextViewModel.COLOR_SELECTOR_SET[i]");
                view2.setBackgroundColor(num2.intValue());
            }
            LinearLayout linearLayout2 = this.mColorSelectorLayout;
            if (linearLayout2 != null) {
                linearLayout2.addView(view2, new LinearLayout.LayoutParams(0, -1, 1.0f));
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WinkEditorTextMenuPart.Vb(WinkEditorTextMenuPart.this, i3, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qb(WinkEditorTextMenuPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qb().S2(i3);
        com.tencent.mobileqq.wink.editor.sticker.text.c cVar = this$0.mTextBackgroundAdapter;
        if (cVar != null) {
            cVar.x(this$0.qb().m2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qc(WinkEditorTextMenuPart this$0, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        this$0.Uc(material, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rb(WinkEditorTextMenuPart this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = this$0.mTextFontContentAdapter;
        if (gVar != null) {
            gVar.Y(list);
        }
        g gVar2 = this$0.mTextFontContentAdapter;
        if (gVar2 != null) {
            gVar2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sb(WinkEditorTextMenuPart this$0, Integer num) {
        MetaMaterial metaMaterial;
        Object orNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.a(this$0.TAG, "textFontMaterialIndexLiveData " + num);
        g gVar = this$0.mTextFontContentAdapter;
        if (num != null && gVar != null) {
            int intValue = num.intValue();
            List<MetaMaterial> materials = gVar.B();
            if (materials != null) {
                Intrinsics.checkNotNullExpressionValue(materials, "materials");
                orNull = CollectionsKt___CollectionsKt.getOrNull(materials, intValue);
                metaMaterial = (MetaMaterial) orNull;
            } else {
                metaMaterial = null;
            }
            gVar.P(intValue, metaMaterial);
            gVar.a0(intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sc(MetaMaterial material) {
        if (this.mTextPagView != null) {
            PAGFile rb5 = rb(material);
            PagEffectData A = rd4.c.f431135f.A(com.tencent.mobileqq.wink.editor.sticker.m.y(material));
            if (A != null && dc(A)) {
                Kc(rb5, material);
            } else {
                Pc(rb5, this.mTextPagView, material);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tb(WinkEditorTextMenuPart this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.sticker.text.c cVar = this$0.mTextBackgroundAdapter;
        if (num != null && cVar != null) {
            cVar.v(num.intValue());
            cVar.notifyDataSetChanged();
        }
    }

    private final void Tc(PAGText pagText, MetaMaterial material) {
        if (com.tencent.mobileqq.wink.editor.c.W0(material, "applyStroke")) {
            pagText.applyStroke = com.tencent.mobileqq.wink.editor.sticker.m.e(material);
        } else {
            com.tencent.mobileqq.wink.editor.sticker.m.e0(material, pagText.applyStroke);
        }
        if (com.tencent.mobileqq.wink.editor.c.W0(material, "strokeColor")) {
            pagText.strokeColor = com.tencent.mobileqq.wink.editor.sticker.m.B(material);
        } else {
            com.tencent.mobileqq.wink.editor.sticker.m.H0(material, pagText.strokeColor);
        }
        if (com.tencent.mobileqq.wink.editor.c.W0(material, "strokeWidth")) {
            pagText.strokeWidth = com.tencent.mobileqq.wink.editor.sticker.m.C(material);
        } else {
            com.tencent.mobileqq.wink.editor.sticker.m.I0(material, pagText.strokeWidth);
        }
    }

    private final void Uc(MetaMaterial material, boolean bilingual) {
        int i3;
        ArrayList<MetaMaterialContent> arrayList;
        MetaMaterialContent metaMaterialContent;
        ArrayList<MetaMaterialContent> metaMaterialContent2;
        ArrayList<MetaMaterialContent> metaMaterialContent3;
        String l3 = com.tencent.mobileqq.wink.editor.sticker.m.l(material);
        boolean z16 = false;
        if (bilingual && com.tencent.mobileqq.wink.editor.sticker.m.m(material) != null) {
            MetaMaterialContentWrapper m3 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
            MetaMaterialContent metaMaterialContent4 = null;
            if (m3 != null) {
                arrayList = m3.getMetaMaterialContent();
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                MetaMaterialContentWrapper m16 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                if (m16 != null && (metaMaterialContent3 = m16.getMetaMaterialContent()) != null) {
                    metaMaterialContent = metaMaterialContent3.get(0);
                } else {
                    metaMaterialContent = null;
                }
                if (metaMaterialContent != null) {
                    MetaMaterialContentWrapper m17 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                    if (m17 != null && (metaMaterialContent2 = m17.getMetaMaterialContent()) != null) {
                        metaMaterialContent4 = metaMaterialContent2.get(0);
                    }
                    Intrinsics.checkNotNull(metaMaterialContent4);
                    l3 = metaMaterialContent4.getContent();
                }
            }
        }
        EditText editText = this.mTextInput;
        if (editText != null) {
            if (!Intrinsics.areEqual(l3, editText.getText().toString()) && !Intrinsics.areEqual(l3, bb.f322031o0)) {
                editText.setText(l3);
                Editable text = editText.getText();
                if (text != null) {
                    i3 = text.length();
                } else {
                    i3 = 0;
                }
                editText.setSelection(i3);
                ImageView imageView = this.mTextConfirm;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.m3u);
                }
            }
            Editable text2 = editText.getText();
            if (text2 == null || text2.length() == 0) {
                z16 = true;
            }
            vb(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vb(WinkEditorTextMenuPart this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bb qb5 = this$0.qb();
        Integer num = bb.f322034r0.get(i3);
        Intrinsics.checkNotNullExpressionValue(num, "WinkEditorTextViewModel.COLOR_SELECTOR_SET[i]");
        qb5.P2(num.intValue());
        this$0.Oc(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Wb() {
        ViewModel viewModel = getViewModel(WinkEditorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorViewModel::class.java)");
        qc((WinkEditorViewModel) viewModel);
        yc(cc());
        qb().q2();
        qb().X1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Xb(WinkEditorTextMenuPart.this, (MetaMaterial) obj);
            }
        });
        qb().U1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Yb(WinkEditorTextMenuPart.this, (String) obj);
            }
        });
        qb().g2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.Zb(WinkEditorTextMenuPart.this, ((Integer) obj).intValue());
            }
        });
        qb().f2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.ac(WinkEditorTextMenuPart.this, (t73.a) obj);
            }
        });
        if (!this.isSubtitleMode) {
            qb().d2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorTextMenuPart.bc(WinkEditorTextMenuPart.this, (Pair) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xb(WinkEditorTextMenuPart this$0, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "material");
        this$0.currentMetaMaterial = material;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkEditorTextMenuPart$initTextViewModel$1$1$1(this$0, material, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yb(WinkEditorTextMenuPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gc(str);
    }

    private final int Za() {
        int screenWidth = (ImmersiveUtils.getScreenWidth() - (ViewExKt.d(24) * 2)) / ViewExKt.d(72);
        if (screenWidth >= 4) {
            return 4;
        }
        return screenWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zb(WinkEditorTextMenuPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.a(this$0.TAG, "textColorIndexLiveData select " + i3);
        this$0.Oc(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ac(WinkEditorTextMenuPart this$0, t73.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair<String, Boolean> pair = (Pair) aVar.a();
        if (pair == null) {
            return;
        }
        this$0.ub(pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bc(WinkEditorTextMenuPart this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = pair.second;
        Intrinsics.checkNotNullExpressionValue(obj, "it.second");
        this$0.Ec(((Number) obj).intValue());
    }

    public static /* synthetic */ void cb(WinkEditorTextMenuPart winkEditorTextMenuPart, boolean z16, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            winkEditorTextMenuPart.bb(z16, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: complete");
    }

    private final boolean dc(PagEffectData pagEffectData) {
        boolean z16;
        boolean z17;
        List<TextLayerData> textLayerList;
        if (pagEffectData != null && (textLayerList = pagEffectData.getTextLayerList()) != null) {
            z16 = false;
            z17 = false;
            for (TextLayerData textLayerData : textLayerList) {
                if (Intrinsics.areEqual(textLayerData.getLayerName(), "source")) {
                    z16 = true;
                }
                if (Intrinsics.areEqual(textLayerData.getLayerName(), com.tencent.mobileqq.wink.editor.subtitle.a.f322144a.g())) {
                    z17 = true;
                }
            }
        } else {
            z16 = false;
            z17 = false;
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    private final void eb(View view, String type) {
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, type);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, sb());
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CHAR_PATTERN);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(hashMap);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private final boolean ec() {
        return H9() instanceof WinkImageTavCut;
    }

    private final void ic(View view) {
        Map<String, Object> mParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(mParams, "mParams");
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_TYPE, Integer.valueOf(qb().f322039c0));
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_USE_TEXT_SOURCE, qb().m2());
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, sb());
        mParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        mParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_TEXT_STYLE_FINISH);
        int i3 = 1;
        if (this.displayType != 1) {
            i3 = 0;
        }
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_TEMPLATE, Integer.valueOf(i3));
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXT_STYLE_FINISH);
        VideoReport.reportEvent("ev_xsj_camera_action", view, mParams);
    }

    private final void jc(View view) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_TEXT_READ_ICON_1);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private final void mc(boolean visible) {
        EditText editText = this.mTextInput;
        if (editText != null) {
            editText.setCursorVisible(visible);
        }
    }

    private final void nc(boolean visible) {
        EditText editText = this.mTextInput;
        if (editText != null) {
            Nc(this.mKeyboardTv, visible);
            if (visible) {
                mc(true);
                com.tencent.videocut.utils.j.f384247a.b(editText);
            } else {
                mc(false);
                com.tencent.videocut.utils.j.f384247a.a(editText);
            }
        }
    }

    private final void vb(boolean isTextEmpty) {
        float f16;
        w53.b.a(this.TAG, "handleTTSLayout: " + isTextEmpty);
        LinearLayout linearLayout = this.ttsLayout;
        boolean z16 = false;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            ImageView imageView = this.ttsIcon;
            float f17 = 0.55f;
            if (imageView != null) {
                if (isTextEmpty) {
                    f16 = 0.55f;
                } else {
                    f16 = 1.0f;
                }
                imageView.setAlpha(f16);
            }
            TextView textView = this.ttsTextView;
            if (textView != null) {
                if (!isTextEmpty) {
                    f17 = 1.0f;
                }
                textView.setAlpha(f17);
            }
            LinearLayout linearLayout2 = this.ttsLayout;
            if (linearLayout2 != null) {
                linearLayout2.setClickable(!isTextEmpty);
            }
            LinearLayout linearLayout3 = this.ttsLayout;
            if (linearLayout3 != null) {
                linearLayout3.setEnabled(!isTextEmpty);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(WinkEditorTextMenuPart this$0, WinkStickerModel winkStickerModel) {
        MetaMaterial material;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            Intrinsics.checkNotNull(winkStickerModel);
            dr.b.n(H9, winkStickerModel, false, 2, null);
        }
        if (winkStickerModel != null && (material = winkStickerModel.getMaterial()) != null && com.tencent.mobileqq.wink.editor.sticker.m.T(material)) {
            String str = "";
            for (TextItem textItem : winkStickerModel.textItems) {
                if (textItem.text.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    str = textItem.text;
                }
            }
            this$0.jb().j5(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yb(WinkEditorTextMenuPart this$0, MetaMaterial metaMaterial) {
        Serializable serializable;
        final TTSAudioInfo tTSAudioInfo;
        long j3;
        long durationUs;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        WinkEditorFragment F9 = this$0.F9();
        if (metaMaterial != null && H9 != null && F9 != null) {
            WinkStickerModel b26 = this$0.qb().b2();
            boolean z16 = false;
            if (b26 != null && b26.getHasChooseTTS()) {
                z16 = true;
            }
            if (z16) {
                WinkStickerModel b27 = this$0.qb().b2();
                if (b27 != null) {
                    tTSAudioInfo = b27.getTtsAudioInfo();
                } else {
                    tTSAudioInfo = null;
                }
            } else {
                Map<String, Serializable> map = metaMaterial.additionalObjectFields;
                if (map != null) {
                    serializable = map.get("ttsAudioInfo");
                } else {
                    serializable = null;
                }
                tTSAudioInfo = (TTSAudioInfo) serializable;
            }
            WinkStickerModel b28 = this$0.qb().b2();
            if (b28 != null) {
                j3 = b28.startTime;
            } else {
                j3 = 0;
            }
            WinkStickerModel b29 = this$0.qb().b2();
            if (b29 != null) {
                durationUs = b29.duration;
            } else {
                durationUs = H9.getDurationUs();
            }
            com.tencent.mobileqq.wink.editor.sticker.l.k(metaMaterial, H9, F9, j3, durationUs, new Function1<WinkStickerModel, WinkStickerModel>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart$initDataObserver$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final WinkStickerModel invoke(@NotNull WinkStickerModel stickerModel) {
                    Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
                    stickerModel.setHasChooseTTS(TTSAudioInfo.this != null);
                    TTSAudioInfo tTSAudioInfo2 = TTSAudioInfo.this;
                    stickerModel.setTtsAudioInfo(tTSAudioInfo2 != null ? tTSAudioInfo2.copy(tTSAudioInfo2.getTemplateType(), TTSAudioInfo.this.getDisplayName(), null, TTSAudioInfo.this.getVolume(), stickerModel.id) : null);
                    return stickerModel;
                }
            });
            this$0.qb().D2(null);
            if (com.tencent.mobileqq.wink.editor.sticker.m.T(metaMaterial)) {
                this$0.jb().j5(com.tencent.mobileqq.wink.editor.sticker.m.l(metaMaterial));
            }
        }
    }

    public void Ab(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        EditText editText = (EditText) rootView.findViewById(R.id.f94815da);
        this.mTextInput = editText;
        if (editText != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTextMenuPart.Bb(WinkEditorTextMenuPart.this, view);
                }
            });
        }
        EditText editText2 = this.mTextInput;
        if (editText2 != null) {
            editText2.addTextChangedListener(new c());
        }
    }

    public final void Ac(boolean z16) {
        this.isSubtitleEditMode = z16;
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f94845dd;
    }

    public final void Bc(boolean z16) {
        this.isSubtitleMode = z16;
    }

    public void Cb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mKeyboardStateListener = new d();
        Ab(rootView);
    }

    public final void Cc() {
        if (this.isSubtitleEditMode) {
            ImageView imageView = this.mTextConfirm;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.m3u);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mTextConfirm;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.oqa);
        }
    }

    @Override // o73.a
    public void D3() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.mobileqq.wink.editor.view.e eVar = new com.tencent.mobileqq.wink.editor.view.e(context);
        this.winkEditorChangeInputLoadingDialog = eVar;
        eVar.b();
        com.tencent.mobileqq.wink.editor.view.e eVar2 = this.winkEditorChangeInputLoadingDialog;
        if (eVar2 != null) {
            eVar2.d();
        }
    }

    public void Fb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorTextMenuPart.Gb(WinkEditorTextMenuPart.this, view);
            }
        };
        this.mMenuLayout = (LinearLayout) rootView.findViewById(R.id.z3e);
        TextView textView = (TextView) rootView.findViewById(R.id.ybm);
        ImageView imageView = null;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        } else {
            textView = null;
        }
        this.mKeyboardTv = textView;
        Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type android.view.View");
        eb(textView, "keyboard");
        TextView textView2 = (TextView) rootView.findViewById(R.id.f94975dq);
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        } else {
            textView2 = null;
        }
        this.mTextStyleTv = textView2;
        Intrinsics.checkNotNull(textView2, "null cannot be cast to non-null type android.view.View");
        eb(textView2, "style");
        TextView textView3 = (TextView) rootView.findViewById(R.id.f94875dg);
        if (textView3 != null) {
            textView3.setOnClickListener(onClickListener);
        } else {
            textView3 = null;
        }
        this.mTextPatternTv = textView3;
        Intrinsics.checkNotNull(textView3, "null cannot be cast to non-null type android.view.View");
        eb(textView3, "huazi");
        TextView textView4 = (TextView) rootView.findViewById(R.id.f94755d5);
        if (textView4 != null) {
            textView4.setOnClickListener(onClickListener);
        } else {
            textView4 = null;
        }
        this.mTextDecorTv = textView4;
        Intrinsics.checkNotNull(textView4, "null cannot be cast to non-null type android.view.View");
        eb(textView4, "decorate");
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.f164882u45);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTextMenuPart.Hb(WinkEditorTextMenuPart.this, view);
                }
            });
            imageView = imageView2;
        }
        this.mTextConfirm = imageView;
        this.mBottomSwitchLayout = (LinearLayout) rootView.findViewById(R.id.f166090ed2);
        rootView.findViewById(R.id.tld).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorTextMenuPart.Ib(WinkEditorTextMenuPart.this, view);
            }
        });
    }

    public void Gc(@Nullable String categoryId) {
        boolean z16;
        ms.a.a(this.TAG, "switchCategory " + categoryId);
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = this.mKeyboardStateHelper;
        if (winkSoftKeyboardStateHelper != null) {
            z16 = winkSoftKeyboardStateHelper.k();
        } else {
            z16 = false;
        }
        if (categoryId != null) {
            switch (categoryId.hashCode()) {
                case -921884268:
                    if (categoryId.equals("CATEGORY_TEXT_DECOR")) {
                        nc(false);
                        if (!z16) {
                            Dc(false);
                            Nc(this.mTextPatternTv, false);
                            Nc(this.mTextDecorTv, true);
                            RecyclerView recyclerView = this.mContentRecyclerView;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case -907563552:
                    if (categoryId.equals("CATEGORY_TEXT_STYLE")) {
                        nc(false);
                        if (!z16) {
                            Dc(true);
                            Nc(this.mTextPatternTv, false);
                            Nc(this.mTextDecorTv, false);
                            RecyclerView recyclerView2 = this.mContentRecyclerView;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 793913343:
                    if (categoryId.equals("CATEGORY_TEXT_PATTERN")) {
                        nc(false);
                        if (!z16) {
                            Dc(false);
                            Nc(this.mTextPatternTv, true);
                            Nc(this.mTextDecorTv, false);
                            RecyclerView recyclerView3 = this.mContentRecyclerView;
                            if (recyclerView3 != null) {
                                recyclerView3.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 910730760:
                    if (categoryId.equals("CATEGORY_KEYBOARD")) {
                        nc(true);
                        Dc(false);
                        Nc(this.mTextPatternTv, false);
                        Nc(this.mTextDecorTv, false);
                        RecyclerView recyclerView4 = this.mContentRecyclerView;
                        if (recyclerView4 != null) {
                            recyclerView4.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        com.tencent.mobileqq.wink.editor.sticker.text.f fVar = this.mTextFancyContentAdapter;
        if (fVar != null) {
            fVar.g0(editMode);
        }
    }

    public void Jb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (!G9().getIsFromZShow() && !G9().getIsFromQzoneText()) {
            this.ttsLayout = (LinearLayout) rootView.findViewById(R.id.f1041862m);
            this.ttsIcon = (ImageView) rootView.findViewById(R.id.f1042362r);
            this.ttsTextView = (TextView) rootView.findViewById(R.id.f10432630);
            LinearLayout linearLayout = this.ttsLayout;
            if (linearLayout != null) {
                jc(linearLayout);
            }
            LinearLayout linearLayout2 = this.ttsLayout;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WinkEditorTextMenuPart.Kb(WinkEditorTextMenuPart.this, view);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        Unit unit;
        int i3;
        TextView textView;
        String string;
        dr H9;
        super.L9(args);
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = new WinkSoftKeyboardStateHelper(getPartRootView());
        WinkSoftKeyboardStateHelper.a aVar = this.mKeyboardStateListener;
        if (aVar != null) {
            winkSoftKeyboardStateHelper.i(aVar);
        }
        this.mKeyboardStateHelper = winkSoftKeyboardStateHelper;
        qb().E2(this.saveTextColor);
        qb().z2(this.saveTextUnderlayType);
        qb().p2(this.isSubtitleMode, false);
        WinkEditorViewModel.EditMode editMode = G9().getEditMode();
        WinkEditorViewModel.EditMode editMode2 = WinkEditorViewModel.EditMode.Video;
        if (editMode == editMode2 && (H9 = H9()) != null) {
            this.isPlayingWhenShow = H9.isPlaying();
            H9.pause();
        }
        ms.a.f(this.TAG, "onShow");
        if (args != null && (string = args.getString("ARGS_BACK_TO_MENU_TYPE")) != null) {
            this.backToMenuType = MenuType.valueOf(string);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.backToMenuType = null;
        }
        if (args != null) {
            i3 = args.getInt(EmotionConstants.DISPLAY_TYPE);
        } else {
            i3 = 0;
        }
        this.displayType = i3;
        int i16 = 8;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    TextView textView2 = this.mTextPatternTv;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    if (!this.isSubtitleMode && (textView = this.mTextDecorTv) != null) {
                        textView.setVisibility(0);
                    }
                    LinearLayout linearLayout = this.ttsLayout;
                    if (linearLayout != null) {
                        if (!G9().getIsFromZShow() && !G9().getIsFromQzoneText() && !this.isSubtitleMode && G9().getEditMode() == editMode2) {
                            i16 = 0;
                        }
                        linearLayout.setVisibility(i16);
                    }
                    Group group = this.textBgGroup;
                    if (group != null) {
                        group.setVisibility(0);
                    }
                    Ya(false);
                    return;
                }
                View partRootView = getPartRootView();
                if (partRootView != null) {
                    partRootView.bringToFront();
                }
                LinearLayout linearLayout2 = this.mBottomSwitchLayout;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                LinearLayout linearLayout3 = this.ttsLayout;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                TextMenuBgView textMenuBgView = this.textMenuBgView;
                if (textMenuBgView != null) {
                    textMenuBgView.l(true, R.color.ckx, new Function0<Bitmap>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart$onShow$6
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final Bitmap invoke() {
                            return WinkEditorTextMenuPart.this.gb();
                        }
                    });
                    return;
                }
                return;
            }
            TextView textView3 = this.mTextPatternTv;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.mTextDecorTv;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            Group group2 = this.textBgGroup;
            if (group2 != null) {
                group2.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.ttsLayout;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            TextMenuBgView textMenuBgView2 = this.textMenuBgView;
            if (textMenuBgView2 != null) {
                textMenuBgView2.l(true, R.color.ckx, new Function0<Bitmap>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart$onShow$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Bitmap invoke() {
                        return WinkEditorTextMenuPart.this.gb();
                    }
                });
                return;
            }
            return;
        }
        TextView textView5 = this.mTextPatternTv;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        TextView textView6 = this.mTextDecorTv;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        Group group3 = this.textBgGroup;
        if (group3 != null) {
            group3.setVisibility(8);
        }
        LinearLayout linearLayout5 = this.ttsLayout;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        Ya(true);
    }

    public void Pc(@Nullable PAGFile materialPagFile, @Nullable PAGView mTextPagView, @NotNull final MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (materialPagFile != null && mTextPagView != null) {
            PAGText textData = materialPagFile.getTextData(0);
            if (textData == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(textData, "pagFile.getTextData(0) ?: return");
            Rc(textData, material);
            materialPagFile.replaceText(0, textData);
            mTextPagView.setComposition(materialPagFile);
            Handler mainHandler = getMainHandler();
            if (mainHandler != null) {
                mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorTextMenuPart.Qc(WinkEditorTextMenuPart.this, material);
                    }
                });
            }
            this.pagViewWidth = mTextPagView.getWidth();
            this.pagViewCenter.x = mTextPagView.getWidth() / 2.0f;
            this.pagViewCenter.y = mTextPagView.getHeight() / 2.0f;
            int numChildren = materialPagFile.numChildren();
            boolean z16 = true;
            if (numChildren != 1) {
                z16 = false;
            }
            this.plainText = z16;
            if (z16) {
                for (int i3 = 0; i3 < numChildren; i3++) {
                    PAGLayer layerAt = materialPagFile.getLayerAt(i3);
                    String str = this.TAG;
                    Intrinsics.checkNotNull(layerAt);
                    ms.a.c(str, "layer name [" + i3 + "] = " + layerAt.layerName());
                    RectF bounds = layerAt.getBounds();
                    this.finalTextBounds = bounds;
                    ms.a.a(this.TAG, "bounds before concat = " + bounds + "  height = " + materialPagFile.height());
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    while (layerAt != null) {
                        matrix.postConcat(layerAt.getTotalMatrix());
                        layerAt = layerAt.parent();
                    }
                    matrix.mapRect(this.finalTextBounds);
                    ms.a.c(this.TAG, "bounds = " + this.finalTextBounds + " ,height = " + materialPagFile.height());
                }
            }
        }
    }

    public void Rc(@NotNull PAGText pagText, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(pagText, "pagText");
        Intrinsics.checkNotNullParameter(material, "material");
        pagText.text = com.tencent.mobileqq.wink.editor.sticker.m.l(material);
        pagText.fillColor = com.tencent.mobileqq.wink.editor.sticker.m.F(material);
        pagText.fontStyle = com.tencent.mobileqq.wink.editor.sticker.m.s(material);
        pagText.fontFamily = com.tencent.mobileqq.wink.editor.sticker.m.o(material);
        Hc(pagText, material);
        Tc(pagText, material);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    /* renamed from: X9 */
    protected boolean getAutoAnimate() {
        return false;
    }

    public void Ya(boolean isTemplateText) {
        int i3;
        TextMenuBgView textMenuBgView = this.textMenuBgView;
        if (textMenuBgView != null) {
            if (isTemplateText) {
                i3 = R.color.ckv;
            } else {
                i3 = R.color.bdd;
            }
            textMenuBgView.l(isTemplateText, i3, new Function0<Bitmap>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart$adjustMask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Bitmap invoke() {
                    return WinkEditorTextMenuPart.this.gb();
                }
            });
        }
    }

    public final void ab() {
        String str;
        Editable text;
        EditText editText = this.mTextInput;
        if (editText != null && (text = editText.getText()) != null) {
            str = text.toString();
        } else {
            str = null;
        }
        this.inputWords = str;
        kc();
        cb(this, true, 0, 2, null);
        ImageView imageView = this.mTextConfirm;
        Intrinsics.checkNotNull(imageView, "null cannot be cast to non-null type android.view.View");
        ic(imageView);
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(7, 100));
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.TEXT;
    }

    public void bb(boolean isUpdated, int completeType) {
        int i3;
        List<MetaMaterial> B;
        List<MetaMaterial> B2;
        Editable editable;
        boolean z16;
        Editable text;
        boolean z17 = true;
        if (!this.isSubtitleMode && isUpdated) {
            EditText editText = this.mTextInput;
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            if (editable != null) {
                EditText editText2 = this.mTextInput;
                if (editText2 != null && (text = editText2.getText()) != null && text.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
            } else {
                return;
            }
        }
        EditText editText3 = this.mTextInput;
        if (editText3 != null) {
            com.tencent.videocut.utils.j.f384247a.a(editText3);
        }
        qb().Q1(isUpdated, this.plainText, this.pagViewWidth, this.pagViewCenter, this.finalTextBounds, this.isSubtitleEditMode, completeType);
        if (isUpdated) {
            this.saveTextUnderlayType = qb().f322039c0;
            g gVar = this.mTextFontContentAdapter;
            if (gVar == null || (B2 = gVar.B()) == null || B2.isEmpty()) {
                z17 = false;
            }
            if (z17 && qb().f322037a0 >= 0) {
                int i16 = qb().f322037a0;
                g gVar2 = this.mTextFontContentAdapter;
                if (gVar2 != null && (B = gVar2.B()) != null) {
                    i3 = B.size();
                } else {
                    i3 = -1;
                }
                if (i16 < i3) {
                    g gVar3 = this.mTextFontContentAdapter;
                    Intrinsics.checkNotNull(gVar3);
                    MetaMaterial metaMaterial = gVar3.B().get(qb().f322037a0);
                    g gVar4 = this.mTextFontContentAdapter;
                    Intrinsics.checkNotNull(gVar4);
                    gVar4.P(qb().f322037a0, metaMaterial);
                }
            }
            if (qb() != null && qb().f322038b0 > -1) {
                Integer num = bb.f322034r0.get(qb().f322038b0);
                Intrinsics.checkNotNullExpressionValue(num, "WinkEditorTextViewModel.\u2026wModel.curTextColorIndex]");
                this.saveTextColor = num.intValue();
            } else {
                this.saveTextColor = qb().c2();
            }
        } else {
            qb().z2(0);
        }
        if (this.isSubtitleMode) {
            WinkEditorViewModel.v5(G9(), MenuType.SUBTITLE, null, 2, null);
        } else if (ba() == MenuType.TEMPLATE_TEXT) {
            if (G9().u4()) {
                x9();
            } else {
                WinkEditorViewModel G9 = G9();
                MenuType menuType = MenuType.TEMPLATE_TEXT_LIST;
                Bundle bundle = new Bundle();
                bundle.putString("selected_sticker_uid", qb().b2().id);
                Unit unit = Unit.INSTANCE;
                G9.u5(menuType, bundle);
            }
        } else {
            x9();
        }
        EditText editText4 = this.mTextInput;
        if (editText4 != null) {
            editText4.setText("");
        }
        Cc();
    }

    @NotNull
    public bb cc() {
        ViewModel viewModel = getViewModel(bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorTextViewModel::class.java)");
        return (bb) viewModel;
    }

    @NotNull
    protected ApplyMaterialTask fb() {
        if (this.mApplyMaterialTask == null) {
            this.mApplyMaterialTask = new b();
        }
        ApplyMaterialTask applyMaterialTask = this.mApplyMaterialTask;
        Intrinsics.checkNotNull(applyMaterialTask);
        return applyMaterialTask;
    }

    @Nullable
    public Bitmap gb() {
        WinkVideoTavCut winkVideoTavCut;
        View view;
        TextureView textureView;
        FrameLayout currentPlayerViewContainer;
        dr H9 = H9();
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null && (currentPlayerViewContainer = winkVideoTavCut.getCurrentPlayerViewContainer()) != null) {
            view = currentPlayerViewContainer.getChildAt(0);
        } else {
            view = null;
        }
        if (view instanceof TextureView) {
            textureView = (TextureView) view;
        } else {
            textureView = null;
        }
        if (textureView == null) {
            return null;
        }
        return textureView.getBitmap();
    }

    /* renamed from: gc, reason: from getter */
    public final boolean getIsSubtitleMode() {
        return this.isSubtitleMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: hb, reason: from getter */
    public final ApplyMaterialTask getMApplyMaterialTask() {
        return this.mApplyMaterialTask;
    }

    public void hc() {
        int i3;
        qb().N1("CATEGORY_KEYBOARD");
        EditText editText = this.mTextInput;
        if (editText != null) {
            if (editText != null) {
                i3 = editText.length();
            } else {
                i3 = 0;
            }
            editText.setSelection(i3);
        }
    }

    @Nullable
    /* renamed from: ib, reason: from getter */
    protected final LinearLayout getMBottomSwitchLayout() {
        return this.mBottomSwitchLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ms.a.f(this.TAG, "initAfterInflation");
        this.contentheight = com.tencent.videocut.utils.e.f384236a.a(380.0f);
        this.mColorSelectorIndicatorOffset = com.tencent.mobileqq.util.x.c(getContext(), 2.0f);
        this.mCheckedCategoryIndicator = ContextCompat.getDrawable(getContext(), R.drawable.kvw);
        this.mUncheckedCategoryIndicator = ContextCompat.getDrawable(getContext(), R.drawable.kvx);
        this.mContentLayout = (FrameLayout) rootView.findViewById(R.id.leb);
        Db();
        wb();
        Cb(rootView);
        Ob(rootView);
        Fb(rootView);
        Lb(rootView);
        Pb();
        Jb(rootView);
        ms.a.f(this.TAG, "initAfterInflation end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkEditorViewModel jb() {
        WinkEditorViewModel winkEditorViewModel = this.mEditorViewModel;
        if (winkEditorViewModel != null) {
            return winkEditorViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEditorViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: kb, reason: from getter */
    public final TextView getMKeyboardTv() {
        return this.mKeyboardTv;
    }

    public final void kc() {
        int i3 = qb().f322039c0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TRANSLUCENCE, "1");
                    }
                } else {
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_PURE_COLOR, "1");
                }
            } else {
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_BORDER, "1");
            }
        } else {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_NULL, "1");
        }
        String m26 = qb().m2();
        if (m26 != null) {
            int hashCode = m26.hashCode();
            if (hashCode != 99628835) {
                if (hashCode != 109780401) {
                    if (hashCode == 571222797 && m26.equals("decorate")) {
                        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_DECORATE, "1");
                    }
                } else if (m26.equals("style")) {
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_STYLE, "1");
                }
            } else if (m26.equals("huazi")) {
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_HUAZI, "1");
            }
        }
        if (this.isSubtitleMode) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_SUBTITLE, "1");
        } else {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TEXT, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: lb, reason: from getter */
    public final ImageView getMTextConfirm() {
        return this.mTextConfirm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: mb, reason: from getter */
    public final TextView getMTextDecorTv() {
        return this.mTextDecorTv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: nb, reason: from getter */
    public final EditText getMTextInput() {
        return this.mTextInput;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: ob, reason: from getter */
    public final TextView getMTextPatternTv() {
        return this.mTextPatternTv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void oc(@Nullable ApplyMaterialTask applyMaterialTask) {
        this.mApplyMaterialTask = applyMaterialTask;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecyclerView recyclerView = this.mContentRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), Za()));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        dr H9;
        this.currentMetaMaterial = null;
        super.onDismiss();
        if (G9().getEditMode() == WinkEditorViewModel.EditMode.Video && !this.isSubtitleEditMode && this.displayType != 1 && this.isPlayingWhenShow && (H9 = H9()) != null) {
            H9.play();
        }
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = this.mKeyboardStateHelper;
        if (winkSoftKeyboardStateHelper != null) {
            winkSoftKeyboardStateHelper.o();
        }
        this.mKeyboardStateHelper = null;
        nc(false);
        TextMenuBgView textMenuBgView = this.textMenuBgView;
        if (textMenuBgView != null) {
            textMenuBgView.k();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ms.a.a(this.TAG, "isSubtitleMode: " + this.isSubtitleMode);
        Wb();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        TextMenuBgView textMenuBgView = this.textMenuBgView;
        if (textMenuBgView != null) {
            textMenuBgView.j();
        }
        super.onPartDestroy(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: pb, reason: from getter */
    public final TextView getMTextStyleTv() {
        return this.mTextStyleTv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final bb qb() {
        bb bbVar = this.mTextViewModel;
        if (bbVar != null) {
            return bbVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTextViewModel");
        return null;
    }

    protected final void qc(@NotNull WinkEditorViewModel winkEditorViewModel) {
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "<set-?>");
        this.mEditorViewModel = winkEditorViewModel;
    }

    public PAGFile rb(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        return com.tencent.mobileqq.wink.utils.x.b().c(com.tencent.mobileqq.wink.editor.sticker.m.y(material));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void rc(@Nullable TextView textView) {
        this.mKeyboardTv = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String sb() {
        if (ec()) {
            return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_PIC_PAGE;
        }
        return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_VIDEO_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sc(@Nullable LinearLayout linearLayout) {
        this.mMenuLayout = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ta(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        List listOf;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        AnimatorSet animatorSet = new AnimatorSet();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ObjectAnimator[]{ObjectAnimator.ofFloat(this.mTextPagView, (Property<PAGView, Float>) ViewAnimator.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.textMenuBgView, (Property<TextMenuBgView, Float>) ViewAnimator.ALPHA, 1.0f, 0.0f)});
        animatorSet.playTogether(listOf);
        animatorSet.setDuration(200L);
        animatorSet.addListener(new e(onStartAction, onEndAction));
        animatorSet.start();
        if (getSlideDownAnimation() != null && (linearLayout = this.mMenuLayout) != null) {
            linearLayout.startAnimation(getSlideDownAnimation());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: tb, reason: from getter */
    public final TextMenuBgView getTextMenuBgView() {
        return this.textMenuBgView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void tc(@Nullable ImageView imageView) {
        this.mTextConfirm = imageView;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    protected void ua(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        List listOf;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        if (this.mTextPagView != null && this.textMenuBgView != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ObjectAnimator[]{ObjectAnimator.ofFloat(this.mTextPagView, (Property<PAGView, Float>) ViewAnimator.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.textMenuBgView, (Property<TextMenuBgView, Float>) ViewAnimator.ALPHA, 0.0f, 1.0f)});
            animatorSet.playTogether(listOf);
            animatorSet.setDuration(200L);
            animatorSet.addListener(new f(onStartAction, onEndAction));
            animatorSet.start();
            if (getSlideUpAnimation() != null && (linearLayout = this.mMenuLayout) != null) {
                linearLayout.startAnimation(getSlideUpAnimation());
            }
        }
    }

    public void ub(@NotNull Pair<String, Boolean> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Object obj = pair.second;
        Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
        boolean z16 = true;
        if (((Boolean) obj).booleanValue()) {
            QQToast.makeText(getContext(), getContext().getString(R.string.f1646426d, Integer.valueOf(((String) pair.first).length())), 0).show();
            EditText editText = this.mTextInput;
            if (editText != null) {
                editText.setText((CharSequence) pair.first);
            }
            EditText editText2 = this.mTextInput;
            if (editText2 != null) {
                editText2.setSelection(((String) pair.first).length());
            }
        }
        Object obj2 = pair.first;
        Intrinsics.checkNotNullExpressionValue(obj2, "pair.first");
        if (((CharSequence) obj2).length() <= 0) {
            z16 = false;
        }
        if (!z16 && !this.isSubtitleEditMode) {
            ImageView imageView = this.mTextConfirm;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.oqa);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mTextConfirm;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.m3u);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void uc(@Nullable TextView textView) {
        this.mTextDecorTv = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void vc(@Nullable EditText editText) {
        this.mTextInput = editText;
    }

    @Override // o73.a
    public void w3() {
        com.tencent.mobileqq.wink.editor.view.e eVar = this.winkEditorChangeInputLoadingDialog;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void wb() {
        qb().e2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.xb(WinkEditorTextMenuPart.this, (WinkStickerModel) obj);
            }
        });
        qb().S1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPart.yb(WinkEditorTextMenuPart.this, (MetaMaterial) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void wc(@Nullable TextView textView) {
        this.mTextPatternTv = textView;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void x9() {
        MenuType menuType = this.backToMenuType;
        Unit unit = null;
        if (menuType != null) {
            WinkEditorViewModel.v5(G9(), menuType, null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.x9();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void xc(@Nullable TextView textView) {
        this.mTextStyleTv = textView;
    }

    protected final void yc(@NotNull bb bbVar) {
        Intrinsics.checkNotNullParameter(bbVar, "<set-?>");
        this.mTextViewModel = bbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zc(int i3) {
        this.saveTextUnderlayType = i3;
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (s16 != null) {
                WinkEditorTextMenuPart winkEditorTextMenuPart = WinkEditorTextMenuPart.this;
                winkEditorTextMenuPart.qb().L1(s16.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
