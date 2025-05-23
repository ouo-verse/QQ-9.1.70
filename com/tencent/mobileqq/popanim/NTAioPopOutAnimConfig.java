package com.tencent.mobileqq.popanim;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.aio.event.FaceBubbleMsgEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.poke.f;
import com.tencent.mobileqq.popanim.api.IVasApngIPCModuleApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.SmallYellowFaceInfo;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\r\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/popanim/NTAioPopOutAnimConfig;", "Lcom/tencent/mobileqq/popanim/PopOutAnimConfig;", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "emoticonInfo", "", "count", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "buildElement", "", "startShakeAnimation", "stopShakeAnimation", "sendPopEmoMsg", "Lmqq/util/WeakReference;", "Lcom/tencent/aio/api/runtime/a;", "a", "Lkotlin/Lazy;", "c", "()Lmqq/util/WeakReference;", "weakAioContext", "Landroid/view/ViewGroup;", "b", "d", "weakRootView", "aioContext", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NTAioPopOutAnimConfig extends PopOutAnimConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy weakAioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy weakRootView;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/popanim/NTAioPopOutAnimConfig$a", "Lcom/tencent/image/URLDrawableHandler$Adapter;", "", "fileSize", "", "onFileDownloadSucceed", "", "errorCode", "onFileDownloadFailed", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends URLDrawableHandler.Adapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTAioPopOutAnimConfig.this);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
        public void onFileDownloadFailed(int errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode);
                return;
            }
            QLog.i("NTAioPopOutAnimConfig", 1, "onFileDownloadFailed, errorCode:" + errorCode);
        }

        @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
        public void onFileDownloadSucceed(long fileSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, fileSize);
                return;
            }
            NTAioPopOutAnimConfig.this.apngSoLoaded = true;
            QLog.i("NTAioPopOutAnimConfig", 1, "onFileDownloadSucceed, fileSize:" + fileSize);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/popanim/NTAioPopOutAnimConfig$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.popanim.NTAioPopOutAnimConfig$b, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTAioPopOutAnimConfig(@NotNull final com.tencent.aio.api.runtime.a aioContext) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<WeakReference<com.tencent.aio.api.runtime.a>>() { // from class: com.tencent.mobileqq.popanim.NTAioPopOutAnimConfig$weakAioContext$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.aio.api.runtime.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final WeakReference<com.tencent.aio.api.runtime.a> invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new WeakReference<>(com.tencent.aio.api.runtime.a.this) : (WeakReference) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.weakAioContext = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WeakReference<ViewGroup>>() { // from class: com.tencent.mobileqq.popanim.NTAioPopOutAnimConfig$weakRootView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.aio.api.runtime.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final WeakReference<ViewGroup> invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (WeakReference) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    View requireView = com.tencent.aio.api.runtime.a.this.c().requireView();
                    Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
                    return new WeakReference<>((ViewGroup) requireView);
                }
            });
            this.weakRootView = lazy2;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            this.itemCountShowAppear = com.tencent.mobileqq.stickerbubble.a.e(appInterface);
            this.itemCountRecShowAppear = com.tencent.mobileqq.stickerbubble.a.e(appInterface);
            this.supportFeedBack = f.k();
            this.maxSendCount = f.g(appInterface, 10);
            boolean isLoaded = ((IVasApngIPCModuleApi) QRoute.api(IVasApngIPCModuleApi.class)).isLoaded();
            this.apngSoLoaded = isLoaded;
            if (!isLoaded) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.popanim.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTAioPopOutAnimConfig.b(NTAioPopOutAnimConfig.this);
                    }
                }, 64, null, false);
            }
            com.tencent.mobileqq.poke.c cVar = com.tencent.mobileqq.poke.c.f258994a;
            if (cVar.g() == null) {
                cVar.k();
            }
            this.typeface = cVar.g();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NTAioPopOutAnimConfig this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IVasApngIPCModuleApi) QRoute.api(IVasApngIPCModuleApi.class)).load(new a());
    }

    private final FaceBubbleElement buildElement(SystemAndEmojiEmoticonInfo emoticonInfo, int count) {
        String str;
        if (emoticonInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NTAioPopOutAnimConfig", 1, "sendPopEmoMsg emoticonInfo is null");
                return null;
            }
            return null;
        }
        int convertToServer = QQSysFaceUtil.convertToServer(emoticonInfo.code);
        String prueFaceDescription = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(convertToServer)));
        if (prueFaceDescription == null) {
            str = "";
        } else {
            str = prueFaceDescription;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "[%s]x%d", Arrays.copyOf(new Object[]{prueFaceDescription, Integer.valueOf(count)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        String format2 = String.format("[%s]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u624b\u673aQQ\u4f53\u9a8c\u65b0\u529f\u80fd\u3002", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        SmallYellowFaceInfo smallYellowFaceInfo = new SmallYellowFaceInfo();
        smallYellowFaceInfo.index = convertToServer;
        smallYellowFaceInfo.compatibleText = str;
        smallYellowFaceInfo.text = str;
        FaceBubbleElement faceBubbleElement = new FaceBubbleElement();
        faceBubbleElement.faceType = 13;
        faceBubbleElement.faceCount = Integer.valueOf(count);
        faceBubbleElement.faceSummary = str;
        faceBubbleElement.content = format;
        faceBubbleElement.oldVersionStr = format2;
        faceBubbleElement.yellowFaceInfo = smallYellowFaceInfo;
        return faceBubbleElement;
    }

    private final WeakReference<com.tencent.aio.api.runtime.a> c() {
        return (WeakReference) this.weakAioContext.getValue();
    }

    private final WeakReference<ViewGroup> d() {
        return (WeakReference) this.weakRootView.getValue();
    }

    @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
    public void sendPopEmoMsg(@Nullable SystemAndEmojiEmoticonInfo emoticonInfo, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonInfo, count);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = c().get();
        FaceBubbleElement buildElement = buildElement(emoticonInfo, count);
        if (buildElement != null && aVar != null) {
            aVar.e().h(new FaceBubbleMsgEvent.FaceBubbleSendEvent(buildElement));
        }
    }

    @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
    public void startShakeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ViewGroup viewGroup = d().get();
        if (viewGroup != null) {
            com.tencent.mobileqq.stickerbubble.a.i(this, viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
    public void stopShakeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ViewGroup viewGroup = d().get();
        if (viewGroup != null) {
            com.tencent.mobileqq.stickerbubble.a.a(this, viewGroup);
        }
    }
}
