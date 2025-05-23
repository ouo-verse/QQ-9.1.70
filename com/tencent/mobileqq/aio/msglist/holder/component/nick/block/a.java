package com.tencent.mobileqq.aio.msglist.holder.component.nick.block;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000  2\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010'\u001a\u00020#\u0012\u0006\u0010,\u001a\u00020(\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH$J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\fH&J\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\n\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002H\u0016R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b%\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00100R$\u00107\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u00103\u001a\u0004\b-\u00104\"\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "", "", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", h.F, "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "Landroid/view/View;", "j", "", "payloads", "", "i", "l", "k", "c", "b", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "vb", "a", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "g", "intent", "o", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "importance", "p", "Landroid/content/Context;", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "getRootView", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "f", "Landroid/view/View;", "blockView", "Lcom/tencent/aio/base/mvvm/a;", "parentVB", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;)V", "nickIconData", "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout rootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View blockView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> parentVB;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b nickIconData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a$a;", "", "", "BLOCK_HORIZONTAL_MARGIN", UserInfo.SEX_FEMALE, "BLOCK_VERTICAL_MARGIN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48750);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context context, @NotNull LinearLayout rootView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
        } else {
            this.context = context;
            this.rootView = rootView;
        }
    }

    public final void a(@NotNull com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) vb5);
        } else {
            Intrinsics.checkNotNullParameter(vb5, "vb");
            this.parentVB = vb5;
        }
    }

    @Nullable
    public final View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.blockView == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            View j3 = j(layoutParams);
            this.blockView = j3;
            Intrinsics.checkNotNull(j3);
            j3.setLayoutParams(layoutParams);
        }
        return this.blockView;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (this.blockView != null) {
                return;
            }
            b();
            this.rootView.addView(this.blockView);
        }
    }

    public abstract int d();

    @NotNull
    public final Context e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nickIconData;
    }

    public void g(@NotNull MviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    public abstract boolean h(@NotNull AIOMsgItem msgItem);

    public abstract void i(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads);

    @NotNull
    protected abstract View j(@NotNull LinearLayout.LayoutParams layoutParams);

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Nullable
    public View n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    public void o(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> aVar = this.parentVB;
        if (aVar != null) {
            aVar.sendIntent(intent);
        }
    }

    public void p(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, importance);
        }
    }

    public final void q(@Nullable com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.nickIconData = bVar;
        }
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }
}
