package com.tencent.mobileqq.guild.feed.feedlist.section.recommend;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J0\u0010\u0014\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0014R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/a;", "Ltk1/a;", "Lrj1/d;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "data", "", "B", "Landroid/view/View;", "initContainerView", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "attached", "onAttachedChanged", "stFeed", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "getViewStubLayoutId", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "textView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends tk1.a<rj1.d> implements Observer<GProStFeed> {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView textView;

    public a() {
        super(FeedListSectionType.Bottom);
    }

    private final void B(h data) {
        bl1.b bVar = bl1.b.f28597a;
        String h16 = bl1.b.h(bVar, data.e(), "0", null, 4, null);
        String h17 = bl1.b.h(bVar, data.getCommentCount(), "0", null, 4, null);
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        textView.setText(QQGuildUIUtil.s(R.string.f145350r9, h16, h17));
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView2 = textView3;
        }
        textView2.setContentDescription(QQGuildUIUtil.s(R.string.f143670mp, h16, h17));
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed stFeed) {
        if (stFeed != null) {
            B(new GProStFeedDetailRspWrapper(stFeed, null, 2, 0 == true ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w_5};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        GProStFeed z16 = z();
        if (z16 != null && !TextUtils.isEmpty(z16.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(z16, this);
            } else {
                jj1.b.c().removeObserverGlobalState(z16, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        TextView textView = (TextView) p().findViewById(R.id.f165495wb0);
        if (textView == null) {
            return;
        }
        this.textView = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<rj1.d> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        if (bindData != null) {
            B(bindData.getData());
        }
    }

    @Nullable
    public final GProStFeed z() {
        T t16 = this.mData;
        if (t16 == 0) {
            return null;
        }
        Object a16 = ((tk1.c) t16).getData().a();
        if (!(a16 instanceof GProStFeed)) {
            return null;
        }
        return (GProStFeed) a16;
    }
}
