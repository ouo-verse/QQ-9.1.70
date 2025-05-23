package com.tencent.mobileqq.wink.editor.subtitle;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.subtitle.k;
import com.tencent.mobileqq.wink.editor.subtitle.l;
import com.tencent.mobileqq.wink.editor.subtitle.p;
import com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00df\u00012\u00020\u0001:\u0002\u00e0\u0001B\t\u00a2\u0006\u0006\b\u00dd\u0001\u0010\u00de\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002JF\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\u0012\u0010 \u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\u0016\u0010)\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050'H\u0002J=\u00100\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+2'\b\u0002\u0010/\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+\u0012\u0004\u0012\u00020\u0002\u0018\u00010*\u00a2\u0006\u0002\b.H\u0002J\n\u00102\u001a\u0004\u0018\u000101H\u0002J\b\u00103\u001a\u00020\u0002H\u0002J\u0010\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u00020\nH\u0002J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u00020\u0002H\u0016J\b\u00109\u001a\u00020\nH\u0016J\u0010\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0014J\b\u0010=\u001a\u00020\u0002H\u0016J\u0012\u0010@\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010>H\u0014J\b\u0010A\u001a\u00020\u0002H\u0014J\b\u0010B\u001a\u00020\u0002H\u0014J\b\u0010C\u001a\u00020\u0002H\u0014J\u0012\u0010F\u001a\u00020\u00022\b\u0010E\u001a\u0004\u0018\u00010DH\u0016J\b\u0010G\u001a\u00020\u001aH\u0016J\b\u0010H\u001a\u00020\u0002H\u0016R\u001b\u0010M\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR!\u0010R\u001a\b\u0012\u0004\u0012\u00020,0N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001b\u0010]\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010J\u001a\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010J\u001a\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001b\u0010\u000b\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010J\u001a\u0004\bi\u0010jR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bl\u0010J\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u0010J\u001a\u0004\br\u0010sR\u001b\u0010w\u001a\u00020k8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bu\u0010J\u001a\u0004\bv\u0010nR\u001b\u0010z\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bx\u0010J\u001a\u0004\by\u0010jR\u001b\u0010\u007f\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010J\u001a\u0004\b}\u0010~R\u001e\u0010\u0082\u0001\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010J\u001a\u0005\b\u0081\u0001\u0010~R\u001e\u0010\u0085\u0001\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0083\u0001\u0010J\u001a\u0005\b\u0084\u0001\u0010~R\u001e\u0010\u0088\u0001\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0086\u0001\u0010J\u001a\u0005\b\u0087\u0001\u0010aR\u001e\u0010\u008b\u0001\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0089\u0001\u0010J\u001a\u0005\b\u008a\u0001\u0010~R\u001e\u0010\u008e\u0001\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008c\u0001\u0010J\u001a\u0005\b\u008d\u0001\u0010\\R\u001e\u0010\u0091\u0001\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008f\u0001\u0010J\u001a\u0005\b\u0090\u0001\u0010aR\u001e\u0010\u0094\u0001\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0092\u0001\u0010J\u001a\u0005\b\u0093\u0001\u0010~R\u001e\u0010\u0097\u0001\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0095\u0001\u0010J\u001a\u0005\b\u0096\u0001\u0010jR \u0010\u009c\u0001\u001a\u00030\u0098\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0099\u0001\u0010J\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R \u0010\u00a1\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009e\u0001\u0010J\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001e\u0010\u00a4\u0001\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a2\u0001\u0010J\u001a\u0005\b\u00a3\u0001\u0010jR\u001e\u0010\u00a7\u0001\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a5\u0001\u0010J\u001a\u0005\b\u00a6\u0001\u0010jR\u001e\u0010\u00aa\u0001\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a8\u0001\u0010J\u001a\u0005\b\u00a9\u0001\u0010jR \u0010\u00af\u0001\u001a\u00030\u00ab\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ac\u0001\u0010J\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u001e\u0010\u00b2\u0001\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b0\u0001\u0010J\u001a\u0005\b\u00b1\u0001\u0010aR\u001e\u0010\u00b5\u0001\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b3\u0001\u0010J\u001a\u0005\b\u00b4\u0001\u0010\\R \u0010\u00ba\u0001\u001a\u00030\u00b6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b7\u0001\u0010J\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001R \u0010\u00bd\u0001\u001a\u00030\u00b6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00bb\u0001\u0010J\u001a\u0006\b\u00bc\u0001\u0010\u00b9\u0001R \u0010\u00c0\u0001\u001a\u00030\u00b6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00be\u0001\u0010J\u001a\u0006\b\u00bf\u0001\u0010\u00b9\u0001R\u001e\u0010\u00c3\u0001\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00c1\u0001\u0010J\u001a\u0005\b\u00c2\u0001\u0010aR \u0010\u00c8\u0001\u001a\u00030\u00c4\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00c5\u0001\u0010J\u001a\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u001c\u0010\u00cc\u0001\u001a\u0005\u0018\u00010\u00c9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00cb\u0001R\u001c\u0010\u00d0\u0001\u001a\u0005\u0018\u00010\u00cd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00cf\u0001R,\u0010\u00d8\u0001\u001a\u0005\u0018\u00010\u00d1\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001\u001a\u0006\b\u00d4\u0001\u0010\u00d5\u0001\"\u0006\b\u00d6\u0001\u0010\u00d7\u0001R\u0018\u0010\u00dc\u0001\u001a\u00030\u00d9\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00da\u0001\u0010\u00db\u0001\u00a8\u0006\u00e1\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "kb", "Rc", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "line", "Lcom/tencent/mobileqq/wink/editor/subtitle/k;", "action", "mc", "", "title", "positiveText", "negativeText", "Lkotlin/Function0;", "positiveAction", "negativeAction", "Gc", "Mc", "Cc", "wc", "Ac", "Bc", "Ec", "initView", "jc", "", "fullScreen", "Tb", "Qc", "Pc", "hint", "Oc", "progress", "Nc", "code", "Kc", "ib", "lb", "", "result", "Dc", "Lkotlin/Function1;", "", "", "", "Lkotlin/ExtensionFunctionType;", "builder", "jb", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleUIData;", "Sb", "Vb", "id", "xc", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "M9", "Landroid/os/Bundle;", "args", "L9", "pa", "onDismiss", "ma", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "uiData", "N9", "onBackEvent", "x9", "M", "Lkotlin/Lazy;", "Ab", "()I", "halfMenuHeight", "", "N", "Jb", "()[Ljava/lang/String;", "loadingTexts", "P", "I", "currentLoadingTextIndex", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "loadingTextChangeRunnable", BdhLogUtil.LogTag.Tag_Req, "Lb", "()Landroid/view/View;", "panelBg", "Landroidx/constraintlayout/widget/Group;", ExifInterface.LATITUDE_SOUTH, "yb", "()Landroidx/constraintlayout/widget/Group;", "groupTopBar", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "T", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "autoTranslateLoadingDialog", "Landroid/widget/TextView;", "U", "getTitle", "()Landroid/widget/TextView;", "Landroidx/constraintlayout/widget/Guideline;", "V", "Mb", "()Landroidx/constraintlayout/widget/Guideline;", "panelTopGuideline", "Landroid/widget/Space;", "W", "Kb", "()Landroid/widget/Space;", "panelBarBottomSpace", "X", "Bb", "keyboardTopGuideline", "Y", "Qb", "time", "Landroid/widget/ImageView;", "Z", "Nb", "()Landroid/widget/ImageView;", "playerToggle", "a0", "rb", "cancel", "b0", "sb", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "c0", "vb", "groupHalfBar", "d0", "ob", "bilingualCheckBox", "e0", "pb", "bilingualParent", "f0", "xb", "groupLoading", "g0", "Gb", "loadingIcon", "h0", "Ib", "loadingText", "Landroid/widget/ProgressBar;", "i0", "Hb", "()Landroid/widget/ProgressBar;", "loadingProgress", "Landroid/widget/FrameLayout;", "j0", "Eb", "()Landroid/widget/FrameLayout;", "loadingErrIcon", "k0", "Fb", "loadingErrTips", "l0", "Db", "loadingBtnGray", "m0", "Cb", "loadingBtnBlue", "Landroidx/recyclerview/widget/RecyclerView;", "n0", "Pb", "()Landroidx/recyclerview/widget/RecyclerView;", "subtitleList", "o0", "ub", "groupBottomBar", "p0", "qb", "bottomDivider", "Landroid/widget/LinearLayout;", "q0", "tb", "()Landroid/widget/LinearLayout;", "editBtn", "r0", "Ob", "styleBtn", "s0", "nb", "allDeleteBtn", "t0", "wb", "groupHasContent", "Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "u0", "Rb", "()Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel;", "viewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "v0", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeViewModel", "Landroid/app/Dialog;", "w0", "Landroid/app/Dialog;", "dialog", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;", "x0", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;", "getSoftKeyboardStateHelper", "()Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;", "setSoftKeyboardStateHelper", "(Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper;)V", "softKeyboardStateHelper", "Lcom/tencent/mobileqq/wink/editor/subtitle/j;", "mb", "()Lcom/tencent/mobileqq/wink/editor/subtitle/j;", "adapter", "<init>", "()V", "y0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSubtitleMenuPart extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy halfMenuHeight;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingTexts;

    /* renamed from: P, reason: from kotlin metadata */
    private int currentLoadingTextIndex;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Runnable loadingTextChangeRunnable;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy panelBg;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupTopBar;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog autoTranslateLoadingDialog;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy title;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy panelTopGuideline;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy panelBarBottomSpace;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy keyboardTopGuideline;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy time;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy playerToggle;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cancel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy confirm;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy groupHalfBar;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bilingualCheckBox;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bilingualParent;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy groupLoading;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingIcon;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingText;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingProgress;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingErrIcon;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingErrTips;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingBtnGray;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingBtnBlue;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subtitleList;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy groupBottomBar;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bottomDivider;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy editBtn;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy styleBtn;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy allDeleteBtn;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy groupHasContent;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicVolumeControlViewModel musicVolumeViewModel;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog dialog;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSoftKeyboardStateHelper softKeyboardStateHelper;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleMenuPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "", "d", "Z", HippyPagerPageChangeListener.DRAGGING, "e", "I", "itemHeight", "f", "highlightIndex", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean dragging;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int itemHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int highlightIndex = -1;

        b() {
            this.itemHeight = WinkSubtitleMenuPart.this.getActivity().getResources().getDimensionPixelSize(R.dimen.djr);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            if (((LinearLayoutManager) layoutManager).isSmoothScrolling()) {
                return;
            }
            if (newState != 1 && newState != 2) {
                if (!this.dragging) {
                    return;
                }
                this.dragging = false;
                WinkSubtitleMenuPart.this.Rb().F3(this.highlightIndex);
                this.highlightIndex = -1;
                return;
            }
            if (this.dragging) {
                return;
            }
            this.dragging = true;
            WinkSubtitleMenuPart.this.Rb().A2();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (!this.dragging) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            this.highlightIndex = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            WinkSubtitleMenuPart.this.mb().x0(this.highlightIndex);
        }
    }

    public WinkSubtitleMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        Lazy lazy16;
        Lazy lazy17;
        Lazy lazy18;
        Lazy lazy19;
        Lazy lazy20;
        Lazy lazy21;
        Lazy lazy22;
        Lazy lazy23;
        Lazy lazy24;
        Lazy lazy25;
        Lazy lazy26;
        Lazy lazy27;
        Lazy lazy28;
        Lazy lazy29;
        Lazy lazy30;
        Lazy lazy31;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$halfMenuHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(WinkSubtitleMenuPart.this.getContext().getResources().getDimensionPixelSize(R.dimen.djt));
            }
        });
        this.halfMenuHeight = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String[]>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingTexts$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String[] invoke() {
                String string = WinkSubtitleMenuPart.this.getContext().getString(R.string.f241127r1);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026nk_subtitle_processing_1)");
                String string2 = WinkSubtitleMenuPart.this.getContext().getString(R.string.f241137r2);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026nk_subtitle_processing_2)");
                String string3 = WinkSubtitleMenuPart.this.getContext().getString(R.string.f241147r3);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026nk_subtitle_processing_3)");
                return new String[]{string, string2, string3};
            }
        });
        this.loadingTexts = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$panelBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return partRootView.findViewById(R.id.f2220033);
            }
        });
        this.panelBg = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Group>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$groupTopBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Group invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                Group invoke$lambda$0 = (Group) partRootView.findViewById(R.id.vur);
                Intrinsics.checkNotNullExpressionValue(invoke$lambda$0, "invoke$lambda$0");
                ViewUtilsKt.i(invoke$lambda$0, R.id.cancel, R.id.title, R.id.b7m);
                return invoke$lambda$0;
            }
        });
        this.groupTopBar = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$title$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (TextView) partRootView.findViewById(R.id.title);
            }
        });
        this.title = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Guideline>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$panelTopGuideline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Guideline invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (Guideline) partRootView.findViewById(R.id.f224403q);
            }
        });
        this.panelTopGuideline = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Space>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$panelBarBottomSpace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Space invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (Space) partRootView.findViewById(R.id.f2219032);
            }
        });
        this.panelBarBottomSpace = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Guideline>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$keyboardTopGuideline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Guideline invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (Guideline) partRootView.findViewById(R.id.ybq);
            }
        });
        this.keyboardTopGuideline = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$time$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (TextView) partRootView.findViewById(R.id.jl7);
            }
        });
        this.time = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$playerToggle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (ImageView) partRootView.findViewById(R.id.f25970c_);
            }
        });
        this.playerToggle = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$cancel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (ImageView) partRootView.findViewById(R.id.cancel);
            }
        });
        this.cancel = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$confirm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (ImageView) partRootView.findViewById(R.id.b7m);
            }
        });
        this.confirm = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<Group>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$groupHalfBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Group invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                Group invoke$lambda$0 = (Group) partRootView.findViewById(R.id.vtp);
                Intrinsics.checkNotNullExpressionValue(invoke$lambda$0, "invoke$lambda$0");
                ViewUtilsKt.i(invoke$lambda$0, R.id.f25970c_, R.id.cancel, R.id.b7m);
                return invoke$lambda$0;
            }
        });
        this.groupHalfBar = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$bilingualCheckBox$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (ImageView) partRootView.findViewById(R.id.tvp);
            }
        });
        this.bilingualCheckBox = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$bilingualParent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return partRootView.findViewById(R.id.f225003w);
            }
        });
        this.bilingualParent = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<Group>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$groupLoading$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Group invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                Group invoke$lambda$0 = (Group) partRootView.findViewById(R.id.vty);
                Intrinsics.checkNotNullExpressionValue(invoke$lambda$0, "invoke$lambda$0");
                ViewUtilsKt.i(invoke$lambda$0, R.id.ysu, R.id.efo, R.id.efn, R.id.ysf, R.id.ysn, R.id.yso, R.id.yse);
                return invoke$lambda$0;
            }
        });
        this.groupLoading = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (ImageView) partRootView.findViewById(R.id.ysu);
            }
        });
        this.loadingIcon = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (TextView) partRootView.findViewById(R.id.efo);
            }
        });
        this.loadingText = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<ProgressBar>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingProgress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ProgressBar invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                ProgressBar progressBar = (ProgressBar) partRootView.findViewById(R.id.efn);
                progressBar.setMax(100);
                return progressBar;
            }
        });
        this.loadingProgress = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingErrIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (FrameLayout) partRootView.findViewById(R.id.ysn);
            }
        });
        this.loadingErrIcon = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingErrTips$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (TextView) partRootView.findViewById(R.id.yso);
            }
        });
        this.loadingErrTips = lazy21;
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingBtnGray$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (TextView) partRootView.findViewById(R.id.ysf);
            }
        });
        this.loadingBtnGray = lazy22;
        lazy23 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$loadingBtnBlue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (TextView) partRootView.findViewById(R.id.yse);
            }
        });
        this.loadingBtnBlue = lazy23;
        lazy24 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$subtitleList$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$subtitleList$2$1, reason: invalid class name */
            /* loaded from: classes21.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Subtitle, k, Unit> {
                AnonymousClass1(Object obj) {
                    super(2, obj, WinkSubtitleMenuPart.class, "onItemAction", "onItemAction(Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitleItemAction;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Subtitle subtitle, k kVar) {
                    invoke2(subtitle, kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Subtitle p06, @NotNull k p16) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    Intrinsics.checkNotNullParameter(p16, "p1");
                    ((WinkSubtitleMenuPart) this.receiver).mc(p06, p16);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                RecyclerView recyclerView = (RecyclerView) partRootView.findViewById(R.id.f906252z);
                recyclerView.setLayoutManager(new LinearLayoutManager(WinkSubtitleMenuPart.this.getContext(), 1, false));
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(WinkSubtitleMenuPart.this);
                final WinkSubtitleMenuPart winkSubtitleMenuPart = WinkSubtitleMenuPart.this;
                recyclerView.setAdapter(new j(anonymousClass1, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$subtitleList$2.2
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
                        WinkSubtitleMenuPart.this.kb();
                    }
                }));
                return recyclerView;
            }
        });
        this.subtitleList = lazy24;
        lazy25 = LazyKt__LazyJVMKt.lazy(new Function0<Group>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$groupBottomBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Group invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                Group invoke$lambda$0 = (Group) partRootView.findViewById(R.id.vt_);
                Intrinsics.checkNotNullExpressionValue(invoke$lambda$0, "invoke$lambda$0");
                ViewUtilsKt.i(invoke$lambda$0, R.id.acn, R.id.f165047bs3, R.id.f898250t, R.id.slq);
                return invoke$lambda$0;
            }
        });
        this.groupBottomBar = lazy25;
        lazy26 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$bottomDivider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return partRootView.findViewById(R.id.acn);
            }
        });
        this.bottomDivider = lazy26;
        lazy27 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$editBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (LinearLayout) partRootView.findViewById(R.id.f165047bs3);
            }
        });
        this.editBtn = lazy27;
        lazy28 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$styleBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (LinearLayout) partRootView.findViewById(R.id.f898250t);
            }
        });
        this.styleBtn = lazy28;
        lazy29 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$allDeleteBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (LinearLayout) partRootView.findViewById(R.id.slq);
            }
        });
        this.allDeleteBtn = lazy29;
        lazy30 = LazyKt__LazyJVMKt.lazy(new Function0<Group>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$groupHasContent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Group invoke() {
                WinkSubtitleMenuPart.this.ub();
                View partRootView = WinkSubtitleMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                Group invoke$lambda$0 = (Group) partRootView.findViewById(R.id.vtq);
                Intrinsics.checkNotNullExpressionValue(invoke$lambda$0, "invoke$lambda$0");
                ViewUtilsKt.i(invoke$lambda$0, R.id.vt_, R.id.f906252z, R.id.cancel, R.id.b7m);
                return invoke$lambda$0;
            }
        });
        this.groupHasContent = lazy30;
        lazy31 = LazyKt__LazyJVMKt.lazy(new Function0<WinkSubtitleViewModel>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkSubtitleViewModel invoke() {
                WinkSubtitleViewModel winkSubtitleViewModel = (WinkSubtitleViewModel) WinkSubtitleMenuPart.this.getViewModel(WinkSubtitleViewModel.class);
                winkSubtitleViewModel.W2(DefaultSubtitleDataSource.f322225a, a.f322144a);
                return winkSubtitleViewModel;
            }
        });
        this.viewModel = lazy31;
    }

    private final int Ab() {
        return ((Number) this.halfMenuHeight.getValue()).intValue();
    }

    private final void Ac() {
        Gc(R.string.f241037qs, R.string.a8j, R.string.cancel, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$showCancelExistEditDialog$1
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
                WinkSubtitleMenuPart.this.Rb().J3(false, false);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Guideline Bb() {
        Object value = this.keyboardTopGuideline.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-keyboardTopGuideline>(...)");
        return (Guideline) value;
    }

    private final void Bc() {
        Gc(R.string.f241037qs, R.string.a8j, R.string.cancel, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$showChangeRevertExistConfirmDialog$1
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
                WinkSubtitleMenuPart.this.Rb().H3(false);
            }
        }, null);
    }

    private final TextView Cb() {
        Object value = this.loadingBtnBlue.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingBtnBlue>(...)");
        return (TextView) value;
    }

    private final void Cc() {
        Gc(R.string.f241077qw, R.string.h3s, R.string.cancel, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$showClearConfirmDialog$1
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
                WinkSubtitleMenuPart.this.Rb().u2(true, true);
            }
        }, null);
    }

    private final TextView Db() {
        Object value = this.loadingBtnGray.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingBtnGray>(...)");
        return (TextView) value;
    }

    private final void Dc(List<Subtitle> result) {
        Tb(false);
        mb().O0(result);
        lb();
        WinkSubtitleUIData Sb = Sb();
        if (Sb != null) {
            Sb.saveSubtitleList(result);
        }
    }

    private final FrameLayout Eb() {
        Object value = this.loadingErrIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingErrIcon>(...)");
        return (FrameLayout) value;
    }

    private final void Ec() {
        Gc(R.string.f241067qv, R.string.f241057qu, R.string.cancel, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$showDeleteAllConfirmDialog$1
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
                WinkSubtitleViewModel.v2(WinkSubtitleMenuPart.this.Rb(), false, false, 2, null);
            }
        }, null);
    }

    private final TextView Fb() {
        Object value = this.loadingErrTips.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingErrTips>(...)");
        return (TextView) value;
    }

    private final ImageView Gb() {
        Object value = this.loadingIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingIcon>(...)");
        return (ImageView) value;
    }

    private final void Gc(@StringRes int title, @StringRes int positiveText, @StringRes int negativeText, final Function0<Unit> positiveAction, final Function0<Unit> negativeAction) {
        try {
            Dialog dialog = this.dialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            QQCustomDialog negativeButton = DialogUtil.createCustomDialog(getContext(), 230).setMessage(getContext().getString(title)).setPositiveButton(getContext().getString(positiveText), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.af
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkSubtitleMenuPart.Hc(Function0.this, dialogInterface, i3);
                }
            }).setNegativeButton(getContext().getString(negativeText), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ag
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkSubtitleMenuPart.Ic(Function0.this, dialogInterface, i3);
                }
            });
            this.dialog = negativeButton;
            negativeButton.getTitleTextView().setSingleLine(false);
            negativeButton.getTitleTextView().setGravity(8388627);
            negativeButton.show();
        } catch (Throwable th5) {
            ms.a.e(this.TAG, th5);
        }
    }

    private final ProgressBar Hb() {
        Object value = this.loadingProgress.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingProgress>(...)");
        return (ProgressBar) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hc(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Ib() {
        Object value = this.loadingText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingText>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ic(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final String[] Jb() {
        return (String[]) this.loadingTexts.getValue();
    }

    private final Space Kb() {
        Object value = this.panelBarBottomSpace.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-panelBarBottomSpace>(...)");
        return (Space) value;
    }

    private final void Kc(int code) {
        switch (code) {
            case 1000019:
                Oc(R.string.f241097qy);
                break;
            case 1000020:
            default:
                Pc();
                break;
            case 1000021:
                Oc(R.string.f241187r7);
                break;
            case 1000022:
                Oc(R.string.f241097qy);
                break;
        }
        lb();
        m.f322215a.o();
    }

    private final View Lb() {
        Object value = this.panelBg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-panelBg>(...)");
        return (View) value;
    }

    private final Guideline Mb() {
        Object value = this.panelTopGuideline.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-panelTopGuideline>(...)");
        return (Guideline) value;
    }

    private final void Mc() {
        Gc(R.string.f241087qx, R.string.f241047qt, R.string.f170901b10, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$showExitConfirmDialog$1
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
                WinkSubtitleMenuPart.this.Rb().R3();
            }
        });
    }

    private final ImageView Nb() {
        Object value = this.playerToggle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-playerToggle>(...)");
        return (ImageView) value;
    }

    private final void Nc(int progress) {
        Qc();
        if (Build.VERSION.SDK_INT >= 24) {
            Hb().setProgress(progress, true);
        } else {
            Hb().setProgress(progress);
        }
        ib();
    }

    private final LinearLayout Ob() {
        Object value = this.styleBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-styleBtn>(...)");
        return (LinearLayout) value;
    }

    private final void Oc(@StringRes int hint) {
        jc();
        Gb().setVisibility(8);
        Ib().setVisibility(8);
        Hb().setVisibility(8);
        Eb().setVisibility(0);
        Fb().setVisibility(0);
        Cb().setVisibility(8);
        Db().setText(R.string.f241107qz);
        Fb().setText(hint);
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(16).setBackgroundColorType(0).setHalfScreenState(true).setThemeType(2).build();
        Eb().removeAllViews();
        Eb().addView(build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView Pb() {
        Object value = this.subtitleList.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-subtitleList>(...)");
        return (RecyclerView) value;
    }

    private final void Pc() {
        jc();
        Gb().setVisibility(8);
        Ib().setVisibility(8);
        Hb().setVisibility(8);
        Eb().setVisibility(0);
        Fb().setVisibility(0);
        Cb().setVisibility(0);
        Db().setText(R.string.f170901b10);
        Fb().setText(R.string.f241117r0);
        try {
            Result.Companion companion = Result.INSTANCE;
            QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(5).setBackgroundColorType(0).setHalfScreenState(true).setThemeType(2).build();
            Eb().removeAllViews();
            Eb().addView(build);
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    private final TextView Qb() {
        Object value = this.time.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-time>(...)");
        return (TextView) value;
    }

    private final void Qc() {
        jc();
        Gb().setVisibility(0);
        Ib().setVisibility(0);
        Hb().setVisibility(0);
        Eb().setVisibility(8);
        Fb().setVisibility(8);
        Cb().setVisibility(8);
        Db().setText(R.string.cancel);
        m mVar = m.f322215a;
        mVar.a(Db());
        mVar.o();
        Gb().setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkSubtitleViewModel Rb() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkSubtitleViewModel) value;
    }

    private final void Rc() {
        Map<Integer, Float> e26;
        Set<Integer> keySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        MusicVolumeControlViewModel musicVolumeControlViewModel = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel != null && (e26 = musicVolumeControlViewModel.e2()) != null && (keySet = e26.keySet()) != null) {
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                linkedHashMap.put(Integer.valueOf(((Number) it.next()).intValue()), Float.valueOf(1.0f));
            }
        }
        dr H9 = H9();
        if (H9 != null) {
            H9.v(linkedHashMap);
        }
    }

    private final WinkSubtitleUIData Sb() {
        WinkEditUIData C9 = C9();
        if (C9 != null && (C9 instanceof WinkSubtitleUIData)) {
            return (WinkSubtitleUIData) C9;
        }
        return null;
    }

    private final void Tb(boolean fullScreen) {
        int a16;
        int dimensionPixelSize;
        int i3 = 8;
        xb().setVisibility(8);
        int i16 = 0;
        wb().setVisibility(0);
        if (fullScreen) {
            vb().setVisibility(8);
            yb().setVisibility(0);
        } else {
            yb().setVisibility(8);
            vb().setVisibility(0);
        }
        Group ub5 = ub();
        if (!fullScreen) {
            i3 = 0;
        }
        ub5.setVisibility(i3);
        int i17 = -1;
        if (fullScreen) {
            Mb().setGuidelineBegin(com.tencent.mobileqq.wink.editor.util.m.n(null, 1, null));
        } else {
            Mb().setGuidelineBegin(-1);
        }
        ViewGroup.LayoutParams layoutParams = Lb().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (!fullScreen) {
            i17 = 0;
        }
        marginLayoutParams.height = i17;
        RecyclerView Pb = Pb();
        int paddingLeft = Pb().getPaddingLeft();
        if (fullScreen) {
            a16 = com.tencent.videocut.utils.e.f384236a.a(8.0f);
        } else {
            a16 = com.tencent.videocut.utils.e.f384236a.a(80.0f) - getActivity().getResources().getDimensionPixelSize(R.dimen.djv);
        }
        Pb.setPadding(paddingLeft, a16, Pb().getPaddingRight(), Pb().getPaddingBottom());
        ViewGroup.LayoutParams layoutParams2 = Pb().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (fullScreen) {
            dimensionPixelSize = getActivity().getResources().getDimensionPixelSize(R.dimen.dju);
        } else {
            dimensionPixelSize = getActivity().getResources().getDimensionPixelSize(R.dimen.djv);
        }
        marginLayoutParams2.topMargin = dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams3 = Kb().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (!fullScreen) {
            i16 = getActivity().getResources().getDimensionPixelSize(R.dimen.djv);
        }
        marginLayoutParams3.topMargin = i16;
        if (!fullScreen) {
            ViewGroup.LayoutParams layoutParams4 = Pb().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams4).bottomToBottom = R.id.acn;
        }
    }

    private final void Vb() {
        Activity activity = getActivity();
        G9().W4(false);
        if (this.autoTranslateLoadingDialog != null && activity != null && !activity.isFinishing()) {
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.autoTranslateLoadingDialog;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.dismiss();
            }
            this.autoTranslateLoadingDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wb(WinkSubtitleMenuPart this$0, Long it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        if (H9 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            H9.seek(it.longValue());
        }
        dr H92 = this$0.H9();
        if (H92 != null) {
            H92.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xb(WinkSubtitleMenuPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkSubtitleUIData Sb = this$0.Sb();
        if (Sb != null) {
            Sb.saveBilingualStatus(bool);
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            this$0.ob().setImageResource(R.drawable.guild_checkbox_selected);
        } else {
            this$0.ob().setImageResource(R.drawable.nud);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yb(WinkSubtitleMenuPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.kb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zb(WinkSubtitleMenuPart this$0, View view) {
        WinkStickerFrameLayout winkStickerFrameLayout;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Rb().getIsBilingual()) {
            this$0.Rb().p2();
        } else {
            this$0.Rb().U3();
        }
        Activity activity = this$0.getActivity();
        if (activity != null && (winkStickerFrameLayout = (WinkStickerFrameLayout) activity.findViewById(R.id.f122407dv)) != null) {
            winkStickerFrameLayout.w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ac(WinkSubtitleMenuPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rb().k2();
        if (Intrinsics.areEqual(this$0.getContext().getString(R.string.cancel), this$0.Db().getText())) {
            m mVar = m.f322215a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mVar.e(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bc(WinkSubtitleMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rb().z3(NetworkUtil.isNetworkAvailable());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cc(WinkSubtitleMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rb().T3();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dc(WinkSubtitleMenuPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rb().B2(true);
        m mVar = m.f322215a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mVar.h(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ec(WinkSubtitleMenuPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rb().M3();
        m mVar = m.f322215a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mVar.m(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gc(WinkSubtitleMenuPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ec();
        m mVar = m.f322215a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mVar.g(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hc(WinkSubtitleMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mb().u0();
        this$0.Rb().j2();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ib() {
        long j3;
        final String[] Jb;
        List mutableList;
        if (this.loadingTextChangeRunnable != null) {
            return;
        }
        dr H9 = H9();
        if (H9 != null) {
            j3 = H9.getDurationUs();
        } else {
            j3 = 0;
        }
        int floor = (int) (10 + (5 * ((float) Math.floor(((float) (j3 / 1000000)) / 60.0f))));
        if (floor > 30) {
            mutableList = ArraysKt___ArraysKt.toMutableList(Jb());
            if (floor > 60) {
                String string = getContext().getString(R.string.f241167r5, Integer.valueOf(floor / 60));
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026cessing_5, costTime / 60)");
                mutableList.add(string);
            } else {
                String string2 = getContext().getString(R.string.f241157r4, Integer.valueOf(floor));
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026e_processing_4, costTime)");
                mutableList.add(string2);
            }
            Object[] array = mutableList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Jb = (String[]) array;
        } else {
            Jb = Jb();
        }
        this.currentLoadingTextIndex = 0;
        Ib().setText(Jb[0]);
        this.loadingTextChangeRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$activeProgressText$1
            @Override // java.lang.Runnable
            public void run() {
                TextView Ib;
                int i3;
                int i16;
                Ib = WinkSubtitleMenuPart.this.Ib();
                String[] strArr = Jb;
                WinkSubtitleMenuPart winkSubtitleMenuPart = WinkSubtitleMenuPart.this;
                i3 = winkSubtitleMenuPart.currentLoadingTextIndex;
                winkSubtitleMenuPart.currentLoadingTextIndex = i3 + 1;
                i16 = winkSubtitleMenuPart.currentLoadingTextIndex;
                Ib.setText(strArr[i16 % Jb.length]);
                ThreadManagerV2.getUIHandlerV2().postDelayed(this, 3000L);
            }
        };
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = this.loadingTextChangeRunnable;
        Intrinsics.checkNotNull(runnable, "null cannot be cast to non-null type java.lang.Runnable");
        uIHandlerV2.postDelayed(runnable, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ic(WinkSubtitleMenuPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.Rb().getInEditing()) {
            m mVar = m.f322215a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mVar.f(it);
        }
        this$0.mb().u0();
        this$0.Rb().s2();
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void initView() {
        VideoReport.setElementId(pb(), WinkDaTongReportConstant.ElementId.EM_XSJ_BILINGUAL_SUBTITLE_ENTRANCE);
        pb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.Zb(WinkSubtitleMenuPart.this, view);
            }
        });
        Db().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.ac(WinkSubtitleMenuPart.this, view);
            }
        });
        Cb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.bc(WinkSubtitleMenuPart.this, view);
            }
        });
        Nb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.cc(WinkSubtitleMenuPart.this, view);
            }
        });
        tb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.dc(WinkSubtitleMenuPart.this, view);
            }
        });
        Ob().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.ec(WinkSubtitleMenuPart.this, view);
            }
        });
        nb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.gc(WinkSubtitleMenuPart.this, view);
            }
        });
        rb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.hc(WinkSubtitleMenuPart.this, view);
            }
        });
        sb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkSubtitleMenuPart.ic(WinkSubtitleMenuPart.this, view);
            }
        });
        Pb().addOnScrollListener(new b());
    }

    private final Map<String, Object> jb(Function1<? super Map<String, Object>, Unit> builder) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        if (builder != null) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            builder.invoke(params);
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        return params;
    }

    private final void jc() {
        xb().setVisibility(0);
        wb().setVisibility(8);
        yb().setVisibility(8);
        Mb().setGuidelineBegin(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kb() {
        if (Intrinsics.areEqual(Rb().P2().getValue(), Boolean.TRUE) && mb().getDisplayMode() == 0) {
            pb().setVisibility(0);
        } else {
            pb().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kc() {
        m.f322215a.o();
    }

    private final void lb() {
        Runnable runnable = this.loadingTextChangeRunnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        this.loadingTextChangeRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j mb() {
        RecyclerView.Adapter adapter = Pb().getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.subtitle.SubtitleAdapter");
        return (j) adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mc(Subtitle line, k action) {
        if (Intrinsics.areEqual(action, k.d.f322199a)) {
            Rb().y3(line);
            return;
        }
        if (action instanceof k.Edit) {
            k.Edit edit = (k.Edit) action;
            Rb().m3(edit.getIndex(), edit.getContent());
        } else if (action instanceof k.BreakLine) {
            k.BreakLine breakLine = (k.BreakLine) action;
            Rb().k3(breakLine.getIndex(), breakLine.getOrigContent(), breakLine.getCurContent(), breakLine.getNewContent());
        } else if (action instanceof k.Click) {
            Rb().l3(((k.Click) action).getIndex());
        }
    }

    private final LinearLayout nb() {
        Object value = this.allDeleteBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-allDeleteBtn>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nc(WinkSubtitleMenuPart this$0, t73.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair pair = (Pair) aVar.a();
        if (pair == null) {
            return;
        }
        this$0.mb().t0(((Number) pair.component1()).intValue(), (Subtitle) pair.component2());
    }

    private final ImageView ob() {
        Object value = this.bilingualCheckBox.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bilingualCheckBox>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oc(WinkSubtitleMenuPart this$0, t73.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair pair = (Pair) aVar.a();
        if (pair == null) {
            return;
        }
        this$0.mb().B0(((Number) pair.component1()).intValue(), (Subtitle) pair.component2());
    }

    private final View pb() {
        Object value = this.bilingualParent.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bilingualParent>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View qb() {
        Object value = this.bottomDivider.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomDivider>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qc(WinkSubtitleMenuPart this$0, t73.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        p pVar = (p) aVar.a();
        if (pVar == null) {
            return;
        }
        if (pVar instanceof p.c) {
            this$0.Rb().X3();
            this$0.Vb();
            ra3.a.a(this$0.getContext(), this$0.getContext().getResources().getString(R.string.f215905wv));
            return;
        }
        if (pVar instanceof p.d) {
            this$0.xc(R.string.f215895wu);
            return;
        }
        if (pVar instanceof p.e) {
            this$0.xc(R.string.f215935wy);
            return;
        }
        if (pVar instanceof p.TranslateUpdateSuccess) {
            this$0.Vb();
            ra3.a.a(this$0.getContext(), this$0.getContext().getResources().getString(R.string.f215945wz));
        } else if (pVar instanceof p.f) {
            this$0.Vb();
            ra3.a.a(this$0.getContext(), this$0.getContext().getResources().getString(R.string.f215925wx));
        } else if (pVar instanceof p.a) {
            this$0.Vb();
            ra3.a.a(this$0.getContext(), this$0.getContext().getResources().getString(R.string.f215885wt));
        }
    }

    private final ImageView rb() {
        Object value = this.cancel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cancel>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rc(WinkSubtitleMenuPart this$0, t73.a aVar) {
        boolean z16;
        List<Subtitle> emptyList;
        List<Subtitle> emptyList2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = (l) aVar.a();
        if (lVar == null) {
            return;
        }
        ms.a.a(this$0.TAG, "viewModel.subtitleLoadEvent event " + lVar.getClass().getSimpleName() + " " + lVar);
        if (Intrinsics.areEqual(lVar, l.C9040l.f322213a)) {
            j mb5 = this$0.mb();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mb5.O0(emptyList);
            WinkSubtitleUIData Sb = this$0.Sb();
            if (Sb != null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                Sb.saveSubtitleList(emptyList2);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(lVar, l.e.f322204a)) {
            this$0.x9();
            return;
        }
        if (Intrinsics.areEqual(lVar, l.k.f322212a)) {
            this$0.Mc();
            return;
        }
        if (Intrinsics.areEqual(lVar, l.a.f322200a)) {
            this$0.Cc();
            return;
        }
        if (Intrinsics.areEqual(lVar, l.b.f322201a)) {
            this$0.wc();
            return;
        }
        if (Intrinsics.areEqual(lVar, l.c.f322202a)) {
            this$0.Ac();
            return;
        }
        if (Intrinsics.areEqual(lVar, l.d.f322203a)) {
            this$0.Bc();
            return;
        }
        if (lVar instanceof l.Loading) {
            this$0.Nc(((l.Loading) lVar).getProgress());
            return;
        }
        if (lVar instanceof l.Err) {
            this$0.Kc(((l.Err) lVar).getCode());
            return;
        }
        if (lVar instanceof l.Finished) {
            l.Finished finished = (l.Finished) lVar;
            List<Subtitle> a16 = finished.a();
            if (a16 != null && !a16.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this$0.Kc(1000019);
                return;
            }
            this$0.mb().M0(0);
            this$0.Dc(finished.a());
            this$0.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ae
                @Override // java.lang.Runnable
                public final void run() {
                    WinkSubtitleMenuPart.sc();
                }
            }, 400L);
            return;
        }
        if (lVar instanceof l.Edit) {
            l.Edit edit = (l.Edit) lVar;
            boolean open = edit.getOpen();
            this$0.mb().M0(open ? 1 : 0);
            this$0.Tb(open);
            if (open) {
                j mb6 = this$0.mb();
                Subtitle subtitle = edit.getSubtitle();
                Intrinsics.checkNotNull(subtitle);
                mb6.y0(subtitle);
                this$0.Qb().setVisibility(4);
                return;
            }
            this$0.Qb().setVisibility(0);
            return;
        }
        if (lVar instanceof l.Styling) {
            WinkStickerModel sticker = ((l.Styling) lVar).getSticker();
            WinkEditorViewModel G9 = this$0.G9();
            MenuType menuType = MenuType.SUBTITLE_TEXT;
            Bundle bundle = new Bundle();
            bundle.putString(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, sticker.id);
            Unit unit = Unit.INSTANCE;
            G9.u5(menuType, bundle);
            return;
        }
        if (lVar instanceof l.KeyBoard) {
            WinkStickerModel sticker2 = ((l.KeyBoard) lVar).getSticker();
            WinkEditorViewModel G92 = this$0.G9();
            MenuType menuType2 = MenuType.SUBTITLE_TEXT;
            Bundle bundle2 = new Bundle();
            bundle2.putInt(EmotionConstants.DISPLAY_TYPE, 3);
            bundle2.putString(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, sticker2.id);
            Unit unit2 = Unit.INSTANCE;
            G92.u5(menuType2, bundle2);
            if (this$0.mb().getDisplayMode() == 0 && this$0.getPartRootView() != null) {
                m mVar = m.f322215a;
                View partRootView = this$0.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                mVar.n(partRootView);
            }
        }
    }

    private final ImageView sb() {
        Object value = this.confirm.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-confirm>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sc() {
        m.f322215a.o();
    }

    private final LinearLayout tb() {
        Object value = this.editBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-editBtn>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tc(WinkSubtitleMenuPart this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long longValue = ((Number) pair.component1()).longValue();
        long longValue2 = ((Number) pair.component2()).longValue();
        TextView Qb = this$0.Qb();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        long j3 = 1000;
        String format = String.format("%s / %s", Arrays.copyOf(new Object[]{com.tencent.mobileqq.wink.editor.music.a.c(longValue / j3), com.tencent.mobileqq.wink.editor.music.a.c(longValue2 / j3)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        Qb.setText(format);
        j.K0(this$0.mb(), longValue, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Group ub() {
        Object value = this.groupBottomBar.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-groupBottomBar>(...)");
        return (Group) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uc(WinkSubtitleMenuPart this$0, Boolean it) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j mb5 = this$0.mb();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mb5.N0(it.booleanValue());
        ImageView Nb = this$0.Nb();
        if (it.booleanValue()) {
            i3 = R.drawable.oqq;
        } else {
            i3 = R.drawable.oqs;
        }
        Nb.setImageResource(i3);
    }

    private final Group vb() {
        Object value = this.groupHalfBar.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-groupHalfBar>(...)");
        return (Group) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vc(dr tavCut) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(tavCut, "$tavCut");
        FrameLayout frameLayout = null;
        if (tavCut instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) tavCut;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            frameLayout = winkVideoTavCut.getCurrentPlayerViewContainer();
        }
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    private final Group wb() {
        Object value = this.groupHasContent.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-groupHasContent>(...)");
        return (Group) value;
    }

    private final void wc() {
        Gc(R.string.f241027qr, R.string.f170901b10, R.string.cancel, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$showAllRevertExistConfirmDialog$1
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
                WinkSubtitleViewModel.v2(WinkSubtitleMenuPart.this.Rb(), false, false, 2, null);
            }
        }, null);
    }

    private final Group xb() {
        Object value = this.groupLoading.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-groupLoading>(...)");
        return (Group) value;
    }

    private final void xc(int id5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getContext().getString(id5));
        G9().W4(true);
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).n(true).q(arrayList).n(false).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ac
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleMenuPart.yc(WinkSubtitleMenuPart.this);
            }
        }).d(new Callable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ad
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean zc5;
                zc5 = WinkSubtitleMenuPart.zc(WinkSubtitleMenuPart.this);
                return zc5;
            }
        }).a();
        this.autoTranslateLoadingDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    private final Group yb() {
        Object value = this.groupTopBar.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-groupTopBar>(...)");
        return (Group) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yc(WinkSubtitleMenuPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rb().m2();
        this$0.Vb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean zc(WinkSubtitleMenuPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rb().m2();
        this$0.Vb();
        return Boolean.TRUE;
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f905752u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        WinkVideoTavCut winkVideoTavCut;
        FrameLayout frameLayout;
        Float f16;
        Map<Integer, Float> map;
        MusicVolumeControlViewModel.VolumeType volumeType;
        LiveData<Float> T1;
        super.L9(args);
        dr H9 = H9();
        WinkVideoTavCut winkVideoTavCut2 = null;
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            frameLayout = winkVideoTavCut.getCurrentPlayerViewContainer();
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        WinkEditorMenuPart.sa(this, Ab(), 0, 2, null);
        Rb().T2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.qc(WinkSubtitleMenuPart.this, (t73.a) obj);
            }
        });
        Rb().R2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.rc(WinkSubtitleMenuPart.this, (t73.a) obj);
            }
        });
        Qb().setVisibility(0);
        Rb().L2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.tc(WinkSubtitleMenuPart.this, (Pair) obj);
            }
        });
        Rb().N2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.uc(WinkSubtitleMenuPart.this, (Boolean) obj);
            }
        });
        Rb().J2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.nc(WinkSubtitleMenuPart.this, (t73.a) obj);
            }
        });
        Rb().K2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.oc(WinkSubtitleMenuPart.this, (t73.a) obj);
            }
        });
        dr H92 = H9();
        Intrinsics.checkNotNull(H92);
        WinkSubtitleViewModel Rb = Rb();
        MusicVolumeControlViewModel musicVolumeControlViewModel = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel != null && (T1 = musicVolumeControlViewModel.T1()) != null) {
            f16 = T1.getValue();
        } else {
            f16 = null;
        }
        MusicVolumeControlViewModel musicVolumeControlViewModel2 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel2 != null) {
            map = musicVolumeControlViewModel2.e2();
        } else {
            map = null;
        }
        MusicVolumeControlViewModel musicVolumeControlViewModel3 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel3 != null) {
            volumeType = musicVolumeControlViewModel3.f2();
        } else {
            volumeType = null;
        }
        Rb.O3(map, f16, volumeType);
        Rc();
        Rb().u3(H92, NetworkUtil.isNetworkAvailable());
        m mVar = m.f322215a;
        mVar.d(Pb(), jb(new Function1<Map<String, Object>, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$onShow$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map2) {
                invoke2(map2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Map<String, Object> buildReportParams) {
                dr H93;
                Intrinsics.checkNotNullParameter(buildReportParams, "$this$buildReportParams");
                H93 = WinkSubtitleMenuPart.this.H9();
                Intrinsics.checkNotNull(H93);
                buildReportParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_VIDEO_REQUEST_DURATION, Long.valueOf(H93.getDurationUs()));
                buildReportParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_IS_REQUEST_SUCCEED_NETWORK, Integer.valueOf(!WinkSubtitleMenuPart.this.mb().A0() ? 1 : 0));
            }
        }), jb(new Function1<Map<String, Object>, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleMenuPart$onShow$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map2) {
                invoke2(map2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Map<String, Object> buildReportParams) {
                dr H93;
                Intrinsics.checkNotNullParameter(buildReportParams, "$this$buildReportParams");
                H93 = WinkSubtitleMenuPart.this.H9();
                Intrinsics.checkNotNull(H93);
                buildReportParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_VIDEO_REQUEST_DURATION, Long.valueOf(H93.getDurationUs()));
                buildReportParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_IS_REQUEST_SUCCEED_NETWORK, Integer.valueOf(!WinkSubtitleMenuPart.this.mb().A0() ? 1 : 0));
            }
        }));
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = new WinkSoftKeyboardStateHelper(getActivity().findViewById(android.R.id.content));
        this.softKeyboardStateHelper = winkSoftKeyboardStateHelper;
        winkSoftKeyboardStateHelper.i(new c());
        mVar.o();
        if (Rb().getIsBilingual()) {
            ob().setImageResource(R.drawable.guild_checkbox_selected);
        } else {
            ob().setImageResource(R.drawable.nud);
        }
        dr H93 = H9();
        if (H93 instanceof WinkVideoTavCut) {
            winkVideoTavCut2 = (WinkVideoTavCut) H93;
        }
        if (winkVideoTavCut2 != null) {
            winkVideoTavCut2.O2(-16777216);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData uiData) {
        super.N9(uiData);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.SUBTITLE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        O9(new WinkSubtitleUIData(this));
        initView();
        m mVar = m.f322215a;
        mVar.c(Gb());
        mVar.b(Eb());
        Rb().U2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.Wb(WinkSubtitleMenuPart.this, (Long) obj);
            }
        });
        FragmentActivity activity = getHostFragment().getActivity();
        if (activity != null) {
            this.musicVolumeViewModel = (MusicVolumeControlViewModel) new ViewModelProvider(activity).get(MusicVolumeControlViewModel.class);
        }
        Rb().a3().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.Xb(WinkSubtitleMenuPart.this, (Boolean) obj);
            }
        });
        Rb().P2().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSubtitleMenuPart.Yb(WinkSubtitleMenuPart.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ma() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.dialog = null;
        qa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            if (mb().A0()) {
                rb().performClick();
            } else {
                Db().performClick();
            }
            return true;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        WinkVideoTavCut winkVideoTavCut;
        super.onDismiss();
        lb();
        Rb().j3();
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.r
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleMenuPart.kc();
            }
        }, 500L);
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SUBTITLE, Integer.valueOf(mb().A0() ? 1 : 0));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_BILINGUAL_SUBTITLE, Integer.valueOf(Rb().getIsBilingual() ? 1 : 0));
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = this.softKeyboardStateHelper;
        if (winkSoftKeyboardStateHelper != null) {
            winkSoftKeyboardStateHelper.o();
        }
        mb().u0();
        dr H9 = H9();
        if (H9 != null) {
            H9.play();
        }
        dr H92 = H9();
        if (H92 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H92;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.O2(WinkVideoTavCut.INSTANCE.m());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void pa() {
        Rb().onResume();
        final dr H9 = H9();
        if (H9 != null) {
            dr H92 = H9();
            if (H92 != null) {
                H92.flush(true);
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.q
                @Override // java.lang.Runnable
                public final void run() {
                    WinkSubtitleMenuPart.vc(dr.this);
                }
            }, 50L);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void x9() {
        if (this.visible) {
            super.x9();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleMenuPart$c", "Lcom/tencent/mobileqq/wink/view/WinkSoftKeyboardStateHelper$a;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements WinkSoftKeyboardStateHelper.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardClosed() {
            int i3;
            ViewGroup.LayoutParams layoutParams = WinkSubtitleMenuPart.this.Pb().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (WinkSubtitleMenuPart.this.qb().getVisibility() == 0) {
                i3 = R.id.acn;
            } else {
                i3 = 0;
            }
            layoutParams2.bottomToBottom = i3;
            WinkSubtitleMenuPart.this.Pb().requestLayout();
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            WinkSubtitleMenuPart.this.Bb().setGuidelineEnd(keyboardHeightInPx);
            ViewGroup.LayoutParams layoutParams = WinkSubtitleMenuPart.this.Pb().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = R.id.ybq;
            WinkSubtitleMenuPart.this.mb().H0(keyboardHeightInPx);
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void a(int keyboardHeightInPx) {
        }
    }
}
