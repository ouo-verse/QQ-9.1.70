package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildNavigationInfo;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import com.tencent.mobileqq.qqguildsdk.data.genc.ea;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cq;
import wh2.ct;
import wh2.dy;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\u0018\u0000 \u0083\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0084\u0001B\t\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0005J\u0014\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fJ\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J/\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u001d\u0010\u001a\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00050\u0016\u00a2\u0006\u0002\b\u0019J\u0006\u0010\u001c\u001a\u00020\u0005J&\u0010\"\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eJ\u001c\u0010$\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fJ\u0006\u0010%\u001a\u00020\u0005R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R.\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\t018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R(\u0010=\u001a\b\u0012\u0004\u0012\u0002090\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010'\u001a\u0004\b;\u0010)\"\u0004\b<\u0010+R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010I\u001a\b\u0012\u0004\u0012\u00020>018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u00103\u001a\u0004\bG\u00105\"\u0004\bH\u00107R$\u0010P\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010X\u001a\u00020Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR(\u0010]\u001a\b\u0012\u0004\u0012\u00020Y018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u00103\u001a\u0004\b[\u00105\"\u0004\b\\\u00107R\u0016\u0010_\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010ZR(\u0010c\u001a\b\u0012\u0004\u0012\u00020>018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u00103\u001a\u0004\ba\u00105\"\u0004\bb\u00107R\"\u0010f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0017\u0010m\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\bj\u0010Z\u001a\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010^R\"\u0010s\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010e\u001a\u0004\bq\u0010g\"\u0004\br\u0010iR\"\u0010w\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010e\u001a\u0004\bu\u0010g\"\u0004\bv\u0010iR\"\u0010{\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010e\u001a\u0004\by\u0010g\"\u0004\bz\u0010iR#\u0010\u0080\u0001\u001a\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b|\u0010Z\u001a\u0004\b}\u0010l\"\u0004\b~\u0010\u007f\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/viewmodel/QQGuildNavigatorConfigViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/viewmodel/d;", "", "guildId", "", "i2", "m2", "x2", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/GuildNavigationInfo;", "infoList", "y2", "Lwh2/ct;", "resFun", "Lkotlin/Function0;", "compatibleFun", "T1", "P1", ICustomDataEditor.NUMBER_PARAM_2, "", "isSupplyAddConfigUi", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c;", "Lkotlin/ExtensionFunctionType;", "block", "Q1", "w2", "iconId", "", "iconUri", "configName", "magnet", "z2", "successFun", "o2", "S1", "i", "Ljava/util/List;", "W1", "()Ljava/util/List;", "setConfigList", "(Ljava/util/List;)V", "configList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z1", "setConfigListSortBeginCache", "configListSortBeginCache", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "X1", "()Landroidx/lifecycle/MutableLiveData;", "setConfigListLD", "(Landroidx/lifecycle/MutableLiveData;)V", "configListLD", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildNavIconTheme;", "D", "l2", "setThemeIconList", "themeIconList", "", "E", "Ljava/lang/Integer;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Ljava/lang/Integer;", "q2", "(Ljava/lang/Integer;)V", "currentEditConfig", UserInfo.SEX_FEMALE, "k2", "setPageStatusLD", "pageStatusLD", "G", "Ljava/lang/String;", "b2", "()Ljava/lang/String;", "r2", "(Ljava/lang/String;)V", "currentIconSelectorColor", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "H", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "getHomeCoverColors", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "v2", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "homeCoverColors", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", "I", "g2", "setNavigationBarLive", "navigationBarLive", "J", "navMaxNum", "K", SemanticAttributes.DbSystemValues.H2, "setNavigationMaxNum", "navigationMaxNum", "L", "Z", "isNavigatorExpand", "()Z", "setNavigatorExpand", "(Z)V", "M", "getRandomNum", "()I", "randomNum", "N", "navigationVersion", "P", "d2", "t2", "enableShowNavBar", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f2", "u2", "hasNavigationInfo", BdhLogUtil.LogTag.Tag_Req, "e2", "setHasCommitted", "hasCommitted", ExifInterface.LATITUDE_SOUTH, "c2", ICustomDataEditor.STRING_PARAM_2, "(I)V", "defaultAuditStatus", "<init>", "()V", "T", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildNavigatorConfigViewModel extends com.tencent.mobileqq.mvvm.c<d> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>> configListLD;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<IGProGuildNavIconTheme> themeIconList;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Integer currentEditConfig;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> pageStatusLD;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String currentIconSelectorColor;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private GuildHomeCoverColors homeCoverColors;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<GuildHomeHeaderNavigationBar> navigationBarLive;

    /* renamed from: J, reason: from kotlin metadata */
    private int navMaxNum;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> navigationMaxNum;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isNavigatorExpand;

    /* renamed from: M, reason: from kotlin metadata */
    private final int randomNum;

    /* renamed from: N, reason: from kotlin metadata */
    private long navigationVersion;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean enableShowNavBar;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasNavigationInfo;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean hasCommitted;

    /* renamed from: S, reason: from kotlin metadata */
    private int defaultAuditStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> configList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> configListSortBeginCache;

    public QQGuildNavigatorConfigViewModel() {
        super(new d());
        this.configList = new ArrayList();
        this.configListSortBeginCache = new ArrayList();
        this.configListLD = new MutableLiveData<>();
        this.themeIconList = new ArrayList();
        this.pageStatusLD = new MutableLiveData<>();
        this.homeCoverColors = GuildHomeCoverColors.INSTANCE.c(0, -1);
        this.navigationBarLive = new MutableLiveData<>();
        this.navMaxNum = 4;
        this.navigationMaxNum = new MutableLiveData<>(4);
        this.randomNum = Random.INSTANCE.nextInt(0, 14);
        this.navigationVersion = -99L;
        this.enableShowNavBar = true;
        this.hasNavigationInfo = true;
        this.pageStatusLD.postValue(4);
        this.configListLD.postValue(this.configList);
    }

    public static /* synthetic */ void R1(QQGuildNavigatorConfigViewModel qQGuildNavigatorConfigViewModel, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        qQGuildNavigatorConfigViewModel.Q1(z16, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.util.ArrayList] */
    public static final void U1(QQGuildNavigatorConfigViewModel this$0, long j3, Function0 function0, ct resFun, final int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
        boolean z16;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List list;
        ArrayList<IGProGuildNavIconInfo> arrayList;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resFun, "$resFun");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        if (i3 == 0) {
            int total = iGProGetPreviewNavigationRsp.getTotal();
            this$0.navMaxNum = total;
            this$0.navigationMaxNum.postValue(Integer.valueOf(total));
            IGProGuildNavigationInfo guildNavigation = iGProGetPreviewNavigationRsp.getGuildNavigation();
            ArrayList<IGProNavigationV2Info> navigationList = iGProGetPreviewNavigationRsp.getGuildNavigation().getNavigationList();
            Intrinsics.checkNotNullExpressionValue(navigationList, "resp.guildNavigation.navigationList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(navigationList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (IGProNavigationV2Info iGProNavigationV2Info : navigationList) {
                String iconUrl = iGProNavigationV2Info.getIconUrl();
                Intrinsics.checkNotNullExpressionValue(iconUrl, "it.iconUrl");
                String title = iGProNavigationV2Info.getTitle();
                Intrinsics.checkNotNullExpressionValue(title, "it.title");
                String jumpUrl = iGProNavigationV2Info.getJumpUrl();
                Intrinsics.checkNotNullExpressionValue(jumpUrl, "it.jumpUrl");
                int jumpUrlType = iGProNavigationV2Info.getJumpUrlType();
                boolean showBubble = iGProNavigationV2Info.getShowBubble();
                String bubbleDesc = iGProNavigationV2Info.getBubbleDesc();
                Intrinsics.checkNotNullExpressionValue(bubbleDesc, "it.bubbleDesc");
                arrayList2.add(new GuildNavigationInfo(iconUrl, title, jumpUrl, jumpUrlType, showBubble, bubbleDesc));
            }
            GuildHomeHeaderNavigationBar a16 = GuildHomeHeaderNavigationBar.INSTANCE.a(String.valueOf(j3), this$0.homeCoverColors, arrayList2, this$0.isNavigatorExpand);
            Logger.f235387a.d().d("QQGuildNavigatorConfigViewModel", 1, "[fetchConfigInfo] guildId:" + j3 + ", maxSize:" + this$0.navMaxNum + ", infoListSize:" + arrayList2.size());
            this$0.navigationBarLive.postValue(a16);
            this$0.navigationVersion = guildNavigation.getVersion();
            ArrayList<IGProNavigationV2Info> navigationList2 = guildNavigation.getNavigationList();
            Intrinsics.checkNotNullExpressionValue(navigationList2, "navInfo.navigationList");
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(navigationList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            for (IGProNavigationV2Info it : navigationList2) {
                c.Companion companion = com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList3.add(companion.a(it));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList3);
            ((List) objectRef.element).addAll(list);
            ArrayList<IGProGuildNavIconTheme> iconThemes = iGProGetPreviewNavigationRsp.getIconThemes();
            Intrinsics.checkNotNullExpressionValue(iconThemes, "resp.iconThemes");
            Iterator<T> it5 = iconThemes.iterator();
            while (true) {
                arrayList = null;
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((IGProGuildNavIconTheme) obj).getIconSelectorColor(), this$0.currentIconSelectorColor)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProGuildNavIconTheme iGProGuildNavIconTheme = (IGProGuildNavIconTheme) obj;
            if (iGProGuildNavIconTheme != null) {
                arrayList = iGProGuildNavIconTheme.getIcons();
            }
            if (arrayList != null) {
                int size = ((List) objectRef.element).size();
                for (int i16 = 0; i16 < size; i16++) {
                    com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar = (com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c) ((List) objectRef.element).get(i16);
                    int size2 = arrayList.size();
                    int i17 = 0;
                    while (true) {
                        if (i17 < size2) {
                            IGProGuildNavIconInfo iGProGuildNavIconInfo = arrayList.get(i17);
                            if (iGProGuildNavIconInfo.getIconId() == cVar.getId()) {
                                ((List) objectRef.element).set(i16, com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c.d(cVar, null, iGProGuildNavIconInfo.getIconUrl(), null, null, null, 29, null));
                                break;
                            }
                            i17++;
                        }
                    }
                }
            }
            this$0.themeIconList.clear();
            List<IGProGuildNavIconTheme> list2 = this$0.themeIconList;
            ArrayList<IGProGuildNavIconTheme> iconThemes2 = iGProGetPreviewNavigationRsp.getIconThemes();
            Intrinsics.checkNotNullExpressionValue(iconThemes2, "resp.iconThemes");
            list2.addAll(iconThemes2);
            int auditStatus = guildNavigation.getAuditStatus();
            int i18 = 2;
            if (auditStatus != 1 && auditStatus != 2) {
                if (auditStatus != 3) {
                    if (auditStatus != 4) {
                        if (auditStatus != 6) {
                            i18 = 4;
                        }
                    }
                }
                i18 = 3;
            }
            this$0.pageStatusLD.postValue(Integer.valueOf(i18));
            if (guildNavigation.getCompatibleFlag() == 1) {
                ((List) objectRef.element).clear();
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.Q1(z16, new Function1<List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.QQGuildNavigatorConfigViewModel$fetchConfigInfo$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> list3) {
                invoke2(list3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> editConfigList) {
                Intrinsics.checkNotNullParameter(editConfigList, "$this$editConfigList");
                if (i3 == 0) {
                    editConfigList.clear();
                    editConfigList.addAll(objectRef.element);
                } else if (editConfigList.isEmpty()) {
                    editConfigList.add(new com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.b());
                }
            }
        });
        resFun.a(i3, str, iGProGetPreviewNavigationRsp);
    }

    private final void i2(long guildId) {
        getRepository().o(guildId, new cq() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.e
            @Override // wh2.cq
            public final void a(int i3, String str, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
                QQGuildNavigatorConfigViewModel.j2(QQGuildNavigatorConfigViewModel.this, i3, str, iGProGetNavigationStatusRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(QQGuildNavigatorConfigViewModel this$0, int i3, String str, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            boolean z17 = false;
            if (iGProGetNavigationStatusRsp.getEnableSetting() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this$0.enableShowNavBar = z16;
            if (iGProGetNavigationStatusRsp.getExistNavigation() == 1) {
                z17 = true;
            }
            this$0.hasNavigationInfo = z17;
            this$0.defaultAuditStatus = iGProGetNavigationStatusRsp.getAuditStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(QQGuildNavigatorConfigViewModel this$0, Ref.ObjectRef reqConfigList, Function0 successFun, int i3, String str) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reqConfigList, "$reqConfigList");
        Intrinsics.checkNotNullParameter(successFun, "$successFun");
        if (i3 == 0) {
            this$0.pageStatusLD.postValue(2);
            this$0.hasNavigationInfo = !((Collection) reqConfigList.element).isEmpty();
            this$0.hasCommitted = true;
            BaseApplication context = BaseApplication.getContext();
            BaseApplication context2 = BaseApplication.getContext();
            if (!((Collection) reqConfigList.element).isEmpty()) {
                i16 = R.string.f142500jj;
            } else {
                i16 = R.string.f158071om;
            }
            QQToast.makeText(context, 2, context2.getString(i16), 1).show();
            successFun.invoke();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, str, 1).show();
    }

    public final void P1() {
        this.configListSortBeginCache.clear();
        this.configListSortBeginCache.addAll(this.configList);
    }

    public final void Q1(boolean isSupplyAddConfigUi, @NotNull Function1<? super List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.configList);
        block.invoke(arrayList);
        this.configList = arrayList;
        if (isSupplyAddConfigUi) {
            w2();
        }
        this.configListLD.postValue(this.configList);
    }

    public final void S1() {
        Integer value = this.pageStatusLD.getValue();
        if (value == null || value.intValue() != 1) {
            this.pageStatusLD.postValue(1);
        }
    }

    public final void T1(final long guildId, @NotNull final ct resFun, @Nullable final Function0<Unit> compatibleFun) {
        Intrinsics.checkNotNullParameter(resFun, "resFun");
        getRepository().m(guildId, new ct() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.g
            @Override // wh2.ct
            public final void a(int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
                QQGuildNavigatorConfigViewModel.U1(QQGuildNavigatorConfigViewModel.this, guildId, compatibleFun, resFun, i3, str, iGProGetPreviewNavigationRsp);
            }
        });
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> W1() {
        return this.configList;
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>> X1() {
        return this.configListLD;
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> Z1() {
        return this.configListSortBeginCache;
    }

    @Nullable
    /* renamed from: a2, reason: from getter */
    public final Integer getCurrentEditConfig() {
        return this.currentEditConfig;
    }

    @Nullable
    /* renamed from: b2, reason: from getter */
    public final String getCurrentIconSelectorColor() {
        return this.currentIconSelectorColor;
    }

    /* renamed from: c2, reason: from getter */
    public final int getDefaultAuditStatus() {
        return this.defaultAuditStatus;
    }

    /* renamed from: d2, reason: from getter */
    public final boolean getEnableShowNavBar() {
        return this.enableShowNavBar;
    }

    /* renamed from: e2, reason: from getter */
    public final boolean getHasCommitted() {
        return this.hasCommitted;
    }

    /* renamed from: f2, reason: from getter */
    public final boolean getHasNavigationInfo() {
        return this.hasNavigationInfo;
    }

    @NotNull
    public final MutableLiveData<GuildHomeHeaderNavigationBar> g2() {
        return this.navigationBarLive;
    }

    @NotNull
    public final MutableLiveData<Integer> h2() {
        return this.navigationMaxNum;
    }

    @NotNull
    public final MutableLiveData<Integer> k2() {
        return this.pageStatusLD;
    }

    @NotNull
    public final List<IGProGuildNavIconTheme> l2() {
        return this.themeIconList;
    }

    public final void m2(long guildId) {
        i2(guildId);
    }

    public final void n2() {
        R1(this, false, new Function1<List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.QQGuildNavigatorConfigViewModel$revertToCacheBegin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> editConfigList) {
                Intrinsics.checkNotNullParameter(editConfigList, "$this$editConfigList");
                editConfigList.clear();
                editConfigList.addAll(QQGuildNavigatorConfigViewModel.this.Z1());
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List, T] */
    public final void o2(long guildId, @NotNull final Function0<Unit> successFun) {
        int collectionSizeOrDefault;
        ?? mutableList;
        boolean z16;
        Intrinsics.checkNotNullParameter(successFun, "successFun");
        String str = this.currentIconSelectorColor;
        if (str != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> list = this.configList;
            ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> arrayList = new ArrayList();
            for (Object obj : list) {
                com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar = (com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c) obj;
                if (!(cVar instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a) && !(cVar instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.b)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar2 : arrayList) {
                ea eaVar = new ea();
                eaVar.f(cVar2.getId());
                eaVar.g(cVar2.getSubDesc());
                eaVar.h(cVar2.getConfigName());
                arrayList2.add(eaVar);
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
            objectRef.element = mutableList;
            d repository = getRepository();
            long j3 = this.navigationVersion;
            T t16 = objectRef.element;
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.GWGProSaveNavigationItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.GWGProSaveNavigationItem> }");
            repository.q(guildId, str, j3, (ArrayList) t16, new dy() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.f
                @Override // wh2.dy
                public final void onSaveGuildNavigation(int i3, String str2) {
                    QQGuildNavigatorConfigViewModel.p2(QQGuildNavigatorConfigViewModel.this, objectRef, successFun, i3, str2);
                }
            });
        }
    }

    public final void q2(@Nullable Integer num) {
        this.currentEditConfig = num;
    }

    public final void r2(@Nullable String str) {
        this.currentIconSelectorColor = str;
    }

    public final void s2(int i3) {
        this.defaultAuditStatus = i3;
    }

    public final void t2(boolean z16) {
        this.enableShowNavBar = z16;
    }

    public final void u2(boolean z16) {
        this.hasNavigationInfo = z16;
    }

    public final void v2(@NotNull GuildHomeCoverColors guildHomeCoverColors) {
        Intrinsics.checkNotNullParameter(guildHomeCoverColors, "<set-?>");
        this.homeCoverColors = guildHomeCoverColors;
    }

    public final void w2() {
        Object lastOrNull;
        boolean z16;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.configList);
        if (!(lastOrNull instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a) && this.configList.size() < this.navMaxNum) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.configList.isEmpty() || z16) {
            this.configList.add(new com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a());
        }
    }

    public final void x2() {
        GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar;
        this.isNavigatorExpand = !this.isNavigatorExpand;
        MutableLiveData<GuildHomeHeaderNavigationBar> mutableLiveData = this.navigationBarLive;
        GuildHomeHeaderNavigationBar value = mutableLiveData.getValue();
        if (value != null) {
            guildHomeHeaderNavigationBar = GuildHomeHeaderNavigationBar.i(value, false, null, null, null, this.isNavigatorExpand, false, 15, null);
        } else {
            guildHomeHeaderNavigationBar = null;
        }
        mutableLiveData.postValue(guildHomeHeaderNavigationBar);
    }

    public final void y2(@NotNull List<GuildNavigationInfo> infoList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        GuildHomeHeaderNavigationBar value = this.navigationBarLive.getValue();
        if (value != null) {
            if (!value.getIsExpand() ? !(value.k().size() > 5 || infoList.size() <= 5) : !(value.k().size() > 5 && infoList.size() <= 5)) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.navigationBarLive.postValue(GuildHomeHeaderNavigationBar.i(value, false, null, null, infoList, z16, true, 7, null));
        }
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [T, com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c] */
    public final void z2(long iconId, @NotNull String iconUri, @NotNull String configName, @NotNull String magnet) {
        Intrinsics.checkNotNullParameter(iconUri, "iconUri");
        Intrinsics.checkNotNullParameter(configName, "configName");
        Intrinsics.checkNotNullParameter(magnet, "magnet");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c(iconId, iconUri, configName, magnet, false, null, 32, null);
        R1(this, false, new Function1<List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.QQGuildNavigatorConfigViewModel$updateNewNavConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> editConfigList) {
                Intrinsics.checkNotNullParameter(editConfigList, "$this$editConfigList");
                Integer currentEditConfig = QQGuildNavigatorConfigViewModel.this.getCurrentEditConfig();
                if (currentEditConfig != null) {
                    editConfigList.set(currentEditConfig.intValue(), objectRef.element);
                }
            }
        }, 1, null);
        S1();
    }
}
