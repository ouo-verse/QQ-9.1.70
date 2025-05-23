package com.tencent.mobileqq.vas.entrance;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonState;
import com.tencent.mobileqq.util.conversationtitlebutton.g;
import com.tencent.mobileqq.vas.entrance.VasZPlanSquareTitleButtonProcessor;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.common.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import nk3.n;
import ow4.a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J+\u0010\u0012\u001a\u00020\n2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J4\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\n0\u000eH\u0016R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/vas/entrance/VasZPlanSquareTitleButtonProcessor;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/g;", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/util/conversationtitlebutton/l;", "buttonState", "", "jumpBySchemaUrl", "reportEntranceExpose", "reportEntranceClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSupport", "callback", "onButtonDidShow", "handleIconClick", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfoForTip", "", "Landroid/graphics/drawable/Drawable;", "cb", "getAvatarDrawableList", "Lz23/b;", "zplanEntryService", "Lz23/b;", "buttonConfig", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaReportApi;", "reportApi", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaReportApi;", "Low4/b;", "entry", "Low4/b;", "isReportBubble", "Z", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasZPlanSquareTitleButtonProcessor implements g {
    private static final String TAG = "VasZPlanSquareTitleButtonProcessor";
    private ConversationTitleBtnConfig buttonConfig;
    private ow4.b entry;
    private boolean isReportBubble;
    private final IZootopiaReportApi reportApi;
    private final z23.b zplanEntryService = new z23.b();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/entrance/VasZPlanSquareTitleButtonProcessor$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Low4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<ow4.b> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f309060e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f309060e = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ow4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(VasZPlanSquareTitleButtonProcessor.TAG, 1, "isSupport, getEntry success, result:" + result);
            VasZPlanSquareTitleButtonProcessor.this.entry = result;
            this.f309060e.invoke(Boolean.valueOf(result.f424389a == 4));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.w(VasZPlanSquareTitleButtonProcessor.TAG, 1, "isSupport, getEntry failed, error:" + error + ", message:" + message);
            this.f309060e.invoke(Boolean.FALSE);
        }
    }

    public VasZPlanSquareTitleButtonProcessor() {
        QRouteApi api = QRoute.api(IZootopiaReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaReportApi::class.java)");
        this.reportApi = (IZootopiaReportApi) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isSupport$lambda$0(Long l3, Function1 callback, VasZPlanSquareTitleButtonProcessor this$0, AccessibleDetail accessibleDetail) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = accessibleDetail != null && accessibleDetail.isAccessible();
        QLog.i(TAG, 1, "isSupport, accessible:" + z16 + ", uin:" + i.a(l3.toString()));
        if (!z16) {
            callback.invoke(Boolean.FALSE);
        } else {
            this$0.zplanEntryService.e(false, new b(callback));
        }
    }

    private final void jumpBySchemaUrl(Context context, String jumpUrl, ConversationTitleBtnConfig config, TitleButtonState buttonState) {
        String str = null;
        if (buttonState.getHasRedTouch()) {
            str = String.valueOf(config != null ? Integer.valueOf(config.getRedDotAppId()) : null);
        }
        boolean z16 = true;
        QLog.i(TAG, 1, "jumpBySchemaUrl:" + jumpUrl + ", redTouchAppId:" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            Bundle bundle = new Bundle();
            bundle.putString("tianshuID", str);
            jumpUrl = ((ISchemeApi) QRoute.api(ISchemeApi.class)).appendPageDataToScheme(jumpUrl, bundle);
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(context, jumpUrl);
    }

    private final void reportEntranceClick() {
        IZootopiaReportApi iZootopiaReportApi = this.reportApi;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_action_type", "click");
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_main_square");
        Unit unit = Unit.INSTANCE;
        iZootopiaReportApi.reportEvent("ev_zplan_external_entrance_action", linkedHashMap);
    }

    private final void reportEntranceExpose() {
        a aVar;
        a aVar2;
        IZootopiaReportApi iZootopiaReportApi = this.reportApi;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_action_type", "imp");
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_main_square");
        ow4.b bVar = this.entry;
        int i3 = 0;
        if (!TextUtils.isEmpty((bVar == null || (aVar2 = bVar.f424391c) == null) ? null : aVar2.f424387a)) {
            ow4.b bVar2 = this.entry;
            if (((bVar2 == null || (aVar = bVar2.f424391c) == null) ? 0 : aVar.f424388b) > 0 && !this.isReportBubble) {
                i3 = 1;
                this.isReportBubble = true;
            }
        }
        linkedHashMap.put("zplan_have_new_bubble", Integer.valueOf(i3));
        Unit unit = Unit.INSTANCE;
        iZootopiaReportApi.reportEvent("ev_zplan_external_entrance_action", linkedHashMap);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getCustomTips(Context context, Function2<? super String, ? super List<? extends Drawable>, Unit> function2) {
        g.a.b(this, context, function2);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean handleIconClick(TitleButtonState buttonState, Context context, String jumpUrl) {
        Intrinsics.checkNotNullParameter(buttonState, "buttonState");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        jumpBySchemaUrl(context, jumpUrl, this.buttonConfig, buttonState);
        reportEntranceClick();
        return true;
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void isSupport(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime d16 = bb.f335811a.d();
        final Long valueOf = d16 != null ? Long.valueOf(d16.getLongAccountUin()) : null;
        if (valueOf == null) {
            QLog.w(TAG, 1, "isSupport, invalid uin!");
            callback.invoke(Boolean.FALSE);
        } else {
            uk3.g.f439121a.e(1001L, valueOf.longValue(), new n() { // from class: w03.a
                @Override // nk3.n
                public final void a(AccessibleDetail accessibleDetail) {
                    VasZPlanSquareTitleButtonProcessor.isSupport$lambda$0(valueOf, callback, this, accessibleDetail);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeRedDot() {
        return g.a.d(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeTips() {
        return g.a.e(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void onButtonDidShow(ConversationTitleBtnConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        QLog.i(TAG, 1, "onButtonDidShow, config:" + config);
        this.buttonConfig = config;
        reportEntranceExpose();
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void refreshRedDot(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        g.a.g(this, redTouch, appInfo, z16);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getAvatarDrawableList(Context context, BusinessInfoCheckUpdate.AppInfo appInfoForTip, Function1<? super Drawable[], Unit> cb5) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        List<Long> h16 = v.f335848a.h(appInfoForTip, "head_uins");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = h16.iterator();
        while (it.hasNext()) {
            arrayList.add(ProAvatarComponentUtils.e(context, 1, String.valueOf(((Number) it.next()).longValue()), false, 0L, 0, false, 0, null, 504, null));
        }
        Object array = arrayList.toArray(new Drawable[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        cb5.invoke(array);
    }
}
