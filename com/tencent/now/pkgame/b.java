package com.tencent.now.pkgame;

import com.tencent.component.callback.ITimedCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or4.g;
import or4.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b*\u0001\u0013\u0018\u0000 \u00192\u00020\u0001:\u0002\t\rB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/now/pkgame/b;", "", "", "roomId", "anchorId", "Lcom/tencent/now/pkgame/b$b;", "callback", "", "f", "a", "Lcom/tencent/now/pkgame/b$b;", "pkInfoCallback", "Lcom/tencent/now/pkgame/PkInfoData;", "b", "Lcom/tencent/now/pkgame/PkInfoData;", "pkInfoData", "c", "J", "otherAnchorUid", "com/tencent/now/pkgame/b$c", "d", "Lcom/tencent/now/pkgame/b$c;", "getAnchorPKInfoCallback", "<init>", "()V", "e", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC9249b pkInfoCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long otherAnchorUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PkInfoData pkInfoData = new PkInfoData();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c getAnchorPKInfoCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/now/pkgame/b$b;", "", "", "isInPK", "", "pkType", "", "otherAnchorUid", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.pkgame.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC9249b {
        void a(boolean isInPK, int pkType, long otherAnchorUid);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/now/pkgame/b$c", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/q;", "data", "", "a", "", "code", "", "msg", "fail", WadlProxyConsts.PARAM_TIME_OUT, "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements ITimedCallback<q> {
        c() {
        }

        @Override // com.tencent.component.callback.ITimedCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable q data) {
            boolean z16;
            if (data != null) {
                b bVar = b.this;
                com.tencent.now.linkscreengame.model.b bVar2 = com.tencent.now.linkscreengame.model.b.f338501a;
                boolean j3 = bVar2.j(data);
                boolean d16 = bVar2.d(data);
                AegisLogger.INSTANCE.i("PK_Biz|PkInfoChecker", "needShowPKUI: " + j3 + ", inPKForUseful: " + d16 + ", pkType:" + data.f401383f);
                InterfaceC9249b interfaceC9249b = bVar.pkInfoCallback;
                if (interfaceC9249b != null) {
                    if (j3 && d16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    interfaceC9249b.a(z16, data.f401383f, bVar.otherAnchorUid);
                }
            }
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void fail(int code, @Nullable String msg2) {
            AegisLogger.INSTANCE.e("PK_Biz|PkInfoChecker", "getAnchorPKInfoCallback", "fail, code:" + code + ", msg:" + msg2);
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void timeOut() {
            AegisLogger.INSTANCE.e("PK_Biz|PkInfoChecker", "getAnchorPKInfoCallback", WadlProxyConsts.PARAM_TIME_OUT);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/now/pkgame/b$d", "Lcom/tencent/component/callback/ITimedCallback;", "Lor4/g;", "rsp", "", "a", "", "code", "", "msg", "fail", WadlProxyConsts.PARAM_TIME_OUT, "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements ITimedCallback<g> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f338635b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f338636c;

        d(long j3, long j16) {
            this.f338635b = j3;
            this.f338636c = j16;
        }

        @Override // com.tencent.component.callback.ITimedCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull g rsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            k[] kVarArr = rsp.f423489d;
            boolean z17 = false;
            if (kVarArr != null) {
                Intrinsics.checkNotNullExpressionValue(kVarArr, "rsp.linkMicInfo");
                if (kVarArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = true;
                }
            }
            int i3 = rsp.f423493h.f423500c.f423475a;
            b.this.otherAnchorUid = eo3.d.a(this.f338635b, rsp);
            AegisLogger.INSTANCE.i("PK_Biz|PkInfoChecker", "isLinkMic: " + z17 + ", bizId: " + i3 + ", otherAnchorUid: " + b.this.otherAnchorUid);
            if (z17) {
                b.this.pkInfoData.a(this.f338636c, b.this.getAnchorPKInfoCallback);
            }
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void fail(int code, @Nullable String msg2) {
            AegisLogger.INSTANCE.e("PK_Biz|PkInfoChecker", "getPkInfo", "fail, code:" + code + ", msg:" + msg2);
        }

        @Override // com.tencent.component.callback.ITimedCallback
        public void timeOut() {
            AegisLogger.INSTANCE.e("PK_Biz|PkInfoChecker", "getPkInfo", WadlProxyConsts.PARAM_TIME_OUT);
        }
    }

    public final void f(long roomId, long anchorId, @NotNull InterfaceC9249b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pkInfoCallback = callback;
        this.pkInfoData.b(roomId, anchorId, new d(anchorId, roomId));
    }
}
