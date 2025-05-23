package com.tencent.qqnt.kernel.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildGroupBubbleCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuildMatchedOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MatchKey;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B!\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010+\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b,\u0010-J,\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0014H\u0002JN\u0010\u001c\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\n2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJV\u0010\u001e\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJN\u0010 \u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\r2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b \u0010!JN\u0010\"\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b\"\u0010#JN\u0010$\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00122#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b$\u0010%JN\u0010&\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00142#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b&\u0010'\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/GuildMsgBaseService;", "L", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "", "method", "", "curSeq", "", "callbackInMain", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "result", "W4", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuildMatchedOperateCallback;", "T4", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildGroupBubbleCallback;", "cb", "Q4", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestGetMsgAbstractsCallback;", "K4", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestMsgOperateCallback;", "N4", "T", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uCb", WidgetCacheConstellationData.WORK, "I4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "J4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "H4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGuildMatchedOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "E4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildGroupBubbleCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "F4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGuestGetMsgAbstractsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", Constants.DEBUG_INFO, "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGuestMsgOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "subTag", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "service", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/api/impl/py;Ljava/lang/Object;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class GuildMsgBaseService<L, S> extends BaseService<L, S> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgBaseService(@NotNull String subTag, @NotNull py content, @Nullable S s16) {
        super(subTag, content, s16);
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, subTag, content, s16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuestGetMsgAbstractsCallback K4(final String method, final int curSeq, final IGuestGetMsgAbstractsCallback result) {
        if (result != null) {
            return new IGuestGetMsgAbstractsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.hz
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestGetMsgAbstractsCallback
                public final void onGetMsgAbstracts(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                    GuildMsgBaseService.L4(GuildMsgBaseService.this, method, curSeq, result, i3, str, arrayList, hashMap);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L4(final GuildMsgBaseService this$0, final String method, final int i3, final IGuestGetMsgAbstractsCallback it, final int i16, final String str, final ArrayList arrayList, final HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ib
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgBaseService.M4(GuildMsgBaseService.this, method, i16, str, i3, it, arrayList, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M4(GuildMsgBaseService this$0, String method, int i3, String str, int i16, IGuestGetMsgAbstractsCallback it, ArrayList arrayList, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onGetMsgAbstracts(i3, str, arrayList, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuestMsgOperateCallback N4(final String method, final int curSeq, final IGuestMsgOperateCallback result) {
        if (result != null) {
            return new IGuestMsgOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ia
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                    GuildMsgBaseService.O4(GuildMsgBaseService.this, method, curSeq, result, i3, str, arrayList, hashMap);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O4(final GuildMsgBaseService this$0, final String method, final int i3, final IGuestMsgOperateCallback it, final int i16, final String str, final ArrayList arrayList, final HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ic
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgBaseService.P4(GuildMsgBaseService.this, method, i16, str, i3, it, arrayList, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P4(GuildMsgBaseService this$0, String method, int i3, String str, int i16, IGuestMsgOperateCallback it, ArrayList arrayList, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGuildGroupBubbleCallback Q4(final String method, final int curSeq, final IGetGuildGroupBubbleCallback cb5) {
        if (cb5 != null) {
            return new IGetGuildGroupBubbleCallback() { // from class: com.tencent.qqnt.kernel.api.impl.hw
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildGroupBubbleCallback
                public final void onResult(int i3, String str, byte[] bArr, byte[] bArr2) {
                    GuildMsgBaseService.R4(GuildMsgBaseService.this, method, curSeq, cb5, i3, str, bArr, bArr2);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R4(final GuildMsgBaseService this$0, final String method, final int i3, final IGetGuildGroupBubbleCallback it, final int i16, final String str, final byte[] bArr, final byte[] bArr2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.id
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgBaseService.S4(GuildMsgBaseService.this, method, i16, str, i3, it, bArr, bArr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S4(GuildMsgBaseService this$0, String method, int i3, String str, int i16, IGetGuildGroupBubbleCallback it, byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, bArr, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuildMatchedOperateCallback T4(final String method, final int curSeq, final IGuildMatchedOperateCallback result) {
        if (result != null) {
            return new IGuildMatchedOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.hx
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGuildMatchedOperateCallback
                public final void onResult(MatchKey matchKey, boolean z16) {
                    GuildMsgBaseService.U4(GuildMsgBaseService.this, method, curSeq, result, matchKey, z16);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U4(final GuildMsgBaseService this$0, final String method, final int i3, final IGuildMatchedOperateCallback it, final MatchKey matchKey, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ie
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgBaseService.V4(GuildMsgBaseService.this, method, i3, it, matchKey, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V4(GuildMsgBaseService this$0, String method, int i3, IGuildMatchedOperateCallback it, MatchKey matchKey, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method)}, Integer.valueOf(i3));
        it.onResult(matchKey, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IMsgOperateCallback W4(final String method, final int curSeq, final boolean callbackInMain, final IMsgOperateCallback result) {
        if (result != null) {
            return new IMsgOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.hy
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GuildMsgBaseService.X4(GuildMsgBaseService.this, method, curSeq, callbackInMain, result, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X4(GuildMsgBaseService this$0, String method, int i3, boolean z16, final IMsgOperateCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i16)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i3));
        if (!z16) {
            it.onResult(i16, str, arrayList);
        } else {
            this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.if
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgBaseService.Y4(IMsgOperateCallback.this, i16, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y4(IMsgOperateCallback it, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T E4(@NotNull final String method, @Nullable final IGetGuildGroupBubbleCallback cb5, @NotNull final Function1<? super IGetGuildGroupBubbleCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().N(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgBaseService$check$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGuildGroupBubbleCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGuildGroupBubbleCallback, T> $work;
            final /* synthetic */ GuildMsgBaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGuildGroupBubbleCallback Q4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGuildGroupBubbleCallback, T> function1 = this.$work;
                Q4 = this.this$0.Q4(this.$method, i3, this.$cb);
                return function1.invoke(Q4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T F4(@NotNull final String method, @Nullable final IGuestGetMsgAbstractsCallback cb5, @NotNull final Function1<? super IGuestGetMsgAbstractsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().t0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgBaseService$check$5
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGuestGetMsgAbstractsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGuestGetMsgAbstractsCallback, T> $work;
            final /* synthetic */ GuildMsgBaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGuestGetMsgAbstractsCallback K4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGuestGetMsgAbstractsCallback, T> function1 = this.$work;
                K4 = this.this$0.K4(this.$method, i3, this.$cb);
                return function1.invoke(K4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T G4(@NotNull final String method, @Nullable final IGuestMsgOperateCallback cb5, @NotNull final Function1<? super IGuestMsgOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().u0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgBaseService$check$6
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGuestMsgOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGuestMsgOperateCallback, T> $work;
            final /* synthetic */ GuildMsgBaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGuestMsgOperateCallback N4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGuestMsgOperateCallback, T> function1 = this.$work;
                N4 = this.this$0.N4(this.$method, i3, this.$cb);
                return function1.invoke(N4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T H4(@NotNull final String method, @Nullable final IGuildMatchedOperateCallback cb5, @NotNull final Function1<? super IGuildMatchedOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().v0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgBaseService$check$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGuildMatchedOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGuildMatchedOperateCallback, T> $work;
            final /* synthetic */ GuildMsgBaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGuildMatchedOperateCallback T4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGuildMatchedOperateCallback, T> function1 = this.$work;
                T4 = this.this$0.T4(this.$method, i3, this.$cb);
                return function1.invoke(T4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T I4(@NotNull String method, @Nullable IMsgOperateCallback cb5, @NotNull Function1<? super IMsgOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) J4(method, cb5, true, work);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T J4(@NotNull final String method, @Nullable final IMsgOperateCallback cb5, final boolean callbackInMain, @NotNull final Function1<? super IMsgOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, this, method, cb5, Boolean.valueOf(callbackInMain), work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().F0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, callbackInMain, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgBaseService$check$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $callbackInMain;
            final /* synthetic */ IMsgOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IMsgOperateCallback, T> $work;
            final /* synthetic */ GuildMsgBaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$callbackInMain = callbackInMain;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, Boolean.valueOf(callbackInMain), cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IMsgOperateCallback W4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IMsgOperateCallback, T> function1 = this.$work;
                W4 = this.this$0.W4(this.$method, i3, this.$callbackInMain, this.$cb);
                return function1.invoke(W4);
            }
        });
    }
}
