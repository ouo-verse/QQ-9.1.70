package com.tencent.mobileqq.troop.troopcard.ui.medal;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.GroupMedalInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMedalLabel;
import com.tencent.qqnt.kernel.nativeinterface.GroupMedalStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0014\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/ui/medal/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "labelName", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMedalInfo;", "medalInfo", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMedalStatus;", "medalStatus", "o", "position", "itemWidth", "", "l", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "modelInfoContainer", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "gapLine", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "medalIcon", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "medalName", "I", "medalLevel", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"SetTextI18n"})
/* loaded from: classes19.dex */
public final class b extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout modelInfoContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View gapLine;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView medalIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView medalName;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView medalLevel;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f299950a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57409);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupMedalStatus.values().length];
            try {
                iArr[GroupMedalStatus.KGROUPMEDALSTATUSNOTACQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupMedalStatus.KGROUPMEDALSTATUSACQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GroupMedalStatus.KGROUPMEDALSTATUSRETENTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GroupMedalStatus.KGROUPMEDALSTATUSTOBEDOWNGRADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f299950a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.yz8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.medal_info_container)");
        this.modelInfoContainer = (LinearLayout) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f116686ze);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.vertical_gap_line)");
        this.gapLine = findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f102555y8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.troop_medal_icon)");
        this.medalIcon = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.f102575y_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.troop_medal_name)");
        this.medalName = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.f102565y9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.troop_medal_level)");
        this.medalLevel = (TextView) findViewById5;
    }

    private final int m(String labelName) {
        CharSequence trim;
        trim = StringsKt__StringsKt.trim((CharSequence) labelName);
        String obj = trim.toString();
        if (Intrinsics.areEqual(obj, "\u9650\u65f6")) {
            return this.itemView.getContext().getColor(R.color.qui_common_brand_standard);
        }
        if (Intrinsics.areEqual(obj, "\u7edd\u7248")) {
            return Color.parseColor("#FF8D40");
        }
        return this.itemView.getContext().getColor(R.color.qui_common_text_secondary_light);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String n(GroupMedalInfo medalInfo) {
        boolean z16;
        String str;
        Object first;
        ArrayList<GroupMedalLabel> arrayList = medalInfo.medalLabelArray;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            ArrayList<GroupMedalLabel> arrayList2 = medalInfo.medalLabelArray;
            if (arrayList2 != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                GroupMedalLabel groupMedalLabel = (GroupMedalLabel) first;
                if (groupMedalLabel != null) {
                    str = groupMedalLabel.medalLabelValue;
                    if (str != null) {
                        return "";
                    }
                    return str;
                }
            }
            str = null;
            if (str != null) {
            }
        } else {
            int i3 = medalInfo.medalLevel;
            if (i3 > 0) {
                return "LV" + i3;
            }
            GroupMedalStatus groupMedalStatus = medalInfo.medalStatus;
            Intrinsics.checkNotNullExpressionValue(groupMedalStatus, "medalInfo.medalStatus");
            return o(groupMedalStatus);
        }
    }

    private final String o(GroupMedalStatus medalStatus) {
        int i3 = a.f299950a[medalStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "";
                    }
                    return "\u5373\u5c06\u964d\u7ea7";
                }
                return "\u4fdd\u7ea7\u4e2d";
            }
            return "\u5df2\u83b7\u5f97";
        }
        return "\u672a\u83b7\u5f97";
    }

    public final void l(int position, @NotNull GroupMedalInfo medalInfo, int itemWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), medalInfo, Integer.valueOf(itemWidth));
            return;
        }
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        ViewGroup.LayoutParams layoutParams = this.modelInfoContainer.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(itemWidth, -2);
        }
        layoutParams.width = itemWidth;
        this.modelInfoContainer.setLayoutParams(layoutParams);
        View view = this.gapLine;
        if (position == 0) {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.medalIcon.setImageDrawable(URLDrawable.getDrawable(medalInfo.medalIcon, URLDrawable.URLDrawableOptions.obtain()));
        this.medalName.setText(medalInfo.medalName);
        String n3 = n(medalInfo);
        this.medalLevel.setText(n3);
        this.medalLevel.setTextColor(m(n3));
    }
}
