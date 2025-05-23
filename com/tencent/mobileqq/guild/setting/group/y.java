package com.tencent.mobileqq.guild.setting.group;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/y;", "", "Landroid/view/View;", "view", "", "elementId", "", "a", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "positionType", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f233563a = new y();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f233564a;

        static {
            int[] iArr = new int[ItemPositionType.values().length];
            try {
                iArr[ItemPositionType.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemPositionType.Middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemPositionType.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemPositionType.Single.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f233564a = iArr;
        }
    }

    y() {
    }

    public final void a(@NotNull View view, @NotNull String elementId) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        emptyMap = MapsKt__MapsKt.emptyMap();
        bt.c(view, elementId, emptyMap, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE);
    }

    public final void b(@NotNull View view, @NotNull ItemPositionType positionType) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        int i16 = a.f233564a[positionType.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        i3 = R.drawable.guild_token_setting_round_rect_8_selector;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i3 = R.drawable.guild_token_setting_bottom_round_rect_8_selector;
                }
            } else {
                i3 = R.drawable.guild_token_setting_rect_8_selector;
            }
        } else {
            i3 = R.drawable.guild_token_setting_top_round_rect_8_selector;
        }
        view.setBackground(view.getContext().getDrawable(i3));
    }
}
