package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bo1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xi1.BatchManageOperate;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0005\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J:\u0010\u0014\u001a\u00020\u000220\u0010\u0013\u001a,\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u000f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\nj\u0002`\u0012H\u0002J \u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010-\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "M9", "E9", "com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultTitlePart$b", "H9", "()Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultTitlePart$b;", "N9", "P9", "Lbo1/a$e;", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResult;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchExtraArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchSuccessState;", "newState", "L9", "", "title", "subtitle", "J9", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "d", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "navBar", "Landroidx/lifecycle/MutableLiveData;", "", "e", "Landroidx/lifecycle/MutableLiveData;", "titleLiveData", "Lvi1/f;", "f", "Lkotlin/Lazy;", "getBatchSelectManager", "()Lvi1/f;", "batchSelectManager", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchResultTitlePart extends Part {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f218257h = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildDefaultThemeNavBarCommon navBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String[]> titleLiveData = new MutableLiveData<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy batchSelectManager;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultTitlePart$a;", "", "", "DEFAULT_TITLE", "Ljava/lang/String;", "", "ELLIPSIZE_START_LENGTH", "I", "SUB_TITLE_INDEX", "SUB_TITLE_TIP_ERROR", "SUB_TITLE_TIP_LOADING", "TITLE_INDEX", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchResultTitlePart$b", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "", "a", "Landroid/view/View;", "view", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onItemSelect", "v", "", "onItemLongClick", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildDefaultThemeNavBarCommon.a {
        b() {
        }

        private final void a() {
            FeedBatchManageSearchResultTitlePart.this.E9();
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@NotNull View view, int item) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (item == 1) {
                a();
            }
        }
    }

    public FeedBatchManageSearchResultTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<vi1.f>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultTitlePart$batchSelectManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final vi1.f invoke() {
                return (vi1.f) PartIOCKt.getIocInterface(FeedBatchManageSearchResultTitlePart.this, vi1.f.class);
            }
        });
        this.batchSelectManager = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9() {
        Integer num;
        LiveData<BatchManageOperate> i3;
        BatchManageOperate value;
        LiveData<BatchManageOperate> i16;
        BatchManageOperate value2;
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        String str = null;
        if (fVar != null && (i16 = fVar.i()) != null && (value2 = i16.getValue()) != null) {
            num = value2.getSelectCount();
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        vi1.f fVar2 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar2 != null && (i3 = fVar2.i()) != null && (value = i3.getValue()) != null) {
            str = value.getSelectedDesc();
        }
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u4f60\u5df2\u9009\u4e2d" + str + "\u7bc7\u5e16\u5b50\uff0c\u662f\u5426\u9000\u51fa\uff1f", getContext().getString(R.string.cancel), "\u9000\u51fa", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i17) {
                FeedBatchManageSearchResultTitlePart.F9(FeedBatchManageSearchResultTitlePart.this, dialogInterface, i17);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i17) {
                FeedBatchManageSearchResultTitlePart.G9(dialogInterface, i17);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(FeedBatchManageSearchResultTitlePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final b H9() {
        return new b();
    }

    private final String I9(String title) {
        boolean z16;
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        String str = null;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        TextView textView = (TextView) guildDefaultThemeNavBarCommon.findViewById(R.id.jq5);
        if (textView == null) {
            return "\u76f8\u5173\u7ed3\u679c";
        }
        int min = Math.min(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight()) - (getContext().getResources().getDimensionPixelSize(R.dimen.c_n) << 1);
        bl1.b bVar = bl1.b.f28597a;
        String string = getContext().getString(R.string.f145230qx, "");
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026arch_relative_result, \"\")");
        String d16 = bVar.d(textView, title, 3, min, string);
        if (d16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d16 = null;
        }
        if (d16 != null) {
            str = getContext().getString(R.string.f145230qx, d16);
        }
        if (str == null) {
            return "\u76f8\u5173\u7ed3\u679c";
        }
        return str;
    }

    private final void J9(String title, String subtitle) {
        String[] value = this.titleLiveData.getValue();
        if (value == null) {
            value = new String[]{"", ""};
        }
        if (title != null) {
            value[0] = I9(title);
        }
        if (subtitle != null) {
            value[1] = subtitle;
        }
        this.titleLiveData.setValue(value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void K9(FeedBatchManageSearchResultTitlePart feedBatchManageSearchResultTitlePart, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        feedBatchManageSearchResultTitlePart.J9(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(a.SuccessState<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs> newState) {
        boolean z16;
        int total;
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> a16 = newState.d().a();
        int i3 = 0;
        if (a16 != null && !a16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Context context = getContext();
        Object[] objArr = new Object[1];
        if (z16) {
            total = 0;
        } else {
            total = newState.d().getTotal();
        }
        objArr[0] = Integer.valueOf(total);
        String string = context.getString(R.string.f145240qy, objArr);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = null;
        K9(this, null, string, 1, null);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.navBar;
        if (guildDefaultThemeNavBarCommon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
        } else {
            guildDefaultThemeNavBarCommon = guildDefaultThemeNavBarCommon2;
        }
        if (z16) {
            i3 = 4;
        }
        guildDefaultThemeNavBarCommon.setRightViewTextVisible(i3);
    }

    private final void M9() {
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.setOnItemSelectListener(H9());
    }

    private final void N9() {
        String b16;
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.setLeftBackVisible(0);
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar != null && (b16 = vi1.c.b(bVar)) != null) {
            K9(this, b16, null, 2, null);
        }
        MutableLiveData<String[]> mutableLiveData = this.titleLiveData;
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<String[], Unit> function1 = new Function1<String[], Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultTitlePart$setUpTitleText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
                invoke2(strArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String[] strArr) {
                GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2;
                guildDefaultThemeNavBarCommon2 = FeedBatchManageSearchResultTitlePart.this.navBar;
                if (guildDefaultThemeNavBarCommon2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navBar");
                    guildDefaultThemeNavBarCommon2 = null;
                }
                guildDefaultThemeNavBarCommon2.setSubTitleWithIcon(strArr[0], strArr[1], null);
            }
        };
        mutableLiveData.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedBatchManageSearchResultTitlePart.O9(Function1.this, obj);
            }
        });
        P9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P9() {
        com.tencent.mobileqq.guild.feed.part.a.d(this).launchWhenStarted(new FeedBatchManageSearchResultTitlePart$startTitleRefreshStateCollector$1(this, null));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        E9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.rlCommenTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rlCommenTitle)");
        this.navBar = (GuildDefaultThemeNavBarCommon) findViewById;
        N9();
        M9();
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(DialogInterface dialogInterface, int i3) {
    }
}
