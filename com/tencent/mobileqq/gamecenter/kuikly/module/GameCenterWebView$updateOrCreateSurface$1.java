package com.tencent.mobileqq.gamecenter.kuikly.module;

import android.view.Surface;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "isAttach", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GameCenterWebView$updateOrCreateSurface$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ GameCenterWebView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCenterWebView$updateOrCreateSurface$1(GameCenterWebView gameCenterWebView) {
        super(1);
        this.this$0 = gameCenterWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GameCenterWebView this$0, EIPCResult eIPCResult) {
        boolean z16;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z16 = this$0.isDestroy;
        if (z16) {
            QLog.e("GameCenterWebView", 1, "[updateSurface] callback view isDestroy");
        }
        if (eIPCResult.isSuccess()) {
            GameCenterWebView.H = this$0.mCurrentSurface;
            String mWebPageId = this$0.getMWebPageId();
            str = this$0.mUrl;
            QLog.d("GameCenterWebView", 1, "[updateSurface] succeed webPageId:" + mWebPageId + ",mUrl:" + str);
            str2 = this$0.mUrl;
            this$0.E(str2);
            return;
        }
        QLog.e("GameCenterWebView", 1, "[updateSurface] error " + eIPCResult.f396321e);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Boolean bool) {
        boolean D;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            this.this$0.B();
            GameCenterWebView.H = this.this$0.mCurrentSurface;
            return;
        }
        D = this.this$0.D();
        if (D || GameCenterWebView.H == this.this$0.mCurrentSurface) {
            return;
        }
        RemoteWebRenderIPCServer a16 = RemoteWebRenderIPCServer.INSTANCE.a();
        String mWebPageId = this.this$0.getMWebPageId();
        Surface surface = this.this$0.mCurrentSurface;
        int measuredWidth = this.this$0.getMeasuredWidth();
        int measuredHeight = this.this$0.getMeasuredHeight();
        final GameCenterWebView gameCenterWebView = this.this$0;
        a16.j0(mWebPageId, surface, measuredWidth, measuredHeight, new EIPCResultCallback() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GameCenterWebView$updateOrCreateSurface$1.b(GameCenterWebView.this, eIPCResult);
            }
        });
    }
}
