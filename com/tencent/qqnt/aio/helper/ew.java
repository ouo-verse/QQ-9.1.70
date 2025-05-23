package com.tencent.qqnt.aio.helper;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.event.TroopNotificationEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001$\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ew;", "Lcom/tencent/aio/main/businesshelper/h;", "", "j", "i", "k", "Lcom/tencent/mobileqq/troop/utils/as;", "msg", "o", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "getTag", "", "getId", "state", "onMoveToState", "", "interestedIn", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "e", "Ljava/lang/String;", "curTroopUin", "", "f", "Z", "isInBackground", tl.h.F, "hasDestroy", "Lcom/tencent/biz/troop/feeds/TroopNewGuidePopWindow;", "Lcom/tencent/biz/troop/feeds/TroopNewGuidePopWindow;", "troopNoticeDialog", "com/tencent/qqnt/aio/helper/ew$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/helper/ew$b;", "mTroopAnnounceObserver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ew implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String curTroopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInBackground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasDestroy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TroopNewGuidePopWindow troopNoticeDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final b mTroopAnnounceObserver = new b();

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        if (this.isInBackground) {
            QLog.d("TroopNotificationAIOHelper", 1, "isInBackground");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.es
                @Override // java.lang.Runnable
                public final void run() {
                    ew.m(ew.this);
                }
            }, 32, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final ew this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return;
        }
        String str = this$0.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        final com.tencent.mobileqq.troop.utils.as d16 = com.tencent.mobileqq.troop.utils.aw.d(qQAppInterface, str);
        if (d16 != null) {
            String str2 = d16.f302081a;
            Intrinsics.checkNotNullExpressionValue(str2, "notificationMsg.mTroopfeeds_id");
            if (str2.length() > 0) {
                if (hf0.a.a(d16.f302081a)) {
                    QLog.w("TroopNotificationAIOHelper", 1, "[showNotificationIfNeeded] ignored. fast click");
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.et
                        @Override // java.lang.Runnable
                        public final void run() {
                            ew.n(ew.this, d16);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ew this$0, com.tencent.mobileqq.troop.utils.as notificationMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(notificationMsg, "notificationMsg");
        this$0.o(notificationMsg);
    }

    private final void o(com.tencent.mobileqq.troop.utils.as msg2) {
        QLog.d("TroopNotificationAIOHelper", 1, "showTroopFeeds");
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (qQAppInterface != null && activity != null && !activity.isFinishing() && !this.hasDestroy) {
            TroopNewGuidePopWindow troopNewGuidePopWindow = this.troopNoticeDialog;
            boolean z16 = false;
            if (troopNewGuidePopWindow != null && troopNewGuidePopWindow.isShowing()) {
                z16 = true;
            }
            if (z16) {
                QLog.d("TroopNotificationAIOHelper", 1, "showTroopFeeds: troopNoticeDialog is showing");
                TroopNewGuidePopWindow troopNewGuidePopWindow2 = this.troopNoticeDialog;
                if (troopNewGuidePopWindow2 != null) {
                    troopNewGuidePopWindow2.dismiss();
                }
            }
            int D = com.tencent.mobileqq.activity.aio.l.D(activity);
            String str2 = this.curTroopUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            } else {
                str = str2;
            }
            TroopNewGuidePopWindow troopNewGuidePopWindow3 = new TroopNewGuidePopWindow(qQAppInterface, activity, str, D);
            this.troopNoticeDialog = troopNewGuidePopWindow3;
            troopNewGuidePopWindow3.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.qqnt.aio.helper.eu
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ew.p(ew.this, dialogInterface);
                }
            });
            TroopNewGuidePopWindow troopNewGuidePopWindow4 = this.troopNoticeDialog;
            if (troopNewGuidePopWindow4 != null) {
                troopNewGuidePopWindow4.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqnt.aio.helper.ev
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        ew.q(ew.this, dialogInterface);
                    }
                });
            }
            TroopNewGuidePopWindow troopNewGuidePopWindow5 = this.troopNoticeDialog;
            if (troopNewGuidePopWindow5 != null) {
                troopNewGuidePopWindow5.n0(msg2);
                return;
            }
            return;
        }
        QLog.d("TroopNotificationAIOHelper", 1, "showTroopFeeds: context null, hasDestroy=" + this.hasDestroy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ew this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a aVar = this$0.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().h(TroopNotificationEvent.OnShowEvent.f356711d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ew this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a aVar = this$0.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().h(TroopNotificationEvent.OnDismissEvent.f356710d);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350631f;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopNotificationAIOHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        this.curTroopUin = a16.g().r().c().j();
        this.hasDestroy = false;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            appInterface.addObserver(this.mTroopAnnounceObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/aio/helper/ew$b", "Lcom/tencent/mobileqq/troop/announcement/api/b;", "", "type", "", "g", "isSuccess", "", "troopUin", "", "data", "", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.troop.announcement.api.b {
        b() {
        }

        private final boolean g(int type) {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102896", true) || type == 2;
        }

        @Override // com.tencent.mobileqq.troop.announcement.api.b
        protected void c(boolean isSuccess, String troopUin, Object data) {
            if (isSuccess) {
                String str = ew.this.curTroopUin;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                    str = null;
                }
                if (Intrinsics.areEqual(troopUin, str) && (data instanceof com.tencent.mobileqq.troop.utils.as)) {
                    com.tencent.mobileqq.troop.utils.as asVar = (com.tencent.mobileqq.troop.utils.as) data;
                    String str2 = asVar.f302081a;
                    if ((str2 == null || str2.length() == 0) || !g(asVar.f302082b)) {
                        return;
                    }
                    ew.this.k();
                }
            }
        }
    }

    private final void i() {
        this.hasDestroy = true;
        TroopNewGuidePopWindow troopNewGuidePopWindow = this.troopNoticeDialog;
        if (troopNewGuidePopWindow != null) {
            Intrinsics.checkNotNull(troopNewGuidePopWindow);
            troopNewGuidePopWindow.dismiss();
            this.troopNoticeDialog = null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return;
        }
        String str = this.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        com.tencent.mobileqq.troop.utils.aw.m(qQAppInterface, str);
        this.isInBackground = true;
        this.troopNoticeDialog = null;
        qQAppInterface.removeObserver(this.mTroopAnnounceObserver);
    }

    private final void j() {
        this.isInBackground = false;
        k();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 12, 8, 9};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            j();
            return;
        }
        if (state == 12) {
            i();
        } else if (state == 8) {
            this.isInBackground = true;
        } else {
            if (state != 9) {
                return;
            }
            this.isInBackground = true;
        }
    }
}
