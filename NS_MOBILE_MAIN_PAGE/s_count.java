package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_count extends JceStruct {
    public int blog_allnum;
    public int message_allnum;
    public int pic_allnum;
    public int qz_house_num;
    public int shuoshuo_allnum;

    public s_count() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pic_allnum = jceInputStream.read(this.pic_allnum, 0, false);
        this.blog_allnum = jceInputStream.read(this.blog_allnum, 1, false);
        this.shuoshuo_allnum = jceInputStream.read(this.shuoshuo_allnum, 2, false);
        this.message_allnum = jceInputStream.read(this.message_allnum, 3, false);
        this.qz_house_num = jceInputStream.read(this.qz_house_num, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.pic_allnum, 0);
        jceOutputStream.write(this.blog_allnum, 1);
        jceOutputStream.write(this.shuoshuo_allnum, 2);
        jceOutputStream.write(this.message_allnum, 3);
        jceOutputStream.write(this.qz_house_num, 4);
    }

    public s_count(int i3, int i16, int i17, int i18, int i19) {
        this.pic_allnum = i3;
        this.blog_allnum = i16;
        this.shuoshuo_allnum = i17;
        this.message_allnum = i18;
        this.qz_house_num = i19;
    }
}
