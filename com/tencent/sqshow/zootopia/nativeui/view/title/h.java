package com.tencent.sqshow.zootopia.nativeui.view.title;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u001f\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/h;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;", "", "id", "", "b", "d", "c", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "Landroid/widget/TextView;", "e", "()Landroid/widget/TextView;", "mTextView", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "getRedDot", "()Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "redDot", "I", "getRedDotId", "()I", "setRedDotId", "(I)V", "redDotId", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends BaseViewPagerTitleWithLineHint.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final TextView mTextView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZPlanRedDotView redDot;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int redDotId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.mTextView = (TextView) view.findViewById(R.id.qrj);
        this.redDot = (ZPlanRedDotView) view.findViewById(R.id.qgv);
    }

    public final void b(int id5) {
        this.redDot.g(1);
        this.redDotId = id5;
        this.redDot.h(id5);
    }

    public final void c() {
        d(this.redDotId);
    }

    public final void d(int id5) {
        g94.f.b(g94.f.f401577a, id5, this.redDot.getStoreType(), 0, false, 12, null);
    }

    /* renamed from: e, reason: from getter */
    public final TextView getMTextView() {
        return this.mTextView;
    }
}
