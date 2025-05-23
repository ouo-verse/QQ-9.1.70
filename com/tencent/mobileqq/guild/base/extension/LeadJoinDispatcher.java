package com.tencent.mobileqq.guild.base.extension;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/base/extension/LeadJoinDispatcher;", "Lcom/tencent/mobileqq/guild/base/extension/AutoPlayDispatcher;", "", "i", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "reason", "", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class LeadJoinDispatcher extends AutoPlayDispatcher {
    @Override // com.tencent.mobileqq.guild.base.extension.AutoPlayDispatcher
    protected void f(boolean force, @NotNull String reason) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (getIsPaused()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.discovery.LeadJoinDispatcher", 2, "paused. not dispatch force=" + force + " reason=" + reason);
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.discovery.LeadJoinDispatcher", "dispatchVisibleViewHolders force=" + force + " reason=" + reason);
        }
        RecyclerView recyclerView2 = getRecyclerView();
        LinearLayoutManager linearLayoutManager = null;
        if (recyclerView2 != null) {
            layoutManager = recyclerView2.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager == null || (recyclerView = getRecyclerView()) == null) {
            return;
        }
        IntRange intRange = new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(recyclerView.findViewHolderForAdapterPosition(((IntIterator) it).nextInt()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            it5.next();
        }
        h().invoke(arrayList2, Boolean.valueOf(force));
    }

    @Override // com.tencent.mobileqq.guild.base.extension.AutoPlayDispatcher
    @NotNull
    protected String i() {
        return "Guild.discovery.LeadJoinDispatcher";
    }
}
