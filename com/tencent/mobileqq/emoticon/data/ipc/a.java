package com.tencent.mobileqq.emoticon.data.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.data.ipc.b;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/a;", "Lcom/tencent/mobileqq/emoticon/data/ipc/b$c;", "Lmqq/app/AppRuntime;", "appRuntime", "Leipc/EIPCResult;", "k", "Landroid/os/Bundle;", "params", "j", "l", "", "action", "", "callbackId", "f", "", "Lcom/tencent/mobileqq/data/EmoticonPackage;", "i", EmojiManagerServiceProxy.EPID, "Lcom/tencent/mobileqq/data/Emoticon;", h.F, "<init>", "()V", "e", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends b.c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f204747f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/a$a;", "", "", "", "b", "Lcom/tencent/mobileqq/emoticon/data/ipc/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/emoticon/data/ipc/a;", "a", "()Lcom/tencent/mobileqq/emoticon/data/ipc/a;", "ACTION_GET_SUB_EMOTICONS_BY_PACKAGE_ID", "Ljava/lang/String;", "ACTION_GET_TAB_EMOTICON_PACKAGES", "ACTION_PREFIX", "ACTION_SYNC_FIND_EMOTICON_BY_ID", "REQ_EID", "REQ_EP_ID", "RESULT_CODE", "RESULT_EMOTICON", "RESULT_EMOTICON_LIST", "RESULT_EP_LIST", "TAG", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return a.f204747f;
            }
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final List<String> b() {
            ArrayList arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("BigEmoticonDataSourceIPC.ACTION_GET_TAB_EMOTICON_PACKAGES", "BigEmoticonDataSourceIPC.ACTION_GET_SUB_EMOTICONS_BY_PACKAGE_ID");
                return arrayListOf;
            }
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27726);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            f204747f = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final EIPCResult j(AppRuntime appRuntime, Bundle params) {
        ArrayList arrayList = new ArrayList();
        String string = params.getString("REQ_EP_ID", "");
        if (!TextUtils.isEmpty(string)) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmoticonManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            arrayList.addAll(((IEmoticonManagerService) runtimeService).syncGetSubEmoticonsByPackageId(string));
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_EMOTICON_LIST", arrayList);
        EIPCResult createResult = EIPCResult.createResult(0, bundle);
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(0, bundle)");
        return createResult;
    }

    private final EIPCResult k(AppRuntime appRuntime) {
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmoticonManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((IEmoticonManagerService) runtimeService).syncGetTabEmoticonPackages(0));
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_EP_LIST", arrayList);
        EIPCResult createResult = EIPCResult.createResult(0, bundle);
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(0, bundle)");
        return createResult;
    }

    private final EIPCResult l(AppRuntime appRuntime, Bundle params) {
        String string = params.getString("REQ_EID");
        String string2 = params.getString("REQ_EP_ID");
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmoticonManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        Emoticon syncFindEmoticonById = ((IEmoticonManagerService) runtimeService).syncFindEmoticonById(string2, string);
        Bundle bundle = new Bundle();
        if (syncFindEmoticonById != null) {
            bundle.putSerializable("RESULT_EMOTICON", syncFindEmoticonById);
        }
        return EIPCResult.createResult(0, bundle);
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
        if (Intrinsics.areEqual("BigEmoticonDataSourceIPC.ACTION_GET_TAB_EMOTICON_PACKAGES", action)) {
            return k(appRuntime);
        }
        if (Intrinsics.areEqual("BigEmoticonDataSourceIPC.ACTION_GET_SUB_EMOTICONS_BY_PACKAGE_ID", action)) {
            return j(appRuntime, params);
        }
        if (Intrinsics.areEqual("BigEmoticonDataSourceIPC.ACTION_SYNC_FIND_EMOTICON_BY_ID", action)) {
            return l(appRuntime, params);
        }
        return EIPCResult.createResult(-1, new Bundle());
    }

    @Nullable
    public final List<Emoticon> h(@NotNull AppRuntime appRuntime, @NotNull String epId) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) epId);
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(epId, "epId");
        if (b.c.e()) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmoticonManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            return ((IEmoticonManagerService) runtimeService).syncGetSubEmoticonsByPackageId(epId);
        }
        Bundle bundle = new Bundle();
        bundle.putString("REQ_EP_ID", epId);
        EIPCResult b16 = b.c.b("BigEmoticonDataSourceIPC.ACTION_GET_SUB_EMOTICONS_BY_PACKAGE_ID", bundle);
        int i3 = b16.code;
        if (i3 != 0) {
            QLog.w("BigEmoticonDataSourceIPC", 1, "getSubEmoticonsByPackageId, failed, result=" + i3);
            return Collections.emptyList();
        }
        int i16 = b16.data.getInt("RESULT_CODE", 0);
        if (i16 != 0) {
            QLog.w("BigEmoticonDataSourceIPC", 1, "getSubEmoticonsByPackageId, failed, code=" + i16);
            return Collections.emptyList();
        }
        Serializable serializable = b16.data.getSerializable("RESULT_EMOTICON_LIST");
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }

    @Nullable
    public final List<EmoticonPackage> i(@NotNull AppRuntime appRuntime) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if (b.c.e()) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmoticonManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            return ((IEmoticonManagerService) runtimeService).syncGetTabEmoticonPackages(0);
        }
        EIPCResult b16 = b.c.b("BigEmoticonDataSourceIPC.ACTION_GET_TAB_EMOTICON_PACKAGES", new Bundle());
        int i3 = b16.code;
        if (i3 != 0) {
            QLog.w("BigEmoticonDataSourceIPC", 1, "getTabEmoticonPackages, failed, result=" + i3);
            return Collections.emptyList();
        }
        int i16 = b16.data.getInt("RESULT_CODE", 0);
        if (i16 != 0) {
            QLog.w("BigEmoticonDataSourceIPC", 1, "getTabEmoticonPackages, failed, code=" + i16);
            return Collections.emptyList();
        }
        Serializable serializable = b16.data.getSerializable("RESULT_EP_LIST");
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }
}
