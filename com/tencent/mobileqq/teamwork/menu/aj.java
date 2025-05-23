package com.tencent.mobileqq.teamwork.menu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.teamwork.menu.aj;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.nativepreview.biz.OutlineStyle;
import com.tencent.nativepreview.wrapper.model.DocOutlineItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/teamwork/menu/aj;", "", "a", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J9\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/teamwork/menu/aj$a;", "", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "items", "Lkotlin/Function1;", "", "listener", "d", "(Landroid/app/Activity;[Lcom/tencent/nativepreview/wrapper/model/DocOutlineItem;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.teamwork.menu.aj$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final View c(LinearLayout container, DocOutlineItem item) {
            TextView textView = new TextView(container.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            float f16 = container.getContext().getResources().getDisplayMetrics().density;
            com.tencent.nativepreview.util.a aVar = com.tencent.nativepreview.util.a.f337875a;
            layoutParams.topMargin = (int) aVar.a(5.0f, f16);
            layoutParams.bottomMargin = (int) aVar.a(5.0f, f16);
            OutlineStyle c16 = OutlineStyle.INSTANCE.c(item.getPresetStyle());
            textView.setText(item.getTitle());
            textView.setTextSize(c16.d());
            textView.setTextColor(c16.e());
            textView.setPadding((int) aVar.a(c16.f(), f16), 0, 0, 0);
            container.addView(textView, layoutParams);
            return textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ActionSheet actionSheet, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            actionSheet.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(Function1 listener, DocOutlineItem[] docOutlineItemArr, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.invoke(docOutlineItemArr[i3]);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void d(@NotNull Activity activity, @Nullable final DocOutlineItem[] items, @NotNull final Function1<? super DocOutlineItem, Unit> listener) {
            LayoutInflater layoutInflater;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(listener, "listener");
            final ActionSheet create = ActionSheet.create(activity);
            Object systemService = activity.getSystemService("layout_inflater");
            View view = null;
            if (systemService instanceof LayoutInflater) {
                layoutInflater = (LayoutInflater) systemService;
            } else {
                layoutInflater = null;
            }
            if (layoutInflater != null) {
                view = layoutInflater.inflate(R.layout.g76, (ViewGroup) null);
            }
            boolean z16 = true;
            if (view == null) {
                QLog.e("DocOutlineUtils", 1, "inflate view failed");
                return;
            }
            View findViewById = view.findViewById(R.id.xdi);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.View");
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    aj.Companion.e(ActionSheet.this, view2);
                }
            });
            create.addView(view);
            if (items != null) {
                if (items.length != 0) {
                    z16 = false;
                }
                if (!z16) {
                    View findViewById2 = view.findViewById(R.id.bww);
                    Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.view.View");
                    findViewById2.setVisibility(8);
                    View findViewById3 = view.findViewById(R.id.f217801y);
                    Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
                    LinearLayout linearLayout = (LinearLayout) findViewById3;
                    int length = items.length;
                    for (final int i3 = 0; i3 < length; i3++) {
                        c(linearLayout, items[i3]).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.ai
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                aj.Companion.f(Function1.this, items, i3, view2);
                            }
                        });
                    }
                    create.show();
                    return;
                }
            }
            View findViewById4 = view.findViewById(R.id.bww);
            Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.view.View");
            findViewById4.setVisibility(0);
            create.show();
        }

        Companion() {
        }
    }
}
