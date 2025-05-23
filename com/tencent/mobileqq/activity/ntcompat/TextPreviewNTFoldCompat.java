package com.tencent.mobileqq.activity.ntcompat;

import android.app.Activity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJC\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bH\u0002JC\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bH\u0002J\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/activity/ntcompat/TextPreviewNTFoldCompat;", "", "", "chatType", "", "peerId", "", "msgId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lkotlin/ParameterName;", "name", "msg", "", "callBack", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/textpreview/PreviewTextContainerView;", "containerView", "uinType", "", "e", "<init>", "()V", "text_preview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TextPreviewNTFoldCompat {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TextPreviewNTFoldCompat f183705a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f183705a = new TextPreviewNTFoldCompat();
        }
    }

    TextPreviewNTFoldCompat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(int chatType, String peerId, long msgId, final Function1<? super AIOMsgItem, Unit> callBack) {
        c(chatType, peerId, msgId, new Function1<MsgRecord, Unit>(callBack) { // from class: com.tencent.mobileqq.activity.ntcompat.TextPreviewNTFoldCompat$findFoldMsgByMsgId$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<AIOMsgItem, Unit> $callBack;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$callBack = callBack;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) callBack);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgRecord msgRecord) {
                invoke2(msgRecord);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MsgRecord it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.$callBack.invoke(((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).transformMsgRecordWithType(it));
                }
            }
        });
    }

    private final void c(int chatType, String peerId, final long msgId, final Function1<? super MsgRecord, Unit> callBack) {
        ArrayList<Long> arrayListOf;
        if (QLog.isColorLevel()) {
            QLog.d("TextPreviewNTCompat", 2, "getMsgsByMsgId chatType " + chatType + " peerId " + peerId + " msgId " + msgId);
        }
        w e16 = f.e();
        if (e16 != null) {
            Contact contact = new Contact(chatType, peerId, "");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(msgId));
            e16.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.activity.ntcompat.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    TextPreviewNTFoldCompat.d(msgId, callBack, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j3, Function1 callBack, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        if (i3 == 0 && arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord it5 = (MsgRecord) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("TextPreviewNTCompat", 2, "getMsgsByMsgId result msgId=" + it5.msgId);
                }
                if (j3 == it5.msgId) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    callBack.invoke(it5);
                    return;
                }
            }
        }
    }

    public final boolean e(@NotNull Activity activity, @NotNull PreviewTextContainerView containerView, int uinType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, activity, containerView, Integer.valueOf(uinType))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        if (!activity.getIntent().getBooleanExtra("key_bundle_nt_folder", false)) {
            return false;
        }
        long longExtra = activity.getIntent().getLongExtra("uniseq", 0L);
        String stringExtra = activity.getIntent().getStringExtra("key_bundle_nt_peeruid");
        if (stringExtra == null) {
            stringExtra = "";
        }
        b(uinType, stringExtra, longExtra, new TextPreviewNTFoldCompat$handleNTFoldMsgUI$1(activity, containerView));
        return true;
    }
}
