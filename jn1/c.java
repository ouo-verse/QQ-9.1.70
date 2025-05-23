package jn1;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c {

    @SerializedName("align")
    private Integer mAlign;

    @SerializedName("style")
    private List<Integer> mStyle;

    public Integer a() {
        return this.mAlign;
    }

    public List<Integer> b() {
        return this.mStyle;
    }

    public void c(Integer num) {
        this.mAlign = num;
    }

    public void d(List<Integer> list) {
        this.mStyle = list;
    }

    public String toString() {
        return "GuildSetFontStyleInfo{mStyle=" + this.mStyle + ", mAlign=" + this.mAlign + '}';
    }
}
