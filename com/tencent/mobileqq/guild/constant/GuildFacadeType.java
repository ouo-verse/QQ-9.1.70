package com.tencent.mobileqq.guild.constant;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "getReportPageId", "", "isDialogStyle", "", "isPreviewStyle", "isPreviewVisitorLeaveMsg", "isPreviewVisitorRecommendChannel", "isStandaloneStyle", "isTabStyle", "Tab", "Standalone", "Dialog", "PreviewVisitorCards", "PreviewVisitorLeaveMsg", "SettingEntrance", "ChatList", "FeedsGuildHome9015", "FeedsGuildHomeSubChannel9015", "GameCenter", "UnknownType", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public enum GuildFacadeType implements Serializable {
    Tab,
    Standalone,
    Dialog,
    PreviewVisitorCards,
    PreviewVisitorLeaveMsg,
    SettingEntrance,
    ChatList,
    FeedsGuildHome9015,
    FeedsGuildHomeSubChannel9015,
    GameCenter,
    UnknownType;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216292a;

        static {
            int[] iArr = new int[GuildFacadeType.values().length];
            try {
                iArr[GuildFacadeType.Tab.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildFacadeType.Standalone.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildFacadeType.Dialog.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GuildFacadeType.PreviewVisitorCards.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GuildFacadeType.PreviewVisitorLeaveMsg.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[GuildFacadeType.SettingEntrance.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[GuildFacadeType.ChatList.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[GuildFacadeType.FeedsGuildHome9015.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[GuildFacadeType.FeedsGuildHomeSubChannel9015.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[GuildFacadeType.GameCenter.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            f216292a = iArr;
        }
    }

    @NotNull
    public final String getReportPageId() {
        switch (a.f216292a[ordinal()]) {
            case 1:
                return "pg_sgrp_channel";
            case 2:
                return "pg_sgrp_sole_channel";
            case 3:
                return "pg_sgrp_sole_channel_floated";
            case 4:
            case 5:
                return "pg_sgrp_tourists_view_preview";
            case 6:
                return "pg_sgrp_tourists_view_set";
            case 7:
                return "pg_sgrp_subscribe_channel";
            case 8:
                return "pg_sgrp_channel_feed";
            case 9:
            case 10:
                return "pg_sgrp_em_sgrp_chat_activity";
            default:
                return "unknown";
        }
    }

    public final boolean isDialogStyle() {
        if (this == Dialog) {
            return true;
        }
        return false;
    }

    public final boolean isPreviewStyle() {
        if (this != PreviewVisitorCards && this != SettingEntrance && this != PreviewVisitorLeaveMsg) {
            return false;
        }
        return true;
    }

    public final boolean isPreviewVisitorLeaveMsg() {
        if (this == PreviewVisitorLeaveMsg) {
            return true;
        }
        return false;
    }

    public final boolean isPreviewVisitorRecommendChannel() {
        if (this != PreviewVisitorCards && this != SettingEntrance) {
            return false;
        }
        return true;
    }

    public final boolean isStandaloneStyle() {
        if (this != Standalone && this != PreviewVisitorCards && this != SettingEntrance && this != PreviewVisitorLeaveMsg && this != ChatList && this != FeedsGuildHome9015) {
            return false;
        }
        return true;
    }

    public final boolean isTabStyle() {
        if (this == Tab) {
            return true;
        }
        return false;
    }
}
