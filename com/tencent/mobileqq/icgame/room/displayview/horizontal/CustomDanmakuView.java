package com.tencent.mobileqq.icgame.room.displayview.horizontal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.live.impl.danmuku.EsportsDanmakuView;
import com.tencent.icgame.game.live.impl.danmuku.f;
import com.tencent.mobileqq.R;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/CustomDanmakuView;", "Landroid/widget/FrameLayout;", "Lfv0/a;", "", FileReaderHelper.TXT_EXT, "", "i", "g", "", "show", "f", "d", "e", tl.h.F, "Lcom/tencent/icgame/game/live/impl/danmuku/EsportsDanmakuView;", "Lcom/tencent/icgame/game/live/impl/danmuku/EsportsDanmakuView;", "danmakuView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class CustomDanmakuView extends FrameLayout implements fv0.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EsportsDanmakuView danmakuView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomDanmakuView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // fv0.a
    public void d() {
        this.danmakuView.onStart();
    }

    @Override // fv0.a
    public void e() {
        this.danmakuView.onStop();
    }

    @Override // fv0.a
    public void f(boolean show) {
        if (show) {
            this.danmakuView.start();
        } else {
            this.danmakuView.stop();
        }
    }

    @Override // fv0.a
    public void g(@NotNull String txt) {
        Intrinsics.checkNotNullParameter(txt, "txt");
        EsportsDanmakuView esportsDanmakuView = this.danmakuView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        f.a.b(esportsDanmakuView, context, txt, getResources().getColor(R.color.f158017al3), 0, 8, null);
    }

    @Override // fv0.a
    public void h() {
        this.danmakuView.onDestroy();
    }

    @Override // fv0.a
    public void i(@NotNull String txt) {
        Intrinsics.checkNotNullParameter(txt, "txt");
        EsportsDanmakuView esportsDanmakuView = this.danmakuView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        f.a.a(esportsDanmakuView, context, txt, getResources().getColor(R.color.f158017al3), 0, 8, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomDanmakuView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomDanmakuView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomDanmakuView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        EsportsDanmakuView esportsDanmakuView = new EsportsDanmakuView(context, null, 0, 6, null);
        this.danmakuView = esportsDanmakuView;
        esportsDanmakuView.l();
        addView(esportsDanmakuView);
    }
}
