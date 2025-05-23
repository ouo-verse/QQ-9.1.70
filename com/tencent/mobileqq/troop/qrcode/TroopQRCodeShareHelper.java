package com.tencent.mobileqq.troop.qrcode;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qrcode.util.QRCodeLoadingComponent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \b2\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/Rn\u00109\u001a\\\u0012\u0013\u0012\u001102\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/TroopQRCodeShareHelper;", "", "", "l", "o", "", "url", "Landroid/graphics/Bitmap;", "i", "", "width", "height", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "qrCodeView", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "troopUin", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", tl.h.F, "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "p", "()Landroid/app/Activity;", "context", "b", "Ljava/lang/String;", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "c", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager;", "d", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager;", "viewModel", "e", "chain", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopShareCard;", "f", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopShareCard;", "shareCard", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "g", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "progressDialog", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "style", "shortChain", "Lkotlin/jvm/functions/Function4;", "callback", "<init>", "(Landroid/app/Activity;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopQRCodeShareHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final TroopInfoData troopInfoData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QRDisplayTroopCardManager viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String chain;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QRDisplayTroopShareCard shareCard;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private QQProgressDialog progressDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Function4<Boolean, Integer, String, String, Unit> callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/qrcode/TroopQRCodeShareHelper$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "data", "", "Lcom/tencent/qqnt/troop/FetchTroopInfoCallback;", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Function2<Boolean, TroopInfo, Unit> {
        b() {
        }

        public void a(boolean isSuccess, TroopInfo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            TroopQRCodeShareHelper.this.h(data);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
            a(bool.booleanValue(), troopInfo);
            return Unit.INSTANCE;
        }
    }

    public TroopQRCodeShareHelper(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.troopUin = "";
        this.troopInfoData = new TroopInfoData();
        this.viewModel = new QRDisplayTroopCardManager();
        this.chain = "";
        this.callback = new Function4<Boolean, Integer, String, String, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.TroopQRCodeShareHelper$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, String str2) {
                invoke(bool.booleanValue(), num.intValue(), str, str2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, String chain, String str) {
                QRDisplayTroopShareCard qRDisplayTroopShareCard;
                QRDisplayTroopShareCard qRDisplayTroopShareCard2;
                Bitmap i16;
                Intrinsics.checkNotNullParameter(chain, "chain");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 3>");
                QLog.e("QRDisplayTroopCardShareHelper", 1, "[callback] isSuccess = " + z16 + " time = " + System.currentTimeMillis());
                if (z16) {
                    TroopQRCodeShareHelper.this.chain = chain;
                    qRDisplayTroopShareCard = TroopQRCodeShareHelper.this.shareCard;
                    if (qRDisplayTroopShareCard != null) {
                        qRDisplayTroopShareCard2 = TroopQRCodeShareHelper.this.shareCard;
                        if (qRDisplayTroopShareCard2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
                            qRDisplayTroopShareCard2 = null;
                        }
                        Activity context2 = TroopQRCodeShareHelper.this.getContext();
                        i16 = TroopQRCodeShareHelper.this.i(chain);
                        qRDisplayTroopShareCard2.R(context2, chain, i16);
                        TroopQRCodeShareHelper.this.j();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.ag
            @Override // java.lang.Runnable
            public final void run() {
                TroopQRCodeShareHelper.k(TroopQRCodeShareHelper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TroopQRCodeShareHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQProgressDialog qQProgressDialog = this$0.progressDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    private final void l() {
        this.viewModel.T1(this.troopUin, this.callback);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.ah
            @Override // java.lang.Runnable
            public final void run() {
                TroopQRCodeShareHelper.m(TroopQRCodeShareHelper.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(TroopQRCodeShareHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    private final Bitmap n(int width, int height) {
        try {
            try {
                return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        }
    }

    private final void o() {
        QRDisplayTroopShareCard qRDisplayTroopShareCard = null;
        View shareLayout = LayoutInflater.from(this.context).inflate(R.layout.h6c, (ViewGroup) null);
        int dpToPx = ViewUtils.dpToPx(428.0f);
        int dpToPx2 = ViewUtils.dpToPx(761.0f);
        shareLayout.measure(View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824), View.MeasureSpec.makeMeasureSpec(dpToPx2, 1073741824));
        shareLayout.layout(0, 0, dpToPx, dpToPx2);
        QRDisplayTroopShareCard qRDisplayTroopShareCard2 = new QRDisplayTroopShareCard();
        Intrinsics.checkNotNullExpressionValue(shareLayout, "shareLayout");
        qRDisplayTroopShareCard2.r(shareLayout, this.troopInfoData);
        QLog.e("QRDisplayTroopCardShareHelper", 1, "[doShare2QZone] chain = " + this.chain + " time = " + System.currentTimeMillis());
        if (this.chain.length() > 0) {
            QRDisplayTroopShareCard qRDisplayTroopShareCard3 = this.shareCard;
            if (qRDisplayTroopShareCard3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCard");
            } else {
                qRDisplayTroopShareCard = qRDisplayTroopShareCard3;
            }
            Activity activity = this.context;
            String str = this.chain;
            qRDisplayTroopShareCard.R(activity, str, i(str));
            j();
        }
        this.shareCard = qRDisplayTroopShareCard2;
    }

    private final void q() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.ai
            @Override // java.lang.Runnable
            public final void run() {
                TroopQRCodeShareHelper.r(TroopQRCodeShareHelper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(TroopQRCodeShareHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.progressDialog == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this$0.context);
            this$0.progressDialog = qQProgressDialog;
            qQProgressDialog.setMessage(this$0.context.getString(R.string.f132483j));
            QQProgressDialog qQProgressDialog2 = this$0.progressDialog;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.showProgerss(true);
            }
        }
        QQProgressDialog qQProgressDialog3 = this$0.progressDialog;
        if (qQProgressDialog3 != null) {
            qQProgressDialog3.show();
        }
    }

    private final void t(QUIColorfulQRCodeView qrCodeView) {
        Resources resources = this.context.getResources();
        if (QQTheme.isVasTheme()) {
            Drawable drawable = resources.getDrawable(R.drawable.qui_common_bg_bottom_standard_bg, null);
            if (drawable instanceof SkinnableBitmapDrawable) {
                Bitmap bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                QUIColorfulQRCodeView.p(qrCodeView, bitmap, null, 2, null);
                return;
            }
        }
        QUIColorfulQRCodeView.o(qrCodeView, resources.getColor(R.color.qui_common_brand_standard, null), null, 2, null);
    }

    public final void h(TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopInfoData troopInfoData = this.troopInfoData;
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        troopInfoData.updateForTroopInfo(troopInfo, currentAccountUin);
        ae aeVar = ae.f298175a;
        if (!aeVar.a(this.troopInfoData) && !aeVar.b(this.troopInfoData)) {
            if (troopInfo.isDisband()) {
                j();
                QQToastUtil.showQQToastInUiThread(0, this.context.getString(R.string.f132463h));
                return;
            } else if (troopInfo.isExited()) {
                j();
                QQToastUtil.showQQToastInUiThread(0, this.context.getString(R.string.f132473i));
                return;
            } else {
                l();
                return;
            }
        }
        j();
        QQToastUtil.showQQToastInUiThread(0, this.context.getString(R.string.f132453g));
    }

    /* renamed from: p, reason: from getter */
    public final Activity getContext() {
        return this.context;
    }

    public final void s(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, this.context.getString(R.string.f235097aq));
            return;
        }
        q();
        this.troopUin = troopUin;
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        QLog.i("QRDisplayTroopCardShareHelper", 1, "[getTroopInfo] troopUin = " + troopUin + " troopInfo = " + troopInfoFromCache);
        if (troopInfoFromCache != null) {
            h(troopInfoFromCache);
        } else {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfoWithExt(troopUin, "QRDisplayTroopCardShareHelper", null, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap i(String url) {
        int dpToPx = ViewUtils.dpToPx(288.0f);
        Bitmap n3 = n(dpToPx, dpToPx);
        if (n3 == null) {
            return null;
        }
        Canvas canvas = new Canvas(n3);
        QRCodeLoadingComponent qRCodeLoadingComponent = new QRCodeLoadingComponent(this.context, null, 0, 6, null);
        qRCodeLoadingComponent.p().setVisibility(0);
        qRCodeLoadingComponent.setChain(url, true);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
        qRCodeLoadingComponent.measure(makeMeasureSpec, makeMeasureSpec);
        t(qRCodeLoadingComponent.p());
        qRCodeLoadingComponent.layout(0, 0, dpToPx, dpToPx);
        qRCodeLoadingComponent.p().d(canvas);
        return n3;
    }
}
