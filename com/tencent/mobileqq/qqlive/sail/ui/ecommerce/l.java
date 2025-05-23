package com.tencent.mobileqq.qqlive.sail.ui.ecommerce;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qzone.util.PerfTracer;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002>?B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J&\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020!H\u0016R\u0016\u0010%\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0&j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R4\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170.2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170.8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103RH\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n050.2\u0018\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n050.8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/l;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lbj4/a;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "event", "", "N1", "Q1", "tabId", "", "mediaProductId", "X1", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "roomInfo", "R1", "S1", "Lfp4/c;", "msgInfo", "onPush", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/l$b;", "callback", "T1", "Ldj4/a;", "product", "", "displayDuration", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getRoomId", "g1", "getProgramId", "getRoomType", "e0", "", "g", "i", "J", "enterRoomTimeStamp", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "baseReportMap", BdhLogUtil.LogTag.Tag_Conn, "Z", "hasReportExit", "Landroidx/lifecycle/MutableLiveData;", "<set-?>", "D", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "productInfoLiveData", "Lkotlin/Pair;", "E", "P1", "pushMsgPair", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "<init>", "()V", "G", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class l extends com.tencent.mobileqq.qqlive.sail.base.d implements bj4.a, com.tencent.mobileqq.qqlive.sail.room.g {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasReportExit;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.d roomInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long enterRoomTimeStamp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> baseReportMap = new HashMap<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<dj4.a> productInfoLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Integer, String>> pushMsgPair = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/l$b;", "", "Ldj4/a;", "productInfo", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull dj4.a productInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/ecommerce/l$c", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/l$b;", "Ldj4/a;", "productInfo", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ yo4.b f272673b;

        c(yo4.b bVar) {
            this.f272673b = bVar;
        }

        @Override // com.tencent.mobileqq.qqlive.sail.ui.ecommerce.l.b
        public void a(@NotNull dj4.a productInfo) {
            Intrinsics.checkNotNullParameter(productInfo, "productInfo");
            l.this.X1(4, this.f272673b.f450752c, productInfo.getProductId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/ecommerce/l$d", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/l$b;", "Ldj4/a;", "productInfo", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ yo4.b f272675b;

        d(yo4.b bVar) {
            this.f272675b = bVar;
        }

        @Override // com.tencent.mobileqq.qqlive.sail.ui.ecommerce.l.b
        public void a(@NotNull dj4.a productInfo) {
            Intrinsics.checkNotNullParameter(productInfo, "productInfo");
            l.this.X1(1, this.f272675b.f450752c, productInfo.getProductId());
        }
    }

    private final void N1(int event) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.baseReportMap);
        if (event != 1) {
            if (event != 2) {
                str = "";
            } else if (!this.hasReportExit && this.enterRoomTimeStamp != 0) {
                this.hasReportExit = true;
                hashMap.put("duration", String.valueOf(System.currentTimeMillis() - this.enterRoomTimeStamp));
                str = "ds_live_goods_audience_exit";
            } else {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isColorLevel()) {
                    companion.e("Audience|QQLiveECCardViewModel", "doRealtimeReport", "hasReportExit=" + this.hasReportExit + ", enterRoomTimeStamp=" + this.enterRoomTimeStamp + ", return");
                    return;
                }
                return;
            }
        } else {
            hashMap.put("exp_time", String.valueOf(this.enterRoomTimeStamp));
            str = "ds_live_goods_audience_entry";
        }
        cj4.c.f31003a.n(str, hashMap);
    }

    private final void Q1() {
        String str;
        int i3;
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j3;
        String l3;
        String str2 = "2";
        this.baseReportMap.put("bus_id", "2");
        this.baseReportMap.put("viewer_uin", String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
        this.baseReportMap.put(AudienceReportConst.ROOM_ID, String.valueOf(getRoomId()));
        HashMap<String, String> hashMap = this.baseReportMap;
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        String str3 = "";
        if (dVar == null || (str = dVar.getProgramId()) == null) {
            str = "";
        }
        hashMap.put("program_id", str);
        com.tencent.mobileqq.qqlive.sail.model.d dVar2 = this.roomInfo;
        if (dVar2 != null) {
            i3 = dVar2.getRoomType();
        } else {
            i3 = 0;
        }
        HashMap<String, String> hashMap2 = this.baseReportMap;
        if (i3 != 0) {
            str2 = "1";
        }
        hashMap2.put("live_type", str2);
        HashMap<String, String> hashMap3 = this.baseReportMap;
        com.tencent.mobileqq.qqlive.sail.model.d dVar3 = this.roomInfo;
        if (dVar3 != null && (j3 = dVar3.j()) != null && (l3 = Long.valueOf(j3.f()).toString()) != null) {
            str3 = l3;
        }
        hashMap3.put("author_uin", str3);
    }

    public static /* synthetic */ void U1(l lVar, b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bVar = null;
        }
        lVar.T1(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(l this$0, b bVar, EIPCResult eIPCResult) {
        Map map;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!eIPCResult.isSuccess()) {
            AegisLogger.INSTANCE.e("Audience|QQLiveECCardViewModel", "queryExplainingProduct", "EIPCResult.code=" + eIPCResult.code);
            return;
        }
        Bundle bundle = eIPCResult.data;
        if (bundle != null) {
            String string = bundle.getString("VALUE_LIVE_BUBBLE_RICHTEXT", "");
            String string2 = bundle.getString("VALUE_LIVE_BUBBLE_DETAILURL", "");
            String string3 = bundle.getString("VALUE_LIVE_BUBBLE_PRODUCTID", "");
            Serializable serializable = bundle.getSerializable("VALUE_LIVE_BUBBLE_REPORTINFO");
            if (serializable instanceof Map) {
                map = (Map) serializable;
            } else {
                map = null;
            }
            dj4.a aVar = new dj4.a(string, string2, string3, map);
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|QQLiveECCardViewModel", "queryExplainingProduct", "productInfo=" + aVar);
            }
            if (aVar.e()) {
                this$0.productInfoLiveData.postValue(aVar);
                if (bVar != null) {
                    bVar.a(aVar);
                    return;
                }
                return;
            }
            companion.e("Audience|QQLiveECCardViewModel", "queryExplainingProduct", "product is invalid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(int event, int tabId, String mediaProductId) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_LIVE_USER_ID", String.valueOf(g1()));
        bundle.putLong("KEY_LIVE_ROOM_ID", getRoomId());
        bundle.putInt("KEY_LIVE_EVENT_TYPE", event);
        bundle.putInt("KEY_LIVE_TAB_ID", tabId);
        bundle.putString("KEY_LIVE_MEDIA_PRODUCT_ID", mediaProductId);
        bundle.putInt("KEY_CHANNEL", 8);
        bundle.putBoolean("KEY_LIVE_IS_MASTER", false);
        cj4.c.f31003a.c("ACTION_REQUEST_LIVE_WINDOW_UPDATE", bundle, null);
    }

    static /* synthetic */ void Z1(l lVar, int i3, int i16, String str, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        if ((i17 & 4) != 0) {
            str = null;
        }
        lVar.X1(i3, i16, str);
    }

    @Override // bj4.a
    public void A(int event, @NotNull dj4.a product, long displayDuration) {
        String str;
        Intrinsics.checkNotNullParameter(product, "product");
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.putAll(this.baseReportMap);
        hashMap.put("bus_id", 8);
        String str2 = product.d().get(ReportDataBuilder.KEY_PRODUCT_ID);
        if (str2 != null) {
            hashMap.put(ReportDataBuilder.KEY_PRODUCT_ID, str2);
        }
        String str3 = product.d().get("product_name");
        if (str3 != null) {
            hashMap.put("product_name", str3);
        }
        String str4 = product.d().get("product_type");
        if (str4 != null) {
            hashMap.put("product_type", str4);
        }
        String str5 = product.d().get("shop_id");
        if (str5 != null) {
            hashMap.put("shop_id", str5);
        }
        if (event != 1) {
            if (event != 2) {
                if (event != 3) {
                    return;
                }
                hashMap.put(PerfTracer.PARAM_CLICK_TIME, Long.valueOf(System.currentTimeMillis() - this.enterRoomTimeStamp));
                String str6 = product.d().get("product_price");
                if (str6 != null) {
                    hashMap.put("product_price", str6);
                }
                String str7 = product.d().get("saas_id");
                if (str7 != null) {
                    hashMap.put("saas_id", str7);
                }
                str = "ds_live_goods_card_clk";
            } else {
                hashMap.put("duration", Long.valueOf(displayDuration));
                str = "ds_live_goods_card_exp_duration";
            }
        } else {
            hashMap.put("exp_time", Long.valueOf(System.currentTimeMillis() - this.enterRoomTimeStamp));
            str = "ds_live_goods_card_exp";
        }
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).dataReport(str, hashMap);
    }

    @NotNull
    public final MutableLiveData<dj4.a> O1() {
        return this.productInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<Pair<Integer, String>> P1() {
        return this.pushMsgPair;
    }

    public final void R1(@Nullable com.tencent.mobileqq.qqlive.sail.model.d roomInfo) {
        this.enterRoomTimeStamp = System.currentTimeMillis();
        this.roomInfo = roomInfo;
        Q1();
        U1(this, null, 1, null);
        if (g()) {
            N1(1);
        }
        cj4.c.f31003a.k(false, getRoomId(), g());
    }

    public final void S1() {
        if (g()) {
            Z1(this, 3, 0, null, 6, null);
            N1(2);
        }
        this.productInfoLiveData.postValue(null);
        this.roomInfo = null;
        this.enterRoomTimeStamp = 0L;
        this.baseReportMap.clear();
    }

    public final void T1(@Nullable final b callback) {
        long roomId = getRoomId();
        if (roomId == 0) {
            QLog.e("Audience|QQLiveECCardViewModel", 2, "queryExplainingProduct() roomId == 0, return");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KEY_LIVE_USER_ID", String.valueOf(g1()));
        bundle.putLong("KEY_LIVE_ROOM_ID", roomId);
        bundle.putInt("KEY_CHANNEL", 8);
        cj4.c.f31003a.c("ACTION_REQUEST_LIVE_BUBBLE_INFO", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.k
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                l.W1(l.this, callback, eIPCResult);
            }
        });
    }

    @Override // bj4.a
    @NotNull
    public String e0() {
        HashMap<String, String> l3;
        String str;
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 == null || (l3 = c16.l()) == null || (str = l3.get("qz_gdt")) == null) {
            return "";
        }
        return str;
    }

    @Override // bj4.a
    public boolean g() {
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        if (dVar != null) {
            return dVar.g();
        }
        return false;
    }

    @Override // bj4.a
    public long g1() {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j3;
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        if (dVar != null && (j3 = dVar.j()) != null) {
            return j3.f();
        }
        return 0L;
    }

    @Override // bj4.a
    @NotNull
    public String getProgramId() {
        String programId;
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        if (dVar == null || (programId = dVar.getProgramId()) == null) {
            return "";
        }
        return programId;
    }

    @Override // bj4.a
    public long getRoomId() {
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        if (dVar != null) {
            return dVar.getRoomId();
        }
        return 0L;
    }

    @Override // bj4.a
    public int getRoomType() {
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        if (dVar != null) {
            return dVar.getRoomType();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        String str;
        yo4.c cVar;
        String str2;
        yo4.c cVar2;
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        yo4.b f16 = com.tencent.mobileqq.qqlive.sail.push.a.f(msgInfo);
        if (f16 != null) {
            int i3 = f16.f450750a;
            String str3 = null;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                T1(new c(f16));
                            }
                        } else {
                            T1(new d(f16));
                        }
                    } else {
                        Z1(this, 0, f16.f450752c, null, 4, null);
                    }
                } else {
                    int i16 = f16.f450752c;
                    yo4.a aVar = f16.f450751b;
                    if (aVar != null && (cVar2 = aVar.f450748c) != null) {
                        str2 = cVar2.f450755b;
                    } else {
                        str2 = null;
                    }
                    X1(2, i16, str2);
                    this.productInfoLiveData.postValue(null);
                }
            } else {
                int i17 = f16.f450752c;
                yo4.a aVar2 = f16.f450751b;
                if (aVar2 != null && (cVar = aVar2.f450748c) != null) {
                    str = cVar.f450755b;
                } else {
                    str = null;
                }
                X1(1, i17, str);
                yo4.a bubbleInfo = f16.f450751b;
                if (bubbleInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(bubbleInfo, "bubbleInfo");
                    String str4 = bubbleInfo.f450746a;
                    String str5 = bubbleInfo.f450747b;
                    yo4.c cVar3 = bubbleInfo.f450748c;
                    if (cVar3 != null) {
                        str3 = cVar3.f450755b;
                    }
                    this.productInfoLiveData.postValue(new dj4.a(str4, str5, str3, bubbleInfo.f450749d));
                }
            }
            this.pushMsgPair.postValue(new Pair<>(Integer.valueOf(f16.f450750a), f16.f450753d));
        }
    }
}
