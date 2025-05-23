package com.tencent.mobileqq.guild.media.widget.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.media.widget.GuildMicSequenceDialogFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class TopOnMicViewHolder$mDeleteBtn$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ViewGroup $this_apply;
    final /* synthetic */ TopOnMicViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopOnMicViewHolder$mDeleteBtn$1$1(TopOnMicViewHolder topOnMicViewHolder, ViewGroup viewGroup) {
        super(1);
        this.this$0 = topOnMicViewHolder;
        this.$this_apply = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TopOnMicViewHolder this$0, DialogInterface dialogInterface, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMicSequenceDialogFragment fragment = this$0.getFragment();
        str = this$0.mTinyId;
        fragment.Bh(Long.parseLong(str));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context context = this.this$0.getFragment().getContext();
        final TopOnMicViewHolder topOnMicViewHolder = this.this$0;
        com.tencent.mobileqq.guild.util.qqui.c.d(context, 230, null, "\u8be5\u6210\u5458\u6b63\u5728\u53d1\u8a00\u4e2d\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u5c06\u5176\u79fb\u51fa\u9ea6\u5e8f?", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TopOnMicViewHolder$mDeleteBtn$1$1.c(TopOnMicViewHolder.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.adapter.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TopOnMicViewHolder$mDeleteBtn$1$1.d(dialogInterface, i3);
            }
        }).show();
        TopOnMicViewHolder topOnMicViewHolder2 = this.this$0;
        ViewGroup viewGroup = this.$this_apply;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "this");
        topOnMicViewHolder2.v(viewGroup, "em_sgrp_queuemanage_delete", new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
    }
}
