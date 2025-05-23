package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section;

import android.util.Log;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/n;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/a;", "Ljl1/h;", "data", "", HippyTKDListViewAdapter.X, "", "u", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "v", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m;", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m;", "components", "e", "I", "state", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends a<jl1.h> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m components = new m(new b());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/n$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m$b;", "Lvl1/a;", "b", "", "d", "a", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements m.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        public void a() {
            if (((jl1.h) ((Section) n.this).mData).getCommonInfo().getLocalReplyListCount() == ((jl1.h) ((Section) n.this).mData).getReplyListPosition() + 1) {
                n.this.state = 3;
                n.this.w();
            }
            vl1.a b16 = b();
            if (b16 != null) {
                Object mData = ((Section) n.this).mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                b16.a3(false, (jl1.h) mData);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        @Nullable
        public vl1.a b() {
            return n.this.p();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        public void c() {
            jl1.h hVar = (jl1.h) ((Section) n.this).mData;
            if (hVar != null) {
                n.this.x(hVar);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.m.b
        public void d() {
            vl1.a b16;
            if (((jl1.h) ((Section) n.this).mData) != null && (b16 = b()) != null) {
                Object mData = ((Section) n.this).mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                b16.a3(true, (jl1.h) mData);
            }
        }
    }

    private final void A() {
        this.components.i();
    }

    private final boolean u(jl1.h data) {
        if (data.getCommonInfo().getLocalReplyListCount() > data.getReplyListPosition() + 1 || data.getCommonInfo().getNextPageReply()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        this.components.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(jl1.h data) {
        com.tencent.xaction.log.b.a("ReplyItemFoldSection", 4, "updateFoldView, position[" + this.mPosition + "], totalReplyCount[" + data.getCommonInfo().getTotalReplyCount() + "], replyListPosition[" + data.getReplyListPosition() + "], itemGroupPosition[" + data.getCommonInfo().getItemGroupPosition() + "], localReplyListCount[" + data.getCommonInfo().getLocalReplyListCount() + "], nextPageReply[" + data.getCommonInfo().getNextPageReply() + "], expandReplyListCount[" + data.getCommonInfo().getExpandReplyListCount() + "]");
        if (data.getCommonInfo().getTotalReplyCount() > 1 && (u(data) || data.getCommonInfo().getLocalReplyListCount() > 1)) {
            if (data.getCommonInfo().getExpandReplyListCount() == data.getReplyListPosition() + 1) {
                if (u(data)) {
                    Log.d("ReplyItemFoldSection", "hasMore, updateUIStateFold");
                    z(data);
                    return;
                } else {
                    y();
                    Log.d("ReplyItemFoldSection", "updateUIStateExpand");
                    return;
                }
            }
            Log.d("ReplyItemFoldSection", "updateUIStateHide");
            A();
            return;
        }
        A();
    }

    private final void y() {
        this.components.g();
    }

    private final void z(jl1.h data) {
        this.components.h(data.getCommonInfo(), (r0.getTotalReplyCount() - data.getReplyListPosition()) - 1);
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
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull jl1.h data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.components.d(data.getCommonInfo(), position, payload);
    }
}
