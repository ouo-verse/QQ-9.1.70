package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkToMarkdownMsgTemplateInfo;
import com.tencent.qqnt.kernel.nativeinterface.ArkToMarkdownMsgTemplateInfoElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.template.template.TemplateMsgTemplateManager$load$1$1", f = "TemplateMsgTemplateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class TemplateMsgTemplateManager$load$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ArkToMarkdownMsgTemplateInfo $data;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateMsgTemplateManager$load$1$1(ArkToMarkdownMsgTemplateInfo arkToMarkdownMsgTemplateInfo, Continuation<? super TemplateMsgTemplateManager$load$1$1> continuation) {
        super(2, continuation);
        this.$data = arkToMarkdownMsgTemplateInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) arkToMarkdownMsgTemplateInfo, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        TemplateMsgTemplateManager$load$1$1 templateMsgTemplateManager$load$1$1 = new TemplateMsgTemplateManager$load$1$1(this.$data, continuation);
        templateMsgTemplateManager$load$1$1.L$0 = obj;
        return templateMsgTemplateManager$load$1$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        r10 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r10);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.mobileqq.aio.msglist.holder.component.template.common.j jVar;
        HashMap hashMap;
        Unit unit;
        HashMap hashMap2;
        List<ArkToMarkdownMsgTemplateInfoElement> filterNotNull;
        String replace$default;
        HashMap hashMap3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                jVar = TemplateMsgTemplateManager.loadingStatus;
                jVar.a();
                hashMap = TemplateMsgTemplateManager.templatesFromServer;
                hashMap.clear();
                ArrayList<ArkToMarkdownMsgTemplateInfoElement> arrayList = this.$data.templateElementList;
                if (arrayList != null && filterNotNull != null) {
                    for (ArkToMarkdownMsgTemplateInfoElement arkToMarkdownMsgTemplateInfoElement : filterNotNull) {
                        String str = arkToMarkdownMsgTemplateInfoElement.group;
                        if (str != null) {
                            Intrinsics.checkNotNullExpressionValue(str, "it.group ?: return@forEach");
                            String str2 = arkToMarkdownMsgTemplateInfoElement.data;
                            if (str2 != null) {
                                Intrinsics.checkNotNullExpressionValue(str2, "it.data ?: return@forEach");
                                String str3 = arkToMarkdownMsgTemplateInfoElement.group;
                                Intrinsics.checkNotNullExpressionValue(str3, "it.group");
                                replace$default = StringsKt__StringsJVMKt.replace$default(str3, "md_template.", "", false, 4, (Object) null);
                                hashMap3 = TemplateMsgTemplateManager.templatesFromServer;
                                String str4 = arkToMarkdownMsgTemplateInfoElement.data;
                                Intrinsics.checkNotNullExpressionValue(str4, "it.data");
                                hashMap3.put(replace$default, str4);
                            }
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    QLog.e("TemMsg.MsgTemplateManager", 1, "data.templateElementList got null");
                }
                com.tencent.mobileqq.aio.msglist.holder.component.template.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a;
                hashMap2 = TemplateMsgTemplateManager.templatesFromServer;
                com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(aVar, "TemMsg.MsgTemplateManager", "service templates result count:" + hashMap2.size(), null, 4, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TemplateMsgTemplateManager$load$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
