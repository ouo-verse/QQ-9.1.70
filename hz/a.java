package hz;

import UserGrowth.stPopWindowItem;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.commonpopdialog.AbsWSPopDialogController;
import com.tencent.biz.pubaccount.weishi.commonpopdialog.WSPopDialogData;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.o;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import hz.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00072\u00020\u00012\u00020\u0002:\u00023\u0013B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0019\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0006\u0010\u0015\u001a\u00020\u0003R+\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lhz/a;", "Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/AbsWSPopDialogController;", "Lhz/c$b;", "", "p", "", "l", h.F, "", "intervalDays", "j", "(Ljava/lang/Integer;)Z", "", "LUserGrowth/stPopWindowItem;", "dialogMap", "f", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "verticalFragment", "o", "b", "onConfirm", "k", "", "<set-?>", "d", "Lhz/a$b;", "i", "()J", DomainData.DOMAIN_NAME, "(J)V", "lastShowTime", "Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/a;", "e", "Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/a;", "dialogData", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "getVerticalFragmentRef", "()Lmqq/util/WeakReference;", "setVerticalFragmentRef", "(Lmqq/util/WeakReference;)V", "verticalFragmentRef", "g", "Z", "getClickedFloatWindowBtn", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "clickedFloatWindowBtn", "<init>", "()V", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends AbsWSPopDialogController implements c.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final b lastShowTime = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WSPopDialogData dialogData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private WeakReference<WSVerticalPageFragment> verticalFragmentRef;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean clickedFloatWindowBtn;

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f406934i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "lastShowTime", "getLastShowTime()J", 0))};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\u0002J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0086\u0002R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lhz/a$b;", "", "Lhz/a;", "controller", "Lkotlin/reflect/KProperty;", "property", "", "a", "value", "", "b", "Ljava/lang/Long;", "lastShowTime", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
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
            long g16 = ai.g("last_show_time_float_window_dialog", 0L);
            this.lastShowTime = Long.valueOf(g16);
            return g16;
        }

        public final void b(a controller, KProperty<?> property, long value) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            Intrinsics.checkNotNullParameter(property, "property");
            this.lastShowTime = Long.valueOf(value);
            ai.o("last_show_time_float_window_dialog", value);
        }
    }

    private final boolean h() {
        if (xz.b.f449122a.c()) {
            WSPopDialogData wSPopDialogData = this.dialogData;
            if (j(wSPopDialogData != null ? Integer.valueOf(wSPopDialogData.getIntervalDays()) : null)) {
                return true;
            }
        }
        return false;
    }

    private final long i() {
        return this.lastShowTime.a(this, f406934i[0]);
    }

    private final void l() {
        WSVerticalPageFragment wSVerticalPageFragment;
        Context context = getContext();
        if (context != null) {
            c cVar = new c(context);
            cVar.d();
            cVar.f(this);
            cVar.show();
            n(o.a());
            com.tencent.biz.pubaccount.weishi.commonpopdialog.b.f80631a.c(2, 3);
            WeakReference<WSVerticalPageFragment> weakReference = this.verticalFragmentRef;
            if (weakReference == null || (wSVerticalPageFragment = weakReference.get()) == null) {
                return;
            }
            hz.b.c(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), wSVerticalPageFragment.Th(), wSVerticalPageFragment.getPresenter().h0());
        }
    }

    private final void n(long j3) {
        this.lastShowTime.b(this, f406934i[0], j3);
    }

    private final boolean p() {
        Map<Integer, stPopWindowItem> b16 = com.tencent.biz.pubaccount.weishi.commonpopdialog.b.f80631a.b();
        if (b16 == null) {
            return false;
        }
        stPopWindowItem stpopwindowitem = b16.get(2);
        int i3 = stpopwindowitem != null ? stpopwindowitem.interval : -1;
        String str = stpopwindowitem != null ? stpopwindowitem.text : null;
        if (str == null) {
            str = "";
        }
        WSPopDialogData wSPopDialogData = new WSPopDialogData(i3, str, stpopwindowitem != null ? stpopwindowitem.style : 1);
        this.dialogData = wSPopDialogData;
        x.j("WSFloatWindowDialogController", "[showDialog] intervalDays = " + wSPopDialogData.getIntervalDays() + ", tipsText = " + wSPopDialogData.getTipsText() + ", style = " + wSPopDialogData.getStyle());
        if (!h()) {
            return false;
        }
        l();
        return true;
    }

    @Override // hz.c.b
    public void b() {
        WSVerticalPageFragment wSVerticalPageFragment;
        WeakReference<WSVerticalPageFragment> weakReference = this.verticalFragmentRef;
        if (weakReference == null || (wSVerticalPageFragment = weakReference.get()) == null) {
            return;
        }
        wSVerticalPageFragment.getBaseActivity().doOnBackPressed();
        String from = wSVerticalPageFragment.getFrom();
        Intrinsics.checkNotNullExpressionValue(from, "from");
        String playScene = wSVerticalPageFragment.getPlayScene();
        Intrinsics.checkNotNullExpressionValue(playScene, "playScene");
        stSimpleMetaFeed currentFeedInfo = wSVerticalPageFragment.Th();
        Intrinsics.checkNotNullExpressionValue(currentFeedInfo, "currentFeedInfo");
        Map<String, String> h06 = wSVerticalPageFragment.getPresenter().h0();
        Intrinsics.checkNotNullExpressionValue(h06, "presenter.reportExtMap");
        hz.b.d(from, playScene, currentFeedInfo, h06);
    }

    @Override // com.tencent.biz.pubaccount.weishi.commonpopdialog.AbsWSPopDialogController
    public void f(Map<Integer, stPopWindowItem> dialogMap) {
        Intrinsics.checkNotNullParameter(dialogMap, "dialogMap");
    }

    public final boolean k() {
        if (this.clickedFloatWindowBtn) {
            this.clickedFloatWindowBtn = false;
            return false;
        }
        return p();
    }

    public final void m(boolean z16) {
        this.clickedFloatWindowBtn = z16;
    }

    public final void o(WSVerticalPageFragment verticalFragment) {
        Intrinsics.checkNotNullParameter(verticalFragment, "verticalFragment");
        this.verticalFragmentRef = new WeakReference<>(verticalFragment);
    }

    @Override // hz.c.b
    public void onConfirm() {
        WSVerticalPageFragment wSVerticalPageFragment;
        WeakReference<WSVerticalPageFragment> weakReference = this.verticalFragmentRef;
        if (weakReference == null || (wSVerticalPageFragment = weakReference.get()) == null) {
            return;
        }
        wSVerticalPageFragment.K3(false);
        String from = wSVerticalPageFragment.getFrom();
        Intrinsics.checkNotNullExpressionValue(from, "from");
        String playScene = wSVerticalPageFragment.getPlayScene();
        Intrinsics.checkNotNullExpressionValue(playScene, "playScene");
        stSimpleMetaFeed currentFeedInfo = wSVerticalPageFragment.Th();
        Intrinsics.checkNotNullExpressionValue(currentFeedInfo, "currentFeedInfo");
        Map<String, String> h06 = wSVerticalPageFragment.getPresenter().h0();
        Intrinsics.checkNotNullExpressionValue(h06, "presenter.reportExtMap");
        hz.b.b(from, playScene, currentFeedInfo, h06);
    }

    private final boolean j(Integer intervalDays) {
        int intValue = intervalDays != null ? intervalDays.intValue() : 0;
        return intValue > 0 && o.a() - i() >= o.b(intValue);
    }
}
