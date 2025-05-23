package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import android.app.Activity;
import com.google.protobuf.nano.MessageNano;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.utils.k;
import com.tencent.mobileqq.zplan.authorize.api.CommonModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import qv4.ai;
import qv4.aj;
import qv4.at;
import qv4.bs;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/UserModInfoChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "", "l", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "k", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UserModInfoChecker extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/UserModInfoChecker$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/aj;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<aj> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f331437e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f331438f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331439h;

        a(EnterModCheckResult enterModCheckResult, EnterModCheckRequest enterModCheckRequest, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar) {
            this.f331437e = enterModCheckResult;
            this.f331438f = enterModCheckRequest;
            this.f331439h = aVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aj result) {
            Intrinsics.checkNotNullParameter(result, "result");
            boolean z16 = true;
            boolean z17 = result.f429928a == 0;
            boolean z18 = result.f429929b == 0;
            String str = result.f429930c;
            boolean z19 = str == null || str.length() == 0;
            UserModInfoChecker userModInfoChecker = UserModInfoChecker.this;
            int i3 = result.f429928a;
            int i16 = result.f429929b;
            at atVar = result.f429933f;
            userModInfoChecker.f("check onResultSuccess result.mapVersionStatus = " + i3 + ", result.qqVersionStatus= " + i16 + ", loadingType= " + (atVar != null ? Integer.valueOf(atVar.f430007b) : null) + ", scheme= " + result.f429932e + ", toastCheckPassed= " + z19);
            if (z17 && z18 && z19) {
                ZootopiaEnterParams enterParamsAfterCheck = this.f331437e.getEnterParamsAfterCheck();
                if (enterParamsAfterCheck != null) {
                    String str2 = result.f429931d;
                    Intrinsics.checkNotNullExpressionValue(str2, "result.mapVersion");
                    enterParamsAfterCheck.setVersion(str2);
                }
                ZootopiaEnterParams enterParamsAfterCheck2 = this.f331437e.getEnterParamsAfterCheck();
                if (enterParamsAfterCheck2 != null) {
                    enterParamsAfterCheck2.setLoadingParams(ZootopiaMapLoadingParams.INSTANCE.a(result.f429933f));
                }
                ArrayList arrayList = new ArrayList();
                nw4.f[] fVarArr = result.f429936i;
                Intrinsics.checkNotNullExpressionValue(fVarArr, "result.infoList");
                for (nw4.f fVar : fVarArr) {
                    byte[] infoByteArray = MessageNano.toByteArray(fVar);
                    Intrinsics.checkNotNullExpressionValue(infoByteArray, "infoByteArray");
                    arrayList.add(infoByteArray);
                }
                ZootopiaEnterParams enterParamsAfterCheck3 = this.f331437e.getEnterParamsAfterCheck();
                if (enterParamsAfterCheck3 != null) {
                    String str3 = result.f429934g;
                    Intrinsics.checkNotNullExpressionValue(str3, "result.downText");
                    String str4 = result.f429935h;
                    Intrinsics.checkNotNullExpressionValue(str4, "result.loadingText");
                    String str5 = result.f429937j;
                    Intrinsics.checkNotNullExpressionValue(str5, "result.newGuideUrl");
                    enterParamsAfterCheck3.setCommonModCheckResult(new CommonModCheckResult(str3, str4, str5, arrayList));
                }
                UserModInfoChecker.this.d(this.f331438f, this.f331437e, this.f331439h);
                return;
            }
            if (!z19) {
                UserModInfoChecker userModInfoChecker2 = UserModInfoChecker.this;
                String str6 = result.f429930c;
                Intrinsics.checkNotNullExpressionValue(str6, "result.toast");
                userModInfoChecker2.i(str6);
            }
            if (!z17) {
                UserModInfoChecker.this.f("check onResultSuccess mapVersionCheckPassed false");
                String str7 = result.f429932e;
                if (str7 != null && str7.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    this.f331437e.setProcessInner(false);
                } else {
                    UserModInfoChecker userModInfoChecker3 = UserModInfoChecker.this;
                    String str8 = result.f429932e;
                    Intrinsics.checkNotNullExpressionValue(str8, "result.scheme");
                    userModInfoChecker3.c(str8, this.f331438f.getSource());
                }
                this.f331437e.setResultCode(5);
                this.f331439h.b(this.f331437e);
                return;
            }
            if (z18) {
                if (!z19) {
                    UserModInfoChecker.this.f("check onResultSuccess toastCheckPassed false");
                    this.f331437e.setResultCode(7);
                    this.f331439h.b(this.f331437e);
                    return;
                }
                UserModInfoChecker.this.d(this.f331438f, this.f331437e, this.f331439h);
                return;
            }
            UserModInfoChecker.this.f("check onResultSuccess qqVersionCheckPassed false");
            if (result.f429929b == 1) {
                UserModInfoChecker.this.l();
            } else {
                String str9 = result.f429932e;
                if (str9 != null && str9.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    this.f331437e.setProcessInner(false);
                } else {
                    UserModInfoChecker userModInfoChecker4 = UserModInfoChecker.this;
                    String str10 = result.f429932e;
                    Intrinsics.checkNotNullExpressionValue(str10, "result.scheme");
                    userModInfoChecker4.c(str10, this.f331438f.getSource());
                }
            }
            this.f331437e.setResultCode(6);
            this.f331439h.b(this.f331437e);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            UserModInfoChecker.this.f("check onResultFailure error = " + error + " message = " + message);
            UserModInfoChecker.this.h(R.string.xbn);
            this.f331437e.setResultCode(8);
            this.f331439h.b(this.f331437e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        f("showQQUpgradeDialog");
        final Activity topActivity = Foreground.getTopActivity();
        if (topActivity.isFinishing()) {
            return;
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.UserModInfoChecker$showQQUpgradeDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                k kVar = new k();
                Activity activity = topActivity;
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                k.e(kVar, activity, null, 2, null);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "UserModInfoChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        ai aiVar = new ai();
        bs bsVar = new bs();
        aiVar.f429925a = bsVar;
        bsVar.f430115a = request.getEnterParams().getMapId();
        aiVar.f429925a.f430116b = request.getEnterParams().getVersion();
        Map<String, Object> ueParams = request.getEnterParams().getUeParams();
        Object obj = ueParams != null ? ueParams.get("serverExtraInfo") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        aiVar.f429927c = str;
        oe3.a.d(oe3.a.f422578a, aiVar, new a(lastCheckResult, request, callback), 0, 4, null);
    }
}
