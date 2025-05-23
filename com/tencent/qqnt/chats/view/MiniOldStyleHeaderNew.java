package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J:\u0010\u001d\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010!R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010!R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010!R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010$\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/chats/view/MiniOldStyleHeaderNew;", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "Lq3/d;", "headerView", "", "offset", "", "percent", "", ExifInterface.LATITUDE_SOUTH, "", BdhLogUtil.LogTag.Tag_Req, "rate", "setCurRefreshRate", "Lq3/f;", "refreshLayout", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "d", "Lcom/qqnt/widget/smartrefreshlayout/header/TwoLevelHeader;", "g", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "header", "isDragging", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "B9", "setBaseOffset", "setTitleBarOffset", "V", "I", "baseOffset", "W", "Z", "finishInvokeByUser", "a0", "fellowHeaderUp", "b0", "fellowHeaderDown", "c0", "containerShowOffset", "d0", "titleBarPadding", "e0", UserInfo.SEX_FEMALE, "refreshRete", "f0", "direction", "g0", "lastTimeOffset", "h0", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "myCurStatus", "i0", "isFullShow", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "j0", "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniOldStyleHeaderNew extends QQChatListTwoLevelHeader {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
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

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isFullShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/view/MiniOldStyleHeaderNew$a;", "", "", "DOWN", "I", "NONE", "", "TAG", "Ljava/lang/String;", "UP", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.view.MiniOldStyleHeaderNew$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniOldStyleHeaderNew(@NotNull Context context) {
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
    public static final void Q(MiniOldStyleHeaderNew this$0) {
        Rect rect;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout B = this$0.B();
        if (B != null) {
            rect = B.getClipBounds();
        } else {
            rect = null;
        }
        if (rect == null) {
            return;
        }
        if (this$0.isFullShow) {
            i3 = this$0.B().getBottom();
        } else {
            i3 = rect.bottom;
        }
        this$0.B().setClipBounds(new Rect(rect.left, rect.top, this$0.B().getWidth(), i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R(int offset) {
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
    public final void S(q3.d headerView, int offset, float percent) {
        int coerceAtMost;
        boolean z16 = false;
        if (percent > 0.5f) {
            B().setClipBounds(new Rect(0, 0, B().getWidth(), B().getHeight()));
        } else {
            RelativeLayout B = B();
            int width = B().getWidth();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(offset + this.titleBarPadding, B().getHeight());
            B.setClipBounds(new Rect(0, 0, width, coerceAtMost));
        }
        if (B().getClipBounds().bottom == B().getHeight()) {
            z16 = true;
        }
        this.isFullShow = z16;
    }

    @Override // com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader, r3.f
    public void B9(@Nullable final q3.d header, boolean isDragging, float percent, final int offset, int headerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, header, Boolean.valueOf(isDragging), Float.valueOf(percent), Integer.valueOf(offset), Integer.valueOf(headerHeight), Integer.valueOf(maxDragHeight));
        } else {
            E(new Function0<Unit>(offset, this, header) { // from class: com.tencent.qqnt.chats.view.MiniOldStyleHeaderNew$onHeaderMoving$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ q3.d $header;
                final /* synthetic */ int $offset;
                final /* synthetic */ MiniOldStyleHeaderNew this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$offset = offset;
                    this.this$0 = this;
                    this.$header = header;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(offset), this, header);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List list;
                    q3.a aVar;
                    q3.a aVar2;
                    q3.a aVar3;
                    q3.a aVar4;
                    q3.a aVar5;
                    RefreshState refreshState;
                    q3.a aVar6;
                    q3.a aVar7;
                    q3.a aVar8;
                    q3.a aVar9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    float height = this.$offset / this.this$0.getHeight();
                    list = CollectionsKt___CollectionsKt.toList(this.this$0.A());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((QQChatListTwoLevelHeader.b) it.next()).b(height);
                    }
                    this.this$0.R(this.$offset);
                    if (this.$header != null && this.this$0.B().getClipChildren()) {
                        this.this$0.S(this.$header, this.$offset, height);
                    }
                    if (height <= 0.12f) {
                        aVar = ((TwoLevelHeader) this.this$0).L;
                        Drawable background = aVar.getView().getBackground();
                        if (background != null) {
                            background.setAlpha(255);
                        }
                        this.this$0.B().setAlpha(0.0f);
                        aVar2 = ((TwoLevelHeader) this.this$0).L;
                        aVar2.getView().setVisibility(0);
                        aVar3 = ((TwoLevelHeader) this.this$0).L;
                        aVar3.getView().setAlpha(1.0f);
                    } else {
                        this.this$0.B().setAlpha(1.0f);
                        if (height > 0.25f) {
                            aVar9 = ((TwoLevelHeader) this.this$0).L;
                            aVar9.getView().setVisibility(8);
                        } else {
                            aVar6 = ((TwoLevelHeader) this.this$0).L;
                            aVar6.getView().setVisibility(0);
                            aVar7 = ((TwoLevelHeader) this.this$0).L;
                            aVar7.getView().setAlpha(1.0f - ((height - 0.12f) / 0.13f));
                            aVar8 = ((TwoLevelHeader) this.this$0).L;
                            Drawable background2 = aVar8.getView().getBackground();
                            if (background2 != null) {
                                background2.setAlpha(0);
                            }
                        }
                    }
                    aVar4 = ((TwoLevelHeader) this.this$0).L;
                    if (aVar4 instanceof AnimRefreshHeaderView) {
                        aVar5 = ((TwoLevelHeader) this.this$0).L;
                        Intrinsics.checkNotNull(aVar5, "null cannot be cast to non-null type com.tencent.qqnt.chats.view.AnimRefreshHeaderView");
                        AnimRefreshHeaderView animRefreshHeaderView = (AnimRefreshHeaderView) aVar5;
                        refreshState = this.this$0.myCurStatus;
                        animRefreshHeaderView.setProgressViewVisible(refreshState != RefreshState.TwoLevelFinish);
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
        E(new MiniOldStyleHeaderNew$onStateChanged$1(newState, this));
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

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newConfig);
        } else {
            super.onConfigurationChanged(newConfig);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.chats.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    MiniOldStyleHeaderNew.Q(MiniOldStyleHeaderNew.this);
                }
            });
        }
    }

    public final void setBaseOffset(int offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, offset);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, offset);
        } else {
            this.titleBarPadding = offset;
        }
    }
}
