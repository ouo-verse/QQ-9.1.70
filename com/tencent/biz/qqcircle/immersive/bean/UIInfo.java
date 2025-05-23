package com.tencent.biz.qqcircle.immersive.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/bean/UIInfo;", "", "()V", "buttonText", "", "getButtonText", "()Ljava/lang/String;", "jumpInfoArray", "Ljava/util/ArrayList;", "Lcom/tencent/biz/qqcircle/immersive/bean/JumpInfo;", "Lkotlin/collections/ArrayList;", "getJumpInfoArray", "()Ljava/util/ArrayList;", "picUrl", "getPicUrl", "tag", "Lcom/tencent/biz/qqcircle/immersive/bean/Tag;", "getTag", "()Lcom/tencent/biz/qqcircle/immersive/bean/Tag;", "title", "getTitle", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class UIInfo {

    @NotNull
    private final String title = "";

    @SerializedName("pic_url")
    @NotNull
    private final String picUrl = "";

    @SerializedName(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT)
    @NotNull
    private final String buttonText = "";

    @SerializedName("jump_info")
    @NotNull
    private final ArrayList<JumpInfo> jumpInfoArray = new ArrayList<>();

    @NotNull
    private final Tag tag = new Tag();

    @NotNull
    public final String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    public final ArrayList<JumpInfo> getJumpInfoArray() {
        return this.jumpInfoArray;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final Tag getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
