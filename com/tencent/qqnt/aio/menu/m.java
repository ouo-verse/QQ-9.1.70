package com.tencent.qqnt.aio.menu;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.qqnt.aio.menu.ui.QQCustomMenuNoIconLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J6\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/menu/m;", "", "Landroid/view/View;", "v", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Lcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;", ParseCommon.CONTAINER, "", "b", "Lcom/tencent/qqnt/aio/menu/al;", "selectLocation", "archer", "", "showSelectMenu", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface m {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(m mVar, View view, com.tencent.qqnt.aio.menu.ui.c cVar, QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    qQCustomMenuNoIconLayout = null;
                }
                mVar.b(view, cVar, qQCustomMenuNoIconLayout);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNormalMenu");
        }

        public static /* synthetic */ void b(m mVar, al alVar, View view, com.tencent.qqnt.aio.menu.ui.c cVar, QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    qQCustomMenuNoIconLayout = null;
                }
                QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout2 = qQCustomMenuNoIconLayout;
                if ((i3 & 16) != 0) {
                    z16 = false;
                }
                mVar.a(alVar, view, cVar, qQCustomMenuNoIconLayout2, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSelectMenu");
        }
    }

    void a(@NotNull al selectLocation, @NotNull View archer, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @Nullable QQCustomMenuNoIconLayout container, boolean showSelectMenu);

    void b(@NotNull View v3, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @Nullable QQCustomMenuNoIconLayout container);
}
