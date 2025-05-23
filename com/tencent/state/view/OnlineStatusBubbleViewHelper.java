package com.tencent.state.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import com.tencent.image.URLDrawable;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.square.ISquareOnlineStatusHelper;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.data.SquareAvatarItemKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J$\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/view/OnlineStatusBubbleViewHelper;", "", "()V", "addSpaceSpan", "Landroid/text/SpannableStringBuilder;", "text", "", "canShowSong", "", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "getBatteryStatusText", "isMe", "onlineStatus", "getBubbleMainText", "isZoom", "getEditTextLength", "", "msg", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "urlDrawableListener", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "getSongName", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "isEmoji", "codePoint", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class OnlineStatusBubbleViewHelper {
    public static final OnlineStatusBubbleViewHelper INSTANCE = new OnlineStatusBubbleViewHelper();

    OnlineStatusBubbleViewHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getBatteryStatusText(boolean isMe, OnlineStatus onlineStatus) {
        boolean z16;
        boolean isPowerConnect;
        boolean isBlank;
        String customText = onlineStatus.getCustomText();
        int i3 = 0;
        if (customText != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(customText);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    return onlineStatus.getCustomText();
                }
                if (!isMe) {
                    SpecialStatus extraData = onlineStatus.getExtraData();
                    Integer batteryLevel = extraData != null ? extraData.getBatteryLevel() : null;
                    isPowerConnect = batteryLevel != null && ((batteryLevel.intValue() & 128) >> 7) == 1;
                    if (batteryLevel != null) {
                        i3 = batteryLevel.intValue() & 127;
                    }
                } else {
                    SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
                    isPowerConnect = squareBatteryStatusManager.isPowerConnect();
                    i3 = squareBatteryStatusManager.getBatteryCapacity();
                }
                if (isPowerConnect) {
                    return i3 + "%\u5145\u7535\u4e2d";
                }
                return i3 + "%\u7535\u91cf";
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final boolean isEmoji(char codePoint) {
        if (codePoint != 0 && codePoint != '\t' && codePoint != '\n' && codePoint != '\r' && ((' ' > codePoint || '\ud7ff' < codePoint) && (('\ue000' > codePoint || '\ufffd' < codePoint) && (0 > codePoint || '\uffff' < codePoint)))) {
            return true;
        }
        return false;
    }

    public final SpannableStringBuilder addSpaceSpan(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard(ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 20), 0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) text);
        spannableStringBuilder.setSpan(standard, 0, 0, 17);
        return spannableStringBuilder;
    }

    public final String getBubbleMainText(boolean isZoom, boolean isMe, OnlineStatus onlineStatus) {
        Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        if (isZoom) {
            int id5 = onlineStatus.getId();
            if (id5 == 1000) {
                return getBatteryStatusText(isMe, onlineStatus);
            }
            if (id5 != 1030) {
                String customText = onlineStatus.getCustomText();
                return customText.length() == 0 ? onlineStatus.getTitle() : customText;
            }
            SpecialStatus extraData = onlineStatus.getExtraData();
            String weatherDesc = extraData != null ? extraData.getWeatherDesc() : null;
            if (weatherDesc != null && weatherDesc.length() != 0) {
                r0 = false;
            }
            if (r0) {
                return onlineStatus.getTitle();
            }
            SpecialStatus extraData2 = onlineStatus.getExtraData();
            return String.valueOf(extraData2 != null ? extraData2.getWeatherDesc() : null);
        }
        if (onlineStatus.getId() == 1000) {
            return getBatteryStatusText(isMe, onlineStatus);
        }
        return onlineStatus.getCustomText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.tencent.image.URLDrawable] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.tencent.state.square.ICommonUtils] */
    public final Drawable getIconDrawable(OnlineStatus status, boolean isMe, URLDrawable.URLDrawableListener urlDrawableListener) {
        boolean startsWith;
        int batteryCapacity;
        Intrinsics.checkNotNullParameter(status, "status");
        if (OnlineStatusBubbleViewHelperKt.isBatteryStatus(status)) {
            if (!isMe) {
                SpecialStatus extraData = status.getExtraData();
                r1 = extraData != null ? extraData.getBatteryLevel() : null;
                batteryCapacity = r1 != null ? r1.intValue() & 127 : 0;
            } else {
                batteryCapacity = SquareBatteryStatusManager.INSTANCE.getBatteryCapacity();
            }
            return new BitmapDrawable(Square.INSTANCE.getConfig().getOnlineStatusHelper().getBatteryDrawable(batteryCapacity, 2));
        }
        if (!OnlineStatusBubbleViewHelperKt.isCustomStatus(status)) {
            startsWith = StringsKt__StringsJVMKt.startsWith(status.getBigIcon(), "http", true);
            if (startsWith) {
                ?? drawable = URLDrawable.getDrawable(status.getBigIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
                drawable.setURLDrawableListener(urlDrawableListener);
                drawable.startDownload();
                if (Square.INSTANCE.getConfig().getCommonUtils().isDrawableReady(drawable)) {
                    r1 = drawable;
                }
            }
            return r1;
        }
        ISquareOnlineStatusHelper onlineStatusHelper = Square.INSTANCE.getConfig().getOnlineStatusHelper();
        SpecialStatus extraData2 = status.getExtraData();
        Intrinsics.checkNotNull(extraData2);
        Integer id5 = extraData2.getId();
        Intrinsics.checkNotNull(id5);
        int intValue = id5.intValue();
        SpecialStatus extraData3 = status.getExtraData();
        Intrinsics.checkNotNull(extraData3);
        Integer type = extraData3.getType();
        Intrinsics.checkNotNull(type);
        return onlineStatusHelper.getDiyStatusDrawable(intValue, type.intValue());
    }

    public final String getSongName(SongInfo songInfo) {
        Intrinsics.checkNotNullParameter(songInfo, "songInfo");
        return songInfo.getSongName() + '-' + songInfo.getSingerName();
    }

    public final boolean canShowSong(OnlineStatus status) {
        boolean z16;
        SongInfo songInfo;
        SongInfo songInfo2;
        if (status == null) {
            return false;
        }
        SpecialStatus extraData = status.getExtraData();
        String str = null;
        if ((extraData != null ? extraData.getSongInfo() : null) != null) {
            SpecialStatus extraData2 = status.getExtraData();
            String songName = (extraData2 == null || (songInfo2 = extraData2.getSongInfo()) == null) ? null : songInfo2.getSongName();
            if (!(songName == null || songName.length() == 0)) {
                SpecialStatus extraData3 = status.getExtraData();
                if (extraData3 != null && (songInfo = extraData3.getSongInfo()) != null) {
                    str = songInfo.getSingerName();
                }
                if (!(str == null || str.length() == 0)) {
                    z16 = true;
                    return z16 && SquareAvatarItemKt.isMusicStatus(status);
                }
            }
        }
        z16 = false;
        if (z16) {
            return false;
        }
    }

    public final int getEditTextLength(String msg2) {
        int i3 = 0;
        if (msg2 == null || msg2.length() == 0) {
            return 0;
        }
        int i16 = 1;
        while (true) {
            int i17 = 2;
            if (i3 < msg2.length()) {
                char charAt = msg2.charAt(i3);
                if (INSTANCE.isEmoji(charAt) || charAt < '\u0080') {
                    i17 = 1;
                }
                i16 += i17;
                i3++;
            } else {
                return i16 / 2;
            }
        }
    }

    public static /* synthetic */ Drawable getIconDrawable$default(OnlineStatusBubbleViewHelper onlineStatusBubbleViewHelper, OnlineStatus onlineStatus, boolean z16, URLDrawable.URLDrawableListener uRLDrawableListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            uRLDrawableListener = null;
        }
        return onlineStatusBubbleViewHelper.getIconDrawable(onlineStatus, z16, uRLDrawableListener);
    }
}
