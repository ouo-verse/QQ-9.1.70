package com.tencent.mobileqq.zplan.aio.tofu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.aio.tofu.TofuAvatarLayout$jsEventListener$2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.aio.api.INTZPlanAvatarView;
import com.tencent.qqnt.aio.api.d;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanTofuAvatarConfig;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import dl0.g;
import dl0.k;
import fl0.a;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import t74.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K2\u00020\u0001:\u0001\u001dB7\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020#\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020\u0014\u00a2\u0006\u0004\bI\u0010JJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J\"\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0014J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0017\u0010\"\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00106R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/tofu/TofuAvatarLayout;", "Lcom/tencent/qqnt/aio/api/INTZPlanAvatarView;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Lcom/tencent/zplan/common/model/AppTheme;", "l", "Lorg/json/JSONObject;", "j", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "isHead", "", "k", "data", "o", "", "errorCode", "hasNetProcess", "hasPaused", "t", "visibility", "onWindowVisibilityChanged", ReportConstant.COSTREPORT_PREFIX, "r", "a", "d", "Lorg/json/JSONObject;", "getAvatarCharacter", "()Lorg/json/JSONObject;", "avatarCharacter", "Lcom/tencent/qqnt/aio/api/d;", "e", "Lcom/tencent/qqnt/aio/api/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/aio/api/d;", "iNTAvatarStatusViewCb", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "f", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "nativeApp", "Lcom/tencent/zplan/zplantracing/b;", h.F, "Lcom/tencent/zplan/zplantracing/b;", "rootSpan", "", "i", "J", "startTimeMillis", "Landroid/view/View;", "Landroid/view/View;", "textureView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/zplan/common/model/AppTheme;", "currentAppTheme", "D", "Z", "firstRenderDone", "Lsk0/b;", "E", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lsk0/b;", "jsEventListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Lorg/json/JSONObject;Lcom/tencent/qqnt/aio/api/d;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TofuAvatarLayout extends INTZPlanAvatarView {

    /* renamed from: C, reason: from kotlin metadata */
    private AppTheme currentAppTheme;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean firstRenderDone;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy jsEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final JSONObject avatarCharacter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final d iNTAvatarStatusViewCb;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IFilamentNativeAppV2305 nativeApp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b rootSpan;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long startTimeMillis;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View textureView;

    public /* synthetic */ TofuAvatarLayout(Context context, JSONObject jSONObject, d dVar, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, jSONObject, dVar, (i16 & 8) != 0 ? null : attributeSet, (i16 & 16) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject j() {
        String str;
        EnumUserGender a16 = EnumUserGender.INSTANCE.a(this.avatarCharacter.optInt("gender"));
        if (a16 == EnumUserGender.GENDER_FEMALE) {
            str = "GirlStretchConfig";
        } else {
            str = "BoyStretchConfig";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bodyTypeName", str);
        jSONObject.put("theme", AppTheme.INSTANCE.b(this.currentAppTheme));
        jSONObject.put("avatarCharacter", this.avatarCharacter);
        jSONObject.put("headAnimPath", k(a16, true));
        jSONObject.put("bodyAnimPath", k(a16, false));
        return jSONObject;
    }

    private final String k(EnumUserGender gender, boolean isHead) {
        ZPlanTofuAvatarConfig zPlanTofuAvatarConfig = ZPlanQQMC.INSTANCE.getZPlanTofuAvatarConfig();
        if (gender == EnumUserGender.GENDER_FEMALE) {
            if (isHead) {
                return zPlanTofuAvatarConfig.getFemale().getHead();
            }
            return zPlanTofuAvatarConfig.getFemale().getBody();
        }
        if (isHead) {
            return zPlanTofuAvatarConfig.getMale().getHead();
        }
        return zPlanTofuAvatarConfig.getMale().getBody();
    }

    private final AppTheme l() {
        if (QQTheme.isNowThemeIsNight()) {
            return AppTheme.NIGHT;
        }
        return AppTheme.DAY;
    }

    private final sk0.b n() {
        return (sk0.b) this.jsEventListener.getValue();
    }

    private final void p(c spanContext) {
        FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        a aVar = a.f399763a;
        IFilamentNativeAppV2305 c16 = FilamentRenderFactory.f105773b.c(new sk0.a(F, false, context, 15, (k) aVar.a(k.class), (dl0.d) aVar.a(dl0.d.class), (g) aVar.a(g.class)));
        this.nativeApp = c16;
        if (c16 != null) {
            c16.addEventListener("onFirstFrameRenderEnd", n());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.addEventListener("onFilamentRenderFail", n());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            iFilamentNativeAppV23052.startWithEntry(spanContext, "bundle/scenes/tofu_avatar/main.js");
        }
    }

    private final void q() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        TextureView view = iFilamentNativeAppV2305 != null ? iFilamentNativeAppV2305.getView() : null;
        this.textureView = view;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            view.setAlpha(0.0f);
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int errorCode, boolean hasNetProcess, boolean hasPaused) {
        long currentTimeMillis = System.currentTimeMillis() - this.startTimeMillis;
        HashMap hashMap = new HashMap();
        hashMap.put("timeCost", String.valueOf(currentTimeMillis));
        hashMap.put("errorCode", String.valueOf(errorCode));
        hashMap.put("hasNetProcess", String.valueOf(hasNetProcess));
        hashMap.put("hasPaused", String.valueOf(hasPaused));
        r.d("0AND0YAG6R40RLM6", "tofuAvatarShow", hashMap);
    }

    private final void u() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TofuAvatarLayout$runAPP$1(this, null), 3, null);
    }

    @Override // com.tencent.qqnt.aio.api.INTZPlanAvatarView
    public void a() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.removeEventListener("onFirstFrameRenderEnd");
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            iFilamentNativeAppV23052.removeEventListener("onFilamentRenderFail");
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23053 = this.nativeApp;
        if (iFilamentNativeAppV23053 != null) {
            iFilamentNativeAppV23053.destroy();
        }
        this.nativeApp = null;
        this.textureView = null;
    }

    /* renamed from: m, reason: from getter */
    public final d getINTAvatarStatusViewCb() {
        return this.iNTAvatarStatusViewCb;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            s();
        } else {
            r();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuAvatarLayout(Context context, JSONObject avatarCharacter, d iNTAvatarStatusViewCb, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        Intrinsics.checkNotNullParameter(iNTAvatarStatusViewCb, "iNTAvatarStatusViewCb");
        this.avatarCharacter = avatarCharacter;
        this.iNTAvatarStatusViewCb = iNTAvatarStatusViewCb;
        this.currentAppTheme = l();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TofuAvatarLayout$jsEventListener$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.zplan.aio.tofu.TofuAvatarLayout$jsEventListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.zplan.aio.tofu.TofuAvatarLayout$jsEventListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final TofuAvatarLayout tofuAvatarLayout = TofuAvatarLayout.this;
                return new sk0.b() { // from class: com.tencent.mobileqq.zplan.aio.tofu.TofuAvatarLayout$jsEventListener$2.1
                    @Override // sk0.b
                    public void handleEvent(c spanContext, String type, String data) {
                        b bVar;
                        long j3;
                        Intrinsics.checkNotNullParameter(type, "type");
                        QLog.i("TofuAvatarLayout", 1, "handleEvent, type: " + type + ", data: " + data);
                        if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
                            TofuAvatarLayout.this.firstRenderDone = true;
                            bVar = TofuAvatarLayout.this.rootSpan;
                            if (bVar != null) {
                                bVar.b();
                            }
                            JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(data);
                            if (b16 == null) {
                                return;
                            }
                            boolean optBoolean = b16.optBoolean("hasNetProcess");
                            boolean optBoolean2 = b16.optBoolean("hasPaused");
                            long currentTimeMillis = System.currentTimeMillis();
                            j3 = TofuAvatarLayout.this.startTimeMillis;
                            TofuAvatarLayout.this.t(0, optBoolean, optBoolean2);
                            QLog.i("TofuAvatarLayout", 1, "IntimateTofuScene_Launch firstRender, costTime:" + (currentTimeMillis - j3));
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TofuAvatarLayout$jsEventListener$2$1$handleEvent$1(TofuAvatarLayout.this, null), 3, null);
                            return;
                        }
                        if (Intrinsics.areEqual(type, "onFilamentRenderFail")) {
                            QLog.i("TofuAvatarLayout", 1, "IntimateTofuScene_Launch renderFail");
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TofuAvatarLayout$jsEventListener$2$1$handleEvent$2(TofuAvatarLayout.this, null), 3, null);
                            TofuAvatarLayout.this.o(data);
                        }
                    }
                };
            }
        });
        this.jsEventListener = lazy;
        long currentTimeMillis = System.currentTimeMillis();
        this.startTimeMillis = currentTimeMillis;
        QLog.i("TofuAvatarLayout", 1, "IntimateTofuScene_Launch start, startTimeMillis:" + currentTimeMillis);
        b startRootSpan = ZPlanSpanFactory.INSTANCE.startRootSpan("IntimateTofuScene_Launch");
        this.rootSpan = startRootSpan;
        p(startRootSpan != null ? startRootSpan.c() : null);
        q();
        u();
        s();
    }

    public final void r() {
        QLog.i("TofuAvatarLayout", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    public final void s() {
        QLog.i("TofuAvatarLayout", 1, "onResume");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String data) {
        JSONObject b16 = data != null ? com.tencent.zplan.common.utils.h.f385294a.b(data) : null;
        int optInt = b16 != null ? b16.optInt("errorCode") : -1;
        if (b16 != null) {
            b16.optString("errorMessage");
        }
        t(optInt, b16 != null ? b16.optBoolean("hasNetProcess") : true, b16 != null ? b16.optBoolean("hasPaused") : false);
    }
}
