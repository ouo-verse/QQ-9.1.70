package com.tencent.qqnt.aio.bottombar.sectionbar.adapter;

import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/a;", "", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "b", "", "sectionType", "Lol3/b;", "intent", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {
    void a(int sectionType, @NotNull ol3.b intent);

    void b(@NotNull MsgIntent msgIntent);
}
