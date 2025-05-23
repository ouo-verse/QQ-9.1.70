package com.tencent.mobileqq.login.relogin.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.af;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010C\u001a\u00020B\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\b\u0010+\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0019\u0010+\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010?R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/dialog/y;", "Lcom/tencent/mobileqq/login/dialog/LoginHalfScreenDialog;", "Landroid/view/View;", "contentView", "", "b0", "k0", "", "editMode", "j0", "W", "", "Lcom/tencent/mobileqq/login/account/a;", "accounts", "", "uin", "i0", "", HippyTKDListViewAdapter.X, "y", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "t", "f0", "G", "Ljava/util/List;", "getAccountList", "()Ljava/util/List;", "setAccountList", "(Ljava/util/List;)V", "accountList", "H", "Ljava/lang/String;", "getCurrUin", "()Ljava/lang/String;", "setCurrUin", "(Ljava/lang/String;)V", "currUin", "Lcom/tencent/mobileqq/login/relogin/dialog/h;", "I", "Lcom/tencent/mobileqq/login/relogin/dialog/h;", "getListener", "()Lcom/tencent/mobileqq/login/relogin/dialog/h;", "listener", "J", "Z", "getEditMode", "()Z", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "titleTv", "L", "editTv", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "M", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "bounceScrollView", "Landroidx/recyclerview/widget/RecyclerView;", "N", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/login/relogin/dialog/f;", "Lcom/tencent/mobileqq/login/relogin/dialog/f;", "adapter", "interceptHalfScreenScroll", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mobileqq/login/relogin/dialog/h;Z)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class y extends LoginHalfScreenDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.login.account.a> accountList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String currUin;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final h listener;

    /* renamed from: J, reason: from kotlin metadata */
    private final boolean editMode;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView editTv;

    /* renamed from: M, reason: from kotlin metadata */
    private BounceScrollView bounceScrollView;

    /* renamed from: N, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private f adapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean interceptHalfScreenScroll;

    public /* synthetic */ y(Context context, List list, String str, h hVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, str, hVar, (i3 & 16) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, list, str, hVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void b0(View contentView) {
        View findViewById = contentView.findViewById(R.id.adr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.bounce_scroll_view)");
        BounceScrollView bounceScrollView = (BounceScrollView) findViewById;
        this.bounceScrollView = bounceScrollView;
        RecyclerView recyclerView = null;
        if (bounceScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bounceScrollView");
            bounceScrollView = null;
        }
        bounceScrollView.setOnInterceptTouchEventListener(new af() { // from class: com.tencent.mobileqq.login.relogin.dialog.w
            @Override // com.tencent.mobileqq.widget.af
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                boolean c06;
                c06 = y.c0(y.this, motionEvent);
                return c06;
            }
        });
        BounceScrollView bounceScrollView2 = this.bounceScrollView;
        if (bounceScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bounceScrollView");
            bounceScrollView2 = null;
        }
        bounceScrollView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.x
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d06;
                d06 = y.d0(y.this, view, motionEvent);
                return d06;
            }
        });
        View findViewById2 = contentView.findViewById(R.id.f71803p5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026id.recycler_account_list)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.recyclerView = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Drawable drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.f161772ks3, null);
        if (drawable != null) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            recyclerView3.addItemDecoration(new u(drawable));
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setVerticalScrollBarEnabled(false);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        f fVar = new f(context, this.listener, this.editMode);
        this.adapter = fVar;
        fVar.C0(this.accountList, this.currUin);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView.setAdapter(this.adapter);
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c0(y this$0, MotionEvent motionEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this$0.interceptHalfScreenScroll = true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d0(y this$0, View view, MotionEvent motionEvent) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        boolean z16 = true;
        if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
            z16 = false;
        }
        if (z16) {
            this$0.interceptHalfScreenScroll = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(y this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h hVar = this$0.listener;
        if (hVar != null) {
            hVar.c(this$0);
        }
        f fVar = this$0.adapter;
        if (fVar != null) {
            if (fVar.p0()) {
                f.z0(fVar, "0X800C4CA", null, 2, null);
            } else {
                f.z0(fVar, "0X800C4C8", null, 2, null);
            }
            fVar.o0(!fVar.p0());
            this$0.j0(fVar.p0());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void g0(y yVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        yVar.f0(str, str2);
    }

    private final void j0(boolean editMode) {
        String string;
        int i3;
        TextView textView = this.editTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTv");
            textView = null;
        }
        if (editMode) {
            string = getContext().getString(R.string.f199944qs);
        } else {
            string = getContext().getString(R.string.f199954qt);
        }
        textView.setText(string);
        if (AppSetting.f99565y) {
            TextView textView2 = this.editTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editTv");
                textView2 = null;
            }
            AccessibilityUtil.d(textView2, Button.class.getName());
        }
        TextView textView3 = this.titleTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView3 = null;
        }
        if (editMode) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView3.setVisibility(i3);
        if (editMode) {
            g0(this, "0X800C4C9", null, 2, null);
        } else {
            g0(this, "0X800C4C7", null, 2, null);
        }
    }

    private final void k0() {
        BounceScrollView bounceScrollView = this.bounceScrollView;
        BounceScrollView bounceScrollView2 = null;
        if (bounceScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bounceScrollView");
            bounceScrollView = null;
        }
        ViewGroup.LayoutParams layoutParams = bounceScrollView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (this.accountList.size() > 4) {
            layoutParams.height = Utils.n(324.0f, getContext().getResources());
        } else {
            layoutParams.height = -2;
        }
        BounceScrollView bounceScrollView3 = this.bounceScrollView;
        if (bounceScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bounceScrollView");
        } else {
            bounceScrollView2 = bounceScrollView3;
        }
        bounceScrollView2.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog
    public boolean P(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }
        return this.interceptHalfScreenScroll;
    }

    @Override // com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog
    public boolean Q(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }
        return this.interceptHalfScreenScroll;
    }

    @Override // com.tencent.mobileqq.login.dialog.LoginHalfScreenDialog
    @NotNull
    public View W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        TextView textView = null;
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.gy6, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        b0(contentView);
        View findViewById = contentView.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.tv_title)");
        this.titleTv = (TextView) findViewById;
        View findViewById2 = contentView.findViewById(R.id.k7l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.tv_edit)");
        TextView textView2 = (TextView) findViewById2;
        this.editTv = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTv");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.e0(y.this, view);
            }
        });
        j0(this.editMode);
        return contentView;
    }

    public final void f0(@NotNull String t16, @Nullable String uin) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) t16, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(t16, "t");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        List<com.tencent.mobileqq.login.account.a> list = this.accountList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        ReportController.r(peekAppRuntime, "dc00898", "", uin, t16, t16, 0, 0, "", str, z.i(), "");
    }

    public final void i0(@NotNull List<com.tencent.mobileqq.login.account.a> accounts, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) accounts, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(accounts, "accounts");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.accountList = accounts;
        this.currUin = uin;
        k0();
        f fVar = this.adapter;
        if (fVar != null) {
            fVar.C0(accounts, uin);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@NotNull Context context, @NotNull List<com.tencent.mobileqq.login.account.a> accountList, @NotNull String currUin, @Nullable h hVar, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountList, "accountList");
        Intrinsics.checkNotNullParameter(currUin, "currUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, accountList, currUin, hVar, Boolean.valueOf(z16));
            return;
        }
        this.accountList = accountList;
        this.currUin = currUin;
        this.listener = hVar;
        this.editMode = z16;
    }
}
