package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/a;", "", "Landroid/content/Context;", "ctx", "Lcom/tencent/widget/ActionSheet;", "a", "actionSheet", "b", "", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/a$a;", "Ljava/util/List;", "getMenus", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "menus", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/a$a;", "getCancel", "()Lcom/tencent/mobileqq/guild/discoveryv2/widget/a$a;", "c", "(Lcom/tencent/mobileqq/guild/discoveryv2/widget/a$a;)V", "cancel", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<C7731a> menus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private C7731a cancel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012:\b\u0002\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006RI\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/a$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "onViewInit", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7731a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Function2<View, ActionSheet, Unit> onViewInit;

        /* JADX WARN: Multi-variable type inference failed */
        public C7731a(@NotNull String text, @Nullable Function2<? super View, ? super ActionSheet, Unit> function2) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.onViewInit = function2;
        }

        @Nullable
        public final Function2<View, ActionSheet, Unit> a() {
            return this.onViewInit;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getText() {
            return this.text;
        }
    }

    @NotNull
    public final ActionSheet a(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Dialog createDialog = ActionSheetHelper.createDialog(ctx, null, true);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        return b((ActionSheet) createDialog);
    }

    @NotNull
    public final ActionSheet b(@NotNull ActionSheet actionSheet) {
        View findViewById;
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        List<C7731a> list = this.menus;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                actionSheet.addButton(((C7731a) it.next()).getText());
            }
        }
        C7731a c7731a = this.cancel;
        if (c7731a != null) {
            actionSheet.addCancelButton(c7731a.getText());
        }
        actionSheet.preInitView();
        List<C7731a> list2 = this.menus;
        if (list2 != null) {
            int i3 = 0;
            for (Object obj : list2) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                C7731a c7731a2 = (C7731a) obj;
                View findViewById2 = actionSheet.findViewById(i3);
                if (findViewById2 != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View?>(i)");
                    Function2<View, ActionSheet, Unit> a16 = c7731a2.a();
                    if (a16 != null) {
                        a16.invoke(findViewById2, actionSheet);
                    }
                }
                i3 = i16;
            }
        }
        C7731a c7731a3 = this.cancel;
        if (c7731a3 != null && (findViewById = actionSheet.findViewById(R.id.action_sheet_btnCancel)) != null) {
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View?>(com.\u2026d.action_sheet_btnCancel)");
            Function2<View, ActionSheet, Unit> a17 = c7731a3.a();
            if (a17 != null) {
                a17.invoke(findViewById, actionSheet);
            }
        }
        return actionSheet;
    }

    public final void c(@Nullable C7731a c7731a) {
        this.cancel = c7731a;
    }

    public final void d(@Nullable List<C7731a> list) {
        this.menus = list;
    }
}
