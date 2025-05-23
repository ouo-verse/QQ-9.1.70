package com.tencent.qqnt.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.homework.handler.HomeworkHandler;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.troopmemberlist.TroopMemberDBExtInfoRepo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t*\u0001#\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/helper/TroopHomeworkCheckRoleHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Landroid/content/BroadcastReceiver;", "", "e", "", "c", "", "getId", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "", "d", "Ljava/lang/Boolean;", "isHwTroop", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "f", "Z", "hadRegisterBroadcast", h.F, "hadAddObserver", "com/tencent/qqnt/helper/TroopHomeworkCheckRoleHelper$b", "i", "Lcom/tencent/qqnt/helper/TroopHomeworkCheckRoleHelper$b;", "homeworkObserver", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopHomeworkCheckRoleHelper extends BroadcastReceiver implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final Map<String, Boolean> C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isHwTroop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hadRegisterBroadcast;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hadAddObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b homeworkObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/helper/TroopHomeworkCheckRoleHelper$a;", "", "", "TAG", "Ljava/lang/String;", "", "", "hadCheckRole", "Ljava/util/Map;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.helper.TroopHomeworkCheckRoleHelper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/helper/TroopHomeworkCheckRoleHelper$b", "Lcom/tencent/mobileqq/troop/homework/observer/a;", "", "isSuccess", "", "troopUin", "memberUin", "", "identity", "course", "stuName", "", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends com.tencent.mobileqq.troop.homework.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHomeworkCheckRoleHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.observer.a
        public void d(boolean isSuccess, @Nullable String troopUin, @Nullable String memberUin, int identity, @Nullable String course, @Nullable String stuName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, memberUin, Integer.valueOf(identity), course, stuName);
                return;
            }
            QLog.d("TroopHomeworkCheckRoleHelper", 1, "onGetHomeworkTroopIdentity: troopUin=" + troopUin + ", memberUin=" + memberUin + ", check role=" + identity);
            if (troopUin != null && memberUin != null) {
                TroopMemberDBExtInfoRepo.INSTANCE.updateHwIdentity(troopUin, memberUin, identity, "TroopHomeworkCheckRoleHelper");
                TroopHomeworkCheckRoleHelper.C.put(TroopHomeworkCheckRoleHelper.this.e(), Boolean.TRUE);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
            C = new LinkedHashMap();
        }
    }

    public TroopHomeworkCheckRoleHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.homeworkObserver = new b();
        }
    }

    private final void c() {
        BusinessHandler businessHandler;
        HomeworkHandler homeworkHandler;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Context context = aVar.c().getContext();
        if (context != null) {
            context.registerReceiver(this, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        }
        this.hadRegisterBroadcast = true;
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar2 = null;
        }
        String j3 = aVar2.g().r().c().j();
        if (!Intrinsics.areEqual(C.get(e()), Boolean.TRUE)) {
            AppInterface e16 = bg.e();
            if (e16 != null) {
                e16.addObserver(this.homeworkObserver);
            }
            this.hadAddObserver = true;
            AppInterface e17 = bg.e();
            if (e17 != null) {
                businessHandler = e17.getBusinessHandler(HomeworkHandler.class.getName());
            } else {
                businessHandler = null;
            }
            if (businessHandler instanceof HomeworkHandler) {
                homeworkHandler = (HomeworkHandler) businessHandler;
            } else {
                homeworkHandler = null;
            }
            AppInterface e18 = bg.e();
            if (e18 != null) {
                str = e18.getCurrentUin();
            }
            if (homeworkHandler != null) {
                homeworkHandler.w2(j3, str);
            }
            QLog.d("TroopHomeworkCheckRoleHelper", 1, "doOnCreate: first launch, check role, troopUin=" + j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        String j3 = aVar.g().r().c().j();
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentUin();
        }
        return j3 + "-" + str;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.A1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopHomeworkCheckRoleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (this.isHwTroop == null) {
            TroopInfo troopInfo = null;
            if (a16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                a16 = null;
            }
            if (a16.g().r().c().e() != 2) {
                this.isHwTroop = Boolean.FALSE;
                return;
            }
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            String j3 = aVar.g().r().c().j();
            ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
            if (iTroopInfoService != null) {
                troopInfo = iTroopInfoService.findTroopInfo(j3, false, false);
            }
            if (troopInfo != null) {
                bool = Boolean.valueOf(troopInfo.isHomeworkTroop());
            } else {
                bool = Boolean.FALSE;
            }
            this.isHwTroop = bool;
        }
        if (Intrinsics.areEqual(this.isHwTroop, Boolean.FALSE)) {
            return;
        }
        c();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        AppInterface e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        h.a.b(this);
        if (this.hadRegisterBroadcast) {
            try {
                com.tencent.aio.api.runtime.a aVar = this.aioContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar = null;
                }
                Context context = aVar.c().getContext();
                if (context != null) {
                    context.unregisterReceiver(this);
                }
            } catch (IllegalArgumentException e17) {
                QLog.e("TroopHomeworkCheckRoleHelper", 1, "onDestroy: ", e17);
            }
        }
        this.hadRegisterBroadcast = false;
        if (this.hadAddObserver && (e16 = bg.e()) != null) {
            e16.removeObserver(this.homeworkObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        String str2;
        String str3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String str4 = null;
        if (intent != null) {
            str = intent.getStringExtra("event");
        } else {
            str = null;
        }
        if (intent != null) {
            str2 = intent.getStringExtra("data");
        } else {
            str2 = null;
        }
        if (intent != null) {
            str3 = intent.getAction();
        } else {
            str3 = null;
        }
        if (Intrinsics.areEqual("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT", str3) && Intrinsics.areEqual(IHWTroopUtilsApi.HW_TROOP_IDENTITY_CHANGED_EVENT, str)) {
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("groupCode");
                    com.tencent.aio.api.runtime.a aVar = this.aioContext;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                        aVar = null;
                    }
                    if (!TextUtils.equals(optString, aVar.g().r().c().j())) {
                        return;
                    }
                    String optString2 = jSONObject.optString("source");
                    int optInt = jSONObject.optInt("rankId", 333);
                    String optString3 = jSONObject.optString("uin");
                    AppInterface e16 = bg.e();
                    if (e16 != null) {
                        str4 = e16.getCurrentUin();
                    }
                    if (!Intrinsics.areEqual(IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE, optString2) && TextUtils.equals(optString3, str4)) {
                        QLog.d("TroopHomeworkCheckRoleHelper", 1, "onReceive: hw role change, troopUin=" + optString + ", memberUin=" + optString3 + ", new role=" + optInt);
                        TroopMemberDBExtInfoRepo.INSTANCE.updateHwIdentity(optString, optString3, optInt, "TroopHomeworkCheckRoleHelper");
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }
}
