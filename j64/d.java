package j64;

import android.os.Handler;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.BatchBotGetReq;
import com.tencent.qqnt.kernel.nativeinterface.BatchBotGetResponse;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetRobotFunctionsCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.dialog.search.SearchException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000f2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010%R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'\u00a8\u0006-"}, d2 = {"Lj64/d;", "Lj64/g;", "", "r", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchBotGetResponse;", "response", DomainData.DOMAIN_NAME, "", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatures;", "robotFeaturesList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "originRobotFeatures", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", tl.h.F, "", "g", "c", "", "d", "Lcom/tencent/robot/slash/businessapi/d;", "Lcom/tencent/robot/slash/businessapi/d;", "mSearchSessionParams", "", "e", "J", "contextStartTime", "f", "Z", "mIsFullAmountFetch", "Lj64/f;", "Lj64/f;", "mRobotConfig", "Ljava/util/ArrayList;", "mResultList", "<init>", "(Lcom/tencent/robot/slash/businessapi/d;)V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchSessionParams mSearchSessionParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long contextStartTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullAmountFetch;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mRobotConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<CommonBotFeatures> mResultList;

    public d(@NotNull SearchSessionParams mSearchSessionParams) {
        Intrinsics.checkNotNullParameter(mSearchSessionParams, "mSearchSessionParams");
        this.mSearchSessionParams = mSearchSessionParams;
        this.mRobotConfig = new f(0L, 0L, 0L, 0L, 15, null);
        this.mResultList = new ArrayList<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CommonBotFeatures m(CommonBotFeatures originRobotFeatures) {
        Long l3;
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        ArrayList<CommonBotFeatureInfo> arrayList2 = originRobotFeatures.commandInfo;
        if (arrayList2 != null) {
            for (CommonBotFeatureInfo it : arrayList2) {
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (h34.a.b(it)) {
                        z17 = true;
                        if (!z17) {
                            arrayList.add(it);
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList<CommonBotFeatureInfo> arrayList4 = originRobotFeatures.serviceInfo;
        if (arrayList4 != null) {
            for (CommonBotFeatureInfo it5 : arrayList4) {
                if (it5 != null) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    if (h34.a.b(it5)) {
                        z16 = true;
                        if (!z16) {
                            arrayList3.add(it5);
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
        }
        CommonBotInfo commonBotInfo = originRobotFeatures.botInfo;
        if (commonBotInfo != null) {
            l3 = Long.valueOf(commonBotInfo.uin);
        } else {
            l3 = null;
        }
        QLog.i("MultiRobotsSearch", 1, "filterUnAuthorizedFunctions robotId = " + l3 + " authorizedCommands size = " + arrayList.size() + " authorizedServices size = " + arrayList3.size());
        if (arrayList.isEmpty() && arrayList3.isEmpty()) {
            return null;
        }
        return new CommonBotFeatures(originRobotFeatures.botInfo, arrayList3, arrayList);
    }

    private final void n(int result, String errMsg, BatchBotGetResponse response) {
        Integer num;
        ArrayList<CommonBotFeatures> arrayList;
        ArrayList<CommonBotFeatures> arrayList2 = null;
        if (response != null && (arrayList = response.botFeatures) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        QLog.i("MultiRobotsSearch", 1, "result = " + result + " errMsg = " + errMsg + " response = " + num);
        if (result != 0) {
            if (errMsg == null) {
                errMsg = "";
            }
            b(new SearchException(result, errMsg, this));
        } else {
            if (response != null) {
                arrayList2 = response.botFeatures;
            }
            this.mResultList = q(arrayList2);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("MultiRobotsSearch", 1, "request timeout");
        this$0.b(new SearchException(FlashChatItem.ID_RANDOM, "timeout", this$0));
    }

    private final ArrayList<CommonBotFeatures> q(List<CommonBotFeatures> robotFeaturesList) {
        CommonBotInfo botInfo;
        CommonBotFeatures m3;
        ArrayList arrayList = new ArrayList();
        if (robotFeaturesList != null) {
            for (CommonBotFeatures commonBotFeatures : robotFeaturesList) {
                if (commonBotFeatures != null && (botInfo = commonBotFeatures.botInfo) != null) {
                    Intrinsics.checkNotNullExpressionValue(botInfo, "botInfo");
                    if (!h34.a.c(botInfo) && !h34.a.g(botInfo) && (m3 = m(commonBotFeatures)) != null) {
                        arrayList.add(m3);
                    }
                }
            }
        }
        QLog.i("MultiRobotsSearch", 1, "pickAuthorizedRobotFeatures pickResultList = " + arrayList.size());
        return t(arrayList);
    }

    private final void r() {
        IRuntimeService iRuntimeService;
        ac robotService;
        String str = AppSetting.f99551k;
        String buildNum = AppSetting.f99542b;
        Intrinsics.checkNotNullExpressionValue(buildNum, "buildNum");
        CommonBotClientInfo commonBotClientInfo = new CommonBotClientInfo(2, str, Integer.parseInt(buildNum));
        BatchBotGetReq batchBotGetReq = new BatchBotGetReq();
        batchBotGetReq.uins = this.mSearchSessionParams.f();
        batchBotGetReq.num = 0;
        batchBotGetReq.clientInfo = commonBotClientInfo;
        batchBotGetReq.tinyids = this.mSearchSessionParams.e();
        batchBotGetReq.page = 0;
        batchBotGetReq.fullFetch = true;
        batchBotGetReq.scene = this.mSearchSessionParams.getScene();
        batchBotGetReq.filter = this.mSearchSessionParams.getFilter();
        batchBotGetReq.bkn = RobotProfileUtils.f368193a.h();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (robotService = iKernelService.getRobotService()) != null) {
            robotService.getRobotFunctions(this.mSearchSessionParams.getContact(), batchBotGetReq, new IGetRobotFunctionsCallback() { // from class: j64.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRobotFunctionsCallback
                public final void onResult(int i3, String str2, BatchBotGetResponse batchBotGetResponse) {
                    d.s(d.this, i3, str2, batchBotGetResponse);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(d this$0, int i3, String str, BatchBotGetResponse batchBotGetResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n(i3, str, batchBotGetResponse);
    }

    private final ArrayList<CommonBotFeatures> t(List<CommonBotFeatures> robotFeaturesList) {
        ArrayList<CommonBotFeatures> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (CommonBotFeatures commonBotFeatures : robotFeaturesList) {
            CommonBotInfo commonBotInfo = commonBotFeatures.botInfo;
            Intrinsics.checkNotNullExpressionValue(commonBotInfo, "it.botInfo");
            if (h34.a.f(commonBotInfo)) {
                arrayList2.add(commonBotFeatures);
            } else {
                arrayList.add(commonBotFeatures);
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @Override // j64.g
    @NotNull
    public String c() {
        return this.mSearchSessionParams.getCookieKey();
    }

    @Override // j64.g
    @Nullable
    public Object d() {
        return this.mResultList;
    }

    @Override // j64.g
    public boolean g() {
        long cacheDuration;
        long currentTimeMillis = System.currentTimeMillis() - this.contextStartTime;
        if (this.mIsFullAmountFetch) {
            cacheDuration = this.mRobotConfig.getRobotSlashCmdCacheDuration();
        } else {
            cacheDuration = this.mRobotConfig.getCacheDuration();
        }
        if (currentTimeMillis > cacheDuration) {
            return true;
        }
        return false;
    }

    @Override // j64.g
    public void h() {
        if (QLog.isColorLevel()) {
            QLog.i("MultiRobotsSearch", 2, "new RobotFunctionSearch start  robotIds = " + this.mSearchSessionParams.f() + " contact = " + this.mSearchSessionParams.getContact() + " scene = " + this.mSearchSessionParams.getScene() + " filter = " + this.mSearchSessionParams.getFilter());
        }
        this.mResultList.clear();
        this.mIsFullAmountFetch = this.mSearchSessionParams.f().isEmpty();
        this.contextStartTime = System.currentTimeMillis();
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: j64.a
            @Override // java.lang.Runnable
            public final void run() {
                d.o(d.this);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: j64.b
            @Override // java.lang.Runnable
            public final void run() {
                d.p(d.this);
            }
        }, this.mRobotConfig.getRequestTimeout());
    }
}
