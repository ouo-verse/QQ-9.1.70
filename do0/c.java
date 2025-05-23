package do0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.tencent.guild.aio.halfpop.menu.debug.DebugLayout;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/widget/FrameLayout;", "decorView", "b", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.tencent.guild.aio.halfpop.menu.debug.DebugLayout, T, android.view.View] */
    @NotNull
    public static final FrameLayout b(@NotNull FrameLayout decorView) {
        T t16;
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        View findViewById = decorView.findViewById(R.id.beb);
        if (findViewById instanceof FrameLayout) {
            t16 = (FrameLayout) findViewById;
        } else {
            t16 = 0;
        }
        objectRef.element = t16;
        if (t16 == 0) {
            Context context = decorView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "decorView.context");
            ?? debugLayout = new DebugLayout(context);
            debugLayout.setId(R.id.beb);
            debugLayout.setBackgroundColor(-1442840576);
            ViewExtKt.f(debugLayout, com.tencent.guild.aio.util.c.b(25));
            debugLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            debugLayout.setFocusable(true);
            objectRef.element = debugLayout;
            decorView.addView((View) debugLayout);
        }
        ((FrameLayout) objectRef.element).removeAllViews();
        ((View) objectRef.element).setVisibility(0);
        Button button = new Button(decorView.getContext());
        button.setText("\u5173 \u95ed");
        button.setTextColor(SupportMenu.CATEGORY_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, com.tencent.guild.aio.util.c.b(40));
        layoutParams.gravity = 53;
        button.setLayoutParams(layoutParams);
        button.setOnClickListener(new View.OnClickListener() { // from class: do0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.c(Ref.ObjectRef.this, view);
            }
        });
        ((FrameLayout) objectRef.element).addView(button);
        FrameLayout frameLayout = new FrameLayout(decorView.getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.tencent.guild.aio.util.c.b(40);
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.setClickable(false);
        ((FrameLayout) objectRef.element).addView(frameLayout);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(Ref.ObjectRef debugLayout, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(debugLayout, "$debugLayout");
        ((FrameLayout) debugLayout.element).removeAllViews();
        ((View) debugLayout.element).setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }
}
