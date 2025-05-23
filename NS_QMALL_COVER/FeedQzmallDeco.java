package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedQzmallDeco extends JceStruct {
    public QzmallCustomBubbleSkin stBubbleSkin;
    public QzmallCustomPassivePraise stCustomPassivePraise;
    public QzmallCustomPraise stCustomPraise;
    public QzmallCustomVip stCustomVip;
    public QzmallFacade stFacade;
    public FacadeDIY stFacadeDIY;
    public QzmallFeedAvatar stFeedAvatar;
    public QzmallFeedSkin stFeedSkin;
    public QzoneDescription stQzDescription;
    public ReturnToPraise stReturnToPraise;
    public ActYellowDiamond stYellowDiamond;
    static QzmallFeedAvatar cache_stFeedAvatar = new QzmallFeedAvatar();
    static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
    static QzmallCustomPassivePraise cache_stCustomPassivePraise = new QzmallCustomPassivePraise();
    static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
    static QzmallFeedSkin cache_stFeedSkin = new QzmallFeedSkin();
    static QzmallFacade cache_stFacade = new QzmallFacade();
    static QzmallCustomBubbleSkin cache_stBubbleSkin = new QzmallCustomBubbleSkin();
    static ActYellowDiamond cache_stYellowDiamond = new ActYellowDiamond();
    static ReturnToPraise cache_stReturnToPraise = new ReturnToPraise();
    static FacadeDIY cache_stFacadeDIY = new FacadeDIY();
    static QzoneDescription cache_stQzDescription = new QzoneDescription();

    public FeedQzmallDeco() {
        this.stFeedAvatar = null;
        this.stCustomVip = null;
        this.stCustomPassivePraise = null;
        this.stCustomPraise = null;
        this.stFeedSkin = null;
        this.stFacade = null;
        this.stBubbleSkin = null;
        this.stYellowDiamond = null;
        this.stReturnToPraise = null;
        this.stFacadeDIY = null;
        this.stQzDescription = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFeedAvatar = (QzmallFeedAvatar) jceInputStream.read((JceStruct) cache_stFeedAvatar, 0, false);
        this.stCustomVip = (QzmallCustomVip) jceInputStream.read((JceStruct) cache_stCustomVip, 1, false);
        this.stCustomPassivePraise = (QzmallCustomPassivePraise) jceInputStream.read((JceStruct) cache_stCustomPassivePraise, 2, false);
        this.stCustomPraise = (QzmallCustomPraise) jceInputStream.read((JceStruct) cache_stCustomPraise, 3, false);
        this.stFeedSkin = (QzmallFeedSkin) jceInputStream.read((JceStruct) cache_stFeedSkin, 4, false);
        this.stFacade = (QzmallFacade) jceInputStream.read((JceStruct) cache_stFacade, 5, false);
        this.stBubbleSkin = (QzmallCustomBubbleSkin) jceInputStream.read((JceStruct) cache_stBubbleSkin, 6, false);
        this.stYellowDiamond = (ActYellowDiamond) jceInputStream.read((JceStruct) cache_stYellowDiamond, 7, false);
        this.stReturnToPraise = (ReturnToPraise) jceInputStream.read((JceStruct) cache_stReturnToPraise, 8, false);
        this.stFacadeDIY = (FacadeDIY) jceInputStream.read((JceStruct) cache_stFacadeDIY, 9, false);
        this.stQzDescription = (QzoneDescription) jceInputStream.read((JceStruct) cache_stQzDescription, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        QzmallFeedAvatar qzmallFeedAvatar = this.stFeedAvatar;
        if (qzmallFeedAvatar != null) {
            jceOutputStream.write((JceStruct) qzmallFeedAvatar, 0);
        }
        QzmallCustomVip qzmallCustomVip = this.stCustomVip;
        if (qzmallCustomVip != null) {
            jceOutputStream.write((JceStruct) qzmallCustomVip, 1);
        }
        QzmallCustomPassivePraise qzmallCustomPassivePraise = this.stCustomPassivePraise;
        if (qzmallCustomPassivePraise != null) {
            jceOutputStream.write((JceStruct) qzmallCustomPassivePraise, 2);
        }
        QzmallCustomPraise qzmallCustomPraise = this.stCustomPraise;
        if (qzmallCustomPraise != null) {
            jceOutputStream.write((JceStruct) qzmallCustomPraise, 3);
        }
        QzmallFeedSkin qzmallFeedSkin = this.stFeedSkin;
        if (qzmallFeedSkin != null) {
            jceOutputStream.write((JceStruct) qzmallFeedSkin, 4);
        }
        QzmallFacade qzmallFacade = this.stFacade;
        if (qzmallFacade != null) {
            jceOutputStream.write((JceStruct) qzmallFacade, 5);
        }
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin = this.stBubbleSkin;
        if (qzmallCustomBubbleSkin != null) {
            jceOutputStream.write((JceStruct) qzmallCustomBubbleSkin, 6);
        }
        ActYellowDiamond actYellowDiamond = this.stYellowDiamond;
        if (actYellowDiamond != null) {
            jceOutputStream.write((JceStruct) actYellowDiamond, 7);
        }
        ReturnToPraise returnToPraise = this.stReturnToPraise;
        if (returnToPraise != null) {
            jceOutputStream.write((JceStruct) returnToPraise, 8);
        }
        FacadeDIY facadeDIY = this.stFacadeDIY;
        if (facadeDIY != null) {
            jceOutputStream.write((JceStruct) facadeDIY, 9);
        }
        QzoneDescription qzoneDescription = this.stQzDescription;
        if (qzoneDescription != null) {
            jceOutputStream.write((JceStruct) qzoneDescription, 10);
        }
    }

    public FeedQzmallDeco(QzmallFeedAvatar qzmallFeedAvatar, QzmallCustomVip qzmallCustomVip, QzmallCustomPassivePraise qzmallCustomPassivePraise, QzmallCustomPraise qzmallCustomPraise, QzmallFeedSkin qzmallFeedSkin, QzmallFacade qzmallFacade, QzmallCustomBubbleSkin qzmallCustomBubbleSkin, ActYellowDiamond actYellowDiamond, ReturnToPraise returnToPraise, FacadeDIY facadeDIY, QzoneDescription qzoneDescription) {
        this.stFeedAvatar = qzmallFeedAvatar;
        this.stCustomVip = qzmallCustomVip;
        this.stCustomPassivePraise = qzmallCustomPassivePraise;
        this.stCustomPraise = qzmallCustomPraise;
        this.stFeedSkin = qzmallFeedSkin;
        this.stFacade = qzmallFacade;
        this.stBubbleSkin = qzmallCustomBubbleSkin;
        this.stYellowDiamond = actYellowDiamond;
        this.stReturnToPraise = returnToPraise;
        this.stFacadeDIY = facadeDIY;
        this.stQzDescription = qzoneDescription;
    }
}
