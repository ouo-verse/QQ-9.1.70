package com.tencent.qqnt.contact.friends;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import hx3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002J \u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/contact/friends/b;", "", "", "uin", "", "d", "tag", "c", "isMsgDisturb", "", "e", "b", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f355778a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/contact/friends/b$a", "Lhx3/c;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements c<Boolean> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable e<Boolean> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f355778a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable String uin, @NotNull String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uin, (Object) tag);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (TextUtils.isEmpty(uin)) {
            return;
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).moveFriendToNewGroup(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin), -1002, tag, new a());
    }

    @Nullable
    public final String b(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin);
        }
        if (TextUtils.isEmpty(uin)) {
            return "";
        }
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
        aVar.d(uidFromUin);
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    public final boolean c(@Nullable String uin, @NotNull String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin, (Object) tag)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (TextUtils.isEmpty(uin)) {
            return false;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        return iFriendsInfoService.isFriend(uid, tag);
    }

    public final boolean d(@Nullable String uin) {
        long parseLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin)).booleanValue();
        }
        if (uin != null) {
            try {
                parseLong = Long.parseLong(uin);
            } catch (NumberFormatException unused) {
                return false;
            }
        } else {
            parseLong = 0;
        }
        if (parseLong <= 10000) {
            return false;
        }
        return true;
    }

    public final void e(@Nullable String uin, boolean isMsgDisturb, @NotNull String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uin, Boolean.valueOf(isMsgDisturb), tag);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (TextUtils.isEmpty(uin)) {
            return;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        Intrinsics.checkNotNull(uin);
        d dVar = new d(uid, uin);
        dVar.M();
        dVar.i0(Boolean.valueOf(isMsgDisturb));
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, tag, (c<d>) null);
    }
}
