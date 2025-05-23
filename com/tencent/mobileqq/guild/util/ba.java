package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/util/ba;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/util/ba$a;", "", "", "a", "", "guildId", "d", "Liz1/a;", "confBean", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJumpToCategoryInfo;", "jumpToCategoryInfo", "c", "subCategoryType", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.util.ba$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a() {
            if (((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).isSelectHotPageByAB()) {
                return 2;
            }
            return 1;
        }

        @NotNull
        public final String b(int subCategoryType) {
            int i3 = R.string.f140920f_;
            if (subCategoryType != 1) {
                if (subCategoryType != 2) {
                    if (subCategoryType == 3) {
                        i3 = R.string.f140930fa;
                    }
                } else {
                    i3 = R.string.f145420rf;
                }
            }
            String qqStr = HardCodeUtil.qqStr(i3);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(\n                w\u2026          }\n            )");
            return qqStr;
        }

        public final int c(@NotNull iz1.a confBean, @NotNull IGProJumpToCategoryInfo jumpToCategoryInfo) {
            Intrinsics.checkNotNullParameter(confBean, "confBean");
            Intrinsics.checkNotNullParameter(jumpToCategoryInfo, "jumpToCategoryInfo");
            Logger.f235387a.d().d("GuildSubCategoryUtils", 1, "[getSubCategoryType with params] jumpToCategoryInfo.feedSortType: " + jumpToCategoryInfo.getFeedSortType() + ", confBean.defaultSortType:" + confBean.getDefaultSortType());
            if (jumpToCategoryInfo.getFeedSortType() == 0) {
                if (confBean.getDefaultSortType() == 0) {
                    return a();
                }
                return confBean.getDefaultSortType();
            }
            return jumpToCategoryInfo.getFeedSortType();
        }

        public final int d(@NotNull String guildId) {
            int a16;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            int a17 = a();
            iz1.a aVar = (iz1.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102934");
            Unit unit = null;
            if (aVar != null) {
                Logger logger = Logger.f235387a;
                logger.d().d("GuildSubCategoryUtils", 1, "[getSubCategoryType] FEED_SQUARE config enable:" + aVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String());
                if (aVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String()) {
                    IGProJumpToCategoryInfo jumpToCategory = ((IGPSService) ch.S0(IGPSService.class, "")).getJumpToCategory(guildId);
                    if (jumpToCategory != null) {
                        a17 = ba.INSTANCE.c(aVar, jumpToCategory);
                        logger.d().d("GuildSubCategoryUtils", 1, "[getSubCategoryType] getCategoryType normal");
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        Companion companion = ba.INSTANCE;
                        logger.d().d("GuildSubCategoryUtils", 1, "[getSubCategoryType] jumpToCategory is null, use AB Test");
                        a16 = companion.a();
                    }
                    unit = Unit.INSTANCE;
                } else {
                    a16 = ba.INSTANCE.a();
                }
                a17 = a16;
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Logger.f235387a.d().d("GuildSubCategoryUtils", 1, "[getSubCategoryType] confBean is null, use AB Test");
                a17 = a();
            }
            Logger.f235387a.d().d("GuildSubCategoryUtils", 1, "[getSubCategoryType] getSubCategoryType result is:" + a17);
            return a17;
        }

        Companion() {
        }
    }
}
