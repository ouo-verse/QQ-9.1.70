package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class MarkFaceInPhotoReq extends JceStruct {
    static MarkFaceItemFeed cache_feed_face_info = new MarkFaceItemFeed();
    static MarkFaceItemMood cache_mood_face_info = new MarkFaceItemMood();
    static int cache_scene;
    public MarkFaceItemFeed feed_face_info;
    public MarkFaceItemMood mood_face_info;
    public long owner;
    public int scene;

    public MarkFaceInPhotoReq() {
        this.owner = 0L;
        this.scene = 0;
        this.feed_face_info = null;
        this.mood_face_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.owner = jceInputStream.read(this.owner, 0, false);
        this.scene = jceInputStream.read(this.scene, 1, false);
        this.feed_face_info = (MarkFaceItemFeed) jceInputStream.read((JceStruct) cache_feed_face_info, 2, false);
        this.mood_face_info = (MarkFaceItemMood) jceInputStream.read((JceStruct) cache_mood_face_info, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.owner, 0);
        jceOutputStream.write(this.scene, 1);
        MarkFaceItemFeed markFaceItemFeed = this.feed_face_info;
        if (markFaceItemFeed != null) {
            jceOutputStream.write((JceStruct) markFaceItemFeed, 2);
        }
        MarkFaceItemMood markFaceItemMood = this.mood_face_info;
        if (markFaceItemMood != null) {
            jceOutputStream.write((JceStruct) markFaceItemMood, 3);
        }
    }

    public MarkFaceInPhotoReq(long j3, int i3, MarkFaceItemFeed markFaceItemFeed, MarkFaceItemMood markFaceItemMood) {
        this.owner = j3;
        this.scene = i3;
        this.feed_face_info = markFaceItemFeed;
        this.mood_face_info = markFaceItemMood;
    }
}
