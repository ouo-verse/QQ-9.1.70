package com.tencent.biz.pubaccount.setting;

import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J+\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH&\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/setting/a;", "", "", "uin", "name", "", "b", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "a", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;[Lcom/tencent/mobileqq/widget/listitem/Group;)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public interface a {
    void a(@NotNull QUIListItemAdapter adapter, @NotNull Group... groups);

    void b(@NotNull String uin, @NotNull String name);
}
