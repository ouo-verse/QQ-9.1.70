package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.ItemPositionType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/p;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "data", "", "l", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "positionType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class p extends RecyclerView.ViewHolder {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f233793a;

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
            f233793a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public void l(@NotNull b data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int m(@NotNull ItemPositionType positionType) {
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        int i3 = a.f233793a[positionType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return R.drawable.guild_token_setting_round_rect_8_selector;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return R.drawable.guild_token_setting_bottom_round_rect_8_selector;
            }
            return R.drawable.guild_token_setting_rect_8_selector;
        }
        return R.drawable.guild_token_setting_top_round_rect_8_selector;
    }
}
