package com.tencent.mobileqq.guild.message.msgsend;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import st1.l;
import st1.m;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0002j\b\u0012\u0004\u0012\u00020\r`\u0004H\u0016R\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/message/msgsend/SubQrCodePicInterceptProcessor;", "Lst1/m;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pathInfos", "", "e", "", "hasQrCode", tl.h.F, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "a", "Lst1/l;", "Lst1/l;", "getSubOnInterceptResult", "()Lst1/l;", "setSubOnInterceptResult", "(Lst1/l;)V", "subOnInterceptResult", "Lcom/tencent/aio/api/runtime/a;", "b", "Lcom/tencent/aio/api/runtime/a;", "context", "c", "Z", "isShowProcessDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "d", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "progressDialog", "<init>", "(Lst1/l;Lcom/tencent/aio/api/runtime/a;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SubQrCodePicInterceptProcessor implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l subOnInterceptResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowProcessDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy progressDialog;

    public SubQrCodePicInterceptProcessor(@NotNull l subOnInterceptResult, @NotNull com.tencent.aio.api.runtime.a context, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(subOnInterceptResult, "subOnInterceptResult");
        Intrinsics.checkNotNullParameter(context, "context");
        this.subOnInterceptResult = subOnInterceptResult;
        this.context = context;
        this.isShowProcessDialog = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQProgressDialog>() { // from class: com.tencent.mobileqq.guild.message.msgsend.SubQrCodePicInterceptProcessor$progressDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQProgressDialog invoke() {
                com.tencent.aio.api.runtime.a aVar;
                com.tencent.aio.api.runtime.a aVar2;
                aVar = SubQrCodePicInterceptProcessor.this.context;
                Context context2 = aVar.c().getContext();
                aVar2 = SubQrCodePicInterceptProcessor.this.context;
                return new QQProgressDialog(context2, aVar2.c().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        });
        this.progressDialog = lazy;
    }

    private final void e(final ArrayList<String> pathInfos) {
        if (this.isShowProcessDialog && this.context.c().getContext() != null) {
            g().setMessage(R.string.f139090ab);
            g().show();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.msgsend.b
            @Override // java.lang.Runnable
            public final void run() {
                SubQrCodePicInterceptProcessor.f(pathInfos, this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ArrayList pathInfos, SubQrCodePicInterceptProcessor this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(pathInfos, "$pathInfos");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = pathInfos.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).isQrCodeOrAppCode((String) it.next())) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        QLog.i("SubQrCodePicInterceptProcessor", 1, "hasQrCode " + z16);
        this$0.h(z16);
    }

    private final QQProgressDialog g() {
        return (QQProgressDialog) this.progressDialog.getValue();
    }

    private final void h(final boolean hasQrCode) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.msgsend.c
            @Override // java.lang.Runnable
            public final void run() {
                SubQrCodePicInterceptProcessor.i(SubQrCodePicInterceptProcessor.this, hasQrCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SubQrCodePicInterceptProcessor this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowProcessDialog && this$0.context.c().getContext() != null) {
            QLog.i("SubQrCodePicInterceptProcessor", 1, "progressDialog dismiss");
            this$0.g().dismiss();
        }
        if (z16) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
            this$0.subOnInterceptResult.a(this$0, true);
        } else {
            this$0.subOnInterceptResult.a(this$0, false);
        }
    }

    @Override // st1.m
    public void a(@NotNull Contact peer, @NotNull ArrayList<MsgElement> msgElements) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        ArrayList<String> arrayList = new ArrayList<>();
        for (MsgElement msgElement : msgElements) {
            if (msgElement.picElement != null) {
                String originImagePath = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getOriginImagePath(msgElement);
                if (!TextUtils.isEmpty(originImagePath)) {
                    arrayList.add(originImagePath);
                }
            }
        }
        if (arrayList.size() > 0 && ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptQrCode(com.tencent.guild.aio.util.ex.a.f(this.context), peer.peerUid)) {
            e(arrayList);
        } else {
            this.subOnInterceptResult.a(this, false);
        }
    }
}
