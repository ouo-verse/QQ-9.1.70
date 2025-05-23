package com.tencent.mobileqq.guild.base.extension;

import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes12.dex */
public final class l implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f214740d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f214741e;

    public l(View view, Function0<Unit> function0) {
        this.f214740d = view;
        this.f214741e = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Function0<Unit> function0 = this.f214741e;
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
