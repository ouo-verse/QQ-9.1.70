package com.tencent.mobileqq.troop.troopinfoedit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.pb.troop.bindgame.GCBindGroup$GCBindGroupSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\bF\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0006R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010#RN\u00108\u001a:\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u000103j\u0004\u0018\u0001`68\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=RT\u0010E\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u0006\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00107\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameItemHelper;", "", "", "gameBindStatus", "", "gameName", "", HippyTKDListViewAdapter.X, "w", "u", "Lcom/tencent/pb/troop/bindgame/GCBindGroup$GCBindGroupSsoServerRsp;", "rsp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "iconType", "", "msg", "t", "Landroid/view/View;", "l", "o", "Landroid/view/View$OnClickListener;", h.F, "", "isVisible", ReportConstant.COSTREPORT_PREFIX, "j", "k", "p", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "troopUin", "c", "Landroid/view/View;", "gameBindView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleTv", "e", "infoTv", "f", "I", "g", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameStatusUpdateCallback;", "Lkotlin/jvm/functions/Function2;", "statusUpdateCallback", "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameVM;", "i", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameVM;", "viewModel", "title", SecretUtils.DES, "getOnFetchGameInfoCallback", "()Lkotlin/jvm/functions/Function2;", "r", "(Lkotlin/jvm/functions/Function2;)V", "onFetchGameInfoCallback", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGameItemHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final Map<String, Pair<Integer, String>> f300449l;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View gameBindView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView infoTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int gameBindStatus;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String gameName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super String, ? super Integer, Unit> statusUpdateCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super String, ? super String, Unit> onFetchGameInfoCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR,\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameItemHelper$a;", "", "", "troopUin", "Lkotlin/Pair;", "", "a", "gameBindStatus", "gameName", "", "b", "TAG", "Ljava/lang/String;", "", "gameBindCache", "Ljava/util/Map;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final Pair<Integer, String> a(@Nullable String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
            }
            if (troopUin == null) {
                return null;
            }
            return (Pair) TroopBindGameItemHelper.f300449l.get(troopUin);
        }

        public final void b(@Nullable String troopUin, int gameBindStatus, @NotNull String gameName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, troopUin, Integer.valueOf(gameBindStatus), gameName);
                return;
            }
            Intrinsics.checkNotNullParameter(gameName, "gameName");
            if (troopUin == null) {
                return;
            }
            TroopBindGameItemHelper.f300449l.put(troopUin, new Pair(Integer.valueOf(gameBindStatus), gameName));
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopinfoedit/TroopBindGameItemHelper$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "gameName", "", "gameBindStatus", "", "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameStatusUpdateCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Function2<String, Integer, Unit> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBindGameItemHelper.this);
            }
        }

        public void a(@NotNull String gameName, int gameBindStatus) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gameName, gameBindStatus);
                return;
            }
            Intrinsics.checkNotNullParameter(gameName, "gameName");
            TroopBindGameItemHelper.this.gameBindStatus = gameBindStatus;
            TroopBindGameItemHelper.this.gameName = gameName;
            TroopBindGameItemHelper.INSTANCE.b(TroopBindGameItemHelper.this.m(), gameBindStatus, gameName);
            TroopBindGameItemHelper.this.x(gameBindStatus, gameName);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
            a(str, num.intValue());
            return Unit.INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57907);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
            f300449l = new LinkedHashMap();
        }
    }

    public TroopBindGameItemHelper(@NotNull Context context, @NotNull String troopUin) {
        int i3;
        Lazy lazy;
        String second;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) troopUin);
            return;
        }
        this.context = context;
        this.troopUin = troopUin;
        Companion companion = INSTANCE;
        Pair<Integer, String> a16 = companion.a(troopUin);
        if (a16 != null) {
            i3 = a16.getFirst().intValue();
        } else {
            i3 = 0;
        }
        this.gameBindStatus = i3;
        Pair<Integer, String> a17 = companion.a(troopUin);
        this.gameName = (a17 == null || (second = a17.getSecond()) == null) ? "" : second;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopBindGameVM>() { // from class: com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBindGameItemHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopBindGameVM invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new TroopBindGameVM(TroopBindGameItemHelper.this.m()) : (TroopBindGameVM) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TroopBindGameItemHelper this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.gameBindStatus == 1) {
            this$0.u();
        } else {
            QRouteApi api = QRoute.api(ITroopLinkApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(\n                ITr\u2026:class.java\n            )");
            String str = ((ITroopLinkApi) api).getUrl("troop_bind_game") + "&groupid=" + this$0.troopUin;
            Intent intent = new Intent(this$0.context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, this$0.context.getString(R.string.i7o));
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", str);
            this$0.context.startActivity(intent);
            eu.g("Grp_game", "Manage_grp", "bind_clk", 0, 0, this$0.troopUin);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final TroopBindGameVM n() {
        return (TroopBindGameVM) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(GCBindGroup$GCBindGroupSsoServerRsp rsp) {
        ArrayList<String> arrayListOf;
        int i3 = rsp.ret.get();
        if (i3 != 0) {
            String string = this.context.getString(R.string.uix);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.qqstr_troopman_0fe19e96)");
            t(1, string);
        } else {
            String string2 = this.context.getString(R.string.ujd);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026.qqstr_troopman_6da66f0b)");
            t(2, string2);
            this.gameBindStatus = 2;
            this.gameName = "";
            INSTANCE.b(this.troopUin, 2, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", 0);
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.troopUin);
            jSONObject.put("name", "");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("*.qq.com");
            c.f300471a.a("bindGames", jSONObject, arrayListOf, null);
        }
        QLog.i("TroopBindGameItemHelper", 1, "[onUnBindGameTroop] troopUin = " + this.troopUin + " ret = " + i3);
    }

    private final void t(int iconType, CharSequence msg2) {
        QQToast.makeText(this.context, iconType, msg2, 0).show();
    }

    private final void u() {
        Dialog createDialog = ActionSheetHelper.createDialog(this.context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(this.context.getString(R.string.i7r));
        actionSheet.addButton(R.string.i7s, 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopinfoedit.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopBindGameItemHelper.v(ActionSheet.this, this, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ActionSheet actionSheet, final TroopBindGameItemHelper this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        actionSheet.dismiss();
        if (i3 == 0) {
            if (!NetworkUtil.isNetworkAvailable()) {
                String string = this$0.context.getString(R.string.uix);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.qqstr_troopman_0fe19e96)");
                this$0.t(1, string);
                return;
            }
            this$0.n().Q1(this$0.troopUin, new Function1<GCBindGroup$GCBindGroupSsoServerRsp, Unit>() { // from class: com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper$showUnBindActionSheet$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBindGameItemHelper.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GCBindGroup$GCBindGroupSsoServerRsp gCBindGroup$GCBindGroupSsoServerRsp) {
                    invoke2(gCBindGroup$GCBindGroupSsoServerRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GCBindGroup$GCBindGroupSsoServerRsp rsp) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                    } else {
                        Intrinsics.checkNotNullParameter(rsp, "rsp");
                        TroopBindGameItemHelper.this.q(rsp);
                    }
                }
            });
        }
    }

    private final void w() {
        if (this.statusUpdateCallback == null) {
            b bVar = new b();
            this.statusUpdateCallback = bVar;
            n().P1(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int gameBindStatus, String gameName) {
        String str = "";
        if (gameBindStatus != 0) {
            if (gameBindStatus != 1) {
                if (gameBindStatus != 2) {
                    gameName = "";
                } else {
                    str = this.context.getString(R.string.i7k);
                    Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri\u2026roop_manage_bind_to_game)");
                    gameName = this.context.getString(R.string.i7q);
                    Intrinsics.checkNotNullExpressionValue(gameName, "context.getString(R.stri\u2026troop_manage_unbind_desc)");
                }
            } else {
                str = this.context.getString(R.string.i7s);
                Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri\u2026op_manage_unbind_to_game)");
            }
        } else {
            String string = this.context.getString(R.string.i7k);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026roop_manage_bind_to_game)");
            gameName = "";
            str = string;
        }
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.infoTv;
        if (textView2 != null) {
            textView2.setText(gameName);
        }
        Function2<? super String, ? super String, Unit> function2 = this.onFetchGameInfoCallback;
        if (function2 != null) {
            function2.invoke(str, gameName);
        }
    }

    @NotNull
    public final View.OnClickListener h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopinfoedit.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopBindGameItemHelper.i(TroopBindGameItemHelper.this, view);
            }
        };
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            w();
            n().M1(this.troopUin, this.statusUpdateCallback);
        }
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.gameBindStatus;
    }

    @NotNull
    public final View l() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.gameBindView == null) {
            TextView textView2 = null;
            View inflate = View.inflate(this.context, R.layout.b3y, null);
            this.gameBindView = inflate;
            if (inflate != null) {
                inflate.setBackgroundResource(R.drawable.common_strip_setting_middle);
            }
            View view = this.gameBindView;
            if (view != null) {
                view.setOnClickListener(h());
            }
            View view2 = this.gameBindView;
            if (view2 != null) {
                textView = (TextView) view2.findViewById(R.id.title);
            } else {
                textView = null;
            }
            this.titleTv = textView;
            View view3 = this.gameBindView;
            if (view3 != null) {
                textView2 = (TextView) view3.findViewById(R.id.info);
            }
            this.infoTv = textView2;
            x(this.gameBindStatus, this.gameName);
        }
        View view4 = this.gameBindView;
        if (view4 == null) {
            return new View(this.context);
        }
        return view4;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            x(this.gameBindStatus, this.gameName);
            w();
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            n().R1();
        }
    }

    public final void r(@Nullable Function2<? super String, ? super String, Unit> function2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function2);
        } else {
            this.onFetchGameInfoCallback = function2;
        }
    }

    public final void s(boolean isVisible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isVisible);
            return;
        }
        View view = this.gameBindView;
        if (view != null) {
            if (isVisible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }
}
