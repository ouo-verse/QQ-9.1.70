package com.tencent.mobileqq.tianshu.api.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Argus;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IPageSceneADManagerApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.page.PageInfo;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.db.HistoryPageChange;
import com.tencent.trpcprotocol.tianshu.insite_task.insite_task.InsiteTaskPB$ClientTriggerReq;
import com.tencent.trpcprotocol.tianshu.insite_task.insite_task.InsiteTaskPB$ClientTriggerRsp;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u000e\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0003H\u0002J*\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0007\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J>\u0010%\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020#H\u0016J \u0010*\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R#\u0010F\u001a\n B*\u0004\u0018\u00010A0A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/PageSceneADManagerApiImpl;", "Lcom/tencent/mobileqq/tianshu/api/IPageSceneADManagerApi;", "Landroidx/fragment/app/Argus$ComponentCallback;", "Lcom/tencent/richframework/argus/page/PageInfo;", "", "getAllVisibleBlockMsg", "pageInfo", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/tianshu/parser/a;", "", "pageToBusiness", "business", "Lcom/tencent/mobileqq/tianshu/parser/d;", "getTimeConfig", "", "nextRequestTime", "", "markRequest", "", "canRequest", "getRequestMMKVKey", "timestamp", "getMillisecondsTomorrow", "page", "markOpenPageTime", "getLastOpenTimeKey", "stamp1", "stamp2", "isSameDay", "fromPage", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "fromPagePO", "newPage", "newPagePO", "groupPO", "Landroidx/fragment/app/Argus$MergeResult;", "mergeResult", "onPageChange", "currentPageInfo", "", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "historyPageChanges", "onPredictResult", "init", "Lcom/tencent/mobileqq/tianshu/parser/b;", "pageConfig", "Lcom/tencent/mobileqq/tianshu/parser/b;", "Lcom/tencent/mobileqq/tianshu/parser/c;", "timeConfig", "Lcom/tencent/mobileqq/tianshu/parser/c;", "currentPage", "Lcom/tencent/mobileqq/tianshu/parser/a;", QCircleLpReportDc010001.KEY_SUBTYPE, "I", "pageString", "Ljava/lang/String;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkv$delegate", "Lkotlin/Lazy;", "getMmkv", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkv", "Ljava/lang/Runnable;", "requestRunnable", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "handler$delegate", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "()V", "Companion", "a", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class PageSceneADManagerApiImpl implements IPageSceneADManagerApi, Argus.ComponentCallback {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String MMKV_KEY = "tianshu_in_site_";

    @NotNull
    public static final String TAG = "PageSceneADManagerApiImp";

    @Nullable
    private com.tencent.mobileqq.tianshu.parser.a currentPage;

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler;

    /* renamed from: mmkv$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mmkv;

    @Nullable
    private com.tencent.mobileqq.tianshu.parser.b pageConfig;

    @Nullable
    private String pageString;

    @NotNull
    private final Runnable requestRunnable;
    private int subType;

    @Nullable
    private com.tencent.mobileqq.tianshu.parser.c timeConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/PageSceneADManagerApiImpl$a;", "", "", "MMKV_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.api.impl.PageSceneADManagerApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/tianshu/api/impl/PageSceneADManagerApiImpl$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.tianshu.parser.a f293024d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PageSceneADManagerApiImpl f293025e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f293026f;

        b(com.tencent.mobileqq.tianshu.parser.a aVar, PageSceneADManagerApiImpl pageSceneADManagerApiImpl, long j3) {
            this.f293024d = aVar;
            this.f293025e = pageSceneADManagerApiImpl;
            this.f293026f = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, pageSceneADManagerApiImpl, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("request errorCode: ");
            sb5.append(errorCode);
            sb5.append(", data != null?");
            if (data == null) {
                z16 = true;
            }
            sb5.append(z16);
            QLog.d(PageSceneADManagerApiImpl.TAG, 1, sb5.toString());
            if (errorCode == 0 && data != null) {
                InsiteTaskPB$ClientTriggerRsp insiteTaskPB$ClientTriggerRsp = new InsiteTaskPB$ClientTriggerRsp();
                try {
                    insiteTaskPB$ClientTriggerRsp.mergeFrom(data);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                QLog.d(PageSceneADManagerApiImpl.TAG, 1, "business " + this.f293024d.b() + ", next request time: " + insiteTaskPB$ClientTriggerRsp.trigger_interval_sec.get());
                if (insiteTaskPB$ClientTriggerRsp.trigger_interval_sec.get() != 0) {
                    this.f293025e.markRequest(this.f293024d.b(), this.f293026f + (insiteTaskPB$ClientTriggerRsp.trigger_interval_sec.get() * 1000));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22238);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PageSceneADManagerApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(PageSceneADManagerApiImpl$mmkv$2.INSTANCE);
            this.mmkv = lazy;
            this.requestRunnable = new Runnable() { // from class: com.tencent.mobileqq.tianshu.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    PageSceneADManagerApiImpl.requestRunnable$lambda$1(PageSceneADManagerApiImpl.this);
                }
            };
            lazy2 = LazyKt__LazyJVMKt.lazy(PageSceneADManagerApiImpl$handler$2.INSTANCE);
            this.handler = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final boolean canRequest(String business) {
        if (NetConnInfoCenter.getServerTimeMillis() > getMmkv().getLong(getRequestMMKVKey(business), 0L, true)) {
            return true;
        }
        return false;
    }

    private final String getAllVisibleBlockMsg(PageInfo pageInfo) {
        Set<ArgusNode<?>> allVisibleNode;
        StringBuilder sb5 = new StringBuilder();
        if (pageInfo != null && (allVisibleNode = pageInfo.getAllVisibleNode()) != null) {
            Iterator<T> it = allVisibleNode.iterator();
            while (it.hasNext()) {
                Object container = ((ArgusNode) it.next()).getContainer();
                if (container != null) {
                    String simpleName = container.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "simpleName");
                    sb5.append(simpleName);
                    sb5.append(" ");
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    private final String getLastOpenTimeKey(String business, String page) {
        return "tianshu_in_site__" + business + util.base64_pad_url + page + "_time_" + RFWApplication.getAccountId();
    }

    private final long getMillisecondsTomorrow(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2);
        int i17 = calendar.get(5);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(i3, i16, i17 + 1, 0, 0, 0);
        calendar2.set(14, 0);
        return calendar2.getTimeInMillis();
    }

    private final MMKVOptionEntityV2 getMmkv() {
        return (MMKVOptionEntityV2) this.mmkv.getValue();
    }

    private final String getRequestMMKVKey(String business) {
        return "tianshu_in_site__" + business + "_next_request_" + RFWApplication.getAccountId();
    }

    private final com.tencent.mobileqq.tianshu.parser.d getTimeConfig(String business) {
        Map<String, com.tencent.mobileqq.tianshu.parser.d> a16;
        com.tencent.mobileqq.tianshu.parser.c cVar = (com.tencent.mobileqq.tianshu.parser.c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tianshu_in_site_push_config");
        this.timeConfig = cVar;
        if (cVar != null && (a16 = cVar.a()) != null) {
            return a16.get(business);
        }
        return null;
    }

    private final boolean isSameDay(long stamp1, long stamp2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(stamp2);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return true;
        }
        return false;
    }

    private final int markOpenPageTime(String business, String page) {
        int i3;
        String str = "tianshu_in_site__" + business + util.base64_pad_url + page + "_last_time_" + RFWApplication.getAccountId();
        long j3 = getMmkv().getLong(str, 0L, true);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        String lastOpenTimeKey = getLastOpenTimeKey(business, page);
        if (isSameDay(j3, serverTimeMillis)) {
            i3 = getMmkv().getInt(lastOpenTimeKey, 0, true) + 1;
        } else {
            i3 = 1;
        }
        getMmkv().putInt(lastOpenTimeKey, i3, true);
        getMmkv().putLong(str, serverTimeMillis, true);
        QLog.d(TAG, 1, "markOpenPageTime, currentTime:" + i3);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markRequest(String business, long nextRequestTime) {
        getMmkv().putLong(getRequestMMKVKey(business), nextRequestTime, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageChange$lambda$2(PageSceneADManagerApiImpl this$0, String newPageString) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newPageString, "$newPageString");
        Pair<com.tencent.mobileqq.tianshu.parser.a, Pair<String, Integer>> pageToBusiness = this$0.pageToBusiness(newPageString);
        if (pageToBusiness == null) {
            this$0.currentPage = null;
            this$0.subType = 0;
            this$0.getHandler().removeCallbacks(this$0.requestRunnable);
            return;
        }
        if (Intrinsics.areEqual(this$0.currentPage, pageToBusiness.getFirst()) && Intrinsics.areEqual(this$0.pageString, pageToBusiness.getSecond().getFirst())) {
            return;
        }
        this$0.currentPage = pageToBusiness.getFirst();
        this$0.subType = pageToBusiness.getSecond().getSecond().intValue();
        this$0.pageString = pageToBusiness.getSecond().getFirst();
        com.tencent.mobileqq.tianshu.parser.d timeConfig = this$0.getTimeConfig(pageToBusiness.getFirst().b());
        if (timeConfig != null && timeConfig.b() > 0 && timeConfig.a() > 0) {
            if (this$0.markOpenPageTime(pageToBusiness.getFirst().b(), pageToBusiness.getSecond().getFirst()) >= timeConfig.a() && this$0.canRequest(pageToBusiness.getFirst().b())) {
                this$0.getHandler().removeCallbacks(this$0.requestRunnable);
                this$0.getHandler().postDelayed(this$0.requestRunnable, timeConfig.b() * 1000);
                QLog.d(TAG, 1, "onPageChange: pageString:" + newPageString + ", pageInfo:" + pageToBusiness + ", timeConfig:" + timeConfig);
                return;
            }
            QLog.d(TAG, 1, "pageString:" + newPageString + ", can not request");
            return;
        }
        QLog.d(TAG, 1, "timeConfig is null");
    }

    private final Pair<com.tencent.mobileqq.tianshu.parser.a, Pair<String, Integer>> pageToBusiness(String pageInfo) {
        List<com.tencent.mobileqq.tianshu.parser.a> a16;
        Set<Map.Entry<String, Integer>> entries;
        Object obj;
        boolean contains$default;
        if (this.pageConfig == null) {
            this.pageConfig = (com.tencent.mobileqq.tianshu.parser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tianshu_page_scene_manager_config");
        }
        com.tencent.mobileqq.tianshu.parser.b bVar = this.pageConfig;
        if (bVar != null && (a16 = bVar.a()) != null) {
            for (com.tencent.mobileqq.tianshu.parser.a aVar : a16) {
                HashMap<String, Integer> c16 = aVar.c();
                if (c16 != null && (entries = c16.entrySet()) != null) {
                    Intrinsics.checkNotNullExpressionValue(entries, "entries");
                    Iterator<T> it = entries.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            Object key = ((Map.Entry) obj).getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) pageInfo, (CharSequence) key, false, 2, (Object) null);
                            if (contains$default) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    if (entry != null) {
                        Intrinsics.checkNotNullExpressionValue(entry, "page.page?.entries?.firs\u2026.key) } ?: return@forEach");
                        return TuplesKt.to(aVar, TuplesKt.to(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestRunnable$lambda$1(PageSceneADManagerApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.tianshu.parser.a aVar = this$0.currentPage;
        if (aVar == null) {
            return;
        }
        InsiteTaskPB$ClientTriggerReq insiteTaskPB$ClientTriggerReq = new InsiteTaskPB$ClientTriggerReq();
        insiteTaskPB$ClientTriggerReq.biz_type.set(aVar.a());
        insiteTaskPB$ClientTriggerReq.biz_sub_type.set(this$0.subType);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        this$0.markRequest(aVar.b(), this$0.getMillisecondsTomorrow(serverTimeMillis));
        QLog.d(TAG, 1, "send request, business:" + aVar.b() + ", subType:" + this$0.subType);
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new b(aVar, this$0, serverTimeMillis), insiteTaskPB$ClientTriggerReq.toByteArray(), "OidbSvcTrpcTcp.0x9280_0", 37504, 0);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IPageSceneADManagerApi
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            Argus.INSTANCE.registerComponentCallback(this);
            QLog.d(TAG, 1, "init");
        }
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPageChange(@Nullable PageInfo fromPage, @Nullable PageInfoPO fromPagePO, @NotNull PageInfo newPage, @NotNull PageInfoPO newPagePO, @Nullable PageInfoPO groupPO, @NotNull Argus.MergeResult mergeResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fromPage, fromPagePO, newPage, newPagePO, groupPO, mergeResult);
            return;
        }
        Intrinsics.checkNotNullParameter(newPage, "newPage");
        Intrinsics.checkNotNullParameter(newPagePO, "newPagePO");
        Intrinsics.checkNotNullParameter(mergeResult, "mergeResult");
        final String allVisibleBlockMsg = getAllVisibleBlockMsg(newPage);
        if (allVisibleBlockMsg.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                PageSceneADManagerApiImpl.onPageChange$lambda$2(PageSceneADManagerApiImpl.this, allVisibleBlockMsg);
            }
        });
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPredictResult(@Nullable PageInfo currentPageInfo, @NotNull List<? extends HistoryPageChange> historyPageChanges) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) currentPageInfo, (Object) historyPageChanges);
        } else {
            Intrinsics.checkNotNullParameter(historyPageChanges, "historyPageChanges");
        }
    }
}
