package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigSelectIconFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.dx;
import com.tencent.mobileqq.qqguildsdk.data.genc.ea;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J0\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0014J&\u0010 \u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\"\u0010%\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016R#\u00100\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R#\u00105\u001a\n +*\u0004\u0018\u000101018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R#\u0010:\u001a\n +*\u0004\u0018\u000106068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b8\u00109R#\u0010=\u001a\n +*\u0004\u0018\u000106068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010-\u001a\u0004\b<\u00109R#\u0010@\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010-\u001a\u0004\b?\u0010/R#\u0010C\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010-\u001a\u0004\bB\u0010/R#\u0010H\u001a\n +*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010-\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010-\u001a\u0004\bK\u0010LR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010Q\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigAddConfigFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Lcom/tencent/mobileqq/guild/window/s$c;", "", "setStatusBar", "initUI", "", "iconUri", "mi", "", "iconId", "Wh", "(Ljava/lang/Long;)Ljava/lang/String;", "pi", "", "isDeleteAction", "Vh", "Landroid/text/Editable;", "editable", "li", "", "action", "Lkotlin/Function3;", "resultFun", "ni", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onDestroyView", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "T", "Lkotlin/Lazy;", "Zh", "()Landroid/widget/ImageView;", "ivAvatarAdd", "Landroid/widget/LinearLayout;", "U", "di", "()Landroid/widget/LinearLayout;", "layoutAvatarAdd", "Landroid/widget/EditText;", "V", "Yh", "()Landroid/widget/EditText;", "etNavName", "W", "Xh", "etNavMagnet", "X", "ai", "ivClearMagnet", "Y", "bi", "ivClearNavName", "Landroid/widget/TextView;", "Z", "ei", "()Landroid/widget/TextView;", "tvDeleteApp", "Lcom/tencent/mobileqq/guild/window/s;", "a0", "ci", "()Lcom/tencent/mobileqq/guild/window/s;", "keyboardStateHelper", "b0", "Ljava/lang/String;", "c0", "Ljava/lang/Long;", "d0", "categoryId", "<init>", "()V", "e0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildNavigatorConfigAddConfigFragment extends QQGuildTitleBarFragment implements s.c {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivAvatarAdd;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy layoutAvatarAdd;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy etNavName;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy etNavMagnet;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivClearMagnet;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivClearNavName;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvDeleteApp;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy keyboardStateHelper;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String iconUri;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long iconId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long categoryId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u00a1\u0001\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0019R\u0014\u0010%\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010)\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010*\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010,\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigAddConfigFragment$a;", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;", "Lkotlin/collections/ArrayList;", "themeIcons", "blackThemeIcons", "", "inputGuildId", "", "inputIconId", "inputIcon", "inputName", "inputSubDesc", "", "isFetchCategoryId", "inputCategoryId", "", "reqCode", "", "a", "(Lcom/tencent/mobileqq/app/QBaseFragment;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;I)V", "KEY_BLACK_THEME_ICONS", "Ljava/lang/String;", "KEY_GUILD_ID", "KEY_IS_FETCH_CATEGORY_ID", "KEY_ITEM_CATEGORY_ID", "KEY_ITEM_ICON", "KEY_ITEM_ICON_ID", "KEY_ITEM_NAME", "KEY_ITEM_SUB_DESC", "KEY_THEME_ICONS", "REQ_SELECT_ICON", "I", "RES_KEY_ACTION", "RES_KEY_CATEGORY_ID", "RES_KEY_CONFIG_NAME", "RES_KEY_ICON_ID", "RES_KEY_ICON_URI", "RES_KEY_MAGNET", "TAG", "configNameInputLength", "nullId", "J", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull QBaseFragment fragment, @NotNull ArrayList<ConfigIconItem> themeIcons, @Nullable ArrayList<ConfigIconItem> blackThemeIcons, @NotNull String inputGuildId, @Nullable Long inputIconId, @Nullable String inputIcon, @Nullable String inputName, @Nullable String inputSubDesc, boolean isFetchCategoryId, @Nullable Long inputCategoryId, int reqCode) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(themeIcons, "themeIcons");
            Intrinsics.checkNotNullParameter(inputGuildId, "inputGuildId");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("themeIcons", themeIcons);
            bundle.putSerializable("blackThemeIcons", blackThemeIcons);
            if (inputIconId != null) {
                inputIconId.longValue();
                bundle.putLong("itemIconId", inputIconId.longValue());
            }
            bundle.putString("itemIcon", inputIcon);
            bundle.putString("itemName", inputName);
            bundle.putString("itemSubDest", inputSubDesc);
            bundle.putString("guildId", inputGuildId);
            bundle.putBoolean("isFetchCategoryId", isFetchCategoryId);
            if (inputCategoryId != null) {
                inputCategoryId.longValue();
                bundle.putLong("itemCategoryId", inputCategoryId.longValue());
            }
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.g(fragment, intent, QPublicFragmentActivity.class, QQGuildNavigatorConfigAddConfigFragment.class, reqCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigAddConfigFragment$d", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "", "onItemLongClick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements GuildDefaultThemeNavBarCommon.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@Nullable View v3, int item) {
            Map mapOf;
            if (item != 1) {
                if (item == 2) {
                    TextView h16 = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).J.h();
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_icon_id", String.valueOf(QQGuildNavigatorConfigAddConfigFragment.this.iconId)), TuplesKt.to("sgrp_navigation_name", QQGuildNavigatorConfigAddConfigFragment.this.Yh().getText().toString()), TuplesKt.to("sgrp_navigation_url", QQGuildNavigatorConfigAddConfigFragment.this.Xh().getText().toString()));
                    VideoReport.reportEvent("clck", h16, mapOf);
                    QQGuildNavigatorConfigAddConfigFragment.this.Vh(false);
                    return;
                }
                return;
            }
            FragmentActivity activity = QQGuildNavigatorConfigAddConfigFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public QQGuildNavigatorConfigAddConfigFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$ivAvatarAdd$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return (ImageView) view.findViewById(R.id.y0k);
            }
        });
        this.ivAvatarAdd = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$layoutAvatarAdd$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return (LinearLayout) view.findViewById(R.id.ydq);
            }
        });
        this.layoutAvatarAdd = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$etNavName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return (EditText) view.findViewById(R.id.uxi);
            }
        });
        this.etNavName = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$etNavMagnet$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return (EditText) view.findViewById(R.id.uxh);
            }
        });
        this.etNavMagnet = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$ivClearMagnet$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return (ImageView) view.findViewById(R.id.y1i);
            }
        });
        this.ivClearMagnet = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$ivClearNavName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return (ImageView) view.findViewById(R.id.y1j);
            }
        });
        this.ivClearNavName = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$tvDeleteApp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return (TextView) view.findViewById(R.id.f107296a1);
            }
        });
        this.tvDeleteApp = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.window.s>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$keyboardStateHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.window.s invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigAddConfigFragment.this).P;
                return new com.tencent.mobileqq.guild.window.s(view, false);
            }
        });
        this.keyboardStateHelper = lazy8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(boolean isDeleteAction) {
        boolean z16;
        final int i3;
        final Function2<Long, Integer, Unit> function2 = new Function2<Long, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$finishAndReturnData$invokeFun$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, Integer num) {
                invoke2(l3, num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Long l3, @Nullable Integer num) {
                String str;
                String str2;
                FragmentActivity activity = QQGuildNavigatorConfigAddConfigFragment.this.getActivity();
                if (activity != null) {
                    QQGuildNavigatorConfigAddConfigFragment qQGuildNavigatorConfigAddConfigFragment = QQGuildNavigatorConfigAddConfigFragment.this;
                    Intent intent = new Intent();
                    intent.putExtra("resIconId", qQGuildNavigatorConfigAddConfigFragment.iconId);
                    str = qQGuildNavigatorConfigAddConfigFragment.iconUri;
                    intent.putExtra("resIconUri", str);
                    intent.putExtra("resConfigName", qQGuildNavigatorConfigAddConfigFragment.Yh().getText().toString());
                    intent.putExtra("resMagnet", qQGuildNavigatorConfigAddConfigFragment.Xh().getText().toString());
                    intent.putExtra("resCategoryId", l3);
                    intent.putExtra("resAction", num);
                    Long l16 = qQGuildNavigatorConfigAddConfigFragment.iconId;
                    str2 = qQGuildNavigatorConfigAddConfigFragment.iconUri;
                    QLog.i("QQGuildNavigatorConfigAddConfigFragment", 2, "save:  iconId:" + l16 + "    iconUri:" + str2 + "    name:" + ((Object) qQGuildNavigatorConfigAddConfigFragment.Yh().getText()) + "   magnet:" + ((Object) qQGuildNavigatorConfigAddConfigFragment.Xh().getText()) + "  returnCategoryId:" + l3);
                    activity.setResult(-1, intent);
                    activity.finish();
                }
            }
        };
        Bundle arguments = getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean("isFetchCategoryId");
        } else {
            z16 = false;
        }
        if (z16) {
            if (isDeleteAction) {
                i3 = 3;
            } else if (this.categoryId != null) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            ni(i3, new Function3<Boolean, String, Long, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment$finishAndReturnData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, Long l3) {
                    invoke(bool.booleanValue(), str, l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @NotNull String errMsg, long j3) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    if (z17) {
                        if (i3 != 3) {
                            QQToastUtil.showQQToast(2, "\u4fdd\u5b58\u6210\u529f");
                        }
                        function2.invoke(Long.valueOf(j3), Integer.valueOf(i3));
                        return;
                    }
                    QQToastUtil.showQQToast(1, errMsg);
                }
            });
            return;
        }
        function2.invoke(null, null);
    }

    private final String Wh(Long iconId) {
        Serializable serializable;
        ArrayList arrayList;
        ConfigIconItem configIconItem;
        Object obj;
        boolean z16;
        int collectionSizeOrDefault;
        if (iconId == null) {
            return null;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("blackThemeIcons");
        } else {
            serializable = null;
        }
        ArrayList arrayList2 = (ArrayList) serializable;
        if (arrayList2 != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (Object obj2 : arrayList2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem");
                arrayList.add((ConfigIconItem) obj2);
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((ConfigIconItem) obj).getId() == iconId.longValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            configIconItem = (ConfigIconItem) obj;
        } else {
            configIconItem = null;
        }
        if (configIconItem == null) {
            return null;
        }
        return configIconItem.getIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText Xh() {
        return (EditText) this.etNavMagnet.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText Yh() {
        return (EditText) this.etNavName.getValue();
    }

    private final ImageView Zh() {
        return (ImageView) this.ivAvatarAdd.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView ai() {
        return (ImageView) this.ivClearMagnet.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView bi() {
        return (ImageView) this.ivClearNavName.getValue();
    }

    private final com.tencent.mobileqq.guild.window.s ci() {
        return (com.tencent.mobileqq.guild.window.s) this.keyboardStateHelper.getValue();
    }

    private final LinearLayout di() {
        return (LinearLayout) this.layoutAvatarAdd.getValue();
    }

    private final TextView ei() {
        return (TextView) this.tvDeleteApp.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (r1 != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void fi(QQGuildNavigatorConfigAddConfigFragment this$0, View view, boolean z16) {
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView ivClearNavName = this$0.bi();
        Intrinsics.checkNotNullExpressionValue(ivClearNavName, "ivClearNavName");
        int i3 = 0;
        if (z16) {
            Editable text = this$0.Yh().getText();
            Intrinsics.checkNotNullExpressionValue(text, "etNavName.text");
            z17 = true;
            if (text.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
        }
        z17 = false;
        if (!z17) {
            i3 = 8;
        }
        ivClearNavName.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (r1 != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void gi(QQGuildNavigatorConfigAddConfigFragment this$0, View view, boolean z16) {
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView ivClearMagnet = this$0.ai();
        Intrinsics.checkNotNullExpressionValue(ivClearMagnet, "ivClearMagnet");
        int i3 = 0;
        if (z16) {
            Editable text = this$0.Xh().getText();
            Intrinsics.checkNotNullExpressionValue(text, "etNavMagnet.text");
            z17 = true;
            if (text.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
        }
        z17 = false;
        if (!z17) {
            i3 = 8;
        }
        ivClearMagnet.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(QQGuildNavigatorConfigAddConfigFragment this$0, View view) {
        Object obj;
        List list;
        Serializable serializable;
        List list2;
        ArrayList<ConfigIconItem> arrayList;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle arguments = this$0.getArguments();
        Long l3 = null;
        if (arguments != null) {
            obj = arguments.get("themeIcons");
        } else {
            obj = null;
        }
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2 != null) {
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            for (Object obj2 : arrayList2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem");
                arrayList3.add((ConfigIconItem) obj2);
            }
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        Bundle arguments2 = this$0.getArguments();
        if (arguments2 != null) {
            serializable = arguments2.getSerializable("blackThemeIcons");
        } else {
            serializable = null;
        }
        ArrayList arrayList4 = (ArrayList) serializable;
        if (arrayList4 != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
            ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
            for (Object obj3 : arrayList4) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem");
                arrayList5.add((ConfigIconItem) obj3);
            }
            list2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList5);
        } else {
            list2 = null;
        }
        if (list2 instanceof ArrayList) {
            arrayList = (ArrayList) list2;
        } else {
            arrayList = null;
        }
        QQGuildNavigatorConfigSelectIconFragment.Companion companion = QQGuildNavigatorConfigSelectIconFragment.INSTANCE;
        ArrayList<ConfigIconItem> arrayList6 = (ArrayList) list;
        Long l16 = this$0.iconId;
        if (l16 != null && (l16 == null || l16.longValue() != -99)) {
            l3 = this$0.iconId;
        }
        companion.a(this$0, arrayList6, arrayList, l3, 101);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(QQGuildNavigatorConfigAddConfigFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Xh().setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initUI() {
        String valueOf;
        int i3;
        ViewUtils.setViewRadius(Zh(), 6.0f);
        VideoReport.addToDetectionWhitelist(getActivity());
        com.tencent.mobileqq.guild.api.impl.e.a(this.N, "pg_sgrp_navigation_bar_set_add", null, null, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j3 = arguments.getLong("itemIconId", -99L);
            if (j3 != -99) {
                this.iconId = Long.valueOf(j3);
            }
            String string = arguments.getString("itemIcon");
            if (string != null) {
                this.iconUri = string;
            }
            String string2 = arguments.getString("itemName");
            if (string2 != null) {
                Yh().setText(string2);
            }
            String string3 = arguments.getString("itemSubDest");
            if (string3 != null) {
                Xh().setText(string3);
            }
            String it = arguments.getString("guildId");
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                linkedHashMap.put("sgrp_channel_id", it);
            }
            long j16 = arguments.getLong("itemCategoryId", -99L);
            if (j16 != -99) {
                this.categoryId = Long.valueOf(j16);
                ei().setVisibility(0);
            }
        }
        Long l3 = this.iconId;
        String str = "";
        if (l3 == null) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(l3);
        }
        linkedHashMap.put("sgrp_icon_id", valueOf);
        String obj = Yh().getText().toString();
        if (obj == null) {
            obj = "";
        }
        linkedHashMap.put("sgrp_navigation_name", obj);
        String obj2 = Xh().getText().toString();
        if (obj2 != null) {
            str = obj2;
        }
        linkedHashMap.put("sgrp_navigation_url", str);
        VideoReport.setPageParams(this.N, new PageParams(linkedHashMap));
        this.J.a();
        this.J.setBackground(getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard));
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (this.iconUri == null) {
            i3 = R.string.f15089168;
        } else {
            i3 = R.string.f1509716f;
        }
        guildDefaultThemeNavBarCommon.setTitle(getString(i3));
        this.J.setRightText(R.string.h3s);
        this.J.h().setEnabled(false);
        this.J.h().setAlpha(0.3f);
        this.J.setOnItemSelectListener(new d());
        EditText etNavName = Yh();
        Intrinsics.checkNotNullExpressionValue(etNavName, "etNavName");
        etNavName.addTextChangedListener(new b());
        EditText etNavMagnet = Xh();
        Intrinsics.checkNotNullExpressionValue(etNavMagnet, "etNavMagnet");
        etNavMagnet.addTextChangedListener(new c());
        Yh().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                QQGuildNavigatorConfigAddConfigFragment.fi(QQGuildNavigatorConfigAddConfigFragment.this, view, z16);
            }
        });
        Xh().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                QQGuildNavigatorConfigAddConfigFragment.gi(QQGuildNavigatorConfigAddConfigFragment.this, view, z16);
            }
        });
        di().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigAddConfigFragment.hi(QQGuildNavigatorConfigAddConfigFragment.this, view);
            }
        });
        ai().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigAddConfigFragment.ii(QQGuildNavigatorConfigAddConfigFragment.this, view);
            }
        });
        bi().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigAddConfigFragment.ji(QQGuildNavigatorConfigAddConfigFragment.this, view);
            }
        });
        ei().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigAddConfigFragment.ki(QQGuildNavigatorConfigAddConfigFragment.this, view);
            }
        });
        pi();
        com.tencent.mobileqq.guild.api.impl.e.a(this.J.h(), null, "em_sgrp_complete_btn", null, null, null, ClickPolicy.REPORT_NONE);
        mi(this.iconUri);
        ci().g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(QQGuildNavigatorConfigAddConfigFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Yh().setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(QQGuildNavigatorConfigAddConfigFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Vh(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(Editable editable) {
        float f16;
        float f17 = 0.0f;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < editable.length()) {
            int i18 = i17 + 1;
            if (new Regex("[A-Za-z0-9\\p{Punct}]").matches(String.valueOf(editable.charAt(i3)))) {
                f16 = 0.5f;
            } else {
                f16 = 1;
            }
            f17 += f16;
            if (f17 <= 4.0f) {
                i16 = i17;
            }
            i3++;
            i17 = i18;
        }
        int i19 = i16 + 1;
        if (i19 < editable.length()) {
            editable.replace(i19, editable.length(), "");
        }
    }

    private final void mi(String iconUri) {
        if (iconUri == null) {
            Zh().setImageResource(R.drawable.qui_add);
            ImageView ivAvatarAdd = Zh();
            Intrinsics.checkNotNullExpressionValue(ivAvatarAdd, "ivAvatarAdd");
            int dip2px = ViewUtils.dip2px(12.0f);
            ivAvatarAdd.setPadding(dip2px, dip2px, dip2px, dip2px);
            Zh().setBackgroundColor(getResources().getColor(R.color.qui_common_fill_standard_primary));
            Zh().setColorFilter((ColorFilter) null);
            return;
        }
        String Wh = Wh(this.iconId);
        if (Wh != null) {
            iconUri = Wh;
        }
        ImageView ivAvatarAdd2 = Zh();
        Intrinsics.checkNotNullExpressionValue(ivAvatarAdd2, "ivAvatarAdd");
        com.tencent.mobileqq.guild.util.v.i(iconUri, ivAvatarAdd2);
        Zh().setBackgroundColor(0);
        ImageView ivAvatarAdd3 = Zh();
        Intrinsics.checkNotNullExpressionValue(ivAvatarAdd3, "ivAvatarAdd");
        int dip2px2 = ViewUtils.dip2px(6.0f);
        ivAvatarAdd3.setPadding(dip2px2, dip2px2, dip2px2, dip2px2);
        Zh().setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN));
    }

    private final void ni(int action, final Function3<? super Boolean, ? super String, ? super Long, Unit> resultFun) {
        String str;
        long j3;
        ArrayList<ea> arrayListOf;
        dx dxVar = new dx();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("guildId")) == null) {
            str = "";
        }
        dxVar.g(MiscKt.l(str));
        dxVar.h("black");
        ea[] eaVarArr = new ea[1];
        ea eaVar = new ea();
        Long l3 = this.iconId;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        eaVar.f(j3);
        eaVar.h(Yh().getText().toString());
        eaVar.g(Xh().getText().toString());
        Long l16 = this.categoryId;
        if (l16 != null) {
            eaVar.e(l16.longValue());
        }
        Unit unit = Unit.INSTANCE;
        eaVarArr[0] = eaVar;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(eaVarArr);
        dxVar.i(arrayListOf);
        dxVar.f(action);
        QLog.i("QQGuildNavigatorConfigAddConfigFragment", 1, "saveAndFetchCategoryId guildId:" + dxVar.b() + " action:" + dxVar.a() + " categoryId:" + this.categoryId);
        ((IGPSService) ch.R0(IGPSService.class)).saveCustomApplication(dxVar, new wh2.dx() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.g
            @Override // wh2.dx
            public final void a(int i3, String str2, IGProCategoryChannelInfoList iGProCategoryChannelInfoList) {
                QQGuildNavigatorConfigAddConfigFragment.oi(QQGuildNavigatorConfigAddConfigFragment.this, resultFun, i3, str2, iGProCategoryChannelInfoList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(QQGuildNavigatorConfigAddConfigFragment this$0, Function3 resultFun, int i3, String str, IGProCategoryChannelInfoList iGProCategoryChannelInfoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultFun, "$resultFun");
        QLog.i("QQGuildNavigatorConfigAddConfigFragment", 1, "saveAndFetchCategoryId result=" + i3 + ", errMsg=" + str + ", categoryId=" + iGProCategoryChannelInfoList.getCategoryId());
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new QQGuildNavigatorConfigAddConfigFragment$saveAndFetchCategoryId$2$1(resultFun, i3, str, iGProCategoryChannelInfoList, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi() {
        boolean z16;
        boolean z17;
        Editable text = Yh().getText();
        Intrinsics.checkNotNullExpressionValue(text, "etNavName.text");
        if (text.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.iconUri != null) {
            Editable text2 = Xh().getText();
            Intrinsics.checkNotNullExpressionValue(text2, "etNavMagnet.text");
            if (text2.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this.J.h().setEnabled(true);
                this.J.h().setAlpha(1.0f);
                return;
            }
        }
        this.J.h().setEnabled(false);
        this.J.h().setAlpha(0.3f);
    }

    private final void setStatusBar() {
        QQGuildUIUtil.L(getActivity(), getResources().getColor(R.color.qui_common_bg_bottom_standard));
        boolean z16 = !GuildThemeManager.f235286a.b();
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        GuildThemeManager.i(z16, window);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setStatusBar();
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168138f10;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            long j3 = -99;
            if (data != null) {
                j3 = data.getLongExtra("resIconId", -99L);
            }
            if (data != null) {
                str = data.getStringExtra("resIconUri");
            } else {
                str = null;
            }
            this.iconId = Long.valueOf(j3);
            this.iconUri = str;
            mi(str);
            pi();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ci().j();
    }

    @Override // com.tencent.mobileqq.guild.window.s.c
    public void onSoftKeyboardClosed() {
        Yh().clearFocus();
        Xh().clearFocus();
    }

    @Override // com.tencent.mobileqq.guild.window.s.c
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            QQGuildNavigatorConfigAddConfigFragment.this.pi();
            if (s16 != null) {
                QQGuildNavigatorConfigAddConfigFragment.this.li(s16);
            }
            ImageView ivClearNavName = QQGuildNavigatorConfigAddConfigFragment.this.bi();
            Intrinsics.checkNotNullExpressionValue(ivClearNavName, "ivClearNavName");
            Editable text = QQGuildNavigatorConfigAddConfigFragment.this.Yh().getText();
            Intrinsics.checkNotNullExpressionValue(text, "etNavName.text");
            boolean z17 = true;
            int i3 = 0;
            if (text.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || !QQGuildNavigatorConfigAddConfigFragment.this.Yh().isFocused()) {
                z17 = false;
            }
            if (!z17) {
                i3 = 8;
            }
            ivClearNavName.setVisibility(i3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            QQGuildNavigatorConfigAddConfigFragment.this.pi();
            ImageView ivClearMagnet = QQGuildNavigatorConfigAddConfigFragment.this.ai();
            Intrinsics.checkNotNullExpressionValue(ivClearMagnet, "ivClearMagnet");
            Editable text = QQGuildNavigatorConfigAddConfigFragment.this.Xh().getText();
            Intrinsics.checkNotNullExpressionValue(text, "etNavMagnet.text");
            boolean z17 = true;
            int i3 = 0;
            if (text.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || !QQGuildNavigatorConfigAddConfigFragment.this.Xh().isFocused()) {
                z17 = false;
            }
            if (!z17) {
                i3 = 8;
            }
            ivClearMagnet.setVisibility(i3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
