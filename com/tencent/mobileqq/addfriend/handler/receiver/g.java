package com.tencent.mobileqq.addfriend.handler.receiver;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.data.LabelTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddyTagRsp;
import com.tencent.qqnt.kernel.nativeinterface.PersonTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/g;", "Lcom/tencent/mobileqq/addfriend/handler/receiver/a;", "Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyTagRsp;", "person", "", "Lcom/tencent/mobileqq/data/LabelTag;", "e", "", "b", "Lcom/tencent/qqnt/remote/d;", "toNTMsg", "Lcom/tencent/qqnt/remote/b;", "fromNTMsg", "", "d", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;)V", "c", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g extends a<NTAddFriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.handler.receiver.g$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull AppInterface appRuntime, @NotNull NTAddFriendHandler handler) {
        super(appRuntime, handler);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        }
    }

    private final List<LabelTag> e(BuddyTagRsp person) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (person != null) {
            ArrayList<PersonTag> arrayList2 = person.tags;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Iterator<PersonTag> it = person.tags.iterator();
                while (it.hasNext()) {
                    PersonTag next = it.next();
                    if (!TextUtils.isEmpty(next.icon) || !TextUtils.isEmpty(next.text)) {
                        LabelTag labelTag = new LabelTag();
                        labelTag.setIcon(next.icon);
                        labelTag.setText(next.text);
                        arrayList.add(labelTag);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.api.a.INSTANCE.g();
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    public void d(@NotNull com.tencent.qqnt.remote.d toNTMsg, @NotNull com.tencent.qqnt.remote.b fromNTMsg) {
        BuddyTagRsp buddyTagRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toNTMsg, (Object) fromNTMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(toNTMsg, "toNTMsg");
        Intrinsics.checkNotNullParameter(fromNTMsg, "fromNTMsg");
        Object a16 = fromNTMsg.a();
        if (a16 instanceof BuddyTagRsp) {
            buddyTagRsp = (BuddyTagRsp) a16;
        } else {
            buddyTagRsp = null;
        }
        if (fromNTMsg.b() == 0 && buddyTagRsp != null) {
            List<LabelTag> e16 = e(buddyTagRsp);
            NTAddFriendHandler c16 = c();
            if (c16 != null) {
                c16.notifyUI(1, true, e16);
            }
            NTAddFriendHandler c17 = c();
            if (c17 != null) {
                c17.notifyUI(2, true, buddyTagRsp.nickname);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTGetAddFriendTagReceiver", 2, "receive error: " + fromNTMsg.b() + "  " + fromNTMsg.c());
        }
    }
}
