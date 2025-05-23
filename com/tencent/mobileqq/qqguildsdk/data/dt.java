package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface dt {
    @Nullable
    cz a(String str);

    IGProUserChannelStateInfo b();

    @NonNull
    List<cz> getChannelStateList();

    String getGuildId();
}
