package com.tencent.mobileqq.qqlive.sail.ui.huyaprivacy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.huya.j;
import com.tencent.mobileqq.qqlive.sail.model.ReportExtKt;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015`\u0016H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/huyaprivacy/b;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qqlive/sail/ui/huyaprivacy/QQLiveExitRoomEvent;", "", "pa", "", "ma", "qa", "", "timeStamp1", "timeStamp2", "na", "", "la", "U9", "V9", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "<init>", "()V", "e", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends com.tencent.mobileqq.qqlive.sail.base.c implements SimpleEventReceiver<QQLiveExitRoomEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/huyaprivacy/b$a;", "", "", "MMKV_KEY_HUYA_PRIVACY_AGREED", "Ljava/lang/String;", "MMKV_KEY_HUYA_PRIVACY_LATEST_AGREED_TS", "", "PRIVACY_AGREED", "I", "PRIVACY_TYPE_HUYA", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.huyaprivacy.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/huyaprivacy/b$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Ltr4/b;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.huyaprivacy.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8392b implements ILiveNetRequest.Callback<tr4.b> {
        static IPatchRedirector $redirector_;

        C8392b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<tr4.b> response) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            if (!response.isFailed() && response.getRsp() != null) {
                QLog.i("Audience|QQLiveHuyaPrivacyPart", 1, "onEnterRoom getPrivacySetting success");
                tr4.b rsp = response.getRsp();
                Intrinsics.checkNotNull(rsp, "null cannot be cast to non-null type com.tencent.trpcprotocol.qlive.trpc_user_privacy_settings.user_privacy_settings.nano.GetPrivacySettingRsp");
                tr4.c cVar = rsp.f437219a;
                if (cVar == null) {
                    return;
                }
                QLog.i("Audience|QQLiveHuyaPrivacyPart", 1, "onEnterRoom privacy setting status: " + cVar.f437221b);
                if (cVar.f437221b != 1) {
                    b.this.pa();
                    return;
                } else {
                    b.this.qa();
                    return;
                }
            }
            QLog.w("Audience|QQLiveHuyaPrivacyPart", 1, "onEnterRoom getPrivacySetting failed, errCode=" + response.getRetCode() + ", errMsg=" + response.getErrMsg());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String la() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentUin();
        }
        return null;
    }

    private final boolean ma() {
        boolean z16;
        boolean z17;
        String la5 = la();
        if (la5 != null && la5.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("Audience|QQLiveHuyaPrivacyPart", 1, "isPrivacyAgreed uin null");
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
        long decodeLong = from.decodeLong("mmkv_key_huya_privacy_latest_agreed_ts_" + la5, 0L);
        if (decodeLong != 0 && na(System.currentTimeMillis(), decodeLong)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (from.decodeBool("mmkv_key_huya_privacy_agreed_" + la5, false)) {
                return true;
            }
        }
        return false;
    }

    private final boolean na(long timeStamp1, long timeStamp2) {
        Date date = new Date(timeStamp1);
        Date date2 = new Date(timeStamp2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        return Intrinsics.areEqual(simpleDateFormat.format(date), simpleDateFormat.format(date2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e eVar = null;
        this$0.broadcastMessage("onExitRoom", null);
        f F9 = this$0.F9();
        if (F9 instanceof e) {
            eVar = (e) F9;
        }
        e eVar2 = eVar;
        if (eVar2 != null) {
            ReportExtKt.b(eVar2, "exit", null, null, null, 14, null);
        }
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa() {
        String a16;
        boolean z16;
        if (!R9()) {
            QLog.w("Audience|QQLiveHuyaPrivacyPart", 1, "openPrivacyDialog isEnteredRoom false");
            return;
        }
        j jVar = (j) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102401");
        if (jVar != null && (a16 = jVar.a()) != null) {
            if (a16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String str = a16 + "&room_id=" + H9();
                QLog.i("Audience|QQLiveHuyaPrivacyPart", 1, "openPrivacyDialog jump privacy scheme: " + str);
                if (getContext() == null) {
                    return;
                }
                Intent intent = new Intent(getContext(), (Class<?>) JumpActivity.class);
                intent.setData(Uri.parse(str));
                if (!(getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                getContext().startActivity(intent);
                c.f272776a.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        boolean z16;
        String la5 = la();
        if (la5 != null && la5.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("Audience|QQLiveHuyaPrivacyPart", 1, "savePrivacyAgreed uin null");
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
        from.encodeBool("mmkv_key_huya_privacy_agreed_" + la5, true);
        from.encodeLong("mmkv_key_huya_privacy_latest_agreed_ts_" + la5, System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.U9();
        SimpleEventBus.getInstance().registerReceiver(this);
        QLog.d("Audience|QQLiveHuyaPrivacyPart", 1, "onEnterRoom roomId=" + H9() + ", anchorId=" + C9());
        if (ma()) {
            return;
        }
        ((ILiveRoomInteractiveApi) QRoute.api(ILiveRoomInteractiveApi.class)).getPrivacySetting(1, new C8392b());
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.V9();
        c.f272776a.b(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QQLiveExitRoomEvent>> getEventClass() {
        ArrayList<Class<QQLiveExitRoomEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQLiveExitRoomEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
            return;
        }
        if (!(event instanceof QQLiveExitRoomEvent)) {
            QLog.d("Audience|QQLiveHuyaPrivacyPart", 1, "onReceiveEvent event not match: " + event);
            return;
        }
        if (((QQLiveExitRoomEvent) event).getRoomId() != H9()) {
            QLog.d("Audience|QQLiveHuyaPrivacyPart", 1, "onReceiveEvent roomId not match: " + event + ".roomId, " + H9());
            return;
        }
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.huyaprivacy.a
            @Override // java.lang.Runnable
            public final void run() {
                b.oa(b.this);
            }
        });
    }
}
