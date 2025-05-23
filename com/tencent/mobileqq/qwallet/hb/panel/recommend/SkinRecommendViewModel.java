package com.tencent.mobileqq.qwallet.hb.panel.recommend;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.hb.panel.m;
import com.tencent.mobileqq.qwallet.pb.MidasOrder$SsoMakeOrderReq;
import com.tencent.mobileqq.qwallet.pb.MidasOrder$SsoMakeOrderRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetRecommendSkinsReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetRecommendSkinsRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Promotion;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SsoAddSkinReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SsoAddSkinRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mobileqq.qwallet.pb.a;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import cooperation.qwallet.plugin.IPayLogic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\u0007\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0002J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u0014\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J*\u0010\u001a\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J2\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0002J2\u0010!\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2 \u0010 \u001a\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00050\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\bH\u0002J&\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00102\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007J\u0014\u0010)\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&J\u0006\u0010*\u001a\u00020\u0005J\b\u0010+\u001a\u00020\u0005H\u0007J\u0006\u0010,\u001a\u00020\u0005J\"\u0010/\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u00100\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010Jg\u00106\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102O\u00105\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u00050\u001fR$\u0010<\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR/\u0010I\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0D0C8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR$\u0010L\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bJ\u00109\u001a\u0004\bK\u0010;RE\u0010T\u001a%\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\u0007\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u00109R\"\u0010]\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetRecommendSkinsRsp;", "rsp", "", "c2", "Lkotlin/Function1;", "", "callback", "b2", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", SkinResFactory.SKIN_THEME_APK_SAVE_DIR, "Q1", "", "skinId", "url", "", "g2", SemanticAttributes.DbSystemValues.H2, "j2", "invokeId", "Landroid/os/Bundle;", "payData", ICustomDataEditor.STRING_PARAM_2, "i2", "skinToken", "Lkotlin/Function2;", "l2", "Lkotlin/Function3;", "bizCallback", "e2", "paUin", "S1", WadlProxyConsts.SCENE_ID, "m2", "", "Lcom/tencent/mobileqq/qwallet/pb/a;", IQWalletPreferenceApi.KEY_SKIN_LIST, "t2", "R1", "onResume", "f2", "Lcom/tencent/mobileqq/qwallet/hb/panel/b;", "recommendSkinHost", ICustomDataEditor.STRING_ARRAY_PARAM_2, "k2", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", "rspCallback", "o2", "<set-?>", "i", "I", "U1", "()I", "displayType", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "Z1", "()Landroidx/lifecycle/MutableLiveData;", "sortOnceSkins", "Landroidx/lifecycle/MediatorLiveData;", "Lkotlin/Pair;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MediatorLiveData;", "X1", "()Landroidx/lifecycle/MediatorLiveData;", "sortAlwaysSkins", "D", "W1", "jumpType", "Lmqq/util/WeakReference;", "E", "Lmqq/util/WeakReference;", "getRefreshSkinVMCallback", "()Lmqq/util/WeakReference;", "q2", "(Lmqq/util/WeakReference;)V", "refreshSkinVMCallback", UserInfo.SEX_FEMALE, "channelReceivingSkin", "G", "Z", "d2", "()Z", "p2", "(Z)V", "isGotSkin", "<init>", "()V", "H", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class SkinRecommendViewModel extends ViewModel implements LifecycleObserver {

    @NotNull
    private static final String I = "qq_m_qq-2013-android-" + AppSetting.f() + "-qwallet";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Pair<Integer, List<com.tencent.mobileqq.qwallet.pb.a>>> sortAlwaysSkins;

    /* renamed from: D, reason: from kotlin metadata */
    private int jumpType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WeakReference<Function1<Integer, Unit>> refreshSkinVMCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private int channelReceivingSkin;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isGotSkin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int displayType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> sortOnceSkins;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277610d;

        public b(o oVar) {
            this.f277610d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) MidasOrder$SsoMakeOrderRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277610d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + MidasOrder$SsoMakeOrderRsp.class + " failed.");
                    o oVar2 = this.f277610d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277610d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/MidasOrder$SsoMakeOrderRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements o<MidasOrder$SsoMakeOrderRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, Bundle, Unit> f277611a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f277612b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Boolean, ? super Integer, ? super Bundle, Unit> function3, int i3) {
            this.f277611a = function3;
            this.f277612b = i3;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull MidasOrder$SsoMakeOrderRsp rsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            String tokenUrl = rsp.url_params.get();
            Intrinsics.checkNotNullExpressionValue(tokenUrl, "tokenUrl");
            if (tokenUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("offerId", "1450042281");
                jSONObject.put("userId", com.tencent.mobileqq.base.a.c());
                jSONObject.put("saveValue", "1");
                jSONObject.put("isCanChange", false);
                jSONObject.put("aid", "qwallet");
                jSONObject.put("tokenUrl", tokenUrl);
                jSONObject.put("numberVisible", false);
                Bundle bundle = new Bundle();
                bundle.putString("callbackSn", "callbackSn");
                bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, jSONObject.toString());
                bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 5);
                this.f277611a.invoke(Boolean.TRUE, Integer.valueOf(this.f277612b), bundle);
                return;
            }
            QLog.w("SkinRecommendViewModel", 1, "onSuccess: token url is empty");
            this.f277611a.invoke(Boolean.FALSE, Integer.valueOf(this.f277612b), null);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("SkinRecommendViewModel", 1, "makeBuySkinOrder onFail: " + errMsg);
            this.f277611a.invoke(Boolean.FALSE, Integer.valueOf(this.f277612b), null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277613d;

        public d(o oVar) {
            this.f277613d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$SsoAddSkinRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277613d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$SsoAddSkinRsp.class + " failed.");
                    o oVar2 = this.f277613d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277613d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel$e", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$SsoAddSkinRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements o<RedPackSkin$SsoAddSkinRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f277614a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f277614a = function2;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$SsoAddSkinRsp rsp) {
            boolean z16;
            String str;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (rsp.code.get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Function2<Boolean, String, Unit> function2 = this.f277614a;
            Boolean valueOf = Boolean.valueOf(z16);
            if (z16) {
                str = "\u9886\u53d6\u6210\u529f";
            } else {
                str = "\u9886\u53d6\u5931\u8d25";
            }
            function2.invoke(valueOf, str);
            QLog.d("SkinRecommendViewModel", 2, "requestAddSkin onSuccess: code " + rsp.code.get() + ", msg, " + rsp.f278707msg.get());
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f277614a.invoke(Boolean.FALSE, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            QLog.d("SkinRecommendViewModel", 1, "requestAddSkin onFail: " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277615d;

        public f(o oVar) {
            this.f277615d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$GetRecommendSkinsRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277615d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$GetRecommendSkinsRsp.class + " failed.");
                    o oVar2 = this.f277615d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277615d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel$g", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetRecommendSkinsRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class g implements o<RedPackSkin$GetRecommendSkinsRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<RedPackSkin$GetRecommendSkinsRsp, Integer, String, Unit> f277616a;

        /* JADX WARN: Multi-variable type inference failed */
        g(Function3<? super RedPackSkin$GetRecommendSkinsRsp, ? super Integer, ? super String, Unit> function3) {
            this.f277616a = function3;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$GetRecommendSkinsRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            this.f277616a.invoke(rsp, 0, null);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f277616a.invoke(null, Integer.valueOf(errCode), errMsg);
            QLog.w("SkinRecommendViewModel", 1, "requestRecommendSkin onFail: " + errMsg);
        }
    }

    public SkinRecommendViewModel() {
        MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> mutableLiveData = new MutableLiveData<>();
        this.sortOnceSkins = mutableLiveData;
        final MediatorLiveData<Pair<Integer, List<com.tencent.mobileqq.qwallet.pb.a>>> mediatorLiveData = new MediatorLiveData<>();
        final Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel$sortAlwaysSkins$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.qwallet.pb.a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.mobileqq.qwallet.pb.a> rawList) {
                List sorted;
                MediatorLiveData<Pair<Integer, List<com.tencent.mobileqq.qwallet.pb.a>>> mediatorLiveData2 = mediatorLiveData;
                Integer valueOf = Integer.valueOf(this.getDisplayType());
                Intrinsics.checkNotNullExpressionValue(rawList, "rawList");
                sorted = CollectionsKt___CollectionsKt.sorted(rawList);
                mediatorLiveData2.setValue(new Pair<>(valueOf, sorted));
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SkinRecommendViewModel.r2(Function1.this, obj);
            }
        });
        this.sortAlwaysSkins = mediatorLiveData;
        this.channelReceivingSkin = -1;
    }

    private final void Q1(Context context, final RedPackSkin$RecommendSkin skin) {
        final Dialog i3 = m.f277567a.i(context);
        int f16 = RedPackSkinExt.f(skin);
        String str = skin.token.get();
        Intrinsics.checkNotNullExpressionValue(str, "skin.token.get()");
        l2(f16, str, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel$addSkinDirectly$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                invoke(bool.booleanValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull String toastMsg) {
                Intrinsics.checkNotNullParameter(toastMsg, "toastMsg");
                Dialog dialog = i3;
                if (dialog != null) {
                    dialog.dismiss();
                }
                QQToast.makeText(BaseApplication.context, z16 ? 2 : 0, toastMsg, 0).show();
                if (z16) {
                    this.k2(RedPackSkinExt.f(skin), 0);
                }
            }
        });
    }

    private final void S1(final String paUin) {
        boolean z16;
        if (paUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.c
            @Override // java.lang.Runnable
            public final void run() {
                SkinRecommendViewModel.T1(paUin);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(String paUin) {
        Intrinsics.checkNotNullParameter(paUin, "$paUin");
        try {
            ((INewQWalletApi) QRoute.apiIPCSync(INewQWalletApi.class)).ipcFollowUin(paUin, true);
        } catch (Exception e16) {
            QLog.e("SkinRecommendViewModel", 1, "followPA: paUin " + paUin, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(RedPackSkin$GetRecommendSkinsRsp rsp, Function1<? super String, Unit> callback) {
        this.jumpType = rsp.jump_type.get();
        List<RedPackSkin$RecommendSkin> skinList = rsp.skins.get();
        Intrinsics.checkNotNullExpressionValue(skinList, "skinList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : skinList) {
            if (!((RedPackSkin$RecommendSkin) obj).has_got.get()) {
                arrayList.add(obj);
            }
        }
        this.sortOnceSkins.postValue(com.tencent.mobileqq.qwallet.pb.a.INSTANCE.c(arrayList));
        String redDotText = rsp.skins_page_reddot.reminder_text.get();
        if (callback != null) {
            Intrinsics.checkNotNullExpressionValue(redDotText, "redDotText");
            callback.invoke(redDotText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(RedPackSkin$GetRecommendSkinsRsp rsp) {
        this.jumpType = rsp.jump_type.get();
        List<RedPackSkin$RecommendSkin> list = rsp.skins.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.skins.get()");
        List<RedPackSkin$RecommendSkin> g16 = RedPackSkinExt.g(list);
        int i3 = rsp.display_type.get();
        this.displayType = i3;
        if (i3 == 1 && (!g16.isEmpty())) {
            g16 = g16.subList(0, 1);
        }
        List<RedPackSkin$Promotion> promotions = rsp.promotions.get();
        MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> mutableLiveData = this.sortOnceSkins;
        a.Companion companion = com.tencent.mobileqq.qwallet.pb.a.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(promotions, "promotions");
        mutableLiveData.postValue(companion.a(promotions, g16));
    }

    private final void e2(RedPackSkin$RecommendSkin skin, Function3<? super Boolean, ? super Integer, ? super Bundle, Unit> bizCallback) {
        MidasOrder$SsoMakeOrderReq midasOrder$SsoMakeOrderReq = new MidasOrder$SsoMakeOrderReq();
        midasOrder$SsoMakeOrderReq.product_id.set(String.valueOf(RedPackSkinExt.f(skin)));
        midasOrder$SsoMakeOrderReq.provide_offer_id.set("800001810");
        midasOrder$SsoMakeOrderReq.offer_id.set("1450042281");
        midasOrder$SsoMakeOrderReq.quantity.set(1);
        midasOrder$SsoMakeOrderReq.selling_price.set(skin.skin.price.get());
        midasOrder$SsoMakeOrderReq.f278697pf.set(I);
        midasOrder$SsoMakeOrderReq.pf_key.set("pfkey");
        c cVar = new c(bizCallback, 7);
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.midas_order.Order.SsoMakeOrder callback: " + cVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.midas_order.Order.SsoMakeOrder");
        newIntent.putExtra("data", fh.b(midasOrder$SsoMakeOrderReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new b(cVar));
        waitAppRuntime.startServlet(newIntent);
    }

    private final boolean g2(Context context, int skinId, String url) {
        boolean z16;
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || this.channelReceivingSkin != -1) {
            return false;
        }
        this.channelReceivingSkin = skinId;
        return k.h(context, url);
    }

    private final void h2(Context context, RedPackSkin$RecommendSkin skin) {
        boolean z16;
        String paUin = skin.public_account_uin.get();
        Intrinsics.checkNotNullExpressionValue(paUin, "paUin");
        if (paUin.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            S1(paUin);
        }
        j2(context, skin);
    }

    private final void i2(final Context context, final RedPackSkin$RecommendSkin skin) {
        final Dialog i3 = m.f277567a.i(context);
        e2(skin, new Function3<Boolean, Integer, Bundle, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel$receiveSkinByPayment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, Bundle bundle) {
                invoke(bool.booleanValue(), num.intValue(), bundle);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i16, @Nullable Bundle bundle) {
                Dialog dialog = i3;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (z16 && bundle != null) {
                    this.s2(context, RedPackSkinExt.f(skin), i16, bundle);
                } else {
                    QQToast.makeText(context, "\u4e0b\u5355\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                }
            }
        });
    }

    private final void j2(Context context, RedPackSkin$RecommendSkin skin) {
        boolean startsWith$default;
        String url = skin.btn_url.get();
        QLog.i("SkinRecommendViewModel", 1, "receiveSkinByUrl: skinId " + RedPackSkinExt.f(skin) + " url=" + url);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "redpackskin://pay", false, 2, null);
        if (startsWith$default) {
            i2(context, skin);
        } else {
            if (g2(context, RedPackSkinExt.f(skin), url)) {
                return;
            }
            Q1(context, skin);
        }
    }

    private final void l2(int skinId, String skinToken, Function2<? super Boolean, ? super String, Unit> callback) {
        QLog.d("SkinRecommendViewModel", 2, "requestAddSkin: skinId " + skinId);
        RedPackSkin$SsoAddSkinReq redPackSkin$SsoAddSkinReq = new RedPackSkin$SsoAddSkinReq();
        redPackSkin$SsoAddSkinReq.skin_id.set(skinId);
        redPackSkin$SsoAddSkinReq.token.set(skinToken);
        redPackSkin$SsoAddSkinReq.timestamp.set(NetConnInfoCenter.getServerTime());
        e eVar = new e(callback);
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoAddSkin callback: " + eVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoAddSkin");
        newIntent.putExtra("data", fh.b(redPackSkin$SsoAddSkinReq.toByteArray()));
        newIntent.putExtra("timeout", 10000L);
        newIntent.setObserver(new d(eVar));
        waitAppRuntime.startServlet(newIntent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n2(SkinRecommendViewModel skinRecommendViewModel, int i3, Function1 function1, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                function1 = null;
            }
            skinRecommendViewModel.m2(i3, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestAllRecommendSkins");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(Context context, final int skinId, int invokeId, Bundle payData) {
        Activity activity;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        Activity activity2 = activity;
        final Handler handler = new Handler(Looper.getMainLooper());
        ((IPayLogic) QRoute.api(IPayLogic.class)).newPay(peekAppRuntime, activity2, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel$startMidasPay$payCallback$1
            /* JADX WARN: Code restructure failed: missing block: B:4:0x003f, code lost:
            
                if (new org.json.JSONObject(r7.getString("result", "")).getInt(cooperation.qzone.QzoneIPCModule.RESULT_CODE) == 0) goto L9;
             */
            @Override // android.os.ResultReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                boolean z16 = true;
                QLog.d("SkinRecommendViewModel", 1, "onReceiveResult: resultCode " + resultCode + ", resultData " + resultData);
                try {
                } catch (JSONException e16) {
                    QLog.e("SkinRecommendViewModel", 1, "startMidasPay onReceiveResult: ", e16);
                }
                z16 = false;
                if (z16) {
                    SkinRecommendViewModel.this.k2(skinId, 0);
                } else {
                    QQToast.makeText(BaseApplication.context, "\u652f\u4ed8\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                }
            }
        }, invokeId, payData);
    }

    public final void R1() {
        List<com.tencent.mobileqq.qwallet.pb.a> emptyList;
        MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> mutableLiveData = this.sortOnceSkins;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(emptyList);
    }

    /* renamed from: U1, reason: from getter */
    public final int getDisplayType() {
        return this.displayType;
    }

    /* renamed from: W1, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final MediatorLiveData<Pair<Integer, List<com.tencent.mobileqq.qwallet.pb.a>>> X1() {
        return this.sortAlwaysSkins;
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> Z1() {
        return this.sortOnceSkins;
    }

    public final void a2(@Nullable Context context, @Nullable com.tencent.mobileqq.qwallet.hb.panel.b recommendSkinHost, @NotNull RedPackSkin$RecommendSkin skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        if (skin.has_got.get()) {
            if (recommendSkinHost != null) {
                recommendSkinHost.Q5(RedPackSkinExt.f(skin));
                return;
            } else {
                zk2.a.f452709a.b(RedPackSkinExt.f(skin), context);
                return;
            }
        }
        int i3 = skin.receive_way.get();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            j2(context, skin);
                            return;
                        } else {
                            h2(context, skin);
                            return;
                        }
                    }
                    i2(context, skin);
                    return;
                }
                int f16 = RedPackSkinExt.f(skin);
                String str = skin.btn_url.get();
                Intrinsics.checkNotNullExpressionValue(str, "skin.btn_url.get()");
                g2(context, f16, str);
                return;
            }
            Q1(context, skin);
            return;
        }
        if (recommendSkinHost != null) {
            recommendSkinHost.Q5(RedPackSkinExt.f(skin));
        }
    }

    /* renamed from: d2, reason: from getter */
    public final boolean getIsGotSkin() {
        return this.isGotSkin;
    }

    public final void f2() {
        this.channelReceivingSkin = -1;
    }

    public final void k2(final int skinId, int sceneId) {
        Object obj;
        RedPackSkin$RecommendSkin value;
        PBBoolField pBBoolField;
        Object obj2;
        boolean z16;
        Function1<Integer, Unit> function1;
        WeakReference<Function1<Integer, Unit>> weakReference = this.refreshSkinVMCallback;
        if (weakReference != null && (function1 = weakReference.get()) != null) {
            function1.invoke(Integer.valueOf(skinId));
        }
        List<com.tencent.mobileqq.qwallet.pb.a> value2 = this.sortOnceSkins.getValue();
        final boolean z17 = false;
        a.Skin skin = null;
        if (value2 != null) {
            Iterator<T> it = value2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    com.tencent.mobileqq.qwallet.pb.a aVar = (com.tencent.mobileqq.qwallet.pb.a) obj2;
                    if ((aVar instanceof a.Skin) && RedPackSkinExt.f(((a.Skin) aVar).getValue()) == skinId) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            obj = (com.tencent.mobileqq.qwallet.pb.a) obj2;
        } else {
            obj = null;
        }
        if (obj instanceof a.Skin) {
            skin = (a.Skin) obj;
        }
        if (skin != null && (value = skin.getValue()) != null && (pBBoolField = value.has_got) != null) {
            z17 = pBBoolField.get();
        }
        QLog.d("SkinRecommendViewModel", 2, "refreshSkinInfo: skinId " + skinId);
        o2(skinId, sceneId, new Function3<RedPackSkin$GetRecommendSkinsRsp, Integer, String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel$refreshSkinInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RedPackSkin$GetRecommendSkinsRsp redPackSkin$GetRecommendSkinsRsp, Integer num, String str) {
                invoke(redPackSkin$GetRecommendSkinsRsp, num.intValue(), str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
            
                r13 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r13);
             */
            /* JADX WARN: Removed duplicated region for block: B:28:0x009e A[LOOP:1: B:20:0x0070->B:28:0x009e, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00a2 A[EDGE_INSN: B:29:0x00a2->B:30:0x00a2 BREAK  A[LOOP:1: B:20:0x0070->B:28:0x009e], SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(@Nullable RedPackSkin$GetRecommendSkinsRsp redPackSkin$GetRecommendSkinsRsp, int i3, @Nullable String str) {
                List<com.tencent.mobileqq.qwallet.pb.a> arrayList;
                PBRepeatMessageField<RedPackSkin$RecommendSkin> pBRepeatMessageField;
                List<RedPackSkin$RecommendSkin> list;
                boolean z18;
                PBRepeatMessageField<RedPackSkin$RecommendSkin> pBRepeatMessageField2;
                List<RedPackSkin$RecommendSkin> list2;
                QLog.d("SkinRecommendViewModel", 2, "refreshSkinInfo: callback skinId " + ((redPackSkin$GetRecommendSkinsRsp == null || (pBRepeatMessageField2 = redPackSkin$GetRecommendSkinsRsp.skins) == null || (list2 = pBRepeatMessageField2.get()) == null) ? null : RedPackSkinExt.b(list2)));
                List<com.tencent.mobileqq.qwallet.pb.a> value3 = SkinRecommendViewModel.this.Z1().getValue();
                if (value3 == null || arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (redPackSkin$GetRecommendSkinsRsp != null && (pBRepeatMessageField = redPackSkin$GetRecommendSkinsRsp.skins) != null && (list = pBRepeatMessageField.get()) != null) {
                    int i16 = skinId;
                    boolean z19 = z17;
                    SkinRecommendViewModel skinRecommendViewModel = SkinRecommendViewModel.this;
                    for (RedPackSkin$RecommendSkin item : list) {
                        Iterator<com.tencent.mobileqq.qwallet.pb.a> it5 = arrayList.iterator();
                        int i17 = 0;
                        while (true) {
                            if (!it5.hasNext()) {
                                i17 = -1;
                                break;
                            }
                            com.tencent.mobileqq.qwallet.pb.a next = it5.next();
                            if (next instanceof a.Skin) {
                                int f16 = RedPackSkinExt.f(((a.Skin) next).getValue());
                                Intrinsics.checkNotNullExpressionValue(item, "item");
                                if (f16 == RedPackSkinExt.f(item)) {
                                    z18 = true;
                                    if (!z18) {
                                        break;
                                    } else {
                                        i17++;
                                    }
                                }
                            }
                            z18 = false;
                            if (!z18) {
                            }
                        }
                        if (i17 != -1) {
                            a.Companion companion = com.tencent.mobileqq.qwallet.pb.a.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(item, "item");
                            arrayList.set(i17, companion.b(item));
                        }
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        if (RedPackSkinExt.f(item) == i16) {
                            boolean z26 = item.has_got.get();
                            if (!z19 && z26) {
                                skinRecommendViewModel.p2(true);
                            }
                        }
                    }
                }
                SkinRecommendViewModel.this.Z1().postValue(arrayList);
            }
        });
    }

    public final void m2(final int sceneId, @Nullable final Function1<? super String, Unit> callback) {
        QLog.d("SkinRecommendViewModel", 2, "requestAllRecommendSkins: ");
        o2(0, sceneId, new Function3<RedPackSkin$GetRecommendSkinsRsp, Integer, String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel$requestAllRecommendSkins$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RedPackSkin$GetRecommendSkinsRsp redPackSkin$GetRecommendSkinsRsp, Integer num, String str) {
                invoke(redPackSkin$GetRecommendSkinsRsp, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable RedPackSkin$GetRecommendSkinsRsp redPackSkin$GetRecommendSkinsRsp, int i3, @Nullable String str) {
                if (redPackSkin$GetRecommendSkinsRsp == null) {
                    return;
                }
                if (sceneId == 0) {
                    this.c2(redPackSkin$GetRecommendSkinsRsp);
                } else {
                    this.b2(redPackSkin$GetRecommendSkinsRsp, callback);
                }
            }
        });
    }

    public final void o2(int skinId, int sceneId, @NotNull Function3<? super RedPackSkin$GetRecommendSkinsRsp, ? super Integer, ? super String, Unit> rspCallback) {
        Intrinsics.checkNotNullParameter(rspCallback, "rspCallback");
        RedPackSkin$GetRecommendSkinsReq redPackSkin$GetRecommendSkinsReq = new RedPackSkin$GetRecommendSkinsReq();
        redPackSkin$GetRecommendSkinsReq.skin_id.set(skinId);
        redPackSkin$GetRecommendSkinsReq.scene.set(sceneId);
        g gVar = new g(rspCallback);
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoGetRecommendSkins callback: " + gVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoGetRecommendSkins");
        newIntent.putExtra("data", fh.b(redPackSkin$GetRecommendSkinsReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new f(gVar));
        waitAppRuntime.startServlet(newIntent);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.d("SkinRecommendViewModel", 2, "onResume: " + this.channelReceivingSkin);
        int i3 = this.channelReceivingSkin;
        if (i3 != -1) {
            k2(i3, 0);
            this.channelReceivingSkin = -1;
        }
    }

    public final void p2(boolean z16) {
        this.isGotSkin = z16;
    }

    public final void q2(@Nullable WeakReference<Function1<Integer, Unit>> weakReference) {
        this.refreshSkinVMCallback = weakReference;
    }

    public final void t2(@NotNull List<? extends com.tencent.mobileqq.qwallet.pb.a> skinList) {
        Intrinsics.checkNotNullParameter(skinList, "skinList");
        this.sortOnceSkins.postValue(skinList);
    }
}
