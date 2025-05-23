package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JO\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/k;", "", "T", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "delegate", "items", "", "position", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "payloads", "", "a", "(Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;Ljava/lang/Object;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "b", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f236217a = new k();

    k() {
    }

    @JvmStatic
    public static final <T> void a(@NotNull b<T> delegate, @NotNull T items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!TraceUtils.m()) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("DelegateTrace", "onBindViewHolder: " + delegate.getClass().getSimpleName() + TokenParser.SP + position + TokenParser.SP + items + " viewType=" + holder.getItemViewType());
            }
            delegate.c(items, position, holder, payloads);
            return;
        }
        TraceUtils traceUtils = TraceUtils.f235403a;
        String str = "Delegate.Bind." + delegate.getClass().getCanonicalName() + util.base64_pad_url + position;
        if (!TraceUtils.m()) {
            traceUtils.l();
            delegate.c(items, position, holder, payloads);
            return;
        }
        try {
            cy.c(str);
            delegate.c(items, position, holder, payloads);
            Unit unit = Unit.INSTANCE;
        } finally {
            cy.d();
        }
    }

    @JvmStatic
    @NotNull
    public static final <T> RecyclerView.ViewHolder b(@NotNull b<T> delegate, @NotNull ViewGroup parent) {
        RecyclerView.ViewHolder d16;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (!TraceUtils.m()) {
            RecyclerView.ViewHolder d17 = delegate.d(parent);
            Intrinsics.checkNotNullExpressionValue(d17, "delegate.onCreateViewHolder(parent)");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("DelegateTrace", "onCreateViewHolder: " + delegate.getClass().getSimpleName() + ", holder = " + d17);
            }
            return d17;
        }
        TraceUtils traceUtils = TraceUtils.f235403a;
        String str = "Delegate.Create." + delegate.getClass().getCanonicalName();
        if (!TraceUtils.m()) {
            traceUtils.l();
            d16 = delegate.d(parent);
        } else {
            try {
                cy.c(str);
                d16 = delegate.d(parent);
            } finally {
                cy.d();
            }
        }
        Intrinsics.checkNotNullExpressionValue(d16, "TraceUtils.trace(\"Delega\u2026wHolder(parent)\n        }");
        return d16;
    }
}
