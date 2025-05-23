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
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.util.Property;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
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
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import com.tencent.videocut.model.TextItem;
import com.tenpay.sdk.util.UinConfigManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u00a2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00fe\u00012\u00020\u00012\u00020\u0002:\u0002\u00ff\u0001B\t\u00a2\u0006\u0006\b\u00fc\u0001\u0010\u00fd\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u0003H\u0003J\b\u0010\"\u001a\u00020\u0003H\u0002J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0$2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0012H\u0002J\u001a\u0010-\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\u0012H\u0002J\u0010\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0007H\u0002J\u0010\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u00020%H\u0002J\b\u00104\u001a\u00020\u0003H\u0002J\b\u00105\u001a\u00020\u0003H\u0002J\u0018\u00108\u001a\u00020\u00032\u0006\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u00020\nH\u0016J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0003H\u0016J\u0010\u0010>\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0014J$\u0010B\u001a\u00020\u00032\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030?2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030?H\u0014J\b\u0010C\u001a\u00020\u0003H\u0016J\b\u0010D\u001a\u00020\u0003H\u0016J\u0012\u0010G\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u0012H\u0016J\n\u0010K\u001a\u0004\u0018\u00010JH\u0016J$\u0010L\u001a\u00020\u00032\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030?2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030?H\u0014J\b\u0010M\u001a\u00020\u0003H\u0016J\b\u0010N\u001a\u00020\u0003H\u0016J\u0010\u0010Q\u001a\u00020\u00032\u0006\u0010P\u001a\u00020OH\u0016J\u0012\u0010T\u001a\u00020\u00032\b\u0010S\u001a\u0004\u0018\u00010RH\u0016J\b\u0010V\u001a\u00020UH\u0016J\u001c\u0010X\u001a\u00020\u00032\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00120$H\u0016J\b\u0010Y\u001a\u00020\u0003H\u0016J\u0018\u0010[\u001a\n Z*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\\\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010_\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010^\u001a\u0004\u0018\u00010]2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010`\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010a\u001a\u00020\u0003J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010e\u001a\u00020\u00032\b\u0010d\u001a\u0004\u0018\u00010%H\u0016J$\u0010i\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u00122\b\b\u0002\u0010g\u001a\u00020\u00122\b\b\u0002\u0010h\u001a\u00020\nH\u0016J\u0006\u0010j\u001a\u00020\u0003J\u0010\u0010m\u001a\u00020\u00032\u0006\u0010l\u001a\u00020kH\u0016J\b\u0010n\u001a\u00020\u0003H\u0016J\b\u0010o\u001a\u00020\u0003H\u0016J\b\u0010p\u001a\u00020%H\u0004R\u0016\u0010s\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010rR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u0088\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0088\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0084\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\br\u0010\u0088\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0088\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0088\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u0088\u0001R\u001c\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u001c\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001c\u0010\u00aa\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R\u001c\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00ab\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u0018\u0010\u00b0\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00af\u0001\u0010wR\u001c\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00b3\u0001R\u001c\u0010\u00b6\u0001\u001a\u0005\u0018\u00010\u00b1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00b3\u0001R\u001c\u0010\u00ba\u0001\u001a\u0005\u0018\u00010\u00b7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u001b\u0010\u00bc\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u0080\u0001R)\u0010\u00c3\u0001\u001a\u00020U8\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u00bd\u0001\u0010\u00be\u0001\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001\"\u0006\b\u00c1\u0001\u0010\u00c2\u0001R*\u0010\u00cb\u0001\u001a\u00030\u00c4\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0018\n\u0006\b\u00c5\u0001\u0010\u00c6\u0001\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001\"\u0006\b\u00c9\u0001\u0010\u00ca\u0001R,\u0010\u00d3\u0001\u001a\u0005\u0018\u00010\u00cc\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00cd\u0001\u0010\u00ce\u0001\u001a\u0006\b\u00cf\u0001\u0010\u00d0\u0001\"\u0006\b\u00d1\u0001\u0010\u00d2\u0001R\u001c\u0010\u00d7\u0001\u001a\u0005\u0018\u00010\u00d4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001R\u0018\u0010\u00db\u0001\u001a\u00030\u00d8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d9\u0001\u0010\u00da\u0001R\u0018\u0010\u00dd\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00dc\u0001\u0010wR\u0018\u0010\u00df\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00de\u0001\u0010wR\u0018\u0010\u00e1\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e0\u0001\u0010rR\u0018\u0010\u00e3\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e2\u0001\u0010wR\u0018\u0010\u00e5\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e4\u0001\u0010wR\u0018\u0010\u00e7\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e6\u0001\u0010wR\u001b\u0010\u00ea\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00e9\u0001R\u001b\u0010\u00ed\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00eb\u0001\u0010\u00ec\u0001R\u001c\u0010\u00f1\u0001\u001a\u0005\u0018\u00010\u00ee\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ef\u0001\u0010\u00f0\u0001R\u001b\u0010\u00f4\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f2\u0001\u0010\u00f3\u0001R\u0018\u0010\u00f6\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00f5\u0001\u0010rR\u0017\u0010\u00f9\u0001\u001a\u00020\u00128TX\u0094\u0004\u00a2\u0006\b\u001a\u0006\b\u00f7\u0001\u0010\u00f8\u0001R\u0018\u0010\u00fb\u0001\u001a\u00030\u00cc\u00018TX\u0094\u0004\u00a2\u0006\b\u001a\u0006\b\u00fa\u0001\u0010\u00d0\u0001\u00a8\u0006\u0080\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lo73/a;", "", "ub", "nb", "Fb", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ab", "", "displayType", "Yb", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "kc", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "pagEffectData", "", "Mb", "Lorg/libpag/PAGFile;", "materialPagFile", "cc", "Lorg/libpag/PAGText;", "pagText", "Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContent;", "content", "bc", com.tencent.mobileqq.search.model.ac.f283467k0, "mc", "bilingual", "nc", "Rb", "Bb", "oc", "type", "Landroid/util/Pair;", "", "fb", "index", "gc", NodeProps.VISIBLE, "Sb", "categoryView", "checked", "ec", "Tb", "Nb", "view", "Pb", "id", "Wa", "Qb", "kb", "elementId", "isIMP", "bb", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "B9", "onInitView", "ob", "initAfterInflation", "Lkotlin/Function0;", "onStartAction", "onEndAction", "ua", Constants.BASE_IN_APP_NAME, "w3", "Landroid/os/Bundle;", "args", "L9", "isTemplateText", "Xa", "Landroid/graphics/Bitmap;", "eb", "ta", "onDismiss", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "Lb", "pair", "mb", "Ob", "kotlin.jvm.PlatformType", "jb", "jc", "Lorg/libpag/PAGView;", "mTextPagView", "hc", "wb", "Ya", "tb", "rb", "categoryId", "Zb", "isUpdated", "fromCancel", "completeType", "Za", "Xb", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "oa", "K9", "lb", "M", "Z", "isSubtitleMode", "N", "isSubtitleEditMode", "P", "I", "Lcom/tencent/mobileqq/wink/editor/sticker/text/TextMenuBgView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/sticker/text/TextMenuBgView;", "textMenuBgView", BdhLogUtil.LogTag.Tag_Req, "Lorg/libpag/PAGView;", "Landroid/widget/FrameLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/FrameLayout;", "mContentLayout", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "mTextConfirm", "Landroid/widget/LinearLayout;", "U", "Landroid/widget/LinearLayout;", "mMenuLayout", "V", "gb", "()Landroid/widget/LinearLayout;", "setMBottomSwitchLayout", "(Landroid/widget/LinearLayout;)V", "mBottomSwitchLayout", "W", "mSubstrateSel", "X", "mSubstrateSelText", "Landroid/widget/ImageView;", "Y", "Landroid/widget/ImageView;", "mSubstrateSelImage", "mColorSel", "a0", "mColorSelBG", "b0", "mFontSel", "c0", "mFontSelBG", "Landroid/widget/EditText;", "d0", "Landroid/widget/EditText;", "mTextInput", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;", "e0", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;", "mKeyboardStateHelper", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper$a;", "f0", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper$a;", "mKeyboardStateListener", "Lcom/tencent/mobileqq/wink/editor/sticker/text/h;", "g0", "Lcom/tencent/mobileqq/wink/editor/sticker/text/h;", "mTextFontContentAdapter", "h0", "mColorSelectorIndicatorOffset", "Landroid/support/v7/widget/RecyclerView;", "i0", "Landroid/support/v7/widget/RecyclerView;", "fontRecyclerView", "j0", "colorSelectorRecyclerView", "Lcom/tencent/mobileqq/wink/editor/sticker/text/b;", "k0", "Lcom/tencent/mobileqq/wink/editor/sticker/text/b;", "colorSelectorAdapter", "l0", "colorSelectorParent", "m0", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "ib", "()Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "Wb", "(Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;)V", "mTextViewModel", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "n0", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", UinConfigManager.KEY_HB, "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "Vb", "(Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;)V", "mEditorViewModel", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "o0", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "getMApplyMaterialTask", "()Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "setMApplyMaterialTask", "(Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;)V", "mApplyMaterialTask", "Landroid/graphics/RectF;", "p0", "Landroid/graphics/RectF;", "finalTextBounds", "Landroid/graphics/PointF;", "q0", "Landroid/graphics/PointF;", "pagViewCenter", "r0", "pagViewWidth", "s0", "contentheight", "t0", IMiniCardBeancurd.SIGN_PLAIN_TEXT, "u0", "saveTextUnderlayType", "v0", "saveTextColor", "w0", "saveFontIndex", "x0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "currentMetaMaterial", "y0", "Ljava/lang/String;", "inputWords", "Lcom/tencent/mobileqq/wink/editor/view/e;", "z0", "Lcom/tencent/mobileqq/wink/editor/view/e;", "winkEditorChangeInputLoadingDialog", "A0", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "backToMenuType", "B0", "isPlayingWhenShow", "X9", "()Z", "autoAnimate", "cb", "applyMaterialTask", "<init>", "()V", "C0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkEditorTextMenuPartV2 extends WinkEditorMenuPart implements o73.a {

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private MenuType backToMenuType;

    /* renamed from: B0, reason: from kotlin metadata */
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
    private TextView mTextConfirm;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mMenuLayout;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mBottomSwitchLayout;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mSubstrateSel;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TextView mSubstrateSelText;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private ImageView mSubstrateSelImage;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mColorSel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mColorSelBG;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mFontSel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mFontSelBG;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mTextInput;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSoftKeyboardStateHelper mKeyboardStateHelper;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSoftKeyboardStateHelper.a mKeyboardStateListener;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h mTextFontContentAdapter;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int mColorSelectorIndicatorOffset;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView fontRecyclerView;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView colorSelectorRecyclerView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.sticker.text.b colorSelectorAdapter;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout colorSelectorParent;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    protected bb mTextViewModel;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    protected WinkEditorViewModel mEditorViewModel;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ApplyMaterialTask mApplyMaterialTask;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RectF finalTextBounds;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private int pagViewWidth;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private int contentheight;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private int saveTextUnderlayType;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private int saveFontIndex;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaMaterial currentMetaMaterial;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String inputWords;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.view.e winkEditorChangeInputLoadingDialog;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF pagViewCenter = new PointF();

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private boolean plainText = true;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private int saveTextColor = Color.parseColor("#EFEFEF");

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2$b", "Lcom/tencent/mobileqq/wink/flow/a;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "", "F1", "g", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
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
            Intrinsics.checkNotNullParameter(material, "material");
            WinkEditorTextMenuPartV2.this.ib().M1(material);
            WinkEditorTextMenuPartV2.this.saveFontIndex = position;
            String str = WinkEditorTextMenuPartV2.this.G9().getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
            if (str != null) {
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2$d", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper$a;", "", "onSoftKeyboardClosed", "", "keyboardHeightInPx", "onSoftKeyboardOpened", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
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
            WinkEditorTextMenuPartV2 winkEditorTextMenuPartV2 = WinkEditorTextMenuPartV2.this;
            String str = winkEditorTextMenuPartV2.TAG;
            WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = winkEditorTextMenuPartV2.mKeyboardStateHelper;
            if (winkSoftKeyboardStateHelper != null) {
                bool = Boolean.valueOf(winkSoftKeyboardStateHelper.k());
            } else {
                bool = null;
            }
            w53.b.a(str, "onSoftKeyboardHeightChanged keyboardHeightInPx:" + keyboardHeightInPx + " keyboardOpened:" + bool);
            WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper2 = WinkEditorTextMenuPartV2.this.mKeyboardStateHelper;
            if (winkSoftKeyboardStateHelper2 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                if (WinkEditorTextMenuPartV2.this.displayType == 4) {
                    LinearLayout mBottomSwitchLayout = WinkEditorTextMenuPartV2.this.getMBottomSwitchLayout();
                    if (mBottomSwitchLayout != null) {
                        mBottomSwitchLayout.setVisibility(8);
                    }
                    FrameLayout frameLayout = WinkEditorTextMenuPartV2.this.mContentLayout;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                }
                WinkEditorTextMenuPartV2.this.ib().N1("CATEGORY_KEYBOARD");
                FrameLayout frameLayout2 = WinkEditorTextMenuPartV2.this.mContentLayout;
                Intrinsics.checkNotNull(frameLayout2);
                if (frameLayout2.getLayoutParams().height != keyboardHeightInPx) {
                    FrameLayout frameLayout3 = WinkEditorTextMenuPartV2.this.mContentLayout;
                    Intrinsics.checkNotNull(frameLayout3);
                    frameLayout3.getLayoutParams().height = keyboardHeightInPx;
                    FrameLayout frameLayout4 = WinkEditorTextMenuPartV2.this.mContentLayout;
                    Intrinsics.checkNotNull(frameLayout4);
                    frameLayout4.requestLayout();
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardClosed() {
            w53.b.a(WinkEditorTextMenuPartV2.this.TAG, "onSoftKeyboardClosed");
            if (WinkEditorTextMenuPartV2.this.displayType == 4) {
                FrameLayout frameLayout = WinkEditorTextMenuPartV2.this.mContentLayout;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                LinearLayout mBottomSwitchLayout = WinkEditorTextMenuPartV2.this.getMBottomSwitchLayout();
                if (mBottomSwitchLayout != null) {
                    mBottomSwitchLayout.setVisibility(8);
                    return;
                }
                return;
            }
            WinkEditorTextMenuPartV2.this.ib().U1().getValue();
            WinkEditorTextMenuPartV2.ab(WinkEditorTextMenuPartV2.this, false, true, 0, 4, null);
            FrameLayout frameLayout2 = WinkEditorTextMenuPartV2.this.mContentLayout;
            Intrinsics.checkNotNull(frameLayout2);
            if (frameLayout2.getLayoutParams().height != WinkEditorTextMenuPartV2.this.contentheight && WinkEditorTextMenuPartV2.this.currentMetaMaterial != null) {
                FrameLayout frameLayout3 = WinkEditorTextMenuPartV2.this.mContentLayout;
                Intrinsics.checkNotNull(frameLayout3);
                frameLayout3.getLayoutParams().height = WinkEditorTextMenuPartV2.this.contentheight;
                FrameLayout frameLayout4 = WinkEditorTextMenuPartV2.this.mContentLayout;
                Intrinsics.checkNotNull(frameLayout4);
                frameLayout4.requestLayout();
            }
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            w53.b.a(WinkEditorTextMenuPartV2.this.TAG, "onSoftKeyboardOpened keyboardHeightInPx:" + keyboardHeightInPx);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321988d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321989e;

        e(Function0<Unit> function0, Function0<Unit> function02) {
            this.f321988d = function0;
            this.f321989e = function02;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f321989e.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            this.f321988d.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321990d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321991e;

        f(Function0<Unit> function0, Function0<Unit> function02) {
            this.f321990d = function0;
            this.f321991e = function02;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f321991e.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            this.f321990d.invoke();
        }
    }

    private final void Ab(View rootView) {
        TextMenuBgView textMenuBgView = (TextMenuBgView) rootView.findViewById(R.id.f94835dc);
        this.textMenuBgView = textMenuBgView;
        if (textMenuBgView != null) {
            textMenuBgView.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPartV2$initTextPagView$1
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
                    WinkEditorTextMenuPartV2.this.Ob();
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

    @SuppressLint({"NotifyDataSetChanged"})
    private final void Bb() {
        RecyclerView.ViewHolder viewHolder;
        View view;
        ms.a.a(this.TAG, "initTextStyleTab");
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView);
        RecyclerView recyclerView = (RecyclerView) partRootView.findViewById(R.id.f94965dp);
        this.fontRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
        RecyclerView recyclerView2 = this.fontRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        h hVar = new h(getContext(), G9().getEditMode());
        hVar.S(cb());
        this.mTextFontContentAdapter = hVar;
        RecyclerView recyclerView3 = this.fontRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(hVar);
        }
        RecyclerView recyclerView4 = this.fontRecyclerView;
        if (recyclerView4 != null) {
            viewHolder = recyclerView4.findViewHolderForAdapterPosition(this.saveFontIndex);
        } else {
            viewHolder = null;
        }
        if (viewHolder != null && (view = viewHolder.itemView) != null) {
            view.performClick();
        }
        RecyclerView recyclerView5 = this.fontRecyclerView;
        if (recyclerView5 != null) {
            recyclerView5.setVisibility(8);
        }
        ib().k2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.Cb(WinkEditorTextMenuPartV2.this, (List) obj);
            }
        });
        ib().j2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.Db(WinkEditorTextMenuPartV2.this, (Integer) obj);
            }
        });
        ib().l2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.Eb((Integer) obj);
            }
        });
        View partRootView2 = getPartRootView();
        Intrinsics.checkNotNull(partRootView2);
        this.colorSelectorParent = (FrameLayout) partRootView2.findViewById(R.id.u0s);
        View partRootView3 = getPartRootView();
        Intrinsics.checkNotNull(partRootView3);
        this.colorSelectorRecyclerView = (RecyclerView) partRootView3.findViewById(R.id.u0t);
        List<Integer> COLOR_SELECTOR_SET_V2 = bb.f322035s0;
        Intrinsics.checkNotNullExpressionValue(COLOR_SELECTOR_SET_V2, "COLOR_SELECTOR_SET_V2");
        com.tencent.mobileqq.wink.editor.sticker.text.b bVar = new com.tencent.mobileqq.wink.editor.sticker.text.b(COLOR_SELECTOR_SET_V2, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPartV2$initTextStyleTab$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                WinkEditorTextMenuPartV2.this.ib().P2(i3);
                WinkEditorTextMenuPartV2.this.saveTextColor = i3;
                WinkEditorTextMenuPartV2.this.gc(bb.f322035s0.indexOf(Integer.valueOf(i3)));
            }
        }, COLOR_SELECTOR_SET_V2.indexOf(Integer.valueOf(this.saveTextColor)));
        this.colorSelectorAdapter = bVar;
        RecyclerView recyclerView6 = this.colorSelectorRecyclerView;
        if (recyclerView6 != null) {
            recyclerView6.setAdapter(bVar);
        }
        RecyclerView recyclerView7 = this.colorSelectorRecyclerView;
        if (recyclerView7 != null) {
            recyclerView7.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cb(WinkEditorTextMenuPartV2 this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h hVar = this$0.mTextFontContentAdapter;
        if (hVar != null) {
            hVar.Y(list);
        }
        h hVar2 = this$0.mTextFontContentAdapter;
        if (hVar2 != null) {
            hVar2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Db(WinkEditorTextMenuPartV2 this$0, Integer num) {
        MetaMaterial metaMaterial;
        Object orNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.a(this$0.TAG, "textFontMaterialIndexLiveData " + num);
        h hVar = this$0.mTextFontContentAdapter;
        if (num != null && hVar != null) {
            int intValue = num.intValue();
            List<MetaMaterial> materials = hVar.B();
            if (materials != null) {
                Intrinsics.checkNotNullExpressionValue(materials, "materials");
                orNull = CollectionsKt___CollectionsKt.getOrNull(materials, intValue);
                metaMaterial = (MetaMaterial) orNull;
            } else {
                metaMaterial = null;
            }
            hVar.P(intValue, metaMaterial);
            hVar.a0(intValue);
        }
    }

    private final void Fb() {
        ViewModel viewModel = getViewModel(WinkEditorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorViewModel::class.java)");
        Vb((WinkEditorViewModel) viewModel);
        Wb(Lb());
        ib().q2();
        ib().X1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ba
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.Gb(WinkEditorTextMenuPartV2.this, (MetaMaterial) obj);
            }
        });
        ib().U1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.Hb(WinkEditorTextMenuPartV2.this, (String) obj);
            }
        });
        ib().g2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.Ib(WinkEditorTextMenuPartV2.this, ((Integer) obj).intValue());
            }
        });
        ib().f2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.Jb(WinkEditorTextMenuPartV2.this, (t73.a) obj);
            }
        });
        if (!this.isSubtitleMode) {
            ib().d2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ap
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorTextMenuPartV2.Kb(WinkEditorTextMenuPartV2.this, (Pair) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gb(WinkEditorTextMenuPartV2 this$0, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "material");
        this$0.currentMetaMaterial = material;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkEditorTextMenuPartV2$initTextViewModel$1$1$1(this$0, material, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hb(WinkEditorTextMenuPartV2 this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Zb(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ib(WinkEditorTextMenuPartV2 this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.a(this$0.TAG, "textColorIndexLiveData select " + i3);
        this$0.gc(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jb(WinkEditorTextMenuPartV2 this$0, t73.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair<String, Boolean> pair = (Pair) aVar.a();
        if (pair == null) {
            return;
        }
        this$0.mb(pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kb(WinkEditorTextMenuPartV2 this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = pair.second;
        Intrinsics.checkNotNullExpressionValue(obj, "it.second");
        this$0.Yb(((Number) obj).intValue());
    }

    private final boolean Mb(PagEffectData pagEffectData) {
        boolean z16;
        boolean z17;
        if (pagEffectData != null) {
            z16 = false;
            z17 = false;
            for (TextLayerData textLayerData : pagEffectData.getTextLayerList()) {
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

    private final boolean Nb() {
        return H9() instanceof WinkImageTavCut;
    }

    private final void Pb(View view) {
        Map<String, Object> mParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(mParams, "mParams");
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_TYPE, Integer.valueOf(ib().f322039c0));
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_USE_TEXT_SOURCE, ib().m2());
        mParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, lb());
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

    private final void Qb() {
        com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
        arVar.o(arVar.k("wink_edit_text_menu_sel_color"), this.saveTextColor);
        arVar.o(arVar.k("wink_edit_text_menu_sel_underlay_type"), this.saveTextUnderlayType);
        arVar.o(arVar.k("wink_edit_text_menu_sel_font"), this.saveFontIndex);
    }

    private final void Rb() {
        int i3 = ib().f322039c0;
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
        String m26 = ib().m2();
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

    private final void Sb(boolean visible) {
        EditText editText = this.mTextInput;
        if (editText != null) {
            editText.setCursorVisible(visible);
        }
    }

    private final void Tb(boolean visible) {
        EditText editText = this.mTextInput;
        if (editText != null) {
            if (visible) {
                Sb(true);
                com.tencent.videocut.utils.j.f384247a.b(editText);
            } else {
                Sb(false);
                com.tencent.videocut.utils.j.f384247a.a(editText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa(String id5) {
        Object obj;
        Map<String, String> map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinearLayout linearLayout = this.mSubstrateSel;
        String str = null;
        if (linearLayout != null) {
            obj = linearLayout.getTag();
        } else {
            obj = null;
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE, String.valueOf(obj));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & this.saveTextColor)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE, format);
        linkedHashMap.put("xsj_text_content", String.valueOf(this.inputWords));
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE, "0");
        MetaMaterial metaMaterial = this.currentMetaMaterial;
        if (metaMaterial != null && (map = metaMaterial.additionalFields) != null) {
            str = map.get("fontID");
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME, String.valueOf(str));
        WinkDatongCurrentParams.put(id5 + "_textreport", linkedHashMap);
    }

    private final void Yb(int displayType) {
        if (!this.visible) {
            Bundle bundle = new Bundle();
            bundle.putInt(EmotionConstants.DISPLAY_TYPE, displayType);
            Q9(bundle);
        }
        ib().w2();
        ib().N1("CATEGORY_TEXT_STYLE");
    }

    public static /* synthetic */ void ab(WinkEditorTextMenuPartV2 winkEditorTextMenuPartV2, boolean z16, boolean z17, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                z17 = false;
            }
            if ((i16 & 4) != 0) {
                i3 = 0;
            }
            winkEditorTextMenuPartV2.Za(z16, z17, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: complete");
    }

    private final void ac(PAGText pagText, MetaMaterial material) {
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

    private final void bb(String elementId, boolean isIMP) {
        String str;
        Map<String, ? extends Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        if (isIMP) {
            str = "ev_xsj_abnormal_imp";
        } else {
            str = "ev_xsj_abnormal_clck";
        }
        aVar.a(elementId, str, WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE, buildElementParams);
    }

    private final void bc(PAGText pagText, MetaMaterialContent content, MetaMaterial material) {
        pagText.text = "";
        if (content != null) {
            pagText.text = content.getContent();
            pagText.fillColor = com.tencent.mobileqq.wink.editor.sticker.m.F(material);
            pagText.fontStyle = com.tencent.mobileqq.wink.editor.sticker.m.s(material);
            pagText.fontFamily = com.tencent.mobileqq.wink.editor.sticker.m.o(material);
            ac(pagText, material);
            mc(pagText, material);
        }
    }

    private final void cc(PAGFile materialPagFile, final MetaMaterial material) {
        ArrayList<MetaMaterialContent> arrayList;
        Integer num;
        Integer num2;
        ArrayList<MetaMaterialContent> metaMaterialContent;
        ArrayList<MetaMaterialContent> metaMaterialContent2;
        ArrayList<MetaMaterialContent> metaMaterialContent3;
        ArrayList<MetaMaterialContent> arrayList2;
        MetaMaterialContent metaMaterialContent4;
        ArrayList<MetaMaterialContent> metaMaterialContent5;
        PAGView pAGView = this.mTextPagView;
        if (materialPagFile != null && pAGView != null) {
            PAGText textData = materialPagFile.getTextData(0);
            if (textData == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(textData, "pagFile.getTextData(0) ?: return");
            MetaMaterialContent metaMaterialContent6 = null;
            if (com.tencent.mobileqq.wink.editor.sticker.m.m(material) != null) {
                MetaMaterialContentWrapper m3 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                if (m3 != null) {
                    arrayList2 = m3.getMetaMaterialContent();
                } else {
                    arrayList2 = null;
                }
                if (arrayList2 != null) {
                    MetaMaterialContentWrapper m16 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                    if (m16 != null && (metaMaterialContent5 = m16.getMetaMaterialContent()) != null) {
                        metaMaterialContent4 = metaMaterialContent5.get(0);
                    } else {
                        metaMaterialContent4 = null;
                    }
                    bc(textData, metaMaterialContent4, material);
                }
            }
            materialPagFile.replaceText(0, textData);
            boolean z16 = true;
            PAGText textData2 = materialPagFile.getTextData(1);
            if (textData2 == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(textData2, "pagFile.getTextData(1) ?: return");
            if (com.tencent.mobileqq.wink.editor.sticker.m.m(material) != null) {
                MetaMaterialContentWrapper m17 = com.tencent.mobileqq.wink.editor.sticker.m.m(material);
                if (m17 != null) {
                    arrayList = m17.getMetaMaterialContent();
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    if (this.isSubtitleEditMode) {
                        bc(textData2, null, material);
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
                                bc(textData2, metaMaterialContent6, material);
                            }
                        }
                    }
                }
            }
            materialPagFile.replaceText(1, textData2);
            pAGView.setComposition(materialPagFile);
            Handler mainHandler = getMainHandler();
            if (mainHandler != null) {
                mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ar
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorTextMenuPartV2.dc(WinkEditorTextMenuPartV2.this, material);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dc(WinkEditorTextMenuPartV2 this$0, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        this$0.nc(material, true);
    }

    private final void ec(View categoryView, boolean checked) {
        Object obj;
        if (categoryView != null) {
            obj = categoryView.getParent();
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        ((View) obj).setSelected(checked);
        if (checked) {
            categoryView.setBackgroundResource(R.drawable.l5n);
        } else {
            categoryView.setBackground(null);
        }
    }

    private final Pair<Integer, String> fb(int type) {
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        return new Pair<>(Integer.valueOf(R.drawable.nr_), "\u534a\u900f\u886c\u5e95");
                    }
                    throw new IllegalArgumentException("Invalid type: " + type);
                }
                return new Pair<>(Integer.valueOf(R.drawable.nr9), "\u7eaf\u8272\u886c\u5e95");
            }
            return new Pair<>(Integer.valueOf(R.drawable.nrb), "\u63cf\u8fb9\u886c\u5e95");
        }
        return new Pair<>(Integer.valueOf(R.drawable.nra), "\u65e0\u886c\u5e95");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ic(WinkEditorTextMenuPartV2 this$0, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        this$0.nc(material, false);
    }

    private final void kb() {
        com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
        this.saveTextColor = arVar.e(arVar.k("wink_edit_text_menu_sel_color"), Color.parseColor("#EFEFEF"));
        this.saveTextUnderlayType = arVar.e(arVar.k("wink_edit_text_menu_sel_underlay_type"), 0);
        this.saveFontIndex = arVar.e(arVar.k("wink_edit_text_menu_sel_font"), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kc(MetaMaterial material) {
        if (this.mTextPagView != null) {
            PAGFile jb5 = jb(material);
            PagEffectData A = rd4.c.f431135f.A(com.tencent.mobileqq.wink.editor.sticker.m.y(material));
            if (A != null && Mb(A)) {
                cc(jb5, material);
            } else {
                hc(jb5, this.mTextPagView, material);
            }
        }
    }

    private final void mc(PAGText pagText, MetaMaterial material) {
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

    private final void nb() {
        RecyclerView recyclerView = this.fontRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FrameLayout frameLayout = this.colorSelectorParent;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ec(this.mColorSelBG, false);
        ec(this.mFontSelBG, false);
    }

    private final void nc(MetaMaterial material, boolean bilingual) {
        ArrayList<MetaMaterialContent> arrayList;
        MetaMaterialContent metaMaterialContent;
        ArrayList<MetaMaterialContent> metaMaterialContent2;
        ArrayList<MetaMaterialContent> metaMaterialContent3;
        String l3 = com.tencent.mobileqq.wink.editor.sticker.m.l(material);
        int i3 = 0;
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
        if (editText != null && !Intrinsics.areEqual(l3, editText.getText().toString()) && !Intrinsics.areEqual(l3, bb.f322031o0)) {
            editText.setText(l3);
            Editable text = editText.getText();
            if (text != null) {
                i3 = text.length();
            }
            editText.setSelection(i3);
        }
    }

    private final void oc() {
        Object obj;
        Integer num;
        LinearLayout linearLayout = this.mSubstrateSel;
        Integer num2 = null;
        if (linearLayout != null) {
            obj = linearLayout.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            num2 = Integer.valueOf((num.intValue() + 1) % 4);
        }
        if (num2 != null) {
            int intValue = num2.intValue();
            LinearLayout linearLayout2 = this.mSubstrateSel;
            if (linearLayout2 != null) {
                linearLayout2.setTag(num2);
            }
            Pair<Integer, String> fb5 = fb(num2.intValue());
            ib().S2(intValue);
            this.saveTextUnderlayType = intValue;
            TextView textView = this.mSubstrateSelText;
            if (textView != null) {
                textView.setText((CharSequence) fb5.second);
            }
            ImageView imageView = this.mSubstrateSelImage;
            if (imageView != null) {
                Object obj2 = fb5.first;
                Intrinsics.checkNotNullExpressionValue(obj2, "drawableAndName.first");
                imageView.setImageResource(((Number) obj2).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pb(WinkEditorTextMenuPartV2 this$0, WinkStickerModel winkStickerModel) {
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
            this$0.hb().j5(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qb(final WinkEditorTextMenuPartV2 this$0, MetaMaterial metaMaterial) {
        Serializable serializable;
        final TTSAudioInfo tTSAudioInfo;
        long j3;
        long durationUs;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        WinkEditorFragment F9 = this$0.F9();
        if (metaMaterial != null && H9 != null && F9 != null) {
            WinkStickerModel b26 = this$0.ib().b2();
            boolean z16 = false;
            if (b26 != null && b26.getHasChooseTTS()) {
                z16 = true;
            }
            if (z16) {
                WinkStickerModel b27 = this$0.ib().b2();
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
            WinkStickerModel b28 = this$0.ib().b2();
            if (b28 != null) {
                j3 = b28.startTime;
            } else {
                j3 = 0;
            }
            WinkStickerModel b29 = this$0.ib().b2();
            if (b29 != null) {
                durationUs = b29.duration;
            } else {
                durationUs = H9.getDurationUs();
            }
            com.tencent.mobileqq.wink.editor.sticker.l.k(metaMaterial, H9, F9, j3, durationUs, new Function1<WinkStickerModel, WinkStickerModel>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPartV2$initDataObserver$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final WinkStickerModel invoke(@NotNull WinkStickerModel stickerModel) {
                    Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
                    WinkEditorTextMenuPartV2.this.Wa(stickerModel.id);
                    stickerModel.setHasChooseTTS(tTSAudioInfo != null);
                    TTSAudioInfo tTSAudioInfo2 = tTSAudioInfo;
                    stickerModel.setTtsAudioInfo(tTSAudioInfo2 != null ? tTSAudioInfo2.copy(tTSAudioInfo2.getTemplateType(), tTSAudioInfo.getDisplayName(), null, tTSAudioInfo.getVolume(), stickerModel.id) : null);
                    return stickerModel;
                }
            });
            this$0.ib().D2(null);
            if (com.tencent.mobileqq.wink.editor.sticker.m.T(metaMaterial)) {
                this$0.hb().j5(com.tencent.mobileqq.wink.editor.sticker.m.l(metaMaterial));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(WinkEditorTextMenuPartV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ib().N1("CATEGORY_KEYBOARD");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ub() {
        aa().getTextMaterialVOLiveData().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.vb(WinkEditorTextMenuPartV2.this, (com.tencent.mobileqq.wink.editor.model.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vb(WinkEditorTextMenuPartV2 this$0, com.tencent.mobileqq.wink.editor.model.b winkMaterialVO) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(winkMaterialVO, "winkMaterialVO");
        this$0.ib().H2(winkMaterialVO.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(WinkEditorTextMenuPartV2 this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.ib().P1(v3, v3.getId(), this$0.lb());
        int id5 = v3.getId();
        if (id5 == R.id.f94985dr) {
            this$0.bb(WinkDaTongReportConstant.ElementId.EM_XSJ_TEXT_UNDERLAY_BUTTON, false);
        } else if (id5 == R.id.f94715d1) {
            this$0.bb(WinkDaTongReportConstant.ElementId.EM_XSJ_TEXT_COLOR_BUTTON, false);
        } else if (id5 == R.id.f94775d7) {
            this$0.bb(WinkDaTongReportConstant.ElementId.EM_XSJ_FONT_BUTTON, false);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yb(WinkEditorTextMenuPartV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ya();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f94855de;
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

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        Unit unit;
        int i3;
        String string;
        dr H9;
        super.L9(args);
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = new WinkSoftKeyboardStateHelper(getPartRootView());
        WinkSoftKeyboardStateHelper.a aVar = this.mKeyboardStateListener;
        if (aVar != null) {
            winkSoftKeyboardStateHelper.i(aVar);
        }
        this.mKeyboardStateHelper = winkSoftKeyboardStateHelper;
        if (ib().W1() == null) {
            ib().f322038b0 = bb.f322035s0.indexOf(Integer.valueOf(this.saveTextColor));
            ib().f322039c0 = this.saveTextUnderlayType;
            ib().f322037a0 = this.saveFontIndex;
        } else {
            this.saveTextColor = ib().c2();
            this.saveTextUnderlayType = ib().f322039c0;
            this.saveFontIndex = ib().f322037a0;
        }
        ib().p2(this.isSubtitleMode, true);
        if (G9().getEditMode() == WinkEditorViewModel.EditMode.Video && (H9 = H9()) != null) {
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
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    Xa(false);
                } else {
                    View partRootView = getPartRootView();
                    if (partRootView != null) {
                        partRootView.bringToFront();
                    }
                    LinearLayout linearLayout = this.mBottomSwitchLayout;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    TextMenuBgView textMenuBgView = this.textMenuBgView;
                    if (textMenuBgView != null) {
                        textMenuBgView.l(true, R.color.ckx, new Function0<Bitmap>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPartV2$onShow$6
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            @Nullable
                            public final Bitmap invoke() {
                                return WinkEditorTextMenuPartV2.this.eb();
                            }
                        });
                    }
                }
            } else {
                TextMenuBgView textMenuBgView2 = this.textMenuBgView;
                if (textMenuBgView2 != null) {
                    textMenuBgView2.l(true, R.color.ckx, new Function0<Bitmap>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPartV2$onShow$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final Bitmap invoke() {
                            return WinkEditorTextMenuPartV2.this.eb();
                        }
                    });
                }
            }
        } else {
            Xa(true);
        }
        Tb(true);
        bb(WinkDaTongReportConstant.ElementId.EM_XSJ_TEXT_UNDERLAY_BUTTON, true);
        bb(WinkDaTongReportConstant.ElementId.EM_XSJ_TEXT_COLOR_BUTTON, true);
        bb(WinkDaTongReportConstant.ElementId.EM_XSJ_FONT_BUTTON, true);
    }

    @NotNull
    public bb Lb() {
        ViewModel viewModel = getViewModel(bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorTextViewModel::class.java)");
        return (bb) viewModel;
    }

    public void Ob() {
        int i3;
        ib().N1("CATEGORY_KEYBOARD");
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

    protected final void Vb(@NotNull WinkEditorViewModel winkEditorViewModel) {
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "<set-?>");
        this.mEditorViewModel = winkEditorViewModel;
    }

    protected final void Wb(@NotNull bb bbVar) {
        Intrinsics.checkNotNullParameter(bbVar, "<set-?>");
        this.mTextViewModel = bbVar;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    /* renamed from: X9 */
    protected boolean getAutoAnimate() {
        return false;
    }

    public void Xa(boolean isTemplateText) {
        TextMenuBgView textMenuBgView = this.textMenuBgView;
        if (textMenuBgView != null) {
            textMenuBgView.l(isTemplateText, R.color.ckv, new Function0<Bitmap>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPartV2$adjustMask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Bitmap invoke() {
                    return WinkEditorTextMenuPartV2.this.eb();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        if (r0 == true) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ya() {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        boolean z18;
        Editable text;
        EditText editText = this.mTextInput;
        if (editText != null && (text = editText.getText()) != null) {
            str = text.toString();
        } else {
            str = null;
        }
        this.inputWords = str;
        Rb();
        String str3 = this.inputWords;
        boolean z19 = true;
        if (str3 != null) {
            if (str3.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z16 = true;
                if (!z16) {
                    ab(this, true, false, 0, 6, null);
                } else {
                    ab(this, false, false, 0, 6, null);
                }
                TextView textView = this.mTextConfirm;
                Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type android.view.View");
                Pb(textView);
                str2 = this.inputWords;
                if (str2 != null) {
                    if (str2.length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z19 = false;
                if (!z19) {
                    return;
                }
                SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(7, 100));
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
        TextView textView2 = this.mTextConfirm;
        Intrinsics.checkNotNull(textView2, "null cannot be cast to non-null type android.view.View");
        Pb(textView2);
        str2 = this.inputWords;
        if (str2 != null) {
        }
        z19 = false;
        if (!z19) {
        }
    }

    public void Za(boolean isUpdated, boolean fromCancel, int completeType) {
        String str;
        int i3;
        List<MetaMaterial> B;
        List<MetaMaterial> B2;
        Editable text;
        Editable editable;
        boolean z16;
        Editable text2;
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
                if (editText2 != null && (text2 = editText2.getText()) != null && text2.length() == 0) {
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
        EditText editText4 = this.mTextInput;
        if (editText4 != null && (text = editText4.getText()) != null) {
            str = text.toString();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) && ib().W1() != null && !fromCancel) {
            ms.a.f(this.TAG, "mTextInput empty");
        } else {
            ib().Q1(isUpdated, this.plainText, this.pagViewWidth, this.pagViewCenter, this.finalTextBounds, this.isSubtitleEditMode, completeType);
        }
        if (isUpdated) {
            h hVar = this.mTextFontContentAdapter;
            if (hVar == null || (B2 = hVar.B()) == null || B2.isEmpty()) {
                z17 = false;
            }
            if (z17 && ib().f322037a0 >= 0) {
                int i16 = ib().f322037a0;
                h hVar2 = this.mTextFontContentAdapter;
                if (hVar2 != null && (B = hVar2.B()) != null) {
                    i3 = B.size();
                } else {
                    i3 = -1;
                }
                if (i16 < i3) {
                    h hVar3 = this.mTextFontContentAdapter;
                    Intrinsics.checkNotNull(hVar3);
                    MetaMaterial metaMaterial = hVar3.B().get(ib().f322037a0);
                    h hVar4 = this.mTextFontContentAdapter;
                    Intrinsics.checkNotNull(hVar4);
                    hVar4.P(ib().f322037a0, metaMaterial);
                }
            }
        } else {
            ib().z2(0);
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
                bundle.putString("selected_sticker_uid", ib().b2().id);
                Unit unit = Unit.INSTANCE;
                G9.u5(menuType, bundle);
            }
        } else {
            x9();
        }
        EditText editText5 = this.mTextInput;
        if (editText5 != null) {
            editText5.setText("");
        }
        Xb();
        Qb();
    }

    public void Zb(@Nullable String categoryId) {
        boolean z16;
        boolean z17;
        ms.a.a(this.TAG, "switchCategory " + categoryId);
        if (categoryId != null) {
            int hashCode = categoryId.hashCode();
            if (hashCode != -1276594656) {
                if (hashCode != -994367056) {
                    if (hashCode == -922501230 && categoryId.equals("CATEGORY_TEXT_COLOR")) {
                        FrameLayout frameLayout = this.colorSelectorParent;
                        if (frameLayout != null && frameLayout.getVisibility() == 8) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            FrameLayout frameLayout2 = this.colorSelectorParent;
                            if (frameLayout2 != null) {
                                frameLayout2.setVisibility(0);
                            }
                            com.tencent.mobileqq.wink.editor.sticker.text.b bVar = this.colorSelectorAdapter;
                            if (bVar != null) {
                                bVar.notifyDataSetChanged();
                            }
                            ec(this.mColorSelBG, true);
                        } else {
                            FrameLayout frameLayout3 = this.colorSelectorParent;
                            if (frameLayout3 != null) {
                                frameLayout3.setVisibility(8);
                            }
                            ec(this.mColorSelBG, false);
                        }
                        ec(this.mFontSelBG, false);
                        RecyclerView recyclerView = this.fontRecyclerView;
                        if (recyclerView != null) {
                            recyclerView.setVisibility(8);
                        }
                        Tb(true);
                        return;
                    }
                    return;
                }
                if (categoryId.equals("CATEGORY_TEXT_SUBSTRATE")) {
                    Tb(true);
                    oc();
                    return;
                }
                return;
            }
            if (categoryId.equals("CATEGORY_TEXT_FONT")) {
                RecyclerView recyclerView2 = this.fontRecyclerView;
                if (recyclerView2 != null && recyclerView2.getVisibility() == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    RecyclerView recyclerView3 = this.fontRecyclerView;
                    if (recyclerView3 != null) {
                        recyclerView3.setVisibility(0);
                    }
                    h hVar = this.mTextFontContentAdapter;
                    if (hVar != null) {
                        hVar.notifyDataSetChanged();
                    }
                    ec(this.mFontSelBG, true);
                } else {
                    RecyclerView recyclerView4 = this.fontRecyclerView;
                    if (recyclerView4 != null) {
                        recyclerView4.setVisibility(8);
                    }
                    ec(this.mFontSelBG, false);
                }
                FrameLayout frameLayout4 = this.colorSelectorParent;
                if (frameLayout4 != null) {
                    frameLayout4.setVisibility(8);
                }
                ec(this.mColorSelBG, false);
                Tb(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.TEXT;
    }

    @NotNull
    protected ApplyMaterialTask cb() {
        if (this.mApplyMaterialTask == null) {
            this.mApplyMaterialTask = new b();
        }
        ApplyMaterialTask applyMaterialTask = this.mApplyMaterialTask;
        Intrinsics.checkNotNull(applyMaterialTask);
        return applyMaterialTask;
    }

    @Nullable
    public Bitmap eb() {
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

    @Nullable
    /* renamed from: gb, reason: from getter */
    protected final LinearLayout getMBottomSwitchLayout() {
        return this.mBottomSwitchLayout;
    }

    @NotNull
    protected final WinkEditorViewModel hb() {
        WinkEditorViewModel winkEditorViewModel = this.mEditorViewModel;
        if (winkEditorViewModel != null) {
            return winkEditorViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEditorViewModel");
        return null;
    }

    public void hc(@Nullable PAGFile materialPagFile, @Nullable PAGView mTextPagView, @NotNull final MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (materialPagFile != null && mTextPagView != null) {
            PAGText textData = materialPagFile.getTextData(0);
            if (textData == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(textData, "pagFile.getTextData(0) ?: return");
            jc(textData, material);
            textData.justification = com.tencent.mobileqq.wink.editor.sticker.m.G(material);
            materialPagFile.replaceText(0, textData);
            mTextPagView.setComposition(materialPagFile);
            Handler mainHandler = getMainHandler();
            if (mainHandler != null) {
                mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorTextMenuPartV2.ic(WinkEditorTextMenuPartV2.this, material);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final bb ib() {
        bb bbVar = this.mTextViewModel;
        if (bbVar != null) {
            return bbVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTextViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        ms.a.f(this.TAG, "initAfterInflation");
        this.contentheight = com.tencent.videocut.utils.e.f384236a.a(380.0f);
        this.mColorSelectorIndicatorOffset = com.tencent.mobileqq.util.x.c(getContext(), 2.0f);
        this.mContentLayout = (FrameLayout) rootView.findViewById(R.id.leb);
        kb();
        ub();
        ob();
        tb(rootView);
        Ab(rootView);
        wb(rootView);
        Bb();
        Tb(true);
        ms.a.f(this.TAG, "initAfterInflation end");
    }

    public PAGFile jb(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        return com.tencent.mobileqq.wink.utils.x.b().c(com.tencent.mobileqq.wink.editor.sticker.m.y(material));
    }

    public void jc(@NotNull PAGText pagText, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(pagText, "pagText");
        Intrinsics.checkNotNullParameter(material, "material");
        pagText.text = com.tencent.mobileqq.wink.editor.sticker.m.l(material);
        pagText.fillColor = com.tencent.mobileqq.wink.editor.sticker.m.F(material);
        pagText.fontStyle = com.tencent.mobileqq.wink.editor.sticker.m.s(material);
        pagText.fontFamily = com.tencent.mobileqq.wink.editor.sticker.m.o(material);
        ac(pagText, material);
        mc(pagText, material);
    }

    @NotNull
    protected final String lb() {
        if (Nb()) {
            return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_PIC_PAGE;
        }
        return WinkDaTongReportConstant.ElementParamValue.XSJ_IS_VIDEO_PAGE;
    }

    public void mb(@NotNull Pair<String, Boolean> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Object obj = pair.second;
        Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
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
        ((CharSequence) obj2).length();
    }

    public void ob() {
        ib().e2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.pb(WinkEditorTextMenuPartV2.this, (WinkStickerModel) obj);
            }
        });
        ib().S1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorTextMenuPartV2.qb(WinkEditorTextMenuPartV2.this, (MetaMaterial) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        dr H9;
        nb();
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
        Tb(false);
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
        Fb();
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

    public void rb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        EditText editText = (EditText) rootView.findViewById(R.id.f94815da);
        this.mTextInput = editText;
        if (editText != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTextMenuPartV2.sb(WinkEditorTextMenuPartV2.this, view);
                }
            });
        }
        EditText editText2 = this.mTextInput;
        if (editText2 != null) {
            editText2.addTextChangedListener(new c());
        }
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

    public void tb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mKeyboardStateListener = new d();
        rb(rootView);
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

    @Override // o73.a
    public void w3() {
        com.tencent.mobileqq.wink.editor.view.e eVar = this.winkEditorChangeInputLoadingDialog;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void wb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ax
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorTextMenuPartV2.xb(WinkEditorTextMenuPartV2.this, view);
            }
        };
        this.mMenuLayout = (LinearLayout) rootView.findViewById(R.id.z3e);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.f94985dr);
        TextView textView = null;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        } else {
            linearLayout = null;
        }
        this.mSubstrateSel = linearLayout;
        this.mSubstrateSelText = (TextView) rootView.findViewById(R.id.f95015du);
        this.mSubstrateSelImage = (ImageView) rootView.findViewById(R.id.f95005dt);
        LinearLayout linearLayout2 = this.mSubstrateSel;
        if (linearLayout2 != null) {
            linearLayout2.setTag(Integer.valueOf(this.saveTextUnderlayType));
        }
        Pair<Integer, String> fb5 = fb(this.saveTextUnderlayType);
        TextView textView2 = this.mSubstrateSelText;
        if (textView2 != null) {
            textView2.setText((CharSequence) fb5.second);
        }
        ImageView imageView = this.mSubstrateSelImage;
        if (imageView != null) {
            Object obj = fb5.first;
            Intrinsics.checkNotNullExpressionValue(obj, "pair.first");
            imageView.setImageResource(((Number) obj).intValue());
        }
        LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.f94715d1);
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(onClickListener);
        } else {
            linearLayout3 = null;
        }
        this.mColorSel = linearLayout3;
        this.mColorSelBG = (LinearLayout) rootView.findViewById(R.id.f94725d2);
        LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.f94775d7);
        if (linearLayout4 != null) {
            linearLayout4.setOnClickListener(onClickListener);
        } else {
            linearLayout4 = null;
        }
        this.mFontSel = linearLayout4;
        this.mFontSelBG = (LinearLayout) rootView.findViewById(R.id.f94785d8);
        TextView textView3 = (TextView) rootView.findViewById(R.id.u47);
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.ay
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTextMenuPartV2.yb(WinkEditorTextMenuPartV2.this, view);
                }
            });
            textView = textView3;
        }
        this.mTextConfirm = textView;
        this.mBottomSwitchLayout = (LinearLayout) rootView.findViewById(R.id.f166090ed2);
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

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    public final void Xb() {
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eb(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gc(int index) {
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPartV2$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (s16 != null) {
                WinkEditorTextMenuPartV2 winkEditorTextMenuPartV2 = WinkEditorTextMenuPartV2.this;
                winkEditorTextMenuPartV2.ib().L1(s16.toString());
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
