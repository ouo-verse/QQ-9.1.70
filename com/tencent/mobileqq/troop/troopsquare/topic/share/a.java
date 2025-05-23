package com.tencent.mobileqq.troop.troopsquare.topic.share;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsquare.common.c;
import com.tencent.mobileqq.troop.troopsquare.utils.ShareAction;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/a;", "Lcom/tencent/mobileqq/troop/troopsquare/utils/b;", "", "channelType", "", "targetId", "idType", "", "success", "", "i", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/troop/troopsquare/utils/ShareAction;", "action", h.F, "e", "f", "a", "g", "c", "b", "d", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "getPage", "()Landroidx/fragment/app/Fragment;", "page", "<init>", "(Landroidx/fragment/app/Fragment;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements com.tencent.mobileqq.troop.troopsquare.utils.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment page;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/a$a;", "", "", "CHANNEL_TYPE_CHANNEL", "I", "CHANNEL_TYPE_QQ", "CHANNEL_TYPE_QZONE", "CHANNEL_TYPE_WECHAR_CIRCLE", "CHANNEL_TYPE_WECHAT", "", "PG_GROUP_SQUARE_TOPIC", "Ljava/lang/String;", "PG_ID", "SHARE_TYPE_FRIEND", "SHARE_TYPE_GROUP", "SHARE_TYPE_MORE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.share.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Fragment page) {
        Intrinsics.checkNotNullParameter(page, "page");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) page);
        } else {
            this.page = page;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void a(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("channelType", 2), TuplesKt.to("dt_pgid", "pg_group_square_topic"));
        cVar.d(c16, "em_share_item", hashMapOf, this.page.getView());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void b(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("channelType", 5), TuplesKt.to("dt_pgid", "pg_group_square_topic"));
        cVar.d(c16, "em_share_item", hashMapOf, this.page.getView());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void c(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("channelType", 4), TuplesKt.to("dt_pgid", "pg_group_square_topic"));
        cVar.d(c16, "em_share_item", hashMapOf, this.page.getView());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void d(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("dt_pgid", "pg_group_square_topic"));
        cVar.d(c16, "em_share_copy", hashMapOf, this.page.getView());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void e(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, 3), TuplesKt.to("dt_pgid", "pg_group_square_topic"));
        cVar.d(c16, "em_group_share_c2c", hashMapOf, this.page.getView());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void f(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        if (action.b().uinType != 1) {
            i3 = 1;
        }
        pairArr[0] = TuplesKt.to(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, Integer.valueOf(i3));
        pairArr[1] = TuplesKt.to("dt_pgid", "pg_group_square_topic");
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        cVar.d(c16, "em_group_share_c2c", hashMapOf, this.page.getView());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void g(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("channelType", 3), TuplesKt.to("dt_pgid", "pg_group_square_topic"));
        cVar.d(c16, "em_share_item", hashMapOf, this.page.getView());
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void h(@NotNull ShareAction action) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        c cVar = c.f301578a;
        View c16 = action.c();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("channelType", 1), TuplesKt.to("dt_pgid", "pg_group_square_topic"));
        cVar.d(c16, "em_share_item", hashMapOf, this.page.getView());
    }

    public final void i(int channelType, @Nullable String targetId, @Nullable Integer idType, @Nullable Boolean success) {
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(channelType), targetId, idType, success);
            return;
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("channelType", Integer.valueOf(channelType));
        if (!Intrinsics.areEqual(success, Boolean.FALSE)) {
            if (Intrinsics.areEqual(success, Boolean.TRUE)) {
                i3 = 1;
            } else if (success == null) {
                i3 = 2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        pairArr[1] = TuplesKt.to("share_state", Integer.valueOf(i3));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (targetId != null && idType != null) {
            hashMapOf.put("target_id", targetId);
            hashMapOf.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, idType);
        }
        c.f301578a.f(null, "ev_group_square_share", hashMapOf);
    }
}
