package com.xiaomi.push;

import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.vas.perception.api.IVipPerceptionKt;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum ei {
    TCP_CONN_FAIL(1),
    TCP_CONN_TIME(2),
    PING_RTT(3),
    CHANNEL_CON_FAIL(4),
    CHANNEL_CON_OK(5),
    ICMP_PING_FAIL(6),
    ICMP_PING_OK(7),
    CHANNEL_ONLINE_RATE(8),
    BATCH_TCP_CONN_SUCCESS(1000),
    BATCH_TCP_CONN_FAIL(1001),
    CHANNEL_STATS_COUNTER(8000),
    GSLB_REQUEST_SUCCESS(10000),
    GSLB_TCP_NOACCESS(10101),
    GSLB_TCP_NETUNREACH(10102),
    GSLB_TCP_CONNREFUSED(TVKEventId.PLAYER_STATE_START_PLAY),
    GSLB_TCP_NOROUTETOHOST(TVKEventId.PLAYER_STATE_PAUSE),
    GSLB_TCP_TIMEOUT(IVipPerceptionKt.VIP_PERCEPTION_OBTAIN_EXPERIENCE_ERR_CODE_REPEAT),
    GSLB_TCP_INVALARG(10106),
    GSLB_TCP_UKNOWNHOST(TVKEventId.PLAYER_STATE_STOP),
    GSLB_TCP_ERR_OTHER(10199),
    GSLB_ERR(10999),
    CONN_SUCCESS(20000),
    CONN_TCP_NOACCESS(ErrorCode.ERROR_CMD_INVALID),
    CONN_TCP_NETUNREACH(ErrorCode.ERROR_APPID_NOT_FOUND),
    CONN_TCP_CONNREFUSED(ErrorCode.ERROR_VERIFY_FAILED),
    CONN_TCP_NOROUTETOHOST(ErrorCode.ERROR_HTTP_CONTENT_FORMAT),
    CONN_TCP_TIMEOUT(ErrorCode.ERROR_TIMESTAMP_INVALID),
    CONN_TCP_INVALARG(ErrorCode.ERROR_CHECKLEGALAPP_SYS_ERROR),
    CONN_TCP_UKNOWNHOST(ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP),
    CONN_TCP_ERR_OTHER(20199),
    CONN_XMPP_ERR(20399),
    CONN_BOSH_UNKNOWNHOST(20407),
    CONN_BOSH_ERR(20499),
    BIND_SUCCESS(30000),
    BIND_TCP_READ_TIMEOUT_DEPRECTED(ErrorCode.SRERR_UNKNOWN_VOICE_FILE_TYPE),
    BIND_TCP_CONNRESET_DEPRECTED(ErrorCode.SRERR_INVALID_BITS_PER_SAMPLE),
    BIND_TCP_BROKEN_PIPE_DEPRECTED(ErrorCode.SRERR_INVALID_SAMPLE_PER_SEC),
    BIND_TCP_READ_TIMEOUT(ErrorCode.SRERR_INVALID_GRAMMAR_TYPE),
    BIND_TCP_CONNRESET(ErrorCode.SRERR_INVALID_CMD),
    BIND_TCP_BROKEN_PIPE(ErrorCode.SRERR_ALREADY_FAILED),
    BIND_TCP_ERR(30199),
    BIND_XMPP_ERR(30399),
    BIND_BOSH_ITEM_NOT_FOUND(ErrorCode.SRERR_DECOMPRESS_FAILED),
    BIND_BOSH_ERR(30499),
    BIND_TIMEOUT(ErrorCode.SRERR_NOENOUGH_INFO),
    BIND_INVALID_SIG(30502),
    CHANNEL_TCP_READTIMEOUT_DEPRECTED(VasWebviewConstants.REPORT_FROM_MY_INDIVIDUATION_SET),
    CHANNEL_TCP_CONNRESET_DEPRECTED(40102),
    CHANNEL_TCP_BROKEN_PIPE_DEPRECTED(40103),
    CHANNEL_TCP_READTIMEOUT(40108),
    CHANNEL_TCP_CONNRESET(40109),
    CHANNEL_TCP_BROKEN_PIPE(40110),
    CHANNEL_TCP_ERR(40199),
    CHANNEL_XMPPEXCEPTION(40399),
    CHANNEL_BOSH_ITEMNOTFIND(VasWebviewConstants.REPORT_FROM_DYNAMIC_MORE),
    CHANNEL_BOSH_EXCEPTION(40499),
    CHANNEL_TIMER_DELAYED(50001);


    /* renamed from: a, reason: collision with other field name */
    private final int f24712a;

    ei(int i3) {
        this.f24712a = i3;
    }

    public int a() {
        return this.f24712a;
    }

    public static ei a(int i3) {
        if (i3 == 30501) {
            return BIND_TIMEOUT;
        }
        if (i3 != 30502) {
            switch (i3) {
                case 1:
                    return TCP_CONN_FAIL;
                case 2:
                    return TCP_CONN_TIME;
                case 3:
                    return PING_RTT;
                case 4:
                    return CHANNEL_CON_FAIL;
                case 5:
                    return CHANNEL_CON_OK;
                case 6:
                    return ICMP_PING_FAIL;
                case 7:
                    return ICMP_PING_OK;
                case 8:
                    return CHANNEL_ONLINE_RATE;
                default:
                    switch (i3) {
                        case 8000:
                            return CHANNEL_STATS_COUNTER;
                        case 10000:
                            return GSLB_REQUEST_SUCCESS;
                        case 10199:
                            return GSLB_TCP_ERR_OTHER;
                        case 10999:
                            return GSLB_ERR;
                        case 20000:
                            return CONN_SUCCESS;
                        case 20199:
                            return CONN_TCP_ERR_OTHER;
                        case 20399:
                            return CONN_XMPP_ERR;
                        case 20407:
                            return CONN_BOSH_UNKNOWNHOST;
                        case 20499:
                            return CONN_BOSH_ERR;
                        case 30000:
                            return BIND_SUCCESS;
                        case 30199:
                            return BIND_TCP_ERR;
                        case 30399:
                            return BIND_XMPP_ERR;
                        case ErrorCode.SRERR_DECOMPRESS_FAILED /* 30401 */:
                            return BIND_BOSH_ITEM_NOT_FOUND;
                        case 30499:
                            return BIND_BOSH_ERR;
                        case 40199:
                            return CHANNEL_TCP_ERR;
                        case 40399:
                            return CHANNEL_XMPPEXCEPTION;
                        case VasWebviewConstants.REPORT_FROM_DYNAMIC_MORE /* 40401 */:
                            return CHANNEL_BOSH_ITEMNOTFIND;
                        case 40499:
                            return CHANNEL_BOSH_EXCEPTION;
                        case 50001:
                            return CHANNEL_TIMER_DELAYED;
                        default:
                            switch (i3) {
                                case 10101:
                                    return GSLB_TCP_NOACCESS;
                                case 10102:
                                    return GSLB_TCP_NETUNREACH;
                                case TVKEventId.PLAYER_STATE_START_PLAY /* 10103 */:
                                    return GSLB_TCP_CONNREFUSED;
                                case TVKEventId.PLAYER_STATE_PAUSE /* 10104 */:
                                    return GSLB_TCP_NOROUTETOHOST;
                                case IVipPerceptionKt.VIP_PERCEPTION_OBTAIN_EXPERIENCE_ERR_CODE_REPEAT /* 10105 */:
                                    return GSLB_TCP_TIMEOUT;
                                case 10106:
                                    return GSLB_TCP_INVALARG;
                                case TVKEventId.PLAYER_STATE_STOP /* 10107 */:
                                    return GSLB_TCP_UKNOWNHOST;
                                default:
                                    switch (i3) {
                                        case ErrorCode.ERROR_CMD_INVALID /* 20101 */:
                                            return CONN_TCP_NOACCESS;
                                        case ErrorCode.ERROR_APPID_NOT_FOUND /* 20102 */:
                                            return CONN_TCP_NETUNREACH;
                                        case ErrorCode.ERROR_VERIFY_FAILED /* 20103 */:
                                            return CONN_TCP_CONNREFUSED;
                                        case ErrorCode.ERROR_HTTP_CONTENT_FORMAT /* 20104 */:
                                            return CONN_TCP_NOROUTETOHOST;
                                        case ErrorCode.ERROR_TIMESTAMP_INVALID /* 20105 */:
                                            return CONN_TCP_TIMEOUT;
                                        case ErrorCode.ERROR_CHECKLEGALAPP_SYS_ERROR /* 20106 */:
                                            return CONN_TCP_INVALARG;
                                        case ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP /* 20107 */:
                                            return CONN_TCP_UKNOWNHOST;
                                        default:
                                            switch (i3) {
                                                case ErrorCode.SRERR_UNKNOWN_VOICE_FILE_TYPE /* 30101 */:
                                                    return BIND_TCP_READ_TIMEOUT_DEPRECTED;
                                                case ErrorCode.SRERR_INVALID_BITS_PER_SAMPLE /* 30102 */:
                                                    return BIND_TCP_CONNRESET_DEPRECTED;
                                                case ErrorCode.SRERR_INVALID_SAMPLE_PER_SEC /* 30103 */:
                                                    return BIND_TCP_BROKEN_PIPE_DEPRECTED;
                                                default:
                                                    switch (i3) {
                                                        case ErrorCode.SRERR_INVALID_GRAMMAR_TYPE /* 30108 */:
                                                            return BIND_TCP_READ_TIMEOUT;
                                                        case ErrorCode.SRERR_INVALID_CMD /* 30109 */:
                                                            return BIND_TCP_CONNRESET;
                                                        case ErrorCode.SRERR_ALREADY_FAILED /* 30110 */:
                                                            return BIND_TCP_BROKEN_PIPE;
                                                        default:
                                                            switch (i3) {
                                                                case VasWebviewConstants.REPORT_FROM_MY_INDIVIDUATION_SET /* 40101 */:
                                                                    return CHANNEL_TCP_READTIMEOUT_DEPRECTED;
                                                                case 40102:
                                                                    return CHANNEL_TCP_CONNRESET_DEPRECTED;
                                                                case 40103:
                                                                    return CHANNEL_TCP_BROKEN_PIPE_DEPRECTED;
                                                                default:
                                                                    switch (i3) {
                                                                        case 40108:
                                                                            return CHANNEL_TCP_READTIMEOUT;
                                                                        case 40109:
                                                                            return CHANNEL_TCP_CONNRESET;
                                                                        case 40110:
                                                                            return CHANNEL_TCP_BROKEN_PIPE;
                                                                        default:
                                                                            return null;
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return BIND_INVALID_SIG;
    }
}
