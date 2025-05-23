package com.tencent.mobileqq.zplan.aigc.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import ce3.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper;
import com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper;
import com.tencent.mobileqq.zplan.aigc.helper.g;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender;
import com.tencent.mobileqq.zplan.aigc.view.dialog.UGCPickColorDialogView;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import ga4.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import k94.ColorPanelData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import qu4.p;
import uv4.as;
import uv4.az;
import w74.UgcColorInfoData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B[\u0012\b\u0010,\u001a\u0004\u0018\u00010)\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010?\u001a\u00020\u0002\u0012\u0006\u0010C\u001a\u00020@\u0012\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0E0D\u00a2\u0006\u0004\b~\u0010\u007fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u001c\u001a\u00020\f2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010&\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010(\u001a\u00020'R\u0016\u0010,\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR&\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0E0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR$\u0010W\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\b>\u0010T\"\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010>R\u0017\u0010c\u001a\u00020^8\u0006\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020'0g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010>R\u0016\u0010n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010>R\u0018\u0010q\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper;", "", "", "slotId", "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView;", "M", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "J", "", "L", "", "Lqu4/p;", "customColors", "Luv4/as;", "K", "G", "P", "", "resourcePath", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "callback", "O", "message", "V", "X", "Z", "dyeingPrice", "Landroid/widget/FrameLayout;", "dialogViewContainer", "U", NodeProps.COLORS, ExifInterface.LATITUDE_SOUTH, "", "N", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "b", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "vm", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "c", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "filamentRender", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/PortalStoreHistoryControllerView;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/PortalStoreHistoryControllerView;", "historyOptView", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "historyLayout", "f", "I", "from", "Lzd3/a;", "g", "Lzd3/a;", "dtReporter", "Lmqq/util/WeakReference;", "Lkotlin/Function1;", tl.h.F, "Lmqq/util/WeakReference;", "i", "Ljava/lang/String;", "TAG", "j", "Luv4/as;", "colorEditorCfg", "Lga4/i;", "k", "Lga4/i;", "dialogController", "l", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "T", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView$b;", "ugcPickColorListener", DomainData.DOMAIN_NAME, "circleItemIndex", "Lcom/tencent/mobileqq/zplan/aigc/helper/g;", "o", "Lcom/tencent/mobileqq/zplan/aigc/helper/g;", "H", "()Lcom/tencent/mobileqq/zplan/aigc/helper/g;", "colorEditHistoryHelper", "p", "Lqu4/p;", "currentColor", "Ljava/util/LinkedList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/LinkedList;", "showStatus", "r", "curGoldCoin", ReportConstant.COSTREPORT_PREFIX, "mDyeingPrice", "t", "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView;", "pickColorDialog", "Lcom/tencent/mobileqq/zplan/aigc/helper/g$b;", "u", "Lcom/tencent/mobileqq/zplan/aigc/helper/g$b;", "historyDataChangeListener", "Lce3/a$a;", "v", "Lce3/a$a;", "aigcDressControllerListener", "Lga4/h;", "w", "Lga4/h;", "dismissListener", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;Lcom/tencent/sqshow/zootopia/nativeui/view/history/PortalStoreHistoryControllerView;Landroid/widget/LinearLayout;ILzd3/a;Lmqq/util/WeakReference;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanUgcDyeingDialogHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SuitCustomColorVewModel vm;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ZplanFilamentSuitRender filamentRender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PortalStoreHistoryControllerView historyOptView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout historyLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int from;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Function1<Integer, Unit>> callback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private as colorEditorCfg;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ga4.i dialogController;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private UGCPickColorDialogView.b ugcPickColorListener;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int circleItemIndex;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final g colorEditHistoryHelper;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private p currentColor;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private LinkedList<Boolean> showStatus;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int curGoldCoin;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int mDyeingPrice;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private UGCPickColorDialogView pickColorDialog;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private g.b historyDataChangeListener;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private a.InterfaceC0184a aigcDressControllerListener;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private ga4.h dismissListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper$a", "Lga4/h;", "Lga4/g;", "panelDialog", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ga4.h {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper$a$a", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/g;", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9134a implements com.tencent.sqshow.zootopia.nativeui.view.history.g {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ZplanUgcDyeingDialogHelper f330275d;

            C9134a(ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper) {
                this.f330275d = zplanUgcDyeingDialogHelper;
            }

            @Override // com.tencent.sqshow.zootopia.nativeui.view.history.g
            public void a() {
                QLog.i(this.f330275d.TAG, 1, "onLastClick");
                this.f330275d.getColorEditHistoryHelper().i(this.f330275d.filamentRender);
            }

            @Override // com.tencent.sqshow.zootopia.nativeui.view.history.g
            public void b() {
                QLog.i(this.f330275d.TAG, 1, "onNextClicked");
                this.f330275d.getColorEditHistoryHelper().j(this.f330275d.filamentRender);
            }
        }

        a() {
        }

        @Override // ga4.h
        public void a(ga4.g panelDialog) {
            Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
            ZplanUgcDyeingDialogHelper.this.historyLayout.setVisibility(8);
            if (!ZplanUgcDyeingDialogHelper.this.showStatus.isEmpty()) {
                ZplanUgcDyeingDialogHelper.this.showStatus.pollFirst();
            }
            QLog.i(ZplanUgcDyeingDialogHelper.this.TAG, 1, "color panel onDismiss");
        }

        @Override // ga4.h
        public void b(ga4.g panelDialog) {
            Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
            h.a.a(this, panelDialog);
            ZplanUgcDyeingDialogHelper.this.showStatus.push(Boolean.TRUE);
            ZplanUgcDyeingDialogHelper.this.historyLayout.setVisibility(0);
            ZplanUgcDyeingDialogHelper.this.historyOptView.setListener(new C9134a(ZplanUgcDyeingDialogHelper.this));
            QLog.i(ZplanUgcDyeingDialogHelper.this.TAG, 1, "color panel onShow");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper$b", "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView$b;", "", "b", "", "position", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements UGCPickColorDialogView.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f330277b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper$b$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ZplanUgcDyeingDialogHelper f330278d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f330279e;

            a(ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper, int i3) {
                this.f330278d = zplanUgcDyeingDialogHelper;
                this.f330279e = i3;
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(com.tencent.sqshow.zootopia.data.f result) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.f330278d.Q(this.f330279e);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                this.f330278d.V("\u83b7\u53d6\u91d1\u5e01\u4f59\u989d\u5931\u8d25");
            }
        }

        b(int i3) {
            this.f330277b = i3;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.view.dialog.UGCPickColorDialogView.b
        public void a(int position) {
            ZplanUgcDyeingDialogHelper.this.circleItemIndex = position;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.view.dialog.UGCPickColorDialogView.b
        public void b() {
            if (ZplanUgcDyeingDialogHelper.this.curGoldCoin > 0) {
                ZplanUgcDyeingDialogHelper.this.Q(this.f330277b);
            } else {
                ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = ZplanUgcDyeingDialogHelper.this;
                zplanUgcDyeingDialogHelper.O(new a(zplanUgcDyeingDialogHelper, this.f330277b));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> f330281e;

        c(com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar) {
            this.f330281e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(com.tencent.sqshow.zootopia.data.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.getGoldCoinRet() != 0) {
                ZplanUgcDyeingDialogHelper.this.V("\u83b7\u53d6\u91d1\u5e01\u4f59\u989d\u5931\u8d25");
            } else {
                ZplanUgcDyeingDialogHelper.this.curGoldCoin = result.getGoldCoin();
            }
            com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar = this.f330281e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZplanUgcDyeingDialogHelper.this.V("\u83b7\u53d6\u91d1\u5e01\u4f59\u989d\u5931\u8d25");
            com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar = this.f330281e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper$d", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUGCDyeingPublishHelper$a;", "", "onSuccess", "", "errorMsg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements ZPlanUGCDyeingPublishHelper.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ zv4.a f330283b;

        d(zv4.a aVar) {
            this.f330283b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ZplanUgcDyeingDialogHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            UGCPickColorDialogView uGCPickColorDialogView = this$0.pickColorDialog;
            if (uGCPickColorDialogView != null) {
                uGCPickColorDialogView.Y();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ZplanUgcDyeingDialogHelper this$0) {
            com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
            ga4.f dialogController;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            UGCPickColorDialogView uGCPickColorDialogView = this$0.pickColorDialog;
            if (uGCPickColorDialogView != null && (mChannel = this$0.getMChannel()) != null && (dialogController = mChannel.getDialogController()) != null) {
                dialogController.g(uGCPickColorDialogView);
            }
            Function1 function1 = (Function1) this$0.callback.get();
            if (function1 != null) {
                function1.invoke(2);
            }
        }

        @Override // com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper.a
        public void onFailed(String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.e(ZplanUgcDyeingDialogHelper.this.TAG, 1, "publishDyeingUGC failed!!!");
            ZplanUgcDyeingDialogHelper.this.V("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = ZplanUgcDyeingDialogHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.o
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanUgcDyeingDialogHelper.d.c(ZplanUgcDyeingDialogHelper.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper.a
        public void onSuccess() {
            QLog.i(ZplanUgcDyeingDialogHelper.this.TAG, 1, "publishDyeingUGC success");
            ZplanUgcDyeingDialogHelper.this.Z("\u67d3\u8272\u6210\u529f\uff0c\u5df2\u4fdd\u5b58\u81f3\u80cc\u5305");
            zd3.a aVar = ZplanUgcDyeingDialogHelper.this.dtReporter;
            List<p> Q2 = ZplanUgcDyeingDialogHelper.this.vm.Q2();
            zv4.a aVar2 = this.f330283b;
            aVar.n(Q2, aVar2.f453554b, aVar2.f453555c);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = ZplanUgcDyeingDialogHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.n
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanUgcDyeingDialogHelper.d.d(ZplanUgcDyeingDialogHelper.this);
                }
            });
        }
    }

    public ZplanUgcDyeingDialogHelper(Context context, SuitCustomColorVewModel vm5, ZplanFilamentSuitRender filamentRender, PortalStoreHistoryControllerView historyOptView, LinearLayout historyLayout, int i3, zd3.a dtReporter, WeakReference<Function1<Integer, Unit>> callback) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        Intrinsics.checkNotNullParameter(historyOptView, "historyOptView");
        Intrinsics.checkNotNullParameter(historyLayout, "historyLayout");
        Intrinsics.checkNotNullParameter(dtReporter, "dtReporter");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.vm = vm5;
        this.filamentRender = filamentRender;
        this.historyOptView = historyOptView;
        this.historyLayout = historyLayout;
        this.from = i3;
        this.dtReporter = dtReporter;
        this.callback = callback;
        this.TAG = "ZplanUgcDyeingDialogHelper";
        this.colorEditHistoryHelper = new g();
        this.currentColor = new p();
        this.showStatus = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1] */
    public final void G() {
        FilamentViewerV2 viewerV2;
        AigcAnimHelper animHelper;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        final ?? r16 = new com.tencent.filament.zplan.d() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1
            @Override // com.tencent.filament.zplan.d
            public void a(byte[] pixels, int width, int height) {
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, ZplanUgcDyeingDialogHelper.this.TAG + "_recordImage", null, null, null, new ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1(ZplanUgcDyeingDialogHelper.this, width, height, pixels, objectRef, null), 14, null);
                }
            }
        };
        P(this.vm.getSlotId());
        Function1<Integer, Unit> function1 = this.callback.get();
        if (function1 != null) {
            function1.invoke(0);
        }
        final ZplanFilamentSuitRender zplanFilamentSuitRender = this.filamentRender;
        AigcPreviewBusinessScene scene = zplanFilamentSuitRender.getScene();
        if (scene == null || (viewerV2 = scene.getViewerV2()) == null || (animHelper = zplanFilamentSuitRender.getAnimHelper()) == null) {
            return;
        }
        animHelper.E1(viewerV2, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$2$1$1
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
                int i3 = z16 ? 3 : 0;
                AigcPreviewBusinessScene scene2 = ZplanFilamentSuitRender.this.getScene();
                if (scene2 != null) {
                    AigcPreviewBusinessScene.recordFrame$default(scene2, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b(), i3, 0.0d, r16, null, 16, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.sqshow.zootopia.nativeui.data.j J(final int slotId, final ViewGroup container, LifecycleOwner lifecycleOwner) {
        L(container);
        com.tencent.sqshow.zootopia.nativeui.data.repo.i iVar = new com.tencent.sqshow.zootopia.nativeui.data.repo.i();
        com.tencent.sqshow.zootopia.nativeui.data.repo.p pVar = new com.tencent.sqshow.zootopia.nativeui.data.repo.p();
        this.aigcDressControllerListener = new a.InterfaceC0184a() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1
            @Override // ce3.a.InterfaceC0184a
            public void a(qu4.c colorInfo, boolean addToHistory) {
                Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, ZplanUgcDyeingDialogHelper.this.TAG + "_onModifyColorInfo", null, null, null, new ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1$onModifyColorInfo$1(ZplanUgcDyeingDialogHelper.this, colorInfo, slotId, addToHistory, container, null), 14, null);
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
    public final as K(List<p> customColors) {
        p[] pVarArr;
        as asVar = new as();
        asVar.f440218a = this.vm.getSlotId();
        asVar.f440219b = 1;
        List<p> list = customColors;
        if (true ^ list.isEmpty()) {
            Object[] array = list.toArray(new p[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            pVarArr = (p[]) array;
        } else {
            pVarArr = null;
        }
        asVar.f440220c = pVarArr;
        return asVar;
    }

    private final void L(ViewGroup container) {
        this.dialogController = new ga4.i(container);
        this.dismissListener = new a();
        ga4.i iVar = this.dialogController;
        if (iVar != null) {
            iVar.c(new WeakReference<>(this.dismissListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> callback) {
        yb4.e.h(yb4.e.f450058a, "request_immediately", new c(callback), 0, 4, null);
    }

    private final void P(int slotId) {
        int[] intArray;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        intArray = CollectionsKt___CollectionsKt.toIntArray(this.vm.Y2());
        for (int i3 : intArray) {
            jSONArray2.put(i3);
        }
        jSONObject2.put("slot", String.valueOf(slotId));
        jSONObject2.put("primitives", jSONArray2);
        jSONArray.mo162put(jSONObject2);
        jSONObject.put("hidePrimitivesInSlot", jSONArray);
        AigcPreviewBusinessScene scene = this.filamentRender.getScene();
        if (scene != null) {
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "avatarSlotMask.toString()");
            scene.hidePrimitiveInSlot(jSONObject3);
        }
        this.vm.w3(true, this.filamentRender);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int slotId) {
        if (this.curGoldCoin >= this.mDyeingPrice) {
            G();
            return;
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$processItemPay$1
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
                UGCPickColorDialogView uGCPickColorDialogView = ZplanUgcDyeingDialogHelper.this.pickColorDialog;
                if (uGCPickColorDialogView != null) {
                    uGCPickColorDialogView.Y();
                }
            }
        });
        X("\u91d1\u5e01\u4e0d\u591f\u5566\uff0c\u5145\u503c\u7ee7\u7eed\u4fdd\u5b58\u670d\u88c5");
        this.dtReporter.m(this.from);
        AvatarCommonOperateHelper.f371049a.n(this.mDyeingPrice - this.curGoldCoin, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$processItemPay$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                    ZplanUgcDyeingDialogHelper.this.G();
                } else {
                    QLog.i(ZplanUgcDyeingDialogHelper.this.TAG, 1, "cancel pay");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(String resourcePath) {
        if (this.vm.getCurrentUgcStoreItem() == null) {
            return;
        }
        zv4.c currentUgcStoreItem = this.vm.getCurrentUgcStoreItem();
        Intrinsics.checkNotNull(currentUgcStoreItem);
        az azVar = currentUgcStoreItem.f453570b;
        zv4.a aVar = new zv4.a();
        aVar.f453553a = 4;
        aVar.f453555c = this.vm.getUgcId();
        aVar.f453554b = this.vm.getCurrentItemId();
        aVar.f453558f = this.vm.getCurrentStoreItemName() + "\u00b7\u67d3\u8272";
        aVar.f453559g = azVar.f440278e;
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
        aVar.f453556d = Long.parseLong(currentUin);
        zv4.c currentUgcStoreItem2 = this.vm.getCurrentUgcStoreItem();
        Intrinsics.checkNotNull(currentUgcStoreItem2);
        aVar.f453560h = currentUgcStoreItem2.f453571c;
        aVar.f453561i = 14;
        ZPlanUGCDyeingPublishHelper.f330232a.f(resourcePath, aVar, new d(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(final String message) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.l
            @Override // java.lang.Runnable
            public final void run() {
                ZplanUgcDyeingDialogHelper.W(ZplanUgcDyeingDialogHelper.this, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(ZplanUgcDyeingDialogHelper this$0, String message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        QQToast.makeText(this$0.context, 1, message, 0).show();
    }

    private final void X(final String message) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.k
            @Override // java.lang.Runnable
            public final void run() {
                ZplanUgcDyeingDialogHelper.Y(ZplanUgcDyeingDialogHelper.this, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ZplanUgcDyeingDialogHelper this$0, String message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        QQToast.makeText(this$0.context, 0, message, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(final String message) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.j
            @Override // java.lang.Runnable
            public final void run() {
                ZplanUgcDyeingDialogHelper.a0(ZplanUgcDyeingDialogHelper.this, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ZplanUgcDyeingDialogHelper this$0, String message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        QQToast.makeText(this$0.context, 2, message, 0).show();
    }

    /* renamed from: H, reason: from getter */
    public final g getColorEditHistoryHelper() {
        return this.colorEditHistoryHelper;
    }

    /* renamed from: I, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getMChannel() {
        return this.mChannel;
    }

    public final boolean N() {
        return !this.showStatus.isEmpty();
    }

    public final void S(List<p> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        as K = K(colors);
        UGCPickColorDialogView uGCPickColorDialogView = this.pickColorDialog;
        if (uGCPickColorDialogView != null) {
            uGCPickColorDialogView.X(K);
        }
    }

    public final void T(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        this.mChannel = jVar;
    }

    public final void U(final int slotId, final int dyeingPrice, final FrameLayout dialogViewContainer, final LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(dialogViewContainer, "dialogViewContainer");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$showColorEditDialog$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper$showColorEditDialog$1$a", "Lcom/tencent/mobileqq/zplan/aigc/helper/g$b;", "Lw74/b;", "colorInfo", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements g.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ZplanUgcDyeingDialogHelper f330289a;

                a(ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper) {
                    this.f330289a = zplanUgcDyeingDialogHelper;
                }

                @Override // com.tencent.mobileqq.zplan.aigc.helper.g.b
                public void a(UgcColorInfoData colorInfo) {
                    Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
                    this.f330289a.circleItemIndex = colorInfo.getColorPosition();
                    UGCPickColorDialogView uGCPickColorDialogView = this.f330289a.pickColorDialog;
                    if (uGCPickColorDialogView != null) {
                        uGCPickColorDialogView.T(this.f330289a.getColorEditHistoryHelper().d() != 0);
                    }
                    this.f330289a.S(colorInfo.b());
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x00a6, code lost:
            
                r1 = r6.this$0.dialogController;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                com.tencent.sqshow.zootopia.nativeui.data.j J;
                as K;
                UGCPickColorDialogView M;
                g.b bVar;
                ga4.i iVar;
                ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = ZplanUgcDyeingDialogHelper.this;
                int i3 = slotId;
                FrameLayout frameLayout = dialogViewContainer;
                Intrinsics.checkNotNull(frameLayout, "null cannot be cast to non-null type android.view.ViewGroup");
                J = zplanUgcDyeingDialogHelper.J(i3, frameLayout, lifecycleOwner);
                zplanUgcDyeingDialogHelper.T(J);
                PortalStoreHistoryControllerView portalStoreHistoryControllerView = ZplanUgcDyeingDialogHelper.this.historyOptView;
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = ZplanUgcDyeingDialogHelper.this.getMChannel();
                Intrinsics.checkNotNull(mChannel);
                portalStoreHistoryControllerView.p(mChannel);
                ZplanUgcDyeingDialogHelper.this.getColorEditHistoryHelper().b(lifecycleOwner, ZplanUgcDyeingDialogHelper.this.historyOptView, ZplanUgcDyeingDialogHelper.this.filamentRender, new WeakReference<>(ZplanUgcDyeingDialogHelper.this.vm));
                ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper2 = ZplanUgcDyeingDialogHelper.this;
                K = zplanUgcDyeingDialogHelper2.K(zplanUgcDyeingDialogHelper2.vm.Q2());
                zplanUgcDyeingDialogHelper2.colorEditorCfg = K;
                g colorEditHistoryHelper = ZplanUgcDyeingDialogHelper.this.getColorEditHistoryHelper();
                List<p> Q2 = ZplanUgcDyeingDialogHelper.this.vm.Q2();
                Intrinsics.checkNotNull(Q2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.trpcprotocol.zplan.cs_common.nano.SingleColor>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.trpcprotocol.zplan.cs_common.nano.SingleColor> }");
                colorEditHistoryHelper.m((ArrayList) Q2);
                ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper3 = ZplanUgcDyeingDialogHelper.this;
                M = zplanUgcDyeingDialogHelper3.M(slotId);
                zplanUgcDyeingDialogHelper3.pickColorDialog = M;
                ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper4 = ZplanUgcDyeingDialogHelper.this;
                zplanUgcDyeingDialogHelper4.historyDataChangeListener = new a(zplanUgcDyeingDialogHelper4);
                g colorEditHistoryHelper2 = ZplanUgcDyeingDialogHelper.this.getColorEditHistoryHelper();
                bVar = ZplanUgcDyeingDialogHelper.this.historyDataChangeListener;
                colorEditHistoryHelper2.o(new WeakReference<>(bVar));
                UGCPickColorDialogView uGCPickColorDialogView = ZplanUgcDyeingDialogHelper.this.pickColorDialog;
                if (uGCPickColorDialogView != null && iVar != null) {
                    iVar.e(uGCPickColorDialogView);
                }
                ZplanUgcDyeingDialogHelper.this.mDyeingPrice = dyeingPrice;
                QLog.i(ZplanUgcDyeingDialogHelper.this.TAG, 1, "showColorEditDialog slotId:" + slotId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCPickColorDialogView M(int slotId) {
        p[] pVarArr;
        QLog.i(this.TAG, 1, "initUGCPickColorDialog slotId:" + slotId);
        this.circleItemIndex = 0;
        qu4.c cVar = new qu4.c();
        qu4.d dVar = new qu4.d();
        dVar.f429583a = slotId;
        p pVar = new p();
        as asVar = this.colorEditorCfg;
        UGCPickColorDialogView uGCPickColorDialogView = null;
        p pVar2 = (asVar == null || (pVarArr = asVar.f440220c) == null) ? null : pVarArr[this.circleItemIndex];
        if (pVar2 == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(pVar2, "colorEditorCfg?.singleCo\u2026ItemIndex) ?: return null");
        pVar.f429637b = pVar2.f429637b;
        dVar.f429585c = pVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        Object[] array = arrayList.toArray(new qu4.d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        cVar.f429581b = (qu4.d[]) array;
        as asVar2 = this.colorEditorCfg;
        Intrinsics.checkNotNull(asVar2);
        ColorPanelData colorPanelData = new ColorPanelData(slotId, cVar, asVar2, -1);
        Context context = this.context;
        if (context != null) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            Intrinsics.checkNotNull(jVar);
            uGCPickColorDialogView = new UGCPickColorDialogView(context, null, 0, jVar, colorPanelData, this.dtReporter, null, 70, null);
        }
        this.ugcPickColorListener = new b(slotId);
        if (uGCPickColorDialogView != null) {
            uGCPickColorDialogView.setUgcPickColorListener(new WeakReference<>(this.ugcPickColorListener));
        }
        return uGCPickColorDialogView;
    }
}
