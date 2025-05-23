package com.tencent.aelight.camera.zplan.api.impl;

import com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B8\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012'\u0010\u0018\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012\u00a2\u0006\u0002\b\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u000b\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0017\u0010\u0010\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR8\u0010\u0018\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012\u00a2\u0006\u0002\b\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/j;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditPicPartManager;", "T", "Lcom/tribe/async/reactive/SimpleObserver;", "Lfs/b;", "result", "", "a", "Ljava/lang/Error;", "Lkotlin/Error;", "error", "onError", "onCancel", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditPicPartManager;", "getReceiver", "()Lcom/tencent/aelight/camera/aioeditor/takevideo/EditPicPartManager;", "receiver", "Lkotlin/Function2;", "Lcom/tencent/aelight/camera/zplan/api/impl/PublishHandlerClosure;", "Lkotlin/ExtensionFunctionType;", "b", "Lkotlin/jvm/functions/Function2;", "getAction", "()Lkotlin/jvm/functions/Function2;", "action", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/EditPicPartManager;Lkotlin/jvm/functions/Function2;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class j<T extends EditPicPartManager> extends SimpleObserver<fs.b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T receiver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function2<T, fs.b, Unit> action;

    /* JADX WARN: Multi-variable type inference failed */
    public j(T receiver, Function2<? super T, ? super fs.b, Unit> action) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(action, "action");
        this.receiver = receiver;
        this.action = action;
    }

    @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(fs.b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.action.invoke(this.receiver, result);
    }

    @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
    public void onCancel() {
        T t16 = this.receiver;
        t16.f67794m.dismissLoadingDialog();
        QQToast.makeText(t16.f67794m.getContext(), HardCodeUtil.qqStr(R.string.lwt), 0).show();
    }

    @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
    public void onError(Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.receiver.U0(error);
    }
}
