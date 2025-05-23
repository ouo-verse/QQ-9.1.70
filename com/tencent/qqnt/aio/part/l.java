package com.tencent.qqnt.aio.part;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/part/l;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/content/Intent;", "data", "", "z9", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/tencent/qqnt/aio/a;", "d", "Lcom/tencent/qqnt/aio/a;", "getAioContext", "()Lcom/tencent/qqnt/aio/a;", "aioContext", "<init>", "(Lcom/tencent/qqnt/aio/a;)V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.aio.a aioContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/part/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.part.l$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63725);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l(@NotNull com.tencent.qqnt.aio.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
        } else {
            this.aioContext = aioContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A9(l this$0, int i3, QQAppInterface app, String str, String str2, String str3, String str4, String str5, String str6, Ref.ObjectRef poiId, Ref.ObjectRef latSpan, Ref.ObjectRef lngSpan, Bundle bundle, HashMap hashMap) {
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(poiId, "$poiId");
        Intrinsics.checkNotNullParameter(latSpan, "$latSpan");
        Intrinsics.checkNotNullParameter(lngSpan, "$lngSpan");
        if (hashMap != null) {
            l3 = (Long) hashMap.get(this$0.aioContext.a().j());
        } else {
            l3 = null;
        }
        QLog.d("SendLocationPart", 1, "doOnActivityResultOkLbs uin:" + LogUtil.wrapLogUin(String.valueOf(l3)));
        if (l3 != null) {
            l3.longValue();
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = i3;
            sessionInfo.f179559f = l3.toString();
            sessionInfo.f179557e = l3.toString();
            ChatActivityFacade.S(this$0.getContext(), app, sessionInfo, str, str2, str3, str4, str5, str6, (String) poiId.element, (String) latSpan.element, (String) lngSpan.element, bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, java.lang.String] */
    private final void z9(Intent data) {
        QQAppInterface qQAppInterface;
        HashSet<String> hashSetOf;
        com.tencent.biz.map.d.f78690a.b();
        QLog.i("SendLocationPart", 1, "doOnActivityResultOkLbs LBS_REQUEST");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        final QQAppInterface qQAppInterface2 = qQAppInterface;
        if (qQAppInterface2 == null) {
            return;
        }
        if (data == null) {
            QLog.d("SendLocationPart", 2, "doOnActivityResultOkLbs data is null");
            return;
        }
        final Bundle extras = data.getExtras();
        if (extras == null) {
            QLog.d("SendLocationPart", 2, "doOnActivityResultOkLbs dataExtras is null");
            return;
        }
        final String string = extras.getString("latitude");
        final String string2 = extras.getString("longitude");
        final String string3 = extras.getString("description");
        final String string4 = extras.getString("title");
        final String string5 = extras.getString("summary");
        final String string6 = extras.getString("dianping_id");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = extras.getString("poiId");
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = extras.getString("latSpan");
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        ?? string7 = extras.getString("lngSpan");
        objectRef3.element = string7;
        if (objectRef.element == 0 || objectRef2.element == 0 || string7 == 0) {
            objectRef.element = "";
            objectRef2.element = "";
            objectRef3.element = "";
        }
        QLog.d("SendLocationPart", 1, "doOnActivityResultOkLbs data = " + data.getExtras());
        final int c16 = com.tencent.nt.adapter.session.c.c(this.aioContext.a().e());
        if (c16 == 1) {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = c16;
            sessionInfo.f179559f = this.aioContext.a().j();
            sessionInfo.f179557e = this.aioContext.a().j();
            ChatActivityFacade.S(getContext(), qQAppInterface2, sessionInfo, string, string2, string3, string4, string5, string6, (String) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, extras);
            return;
        }
        ag uixConvertService = ((IKernelService) qQAppInterface2.getRuntimeService(IKernelService.class, "")).getUixConvertService();
        Intrinsics.checkNotNull(uixConvertService, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IUixConvertService");
        hashSetOf = SetsKt__SetsKt.hashSetOf(this.aioContext.a().j());
        uixConvertService.getUin(hashSetOf, new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.aio.part.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
            public final void onResult(HashMap hashMap) {
                l.A9(l.this, c16, qQAppInterface2, string, string2, string3, string4, string5, string6, objectRef, objectRef2, objectRef3, extras, hashMap);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            if (requestCode != 18) {
                return;
            }
            z9(data);
        }
    }
}
