package com.tencent.mobileqq.troop.troopaiobanner;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\b\u0010\r\u001a\u00020\u0007H\u0016R\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopaiobanner/c;", "Lmqq/manager/Manager;", "", "troopUin", "", "bizType", "msgId", "", "c", "Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerModel;", "b", "bizId", "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Ljava/util/Map;", "bannerModelMap", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", "e", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", "studyModeChangeListener", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, TroopAIONotifyBannerModel> bannerModelMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StudyModeChangeListener studyModeChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopaiobanner/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopaiobanner.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62372);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
            return;
        }
        this.bannerModelMap = new LinkedHashMap();
        StudyModeChangeListener studyModeChangeListener = new StudyModeChangeListener() { // from class: com.tencent.mobileqq.troop.troopaiobanner.b
            @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
            public final void onChange(boolean z16) {
                c.e(c.this, z16);
            }
        };
        this.studyModeChangeListener = studyModeChangeListener;
        StudyModeManager.H(studyModeChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopAIONotifyBannerManager", 1, "[onStudyModeChanged] isStudyMode:" + z16);
        Iterator<T> it = this$0.bannerModelMap.entrySet().iterator();
        while (it.hasNext()) {
            ((TroopAIONotifyBannerModel) ((Map.Entry) it.next()).getValue()).l(z16);
        }
    }

    @NotNull
    public final TroopAIONotifyBannerModel b(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopAIONotifyBannerModel) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopAIONotifyBannerModel troopAIONotifyBannerModel = this.bannerModelMap.get(troopUin);
        if (troopAIONotifyBannerModel == null) {
            TroopAIONotifyBannerModel troopAIONotifyBannerModel2 = new TroopAIONotifyBannerModel(troopUin);
            this.bannerModelMap.put(troopUin, troopAIONotifyBannerModel2);
            return troopAIONotifyBannerModel2;
        }
        return troopAIONotifyBannerModel;
    }

    public final void c(@NotNull String troopUin, int bizType, @NotNull String msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, Integer.valueOf(bizType), msgId);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        QLog.i("TroopAIONotifyBannerManager", 1, "[handleReceiveMsg] troopUin = " + troopUin + ", bizType = " + bizType + " msgId = " + msgId);
        if (bizType == 0) {
            return;
        }
        if (bizType == 9 && ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).skipSecurityPush()) {
            return;
        }
        b(troopUin).i(bizType, msgId);
    }

    public final void d(@NotNull String troopUin, @NotNull String bizId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) bizId);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        b(troopUin).h(troopUin, bizId);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            StudyModeManager.U(this.studyModeChangeListener);
            this.bannerModelMap.clear();
        }
    }
}
