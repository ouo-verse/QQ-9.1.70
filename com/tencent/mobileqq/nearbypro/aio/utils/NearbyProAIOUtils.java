package com.tencent.mobileqq.nearbypro.aio.utils;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JC\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J3\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/utils/NearbyProAIOUtils;", "", "Landroid/content/Context;", "ctx", "", "tid", "nickname", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "callback", "a", "openId", "b", "c", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProAIOUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NearbyProAIOUtils f253151a = new NearbyProAIOUtils();

    NearbyProAIOUtils() {
    }

    public final void a(@NotNull final Context ctx, @NotNull String tid, @NotNull final String nickname, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(tid, "tid");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        AIONetworkHelper.f253140a.p(tid, new Function2<String, Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.aio.utils.NearbyProAIOUtils$goToAddFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String openId, boolean z16) {
                Intrinsics.checkNotNullParameter(openId, "openId");
                if (z16) {
                    Context context = ctx;
                    QQToast.makeText(context, context.getResources().getString(R.string.f170242ki), 0).show();
                } else {
                    IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                    Context context2 = ctx;
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(ctx, iAddFriendApi.startAddFriend(context2, 3, openId, "102063870", 3007, 30, nickname, context2.getResources().getString(R.string.f169942jp), null));
                }
            }
        });
    }

    public final void b(@NotNull Context ctx, @NotNull String openId, @NotNull String nickname) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(ctx, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(ctx, 3, openId, "102063870", 3007, 30, nickname, ctx.getResources().getString(R.string.f169942jp), null));
    }

    public final void c(@NotNull String tid, @Nullable final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(tid, "tid");
        AIONetworkHelper.f253140a.p(tid, new Function2<String, Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.aio.utils.NearbyProAIOUtils$isFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String openID, boolean z16) {
                Intrinsics.checkNotNullParameter(openID, "openID");
                Function1<Boolean, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(z16));
                }
            }
        });
    }
}
