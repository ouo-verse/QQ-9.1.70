package com.tencent.ecommerce.base.plugin;

import android.content.Intent;
import com.tencent.ecommerce.base.network.api.ECPkgCodingType;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECSendPackageCallback;
import com.tencent.ecommerce.base.report.service.g;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.biz.consumer.factory.ECGoodsCardFactory;
import com.tencent.ecommerce.biz.util.n;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\bRN\u0010\u000f\u001a<\u0012\u0004\u0012\u00020\u0002\u00122\u00120\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/ECLogicDispatcher;", "", "", "type", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "it", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callback", "", "a", "", "Lkotlin/Function2;", "Ljava/util/Map;", "processors", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECLogicDispatcher {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, Function2<HashMap<String, String>, IECLogicCallback, Unit>> processors;

    /* renamed from: b, reason: collision with root package name */
    public static final ECLogicDispatcher f100875b = new ECLogicDispatcher();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        processors = linkedHashMap;
        linkedHashMap.put(101, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.h(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(102, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.y(hashMap);
            }
        });
        linkedHashMap.put(103, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.j(iECLogicCallback);
            }
        });
        linkedHashMap.put(104, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.p(hashMap);
            }
        });
        linkedHashMap.put(105, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.o(hashMap);
            }
        });
        linkedHashMap.put(106, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.x(hashMap);
            }
        });
        linkedHashMap.put(107, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.u(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(125, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.v(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(108, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.t(hashMap);
            }
        });
        linkedHashMap.put(109, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.10
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.g();
            }
        });
        linkedHashMap.put(115, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.11
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.n(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(122, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.12
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.m(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(116, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.13
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.biz.live.a.f102661d.w(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(111, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.14
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                ECPTSStyleManager.f100993b.preloadStyle(wg0.a.a());
            }
        });
        linkedHashMap.put(110, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.15
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                String str = hashMap.get("PARAM_PAGE_NAME");
                String str2 = hashMap.get("PARAM_FRAME_TREE");
                if (str == null || str2 == null) {
                    return;
                }
                ECPTSStyleManager.f100993b.updateStyle(str, str2);
            }
        });
        linkedHashMap.put(113, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.16
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                String str = hashMap.get("PARAM_SCREEN_RECEIVER_ACTION");
                if (str != null) {
                    new wg0.b().receive(new Intent(str));
                }
            }
        });
        linkedHashMap.put(114, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.17

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/plugin/ECLogicDispatcher$17$a", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "successResponse", "", "onSuccess", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* renamed from: com.tencent.ecommerce.base.plugin.ECLogicDispatcher$17$a */
            /* loaded from: classes32.dex */
            public static final class a implements IECSendPackageCallback {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ IECLogicCallback f100876a;

                a(IECLogicCallback iECLogicCallback) {
                    this.f100876a = iECLogicCallback;
                }

                @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
                public void onError(ECRemoteResponse errorResponse) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("RESULT_ERROR", errorResponse);
                    this.f100876a.onResult(hashMap);
                }

                @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
                public void onSuccess(ECRemoteResponse successResponse) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("RESULT_SUCCESS", successResponse);
                    this.f100876a.onResult(hashMap);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                ECPkgCodingType eCPkgCodingType;
                String str = hashMap.get("PARAM_SERVICE");
                String str2 = str != null ? str : "";
                String str3 = hashMap.get("PARAM_METHOD");
                String str4 = str3 != null ? str3 : "";
                String str5 = hashMap.get("PARAM_DATA");
                String str6 = str5 != null ? str5 : "";
                String str7 = hashMap.get("PARAM_CODING_TYPE");
                if (str7 == null) {
                    str7 = "0";
                }
                com.tencent.ecommerce.base.network.service.a aVar = com.tencent.ecommerce.base.network.service.a.f100826c;
                byte[] bytes = str6.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                if (Intrinsics.areEqual(str7, "0")) {
                    eCPkgCodingType = ECPkgCodingType.EC_PACKAGE_CODING_TYPE_JSON;
                } else {
                    eCPkgCodingType = ECPkgCodingType.EC_PACKAGE_CODING_TYPE_PROTOBUF;
                }
                aVar.i(str2, str4, bytes, eCPkgCodingType, new a(iECLogicCallback));
            }
        });
        linkedHashMap.put(117, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.18
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                ECGoodsCardFactory.f101594e.i(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(118, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.19
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                ECGoodsCardFactory.f101594e.j(hashMap);
            }
        });
        linkedHashMap.put(119, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.20
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                ECGoodsCardFactory.f101594e.k(hashMap);
            }
        });
        linkedHashMap.put(120, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.21
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                String str = hashMap.get("PARAM_EVENT_CODE");
                if (str == null) {
                    str = "";
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.putAll(hashMap);
                linkedHashMap2.remove("PARAM_EVENT_CODE");
                if (!Intrinsics.areEqual(str, "")) {
                    g.d(str, linkedHashMap2);
                }
            }
        });
        linkedHashMap.put(121, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.22
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                zh0.a.f452541a.c(hashMap);
            }
        });
        linkedHashMap.put(123, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.23
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                mj0.a.f416860b.b(hashMap, iECLogicCallback);
            }
        });
        linkedHashMap.put(124, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.24
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                HashMap<String, Object> hashMapOf;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_HR_VIEW_MODEL_OBJECT", new com.tencent.ecommerce.biz.hr.c()));
                iECLogicCallback.onResult(hashMapOf);
            }
        });
        linkedHashMap.put(127, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.25
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                HashMap<String, Object> hashMapOf;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("fragment_model", new com.tencent.ecommerce.biz.hr.b()));
                iECLogicCallback.onResult(hashMapOf);
            }
        });
        linkedHashMap.put(126, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.26
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                n nVar = n.f104876a;
                String str = hashMap.get("crash_stack");
                if (str == null) {
                    str = "";
                }
                nVar.a(str);
            }
        });
        linkedHashMap.put(99, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.27
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.base.eventbus.a.f100697c.d(hashMap);
            }
        });
        linkedHashMap.put(98, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.28
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                com.tencent.ecommerce.base.eventbus.a.f100697c.g(hashMap);
            }
        });
        linkedHashMap.put(128, new Function2<HashMap<String, String>, IECLogicCallback, Unit>() { // from class: com.tencent.ecommerce.base.plugin.ECLogicDispatcher.29
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                invoke2(hashMap, iECLogicCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap, IECLogicCallback iECLogicCallback) {
                mj0.a.f416860b.c(hashMap, iECLogicCallback);
            }
        });
    }

    ECLogicDispatcher() {
    }

    public final void a(int type, HashMap<String, String> it, IECLogicCallback callback) {
        Function2<HashMap<String, String>, IECLogicCallback, Unit> function2 = processors.get(Integer.valueOf(type));
        if (function2 != null) {
            function2.invoke(it, callback);
        }
    }
}
