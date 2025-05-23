package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "path", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
final class AIOEmoApiImpl$sendRandomPicEmotionMsgFromOther$1 extends Lambda implements Function1<String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ HashMap<Integer, MsgAttributeInfo> $msgAttrs;
    final /* synthetic */ Contact $peer;
    final /* synthetic */ AIOEmoApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOEmoApiImpl$sendRandomPicEmotionMsgFromOther$1(Contact contact, AIOEmoApiImpl aIOEmoApiImpl, HashMap<Integer, MsgAttributeInfo> hashMap) {
        super(1);
        this.$peer = contact;
        this.this$0 = aIOEmoApiImpl;
        this.$msgAttrs = hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contact, aIOEmoApiImpl, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(com.tencent.qqnt.kernel.api.w msgService, Contact peer, String str, AIOEmoApiImpl this$0, HashMap hashMap) {
        long j3;
        Intrinsics.checkNotNullParameter(msgService, "$msgService");
        Intrinsics.checkNotNullParameter(peer, "$peer");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Long j06 = msgService.j0(peer.chatType);
        if (j06 != null) {
            j3 = j06.longValue();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        this$0.sendMsgWithAttr(msgService, j16, peer, AIOObjectTransform.m(AIOObjectTransform.f194080a, com.tencent.mobileqq.aio.msg.data.b.c(com.tencent.mobileqq.aio.msg.data.b.f190166a, str, null, true, 13, null, null, null, false, 240, null), 0, 2, null), hashMap, new IOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.g
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                AIOEmoApiImpl$sendRandomPicEmotionMsgFromOther$1.e(i3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, String str) {
        QLog.d(AIOEmoApiImpl.TAG, 1, "[sendPicEmotionMsg] err=" + i3 + ", msg=" + str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (str != null && com.tencent.qqnt.aio.utils.m.f352305a.f(str)) {
            final com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 == null) {
                return;
            }
            final Contact contact = this.$peer;
            final AIOEmoApiImpl aIOEmoApiImpl = this.this$0;
            final HashMap<Integer, MsgAttributeInfo> hashMap = this.$msgAttrs;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    AIOEmoApiImpl$sendRandomPicEmotionMsgFromOther$1.d(com.tencent.qqnt.kernel.api.w.this, contact, str, aIOEmoApiImpl, hashMap);
                }
            }, 16, null, true);
            return;
        }
        QLog.e(AIOEmoApiImpl.TAG, 1, "sendRandomPicEmotionMsgFromOther path not exists, " + str);
    }
}
