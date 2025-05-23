package com.tencent.mobileqq.troop.troopinfoedit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.m;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.pb.troop.bindgame.GCBindGroup$GCBindGroupSsoServerReq;
import com.tencent.pb.troop.bindgame.GCBindGroup$GCBindGroupSsoServerRsp;
import com.tencent.pb.troop.bindgame.GCBindGroup$QQBindInfo;
import com.tencent.pb.troop.bindgame.GCBindGroup$QQGroupBind;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\u0004\b \u0010!JP\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022>\u0010\r\u001a:\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004j\u0004\u0018\u0001`\fH\u0002JB\u0010\u0010\u001a\u00020\u000b2:\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fJ\u0006\u0010\u0011\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u000bH\u0014JN\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052>\u0010\r\u001a:\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004j\u0004\u0018\u0001`\fJ1\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00052!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u000b0\u0016R\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/pb/troop/bindgame/GCBindGroup$GCBindGroupSsoServerRsp;", "rsp", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "gameName", "", "gameBindStatus", "", "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameStatusUpdateCallback;", "callback", "O1", "statusUpdateCallback", "P1", "R1", "onCleared", "troopUin", "M1", "mTroopUin", "Lkotlin/Function1;", "Q1", "i", "Ljava/lang/String;", "N1", "()Ljava/lang/String;", "Landroid/content/BroadcastReceiver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/BroadcastReceiver;", "gameBindBroadcastReceiver", "<init>", "(Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGameVM extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BroadcastReceiver gameBindBroadcastReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameVM$a;", "", "", "GTE_GAME_BIND_STATUS_CMD", "Ljava/lang/String;", "GTE_GAME_BIND_STATUS_EXT_CMD", "TAG", "UNBIND_GAME_CMD", "UNBIND_GAME_EXT_CMD", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameVM$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopinfoedit/TroopBindGameVM$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<String, Integer, Unit> f300464e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super String, ? super Integer, Unit> function2) {
            this.f300464e = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBindGameVM.this, (Object) function2);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            QLog.i("TroopBindGameVM", 1, "[fetchGameBindStatus] onResult errorCode = " + errorCode);
            if (errorCode == 0 && data != null) {
                try {
                    GCBindGroup$GCBindGroupSsoServerRsp gCBindGroup$GCBindGroupSsoServerRsp = new GCBindGroup$GCBindGroupSsoServerRsp();
                    gCBindGroup$GCBindGroupSsoServerRsp.mergeFrom(data);
                    TroopBindGameVM.this.O1(gCBindGroup$GCBindGroupSsoServerRsp, this.f300464e);
                } catch (InvalidProtocolBufferMicroException unused) {
                    QLog.e("TroopBindGameVM", 1, "[fetchGameBindStatus] parse game bind status failed");
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopinfoedit/TroopBindGameVM$c", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<GCBindGroup$GCBindGroupSsoServerRsp, Unit> f300465d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super GCBindGroup$GCBindGroupSsoServerRsp, Unit> function1) {
            this.f300465d = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            QLog.i("TroopBindGameVM", 1, "[unBindGameTroop] onResult errorCode = " + errorCode);
            if (errorCode == 0 && data != null) {
                try {
                    GCBindGroup$GCBindGroupSsoServerRsp gCBindGroup$GCBindGroupSsoServerRsp = new GCBindGroup$GCBindGroupSsoServerRsp();
                    gCBindGroup$GCBindGroupSsoServerRsp.mergeFrom(data);
                    this.f300465d.invoke(gCBindGroup$GCBindGroupSsoServerRsp);
                } catch (InvalidProtocolBufferMicroException unused) {
                    QLog.e("TroopBindGameVM", 1, "[unBindGameTroop] parse game unbind failed");
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopBindGameVM(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
        } else {
            this.troopUin = troopUin;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O1(GCBindGroup$GCBindGroupSsoServerRsp rsp, Function2<? super String, ? super Integer, Unit> callback) {
        String str;
        int i3;
        boolean z16;
        PBStringField pBStringField;
        int i16 = rsp.ret.get();
        GCBindGroup$QQBindInfo gCBindGroup$QQBindInfo = rsp.bind_info;
        if (gCBindGroup$QQBindInfo != null && (pBStringField = gCBindGroup$QQBindInfo.app_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (i16 != -3000005) {
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = 1;
                if (callback != null) {
                    callback.invoke(str, Integer.valueOf(i3));
                }
                QLog.i("TroopBindGameVM", 1, "[onGetGameBindStatus] ret=" + i16 + ", status = " + i3 + ", name = " + str);
            }
        }
        i3 = 2;
        if (callback != null) {
        }
        QLog.i("TroopBindGameVM", 1, "[onGetGameBindStatus] ret=" + i16 + ", status = " + i3 + ", name = " + str);
    }

    public final void M1(@NotNull String troopUin, @Nullable Function2<? super String, ? super Integer, Unit> callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            GCBindGroup$GCBindGroupSsoServerReq gCBindGroup$GCBindGroupSsoServerReq = new GCBindGroup$GCBindGroupSsoServerReq();
            gCBindGroup$GCBindGroupSsoServerReq.cmd.set("get_appid");
            GCBindGroup$QQGroupBind gCBindGroup$QQGroupBind = new GCBindGroup$QQGroupBind();
            gCBindGroup$QQGroupBind.group_code.set(longValue);
            gCBindGroup$GCBindGroupSsoServerReq.bind_req.set(gCBindGroup$QQGroupBind);
            NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, m.class);
            b bVar = new b(callback);
            bVar.mApp = new WeakReference<>(peekAppRuntime);
            bVar.mType = 2;
            newIntent.setObserver(bVar);
            newIntent.putExtra("cmd", "gcbindgroupsso.get_appid");
            newIntent.putExtra("data", gCBindGroup$GCBindGroupSsoServerReq.toByteArray());
            peekAppRuntime.startServlet(newIntent);
        }
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final void P1(@NotNull final Function2<? super String, ? super Integer, Unit> statusUpdateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) statusUpdateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(statusUpdateCallback, "statusUpdateCallback");
        this.gameBindBroadcastReceiver = new BroadcastReceiver(statusUpdateCallback) { // from class: com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameVM$registerGameBindReceiver$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2<String, Integer, Unit> f300467b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.f300467b = statusUpdateCallback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBindGameVM.this, (Object) statusUpdateCallback);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i3 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT", str)) {
                    String stringExtra = intent.getStringExtra("data");
                    if (stringExtra == null) {
                        stringExtra = new JSONObject().toString();
                    }
                    Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"d\u2026: JSONObject().toString()");
                    if (Intrinsics.areEqual("bindGames", intent.getStringExtra("event"))) {
                        QLog.i("TroopBindGameVM", 1, "receive bind game event, data = " + stringExtra);
                        try {
                            JSONObject jSONObject = new JSONObject(stringExtra);
                            if (!Intrinsics.areEqual(TroopBindGameVM.this.N1(), jSONObject.getString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID))) {
                                return;
                            }
                            int i16 = jSONObject.getInt("appid");
                            String name = jSONObject.getString("name");
                            if (i16 > 0) {
                                if (!TextUtils.isEmpty(name)) {
                                    Intrinsics.checkNotNullExpressionValue(name, "name");
                                    i3 = 1;
                                    this.f300467b.invoke(name, Integer.valueOf(i3));
                                }
                                i3 = 0;
                            }
                            name = "";
                            this.f300467b.invoke(name, Integer.valueOf(i3));
                        } catch (JSONException e16) {
                            QLog.e("TroopBindGameVM", 1, "parse bind game event error", e16);
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        BaseApplication.getContext().registerReceiver(this.gameBindBroadcastReceiver, intentFilter);
    }

    public final void Q1(@NotNull String mTroopUin, @NotNull Function1<? super GCBindGroup$GCBindGroupSsoServerRsp, Unit> callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) mTroopUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(mTroopUin, "mTroopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(mTroopUin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            GCBindGroup$GCBindGroupSsoServerReq gCBindGroup$GCBindGroupSsoServerReq = new GCBindGroup$GCBindGroupSsoServerReq();
            gCBindGroup$GCBindGroupSsoServerReq.cmd.set("unbind_group");
            GCBindGroup$QQGroupBind gCBindGroup$QQGroupBind = new GCBindGroup$QQGroupBind();
            gCBindGroup$QQGroupBind.group_code.set(longValue);
            gCBindGroup$GCBindGroupSsoServerReq.bind_req.set(gCBindGroup$QQGroupBind);
            NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, m.class);
            c cVar = new c(callback);
            cVar.mApp = new WeakReference<>(peekAppRuntime);
            cVar.mType = 2;
            newIntent.setObserver(cVar);
            newIntent.putExtra("cmd", "gcbindgroupsso.unbind_group");
            newIntent.putExtra("data", gCBindGroup$GCBindGroupSsoServerReq.toByteArray());
            peekAppRuntime.startServlet(newIntent);
        }
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            if (this.gameBindBroadcastReceiver == null) {
                return;
            }
            BaseApplication.getContext().unregisterReceiver(this.gameBindBroadcastReceiver);
        } catch (Exception e16) {
            QLog.e("TroopBindGameVM", 1, "[unRegisterGameBindReceiver] exception = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            R1();
        }
    }
}
