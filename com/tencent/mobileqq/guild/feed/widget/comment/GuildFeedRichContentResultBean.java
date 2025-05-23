package com.tencent.mobileqq.guild.feed.widget.comment;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.util.ax;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedRichContentResultBean implements Serializable {
    public Object ext;

    @SerializedName("contents")
    public List<RichContent> contents = new ArrayList();

    @SerializedName("images")
    public List<ImageContent> images = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class AtUser implements Serializable {

        @SerializedName("guild_info")
        public GuildInfo guildInfo;

        @SerializedName("role_group_id")
        public RoleInfo roleInfo;

        @SerializedName("type")
        private int type;

        @SerializedName(QCircleAlphaUserReporter.KEY_USER)
        public User user;

        public AtUser(int i3, String str, String str2, RoleInfo roleInfo) {
            this.type = i3;
            if (i3 != 3 && i3 != 4) {
                if (i3 == 2) {
                    this.roleInfo = roleInfo;
                }
            } else {
                this.guildInfo = new GuildInfo(str2);
            }
            this.user = new User(str, str2);
        }

        public int getType() {
            return this.type;
        }

        public User getUser() {
            return this.user;
        }

        public String toString() {
            return "{type:" + this.type + ", user:" + this.user + "},";
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class EmojiContent implements Serializable {

        /* renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        public String f224299id;

        @SerializedName("type")
        public String type = "1";

        public EmojiContent(String str) {
            this.f224299id = str;
        }

        public String getId() {
            return this.f224299id;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class GuildInfo implements Serializable {

        @SerializedName("guild_id")
        public long guildId;

        @SerializedName("name")
        public String name;

        public GuildInfo(String str) {
            this.name = str;
        }

        public String toString() {
            return "{guildId:" + this.guildId + ", name:" + this.name + "},";
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class ImageContent implements Serializable {

        @SerializedName("height")
        public int height;

        @SerializedName("imageMD5")
        public String imageMD5;

        @SerializedName("is_gif")
        public boolean isGif;

        @SerializedName("is_orig")
        public boolean isOrig;

        @SerializedName("orig_size")
        public long origSize;

        @SerializedName("picUrl")
        public String picUrl;

        @SerializedName("width")
        public int width;
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class RichAtContent extends RichContent {

        @SerializedName("at_content")
        private AtUser mUser;

        public RichAtContent(int i3, String str, String str2, RoleInfo roleInfo) {
            this.type = 2;
            this.mUser = new AtUser(i3, str, str2, roleInfo);
        }

        public AtUser getUser() {
            return this.mUser;
        }

        @Override // com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean.RichContent
        public String toString() {
            return "{at_content:" + this.mUser + "},";
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class RichContent implements Serializable {

        @SerializedName("type")
        protected int type;

        public int getType() {
            return this.type;
        }

        public String toString() {
            return "{type:" + this.type + "},";
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class RichEmojiContent extends RichContent {

        @SerializedName("emoji_content")
        private EmojiContent emojiContent;

        public RichEmojiContent(String str) {
            this.type = 4;
            this.emojiContent = new EmojiContent(str);
        }

        public EmojiContent getEmojiContent() {
            return this.emojiContent;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class RichTextContent extends RichContent {

        @SerializedName("text_content")
        protected Text content;

        public RichTextContent(String str) {
            this.type = 1;
            this.content = new Text(str);
        }

        public Text getContent() {
            return this.content;
        }

        @Override // com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean.RichContent
        public String toString() {
            return "{text_content:" + this.content + "},";
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class RoleInfo implements Serializable {

        @SerializedName("color")
        public long color;

        @SerializedName("name")
        public String name;

        @SerializedName("role_id")
        public String roleId;

        public RoleInfo(String str, String str2, long j3) {
            this.roleId = str;
            this.name = str2;
            this.color = j3;
        }

        public String toString() {
            return "{role_id:" + this.roleId + ", name:" + this.name + ", color: " + this.color + "},";
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class Text implements Serializable {

        @SerializedName("text")
        private String mText;

        public Text(String str) {
            this.mText = str;
        }

        public String getText() {
            return this.mText;
        }

        public String toString() {
            return this.mText;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class User implements Serializable {

        @SerializedName("id")
        private String mUserId;

        @SerializedName("nick")
        private String mUserNick;

        public User(String str, String str2) {
            this.mUserId = str;
            this.mUserNick = str2;
        }

        public String getUserId() {
            return this.mUserId;
        }

        public String getUserNick() {
            return this.mUserNick;
        }

        public String toString() {
            return "{id:" + this.mUserId + ", nick:" + this.mUserNick + "},";
        }
    }

    public void addAtContent(int i3, String str, String str2, RoleInfo roleInfo) {
        this.contents.add(new RichAtContent(i3, str, str2, roleInfo));
    }

    public void addAtNums(int i3, int i16, int i17) {
        this.ext = ax.n(i3, i16, i17);
    }

    public void addContent(RichContent richContent) {
        this.contents.add(richContent);
    }

    public void addEmojiContent(String str) {
        this.contents.add(new RichEmojiContent(str));
    }

    public void addImageContent(ImageContent imageContent) {
        this.images.add(imageContent);
    }

    public void addTextContent(String str) {
        this.contents.add(new RichTextContent(str));
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("[");
        Iterator<RichContent> it = this.contents.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toString());
            sb5.append(',');
        }
        sb5.append("],");
        return sb5.toString();
    }
}
