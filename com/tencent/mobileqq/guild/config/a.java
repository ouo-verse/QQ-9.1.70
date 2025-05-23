package com.tencent.mobileqq.guild.config;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0019\u0010\u0006\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/a;", "Lcom/tencent/freesia/IConfigData;", "Item", "", "", "content", "onParse", "([B)Lcom/tencent/freesia/IConfigData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onUpdate", "(Lcom/tencent/freesia/IConfigData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a<Item extends IConfigData> {
    @NotNull
    Item onParse(@Nullable byte[] content);

    void onUpdate(@Nullable Item item);
}
