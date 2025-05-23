package com.tencent.guild.aio.factory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.aio.api.refreshLoad.HeadFooterViewHolder;
import com.tencent.aio.exception.AIOException;
import com.tencent.mobileqq.utils.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/factory/e;", "Lcom/tencent/aio/api/refreshLoad/e;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "c", "", "type", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements com.tencent.aio.api.refreshLoad.e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f110654a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/factory/e$a", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "Landroid/view/View;", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends HeadFooterViewHolder {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f110655c;

        a(Context context) {
            this.f110655c = context;
        }

        @Override // com.tencent.aio.api.refreshLoad.HeadFooterViewHolder
        @NotNull
        public View b() {
            FrameLayout frameLayout = new FrameLayout(this.f110655c);
            Context context = this.f110655c;
            ProgressBar progressBar = new ProgressBar(context);
            progressBar.setIndeterminateDrawable(e.f110654a.c(context));
            com.tencent.aio.base.tool.b bVar = com.tencent.aio.base.tool.b.f69219a;
            FrameLayout.LayoutParams a16 = bVar.a(context, 24, 24);
            a16.gravity = 17;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(progressBar, a16);
            FrameLayout.LayoutParams a17 = bVar.a(context, -1, 45);
            a17.gravity = 48;
            frameLayout.setLayoutParams(a17);
            return frameLayout;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/factory/e$b", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "Landroid/view/View;", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends HeadFooterViewHolder {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f110656c;

        b(Context context) {
            this.f110656c = context;
        }

        @Override // com.tencent.aio.api.refreshLoad.HeadFooterViewHolder
        @NotNull
        public View b() {
            FrameLayout frameLayout = new FrameLayout(this.f110656c);
            Context context = this.f110656c;
            ProgressBar progressBar = new ProgressBar(context);
            progressBar.setIndeterminateDrawable(e.f110654a.c(context));
            com.tencent.aio.base.tool.b bVar = com.tencent.aio.base.tool.b.f69219a;
            FrameLayout.LayoutParams a16 = bVar.a(context, 24, 24);
            a16.gravity = 17;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(progressBar, a16);
            FrameLayout.LayoutParams a17 = bVar.a(context, -1, 45);
            a17.gravity = 80;
            frameLayout.setLayoutParams(a17);
            return frameLayout;
        }
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable c(Context context) {
        Drawable d16 = com.tencent.mobileqq.guild.util.qqui.d.d(context, 2);
        if (d16 != null) {
            d16.setBounds(0, 0, x.a(10.0f), x.a(10.0f));
        }
        return d16;
    }

    @Override // com.tencent.aio.api.refreshLoad.e
    @NotNull
    public HeadFooterViewHolder a(int type, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (type == 0) {
            return new a(context);
        }
        if (type == 1) {
            return new b(context);
        }
        throw new AIOException("can not implement " + type);
    }
}
