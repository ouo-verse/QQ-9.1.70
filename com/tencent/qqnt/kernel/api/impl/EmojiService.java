package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GetAIGCEmojiListReq;
import com.tencent.qqnt.kernel.nativeinterface.ICheckImageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAIGCEmojiListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelEmojiService;
import com.tencent.qqnt.kernel.nativeinterface.PicMaterial;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\u0019\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\u0011\u001a\u00020\n2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/EmojiService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelEmojiService;", "Lcom/tencent/qqnt/kernel/api/n;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAIGCEmojiListReq;", "req", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIGCEmojiListCallback;", "cb", "", "getAIGCEmojiList", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicMaterial;", "Lkotlin/collections/ArrayList;", "imageList", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckImageCallback;", "checkImage", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelEmojiService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class EmojiService extends BaseService<IKernelEmojiService, IKernelEmojiService> implements com.tencent.qqnt.kernel.api.n {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/EmojiService$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.EmojiService$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45733);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiService(@Nullable IKernelEmojiService iKernelEmojiService, @NotNull py content) {
        super("EmojiService", content, iKernelEmojiService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelEmojiService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.n
    public void checkImage(@NotNull final ArrayList<PicMaterial> imageList, @Nullable ICheckImageCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageList, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(imageList, "imageList");
            check("checkImage", cb5, new Function1<ICheckImageCallback, Unit>(imageList) { // from class: com.tencent.qqnt.kernel.api.impl.EmojiService$checkImage$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<PicMaterial> $imageList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$imageList = imageList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmojiService.this, (Object) imageList);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ICheckImageCallback iCheckImageCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iCheckImageCallback);
                    }
                    IKernelEmojiService service = EmojiService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.checkImage(this.$imageList, iCheckImageCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.n
    public void getAIGCEmojiList(@NotNull final GetAIGCEmojiListReq req, final boolean force, @Nullable IGetAIGCEmojiListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, req, Boolean.valueOf(force), cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getAIGCEmojiList", cb5, new Function1<IGetAIGCEmojiListCallback, Unit>(req, force) { // from class: com.tencent.qqnt.kernel.api.impl.EmojiService$getAIGCEmojiList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $force;
                final /* synthetic */ GetAIGCEmojiListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    this.$force = force;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmojiService.this, req, Boolean.valueOf(force));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetAIGCEmojiListCallback iGetAIGCEmojiListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetAIGCEmojiListCallback);
                    }
                    IKernelEmojiService service = EmojiService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getAIGCEmojiList(this.$req, this.$force, iGetAIGCEmojiListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
