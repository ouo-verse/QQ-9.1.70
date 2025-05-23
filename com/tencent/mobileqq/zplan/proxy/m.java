package com.tencent.mobileqq.zplan.proxy;

import android.os.Build;
import com.epicgames.ue4.ZPlanVersion;
import com.tencent.filament.zplan.record.FilamentNativeAppRecorder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.model.GeneralRecordSwitches;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import yx4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\nH\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/m;", "Lyx4/c;", "Lyx4/c$c;", "getConfig", "", "userId", "f", "jsonParams", "", "appearanceKeyChangeFromEngine", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "data", DomainData.DOMAIN_NAME, "avatarSceneParams", "notifyEnterAvatarScene", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "i", "p", "t", "g", "l", "k", "e", "getZPlanVersion", "Lcom/tencent/zplan/record/a;", "scene", "Lcom/tencent/zplan/record/model/c;", tl.h.F, "r", "enableFilament", "Lcom/tencent/zplan/meme/EngineType;", "v", "Lyx4/c$b;", "a", "Lyx4/c$e;", "d", "Lyx4/c$h;", DownloadInfo.spKey_Config, "o", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m implements yx4.c {

    /* renamed from: a, reason: collision with root package name */
    private static final a f335004a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/m$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // yx4.c
    public c.CloudCommonConfig a() {
        return ZPlanQQMC.INSTANCE.getZPlanCloudCacheCommonConfig();
    }

    @Override // yx4.c
    public void appearanceKeyChangeFromEngine(String jsonParams) {
        Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        c.d.a(this, jsonParams);
        ((pi3.a) k74.i.INSTANCE.a(pi3.a.class)).appearanceKeyChangeFromEngine(jsonParams);
    }

    @Override // yx4.c
    public int b() {
        return ZPlanFeatureSwitch.f369852a.U0();
    }

    @Override // yx4.c
    public int c() {
        return c.d.d(this);
    }

    @Override // yx4.c
    public c.ForceDeleteResourceConfig d() {
        return ZPlanQQMC.INSTANCE.getZPlanRecordForceDeleteConfig();
    }

    @Override // yx4.c
    public boolean e() {
        return ZPlanFeatureSwitch.f369852a.m();
    }

    @Override // yx4.c
    public String f(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return ZplanDataRepository.l(ZplanDataRepository.f334898a, userId, false, 2, null).appearanceKey;
    }

    @Override // yx4.c
    public int g() {
        return ZPlanFeatureSwitch.f369852a.r1();
    }

    @Override // yx4.c
    public c.Config getConfig() {
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        int t16 = zPlanFeatureSwitch.t1();
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        return new c.Config(t16, zPlanQQMC.getMemeRecordTimeoutTime(), zPlanQQMC.getMemeRecordFileCacheSize(), zPlanFeatureSwitch.d2(), zPlanFeatureSwitch.w2(), zPlanFeatureSwitch.N1(), zPlanFeatureSwitch.o3(), zPlanFeatureSwitch.H(), zPlanFeatureSwitch.y1(), new c.FrameModeConfig(zPlanFeatureSwitch.u1()), new c.APNGModeConfig(zPlanFeatureSwitch.b(), zPlanFeatureSwitch.P2(), zPlanFeatureSwitch.j()), new c.GIFModeConfig(zPlanFeatureSwitch.C(), 0, 2, null), new c.SharpPConfig(zPlanFeatureSwitch.x1(), zPlanFeatureSwitch.w1()), zPlanFeatureSwitch.U(), false, zPlanFeatureSwitch.d(), 16384, null);
    }

    @Override // yx4.c
    public String getZPlanVersion() {
        return ZPlanVersion.ZPlanVersion;
    }

    @Override // yx4.c
    public GeneralRecordSwitches h(com.tencent.zplan.record.a scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return ZPlanQQMC.INSTANCE.getGeneralRecordSwitchesByScene(scene);
    }

    @Override // yx4.c
    public long i() {
        return ZPlanQQMC.INSTANCE.getZPlanRRCResourceExpireConfig().getCloudCommonExpireDelay();
    }

    @Override // yx4.c
    public boolean j() {
        return ZPlanFeatureSwitch.f369852a.I();
    }

    @Override // yx4.c
    public boolean k() {
        return ZPlanFeatureSwitch.f369852a.V();
    }

    @Override // yx4.c
    public int l() {
        return ZPlanFeatureSwitch.f369852a.O1();
    }

    @Override // yx4.c
    public long m() {
        return ZPlanFeatureSwitch.f369852a.T0();
    }

    @Override // yx4.c
    public void n(boolean success, MemeResult data) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        wx4.d i3 = data.i();
        if (i3 == null) {
            return;
        }
        if (!i3.getHitCache() || ZPlanFeatureSwitch.f369852a.u3()) {
            MemeAction action = data.getAction();
            if (action.getType() == Meme.Type.CMShow) {
                return;
            }
            String senderUin = action.getSenderUin();
            if (senderUin == null) {
                senderUin = "";
            }
            String receiverUin = action.getReceiverUin();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("recordResult", String.valueOf(wx4.d.INSTANCE.b(success))), TuplesKt.to("recordType", action.getType().name()), TuplesKt.to("recordKey", String.valueOf(data.e())), TuplesKt.to("resId", String.valueOf(data.d())), TuplesKt.to(AppConstants.Key.COLUMN_MSG_SENDER_UIN, senderUin), TuplesKt.to("receiverUin", receiverUin != null ? receiverUin : ""), TuplesKt.to("perfLevel", String.valueOf(DeviceInfoUtils.getPerfLevel())), TuplesKt.to("timestampMs", String.valueOf(System.currentTimeMillis())), TuplesKt.to("fileSize", String.valueOf(success ? com.tencent.zplan.common.utils.c.f385288a.i(data.getRecordPath()) : 0L)));
            mutableMapOf.putAll(i3.I());
            t74.r.e(null, "meme_record_timeCost", mutableMapOf, 1, null);
        }
    }

    @Override // yx4.c
    public void notifyEnterAvatarScene(String avatarSceneParams) {
        c.d.c(this, avatarSceneParams);
        ((pi3.a) k74.i.INSTANCE.a(pi3.a.class)).notifyEnterAvatarScene(avatarSceneParams);
    }

    @Override // yx4.c
    public boolean o(c.LocalResourceUploadConfig config) {
        boolean contains;
        Object obj;
        boolean equals;
        Intrinsics.checkNotNullParameter(config, "config");
        try {
            if (Build.VERSION.SDK_INT < config.getApiLevel()) {
                return false;
            }
            Object obj2 = null;
            if (!config.d().isEmpty()) {
                String model = DeviceInfoMonitor.getModel();
                Iterator<T> it = config.d().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    equals = StringsKt__StringsJVMKt.equals((String) obj, model, true);
                    if (equals) {
                        break;
                    }
                }
                if (obj != null) {
                    return false;
                }
            }
            if (Math.ceil(t74.c.b() / 1024.0d) < config.getMemory()) {
                return false;
            }
            if (!config.b().isEmpty()) {
                String b16 = t74.d.f435534a.b();
                Iterator<T> it5 = config.b().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    contains = StringsKt__StringsKt.contains((CharSequence) b16, (CharSequence) next, true);
                    if (contains) {
                        obj2 = next;
                        break;
                    }
                }
                if (obj2 != null) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            QLog.e("QQZPlanMemeProxy", 1, "enableUploadForUploadConfigRequirement exception", th5);
            return false;
        }
    }

    @Override // yx4.c
    public long p() {
        return ZPlanQQMC.INSTANCE.getZPlanRRCResourceExpireConfig().getLocalCommonExpireDelay();
    }

    @Override // yx4.c
    public long q() {
        return ZPlanQQMC.INSTANCE.getRecordResourceCenterFileCacheSize();
    }

    @Override // yx4.c
    public String r() {
        String e16 = bb.f335811a.e();
        return e16 == null ? "" : e16;
    }

    @Override // yx4.c
    public boolean s() {
        return ZPlanQQMC.INSTANCE.enableQuitMemeEncoderThreadHandler();
    }

    @Override // yx4.c
    public long t() {
        return ZPlanQQMC.INSTANCE.getZPlanRRCResourceExpireConfig().getCloudForceExpireTimestamp();
    }

    @Override // yx4.c
    public boolean u() {
        return c.d.b(this);
    }

    @Override // yx4.c
    public EngineType v(boolean enableFilament) {
        if (enableFilament) {
            return new EngineType.Filament(FilamentNativeAppRecorder.class);
        }
        return null;
    }
}
