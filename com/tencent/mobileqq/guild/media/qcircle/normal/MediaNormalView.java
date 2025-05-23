package com.tencent.mobileqq.guild.media.qcircle.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ViewKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.chat.widget.GuildMediaScreenShareView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaMemberListView;
import com.tencent.mobileqq.guild.media.widget.user.adapter.c;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/normal/MediaNormalView;", "Landroid/widget/LinearLayout;", "", "a", "isPause", "", "setIsPause", "b", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", "d", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", "listView", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareView;", "e", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaScreenShareView;", "screenView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaNormalView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaMemberListView listView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaScreenShareView screenView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaNormalView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean a() {
        Fragment fragment;
        try {
            fragment = ViewKt.findFragment(this);
        } catch (Exception unused) {
            fragment = null;
        }
        if (fragment == null) {
            return false;
        }
        this.listView.h0(new c(fragment));
        this.listView.setNeedIgnoreSelf(true);
        this.listView.setFromQCircle(true);
        this.listView.c0();
        this.listView.j0("MediaNormalView");
        GuildMediaScreenShareView.g(this.screenView, null, 1, null);
        return true;
    }

    public final void b() {
        this.listView.onDestroy();
        this.screenView.h();
    }

    public final void setIsPause(boolean isPause) {
        this.screenView.setCurPageIsAvailable(!isPause);
    }

    public /* synthetic */ MediaNormalView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaNormalView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.eyy, this);
        View findViewById = findViewById(R.id.zsc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.normal_rv)");
        this.listView = (GuildMediaMemberListView) findViewById;
        View findViewById2 = findViewById(R.id.f80424bf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.screen_share_layout)");
        this.screenView = (GuildMediaScreenShareView) findViewById2;
    }
}
