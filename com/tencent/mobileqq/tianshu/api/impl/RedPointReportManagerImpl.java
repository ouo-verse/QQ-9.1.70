package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.api.IRedPointReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/RedPointReportManagerImpl;", "Lcom/tencent/mobileqq/tianshu/api/IRedPointReportManager;", "", "path", "", "resetExposuresDeduplicate", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "info", "", "checkExposuresDeduplicate", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "redTouchManager", "", "appSet", "reportLevelZeroExposure", "reportLevelZeroClick", WadlProxyConsts.EXTRA_DATA, "reportExposuresDeduplicate", "", "pathList", "reportClick", "<init>", "()V", "Companion", "a", "b", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RedPointReportManagerImpl implements IRedPointReportManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "RedPointReportManager";

    @NotNull
    private static final HashMap<String, String> exposuresMap;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/RedPointReportManagerImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.api.impl.RedPointReportManagerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/RedPointReportManagerImpl$b;", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager$a;", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "", "a", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements IRedTouchManager.a {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager.a
        public boolean a(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
            boolean z16;
            boolean z17;
            boolean z18;
            PBInt32Field pBInt32Field;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInfo)).booleanValue();
            }
            if (appInfo != null && (pBInt32Field = appInfo.mission_level) != null && pBInt32Field.get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            if (appInfo != null && com.tencent.mobileqq.tianshu.ui.a.d(appInfo)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
            if (appInfo != null && com.tencent.mobileqq.tianshu.ui.a.a(appInfo)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22266);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
            exposuresMap = new HashMap<>();
        }
    }

    public RedPointReportManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean checkExposuresDeduplicate(BusinessInfoCheckUpdate.AppInfo info) {
        String path = info.path.get();
        int i3 = info.type.get();
        String str = info.hash.get();
        if (i3 == 8) {
            str = String.valueOf(info.version.get());
        }
        HashMap<String, String> hashMap = exposuresMap;
        String str2 = hashMap.get(path);
        if (str2 != null && Intrinsics.areEqual(str2, str)) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(path, "path");
        hashMap.put(path, str);
        return false;
    }

    private final IRedTouchManager redTouchManager() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        return (IRedTouchManager) runtimeService;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointReportManager
    public void reportClick(@NotNull String path, @Nullable String extraData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) path, (Object) extraData);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = redTouchManager().getAppInfoByPath(path);
        if (appInfoByPath != null) {
            reportClick(appInfoByPath, extraData);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointReportManager
    public void reportExposuresDeduplicate(@NotNull String path, @Nullable String extraData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) path, (Object) extraData);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = redTouchManager().getAppInfoByPath(path);
        if (appInfoByPath != null) {
            reportExposuresDeduplicate(appInfoByPath, extraData);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointReportManager
    public void reportLevelZeroClick(int appSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, appSet);
            return;
        }
        QLog.i(TAG, 1, "[reportLevelZeroClick] appSet:" + appSet + TokenParser.SP);
        redTouchManager().reportLevelZeroRedInfo(appSet, 31, false, new b());
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointReportManager
    public void reportLevelZeroExposure(int appSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, appSet);
        } else {
            redTouchManager().reportLevelZeroRedInfo(appSet, 30, false, new b());
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointReportManager
    public void resetExposuresDeduplicate(@NotNull List<String> pathList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pathList);
            return;
        }
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        Iterator<String> it = pathList.iterator();
        while (it.hasNext()) {
            resetExposuresDeduplicate(it.next());
        }
        QLog.i(TAG, 1, "[resetExposuresDeduplicate]\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u91cd\u7f6e\uff1a" + pathList.size() + " \u5269\u4f59\uff1a" + exposuresMap.size());
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointReportManager
    public void reportClick(@NotNull BusinessInfoCheckUpdate.AppInfo info, @Nullable String extraData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) info, (Object) extraData);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.i(TAG, 1, "[reportClick] path:" + info.path.get() + TokenParser.SP);
        redTouchManager().reportLevelOneRedInfo(info, 31, extraData);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedPointReportManager
    public void reportExposuresDeduplicate(@NotNull BusinessInfoCheckUpdate.AppInfo info, @Nullable String extraData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) info, (Object) extraData);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (checkExposuresDeduplicate(info)) {
            return;
        }
        QLog.i(TAG, 1, "[reportExposuresDeduplicate] path:" + info.path.get() + TokenParser.SP);
        redTouchManager().reportLevelOneRedInfo(info, 30, extraData);
    }

    private final void resetExposuresDeduplicate(String path) {
        exposuresMap.remove(path);
    }
}
