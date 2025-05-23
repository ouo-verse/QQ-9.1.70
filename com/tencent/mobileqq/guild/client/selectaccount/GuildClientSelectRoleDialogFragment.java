package com.tencent.mobileqq.guild.client.selectaccount;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.ej;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectRoleDialogFragment;", "Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectListDialogFragment;", "", "data", "Lcom/tencent/mobileqq/guild/client/selectaccount/p;", OcrConfig.CHINESE, "", "", "Gh", "", "Hh", "Ih", "", "Lcom/tencent/mobileqq/qqguildsdk/data/ej;", "P", "Ljava/util/List;", "getMRoleData", "()Ljava/util/List;", "Th", "(Ljava/util/List;)V", "mRoleData", "", "titleName", "clientId", "areaId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildClientSelectRoleDialogFragment extends GuildClientSelectListDialogFragment {

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private List<? extends ej> mRoleData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildClientSelectRoleDialogFragment(@NotNull String titleName, @NotNull String clientId, @NotNull String areaId) {
        super(titleName, clientId, areaId);
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(areaId, "areaId");
    }

    @Override // com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment
    protected void Gh(@NotNull List<p> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<? extends ej> list = this.mRoleData;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            Ch(list);
        }
    }

    @Override // com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment
    protected boolean Hh() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment
    protected boolean Ih() {
        return false;
    }

    public final void Th(@Nullable List<? extends ej> list) {
        this.mRoleData = list;
    }

    @Override // com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectListDialogFragment
    @NotNull
    public p zh(@NotNull Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof ej) {
            ej ejVar = (ej) data;
            String roleId = ejVar.getRoleId();
            Intrinsics.checkNotNullExpressionValue(roleId, "data.roleId");
            String roleName = ejVar.getRoleName();
            Intrinsics.checkNotNullExpressionValue(roleName, "data.roleName");
            return new p(roleId, roleName);
        }
        return new p("", "");
    }
}
