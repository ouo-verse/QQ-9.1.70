package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.aio.event.AIOTroopGiftEvent;
import com.tencent.mobileqq.aio.event.NTPanelEntrance;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/GiftOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "g", "", "", "isShowRedDot", "", "aioType", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "d", "friendUin", "e", "f", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "Z", "enableNewC2CPanel", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GiftOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: b, reason: collision with root package name */
    private static final a f360472b = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enableNewC2CPanel = VasLongToggle.VAS_C2C_GIFT_PANEL_KUIKLY_CONFIG.isEnable(false);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/GiftOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void e(Activity activity, String friendUin) {
        String replace$default;
        String stringData = VasLongToggle.VAS_C2C_GIFT_PANEL_KUIKLY_CONFIG.getStringData("");
        if (stringData.length() == 0) {
            return;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(stringData, "{friendUin}", friendUin, false, 4, (Object) null);
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(activity, replace$default);
    }

    private final boolean f(com.tencent.aio.api.runtime.a context) {
        context.e().h(new AIOTroopGiftEvent.TroopSendGiftEvent(true, null, NTPanelEntrance.TROOP_PLUS_PANEL));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(long uin, QQAppInterface app, com.tencent.aio.api.runtime.a context) {
        boolean z16;
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("GiftOnClickProcessor", 2, "deliver flowers!");
        }
        int e16 = context.g().r().c().e();
        if (e16 == 1) {
            if (this.enableNewC2CPanel) {
                e(requireActivity, String.valueOf(uin));
            } else {
                d(requireActivity, String.valueOf(uin));
            }
            z16 = false;
        } else {
            if (e16 != 2) {
                return;
            }
            z16 = f(context);
            i3 = 1;
        }
        c(String.valueOf(uin), z16, app, i3);
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.GiftOnClickProcessor$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, QQAppInterface qQAppInterface) {
                invoke(l3.longValue(), qQAppInterface);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, QQAppInterface app) {
                Intrinsics.checkNotNullParameter(app, "app");
                GiftOnClickProcessor.this.g(j3, app, context);
            }
        });
    }

    private final void d(Activity activity, String uin) {
        String url;
        String url2;
        try {
            String url3 = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_C2C_PLUS_GIFT_JUMP_URL, QzoneConfig.DefaultValue.DEFAULT_C2C_PLUS_AIO_GIFT_JUMP_URL);
            int i3 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()) ? 1 : 0;
            Intrinsics.checkNotNullExpressionValue(url3, "url");
            url = StringsKt__StringsJVMKt.replace$default(url3, "{uin}", uin, false, 4, (Object) null);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            url2 = StringsKt__StringsJVMKt.replace$default(url, "{themeMode}", sb5.toString(), false, 4, (Object) null);
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
                bundle.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                Intrinsics.checkNotNullExpressionValue(url2, "url");
                iVasHybridRoute.openTranslucentBrowser(activity, url2, null, bundle);
            } else {
                Intent intent = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
                intent.putExtra("url", url2);
                intent.setData(Uri.parse(url2));
                intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                activity.startActivity(intent);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GiftOnClickProcessor", 2, e16, new Object[0]);
            }
        }
    }

    private final void c(String uin, boolean isShowRedDot, QQAppInterface app, int aioType) {
        if (aioType != 1) {
            if (aioType == 2) {
                ReportController.o(app, "dc00899", "Grp_flower", "", ProtocolDownloaderConstants.HOST_C2C, "gift_clk", 0, 0, "", "", "", "");
            }
        } else if (com.tencent.biz.anonymous.a.h().d(uin)) {
            ReportController.o(null, "dc00899", "Grp_anon", "", "aio_plus", "clk_send", 1, 0, uin, "", "", "");
        } else {
            ReportController.o(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_plus", 0, 0, uin, String.valueOf(isShowRedDot), "", "");
        }
        ReportController.o(app, "dc00899", "grp_lbs", "", "qq_gift", "plus_entry_clk", 0, 0, String.valueOf(aioType), "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("GiftOnClickProcessor", 2, "PlusPanel onGiftClick, aioType=" + aioType);
        }
    }
}
