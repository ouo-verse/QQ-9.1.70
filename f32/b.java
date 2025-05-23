package f32;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.component.d;
import com.tencent.mobileqq.icgame.framework.component.g;
import com.tencent.mobileqq.icgame.framework.component.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J0\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\"\b\b\u0000\u0010\u0007*\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Lf32/b;", "", "Lcom/tencent/mobileqq/icgame/framework/page/a;", "getPage", "Lg32/g;", "c", "Lcom/tencent/mobileqq/icgame/framework/component/h;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Class;", "clazz", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "a", "Lcom/tencent/mobileqq/icgame/framework/component/g;", "", "key", "b", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b {
    @Nullable
    <C extends h> d<C> a(@NotNull Class<C> clazz);

    @Nullable
    <C extends g> d<C> b(@NotNull Class<C> clazz, @NotNull String key);

    @NotNull
    g32.g c();

    @NotNull
    com.tencent.mobileqq.icgame.framework.page.a getPage();
}
