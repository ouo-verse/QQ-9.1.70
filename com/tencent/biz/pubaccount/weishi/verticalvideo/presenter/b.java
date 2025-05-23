package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 02\u00020\u0001:\u00011B\u0011\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0014J\"\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u001d\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0016J2\u0010 \u001a\u00020\u00022\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\"\u0010'\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&\u00a8\u00062"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/b;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/AbsWSVerticalPagePresenter;", "", SemanticAttributes.DbSystemValues.H2, "", "b2", "Ljz/c;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "listener", "Z1", "itemData", "V1", "f2", "isFirst", "d2", "e2", "c2", "", "W1", "", "", "X1", "Y1", "isRefresh", "from", "H", "y0", "", VideoTemplateParser.ITEM_LIST, HippyTKDListViewAdapter.X, "", "extObject", "d0", "P", "Z", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Z", "setHasReceiveRecommendResult", "(Z)V", "hasReceiveRecommendResult", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getHasReceiveDetailResult", "g2", "hasReceiveDetailResult", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;", "view", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class b extends AbsWSVerticalPagePresenter {

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasReceiveRecommendResult;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasReceiveDetailResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/presenter/b$b", "Lkz/a;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "itemData", "", "a", "", "errorCode", "", "errorMsg", "onFailure", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static final class C0837b implements kz.a<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> f82257b;

        C0837b(jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> cVar) {
            this.f82257b = cVar;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
            b.this.g2(true);
            x.i("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][getFeedDetail] onSuccess");
            if (b.this.e2() && b.this.getHasReceiveRecommendResult()) {
                x.j("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][getFeedDetail] recommendFeed has received, refuse detailFeed");
                return;
            }
            if (itemData == null) {
                return;
            }
            boolean c26 = b.this.c2();
            x.j("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][getFeedDetail] use detailFeed needFillData:" + c26);
            if (c26) {
                b.this.V1(itemData, this.f82257b);
            } else {
                b.this.f2(itemData);
            }
        }

        @Override // kz.a
        public void onFailure(int errorCode, String errorMsg) {
            jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> cVar;
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            x.f("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][getFeedDetail] onSuccess");
            if ((b.this.e2() && b.this.getHasReceiveRecommendResult()) || (cVar = this.f82257b) == null) {
                return;
            }
            cVar.i(errorCode, errorMsg, true, false);
        }
    }

    public b(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Z1(jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> listener) {
        boolean z16;
        boolean isBlank;
        String W1 = W1();
        int Y1 = Y1();
        Map<String, Integer> X1 = X1();
        x.j("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][getFeedDetail] needFetchDetailFeed, feedId:" + W1 + " , scene:" + Y1 + ", videoFeedTypeMap:" + X1 + ", " + this);
        if (W1 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(W1);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    new com.tencent.biz.pubaccount.weishi.verticalvideo.data.d().a(new com.tencent.biz.pubaccount.weishi.verticalvideo.data.e(W1, Y1, X1, new C0837b(listener)));
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final boolean b2() {
        if (!this.hasReceiveDetailResult && !this.hasReceiveRecommendResult) {
            return false;
        }
        x.j("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][isFilterLocalData] filterLocalData");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter = O0 != null ? O0.getAdapter() : null;
        if (adapter == null || adapter.z() == null) {
            return;
        }
        stSimpleMetaFeed e16 = itemData != null ? itemData.e() : null;
        if (e16 == null) {
            return;
        }
        S1(adapter.getItem(0), e16);
        Object obj = adapter.z().f82127d;
        Intrinsics.checkNotNullExpressionValue(obj, "adapter.playingVideoHolder.mItemView");
        if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
            ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).o(itemData);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void H(boolean isRefresh, boolean isFirst, String from) {
        boolean e26 = e2();
        boolean d26 = d2(isFirst);
        x.j("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][onLoadData] needFetchRecommend:" + e26 + ", needFetchDetail:" + d26);
        if (e26) {
            super.H(isRefresh, isFirst, from);
        }
        if (d26) {
            x.j("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][onLoadData]");
            Z1(this);
        }
    }

    protected String W1() {
        WSRedDotPushMsg z16 = bb.z();
        if (z16 != null) {
            String str = z16.mFeedIds;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            wsPushMsgData.mFeedIds\n        }");
            return str;
        }
        String q16 = com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.q();
        Intrinsics.checkNotNullExpressionValue(q16, "{\n            WSVertical\u2026getLastFeedId()\n        }");
        return q16;
    }

    protected Map<String, Integer> X1() {
        Map<String, Integer> mapOf;
        Map<String, Integer> emptyMap;
        if (bb.z() != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair(W1(), Integer.valueOf(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.r())));
        return mapOf;
    }

    protected int Y1() {
        return 1;
    }

    /* renamed from: a2, reason: from getter */
    protected final boolean getHasReceiveRecommendResult() {
        return this.hasReceiveRecommendResult;
    }

    protected boolean c2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        return ((O0 == null || (adapter = O0.getAdapter()) == null) ? 0 : adapter.getItemCount()) == 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, jz.c
    public void d0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> itemList, boolean isRefresh, boolean isFirst, Object extObject) {
        h2();
        super.d0(itemList, isRefresh, isFirst, extObject);
    }

    protected boolean d2(boolean isFirst) {
        return false;
    }

    protected boolean e2() {
        return true;
    }

    protected final void g2(boolean z16) {
        this.hasReceiveDetailResult = z16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, jz.d
    public void x(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        x.j("AbsWSVerticalWithFeedDetailPresenter", "[AbsWSVerticalWithFeedDetailPresenter][onSuccessFromLocal] " + this);
        if (b2()) {
            return;
        }
        super.x(itemList);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean isRefresh, boolean isFirst, String from) {
        return true;
    }

    private final void h2() {
        this.hasReceiveRecommendResult = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData, jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> listener) {
        if (listener != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(itemData);
            R0(arrayList);
        }
    }
}
