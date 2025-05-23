package com.tencent.mobileqq.troop.selectmember.inject;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J8\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\f0\u0002j\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e0\f`\u0004H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/inject/b;", "", "Ljava/util/ArrayList;", "Lcom/tencent/biz/richframework/part/Part;", "Lkotlin/collections/ArrayList;", "d", "Lcom/tencent/mobileqq/troop/selectmember/inject/d;", "c", "Lcom/tencent/mobileqq/troop/selectmember/inject/e;", "f", "Lcom/tencent/mobileqq/troop/selectmember/inject/a;", "a", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "e", "Lcom/tencent/mobileqq/troop/selectmember/inject/c;", "b", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface b {
    @Nullable
    a a();

    @Nullable
    c b();

    @Nullable
    d c();

    @NotNull
    ArrayList<Part> d();

    @NotNull
    ArrayList<AbsTroopSelectMemberDelegate<? extends com.tencent.mobileqq.troop.selectmember.bean.a, ? extends RecyclerView.ViewHolder>> e();

    @Nullable
    e f();
}
