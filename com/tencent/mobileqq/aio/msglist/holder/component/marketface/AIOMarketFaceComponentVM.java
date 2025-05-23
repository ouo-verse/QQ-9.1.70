package com.tencent.mobileqq.aio.msglist.holder.component.marketface;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.c;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.emotion.api.IEmojiManagerService;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.config.a;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0002/0B\u0007\u00a2\u0006\u0004\b,\u0010-J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\bH\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponentVM;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picElement", "Landroid/view/View;", "imageView", "", "M", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$a;", "intent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$d;", "H", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$c;", "G", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$b;", "D", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$e;", "P", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/emotion/adapter/api/a;", "info", "K", "marketFaceInfo", "L", "J", "", "type", "", "N", "O", "Lcom/tencent/qqnt/aio/holder/a;", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponentVM$b;", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponentVM$b;", "jsonDownloadListener", "<init>", "()V", h.F, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMarketFaceComponentVM extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b jsonDownloadListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponentVM$a;", "", "", "JOB_MAGIC", "I", "JOB_NORMAL", "JOB_SMALL", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponentVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponentVM$b;", "Lcom/tencent/qqnt/emotion/manager/b;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "opType", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "", "b", "Lcom/tencent/mobileqq/data/EmoticonPackage;", "ep", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "params", "a", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "I", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends com.tencent.qqnt.emotion.manager.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<com.tencent.aio.api.runtime.a> aioContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int opType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private MarketFaceElement marketFaceElement;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.emotion.manager.b
        public void a(@NotNull EmoticonPackage ep5, int resultCode, @Nullable Bundle params) {
            WeakReference<com.tencent.aio.api.runtime.a> weakReference;
            com.tencent.aio.api.runtime.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, ep5, Integer.valueOf(resultCode), params);
                return;
            }
            Intrinsics.checkNotNullParameter(ep5, "ep");
            if (QLog.isColorLevel()) {
                QLog.d("MarketFaceItemBuilder", 2, "onJsonComplete:" + ep5.epId);
            }
            if (resultCode == 0) {
                String str = ep5.epId;
                MarketFaceElement marketFaceElement = this.marketFaceElement;
                MarketFaceElement marketFaceElement2 = null;
                if (marketFaceElement == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("marketFaceElement");
                    marketFaceElement = null;
                }
                if (Intrinsics.areEqual(str, String.valueOf(marketFaceElement.emojiPackageId)) && (weakReference = this.aioContext) != null && (aVar = weakReference.get()) != null) {
                    IEmosmService iEmosmService = (IEmosmService) QRoute.api(IEmosmService.class);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    MarketFaceElement marketFaceElement3 = this.marketFaceElement;
                    if (marketFaceElement3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("marketFaceElement");
                    } else {
                        marketFaceElement2 = marketFaceElement3;
                    }
                    iEmosmService.sendEmoticon(peekAppRuntime, aVar, marketFaceElement2);
                }
            }
        }

        public final void b(@NotNull com.tencent.aio.api.runtime.a aioContext, int opType, @NotNull MarketFaceElement marketFaceElement) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, aioContext, Integer.valueOf(opType), marketFaceElement);
                return;
            }
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(marketFaceElement, "marketFaceElement");
            this.aioContext = new WeakReference<>(aioContext);
            this.opType = opType;
            this.marketFaceElement = marketFaceElement;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMarketFaceComponentVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.jsonDownloadListener = new b();
        }
    }

    private final void C(c.a intent) {
        ((IAIOMarketFaceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOMarketFaceApi.class)).enterMarketFacePreview(intent.a(), intent.c(), intent.b());
    }

    private final void D(c.b intent) {
        final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (!(waitAppRuntime instanceof BaseQQAppInterface)) {
            return;
        }
        final MarketFaceElement a16 = intent.a();
        ((IEmoticonManagerService) ((BaseQQAppInterface) waitAppRuntime).getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(String.valueOf(a16.emojiPackageId), new com.tencent.qqnt.emotion.c() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.b
            @Override // com.tencent.qqnt.emotion.c
            public final void postQuery(Object obj) {
                AIOMarketFaceComponentVM.F(AIOMarketFaceComponentVM.this, a16, waitAppRuntime, (EmoticonPackage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F(AIOMarketFaceComponentVM this$0, MarketFaceElement marketFaceElement, AppRuntime appRuntime, EmoticonPackage emoticonPackage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(marketFaceElement, "$marketFaceElement");
        if (emoticonPackage == null) {
            this$0.jsonDownloadListener.b((com.tencent.aio.api.runtime.a) this$0.getMContext(), 107, marketFaceElement);
            IRuntimeService runtimeService = ((BaseQQAppInterface) appRuntime).getRuntimeService(IEmojiManagerService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IE\u2026nagerService::class.java)");
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) runtimeService;
            iEmojiManagerService.getEmojiListenerManager().b(this$0.jsonDownloadListener);
            iEmojiManagerService.startDownloadEmosmJson(String.valueOf(marketFaceElement.emojiPackageId), com.tencent.qqnt.emotion.constant.c.f356199a);
            return;
        }
        ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmoticon(MobileQQ.sMobileQQ.peekAppRuntime(), (com.tencent.aio.api.runtime.a) this$0.getMContext(), marketFaceElement);
    }

    private final void G(c.C7309c intent) {
        MarketFaceElement marketFaceElement;
        MsgElement firstTypeElement = intent.a().getFirstTypeElement(11);
        if (firstTypeElement != null) {
            marketFaceElement = firstTypeElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        if (marketFaceElement != null) {
            QRouteApi api = QRoute.api(IMarketFaceTailConfigExt.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMarketFaceTailConfigExt::class.java)");
            IMarketFaceTailConfigExt iMarketFaceTailConfigExt = (IMarketFaceTailConfigExt) api;
            Pair<String, String> tailConfig = iMarketFaceTailConfigExt.getTailConfig(String.valueOf(marketFaceElement.emojiPackageId));
            if (tailConfig != null && !TextUtils.isEmpty(tailConfig.getSecond())) {
                Context baseContext = MobileQQ.sMobileQQ.getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "sMobileQQ.baseContext");
                iMarketFaceTailConfigExt.openUrl(baseContext, tailConfig.getSecond());
            }
        }
    }

    private final void H(c.d intent) {
        MarketFaceElement marketFaceElement;
        MsgElement firstTypeElement = intent.a().getFirstTypeElement(11);
        if (firstTypeElement != null) {
            marketFaceElement = firstTypeElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        if (marketFaceElement != null) {
            com.tencent.qqnt.emotion.config.a a16 = com.tencent.qqnt.emotion.config.a.INSTANCE.a();
            String valueOf = String.valueOf(marketFaceElement.emojiPackageId);
            String str = marketFaceElement.emojiId;
            Intrinsics.checkNotNullExpressionValue(str, "marketFaceElement.emojiId");
            a.b a17 = a16.a(valueOf, str);
            if (a17 != null && !TextUtils.isEmpty(a17.a())) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOMarketFaceComponentVM", 2, "handleClickTailView jumpurl = " + a17.a());
                    return;
                }
                return;
            }
            QLog.d("AIOMarketFaceComponentVM", 1, "handleClickTailView error, jumpurl is empty!");
        }
    }

    private final void J(com.tencent.qqnt.emotion.adapter.api.a marketFaceInfo) {
        QLog.i("AIOMarketFaceComponentVM", 1, "handleMagicMarketFace");
        updateUI(new AIOMarketFaceUIState$MarketFaceInfoUpdateState(marketFaceInfo, 0, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(com.tencent.qqnt.emotion.adapter.api.a info) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMarketFaceComponentVM", 4, "handleSuccess type=" + info.b());
        }
        if (O(info.b())) {
            L(info);
        } else if (N(info.b())) {
            J(info);
        } else {
            QLog.i("AIOMarketFaceComponentVM", 1, "unSupport MarketFace");
        }
    }

    private final void L(com.tencent.qqnt.emotion.adapter.api.a marketFaceInfo) {
        updateUI(new AIOMarketFaceUIState$MarketFaceInfoUpdateState(marketFaceInfo, 0, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M(AIOMsgItem msgItem, MsgElement picElement, View imageView) {
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, peekAppRuntime, requireContext, imageView, msgItem, picElement, false, null, null, false, 256, null);
    }

    private final boolean N(int type) {
        if (type == 2) {
            return true;
        }
        return false;
    }

    private final boolean O(int type) {
        if (type == 0) {
            return true;
        }
        return false;
    }

    private final void P(c.e intent) {
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new AIOMarketFaceComponentVM$requestDownloadMarketFaceResource$1(intent, this, null), 3, null);
    }

    private final void Q(c.f intent) {
        MarketFaceElement b16 = intent.b();
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMarketFaceComponentVM", 4, "begin==queryMarketFacePkg ThreadName=" + Thread.currentThread().getName() + " intent=" + intent + " data=" + b16);
        }
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new AIOMarketFaceComponentVM$requestMarketFaceInfo$1(b16, this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.f) {
            Q((c.f) intent);
            return;
        }
        if (intent instanceof c.e) {
            P((c.e) intent);
            return;
        }
        if (intent instanceof d.ac) {
            d.ac acVar = (d.ac) intent;
            M(acVar.b(), acVar.c(), acVar.a());
            return;
        }
        if (intent instanceof c.a) {
            C((c.a) intent);
            return;
        }
        if (intent instanceof c.d) {
            H((c.d) intent);
            return;
        }
        if (intent instanceof c.C7309c) {
            G((c.C7309c) intent);
            return;
        }
        if (intent instanceof c.b) {
            D((c.b) intent);
        } else if (intent instanceof d.ad) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOReserve1CreateModelIntent("audio_button", new AIOMsgListEvent.PlayAudio(((d.ad) intent).a())));
        } else {
            super.handleIntent(intent);
        }
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMarketFaceComponentVM", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime != null) {
            com.tencent.qqnt.emotion.manager.c emojiListenerManager = ((IEmojiManagerService) waitAppRuntime.getRuntimeService(IEmojiManagerService.class, "")).getEmojiListenerManager();
            Intrinsics.checkNotNullExpressionValue(emojiListenerManager, "it.getRuntimeService(IEm\u2026getEmojiListenerManager()");
            emojiListenerManager.a(this.jsonDownloadListener);
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMarketFaceComponentVM", 4, "onCreate");
        }
    }
}
