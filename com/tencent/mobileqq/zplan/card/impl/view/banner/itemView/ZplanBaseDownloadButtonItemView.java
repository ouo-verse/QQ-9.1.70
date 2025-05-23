package com.tencent.mobileqq.zplan.card.impl.view.banner.itemView;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBannerStyle;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u008e\u0001\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162(\b\u0002\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\"\u0010#\u001a\u00020\u001d8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanBaseDownloadButtonItemView;", "Landroid/widget/FrameLayout;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "params", "", h.F, "Lpv4/s;", "data", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "clazz", "Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "barType", "", "cloudModBtnType", "", "reportByOutSide", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lkotlin/Function0;", "buttonClickListener", "e", "d", "Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "b", "()Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "g", "(Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;)V", "downloadButton", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "c", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "setDownloadButtonBinder", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;)V", "downloadButtonBinder", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ZplanBaseDownloadButtonItemView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected ZplanCommonButton downloadButton;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ZootopiaDownloadButtonBinder downloadButtonBinder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBaseDownloadButtonItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZplanCommonButton b() {
        ZplanCommonButton zplanCommonButton = this.downloadButton;
        if (zplanCommonButton != null) {
            return zplanCommonButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadButton");
        return null;
    }

    public final ZootopiaDownloadButtonBinder c() {
        ZootopiaDownloadButtonBinder zootopiaDownloadButtonBinder = this.downloadButtonBinder;
        if (zootopiaDownloadButtonBinder != null) {
            return zootopiaDownloadButtonBinder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadButtonBinder");
        return null;
    }

    public String d() {
        return String.valueOf(c().getCurrMapInfo().getMapID());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(ZplanCommonButton zplanCommonButton) {
        Intrinsics.checkNotNullParameter(zplanCommonButton, "<set-?>");
        this.downloadButton = zplanCommonButton;
    }

    public void h(HashMap<String, Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        c().l(params);
    }

    public final void setDownloadButtonBinder(ZootopiaDownloadButtonBinder zootopiaDownloadButtonBinder) {
        Intrinsics.checkNotNullParameter(zootopiaDownloadButtonBinder, "<set-?>");
        this.downloadButtonBinder = zootopiaDownloadButtonBinder;
    }

    public final void e(s data, ZootopiaSource sourceCurrent, LifecycleOwner lifecycleOwner, Class<? extends ZootopiaDownloadButton> clazz, ZootopiaDownloadBarType barType, int cloudModBtnType, boolean reportByOutSide, HashMap<String, Object> reportParams, Function0<Unit> buttonClickListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(barType, "barType");
        b().setClickHandler(buttonClickListener);
        b().t(new fl3.a(data.f427684e, data.f427682c, "#FFFFFF", clazz, barType, cloudModBtnType, sourceCurrent, c(), reportByOutSide, reportParams), lifecycleOwner);
    }

    public static /* synthetic */ void f(ZplanBaseDownloadButtonItemView zplanBaseDownloadButtonItemView, s sVar, ZootopiaSource zootopiaSource, LifecycleOwner lifecycleOwner, Class cls, ZootopiaDownloadBarType zootopiaDownloadBarType, int i3, boolean z16, HashMap hashMap, Function0 function0, int i16, Object obj) {
        if (obj == null) {
            zplanBaseDownloadButtonItemView.e(sVar, zootopiaSource, (i16 & 4) != 0 ? null : lifecycleOwner, (i16 & 8) != 0 ? ZootopiaDownloadButtonBannerStyle.class : cls, (i16 & 16) != 0 ? ZootopiaDownloadBarType.BANNER_DOWNLOAD_BAR : zootopiaDownloadBarType, (i16 & 32) != 0 ? 2 : i3, (i16 & 64) != 0 ? true : z16, (i16 & 128) != 0 ? null : hashMap, (i16 & 256) != 0 ? null : function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderDownloadButton");
    }
}
