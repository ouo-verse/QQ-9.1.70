package com.tencent.mobileqq.guild.widget.adapterdelegates;

import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l<T extends List<?>> extends a<T> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        T t16 = this.C;
        if (t16 == 0) {
            return 0;
        }
        return ((List) t16).size();
    }
}
