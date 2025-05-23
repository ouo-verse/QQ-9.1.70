package com.tencent.mobileqq.zplan.aigc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import ce3.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment;
import com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$showColorEditDialog$1;
import com.tencent.mobileqq.zplan.aigc.data.PatternPositionType;
import com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem;
import com.tencent.mobileqq.zplan.aigc.helper.AIGCCreatePublishHelper;
import com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic;
import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.mobileqq.zplan.aigc.render.AIGCWhiteModel;
import com.tencent.mobileqq.zplan.aigc.render.ModelExtraInfo;
import com.tencent.mobileqq.zplan.aigc.render.ModelStyle;
import com.tencent.mobileqq.zplan.aigc.render.g;
import com.tencent.mobileqq.zplan.aigc.utils.SuitOutfitHelper;
import com.tencent.mobileqq.zplan.aigc.view.CustomRadioButtonGroup;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.portal.aigc.view.AigcWatermarkView;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import ga4.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import k94.ColorPanelData;
import k94.DialogCustomData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import wc3.AigcPreviewParams;

@Metadata(d1 = {"\u0000\u008a\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00c9\u00022\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0002\u00ca\u0002B\t\u00a2\u0006\u0006\b\u00c7\u0002\u0010\u00c8\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\tH\u0002J#\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u00020\t2\n\b\u0002\u00102\u001a\u0004\u0018\u000101H\u0002\u00a2\u0006\u0004\b3\u00104J\u0010\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\tH\u0002J\u0010\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0007H\u0002J\u0010\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u000201H\u0002J\u0018\u0010=\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\tH\u0002J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u000201H\u0002J\b\u0010D\u001a\u00020\u0005H\u0002J\b\u0010E\u001a\u00020\u0005H\u0002J\b\u0010F\u001a\u00020\u0005H\u0002J\b\u0010G\u001a\u00020\u0005H\u0002J\b\u0010H\u001a\u00020\u0005H\u0002J\b\u0010I\u001a\u00020\u0005H\u0002J\b\u0010J\u001a\u00020\u0005H\u0002J\u0012\u0010M\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020NH\u0016J\b\u0010Q\u001a\u00020\u0005H\u0016J\b\u0010R\u001a\u00020\u0007H\u0014J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020T0SH\u0016J\b\u0010V\u001a\u00020\u0007H\u0014J\b\u0010W\u001a\u000201H\u0014J&\u0010[\u001a\u0004\u0018\u00010Z2\u0006\u0010Y\u001a\u00020X2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010]\u001a\u00020\u00052\b\u0010\\\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010_\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030^0\u0012j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030^`\u0014H\u0016J\u001a\u0010a\u001a\u00020\u00052\u0006\u0010`\u001a\u00020Z2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J\b\u0010b\u001a\u00020\u0005H\u0016J\b\u0010c\u001a\u00020\u0005H\u0016J\b\u0010d\u001a\u00020\u0005H\u0016J\b\u0010e\u001a\u000201H\u0016R\u001b\u0010k\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010h\u001a\u0004\bn\u0010oR\u001b\u0010u\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010h\u001a\u0004\bs\u0010tR\u001b\u0010x\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010h\u001a\u0004\bw\u0010tR\u001b\u0010}\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010h\u001a\u0004\b{\u0010|R\u001c\u0010\u0080\u0001\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b~\u0010h\u001a\u0004\b\u007f\u0010|R \u0010\u0085\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0082\u0001\u0010h\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u008a\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0087\u0001\u0010h\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001e\u0010\u008d\u0001\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008b\u0001\u0010h\u001a\u0005\b\u008c\u0001\u0010tR \u0010\u0092\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008f\u0001\u0010h\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R \u0010\u0095\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0093\u0001\u0010h\u001a\u0006\b\u0094\u0001\u0010\u0091\u0001R\u001e\u0010\u0098\u0001\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0096\u0001\u0010h\u001a\u0005\b\u0097\u0001\u0010jR \u0010\u009b\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0099\u0001\u0010h\u001a\u0006\b\u009a\u0001\u0010\u0091\u0001R\u001e\u0010\u009e\u0001\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u009c\u0001\u0010h\u001a\u0005\b\u009d\u0001\u0010|R \u0010\u00a3\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a0\u0001\u0010h\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001e\u0010\u00a6\u0001\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a4\u0001\u0010h\u001a\u0005\b\u00a5\u0001\u0010jR \u0010\u00ab\u0001\u001a\u00030\u00a7\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a8\u0001\u0010h\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R \u0010\u00ae\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ac\u0001\u0010h\u001a\u0006\b\u00ad\u0001\u0010\u0084\u0001R \u0010\u00b1\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00af\u0001\u0010h\u001a\u0006\b\u00b0\u0001\u0010\u0091\u0001R \u0010\u00b4\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b2\u0001\u0010h\u001a\u0006\b\u00b3\u0001\u0010\u0089\u0001R\u001c\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u001c\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00b9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u001b\u0010\u00bf\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u001c\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u00c0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u001b\u0010\u00c6\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001R,\u0010\u00ce\u0001\u001a\u0005\u0018\u00010\u00c7\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c8\u0001\u0010\u00c9\u0001\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001\"\u0006\b\u00cc\u0001\u0010\u00cd\u0001R+\u0010\u00d5\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00cf\u0001\u0010\u00d0\u0001\u001a\u0006\b\u00d1\u0001\u0010\u00d2\u0001\"\u0006\b\u00d3\u0001\u0010\u00d4\u0001R\u0019\u0010\u00d7\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u00bd\u0001R)\u0010\u00dd\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d8\u0001\u0010\u00bd\u0001\u001a\u0006\b\u00d9\u0001\u0010\u00da\u0001\"\u0006\b\u00db\u0001\u0010\u00dc\u0001R)\u0010\u00e1\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00de\u0001\u0010\u00bd\u0001\u001a\u0006\b\u00df\u0001\u0010\u00da\u0001\"\u0006\b\u00e0\u0001\u0010\u00dc\u0001R\u001b\u0010\u00e3\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e2\u0001\u0010\u00be\u0001R+\u0010\u00ea\u0001\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e4\u0001\u0010\u00e5\u0001\u001a\u0006\b\u00e6\u0001\u0010\u00e7\u0001\"\u0006\b\u00e8\u0001\u0010\u00e9\u0001R\u0019\u0010\u00ec\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00eb\u0001\u0010\u00bd\u0001R\u001c\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u00ed\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ee\u0001\u0010\u00ef\u0001R\u0019\u0010\u00f2\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u0082\u0001R\u0019\u0010\u00f4\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f3\u0001\u0010\u0082\u0001R\u0019\u0010\u00f7\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f5\u0001\u0010\u00f6\u0001R\u0019\u0010\u00f9\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f8\u0001\u0010\u00f6\u0001R\u0019\u0010\u00fb\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fa\u0001\u0010\u0087\u0001R\u0019\u0010\u00fd\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fc\u0001\u0010\u00f6\u0001R\u0019\u0010\u00ff\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fe\u0001\u0010\u00f6\u0001R\u001c\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R)\u0010\u0086\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0002\u0010\u0085\u0002R\u0019\u0010\u0088\u0002\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0002\u0010\u00bd\u0001R\u001c\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u0089\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0002\u0010\u008b\u0002R'\u0010\u0091\u0002\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030\u008e\u00020\u008d\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R'\u0010\u0093\u0002\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030\u008e\u00020\u008d\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0002\u0010\u0090\u0002R\u0019\u0010\u0095\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0002\u0010\u0087\u0001R\u0019\u0010\u0097\u0002\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0002\u0010\u0087\u0001R\u001c\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0098\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u001b\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u0019\u0010\u00a0\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0002\u0010\u0082\u0001R\u0019\u0010\u00a2\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0002\u0010\u00f6\u0001R\u001c\u0010\u00a6\u0002\u001a\u0005\u0018\u00010\u00a3\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0002\u0010\u00a5\u0002R\u001c\u0010\u00aa\u0002\u001a\u0005\u0018\u00010\u00a7\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0002\u0010\u00a9\u0002R\u001a\u0010\u00ae\u0002\u001a\u00030\u00ab\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0002\u0010\u00ad\u0002R\u001e\u0010\u00b2\u0002\u001a\t\u0012\u0004\u0012\u0002010\u00af\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b0\u0002\u0010\u00b1\u0002R \u0010\u00b7\u0002\u001a\u00030\u00b3\u00028BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b4\u0002\u0010h\u001a\u0006\b\u00b5\u0002\u0010\u00b6\u0002R \u0010\u00bc\u0002\u001a\u00030\u00b8\u00028BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b9\u0002\u0010h\u001a\u0006\b\u00ba\u0002\u0010\u00bb\u0002R\u001e\u0010\u00c0\u0002\u001a\t\u0012\u0004\u0012\u00020>0\u00bd\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00be\u0002\u0010\u00bf\u0002R\u0019\u0010\u00c2\u0002\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0002\u0010\u00bd\u0001R\u001c\u0010\u00c6\u0002\u001a\u0005\u0018\u00010\u00c3\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0002\u0010\u00c5\u0002\u00a8\u0006\u00cb\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitPreviewFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment$b;", "", "Zj", "", "index", "", "jj", "initView", "", "ugcId", "resDir", "Landroid/graphics/Bitmap;", "aj", "Hi", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/m;", "Lkotlin/collections/ArrayList;", "Jj", HippyControllerProps.STRING, "lj", "Ii", "sj", "type", "flag", "tj", "Landroid/graphics/drawable/Drawable;", "oj", "initViewModel", "Dj", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Ij", "Pj", "Luv4/as;", "Ui", "Mj", "Luv4/aa;", "result", "Cj", "toastWords", "Uj", "toastMsg", "", "needFinishFragment", "Ri", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "resourcePath", "Qi", "color", "Pi", "bShow", "Mi", "patternPos", "colorString", com.tencent.av.ui.ak.f75340i, "Ljava/lang/Runnable;", "runnable", "Gi", "Yj", "isPreview", "ck", "Vj", "Qj", "Kj", "Lj", "Wj", "Xj", "bk", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onAttach", "onDetach", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "enableRootViewSetFitsSystemWindows", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "onCreateView", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressed", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "nj", "()Landroid/widget/FrameLayout;", "filamentContainer", "Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup;", "D", "rj", "()Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup;", "patternPosTypeButtons", "Landroid/widget/Button;", "E", "dj", "()Landroid/widget/Button;", "completeButton", UserInfo.SEX_FEMALE, "gj", "continueButton", "Landroid/widget/LinearLayout;", "G", "Zi", "()Landroid/widget/LinearLayout;", "checkButtonMask", "H", "Yi", "checkButton", "Landroid/widget/ImageView;", "I", "Xi", "()Landroid/widget/ImageView;", "checkBtnIcon", "Landroid/widget/TextView;", "J", "Wi", "()Landroid/widget/TextView;", "checkBtnDescription", "K", "wj", "shareButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "L", "cj", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "colorPicker", "M", "ej", "completeButtonView", "N", "hj", "createButtonView", "P", "Bj", "whiteMask", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "zj", "syncQQ", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", BdhLogUtil.LogTag.Tag_Req, "vj", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "selectSyncImage", ExifInterface.LATITUDE_SOUTH, "kj", "dialogViewContainer", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "T", "uj", "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "previewLightLoopPag", "U", "fj", "completeLoadingIcon", "V", "qj", "parentView", "W", "Vi", "aiTv", "Lwk0/a;", "X", "Lwk0/a;", "nativeApp", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "Y", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "scene", "Z", "Landroid/view/View;", "textureView", "Lwc3/a;", "a0", "Lwc3/a;", "aigcPreviewParams", "b0", "Luv4/as;", "colorEditorCfg", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "c0", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "ij", "()Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "setCreatedClothLogic", "(Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;)V", "createdClothLogic", "d0", "Landroid/graphics/Bitmap;", "bj", "()Landroid/graphics/Bitmap;", "Nj", "(Landroid/graphics/Bitmap;)V", "clothBitmap", "e0", "completeState", "f0", "xj", "()Z", "setShouldColorPickerShow", "(Z)V", "shouldColorPickerShow", "g0", "yj", "setShouldShowPatternButtons", "shouldShowPatternButtons", "h0", "parentview", "i0", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "pj", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Oj", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "j0", "colorPanelShow", "Lga4/i;", "k0", "Lga4/i;", "dialogController", "l0", "currentPatternPosType", "m0", "originPatternPosType", "n0", "Ljava/lang/String;", "currentColor", "o0", "originColor", "p0", "preUpdateUgcTime", "q0", "currentLightEnterPagUrl", "r0", "currentLightLoopPagUrl", "Lzd3/a;", "s0", "Lzd3/a;", "dtReporter", "t0", "Ljava/util/ArrayList;", "pastePositionTypeList", "u0", "isLoading", "Lnk3/b;", "v0", "Lnk3/b;", "publishListener", "", "", "w0", "Ljava/util/Map;", "poseTypeBtnClickParamsMap", "x0", "colorPickerParamsMap", "y0", "createLoadingStartTime", "z0", "lastClickTime", "Lcom/tencent/mobileqq/zplan/aigc/share/bl;", "A0", "Lcom/tencent/mobileqq/zplan/aigc/share/bl;", "suitShareDialog", "B0", "Landroid/graphics/drawable/Drawable;", "qqHeadDrawable", "C0", "gender", "D0", "source", "Lce3/a$a;", "E0", "Lce3/a$a;", "aigcDressControllerListener", "Lga4/h;", "F0", "Lga4/h;", "dialogControllerListener", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "G0", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "avatarDressDataManager", "Landroidx/lifecycle/MutableLiveData;", "H0", "Landroidx/lifecycle/MutableLiveData;", "fetchAvatarSuccessEvent", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "I0", "Aj", "()Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "vm", "Lcom/tencent/mobileqq/zplan/portal/aigc/view/AigcWatermarkView;", "J0", "mj", "()Lcom/tencent/mobileqq/zplan/portal/aigc/view/AigcWatermarkView;", "filamentBg", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "K0", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "generatePreviewQueue", "L0", "isRunning", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "M0", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "previewResourceListener", "<init>", "()V", "N0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitPreviewFragment extends ImmersivePartFragment implements SimpleEventReceiver<SimpleBaseEvent>, SuitParentFragment.b {

    /* renamed from: A0, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.share.bl suitShareDialog;

    /* renamed from: B0, reason: from kotlin metadata */
    private Drawable qqHeadDrawable;

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy filamentContainer;

    /* renamed from: C0, reason: from kotlin metadata */
    private int gender;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy patternPosTypeButtons;

    /* renamed from: D0, reason: from kotlin metadata */
    private String source;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy completeButton;

    /* renamed from: E0, reason: from kotlin metadata */
    private a.InterfaceC0184a aigcDressControllerListener;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy continueButton;

    /* renamed from: F0, reason: from kotlin metadata */
    private ga4.h dialogControllerListener;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy checkButtonMask;

    /* renamed from: G0, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.helper.b avatarDressDataManager;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy checkButton;

    /* renamed from: H0, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> fetchAvatarSuccessEvent;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy checkBtnIcon;

    /* renamed from: I0, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy checkBtnDescription;

    /* renamed from: J0, reason: from kotlin metadata */
    private final Lazy filamentBg;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy shareButton;

    /* renamed from: K0, reason: from kotlin metadata */
    private final ConcurrentLinkedQueue<Runnable> generatePreviewQueue;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy colorPicker;

    /* renamed from: L0, reason: from kotlin metadata */
    private boolean isRunning;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy completeButtonView;

    /* renamed from: M0, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.render.g previewResourceListener;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy createButtonView;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy whiteMask;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy syncQQ;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy selectSyncImage;

    /* renamed from: S, reason: from kotlin metadata */
    private final Lazy dialogViewContainer;

    /* renamed from: T, reason: from kotlin metadata */
    private final Lazy previewLightLoopPag;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy completeLoadingIcon;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy parentView;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy aiTv;

    /* renamed from: X, reason: from kotlin metadata */
    private wk0.a nativeApp;

    /* renamed from: Y, reason: from kotlin metadata */
    private AigcPreviewBusinessScene scene;

    /* renamed from: Z, reason: from kotlin metadata */
    private View textureView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private AigcPreviewParams aigcPreviewParams;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private uv4.as colorEditorCfg;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private CreatedClothShowLogic createdClothLogic;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Bitmap clothBitmap;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean completeState;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean shouldColorPickerShow;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean shouldShowPatternButtons;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private View parentview;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean colorPanelShow;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private ga4.i dialogController;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private int currentPatternPosType;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private int originPatternPosType;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private String currentColor;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private String originColor;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private long preUpdateUgcTime;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private String currentLightEnterPagUrl;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private String currentLightLoopPagUrl;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private ArrayList<PatternPositionType> pastePositionTypeList;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private boolean isLoading;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private nk3.b publishListener;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> poseTypeBtnClickParamsMap;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> colorPickerParamsMap;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private long createLoadingStartTime;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\b\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$b", "Luk0/e;", "", "type", "eventData", "", "onEvent", "", "d", "Z", "b", "()Z", "setDone", "(Z)V", "done", "Lkotlinx/coroutines/CancellableContinuation;", "e", "Lkotlinx/coroutines/CancellableContinuation;", "getContRef", "()Lkotlinx/coroutines/CancellableContinuation;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "contRef", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements uk0.e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean done;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private CancellableContinuation<? super Unit> contRef;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SuitPreviewFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.nj().setVisibility(0);
            this$0.ck(true);
            this$0.cj().setVisibility(this$0.getShouldColorPickerShow() ? 0 : 8);
            this$0.dj().setVisibility(0);
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101185", true);
            QLog.i("SuitPreviewFragment", 1, "enableFix: " + isSwitchOn);
            if (isSwitchOn) {
                this$0.zj().setVisibility(0);
            } else {
                this$0.zj().setVisibility(8);
            }
            this$0.Bj().setVisibility(0);
            this$0.rj().setVisibility(this$0.getShouldShowPatternButtons() ? 0 : 8);
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDone() {
            return this.done;
        }

        public final void d(CancellableContinuation<? super Unit> cancellableContinuation) {
            this.contRef = cancellableContinuation;
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            long currentTimeMillis = System.currentTimeMillis() - SuitPreviewFragment.this.Aj().getPerformanceTimeStamp();
            SuitPreviewFragment.this.Aj().y3(System.currentTimeMillis());
            QLog.i("aigc_performance", 1, "{performance} filamentViewV2 first frame time(ms): " + currentTimeMillis);
            SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
            suitPreviewFragment.ak(suitPreviewFragment.currentPatternPosType, SuitPreviewFragment.this.currentColor);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final SuitPreviewFragment suitPreviewFragment2 = SuitPreviewFragment.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.cf
                @Override // java.lang.Runnable
                public final void run() {
                    SuitPreviewFragment.b.c(SuitPreviewFragment.this);
                }
            });
            synchronized (this) {
                this.done = true;
                CancellableContinuation<? super Unit> cancellableContinuation = this.contRef;
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
                this.contRef = null;
                Unit unit = Unit.INSTANCE;
            }
            QLog.i("SuitPreviewFragment", 1, "FIRST_FRAME");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<Integer> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SuitPreviewFragment", 1, "requestAvatarDressData failed: " + message);
            if (SuitPreviewFragment.this.getContext() != null) {
                SuitPreviewFragment.this.fetchAvatarSuccessEvent.postValue(Boolean.FALSE);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }

        public void a(int result) {
            QLog.i("SuitPreviewFragment", 1, "requestAvatarDressData success");
            if (SuitPreviewFragment.this.getContext() != null) {
                SuitPreviewFragment.this.fetchAvatarSuccessEvent.postValue(Boolean.TRUE);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$d", "Lcom/tencent/mobileqq/zplan/aigc/view/CustomRadioButtonGroup$c;", "", "index", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements CustomRadioButtonGroup.c {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.view.CustomRadioButtonGroup.c
        public void a(int index) {
            QLog.e("SuitPreviewFragment", 1, "patternPosTypeButtons onRadioButtonSelect: " + index);
            SuitPreviewFragment.this.currentPatternPosType = index;
            SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
            suitPreviewFragment.ak(index, suitPreviewFragment.currentColor);
            SuitPreviewFragment.this.poseTypeBtnClickParamsMap.put("zplan_clck_paste_way", SuitPreviewFragment.this.jj(index));
            Map map = SuitPreviewFragment.this.poseTypeBtnClickParamsMap;
            SuitPreviewFragment suitPreviewFragment2 = SuitPreviewFragment.this;
            map.put("zplan_default_paste_way", suitPreviewFragment2.jj(suitPreviewFragment2.originPatternPosType));
            Map map2 = SuitPreviewFragment.this.poseTypeBtnClickParamsMap;
            SuitWhiteModelItem selectedWhiteModelItem = SuitPreviewFragment.this.Aj().getSelectedWhiteModelItem();
            map2.put("zplan_model_id", String.valueOf(selectedWhiteModelItem != null ? selectedWhiteModelItem.getItemId() : null));
            zd3.a aVar = SuitPreviewFragment.this.dtReporter;
            if (aVar != null) {
                aVar.t(SuitPreviewFragment.this.rj(), "em_zplan_paste_pick", SuitPreviewFragment.this.poseTypeBtnClickParamsMap);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<uv4.aa> {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.aa result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("SuitPreviewFragment", 1, "onResultSuccess");
            SuitPreviewFragment.this.Cj(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SuitPreviewFragment", 1, "onResultFailure error:" + error + ", message:" + message);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$f", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements uk0.e {
        f() {
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            QLog.d("SuitPreviewFragment", 4, "onEvent, type: " + type + ", eventData: " + eventData);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$g", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "resourcePath", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements com.tencent.mobileqq.zplan.aigc.render.g {
        /* JADX INFO: Access modifiers changed from: package-private */
        public g() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(String resourcePath) {
            Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
            QLog.i("SuitPreviewFragment", 1, "patternPosTypeButtons onAIGCResourceReady: " + resourcePath);
            String str = resourcePath + "/ConfigData/" + SuitPreviewFragment.this.Aj().L2() + "_ParamsConfig.json";
            HashMap hashMap = new HashMap();
            hashMap.put("103", str);
            AigcPreviewBusinessScene aigcPreviewBusinessScene = SuitPreviewFragment.this.scene;
            if (aigcPreviewBusinessScene != null) {
                AigcPreviewBusinessScene.updateUgc$default(aigcPreviewBusinessScene, hashMap, null, 2, null);
            }
            SuitPreviewFragment.this.preUpdateUgcTime = System.currentTimeMillis();
            SuitPreviewFragment.this.isRunning = false;
            SuitPreviewFragment.this.Yj();
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int i3) {
            g.a.e(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean z16) {
            g.a.f(this, z16);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int i3) {
            g.a.a(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    public SuitPreviewFragment() {
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$filamentContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.f163617r32);
            }
        });
        this.filamentContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CustomRadioButtonGroup>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$patternPosTypeButtons$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CustomRadioButtonGroup invoke() {
                return (CustomRadioButtonGroup) SuitPreviewFragment.this.requireView().findViewById(R.id.pnl);
            }
        });
        this.patternPosTypeButtons = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$completeButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Button invoke() {
                return (Button) SuitPreviewFragment.this.requireView().findViewById(R.id.plg);
            }
        });
        this.completeButton = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$continueButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Button invoke() {
                return (Button) SuitPreviewFragment.this.requireView().findViewById(R.id.pme);
            }
        });
        this.continueButton = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$checkButtonMask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.pj_);
            }
        });
        this.checkButtonMask = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$checkButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.pj8);
            }
        });
        this.checkButton = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$checkBtnIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitPreviewFragment.this.requireView().findViewById(R.id.pja);
            }
        });
        this.checkBtnIcon = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$checkBtnDescription$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitPreviewFragment.this.requireView().findViewById(R.id.pj9);
            }
        });
        this.checkBtnDescription = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$shareButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Button invoke() {
                return (Button) SuitPreviewFragment.this.requireView().findViewById(R.id.qkv);
            }
        });
        this.shareButton = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$colorPicker$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.p_l);
            }
        });
        this.colorPicker = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$completeButtonView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.plh);
            }
        });
        this.completeButtonView = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$createButtonView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.pmz);
            }
        });
        this.createButtonView = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$whiteMask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.q7w);
            }
        });
        this.whiteMask = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$syncQQ$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.qp6);
            }
        });
        this.syncQQ = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<QUICheckBox>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$selectSyncImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUICheckBox invoke() {
                return (QUICheckBox) SuitPreviewFragment.this.requireView().findViewById(R.id.f163518qk1);
            }
        });
        this.selectSyncImage = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$dialogViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.ppq);
            }
        });
        this.dialogViewContainer = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<SuitPagView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$previewLightLoopPag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitPagView invoke() {
                return (SuitPagView) SuitPreviewFragment.this.requireView().findViewById(R.id.qou);
            }
        });
        this.previewLightLoopPag = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$completeLoadingIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitPreviewFragment.this.requireView().findViewById(R.id.pli);
            }
        });
        this.completeLoadingIcon = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$parentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitPreviewFragment.this.requireView().findViewById(R.id.qbp);
            }
        });
        this.parentView = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$aiTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitPreviewFragment.this.requireView().findViewById(R.id.p_g);
            }
        });
        this.aiTv = lazy20;
        this.shouldColorPickerShow = true;
        this.shouldShowPatternButtons = true;
        this.currentColor = "#FFFFFF";
        this.originColor = "#FFFFFF";
        this.currentLightEnterPagUrl = "";
        this.currentLightLoopPagUrl = "";
        this.pastePositionTypeList = new ArrayList<>();
        this.poseTypeBtnClickParamsMap = new LinkedHashMap();
        this.colorPickerParamsMap = new LinkedHashMap();
        this.source = "";
        this.avatarDressDataManager = new com.tencent.mobileqq.zplan.aigc.helper.b();
        this.fetchAvatarSuccessEvent = new MutableLiveData<>();
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<SuitCreateTechFragmentViewModel>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitCreateTechFragmentViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(SuitPreviewFragment.this.requireParentFragment()).get(SuitCreateTechFragmentViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026entViewModel::class.java)");
                return (SuitCreateTechFragmentViewModel) viewModel;
            }
        });
        this.vm = lazy21;
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<AigcWatermarkView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$filamentBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AigcWatermarkView invoke() {
                return (AigcWatermarkView) SuitPreviewFragment.this.requireView().findViewById(R.id.pty);
            }
        });
        this.filamentBg = lazy22;
        this.generatePreviewQueue = new ConcurrentLinkedQueue<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuitCreateTechFragmentViewModel Aj() {
        return (SuitCreateTechFragmentViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstraintLayout Bj() {
        Object value = this.whiteMask.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-whiteMask>(...)");
        return (ConstraintLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r4 = kotlin.collections.ArraysKt___ArraysKt.toList(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Cj(uv4.aa result) {
        List emptyList;
        uv4.bk[] bkVarArr = result.f440103a;
        if (bkVarArr == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        QLog.i("SuitPreviewFragment", 1, "handleStoreItemListRsp, originDataListSize:" + emptyList.size());
        Iterator it = emptyList.iterator();
        while (it.hasNext()) {
            uv4.as asVar = ((uv4.bk) it.next()).f440366b.C;
            if (asVar != null && asVar.f440218a == 103) {
                this.colorEditorCfg = ((uv4.bk) emptyList.get(0)).f440366b.C;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ej(SuitPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Pj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Gi(Runnable runnable) {
        while (this.generatePreviewQueue.size() > 0) {
            this.generatePreviewQueue.poll();
        }
        this.generatePreviewQueue.add(runnable);
        Yj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gj(SuitPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.aigc.helper.h hVar = com.tencent.mobileqq.zplan.aigc.helper.h.f330325a;
        boolean z16 = !com.tencent.mobileqq.zplan.aigc.helper.h.f(hVar, "check_sync", false, 2, null);
        hVar.o("check_sync", z16);
        this$0.vj().setChecked(z16);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_is_selected_when_clck", Integer.valueOf(this$0.vj().isChecked() ? 1 : 0));
        zd3.a aVar = this$0.dtReporter;
        if (aVar != null) {
            aVar.t(this$0.vj(), "em_zplan_popular_syn", linkedHashMap);
        }
    }

    private final void Hi() {
        boolean f16 = com.tencent.mobileqq.zplan.aigc.helper.h.f(com.tencent.mobileqq.zplan.aigc.helper.h.f330325a, "check_sync", false, 2, null);
        QLog.i("SuitPreviewFragment", 1, "changeSelectStatus " + f16);
        vj().setChecked(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hj(final SuitPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitPreviewFragment$initView$6$1(null), 3, null);
        com.tencent.mobileqq.zplan.aigc.share.b.f330597a.h();
        this$0.dj().setEnabled(false);
        final long currentTimeMillis = System.currentTimeMillis();
        this$0.Wj();
        this$0.Gi(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initView$lambda$9$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                CreatedClothShowLogic createdClothLogic = SuitPreviewFragment.this.getCreatedClothLogic();
                if (createdClothLogic != null) {
                    final SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
                    final long j3 = currentTimeMillis;
                    createdClothLogic.e(new com.tencent.mobileqq.zplan.aigc.render.g() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initView$6$runnable$1$1
                        @Override // com.tencent.mobileqq.zplan.aigc.render.g
                        public void a(String str) {
                            g.a.b(this, str);
                        }

                        @Override // com.tencent.mobileqq.zplan.aigc.render.g
                        public void b(int i3) {
                            g.a.e(this, i3);
                        }

                        @Override // com.tencent.mobileqq.zplan.aigc.render.g
                        public void c(boolean z16) {
                            g.a.f(this, z16);
                        }

                        @Override // com.tencent.mobileqq.zplan.aigc.render.g
                        public void d(final String resourcePath) {
                            Bitmap aj5;
                            Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
                            SuitPreviewFragment suitPreviewFragment2 = SuitPreviewFragment.this;
                            aj5 = suitPreviewFragment2.aj(suitPreviewFragment2.Aj().L2(), resourcePath);
                            suitPreviewFragment2.Nj(aj5);
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("resourceDuration", String.valueOf(System.currentTimeMillis() - j3));
                            t74.r.e(null, "zplan#aigc#dress#filament#export#publish", linkedHashMap, 1, null);
                            final SuitPreviewFragment suitPreviewFragment3 = SuitPreviewFragment.this;
                            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initView$6$runnable$1$1$onAIGCResourceReady$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    SuitPreviewFragment.this.Qi(resourcePath);
                                }
                            });
                        }

                        @Override // com.tencent.mobileqq.zplan.aigc.render.g
                        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
                            g.a.g(this, z16, aIGCWhiteModel);
                        }

                        @Override // com.tencent.mobileqq.zplan.aigc.render.g
                        public void f(int i3) {
                            g.a.a(this, i3);
                        }

                        @Override // com.tencent.mobileqq.zplan.aigc.render.g
                        public void onScreenShotResult(Bitmap bitmap) {
                            g.a.d(this, bitmap);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ii() {
        Aj().o2().postValue(4);
        rj().setVisibility(8);
        cj().setVisibility(8);
        hj().setVisibility(8);
        Bj().setVisibility(8);
        ej().setVisibility(0);
        bk();
        Vi().setVisibility(0);
        zj().setVisibility(8);
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        SuitParentFragment.Wh((SuitParentFragment) parentFragment, false, 1, null);
        Lj();
        this.completeState = true;
        Kj();
        gj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.cb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitPreviewFragment.Ji(SuitPreviewFragment.this, view);
            }
        });
        Yi().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.cc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitPreviewFragment.Ki(SuitPreviewFragment.this, view);
            }
        });
        wj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.cd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitPreviewFragment.Li(SuitPreviewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.sqshow.zootopia.nativeui.data.j Ij(ViewGroup container, LifecycleOwner lifecycleOwner) {
        this.dialogController = new ga4.i(container);
        com.tencent.sqshow.zootopia.nativeui.data.repo.i iVar = new com.tencent.sqshow.zootopia.nativeui.data.repo.i();
        com.tencent.sqshow.zootopia.nativeui.data.repo.p pVar = new com.tencent.sqshow.zootopia.nativeui.data.repo.p();
        this.aigcDressControllerListener = new a.InterfaceC0184a() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$makeUpChannel$1
            @Override // ce3.a.InterfaceC0184a
            public void a(qu4.c colorInfo, boolean addToHistory) {
                Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "SuitPreviewFragment_onModifyColorInfo", null, null, null, new SuitPreviewFragment$makeUpChannel$1$onModifyColorInfo$1(SuitPreviewFragment.this, colorInfo, null), 14, null);
                }
            }
        };
        ce3.a aVar = new ce3.a(pVar, new WeakReference(this.aigcDressControllerListener));
        ga4.i iVar2 = this.dialogController;
        Intrinsics.checkNotNull(iVar2);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar2);
        jVar.Z(lifecycleOwner);
        jVar.T(iVar);
        jVar.Q(aVar);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(SuitPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.qj().getVisibility() != 8) {
            zd3.a aVar = this$0.dtReporter;
            if (aVar != null) {
                zd3.a.v(aVar, this$0.gj(), "em_zplan_continue_create", null, 4, null);
            }
            this$0.qj().setVisibility(8);
        }
        Fragment parentFragment = this$0.getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).Wi();
    }

    private final ArrayList<PatternPositionType> Jj() {
        boolean z16;
        AIGCWhiteModel aigcWhiteModel;
        ModelExtraInfo modelExtraInfo;
        List<ModelStyle> modelStyles;
        ArrayList<PatternPositionType> arrayList = new ArrayList<>();
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        CreatedClothShowLogic createdClothLogic = ((SuitParentFragment) parentFragment).getCreatedClothLogic();
        this.createdClothLogic = createdClothLogic;
        Integer valueOf = createdClothLogic != null ? Integer.valueOf(createdClothLogic.getCurrentPatternPosType()) : null;
        Intrinsics.checkNotNull(valueOf);
        int intValue = valueOf.intValue();
        this.currentPatternPosType = intValue;
        this.originPatternPosType = intValue;
        SuitWhiteModelItem selectedWhiteModelItem = Aj().getSelectedWhiteModelItem();
        if (selectedWhiteModelItem == null || (aigcWhiteModel = selectedWhiteModelItem.getAigcWhiteModel()) == null || (modelExtraInfo = aigcWhiteModel.getModelExtraInfo()) == null || (modelStyles = modelExtraInfo.getModelStyles()) == null) {
            z16 = false;
        } else {
            z16 = false;
            int i3 = 0;
            for (Object obj : modelStyles) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ModelStyle modelStyle = (ModelStyle) obj;
                arrayList.add(new PatternPositionType(i3, modelStyle.getStyleName(), i3, modelStyle));
                int lj5 = lj(modelStyle.getStyleName());
                if (!Intrinsics.areEqual(modelStyle.getStyleName(), "\u5168\u8eab")) {
                    z16 = true;
                }
                rj().b(lj5, modelStyle.getStyleName(), this.currentPatternPosType == i3);
                i3 = i16;
            }
        }
        boolean z17 = rj().getChildCount() > 1;
        this.shouldShowPatternButtons = z17;
        if (!z17) {
            rj().setVisibility(8);
            this.shouldColorPickerShow = z16;
        } else {
            rj().setVisibility(0);
            this.shouldColorPickerShow = true;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(SuitPreviewFragment this$0, View view) {
        List mutableListOf;
        long[] longArray;
        long[] longArray2;
        long[] longArray3;
        long[] longArray4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(this$0.Aj().L2()));
        bv4.e eVar = new bv4.e();
        int b26 = this$0.Aj().b2(String.valueOf(this$0.Aj().getCurrentItemId()));
        if (b26 == 1) {
            longArray = CollectionsKt___CollectionsKt.toLongArray(mutableListOf);
            eVar.f29274a = longArray;
        } else if (b26 == 2) {
            longArray2 = CollectionsKt___CollectionsKt.toLongArray(mutableListOf);
            eVar.f29275b = longArray2;
        } else if (b26 != 3) {
            QLog.e("SuitPreviewFragment", 1, "current item " + this$0.Aj().getCurrentItemId() + " does not in any white model list");
        } else {
            List list = mutableListOf;
            longArray3 = CollectionsKt___CollectionsKt.toLongArray(list);
            eVar.f29274a = longArray3;
            longArray4 = CollectionsKt___CollectionsKt.toLongArray(list);
            eVar.f29275b = longArray4;
        }
        String b16 = SuitOutfitHelper.f330689a.b(eVar, "aigc_match");
        if ((b16.length() > 0) && this$0.getContext() != null) {
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            iZPlanApi.launchScheme(requireContext, b16);
        }
        this$0.requireActivity().overridePendingTransition(0, 0);
        Fragment parentFragment = this$0.getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        Fragment parentFragment2 = this$0.getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        if (!((SuitParentFragment) parentFragment).Gi(((SuitParentFragment) parentFragment2).getAvatarFrom()) && !this$0.Aj().getNeedFromNewPreview()) {
            this$0.requireActivity().finish();
        } else {
            QLog.i("SuitPreviewFragment", 1, "onBackPressed back avatar");
            this$0.onBackPressed();
        }
        zd3.a aVar = this$0.dtReporter;
        if (aVar != null) {
            zd3.a.v(aVar, this$0.Yi(), "em_zplan_to_view", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(SuitPreviewFragment this$0, View view) {
        uv4.bn data;
        uv4.az azVar;
        com.tencent.mobileqq.zplan.aigc.share.bl blVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime < 1000) {
            QLog.i("SuitPreviewFragment", 1, "click interval is too small");
            return;
        }
        this$0.lastClickTime = currentTimeMillis;
        com.tencent.mobileqq.zplan.aigc.share.bl blVar2 = this$0.suitShareDialog;
        boolean z16 = false;
        if (blVar2 != null && blVar2.b()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("SuitPreviewFragment", 1, "dialog is showing");
            return;
        }
        Bitmap sj5 = this$0.sj(this$0.Aj().L2());
        if (sj5 != null) {
            SuitWhiteModelItem selectedWhiteModelItem = this$0.Aj().getSelectedWhiteModelItem();
            if (selectedWhiteModelItem != null && (data = selectedWhiteModelItem.getData()) != null && (azVar = data.f440382g) != null && (blVar = this$0.suitShareDialog) != null) {
                String description = this$0.Aj().getDescription();
                String str = azVar.f440277d;
                Intrinsics.checkNotNullExpressionValue(str, "it1.name");
                blVar.d(description, str, this$0.Aj().L2(), "1", sj5, this$0.dtReporter, this$0.gender, this$0.source);
            }
        } else {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "SuitPreviewFragment", null, null, null, new SuitPreviewFragment$changeUIofComplete$3$2(this$0, null), 14, null);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_clothes_ugcid", Long.valueOf(this$0.Aj().L2()));
        zd3.a aVar = this$0.dtReporter;
        if (aVar != null) {
            aVar.t(this$0.wj(), SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, linkedHashMap);
        }
    }

    private final void Lj() {
        if (this.completeState) {
            zd3.a aVar = this.dtReporter;
            if (aVar != null) {
                zd3.a.A(aVar, Yi(), "em_zplan_to_view", null, 4, null);
            }
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 != null) {
                zd3.a.A(aVar2, gj(), "em_zplan_continue_create", null, 4, null);
                return;
            }
            return;
        }
        zd3.a aVar3 = this.dtReporter;
        if (aVar3 != null) {
            aVar3.z(cj(), "em_zplan_color_pick", this.colorPickerParamsMap);
        }
        zd3.a aVar4 = this.dtReporter;
        if (aVar4 != null) {
            aVar4.z(rj(), "em_zplan_paste_pick", this.poseTypeBtnClickParamsMap);
        }
        zd3.a aVar5 = this.dtReporter;
        if (aVar5 != null) {
            zd3.a.A(aVar5, dj(), "em_zplan_create_complete", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(SuitPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cj().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(SuitPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cj().setVisibility(this$0.shouldColorPickerShow ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Pi(int color) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(color & 16777215)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final void Pj() {
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$showColorEditDialog$1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$showColorEditDialog$1$a", "Lga4/h;", "Lga4/g;", "panelDialog", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements ga4.h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ SuitPreviewFragment f330059a;

                a(SuitPreviewFragment suitPreviewFragment) {
                    this.f330059a = suitPreviewFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(SuitPreviewFragment this$0) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Fragment parentFragment = this$0.getParentFragment();
                    Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                    ((SuitParentFragment) parentFragment).Vh(false);
                }

                @Override // ga4.h
                public void a(ga4.g panelDialog) {
                    Map map;
                    Map<String, Object> map2;
                    Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
                    this.f330059a.Mi(true);
                    SuitPreviewFragment suitPreviewFragment = this.f330059a;
                    suitPreviewFragment.originColor = suitPreviewFragment.currentColor;
                    Fragment parentFragment = this.f330059a.getParentFragment();
                    Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                    ((SuitParentFragment) parentFragment).Vh(true);
                    QLog.i("SuitPreviewFragment", 1, "color panel onDismiss");
                    map = this.f330059a.colorPickerParamsMap;
                    map.put("zplan_create_color_value", this.f330059a.currentColor);
                    zd3.a aVar = this.f330059a.dtReporter;
                    if (aVar != null) {
                        ConstraintLayout cj5 = this.f330059a.cj();
                        map2 = this.f330059a.colorPickerParamsMap;
                        aVar.t(cj5, "em_zplan_color_pick", map2);
                    }
                }

                @Override // ga4.h
                public void b(ga4.g panelDialog) {
                    Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
                    h.a.a(this, panelDialog);
                    MqqHandler uIHandler = ThreadManager.getUIHandler();
                    final SuitPreviewFragment suitPreviewFragment = this.f330059a;
                    uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.cg
                        @Override // java.lang.Runnable
                        public final void run() {
                            SuitPreviewFragment$showColorEditDialog$1.a.d(SuitPreviewFragment.this);
                        }
                    });
                    SuitPreviewFragment suitPreviewFragment2 = this.f330059a;
                    if (Intrinsics.areEqual(suitPreviewFragment2.jj(suitPreviewFragment2.currentPatternPosType), "\u5168\u8eab")) {
                        this.f330059a.Uj(ZPlanAIGCStatusCode.CREATE_AIGC_PREVIEW_COLOR_PICKER_TIP.getMessage());
                    }
                    this.f330059a.Mi(false);
                }
            }

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
                FrameLayout kj5;
                com.tencent.sqshow.zootopia.nativeui.data.j Ij;
                uv4.as asVar;
                uv4.as asVar2;
                uv4.as asVar3;
                ga4.i iVar;
                ga4.h hVar;
                uv4.as Ui;
                SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
                kj5 = suitPreviewFragment.kj();
                Intrinsics.checkNotNull(kj5, "null cannot be cast to non-null type android.view.ViewGroup");
                LifecycleOwner viewLifecycleOwner = SuitPreviewFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                Ij = suitPreviewFragment.Ij(kj5, viewLifecycleOwner);
                suitPreviewFragment.Oj(Ij);
                qu4.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.p().b().getAvatarCharacter().f429575d;
                if (cVar == null) {
                    cVar = new qu4.c();
                }
                qu4.d[] dVarArr = cVar.f429581b;
                Intrinsics.checkNotNullExpressionValue(dVarArr, "currentColorInfo.slotArr");
                SuitPreviewFragment suitPreviewFragment2 = SuitPreviewFragment.this;
                for (qu4.d dVar : dVarArr) {
                    if (dVar.f429583a == 103) {
                        dVar.f429585c.f429637b = Color.parseColor(suitPreviewFragment2.currentColor);
                        suitPreviewFragment2.ak(suitPreviewFragment2.currentPatternPosType, suitPreviewFragment2.currentColor);
                    }
                }
                asVar = SuitPreviewFragment.this.colorEditorCfg;
                if (asVar == null) {
                    QLog.i("SuitPreviewFragment", 1, "colorEditorCfg is null, use fake data");
                    SuitPreviewFragment suitPreviewFragment3 = SuitPreviewFragment.this;
                    Ui = suitPreviewFragment3.Ui();
                    suitPreviewFragment3.colorEditorCfg = Ui;
                }
                asVar2 = SuitPreviewFragment.this.colorEditorCfg;
                Integer valueOf = asVar2 != null ? Integer.valueOf(asVar2.f440218a) : null;
                QLog.i("SuitPreviewFragment", 1, "showColorEditDialog slotId:" + valueOf);
                ga4.j jVar = ga4.j.f401682a;
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = SuitPreviewFragment.this.getMChannel();
                Intrinsics.checkNotNull(mChannel);
                Context requireContext = SuitPreviewFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                DialogCustomData dialogCustomData = new DialogCustomData(null, null, null, null, null, 0, 63, null);
                SuitPreviewFragment suitPreviewFragment4 = SuitPreviewFragment.this;
                Intrinsics.checkNotNull(valueOf);
                int intValue = valueOf.intValue();
                asVar3 = suitPreviewFragment4.colorEditorCfg;
                Intrinsics.checkNotNull(asVar3);
                dialogCustomData.g(new ColorPanelData(intValue, cVar, asVar3, -1));
                Unit unit = Unit.INSTANCE;
                ga4.g a16 = jVar.a(7, mChannel, requireContext, dialogCustomData, true);
                SuitPreviewFragment suitPreviewFragment5 = SuitPreviewFragment.this;
                suitPreviewFragment5.dialogControllerListener = new a(suitPreviewFragment5);
                iVar = SuitPreviewFragment.this.dialogController;
                if (iVar != null) {
                    hVar = SuitPreviewFragment.this.dialogControllerListener;
                    iVar.c(new WeakReference<>(hVar));
                }
                a16.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Qi(String resourcePath) {
        Long l3;
        SuitWhiteModelItem selectedWhiteModelItem;
        String itemId;
        long L2 = Aj().L2();
        try {
            selectedWhiteModelItem = Aj().getSelectedWhiteModelItem();
        } catch (Throwable unused) {
        }
        if (selectedWhiteModelItem != null && (itemId = selectedWhiteModelItem.getItemId()) != null) {
            l3 = Long.valueOf(Long.parseLong(itemId));
            if (l3 != null) {
                if ((resourcePath.length() == 0) == false) {
                    QLog.i("SuitPreviewFragment", 1, "ready for publish, ugcId: " + L2 + ", itemId: " + l3);
                    Context requireContext = requireContext();
                    if (requireContext == null) {
                        return;
                    }
                    if (!NetworkUtil.isNetSupport(requireContext)) {
                        QLog.e("SuitPreviewFragment", 1, "trigger publish failed, network unavailable");
                        Si(this, ZPlanAIGCStatusCode.NETWORK_UNAVAILABLE_V2.getMessage(), null, 2, null);
                        return;
                    }
                    String str = "\u667a\u7ed8\u00b7" + Aj().getName();
                    this.publishListener = new nk3.b() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$doOnAIGCCreateResourceReady$1
                        @Override // nk3.b
                        public void a(ZPlanAIGCStatusCode errCode, String errMsg) {
                            Intrinsics.checkNotNullParameter(errCode, "errCode");
                            boolean z16 = true;
                            QLog.e("SuitPreviewFragment", 1, "trigger publish failed, errMsg: " + errMsg + "\uff0c " + errCode);
                            if (errMsg != null && errMsg.length() != 0) {
                                z16 = false;
                            }
                            if (z16) {
                                errMsg = errCode.getMessage();
                            }
                            SuitPreviewFragment.Si(SuitPreviewFragment.this, errMsg, null, 2, null);
                        }

                        @Override // nk3.b
                        public void onSuccess(final int couponCount) {
                            final SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
                            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$doOnAIGCCreateResourceReady$1$onSuccess$1

                                /* JADX INFO: Access modifiers changed from: package-private */
                                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                                @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$doOnAIGCCreateResourceReady$1$onSuccess$1$1", f = "SuitPreviewFragment.kt", i = {}, l = {gdt_analysis_event.EVENT_VIDEO_STATE_PREPARED}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$doOnAIGCCreateResourceReady$1$onSuccess$1$1, reason: invalid class name */
                                /* loaded from: classes35.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    int label;
                                    final /* synthetic */ SuitPreviewFragment this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(SuitPreviewFragment suitPreviewFragment, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.this$0 = suitPreviewFragment;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.this$0, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended;
                                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i3 = this.label;
                                        if (i3 == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            AigcPreviewBusinessScene aigcPreviewBusinessScene = this.this$0.scene;
                                            if (aigcPreviewBusinessScene != null) {
                                                this.label = 1;
                                                if (aigcPreviewBusinessScene.loadCompleteAction(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            }
                                        } else if (i3 == 1) {
                                            ResultKt.throwOnFailure(obj);
                                        } else {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        AigcPreviewBusinessScene aigcPreviewBusinessScene2 = this.this$0.scene;
                                        if (aigcPreviewBusinessScene2 != null) {
                                            aigcPreviewBusinessScene2.switchCamera("{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,13.03359],\"target\":[0.0,0.78022,0.0],\"upward\":[0.0,1.0,0.0]}}");
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    int i3;
                                    ArrayList arrayList;
                                    QUICheckBox vj5;
                                    int i16 = 1;
                                    QLog.i("SuitPreviewFragment", 1, "trigger publish succeed.");
                                    if (SuitPreviewFragment.this.getParentFragment() == null) {
                                        QLog.i("SuitPreviewFragment", 1, "parentFragment has been released.");
                                        return;
                                    }
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    boolean isOfficial = SuitPreviewFragment.this.Aj().getIsOfficial();
                                    if (isOfficial) {
                                        i3 = 1;
                                    } else {
                                        if (isOfficial) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        i3 = 0;
                                    }
                                    linkedHashMap.put("zplan_is_preintent", Integer.valueOf(i3));
                                    linkedHashMap.put("zplan_box_text", SuitPreviewFragment.this.Aj().getDescription());
                                    SuitWhiteModelItem selectedWhiteModelItem2 = SuitPreviewFragment.this.Aj().getSelectedWhiteModelItem();
                                    linkedHashMap.put("zplan_model_id", String.valueOf(selectedWhiteModelItem2 != null ? selectedWhiteModelItem2.getItemId() : null));
                                    linkedHashMap.put("zplan_intent_prompt", SuitPreviewFragment.this.Aj().getPrompt());
                                    linkedHashMap.put("zplan_model_color", SuitPreviewFragment.this.currentColor);
                                    arrayList = SuitPreviewFragment.this.pastePositionTypeList;
                                    linkedHashMap.put("zplan_paste_way", ((PatternPositionType) arrayList.get(SuitPreviewFragment.this.currentPatternPosType)).getText());
                                    linkedHashMap.put("zplan_trace_id", String.valueOf(SuitPreviewFragment.this.Aj().L2()));
                                    linkedHashMap.put("zplan_keywords_clothes_num", Integer.valueOf(SuitPreviewFragment.this.Aj().getClothNumber()));
                                    Fragment parentFragment = SuitPreviewFragment.this.getParentFragment();
                                    Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                                    Fragment parentFragment2 = SuitPreviewFragment.this.getParentFragment();
                                    Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                                    if (!((SuitParentFragment) parentFragment).Gi(((SuitParentFragment) parentFragment2).getAvatarFrom()) && !SuitPreviewFragment.this.Aj().getNeedFromNewPreview()) {
                                        i16 = 0;
                                    }
                                    linkedHashMap.put("zplan_is_copy_clothes", Integer.valueOf(i16));
                                    vj5 = SuitPreviewFragment.this.vj();
                                    linkedHashMap.put("zplan_is_selected_when_clck", Integer.valueOf(vj5.isChecked() ? 1 : 0));
                                    zd3.a aVar = SuitPreviewFragment.this.dtReporter;
                                    if (aVar != null) {
                                        aVar.t(SuitPreviewFragment.this.dj(), "em_zplan_create_complete", linkedHashMap);
                                    }
                                    SuitPreviewFragment.this.Ri(ZPlanAIGCStatusCode.CREATE_AIGC_PUBLISH_SUCCEED_V2.getMessage(), Boolean.TRUE);
                                    if (SuitPreviewFragment.this.getParentFragment() != null) {
                                        Fragment parentFragment3 = SuitPreviewFragment.this.getParentFragment();
                                        Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                                        ((SuitParentFragment) parentFragment3).Vh(false);
                                    }
                                    SuitPreviewFragment.this.Aj().L3(couponCount);
                                    SuitPreviewFragment.this.Ii();
                                    SuitPreviewFragment.this.ck(false);
                                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                                    if (f16 != null) {
                                        CorountineFunKt.e(f16, "SuitPreviewFragment", null, null, null, new AnonymousClass1(SuitPreviewFragment.this, null), 14, null);
                                    }
                                }
                            });
                        }
                    };
                    AIGCCreatePublishHelper.f330226a.a(L2, l3.longValue(), resourcePath, Aj().getIsOfficial(), str, Aj().getDescription(), Aj().getPrompt(), com.tencent.mobileqq.zplan.aigc.helper.h.f(com.tencent.mobileqq.zplan.aigc.helper.h.f330325a, "check_sync", false, 2, null) ? 1 : 0, this.publishListener);
                    return;
                }
            }
            QLog.e("SuitPreviewFragment", 1, "onAIGCResourceReady, params for publish invalid.");
            Si(this, ZPlanAIGCStatusCode.NORMAL_ERROR.getMessage(), null, 2, null);
        }
        l3 = null;
        if (l3 != null) {
        }
        QLog.e("SuitPreviewFragment", 1, "onAIGCResourceReady, params for publish invalid.");
        Si(this, ZPlanAIGCStatusCode.NORMAL_ERROR.getMessage(), null, 2, null);
    }

    private final void Qj() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.br
            @Override // java.lang.Runnable
            public final void run() {
                SuitPreviewFragment.Rj(SuitPreviewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri(final String toastMsg, Boolean needFinishFragment) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.ca
            @Override // java.lang.Runnable
            public final void run() {
                SuitPreviewFragment.Ti(toastMsg, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rj(final SuitPreviewFragment this$0) {
        final String str;
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this$0.getContext(), 230);
        new LinkedHashMap();
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
            str = "";
        }
        createCustomDialog.setTitle(this$0.getResources().getString(R.string.xl5)).setNegativeButton(this$0.getResources().getString(R.string.xkv), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bs
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SuitPreviewFragment.Sj(SuitPreviewFragment.this, str, dialogInterface, i3);
            }
        }).setPositiveButton(this$0.getResources().getString(R.string.xkz), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bt
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SuitPreviewFragment.Tj(SuitPreviewFragment.this, str, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sj(SuitPreviewFragment this$0, String source, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        zd3.a aVar = this$0.dtReporter;
        if (aVar != null) {
            aVar.q(source, this$0.Aj().v2(), 1);
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(String toastMsg, SuitPreviewFragment this$0) {
        String str;
        zd3.a aVar;
        Intent intent;
        Intrinsics.checkNotNullParameter(toastMsg, "$toastMsg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
            str = "";
        }
        if (Intrinsics.areEqual(toastMsg, ZPlanAIGCStatusCode.AIGC_PIC_AUDIT_BLOCK.getMessage())) {
            zd3.a aVar2 = this$0.dtReporter;
            if (aVar2 != null) {
                aVar2.h(str, this$0.Aj().v2(), 4, String.valueOf(this$0.Aj().L2()));
            }
            this$0.Qj();
        } else {
            if (Intrinsics.areEqual(toastMsg, "\u5b89\u5168\u56de\u8c03\u8d85\u65f6")) {
                toastMsg = ZPlanAIGCStatusCode.SERVICE_SYSTEM_BUSY.getMessage();
                zd3.a aVar3 = this$0.dtReporter;
                if (aVar3 != null) {
                    aVar3.h(str, this$0.Aj().v2(), 3, String.valueOf(this$0.Aj().L2()));
                }
            } else if (!Intrinsics.areEqual(toastMsg, ZPlanAIGCStatusCode.CREATE_AIGC_PUBLISH_SUCCEED_V2.getMessage()) && (aVar = this$0.dtReporter) != null) {
                aVar.h(str, this$0.Aj().v2(), 1, String.valueOf(this$0.Aj().L2()));
            }
            this$0.Uj(toastMsg);
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 == null || activity2.isFinishing()) {
            return;
        }
        this$0.Xj();
        this$0.dj().setEnabled(true);
        this$0.isRunning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tj(SuitPreviewFragment this$0, String source, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        zd3.a aVar = this$0.dtReporter;
        if (aVar != null) {
            aVar.q(source, this$0.Aj().v2(), 2);
        }
        Fragment parentFragment = this$0.getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).Wi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final uv4.as Ui() {
        uv4.as asVar = new uv4.as();
        asVar.f440218a = 103;
        asVar.f440219b = 1;
        qu4.p[] pVarArr = new qu4.p[18];
        int[] iArr = {16248809, 11972528, 11378836, 16510407, 15911445, 13807776, 14328979, 14059396, 10390918, 13026470, 11781050, 8827849, 10399945, 15645639, 13799050, 16686288, 14198978, 13152464};
        for (int i3 = 0; i3 < 18; i3++) {
            int i16 = iArr[i3];
            qu4.p pVar = new qu4.p();
            pVar.f429636a = 0;
            pVar.f429637b = i16;
            pVarArr[i3] = pVar;
        }
        asVar.f440220c = pVarArr;
        return asVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uj(final String toastWords) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$showStatusToast$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (SuitPreviewFragment.this.getContext() != null) {
                    QQToast.makeText(SuitPreviewFragment.this.getContext(), toastWords, 0).show();
                }
            }
        });
    }

    private final TextView Vi() {
        Object value = this.aiTv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-aiTv>(...)");
        return (TextView) value;
    }

    private final void Vj() {
        View view = this.textureView;
        if (view != null) {
            view.setZ(0.0f);
        }
        uj().setZ(-1.0f);
        mj().setZ(-2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Wi() {
        Object value = this.checkBtnDescription.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-checkBtnDescription>(...)");
        return (TextView) value;
    }

    private final void Wj() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        fj().setVisibility(0);
        fj().startAnimation(rotateAnimation);
        this.createLoadingStartTime = System.currentTimeMillis();
        dj().setText("");
        this.isLoading = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Xi() {
        Object value = this.checkBtnIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-checkBtnIcon>(...)");
        return (ImageView) value;
    }

    private final void Xj() {
        String str;
        Intent intent;
        fj().setVisibility(8);
        fj().clearAnimation();
        dj().setText("\u5b8c\u6210\u521b\u4f5c");
        this.isLoading = false;
        long currentTimeMillis = System.currentTimeMillis() - this.createLoadingStartTime;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
            str = "";
        }
        zd3.a aVar = this.dtReporter;
        if (aVar != null) {
            aVar.i(str, Aj().v2(), (int) currentTimeMillis, String.valueOf(Aj().L2()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout Yi() {
        Object value = this.checkButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-checkButton>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yj() {
        if (!this.isRunning && this.generatePreviewQueue.size() > 0) {
            this.isRunning = true;
            Runnable poll = this.generatePreviewQueue.poll();
            if (poll != null) {
                poll.run();
                return;
            } else {
                Yj();
                return;
            }
        }
        if (this.generatePreviewQueue.size() == 0) {
            this.isRunning = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout Zi() {
        Object value = this.checkButtonMask.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-checkButtonMask>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ak(final int patternPos, final String colorString) {
        Gi(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$updateAvatar$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.zplan.aigc.render.g gVar;
                SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
                suitPreviewFragment.previewResourceListener = new SuitPreviewFragment.g();
                CreatedClothShowLogic createdClothLogic = SuitPreviewFragment.this.getCreatedClothLogic();
                if (createdClothLogic != null) {
                    int i3 = patternPos;
                    String str = colorString;
                    gVar = SuitPreviewFragment.this.previewResourceListener;
                    createdClothLogic.f(i3, str, new WeakReference<>(gVar));
                }
            }
        });
    }

    private final void bk() {
        Yi().setEnabled(false);
        Zi().setVisibility(0);
        Wi().setText("\u751f\u6210\u4e2d...3");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$updateCheckBtnInfo$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                final SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$updateCheckBtnInfo$updateCheckButtonTask1$1$1
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
                        TextView Wi;
                        if (SuitPreviewFragment.this.getView() == null) {
                            return;
                        }
                        Wi = SuitPreviewFragment.this.Wi();
                        Wi.setText("\u751f\u6210\u4e2d...2");
                    }
                });
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$updateCheckBtnInfo$$inlined$Runnable$2
            @Override // java.lang.Runnable
            public final void run() {
                final SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$updateCheckBtnInfo$updateCheckButtonTask2$1$1
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
                        TextView Wi;
                        if (SuitPreviewFragment.this.getView() == null) {
                            return;
                        }
                        Wi = SuitPreviewFragment.this.Wi();
                        Wi.setText("\u751f\u6210\u4e2d...1");
                    }
                });
            }
        };
        Runnable runnable3 = new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$updateCheckBtnInfo$$inlined$Runnable$3
            @Override // java.lang.Runnable
            public final void run() {
                final SuitPreviewFragment suitPreviewFragment = SuitPreviewFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$updateCheckBtnInfo$updateCheckButtonTask3$1$1
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
                        LinearLayout Zi;
                        LinearLayout Yi;
                        ImageView Xi;
                        TextView Wi;
                        if (SuitPreviewFragment.this.getView() == null) {
                            return;
                        }
                        Zi = SuitPreviewFragment.this.Zi();
                        Zi.setVisibility(8);
                        Yi = SuitPreviewFragment.this.Yi();
                        Yi.setEnabled(true);
                        Xi = SuitPreviewFragment.this.Xi();
                        Xi.setVisibility(0);
                        Wi = SuitPreviewFragment.this.Wi();
                        Wi.setText("\u53bb\u8bd5\u7a7f");
                    }
                });
            }
        };
        ThreadManagerV2.executeDelay(runnable, 16, null, true, 1000L);
        ThreadManagerV2.executeDelay(runnable2, 16, null, true, 2000L);
        ThreadManagerV2.executeDelay(runnable3, 16, null, true, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstraintLayout cj() {
        Object value = this.colorPicker.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-colorPicker>(...)");
        return (ConstraintLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Button dj() {
        Object value = this.completeButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-completeButton>(...)");
        return (Button) value;
    }

    private final ConstraintLayout ej() {
        Object value = this.completeButtonView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-completeButtonView>(...)");
        return (ConstraintLayout) value;
    }

    private final ImageView fj() {
        Object value = this.completeLoadingIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-completeLoadingIcon>(...)");
        return (ImageView) value;
    }

    private final Button gj() {
        Object value = this.continueButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-continueButton>(...)");
        return (Button) value;
    }

    private final FrameLayout hj() {
        Object value = this.createButtonView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createButtonView>(...)");
        return (FrameLayout) value;
    }

    private final void initView() {
        QLog.i("SuitPreviewFragment", 1, "initView");
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).Vh(true);
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        SuitParentFragment.Yh((SuitParentFragment) parentFragment2, false, 1, null);
        mj().setText(MobileQQ.sMobileQQ.getLastLoginUin() + "\u5236\u4f5c\u4e2d");
        cj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitPreviewFragment.Ej(SuitPreviewFragment.this, view);
            }
        });
        cj().setVisibility(8);
        nj().setVisibility(4);
        Fragment parentFragment3 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        this.createdClothLogic = ((SuitParentFragment) parentFragment3).getCreatedClothLogic();
        this.suitShareDialog = new com.tencent.mobileqq.zplan.aigc.share.bl();
        this.qqHeadDrawable = oj();
        long currentTimeMillis = System.currentTimeMillis() - Aj().getPerformanceTimeStamp();
        Aj().y3(System.currentTimeMillis());
        QLog.i("aigc_performance", 1, "{performance} switch fragment time(ms): " + currentTimeMillis);
        MutableLiveData<Boolean> mutableLiveData = this.fetchAvatarSuccessEvent;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$initView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (bool.booleanValue()) {
                    SuitPreviewFragment.this.Zj();
                } else {
                    QLog.e("SuitPreviewFragment", 1, "fetchAvatarData failed");
                    SuitPreviewFragment.this.Uj(ZPlanAIGCStatusCode.NORMAL_ERROR.getMessage());
                }
            }
        };
        mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.bu
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitPreviewFragment.Fj(Function1.this, obj);
            }
        });
        if (!com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.f()) {
            this.avatarDressDataManager.g(null, false, new c());
        } else {
            QLog.i("SuitPreviewFragment", 1, "avatar is initialized");
            Zj();
        }
        this.pastePositionTypeList = Jj();
        rj().setSelectCallback(new d());
        rj().setVisibility(8);
        Hi();
        vj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitPreviewFragment.Gj(SuitPreviewFragment.this, view);
            }
        });
        dj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitPreviewFragment.Hj(SuitPreviewFragment.this, view);
            }
        });
        dj().setVisibility(8);
        zj().setVisibility(8);
        Bj().setVisibility(8);
        uj().x();
        QLog.i("SuitPreviewFragment", 1, "initView end");
    }

    private final void initViewModel() {
        CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
        Integer valueOf = createdClothShowLogic != null ? Integer.valueOf(createdClothShowLogic.getCurrentPatternPosType()) : null;
        Intrinsics.checkNotNull(valueOf);
        this.currentPatternPosType = valueOf.intValue();
        CreatedClothShowLogic createdClothShowLogic2 = this.createdClothLogic;
        String currentColorString = createdClothShowLogic2 != null ? createdClothShowLogic2.getCurrentColorString() : null;
        Intrinsics.checkNotNull(currentColorString);
        this.currentColor = currentColorString;
        this.originColor = currentColorString;
        Mj();
        Aj().F3(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String jj(int index) {
        int i3 = 0;
        for (Object obj : this.pastePositionTypeList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            PatternPositionType patternPositionType = (PatternPositionType) obj;
            if (index == i3) {
                return patternPositionType.getText();
            }
            i3 = i16;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout kj() {
        Object value = this.dialogViewContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dialogViewContainer>(...)");
        return (FrameLayout) value;
    }

    private final int lj(String string) {
        int hashCode = string.hashCode();
        if (hashCode == 682563) {
            if (string.equals("\u5168\u8eab")) {
                return R.drawable.idn;
            }
            return 0;
        }
        if (hashCode != 752264) {
            if (hashCode == 1156515 && string.equals("\u8eaf\u5e72")) {
                return R.drawable.idm;
            }
            return 0;
        }
        if (string.equals("\u5c45\u4e2d")) {
            return R.drawable.idl;
        }
        return 0;
    }

    private final AigcWatermarkView mj() {
        Object value = this.filamentBg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filamentBg>(...)");
        return (AigcWatermarkView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout nj() {
        Object value = this.filamentContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filamentContainer>(...)");
        return (FrameLayout) value;
    }

    private final Drawable oj() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime.getCurrentUin();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        FaceDrawable outboundUserFaceDrawable = FaceDrawable.getOutboundUserFaceDrawable(appInterface, currentUin, (byte) 3);
        if (outboundUserFaceDrawable != null) {
            return outboundUserFaceDrawable;
        }
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(appInterface, 1, currentUin, 3, defaultDrawable, defaultDrawable, null);
        Intrinsics.checkNotNullExpressionValue(faceDrawable, "run {\n            val de\u2026l\n            )\n        }");
        return faceDrawable;
    }

    private final ConstraintLayout qj() {
        Object value = this.parentView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-parentView>(...)");
        return (ConstraintLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomRadioButtonGroup rj() {
        Object value = this.patternPosTypeButtons.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-patternPosTypeButtons>(...)");
        return (CustomRadioButtonGroup) value;
    }

    private final Bitmap sj(long ugcId) {
        if (!com.tencent.mobileqq.zplan.aigc.share.b.f330597a.d() || tj(ugcId, 0, 0) == null || tj(ugcId, 1, 0) == null) {
            return null;
        }
        return tj(ugcId, 2, 0);
    }

    private final Bitmap tj(long ugcId, int type, int flag) {
        String str = "temp_suit_share_" + ugcId + "_" + type + "_" + flag + ".png";
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "suit_cache_dir").getAbsolutePath()));
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        File file2 = new File(file.getAbsolutePath(), str);
        if (file2.exists()) {
            return BitmapFactory.decodeFile(file2.getAbsolutePath());
        }
        return null;
    }

    private final SuitPagView uj() {
        Object value = this.previewLightLoopPag.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-previewLightLoopPag>(...)");
        return (SuitPagView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUICheckBox vj() {
        Object value = this.selectSyncImage.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-selectSyncImage>(...)");
        return (QUICheckBox) value;
    }

    private final Button wj() {
        Object value = this.shareButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shareButton>(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout zj() {
        Object value = this.syncQQ.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-syncQQ>(...)");
        return (LinearLayout) value;
    }

    public final void Nj(Bitmap bitmap) {
        this.clothBitmap = bitmap;
    }

    public final void Oj(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        this.mChannel = jVar;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* renamed from: bj, reason: from getter */
    public final Bitmap getClothBitmap() {
        return this.clothBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dgb;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* renamed from: ij, reason: from getter */
    public final CreatedClothShowLogic getCreatedClothLogic() {
        return this.createdClothLogic;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d("SuitPreviewFragment", 1, "onAttach");
        super.onAttach(activity);
    }

    @Override // com.tencent.mobileqq.zplan.aigc.SuitParentFragment.b
    public boolean onBackPressed() {
        if (this.isLoading || Aj().getIsSwitchingFragment()) {
            return true;
        }
        if (this.colorPanelShow) {
            QLog.i("SuitPreviewFragment", 1, "onBackPressed close color panel");
            this.colorPanelShow = false;
            this.currentColor = this.originColor;
            ga4.i iVar = this.dialogController;
            if (iVar != null) {
                iVar.a();
            }
            Mi(true);
            ak(this.currentPatternPosType, this.originColor);
            return true;
        }
        qj().setVisibility(8);
        QLog.i("SuitPreviewFragment", 1, "onBackPressed");
        wk0.a aVar = this.nativeApp;
        if (aVar != null) {
            aVar.removeEventListener("onFirstFrameRenderEnd");
        }
        this.publishListener = null;
        if (this.completeState) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            Fragment parentFragment2 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            if (!((SuitParentFragment) parentFragment).Gi(((SuitParentFragment) parentFragment2).getAvatarFrom()) && !Aj().getNeedFromNewPreview()) {
                requireActivity().finish();
            } else {
                QLog.i("SuitPreviewFragment", 1, "onBackPressed back avatar");
                Fragment parentFragment3 = getParentFragment();
                Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                ((SuitParentFragment) parentFragment3).Vh(true);
                Fragment parentFragment4 = getParentFragment();
                Intrinsics.checkNotNull(parentFragment4, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                SuitParentFragment.Ji((SuitParentFragment) parentFragment4, "pg_zplan_preview_new", false, 2, null);
                Fragment parentFragment5 = getParentFragment();
                Intrinsics.checkNotNull(parentFragment5, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                ((SuitParentFragment) parentFragment5).Ti();
            }
            return true;
        }
        if (Aj().getNeedFromNewPreview()) {
            Fragment parentFragment6 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment6, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            ((SuitParentFragment) parentFragment6).Vh(false);
        }
        Fragment parentFragment7 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment7, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment7).Ki();
        Aj().o2().postValue(2);
        return false;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.d("SuitPreviewFragment", 1, "onCreate");
        this.aigcPreviewParams = Aj().getAigcPreviewParams();
        Aj().o2().postValue(3);
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        this.dtReporter = ((SuitParentFragment) parentFragment).getDtReporter();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        zd3.a aVar;
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.d("SuitPreviewFragment", 1, "onCreateView");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        String str2 = null;
        if (onCreateView == null) {
            onCreateView = null;
        }
        this.parentview = onCreateView;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent2 = activity.getIntent()) == null || (str = intent2.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "activity?.intent?.getStr\u2026Entry.ENTRY_SOURCE) ?: \"\"");
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        linkedHashMap.put("zplan_gender", Integer.valueOf(Aj().v2()));
        this.gender = Aj().v2();
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            str2 = intent.getStringExtra("AIGC_ENTRY_SOURCE");
        }
        this.source = str2 != null ? str2 : "";
        View view = this.parentview;
        if (view != null && (aVar = this.dtReporter) != null) {
            aVar.c(this, view, "pg_zplan_create_new", linkedHashMap);
        }
        VideoReport.setPageId(this.parentview, "pg_zplan_create_new");
        if (!com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.f()) {
            this.avatarDressDataManager.e();
        }
        return onCreateView;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
    }

    /* renamed from: pj, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getMChannel() {
        return this.mChannel;
    }

    /* renamed from: xj, reason: from getter */
    public final boolean getShouldColorPickerShow() {
        return this.shouldColorPickerShow;
    }

    /* renamed from: yj, reason: from getter */
    public final boolean getShouldShowPatternButtons() {
        return this.shouldShowPatternButtons;
    }

    private final void Dj() {
        QLog.i("SuitPreviewFragment", 1, "initLoading");
        b bVar = new b();
        wk0.a aVar = this.nativeApp;
        if (aVar != null) {
            aVar.c("onFirstFrameRenderEnd", bVar);
        }
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new SuitPreviewFragment$initLoading$1(bVar, this, null));
    }

    private final void Mj() {
        uv4.ah ahVar = new uv4.ah();
        ahVar.f440139b = "true";
        ahVar.f440138a = 1;
        uv4.z zVar = new uv4.z();
        zVar.f440474b = "t:803";
        zVar.f440476d = 0;
        zVar.f440475c = 3;
        zVar.f440477e = new uv4.ah[]{ahVar};
        zVar.f440478f = 1;
        zVar.f440473a = "";
        zVar.f440479g = 1;
        zVar.f440480h = "";
        com.tencent.sqshow.zootopia.nativeui.data.k.b(com.tencent.sqshow.zootopia.nativeui.data.k.f371036a, zVar, a94.a.f25732a.a(new WeakReference(new e())), 0, 4, null);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d("SuitPreviewFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        nj().removeView(this.textureView);
        wk0.a aVar = this.nativeApp;
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.avatarDressDataManager.b();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.d("SuitPreviewFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        wk0.a aVar = this.nativeApp;
        if (aVar != null) {
            aVar.onPause();
        }
        Lj();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d("SuitPreviewFragment", 1, "onResume");
        super.onResume();
        mj().setText(MobileQQ.sMobileQQ.getLastLoginUin() + "\u5236\u4f5c\u4e2d");
        wk0.a aVar = this.nativeApp;
        if (aVar != null) {
            aVar.onResume();
        }
        Kj();
    }

    private final void Kj() {
        int i3;
        if (this.completeState) {
            zd3.a aVar = this.dtReporter;
            if (aVar != null) {
                zd3.a.y(aVar, Yi(), "em_zplan_to_view", null, null, 12, null);
            }
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 != null) {
                zd3.a.y(aVar2, gj(), "em_zplan_continue_create", null, null, 12, null);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clothes_ugcid", Long.valueOf(Aj().L2()));
            zd3.a aVar3 = this.dtReporter;
            if (aVar3 != null) {
                zd3.a.y(aVar3, wj(), SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, linkedHashMap, null, 8, null);
                return;
            }
            return;
        }
        this.colorPickerParamsMap.put("zplan_create_color_value", this.currentColor);
        zd3.a aVar4 = this.dtReporter;
        if (aVar4 != null) {
            zd3.a.y(aVar4, cj(), "em_zplan_color_pick", this.colorPickerParamsMap, null, 8, null);
        }
        this.poseTypeBtnClickParamsMap.put("zplan_default_paste_way", jj(this.originPatternPosType));
        Map<String, Object> map = this.poseTypeBtnClickParamsMap;
        SuitWhiteModelItem selectedWhiteModelItem = Aj().getSelectedWhiteModelItem();
        map.put("zplan_model_id", String.valueOf(selectedWhiteModelItem != null ? selectedWhiteModelItem.getItemId() : null));
        zd3.a aVar5 = this.dtReporter;
        if (aVar5 != null) {
            zd3.a.y(aVar5, rj(), "em_zplan_paste_pick", this.poseTypeBtnClickParamsMap, null, 8, null);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        boolean isOfficial = Aj().getIsOfficial();
        if (isOfficial) {
            i3 = 1;
        } else {
            if (isOfficial) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = 0;
        }
        linkedHashMap2.put("zplan_is_preintent", Integer.valueOf(i3));
        linkedHashMap2.put("zplan_box_text", Aj().getDescription());
        SuitWhiteModelItem selectedWhiteModelItem2 = Aj().getSelectedWhiteModelItem();
        linkedHashMap2.put("zplan_model_id", String.valueOf(selectedWhiteModelItem2 != null ? selectedWhiteModelItem2.getItemId() : null));
        linkedHashMap2.put("zplan_intent_prompt", Aj().getPrompt());
        linkedHashMap2.put("zplan_model_color", this.currentColor);
        linkedHashMap2.put("zplan_paste_way", this.pastePositionTypeList.get(this.currentPatternPosType).getText());
        linkedHashMap2.put("zplan_trace_id", String.valueOf(Aj().L2()));
        linkedHashMap2.put("zplan_keywords_clothes_num", Integer.valueOf(Aj().getClothNumber()));
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        linkedHashMap2.put("zplan_is_copy_clothes", Integer.valueOf((((SuitParentFragment) parentFragment).Gi(((SuitParentFragment) parentFragment2).getAvatarFrom()) || Aj().getNeedFromNewPreview()) ? 1 : 0));
        linkedHashMap2.put("zplan_is_selected_when_clck", Integer.valueOf(vj().isChecked() ? 1 : 0));
        zd3.a aVar6 = this.dtReporter;
        if (aVar6 != null) {
            zd3.a.y(aVar6, dj(), "em_zplan_create_complete", linkedHashMap2, null, 8, null);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("zplan_is_selected_when_clck", Integer.valueOf(vj().isChecked() ? 1 : 0));
        zd3.a aVar7 = this.dtReporter;
        if (aVar7 != null) {
            zd3.a.y(aVar7, vj(), "em_zplan_popular_syn", linkedHashMap3, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Zj() {
        Collection emptyList;
        View view;
        wk0.a aVar;
        wk0.a aVar2;
        AigcPreviewParams aigcPreviewParams = this.aigcPreviewParams;
        if (aigcPreviewParams != null) {
            Intrinsics.checkNotNull(aigcPreviewParams);
            emptyList = aigcPreviewParams.b();
        } else {
            QLog.w("SuitPreviewFragment", 1, "onCreate agic\u9884\u89c8\u9875\u7f3a\u5c11\u9884\u89c8\u53c2\u6570");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.scene = new AigcPreviewBusinessScene(emptyList, Aj().getAvatarType(), null, null, null, 28, null);
        wk0.a b16 = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, FilamentApiImpl.f369933a.e(), null, null, 12, null);
        this.nativeApp = b16;
        if (b16 != null) {
            b16.c("onFirstFrameRenderEnd", new f());
        }
        Dj();
        wk0.a aVar3 = this.nativeApp;
        Integer num = null;
        if (aVar3 != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            view = aVar3.z(requireContext, Boolean.TRUE);
            if (view != null) {
                view.setZ(0.0f);
                this.textureView = view;
                nj().addView(this.textureView, new FrameLayout.LayoutParams(-1, -1));
                Vj();
                aVar = this.nativeApp;
                if (aVar != null) {
                    AigcPreviewBusinessScene aigcPreviewBusinessScene = this.scene;
                    Intrinsics.checkNotNull(aigcPreviewBusinessScene);
                    num = Integer.valueOf(aVar.y("", aigcPreviewBusinessScene));
                }
                if (num != null || num.intValue() != 1) {
                    QLog.e("SuitPreviewFragment", 1, "startWithEntry fail, ret: " + num);
                }
                aVar2 = this.nativeApp;
                if (aVar2 == null) {
                    aVar2.onResume();
                    return;
                }
                return;
            }
        }
        view = null;
        this.textureView = view;
        nj().addView(this.textureView, new FrameLayout.LayoutParams(-1, -1));
        Vj();
        aVar = this.nativeApp;
        if (aVar != null) {
        }
        if (num != null) {
        }
        QLog.e("SuitPreviewFragment", 1, "startWithEntry fail, ret: " + num);
        aVar2 = this.nativeApp;
        if (aVar2 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap aj(long ugcId, String resDir) {
        if (resDir == null) {
            QLog.e("SuitPreviewFragment", 1, "cloth resDir is null");
            return null;
        }
        String str = resDir + "/Icon/" + ugcId + "_icon.png";
        Bitmap decodeFile = BitmapFactory.decodeFile(new File(str).getAbsolutePath());
        if (decodeFile != null) {
            return decodeFile;
        }
        QLog.e("SuitPreviewFragment", 1, "no cloth resource in target path " + str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ck(boolean isPreview) {
        if (isPreview) {
            this.currentLightEnterPagUrl = "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_up_light_start.pag";
            this.currentLightLoopPagUrl = "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_up_light_loop.pag";
        } else {
            this.currentLightEnterPagUrl = "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_done_start.pag";
            this.currentLightLoopPagUrl = "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_done_loop.pag";
        }
        uj().r(this.currentLightEnterPagUrl, this.currentLightLoopPagUrl, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mi(boolean bShow) {
        if (!bShow) {
            this.colorPanelShow = true;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bx
                @Override // java.lang.Runnable
                public final void run() {
                    SuitPreviewFragment.Ni(SuitPreviewFragment.this);
                }
            });
            Aj().J3(false);
            AigcPreviewBusinessScene aigcPreviewBusinessScene = this.scene;
            if (aigcPreviewBusinessScene != null) {
                aigcPreviewBusinessScene.switchCamera("{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,18.21942],\"target\":[0.0,0.01795728,0.0],\"upward\":[0.0,1.0,0.0]}}");
                return;
            }
            return;
        }
        this.colorPanelShow = false;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bz
            @Override // java.lang.Runnable
            public final void run() {
                SuitPreviewFragment.Oi(SuitPreviewFragment.this);
            }
        });
        Aj().J3(true);
        AigcPreviewBusinessScene aigcPreviewBusinessScene2 = this.scene;
        if (aigcPreviewBusinessScene2 != null) {
            aigcPreviewBusinessScene2.switchCamera("{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,10.94781],\"target\":[0.0,0.7138047,0.0],\"upward\":[0.0,1.0,0.0]}}");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Si(SuitPreviewFragment suitPreviewFragment, String str, Boolean bool, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        suitPreviewFragment.Ri(str, bool);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
    }
}
