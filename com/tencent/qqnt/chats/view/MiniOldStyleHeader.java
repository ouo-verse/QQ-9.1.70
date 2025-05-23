package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00019B\u000f\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J:\u0010\u001a\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010 R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u001eR\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u001eR\u0016\u00103\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/chats/view/MiniOldStyleHeader;", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "Lq3/d;", "headerView", "", "offset", "", "X", "", "W", "", "rate", "setCurRefreshRate", "Lq3/f;", "refreshLayout", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "d", "Lcom/qqnt/widget/smartrefreshlayout/header/TwoLevelHeader;", "g", "header", "isDragging", "percent", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "B9", "setBaseOffset", "setTitleBarOffset", "V", "I", "baseOffset", "Z", "finishInvokeByUser", "a0", "fellowHeaderUp", "b0", "fellowHeaderDown", "c0", "containerShowOffset", "d0", "titleBarPadding", "e0", UserInfo.SEX_FEMALE, "refreshRete", "f0", "direction", "g0", "lastTimeOffset", "h0", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "myCurStatus", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i0", "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniOldStyleHeader extends QQChatListTwoLevelHeader {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: V, reason: from kotlin metadata */
    private int baseOffset;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean finishInvokeByUser;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean fellowHeaderUp;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean fellowHeaderDown;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int containerShowOffset;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int titleBarPadding;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private float refreshRete;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int direction;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int lastTimeOffset;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RefreshState myCurStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/view/MiniOldStyleHeader$a;", "", "", "CONTAINER_SHOW", UserInfo.SEX_FEMALE, "", "DOWN", "I", "NONE", "REFRESH_HIDE", "", "TAG", "Ljava/lang/String;", "UP", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.view.MiniOldStyleHeader$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniOldStyleHeader(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.refreshRete = 1.4f;
            this.myCurStatus = RefreshState.None;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W(int offset) {
        int i3 = offset - this.lastTimeOffset;
        this.lastTimeOffset = offset;
        if (i3 > 0) {
            if (this.direction == -1) {
                return false;
            }
            this.direction = -1;
            return true;
        }
        if (i3 == 0) {
            if (this.direction == 0) {
                return false;
            }
            this.direction = 0;
            return true;
        }
        if (this.direction == 1) {
            return false;
        }
        this.direction = 1;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(q3.d headerView, int offset) {
        RefreshState refreshState = this.myCurStatus;
        if (refreshState != RefreshState.TwoLevel && refreshState != RefreshState.TwoLevelReleased) {
            int i3 = offset - this.titleBarPadding;
            if (i3 < 0) {
                i3 = 0;
            }
            int translationY = (offset - ((int) B().getTranslationY())) - i3;
            if (this.myCurStatus == RefreshState.TwoLevelFinish) {
                B().setClipBounds(new Rect(0, translationY, B().getWidth(), B().getBottom()));
                return;
            } else {
                B().setClipBounds(new Rect(0, translationY, B().getWidth(), offset - ((int) B().getTranslationY())));
                return;
            }
        }
        B().setClipBounds(new Rect(0, 0, B().getWidth(), offset - ((int) B().getTranslationY())));
    }

    @Override // com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader, r3.f
    public void B9(@Nullable final q3.d header, boolean isDragging, float percent, final int offset, final int headerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, header, Boolean.valueOf(isDragging), Float.valueOf(percent), Integer.valueOf(offset), Integer.valueOf(headerHeight), Integer.valueOf(maxDragHeight));
        } else {
            E(new Function0<Unit>(offset, header, headerHeight) { // from class: com.tencent.qqnt.chats.view.MiniOldStyleHeader$onHeaderMoving$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ q3.d $header;
                final /* synthetic */ int $headerHeight;
                final /* synthetic */ int $offset;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$offset = offset;
                    this.$header = header;
                    this.$headerHeight = headerHeight;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MiniOldStyleHeader.this, Integer.valueOf(offset), header, Integer.valueOf(headerHeight));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    float f16;
                    float f17;
                    RefreshState refreshState;
                    q3.a aVar;
                    boolean z16;
                    boolean z17;
                    int i3;
                    int i16;
                    int i17;
                    boolean z18;
                    int i18;
                    q3.a aVar2;
                    RefreshState refreshState2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MiniOldStyleHeader.this.W(this.$offset);
                    if (this.$header != null && MiniOldStyleHeader.this.B().getClipChildren()) {
                        MiniOldStyleHeader.this.X(this.$header, this.$offset);
                    }
                    float f18 = this.$offset;
                    f16 = MiniOldStyleHeader.this.refreshRete;
                    if (f18 / (f16 * this.$headerHeight) > 1.4f) {
                        refreshState2 = MiniOldStyleHeader.this.myCurStatus;
                        if (refreshState2 != RefreshState.TwoLevelFinish) {
                            MiniOldStyleHeader.this.B().setVisibility(0);
                            MiniOldStyleHeader.this.getView().setVisibility(0);
                            MiniOldStyleHeader.this.fellowHeaderDown = true;
                        }
                    }
                    float f19 = this.$offset;
                    f17 = MiniOldStyleHeader.this.refreshRete;
                    if (f19 / (f17 * this.$headerHeight) > 1.8f) {
                        aVar2 = ((TwoLevelHeader) MiniOldStyleHeader.this).L;
                        aVar2.getView().setVisibility(8);
                    } else {
                        refreshState = MiniOldStyleHeader.this.myCurStatus;
                        if (refreshState != RefreshState.TwoLevelFinish) {
                            aVar = ((TwoLevelHeader) MiniOldStyleHeader.this).L;
                            aVar.getView().setVisibility(0);
                        }
                    }
                    z16 = MiniOldStyleHeader.this.fellowHeaderUp;
                    if (z16) {
                        z18 = MiniOldStyleHeader.this.finishInvokeByUser;
                        if (!z18) {
                            float f26 = this.$offset;
                            i18 = MiniOldStyleHeader.this.titleBarPadding;
                            float height = (f26 + i18) - MiniOldStyleHeader.this.B().getHeight();
                            MiniOldStyleHeader.this.B().setTranslationY(height <= 0.0f ? height : 0.0f);
                            return;
                        }
                    }
                    z17 = MiniOldStyleHeader.this.fellowHeaderDown;
                    if (z17) {
                        i3 = MiniOldStyleHeader.this.containerShowOffset;
                        if (i3 == 0) {
                            MiniOldStyleHeader.this.containerShowOffset = this.$offset;
                        }
                        i16 = MiniOldStyleHeader.this.baseOffset;
                        int i19 = (-i16) + this.$offset;
                        i17 = MiniOldStyleHeader.this.containerShowOffset;
                        float f27 = i19 - i17;
                        MiniOldStyleHeader.this.B().setTranslationY(f27 <= 0.0f ? f27 : 0.0f);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader, com.qqnt.widget.smartrefreshlayout.header.ExtTwoLevelHeader, com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader, com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(@NotNull q3.f refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, refreshLayout, oldState, newState);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        super.d(refreshLayout, oldState, newState);
        if (this.myCurStatus == newState) {
            return;
        }
        E(new MiniOldStyleHeader$onStateChanged$1(newState, this));
        this.myCurStatus = newState;
    }

    @Override // com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader
    @NotNull
    public TwoLevelHeader g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TwoLevelHeader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        TwoLevelHeader g16 = super.g();
        Intrinsics.checkNotNullExpressionValue(g16, "super.finishTwoLevel()");
        return g16;
    }

    public final void setBaseOffset(int offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, offset);
        } else {
            this.baseOffset = offset;
        }
    }

    public final void setCurRefreshRate(float rate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(rate));
        } else {
            this.refreshRete = rate;
        }
    }

    public final void setTitleBarOffset(int offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, offset);
        } else {
            this.titleBarPadding = offset;
        }
    }
}
