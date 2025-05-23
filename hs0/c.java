package hs0;

import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.guildlive.aio.input.component.playtogether.GuildLiveAioPlayTogetherUIState;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$PlayTogetherIconUpdate;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lhs0/c;", "Lpn0/a;", "Lol3/b;", "Lcom/tencent/guildlive/aio/input/component/playtogether/GuildLiveAioPlayTogetherUIState;", "Lcom/tencent/guildlive/api/intent/GuildLiveOuterMsgIntent$PlayTogetherIconUpdate;", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "showAnimation", "Landroid/graphics/drawable/Drawable;", "p", "o", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "j", "<init>", "()V", "f", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends pn0.a<ol3.b, GuildLiveAioPlayTogetherUIState> {
    /* JADX WARN: Multi-variable type inference failed */
    private final Drawable o() {
        return ResourcesCompat.getDrawable(((com.tencent.aio.api.runtime.a) getMContext()).c().getResources(), R.drawable.guild_live_bottom_play_together_disable_icon, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Drawable p(boolean showAnimation) {
        int dpToPx = ViewUtils.dpToPx(38.0f);
        Drawable drawable = ResourcesCompat.getDrawable(((com.tencent.aio.api.runtime.a) getMContext()).c().getResources(), R.drawable.guild_live_bottom_play_together_icon, null);
        if (!showAnimation) {
            return drawable;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseAutoScaleParams = false;
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        obtain.mUseApngImage = true;
        obtain.mPlayGifImage = true;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable("https://downv6.qq.com/innovate/guild/third_app_icon/smoba/icon_iSpt.png", obtain);
        if (drawable2.getStatus() != 1) {
            drawable2.startDownload(true);
        }
        Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
        return drawable2;
    }

    private final void q(GuildLiveOuterMsgIntent$PlayTogetherIconUpdate intent) {
        Drawable o16;
        if (QLog.isColorLevel()) {
            GuildLiveLogUtil.INSTANCE.b(FrameworkVM.TAG, "[handleIconUpdate] visible = " + intent.getVisibility() + ", isStatusOn = " + intent.getIsStatusOn() + ", showAnimation = " + intent.getShowAnimation());
        }
        int visibility = intent.getVisibility();
        if (intent.getIsStatusOn()) {
            o16 = p(intent.getShowAnimation());
        } else {
            o16 = o();
        }
        updateUI(new GuildLiveAioPlayTogetherUIState.PlayTogetherUpdate(visibility, o16));
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildLiveOuterMsgIntent$PlayTogetherIconUpdate) {
            q((GuildLiveOuterMsgIntent$PlayTogetherIconUpdate) intent);
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$PlayTogetherIconUpdate.class).getQualifiedName());
        return listOf;
    }
}
