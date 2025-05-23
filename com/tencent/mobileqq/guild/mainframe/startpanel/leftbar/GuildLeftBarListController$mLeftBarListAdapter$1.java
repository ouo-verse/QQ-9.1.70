package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildLeftBarListController$mLeftBarListAdapter$1 extends FunctionReferenceImpl implements Function1<Integer, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildLeftBarListController$mLeftBarListAdapter$1(Object obj) {
        super(1, obj, GuildLeftBarListController.class, NodeProps.ON_LONG_CLICK, "onLongClick(I)Z", 0);
    }

    @NotNull
    public final Boolean invoke(int i3) {
        boolean Y;
        Y = ((GuildLeftBarListController) this.receiver).Y(i3);
        return Boolean.valueOf(Y);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return invoke(num.intValue());
    }
}
