package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.render.player.IPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0017\u001a\u00020\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/p;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/a;", "", "v", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;", "player", "Lnu3/d;", "eventBean", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "w", "y", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "B", "Lnu3/c;", "f", "p", "", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "TAG", "<init>", "()V", "g", "a", "b", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "TavPlayerProxy@" + Integer.toHexString(hashCode());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/p$b;", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "", AdMetricTag.EVENT_NAME, "resultKey", "", "resultValue", "", "c", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/render/player/IPlayer;", "iPlayer", "a", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;", "player", "<init>", "(Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/p;Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b implements IPlayer.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final o player;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f347996b;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f347997a;

            static {
                int[] iArr = new int[IPlayer.PlayerStatus.values().length];
                try {
                    iArr[IPlayer.PlayerStatus.PLAYING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[IPlayer.PlayerStatus.PAUSED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f347997a = iArr;
            }
        }

        public b(p pVar, o player) {
            Intrinsics.checkNotNullParameter(player, "player");
            this.f347996b = pVar;
            this.player = player;
        }

        private final void c(String eventName, String resultKey, Object resultValue) {
            try {
                p.super.g("tav_play", com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.d(this.player, eventName, resultKey, resultValue));
            } catch (JSONException e16) {
                ee4.b.c(this.f347996b.getTAG(), "trySubscribe: ", e16);
            }
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void a(IPlayer.PlayerStatus status, IPlayer iPlayer) {
            String str;
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            int i3 = status == null ? -1 : a.f347997a[status.ordinal()];
            if (i3 == 1) {
                str = "play";
            } else if (i3 == 2) {
                str = "pause";
            } else if (status == null || (str = status.name()) == null) {
                str = "";
            }
            c("stateChange", "state", str);
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void b(IPlayer iPlayer) {
            IPlayer.a.C9881a.a(this, iPlayer);
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            JSONObject jSONObject;
            try {
                jSONObject = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.e(CMTime.fromUs(currentDurationUs));
            } catch (JSONException e16) {
                e16.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                return;
            }
            c("timeChange", "time", jSONObject);
        }
    }

    private final void A(o player, nu3.d eventBean) {
        Object f16 = eventBean.f("cutSession");
        if (!(f16 instanceof e)) {
            j("cutSession");
        } else {
            player.p(((e) f16).getCutSession(), false);
            m();
        }
    }

    private final void B(o player, nu3.d eventBean) {
        try {
            JSONObject param = eventBean.getParam();
            Boolean valueOf = param != null ? Boolean.valueOf(param.getBoolean("isLoopedPlay")) : null;
            if (valueOf == null) {
                i("setLoopPlay failed, parameter 'isLoopPlay' parse error");
            } else {
                player.n(valueOf.booleanValue());
                m();
            }
        } catch (JSONException e16) {
            i("setLoopedPlay failed - " + e16);
        }
    }

    private final void C(o player) {
        player.o();
        m();
    }

    private final void u(o player, nu3.d eventBean) {
        Object f16 = eventBean.f("videoView");
        if (!(f16 instanceof r)) {
            j("videoView");
        } else if (((r) f16).a(player)) {
            m();
        } else {
            i("view has be attach to another player, sorry");
        }
    }

    private final void v() {
        o oVar = new o();
        oVar.c(new b(this, oVar));
        k(oVar);
    }

    private final void w(o player) {
        Long e16 = player.e();
        JSONObject put = new JSONObject().put("duration", com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.e(CMTime.fromUs(e16 != null ? e16.longValue() : 0L)));
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject().put(DURATIO\u2026Time.fromUs(durationUs)))");
        n(put);
    }

    private final void x(o player) {
        player.i();
        m();
    }

    private final void y(o player) {
        player.j();
        m();
    }

    private final void z(o player, nu3.d eventBean) {
        try {
            JSONObject param = eventBean.getParam();
            JSONObject jSONObject = param != null ? param.getJSONObject("time") : null;
            if (jSONObject == null) {
                i("seek failed, parameter 'time' parse error");
            } else {
                player.m(com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.l(jSONObject));
                m();
            }
        } catch (JSONException e16) {
            i("seek failed - " + e16);
        }
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    /* renamed from: d, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void f(nu3.c eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.f(eventBean);
        v();
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void p(nu3.d eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.p(eventBean);
        Object targetObj = eventBean.getTargetObj();
        if (!(targetObj instanceof o)) {
            i("invoke func failed, target object 'player' cannot be found in object pool");
            return;
        }
        String methodName = eventBean.getMethodName();
        if (methodName != null) {
            switch (methodName.hashCode()) {
                case -1992012396:
                    if (methodName.equals("duration")) {
                        w((o) targetObj);
                        return;
                    }
                    return;
                case -840745386:
                    if (methodName.equals("unbind")) {
                        C((o) targetObj);
                        return;
                    }
                    return;
                case -75596549:
                    if (methodName.equals("attachVideoView")) {
                        u((o) targetObj, eventBean);
                        return;
                    }
                    return;
                case 3443508:
                    if (methodName.equals("play")) {
                        y((o) targetObj);
                        return;
                    }
                    return;
                case 3526264:
                    if (methodName.equals(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                        z((o) targetObj, eventBean);
                        return;
                    }
                    return;
                case 106440182:
                    if (methodName.equals("pause")) {
                        x((o) targetObj);
                        return;
                    }
                    return;
                case 1134817270:
                    if (methodName.equals("setCutSession")) {
                        A((o) targetObj, eventBean);
                        return;
                    }
                    return;
                case 1449780761:
                    if (methodName.equals("setLoopedPlay")) {
                        B((o) targetObj, eventBean);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
