package NS_QQ_STORY_META;

import com.qzone.common.business.model.AvatarCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$StMusic extends MessageMicro<META$StMusic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64, 74, 80, 88, 98, 106, 112, 120, 130, 136, 146, 154, 162, 168, 178, 186, 194, 200}, new String[]{"uiSongId", "strSongMid", "strSongName", "strLanguage", "iTrySize", "iTryBegin", "iTryEnd", "iPlayTime", "strPlayUrl", "iSize", "copyright", "strFormat", "strLyric", AvatarCacheData.ITYPE, "iStartPos", "strLabel", "uiAlbumId", "strAlbumMid", "strAlbumName", "strAlbumPic", "uiSingerId", "strSingerMid", "strSingerName", "strSingerPic", "iFrom"}, new Object[]{0L, "", "", "", 0, 0, 0, 0, "", 0, 0, "", "", 0, 0L, "", 0L, "", "", "", 0L, "", "", "", 0}, META$StMusic.class);
    public final PBUInt64Field uiSongId = PBField.initUInt64(0);
    public final PBStringField strSongMid = PBField.initString("");
    public final PBStringField strSongName = PBField.initString("");
    public final PBStringField strLanguage = PBField.initString("");
    public final PBInt32Field iTrySize = PBField.initInt32(0);
    public final PBInt32Field iTryBegin = PBField.initInt32(0);
    public final PBInt32Field iTryEnd = PBField.initInt32(0);
    public final PBInt32Field iPlayTime = PBField.initInt32(0);
    public final PBStringField strPlayUrl = PBField.initString("");
    public final PBInt32Field iSize = PBField.initInt32(0);
    public final PBInt32Field copyright = PBField.initInt32(0);
    public final PBStringField strFormat = PBField.initString("");
    public final PBStringField strLyric = PBField.initString("");
    public final PBInt32Field iType = PBField.initInt32(0);
    public final PBUInt64Field iStartPos = PBField.initUInt64(0);
    public final PBStringField strLabel = PBField.initString("");
    public final PBUInt64Field uiAlbumId = PBField.initUInt64(0);
    public final PBStringField strAlbumMid = PBField.initString("");
    public final PBStringField strAlbumName = PBField.initString("");
    public final PBStringField strAlbumPic = PBField.initString("");
    public final PBUInt64Field uiSingerId = PBField.initUInt64(0);
    public final PBStringField strSingerMid = PBField.initString("");
    public final PBStringField strSingerName = PBField.initString("");
    public final PBStringField strSingerPic = PBField.initString("");
    public final PBInt32Field iFrom = PBField.initInt32(0);
}
