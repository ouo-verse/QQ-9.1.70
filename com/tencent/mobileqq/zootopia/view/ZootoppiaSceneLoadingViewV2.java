package com.tencent.mobileqq.zootopia.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUETechReportParams;
import com.tencent.mobileqq.zplan.smallhome.ZPlanUEActivityHelper;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEScaleEvent;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatus;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 v2\u00020\u0001:\u0001\u0014B\u001d\b\u0007\u0012\u0006\u0010q\u001a\u00020p\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010r\u00a2\u0006\u0004\bt\u0010uJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J&\u0010\u001b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010#\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016J \u0010'\u001a\u00020\u00022\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020 H\u0016J \u0010+\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020(2\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0018\u0010@\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00109R\u0018\u0010H\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00109R\u0018\u0010J\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u00109R\u0018\u0010L\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00105R\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u00109R\u0016\u0010\u0016\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010aR\u0016\u0010h\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010j\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010aR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010K\u00a8\u0006w"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootoppiaSceneLoadingViewV2;", "Lcom/tencent/mobileqq/zootopia/view/ZPlanBaseSceneLoadingView;", "", "r", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "status", "", "isStatusChanged", "B", "isBack", HippyTKDListViewAdapter.X, "", "btnStatus", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "type", "v", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "a", "Lid3/d;", "reportHelper", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "params", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "c", tl.h.F, "Landroid/view/View$OnClickListener;", "listener", "setOnBackArrowClickListener", "", "progressTitle", "progress", "e", "ver1", "ver2", "ver3", "i", "", "title", SecretUtils.DES, "g", "f", "Landroid/app/Activity;", "Landroid/view/View;", "Landroid/view/View;", "contentView", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "loadMediaViewBg", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "backBtn", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "backBtnTxt", BdhLogUtil.LogTag.Tag_Conn, "ver1Info", "D", "ver2Info", "E", "ver3Info", "Landroid/widget/ProgressBar;", UserInfo.SEX_FEMALE, "Landroid/widget/ProgressBar;", "progressBar", "G", "progressDes", "H", "loadMsg", "I", "loadDes", "J", "downLoadBtnLL", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "downLoadBtnIcon", "L", "downLoadBtnTxt", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "M", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "N", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "P", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "isLand", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View$OnClickListener;", "exitSourceClick", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "BACK_TIPS", "T", "BACK_LOAD_TIPS", "U", "CONTINUE_DOWNLOAD", "V", "STOP_DOWNLOAD", "W", "REPAIRE_RES", "a0", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "", "b0", "startTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "c0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootoppiaSceneLoadingViewV2 extends ZPlanBaseSceneLoadingView {

    /* renamed from: d0, reason: collision with root package name */
    private static final int f329710d0 = com.tencent.sqshow.zootopia.utils.i.a(7.3f);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f329711e0 = com.tencent.sqshow.zootopia.utils.i.b(9);

    /* renamed from: f0, reason: collision with root package name */
    private static final int f329712f0 = com.tencent.sqshow.zootopia.utils.i.a(11.8f);

    /* renamed from: C, reason: from kotlin metadata */
    private TextView ver1Info;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView ver2Info;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView ver3Info;

    /* renamed from: F, reason: from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView progressDes;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView loadMsg;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView loadDes;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout downLoadBtnLL;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView downLoadBtnIcon;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView downLoadBtnTxt;

    /* renamed from: M, reason: from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: N, reason: from kotlin metadata */
    private ZootopiaEnterParams params;

    /* renamed from: P, reason: from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isLand;

    /* renamed from: R, reason: from kotlin metadata */
    private View.OnClickListener exitSourceClick;

    /* renamed from: S, reason: from kotlin metadata */
    private String BACK_TIPS;

    /* renamed from: T, reason: from kotlin metadata */
    private String BACK_LOAD_TIPS;

    /* renamed from: U, reason: from kotlin metadata */
    private String CONTINUE_DOWNLOAD;

    /* renamed from: V, reason: from kotlin metadata */
    private String STOP_DOWNLOAD;

    /* renamed from: W, reason: from kotlin metadata */
    private String REPAIRE_RES;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ZPlanModLoadStatus status;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private URLImageView loadMediaViewBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout backBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView backBtnTxt;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f329720a;

        static {
            int[] iArr = new int[ZPlanModLoadStatus.values().length];
            try {
                iArr[ZPlanModLoadStatus.UELoading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZPlanModLoadStatus.MainPakPausing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ZPlanModLoadStatus.MainPakDownloading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ZPlanModLoadStatus.MainPakDownloadFinish.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f329720a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootoppiaSceneLoadingViewV2$c", "Lcom/tencent/mobileqq/zootopia/view/a;", "", "errorCode", "", "errorMessage", "", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends a {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.a, com.tencent.mobileqq.zootopia.ipc.ah
        public void onFailed(int errorCode, String errorMessage) {
            Activity activity;
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            super.onFailed(errorCode, errorMessage);
            if (errorCode != -87604 || (activity = ZootoppiaSceneLoadingViewV2.this.activity) == null) {
                return;
            }
            activity.finish();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootoppiaSceneLoadingViewV2(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ZootoppiaSceneLoadingViewV2 this$0, String ver1, String ver2, String ver3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ver1, "$ver1");
        Intrinsics.checkNotNullParameter(ver2, "$ver2");
        Intrinsics.checkNotNullParameter(ver3, "$ver3");
        TextView textView = this$0.ver1Info;
        if (textView != null) {
            textView.setText(ver1);
        }
        TextView textView2 = this$0.ver2Info;
        if (textView2 != null) {
            textView2.setText(ver2);
        }
        TextView textView3 = this$0.ver3Info;
        if (textView3 == null) {
            return;
        }
        textView3.setText(ver3);
    }

    private final void B(final ZPlanModLoadStatus status, final boolean isStatusChanged) {
        post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ah
            @Override // java.lang.Runnable
            public final void run() {
                ZootoppiaSceneLoadingViewV2.D(ZPlanModLoadStatus.this, this, isStatusChanged);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(ZPlanModLoadStatus status, ZootoppiaSceneLoadingViewV2 this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(status, "$status");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = b.f329720a[status.ordinal()];
        if (i3 == 1) {
            this$0.x(true);
            TextView textView = this$0.backBtnTxt;
            if (textView == null) {
                return;
            }
            textView.setText(this$0.BACK_TIPS);
            return;
        }
        if (i3 == 2) {
            this$0.x(true);
            TextView textView2 = this$0.backBtnTxt;
            if (textView2 != null) {
                textView2.setText(this$0.BACK_TIPS);
            }
            this$0.y(2, z16);
            return;
        }
        if (i3 == 3) {
            this$0.x(false);
            TextView textView3 = this$0.backBtnTxt;
            if (textView3 != null) {
                textView3.setText(this$0.BACK_LOAD_TIPS);
            }
            this$0.y(1, z16);
            return;
        }
        if (i3 != 4) {
            this$0.x(false);
            TextView textView4 = this$0.backBtnTxt;
            if (textView4 == null) {
                return;
            }
            textView4.setText(this$0.BACK_LOAD_TIPS);
            return;
        }
        this$0.y(0, z16);
    }

    private final void r() {
        View view = this.contentView;
        this.loadMediaViewBg = view != null ? (URLImageView) view.findViewById(R.id.q5v) : null;
        u();
        View view2 = this.contentView;
        this.backBtn = view2 != null ? (LinearLayout) view2.findViewById(R.id.r1k) : null;
        View view3 = this.contentView;
        this.backBtnTxt = view3 != null ? (TextView) view3.findViewById(R.id.f163300pd4) : null;
        View view4 = this.contentView;
        this.ver1Info = view4 != null ? (TextView) view4.findViewById(R.id.r9u) : null;
        View view5 = this.contentView;
        this.ver2Info = view5 != null ? (TextView) view5.findViewById(R.id.r9v) : null;
        View view6 = this.contentView;
        this.ver3Info = view6 != null ? (TextView) view6.findViewById(R.id.r9w) : null;
        View view7 = this.contentView;
        this.progressBar = view7 != null ? (ProgressBar) view7.findViewById(R.id.f163490qe3) : null;
        View view8 = this.contentView;
        this.progressDes = view8 != null ? (TextView) view8.findViewById(R.id.qe9) : null;
        View view9 = this.contentView;
        this.loadMsg = view9 != null ? (TextView) view9.findViewById(R.id.q5x) : null;
        View view10 = this.contentView;
        this.loadDes = view10 != null ? (TextView) view10.findViewById(R.id.q5w) : null;
        View view11 = this.contentView;
        this.downLoadBtnLL = view11 != null ? (LinearLayout) view11.findViewById(R.id.r7l) : null;
        View view12 = this.contentView;
        this.downLoadBtnIcon = view12 != null ? (ImageView) view12.findViewById(R.id.r3f) : null;
        View view13 = this.contentView;
        this.downLoadBtnTxt = view13 != null ? (TextView) view13.findViewById(R.id.r3g) : null;
        C(this, this.status, false, 2, null);
        LinearLayout linearLayout = this.backBtn;
        if (linearLayout != null) {
            com.tencent.sqshow.zootopia.utils.aa.b(linearLayout, com.tencent.sqshow.zootopia.utils.i.b(10));
        }
        LinearLayout linearLayout2 = this.backBtn;
        if (linearLayout2 != null) {
            com.tencent.sqshow.zootopia.utils.aa.d(linearLayout2, new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view14) {
                    ZootoppiaSceneLoadingViewV2.s(ZootoppiaSceneLoadingViewV2.this, view14);
                }
            });
        }
        LinearLayout linearLayout3 = this.downLoadBtnLL;
        if (linearLayout3 != null) {
            com.tencent.sqshow.zootopia.utils.aa.d(linearLayout3, new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view14) {
                    ZootoppiaSceneLoadingViewV2.t(ZootoppiaSceneLoadingViewV2.this, view14);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZootoppiaSceneLoadingViewV2 this$0, View it) {
        Map<String, ? extends Object> mutableMapOf;
        Map<String, ? extends Object> mutableMapOf2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = b.f329720a[this$0.status.ordinal()];
        if (i3 != 1 && i3 != 2) {
            ZootopiaEnterParams zootopiaEnterParams = this$0.params;
            if (zootopiaEnterParams != null) {
                int mapId = zootopiaEnterParams.getMapId();
                this$0.v(1);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                ZootopiaEnterParams zootopiaEnterParams2 = this$0.params;
                simpleEventBus.dispatchEvent(new ZPlanUEScaleEvent(zootopiaEnterParams2 != null ? zootopiaEnterParams2.getMapId() : -1, "", "", 0, 4));
                com.tencent.mobileqq.zplan.smallhome.i.f335703a.e(mapId, ZPlanUEActivityHelper.INSTANCE.a().j());
                ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_download_state", 1));
                zplanViewReportHelper.e(it, "em_zplan_back_btn", mutableMapOf2);
                return;
            }
            return;
        }
        this$0.v(0);
        ZplanViewReportHelper zplanViewReportHelper2 = this$0.reportHelper;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_download_state", 0));
        zplanViewReportHelper2.e(it, "em_zplan_back_btn", mutableMapOf);
        View.OnClickListener onClickListener = this$0.exitSourceClick;
        if (onClickListener != null) {
            onClickListener.onClick(it);
        }
        Activity activity = this$0.activity;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ZootoppiaSceneLoadingViewV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaEnterParams zootopiaEnterParams = this$0.params;
        if (zootopiaEnterParams != null) {
            int mapId = zootopiaEnterParams.getMapId();
            int i3 = b.f329720a[this$0.status.ordinal()];
            if (i3 == 2) {
                ZootopiaDownloadManagerIpc.f328013a.o(mapId, new c(), this$0.activity);
                ImageView imageView = this$0.downLoadBtnIcon;
                if (imageView != null) {
                    this$0.reportHelper.e(imageView, "em_zplan_continue_loading_btn", new LinkedHashMap());
                    return;
                }
                return;
            }
            if (i3 != 3) {
                com.tencent.mobileqq.zplan.smallhome.i.f335703a.c();
                ImageView imageView2 = this$0.downLoadBtnIcon;
                if (imageView2 != null) {
                    this$0.reportHelper.e(imageView2, "em_zplan_fix_version_btn", new LinkedHashMap());
                }
                this$0.v(2);
                return;
            }
            ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).pauseMapDownload(String.valueOf(mapId), new a());
            ImageView imageView3 = this$0.downLoadBtnIcon;
            if (imageView3 != null) {
                this$0.reportHelper.e(imageView3, "em_zplan_suspend_loading_btn", new LinkedHashMap());
            }
        }
    }

    private final void u() {
        URLImageView uRLImageView;
        ZootopiaMapLoadingParams loadingParams;
        ZootopiaEnterParams zootopiaEnterParams = this.params;
        pu4.g loadingBackgroundMaterial = (zootopiaEnterParams == null || (loadingParams = zootopiaEnterParams.getLoadingParams()) == null) ? null : loadingParams.loadingBackgroundMaterial();
        QLog.d("ZootopiaSceneLoadingViewV2", 1, "loadBackgroundView, material: " + loadingBackgroundMaterial);
        if (loadingBackgroundMaterial == null || (uRLImageView = this.loadMediaViewBg) == null) {
            return;
        }
        String str = loadingBackgroundMaterial.f427434a;
        Intrinsics.checkNotNullExpressionValue(str, "it.url");
        CommonExKt.v(uRLImageView, str, R.drawable.ofc, null, 4, null);
    }

    private final void v(int type) {
        String str;
        Boolean isDownloaded;
        com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
        ZPlanUETechReportParams.Companion companion = ZPlanUETechReportParams.INSTANCE;
        ZootopiaEnterParams zootopiaEnterParams = this.params;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : -1;
        long currentTimeMillis = System.currentTimeMillis();
        ZootopiaEnterParams zootopiaEnterParams2 = this.params;
        long startTime = currentTimeMillis - (zootopiaEnterParams2 != null ? zootopiaEnterParams2.getStartTime() : 0L);
        long currentTimeMillis2 = System.currentTimeMillis() - this.startTime;
        ZootopiaEnterParams zootopiaEnterParams3 = this.params;
        if (zootopiaEnterParams3 == null || (str = zootopiaEnterParams3.getSource()) == null) {
            str = "0";
        }
        ZootopiaEnterParams zootopiaEnterParams4 = this.params;
        bVar.e(companion.a(mapId, startTime, currentTimeMillis2, false, true, str, (zootopiaEnterParams4 == null || (isDownloaded = zootopiaEnterParams4.getIsDownloaded()) == null) ? true : isDownloaded.booleanValue()), this.status.ordinal(), type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ZootoppiaSceneLoadingViewV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y(3, true);
    }

    private final void y(@BtnStatus int btnStatus, boolean isStatusChanged) {
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        QLog.d("ZootopiaSceneLoadingViewV2", 1, "updateDownloadBtn, btnStatus: " + btnStatus);
        if (btnStatus == 0) {
            LinearLayout linearLayout = this.downLoadBtnLL;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        if (btnStatus == 1) {
            LinearLayout linearLayout2 = this.downLoadBtnLL;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            TextView textView = this.downLoadBtnTxt;
            if (textView != null) {
                textView.setText(this.STOP_DOWNLOAD);
            }
            ImageView imageView4 = this.downLoadBtnIcon;
            layoutParams = imageView4 != null ? imageView4.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.width = f329710d0;
            }
            if (layoutParams != null) {
                layoutParams.height = f329711e0;
            }
            ImageView imageView5 = this.downLoadBtnIcon;
            if (imageView5 != null) {
                imageView5.setVisibility(0);
            }
            ImageView imageView6 = this.downLoadBtnIcon;
            if (imageView6 != null) {
                imageView6.setBackgroundResource(R.drawable.iip);
            }
            if (!isStatusChanged || (imageView = this.downLoadBtnIcon) == null) {
                return;
            }
            this.reportHelper.g(imageView, "em_zplan_suspend_loading_btn", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            return;
        }
        if (btnStatus == 2) {
            LinearLayout linearLayout3 = this.downLoadBtnLL;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            ImageView imageView7 = this.downLoadBtnIcon;
            if (imageView7 != null) {
                imageView7.setVisibility(8);
            }
            TextView textView2 = this.downLoadBtnTxt;
            if (textView2 != null) {
                textView2.setText(this.CONTINUE_DOWNLOAD);
            }
            if (!isStatusChanged || (imageView2 = this.downLoadBtnIcon) == null) {
                return;
            }
            this.reportHelper.g(imageView2, "em_zplan_continue_loading_btn", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            return;
        }
        if (btnStatus != 3) {
            return;
        }
        LinearLayout linearLayout4 = this.downLoadBtnLL;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        TextView textView3 = this.downLoadBtnTxt;
        if (textView3 != null) {
            textView3.setText(this.REPAIRE_RES);
        }
        ImageView imageView8 = this.downLoadBtnIcon;
        layoutParams = imageView8 != null ? imageView8.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = f329712f0;
        }
        if (layoutParams != null) {
            layoutParams.height = f329712f0;
        }
        ImageView imageView9 = this.downLoadBtnIcon;
        if (imageView9 != null) {
            imageView9.setVisibility(0);
        }
        ImageView imageView10 = this.downLoadBtnIcon;
        if (imageView10 != null) {
            imageView10.setBackgroundResource(R.drawable.iio);
        }
        if (!isStatusChanged || (imageView3 = this.downLoadBtnIcon) == null) {
            return;
        }
        this.reportHelper.g(imageView3, "em_zplan_fix_version_btn", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ZootoppiaSceneLoadingViewV2 this$0, float f16, String title, String des) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(des, "$des");
        ProgressBar progressBar = this$0.progressBar;
        if (progressBar != null) {
            progressBar.setProgress((int) f16);
        }
        TextView textView = this$0.progressDes;
        if (textView != null) {
            textView.setText(com.tencent.mobileqq.zplan.utils.r.f335836a.a(f16));
        }
        TextView textView2 = this$0.loadMsg;
        if (textView2 != null) {
            textView2.setText(title);
        }
        TextView textView3 = this$0.loadDes;
        if (textView3 == null) {
            return;
        }
        textView3.setText(des);
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.a(activity);
        this.startTime = System.currentTimeMillis();
        this.activity = activity;
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void f() {
        super.f();
        post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.af
            @Override // java.lang.Runnable
            public final void run() {
                ZootoppiaSceneLoadingViewV2.w(ZootoppiaSceneLoadingViewV2.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void g(final float progress, final String title, final String des) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(des, "des");
        QLog.d("ZootopiaSceneLoadingViewV2", 4, "progress: " + progress + ", title:" + title + ", des:" + des);
        post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ag
            @Override // java.lang.Runnable
            public final void run() {
                ZootoppiaSceneLoadingViewV2.z(ZootoppiaSceneLoadingViewV2.this, progress, title, des);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void h(ZPlanModLoadStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        boolean z16 = this.status != status;
        this.status = status;
        B(status, z16);
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void i(final String ver1, final String ver2, final String ver3) {
        Intrinsics.checkNotNullParameter(ver1, "ver1");
        Intrinsics.checkNotNullParameter(ver2, "ver2");
        Intrinsics.checkNotNullParameter(ver3, "ver3");
        QLog.d("ZootopiaSceneLoadingViewV2", 1, "ver1: " + ver1 + ", ver2:" + ver2 + ", ver3:" + ver3);
        post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ai
            @Override // java.lang.Runnable
            public final void run() {
                ZootoppiaSceneLoadingViewV2.A(ZootoppiaSceneLoadingViewV2.this, ver1, ver2, ver3);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void setOnBackArrowClickListener(View.OnClickListener listener) {
        this.exitSourceClick = listener;
    }

    public /* synthetic */ ZootoppiaSceneLoadingViewV2(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootoppiaSceneLoadingViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportHelper = new ZplanViewReportHelper();
        String string = context.getString(R.string.xog);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026zplan_engine_load_return)");
        this.BACK_TIPS = string;
        String string2 = context.getString(R.string.xoe);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.zplan_engine_load_back)");
        this.BACK_LOAD_TIPS = string2;
        String string3 = context.getString(R.string.f169841xw3);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026lan_ue_continue_download)");
        this.CONTINUE_DOWNLOAD = string3;
        String string4 = context.getString(R.string.xwf);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.zplan_ue_stop_download)");
        this.STOP_DOWNLOAD = string4;
        String string5 = context.getString(R.string.xwe);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.zplan_ue_repaire_res)");
        this.REPAIRE_RES = string5;
        this.status = ZPlanModLoadStatus.Init;
        this.startTime = -1L;
    }

    private final void q() {
        Map<String, Object> mutableMapOf;
        Map mutableMapOf2;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Pair[] pairArr = new Pair[1];
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.INSTANCE.g();
        }
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, zootopiaSource);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        zplanViewReportHelper.a(context, this, "pg_zplan_xiaowo_loading", mutableMapOf);
        ZplanViewReportHelper zplanViewReportHelper2 = this.reportHelper;
        Pair[] pairArr2 = new Pair[1];
        ZootopiaSource zootopiaSource2 = this.source;
        if (zootopiaSource2 == null) {
            zootopiaSource2 = ZootopiaSource.INSTANCE.g();
        }
        pairArr2[0] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, zootopiaSource2);
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr2);
        zplanViewReportHelper2.g(this, "pg_zplan_xiaowo_loading", (r16 & 4) != 0 ? null : mutableMapOf2, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        LinearLayout linearLayout = this.backBtn;
        if (linearLayout != null) {
            this.reportHelper.g(linearLayout, "em_zplan_back_btn", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    private final void x(boolean isBack) {
        if (isBack) {
            TextView textView = this.backBtnTxt;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = this.backBtnTxt;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void c(id3.d reportHelper, ZootopiaEnterParams params, ZootopiaSource source) {
        if (params == null) {
            return;
        }
        this.params = params;
        this.source = source;
        if (this.contentView == null) {
            this.isLand = params.getScreenType() != 2;
            this.contentView = View.inflate(getContext(), R.layout.d9_, this);
            r();
            q();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void e(String progressTitle, String progress) {
        boolean z16 = false;
        if (progressTitle != null) {
            if (!(progressTitle.length() == 0)) {
                z16 = true;
            }
        }
        if (!z16) {
            progressTitle = getContext().getString(R.string.xwb);
            Intrinsics.checkNotNullExpressionValue(progressTitle, "context.getString(R.string.zplan_ue_in_loading)");
        }
        g(progress != null ? Float.parseFloat(progress) : 0.0f, progressTitle, "");
    }

    static /* synthetic */ void C(ZootoppiaSceneLoadingViewV2 zootoppiaSceneLoadingViewV2, ZPlanModLoadStatus zPlanModLoadStatus, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        zootoppiaSceneLoadingViewV2.B(zPlanModLoadStatus, z16);
    }
}
