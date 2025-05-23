package com.tencent.qqnt.aio.helper;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u000b*\u0001\u0016\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\tH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R/\u0010\u001d\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/helper/BaseLifecycleHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "e", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "b", "()Lcom/tencent/aio/api/runtime/a;", "setAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "aioContext", "com/tencent/qqnt/aio/helper/BaseLifecycleHelper$a", "Lcom/tencent/qqnt/aio/helper/BaseLifecycleHelper$a;", "action", "f", "Lkotlin/Lazy;", "c", "()Ljava/util/ArrayList;", "registerMsgList", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseLifecycleHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a action = new a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy registerMsgList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/BaseLifecycleHelper$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            BaseLifecycleHelper.this.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public BaseLifecycleHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<String>>() { // from class: com.tencent.qqnt.aio.helper.BaseLifecycleHelper$registerMsgList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<String> invoke() {
                return BaseLifecycleHelper.this.a();
            }
        });
        this.registerMsgList = lazy;
    }

    private final ArrayList<String> c() {
        return (ArrayList) this.registerMsgList.getValue();
    }

    public abstract ArrayList<String> a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: from getter */
    public final com.tencent.aio.api.runtime.a getAioContext() {
        return this.aioContext;
    }

    public abstract void e(MsgIntent i3);

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(param, "param");
        this.aioContext = param.a();
        for (String str : c()) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                a aVar2 = this.action;
                com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
                Intrinsics.checkNotNull(aVar3);
                LifecycleOwner d16 = aVar3.d();
                Intrinsics.checkNotNullExpressionValue(d16, "aioContext!!.lifecycleOwner");
                e16.c(str, aVar2, d16);
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        for (String str : c()) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.b(str, this.action);
            }
        }
    }
}
