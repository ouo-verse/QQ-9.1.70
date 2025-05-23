package com.tencent.qqnt.kernel.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiPathInfo;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiByIdReq;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiByUrlReq;
import com.tencent.qqnt.kernel.nativeinterface.GetBaseEmojiPathReq;
import com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdWithUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchFullSysEmojisCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PullSysEmojisReq;
import com.tencent.qqnt.kernel.nativeinterface.PullSysEmojisRsp;
import com.tencent.qqnt.kernel.nativeinterface.SysEmoji;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001/B\u0019\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-JN\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00000\nH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JN\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00112#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00000\nH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JN\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00142#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00000\nH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020 H\u0016J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010&\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020'H\u0016\u00a8\u00060"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/BaseEmojiService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBaseEmojiListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBaseEmojiService;", "Lcom/tencent/qqnt/kernel/api/i;", "T", "", "method", "Lcom/tencent/qqnt/kernel/nativeinterface/IDownloadBaseEmojiByIdWithUrlCallback;", "cb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uCb", WidgetCacheConstellationData.WORK, "z4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IDownloadBaseEmojiByIdWithUrlCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchFullSysEmojisCallback;", "A4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IFetchFullSysEmojisCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDownloadBaseEmojiByIdCallback;", "y4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IDownloadBaseEmojiByIdCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "result", "H4", "B4", "E4", "Lcom/tencent/qqnt/kernel/nativeinterface/PullSysEmojisReq;", "req", "callback", "", "fetchFullSysEmojis", "Lcom/tencent/qqnt/kernel/nativeinterface/GetBaseEmojiPathReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/BaseEmojiPathInfo;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadBaseEmojiByUrlReq;", "downloadBaseEmojiByIdWithUrl", "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadBaseEmojiByIdReq;", "downloadBaseEmojiById", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "delAllBaseEmojiResource", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBaseEmojiService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class BaseEmojiService extends BaseService<IKernelBaseEmojiListener, IKernelBaseEmojiService> implements com.tencent.qqnt.kernel.api.i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/BaseEmojiService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseEmojiService(@Nullable IKernelBaseEmojiService iKernelBaseEmojiService, @NotNull py content) {
        super("Emoji", content, iKernelBaseEmojiService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelBaseEmojiService, (Object) content);
        }
    }

    private final <T> T A4(String method, final IFetchFullSysEmojisCallback cb5, final Function1<? super IFetchFullSysEmojisCallback, ? extends T> work) {
        return (T) getContent().e().p(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$check$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ IFetchFullSysEmojisCallback $cb;
            final /* synthetic */ Function1<IFetchFullSysEmojisCallback, T> $work;
            final /* synthetic */ BaseEmojiService this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, work, this, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IFetchFullSysEmojisCallback B4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (T) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                Function1<IFetchFullSysEmojisCallback, T> function1 = this.$work;
                B4 = this.this$0.B4(this.$cb);
                return function1.invoke(B4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFetchFullSysEmojisCallback B4(final IFetchFullSysEmojisCallback result) {
        if (result != null) {
            return new IFetchFullSysEmojisCallback() { // from class: com.tencent.qqnt.kernel.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchFullSysEmojisCallback
                public final void onResult(int i3, String str, PullSysEmojisRsp pullSysEmojisRsp) {
                    BaseEmojiService.C4(BaseEmojiService.this, result, i3, str, pullSysEmojisRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C4(BaseEmojiService this$0, final IFetchFullSysEmojisCallback it, final int i3, final String str, final PullSysEmojisRsp pullSysEmojisRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                BaseEmojiService.D4(i3, it, str, pullSysEmojisRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D4(int i3, IFetchFullSysEmojisCallback it, String str, PullSysEmojisRsp pullSysEmojisRsp) {
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.e(KLog.f359087a, "Emoji", new Object[]{TuplesKt.to("result", Integer.valueOf(i3))}, null, 4, null);
        it.onResult(i3, str, pullSysEmojisRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IDownloadBaseEmojiByIdCallback E4(final IDownloadBaseEmojiByIdCallback result) {
        if (result != null) {
            return new IDownloadBaseEmojiByIdCallback() { // from class: com.tencent.qqnt.kernel.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdCallback
                public final void onResult(int i3, String str, SysEmoji sysEmoji, BaseEmojiPathInfo baseEmojiPathInfo) {
                    BaseEmojiService.F4(BaseEmojiService.this, result, i3, str, sysEmoji, baseEmojiPathInfo);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F4(BaseEmojiService this$0, final IDownloadBaseEmojiByIdCallback it, final int i3, final String str, final SysEmoji sysEmoji, final BaseEmojiPathInfo baseEmojiPathInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                BaseEmojiService.G4(i3, it, str, sysEmoji, baseEmojiPathInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G4(int i3, IDownloadBaseEmojiByIdCallback it, String str, SysEmoji sysEmoji, BaseEmojiPathInfo baseEmojiPathInfo) {
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.e(KLog.f359087a, "Emoji", new Object[]{TuplesKt.to("result", Integer.valueOf(i3))}, null, 4, null);
        it.onResult(i3, str, sysEmoji, baseEmojiPathInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IDownloadBaseEmojiByIdWithUrlCallback H4(final IDownloadBaseEmojiByIdWithUrlCallback result) {
        if (result != null) {
            return new IDownloadBaseEmojiByIdWithUrlCallback() { // from class: com.tencent.qqnt.kernel.api.impl.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdWithUrlCallback
                public final void onResult(int i3, String str, BaseEmojiPathInfo baseEmojiPathInfo) {
                    BaseEmojiService.I4(BaseEmojiService.this, result, i3, str, baseEmojiPathInfo);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I4(BaseEmojiService this$0, final IDownloadBaseEmojiByIdWithUrlCallback it, final int i3, final String str, final BaseEmojiPathInfo baseEmojiPathInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                BaseEmojiService.J4(i3, it, str, baseEmojiPathInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J4(int i3, IDownloadBaseEmojiByIdWithUrlCallback it, String str, BaseEmojiPathInfo baseEmojiPathInfo) {
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.e(KLog.f359087a, "Emoji", new Object[]{TuplesKt.to("result", Integer.valueOf(i3))}, null, 4, null);
        it.onResult(i3, str, baseEmojiPathInfo);
    }

    private final <T> T y4(String method, final IDownloadBaseEmojiByIdCallback cb5, final Function1<? super IDownloadBaseEmojiByIdCallback, ? extends T> work) {
        return (T) getContent().e().n(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$check$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ IDownloadBaseEmojiByIdCallback $cb;
            final /* synthetic */ Function1<IDownloadBaseEmojiByIdCallback, T> $work;
            final /* synthetic */ BaseEmojiService this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, work, this, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IDownloadBaseEmojiByIdCallback E4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (T) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                Function1<IDownloadBaseEmojiByIdCallback, T> function1 = this.$work;
                E4 = this.this$0.E4(this.$cb);
                return function1.invoke(E4);
            }
        });
    }

    private final <T> T z4(String method, final IDownloadBaseEmojiByIdWithUrlCallback cb5, final Function1<? super IDownloadBaseEmojiByIdWithUrlCallback, ? extends T> work) {
        return (T) getContent().e().o(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$check$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IDownloadBaseEmojiByIdWithUrlCallback $cb;
            final /* synthetic */ Function1<IDownloadBaseEmojiByIdWithUrlCallback, T> $work;
            final /* synthetic */ BaseEmojiService this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, work, this, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IDownloadBaseEmojiByIdWithUrlCallback H4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (T) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                Function1<IDownloadBaseEmojiByIdWithUrlCallback, T> function1 = this.$work;
                H4 = this.this$0.H4(this.$cb);
                return function1.invoke(H4);
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.i
    @Nullable
    public BaseEmojiPathInfo S(@NotNull final GetBaseEmojiPathReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseEmojiPathInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        HashMap hashMap = (HashMap) check("getBaseEmojiPathByIds", new Function0<HashMap<String, BaseEmojiPathInfo>>(this) { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$getBaseEmojiPathById$resultList$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseEmojiService this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GetBaseEmojiPathReq.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final HashMap<String, BaseEmojiPathInfo> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ArrayList<GetBaseEmojiPathReq> arrayList = new ArrayList<>();
                arrayList.add(GetBaseEmojiPathReq.this);
                IKernelBaseEmojiService service = this.this$0.getService();
                if (service != null) {
                    return service.getBaseEmojiPathByIds(arrayList);
                }
                return null;
            }
        });
        if (hashMap != null) {
            return (BaseEmojiPathInfo) hashMap.get(req.emojiId);
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.i
    public void delAllBaseEmojiResource(@NotNull IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            check("delAllBaseEmojiResource", callback, new Function1<IOperateCallback, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$delAllBaseEmojiResource$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseEmojiService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBaseEmojiService service = BaseEmojiService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.delAllBaseEmojiResource(iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.i
    public void downloadBaseEmojiById(@NotNull final DownloadBaseEmojiByIdReq req, @Nullable IDownloadBaseEmojiByIdCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            y4("downloadBaseEmojiById", callback, new Function1<IDownloadBaseEmojiByIdCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$downloadBaseEmojiById$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DownloadBaseEmojiByIdReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseEmojiService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IDownloadBaseEmojiByIdCallback iDownloadBaseEmojiByIdCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iDownloadBaseEmojiByIdCallback);
                    }
                    IKernelBaseEmojiService service = BaseEmojiService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.downloadBaseEmojiById(this.$req, iDownloadBaseEmojiByIdCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.i
    public void downloadBaseEmojiByIdWithUrl(@NotNull final DownloadBaseEmojiByUrlReq req, @Nullable IDownloadBaseEmojiByIdWithUrlCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            z4("downloadBaseEmojiByIdWithUrl", callback, new Function1<IDownloadBaseEmojiByIdWithUrlCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$downloadBaseEmojiByIdWithUrl$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DownloadBaseEmojiByUrlReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseEmojiService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IDownloadBaseEmojiByIdWithUrlCallback iDownloadBaseEmojiByIdWithUrlCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iDownloadBaseEmojiByIdWithUrlCallback);
                    }
                    IKernelBaseEmojiService service = BaseEmojiService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.downloadBaseEmojiByIdWithUrl(this.$req, iDownloadBaseEmojiByIdWithUrlCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.i
    public void fetchFullSysEmojis(@NotNull final PullSysEmojisReq req, @Nullable IFetchFullSysEmojisCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            A4("fetchFullSysEmojis", callback, new Function1<IFetchFullSysEmojisCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.BaseEmojiService$fetchFullSysEmojis$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PullSysEmojisReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseEmojiService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IFetchFullSysEmojisCallback iFetchFullSysEmojisCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iFetchFullSysEmojisCallback);
                    }
                    IKernelBaseEmojiService service = BaseEmojiService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchFullSysEmojis(this.$req, iFetchFullSysEmojisCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
