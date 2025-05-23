package com.tencent.mobileqq.zplan.emoticon.panel.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zplan.maintenance.ZPlanMaintInfoRepo;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.model.j;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonMaintainingView;", "Landroid/widget/LinearLayout;", "", "d", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "bgLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonMaintainingView extends LinearLayout {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout bgLayout;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonMaintainingView$a;", "", "", "a", "", "MAINTAINING_BACKGROUND_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.view.ZPlanEmoticonMaintainingView$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return j.a(ZPlanMaintInfoRepo.f333853a.b(MaintEntryType.ALL), new Date());
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonMaintainingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanEmoticonMaintainingView.c(ZPlanEmoticonMaintainingView.this, view);
            }
        });
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPriority = (byte) 2;
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/zplan/maintenance/zplan_emoticon_maintaining_bg.png", obtain));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(imageView);
        this.bgLayout = relativeLayout;
        addView(relativeLayout);
        setGravity(16);
        setOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ZPlanEmoticonMaintainingView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    private final void d() {
        ZPlanMaintInfo b16 = ZPlanMaintInfoRepo.f333853a.b(MaintEntryType.ALL);
        String mMainTitle = b16.getMMainTitle();
        String mSubTitle = b16.getMSubTitle();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(mMainTitle);
        createCustomDialog.setMessage(mSubTitle);
        createCustomDialog.setPositiveButton(R.string.xqq, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanEmoticonMaintainingView.e(dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(true);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonMaintainingView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
