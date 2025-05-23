package com.tencent.mobileqq.minigame.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/minigame/utils/MiniGameTabTestConstants;", "", "()V", "EXP_MINIGAME_BOTTOM_TAB_FARM_BUBBLE", "", "EXP_MINIGAME_DRAWER_ENTRANCE_COPYWRITING_REVISON", "REGISTER_ABTEST_LIST", "", "getREGISTER_ABTEST_LIST", "()Ljava/util/List;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameTabTestConstants {
    public static final String EXP_MINIGAME_BOTTOM_TAB_FARM_BUBBLE = "exp_minigame_bottom_tab_farm_bubble";
    public static final String EXP_MINIGAME_DRAWER_ENTRANCE_COPYWRITING_REVISON = "exp_minigame_drawer_entrance_copywriting_revison";
    public static final MiniGameTabTestConstants INSTANCE = new MiniGameTabTestConstants();
    private static final List<String> REGISTER_ABTEST_LIST;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{EXP_MINIGAME_DRAWER_ENTRANCE_COPYWRITING_REVISON, EXP_MINIGAME_BOTTOM_TAB_FARM_BUBBLE});
        REGISTER_ABTEST_LIST = listOf;
    }

    MiniGameTabTestConstants() {
    }

    public final List<String> getREGISTER_ABTEST_LIST() {
        return REGISTER_ABTEST_LIST;
    }
}
