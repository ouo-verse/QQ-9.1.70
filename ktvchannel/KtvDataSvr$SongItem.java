package ktvchannel;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$SongItem extends MessageMicro<KtvDataSvr$SongItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField ksong_mid = PBField.initString("");
    public final PBStringField song_name = PBField.initString("");
    public final PBStringField singer_mid = PBField.initString("");
    public final PBStringField singer_name = PBField.initString("");
    public final PBStringField song_cover_url = PBField.initString("");
    public final PBStringField accompany_url = PBField.initString("");
    public final PBStringField origin_audio_url = PBField.initString("");
    public final PBStringField mv_url = PBField.initString("");
    public final PBInt32Field play_interval = PBField.initInt32(0);
    public KtvDataSvr$LyricInfo lyric_info = new MessageMicro<KtvDataSvr$LyricInfo>() { // from class: ktvchannel.KtvDataSvr$LyricInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48}, new String[]{"content", "timestamp", "compress_type", "code", "version", "lyric_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, "", 0}, KtvDataSvr$LyricInfo.class);
        public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field timestamp = PBField.initInt32(0);
        public final PBInt32Field compress_type = PBField.initInt32(0);
        public final PBInt32Field code = PBField.initInt32(0);
        public final PBStringField version = PBField.initString("");
        public final PBInt32Field lyric_type = PBField.initInt32(0);
    };
    public final PBInt32Field music_file_size = PBField.initInt32(0);
    public final PBStringField album_mid = PBField.initString("");
    public KtvDataSvr$LyricInfo note_info = new MessageMicro<KtvDataSvr$LyricInfo>() { // from class: ktvchannel.KtvDataSvr$LyricInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48}, new String[]{"content", "timestamp", "compress_type", "code", "version", "lyric_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, "", 0}, KtvDataSvr$LyricInfo.class);
        public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field timestamp = PBField.initInt32(0);
        public final PBInt32Field compress_type = PBField.initInt32(0);
        public final PBInt32Field code = PBField.initInt32(0);
        public final PBStringField version = PBField.initString("");
        public final PBInt32Field lyric_type = PBField.initInt32(0);
    };
    public KtvDataSvr$LyricInfo section_info = new MessageMicro<KtvDataSvr$LyricInfo>() { // from class: ktvchannel.KtvDataSvr$LyricInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48}, new String[]{"content", "timestamp", "compress_type", "code", "version", "lyric_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, "", 0}, KtvDataSvr$LyricInfo.class);
        public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field timestamp = PBField.initInt32(0);
        public final PBInt32Field compress_type = PBField.initInt32(0);
        public final PBInt32Field code = PBField.initInt32(0);
        public final PBStringField version = PBField.initString("");
        public final PBInt32Field lyric_type = PBField.initInt32(0);
    };
    public final PBInt32Field song_type = PBField.initInt32(0);
    public final PBBoolField has_mv = PBField.initBool(false);
    public final PBBoolField has_hq = PBField.initBool(false);
    public final PBBoolField has_ori_song = PBField.initBool(false);
    public final PBBoolField has_midi = PBField.initBool(false);
    public final PBBoolField mv_has_lyric = PBField.initBool(false);
    public final PBInt32Field language = PBField.initInt32(0);
    public final PBInt32Field cp_status = PBField.initInt32(0);
    public final PBBoolField need_vip = PBField.initBool(false);
    public final PBUInt32Field qqmusic_id = PBField.initUInt32(0);
    public final PBInt32Field block_mask = PBField.initInt32(0);

    static {
        String[] strArr = {"ksong_mid", "song_name", "singer_mid", "singer_name", "song_cover_url", "accompany_url", "origin_audio_url", "mv_url", "play_interval", "lyric_info", "music_file_size", "album_mid", "note_info", "section_info", "song_type", "has_mv", "has_hq", "has_ori_song", "has_midi", "mv_has_lyric", IjkMediaMeta.IJKM_KEY_LANGUAGE, "cp_status", "need_vip", "qqmusic_id", "block_mask"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 88, 98, 106, 114, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200}, strArr, new Object[]{"", "", "", "", "", "", "", "", 0, null, 0, "", null, null, 0, bool, bool, bool, bool, bool, 0, 0, bool, 0, 0}, KtvDataSvr$SongItem.class);
    }
}
