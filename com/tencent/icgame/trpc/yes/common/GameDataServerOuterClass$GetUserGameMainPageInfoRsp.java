package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetUserGameMainPageInfoRsp extends MessageMicro<GameDataServerOuterClass$GetUserGameMainPageInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{34}, new String[]{"qsm"}, new Object[]{null}, GameDataServerOuterClass$GetUserGameMainPageInfoRsp.class);
    public GameDataServerOuterClass$QsmMainPageInfo qsm = new MessageMicro<GameDataServerOuterClass$QsmMainPageInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rank", "history_best_rank", "game_info"}, new Object[]{null, null, null}, GameDataServerOuterClass$QsmMainPageInfo.class);
        public GameDataServerOuterClass$QsmMainPageRankInfo rank = new MessageMicro<GameDataServerOuterClass$QsmMainPageRankInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageRankInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58}, new String[]{"level", "name", "short_name", "big_grade_level", "big_grade_name", "grade_small_image", "grade_big_image"}, new Object[]{0L, "", "", 0L, "", "", ""}, GameDataServerOuterClass$QsmMainPageRankInfo.class);
            public final PBUInt64Field level = PBField.initUInt64(0);
            public final PBStringField name = PBField.initString("");
            public final PBStringField short_name = PBField.initString("");
            public final PBUInt64Field big_grade_level = PBField.initUInt64(0);
            public final PBStringField big_grade_name = PBField.initString("");
            public final PBStringField grade_small_image = PBField.initString("");
            public final PBStringField grade_big_image = PBField.initString("");
        };
        public GameDataServerOuterClass$QsmMainPageRankInfo history_best_rank = new MessageMicro<GameDataServerOuterClass$QsmMainPageRankInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageRankInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58}, new String[]{"level", "name", "short_name", "big_grade_level", "big_grade_name", "grade_small_image", "grade_big_image"}, new Object[]{0L, "", "", 0L, "", "", ""}, GameDataServerOuterClass$QsmMainPageRankInfo.class);
            public final PBUInt64Field level = PBField.initUInt64(0);
            public final PBStringField name = PBField.initString("");
            public final PBStringField short_name = PBField.initString("");
            public final PBUInt64Field big_grade_level = PBField.initUInt64(0);
            public final PBStringField big_grade_name = PBField.initString("");
            public final PBStringField grade_small_image = PBField.initString("");
            public final PBStringField grade_big_image = PBField.initString("");
        };
        public GameDataServerOuterClass$QsmMainPageGameInfo game_info = new MessageMicro<GameDataServerOuterClass$QsmMainPageGameInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageGameInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"speed_single", "speed_team", "prop_single", "prop_team"}, new Object[]{null, null, null, null}, GameDataServerOuterClass$QsmMainPageGameInfo.class);
            public GameDataServerOuterClass$QsmMainPageSingleGameInfo speed_single = new MessageMicro<GameDataServerOuterClass$QsmMainPageSingleGameInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageSingleGameInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"match_count", "avg_rank", "continuous_complete", "all_kill_count", "complete_rate"}, new Object[]{0L, "", 0L, 0L, ""}, GameDataServerOuterClass$QsmMainPageSingleGameInfo.class);
                public final PBUInt64Field match_count = PBField.initUInt64(0);
                public final PBStringField avg_rank = PBField.initString("");
                public final PBUInt64Field continuous_complete = PBField.initUInt64(0);
                public final PBUInt64Field all_kill_count = PBField.initUInt64(0);
                public final PBStringField complete_rate = PBField.initString("");
            };
            public GameDataServerOuterClass$QsmMainPageTeamGameInfo speed_team = new MessageMicro<GameDataServerOuterClass$QsmMainPageTeamGameInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageTeamGameInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"match_count", "win_over_count", "continuous_win", "mvp_count", "win_rate"}, new Object[]{0L, 0L, 0L, 0L, ""}, GameDataServerOuterClass$QsmMainPageTeamGameInfo.class);
                public final PBUInt64Field match_count = PBField.initUInt64(0);
                public final PBUInt64Field win_over_count = PBField.initUInt64(0);
                public final PBUInt64Field continuous_win = PBField.initUInt64(0);
                public final PBUInt64Field mvp_count = PBField.initUInt64(0);
                public final PBStringField win_rate = PBField.initString("");
            };
            public GameDataServerOuterClass$QsmMainPageSingleGameInfo prop_single = new MessageMicro<GameDataServerOuterClass$QsmMainPageSingleGameInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageSingleGameInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"match_count", "avg_rank", "continuous_complete", "all_kill_count", "complete_rate"}, new Object[]{0L, "", 0L, 0L, ""}, GameDataServerOuterClass$QsmMainPageSingleGameInfo.class);
                public final PBUInt64Field match_count = PBField.initUInt64(0);
                public final PBStringField avg_rank = PBField.initString("");
                public final PBUInt64Field continuous_complete = PBField.initUInt64(0);
                public final PBUInt64Field all_kill_count = PBField.initUInt64(0);
                public final PBStringField complete_rate = PBField.initString("");
            };
            public GameDataServerOuterClass$QsmMainPageTeamGameInfo prop_team = new MessageMicro<GameDataServerOuterClass$QsmMainPageTeamGameInfo>() { // from class: com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$QsmMainPageTeamGameInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"match_count", "win_over_count", "continuous_win", "mvp_count", "win_rate"}, new Object[]{0L, 0L, 0L, 0L, ""}, GameDataServerOuterClass$QsmMainPageTeamGameInfo.class);
                public final PBUInt64Field match_count = PBField.initUInt64(0);
                public final PBUInt64Field win_over_count = PBField.initUInt64(0);
                public final PBUInt64Field continuous_win = PBField.initUInt64(0);
                public final PBUInt64Field mvp_count = PBField.initUInt64(0);
                public final PBStringField win_rate = PBField.initString("");
            };
        };
    };
}
