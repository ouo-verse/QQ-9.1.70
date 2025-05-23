package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fB'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", NodeProps.VISIBLE, "", "d", "c", "", "roomCoverUrl", "b", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "a", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "callback", "setOperateCallback", "e", "f", "g", "", "isMute", "setMute", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "operateCallback", "Landroid/content/Context;", "context", "coverUrl", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/util/AttributeSet;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveFloatWindowOperateView extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a operateCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "", "", "b", "a", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public /* synthetic */ QQLiveFloatWindowOperateView(Context context, String str, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i3 & 4) != 0 ? null : attributeSet);
    }

    private final URLDrawable.URLDrawableOptions a() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026sparentDrawable\n        }");
        return obtain;
    }

    private final void b(String roomCoverUrl) {
        if (!TextUtils.isEmpty(roomCoverUrl)) {
            URLDrawable drawable = URLDrawable.getDrawable(roomCoverUrl, a());
            ImageView imageView = (ImageView) findViewById(R.id.f639334v);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageDrawable(drawable);
        }
        findViewById(R.id.f165241vb2).setOnClickListener(this);
        findViewById(R.id.f165242vb3).setOnClickListener(this);
        ((FrameLayout) findViewById(R.id.f165239vb0)).setOnClickListener(this);
    }

    private final void c(int visible) {
        ((LinearLayout) findViewById(R.id.f6364343)).setVisibility(visible);
    }

    private final void d(int visible) {
        ((ImageView) findViewById(R.id.f639334v)).setVisibility(visible);
    }

    public final void e() {
        setVisibility(0);
        d(0);
        c(8);
    }

    public final void f() {
        setVisibility(0);
        d(0);
        c(0);
    }

    public final void g() {
        setVisibility(0);
        d(8);
        c(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.f165241vb2) {
            a aVar2 = this.operateCallback;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (id5 == R.id.f165242vb3) {
            a aVar3 = this.operateCallback;
            if (aVar3 != null) {
                aVar3.a();
            }
        } else if (id5 == R.id.f165239vb0 && (aVar = this.operateCallback) != null) {
            aVar.c();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setMute(boolean isMute) {
        ImageView imageView = (ImageView) findViewById(R.id.f165242vb3);
        if (isMute) {
            imageView.setBackgroundResource(R.drawable.nnj);
        } else {
            imageView.setBackgroundResource(R.drawable.nnk);
        }
    }

    public final void setOperateCallback(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.operateCallback = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveFloatWindowOperateView(@NotNull Context context, @Nullable String str, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(BaseApplication.getContext(), R.layout.fal, this);
        b(str);
    }
}
