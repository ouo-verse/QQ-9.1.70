package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MediaInfo extends JceStruct {
    static ArrayList<AudioInfo> cache_audioinfo;
    static ArrayList<PicInfo> cache_picinfolist;
    static VedioInfo cache_vedioinfo;
    public ArrayList<AudioInfo> audioinfo;
    public ArrayList<PicInfo> picinfolist;
    public VedioInfo vedioinfo;

    public MediaInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_picinfolist == null) {
            cache_picinfolist = new ArrayList<>();
            cache_picinfolist.add(new PicInfo());
        }
        this.picinfolist = (ArrayList) jceInputStream.read((JceInputStream) cache_picinfolist, 0, false);
        if (cache_vedioinfo == null) {
            cache_vedioinfo = new VedioInfo();
        }
        this.vedioinfo = (VedioInfo) jceInputStream.read((JceStruct) cache_vedioinfo, 1, false);
        if (cache_audioinfo == null) {
            cache_audioinfo = new ArrayList<>();
            cache_audioinfo.add(new AudioInfo());
        }
        this.audioinfo = (ArrayList) jceInputStream.read((JceInputStream) cache_audioinfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PicInfo> arrayList = this.picinfolist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        VedioInfo vedioInfo = this.vedioinfo;
        if (vedioInfo != null) {
            jceOutputStream.write((JceStruct) vedioInfo, 1);
        }
        ArrayList<AudioInfo> arrayList2 = this.audioinfo;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public MediaInfo(ArrayList<PicInfo> arrayList, VedioInfo vedioInfo, ArrayList<AudioInfo> arrayList2) {
        this.picinfolist = arrayList;
        this.vedioinfo = vedioInfo;
        this.audioinfo = arrayList2;
    }
}
