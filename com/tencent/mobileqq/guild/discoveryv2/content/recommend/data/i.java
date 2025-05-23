package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/i;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "label", "", "g", "", "originString", "newString", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGuildData;", "data", "b", "", "I", "f", "()I", "setSgrpStatus", "(I)V", "sgrpStatus", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setSgrpRecallTag", "(Ljava/lang/String;)V", "sgrpRecallTag", "c", "setSgrpExplicitTag", "sgrpExplicitTag", "d", "setSgrpGameGiftTag", "sgrpGameGiftTag", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int sgrpStatus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sgrpRecallTag = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sgrpExplicitTag = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sgrpGameGiftTag = "";

    private final String a(String originString, String newString) {
        if (!TextUtils.isEmpty(originString)) {
            return originString + "," + newString;
        }
        return newString;
    }

    private final void g(IGProGuildLabel label) {
        byte[] labelName = label.getLabelName();
        Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
        String str = new String(labelName, Charsets.UTF_8);
        if (ci1.b.k(label.getLabelType())) {
            this.sgrpRecallTag = a(this.sgrpRecallTag, str);
        }
        if (ci1.b.n(label.getLabelType())) {
            this.sgrpExplicitTag = a(this.sgrpExplicitTag, str);
        }
    }

    public final void b(@NotNull RecommendGuildData data) {
        ArrayList<String> giftIconList;
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<IGProGuildLabel> tagList = data.getTagList();
        if (tagList.isEmpty()) {
            return;
        }
        boolean z16 = false;
        IGProGuildLabel firstTag = tagList.get(0);
        IGProGameGiftInfo giftInfo = data.getGiftInfo();
        if (giftInfo != null && (giftIconList = giftInfo.getGiftIconList()) != null && (!giftIconList.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            this.sgrpGameGiftTag = data.getGiftInfo().getGiftNum() + "\u4e2a\u793c\u5305\u5f85\u9886\u53d6";
        }
        if (ci1.b.m(firstTag.getLabelType())) {
            this.sgrpStatus = firstTag.getLabelType();
        }
        Intrinsics.checkNotNullExpressionValue(firstTag, "firstTag");
        g(firstTag);
        if (tagList.size() > 1) {
            IGProGuildLabel secondLabel = tagList.get(1);
            Intrinsics.checkNotNullExpressionValue(secondLabel, "secondLabel");
            g(secondLabel);
        }
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getSgrpExplicitTag() {
        return this.sgrpExplicitTag;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSgrpGameGiftTag() {
        return this.sgrpGameGiftTag;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSgrpRecallTag() {
        return this.sgrpRecallTag;
    }

    /* renamed from: f, reason: from getter */
    public final int getSgrpStatus() {
        return this.sgrpStatus;
    }
}
