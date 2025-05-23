package com.tencent.qqnt.aio.mutualmark.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J*\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/mutualmark/api/impl/AIOMutualMaskApiImpl;", "Lcom/tencent/qqnt/aio/mutualmark/api/IAIOMutualMaskApi;", "", "troopUin", "memberUin", "troopHonorString", "", "richFlag", "Lcom/tencent/qqnt/aio/mutualmark/api/a;", "tryToGetMutualMarkDataOrNotifyUpdate", "", "notifyTroopMemberHonorUpdateByCheckIconDrawable", "uin", "honorStr", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "getDrawable", "getMutualMarkInfo", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMutualMaskApiImpl implements IAIOMutualMaskApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOMutualMaskApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/mutualmark/api/impl/AIOMutualMaskApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.mutualmark.api.impl.AIOMutualMaskApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMutualMaskApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMutualMarkInfo$lambda$1(AIOMutualMaskApiImpl this$0, String troopUin, String memberUin, TroopMemberInfo troopMemberInfo) {
        String str;
        byte b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        if (troopMemberInfo != null) {
            str = troopMemberInfo.honorList;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (troopMemberInfo != null) {
            b16 = troopMemberInfo.mHonorRichFlag;
        } else {
            b16 = 0;
        }
        this$0.notifyTroopMemberHonorUpdateByCheckIconDrawable(troopUin, memberUin, str, b16);
    }

    private final void notifyTroopMemberHonorUpdateByCheckIconDrawable(String troopUin, String memberUin, String troopHonorString, byte richFlag) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        ITroopHonorService.b bVar = new ITroopHonorService.b(troopUin, memberUin, troopHonorString, Byte.valueOf(richFlag));
        if (!bVar.a()) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "notifyTroopMemberHonorUpdateByCheckIconDrawable troopIconInfo isValid troopUin = " + troopUin + " memberUin = " + memberUin + " honorList = " + troopHonorString + " richFlag = " + ((int) richFlag));
            }
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new r(memberUin, troopUin, troopHonorString, richFlag));
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "notifyTByCheckIconDrawable troopUin = " + troopUin + " memberUin = " + memberUin + " honorStr = " + troopHonorString + " richFlag = " + ((int) richFlag));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        List<Drawable> list = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(ITroopHonorService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopHonorService iTroopHonorService = (ITroopHonorService) iRuntimeService;
        if (iTroopHonorService != null) {
            list = iTroopHonorService.getHonorIcon(bVar, new e(troopUin, memberUin, troopHonorString, richFlag));
        }
        List<Drawable> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.i(TAG, 1, "notifyTroopMemberHonorUpdateByCheckIconDrawable iconList isNullOrEmpty not troopUin = " + troopUin + " memberUin = " + memberUin + " honorList = " + troopHonorString + " richFlag = " + ((int) richFlag));
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new r(memberUin, troopUin, troopHonorString, richFlag));
        }
    }

    private static final void notifyTroopMemberHonorUpdateByCheckIconDrawable$lambda$3(String troopUin, String memberUin, String troopHonorString, byte b16, List list) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        Intrinsics.checkNotNullParameter(troopHonorString, "$troopHonorString");
        QLog.i(TAG, 1, "notifyTroopMemberHonorUpdateByCheckIconDrawable getHonorIcon callback troopUin = " + troopUin + " memberUin = " + memberUin + " honorList = " + troopHonorString + " richFlag = " + ((int) b16));
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new r(memberUin, troopUin, troopHonorString, b16));
    }

    private final com.tencent.qqnt.aio.mutualmark.api.a tryToGetMutualMarkDataOrNotifyUpdate(String troopUin, String memberUin, String troopHonorString, byte richFlag) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        List<Drawable> list;
        boolean z16;
        ITroopHonorService.b bVar = new ITroopHonorService.b(troopUin, memberUin, troopHonorString, Byte.valueOf(richFlag));
        if (!bVar.a()) {
            QLog.i(TAG, 1, "tryToGetMutualMarkDataOrNotifyUpdate troopIconInfo isValid troopUin = " + troopUin + " memberUin = " + memberUin + " honorList = " + troopHonorString + " richFlag = " + ((int) richFlag));
            return new com.tencent.qqnt.aio.mutualmark.api.a(troopUin, memberUin, troopHonorString, richFlag);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(ITroopHonorService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopHonorService iTroopHonorService = (ITroopHonorService) iRuntimeService;
        if (iTroopHonorService != null) {
            list = iTroopHonorService.getHonorIcon(bVar, new e(troopUin, memberUin, troopHonorString, richFlag));
        } else {
            list = null;
        }
        List<Drawable> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.i(TAG, 1, "tryToGetMutualMarkDataOrNotifyUpdate iconList isNullOrEmpty troopUin = " + troopUin + " memberUin = " + memberUin + " honorList = " + troopHonorString + " richFlag = " + ((int) richFlag));
            return new com.tencent.qqnt.aio.mutualmark.api.a(troopUin, memberUin, troopHonorString, richFlag);
        }
        QLog.i(TAG, 1, "tryToGetMutualMarkDataOrNotifyUpdate iconList null troopUin = " + troopUin + " memberUin = " + memberUin + " honorList = " + troopHonorString + " richFlag = " + ((int) richFlag));
        return null;
    }

    private static final void tryToGetMutualMarkDataOrNotifyUpdate$lambda$2(String troopUin, String memberUin, String troopHonorString, byte b16, List list) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        Intrinsics.checkNotNullParameter(troopHonorString, "$troopHonorString");
        QLog.i(TAG, 1, "tryToGetMutualMarkDataOrNotifyUpdate getHonorIcon callback troopUin = " + troopUin + " memberUin = " + memberUin + " honorList = " + troopHonorString + " richFlag = " + ((int) b16));
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new r(memberUin, troopUin, troopHonorString, b16));
    }

    @Override // com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi
    @NotNull
    public ArrayList<Drawable> getDrawable(@NotNull String troopUin, @NotNull String uin, @NotNull String honorStr, byte richFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, this, troopUin, uin, honorStr, Byte.valueOf(richFlag));
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(honorStr, "honorStr");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "getDrawable troopUin = " + troopUin + " memberUin = " + uin + " honorStr = " + honorStr + " richFlag = " + ((int) richFlag));
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopHonorService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        return new ArrayList<>(((ITroopHonorService) runtimeService).getHonorIcon(new ITroopHonorService.b(troopUin, uin, honorStr, Byte.valueOf(richFlag)), new ITroopHonorService.a() { // from class: com.tencent.qqnt.aio.mutualmark.api.impl.b
        }));
    }

    @Override // com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi
    @Nullable
    public com.tencent.qqnt.aio.mutualmark.api.a getMutualMarkInfo(@NotNull final String troopUin, @NotNull final String memberUin) {
        boolean z16;
        boolean z17;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppInterface appInterface2;
        IRuntimeService iRuntimeService2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.aio.mutualmark.api.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        boolean z18 = true;
        if (troopUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        if (memberUin.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        String troopHonorString = "";
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(ITroopHonorService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopHonorService iTroopHonorService = (ITroopHonorService) iRuntimeService;
        if (iTroopHonorService == null) {
            return null;
        }
        if (!iTroopHonorService.isSupportTroopHonor(troopUin)) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "getMutualMarkInfo isSupportTroopHonor false  troopUin = " + troopUin + " memberUin = " + memberUin);
            }
            return new com.tencent.qqnt.aio.mutualmark.api.a(troopUin, memberUin, "", (byte) 0);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface2 = (AppInterface) peekAppRuntime2;
        } else {
            appInterface2 = null;
        }
        if (appInterface2 != null) {
            iRuntimeService2 = appInterface2.getRuntimeService(ITroopMemberInfoService.class, "");
        } else {
            iRuntimeService2 = null;
        }
        ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) iRuntimeService2;
        if (iTroopMemberInfoService == null) {
            return null;
        }
        TroopMemberInfo troopMemberFromCacheOrFetchAsync = iTroopMemberInfoService.getTroopMemberFromCacheOrFetchAsync(troopUin, memberUin, "AIOMutualMaskApiImpl-markInfo", new ITroopMemberInfoService.a() { // from class: com.tencent.qqnt.aio.mutualmark.api.impl.a
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
            public final void a(TroopMemberInfo troopMemberInfo) {
                AIOMutualMaskApiImpl.getMutualMarkInfo$lambda$1(AIOMutualMaskApiImpl.this, troopUin, memberUin, troopMemberInfo);
            }
        });
        if (troopMemberFromCacheOrFetchAsync != null) {
            String str = troopMemberFromCacheOrFetchAsync.honorList;
            if (str != null && str.length() != 0) {
                z18 = false;
            }
            if (!z18) {
                troopHonorString = troopMemberFromCacheOrFetchAsync.honorList;
            }
            Intrinsics.checkNotNullExpressionValue(troopHonorString, "troopHonorString");
            return tryToGetMutualMarkDataOrNotifyUpdate(troopUin, memberUin, troopHonorString, troopMemberFromCacheOrFetchAsync.mHonorRichFlag);
        }
        QLog.i(TAG, 1, "getMutualMarkInfo troopMemberInfo null troopUin = " + troopUin + " memberUin = " + memberUin);
        return null;
    }

    private static final void getDrawable$lambda$0(List list) {
    }
}
