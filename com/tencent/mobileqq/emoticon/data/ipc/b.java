package com.tencent.mobileqq.emoticon.data.ipc;

import android.os.Bundle;
import android.util.Log;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.o;
import com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils;
import com.tencent.mobileqq.emoticon.data.ipc.b;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0004\u0018\u0019\u001a\u000eB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R@\u0010\u0010\u001a.\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nj\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/emoticon/data/ipc/b$c;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "methodClassList", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "methodList", "<init>", "()V", "f", "a", "b", "c", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final b f204749h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Class<? extends c>> methodClassList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, c> methodList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$a;", "", "", "b", "Lcom/tencent/mobileqq/emoticon/data/ipc/b;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/emoticon/data/ipc/b;", "a", "()Lcom/tencent/mobileqq/emoticon/data/ipc/b;", "", "ERROR_NO_ACTION", "I", "ERROR_NO_ACTION_HANDLER", "ERROR_NO_APP_RUNTIME", "", "NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.b$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

        @NotNull
        public final b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.f204749h;
            }
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @JvmStatic
        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (MobileQQ.sProcessId == 1) {
                return true;
            }
            return false;
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
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$b;", "Lcom/tencent/mobileqq/emoticon/data/ipc/b$c;", "Lmqq/app/AppRuntime;", "appRuntime", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "f", "<init>", "()V", "e", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7498b extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$b$a;", "", "", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "a", "", "ACTION", "Ljava/lang/String;", "RESULT_KEY_EMOTIONS", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.b$b$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
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

            @JvmStatic
            @NotNull
            public final List<EmoticonInfo> a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (List) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                c.Companion companion = c.INSTANCE;
                EIPCResult b16 = c.b("GetFavRoamingEmoticons", new Bundle());
                ArrayList arrayList = new ArrayList();
                int i3 = b16.code;
                if (i3 != 0) {
                    QLog.i("EmoticonDataServiceIPC", 1, "Failed to get fav roaming emoticons, code=" + i3);
                    return arrayList;
                }
                ArrayList parcelableArrayList = b16.data.getParcelableArrayList("emotions");
                Intrinsics.checkNotNull(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.emoticonview.EmoticonInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.emoticonview.EmoticonInfo> }");
                return parcelableArrayList;
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27750);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public C7498b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.data.ipc.b.c
        @Nullable
        public EIPCResult f(@NotNull AppRuntime appRuntime, @NotNull String action, @NotNull Bundle params, int callbackId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EIPCResult) iPatchRedirector.redirect((short) 2, this, appRuntime, action, params, Integer.valueOf(callbackId));
            }
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(params, "params");
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IFavroamingDBManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = ((IFavroamingDBManagerService) runtimeService).syncGetCustomEmotionInfoShowedInPanel();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("emotions", new ArrayList<>(syncGetCustomEmotionInfoShowedInPanel));
            return EIPCResult.createResult(0, bundle);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$c;", "", "Lmqq/app/AppRuntime;", "appRuntime", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "f", "data", "", "d", "<init>", "()V", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static abstract class c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0005J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0005J(\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0005J\b\u0010\u000f\u001a\u00020\u000eH\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$c$a;", "", "", "action", "Landroid/os/Bundle;", "param", "Leipc/EIPCResultCallback;", "callback", "", "c", "Leipc/EIPCResult;", "b", "process", "a", "", "d", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.b$c$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                    return;
                }
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
            }

            @JvmStatic
            protected final void a(@NotNull String process, @NotNull String action, @NotNull Bundle param, @NotNull EIPCResultCallback callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, process, action, param, callback);
                    return;
                }
                Intrinsics.checkNotNullParameter(process, "process");
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(callback, "callback");
                QIPCServerHelper.getInstance().callClient(process, "EmoticonDataServiceIPC", action, param, callback);
            }

            @JvmStatic
            @NotNull
            protected final EIPCResult b(@NotNull String action, @NotNull Bundle param) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (EIPCResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) action, (Object) param);
                }
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(param, "param");
                b.INSTANCE.a();
                QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
                if (qIPCClientHelper == null) {
                    QLog.i("EmoticonDataServiceIPC", 1, "callServer  clientHelper is null");
                }
                EIPCResult callServer = qIPCClientHelper.callServer("EmoticonDataServiceIPC", action, param);
                Intrinsics.checkNotNullExpressionValue(callServer, "clientHelper.callServer(NAME, action, param)");
                return callServer;
            }

            @JvmStatic
            protected final void c(@NotNull String action, @NotNull Bundle param, @NotNull EIPCResultCallback callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, action, param, callback);
                    return;
                }
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(callback, "callback");
                b.INSTANCE.a();
                QIPCClientHelper.getInstance().callServer("EmoticonDataServiceIPC", action, param, callback);
            }

            @JvmStatic
            protected final boolean d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                if (MobileQQ.sProcessId == 1) {
                    return true;
                }
                return false;
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27771);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @JvmStatic
        public static final void a(@NotNull String str, @NotNull String str2, @NotNull Bundle bundle, @NotNull EIPCResultCallback eIPCResultCallback) {
            INSTANCE.a(str, str2, bundle, eIPCResultCallback);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @JvmStatic
        @NotNull
        public static final EIPCResult b(@NotNull String str, @NotNull Bundle bundle) {
            return INSTANCE.b(str, bundle);
        }

        @JvmStatic
        protected static final void c(@NotNull String str, @NotNull Bundle bundle, @NotNull EIPCResultCallback eIPCResultCallback) {
            INSTANCE.c(str, bundle, eIPCResultCallback);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @JvmStatic
        public static final boolean e() {
            return INSTANCE.d();
        }

        protected final void d(int callbackId, @NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, callbackId, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                b.INSTANCE.a().callbackResult(callbackId, EIPCResult.createResult(0, data));
            }
        }

        @Nullable
        public abstract EIPCResult f(@NotNull AppRuntime appRuntime, @NotNull String action, @NotNull Bundle params, int callbackId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000f\u0010B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$d;", "Lcom/tencent/mobileqq/emoticon/data/ipc/b$c;", "Lmqq/app/AppRuntime;", "appRuntime", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "f", "<init>", "()V", "e", "a", "b", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$d$a;", "", "Lcom/tencent/mobileqq/emoticon/data/ipc/b$d$b;", "callback", "", "b", "", "ACTION", "Ljava/lang/String;", "RESULT_KEY_EMOTIONS", "RESULT_KEY_SUCCESS", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.b$d$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
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

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(InterfaceC7499b callback, EIPCResult eIPCResult) {
                Bundle bundle;
                Intrinsics.checkNotNullParameter(callback, "$callback");
                int i3 = eIPCResult.code;
                if (i3 == 0 && (bundle = eIPCResult.data) != null) {
                    boolean z16 = bundle.getBoolean("success");
                    ArrayList<EmoticonInfo> parcelableArrayList = eIPCResult.data.getParcelableArrayList("emoticons");
                    if (z16 && parcelableArrayList != null) {
                        callback.a(z16, parcelableArrayList);
                        return;
                    } else {
                        callback.a(false, new ArrayList<>());
                        return;
                    }
                }
                QLog.i("EmoticonDataServiceIPC", 1, "[UpdateFavRoaming] ipc error, code=" + i3 + " data=" + eIPCResult.data);
                callback.a(false, new ArrayList<>());
            }

            @JvmStatic
            public final void b(@NotNull final InterfaceC7499b callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
                    return;
                }
                Intrinsics.checkNotNullParameter(callback, "callback");
                c.Companion companion = c.INSTANCE;
                c.c("UpdateFavRoaming", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.emoticon.data.ipc.c
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        b.d.Companion.c(b.d.InterfaceC7499b.this, eIPCResult);
                    }
                });
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
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/b$d$b;", "", "", "result", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "Lkotlin/collections/ArrayList;", "emoticons", "", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public interface InterfaceC7499b {
            void a(boolean result, @NotNull ArrayList<EmoticonInfo> emoticons);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/emoticon/data/ipc/b$d$c", "Lcom/tencent/mobileqq/emosm/favroaming/o;", "", "a", "notifySyncFail", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class c implements o {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f204756b;

            c(int i3) {
                this.f204756b = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, i3);
                }
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.o
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("success", true);
                bundle.putParcelableArrayList("emoticons", ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).getEmoticonData());
                d.this.d(this.f204756b, bundle);
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.o
            public void notifySyncFail() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("success", false);
                bundle.putParcelableArrayList("emoticons", new ArrayList<>());
                d.this.d(this.f204756b, bundle);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27799);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticon.data.ipc.b.c
        @Nullable
        public EIPCResult f(@NotNull AppRuntime appRuntime, @NotNull String action, @NotNull Bundle params, int callbackId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EIPCResult) iPatchRedirector.redirect((short) 2, this, appRuntime, action, params, Integer.valueOf(callbackId));
            }
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(params, "params");
            Log.i("EmoticonDataServiceIPC", "update fav roaming complete");
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).triggerToSyncFromServer(new c(callbackId));
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f204749h = new b();
        }
    }

    public b() {
        super("EmoticonDataServiceIPC");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<String, Class<? extends c>> hashMap = new HashMap<>();
        this.methodClassList = hashMap;
        this.methodList = new ConcurrentHashMap<>();
        hashMap.put("UpdateFavRoaming", d.class);
        hashMap.put("GetFavRoamingEmoticons", C7498b.class);
        Iterator<String> it = com.tencent.mobileqq.emoticon.data.ipc.d.INSTANCE.b().iterator();
        while (it.hasNext()) {
            this.methodList.put(it.next(), com.tencent.mobileqq.emoticon.data.ipc.d.INSTANCE.a());
        }
        Iterator<String> it5 = a.INSTANCE.b().iterator();
        while (it5.hasNext()) {
            this.methodList.put(it5.next(), a.INSTANCE.a());
        }
        if (!INSTANCE.b()) {
            QIPCClientHelper.getInstance().register(this);
        }
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (action == null) {
            QLog.w("EmoticonDataServiceIPC", 1, "onCall, action is null");
            return EIPCResult.createResult(-1001, new Bundle());
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("EmoticonDataServiceIPC", 1, "onCall, no app runtime, action=" + action);
            return EIPCResult.createResult(-1003, new Bundle());
        }
        c cVar = this.methodList.get(action);
        if (cVar != null) {
            if (params == null) {
                params = new Bundle();
            }
            return cVar.f(peekAppRuntime, action, params, callbackId);
        }
        Class<? extends c> cls = this.methodClassList.get(action);
        if (cls == null) {
            QLog.i("EmoticonDataServiceIPC", 1, "onCall, unknown action " + action);
            return EIPCResult.createResult(-1002, new Bundle());
        }
        c newInstance = cls.newInstance();
        this.methodList.put(action, newInstance);
        if (params == null) {
            params = new Bundle();
        }
        return newInstance.f(peekAppRuntime, action, params, callbackId);
    }
}
