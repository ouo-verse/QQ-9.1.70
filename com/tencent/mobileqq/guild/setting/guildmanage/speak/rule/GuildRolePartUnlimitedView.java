package com.tencent.mobileqq.guild.setting.guildmanage.speak.rule;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.view.previewavatar.GuildRoleMemberPreviewView;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\r\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildRolePartUnlimitedView;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView;", "", "H", "I", "J", "K", "c0", "Y", "a0", "V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRolePartUnlimitedView extends BaseGuildRolePartUnlimitedView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildRolePartUnlimitedView(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GuildRolePartUnlimitedView this$0, int i3, String str, int i16, boolean z16, byte[] bArr, List memberList) {
        int collectionSizeOrDefault;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        this$0.A().postValue(Integer.valueOf(i16));
        GuildRoleMemberPreviewView p16 = this$0.p();
        List<IGProUserInfo> list = memberList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProUserInfo iGProUserInfo : list) {
            arrayList.add(new a.b(2, this$0.m(), iGProUserInfo.getTinyId(), ch.d0(iGProUserInfo)));
        }
        int size = memberList.size();
        boolean z18 = true;
        if (size > 15) {
            z17 = true;
        } else {
            z17 = false;
        }
        p16.setPreviewItemDataWithNickname(arrayList, z17);
        TextView o16 = this$0.o();
        if (i16 <= 0) {
            z18 = false;
        }
        this$0.U(o16, z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(GuildRolePartUnlimitedView this$0, int i3, String str, int i16, List roleList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(roleList, "roleList");
        if (i3 != 0) {
            return;
        }
        this$0.z().postValue(Integer.valueOf(i16));
        List<IGProGuildRoleInfo> list = roleList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProGuildRoleInfo iGProGuildRoleInfo : list) {
            String roleId = iGProGuildRoleInfo.getRoleId();
            String name = iGProGuildRoleInfo.getName();
            int color = (-16777216) | iGProGuildRoleInfo.getColor();
            int roleType = iGProGuildRoleInfo.getRoleType();
            String levelSimpleDsc = iGProGuildRoleInfo.getLevelSimpleDsc();
            String levelIconUrl = iGProGuildRoleInfo.getLevelIconUrl();
            int displayType = iGProGuildRoleInfo.getDisplayType();
            Intrinsics.checkNotNullExpressionValue(roleId, "roleId");
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(levelSimpleDsc, "levelSimpleDsc");
            Intrinsics.checkNotNullExpressionValue(levelIconUrl, "levelIconUrl");
            arrayList.add(new RoleLabelData(roleId, color, name, roleType, levelSimpleDsc, levelIconUrl, false, false, displayType, 192, null));
        }
        this$0.v().clear();
        List<String> v3 = this$0.v();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((RoleLabelData) it.next()).getRoleId());
        }
        v3.addAll(arrayList2);
        this$0.r().f(arrayList);
        TextView n3 = this$0.n();
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (((RoleLabelData) obj).isNormalRole()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.U(n3, z16);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView
    public void H() {
        String string = getResources().getString(R.string.f1488410o);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026.guild_manage_add_member)");
        L(string, 20);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView
    public void I() {
        String string = getResources().getString(R.string.f157151m5);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026ak_rule_unlimited_member)");
        String string2 = getResources().getString(R.string.f1488410o);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026.guild_manage_add_member)");
        M(string, string2, 19);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView
    public void J() {
        N(4);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView
    public void K() {
        P();
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView
    public void V() {
        a0();
    }

    public final void Y() {
        IRuntimeService runtimeService = l().getAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mFragment.appInterface.g\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).fetchGuildSpeakableMemberList(m(), true, null, new xh2.p() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.h
            @Override // xh2.p
            public final void a(int i3, String str, int i16, boolean z16, byte[] bArr, List list) {
                GuildRolePartUnlimitedView.Z(GuildRolePartUnlimitedView.this, i3, str, i16, z16, bArr, list);
            }
        });
    }

    public final void a0() {
        IRuntimeService runtimeService = l().getAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mFragment.appInterface.g\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).fetchGuildSpeakableRoleList(m(), true, new xh2.q() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.g
            @Override // xh2.q
            public final void a(int i3, String str, int i16, List list) {
                GuildRolePartUnlimitedView.b0(GuildRolePartUnlimitedView.this, i3, str, i16, list);
            }
        });
    }

    public final void c0() {
        w().setImageResource(R.drawable.skin_icon_arrow_right_normal);
        y().setVisibility(0);
        q().setVisibility(8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildRolePartUnlimitedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRolePartUnlimitedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        E(context);
    }
}
