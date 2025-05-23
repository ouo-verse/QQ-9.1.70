package com.tencent.biz.pubaccount.weishi.commonpopdialog;

import UserGrowth.stPopWindowItem;
import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH&J\u0006\u0010\r\u001a\u00020\u0006R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/AbsWSPopDialogController;", "", "Landroid/content/Context;", "context", "", "needFetchData", "", "d", "", "", "LUserGrowth/stPopWindowItem;", "dialogMap", "f", "e", "a", "Landroid/content/Context;", "c", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "b", "Ljava/util/Map;", "getDialogMap", "()Ljava/util/Map;", "g", "(Ljava/util/Map;)V", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class AbsWSPopDialogController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, stPopWindowItem> dialogMap;

    /* renamed from: c, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public void d(Context context, boolean needFetchData) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        if (needFetchData) {
            b.f80631a.a(new Function1<Map<Integer, ? extends stPopWindowItem>, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.commonpopdialog.AbsWSPopDialogController$init$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends stPopWindowItem> map) {
                    invoke2((Map<Integer, stPopWindowItem>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<Integer, stPopWindowItem> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AbsWSPopDialogController.this.g(it);
                    AbsWSPopDialogController.this.f(it);
                }
            });
        }
    }

    public abstract void f(Map<Integer, stPopWindowItem> dialogMap);

    public void g(Map<Integer, stPopWindowItem> map) {
        this.dialogMap = map;
    }

    public final void e() {
        this.context = null;
    }
}
