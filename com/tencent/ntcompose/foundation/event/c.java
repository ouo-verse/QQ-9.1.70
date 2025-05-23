package com.tencent.ntcompose.foundation.event;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ntcompose/foundation/event/c;", "", "", "b", "", "Lcom/tencent/ntcompose/foundation/event/b;", "a", "Ljava/util/List;", "onBackPressedCallbacks", "Lcom/tencent/kuikly/core/pager/b;", "pager", "<init>", "(Lcom/tencent/kuikly/core/pager/b;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<b> onBackPressedCallbacks;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ntcompose/foundation/event/c$a", "Lcom/tencent/kuikly/core/pager/c;", "", "pagerEvent", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "eventData", "", "onPagerEvent", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.kuikly.core.pager.c {
        a() {
        }

        @Override // com.tencent.kuikly.core.pager.c
        public void onPagerEvent(String pagerEvent, e eventData) {
            Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            if (Intrinsics.areEqual(pagerEvent, "onModalModeBackPressed")) {
                c.this.b();
            }
        }

        @Override // com.tencent.kuikly.core.pager.c
        public void onRootViewSizeChanged(double d16, double d17) {
            c.a.a(this, d16, d17);
        }
    }

    public c(com.tencent.kuikly.core.pager.b pager) {
        Intrinsics.checkNotNullParameter(pager, "pager");
        this.onBackPressedCallbacks = new ArrayList();
        pager.addPagerEventObserver(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        b bVar;
        List<b> list = this.onBackPressedCallbacks;
        ListIterator<b> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                bVar = null;
                break;
            } else {
                bVar = listIterator.previous();
                if (bVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String()) {
                    break;
                }
            }
        }
        b bVar2 = bVar;
        if (bVar2 != null) {
            bVar2.b();
        }
    }
}
