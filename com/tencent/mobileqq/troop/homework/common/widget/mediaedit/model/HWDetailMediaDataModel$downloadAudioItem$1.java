package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.io.File;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel$downloadAudioItem$1", f = "HWDetailMediaDataModel.kt", i = {}, l = {157, 166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWDetailMediaDataModel$downloadAudioItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ AudioItem $item;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ HWDetailMediaDataModel<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWDetailMediaDataModel$downloadAudioItem$1(AudioItem audioItem, Function0<Unit> function0, HWDetailMediaDataModel<T> hWDetailMediaDataModel, String str, Continuation<? super HWDetailMediaDataModel$downloadAudioItem$1> continuation) {
        super(2, continuation);
        this.$item = audioItem;
        this.$callback = function0;
        this.this$0 = hWDetailMediaDataModel;
        this.$url = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, audioItem, function0, hWDetailMediaDataModel, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWDetailMediaDataModel$downloadAudioItem$1(this.$item, this.$callback, this.this$0, this.$url, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        Set set;
        Set set2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            String localPath = this.$item.getLocalPath();
            if (localPath != null && localPath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 || !new File(localPath).exists()) {
                set = ((HWDetailMediaDataModel) this.this$0).downloadAudioTaskSet;
                set.add(this.$url);
                AudioItem audioItem = this.$item;
                String str = this.$url;
                audioItem.setLocalPath(TroopHomeworkHelper.i(str, TroopHomeworkHelper.k(str)));
                QLog.i("HW.MediaEdit.HWDetailMediaDataModel", 1, "downloadAudioFile url:" + this.$url + ", finish:" + this.$item.getLocalPath());
                set2 = ((HWDetailMediaDataModel) this.this$0).downloadAudioTaskSet;
                set2.remove(this.$url);
                Function0<Unit> function0 = this.$callback;
                if (function0 != null) {
                    HWDetailMediaDataModel<T> hWDetailMediaDataModel = this.this$0;
                    this.L$0 = function0;
                    this.label = 2;
                    if (hWDetailMediaDataModel.e(function0, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            Function0<Unit> function02 = this.$callback;
            if (function02 != null) {
                HWDetailMediaDataModel<T> hWDetailMediaDataModel2 = this.this$0;
                this.L$0 = function02;
                this.label = 1;
                if (hWDetailMediaDataModel2.e(function02, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWDetailMediaDataModel$downloadAudioItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
