package com.tencent.mobileqq.guild.media.pic.api;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildPicAIO extends QRouteApi {
    public static final float GUILD_AIO_IMAGE_ROUND_CORNER = 0.0f;
    public static final float GUILD_AIO_VIDEO_ROUND_CORNER = 0.0f;
    public static final String GUILD_PIC_QCIRCLE_STUFF = "_gq";
    public static final String GUILD_PIC_URLDRAWABLE_STUFF = "guildStuff";

    long getGroupPicSizeLimit();

    @Nullable
    File getGuildChatImageFile(Object obj);

    Bitmap getThumbBitmap(Bitmap bitmap, int i3, int i16);

    int[] getThumbMaxDp(boolean z16);

    int[] getThumbMaxPx(boolean z16);

    int[] getThumbMinDp(boolean z16);

    int[] getThumbMinPx(boolean z16);

    int[] getThumbSize(long j3, long j16, boolean z16);

    int[] getThumbSize(long j3, long j16, boolean z16, @Nullable int[] iArr);

    ThumbWidthHeightDP getThumbWidthHeightDPForGuildPicMsg();

    boolean limitByGuild(Object obj);
}
