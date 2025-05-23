package com.tencent.mobileqq.account.configs;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.account.bean.QQAccount;
import com.tencent.mobileqq.account.view.AccountItemView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001\u0018B=\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\t\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u001a\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/account/configs/AccountListView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/account/view/AccountItemView$b;", "", "B", "Lcom/tencent/mobileqq/account/view/AccountItemView;", "itemView", "Lcom/tencent/mobileqq/account/bean/QQAccount;", "account", "", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isEdit", "p", "u", "v", ReportConstant.COSTREPORT_PREFIX, "t", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "view", "a", "b", "c", "Lcom/tencent/mobileqq/account/viewmodel/a;", "d", "Lcom/tencent/mobileqq/account/viewmodel/a;", "vm", "Lw51/a;", "e", "Lw51/a;", "interaction", "f", "Landroid/view/View;", "addAccountView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "addAccountIcon", "", "i", "Ljava/util/List;", "accountList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "accountItemViewList", BdhLogUtil.LogTag.Tag_Conn, "Z", "isEditing", "D", "Lcom/tencent/mobileqq/account/view/AccountItemView;", "currDelSelectionItemView", "E", "Landroid/widget/LinearLayout;", "llAccountList", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/account/viewmodel/a;Lw51/a;Landroidx/lifecycle/LifecycleOwner;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AccountListView extends LinearLayout implements AccountItemView.b {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isEditing;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AccountItemView currDelSelectionItemView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout llAccountList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.account.viewmodel.a vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final w51.a interaction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View addAccountView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView addAccountIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QQAccount> accountList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AccountItemView> accountItemViewList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/account/configs/AccountListView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.account.configs.AccountListView$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ AccountListView(Context context, com.tencent.mobileqq.account.viewmodel.a aVar, w51.a aVar2, LifecycleOwner lifecycleOwner, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar, aVar2, lifecycleOwner, (i16 & 16) != 0 ? null : attributeSet, (i16 & 32) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, aVar, aVar2, lifecycleOwner, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        int i3;
        if (je0.a.a(getContext())) {
            i3 = R.drawable.nja;
        } else {
            i3 = R.drawable.nj_;
        }
        ImageView imageView = this.addAccountIcon;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(boolean isEdit) {
        this.isEditing = isEdit;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            View view = this.addAccountView;
            if (childAt == view) {
                if (isEdit) {
                    if (view != null) {
                        view.setVisibility(8);
                    }
                } else if (view != null) {
                    view.setVisibility(0);
                }
            } else if (childAt instanceof AccountItemView) {
                if (isEdit) {
                    ((AccountItemView) childAt).g();
                } else {
                    ((AccountItemView) childAt).c();
                    v();
                }
            }
        }
    }

    private final View q() {
        int i3 = 0;
        View addAccountView = LayoutInflater.from(getContext()).inflate(R.layout.h7t, (ViewGroup) this, false);
        addAccountView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.account.configs.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountListView.r(AccountListView.this, view);
            }
        });
        addAccountView.setBackground(AccountItemView.b(getContext(), 0.0f, 16.0f));
        if (this.isEditing) {
            i3 = 8;
        }
        addAccountView.setVisibility(i3);
        Intrinsics.checkNotNullExpressionValue(addAccountView, "addAccountView");
        return addAccountView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AccountListView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.account.utils.a.a() >= 8) {
            this$0.w();
        } else {
            this$0.interaction.a(null, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int s() {
        return this.accountList.size();
    }

    private final void t(QQAccount account) {
        this.interaction.c(com.tencent.mobileqq.account.utils.a.c(account.getUin()));
    }

    private final void u() {
        AccountItemView accountItemView = this.currDelSelectionItemView;
        if (accountItemView != null) {
            if (accountItemView != null) {
                accountItemView.d();
            }
            this.currDelSelectionItemView = null;
        }
    }

    private final void v() {
        AccountItemView accountItemView = this.currDelSelectionItemView;
        if (accountItemView != null) {
            if (accountItemView != null) {
                accountItemView.e();
            }
            this.currDelSelectionItemView = null;
        }
    }

    private final void w() {
        QQCustomDialog message = DialogUtil.createCustomDialog(getContext(), 230).setTitle(getContext().getString(R.string.f1636423o)).setMessage("\u4f60\u767b\u5f55\u7684\u8d26\u53f7\u6570\u91cf\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u5220\u9664\u90e8\u5206\u8d26\u53f7\u540e\u91cd\u65b0\u767b\u5f55");
        Intrinsics.checkNotNullExpressionValue(message, "createCustomDialog(conte\u2026\u5f55\u7684\u8d26\u53f7\u6570\u91cf\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u5220\u9664\u90e8\u5206\u8d26\u53f7\u540e\u91cd\u65b0\u767b\u5f55\")");
        message.setPositiveButton(R.string.f16346237, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.account.configs.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountListView.x(AccountListView.this, dialogInterface, i3);
            }
        });
        message.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.account.configs.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountListView.y(dialogInterface, i3);
            }
        });
        message.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(AccountListView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vm.N1().postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void z(AccountItemView itemView, QQAccount account, int pos) {
        int s16;
        itemView.setAccount(account);
        if (this.isEditing) {
            s16 = s();
        } else {
            s16 = s() + 1;
        }
        itemView.setPosition(pos, s16);
        if (this.isEditing) {
            itemView.g();
        } else {
            itemView.c();
        }
        itemView.setOnItemClickListener(this);
    }

    public final void A() {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int s16 = s();
        if (s16 != this.accountItemViewList.size()) {
            this.llAccountList.removeAllViews();
            this.accountItemViewList.clear();
            for (int i3 = 0; i3 < s16; i3++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h7u, (ViewGroup) this, false);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.account.view.AccountItemView");
                AccountItemView accountItemView = (AccountItemView) inflate;
                this.accountItemViewList.add(accountItemView);
                this.llAccountList.addView(accountItemView);
            }
            View q16 = q();
            this.addAccountView = q16;
            if (q16 != null) {
                imageView = (ImageView) q16.findViewById(R.id.f164305sn0);
            } else {
                imageView = null;
            }
            this.addAccountIcon = imageView;
            B();
            this.llAccountList.addView(this.addAccountView);
        }
        for (int i16 = 0; i16 < s16; i16++) {
            z(this.accountItemViewList.get(i16), this.accountList.get(i16), i16);
        }
    }

    @Override // com.tencent.mobileqq.account.view.AccountItemView.b
    public void a(@Nullable AccountItemView view, @NotNull QQAccount account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) account);
            return;
        }
        Intrinsics.checkNotNullParameter(account, "account");
        QLog.d("AccountListView", 2, "AccountItemView onItemClick type = " + account.getType());
        if (this.isEditing) {
            u();
            return;
        }
        if (TextUtils.equals(account.getUin(), MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin())) {
            return;
        }
        t(account);
        VideoReport.setElementId(view, "em_bas_account_management");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, null);
    }

    @Override // com.tencent.mobileqq.account.view.AccountItemView.b
    public void b(@Nullable AccountItemView view, @Nullable QQAccount account) {
        String str;
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) account);
            return;
        }
        String str5 = null;
        if (account != null) {
            str = account.getUin();
        } else {
            str = null;
        }
        if (com.tencent.mobileqq.account.utils.a.c(str) != null) {
            w51.a aVar = this.interaction;
            if (account != null) {
                str5 = account.getUin();
            }
            aVar.b(str5);
            return;
        }
        if (account != null) {
            str2 = account.getUin();
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            com.tencent.mobileqq.account.viewmodel.a aVar2 = this.vm;
            if (account != null) {
                str4 = account.getId();
            } else {
                str4 = null;
            }
            aVar2.T1(null, str4);
            return;
        }
        com.tencent.mobileqq.account.viewmodel.a aVar3 = this.vm;
        if (account != null) {
            str3 = account.getUin();
        } else {
            str3 = null;
        }
        aVar3.T1(str3, null);
    }

    @Override // com.tencent.mobileqq.account.view.AccountItemView.b
    public void c(@Nullable AccountItemView view, @Nullable QQAccount account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) account);
            return;
        }
        AccountItemView accountItemView = this.currDelSelectionItemView;
        if (accountItemView == null) {
            this.currDelSelectionItemView = view;
            if (view != null) {
                view.h();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(accountItemView, view)) {
            u();
            this.currDelSelectionItemView = view;
            return;
        }
        u();
        this.currDelSelectionItemView = view;
        if (view != null) {
            view.h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountListView(@NotNull Context context, @NotNull com.tencent.mobileqq.account.viewmodel.a vm5, @NotNull w51.a interaction, @NotNull LifecycleOwner owner, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(owner, "owner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, vm5, interaction, owner, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.vm = vm5;
        this.interaction = interaction;
        this.accountList = new ArrayList();
        this.accountItemViewList = new ArrayList();
        this.isEditing = vm5.O1();
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.llAccountList = linearLayout;
        addView(linearLayout);
        MutableLiveData<List<QQAccount>> M1 = vm5.M1();
        final Function1<List<? extends QQAccount>, Unit> function1 = new Function1<List<? extends QQAccount>, Unit>() { // from class: com.tencent.mobileqq.account.configs.AccountListView.2
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountListView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QQAccount> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends QQAccount> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                QLog.d("AccountListView", 2, "observeAccountList onChanged");
                AccountListView.this.accountList.clear();
                if (list != null) {
                    AccountListView.this.accountList.addAll(list);
                }
                AccountListView.this.A();
            }
        };
        M1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.account.configs.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountListView.j(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> R1 = vm5.R1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.account.configs.AccountListView.3
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountListView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isEdit) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) isEdit);
                    return;
                }
                AccountListView accountListView = AccountListView.this;
                Intrinsics.checkNotNullExpressionValue(isEdit, "isEdit");
                accountListView.p(isEdit.booleanValue());
            }
        };
        R1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.account.configs.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountListView.k(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> P1 = vm5.P1();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.account.configs.AccountListView.4
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountListView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AccountListView.this.B();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                }
            }
        };
        P1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.account.configs.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountListView.l(Function1.this, obj);
            }
        });
    }
}
