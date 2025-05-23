package com.tencent.mobileqq.guild.channel.managev2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingFragment;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.cz;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ActionSheet;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0007J0\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014H\u0007J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014H\u0007J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0007J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils$Params;", "params", "", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/cy;", "b", "", "guildId", "channelId", "", "c", "Landroid/view/View;", "view", "elemId", "", "i", "g", "d", "e", "k", "Lcom/tencent/widget/ActionSheet;", "actionSheet", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "Params", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelSettingUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChannelSettingUtils f215196a = new ChannelSettingUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils$Params;", "Ljava/io/Serializable;", "guildId", "", "channelId", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "setChannelInfo", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "getGuildId", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "setGuildInfo", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final /* data */ class Params implements Serializable {

        @NotNull
        private final String channelId;
        public IGProChannelInfo channelInfo;

        @NotNull
        private final String guildId;
        public IGProGuildInfo guildInfo;

        public Params(@NotNull String guildId, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.guildId = guildId;
            this.channelId = channelId;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = params.guildId;
            }
            if ((i3 & 2) != 0) {
                str2 = params.channelId;
            }
            return params.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final Params copy(@NotNull String guildId, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new Params(guildId, channelId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            if (Intrinsics.areEqual(this.guildId, params.guildId) && Intrinsics.areEqual(this.channelId, params.channelId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final IGProChannelInfo getChannelInfo() {
            IGProChannelInfo iGProChannelInfo = this.channelInfo;
            if (iGProChannelInfo != null) {
                return iGProChannelInfo;
            }
            Intrinsics.throwUninitializedPropertyAccessException("channelInfo");
            return null;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        public final IGProGuildInfo getGuildInfo() {
            IGProGuildInfo iGProGuildInfo = this.guildInfo;
            if (iGProGuildInfo != null) {
                return iGProGuildInfo;
            }
            Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
            return null;
        }

        public int hashCode() {
            return (this.guildId.hashCode() * 31) + this.channelId.hashCode();
        }

        public final void setChannelInfo(@NotNull IGProChannelInfo iGProChannelInfo) {
            Intrinsics.checkNotNullParameter(iGProChannelInfo, "<set-?>");
            this.channelInfo = iGProChannelInfo;
        }

        public final void setGuildInfo(@NotNull IGProGuildInfo iGProGuildInfo) {
            Intrinsics.checkNotNullParameter(iGProGuildInfo, "<set-?>");
            this.guildInfo = iGProGuildInfo;
        }

        @NotNull
        public String toString() {
            return "Params(guildId=" + this.guildId + ", channelId=" + this.channelId + ")";
        }
    }

    ChannelSettingUtils() {
    }

    @JvmStatic
    @Nullable
    public static final cy b(@NotNull IGProChannelInfo channelInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        List<cy> channelCategoryList = ((IGPSService) S0).getChannelCategoryList(channelInfo.getGuildId());
        Object obj = null;
        if (channelCategoryList == null) {
            return null;
        }
        Iterator<T> it = channelCategoryList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (channelInfo.getCategoryId() == ((cy) next).getCategoryId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (cy) obj;
    }

    @JvmStatic
    public static final boolean c(@NotNull String guildId, @NotNull String channelId) {
        cz czVar;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        dt guildState = ((IGPSService) S0).getGuildState(guildId);
        IAudioChannelState iAudioChannelState = null;
        if (guildState != null) {
            czVar = guildState.a(channelId);
        } else {
            czVar = null;
        }
        if (czVar instanceof IAudioChannelState) {
            iAudioChannelState = (IAudioChannelState) czVar;
        }
        if (iAudioChannelState == null || iAudioChannelState.getChannelState() != 18 || !j.a().d0().m1()) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean d(@NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        if (channelInfo.getType() != 6 || channelInfo.getApplicationId() != 1000050) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void f(@NotNull Context context, @NotNull Params params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intent intent = new Intent();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        if (((IGPSService) S0).getChannelInfo(params.getChannelId()) == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "open params: channelInfo is null, channelId:" + params.getChannelId();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.ChannelSettingFragment", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().i("Guild.mnr.ChannelSettingFragment", 1, "open params: " + params.getGuildId() + ", " + params.getChannelId());
        intent.putExtras(BundleKt.bundleOf(TuplesKt.to("EXTRA_COMMON_PARAM", params)));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, ChannelSettingFragment.class);
    }

    @JvmStatic
    public static final void g(@NotNull View view, @NotNull String elemId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        VideoReport.setElementId(view, elemId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", view, params);
    }

    public static /* synthetic */ void h(View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        g(view, str, map);
    }

    @JvmStatic
    public static final void i(@NotNull View view, @NotNull String elemId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        VideoReport.setElementId(view, elemId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, params);
    }

    public static /* synthetic */ void j(View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        i(view, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final boolean e(@NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        return channelInfo.getSpecialType().contains(1);
    }

    public final void k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, HardCodeUtil.qqStr(R.string.f157551n8), HardCodeUtil.qqStr(R.string.f146610un), (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: ag1.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChannelSettingUtils.l(dialogInterface, i3);
            }
        });
        createCustomDialog.getMessageTextView().setGravity(17);
        createCustomDialog.getBtnLeft().setTypeface(createCustomDialog.getBtnLeft().getTypeface(), 1);
        createCustomDialog.show();
    }

    public final void m(@NotNull ActionSheet actionSheet) {
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        for (int i3 = 0; i3 < 2; i3++) {
            ImageView imageView = (ImageView) actionSheet.mContentContainer.findViewById(i3).findViewById(R.id.f163929cr);
            imageView.setImageResource(R.drawable.guild_actionsheet_checkbox_checked);
            int dip2px = ViewUtils.dip2px(16.0f);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = dip2px;
            layoutParams.height = dip2px;
        }
    }
}
