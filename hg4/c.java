package hg4;

import ag4.i;
import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.l;
import ig4.f;
import ig4.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)JZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002JX\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002JH\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJH\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJP\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJV\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJ>\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJ>\u0010 \u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJ6\u0010\"\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fJ\u0016\u0010#\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\bJ \u0010'\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u000b\u00a8\u0006*"}, d2 = {"Lhg4/c;", "", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "authInfo", "", "yesGameId", "Lag4/i$a;", "cb", "", "autoShowAccountSelect", "isAllowChangeAccount", "Lag4/i$d;", "bindAccountCallback", "Landroid/app/Activity;", "context", "", "", "extraInfo", "", "g", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "desc", "o", "Landroid/content/DialogInterface;", "dialog", "e", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "accountList", "i", "callback", h.F, "r", "withHint", "d", "selectSmobaAccountCallback", "u", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a */
    @NotNull
    public static final c f404865a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"hg4/c$a", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> {

        /* renamed from: a */
        final /* synthetic */ DialogInterface f404866a;

        /* renamed from: b */
        final /* synthetic */ int f404867b;

        /* renamed from: c */
        final /* synthetic */ Activity f404868c;

        /* renamed from: d */
        final /* synthetic */ i.d f404869d;

        /* renamed from: e */
        final /* synthetic */ Map<String, String> f404870e;

        a(DialogInterface dialogInterface, int i3, Activity activity, i.d dVar, Map<String, String> map) {
            this.f404866a = dialogInterface;
            this.f404867b = i3;
            this.f404868c = activity;
            this.f404869d = dVar;
            this.f404870e = map;
        }

        @Override // ag4.i.b
        /* renamed from: a */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
            wf4.a.f445618a.b(this.f404866a);
            l.i("GameDialogUtils_", "result:" + result + ", errorCode:" + errorCode + ", errorMsg:" + errorMsg + ", rsp:" + rsp);
            if (result && rsp != null) {
                c.f404865a.i(this.f404867b, this.f404868c, rsp, this.f404869d, this.f404870e);
            } else {
                QQToast.makeText(this.f404868c, errorMsg, 0).show();
            }
            this.f404866a.dismiss();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"hg4/c$b", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> {

        /* renamed from: a */
        final /* synthetic */ boolean f404871a;

        /* renamed from: b */
        final /* synthetic */ i.d f404872b;

        /* renamed from: c */
        final /* synthetic */ int f404873c;

        /* renamed from: d */
        final /* synthetic */ Activity f404874d;

        /* renamed from: e */
        final /* synthetic */ Map<String, String> f404875e;

        b(boolean z16, i.d dVar, int i3, Activity activity, Map<String, String> map) {
            this.f404871a = z16;
            this.f404872b = dVar;
            this.f404873c = i3;
            this.f404874d = activity;
            this.f404875e = map;
        }

        @Override // ag4.i.b
        /* renamed from: a */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
            boolean z16 = false;
            if (rsp != null && cg4.b.a(rsp)) {
                z16 = true;
            }
            if (z16 && !this.f404871a) {
                i.d dVar = this.f404872b;
                if (dVar != null) {
                    dVar.a(rsp);
                    return;
                }
                return;
            }
            c.f404865a.h(this.f404873c, this.f404874d, this.f404872b, this.f404875e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"hg4/c$c", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hg4.c$c */
    /* loaded from: classes26.dex */
    public static final class C10435c implements i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> {

        /* renamed from: a */
        final /* synthetic */ Activity f404876a;

        /* renamed from: b */
        final /* synthetic */ int f404877b;

        /* renamed from: c */
        final /* synthetic */ i.d f404878c;

        /* renamed from: d */
        final /* synthetic */ Map<String, String> f404879d;

        C10435c(Activity activity, int i3, i.d dVar, Map<String, String> map) {
            this.f404876a = activity;
            this.f404877b = i3;
            this.f404878c = dVar;
            this.f404879d = map;
        }

        @Override // ag4.i.b
        /* renamed from: a */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
            wf4.a.f445618a.a(this.f404876a);
            if (result && rsp != null) {
                c.f404865a.i(this.f404877b, this.f404876a, rsp, this.f404878c, this.f404879d);
                return;
            }
            i.d dVar = this.f404878c;
            if (dVar != null) {
                dVar.e(errorCode, "Get list failed, " + errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"hg4/c$d", "Lag4/i$b;", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements i.b<GameAuthOuterClass$GetGameAuthRsp> {

        /* renamed from: a */
        final /* synthetic */ Activity f404880a;

        /* renamed from: b */
        final /* synthetic */ int f404881b;

        /* renamed from: c */
        final /* synthetic */ i.a f404882c;

        /* renamed from: d */
        final /* synthetic */ boolean f404883d;

        /* renamed from: e */
        final /* synthetic */ boolean f404884e;

        /* renamed from: f */
        final /* synthetic */ i.d f404885f;

        /* renamed from: g */
        final /* synthetic */ Map<String, String> f404886g;

        d(Activity activity, int i3, i.a aVar, boolean z16, boolean z17, i.d dVar, Map<String, String> map) {
            this.f404880a = activity;
            this.f404881b = i3;
            this.f404882c = aVar;
            this.f404883d = z16;
            this.f404884e = z17;
            this.f404885f = dVar;
            this.f404886g = map;
        }

        @Override // ag4.i.b
        /* renamed from: a */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable GameAuthOuterClass$GetGameAuthRsp rsp) {
            wf4.a.f445618a.a(this.f404880a);
            if (result && rsp != null) {
                c.f404865a.g(rsp, this.f404881b, this.f404882c, this.f404883d, this.f404884e, this.f404885f, this.f404880a, this.f404886g);
                return;
            }
            i.a aVar = this.f404882c;
            if (aVar != null) {
                aVar.d(errorCode, errorMsg);
            }
            l.e("GameDialogUtils_", "showAuthHintDialog auth info is empty!");
            QQToast.makeText(this.f404880a, "\u6388\u6743\u4fe1\u606f\u62c9\u53d6\u5931\u8d25\uff1a" + errorMsg, 0).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"hg4/c$e", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> {

        /* renamed from: a */
        final /* synthetic */ Activity f404887a;

        /* renamed from: b */
        final /* synthetic */ int f404888b;

        /* renamed from: c */
        final /* synthetic */ i.d f404889c;

        e(Activity activity, int i3, i.d dVar) {
            this.f404887a = activity;
            this.f404888b = i3;
            this.f404889c = dVar;
        }

        @Override // ag4.i.b
        /* renamed from: a */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
            wf4.a.f445618a.a(this.f404887a);
            if (result && rsp != null) {
                if (rsp.role_list.get().size() == 0) {
                    l.e("GameDialogUtils_", "showAccountBindDialog data.size == 0");
                    c.f404865a.r(this.f404888b, this.f404887a);
                    i.d dVar = this.f404889c;
                    if (dVar != null) {
                        dVar.e(-1, "account list is 0");
                        return;
                    }
                    return;
                }
                int i3 = this.f404888b;
                Activity activity = this.f404887a;
                List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list = rsp.role_list.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.role_list.get()");
                new f(i3, activity, list, this.f404889c, null, 16, null).show();
                return;
            }
            i.d dVar2 = this.f404889c;
            if (dVar2 != null) {
                dVar2.e(errorCode, errorMsg);
            }
            l.e("GameDialogUtils_", "showSwitchAccountDialog list is empty!, errorCode=" + errorCode + ", errorMsg:" + errorMsg);
            QQToast.makeText(this.f404887a, "\u5217\u8868\u62c9\u53d6\u5931\u8d25", 0).show();
        }
    }

    c() {
    }

    private final void f(int yesGameId, GameAuthOuterClass$GetGameAuthRsp authInfo, i.a cb5, boolean autoShowAccountSelect, boolean isAllowChangeAccount, i.d bindAccountCallback, Activity context, Map<String, String> extraInfo) {
        GameAuthOuterClass$AgreeGameAuthRsp gameAuthOuterClass$AgreeGameAuthRsp = new GameAuthOuterClass$AgreeGameAuthRsp();
        gameAuthOuterClass$AgreeGameAuthRsp.auth_desc.set(authInfo.auth_desc.get());
        gameAuthOuterClass$AgreeGameAuthRsp.is_auth.set(authInfo.is_auth.get());
        if (cb5 != null) {
            cb5.g(gameAuthOuterClass$AgreeGameAuthRsp);
        }
        if (!autoShowAccountSelect) {
            return;
        }
        GameCoreServiceImpl.INSTANCE.a().m2(yesGameId, new b(isAllowChangeAccount, bindAccountCallback, yesGameId, context, extraInfo));
    }

    public final void g(GameAuthOuterClass$GetGameAuthRsp authInfo, int yesGameId, i.a cb5, boolean autoShowAccountSelect, boolean isAllowChangeAccount, i.d bindAccountCallback, Activity context, Map<String, String> extraInfo) {
        if (authInfo.is_auth.get()) {
            f(yesGameId, authInfo, cb5, autoShowAccountSelect, isAllowChangeAccount, bindAccountCallback, context, extraInfo);
            return;
        }
        List<String> list = authInfo.auth_desc.get();
        Intrinsics.checkNotNullExpressionValue(list, "authInfo.auth_desc.get()");
        o(yesGameId, context, list, autoShowAccountSelect, cb5, bindAccountCallback, extraInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(c cVar, int i3, Activity activity, i.d dVar, Map map, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            map = new HashMap();
        }
        cVar.h(i3, activity, dVar, map);
    }

    public static /* synthetic */ void k(c cVar, int i3, Activity activity, YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp, i.d dVar, Map map, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            map = new HashMap();
        }
        cVar.i(i3, activity, yesGameInfoOuterClass$GetUserGameRoleListRsp, dVar, map);
    }

    public static /* synthetic */ void n(c cVar, int i3, Activity activity, boolean z16, i.a aVar, i.d dVar, Map map, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            map = new HashMap();
        }
        cVar.l(i3, activity, z16, aVar, dVar, map);
    }

    public static /* synthetic */ void p(c cVar, int i3, Activity activity, List list, boolean z16, i.a aVar, i.d dVar, Map map, int i16, Object obj) {
        Map map2;
        if ((i16 & 64) != 0) {
            map2 = new HashMap();
        } else {
            map2 = map;
        }
        cVar.o(i3, activity, list, z16, aVar, dVar, map2);
    }

    public static final void s(int i3, Activity context, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(context, "$context");
        ((i) mm4.b.b(i.class)).O2(i3, context);
    }

    public final boolean d(int yesGameId, boolean withHint) {
        boolean r26 = ((sm4.a) mm4.b.b(sm4.a.class)).r2(yesGameId);
        if (r26 && withHint) {
            QQToast.makeText(vf4.a.b(), R.string.yv6, 0).show();
        }
        return r26;
    }

    public final void e(int yesGameId, @NotNull Activity context, @NotNull DialogInterface dialog, @Nullable i.d bindAccountCallback, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        wf4.a.f445618a.e(dialog);
        ((i) mm4.b.b(i.class)).s3(yesGameId, new a(dialog, yesGameId, context, bindAccountCallback, extraInfo));
    }

    public final void h(int i3, @NotNull Activity context, @Nullable i.d dVar, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        wf4.a.f445618a.c(context);
        ((i) mm4.b.b(i.class)).s3(i3, new C10435c(context, i3, dVar, extraInfo));
    }

    public final void i(int yesGameId, @NotNull Activity context, @NotNull YesGameInfoOuterClass$GetUserGameRoleListRsp accountList, @Nullable i.d cb5, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountList, "accountList");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (d(yesGameId, true)) {
            if (cb5 != null) {
                cb5.e(-2, "\u6b63\u5728\u7ec4\u961f\u4e2d\uff0c\u65e0\u6cd5\u5207\u6362/\u7ed1\u5b9a\u89d2\u8272");
                return;
            }
            return;
        }
        List<YesGameInfoOuterClass$YesGameRoleAbsInfo> data = accountList.role_list.get();
        if (data.size() == 0) {
            l.e("GameDialogUtils_", "showAccountBindDialog data.size == 0");
            r(yesGameId, context);
            if (cb5 != null) {
                cb5.e(-1, "account list is 0");
                return;
            }
            return;
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        new f(yesGameId, context, data, cb5, extraInfo).show();
        if (cb5 != null) {
            cb5.c();
        }
    }

    public final void l(int yesGameId, @NotNull Activity context, boolean autoShowAccountSelect, @Nullable i.a cb5, @Nullable i.d bindAccountCallback, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        m(yesGameId, context, autoShowAccountSelect, false, cb5, bindAccountCallback, extraInfo);
    }

    public final void m(int i3, @NotNull Activity context, boolean z16, boolean z17, @Nullable i.a aVar, @Nullable i.d dVar, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        GameAuthOuterClass$GetGameAuthRsp value = GameCoreServiceImpl.INSTANCE.a().G0(i3).getValue();
        if (value != null) {
            g(value, i3, aVar, z16, z17, dVar, context, extraInfo);
            return;
        }
        wf4.a.f445618a.c(context);
        ((i) mm4.b.b(i.class)).I1(i3, new d(context, i3, aVar, z16, z17, dVar, extraInfo));
    }

    public final void o(int yesGameId, @NotNull Activity context, @NotNull List<String> desc, boolean autoShowAccountSelect, @Nullable i.a cb5, @Nullable i.d bindAccountCallback, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        new k(yesGameId, desc, autoShowAccountSelect, cb5, bindAccountCallback, context, extraInfo).show();
        if (cb5 != null) {
            cb5.c();
        }
    }

    public final void q(int i3, @NotNull Activity context, boolean z16, @Nullable i.a aVar, @Nullable i.d dVar, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        m(i3, context, z16, true, aVar, dVar, extraInfo);
    }

    public final void r(final int yesGameId, @NotNull final Activity context) {
        gh4.d dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        String X0 = ((ag4.h) mm4.b.b(ag4.h.class)).X0(yesGameId);
        com.tencent.timi.game.ui.widget.e c16 = new e.a(context).q("\u9700\u8981\u7ed1\u5b9a\u4f60\u7684\u9ed8\u8ba4" + X0 + "\u8d26\u53f7").j("\u4f60\u7684QQ\u8d26\u53f7\u6682\u65e0" + X0 + "\u89d2\u8272\u4fe1\u606f\uff0c\u53bb" + X0 + "\u521b\u5efa\u540e\u5f00\u9ed1\u4ea4\u53cb\u66f4\u4fbf\u6377").p("\u53bb\u521b\u5efa").o(new DialogInterface.OnClickListener() { // from class: hg4.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.s(yesGameId, context, dialogInterface, i3);
            }
        }).n("\u77e5\u9053\u4e86").m(new DialogInterface.OnClickListener() { // from class: hg4.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.t(dialogInterface, i3);
            }
        }).i(true).c();
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            dVar = I0.m0();
        } else {
            dVar = null;
        }
        if (dVar != null) {
            dVar.b(c16);
        }
        if (dVar != null) {
            dVar.a(c16.getNegativeButton(), dVar.f());
        }
        if (dVar != null) {
            dVar.a(c16.getPositiveButton(), dVar.g());
        }
        c16.show();
    }

    public final void u(int yesGameId, @NotNull Activity context, @Nullable i.d selectSmobaAccountCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (d(yesGameId, true)) {
            return;
        }
        wf4.a.f445618a.c(context);
        ((i) mm4.b.b(i.class)).s3(yesGameId, new e(context, yesGameId, selectSmobaAccountCallback));
    }

    public static final void t(DialogInterface dialogInterface, int i3) {
    }
}
