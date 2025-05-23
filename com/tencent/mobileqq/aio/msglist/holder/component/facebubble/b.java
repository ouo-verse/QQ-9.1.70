package com.tencent.mobileqq.aio.msglist.holder.component.facebubble;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "", QQSysAndEmojiResInfo.EMO_ID, "count", "index", "", "B", "(IILjava/lang/Integer;)V", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "Lcom/tencent/qqnt/aio/holder/a;", "intent", "o", "f", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean A() {
        e.a aVar = (e.a) ((com.tencent.aio.api.runtime.a) getMContext()).e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(int emoId, int count, Integer index) {
        Bundle bundle;
        AIOParam g16;
        if (A()) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        Object obj = null;
        if (aVar != null && (g16 = aVar.g()) != null) {
            bundle = g16.l();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            obj = bundle.get("key_from");
        }
        if (Intrinsics.areEqual(obj, "13")) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOFaceBubbleContentComponent", 2, "\u804a\u5929\u5386\u53f2\u8fdb\u5165 \u4e0d\u64ad\u653e");
            }
        } else {
            if (emoId == 13 && index != null) {
                if (index.intValue() >= 0) {
                    ((IAIOPEPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPEPanelApi.class)).playPopEmoAnimation((com.tencent.aio.api.runtime.a) getMContext(), index.intValue(), count);
                    return;
                }
                return;
            }
            ((IAIOPEPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPEPanelApi.class)).playPokeEmoAnimation((com.tencent.aio.api.runtime.a) getMContext(), emoId, count);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d) {
            d dVar = (d) intent;
            B(dVar.b(), dVar.a(), dVar.c());
        } else {
            if (intent instanceof c) {
                IAIOPEPanelApi iAIOPEPanelApi = (IAIOPEPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPEPanelApi.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                iAIOPEPanelApi.checkPEResDownloaded(peekAppRuntime, (com.tencent.aio.api.runtime.a) getMContext());
                return;
            }
            super.handleIntent(intent);
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.aioContext = context;
        super.onCreate(context);
    }
}
