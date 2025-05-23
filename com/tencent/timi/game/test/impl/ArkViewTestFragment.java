package com.tencent.timi.game.test.impl;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.timi.game.test.impl.ArkViewTestFragment;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.b;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nr2.ay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0001*\u0018\u0000 02\u00020\u0001:\u0003123B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00070!j\b\u0012\u0004\u0012\u00020\u0007`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u00060&R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/timi/game/test/impl/ArkViewTestFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initView", "Bh", OcrConfig.CHINESE, "initData", "Lcom/tencent/ark/open/ArkView$InitInfo;", "vh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lnr2/ay;", BdhLogUtil.LogTag.Tag_Conn, "Lnr2/ay;", "binding", "Lcom/tencent/ark/open/ArkAppInfo$Size;", "D", "Lcom/tencent/ark/open/ArkAppInfo$Size;", "mMinSize", "E", "mMaxSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mData", "Lcom/tencent/timi/game/test/impl/ArkViewTestFragment$a;", "G", "Lcom/tencent/timi/game/test/impl/ArkViewTestFragment$a;", "adapter", "com/tencent/timi/game/test/impl/ArkViewTestFragment$e", "H", "Lcom/tencent/timi/game/test/impl/ArkViewTestFragment$e;", "mArkLoadCallback", "<init>", "()V", "I", "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ArkViewTestFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ay binding;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArkAppInfo.Size mMinSize = new ArkAppInfo.Size(0, 0);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArkAppInfo.Size mMaxSize = new ArkAppInfo.Size(360, 360);

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ArkView.InitInfo> mData = new ArrayList<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final a adapter = new a();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e mArkLoadCallback = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/test/impl/ArkViewTestFragment$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/test/impl/ArkViewTestFragment$c;", "Lcom/tencent/ark/open/ArkView;", "i0", "Landroid/view/ViewGroup;", "p0", "", "p1", "k0", "holder", "position", "", "j0", "getItemCount", "<init>", "(Lcom/tencent/timi/game/test/impl/ArkViewTestFragment;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class a extends RecyclerView.Adapter<c> {
        public a() {
        }

        private final ArkView i0() {
            ArkView arkView = new ArkView(ArkViewTestFragment.this.getContext(), null);
            arkView.setBorderType(0);
            return arkView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return ArkViewTestFragment.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull c holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.getView().load((ArkView.InitInfo) ArkViewTestFragment.this.mData.get(position), ArkViewTestFragment.this.mArkLoadCallback);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            return new c(i0());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/test/impl/ArkViewTestFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ark/open/ArkView;", "E", "Lcom/tencent/ark/open/ArkView;", "l", "()Lcom/tencent/ark/open/ArkView;", "view", "<init>", "(Lcom/tencent/ark/open/ArkView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ArkView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull ArkView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ArkView getView() {
            return this.view;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/test/impl/ArkViewTestFragment$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            parent.getChildAdapterPosition(view);
            outRect.top = b.a(24);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/test/impl/ArkViewTestFragment$e", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "state", "errCode", "", "msg", "", "canRetry", "", "onLoadFailed", "onLoadState", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements ArkViewImplement.LoadCallback {
        e() {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int state, int errCode, @Nullable String msg2, boolean canRetry) {
            l.e("ArkViewTestFragment_", "onLoadFailed state:" + state + ", errCode:" + errCode + ", msg:" + msg2 + ", canRetry:" + canRetry);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int state) {
            l.i("ArkViewTestFragment_", "onLoadState state:" + state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ah(String str, String str2, String str3) {
        l.i("ArkViewTestFragment_", "appName:" + str + ", eventName:" + str2 + ", params:" + str3);
        f.c("\u6536\u5230\u6765\u81eaArk\u7684\u901a\u77e5\uff1aappName:" + str + ", eventName:" + str2 + ", params:" + str3);
        return true;
    }

    private final void Bh() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", "100");
        jSONObject.put("type", "2");
        jSONObject.put("name", "\u591a\u4eba\u7ec4\u6392");
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.yes.fleetcard", "", "data_from_native", jSONObject.toString());
    }

    private final void initData() {
        for (int i3 = 0; i3 < 10; i3++) {
            this.mData.add(vh());
        }
    }

    private final void initView() {
        ay ayVar = this.binding;
        ay ayVar2 = null;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        ayVar.f420951b.setOnClickListener(new View.OnClickListener() { // from class: in4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArkViewTestFragment.wh(view);
            }
        });
        ay ayVar3 = this.binding;
        if (ayVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar3 = null;
        }
        ayVar3.f420954e.setOnClickListener(new View.OnClickListener() { // from class: in4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArkViewTestFragment.xh(ArkViewTestFragment.this, view);
            }
        });
        ay ayVar4 = this.binding;
        if (ayVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar4 = null;
        }
        ayVar4.f420953d.setOnClickListener(new View.OnClickListener() { // from class: in4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArkViewTestFragment.yh(ArkViewTestFragment.this, view);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        ay ayVar5 = this.binding;
        if (ayVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar5 = null;
        }
        ayVar5.f420952c.setLayoutManager(linearLayoutManager);
        ay ayVar6 = this.binding;
        if (ayVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar6 = null;
        }
        ayVar6.f420952c.setAdapter(this.adapter);
        ay ayVar7 = this.binding;
        if (ayVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ayVar2 = ayVar7;
        }
        ayVar2.f420952c.addItemDecoration(new d());
        zh();
        this.adapter.notifyDataSetChanged();
    }

    private final ArkView.InitInfo vh() {
        ArkView.InitInfo initInfo = new ArkView.InitInfo();
        initInfo.appID = "com.tencent.yes.fleetcard";
        initInfo.view = "fleetcard";
        initInfo.minVersion = "1.0.35.0";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("team_id", "7000636348760633499");
        jSONObject.put("destscene", "1");
        jSONObject.put("entryscene", "1");
        jSONObject.put("roomtype", "1");
        jSONObject.put("prompt", "\u5f00\u9ed1\u4ea4\u53cb\u5927\u5385");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(DownloadInfo.spKey_Config, jSONObject);
        initInfo.meta = jSONObject2.toString();
        return initInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(ArkViewTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ay ayVar = this$0.binding;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        ayVar.f420952c.requestLayout();
        this$0.adapter.notifyDataSetChanged();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(ArkViewTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Bh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void zh() {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.yes.fleetcard", new g() { // from class: in4.d
            @Override // com.tencent.mobileqq.ark.module.g
            public final boolean notify(String str, String str2, String str3) {
                boolean Ah;
                Ah = ArkViewTestFragment.Ah(str, str2, str3);
                return Ah;
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        l.b("ArkViewTestFragment_", "onCreate");
        super.onCreate(savedInstanceState);
        initData();
        QRouteApi api = QRoute.api(IArkEnvironment.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IArkEnvironment::class.java)");
        ((IArkEnvironment) api).initMultiProcEnv((IArkEnvDelegate) QRoute.api(IArkEnvDelegate.class), false);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        l.b("ArkViewTestFragment_", "onCreateView");
        ay g16 = ay.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        ConstraintLayout root = g16.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        l.b("ArkViewTestFragment_", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        initView();
    }
}
