package com.tencent.qqnt.chats.view;

import android.graphics.Rect;
import android.widget.RelativeLayout;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class MiniOldStyleHeader$onStateChanged$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ RefreshState $newState;
    final /* synthetic */ MiniOldStyleHeader this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355577a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49314);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshState.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RefreshState.TwoLevelReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RefreshState.ReleaseToTwoLevel.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RefreshState.None.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f355577a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniOldStyleHeader$onStateChanged$1(RefreshState refreshState, MiniOldStyleHeader miniOldStyleHeader) {
        super(0);
        this.$newState = refreshState;
        this.this$0 = miniOldStyleHeader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) refreshState, (Object) miniOldStyleHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MiniOldStyleHeader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B().setClipBounds(new Rect(0, 0, this$0.B().getWidth(), this$0.B().getBottom()));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        switch (a.f355577a[this.$newState.ordinal()]) {
            case 1:
                this.this$0.B().setVisibility(0);
                this.this$0.getView().setVisibility(0);
                this.this$0.B().setClipChildren(true);
                return;
            case 2:
                this.this$0.fellowHeaderDown = false;
                this.this$0.fellowHeaderUp = true;
                this.this$0.B().setClipChildren(false);
                final MiniOldStyleHeader miniOldStyleHeader = this.this$0;
                miniOldStyleHeader.postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.view.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniOldStyleHeader$onStateChanged$1.b(MiniOldStyleHeader.this);
                    }
                }, 200L);
                return;
            case 3:
                this.this$0.fellowHeaderDown = false;
                this.this$0.fellowHeaderUp = true;
                this.this$0.B().setClipChildren(false);
                return;
            case 4:
            case 5:
                z16 = this.this$0.fellowHeaderDown;
                if (!z16) {
                    RelativeLayout B = this.this$0.B();
                    i3 = this.this$0.baseOffset;
                    B.setTranslationY(-i3);
                }
                this.this$0.fellowHeaderDown = true;
                return;
            case 6:
                this.this$0.B().setTranslationY(0.0f);
                this.this$0.finishInvokeByUser = false;
                this.this$0.containerShowOffset = 0;
                this.this$0.fellowHeaderUp = false;
                this.this$0.fellowHeaderDown = false;
                return;
            default:
                return;
        }
    }
}
