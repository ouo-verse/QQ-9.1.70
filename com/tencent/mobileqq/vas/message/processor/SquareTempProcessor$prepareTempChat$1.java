package com.tencent.mobileqq.vas.message.processor;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "sign", "", "peerUid", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SquareTempProcessor$prepareTempChat$1 extends Lambda implements Function2<byte[], String, Unit> {
    final /* synthetic */ Function1<String, Unit> $cb;
    final /* synthetic */ boolean $force;
    final /* synthetic */ w $msgService;
    final /* synthetic */ String $myUid;
    final /* synthetic */ String $peerNickname;
    final /* synthetic */ String $peerUin;
    final /* synthetic */ SquareTempProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SquareTempProcessor$prepareTempChat$1(String str, boolean z16, SquareTempProcessor squareTempProcessor, String str2, String str3, w wVar, Function1<? super String, Unit> function1) {
        super(2);
        this.$peerUin = str;
        this.$force = z16;
        this.this$0 = squareTempProcessor;
        this.$peerNickname = str2;
        this.$myUid = str3;
        this.$msgService = wVar;
        this.$cb = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr, String str) {
        invoke2(bArr, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final byte[] sign, final String str) {
        Intrinsics.checkNotNullParameter(sign, "sign");
        QLog.i("SquareTempProcessor", 1, "prepareTempChat sign: " + sign + ", uin: " + this.$peerUin + ", peerUid: " + str + ", force: " + this.$force);
        if (this.$force) {
            this.this$0.h(str, this.$peerNickname, sign, this.$myUid, this.$msgService, this.$cb);
            return;
        }
        final w wVar = this.$msgService;
        final Function1<String, Unit> function1 = this.$cb;
        final SquareTempProcessor squareTempProcessor = this.this$0;
        final String str2 = this.$peerNickname;
        final String str3 = this.$myUid;
        wVar.getTempChatInfo(115, str, new IGetTempChatInfoCallback() { // from class: com.tencent.mobileqq.vas.message.processor.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
            public final void onResult(int i3, String str4, TempChatInfo tempChatInfo) {
                SquareTempProcessor$prepareTempChat$1.b(Function1.this, str, squareTempProcessor, str2, sign, str3, wVar, i3, str4, tempChatInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 cb5, String str, SquareTempProcessor this$0, String str2, byte[] sign, String myUid, w msgService, int i3, String str3, TempChatInfo tempChatInfo) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sign, "$sign");
        Intrinsics.checkNotNullParameter(myUid, "$myUid");
        Intrinsics.checkNotNullParameter(msgService, "$msgService");
        QLog.i("SquareTempProcessor", 1, "prepareTempChat getTempChatInfo: " + i3 + ", errMsg: " + str3 + ", tmpChatInfo: " + tempChatInfo);
        if (i3 != 0) {
            this$0.h(str, str2, sign, myUid, msgService, cb5);
        } else {
            QLog.i("SquareTempProcessor", 1, "prepareTempChat local sign is valid!");
            cb5.invoke(str == null ? "" : str);
        }
    }
}
