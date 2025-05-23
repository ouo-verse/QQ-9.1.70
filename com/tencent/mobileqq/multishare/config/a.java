package com.tencent.mobileqq.multishare.config;

import android.content.DialogInterface;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.multishare.action.b;
import com.tencent.mobileqq.multishare.action.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import j92.e;
import j92.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b]\u0010^R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b2\u0010\u0010R(\u00107\u001a\b\u0012\u0004\u0012\u0002040\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\r\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R$\u0010>\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010L\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010H\u001a\u0004\b*\u0010I\"\u0004\bJ\u0010KR$\u0010O\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010H\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR$\u0010Q\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010H\u001a\u0004\b@\u0010I\"\u0004\bP\u0010KR\"\u0010S\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\bR\u0010\bR$\u0010Z\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\b\"\u0010W\"\u0004\bX\u0010YR$\u0010\\\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010H\u001a\u0004\bU\u0010I\"\u0004\b[\u0010K\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/multishare/config/a;", "", "", "a", "Z", "p", "()Z", "w", "(Z)V", "isNeedShowRecentUsers", "", "Lcom/tencent/mobileqq/multishare/action/b;", "b", "Ljava/util/List;", "()Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/util/List;)V", "actionItems", "Lj92/b;", "c", "Lj92/b;", "d", "()Lj92/b;", "t", "(Lj92/b;)V", "itemClickListener", "Landroid/content/DialogInterface$OnShowListener;", "Landroid/content/DialogInterface$OnShowListener;", "i", "()Landroid/content/DialogInterface$OnShowListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/content/DialogInterface$OnShowListener;)V", "onShowListener", "Landroid/content/DialogInterface$OnCancelListener;", "e", "Landroid/content/DialogInterface$OnCancelListener;", "g", "()Landroid/content/DialogInterface$OnCancelListener;", HippyTKDListViewAdapter.X, "(Landroid/content/DialogInterface$OnCancelListener;)V", "onCancelListener", "Landroid/content/DialogInterface$OnDismissListener;", "f", "Landroid/content/DialogInterface$OnDismissListener;", h.F, "()Landroid/content/DialogInterface$OnDismissListener;", "y", "(Landroid/content/DialogInterface$OnDismissListener;)V", "onDismissListener", "Lcom/tencent/biz/richframework/part/Part;", ReportConstant.COSTREPORT_PREFIX, "extraParts", "Lcom/tencent/mobileqq/multishare/action/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B", "selectedUserList", "Lj92/e;", "Lj92/e;", "k", "()Lj92/e;", "setRecentShareSorter", "(Lj92/e;)V", "recentShareSorter", "Lj92/f;", "j", "Lj92/f;", "l", "()Lj92/f;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lj92/f;)V", "recentUserFetcher", "", "Ljava/lang/String;", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "msgHint", DomainData.DOMAIN_NAME, BdhLogUtil.LogTag.Tag_Conn, "sendText", "setPreLeaveMsg", "preLeaveMsg", "r", "alwaysShowPreviewLayout", "Lj92/a;", "o", "Lj92/a;", "()Lj92/a;", "u", "(Lj92/a;)V", "msgChecker", "D", "sharePanelTitle", "<init>", "()V", "qqmultishare-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedShowRecentUsers;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends b> actionItems;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j92.b itemClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnShowListener onShowListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnCancelListener onCancelListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener onDismissListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends Part> extraParts;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends c> selectedUserList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e recentShareSorter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f recentUserFetcher;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String msgHint;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String sendText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String preLeaveMsg;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean alwaysShowPreviewLayout;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j92.a msgChecker;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String sharePanelTitle;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isNeedShowRecentUsers = true;
            this.selectedUserList = new ArrayList();
        }
    }

    public final void A(@Nullable f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) fVar);
        } else {
            this.recentUserFetcher = fVar;
        }
    }

    public final void B(@NotNull List<? extends c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.selectedUserList = list;
        }
    }

    public final void C(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.sendText = str;
        }
    }

    public final void D(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            this.sharePanelTitle = str;
        }
    }

    @Nullable
    public final List<b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.actionItems;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.alwaysShowPreviewLayout;
    }

    @Nullable
    public final List<Part> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.extraParts;
    }

    @Nullable
    public final j92.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (j92.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.itemClickListener;
    }

    @Nullable
    public final j92.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (j92.a) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.msgChecker;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.msgHint;
    }

    @Nullable
    public final DialogInterface.OnCancelListener g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (DialogInterface.OnCancelListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.onCancelListener;
    }

    @Nullable
    public final DialogInterface.OnDismissListener h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (DialogInterface.OnDismissListener) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.onDismissListener;
    }

    @Nullable
    public final DialogInterface.OnShowListener i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DialogInterface.OnShowListener) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.onShowListener;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.preLeaveMsg;
    }

    @Nullable
    public final e k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (e) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.recentShareSorter;
    }

    @Nullable
    public final f l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (f) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.recentUserFetcher;
    }

    @NotNull
    public final List<c> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.selectedUserList;
    }

    @Nullable
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.sendText;
    }

    @Nullable
    public final String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.sharePanelTitle;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isNeedShowRecentUsers;
    }

    public final void q(@Nullable List<? extends b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.actionItems = list;
        }
    }

    public final void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.alwaysShowPreviewLayout = z16;
        }
    }

    public final void s(@Nullable List<? extends Part> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
        } else {
            this.extraParts = list;
        }
    }

    public final void t(@Nullable j92.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.itemClickListener = bVar;
        }
    }

    public final void u(@Nullable j92.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) aVar);
        } else {
            this.msgChecker = aVar;
        }
    }

    public final void v(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.msgHint = str;
        }
    }

    public final void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isNeedShowRecentUsers = z16;
        }
    }

    public final void x(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onCancelListener);
        } else {
            this.onCancelListener = onCancelListener;
        }
    }

    public final void y(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onDismissListener);
        } else {
            this.onDismissListener = onDismissListener;
        }
    }

    public final void z(@Nullable DialogInterface.OnShowListener onShowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onShowListener);
        } else {
            this.onShowListener = onShowListener;
        }
    }
}
