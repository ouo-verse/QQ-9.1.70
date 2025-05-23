package com.tencent.mobileqq.weather.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J \u0010\b\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/d;", "Lcom/tencent/mobileqq/weather/adapter/b;", "", "o", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/data/d;", "Lkotlin/collections/ArrayList;", "data", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mMedicalDesc", UserInfo.SEX_FEMALE, "mMedicalAuthor", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "mMedicalContainer", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "mMedicalLogo", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mMedicalDesc;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mMedicalAuthor;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout mMedicalContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView mMedicalLogo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(com.tencent.mobileqq.weather.data.d medicalData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(medicalData, "$medicalData");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        gVar.O(context, medicalData.g());
        com.tencent.mobileqq.weather.util.report.c.f313670a.f(medicalData.e());
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void o() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mMedicalDesc;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.mMedicalAuthor;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
            RelativeLayout relativeLayout = this.mMedicalContainer;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(Color.parseColor("#313131"));
            }
            ImageView imageView = this.mMedicalLogo;
            if (imageView != null) {
                imageView.setImageDrawable(this.itemView.getContext().getDrawable(R.drawable.nim));
            }
        }
    }

    @Override // com.tencent.mobileqq.weather.adapter.b
    public void l(@NotNull ArrayList<com.tencent.mobileqq.weather.data.d> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.itemView;
        this.mMedicalDesc = (TextView) view.findViewById(R.id.smi);
        this.mMedicalAuthor = (TextView) view.findViewById(R.id.smf);
        this.mMedicalContainer = (RelativeLayout) view.findViewById(R.id.smh);
        this.mMedicalLogo = (ImageView) view.findViewById(R.id.smj);
        com.tencent.mobileqq.weather.data.d dVar = data.get(0);
        Intrinsics.checkNotNullExpressionValue(dVar, "data[0]");
        final com.tencent.mobileqq.weather.data.d dVar2 = dVar;
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.n(com.tencent.mobileqq.weather.data.d.this, view2);
            }
        });
        TextView textView = this.mMedicalDesc;
        if (textView != null) {
            textView.setText(dVar2.f());
        }
        TextView textView2 = this.mMedicalAuthor;
        if (textView2 != null) {
            textView2.setText(dVar2.a());
        }
        com.tencent.mobileqq.weather.util.b.j(this.mMedicalContainer, 5.0f);
        o();
    }
}
