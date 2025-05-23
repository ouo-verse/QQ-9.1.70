package com.tencent.mobileqq.wink.editor.subtitle.source;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.tavcut.core.render.audio.extractor.IAudioExtractorProcessor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJU\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022C\u0010\r\u001a?\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004\u00a2\u0006\u0002\b\fH\u0002JJ\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001028\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002JU\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022C\u0010\r\u001a?\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u000b0\u0004\u00a2\u0006\u0002\b\fH\u0002Jn\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022Z\u0010\r\u001aV\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000b0\u0019\u00a2\u0006\u0002\b\fH\u0016JW\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022C\u0010\r\u001a?\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004\u00a2\u0006\u0002\b\fH\u0016J_\u0010 \u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001e2C\u0010\r\u001a?\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u000b0\u0004\u00a2\u0006\u0002\b\fH\u0016JL\u0010!\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000228\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016JG\u0010'\u001a\u00020\u000e2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0&H\u0016R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010)\u001a\u0004\b*\u0010+R\u001b\u00100\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010)\u001a\u0004\b.\u0010/R\u001b\u00104\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010)\u001a\u0004\b2\u00103R\u001b\u00108\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010)\u001a\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R0\u0010F\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020Bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/DefaultSubtitleDataSource;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/f;", "", "url", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/b;", "", "Lkotlin/ParameterName;", "name", "code", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "Lkotlin/ExtensionFunctionType;", "callback", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "t", "", "bytes", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleResult;", "content", "r", "path", "u", "input", "Lkotlin/Function4;", "msg", "outputPath", "a", "e", "", "delay", "c", "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "Lkotlin/collections/ArrayList;", "lines", "Lkotlin/Function1;", "b", "Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "netEngine", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleServiceHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleServiceHandler;", "editorDataServiceHandler", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/TranslateServiceHandler;", "p", "()Lcom/tencent/mobileqq/wink/editor/subtitle/source/TranslateServiceHandler;", "translateDataServiceHandler", "Lcom/google/gson/Gson;", DomainData.DOMAIN_NAME, "()Lcom/google/gson/Gson;", "gson", "Landroid/os/Handler;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/os/Handler;", "uiHandler", "Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractorProcessor;", "g", "Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractorProcessor;", "extractor", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "extractTaskMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DefaultSubtitleDataSource implements f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DefaultSubtitleDataSource f322225a = new DefaultSubtitleDataSource();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy netEngine;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy editorDataServiceHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy translateDataServiceHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy gson;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy uiHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IAudioExtractorProcessor extractor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> extractTaskMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/DefaultSubtitleDataSource$a", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "", "cancel", "", "d", "Z", "a", "()Z", "c", "(Z)V", "canceled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.mobileqq.wink.editor.subtitle.source.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean canceled;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HttpNetReq f322234e;

        a(HttpNetReq httpNetReq) {
            this.f322234e = httpNetReq;
        }

        @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
        /* renamed from: a, reason: from getter */
        public boolean getCanceled() {
            return this.canceled;
        }

        public void c(boolean z16) {
            this.canceled = z16;
        }

        @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
        public void cancel() {
            c(true);
            DefaultSubtitleDataSource.f322225a.o().cancelReq(this.f322234e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/DefaultSubtitleDataSource$b", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, SubtitleResult, Unit> f322235d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Integer, ? super SubtitleResult, Unit> function2) {
            this.f322235d = function2;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(@Nullable NetResp resp) {
            boolean z16;
            if (resp == null) {
                this.f322235d.invoke(10000014, null);
                return;
            }
            if (resp.mResult == 0 && resp.mRespData != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            w53.b.a("DefaultSubtitleDataSource", "download onResp: " + z16);
            if (z16) {
                DefaultSubtitleDataSource defaultSubtitleDataSource = DefaultSubtitleDataSource.f322225a;
                byte[] bArr = resp.mRespData;
                Intrinsics.checkNotNullExpressionValue(bArr, "resp.mRespData");
                defaultSubtitleDataSource.r(bArr, this.f322235d);
                return;
            }
            this.f322235d.invoke(Integer.valueOf(resp.mResult), null);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(@NotNull NetReq req, long curOffset, long totalLen) {
            Intrinsics.checkNotNullParameter(req, "req");
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IHttpEngineService>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$netEngine$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IHttpEngineService invoke() {
                IRuntimeService runtimeService = com.tencent.mobileqq.wink.b.a().getRuntimeService(IHttpEngineService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface()\n      \u2026ava, ProcessConstant.ALL)");
                return (IHttpEngineService) runtimeService;
            }
        });
        netEngine = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SubtitleServiceHandler>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$editorDataServiceHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SubtitleServiceHandler invoke() {
                BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(SubtitleServiceHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.subtitle.source.SubtitleServiceHandler");
                return (SubtitleServiceHandler) businessHandler;
            }
        });
        editorDataServiceHandler = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TranslateServiceHandler>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$translateDataServiceHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TranslateServiceHandler invoke() {
                BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(TranslateServiceHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.subtitle.source.TranslateServiceHandler");
                return (TranslateServiceHandler) businessHandler;
            }
        });
        translateDataServiceHandler = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Gson invoke() {
                return new Gson();
            }
        });
        gson = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return ThreadManagerV2.getUIHandlerV2();
            }
        });
        uiHandler = lazy5;
        extractTaskMap = new HashMap<>();
    }

    DefaultSubtitleDataSource() {
    }

    private final SubtitleServiceHandler m() {
        return (SubtitleServiceHandler) editorDataServiceHandler.getValue();
    }

    private final Gson n() {
        return (Gson) gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IHttpEngineService o() {
        return (IHttpEngineService) netEngine.getValue();
    }

    private final TranslateServiceHandler p() {
        return (TranslateServiceHandler) translateDataServiceHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler q() {
        Object value = uiHandler.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-uiHandler>(...)");
        return (Handler) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(byte[] bytes, Function2<? super Integer, ? super SubtitleResult, Unit> callback) {
        try {
            String str = new String(bytes, Charsets.UTF_8);
            if (TextUtils.isEmpty(str)) {
                callback.invoke(1000016, null);
                return;
            }
            try {
                SubtitleResult subtitleResult = (SubtitleResult) n().fromJson(str, SubtitleResult.class);
                if (subtitleResult == null) {
                    callback.invoke(1000018, null);
                    w53.b.c("DefaultSubtitleDataSource", "loadAndParseResult parse empty");
                } else {
                    callback.invoke(0, subtitleResult);
                }
            } catch (Throwable th5) {
                callback.invoke(1000017, null);
                w53.b.d("DefaultSubtitleDataSource", "loadAndParseResult parse " + th5, th5);
            }
        } catch (Throwable th6) {
            callback.invoke(1000015, null);
            w53.b.d("DefaultSubtitleDataSource", "loadAndParseResult load " + th6, th6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String str, int i3) {
        f322225a.m().w3(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.editor.subtitle.source.a t(String url, Function3<? super com.tencent.mobileqq.wink.editor.subtitle.source.b, ? super Integer, ? super String, Unit> callback) {
        c cVar = new c();
        int hashCode = url.hashCode();
        DefaultSubtitleDataSource$submitUrl$submitObserver$1 defaultSubtitleDataSource$submitUrl$submitObserver$1 = new DefaultSubtitleDataSource$submitUrl$submitObserver$1(cVar, hashCode, callback);
        com.tencent.mobileqq.wink.b.a().addObserver(defaultSubtitleDataSource$submitUrl$submitObserver$1);
        m().x3(url, hashCode);
        return defaultSubtitleDataSource$submitUrl$submitObserver$1;
    }

    private final com.tencent.mobileqq.wink.editor.subtitle.source.a u(String path, Function3<? super com.tencent.mobileqq.wink.editor.subtitle.source.b, ? super Integer, ? super String, Unit> callback) {
        DefaultSubtitleDataSource$uploadAudioFile$uploadListener$1 defaultSubtitleDataSource$uploadAudioFile$uploadListener$1 = new DefaultSubtitleDataSource$uploadAudioFile$uploadListener$1(new c(), path, callback);
        com.tencent.mobileqq.wink.edit.manager.g.c(path, FileUtils.getExtension(path), defaultSubtitleDataSource$uploadAudioFile$uploadListener$1);
        return defaultSubtitleDataSource$uploadAudioFile$uploadListener$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.f
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.wink.editor.subtitle.source.a a(@Nullable String input, @NotNull Function4<? super com.tencent.mobileqq.wink.editor.subtitle.source.b, ? super Integer, ? super String, ? super String, Unit> callback) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(callback, "callback");
        IAudioExtractorProcessor iAudioExtractorProcessor = extractor;
        if (iAudioExtractorProcessor == null) {
            iAudioExtractorProcessor = rd4.c.f431135f.c();
        }
        extractor = iAudioExtractorProcessor;
        if (input != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(input);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    callback.invoke(g.b(), 1000000, "invalid input " + input, null);
                    return g.b();
                }
                if (!new File(input).exists()) {
                    callback.invoke(g.b(), 1000000, "invalid input file " + input, null);
                    return g.b();
                }
                File file = new File(com.tencent.mobileqq.wink.b.c().getCacheDir(), "/wink/edit_subtitle_tmp");
                if (!file.exists() && !file.mkdirs()) {
                    callback.invoke(g.b(), 1000001, "can not create cache dir " + file.getAbsolutePath(), null);
                    return g.b();
                }
                File file2 = new File(file, com.tencent.open.base.g.d(input) + ".mp4");
                if (file2.exists() && !file2.delete()) {
                    callback.invoke(g.b(), 1000003, "can not delete tmp file " + file2.getAbsolutePath(), null);
                    return g.b();
                }
                DefaultSubtitleDataSource$extractAudio$cancelableListener$1 defaultSubtitleDataSource$extractAudio$cancelableListener$1 = new DefaultSubtitleDataSource$extractAudio$cancelableListener$1(new c(), input, callback);
                String absolutePath = file2.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "tmpFile.absolutePath");
                extractTaskMap.put(input, iAudioExtractorProcessor.extractAudioFromVideo(input, absolutePath, defaultSubtitleDataSource$extractAudio$cancelableListener$1));
                return defaultSubtitleDataSource$extractAudio$cancelableListener$1;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.f
    @NotNull
    public com.tencent.mobileqq.wink.editor.subtitle.source.a b(@Nullable ArrayList<Subtitle> lines, @NotNull Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (lines != null && lines.size() != 0) {
            p().r3(lines);
            DefaultSubtitleDataSource$updateTranslateResult$translateObserver$1 defaultSubtitleDataSource$updateTranslateResult$translateObserver$1 = new DefaultSubtitleDataSource$updateTranslateResult$translateObserver$1(new c(), callback, lines);
            com.tencent.mobileqq.wink.b.a().addObserver(defaultSubtitleDataSource$updateTranslateResult$translateObserver$1);
            return defaultSubtitleDataSource$updateTranslateResult$translateObserver$1;
        }
        callback.invoke(1000011);
        return g.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.f
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.wink.editor.subtitle.source.a c(@Nullable final String taskId, long delay, @NotNull Function3<? super com.tencent.mobileqq.wink.editor.subtitle.source.b, ? super Integer, ? super String, Unit> callback) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (taskId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(taskId);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    callback.invoke(g.b(), 1000010, null);
                    return g.b();
                }
                final int hashCode = taskId.hashCode();
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultSubtitleDataSource.s(taskId, hashCode);
                    }
                };
                DefaultSubtitleDataSource$queryResult$queryObserver$1 defaultSubtitleDataSource$queryResult$queryObserver$1 = new DefaultSubtitleDataSource$queryResult$queryObserver$1(new c(), hashCode, runnable, callback);
                com.tencent.mobileqq.wink.b.a().addObserver(defaultSubtitleDataSource$queryResult$queryObserver$1);
                if (delay > 0) {
                    q().postDelayed(runnable, delay);
                } else {
                    runnable.run();
                }
                return defaultSubtitleDataSource$queryResult$queryObserver$1;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.f
    @NotNull
    public com.tencent.mobileqq.wink.editor.subtitle.source.a d(@Nullable String url, @NotNull Function2<? super Integer, ? super SubtitleResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Uri.parse(url);
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mReqUrl = url;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mExcuteTimeLimit = 20000L;
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            httpNetReq.mCallback = new b(callback);
            o().sendReq(httpNetReq);
            return new a(httpNetReq);
        } catch (Throwable th5) {
            w53.b.d("DefaultSubtitleDataSource", "download result: " + th5, th5);
            callback.invoke(1000013, null);
            return g.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.f
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.wink.editor.subtitle.source.a e(@Nullable String path, @NotNull final Function3<? super com.tencent.mobileqq.wink.editor.subtitle.source.b, ? super Integer, ? super String, Unit> callback) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (path != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(path);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    callback.invoke(g.b(), 1000004, null);
                    return g.b();
                }
                if (!new File(path).exists()) {
                    callback.invoke(g.b(), 1000004, null);
                    return g.b();
                }
                return u(path, new Function3<com.tencent.mobileqq.wink.editor.subtitle.source.b, Integer, String, Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$submitAudio$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(b bVar, Integer num, String str) {
                        invoke(bVar, num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull b uploadAudioFile, int i3, @Nullable String str) {
                        a t16;
                        Intrinsics.checkNotNullParameter(uploadAudioFile, "$this$uploadAudioFile");
                        if (i3 != 0) {
                            callback.invoke(uploadAudioFile, Integer.valueOf(i3), null);
                            return;
                        }
                        try {
                            Uri.parse(str);
                        } catch (Throwable th5) {
                            w53.b.d("DefaultSubtitleDataSource", "parse uploaded url: " + th5, th5);
                            callback.invoke(uploadAudioFile, 1000008, null);
                        }
                        DefaultSubtitleDataSource defaultSubtitleDataSource = DefaultSubtitleDataSource.f322225a;
                        Intrinsics.checkNotNull(str);
                        t16 = defaultSubtitleDataSource.t(str, callback);
                        uploadAudioFile.b(t16);
                    }
                });
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
