package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks;

import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.SequenceTaskQueue$execute$1;
import com.tencent.kuikly.core.pager.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RedirectJumpCheckTask implements ISequenceTask {
    public final g pageData;

    public RedirectJumpCheckTask(g gVar) {
        this.pageData = gVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    public final boolean canStart() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    public final void onStart(Function1<? super Boolean, Unit> function1) {
        if (NBPMainKtxKt.getJumpScheme(this.pageData).length() > 0) {
            ((SequenceTaskQueue$execute$1) function1).invoke(Boolean.TRUE);
        } else if (!this.pageData.n().a("nbp_forward") && !this.pageData.n().a("nbp_fid")) {
            ((SequenceTaskQueue$execute$1) function1).invoke(Boolean.FALSE);
        } else {
            ((SequenceTaskQueue$execute$1) function1).invoke(Boolean.TRUE);
        }
    }
}
