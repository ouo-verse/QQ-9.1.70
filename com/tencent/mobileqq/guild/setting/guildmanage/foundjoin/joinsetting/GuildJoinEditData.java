package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestionItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildSetting;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestionItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestionItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildWordQuestionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0004B5\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010&\u001a\u0004\b\u001e\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/a;", "", "", "i", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildSetting;", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "originSetting", tl.h.F, "", "toString", "", "hashCode", "other", "equals", "I", "d", "()I", "k", "(I)V", "mOptionType", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "mQuestionWithAdminReview", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;", "f", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;)V", "mWordQuestion", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;", "j", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;)V", "mChoiceQuestion", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestion;Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestion;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildJoinEditData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int mOptionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String mQuestionWithAdminReview;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private GWGProJoinGuildWordQuestion mWordQuestion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private GWGProJoinGuildChoiceQuestion mChoiceQuestion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/a$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "originalSetting", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/a;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildJoinEditData a(@NotNull IGProJoinGuildSetting originalSetting) {
            Intrinsics.checkNotNullParameter(originalSetting, "originalSetting");
            GuildJoinEditData guildJoinEditData = new GuildJoinEditData(originalSetting.getOptionType(), null, null, null, 14, null);
            int optionType = originalSetting.getOptionType();
            if (optionType != 5) {
                if (optionType != 6) {
                    if (optionType == 7) {
                        GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion = new GWGProJoinGuildChoiceQuestion();
                        IGProJoinGuildChoiceQuestion choiceQuestion = originalSetting.getChoiceQuestion();
                        gWGProJoinGuildChoiceQuestion.setNeedAnswerNum(choiceQuestion.getNeedAnswerNum());
                        gWGProJoinGuildChoiceQuestion.setPassCorrectNum(choiceQuestion.getPassCorrectNum());
                        Iterator<IGProJoinGuildChoiceQuestionItem> it = choiceQuestion.getItems().iterator();
                        while (it.hasNext()) {
                            IGProJoinGuildChoiceQuestionItem next = it.next();
                            GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem = new GWGProJoinGuildChoiceQuestionItem();
                            gWGProJoinGuildChoiceQuestionItem.setQuestion(next.getQuestion());
                            gWGProJoinGuildChoiceQuestionItem.setAnswers(next.getAnswers());
                            gWGProJoinGuildChoiceQuestionItem.setCorrectAnswer(next.getCorrectAnswer());
                            gWGProJoinGuildChoiceQuestion.getItems().add(gWGProJoinGuildChoiceQuestionItem);
                        }
                        guildJoinEditData.j(gWGProJoinGuildChoiceQuestion);
                    }
                } else {
                    guildJoinEditData.m(new GWGProJoinGuildWordQuestion());
                    Iterator<IGProJoinGuildWordQuestionItem> it5 = originalSetting.getWordQuestion().getItems().iterator();
                    while (it5.hasNext()) {
                        IGProJoinGuildWordQuestionItem next2 = it5.next();
                        GWGProJoinGuildWordQuestionItem gWGProJoinGuildWordQuestionItem = new GWGProJoinGuildWordQuestionItem();
                        gWGProJoinGuildWordQuestionItem.setQuestion(next2.getQuestion());
                        gWGProJoinGuildWordQuestionItem.setCorrectAnswer(next2.getCorrectAnswer());
                        GWGProJoinGuildWordQuestion mWordQuestion = guildJoinEditData.getMWordQuestion();
                        Intrinsics.checkNotNull(mWordQuestion);
                        mWordQuestion.getItems().add(gWGProJoinGuildWordQuestionItem);
                    }
                }
            } else {
                guildJoinEditData.l(originalSetting.getWordQuestion().getItems().get(0).getQuestion());
            }
            return guildJoinEditData;
        }

        Companion() {
        }
    }

    @JvmOverloads
    public GuildJoinEditData(int i3) {
        this(i3, null, null, null, 14, null);
    }

    @JvmStatic
    @NotNull
    public static final GuildJoinEditData b(@NotNull IGProJoinGuildSetting iGProJoinGuildSetting) {
        return INSTANCE.a(iGProJoinGuildSetting);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if (r0 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        boolean isBlank;
        int i3 = this.mOptionType;
        boolean z16 = false;
        if (i3 == 5) {
            String str = this.mQuestionWithAdminReview;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
            }
            z16 = true;
            return !z16;
        }
        if (i3 == 6) {
            GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion = this.mWordQuestion;
            if (gWGProJoinGuildWordQuestion == null) {
                return false;
            }
            Intrinsics.checkNotNull(gWGProJoinGuildWordQuestion);
            Intrinsics.checkNotNullExpressionValue(gWGProJoinGuildWordQuestion.getItems(), "mWordQuestion!!.items");
            if (!(!r0.isEmpty())) {
                return false;
            }
            return true;
        }
        if (i3 != 7) {
            return true;
        }
        GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion = this.mChoiceQuestion;
        if (gWGProJoinGuildChoiceQuestion == null) {
            return false;
        }
        Intrinsics.checkNotNull(gWGProJoinGuildChoiceQuestion);
        Intrinsics.checkNotNullExpressionValue(gWGProJoinGuildChoiceQuestion.getItems(), "mChoiceQuestion!!.items");
        if (!(!r0.isEmpty())) {
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final GWGProJoinGuildChoiceQuestion getMChoiceQuestion() {
        return this.mChoiceQuestion;
    }

    /* renamed from: d, reason: from getter */
    public final int getMOptionType() {
        return this.mOptionType;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getMQuestionWithAdminReview() {
        return this.mQuestionWithAdminReview;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinEditData)) {
            return false;
        }
        GuildJoinEditData guildJoinEditData = (GuildJoinEditData) other;
        if (this.mOptionType == guildJoinEditData.mOptionType && Intrinsics.areEqual(this.mQuestionWithAdminReview, guildJoinEditData.mQuestionWithAdminReview) && Intrinsics.areEqual(this.mWordQuestion, guildJoinEditData.mWordQuestion) && Intrinsics.areEqual(this.mChoiceQuestion, guildJoinEditData.mChoiceQuestion)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final GWGProJoinGuildWordQuestion getMWordQuestion() {
        return this.mWordQuestion;
    }

    @NotNull
    public final GWGProJoinGuildSetting g() {
        int i3 = this.mOptionType;
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    GWGProJoinGuildSetting gWGProJoinGuildSetting = new GWGProJoinGuildSetting();
                    gWGProJoinGuildSetting.setOptionType(this.mOptionType);
                    return gWGProJoinGuildSetting;
                }
                GWGProJoinGuildSetting gWGProJoinGuildSetting2 = new GWGProJoinGuildSetting();
                gWGProJoinGuildSetting2.setOptionType(this.mOptionType);
                gWGProJoinGuildSetting2.setChoiceQuestion(this.mChoiceQuestion);
                return gWGProJoinGuildSetting2;
            }
            GWGProJoinGuildSetting gWGProJoinGuildSetting3 = new GWGProJoinGuildSetting();
            gWGProJoinGuildSetting3.setOptionType(this.mOptionType);
            gWGProJoinGuildSetting3.setWordQuestion(this.mWordQuestion);
            return gWGProJoinGuildSetting3;
        }
        GWGProJoinGuildSetting gWGProJoinGuildSetting4 = new GWGProJoinGuildSetting();
        gWGProJoinGuildSetting4.setOptionType(this.mOptionType);
        ArrayList<GWGProJoinGuildWordQuestionItem> items = gWGProJoinGuildSetting4.getWordQuestion().getItems();
        GWGProJoinGuildWordQuestionItem gWGProJoinGuildWordQuestionItem = new GWGProJoinGuildWordQuestionItem();
        gWGProJoinGuildWordQuestionItem.setQuestion(this.mQuestionWithAdminReview);
        Unit unit = Unit.INSTANCE;
        items.add(0, gWGProJoinGuildWordQuestionItem);
        return gWGProJoinGuildSetting4;
    }

    public final boolean h(@NotNull IGProJoinGuildSetting originSetting) {
        Intrinsics.checkNotNullParameter(originSetting, "originSetting");
        if (originSetting.getOptionType() != this.mOptionType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i3 = this.mOptionType * 31;
        String str = this.mQuestionWithAdminReview;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion = this.mWordQuestion;
        if (gWGProJoinGuildWordQuestion == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = gWGProJoinGuildWordQuestion.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion = this.mChoiceQuestion;
        if (gWGProJoinGuildChoiceQuestion != null) {
            i16 = gWGProJoinGuildChoiceQuestion.hashCode();
        }
        return i18 + i16;
    }

    public final boolean i() {
        Set of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{2, 5, 6, 7});
        return of5.contains(Integer.valueOf(this.mOptionType));
    }

    public final void j(@Nullable GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion) {
        this.mChoiceQuestion = gWGProJoinGuildChoiceQuestion;
    }

    public final void k(int i3) {
        this.mOptionType = i3;
    }

    public final void l(@Nullable String str) {
        this.mQuestionWithAdminReview = str;
    }

    public final void m(@Nullable GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion) {
        this.mWordQuestion = gWGProJoinGuildWordQuestion;
    }

    @NotNull
    public String toString() {
        return "GuildJoinEditData(mOptionType=" + this.mOptionType + ", mQuestionWithAdminReview=" + this.mQuestionWithAdminReview + ", mWordQuestion=" + this.mWordQuestion + ", mChoiceQuestion=" + this.mChoiceQuestion + ")";
    }

    @JvmOverloads
    public GuildJoinEditData(int i3, @Nullable String str, @Nullable GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion, @Nullable GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion) {
        this.mOptionType = i3;
        this.mQuestionWithAdminReview = str;
        this.mWordQuestion = gWGProJoinGuildWordQuestion;
        this.mChoiceQuestion = gWGProJoinGuildChoiceQuestion;
    }

    public /* synthetic */ GuildJoinEditData(int i3, String str, GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion, GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : gWGProJoinGuildWordQuestion, (i16 & 8) != 0 ? null : gWGProJoinGuildChoiceQuestion);
    }
}
