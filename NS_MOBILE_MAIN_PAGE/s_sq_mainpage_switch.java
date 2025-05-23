package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_sq_mainpage_switch extends JceStruct {
    public boolean is_show_weishi;

    public s_sq_mainpage_switch() {
        this.is_show_weishi = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_show_weishi = jceInputStream.read(this.is_show_weishi, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_show_weishi, 0);
    }

    public s_sq_mainpage_switch(boolean z16) {
        this.is_show_weishi = z16;
    }
}
