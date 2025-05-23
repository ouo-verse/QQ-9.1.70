package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_anti_cheat extends JceStruct {
    public int click_interval;
    public int down_delay;
    public int drag_flag;
    public int play_time;
    public s_coordinate pop_posi;
    public s_coordinate push_posi;
    public int switch_flag;
    public int up_delay;
    static s_coordinate cache_push_posi = new s_coordinate();
    static s_coordinate cache_pop_posi = new s_coordinate();

    public s_anti_cheat() {
        this.push_posi = null;
        this.pop_posi = null;
        this.click_interval = -999;
        this.play_time = -999;
        this.down_delay = -999;
        this.up_delay = -999;
        this.drag_flag = 0;
        this.switch_flag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.push_posi = (s_coordinate) jceInputStream.read((JceStruct) cache_push_posi, 0, false);
        this.pop_posi = (s_coordinate) jceInputStream.read((JceStruct) cache_pop_posi, 1, false);
        this.click_interval = jceInputStream.read(this.click_interval, 2, false);
        this.play_time = jceInputStream.read(this.play_time, 3, false);
        this.down_delay = jceInputStream.read(this.down_delay, 4, false);
        this.up_delay = jceInputStream.read(this.up_delay, 5, false);
        this.drag_flag = jceInputStream.read(this.drag_flag, 6, false);
        this.switch_flag = jceInputStream.read(this.switch_flag, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_coordinate s_coordinateVar = this.push_posi;
        if (s_coordinateVar != null) {
            jceOutputStream.write((JceStruct) s_coordinateVar, 0);
        }
        s_coordinate s_coordinateVar2 = this.pop_posi;
        if (s_coordinateVar2 != null) {
            jceOutputStream.write((JceStruct) s_coordinateVar2, 1);
        }
        jceOutputStream.write(this.click_interval, 2);
        jceOutputStream.write(this.play_time, 3);
        jceOutputStream.write(this.down_delay, 4);
        jceOutputStream.write(this.up_delay, 5);
        jceOutputStream.write(this.drag_flag, 6);
        jceOutputStream.write(this.switch_flag, 7);
    }

    public s_anti_cheat(s_coordinate s_coordinateVar, s_coordinate s_coordinateVar2, int i3, int i16, int i17, int i18, int i19, int i26) {
        this.push_posi = s_coordinateVar;
        this.pop_posi = s_coordinateVar2;
        this.click_interval = i3;
        this.play_time = i16;
        this.down_delay = i17;
        this.up_delay = i18;
        this.drag_flag = i19;
        this.switch_flag = i26;
    }
}
