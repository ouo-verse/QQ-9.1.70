package com.tencent.qqnt.ntrelation.friendsinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.constant.RelationObserverType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J \u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016J \u0010\u0012\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0002j\b\u0012\u0004\u0012\u00020\r`\u0004H\u0016J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\bH\u0016J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/QQFriendDataCallbackServiceImpl;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendDataCallbackService;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lkotlin/collections/ArrayList;", "data", "", "allFriendsInfoToCallback", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "friendsCategoryInfoToCallback", "friendsCategoryUidsInfoToCallback", "friendsLetterCategoryUidsInfoToCallback", "", "trace", "Lhx3/b;", "iQueryGeneralDataCallback", "registerAnyFriendChangeUids", "allFriendUidsChangeToCallback", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "registerCategoryInfoCallback", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "friendDetailInfoToCallback", "unregisterFriendCategoryInfoV2Callback", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQFriendDataCallbackServiceImpl implements IQQFriendDataCallbackService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "QQDataCallbackServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/QQFriendDataCallbackServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.QQFriendDataCallbackServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQFriendDataCallbackServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void allFriendUidsChangeToCallback(@NotNull ArrayList<String> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.p(data);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void allFriendsInfoToCallback(@NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.o(data);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void friendDetailInfoToCallback(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) data);
        } else {
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.r(data);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void friendsCategoryInfoToCallback(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void friendsCategoryUidsInfoToCallback(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
        } else {
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.q(data, false);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void friendsLetterCategoryUidsInfoToCallback(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
        } else {
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.s(data, false);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void registerAnyFriendChangeUids(@Nullable String trace, @NotNull hx3.b<String> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.d(trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void registerCategoryInfoCallback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, reqType, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.l(reqType, RelationObserverType.CONTINUOUS, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService
    public void unregisterFriendCategoryInfoV2Callback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, reqType, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.v(reqType, trace, iQueryGeneralDataCallback);
    }
}
