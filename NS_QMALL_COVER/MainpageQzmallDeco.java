package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MainpageQzmallDeco extends JceStruct {
    public UserCmShowQzoneTrack stCmShowQzoneTrack;
    public CustomTrackDeco stCustomTrack;
    public QzmallCustomVip stCustomVip;
    public DataForQboss stQbossData;
    public StrangerSkin stStrangerSkin;
    public QzmallVipWidget stVipWidget;
    public ActYellowDiamond stYellowDiamond;
    static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
    static QzmallVipWidget cache_stVipWidget = new QzmallVipWidget();
    static ActYellowDiamond cache_stYellowDiamond = new ActYellowDiamond();
    static DataForQboss cache_stQbossData = new DataForQboss();
    static CustomTrackDeco cache_stCustomTrack = new CustomTrackDeco();
    static StrangerSkin cache_stStrangerSkin = new StrangerSkin();
    static UserCmShowQzoneTrack cache_stCmShowQzoneTrack = new UserCmShowQzoneTrack();

    public MainpageQzmallDeco() {
        this.stCustomVip = null;
        this.stVipWidget = null;
        this.stYellowDiamond = null;
        this.stQbossData = null;
        this.stCustomTrack = null;
        this.stStrangerSkin = null;
        this.stCmShowQzoneTrack = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stCustomVip = (QzmallCustomVip) jceInputStream.read((JceStruct) cache_stCustomVip, 0, false);
        this.stVipWidget = (QzmallVipWidget) jceInputStream.read((JceStruct) cache_stVipWidget, 1, false);
        this.stYellowDiamond = (ActYellowDiamond) jceInputStream.read((JceStruct) cache_stYellowDiamond, 2, false);
        this.stQbossData = (DataForQboss) jceInputStream.read((JceStruct) cache_stQbossData, 3, false);
        this.stCustomTrack = (CustomTrackDeco) jceInputStream.read((JceStruct) cache_stCustomTrack, 4, false);
        this.stStrangerSkin = (StrangerSkin) jceInputStream.read((JceStruct) cache_stStrangerSkin, 5, false);
        this.stCmShowQzoneTrack = (UserCmShowQzoneTrack) jceInputStream.read((JceStruct) cache_stCmShowQzoneTrack, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        QzmallCustomVip qzmallCustomVip = this.stCustomVip;
        if (qzmallCustomVip != null) {
            jceOutputStream.write((JceStruct) qzmallCustomVip, 0);
        }
        QzmallVipWidget qzmallVipWidget = this.stVipWidget;
        if (qzmallVipWidget != null) {
            jceOutputStream.write((JceStruct) qzmallVipWidget, 1);
        }
        ActYellowDiamond actYellowDiamond = this.stYellowDiamond;
        if (actYellowDiamond != null) {
            jceOutputStream.write((JceStruct) actYellowDiamond, 2);
        }
        DataForQboss dataForQboss = this.stQbossData;
        if (dataForQboss != null) {
            jceOutputStream.write((JceStruct) dataForQboss, 3);
        }
        CustomTrackDeco customTrackDeco = this.stCustomTrack;
        if (customTrackDeco != null) {
            jceOutputStream.write((JceStruct) customTrackDeco, 4);
        }
        StrangerSkin strangerSkin = this.stStrangerSkin;
        if (strangerSkin != null) {
            jceOutputStream.write((JceStruct) strangerSkin, 5);
        }
        UserCmShowQzoneTrack userCmShowQzoneTrack = this.stCmShowQzoneTrack;
        if (userCmShowQzoneTrack != null) {
            jceOutputStream.write((JceStruct) userCmShowQzoneTrack, 6);
        }
    }

    public MainpageQzmallDeco(QzmallCustomVip qzmallCustomVip, QzmallVipWidget qzmallVipWidget, ActYellowDiamond actYellowDiamond, DataForQboss dataForQboss, CustomTrackDeco customTrackDeco, StrangerSkin strangerSkin, UserCmShowQzoneTrack userCmShowQzoneTrack) {
        this.stCustomVip = qzmallCustomVip;
        this.stVipWidget = qzmallVipWidget;
        this.stYellowDiamond = actYellowDiamond;
        this.stQbossData = dataForQboss;
        this.stCustomTrack = customTrackDeco;
        this.stStrangerSkin = strangerSkin;
        this.stCmShowQzoneTrack = userCmShowQzoneTrack;
    }
}
