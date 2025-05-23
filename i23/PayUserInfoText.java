package i23;

import android.text.SpannableString;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001d\u00a8\u0006 "}, d2 = {"Li23/e;", "", "", "a", "", "countDown", "", h.F, "toString", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "payText", "b", "c", "payMarkText", "Landroid/text/SpannableString;", "Landroid/text/SpannableString;", "f", "()Landroid/text/SpannableString;", "statusTitle", "e", "statusSubtitle", "", "Z", "g", "()Z", "isCountDownGetExperience", "getExperienceQualificationText", "J", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/text/SpannableString;Landroid/text/SpannableString;ZLjava/lang/String;J)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: i23.e, reason: from toString */
/* loaded from: classes20.dex */
public final class PayUserInfoText {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String payText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String payMarkText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SpannableString statusTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SpannableString statusSubtitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCountDownGetExperience;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String getExperienceQualificationText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long countDown;

    public PayUserInfoText(@NotNull String payText, @NotNull String payMarkText, @NotNull SpannableString statusTitle, @NotNull SpannableString statusSubtitle, boolean z16, @NotNull String getExperienceQualificationText, long j3) {
        Intrinsics.checkNotNullParameter(payText, "payText");
        Intrinsics.checkNotNullParameter(payMarkText, "payMarkText");
        Intrinsics.checkNotNullParameter(statusTitle, "statusTitle");
        Intrinsics.checkNotNullParameter(statusSubtitle, "statusSubtitle");
        Intrinsics.checkNotNullParameter(getExperienceQualificationText, "getExperienceQualificationText");
        this.payText = payText;
        this.payMarkText = payMarkText;
        this.statusTitle = statusTitle;
        this.statusSubtitle = statusSubtitle;
        this.isCountDownGetExperience = z16;
        this.getExperienceQualificationText = getExperienceQualificationText;
        this.countDown = j3;
    }

    @NotNull
    public final String a() {
        return this.countDown + BaseApplication.context.getString(R.string.f2172960m);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGetExperienceQualificationText() {
        return this.getExperienceQualificationText;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPayMarkText() {
        return this.payMarkText;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPayText() {
        return this.payText;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final SpannableString getStatusSubtitle() {
        return this.statusSubtitle;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final SpannableString getStatusTitle() {
        return this.statusTitle;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsCountDownGetExperience() {
        return this.isCountDownGetExperience;
    }

    public final void h(long countDown) {
        this.countDown = countDown;
    }

    @NotNull
    public String toString() {
        String str = this.payText;
        String str2 = this.payMarkText;
        SpannableString spannableString = this.statusTitle;
        SpannableString spannableString2 = this.statusSubtitle;
        return "PayUserInfoText(payText='" + str + "', payMarkText='" + str2 + "', statusTitle=" + ((Object) spannableString) + ", statusSubtitle=" + ((Object) spannableString2) + ", isCountDownGetExperience=" + this.isCountDownGetExperience + ", getExperienceQualificationText='" + this.getExperienceQualificationText + "', countDown=" + this.countDown + ")";
    }
}
