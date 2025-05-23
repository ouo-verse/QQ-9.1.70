package om;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.util.ak;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.widget.RoundCorneredLinearLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$MapExtraInfo;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \n2\u00020\u0001:\u0002\u000e\u001cB\u000f\u0012\u0006\u0010\t\u001a\u00020.\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H&J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\"\u0010\u001b\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010$R$\u0010+\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010,\u00a8\u00061"}, d2 = {"Lom/a;", "", "", h.F, "g", "", "actionId", "i", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "e", "Lnm/b;", "itemData", com.tencent.luggage.wxa.c8.c.G, "a", "f", "", WadlProxyConsts.KEY_JUMP_URL, "Landroid/content/Context;", "context", "d", "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "getMContainer", "()Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "setMContainer", "(Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;)V", "mContainer", "b", "Landroid/view/View;", "c", "()Landroid/view/View;", "setMCardContent", "(Landroid/view/View;)V", "mCardContent", "Lom/a$b;", "Lom/a$b;", "mItemViewIoc", "Lnm/b;", "getMData", "()Lnm/b;", "setMData", "(Lnm/b;)V", "mData", "()I", "layoutId", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredLinearLayout mContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View mCardContent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private b mItemViewIoc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nm.b mData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lom/a$b;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "calendarTime", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "W", "()Ljava/lang/StringBuilder;", "itemTypeBuilder", "c0", "itemTypeList", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        /* renamed from: W */
        StringBuilder getItemTypeBuilder();

        String c0();

        /* renamed from: q */
        String getCalendarTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.me5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ll_card_container)");
        RoundCorneredLinearLayout roundCorneredLinearLayout = (RoundCorneredLinearLayout) findViewById;
        this.mContainer = roundCorneredLinearLayout;
        roundCorneredLinearLayout.setRadius(ar.e(8.0f));
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(b(), rootView, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView.context).i\u2026ayoutId, rootView, false)");
        this.mCardContent = inflate;
        this.mContainer.addView(inflate);
        e(this.mCardContent);
        if (rootView instanceof b) {
            this.mItemViewIoc = (b) rootView;
        }
    }

    private final void g() {
        String str;
        String str2;
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(14, 2);
        b bVar = this.mItemViewIoc;
        String str3 = "";
        if (bVar == null) {
            str = "";
        } else {
            Intrinsics.checkNotNull(bVar);
            str = bVar.c0();
        }
        lpReportInfo_dc02880.reserves1 = str;
        b bVar2 = this.mItemViewIoc;
        if (bVar2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNull(bVar2);
            str2 = bVar2.getCalendarTime();
        }
        lpReportInfo_dc02880.reserves2 = str2;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, false);
        LpReportInfo_dc02880 lpReportInfo_dc028802 = new LpReportInfo_dc02880(15, 2);
        nm.b bVar3 = this.mData;
        lpReportInfo_dc028802.reserves1 = String.valueOf(bVar3 != null ? Integer.valueOf(bVar3.j()) : null);
        b bVar4 = this.mItemViewIoc;
        if (bVar4 != null) {
            Intrinsics.checkNotNull(bVar4);
            str3 = bVar4.getCalendarTime();
        }
        lpReportInfo_dc028802.reserves2 = str3;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc028802, false, false);
        i(102);
    }

    private final void h() {
        String str;
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(15, 1);
        nm.b bVar = this.mData;
        lpReportInfo_dc02880.reserves1 = String.valueOf(bVar != null ? Integer.valueOf(bVar.j()) : null);
        b bVar2 = this.mItemViewIoc;
        if (bVar2 != null) {
            Intrinsics.checkNotNull(bVar2);
            str = bVar2.getCalendarTime();
        } else {
            str = "";
        }
        lpReportInfo_dc02880.reserves2 = str;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, false);
        i(101);
    }

    private final void i(int actionId) {
        nm.b bVar = this.mData;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            if (!bl.b(bVar.h())) {
                nm.b bVar2 = this.mData;
                Intrinsics.checkNotNull(bVar2);
                String str = "";
                String str2 = "";
                for (QZoneOfficialAccountBase$MapExtraInfo qZoneOfficialAccountBase$MapExtraInfo : bVar2.h()) {
                    if (TextUtils.equals(qZoneOfficialAccountBase$MapExtraInfo.key.get(), WinkDaTongReportConstant.ElementParamKey.ADID)) {
                        str = qZoneOfficialAccountBase$MapExtraInfo.value.get();
                        Intrinsics.checkNotNullExpressionValue(str, "extraInfo.value.get()");
                    } else if (TextUtils.equals(qZoneOfficialAccountBase$MapExtraInfo.key.get(), MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO)) {
                        str2 = qZoneOfficialAccountBase$MapExtraInfo.value.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "extraInfo.value.get()");
                    }
                }
                QLog.d("QZonePublicAcntItemBaseCardBuilder", 1, "reportItemTianShu  | adId = " + str + " | traceInfo = " + str2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.b(actionId, str, str2));
                return;
            }
        }
        QLog.w("QZonePublicAcntItemBaseCardBuilder", 1, "reportItemTianShu , ext_info is empty");
    }

    public final void a(nm.b itemData, int pos) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        this.mData = itemData;
        b bVar = this.mItemViewIoc;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            if (bVar.getItemTypeBuilder() != null) {
                b bVar2 = this.mItemViewIoc;
                Intrinsics.checkNotNull(bVar2);
                StringBuilder itemTypeBuilder = bVar2.getItemTypeBuilder();
                Intrinsics.checkNotNull(itemTypeBuilder);
                itemTypeBuilder.append(itemData.j());
                itemTypeBuilder.append(",");
            }
        }
        h();
        f(itemData, pos);
    }

    public abstract int b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c, reason: from getter */
    public final View getMCardContent() {
        return this.mCardContent;
    }

    public final void d(String jumpUrl, Context context) {
        g();
        if (TextUtils.isEmpty(jumpUrl) || context == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        ax c16 = bi.c(qQAppInterface, context, jumpUrl);
        if (c16 != null) {
            c16.b();
        } else {
            yo.d.d(jumpUrl, context, null);
        }
    }

    public abstract void e(View rootView);

    public abstract void f(nm.b itemData, int pos);
}
