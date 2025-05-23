package com.qzone.reborn.albumx.qzonex.part.degrade;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import com.qzone.reborn.albumx.qzone.vas.event.QZonePhotoDegradeEvent;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.troop.e;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import na.e;
import nc.ae;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/degrade/QZAlbumxPhotoDegradeDialogPart;", "Lcom/qzone/reborn/base/k;", "", "D9", "Lcom/tencent/mobileqq/vas/troop/e$c;", "dialogData", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnc/ae;", "d", "Lnc/ae;", "albumViewModel", "", "e", "Z", "needRefresh", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxPhotoDegradeDialogPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ae albumViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean needRefresh = ar.INSTANCE.a("anzaihuang", "2024-07-18", "vas_qzone_photo_refresh_vip").isEnable(true);

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/degrade/QZAlbumxPhotoDegradeDialogPart$a", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements IVasYellowDiamondPay.a {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (isSuccess) {
                QZonePhotoDegradeEvent qZonePhotoDegradeEvent = new QZonePhotoDegradeEvent();
                qZonePhotoDegradeEvent.setForceClose(true);
                SimpleEventBus.getInstance().dispatchEvent(qZonePhotoDegradeEvent);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/degrade/QZAlbumxPhotoDegradeDialogPart$b", "Lkotlin/Function1;", "", "", "isChecked", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Function1<Boolean, Unit> {
        b() {
        }

        public void a(boolean isChecked) {
            HashMap hashMap = new HashMap();
            hashMap.put("belong_app", 1);
            hashMap.put("action_type", "click");
            hashMap.put("btn_type", 1);
            hashMap.put("is_tick", Integer.valueOf(isChecked ? 1 : 0));
            if (isChecked) {
                e.f419543a.d(3);
            }
            fo.c.c("ev_qz_yellowdiamond_demotion_pop", hashMap);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/degrade/QZAlbumxPhotoDegradeDialogPart$c", "Lkotlin/Function1;", "", "", "isChecked", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements Function1<Boolean, Unit> {
        c() {
        }

        public void a(boolean isChecked) {
            HashMap hashMap = new HashMap();
            hashMap.put("belong_app", 1);
            hashMap.put("action_type", "click");
            hashMap.put("btn_type", 2);
            hashMap.put("is_tick", Integer.valueOf(isChecked ? 1 : 0));
            if (isChecked) {
                e.f419543a.d(3);
            }
            fo.c.c("ev_qz_yellowdiamond_demotion_pop", hashMap);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    private final void D9() {
        ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).addPayCallback(new a());
        e.f419543a.b(3, new QZAlbumxPhotoDegradeDialogPart$requestDegradeDialog$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(e.DialogData dialogData) {
        b bVar = new b();
        c cVar = new c();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        new com.tencent.mobileqq.vas.troop.e(activity, dialogData, bVar, cVar).j();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026istViewModel::class.java)");
        ae aeVar = (ae) viewModel;
        this.albumViewModel = aeVar;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        if (Intrinsics.areEqual(aeVar.a2().getUin(), LoginData.getInstance().getUinString())) {
            D9();
        }
        if (!this.needRefresh || LoginData.getInstance().isQzoneVip()) {
            return;
        }
        VipEnv.refreshYellowDiamondInfo();
    }
}
