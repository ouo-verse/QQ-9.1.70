package com.tencent.mobileqq.guild.setting.guildmanage.speak.rule;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionRoleListFragment;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildOpenBindPermissionUtils;
import com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleGroupSelectDialog;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildRoleGroupSelectModel;
import com.tencent.mobileqq.guild.rolegroup.view.previewavatar.GuildRoleMemberPreviewView;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelPanel;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 {2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002*+B\u0013\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0095\u0001B(\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001\u0012\u0007\u0010\u0096\u0001\u001a\u00020 \u00a2\u0006\u0006\b\u0091\u0001\u0010\u0097\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J&\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\u001c\u001a\u00020\u0005J\b\u0010\u001d\u001a\u00020\u0005H\u0004J \u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0004J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0004J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020 H\u0004J\u0010\u0010'\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010*\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020&H\u0004J\b\u0010/\u001a\u00020\u0005H&R\"\u00106\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010N\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bK\u00101\u001a\u0004\bL\u00103\"\u0004\bM\u00105R\"\u0010R\u001a\u00020;8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bO\u0010=\u001a\u0004\bP\u0010?\"\u0004\bQ\u0010AR\"\u0010V\u001a\u00020;8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bS\u0010=\u001a\u0004\bT\u0010?\"\u0004\bU\u0010AR\"\u0010Z\u001a\u00020;8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bW\u0010=\u001a\u0004\bX\u0010?\"\u0004\bY\u0010AR\"\u0010]\u001a\u00020;8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010=\u001a\u0004\b[\u0010?\"\u0004\b\\\u0010AR\"\u0010d\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010k\u001a\u00020e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010r\u001a\u00020l8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010u\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u00101\u001a\u0004\bs\u00103\"\u0004\bt\u00105R\"\u0010x\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u00101\u001a\u0004\bv\u00103\"\u0004\bw\u00105R\"\u0010}\u001a\u00020\u00178\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010y\u001a\u0004\bD\u0010z\"\u0004\b{\u0010|R%\u0010\u0082\u0001\u001a\u00020\t8\u0004@\u0004X\u0084.\u00a2\u0006\u0014\n\u0004\b#\u0010~\u001a\u0004\bO\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R%\u0010\u0084\u0001\u001a\u00020\t8\u0004@\u0004X\u0084.\u00a2\u0006\u0014\n\u0004\b\"\u0010~\u001a\u0004\bK\u0010\u007f\"\u0006\b\u0083\u0001\u0010\u0081\u0001R+\u0010\u008a\u0001\u001a\u0012\u0012\r\u0012\u000b \u0086\u0001*\u0004\u0018\u00010 0 0\u0085\u00018\u0006\u00a2\u0006\u000f\n\u0005\b%\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R+\u0010\u008c\u0001\u001a\u0012\u0012\r\u0012\u000b \u0086\u0001*\u0004\u0018\u00010 0 0\u0085\u00018\u0006\u00a2\u0006\u000f\n\u0005\b\u001d\u0010\u0087\u0001\u001a\u0006\b\u008b\u0001\u0010\u0089\u0001R$\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u008d\u00018\u0004X\u0084\u0004\u00a2\u0006\u000e\n\u0005\b\u000b\u0010\u008e\u0001\u001a\u0005\b\b\u0010\u008f\u0001\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Lhy1/g;", "Lcom/tencent/theme/SkinnableView;", "", "G", "Landroid/view/View;", "v", "", "elementId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "H", "I", "J", "K", "Landroid/content/Context;", "context", "E", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "fragment", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView$b;", "callback", "setParams", "onThemeChanged", NodeProps.ON_CLICK, "B", "P", "title", "nextAddTitle", "", "fetchMemberListType", "M", "L", IProfileCardConst.KEY_FROM_TYPE, "N", "", "c", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "roleData", "a", "b", "view", "enable", "U", "V", "d", "Landroid/view/View;", "u", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRootView", "e", HippyTKDListViewAdapter.X, "setMUnlimitedContainer", "mUnlimitedContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "y", "()Landroid/widget/TextView;", "setMUnlimitedNumView", "(Landroid/widget/TextView;)V", "mUnlimitedNumView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "w", "()Landroid/widget/ImageView;", "setMUnlimitedArrowView", "(Landroid/widget/ImageView;)V", "mUnlimitedArrowView", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setMRoleAndMemberContainer", "mRoleAndMemberContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "setMManagerRoleGroup", "mManagerRoleGroup", BdhLogUtil.LogTag.Tag_Conn, "o", "setMManagerRoleMember", "mManagerRoleMember", "D", "t", "setMRoleMemberSum", "mRoleMemberSum", ReportConstant.COSTREPORT_PREFIX, "setMRoleGroupSum", "mRoleGroupSum", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "l", "()Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "setMFragment", "(Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;)V", "mFragment", "Lcom/tencent/mobileqq/guild/rolegroup/view/previewavatar/GuildRoleMemberPreviewView;", "Lcom/tencent/mobileqq/guild/rolegroup/view/previewavatar/GuildRoleMemberPreviewView;", "p", "()Lcom/tencent/mobileqq/guild/rolegroup/view/previewavatar/GuildRoleMemberPreviewView;", "setMMemberAvatarView", "(Lcom/tencent/mobileqq/guild/rolegroup/view/previewavatar/GuildRoleMemberPreviewView;)V", "mMemberAvatarView", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;", "r", "()Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;", "setMRoleGroupLabelPanel", "(Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;)V", "mRoleGroupLabelPanel", "j", "setMDivider1", "mDivider1", "k", "setMDivider2", "mDivider2", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView$b;", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView$b;", BdhLogUtil.LogTag.Tag_Req, "(Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView$b;)V", "mCallback", "Ljava/lang/String;", "()Ljava/lang/String;", "T", "(Ljava/lang/String;)V", "mGuildId", ExifInterface.LATITUDE_SOUTH, "mChannelId", "Le12/e;", "kotlin.jvm.PlatformType", "Le12/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Le12/e;", "roleGroupSum", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "roleMemberSum", "", "Ljava/util/List;", "()Ljava/util/List;", "mSelectedRoleList", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class BaseGuildRolePartUnlimitedView extends LinearLayout implements View.OnClickListener, hy1.g, SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    public TextView mManagerRoleMember;

    /* renamed from: D, reason: from kotlin metadata */
    public TextView mRoleMemberSum;

    /* renamed from: E, reason: from kotlin metadata */
    public TextView mRoleGroupSum;

    /* renamed from: F, reason: from kotlin metadata */
    public QQGuildTitleBarFragment mFragment;

    /* renamed from: G, reason: from kotlin metadata */
    public GuildRoleMemberPreviewView mMemberAvatarView;

    /* renamed from: H, reason: from kotlin metadata */
    public RoleLabelPanel mRoleGroupLabelPanel;

    /* renamed from: I, reason: from kotlin metadata */
    public View mDivider1;

    /* renamed from: J, reason: from kotlin metadata */
    public View mDivider2;

    /* renamed from: K, reason: from kotlin metadata */
    protected b mCallback;

    /* renamed from: L, reason: from kotlin metadata */
    protected String mGuildId;

    /* renamed from: M, reason: from kotlin metadata */
    protected String mChannelId;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Integer> roleGroupSum;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Integer> roleMemberSum;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final List<String> mSelectedRoleList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public View mUnlimitedContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView mUnlimitedNumView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ImageView mUnlimitedArrowView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public View mRoleAndMemberContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public TextView mManagerRoleGroup;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView$b;", "", "Landroid/view/View;", "v", "", "elementId", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(@NotNull View v3, @NotNull String elementId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseGuildRolePartUnlimitedView(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(BaseGuildRolePartUnlimitedView this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView s16 = this$0.s();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getResources().getString(R.string.f154351ek);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.guild_role_add_role)");
        String format = String.format(string, Arrays.copyOf(new Object[]{num}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        s16.setText(format);
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(BaseGuildRolePartUnlimitedView this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView t16 = this$0.t();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getResources().getString(R.string.f154321eh);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026ng.guild_role_add_member)");
        String format = String.format(string, Arrays.copyOf(new Object[]{num}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        t16.setText(format);
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(BaseGuildRolePartUnlimitedView this$0, View v3, a.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = bVar.f232295a;
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.Q(v3, "em_sgrp_unrestrict_member_add");
            this$0.H();
        } else if (i3 == 1) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.Q(v3, "em_sgrp_unrestrict_member_edit");
            this$0.I();
        }
    }

    private final void G() {
        boolean z16;
        boolean z17;
        Integer value = this.roleGroupSum.getValue();
        Integer value2 = this.roleMemberSum.getValue();
        if (value != null && value.intValue() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (value2 != null && value2.intValue() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            TextView y16 = y();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.f157161m6);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026ule_unlimited_member_num)");
            String format = String.format(string, Arrays.copyOf(new Object[]{value, value2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            y16.setText(format);
            return;
        }
        if (z16 && !z17) {
            TextView y17 = y();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getResources().getString(R.string.f157181m8);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026nlimited_member_num_role)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{value}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            y17.setText(format2);
            return;
        }
        if (!z16 && z17) {
            TextView y18 = y();
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String string3 = getResources().getString(R.string.f157171m7);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st\u2026imited_member_num_people)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{value2}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            y18.setText(format3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(BaseGuildRolePartUnlimitedView this$0, List list, List list2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V();
    }

    private final void Q(View v3, String elementId) {
        if (this.mCallback == null) {
            return;
        }
        h().a(v3, elementId);
    }

    @NotNull
    public final e12.e<Integer> A() {
        return this.roleMemberSum;
    }

    public final void B() {
        this.roleGroupSum.observe(l().getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseGuildRolePartUnlimitedView.C(BaseGuildRolePartUnlimitedView.this, (Integer) obj);
            }
        });
        this.roleMemberSum.observe(l().getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseGuildRolePartUnlimitedView.D(BaseGuildRolePartUnlimitedView.this, (Integer) obj);
            }
        });
    }

    public void E(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.f98, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026e_role_part_layout, this)");
        setMRootView(inflate);
        View findViewById = u().findViewById(R.id.f165649x45);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026uild_unlimited_container)");
        setMUnlimitedContainer(findViewById);
        View findViewById2 = u().findViewById(R.id.x46);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.guild_unlimited_num)");
        setMUnlimitedNumView((TextView) findViewById2);
        View findViewById3 = u().findViewById(R.id.f165648x44);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.guild_unlimited_arrow)");
        setMUnlimitedArrowView((ImageView) findViewById3);
        View findViewById4 = u().findViewById(R.id.f777745_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026ole_and_member_container)");
        setMRoleAndMemberContainer(findViewById4);
        View findViewById5 = u().findViewById(R.id.ywx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.manager_role_group)");
        setMManagerRoleGroup((TextView) findViewById5);
        View findViewById6 = u().findViewById(R.id.ywy);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.manager_role_member)");
        setMManagerRoleMember((TextView) findViewById6);
        View findViewById7 = u().findViewById(R.id.f778745j);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.role_member_preview)");
        setMMemberAvatarView((GuildRoleMemberPreviewView) findViewById7);
        View findViewById8 = u().findViewById(R.id.f777945b);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.role_group_panel)");
        setMRoleGroupLabelPanel((RoleLabelPanel) findViewById8);
        View findViewById9 = u().findViewById(R.id.f7776459);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.role_add_member)");
        setMRoleMemberSum((TextView) findViewById9);
        View findViewById10 = u().findViewById(R.id.f7775458);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R.id.role_add_group)");
        setMRoleGroupSum((TextView) findViewById10);
        View findViewById11 = u().findViewById(R.id.bmt);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R.id.divider)");
        setMDivider1(findViewById11);
        View findViewById12 = u().findViewById(R.id.ujg);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R.id.divider2)");
        setMDivider2(findViewById12);
        onThemeChanged();
        r().setOnLabelClickListener(this);
        x().setOnClickListener(this);
        n().setOnClickListener(this);
        o().setOnClickListener(this);
        p().c(new a.InterfaceC7880a() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.a
            @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a.InterfaceC7880a
            public final void a(View view, a.b bVar) {
                BaseGuildRolePartUnlimitedView.F(BaseGuildRolePartUnlimitedView.this, view, bVar);
            }
        });
    }

    public abstract void H();

    public abstract void I();

    public abstract void J();

    public abstract void K();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(@NotNull String title, int fetchMemberListType) {
        Intrinsics.checkNotNullParameter(title, "title");
        GuildCommonViewMemberFragment.ki(l().getActivity(), new GuildRoleMemberParamData(m(), title, 1, fetchMemberListType).setSubChannelId(i()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M(@NotNull String title, @NotNull String nextAddTitle, int fetchMemberListType) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(nextAddTitle, "nextAddTitle");
        GuildCommonViewMemberFragment.ki(l().getActivity(), new GuildRoleMemberParamData(m(), title, 2, fetchMemberListType).setSubChannelId(i()).setNextAddPageTitle(nextAddTitle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(int fromType) {
        GuildRoleGroupSelectDialog.Hh(l().getParentFragmentManager(), new GuildRoleGroupSelectModel.b().m(fromType).n(m()).k(i()).p(true).o(this.mSelectedRoleList).j(new GuildRoleGroupSelectDialog.a() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.d
            @Override // com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleGroupSelectDialog.a
            public final void a(List list, List list2) {
                BaseGuildRolePartUnlimitedView.O(BaseGuildRolePartUnlimitedView.this, list, list2);
            }
        }).i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P() {
        GuildBindPermissionRoleListFragment.Companion companion = GuildBindPermissionRoleListFragment.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.a(context, GuildOpenBindPermissionUtils.j(m()));
    }

    protected final void R(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mCallback = bVar;
    }

    protected final void S(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mChannelId = str;
    }

    protected final void T(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGuildId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(@NotNull View view, boolean enable) {
        float f16;
        Intrinsics.checkNotNullParameter(view, "view");
        if (enable) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        view.setAlpha(f16);
        view.setEnabled(enable);
    }

    public abstract void V();

    @Override // hy1.g
    public boolean a(@NotNull View v3, @NotNull RoleLabelData roleData) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(roleData, "roleData");
        return false;
    }

    @Override // hy1.g
    public boolean b(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Q(v3, "em_sgrp_unrestrict_member_edit");
        K();
        return true;
    }

    @Override // hy1.g
    public boolean c(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Q(v3, "em_sgrp_unrestrict_role_add");
        J();
        return true;
    }

    @NotNull
    protected final b h() {
        b bVar = this.mCallback;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCallback");
        return null;
    }

    @NotNull
    protected final String i() {
        String str = this.mChannelId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChannelId");
        return null;
    }

    @NotNull
    public final View j() {
        View view = this.mDivider1;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDivider1");
        return null;
    }

    @NotNull
    public final View k() {
        View view = this.mDivider2;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDivider2");
        return null;
    }

    @NotNull
    public final QQGuildTitleBarFragment l() {
        QQGuildTitleBarFragment qQGuildTitleBarFragment = this.mFragment;
        if (qQGuildTitleBarFragment != null) {
            return qQGuildTitleBarFragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String m() {
        String str = this.mGuildId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
        return null;
    }

    @NotNull
    public final TextView n() {
        TextView textView = this.mManagerRoleGroup;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mManagerRoleGroup");
        return null;
    }

    @NotNull
    public final TextView o() {
        TextView textView = this.mManagerRoleMember;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mManagerRoleMember");
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (Intrinsics.areEqual(v3, x())) {
            if (q().getVisibility() == 0) {
                q().setVisibility(8);
                y().setVisibility(0);
                w().setImageResource(R.drawable.skin_icon_arrow_right_normal);
            } else {
                q().setVisibility(0);
                y().setVisibility(4);
                w().setImageResource(R.drawable.guild_arrow_down);
            }
        } else if (Intrinsics.areEqual(v3, n())) {
            Q(v3, "em_sgrp_unrestrict_role_edit");
            K();
        } else if (Intrinsics.areEqual(v3, o())) {
            Q(v3, "em_sgrp_unrestrict_member_edit");
            I();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        int i3;
        ie0.a f16 = ie0.a.f();
        Context context = getContext();
        if (GuildThemeManager.f235286a.b()) {
            i3 = 1002;
        } else {
            i3 = 1001;
        }
        ColorStateList h16 = f16.h(context, R.color.qui_common_border_standard, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(h16);
        j().setBackground(gradientDrawable);
        k().setBackground(gradientDrawable);
    }

    @NotNull
    public final GuildRoleMemberPreviewView p() {
        GuildRoleMemberPreviewView guildRoleMemberPreviewView = this.mMemberAvatarView;
        if (guildRoleMemberPreviewView != null) {
            return guildRoleMemberPreviewView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMemberAvatarView");
        return null;
    }

    @NotNull
    public final View q() {
        View view = this.mRoleAndMemberContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoleAndMemberContainer");
        return null;
    }

    @NotNull
    public final RoleLabelPanel r() {
        RoleLabelPanel roleLabelPanel = this.mRoleGroupLabelPanel;
        if (roleLabelPanel != null) {
            return roleLabelPanel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoleGroupLabelPanel");
        return null;
    }

    @NotNull
    public final TextView s() {
        TextView textView = this.mRoleGroupSum;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoleGroupSum");
        return null;
    }

    public final void setMDivider1(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mDivider1 = view;
    }

    public final void setMDivider2(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mDivider2 = view;
    }

    public final void setMFragment(@NotNull QQGuildTitleBarFragment qQGuildTitleBarFragment) {
        Intrinsics.checkNotNullParameter(qQGuildTitleBarFragment, "<set-?>");
        this.mFragment = qQGuildTitleBarFragment;
    }

    public final void setMManagerRoleGroup(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mManagerRoleGroup = textView;
    }

    public final void setMManagerRoleMember(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mManagerRoleMember = textView;
    }

    public final void setMMemberAvatarView(@NotNull GuildRoleMemberPreviewView guildRoleMemberPreviewView) {
        Intrinsics.checkNotNullParameter(guildRoleMemberPreviewView, "<set-?>");
        this.mMemberAvatarView = guildRoleMemberPreviewView;
    }

    public final void setMRoleAndMemberContainer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRoleAndMemberContainer = view;
    }

    public final void setMRoleGroupLabelPanel(@NotNull RoleLabelPanel roleLabelPanel) {
        Intrinsics.checkNotNullParameter(roleLabelPanel, "<set-?>");
        this.mRoleGroupLabelPanel = roleLabelPanel;
    }

    public final void setMRoleGroupSum(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mRoleGroupSum = textView;
    }

    public final void setMRoleMemberSum(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mRoleMemberSum = textView;
    }

    public final void setMRootView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRootView = view;
    }

    public final void setMUnlimitedArrowView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mUnlimitedArrowView = imageView;
    }

    public final void setMUnlimitedContainer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mUnlimitedContainer = view;
    }

    public final void setMUnlimitedNumView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mUnlimitedNumView = textView;
    }

    public final void setParams(@NotNull QQGuildTitleBarFragment fragment, @NotNull String guildId, @NotNull String channelId, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        setMFragment(fragment);
        T(guildId);
        S(channelId);
        R(callback);
        B();
    }

    @NotNull
    public final TextView t() {
        TextView textView = this.mRoleMemberSum;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoleMemberSum");
        return null;
    }

    @NotNull
    public final View u() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<String> v() {
        return this.mSelectedRoleList;
    }

    @NotNull
    public final ImageView w() {
        ImageView imageView = this.mUnlimitedArrowView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUnlimitedArrowView");
        return null;
    }

    @NotNull
    public final View x() {
        View view = this.mUnlimitedContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUnlimitedContainer");
        return null;
    }

    @NotNull
    public final TextView y() {
        TextView textView = this.mUnlimitedNumView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUnlimitedNumView");
        return null;
    }

    @NotNull
    public final e12.e<Integer> z() {
        return this.roleGroupSum;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseGuildRolePartUnlimitedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseGuildRolePartUnlimitedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.roleGroupSum = new e12.e<>(0);
        this.roleMemberSum = new e12.e<>(0);
        this.mSelectedRoleList = new ArrayList();
        E(context);
    }
}
