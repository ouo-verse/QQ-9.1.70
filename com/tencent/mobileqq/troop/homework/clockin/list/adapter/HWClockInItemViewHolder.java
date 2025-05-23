package com.tencent.mobileqq.troop.homework.clockin.list.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/adapter/HWClockInItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "textView", "", "keyStr", "contentStr", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/clockin/list/data/a;", "clockInData", "l", "E", "Landroid/widget/TextView;", "title", UserInfo.SEX_FEMALE, "content", "G", "clockInDays", "H", "clockInFrequency", "I", "publishClassName", "J", "publishTime", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "ClockInfoDescKey", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInItemViewHolder extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView title;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView content;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private TextView clockInDays;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private TextView clockInFrequency;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TextView publishClassName;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private TextView publishTime;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/adapter/HWClockInItemViewHolder$ClockInfoDescKey;", "", "descStr", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescStr", "()Ljava/lang/String;", "CLICK_IN_DAYS", "PUBLISH_CLASS", "CLOCK_IN_FREQUENCY", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class ClockInfoDescKey {
        private static final /* synthetic */ ClockInfoDescKey[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ClockInfoDescKey CLICK_IN_DAYS;
        public static final ClockInfoDescKey CLOCK_IN_FREQUENCY;
        public static final ClockInfoDescKey PUBLISH_CLASS;

        @NotNull
        private final String descStr;

        private static final /* synthetic */ ClockInfoDescKey[] $values() {
            return new ClockInfoDescKey[]{CLICK_IN_DAYS, PUBLISH_CLASS, CLOCK_IN_FREQUENCY};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43068);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            CLICK_IN_DAYS = new ClockInfoDescKey("CLICK_IN_DAYS", 0, "\u6253\u5361\u5df2\u8fdb\u884c\uff1a");
            PUBLISH_CLASS = new ClockInfoDescKey("PUBLISH_CLASS", 1, "\u53d1\u5e03\u73ed\u7ea7\uff1a");
            CLOCK_IN_FREQUENCY = new ClockInfoDescKey("CLOCK_IN_FREQUENCY", 2, "\u6253\u5361\u9891\u6b21\uff1a");
            $VALUES = $values();
        }

        ClockInfoDescKey(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.descStr = str2;
            }
        }

        public static ClockInfoDescKey valueOf(String str) {
            return (ClockInfoDescKey) Enum.valueOf(ClockInfoDescKey.class, str);
        }

        public static ClockInfoDescKey[] values() {
            return (ClockInfoDescKey[]) $VALUES.clone();
        }

        @NotNull
        public final String getDescStr() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.descStr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInItemViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.f164818tz1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.clock_in_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.tyq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.clock_in_content)");
        this.content = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.tyr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.clock_in_days)");
        this.clockInDays = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.tys);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.clock_in_frequency)");
        this.clockInFrequency = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.tyu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.clock_in_publish_class)");
        this.publishClassName = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.tyv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.clock_in_publish_time)");
        this.publishTime = (TextView) findViewById6;
    }

    private final void m(TextView textView, String keyStr, String contentStr) {
        Context context = textView.getContext();
        SpannableString spannableString = new SpannableString(keyStr + contentStr);
        spannableString.setSpan(new ForegroundColorSpan(context.getColor(R.color.qui_common_text_secondary)), 0, keyStr.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(context.getColor(R.color.qui_common_text_primary)), keyStr.length(), spannableString.length(), 33);
        textView.setText(spannableString);
    }

    public final void l(@NotNull com.tencent.mobileqq.troop.homework.clockin.list.data.a clockInData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) clockInData);
            return;
        }
        Intrinsics.checkNotNullParameter(clockInData, "clockInData");
        this.title.setText(clockInData.k());
        this.content.setText(clockInData.d());
        m(this.clockInDays, ClockInfoDescKey.CLICK_IN_DAYS.getDescStr(), clockInData.e());
        m(this.clockInFrequency, ClockInfoDescKey.CLOCK_IN_FREQUENCY.getDescStr(), clockInData.g());
        if (clockInData.l().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.publishClassName.setVisibility(0);
            m(this.publishClassName, ClockInfoDescKey.PUBLISH_CLASS.getDescStr(), clockInData.l());
        } else {
            this.publishClassName.setVisibility(8);
        }
        this.publishTime.setText(clockInData.i());
    }
}
