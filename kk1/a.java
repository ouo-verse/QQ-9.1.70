package kk1;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import hl1.g;
import java.util.List;
import kl1.f;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkk1/a;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lhl1/g;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends AdapterDelegatesManager<List<? extends g>> {
    public a() {
        addDelegate(6, new kl1.d());
        addDelegate(7, new f());
        addDelegate(4, new kl1.e());
    }
}
