package com.tencent.robot.adelie.homepage.create.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0001\u0018B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0005\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0007J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010)\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView;", "Landroid/widget/HorizontalScrollView;", "Lcom/tencent/robot/adelie/homepage/create/view/w;", "", "o", "", "index", "", "text", "f", "", "l", "", "list", "setLabelList", "", "i", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView$a$a;", "listener", "setOnItemClickListener", "p", "j", "labelName", "k", "a", "Lhn2/b;", "d", "Lkotlin/Lazy;", tl.h.F, "()Lhn2/b;", "binding", "e", "Ljava/util/List;", "labelDataList", "", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelItemView;", "Ljava/util/Map;", "labelViewMap", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView$a$a;", "itemClickListener", "", "Ljava/util/Set;", "selectedlabelSet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieLabelListView extends HorizontalScrollView implements w {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> labelDataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, AdelieLabelItemView> labelViewMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Companion.InterfaceC9754a itemClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<String> selectedlabelSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int C = c24.a.a(61);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView$a;", "", "", "LABEL_HEIGHT", "I", "a", "()I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.view.AdelieLabelListView$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView$a$a;", "", "Landroid/view/View;", "v", "", "text", "", "H", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.adelie.homepage.create.view.AdelieLabelListView$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public interface InterfaceC9754a {
            void H(@NotNull View v3, @NotNull String text);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return AdelieLabelListView.C;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieLabelListView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f(int index, String text) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (index != 0) {
            layoutParams.leftMargin = c24.a.a(6);
            layoutParams.setMarginStart(c24.a.a(6));
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        final AdelieLabelItemView adelieLabelItemView = new AdelieLabelItemView(context, null, 0, 6, null);
        adelieLabelItemView.setText(text);
        h().f405342b.addView(adelieLabelItemView, layoutParams);
        adelieLabelItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdelieLabelListView.g(AdelieLabelListView.this, adelieLabelItemView, view);
            }
        });
        this.labelViewMap.put(text, adelieLabelItemView);
        com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, adelieLabelItemView, "em_bas_label_selection", null, null, null, null, null, 124, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AdelieLabelListView this$0, AdelieLabelItemView itemView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Companion.InterfaceC9754a interfaceC9754a = this$0.itemClickListener;
        if (interfaceC9754a != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            interfaceC9754a.H(view, itemView.d().toString());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hn2.b h() {
        return (hn2.b) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String str, final AdelieLabelListView this$0) {
        String replace$default;
        String replace$default2;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Sequence<MatchResult> findAll$default = Regex.findAll$default(AdelieWrapperSettingWatcher.INSTANCE.a(), str, 0, 2, null);
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MatchResult matchResult : findAll$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str.subSequence(matchResult.getRange().getFirst(), matchResult.getRange().getLast() + 1).toString(), "#", "", false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, " ", "", false, 4, (Object) null);
            Iterator<T> it = this$0.labelDataList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(replace$default2, (String) obj)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            String str2 = (String) obj;
            if (str2 != null) {
                linkedHashSet.add(str2);
            }
        }
        this$0.selectedlabelSet = linkedHashSet;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.view.j
            @Override // java.lang.Runnable
            public final void run() {
                AdelieLabelListView.n(AdelieLabelListView.this, linkedHashSet);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AdelieLabelListView this$0, Set selectedSet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedSet, "$selectedSet");
        for (Map.Entry<String, AdelieLabelItemView> entry : this$0.labelViewMap.entrySet()) {
            entry.getValue().setSelected(selectedSet.contains(entry.getKey()));
        }
    }

    private final void o() {
        FontSettingManager.resetViewSize2Normal(getContext(), h().getMContainer());
        h().f405342b.removeAllViews();
        this.labelViewMap.clear();
        Iterator<String> it = this.labelDataList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            f(i3, it.next());
            i3++;
        }
    }

    @Override // com.tencent.robot.adelie.homepage.create.view.w
    public void a(@Nullable final String text) {
        boolean z16;
        if (this.labelViewMap.isEmpty()) {
            return;
        }
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            for (Map.Entry<String, AdelieLabelItemView> entry : this.labelViewMap.entrySet()) {
                entry.getKey();
                entry.getValue().setSelected(false);
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.view.i
            @Override // java.lang.Runnable
            public final void run() {
                AdelieLabelListView.m(text, this);
            }
        }, 16, null, true);
    }

    @NotNull
    public final List<String> i() {
        return this.labelDataList;
    }

    public final void j() {
        setVisibility(8);
    }

    public final boolean k(@NotNull String labelName) {
        Intrinsics.checkNotNullParameter(labelName, "labelName");
        return this.selectedlabelSet.contains(labelName);
    }

    public final boolean l() {
        return !this.labelDataList.isEmpty();
    }

    public final void p() {
        Map mapOf;
        setVisibility(0);
        for (Map.Entry<String, AdelieLabelItemView> entry : this.labelViewMap.entrySet()) {
            String key = entry.getKey();
            AdelieLabelItemView value = entry.getValue();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tag_text", key));
            VideoReport.reportEvent("imp", value, mapOf);
        }
    }

    public final void setLabelList(@Nullable List<String> list) {
        List list2;
        QLog.i("AdelieLabelListView", 1, "setLabelList = " + list);
        this.labelDataList.clear();
        if (list != null) {
            List<String> list3 = this.labelDataList;
            list2 = CollectionsKt___CollectionsKt.toList(list);
            list3.addAll(list2);
        }
        o();
    }

    public final void setOnItemClickListener(@NotNull Companion.InterfaceC9754a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemClickListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieLabelListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieLabelListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieLabelListView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<hn2.b>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieLabelListView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final hn2.b invoke() {
                return hn2.b.f(LayoutInflater.from(context), this);
            }
        });
        this.binding = lazy;
        this.labelDataList = new ArrayList();
        this.labelViewMap = new LinkedHashMap();
        this.selectedlabelSet = new LinkedHashSet();
    }
}
