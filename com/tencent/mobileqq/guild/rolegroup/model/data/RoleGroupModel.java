package com.tencent.mobileqq.guild.rolegroup.model.data;

import android.graphics.Color;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.Desc;
import com.tencent.mobileqq.qqguildsdk.data.GProRolePermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.ek;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b;\b\u0086\b\u0018\u0000 02\u00020\u0001:\u0001(B\u00af\u0001\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020\u000f\u00a2\u0006\u0004\bZ\u0010[J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u00b1\u0001\u0010$\u001a\u00020\u00002\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0003\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u000fH\u00c6\u0001J\t\u0010%\u001a\u00020\u000fH\u00d6\u0001J\t\u0010&\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010'\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b$\u00104\u001a\u0004\b5\u00106R\"\u0010\u0013\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00104\u001a\u0004\b8\u00106\"\u0004\b9\u0010:R\u0017\u0010\u0014\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b;\u0010/\u001a\u0004\b<\u00101R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010/\u001a\u0004\b=\u00101\"\u0004\bB\u00103R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010>\u001a\u0004\bC\u0010@\"\u0004\bD\u0010ER\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\bF\u00101\"\u0004\bG\u00103R\u0017\u0010\u0019\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\bH\u0010/\u001a\u0004\bI\u00101R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bJ\u0010>\u001a\u0004\bK\u0010@R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\bI\u0010L\u001a\u0004\bH\u0010MR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010N\u001a\u0004\b;\u0010O\"\u0004\bP\u0010QR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u00109\u001a\u0004\bJ\u0010W\"\u0004\b/\u0010XR\"\u0010#\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u00104\u001a\u0004\bA\u00106\"\u0004\bY\u0010:\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "", "", ReportConstant.COSTREPORT_PREFIX, "w", "v", "u", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "", "", DomainData.DOMAIN_NAME, "other", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "userList", QFSSearchBaseRequest.EXTRA_KEY_USER_COUNT, "id", "name", "iconId", "isSortableForBackend", "color", "isHoist", "roleType", "memberLimit", "isLevelRole", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "lvRole", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/a;", "channelPermission", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/h;", "rolePermission", "", "manageTagPendingColor", "displayTagName", "c", "toString", "hashCode", "equals", "a", "Ljava/util/List;", "r", "()Ljava/util/List;", "M", "(Ljava/util/List;)V", "b", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "L", "(I)V", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "(Ljava/lang/String;)V", "e", tl.h.F, "f", "Z", "B", "()Z", "g", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "H", "(Z)V", "p", "setRoleType", "j", "l", "k", "y", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/a;", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/a;", "E", "(Lcom/tencent/mobileqq/guild/rolegroup/model/data/a;)V", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/h;", "o", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/h;", "K", "(Lcom/tencent/mobileqq/guild/rolegroup/model/data/h;)V", "()J", "(J)V", "G", "<init>", "(Ljava/util/List;ILjava/lang/String;Ljava/lang/String;IZIZIIZLcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;Lcom/tencent/mobileqq/guild/rolegroup/model/data/a;Lcom/tencent/mobileqq/guild/rolegroup/model/data/h;JLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class RoleGroupModel {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private static final AtomicInteger f232651r = new AtomicInteger(0);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private static final Lazy<Random> f232652s = LazyKt.lazy(new Function0<Random>() { // from class: com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel$Companion$random$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Random invoke() {
            return RandomKt.Random(Random.INSTANCE.nextLong());
        }
    });

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> userList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int userCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int iconId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSortableForBackend;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int color;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isHoist;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int roleType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int memberLimit;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isLevelRole;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProGuildRoleInfo lvRole;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ChannelPermission channelPermission;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private RolePermission rolePermission;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private long manageTagPendingColor;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String displayTagName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J6\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel$a;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "d", "e", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/GProRolePermission;", "allowPermission", "", "Lcom/tencent/mobileqq/qqguildsdk/data/bv;", "descList", "Lcom/tencent/mobileqq/qqguildsdk/data/ek;", "permissionCategories", "f", "a", "", "ADMIN_ROLE_ID", "Ljava/lang/String;", "CATEGORY_ADMIN_ROLE_ID", "CHANNEL_ADMIN_ROLE_ID", "CREATOR_ROLE_ID", "DEFAULT_ROLE_ID", "TAG", "VISITOR_ROLE_ID", "Ljava/util/concurrent/atomic/AtomicInteger;", "sSequence", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RoleGroupModel a(@NotNull RoleGroupModel roleInfo) {
            Intrinsics.checkNotNullParameter(roleInfo, "roleInfo");
            RoleGroupModel d16 = RoleGroupModel.d(roleInfo, null, 0, null, null, 0, false, 0, false, 0, 0, false, null, null, null, 0L, null, 65535, null);
            d16.K(RolePermission.INSTANCE.a(roleInfo.getRolePermission()));
            return d16;
        }

        @JvmStatic
        @NotNull
        public final RoleGroupModel b(@NotNull IGProGuildRoleInfo roleInfo) {
            Intrinsics.checkNotNullParameter(roleInfo, "roleInfo");
            String roleId = roleInfo.getRoleId();
            String name = roleInfo.getName();
            int color = roleInfo.getColor() | (-16777216);
            int nameplate = roleInfo.getNameplate();
            int count = roleInfo.getCount();
            boolean hoist = roleInfo.getHoist();
            boolean z16 = !roleInfo.getIsNotSort();
            int roleType = roleInfo.getRoleType();
            int memberLimit = roleInfo.getMemberLimit();
            boolean isLevelRole = roleInfo.isLevelRole();
            ChannelPermission a16 = ChannelPermission.INSTANCE.a(roleInfo);
            long manageTagPendingColor = roleInfo.getManageTagPendingColor();
            String displayTagName = roleInfo.getDisplayTagName();
            Intrinsics.checkNotNullExpressionValue(roleId, "roleId");
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(displayTagName, "displayTagName");
            RoleGroupModel roleGroupModel = new RoleGroupModel(null, count, roleId, name, nameplate, z16, color, hoist, roleType, memberLimit, isLevelRole, roleInfo, a16, null, manageTagPendingColor, displayTagName, 8193, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.rg.RoleGroupModel", "IGProGuildRoleInfo -> " + roleGroupModel);
                return roleGroupModel;
            }
            return roleGroupModel;
        }

        @JvmStatic
        @NotNull
        public final RoleGroupModel c() {
            RoleGroupModel roleGroupModel = new RoleGroupModel(null, 0, String.valueOf(RoleGroupModel.f232651r.incrementAndGet()), null, 0, false, 0, true, 0, 1000, false, null, null, new RolePermission(false, false, false, false, false, false, false, false, null, null, null, 2047, null), 0L, null, 56699, null);
            roleGroupModel.J("");
            roleGroupModel.F(com.tencent.mobileqq.guild.base.view.colorpick.a.b());
            return roleGroupModel;
        }

        @JvmStatic
        @NotNull
        public final RoleGroupModel d() {
            RoleGroupModel roleGroupModel = new RoleGroupModel(null, 0, "1", null, 0, false, 0, true, 1, 0, false, null, null, new RolePermission(false, false, false, false, false, false, false, false, null, null, null, 2039, null), 0L, null, 56955, null);
            roleGroupModel.J("\u666e\u901a\u6210\u5458");
            roleGroupModel.F(Color.parseColor("#79798C"));
            return roleGroupModel;
        }

        @JvmStatic
        @NotNull
        public final RoleGroupModel e() {
            RoleGroupModel roleGroupModel = new RoleGroupModel(null, 0, "3", null, 0, false, 0, true, 3, 0, false, null, null, new RolePermission(false, false, false, false, false, false, false, false, null, null, null, 2039, null), 0L, null, 56955, null);
            roleGroupModel.J("\u673a\u5668\u4eba");
            roleGroupModel.F(Color.parseColor("#79798C"));
            return roleGroupModel;
        }

        @JvmStatic
        @NotNull
        public final RoleGroupModel f(@NotNull IGProGuildRoleInfo roleInfo, @Nullable GProRolePermission allowPermission, @NotNull List<Desc> descList, @NotNull List<? extends ek> permissionCategories) {
            Intrinsics.checkNotNullParameter(roleInfo, "roleInfo");
            Intrinsics.checkNotNullParameter(descList, "descList");
            Intrinsics.checkNotNullParameter(permissionCategories, "permissionCategories");
            RoleGroupModel b16 = b(roleInfo);
            b16.K(RolePermission.INSTANCE.b(roleInfo, allowPermission, descList, permissionCategories));
            return b16;
        }

        Companion() {
        }
    }

    public RoleGroupModel() {
        this(null, 0, null, null, 0, false, 0, false, 0, 0, false, null, null, null, 0L, null, 65535, null);
    }

    @JvmStatic
    @NotNull
    public static final RoleGroupModel D() {
        return INSTANCE.c();
    }

    @JvmStatic
    @NotNull
    public static final RoleGroupModel b(@NotNull RoleGroupModel roleGroupModel) {
        return INSTANCE.a(roleGroupModel);
    }

    public static /* synthetic */ RoleGroupModel d(RoleGroupModel roleGroupModel, List list, int i3, String str, String str2, int i16, boolean z16, int i17, boolean z17, int i18, int i19, boolean z18, IGProGuildRoleInfo iGProGuildRoleInfo, ChannelPermission channelPermission, RolePermission rolePermission, long j3, String str3, int i26, Object obj) {
        return roleGroupModel.c((i26 & 1) != 0 ? roleGroupModel.userList : list, (i26 & 2) != 0 ? roleGroupModel.userCount : i3, (i26 & 4) != 0 ? roleGroupModel.id : str, (i26 & 8) != 0 ? roleGroupModel.name : str2, (i26 & 16) != 0 ? roleGroupModel.iconId : i16, (i26 & 32) != 0 ? roleGroupModel.isSortableForBackend : z16, (i26 & 64) != 0 ? roleGroupModel.color : i17, (i26 & 128) != 0 ? roleGroupModel.isHoist : z17, (i26 & 256) != 0 ? roleGroupModel.roleType : i18, (i26 & 512) != 0 ? roleGroupModel.memberLimit : i19, (i26 & 1024) != 0 ? roleGroupModel.isLevelRole : z18, (i26 & 2048) != 0 ? roleGroupModel.lvRole : iGProGuildRoleInfo, (i26 & 4096) != 0 ? roleGroupModel.channelPermission : channelPermission, (i26 & 8192) != 0 ? roleGroupModel.rolePermission : rolePermission, (i26 & 16384) != 0 ? roleGroupModel.manageTagPendingColor : j3, (i26 & 32768) != 0 ? roleGroupModel.displayTagName : str3);
    }

    public final boolean A(@Nullable Object other) {
        if (!(other instanceof RoleGroupModel)) {
            return false;
        }
        RoleGroupModel roleGroupModel = (RoleGroupModel) other;
        if (!Intrinsics.areEqual(this.userList, roleGroupModel.userList) || this.userCount != roleGroupModel.userCount || !Intrinsics.areEqual(this.id, roleGroupModel.id) || !Intrinsics.areEqual(this.name, roleGroupModel.name) || this.iconId != roleGroupModel.iconId || this.color != roleGroupModel.color || this.isHoist != roleGroupModel.isHoist || this.roleType != roleGroupModel.roleType || this.memberLimit != roleGroupModel.memberLimit) {
            return false;
        }
        return true;
    }

    /* renamed from: B, reason: from getter */
    public final boolean getIsSortableForBackend() {
        return this.isSortableForBackend;
    }

    public final boolean C() {
        if (this.roleType == 6) {
            return true;
        }
        return false;
    }

    public final void E(@NotNull ChannelPermission channelPermission) {
        Intrinsics.checkNotNullParameter(channelPermission, "<set-?>");
        this.channelPermission = channelPermission;
    }

    public final void F(int i3) {
        this.color = i3;
    }

    public final void G(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayTagName = str;
    }

    public final void H(boolean z16) {
        this.isHoist = z16;
    }

    public final void I(long j3) {
        this.manageTagPendingColor = j3;
    }

    public final void J(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void K(@NotNull RolePermission rolePermission) {
        Intrinsics.checkNotNullParameter(rolePermission, "<set-?>");
        this.rolePermission = rolePermission;
    }

    public final void L(int i3) {
        this.userCount = i3;
    }

    public final void M(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.userList = list;
    }

    @NotNull
    public final RoleGroupModel c(@NotNull List<String> userList, int userCount, @NotNull String id5, @NotNull String name, int iconId, boolean isSortableForBackend, @ColorInt int color, boolean isHoist, int roleType, int memberLimit, boolean isLevelRole, @Nullable IGProGuildRoleInfo lvRole, @NotNull ChannelPermission channelPermission, @NotNull RolePermission rolePermission, long manageTagPendingColor, @NotNull String displayTagName) {
        Intrinsics.checkNotNullParameter(userList, "userList");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(channelPermission, "channelPermission");
        Intrinsics.checkNotNullParameter(rolePermission, "rolePermission");
        Intrinsics.checkNotNullParameter(displayTagName, "displayTagName");
        return new RoleGroupModel(userList, userCount, id5, name, iconId, isSortableForBackend, color, isHoist, roleType, memberLimit, isLevelRole, lvRole, channelPermission, rolePermission, manageTagPendingColor, displayTagName);
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ChannelPermission getChannelPermission() {
        return this.channelPermission;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleGroupModel)) {
            return false;
        }
        RoleGroupModel roleGroupModel = (RoleGroupModel) other;
        if (Intrinsics.areEqual(this.userList, roleGroupModel.userList) && this.userCount == roleGroupModel.userCount && Intrinsics.areEqual(this.id, roleGroupModel.id) && Intrinsics.areEqual(this.name, roleGroupModel.name) && this.iconId == roleGroupModel.iconId && this.isSortableForBackend == roleGroupModel.isSortableForBackend && this.color == roleGroupModel.color && this.isHoist == roleGroupModel.isHoist && this.roleType == roleGroupModel.roleType && this.memberLimit == roleGroupModel.memberLimit && this.isLevelRole == roleGroupModel.isLevelRole && Intrinsics.areEqual(this.lvRole, roleGroupModel.lvRole) && Intrinsics.areEqual(this.channelPermission, roleGroupModel.channelPermission) && Intrinsics.areEqual(this.rolePermission, roleGroupModel.rolePermission) && this.manageTagPendingColor == roleGroupModel.manageTagPendingColor && Intrinsics.areEqual(this.displayTagName, roleGroupModel.displayTagName)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getDisplayTagName() {
        return this.displayTagName;
    }

    /* renamed from: h, reason: from getter */
    public final int getIconId() {
        return this.iconId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((this.userList.hashCode() * 31) + this.userCount) * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.iconId) * 31;
        boolean z16 = this.isSortableForBackend;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (((hashCode2 + i16) * 31) + this.color) * 31;
        boolean z17 = this.isHoist;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (((((i17 + i18) * 31) + this.roleType) * 31) + this.memberLimit) * 31;
        boolean z18 = this.isLevelRole;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int i26 = (i19 + i3) * 31;
        IGProGuildRoleInfo iGProGuildRoleInfo = this.lvRole;
        if (iGProGuildRoleInfo == null) {
            hashCode = 0;
        } else {
            hashCode = iGProGuildRoleInfo.hashCode();
        }
        return ((((((((i26 + hashCode) * 31) + this.channelPermission.hashCode()) * 31) + this.rolePermission.hashCode()) * 31) + androidx.fragment.app.a.a(this.manageTagPendingColor)) * 31) + this.displayTagName.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final IGProGuildRoleInfo getLvRole() {
        return this.lvRole;
    }

    /* renamed from: k, reason: from getter */
    public final long getManageTagPendingColor() {
        return this.manageTagPendingColor;
    }

    /* renamed from: l, reason: from getter */
    public final int getMemberLimit() {
        return this.memberLimit;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<Integer> n() {
        int collectionSizeOrDefault;
        ArrayList<RolePermissionDesc> h16 = this.rolePermission.h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h16) {
            if (!((RolePermissionDesc) obj).e()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((RolePermissionDesc) it.next()).getPermissionType()));
        }
        return arrayList2;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final RolePermission getRolePermission() {
        return this.rolePermission;
    }

    /* renamed from: p, reason: from getter */
    public final int getRoleType() {
        return this.roleType;
    }

    /* renamed from: q, reason: from getter */
    public final int getUserCount() {
        return this.userCount;
    }

    @NotNull
    public final List<String> r() {
        return this.userList;
    }

    public final boolean s() {
        if (this.roleType == 2) {
            return true;
        }
        return false;
    }

    public final boolean t() {
        if (this.roleType == 7) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "RoleGroupModel(userList=" + this.userList + ", userCount=" + this.userCount + ", id=" + this.id + ", name=" + this.name + ", iconId=" + this.iconId + ", isSortableForBackend=" + this.isSortableForBackend + ", color=" + this.color + ", isHoist=" + this.isHoist + ", roleType=" + this.roleType + ", memberLimit=" + this.memberLimit + ", isLevelRole=" + this.isLevelRole + ", lvRole=" + this.lvRole + ", channelPermission=" + this.channelPermission + ", rolePermission=" + this.rolePermission + ", manageTagPendingColor=" + this.manageTagPendingColor + ", displayTagName=" + this.displayTagName + ")";
    }

    public final boolean u() {
        if (this.roleType == 5) {
            return true;
        }
        return false;
    }

    public final boolean v() {
        if (this.roleType == 4) {
            return true;
        }
        return false;
    }

    public final boolean w() {
        if (this.roleType == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: x, reason: from getter */
    public final boolean getIsHoist() {
        return this.isHoist;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsLevelRole() {
        return this.isLevelRole;
    }

    public final boolean z() {
        if (this.roleType == 0) {
            return true;
        }
        return false;
    }

    public RoleGroupModel(@NotNull List<String> userList, int i3, @NotNull String id5, @NotNull String name, int i16, boolean z16, @ColorInt int i17, boolean z17, int i18, int i19, boolean z18, @Nullable IGProGuildRoleInfo iGProGuildRoleInfo, @NotNull ChannelPermission channelPermission, @NotNull RolePermission rolePermission, long j3, @NotNull String displayTagName) {
        Intrinsics.checkNotNullParameter(userList, "userList");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(channelPermission, "channelPermission");
        Intrinsics.checkNotNullParameter(rolePermission, "rolePermission");
        Intrinsics.checkNotNullParameter(displayTagName, "displayTagName");
        this.userList = userList;
        this.userCount = i3;
        this.id = id5;
        this.name = name;
        this.iconId = i16;
        this.isSortableForBackend = z16;
        this.color = i17;
        this.isHoist = z17;
        this.roleType = i18;
        this.memberLimit = i19;
        this.isLevelRole = z18;
        this.lvRole = iGProGuildRoleInfo;
        this.channelPermission = channelPermission;
        this.rolePermission = rolePermission;
        this.manageTagPendingColor = j3;
        this.displayTagName = displayTagName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RoleGroupModel(List list, int i3, String str, String str2, int i16, boolean z16, int i17, boolean z17, int i18, int i19, boolean z18, IGProGuildRoleInfo iGProGuildRoleInfo, ChannelPermission channelPermission, RolePermission rolePermission, long j3, String str3, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r3, r13, r15, (i26 & 8192) != 0 ? new RolePermission(false, false, false, false, false, false, false, false, null, null, null, 2047, null) : rolePermission, (i26 & 16384) != 0 ? 0L : j3, (i26 & 32768) != 0 ? r31 : str3);
        String str4;
        ChannelPermission channelPermission2;
        List arrayList = (i26 & 1) != 0 ? new ArrayList() : list;
        int i27 = (i26 & 2) != 0 ? 0 : i3;
        String str5 = (i26 & 4) != 0 ? "" : str;
        String str6 = (i26 & 8) != 0 ? "" : str2;
        int i28 = (i26 & 16) != 0 ? 0 : i16;
        boolean z19 = (i26 & 32) != 0 ? false : z16;
        int i29 = (i26 & 64) != 0 ? -16777216 : i17;
        boolean z26 = (i26 & 128) != 0 ? false : z17;
        int i36 = (i26 & 256) != 0 ? 0 : i18;
        int i37 = (i26 & 512) != 0 ? 0 : i19;
        boolean z27 = (i26 & 1024) == 0 ? z18 : false;
        List list2 = null;
        byte b16 = 0;
        byte b17 = 0;
        IGProGuildRoleInfo iGProGuildRoleInfo2 = (i26 & 2048) != 0 ? null : iGProGuildRoleInfo;
        if ((i26 & 4096) != 0) {
            str4 = "";
            channelPermission2 = new ChannelPermission(list2, b17 == true ? 1 : 0, 3, b16 == true ? 1 : 0);
        } else {
            str4 = "";
            channelPermission2 = channelPermission;
        }
    }
}
