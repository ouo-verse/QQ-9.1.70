package com.tencent.mobileqq.tbstool;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tbstool/TBSToolIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "callbackId", "", "e", tl.h.F, "g", "d", "", "action", "Leipc/EIPCResult;", "onCall", "name", "<init>", "(Ljava/lang/String;)V", "a", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TBSToolIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<TBSToolIPCModule> f291404e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tbstool/TBSToolIPCModule$a;", "", "Lcom/tencent/mobileqq/tbstool/TBSToolIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/tbstool/TBSToolIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "KEY_FILE_ID", "Ljava/lang/String;", "KEY_FILE_ID_LIST", "KEY_FILE_PATH", "KEY_FILE_PATH_LIST", "KEY_METHOD", "KEY_PARAM", "TAG", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tbstool.TBSToolIPCModule$a, reason: from kotlin metadata */
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

        @NotNull
        public final TBSToolIPCModule a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TBSToolIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (TBSToolIPCModule) TBSToolIPCModule.f291404e.getValue();
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
        Lazy<TBSToolIPCModule> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) TBSToolIPCModule$Companion$instance$2.INSTANCE);
        f291404e = lazy;
    }

    public /* synthetic */ TBSToolIPCModule(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) defaultConstructorMarker);
    }

    private final void d(Bundle params) {
        ArrayList<String> stringArrayList = params.getStringArrayList("pathList");
        boolean z16 = true;
        QLog.d("TBSToolIPCModule", 1, "forwardFile pathList: " + stringArrayList);
        if (stringArrayList == null || !(!stringArrayList.isEmpty())) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        TBSToolClientUtils.f291401a.s(stringArrayList);
    }

    private final void e(Bundle params, final int callbackId) {
        String string = params.getString("method", "");
        String string2 = params.getString("param", "");
        QLog.d("TBSToolIPCModule", 1, "forwardRequest method: " + string + ", param: " + string2);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        TbsToolEntrance.getInstance().onJsCall(string, string2, new ValueCallback() { // from class: com.tencent.mobileqq.tbstool.j
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                TBSToolIPCModule.f(TBSToolIPCModule.this, callbackId, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TBSToolIPCModule this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("param", str);
        Unit unit = Unit.INSTANCE;
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    private final void g(Bundle params) {
        String string = params.getString("path", "");
        long j3 = params.getLong("fileId", 0L);
        QLog.d("TBSToolIPCModule", 1, "openFile path: " + string + ", sessionId: " + j3);
        if (!TextUtils.isEmpty(string) && j3 > 0) {
            TBSToolClientUtils.A(TBSToolClientUtils.f291401a, j3, null, 2, null);
        }
    }

    private final void h(Bundle params) {
        long[] jArr;
        Activity L;
        boolean z16;
        boolean z17;
        long[] longArray = params.getLongArray("fileIdList");
        boolean z18 = false;
        if (longArray != null) {
            ArrayList arrayList = new ArrayList();
            for (long j3 : longArray) {
                if (j3 > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(Long.valueOf(j3));
                }
            }
            jArr = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        } else {
            jArr = null;
        }
        QLog.d("TBSToolIPCModule", 1, "openMyFile sessionId: " + Arrays.toString(jArr));
        if (jArr != null) {
            if (jArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z18 = true;
            }
        }
        if (z18 && (L = TBSToolClientUtils.f291401a.L()) != null) {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).jumpToMyFile(L, jArr);
        }
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (params != null && !TextUtils.isEmpty(action)) {
            if (action != null) {
                switch (action.hashCode()) {
                    case -1389363727:
                        if (action.equals("jumpToMyFile")) {
                            h(params);
                            break;
                        }
                        break;
                    case -505062682:
                        if (action.equals("openFile")) {
                            g(params);
                            break;
                        }
                        break;
                    case 1247032612:
                        if (action.equals("sendFile")) {
                            d(params);
                            break;
                        }
                        break;
                    case 2085112809:
                        if (action.equals("forwardJSRequestToTBS")) {
                            e(params, callbackId);
                            break;
                        }
                        break;
                }
            }
            return null;
        }
        QLog.d("TBSToolIPCModule", 1, "onCall empty params action: " + action + ", bundle params: " + params);
        return null;
    }

    TBSToolIPCModule(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }
}
