package com.tencent.mobileqq.nearbypro.feeds.publish.kuikly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.nearbypro.ai.NBPAIHelper;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feeds.event.NBPFeedRefreshEvent;
import com.tencent.mobileqq.nearbypro.media.NBPMediaInfo;
import com.tencent.mobileqq.nearbypro.media.NBPMediaSelector;
import com.tencent.mobileqq.nearbypro.media.gallery.NBGalleryPreview;
import com.tencent.mobileqq.nearbypro.media.gallery.NBLayerDeleteMediaEvent;
import com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qzone.LbsDataV2;
import i01.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import rp4.f;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J5\u0010\f\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\r\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\u000e\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J=\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J?\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0015\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J?\u0010\u0018\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0004H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0016JI\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\u0012\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"`#H\u0016R;\u0010'\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feeds/publish/kuikly/NBPPublishKuiklyModule;", "Li01/e;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "r", "", "sourcePath", "u", "w", "params", "l", "v", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "Lcooperation/qzone/LbsDataV2$GpsInfo;", "gps", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "method", "call", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Lkotlin/jvm/functions/Function1;", "enterGalleryPreviewPageCallback", "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "e", "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "recorder", "<init>", "()V", "f", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPPublishKuiklyModule extends e implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> enterGalleryPreviewPageCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FilamentCoverRecorder recorder = new FilamentCoverRecorder();

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/nearbypro/feeds/publish/kuikly/NBPPublishKuiklyModule$b", "Lcom/tencent/lbssearch/httpresponse/HttpResponseListener;", "Lcom/tencent/lbssearch/object/result/Geo2AddressResultObject;", "", "p0", "p1", "", "a", "", "", "p2", "onFailure", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements HttpResponseListener<Geo2AddressResultObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f253305a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super String, Unit> function1) {
            this.f253305a = function1;
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(int p06, @Nullable Geo2AddressResultObject p16) {
            String str;
            Geo2AddressResultObject.ReverseAddressResult reverseAddressResult;
            AdInfo adInfo;
            Function1<String, Unit> function1 = this.f253305a;
            if (p16 != null && (reverseAddressResult = p16.result) != null && (adInfo = reverseAddressResult.ad_info) != null) {
                str = adInfo.nation;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            function1.invoke(str);
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int p06, @Nullable String p16, @Nullable Throwable p26) {
            j.c().d("NBPPublishKuiklyModule", "getCountryByPoiId error: " + p16);
            this.f253305a.invoke("");
        }
    }

    private final void j(Object params, Function1<Object, Unit> callback) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (getContext() == null) {
                j.c().d("NBPPublishKuiklyModule", "detectPhotoTag, context is null");
                return;
            }
            float[] f16 = NBPAIHelper.f253088a.f(str);
            if (f16 == null) {
                if (callback != null) {
                    callback.invoke(null);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("output", new JSONArray(f16));
                if (callback != null) {
                    callback.invoke(jSONObject);
                }
            }
        }
    }

    private final void l(Object params, Function1<Object, Unit> callback) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (getContext() == null) {
                j.c().d("NBPPublishKuiklyModule", "enterGalleryPreviewPage, context is null");
                return;
            }
            SimpleEventBus.getInstance().registerReceiver(this);
            this.enterGalleryPreviewPageCallback = callback;
            NBGalleryPreview nBGalleryPreview = NBGalleryPreview.f253611a;
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            Bundle bundle = new Bundle();
            bundle.putBoolean("NBP_GALLERY_TITLE", true);
            Unit unit = Unit.INSTANCE;
            nBGalleryPreview.a(str, null, context, bundle);
        }
    }

    private final void m(final Function1<Object, Unit> callback) {
        addKuiklyRenderLifecycleCallback(new c() { // from class: com.tencent.mobileqq.nearbypro.feeds.publish.kuikly.NBPPublishKuiklyModule$enterLocationPage$lifecycleCallback$1
            @Override // com.tencent.kuikly.core.render.android.c
            public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                final LbsDataV2.PoiInfo poiInfo;
                boolean z16;
                LatLng latLng;
                Bundle extras;
                c.a.a(this, requestCode, resultCode, data);
                if (requestCode == 1208) {
                    SelfUserInfo b16 = com.tencent.mobileqq.nearbypro.utils.c.b(j.b());
                    if (data != null && (extras = data.getExtras()) != null) {
                        poiInfo = (LbsDataV2.PoiInfo) extras.getParcelable(PoiDbManager.TBL_POI);
                    } else {
                        poiInfo = null;
                    }
                    if (poiInfo != null && !Intrinsics.areEqual(poiInfo.poiId, "invalide_poi_id")) {
                        if (Intrinsics.areEqual(poiInfo.poiName, b16.getLocationName()) && (latLng = b16.getLatLng()) != null) {
                            LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
                            double d16 = 1000000;
                            gpsInfo.lat = (int) (latLng.latitude * d16);
                            gpsInfo.alt = (int) (latLng.altitude * d16);
                        }
                        String str = poiInfo.country;
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            NBPPublishKuiklyModule nBPPublishKuiklyModule = NBPPublishKuiklyModule.this;
                            LbsDataV2.GpsInfo gpsInfo2 = poiInfo.gpsInfo;
                            Intrinsics.checkNotNullExpressionValue(gpsInfo2, "newPoiInfo.gpsInfo");
                            final Function1<Object, Unit> function1 = callback;
                            nBPPublishKuiklyModule.o(gpsInfo2, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.feeds.publish.kuikly.NBPPublishKuiklyModule$enterLocationPage$lifecycleCallback$1$onActivityResult$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                    invoke2(str2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    LbsDataV2.PoiInfo poiInfo2 = LbsDataV2.PoiInfo.this;
                                    poiInfo2.country = it;
                                    byte[] c16 = com.tencent.mobileqq.nearbypro.request.c.c(com.tencent.mobileqq.nearbypro.utils.e.g(poiInfo2));
                                    Function1<Object, Unit> function12 = function1;
                                    if (function12 != null) {
                                        function12.invoke(c16);
                                    }
                                }
                            });
                            return;
                        }
                        byte[] c16 = com.tencent.mobileqq.nearbypro.request.c.c(com.tencent.mobileqq.nearbypro.utils.e.g(poiInfo));
                        Function1<Object, Unit> function12 = callback;
                        if (function12 != null) {
                            function12.invoke(c16);
                        }
                    }
                }
                NBPPublishKuiklyModule.this.removeKuiklyRenderLifeCycleCallback(this);
            }
        });
        ((INearbyProToolApi) QRoute.api(INearbyProToolApi.class)).launchLocationSelectPage(getActivity(), 1208);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(LbsDataV2.GpsInfo gps, Function1<? super String, Unit> callback) {
        new TencentSearch(getContext()).geo2address(new Geo2AddressParam(a.a(gps)).getPoi(false).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(1).setPageIndex(1)), new b(callback));
    }

    private final void p(Object params) {
        Object orNull;
        byte[] bArr;
        if (params instanceof Object[]) {
            try {
                orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
                if (orNull instanceof byte[]) {
                    bArr = (byte[]) orNull;
                } else {
                    bArr = null;
                }
                i statusFeed = i.d(bArr);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                Intrinsics.checkNotNullExpressionValue(statusFeed, "statusFeed");
                simpleEventBus.dispatchEvent(new NBPFeedRefreshEvent(statusFeed));
            } catch (Throwable th5) {
                j.c().d("NBPPublishKuiklyModule", "notifyFeedRefresh error: " + th5);
            }
        }
    }

    private final void q(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        boolean optBoolean = jSONObject.optBoolean("detectPhotoTag");
        long optLong = jSONObject.optLong("minSoVersion");
        long optLong2 = jSONObject.optLong("minModelVersion");
        if (optBoolean) {
            NBPAIHelper.j(NBPAIHelper.f253088a, optLong, optLong2, null, 4, null);
        }
        Context context = getContext();
        if (context != null) {
            NBPMediaSelector.f253605a.h(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final Function1<Object, Unit> callback) {
        Activity activity = getActivity();
        if (activity == null) {
            j.c().d("NBPPublishKuiklyModule", "openAlbum, activity is null");
        } else {
            NBPMediaSelector.f253605a.e(activity, new WeakReference<>(this), new Function1<List<? extends NBPMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.nearbypro.feeds.publish.kuikly.NBPPublishKuiklyModule$openAlbum$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends NBPMediaInfo> list) {
                    invoke2((List<NBPMediaInfo>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<NBPMediaInfo> it) {
                    Object firstOrNull;
                    Object firstOrNull2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ga2.a c16 = j.c();
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) it);
                    NBPMediaInfo nBPMediaInfo = (NBPMediaInfo) firstOrNull;
                    c16.e("NBPPublishKuiklyModule", "openAlbum, path: " + (nBPMediaInfo != null ? nBPMediaInfo.getMediaPath() : null));
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) it);
                    NBPMediaInfo nBPMediaInfo2 = (NBPMediaInfo) firstOrNull2;
                    if (nBPMediaInfo2 == null) {
                        NBPPublishKuiklyModule.this.r(callback);
                    } else {
                        NBPPublishKuiklyModule.this.u(nBPMediaInfo2.getMediaPath(), callback);
                    }
                }
            });
        }
    }

    private final void t(final Function1<Object, Unit> callback) {
        Activity activity = getActivity();
        if (activity == null) {
            j.c().d("NBPPublishKuiklyModule", "openCamera, activity is null");
        } else {
            NBPMediaSelector.f253605a.f(activity, new Function1<List<? extends NBPMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.nearbypro.feeds.publish.kuikly.NBPPublishKuiklyModule$openCamera$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends NBPMediaInfo> list) {
                    invoke2((List<NBPMediaInfo>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<NBPMediaInfo> it) {
                    Object firstOrNull;
                    Object firstOrNull2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ga2.a c16 = j.c();
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) it);
                    NBPMediaInfo nBPMediaInfo = (NBPMediaInfo) firstOrNull;
                    c16.e("NBPPublishKuiklyModule", "openCamera, path: " + (nBPMediaInfo != null ? nBPMediaInfo.getMediaPath() : null));
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) it);
                    NBPMediaInfo nBPMediaInfo2 = (NBPMediaInfo) firstOrNull2;
                    if (nBPMediaInfo2 != null) {
                        NBPPublishKuiklyModule.this.u(nBPMediaInfo2.getMediaPath(), callback);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final String sourcePath, final Function1<Object, Unit> callback) {
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.feeds.publish.kuikly.NBPPublishKuiklyModule$processSourceImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String w3;
                w3 = NBPPublishKuiklyModule.this.w(sourcePath);
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(w3);
                }
            }
        });
    }

    private final void v(Object params, final Function1<Object, Unit> callback) {
        Object orNull;
        byte[] bArr;
        if (params instanceof Object[]) {
            try {
                orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
                if (orNull instanceof byte[]) {
                    bArr = (byte[]) orNull;
                } else {
                    bArr = null;
                }
                f resourceInfo = f.c(bArr);
                Intrinsics.checkNotNullExpressionValue(resourceInfo, "resourceInfo");
                final Resource f16 = com.tencent.mobileqq.nearbypro.utils.e.f(resourceInfo, null, 1, null);
                SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.feeds.publish.kuikly.NBPPublishKuiklyModule$recordAvatar$1

                    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/nearbypro/feeds/publish/kuikly/NBPPublishKuiklyModule$recordAvatar$1$a", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/data/RecordSource;", "cover", "", "onRecordSuccess", "", "type", "errorCode", "onRecordError", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes15.dex */
                    public static final class a implements FilamentCoverRecorder.IRecordCallback {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ Function1<Object, Unit> f253308a;

                        a(Function1<Object, Unit> function1) {
                            this.f253308a = function1;
                        }

                        @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
                        public void onRecordError(int type, @NotNull FilamentCoverRecorder.RecordRequest request, int errorCode) {
                            Intrinsics.checkNotNullParameter(request, "request");
                            Function1<Object, Unit> function1 = this.f253308a;
                            if (function1 != null) {
                                function1.invoke("");
                            }
                            j.c().d("NBPPublishKuiklyModule", "recordAvatar error, type: " + type + " errCode: " + errorCode);
                        }

                        @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
                        public void onRecordSuccess(@NotNull FilamentCoverRecorder.RecordRequest request, @NotNull RecordSource cover) {
                            Intrinsics.checkNotNullParameter(request, "request");
                            Intrinsics.checkNotNullParameter(cover, "cover");
                            Function1<Object, Unit> function1 = this.f253308a;
                            if (function1 != null) {
                                function1.invoke(cover.getPath());
                            }
                            j.c().e("NBPPublishKuiklyModule", "recordAvatar succsss, path: " + cover.getPath());
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentCoverRecorder filamentCoverRecorder;
                        FilamentAvatarCoverUri filamentCoverUrl = Resource.this.getFilamentCoverUrl();
                        boolean exists = filamentCoverUrl.getLocalCacheFile().exists();
                        String cachePath = filamentCoverUrl.getCachePath();
                        if (exists) {
                            Function1<Object, Unit> function1 = callback;
                            if (function1 != null) {
                                function1.invoke(cachePath);
                                return;
                            }
                            return;
                        }
                        String valueOf = String.valueOf(ab2.a.f25767a.m());
                        DressKeys userDressKey = Resource.this.getFilament().getUserDressKey();
                        if (userDressKey != null) {
                            SquareRecordManager.INSTANCE.setGuestCacheDressKey(valueOf, userDressKey.getOwner());
                        }
                        filamentCoverRecorder = this.recorder;
                        filamentCoverRecorder.startRecord(new FilamentCoverRecorder.RecordRequest(valueOf + "_" + Resource.this.getActionId(), new UserIdentifier(valueOf, null, 2, null), null, Resource.this, cachePath, true, RecordType.FILAMENT_NEARBY), new a(callback));
                    }
                });
            } catch (Throwable th5) {
                j.c().d("NBPPublishKuiklyModule", "recordAvatar error: " + th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String w(String sourcePath) {
        boolean z16;
        String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.PATH_NEARBYPRO_TEMP) + System.currentTimeMillis() + ".jpg";
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(sourcePath);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        int exifOrientation = BaseImageUtil.getExifOrientation(sourcePath);
        if (exifOrientation != 0 && exifOrientation % 90 == 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, width, height, matrix, true);
            width = decodeFile.getHeight();
            height = decodeFile.getWidth();
            decodeFile = createBitmap;
        }
        if (width > 1600 && height > 1600) {
            if (width > height) {
                int i3 = (int) ((1600 * width) / height);
                height = 1600;
                width = i3;
            } else {
                int i16 = (int) ((1600 * height) / width);
                width = 1600;
                height = i16;
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (width > 10000 || height > 10000) {
            if (width > height) {
                height = (height * 10000) / width;
                width = 10000;
            } else {
                width = (int) ((width * 10000) / height);
                height = 10000;
            }
            z16 = true;
        }
        if (z16) {
            decodeFile = Bitmap.createScaledBitmap(decodeFile, width, height, true);
        }
        BaseImageUtil.saveBitmapFileAsJPEG(decodeFile, 50, new File(str));
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1607216887:
                if (method.equals("onPublishPageCreated")) {
                    q(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -800625956:
                if (method.equals("enterLocationPage")) {
                    m(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -295879733:
                if (method.equals("detectPhotoTag")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -197190467:
                if (method.equals("enterGalleryPreviewPage")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -127175153:
                if (method.equals("openCamera")) {
                    t(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1278160980:
                if (method.equals("notifyFeedRefresh")) {
                    p(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1328929034:
                if (method.equals("recordAvatar")) {
                    v(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1518388805:
                if (method.equals("openAlbum")) {
                    r(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(NBLayerDeleteMediaEvent.class);
        return arrayListOf;
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        j.c().e("NBPPublishKuiklyModule", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        NBPMediaSelector.f253605a.c();
        this.recorder.onDestroy();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof NBLayerDeleteMediaEvent) {
            Function1<Object, Unit> function1 = this.enterGalleryPreviewPageCallback;
            if (function1 != null) {
                function1.invoke("");
            }
            this.enterGalleryPreviewPageCallback = null;
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }
}
