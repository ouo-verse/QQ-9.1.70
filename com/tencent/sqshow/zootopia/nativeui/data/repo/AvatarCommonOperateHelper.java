package com.tencent.sqshow.zootopia.nativeui.data.repo;

import android.app.Activity;
import android.os.Handler;
import b94.a;
import b94.d;
import b94.e;
import com.google.gson.JsonArray;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanDebugHelper;
import com.tencent.mobileqq.zplan.api.IZPlanPortalStoreLuaPluginHelper;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartGoodsData;
import com.tencent.sqshow.zootopia.nativeui.data.cart.PriceType;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import com.tencent.sqshow.zootopia.nativeui.ue.aa;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicActionSheet;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m94.DressControllerInitData;
import mqq.app.Foreground;
import uv4.al;
import uv4.az;
import uv4.bd;
import uv4.bo;
import uv4.bp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001IB\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J<\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J4\u0010\u0016\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J*\u0010\u001a\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rH\u0002JE\u0010$\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00140 H\u0002J\"\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001eH\u0002J\u001b\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)H\u0002\u00a2\u0006\u0004\b,\u0010-J\b\u0010.\u001a\u00020\u0002H\u0002JN\u00103\u001a\u00020\u00142\u0006\u00100\u001a\u00020/2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001e\u00105\u001a\u0002042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004JW\u0010;\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00107\u001a\u0004\u0018\u0001062\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u00108\u001a\u00020\u00042%\b\u0002\u0010:\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u0014\u0018\u00010 JH\u0010>\u001a\u00020\u00142\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010)2\u0006\u0010\u000b\u001a\u00020\n2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u00140 \u00a2\u0006\u0004\b>\u0010?J?\u0010C\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\r2!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u00140 J\u0006\u0010D\u001a\u00020\u0014J\"\u0010F\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140 \u00a8\u0006J"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper;", "", "", "j", "", "curGold", "payGold", "curSilver", "paySilver", "l", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "diffGoldCoin", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "data", "gender", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/g;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "source", "Luv4/az;", VideoTemplateParser.ITEM_LIST, ReportConstant.COSTREPORT_PREFIX, "needShowShareDialog", "Luv4/al;", "currentAvatar", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicActionSheet;", "shareActionSheet", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", UIJsPlugin.EVENT_SHOW_TOAST, "r", "Ldw4/b;", "result", "generalAvatarShareWithPicActionSheet", "v", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "k", "()[Ljava/util/ArrayList;", "p", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$BuySource;", "buySource", "goldPrice", "silverPrice", "f", "Lcom/tencent/mobileqq/zplan/aigc/const/ZPlanAIGCStatusCode;", "i", "Lqu4/a;", "finalAvatar", "saveSource", "success", "listener", "t", "Luv4/e;", "items", "w", "([Luv4/e;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lkotlin/jvm/functions/Function1;)V", "Luv4/bd;", "itemParams", "finishCallback", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "diffGoldPrice", DomainData.DOMAIN_NAME, "<init>", "()V", "BuySource", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarCommonOperateHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final AvatarCommonOperateHelper f371049a = new AvatarCommonOperateHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$BuySource;", "", "(Ljava/lang/String;I)V", "SOURCE_SHOPPING_CART", "SOURCE_EXPERIENCE_CARD", "SOURCE_COUPON_SHOPPING_CART", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum BuySource {
        SOURCE_SHOPPING_CART,
        SOURCE_EXPERIENCE_CARD,
        SOURCE_COUPON_SHOPPING_CART
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371050a;

        static {
            int[] iArr = new int[PriceType.values().length];
            try {
                iArr[PriceType.GOAL_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PriceType.SILVER_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f371050a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/g;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<uv4.g> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<uv4.g> f371051d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<CartGoodsData> f371052e;

        b(com.tencent.mobileqq.zootopia.api.e<uv4.g> eVar, List<CartGoodsData> list) {
            this.f371051d = eVar;
            this.f371052e = list;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.g result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZPlanRedDotManager.f373437a.v();
            this.f371051d.onResultSuccess(result);
            QLog.i("AvatarBugStoreRepo", 1, "buyStoreItem success " + result.f440419a + ", " + result.f440420b);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            int collectionSizeOrDefault;
            this.f371051d.onResultFailure(error, message);
            List<CartGoodsData> list = this.f371052e;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CartGoodsData) it.next()).getItemData().f440277d);
            }
            QLog.e("AvatarBugStoreRepo", 1, "\u8d2d\u4e70\u5546\u54c1\u5931\u8d25 " + arrayList + " error " + error + " and message " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$c", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements IVasNativePayManager.PayObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            QLog.d("AvatarBugStoreRepo", 1, "onOpenPayViewSuccess");
            ((IZPlanPortalStoreLuaPluginHelper) QRoute.api(IZPlanPortalStoreLuaPluginHelper.class)).setPayPanelShowingState(true);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            QLog.d("AvatarBugStoreRepo", 1, "onPayError, code: " + code);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            QLog.d("AvatarBugStoreRepo", 1, "onOpenPayViewFail");
            ((IZPlanPortalStoreLuaPluginHelper) QRoute.api(IZPlanPortalStoreLuaPluginHelper.class)).setPayPanelShowingState(false);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            QLog.d("AvatarBugStoreRepo", 1, "onPaySuccess");
            yb4.e.g(yb4.e.f450058a, "PaySuccess", 0, 2, null);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
            QLog.d("AvatarBugStoreRepo", 1, "onPayViewClose");
            ((IZPlanPortalStoreLuaPluginHelper) QRoute.api(IZPlanPortalStoreLuaPluginHelper.class)).setPayPanelShowingState(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$d", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements IVasNativePayManager.PayObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f371053a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Boolean, Unit> function1) {
            this.f371053a = function1;
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            QLog.e("AvatarBugStoreRepo", 1, "onPayError, code: " + code);
            this.f371053a.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            QLog.i("AvatarBugStoreRepo", 1, "onOpenPayViewFail");
            this.f371053a.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            QLog.i("AvatarBugStoreRepo", 1, "onOpenPayViewSuccess");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            QLog.i("AvatarBugStoreRepo", 1, "onPaySuccess");
            yb4.e.g(yb4.e.f450058a, "PaySuccess", 0, 2, null);
            this.f371053a.invoke(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
            QLog.i("AvatarBugStoreRepo", 1, "onPayViewClose");
            this.f371053a.invoke(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/n;", "result", "", "b", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<uv4.n> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f371054d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$e$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "c", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ qu4.a f371055d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ IZPlanIPCHelper f371056e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Function1<Boolean, Unit> f371057f;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/AvatarCommonOperateHelper$e$a$a", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$e$a$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            public static final class C9815a implements a.b {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ IZPlanIPCHelper f371058d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Function1<Boolean, Unit> f371059e;

                /* JADX WARN: Multi-variable type inference failed */
                C9815a(IZPlanIPCHelper iZPlanIPCHelper, Function1<? super Boolean, Unit> function1) {
                    this.f371058d = iZPlanIPCHelper;
                    this.f371059e = function1;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(Function1 finishCallback, boolean z16) {
                    Intrinsics.checkNotNullParameter(finishCallback, "$finishCallback");
                    finishCallback.invoke(Boolean.valueOf(z16));
                }

                @Override // com.tencent.zplan.luabridge.a.b
                public void onExecuteLua() {
                    a.b.C10064a.a(this);
                }

                @Override // com.tencent.zplan.luabridge.a.b
                public void onLuaResult(final boolean success, String result) {
                    QLog.i("AvatarBugStoreRepo", 1, "excete changeDress => " + success + ", " + result);
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final Function1<Boolean, Unit> function1 = this.f371059e;
                    uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AvatarCommonOperateHelper.e.a.C9815a.b(Function1.this, success);
                        }
                    });
                    if (success) {
                        this.f371058d.dressInfoIpcRefreshDressInfo("mod_save");
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            a(qu4.a aVar, IZPlanIPCHelper iZPlanIPCHelper, Function1<? super Boolean, Unit> function1) {
                this.f371055d = aVar;
                this.f371056e = iZPlanIPCHelper;
                this.f371057f = function1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(Function1 finishCallback) {
                Intrinsics.checkNotNullParameter(finishCallback, "$finishCallback");
                finishCallback.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(ZootopiaOpenIdResult result) {
                String str;
                aa aaVar = aa.f371327d;
                qu4.a avatar = this.f371055d;
                Intrinsics.checkNotNullExpressionValue(avatar, "avatar");
                if (result == null || (str = result.getOpenId()) == null) {
                    str = "";
                }
                a.C0113a.a(aaVar, "mod", avatar, null, str, new C9815a(this.f371056e, this.f371057f), null, 36, null);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("AvatarBugStoreRepo", 1, "getOpenId faile " + error + " " + message);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Function1<Boolean, Unit> function1 = this.f371057f;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AvatarCommonOperateHelper.e.a.b(Function1.this);
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super Boolean, Unit> function1) {
            this.f371054d = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(IZPlanIPCHelper ipcHelper) {
            Intrinsics.checkNotNullParameter(ipcHelper, "$ipcHelper");
            ipcHelper.nativeUiIPCAvatarCharacterChanged();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.n result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("AvatarBugStoreRepo", 1, " result => " + Arrays.toString(result.f440433b) + " , " + (result.f440432a == null));
            String[] strArr = result.f440433b;
            if (strArr != null) {
                for (String str : strArr) {
                    QQToast.makeText(BaseApplication.getContext(), 1, str, 1).show();
                }
            }
            qu4.a aVar = result.f440432a;
            if (aVar == null) {
                this.f371054d.invoke(Boolean.FALSE);
                return;
            }
            QRouteApi api = QRoute.api(IZPlanIPCHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanIPCHelper::class.java)");
            final IZPlanIPCHelper iZPlanIPCHelper = (IZPlanIPCHelper) api;
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.a
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarCommonOperateHelper.e.c(IZPlanIPCHelper.this);
                }
            }, 3000L);
            iZPlanIPCHelper.openIdRemoteManagerGetOpenIdInfoSilent(new a(aVar, iZPlanIPCHelper, this.f371054d));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("AvatarBugStoreRepo", 1, "request file " + error + " " + message);
            this.f371054d.invoke(Boolean.FALSE);
        }
    }

    AvatarCommonOperateHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<CartGoodsData> data, com.tencent.sqshow.zootopia.nativeui.data.j channel, int gender, com.tencent.mobileqq.zootopia.api.e<uv4.g> callback) {
        int collectionSizeOrDefault;
        uv4.f fVar = new uv4.f();
        List<CartGoodsData> list = data;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            CartGoodsData cartGoodsData = (CartGoodsData) it.next();
            uv4.e eVar = new uv4.e();
            eVar.f440404b = cartGoodsData.getItemData().f440275b;
            eVar.f440403a = cartGoodsData.getItemData().f440274a;
            eVar.f440405c = cartGoodsData.getItemData().f440276c;
            eVar.f440406d = cartGoodsData.getItemData().B;
            int i16 = a.f371050a[cartGoodsData.getPriceType().ordinal()];
            if (i16 != 1 && i16 == 2) {
                i3 = 1;
            }
            eVar.f440407e = i3;
            eVar.f440408f = 1;
            eVar.f440411i = channel.a().contains(r94.b.a(cartGoodsData.getItemData()));
            eVar.f440412j = cartGoodsData.getItemData().G;
            eVar.f440413k = cartGoodsData.getItemData().H;
            eVar.f440414l = cartGoodsData.getItemData().K;
            arrayList.add(eVar);
        }
        Object[] array = arrayList.toArray(new uv4.e[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        fVar.f440415a = (uv4.e[]) array;
        fVar.f440416b = gender;
        fVar.f440417c = channel.getSchemeParams();
        fVar.f440418d = channel.getZplanPageOpenSource();
        QLog.i("AvatarBugStoreRepo", 1, "buy Store item " + Arrays.toString(fVar.f440415a) + ", gender= " + gender + ", schemeParams: " + channel.getSchemeParams());
        if (ZPlanFeatureSwitch.f369852a.q()) {
            callback.onResultFailure(-1, "\u6d4b\u8bd5\u8d2d\u4e70\u5931\u8d25");
            QLog.e("AvatarBugStoreRepo", 1, "test buyStoreItem fail.");
        } else {
            va4.a.f(va4.a.f441274a, fVar, new b(callback, data), 0, 4, null);
        }
    }

    private final boolean j() {
        if (!ZPlanQQMC.INSTANCE.enableZPlanPayModuleUpdate()) {
            QLog.i("AvatarBugStoreRepo", 1, "enablePayModuleUpdateQQMC false, return.");
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_zplan_pay_module_update");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026_ZPLAN_PAY_MODULE_UPDATE)");
        expEntity.reportExpExposure();
        return expEntity.isExperiment("exp_zplan_pay_module_update_B");
    }

    private final ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] k() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        if (ZPlanQQMC.INSTANCE.enableShareDressToXhs()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(218));
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(204));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(205));
        return new ArrayList[]{arrayList, arrayList2};
    }

    private final int l(int curGold, int payGold, int curSilver, int paySilver) {
        boolean z16 = true;
        boolean z17 = false;
        if (payGold <= 0) {
            if (curSilver >= 0 && curSilver < paySilver) {
                z17 = true;
            }
            if (!z17) {
                return 2;
            }
            return 1;
        }
        if (paySilver <= 0) {
            if (curGold < 0 || curGold >= payGold) {
                z16 = false;
            }
            if (!z16) {
                return 2;
            }
            return 0;
        }
        if (curGold >= payGold && curSilver < paySilver) {
            return 1;
        }
        if (curGold < payGold && curSilver >= paySilver) {
            return 0;
        }
        if (curGold >= payGold || curSilver >= paySilver) {
            return 2;
        }
        return 0;
    }

    private final boolean p() {
        return ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableAvatarDressShare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final boolean needShowShareDialog, final al currentAvatar, final GeneralAvatarShareWithPicActionSheet shareActionSheet, final Function1<? super Boolean, Unit> callback) {
        com.tencent.sqshow.dresskey.b.f369818a.u("avatar_save", true, new com.tencent.mobileqq.zootopia.api.e<dw4.b>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$refreshDressKeyAndShare$1
            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(final dw4.b result) {
                Intrinsics.checkNotNullParameter(result, "result");
                final Function1<Boolean, Unit> function1 = callback;
                final boolean z16 = needShowShareDialog;
                final al alVar = currentAvatar;
                final GeneralAvatarShareWithPicActionSheet generalAvatarShareWithPicActionSheet = shareActionSheet;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$refreshDressKeyAndShare$1$onResultSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        boolean z17;
                        boolean v3;
                        Function1<Boolean, Unit> function12 = function1;
                        if (z16) {
                            v3 = AvatarCommonOperateHelper.f371049a.v(result, alVar, generalAvatarShareWithPicActionSheet);
                            if (v3) {
                                z17 = false;
                                function12.invoke(Boolean.valueOf(z17));
                            }
                        }
                        z17 = true;
                        function12.invoke(Boolean.valueOf(z17));
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.d("AvatarBugStoreRepo", 1, "updateAvatarCharacter rrefreshDressInfo fail error=" + error + " message=" + message);
                final Function1<Boolean, Unit> function1 = callback;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$refreshDressKeyAndShare$1$onResultFailure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        function1.invoke(Boolean.TRUE);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(com.tencent.sqshow.zootopia.nativeui.data.j channel, int source, List<az> itemList) {
        String str;
        String p16;
        b94.d avatarDressController;
        DressControllerInitData mInitData;
        ZootopiaSource source2;
        int collectionSizeOrDefault;
        Object obj;
        JsonArray jsonArray = new JsonArray();
        Collection<az> values = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().b().values();
        if (itemList != null) {
            List<az> list = itemList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (az azVar : list) {
                Iterator<T> it = values.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((az) obj).B, azVar.B)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                az azVar2 = (az) obj;
                if (azVar2 != null) {
                    azVar = azVar2;
                }
                arrayList.add(azVar);
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                jsonArray.add(r94.b.J((az) it5.next()));
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        String str2 = "";
        if (channel == null || (avatarDressController = channel.getAvatarDressController()) == null || (mInitData = avatarDressController.getMInitData()) == null || (source2 = mInitData.getSource()) == null || (str = ah.b(source2)) == null) {
            str = "";
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        if (itemList != null && (p16 = r94.b.p(itemList)) != null) {
            str2 = p16;
        }
        hashMap.put("zplan_item_id", str2);
        hashMap.put("zplan_gender", Integer.valueOf(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex()));
        hashMap.put("zplan_save_source", Integer.valueOf(source));
        String jsonElement = jsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "extInfo.toString()");
        hashMap.put("zplan_ext_info", jsonElement);
        VideoReport.reportEvent("ev_zplan_save_success", null, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v(dw4.b result, al currentAvatar, GeneralAvatarShareWithPicActionSheet generalAvatarShareWithPicActionSheet) {
        Map mapOf;
        if (w84.a.f445029a.b()) {
            QLog.i("AvatarBugStoreRepo", 1, " \u9752\u5c11\u5e74\u6a21\u5f0f\u4e0d\u5f39\u5206\u4eab\u5f39\u7a97");
            return false;
        }
        boolean enableZPlanShareTemplate = ZPlanQQMC.INSTANCE.enableZPlanShareTemplate();
        if (!p() || !enableZPlanShareTemplate) {
            QLog.d("AvatarBugStoreRepo", 1, " updateAvatarCharacter success, \u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u5931\u8d25\uff0c\u7279\u6027\u5f00\u5173\u5173\u95ed");
            return false;
        }
        if (generalAvatarShareWithPicActionSheet == null) {
            QLog.e("AvatarBugStoreRepo", 1, " updateAvatarCharacter success, \u5f39\u51fa\u5206\u4eab\u5f39\u7a97\u5931\u8d25\uff0cgeneralAvatarShareWithPicActionSheet == null");
            return false;
        }
        GeneralAvatarShareWithPicPresenter generalAvatarShareWithPicPresenter = new GeneralAvatarShareWithPicPresenter(generalAvatarShareWithPicActionSheet);
        generalAvatarShareWithPicActionSheet.setActionSheetItems(k());
        generalAvatarShareWithPicActionSheet.R0(generalAvatarShareWithPicPresenter);
        qu4.h hVar = result.f395115b;
        String str = hVar != null ? hVar.f429598b : null;
        if (str == null) {
            return false;
        }
        generalAvatarShareWithPicActionSheet.Q0(str);
        qu4.a aVar = currentAvatar.f440152a;
        if (aVar == null) {
            return false;
        }
        generalAvatarShareWithPicActionSheet.P0(aVar);
        generalAvatarShareWithPicPresenter.u();
        ((IZPlanDebugHelper) QRoute.api(IZPlanDebugHelper.class)).shareAvatarCharacterIfNeed(currentAvatar, result);
        VideoReport.setPageId(generalAvatarShareWithPicActionSheet, "pg_zplan_avatar_outfit_share");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "AvatarBugStoreRepo"));
        VideoReport.reportEvent("pgin", generalAvatarShareWithPicActionSheet, mapOf);
        return true;
    }

    public final ZPlanAIGCStatusCode i(com.tencent.sqshow.zootopia.nativeui.data.j channel, int goldPrice, int silverPrice) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (!iZPlanApi.isNetworkAvailable(context)) {
            QLog.e("AvatarBugStoreRepo", 1, "network is doesn't work");
            return ZPlanAIGCStatusCode.NETWORK_UNAVAILABLE;
        }
        com.tencent.sqshow.zootopia.data.f value = gb4.a.f401894a.b().getValue();
        if (value == null) {
            QLog.e("AvatarBugStoreRepo", 1, "check currency failed.");
            return ZPlanAIGCStatusCode.CHECK_CURRENCY_FAILED;
        }
        if (value.getGoldCoinRet() == 0) {
            int goldCoin = value.getGoldCoin();
            if (goldCoin >= 0 && goldCoin < goldPrice) {
                return ZPlanAIGCStatusCode.GOLD_COIN_NOT_ENOUGH;
            }
        }
        if (value.getSilverCoinRet() == 0) {
            int silverCoin = value.getSilverCoin();
            if (silverCoin >= 0 && silverCoin < silverPrice) {
                return ZPlanAIGCStatusCode.SILVER_COIN_NOT_ENOUTH;
            }
        }
        return ZPlanAIGCStatusCode.COIN_ENOUGH;
    }

    public final void m() {
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Activity activityFromContext = iZPlanApi.getActivityFromContext(context);
        if (activityFromContext == null) {
            activityFromContext = Foreground.getTopActivity();
        }
        ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(activityFromContext, IVasNativePayManager.TITLE_RECHARGE, "\u8d85\u7ea7QQ\u79c0", new IVasNativePayManager.ReportData("1009", "0", "0", "0"), new c());
    }

    public final void n(int diffGoldPrice, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("AvatarBugStoreRepo", 1, "handleAddCoinAndBuy, diffGoldPrice is " + diffGoldPrice);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Activity activityFromContext = iZPlanApi.getActivityFromContext(context);
        if (activityFromContext == null) {
            activityFromContext = Foreground.getTopActivity();
        }
        if (ZPlanFeatureSwitch.f369852a.r()) {
            QLog.i("AvatarBugStoreRepo", 1, "handleAddCoinAndBuy, test pay fail");
            callback.invoke(Boolean.FALSE);
        } else {
            ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).directdPay(activityFromContext, diffGoldPrice, new IVasNativePayManager.ReportData("1009", "0", "0", "0"), new d(callback));
        }
    }

    public final void o(int gender, List<bd> itemParams, Function1<? super Boolean, Unit> finishCallback) {
        Intrinsics.checkNotNullParameter(itemParams, "itemParams");
        Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
        uv4.m mVar = new uv4.m();
        mVar.f440431b = gender;
        Object[] array = itemParams.toArray(new bd[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        mVar.f440430a = (bd[]) array;
        QLog.d("AvatarBugStoreRepo", 1, "dress avatar => " + mVar);
        va4.a.h(va4.a.f441274a, mVar, new e(finishCallback), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final com.tencent.sqshow.zootopia.nativeui.data.j channel, int diffGoldCoin, final List<CartGoodsData> data, final int gender, final com.tencent.mobileqq.zootopia.api.e<uv4.g> callback) {
        QLog.i("AvatarBugStoreRepo", 1, "realAddCoinAndBuy");
        n(diffGoldCoin, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$realAddCoinAndBuy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    QLog.i("AvatarBugStoreRepo", 1, "handleAddCoinAndBuy success, buyStoreItemRequest");
                    b94.e O = com.tencent.sqshow.zootopia.nativeui.data.j.this.O();
                    if (O != null) {
                        e.a.h(O, 0L, 1, null);
                    }
                    AvatarCommonOperateHelper.f371049a.h(data, com.tencent.sqshow.zootopia.nativeui.data.j.this, gender, callback);
                    return;
                }
                QLog.e("AvatarBugStoreRepo", 1, "handleAddCoinAndBuy fail.");
                callback.onResultFailure(-1, "handleAddCoinAndBuy fail");
            }
        });
    }

    public final void t(final com.tencent.sqshow.zootopia.nativeui.data.j channel, qu4.a finalAvatar, final boolean needShowShareDialog, final int saveSource, final Function1<? super Boolean, Unit> listener) {
        b94.e O;
        b94.e O2;
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (!iZPlanApi.isNetworkAvailable(context)) {
            QLog.e("AvatarBugStoreRepo", 1, "network is doesn't work");
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.xrx, 1).show();
            return;
        }
        qu4.a avatarCharacter = finalAvatar == null ? com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().getAvatarCharacter() : finalAvatar;
        if (channel != null && (O2 = channel.O()) != null) {
            O2.P1(500L);
        }
        bo boVar = new bo();
        boVar.f440383a = avatarCharacter;
        QRouteApi api = QRoute.api(IZPlanDebugHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanDebugHelper::class.java)");
        IZPlanDebugHelper iZPlanDebugHelper = (IZPlanDebugHelper) api;
        if (iZPlanDebugHelper.isUploadAvatarChecked()) {
            String str = BaseApplication.getContext().getCacheDir().toString() + "/zplanAvatar";
            String jSONObject = r94.c.h(avatarCharacter).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "avatarCharacter.toJson().toString()");
            iZPlanDebugHelper.zipAndUploadAvatarJsonToWorkChat(jSONObject, str);
            QQToast.makeText(BaseApplication.getContext(), 0, "\u5df2\u5c1d\u8bd5\u4e0a\u4f20AVATAR\u4fe1\u606f\uff0c\u8bf7\u524d\u5f80\u4f01\u4e1a\u5fae\u4fe1\u67e5\u770b", 0).show();
        }
        if (ZPlanFeatureSwitch.f369852a.s()) {
            QLog.e("AvatarBugStoreRepo", 1, "test saveAvatarCharacter fail");
            QQToast.makeText(BaseApplication.getContext(), 1, "\u6d4b\u8bd5\u4fdd\u5b58\u5931\u8d25", 0).show();
            if (listener != null) {
                listener.invoke(Boolean.FALSE);
            }
            if (channel == null || (O = channel.O()) == null) {
                return;
            }
            O.S2();
            return;
        }
        Object lifecycleOwner = channel != null ? channel.getLifecycleOwner() : null;
        Activity activity = lifecycleOwner instanceof Activity ? (Activity) lifecycleOwner : null;
        final GeneralAvatarShareWithPicActionSheet generalAvatarShareWithPicActionSheet = activity != null ? new GeneralAvatarShareWithPicActionSheet(activity) : null;
        va4.a.l(va4.a.f441274a, boVar, new com.tencent.mobileqq.zootopia.api.e<bp>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$saveAvatarCharacter$1
            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(bp result) {
                az[] azVarArr;
                com.tencent.sqshow.zootopia.nativeui.data.j jVar;
                b94.a engineApi;
                b94.d avatarDressController;
                b94.e O3;
                b94.e O4;
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.d("AvatarBugStoreRepo", 1, " updateAvatarCharacter success, gender:" + result.f440387d + ", " + result.f440384a + " , " + result.f440385b);
                com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = com.tencent.sqshow.zootopia.nativeui.data.j.this;
                if (jVar2 != null && (O4 = jVar2.O()) != null) {
                    O4.S2();
                }
                if (result.f440384a == 0) {
                    com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = com.tencent.sqshow.zootopia.nativeui.data.j.this;
                    if (jVar3 != null && (O3 = jVar3.O()) != null) {
                        al alVar = result.f440386c;
                        Intrinsics.checkNotNullExpressionValue(alVar, "result.currentAvatar");
                        O3.O7(alVar, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.g(Integer.valueOf(result.f440387d)));
                    }
                    com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = com.tencent.sqshow.zootopia.nativeui.data.j.this;
                    if (jVar4 != null && (avatarDressController = jVar4.getAvatarDressController()) != null) {
                        al alVar2 = result.f440386c;
                        Intrinsics.checkNotNullExpressionValue(alVar2, "result.currentAvatar");
                        avatarDressController.Mc(alVar2, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.g(Integer.valueOf(result.f440387d)));
                    }
                    qu4.a aVar = result.f440386c.f440152a;
                    if (aVar != null && (jVar = com.tencent.sqshow.zootopia.nativeui.data.j.this) != null && (engineApi = jVar.getEngineApi()) != null) {
                        engineApi.g(aVar);
                    }
                    Function1<Boolean, Unit> function1 = listener;
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                    AvatarCommonOperateHelper avatarCommonOperateHelper = AvatarCommonOperateHelper.f371049a;
                    boolean z16 = needShowShareDialog;
                    al alVar3 = result.f440386c;
                    Intrinsics.checkNotNullExpressionValue(alVar3, "result.currentAvatar");
                    avatarCommonOperateHelper.r(z16, alVar3, generalAvatarShareWithPicActionSheet, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$saveAvatarCharacter$1$onResultSuccess$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17) {
                            if (z17) {
                                QQToast.makeText(BaseApplication.getContext(), 2, "\u4fdd\u5b58\u6210\u529f", 0).show();
                            }
                        }
                    });
                    com.tencent.sqshow.zootopia.nativeui.data.j jVar5 = com.tencent.sqshow.zootopia.nativeui.data.j.this;
                    int i3 = saveSource;
                    al alVar4 = result.f440386c;
                    avatarCommonOperateHelper.s(jVar5, i3, (alVar4 == null || (azVarArr = alVar4.f440153b) == null) ? null : ArraysKt___ArraysKt.toList(azVarArr));
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), 1, result.f440385b, 0).show();
                Function1<Boolean, Unit> function12 = listener;
                if (function12 != null) {
                    function12.invoke(Boolean.FALSE);
                }
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                b94.e O3;
                QLog.d("AvatarBugStoreRepo", 1, " updateAvatarCharacter error " + error + ", msg = " + message);
                QQToast.makeText(BaseApplication.getContext(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
                Function1<Boolean, Unit> function1 = listener;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
                com.tencent.sqshow.zootopia.nativeui.data.j jVar = com.tencent.sqshow.zootopia.nativeui.data.j.this;
                if (jVar == null || (O3 = jVar.O()) == null) {
                    return;
                }
                O3.S2();
            }
        }, 0, 4, null);
    }

    public final void w(uv4.e[] items, com.tencent.sqshow.zootopia.nativeui.data.j channel, Function1<? super Boolean, Unit> listener) {
        int collectionSizeOrDefault;
        qu4.a E4;
        b94.d avatarDressController;
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (items == null) {
            return;
        }
        QLog.d("AvatarBugStoreRepo", 1, "buyStoreItem => " + Arrays.toString(items));
        Map<Integer, az> b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().b();
        ArrayList arrayList = new ArrayList();
        com.tencent.sqshow.zootopia.nativeui.data.l storeItemPool = channel.getStoreItemPool();
        Iterator<Map.Entry<Integer, az>> it = b16.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, az> next = it.next();
            if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.a(storeItemPool.b(next.getValue()), true)) {
                int length = items.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    uv4.e eVar = items[i3];
                    if (Intrinsics.areEqual(eVar.f440406d, next.getValue().B) && eVar.f440409g == 0) {
                        r15 = eVar;
                        break;
                    }
                    i3++;
                }
                if (r15 == null) {
                    arrayList.add(next.getValue());
                }
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((az) it5.next()).B);
        }
        QLog.d("AvatarBugStoreRepo", 1, "list ==> " + arrayList2);
        if (arrayList.isEmpty()) {
            E4 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().getAvatarCharacter();
        } else {
            b94.d avatarDressController2 = channel.getAvatarDressController();
            E4 = avatarDressController2 != null ? avatarDressController2.E4(arrayList2, com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b()) : null;
        }
        if ((!arrayList.isEmpty()) && (avatarDressController = channel.getAvatarDressController()) != null) {
            d.a.d(avatarDressController, arrayList, null, NormalDressStrategy.ONLY_OFF, null, 10, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AvatarBugStoreRepo", 1, "finalAvatar => " + (E4 != null ? r94.c.A(E4) : null));
            QLog.d("AvatarBugStoreRepo", 1, "currentDressMap => " + r94.c.z(b16));
        }
        t(channel, E4, channel.getEngineApi().getType() != AvatarEngineType.UE_SMALL_HOME, 1, listener);
    }

    public final void f(BuySource buySource, final com.tencent.sqshow.zootopia.nativeui.data.j channel, final List<CartGoodsData> data, int goldPrice, int silverPrice, final int gender, final com.tencent.mobileqq.zootopia.api.e<uv4.g> callback) {
        Intrinsics.checkNotNullParameter(buySource, "buySource");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (data == null) {
            return;
        }
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (!iZPlanApi.isNetworkAvailable(context)) {
            QLog.e("AvatarBugStoreRepo", 1, "network is doesn't work");
            callback.onResultFailure(-100, BaseApplication.getContext().getString(R.string.xrx));
            return;
        }
        com.tencent.sqshow.zootopia.data.f value = gb4.a.f401894a.b().getValue();
        IZPlanApi iZPlanApi2 = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context2 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        Activity activityFromContext = iZPlanApi2.getActivityFromContext(context2);
        if (activityFromContext == null) {
            activityFromContext = Foreground.getTopActivity();
        }
        Activity topActivity = activityFromContext;
        int l3 = value != null ? f371049a.l(value.getGoldCoin(), goldPrice, value.getSilverCoin(), silverPrice) : 2;
        boolean z16 = false;
        if ((value != null && value.getGoldCoinRet() == 0) && l3 == 0) {
            if (j()) {
                QLog.i("AvatarBugStoreRepo", 1, "enableDirectPay");
                final int goldCoin = goldPrice - value.getGoldCoin();
                if (goldCoin == goldPrice) {
                    q(channel, goldCoin, data, gender, callback);
                } else {
                    NativeUiDialogUtils nativeUiDialogUtils = NativeUiDialogUtils.f371177a;
                    Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
                    NativeUiDialogUtils.c(nativeUiDialogUtils, channel, topActivity, value.getGoldCoin(), goldCoin, false, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$buyStoreItem$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17) {
                            if (z17) {
                                AvatarCommonOperateHelper.f371049a.q(com.tencent.sqshow.zootopia.nativeui.data.j.this, goldCoin, data, gender, callback);
                            } else {
                                QLog.i("AvatarBugStoreRepo", 1, "cancel pay");
                            }
                        }
                    }, 16, null);
                }
                if (buySource == BuySource.SOURCE_EXPERIENCE_CARD) {
                    QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.xpj), 1).show();
                    b94.e O = channel.O();
                    if (O != null) {
                        O.S2();
                        return;
                    }
                    return;
                }
                callback.onResultFailure(-1001, BaseApplication.getContext().getString(R.string.xpj));
                return;
            }
            NativeUiDialogUtils nativeUiDialogUtils2 = NativeUiDialogUtils.f371177a;
            Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
            nativeUiDialogUtils2.d(channel, topActivity, false, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper$buyStoreItem$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    if (z17) {
                        AvatarCommonOperateHelper.f371049a.m();
                    }
                }
            });
            callback.onResultFailure(-1001, BaseApplication.getContext().getString(R.string.xpj));
            return;
        }
        if (value != null && value.getSilverCoinRet() == 0) {
            z16 = true;
        }
        if (z16 && l3 == 1) {
            callback.onResultFailure(-1002, BaseApplication.getContext().getString(R.string.xux));
        } else {
            h(data, channel, gender, callback);
        }
    }

    public static /* synthetic */ void u(AvatarCommonOperateHelper avatarCommonOperateHelper, com.tencent.sqshow.zootopia.nativeui.data.j jVar, qu4.a aVar, boolean z16, int i3, Function1 function1, int i16, Object obj) {
        qu4.a aVar2 = (i16 & 2) != 0 ? null : aVar;
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i16 & 8) != 0) {
            i3 = 2;
        }
        avatarCommonOperateHelper.t(jVar, aVar2, z17, i3, (i16 & 16) != 0 ? null : function1);
    }
}
