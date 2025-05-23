package dy1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J6\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a8\u0006\u0016"}, d2 = {"Ldy1/a;", "", "", "roleType", "", "isCustomAdmin", "a", "color", "Landroid/widget/TextView;", "adminRoleColor", "Landroid/content/Context;", "context", "", "c", "Landroid/widget/ImageView;", "imageRoleColor", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f395200a = new a();

    a() {
    }

    private final boolean a(int roleType, boolean isCustomAdmin) {
        if (4 != roleType && 2 != roleType && 5 != roleType && 7 != roleType && !isCustomAdmin) {
            return false;
        }
        return true;
    }

    private final void c(int roleType, int color, TextView adminRoleColor, Context context) {
        String str;
        if (4 == roleType) {
            str = "\u4e3b";
        } else {
            str = "\u7ba1";
        }
        adminRoleColor.setText(str);
        Drawable drawable = context.getDrawable(R.drawable.guild_admin_role_color_bg);
        if (drawable != null) {
            drawable.setTint(color);
        }
        adminRoleColor.setBackground(drawable);
    }

    public final boolean b(@Nullable IGProGuildRoleInfo roleInfo) {
        if (roleInfo != null && roleInfo.getDisplayType() == 1) {
            return true;
        }
        return false;
    }

    public final void d(int color, int roleType, boolean isCustomAdmin, @NotNull ImageView imageRoleColor, @NotNull TextView adminRoleColor, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(imageRoleColor, "imageRoleColor");
        Intrinsics.checkNotNullParameter(adminRoleColor, "adminRoleColor");
        Intrinsics.checkNotNullParameter(context, "context");
        if (a(roleType, isCustomAdmin)) {
            imageRoleColor.setVisibility(8);
            adminRoleColor.setVisibility(0);
            c(roleType, color, adminRoleColor, context);
        } else {
            adminRoleColor.setVisibility(8);
            imageRoleColor.setImageTintList(ColorStateList.valueOf(color));
            imageRoleColor.setVisibility(0);
        }
    }
}
