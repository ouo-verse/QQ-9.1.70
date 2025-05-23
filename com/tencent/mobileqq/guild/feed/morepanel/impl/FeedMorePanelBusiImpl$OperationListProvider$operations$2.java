package com.tencent.mobileqq.guild.feed.morepanel.impl;

import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class FeedMorePanelBusiImpl$OperationListProvider$operations$2 extends FunctionReferenceImpl implements Function0<List<ShareActionSheetBuilder.ActionSheetItem>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedMorePanelBusiImpl$OperationListProvider$operations$2(Object obj) {
        super(0, obj, FeedMorePanelBusiImpl.OperationListProvider.class, "createOperationList", "createOperationList()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<ShareActionSheetBuilder.ActionSheetItem> invoke() {
        return ((FeedMorePanelBusiImpl.OperationListProvider) this.receiver).f();
    }
}
