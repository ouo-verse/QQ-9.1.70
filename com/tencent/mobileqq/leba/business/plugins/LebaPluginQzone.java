package com.tencent.mobileqq.leba.business.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.et;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginQzone$qzob$2;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.service.qzone.QZoneClearRedCountInfoEvent;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQZonePageApi;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.view.FilterEnum;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LinkReport;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001UB\u0007\u00a2\u0006\u0004\bS\u0010TJ \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u001e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016Jb\u00102\u001a\u00020\"2\b\u0010\u0011\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0018\u0010/\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010-2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\"H\u0016J\n\u00103\u001a\u0004\u0018\u00010+H\u0016J\b\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\nH\u0016J\u0018\u00107\u001a\u00020\n2\u0006\u00106\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u00020\nH\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016J\b\u0010<\u001a\u00020\nH\u0016J\b\u0010=\u001a\u00020\nH\u0016J\u0012\u0010?\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010>H\u0016J$\u0010C\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030A0@j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030A`BH\u0016R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010HR\u0016\u0010K\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010L\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010HR\u001b\u0010P\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010N\u001a\u0004\bH\u0010OR\u0014\u0010R\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010Q\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzone;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/service/qzone/QZoneClearRedCountInfoEvent;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "", "V", "b0", "", "style", "d0", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Y", "event", "a0", "X", "c0", "Lcom/tencent/mobileqq/servlet/QZoneManagerImp;", "qim", "f0", "g0", "Lcom/tencent/mobileqq/leba/entity/o;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "H", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "mode", "", "l", "Lmqq/app/AppRuntime;", "Landroid/content/Context;", "context", "", "resID", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "isTableModel", "y", "u", "D", "G", "tabChange", "I", MosaicConstants$JsFunction.FUNC_ON_DESTROY, UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "w", "e", "M", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzoneRedViewHolder;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzoneRedViewHolder;", "redViewHolder", "Z", "enterQzone", "E", "mIsItemClick", "refreshQZoneWithRedDot", "Lcom/tencent/mobileqq/observer/QZoneObserver;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/observer/QZoneObserver;", "qzob", "()J", "resId", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginQzone extends BaseLebaPluginItem implements SimpleEventReceiver<QZoneClearRedCountInfoEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LebaPluginQzoneRedViewHolder redViewHolder;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean enterQzone;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsItemClick;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean refreshQZoneWithRedDot;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy qzob;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzone$a;", "", "", "JUMP_QZONE_FRIEND", "Ljava/lang/String;", "QZONE_PROCESS_NAME", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzone$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginQzone$b", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends DefaultClickProcessor {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzone.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        @NotNull
        public DefaultClickProcessor.a c(@NotNull View view, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DefaultClickProcessor.a) iPatchRedirector.redirect((short) 2, this, view, item, reportInfo);
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            DefaultClickProcessor.a c16 = super.c(view, item, reportInfo);
            LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = LebaPluginQzone.this.redViewHolder;
            boolean z17 = true;
            if (lebaPluginQzoneRedViewHolder != null && lebaPluginQzoneRedViewHolder.K()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !LebaPluginQzone.this.refreshQZoneWithRedDot) {
                z17 = false;
            }
            c16.r(z17);
            return c16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginQzone() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LebaPluginQzone$qzob$2.a>() { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzone$qzob$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginQzone$qzob$2$a", "Lcom/tencent/mobileqq/observer/QZoneObserver;", "", "isSuc", "hasNew", "", "type", "", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes15.dex */
                public static final class a extends QZoneObserver {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ LebaPluginQzone f240137d;

                    a(LebaPluginQzone lebaPluginQzone) {
                        this.f240137d = lebaPluginQzone;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginQzone);
                        }
                    }

                    @Override // com.tencent.mobileqq.observer.QZoneObserver
                    protected void f(boolean isSuc, boolean hasNew, long type) {
                        Unit unit;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), Boolean.valueOf(hasNew), Long.valueOf(type));
                            return;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("QZoneObserver onGetQZoneFeedCountFin, isSuc=" + isSuc + ",hasNew=" + hasNew + ",type=" + type);
                        if (QLog.isColorLevel()) {
                            if (((type >>> 17) & 1) != 0) {
                                sb5.append("\nLeba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
                            }
                            sb5.append("\nLeba onGetQZoneFeedCountFin type: " + type + " and then call Leba freshEntryItemUI");
                        }
                        QLog.i("UndealCount.QZoneObserver", 1, sb5.toString());
                        if (isSuc) {
                            LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.f240137d.redViewHolder;
                            if (lebaPluginQzoneRedViewHolder != null) {
                                lebaPluginQzoneRedViewHolder.b0();
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            if (unit == null) {
                                QLog.e("UndealCount.QZoneObserver", 1, "onGetQZoneFeedCountFin redViewHolder is null");
                            }
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginQzone.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(LebaPluginQzone.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.qzob = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void V(final View v3, com.tencent.mobileqq.leba.entity.n item, final com.tencent.mobileqq.leba.entity.f reportInfo) {
        ThreadRegulator.d().f(4);
        ThreadRegulator.d().g(4, 2000L);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.af
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginQzone.W(LebaPluginQzone.this, reportInfo, v3);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(LebaPluginQzone this$0, com.tencent.mobileqq.leba.entity.f reportInfo, View v3) {
        QZoneManagerImp qZoneManagerImp;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportInfo, "$reportInfo");
        Intrinsics.checkNotNullParameter(v3, "$v");
        this$0.enterQzone = true;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        } else {
            qZoneManagerImp = null;
        }
        if (qZoneManagerImp != null) {
            if (qZoneManagerImp.j(1) <= 0 && qZoneManagerImp.j(2) <= 0) {
                QZoneClickReport.ReportInfo reportInfo2 = new QZoneClickReport.ReportInfo();
                reportInfo2.actionType = "1";
                reportInfo2.subactionType = "0";
                reportInfo2.tabletype = 4;
                reportInfo2.sourceType = "3";
                reportInfo2.sourceFrom = QZoneClickReport.ClickReportConfig.SOURCE_FROM_MAINENTRY;
                reportInfo2.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_FRIENDFEED;
                QZoneClickReport.report(peekAppRuntime.getAccount(), reportInfo2, false);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "3");
                hashMap.put("source_from", QZoneClickReport.ClickReportConfig.SOURCE_FROM_MAINENTRY);
                hashMap.put("source_to", QZoneClickReport.ClickReportConfig.SOURCE_TO_FRIENDFEED);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(peekAppRuntime.getAccount(), StatisticCollector.QZONE_SOURCE_DATA_REPORT, true, 0L, 0L, hashMap, null);
            }
            et.a(qZoneManagerImp, false, reportInfo.f240480d);
            Context context = v3.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            com.tencent.mobileqq.service.report.b.d((Activity) context, true);
            LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this$0.redViewHolder;
            if (lebaPluginQzoneRedViewHolder != null) {
                lebaPluginQzoneRedViewHolder.J();
            }
        }
        LinkReport.reportClickQZoneEntry(peekAppRuntime.getCurrentUin());
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).preLaunchMiniAppCheckinFromLeba();
    }

    private final int X() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return 0;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.QZoneManagerImp");
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) manager;
        int j3 = qZoneManagerImp.j(1) + qZoneManagerImp.j(73);
        if (QZoneIntimateEntranceManager.u()) {
            QLog.i("LebaQzonePlugin", 4, "is frame moment switch open, show moment passive dot");
            j3 += qZoneManagerImp.j(66);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + qZoneManagerImp.j(1));
        }
        return j3;
    }

    private final void Y(QQAppInterface app) {
        Manager manager = app.getManager(QQManagerFactory.QZONE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.model.QZoneManager");
        com.tencent.mobileqq.model.c cVar = (com.tencent.mobileqq.model.c) manager;
        QLog.d("LebaQzonePlugin", 2, "getQZoneUnreadByLebaResume isItemClick = " + this.mIsItemClick);
        if (this.mIsItemClick) {
            if (QLog.isColorLevel()) {
                QLog.d("LebaQzonePlugin", 2, "getQzoneUnread by tab resume.");
            }
            cVar.Z(3);
        }
        cVar.Q0(false);
        this.mIsItemClick = false;
    }

    private final QZoneObserver Z() {
        return (QZoneObserver) this.qzob.getValue();
    }

    private final void a0(QZoneClearRedCountInfoEvent event) {
        QZoneManagerImp qZoneManagerImp;
        if (event == null) {
            return;
        }
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        } else {
            qZoneManagerImp = null;
        }
        if (qZoneManagerImp == null) {
            QLog.e("LebaQzonePlugin", 1, "qzone manager imp is null");
        } else {
            qZoneManagerImp.h(event.mCountId);
        }
    }

    private final void b0() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QZoneManagerImp qZoneManagerImp = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.i("LebaQzonePlugin", 1, "handerQzoneJumpScheme app == null");
            return;
        }
        com.tencent.mobileqq.statistics.t.a().g(qQAppInterface.getCurrentAccountUin());
        com.tencent.mobileqq.statistics.t.a().i(qQAppInterface.getCurrentAccountUin());
        com.tencent.mobileqq.perf.process.foregroud.b.f257916a.j("com.tencent.mobileqq:qzone");
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        }
        if (qZoneManagerImp != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d(LogTag.UNREAD, 4, "qq click action and clear active feed unread");
            }
            qZoneManagerImp.Q0(true);
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
    }

    private final int c0() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return 0;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.QZoneManagerImp");
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) manager;
        int j3 = qZoneManagerImp.j(2) + qZoneManagerImp.j(3);
        if (QZoneIntimateEntranceManager.u()) {
            QLog.i("LebaQzonePlugin", 4, "is frame moment switch open, show moment active dot");
            j3 += qZoneManagerImp.j(67);
        }
        if (!SimpleUIUtil.isNowElderMode()) {
            j3 += f0(qZoneManagerImp);
        }
        if (!QZoneApiProxy.needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime())) {
            j3 += g0(qZoneManagerImp);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + qZoneManagerImp.j(2) + " TYPE_VISITOR:" + qZoneManagerImp.j(3) + " TYPE INTIMATE: " + qZoneManagerImp.j(74));
        }
        QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + j3);
        return j3;
    }

    private final void d0(final int style) {
        QLog.d("LebaQzonePlugin", 2, "onResumeQzone ");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.ae
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginQzone.e0(LebaPluginQzone.this, style);
            }
        }, 5, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(LebaPluginQzone this$0, int i3) {
        QQAppInterface qQAppInterface;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QZoneManagerImp qZoneManagerImp = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        QZoneHelper.preloadQzone(qQAppInterface, QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK);
        this$0.Y(qQAppInterface);
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        }
        if (qZoneManagerImp != null) {
            if (!QZoneApiProxy.needShowQzoneFrame(qQAppInterface.getApplicationContext(), MobileQQ.sMobileQQ.peekAppRuntime())) {
                com.tencent.mobileqq.service.report.b.e(QBaseActivity.sTopActivity, true);
                ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).daTongExposeReport();
            }
            if (i3 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            et.a(qZoneManagerImp, true, z16);
            if (qZoneManagerImp.j(1) > 0) {
                QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
                reportInfo.actionType = "1";
                reportInfo.subactionType = "5";
                QZoneClickReport.report(qQAppInterface.getAccount(), reportInfo, false);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("unread_type", "5");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getAccount(), StatisticCollector.QZONE_UNREAD_DATA_REPORT, true, 0L, 0L, hashMap, null);
            } else if (qZoneManagerImp.j(2) > 0) {
                QZoneClickReport.ReportInfo reportInfo2 = new QZoneClickReport.ReportInfo();
                reportInfo2.actionType = "1";
                reportInfo2.subactionType = "6";
                QZoneClickReport.report(qQAppInterface.getAccount(), reportInfo2, false);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("unread_type", "6");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getAccount(), StatisticCollector.QZONE_UNREAD_DATA_REPORT, true, 0L, 0L, hashMap2, null);
            }
        }
        if (System.currentTimeMillis() - LocalMultiProcConfig.getLong(BaseApplication.getContext().getString(R.string.h4p) + qQAppInterface.getAccount(), 0L) > 86400000) {
            HashMap<String, String> hashMap3 = new HashMap<>();
            if (LocalMultiProcConfig.getBool(BaseApplication.getContext().getString(R.string.h4o) + qQAppInterface.getAccount(), true)) {
                hashMap3.put("myfeednotifypush", "0");
            } else {
                hashMap3.put("myfeednotifypush", "1");
            }
            if (com.tencent.mobileqq.servlet.d.k(BaseApplication.getContext(), "com.qzone")) {
                hashMap3.put("qzoneinstalled", "0");
            } else {
                hashMap3.put("qzoneinstalled", "1");
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getAccount(), StatisticCollector.QZONE_PUSH_STATE, true, 0L, 0L, hashMap3, null);
            LocalMultiProcConfig.putLong(BaseApplication.getContext().getString(R.string.h4p) + qQAppInterface.getAccount(), System.currentTimeMillis());
        }
    }

    private final int f0(QZoneManagerImp qim) {
        if (qim == null) {
            return 0;
        }
        int j3 = qim.j(74);
        QZoneCountInfo k3 = qim.k(74);
        if (j3 > 0 && k3 != null) {
            ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).saveRedCountInfo(74, k3);
        }
        QLog.i("LebaQzonePlugin", 4, "intimateUnreadCnt is " + j3);
        return j3;
    }

    private final int g0(QZoneManagerImp qim) {
        QZoneCountInfo k3;
        if (qim == null || (k3 = qim.k(1028)) == null || !((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).isValidPublishPlusIconRedDot(k3)) {
            return 0;
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "show publish icon count info");
        return 1;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
        if (lebaPluginQzoneRedViewHolder != null) {
            lebaPluginQzoneRedViewHolder.W();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void F() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.i("LebaQzonePlugin", 1, "onLebaTabChangeQzone app == null");
            return;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.model.QZoneManager");
        com.tencent.mobileqq.model.c cVar = (com.tencent.mobileqq.model.c) manager;
        QZoneNotifyServlet.F = true;
        if (QLog.isColorLevel()) {
            QLog.d("LebaQzonePlugin", 2, "click leba.test if get qzone unread.");
        }
        cVar.Z(3);
        LpReportInfo_pf00064.allReport(637, 31, 1);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
        if (lebaPluginQzoneRedViewHolder != null) {
            lebaPluginQzoneRedViewHolder.Y();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        QZoneHelper.sQZoneHCCode = HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{0}, 3000, 101, 4L, Process.myTid(), "bootQzone", true);
        QLog.d("LebaQzonePlugin", 1, "user clicked qzone feed entry.");
        QLog.d("friend_feed_launch", 1, "click friend feed");
        super.H(v3, item, reportInfo);
        V(v3, item, reportInfo);
        b0();
        this.mIsItemClick = true;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void I(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
            return;
        }
        d0(style);
        LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
        if (lebaPluginQzoneRedViewHolder != null) {
            lebaPluginQzoneRedViewHolder.Z();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void M() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.unRegistObserver(Z());
        }
        LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
        if (lebaPluginQzoneRedViewHolder != null) {
            lebaPluginQzoneRedViewHolder.a0();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void e() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.registObserver(Z());
        }
        LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
        if (lebaPluginQzoneRedViewHolder != null) {
            lebaPluginQzoneRedViewHolder.q();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QZoneClearRedCountInfoEvent>> getEventClass() {
        ArrayList<Class<QZoneClearRedCountInfoEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneClearRedCountInfoEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 20, (Object) this);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void h(@NotNull View v3, @Nullable com.tencent.mobileqq.leba.entity.n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        super.h(v3, item);
        boolean existQZoneActiveRedCountInfo = ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).existQZoneActiveRedCountInfo();
        this.refreshQZoneWithRedDot = existQZoneActiveRedCountInfo;
        QLog.i("LebaQzonePlugin", 1, "needRefreshQZone is " + existQZoneActiveRedCountInfo);
        ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).daTongClickReport();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public DefaultClickProcessor k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DefaultClickProcessor) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean l(int mode, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
        }
        if (style == 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public com.tencent.mobileqq.leba.entity.o m() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.leba.entity.o) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String entranceText = ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).getLebaEntranceText();
        if (!QQTheme.isNowSimpleUI() && !((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).isShowQZoneFrameForTeenage()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Intrinsics.checkNotNullExpressionValue(entranceText, "entranceText");
        if (z16) {
            i3 = R.drawable.krg;
        } else {
            i3 = R.drawable.evr;
        }
        int i16 = i3;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", Arrays.copyOf(new Object[]{MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), "tab_qzone"}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return new com.tencent.mobileqq.leba.entity.o(10000L, entranceText, i16, null, null, false, (short) 2, format, false, "friendmomt", FilterEnum.MIC_PTU_TRANS_XINXIAN, null);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
        if (lebaPluginQzoneRedViewHolder != null) {
            lebaPluginQzoneRedViewHolder.X();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) event);
        } else if (event instanceof QZoneClearRedCountInfoEvent) {
            a0((QZoneClearRedCountInfoEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Nullable
    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
        if (lebaPluginQzoneRedViewHolder != null) {
            return lebaPluginQzoneRedViewHolder.I();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 10000L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Nullable
    public RedTypeInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        int X = X();
        int c06 = c0();
        LebaTabRedTouch.e(X, c06);
        if (X > 0) {
            RedTypeInfo redTypeInfo = new RedTypeInfo();
            redTypeInfo.setRedType(5);
            redTypeInfo.setRedContent(String.valueOf(X));
            return redTypeInfo;
        }
        if (c06 > 0) {
            RedTypeInfo redTypeInfo2 = new RedTypeInfo();
            redTypeInfo2.setRedType(0);
            return redTypeInfo2;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        if (!isTableModel) {
            if (this.redViewHolder == null) {
                if (redTouch != null) {
                    view = redTouch.getTarget();
                } else {
                    view = null;
                }
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.RelativeLayout");
                this.redViewHolder = new LebaPluginQzoneRedViewHolder((RelativeLayout) view);
            }
            LebaPluginQzoneRedViewHolder lebaPluginQzoneRedViewHolder = this.redViewHolder;
            if (lebaPluginQzoneRedViewHolder != null) {
                Intrinsics.checkNotNull(redTouch);
                BaseLebaPluginItem.g(this, redTouch, lebaPluginQzoneRedViewHolder.r(), null, 4, null);
                lebaPluginQzoneRedViewHolder.b0();
            }
        }
        return true;
    }
}
