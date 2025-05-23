package com.tencent.biz.pubaccount.weishi.home.guide;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.weishi.home.WSTopBarHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000e\u001a\u00020\u00062\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\fH&J\b\u0010\u000f\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/guide/a;", "", "", "position", "Lcom/tencent/biz/pubaccount/weishi/home/WSTopBarHolder;", "barHolder", "", "b", "index", "totalCount", "a", "Lkotlin/Function0;", "Lcom/tencent/biz/pubaccount/weishi/home/guide/WSTopBarGuideClickListener;", "listener", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface a {
    void a(int index, int totalCount, WSTopBarHolder barHolder);

    void b(int position, WSTopBarHolder barHolder);

    void c(Function0<Unit> listener);

    void onDestroy();
}
