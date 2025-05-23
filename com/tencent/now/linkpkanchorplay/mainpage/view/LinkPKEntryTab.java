package com.tencent.now.linkpkanchorplay.mainpage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.now.linkpkanchorplay.entrance.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0018R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/LinkPKEntryTab;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "selectedTypeLiveData", "Lcom/tencent/now/linkpkanchorplay/entrance/a;", "e", "Lcom/tencent/now/linkpkanchorplay/entrance/a;", "apngResLoader", "", "", "f", "Ljava/util/List;", "tabItemList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LinkPKEntryTab extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> selectedTypeLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a apngResLoader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Object> tabItemList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPKEntryTab(@NotNull Context context) {
        super(context);
        List<String> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedTypeLiveData = new MutableLiveData<>();
        a aVar = new a();
        this.apngResLoader = aVar;
        this.tabItemList = new ArrayList();
        View.inflate(getContext(), R.layout.fe_, this);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEKxF1AQIwsnHSpc9aQZnSB2InY3ziaibj01yf8p2M9Ap1Sw/", "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDDiabAqnARBgOwlmztPcxu5LuFH7UkIEib9LtUrd3P0ksw/");
        aVar.a(mutableListOf);
        aVar.c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPKEntryTab(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        List<String> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedTypeLiveData = new MutableLiveData<>();
        a aVar = new a();
        this.apngResLoader = aVar;
        this.tabItemList = new ArrayList();
        View.inflate(getContext(), R.layout.fe_, this);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEKxF1AQIwsnHSpc9aQZnSB2InY3ziaibj01yf8p2M9Ap1Sw/", "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDDiabAqnARBgOwlmztPcxu5LuFH7UkIEib9LtUrd3P0ksw/");
        aVar.a(mutableListOf);
        aVar.c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPKEntryTab(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<String> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedTypeLiveData = new MutableLiveData<>();
        a aVar = new a();
        this.apngResLoader = aVar;
        this.tabItemList = new ArrayList();
        View.inflate(getContext(), R.layout.fe_, this);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEKxF1AQIwsnHSpc9aQZnSB2InY3ziaibj01yf8p2M9Ap1Sw/", "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDDiabAqnARBgOwlmztPcxu5LuFH7UkIEib9LtUrd3P0ksw/");
        aVar.a(mutableListOf);
        aVar.c();
    }
}
