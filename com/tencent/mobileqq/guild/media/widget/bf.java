package com.tencent.mobileqq.guild.media.widget;

import androidx.recyclerview.widget.DefaultItemAnimator;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/bf;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "", "runPendingAnimations", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bf extends DefaultItemAnimator {
    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        try {
            super.runPendingAnimations();
        } catch (Exception e16) {
            QLog.e("GuildMediaSafeDefaultItemAnimator", 1, "[runPendingAnimations] exception: " + e16, e16);
        }
    }
}
