package gx2;

import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.event.ModuleEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import gx2.e;
import java.util.Arrays;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0002\u0017\u0016B\u001b\u0012\b\u0010&\u001a\u0004\u0018\u00010 \u0012\b\u0010-\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b.\u0010/J'\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0002J'\u0010\t\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\t\u0010\u0007J'\u0010\n\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\n\u0010\u0007J'\u0010\u000b\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u000b\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0002J'\u0010\r\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\r\u0010\u0007J'\u0010\u000e\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0007J'\u0010\u000f\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J'\u0010\u0014\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0007J'\u0010\u0015\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J'\u0010\u0019\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0007J'\u0010\u001a\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0002J'\u0010\u001c\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u0007J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lgx2/b;", "Lgx2/c;", "", "", "mParams", "", "t", "([Ljava/lang/Object;)V", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "c", "e", "p", "f", "v", "j", h.F, "i", "g", "o", "l", "b", "a", "r", "u", "k", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lgx2/e;", "event", "w", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;", "getMSession", "()Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;", "setMSession", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;)V", "mSession", "Lgx2/b$b;", "Lgx2/b$b;", "getMListener", "()Lgx2/b$b;", "setMListener", "(Lgx2/b$b;)V", "mListener", "<init>", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;Lgx2/b$b;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d mSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC10401b mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lgx2/b$b;", "", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: gx2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC10401b {
        void onDestroy();
    }

    public b(@Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar, @Nullable InterfaceC10401b interfaceC10401b) {
        this.mSession = dVar;
        this.mListener = interfaceC10401b;
    }

    private final void a() {
        RewardedAd ad5;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (ad5 = dVar.getAd()) != null) {
            ad5.e();
        }
        com.tencent.ams.xsad.rewarded.c.f().a();
        com.tencent.ams.xsad.rewarded.dynamic.a.e().a();
        InterfaceC10401b interfaceC10401b = this.mListener;
        if (interfaceC10401b != null) {
            interfaceC10401b.onDestroy();
        }
        this.mListener = null;
    }

    private final void b() {
        RewardedAd ad5;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (ad5 = dVar.getAd()) != null) {
            ad5.o();
        }
    }

    private final void c(Object... mParams) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && (mParams[0] instanceof RewardedAdListener.ClickInfo) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.Ab((RewardedAdListener.ClickInfo) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ams.xsad.rewarded.RewardedAdListener.ClickInfo");
        }
    }

    private final void d(Object... mParams) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && (mParams[0] instanceof Long) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.jb(((Long) obj).longValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    private final void e() {
        RewardedAdListener listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (listener = dVar.getListener()) != null) {
            listener.a5();
        }
    }

    private final void f(Object... mParams) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && (mParams[0] instanceof com.tencent.ams.xsad.rewarded.view.a) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.S7((com.tencent.ams.xsad.rewarded.view.a) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ams.xsad.rewarded.view.CloseTipDialog");
        }
    }

    private final void g() {
        RewardedAdListener listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (listener = dVar.getListener()) != null) {
            listener.onAdPlayComplete();
        }
    }

    private final void h() {
        RewardedAdListener listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (listener = dVar.getListener()) != null) {
            listener.onAdPlayPause();
        }
    }

    private final void i() {
        RewardedAdListener listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (listener = dVar.getListener()) != null) {
            listener.onAdPlayResume();
        }
    }

    private final void j() {
        RewardedAdListener listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (listener = dVar.getListener()) != null) {
            listener.onAdPlayStart();
        }
    }

    private final void k(Object... mParams) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        String str;
        RewardedAdData g16;
        if (mParams.length == 1 && (mParams[0] instanceof RewardedAdListener.b) && (dVar = this.mSession) != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleAdRefresh, session hashcode = ");
            sb5.append(dVar);
            sb5.append(", data = ");
            RewardedAd ad5 = dVar.getAd();
            RewardedAdData rewardedAdData = null;
            if (ad5 != null && (g16 = ad5.g()) != null) {
                str = g16.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            n.e("[RewardAd]QAdRewardEventHandler", sb5.toString());
            RewardedAdListener.b bVar = (RewardedAdListener.b) mParams[0];
            RewardedAdListener.a aVar = new RewardedAdListener.a();
            RewardedAd ad6 = dVar.getAd();
            if (ad6 != null) {
                rewardedAdData = ad6.g();
            }
            aVar.f71724b = rewardedAdData;
            if (bVar != null) {
                bVar.a(aVar);
            }
        }
    }

    private final void l(Object... mParams) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && (mParams[0] instanceof Boolean) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.J1(((Boolean) obj).booleanValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
    }

    private final void m(Object... mParams) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && (mParams[0] instanceof RewardedAdError) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.L7((RewardedAdError) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ams.xsad.rewarded.RewardedAdError");
        }
    }

    private final void n() {
        RewardedAdListener listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (listener = dVar.getListener()) != null) {
            listener.we();
        }
    }

    private final void o(Object... mParams) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && (mParams[0] instanceof Integer) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.Od(((Integer) obj).intValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private final void p(Object... mParams) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length >= 2 && (mParams[0] instanceof com.tencent.ams.xsad.rewarded.view.a) && (mParams[1] instanceof Boolean) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                com.tencent.ams.xsad.rewarded.view.a aVar = (com.tencent.ams.xsad.rewarded.view.a) obj;
                Object obj2 = mParams[1];
                if (obj2 != null) {
                    listener.gb(aVar, ((Boolean) obj2).booleanValue());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ams.xsad.rewarded.view.CloseTipDialog");
        }
    }

    private final void q(Object... mParams) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 1 && (mParams[0] instanceof ModuleEvent) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.K6((ModuleEvent) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ams.xsad.rewarded.event.ModuleEvent");
        }
    }

    private final void r() {
        RewardedAdListener listener;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (listener = dVar.getListener()) != null) {
            listener.onOriginalExposure();
        }
    }

    private final void t(Object... mParams) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        if (mParams.length >= 2 && (mParams[0] instanceof Activity) && (mParams[1] instanceof RewardedAdListener) && (dVar = this.mSession) != null) {
            n.e("[RewardAd]QAdRewardEventHandler", "handleStartAd, session hashcode = " + dVar);
            RewardedAd ad5 = dVar.getAd();
            if (ad5 != null) {
                Object obj = mParams[0];
                if (obj != null) {
                    Activity activity = (Activity) obj;
                    Object obj2 = mParams[1];
                    if (obj2 != null) {
                        ad5.q(activity, (RewardedAdListener) obj2, dVar.getMaxUnlockTime());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.ams.xsad.rewarded.RewardedAdListener");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    private final void u(Object... mParams) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length >= 2 && (mParams[0] instanceof Integer) && (mParams[1] instanceof RewardedAdListener.b) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.m6(((Integer) obj).intValue(), (RewardedAdListener.b) mParams[1]);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private final void v(Object... mParams) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAdListener listener;
        if (mParams.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && (mParams[0] instanceof com.tencent.ams.xsad.rewarded.b) && (dVar = this.mSession) != null && (listener = dVar.getListener()) != null) {
            Object obj = mParams[0];
            if (obj != null) {
                listener.yg((com.tencent.ams.xsad.rewarded.b) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ams.xsad.rewarded.RewardItem");
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.b
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onEvent(@Nullable e event) {
        if (event != null) {
            int eventKey = event.getEventKey();
            e.Companion companion = e.INSTANCE;
            if (eventKey == companion.v()) {
                Object[] mParams = event.getMParams();
                t(Arrays.copyOf(mParams, mParams.length));
                return;
            }
            if (eventKey == companion.o()) {
                n();
                return;
            }
            if (eventKey == companion.n()) {
                Object[] mParams2 = event.getMParams();
                m(Arrays.copyOf(mParams2, mParams2.length));
                return;
            }
            if (eventKey == companion.b()) {
                Object[] mParams3 = event.getMParams();
                c(Arrays.copyOf(mParams3, mParams3.length));
                return;
            }
            if (eventKey == companion.c()) {
                Object[] mParams4 = event.getMParams();
                d(Arrays.copyOf(mParams4, mParams4.length));
                return;
            }
            if (eventKey == companion.d()) {
                e();
                return;
            }
            if (eventKey == companion.e()) {
                Object[] mParams5 = event.getMParams();
                p(Arrays.copyOf(mParams5, mParams5.length));
                return;
            }
            if (eventKey == companion.f()) {
                Object[] mParams6 = event.getMParams();
                f(Arrays.copyOf(mParams6, mParams6.length));
                return;
            }
            if (eventKey == companion.l()) {
                j();
                return;
            }
            if (eventKey == companion.j()) {
                h();
                return;
            }
            if (eventKey == companion.k()) {
                i();
                return;
            }
            if (eventKey == companion.i()) {
                g();
                return;
            }
            if (eventKey == companion.q()) {
                Object[] mParams7 = event.getMParams();
                o(Arrays.copyOf(mParams7, mParams7.length));
                return;
            }
            if (eventKey == companion.s()) {
                Object[] mParams8 = event.getMParams();
                l(Arrays.copyOf(mParams8, mParams8.length));
                return;
            }
            if (eventKey == companion.t()) {
                b();
                return;
            }
            if (eventKey == companion.r()) {
                Object[] mParams9 = event.getMParams();
                v(Arrays.copyOf(mParams9, mParams9.length));
                return;
            }
            if (eventKey == companion.a()) {
                a();
                return;
            }
            if (eventKey == companion.u()) {
                r();
                return;
            }
            if (eventKey == companion.p()) {
                Object[] mParams10 = event.getMParams();
                u(Arrays.copyOf(mParams10, mParams10.length));
                return;
            }
            if (eventKey == companion.m()) {
                Object[] mParams11 = event.getMParams();
                k(Arrays.copyOf(mParams11, mParams11.length));
            } else if (eventKey == companion.h()) {
                Object[] mParams12 = event.getMParams();
                q(Arrays.copyOf(mParams12, mParams12.length));
            } else if (eventKey == companion.g()) {
                s();
            }
        }
    }

    private final void s() {
    }
}
