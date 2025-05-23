package com.tencent.qqnt.aio.part;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/part/i;", "Lcom/tencent/biz/richframework/part/Part;", "", QzoneIPCModule.RESULT_CODE, "", "x9", "requestCode", "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/qqnt/aio/a;", "d", "Lcom/tencent/qqnt/aio/a;", "getAioContext", "()Lcom/tencent/qqnt/aio/a;", "aioContext", "<init>", "(Lcom/tencent/qqnt/aio/a;)V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class i extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.aio.a aioContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/part/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.part.i$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63722);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i(@NotNull com.tencent.qqnt.aio.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
        } else {
            this.aioContext = aioContext;
        }
    }

    private final void x9(int resultCode) {
        int i3 = 1;
        QLog.i("OpenEmoticonPanelPart", 1, "doSendMsgIntent, resultCode:" + resultCode);
        switch (resultCode) {
            case 1001:
                i3 = 17;
                break;
            case 1002:
                i3 = 18;
                break;
            case 1003:
                i3 = 20;
                break;
        }
        this.aioContext.b(new EmotionPanelMsgIntent.SetEmotionPanelDefaultType(i3));
        this.aioContext.b(new PanelContainerMsgIntent.ShowPanelMsgIntent("OpenEmoticonPanelPart", 1001, false, 0, 12, null));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (requestCode == 30007) {
            switch (resultCode) {
                case 1001:
                case 1002:
                case 1003:
                    x9(resultCode);
                    return;
                default:
                    return;
            }
        } else if (requestCode == 30009) {
            this.aioContext.b(EmotionPanelMsgIntent.RefreshEmotionPanel.f205387d);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null && intent.getBooleanExtra(AppConstants.Key.OPEN_ZPLAN_EMOTICON_TAB, false)) {
            x9(1001);
            activity.getIntent().putExtra(AppConstants.Key.OPEN_ZPLAN_EMOTICON_TAB, false);
        }
    }
}
