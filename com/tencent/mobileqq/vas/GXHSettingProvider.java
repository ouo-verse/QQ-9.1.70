package com.tencent.mobileqq.vas;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.setting.processor.SettingConfigProvider;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.GXHSettingProvider;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0015\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0004J\u0015\u0010\u0017\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0004J\u0015\u0010\u0018\u001a\u00020\r*\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\u0004J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/GXHSettingProvider;", "Lcom/tencent/mobileqq/setting/processor/SettingConfigProvider;", "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/setting/processor/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/GXHSettingProvider$Companion$a;", "itemData", "Lcom/tencent/mobileqq/vas/ae;", "L", "Lcom/tencent/mobileqq/vas/u;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/vas/ai;", UserInfo.SEX_FEMALE, "M", "Lcom/tencent/mobileqq/vas/aa;", "H", "J", "D", "Lcom/tencent/mobileqq/vas/GXHSettingProvider$Companion$ACTION;", "action", "P", "O", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "flag", "B", "Lcom/tencent/mobileqq/setting/processor/b;", "f", "<init>", "()V", "e", "Companion", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class GXHSettingProvider extends SettingConfigProvider {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<JSONObject> f307834f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy<JSONObject> f307835g;

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f307836h;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/GXHSettingProvider$Companion;", "", "Lorg/json/JSONObject;", "toggleJson$delegate", "Lkotlin/Lazy;", "d", "()Lorg/json/JSONObject;", "toggleJson", "defaultJson$delegate", "c", "defaultJson", "", "hideToggle", "Z", "<init>", "()V", "ACTION", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/GXHSettingProvider$Companion$ACTION;", "", "(Ljava/lang/String;I)V", "HIDE_FOR_SIMPLE_MODE", "HIDE_FOR_STUDY_MODE", "HIDE_FOR_NORMAL_MODE", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes20.dex */
        public enum ACTION {
            HIDE_FOR_SIMPLE_MODE,
            HIDE_FOR_STUDY_MODE,
            HIDE_FOR_NORMAL_MODE
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/GXHSettingProvider$Companion$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "icon", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "tittle", "d", "urlFlag", "datong", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.GXHSettingProvider$Companion$a, reason: from toString */
        /* loaded from: classes20.dex */
        public static final /* data */ class Item {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int icon;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String tittle;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String urlFlag;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String datong;

            public Item(int i3, @NotNull String tittle, @NotNull String urlFlag, @NotNull String datong) {
                Intrinsics.checkNotNullParameter(tittle, "tittle");
                Intrinsics.checkNotNullParameter(urlFlag, "urlFlag");
                Intrinsics.checkNotNullParameter(datong, "datong");
                this.icon = i3;
                this.tittle = tittle;
                this.urlFlag = urlFlag;
                this.datong = datong;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final String getDatong() {
                return this.datong;
            }

            /* renamed from: b, reason: from getter */
            public final int getIcon() {
                return this.icon;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final String getTittle() {
                return this.tittle;
            }

            @NotNull
            /* renamed from: d, reason: from getter */
            public final String getUrlFlag() {
                return this.urlFlag;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                if (this.icon == item.icon && Intrinsics.areEqual(this.tittle, item.tittle) && Intrinsics.areEqual(this.urlFlag, item.urlFlag) && Intrinsics.areEqual(this.datong, item.datong)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (((((this.icon * 31) + this.tittle.hashCode()) * 31) + this.urlFlag.hashCode()) * 31) + this.datong.hashCode();
            }

            @NotNull
            public String toString() {
                return "Item(icon=" + this.icon + ", tittle=" + this.tittle + ", urlFlag=" + this.urlFlag + ", datong=" + this.datong + ")";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final JSONObject c() {
            return (JSONObject) GXHSettingProvider.f307835g.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final JSONObject d() {
            return (JSONObject) GXHSettingProvider.f307834f.getValue();
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f307841a;

        static {
            int[] iArr = new int[Companion.ACTION.values().length];
            try {
                iArr[Companion.ACTION.HIDE_FOR_SIMPLE_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.ACTION.HIDE_FOR_STUDY_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.ACTION.HIDE_FOR_NORMAL_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f307841a = iArr;
        }
    }

    static {
        Lazy<JSONObject> lazy;
        Lazy<JSONObject> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$Companion$toggleJson$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                return ar.INSTANCE.a("kenaiyu", "2024-10-18", "vas_entry_config").getJson();
            }
        });
        f307834f = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$Companion$defaultJson$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                return new JSONObject("\n                {\n                    \"theme\": \"https://zb.vip.qq.com/v2/pages/themeMall?enteranceId=sqsetting\",\n                    \"pendant\": \"https://zb.vip.qq.com/v2/pages/widgetMall?enteranceId=sqsetting\",\n                    \"font\": \"https://zb.vip.qq.com/v2/pages/fontMall?enteranceId=sqsetting\",\n                    \"bubble\": \"https://zb.vip.qq.com/v2/pages/bubbleMall?enteranceId=sqsetting\",\n                    \"background\": \"https://club.vip.qq.com/transfer?open_kuikly_info=%7B%22bundle_name%22%3A%22vas_qqvip_page%22%7D&qqmc_config=vas_kuikly_config&page_name=VasBackgroundShop\",\n                    \"enter_group_effect\": \"https://zb.vip.qq.com/v2/pages/groupMall\",\n                    \"card\": \"https://zb.vip.qq.com/v2/pages/cardMall\",\n                    \"like\": \"https://zb.vip.qq.com/like?_wv=3\",\n                    \"floating_screen\": \"https://zb.vip.qq.com/flashScreen\",\n                    \"nameplate\": \"https://club.vip.qq.com/qqvip/medal/my?_wv=16777221&_wwv=8192&_proxy=1\",\n                    \"color_nick\": \"https://club.vip.qq.com/qqvip/setting/colorful-nickname?_wv=16777216\",\n                    \"vip_flag\": \"https://club.vip.qq.com/qqvip/setting/head-logo?_wv=16777216\",\n                    \"game_nameplate\": \"https://club.vip.qq.com/qqvip/game-medal/mine?_wv=16777223&_wwv=4&_wvx=10\",\n                    \"app_icon\": \"https://zb.vip.qq.com/v2/pages/qqIconMall\"\n                }\n                ");
            }
        });
        f307835g = lazy2;
        f307836h = ar.INSTANCE.b("kenaiyu", "2024-12-23", "vas_feature_120954470").isEnable(true);
    }

    private final u A(final Context context, final Companion.Item itemData) {
        u uVar = new u(context, itemData);
        uVar.D(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$gameIcon$1$1
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
                String B;
                B = GXHSettingProvider.this.B(itemData.getUrlFlag());
                if (B.length() > 0) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(context, ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(B, new IVipTraceDetailReport.b(null, "pg_bas_dressvip_set", null, null, 13, null)));
                }
            }
        });
        uVar.C(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$gameIcon$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.setElementId(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementReuseIdentifier(it, GXHSettingProvider.Companion.Item.this.getDatong());
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("text_status", VasInjectApi.getInstance().isShowGameIcon() ? "1" : "0"));
                VideoReport.setElementParams(it, mapOf);
                VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
            }
        });
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B(String flag) {
        boolean z16;
        Companion companion = INSTANCE;
        String url = companion.d().optString(flag);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            url = companion.c().optString(flag);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    private final List<com.tencent.mobileqq.setting.processor.c> C(Context context) {
        List<com.tencent.mobileqq.setting.processor.c> mutableListOf;
        ae L = L(context, new Companion.Item(R.drawable.qui_name_card, "\u540d\u7247", IndividuationUrlHelper.UrlId.CARD_HOME, "em_bas_business_card"));
        Companion.ACTION action = Companion.ACTION.HIDE_FOR_STUDY_MODE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(P(L, action), P(L(context, new Companion.Item(R.drawable.qui_like, "\u70b9\u8d5e", "like", "em_bas_like")), action), P(L(context, new Companion.Item(R.drawable.qui_changing_sound, "\u6d6e\u5c4f", "floating_screen", "em_bas_floating_shield")), action));
        com.tencent.mobileqq.setting.processor.c medalProcessor = ((ISettingApi) QRoute.api(ISettingApi.class)).getMedalProcessor(context);
        if (medalProcessor != null) {
            mutableListOf.add(medalProcessor);
        }
        return mutableListOf;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [mqq.util.WeakReference, T] */
    private final ai D(Context context, final Companion.Item itemData) {
        ai aiVar = new ai(context, 20, itemData.getTittle(), itemData.getIcon(), VasInjectApi.getInstance().isShowColorName());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new WeakReference(null);
        aiVar.C(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GXHSettingProvider.E(Ref.ObjectRef.this, compoundButton, z16);
            }
        });
        aiVar.B(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$showTroopColorName$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [mqq.util.WeakReference, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.setElementId(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementReuseIdentifier(it, GXHSettingProvider.Companion.Item.this.getDatong());
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", VasInjectApi.getInstance().isShowColorName() ? "1" : "2"));
                VideoReport.setElementParams(it, mapOf);
                VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
                objectRef.element = new WeakReference(it);
            }
        });
        return aiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void E(Ref.ObjectRef weakSwitch, CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(weakSwitch, "$weakSwitch");
        VasInjectApi.getInstance().setShowColorName(z16);
        View view = (View) ((WeakReference) weakSwitch.element).get();
        if (view != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            linkedHashMap.put("op_result", str);
            Unit unit = Unit.INSTANCE;
            VideoReport.reportEvent("dt_clck", view, linkedHashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [mqq.util.WeakReference, T] */
    private final ai F(Context context, final Companion.Item itemData) {
        ai aiVar = new ai(context, 20, itemData.getTittle(), itemData.getIcon(), VasInjectApi.getInstance().isShowTroopLiang());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new WeakReference(null);
        aiVar.C(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GXHSettingProvider.G(Ref.ObjectRef.this, compoundButton, z16);
            }
        });
        aiVar.B(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$showTroopLiang$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [mqq.util.WeakReference, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.setElementId(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementReuseIdentifier(it, GXHSettingProvider.Companion.Item.this.getDatong());
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", VasInjectApi.getInstance().isShowTroopLiang() ? "1" : "2"));
                VideoReport.setElementParams(it, mapOf);
                VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
                objectRef.element = new WeakReference(it);
            }
        });
        return aiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(Ref.ObjectRef weakSwitch, CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(weakSwitch, "$weakSwitch");
        VasInjectApi.getInstance().setShowTroopLiang(z16);
        View view = (View) ((WeakReference) weakSwitch.element).get();
        if (view != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            linkedHashMap.put("op_result", str);
            Unit unit = Unit.INSTANCE;
            VideoReport.reportEvent("dt_clck", view, linkedHashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [mqq.util.WeakReference, T] */
    private final aa H(final Context context, final Companion.Item itemData) {
        aa aaVar = new aa(context, 20, itemData.getTittle(), itemData.getIcon(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$showTroopVipIcon$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(VasInjectApi.getInstance().isShowTroopVipIcon());
            }
        });
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new WeakReference(null);
        aaVar.C(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GXHSettingProvider.I(context, objectRef, compoundButton, z16);
            }
        });
        aaVar.B(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$showTroopVipIcon$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [mqq.util.WeakReference, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.setElementId(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementReuseIdentifier(it, GXHSettingProvider.Companion.Item.this.getDatong());
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", VasInjectApi.getInstance().isShowTroopVipIcon() ? "1" : "2"));
                VideoReport.setElementParams(it, mapOf);
                VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
                objectRef.element = new WeakReference(it);
            }
        });
        return aaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void I(Context context, Ref.ObjectRef weakSwitch, CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(weakSwitch, "$weakSwitch");
        VasInjectApi.getInstance().setShowTroopVipIcon(context, z16);
        if (z16 && !VasInjectApi.getInstance().isShowTroopVipIcon()) {
            compoundButton.setChecked(false);
        }
        View view = (View) ((WeakReference) weakSwitch.element).get();
        if (view != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            linkedHashMap.put("op_result", str);
            Unit unit = Unit.INSTANCE;
            VideoReport.reportEvent("dt_clck", view, linkedHashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [mqq.util.WeakReference, T] */
    private final ai J(Context context, final Companion.Item itemData) {
        ai aiVar = new ai(context, 20, itemData.getTittle(), itemData.getIcon(), VasInjectApi.getInstance().isShowVipIconForSimpleMode());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new WeakReference(null);
        aiVar.C(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GXHSettingProvider.K(Ref.ObjectRef.this, compoundButton, z16);
            }
        });
        aiVar.B(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$showVipIconForSimpleMode$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [mqq.util.WeakReference, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.setElementId(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementReuseIdentifier(it, GXHSettingProvider.Companion.Item.this.getDatong());
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", VasInjectApi.getInstance().isShowVipIconForSimpleMode() ? "1" : "2"));
                VideoReport.setElementParams(it, mapOf);
                VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
                objectRef.element = new WeakReference(it);
            }
        });
        return aiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void K(Ref.ObjectRef weakSwitch, CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(weakSwitch, "$weakSwitch");
        VasInjectApi.getInstance().setShowVipIconForSimpleMode(z16);
        View view = (View) ((WeakReference) weakSwitch.element).get();
        if (view != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            linkedHashMap.put("op_result", str);
            Unit unit = Unit.INSTANCE;
            VideoReport.reportEvent("dt_clck", view, linkedHashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final ae L(final Context context, final Companion.Item itemData) {
        ae aeVar = new ae(context, 20, itemData.getTittle(), itemData.getIcon());
        aeVar.C(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$simpleItem$1$1
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
                String B;
                B = GXHSettingProvider.this.B(itemData.getUrlFlag());
                if (B.length() > 0) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(context, ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(B, new IVipTraceDetailReport.b(null, itemData.getDatong(), null, null, 13, null)));
                }
            }
        });
        aeVar.B(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$simpleItem$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.setElementId(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementReuseIdentifier(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
            }
        });
        return aeVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [mqq.util.WeakReference, T] */
    private final ai M(Context context, final Companion.Item itemData) {
        ai aiVar = new ai(context, 20, itemData.getTittle(), itemData.getIcon(), ThemeVipBehavior.getVipSplashSwitch());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new WeakReference(null);
        aiVar.C(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.q
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GXHSettingProvider.N(Ref.ObjectRef.this, compoundButton, z16);
            }
        });
        aiVar.B(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.GXHSettingProvider$vipSplash$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [mqq.util.WeakReference, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.setElementId(it, GXHSettingProvider.Companion.Item.this.getDatong());
                VideoReport.setElementReuseIdentifier(it, GXHSettingProvider.Companion.Item.this.getDatong());
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", ThemeVipBehavior.getVipSplashSwitch() ? "1" : "2"));
                VideoReport.setElementParams(it, mapOf);
                VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
                objectRef.element = new WeakReference(it);
            }
        });
        return aiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void N(Ref.ObjectRef weakSwitch, CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(weakSwitch, "$weakSwitch");
        ThemeVipBehavior.updateSvipSplashSwitch(z16);
        View view = (View) ((WeakReference) weakSwitch.element).get();
        if (view != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            linkedHashMap.put("op_result", str);
            Unit unit = Unit.INSTANCE;
            VideoReport.reportEvent("dt_clck", view, linkedHashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final aa O(aa aaVar, Companion.ACTION action) {
        int i3 = a.f307841a[action.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && !QQTheme.isNowSimpleUI()) {
                    aaVar.D(false);
                }
            } else if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
                aaVar.D(false);
            }
        } else if (QQTheme.isNowSimpleUI()) {
            aaVar.D(false);
        }
        return aaVar;
    }

    private final ae P(ae aeVar, Companion.ACTION action) {
        int i3 = a.f307841a[action.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && ((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
                aeVar.D(false);
            }
        } else if (QQTheme.isNowSimpleUI()) {
            aeVar.D(false);
        }
        return aeVar;
    }

    private final ai Q(ai aiVar, Companion.ACTION action) {
        int i3 = a.f307841a[action.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && !QQTheme.isNowSimpleUI()) {
                    aiVar.D(false);
                }
            } else if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
                aiVar.D(false);
            }
        } else if (QQTheme.isNowSimpleUI()) {
            aiVar.D(false);
        }
        return aiVar;
    }

    @Override // com.tencent.mobileqq.setting.processor.SettingConfigProvider
    @NotNull
    public List<com.tencent.mobileqq.setting.processor.b> f(@NotNull Context context) {
        List mutableListOf;
        List mutableListOf2;
        com.tencent.mobileqq.setting.processor.b[] bVarArr;
        List mutableListOf3;
        List mutableListOf4;
        List<com.tencent.mobileqq.setting.processor.b> mutableListOf5;
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.setting.processor.b[] bVarArr2 = new com.tencent.mobileqq.setting.processor.b[5];
        ae L = L(context, new Companion.Item(R.drawable.qui_skin, "\u4e3b\u9898\u98ce\u683c", "theme", "em_bas_theme_style"));
        Companion.ACTION action = Companion.ACTION.HIDE_FOR_STUDY_MODE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(P(L, action), P(L(context, new Companion.Item(R.drawable.qui_pendant, "\u5934\u50cf\u6302\u4ef6", IndividuationUrlHelper.UrlId.PENDANT_HOME, "em_bas_avatar_frame")), action), P(L(context, new Companion.Item(R.drawable.qui_typeface, "\u5b57\u4f53\u6837\u5f0f", "font", "em_bas_text_visual")), action));
        bVarArr2[0] = new com.tencent.mobileqq.setting.processor.b(mutableListOf, "\u98ce\u683c\u8bbe\u7f6e", null, 4, null);
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(P(L(context, new Companion.Item(R.drawable.qui_message, "\u804a\u5929\u6c14\u6ce1", "bubble", "em_bas_chat_bubble")), action), P(L(context, new Companion.Item(R.drawable.qui_set_background, "\u804a\u5929\u80cc\u666f", "background", "em_bas_chat_background")), action), P(L(context, new Companion.Item(R.drawable.qui_entry_effect, "\u8fdb\u7fa4\u7279\u6548", "enter_group_effect", "em_group_enter_visual")), action));
        bVarArr2[1] = new com.tencent.mobileqq.setting.processor.b(mutableListOf2, "\u804a\u5929", null, 4, null);
        bVarArr2[2] = new com.tencent.mobileqq.setting.processor.b(C(context), "\u8d44\u6599\u5361", null, 4, null);
        String str = "";
        if (f307836h) {
            bVarArr = bVarArr2;
            str = "";
            mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(L(context, new Companion.Item(R.drawable.qui_vip, "\u4f1a\u5458\u94ed\u724c", "nameplate", "em_bas_svip_nameplate")), L(context, new Companion.Item(R.drawable.qui_nickname, "\u4f1a\u5458\u5f69\u8272\u6635\u79f0", "color_nick", "em_bas_svip_color_nickname")), P(L(context, new Companion.Item(R.drawable.qui_super_member, "\u4f1a\u5458\u6807\u8bc6", "vip_flag", "em_bas_svip_logo")), Companion.ACTION.HIDE_FOR_SIMPLE_MODE), A(context, new Companion.Item(R.drawable.qui_title_member, "\u4f1a\u5458\u79f0\u53f7&\u738b\u8005\u6bb5\u4f4d", "game_nameplate", "em_bas_svip_title_king_rank")), F(context, new Companion.Item(R.drawable.qui_group_owner, "\u9753\u53f7\u7fa4\u7fa4\u4e3b\u8eab\u4efd", str, "em_bas_good_num_group_owner_identity")));
        } else {
            bVarArr = bVarArr2;
            aa H = H(context, new Companion.Item(R.drawable.qui_group, "\u7fa4\u804a\u5c55\u793a\u8eab\u4efd\u94ed\u724c", "", ""));
            Companion.ACTION action2 = Companion.ACTION.HIDE_FOR_SIMPLE_MODE;
            mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(L(context, new Companion.Item(R.drawable.qui_vip, "\u4f1a\u5458\u94ed\u724c", "nameplate", "em_bas_svip_nameplate")), O(H, action2), Q(J(context, new Companion.Item(R.drawable.qui_name_card, "\u5c55\u793a\u6211\u7684\u94ed\u724c", "", "")), Companion.ACTION.HIDE_FOR_NORMAL_MODE), L(context, new Companion.Item(R.drawable.qui_nickname, "\u4f1a\u5458\u5f69\u8272\u6635\u79f0", "color_nick", "em_bas_svip_color_nickname")), Q(D(context, new Companion.Item(R.drawable.qui_list_select, "\u804a\u5929\u5217\u8868\u5c55\u793a\u5f69\u8272\u6635\u79f0", "", "")), action2), P(L(context, new Companion.Item(R.drawable.qui_super_member, "\u4f1a\u5458\u6807\u8bc6", "vip_flag", "em_bas_svip_logo")), action2), A(context, new Companion.Item(R.drawable.qui_title_member, "\u4f1a\u5458\u79f0\u53f7&\u738b\u8005\u6bb5\u4f4d", "game_nameplate", "em_bas_svip_title_king_rank")), F(context, new Companion.Item(R.drawable.qui_group_owner, "\u9753\u53f7\u7fa4\u7fa4\u4e3b\u8eab\u4efd", "", "em_bas_good_num_group_owner_identity")));
        }
        bVarArr[3] = new com.tencent.mobileqq.setting.processor.b(mutableListOf3, "\u8eab\u4efd", null, 4, null);
        mutableListOf4 = CollectionsKt__CollectionsKt.mutableListOf(P(L(context, new Companion.Item(R.drawable.qui_qq_edit, "APP\u4e2a\u6027\u56fe\u6807", MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "em_bas_app_personality_icon")), action), M(context, new Companion.Item(R.drawable.qui_launch_screen, "\u4f1a\u5458\u4e13\u5c5e\u5c0a\u8d35\u5f00\u5c4f", str, "em_bas_svip_exclusive_coopen")));
        bVarArr[4] = new com.tencent.mobileqq.setting.processor.b(mutableListOf4, "\u542f\u52a8", null, 4, null);
        mutableListOf5 = CollectionsKt__CollectionsKt.mutableListOf(bVarArr);
        return mutableListOf5;
    }
}
