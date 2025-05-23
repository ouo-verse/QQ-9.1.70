package com.tencent.mobileqq.emoticon.data.ipc;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.data.ipc.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J*\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/d;", "Lcom/tencent/mobileqq/emoticon/data/ipc/b$c;", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;", "Lmqq/app/AppRuntime;", "appRuntime", "Leipc/EIPCResult;", "i", "Landroid/os/Bundle;", "params", "l", "k", "j", "", "action", "", "callbackId", "f", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchResult;", "result", "", "onSearchCallBack", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "callback", DomainData.DOMAIN_NAME, "e", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;", "getEmoticonSearchCallBack", "()Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;", "setEmoticonSearchCallBack", "(Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;)V", "emoticonSearchCallBack", "Ljava/lang/String;", "getClientProcessName", "()Ljava/lang/String;", "setClientProcessName", "(Ljava/lang/String;)V", "clientProcessName", "<init>", "()V", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends b.c implements IEmotionSearchManagerService.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final d f204759i;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IEmotionSearchManagerService.a emoticonSearchCallBack;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String clientProcessName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/ipc/d$a;", "", "", "", "b", "Lcom/tencent/mobileqq/emoticon/data/ipc/d;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/emoticon/data/ipc/d;", "a", "()Lcom/tencent/mobileqq/emoticon/data/ipc/d;", "ACTION_LOAD_MORE", "Ljava/lang/String;", "ACTION_PREFIX", "ACTION_PUSH_EMOTION_SEARCH_TASK", "ACTION_SEARCH_CALLBACK", "ACTION_SET_CALLBACK", "", "ERROR_NO_CALLBACK", "I", "REQ_PROCESS_NAME", "RESULT_CODE", "RESULT_SEARCH_RESULT", "TAG", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.data.ipc.d$a, reason: from kotlin metadata */
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
        public final d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return d.f204759i;
            }
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final List<String> b() {
            ArrayList arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("HotPicDataSourceIPC.", "HotPicDataSourceIPC.ACTION_LOAD_MORE", "HotPicDataSourceIPC.ACTION_SET_CALLBACK", "HotPicDataSourceIPC.ACTION_SEARCH_CALLBACK", "HotPicDataSourceIPC.ACTION_PUSH_EMOTION_SEARCH_TASK");
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/emoticon/data/ipc/d$b", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@NotNull EIPCResult result) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = result.code;
            if (i3 != 0) {
                QLog.i("HotPicDataSourceIPC", 1, "onSearchCallBack, failed to call client, code=" + i3);
                return;
            }
            Bundle bundle = result.data;
            if (bundle != null) {
                num = Integer.valueOf(bundle.getInt("RESULT_CODE"));
            } else {
                num = null;
            }
            QLog.i("HotPicDataSourceIPC", 1, "onSearchCallBack, result-code=" + num);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27937);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
            f204759i = new d();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final EIPCResult i(AppRuntime appRuntime) {
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmotionSearchManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IEmotionSearchManagerService) runtimeService).loadMore();
        EIPCResult createResult = EIPCResult.createResult(0, new Bundle());
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(0, Bundle())");
        return createResult;
    }

    private final EIPCResult j(AppRuntime appRuntime) {
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmotionSearchManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IEmotionSearchManagerService) runtimeService).pushEmotionSearchTask(new IEmotionSearchManagerService.EmotionSearchTask(0));
        return EIPCResult.createResult(0, new Bundle());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final EIPCResult k(Bundle params) {
        Exception e16;
        IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult;
        IEmotionSearchManagerService.a aVar;
        if (this.emoticonSearchCallBack == null) {
            QLog.i("HotPicDataSourceIPC", 1, "onCallSearchCallback, callback is null");
            Bundle bundle = new Bundle();
            bundle.putInt("RESULT_CODE", 1001);
            return EIPCResult.createResult(0, bundle);
        }
        try {
            params.setClassLoader(EmotionSearchItem.class.getClassLoader());
            ArrayList<EmotionSearchItem> parcelableArrayList = params.getParcelableArrayList(VideoTemplateParser.ITEM_LIST);
            Serializable serializable = params.getSerializable("RESULT_SEARCH_RESULT");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchResult");
            emotionSearchResult = (IEmotionSearchManagerService.EmotionSearchResult) serializable;
            try {
                emotionSearchResult.itemList = parcelableArrayList;
            } catch (Exception e17) {
                e16 = e17;
                QLog.i("HotPicDataSourceIPC", 1, "onCallSearchCallback, exc=" + e16);
                aVar = this.emoticonSearchCallBack;
                if (aVar != null) {
                }
                return EIPCResult.createResult(0, new Bundle());
            }
        } catch (Exception e18) {
            e16 = e18;
            emotionSearchResult = null;
        }
        aVar = this.emoticonSearchCallBack;
        if (aVar != null) {
            aVar.onSearchCallBack(emotionSearchResult);
        }
        return EIPCResult.createResult(0, new Bundle());
    }

    private final EIPCResult l(AppRuntime appRuntime, Bundle params) {
        this.clientProcessName = params.getString("REQ_PROCESS_NAME", null);
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmotionSearchManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IEmotionSearchManagerService) runtimeService).setSearchCallBack(this);
        EIPCResult createResult = EIPCResult.createResult(0, new Bundle());
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(0, Bundle())");
        return createResult;
    }

    @Override // com.tencent.mobileqq.emoticon.data.ipc.b.c
    @Nullable
    public EIPCResult f(@NotNull AppRuntime appRuntime, @NotNull String action, @NotNull Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 6, this, appRuntime, action, params, Integer.valueOf(callbackId));
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (Intrinsics.areEqual("HotPicDataSourceIPC.ACTION_LOAD_MORE", action)) {
            return i(appRuntime);
        }
        if (Intrinsics.areEqual("HotPicDataSourceIPC.ACTION_SET_CALLBACK", action)) {
            return l(appRuntime, params);
        }
        if (Intrinsics.areEqual("HotPicDataSourceIPC.ACTION_SEARCH_CALLBACK", action)) {
            return k(params);
        }
        if (Intrinsics.areEqual("HotPicDataSourceIPC.ACTION_PUSH_EMOTION_SEARCH_TASK", action)) {
            return j(appRuntime);
        }
        QLog.i("HotPicDataSourceIPC", 1, "onCall, action not found, " + action);
        return EIPCResult.createResult(-1, new Bundle());
    }

    public final void h(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if (b.c.e()) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmotionSearchManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            ((IEmotionSearchManagerService) runtimeService).loadMore();
            return;
        }
        b.c.b("HotPicDataSourceIPC.ACTION_LOAD_MORE", new Bundle());
    }

    public final void m(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if (b.c.e()) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmotionSearchManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            ((IEmotionSearchManagerService) runtimeService).pushEmotionSearchTask(new IEmotionSearchManagerService.EmotionSearchTask(0));
            return;
        }
        b.c.b("HotPicDataSourceIPC.ACTION_PUSH_EMOTION_SEARCH_TASK", new Bundle());
    }

    public final void n(@NotNull AppRuntime appRuntime, @NotNull IEmotionSearchManagerService.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (b.c.e()) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmotionSearchManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            ((IEmotionSearchManagerService) runtimeService).setSearchCallBack(callback);
        } else {
            this.emoticonSearchCallBack = callback;
            Bundle bundle = new Bundle();
            bundle.putString("REQ_PROCESS_NAME", MobileQQ.processName);
            b.c.b("HotPicDataSourceIPC.ACTION_SET_CALLBACK", bundle);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.a
    public void onSearchCallBack(@Nullable IEmotionSearchManagerService.EmotionSearchResult result) {
        ArrayList<EmotionSearchItem> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) result);
            return;
        }
        if (TextUtils.isEmpty(this.clientProcessName)) {
            QLog.w("HotPicDataSourceIPC", 1, "onSearchCallBack, client process name is empty");
            return;
        }
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        if (result != null) {
            arrayList = result.itemList;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            arrayList2.addAll(result.itemList);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_SEARCH_RESULT", result);
        bundle.putParcelableArrayList(VideoTemplateParser.ITEM_LIST, arrayList2);
        String str = this.clientProcessName;
        Intrinsics.checkNotNull(str);
        b.c.a(str, "HotPicDataSourceIPC.ACTION_SEARCH_CALLBACK", bundle, new b());
    }
}
