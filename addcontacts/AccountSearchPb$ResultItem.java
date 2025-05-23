package addcontacts;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes.dex */
public final class AccountSearchPb$ResultItem extends MessageMicro<AccountSearchPb$ResultItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id;
    public final PBBytesField feed_type;
    public final PBUInt32Field ftime;
    public final PBBytesField has_video;
    public final PBBytesField jmp_url;
    public final PBBytesField name;
    public final PBBytesField nick_name;
    public final PBBytesField phtot_update;
    public final PBBytesField pic_url;
    public final PBRepeatField<ByteStringMicro> pic_url_list;
    public final PBBytesField result_id;
    public final PBBytesField summary;
    public final PBUInt32Field total_pic_num;
    public final PBUInt64Field uin;

    static {
        String[] strArr = {"feed_id", "name", "pic_url", "jmp_url", QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "summary", "has_video", "phtot_update", "uin", "result_id", TPReportKeys.LiveExKeys.LIVE_EX_REPORT_TIME, IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "pic_url_list", "total_pic_num"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 88, 98, 106, 112}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0}, AccountSearchPb$ResultItem.class);
    }

    public AccountSearchPb$ResultItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.feed_id = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.jmp_url = PBField.initBytes(byteStringMicro);
        this.feed_type = PBField.initBytes(byteStringMicro);
        this.summary = PBField.initBytes(byteStringMicro);
        this.has_video = PBField.initBytes(byteStringMicro);
        this.phtot_update = PBField.initBytes(byteStringMicro);
        this.uin = PBField.initUInt64(0L);
        this.result_id = PBField.initBytes(byteStringMicro);
        this.ftime = PBField.initUInt32(0);
        this.nick_name = PBField.initBytes(byteStringMicro);
        this.pic_url_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.total_pic_num = PBField.initUInt32(0);
    }
}
