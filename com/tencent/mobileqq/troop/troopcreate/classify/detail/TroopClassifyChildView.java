package com.tencent.mobileqq.troop.troopcreate.classify.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.utils.ay;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyChildView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "d", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyContainerView;", "containerView", "childContainerView", "f", "e", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/d;", DownloadInfo.spKey_Config, "b", "", "open", "g", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "childIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "childTv", "childArrowIv", "", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/b;", tl.h.F, "Ljava/util/List;", "curItems", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopClassifyChildView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView childIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView childTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView childArrowIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<b> curItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyChildView$a;", "", "", "HOR_PADDING", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.classify.detail.TroopClassifyChildView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25170);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyChildView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TroopClassifyChildView this$0, TroopClassifyContainerView containerView, LinearLayout childContainerView, a item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(containerView, "$containerView");
        Intrinsics.checkNotNullParameter(childContainerView, "$childContainerView");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.f(containerView, childContainerView, item);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d(a item) {
        VideoReport.setElementId(this, "em_group_classify_icon");
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("group_first_level", item.j());
        hashMap.put("group_second_level", "");
        hashMap.put("group_level_id", item.g());
        VideoReport.setElementParams(this, hashMap);
    }

    private final void e(a item) {
        Activity activity;
        Intent intent = new Intent();
        intent.putExtra("url", item.i());
        intent.putExtra("isShowAd", false);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        com.tencent.mobileqq.troop.troopcreate.a.k(getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
        QLog.i("TroopClassifyChildView", 1, "[jumpToH5] item:" + item);
    }

    private final void f(TroopClassifyContainerView containerView, LinearLayout childContainerView, a item) {
        boolean z16;
        if (u.a().b()) {
            QLog.i("TroopClassifyChildView", 1, "[onClickItem] fast click");
            return;
        }
        if (item.i().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            e(item);
            return;
        }
        if (!item.h().isEmpty()) {
            containerView.c(childContainerView, this, this.curItems, item.j());
            return;
        }
        QLog.i("TroopClassifyChildView", 1, "[onClickItem] illegal item:" + item);
    }

    public final void b(@NotNull d config, @NotNull final a item, @NotNull final TroopClassifyContainerView containerView, @NotNull final LinearLayout childContainerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, config, item, containerView, childContainerView);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(childContainerView, "childContainerView");
        List<b> h16 = item.h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h16) {
            if (!config.a().contains(((b) obj).c())) {
                arrayList.add(obj);
            }
        }
        this.curItems = arrayList;
        this.childTv.setText(item.j());
        this.childTv.setContentDescription(item.j());
        ImageView imageView = this.childArrowIv;
        if (!(!this.curItems.isEmpty())) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        if (QQTheme.isNowThemeIsNight()) {
            ay.f302095a.a(item.f(), this.childIv);
        } else {
            ay.f302095a.a(item.e(), this.childIv);
        }
        d(item);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopClassifyChildView.c(TroopClassifyChildView.this, containerView, childContainerView, item, view);
            }
        });
    }

    public final void g(boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, open);
        } else if (open) {
            this.childArrowIv.setImageResource(R.drawable.qui_chevron_up_icon_secondary_01);
        } else {
            this.childArrowIv.setImageResource(R.drawable.qui_chevron_down_icon_secondary);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyChildView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopClassifyChildView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyChildView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<b> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.curItems = emptyList;
        setOrientation(0);
        View.inflate(context, R.layout.f169144hz1, this);
        int a16 = ViewUtils.f352270a.a(16.0f);
        setPadding(a16, 0, a16, 0);
        View findViewById = findViewById(R.id.tx8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.classify_child_iv)");
        this.childIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tx9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.classify_child_text)");
        this.childTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tx7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.classify_child_arrow)");
        this.childArrowIv = (ImageView) findViewById3;
    }
}
