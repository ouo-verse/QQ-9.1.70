package com.tencent.mobileqq.wink.editor.subtitle.source;

import android.os.Handler;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SubtitleQueryRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0013\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/DefaultSubtitleDataSource$queryResult$queryObserver$1", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/e;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/b;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "child", "", "b", "cancel", "", "type", "", "isSuccess", "", "data", "d", "e", "I", "c", "()I", "awareType", "a", "()Z", "canceled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DefaultSubtitleDataSource$queryResult$queryObserver$1 extends e implements b {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ c f322240d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int awareType;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function3<b, Integer, String, Unit> f322242f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultSubtitleDataSource$queryResult$queryObserver$1(c cVar, int i3, final Runnable runnable, Function3<? super b, ? super Integer, ? super String, Unit> function3) {
        this.f322242f = function3;
        this.f322240d = cVar;
        cVar.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$queryResult$queryObserver$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Handler q16;
                w53.b.c("DefaultSubtitleDataSource", "queryResult cancel");
                q16 = DefaultSubtitleDataSource.f322225a.q();
                q16.removeCallbacks(runnable);
                com.tencent.mobileqq.wink.b.a().removeObserver(this);
            }
        });
        this.awareType = i3;
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    /* renamed from: a */
    public boolean getCanceled() {
        return this.f322240d.getCanceled();
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.b
    public void b(@Nullable a child) {
        this.f322240d.b(child);
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.e
    /* renamed from: c, reason: from getter */
    public int getAwareType() {
        return this.awareType;
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    public void cancel() {
        this.f322240d.cancel();
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.e
    public void d(int type, boolean isSuccess, @Nullable Object data) {
        Pair pair;
        FromServiceMsg fromServiceMsg;
        Integer num;
        String str;
        String str2;
        int resultCode;
        if (getCanceled()) {
            return;
        }
        if (data instanceof Pair) {
            pair = (Pair) data;
        } else {
            pair = null;
        }
        if (pair != null) {
            fromServiceMsg = (FromServiceMsg) pair.getFirst();
        } else {
            fromServiceMsg = null;
        }
        if (fromServiceMsg == null) {
            w53.b.c("DefaultSubtitleDataSource", "query result null");
            this.f322242f.invoke(this, 1000011, null);
            return;
        }
        FromServiceMsg fromServiceMsg2 = (FromServiceMsg) pair.component1();
        SubtitleQueryRsp subtitleQueryRsp = (SubtitleQueryRsp) pair.component2();
        if (subtitleQueryRsp != null) {
            num = Integer.valueOf(subtitleQueryRsp.Code);
        } else {
            num = null;
        }
        if (subtitleQueryRsp != null) {
            str = subtitleQueryRsp.Msg;
        } else {
            str = null;
        }
        if (subtitleQueryRsp != null) {
            str2 = subtitleQueryRsp.SubtitleURL;
        } else {
            str2 = null;
        }
        w53.b.a("DefaultSubtitleDataSource", "query result " + num + " " + str + " " + str2 + " " + fromServiceMsg2);
        Intrinsics.checkNotNull(fromServiceMsg2);
        if (fromServiceMsg2.isSuccess() && subtitleQueryRsp != null && subtitleQueryRsp.Code == 0) {
            w53.b.a("DefaultSubtitleDataSource", "query success callback");
            this.f322242f.invoke(this, 0, subtitleQueryRsp.SubtitleURL);
            return;
        }
        Function3<b, Integer, String, Unit> function3 = this.f322242f;
        if (subtitleQueryRsp != null) {
            resultCode = subtitleQueryRsp.Code;
        } else {
            resultCode = fromServiceMsg2.getResultCode();
        }
        function3.invoke(this, Integer.valueOf(resultCode), null);
    }
}
