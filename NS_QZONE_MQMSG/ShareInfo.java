package NS_QZONE_MQMSG;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShareInfo extends JceStruct {
    static ShareCell cache_shareToFriend = new ShareCell();
    static ShareCell cache_shareToQzone = new ShareCell();
    static single_feed cache_single_feed_data = new single_feed();
    public ShareCell shareToFriend;
    public ShareCell shareToQzone;
    public single_feed single_feed_data;

    public ShareInfo() {
        this.shareToFriend = null;
        this.shareToQzone = null;
        this.single_feed_data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shareToFriend = (ShareCell) jceInputStream.read((JceStruct) cache_shareToFriend, 0, false);
        this.shareToQzone = (ShareCell) jceInputStream.read((JceStruct) cache_shareToQzone, 1, false);
        this.single_feed_data = (single_feed) jceInputStream.read((JceStruct) cache_single_feed_data, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ShareCell shareCell = this.shareToFriend;
        if (shareCell != null) {
            jceOutputStream.write((JceStruct) shareCell, 0);
        }
        ShareCell shareCell2 = this.shareToQzone;
        if (shareCell2 != null) {
            jceOutputStream.write((JceStruct) shareCell2, 1);
        }
        single_feed single_feedVar = this.single_feed_data;
        if (single_feedVar != null) {
            jceOutputStream.write((JceStruct) single_feedVar, 2);
        }
    }

    public ShareInfo(ShareCell shareCell, ShareCell shareCell2, single_feed single_feedVar) {
        this.shareToFriend = shareCell;
        this.shareToQzone = shareCell2;
        this.single_feed_data = single_feedVar;
    }
}
