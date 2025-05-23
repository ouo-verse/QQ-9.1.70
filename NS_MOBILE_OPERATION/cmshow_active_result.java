package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cmshow_active_result extends JceStruct {
    public int cm_cardli_count;
    public int cm_stone_count;
    public int fire_score;
    public byte is_reach_friend_limit;
    public byte is_reach_limit;

    public cmshow_active_result() {
        this.fire_score = 0;
        this.cm_stone_count = 0;
        this.is_reach_limit = (byte) 0;
        this.cm_cardli_count = 0;
        this.is_reach_friend_limit = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fire_score = jceInputStream.read(this.fire_score, 1, false);
        this.cm_stone_count = jceInputStream.read(this.cm_stone_count, 2, false);
        this.is_reach_limit = jceInputStream.read(this.is_reach_limit, 3, false);
        this.cm_cardli_count = jceInputStream.read(this.cm_cardli_count, 4, false);
        this.is_reach_friend_limit = jceInputStream.read(this.is_reach_friend_limit, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fire_score, 1);
        jceOutputStream.write(this.cm_stone_count, 2);
        jceOutputStream.write(this.is_reach_limit, 3);
        jceOutputStream.write(this.cm_cardli_count, 4);
        jceOutputStream.write(this.is_reach_friend_limit, 5);
    }

    public cmshow_active_result(int i3, int i16, byte b16, int i17, byte b17) {
        this.fire_score = i3;
        this.cm_stone_count = i16;
        this.is_reach_limit = b16;
        this.cm_cardli_count = i17;
        this.is_reach_friend_limit = b17;
    }
}
