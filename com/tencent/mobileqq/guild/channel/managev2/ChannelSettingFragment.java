package com.tencent.mobileqq.guild.channel.managev2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMsgIntent;
import com.tencent.mobileqq.guild.channel.managev2.container.f;
import com.tencent.mobileqq.guild.channel.managev2.container.h;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVB;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001!\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0010\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "initViews", "Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils$Params;", "Eh", "params", "Gh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Fh", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "rh", "Lcom/tencent/mobileqq/guild/channel/managev2/container/f;", "T", "Lcom/tencent/mobileqq/guild/channel/managev2/container/f;", "mRootVB", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "U", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "mVBContext", "Landroid/view/View;", "V", "Landroid/view/View;", "mMviViewRoot", "com/tencent/mobileqq/guild/channel/managev2/ChannelSettingFragment$b", "W", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingFragment$b;", "channelInfoChangeAction", "<init>", "()V", "X", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class ChannelSettingFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: T, reason: from kotlin metadata */
    private f mRootVB;

    /* renamed from: U, reason: from kotlin metadata */
    private ChannelSettingMviContext mVBContext;

    /* renamed from: V, reason: from kotlin metadata */
    private View mMviViewRoot;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final b channelInfoChangeAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/channel/managev2/ChannelSettingFragment$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof ChannelSettingMsgIntent.ChannelInfoChange) {
                ChannelSettingFragment channelSettingFragment = ChannelSettingFragment.this;
                TextView textView = channelSettingFragment.E;
                ChannelSettingMviContext channelSettingMviContext = channelSettingFragment.mVBContext;
                if (channelSettingMviContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVBContext");
                    channelSettingMviContext = null;
                }
                textView.setText("\u7ba1\u7406" + channelSettingMviContext.getParams().getChannelInfo().getChannelName());
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final ChannelSettingUtils.Params Eh() {
        Serializable serializable;
        ChannelSettingUtils.Params params;
        boolean z16;
        boolean z17;
        boolean z18;
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("EXTRA_COMMON_PARAM");
        } else {
            serializable = null;
        }
        if (serializable instanceof ChannelSettingUtils.Params) {
            params = (ChannelSettingUtils.Params) serializable;
        } else {
            params = null;
        }
        if (params == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("invalid arguments: EXTRA_COMMON_PARAM is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.ChannelSettingFragment", 1, (String) it.next(), null);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return null;
        }
        boolean z19 = false;
        if (params.getGuildId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (params.getChannelId().length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                IRuntimeService S0 = ch.S0(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                IGPSService iGPSService = (IGPSService) S0;
                IGProGuildInfo guildInfo = iGPSService.getGuildInfo(params.getGuildId());
                IGProChannelInfo channelInfo = iGPSService.getChannelInfo(params.getChannelId());
                if (guildInfo != null && channelInfo != null) {
                    params.setGuildInfo(guildInfo);
                    params.setChannelInfo(channelInfo);
                    return params;
                }
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                if (guildInfo == null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (channelInfo == null) {
                    z19 = true;
                }
                String str = "invalid param: guildInfo is null: " + z18 + ", channelInfo is null: " + z19 + ", guildId: " + params.getGuildId() + ", channelId : " + params.getChannelId();
                if (str instanceof String) {
                    bVar2.a().add(str);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.mnr.ChannelSettingFragment", 1, (String) it5.next(), null);
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
                return null;
            }
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar3 = new Logger.b();
        String str2 = "invalid param: guildId: " + params.getGuildId() + ", channelId : " + params.getChannelId();
        if (str2 instanceof String) {
            bVar3.a().add(str2);
        }
        Iterator<T> it6 = bVar3.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("Guild.mnr.ChannelSettingFragment", 1, (String) it6.next(), null);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
        return null;
    }

    private final void Gh(ChannelSettingUtils.Params params) {
        Map<String, Object> mapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_sub_channel_set");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.P;
        IGProChannelInfo channelInfo = params.getChannelInfo();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", params.getGuildId()), TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(params.getChannelInfo().getType())), TuplesKt.to("sgrp_sub_channel_type", Integer.valueOf(params.getChannelInfo().getType())), TuplesKt.to("sgrp_sub_channel_id", params.getChannelId()), TuplesKt.to("sgrp_sub_channel_name", params.getChannelInfo().getChannelName()), TuplesKt.to("sgrp_user_type", ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(params.getGuildId())), TuplesKt.to("sgrp_duration_flag", 1));
        iGuildDTReportApi.setChannelPageParams(view, channelInfo, mapOf);
    }

    private final void initViews() {
        f fVar;
        ChannelSettingUtils.Params Eh = Eh();
        if (Eh == null) {
            return;
        }
        Fh(Eh);
        ChannelSettingMviContext channelSettingMviContext = new ChannelSettingMviContext(this, Eh);
        this.mVBContext = channelSettingMviContext;
        channelSettingMviContext.e().d(Reflection.getOrCreateKotlinClass(ChannelSettingMsgIntent.ChannelInfoChange.class).getQualifiedName(), this.channelInfoChangeAction);
        f a16 = h.a(Eh.getGuildId(), Eh.getChannelInfo());
        this.mRootVB = a16;
        View view = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootVB");
            fVar = null;
        } else {
            fVar = a16;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        View view2 = this.P;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mMviViewRoot = FrameworkVB.buildViewTree$default(fVar, requireContext, (ViewGroup) view2, null, 4, null);
        f fVar2 = this.mRootVB;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootVB");
            fVar2 = null;
        }
        ChannelSettingMviContext channelSettingMviContext2 = this.mVBContext;
        if (channelSettingMviContext2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVBContext");
            channelSettingMviContext2 = null;
        }
        fVar2.buildVM(channelSettingMviContext2);
        View view3 = this.P;
        Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) view3;
        View view4 = this.mMviViewRoot;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMviViewRoot");
        } else {
            view = view4;
        }
        viewGroup.addView(view);
        Gh(Eh);
        rh();
    }

    protected void Fh(@NotNull ChannelSettingUtils.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.E.setText("\u7ba1\u7406" + params.getChannelInfo().getChannelName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initViews();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f9m;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        f fVar = this.mRootVB;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootVB");
            fVar = null;
        }
        fVar.destroy();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ChannelSettingMviContext channelSettingMviContext = this.mVBContext;
        if (channelSettingMviContext == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onCreateView was not called before onDestroyView");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.ChannelSettingFragment", 1, (String) it.next(), null);
            }
            return;
        }
        if (channelSettingMviContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVBContext");
            channelSettingMviContext = null;
        }
        channelSettingMviContext.e().b(Reflection.getOrCreateKotlinClass(ChannelSettingMsgIntent.ChannelInfoChange.class).getQualifiedName(), this.channelInfoChangeAction);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
