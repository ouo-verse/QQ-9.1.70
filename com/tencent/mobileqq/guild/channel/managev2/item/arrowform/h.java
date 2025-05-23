package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.view.View;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMsgIntent;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/channel/managev2/b;", "intent", "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "l", "", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "Landroid/view/View;", "view", "p", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class h extends ChannelSettingBaseVM {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM
    public void l(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, "handleIntentAction " + intent);
        }
        if (intent instanceof ChannelSettingMsgIntent.ChannelInfoChange) {
            q((ChannelSettingMviContext) getMContext());
        } else if (intent instanceof ChannelSettingMsgIntent.PermissionChange) {
            r(((ChannelSettingMsgIntent.PermissionChange) intent).getPermissionInfo());
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull ChannelSettingMviContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        q(context);
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(ChannelSettingMsgIntent.ChannelInfoChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ChannelSettingMsgIntent.PermissionChange.class).getQualifiedName()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.guild.channel.managev2.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C7685b) {
            p(((b.C7685b) intent).getView());
        }
    }

    public abstract void p(@NotNull View view);

    public abstract void q(@NotNull ChannelSettingMviContext context);

    public abstract void r(@NotNull dx permissionInfo);
}
