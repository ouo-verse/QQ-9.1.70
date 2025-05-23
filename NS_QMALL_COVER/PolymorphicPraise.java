package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PolymorphicPraise extends JceStruct {
    static EmotionPraise cache_stOperationPraise;
    static ArrayList<EmotionPraise> cache_vecEmotionPraise = new ArrayList<>();
    public int iGuideToUse;
    public int iItemId;
    public EmotionPraise stOperationPraise;
    public ArrayList<EmotionPraise> vecEmotionPraise;

    static {
        cache_vecEmotionPraise.add(new EmotionPraise());
        cache_stOperationPraise = new EmotionPraise();
    }

    public PolymorphicPraise() {
        this.iItemId = -1;
        this.vecEmotionPraise = null;
        this.stOperationPraise = null;
        this.iGuideToUse = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.vecEmotionPraise = (ArrayList) jceInputStream.read((JceInputStream) cache_vecEmotionPraise, 1, false);
        this.stOperationPraise = (EmotionPraise) jceInputStream.read((JceStruct) cache_stOperationPraise, 2, false);
        this.iGuideToUse = jceInputStream.read(this.iGuideToUse, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        ArrayList<EmotionPraise> arrayList = this.vecEmotionPraise;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        EmotionPraise emotionPraise = this.stOperationPraise;
        if (emotionPraise != null) {
            jceOutputStream.write((JceStruct) emotionPraise, 2);
        }
        jceOutputStream.write(this.iGuideToUse, 3);
    }

    public PolymorphicPraise(int i3, ArrayList<EmotionPraise> arrayList, EmotionPraise emotionPraise, int i16) {
        this.iItemId = i3;
        this.vecEmotionPraise = arrayList;
        this.stOperationPraise = emotionPraise;
        this.iGuideToUse = i16;
    }
}
