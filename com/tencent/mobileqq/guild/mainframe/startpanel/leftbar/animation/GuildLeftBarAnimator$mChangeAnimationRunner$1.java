package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildLeftBarAnimator$mChangeAnimationRunner$1 extends FunctionReferenceImpl implements Function2<RecyclerView.ViewHolder, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildLeftBarAnimator$mChangeAnimationRunner$1(Object obj) {
        super(2, obj, GuildLeftBarAnimator.class, "dispatchChangeStarting", "dispatchChangeStarting(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Boolean bool) {
        invoke(viewHolder, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RecyclerView.ViewHolder viewHolder, boolean z16) {
        ((GuildLeftBarAnimator) this.receiver).dispatchChangeStarting(viewHolder, z16);
    }
}
