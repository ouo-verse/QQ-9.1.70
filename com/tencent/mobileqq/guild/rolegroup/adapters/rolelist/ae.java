package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
@RequiresApi(21)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0000H\u0002\u00a8\u0006\u0007"}, d2 = {"Landroid/view/View;", "", "enable", "", "d", "itemView", "c", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ae {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view, boolean z16, View view2) {
        float f16;
        if (z16) {
            f16 = 1.0f;
        } else if (!z16) {
            f16 = 0.5f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        view2.setAlpha(f16);
        view.setEnabled(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view, boolean z16) {
        float f16;
        view.setSelected(z16);
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        if (z16) {
            f16 = 20.0f;
        } else {
            f16 = 0.0f;
        }
        view.setTranslationZ(f16);
    }
}
