package com.tencent.sqshow.zootopia.nativeui.dialog.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.aigc.IZPlanAIGCHelper;
import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartGoodsData;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartStatus;
import com.tencent.sqshow.zootopia.nativeui.data.cart.PriceType;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Foreground;
import org.json.JSONObject;
import qv4.bi;
import qv4.bk;
import uv4.az;
import uv4.bc;
import uv4.bd;
import uv4.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 U2\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010@\u001a\u00020;\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001e\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001eH\u0002J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010+\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020*0\u0011J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u001c\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J&\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u00103\u001a\u00020\u0004J\u0019\u00105\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b5\u00106R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010@\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010G\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u00106R\u001b\u0010R\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\u00a8\u0006V"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/ShoppingCartControl;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "l", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "callback", "totalCount", "j", "Luv4/g;", "result", ReportConstant.COSTREPORT_PREFIX, "", "gender", "t", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "list", "u", "", "toastStr", "r", "Luv4/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Luv4/az;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "p", "store", "", "cartDataList", "g", "str", "", "success", "G", UserInfo.SEX_FEMALE, "storeItem", "i", "couponItem", tl.h.F, "Luv4/bd;", BdhLogUtil.LogTag.Tag_Conn, "v", "w", "Landroid/view/View;", "buyBtnView", HippyTKDListViewAdapter.X, "Lkotlin/Triple;", "k", "D", ISchemeApi.KEY_REFERER, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Landroid/content/Context;", "b", "Landroid/content/Context;", DomainData.DOMAIN_NAME, "()Landroid/content/Context;", "context", "c", "Z", "y", "()Z", "E", "(Z)V", "isInMod", "d", "I", "o", "()I", "setGender", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/l;", "e", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/l;", "silverErrorConfig", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;Landroid/content/Context;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ShoppingCartControl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isInMod;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int gender;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy silverErrorConfig;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371256a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f371257b;

        static {
            int[] iArr = new int[ZPlanAIGCStatusCode.values().length];
            try {
                iArr[ZPlanAIGCStatusCode.COIN_ENOUGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZPlanAIGCStatusCode.GOLD_COIN_NOT_ENOUGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f371256a = iArr;
            int[] iArr2 = new int[PriceType.values().length];
            try {
                iArr2[PriceType.GOAL_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PriceType.SILVER_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PriceType.GOAL_AND_SILVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f371257b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(ShoppingCartControl.this.p(((CartGoodsData) t16).getItemData()), ShoppingCartControl.this.p(((CartGoodsData) t17).getItemData()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(ShoppingCartControl.this.p(((CartGoodsData) t16).getItemData()), ShoppingCartControl.this.p(((CartGoodsData) t17).getItemData()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/views/ShoppingCartControl$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<uv4.c> {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ShoppingCartControl.this.z(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ShoppingCart_", 1, "request StoreItem failed -> " + error + " " + message);
            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.LOADING_FAIL);
        }
    }

    public ShoppingCartControl(com.tencent.sqshow.zootopia.nativeui.data.j channel, Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(context, "context");
        this.channel = channel;
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SilverNotEnoughConfig>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$silverErrorConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SilverNotEnoughConfig invoke() {
                return new SilverNotEnoughConfig(null, null, null, 7, null);
            }
        });
        this.silverErrorConfig = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        SilverNotEnoughConfig q16 = q();
        if (q16 != null) {
            t74.l.f435563a.d(new ShoppingCartControl$showSilverNotEnoughDialog$1$1(this, q16));
        }
    }

    private final void G(final String str, final boolean success) {
        com.tencent.zplan.luabridge.a aVar;
        QLog.i("ShoppingCart_", 1, "toast => " + str);
        if (this.isInMod) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg", str);
            if (t74.h.b()) {
                aVar = ZPlanServiceHelper.I.S();
            } else {
                aVar = ZPlanLuaBridge.INSTANCE;
            }
            com.tencent.zplan.luabridge.a aVar2 = aVar;
            if (aVar2 != null) {
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "params.toString()");
                a.C10063a.b(aVar2, "N2L_Toast", jSONObject2, null, 4, null);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.c
            @Override // java.lang.Runnable
            public final void run() {
                ShoppingCartControl.I(success, this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(boolean z16, ShoppingCartControl this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "$str");
        QQToast.makeText(this$0.context, z16 ? 2 : 1, str, 0).show();
    }

    private final void g(az store, List<CartGoodsData> cartDataList) {
        Iterator<CartGoodsData> it = cartDataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else {
                if (it.next().getItemData().f440274a == store.f440274a) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (i3 < 0) {
            cartDataList.add(new CartGoodsData(!com.tencent.sqshow.zootopia.nativeui.data.cart.b.e(store), CartGoodsData.INSTANCE.a(store), store, 0, 8, null));
        }
    }

    private final void j(com.tencent.mobileqq.zootopia.api.e<Long> callback, long totalCount) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ShoppingCartControl$buyCouponRequest$1(totalCount, callback, this, null), 3, null);
    }

    private final void l(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Activity topActivity = iZPlanApi.getActivityFromContext(context);
        if (topActivity == null) {
            topActivity = Foreground.getTopActivity();
        }
        NativeUiDialogUtils nativeUiDialogUtils = NativeUiDialogUtils.f371177a;
        Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
        nativeUiDialogUtils.d(channel, topActivity, false, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$doChargeGoldCoin$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    AvatarCommonOperateHelper.f371049a.m();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(az item) {
        if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.c(item, this.gender) && !com.tencent.sqshow.zootopia.nativeui.data.cart.b.e(item)) {
            be beVar = item.f440290q;
            return "0_" + (beVar != null ? beVar.f440324a : 0);
        }
        if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.e(item)) {
            be beVar2 = item.f440290q;
            return "1_" + (beVar2 != null ? beVar2.f440324a : 0);
        }
        if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.d(item, this.gender)) {
            be beVar3 = item.f440290q;
            return "3_" + (beVar3 != null ? beVar3.f440324a : 0);
        }
        be beVar4 = item.f440290q;
        return "4_" + (beVar4 != null ? beVar4.f440324a : 0);
    }

    private final SilverNotEnoughConfig q() {
        return (SilverNotEnoughConfig) this.silverErrorConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(uv4.g result) {
        QLog.d("ShoppingCart_", 1, "buy success " + Arrays.toString(result.f440421c));
        if (this.isInMod) {
            t(this.gender, result);
            return;
        }
        String string = this.context.getString(R.string.xm7);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.zplan_bug_success)");
        G(string, true);
        yb4.e.g(yb4.e.f450058a, "buySuc", 0, 2, null);
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        cVar.i().e(CartStatus.HIDE_LOADING_AND_DISMISS);
        cVar.r().e(Boolean.TRUE);
        AvatarCommonOperateHelper.f371049a.w(result.f440421c, this.channel, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleBuySucAction$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.i("ShoppingCart_", 1, "updateCurrentDressInfo succeed");
                PortalStoreCreateRoleBubbleHelper.f371421a.d();
            }
        });
    }

    private final void t(final int gender, final uv4.g result) {
        HashMap hashMapOf;
        String string = this.context.getString(R.string.xm7);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.zplan_bug_success)");
        G(string, true);
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.HIDE_LOADING);
        ArrayList arrayList = null;
        yb4.e.g(yb4.e.f450058a, "buySuc", 0, 2, null);
        az[] azVarArr = result.f440422d;
        if (azVarArr != null) {
            arrayList = new ArrayList(azVarArr.length);
            for (az it : azVarArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(r94.b.K(it));
            }
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_item_id", String.valueOf(arrayList)));
        NativeUiDialogUtils.f371177a.e(this.channel, this.context, hashMapOf, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleBuySucActionInMode$1
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

            public final void invoke(final boolean z16) {
                if (z16) {
                    com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.SHOW_LOADING);
                    ArrayList arrayList2 = new ArrayList();
                    uv4.e[] eVarArr = uv4.g.this.f440421c;
                    if (eVarArr != null) {
                        for (uv4.e eVar : eVarArr) {
                            if (eVar.f440409g == 0) {
                                bd bdVar = new bd();
                                bdVar.f440321b = eVar.f440404b;
                                bdVar.f440322c = eVar.f440405c;
                                bdVar.f440320a = eVar.f440403a;
                                bdVar.f440323d = eVar.f440406d;
                                arrayList2.add(bdVar);
                            }
                        }
                    }
                    AvatarCommonOperateHelper avatarCommonOperateHelper = AvatarCommonOperateHelper.f371049a;
                    int i3 = gender;
                    final ShoppingCartControl shoppingCartControl = this;
                    avatarCommonOperateHelper.o(i3, arrayList2, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleBuySucActionInMode$1.2
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
                            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.HIDE_LOADING_AND_DISMISS);
                            QLog.d("ShoppingCart_", 1, " new Dress " + z16);
                            ShoppingCartControl.H(shoppingCartControl, z17 ? "\u4fdd\u5b58\u6210\u529f" : "\u4fdd\u5b58\u5931\u8d25", false, 2, null);
                        }
                    });
                    return;
                }
                com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.HIDE_LOADING_AND_DISMISS);
            }
        });
    }

    private final void u(List<CartGoodsData> list) {
        int collectionSizeOrDefault;
        HashMap hashMapOf;
        final ArrayList arrayList = new ArrayList();
        for (CartGoodsData cartGoodsData : list) {
            if (!com.tencent.sqshow.zootopia.nativeui.data.cart.b.d(cartGoodsData.getItemData(), this.gender)) {
                bd bdVar = new bd();
                bdVar.f440321b = cartGoodsData.getItemData().f440275b;
                bdVar.f440322c = cartGoodsData.getItemData().f440276c;
                bdVar.f440320a = cartGoodsData.getItemData().f440274a;
                bdVar.f440323d = cartGoodsData.getItemData().B;
                arrayList.add(bdVar);
            }
        }
        if (arrayList.size() > 0) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(((bd) it.next()).f440321b));
            }
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_item_id", arrayList2.toString()));
            NativeUiDialogUtils.f371177a.e(this.channel, this.context, hashMapOf, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleChangeDress$2
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

                public final void invoke(final boolean z16) {
                    if (z16) {
                        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.SHOW_LOADING);
                        AvatarCommonOperateHelper avatarCommonOperateHelper = AvatarCommonOperateHelper.f371049a;
                        int gender = ShoppingCartControl.this.getGender();
                        List<bd> list2 = arrayList;
                        final ShoppingCartControl shoppingCartControl = ShoppingCartControl.this;
                        avatarCommonOperateHelper.o(gender, list2, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleChangeDress$2.1
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
                                com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.HIDE_LOADING_AND_DISMISS);
                                ShoppingCartControl.H(ShoppingCartControl.this, z17 ? "\u4fdd\u5b58\u6210\u529f" : "\u4fdd\u5b58\u5931\u8d25", false, 2, null);
                                QLog.d("ShoppingCart_", 1, " new Dress " + z16);
                            }
                        });
                    }
                }
            });
            return;
        }
        H(this, "\u6027\u522b\u4e0d\u7b26, \u65e0\u6cd5\u7a7f\u6234", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(uv4.c result) {
        com.tencent.sqshow.zootopia.nativeui.data.l y16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.y();
        az[] azVarArr = result.f440398a;
        Intrinsics.checkNotNullExpressionValue(azVarArr, "result.list");
        y16.d(azVarArr);
        ArrayList arrayList = new ArrayList();
        az[] azVarArr2 = result.f440398a;
        if (azVarArr2 != null) {
            for (az it : azVarArr2) {
                if (it.E) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(new CartGoodsData((com.tencent.sqshow.zootopia.nativeui.data.cart.b.e(it) || com.tencent.sqshow.zootopia.nativeui.data.cart.b.d(it, this.gender)) ? false : true, CartGoodsData.INSTANCE.a(it), it, 0, 8, null));
                }
            }
        }
        QLog.d("ShoppingCart_", 1, "request success -> " + arrayList);
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new d());
        }
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        cVar.I(arrayList);
        cVar.i().e(CartStatus.NORMAL);
    }

    public final void A(int referer) {
        String replace$default;
        gb4.a aVar = gb4.a.f401894a;
        bk value = aVar.e().getValue();
        if (value == null) {
            value = aVar.f();
        }
        Intrinsics.checkNotNullExpressionValue(value, "ZPlanTopTitleData.portal\u2026rtalTitleModelInfoCache()");
        bi biVar = value.f430079e;
        QLog.i("ShoppingCart_", 1, "jumpUrl : " + (biVar != null ? biVar.f430066a : null));
        bi biVar2 = value.f430079e;
        if (biVar2 != null) {
            String str = biVar2.f430066a;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "taskData.jumpUrl ?: \"\"");
            }
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "referer=1001", "referer=" + referer, false, 4, (Object) null);
            if (replace$default.length() == 0) {
                return;
            }
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(this.context, replace$default);
        }
    }

    public final void C(int gender, List<bd> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.gender = gender;
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.SHOW_SKELETON_LOADING);
        uv4.b bVar = new uv4.b();
        Object[] array = list.toArray(new bd[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.f440298a = (bd[]) array;
        bVar.f440299b = gender;
        QLog.d("ShoppingCart_", 1, "quert itemList -> " + bVar);
        va4.a.b(va4.a.f441274a, bVar, new e(), 0, 4, null);
    }

    public final void D() {
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        cVar.o().d();
        cVar.i().d();
    }

    public final void E(boolean z16) {
        this.isInMod = z16;
    }

    public final void i(int gender, az storeItem) {
        int collectionSizeOrDefault;
        this.gender = gender;
        ArrayList arrayList = new ArrayList();
        m94.a b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b();
        com.tencent.sqshow.zootopia.nativeui.data.l storeItemPool = this.channel.getStoreItemPool();
        for (Map.Entry<Integer, az> entry : b16.b().entrySet()) {
            if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.b(storeItemPool.b(entry.getValue()), false, 1, null)) {
                g(entry.getValue(), arrayList);
            }
        }
        if (storeItem != null) {
            List<String> g16 = r94.b.g(storeItem);
            for (CartGoodsData cartGoodsData : arrayList) {
                cartGoodsData.i(g16.contains(cartGoodsData.getItemData().B));
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new c());
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((CartGoodsData) it.next()).getItemData().f440275b));
        }
        QLog.d("ShoppingCart_", 1, "itemList => " + arrayList2);
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.I(arrayList);
    }

    public final Triple<Integer, Integer, Integer> k(List<CartGoodsData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (CartGoodsData cartGoodsData : list) {
            if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.c(cartGoodsData.getItemData(), this.gender) && cartGoodsData.getIsSelected()) {
                int count = cartGoodsData.getCount();
                bc bcVar = cartGoodsData.getItemData().f440287n;
                int i18 = bcVar != null ? bcVar.f440315d : 0;
                int i19 = cartGoodsData.getItemData().f440287n.f440316e;
                i17 += count;
                int i26 = b.f371257b[cartGoodsData.getPriceType().ordinal()];
                if (i26 != 1) {
                    if (i26 != 2) {
                        if (i26 != 3) {
                            QLog.e("ShoppingCart_", 1, "data.priceType invalid.");
                        } else {
                            i3 += i18 * count;
                        }
                    }
                    i16 += i19 * count;
                } else {
                    i3 += i18 * count;
                }
            }
        }
        return new Triple<>(Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    /* renamed from: m, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getChannel() {
        return this.channel;
    }

    /* renamed from: n, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: o, reason: from getter */
    public final int getGender() {
        return this.gender;
    }

    public final void v() {
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        PriceType b16 = cVar.o().b();
        PriceType priceType = PriceType.GOAL_FIRST;
        if (b16 == priceType) {
            cVar.o().e(PriceType.SILVER_FIRST);
        } else {
            cVar.o().e(priceType);
        }
    }

    public final void x(View buyBtnView, com.tencent.mobileqq.zootopia.api.e<Long> callback) {
        Intrinsics.checkNotNullParameter(buyBtnView, "buyBtnView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<CartGoodsData> value = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.h().getValue();
        Triple<Integer, Integer, Integer> k3 = value != null ? k(value) : null;
        int intValue = k3 != null ? k3.getFirst().intValue() : 0;
        int intValue2 = k3 != null ? k3.getSecond().intValue() : 0;
        long intValue3 = k3 != null ? k3.getThird().intValue() : 0L;
        ((IZPlanAIGCHelper) QRoute.api(IZPlanAIGCHelper.class)).reportZPlanAIGCCouponBuyClick(buyBtnView, intValue3, intValue);
        ZPlanAIGCStatusCode i3 = AvatarCommonOperateHelper.f371049a.i(this.channel, intValue, intValue2);
        QLog.i("ShoppingCart_", 1, "handleClickBuyCouponButton, totalGold: " + intValue + ", totalSilver: " + intValue2 + ", coinStatus: " + i3);
        int i16 = b.f371256a[i3.ordinal()];
        if (i16 == 1) {
            j(callback, intValue3);
            return;
        }
        if (i16 != 2) {
            H(this, i3.getMessage(), false, 2, null);
            callback.onResultFailure(-100, i3.getMessage());
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.xpj), 1).show();
            callback.onResultFailure(-100, "gold coin not enough.");
            l(this.channel);
        }
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsInMod() {
        return this.isInMod;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0013, code lost:
    
        r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w() {
        ArrayList arrayList;
        int i3;
        int i16;
        List mutableList;
        List<CartGoodsData> value = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.h().getValue();
        if (value == null || mutableList == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : mutableList) {
                CartGoodsData cartGoodsData = (CartGoodsData) obj;
                if (cartGoodsData.getIsSelected() && com.tencent.sqshow.zootopia.nativeui.data.cart.b.c(cartGoodsData.getItemData(), this.gender)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((CartGoodsData) obj2).getPriceType() == PriceType.GOAL_FIRST) {
                    arrayList3.add(obj2);
                }
            }
            i3 = arrayList3.size();
        } else {
            i3 = 0;
        }
        Triple<Integer, Integer, Integer> k3 = value != null ? k(value) : null;
        int intValue = k3 != null ? k3.getFirst().intValue() : 0;
        int intValue2 = k3 != null ? k3.getSecond().intValue() : 0;
        if ((k3 != null ? k3.getThird().intValue() : 0) > 0) {
            if (i3 > 12) {
                String string = this.context.getResources().getString(R.string.f169820xs2);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026R.string.zplan_over_nums)");
                H(this, string, false, 2, null);
                return;
            } else {
                QLog.d("ShoppingCart_", 1, " click buy button " + k3);
                com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.SHOW_LOADING);
                AvatarCommonOperateHelper.f371049a.f(AvatarCommonOperateHelper.BuySource.SOURCE_SHOPPING_CART, this.channel, arrayList, intValue, intValue2, this.gender, new com.tencent.mobileqq.zootopia.api.e<uv4.g>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleClickBuyButton$1
                    @Override // com.tencent.mobileqq.zootopia.api.e
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onResultSuccess(final uv4.g result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        final ShoppingCartControl shoppingCartControl = ShoppingCartControl.this;
                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleClickBuyButton$1$onResultSuccess$1
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
                                uv4.g gVar = uv4.g.this;
                                QLog.i("ShoppingCart_", 1, "buy resp,errorCode= " + gVar.f440419a + ", items : " + Arrays.toString(gVar.f440421c));
                                com.tencent.sqshow.zootopia.nativeui.data.l storeItemPool = shoppingCartControl.getChannel().getStoreItemPool();
                                az[] azVarArr = uv4.g.this.f440422d;
                                Intrinsics.checkNotNullExpressionValue(azVarArr, "result.storeItems");
                                storeItemPool.d(azVarArr);
                                uv4.g gVar2 = uv4.g.this;
                                if (gVar2.f440419a == 0) {
                                    uv4.e[] eVarArr = gVar2.f440421c;
                                    Intrinsics.checkNotNullExpressionValue(eVarArr, "result.items");
                                    if (!(eVarArr.length == 0)) {
                                        shoppingCartControl.s(uv4.g.this);
                                        return;
                                    }
                                }
                                ShoppingCartControl shoppingCartControl2 = shoppingCartControl;
                                String str = uv4.g.this.f440420b;
                                Intrinsics.checkNotNullExpressionValue(str, "result.errMsg");
                                shoppingCartControl2.r(str);
                            }
                        });
                    }

                    @Override // com.tencent.mobileqq.zootopia.api.e
                    public void onResultFailure(final int error, final String message) {
                        final ShoppingCartControl shoppingCartControl = ShoppingCartControl.this;
                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl$handleClickBuyButton$1$onResultFailure$1
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

                            /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
                            
                                if ((r0.length() > 0) == true) goto L29;
                             */
                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0047, code lost:
                            
                                if ((r0.length() > 0) == true) goto L13;
                             */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke2() {
                                boolean z16 = true;
                                QLog.e("ShoppingCart_", 1, "onResultFailure " + error + ", " + message);
                                com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.HIDE_LOADING);
                                int i17 = error;
                                if (i17 == -1001) {
                                    String str = message;
                                    if (str != null) {
                                    }
                                    z16 = false;
                                    if (z16) {
                                        ShoppingCartControl.H(shoppingCartControl, message, false, 2, null);
                                        return;
                                    }
                                    return;
                                }
                                if (i17 == -1002) {
                                    shoppingCartControl.F();
                                    return;
                                }
                                if (i17 == -100) {
                                    String str2 = message;
                                    if (str2 != null) {
                                    }
                                    z16 = false;
                                    if (z16) {
                                        ShoppingCartControl.H(shoppingCartControl, message, false, 2, null);
                                        return;
                                    }
                                    return;
                                }
                                ShoppingCartControl shoppingCartControl2 = shoppingCartControl;
                                String string2 = shoppingCartControl2.getContext().getResources().getString(R.string.xm6);
                                Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026.string.zplan_bug_failed)");
                                shoppingCartControl2.r(string2);
                            }
                        });
                    }
                });
                return;
            }
        }
        if (value != null) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : value) {
                CartGoodsData cartGoodsData2 = (CartGoodsData) obj3;
                if (cartGoodsData2.getItemData().f440295v > 0 || com.tencent.sqshow.zootopia.nativeui.data.cart.b.d(cartGoodsData2.getItemData(), this.gender)) {
                    arrayList4.add(obj3);
                }
            }
            i16 = arrayList4.size();
        } else {
            i16 = 0;
        }
        if (this.isInMod && value != null && i16 == value.size()) {
            u(value);
        } else {
            H(this, "\u81f3\u5c11\u9009\u62e9\u4e00\u4e2a\u88c5\u626e", false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String toastStr) {
        List<bd> emptyList;
        int collectionSizeOrDefault;
        H(this, toastStr, false, 2, null);
        yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        cVar.i().e(CartStatus.SHOW_SKELETON_LOADING);
        List<CartGoodsData> value = cVar.h().getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<CartGoodsData> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList<>(collectionSizeOrDefault);
            for (CartGoodsData cartGoodsData : list) {
                bd bdVar = new bd();
                bdVar.f440320a = cartGoodsData.getItemData().f440274a;
                bdVar.f440321b = cartGoodsData.getItemData().f440275b;
                bdVar.f440322c = cartGoodsData.getItemData().f440276c;
                bdVar.f440323d = cartGoodsData.getItemData().B;
                emptyList.add(bdVar);
            }
        }
        C(this.gender, emptyList);
    }

    public final void h(az couponItem) {
        if (couponItem == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        g(couponItem, arrayList);
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.I(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void H(ShoppingCartControl shoppingCartControl, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        shoppingCartControl.G(str, z16);
    }

    public static /* synthetic */ void B(ShoppingCartControl shoppingCartControl, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 2001;
        }
        shoppingCartControl.A(i3);
    }
}
