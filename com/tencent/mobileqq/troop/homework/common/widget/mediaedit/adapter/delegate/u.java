package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UserInfoTitleItem;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/u;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/BaseMediaEditSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/UserInfoTitleItem;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "t", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "f", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "avatarImage", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "nameTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pubTimeTv", BdhLogUtil.LogTag.Tag_Conn, "makeUpTv", "D", "Landroid/view/View;", "moreIcon", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class u extends BaseMediaEditSection<UserInfoTitleItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView makeUpTv;

    /* renamed from: D, reason: from kotlin metadata */
    private View moreIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Drawable defaultDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarImage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView nameTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView pubTimeTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/u$a;", "", "", "KEY_UIN", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.u$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46677);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.defaultDrawable = BaseImageUtil.getDefaultFaceDrawable140_140();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(u this$0, View this_apply, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        qs2.a q16 = this$0.q();
        Context context = this_apply.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        q16.c(activity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1194076r};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.BaseMediaEditSection, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable final View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        super.onInitView(containerView);
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.l_k);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar_image)");
            this.avatarImage = (ImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.dqd);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item_name)");
            this.nameTv = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.xwr);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.item_publish_time)");
            this.pubTimeTv = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.xvs);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.item_light_text)");
            this.makeUpTv = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.xwc);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.item_more_icon)");
            this.moreIcon = findViewById5;
            if (findViewById5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreIcon");
                findViewById5 = null;
            }
            findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.u(u.this, containerView, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable UserInfoTitleItem data, int position, @Nullable List<Object> payload) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data == null) {
            return;
        }
        TextView textView = this.nameTv;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameTv");
            textView = null;
        }
        textView.setText(data.getName());
        TextView textView2 = this.pubTimeTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubTimeTv");
            textView2 = null;
        }
        textView2.setText(data.getSubTitle());
        TextView textView3 = this.makeUpTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeUpTv");
            textView3 = null;
        }
        if (data.isMakeUp()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView3.setVisibility(i3);
        View view = this.moreIcon;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreIcon");
            view = null;
        }
        if (!data.getShowMoreAction()) {
            i16 = 8;
        }
        view.setVisibility(i16);
        ImageView imageView2 = this.avatarImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImage");
            imageView2 = null;
        }
        if (!Intrinsics.areEqual(imageView2.getTag(-1000), data.getUin())) {
            AppInterface e16 = bg.e();
            String uin = data.getUin();
            Drawable drawable = this.defaultDrawable;
            FaceDrawable faceDrawableFrom = FaceDrawable.getFaceDrawableFrom(e16, 1, uin, 3, drawable, drawable, 6);
            ImageView imageView3 = this.avatarImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarImage");
                imageView3 = null;
            }
            imageView3.setImageDrawable(faceDrawableFrom);
            ImageView imageView4 = this.avatarImage;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarImage");
            } else {
                imageView = imageView4;
            }
            imageView.setTag(-1000, data.getUin());
        }
    }
}
