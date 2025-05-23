package com.tencent.mobileqq.qqguildsdk.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qqguildsdk.internal.KLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigateResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchNavigateInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B!\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010+\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b,\u0010-J$\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0013H\u0002JN\u0010\u001c\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\b2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJN\u0010\u001e\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJN\u0010 \u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\r2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b \u0010!JN\u0010\"\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b\"\u0010#JN\u0010$\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b$\u0010%JN\u0010&\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00020\u0017H\u0004\u00a2\u0006\u0004\b&\u0010'\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGuildMsgBaseService;", "L", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService;", "", "method", "", "curSeq", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IUnreadCntCallback;", "result", "L1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "I1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildFetchChannelLatestSeqCallback;", "F1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchNavigateInfoCallback;", "z1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildGetMsgAbstractsCallback;", "C1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildInteractiveNotificationCallback;", "w1", "T", "cb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uCb", WidgetCacheConstellationData.WORK, "v1", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IUnreadCntCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "u1", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", ICustomDataEditor.STRING_PARAM_1, "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildFetchChannelLatestSeqCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "q1", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchNavigateInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "r1", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildGetMsgAbstractsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "t1", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildInteractiveNotificationCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "subTag", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "service", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;Ljava/lang/Object;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class GProGuildMsgBaseService<L, S> extends BaseService<L, S> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProGuildMsgBaseService(@NotNull String subTag, @NotNull ServiceContent content, @Nullable S s16) {
        super(subTag, content, s16);
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(final GProGuildMsgBaseService this$0, final String method, final int i3, final IFetchNavigateInfoCallback it, final int i16, final String str, final GProNavigateResult gProNavigateResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cr
            @Override // java.lang.Runnable
            public final void run() {
                GProGuildMsgBaseService.B1(GProGuildMsgBaseService.this, method, i16, str, i3, it, gProNavigateResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(GProGuildMsgBaseService this$0, String method, int i3, String str, int i16, IFetchNavigateInfoCallback it, GProNavigateResult gProNavigateResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onFetchNavigateInfo(i3, str, gProNavigateResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGuildGetMsgAbstractsCallback C1(final String method, final int curSeq, final IGProGuildGetMsgAbstractsCallback result) {
        if (result != null) {
            return new IGProGuildGetMsgAbstractsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cp
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback
                public final void onGetMsgAbstracts(int i3, String str, ArrayList arrayList) {
                    GProGuildMsgBaseService.D1(GProGuildMsgBaseService.this, method, curSeq, result, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(final GProGuildMsgBaseService this$0, final String method, final int i3, final IGProGuildGetMsgAbstractsCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cq
            @Override // java.lang.Runnable
            public final void run() {
                GProGuildMsgBaseService.E1(GProGuildMsgBaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(GProGuildMsgBaseService this$0, String method, int i3, String str, int i16, IGProGuildGetMsgAbstractsCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onGetMsgAbstracts(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuildFetchChannelLatestSeqCallback F1(final String method, final int curSeq, final IGuildFetchChannelLatestSeqCallback result) {
        if (result != null) {
            return new IGuildFetchChannelLatestSeqCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cn
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback
                public final void onFetchChannelLatestSeq(int i3, String str, long j3) {
                    GProGuildMsgBaseService.G1(GProGuildMsgBaseService.this, method, curSeq, result, i3, str, j3);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(final GProGuildMsgBaseService this$0, final String method, final int i3, final IGuildFetchChannelLatestSeqCallback it, final int i16, final String str, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cs
            @Override // java.lang.Runnable
            public final void run() {
                GProGuildMsgBaseService.H1(GProGuildMsgBaseService.this, method, i16, str, i3, it, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(GProGuildMsgBaseService this$0, String method, int i3, String str, int i16, IGuildFetchChannelLatestSeqCallback it, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onFetchChannelLatestSeq(i3, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuildOperateCallback I1(final String method, final int curSeq, final IGuildOperateCallback result) {
        if (result != null) {
            return new IGuildOperateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ch
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    GProGuildMsgBaseService.J1(GProGuildMsgBaseService.this, method, curSeq, result, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(final GProGuildMsgBaseService this$0, final String method, final int i3, final IGuildOperateCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ck
            @Override // java.lang.Runnable
            public final void run() {
                GProGuildMsgBaseService.K1(GProGuildMsgBaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(GProGuildMsgBaseService this$0, String method, int i3, String str, int i16, IGuildOperateCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IUnreadCntCallback L1(final String method, final int curSeq, final IUnreadCntCallback result) {
        if (result != null) {
            return new IUnreadCntCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.co
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GProGuildMsgBaseService.M1(GProGuildMsgBaseService.this, method, curSeq, result, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(final GProGuildMsgBaseService this$0, final String method, final int i3, final IUnreadCntCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ci
            @Override // java.lang.Runnable
            public final void run() {
                GProGuildMsgBaseService.N1(GProGuildMsgBaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(GProGuildMsgBaseService this$0, String method, int i3, String str, int i16, IUnreadCntCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuildInteractiveNotificationCallback w1(final String method, final int curSeq, final IGuildInteractiveNotificationCallback result) {
        if (result != null) {
            return new IGuildInteractiveNotificationCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cm
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback
                public final void onResult(int i3, String str, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
                    GProGuildMsgBaseService.x1(GProGuildMsgBaseService.this, method, curSeq, result, i3, str, guildInteractiveNotificationItem);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(final GProGuildMsgBaseService this$0, final String method, final int i3, final IGuildInteractiveNotificationCallback it, final int i16, final String str, final GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cj
            @Override // java.lang.Runnable
            public final void run() {
                GProGuildMsgBaseService.y1(GProGuildMsgBaseService.this, method, i16, str, i3, it, guildInteractiveNotificationItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(GProGuildMsgBaseService this$0, String method, int i3, String str, int i16, IGuildInteractiveNotificationCallback it, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, guildInteractiveNotificationItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFetchNavigateInfoCallback z1(final String method, final int curSeq, final IFetchNavigateInfoCallback result) {
        if (result != null) {
            return new IFetchNavigateInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cl
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IFetchNavigateInfoCallback
                public final void onFetchNavigateInfo(int i3, String str, GProNavigateResult gProNavigateResult) {
                    GProGuildMsgBaseService.A1(GProGuildMsgBaseService.this, method, curSeq, result, i3, str, gProNavigateResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T q1(@NotNull final String method, @Nullable final IFetchNavigateInfoCallback cb5, @NotNull final Function1<? super IFetchNavigateInfoCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().e(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgBaseService$check$4
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
                IFetchNavigateInfoCallback z16;
                Function1<IFetchNavigateInfoCallback, T> function1 = work;
                z16 = this.z1(method, i3, cb5);
                return function1.invoke(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T r1(@NotNull final String method, @Nullable final IGProGuildGetMsgAbstractsCallback cb5, @NotNull final Function1<? super IGProGuildGetMsgAbstractsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().A(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgBaseService$check$5
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
                IGProGuildGetMsgAbstractsCallback C1;
                Function1<IGProGuildGetMsgAbstractsCallback, T> function1 = work;
                C1 = this.C1(method, i3, cb5);
                return function1.invoke(C1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T s1(@NotNull final String method, @Nullable final IGuildFetchChannelLatestSeqCallback cb5, @NotNull final Function1<? super IGuildFetchChannelLatestSeqCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().L(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgBaseService$check$3
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
                IGuildFetchChannelLatestSeqCallback F1;
                Function1<IGuildFetchChannelLatestSeqCallback, T> function1 = work;
                F1 = this.F1(method, i3, cb5);
                return function1.invoke(F1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T t1(@NotNull final String method, @Nullable final IGuildInteractiveNotificationCallback cb5, @NotNull final Function1<? super IGuildInteractiveNotificationCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().M(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgBaseService$check$6
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
                IGuildInteractiveNotificationCallback w16;
                Function1<IGuildInteractiveNotificationCallback, T> function1 = work;
                w16 = this.w1(method, i3, cb5);
                return function1.invoke(w16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T u1(@NotNull final String method, @Nullable final IGuildOperateCallback cb5, @NotNull final Function1<? super IGuildOperateCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().N(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgBaseService$check$2
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
                IGuildOperateCallback I1;
                Function1<IGuildOperateCallback, T> function1 = work;
                I1 = this.I1(method, i3, cb5);
                return function1.invoke(I1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T v1(@NotNull final String method, @Nullable final IUnreadCntCallback cb5, @NotNull final Function1<? super IUnreadCntCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().O(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgBaseService$check$1
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
                IUnreadCntCallback L1;
                Function1<IUnreadCntCallback, T> function1 = work;
                L1 = this.L1(method, i3, cb5);
                return function1.invoke(L1);
            }
        });
    }
}
