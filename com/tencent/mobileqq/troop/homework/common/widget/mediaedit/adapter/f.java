package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0005\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u00102\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010 \u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/f$a;", "Landroid/content/Context;", "context", "m0", "Landroid/widget/LinearLayout$LayoutParams;", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "t0", "getItemCount", "holder", "position", "", "s0", "Lqs2/b;", "listener", "u0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "includeFile", "Ljava/lang/ref/WeakReference;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/ref/WeakReference;", "D", NodeProps.VISIBLE, "E", "I", "iconSize", UserInfo.SEX_FEMALE, "iconMarginStart", "<init>", "(Z)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WeakReference<qs2.b> listener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean visible;

    /* renamed from: E, reason: from kotlin metadata */
    private final int iconSize;

    /* renamed from: F, reason: from kotlin metadata */
    private final int iconMarginStart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean includeFile;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/f$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/f;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        final /* synthetic */ f E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull f fVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) itemView);
            }
        }
    }

    public f() {
        this(false, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    private final a m0(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        int dpToPx = ViewUtils.dpToPx(5.0f);
        linearLayout.setPadding(0, dpToPx, 0, dpToPx);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(44.0f)));
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.qui_image);
        TriggerRunnerKt.c(imageView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.n0(f.this, view);
            }
        }, 1, null);
        linearLayout.addView(imageView, r0());
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(R.drawable.qui_camera);
        TriggerRunnerKt.c(imageView2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.o0(f.this, view);
            }
        }, 1, null);
        linearLayout.addView(imageView2, r0());
        ImageView imageView3 = new ImageView(context);
        imageView3.setImageResource(R.drawable.qui_microphone_on);
        TriggerRunnerKt.c(imageView3, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.p0(f.this, view);
            }
        }, 1, null);
        linearLayout.addView(imageView3, r0());
        if (this.includeFile) {
            ImageView imageView4 = new ImageView(context);
            imageView4.setImageResource(R.drawable.qui_folder_aio_oversized);
            TriggerRunnerKt.c(imageView4, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.q0(f.this, view);
                }
            }, 1, null);
            linearLayout.addView(imageView4, r0());
        }
        return new a(this, linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(f this$0, View view) {
        qs2.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<qs2.b> weakReference = this$0.listener;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.u4(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(f this$0, View view) {
        qs2.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<qs2.b> weakReference = this$0.listener;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.k4();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(f this$0, View view) {
        qs2.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<qs2.b> weakReference = this$0.listener;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.n8();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(f this$0, View view) {
        qs2.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<qs2.b> weakReference = this$0.listener;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.g4(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final LinearLayout.LayoutParams r0() {
        int i3 = this.iconSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMarginStart(this.iconMarginStart);
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return this.visible ? 1 : 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return m0(context);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void u0(@NotNull qs2.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = new WeakReference<>(listener);
        this.visible = true;
        notifyDataSetChanged();
    }

    public f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.includeFile = z16;
        this.iconSize = ViewUtils.dpToPx(24.0f);
        this.iconMarginStart = ViewUtils.dpToPx(16.0f);
    }

    public /* synthetic */ f(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
