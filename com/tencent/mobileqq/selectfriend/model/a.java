package com.tencent.mobileqq.selectfriend.model;

import android.content.DialogInterface;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\t\u0010\u001bR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u0003\u0010\u001bR\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\u001d\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/selectfriend/model/a;", "", "", "a", "Z", "i", "()Z", "isShowEditInput", "Landroid/view/View;", "b", "Landroid/view/View;", "c", "()Landroid/view/View;", "contentView", "", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "dialogTitle", "e", "editHint", "f", "leftBtnText", "g", "rightBtnText", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface$OnClickListener;", "()Landroid/content/DialogInterface$OnClickListener;", "confirmListener", h.F, "cancelListener", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Ljava/util/List;", "()Ljava/util/List;", "targetList", "Lcom/tencent/mobileqq/selectfriend/model/a$a;", "builder", "<init>", "(Lcom/tencent/mobileqq/selectfriend/model/a$a;)V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowEditInput;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View contentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String dialogTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String editHint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String leftBtnText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String rightBtnText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final DialogInterface.OnClickListener confirmListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final DialogInterface.OnClickListener cancelListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<ResultRecord> targetList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u001b\u001a\u00020\u00002\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010(\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00103\u001a\u0004\b'\u00104\"\u0004\b5\u00106R$\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00103\u001a\u0004\b!\u00104\"\u0004\b7\u00106R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/model/a$a;", "", "Lcom/tencent/mobileqq/selectfriend/model/a;", "a", "", "isShowEditInput", "p", "Landroid/view/View;", "contentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "dialogTitle", DomainData.DOMAIN_NAME, "editHint", "o", "leftBtnText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "rightBtnText", "r", "Landroid/content/DialogInterface$OnClickListener;", "confirmListener", "l", "cancelListener", "k", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", ReportConstant.COSTREPORT_PREFIX, "Z", "j", "()Z", "setShowEditInput", "(Z)V", "b", "Landroid/view/View;", "d", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setDialogTitle", "(Ljava/lang/String;)V", "f", "setEditHint", "g", "setLeftBtnText", h.F, "setRightBtnText", "Landroid/content/DialogInterface$OnClickListener;", "()Landroid/content/DialogInterface$OnClickListener;", "setConfirmListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "setCancelListener", "i", "Ljava/util/List;", "()Ljava/util/List;", "setTargetList", "(Ljava/util/List;)V", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectfriend.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8561a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isShowEditInput;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View contentView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String dialogTitle;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String editHint;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String leftBtnText;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String rightBtnText;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private DialogInterface.OnClickListener confirmListener;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private DialogInterface.OnClickListener cancelListener;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<? extends ResultRecord> targetList;

        public C8561a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (a) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return new a(this);
        }

        @Nullable
        public final DialogInterface.OnClickListener b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.cancelListener;
        }

        @Nullable
        public final DialogInterface.OnClickListener c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.confirmListener;
        }

        @Nullable
        public final View d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.contentView;
        }

        @Nullable
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.dialogTitle;
        }

        @Nullable
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.editHint;
        }

        @Nullable
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.leftBtnText;
        }

        @Nullable
        public final String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.rightBtnText;
        }

        @Nullable
        public final List<ResultRecord> i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (List) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.targetList;
        }

        public final boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isShowEditInput;
        }

        @NotNull
        public final C8561a k(@Nullable DialogInterface.OnClickListener cancelListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (C8561a) iPatchRedirector.redirect((short) 28, (Object) this, (Object) cancelListener);
            }
            this.cancelListener = cancelListener;
            return this;
        }

        @NotNull
        public final C8561a l(@Nullable DialogInterface.OnClickListener confirmListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (C8561a) iPatchRedirector.redirect((short) 27, (Object) this, (Object) confirmListener);
            }
            this.confirmListener = confirmListener;
            return this;
        }

        @NotNull
        public final C8561a m(@Nullable View contentView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (C8561a) iPatchRedirector.redirect((short) 22, (Object) this, (Object) contentView);
            }
            this.contentView = contentView;
            return this;
        }

        @NotNull
        public final C8561a n(@Nullable String dialogTitle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (C8561a) iPatchRedirector.redirect((short) 23, (Object) this, (Object) dialogTitle);
            }
            this.dialogTitle = dialogTitle;
            return this;
        }

        @NotNull
        public final C8561a o(@Nullable String editHint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (C8561a) iPatchRedirector.redirect((short) 24, (Object) this, (Object) editHint);
            }
            this.editHint = editHint;
            return this;
        }

        @NotNull
        public final C8561a p(boolean isShowEditInput) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (C8561a) iPatchRedirector.redirect((short) 21, (Object) this, isShowEditInput);
            }
            this.isShowEditInput = isShowEditInput;
            return this;
        }

        @NotNull
        public final C8561a q(@Nullable String leftBtnText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (C8561a) iPatchRedirector.redirect((short) 25, (Object) this, (Object) leftBtnText);
            }
            this.leftBtnText = leftBtnText;
            return this;
        }

        @NotNull
        public final C8561a r(@Nullable String rightBtnText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (C8561a) iPatchRedirector.redirect((short) 26, (Object) this, (Object) rightBtnText);
            }
            this.rightBtnText = rightBtnText;
            return this;
        }

        @NotNull
        public final C8561a s(@Nullable List<? extends ResultRecord> targetList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (C8561a) iPatchRedirector.redirect((short) 29, (Object) this, (Object) targetList);
            }
            this.targetList = targetList;
            return this;
        }
    }

    public a(@NotNull C8561a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.isShowEditInput = builder.j();
        this.contentView = builder.d();
        this.dialogTitle = builder.e();
        this.editHint = builder.f();
        this.leftBtnText = builder.g();
        this.rightBtnText = builder.h();
        this.confirmListener = builder.c();
        this.cancelListener = builder.b();
        this.targetList = builder.i();
    }

    @Nullable
    public final DialogInterface.OnClickListener a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.cancelListener;
    }

    @Nullable
    public final DialogInterface.OnClickListener b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.confirmListener;
    }

    @Nullable
    public final View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.contentView;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.dialogTitle;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.editHint;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.leftBtnText;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.rightBtnText;
    }

    @Nullable
    public final List<ResultRecord> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.targetList;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isShowEditInput;
    }
}
