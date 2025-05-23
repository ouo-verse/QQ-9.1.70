package com.tencent.sqshow.zootopia.nativeui.view.experience;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b94.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartGoodsData;
import com.tencent.sqshow.zootopia.nativeui.data.cart.PriceType;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.experience.ExperienceCardDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.experience.b;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import uv4.au;
import uv4.az;
import uv4.bc;
import uv4.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00015B/\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001a\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCardDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BaseDragPanelDialogView;", "Luv4/az;", "storeItem", "", "g0", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "e0", "Landroid/view/View;", "view", "m0", "o0", "l0", "n0", "b0", "a0", "Lcom/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCardDialogView$ButtonShowType;", "c0", "N", "", "defaultSelectId", "Y", "onDismiss", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "d0", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", WadlProxyConsts.CHANNEL, "Ln74/j;", "K", "Ln74/j;", "dialogBinding", "L", "I", "mDefaultSelectId", "Landroidx/lifecycle/Observer;", "Luv4/au;", "M", "Landroidx/lifecycle/Observer;", "mObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "ButtonShowType", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ExperienceCardDialogView extends BaseDragPanelDialogView {

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: K, reason: from kotlin metadata */
    private final n74.j dialogBinding;

    /* renamed from: L, reason: from kotlin metadata */
    private int mDefaultSelectId;

    /* renamed from: M, reason: from kotlin metadata */
    private Observer<au> mObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCardDialogView$ButtonShowType;", "", "(Ljava/lang/String;I)V", "SHOW_ERROR", "SHOW_BUY", "SHOW_USE", "SHOW_DOUBLE", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum ButtonShowType {
        SHOW_ERROR,
        SHOW_BUY,
        SHOW_USE,
        SHOW_DOUBLE
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371851a;

        static {
            int[] iArr = new int[ButtonShowType.values().length];
            try {
                iArr[ButtonShowType.SHOW_DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonShowType.SHOW_BUY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonShowType.SHOW_USE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f371851a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCardDialogView$b", "Lcom/tencent/sqshow/zootopia/nativeui/view/experience/b$a;", "", "position", "Luv4/az;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.view.experience.b f371853b;

        b(com.tencent.sqshow.zootopia.nativeui.view.experience.b bVar) {
            this.f371853b = bVar;
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.view.experience.b.a
        public void a(int position, az item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ExperienceCardDialogView.this.g0(this.f371853b.k0());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCardDialogView$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f371854d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f371855e;

        c(int i3, int i16) {
            this.f371854d = i3;
            this.f371855e = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (childAdapterPosition < (adapter != null ? adapter.getItemCount() : 0)) {
                outRect.right = this.f371854d;
            }
            view.getLayoutParams().width = this.f371855e;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCardDialogView$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/g;", "result", "", "d", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<uv4.g> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        
            if (r3 != false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void c(int i3, String str, ExperienceCardDialogView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.e("BaseDragPanelDialogView", 1, "onResultFailure " + i3 + ", " + str);
            if (i3 == -100) {
                boolean z16 = false;
                if (str != null) {
                    if (str.length() > 0) {
                        z16 = true;
                    }
                }
            }
            str = "\u8d2d\u4e70\u5931\u8d25";
            QQToast.makeText(this$0.getContext(), 1, str, 1).show();
            this$0.o();
            b94.e O = this$0.getChannel().O();
            if (O != null) {
                O.S2();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ExperienceCardDialogView this$0, uv4.g result) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            QLog.i("BaseDragPanelDialogView", 1, "onResultSuccess ");
            QQToast.makeText(this$0.getContext(), 2, "\u8d2d\u4e70\u6210\u529f", 1).show();
            this$0.o();
            com.tencent.sqshow.zootopia.nativeui.data.l storeItemPool = this$0.getChannel().getStoreItemPool();
            az[] azVarArr = result.f440422d;
            Intrinsics.checkNotNullExpressionValue(azVarArr, "result.storeItems");
            storeItemPool.d(azVarArr);
            b94.e O = this$0.getChannel().O();
            if (O != null) {
                O.S2();
            }
            m.f371882a.b();
            yb4.e.g(yb4.e.f450058a, "bugSucc", 0, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final uv4.g result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ExperienceCardDialogView experienceCardDialogView = ExperienceCardDialogView.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.j
                @Override // java.lang.Runnable
                public final void run() {
                    ExperienceCardDialogView.d.e(ExperienceCardDialogView.this, result);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(final int error, final String message) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ExperienceCardDialogView experienceCardDialogView = ExperienceCardDialogView.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.i
                @Override // java.lang.Runnable
                public final void run() {
                    ExperienceCardDialogView.d.c(error, message, experienceCardDialogView);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCardDialogView$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bv;", "result", "", "d", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<bv> {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ExperienceCardDialogView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQToast.makeText(this$0.getContext(), 1, "\u4f7f\u7528\u5931\u8d25", 1).show();
            this$0.o();
            b94.e O = this$0.getChannel().O();
            if (O != null) {
                O.S2();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ExperienceCardDialogView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQToast.makeText(this$0.getContext(), 2, "\u4f7f\u7528\u6210\u529f", 1).show();
            this$0.o();
            m.f371882a.b();
            b94.e O = this$0.getChannel().O();
            if (O != null) {
                O.S2();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bv result) {
            Intrinsics.checkNotNullParameter(result, "result");
            final ExperienceCardDialogView experienceCardDialogView = ExperienceCardDialogView.this;
            experienceCardDialogView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.l
                @Override // java.lang.Runnable
                public final void run() {
                    ExperienceCardDialogView.e.e(ExperienceCardDialogView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            final ExperienceCardDialogView experienceCardDialogView = ExperienceCardDialogView.this;
            experienceCardDialogView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.k
                @Override // java.lang.Runnable
                public final void run() {
                    ExperienceCardDialogView.e.c(ExperienceCardDialogView.this);
                }
            });
        }
    }

    public /* synthetic */ ExperienceCardDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ExperienceCardDialogView this$0, int i3, au auVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialogBinding.f419356f.setText(auVar.f440234c);
        this$0.dialogBinding.f419355e.setText(auVar.f440235d);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        az[] azVarArr = auVar.f440233b;
        Intrinsics.checkNotNullExpressionValue(azVarArr, "it.experienceCards");
        com.tencent.sqshow.zootopia.nativeui.view.experience.b bVar = new com.tencent.sqshow.zootopia.nativeui.view.experience.b(context, azVarArr, i3);
        this$0.dialogBinding.f419354d.setAdapter(bVar);
        bVar.o0(new b(bVar));
        this$0.g0(bVar.k0());
    }

    private final void b0(az storeItem) {
        b94.e O = this.channel.O();
        if (O != null) {
            e.a.h(O, 0L, 1, null);
        }
        m.f371882a.c(storeItem.f440275b, 1, new e());
    }

    private final ButtonShowType c0(az storeItem) {
        boolean z16 = false;
        boolean z17 = storeItem.f440295v > 0;
        bc bcVar = storeItem.f440287n;
        if (bcVar != null && bcVar.f440312a == 0) {
            z16 = true;
        }
        boolean z18 = !z16;
        if (z17 && z18) {
            return ButtonShowType.SHOW_DOUBLE;
        }
        if (z17) {
            return ButtonShowType.SHOW_USE;
        }
        if (z18) {
            return ButtonShowType.SHOW_BUY;
        }
        return ButtonShowType.SHOW_ERROR;
    }

    private final HashMap<String, Object> e0(az storeItem) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_item_id", r94.b.K(storeItem));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(final az storeItem) {
        int i3 = a.f371851a[c0(storeItem).ordinal()];
        if (i3 == 1) {
            this.dialogBinding.f419353c.setVisibility(0);
            this.dialogBinding.f419352b.setVisibility(0);
            this.dialogBinding.f419352b.setText(getContext().getString(R.string.xm8));
            this.dialogBinding.f419353c.setText(getContext().getString(R.string.xwj));
            this.dialogBinding.f419352b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExperienceCardDialogView.h0(ExperienceCardDialogView.this, storeItem, view);
                }
            });
            this.dialogBinding.f419353c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExperienceCardDialogView.i0(ExperienceCardDialogView.this, storeItem, view);
                }
            });
            Button button = this.dialogBinding.f419353c;
            Intrinsics.checkNotNullExpressionValue(button, "dialogBinding.btnRight");
            o0(button, storeItem);
            Button button2 = this.dialogBinding.f419352b;
            Intrinsics.checkNotNullExpressionValue(button2, "dialogBinding.btnLeft");
            m0(button2, storeItem);
            return;
        }
        if (i3 == 2) {
            this.dialogBinding.f419352b.setVisibility(8);
            this.dialogBinding.f419353c.setVisibility(0);
            this.dialogBinding.f419353c.setText(getContext().getString(R.string.xm8));
            Button button3 = this.dialogBinding.f419353c;
            Intrinsics.checkNotNullExpressionValue(button3, "dialogBinding.btnRight");
            aa.d(button3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExperienceCardDialogView.j0(ExperienceCardDialogView.this, storeItem, view);
                }
            });
            Button button4 = this.dialogBinding.f419353c;
            Intrinsics.checkNotNullExpressionValue(button4, "dialogBinding.btnRight");
            m0(button4, storeItem);
            return;
        }
        if (i3 != 3) {
            QLog.e("ExperienceCardDialogView", 1, "\u9519\u8bef\u6570\u636e\uff0c\u6309\u94ae\u663e\u793a\u5224\u65ad\u903b\u8f91\u9519\u8bef\u3002" + storeItem);
            return;
        }
        this.dialogBinding.f419352b.setVisibility(8);
        this.dialogBinding.f419353c.setVisibility(0);
        this.dialogBinding.f419353c.setText(getContext().getString(R.string.xwj));
        Button button5 = this.dialogBinding.f419353c;
        Intrinsics.checkNotNullExpressionValue(button5, "dialogBinding.btnRight");
        aa.d(button5, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCardDialogView.k0(ExperienceCardDialogView.this, storeItem, view);
            }
        });
        Button button6 = this.dialogBinding.f419353c;
        Intrinsics.checkNotNullExpressionValue(button6, "dialogBinding.btnRight");
        o0(button6, storeItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ExperienceCardDialogView this$0, az storeItem, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storeItem, "$storeItem");
        this$0.a0(storeItem);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.l0(it, storeItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(ExperienceCardDialogView this$0, az storeItem, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storeItem, "$storeItem");
        this$0.b0(storeItem);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.n0(it, storeItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(ExperienceCardDialogView this$0, az storeItem, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storeItem, "$storeItem");
        this$0.a0(storeItem);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.l0(it, storeItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(ExperienceCardDialogView this$0, az storeItem, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storeItem, "$storeItem");
        this$0.b0(storeItem);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.n0(it, storeItem);
    }

    private final void l0(View view, az storeItem) {
        this.channel.getReporter().getMReporter().e(view, "em_zplan_dye_fade_renewal_purchase", e0(storeItem));
    }

    private final void m0(View view, az storeItem) {
        this.channel.getReporter().getMReporter().g(view, "em_zplan_dye_fade_renewal_purchase", (r16 & 4) != 0 ? null : e0(storeItem), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void n0(View view, az storeItem) {
        this.channel.getReporter().getMReporter().e(view, "em_zplan_dye_fade_renewal_use", e0(storeItem));
    }

    private final void o0(View view, az storeItem) {
        this.channel.getReporter().getMReporter().g(view, "em_zplan_dye_fade_renewal_use", (r16 & 4) != 0 ? null : e0(storeItem), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView
    public View N() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.dialogBinding.f419354d.setLayoutManager(linearLayoutManager);
        int c16 = u.INSTANCE.c(getContext());
        int b16 = com.tencent.sqshow.zootopia.utils.i.b(16);
        int b17 = com.tencent.sqshow.zootopia.utils.i.b(8);
        this.dialogBinding.f419354d.addItemDecoration(new c(b17, ((c16 - (b16 * 2)) - (b17 * 2)) / 3));
        LinearLayout root = this.dialogBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "dialogBinding.root");
        return root;
    }

    public final void Y(final int defaultSelectId) {
        this.mDefaultSelectId = defaultSelectId;
        m mVar = m.f371882a;
        mVar.a().removeObserver(this.mObserver);
        this.mObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExperienceCardDialogView.Z(ExperienceCardDialogView.this, defaultSelectId, (au) obj);
            }
        };
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            mVar.a().observe(lifecycleOwner, this.mObserver);
        }
    }

    /* renamed from: d0, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getChannel() {
        return this.channel;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onDismiss() {
        super.onDismiss();
        m.f371882a.a().removeObserver(this.mObserver);
    }

    public final void setChannel(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.channel = jVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperienceCardDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        n74.j g16 = n74.j.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.dialogBinding = g16;
        this.mDefaultSelectId = -1;
        this.mObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExperienceCardDialogView.f0((au) obj);
            }
        };
    }

    private final void a0(az storeItem) {
        b94.e O = this.channel.O();
        if (O != null) {
            e.a.h(O, 0L, 1, null);
        }
        CartGoodsData cartGoodsData = new CartGoodsData(true, PriceType.GOAL_FIRST, storeItem, 0, 8, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cartGoodsData);
        bc bcVar = storeItem.f440287n;
        AvatarCommonOperateHelper.f371049a.f(AvatarCommonOperateHelper.BuySource.SOURCE_EXPERIENCE_CARD, this.channel, arrayList, bcVar.f440313b, bcVar.f440314c, (r17 & 32) != 0 ? com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex() : 0, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(au auVar) {
    }
}
