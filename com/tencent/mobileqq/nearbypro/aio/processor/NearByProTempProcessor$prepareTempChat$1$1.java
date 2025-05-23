package com.tencent.mobileqq.nearbypro.aio.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "sign", "", "peerUid", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class NearByProTempProcessor$prepareTempChat$1$1 extends Lambda implements Function2<byte[], String, Unit> {
    final /* synthetic */ AppInterface $appInterface;
    final /* synthetic */ Function1<String, Unit> $cb;
    final /* synthetic */ w $msgService;
    final /* synthetic */ String $peerNickname;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearByProTempProcessor$prepareTempChat$1$1(String str, AppInterface appInterface, w wVar, Function1<? super String, Unit> function1) {
        super(2);
        this.$peerNickname = str;
        this.$appInterface = appInterface;
        this.$msgService = wVar;
        this.$cb = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 cb5, String str, int i3, String str2) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        j.c().e("NearByProTempProcessor", "prepareTempChat: " + i3 + ", errMsg: " + str2);
        if (str == null) {
            str = "";
        }
        cb5.invoke(str);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr, String str) {
        invoke2(bArr, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull byte[] sign, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(sign, "sign");
        String str2 = this.$peerNickname;
        String str3 = str2 == null ? "" : str2;
        String currentUid = this.$appInterface.getCurrentUid();
        TempChatPrepareInfo tempChatPrepareInfo = new TempChatPrepareInfo(119, str, str3, "", sign, currentUid == null ? "" : currentUid, "", new TempChatGameSession());
        w wVar = this.$msgService;
        final Function1<String, Unit> function1 = this.$cb;
        wVar.prepareTempChat(tempChatPrepareInfo, new IOperateCallback() { // from class: com.tencent.mobileqq.nearbypro.aio.processor.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str4) {
                NearByProTempProcessor$prepareTempChat$1$1.b(Function1.this, str, i3, str4);
            }
        });
    }
}
