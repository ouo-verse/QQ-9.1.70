package cooperation.qzone.statistic.access;

import com.tencent.ads.data.AdParam;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.statistic.access.concept.Key;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WnsKeys {
    public static Key[] PrivateKeys;
    public static Key[] PublicKeys;
    public static Key TcpTime;
    public static Key Device = new Key("device");
    public static Key SDKVersion = new Key(AdParam.SDKVERSION);
    public static Key DeviceInfo = new Key("deviceinfo");
    public static Key CommandId = new Key("commandid");
    public static Key APN = new Key("apn");
    public static Key ResultCode_i = new Key("resultcode");
    public static Key Timestamp = new Key(TPReportKeys.PlayerStep.PLAYER_START_TIME);
    public static Key ToUIN = new Key("touin");
    public static Key TimeCost = new Key("tmcost");
    public static Key RequestSize = new Key("reqsize");
    public static Key ResponseSize = new Key("rspsize");
    public static Key Frequency = new Key("frequency");
    public static Key ServerIP = new Key("serverip");
    public static Key Detail = new Key("detail");
    public static Key Sequence = new Key("seq");
    public static Key Qua = new Key("qua");
    public static Key Port = new Key("port");
    public static Key AppId = new Key("appid");
    public static Key ReleaseVersion = new Key("releaseversion");
    public static Key Build = new Key("build");
    public static Key DType = new Key(AdParam.DTYPE);
    public static Key ODetails = new Key("odetails");
    public static Key BusiServerip = new Key("busiserverip");
    public static Key TEST = new Key("test");
    public static Key DnsTime = new Key("dnstime");

    static {
        Key key = new Key("tcptime");
        TcpTime = key;
        Key[] keyArr = {Device, SDKVersion, DeviceInfo};
        PublicKeys = keyArr;
        PrivateKeys = new Key[]{AppId, ReleaseVersion, Build, CommandId, APN, ResultCode_i, Timestamp, ToUIN, TimeCost, RequestSize, ResponseSize, Frequency, ServerIP, Port, Detail, Sequence, Qua, DType, ODetails, TEST, DnsTime, key};
        Key.initializeOrders(keyArr);
        Key.initializeOrders(PrivateKeys);
    }
}
