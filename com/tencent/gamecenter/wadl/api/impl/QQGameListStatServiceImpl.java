package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameListStatService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.h;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqgame.QQGameQfsSubscribe;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0002/0B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u001c\u001a\u00020\u00032\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0019j\b\u0012\u0004\u0012\u00020\u0016`\u001aH\u0016J \u0010\u001d\u001a\u00020\u00032\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0019j\b\u0012\u0004\u0012\u00020\u0016`\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/impl/QQGameListStatServiceImpl;", "Lcom/tencent/gamecenter/wadl/api/IQQGameListStatService;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;", "", "checkIfGetGameList", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "onGetGameList", "", "Lcom/tencent/gamecenter/wadl/api/impl/QQGameListStatServiceImpl$b;", "allGameList", "reportInstalledGameList", "installedGameList", "report", "", "isReportConfigEnable", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", "statGameList", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "onWadlTaskStatusChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "wadlResults", "onQueryCallback", "onQueryCallbackVia", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "mGameList", "Ljava/util/List;", "isStating", "Z", "mLastTaskChangeTs", "J", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "mTrpcListener", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "getGameList", "()Lkotlin/Unit;", "gameList", "<init>", "()V", "Companion", "a", "b", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class QQGameListStatServiceImpl implements IQQGameListStatService, WadlProxyServiceCallBackInterface {

    @NotNull
    private static final String CONFIG_ID_REPORT_SWITCH = "100487";

    @NotNull
    private static final String TAG = "QQGameListStatServiceImpl";
    private static final long TASK_CHANGE_CHECK_INTERVAL = 21600000;
    private volatile boolean isStating;
    private long mLastTaskChangeTs;

    @NotNull
    private final List<b> mGameList = new ArrayList();

    @NotNull
    private final WadlTrpcListener mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameListStatServiceImpl$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        @NotNull
        public HashSet<String> getFilterCmds() {
            return new HashSet<String>() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameListStatServiceImpl$mTrpcListener$1$getFilterCmds$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    add(WadlProxyConsts.CMD_GET_GAME_LIST);
                }

                @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return contains((String) obj);
                    }
                    return false;
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final /* bridge */ boolean remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final /* bridge */ int size() {
                    return getSize();
                }

                public /* bridge */ boolean contains(String str) {
                    return super.contains((Object) str);
                }

                public /* bridge */ boolean remove(String str) {
                    return super.remove((Object) str);
                }
            };
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(@NotNull Intent request, @NotNull String cmd, long ret, @NotNull TrpcProxy.TrpcInovkeRsp rsp) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (Intrinsics.areEqual(WadlProxyConsts.CMD_GET_GAME_LIST, cmd)) {
                QQGameListStatServiceImpl.this.onGetGameList(ret, rsp);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/impl/QQGameListStatServiceImpl$b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "gameAppid", "b", "d", PushClientConstants.TAG_PKG_NAME, "<init>", "()V", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String gameAppid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String pkgName;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getGameAppid() {
            return this.gameAppid;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPkgName() {
            return this.pkgName;
        }

        public final void c(@Nullable String str) {
            this.gameAppid = str;
        }

        public final void d(@Nullable String str) {
            this.pkgName = str;
        }
    }

    private final void checkIfGetGameList() {
        if (isReportConfigEnable() && !this.isStating && h.d()) {
            this.isStating = true;
            getGameList();
        }
    }

    private final Unit getGameList() {
        QLog.d(TAG, 1, "getGameList");
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).getGameList();
        return Unit.INSTANCE;
    }

    private final boolean isReportConfigEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_ID_REPORT_SWITCH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[Catch: Exception -> 0x009b, TryCatch #0 {Exception -> 0x009b, blocks: (B:6:0x0024, B:8:0x0041, B:13:0x004d, B:14:0x004f, B:22:0x0084, B:23:0x0085, B:29:0x008c, B:30:0x008d, B:31:0x008e, B:16:0x0050, B:17:0x0059, B:19:0x005f, B:21:0x0082), top: B:5:0x0024, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e A[Catch: Exception -> 0x009b, TRY_LEAVE, TryCatch #0 {Exception -> 0x009b, blocks: (B:6:0x0024, B:8:0x0041, B:13:0x004d, B:14:0x004f, B:22:0x0084, B:23:0x0085, B:29:0x008c, B:30:0x008d, B:31:0x008e, B:16:0x0050, B:17:0x0059, B:19:0x005f, B:21:0x0082), top: B:5:0x0024, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onGetGameList(long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        boolean z16;
        QLog.d(TAG, 1, "onGetGameList, ret=", Long.valueOf(ret));
        if (ret == 0 && rsp.data.has()) {
            try {
                QQGameQfsSubscribe.GetGameListRsp getGameListRsp = new QQGameQfsSubscribe.GetGameListRsp();
                getGameListRsp.mergeFrom(rsp.data.get().toByteArray());
                List<QQGameQfsSubscribe.GameSummary> list = getGameListRsp.summary.get();
                List<QQGameQfsSubscribe.GameSummary> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z16 = false;
                    if (z16) {
                        synchronized (this.mGameList) {
                            this.mGameList.clear();
                            for (QQGameQfsSubscribe.GameSummary gameSummary : list) {
                                b bVar = new b();
                                bVar.c(gameSummary.game_id.get());
                                bVar.d(gameSummary.package_name.get());
                                this.mGameList.add(bVar);
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                        reportInstalledGameList(this.mGameList);
                    } else {
                        QLog.d(TAG, 1, "onGetGameList, game list empty");
                        h.c();
                    }
                }
                z16 = true;
                if (z16) {
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onGetGameList, e=", e16);
            }
        } else {
            QLog.d(TAG, 1, "onGetGameList, failed");
        }
        this.isStating = false;
    }

    private final void report(List<b> installedGameList) {
        try {
            WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
            wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId("913861").setExt(1, "81708").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD);
            int i3 = 0;
            for (int i16 = 20; i3 < installedGameList.size() && i16 <= 50; i16++) {
                wadlReportBuilder.setExt(i16, installedGameList.get(i3).getGameAppid());
                i3++;
            }
            wadlReportBuilder.report();
            QLog.d(TAG, 1, "report, size=", Integer.valueOf(installedGameList.size()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "report exception=", e16);
        }
    }

    private final void reportInstalledGameList(List<b> allGameList) {
        boolean z16;
        QLog.d(TAG, 1, "reportInstalledGameList");
        if (!allGameList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : allGameList) {
                String pkgName = bVar.getPkgName();
                boolean z17 = false;
                if (pkgName != null && pkgName.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (GameCenterUtil.getPackageInfo(bVar.getPkgName()) != null) {
                        Iterator<b> it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (Intrinsics.areEqual(it.next().getPkgName(), bVar.getPkgName())) {
                                    z17 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (!z17) {
                            arrayList.add(bVar);
                        }
                    }
                } else {
                    QLog.d(TAG, 1, "reportInstalledGameList, pkg name empty, appid=", bVar.getGameAppid());
                }
            }
            report(arrayList);
            h.c();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(@NotNull ArrayList<WadlResult> wadlResults) {
        Intrinsics.checkNotNullParameter(wadlResults, "wadlResults");
        checkIfGetGameList();
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(@NotNull ArrayList<WadlResult> wadlResults) {
        Intrinsics.checkNotNullParameter(wadlResults, "wadlResults");
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(@NotNull WadlResult wadlResult) {
        Intrinsics.checkNotNullParameter(wadlResult, "wadlResult");
        if (NetConnInfoCenter.getServerTimeMillis() - this.mLastTaskChangeTs > 21600000) {
            this.mLastTaskChangeTs = NetConnInfoCenter.getServerTimeMillis();
            checkIfGetGameList();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameListStatService
    public void statGameList() {
        QLog.d(TAG, 1, "statGameList");
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
    }
}
