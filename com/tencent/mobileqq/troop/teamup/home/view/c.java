package com.tencent.mobileqq.troop.teamup.home.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.ITroopPreviewMediaApi;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWItemLoadImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00052\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010&R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/view/c;", "", "Landroid/widget/LinearLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/widget/TextView;", "f", "Lcom/tencent/mobileqq/troop/teamup/home/data/a;", "data", "", h.F, "b", "c", "", "index", "k", "i", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ImageItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "e", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ImageItem;)Ljava/lang/Float;", "j", "Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;", "a", "Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;", "getDisplayView", "()Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;", "displayView", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/jvm/functions/Function1;", "getBindPictureReport", "()Lkotlin/jvm/functions/Function1;", "g", "(Lkotlin/jvm/functions/Function1;)V", "bindPictureReport", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWItemLoadImageView;", "Ljava/util/List;", "imageViewList", "d", "Landroid/widget/TextView;", "contentView", "Lcom/tencent/mobileqq/troop/teamup/home/data/a;", "currentData", "<init>", "(Lcom/tencent/mobileqq/troop/teamup/home/view/MediaDisplayView;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaDisplayView displayView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> bindPictureReport;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<HWItemLoadImageView> imageViewList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.teamup.home.data.a currentData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/view/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.view.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55892);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull MediaDisplayView displayView) {
        Intrinsics.checkNotNullParameter(displayView, "displayView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) displayView);
            return;
        }
        this.displayView = displayView;
        this.imageViewList = new ArrayList();
        this.contentView = f(displayView.e());
    }

    private final void b(com.tencent.mobileqq.troop.teamup.home.data.a data) {
        int size = data.b().size();
        if (size <= this.imageViewList.size()) {
            return;
        }
        int size2 = size - this.imageViewList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            c();
        }
    }

    private final void c() {
        Context context = this.displayView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        HWItemLoadImageView hWItemLoadImageView = new HWItemLoadImageView(context, null, 2, 0 == true ? 1 : 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT);
        marginLayoutParams.topMargin = e.a(8.0f);
        final int size = this.imageViewList.size();
        hWItemLoadImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.home.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.d(c.this, size, view);
            }
        });
        this.imageViewList.add(hWItemLoadImageView);
        this.displayView.e().addView(hWItemLoadImageView, marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Float e(ImageItem item) {
        float height = item.getHeight();
        float width = item.getWidth();
        if (height > 0.0f && width > 0.0f) {
            return Float.valueOf(width / height);
        }
        return null;
    }

    private final TextView f(LinearLayout parent) {
        Context context = parent.getContext();
        TextView textView = new TextView(context);
        textView.setTextColor(context.getColorStateList(R.color.qui_common_text_primary));
        textView.setTextSize(17.0f);
        parent.addView(textView, new ViewGroup.LayoutParams(-1, -2));
        return textView;
    }

    private final void h(com.tencent.mobileqq.troop.teamup.home.data.a data) {
        this.contentView.setText(new QQText(data.a(), 11, 20));
    }

    private final void i(com.tencent.mobileqq.troop.teamup.home.data.a data) {
        Unit unit;
        List<ImageItem> b16 = data.b();
        List<HWItemLoadImageView> list = this.imageViewList;
        if (b16.size() > list.size()) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("MediaDisplayViewController", "impossible imageList.size > imageViewList.size");
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 >= b16.size()) {
                list.get(i3).setVisibility(8);
            } else {
                list.get(i3).setVisibility(0);
                Float e16 = e(b16.get(i3));
                if (e16 != null) {
                    list.get(i3).setRatio(e16.floatValue());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d("MediaDisplayViewController", "got ratio error:" + b16.get(i3).getWidth() + "," + b16.get(i3).getHeight());
                }
                list.get(i3).p(b16.get(i3));
                Function1<? super View, Unit> function1 = this.bindPictureReport;
                if (function1 != null) {
                    function1.invoke(list.get(i3));
                }
            }
        }
    }

    private final void k(int index) {
        List<ImageItem> b16;
        Activity activity;
        com.tencent.mobileqq.troop.teamup.home.data.a aVar = this.currentData;
        if (aVar != null && (b16 = aVar.b()) != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<T> it = b16.iterator();
            while (it.hasNext()) {
                String httpUrl = ((ImageItem) it.next()).getHttpUrl();
                if (httpUrl != null) {
                    arrayList.add(httpUrl);
                }
            }
            Context context = this.displayView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("MediaDisplayViewController", "showFullScreenImage but activity is " + this.displayView.getContext());
                return;
            }
            ((ITroopPreviewMediaApi) QRoute.api(ITroopPreviewMediaApi.class)).showPicture(activity, index, arrayList);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("MediaDisplayViewController", "showFullScreenImage but currentData is null");
    }

    public final void g(@Nullable Function1<? super View, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function1);
        } else {
            this.bindPictureReport = function1;
        }
    }

    public final void j(@NotNull com.tencent.mobileqq.troop.teamup.home.data.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentData = data;
        h(data);
        b(data);
        i(data);
    }
}
