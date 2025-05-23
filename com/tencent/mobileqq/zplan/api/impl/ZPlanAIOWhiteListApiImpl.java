package com.tencent.mobileqq.zplan.api.impl;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import wk3.ZPlanCoupleAvatarSwitchConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0002\"#B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIOWhiteListApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOWhiteListApi;", "", "hasAioAvatarFeature", "", "notifyListeners", QCircleLpReportDc05507.KEY_CLEAR, "", "data", "Ll55/b;", "parseRsp", "requestAIOWhiteList", "setAvatarFeature", "hasAvatarFeature", "", "friendUin", "currentUserNeedShowDialog", "reportExposure", "Lcom/tencent/mobileqq/zplan/api/b;", "listener", "registerAIOWhiteListListener", "unRegisterAIOWhiteListListener", "Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIOWhiteListApiImpl$b;", "whiteListData", "Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIOWhiteListApiImpl$b;", "passiveAddWhiteListUser", "Z", "", "Lmqq/util/WeakReference;", "whiteListListeners", "Ljava/util/Set;", "<init>", "()V", "Companion", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAIOWhiteListApiImpl implements IZPlanAIOWhiteListApi {
    public static final String METHOD = "trpc.zplan.aio_avatar_whitelist.WhitelistManager.SsoGetAIOAvatarWhitelistInfo";
    public static final String TAG = "ZPlanAIOWhiteListImpl";
    private boolean passiveAddWhiteListUser;
    private WhiteListData whiteListData;
    private final Set<WeakReference<com.tencent.mobileqq.zplan.api.b>> whiteListListeners = new LinkedHashSet();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIOWhiteListApiImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "e", "(Z)V", "hasAioAvatarFeature", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tabExpKey", "", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "showPopupLayerFriendUins", "tabExpId", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.api.impl.ZPlanAIOWhiteListApiImpl$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class WhiteListData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasAioAvatarFeature;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String tabExpKey;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<Long> showPopupLayerFriendUins;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String tabExpId;

        public WhiteListData() {
            this(false, null, null, null, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasAioAvatarFeature() {
            return this.hasAioAvatarFeature;
        }

        public final List<Long> b() {
            return this.showPopupLayerFriendUins;
        }

        /* renamed from: c, reason: from getter */
        public final String getTabExpId() {
            return this.tabExpId;
        }

        /* renamed from: d, reason: from getter */
        public final String getTabExpKey() {
            return this.tabExpKey;
        }

        public final void e(boolean z16) {
            this.hasAioAvatarFeature = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z16 = this.hasAioAvatarFeature;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((((r06 * 31) + this.tabExpKey.hashCode()) * 31) + this.showPopupLayerFriendUins.hashCode()) * 31) + this.tabExpId.hashCode();
        }

        public String toString() {
            return "WhiteListData(hasAioAvatarFeature=" + this.hasAioAvatarFeature + ", tabExpKey=" + this.tabExpKey + ", showPopupLayerFriendUins=" + this.showPopupLayerFriendUins + ", tabExpId=" + this.tabExpId + ")";
        }

        public WhiteListData(boolean z16, String tabExpKey, List<Long> showPopupLayerFriendUins, String tabExpId) {
            Intrinsics.checkNotNullParameter(tabExpKey, "tabExpKey");
            Intrinsics.checkNotNullParameter(showPopupLayerFriendUins, "showPopupLayerFriendUins");
            Intrinsics.checkNotNullParameter(tabExpId, "tabExpId");
            this.hasAioAvatarFeature = z16;
            this.tabExpKey = tabExpKey;
            this.showPopupLayerFriendUins = showPopupLayerFriendUins;
            this.tabExpId = tabExpId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WhiteListData)) {
                return false;
            }
            WhiteListData whiteListData = (WhiteListData) other;
            return this.hasAioAvatarFeature == whiteListData.hasAioAvatarFeature && Intrinsics.areEqual(this.tabExpKey, whiteListData.tabExpKey) && Intrinsics.areEqual(this.showPopupLayerFriendUins, whiteListData.showPopupLayerFriendUins) && Intrinsics.areEqual(this.tabExpId, whiteListData.tabExpId);
        }

        public /* synthetic */ WhiteListData(boolean z16, String str, List list, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? "" : str2);
        }
    }

    private final synchronized void notifyListeners(boolean hasAioAvatarFeature) {
        Set set;
        set = CollectionsKt___CollectionsKt.toSet(this.whiteListListeners);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.zplan.api.b bVar = (com.tencent.mobileqq.zplan.api.b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onResult(hasAioAvatarFeature);
            }
        }
    }

    private final l55.b parseRsp(Object data) {
        byte[] bArr = data instanceof byte[] ? (byte[]) data : null;
        if (bArr == null) {
            return null;
        }
        try {
            return l55.b.c(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "getAIOWhiteList parse failed.", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAIOWhiteList$lambda$1(ZPlanAIOWhiteListApiImpl this$0, int i3, boolean z16, Object obj) {
        List arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            QLog.i(TAG, 1, "requestAIOWhiteList request failed");
            return;
        }
        l55.b parseRsp = this$0.parseRsp(obj);
        if (parseRsp == null) {
            return;
        }
        boolean z17 = parseRsp.f413870a;
        String str = parseRsp.f413871b;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.tabExpKey");
        long[] jArr = parseRsp.f413872c;
        if (jArr != null) {
            Intrinsics.checkNotNullExpressionValue(jArr, "rsp.showPopupLayerFriendUins");
            arrayList = ArraysKt___ArraysJvmKt.asList(jArr);
        } else {
            arrayList = new ArrayList();
        }
        String str2 = parseRsp.f413873d;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.tabExpId");
        this$0.whiteListData = new WhiteListData(z17, str, arrayList, str2);
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            ZPlanAIOWhiteListCache.f331339a.f(this$0.whiteListData, d16.getLongAccountUin());
        }
        WhiteListData whiteListData = this$0.whiteListData;
        boolean z18 = false;
        if (whiteListData != null && whiteListData.getHasAioAvatarFeature()) {
            z18 = true;
        }
        this$0.notifyListeners(z18);
        QLog.d(TAG, 1, "requestAIOWhiteList rsp success: " + this$0.whiteListData);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi
    public boolean currentUserNeedShowDialog(long friendUin) {
        List<Long> b16;
        WhiteListData whiteListData = this.whiteListData;
        if (whiteListData == null || (b16 = whiteListData.b()) == null) {
            return false;
        }
        return b16.contains(Long.valueOf(friendUin));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi
    public boolean hasAvatarFeature() {
        AccessibleDetail zplanAccessibleDetailFromCacheOnly;
        ZPlanCoupleAvatarSwitchConfig coupleAvatarSwitchConfig = ZPlanQQMC.INSTANCE.getCoupleAvatarSwitchConfig();
        if (!coupleAvatarSwitchConfig.getEnable()) {
            QLog.i(TAG, 1, "hasAvatarFeature coupleAvatarSwitchConfig false.");
            return false;
        }
        AppRuntime d16 = bb.f335811a.d();
        Long valueOf = d16 != null ? Long.valueOf(d16.getLongAccountUin()) : null;
        if (valueOf != null && ((zplanAccessibleDetailFromCacheOnly = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetailFromCacheOnly(coupleAvatarSwitchConfig.getAccessibleSceneAppId(), valueOf.longValue())) == null || !zplanAccessibleDetailFromCacheOnly.isDevicePass())) {
            QLog.i(TAG, 1, "hasAvatarFeature accessibleDetail device pass failed. " + zplanAccessibleDetailFromCacheOnly);
            return false;
        }
        if (valueOf != null) {
            long longValue = valueOf.longValue();
            ZPlanAIOWhiteListCache zPlanAIOWhiteListCache = ZPlanAIOWhiteListCache.f331339a;
            if (!zPlanAIOWhiteListCache.e(longValue)) {
                this.whiteListData = zPlanAIOWhiteListCache.c(longValue);
            }
        }
        WhiteListData whiteListData = this.whiteListData;
        boolean hasAioAvatarFeature = whiteListData != null ? whiteListData.getHasAioAvatarFeature() : false;
        if (!hasAioAvatarFeature) {
            hasAioAvatarFeature = this.passiveAddWhiteListUser;
        }
        QLog.i(TAG, 1, "hasAvatarFeature " + hasAioAvatarFeature);
        return hasAioAvatarFeature;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi
    public synchronized void registerAIOWhiteListListener(com.tencent.mobileqq.zplan.api.b listener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<WeakReference<com.tencent.mobileqq.zplan.api.b>> it = this.whiteListListeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            } else if (Intrinsics.areEqual(it.next().get(), listener)) {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            this.whiteListListeners.add(new WeakReference<>(listener));
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi
    public void reportExposure() {
        String str;
        String tabExpId;
        WhiteListData whiteListData = this.whiteListData;
        String str2 = "";
        if (whiteListData == null || (str = whiteListData.getTabExpKey()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            return;
        }
        WhiteListData whiteListData2 = this.whiteListData;
        if (whiteListData2 != null && (tabExpId = whiteListData2.getTabExpId()) != null) {
            str2 = tabExpId;
        }
        if (str2.length() == 0) {
            return;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str2);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(tabExpId)");
        expEntity.reportExpExposure();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi
    public void requestAIOWhiteList() {
        byte[] byteArray;
        QLog.d(TAG, 1, "requestAIOWhiteList starting");
        try {
            clear();
            ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
            if (a16 == null || (byteArray = MessageNano.toByteArray(new l55.a())) == null) {
                return;
            }
            a16.request(METHOD, byteArray, new BusinessObserver() { // from class: com.tencent.mobileqq.zplan.api.impl.a
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    ZPlanAIOWhiteListApiImpl.requestAIOWhiteList$lambda$1(ZPlanAIOWhiteListApiImpl.this, i3, z16, obj);
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "requestAIOWhiteList failed.", e16);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi
    public void setAvatarFeature() {
        WhiteListData whiteListData = this.whiteListData;
        if (whiteListData != null) {
            whiteListData.e(true);
        }
        this.passiveAddWhiteListUser = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        r0.remove();
     */
    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void unRegisterAIOWhiteListListener(com.tencent.mobileqq.zplan.api.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<WeakReference<com.tencent.mobileqq.zplan.api.b>> it = this.whiteListListeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (Intrinsics.areEqual(it.next().get(), listener)) {
                break;
            }
        }
    }

    private final void clear() {
        this.passiveAddWhiteListUser = false;
    }
}
