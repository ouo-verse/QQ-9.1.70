package com.tencent.mobileqq.troop.troopaiobanner;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.ContactThirdPartyBusinessInfos;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.ThirdPartyBusinessInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$Priority;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$TodoBanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00162\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R0\u0010&\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00150#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R*\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R8\u00101\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00150'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerModel;", "", "", "bizType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "respDisappear", "r", "Lcom/tencent/trpcprotocol/iqun/group_top_banner_notify/group_top_banner_notify/GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;", "bannerInfo", "", "o", "", "msgId", "i", "Lcom/tencent/mobileqq/troop/troopaiobanner/a;", "msgItem", "p", "troopUin", "bizId", tl.h.F, "Lkotlin/Pair;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isStudyMode", "l", "j", "a", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "", "b", "Ljava/util/Map;", "msgCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "bannerInfoCacheMap", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "g", "()Landroidx/lifecycle/MutableLiveData;", "setNewMsgState", "(Landroidx/lifecycle/MutableLiveData;)V", "newMsgState", "e", "setBannerInfoState", "bannerInfoState", "<init>", "(Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAIONotifyBannerModel {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, String> msgCacheMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<Integer, Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>> bannerInfoCacheMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<a> newMsgState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>> bannerInfoState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopAIONotifyBannerModel(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
            return;
        }
        this.troopUin = troopUin;
        this.msgCacheMap = new LinkedHashMap();
        this.bannerInfoCacheMap = new ConcurrentHashMap<>();
        this.newMsgState = new MutableLiveData<>();
        this.bannerInfoState = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        QLog.i("TroopAIONotifyBannerModel", 1, "[notifyNTBizInfoIfNeeded] biz PLAY_TOGETHER. result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(TroopAIONotifyBannerModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Collection<Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>> values = this$0.bannerInfoCacheMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "bannerInfoCacheMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            this$0.bannerInfoState.setValue((Pair) it.next());
        }
    }

    private final boolean q(int bizType) {
        boolean z16;
        GroupTopBannerNotifyPB$QueryTopBannerInfoRsp first;
        PBBoolField pBBoolField;
        Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> pair = this.bannerInfoCacheMap.get(Integer.valueOf(bizType));
        if (pair != null && (first = pair.getFirst()) != null && (pBBoolField = first.is_disappear) != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = true;
        }
        return r(bizType, z16);
    }

    private final boolean r(int bizType, boolean respDisappear) {
        boolean z16 = false;
        if (bizType != 2) {
            return false;
        }
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isStudyMode()) {
            QLog.i("TroopAIONotifyBannerModel", 1, "[underPlayTogetherState] studyMode");
            return false;
        }
        if (respDisappear) {
            QLog.i("TroopAIONotifyBannerModel", 1, "[underPlayTogetherState] respDisappear is true");
            return false;
        }
        IRuntimeService runtimeService = TroopUtils.f().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026va, ProcessConstant.MAIN)");
        TroopInfo troopInfo = ((ITroopInfoService) runtimeService).getTroopInfo(this.troopUin);
        if (troopInfo != null) {
            z16 = troopInfo.shouldShowPlayTogetherStatus();
        }
        QLog.i("TroopAIONotifyBannerModel", 1, "[underPlayTogetherState] switchOn:" + z16);
        return z16;
    }

    @NotNull
    public final MutableLiveData<Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bannerInfoState;
    }

    @Nullable
    public final Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> f(@NotNull GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        int i3;
        GroupTopBannerNotifyPB$Priority groupTopBannerNotifyPB$Priority;
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Pair) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bannerInfo);
        }
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Object obj = null;
        if (!bannerInfo.banner_priority.has() || !bannerInfo.banner_priority.category_type.has() || bannerInfo.banner_priority.category_type.get() == 0) {
            return null;
        }
        int i16 = bannerInfo.biz_type.get();
        int i17 = bannerInfo.banner_priority.category_type.get();
        Set<Map.Entry<Integer, Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>>> entrySet = this.bannerInfoCacheMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "bannerInfoCacheMap.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (i16 != ((GroupTopBannerNotifyPB$QueryTopBannerInfoRsp) ((Pair) entry.getValue()).getFirst()).biz_type.get()) {
                GroupTopBannerNotifyPB$Priority groupTopBannerNotifyPB$Priority2 = ((GroupTopBannerNotifyPB$QueryTopBannerInfoRsp) ((Pair) entry.getValue()).getFirst()).banner_priority;
                boolean z16 = false;
                if (groupTopBannerNotifyPB$Priority2 != null && (pBUInt32Field2 = groupTopBannerNotifyPB$Priority2.category_type) != null && pBUInt32Field2.get() == i17) {
                    z16 = true;
                }
                if (z16) {
                    if (obj != null) {
                        int i18 = ((GroupTopBannerNotifyPB$QueryTopBannerInfoRsp) ((Pair) entry.getValue()).getFirst()).banner_priority.priority.get();
                        GroupTopBannerNotifyPB$QueryTopBannerInfoRsp groupTopBannerNotifyPB$QueryTopBannerInfoRsp = (GroupTopBannerNotifyPB$QueryTopBannerInfoRsp) ((Pair) obj).getFirst();
                        if (groupTopBannerNotifyPB$QueryTopBannerInfoRsp != null && (groupTopBannerNotifyPB$Priority = groupTopBannerNotifyPB$QueryTopBannerInfoRsp.banner_priority) != null && (pBUInt32Field = groupTopBannerNotifyPB$Priority.priority) != null) {
                            i3 = pBUInt32Field.get();
                        } else {
                            i3 = Integer.MAX_VALUE;
                        }
                        if (i18 > i3) {
                        }
                    }
                    obj = entry.getValue();
                }
            }
        }
        return (Pair) obj;
    }

    @NotNull
    public final MutableLiveData<a> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.newMsgState;
    }

    public final void h(@NotNull String troopUin, @NotNull String bizId) {
        String second;
        Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> value;
        GroupTopBannerNotifyPB$QueryTopBannerInfoRsp first;
        String str;
        PBStringField pBStringField;
        PBBoolField pBBoolField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopUin, (Object) bizId);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> value2 = this.bannerInfoState.getValue();
        if (value2 != null && (second = value2.getSecond()) != null && (value = this.bannerInfoState.getValue()) != null && (first = value.getFirst()) != null) {
            GroupTopBannerNotifyPB$TodoBanner groupTopBannerNotifyPB$TodoBanner = first.to_do_banner;
            boolean z16 = false;
            if (groupTopBannerNotifyPB$TodoBanner != null && (pBBoolField = groupTopBannerNotifyPB$TodoBanner.is_exposure) != null && pBBoolField.get()) {
                z16 = true;
            }
            if (z16) {
                return;
            }
            GroupTopBannerNotifyPB$TodoBanner groupTopBannerNotifyPB$TodoBanner2 = first.to_do_banner;
            if (groupTopBannerNotifyPB$TodoBanner2 != null && (pBStringField = groupTopBannerNotifyPB$TodoBanner2.url) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str != null && ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isHWUrlAndEquals(str, troopUin, bizId)) {
                QLog.i("TroopAIONotifyBannerModel", 1, "[handlerHWBizOpened]");
                p(new a(first.biz_type.get(), second));
            }
        }
    }

    public final void i(int bizType, @NotNull String msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, bizType, (Object) msgId);
            return;
        }
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        this.bannerInfoCacheMap.remove(Integer.valueOf(bizType));
        this.msgCacheMap.put(Integer.valueOf(bizType), msgId);
        a aVar = new a(bizType, msgId);
        this.newMsgState.postValue(aVar);
        if (bizType == 2) {
            p(aVar);
        }
    }

    public final void j(int bizType) {
        ArrayList arrayListOf;
        ArrayList<ContactThirdPartyBusinessInfos> arrayListOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, bizType);
            return;
        }
        if (bizType == 2) {
            String str = "";
            Contact contact = new Contact(2, this.troopUin, "");
            boolean q16 = q(bizType);
            if (q16) {
                str = this.troopUin;
            } else if (q16) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ThirdPartyBusinessInfo(LiteBusinessType.KTEAMOFKINGS, str, false));
            ContactThirdPartyBusinessInfos contactThirdPartyBusinessInfos = new ContactThirdPartyBusinessInfos(contact, arrayListOf);
            aa recentContactService = ((IKernelService) TroopUtils.f().getRuntimeService(IKernelService.class, "all")).getRecentContactService();
            if (recentContactService != null) {
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(contactThirdPartyBusinessInfos);
                recentContactService.setThirdPartyBusinessInfos(arrayListOf2, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.troopaiobanner.e
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str2) {
                        TroopAIONotifyBannerModel.k(i3, str2);
                    }
                });
            }
        }
    }

    public final void l(boolean isStudyMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isStudyMode);
            return;
        }
        m();
        if (this.msgCacheMap.containsKey(2)) {
            j(2);
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopaiobanner.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopAIONotifyBannerModel.n(TroopAIONotifyBannerModel.this);
            }
        });
        Iterator<T> it = this.msgCacheMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            p(new a(((Number) entry.getKey()).intValue(), (String) entry.getValue()));
        }
    }

    public final void o(@NotNull GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        boolean z16;
        GroupTopBannerNotifyPB$QueryTopBannerInfoRsp first;
        PBUInt32Field pBUInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bannerInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        int i3 = bannerInfo.biz_type.get();
        this.bannerInfoCacheMap.remove(Integer.valueOf(i3));
        this.msgCacheMap.remove(Integer.valueOf(i3));
        Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> value = this.bannerInfoState.getValue();
        boolean z17 = true;
        if (value != null && (first = value.getFirst()) != null && (pBUInt32Field = first.biz_type) != null && i3 == pBUInt32Field.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.bannerInfoState.postValue(null);
        }
        a value2 = this.newMsgState.getValue();
        if (value2 == null || i3 != value2.a()) {
            z17 = false;
        }
        if (z17) {
            this.newMsgState.postValue(null);
        }
    }

    public final void p(@NotNull final a msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgItem);
        } else {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            g.f299293a.c(this.troopUin, msgItem.a(), msgItem.b(), new Function2<Boolean, GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, Unit>(this) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerModel$requestBannerDetail$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ TroopAIONotifyBannerModel this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, GroupTopBannerNotifyPB$QueryTopBannerInfoRsp groupTopBannerNotifyPB$QueryTopBannerInfoRsp) {
                    invoke(bool.booleanValue(), groupTopBannerNotifyPB$QueryTopBannerInfoRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @Nullable GroupTopBannerNotifyPB$QueryTopBannerInfoRsp groupTopBannerNotifyPB$QueryTopBannerInfoRsp) {
                    ConcurrentHashMap concurrentHashMap;
                    Map map;
                    ConcurrentHashMap concurrentHashMap2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), groupTopBannerNotifyPB$QueryTopBannerInfoRsp);
                        return;
                    }
                    QLog.i("TroopAIONotifyBannerModel", 1, "[requestBannerDetail] msgId = " + a.this.b() + ", isSuccess = " + z16 + ", bannerInfo = " + f.a(groupTopBannerNotifyPB$QueryTopBannerInfoRsp));
                    if (!z16 || groupTopBannerNotifyPB$QueryTopBannerInfoRsp == null) {
                        return;
                    }
                    Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> pair = new Pair<>(groupTopBannerNotifyPB$QueryTopBannerInfoRsp, a.this.b());
                    if (groupTopBannerNotifyPB$QueryTopBannerInfoRsp.is_disappear.get()) {
                        concurrentHashMap2 = this.this$0.bannerInfoCacheMap;
                        concurrentHashMap2.remove(Integer.valueOf(a.this.a()));
                    } else {
                        concurrentHashMap = this.this$0.bannerInfoCacheMap;
                        concurrentHashMap.put(Integer.valueOf(a.this.a()), pair);
                    }
                    map = this.this$0.msgCacheMap;
                    map.remove(Integer.valueOf(a.this.a()));
                    this.this$0.e().postValue(pair);
                    this.this$0.j(a.this.a());
                }
            });
        }
    }
}
