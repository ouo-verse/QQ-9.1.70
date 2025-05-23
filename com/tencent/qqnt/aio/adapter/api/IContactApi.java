package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IContactApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "openAddFriend", "", "context", "Landroid/content/Context;", "nick", "", "uid", "openProfileCard", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "openUserProfileCard", "openUserProfileCardByUin", "uin", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IContactApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static void a(@NotNull IContactApi iContactApi, @NotNull Context context, @NotNull String uid, @NotNull String nick) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(nick, "nick");
        }

        public static void b(@NotNull IContactApi iContactApi, @NotNull Context context, @NotNull String uin, @NotNull String nick) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(nick, "nick");
        }
    }

    void openAddFriend(@NotNull Context context, @NotNull String nick, @NotNull String uid);

    void openProfileCard(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    void openUserProfileCard(@NotNull Context context, @NotNull String uid, @NotNull String nick);

    void openUserProfileCardByUin(@NotNull Context context, @NotNull String uin, @NotNull String nick);
}
