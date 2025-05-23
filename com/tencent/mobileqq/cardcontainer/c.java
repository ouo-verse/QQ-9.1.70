package com.tencent.mobileqq.cardcontainer;

import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/c;", "", "", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "d", "", "e", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "b", "Lcom/tencent/mobileqq/cardcontainer/f;", "c", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "containerData", "a", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface c {
    @NotNull
    ContainerData a(@NotNull ContainerData containerData);

    boolean b(@NotNull com.tencent.mobileqq.cardcontainer.data.a data);

    @NotNull
    f c();

    @NotNull
    List<CardType> d();

    boolean e();
}
