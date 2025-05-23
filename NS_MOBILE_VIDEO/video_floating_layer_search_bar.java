package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class video_floating_layer_search_bar extends JceStruct {
    public String history_jump_url;
    public String hot_word;
    public String hot_word_jump_url;
    public String video_play_history_description;

    public video_floating_layer_search_bar() {
        this.hot_word = "";
        this.hot_word_jump_url = "";
        this.video_play_history_description = "";
        this.history_jump_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hot_word = jceInputStream.readString(0, false);
        this.hot_word_jump_url = jceInputStream.readString(1, false);
        this.video_play_history_description = jceInputStream.readString(3, false);
        this.history_jump_url = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.hot_word;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.hot_word_jump_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.video_play_history_description;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.history_jump_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public video_floating_layer_search_bar(String str, String str2, String str3, String str4) {
        this.hot_word = str;
        this.hot_word_jump_url = str2;
        this.video_play_history_description = str3;
        this.history_jump_url = str4;
    }
}
