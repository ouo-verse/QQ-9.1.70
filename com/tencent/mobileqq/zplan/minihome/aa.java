package com.tencent.mobileqq.zplan.minihome;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J$\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H&J$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006H&JV\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006H&J<\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u001cH&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/aa;", "", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeProfileCardType;", "type", "", "a", "", "uin", "d", "eventCode", "timeStatJSONString", "pixelCallbackDuration", "f", "errMsg", "errorDuration", "b", "entranceFrom", "exitReason", "isResetRoomAndAvatar", "roomLoadDuration", "avatarLoadDuration", "totalDuration", "c", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeReplaceEvent;", "event", "", "success", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "e", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface aa {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(aa aaVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, Object obj) {
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            if (obj == null) {
                String str14 = "unknown";
                if ((i3 & 2) != 0) {
                    str9 = "unknown";
                } else {
                    str9 = str2;
                }
                if ((i3 & 4) == 0) {
                    str14 = str3;
                }
                String str15 = "";
                if ((i3 & 8) != 0) {
                    str10 = "";
                } else {
                    str10 = str4;
                }
                if ((i3 & 16) != 0) {
                    str11 = "";
                } else {
                    str11 = str5;
                }
                if ((i3 & 32) != 0) {
                    str12 = "";
                } else {
                    str12 = str6;
                }
                if ((i3 & 64) != 0) {
                    str13 = "";
                } else {
                    str13 = str7;
                }
                if ((i3 & 128) == 0) {
                    str15 = str8;
                }
                aaVar.c(str, str9, str14, str10, str11, str12, str13, str15);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportMiniHomeExit");
        }
    }

    void a(@NotNull MiniHomeProfileCardType type);

    void b(@NotNull String eventCode, @Nullable String errMsg, @NotNull String errorDuration);

    void c(@NotNull String eventCode, @NotNull String entranceFrom, @NotNull String exitReason, @NotNull String isResetRoomAndAvatar, @NotNull String pixelCallbackDuration, @NotNull String roomLoadDuration, @NotNull String avatarLoadDuration, @NotNull String totalDuration);

    void d(@NotNull String uin);

    void e(@NotNull MiniHomeReplaceEvent event, boolean success, @NotNull HashMap<String, String> params);

    void f(@NotNull String eventCode, @Nullable String timeStatJSONString, @NotNull String pixelCallbackDuration);
}
