package com.tencent.sqshow.zootopia.nativeui.view.detail;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b94.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.adv.web.RewardType;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaPortalGiftData;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarPanelAllData;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PortalStorePanelAllData;
import com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsSimpleInfoView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.state.report.SquareReportConst;
import i94.CollectInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressControllerInitData;
import m94.DressErrorMsg;
import mqq.app.Foreground;
import n74.u;
import org.json.JSONObject;
import uv4.ae;
import uv4.at;
import uv4.az;
import uv4.ba;
import uv4.bc;
import uv4.bf;
import w94.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 W2\u00020\u0001:\u0001XB/\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010T\u001a\u00020L\u0012\u0006\u0010:\u001a\u000203\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010$\u001a\u00020\u00042\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\b0!j\b\u0012\u0004\u0012\u00020\b`\"H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130&j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`'2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J,\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130&j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`'2\u0006\u00101\u001a\u00020\bH\u0002R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010CR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020F0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010GR6\u0010J\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180&j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0018`'0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010GR(\u0010N\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020L\u0012\u0006\u0012\u0004\u0018\u00010\u00120K0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010GR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010G\u00a8\u0006Y"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/GoodsDetailDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BaseDragPanelDialogView;", "Landroid/view/View;", "N", "", "onDismiss", "", "M", "Luv4/az;", "itemData", "o0", "J0", "p0", "storeItem", "x0", "", "dressUpStartTime", "", "", "", "B0", "w0", "Landroid/content/Context;", "context", "Luv4/ae;", "data", "K0", "q0", "h0", "E0", "O0", "r0", "v0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "subItems", "u0", "m0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "z0", "S0", "t0", QFSEdgeItem.KEY_AUTHOR_ID, "ugcId", "P0", "C0", "D0", "R0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "A0", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "y0", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", WadlProxyConsts.CHANNEL, "Ln74/u;", "K", "Ln74/u;", "dialogBinding", "Lw94/a;", "L", "Lw94/a;", "ugcVm", "Luv4/az;", "mData", "Landroidx/lifecycle/Observer;", "Li94/a;", "Landroidx/lifecycle/Observer;", "mCollectObserver", "P", "mUgcDataObserver", "Lkotlin/Pair;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mErrorDataObserver", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", BdhLogUtil.LogTag.Tag_Req, "mItemUpdateObserver", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", ExifInterface.LATITUDE_SOUTH, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class GoodsDetailDialogView extends BaseDragPanelDialogView {

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: K, reason: from kotlin metadata */
    private u dialogBinding;

    /* renamed from: L, reason: from kotlin metadata */
    private final w94.a ugcVm;

    /* renamed from: M, reason: from kotlin metadata */
    private az mData;

    /* renamed from: N, reason: from kotlin metadata */
    private final Observer<CollectInfo> mCollectObserver;

    /* renamed from: P, reason: from kotlin metadata */
    private final Observer<HashMap<String, ae>> mUgcDataObserver;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Observer<Pair<Integer, String>> mErrorDataObserver;

    /* renamed from: R, reason: from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.nativeui.data.l> mItemUpdateObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/GoodsDetailDialogView$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (itemPosition < (parent.getAdapter() != null ? r4.getNUM_BACKGOURND_ICON() : 0) - 1) {
                outRect.right = com.tencent.sqshow.zootopia.utils.i.b(8);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/GoodsDetailDialogView$c", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements m94.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ az f371638b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f371639c;

        c(az azVar, long j3) {
            this.f371638b = azVar;
            this.f371639c = j3;
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.i("GoodsDetailDialogView", 1, "dressOnOrOffClothes#onError errorMsg.code:" + errorMsg.getErrorCode() + " errorMsg.msg:" + errorMsg.getErrorMsg());
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("GoodsDetailDialogView", 1, "dressOnOrOffClothes onSuccess task.id=" + task.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
            VideoReport.reportEvent("ev_zplan_try_clothes_success", null, GoodsDetailDialogView.this.B0(this.f371638b, this.f371639c));
        }
    }

    public /* synthetic */ GoodsDetailDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    private final HashMap<String, Object> A0(az item) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_item_id", r94.b.K(item));
        String jsonElement = r94.b.J(item).toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "item.reportExtInfoJson().toString()");
        hashMap.put("zplan_ext_info", jsonElement);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> B0(az storeItem, long dressUpStartTime) {
        String h16;
        DressControllerInitData mInitData;
        ZootopiaSource source;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController == null || (mInitData = avatarDressController.getMInitData()) == null || (source = mInitData.getSource()) == null || (h16 = ah.b(source)) == null) {
            h16 = ZPlanAvatarPreDownloadManager.f371947a.h();
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, h16);
        hashMap.put("zplan_item_id", r94.b.K(storeItem));
        hashMap.put("zplan_gender", Integer.valueOf(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex()));
        hashMap.put("zplan_is_ai_sculpt", "0");
        hashMap.put("zplan_is_pre_download", Integer.valueOf(ZPlanAvatarPreDownloadManager.f371947a.k(r94.b.M(storeItem), storeItem.f440275b) ? 1 : 0));
        hashMap.put("zplan_use_times", String.valueOf(System.currentTimeMillis() - dressUpStartTime));
        hashMap.put("zplan_try_clothes_source", "avatar_mall_assemble_goods");
        return hashMap;
    }

    private final void C0() {
        this.dialogBinding.f419424g.setVisibility(8);
        this.dialogBinding.f419431n.setVisibility(0);
        this.dialogBinding.f419420c.setVisibility(0);
    }

    private final void D0() {
        this.dialogBinding.f419432o.d();
        this.dialogBinding.f419432o.setVisibility(8);
        this.dialogBinding.f419424g.setVisibility(8);
        this.dialogBinding.f419431n.setVisibility(0);
        this.dialogBinding.f419420c.setVisibility(0);
    }

    private final void E0(az itemData) {
        Activity attachedActivity;
        t74.o oVar = new t74.o();
        oVar.o(new GoodsDetailDialogView$launchAd$adHelper$1$1(this, itemData));
        ba baVar = itemData.f440288o;
        if (baVar.f440308i <= baVar.f440307h || (attachedActivity = this.channel.getAttachedActivity()) == null) {
            return;
        }
        this.dialogBinding.f419423f.setEnabled(false);
        int value = RewardType.SUPER_SHOW_FREE_ITEM.getValue();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_id", itemData.f440275b);
        Unit unit = Unit.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
        t74.o.m(oVar, attachedActivity, value, jSONObject2, 0, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(GoodsDetailDialogView this$0, CollectInfo collectInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        az azVar = this$0.mData;
        if (azVar == null) {
            return;
        }
        this$0.S0(azVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(GoodsDetailDialogView this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        az azVar = this$0.mData;
        if (azVar == null) {
            return;
        }
        bf bfVar = azVar.f440293t;
        long j3 = bfVar.f440328b;
        long j16 = bfVar.f440327a;
        this$0.D0();
        this$0.P0(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(GoodsDetailDialogView this$0, com.tencent.sqshow.zootopia.nativeui.data.l lVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        az azVar = this$0.mData;
        if (azVar == null) {
            return;
        }
        az b16 = lVar.b(azVar);
        if (Intrinsics.areEqual(b16, azVar)) {
            return;
        }
        QLog.i("GoodsDetailDialogView", 1, "mItemUpdateObserver data updated!");
        this$0.J0(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(GoodsDetailDialogView this$0, Context context, HashMap hashMap) {
        Set keySet;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        az azVar = this$0.mData;
        if (azVar == null) {
            return;
        }
        QLog.i("GoodsDetailDialogView", 1, "mUgcDataObserver on UGC data observer");
        bf bfVar = azVar.f440293t;
        long j3 = bfVar.f440328b;
        long j16 = bfVar.f440327a;
        this$0.D0();
        this$0.C0();
        String str = null;
        if (hashMap != null && (keySet = hashMap.keySet()) != null) {
            Iterator it = keySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(w94.a.INSTANCE.b(j3, j16), (String) obj)) {
                        break;
                    }
                }
            }
            String str2 = (String) obj;
            if (str2 != null) {
                ae data = (ae) hashMap.get(str2);
                if (data != null) {
                    Intrinsics.checkNotNullExpressionValue(data, "data");
                    this$0.K0(context, data, azVar);
                }
                str = str2;
            }
        }
        if (str != null) {
            return;
        }
        this$0.D0();
        this$0.P0(j3, j16);
    }

    private final void J0(az itemData) {
        this.mData = itemData;
        t0(itemData);
        m0(itemData);
        q0(itemData);
        v0(itemData);
        if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.f(itemData)) {
            w0(itemData);
        } else {
            p0(itemData);
        }
        r0(itemData);
        h0(itemData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(ISchemeApi schemeApi, Context context, ae data, GoodsDetailDialogView this$0, az itemData, View view) {
        Intrinsics.checkNotNullParameter(schemeApi, "$schemeApi");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        String str = data.f440120d;
        Intrinsics.checkNotNullExpressionValue(str, "data.authorJumpUrl");
        schemeApi.launchScheme(context, str);
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this$0.dialogBinding.f419434q;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "dialogBinding.tvItemAuthor");
        mReporter.e(zplanExcludeFontPaddingTextView, "em_zplan_item_detail_creator", this$0.A0(itemData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(ISchemeApi schemeApi, Context context, ae data, GoodsDetailDialogView this$0, az itemData, View view) {
        Intrinsics.checkNotNullParameter(schemeApi, "$schemeApi");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        String str = data.f440120d;
        Intrinsics.checkNotNullExpressionValue(str, "data.authorJumpUrl");
        schemeApi.launchScheme(context, str);
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this$0.dialogBinding.f419437t;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "dialogBinding.tvProductSum");
        mReporter.e(zplanExcludeFontPaddingTextView, "em_zplan_item_detail_creator_center", this$0.A0(itemData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(ISchemeApi schemeApi, Context context, ae data, GoodsDetailDialogView this$0, az itemData, View view) {
        Intrinsics.checkNotNullParameter(schemeApi, "$schemeApi");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        String str = data.f440120d;
        Intrinsics.checkNotNullExpressionValue(str, "data.authorJumpUrl");
        schemeApi.launchScheme(context, str);
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this$0.dialogBinding.f419437t;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "dialogBinding.tvProductSum");
        mReporter.e(zplanExcludeFontPaddingTextView, "em_zplan_item_detail_creator_center", this$0.A0(itemData));
    }

    private final void O0(az itemData) {
        ZplanViewReportHelper mReporter = this.channel.getReporter().getMReporter();
        Button button = this.dialogBinding.f419423f;
        Intrinsics.checkNotNullExpressionValue(button, "dialogBinding.btnRight");
        mReporter.e(button, "em_zplan_item_detail_purchase", A0(itemData));
    }

    private final void P0(final long authorId, final long ugcId) {
        this.dialogBinding.f419431n.setVisibility(8);
        this.dialogBinding.f419420c.setVisibility(8);
        this.dialogBinding.f419424g.setVisibility(0);
        this.dialogBinding.f419424g.f("\u54ce\u5440\uff0c\u52a0\u8f7d\u5931\u8d25\u4e86");
        this.dialogBinding.f419424g.b("\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u91cd\u8bd5");
        this.dialogBinding.f419424g.setRetryButtonText("\u91cd\u65b0\u52a0\u8f7d");
        this.dialogBinding.f419424g.setRetryButtonVisibility(true);
        this.dialogBinding.f419424g.setOnRetryButtonOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoodsDetailDialogView.Q0(GoodsDetailDialogView.this, authorId, ugcId, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(GoodsDetailDialogView this$0, long j3, long j16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ugcVm.N1(j3, j16);
        this$0.R0();
    }

    private final void R0() {
        this.dialogBinding.f419432o.setVisibility(0);
        this.dialogBinding.f419432o.c();
        this.dialogBinding.f419431n.setVisibility(8);
        this.dialogBinding.f419424g.setVisibility(8);
        this.dialogBinding.f419420c.setVisibility(8);
    }

    private final void S0(az itemData) {
        this.dialogBinding.f419421d.setBackgroundResource(g94.b.f401562a.i(itemData) ? R.drawable.im6 : R.drawable.im5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b6, code lost:
    
        if ((r0 != null && com.tencent.mobileqq.zootopia.utils.g.f(r0)) == false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h0(final az itemData) {
        final String str;
        MutableLiveData<PortalStorePanelAllData> e16;
        PortalStorePanelAllData value;
        at commonCfg;
        MutableLiveData<AvatarPanelAllData> b16;
        AvatarPanelAllData value2;
        at commonCfg2;
        boolean z16 = false;
        this.dialogBinding.f419422e.setVisibility((!itemData.f440285l || r94.b.y(itemData)) ? 8 : 0);
        this.dialogBinding.f419422e.setText("\u8d60\u9001");
        com.tencent.sqshow.zootopia.nativeui.data.repo.i dataController = this.channel.getDataController();
        if (dataController == null || (b16 = dataController.b()) == null || (value2 = b16.getValue()) == null || (commonCfg2 = value2.getCommonCfg()) == null || (str = commonCfg2.f440223a) == null) {
            com.tencent.sqshow.zootopia.nativeui.data.repo.p dataControllerV1 = this.channel.getDataControllerV1();
            str = (dataControllerV1 == null || (e16 = dataControllerV1.e()) == null || (value = e16.getValue()) == null || (commonCfg = value.getCommonCfg()) == null) ? null : commonCfg.f440223a;
            if (str == null) {
                str = "";
            }
        }
        this.dialogBinding.f419422e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoodsDetailDialogView.i0(az.this, str, this, view);
            }
        });
        if (itemData.f440295v > 0 && !com.tencent.sqshow.zootopia.nativeui.data.cart.b.e(itemData) && !r94.b.y(itemData)) {
            this.dialogBinding.f419423f.setText("\u5df2\u62e5\u6709");
            this.dialogBinding.f419423f.setEnabled(false);
        } else {
            bc bcVar = itemData.f440287n;
            if ((bcVar == null || com.tencent.mobileqq.zootopia.utils.g.g(bcVar)) ? false : true) {
                ba baVar = itemData.f440288o;
            }
            ba baVar2 = itemData.f440288o;
            if (baVar2 != null && baVar2.f440305f == 3) {
                z16 = true;
            }
            if (!z16) {
                this.dialogBinding.f419423f.setText("\u8d2d\u4e70");
                this.dialogBinding.f419423f.setEnabled(true);
                this.dialogBinding.f419423f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GoodsDetailDialogView.l0(GoodsDetailDialogView.this, itemData, view);
                    }
                });
            }
            ba baVar3 = itemData.f440288o;
            String str2 = baVar3 != null ? baVar3.f440303d : null;
            Button button = this.dialogBinding.f419423f;
            if (TextUtils.isEmpty(str2)) {
                str2 = "\u6d3b\u52a8\u83b7\u53d6";
            }
            button.setText(str2);
            this.dialogBinding.f419423f.setEnabled(true);
            this.dialogBinding.f419423f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GoodsDetailDialogView.j0(az.this, this, view);
                }
            });
        }
        HashMap<String, Object> A0 = A0(itemData);
        if (itemData.f440285l) {
            ZplanViewReportHelper mReporter = this.channel.getReporter().getMReporter();
            Button button2 = this.dialogBinding.f419422e;
            Intrinsics.checkNotNullExpressionValue(button2, "dialogBinding.btnLeft");
            mReporter.g(button2, "em_zplan_item_detail_give", (r16 & 4) != 0 ? null : A0, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        ZplanViewReportHelper mReporter2 = this.channel.getReporter().getMReporter();
        Button button3 = this.dialogBinding.f419423f;
        Intrinsics.checkNotNullExpressionValue(button3, "dialogBinding.btnRight");
        mReporter2.g(button3, "em_zplan_item_detail_purchase", (r16 & 4) != 0 ? null : A0, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(az itemData, String goldCoinIcon, GoodsDetailDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(goldCoinIcon, "$goldCoinIcon");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaPortalGiftData a16 = ZootopiaPortalGiftData.INSTANCE.a(itemData, goldCoinIcon);
        ta4.b bVar = ta4.b.f435764a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bVar.c(context, a16);
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        Button button = this$0.dialogBinding.f419422e;
        Intrinsics.checkNotNullExpressionValue(button, "dialogBinding.btnLeft");
        mReporter.e(button, "em_zplan_item_detail_give", this$0.A0(itemData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(az itemData, final GoodsDetailDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (r94.b.y(itemData)) {
            this$0.E0(itemData);
        } else if (!TextUtils.isEmpty(itemData.f440288o.f440302c)) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = itemData.f440288o.f440302c;
            Intrinsics.checkNotNullExpressionValue(str, "itemData.activity.activityUrl");
            iSchemeApi.launchScheme(context, str);
        } else {
            ba baVar = itemData.f440288o;
            boolean z16 = false;
            if (baVar != null && baVar.f440305f == 3) {
                z16 = true;
            }
            if (z16) {
                this$0.dialogBinding.getMRv().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        GoodsDetailDialogView.k0(GoodsDetailDialogView.this);
                    }
                });
            }
        }
        this$0.O0(itemData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(GoodsDetailDialogView this$0) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ga4.f dialogController = this$0.channel.getDialogController();
        ga4.j jVar = ga4.j.f401682a;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this$0.channel;
        Context context = this$0.dialogBinding.getMRv().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "dialogBinding.root.context");
        a16 = jVar.a(22, jVar2, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
        dialogController.e(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(GoodsDetailDialogView this$0, az itemData, View view) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = this$0.getMChannel();
        ga4.j jVar = ga4.j.f401682a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16 = jVar.a(2, mChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(itemData, null, null, null, null, 0, 62, null), (r22 & 16) != 0 ? false : false);
        a16.show();
        this$0.O0(itemData);
    }

    private final void m0(final az itemData) {
        S0(itemData);
        ZplanViewReportHelper mReporter = this.channel.getReporter().getMReporter();
        Button button = this.dialogBinding.f419421d;
        Intrinsics.checkNotNullExpressionValue(button, "dialogBinding.btnCollect");
        mReporter.g(button, "em_zplan_item_detail_keep", (r16 & 4) != 0 ? null : z0(itemData), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        this.dialogBinding.f419421d.setVisibility(itemData.L ? 8 : 0);
        Button button2 = this.dialogBinding.f419421d;
        Intrinsics.checkNotNullExpressionValue(button2, "dialogBinding.btnCollect");
        aa.b(button2, com.tencent.sqshow.zootopia.utils.i.b(10));
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            g94.b.f401562a.g().observe(lifecycleOwner, this.mCollectObserver);
        }
        Button button3 = this.dialogBinding.f419421d;
        Intrinsics.checkNotNullExpressionValue(button3, "dialogBinding.btnCollect");
        aa.e(button3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoodsDetailDialogView.n0(az.this, this, view);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(az itemData, GoodsDetailDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g94.b bVar = g94.b.f401562a;
        if (!bVar.i(itemData)) {
            bVar.d(itemData);
            b94.e O = this$0.getMChannel().O();
            if (O != null) {
                O.A2();
            }
        } else {
            bVar.b(itemData);
        }
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        Button button = this$0.dialogBinding.f419421d;
        Intrinsics.checkNotNullExpressionValue(button, "dialogBinding.btnCollect");
        mReporter.e(button, "em_zplan_item_detail_keep", this$0.z0(itemData));
    }

    private final void p0(az itemData) {
        ArrayList<az> arrayList = new ArrayList<>();
        az[] azVarArr = itemData.f440289p;
        if (azVarArr != null) {
            for (az azVar : azVarArr) {
                if (azVar.E) {
                    arrayList.add(azVar);
                }
            }
        }
        this.dialogBinding.f419437t.setText("\u5171\u5305\u542b" + arrayList.size() + "\u4ef6\u5546\u54c1");
        u0(arrayList);
    }

    private final void q0(az itemData) {
        this.dialogBinding.f419430m.G0(itemData);
    }

    private final void r0(final az itemData) {
        this.dialogBinding.f419426i.setVisibility(itemData.f440276c > 0 ? 0 : 8);
        this.dialogBinding.f419426i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoodsDetailDialogView.s0(az.this, this, view);
            }
        });
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.f159875if0);
        drawable.setBounds(new Rect(0, 0, com.tencent.sqshow.zootopia.utils.i.b(16), com.tencent.sqshow.zootopia.utils.i.b(16)));
        this.dialogBinding.f419438u.setCompoundDrawables(drawable, null, null, null);
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.dialogBinding.f419438u;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "dialogBinding.tvReport");
        zplanExcludeFontPaddingTextView.setCompoundDrawablePadding(com.tencent.sqshow.zootopia.utils.i.b(com.tencent.sqshow.zootopia.utils.i.b(1)));
        if (this.dialogBinding.f419426i.getVisibility() == 0) {
            HashMap<String, Object> A0 = A0(itemData);
            ZplanViewReportHelper mReporter = this.channel.getReporter().getMReporter();
            RelativeLayout relativeLayout = this.dialogBinding.f419426i;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "dialogBinding.layoutReport");
            mReporter.g(relativeLayout, "em_zplan_item_detail_report", (r16 & 4) != 0 ? null : A0, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(az itemData, GoodsDetailDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String reportUrl = itemData.f440293t.f440329c;
        if (TextUtils.isEmpty(reportUrl)) {
            reportUrl = "https://mweb.superqqshow.qq.com/app/ugcDress/reportCrime?" + itemData.f440276c;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(reportUrl, "reportUrl");
        iSchemeApi.launchScheme(context, reportUrl);
        HashMap<String, Object> A0 = this$0.A0(itemData);
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        RelativeLayout relativeLayout = this$0.dialogBinding.f419426i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "dialogBinding.layoutReport");
        mReporter.e(relativeLayout, "em_zplan_item_detail_report", A0);
    }

    private final void t0(az itemData) {
        this.dialogBinding.f419436s.setText(itemData.f440277d);
        String str = itemData.f440278e;
        if (str == null || str.length() == 0) {
            this.dialogBinding.f419435r.setVisibility(8);
        } else {
            this.dialogBinding.f419435r.setText(itemData.f440278e);
        }
        GoodsSimpleInfoView goodsSimpleInfoView = this.dialogBinding.f419425h;
        Intrinsics.checkNotNullExpressionValue(goodsSimpleInfoView, "dialogBinding.itemSimpleView");
        GoodsSimpleInfoView.c(goodsSimpleInfoView, itemData, false, null, 6, null);
    }

    private final void u0(ArrayList<az> subItems) {
        if (!subItems.isEmpty()) {
            QLog.i("GoodsDetailDialogView", 1, "bindSubItemList");
            az azVar = this.mData;
            boolean f16 = azVar != null ? com.tencent.sqshow.zootopia.nativeui.data.cart.b.f(azVar) : false;
            RecyclerView recyclerView = this.dialogBinding.f419429l;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            fa4.a aVar = new fa4.a(context, this.channel, f16);
            aVar.i0(subItems);
            recyclerView.setAdapter(aVar);
            return;
        }
        this.dialogBinding.f419429l.setVisibility(8);
        this.dialogBinding.f419437t.setVisibility(8);
    }

    private final void v0(az itemData) {
        this.dialogBinding.f419433p.f(itemData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w0(az itemData) {
        Set<String> keySet;
        this.dialogBinding.f419437t.setText("TA\u7684\u66f4\u591a\u4f5c\u54c1");
        this.dialogBinding.f419419b.setVisibility(0);
        bf bfVar = itemData.f440293t;
        long j3 = bfVar.f440328b;
        long j16 = bfVar.f440327a;
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            this.ugcVm.M1().observe(lifecycleOwner, this.mUgcDataObserver);
            this.ugcVm.L1().observe(lifecycleOwner, this.mErrorDataObserver);
        }
        HashMap<String, ae> value = this.ugcVm.M1().getValue();
        String str = null;
        if (value != null && (keySet = value.keySet()) != null) {
            Iterator<T> it = keySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(w94.a.INSTANCE.b(j3, j16), (String) next)) {
                    str = next;
                    break;
                }
            }
            str = str;
        }
        if (str == null || str.length() == 0) {
            this.ugcVm.N1(j3, j16);
            R0();
        }
    }

    private final void x0(az storeItem) {
        QLog.i("GoodsDetailDialogView", 1, "clickItem#doDressNewClothes - " + storeItem.f440274a + " - " + storeItem.f440277d);
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController != null ? avatarDressController.Kf(storeItem) : false) {
            QLog.i("GoodsDetailDialogView", 1, "clickItem#doDressNewClothes TaskRunning");
            return;
        }
        if (r94.b.x(storeItem, this.channel.l().getValue())) {
            QLog.i("GoodsDetailDialogView", 1, "clickItem#doDressNewClothes has dressed");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        b94.d avatarDressController2 = this.channel.getAvatarDressController();
        if (avatarDressController2 != null) {
            d.a.e(avatarDressController2, storeItem, new c(storeItem, currentTimeMillis), null, 4, null);
        }
    }

    private final HashMap<String, Object> z0(az itemData) {
        String str;
        HashMap<String, Object> A0 = A0(itemData);
        if (g94.b.f401562a.i(itemData)) {
            str = "1";
        } else {
            str = "0";
        }
        A0.put("zplan_keep_status", str);
        return A0;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean M() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView
    public View N() {
        RecyclerView recyclerView = this.dialogBinding.f419429l;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.dialogBinding.f419429l.addItemDecoration(new b());
        RelativeLayout mRv = this.dialogBinding.getMRv();
        Intrinsics.checkNotNull(mRv, "null cannot be cast to non-null type android.view.View");
        return mRv;
    }

    public void o0(az itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        x0(itemData);
        J0(itemData);
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        this.channel.getStoreItemPool().c().observe(lifecycleOwner, this.mItemUpdateObserver);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onDismiss() {
        super.onDismiss();
        this.channel.getStoreItemPool().c().removeObserver(this.mItemUpdateObserver);
        this.ugcVm.L1().removeObserver(this.mErrorDataObserver);
        this.ugcVm.M1().removeObserver(this.mUgcDataObserver);
        g94.b.f401562a.g().removeObserver(this.mCollectObserver);
    }

    public final void setChannel(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.channel = jVar;
    }

    /* renamed from: y0, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getChannel() {
        return this.channel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsDetailDialogView(final Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        w94.a a16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        u g16 = u.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n        LayoutI\u2026          (context)\n    )");
        this.dialogBinding = g16;
        if (this.channel.getAttachedActivity() instanceof FragmentActivity) {
            a.Companion companion = w94.a.INSTANCE;
            Activity attachedActivity = this.channel.getAttachedActivity();
            Intrinsics.checkNotNull(attachedActivity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            a16 = companion.a((FragmentActivity) attachedActivity);
        } else {
            Activity topActivity = Foreground.getTopActivity();
            Intrinsics.checkNotNull(topActivity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            a16 = w94.a.INSTANCE.a((FragmentActivity) topActivity);
        }
        this.ugcVm = a16;
        this.mCollectObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GoodsDetailDialogView.F0(GoodsDetailDialogView.this, (CollectInfo) obj);
            }
        };
        this.mUgcDataObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GoodsDetailDialogView.I0(GoodsDetailDialogView.this, context, (HashMap) obj);
            }
        };
        this.mErrorDataObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GoodsDetailDialogView.G0(GoodsDetailDialogView.this, (Pair) obj);
            }
        };
        this.mItemUpdateObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GoodsDetailDialogView.H0(GoodsDetailDialogView.this, (com.tencent.sqshow.zootopia.nativeui.data.l) obj);
            }
        };
    }

    private final void K0(final Context context, final ae data, final az itemData) {
        String string = context.getResources().getString(R.string.xli, data.f440118b);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.authorNickname\n        )");
        int color = context.getResources().getColor(R.color.f8336o);
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.dialogBinding.f419434q;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "dialogBinding.tvItemAuthor");
        m84.b.i(zplanExcludeFontPaddingTextView, string, color, 2, string.length());
        QRouteApi api = QRoute.api(ISchemeApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISchemeApi::class.java)");
        final ISchemeApi iSchemeApi = (ISchemeApi) api;
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = this.dialogBinding.f419434q;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView2, "dialogBinding.tvItemAuthor");
        aa.b(zplanExcludeFontPaddingTextView2, com.tencent.sqshow.zootopia.utils.i.b(5));
        this.dialogBinding.f419434q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoodsDetailDialogView.L0(ISchemeApi.this, context, data, this, itemData, view);
            }
        });
        this.dialogBinding.f419437t.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoodsDetailDialogView.M0(ISchemeApi.this, context, data, this, itemData, view);
            }
        });
        View view = this.dialogBinding.f419419b;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBinding.arrowRight");
        aa.b(view, com.tencent.sqshow.zootopia.utils.i.b(10));
        this.dialogBinding.f419419b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GoodsDetailDialogView.N0(ISchemeApi.this, context, data, this, itemData, view2);
            }
        });
        com.tencent.sqshow.zootopia.nativeui.data.l storeItemPool = this.channel.getStoreItemPool();
        az[] azVarArr = data.f440119c;
        Intrinsics.checkNotNullExpressionValue(azVarArr, "data.itemList");
        storeItemPool.d(azVarArr);
        ArrayList<az> arrayList = new ArrayList<>();
        az[] azVarArr2 = data.f440119c;
        Intrinsics.checkNotNullExpressionValue(azVarArr2, "data.itemList");
        for (az azVar : azVarArr2) {
            if (azVar.E) {
                arrayList.add(azVar);
            }
        }
        u0(arrayList);
        ZplanViewReportHelper mReporter = this.channel.getReporter().getMReporter();
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = this.dialogBinding.f419434q;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView3, "dialogBinding.tvItemAuthor");
        mReporter.g(zplanExcludeFontPaddingTextView3, "em_zplan_item_detail_creator", (r16 & 4) != 0 ? null : A0(itemData), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper mReporter2 = this.channel.getReporter().getMReporter();
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4 = this.dialogBinding.f419437t;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView4, "dialogBinding.tvProductSum");
        mReporter2.g(zplanExcludeFontPaddingTextView4, "em_zplan_item_detail_creator_center", (r16 & 4) != 0 ? null : A0(itemData), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }
}
