package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section;

import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/a;", "Ljl1/b;", "data", "", "v", HippyTKDListViewAdapter.X, "w", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "t", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m;", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m;", "components", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends a<jl1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m components = new m(new b());

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.components.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(jl1.b data) {
        if (data.getCommonInfo().getExpandReplyListCount() == 0 && data.getCommonInfo().getTotalReplyCount() > 0) {
            w(data);
        } else {
            x();
        }
    }

    private final void w(jl1.b data) {
        this.components.h(data.getCommonInfo(), data.getCommonInfo().getTotalReplyCount());
    }

    private final void x() {
        this.components.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wdj};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.e(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull jl1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.components.d(data.getCommonInfo(), position, payload);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/d$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m$b;", "Lvl1/a;", "b", "", "d", "a", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements m.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        public void a() {
            d.this.u();
            vl1.a b16 = b();
            if (b16 != null) {
                Object mData = ((Section) d.this).mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                b16.n4((jl1.b) mData);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        @Nullable
        public vl1.a b() {
            return d.this.p();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        public void c() {
            jl1.b bVar = (jl1.b) ((Section) d.this).mData;
            if (bVar == null) {
                return;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("commentItemFoldSection", 1, "updateFoldView: " + bVar.getCommonInfo());
            }
            d.this.v(bVar);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        public void d() {
        }
    }
}
