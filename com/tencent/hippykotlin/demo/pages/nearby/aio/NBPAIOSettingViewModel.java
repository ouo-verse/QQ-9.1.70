package com.tencent.hippykotlin.demo.pages.nearby.aio;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.aio.repository.GetBlockRequest;
import com.tencent.hippykotlin.demo.pages.nearby.aio.repository.GetUnblockRequest;
import com.tencent.hippykotlin.demo.pages.nearby.aio.repository.NBPAIOSettingRepository;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kuikly.trpc.relation.blacklist.e;
import kuikly.trpc.relation.blacklist.i;

/* loaded from: classes31.dex */
public final class NBPAIOSettingViewModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPAIOSettingViewModel.class, "isBlock", "isBlock()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPAIOSettingViewModel.class, "isRequesting", "isRequesting()Z", 0)};
    public final ReadWriteProperty isBlock$delegate;
    public final ReadWriteProperty isRequesting$delegate;
    public final String pagerId;
    public final String tid;

    public NBPAIOSettingViewModel(String str, String str2) {
        this.pagerId = str;
        this.tid = str2;
        Boolean bool = Boolean.FALSE;
        this.isBlock$delegate = c.a(bool);
        this.isRequesting$delegate = c.a(bool);
        NBPAIOSettingRepository.INSTANCE.requestCheckBlockStatus(str2, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 == null) {
                    KLog.INSTANCE.e("NBPAIOSettingViewModel", "requestCheckBlockStatus failed, rspModel is null");
                } else {
                    NBPAIOSettingViewModel.this.setBlock(eVar2.f413285d);
                }
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel.2
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                KLog.INSTANCE.e("NBPAIOSettingViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestCheckBlockStatus failed, errorCode: ", num.intValue(), ", errorMsg: ", str3));
                return Unit.INSTANCE;
            }
        });
    }

    public final void blockSomeone(boolean z16) {
        if (isRequesting()) {
            return;
        }
        setRequesting(true);
        if (z16) {
            String str = this.tid;
            final Function1<kuikly.trpc.relation.blacklist.c, Unit> function1 = new Function1<kuikly.trpc.relation.blacklist.c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel$blockSomeone$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(kuikly.trpc.relation.blacklist.c cVar) {
                    kuikly.trpc.relation.blacklist.c cVar2 = cVar;
                    NBPAIOSettingViewModel.this.setRequesting(false);
                    if (cVar2 == null) {
                        KLog.INSTANCE.e("NBPAIOSettingViewModel", "requestBlockSomeone failed, rspModel is null");
                        NBPAIOSettingViewModel.this.setBlock(false);
                    } else {
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestBlockSomeone success, code: ");
                        m3.append(cVar2.f413276d);
                        m3.append(", msg: ");
                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, cVar2.f413277e, kLog, "NBPAIOSettingViewModel");
                        long j3 = cVar2.f413276d;
                        if (j3 == 0) {
                            Utils.INSTANCE.currentBridgeModule().qToast("\u5c4f\u853d\u6210\u529f", QToastMode.Success);
                        } else if (j3 == 10001) {
                            NBPAIOSettingViewModel.this.setBlock(false);
                            Utils.INSTANCE.currentBridgeModule().showAlert(null, "\u9ed1\u540d\u5355\u5df2\u8fbe\u4e0a\u9650", "\u6211\u77e5\u9053\u4e86", null, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel$blockSomeone$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            NBPAIOSettingViewModel.this.setBlock(false);
                            if (cVar2.f413277e.length() > 0) {
                                Utils.INSTANCE.currentBridgeModule().qToast(cVar2.f413277e, QToastMode.Warning);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel$blockSomeone$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str2) {
                    NBPAIOSettingViewModel.this.setRequesting(false);
                    KLog.INSTANCE.e("NBPAIOSettingViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestBlockSomeone failed, errorCode: ", num.intValue(), ", errorMsg: ", str2));
                    Utils.INSTANCE.currentBridgeModule().qToast("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                    NBPAIOSettingViewModel.this.setBlock(false);
                    return Unit.INSTANCE;
                }
            };
            QQKuiklyPlatformApi.Companion.sendOIDBRequest(new GetBlockRequest(str), false, new Function1<OIDBResponse<kuikly.trpc.relation.blacklist.c>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.repository.NBPAIOSettingRepository$requestBlockSomeone$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(OIDBResponse<kuikly.trpc.relation.blacklist.c> oIDBResponse) {
                    OIDBResponse<kuikly.trpc.relation.blacklist.c> oIDBResponse2 = oIDBResponse;
                    if (oIDBResponse2.success) {
                        function1.invoke(oIDBResponse2.rsp);
                    } else {
                        function2.invoke(Integer.valueOf(oIDBResponse2.code), oIDBResponse2.f114186msg);
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        String str2 = this.tid;
        final Function1<i, Unit> function12 = new Function1<i, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel$blockSomeone$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(i iVar) {
                i iVar2 = iVar;
                NBPAIOSettingViewModel.this.setRequesting(false);
                if (iVar2 == null) {
                    KLog.INSTANCE.e("NBPAIOSettingViewModel", "requestUnblockSomeone failed, rspModel is null");
                    NBPAIOSettingViewModel.this.setBlock(true);
                } else {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestUnblockSomeone success, code: ");
                    m3.append(iVar2.f413298d);
                    m3.append(", msg: ");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, iVar2.f413299e, kLog, "NBPAIOSettingViewModel");
                    if (iVar2.f413298d == 0) {
                        Utils.INSTANCE.currentBridgeModule().qToast("\u53d6\u6d88\u5c4f\u853d\u6210\u529f", QToastMode.Success);
                    } else {
                        NBPAIOSettingViewModel.this.setBlock(true);
                        if (iVar2.f413299e.length() > 0) {
                            Utils.INSTANCE.currentBridgeModule().qToast(iVar2.f413299e, QToastMode.Warning);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel$blockSomeone$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                NBPAIOSettingViewModel.this.setRequesting(false);
                KLog.INSTANCE.e("NBPAIOSettingViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestUnblockSomeone failed, errorCode: ", num.intValue(), ", errorMsg: ", str3));
                Utils.INSTANCE.currentBridgeModule().qToast("\u53d6\u6d88\u5c4f\u853d\u5931\u8d25", QToastMode.Warning);
                NBPAIOSettingViewModel.this.setBlock(true);
                return Unit.INSTANCE;
            }
        };
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new GetUnblockRequest(str2), false, new Function1<OIDBResponse<i>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.repository.NBPAIOSettingRepository$requestUnblockSomeone$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<i> oIDBResponse) {
                OIDBResponse<i> oIDBResponse2 = oIDBResponse;
                if (oIDBResponse2.success) {
                    function12.invoke(oIDBResponse2.rsp);
                } else {
                    function22.invoke(Integer.valueOf(oIDBResponse2.code), oIDBResponse2.f114186msg);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final boolean isRequesting() {
        return ((Boolean) this.isRequesting$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setBlock(boolean z16) {
        this.isBlock$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final void setRequesting(boolean z16) {
        this.isRequesting$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
