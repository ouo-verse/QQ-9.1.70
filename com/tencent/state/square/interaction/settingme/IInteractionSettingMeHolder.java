package com.tencent.state.square.interaction.settingme;

import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/interaction/settingme/IInteractionSettingMeHolder;", "", "bind", "", "adapter", "Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeAdapter;", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "position", "", "event", "Lcom/tencent/state/square/interaction/settingme/ItemUpdateEvent;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
interface IInteractionSettingMeHolder {
    void bind(InteractionSettingMeAdapter adapter, ArrayList<Object> list, int position);

    void bind(ItemUpdateEvent event);
}
