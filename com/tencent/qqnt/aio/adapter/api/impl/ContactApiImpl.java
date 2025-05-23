package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IContactApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ContactApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IContactApi;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "", "friendUin", "", "sourceId", "subSourceId", "friendName", "", "handleAddFriendActionClick", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "openProfileCard", "nick", "uid", "openAddFriend", "Lcom/tencent/qqnt/aio/contact/profile/j;", "profileChain$delegate", "Lkotlin/Lazy;", "getProfileChain", "()Lcom/tencent/qqnt/aio/contact/profile/j;", "profileChain", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ContactApiImpl implements IContactApi {
    public static final String TAG = "ContactApiImpl";

    /* renamed from: profileChain$delegate, reason: from kotlin metadata */
    private final Lazy profileChain;

    public ContactApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.aio.contact.profile.j>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ContactApiImpl$profileChain$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.qqnt.aio.contact.profile.j invoke() {
                return new com.tencent.qqnt.aio.contact.profile.j();
            }
        });
        this.profileChain = lazy;
    }

    private final com.tencent.qqnt.aio.contact.profile.j getProfileChain() {
        return (com.tencent.qqnt.aio.contact.profile.j) this.profileChain.getValue();
    }

    private final void handleAddFriendActionClick(QQAppInterface app, Context context, String friendUin, int sourceId, int subSourceId, String friendName) {
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 1, friendUin, null, sourceId, subSourceId, friendName, null, null, "", null);
        if (startAddFriend != null) {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, startAddFriend);
        }
        ReportController.n(app, "P_CliOper", "dc00898", friendUin, "0X800C006", "0X800C006", 0, 1, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openAddFriend$lambda$0(ContactApiImpl this$0, QQAppInterface app, Context context, String friendUin, int i3, int i16, String friendName, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(friendUin, "$friendUin");
        Intrinsics.checkNotNullParameter(friendName, "$friendName");
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        this$0.handleAddFriendActionClick(app, context, String.valueOf(hashMap.get(friendUin)), i3, i16, friendName);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openAddFriend(final Context context, final String nick, final String uid) {
        Set of5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(uid, "uid");
        QLog.i("ContactApiImpl", 1, "openAddFriend will executed!");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        final int i3 = 3071;
        final int i16 = 5193;
        com.tencent.qqnt.kernel.api.ag uixConvertService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "all")).getUixConvertService();
        if (uixConvertService != null) {
            of5 = SetsKt__SetsJVMKt.setOf(uid);
            uixConvertService.getUin(new HashSet<>(of5), new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.af
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                public final void onResult(HashMap hashMap) {
                    ContactApiImpl.openAddFriend$lambda$0(ContactApiImpl.this, qQAppInterface, context, uid, i3, i16, nick, hashMap);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openProfileCard(Context context, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        getProfileChain().a(context, msgItem);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openUserProfileCard(Context context, String str, String str2) {
        IContactApi.a.a(this, context, str, str2);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openUserProfileCardByUin(Context context, String str, String str2) {
        IContactApi.a.b(this, context, str, str2);
    }
}
