package jn1;

import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e {

    @SerializedName("show")
    private boolean mShow;

    @SerializedName("showAt")
    private boolean mShowAt;

    @SerializedName("showEmoji")
    private boolean mShowEmoji;

    @SerializedName("showFontStyleSetting")
    private boolean mShowFontStyleSetting;

    @SerializedName("showLink")
    private boolean mShowLink;

    @SerializedName("showPhoto")
    private boolean mShowPhoto;

    @SerializedName("showRedo")
    private boolean mShowRedo;

    @SerializedName("showTag")
    private boolean mShowTag;

    @SerializedName("showVideoLink")
    private boolean showVideoLink;

    public boolean a() {
        return this.mShow;
    }

    public boolean b() {
        return this.mShowAt;
    }

    public boolean c() {
        return this.mShowEmoji;
    }

    public boolean d() {
        return this.mShowFontStyleSetting;
    }

    public boolean e() {
        return this.mShowLink;
    }

    public boolean f() {
        return this.mShowPhoto;
    }

    public boolean g() {
        return this.mShowRedo;
    }

    public boolean h() {
        return this.showVideoLink;
    }

    public String toString() {
        return "GuildShowToolsBarInfo{mShow=" + this.mShow + ", mShowTag=" + this.mShowTag + ", mShowAt=" + this.mShowAt + ", mShowLink=" + this.mShowLink + ", mShowEmoji=" + this.mShowEmoji + ", mShowPhoto=" + this.mShowPhoto + ", mShowFontStyleSetting=" + this.mShowFontStyleSetting + ", mShowRedo=" + this.mShowRedo + ", showVideoLink=" + this.showVideoLink + '}';
    }
}
