package fz;

import UserGrowth.stPopWindowItem;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.commonpopdialog.AbsWSPopDialogController;
import com.tencent.biz.pubaccount.weishi.commonpopdialog.WSPopDialogData;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.o;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import gz.c;
import gz.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002\u001b.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0019\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001c\u0010\u0019\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0006\u0010\u001a\u001a\u00020\u0003J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R+\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010)\u00a8\u0006/"}, d2 = {"Lfz/a;", "Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/AbsWSPopDialogController;", "Lgz/d$a;", "", "o", "Landroid/content/Context;", "context", "", "style", "Lgz/d;", "i", "(Landroid/content/Context;Ljava/lang/Integer;)Lgz/d;", "scene", "", h.F, "intervalDays", "k", "(Ljava/lang/Integer;)Z", "l", "(ILjava/lang/Integer;)Z", "needFetchData", "d", "", "LUserGrowth/stPopWindowItem;", "dialogMap", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "onCancel", "", "<set-?>", "Lfz/a$b;", "j", "()J", DomainData.DOMAIN_NAME, "(J)V", "lastShowTime", "Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/a;", "e", "Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/a;", "dialogData", "Z", "hasSlided", "<init>", "()V", "g", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends AbsWSPopDialogController implements d.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final b lastShowTime = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WSPopDialogData dialogData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasSlided;

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f400955h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "lastShowTime", "getLastShowTime()J", 0))};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\u0002J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0086\u0002R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lfz/a$b;", "", "Lfz/a;", "controller", "Lkotlin/reflect/KProperty;", "property", "", "a", "value", "", "b", "Ljava/lang/Long;", "lastShowTime", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Long lastShowTime;

        public final long a(a controller, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            Intrinsics.checkNotNullParameter(property, "property");
            Long l3 = this.lastShowTime;
            if (l3 != null) {
                return l3.longValue();
            }
            long g16 = ai.g("last_show_time_auth_friends_dialog", 0L);
            this.lastShowTime = Long.valueOf(g16);
            return g16;
        }

        public final void b(a controller, KProperty<?> property, long value) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            Intrinsics.checkNotNullParameter(property, "property");
            this.lastShowTime = Long.valueOf(value);
            ai.o("last_show_time_auth_friends_dialog", value);
        }
    }

    private final boolean h(int scene) {
        WSPopDialogData wSPopDialogData = this.dialogData;
        if (l(scene, wSPopDialogData != null ? Integer.valueOf(wSPopDialogData.getStyle()) : null)) {
            WSPopDialogData wSPopDialogData2 = this.dialogData;
            if (k(wSPopDialogData2 != null ? Integer.valueOf(wSPopDialogData2.getIntervalDays()) : null)) {
                return true;
            }
        }
        return false;
    }

    private final long j() {
        return this.lastShowTime.a(this, f400955h[0]);
    }

    private final void n(long j3) {
        this.lastShowTime.b(this, f400955h[0], j3);
    }

    private final void o() {
        x.j("WSAuthFriendsController", "show dialog.");
        Context context = getContext();
        if (context != null) {
            WSPopDialogData wSPopDialogData = this.dialogData;
            d i3 = i(context, wSPopDialogData != null ? Integer.valueOf(wSPopDialogData.getStyle()) : null);
            i3.e();
            i3.h(this);
            WSPopDialogData wSPopDialogData2 = this.dialogData;
            i3.i(wSPopDialogData2 != null ? wSPopDialogData2.getTipsText() : null);
            i3.show();
            n(o.a());
            fz.b.f400960a.d();
        }
    }

    @Override // gz.d.a
    public void a() {
        x.j("WSAuthFriendsController", "onAgree()");
        com.tencent.biz.pubaccount.weishi.commonpopdialog.b.f80631a.c(1, 1);
        fz.b.f400960a.c(true);
    }

    @Override // com.tencent.biz.pubaccount.weishi.commonpopdialog.AbsWSPopDialogController
    public void d(Context context, boolean needFetchData) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.d(context, needFetchData);
        x.j("WSAuthFriendsController", "lastShowTime = " + j());
    }

    @Override // com.tencent.biz.pubaccount.weishi.commonpopdialog.AbsWSPopDialogController
    public void f(Map<Integer, stPopWindowItem> dialogMap) {
        Intrinsics.checkNotNullParameter(dialogMap, "dialogMap");
        stPopWindowItem stpopwindowitem = dialogMap.get(1);
        int i3 = stpopwindowitem != null ? stpopwindowitem.interval : -1;
        String str = stpopwindowitem != null ? stpopwindowitem.text : null;
        if (str == null) {
            str = "";
        }
        WSPopDialogData wSPopDialogData = new WSPopDialogData(i3, str, stpopwindowitem != null ? stpopwindowitem.style : 1);
        this.dialogData = wSPopDialogData;
        x.j("WSAuthFriendsController", "[onSuccessPopWindowData] intervalDays = " + wSPopDialogData.getIntervalDays() + ", tipsText = " + wSPopDialogData.getTipsText() + ", style = " + wSPopDialogData.getStyle());
        if (h(1)) {
            o();
        }
    }

    public final void m() {
        if (this.hasSlided) {
            return;
        }
        this.hasSlided = true;
        if (!h(2)) {
            x.j("WSAuthFriendsController", "no showing dialog.");
        } else {
            o();
        }
    }

    @Override // gz.d.a
    public void onCancel() {
        x.j("WSAuthFriendsController", "onCancel()");
        com.tencent.biz.pubaccount.weishi.commonpopdialog.b.f80631a.c(1, 2);
        fz.b.f400960a.c(false);
    }

    private final d i(Context context, Integer style) {
        if (style != null && style.intValue() == 2) {
            return new c(context);
        }
        if (style != null && style.intValue() == 3) {
            return new gz.b(context);
        }
        return new gz.a(context);
    }

    private final boolean k(Integer intervalDays) {
        int intValue = intervalDays != null ? intervalDays.intValue() : 0;
        return intValue > 0 && o.a() - j() >= o.b(intValue);
    }

    private final boolean l(int scene, Integer style) {
        if (scene != 1) {
            if (scene != 2 || style == null || style.intValue() != 1) {
                return false;
            }
        } else if ((style == null || style.intValue() != 2) && (style == null || style.intValue() != 3)) {
            return false;
        }
        return true;
    }
}
