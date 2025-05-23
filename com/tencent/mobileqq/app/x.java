package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonTabNtUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBottomEmojiReq;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.DelMarketEmojiTabReq;
import com.tencent.qqnt.kernel.nativeinterface.DelMarketEmojiTableResult;
import com.tencent.qqnt.kernel.nativeinterface.FetchBottomEmojiTableListReq;
import com.tencent.qqnt.kernel.nativeinterface.IDelMarketEmojiTableCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchBottomEmojiTableListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IModifyBottomEmojiTableSwitchStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMoveBottomEmojiTableCallback;
import com.tencent.qqnt.kernel.nativeinterface.MarketEmoticonInfo;
import com.tencent.qqnt.kernel.nativeinterface.ModifyBottomEmojiTableSwitchStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.MoveBottomEmojiTableReq;
import com.tencent.qqnt.kernel.nativeinterface.MoveBottomEmojiTableResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010#\u001a\u00020\u001f\u00a2\u0006\u0004\b$\u0010%J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\t2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u0017H\u0016J&\u0010\u001d\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/app/x;", "Lcom/tencent/mobileqq/app/az;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketEmoticonInfo;", "marketEmoticonInfo", "businessType", "", DomainData.DOMAIN_NAME, "timestamp", "segmentFlag", "fetchSeq", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonTabEmojiInfo;", "commonTabEmojiInfo", "", "hide", "d", "packageId", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ids", "g", "", "commonTabInfoList", "shouldReverse", "e", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/app/EmoticonHandler;", "a", "Lmqq/util/WeakReference;", "emoticonHandlerWeakReference", "emoticonHandler", "<init>", "(Lcom/tencent/mobileqq/app/EmoticonHandler;)V", "b", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class x implements az {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<EmoticonHandler> emoticonHandlerWeakReference;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/x$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.x$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public x(@NotNull EmoticonHandler emoticonHandler) {
        Intrinsics.checkNotNullParameter(emoticonHandler, "emoticonHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonHandler);
        } else {
            this.emoticonHandlerWeakReference = new WeakReference<>(emoticonHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, int i16, x this$0, int i17, String str, DelMarketEmojiTableResult delMarketEmojiTableResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("EmotionTabNTSubHandler", 1, "[delEmoticonPackage] result=", Integer.valueOf(i17), ", errMsg=", str, ", rsp=", delMarketEmojiTableResult);
        EmoticonResp emoticonResp = new EmoticonResp();
        emoticonResp.resultcode = i17;
        emoticonResp.delEpId = i3;
        String valueOf = String.valueOf(i3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IEmoticonManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026AIN\n                    )");
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) runtimeService;
        iEmoticonManagerService.removeTabEmoticonPackage(valueOf, i16);
        com.tencent.mobileqq.emoticon.b.b().g(iEmoticonManagerService.syncFindEmoticonPackageById(valueOf, i16));
        EmoticonHandler emoticonHandler = this$0.emoticonHandlerWeakReference.get();
        if (emoticonHandler != null) {
            if (i17 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            emoticonHandler.R2(i17, z16, 1, i16, emoticonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ArrayList ids, x this$0, int i3, String str, DelMarketEmojiTableResult delMarketEmojiTableResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ids, "$ids");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("EmotionTabNTSubHandler", 1, "[delEmoticonPackages] result=", Integer.valueOf(i3), ", errMsg=", str, ", rsp=", delMarketEmojiTableResult);
        EmoticonResp emoticonResp = new EmoticonResp();
        emoticonResp.ids = ids;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IEmoticonManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IE\u2026AIN\n                    )");
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) runtimeService;
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            String valueOf = String.valueOf(((Integer) it.next()).intValue());
            iEmoticonManagerService.removeTabEmoticonPackage(valueOf, 0);
            com.tencent.mobileqq.emoticon.b.b().g(iEmoticonManagerService.syncFindEmoticonPackageById(valueOf, 0));
        }
        EmoticonHandler emoticonHandler = this$0.emoticonHandlerWeakReference.get();
        if (emoticonHandler != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            emoticonHandler.R2(i3, z16, 17, 0, emoticonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(x this$0, int i3, int i16, String errMsg, MarketEmoticonInfo marketEmoticonInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.n(i16, errMsg, marketEmoticonInfo, i3);
    }

    private final void n(int result, String errMsg, MarketEmoticonInfo marketEmoticonInfo, int businessType) {
        ArrayList<CommonTabEmojiInfo> arrayList;
        int i3;
        boolean z16;
        ArrayList<CommonTabEmojiInfo> arrayList2 = null;
        if (marketEmoticonInfo != null) {
            arrayList = marketEmoticonInfo.emojiNewTabs;
        } else {
            arrayList = null;
        }
        Object[] objArr = new Object[6];
        objArr[0] = "[fetchEmoticonPackages] result=";
        objArr[1] = Integer.valueOf(result);
        objArr[2] = ", errMsg=";
        objArr[3] = errMsg;
        objArr[4] = ", emojiNewTabs size=";
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        objArr[5] = Integer.valueOf(i3);
        QLog.d("EmotionTabNTSubHandler", 1, objArr);
        EmoticonResp emoticonResp = new EmoticonResp();
        emoticonResp.resultcode = result;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            EmoticonHandler emoticonHandler = this.emoticonHandlerWeakReference.get();
            if (emoticonHandler != null) {
                emoticonHandler.R2(result, false, 2, businessType, emoticonResp);
                return;
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        StringBuilder sb5 = new StringBuilder("[fetchEmoticonPackages] list=[");
        for (CommonTabEmojiInfo commonTabEmojiInfo : arrayList) {
            EmoticonTabNtUtils emoticonTabNtUtils = EmoticonTabNtUtils.INSTANCE;
            if (emoticonTabNtUtils.isMarketFace(commonTabEmojiInfo)) {
                EmoticonPackage convertCommonEmojiInfoToEmoticonPackage = emoticonTabNtUtils.convertCommonEmojiInfoToEmoticonPackage(commonTabEmojiInfo);
                arrayList3.add(convertCommonEmojiInfoToEmoticonPackage);
                arrayList4.add(convertCommonEmojiInfoToEmoticonPackage.epId);
            } else if (commonTabEmojiInfo.bottomEmojitabType == 6 && TextUtils.isEmpty(commonTabEmojiInfo.tabName)) {
                commonTabEmojiInfo.tabName = emoticonTabNtUtils.getDefaultOfficialEmojiTabName(commonTabEmojiInfo.epId);
            }
            sb5.append("{\"name\":\"");
            sb5.append(commonTabEmojiInfo.tabName);
            sb5.append("\"");
            sb5.append(",\"type\":");
            sb5.append(commonTabEmojiInfo.bottomEmojitabType);
            sb5.append(",\"id\":");
            sb5.append(commonTabEmojiInfo.epId);
            sb5.append(",\"hide\":");
            sb5.append(commonTabEmojiInfo.isHide);
            sb5.append("},");
        }
        sb5.append("]");
        QLog.d("EmotionTabNTSubHandler", 1, sb5);
        emoticonResp.data = arrayList3;
        emoticonResp.magicData = new ArrayList();
        emoticonResp.smallEmoticonData = new ArrayList();
        emoticonResp.tabOrderList = arrayList4;
        if (marketEmoticonInfo != null) {
            arrayList2 = marketEmoticonInfo.emojiNewTabs;
        }
        emoticonResp.emojiNewTabs = arrayList2;
        EmoticonHandler emoticonHandler2 = this.emoticonHandlerWeakReference.get();
        if (emoticonHandler2 != null) {
            emoticonHandler2.R2(result, true, 2, 0, emoticonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(List commonTabInfoList, x this$0, int i3, int i16, String str, MoveBottomEmojiTableResult moveBottomEmojiTableResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(commonTabInfoList, "$commonTabInfoList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringBuilder sb5 = new StringBuilder("[");
        Iterator it = commonTabInfoList.iterator();
        while (it.hasNext()) {
            CommonTabEmojiInfo commonTabEmojiInfo = (CommonTabEmojiInfo) it.next();
            sb5.append("{\"name\":\"");
            sb5.append(commonTabEmojiInfo.tabName);
            sb5.append("\"");
            sb5.append(",\"type\":");
            sb5.append(commonTabEmojiInfo.bottomEmojitabType);
            sb5.append(",\"id\":");
            sb5.append(commonTabEmojiInfo.epId);
            sb5.append("},");
        }
        sb5.append("]");
        QLog.d("EmotionTabNTSubHandler", 1, "[reportEmoticonOrder] req=", sb5, ", result=", Integer.valueOf(i16), ", errMsg=", str, ", moveBottomEmojiTableResult=", moveBottomEmojiTableResult);
        EmoticonResp emoticonResp = new EmoticonResp();
        emoticonResp.resultcode = i16;
        EmoticonHandler emoticonHandler = this$0.emoticonHandlerWeakReference.get();
        if (emoticonHandler != null) {
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            emoticonHandler.R2(i16, z16, 16, i3, emoticonResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ModifyBottomEmojiTableSwitchStatusReq req, x this$0, int i3, int i16, String str, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("EmotionTabNTSubHandler", 1, "[modifyBottomEmojiTableSwitchStatus] req=", req, ", result=", Integer.valueOf(i16), ", errMsg=", str, ", success=", Boolean.valueOf(z16));
        EmoticonResp emoticonResp = new EmoticonResp();
        emoticonResp.resultcode = i16;
        EmoticonHandler emoticonHandler = this$0.emoticonHandlerWeakReference.get();
        if (emoticonHandler != null) {
            if (i16 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            emoticonHandler.R2(i16, z17, 4096, i3, emoticonResp);
        }
    }

    @Override // com.tencent.mobileqq.app.az
    public void c(int timestamp, int segmentFlag, final int businessType, int fetchSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(timestamp), Integer.valueOf(segmentFlag), Integer.valueOf(businessType), Integer.valueOf(fetchSeq));
            return;
        }
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("EmotionTabNTSubHandler", 1, "[fetchEmoticonPackages] error, msgService is null.");
            return;
        }
        FetchBottomEmojiTableListReq fetchBottomEmojiTableListReq = new FetchBottomEmojiTableListReq();
        CommonBottomEmojiReq commonBottomEmojiReq = fetchBottomEmojiTableListReq.commonReqInfo;
        commonBottomEmojiReq.appVersion = AppSetting.f99551k;
        commonBottomEmojiReq.businessId = businessType;
        fetchBottomEmojiTableListReq.timeStamp = timestamp;
        fetchBottomEmojiTableListReq.segmentFlag = segmentFlag;
        e16.fetchBottomEmojiTableList(fetchBottomEmojiTableListReq, new IFetchBottomEmojiTableListCallback() { // from class: com.tencent.mobileqq.app.u
            @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchBottomEmojiTableListCallback
            public final void onFetchBottomEmojiTableListCallback(int i3, String str, MarketEmoticonInfo marketEmoticonInfo) {
                x.m(x.this, businessType, i3, str, marketEmoticonInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.az
    public void d(@NotNull CommonTabEmojiInfo commonTabEmojiInfo, final int businessType, boolean hide) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, commonTabEmojiInfo, Integer.valueOf(businessType), Boolean.valueOf(hide));
            return;
        }
        Intrinsics.checkNotNullParameter(commonTabEmojiInfo, "commonTabEmojiInfo");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("EmotionTabNTSubHandler", 1, "[setEmoticonPackageStatus] error, msgService is null.");
            return;
        }
        final ModifyBottomEmojiTableSwitchStatusReq modifyBottomEmojiTableSwitchStatusReq = new ModifyBottomEmojiTableSwitchStatusReq();
        CommonBottomEmojiReq commonBottomEmojiReq = modifyBottomEmojiTableSwitchStatusReq.commonBottomEmojiReqInfo;
        commonBottomEmojiReq.businessId = businessType;
        commonBottomEmojiReq.appVersion = AppSetting.f99551k;
        commonTabEmojiInfo.isHide = hide;
        modifyBottomEmojiTableSwitchStatusReq.emojiNewTabs.add(commonTabEmojiInfo);
        e16.modifyBottomEmojiTableSwitchStatus(modifyBottomEmojiTableSwitchStatusReq, new IModifyBottomEmojiTableSwitchStatusCallback() { // from class: com.tencent.mobileqq.app.v
            @Override // com.tencent.qqnt.kernel.nativeinterface.IModifyBottomEmojiTableSwitchStatusCallback
            public final void onModifyBottomEmojiTableSwitchStatusCallback(int i3, String str, boolean z16) {
                x.p(ModifyBottomEmojiTableSwitchStatusReq.this, this, businessType, i3, str, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.az
    public void e(@NotNull final List<CommonTabEmojiInfo> commonTabInfoList, boolean shouldReverse, final int businessType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, commonTabInfoList, Boolean.valueOf(shouldReverse), Integer.valueOf(businessType));
            return;
        }
        Intrinsics.checkNotNullParameter(commonTabInfoList, "commonTabInfoList");
        if (commonTabInfoList.isEmpty()) {
            return;
        }
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("EmotionTabNTSubHandler", 1, "[reportEmoticonOrder] error, msgService is null.");
            return;
        }
        MoveBottomEmojiTableReq moveBottomEmojiTableReq = new MoveBottomEmojiTableReq();
        ArrayList arrayList = new ArrayList();
        if (shouldReverse) {
            Collections.reverse(commonTabInfoList);
        }
        for (CommonTabEmojiInfo commonTabEmojiInfo : commonTabInfoList) {
            if (EmoticonTabNtUtils.INSTANCE.isMarketFace(commonTabEmojiInfo)) {
                arrayList.add(Integer.valueOf(commonTabEmojiInfo.epId));
            }
        }
        CommonBottomEmojiReq commonBottomEmojiReq = moveBottomEmojiTableReq.commonBottomEmojiReqInfo;
        commonBottomEmojiReq.businessId = businessType;
        commonBottomEmojiReq.appVersion = AppSetting.f99551k;
        moveBottomEmojiTableReq.tabIdList.addAll(arrayList);
        moveBottomEmojiTableReq.emojiNewTabs.addAll(commonTabInfoList);
        e16.moveBottomEmojiTable(moveBottomEmojiTableReq, new IMoveBottomEmojiTableCallback() { // from class: com.tencent.mobileqq.app.w
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMoveBottomEmojiTableCallback
            public final void onMoveBottomEmojiTableCallback(int i3, String str, MoveBottomEmojiTableResult moveBottomEmojiTableResult) {
                x.o(commonTabInfoList, this, businessType, i3, str, moveBottomEmojiTableResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.az
    public void f(final int packageId, final int businessType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(packageId), Integer.valueOf(businessType));
            return;
        }
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("EmotionTabNTSubHandler", 1, "[delEmoticonPackage] error, msgService is null.");
            return;
        }
        DelMarketEmojiTabReq delMarketEmojiTabReq = new DelMarketEmojiTabReq();
        CommonBottomEmojiReq commonBottomEmojiReq = delMarketEmojiTabReq.commonBottomEmojiReqInfo;
        commonBottomEmojiReq.businessId = businessType;
        commonBottomEmojiReq.appVersion = AppSetting.f99551k;
        delMarketEmojiTabReq.tabIds.add(Integer.valueOf(packageId));
        e16.delMarketEmojiTab(delMarketEmojiTabReq, new IDelMarketEmojiTableCallback() { // from class: com.tencent.mobileqq.app.s
            @Override // com.tencent.qqnt.kernel.nativeinterface.IDelMarketEmojiTableCallback
            public final void onDelMarketEmojiTableCallback(int i3, String str, DelMarketEmojiTableResult delMarketEmojiTableResult) {
                x.k(packageId, businessType, this, i3, str, delMarketEmojiTableResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.az
    public void g(@NotNull final ArrayList<Integer> ids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ids);
            return;
        }
        Intrinsics.checkNotNullParameter(ids, "ids");
        if (ids.isEmpty()) {
            return;
        }
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("EmotionTabNTSubHandler", 1, "[delEmoticonPackages] error, msgService is null.");
            return;
        }
        DelMarketEmojiTabReq delMarketEmojiTabReq = new DelMarketEmojiTabReq();
        delMarketEmojiTabReq.tabIds.addAll(ids);
        e16.delMarketEmojiTab(delMarketEmojiTabReq, new IDelMarketEmojiTableCallback() { // from class: com.tencent.mobileqq.app.t
            @Override // com.tencent.qqnt.kernel.nativeinterface.IDelMarketEmojiTableCallback
            public final void onDelMarketEmojiTableCallback(int i3, String str, DelMarketEmojiTableResult delMarketEmojiTableResult) {
                x.l(ids, this, i3, str, delMarketEmojiTableResult);
            }
        });
    }
}
