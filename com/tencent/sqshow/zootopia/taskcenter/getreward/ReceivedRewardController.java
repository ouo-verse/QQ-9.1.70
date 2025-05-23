package com.tencent.sqshow.zootopia.taskcenter.getreward;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import cc4.b;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.recommend.common.event.ZplanConfigChangeEvent;
import com.tencent.sqshow.zootopia.taskcenter.getreward.ReceivedRewardController;
import com.tencent.sqshow.zootopia.utils.ae;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n74.df;
import org.json.JSONObject;
import org.libpag.PAGView;
import pu4.g;
import t74.s;
import t74.u;
import tl.h;
import xv4.ab;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0089\u00012\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001+B1\u0012\u0006\u0010>\u001a\u00020<\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0010D\u001a\u00020\u0010\u0012\u0006\u0010J\u001a\u00020E\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\u001a\u0010\"\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0002J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J*\u0010+\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u000bH\u0016J\u001a\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\u001aH\u0016J \u00100\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u0006\u0010/\u001a\u00020\tJ\u0016\u00101\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bJ\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0010H\u0016J\u0012\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000507\u0018\u000106H\u0016J\b\u00109\u001a\u00020\u001aH\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010=R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0017\u0010D\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\bA\u0010\u0019\u001a\u0004\bB\u0010CR\u0017\u0010J\u001a\u00020E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010[R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0017\u0010h\u001a\u00020d8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010e\u001a\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010iR\u0016\u0010l\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010iR\u0016\u0010n\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010iR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010qR\u0018\u0010v\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010qR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010@R\u0018\u0010{\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010}\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010zR \u0010\u007f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010@R\u0019\u0010\u0082\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/getreward/ReceivedRewardController;", "Lcc4/b;", "Ldb4/a;", "Lcc4/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "r", BdhLogUtil.LogTag.Tag_Conn, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lcom/tencent/sqshow/zootopia/data/w;", "rewardList", "u", "v", "", "size", "p", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "pagView", "mode", "I", "", "url", "Landroid/media/MediaPlayer;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mediaPlayer", "D", "o", UserInfo.SEX_FEMALE, "E", "Landroid/view/View;", "getView", "Lcc4/b$b;", "listener", "b", "c", "Lxv4/ab;", "materialList", "a", "error", "message", "d", "withPAG", "G", ReportConstant.COSTREPORT_PREFIX, "status", "I4", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "t", "onDismiss", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/content/Context;", "Landroid/content/Context;", "context", "e", "Ljava/util/List;", "f", "getType", "()I", "type", "", h.F, "J", "getIndex", "()J", "index", "i", "Lcc4/b$b;", "dismissListener", "Landroid/view/LayoutInflater;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/animation/RotateAnimation;", "Landroid/view/animation/RotateAnimation;", "rotateAnimation", "Landroid/view/animation/ScaleAnimation;", "Landroid/view/animation/ScaleAnimation;", "scaleAnimation", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ln74/df;", "Ln74/df;", "binding", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "Lcom/tencent/sqshow/zootopia/taskcenter/getreward/f;", "H", "Lcom/tencent/sqshow/zootopia/taskcenter/getreward/f;", "repo", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "getReportHelper", "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Ljava/lang/String;", "blindRewardInPAG", "K", "rewardInPAG", "L", "rewardLoopPAG", "Lpu4/g;", "M", "Lpu4/g;", "blindBoxMaterial", "N", "inMaterial", "P", "loopMaterial", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "rewardMaterialList", BdhLogUtil.LogTag.Tag_Req, "Landroid/media/MediaPlayer;", "blindBoxPlayer", ExifInterface.LATITUDE_SOUTH, "rewardBoxPlayer", "T", "currentRewardList", "U", "Z", "hasPagPlayed", "Ljava/lang/Runnable;", "V", "Ljava/lang/Runnable;", "renderViewRunnable", "<init>", "(Landroid/content/Context;Ljava/util/List;IJ)V", "W", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ReceivedRewardController implements cc4.b, db4.a, cc4.c, SimpleEventReceiver<SimpleBaseEvent> {
    private static final float X = 0.301f;
    private static final float Y = 0.323f;
    private static final float Z = 0.242f;

    /* renamed from: a0, reason: collision with root package name */
    private static final int f373013a0 = R.drawable.iic;

    /* renamed from: C, reason: from kotlin metadata */
    private RotateAnimation rotateAnimation;

    /* renamed from: D, reason: from kotlin metadata */
    private ScaleAnimation scaleAnimation;

    /* renamed from: E, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    private df binding;

    /* renamed from: G, reason: from kotlin metadata */
    private final Drawable errorDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private final f repo;

    /* renamed from: I, reason: from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: J, reason: from kotlin metadata */
    private String blindRewardInPAG;

    /* renamed from: K, reason: from kotlin metadata */
    private String rewardInPAG;

    /* renamed from: L, reason: from kotlin metadata */
    private String rewardLoopPAG;

    /* renamed from: M, reason: from kotlin metadata */
    private g blindBoxMaterial;

    /* renamed from: N, reason: from kotlin metadata */
    private g inMaterial;

    /* renamed from: P, reason: from kotlin metadata */
    private g loopMaterial;

    /* renamed from: Q, reason: from kotlin metadata */
    private List<ab> rewardMaterialList;

    /* renamed from: R, reason: from kotlin metadata */
    private MediaPlayer blindBoxPlayer;

    /* renamed from: S, reason: from kotlin metadata */
    private MediaPlayer rewardBoxPlayer;

    /* renamed from: T, reason: from kotlin metadata */
    private List<ZootopiaTaskRewardInfo> currentRewardList;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasPagPlayed;

    /* renamed from: V, reason: from kotlin metadata */
    private Runnable renderViewRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<ZootopiaTaskRewardInfo> rewardList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long index;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b.InterfaceC0182b dismissListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater layoutInflater;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/getreward/ReceivedRewardController$b", "Lcc4/a;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends cc4.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<ZootopiaTaskRewardInfo> f373021f;

        b(List<ZootopiaTaskRewardInfo> list) {
            this.f373021f = list;
        }

        @Override // cc4.a, org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
            QLog.i(getTAG(), 1, "handleBlindBoxRewardPAG onAnimationEnd");
            super.onAnimationEnd(p06);
            ReceivedRewardController.this.binding.f419229b.setVisibility(4);
            ReceivedRewardController.this.v(this.f373021f);
        }

        @Override // cc4.a, org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView p06) {
            QLog.i(getTAG(), 1, "handleBlindBoxRewardPAG onAnimationStart");
            super.onAnimationStart(p06);
            ReceivedRewardController.this.I4(4);
            ReceivedRewardController receivedRewardController = ReceivedRewardController.this;
            receivedRewardController.D(receivedRewardController.blindBoxPlayer);
            ReceivedRewardController.this.hasPagPlayed = true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/getreward/ReceivedRewardController$c", "Lcc4/a;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends cc4.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<ZootopiaTaskRewardInfo> f373023f;

        c(List<ZootopiaTaskRewardInfo> list) {
            this.f373023f = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ReceivedRewardController this$0, List rewardList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(rewardList, "$rewardList");
            this$0.s(rewardList);
            this$0.D(this$0.rewardBoxPlayer);
        }

        @Override // cc4.a, org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
            QLog.i(getTAG(), 1, "handleCommonRewardPAG onAnimationEnd");
            ReceivedRewardController.this.binding.f419231d.setVisibility(4);
            ReceivedRewardController.this.binding.f419231d.resetView();
        }

        @Override // cc4.a, org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView p06) {
            QLog.i(getTAG(), 1, "handleCommonRewardPAG onAnimationStart");
            super.onAnimationStart(p06);
            ReceivedRewardController.this.I4(4);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ReceivedRewardController receivedRewardController = ReceivedRewardController.this;
            final List<ZootopiaTaskRewardInfo> list = this.f373023f;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.taskcenter.getreward.e
                @Override // java.lang.Runnable
                public final void run() {
                    ReceivedRewardController.c.d(ReceivedRewardController.this, list);
                }
            }, 350L);
            ReceivedRewardController.this.hasPagPlayed = true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/getreward/ReceivedRewardController$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QLog.i("ReceivedRewardController", 1, "onAnimationEnd");
            ReceivedRewardController.this.w();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            QLog.i("ReceivedRewardController", 1, "onAnimationRepeat");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            QLog.i("ReceivedRewardController", 1, "onAnimationStart");
        }
    }

    public ReceivedRewardController(Context context, List<ZootopiaTaskRewardInfo> rewardList, int i3, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rewardList, "rewardList");
        this.context = context;
        this.rewardList = rewardList;
        this.type = i3;
        this.index = j3;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.layoutInflater = from;
        df g16 = df.g(from);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        Resources resources = context.getResources();
        Drawable drawable = resources != null ? resources.getDrawable(f373013a0) : null;
        Intrinsics.checkNotNull(drawable);
        this.errorDrawable = drawable;
        this.repo = new f(rewardList, this, this);
        this.reportHelper = new ZplanViewReportHelper();
        this.blindRewardInPAG = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/blindbox_open.pag";
        this.rewardInPAG = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/task_reward_in_gradient.pag";
        this.rewardLoopPAG = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/task_reward_loop.pag";
        o();
    }

    private final boolean A() {
        if (this.type == 1 && ZPlanPAGLoader.h(ZPlanPAGLoader.f369875a, this.blindRewardInPAG, false, 2, null) == null) {
            return false;
        }
        ZPlanPAGLoader zPlanPAGLoader = ZPlanPAGLoader.f369875a;
        return (ZPlanPAGLoader.h(zPlanPAGLoader, this.rewardInPAG, false, 2, null) == null || ZPlanPAGLoader.h(zPlanPAGLoader, this.rewardLoopPAG, false, 2, null) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ReceivedRewardController this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean A = this$0.A();
        QLog.i("ReceivedRewardController", 1, "onDataSuccess, check again isPagReady:" + A);
        this$0.G(list, A);
    }

    private final void C() {
        List<ab> list = this.rewardMaterialList;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<ab> list2 = this.rewardMaterialList;
        if (list2 != null) {
            if (this.type == 1 && list2.size() == 3) {
                String str = list2.get(0).f448769b;
                Intrinsics.checkNotNullExpressionValue(str, "it[0].url");
                this.blindRewardInPAG = str;
                String str2 = list2.get(1).f448769b;
                Intrinsics.checkNotNullExpressionValue(str2, "it[1].url");
                this.rewardInPAG = str2;
                String str3 = list2.get(2).f448769b;
                Intrinsics.checkNotNullExpressionValue(str3, "it[2].url");
                this.rewardLoopPAG = str3;
                return;
            }
            int i3 = this.type;
            if ((i3 == 0 || i3 == 2) && list2.size() == 2) {
                String str4 = list2.get(0).f448769b;
                Intrinsics.checkNotNullExpressionValue(str4, "it[0].url");
                this.rewardInPAG = str4;
                String str5 = list2.get(1).f448769b;
                Intrinsics.checkNotNullExpressionValue(str5, "it[1].url");
                this.rewardLoopPAG = str5;
            }
        }
        QLog.i("ReceivedRewardController", 1, "parsePAGUrl, blindRewardInPAG:" + this.blindRewardInPAG + ", rewardInPAG:" + this.rewardInPAG + ", rewardLoopPAG:" + this.rewardLoopPAG);
    }

    private final void E(List<ZootopiaTaskRewardInfo> rewardList) {
        QLog.i("ReceivedRewardController", 1, "reformUE2RefreshData, ready to call N2L_RefreshData}");
        if (rewardList != null) {
            int size = rewardList.size();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = rewardList.get(i3);
                if (zootopiaTaskRewardInfo != null) {
                    int bagType = zootopiaTaskRewardInfo.getBagType();
                    if (arrayList.contains(Integer.valueOf(bagType))) {
                        QLog.i("ReceivedRewardController", 1, "N2L_RefreshData, same type, type=" + bagType + ", return");
                    } else {
                        arrayList.add(Integer.valueOf(bagType));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", bagType);
                        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
                        if (S != null) {
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                            a.C10063a.b(S, "N2L_RefreshData", jSONObject2, null, 4, null);
                        }
                        QLog.i("ReceivedRewardController", 1, "reformUE2RefreshData, N2L_RefreshData=" + jSONObject);
                    }
                }
            }
        }
    }

    private final void F() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ReceivedRewardController this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ReceivedRewardController", 1, "renderView after 5s, hasPagPlayed=" + this$0.hasPagPlayed);
        if (this$0.hasPagPlayed) {
            return;
        }
        this$0.binding.f419229b.stop();
        this$0.binding.f419231d.stop();
        this$0.binding.f419229b.setVisibility(4);
        this$0.binding.f419231d.setVisibility(4);
        this$0.G(list, false);
    }

    private final void I(final ZPlanPAGView pagView, final int mode) {
        pagView.setPagViewReadyListener(new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.taskcenter.getreward.ReceivedRewardController$setPagScaleModeStretch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    ZPlanPAGView.this.setScaleMode(mode);
                }
            }
        });
    }

    private final void o() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void p(int size) {
        QLog.i("ReceivedRewardController", 1, "adjustScreenHeight");
        u.Companion companion = u.INSTANCE;
        int b16 = companion.b(this.context);
        if (companion.g()) {
            QLog.i("ReceivedRewardController", 1, "multi window, set width as height");
            b16 = companion.c(this.context);
        }
        ViewGroup.LayoutParams layoutParams = this.binding.f419233f.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (size == 3) {
            layoutParams2.topMargin = (int) (b16 * Y);
        } else if (size != 6) {
            layoutParams2.topMargin = (int) (b16 * X);
        } else {
            layoutParams2.topMargin = (int) (b16 * Z);
        }
        this.binding.f419233f.setLayoutParams(layoutParams2);
    }

    private final MediaPlayer q(String url) {
        String isSourceExit = ((ISourceDownloadHelper) QRoute.api(ISourceDownloadHelper.class)).isSourceExit(url, ZPlanFileCategory.MP3_RES.getValue());
        QLog.i("ReceivedRewardController", 1, "assembleMediaPlayer, sourceUrl:" + isSourceExit + ", ready to play");
        if (isSourceExit.length() > 0) {
            return gc4.b.f401925a.b(this.context, isSourceExit);
        }
        return null;
    }

    private final void u(List<ZootopiaTaskRewardInfo> rewardList) {
        this.binding.f419229b.resetView();
        this.blindBoxPlayer = q("https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/zplan_get_blind_box.mp3");
        this.binding.f419229b.setRepeatCount(1);
        this.binding.f419229b.setVisibility(0);
        ZPlanPAGView zPlanPAGView = this.binding.f419229b;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView, "binding.blindBoxBg");
        I(zPlanPAGView, 2);
        t74.f fVar = t74.f.f435541a;
        ZPlanPAGView zPlanPAGView2 = this.binding.f419229b;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView2, "binding.blindBoxBg");
        g gVar = this.blindBoxMaterial;
        Intrinsics.checkNotNull(gVar);
        fVar.d(zPlanPAGView2, gVar, new b(rewardList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(List<ZootopiaTaskRewardInfo> rewardList) {
        this.binding.f419231d.resetView();
        this.binding.f419232e.resetView();
        this.rewardBoxPlayer = q("https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/zplan_get_reward.mp3");
        this.binding.f419231d.setRepeatCount(1);
        this.binding.f419231d.setVisibility(0);
        ZPlanPAGView zPlanPAGView = this.binding.f419231d;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView, "binding.congInBg");
        J(this, zPlanPAGView, 0, 2, null);
        t74.f fVar = t74.f.f435541a;
        ZPlanPAGView zPlanPAGView2 = this.binding.f419231d;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView2, "binding.congInBg");
        g gVar = this.inMaterial;
        Intrinsics.checkNotNull(gVar);
        fVar.d(zPlanPAGView2, gVar, new c(rewardList));
        this.binding.f419232e.setVisibility(0);
        this.binding.f419232e.setRepeatCount(0);
        ZPlanPAGView zPlanPAGView3 = this.binding.f419232e;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView3, "binding.congLoopBg");
        J(this, zPlanPAGView3, 0, 2, null);
        ZPlanPAGView zPlanPAGView4 = this.binding.f419232e;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView4, "binding.congLoopBg");
        g gVar2 = this.loopMaterial;
        Intrinsics.checkNotNull(gVar2);
        fVar.d(zPlanPAGView4, gVar2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        View view = this.rootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.taskcenter.getreward.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReceivedRewardController.x(ReceivedRewardController.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ReceivedRewardController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.dismissListener != null) {
            this$0.F();
            b.InterfaceC0182b interfaceC0182b = this$0.dismissListener;
            Intrinsics.checkNotNull(interfaceC0182b);
            interfaceC0182b.dismiss();
        }
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        RelativeLayout root = this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        zplanViewReportHelper.e(root, "em_zplan_lottery_win_close", new LinkedHashMap());
    }

    private final void y() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation = rotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation);
        rotateAnimation.setRepeatCount(-1);
        RotateAnimation rotateAnimation2 = this.rotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation2);
        rotateAnimation2.setDuration(1000L);
        RotateAnimation rotateAnimation3 = this.rotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation3);
        rotateAnimation3.setInterpolator(new LinearInterpolator());
        this.binding.f419235h.setAnimation(this.rotateAnimation);
    }

    private final void z() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.scaleAnimation = scaleAnimation;
        Intrinsics.checkNotNull(scaleAnimation);
        scaleAnimation.setDuration(250L);
        ScaleAnimation scaleAnimation2 = this.scaleAnimation;
        Intrinsics.checkNotNull(scaleAnimation2);
        scaleAnimation2.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation3 = this.scaleAnimation;
        Intrinsics.checkNotNull(scaleAnimation3);
        scaleAnimation3.setAnimationListener(new d());
        this.binding.f419235h.setAnimation(this.rotateAnimation);
    }

    @Override // cc4.c
    public void a(final List<ZootopiaTaskRewardInfo> rewardList, List<ab> materialList) {
        QLog.i("ReceivedRewardController", 1, "onDataSuccess, rewardList:" + rewardList + ", materialList:" + materialList);
        E(rewardList);
        this.rewardMaterialList = materialList;
        C();
        this.currentRewardList = rewardList;
        if (!A()) {
            QLog.i("ReceivedRewardController", 1, "onDataSuccess, isPagReady:false, wait:5000");
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.taskcenter.getreward.c
                @Override // java.lang.Runnable
                public final void run() {
                    ReceivedRewardController.B(ReceivedRewardController.this, rewardList);
                }
            }, 5000L);
        } else {
            QLog.i("ReceivedRewardController", 1, "onDataSuccess, isPagReady:true");
            G(rewardList, true);
        }
    }

    @Override // cc4.b
    public void b(b.InterfaceC0182b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dismissListener = listener;
    }

    @Override // cc4.b
    public void c() {
        this.repo.a(this.index, this.type);
        QLog.i("ReceivedRewardController", 1, "requestData index:" + this.index + ", type:" + this.type);
    }

    @Override // cc4.c
    public void d(int error, String message) {
        QLog.i("ReceivedRewardController", 1, "onDataFailed, error:" + error + ", message:" + message);
        v vVar = v.f373305a;
        String string = this.context.getResources().getString(R.string.xvx);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026sk_system_receive_failed)");
        String b16 = vVar.b(error, message, string);
        if (b16 != null) {
            QQToast.makeText(this.context, 1, b16, 0).show();
        }
        F();
        b.InterfaceC0182b interfaceC0182b = this.dismissListener;
        if (interfaceC0182b != null) {
            interfaceC0182b.dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZplanConfigChangeEvent.class);
        return arrayList;
    }

    @Override // cc4.b
    public View getView() {
        if (this.rootView == null) {
            this.rootView = this.binding.f419241n;
        }
        I4(1);
        r();
        View view = this.rootView;
        Intrinsics.checkNotNull(view);
        return view;
    }

    @Override // cc4.b
    public void onDetachedFromWindow() {
        b.a.a(this);
        QLog.i("ReceivedRewardController", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        F();
    }

    @Override // cc4.b
    public void onDismiss() {
        b.a.b(this);
        QLog.i("ReceivedRewardController", 1, "onDismiss");
        F();
        Runnable runnable = this.renderViewRunnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        this.renderViewRunnable = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof ZplanConfigChangeEvent) {
            QLog.i("ReceivedRewardController", 1, "onReceiveEvent, event:" + event);
            List<ZootopiaTaskRewardInfo> list = this.currentRewardList;
            p(list != null ? list.size() : 1);
            return;
        }
        QLog.i("ReceivedRewardController", 1, "onReceiveEvent, do not handle " + event);
    }

    public final void s(List<ZootopiaTaskRewardInfo> rewardList) {
        Intrinsics.checkNotNullParameter(rewardList, "rewardList");
        QLog.i("ReceivedRewardController", 1, "doRenderView");
        p(rewardList.size());
        if (rewardList.size() == 1) {
            this.binding.f419236i.startAnimation(this.scaleAnimation);
            ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = rewardList.get(0);
            this.binding.f419236i.setVisibility(0);
            this.binding.f419238k.setText(zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemTitle() : null);
            TextView textView = this.binding.f419237j;
            Resources resources = this.context.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = String.valueOf(zootopiaTaskRewardInfo != null ? Integer.valueOf(zootopiaTaskRewardInfo.getRewardItemCnt()) : null);
            textView.setText(resources.getString(R.string.xvy, objArr));
            ae.INSTANCE.a(this.binding.f419240m, zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemIcon() : null, this.errorDrawable, f373013a0);
            return;
        }
        this.binding.f419236i.setVisibility(8);
        this.binding.f419239l.setVisibility(0);
        a aVar = new a(this.context);
        this.binding.f419239l.setAdapter((ListAdapter) aVar);
        aVar.setData(rewardList);
        this.binding.f419239l.startAnimation(this.scaleAnimation);
    }

    public String t() {
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache("task_panel_external", ZplanCacheComponentType.PARENT_PAGE_HANDLER);
        String str = cache instanceof String ? (String) cache : null;
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null && s.f435588a.a()) {
            QLog.i("ReceivedRewardController", 1, "playMp3, start play");
            gc4.b.f401925a.c(mediaPlayer);
        } else {
            QLog.i("ReceivedRewardController", 1, "playMp3, mediaPlayer is null or app is in background, do not play");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        if (r5 != 2) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G(final List<ZootopiaTaskRewardInfo> rewardList, boolean withPAG) {
        List<ZootopiaTaskRewardInfo> list = rewardList;
        if (list == null || list.isEmpty()) {
            I4(3);
            return;
        }
        if (!withPAG) {
            I4(4);
            this.binding.f419233f.setVisibility(0);
            this.binding.f419234g.setVisibility(0);
            s(rewardList);
            return;
        }
        t74.f fVar = t74.f.f435541a;
        this.blindBoxMaterial = fVar.a(this.blindRewardInPAG, "");
        this.inMaterial = fVar.a(this.rewardInPAG, "");
        this.loopMaterial = fVar.a(this.rewardLoopPAG, "");
        int i3 = this.type;
        if (i3 != 0) {
            if (i3 == 1) {
                u(rewardList);
            }
            if (ZPlanQQMC.INSTANCE.enableShowRewardWhenPagPlayFail()) {
                return;
            }
            QLog.i("ReceivedRewardController", 1, "enableShowRewardWhenPagPlayFail");
            this.renderViewRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.taskcenter.getreward.d
                @Override // java.lang.Runnable
                public final void run() {
                    ReceivedRewardController.H(ReceivedRewardController.this, rewardList);
                }
            };
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.renderViewRunnable;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.postDelayed(runnable, 5000L);
            return;
        }
        v(rewardList);
        if (ZPlanQQMC.INSTANCE.enableShowRewardWhenPagPlayFail()) {
        }
    }

    @Override // db4.a
    public void I4(int status) {
        if (status == 1) {
            QLog.i("ReceivedRewardController", 1, "start loading");
            this.binding.f419235h.setVisibility(0);
            y();
            z();
            return;
        }
        if (status == 2 || status == 3) {
            QLog.i("ReceivedRewardController", 1, "empty or null, return");
            b.InterfaceC0182b interfaceC0182b = this.dismissListener;
            if (interfaceC0182b != null) {
                interfaceC0182b.dismiss();
            }
            F();
            return;
        }
        if (status != 4) {
            return;
        }
        QLog.i("ReceivedRewardController", 1, "hide loading view");
        RotateAnimation rotateAnimation = this.rotateAnimation;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
        this.binding.f419235h.setVisibility(8);
        this.binding.f419233f.setVisibility(0);
    }

    private final void r() {
        Map<String, Object> mutableMapOf;
        Map mutableMapOf2;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Context context = this.context;
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, t()));
        zplanViewReportHelper.a(context, root, "pg_zplan_daily_task", mutableMapOf);
        ZplanViewReportHelper zplanViewReportHelper2 = this.reportHelper;
        RelativeLayout root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, t()));
        zplanViewReportHelper2.g(root2, "em_zplan_lottery_win_close", (r16 & 4) != 0 ? null : mutableMapOf2, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    static /* synthetic */ void J(ReceivedRewardController receivedRewardController, ZPlanPAGView zPlanPAGView, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        receivedRewardController.I(zPlanPAGView, i3);
    }
}
