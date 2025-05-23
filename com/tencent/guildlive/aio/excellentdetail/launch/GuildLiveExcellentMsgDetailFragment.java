package com.tencent.guildlive.aio.excellentdetail.launch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.article.launcher.GuildBaseFragment;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guildlive.aio.factory.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guildlive/aio/excellentdetail/launch/GuildLiveExcellentMsgDetailFragment;", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "color", "", "rh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "qh", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "", "onBackEvent", "Lus/a;", BdhLogUtil.LogTag.Tag_Conn, "Lus/a;", "chatFragmentProvider", "<init>", "()V", "D", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveExcellentMsgDetailFragment extends GuildBaseFragment {
    private static final int E = Color.parseColor("#171718");

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a chatFragmentProvider;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ph() {
        Intent intent;
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
            QLog.e("GuildLiveExcellentMsgDetailFragment", 1, "[initChatFragment] intent is null");
            return;
        }
        String stringExtra = intent.getStringExtra("guild_chosen_guild_id");
        String stringExtra2 = intent.getStringExtra("guild_chosen_channel_id");
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
                                String name = b.class.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "GuildLiveAnnounceDetailAioFactory::class.java.name");
                                AIOParam c16 = aVar.e(name).h(new AIOSession(aIOContact)).d(0).a(bundle).c();
                                new Bundle().putParcelable("aio_param", c16);
                                com.tencent.aio.main.engine.b bVar = com.tencent.aio.main.engine.b.f69377a;
                                FragmentManager childFragmentManager = getChildFragmentManager();
                                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                                a d16 = com.tencent.aio.main.engine.b.d(bVar, c16, childFragmentManager, R.id.w2h, null, 8, null);
                                this.chatFragmentProvider = d16;
                                if (d16 != null) {
                                    d16.k(new ColorDrawable(E));
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
                QLog.e("GuildLiveExcellentMsgDetailFragment", 1, "[initChatFragment] guildId =" + stringExtra + ", channelId = " + stringExtra2);
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.e("GuildLiveExcellentMsgDetailFragment", 1, "[initChatFragment] guildId =" + stringExtra + ", channelId = " + stringExtra2);
    }

    private final void qh(View rootView) {
        HashMap hashMapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(rootView, "pg_sgrp_avchannel_announcement_detail");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 1));
        VideoReport.setPageParams(rootView, new PageParams(hashMapOf));
    }

    private final void rh(Activity activity, int color) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
            window.setNavigationBarColor(color);
        }
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
        rh(getActivity(), E);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = LayoutInflater.from(BaseApplication.context).inflate(R.layout.ewu, container, false);
        ph();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        qh(rootView);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }
}
