package com.tencent.mobileqq.vas.adv.base.service;

import android.text.TextUtils;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0017*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00012\u00020\u0004:\u0001\u001fB\u000f\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0002J0\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH$J\b\u0010\u0013\u001a\u00020\u0012H\u0004J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0004J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0001H$\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001bH$R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/service/c;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "V", "T", "", "Ljava/lang/Runnable;", "e", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "specifiedAdsJsonList", "Ltencent/gdt/qq_ad_get$QQAdGet$PositionInfo$PositionExt$SpecifiedAdsItem;", "g", "", "j", "Lbz2/a;", "callback", "k", "Ltencent/gdt/access$AdGetReq;", "d", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "serviceCode", "", "c", "rsp", "i", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "", "errMsg", h.F, "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "vasNewAdParams", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRequestingAd", "<init>", "(Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class c<V extends MessageMicro<V>, T extends MessageMicro<T>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasNewAdParams vasNewAdParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile AtomicBoolean isRequestingAd;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f307980a;

        static {
            int[] iArr = new int[VasAdvServiceCode.values().length];
            try {
                iArr[VasAdvServiceCode.SUCCEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VasAdvServiceCode.CREATE_REQUEST_ERR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VasAdvServiceCode.CREATE_REPORT_ERR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_CMD_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_RSP_PARSE_ERR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_RSP_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_CMD_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_RSP_PARSE_ERR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_RSP_FAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f307980a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/c$c", "Lbz2/a;", "rsp", "", "a", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.base.service.c$c, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C8897c implements bz2.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c<V, T> f307981a;

        C8897c(c<V, T> cVar) {
            this.f307981a = cVar;
        }

        @Override // bz2.a
        public void a(@NotNull T rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            this.f307981a.i(rsp);
            ((c) this.f307981a).isRequestingAd.set(false);
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f307981a.h(code, errMsg);
            ((c) this.f307981a).isRequestingAd.set(false);
        }
    }

    public c(@NotNull VasNewAdParams vasNewAdParams) {
        Intrinsics.checkNotNullParameter(vasNewAdParams, "vasNewAdParams");
        this.vasNewAdParams = vasNewAdParams;
        this.isRequestingAd = new AtomicBoolean(false);
    }

    private final Runnable e() {
        return new Runnable() { // from class: com.tencent.mobileqq.vas.adv.base.service.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(c.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isRequestingAd.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("VasAdLoadBaseService", 2, "repeating request ad, discard");
                return;
            }
            return;
        }
        this$0.k(new C8897c(this$0));
    }

    private final ArrayList<qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem> g(ArrayList<JSONObject> specifiedAdsJsonList) {
        ArrayList<qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem> arrayList = new ArrayList<>();
        Iterator<JSONObject> it = specifiedAdsJsonList.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem specifiedAdsItem = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem();
            specifiedAdsItem.aid.set(next.optLong("aid", 0L));
            specifiedAdsItem.creative_id.set(next.optLong("creative_id", 0L));
            PBUInt64Field pBUInt64Field = specifiedAdsItem.version;
            String optString = next.optString("version", "0");
            Intrinsics.checkNotNullExpressionValue(optString, "adJson.optString(RES_VERSION, \"0\")");
            pBUInt64Field.set(Long.parseLong(optString));
            arrayList.add(specifiedAdsItem);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c(@NotNull VasAdvServiceCode serviceCode) {
        Intrinsics.checkNotNullParameter(serviceCode, "serviceCode");
        switch (b.f307980a[serviceCode.ordinal()]) {
            case 1:
                return 0;
            case 2:
            case 3:
                return 5;
            case 4:
                return 2;
            case 5:
            case 6:
                return 6;
            case 7:
                return 3;
            case 8:
            case 9:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final access.AdGetReq d() {
        int i3;
        int i16;
        int i17;
        ArrayList arrayListOf;
        ArrayList<JSONObject> specifiedTianShuAdsJsonList;
        access.AdGetReq adGetReq = new access.AdGetReq();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            PBEnumField pBEnumField = adGetReq.busi_type;
            Integer busiType = this.vasNewAdParams.getBusiType();
            if (busiType != null) {
                i3 = busiType.intValue();
            } else {
                i3 = 0;
            }
            pBEnumField.set(i3);
            PBStringField pBStringField = adGetReq.client_mod;
            String clientMod = this.vasNewAdParams.getClientMod();
            if (clientMod == null) {
                clientMod = GdtDeviceInfoHelper.getClientMode();
            }
            pBStringField.set(clientMod);
            PBStringField pBStringField2 = adGetReq.last_req_cookie;
            String lastRequestCookie = this.vasNewAdParams.getLastRequestCookie();
            String str = "";
            if (lastRequestCookie == null) {
                lastRequestCookie = "";
            }
            pBStringField2.set(lastRequestCookie);
            Iterator<String> it = this.vasNewAdParams.getAdvPos().iterator();
            while (it.hasNext()) {
                String next = it.next();
                qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
                positionInfo.pos_id.set(next);
                PBUInt32Field pBUInt32Field = positionInfo.ad_count;
                Integer adCount = this.vasNewAdParams.getAdCount();
                if (adCount != null) {
                    i16 = adCount.intValue();
                } else {
                    i16 = 1;
                }
                pBUInt32Field.set(i16);
                qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
                PBUInt32Field pBUInt32Field2 = positionExt.deep_link_version;
                Integer deepLinkVersion = this.vasNewAdParams.getDeepLinkVersion();
                if (deepLinkVersion != null) {
                    i17 = deepLinkVersion.intValue();
                } else {
                    i17 = 1;
                }
                pBUInt32Field2.set(i17);
                Integer busiType2 = this.vasNewAdParams.getBusiType();
                if (busiType2 != null && busiType2.intValue() == 14) {
                    positionExt.get_ad_type.set(1);
                    positionInfo.ad_count.set(10);
                }
                if (TextUtils.equals(this.vasNewAdParams.getTargetPosId(), next)) {
                    ArrayList<JSONObject> specifiedAdsJsonList = this.vasNewAdParams.getSpecifiedAdsJsonList();
                    if (specifiedAdsJsonList != null) {
                        positionExt.specified_ads.set(g(specifiedAdsJsonList));
                    }
                    positionExt.get_ad_type.set(this.vasNewAdParams.getGetAdType());
                }
                if (TextUtils.equals(this.vasNewAdParams.getTianShuPosId(), next) && (specifiedTianShuAdsJsonList = this.vasNewAdParams.getSpecifiedTianShuAdsJsonList()) != null) {
                    positionExt.specified_ads.set(g(specifiedTianShuAdsJsonList));
                }
                Integer allowedCategory = this.vasNewAdParams.getAllowedCategory();
                if (allowedCategory != null) {
                    int intValue = allowedCategory.intValue();
                    qq_ad_get.QQAdGet.PositionInfo.PositionExt.PositionContextInfo positionContextInfo = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.PositionContextInfo();
                    PBRepeatField<Integer> pBRepeatField = positionContextInfo.allowed_category;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(intValue));
                    pBRepeatField.set(arrayListOf);
                    positionExt.context_info.set(positionContextInfo);
                }
                if (this.vasNewAdParams.getDisableMaskReq()) {
                    positionExt.disable_recall_mengceng_ad.set(true);
                }
                positionInfo.pos_ext.set(positionExt);
                qQAdGet.position_info.add(positionInfo);
            }
            qq_ad_get.QQAdGet.DeviceInfo deviceInfo = this.vasNewAdParams.getDeviceInfo();
            if (deviceInfo != null) {
                qQAdGet.device_info.set(deviceInfo);
            } else {
                qq_ad_get.QQAdGet.DeviceInfo deviceInfo2 = VasAdvSupport.INSTANCE.a().getDeviceInfo();
                if (deviceInfo2 != null) {
                    qQAdGet.device_info.set(deviceInfo2);
                }
            }
            qq_ad_get.QQAdGet.ContextInfo contextInfo = new qq_ad_get.QQAdGet.ContextInfo();
            PBStringField pBStringField3 = contextInfo.str_source_from;
            String sourceFrom = this.vasNewAdParams.getSourceFrom();
            if (sourceFrom != null) {
                str = sourceFrom;
            }
            pBStringField3.set(str);
            qQAdGet.context_info.set(contextInfo);
            access.VideoFeedInfo videoFeedInfo = this.vasNewAdParams.getVideoFeedInfo();
            if (videoFeedInfo != null) {
                adGetReq.video_feed_info.set(videoFeedInfo);
            }
            adGetReq.qq_ad_get.set(qQAdGet);
            Iterator<String> it5 = this.vasNewAdParams.getBannerAdPush().iterator();
            while (it5.hasNext()) {
                adGetReq.push_ad_passthrough.add(it5.next());
            }
            List<String> extIds = this.vasNewAdParams.getExtIds();
            if (extIds != null) {
                adGetReq.exp_ids.set(extIds);
            }
            access.QzoneInfo qzoneInfo = this.vasNewAdParams.getQzoneInfo();
            if (qzoneInfo != null) {
                adGetReq.qzone_info.set(qzoneInfo);
            }
        } catch (Throwable th5) {
            QLog.e("VasAdLoadBaseService", 1, "create ad req failed " + th5 + ", busiType:" + this.vasNewAdParams.getBusiType());
        }
        return adGetReq;
    }

    protected abstract void h(@NotNull VasAdvServiceCode serviceCode, @NotNull String errMsg);

    protected abstract void i(@NotNull T rsp);

    public final void j() {
        c.a.a(VasAdvSupport.INSTANCE.a(), e(), true, false, 4, null);
    }

    protected abstract void k(@NotNull bz2.a<T> callback);
}
