package com.tencent.qqnt.chats.core.ui.refresh;

import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.n;
import com.tencent.qqnt.chats.view.AnimRefreshHeaderView;
import com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q3.d;
import q3.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000f*\u0001)\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u0012\u0006\u0010\"\u001a\u00020\u0018\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\"\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/refresh/c;", "Lcom/tencent/qqnt/chats/core/ui/n;", "", "isEnable", "", h.F, "handleBackPress", "Lcom/tencent/qqnt/chats/core/ui/listener/b;", "refreshListener", "f", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader$b;", "listener", "g", "Lq3/d;", "d", "Lq3/d;", "defaultHeader", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "e", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "secondLevelHeader", "Lq3/f;", "Lq3/f;", "refreshView", "Landroid/view/View;", "Landroid/view/View;", "getTitleBar", "()Landroid/view/View;", "titleBar", "i", "getContentView", "contentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getThirdContainer", "thirdContainer", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "com/tencent/qqnt/chats/core/ui/refresh/c$a", "D", "Lcom/tencent/qqnt/chats/core/ui/refresh/c$a;", "callback", "E", "Lcom/tencent/qqnt/chats/core/ui/listener/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader$b;", "onProcessChangeListener", "G", "Z", "enableTwoLevel", "<init>", "(Lq3/d;Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;Lq3/f;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/content/Context;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private a callback;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.ui.listener.b refreshListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQChatListTwoLevelHeader.b onProcessChangeListener;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean enableTwoLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d defaultHeader;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQChatListTwoLevelHeader secondLevelHeader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f refreshView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View titleBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View contentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View thirdContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/chats/core/ui/refresh/c$a", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader$b;", "", "cur", "", "b", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements QQChatListTwoLevelHeader.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader.b
        public void a(@NotNull RefreshState oldState, @NotNull RefreshState newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldState, (Object) newState);
                return;
            }
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(newState, "newState");
            QQChatListTwoLevelHeader.b bVar = c.this.onProcessChangeListener;
            if (bVar != null) {
                bVar.a(oldState, newState);
            }
        }

        @Override // com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader.b
        public void b(float cur) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQChatListTwoLevelHeader.b bVar = c.this.onProcessChangeListener;
                if (bVar != null) {
                    bVar.b(cur);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(cur));
        }
    }

    public c(@NotNull d defaultHeader, @NotNull QQChatListTwoLevelHeader secondLevelHeader, @NotNull f refreshView, @NotNull View titleBar, @NotNull View contentView, @NotNull View thirdContainer, @NotNull Context context) {
        AnimRefreshHeaderView animRefreshHeaderView;
        Intrinsics.checkNotNullParameter(defaultHeader, "defaultHeader");
        Intrinsics.checkNotNullParameter(secondLevelHeader, "secondLevelHeader");
        Intrinsics.checkNotNullParameter(refreshView, "refreshView");
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(thirdContainer, "thirdContainer");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, defaultHeader, secondLevelHeader, refreshView, titleBar, contentView, thirdContainer, context);
            return;
        }
        this.defaultHeader = defaultHeader;
        this.secondLevelHeader = secondLevelHeader;
        this.refreshView = refreshView;
        this.titleBar = titleBar;
        this.contentView = contentView;
        this.thirdContainer = thirdContainer;
        this.context = context;
        this.callback = new a();
        this.enableTwoLevel = true;
        refreshView.b(this.secondLevelHeader);
        this.secondLevelHeader.t(new o3.a() { // from class: com.tencent.qqnt.chats.core.ui.refresh.a
            @Override // o3.a
            public final boolean a(f fVar) {
                boolean c16;
                c16 = c.c(fVar);
                return c16;
            }
        });
        refreshView.c(this.secondLevelHeader);
        refreshView.setEnableLoadMore(false);
        refreshView.a(true);
        refreshView.setEnableOverScrollDrag(true);
        refreshView.g(1.0f);
        d dVar = this.defaultHeader;
        if (dVar instanceof AnimRefreshHeaderView) {
            animRefreshHeaderView = (AnimRefreshHeaderView) dVar;
        } else {
            animRefreshHeaderView = null;
        }
        float f16 = 40.0f;
        if (animRefreshHeaderView != null && animRefreshHeaderView.i()) {
            f16 = 64.0f;
        }
        refreshView.m(f16);
        refreshView.g(0.5f);
        refreshView.l(new r3.h() { // from class: com.tencent.qqnt.chats.core.ui.refresh.b
            @Override // r3.h
            public final void e(f fVar) {
                c.d(c.this, fVar);
            }
        });
        titleBar.bringToFront();
        this.secondLevelHeader.z(this.callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(f it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.qqnt.chats.core.ui.listener.b bVar = this$0.refreshListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void f(@NotNull com.tencent.qqnt.chats.core.ui.listener.b refreshListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) refreshListener);
        } else {
            Intrinsics.checkNotNullParameter(refreshListener, "refreshListener");
            this.refreshListener = refreshListener;
        }
    }

    public final void g(@Nullable QQChatListTwoLevelHeader.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
        } else {
            this.onProcessChangeListener = listener;
        }
    }

    public final void h(boolean isEnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isEnable);
            return;
        }
        if (isEnable == this.enableTwoLevel) {
            return;
        }
        this.enableTwoLevel = isEnable;
        if (isEnable) {
            this.refreshView.b(this.secondLevelHeader);
            this.refreshView.c(this.secondLevelHeader);
        } else {
            this.refreshView.b(this.defaultHeader);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.n
    public boolean handleBackPress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.secondLevelHeader.D()) {
            this.secondLevelHeader.g();
            return true;
        }
        return false;
    }
}
