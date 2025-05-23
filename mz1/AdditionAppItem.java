package mz1;

import androidx.core.app.NotificationCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mz1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b%\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001\u001bBa\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016Jp\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e\"\u0004\b \u0010!R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$R$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010!R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010*R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b6\u0010$\"\u0004\b7\u00108R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\"\u001a\u0004\b9\u0010$\"\u0004\b:\u00108\u00a8\u0006="}, d2 = {"Lmz1/a;", "Lmz1/c;", "", "getItemType", "", "getItemId", "newItem", "", "c", "b", "id", "appName", "jumpType", "iconUrl", "iconRes", "Lmz1/i;", NotificationCompat.CATEGORY_NAVIGATION, "isCanDragEdit", "editType", "flexType", "e", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Lmz1/i;ZII)Lmz1/a;", "toString", "hashCode", "", "other", "equals", "a", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "g", "p", "(Ljava/lang/String;)V", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "d", "k", "t", "Ljava/lang/Integer;", "j", "()Ljava/lang/Integer;", "f", "Lmz1/i;", DomainData.DOMAIN_NAME, "()Lmz1/i;", "u", "(Lmz1/i;)V", "Z", "o", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", tl.h.F, "r", "(I)V", "i", ReportConstant.COSTREPORT_PREFIX, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Lmz1/i;ZII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: mz1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class AdditionAppItem implements c {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final ArrayList<Integer> f417871k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int jumpType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer iconRes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private NavigatorItem navigation;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isCanDragEdit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int editType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int flexType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lmz1/a$a;", "", "", "categoryType", "", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ljava/util/ArrayList;", "Lmz1/a;", "a", "c", "(I)Ljava/lang/Integer;", "EDIT_TYPE_ADD", "I", "EDIT_TYPE_DELETE", "FLEX_TYPE_BASIS_33_PER", "FLEX_TYPE_BASIS_50_PER", "FLEX_TYPE_NO", "FLEX_TYPE_WRAP", "Lkotlin/collections/ArrayList;", "canConvertCategoryTypeOfCategoryChannelInfo", "Ljava/util/ArrayList;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mz1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(int categoryType) {
            if (categoryType != 2) {
                if (categoryType != 3) {
                    if (categoryType != 7) {
                        if (categoryType != 9) {
                            if (categoryType != 10) {
                                return "";
                            }
                            return "\u7b7e\u5230";
                        }
                        return "\u8bed\u97f3\u623f";
                    }
                    return "\u65e5\u7a0b";
                }
                return "\u76f4\u64ad";
            }
            return "\u8ba8\u8bba\u7ec4";
        }

        @NotNull
        public final ArrayList<AdditionAppItem> a(@NotNull IGProCategoryChannelInfoList item) {
            int i3;
            String str;
            Intrinsics.checkNotNullParameter(item, "item");
            ArrayList<AdditionAppItem> arrayList = new ArrayList<>();
            if (item.getCategoryType() == 11) {
                IGProNavigationV2Info navigation = item.getNavigation();
                if (navigation != null) {
                    String valueOf = String.valueOf(item.getCategoryId());
                    String title = navigation.getTitle();
                    Intrinsics.checkNotNullExpressionValue(title, "it.title");
                    long iconId = navigation.getIconId();
                    String iconUrl = navigation.getIconUrl();
                    Intrinsics.checkNotNullExpressionValue(iconUrl, "it.iconUrl");
                    String title2 = navigation.getTitle();
                    Intrinsics.checkNotNullExpressionValue(title2, "it.title");
                    String jumpUrl = navigation.getJumpUrl();
                    Intrinsics.checkNotNullExpressionValue(jumpUrl, "it.jumpUrl");
                    arrayList.add(new AdditionAppItem(valueOf, title, 11, navigation.getIconUrl(), null, new NavigatorItem(iconId, iconUrl, title2, jumpUrl, item.getCategoryId(), null, 32, null), false, 0, 0, 464, null));
                }
            } else if (AdditionAppItem.f417871k.contains(Integer.valueOf(item.getCategoryType()))) {
                AdditionAppItem additionAppItem = new AdditionAppItem(String.valueOf(item.getCategoryId()), b(item.getCategoryType()), item.getCategoryType(), null, c(item.getCategoryType()), null, false, 0, 0, 488, null);
                if (item.getCategoryType() == 7) {
                    ArrayList<IGProChannel> channelInfoList = item.getChannelInfoList();
                    boolean z16 = false;
                    if (channelInfoList != null) {
                        i3 = channelInfoList.size();
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 0) {
                        str = String.valueOf(item.getChannelInfoList().get(0).getChannelId());
                    } else {
                        str = "";
                    }
                    String str2 = str;
                    if (str2.length() > 0) {
                        z16 = true;
                    }
                    if (z16) {
                        additionAppItem.u(new NavigatorItem(0L, null, null, null, 0L, str2, 31, null));
                    }
                }
                arrayList.add(additionAppItem);
            }
            return arrayList;
        }

        @Nullable
        public final Integer c(int categoryType) {
            if (categoryType != 2) {
                if (categoryType != 3) {
                    if (categoryType != 7) {
                        if (categoryType != 9) {
                            if (categoryType != 10) {
                                return null;
                            }
                            return Integer.valueOf(R.drawable.guild_app_manage_check_in);
                        }
                        return Integer.valueOf(R.drawable.guild_channel_voice_p);
                    }
                    return Integer.valueOf(R.drawable.guild_app_manage_schedule);
                }
                return Integer.valueOf(R.drawable.guild_channel_video_p);
            }
            return Integer.valueOf(R.drawable.guild_channel_text_chat_p);
        }

        Companion() {
        }
    }

    static {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2, 3, 9, 7, 10, 11);
        f417871k = arrayListOf;
    }

    public AdditionAppItem(@NotNull String id5, @NotNull String appName, int i3, @Nullable String str, @Nullable Integer num, @Nullable NavigatorItem navigatorItem, boolean z16, int i16, int i17) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.id = id5;
        this.appName = appName;
        this.jumpType = i3;
        this.iconUrl = str;
        this.iconRes = num;
        this.navigation = navigatorItem;
        this.isCanDragEdit = z16;
        this.editType = i16;
        this.flexType = i17;
    }

    public static /* synthetic */ AdditionAppItem f(AdditionAppItem additionAppItem, String str, String str2, int i3, String str3, Integer num, NavigatorItem navigatorItem, boolean z16, int i16, int i17, int i18, Object obj) {
        String str4;
        String str5;
        int i19;
        String str6;
        Integer num2;
        NavigatorItem navigatorItem2;
        boolean z17;
        int i26;
        int i27;
        if ((i18 & 1) != 0) {
            str4 = additionAppItem.id;
        } else {
            str4 = str;
        }
        if ((i18 & 2) != 0) {
            str5 = additionAppItem.appName;
        } else {
            str5 = str2;
        }
        if ((i18 & 4) != 0) {
            i19 = additionAppItem.jumpType;
        } else {
            i19 = i3;
        }
        if ((i18 & 8) != 0) {
            str6 = additionAppItem.iconUrl;
        } else {
            str6 = str3;
        }
        if ((i18 & 16) != 0) {
            num2 = additionAppItem.iconRes;
        } else {
            num2 = num;
        }
        if ((i18 & 32) != 0) {
            navigatorItem2 = additionAppItem.navigation;
        } else {
            navigatorItem2 = navigatorItem;
        }
        if ((i18 & 64) != 0) {
            z17 = additionAppItem.isCanDragEdit;
        } else {
            z17 = z16;
        }
        if ((i18 & 128) != 0) {
            i26 = additionAppItem.editType;
        } else {
            i26 = i16;
        }
        if ((i18 & 256) != 0) {
            i27 = additionAppItem.flexType;
        } else {
            i27 = i17;
        }
        return additionAppItem.e(str4, str5, i19, str6, num2, navigatorItem2, z17, i26, i27);
    }

    @Override // mz1.c
    @Nullable
    public Object a(@NotNull c cVar) {
        return c.a.a(this, cVar);
    }

    @Override // mz1.c
    public boolean b(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof AdditionAppItem)) {
            return false;
        }
        AdditionAppItem additionAppItem = (AdditionAppItem) newItem;
        if (!Intrinsics.areEqual(this.appName, additionAppItem.appName) || !Intrinsics.areEqual(this.iconUrl, additionAppItem.iconUrl) || !Intrinsics.areEqual(this.iconRes, additionAppItem.iconRes) || this.editType != additionAppItem.editType || this.flexType != additionAppItem.flexType || this.isCanDragEdit != additionAppItem.isCanDragEdit) {
            return false;
        }
        return true;
    }

    @Override // mz1.c
    public boolean c(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof AdditionAppItem)) {
            return false;
        }
        return Intrinsics.areEqual(getItemId(), newItem.getItemId());
    }

    @NotNull
    public final AdditionAppItem e(@NotNull String id5, @NotNull String appName, int jumpType, @Nullable String iconUrl, @Nullable Integer iconRes, @Nullable NavigatorItem navigation, boolean isCanDragEdit, int editType, int flexType) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(appName, "appName");
        return new AdditionAppItem(id5, appName, jumpType, iconUrl, iconRes, navigation, isCanDragEdit, editType, flexType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdditionAppItem)) {
            return false;
        }
        AdditionAppItem additionAppItem = (AdditionAppItem) other;
        if (Intrinsics.areEqual(this.id, additionAppItem.id) && Intrinsics.areEqual(this.appName, additionAppItem.appName) && this.jumpType == additionAppItem.jumpType && Intrinsics.areEqual(this.iconUrl, additionAppItem.iconUrl) && Intrinsics.areEqual(this.iconRes, additionAppItem.iconRes) && Intrinsics.areEqual(this.navigation, additionAppItem.navigation) && this.isCanDragEdit == additionAppItem.isCanDragEdit && this.editType == additionAppItem.editType && this.flexType == additionAppItem.flexType) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @Override // mz1.c
    @NotNull
    public String getItemId() {
        return "addition_app_item_" + this.id;
    }

    @Override // mz1.c
    public int getItemType() {
        return 1;
    }

    /* renamed from: h, reason: from getter */
    public final int getEditType() {
        return this.editType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((this.id.hashCode() * 31) + this.appName.hashCode()) * 31) + this.jumpType) * 31;
        String str = this.iconUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        Integer num = this.iconRes;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        NavigatorItem navigatorItem = this.navigation;
        if (navigatorItem != null) {
            i3 = navigatorItem.hashCode();
        }
        int i18 = (i17 + i3) * 31;
        boolean z16 = this.isCanDragEdit;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        return ((((i18 + i19) * 31) + this.editType) * 31) + this.flexType;
    }

    /* renamed from: i, reason: from getter */
    public final int getFlexType() {
        return this.flexType;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final Integer getIconRes() {
        return this.iconRes;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: m, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final NavigatorItem getNavigation() {
        return this.navigation;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsCanDragEdit() {
        return this.isCanDragEdit;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void q(boolean z16) {
        this.isCanDragEdit = z16;
    }

    public final void r(int i3) {
        this.editType = i3;
    }

    public final void s(int i3) {
        this.flexType = i3;
    }

    public final void t(@Nullable String str) {
        this.iconUrl = str;
    }

    @NotNull
    public String toString() {
        return "AdditionAppItem(id=" + this.id + ", appName=" + this.appName + ", jumpType=" + this.jumpType + ", iconUrl=" + this.iconUrl + ", iconRes=" + this.iconRes + ", navigation=" + this.navigation + ", isCanDragEdit=" + this.isCanDragEdit + ", editType=" + this.editType + ", flexType=" + this.flexType + ")";
    }

    public final void u(@Nullable NavigatorItem navigatorItem) {
        this.navigation = navigatorItem;
    }

    public /* synthetic */ AdditionAppItem(String str, String str2, int i3, String str3, Integer num, NavigatorItem navigatorItem, boolean z16, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, (i18 & 8) != 0 ? null : str3, (i18 & 16) != 0 ? null : num, (i18 & 32) != 0 ? null : navigatorItem, (i18 & 64) != 0 ? false : z16, (i18 & 128) != 0 ? 0 : i16, (i18 & 256) != 0 ? 0 : i17);
    }
}
