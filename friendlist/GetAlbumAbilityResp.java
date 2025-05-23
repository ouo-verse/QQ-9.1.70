package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetAlbumAbilityResp extends JceStruct {
    static int cache_result;
    static ArrayList<stAlbumAbiInfo> cache_vecAlbumAbiUins;
    public int result;
    public long uin;
    public ArrayList<stAlbumAbiInfo> vecAlbumAbiUins;

    public GetAlbumAbilityResp() {
        this.uin = 0L;
        this.result = 0;
        this.vecAlbumAbiUins = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.result = jceInputStream.read(this.result, 1, true);
        if (cache_vecAlbumAbiUins == null) {
            cache_vecAlbumAbiUins = new ArrayList<>();
            cache_vecAlbumAbiUins.add(new stAlbumAbiInfo());
        }
        this.vecAlbumAbiUins = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAlbumAbiUins, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write((Collection) this.vecAlbumAbiUins, 2);
    }

    public GetAlbumAbilityResp(long j3, int i3, ArrayList<stAlbumAbiInfo> arrayList) {
        this.uin = j3;
        this.result = i3;
        this.vecAlbumAbiUins = arrayList;
    }
}
