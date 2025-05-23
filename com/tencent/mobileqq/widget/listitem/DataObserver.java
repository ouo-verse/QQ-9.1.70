package com.tencent.mobileqq.widget.listitem;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.a;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0006\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJC\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u000f0\fJ\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u000fR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/DataObserver;", "Lcom/tencent/mobileqq/widget/listitem/a;", BdhLogUtil.LogTag.Tag_Conn, "", "T", "data", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "()Lcom/tencent/mobileqq/widget/listitem/a;", "Landroidx/lifecycle/LiveData;", "liveData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "transformer", "f", "e", NodeProps.VISIBLE, "g", "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "b", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Lcom/tencent/mobileqq/widget/listitem/a;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class DataObserver<C extends a<?>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifeCycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIListItemAdapter adapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C config;

    public DataObserver(@NotNull LifecycleOwner lifeCycleOwner, @NotNull QUIListItemAdapter adapter, @NotNull C config) {
        Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(config, "config");
        this.lifeCycleOwner = lifeCycleOwner;
        this.adapter = adapter;
        this.config = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final C d() {
        return this.config;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final DataObserver<C> e(@NotNull LiveData<Boolean> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        return f(liveData, new DataObserver$visible$2(this));
    }

    @NotNull
    public final <T> DataObserver<C> f(@NotNull LiveData<T> liveData, @NotNull final Function1<? super T, Boolean> transformer) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        LifecycleOwner lifecycleOwner = this.lifeCycleOwner;
        final Function1<T, Unit> function1 = new Function1<T, Unit>(this) { // from class: com.tencent.mobileqq.widget.listitem.DataObserver$visible$1
            final /* synthetic */ DataObserver<C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((DataObserver$visible$1<T>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t16) {
                this.this$0.g(transformer.invoke(t16).booleanValue());
            }
        };
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.widget.listitem.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DataObserver.h(Function1.this, obj);
            }
        });
        return this;
    }

    @NotNull
    public final DataObserver<C> g(boolean visible) {
        this.adapter.m0(this.config, visible);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T c(T data) {
        return data;
    }
}
