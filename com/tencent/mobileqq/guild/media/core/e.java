package com.tencent.mobileqq.guild.media.core;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper;
import com.tencent.mobileqq.guild.media.core.logic.ScreenShareStatusHelper;
import com.tencent.mobileqq.guild.media.core.logic.ab;
import com.tencent.mobileqq.guild.media.core.logic.ac;
import com.tencent.mobileqq.guild.media.core.logic.ae;
import com.tencent.mobileqq.guild.media.core.logic.bz;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH&J.\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\nH&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\nH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0018\u001a\u00020\nH&J\b\u0010\u001a\u001a\u00020\u0019H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001d\u001a\u00020\nH&J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH&J\b\u0010!\u001a\u00020\u0011H&J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H&J\b\u0010&\u001a\u00020%H&J\b\u0010(\u001a\u00020'H&J\b\u0010*\u001a\u00020)H&J\b\u0010,\u001a\u00020+H&J\b\u0010.\u001a\u00020-H&J\b\u00100\u001a\u00020/H&J\b\u00102\u001a\u000201H&J\b\u00104\u001a\u000203H&J\b\u00106\u001a\u000205H&J\b\u00108\u001a\u000207H&J\b\u0010:\u001a\u000209H&J\b\u0010<\u001a\u00020;H&J\b\u0010>\u001a\u00020=H&J\b\u0010@\u001a\u00020?H&J\b\u0010B\u001a\u00020AH&J\b\u0010C\u001a\u000205H&J\b\u0010D\u001a\u00020\u0006H&J\b\u0010F\u001a\u00020EH&J\b\u0010H\u001a\u00020GH&J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0019H&J\n\u0010L\u001a\u0004\u0018\u00010KH&J\u0012\u0010N\u001a\u00020\u00062\b\u0010M\u001a\u0004\u0018\u00010KH&J\b\u0010O\u001a\u00020\u0011H&J\b\u0010P\u001a\u00020\u0011H&J\u0012\u0010R\u001a\u00020\u00062\b\u0010Q\u001a\u0004\u0018\u00010KH&J\n\u0010S\u001a\u0004\u0018\u00010KH&J\b\u0010U\u001a\u00020TH&J\b\u0010W\u001a\u00020VH&\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/e;", "", "Lcom/tencent/mobileqq/guild/media/core/q;", "startParams", "Lcom/tencent/mobileqq/guild/media/core/b;", "callback", "", "c", "Lcom/tencent/mobileqq/guild/media/core/h;", UserInfo.SEX_FEMALE, "", "showTips", "reasonForLog", "D", "channelId", "fragmentKey", BdhLogUtil.LogTag.Tag_Req, "", "isInChannel", "i0", "K", "getGuildID", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "E", "", "L", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "getChannelType", "Lcom/tencent/mobileqq/guild/media/core/RefreshType;", "refreshType", "G", ReportConstant.COSTREPORT_PREFIX, "", "themeType", "d", "Lcom/tencent/mobileqq/guild/media/core/logic/o;", "J", "Lcom/tencent/mobileqq/guild/media/core/logic/s;", "W", "Lcom/tencent/mobileqq/guild/media/core/logic/AudioNotifyHelper;", "l0", "Lus1/b;", "H0", "Lcom/tencent/mobileqq/guild/media/core/logic/gift/a;", "b0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper;", "P", "Lcom/tencent/mobileqq/guild/media/core/logic/ScreenShareStatusHelper;", "X", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper;", "T", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper;", "N", "Lcom/tencent/mobileqq/guild/media/core/logic/r;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/core/logic/bz;", "Y", "Lcom/tencent/mobileqq/guild/media/core/logic/ac;", "M", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper;", "d0", "Lcom/tencent/mobileqq/guild/media/core/logic/ab;", "M0", BdhLogUtil.LogTag.Tag_Conn, "I", "Lcom/tencent/mobileqq/guild/media/core/logic/q;", "I0", "Lcom/tencent/mobileqq/guild/media/core/logic/ae;", "f0", "seq", "O", "Landroid/os/Bundle;", "a0", "loadBean", "j0", "U", "J0", "extra", "e0", "c0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper;", "H", "Lcom/tencent/mobileqq/guild/media/core/logic/gift/b;", "F0", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e {
    @NotNull
    MediaChannelPermissionHelper C();

    void D(@Nullable String showTips, @Nullable String reasonForLog);

    @NotNull
    String E();

    void F(@Nullable h callback);

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.gift.b F0();

    void G(@NotNull String channelId, @NotNull RefreshType refreshType);

    @NotNull
    MediaChannelFreeGiftTaskHelper H();

    @NotNull
    us1.b H0();

    void I();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.q I0();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.o J();

    boolean J0();

    boolean K(@NotNull String channelId);

    long L();

    @NotNull
    ac M();

    @NotNull
    ab M0();

    @NotNull
    MediaChannelMicSequenceHelper N();

    void O(long seq);

    @NotNull
    MediaChannelMultiRoomHelper P();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.r Q();

    void R(@Nullable String showTips, @Nullable String reasonForLog, @NotNull String channelId, @Nullable String fragmentKey);

    @NotNull
    MediaChannelPermissionHelper S();

    @NotNull
    MediaChannelRaiseHandHelper T();

    boolean U();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.s W();

    @NotNull
    ScreenShareStatusHelper X();

    @NotNull
    bz Y();

    @Nullable
    /* renamed from: a0 */
    Bundle getLoadBeanBundle();

    @NotNull
    com.tencent.mobileqq.guild.media.core.logic.gift.a b0();

    void c(@NotNull q startParams, @Nullable b callback);

    @Nullable
    Bundle c0();

    void d(int themeType);

    @NotNull
    MediaChannelThirdAppHelper d0();

    void e0(@Nullable Bundle extra);

    @NotNull
    ae f0();

    @Nullable
    IGProChannelInfo getChannelInfo();

    @NotNull
    String getChannelType();

    @NotNull
    String getGuildID();

    @Nullable
    IGProGuildInfo getGuildInfo();

    boolean i0(@NotNull String channelId);

    boolean isInChannel();

    void j0(@Nullable Bundle loadBean);

    @NotNull
    AudioNotifyHelper l0();

    boolean s();
}
