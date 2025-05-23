package com.tencent.mobileqq.guild.discoveryv2.content.model;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/f;", "", "Lcom/tencent/mvi/base/route/j;", "message", "", "D0", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "pullToRefreshArgs", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/g;", "loadMoreArgs", "B", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "i", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/j;", "observer", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/h;", "b", "", "l", "", "d", "", "account", "onAccountChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static void a(@NotNull f fVar, @NotNull com.tencent.mvi.base.route.j message) {
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    void B(@NotNull LoadMoreArgs loadMoreArgs);

    void C(@NotNull PullToRefreshArgs pullToRefreshArgs);

    void D0(@NotNull com.tencent.mvi.base.route.j message);

    void b(@NotNull LifecycleOwner owner, @NotNull Observer<LoadMoreState> observer);

    void d(@NotNull LifecycleOwner owner, @NotNull Observer<Long> observer);

    @NotNull
    List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> i();

    boolean l();

    void onAccountChanged(@NotNull String account);

    void q(@NotNull LifecycleOwner owner, @NotNull Observer<PullToRefreshState> observer);
}
