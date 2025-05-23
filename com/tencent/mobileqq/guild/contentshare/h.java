package com.tencent.mobileqq.guild.contentshare;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/h;", "", "<init>", "()V", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/h$a;", "Lcom/tencent/mobileqq/guild/contentshare/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "d", "()I", "textColor", "b", "c", "replyLayoutResId", "", UserInfo.SEX_FEMALE, "()F", "msgContentMarginLeftRightDp", "atTextColor", "<init>", "(IIFI)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.contentshare.h$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class MsgContentStyle extends h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int textColor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int replyLayoutResId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final float msgContentMarginLeftRightDp;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int atTextColor;

        public MsgContentStyle(int i3, int i16, float f16, int i17) {
            this.textColor = i3;
            this.replyLayoutResId = i16;
            this.msgContentMarginLeftRightDp = f16;
            this.atTextColor = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getAtTextColor() {
            return this.atTextColor;
        }

        /* renamed from: b, reason: from getter */
        public final float getMsgContentMarginLeftRightDp() {
            return this.msgContentMarginLeftRightDp;
        }

        /* renamed from: c, reason: from getter */
        public final int getReplyLayoutResId() {
            return this.replyLayoutResId;
        }

        /* renamed from: d, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgContentStyle)) {
                return false;
            }
            MsgContentStyle msgContentStyle = (MsgContentStyle) other;
            if (this.textColor == msgContentStyle.textColor && this.replyLayoutResId == msgContentStyle.replyLayoutResId && Float.compare(this.msgContentMarginLeftRightDp, msgContentStyle.msgContentMarginLeftRightDp) == 0 && this.atTextColor == msgContentStyle.atTextColor) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.textColor * 31) + this.replyLayoutResId) * 31) + Float.floatToIntBits(this.msgContentMarginLeftRightDp)) * 31) + this.atTextColor;
        }

        @NotNull
        public String toString() {
            return "MsgContentStyle(textColor=" + this.textColor + ", replyLayoutResId=" + this.replyLayoutResId + ", msgContentMarginLeftRightDp=" + this.msgContentMarginLeftRightDp + ", atTextColor=" + this.atTextColor + ')';
        }
    }
}
