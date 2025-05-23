package com.tencent.mobileqq.troop.homework.coursemgr.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.CourseInfo;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001b\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014R\"\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/e;", "Lcom/tencent/mobileqq/widget/listitem/v;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "view", "", "position", "", "", "payloads", "", UserInfo.SEX_FEMALE, "", "l", "Z", "isSelect", "()Z", "P", "(Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "canDelete", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "courseInfo", "Lkotlin/Function0;", "o", "Lkotlin/jvm/functions/Function0;", "onDeleteClick", "Landroid/widget/TextView;", "p", "Landroid/widget/TextView;", "courseNameTv", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/FrameLayout;", "manageIconWrap", "Landroid/widget/ImageView;", "r", "Landroid/widget/ImageView;", "manageIcon", "<init>", "(ZZLcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;Lkotlin/jvm/functions/Function0;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends v {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isSelect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean canDelete;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CourseInfo courseInfo;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onDeleteClick;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView courseNameTv;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout manageIconWrap;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView manageIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(boolean z16, boolean z17, @NotNull CourseInfo courseInfo, @NotNull Function0<Unit> onDeleteClick) {
        super(R.layout.g0a);
        Intrinsics.checkNotNullParameter(courseInfo, "courseInfo");
        Intrinsics.checkNotNullParameter(onDeleteClick, "onDeleteClick");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), courseInfo, onDeleteClick);
            return;
        }
        this.isSelect = z16;
        this.canDelete = z17;
        this.courseInfo = courseInfo;
        this.onDeleteClick = onDeleteClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onDeleteClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void F(@NotNull View view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TextView textView = this.courseNameTv;
        if (textView != null) {
            textView.setText(this.courseInfo.getCourseName());
        }
        if (this.isSelect) {
            FrameLayout frameLayout = this.manageIconWrap;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ImageView imageView = this.manageIcon;
            if (imageView != null) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.qui_check_brand_standard));
            }
            FrameLayout frameLayout2 = this.manageIconWrap;
            if (frameLayout2 != null) {
                frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.ui.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        e.M(view2);
                    }
                });
                return;
            }
            return;
        }
        if (this.canDelete) {
            FrameLayout frameLayout3 = this.manageIconWrap;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(0);
            }
            ImageView imageView2 = this.manageIcon;
            if (imageView2 != null) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.qui_delete));
            }
            FrameLayout frameLayout4 = this.manageIconWrap;
            if (frameLayout4 != null) {
                frameLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.ui.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        e.N(e.this, view2);
                    }
                });
                return;
            }
            return;
        }
        FrameLayout frameLayout5 = this.manageIconWrap;
        if (frameLayout5 != null) {
            frameLayout5.setVisibility(8);
        }
        FrameLayout frameLayout6 = this.manageIconWrap;
        if (frameLayout6 != null) {
            frameLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.O(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.v, com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public View H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View H = super.H(parent);
        this.courseNameTv = (TextView) H.findViewById(R.id.f102095wz);
        this.manageIconWrap = (FrameLayout) H.findViewById(R.id.f102075wx);
        this.manageIcon = (ImageView) H.findViewById(R.id.f102065ww);
        return H;
    }

    public final void P(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isSelect = z16;
        }
    }
}
