package com.tencent.mobileqq.troop.troopcreate.classify.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopcreate.event.TroopChangeClassEvent;
import com.tencent.mobileqq.troop.utils.ay;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyNewItemView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "e", "d", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/d;", DownloadInfo.spKey_Config, "", "isFromSettingPage", "", "categoryId", "b", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "childIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "childTv", "", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/b;", "f", "Ljava/util/List;", "curItems", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopClassifyNewItemView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static WeakReference<TroopClassifyNewItemView> f300062i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView childIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView childTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<b> curItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyNewItemView$a;", "", "", "TAG", "Ljava/lang/String;", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyNewItemView;", "curSelectViewRef", "Lmqq/util/WeakReference;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.classify.detail.TroopClassifyNewItemView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyNewItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(boolean z16, a item, String categoryId, TroopClassifyNewItemView this$0, View view) {
        TroopClassifyNewItemView troopClassifyNewItemView;
        TextView textView;
        TroopClassifyNewItemView troopClassifyNewItemView2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(categoryId, "$categoryId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && !Intrinsics.areEqual(item.g(), categoryId)) {
            view.setBackgroundResource(R.drawable.lvy);
            ((TextView) view.findViewById(R.id.txe)).setTextColor(this$0.getContext().getColor(R.color.qui_common_brand_standard));
            WeakReference<TroopClassifyNewItemView> weakReference = f300062i;
            if (weakReference != null && (troopClassifyNewItemView2 = weakReference.get()) != null) {
                troopClassifyNewItemView2.setBackgroundResource(R.color.ajr);
            }
            WeakReference<TroopClassifyNewItemView> weakReference2 = f300062i;
            if (weakReference2 != null && (troopClassifyNewItemView = weakReference2.get()) != null && (textView = troopClassifyNewItemView.childTv) != null) {
                textView.setTextColor(this$0.getContext().getColor(R.color.qui_common_text_primary));
            }
            f300062i = new WeakReference<>(this$0);
            SimpleEventBus.getInstance().dispatchEvent(new TroopChangeClassEvent(item.g()));
        } else if (!z16) {
            this$0.e(item);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d(a item) {
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
        QLog.i("TroopClassifyNewItemView", 1, "[jumpToH5] item:" + item);
    }

    private final void e(a item) {
        boolean z16 = true;
        if (u.a().b()) {
            QLog.i("TroopClassifyNewItemView", 1, "[onClickItem] fast click");
            return;
        }
        if (item.i().length() <= 0) {
            z16 = false;
        }
        if (z16) {
            d(item);
        }
    }

    public final void b(@NotNull d config, @NotNull final a item, final boolean isFromSettingPage, @NotNull final String categoryId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, config, item, Boolean.valueOf(isFromSettingPage), categoryId);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
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
        if (isFromSettingPage && Intrinsics.areEqual(item.g(), categoryId)) {
            setBackgroundResource(R.drawable.lvy);
            this.childTv.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
            f300062i = new WeakReference<>(this);
        } else {
            setBackgroundResource(R.color.ajr);
            this.childTv.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        if (QQTheme.isNowThemeIsNight()) {
            ay.f302095a.a(item.f(), this.childIv);
        } else {
            ay.f302095a.a(item.e(), this.childIv);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.detail.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopClassifyNewItemView.c(isFromSettingPage, item, categoryId, this, view);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyNewItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopClassifyNewItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyNewItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
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
        setOrientation(1);
        setGravity(17);
        View.inflate(context, R.layout.f168570fy2, this);
        View findViewById = findViewById(R.id.txd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.classify_type_iv)");
        this.childIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.txe);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.classify_type_text)");
        this.childTv = (TextView) findViewById2;
    }
}
