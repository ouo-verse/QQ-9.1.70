package com.tencent.mobileqq.login.relogin.dialog;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0016\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010(\u001a\u00020#\u0012\b\u0010.\u001a\u0004\u0018\u00010)\u0012\u0006\u0010B\u001a\u00020\u0014\u00a2\u0006\u0004\bC\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\"\u0010\u0013\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019H\u0017J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0006\u0010\u001f\u001a\u00020\u0006J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010.\u001a\u0004\u0018\u00010)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\"\u0010<\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00104R\u0018\u0010A\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/dialog/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/login/relogin/dialog/g;", "holder", "Lcom/tencent/mobileqq/login/account/a;", "account", "", "A0", "Landroid/view/View;", "view", "", "from", "to", "B0", "n0", "", "accounts", "", "currUin", "C0", "", "mode", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "x0", "position", "r0", "getItemCount", "q0", "t", "uin", "y0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/login/relogin/dialog/h;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/login/relogin/dialog/h;", "getListener", "()Lcom/tencent/mobileqq/login/relogin/dialog/h;", "listener", "", "D", "Ljava/util/List;", "accountList", "E", "Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, UserInfo.SEX_FEMALE, "Z", "p0", "()Z", "setEditMode", "(Z)V", "editMode", "G", "deleteModeUin", "H", "Lcom/tencent/mobileqq/login/relogin/dialog/g;", "deleteModeHolder", "isEditMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/login/relogin/dialog/h;Z)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f extends RecyclerView.Adapter<g> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final h listener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.login.account.a> accountList;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String currentUin;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean editMode;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String deleteModeUin;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private g deleteModeHolder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public f(@NotNull Context context, @Nullable h hVar, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, hVar, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        this.listener = hVar;
        this.accountList = new ArrayList();
        this.editMode = z16;
    }

    private final void A0(g holder, com.tencent.mobileqq.login.account.a account) {
        if (Intrinsics.areEqual(holder, this.deleteModeHolder)) {
            q0();
            return;
        }
        q0();
        this.deleteModeHolder = holder;
        this.deleteModeUin = account.f();
        float f16 = -holder.v().getWidth();
        B0(holder.q(), holder.q().getTranslationX(), f16);
        B0(holder.p(), holder.p().getTranslationX(), f16);
        B0(holder.v(), holder.v().getTranslationX(), f16);
    }

    private final void B0(View view, float from, float to5) {
        if (view.getTag() instanceof ObjectAnimator) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type android.animation.ObjectAnimator");
            ((ObjectAnimator) tag).cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", from, to5);
        ofFloat.setDuration(250L);
        view.setTag(ofFloat);
        ofFloat.start();
    }

    private final void n0() {
        g gVar = this.deleteModeHolder;
        if (gVar != null) {
            if (gVar.q().getTag() instanceof ObjectAnimator) {
                Object tag = gVar.q().getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type android.animation.ObjectAnimator");
                ((ObjectAnimator) tag).cancel();
            }
            if (gVar.p().getTag() instanceof ObjectAnimator) {
                Object tag2 = gVar.p().getTag();
                Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type android.animation.ObjectAnimator");
                ((ObjectAnimator) tag2).cancel();
            }
            if (gVar.v().getTag() instanceof ObjectAnimator) {
                Object tag3 = gVar.v().getTag();
                Intrinsics.checkNotNull(tag3, "null cannot be cast to non-null type android.animation.ObjectAnimator");
                ((ObjectAnimator) tag3).cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(f this$0, com.tencent.mobileqq.login.account.a account, g holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.y0("0X800C4C2", account.f());
        this$0.A0(holder, account);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(f this$0, com.tencent.mobileqq.login.account.a account, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        h hVar = this$0.listener;
        if (hVar != null) {
            hVar.b(account);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(f this$0, com.tencent.mobileqq.login.account.a account, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        h hVar = this$0.listener;
        if (hVar != null) {
            hVar.d(account);
        }
        this$0.y0("0X800C4C4", account.f());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(f this$0, com.tencent.mobileqq.login.account.a account, View view) {
        h hVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        if (!Intrinsics.areEqual(this$0.currentUin, account.f()) && (hVar = this$0.listener) != null) {
            hVar.a(account);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w0(f this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q0();
        return false;
    }

    public static /* synthetic */ void z0(f fVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        fVar.y0(str, str2);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void C0(@Nullable List<com.tencent.mobileqq.login.account.a> accounts, @Nullable String currUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) accounts, (Object) currUin);
            return;
        }
        this.currentUin = currUin;
        this.accountList.clear();
        if (accounts != null) {
            this.accountList.addAll(accounts);
        }
        n0();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.accountList.size();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void o0(boolean mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, mode);
            return;
        }
        this.editMode = mode;
        this.deleteModeUin = null;
        n0();
        this.deleteModeHolder = null;
        notifyDataSetChanged();
        if (this.editMode) {
            z0(this, "0X800C4C1", null, 2, null);
            z0(this, "0X800C4C3", null, 2, null);
        }
    }

    public final boolean p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.editMode;
    }

    public final void q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        g gVar = this.deleteModeHolder;
        if (gVar != null) {
            B0(gVar.q(), gVar.q().getTranslationX(), 0.0f);
            B0(gVar.p(), gVar.p().getTranslationX(), 0.0f);
            B0(gVar.v(), gVar.v().getTranslationX(), 0.0f);
            this.deleteModeHolder = null;
            this.deleteModeUin = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final g holder, int position) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        final com.tencent.mobileqq.login.account.a aVar = this.accountList.get(position);
        if (this.editMode) {
            holder.q().setVisibility(0);
            holder.q().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.s0(f.this, aVar, holder, view);
                }
            });
            if (AppSetting.f99565y) {
                holder.q().setContentDescription(HardCodeUtil.qqStr(R.string.ajx));
            }
        } else {
            holder.q().setOnClickListener(null);
            holder.q().setVisibility(8);
        }
        holder.v().setVisibility(0);
        holder.v().setBackground(new ColorDrawable(this.context.getColor(R.color.qui_common_feedback_error)));
        holder.v().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.t0(f.this, aVar, view);
            }
        });
        if (this.editMode && Intrinsics.areEqual(this.deleteModeUin, aVar.f())) {
            float f16 = -holder.v().getWidth();
            if (f16 == 0.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                f16 = -ViewUtils.dpToPx(80.0f);
            }
            holder.q().setTranslationX(f16);
            holder.p().setTranslationX(f16);
            holder.v().setTranslationX(f16);
        } else {
            holder.q().setTranslationX(0.0f);
            holder.p().setTranslationX(0.0f);
            holder.v().setTranslationX(0.0f);
        }
        com.tencent.mobileqq.login.account.d.i(com.tencent.mobileqq.login.account.d.f241848a, holder.m(), aVar.f(), 0, null, 12, null);
        holder.t().setText(aVar.d());
        String c16 = aVar.c();
        if (c16 != null && c16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            holder.l().setText(aVar.f());
        } else {
            holder.l().setText(c16);
        }
        int i3 = 4;
        if (this.editMode) {
            holder.s().setVisibility(0);
            if (aVar.g()) {
                holder.r().setVisibility(0);
                holder.r().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f.u0(f.this, aVar, view);
                    }
                });
                holder.u().setVisibility(4);
            } else {
                holder.r().setVisibility(4);
                holder.r().setOnClickListener(null);
                holder.u().setVisibility(0);
            }
        } else {
            holder.s().setVisibility(8);
        }
        if (this.editMode) {
            holder.o().setVisibility(8);
        } else {
            boolean areEqual = Intrinsics.areEqual(this.currentUin, aVar.f());
            ImageView o16 = holder.o();
            if (areEqual) {
                i3 = 0;
            }
            o16.setVisibility(i3);
            if (AppSetting.f99565y) {
                AccessibilityUtil.y(holder.itemView, ((Object) holder.t().getText()) + "\uff0c" + ((Object) holder.l().getText()), areEqual);
            }
        }
        int num_backgournd_icon = getNUM_BACKGOURND_ICON();
        if (num_backgournd_icon == 1) {
            holder.itemView.setBackgroundResource(R.drawable.ks7);
        } else if (position == 0) {
            holder.itemView.setBackgroundResource(R.drawable.ks8);
        } else if (position == num_backgournd_icon - 1) {
            holder.itemView.setBackgroundResource(R.drawable.ks6);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
        }
        if (this.editMode) {
            holder.itemView.setEnabled(false);
            holder.itemView.setOnClickListener(null);
        } else {
            holder.itemView.setEnabled(true);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.v0(f.this, aVar, view);
                }
            });
        }
        holder.p().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean w06;
                w06 = f.w0(f.this, view, motionEvent);
                return w06;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (g) iPatchRedirector.redirect((short) 8, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gyc, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026nt_manage, parent, false)");
        return new g(inflate);
    }

    public final void y0(@NotNull String t16, @Nullable String uin) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) t16, (Object) uin);
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
}
