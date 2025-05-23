package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class quote_photo_universal_req extends JceStruct {
    static ArrayList<s_quote_photo_info> cache_photos;
    static quote_photo_dst cache_quote_dst;
    static quote_photo_src cache_quote_src;
    public ArrayList<s_quote_photo_info> photos;
    public quote_photo_dst quote_dst;
    public quote_photo_src quote_src;

    public quote_photo_universal_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_quote_src == null) {
            cache_quote_src = new quote_photo_src();
        }
        this.quote_src = (quote_photo_src) jceInputStream.read((JceStruct) cache_quote_src, 0, false);
        if (cache_quote_dst == null) {
            cache_quote_dst = new quote_photo_dst();
        }
        this.quote_dst = (quote_photo_dst) jceInputStream.read((JceStruct) cache_quote_dst, 1, false);
        if (cache_photos == null) {
            cache_photos = new ArrayList<>();
            cache_photos.add(new s_quote_photo_info());
        }
        this.photos = (ArrayList) jceInputStream.read((JceInputStream) cache_photos, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        quote_photo_src quote_photo_srcVar = this.quote_src;
        if (quote_photo_srcVar != null) {
            jceOutputStream.write((JceStruct) quote_photo_srcVar, 0);
        }
        quote_photo_dst quote_photo_dstVar = this.quote_dst;
        if (quote_photo_dstVar != null) {
            jceOutputStream.write((JceStruct) quote_photo_dstVar, 1);
        }
        ArrayList<s_quote_photo_info> arrayList = this.photos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public quote_photo_universal_req(quote_photo_src quote_photo_srcVar, quote_photo_dst quote_photo_dstVar, ArrayList<s_quote_photo_info> arrayList) {
        this.quote_src = quote_photo_srcVar;
        this.quote_dst = quote_photo_dstVar;
        this.photos = arrayList;
    }
}
