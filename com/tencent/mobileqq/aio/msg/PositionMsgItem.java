package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00052\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PositionMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Landroid/content/Context;", "context", "", "Y0", "", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "W0", "Lkotlin/Lazy;", "i2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "arkElement", "Lcom/tencent/mobileqq/aio/msg/template/b;", "X0", "Lcom/tencent/mobileqq/aio/msg/template/b;", "j2", "()Lcom/tencent/mobileqq/aio/msg/template/b;", "setInfo", "(Lcom/tencent/mobileqq/aio/msg/template/b;)V", "info", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PositionMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final Lazy arkElement;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.msg.template.b info;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PositionMsgItem$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.PositionMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PositionMsgItem(@NotNull final MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.PositionMsgItem$arkElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgRecord.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final MsgElement invoke() {
                    MsgElement msgElement;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (MsgElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ArrayList<MsgElement> arrayList = MsgRecord.this.elements;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
                    ListIterator<MsgElement> listIterator = arrayList.listIterator(arrayList.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            msgElement = null;
                            break;
                        }
                        msgElement = listIterator.previous();
                        if (msgElement.elementType == 10) {
                            break;
                        }
                    }
                    return msgElement;
                }
            });
            this.arkElement = lazy;
            this.info = new com.tencent.mobileqq.aio.msg.template.b(msgRecord, null, null, null, null, null, 62, null);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    private final MsgElement i2() {
        return (MsgElement) this.arkElement.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        String str;
        ArkElement arkElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        com.tencent.mobileqq.aio.msg.template.b bVar = this.info;
        MsgElement i26 = i2();
        if (i26 != null && (arkElement = i26.arkElement) != null) {
            str = arkElement.bytesData;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        bVar.g(str);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        String str;
        ArkElement arkElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 6, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        PositionMsgItem positionMsgItem = new PositionMsgItem(targetMsgRecord);
        com.tencent.mobileqq.aio.msg.template.b bVar = positionMsgItem.info;
        MsgElement i26 = positionMsgItem.i2();
        if (i26 != null && (arkElement = i26.arkElement) != null) {
            str = arkElement.bytesData;
        } else {
            str = null;
        }
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "it.arkElement?.arkElemen\u2026.bytesData ?: return@also");
            bVar.g(str);
        }
        return positionMsgItem;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 102;
        }
        return 103;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.msg.template.b j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msg.template.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.info;
    }
}
