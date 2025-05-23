package com.tencent.qqnt.chats.core.adapter.menu.creator;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/menu/creator/c;", "Lcom/tencent/qqnt/chats/core/adapter/menu/creator/a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "b", "view", "", "a", "", ReportConstant.COSTREPORT_PREFIX, "(I)I", "dp", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354615b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354616c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354617d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354618e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354619f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354620g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354621h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354622i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354623j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354624k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354625l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354626m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354627n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354628o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354629p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354630q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354631r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.chats.core.adapter.menu.a f354632s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private static final int[] f354633t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private static final int[] f354634u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private static final int[] f354635v;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0015\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\nR\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001e\u0010\nR\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\b\u001a\u0004\b \u0010\nR\u0017\u0010!\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\"\u0010\nR\u0017\u0010$\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R\u0017\u0010*\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010-R\u0014\u00101\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0014\u00102\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010-R\u0014\u00103\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0014\u00104\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u0010-R\u0014\u00105\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u0010-R\u0014\u00106\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u0010-R\u0014\u00107\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u0010-R\u0014\u00108\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u0010-R\u0014\u00109\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010-R\u0014\u0010:\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010-R\u0014\u0010;\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010-R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010-R\u0014\u0010=\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010-R\u0014\u0010>\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010-\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/menu/creator/c$a;", "", "", "type", "r", "i", "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "deleteItem", "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "g", "()Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "cancelTop", "d", "setTop", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "maskRead", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "maskUnRead", DomainData.DOMAIN_NAME, "cancelHide", "b", "publicAccountUnSub", "p", "channelCancelSub", "e", "msgNoDisturb", "o", "cancelMsgNoDisturb", "c", "foldGuild", h.F, "cancelFoldGuild", "a", "copyData", "f", "", "MENU_STR_IDS", "[I", "l", "()[I", "MENU_BG_IDS", "j", "MENU_IDS", "k", "MENU_INDEX_CANCEL_FOLD_GUILD", "I", "MENU_INDEX_CANCEL_HIDE", "MENU_INDEX_CANCEL_MSG_NO_DISTURB", "MENU_INDEX_CANCEL_SETTOP", "MENU_INDEX_CHANNEL_CANCEL_SUBSCRIBE", "MENU_INDEX_COPY_DATA", "MENU_INDEX_DEL", "MENU_INDEX_FOLD_GUILD", "MENU_INDEX_MASK_READ", "MENU_INDEX_MASK_UNREAD", "MENU_INDEX_MSG_NO_DISTURB", "MENU_INDEX_NOT_SHOW", "MENU_INDEX_PUBLIC_ACCOUNT_UNSUBSCRIBE", "MENU_INDEX_SETTOP", "MENU_INDEX_TROOPMSGSETTING", "MENU_INDEX_TROOP_CANCEL_SETTOP", "MENU_INDEX_TROOP_SETTOP", "MENU_INDEX_UNSUBSCRIBE", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.menu.creator.c$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
                return;
            }
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
                return c.f354631r;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 18, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return c.f354624k;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return c.f354629p;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return c.f354617d;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return c.f354627n;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                return c.f354632s;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 19, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return c.f354615b;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                return c.f354630q;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 17, (Object) this);
        }

        public final int i(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, type)).intValue();
            }
            if (type == -1 || type >= k().length) {
                return -1;
            }
            return k()[type];
        }

        @NotNull
        public final int[] j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
                return c.f354634u;
            }
            return (int[]) iPatchRedirector.redirect((short) 23, (Object) this);
        }

        @NotNull
        public final int[] k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
                return c.f354635v;
            }
            return (int[]) iPatchRedirector.redirect((short) 24, (Object) this);
        }

        @NotNull
        public final int[] l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                return c.f354633t;
            }
            return (int[]) iPatchRedirector.redirect((short) 22, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return c.f354619f;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return c.f354620g;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return c.f354628o;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return c.f354626m;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.menu.a q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return c.f354618e;
            }
            return (com.tencent.qqnt.chats.core.adapter.menu.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        public final int r(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, type)).intValue();
            }
            if (type == -1 || type >= k().length) {
                return -1;
            }
            return l()[type];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(VasWebviewConstants.REPORT_FROM_MY_INDIVIDUATION_SET);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        f354615b = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 0, R.id.epz, 0, 0, 0, 115, null);
        f354616c = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 1, R.id.eql, 0, 0, 0, 115, null);
        f354617d = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 2, R.id.epu, 0, 0, 0, 115, null);
        f354618e = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 3, R.id.eqe, 0, 0, 0, 115, null);
        f354619f = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 4, R.id.eqa, 0, 0, 0, 115, null);
        f354620g = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 5, R.id.eqb, 0, 0, 0, 115, null);
        f354621h = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 6, R.id.eqo, 0, 0, 0, 115, null);
        f354622i = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 7, R.id.eqk, 0, 0, 0, 115, null);
        f354623j = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 8, R.id.eqj, 0, 0, 0, 115, null);
        f354624k = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 9, R.id.gsg, 0, 0, 0, 115, null);
        f354625l = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 10, 0, 0, 0, 0, 123, null);
        f354626m = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 11, R.id.z4b, 0, 0, 0, 115, null);
        f354627n = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 12, R.id.z3n, 0, 0, 0, 115, null);
        f354628o = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 13, R.id.z49, 0, 0, 0, 115, null);
        f354629p = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 14, R.id.z3l, 0, 0, 0, 115, null);
        f354630q = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 15, R.id.z3x, 0, 0, 0, 115, null);
        f354631r = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 16, R.id.z3k, 0, 0, 0, 115, null);
        f354632s = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 17, R.id.z4o, 0, 0, 0, 115, null);
        f354633t = new int[]{R.string.zja, R.string.zl_, R.string.zj_, R.string.zld, R.string.zlc, R.string.zle, R.string.zlt, R.string.zld, R.string.zj_, R.string.zj5, R.string.zja, R.string.zla, R.string.zj7, R.string.zl9, R.string.zj6, R.string.zjb, R.string.f170721zj4, R.string.zl8};
        f354634u = new int[]{R.drawable.cja, R.drawable.cj9, R.drawable.mrz, R.drawable.mrz, R.drawable.cjb, R.drawable.cjb, R.drawable.cj9, R.drawable.mrz, R.drawable.mrz, R.drawable.cjb, R.drawable.cja, R.drawable.f160581ms1, R.drawable.cja, R.drawable.cjb, R.drawable.cjb, R.drawable.cjb, R.drawable.cjb, R.drawable.mrz};
        f354635v = new int[]{R.id.epz, R.id.eql, R.id.epu, R.id.eqe, R.id.eqa, R.id.eqb, R.id.eqo, R.id.eqk, R.id.eqj, R.id.gsg, R.id.z4a, R.id.z4b, R.id.z3n, R.id.z49, R.id.z3l, R.id.z3x, R.id.z3k, R.id.z4o};
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.menu.creator.a
    public void a(@NotNull View view, @NotNull com.tencent.qqnt.chats.core.adapter.menu.a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        int[] iArr = f354635v;
        int i3 = iArr[item.f()];
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getId() != i3) {
                int a16 = item.a();
                Integer e16 = item.e();
                if (item.f() != -1 && item.f() < iArr.length) {
                    i3 = iArr[item.f()];
                    a16 = f354634u[item.f()];
                    e16 = Integer.valueOf(f354633t[item.f()]);
                }
                textView.setId(i3);
                textView.setBackgroundResource(a16);
                if (e16 != null) {
                    textView.setText(e16.intValue());
                } else {
                    textView.setText(item.d());
                }
            }
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.menu.creator.a
    @NotNull
    public View b(@NotNull ViewGroup parent, @NotNull com.tencent.qqnt.chats.core.adapter.menu.a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, (Object) item);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(item.g(), item.b()));
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        textView.setPadding(s(20), 0, s(20), 0);
        int c16 = item.c();
        int a16 = item.a();
        Integer e16 = item.e();
        if (item.f() != -1) {
            int f16 = item.f();
            int[] iArr = f354635v;
            if (f16 < iArr.length) {
                c16 = iArr[item.f()];
                a16 = f354634u[item.f()];
                e16 = Integer.valueOf(f354633t[item.f()]);
            }
        }
        textView.setId(c16);
        textView.setBackgroundResource(a16);
        if (e16 != null) {
            textView.setText(e16.intValue());
        } else {
            textView.setText(item.d());
        }
        return textView;
    }

    public final int s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        return (int) TypedValue.applyDimension(1, i3, Resources.getSystem().getDisplayMetrics());
    }
}
