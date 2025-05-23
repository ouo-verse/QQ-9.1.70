package fi2;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.framework.component.d;
import com.tencent.mobileqq.qqlive.framework.component.g;
import com.tencent.mobileqq.qqlive.framework.component.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J(\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J0\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lfi2/b;", "", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/g;", "c", "Lcom/tencent/mobileqq/qqlive/framework/component/h;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Class;", "clazz", "Lcom/tencent/mobileqq/qqlive/framework/component/d;", "a", "Lcom/tencent/mobileqq/qqlive/framework/component/g;", "", "key", "b", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {
    @Nullable
    <C extends h> d<C> a(@NotNull Class<C> clazz);

    @Nullable
    <C extends g> d<C> b(@NotNull Class<C> clazz, @NotNull String key);

    @NotNull
    com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g c();
}
