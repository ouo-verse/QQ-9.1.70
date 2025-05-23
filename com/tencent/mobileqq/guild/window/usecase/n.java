package com.tencent.mobileqq.guild.window.usecase;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import at1.GuildGameCreateBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.window.GuildGameFloatWrapper;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ0\u0010\u0013\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/window/usecase/n;", "Lcom/tencent/mobileqq/guild/window/usecase/e;", "Landroid/view/ViewGroup;", "customView", "", "L", "", "roomState", "", "currentNum", "maxNum", "T", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "j", "E", "Landroid/widget/TextView;", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "mWangZheStatusTv", "o", "Landroid/view/ViewGroup;", "mWangZheStatusWrapper", "p", "I", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/window/GuildGameFloatWrapper;", "wrapper", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/window/GuildGameFloatWrapper;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class n extends e {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mWangZheStatusTv;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mWangZheStatusWrapper;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int currentNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull GuildGameFloatWrapper wrapper) {
        super(guildInfo, channelInfo, wrapper);
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        K("WangZheGameFloatWindowUseCase");
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.e
    public void E() {
        u.q("https://downv6.qq.com/innovate/guild/avatar_icon/guild_live_wz_icon.png", x(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.window.usecase.e
    public void L(@NotNull ViewGroup customView) {
        int i3;
        long j3;
        long currentNum;
        IGProVoiceSmobaGameRoomStateInfo roomInfo;
        long j16;
        IGProVoiceSmobaGameGameStaticInfo gameInfo;
        Intrinsics.checkNotNullParameter(customView, "customView");
        Logger.f235387a.d().i(getTag(), 1, "setupView");
        super.L(customView);
        View findViewById = customView.findViewById(R.id.f1205879y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "customView.findViewById(R.id.wangzhe_status_tv)");
        this.mWangZheStatusTv = (TextView) findViewById;
        View findViewById2 = customView.findViewById(R.id.f1205979z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "customView.findViewById(\u2026d.wangzhe_status_wrapper)");
        this.mWangZheStatusWrapper = (ViewGroup) findViewById2;
        if (!com.tencent.mobileqq.guild.media.core.j.c().o()) {
            return;
        }
        GuildGameCreateBean n3 = com.tencent.mobileqq.guild.media.core.j.c().n();
        IGProVoiceSmobaGameRoomStateInfo roomInfo2 = n3.getRoomInfo();
        if (roomInfo2 != null) {
            i3 = roomInfo2.getRoomState();
        } else {
            i3 = -1;
        }
        int i16 = i3;
        if (((int) n3.getNewCurMember()) != 0) {
            currentNum = n3.getNewCurMember();
        } else {
            IGProVoiceSmobaGameRoomStateInfo roomInfo3 = n3.getRoomInfo();
            if (roomInfo3 != null) {
                currentNum = roomInfo3.getCurrentNum();
            } else {
                j3 = 0;
                roomInfo = n3.getRoomInfo();
                if (roomInfo == null && (gameInfo = roomInfo.getGameInfo()) != null) {
                    j16 = gameInfo.getMaxNum();
                } else {
                    j16 = 0;
                }
                T(i16, j3, j16);
            }
        }
        j3 = currentNum;
        roomInfo = n3.getRoomInfo();
        if (roomInfo == null) {
        }
        j16 = 0;
        T(i16, j3, j16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12, types: [android.view.ViewGroup] */
    public final void T(int roomState, long currentNum, long maxNum) {
        Logger logger = Logger.f235387a;
        String tag = getTag();
        logger.d().i(tag, 1, "setRoomState roomState: " + roomState + " | currentNum: " + currentNum + " | this.currentNum: " + this.currentNum + " | maxNum: " + maxNum);
        TextView textView = null;
        if (roomState != 1 && roomState != 2) {
            ?? r75 = this.mWangZheStatusWrapper;
            if (r75 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mWangZheStatusWrapper");
            } else {
                textView = r75;
            }
            textView.setVisibility(8);
        } else {
            ViewGroup viewGroup = this.mWangZheStatusWrapper;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWangZheStatusWrapper");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            TextView textView2 = this.mWangZheStatusTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWangZheStatusTv");
            } else {
                textView = textView2;
            }
            textView.setText("\u7ec4\u961f\u4e2d" + currentNum + "/" + maxNum);
        }
        if (this.currentNum < currentNum) {
            logger.d().i(getTag(), 1, "setRoomState | vibrate");
            QQGuildUIUtil.T(80L);
        }
        this.currentNum = (int) currentNum;
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.e, com.tencent.mobileqq.guild.window.usecase.g
    public void j(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable r userInfoList) {
        if (userInfoList == null) {
            return;
        }
        super.j(guildId, channelId, localUserInfo, userInfoList);
        List<p> list = userInfoList.f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "userInfoList.anchors");
        Iterator<T> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (((p) it.next()).f228101i) {
                z16 = true;
            }
        }
        if (!z16) {
            u.q("https://downv6.qq.com/innovate/guild/avatar_icon/guild_live_wz_icon.png", x(), true);
        }
    }
}
