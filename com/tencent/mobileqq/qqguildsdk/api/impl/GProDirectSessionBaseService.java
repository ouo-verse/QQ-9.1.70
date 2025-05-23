package com.tencent.mobileqq.qqguildsdk.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qqguildsdk.internal.KLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B!\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002JN\u0010\u0014\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\b2#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00028\u00020\u000fH\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015JN\u0010\u0016\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00028\u00020\u000fH\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProDirectSessionBaseService;", "L", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService;", "", "method", "", "curSeq", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "result", "j1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchListCallback;", "g1", "T", "cb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uCb", WidgetCacheConstellationData.WORK, "f1", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "e1", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "subTag", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "service", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;Ljava/lang/Object;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class GProDirectSessionBaseService<L, S> extends BaseService<L, S> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProDirectSessionBaseService(@NotNull String subTag, @NotNull ServiceContent content, @Nullable S s16) {
        super(subTag, content, s16);
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFetchListCallback g1(final String method, final int curSeq, final IFetchListCallback result) {
        if (result != null) {
            return new IFetchListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cd
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IFetchListCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GProDirectSessionBaseService.h1(GProDirectSessionBaseService.this, method, curSeq, result, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(final GProDirectSessionBaseService this$0, final String method, final int i3, final IFetchListCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cf
            @Override // java.lang.Runnable
            public final void run() {
                GProDirectSessionBaseService.i1(GProDirectSessionBaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(GProDirectSessionBaseService this$0, String method, int i3, String str, int i16, IFetchListCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuildOperateCallback j1(final String method, final int curSeq, final IGuildOperateCallback result) {
        if (result != null) {
            return new IGuildOperateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cc
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    GProDirectSessionBaseService.k1(GProDirectSessionBaseService.this, method, curSeq, result, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(final GProDirectSessionBaseService this$0, final String method, final int i3, final IGuildOperateCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ce
            @Override // java.lang.Runnable
            public final void run() {
                GProDirectSessionBaseService.l1(GProDirectSessionBaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(GProDirectSessionBaseService this$0, String method, int i3, String str, int i16, IGuildOperateCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T e1(@NotNull final String method, @Nullable final IFetchListCallback cb5, @NotNull final Function1<? super IFetchListCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().d(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProDirectSessionBaseService$check$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IFetchListCallback g16;
                Function1<IFetchListCallback, T> function1 = work;
                g16 = this.g1(method, i3, cb5);
                return function1.invoke(g16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T f1(@NotNull final String method, @Nullable final IGuildOperateCallback cb5, @NotNull final Function1<? super IGuildOperateCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().N(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProDirectSessionBaseService$check$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGuildOperateCallback j16;
                Function1<IGuildOperateCallback, T> function1 = work;
                j16 = this.j1(method, i3, cb5);
                return function1.invoke(j16);
            }
        });
    }
}
