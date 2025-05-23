package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0016\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B=\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016JI\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u0003R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\"\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/e;", "newItem", "", "b", "a", "", "id", "", "icon", "configName", "subDesc", "isShowAttention", "c", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c;", "e", "k", "d", "J", "i", "()J", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "f", "j", "Z", "l", "()Z", "setShowAttention", "(Z)V", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Object;", "g", "()Ljava/lang/Object;", "setExtras", "(Ljava/lang/Object;)V", "extras", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V", BdhLogUtil.LogTag.Tag_Conn, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class c implements com.tencent.mobileqq.guild.widget.adapterdelegates.e<c> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String configName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subDesc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowAttention;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object extras;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationV2Info;", "info", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c;", "a", "", "ID_ADD_CONFIG", "J", "ID_FETCH_CONFIG_ERROR", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a(@NotNull IGProNavigationV2Info info) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(info, "info");
            if (info.getJumpUrlAuditStatus() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (info.getTitleAuditStatus() == 2) {
                z17 = true;
            } else {
                z17 = z16;
            }
            long iconId = info.getIconId();
            String iconUrl = info.getIconUrl();
            String title = info.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "info.title");
            String jumpUrl = info.getJumpUrl();
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "info.jumpUrl");
            return new c(iconId, iconUrl, title, jumpUrl, z17, info);
        }

        Companion() {
        }
    }

    public c(long j3, @Nullable String str, @NotNull String configName, @NotNull String subDesc, boolean z16, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(configName, "configName");
        Intrinsics.checkNotNullParameter(subDesc, "subDesc");
        this.id = j3;
        this.icon = str;
        this.configName = configName;
        this.subDesc = subDesc;
        this.isShowAttention = z16;
        this.extras = obj;
    }

    public static /* synthetic */ c d(c cVar, Long l3, String str, String str2, String str3, Boolean bool, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                l3 = null;
            }
            if ((i3 & 2) != 0) {
                str = null;
            }
            if ((i3 & 4) != 0) {
                str2 = null;
            }
            if ((i3 & 8) != 0) {
                str3 = null;
            }
            if ((i3 & 16) != 0) {
                bool = null;
            }
            return cVar.c(l3, str, str2, str3, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (Intrinsics.areEqual(this.icon, newItem.icon) && Intrinsics.areEqual(this.subDesc, newItem.subDesc) && this.isShowAttention == newItem.isShowAttention && Intrinsics.areEqual(this.configName, newItem.configName) && this.id == newItem.id) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (hashCode() == newItem.hashCode()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final c c(@Nullable Long id5, @Nullable String icon, @Nullable String configName, @Nullable String subDesc, @Nullable Boolean isShowAttention) {
        long j3;
        boolean z16;
        if (id5 != null) {
            j3 = id5.longValue();
        } else {
            j3 = this.id;
        }
        long j16 = j3;
        if (icon == null) {
            icon = this.icon;
        }
        String str = icon;
        if (configName == null) {
            configName = this.configName;
        }
        String str2 = configName;
        if (subDesc == null) {
            subDesc = this.subDesc;
        }
        String str3 = subDesc;
        if (isShowAttention != null) {
            z16 = isShowAttention.booleanValue();
        } else {
            z16 = this.isShowAttention;
        }
        return new c(j16, str, str2, str3, z16, this.extras);
    }

    @NotNull
    public final String e() {
        String string;
        Object obj = this.extras;
        String str = "";
        if (obj instanceof IGProNavigationV2Info) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info");
            IGProNavigationV2Info iGProNavigationV2Info = (IGProNavigationV2Info) obj;
            if (iGProNavigationV2Info.getJumpUrlAuditStatus() == 2 && iGProNavigationV2Info.getTitleAuditStatus() == 2) {
                string = BaseApplication.getContext().getString(R.string.f15084163);
            } else if (iGProNavigationV2Info.getJumpUrlAuditStatus() == 2) {
                string = BaseApplication.getContext().getString(R.string.f15085164);
            } else {
                if (iGProNavigationV2Info.getTitleAuditStatus() == 2) {
                    string = BaseApplication.getContext().getString(R.string.f15086165);
                }
                Intrinsics.checkNotNullExpressionValue(str, "{\n            var info =\u2026\"\n            }\n        }");
            }
            str = string;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            var info =\u2026\"\n            }\n        }");
        }
        return str;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getConfigName() {
        return this.configName;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Object getExtras() {
        return this.extras;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: i, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getSubDesc() {
        return this.subDesc;
    }

    public final boolean k() {
        if (!(this instanceof a) && !(this instanceof b)) {
            return false;
        }
        return true;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsShowAttention() {
        return this.isShowAttention;
    }

    public /* synthetic */ c(long j3, String str, String str2, String str3, boolean z16, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, str2, str3, z16, (i3 & 32) != 0 ? null : obj);
    }
}
