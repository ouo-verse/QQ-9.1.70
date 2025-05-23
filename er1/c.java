package er1;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007\u00a8\u0006\u0010"}, d2 = {"Ler1/c;", "", "Landroid/widget/TextView;", "textView", "", "c", "Landroid/widget/ImageView;", "imageView", "", "isUp", "b", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f397055a = new c();

    c() {
    }

    @JvmStatic
    public static final void a(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        boolean isVasTheme = QQTheme.isVasTheme();
        Integer valueOf = Integer.valueOf(R.color.qui_common_fill_light_secondary);
        if (isVasTheme) {
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            LiveData<Integer> g16 = QuiBitmapResourceObtainColorHelper.g(context, R.drawable.qui_common_bg_bottom_standard_bg);
            if (g16.getValue() != null) {
                Context context2 = rootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
                Integer value = g16.getValue();
                Intrinsics.checkNotNull(value);
                rootView.setBackground(GuildUIUtils.y(context2, R.drawable.guild_unread_bubble_bg, value.intValue()));
                return;
            }
            Context context3 = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "rootView.context");
            rootView.setBackground(GuildUIUtils.w(context3, R.drawable.guild_unread_bubble_bg, valueOf));
            return;
        }
        Context context4 = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "rootView.context");
        rootView.setBackground(GuildUIUtils.w(context4, R.drawable.guild_unread_bubble_bg, valueOf));
    }

    @JvmStatic
    public static final void b(@NotNull ImageView imageView, boolean isUp) {
        int i3;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (isUp) {
            i3 = R.drawable.guild_channel_unread_bubble_up;
        } else {
            i3 = R.drawable.guild_channel_unread_bubble_down;
        }
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        imageView.setBackground(GuildUIUtils.w(context, i3, Integer.valueOf(R.color.qui_common_icon_aio_toolbar_active)));
    }

    @JvmStatic
    public static final void c(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.qui_common_icon_aio_toolbar_active));
    }
}
