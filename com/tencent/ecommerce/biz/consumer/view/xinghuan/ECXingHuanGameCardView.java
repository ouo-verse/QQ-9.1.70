package com.tencent.ecommerce.biz.consumer.view.xinghuan;

import ah0.a;
import ah0.b;
import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewKt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView;
import com.tencent.ecommerce.biz.consumer.view.xinghuan.widget.ECXingHuanNormalButtonView;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.ecommerce.biz.consumer.xinghuan.IGameEventListener;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.ButtonInfo;
import com.tencent.ecommerce.repo.consumer.resp.GameBasicInfo;
import com.tencent.ecommerce.repo.consumer.resp.GameDownLoadInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00ad\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u00ae\u0001\u00af\u0001\u00b0\u0001B\u0011\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ac\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u0007J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0012\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010)\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010&H\u0016J,\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0,2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J,\u0010/\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0,H\u0016J$\u00100\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0,H\u0016J\u0010\u00101\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u00104\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001a\u0010;\u001a\u00020:2\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u000108H\u0002J*\u0010?\u001a\u00020\u00072\u0006\u0010<\u001a\u00020:2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020=2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010@\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010A\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010C\u001a\u00020B2\u0006\u0010<\u001a\u00020:H\u0002J\b\u0010D\u001a\u00020\u0004H\u0002J\u001a\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010G\u001a\u00020\u0007H\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020\u0007H\u0002J\b\u0010J\u001a\u00020\u0007H\u0002J\u0018\u0010L\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010K\u001a\u00020&H\u0002J\u0018\u0010M\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010K\u001a\u00020&H\u0002J\u0010\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\rH\u0002J\b\u0010P\u001a\u00020\u0004H\u0002J\b\u0010Q\u001a\u00020\u0004H\u0002J\b\u0010R\u001a\u00020\u0004H\u0002J\u0010\u0010T\u001a\u00020S2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010U\u001a\u00020\u0004H\u0002J\b\u0010V\u001a\u00020\u0007H\u0002R\u0014\u0010Y\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010[\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010XR\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010g\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010XR\u0014\u0010i\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010dR\u0014\u0010k\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010dR\u0014\u0010m\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010XR\u0014\u0010o\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010XR\u0014\u0010q\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010XR\u0014\u0010r\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010^R\u0014\u0010s\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010XR\u0014\u0010t\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010dR\u0014\u0010u\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010XR\u0014\u0010v\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010dR\u0014\u0010w\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010dR\u0014\u0010z\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010yR\u0018\u0010|\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010}R\u0018\u0010\u007f\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010{R\u0017\u0010\u0080\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00105R\u0017\u0010\u0081\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00105R\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bQ\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bT\u0010\u0082\u0001R\u001b\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bO\u0010\u0086\u0001R\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bL\u0010\u0088\u0001R\u001a\u0010\u008b\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bJ\u0010\u008a\u0001R\u001a\u0010\u008c\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bI\u0010\u008a\u0001R\u0017\u0010\u008d\u0001\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010MR\u0017\u0010\u008e\u0001\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010MR\u0017\u0010\u008f\u0001\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010MR\u0018\u0010\u0091\u0001\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010MR \u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020S0\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0094\u0001R \u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0094\u0001R,\u0010\u009c\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0,0\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0094\u0001R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R \u0010\u00a0\u0001\u001a\t\u0012\u0004\u0012\u00020B0\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0094\u0001R\u001a\u0010\u00a4\u0001\u001a\u00030\u00a1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0017\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u00105R\u0017\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a6\u0001\u00105R\u0017\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a7\u0001\u00105R\u0017\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a8\u0001\u00105R\u0018\u0010\u00aa\u0001\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a9\u0001\u0010M\u00a8\u0006\u00b1\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IGameEventListener;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "view", "", "url", "onClickButton", "X", "appId", "followStatus", "subscribeStatus", "onFollowOrSubscribeStatusChange", "progress", "taskStatus", "onDownloadTaskStatusChange", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "uiType", "configCardUI", "updateUIByType", "resetToSmallCardIfNeed", "getView", "getBigView", "getUIType", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "ext", "onWrapperViewAppear", "onWrapperViewDisappear", "onClickReport", "N", "feedId", "O", "J", "I", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/repo/consumer/resp/ButtonInfo;", "buttonInfo", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "M", "btn", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$a;", "btnStyle", "f0", "H", "K", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$BtnConstruct;", "P", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanBaseBigCardView;", "L", "d0", "Y", "c0", "b0", "onCloseClick", "a0", "Z", "contentId", "W", ExifInterface.LATITUDE_SOUTH, "U", "T", "", "V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "e0", "d", "Landroid/view/View;", "smallLayout", "e", "smallBgView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "smallIconView", h.F, "smallTitleContainerView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "smallTipsView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "smallDivisionView", BdhLogUtil.LogTag.Tag_Conn, "smallTitleView", "D", "smallTitleTagView", "E", "mediumLayout", UserInfo.SEX_FEMALE, "mediumContainer", "G", "mediumBgView", "mediumCoverView", "mediumTitleContainerView", "mediumTitleView", "mediumSubtitleLayout", "mediumSubtitleTagView", "mediumSubtitleView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mediumBtnLayout", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "mediumBtn", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanBaseBigCardView;", "bigLayout", "bigBtn", "originUIType", "curUIType", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "smallCardUIInfo", "mediumCardUIInfo", "Lah0/a;", "Lah0/a;", "ecAnimationSet", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "onClickEventListener", "Landroid/view/View$OnClickListener;", "onCloseAnimStartListener", "onCloseAnimEndListener", "isMediumCardUIConfig", "isDetached", "isMediumBtnSet", "g0", "isBigBtnSet", "Landroid/util/SparseArray;", "h0", "Landroid/util/SparseArray;", "exposeRecordMap", "", "i0", "exposeTimeMap", "j0", "exposeReportParamsMap", "k0", "exposeExtMap", "l0", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "m0", "btnConstructMap", "Lph0/a;", "n0", "Lph0/a;", "btnData", "o0", "p0", "q0", "r0", "s0", "isFirstConfig", "<init>", "(Landroid/content/Context;)V", "F0", "BtnConstruct", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECXingHuanGameCardView extends FrameLayout implements IECGoodsCardView, IGameEventListener {
    private static final Lazy A0;
    private static final Lazy B0;
    private static final Lazy C0;
    private static final b D0;
    private static final b E0;

    /* renamed from: F0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: t0, reason: collision with root package name */
    private static final Lazy f101869t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final Lazy f101870u0;

    /* renamed from: v0, reason: collision with root package name */
    private static final Lazy f101871v0;

    /* renamed from: w0, reason: collision with root package name */
    private static final Lazy f101872w0;

    /* renamed from: x0, reason: collision with root package name */
    private static final Lazy f101873x0;

    /* renamed from: y0, reason: collision with root package name */
    private static final Lazy f101874y0;

    /* renamed from: z0, reason: collision with root package name */
    private static final Lazy f101875z0;

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView smallTitleView;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView smallTitleTagView;

    /* renamed from: E, reason: from kotlin metadata */
    private final View mediumLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private final View mediumContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private final View mediumBgView;

    /* renamed from: H, reason: from kotlin metadata */
    private final ImageView mediumCoverView;

    /* renamed from: I, reason: from kotlin metadata */
    private final View mediumTitleContainerView;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView mediumTitleView;

    /* renamed from: K, reason: from kotlin metadata */
    private final View mediumSubtitleLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView mediumSubtitleTagView;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView mediumSubtitleView;

    /* renamed from: N, reason: from kotlin metadata */
    private final ViewGroup mediumBtnLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private IECXingHuanGameButton mediumBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECXingHuanBaseBigCardView bigLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private IECXingHuanGameButton bigBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private int originUIType;

    /* renamed from: T, reason: from kotlin metadata */
    private int curUIType;

    /* renamed from: U, reason: from kotlin metadata */
    private UIInfo smallCardUIInfo;

    /* renamed from: V, reason: from kotlin metadata */
    private UIInfo mediumCardUIInfo;

    /* renamed from: W, reason: from kotlin metadata */
    private a ecAnimationSet;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private IECGoodsCardView.IGoodsCardClickListener onClickEventListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onCloseAnimStartListener;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onCloseAnimEndListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View smallLayout;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isMediumCardUIConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View smallBgView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isDetached;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView smallIconView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean isMediumBtnSet;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isBigBtnSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View smallTitleContainerView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private SparseArray<Boolean> exposeRecordMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView smallTipsView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private SparseArray<Long> exposeTimeMap;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private SparseArray<com.tencent.ecommerce.biz.consumer.report.b> exposeReportParamsMap;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private SparseArray<Map<String, String>> exposeExtMap;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private ECContentInfo contentInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View smallDivisionView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private SparseArray<BtnConstruct> btnConstructMap;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private ph0.a btnData;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private int taskStatus;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private int subscribeStatus;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private int followStatus;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private int progress;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstConfig;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$BtnConstruct;", "", "(Ljava/lang/String;I)V", "GAME", "CUSTOM", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum BtnConstruct {
        GAME,
        CUSTOM
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001b\u0010\u001e\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0014R\u001b\u0010!\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0014R\u001b\u0010$\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0014R\u0017\u0010&\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b+\u0010)R\u0014\u0010-\u001a\u00020,8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00104\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u00101R\u0014\u00105\u001a\u00020,8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u0010.R\u0014\u00106\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$b;", "", "", "MAX_WIDTH$delegate", "Lkotlin/Lazy;", "i", "()I", "MAX_WIDTH", "COVER_IMAGE_SIZE$delegate", "g", "COVER_IMAGE_SIZE", "ICON_IMAGE_SIZE$delegate", h.F, "ICON_IMAGE_SIZE", "MEDIUM_BTN_TEXT_SIZE$delegate", "k", "MEDIUM_BTN_TEXT_SIZE", "", "MEDIUM_BTN_WIDTH$delegate", "l", "()F", "MEDIUM_BTN_WIDTH", "MEDIUM_BTN_HEIGHT$delegate", "j", "MEDIUM_BTN_HEIGHT", "BIG_BTN_TEXT_SIZE$delegate", "d", "BIG_BTN_TEXT_SIZE", "BIG_BTN_WIDTH$delegate", "e", "BIG_BTN_WIDTH", "BIG_BTN_HEIGHT$delegate", "c", "BIG_BTN_HEIGHT", "BTN_BG_CORNER$delegate", "f", "BTN_BG_CORNER", "Lah0/b;", "BEZIER_INTERPOLATOR_TRANSLATION", "Lah0/b;", "b", "()Lah0/b;", "BEZIER_INTERPOLATOR_SCALE", "a", "", "ANIMATION_DURATION", "J", "", "DEFAULT_BUTTON_COLOR", "Ljava/lang/String;", "DEFAULT_PROGRESS_BG_COLOR", "DEFAULT_PROGRESS_FG_COLOR", "DEFAULT_TEXT_COLOR", "HALF_ANIMATION_DURATION", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$b, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final b a() {
            return ECXingHuanGameCardView.E0;
        }

        public final b b() {
            return ECXingHuanGameCardView.D0;
        }

        public final float c() {
            return ((Number) ECXingHuanGameCardView.B0.getValue()).floatValue();
        }

        public final int d() {
            return ((Number) ECXingHuanGameCardView.f101875z0.getValue()).intValue();
        }

        public final float e() {
            return ((Number) ECXingHuanGameCardView.A0.getValue()).floatValue();
        }

        public final float f() {
            return ((Number) ECXingHuanGameCardView.C0.getValue()).floatValue();
        }

        public final int g() {
            return ((Number) ECXingHuanGameCardView.f101870u0.getValue()).intValue();
        }

        public final int h() {
            return ((Number) ECXingHuanGameCardView.f101871v0.getValue()).intValue();
        }

        public final int i() {
            return ((Number) ECXingHuanGameCardView.f101869t0.getValue()).intValue();
        }

        public final float j() {
            return ((Number) ECXingHuanGameCardView.f101874y0.getValue()).floatValue();
        }

        public final int k() {
            return ((Number) ECXingHuanGameCardView.f101872w0.getValue()).intValue();
        }

        public final float l() {
            return ((Number) ECXingHuanGameCardView.f101873x0.getValue()).floatValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$configBigCardUI$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101904d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECXingHuanGameCardView f101905e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f101906f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ECContentInfo f101907h;

        c(View.OnClickListener onClickListener, ECXingHuanGameCardView eCXingHuanGameCardView, Ref.ObjectRef objectRef, ECContentInfo eCContentInfo) {
            this.f101904d = onClickListener;
            this.f101905e = eCXingHuanGameCardView;
            this.f101906f = objectRef;
            this.f101907h = eCContentInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int R = this.f101905e.R();
            if (R == this.f101905e.U()) {
                this.f101905e.a0(this.f101907h, this.f101904d);
            } else if (R == this.f101905e.T()) {
                this.f101905e.Z(this.f101907h, this.f101904d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101909e;

        d(UIInfo uIInfo) {
            this.f101909e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECXingHuanGameCardView.this.mediumLayout.setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = ECXingHuanGameCardView.this.onClickEventListener;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECXingHuanGameCardView.this.mediumLayout, ECGoodsCommonUtils.f101579a.o(this.f101909e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101911e;

        e(UIInfo uIInfo) {
            this.f101911e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECXingHuanGameCardView.this.smallLayout.setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = ECXingHuanGameCardView.this.onClickEventListener;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECXingHuanGameCardView.this.smallLayout, ECGoodsCommonUtils.f101579a.o(this.f101911e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$MAX_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                int f16 = (int) (ECDeviceUtils.f104857e.f() * 0.72f);
                if (f16 > 0) {
                    return f16;
                }
                cg0.a.a("ECXingHuanGameCardView", "MAX_WIDTH", "getScreenWidth is zero");
                return Integer.MAX_VALUE;
            }
        });
        f101869t0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$COVER_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(36.0f);
            }
        });
        f101870u0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$ICON_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(24.0f);
            }
        });
        f101871v0 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$MEDIUM_BTN_TEXT_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(12.0f);
            }
        });
        f101872w0 = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$MEDIUM_BTN_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(64.0f);
            }
        });
        f101873x0 = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$MEDIUM_BTN_HEIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(28.0f);
            }
        });
        f101874y0 = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$BIG_BTN_TEXT_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(14.0f);
            }
        });
        f101875z0 = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$BIG_BTN_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(244.0f);
            }
        });
        A0 = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$BIG_BTN_HEIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(32.0f);
            }
        });
        B0 = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$Companion$BTN_BG_CORNER$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(4.0f);
            }
        });
        C0 = lazy10;
        D0 = new b(0.32f, 0.94f, 0.6f, 1.0f);
        E0 = new b(0.26f, 1.0f, 0.48f, 1.0f);
    }

    public ECXingHuanGameCardView(Context context) {
        super(context);
        this.originUIType = -1;
        this.curUIType = -1;
        this.exposeRecordMap = new SparseArray<>();
        this.exposeTimeMap = new SparseArray<>();
        this.exposeReportParamsMap = new SparseArray<>();
        this.exposeExtMap = new SparseArray<>();
        this.btnConstructMap = new SparseArray<>();
        this.btnData = new ph0.a();
        this.isFirstConfig = true;
        com.tencent.ecommerce.base.device.a.f100685b.f(context, LayoutInflater.from(context).inflate(R.layout.cv8, (ViewGroup) this, true));
        View findViewById = findViewById(R.id.oao);
        this.smallLayout = findViewById;
        this.smallBgView = findViewById(R.id.oai);
        this.smallIconView = (ImageView) findViewById(R.id.oam);
        this.smallTitleContainerView = findViewById(R.id.oaq);
        this.smallTipsView = (TextView) findViewById(R.id.oap);
        this.smallDivisionView = findViewById(R.id.oaj);
        this.smallTitleView = (TextView) findViewById(R.id.oas);
        this.smallTitleTagView = (TextView) findViewById(R.id.oar);
        View findViewById2 = findViewById(R.id.o4n);
        this.mediumLayout = findViewById2;
        this.mediumBgView = findViewById(R.id.o4d);
        this.mediumContainer = findViewById(R.id.o4i);
        this.mediumCoverView = (ImageView) findViewById(R.id.o4j);
        this.mediumTitleContainerView = findViewById(R.id.o4u);
        this.mediumTitleView = (TextView) findViewById(R.id.o4v);
        this.mediumSubtitleLayout = findViewById(R.id.o4r);
        this.mediumSubtitleTagView = (TextView) findViewById(R.id.o4s);
        this.mediumSubtitleView = (TextView) findViewById(R.id.o4t);
        this.mediumBtnLayout = (ViewGroup) findViewById(R.id.o4e);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$c, T] */
    private final void H(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (this.bigLayout == null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            this.bigLayout = L(contentInfo, uiType);
            View.OnClickListener onClickListener = this.onCloseAnimStartListener;
            if (onClickListener != null) {
                objectRef.element = new c(onClickListener, this, objectRef, contentInfo);
            }
            ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
            if (eCXingHuanBaseBigCardView != null) {
                eCXingHuanBaseBigCardView.setVisibility(8);
            }
            ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2 = this.bigLayout;
            if (eCXingHuanBaseBigCardView2 != null) {
                eCXingHuanBaseBigCardView2.f(uiType, uiInfo, K(uiType, uiInfo), this.onClickEventListener, (View.OnClickListener) objectRef.element);
            }
        }
    }

    private final void I(UIInfo uiInfo) {
        if (this.isMediumCardUIConfig) {
            return;
        }
        this.mediumCardUIInfo = uiInfo;
        if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
            Companion companion = INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.mediumCoverView, new IECImageLoader.ImageLoaderOption(companion.g(), companion.g(), 0, null, null, null, false, false, null, 508, null));
        }
        this.mediumTitleView.setText(uiInfo.getTitle());
        this.mediumSubtitleView.setText(uiInfo.getSubtitle());
        this.mediumSubtitleTagView.setVisibility(TextUtils.isEmpty(uiInfo.getActivityTagInfo().getText()) ^ true ? 0 : 8);
        this.mediumSubtitleTagView.setText(uiInfo.getActivityTagInfo().getText());
        IECXingHuanGameButton M = M(getContext(), uiInfo.getButtonInfo());
        this.mediumBtnLayout.addView(M.getView(), new FrameLayout.LayoutParams(-1, -1));
        Companion companion2 = INSTANCE;
        f0(M, uiInfo, new BtnStyle(companion2.k(), companion2.l(), companion2.j()), this);
        M.getView().setTag(R.id.nte, Integer.valueOf(T()));
        this.btnConstructMap.put(T(), P(M));
        Unit unit = Unit.INSTANCE;
        this.mediumBtn = M;
        this.isMediumBtnSet = true;
        this.mediumLayout.setOnClickListener(new d(uiInfo));
        this.isMediumCardUIConfig = true;
    }

    private final void J(UIInfo uiInfo) {
        this.smallCardUIInfo = uiInfo;
        Companion companion = INSTANCE;
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.smallIconView, new IECImageLoader.ImageLoaderOption(companion.h(), companion.h(), 0, null, null, ResourcesCompat.getDrawable(getResources(), R.drawable.dhw, null), false, false, null, com.tencent.luggage.wxa.j2.c.CTRL_INDEX, null));
        this.smallTitleView.setText(uiInfo.getTitle());
        this.smallTitleTagView.setVisibility(TextUtils.isEmpty(uiInfo.getActivityTagInfo().getText()) ^ true ? 0 : 8);
        this.smallTitleTagView.setText(uiInfo.getActivityTagInfo().getText());
        this.smallLayout.setOnClickListener(new e(uiInfo));
    }

    private final IECXingHuanGameButton K(int uiType, UIInfo uiInfo) {
        IECXingHuanGameButton M = M(getContext(), uiInfo.getButtonInfo());
        Companion companion = INSTANCE;
        f0(M, uiInfo, new BtnStyle(companion.d(), companion.e(), companion.c()), null);
        M.getView().setTag(R.id.nte, Integer.valueOf(uiType));
        M.addEventListener(this);
        this.btnConstructMap.put(uiType, P(M));
        this.bigBtn = M;
        this.isBigBtnSet = true;
        return M;
    }

    private final IECXingHuanGameButton M(Context context, ButtonInfo buttonInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[createButton] text: ");
        sb5.append(buttonInfo != null ? buttonInfo.getButtonText() : null);
        sb5.append(", ");
        sb5.append("useGameCustomButton: ");
        sb5.append(buttonInfo != null ? Boolean.valueOf(buttonInfo.getUseGameCustomButton()) : null);
        cg0.a.b("ECXingHuanGameCardView", sb5.toString());
        if (buttonInfo != null && buttonInfo.getUseGameCustomButton()) {
            ECXingHuanNormalButtonView eCXingHuanNormalButtonView = new ECXingHuanNormalButtonView(context);
            eCXingHuanNormalButtonView.setButtonInfo(buttonInfo);
            return eCXingHuanNormalButtonView;
        }
        return QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().createXingHuanGameButton(context);
    }

    private final void N(UIInfo uiInfo) {
        GameBasicInfo basic = uiInfo.getGameInfo().getBasic();
        this.btnData.l(String.valueOf(basic.getAppId()));
        this.btnData.m(basic.getAppName());
        GameDownLoadInfo download = uiInfo.getGameInfo().getDownload();
        this.btnData.o(download.getPkgName());
        this.btnData.k(download.getAndroidDownloadUrl());
        this.btnData.p(download.getAndroidPkgSize());
        this.btnData.n(download.getIconUrl());
        this.btnData.j(download.getChannelId());
        this.btnData.q(O(download.getContentId()));
    }

    private final String O(String feedId) {
        return "{\"ext_module\":9392,\"ext_sub_module\":939201,\"gamecenter_src\":\"xiaoshijie_shangka_" + feedId + "\"}";
    }

    private final BtnConstruct P(IECXingHuanGameButton btn) {
        if (btn instanceof ECXingHuanNormalButtonView) {
            return BtnConstruct.CUSTOM;
        }
        return BtnConstruct.GAME;
    }

    private final int Q() {
        return ECGoodsCommonUtils.f101579a.d(this.followStatus, this.subscribeStatus, this.taskStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R() {
        if (this.smallCardUIInfo != null) {
            return U();
        }
        if (this.mediumCardUIInfo != null) {
            return T();
        }
        return S();
    }

    private final int S() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T() {
        return 421;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int U() {
        return 420;
    }

    private final boolean V(int uiType) {
        if (uiType != 422 && uiType != 423 && uiType != 424 && uiType != 425 && uiType != 426) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(String contentId) {
        IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
        if (videoControl != null) {
            videoControl.sendVideoInfoViewShowEvent(contentId, true, true);
        }
    }

    private final void Y() {
        ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
        if (eCXingHuanBaseBigCardView != null) {
            eCXingHuanBaseBigCardView.setVisibility(4);
        }
        ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2 = this.bigLayout;
        if (eCXingHuanBaseBigCardView2 != null) {
            eCXingHuanBaseBigCardView2.post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$startAnimBigAppear$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView3;
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView4;
                    eCXingHuanBaseBigCardView3 = ECXingHuanGameCardView.this.bigLayout;
                    if (eCXingHuanBaseBigCardView3 != null) {
                        ViewKt.setVisible(eCXingHuanBaseBigCardView3, true);
                    }
                    eCXingHuanBaseBigCardView4 = ECXingHuanGameCardView.this.bigLayout;
                    if (eCXingHuanBaseBigCardView4 != null) {
                        eCXingHuanBaseBigCardView4.i();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(final ECContentInfo contentInfo, View.OnClickListener onCloseClick) {
        this.mediumLayout.setVisibility(4);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$startAnimBigChangeToMedium$1
            @Override // java.lang.Runnable
            public final void run() {
                View view;
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView;
                View view2;
                View view3;
                ImageView imageView;
                ImageView imageView2;
                int[] iArr = new int[2];
                view = ECXingHuanGameCardView.this.mediumBgView;
                view.getLocationInWindow(iArr);
                eCXingHuanBaseBigCardView = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView != null) {
                    view2 = ECXingHuanGameCardView.this.mediumBgView;
                    int width = view2.getWidth();
                    view3 = ECXingHuanGameCardView.this.mediumBgView;
                    int height = view3.getHeight();
                    imageView = ECXingHuanGameCardView.this.mediumCoverView;
                    int width2 = imageView.getWidth();
                    imageView2 = ECXingHuanGameCardView.this.mediumCoverView;
                    eCXingHuanBaseBigCardView.j(width, height, width2, imageView2.getHeight(), iArr, new a());
                }
                ECXingHuanGameCardView.this.W(contentInfo.getContentId());
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$startAnimBigChangeToMedium$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView;
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2;
                    View.OnClickListener onClickListener;
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView3;
                    ECXingHuanGameCardView.this.smallLayout.setVisibility(8);
                    ECXingHuanGameCardView.this.mediumLayout.setVisibility(0);
                    eCXingHuanBaseBigCardView = ECXingHuanGameCardView.this.bigLayout;
                    if (eCXingHuanBaseBigCardView != null) {
                        ViewKt.setVisible(eCXingHuanBaseBigCardView, false);
                    }
                    eCXingHuanBaseBigCardView2 = ECXingHuanGameCardView.this.bigLayout;
                    if (eCXingHuanBaseBigCardView2 != null) {
                        eCXingHuanBaseBigCardView2.h();
                    }
                    ECXingHuanGameCardView eCXingHuanGameCardView = ECXingHuanGameCardView.this;
                    eCXingHuanGameCardView.curUIType = eCXingHuanGameCardView.T();
                    onClickListener = ECXingHuanGameCardView.this.onCloseAnimEndListener;
                    if (onClickListener != null) {
                        eCXingHuanBaseBigCardView3 = ECXingHuanGameCardView.this.bigLayout;
                        onClickListener.onClick(eCXingHuanBaseBigCardView3);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }
            }
        });
        ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
        if (eCXingHuanBaseBigCardView != null) {
            eCXingHuanBaseBigCardView.setTag(R.id.oc6, Integer.valueOf(T()));
        }
        onCloseClick.onClick(this.bigLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(final ECContentInfo contentInfo, View.OnClickListener onCloseClick) {
        this.smallLayout.setVisibility(4);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$startAnimBigChangeToSmall$1
            @Override // java.lang.Runnable
            public final void run() {
                View view;
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView;
                View view2;
                View view3;
                ImageView imageView;
                ImageView imageView2;
                int[] iArr = new int[2];
                view = ECXingHuanGameCardView.this.smallBgView;
                view.getLocationInWindow(iArr);
                eCXingHuanBaseBigCardView = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView != null) {
                    view2 = ECXingHuanGameCardView.this.smallBgView;
                    int width = view2.getWidth();
                    view3 = ECXingHuanGameCardView.this.smallBgView;
                    int height = view3.getHeight();
                    imageView = ECXingHuanGameCardView.this.smallIconView;
                    int width2 = imageView.getWidth();
                    imageView2 = ECXingHuanGameCardView.this.smallIconView;
                    eCXingHuanBaseBigCardView.k(width, height, width2, imageView2.getHeight(), iArr, new a());
                }
                ECXingHuanGameCardView.this.W(contentInfo.getContentId());
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$startAnimBigChangeToSmall$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView;
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2;
                    View.OnClickListener onClickListener;
                    ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView3;
                    ECXingHuanGameCardView.this.smallLayout.setVisibility(0);
                    ECXingHuanGameCardView.this.mediumLayout.setVisibility(8);
                    eCXingHuanBaseBigCardView = ECXingHuanGameCardView.this.bigLayout;
                    if (eCXingHuanBaseBigCardView != null) {
                        ViewKt.setVisible(eCXingHuanBaseBigCardView, false);
                    }
                    eCXingHuanBaseBigCardView2 = ECXingHuanGameCardView.this.bigLayout;
                    if (eCXingHuanBaseBigCardView2 != null) {
                        eCXingHuanBaseBigCardView2.h();
                    }
                    ECXingHuanGameCardView eCXingHuanGameCardView = ECXingHuanGameCardView.this;
                    eCXingHuanGameCardView.curUIType = eCXingHuanGameCardView.U();
                    onClickListener = ECXingHuanGameCardView.this.onCloseAnimEndListener;
                    if (onClickListener != null) {
                        eCXingHuanBaseBigCardView3 = ECXingHuanGameCardView.this.bigLayout;
                        onClickListener.onClick(eCXingHuanBaseBigCardView3);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }
            }
        });
        ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
        if (eCXingHuanBaseBigCardView != null) {
            eCXingHuanBaseBigCardView.setTag(R.id.oc6, Integer.valueOf(U()));
        }
        onCloseClick.onClick(this.bigLayout);
    }

    private final void b0() {
        ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
        if (eCXingHuanBaseBigCardView != null) {
            eCXingHuanBaseBigCardView.setVisibility(4);
        }
        final int[] iArr = new int[2];
        this.mediumBgView.getLocationInWindow(iArr);
        final int[] iArr2 = new int[2];
        this.mediumBtnLayout.getLocationInWindow(iArr2);
        final int[] iArr3 = new int[2];
        this.mediumTitleView.getLocationInWindow(iArr3);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$startAnimMediumChangeToBig$1
            @Override // java.lang.Runnable
            public final void run() {
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2;
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView3;
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView4;
                View view;
                View view2;
                ImageView imageView;
                ImageView imageView2;
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                ECXingHuanGameCardView.this.mediumLayout.setVisibility(4);
                eCXingHuanBaseBigCardView2 = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView2 != null) {
                    ViewKt.setVisible(eCXingHuanBaseBigCardView2, true);
                }
                eCXingHuanBaseBigCardView3 = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView3 != null) {
                    eCXingHuanBaseBigCardView3.h();
                }
                eCXingHuanBaseBigCardView4 = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView4 != null) {
                    view = ECXingHuanGameCardView.this.mediumBgView;
                    int width = view.getWidth();
                    view2 = ECXingHuanGameCardView.this.mediumBgView;
                    int height = view2.getHeight();
                    imageView = ECXingHuanGameCardView.this.mediumCoverView;
                    int width2 = imageView.getWidth();
                    imageView2 = ECXingHuanGameCardView.this.mediumCoverView;
                    int height2 = imageView2.getHeight();
                    viewGroup = ECXingHuanGameCardView.this.mediumBtnLayout;
                    int width3 = viewGroup.getWidth();
                    viewGroup2 = ECXingHuanGameCardView.this.mediumBtnLayout;
                    eCXingHuanBaseBigCardView4.l(width, height, width2, height2, width3, viewGroup2.getHeight(), iArr, iArr2, iArr3, new a());
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$startAnimMediumChangeToBig$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECXingHuanGameCardView.this.mediumLayout.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }
            }
        });
    }

    private final void c0() {
        ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
        if (eCXingHuanBaseBigCardView != null) {
            eCXingHuanBaseBigCardView.setVisibility(4);
        }
        final int[] iArr = new int[2];
        this.smallBgView.getLocationInWindow(iArr);
        final int[] iArr2 = new int[2];
        this.smallTitleView.getLocationInWindow(iArr2);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$startAnimSmallChangeToBig$1
            @Override // java.lang.Runnable
            public final void run() {
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2;
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView3;
                ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView4;
                View view;
                View view2;
                ImageView imageView;
                ImageView imageView2;
                ECXingHuanGameCardView.this.smallLayout.setVisibility(4);
                eCXingHuanBaseBigCardView2 = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView2 != null) {
                    ViewKt.setVisible(eCXingHuanBaseBigCardView2, true);
                }
                eCXingHuanBaseBigCardView3 = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView3 != null) {
                    eCXingHuanBaseBigCardView3.h();
                }
                eCXingHuanBaseBigCardView4 = ECXingHuanGameCardView.this.bigLayout;
                if (eCXingHuanBaseBigCardView4 != null) {
                    view = ECXingHuanGameCardView.this.smallBgView;
                    int width = view.getWidth();
                    view2 = ECXingHuanGameCardView.this.smallBgView;
                    int height = view2.getHeight();
                    imageView = ECXingHuanGameCardView.this.smallIconView;
                    int width2 = imageView.getWidth();
                    imageView2 = ECXingHuanGameCardView.this.smallIconView;
                    eCXingHuanBaseBigCardView4.m(width, height, width2, imageView2.getHeight(), iArr, iArr2, new a());
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$startAnimSmallChangeToBig$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECXingHuanGameCardView.this.smallLayout.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }
            }
        });
    }

    private final void d0() {
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$startAnimSmallChangeToMedium$1
            @Override // java.lang.Runnable
            public final void run() {
                TextView textView;
                TextView textView2;
                ViewGroup viewGroup;
                a.C0035a a16;
                View view;
                a.C0035a a17;
                View view2;
                View view3;
                View view4;
                View view5;
                TextView textView3;
                ImageView imageView;
                a.C0035a a18;
                ImageView imageView2;
                ImageView imageView3;
                ImageView imageView4;
                ImageView imageView5;
                ImageView imageView6;
                ImageView imageView7;
                ImageView imageView8;
                ECXingHuanGameCardView.this.mediumLayout.setVisibility(0);
                ECXingHuanGameCardView.this.smallLayout.setVisibility(8);
                textView = ECXingHuanGameCardView.this.mediumTitleView;
                textView.getLocationInWindow(new int[2]);
                textView2 = ECXingHuanGameCardView.this.smallTitleView;
                textView2.getLocationInWindow(new int[2]);
                ECXingHuanGameCardView eCXingHuanGameCardView = ECXingHuanGameCardView.this;
                a.C0035a c0035a = new a.C0035a(400L);
                viewGroup = ECXingHuanGameCardView.this.mediumBtnLayout;
                a16 = c0035a.a(viewGroup, 0.0f, 1.0f, (r26 & 8) != 0 ? c0035a.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                view = ECXingHuanGameCardView.this.mediumSubtitleLayout;
                a17 = a16.a(view, 0.0f, 1.0f, (r26 & 8) != 0 ? a16.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                view2 = ECXingHuanGameCardView.this.mediumBgView;
                float width = ECXingHuanGameCardView.this.smallLayout.getWidth();
                view3 = ECXingHuanGameCardView.this.mediumBgView;
                float width2 = width / view3.getWidth();
                float height = ECXingHuanGameCardView.this.smallLayout.getHeight();
                view4 = ECXingHuanGameCardView.this.mediumBgView;
                float height2 = height / view4.getHeight();
                view5 = ECXingHuanGameCardView.this.mediumBgView;
                float height3 = view5.getHeight();
                ECXingHuanGameCardView.Companion companion = ECXingHuanGameCardView.INSTANCE;
                a.C0035a f16 = a.C0035a.f(a17, view2, width2, 1.0f, height2, 1.0f, 0.0f, height3, 0L, false, companion.b(), null, 0L, 3488, null);
                textView3 = ECXingHuanGameCardView.this.mediumTitleView;
                a.C0035a j3 = a.C0035a.j(f16, textView3, r1[0] - r3[0], r1[1] - r3[1], 0.0f, 0.0f, 0L, false, companion.b(), null, g.CTRL_INDEX, null);
                imageView = ECXingHuanGameCardView.this.mediumCoverView;
                a18 = j3.a(imageView, 0.0f, 1.0f, (r26 & 8) != 0 ? j3.duration : 400L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                imageView2 = ECXingHuanGameCardView.this.mediumCoverView;
                imageView3 = ECXingHuanGameCardView.this.smallIconView;
                float width3 = imageView3.getWidth();
                imageView4 = ECXingHuanGameCardView.this.mediumCoverView;
                float width4 = width3 / imageView4.getWidth();
                imageView5 = ECXingHuanGameCardView.this.smallIconView;
                float height4 = imageView5.getHeight();
                imageView6 = ECXingHuanGameCardView.this.mediumCoverView;
                float height5 = height4 / imageView6.getHeight();
                imageView7 = ECXingHuanGameCardView.this.mediumCoverView;
                float f17 = -imageView7.getLeft();
                imageView8 = ECXingHuanGameCardView.this.mediumCoverView;
                eCXingHuanGameCardView.ecAnimationSet = a.C0035a.f(a18, imageView2, width4, 1.0f, height5, 1.0f, f17, imageView8.getBottom(), 0L, false, companion.a(), null, 0L, 3456, null).c().b();
            }
        });
    }

    private final void e0() {
        ECContentInfo eCContentInfo = this.contentInfo;
        boolean isContinuation = eCContentInfo != null ? eCContentInfo.getIsContinuation() : false;
        com.tencent.ecommerce.biz.consumer.report.b bVar = this.exposeReportParamsMap.get(this.curUIType);
        Map<String, String> map = this.exposeExtMap.get(this.curUIType);
        SparseArray<Boolean> sparseArray = this.exposeRecordMap;
        int i3 = this.curUIType;
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = sparseArray.get(i3, bool);
        this.exposeRecordMap.put(this.curUIType, bool);
        if (bVar == null || map == null || !bool2.booleanValue()) {
            return;
        }
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        bVar.d(Q());
        bVar.b(this.btnData.getAppId());
        bVar.m(bVar.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
        bVar.s(com.tencent.ecommerce.biz.util.b.a(isContinuation));
        Unit unit = Unit.INSTANCE;
        aVar.d(bVar, map);
    }

    private final void f0(IECXingHuanGameButton btn, UIInfo uiInfo, BtnStyle btnStyle, IGameEventListener listener) {
        String str;
        ButtonInfo buttonInfo = uiInfo.getButtonInfo();
        if (TextUtils.isEmpty(buttonInfo != null ? buttonInfo.getButtonBgColor() : null)) {
            str = "linear-gradient(to right, #FF46A0 0%, #FF3355 100%)";
        } else {
            ButtonInfo buttonInfo2 = uiInfo.getButtonInfo();
            String buttonBgColor = buttonInfo2 != null ? buttonInfo2.getButtonBgColor() : null;
            Intrinsics.checkNotNull(buttonBgColor);
            str = buttonBgColor;
        }
        ph0.b bVar = new ph0.b();
        bVar.o(INSTANCE.f());
        bVar.z(btnStyle.textSize);
        bVar.u(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        bVar.r(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        ECGoodsCommonUtils eCGoodsCommonUtils = ECGoodsCommonUtils.f101579a;
        bVar.y(eCGoodsCommonUtils.i("#26FFFFFF", bVar.getBgCorner()));
        bVar.x(eCGoodsCommonUtils.g("#1AFFFFFF", btnStyle.btnWidth, btnStyle.btnHeight, bVar.getBgCorner()));
        bVar.t(eCGoodsCommonUtils.g(str, btnStyle.btnWidth, btnStyle.btnHeight, bVar.getBgCorner()));
        bVar.q(eCGoodsCommonUtils.g(str, btnStyle.btnWidth, btnStyle.btnHeight, bVar.getBgCorner()));
        bVar.p(getContext().getResources().getString(R.string.wkj));
        bVar.w(getContext().getResources().getString(R.string.wkm));
        bVar.B(getContext().getResources().getString(R.string.wko));
        bVar.A(getContext().getResources().getString(R.string.wkk));
        bVar.v(getContext().getResources().getString(R.string.wkn));
        bVar.s(getContext().getResources().getString(R.string.wkl));
        btn.setData(this.btnData);
        btn.setUi(bVar);
        btn.update();
        if (listener != null) {
            btn.addEventListener(listener);
        }
    }

    public final void X() {
        IECXingHuanGameButton iECXingHuanGameButton;
        View view;
        View view2;
        cg0.a.b("ECXingHuanGameCardView", "performClickDistributeButton, curUIType:" + getUiType());
        if (V(getUiType())) {
            IECXingHuanGameButton iECXingHuanGameButton2 = this.bigBtn;
            if (iECXingHuanGameButton2 == null || (view2 = iECXingHuanGameButton2.getView()) == null) {
                return;
            }
            view2.performClick();
            return;
        }
        if (getUiType() != T() || (iECXingHuanGameButton = this.mediumBtn) == null || (view = iECXingHuanGameButton.getView()) == null) {
            return;
        }
        view.performClick();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (this.isFirstConfig) {
            this.isFirstConfig = false;
            N(uiInfo);
        }
        try {
            if (uiType == U()) {
                J(uiInfo);
            } else if (uiType == T()) {
                I(uiInfo);
            } else if (V(uiType)) {
                H(contentInfo, uiInfo, uiType);
            }
        } catch (Exception e16) {
            cg0.a.a("ECXingHuanGameCardView", "configCardUI", "exception " + e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getBigView() {
        return this.bigLayout;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    /* renamed from: getUIType, reason: from getter */
    public int getUiType() {
        return this.curUIType;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cg0.a.b("ECXingHuanGameCardView", "[onAttachedToWindow] isDetached: " + this.isDetached + ", isMediumBtnSet: " + this.isMediumBtnSet + ", isBigBtnSet: " + this.isBigBtnSet);
        try {
            if (this.isDetached) {
                this.isDetached = false;
                if (this.isMediumBtnSet) {
                    IECXingHuanGameButton iECXingHuanGameButton = this.mediumBtn;
                    if (iECXingHuanGameButton != null) {
                        iECXingHuanGameButton.update();
                    }
                    IECXingHuanGameButton iECXingHuanGameButton2 = this.mediumBtn;
                    if (iECXingHuanGameButton2 != null) {
                        iECXingHuanGameButton2.addEventListener(this);
                    }
                }
                if (this.isBigBtnSet) {
                    IECXingHuanGameButton iECXingHuanGameButton3 = this.bigBtn;
                    if (iECXingHuanGameButton3 != null) {
                        iECXingHuanGameButton3.update();
                    }
                    IECXingHuanGameButton iECXingHuanGameButton4 = this.bigBtn;
                    if (iECXingHuanGameButton4 != null) {
                        iECXingHuanGameButton4.addEventListener(this);
                    }
                }
            }
        } catch (Exception e16) {
            cg0.a.a("ECXingHuanGameCardView", NodeProps.ON_ATTACHED_TO_WINDOW, "exception " + e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onClickReport(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        reportParams.d(Q());
        reportParams.b(this.btnData.getAppId());
        reportParams.i(reportParams.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
        Unit unit = Unit.INSTANCE;
        aVar.b(reportParams, ext);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IECXingHuanGameButton iECXingHuanGameButton;
        IECXingHuanGameButton iECXingHuanGameButton2;
        super.onDetachedFromWindow();
        cg0.a.b("ECXingHuanGameCardView", "[onDetachedFromWindow]");
        this.isDetached = true;
        try {
            if (this.isMediumBtnSet && (iECXingHuanGameButton2 = this.mediumBtn) != null) {
                iECXingHuanGameButton2.removeEventListener(this);
            }
            if (!this.isBigBtnSet || (iECXingHuanGameButton = this.bigBtn) == null) {
                return;
            }
            iECXingHuanGameButton.removeEventListener(this);
        } catch (Exception e16) {
            cg0.a.a("ECXingHuanGameCardView", NodeProps.ON_DETACHED_FROM_WINDOW, "exception " + e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IGameEventListener
    public void onDownloadTaskStatusChange(String appId, int progress, int taskStatus) {
        if (Intrinsics.areEqual(appId, this.btnData.getAppId())) {
            cg0.a.b("ECXingHuanGameCardView", "onDownloadTaskStatusChange progress=" + progress + ", taskStatus=" + taskStatus);
            this.progress = progress;
            this.taskStatus = taskStatus;
            e0();
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IGameEventListener
    public void onFollowOrSubscribeStatusChange(String appId, int followStatus, int subscribeStatus) {
        if (Intrinsics.areEqual(appId, this.btnData.getAppId())) {
            cg0.a.b("ECXingHuanGameCardView", "onFollowOrSubscribeStatusChange followStatus=" + followStatus + ", subscribeStatus:" + subscribeStatus);
            this.subscribeStatus = subscribeStatus;
            this.followStatus = followStatus;
            if (followStatus == 0 && subscribeStatus == 3) {
                return;
            }
            e0();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        Companion companion = INSTANCE;
        if (size > companion.i()) {
            cg0.a.b("ECXingHuanGameCardView", "adjust width " + size + " to " + companion.i());
            size = companion.i();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewAppear(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
        this.exposeRecordMap.put(this.curUIType, Boolean.TRUE);
        this.exposeTimeMap.put(this.curUIType, Long.valueOf(System.currentTimeMillis()));
        this.exposeReportParamsMap.put(this.curUIType, reportParams);
        this.exposeExtMap.put(this.curUIType, ext);
        this.contentInfo = contentInfo;
        if (this.curUIType == U() || this.btnConstructMap.get(this.curUIType) == BtnConstruct.CUSTOM || Q() != -1) {
            e0();
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        a aVar = this.ecAnimationSet;
        if (aVar != null) {
            aVar.a();
        }
        long currentTimeMillis = this.exposeTimeMap.get(uiType) != null ? System.currentTimeMillis() - this.exposeTimeMap.get(uiType).longValue() : -1L;
        this.exposeTimeMap.remove(uiType);
        com.tencent.ecommerce.biz.consumer.report.a aVar2 = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        reportParams.d(Q());
        reportParams.b(this.btnData.getAppId());
        reportParams.k(reportParams.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
        reportParams.l(currentTimeMillis);
        Unit unit = Unit.INSTANCE;
        aVar2.c(reportParams, ext);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void resetToSmallCardIfNeed(int uiType) {
        int R = R();
        if (R == U()) {
            this.smallLayout.setVisibility(0);
            this.smallLayout.setAlpha(1.0f);
            this.mediumLayout.setVisibility(8);
            this.curUIType = U();
            ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
            if (eCXingHuanBaseBigCardView != null) {
                ViewKt.setVisible(eCXingHuanBaseBigCardView, false);
                return;
            }
            return;
        }
        if (R == T()) {
            this.smallLayout.setVisibility(8);
            this.mediumLayout.setVisibility(0);
            this.mediumLayout.setAlpha(1.0f);
            this.curUIType = T();
            ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2 = this.bigLayout;
            if (eCXingHuanBaseBigCardView2 != null) {
                ViewKt.setVisible(eCXingHuanBaseBigCardView2, false);
            }
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener) {
        this.onCloseAnimStartListener = animStartListener;
        this.onCloseAnimEndListener = animEndListener;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setGoodsCardClickListener(IECGoodsCardView.IGoodsCardClickListener listener) {
        this.onClickEventListener = listener;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void updateUIByType(int uiType) {
        this.originUIType = this.curUIType;
        this.curUIType = uiType;
        if (uiType == U()) {
            this.smallLayout.setVisibility(0);
            this.mediumLayout.setVisibility(8);
            ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView = this.bigLayout;
            if (eCXingHuanBaseBigCardView != null) {
                ViewKt.setVisible(eCXingHuanBaseBigCardView, false);
                return;
            }
            return;
        }
        if (uiType == T()) {
            if (this.originUIType == U()) {
                this.mediumLayout.setVisibility(4);
                d0();
                return;
            }
            this.smallLayout.setVisibility(8);
            this.mediumLayout.setVisibility(0);
            ECXingHuanBaseBigCardView eCXingHuanBaseBigCardView2 = this.bigLayout;
            if (eCXingHuanBaseBigCardView2 != null) {
                ViewKt.setVisible(eCXingHuanBaseBigCardView2, false);
                return;
            }
            return;
        }
        if (V(uiType)) {
            int i3 = this.originUIType;
            if (i3 == U()) {
                c0();
            } else {
                if (i3 == T()) {
                    b0();
                    return;
                }
                this.smallLayout.setVisibility(8);
                this.mediumLayout.setVisibility(8);
                Y();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanGameCardView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "textSize", "", "b", UserInfo.SEX_FEMALE, "btnWidth", "c", "btnHeight", "<init>", "(IFF)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class BtnStyle {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int textSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float btnWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final float btnHeight;

        public BtnStyle(int i3, float f16, float f17) {
            this.textSize = i3;
            this.btnWidth = f16;
            this.btnHeight = f17;
        }

        public int hashCode() {
            return (((this.textSize * 31) + Float.floatToIntBits(this.btnWidth)) * 31) + Float.floatToIntBits(this.btnHeight);
        }

        public String toString() {
            return "BtnStyle(textSize=" + this.textSize + ", btnWidth=" + this.btnWidth + ", btnHeight=" + this.btnHeight + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BtnStyle)) {
                return false;
            }
            BtnStyle btnStyle = (BtnStyle) other;
            return this.textSize == btnStyle.textSize && Float.compare(this.btnWidth, btnStyle.btnWidth) == 0 && Float.compare(this.btnHeight, btnStyle.btnHeight) == 0;
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IGameEventListener
    public void onClickButton(View view, String url) {
        view.setTag(R.id.ntd, 2);
        IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = this.onClickEventListener;
        if (iGoodsCardClickListener != null) {
            IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, view, url, null, 4, null);
        }
    }

    private final ECXingHuanBaseBigCardView L(ECContentInfo contentInfo, int uiType) {
        switch (uiType) {
            case 422:
                return new ECXingHuanLeftPicCardView(getContext(), contentInfo);
            case 423:
                return new ECXingHuanTopPicCardView(getContext(), contentInfo);
            case 424:
                return new ECXingHuanTopPicCardView(getContext(), contentInfo);
            case 425:
                return new ECXingHuanTopPicCardView(getContext(), contentInfo);
            case PlayUI.UIType.BIG_CARD_SHAPED_PIC /* 426 */:
                return new ECXingHuanShapedCardView(getContext(), contentInfo);
            default:
                return null;
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getView() {
        return this;
    }
}
