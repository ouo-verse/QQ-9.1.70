package com.tencent.qqnt.chats.core.ui.third;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004H&J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/b;", "", "Landroid/content/Context;", "context", "", "", "extra", "Landroid/view/View;", "a", "view", "", "b", ViewStickEventHelper.IS_SHOW, "", "f", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "c", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "d", "e", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {
    @NotNull
    View a(@NotNull Context context, @Nullable Map<String, ? extends Object> extra);

    boolean b(@NotNull View view, @Nullable Map<String, ? extends Object> extra);

    void c(boolean canShow);

    @NotNull
    ThirdViewEnum d();

    void e(@NotNull View view);

    void f(@NotNull View view, boolean isShow);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static void b(@NotNull b bVar, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public static void a(@NotNull b bVar, boolean z16) {
        }
    }
}
