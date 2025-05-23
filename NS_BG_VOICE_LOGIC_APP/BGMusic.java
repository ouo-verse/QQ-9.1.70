package NS_BG_VOICE_LOGIC_APP;

import NS_MOBILE_MUSIC.MusicInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BGMusic extends JceStruct {
    static ArrayList<MusicInfo> cache_all_music_list = new ArrayList<>();
    public ArrayList<MusicInfo> all_music_list;
    public int all_music_nums;
    public byte green_diamond_flag;
    public boolean music_can_play;

    static {
        cache_all_music_list.add(new MusicInfo());
    }

    public BGMusic() {
        this.green_diamond_flag = (byte) 0;
        this.music_can_play = true;
        this.all_music_nums = 0;
        this.all_music_list = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.green_diamond_flag = jceInputStream.read(this.green_diamond_flag, 1, false);
        this.music_can_play = jceInputStream.read(this.music_can_play, 2, false);
        this.all_music_nums = jceInputStream.read(this.all_music_nums, 3, false);
        this.all_music_list = (ArrayList) jceInputStream.read((JceInputStream) cache_all_music_list, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.green_diamond_flag, 1);
        jceOutputStream.write(this.music_can_play, 2);
        jceOutputStream.write(this.all_music_nums, 3);
        ArrayList<MusicInfo> arrayList = this.all_music_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
    }

    public BGMusic(byte b16, boolean z16, int i3, ArrayList<MusicInfo> arrayList) {
        this.green_diamond_flag = b16;
        this.music_can_play = z16;
        this.all_music_nums = i3;
        this.all_music_list = arrayList;
    }
}
