package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAllBgMusicListRsp extends JceStruct {
    static ArrayList<MusicInfo> cache_all_music_list;
    public ArrayList<MusicInfo> all_music_list;
    public int all_music_nums;
    public byte green_diamond_flag;
    public boolean music_can_play;
    public byte play_mode_flag;
    public byte wifi_auto_play;

    public GetAllBgMusicListRsp() {
        this.music_can_play = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.green_diamond_flag = jceInputStream.read(this.green_diamond_flag, 0, false);
        this.music_can_play = jceInputStream.read(this.music_can_play, 1, false);
        this.all_music_nums = jceInputStream.read(this.all_music_nums, 2, false);
        if (cache_all_music_list == null) {
            cache_all_music_list = new ArrayList<>();
            cache_all_music_list.add(new MusicInfo());
        }
        this.all_music_list = (ArrayList) jceInputStream.read((JceInputStream) cache_all_music_list, 3, false);
        this.wifi_auto_play = jceInputStream.read(this.wifi_auto_play, 4, false);
        this.play_mode_flag = jceInputStream.read(this.play_mode_flag, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.green_diamond_flag, 0);
        jceOutputStream.write(this.music_can_play, 1);
        jceOutputStream.write(this.all_music_nums, 2);
        ArrayList<MusicInfo> arrayList = this.all_music_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.wifi_auto_play, 4);
        jceOutputStream.write(this.play_mode_flag, 5);
    }

    public GetAllBgMusicListRsp(byte b16, boolean z16, int i3, ArrayList<MusicInfo> arrayList, byte b17, byte b18) {
        this.green_diamond_flag = b16;
        this.music_can_play = z16;
        this.all_music_nums = i3;
        this.all_music_list = arrayList;
        this.wifi_auto_play = b17;
        this.play_mode_flag = b18;
    }
}
