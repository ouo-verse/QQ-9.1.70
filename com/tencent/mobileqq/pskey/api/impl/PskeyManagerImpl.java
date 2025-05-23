package com.tencent.mobileqq.pskey.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.pskey.PskeyLocalDataManager;
import com.tencent.mobileqq.pskey.PskeyNetworkDataHandler;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.pskey.f;
import com.tencent.mobileqq.pskey.h;
import com.tencent.mobileqq.pskey.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007\u00a2\u0006\u0004\bP\u0010QJ-\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000bJ)\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0002J4\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J0\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J0\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u000fH\u0002J,\u0010 \u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\b\u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\tH\u0002J-\u0010\"\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\"\u0010\u000bJ\u0018\u0010$\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J%\u0010%\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b%\u0010&J%\u0010'\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b'\u0010&J'\u0010(\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b(\u0010&J'\u0010)\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b)\u0010&J\u001f\u0010*\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010.\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010/\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020\tH\u0016J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u00020\tH\u0016J-\u0010 \u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b \u0010\u000bJ\u001d\u00104\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b4\u0010+J\u0010\u00107\u001a\u00020\t2\u0006\u00106\u001a\u000205H\u0016J\b\u00108\u001a\u00020\tH\u0016R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020,0J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/pskey/api/impl/PskeyManagerImpl;", "Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "", "", "domains", "", "keyType", "Lsd2/a;", "callback", "", "getKey", "([Ljava/lang/String;ILsd2/a;)V", "checkDomainWhiteList", "([Ljava/lang/String;I)V", "replaceKey", "", "getPskeySync", "([Ljava/lang/String;)Ljava/util/Map;", "notifyPskeyListenersPskeyChanged", "initAccountKickedReceiver", "uin", "", "needUpdateAllPskey", "isUinNotChanged", "Lcom/tencent/mobileqq/pskey/a;", "domainToPskeyMap", "type", "checkUinAndCallback", "Ljava/util/HashMap;", "toReturnType", "getPskeyFromLocal", "Lcom/tencent/mobileqq/pskey/f;", "getPskeyFromRequest", "checkPskeyNetworkDataHandler", "callGetPskeyIgnoreLocalCacheInMainProcess", "Leipc/EIPCResultCallback;", "getEipcResultCallback", "getPskey", "([Ljava/lang/String;Lsd2/a;)V", "getUskey", "replacePskey", "replaceUskey", "clearLocalPskey", "([Ljava/lang/String;)V", "Lsd2/b;", "listener", "registerPskeyListener", "unregisterPskeyListener", "attackUpdatePskey", "onNTKernelSessionCreated", "onAppDestory", "updateAllPskeyAndUskey", "reportGetPskey", "Lmqq/app/AppRuntime;", "app", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/pskey/d;", "pskeyAttackUpdateHelper", "Lcom/tencent/mobileqq/pskey/d;", "mAppRuntime", "Lmqq/app/AppRuntime;", "Lcom/tencent/mobileqq/pskey/PskeyNetworkDataHandler;", "mPskeyNetworkDataHandler", "Lcom/tencent/mobileqq/pskey/PskeyNetworkDataHandler;", "Lcom/tencent/mobileqq/pskey/PskeyLocalDataManager;", "mPskeyLocalDataManager", "Lcom/tencent/mobileqq/pskey/PskeyLocalDataManager;", "Lcom/tencent/mobileqq/pskey/h;", "mPskeyRequestDomainListManager", "Lcom/tencent/mobileqq/pskey/h;", "Landroid/content/BroadcastReceiver;", "mAccountKickedReceiver", "Landroid/content/BroadcastReceiver;", "Ljava/util/ArrayList;", "mListenerList", "Ljava/util/ArrayList;", "", "mLastCheckUpdateAllPskeyTimeStamp", "J", "<init>", "()V", "Companion", "a", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PskeyManagerImpl implements IPskeyManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String MAIN_PROCESS_NAME = "com.tencent.mobileqq";

    @NotNull
    private static final String TAG = "PskeyManagerImpl";
    private static final int UPDATE_ALL_PSKEY_COOL_DOWN = 10000;

    @Nullable
    private BroadcastReceiver mAccountKickedReceiver;

    @Nullable
    private AppRuntime mAppRuntime;
    private long mLastCheckUpdateAllPskeyTimeStamp;

    @NotNull
    private ArrayList<sd2.b> mListenerList;

    @Nullable
    private PskeyLocalDataManager mPskeyLocalDataManager;

    @Nullable
    private PskeyNetworkDataHandler mPskeyNetworkDataHandler;

    @Nullable
    private h mPskeyRequestDomainListManager;

    @NotNull
    private com.tencent.mobileqq.pskey.d pskeyAttackUpdateHelper;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/pskey/api/impl/PskeyManagerImpl$a;", "", "", "MAIN_PROCESS_NAME", "Ljava/lang/String;", "TAG", "", "UPDATE_ALL_PSKEY_COOL_DOWN", "I", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pskey.api.impl.PskeyManagerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/pskey/api/impl/PskeyManagerImpl$b", "Lcom/tencent/mobileqq/pskey/f;", "", "", "Lcom/tencent/mobileqq/pskey/a;", "domainToPskeyMap", "", "onSuccess", "errMsg", "onFail", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, com.tencent.mobileqq.pskey.a> f261143b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ sd2.a f261144c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f261145d;

        b(Map<String, com.tencent.mobileqq.pskey.a> map, sd2.a aVar, int i3) {
            this.f261143b = map;
            this.f261144c = aVar;
            this.f261145d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PskeyManagerImpl.this, map, aVar, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.pskey.f
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e(PskeyManagerImpl.TAG, 1, "getPskey getPskeyFromRequest onFail, errMsg = " + errMsg);
            this.f261144c.onFail(errMsg);
        }

        @Override // com.tencent.mobileqq.pskey.f
        public void onSuccess(@NotNull Map<String, com.tencent.mobileqq.pskey.a> domainToPskeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToPskeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToPskeyMap, "domainToPskeyMap");
            AppRuntime appRuntime = PskeyManagerImpl.this.mAppRuntime;
            Intrinsics.checkNotNull(appRuntime);
            String uin = appRuntime.getCurrentAccountUin();
            if (QLog.isDevelopLevel()) {
                QLog.i(PskeyManagerImpl.TAG, 4, "getPskey getPskeyFromRequest success");
            }
            PskeyLocalDataManager pskeyLocalDataManager = PskeyManagerImpl.this.mPskeyLocalDataManager;
            Intrinsics.checkNotNull(pskeyLocalDataManager);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            pskeyLocalDataManager.k(uin, domainToPskeyMap);
            Map<String, com.tencent.mobileqq.pskey.a> pskeyFromLocal = PskeyManagerImpl.this.getPskeyFromLocal(uin, this.f261143b);
            i iVar = i.f261182a;
            Map<String, com.tencent.mobileqq.pskey.a> d16 = iVar.d(this.f261143b, pskeyFromLocal);
            iVar.e(uin, d16);
            PskeyManagerImpl.this.checkUinAndCallback(uin, this.f261144c, d16, this.f261145d);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/pskey/api/impl/PskeyManagerImpl$c", "Lcom/tencent/mobileqq/pskey/f;", "", "", "Lcom/tencent/mobileqq/pskey/a;", "domainToPskeyMap", "", "onSuccess", "errMsg", "onFail", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f261147b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, com.tencent.mobileqq.pskey.a> f261148c;

        c(String str, Map<String, com.tencent.mobileqq.pskey.a> map) {
            this.f261147b = str;
            this.f261148c = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PskeyManagerImpl.this, str, map);
            }
        }

        @Override // com.tencent.mobileqq.pskey.f
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e(PskeyManagerImpl.TAG, 1, "getPskeySync getPskeyFromRequest onFail, errMsg = " + errMsg);
        }

        @Override // com.tencent.mobileqq.pskey.f
        public void onSuccess(@NotNull Map<String, com.tencent.mobileqq.pskey.a> domainToPskeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToPskeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToPskeyMap, "domainToPskeyMap");
            QLog.i(PskeyManagerImpl.TAG, 4, "getPskeySync getPskeyFromRequest success");
            PskeyLocalDataManager pskeyLocalDataManager = PskeyManagerImpl.this.mPskeyLocalDataManager;
            Intrinsics.checkNotNull(pskeyLocalDataManager);
            String uin = this.f261147b;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            pskeyLocalDataManager.k(uin, domainToPskeyMap);
            PskeyManagerImpl pskeyManagerImpl = PskeyManagerImpl.this;
            String uin2 = this.f261147b;
            Intrinsics.checkNotNullExpressionValue(uin2, "uin");
            Map<String, com.tencent.mobileqq.pskey.a> pskeyFromLocal = pskeyManagerImpl.getPskeyFromLocal(uin2, this.f261148c);
            i iVar = i.f261182a;
            Map<String, com.tencent.mobileqq.pskey.a> d16 = iVar.d(this.f261148c, pskeyFromLocal);
            String uin3 = this.f261147b;
            Intrinsics.checkNotNullExpressionValue(uin3, "uin");
            iVar.e(uin3, d16);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/pskey/api/impl/PskeyManagerImpl$d", "Lsd2/b;", "", "a", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements sd2.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PskeyManagerImpl.this);
            }
        }

        @Override // sd2.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PskeyManagerImpl.this.notifyPskeyListenersPskeyChanged();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/pskey/api/impl/PskeyManagerImpl$e", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements sd2.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e(PskeyManagerImpl.TAG, 1, "updateAllPskey onFail, errMsg = " + errMsg);
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            if (QLog.isDevelopLevel()) {
                QLog.i(PskeyManagerImpl.TAG, 4, "updateAllPskey onSuccess");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PskeyManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pskeyAttackUpdateHelper = new com.tencent.mobileqq.pskey.d();
            this.mListenerList = new ArrayList<>();
        }
    }

    private final void callGetPskeyIgnoreLocalCacheInMainProcess(final String[] domains, final int keyType, final sd2.a callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pskey.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                PskeyManagerImpl.callGetPskeyIgnoreLocalCacheInMainProcess$lambda$8(PskeyManagerImpl.this, domains, keyType, callback);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callGetPskeyIgnoreLocalCacheInMainProcess$lambda$8(PskeyManagerImpl this$0, String[] domains, int i3, sd2.a callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(domains, "$domains");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        AppRuntime appRuntime = this$0.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        QLog.i(TAG, 4, "getPskeyFromRequest start uin = " + appRuntime.getCurrentAccountUin());
        String currentProcessName = ProcessUtil.getCurrentProcessName(BaseApplication.context);
        if (TextUtils.equals(currentProcessName, "com.tencent.mobileqq")) {
            this$0.getPskeyFromRequest(domains, i3, callback);
            return;
        }
        try {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "getPskeyIpcToMainProcess curProcessName = " + currentProcessName + ", start IPC");
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("domains", domains);
            bundle.putInt("key_request_type", i3);
            QIPCClientHelper.getInstance().callServer("PskeyIPCModule", "action_get_pskey_ignore_local_cache", bundle, this$0.getEipcResultCallback(i3, callback));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private final void checkDomainWhiteList(String[] domains, int keyType) {
        AppRuntime appRuntime;
        List<String> list;
        boolean z16;
        if ((keyType == 0 || keyType == 2) && (appRuntime = this.mAppRuntime) != null) {
            h hVar = this.mPskeyRequestDomainListManager;
            if (hVar != null) {
                Intrinsics.checkNotNull(appRuntime);
                list = hVar.a(appRuntime);
            } else {
                list = null;
            }
            List<String> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.e(TAG, 1, "checkDomainWhiteList is null");
                return;
            }
            for (final String str : domains) {
                if (!list.contains(str)) {
                    QLog.e(TAG, 1, "checkDomainWhiteList illegal domain: " + str);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pskey.api.impl.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            PskeyManagerImpl.checkDomainWhiteList$lambda$2$lambda$1(str);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkDomainWhiteList$lambda$2$lambda$1(String domain) {
        Intrinsics.checkNotNullParameter(domain, "$domain");
        QQToast.makeText(MobileQQ.sMobileQQ, "\u975e\u6cd5\u57df\u540d" + domain + ",\u8054\u7cfbDevinsu\u52a0\u767d", 0).show();
    }

    private final void checkPskeyNetworkDataHandler() {
        if (this.mPskeyNetworkDataHandler == null) {
            try {
                AppRuntime appRuntime = this.mAppRuntime;
                Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                BusinessHandler businessHandler = ((AppInterface) appRuntime).getBusinessHandler(PskeyNetworkDataHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.pskey.PskeyNetworkDataHandler");
                this.mPskeyNetworkDataHandler = (PskeyNetworkDataHandler) businessHandler;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onCreate app as AppInterface error", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUinAndCallback(String uin, sd2.a callback, Map<String, com.tencent.mobileqq.pskey.a> domainToPskeyMap, int type) {
        if (isUinNotChanged(uin)) {
            callback.onSuccess(toReturnType(domainToPskeyMap, type));
        } else {
            callback.onFail("uin is changed");
        }
    }

    private final EIPCResultCallback getEipcResultCallback(int keyType, final sd2.a callback) {
        return new EIPCResultCallback() { // from class: com.tencent.mobileqq.pskey.api.impl.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                PskeyManagerImpl.getEipcResultCallback$lambda$9(sd2.a.this, this, eIPCResult);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEipcResultCallback$lambda$9(sd2.a callback, PskeyManagerImpl this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = eIPCResult.data;
        Intrinsics.checkNotNullExpressionValue(bundle, "result.data");
        String string = bundle.getString("errMsg");
        if (eIPCResult.code == 0 && !TextUtils.isEmpty(string)) {
            if (!Intrinsics.areEqual(string, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
                QLog.e(TAG, 1, "errMsg = " + string);
                Intrinsics.checkNotNull(string);
                callback.onFail(string);
                return;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList("result_map_domains");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("result_map_keys");
            if (stringArrayList != null && stringArrayList2 != null) {
                int size = stringArrayList.size();
                HashMap hashMap = new HashMap();
                for (int i3 = 0; i3 < size; i3++) {
                    String domain = stringArrayList.get(i3);
                    String pskey = stringArrayList2.get(i3);
                    if (!TextUtils.isEmpty(domain) && !TextUtils.isEmpty(pskey)) {
                        Intrinsics.checkNotNullExpressionValue(domain, "domain");
                        Intrinsics.checkNotNullExpressionValue(pskey, "pskey");
                        hashMap.put(domain, pskey);
                    } else {
                        QLog.e(TAG, 1, "domain or pskey isEmpty");
                    }
                }
                callback.onSuccess(hashMap);
                this$0.notifyPskeyListenersPskeyChanged();
                return;
            }
            QLog.e(TAG, 1, "wrong params");
            callback.onFail("wrong params");
            return;
        }
        QLog.e(TAG, 1, "unknown Error");
        callback.onFail("unknown Error");
    }

    private final void getKey(String[] domains, int keyType, sd2.a callback) {
        AppRuntime appRuntime;
        List<String> list;
        AppRuntime appRuntime2 = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime2);
        String uin = appRuntime2.getCurrentAccountUin();
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "getPskey start uin = " + uin);
        }
        if (TextUtils.isEmpty(uin)) {
            QLog.e(TAG, 1, "getKey uin is null");
            callback.onFail("this process uin is null");
            return;
        }
        i iVar = i.f261182a;
        Map<String, com.tencent.mobileqq.pskey.a> a16 = iVar.a(domains);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Map<String, com.tencent.mobileqq.pskey.a> pskeyFromLocal = getPskeyFromLocal(uin, a16);
        if (iVar.c(pskeyFromLocal, keyType)) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "getPskey getPskeyFromLocal success");
            }
            iVar.e(uin, pskeyFromLocal);
            checkUinAndCallback(uin, callback, pskeyFromLocal, keyType);
            updateAllPskeyAndUskey();
            return;
        }
        if (keyType == 1 && (appRuntime = this.mAppRuntime) != null) {
            h hVar = this.mPskeyRequestDomainListManager;
            if (hVar != null) {
                Intrinsics.checkNotNull(appRuntime);
                list = hVar.e(appRuntime);
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                for (String str : domains) {
                    if (!list.contains(str)) {
                        callback.onFail("not support this domain: " + str);
                        return;
                    }
                }
            } else {
                callback.onFail("not support these domains: " + domains);
                return;
            }
        }
        callGetPskeyIgnoreLocalCacheInMainProcess(domains, keyType, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, com.tencent.mobileqq.pskey.a> getPskeyFromLocal(String uin, Map<String, com.tencent.mobileqq.pskey.a> domains) {
        PskeyLocalDataManager pskeyLocalDataManager = this.mPskeyLocalDataManager;
        Intrinsics.checkNotNull(pskeyLocalDataManager);
        return pskeyLocalDataManager.f(uin, domains);
    }

    @Deprecated(message = "\u4ec5\u8c03\u8bd5\u4f7f\u7528\uff0c\u4e1a\u52a1\u8bf7\u4f7f\u7528getPskey")
    private final Map<String, String> getPskeySync(String[] domains) {
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        String uin = appRuntime.getCurrentAccountUin();
        i iVar = i.f261182a;
        Map<String, com.tencent.mobileqq.pskey.a> a16 = iVar.a(domains);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Map<String, com.tencent.mobileqq.pskey.a> pskeyFromLocal = getPskeyFromLocal(uin, a16);
        if (iVar.b(pskeyFromLocal)) {
            iVar.e(uin, pskeyFromLocal);
            return toReturnType(pskeyFromLocal, 0);
        }
        getPskeyFromRequest(uin, a16, new c(uin, pskeyFromLocal));
        return toReturnType(pskeyFromLocal, 0);
    }

    private final void initAccountKickedReceiver() {
        if (this.mAccountKickedReceiver == null) {
            this.mAccountKickedReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.pskey.api.impl.PskeyManagerImpl$initAccountKickedReceiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PskeyManagerImpl.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    h hVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (context != null && intent != null) {
                        Serializable serializableExtra = intent.getSerializableExtra("reason");
                        QLog.d("PskeyManagerImpl", 1, "account kicked, logoutReason=" + serializableExtra);
                        if (serializableExtra == Constants.LogoutReason.kicked) {
                            hVar = PskeyManagerImpl.this.mPskeyRequestDomainListManager;
                            Intrinsics.checkNotNull(hVar);
                            AppRuntime appRuntime = PskeyManagerImpl.this.mAppRuntime;
                            Intrinsics.checkNotNull(appRuntime);
                            Object[] array = hVar.b(appRuntime).toArray(new String[0]);
                            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            PskeyManagerImpl.this.clearLocalPskey((String[]) array);
                        }
                    }
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        BaseApplication.getContext().registerReceiver(this.mAccountKickedReceiver, intentFilter);
    }

    private final boolean isUinNotChanged(String uin) {
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return TextUtils.equals(uin, appRuntime.getCurrentAccountUin());
    }

    private final boolean needUpdateAllPskey(String uin) {
        if (uin == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCheckUpdateAllPskeyTimeStamp <= 10000) {
            return false;
        }
        this.mLastCheckUpdateAllPskeyTimeStamp = currentTimeMillis;
        PskeyLocalDataManager pskeyLocalDataManager = this.mPskeyLocalDataManager;
        Intrinsics.checkNotNull(pskeyLocalDataManager);
        return pskeyLocalDataManager.h(uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPskeyListenersPskeyChanged() {
        QLog.d(TAG, 1, "notifyPskeyListenersPskeyChanged");
        synchronized (this.mListenerList) {
            Iterator<sd2.b> it = this.mListenerList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        if (r1 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void replaceKey(String[] domains, int keyType, sd2.a callback) {
        boolean z16;
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "replaceKey key type : " + keyType);
        }
        if (domains != null) {
            if (domains.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        h hVar = this.mPskeyRequestDomainListManager;
        Intrinsics.checkNotNull(hVar);
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        Object[] array = hVar.b(appRuntime).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        domains = (String[]) array;
        clearLocalPskey(domains);
        Intrinsics.checkNotNull(domains);
        getKey(domains, keyType, callback);
    }

    private final HashMap<String, String> toReturnType(Map<String, com.tencent.mobileqq.pskey.a> domainToPskeyMap, int type) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, com.tencent.mobileqq.pskey.a> entry : domainToPskeyMap.entrySet()) {
            String key = entry.getKey();
            com.tencent.mobileqq.pskey.a value = entry.getValue();
            if ((Intrinsics.areEqual(value.b(), "") && Intrinsics.areEqual(value.c(), "")) || value.a() == 0) {
                QLog.e(TAG, 1, "toReturnType domain = " + key + ", result is invalid");
            } else if (type == 0) {
                hashMap.put(key, value.b());
            } else {
                hashMap.put(key, value.c());
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void attackUpdatePskey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.pskeyAttackUpdateHelper.d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r1 != false) goto L15;
     */
    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clearLocalPskey(@Nullable String[] domains) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) domains);
            return;
        }
        QLog.i(TAG, 4, "clearLocalPskey");
        if (domains != null) {
            if (domains.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        h hVar = this.mPskeyRequestDomainListManager;
        Intrinsics.checkNotNull(hVar);
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        Object[] array = hVar.b(appRuntime).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        domains = (String[]) array;
        AppRuntime appRuntime2 = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime2);
        String uin = appRuntime2.getCurrentAccountUin();
        PskeyLocalDataManager pskeyLocalDataManager = this.mPskeyLocalDataManager;
        Intrinsics.checkNotNull(pskeyLocalDataManager);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Intrinsics.checkNotNull(domains);
        pskeyLocalDataManager.d(uin, domains);
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void getPskey(@NotNull String[] domains, @NotNull sd2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) domains, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getKey(domains, 0, callback);
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void getPskeyFromRequest(@NotNull String[] domains, int keyType, @NotNull sd2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, domains, Integer.valueOf(keyType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        String uin = appRuntime.getCurrentAccountUin();
        QLog.i(TAG, 4, "getPskeyFromRequest start uin = " + uin);
        Map<String, com.tencent.mobileqq.pskey.a> a16 = i.f261182a.a(domains);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Map<String, com.tencent.mobileqq.pskey.a> pskeyFromLocal = getPskeyFromLocal(uin, a16);
        getPskeyFromRequest(uin, pskeyFromLocal, new b(pskeyFromLocal, callback, keyType));
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void getUskey(@NotNull String[] domains, @NotNull sd2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) domains, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getKey(domains, 1, callback);
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void onAppDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.pskeyAttackUpdateHelper.f();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i(TAG, 4, "onCreate");
        this.mAppRuntime = app;
        initAccountKickedReceiver();
        this.mPskeyLocalDataManager = new PskeyLocalDataManager(app, new d());
        this.mPskeyRequestDomainListManager = new h();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.i(TAG, 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        try {
            if (this.mAccountKickedReceiver != null) {
                BaseApplication.getContext().unregisterReceiver(this.mAccountKickedReceiver);
                this.mAccountKickedReceiver = null;
            }
            PskeyLocalDataManager pskeyLocalDataManager = this.mPskeyLocalDataManager;
            if (pskeyLocalDataManager != null) {
                pskeyLocalDataManager.o();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 2, "onDestroy unregister broadcast failed :" + e16);
        }
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void onNTKernelSessionCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.pskeyAttackUpdateHelper.h();
        }
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void registerPskeyListener(@Nullable sd2.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
            return;
        }
        if (listener == null) {
            QLog.e(TAG, 1, "registerPskeyListener failed, listener is null");
            return;
        }
        synchronized (this.mListenerList) {
            if (!this.mListenerList.contains(listener)) {
                this.mListenerList.add(listener);
                QLog.d(TAG, 4, "registerPskeyListener ok");
            } else {
                QLog.d(TAG, 4, "registerPskeyListener duplicated listener");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void replacePskey(@Nullable String[] domains, @NotNull sd2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) domains, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            replaceKey(domains, 0, callback);
        }
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void replaceUskey(@Nullable String[] domains, @NotNull sd2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) domains, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            replaceKey(domains, 1, callback);
        }
    }

    @Override // mqq.manager.TicketManager.IPskeyManager
    public void reportGetPskey(@NotNull String[] domains) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) domains);
            return;
        }
        Intrinsics.checkNotNullParameter(domains, "domains");
        ArrayList arrayList = new ArrayList();
        for (String str : domains) {
            arrayList.add(new Regex("\\(.*\\)").replace(str, ""));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        getPskeySync((String[]) array);
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void unregisterPskeyListener(@Nullable sd2.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
            return;
        }
        if (listener == null) {
            QLog.e(TAG, 1, "unregisterPskeyListener failed, listener is null");
            return;
        }
        synchronized (this.mListenerList) {
            if (this.mListenerList.remove(listener)) {
                QLog.d(TAG, 4, "unregisterPskeyListener ok");
            } else {
                QLog.d(TAG, 4, "unregisterPskeyListener no such listener");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyManager
    public void updateAllPskeyAndUskey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        String uin = appRuntime.getCurrentAccountUin();
        h hVar = this.mPskeyRequestDomainListManager;
        Intrinsics.checkNotNull(hVar);
        AppRuntime appRuntime2 = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime2);
        Object[] array = hVar.b(appRuntime2).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        Map<String, com.tencent.mobileqq.pskey.a> a16 = i.f261182a.a(strArr);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        getPskeyFromLocal(uin, a16);
        if (!needUpdateAllPskey(uin)) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "updateAllPskey end uin = " + uin + " needUpdateAllPskey = false");
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "updateAllPskey start uin = " + uin);
        }
        callGetPskeyIgnoreLocalCacheInMainProcess(strArr, 0, new e());
    }

    private final void getPskeyFromRequest(String uin, Map<String, com.tencent.mobileqq.pskey.a> domains, f callback) {
        List<String> list;
        checkPskeyNetworkDataHandler();
        if (this.mPskeyNetworkDataHandler == null) {
            QLog.e(TAG, 1, "getPskeyFromRequest mPskeyNetworkDataHandler == null");
            return;
        }
        i iVar = i.f261182a;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(domains.keySet());
        h hVar = this.mPskeyRequestDomainListManager;
        Intrinsics.checkNotNull(hVar);
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        arrayList.addAll(hVar.b(appRuntime));
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        List<String> f16 = iVar.f(list);
        PskeyNetworkDataHandler pskeyNetworkDataHandler = this.mPskeyNetworkDataHandler;
        Intrinsics.checkNotNull(pskeyNetworkDataHandler);
        pskeyNetworkDataHandler.E2(uin, f16, callback);
    }
}
