package com.qwallet.home;

import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.proxy.DownloadProxy;
import cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo;
import cooperation.vip.pb.TianShuAccess;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002-.B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019J\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\u0010\u0010 \u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0014J\n\u0010%\u001a\u0004\u0018\u00010$H\u0014R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/qwallet/home/NativePopViewModel;", "Lcom/qwallet/home/c;", "Landroidx/lifecycle/LifecycleObserver;", "", "i2", "", "endOfAction", SemanticAttributes.DbSystemValues.H2, "", "e2", "", "adId", "d2", "j2", "Lcom/qwallet/home/NativePopViewModel$b;", "popInfo", "T1", "Lcooperation/qwallet/plugin/ipc/QWalletRedTouchInfo;", "redPointInfo", "b2", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "U1", "Landroidx/lifecycle/LiveData;", "W1", "g2", "f2", "reportClose", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "M1", "c2", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "N1", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "L1", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "mPopLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class NativePopViewModel extends c implements LifecycleObserver {

    @NotNull
    private static final PopInfo D = new PopInfo(0, "", "", "", 0, null, 0);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<PopInfo> mPopLiveData = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u000f\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0018\u0010\r\u00a8\u0006\""}, d2 = {"Lcom/qwallet/home/NativePopViewModel$b;", "", "", "i", tl.h.F, "", "toString", "", "hashCode", "other", "equals", "a", "I", "()I", "adId", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "imageUrl", "d", WadlProxyConsts.KEY_JUMP_URL, "g", "title", "e", "f", "showSeconds", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "()Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "popType", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcooperation/vip/pb/TianShuAccess$AdItem;I)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qwallet.home.NativePopViewModel$b, reason: from toString */
    /* loaded from: classes3.dex */
    public static final /* data */ class PopInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int adId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String imageUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String jumpUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int showSeconds;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final TianShuAccess.AdItem adItem;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int popType;

        public PopInfo(int i3, @NotNull String imageUrl, @NotNull String jumpUrl, @NotNull String title, int i16, @Nullable TianShuAccess.AdItem adItem, int i17) {
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            this.adId = i3;
            this.imageUrl = imageUrl;
            this.jumpUrl = jumpUrl;
            this.title = title;
            this.showSeconds = i16;
            this.adItem = adItem;
            this.popType = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getAdId() {
            return this.adId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final TianShuAccess.AdItem getAdItem() {
            return this.adItem;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        /* renamed from: e, reason: from getter */
        public final int getPopType() {
            return this.popType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PopInfo)) {
                return false;
            }
            PopInfo popInfo = (PopInfo) other;
            if (this.adId == popInfo.adId && Intrinsics.areEqual(this.imageUrl, popInfo.imageUrl) && Intrinsics.areEqual(this.jumpUrl, popInfo.jumpUrl) && Intrinsics.areEqual(this.title, popInfo.title) && this.showSeconds == popInfo.showSeconds && Intrinsics.areEqual(this.adItem, popInfo.adItem) && this.popType == popInfo.popType) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getShowSeconds() {
            return this.showSeconds;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final boolean h() {
            int i3 = this.popType;
            if (i3 == 1 || i3 == 3) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((((this.adId * 31) + this.imageUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.showSeconds) * 31;
            TianShuAccess.AdItem adItem = this.adItem;
            if (adItem == null) {
                hashCode = 0;
            } else {
                hashCode = adItem.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + this.popType;
        }

        public final boolean i() {
            if (this.popType == 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "PopInfo(adId=" + this.adId + ", imageUrl=" + this.imageUrl + ", jumpUrl=" + this.jumpUrl + ", title=" + this.title + ", showSeconds=" + this.showSeconds + ", adItem=" + this.adItem + ", popType=" + this.popType + ")";
        }
    }

    private final boolean T1(PopInfo popInfo) {
        boolean z16;
        boolean z17;
        if (popInfo.getImageUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (popInfo.getJumpUrl().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    private final void U1(final PopInfo popInfo) {
        DownloadProxy.getResPath(popInfo.getImageUrl(), new ResultReceiver() { // from class: com.qwallet.home.NativePopViewModel$downloadAndPost$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                if (resultCode != 0) {
                    QLog.i("NativePopViewModel", 1, "DownloadProxy error");
                    return;
                }
                QLog.i("NativePopViewModel", 1, "filePath = " + resultData.getString(DownloadProxy.KEY_FILE_PATH, ""));
                mutableLiveData = NativePopViewModel.this.mPopLiveData;
                mutableLiveData.postValue(popInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(NativePopViewModel this$0, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            QLog.i("NativePopViewModel", 1, "getTianShuCallback: result = false");
            this$0.mPopLiveData.postValue(D);
        } else if (this$0.Z1(getAdsRsp)) {
            QLog.i("NativePopViewModel", 1, "getTianShuCallback: handleAdPop success");
        } else if (this$0.a2(getAdsRsp)) {
            QLog.i("NativePopViewModel", 1, "getTianShuCallback: handleBottomPop success");
        } else {
            QLog.i("NativePopViewModel", 1, "getTianShuCallback: not handle");
            this$0.mPopLiveData.postValue(D);
        }
    }

    private final boolean Z1(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.AdItem> list;
        List<TianShuAccess.MapEntry> list2;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Integer showSeconds;
        boolean z16;
        String str;
        String str2;
        String str3;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        PBRepeatMessageField<TianShuAccess.RspEntry> pBRepeatMessageField2;
        List<TianShuAccess.RspEntry> list3;
        boolean z17;
        PBUInt32Field pBUInt32Field;
        if (getAdsRsp != null && (pBRepeatMessageField2 = getAdsRsp.mapAds) != null && (list3 = pBRepeatMessageField2.get()) != null) {
            for (TianShuAccess.RspEntry rspEntry : list3) {
                if (rspEntry != null && (pBUInt32Field = rspEntry.key) != null && 895 == pBUInt32Field.get()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        rspEntry = null;
        if (rspEntry == null) {
            QLog.i("NativePopViewModel", 1, "handleAdPop: rspEntry is null");
            return false;
        }
        TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value;
        if (adPlacementInfo != null && (pBRepeatMessageField = adPlacementInfo.lst) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        if (list == null) {
            QLog.i("NativePopViewModel", 1, "handleAdPop: itemList is null");
            return false;
        }
        if (e2()) {
            QLog.i("NativePopViewModel", 1, "handleAdPop: isExposureToday");
            return false;
        }
        QLog.i("NativePopViewModel", 1, "handleAdPop: itemList size is " + list.size());
        for (TianShuAccess.AdItem adItem : list) {
            if (!d2(adItem.iAdId.get())) {
                PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField3 = adItem.argList;
                if (pBRepeatMessageField3 != null) {
                    list2 = pBRepeatMessageField3.get();
                } else {
                    list2 = null;
                }
                if (list2 == null) {
                    return false;
                }
                Intrinsics.checkNotNullExpressionValue(list2, "adItem.argList?.get() ?: return false");
                List<TianShuAccess.MapEntry> list4 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (TianShuAccess.MapEntry mapEntry : list4) {
                    if (mapEntry != null && (pBStringField2 = mapEntry.key) != null) {
                        str2 = pBStringField2.get();
                    } else {
                        str2 = null;
                    }
                    if (mapEntry != null && (pBStringField = mapEntry.value) != null) {
                        str3 = pBStringField.get();
                    } else {
                        str3 = null;
                    }
                    linkedHashMap.put(str2, str3);
                }
                try {
                    String str4 = (String) linkedHashMap.get("showSeconds");
                    if (str4 == null) {
                        str4 = "0";
                    }
                    showSeconds = Integer.valueOf(str4);
                } catch (NumberFormatException unused) {
                    showSeconds = 0;
                }
                int i3 = adItem.iAdId.get();
                String str5 = adItem.title.get();
                if (str5.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    str5 = adItem.desc.get();
                }
                String str6 = (String) linkedHashMap.get("image");
                String str7 = "";
                if (str6 == null) {
                    str6 = "";
                }
                String str8 = (String) linkedHashMap.get(WadlProxyConsts.KEY_JUMP_URL);
                if (str8 == null) {
                    str = "";
                } else {
                    str = str8;
                }
                if (str5 != null) {
                    Intrinsics.checkNotNullExpressionValue(str5, "title ?: \"\"");
                    str7 = str5;
                }
                Intrinsics.checkNotNullExpressionValue(showSeconds, "showSeconds");
                PopInfo popInfo = new PopInfo(i3, str6, str, str7, showSeconds.intValue(), adItem, 2);
                if (T1(popInfo)) {
                    U1(popInfo);
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean a2(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.AdItem> list;
        List<TianShuAccess.MapEntry> list2;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        PBRepeatMessageField<TianShuAccess.RspEntry> pBRepeatMessageField2;
        List<TianShuAccess.RspEntry> list3;
        boolean z16;
        PBUInt32Field pBUInt32Field;
        if (getAdsRsp != null && (pBRepeatMessageField2 = getAdsRsp.mapAds) != null && (list3 = pBRepeatMessageField2.get()) != null) {
            for (TianShuAccess.RspEntry rspEntry : list3) {
                if (rspEntry != null && (pBUInt32Field = rspEntry.key) != null && 1303 == pBUInt32Field.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        rspEntry = null;
        if (rspEntry == null) {
            QLog.i("NativePopViewModel", 1, "handleBottomPop: rspEntry is null");
            return false;
        }
        TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value;
        if (adPlacementInfo != null && (pBRepeatMessageField = adPlacementInfo.lst) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        if (list == null) {
            QLog.i("NativePopViewModel", 1, "handleBottomPop: itemList is null");
            return false;
        }
        QLog.i("NativePopViewModel", 1, "handleBottomPop: itemList size is " + list.size());
        for (TianShuAccess.AdItem adItem : list) {
            PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField3 = adItem.argList;
            if (pBRepeatMessageField3 != null) {
                list2 = pBRepeatMessageField3.get();
            } else {
                list2 = null;
            }
            if (list2 == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(list2, "adItem.argList?.get() ?: return false");
            List<TianShuAccess.MapEntry> list4 = list2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (TianShuAccess.MapEntry mapEntry : list4) {
                if (mapEntry != null && (pBStringField2 = mapEntry.key) != null) {
                    str4 = pBStringField2.get();
                } else {
                    str4 = null;
                }
                if (mapEntry != null && (pBStringField = mapEntry.value) != null) {
                    str5 = pBStringField.get();
                } else {
                    str5 = null;
                }
                linkedHashMap.put(str4, str5);
            }
            int i3 = adItem.iAdId.get();
            String str6 = (String) linkedHashMap.get("half_popup_image");
            if (str6 == null) {
                str = "";
            } else {
                str = str6;
            }
            String str7 = (String) linkedHashMap.get("half_popup_url");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            String str8 = (String) linkedHashMap.get("half_popup_title");
            if (str8 == null) {
                str3 = "";
            } else {
                str3 = str8;
            }
            PopInfo popInfo = new PopInfo(i3, str, str2, str3, 0, adItem, 3);
            if (T1(popInfo)) {
                U1(popInfo);
                return true;
            }
        }
        return false;
    }

    private final boolean b2(QWalletRedTouchInfo redPointInfo) {
        if (redPointInfo == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(redPointInfo.buffer);
            QLog.i("NativePopViewModel", 1, "handleBottomRedPointPop, extraData=" + jSONObject);
            String imageUrl = jSONObject.optString("half_popup_image");
            String jumpUrl = jSONObject.optString("half_popup_url");
            String title = jSONObject.optString("half_popup_title");
            int i3 = redPointInfo.adId;
            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            PopInfo popInfo = new PopInfo(i3, imageUrl, jumpUrl, title, 0, null, 1);
            if (!T1(popInfo)) {
                return false;
            }
            U1(popInfo);
            return true;
        } catch (JSONException e16) {
            QLog.e("NativePopViewModel", 1, e16, new Object[0]);
            return false;
        }
    }

    private final boolean d2(int adId) {
        if (j2()) {
            return false;
        }
        return com.tencent.mobileqq.qwallet.utils.g.c("key_exposure_adid_" + adId, false);
    }

    private final boolean e2() {
        if (j2()) {
            return false;
        }
        if (NetConnInfoCenter.getServerTime() - com.tencent.mobileqq.qwallet.utils.g.f279262a.g("key_exposure_time_seconds") >= 86400) {
            return false;
        }
        return true;
    }

    private final void h2(String endOfAction) {
        Integer num;
        boolean z16;
        String str;
        String str2;
        String valueOf;
        String title;
        PopInfo value = this.mPopLiveData.getValue();
        Integer num2 = null;
        if (value != null) {
            num = Integer.valueOf(value.getPopType());
        } else {
            num = null;
        }
        boolean z17 = false;
        if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "index.half_popup." + endOfAction;
        } else {
            str = "index.popup." + endOfAction;
        }
        String str3 = "";
        if (num != null && num.intValue() == 1) {
            str2 = "1";
        } else if (num == null || num.intValue() != 3) {
            str2 = "";
        } else {
            str2 = "2";
        }
        if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) {
            z17 = true;
        }
        if (z17) {
            if (value != null) {
                num2 = Integer.valueOf(value.getAdId());
            }
            valueOf = String.valueOf(num2);
        } else {
            valueOf = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
        }
        if (value != null && (title = value.getTitle()) != null) {
            str3 = title;
        }
        P1(str, str2, valueOf, str3);
    }

    private final void i2() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            if (QLog.isColorLevel()) {
                QLog.i("NativePopViewModel", 1, "is exposure today or is study mode");
            }
            this.mPopLiveData.postValue(D);
            return;
        }
        Q1();
    }

    private final boolean j2() {
        return false;
    }

    @Override // com.qwallet.home.c
    @Nullable
    protected TianShuAccess.AdItem L1() {
        PopInfo value = this.mPopLiveData.getValue();
        if (value != null) {
            return value.getAdItem();
        }
        return null;
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected TianShuGetAdvCallback M1() {
        return new TianShuGetAdvCallback() { // from class: com.qwallet.home.i
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                NativePopViewModel.X1(NativePopViewModel.this, z16, getAdsRsp);
            }
        };
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected List<TianShuAdPosItemData> N1() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 895;
        tianShuAdPosItemData.mNeedCnt = 3;
        Unit unit = Unit.INSTANCE;
        TianShuAdPosItemData tianShuAdPosItemData2 = new TianShuAdPosItemData();
        tianShuAdPosItemData2.mPosId = 1303;
        tianShuAdPosItemData2.mNeedCnt = 1;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TianShuAdPosItemData[]{tianShuAdPosItemData, tianShuAdPosItemData2});
        return listOf;
    }

    @NotNull
    public final LiveData<PopInfo> W1() {
        return this.mPopLiveData;
    }

    public final boolean c2(@Nullable QWalletRedTouchInfo redPointInfo) {
        if (b2(redPointInfo)) {
            QLog.i("NativePopViewModel", 1, "getTianShuCallback: handleBottomRedPointPop success");
        } else {
            i2();
        }
        return true;
    }

    public final void f2() {
        h2("click");
        PopInfo value = this.mPopLiveData.getValue();
        boolean z16 = false;
        if (value != null && value.getPopType() == 1) {
            z16 = true;
        }
        if (!z16) {
            O1(102);
        }
    }

    public final void g2() {
        boolean z16;
        h2("show");
        PopInfo value = this.mPopLiveData.getValue();
        boolean z17 = false;
        if (value != null && value.getPopType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            O1(101);
            if (value != null && value.getPopType() == 2) {
                z17 = true;
            }
            if (z17) {
                com.tencent.mobileqq.qwallet.utils.g.l("key_exposure_adid_" + value.getAdId(), true);
                com.tencent.mobileqq.qwallet.utils.g.o("key_exposure_time_seconds", NetConnInfoCenter.getServerTime());
                return;
            }
            return;
        }
        QWalletHomePopViewModel.INSTANCE.a();
    }

    public final void reportClose() {
        h2("close");
    }
}
