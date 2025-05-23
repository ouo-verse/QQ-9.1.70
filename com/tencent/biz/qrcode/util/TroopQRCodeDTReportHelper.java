package com.tencent.biz.qrcode.util;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardRepo;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ=\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007J*\u0010\u001b\u001a\u00020\u000b*\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0019H\u0002J\u0014\u0010\u001d\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006H\u0002\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qrcode/util/TroopQRCodeDTReportHelper;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "source", "groupId", "", "qrStyle", "", "e", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "saveView", "f", "shareView", "g", "switchView", "i", "editView", "d", "changeView", tl.h.F, "method", "Lkotlin/Function1;", "callback", "c", "elementId", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class TroopQRCodeDTReportHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopQRCodeDTReportHelper f95052a = new TroopQRCodeDTReportHelper();

    TroopQRCodeDTReportHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(View view, String str) {
        VideoReport.setElementId(view, str);
    }

    private final void c(View view, String str, Function1<? super View, Unit> function1) {
        if (view == null) {
            QLog.i("TroopQRCodeDTReportHelper", 1, str + " view is null");
            return;
        }
        function1.invoke(view);
    }

    @JvmStatic
    public static final void d(@Nullable View editView) {
        f95052a.c(editView, "initEditButtonData", new Function1<View, Unit>() { // from class: com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper$initEditButtonData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TroopQRCodeDTReportHelper.f95052a.b(it, "em_group_qrcode_toset_btn");
            }
        });
    }

    @JvmStatic
    public static final void e(@Nullable final FragmentActivity activity, @Nullable View rootView, @NotNull final String source, @NotNull final String groupId, @Nullable final Integer qrStyle) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        f95052a.c(rootView, "initQrCodePageData", new Function1<View, Unit>() { // from class: com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper$initQrCodePageData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                Integer num;
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.addToDetectionWhitelist(FragmentActivity.this);
                VideoReport.setPageId(it, "pg_group_qrcode");
                VideoReport.setPageReportPolicy(it, PageReportPolicy.REPORT_ALL);
                String str = source;
                if (str.length() == 0) {
                    str = "1000";
                }
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, str), TuplesKt.to("group_id", groupId), TuplesKt.to("qrcode_type", (!QRDisplayTroopCardRepo.f298123a.i() || (num = qrStyle) == null || num == null || num.intValue() != 2) ? "0" : "1"));
                VideoReport.setPageParams(it, new PageParams((Map<String, ?>) mapOf));
            }
        });
    }

    @JvmStatic
    public static final void f(@Nullable View saveView) {
        f95052a.c(saveView, "initSaveButtonData", new Function1<View, Unit>() { // from class: com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper$initSaveButtonData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TroopQRCodeDTReportHelper.f95052a.b(it, "em_group_qrcode_save_btn");
            }
        });
    }

    @JvmStatic
    public static final void g(@Nullable View shareView) {
        f95052a.c(shareView, "initShareButtonData", new Function1<View, Unit>() { // from class: com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper$initShareButtonData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TroopQRCodeDTReportHelper.f95052a.b(it, "em_group_qrcode_share_btn");
            }
        });
    }

    @JvmStatic
    public static final void h(@Nullable View changeView) {
        f95052a.c(changeView, "initStyleChangeButtonData", new Function1<View, Unit>() { // from class: com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper$initStyleChangeButtonData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TroopQRCodeDTReportHelper.f95052a.b(it, "em_group_qrcode_change_btn");
            }
        });
    }

    @JvmStatic
    public static final void i(@Nullable View switchView) {
        f95052a.c(switchView, "initSwitchSourceButtonData", new Function1<View, Unit>() { // from class: com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper$initSwitchSourceButtonData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TroopQRCodeDTReportHelper.f95052a.b(it, "em_group_qrcode_switch_btn");
            }
        });
    }
}
