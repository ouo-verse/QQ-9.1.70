package com.tencent.mobileqq.aio.title;

import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pv3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/title/z;", "Lpv3/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "friendInfo", "", "c", "Lcom/tencent/aio/api/runtime/a;", "context", "", "b", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class z implements pv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/title/z$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.title.z$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65110);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c(com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendInfo) {
        if (!TextUtils.isEmpty(friendInfo.r())) {
            String r16 = friendInfo.r();
            Intrinsics.checkNotNull(r16);
            return r16;
        }
        if (!TextUtils.isEmpty(friendInfo.p())) {
            String p16 = friendInfo.p();
            Intrinsics.checkNotNull(p16);
            return p16;
        }
        return "";
    }

    @Override // pv3.a
    @NotNull
    public CharSequence a(@NotNull CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence);
        }
        return a.C11043a.a(this, charSequence);
    }

    @Override // pv3.a
    @NotNull
    public CharSequence b(@Nullable com.tencent.aio.api.runtime.a context) {
        Integer num;
        ArrayList<String> arrayListOf;
        AIOSession r16;
        AIOContact c16;
        AIOParam g16;
        AIOSession r17;
        AIOContact c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        String str = null;
        if (context != null && (g16 = context.g()) != null && (r17 = g16.r()) != null && (c17 = r17.c()) != null) {
            num = Integer.valueOf(c17.e());
        } else {
            num = null;
        }
        if (num == null || num.intValue() != 1) {
            return "";
        }
        AIOParam g17 = context.g();
        if (g17 != null && (r16 = g17.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        }
        if (str == null) {
            return "";
        }
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf, "C2CTitleNickProvider");
        if (friendSimpleInfoWithUid != null) {
            for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : friendSimpleInfoWithUid) {
                if (Intrinsics.areEqual(dVar.getUid(), str)) {
                    String c18 = c(dVar);
                    QLog.i("C2CTitleNickProvider", 1, "[getNick]: " + com.tencent.qqnt.aio.utils.b.c(c18));
                    return c18;
                }
            }
        }
        return "";
    }
}
