package com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.HWClockInRole;
import com.tencent.mobileqq.troop.homework.clockin.c;
import com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.Status;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B.\u0012%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016R1\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/adapter/b;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/adapter/b$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "j0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "clickEventCallback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends ListAdapter<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, C8709b> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit> clickEventCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/adapter/b$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a oldItem, @NotNull com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.e() == newItem.e()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a oldItem, @NotNull com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return c.f296281a.c(oldItem.f(), newItem.f());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001c\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/adapter/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "p", "o", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "info", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "E", "Landroid/view/ViewGroup;", "rootLayout", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "dayTextView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "tickImageView", "H", "statusTextView", "Landroid/content/Context;", "I", "Landroid/content/Context;", "context", "J", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "dateInfo", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8709b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        private final ViewGroup rootLayout;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView dayTextView;

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView tickImageView;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView statusTextView;

        /* renamed from: I, reason: from kotlin metadata */
        private final Context context;

        /* renamed from: J, reason: from kotlin metadata */
        private com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a dateInfo;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b$b$a */
        /* loaded from: classes19.dex */
        public /* synthetic */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f296429a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42848);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[Status.values().length];
                try {
                    iArr[Status.STATUS_CLOCK_IN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Status.STATUS_MAKE_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Status.STATUS_UN_CLOCK_IN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f296429a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8709b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            this.rootLayout = (ViewGroup) itemView.findViewById(R.id.root_layout);
            this.dayTextView = (TextView) itemView.findViewById(R.id.uea);
            this.tickImageView = (ImageView) itemView.findViewById(R.id.f97205jr);
            this.statusTextView = (TextView) itemView.findViewById(R.id.f88294wo);
            this.context = itemView.getContext();
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
        
            if (r0.g() != false) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void l() {
            int i3;
            TextView textView = this.dayTextView;
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar = this.dateInfo;
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar = null;
            }
            textView.setText(aVar.a());
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar3 = this.dateInfo;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar3 = null;
            }
            if (aVar3.h()) {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar4 = this.dateInfo;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar4 = null;
                }
                if (!aVar4.g()) {
                    i3 = R.color.qui_common_brand_standard;
                    this.dayTextView.setTextColor(ContextCompat.getColor(this.context, i3));
                }
            }
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar5 = this.dateInfo;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar5 = null;
            }
            if (!aVar5.h()) {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar6 = this.dateInfo;
                if (aVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar6 = null;
                }
                if (aVar6.i()) {
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar7 = this.dateInfo;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                        aVar7 = null;
                    }
                }
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar8 = this.dateInfo;
                if (aVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                } else {
                    aVar2 = aVar8;
                }
                if (aVar2.i()) {
                    i3 = R.color.qui_common_text_primary;
                } else {
                    i3 = R.color.qui_common_text_tertiary;
                }
                this.dayTextView.setTextColor(ContextCompat.getColor(this.context, i3));
            }
            i3 = R.color.qui_common_text_allwhite_primary;
            this.dayTextView.setTextColor(ContextCompat.getColor(this.context, i3));
        }

        private final void m() {
            ViewGroup viewGroup = this.rootLayout;
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar = this.dateInfo;
            Drawable drawable = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar = null;
            }
            if (aVar.g()) {
                drawable = ContextCompat.getDrawable(this.context, R.drawable.f161557kd1);
            } else {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar2 = this.dateInfo;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar2 = null;
                }
                if (aVar2.h()) {
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar3 = this.dateInfo;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                        aVar3 = null;
                    }
                    if (!aVar3.g()) {
                        drawable = ContextCompat.getDrawable(this.context, R.drawable.f161560kd4);
                    }
                }
            }
            viewGroup.setBackground(drawable);
        }

        private final void o() {
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar = this.dateInfo;
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar = null;
            }
            if (aVar.d() == HWClockInRole.ROLE_TEACHER) {
                TextView textView = this.statusTextView;
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar3 = this.dateInfo;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar3 = null;
                }
                textView.setText(aVar3.c());
            } else {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar4 = this.dateInfo;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar4 = null;
                }
                String str = "\u5df2\u6253";
                if (aVar4.h()) {
                    TextView textView2 = this.statusTextView;
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar5 = this.dateInfo;
                    if (aVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                        aVar5 = null;
                    }
                    if (aVar5.e() != Status.STATUS_CLOCK_IN) {
                        com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar6 = this.dateInfo;
                        if (aVar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                            aVar6 = null;
                        }
                        str = aVar6.c();
                    }
                    textView2.setText(str);
                } else {
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar7 = this.dateInfo;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                        aVar7 = null;
                    }
                    if (aVar7.i()) {
                        TextView textView3 = this.statusTextView;
                        com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar8 = this.dateInfo;
                        if (aVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                            aVar8 = null;
                        }
                        int i3 = a.f296429a[aVar8.e().ordinal()];
                        if (i3 != 1 && i3 != 2) {
                            if (i3 != 3) {
                                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar9 = this.dateInfo;
                                if (aVar9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                                    aVar9 = null;
                                }
                                str = aVar9.c();
                            } else {
                                str = "\u7f3a\u5361";
                            }
                        }
                        textView3.setText(str);
                    } else {
                        TextView textView4 = this.statusTextView;
                        com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar10 = this.dateInfo;
                        if (aVar10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                            aVar10 = null;
                        }
                        textView4.setText(aVar10.c());
                    }
                }
            }
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar11 = this.dateInfo;
            if (aVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar11 = null;
            }
            boolean h16 = aVar11.h();
            int i16 = R.color.qui_common_text_allwhite_primary;
            if (h16) {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar12 = this.dateInfo;
                if (aVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                } else {
                    aVar2 = aVar12;
                }
                if (!aVar2.g()) {
                    i16 = R.color.qui_common_brand_standard;
                }
            } else {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar13 = this.dateInfo;
                if (aVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar13 = null;
                }
                if (aVar13.i()) {
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar14 = this.dateInfo;
                    if (aVar14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    } else {
                        aVar2 = aVar14;
                    }
                    if (!aVar2.g()) {
                        i16 = R.color.qui_common_text_primary;
                    }
                } else {
                    i16 = R.color.qui_common_text_tertiary;
                }
            }
            this.statusTextView.setTextColor(ContextCompat.getColor(this.context, i16));
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x008b, code lost:
        
            if (r0.g() != false) goto L56;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void p() {
            Integer valueOf;
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar = this.dateInfo;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar = null;
            }
            if (aVar.d() == HWClockInRole.ROLE_TEACHER) {
                this.tickImageView.setBackground(null);
                this.tickImageView.setVisibility(8);
                return;
            }
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar2 = this.dateInfo;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                aVar2 = null;
            }
            int i3 = a.f296429a[aVar2.e().ordinal()];
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar3 = this.dateInfo;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                        aVar3 = null;
                    }
                    if (!aVar3.h()) {
                        com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar4 = this.dateInfo;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                            aVar4 = null;
                        }
                        if (aVar4.g()) {
                            valueOf = Integer.valueOf(R.drawable.f161558kd2);
                        } else {
                            valueOf = Integer.valueOf(R.drawable.f161559kd3);
                        }
                    }
                }
                valueOf = null;
            } else {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar5 = this.dateInfo;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar5 = null;
                }
                boolean h16 = aVar5.h();
                int i16 = R.drawable.kd7;
                if (h16) {
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar6 = this.dateInfo;
                    if (aVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                        aVar6 = null;
                    }
                }
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar7 = this.dateInfo;
                if (aVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                    aVar7 = null;
                }
                if (aVar7.h()) {
                    i16 = R.drawable.kd5;
                } else {
                    com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar8 = this.dateInfo;
                    if (aVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateInfo");
                        aVar8 = null;
                    }
                    if (!aVar8.g()) {
                        i16 = R.drawable.kd6;
                    }
                }
                valueOf = Integer.valueOf(i16);
            }
            ImageView imageView = this.tickImageView;
            if (valueOf == null) {
                imageView.setBackground(null);
                imageView.setVisibility(8);
            } else {
                imageView.setBackground(ContextCompat.getDrawable(imageView.getContext(), valueOf.intValue()));
                imageView.setVisibility(0);
            }
        }

        public final void q(@NotNull com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            this.dateInfo = info;
            m();
            l();
            p();
            o();
        }
    }

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a dateInfo, b this$0, View view) {
        Function1<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit> function1;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dateInfo.i() && (function1 = this$0.clickEventCallback) != null) {
            Intrinsics.checkNotNullExpressionValue(dateInfo, "dateInfo");
            function1.invoke(dateInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C8709b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        final com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a dateInfo = getCurrentList().get(position);
        Intrinsics.checkNotNullExpressionValue(dateInfo, "dateInfo");
        holder.q(dateInfo);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.k0(com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a.this, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C8709b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C8709b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fzz, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026list_item, parent, false)");
        return new C8709b(inflate);
    }

    public /* synthetic */ b(Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, function1, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@Nullable Function1<? super com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit> function1) {
        super(new a());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.clickEventCallback = function1;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
        }
    }
}
