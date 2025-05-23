package com.tencent.mobileqq.troop.trooptodo;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.trooptodo.TodoInfoPresenter;
import com.tencent.mobileqq.troop.trooptodo.d;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.troop.TroopListRepo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00af\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t*\u0001E\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0018B\u0007\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J)\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00102\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010'\u001a\u00020&H\u0016J7\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u00102\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00103R\u0016\u00105\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00103R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010:R\u0016\u0010=\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR&\u0010L\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020E0I0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0016\u0010[\u001a\u0004\u0018\u00010X8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010]\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010V\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoHelper;", "Lcom/tencent/qqnt/aio/toptips/a;", "Lut2/a;", "Lcom/tencent/mobileqq/aio/notification/e;", "", "onResume", "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/troop/trooptodo/d;", "model", "t", "v", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$c;", "uiModel", "", "event", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "params", "Landroid/view/View;", "a", "([Ljava/lang/Object;)Landroid/view/View;", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "eventType", "g", "(Lcom/tencent/qqnt/aio/toptips/c;I[Ljava/lang/Object;)V", "", "isSuccess", "data", "k", "i", "c", "f", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "e", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", tl.h.F, "", "d", "Ljava/lang/String;", "troopUin", "Z", "isFirstEnterGroup", "isShowing", "Lcom/tencent/mobileqq/troop/trooptodo/k;", "Lcom/tencent/mobileqq/troop/trooptodo/k;", "troopToDoTipsBar", "Lcom/tencent/mobileqq/troop/trooptodo/g;", "Lcom/tencent/mobileqq/troop/trooptodo/g;", "troopToDoObserver", "Lcom/tencent/qqnt/aio/toptips/c;", "tipsManager", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$c;", "notification", "Lcom/tencent/mobileqq/troop/trooptodo/TodoInfoPresenter$c;", "D", "Lcom/tencent/mobileqq/troop/trooptodo/TodoInfoPresenter$c;", "infoListener", "com/tencent/mobileqq/troop/trooptodo/TroopToDoHelper$b", "E", "Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoHelper$b;", "action", "Lkotlin/Pair;", UserInfo.SEX_FEMALE, "Ljava/util/List;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoReporter;", "G", "Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoReporter;", "reporter", "Lcom/tencent/common/app/AppInterface;", "r", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "j", "()I", "barPriority", "", "b", "()[I", "excludeTypes", "getType", "type", "<init>", "()V", "H", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopToDoHelper extends com.tencent.qqnt.aio.toptips.a implements ut2.a, com.tencent.mobileqq.aio.notification.e {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private IAIONotificationUIModel.c notification;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TodoInfoPresenter.c infoListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> msgList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TroopToDoReporter reporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstEnterGroup;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k troopToDoTipsBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g troopToDoObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.aio.toptips.c tipsManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/TroopToDoHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.trooptodo.TroopToDoHelper$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/trooptodo/TroopToDoHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            if ((i3 instanceof MsgNavigationEvent.NavigationResultNotify) && !((MsgNavigationEvent.NavigationResultNotify) i3).c()) {
                QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.f170224yr2), 0).show();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/trooptodo/TroopToDoHelper$c", "Lcom/tencent/mobileqq/troop/trooptodo/TodoInfoPresenter$c;", "Lcom/tencent/mobileqq/troop/trooptodo/d;", "model", "", "a", "Lcom/tencent/mobileqq/troop/trooptodo/TodoInfoPresenter$ErrorType;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements TodoInfoPresenter.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopToDoHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.trooptodo.TodoInfoPresenter.c
        public void a(@Nullable d model) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopToDoHelper.this.t(model);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
            }
        }

        @Override // com.tencent.mobileqq.troop.trooptodo.TodoInfoPresenter.c
        public void b(@NotNull TodoInfoPresenter.ErrorType errorType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorType);
                return;
            }
            Intrinsics.checkNotNullParameter(errorType, "errorType");
            QLog.e("TroopToDoHelper", 1, "ITodoInfoListener.onError invoke, errorType = " + errorType);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61979);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopToDoHelper() {
        List<Pair<String, b>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isFirstEnterGroup = true;
        this.troopToDoObserver = new g(this);
        this.infoListener = new c();
        b bVar = new b();
        this.action = bVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(MsgNavigationEvent.NavigationResultNotify.class)), bVar));
        this.msgList = listOf;
        this.reporter = new TroopToDoReporter();
    }

    private final void onDestroy() {
        q();
        r().removeObserver(this.troopToDoObserver);
        TodoInfoPresenter.m().j();
        this.troopUin = null;
        this.isFirstEnterGroup = true;
        this.troopToDoTipsBar = null;
        Iterator<T> it = this.msgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
                cVar = null;
            }
            cVar.a().e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    private final void onResume() {
        if (this.isFirstEnterGroup) {
            com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
                cVar = null;
            }
            this.troopUin = cVar.a().g().r().c().j();
            r().addObserver(this.troopToDoObserver);
            TodoInfoPresenter.m().f(r(), this.infoListener);
            w();
        } else {
            v();
        }
        this.isFirstEnterGroup = false;
        Iterator<T> it = this.msgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.qqnt.aio.toptips.c cVar2 = this.tipsManager;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
                cVar2 = null;
            }
            com.tencent.mvi.base.route.j e16 = cVar2.a().e();
            String str = (String) pair.getFirst();
            com.tencent.mvi.base.route.a aVar = (com.tencent.mvi.base.route.a) pair.getSecond();
            com.tencent.qqnt.aio.toptips.c cVar3 = this.tipsManager;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
                cVar3 = null;
            }
            LifecycleOwner d16 = cVar3.a().d();
            Intrinsics.checkNotNullExpressionValue(d16, "tipsManager.getAioContext().lifecycleOwner");
            e16.c(str, aVar, d16);
        }
    }

    private final void q() {
        QLog.i("TroopToDoHelper", 2, "dismiss: ");
        this.isShowing = false;
        com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
            cVar = null;
        }
        cVar.i(this, true);
        n.j(false);
        n.b();
    }

    private final AppInterface r() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(IAIONotificationUIModel.c uiModel, int event) {
        k kVar;
        if (event != 1) {
            if (event != 2) {
                if (event == 3 && !Intrinsics.areEqual(uiModel.d(), BaseApplication.getContext().getString(R.string.f236647ex)) && (kVar = this.troopToDoTipsBar) != null) {
                    kVar.m();
                    return;
                }
                return;
            }
            k kVar2 = this.troopToDoTipsBar;
            if (kVar2 != null) {
                kVar2.k();
                return;
            }
            return;
        }
        com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
            cVar = null;
        }
        ((com.tencent.mobileqq.aio.notification.c) cVar).k();
        k kVar3 = this.troopToDoTipsBar;
        if (kVar3 != null) {
            kVar3.j();
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(d model) {
        AppInterface appInterface;
        if (model == null || !Intrinsics.areEqual(String.valueOf(model.c().f301780a), this.troopUin)) {
            return;
        }
        if (this.troopToDoTipsBar == null) {
            com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
                cVar = null;
            }
            this.troopToDoTipsBar = new k(cVar.a(), this.reporter);
        }
        if (model.c().f301783d != 2 && model.c().f301783d != 4) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopToDoHelper", 2, "initTroopToDoTipsBarAndShow: mode=" + model);
            }
            k kVar = this.troopToDoTipsBar;
            if (kVar != null) {
                kVar.r(model);
            }
            IAIONotificationUIModel.c cVar2 = this.notification;
            if (cVar2 != null) {
                String b16 = model.b();
                Intrinsics.checkNotNullExpressionValue(b16, "model.content");
                cVar2.k(b16);
            }
            z();
            this.reporter.e(r(), model);
            if (model.c().f301783d == 3) {
                u(model);
                return;
            }
            if (model.c().f301783d != 1 || (appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            if (n.d(appInterface, model.c().f301780a)) {
                u(model);
                return;
            } else {
                q();
                return;
            }
        }
        QLog.i("TroopToDoHelper", 1, "initTroopToDoTipsBarAndShow: taskstatus error");
        q();
    }

    private final void u(d model) {
        com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
            cVar = null;
        }
        boolean e16 = cVar.e(this);
        this.isShowing = e16;
        QLog.i("TroopToDoHelper", 2, "show: success=" + e16);
        n.j(true);
        n.i(model);
        this.reporter.h();
    }

    private final void v() {
        if (this.isShowing) {
            this.reporter.h();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.tencent.mobileqq.data.troop.TroopInfo] */
    private final void w() {
        Long longOrNull;
        final String str = this.troopUin;
        if (str != null) {
            final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.troop.trooptodo.e
                @Override // java.lang.Runnable
                public final void run() {
                    TroopToDoHelper.x(TroopToDoHelper.this);
                }
            };
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(str);
            objectRef.element = troopInfoFromCache;
            if (troopInfoFromCache == 0) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                if (longOrNull != null) {
                    long longValue = longOrNull.longValue();
                    s i3 = bg.i(null, 1, null);
                    if (i3 != null) {
                        i3.getGroupDetailInfo(longValue, GroupInfoSource.KAIO, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.trooptodo.f
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                            public final void onResult(int i16, String str2) {
                                TroopToDoHelper.y(Ref.ObjectRef.this, str, this, runnable, i16, str2);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void x(TroopToDoHelper this$0) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.troopUin;
        if (str != null && longOrNull != null) {
            TodoInfoPresenter.m().H(longOrNull.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.tencent.mobileqq.data.troop.TroopInfo] */
    public static final void y(Ref.ObjectRef troopInfo, String realTroopUin, TroopToDoHelper this$0, Runnable next, int i3, String str) {
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        Intrinsics.checkNotNullParameter(realTroopUin, "$realTroopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(next, "$next");
        ?? troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(realTroopUin);
        troopInfo.element = troopInfoFromCache;
        if (troopInfoFromCache == 0) {
            QLog.i("TroopToDoHelper", 1, "[tryRequestByEnterGroup] troopInfo is null, troopUin:" + this$0.troopUin);
        }
        next.run();
    }

    private final void z() {
        String str;
        IAIONotificationUIModel.c cVar = this.notification;
        if (cVar != null) {
            k kVar = this.troopToDoTipsBar;
            if (kVar == null || (str = kVar.e()) == null) {
                str = "";
            }
            cVar.j(str);
            com.tencent.qqnt.aio.toptips.c cVar2 = this.tipsManager;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
                cVar2 = null;
            }
            Intrinsics.checkNotNull(cVar2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationManager");
            ((com.tencent.mobileqq.aio.notification.c) cVar2).j(cVar.getToken(), cVar);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return null;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // ut2.a
    public void c(boolean isSuccess, @Nullable Object data) {
        d d16;
        d.b c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(isSuccess), data);
            return;
        }
        QLog.i("TroopToDoHelper", 2, "handleCompleteTask invoke, isSuccess = " + isSuccess);
        if (!isSuccess) {
            String string = BaseApplication.getContext().getString(R.string.f236567ep);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026do_complete_failed_toast)");
            QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
            return;
        }
        k kVar = this.troopToDoTipsBar;
        if (kVar == null) {
            QLog.e("TroopToDoHelper", 1, "handleCompleteTask troopToDoTipsBar == null");
            return;
        }
        if (kVar != null && (d16 = kVar.d()) != null && (c16 = d16.c()) != null) {
            long j3 = c16.f301780a;
            if (n.d(r(), j3)) {
                k kVar2 = this.troopToDoTipsBar;
                if (kVar2 != null) {
                    kVar2.p();
                }
                z();
            } else {
                QLog.i("TroopToDoHelper", 4, "TroopToDoTipsBar \u4e0d\u5c55\u793a: \u666e\u901a\u6210\u5458handleCompleteTask");
                q();
            }
            TodoInfoPresenter.m().G(j3);
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    @NotNull
    public IAIONotificationUIModel e() {
        d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IAIONotificationUIModel) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.notification == null) {
            String str = null;
            ThemeUtil.isNowThemeIsNight(r(), false, null);
            IAIONotificationUIModel.c.Companion companion = IAIONotificationUIModel.c.INSTANCE;
            AIONotificationBusiId aIONotificationBusiId = AIONotificationBusiId.TROOP_TODO;
            k kVar = this.troopToDoTipsBar;
            if (kVar != null && (d16 = kVar.d()) != null) {
                str = d16.b();
            }
            if (str == null) {
                str = "";
            }
            this.notification = companion.a(aIONotificationBusiId, "[\u7fa4\u5f85\u529e]", str, new Function2<IAIONotificationUIModel, Integer, Unit>() { // from class: com.tencent.mobileqq.troop.trooptodo.TroopToDoHelper$getNotificationUIModel$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopToDoHelper.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                    invoke(iAIONotificationUIModel, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IAIONotificationUIModel uiModel, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uiModel, i3);
                    } else {
                        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
                        TroopToDoHelper.this.s((IAIONotificationUIModel.c) uiModel, i3);
                    }
                }
            });
        }
        IAIONotificationUIModel.c cVar = this.notification;
        if (cVar != null) {
            cVar.i(IAIONotificationUIModel.ActionIcon.CLOSE);
        }
        z();
        IAIONotificationUIModel.c cVar2 = this.notification;
        Intrinsics.checkNotNull(cVar2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationUIModel");
        return cVar2;
    }

    @Override // ut2.a
    public void f(boolean isSuccess, @Nullable Object data) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(isSuccess), data);
            return;
        }
        QLog.d("TroopToDoHelper", 1, "handleAddTask invoke, isSuccess=" + isSuccess + ", data=" + data);
        if (!isSuccess) {
            String string = BaseApplication.getContext().getString(R.string.f236527el);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026p_to_do_add_failed_toast)");
            QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
            return;
        }
        if ((data instanceof Integer) && Intrinsics.areEqual(data, (Object) 300225)) {
            String string2 = BaseApplication.getContext().getString(R.string.f236537em);
            Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026p_to_do_add_has_been_set)");
            QQToast.makeText(BaseApplication.getContext(), 1, string2, 0).show();
        }
        String str = this.troopUin;
        if (str != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        } else {
            l3 = null;
        }
        if (l3 != null) {
            TodoInfoPresenter.m().I(l3.longValue());
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NotNull com.tencent.qqnt.aio.toptips.c topTipsManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, topTipsManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(topTipsManager, "topTipsManager");
        Intrinsics.checkNotNullParameter(params, "params");
        this.tipsManager = topTipsManager;
        if (topTipsManager.a().g().r().c().e() != 2) {
            return;
        }
        if (eventType != 1004) {
            if (eventType == 1007) {
                onResume();
                return;
            }
            return;
        }
        onDestroy();
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 110;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(AIONotificationBusiId.TROOP_TODO);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 13, (Object) this);
    }

    @Override // ut2.a
    public void i(boolean isSuccess, @Nullable Object data) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(isSuccess), data);
            return;
        }
        QLog.i("TroopToDoHelper", 2, "handleRecallTask invoke, isSuccess = " + isSuccess + " data = " + data);
        if (!isSuccess) {
            String string = BaseApplication.getContext().getString(R.string.f236637ew);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026o_do_recall_failed_toast)");
            QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
            return;
        }
        if ((data instanceof Integer) && Intrinsics.areEqual(data, (Object) 300213)) {
            String string2 = BaseApplication.getContext().getString(R.string.f236577eq);
            Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026_to_do_has_been_recalled)");
            QQToast.makeText(BaseApplication.getContext(), 1, string2, 0).show();
        }
        q();
        String str = this.troopUin;
        if (str != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        } else {
            l3 = null;
        }
        if (l3 != null) {
            TodoInfoPresenter.m().G(l3.longValue());
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 12;
    }

    @Override // ut2.a
    public void k(boolean isSuccess, @Nullable Object data) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(isSuccess), data);
            return;
        }
        QLog.i("TroopToDoHelper", 2, "handleCloseTask invoke, isSuccess = " + isSuccess);
        if (!isSuccess) {
            String string = BaseApplication.getContext().getString(R.string.f236557eo);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026to_do_close_failed_toast)");
            QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
            return;
        }
        q();
        String str = this.troopUin;
        if (str != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        } else {
            l3 = null;
        }
        if (l3 != null) {
            TodoInfoPresenter.m().G(l3.longValue());
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        g((com.tencent.qqnt.aio.toptips.c) notificationManager, eventType, params);
    }
}
