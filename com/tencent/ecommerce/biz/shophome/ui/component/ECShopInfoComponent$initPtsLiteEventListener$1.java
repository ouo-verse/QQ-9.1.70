package com.tencent.ecommerce.biz.shophome.ui.component;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopManageDialog;
import com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopUnbindDialog;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.pts.core.PTSComposer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/component/ECShopInfoComponent$initPtsLiteEventListener$1", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopInfoComponent$initPtsLiteEventListener$1 extends com.tencent.ecommerce.base.ui.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECShopInfoComponent f104293a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECShopInfoComponent$initPtsLiteEventListener$1(ECShopInfoComponent eCShopInfoComponent) {
        this.f104293a = eCShopInfoComponent;
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
        String str;
        boolean k3;
        String str2;
        Bundle bundle;
        String str3;
        String str4;
        FragmentManager fragmentManager;
        String str5;
        FragmentManager fragmentManager2;
        String str6;
        String str7 = "";
        if (dataMap == null || (str = dataMap.get("eventType")) == null) {
            str = "";
        }
        int hashCode = str.hashCode();
        if (hashCode == -931150290) {
            if (str.equals("allInOneJump")) {
                if (dataMap != null && (str2 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL)) != null) {
                    str7 = str2;
                }
                if (TextUtils.isEmpty(str7)) {
                    cg0.a.a("ECShopInfoComponent", "[onTapEventTriggered] ", "jumpUrl is empty.");
                    return;
                }
                cg0.a.b("ECShopInfoComponent", "[onTapEventTriggered] jumpUrl = " + str7);
                k3 = this.f104293a.k(str7);
                if (k3) {
                    this.f104293a.l(str7);
                    return;
                } else {
                    ECScheme.g(str7, null, 2, null);
                    return;
                }
            }
            return;
        }
        if (hashCode != -332265821) {
            if (hashCode == -140766279 && str.equals("clickShopManageBtn")) {
                if (dataMap == null || (str3 = dataMap.get("popUpType")) == null) {
                    str3 = "";
                }
                if (dataMap == null || (str4 = dataMap.get("popUpDesc")) == null) {
                    str4 = "";
                }
                if (dataMap != null && (str6 = dataMap.get("popUpUrl")) != null) {
                    str7 = str6;
                }
                cg0.a.b("ECShopInfoComponent", "[onTapEventTriggered] manage_shop_des = " + str4 + "; manage_shop_url = " + str7 + ",manage_shop_popUpType = " + str3);
                switch (str3.hashCode()) {
                    case 48:
                        str3.equals("0");
                        return;
                    case 49:
                        if (str3.equals("1")) {
                            ECShopManageDialog eCShopManageDialog = new ECShopManageDialog();
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("MANAGE_SHOP_DES", str4);
                            bundle2.putString("MANAGE_SHOP_URL", str7);
                            Unit unit = Unit.INSTANCE;
                            eCShopManageDialog.setArguments(bundle2);
                            fragmentManager = this.f104293a.fragmentManager;
                            eCShopManageDialog.uh(fragmentManager, new Function1<ECShopManageDialog.ECShopManageDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.component.ECShopInfoComponent$initPtsLiteEventListener$1$onTapEventTriggered$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ECShopManageDialog.ECShopManageDialogResult eCShopManageDialogResult) {
                                    invoke2(eCShopManageDialogResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ECShopManageDialog.ECShopManageDialogResult eCShopManageDialogResult) {
                                    if (Intrinsics.areEqual(eCShopManageDialogResult, ECShopManageDialog.ECShopManageDialogResult.Cancel.f104358d)) {
                                        cg0.a.b("ECShopInfoComponent", "ecManageShopDialog cancel");
                                    } else if (Intrinsics.areEqual(eCShopManageDialogResult, ECShopManageDialog.ECShopManageDialogResult.PageReady.f104359d)) {
                                        cg0.a.b("ECShopInfoComponent", "ecManageShopDialog confirm");
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    case 50:
                        if (str3.equals("2")) {
                            ECShopUnbindDialog eCShopUnbindDialog = new ECShopUnbindDialog();
                            Bundle bundle3 = new Bundle();
                            str5 = this.f104293a.shopId;
                            bundle3.putString("shopId", str5);
                            Unit unit2 = Unit.INSTANCE;
                            eCShopUnbindDialog.setArguments(bundle3);
                            fragmentManager2 = this.f104293a.fragmentManager;
                            eCShopUnbindDialog.uh(fragmentManager2, new Function1<ECShopUnbindDialog.ECShopUnbindDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.component.ECShopInfoComponent$initPtsLiteEventListener$1$onTapEventTriggered$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ECShopUnbindDialog.ECShopUnbindDialogResult eCShopUnbindDialogResult) {
                                    invoke2(eCShopUnbindDialogResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ECShopUnbindDialog.ECShopUnbindDialogResult eCShopUnbindDialogResult) {
                                    WeakReference weakReference;
                                    if (Intrinsics.areEqual(eCShopUnbindDialogResult, ECShopUnbindDialog.ECShopUnbindDialogResult.Cancel.f104366d)) {
                                        cg0.a.b("ECShopInfoComponent", "ecShopUnbindDialog cancel");
                                        return;
                                    }
                                    if (Intrinsics.areEqual(eCShopUnbindDialogResult, ECShopUnbindDialog.ECShopUnbindDialogResult.Confirm.f104367d)) {
                                        weakReference = ECShopInfoComponent$initPtsLiteEventListener$1.this.f104293a.weakReference;
                                        Activity activity = (Activity) weakReference.get();
                                        cg0.a.b("ECShopInfoComponent", "ecShopUnbindDialog confirm context=" + activity);
                                        if (activity != null) {
                                            activity.finish();
                                            return;
                                        }
                                        return;
                                    }
                                    if (Intrinsics.areEqual(eCShopUnbindDialogResult, ECShopUnbindDialog.ECShopUnbindDialogResult.ReadyGo.f104368d)) {
                                        cg0.a.b("ECShopInfoComponent", "ecShopUnbindDialog ready go");
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        if (str.equals("qstoreLogoCk")) {
            com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
            bundle = this.f104293a.arguments;
            ECShopReportParams c16 = aVar.c(bundle);
            aVar.f(c16.role, c16.shopId, c16.source);
        }
    }
}
