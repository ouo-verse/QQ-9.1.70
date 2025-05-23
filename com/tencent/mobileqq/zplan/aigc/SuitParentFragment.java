package com.tencent.mobileqq.zplan.aigc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.web.RewardType;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.data.Imagery;
import com.tencent.mobileqq.zplan.aigc.helper.CouponShoppingBagHelper;
import com.tencent.mobileqq.zplan.aigc.helper.i;
import com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k94.DialogCustomData;
import kj3.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l94.AvatarActionSheetDialogMenuItem;
import l94.e;
import lj3.AIGCCreationProtocolPopUpWindowModel;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00dd\u00012\u00020\u0001:\b\u00de\u0001\u00df\u0001\u00e0\u0001\u00e1\u0001B\t\u00a2\u0006\u0006\b\u00db\u0001\u0010\u00dc\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J \u0010\u001c\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002J\u001e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\b\u0010!\u001a\u00020 H\u0014J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\b\u0010%\u001a\u00020 H\u0014J&\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u00020\u001aH\u0014J\u001a\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0006\u00103\u001a\u00020 J\u0006\u00104\u001a\u00020\u0002J\u0006\u00105\u001a\u00020\u0002J\u0006\u00106\u001a\u00020\u0002J\u0006\u00107\u001a\u00020\u0002J\u0006\u00108\u001a\u00020\u0002J\"\u0010=\u001a\u00020\u00022\u0006\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u00020\u001a2\b\b\u0002\u0010<\u001a\u00020\u001aJ\u0006\u0010>\u001a\u00020\u0002J\u0010\u0010@\u001a\u00020\u00022\b\b\u0002\u0010?\u001a\u00020\u001aJ\u0010\u0010B\u001a\u00020\u00022\b\b\u0002\u0010A\u001a\u00020\u001aJ\u0006\u0010C\u001a\u00020\u0002J\u0018\u0010E\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010D\u001a\u00020\tJ\u000e\u0010G\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020 J\u0006\u0010I\u001a\u00020HJ$\u0010L\u001a\u00020\u00022\u0006\u0010K\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015J.\u0010S\u001a\u00020\u00022\u0006\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020 2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020 2\u0006\u0010R\u001a\u00020 J\u0010\u0010T\u001a\u00020\u00022\b\u0010P\u001a\u0004\u0018\u00010OJ\b\u0010U\u001a\u00020\u001aH\u0016J\b\u0010V\u001a\u00020\u0002H\u0016J\u001e\u0010W\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ\u0018\u0010Z\u001a\u00020\u00022\u0006\u0010X\u001a\u00020\t2\b\b\u0002\u0010Y\u001a\u00020\u001aJ\u0006\u0010[\u001a\u00020\u0002R\u001b\u0010a\u001a\u00020\\8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001b\u0010f\u001a\u00020b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010^\u001a\u0004\bd\u0010eR\u001b\u0010i\u001a\u00020b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010^\u001a\u0004\bh\u0010eR\u001b\u0010n\u001a\u00020j8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bk\u0010^\u001a\u0004\bl\u0010mR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010^\u001a\u0004\bq\u0010rR\u001b\u0010v\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010^\u001a\u0004\bu\u0010eR\u001b\u0010y\u001a\u00020j8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010^\u001a\u0004\bx\u0010mR\u001b\u0010|\u001a\u00020b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010^\u001a\u0004\b{\u0010eR\u001d\u0010\u0081\u0001\u001a\u00020}8FX\u0086\u0084\u0002\u00a2\u0006\r\n\u0004\b~\u0010^\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R+\u0010\u0099\u0001\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010\u00a0\u0001R,\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001\"\u0006\b\u00a7\u0001\u0010\u00a8\u0001R,\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00aa\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R)\u0010\u00b7\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b2\u0001\u0010\u008e\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001\"\u0006\b\u00b5\u0001\u0010\u00b6\u0001R\u0017\u0010\u00ba\u0001\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u0018\u0010\u00bc\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00bb\u0001\u0010wR\u0019\u0010\u00bf\u0001\u001a\u00030\u00bd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00be\u0001\u0010zR\u0018\u0010\u00c0\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010wR(\u0010\u00c6\u0001\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00c1\u0001\u0010w\u001a\u0006\b\u00c2\u0001\u0010\u00c3\u0001\"\u0006\b\u00c4\u0001\u0010\u00c5\u0001R)\u0010\u00cd\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001\"\u0006\b\u00cb\u0001\u0010\u00cc\u0001R%\u0010\u00d2\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030\u00cf\u00010\u00ce\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u00d1\u0001R)\u0010\u00d6\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d3\u0001\u0010\u008e\u0001\u001a\u0006\b\u00d4\u0001\u0010\u00b4\u0001\"\u0006\b\u00d5\u0001\u0010\u00b6\u0001R\u001f\u0010\u00da\u0001\u001a\n\u0012\u0005\u0012\u00030\u00bd\u00010\u00d7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d8\u0001\u0010\u00d9\u0001\u00a8\u0006\u00e2\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "si", "Zh", "initViewModel", "initView", "ri", "Oi", "", "source", "ai", "Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2;", "mi", "Landroid/content/Context;", "context", "Ll94/c;", "Uh", "Ei", "Rh", "Qh", "Lkotlin/Function0;", "backHandler", "Th", "Sh", "callback", "", "needAlways", "Li", "Lu45/j;", "rsp", "Hi", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "enableRootViewSetFitsSystemWindows", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "bi", "Ui", "Xi", "Wi", "Ki", "Yi", "Lcom/tencent/mobileqq/zplan/aigc/data/i;", "imagery", "needAnimation", "needClearState", "Vi", "Ti", "needArrow", "Vh", "visibility", "Xh", "Pi", "title", "Ri", "from", "Gi", "Lzd3/a;", "gi", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "avatarPanelChannel", "Qi", "startLocationX", "startLocationY", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "width", "height", "Ph", "aj", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Di", "targetPageId", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Ii", "Zi", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "qi", "()Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "vm", "Landroid/widget/ImageView;", "D", "ci", "()Landroid/widget/ImageView;", "back", "E", "ii", "home", "Landroidx/constraintlayout/widget/ConstraintLayout;", UserInfo.SEX_FEMALE, "ni", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "ticketLayout", "Landroid/widget/TextView;", "G", "oi", "()Landroid/widget/TextView;", "ticketNum", "H", "di", "buyTicket", "I", "pi", "topArea", "J", "ki", "parentBackGroundImg", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "K", "li", "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "parentBackGroundPAG", "Landroidx/fragment/app/Fragment;", "L", "Landroidx/fragment/app/Fragment;", "currentFragment", "M", "Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2;", "suitFragmentV2", "Lcom/tencent/mobileqq/zplan/aigc/AigcAvatarFragment;", "N", "Lcom/tencent/mobileqq/zplan/aigc/AigcAvatarFragment;", "aigcAvatarFragment", "P", "Z", "ticketFirst", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "parentview", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getMChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setMChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "fi", "()Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "setCreatedClothLogic", "(Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;)V", "createdClothLogic", "Lcom/tencent/mobileqq/zplan/aigc/helper/CouponShoppingBagHelper;", "T", "Lcom/tencent/mobileqq/zplan/aigc/helper/CouponShoppingBagHelper;", "getCouponShoppingBagHelper", "()Lcom/tencent/mobileqq/zplan/aigc/helper/CouponShoppingBagHelper;", "setCouponShoppingBagHelper", "(Lcom/tencent/mobileqq/zplan/aigc/helper/CouponShoppingBagHelper;)V", "couponShoppingBagHelper", "Lga4/i;", "U", "Lga4/i;", WidgetCacheLunarData.JI, "()Lga4/i;", "setPanelDialogController", "(Lga4/i;)V", "panelDialogController", "V", "ei", "()Z", "Ni", "(Z)V", "createdClothAnimating", "W", "Lzd3/a;", "dtReporter", "X", "currentViewState", "", "Y", "lastClickTime", "avatarFrom", "a0", "hi", "()I", "setFeedFrom", "(I)V", "feedFrom", "b0", "Ljava/lang/String;", "getCurrentPageId", "()Ljava/lang/String;", "setCurrentPageId", "(Ljava/lang/String;)V", "currentPageId", "", "", "c0", "Ljava/util/Map;", "buyTicketParamsMap", "d0", "Ci", "Mi", "isAdLoading", "Landroidx/lifecycle/Observer;", "e0", "Landroidx/lifecycle/Observer;", "mCouponBuySucceedObserver", "<init>", "()V", "f0", "AigcSuitFeedFromValue", "AigcSuitPreviewFromValue", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitParentFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy back;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy home;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy ticketLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy ticketNum;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy buyTicket;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy topArea;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy parentBackGroundImg;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy parentBackGroundPAG;

    /* renamed from: L, reason: from kotlin metadata */
    private Fragment currentFragment;

    /* renamed from: M, reason: from kotlin metadata */
    private SuitCreateFragmentV2 suitFragmentV2;

    /* renamed from: N, reason: from kotlin metadata */
    private AigcAvatarFragment aigcAvatarFragment;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean ticketFirst;

    /* renamed from: Q, reason: from kotlin metadata */
    private View parentview;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: S, reason: from kotlin metadata */
    private CreatedClothShowLogic createdClothLogic;

    /* renamed from: T, reason: from kotlin metadata */
    private CouponShoppingBagHelper couponShoppingBagHelper;

    /* renamed from: U, reason: from kotlin metadata */
    private ga4.i panelDialogController;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean createdClothAnimating;

    /* renamed from: W, reason: from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: X, reason: from kotlin metadata */
    private int currentViewState;

    /* renamed from: Y, reason: from kotlin metadata */
    private long lastClickTime;

    /* renamed from: Z, reason: from kotlin metadata */
    private int avatarFrom;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int feedFrom;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String currentPageId;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> buyTicketParamsMap;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isAdLoading;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final Observer<Long> mCouponBuySucceedObserver;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment$AigcSuitFeedFromValue;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PORTAL", "BAG", "LITTLE_WORLD", "PREVIEW", "DEFAULT", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum AigcSuitFeedFromValue {
        PORTAL(1),
        BAG(2),
        LITTLE_WORLD(3),
        PREVIEW(4),
        DEFAULT(99);

        private final int value;

        AigcSuitFeedFromValue(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment$AigcSuitPreviewFromValue;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "FEED_PAGE", "QZONE", "SCHEME", "LITTLE_WORLD", "OUTFIT_DETAIL", "STORE_MAKE_SAME", "DEFAULT", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum AigcSuitPreviewFromValue {
        FEED_PAGE(1),
        QZONE(2),
        SCHEME(3),
        LITTLE_WORLD(4),
        OUTFIT_DETAIL(5),
        STORE_MAKE_SAME(6),
        DEFAULT(99);

        private final int value;

        AigcSuitPreviewFromValue(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment$b;", "", "", "onBackPressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        boolean onBackPressed();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f330002e;

        c(ImageView imageView) {
            this.f330002e = imageView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            View view = SuitParentFragment.this.parentview;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).removeView(this.f330002e);
            SuitParentFragment.this.Ni(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$d", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements l94.e {
        d() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$e", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements l94.e {
        e() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SuitParentFragment.this.ai("source_add_btn");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clck_type", 1);
            SuitParentFragment.this.dtReporter.t(view, "em_zplan_create_coupon_insufficient_module", linkedHashMap);
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$f", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements l94.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f330004a;

        f(Function0<Unit> function0) {
            this.f330004a = function0;
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f330004a.invoke();
        }

        @Override // l94.e
        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$g", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements com.tencent.mobileqq.zootopia.api.e<Integer> {
        g() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }

        public void a(int result) {
            QLog.i("SuitParentFragment", 1, "restore AvatarDataCenter success");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("SuitParentFragment", 1, "restore AvatarDataCenter failed");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$i", "Lkj3/a$a;", "", "errCode", "", "errMsg", "", "onFail", "Lu45/j;", "rsp", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements a.InterfaceC10662a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f330007b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f330008c;

        i(boolean z16, Function0<Unit> function0) {
            this.f330007b = z16;
            this.f330008c = function0;
        }

        @Override // kj3.a.InterfaceC10662a
        public void a(u45.j rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.i("AIGCCreationPageEntry", 1, "requestAgreeProtocolStatus success. status: " + rsp.f438240a);
            if (this.f330007b) {
                Intent intent = new Intent();
                intent.putExtra("url", rsp.f438244e);
                RouteUtils.startActivity(SuitParentFragment.this.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
            } else if (!rsp.f438240a) {
                SuitParentFragment.this.Hi(rsp, this.f330008c);
            } else {
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(SuitParentFragment.this.Sh(), rsp.f438248i);
                this.f330008c.invoke();
            }
        }

        @Override // kj3.a.InterfaceC10662a
        public void onFail(int errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("AIGCCreationPageEntry", 1, "requestAgreeProtocolStatus fail. errCode:" + errCode + ", errMsg:" + errMsg);
            QQToast.makeText(SuitParentFragment.this.getContext(), 1, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, 0).show();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$j", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class j implements l94.e {
        j() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$k", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class k implements l94.e {
        k() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clck_type", 0);
            SuitParentFragment.this.dtReporter.t(view, "em_zplan_create_coupon_insufficient_module", linkedHashMap);
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    public SuitParentFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SuitCreateTechFragmentViewModel>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitCreateTechFragmentViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(SuitParentFragment.this).get(SuitCreateTechFragmentViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026entViewModel::class.java)");
                return (SuitCreateTechFragmentViewModel) viewModel;
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$back$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitParentFragment.this.requireView().findViewById(R.id.pcx);
            }
        });
        this.back = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$home$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitParentFragment.this.requireView().findViewById(R.id.pzx);
            }
        });
        this.home = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$ticketLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitParentFragment.this.requireView().findViewById(R.id.qqv);
            }
        });
        this.ticketLayout = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$ticketNum$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitParentFragment.this.requireView().findViewById(R.id.qqu);
            }
        });
        this.ticketNum = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$buyTicket$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitParentFragment.this.requireView().findViewById(R.id.php);
            }
        });
        this.buyTicket = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$topArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitParentFragment.this.requireView().findViewById(R.id.qsa);
            }
        });
        this.topArea = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$parentBackGroundImg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitParentFragment.this.requireView().findViewById(R.id.qbq);
            }
        });
        this.parentBackGroundImg = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<SuitPagView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$parentBackGroundPAG$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitPagView invoke() {
                return (SuitPagView) SuitParentFragment.this.requireView().findViewById(R.id.qbs);
            }
        });
        this.parentBackGroundPAG = lazy9;
        this.dtReporter = new zd3.a();
        this.currentViewState = -1;
        this.avatarFrom = AigcSuitPreviewFromValue.FEED_PAGE.getValue();
        this.feedFrom = AigcSuitFeedFromValue.PORTAL.getValue();
        this.currentPageId = "pg_zplan_create_new";
        this.buyTicketParamsMap = new LinkedHashMap();
        this.mCouponBuySucceedObserver = new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.bi
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitParentFragment.Fi(SuitParentFragment.this, (Long) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ei() {
        com.tencent.mobileqq.zplan.aigc.helper.i iVar = new com.tencent.mobileqq.zplan.aigc.helper.i();
        iVar.k(new h());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            int value = RewardType.SUPER_SHOW_CREATIVE_VOUCHER.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_id", 1);
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
            com.tencent.mobileqq.zplan.aigc.helper.i.i(iVar, activity, value, jSONObject2, 0, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(SuitParentFragment this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (l3 != null && l3.longValue() == -1) {
            return;
        }
        SuitCreateTechFragmentViewModel.c3(this$0.qi(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi(final u45.j rsp, final Function0<Unit> callback) {
        final AIGCCreationProtocolPopUpWindowModel a16 = new AIGCCreationProtocolPopUpWindowModel(null, null, null, null, null, null, null, 127, null).a(rsp);
        com.tencent.mobileqq.zplan.aigc.share.b.f330597a.e(a16.getHeadPictureUrl(), "aigc_protocol_head_pic.png", "zplan_aigc_protocol", new com.tencent.mobileqq.zplan.aigc.share.d() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$openCreationProtocolDialog$1
            @Override // com.tencent.mobileqq.zplan.aigc.share.d
            public void onFailure(String error) {
                Intrinsics.checkNotNullParameter(error, "error");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.tencent.mobileqq.zplan.aigc.share.d
            public void onSuccess(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                CommonExKt.j(new SuitParentFragment$openCreationProtocolDialog$1$onSuccess$1(AIGCCreationProtocolPopUpWindowModel.this, this, bitmap, rsp, callback));
            }
        });
    }

    private final void Oi() {
        ConstraintLayout pi5 = pi();
        com.tencent.mobileqq.zplan.aigc.utils.a aVar = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        pi5.setPadding(0, aVar.c(requireContext), 0, ImmersiveUtils.dpToPx(4.0f));
    }

    private final AvatarActionSheetDialogMenuItem Qh(Context context) {
        String string = context.getResources().getString(R.string.xkw);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_aigc_v2_continue_create)");
        return new AvatarActionSheetDialogMenuItem(2, 2, string, new d(), null, 16, null);
    }

    private final AvatarActionSheetDialogMenuItem Rh(Context context) {
        String string = context.getResources().getString(R.string.xkq);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ng.zplan_aigc_ticket_buy)");
        return new AvatarActionSheetDialogMenuItem(2, 3, string, new e(), null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Sh() {
        return "ZPLAN_AIGC_PROTOCOL_STATUS_" + com.tencent.mobileqq.zplan.utils.bb.f335811a.e();
    }

    private final AvatarActionSheetDialogMenuItem Th(Context context, Function0<Unit> backHandler) {
        String string = context.getResources().getString(R.string.xkx);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ng.zplan_aigc_v2_give_up)");
        return new AvatarActionSheetDialogMenuItem(3, 1, string, new f(backHandler), null, 16, null);
    }

    private final AvatarActionSheetDialogMenuItem Uh(Context context) {
        String string = context.getResources().getString(R.string.xks);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026lan_aigc_ticket_watch_ad)");
        return new AvatarActionSheetDialogMenuItem(2, 2, string, new l94.e() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$buildWatchAdItem$1
            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToastUtil.showQQToast(0, R.string.xs_);
                    return;
                }
                SuitParentFragment.this.Mi(true);
                SuitParentFragment.this.qi().i3(1, new SuitParentFragment$buildWatchAdItem$1$onItemClick$1(SuitParentFragment.this));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("zplan_clck_type", 2);
                SuitParentFragment.this.dtReporter.t(view, "em_zplan_create_coupon_insufficient_module", linkedHashMap);
            }

            @Override // l94.e
            public void b(View view) {
                e.a.a(this, view);
            }
        }, null, 16, null);
    }

    private final void Zh() {
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.j().a().removeObserver(this.mCouponBuySucceedObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView di() {
        Object value = this.buyTicket.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-buyTicket>(...)");
        return (ImageView) value;
    }

    private final void initView() {
        int value;
        int value2;
        com.tencent.mobileqq.zplan.aigc.utils.a.f330690a.h(li());
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i3 = arguments.getInt("subPageId", 0);
            if (i3 == 0) {
                Ui();
            } else if (i3 == 1) {
                if (arguments.containsKey("from")) {
                    value = arguments.getInt("from");
                } else {
                    value = AigcSuitPreviewFromValue.SCHEME.getValue();
                }
                this.avatarFrom = value;
                qi().o3(arguments.containsKey("item_id") ? arguments.getInt("item_id") : -1);
                QLog.d("SuitParentFragment", 1, "avatar from ." + this.avatarFrom);
                qi().H3(arguments.containsKey("useCacheAvatarData") ? arguments.getBoolean("useCacheAvatarData") : false);
                if (this.avatarFrom == AigcSuitPreviewFromValue.STORE_MAKE_SAME.getValue()) {
                    qi().H3(true);
                    qi().s3(true);
                }
                QLog.d("SuitParentFragment", 1, "contain ugc id ." + arguments.getLong("ugcId"));
                SuitCreateTechFragmentViewModel qi5 = qi();
                long j3 = 0;
                if (arguments.containsKey("ugcId")) {
                    long j16 = arguments.getLong("ugcId", 0L);
                    if (j16 == 0) {
                        arguments.getInt("ugcId");
                        j3 = arguments.getInt("ugcId");
                    } else {
                        j3 = j16;
                    }
                }
                qi5.I3(j3);
                Ji(this, "pg_zplan_preview_new", false, 2, null);
                Ti();
            } else if (i3 == 2) {
                if (arguments.containsKey("from")) {
                    value2 = arguments.getInt("from");
                } else {
                    value2 = AigcSuitFeedFromValue.PORTAL.getValue();
                }
                this.feedFrom = value2;
                QLog.d("SuitParentFragment", 1, " jump to feed from :" + value2);
                Ji(this, "pg_zplan_create_home", false, 2, null);
                Xi();
            }
        }
        ci().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitParentFragment.ti(SuitParentFragment.this, view);
            }
        });
        ii().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitParentFragment.ui(SuitParentFragment.this, view);
            }
        });
        di().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.bh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitParentFragment.vi(SuitParentFragment.this, view);
            }
        });
        Oi();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.createdClothLogic = new CreatedClothShowLogic(requireContext);
    }

    private final void initViewModel() {
        AssetManager assets;
        Context context = getContext();
        if (context != null && (assets = context.getAssets()) != null) {
            oi().setTypeface(t74.m.f435564a.c(assets));
        }
        LiveData<Long> J2 = qi().J2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                ImageView di5;
                TextView oi5;
                Map map;
                boolean z16;
                ImageView di6;
                Map map2;
                di5 = SuitParentFragment.this.di();
                di5.setVisibility(0);
                oi5 = SuitParentFragment.this.oi();
                oi5.setText(String.valueOf(it));
                map = SuitParentFragment.this.buyTicketParamsMap;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                map.put("zplan_create_coupon_num", it);
                z16 = SuitParentFragment.this.ticketFirst;
                if (z16) {
                    return;
                }
                SuitParentFragment.this.ticketFirst = true;
                zd3.a aVar = SuitParentFragment.this.dtReporter;
                di6 = SuitParentFragment.this.di();
                map2 = SuitParentFragment.this.buyTicketParamsMap;
                zd3.a.y(aVar, di6, "em_zplan_create_coupon", map2, null, 8, null);
            }
        };
        J2.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitParentFragment.xi(Function1.this, obj);
            }
        });
        this.dtReporter.a(di(), new IDynamicParams() { // from class: com.tencent.mobileqq.zplan.aigc.ba
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map yi5;
                yi5 = SuitParentFragment.yi(SuitParentFragment.this, str);
                return yi5;
            }
        });
        LiveData<Boolean> I2 = qi().I2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$initViewModel$4
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
            public final void invoke2(Boolean success) {
                ImageView di5;
                Map map;
                SuitParentFragment.this.qi().o2().postValue(0);
                Intrinsics.checkNotNullExpressionValue(success, "success");
                if (success.booleanValue()) {
                    zd3.a aVar = SuitParentFragment.this.dtReporter;
                    di5 = SuitParentFragment.this.di();
                    map = SuitParentFragment.this.buyTicketParamsMap;
                    zd3.a.y(aVar, di5, "em_zplan_create_coupon", map, null, 8, null);
                }
            }
        };
        I2.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitParentFragment.zi(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> o26 = qi().o2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$initViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer viewState) {
                int i3;
                int i16;
                zd3.a aVar = SuitParentFragment.this.dtReporter;
                ImageView ci5 = SuitParentFragment.this.ci();
                i3 = SuitParentFragment.this.currentViewState;
                zd3.a.s(aVar, "dt_imp_end", ci5, i3, null, 8, null);
                SuitParentFragment suitParentFragment = SuitParentFragment.this;
                Intrinsics.checkNotNullExpressionValue(viewState, "viewState");
                suitParentFragment.currentViewState = viewState.intValue();
                zd3.a aVar2 = SuitParentFragment.this.dtReporter;
                ImageView ci6 = SuitParentFragment.this.ci();
                i16 = SuitParentFragment.this.currentViewState;
                zd3.a.s(aVar2, "dt_imp", ci6, i16, null, 8, null);
            }
        };
        o26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.bc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitParentFragment.Ai(Function1.this, obj);
            }
        });
        LiveData<Boolean> K2 = qi().K2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$initViewModel$6
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
            public final void invoke2(Boolean it) {
                ConstraintLayout ni5;
                ConstraintLayout ni6;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    ni6 = SuitParentFragment.this.ni();
                    ni6.setVisibility(0);
                } else {
                    ni5 = SuitParentFragment.this.ni();
                    ni5.setVisibility(8);
                }
            }
        };
        K2.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitParentFragment.Bi(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> w26 = qi().w2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$initViewModel$7
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
            public final void invoke2(Boolean isHidden) {
                ConstraintLayout pi5;
                pi5 = SuitParentFragment.this.pi();
                Intrinsics.checkNotNullExpressionValue(isHidden, "isHidden");
                pi5.setVisibility(isHidden.booleanValue() ? 8 : 0);
            }
        };
        w26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.be
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitParentFragment.wi(Function1.this, obj);
            }
        });
    }

    private final SuitCreateFragmentV2 mi() {
        if (this.suitFragmentV2 == null) {
            this.suitFragmentV2 = new SuitCreateFragmentV2();
        }
        SuitCreateFragmentV2 suitCreateFragmentV2 = this.suitFragmentV2;
        Intrinsics.checkNotNull(suitCreateFragmentV2);
        return suitCreateFragmentV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstraintLayout ni() {
        Object value = this.ticketLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ticketLayout>(...)");
        return (ConstraintLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView oi() {
        Object value = this.ticketNum.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ticketNum>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstraintLayout pi() {
        Object value = this.topArea.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-topArea>(...)");
        return (ConstraintLayout) value;
    }

    private final void si() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.j().a().observe(requireActivity, this.mCouponBuySucceedObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(SuitParentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        zd3.a.s(this$0.dtReporter, "dt_clck", this$0.ci(), this$0.currentViewState, null, 8, null);
        this$0.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(SuitParentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AigcAvatarFragment aigcAvatarFragment = this$0.aigcAvatarFragment;
        if (aigcAvatarFragment != null) {
            aigcAvatarFragment.oi(new g());
        }
        this$0.dtReporter.w("dt_clck", this$0.ii());
        this$0.ri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(SuitParentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime > 500) {
            this$0.lastClickTime = currentTimeMillis;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_create_coupon_num", String.valueOf(this$0.qi().J2().getValue()));
            VideoReport.reportEvent("dt_clck", this$0.di(), linkedHashMap);
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Si(this$0, requireContext, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map yi(SuitParentFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.buyTicketParamsMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* renamed from: Ci, reason: from getter */
    public final boolean getIsAdLoading() {
        return this.isAdLoading;
    }

    public final void Di(Function0<Unit> callback, boolean needAlways) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SuitParentFragment", 1, "jumpProtocol.");
        if (needAlways) {
            Li(callback, needAlways);
            return;
        }
        long j3 = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getLong(Sh(), 0L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        QLog.i("SuitParentFragment", 1, "jumpProtocol. currentTime " + currentTimeMillis + " " + j3);
        if (currentTimeMillis <= j3) {
            callback.invoke();
        } else {
            Li(callback, needAlways);
        }
    }

    public final boolean Gi(int from) {
        return from == AigcSuitPreviewFromValue.SCHEME.getValue() || from == AigcSuitPreviewFromValue.QZONE.getValue() || from == AigcSuitPreviewFromValue.LITTLE_WORLD.getValue();
    }

    public final void Ii(String targetPageId, boolean force) {
        LinkedHashMap linkedHashMap;
        String str;
        Intent intent;
        Intrinsics.checkNotNullParameter(targetPageId, "targetPageId");
        if (!Intrinsics.areEqual(this.currentPageId, targetPageId)) {
            Zi();
        }
        if (!Intrinsics.areEqual(this.currentPageId, targetPageId) || force) {
            this.currentPageId = targetPageId;
            View view = this.parentview;
            if (Intrinsics.areEqual(targetPageId, "pg_zplan_create_new")) {
                linkedHashMap = new LinkedHashMap();
                FragmentActivity activity = getActivity();
                if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(str, "activity?.intent?.getStr\u2026Entry.ENTRY_SOURCE) ?: \"\"");
                linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
                linkedHashMap.put("zplan_gender", Integer.valueOf(qi().v2()));
            } else if (Intrinsics.areEqual(this.currentPageId, "pg_zplan_create_home")) {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("zplan_create_home_source", Integer.valueOf(this.feedFrom));
            } else {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("zplan_preview_new_source", Integer.valueOf(this.avatarFrom));
                linkedHashMap.put("zplan_clothes_ugcid", Long.valueOf(qi().getWhiteModelUgcId()));
            }
            if (view != null) {
                this.dtReporter.c(this, view, this.currentPageId, linkedHashMap);
            }
            VideoReport.setPageId(view, this.currentPageId);
        }
    }

    public final void Ki() {
        SuitCreateFragmentV2 suitCreateFragmentV2 = this.suitFragmentV2;
        if (suitCreateFragmentV2 != null) {
            Intrinsics.checkNotNull(suitCreateFragmentV2);
            suitCreateFragmentV2.Dj();
            SuitCreateFragmentV2 suitCreateFragmentV22 = this.suitFragmentV2;
            Intrinsics.checkNotNull(suitCreateFragmentV22);
            suitCreateFragmentV22.Lj();
        }
    }

    public final void Mi(boolean z16) {
        this.isAdLoading = z16;
    }

    public final void Ni(boolean z16) {
        this.createdClothAnimating = z16;
    }

    public final void Ph(int startLocationX, int startLocationY, Bitmap bitmap, int width, int height) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (this.parentview == null) {
            return;
        }
        View view = this.parentview;
        Intrinsics.checkNotNull(view);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setImageBitmap(bitmap);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.leftMargin = startLocationX;
        layoutParams.topMargin = startLocationY;
        imageView.setLayoutParams(layoutParams);
        View view2 = this.parentview;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view2).addView(imageView);
        Object systemService = requireActivity().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = (displayMetrics.widthPixels / 2) - (width / 2);
        int i16 = (displayMetrics.heightPixels / 2) - (height / 2);
        Path path = new Path();
        path.moveTo(startLocationX, startLocationY);
        path.lineTo(i3, i16);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.X, (Property<ImageView, Float>) View.Y, path);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        ofFloat2.addListener(new c(imageView));
        this.createdClothAnimating = true;
        animatorSet.start();
    }

    public final void Pi() {
        View view = this.parentview;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ga4.i iVar = new ga4.i((ViewGroup) view);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar);
        this.mChannel = jVar;
        Intrinsics.checkNotNull(jVar);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Qi(jVar, requireContext, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitParentFragment$showBackConfirmDialog$1$1
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
                int i3;
                int i16;
                i3 = SuitParentFragment.this.avatarFrom;
                QLog.d("SuitParentFragment", 1, "showConfirmDialog ~~~~" + i3);
                SuitParentFragment suitParentFragment = SuitParentFragment.this;
                i16 = suitParentFragment.avatarFrom;
                if (!suitParentFragment.Gi(i16) && !SuitParentFragment.this.qi().getNeedFromNewPreview()) {
                    SuitParentFragment.this.requireActivity().finish();
                    return;
                }
                QLog.d("SuitParentFragment", 1, "popBackStack ");
                SuitParentFragment.this.Vh(true);
                SuitParentFragment.this.Ti();
                SuitParentFragment.Ji(SuitParentFragment.this, "pg_zplan_preview_new", false, 2, null);
            }
        });
        this.panelDialogController = iVar;
    }

    public final void Qi(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, new l94.a().b(Qh(context)).b(Th(context, backHandler)).d(new j()).c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    public final void Ti() {
        QLog.d("SuitParentFragment", 1, "switchToAigcAvatarFragment ~~~~");
        AigcAvatarFragment aigcAvatarFragment = this.aigcAvatarFragment;
        if (aigcAvatarFragment == null) {
            aigcAvatarFragment = new AigcAvatarFragment();
        }
        this.aigcAvatarFragment = aigcAvatarFragment;
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            Intrinsics.checkNotNull(fragment);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fragment.getView(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(currentFragment!\u2026tView(), \"alpha\", 1f, 0f)");
            ofFloat.setDuration(500L);
            AigcAvatarFragment aigcAvatarFragment2 = this.aigcAvatarFragment;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aigcAvatarFragment2 != null ? aigcAvatarFragment2.getView() : null, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(aigcAvatarFragme\u2026tView(), \"alpha\", 0f, 1f)");
            ofFloat2.setDuration(500L);
            new AnimatorSet().playTogether(ofFloat, ofFloat2);
        }
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("AigcAvatarFragment");
        QLog.d("SuitParentFragment", 1, "aigcAvatarFragment." + this.currentFragment);
        if (findFragmentByTag == null) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            AigcAvatarFragment aigcAvatarFragment3 = this.aigcAvatarFragment;
            Intrinsics.checkNotNull(aigcAvatarFragment3);
            beginTransaction.add(R.id.pjg, aigcAvatarFragment3, "AigcAvatarFragment").addToBackStack("avatarsuitCreateFragment").setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();
        } else {
            Xh(Gi(getAvatarFrom()));
            List<Fragment> fragments = getChildFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
            QLog.d("SuitParentFragment", 1, "aigcAvatarFragment~" + this.currentFragment);
            for (Fragment fragment2 : fragments) {
                if (fragment2 != null && fragment2.isVisible()) {
                    this.currentFragment = fragment2;
                    QLog.d("SuitParentFragment", 1, "aigcAvatarFragment~" + fragment2);
                }
            }
            Fragment fragment3 = this.currentFragment;
            if (fragment3 != null) {
                QLog.d("SuitParentFragment", 1, "aigcAvatarFragment\uff01\uff01\uff01" + fragment3);
                if (this.aigcAvatarFragment != null) {
                    FragmentTransaction beginTransaction2 = getChildFragmentManager().beginTransaction();
                    AigcAvatarFragment aigcAvatarFragment4 = this.aigcAvatarFragment;
                    Intrinsics.checkNotNull(aigcAvatarFragment4);
                    beginTransaction2.show(aigcAvatarFragment4).setCustomAnimations(R.anim.f154362jj, R.anim.f154363jk).hide(fragment3).addToBackStack(null).commit();
                }
            }
        }
        this.currentFragment = this.aigcAvatarFragment;
    }

    public final void Ui() {
        SuitCreateFragmentV2 mi5 = mi();
        getChildFragmentManager().beginTransaction().add(R.id.pjg, mi5, "SuitCreateFragmentV2").addToBackStack("switchToCreateFragment").commit();
        this.currentFragment = mi5;
    }

    public final void Vi(Imagery imagery, boolean needAnimation, boolean needClearState) {
        Intrinsics.checkNotNullParameter(imagery, "imagery");
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("SuitCreateFragmentV2");
        Vh(false);
        Yh(this, false, 1, null);
        QLog.d("SuitParentFragment", 1, "switchToCreateFragmentFilamentTab~." + this.currentFragment);
        if (findFragmentByTag == null) {
            SuitCreateFragmentV2 mi5 = mi();
            Bundle bundle = new Bundle();
            bundle.putString("source", "switchFilamentFragment");
            mi5.setArguments(bundle);
            qi().D3(imagery);
            Fragment fragment = this.currentFragment;
            if (fragment != null) {
                getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.f154364jl, R.anim.f154363jk).add(R.id.pjg, mi5, "SuitCreateFragmentV2").hide(fragment).addToBackStack(null).commit();
            }
            this.currentFragment = mi5;
        } else {
            QLog.d("SuitParentFragment", 1, "createV2Fragment.currentFragment  " + this.currentFragment);
            Fragment fragment2 = this.currentFragment;
            if (fragment2 != null) {
                getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.f154364jl, R.anim.f154362jj).show(findFragmentByTag).hide(fragment2).addToBackStack(null).commit();
            }
            this.currentFragment = findFragmentByTag;
            Intrinsics.checkNotNull(findFragmentByTag, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2");
            ((SuitCreateFragmentV2) findFragmentByTag).ak(true);
            Fragment fragment3 = this.currentFragment;
            Intrinsics.checkNotNull(fragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2");
            SuitCreateFragmentV2.dk((SuitCreateFragmentV2) fragment3, imagery, false, false, 6, null);
        }
        Ji(this, "pg_zplan_create_new", false, 2, null);
    }

    public final void Wi() {
        getChildFragmentManager().popBackStack();
        SuitCreateFragmentV2 mi5 = mi();
        this.currentFragment = mi5;
        mi5.Sj(0, false, true);
    }

    public final void Xi() {
        SuitFeedFragment suitFeedFragment = new SuitFeedFragment();
        getChildFragmentManager().beginTransaction().add(R.id.pjg, suitFeedFragment).addToBackStack("switchToCreateFragment").commit();
        this.currentFragment = suitFeedFragment;
    }

    public final void Yi() {
        QLog.d("SuitParentFragment", 1, "switchToPreviewFragment ~~~~");
        SuitPreviewFragment suitPreviewFragment = new SuitPreviewFragment();
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            Intrinsics.checkNotNull(fragment);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fragment.getView(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(currentFragment!\u2026tView(), \"alpha\", 1f, 0f)");
            ofFloat.setDuration(500L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(suitPreviewFragment.getView(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(previewFragment.\u2026tView(), \"alpha\", 0f, 1f)");
            ofFloat2.setDuration(500L);
            new AnimatorSet().playTogether(ofFloat, ofFloat2);
        }
        getChildFragmentManager().beginTransaction().add(R.id.pjg, suitPreviewFragment).addToBackStack(null).setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();
        this.currentFragment = suitPreviewFragment;
    }

    public final void Zi() {
        VideoReport.pageLogicDestroy(this.parentview);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* renamed from: bi, reason: from getter */
    public final int getAvatarFrom() {
        return this.avatarFrom;
    }

    public final ImageView ci() {
        Object value = this.back.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-back>(...)");
        return (ImageView) value;
    }

    /* renamed from: ei, reason: from getter */
    public final boolean getCreatedClothAnimating() {
        return this.createdClothAnimating;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* renamed from: fi, reason: from getter */
    public final CreatedClothShowLogic getCreatedClothLogic() {
        return this.createdClothLogic;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dga;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* renamed from: gi, reason: from getter */
    public final zd3.a getDtReporter() {
        return this.dtReporter;
    }

    /* renamed from: hi, reason: from getter */
    public final int getFeedFrom() {
        return this.feedFrom;
    }

    public final ImageView ii() {
        Object value = this.home.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-home>(...)");
        return (ImageView) value;
    }

    /* renamed from: ji, reason: from getter */
    public final ga4.i getPanelDialogController() {
        return this.panelDialogController;
    }

    public final ImageView ki() {
        Object value = this.parentBackGroundImg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-parentBackGroundImg>(...)");
        return (ImageView) value;
    }

    public final SuitPagView li() {
        Object value = this.parentBackGroundPAG.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-parentBackGroundPAG>(...)");
        return (SuitPagView) value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        List<Fragment> reversed;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        ga4.f dialogController;
        QLog.d("SuitParentFragment", 1, "onBackEvent");
        CouponShoppingBagHelper couponShoppingBagHelper = this.couponShoppingBagHelper;
        boolean z16 = false;
        if ((couponShoppingBagHelper == null || (mChannel = couponShoppingBagHelper.getMChannel()) == null || (dialogController = mChannel.getDialogController()) == null || !dialogController.a()) ? false : true) {
            return true;
        }
        ga4.i iVar = this.panelDialogController;
        if (iVar != null && iVar.a()) {
            z16 = true;
        }
        if (z16 || qi().getIsSwitchingFragment()) {
            return true;
        }
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        reversed = CollectionsKt___CollectionsKt.reversed(fragments);
        for (Fragment fragment : reversed) {
            if (fragment.isVisible()) {
                if ((!(fragment instanceof b) || !((b) fragment).onBackPressed()) && fragments.size() > 1) {
                    getChildFragmentManager().popBackStack();
                }
                return true;
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        Intent intent;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (onCreateView == null) {
            onCreateView = null;
        }
        this.parentview = onCreateView;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "activity?.intent?.getStr\u2026Entry.ENTRY_SOURCE) ?: \"\"");
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        linkedHashMap.put("zplan_gender", Integer.valueOf(qi().v2()));
        View view = this.parentview;
        if (view != null) {
            this.dtReporter.c(this, view, "pg_zplan_create_new", linkedHashMap);
        }
        VideoReport.setPageId(this.parentview, "pg_zplan_create_new");
        return onCreateView;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Zh();
        super.onDestroy();
        zd3.a.A(this.dtReporter, di(), "em_zplan_create_coupon", null, 4, null);
        this.suitFragmentV2 = null;
        this.currentFragment = null;
        CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
        if (createdClothShowLogic != null) {
            createdClothShowLogic.s();
        }
        this.createdClothLogic = null;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
        SuitCreateTechFragmentViewModel.c3(qi(), null, 1, null);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
        si();
    }

    public final SuitCreateTechFragmentViewModel qi() {
        return (SuitCreateTechFragmentViewModel) this.vm.getValue();
    }

    private final void Li(Function0<Unit> callback, boolean needAlways) {
        QLog.i("AIGCCreationPageEntry", 1, "requestAgreeProtocolStatus start.");
        kj3.a.f412566a.a(new i(needAlways, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(String source) {
        FragmentActivity activity;
        QLog.d("SuitParentFragment", 1, "doShowShoppingBag.");
        Context context = getContext();
        if (context == null || (activity = getActivity()) == null) {
            return;
        }
        View view = getView();
        ViewGroup viewGroup = view != null ? (ViewGroup) view.findViewById(R.id.pmr) : null;
        if (viewGroup == null) {
            return;
        }
        View view2 = getView();
        AvatarGlobalLoadingView avatarGlobalLoadingView = view2 != null ? (AvatarGlobalLoadingView) view2.findViewById(R.id.pwx) : null;
        if (avatarGlobalLoadingView == null) {
            return;
        }
        CouponShoppingBagHelper couponShoppingBagHelper = new CouponShoppingBagHelper(viewGroup, avatarGlobalLoadingView, activity);
        couponShoppingBagHelper.e(context, source);
        this.couponShoppingBagHelper = couponShoppingBagHelper;
    }

    private final void ri() {
        FragmentActivity requireActivity;
        QLog.i("SuitParentFragment", 1, "gotoCreationPage");
        Bundle bundle = new Bundle();
        bundle.putInt("subPageId", 2);
        bundle.putInt("from", AigcSuitFeedFromValue.PREVIEW.getValue());
        IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iEntryApi.startAIGCCreationPage(requireContext, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.None, ZootopiaSource.SUB_SOURCE_AIGC_CREATION_ENTRANCE, null, 4, null), bundle);
        Fragment fragment = this.currentFragment;
        if (!(fragment instanceof AigcAvatarFragment) || fragment == null || (requireActivity = fragment.requireActivity()) == null) {
            return;
        }
        requireActivity.finish();
    }

    public final void Vh(boolean needArrow) {
        if (needArrow) {
            ci().setBackgroundResource(R.drawable.h1z);
        } else {
            ci().setBackgroundResource(R.drawable.f159858h23);
        }
    }

    public final void Xh(boolean visibility) {
        if (visibility) {
            ii().setVisibility(0);
        } else {
            ii().setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$h", "Lcom/tencent/mobileqq/zplan/aigc/helper/i$b;", "", "success", "", "b", "profitable", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements i.b {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$h$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "d", "", "error", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.zootopia.api.e<String> {
            a() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(String result) {
                Intrinsics.checkNotNullParameter(result, "result");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bo
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitParentFragment.h.a.e();
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bn
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitParentFragment.h.a.c();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c() {
                QQToastUtil.showQQToast(1, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e() {
                QQToastUtil.showQQToast(2, R.string.xkt);
            }
        }

        h() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.helper.i.b
        public void a(boolean success) {
            QLog.i("SuitParentFragment", 1, "ZPlanAIGCWatchAdHelper report ad result: " + success);
            if (success) {
                SuitParentFragment.this.qi().b3(new a());
            }
            SuitParentFragment.this.Mi(false);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.helper.i.b
        public void b(boolean success) {
            QLog.i("SuitParentFragment", 1, "ZPlanAIGCWatchAdHelper request ad result: " + success);
            if (success) {
                return;
            }
            SuitParentFragment.this.Mi(false);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.bm
                @Override // java.lang.Runnable
                public final void run() {
                    SuitParentFragment.h.e();
                }
            });
        }

        @Override // com.tencent.mobileqq.zplan.aigc.helper.i.b
        public void c(boolean profitable) {
            SuitParentFragment.this.Mi(false);
            QLog.i("SuitParentFragment", 1, "ZPlanAIGCWatchAdHelper show ad result: " + profitable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e() {
            QQToastUtil.showQQToast(0, R.string.xs_);
        }
    }

    public static /* synthetic */ void Si(SuitParentFragment suitParentFragment, Context context, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        suitParentFragment.Ri(context, str);
    }

    public final void Ri(Context context, String title) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        View view = this.parentview;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, new ga4.i((ViewGroup) view));
        l94.a aVar = new l94.a();
        if (!Intrinsics.areEqual(title, "")) {
            aVar.e(title);
        }
        aVar.b(Rh(context));
        aVar.b(Uh(context));
        aVar.d(new k());
        a16 = ga4.j.f401682a.a(6, jVar, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, aVar.c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        zd3.a.y(this.dtReporter, a16.getView(), "em_zplan_create_coupon_insufficient_module", null, null, 12, null);
        a16.show();
    }

    public static /* synthetic */ void Ji(SuitParentFragment suitParentFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        suitParentFragment.Ii(str, z16);
    }

    public static /* synthetic */ void Wh(SuitParentFragment suitParentFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        suitParentFragment.Vh(z16);
    }

    public static /* synthetic */ void Yh(SuitParentFragment suitParentFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        suitParentFragment.Xh(z16);
    }

    public final void aj(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            ki().setVisibility(8);
            li().setVisibility(0);
            li().q("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_created_background.pag", 0, (r13 & 4) != 0 ? null : 2, (r13 & 8) != 0 ? null : bitmap, (r13 & 16) != 0 ? null : null);
        } else {
            ki().setVisibility(0);
            li().setVisibility(8);
        }
    }
}
