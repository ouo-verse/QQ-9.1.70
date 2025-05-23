package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfileQzmallDeco extends JceStruct {
    public QzmallAvatar stAvatar;
    public UserCmShowQzoneTrack stCmShowQzoneTrack;
    public QzmallCustomBanner stCustomBanner;
    public QzmallCustomNavi stCustomNavi;
    public QzmallCustomPlayer stCustomPlayer;
    public QzmallCustomPraise stCustomPraise;
    public CustomTrackDeco stCustomTrack;
    public QzmallCustomVip stCustomVip;
    public QzmallFacade stFacade;
    public FacadeDIY stFacadeDIY;
    public FeedNavi stFeedNavi;
    public QzmallFeedSkin stFeedSkin;
    public QzmallFloat stFloat;
    public PolymorphicPraise stPolymorphicPraise;
    public DataForQboss stQbossData;
    public ActYellowDiamond stYellowDiamond;
    static QzmallCustomNavi cache_stCustomNavi = new QzmallCustomNavi();
    static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
    static QzmallCustomPlayer cache_stCustomPlayer = new QzmallCustomPlayer();
    static QzmallCustomBanner cache_stCustomBanner = new QzmallCustomBanner();
    static QzmallAvatar cache_stAvatar = new QzmallAvatar();
    static QzmallFloat cache_stFloat = new QzmallFloat();
    static QzmallFeedSkin cache_stFeedSkin = new QzmallFeedSkin();
    static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
    static QzmallFacade cache_stFacade = new QzmallFacade();
    static ActYellowDiamond cache_stYellowDiamond = new ActYellowDiamond();
    static PolymorphicPraise cache_stPolymorphicPraise = new PolymorphicPraise();
    static DataForQboss cache_stQbossData = new DataForQboss();
    static FeedNavi cache_stFeedNavi = new FeedNavi();
    static FacadeDIY cache_stFacadeDIY = new FacadeDIY();
    static CustomTrackDeco cache_stCustomTrack = new CustomTrackDeco();
    static UserCmShowQzoneTrack cache_stCmShowQzoneTrack = new UserCmShowQzoneTrack();

    public ProfileQzmallDeco() {
        this.stCustomNavi = null;
        this.stCustomPraise = null;
        this.stCustomPlayer = null;
        this.stCustomBanner = null;
        this.stAvatar = null;
        this.stFloat = null;
        this.stFeedSkin = null;
        this.stCustomVip = null;
        this.stFacade = null;
        this.stYellowDiamond = null;
        this.stPolymorphicPraise = null;
        this.stQbossData = null;
        this.stFeedNavi = null;
        this.stFacadeDIY = null;
        this.stCustomTrack = null;
        this.stCmShowQzoneTrack = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stCustomNavi = (QzmallCustomNavi) jceInputStream.read((JceStruct) cache_stCustomNavi, 0, false);
        this.stCustomPraise = (QzmallCustomPraise) jceInputStream.read((JceStruct) cache_stCustomPraise, 1, false);
        this.stCustomPlayer = (QzmallCustomPlayer) jceInputStream.read((JceStruct) cache_stCustomPlayer, 2, false);
        this.stCustomBanner = (QzmallCustomBanner) jceInputStream.read((JceStruct) cache_stCustomBanner, 3, false);
        this.stAvatar = (QzmallAvatar) jceInputStream.read((JceStruct) cache_stAvatar, 4, false);
        this.stFloat = (QzmallFloat) jceInputStream.read((JceStruct) cache_stFloat, 5, false);
        this.stFeedSkin = (QzmallFeedSkin) jceInputStream.read((JceStruct) cache_stFeedSkin, 6, false);
        this.stCustomVip = (QzmallCustomVip) jceInputStream.read((JceStruct) cache_stCustomVip, 7, false);
        this.stFacade = (QzmallFacade) jceInputStream.read((JceStruct) cache_stFacade, 8, false);
        this.stYellowDiamond = (ActYellowDiamond) jceInputStream.read((JceStruct) cache_stYellowDiamond, 9, false);
        this.stPolymorphicPraise = (PolymorphicPraise) jceInputStream.read((JceStruct) cache_stPolymorphicPraise, 10, false);
        this.stQbossData = (DataForQboss) jceInputStream.read((JceStruct) cache_stQbossData, 11, false);
        this.stFeedNavi = (FeedNavi) jceInputStream.read((JceStruct) cache_stFeedNavi, 12, false);
        this.stFacadeDIY = (FacadeDIY) jceInputStream.read((JceStruct) cache_stFacadeDIY, 13, false);
        this.stCustomTrack = (CustomTrackDeco) jceInputStream.read((JceStruct) cache_stCustomTrack, 14, false);
        this.stCmShowQzoneTrack = (UserCmShowQzoneTrack) jceInputStream.read((JceStruct) cache_stCmShowQzoneTrack, 15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        QzmallCustomNavi qzmallCustomNavi = this.stCustomNavi;
        if (qzmallCustomNavi != null) {
            jceOutputStream.write((JceStruct) qzmallCustomNavi, 0);
        }
        QzmallCustomPraise qzmallCustomPraise = this.stCustomPraise;
        if (qzmallCustomPraise != null) {
            jceOutputStream.write((JceStruct) qzmallCustomPraise, 1);
        }
        QzmallCustomPlayer qzmallCustomPlayer = this.stCustomPlayer;
        if (qzmallCustomPlayer != null) {
            jceOutputStream.write((JceStruct) qzmallCustomPlayer, 2);
        }
        QzmallCustomBanner qzmallCustomBanner = this.stCustomBanner;
        if (qzmallCustomBanner != null) {
            jceOutputStream.write((JceStruct) qzmallCustomBanner, 3);
        }
        QzmallAvatar qzmallAvatar = this.stAvatar;
        if (qzmallAvatar != null) {
            jceOutputStream.write((JceStruct) qzmallAvatar, 4);
        }
        QzmallFloat qzmallFloat = this.stFloat;
        if (qzmallFloat != null) {
            jceOutputStream.write((JceStruct) qzmallFloat, 5);
        }
        QzmallFeedSkin qzmallFeedSkin = this.stFeedSkin;
        if (qzmallFeedSkin != null) {
            jceOutputStream.write((JceStruct) qzmallFeedSkin, 6);
        }
        QzmallCustomVip qzmallCustomVip = this.stCustomVip;
        if (qzmallCustomVip != null) {
            jceOutputStream.write((JceStruct) qzmallCustomVip, 7);
        }
        QzmallFacade qzmallFacade = this.stFacade;
        if (qzmallFacade != null) {
            jceOutputStream.write((JceStruct) qzmallFacade, 8);
        }
        ActYellowDiamond actYellowDiamond = this.stYellowDiamond;
        if (actYellowDiamond != null) {
            jceOutputStream.write((JceStruct) actYellowDiamond, 9);
        }
        PolymorphicPraise polymorphicPraise = this.stPolymorphicPraise;
        if (polymorphicPraise != null) {
            jceOutputStream.write((JceStruct) polymorphicPraise, 10);
        }
        DataForQboss dataForQboss = this.stQbossData;
        if (dataForQboss != null) {
            jceOutputStream.write((JceStruct) dataForQboss, 11);
        }
        FeedNavi feedNavi = this.stFeedNavi;
        if (feedNavi != null) {
            jceOutputStream.write((JceStruct) feedNavi, 12);
        }
        FacadeDIY facadeDIY = this.stFacadeDIY;
        if (facadeDIY != null) {
            jceOutputStream.write((JceStruct) facadeDIY, 13);
        }
        CustomTrackDeco customTrackDeco = this.stCustomTrack;
        if (customTrackDeco != null) {
            jceOutputStream.write((JceStruct) customTrackDeco, 14);
        }
        UserCmShowQzoneTrack userCmShowQzoneTrack = this.stCmShowQzoneTrack;
        if (userCmShowQzoneTrack != null) {
            jceOutputStream.write((JceStruct) userCmShowQzoneTrack, 15);
        }
    }

    public ProfileQzmallDeco(QzmallCustomNavi qzmallCustomNavi, QzmallCustomPraise qzmallCustomPraise, QzmallCustomPlayer qzmallCustomPlayer, QzmallCustomBanner qzmallCustomBanner, QzmallAvatar qzmallAvatar, QzmallFloat qzmallFloat, QzmallFeedSkin qzmallFeedSkin, QzmallCustomVip qzmallCustomVip, QzmallFacade qzmallFacade, ActYellowDiamond actYellowDiamond, PolymorphicPraise polymorphicPraise, DataForQboss dataForQboss, FeedNavi feedNavi, FacadeDIY facadeDIY, CustomTrackDeco customTrackDeco, UserCmShowQzoneTrack userCmShowQzoneTrack) {
        this.stCustomNavi = qzmallCustomNavi;
        this.stCustomPraise = qzmallCustomPraise;
        this.stCustomPlayer = qzmallCustomPlayer;
        this.stCustomBanner = qzmallCustomBanner;
        this.stAvatar = qzmallAvatar;
        this.stFloat = qzmallFloat;
        this.stFeedSkin = qzmallFeedSkin;
        this.stCustomVip = qzmallCustomVip;
        this.stFacade = qzmallFacade;
        this.stYellowDiamond = actYellowDiamond;
        this.stPolymorphicPraise = polymorphicPraise;
        this.stQbossData = dataForQboss;
        this.stFeedNavi = feedNavi;
        this.stFacadeDIY = facadeDIY;
        this.stCustomTrack = customTrackDeco;
        this.stCmShowQzoneTrack = userCmShowQzoneTrack;
    }
}
