package com.tencent.guildmedia.aio.excellentdetail.launch;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.aio.article.launcher.GuildBaseFragment;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/guildmedia/aio/excellentdetail/launch/GuildMediaAnnounceDetailFragment;", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "", "th", "", "vh", "yh", "wh", OcrConfig.CHINESE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "xh", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "onDestroyView", "onBackEvent", "Lus/a;", BdhLogUtil.LogTag.Tag_Conn, "Lus/a;", "chatFragmentProvider", "", "D", "I", "containerId", "", "E", "Ljava/lang/String;", "currentGuildId", UserInfo.SEX_FEMALE, "currentChannelId", "G", "selfTinyId", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "H", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "<init>", "()V", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAnnounceDetailFragment extends GuildBaseFragment {
    private static final int J = Color.parseColor("#171718");

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a chatFragmentProvider;

    /* renamed from: D, reason: from kotlin metadata */
    private int containerId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String currentGuildId = "";

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String currentChannelId = "";

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String selfTinyId = "";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014JJ\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0014\u00a8\u0006\u0015"}, d2 = {"com/tencent/guildmedia/aio/excellentdetail/launch/GuildMediaAnnounceDetailFragment$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "", "channelIds", "onPushChannelDestroy", "chnnUin", "operatorTinyId", "tinyId", "code", "msg", "leavePlatform", "onPushKickOutAudioChannel", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@NotNull String guildId, int black) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(GuildMediaAnnounceDetailFragment.this.currentGuildId, guildId)) {
                QLog.i("GuildMediaAnnounceDetailFragment", 1, "onBeKickFromGuild");
                GuildMediaAnnounceDetailFragment.this.th();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(GuildMediaAnnounceDetailFragment.this.currentGuildId, guildId)) {
                QLog.i("GuildMediaAnnounceDetailFragment", 1, "onDeleteGuild");
                GuildMediaAnnounceDetailFragment.this.th();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(GuildMediaAnnounceDetailFragment.this.currentGuildId, guildId)) {
                QLog.i("GuildMediaAnnounceDetailFragment", 1, "onDestroyGuild");
                GuildMediaAnnounceDetailFragment.this.th();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@NotNull String guildId, @NotNull List<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            if (Intrinsics.areEqual(GuildMediaAnnounceDetailFragment.this.currentGuildId, guildId)) {
                Iterator<String> it = channelIds.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(GuildMediaAnnounceDetailFragment.this.currentChannelId, it.next())) {
                        QLog.i("GuildMediaAnnounceDetailFragment", 1, "onPushChannelDestroy");
                        GuildMediaAnnounceDetailFragment.this.th();
                        return;
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushKickOutAudioChannel(@Nullable String guildId, @Nullable String chnnUin, @Nullable String operatorTinyId, @Nullable String tinyId, int code, @Nullable String msg2, int leavePlatform) {
            boolean z16 = true;
            QLog.w("GuildMediaAnnounceDetailFragment", 1, "onPushKickOutAudioChannel guild=" + guildId + ", channelId=" + chnnUin + ", id:=" + tinyId);
            if (!Intrinsics.areEqual(guildId, GuildMediaAnnounceDetailFragment.this.currentGuildId) || !Intrinsics.areEqual(chnnUin, GuildMediaAnnounceDetailFragment.this.currentChannelId)) {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(tinyId, GuildMediaAnnounceDetailFragment.this.selfTinyId)) {
                GuildMediaAnnounceDetailFragment.this.th();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(GuildMediaAnnounceDetailFragment.this.currentGuildId, guildId)) {
                QLog.i("GuildMediaAnnounceDetailFragment", 1, "onRemoveGuild");
                GuildMediaAnnounceDetailFragment.this.th();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void th() {
        if (!vh() && !m.b(requireActivity())) {
            QLog.d("GuildMediaAnnounceDetailFragment", 1, "exitWithPadJudge activity finish");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void uh() {
        Intent intent;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean isBlank2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            QLog.e("GuildMediaAnnounceDetailFragment", 1, "[initChatFragment] intent is null");
            return;
        }
        String stringExtra = intent.getStringExtra("guild_chosen_guild_id");
        String stringExtra2 = intent.getStringExtra("guild_chosen_channel_id");
        if (stringExtra == null) {
            str = "";
        } else {
            str = stringExtra;
        }
        this.currentGuildId = str;
        if (stringExtra2 == null) {
            str2 = "";
        } else {
            str2 = stringExtra2;
        }
        this.currentChannelId = str2;
        String stringExtra3 = intent.getStringExtra("guild_chosen_myself_tinyid");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.selfTinyId = stringExtra3;
        long longExtra = intent.getLongExtra("guild_chosen_first_can_show_seq", Long.MAX_VALUE);
        if (stringExtra != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(stringExtra);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (stringExtra2 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(stringExtra2);
                        if (!isBlank) {
                            z17 = false;
                            if (!z17) {
                                AIOContact aIOContact = new AIOContact(4, stringExtra2, stringExtra, "");
                                Bundle bundle = new Bundle();
                                bundle.putAll(intent.getExtras());
                                bundle.putInt("AIOParam_FromScene", FromScene.CHOSEN.ordinal());
                                bundle.putLong("extra_key_show_max_msg_seq", longExtra);
                                AIOParam.a aVar = new AIOParam.a();
                                String name = com.tencent.guildmedia.aio.factory.b.class.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "GuildMediaAnnounceDetail\u2026oFactory::class.java.name");
                                AIOParam c16 = aVar.e(name).h(new AIOSession(aIOContact)).d(0).a(bundle).c();
                                new Bundle().putParcelable("aio_param", c16);
                                com.tencent.aio.main.engine.b bVar = com.tencent.aio.main.engine.b.f69377a;
                                FragmentManager childFragmentManager = getChildFragmentManager();
                                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                                a d16 = com.tencent.aio.main.engine.b.d(bVar, c16, childFragmentManager, this.containerId, null, 8, null);
                                this.chatFragmentProvider = d16;
                                int i3 = J;
                                if (d16 != null) {
                                    d16.k(new ColorDrawable(i3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                QLog.e("GuildMediaAnnounceDetailFragment", 1, "[initChatFragment] guildId =" + stringExtra + ", channelId = " + stringExtra2);
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.e("GuildMediaAnnounceDetailFragment", 1, "[initChatFragment] guildId =" + stringExtra + ", channelId = " + stringExtra2);
    }

    private final boolean vh() {
        boolean z16;
        boolean z17;
        if (getActivity() == null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && activity2.isDestroyed()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || getContext() == null) {
            return true;
        }
        return false;
    }

    private final void wh() {
        BaseQQAppInterface baseQQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        IRuntimeService runtimeService = baseQQAppInterface.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).addObserver(this.mGPServiceObserver);
        QLog.d("GuildMediaAnnounceDetailFragment", 1, "registerObservers");
    }

    private final void xh(View rootView) {
        HashMap hashMapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(rootView, "pg_sgrp_avchannel_announcement_detail");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 0));
        VideoReport.setPageParams(rootView, new PageParams(hashMapOf));
    }

    private final void yh() {
        FragmentActivity activity = requireActivity();
        UIUtil uIUtil = UIUtil.f112434a;
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        uIUtil.B(activity, activity.getResources().getColor(R.color.ajr));
        ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
        }
    }

    private final void zh() {
        BaseQQAppInterface baseQQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        IRuntimeService runtimeService = baseQQAppInterface.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).deleteObserver(this.mGPServiceObserver);
        QLog.d("GuildMediaAnnounceDetailFragment", 1, "unregisterObserver");
    }

    @Override // com.tencent.guild.aio.article.launcher.GuildBaseFragment
    public boolean onBackEvent() {
        a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            return aVar.onBackPressed();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        yh();
        QLog.d("GuildMediaAnnounceDetailFragment", 1, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.d("GuildMediaAnnounceDetailFragment", 1, "onCreateView");
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int generateViewId = View.generateViewId();
        this.containerId = generateViewId;
        frameLayout.setId(generateViewId);
        uh();
        wh();
        xh(frameLayout);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        QLog.d("GuildMediaAnnounceDetailFragment", 1, "onDestroyView");
        super.onDestroyView();
        zh();
    }
}
