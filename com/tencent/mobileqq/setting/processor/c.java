package com.tencent.mobileqq.setting.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010F\u001a\u00020;\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\nJ\f\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H&J\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015R\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00109\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010?\u001a\u0010\u0012\f\u0012\n <*\u0004\u0018\u00010;0;0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0013\u0010B\u001a\u0004\u0018\u00010@8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010AR\u0013\u0010E\u001a\u0004\u0018\u00010C8F\u00a2\u0006\u0006\u001a\u0004\b=\u0010D\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/setting/processor/d;", "", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", DomainData.DOMAIN_NAME, "r", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "p", "type", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "", "isVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "I", "j", "()I", "Lcom/tencent/mobileqq/setting/processor/g;", "b", "Lcom/tencent/mobileqq/setting/processor/g;", "getProcessorRefresh", "()Lcom/tencent/mobileqq/setting/processor/g;", "u", "(Lcom/tencent/mobileqq/setting/processor/g;)V", "processorRefresh", "Lcom/tencent/mobileqq/setting/processor/f;", "c", "Lcom/tencent/mobileqq/setting/processor/f;", "i", "()Lcom/tencent/mobileqq/setting/processor/f;", "t", "(Lcom/tencent/mobileqq/setting/processor/f;)V", "processorInteraction", "d", "Lcom/tencent/mobileqq/widget/listitem/a;", "g", "()Lcom/tencent/mobileqq/widget/listitem/a;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/widget/listitem/a;)V", DownloadInfo.spKey_Config, "e", "Z", "k", "()Z", "setResume", "(Z)V", "isResume", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "f", "Ljava/lang/ref/WeakReference;", "contextRef", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/common/app/AppInterface;", "()Lcom/tencent/common/app/AppInterface;", "app", "context", "<init>", "(Landroid/content/Context;I)V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g processorRefresh;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f processorInteraction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.a<?> config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isResume;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Context> contextRef;

    public c(@NotNull Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.type = i3;
            this.contextRef = new WeakReference<>(context);
        }
    }

    @Nullable
    public final Activity e() {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Activity) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        Context context = this.contextRef.get();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        return activity;
    }

    @Nullable
    public final AppInterface f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AppInterface) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    @Nullable
    public final com.tencent.mobileqq.widget.listitem.a<?> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.config;
    }

    @Nullable
    public final c h(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (c) iPatchRedirector.redirect((short) 21, (Object) this, type);
        }
        f fVar = this.processorInteraction;
        if (fVar != null) {
            return fVar.d(type);
        }
        return null;
    }

    @Nullable
    public final f i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.processorInteraction;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.type;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isResume;
    }

    public final void l() {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.mobileqq.widget.listitem.a<?> aVar = this.config;
        if (aVar != null && (gVar = this.processorRefresh) != null) {
            gVar.c(aVar);
        }
    }

    public final void m(boolean isVisible) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, isVisible);
            return;
        }
        com.tencent.mobileqq.widget.listitem.a<?> aVar = this.config;
        if (aVar != null && (gVar = this.processorRefresh) != null) {
            gVar.a(aVar, isVisible);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.isResume = false;
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.isResume = true;
        }
    }

    public void p(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        }
    }

    @NotNull
    public abstract com.tencent.mobileqq.widget.listitem.a<?> q();

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    public final void s(@Nullable com.tencent.mobileqq.widget.listitem.a<?> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.config = aVar;
        }
    }

    public final void t(@Nullable f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
        } else {
            this.processorInteraction = fVar;
        }
    }

    public final void u(@Nullable g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
        } else {
            this.processorRefresh = gVar;
        }
    }
}
