package com.tencent.state;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/IFragmentManager;", "", "topFragment", "Landroidx/fragment/app/Fragment;", "getTopFragment", "()Landroidx/fragment/app/Fragment;", "hideFragment", "", "fragment", "popFragment", "pushFragment", "showFragment", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IFragmentManager {
    Fragment getTopFragment();

    void hideFragment(Fragment fragment);

    void popFragment(Fragment fragment);

    void pushFragment(Fragment fragment);

    void showFragment(Fragment fragment);
}
