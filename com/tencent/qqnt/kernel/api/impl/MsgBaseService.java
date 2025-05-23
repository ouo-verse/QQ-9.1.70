package com.tencent.qqnt.kernel.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.GetMsgsStatusEnum;
import com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgSeqCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgWithStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgsRspOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryFirstRoamMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgsRsp;
import com.tencent.qqnt.kernel.nativeinterface.RoamDatemsg;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B!\u0012\u0006\u0010D\u001a\u00020\u0004\u0012\u0006\u0010F\u001a\u00020E\u0012\b\u0010G\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\bH\u0010IJ,\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J,\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0017H\u0002J$\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0019H\u0002J$\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u001fH\u0002J$\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010!H\u0002JN\u0010*\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\n2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b*\u0010+JV\u0010,\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b,\u0010-JV\u0010.\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\b2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b.\u0010/JN\u00100\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u000f2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b0\u00101JN\u00102\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00112#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b2\u00103JN\u00104\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00132#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b4\u00105JN\u00106\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00152#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b6\u00107JN\u00108\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00172#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b8\u00109JN\u0010:\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00192#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b:\u0010;JN\u0010<\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u001b2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b<\u0010=JN\u0010>\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u001d2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b>\u0010?JN\u0010@\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u001f2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001f\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\b@\u0010AJN\u0010B\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010#2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010!2#\u0010)\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00020%H\u0004\u00a2\u0006\u0004\bB\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/MsgBaseService;", "L", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "", "method", "", "curSeq", "", "callbackInMain", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "result", "K5", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgsRspOperateCallback;", "N5", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAioFirstViewLatestMsgCallback;", "m5", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgWithStatusCallback;", "T5", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgSeqCallback;", "Q5", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecentUseEmojiListCallback;", ICustomDataEditor.STRING_PARAM_5, "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "t5", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgEmojiLikesListCallback;", "E5", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetDraftOperateCallback;", "p5", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgAbstractsCallback;", "H5", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryFirstRoamMsgCallback;", "B5", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesForRoleCallback;", "u5", "T", "cb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uCb", WidgetCacheConstellationData.WORK, "g5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "h5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "i5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IMsgsRspOperateCallback;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Z4", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetAioFirstViewLatestMsgCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "e5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgWithStatusCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "d5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgSeqCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "f5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecentUseEmojiListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "k5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "c5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgEmojiLikesListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", ICustomDataEditor.STRING_ARRAY_PARAM_5, "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetDraftOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "b5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgAbstractsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "j5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IQueryFirstRoamMsgCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "l5", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesForRoleCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "subTag", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "service", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/api/impl/py;Ljava/lang/Object;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class MsgBaseService<L, S> extends BaseService<L, S> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBaseService(@NotNull String subTag, @NotNull py content, @Nullable S s16) {
        super(subTag, content, s16);
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, subTag, content, s16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A5(MsgBaseService this$0, String method, int i3, String str, int i16, ISetMsgEmojiLikesForRoleCallback it, long j3, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, j3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQueryFirstRoamMsgCallback B5(final String method, final int curSeq, final IQueryFirstRoamMsgCallback result) {
        if (result != null) {
            return new IQueryFirstRoamMsgCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jg
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryFirstRoamMsgCallback
                public final void onResult(int i3, String str, RoamDatemsg roamDatemsg) {
                    MsgBaseService.C5(MsgBaseService.this, method, curSeq, result, i3, str, roamDatemsg);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C5(final MsgBaseService this$0, final String method, final int i3, final IQueryFirstRoamMsgCallback it, final int i16, final String str, final RoamDatemsg roamDatemsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.jj
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.D5(MsgBaseService.this, method, i16, str, i3, it, roamDatemsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D5(MsgBaseService this$0, String method, int i3, String str, int i16, IQueryFirstRoamMsgCallback it, RoamDatemsg roamDatemsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, roamDatemsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetMsgEmojiLikesListCallback E5(final String method, final int curSeq, final IGetMsgEmojiLikesListCallback result) {
        if (result != null) {
            return new IGetMsgEmojiLikesListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jk
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgEmojiLikesListCallback
                public final void onGetMsgEmojiLikesList(int i3, String str, ArrayList arrayList, String str2, boolean z16, boolean z17) {
                    MsgBaseService.F5(MsgBaseService.this, method, curSeq, result, i3, str, arrayList, str2, z16, z17);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F5(final MsgBaseService this$0, final String method, final int i3, final IGetMsgEmojiLikesListCallback it, final int i16, final String str, final ArrayList arrayList, final String str2, final boolean z16, final boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.jd
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.G5(MsgBaseService.this, method, i16, str, i3, it, arrayList, str2, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G5(MsgBaseService this$0, String method, int i3, String str, int i16, IGetMsgEmojiLikesListCallback it, ArrayList arrayList, String str2, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onGetMsgEmojiLikesList(i3, str, arrayList, str2, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetMsgAbstractsCallback H5(final String method, final int curSeq, final IGetMsgAbstractsCallback result) {
        if (result != null) {
            return new IGetMsgAbstractsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jf
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgAbstractsCallback
                public final void onGetMsgAbstracts(int i3, String str, ArrayList arrayList) {
                    MsgBaseService.I5(MsgBaseService.this, method, curSeq, result, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I5(final MsgBaseService this$0, final String method, final int i3, final IGetMsgAbstractsCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.je
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.J5(MsgBaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J5(MsgBaseService this$0, String method, int i3, String str, int i16, IGetMsgAbstractsCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onGetMsgAbstracts(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IMsgOperateCallback K5(final String method, final int curSeq, final boolean callbackInMain, final IMsgOperateCallback result) {
        if (result != null) {
            return new IMsgOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jr
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    MsgBaseService.L5(MsgBaseService.this, method, curSeq, callbackInMain, result, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L5(MsgBaseService this$0, String method, int i3, boolean z16, final IMsgOperateCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i16)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i3));
        if (!z16) {
            it.onResult(i16, str, arrayList);
        } else {
            this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.iv
                @Override // java.lang.Runnable
                public final void run() {
                    MsgBaseService.M5(IMsgOperateCallback.this, i16, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M5(IMsgOperateCallback it, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IMsgsRspOperateCallback N5(final String method, final int curSeq, final boolean callbackInMain, final IMsgsRspOperateCallback result) {
        if (result != null) {
            return new IMsgsRspOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jm
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgsRspOperateCallback
                public final void onResult(MsgsRsp msgsRsp) {
                    MsgBaseService.O5(MsgBaseService.this, method, curSeq, callbackInMain, result, msgsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O5(MsgBaseService this$0, String method, int i3, boolean z16, final IMsgsRspOperateCallback it, final MsgsRsp msgsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method)}, Integer.valueOf(i3));
        if (!z16) {
            it.onResult(msgsRsp);
        } else {
            this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ja
                @Override // java.lang.Runnable
                public final void run() {
                    MsgBaseService.P5(IMsgsRspOperateCallback.this, msgsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P5(IMsgsRspOperateCallback it, MsgsRsp msgsRsp) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.onResult(msgsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetMsgSeqCallback Q5(final String method, final int curSeq, final IGetMsgSeqCallback result) {
        if (result != null) {
            return new IGetMsgSeqCallback() { // from class: com.tencent.qqnt.kernel.api.impl.iu
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgSeqCallback
                public final void onGetMsgSeq(int i3, String str, long j3) {
                    MsgBaseService.R5(MsgBaseService.this, method, curSeq, result, i3, str, j3);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R5(final MsgBaseService this$0, final String method, final int i3, final IGetMsgSeqCallback it, final int i16, final String str, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.jb
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.S5(MsgBaseService.this, method, i16, str, i3, it, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S5(MsgBaseService this$0, String method, int i3, String str, int i16, IGetMsgSeqCallback it, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onGetMsgSeq(i3, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetMsgWithStatusCallback T5(final String method, final int curSeq, final IGetMsgWithStatusCallback result) {
        if (result != null) {
            return new IGetMsgWithStatusCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jh
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgWithStatusCallback
                public final void onResult(int i3, String str, GetMsgsStatusEnum getMsgsStatusEnum, ArrayList arrayList) {
                    MsgBaseService.U5(MsgBaseService.this, method, curSeq, result, i3, str, getMsgsStatusEnum, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U5(MsgBaseService this$0, String method, int i3, final IGetMsgWithStatusCallback it, final int i16, final String str, final GetMsgsStatusEnum getMsgsStatusEnum, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i16)), TuplesKt.to("errMsg", str), TuplesKt.to("status", getMsgsStatusEnum)}, Integer.valueOf(i3));
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ji
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.V5(IGetMsgWithStatusCallback.this, i16, str, getMsgsStatusEnum, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V5(IGetMsgWithStatusCallback it, int i3, String str, GetMsgsStatusEnum getMsgsStatusEnum, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.onResult(i3, str, getMsgsStatusEnum, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetAioFirstViewLatestMsgCallback m5(final String method, final int curSeq, final IGetAioFirstViewLatestMsgCallback result) {
        if (result != null) {
            return new IGetAioFirstViewLatestMsgCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jo
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback
                public final void onResult(int i3, String str, ArrayList arrayList, boolean z16) {
                    MsgBaseService.n5(MsgBaseService.this, method, curSeq, result, i3, str, arrayList, z16);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n5(MsgBaseService this$0, String method, int i3, final IGetAioFirstViewLatestMsgCallback it, final int i16, final String str, final ArrayList arrayList, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i16)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i3));
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.iz
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.o5(IGetAioFirstViewLatestMsgCallback.this, i16, str, arrayList, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o5(IGetAioFirstViewLatestMsgCallback it, int i3, String str, ArrayList arrayList, boolean z16) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.onResult(i3, str, arrayList, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetDraftOperateCallback p5(final String method, final int curSeq, final IGetDraftOperateCallback result) {
        if (result != null) {
            return new IGetDraftOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                    MsgBaseService.q5(MsgBaseService.this, method, curSeq, result, i3, str, arrayList, j3);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q5(final MsgBaseService this$0, final String method, final int i3, final IGetDraftOperateCallback it, final int i16, final String str, final ArrayList arrayList, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.iw
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.r5(MsgBaseService.this, method, i16, str, i3, it, arrayList, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r5(MsgBaseService this$0, String method, int i3, String str, int i16, IGetDraftOperateCallback it, ArrayList arrayList, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetRecentUseEmojiListCallback s5(final String method, final int curSeq, final IGetRecentUseEmojiListCallback result) {
        if (result != null) {
            return new IGetRecentUseEmojiListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jl
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback
                public final void onGetRecentUseEmojiListCallback(int i3, String str, ArrayList arrayList) {
                    MsgBaseService.v5(MsgBaseService.this, method, curSeq, result, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetMsgEmojiLikesCallback t5(final String method, final int curSeq, final ISetMsgEmojiLikesCallback result) {
        if (result != null) {
            return new ISetMsgEmojiLikesCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jn
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback
                public final void onSetMsgEmojiLikes(int i3, String str) {
                    MsgBaseService.x5(MsgBaseService.this, method, curSeq, result, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetMsgEmojiLikesForRoleCallback u5(final String method, final int curSeq, final ISetMsgEmojiLikesForRoleCallback result) {
        if (result != null) {
            return new ISetMsgEmojiLikesForRoleCallback() { // from class: com.tencent.qqnt.kernel.api.impl.jp
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback
                public final void onResult(int i3, String str, long j3, String str2) {
                    MsgBaseService.z5(MsgBaseService.this, method, curSeq, result, i3, str, j3, str2);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v5(final MsgBaseService this$0, final String method, final int i3, final IGetRecentUseEmojiListCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ix
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.w5(MsgBaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w5(MsgBaseService this$0, String method, int i3, String str, int i16, IGetRecentUseEmojiListCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onGetRecentUseEmojiListCallback(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x5(final MsgBaseService this$0, final String method, final int i3, final ISetMsgEmojiLikesCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.jc
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.y5(MsgBaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y5(MsgBaseService this$0, String method, int i3, String str, int i16, ISetMsgEmojiLikesCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onSetMsgEmojiLikes(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z5(final MsgBaseService this$0, final String method, final int i3, final ISetMsgEmojiLikesForRoleCallback it, final int i16, final String str, final long j3, final String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.iy
            @Override // java.lang.Runnable
            public final void run() {
                MsgBaseService.A5(MsgBaseService.this, method, i16, str, i3, it, j3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T Z4(@NotNull final String method, @Nullable final IGetAioFirstViewLatestMsgCallback cb5, @NotNull final Function1<? super IGetAioFirstViewLatestMsgCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().u(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetAioFirstViewLatestMsgCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetAioFirstViewLatestMsgCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IGetAioFirstViewLatestMsgCallback m56;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetAioFirstViewLatestMsgCallback, T> function1 = this.$work;
                m56 = this.this$0.m5(this.$method, i3, this.$cb);
                return function1.invoke(m56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T a5(@NotNull final String method, @Nullable final IGetDraftOperateCallback cb5, @NotNull final Function1<? super IGetDraftOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (T) iPatchRedirector.redirect((short) 13, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().v(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$10
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetDraftOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetDraftOperateCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IGetDraftOperateCallback p56;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetDraftOperateCallback, T> function1 = this.$work;
                p56 = this.this$0.p5(this.$method, i3, this.$cb);
                return function1.invoke(p56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T b5(@NotNull final String method, @Nullable final IGetMsgAbstractsCallback cb5, @NotNull final Function1<? super IGetMsgAbstractsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (T) iPatchRedirector.redirect((short) 14, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().P(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$11
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetMsgAbstractsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetMsgAbstractsCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IGetMsgAbstractsCallback H5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetMsgAbstractsCallback, T> function1 = this.$work;
                H5 = this.this$0.H5(this.$method, i3, this.$cb);
                return function1.invoke(H5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T c5(@NotNull final String method, @Nullable final IGetMsgEmojiLikesListCallback cb5, @NotNull final Function1<? super IGetMsgEmojiLikesListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (T) iPatchRedirector.redirect((short) 12, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().Q(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$9
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetMsgEmojiLikesListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetMsgEmojiLikesListCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IGetMsgEmojiLikesListCallback E5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetMsgEmojiLikesListCallback, T> function1 = this.$work;
                E5 = this.this$0.E5(this.$method, i3, this.$cb);
                return function1.invoke(E5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T d5(@NotNull final String method, @Nullable final IGetMsgSeqCallback cb5, @NotNull final Function1<? super IGetMsgSeqCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().R(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$5
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetMsgSeqCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetMsgSeqCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IGetMsgSeqCallback Q5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetMsgSeqCallback, T> function1 = this.$work;
                Q5 = this.this$0.Q5(this.$method, i3, this.$cb);
                return function1.invoke(Q5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T e5(@NotNull final String method, @Nullable final IGetMsgWithStatusCallback cb5, @NotNull final Function1<? super IGetMsgWithStatusCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().S(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetMsgWithStatusCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetMsgWithStatusCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IGetMsgWithStatusCallback T5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetMsgWithStatusCallback, T> function1 = this.$work;
                T5 = this.this$0.T5(this.$method, i3, this.$cb);
                return function1.invoke(T5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T f5(@NotNull final String method, @Nullable final IGetRecentUseEmojiListCallback cb5, @NotNull final Function1<? super IGetRecentUseEmojiListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (T) iPatchRedirector.redirect((short) 10, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().V(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$7
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetRecentUseEmojiListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetRecentUseEmojiListCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IGetRecentUseEmojiListCallback s56;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetRecentUseEmojiListCallback, T> function1 = this.$work;
                s56 = this.this$0.s5(this.$method, i3, this.$cb);
                return function1.invoke(s56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T g5(@NotNull String method, @Nullable IMsgOperateCallback cb5, @NotNull Function1<? super IMsgOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) h5(method, cb5, true, work);
    }

    @Nullable
    protected final <T> T h5(@NotNull final String method, @Nullable final IMsgOperateCallback cb5, final boolean callbackInMain, @NotNull final Function1<? super IMsgOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, this, method, cb5, Boolean.valueOf(callbackInMain), work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().F0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, callbackInMain, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $callbackInMain;
            final /* synthetic */ IMsgOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IMsgOperateCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IMsgOperateCallback K5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IMsgOperateCallback, T> function1 = this.$work;
                K5 = this.this$0.K5(this.$method, i3, this.$callbackInMain, this.$cb);
                return function1.invoke(K5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T i5(@NotNull final String method, @Nullable final IMsgsRspOperateCallback cb5, final boolean callbackInMain, @NotNull final Function1<? super IMsgsRspOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, this, method, cb5, Boolean.valueOf(callbackInMain), work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().G0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, callbackInMain, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $callbackInMain;
            final /* synthetic */ IMsgsRspOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IMsgsRspOperateCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IMsgsRspOperateCallback N5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IMsgsRspOperateCallback, T> function1 = this.$work;
                N5 = this.this$0.N5(this.$method, i3, this.$callbackInMain, this.$cb);
                return function1.invoke(N5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T j5(@NotNull final String method, @Nullable final IQueryFirstRoamMsgCallback cb5, @NotNull final Function1<? super IQueryFirstRoamMsgCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (T) iPatchRedirector.redirect((short) 16, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().M0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$13
            static IPatchRedirector $redirector_;
            final /* synthetic */ IQueryFirstRoamMsgCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IQueryFirstRoamMsgCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                IQueryFirstRoamMsgCallback B5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IQueryFirstRoamMsgCallback, T> function1 = this.$work;
                B5 = this.this$0.B5(this.$method, i3, this.$cb);
                return function1.invoke(B5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T k5(@NotNull final String method, @Nullable final ISetMsgEmojiLikesCallback cb5, @NotNull final Function1<? super ISetMsgEmojiLikesCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (T) iPatchRedirector.redirect((short) 11, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().Y0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$8
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetMsgEmojiLikesCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetMsgEmojiLikesCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                ISetMsgEmojiLikesCallback t56;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetMsgEmojiLikesCallback, T> function1 = this.$work;
                t56 = this.this$0.t5(this.$method, i3, this.$cb);
                return function1.invoke(t56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T l5(@NotNull final String method, @Nullable final ISetMsgEmojiLikesForRoleCallback cb5, @NotNull final Function1<? super ISetMsgEmojiLikesForRoleCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (T) iPatchRedirector.redirect((short) 20, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().e().Z0(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.MsgBaseService$check$16
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetMsgEmojiLikesForRoleCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetMsgEmojiLikesForRoleCallback, T> $work;
            final /* synthetic */ MsgBaseService<L, S> this$0;

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
                ISetMsgEmojiLikesForRoleCallback u56;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetMsgEmojiLikesForRoleCallback, T> function1 = this.$work;
                u56 = this.this$0.u5(this.$method, i3, this.$cb);
                return function1.invoke(u56);
            }
        });
    }
}
