package com.tencent.sqshow.zootopia.recommend.main.tab;

import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH&J$\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH&J \u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0012\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\fH&J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u001a\u001a\u00020\u0004H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/a;", "", "Llb4/a;", "switcher", "", "g", "", "withAnim", "Lkotlin/Function0;", "callback", "b", h.F, "", "selectedPos", "", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", "dataList", "f", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/g;", "l", "e", "c", "d", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", FunctionConfigManagerImpl.CONFIG_CONTENT_URL, "a", "destroy", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface a {
    int a(ZPlanTabContentUrl contentUrl);

    void b(boolean withAnim, Function0<Unit> callback);

    void c(int selectedPos);

    int d();

    void destroy();

    void e(g l3);

    void f(int selectedPos, List<f> dataList);

    void g(lb4.a switcher);

    void h(boolean withAnim, Function0<Unit> callback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.sqshow.zootopia.recommend.main.tab.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9836a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a aVar, boolean z16, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    function0 = null;
                }
                aVar.h(z16, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(a aVar, boolean z16, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    function0 = null;
                }
                aVar.b(z16, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
    }
}
