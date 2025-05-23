package com.tencent.mobileqq.troop.troopidentity.parts;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityTitleInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityTitleHostPart;", "Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "", "Q9", "Landroid/view/View$OnClickListener;", "L9", "R9", "N9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "E9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/troop/troopidentity/configs/a;", "e", "Lcom/tencent/mobileqq/troop/troopidentity/configs/a;", "titleCustomConfig", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/troop/troopidentity/view/b;", tl.h.F, "Lcom/tencent/mobileqq/troop/troopidentity/view/b;", "titleAdapter", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "levelTipTextView", "Landroid/content/IntentFilter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/IntentFilter;", "intentFilter", "Landroid/content/BroadcastReceiver;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/BroadcastReceiver;", "receiver", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityTitleHostPart extends TroopIdentityIconBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final BroadcastReceiver receiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopidentity.configs.a<View> titleCustomConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopidentity.view.b titleAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView levelTipTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IntentFilter intentFilter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityTitleHostPart$a;", "", "", "EVENT_TITLE_RICH_UPDATE", "Ljava/lang/String;", "TAG", "TITLE_VIP_ICON", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityTitleHostPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityTitleHostPart$b", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends GridLayoutManager {
        static IPatchRedirector $redirector_;

        b(Context context) {
            super(context, 3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57806);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityTitleHostPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.intentFilter = new IntentFilter("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
            this.receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityTitleHostPart$receiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopIdentityTitleHostPart.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    String stringExtra;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (intent != null && (stringExtra = intent.getStringExtra(AdMetricTag.EVENT_NAME)) != null) {
                        String stringExtra2 = intent.getStringExtra("data");
                        String str = "";
                        if (stringExtra2 == null) {
                            stringExtra2 = "";
                        }
                        QLog.i("TroopIdentityTitleHostPart", 1, "[receiver] event = " + stringExtra + " jsonData = " + stringExtra2);
                        if (Intrinsics.areEqual(stringExtra, "titleRichUpdate")) {
                            try {
                                JSONObject jSONObject = new JSONObject(stringExtra2);
                                String optString = jSONObject.optString("troopUin");
                                if (optString == null) {
                                    optString = "";
                                }
                                String optString2 = jSONObject.optString("memberUin");
                                if (optString2 != null) {
                                    str = optString2;
                                }
                                int optInt = jSONObject.optInt("richFlag");
                                if (Intrinsics.areEqual(optString, TroopIdentityTitleHostPart.this.A9().g2()) && Intrinsics.areEqual(str, TroopIdentityTitleHostPart.this.A9().c2())) {
                                    TroopIdentityTitleHostPart.this.A9().r2(optInt);
                                }
                            } catch (Exception e16) {
                                QLog.e("TroopIdentityTitleHostPart", 1, "[onReceive] exception = " + e16);
                            }
                        }
                    }
                }
            };
        }
    }

    private final View.OnClickListener L9() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIdentityTitleHostPart.M9(TroopIdentityTitleHostPart.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(TroopIdentityTitleHostPart this$0, View view) {
        Unit unit;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).jumpToVasTroopHonorUrl(context, this$0.A9().g2());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("TroopIdentityTitleHostPart", 1, "[JumpToVasTroopHonorUrl] context is null. troopUin = " + this$0.A9().g2());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9() {
        LiveData<GetIdentityListRsp> Z1 = A9().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GetIdentityListRsp, Unit> function1 = new Function1<GetIdentityListRsp, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityTitleHostPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityTitleHostPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetIdentityListRsp getIdentityListRsp) {
                invoke2(getIdentityListRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GetIdentityListRsp getIdentityListRsp) {
                com.tencent.mobileqq.troop.troopidentity.view.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getIdentityListRsp);
                    return;
                }
                ArrayList<GroupIdentityTitleInfo> arrayList = getIdentityListRsp.titles;
                Intrinsics.checkNotNullExpressionValue(arrayList, "it.titles");
                bVar = TroopIdentityTitleHostPart.this.titleAdapter;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleAdapter");
                    bVar = null;
                }
                bVar.m0(arrayList);
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityTitleHostPart.P9(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> h26 = A9().h2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit> function12 = new Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityTitleHostPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityTitleHostPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
            
                if (r5.f300595f == true) goto L35;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                TextView textView;
                boolean z16;
                ArrayList<GroupIdentityTitleInfo> arrayList;
                com.tencent.mobileqq.troop.troopidentity.view.b bVar;
                com.tencent.mobileqq.troop.troopidentity.view.b bVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                    return;
                }
                TextView textView2 = null;
                com.tencent.mobileqq.troop.troopidentity.view.b bVar3 = null;
                if (cVar instanceof c.d) {
                    bVar2 = TroopIdentityTitleHostPart.this.titleAdapter;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleAdapter");
                    } else {
                        bVar3 = bVar2;
                    }
                    bVar3.m0(((c.d) cVar).b());
                    return;
                }
                if (cVar instanceof c.C8816c) {
                    GetIdentityListRsp value = TroopIdentityTitleHostPart.this.A9().Z1().getValue();
                    if (value != null && (arrayList = value.titles) != null) {
                        bVar = TroopIdentityTitleHostPart.this.titleAdapter;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("titleAdapter");
                            bVar = null;
                        }
                        bVar.m0(arrayList);
                    }
                    textView = TroopIdentityTitleHostPart.this.levelTipTextView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("levelTipTextView");
                    } else {
                        textView2 = textView;
                    }
                    com.tencent.mobileqq.troop.troopmemberlevel.a a16 = ((c.C8816c) cVar).a();
                    if (a16 != null) {
                        z16 = true;
                    }
                    z16 = false;
                    textView2.setVisibility(z16 ? 0 : 8);
                }
            }
        };
        h26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityTitleHostPart.O9(Function1.this, obj);
            }
        });
        try {
            Context context = getContext();
            if (context != null) {
                context.registerReceiver(this.receiver, this.intentFilter);
            }
        } catch (Exception e16) {
            QLog.e("TroopIdentityTitleHostPart", 1, "[registerReceiver] exception = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x005d, code lost:
    
        if (r4.f300595f == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Q9() {
        boolean z16;
        com.tencent.mobileqq.troop.troopidentity.view.b bVar = null;
        View rootView = View.inflate(getContext(), R.layout.hzl, null);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.kyu);
        TroopIdentityHonorUtil troopIdentityHonorUtil = TroopIdentityHonorUtil.f300410a;
        Intrinsics.checkNotNullExpressionValue(imageView, "this");
        troopIdentityHonorUtil.i(imageView, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9170/qecommerce_group_svip_9170.png");
        ((RelativeLayout) rootView.findViewById(R.id.f102175x7)).setOnClickListener(L9());
        View findViewById = rootView.findViewById(R.id.f166217z20);
        TextView textView = (TextView) findViewById;
        com.tencent.mobileqq.troop.troopidentity.util.a.e(z9(), "em_group_level_detailsl", null, 2, null);
        textView.setOnClickListener(R9());
        com.tencent.mobileqq.troop.troopmemberlevel.a a26 = A9().a2();
        int i3 = 0;
        if (a26 != null) {
            z16 = true;
        }
        z16 = false;
        if (!z16) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Te\u2026 else View.GONE\n        }");
        this.levelTipTextView = textView;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.f102645yg);
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.AllRound;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        linearLayout.setBackground(qUIListItemBackgroundType.getBackground(activity, 1000));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.titleAdapter = new com.tencent.mobileqq.troop.troopidentity.view.b(context, A9());
        View findViewById2 = rootView.findViewById(R.id.f102275xg);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new b(recyclerView.getContext()));
        recyclerView.setItemAnimator(null);
        com.tencent.mobileqq.troop.troopidentity.view.b bVar2 = this.titleAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleAdapter");
        } else {
            bVar = bVar2;
        }
        recyclerView.setAdapter(bVar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Re\u2026 = titleAdapter\n        }");
        this.recyclerView = recyclerView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        this.titleCustomConfig = new com.tencent.mobileqq.troop.troopidentity.configs.a<>(rootView);
    }

    private final View.OnClickListener R9() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIdentityTitleHostPart.S9(TroopIdentityTitleHostPart.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(TroopIdentityTitleHostPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QRoute.createNavigator(this$0.getActivity(), RouterConstants.UI_ROUTE_BROWSER).withString("url", "https://qun.qq.com/interactive/mylevel?gc=" + this$0.A9().g2() + "&_wv=3&_wwv=128&_wvx=2&_wvxBclr=f4f5f9").request();
        com.tencent.mobileqq.troop.troopidentity.util.a.c(this$0.z9(), "em_group_level_detailsl", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityIconBasePart
    @NotNull
    public Group[] E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Group[] groupArr = new Group[1];
        Group.Companion companion = Group.INSTANCE;
        com.tencent.mobileqq.widget.listitem.a<?>[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        com.tencent.mobileqq.troop.troopidentity.configs.a<View> aVar = this.titleCustomConfig;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleCustomConfig");
            aVar = null;
        }
        aVarArr[0] = aVar;
        groupArr[0] = companion.c("\u9009\u62e9\u5934\u8854\u548c\u7fa4\u6807\u8bc6", aVarArr);
        return groupArr;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Q9();
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        try {
            Context context = getContext();
            if (context != null) {
                context.unregisterReceiver(this.receiver);
            }
        } catch (Exception e16) {
            QLog.e("TroopIdentityTitleHostPart", 1, "[unregisterReceiver] exception = " + e16);
        }
    }
}
