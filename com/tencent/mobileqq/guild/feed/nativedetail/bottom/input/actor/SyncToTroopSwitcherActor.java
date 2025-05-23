package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00060\u0001j\u0002`\u0002:\u0001\u0017B\u0013\u0012\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/SyncToTroopSwitcherActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "", "i", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "syncToTroopRl", "Landroid/widget/CheckBox;", tl.h.F, "Landroid/widget/CheckBox;", "syncCheckBox", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SyncToTroopSwitcherActor extends NativeDetailInputWindowDirector.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout syncToTroopRl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CheckBox syncCheckBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncToTroopSwitcherActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
    }

    private final void i() {
        TextView textView;
        TroopInfo troopInfoFromCache;
        RelativeLayout relativeLayout = this.syncToTroopRl;
        Long l3 = null;
        if (relativeLayout != null) {
            textView = (TextView) relativeLayout.findViewById(R.id.wey);
        } else {
            textView = null;
        }
        String string = getAttachInfo().getExtra().getString("guild_feed_channel_name");
        if (!TextUtils.isEmpty(string)) {
            if (textView != null) {
                textView.setText(string);
                return;
            }
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            QLog.e("SyncToTroopSwitcherActor", 1, "setTroopName sub process!");
            return;
        }
        AppInterface l16 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l16, "appInterface()");
        IGProGuildInfo guildInfo = ((IGPSService) l16.getRuntimeService(IGPSService.class, "")).getGuildInfo(getAttachInfo().e());
        if (guildInfo != null) {
            l3 = Long.valueOf(guildInfo.getGroupId());
        }
        if ((l3 == null || l3.longValue() != 0) && (troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(l3))) != null) {
            if (textView != null) {
                textView.setText(troopInfoFromCache.getTroopDisplayName());
            }
            QLog.i("SyncToTroopSwitcherActor", 1, "[setTroopName], name: " + troopInfoFromCache.getTroopDisplayName());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        RelativeLayout relativeLayout = (RelativeLayout) inputWindow.X().v().getInputPanelContainer().findViewById(R.id.wez);
        this.syncToTroopRl = relativeLayout;
        if (relativeLayout != null) {
            checkBox = (CheckBox) relativeLayout.findViewById(R.id.wex);
        } else {
            checkBox = null;
        }
        this.syncCheckBox = checkBox;
        QLog.i("SyncToTroopSwitcherActor", 1, "onInputWindowInitialized businessType=" + getAttachInfo().a());
        if (getAttachInfo().a() == 7) {
            RelativeLayout relativeLayout2 = this.syncToTroopRl;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            i();
            CheckBox checkBox2 = this.syncCheckBox;
            if (checkBox2 != null) {
                checkBox2.setChecked(bi.a());
            }
            final RelativeLayout relativeLayout3 = this.syncToTroopRl;
            if (relativeLayout3 != null) {
                final long j3 = 200;
                relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SyncToTroopSwitcherActor$onInputWindowInitialized$$inlined$setSingleClickListener$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View it) {
                        CheckBox checkBox3;
                        CheckBox checkBox4;
                        CheckBox checkBox5;
                        boolean z16;
                        EventCollector.getInstance().onViewClickedBefore(it);
                        boolean z17 = false;
                        relativeLayout3.setClickable(false);
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        checkBox3 = this.syncCheckBox;
                        if (checkBox3 != null) {
                            checkBox5 = this.syncCheckBox;
                            if (checkBox5 != null && checkBox5.isChecked()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            checkBox3.setChecked(!z16);
                        }
                        checkBox4 = this.syncCheckBox;
                        if (checkBox4 != null && checkBox4.isChecked()) {
                            z17 = true;
                        }
                        bi.b(z17);
                        final View view = relativeLayout3;
                        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SyncToTroopSwitcherActor$onInputWindowInitialized$$inlined$setSingleClickListener$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                view.setClickable(true);
                            }
                        }, j3);
                        EventCollector.getInstance().onViewClicked(it);
                    }
                });
                return;
            }
            return;
        }
        RelativeLayout relativeLayout4 = this.syncToTroopRl;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
    }
}
