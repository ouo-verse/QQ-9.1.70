package com.tencent.mobileqq.troop.schooltoolbox.delegate;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.schooltoolbox.api.ISchoolToolHandleApi;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u0000 \u00062\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0006\u001a\u00020\u0005H&J\u0014\u0010\t\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0014J2\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00022\n\u0010\u000b\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/delegate/c;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/troop/schooltoolbox/data/b;", "Lcom/tencent/mobileqq/troop/schooltoolbox/data/c;", "Lcom/tencent/mobileqq/troop/schooltoolbox/delegate/c$b;", "", "f", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, tl.h.F, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "position", "", "", "payloads", "", "g", "Landroid/view/View$OnClickListener;", "d", "Landroid/view/View$OnClickListener;", "onclickListener", "Landroid/view/View$OnTouchListener;", "e", "Landroid/view/View$OnTouchListener;", "onTouchListener", "", "troopUin", "<init>", "(J)V", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class c extends AbsListItemAdapterDelegate<com.tencent.mobileqq.troop.schooltoolbox.data.b, com.tencent.mobileqq.troop.schooltoolbox.data.c, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    private static final int f298315h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onclickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener onTouchListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/delegate/c$a;", "", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.schooltoolbox.delegate.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/delegate/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Landroid/widget/ImageView;", "E", "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/List;", "imgList", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "p", "titleList", "G", "l", "descList", "Landroid/view/ViewGroup;", "H", "o", "setItemViewList", "(Ljava/util/List;)V", "itemViewList", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/troop/schooltoolbox/delegate/c;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final List<ImageView> imgList;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final List<TextView> titleList;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final List<TextView> descList;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private List<ViewGroup> itemViewList;
        final /* synthetic */ c I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull c cVar, View view) {
            super(view);
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(view, "view");
            this.I = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) view);
                return;
            }
            this.imgList = new ArrayList();
            this.titleList = new ArrayList();
            this.descList = new ArrayList();
            this.itemViewList = new ArrayList();
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                    List<ViewGroup> list = this.itemViewList;
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                    list.add((ViewGroup) childAt);
                    List<ImageView> list2 = this.imgList;
                    View findViewById = childAt.findViewById(R.id.df9);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.img)");
                    list2.add(findViewById);
                    List<TextView> list3 = this.titleList;
                    View findViewById2 = childAt.findViewById(R.id.title);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.title)");
                    list3.add(findViewById2);
                    List<TextView> list4 = this.descList;
                    View findViewById3 = childAt.findViewById(R.id.bg6);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.desc)");
                    list4.add(findViewById3);
                    TriggerRunnerKt.c(childAt, 0L, cVar.onclickListener, 1, null);
                    childAt.setOnTouchListener(cVar.onTouchListener);
                }
            }
        }

        @NotNull
        public final List<TextView> l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.descList;
        }

        @NotNull
        public final List<ImageView> m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.imgList;
        }

        @NotNull
        public final List<ViewGroup> o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.itemViewList;
        }

        @NotNull
        public final List<TextView> p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.titleList;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f298315h = 1;
        }
    }

    public c(final long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.onclickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.schooltoolbox.delegate.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.j(j3, view);
                }
            };
            this.onTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.schooltoolbox.delegate.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean i3;
                    i3 = c.i(view, motionEvent);
                    return i3;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setAlpha(0.5f);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            view.setAlpha(1.0f);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(long j3, View view) {
        com.tencent.mobileqq.troop.schooltoolbox.data.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.schooltoolbox.data.a) {
            aVar = (com.tencent.mobileqq.troop.schooltoolbox.data.a) tag;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            ((ISchoolToolHandleApi) QRoute.api(ISchoolToolHandleApi.class)).handlerAppAction(view.getContext(), com.tencent.relation.common.utils.b.a(), String.valueOf(j3), aVar.a(), aVar.d(), f298315h, 0, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public abstract int f();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.troop.schooltoolbox.data.b item, @NotNull b holder, int position, @NotNull List<Object> payloads) {
        boolean z16;
        Object orNull;
        Object orNull2;
        Object orNull3;
        Object orNull4;
        Object orNull5;
        Object orNull6;
        Object orNull7;
        Object orNull8;
        Object orNull9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, item, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        int i3 = 0;
        for (Object obj : holder.o()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            orNull6 = CollectionsKt___CollectionsKt.getOrNull(holder.m(), i3);
            ImageView imageView = (ImageView) orNull6;
            if (imageView != null) {
                imageView.setImageResource(0);
            }
            orNull7 = CollectionsKt___CollectionsKt.getOrNull(holder.p(), i3);
            TextView textView = (TextView) orNull7;
            if (textView != null) {
                textView.setText((CharSequence) null);
            }
            orNull8 = CollectionsKt___CollectionsKt.getOrNull(holder.l(), i3);
            TextView textView2 = (TextView) orNull8;
            if (textView2 != null) {
                textView2.setText((CharSequence) null);
            }
            orNull9 = CollectionsKt___CollectionsKt.getOrNull(holder.o(), i3);
            ViewGroup viewGroup = (ViewGroup) orNull9;
            if (viewGroup != null) {
                viewGroup.setTag(null);
            }
            i3 = i16;
        }
        int i17 = 0;
        for (Object obj2 : item.a()) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.troop.schooltoolbox.data.a aVar = (com.tencent.mobileqq.troop.schooltoolbox.data.a) obj2;
            if (aVar.c().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                orNull5 = CollectionsKt___CollectionsKt.getOrNull(holder.m(), i17);
                ImageView imageView2 = (ImageView) orNull5;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.qui_common_border_standard_bg);
                }
            } else {
                orNull = CollectionsKt___CollectionsKt.getOrNull(holder.m(), i17);
                ImageView imageView3 = (ImageView) orNull;
                if (imageView3 != null) {
                    imageView3.setImageDrawable(URLDrawable.getDrawable(aVar.c(), URLDrawable.URLDrawableOptions.obtain()));
                }
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(holder.p(), i17);
            TextView textView3 = (TextView) orNull2;
            if (textView3 != null) {
                textView3.setText(aVar.e());
            }
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(holder.l(), i17);
            TextView textView4 = (TextView) orNull3;
            if (textView4 != null) {
                textView4.setText(aVar.b());
            }
            orNull4 = CollectionsKt___CollectionsKt.getOrNull(holder.o(), i17);
            ViewGroup viewGroup2 = (ViewGroup) orNull4;
            if (viewGroup2 != null) {
                viewGroup2.setTag(aVar);
            }
            i17 = i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(f(), parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(this, view);
    }
}
