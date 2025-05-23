package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import com.tencent.avbiz.Constants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Method;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VipRequest;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.UserIDRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UploadBackgroundRequest {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object isSuperVip2(UpLoadBackgroundPage upLoadBackgroundPage, Continuation<? super Boolean> continuation) {
        UploadBackgroundRequest$isSuperVip2$1 uploadBackgroundRequest$isSuperVip2$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof UploadBackgroundRequest$isSuperVip2$1) {
            uploadBackgroundRequest$isSuperVip2$1 = (UploadBackgroundRequest$isSuperVip2$1) continuation;
            int i16 = uploadBackgroundRequest$isSuperVip2$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                uploadBackgroundRequest$isSuperVip2$1.label = i16 - Integer.MIN_VALUE;
                Object obj = uploadBackgroundRequest$isSuperVip2$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = uploadBackgroundRequest$isSuperVip2$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    UserIDRequest userIDRequest = new UserIDRequest();
                    uploadBackgroundRequest$isSuperVip2$1.label = 1;
                    obj = userIDRequest.isSuperVip(upLoadBackgroundPage, uploadBackgroundRequest$isSuperVip2$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("isSVip2: ", ((Boolean) obj).booleanValue(), KLog.INSTANCE, "UploadBackgroundRequest");
                return obj;
            }
        }
        uploadBackgroundRequest$isSuperVip2$1 = new UploadBackgroundRequest$isSuperVip2$1(this, continuation);
        Object obj2 = uploadBackgroundRequest$isSuperVip2$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = uploadBackgroundRequest$isSuperVip2$1.label;
        if (i3 != 0) {
        }
        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("isSVip2: ", ((Boolean) obj2).booleanValue(), KLog.INSTANCE, "UploadBackgroundRequest");
        return obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object batchSetBackgroundPhoto(UpLoadBackgroundPage upLoadBackgroundPage, final b bVar, final int i3, Continuation<? super Pair<Boolean, String>> continuation) {
        UploadBackgroundRequest$batchSetBackgroundPhoto$1 uploadBackgroundRequest$batchSetBackgroundPhoto$1;
        Object coroutine_suspended;
        int i16;
        String trimIndent;
        UpLoadBackgroundPage upLoadBackgroundPage2;
        e m3;
        String str;
        if (continuation instanceof UploadBackgroundRequest$batchSetBackgroundPhoto$1) {
            uploadBackgroundRequest$batchSetBackgroundPhoto$1 = (UploadBackgroundRequest$batchSetBackgroundPhoto$1) continuation;
            int i17 = uploadBackgroundRequest$batchSetBackgroundPhoto$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                uploadBackgroundRequest$batchSetBackgroundPhoto$1.label = i17 - Integer.MIN_VALUE;
                Object obj = uploadBackgroundRequest$batchSetBackgroundPhoto$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = uploadBackgroundRequest$batchSetBackgroundPhoto$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    trimIndent = StringsKt__IndentKt.trimIndent("\n            {\n            \t\"req\": " + new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundRequest$batchSetBackgroundPhoto$reqData$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            e eVar2 = eVar;
                            final b bVar2 = b.this;
                            eVar2.z("infos", new b(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundRequest$batchSetBackgroundPhoto$reqData$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(b bVar3) {
                                    b bVar4 = bVar3;
                                    int c16 = b.this.c();
                                    for (int i18 = 0; i18 < c16; i18++) {
                                        e eVar3 = new e();
                                        e l3 = b.this.l(i18);
                                        if (l3 != null) {
                                            eVar3.v("uid", l3.p("uin"));
                                            eVar3.t("localType", l3.j("type") + 2);
                                        }
                                        bVar4.a(bVar4, eVar3);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }));
                            final int i18 = i3;
                            eVar2.z("itemInfos", new b(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundRequest$batchSetBackgroundPhoto$reqData$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(b bVar3) {
                                    b bVar4 = bVar3;
                                    bVar4.b(bVar4, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundRequest.batchSetBackgroundPhoto.reqData.1.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(e eVar3) {
                                            e eVar4 = eVar3;
                                            eVar4.z("appid", 8);
                                            eVar4.z("itemId", 99);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final int i19 = i18;
                                    bVar4.b(bVar4, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundRequest.batchSetBackgroundPhoto.reqData.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(e eVar3) {
                                            e eVar4 = eVar3;
                                            eVar4.z("appid", 35);
                                            eVar4.z("itemId", Integer.valueOf(i19));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            }));
                            return Unit.INSTANCE;
                        }
                    }) + ",\n            \t\"options\": {\n            \t\t\"context\": {\n            \t\t\t\"businessType\": \"qqgxh\"\n            \t\t},\n            \t\t\"naming\": {\n            \t\t\t\"namespace\": \"Production\",\n            \t\t\t\"env\": \"formal\"\n            \t\t}\n            \t}\n            }\n            ");
                    e eVar = new e(trimIndent);
                    KRequest kRequest = VipRequest.instance;
                    RequestConfig requestConfig = new RequestConfig(null, null, null, null, eVar, 0, null, 991);
                    uploadBackgroundRequest$batchSetBackgroundPhoto$1.L$0 = upLoadBackgroundPage;
                    uploadBackgroundRequest$batchSetBackgroundPhoto$1.label = 1;
                    kRequest.getClass();
                    requestConfig.method = Method.POST;
                    requestConfig.url = "https://zb.vip.qq.com/trpc-proxy/qqva/uni_logic_server/UniLogic/BatchUpGradeBG";
                    obj = kRequest.request(requestConfig, uploadBackgroundRequest$batchSetBackgroundPhoto$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    upLoadBackgroundPage2 = upLoadBackgroundPage;
                } else if (i16 == 1) {
                    upLoadBackgroundPage2 = uploadBackgroundRequest$batchSetBackgroundPhoto$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e eVar2 = ((Response) obj).data;
                KLog kLog = KLog.INSTANCE;
                kLog.i(upLoadBackgroundPage2.getPageName(), "batchSetBackgroundPhoto result " + eVar2);
                m3 = eVar2.m("error");
                if (!(m3 == null && m3.j("ret") == 0)) {
                    return TuplesKt.to(Boxing.boxBoolean(true), "success");
                }
                e m16 = eVar2.m("error");
                if (m16 == null || (str = m16.p("message")) == null) {
                    str = "";
                }
                kLog.i(upLoadBackgroundPage2.getPageName(), AgreementConsentViewKt$$ExternalSyntheticOutline0.m("errmsg : ", str));
                return TuplesKt.to(Boxing.boxBoolean(false), str);
            }
        }
        uploadBackgroundRequest$batchSetBackgroundPhoto$1 = new UploadBackgroundRequest$batchSetBackgroundPhoto$1(this, continuation);
        Object obj2 = uploadBackgroundRequest$batchSetBackgroundPhoto$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = uploadBackgroundRequest$batchSetBackgroundPhoto$1.label;
        if (i16 != 0) {
        }
        e eVar22 = ((Response) obj2).data;
        KLog kLog2 = KLog.INSTANCE;
        kLog2.i(upLoadBackgroundPage2.getPageName(), "batchSetBackgroundPhoto result " + eVar22);
        m3 = eVar22.m("error");
        if (!(m3 == null && m3.j("ret") == 0)) {
        }
    }

    public final List<BackgroundStyleItemData> fetchEffectData() {
        ArrayList arrayListOf;
        BackgroundStyleItemData backgroundStyleItemData = new BackgroundStyleItemData();
        backgroundStyleItemData.setSelected(true);
        backgroundStyleItemData.itemId = 0;
        backgroundStyleItemData.isFree = true;
        backgroundStyleItemData.backgroundTitle = Constants.Business.DEFAULT;
        backgroundStyleItemData.backgroundImagePath = "";
        Unit unit = Unit.INSTANCE;
        BackgroundStyleItemData backgroundStyleItemData2 = new BackgroundStyleItemData();
        backgroundStyleItemData2.itemId = 100006;
        backgroundStyleItemData2.backgroundTitle = "\u8774\u8776";
        backgroundStyleItemData2.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100006/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData3 = new BackgroundStyleItemData();
        backgroundStyleItemData3.itemId = 100004;
        backgroundStyleItemData3.backgroundTitle = "\u7231\u5fc3\u82b1\u74e3";
        backgroundStyleItemData3.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100004/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData4 = new BackgroundStyleItemData();
        backgroundStyleItemData4.itemId = 100003;
        backgroundStyleItemData4.backgroundTitle = "\u7231\u604b\u73ab\u7470";
        backgroundStyleItemData4.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100003/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData5 = new BackgroundStyleItemData();
        backgroundStyleItemData5.itemId = 100008;
        backgroundStyleItemData5.backgroundTitle = "\u5343\u7eb8\u9e64";
        backgroundStyleItemData5.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100008/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData6 = new BackgroundStyleItemData();
        backgroundStyleItemData6.itemId = 100011;
        backgroundStyleItemData6.backgroundTitle = "\u70b8\u5f39";
        backgroundStyleItemData6.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100011/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData7 = new BackgroundStyleItemData();
        backgroundStyleItemData7.itemId = 100010;
        backgroundStyleItemData7.backgroundTitle = "\u65f6\u5149\u7a7f\u68ad";
        backgroundStyleItemData7.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100010/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData8 = new BackgroundStyleItemData();
        backgroundStyleItemData8.itemId = 100009;
        backgroundStyleItemData8.backgroundTitle = "\u6e05\u65b0\u67e0\u6aac";
        backgroundStyleItemData8.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100009/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData9 = new BackgroundStyleItemData();
        backgroundStyleItemData9.itemId = 100007;
        backgroundStyleItemData9.backgroundTitle = "\u793c\u76d2";
        backgroundStyleItemData9.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100007/listImg.png";
        BackgroundStyleItemData backgroundStyleItemData10 = new BackgroundStyleItemData();
        backgroundStyleItemData10.itemId = 100001;
        backgroundStyleItemData10.backgroundTitle = "\u751c\u871c\u6a31\u6843";
        backgroundStyleItemData10.backgroundImagePath = "https://tianquan.gtimg.cn/colorScreen/diybg/100001/listImg.png";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(backgroundStyleItemData, backgroundStyleItemData2, backgroundStyleItemData3, backgroundStyleItemData4, backgroundStyleItemData5, backgroundStyleItemData6, backgroundStyleItemData7, backgroundStyleItemData8, backgroundStyleItemData9, backgroundStyleItemData10);
        return arrayListOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object callUniSet(UpLoadBackgroundPage upLoadBackgroundPage, String str, int i3, int i16, Continuation<? super Pair<Boolean, String>> continuation) {
        UploadBackgroundRequest$callUniSet$1 uploadBackgroundRequest$callUniSet$1;
        Object coroutine_suspended;
        int i17;
        int i18;
        String trimIndent;
        String trimIndent2;
        UpLoadBackgroundPage upLoadBackgroundPage2;
        e eVar;
        String str2;
        if (continuation instanceof UploadBackgroundRequest$callUniSet$1) {
            uploadBackgroundRequest$callUniSet$1 = (UploadBackgroundRequest$callUniSet$1) continuation;
            int i19 = uploadBackgroundRequest$callUniSet$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                uploadBackgroundRequest$callUniSet$1.label = i19 - Integer.MIN_VALUE;
                UploadBackgroundRequest$callUniSet$1 uploadBackgroundRequest$callUniSet$12 = uploadBackgroundRequest$callUniSet$1;
                Object obj = uploadBackgroundRequest$callUniSet$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = uploadBackgroundRequest$callUniSet$12.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int i26 = 3;
                    if (str.length() == 0) {
                        i18 = 1;
                    } else if (i3 == 0) {
                        i18 = 2;
                    } else {
                        if (i3 != 1) {
                            KLog.INSTANCE.e(upLoadBackgroundPage.getPageName(), "error uinType = " + i3);
                            return TuplesKt.to(Boxing.boxBoolean(false), "error uinType");
                        }
                        i18 = 3;
                    }
                    String uin = i18 == 1 ? upLoadBackgroundPage.platformApi.getQqModule().getUin() : str;
                    trimIndent = StringsKt__IndentKt.trimIndent("\n            ,\n            {\n                \"appid\": 35,\n                \"itemid\": \"" + i16 + "\"\n            }\n            ");
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\n            {\n            \t\"stLogin\": {\n            \t\t\"iKeyType\": 1,\n            \t\t\"iOpplat\":");
                    if (upLoadBackgroundPage.platformApi.getVasModule().getPlatformType() == 1) {
                        i26 = 2;
                    } else if (upLoadBackgroundPage.platformApi.getVasModule().getPlatformType() != 2) {
                        i26 = 0;
                    }
                    m3.append(i26);
                    m3.append(",\n            \t    \"lUin\": ");
                    m3.append(upLoadBackgroundPage.platformApi.getQqModule().getUin());
                    m3.append(",\n            \t\t\"sClientVer\": \"");
                    m3.append(upLoadBackgroundPage.platformApi.getVasModule().getMainClientVersion());
                    m3.append("\"\n            \t},\n            \t\"stHamletItem\": {\n            \t    \"uid\": \"");
                    m3.append(uin);
                    m3.append("\",\n            \t    \"locationtype\": ");
                    m3.append(i18);
                    m3.append(",\n            \t    \"itemlist\": [\n            \t        {\n            \t            \"appid\": 8,\n            \t            \"itemid\": 99\n            \t        }\n                        ");
                    m3.append(trimIndent);
                    m3.append("\n            \t    ]\n            \t}\n            }\n            ");
                    trimIndent2 = StringsKt__IndentKt.trimIndent(m3.toString());
                    e eVar2 = new e(trimIndent2);
                    uploadBackgroundRequest$callUniSet$12.L$0 = upLoadBackgroundPage;
                    uploadBackgroundRequest$callUniSet$12.L$1 = eVar2;
                    uploadBackgroundRequest$callUniSet$12.label = 1;
                    obj = upLoadBackgroundPage.httpPost("https://zb.vip.qq.com/srf/QC_UniBusinessLogicServer_UniBusinessLogicObj/uniSet", "vip.qq.com", eVar2, false, null, uploadBackgroundRequest$callUniSet$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    upLoadBackgroundPage2 = upLoadBackgroundPage;
                    eVar = eVar2;
                } else if (i17 == 1) {
                    eVar = uploadBackgroundRequest$callUniSet$12.L$1;
                    upLoadBackgroundPage2 = uploadBackgroundRequest$callUniSet$12.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = (String) obj;
                String m16 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("singleSetBackgroundPhoto result ", str2);
                KLog kLog = KLog.INSTANCE;
                kLog.i(upLoadBackgroundPage2.getPageName(), m16);
                if (!(str2.length() != 0)) {
                    kLog.e(upLoadBackgroundPage2.getPageName(), eVar.toString());
                    return TuplesKt.to(Boxing.boxBoolean(false), "empty resp");
                }
                e m17 = new e(str2).m("data");
                e m18 = m17 != null ? m17.m("rsp") : null;
                if (m18 == null) {
                    kLog.e(upLoadBackgroundPage2.getPageName(), eVar.toString());
                    kLog.e(upLoadBackgroundPage2.getPageName(), str2);
                    return TuplesKt.to(Boxing.boxBoolean(false), "error resp");
                }
                if (Intrinsics.areEqual(m18.p("ret"), "0")) {
                    return TuplesKt.to(Boxing.boxBoolean(true), "success");
                }
                String p16 = m18.p(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
                kLog.i(upLoadBackgroundPage2.getPageName(), AgreementConsentViewKt$$ExternalSyntheticOutline0.m("errmsg : ", p16));
                return TuplesKt.to(Boxing.boxBoolean(false), p16);
            }
        }
        uploadBackgroundRequest$callUniSet$1 = new UploadBackgroundRequest$callUniSet$1(this, continuation);
        UploadBackgroundRequest$callUniSet$1 uploadBackgroundRequest$callUniSet$122 = uploadBackgroundRequest$callUniSet$1;
        Object obj2 = uploadBackgroundRequest$callUniSet$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = uploadBackgroundRequest$callUniSet$122.label;
        if (i17 != 0) {
        }
        str2 = (String) obj2;
        String m162 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("singleSetBackgroundPhoto result ", str2);
        KLog kLog2 = KLog.INSTANCE;
        kLog2.i(upLoadBackgroundPage2.getPageName(), m162);
        if (!(str2.length() != 0)) {
        }
    }
}
