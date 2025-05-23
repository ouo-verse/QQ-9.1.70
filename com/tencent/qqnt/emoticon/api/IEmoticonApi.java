package com.tencent.qqnt.emoticon.api;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J!\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/emoticon/api/IEmoticonApi;", "T", "Lcom/tencent/mobileqq/text/IEmoticonSpanRefreshCallback;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDevicePerfLevel", "", "ctx", "Landroid/content/Context;", "getEmoticonSpanClass", "Ljava/lang/Class;", "loadConfig", "Lcom/tencent/freesia/IConfigData;", VipFunCallConstants.KEY_GROUP, "", "(Ljava/lang/String;)Lcom/tencent/freesia/IConfigData;", "showAIEmoticonPanel", "", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "showCompositeEmoticonPanel", "showZPlanEmoticonPanel", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IEmoticonApi<T extends IEmoticonSpanRefreshCallback> extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static <T extends IEmoticonSpanRefreshCallback> int a(@NotNull IEmoticonApi<T> iEmoticonApi, @NotNull Context ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            return -1;
        }

        /* JADX WARN: Incorrect return type in method signature: <T_I1::Lcom/tencent/mobileqq/text/IEmoticonSpanRefreshCallback;T::Lcom/tencent/freesia/IConfigData;>(Lcom/tencent/qqnt/emoticon/api/IEmoticonApi<TT_I1;>;Ljava/lang/String;)TT; */
        @Nullable
        public static IConfigData b(@NotNull IEmoticonApi iEmoticonApi, @NotNull String group) {
            Intrinsics.checkNotNullParameter(group, "group");
            return null;
        }

        public static <T extends IEmoticonSpanRefreshCallback> void c(@NotNull IEmoticonApi<T> iEmoticonApi, @NotNull FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        }

        public static <T extends IEmoticonSpanRefreshCallback> void d(@NotNull IEmoticonApi<T> iEmoticonApi, @NotNull FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        }

        public static <T extends IEmoticonSpanRefreshCallback> void e(@NotNull IEmoticonApi<T> iEmoticonApi, @NotNull FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        }
    }

    int getDevicePerfLevel(@NotNull Context ctx);

    @NotNull
    Class<T> getEmoticonSpanClass();

    /* JADX WARN: Incorrect return type in method signature: <T::Lcom/tencent/freesia/IConfigData;>(Ljava/lang/String;)TT; */
    @Nullable
    IConfigData loadConfig(@NotNull String group);

    void showAIEmoticonPanel(@NotNull FragmentActivity fragmentActivity);

    void showCompositeEmoticonPanel(@NotNull FragmentActivity fragmentActivity);

    void showZPlanEmoticonPanel(@NotNull FragmentActivity fragmentActivity);
}
