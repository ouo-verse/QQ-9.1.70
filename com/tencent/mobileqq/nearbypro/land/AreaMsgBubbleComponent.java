package com.tencent.mobileqq.nearbypro.land;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.view.NearbyChatBubbleComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/AreaMsgBubbleComponent;", "Lcom/tencent/mobileqq/nearbypro/land/i;", "", "M9", "", "", TabPreloadItem.TAB_NAME_MESSAGE, "", "index", "", "delay", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "update", "Lcom/tencent/mobileqq/nearbypro/view/NearbyChatBubbleComponent;", "f", "Lcom/tencent/mobileqq/nearbypro/view/NearbyChatBubbleComponent;", "bubbleComponent", "Landroid/os/Handler;", tl.h.F, "Landroid/os/Handler;", "mainHandle", "i", "I", "curIndex", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AreaMsgBubbleComponent extends i {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NearbyChatBubbleComponent bubbleComponent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mainHandle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int curIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int C = (int) (d.INSTANCE.a() * 0.9f);
    private static int D = com.tencent.mobileqq.nearbypro.utils.d.b(70);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/AreaMsgBubbleComponent$a;", "", "", "BUBBLE_WIDTH_PX", "I", "a", "()I", "setBUBBLE_WIDTH_PX", "(I)V", "", "MSG_SHOW_DELAY_MILLISECOND", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.land.AreaMsgBubbleComponent$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return AreaMsgBubbleComponent.C;
        }

        Companion() {
        }
    }

    public AreaMsgBubbleComponent() {
        super(R.id.tsy);
        this.mainHandle = new Handler(Looper.getMainLooper());
    }

    private final void J9(final List<String> msgList, final int index, long delay) {
        this.mainHandle.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.land.g
            @Override // java.lang.Runnable
            public final void run() {
                AreaMsgBubbleComponent.L9(msgList, index, this);
            }
        }, delay);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void K9(AreaMsgBubbleComponent areaMsgBubbleComponent, List list, int i3, long j3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            j3 = 0;
        }
        areaMsgBubbleComponent.J9(list, i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void L9(List msgList, int i3, AreaMsgBubbleComponent this$0) {
        Object orNull;
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        orNull = CollectionsKt___CollectionsKt.getOrNull(msgList, i3);
        String str = (String) orNull;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    NearbyChatBubbleComponent nearbyChatBubbleComponent = this$0.bubbleComponent;
                    if (nearbyChatBubbleComponent != null) {
                        nearbyChatBubbleComponent.a(str);
                    }
                    int i16 = this$0.curIndex + 1;
                    this$0.curIndex = i16;
                    this$0.J9(msgList, i16, 2000L);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void M9() {
        LiveData<List<String>> R1 = ((za2.c) getViewModel(za2.c.class)).R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends String>, Unit> function1 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.nearbypro.land.AreaMsgBubbleComponent$initObserve$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> it) {
                Handler handler;
                int i3;
                ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                if (c16.isColorLevel()) {
                    c16.e("AreaMsgBubbleComponent", "area msgList update size=" + it.size());
                }
                AreaMsgBubbleComponent.this.curIndex = 0;
                handler = AreaMsgBubbleComponent.this.mainHandle;
                handler.removeCallbacksAndMessages(null);
                AreaMsgBubbleComponent areaMsgBubbleComponent = AreaMsgBubbleComponent.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                i3 = AreaMsgBubbleComponent.this.curIndex;
                AreaMsgBubbleComponent.K9(areaMsgBubbleComponent, it, i3, 0L, 4, null);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.nearbypro.land.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AreaMsgBubbleComponent.N9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.tsy);
        } else {
            viewGroup = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        NearbyChatBubbleComponent nearbyChatBubbleComponent = new NearbyChatBubbleComponent(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(C, D);
        layoutParams.gravity = 17;
        if (viewGroup != null) {
            viewGroup.addView(nearbyChatBubbleComponent, layoutParams);
        }
        this.bubbleComponent = nearbyChatBubbleComponent;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        this.mainHandle.removeCallbacksAndMessages(null);
        NearbyChatBubbleComponent nearbyChatBubbleComponent = this.bubbleComponent;
        if (nearbyChatBubbleComponent != null) {
            nearbyChatBubbleComponent.g();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.land.i
    public void update() {
        super.update();
        NearbyChatBubbleComponent nearbyChatBubbleComponent = this.bubbleComponent;
        if (nearbyChatBubbleComponent != null) {
            nearbyChatBubbleComponent.g();
        }
        NearbyChatBubbleComponent nearbyChatBubbleComponent2 = this.bubbleComponent;
        if (nearbyChatBubbleComponent2 != null) {
            nearbyChatBubbleComponent2.removeAllViews();
        }
        this.mainHandle.removeCallbacksAndMessages(null);
        this.curIndex = 0;
    }
}
