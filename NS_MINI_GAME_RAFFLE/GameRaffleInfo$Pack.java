package NS_MINI_GAME_RAFFLE;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes.dex */
public final class GameRaffleInfo$Pack extends MessageMicro<GameRaffleInfo$Pack> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField business_cover;
    public final PBUInt32Field business_id;
    public final PBStringField business_logo;
    public final PBStringField business_name;
    public final PBStringField business_name_pic;
    public final PBStringField business_video;
    public final PBStringField business_video_cover;
    public final PBUInt32Field ctime;
    public final PBUInt32Field money;
    public final PBUInt32Field mtime;
    public final PBStringField order;
    public final PBBytesField pack_id;
    public final PBUInt32Field promotion_id;
    public final PBStringField req_id;
    public final PBUInt64Field send_uin;
    public final PBBytesField signature;
    public final PBUInt32Field state;
    public final PBUInt32Field type;
    public final PBUInt64Field uin;
    public final PBStringField url;
    public final PBStringField wishing;

    static {
        String[] strArr = {"pack_id", "state", "type", "ctime", WidgetCacheConstellationData.MONEY, "business_id", "signature", "url", "mtime", "order", "uin", "send_uin", "wishing", "promotion_id", CheckForwardServlet.KEY_REQ_ID, "business_name", "business_logo", "business_cover", "business_video_cover", "business_video", "business_name_pic"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 66, 72, 82, 88, 96, 106, 112, 122, 130, 138, 146, 154, 162, 170}, strArr, new Object[]{byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, "", 0, "", 0L, 0L, "", 0, "", "", "", "", "", "", ""}, GameRaffleInfo$Pack.class);
    }

    public GameRaffleInfo$Pack() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pack_id = PBField.initBytes(byteStringMicro);
        this.state = PBField.initUInt32(0);
        this.type = PBField.initUInt32(0);
        this.ctime = PBField.initUInt32(0);
        this.money = PBField.initUInt32(0);
        this.business_id = PBField.initUInt32(0);
        this.signature = PBField.initBytes(byteStringMicro);
        this.url = PBField.initString("");
        this.mtime = PBField.initUInt32(0);
        this.order = PBField.initString("");
        this.uin = PBField.initUInt64(0L);
        this.send_uin = PBField.initUInt64(0L);
        this.wishing = PBField.initString("");
        this.promotion_id = PBField.initUInt32(0);
        this.req_id = PBField.initString("");
        this.business_name = PBField.initString("");
        this.business_logo = PBField.initString("");
        this.business_cover = PBField.initString("");
        this.business_video_cover = PBField.initString("");
        this.business_video = PBField.initString("");
        this.business_name_pic = PBField.initString("");
    }
}
