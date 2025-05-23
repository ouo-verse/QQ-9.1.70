package com.tencent.qqnt.ntrelation.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$Action;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$Buddy;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/f;", "", "T", "", "uid", "trace", "Lhx3/a;", "iDeleteGeneralDataCallback", "", "b", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f360260a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f360260a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(hx3.a aVar, int i3, String str) {
        if (QLog.isDebugVersion()) {
            QLog.i("NTFriendCommonUtil", 1, "deleteFriend kernel finish");
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        if (str == null) {
            str = "";
        }
        eVar.f(str);
        if (aVar != null) {
            aVar.a(eVar);
        }
    }

    public <T> void b(@NotNull String uid, @Nullable String trace, @Nullable final hx3.a<T> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ProfileUpdateMsg$Buddy profileUpdateMsg$Buddy = new ProfileUpdateMsg$Buddy();
        profileUpdateMsg$Buddy.uid.set(uid);
        ProfileUpdateMsg$Action profileUpdateMsg$Action = new ProfileUpdateMsg$Action();
        profileUpdateMsg$Action.del_buddy.set(profileUpdateMsg$Buddy);
        ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
        ArrayList arrayList = new ArrayList();
        arrayList.add(profileUpdateMsg$Action);
        profileUpdateMsg$UpdateMsg.action.set(arrayList);
        FriendListInfoCache.INSTANCE.a().j(uid);
        if (QLog.isDebugVersion()) {
            QLog.i("NTFriendCommonUtil", 1, "deleteFriend LRU cache");
        }
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            if (trace == null) {
                trace = "";
            }
            byte[] byteArray = profileUpdateMsg$UpdateMsg.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "updateMsg.toByteArray()");
            f16.updateProfileData(trace, byteArray, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.util.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    f.c(hx3.a.this, i3, str);
                }
            });
        }
    }
}
