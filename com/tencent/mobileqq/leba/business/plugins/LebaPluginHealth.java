package com.tencent.mobileqq.leba.business.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016Jb\u0010$\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\tH\u0016R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginHealth;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "", "position", "", "isTableModel", "hasRedDot", "", "action", "", "T", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "", ReportConstant.COSTREPORT_PREFIX, "t", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "", "resID", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "y", "G", BdhLogUtil.LogTag.Tag_Conn, "Z", "mHasExposed", "()J", "resId", "<init>", "()V", "D", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginHealth extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static List<String> E;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mHasExposed;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginHealth$a;", "", "", "ACTION_CLICK", "Ljava/lang/String;", "ACTION_EXPOSE", "HAS_RED_DOT", "HEALTH_DOMAIN", "IS_TABLE_MODE", "MODULE", "OPERNAME", "POSITION", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginHealth$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginHealth$b", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "", "url", "", "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "g", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends DefaultClickProcessor {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final boolean l(String url) {
            String str = null;
            try {
                str = new URL(url).getHost();
                return TextUtils.equals(str, "yundong.qq.com");
            } catch (Exception unused) {
                QLog.e("Leba.DefaultClickProcessor", 2, "get url host failed, error is" + str);
                return false;
            }
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        public void g(@NotNull Activity activity, @NotNull DefaultClickProcessor.a item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(item, "item");
            String l3 = item.l();
            if (l3 == null) {
                l3 = "";
            }
            if (l(l3)) {
                IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQHealthService.class, ProcessConstant.MULTI);
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026a, ProcessConstant.MULTI)");
                if (((IQQHealthService) runtimeService).redirectAIOToMainPage(activity, 160)) {
                    return;
                }
            }
            super.g(activity, item);
        }
    }

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"jiankang.qq.com", "guahao.com", "91160.com"});
        E = listOf;
    }

    public LebaPluginHealth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(LebaPluginHealth this$0, int i3, boolean z16, RedTouch redTouch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        int i16 = i3 + 1;
        if (redTouch == null || !redTouch.hasLebaRedTouch()) {
            z17 = false;
        }
        this$0.T(i16, z16, z17, "expose");
    }

    private final void T(int position, boolean isTableModel, boolean hasRedDot, String action) {
        String str;
        Map<String, String> mapOf;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("ext2", String.valueOf(position));
        String str2 = "1";
        if (!isTableModel) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[1] = TuplesKt.to("ext3", str);
        if (!hasRedDot) {
            str2 = "0";
        }
        pairArr[2] = TuplesKt.to("ext4", str2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("dongtai", AdHippyFragment.HEALTH_NAME, action, mapOf);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.G();
            this.mHasExposed = false;
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        int i3 = reportInfo.f240478b;
        boolean z17 = reportInfo.f240480d;
        if (reportInfo.f240479c != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        T(i3, z17, z16, "click");
        super.H(v3, item, reportInfo);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public DefaultClickProcessor k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DefaultClickProcessor) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public List<String> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return E;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "key_health_dns_parse";
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 4559L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable final RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, final int index, final boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        if (!this.mHasExposed) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.j
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginHealth.S(LebaPluginHealth.this, index, isTableModel, redTouch);
                }
            });
        }
        this.mHasExposed = true;
        return super.y(app, context, resID, redTouch, resPkgName, redTouchHistory, index, isTableModel);
    }
}
