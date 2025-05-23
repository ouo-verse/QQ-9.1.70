package com.tencent.biz.pubaccount.setting;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b;
import com.tencent.mobileqq.widget.listitem.x.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00028\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/setting/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "I", "V", "()I", "id", "left", "right", "<init>", "(ILcom/tencent/mobileqq/widget/listitem/x$b;Lcom/tencent/mobileqq/widget/listitem/x$c;)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b<L extends x.b, R extends x.c> extends x<L, R> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i3, @NotNull L left, @NotNull R right) {
        super(left, right);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.id = i3;
    }

    /* renamed from: V, reason: from getter */
    public final int getId() {
        return this.id;
    }
}
